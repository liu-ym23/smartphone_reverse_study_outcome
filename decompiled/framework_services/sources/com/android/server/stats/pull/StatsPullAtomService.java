package com.android.server.stats.pull;

import android.app.ActivityManagerInternal;
import android.app.AppOpsManager;
import android.app.INotificationManager;
import android.app.PendingIntentStats;
import android.app.ProcessMemoryState;
import android.app.RuntimeAppOpAccessMessage;
import android.app.StatsManager;
import android.app.usage.NetworkStatsManager;
import android.bluetooth.BluetoothActivityEnergyInfo;
import android.bluetooth.BluetoothAdapter;
import android.bluetooth.UidTraffic;
import android.content.ContentResolver;
import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.IncrementalStatesInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManagerInternal;
import android.content.pm.PermissionInfo;
import android.content.pm.UserInfo;
import android.hardware.display.DisplayManager;
import android.hardware.face.FaceManager;
import android.hardware.fingerprint.FingerprintManager;
import android.hardware.health.BatteryHealthData;
import android.hardware.health.HealthInfo;
import android.health.connect.HealthConnectManager;
import android.icu.util.TimeZone;
import android.media.AudioManager;
import android.media.MediaDrm;
import android.media.UnsupportedSchemeException;
import android.net.ConnectivityManager;
import android.net.Network;
import android.net.NetworkRequest;
import android.net.NetworkStats;
import android.net.NetworkTemplate;
import android.net.wifi.WifiManager;
import android.os.AsyncTask;
import android.os.BatteryProperty;
import android.os.BatteryStatsManager;
import android.os.BatteryUsageStats;
import android.os.Binder;
import android.os.Build;
import android.os.Bundle;
import android.os.CoolingDevice;
import android.os.Debug;
import android.os.Environment;
import android.os.IStoraged;
import android.os.IThermalEventListener;
import android.os.IThermalService;
import android.os.ParcelFileDescriptor;
import android.os.Parcelable;
import android.os.Process;
import android.os.RemoteException;
import android.os.ServiceManager;
import android.os.ServiceSpecificException;
import android.os.StatFs;
import android.os.SynchronousResultReceiver;
import android.os.SystemClock;
import android.os.SystemProperties;
import android.os.Temperature;
import android.os.Trace;
import android.os.UserHandle;
import android.os.UserManager;
import android.os.connectivity.WifiActivityEnergyInfo;
import android.os.incremental.IncrementalManager;
import android.os.storage.DiskInfo;
import android.os.storage.StorageManager;
import android.os.storage.VolumeInfo;
import android.provider.DeviceConfig;
import android.provider.Settings;
import android.security.metrics.CrashStats;
import android.security.metrics.IKeystoreMetrics;
import android.security.metrics.KeyCreationWithAuthInfo;
import android.security.metrics.KeyCreationWithGeneralInfo;
import android.security.metrics.KeyCreationWithPurposeAndModesInfo;
import android.security.metrics.KeyOperationWithGeneralInfo;
import android.security.metrics.KeyOperationWithPurposeAndModesInfo;
import android.security.metrics.Keystore2AtomWithOverflow;
import android.security.metrics.KeystoreAtom;
import android.security.metrics.RkpErrorStats;
import android.security.metrics.StorageStats;
import android.telephony.ModemActivityInfo;
import android.telephony.SubscriptionInfo;
import android.telephony.SubscriptionManager;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import android.util.ArrayMap;
import android.util.ArraySet;
import android.util.Log;
import android.util.MathUtils;
import android.util.Pair;
import android.util.Slog;
import android.util.SparseArray;
import android.util.SparseIntArray;
import android.util.StatsEvent;
import android.util.proto.ProtoOutputStream;
import android.uwb.UwbActivityEnergyInfo;
import android.uwb.UwbManager;
import android.view.Display;
import com.android.internal.app.procstats.IProcessStats;
import com.android.internal.app.procstats.ProcessStats;
import com.android.internal.app.procstats.StatsEventOutput;
import com.android.internal.os.BackgroundThread;
import com.android.internal.os.BinderCallsStats;
import com.android.internal.os.KernelAllocationStats;
import com.android.internal.os.KernelCpuBpfTracking;
import com.android.internal.os.KernelCpuThreadReader;
import com.android.internal.os.KernelCpuThreadReaderDiff;
import com.android.internal.os.KernelCpuThreadReaderSettingsObserver;
import com.android.internal.os.KernelCpuTotalBpfMapReader;
import com.android.internal.os.KernelCpuUidTimeReader;
import com.android.internal.os.LooperStats;
import com.android.internal.os.PowerProfile;
import com.android.internal.os.ProcessCpuTracker;
import com.android.internal.os.ProcfsMemoryUtil;
import com.android.internal.os.SelectedProcessCpuThreadReader;
import com.android.internal.os.StoragedUidIoStatsReader;
import com.android.internal.util.CollectionUtils;
import com.android.internal.util.ConcurrentUtils;
import com.android.internal.util.FrameworkStatsLog;
import com.android.role.RoleManagerLocal;
import com.android.server.BinderCallsStatsService;
import com.android.server.LocalManagerRegistry;
import com.android.server.LocalServices;
import com.android.server.SystemServerInitThreadPool$$ExternalSyntheticLambda0;
import com.android.server.SystemService;
import com.android.server.SystemServiceManager;
import com.android.server.am.MemoryStatUtil;
import com.android.server.autofill.HintsHelper;
import com.android.server.backup.BackupAgentTimeoutParameters;
import com.android.server.health.HealthServiceWrapper;
import com.android.server.job.JobSchedulerShellCommand;
import com.android.server.pinner.PinnerService;
import com.android.server.pm.UserManagerInternal;
import com.android.server.power.stats.KernelWakelockReader;
import com.android.server.power.stats.KernelWakelockStats;
import com.android.server.slice.SliceClientPermissions;
import com.android.server.stats.pull.netstats.NetworkStatsAccumulator;
import com.android.server.stats.pull.netstats.NetworkStatsExt;
import com.android.server.stats.pull.netstats.NetworkStatsUtils;
import com.android.server.stats.pull.netstats.SubInfo;
import com.android.server.stats.pull.psi.PsiData;
import com.android.server.stats.pull.psi.PsiExtractor;
import com.android.server.storage.DeviceStorageMonitorServiceSmtEx;
import com.android.server.storage.DiskStatsFileLogger;
import com.android.server.storage.DiskStatsLoggingService;
import com.android.server.timezonedetector.MetricsTimeZoneDetectorState;
import com.android.server.timezonedetector.TimeZoneDetectorInternal;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.security.NoSuchAlgorithmException;
import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.MissingResourceException;
import java.util.Random;
import java.util.Set;
import java.util.UUID;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.function.Function;
import libcore.io.IoUtils;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public class StatsPullAtomService extends SystemService {
    private static final long APP_OPS_SAMPLING_INITIALIZATION_DELAY_MILLIS = 45000;
    private static final int APP_OPS_SIZE_ESTIMATE = 2000;
    private static final String APP_OPS_TARGET_COLLECTION_SIZE = "app_ops_target_collection_size";
    private static final String COMMON_PERMISSION_PREFIX = "android.permission.";
    private static final int CPU_CYCLES_PER_UID_CLUSTER_VALUES = 3;
    private static final int CPU_TIME_PER_THREAD_FREQ_MAX_NUM_FREQUENCIES = 8;
    private static final String DANGEROUS_PERMISSION_STATE_SAMPLE_RATE = "dangerous_permission_state_sample_rate";
    private static final boolean DEBUG = true;
    private static final int DIMENSION_KEY_SIZE_HARD_LIMIT = 800;
    private static final int DIMENSION_KEY_SIZE_SOFT_LIMIT = 500;
    public static final boolean ENABLE_MOBILE_DATA_STATS_AGGREGATED_PULLER = false;
    public static final boolean ENABLE_PRESSURE_STALL_INFORMATION_PULLER = false;
    private static final long EXTERNAL_STATS_SYNC_TIMEOUT_MILLIS = 2000;
    private static final int MAX_PROCSTATS_RAW_SHARD_SIZE = 58982;
    private static final int MAX_PROCSTATS_SHARDS = 5;
    private static final int MAX_PROCSTATS_SHARD_SIZE = 49152;
    private static final long MILLIS_PER_SEC = 1000;
    private static final long MILLI_AMP_HR_TO_NANO_AMP_SECS = 3600000000L;
    private static final int MIN_CPU_TIME_PER_UID_FREQ = 10;
    private static final long NETSTATS_POLL_RATE_LIMIT_MS = 15000;
    private static final long NETSTATS_UID_DEFAULT_BUCKET_DURATION_MS = 0;
    private static final int OP_FLAGS_PULLED = 9;
    private static final int RANDOM_SEED = 0;
    private static final String RESULT_RECEIVER_CONTROLLER_KEY = "controller_activity";
    private static final String TAG = "StatsPullAtomService";
    private AggregatedMobileDataStatsPuller mAggregatedMobileDataStatsPuller;
    private final Object mAppOpsLock;
    private int mAppOpsSamplingRate;
    private final Object mAppSizeLock;
    private final Object mAppsOnExternalStorageInfoLock;
    private final Object mAttributedAppOpsLock;
    private File mBaseDir;
    private final Object mBinderCallsStatsExceptionsLock;
    private final Object mBinderCallsStatsLock;
    private final Object mBluetoothActivityInfoLock;
    private final Object mBluetoothBytesTransferLock;
    private final Object mBuildInformationLock;
    private final Object mCategorySizeLock;
    private final Context mContext;
    private final Object mCooldownDeviceLock;
    private final Object mCpuActiveTimeLock;
    private final Object mCpuClusterTimeLock;
    private final Object mCpuTimePerClusterFreqLock;
    private final Object mCpuTimePerThreadFreqLock;
    private final Object mCpuTimePerUidFreqLock;
    private final Object mCpuTimePerUidLock;
    private KernelCpuUidTimeReader.KernelCpuUidActiveTimeReader mCpuUidActiveTimeReader;
    private KernelCpuUidTimeReader.KernelCpuUidClusterTimeReader mCpuUidClusterTimeReader;
    private KernelCpuUidTimeReader.KernelCpuUidFreqTimeReader mCpuUidFreqTimeReader;
    private KernelCpuUidTimeReader.KernelCpuUidUserSysTimeReader mCpuUidUserSysTimeReader;
    private final ArraySet<Integer> mDangerousAppOpsList;
    private final Object mDangerousAppOpsListLock;
    private final Object mDangerousPermissionStateLock;
    private final Object mDataBytesTransferLock;
    private final Object mDebugElapsedClockLock;
    private long mDebugElapsedClockPreviousValue;
    private long mDebugElapsedClockPullCount;
    private final Object mDebugFailingElapsedClockLock;
    private long mDebugFailingElapsedClockPreviousValue;
    private long mDebugFailingElapsedClockPullCount;
    private final Object mDeviceCalculatedPowerUseLock;
    private final Object mDirectoryUsageLock;
    private final Object mDiskIoLock;
    private final Object mDiskStatsLock;
    private final Object mExternalStorageInfoLock;
    private final Object mFaceSettingsLock;
    private final Object mHealthHalLock;
    private HealthServiceWrapper mHealthService;
    private final ArrayList<SubInfo> mHistoricalSubs;
    private IKeystoreMetrics mIKeystoreMetrics;
    private final Object mInstalledIncrementalPackagesLock;
    private final Object mIonHeapSizeLock;
    private KernelCpuThreadReaderDiff mKernelCpuThreadReader;
    private final Object mKernelWakelockLock;
    private KernelWakelockReader mKernelWakelockReader;
    private final Object mKeystoreLock;
    private long mLastNetworkStatsPollTime;
    private final Object mLooperStatsLock;
    private final Object mModemActivityInfoLock;
    private final ArrayList<NetworkStatsAccumulator> mNetworkStatsAccumulators;
    private final ArrayList<NetworkStatsExt> mNetworkStatsBaselines;
    private NetworkStatsManager mNetworkStatsManager;
    private INotificationManager mNotificationManagerService;
    private final Object mNotificationRemoteViewsLock;
    private final Object mNotificationStatsLock;
    private final Object mNumBiometricsEnrolledLock;
    private final Object mPowerProfileLock;
    private final Object mProcStatsLock;
    private final Object mProcessCpuTimeLock;
    private ProcessCpuTracker mProcessCpuTracker;
    private final Object mProcessMemoryHighWaterMarkLock;
    private final Object mProcessMemoryStateLock;
    private IProcessStats mProcessStatsService;
    private final Object mProcessSystemIonHeapSizeLock;
    private final Object mRoleHolderLock;
    private final Object mRuntimeAppOpAccessMessageLock;
    private final Object mSettingsStatsLock;
    private StatsPullAtomCallbackImpl mStatsCallbackImpl;
    private StatsManager mStatsManager;
    private StatsSubscriptionsListener mStatsSubscriptionsListener;
    private StorageManager mStorageManager;
    private IStoraged mStorageService;
    private final Object mStoragedLock;
    private StoragedUidIoStatsReader mStoragedUidIoStatsReader;
    private SubscriptionManager mSubscriptionManager;
    private SelectedProcessCpuThreadReader mSurfaceFlingerProcessCpuThreadReader;
    private final Object mSystemElapsedRealtimeLock;
    private final Object mSystemIonHeapSizeLock;
    private final Object mSystemUptimeLock;
    private TelephonyManager mTelephony;
    private final Object mTemperatureLock;
    private final Object mThermalLock;
    private IThermalService mThermalService;
    private final Object mTimeZoneDataInfoLock;
    private final Object mTimeZoneDetectionInfoLock;
    private KernelWakelockStats mTmpWakelockStats;
    private final Object mUwbActivityInfoLock;
    private UwbManager mUwbManager;
    private final Object mWifiActivityInfoLock;
    private WifiManager mWifiManager;

    private class AppOpEntry {
        public final String mAttributionTag;
        public final int mHash;
        public final AppOpsManager.HistoricalOp mOp;
        public final String mPackageName;
        public final int mUid;

        AppOpEntry(StatsPullAtomService r2, String packageName, String attributionTag, AppOpsManager.HistoricalOp op, int uid) {
            this.mPackageName = packageName;
            this.mAttributionTag = attributionTag;
            this.mUid = uid;
            this.mOp = op;
            this.mHash = ((packageName.hashCode() + StatsPullAtomService.m8368$$Nest$sfgetRANDOM_SEED()) & Integer.MAX_VALUE) % 100;
        }
    }

    private static final class ConnectivityStatsCallback extends ConnectivityManager.NetworkCallback {
        /* synthetic */ ConnectivityStatsCallback(StatsPullAtomServiceIA r1) {
            this();
        }

        private ConnectivityStatsCallback() {
        }

        @Override // android.net.ConnectivityManager.NetworkCallback
        public void onAvailable(Network network) {
            FrameworkStatsLog.write(98, network.getNetId(), 1);
        }

        @Override // android.net.ConnectivityManager.NetworkCallback
        public void onLost(Network network) {
            FrameworkStatsLog.write(98, network.getNetId(), 2);
        }
    }

    private class StatsPullAtomCallbackImpl implements StatsManager.StatsPullAtomCallback {
        final /* synthetic */ StatsPullAtomService this$0;

        /* synthetic */ StatsPullAtomCallbackImpl(StatsPullAtomService r1, StatsPullAtomServiceIA r2) {
            this(r1);
        }

        private StatsPullAtomCallbackImpl(StatsPullAtomService r1) {
            this.this$0 = r1;
        }

        public int onPullAtom(int atomTag, List<StatsEvent> data) {
            if (Trace.isTagEnabled(524288) == false) goto L594;
            Trace.traceBegin(524288, "StatsPull-" + atomTag);
        L594:
            switch(atomTag) {
                case 10000: goto L563;
                case 10001: goto L563;
                case 10002: goto L563;
                case 10003: goto L563;
                case 10004: goto L554;
                case 10006: goto L545;
                case 10007: goto L536;
                case 10009: goto L527;
                case 10010: goto L518;
                case 10011: goto L509;
                case 10012: goto L500;
                case 10013: goto L491;
                case 10014: goto L482;
                case 10015: goto L473;
                case 10016: goto L464;
                case 10017: goto L455;
                case 10019: goto L446;
                case 10020: goto L446;
                case 10021: goto L437;
                case 10022: goto L428;
                case 10023: goto L419;
                case 10024: goto L410;
                case 10025: goto L401;
                case 10026: goto L392;
                case 10027: goto L383;
                case 10028: goto L374;
                case 10029: goto L365;
                case 10030: goto L446;
                case 10031: goto L356;
                case 10032: goto L347;
                case 10033: goto L338;
                case 10034: goto L329;
                case 10035: goto L320;
                case 10037: goto L311;
                case 10039: goto L302;
                case 10042: goto L293;
                case 10043: goto L446;
                case 10044: goto L284;
                case 10045: goto L446;
                case 10046: goto L275;
                case 10047: goto L266;
                case 10048: goto L257;
                case 10049: goto L248;
                case 10050: goto L239;
                case 10052: goto L230;
                case 10053: goto L221;
                case 10056: goto L212;
                case 10057: goto L203;
                case 10058: goto L194;
                case 10059: goto L185;
                case 10060: goto L176;
                case 10061: goto L167;
                case 10064: goto L164;
                case 10066: goto L155;
                case 10067: goto L239;
                case 10069: goto L146;
                case 10070: goto L137;
                case 10075: goto L128;
                case 10080: goto L119;
                case 10082: goto L563;
                case 10083: goto L563;
                case 10092: goto L116;
                case 10095: goto L107;
                case 10096: goto L98;
                case 10098: goto L95;
                case 10100: goto L563;
                case 10102: goto L86;
                case 10103: goto L83;
                case 10105: goto L80;
                case 10114: goto L71;
                case 10117: goto L68;
                case 10118: goto L83;
                case 10119: goto L83;
                case 10120: goto L83;
                case 10121: goto L83;
                case 10122: goto L83;
                case 10123: goto L83;
                case 10124: goto L83;
                case 10125: goto L83;
                case 10127: goto L65;
                case 10128: goto L62;
                case 10130: goto L59;
                case 10150: goto L56;
                case 10151: goto L53;
                case 10171: goto L44;
                case 10172: goto L35;
                case 10175: goto L32;
                case 10188: goto L23;
                case 10189: goto L20;
                case 10200: goto L563;
                case 10204: goto L14;
                case 10220: goto L446;
                case 10229: goto L10;
                default: goto L7;
            };
        L10:
            int r2 = this.this$0.pullPressureStallInformation(atomTag, data);     // Catch: Throwable -> L8
            Trace.traceEnd(524288);
            return r2;
        L20:
            int r3 = StatsPullAtomService.m8359$$Nest$mpullCachedAppsHighWatermark(this.this$0, atomTag, data);     // Catch: Throwable -> L8
            Trace.traceEnd(524288);
            return r3;
        L23:
            Object r4 = StatsPullAtomService.m8354$$Nest$fgetmUwbActivityInfoLock(this.this$0);     // Catch: Throwable -> L8
            monitor-enter(r4);     // Catch: Throwable -> L8
            int r5 = this.this$0.pullUwbActivityInfoLocked(atomTag, data);     // Catch: Throwable -> L29
            monitor-exit(r4);     // Catch: Throwable -> L29
            Trace.traceEnd(524288);
            return r5;
        L29:
            th = move-exception;
            throw th;     // Catch: Throwable -> L8
        L32:
            int r6 = StatsPullAtomService.m8361$$Nest$mpullHdrCapabilities(this.this$0, atomTag, data);     // Catch: Throwable -> L8
            Trace.traceEnd(524288);
            return r6;
        L35:
            Object r7 = StatsPullAtomService.m8339$$Nest$fgetmProcStatsLock(this.this$0);     // Catch: Throwable -> L8
            monitor-enter(r7);     // Catch: Throwable -> L8
            int r8 = StatsPullAtomService.m8366$$Nest$mpullProcessAssociationLocked(this.this$0, atomTag, data);     // Catch: Throwable -> L41
            monitor-exit(r7);     // Catch: Throwable -> L41
            Trace.traceEnd(524288);
            return r8;
        L41:
            th = move-exception;
            throw th;     // Catch: Throwable -> L8
        L44:
            Object r9 = StatsPullAtomService.m8339$$Nest$fgetmProcStatsLock(this.this$0);     // Catch: Throwable -> L8
            monitor-enter(r9);     // Catch: Throwable -> L8
            int r10 = StatsPullAtomService.m8367$$Nest$mpullProcessStateLocked(this.this$0, atomTag, data);     // Catch: Throwable -> L50
            monitor-exit(r9);     // Catch: Throwable -> L50
            Trace.traceEnd(524288);
            return r10;
        L50:
            th = move-exception;
            throw th;     // Catch: Throwable -> L8
        L53:
            int r11 = StatsPullAtomService.m8364$$Nest$mpullPendingIntentsPerPackage(this.this$0, atomTag, data);     // Catch: Throwable -> L8
            Trace.traceEnd(524288);
            return r11;
        L56:
            int r12 = this.this$0.pullSystemServerPinnerStats(atomTag, data);     // Catch: Throwable -> L8
            Trace.traceEnd(524288);
            return r12;
        L59:
            int r13 = this.this$0.pullMediaCapabilitiesStats(atomTag, data);     // Catch: Throwable -> L8
            Trace.traceEnd(524288);
            return r13;
        L62:
            int r14 = this.this$0.pullAccessibilityFloatingMenuStatsLocked(atomTag, data);     // Catch: Throwable -> L8
            Trace.traceEnd(524288);
            return r14;
        L65:
            int r15 = this.this$0.pullAccessibilityShortcutStatsLocked(data);     // Catch: Throwable -> L8
            Trace.traceEnd(524288);
            return r15;
        L68:
            int r16 = this.this$0.pullVmStat(atomTag, data);     // Catch: Throwable -> L8
            Trace.traceEnd(524288);
            return r16;
        L71:
            Object r17 = StatsPullAtomService.m8330$$Nest$fgetmInstalledIncrementalPackagesLock(this.this$0);     // Catch: Throwable -> L8
            monitor-enter(r17);     // Catch: Throwable -> L8
            int r18 = this.this$0.pullInstalledIncrementalPackagesLocked(atomTag, data);     // Catch: Throwable -> L77
            monitor-exit(r17);     // Catch: Throwable -> L77
            Trace.traceEnd(524288);
            return r18;
        L77:
            th = move-exception;
            throw th;     // Catch: Throwable -> L8
        L80:
            int r19 = this.this$0.pullProcessDmabufMemory(atomTag, data);     // Catch: Throwable -> L8
            Trace.traceEnd(524288);
            return r19;
        L83:
            int r20 = this.this$0.pullKeystoreAtoms(atomTag, data);     // Catch: Throwable -> L8
            Trace.traceEnd(524288);
            return r20;
        L86:
            Object r21 = StatsPullAtomService.m8353$$Nest$fgetmTimeZoneDetectionInfoLock(this.this$0);     // Catch: Throwable -> L8
            monitor-enter(r21);     // Catch: Throwable -> L8
            int r22 = this.this$0.pullTimeZoneDetectorStateLocked(atomTag, data);     // Catch: Throwable -> L92
            monitor-exit(r21);     // Catch: Throwable -> L92
            Trace.traceEnd(524288);
            return r22;
        L92:
            th = move-exception;
            throw th;     // Catch: Throwable -> L8
        L95:
            int r23 = this.this$0.pullCpuCyclesPerThreadGroupCluster(atomTag, data);     // Catch: Throwable -> L8
            Trace.traceEnd(524288);
            return r23;
        L98:
            Object r24 = StatsPullAtomService.m8316$$Nest$fgetmCpuTimePerUidFreqLock(this.this$0);     // Catch: Throwable -> L8
            monitor-enter(r24);     // Catch: Throwable -> L8
            int r25 = this.this$0.pullCpuCyclesPerUidClusterLocked(atomTag, data);     // Catch: Throwable -> L104
            monitor-exit(r24);     // Catch: Throwable -> L104
            Trace.traceEnd(524288);
            return r25;
        L104:
            th = move-exception;
            throw th;     // Catch: Throwable -> L8
        L107:
            Object r26 = StatsPullAtomService.m8314$$Nest$fgetmCpuTimePerClusterFreqLock(this.this$0);     // Catch: Throwable -> L8
            monitor-enter(r26);     // Catch: Throwable -> L8
            int r27 = this.this$0.pullCpuTimePerClusterFreqLocked(atomTag, data);     // Catch: Throwable -> L113
            monitor-exit(r26);     // Catch: Throwable -> L113
            Trace.traceEnd(524288);
            return r27;
        L113:
            th = move-exception;
            throw th;     // Catch: Throwable -> L8
        L116:
            int r28 = this.this$0.pullSystemMemory(atomTag, data);     // Catch: Throwable -> L8
            Trace.traceEnd(524288);
            return r28;
        L119:
            Object r29 = StatsPullAtomService.m8346$$Nest$fgetmSettingsStatsLock(this.this$0);     // Catch: Throwable -> L8
            monitor-enter(r29);     // Catch: Throwable -> L8
            int r30 = this.this$0.pullSettingsStatsLocked(atomTag, data);     // Catch: Throwable -> L125
            monitor-exit(r29);     // Catch: Throwable -> L125
            Trace.traceEnd(524288);
            return r30;
        L125:
            th = move-exception;
            throw th;     // Catch: Throwable -> L8
        L128:
            Object r31 = StatsPullAtomService.m8304$$Nest$fgetmAttributedAppOpsLock(this.this$0);     // Catch: Throwable -> L8
            monitor-enter(r31);     // Catch: Throwable -> L8
            int r32 = this.this$0.pullAttributedAppOpsLocked(atomTag, data);     // Catch: Throwable -> L134
            monitor-exit(r31);     // Catch: Throwable -> L134
            Trace.traceEnd(524288);
            return r32;
        L134:
            th = move-exception;
            throw th;     // Catch: Throwable -> L8
        L137:
            Object r33 = StatsPullAtomService.m8331$$Nest$fgetmIonHeapSizeLock(this.this$0);     // Catch: Throwable -> L8
            monitor-enter(r33);     // Catch: Throwable -> L8
            int r34 = this.this$0.pullIonHeapSizeLocked(atomTag, data);     // Catch: Throwable -> L143
            monitor-exit(r33);     // Catch: Throwable -> L143
            Trace.traceEnd(524288);
            return r34;
        L143:
            th = move-exception;
            throw th;     // Catch: Throwable -> L8
        L146:
            Object r35 = StatsPullAtomService.m8345$$Nest$fgetmRuntimeAppOpAccessMessageLock(this.this$0);     // Catch: Throwable -> L8
            monitor-enter(r35);     // Catch: Throwable -> L8
            int r36 = this.this$0.pullRuntimeAppOpAccessMessageLocked(atomTag, data);     // Catch: Throwable -> L152
            monitor-exit(r35);     // Catch: Throwable -> L152
            Trace.traceEnd(524288);
            return r36;
        L152:
            th = move-exception;
            throw th;     // Catch: Throwable -> L8
        L155:
            Object r37 = StatsPullAtomService.m8336$$Nest$fgetmNotificationRemoteViewsLock(this.this$0);     // Catch: Throwable -> L8
            monitor-enter(r37);     // Catch: Throwable -> L8
            int r38 = this.this$0.pullNotificationRemoteViewsLocked(atomTag, data);     // Catch: Throwable -> L161
            monitor-exit(r37);     // Catch: Throwable -> L161
            Trace.traceEnd(524288);
            return r38;
        L161:
            th = move-exception;
            throw th;     // Catch: Throwable -> L8
        L164:
            int r39 = this.this$0.pullProcessMemorySnapshot(atomTag, data);     // Catch: Throwable -> L8
            Trace.traceEnd(524288);
            return r39;
        L167:
            Object r40 = StatsPullAtomService.m8343$$Nest$fgetmProcessSystemIonHeapSizeLock(this.this$0);     // Catch: Throwable -> L8
            monitor-enter(r40);     // Catch: Throwable -> L8
            int r41 = this.this$0.pullProcessSystemIonHeapSizeLocked(atomTag, data);     // Catch: Throwable -> L173
            monitor-exit(r40);     // Catch: Throwable -> L173
            Trace.traceEnd(524288);
            return r41;
        L173:
            th = move-exception;
            throw th;     // Catch: Throwable -> L8
        L176:
            Object r42 = StatsPullAtomService.m8300$$Nest$fgetmAppOpsLock(this.this$0);     // Catch: Throwable -> L8
            monitor-enter(r42);     // Catch: Throwable -> L8
            int r43 = this.this$0.pullAppOpsLocked(atomTag, data);     // Catch: Throwable -> L182
            monitor-exit(r42);     // Catch: Throwable -> L182
            Trace.traceEnd(524288);
            return r43;
        L182:
            th = move-exception;
            throw th;     // Catch: Throwable -> L8
        L185:
            Object r44 = StatsPullAtomService.m8311$$Nest$fgetmCooldownDeviceLock(this.this$0);     // Catch: Throwable -> L8
            monitor-enter(r44);     // Catch: Throwable -> L8
            int r45 = this.this$0.pullCooldownDeviceLocked(atomTag, data);     // Catch: Throwable -> L191
            monitor-exit(r44);     // Catch: Throwable -> L191
            Trace.traceEnd(524288);
            return r45;
        L191:
            th = move-exception;
            throw th;     // Catch: Throwable -> L8
        L194:
            Object r46 = StatsPullAtomService.m8327$$Nest$fgetmFaceSettingsLock(this.this$0);     // Catch: Throwable -> L8
            monitor-enter(r46);     // Catch: Throwable -> L8
            int r47 = this.this$0.pullFaceSettingsLocked(atomTag, data);     // Catch: Throwable -> L200
            monitor-exit(r46);     // Catch: Throwable -> L200
            Trace.traceEnd(524288);
            return r47;
        L200:
            th = move-exception;
            throw th;     // Catch: Throwable -> L8
        L203:
            Object r48 = StatsPullAtomService.m8303$$Nest$fgetmAppsOnExternalStorageInfoLock(this.this$0);     // Catch: Throwable -> L8
            monitor-enter(r48);     // Catch: Throwable -> L8
            int r49 = this.this$0.pullAppsOnExternalStorageInfoLocked(atomTag, data);     // Catch: Throwable -> L209
            monitor-exit(r48);     // Catch: Throwable -> L209
            Trace.traceEnd(524288);
            return r49;
        L209:
            th = move-exception;
            throw th;     // Catch: Throwable -> L8
        L212:
            Object r50 = StatsPullAtomService.m8348$$Nest$fgetmSystemIonHeapSizeLock(this.this$0);     // Catch: Throwable -> L8
            monitor-enter(r50);     // Catch: Throwable -> L8
            int r51 = this.this$0.pullSystemIonHeapSizeLocked(atomTag, data);     // Catch: Throwable -> L218
            monitor-exit(r50);     // Catch: Throwable -> L218
            Trace.traceEnd(524288);
            return r51;
        L218:
            th = move-exception;
            throw th;     // Catch: Throwable -> L8
        L221:
            Object r52 = StatsPullAtomService.m8326$$Nest$fgetmExternalStorageInfoLock(this.this$0);     // Catch: Throwable -> L8
            monitor-enter(r52);     // Catch: Throwable -> L8
            int r53 = this.this$0.pullExternalStorageInfoLocked(atomTag, data);     // Catch: Throwable -> L227
            monitor-exit(r52);     // Catch: Throwable -> L227
            Trace.traceEnd(524288);
            return r53;
        L227:
            th = move-exception;
            throw th;     // Catch: Throwable -> L8
        L230:
            Object r54 = StatsPullAtomService.m8352$$Nest$fgetmTimeZoneDataInfoLock(this.this$0);     // Catch: Throwable -> L8
            monitor-enter(r54);     // Catch: Throwable -> L8
            int r55 = this.this$0.pullTimeZoneDataInfoLocked(atomTag, data);     // Catch: Throwable -> L236
            monitor-exit(r54);     // Catch: Throwable -> L236
            Trace.traceEnd(524288);
            return r55;
        L236:
            th = move-exception;
            throw th;     // Catch: Throwable -> L8
        L239:
            Object r56 = StatsPullAtomService.m8318$$Nest$fgetmDangerousPermissionStateLock(this.this$0);     // Catch: Throwable -> L8
            monitor-enter(r56);     // Catch: Throwable -> L8
            int r57 = this.this$0.pullDangerousPermissionStateLocked(atomTag, data);     // Catch: Throwable -> L245
            monitor-exit(r56);     // Catch: Throwable -> L245
            Trace.traceEnd(524288);
            return r57;
        L245:
            th = move-exception;
            throw th;     // Catch: Throwable -> L8
        L248:
            Object r58 = StatsPullAtomService.m8344$$Nest$fgetmRoleHolderLock(this.this$0);     // Catch: Throwable -> L8
            monitor-enter(r58);     // Catch: Throwable -> L8
            int r59 = this.this$0.pullRoleHolderLocked(atomTag, data);     // Catch: Throwable -> L254
            monitor-exit(r58);     // Catch: Throwable -> L254
            Trace.traceEnd(524288);
            return r59;
        L254:
            th = move-exception;
            throw th;     // Catch: Throwable -> L8
        L257:
            Object r60 = StatsPullAtomService.m8337$$Nest$fgetmNumBiometricsEnrolledLock(this.this$0);     // Catch: Throwable -> L8
            monitor-enter(r60);     // Catch: Throwable -> L8
            int r61 = StatsPullAtomService.m8363$$Nest$mpullNumBiometricsEnrolledLocked(this.this$0, 4, atomTag, data);     // Catch: Throwable -> L263
            monitor-exit(r60);     // Catch: Throwable -> L263
            Trace.traceEnd(524288);
            return r61;
        L263:
            th = move-exception;
            throw th;     // Catch: Throwable -> L8
        L266:
            Object r62 = StatsPullAtomService.m8321$$Nest$fgetmDebugFailingElapsedClockLock(this.this$0);     // Catch: Throwable -> L8
            monitor-enter(r62);     // Catch: Throwable -> L8
            int r63 = this.this$0.pullDebugFailingElapsedClockLocked(atomTag, data);     // Catch: Throwable -> L272
            monitor-exit(r62);     // Catch: Throwable -> L272
            Trace.traceEnd(524288);
            return r63;
        L272:
            th = move-exception;
            throw th;     // Catch: Throwable -> L8
        L275:
            Object r64 = StatsPullAtomService.m8320$$Nest$fgetmDebugElapsedClockLock(this.this$0);     // Catch: Throwable -> L8
            monitor-enter(r64);     // Catch: Throwable -> L8
            int r65 = this.this$0.pullDebugElapsedClockLocked(atomTag, data);     // Catch: Throwable -> L281
            monitor-exit(r64);     // Catch: Throwable -> L281
            Trace.traceEnd(524288);
            return r65;
        L281:
            th = move-exception;
            throw th;     // Catch: Throwable -> L8
        L284:
            Object r66 = StatsPullAtomService.m8309$$Nest$fgetmBuildInformationLock(this.this$0);     // Catch: Throwable -> L8
            monitor-enter(r66);     // Catch: Throwable -> L8
            int r67 = this.this$0.pullBuildInformationLocked(atomTag, data);     // Catch: Throwable -> L290
            monitor-exit(r66);     // Catch: Throwable -> L290
            Trace.traceEnd(524288);
            return r67;
        L290:
            th = move-exception;
            throw th;     // Catch: Throwable -> L8
        L293:
            Object r68 = StatsPullAtomService.m8341$$Nest$fgetmProcessMemoryHighWaterMarkLock(this.this$0);     // Catch: Throwable -> L8
            monitor-enter(r68);     // Catch: Throwable -> L8
            int r69 = this.this$0.pullProcessMemoryHighWaterMarkLocked(atomTag, data);     // Catch: Throwable -> L299
            monitor-exit(r68);     // Catch: Throwable -> L299
            Trace.traceEnd(524288);
            return r69;
        L299:
            th = move-exception;
            throw th;     // Catch: Throwable -> L8
        L302:
            Object r70 = StatsPullAtomService.m8322$$Nest$fgetmDeviceCalculatedPowerUseLock(this.this$0);     // Catch: Throwable -> L8
            monitor-enter(r70);     // Catch: Throwable -> L8
            int r71 = this.this$0.pullDeviceCalculatedPowerUseLocked(atomTag, data);     // Catch: Throwable -> L308
            monitor-exit(r70);     // Catch: Throwable -> L308
            Trace.traceEnd(524288);
            return r71;
        L308:
            th = move-exception;
            throw th;     // Catch: Throwable -> L8
        L311:
            Object r72 = StatsPullAtomService.m8315$$Nest$fgetmCpuTimePerThreadFreqLock(this.this$0);     // Catch: Throwable -> L8
            monitor-enter(r72);     // Catch: Throwable -> L8
            int r73 = this.this$0.pullCpuTimePerThreadFreqLocked(atomTag, data);     // Catch: Throwable -> L317
            monitor-exit(r72);     // Catch: Throwable -> L317
            Trace.traceEnd(524288);
            return r73;
        L317:
            th = move-exception;
            throw th;     // Catch: Throwable -> L8
        L320:
            Object r74 = StatsPullAtomService.m8340$$Nest$fgetmProcessCpuTimeLock(this.this$0);     // Catch: Throwable -> L8
            monitor-enter(r74);     // Catch: Throwable -> L8
            int r75 = this.this$0.pullProcessCpuTimeLocked(atomTag, data);     // Catch: Throwable -> L326
            monitor-exit(r74);     // Catch: Throwable -> L326
            Trace.traceEnd(524288);
            return r75;
        L326:
            th = move-exception;
            throw th;     // Catch: Throwable -> L8
        L329:
            Object r76 = StatsPullAtomService.m8339$$Nest$fgetmProcStatsLock(this.this$0);     // Catch: Throwable -> L8
            monitor-enter(r76);     // Catch: Throwable -> L8
            int r77 = StatsPullAtomService.m8365$$Nest$mpullProcStatsLocked(this.this$0, atomTag, data);     // Catch: Throwable -> L335
            monitor-exit(r76);     // Catch: Throwable -> L335
            Trace.traceEnd(524288);
            return r77;
        L335:
            th = move-exception;
            throw th;     // Catch: Throwable -> L8
        L338:
            Object r78 = StatsPullAtomService.m8338$$Nest$fgetmPowerProfileLock(this.this$0);     // Catch: Throwable -> L8
            monitor-enter(r78);     // Catch: Throwable -> L8
            int r79 = this.this$0.pullPowerProfileLocked(atomTag, data);     // Catch: Throwable -> L344
            monitor-exit(r78);     // Catch: Throwable -> L344
            Trace.traceEnd(524288);
            return r79;
        L344:
            th = move-exception;
            throw th;     // Catch: Throwable -> L8
        L347:
            Object r80 = StatsPullAtomService.m8324$$Nest$fgetmDiskIoLock(this.this$0);     // Catch: Throwable -> L8
            monitor-enter(r80);     // Catch: Throwable -> L8
            int r81 = this.this$0.pullDiskIOLocked(atomTag, data);     // Catch: Throwable -> L353
            monitor-exit(r80);     // Catch: Throwable -> L353
            Trace.traceEnd(524288);
            return r81;
        L353:
            th = move-exception;
            throw th;     // Catch: Throwable -> L8
        L356:
            Object r82 = StatsPullAtomService.m8337$$Nest$fgetmNumBiometricsEnrolledLock(this.this$0);     // Catch: Throwable -> L8
            monitor-enter(r82);     // Catch: Throwable -> L8
            int r83 = StatsPullAtomService.m8363$$Nest$mpullNumBiometricsEnrolledLocked(this.this$0, 1, atomTag, data);     // Catch: Throwable -> L362
            monitor-exit(r82);     // Catch: Throwable -> L362
            Trace.traceEnd(524288);
            return r83;
        L362:
            th = move-exception;
            throw th;     // Catch: Throwable -> L8
        L365:
            Object r84 = StatsPullAtomService.m8339$$Nest$fgetmProcStatsLock(this.this$0);     // Catch: Throwable -> L8
            monitor-enter(r84);     // Catch: Throwable -> L8
            int r85 = StatsPullAtomService.m8365$$Nest$mpullProcStatsLocked(this.this$0, atomTag, data);     // Catch: Throwable -> L371
            monitor-exit(r84);     // Catch: Throwable -> L371
            Trace.traceEnd(524288);
            return r85;
        L371:
            th = move-exception;
            throw th;     // Catch: Throwable -> L8
        L374:
            Object r86 = StatsPullAtomService.m8310$$Nest$fgetmCategorySizeLock(this.this$0);     // Catch: Throwable -> L8
            monitor-enter(r86);     // Catch: Throwable -> L8
            int r87 = this.this$0.pullCategorySizeLocked(atomTag, data);     // Catch: Throwable -> L380
            monitor-exit(r86);     // Catch: Throwable -> L380
            Trace.traceEnd(524288);
            return r87;
        L380:
            th = move-exception;
            throw th;     // Catch: Throwable -> L8
        L383:
            Object r88 = StatsPullAtomService.m8302$$Nest$fgetmAppSizeLock(this.this$0);     // Catch: Throwable -> L8
            monitor-enter(r88);     // Catch: Throwable -> L8
            int r89 = this.this$0.pullAppSizeLocked(atomTag, data);     // Catch: Throwable -> L389
            monitor-exit(r88);     // Catch: Throwable -> L389
            Trace.traceEnd(524288);
            return r89;
        L389:
            th = move-exception;
            throw th;     // Catch: Throwable -> L8
        L392:
            Object r90 = StatsPullAtomService.m8323$$Nest$fgetmDirectoryUsageLock(this.this$0);     // Catch: Throwable -> L8
            monitor-enter(r90);     // Catch: Throwable -> L8
            int r91 = this.this$0.pullDirectoryUsageLocked(atomTag, data);     // Catch: Throwable -> L398
            monitor-exit(r90);     // Catch: Throwable -> L398
            Trace.traceEnd(524288);
            return r91;
        L398:
            th = move-exception;
            throw th;     // Catch: Throwable -> L8
        L401:
            Object r92 = StatsPullAtomService.m8325$$Nest$fgetmDiskStatsLock(this.this$0);     // Catch: Throwable -> L8
            monitor-enter(r92);     // Catch: Throwable -> L8
            int r93 = this.this$0.pullDiskStatsLocked(atomTag, data);     // Catch: Throwable -> L407
            monitor-exit(r92);     // Catch: Throwable -> L407
            Trace.traceEnd(524288);
            return r93;
        L407:
            th = move-exception;
            throw th;     // Catch: Throwable -> L8
        L410:
            Object r94 = StatsPullAtomService.m8333$$Nest$fgetmLooperStatsLock(this.this$0);     // Catch: Throwable -> L8
            monitor-enter(r94);     // Catch: Throwable -> L8
            int r95 = this.this$0.pullLooperStatsLocked(atomTag, data);     // Catch: Throwable -> L416
            monitor-exit(r94);     // Catch: Throwable -> L416
            Trace.traceEnd(524288);
            return r95;
        L416:
            th = move-exception;
            throw th;     // Catch: Throwable -> L8
        L419:
            Object r96 = StatsPullAtomService.m8305$$Nest$fgetmBinderCallsStatsExceptionsLock(this.this$0);     // Catch: Throwable -> L8
            monitor-enter(r96);     // Catch: Throwable -> L8
            int r97 = this.this$0.pullBinderCallsStatsExceptionsLocked(atomTag, data);     // Catch: Throwable -> L425
            monitor-exit(r96);     // Catch: Throwable -> L425
            Trace.traceEnd(524288);
            return r97;
        L425:
            th = move-exception;
            throw th;     // Catch: Throwable -> L8
        L428:
            Object r98 = StatsPullAtomService.m8306$$Nest$fgetmBinderCallsStatsLock(this.this$0);     // Catch: Throwable -> L8
            monitor-enter(r98);     // Catch: Throwable -> L8
            int r99 = this.this$0.pullBinderCallsStatsLocked(atomTag, data);     // Catch: Throwable -> L434
            monitor-exit(r98);     // Catch: Throwable -> L434
            Trace.traceEnd(524288);
            return r99;
        L434:
            th = move-exception;
            throw th;     // Catch: Throwable -> L8
        L437:
            Object r100 = StatsPullAtomService.m8351$$Nest$fgetmTemperatureLock(this.this$0);     // Catch: Throwable -> L8
            monitor-enter(r100);     // Catch: Throwable -> L8
            int r101 = this.this$0.pullTemperatureLocked(atomTag, data);     // Catch: Throwable -> L443
            monitor-exit(r100);     // Catch: Throwable -> L443
            Trace.traceEnd(524288);
            return r101;
        L443:
            th = move-exception;
            throw th;     // Catch: Throwable -> L8
        L446:
            Object r102 = StatsPullAtomService.m8328$$Nest$fgetmHealthHalLock(this.this$0);     // Catch: Throwable -> L8
            monitor-enter(r102);     // Catch: Throwable -> L8
            int r103 = StatsPullAtomService.m8362$$Nest$mpullHealthHalLocked(this.this$0, atomTag, data);     // Catch: Throwable -> L452
            monitor-exit(r102);     // Catch: Throwable -> L452
            Trace.traceEnd(524288);
            return r103;
        L452:
            th = move-exception;
            throw th;     // Catch: Throwable -> L8
        L455:
            Object r104 = StatsPullAtomService.m8313$$Nest$fgetmCpuClusterTimeLock(this.this$0);     // Catch: Throwable -> L8
            monitor-enter(r104);     // Catch: Throwable -> L8
            int r105 = this.this$0.pullCpuClusterTimeLocked(atomTag, data);     // Catch: Throwable -> L461
            monitor-exit(r104);     // Catch: Throwable -> L461
            Trace.traceEnd(524288);
            return r105;
        L461:
            th = move-exception;
            throw th;     // Catch: Throwable -> L8
        L464:
            Object r106 = StatsPullAtomService.m8312$$Nest$fgetmCpuActiveTimeLock(this.this$0);     // Catch: Throwable -> L8
            monitor-enter(r106);     // Catch: Throwable -> L8
            int r107 = this.this$0.pullCpuActiveTimeLocked(atomTag, data);     // Catch: Throwable -> L470
            monitor-exit(r106);     // Catch: Throwable -> L470
            Trace.traceEnd(524288);
            return r107;
        L470:
            th = move-exception;
            throw th;     // Catch: Throwable -> L8
        L473:
            Object r108 = StatsPullAtomService.m8349$$Nest$fgetmSystemUptimeLock(this.this$0);     // Catch: Throwable -> L8
            monitor-enter(r108);     // Catch: Throwable -> L8
            int r109 = this.this$0.pullSystemUptimeLocked(atomTag, data);     // Catch: Throwable -> L479
            monitor-exit(r108);     // Catch: Throwable -> L479
            Trace.traceEnd(524288);
            return r109;
        L479:
            th = move-exception;
            throw th;     // Catch: Throwable -> L8
        L482:
            Object r110 = StatsPullAtomService.m8347$$Nest$fgetmSystemElapsedRealtimeLock(this.this$0);     // Catch: Throwable -> L8
            monitor-enter(r110);     // Catch: Throwable -> L8
            int r111 = this.this$0.pullSystemElapsedRealtimeLocked(atomTag, data);     // Catch: Throwable -> L488
            monitor-exit(r110);     // Catch: Throwable -> L488
            Trace.traceEnd(524288);
            return r111;
        L488:
            th = move-exception;
            throw th;     // Catch: Throwable -> L8
        L491:
            Object r112 = StatsPullAtomService.m8342$$Nest$fgetmProcessMemoryStateLock(this.this$0);     // Catch: Throwable -> L8
            monitor-enter(r112);     // Catch: Throwable -> L8
            int r113 = this.this$0.pullProcessMemoryStateLocked(atomTag, data);     // Catch: Throwable -> L497
            monitor-exit(r112);     // Catch: Throwable -> L497
            Trace.traceEnd(524288);
            return r113;
        L497:
            th = move-exception;
            throw th;     // Catch: Throwable -> L8
        L500:
            Object r114 = StatsPullAtomService.m8334$$Nest$fgetmModemActivityInfoLock(this.this$0);     // Catch: Throwable -> L8
            monitor-enter(r114);     // Catch: Throwable -> L8
            int r115 = this.this$0.pullModemActivityInfoLocked(atomTag, data);     // Catch: Throwable -> L506
            monitor-exit(r114);     // Catch: Throwable -> L506
            Trace.traceEnd(524288);
            return r115;
        L506:
            th = move-exception;
            throw th;     // Catch: Throwable -> L8
        L509:
            Object r116 = StatsPullAtomService.m8355$$Nest$fgetmWifiActivityInfoLock(this.this$0);     // Catch: Throwable -> L8
            monitor-enter(r116);     // Catch: Throwable -> L8
            int r117 = this.this$0.pullWifiActivityInfoLocked(atomTag, data);     // Catch: Throwable -> L515
            monitor-exit(r116);     // Catch: Throwable -> L515
            Trace.traceEnd(524288);
            return r117;
        L515:
            th = move-exception;
            throw th;     // Catch: Throwable -> L8
        L518:
            Object r118 = StatsPullAtomService.m8316$$Nest$fgetmCpuTimePerUidFreqLock(this.this$0);     // Catch: Throwable -> L8
            monitor-enter(r118);     // Catch: Throwable -> L8
            int r119 = this.this$0.pullCpuTimePerUidFreqLocked(atomTag, data);     // Catch: Throwable -> L524
            monitor-exit(r118);     // Catch: Throwable -> L524
            Trace.traceEnd(524288);
            return r119;
        L524:
            th = move-exception;
            throw th;     // Catch: Throwable -> L8
        L527:
            Object r120 = StatsPullAtomService.m8317$$Nest$fgetmCpuTimePerUidLock(this.this$0);     // Catch: Throwable -> L8
            monitor-enter(r120);     // Catch: Throwable -> L8
            int r121 = this.this$0.pullCpuTimePerUidLocked(atomTag, data);     // Catch: Throwable -> L533
            monitor-exit(r120);     // Catch: Throwable -> L533
            Trace.traceEnd(524288);
            return r121;
        L533:
            th = move-exception;
            throw th;     // Catch: Throwable -> L8
        L536:
            Object r122 = StatsPullAtomService.m8307$$Nest$fgetmBluetoothActivityInfoLock(this.this$0);     // Catch: Throwable -> L8
            monitor-enter(r122);     // Catch: Throwable -> L8
            int r123 = this.this$0.pullBluetoothActivityInfoLocked(atomTag, data);     // Catch: Throwable -> L542
            monitor-exit(r122);     // Catch: Throwable -> L542
            Trace.traceEnd(524288);
            return r123;
        L542:
            th = move-exception;
            throw th;     // Catch: Throwable -> L8
        L545:
            Object r124 = StatsPullAtomService.m8308$$Nest$fgetmBluetoothBytesTransferLock(this.this$0);     // Catch: Throwable -> L8
            monitor-enter(r124);     // Catch: Throwable -> L8
            int r125 = this.this$0.pullBluetoothBytesTransferLocked(atomTag, data);     // Catch: Throwable -> L551
            monitor-exit(r124);     // Catch: Throwable -> L551
            Trace.traceEnd(524288);
            return r125;
        L551:
            th = move-exception;
            throw th;     // Catch: Throwable -> L8
        L554:
            Object r126 = StatsPullAtomService.m8332$$Nest$fgetmKernelWakelockLock(this.this$0);     // Catch: Throwable -> L8
            monitor-enter(r126);     // Catch: Throwable -> L8
            int r127 = this.this$0.pullKernelWakelockLocked(atomTag, data);     // Catch: Throwable -> L560
            monitor-exit(r126);     // Catch: Throwable -> L560
            Trace.traceEnd(524288);
            return r127;
        L560:
            th = move-exception;
            throw th;     // Catch: Throwable -> L8
        L563:
            Object r128 = StatsPullAtomService.m8319$$Nest$fgetmDataBytesTransferLock(this.this$0);     // Catch: Throwable -> L8
            monitor-enter(r128);     // Catch: Throwable -> L8
            int r129 = StatsPullAtomService.m8360$$Nest$mpullDataBytesTransferLocked(this.this$0, atomTag, data);     // Catch: Throwable -> L569
            monitor-exit(r128);     // Catch: Throwable -> L569
            Trace.traceEnd(524288);
            return r129;
        L569:
            th = move-exception;
            throw th;     // Catch: Throwable -> L8
        L7:
            throw new UnsupportedOperationException("Unknown tagId=" + atomTag);     // Catch: Throwable -> L8
        L14:
            if (StatsPullAtomService.ENABLE_MOBILE_DATA_STATS_AGGREGATED_PULLER == false) goto L563;
            if (StatsPullAtomService.m8299$$Nest$fgetmAggregatedMobileDataStatsPuller(this.this$0) == null) goto L563;
            int r130 = StatsPullAtomService.m8299$$Nest$fgetmAggregatedMobileDataStatsPuller(this.this$0).pullDataBytesTransfer(data);     // Catch: Throwable -> L8
            Trace.traceEnd(524288);
            return r130;
        L8:
            th = move-exception;
            Trace.traceEnd(524288);
            throw th;
        }
    }

    private final class StatsPullAtomServiceInternalImpl extends StatsPullAtomServiceInternal {
        final /* synthetic */ StatsPullAtomService this$0;

        /* synthetic */ StatsPullAtomServiceInternalImpl(StatsPullAtomService r1, StatsPullAtomServiceIA r2) {
            this(r1);
        }

        private StatsPullAtomServiceInternalImpl(StatsPullAtomService r1) {
            this.this$0 = r1;
        }

        @Override // com.android.server.stats.pull.StatsPullAtomServiceInternal
        public void noteUidProcessState(int uid, int state) {
            if (StatsPullAtomService.ENABLE_MOBILE_DATA_STATS_AGGREGATED_PULLER == false) goto L8;
            if (StatsPullAtomService.m8299$$Nest$fgetmAggregatedMobileDataStatsPuller(this.this$0) == null) goto L8;
            long elapsedRealtime = SystemClock.elapsedRealtime();
            long uptime = SystemClock.uptimeMillis();
            StatsPullAtomService.m8299$$Nest$fgetmAggregatedMobileDataStatsPuller(this.this$0).noteUidProcessState(uid, state, elapsedRealtime, uptime);
            return;
        }
    }

    private final class StatsSubscriptionsListener extends SubscriptionManager.OnSubscriptionsChangedListener {
        private final SubscriptionManager mSm;
        final /* synthetic */ StatsPullAtomService this$0;

        /* JADX INFO: renamed from: $r8$lambda$N2r-c0TlgIaFICWmV-27qlj8QH0, reason: not valid java name */
        public static /* synthetic */ boolean m8369$r8$lambda$N2rc0TlgIaFICWmV27qlj8QH0(SubscriptionInfo r0, SubInfo r1) {
            return lambda$onSubscriptionsChangedLocked$0(r0, r1);
        }

        StatsSubscriptionsListener(StatsPullAtomService r1, SubscriptionManager sm) {
            this.this$0 = r1;
            this.mSm = sm;
        }

        @Override // android.telephony.SubscriptionManager.OnSubscriptionsChangedListener
        public void onSubscriptionsChanged() {
            Object r0 = StatsPullAtomService.m8319$$Nest$fgetmDataBytesTransferLock(this.this$0);
            monitor-enter(r0);
            onSubscriptionsChangedLocked();     // Catch: Throwable -> L7
            monitor-exit(r0);     // Catch: Throwable -> L7
            return;
        L7:
            th = move-exception;
            throw th;
        }

        private void onSubscriptionsChangedLocked() {
            List<SubscriptionInfo> currentSubs = this.mSm.getCompleteActiveSubscriptionInfoList();
            Iterator<SubscriptionInfo> r1 = currentSubs.iterator();
        L4:
            if (r1.hasNext() == false) goto L19;
            final SubscriptionInfo sub = r1.next();
            SubInfo match = (SubInfo) CollectionUtils.find(StatsPullAtomService.m8329$$Nest$fgetmHistoricalSubs(this.this$0), new StatsPullAtomService$StatsSubscriptionsListener$$ExternalSyntheticLambda0(sub));
            if (match != null) goto L4;
            int subId = sub.getSubscriptionId();
            String mcc = sub.getMccString();
            String mnc = sub.getMncString();
            String subscriberId = StatsPullAtomService.m8350$$Nest$fgetmTelephony(this.this$0).getSubscriberId(subId);
            if (TextUtils.isEmpty(subscriberId) == true) goto L18;
            if (TextUtils.isEmpty(mcc) == true) goto L18;
            if (TextUtils.isEmpty(mnc) == true) goto L18;
            if (sub.getCarrierId() == (-1)) goto L18;
            SubInfo subInfo = new SubInfo(subId, sub.getCarrierId(), mcc, mnc, subscriberId, sub.isOpportunistic());
            Slog.i(StatsPullAtomService.TAG, "subId " + subId + " added into historical sub list");
            StatsPullAtomService.m8329$$Nest$fgetmHistoricalSubs(this.this$0).add(subInfo);
            StatsPullAtomService.m8335$$Nest$fgetmNetworkStatsBaselines(this.this$0).addAll(StatsPullAtomService.m8358$$Nest$mgetDataUsageBytesTransferSnapshotForSubLocked(this.this$0, subInfo));
        L18:
            Slog.e(StatsPullAtomService.TAG, "subInfo of subId " + subId + " is invalid, ignored.");
            goto L4
        }

        private static /* synthetic */ boolean lambda$onSubscriptionsChangedLocked$0(SubscriptionInfo sub, SubInfo it) {
            if (it.subId != sub.getSubscriptionId()) goto L5;
            return true;
        L5:
            return false;
        }
    }

    private static final class ThermalEventListener extends IThermalEventListener.Stub {
        /* synthetic */ ThermalEventListener(StatsPullAtomServiceIA r1) {
            this();
        }

        private ThermalEventListener() {
        }

        public void notifyThrottling(Temperature temp) {
            FrameworkStatsLog.write(189, temp.getType(), temp.getName(), (int) (temp.getValue() * 10.0f), temp.getStatus());
        }
    }

    public static /* synthetic */ void $r8$lambda$0cKdZJLATNbDt9m0JVtJvNMBxH0(SynchronousResultReceiver r0, WifiActivityEnergyInfo r1) {
        lambda$pullWifiActivityInfoLocked$19(r0, r1);
    }

    public static /* synthetic */ void $r8$lambda$2O0SkzcYXm_AQJGiJNMylXy_Wlg(List r0, int r1, int r2, long[] r3) {
        lambda$pullCpuTimePerUidLocked$14(r0, r1, r2, r3);
    }

    public static /* synthetic */ NetworkStats.Entry $r8$lambda$3h98UZb7dm2Em_hF8s2O2X4P0wc(NetworkStats.Entry r0) {
        return lambda$sliceNetworkStatsByUidAndFgbg$12(r0);
    }

    public static /* synthetic */ void $r8$lambda$7QNTU9FRjoKcuYBW3nwxJ_1h3JI(List r0, int r1, int r2, long[] r3) {
        lambda$pullCpuClusterTimeLocked$18(r0, r1, r2, r3);
    }

    public static /* synthetic */ NetworkStats $r8$lambda$8VLDv9gQV9cbYLHktnmAvgf2y4s(StatsPullAtomService r0, NetworkTemplate r1, boolean r2, long r3, long r5) {
        return r0.lambda$getUidNetworkStatsSnapshotForTemplateLocked$9(r1, r2, r3, r5);
    }

    /* JADX INFO: renamed from: $r8$lambda$9sDwaXHr6DKJcT98-BrD4PQ9HfI, reason: not valid java name */
    public static /* synthetic */ void m8295$r8$lambda$9sDwaXHr6DKJcT98BrD4PQ9HfI(SparseArray r0, int r1, long[] r2) {
        lambda$pullCpuTimePerUidFreqLocked$16(r0, r1, r2);
    }

    public static /* synthetic */ boolean $r8$lambda$DwULdVYm9Qf7XhyM_4BQrbqbpE4(int r0) {
        return lambda$countAccessibilityServices$28(r0);
    }

    public static /* synthetic */ void $r8$lambda$RgpNyMARA8GUjHyunSK8FDiRfT8(SparseArray r0, int r1, int[] r2, long[] r3, double[] r4, int r5, long[] r6) {
        lambda$pullCpuCyclesPerUidClusterLocked$15(r0, r1, r2, r3, r4, r5, r6);
    }

    /* JADX INFO: renamed from: $r8$lambda$XpfctOQ0eLPtXTb5L-V7Ki49Za4, reason: not valid java name */
    public static /* synthetic */ boolean m8296$r8$lambda$XpfctOQ0eLPtXTb5LV7Ki49Za4(StatsPullAtomService r0, int r1, File r2, String r3) {
        return r0.lambda$readProcStatsHighWaterMark$23(r1, r2, r3);
    }

    /* JADX INFO: renamed from: $r8$lambda$_sqKYA5jJ5098GuPVU-_KS1n6_w, reason: not valid java name */
    public static /* synthetic */ void m8297$r8$lambda$_sqKYA5jJ5098GuPVU_KS1n6_w(AtomicInteger r0, int[] r1) {
        lambda$hasDolbyVisionIssue$27(r0, r1);
    }

    public static /* synthetic */ boolean $r8$lambda$ekv4UoGqsHEPM5t9Ano0NUSQAQI(NetworkStatsExt r0, NetworkStatsExt r1) {
        return lambda$pullDataBytesTransferLocked$7(r0, r1);
    }

    public static /* synthetic */ void $r8$lambda$f8CMvmwmNLc8uUbjdjU3zNO3uPg(StatsPullAtomService r0) {
        r0.lambda$getIThermalService$2();
    }

    public static /* synthetic */ void $r8$lambda$fBtiMXk9aIaWnrTzdfhmfOwjEJ4(StatsPullAtomService r0) {
        r0.lambda$getIKeystoreMetricsService$3();
    }

    public static /* synthetic */ void $r8$lambda$fS9CWa4A6V7bN4ZnSc7_Ru_wM0M(SynchronousResultReceiver r0, UwbActivityEnergyInfo r1) {
        lambda$pullUwbActivityInfoLocked$20(r0, r1);
    }

    public static /* synthetic */ boolean $r8$lambda$fUFk8IGjCPUN5Z1_tSVHSh_nW2M(NetworkTemplate r0, boolean r1, NetworkStatsAccumulator r2) {
        return lambda$getUidNetworkStatsSnapshotForTemplateLocked$8(r0, r1, r2);
    }

    public static /* synthetic */ void $r8$lambda$gdGSFuqXcHC_1akP48Yk4TAgQy0(SparseArray r0, ProcessMemoryState r1) {
        lambda$pullProcessMemoryHighWaterMarkLocked$21(r0, r1);
    }

    public static /* synthetic */ void $r8$lambda$gszRlraDMPykoqwbE9AU9qwdVfw(StatsPullAtomService r0) {
        r0.lambda$getIProcessStatsService$6();
    }

    public static /* synthetic */ NetworkStats.Entry $r8$lambda$iUkxJZDuMC3iIfhqLcbPHDiceXU(NetworkStats.Entry r0) {
        return lambda$sliceNetworkStatsByUid$10(r0);
    }

    public static /* synthetic */ void $r8$lambda$jeEx2IUSYb9lX3Rx0kgkE63ggWo(StatsPullAtomService r0) {
        r0.lambda$getINotificationManagerService$5();
    }

    /* JADX INFO: renamed from: $r8$lambda$lhR8vHUhEf2w0nIQBkw-NB6HwRA, reason: not valid java name */
    public static /* synthetic */ void m8298$r8$lambda$lhR8vHUhEf2w0nIQBkwNB6HwRA(List r0, int r1, int r2, Long r3) {
        lambda$pullCpuActiveTimeLocked$17(r0, r1, r2, r3);
    }

    public static /* synthetic */ void $r8$lambda$nNR4Gctk6hlu9qnTsuOvrymZzfk(StatsPullAtomService r0) {
        r0.lambda$onBootPhase$1();
    }

    public static /* synthetic */ void $r8$lambda$qb74jErDmbpYjoDRKkDDIHHyoHk(StatsPullAtomService r0) {
        r0.lambda$onBootPhase$0();
    }

    public static /* synthetic */ NetworkStats.Entry $r8$lambda$sreRGAc35eKWERfOvm5LZBlAzsY(NetworkStats.Entry r0) {
        return lambda$sliceNetworkStatsByFgbg$11(r0);
    }

    public static /* synthetic */ boolean $r8$lambda$utUETIDrW9SBoswWi9QjqulXwTk(int r0) {
        return lambda$hasDolbyVisionIssue$25(r0);
    }

    public static /* synthetic */ boolean $r8$lambda$w7Kd7lQjlCiLcNLOI7IGnUO7EkY(int[] r0) {
        return lambda$hasDolbyVisionIssue$26(r0);
    }

    public static /* synthetic */ void $r8$lambda$xOFqwPE7nMI3fCLOQoBFq0pcvKM(StatsPullAtomService r0) {
        r0.lambda$getIStoragedService$4();
    }

    public static /* synthetic */ NetworkStats.Entry $r8$lambda$y1LLMMDwbj7_Q6rslFz7YV7vHwU(NetworkStats.Entry r0) {
        return lambda$sliceNetworkStatsByUidTagAndMetered$13(r0);
    }

    public static /* synthetic */ void $r8$lambda$yiSVwuJ3h2vuh0LsbdQ790jSlzQ(List r0, int r1, int r2, long r3, long r5, long r7, long r9, long r11, long r13, long r15, long r17, long r19, long r21) {
        lambda$pullDiskIOLocked$24(r0, r1, r2, r3, r5, r7, r9, r11, r13, r15, r17, r19, r21);
    }

    public static /* synthetic */ void $r8$lambda$zNvpss6UMLNdcD_4Qi4QLslHmiA(SparseArray r0, ProcessMemoryState r1) {
        lambda$pullProcessMemorySnapshot$22(r0, r1);
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmAggregatedMobileDataStatsPuller, reason: not valid java name */
    static /* bridge */ /* synthetic */ AggregatedMobileDataStatsPuller m8299$$Nest$fgetmAggregatedMobileDataStatsPuller(StatsPullAtomService r0) {
        return r0.mAggregatedMobileDataStatsPuller;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmAppOpsLock, reason: not valid java name */
    static /* bridge */ /* synthetic */ Object m8300$$Nest$fgetmAppOpsLock(StatsPullAtomService r0) {
        return r0.mAppOpsLock;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmAppOpsSamplingRate, reason: not valid java name */
    static /* bridge */ /* synthetic */ int m8301$$Nest$fgetmAppOpsSamplingRate(StatsPullAtomService r0) {
        return r0.mAppOpsSamplingRate;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmAppSizeLock, reason: not valid java name */
    static /* bridge */ /* synthetic */ Object m8302$$Nest$fgetmAppSizeLock(StatsPullAtomService r0) {
        return r0.mAppSizeLock;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmAppsOnExternalStorageInfoLock, reason: not valid java name */
    static /* bridge */ /* synthetic */ Object m8303$$Nest$fgetmAppsOnExternalStorageInfoLock(StatsPullAtomService r0) {
        return r0.mAppsOnExternalStorageInfoLock;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmAttributedAppOpsLock, reason: not valid java name */
    static /* bridge */ /* synthetic */ Object m8304$$Nest$fgetmAttributedAppOpsLock(StatsPullAtomService r0) {
        return r0.mAttributedAppOpsLock;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmBinderCallsStatsExceptionsLock, reason: not valid java name */
    static /* bridge */ /* synthetic */ Object m8305$$Nest$fgetmBinderCallsStatsExceptionsLock(StatsPullAtomService r0) {
        return r0.mBinderCallsStatsExceptionsLock;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmBinderCallsStatsLock, reason: not valid java name */
    static /* bridge */ /* synthetic */ Object m8306$$Nest$fgetmBinderCallsStatsLock(StatsPullAtomService r0) {
        return r0.mBinderCallsStatsLock;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmBluetoothActivityInfoLock, reason: not valid java name */
    static /* bridge */ /* synthetic */ Object m8307$$Nest$fgetmBluetoothActivityInfoLock(StatsPullAtomService r0) {
        return r0.mBluetoothActivityInfoLock;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmBluetoothBytesTransferLock, reason: not valid java name */
    static /* bridge */ /* synthetic */ Object m8308$$Nest$fgetmBluetoothBytesTransferLock(StatsPullAtomService r0) {
        return r0.mBluetoothBytesTransferLock;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmBuildInformationLock, reason: not valid java name */
    static /* bridge */ /* synthetic */ Object m8309$$Nest$fgetmBuildInformationLock(StatsPullAtomService r0) {
        return r0.mBuildInformationLock;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmCategorySizeLock, reason: not valid java name */
    static /* bridge */ /* synthetic */ Object m8310$$Nest$fgetmCategorySizeLock(StatsPullAtomService r0) {
        return r0.mCategorySizeLock;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmCooldownDeviceLock, reason: not valid java name */
    static /* bridge */ /* synthetic */ Object m8311$$Nest$fgetmCooldownDeviceLock(StatsPullAtomService r0) {
        return r0.mCooldownDeviceLock;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmCpuActiveTimeLock, reason: not valid java name */
    static /* bridge */ /* synthetic */ Object m8312$$Nest$fgetmCpuActiveTimeLock(StatsPullAtomService r0) {
        return r0.mCpuActiveTimeLock;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmCpuClusterTimeLock, reason: not valid java name */
    static /* bridge */ /* synthetic */ Object m8313$$Nest$fgetmCpuClusterTimeLock(StatsPullAtomService r0) {
        return r0.mCpuClusterTimeLock;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmCpuTimePerClusterFreqLock, reason: not valid java name */
    static /* bridge */ /* synthetic */ Object m8314$$Nest$fgetmCpuTimePerClusterFreqLock(StatsPullAtomService r0) {
        return r0.mCpuTimePerClusterFreqLock;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmCpuTimePerThreadFreqLock, reason: not valid java name */
    static /* bridge */ /* synthetic */ Object m8315$$Nest$fgetmCpuTimePerThreadFreqLock(StatsPullAtomService r0) {
        return r0.mCpuTimePerThreadFreqLock;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmCpuTimePerUidFreqLock, reason: not valid java name */
    static /* bridge */ /* synthetic */ Object m8316$$Nest$fgetmCpuTimePerUidFreqLock(StatsPullAtomService r0) {
        return r0.mCpuTimePerUidFreqLock;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmCpuTimePerUidLock, reason: not valid java name */
    static /* bridge */ /* synthetic */ Object m8317$$Nest$fgetmCpuTimePerUidLock(StatsPullAtomService r0) {
        return r0.mCpuTimePerUidLock;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmDangerousPermissionStateLock, reason: not valid java name */
    static /* bridge */ /* synthetic */ Object m8318$$Nest$fgetmDangerousPermissionStateLock(StatsPullAtomService r0) {
        return r0.mDangerousPermissionStateLock;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmDataBytesTransferLock, reason: not valid java name */
    static /* bridge */ /* synthetic */ Object m8319$$Nest$fgetmDataBytesTransferLock(StatsPullAtomService r0) {
        return r0.mDataBytesTransferLock;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmDebugElapsedClockLock, reason: not valid java name */
    static /* bridge */ /* synthetic */ Object m8320$$Nest$fgetmDebugElapsedClockLock(StatsPullAtomService r0) {
        return r0.mDebugElapsedClockLock;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmDebugFailingElapsedClockLock, reason: not valid java name */
    static /* bridge */ /* synthetic */ Object m8321$$Nest$fgetmDebugFailingElapsedClockLock(StatsPullAtomService r0) {
        return r0.mDebugFailingElapsedClockLock;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmDeviceCalculatedPowerUseLock, reason: not valid java name */
    static /* bridge */ /* synthetic */ Object m8322$$Nest$fgetmDeviceCalculatedPowerUseLock(StatsPullAtomService r0) {
        return r0.mDeviceCalculatedPowerUseLock;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmDirectoryUsageLock, reason: not valid java name */
    static /* bridge */ /* synthetic */ Object m8323$$Nest$fgetmDirectoryUsageLock(StatsPullAtomService r0) {
        return r0.mDirectoryUsageLock;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmDiskIoLock, reason: not valid java name */
    static /* bridge */ /* synthetic */ Object m8324$$Nest$fgetmDiskIoLock(StatsPullAtomService r0) {
        return r0.mDiskIoLock;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmDiskStatsLock, reason: not valid java name */
    static /* bridge */ /* synthetic */ Object m8325$$Nest$fgetmDiskStatsLock(StatsPullAtomService r0) {
        return r0.mDiskStatsLock;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmExternalStorageInfoLock, reason: not valid java name */
    static /* bridge */ /* synthetic */ Object m8326$$Nest$fgetmExternalStorageInfoLock(StatsPullAtomService r0) {
        return r0.mExternalStorageInfoLock;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmFaceSettingsLock, reason: not valid java name */
    static /* bridge */ /* synthetic */ Object m8327$$Nest$fgetmFaceSettingsLock(StatsPullAtomService r0) {
        return r0.mFaceSettingsLock;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmHealthHalLock, reason: not valid java name */
    static /* bridge */ /* synthetic */ Object m8328$$Nest$fgetmHealthHalLock(StatsPullAtomService r0) {
        return r0.mHealthHalLock;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmHistoricalSubs, reason: not valid java name */
    static /* bridge */ /* synthetic */ ArrayList m8329$$Nest$fgetmHistoricalSubs(StatsPullAtomService r0) {
        return r0.mHistoricalSubs;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmInstalledIncrementalPackagesLock, reason: not valid java name */
    static /* bridge */ /* synthetic */ Object m8330$$Nest$fgetmInstalledIncrementalPackagesLock(StatsPullAtomService r0) {
        return r0.mInstalledIncrementalPackagesLock;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmIonHeapSizeLock, reason: not valid java name */
    static /* bridge */ /* synthetic */ Object m8331$$Nest$fgetmIonHeapSizeLock(StatsPullAtomService r0) {
        return r0.mIonHeapSizeLock;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmKernelWakelockLock, reason: not valid java name */
    static /* bridge */ /* synthetic */ Object m8332$$Nest$fgetmKernelWakelockLock(StatsPullAtomService r0) {
        return r0.mKernelWakelockLock;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmLooperStatsLock, reason: not valid java name */
    static /* bridge */ /* synthetic */ Object m8333$$Nest$fgetmLooperStatsLock(StatsPullAtomService r0) {
        return r0.mLooperStatsLock;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmModemActivityInfoLock, reason: not valid java name */
    static /* bridge */ /* synthetic */ Object m8334$$Nest$fgetmModemActivityInfoLock(StatsPullAtomService r0) {
        return r0.mModemActivityInfoLock;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmNetworkStatsBaselines, reason: not valid java name */
    static /* bridge */ /* synthetic */ ArrayList m8335$$Nest$fgetmNetworkStatsBaselines(StatsPullAtomService r0) {
        return r0.mNetworkStatsBaselines;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmNotificationRemoteViewsLock, reason: not valid java name */
    static /* bridge */ /* synthetic */ Object m8336$$Nest$fgetmNotificationRemoteViewsLock(StatsPullAtomService r0) {
        return r0.mNotificationRemoteViewsLock;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmNumBiometricsEnrolledLock, reason: not valid java name */
    static /* bridge */ /* synthetic */ Object m8337$$Nest$fgetmNumBiometricsEnrolledLock(StatsPullAtomService r0) {
        return r0.mNumBiometricsEnrolledLock;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmPowerProfileLock, reason: not valid java name */
    static /* bridge */ /* synthetic */ Object m8338$$Nest$fgetmPowerProfileLock(StatsPullAtomService r0) {
        return r0.mPowerProfileLock;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmProcStatsLock, reason: not valid java name */
    static /* bridge */ /* synthetic */ Object m8339$$Nest$fgetmProcStatsLock(StatsPullAtomService r0) {
        return r0.mProcStatsLock;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmProcessCpuTimeLock, reason: not valid java name */
    static /* bridge */ /* synthetic */ Object m8340$$Nest$fgetmProcessCpuTimeLock(StatsPullAtomService r0) {
        return r0.mProcessCpuTimeLock;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmProcessMemoryHighWaterMarkLock, reason: not valid java name */
    static /* bridge */ /* synthetic */ Object m8341$$Nest$fgetmProcessMemoryHighWaterMarkLock(StatsPullAtomService r0) {
        return r0.mProcessMemoryHighWaterMarkLock;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmProcessMemoryStateLock, reason: not valid java name */
    static /* bridge */ /* synthetic */ Object m8342$$Nest$fgetmProcessMemoryStateLock(StatsPullAtomService r0) {
        return r0.mProcessMemoryStateLock;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmProcessSystemIonHeapSizeLock, reason: not valid java name */
    static /* bridge */ /* synthetic */ Object m8343$$Nest$fgetmProcessSystemIonHeapSizeLock(StatsPullAtomService r0) {
        return r0.mProcessSystemIonHeapSizeLock;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmRoleHolderLock, reason: not valid java name */
    static /* bridge */ /* synthetic */ Object m8344$$Nest$fgetmRoleHolderLock(StatsPullAtomService r0) {
        return r0.mRoleHolderLock;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmRuntimeAppOpAccessMessageLock, reason: not valid java name */
    static /* bridge */ /* synthetic */ Object m8345$$Nest$fgetmRuntimeAppOpAccessMessageLock(StatsPullAtomService r0) {
        return r0.mRuntimeAppOpAccessMessageLock;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmSettingsStatsLock, reason: not valid java name */
    static /* bridge */ /* synthetic */ Object m8346$$Nest$fgetmSettingsStatsLock(StatsPullAtomService r0) {
        return r0.mSettingsStatsLock;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmSystemElapsedRealtimeLock, reason: not valid java name */
    static /* bridge */ /* synthetic */ Object m8347$$Nest$fgetmSystemElapsedRealtimeLock(StatsPullAtomService r0) {
        return r0.mSystemElapsedRealtimeLock;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmSystemIonHeapSizeLock, reason: not valid java name */
    static /* bridge */ /* synthetic */ Object m8348$$Nest$fgetmSystemIonHeapSizeLock(StatsPullAtomService r0) {
        return r0.mSystemIonHeapSizeLock;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmSystemUptimeLock, reason: not valid java name */
    static /* bridge */ /* synthetic */ Object m8349$$Nest$fgetmSystemUptimeLock(StatsPullAtomService r0) {
        return r0.mSystemUptimeLock;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmTelephony, reason: not valid java name */
    static /* bridge */ /* synthetic */ TelephonyManager m8350$$Nest$fgetmTelephony(StatsPullAtomService r0) {
        return r0.mTelephony;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmTemperatureLock, reason: not valid java name */
    static /* bridge */ /* synthetic */ Object m8351$$Nest$fgetmTemperatureLock(StatsPullAtomService r0) {
        return r0.mTemperatureLock;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmTimeZoneDataInfoLock, reason: not valid java name */
    static /* bridge */ /* synthetic */ Object m8352$$Nest$fgetmTimeZoneDataInfoLock(StatsPullAtomService r0) {
        return r0.mTimeZoneDataInfoLock;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmTimeZoneDetectionInfoLock, reason: not valid java name */
    static /* bridge */ /* synthetic */ Object m8353$$Nest$fgetmTimeZoneDetectionInfoLock(StatsPullAtomService r0) {
        return r0.mTimeZoneDetectionInfoLock;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmUwbActivityInfoLock, reason: not valid java name */
    static /* bridge */ /* synthetic */ Object m8354$$Nest$fgetmUwbActivityInfoLock(StatsPullAtomService r0) {
        return r0.mUwbActivityInfoLock;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmWifiActivityInfoLock, reason: not valid java name */
    static /* bridge */ /* synthetic */ Object m8355$$Nest$fgetmWifiActivityInfoLock(StatsPullAtomService r0) {
        return r0.mWifiActivityInfoLock;
    }

    /* JADX INFO: renamed from: -$$Nest$fputmAppOpsSamplingRate, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m8356$$Nest$fputmAppOpsSamplingRate(StatsPullAtomService r0, int r1) {
        r0.mAppOpsSamplingRate = r1;
    }

    /* JADX INFO: renamed from: -$$Nest$mestimateAppOpsSamplingRate, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m8357$$Nest$mestimateAppOpsSamplingRate(StatsPullAtomService r0) {
        r0.estimateAppOpsSamplingRate();
    }

    /* JADX INFO: renamed from: -$$Nest$mgetDataUsageBytesTransferSnapshotForSubLocked, reason: not valid java name */
    static /* bridge */ /* synthetic */ List m8358$$Nest$mgetDataUsageBytesTransferSnapshotForSubLocked(StatsPullAtomService r0, SubInfo r1) {
        return r0.getDataUsageBytesTransferSnapshotForSubLocked(r1);
    }

    /* JADX INFO: renamed from: -$$Nest$mpullCachedAppsHighWatermark, reason: not valid java name */
    static /* bridge */ /* synthetic */ int m8359$$Nest$mpullCachedAppsHighWatermark(StatsPullAtomService r0, int r1, List r2) {
        return r0.pullCachedAppsHighWatermark(r1, r2);
    }

    /* JADX INFO: renamed from: -$$Nest$mpullDataBytesTransferLocked, reason: not valid java name */
    static /* bridge */ /* synthetic */ int m8360$$Nest$mpullDataBytesTransferLocked(StatsPullAtomService r0, int r1, List r2) {
        return r0.pullDataBytesTransferLocked(r1, r2);
    }

    /* JADX INFO: renamed from: -$$Nest$mpullHdrCapabilities, reason: not valid java name */
    static /* bridge */ /* synthetic */ int m8361$$Nest$mpullHdrCapabilities(StatsPullAtomService r0, int r1, List r2) {
        return r0.pullHdrCapabilities(r1, r2);
    }

    /* JADX INFO: renamed from: -$$Nest$mpullHealthHalLocked, reason: not valid java name */
    static /* bridge */ /* synthetic */ int m8362$$Nest$mpullHealthHalLocked(StatsPullAtomService r0, int r1, List r2) {
        return r0.pullHealthHalLocked(r1, r2);
    }

    /* JADX INFO: renamed from: -$$Nest$mpullNumBiometricsEnrolledLocked, reason: not valid java name */
    static /* bridge */ /* synthetic */ int m8363$$Nest$mpullNumBiometricsEnrolledLocked(StatsPullAtomService r0, int r1, int r2, List r3) {
        return r0.pullNumBiometricsEnrolledLocked(r1, r2, r3);
    }

    /* JADX INFO: renamed from: -$$Nest$mpullPendingIntentsPerPackage, reason: not valid java name */
    static /* bridge */ /* synthetic */ int m8364$$Nest$mpullPendingIntentsPerPackage(StatsPullAtomService r0, int r1, List r2) {
        return r0.pullPendingIntentsPerPackage(r1, r2);
    }

    /* JADX INFO: renamed from: -$$Nest$mpullProcStatsLocked, reason: not valid java name */
    static /* bridge */ /* synthetic */ int m8365$$Nest$mpullProcStatsLocked(StatsPullAtomService r0, int r1, List r2) {
        return r0.pullProcStatsLocked(r1, r2);
    }

    /* JADX INFO: renamed from: -$$Nest$mpullProcessAssociationLocked, reason: not valid java name */
    static /* bridge */ /* synthetic */ int m8366$$Nest$mpullProcessAssociationLocked(StatsPullAtomService r0, int r1, List r2) {
        return r0.pullProcessAssociationLocked(r1, r2);
    }

    /* JADX INFO: renamed from: -$$Nest$mpullProcessStateLocked, reason: not valid java name */
    static /* bridge */ /* synthetic */ int m8367$$Nest$mpullProcessStateLocked(StatsPullAtomService r0, int r1, List r2) {
        return r0.pullProcessStateLocked(r1, r2);
    }

    /* JADX INFO: renamed from: -$$Nest$sfgetRANDOM_SEED, reason: not valid java name */
    static /* bridge */ /* synthetic */ int m8368$$Nest$sfgetRANDOM_SEED() {
        return RANDOM_SEED;
    }

    private native void initializeNativePullers();

    static {
        RANDOM_SEED = new Random().nextInt();
        NETSTATS_UID_DEFAULT_BUCKET_DURATION_MS = TimeUnit.HOURS.toMillis(2);
        ENABLE_MOBILE_DATA_STATS_AGGREGATED_PULLER = true;
        ENABLE_PRESSURE_STALL_INFORMATION_PULLER = true;
    }

    public StatsPullAtomService(Context context) {
        super(context);
        this.mThermalLock = new Object();
        this.mStoragedLock = new Object();
        this.mNotificationStatsLock = new Object();
        this.mDebugElapsedClockPreviousValue = 0;
        this.mDebugElapsedClockPullCount = 0;
        this.mDebugFailingElapsedClockPreviousValue = 0;
        this.mDebugFailingElapsedClockPullCount = 0;
        this.mNetworkStatsManager = null;
        this.mAppOpsSamplingRate = 0;
        this.mDangerousAppOpsListLock = new Object();
        this.mDangerousAppOpsList = new ArraySet();
        this.mNetworkStatsBaselines = new ArrayList();
        this.mNetworkStatsAccumulators = new ArrayList();
        this.mLastNetworkStatsPollTime = -15000;
        this.mHistoricalSubs = new ArrayList();
        this.mAggregatedMobileDataStatsPuller = null;
        this.mDataBytesTransferLock = new Object();
        this.mBluetoothBytesTransferLock = new Object();
        this.mKernelWakelockLock = new Object();
        this.mCpuTimePerClusterFreqLock = new Object();
        this.mCpuTimePerUidLock = new Object();
        this.mCpuTimePerUidFreqLock = new Object();
        this.mCpuActiveTimeLock = new Object();
        this.mCpuClusterTimeLock = new Object();
        this.mWifiActivityInfoLock = new Object();
        this.mModemActivityInfoLock = new Object();
        this.mBluetoothActivityInfoLock = new Object();
        this.mUwbActivityInfoLock = new Object();
        this.mSystemElapsedRealtimeLock = new Object();
        this.mSystemUptimeLock = new Object();
        this.mProcessMemoryStateLock = new Object();
        this.mProcessMemoryHighWaterMarkLock = new Object();
        this.mSystemIonHeapSizeLock = new Object();
        this.mIonHeapSizeLock = new Object();
        this.mProcessSystemIonHeapSizeLock = new Object();
        this.mTemperatureLock = new Object();
        this.mCooldownDeviceLock = new Object();
        this.mBinderCallsStatsLock = new Object();
        this.mBinderCallsStatsExceptionsLock = new Object();
        this.mLooperStatsLock = new Object();
        this.mDiskStatsLock = new Object();
        this.mDirectoryUsageLock = new Object();
        this.mAppSizeLock = new Object();
        this.mCategorySizeLock = new Object();
        this.mNumBiometricsEnrolledLock = new Object();
        this.mProcStatsLock = new Object();
        this.mDiskIoLock = new Object();
        this.mPowerProfileLock = new Object();
        this.mProcessCpuTimeLock = new Object();
        this.mCpuTimePerThreadFreqLock = new Object();
        this.mDeviceCalculatedPowerUseLock = new Object();
        this.mDebugElapsedClockLock = new Object();
        this.mDebugFailingElapsedClockLock = new Object();
        this.mBuildInformationLock = new Object();
        this.mRoleHolderLock = new Object();
        this.mTimeZoneDataInfoLock = new Object();
        this.mTimeZoneDetectionInfoLock = new Object();
        this.mExternalStorageInfoLock = new Object();
        this.mAppsOnExternalStorageInfoLock = new Object();
        this.mFaceSettingsLock = new Object();
        this.mAppOpsLock = new Object();
        this.mRuntimeAppOpAccessMessageLock = new Object();
        this.mNotificationRemoteViewsLock = new Object();
        this.mDangerousPermissionStateLock = new Object();
        this.mHealthHalLock = new Object();
        this.mAttributedAppOpsLock = new Object();
        this.mSettingsStatsLock = new Object();
        this.mInstalledIncrementalPackagesLock = new Object();
        this.mKeystoreLock = new Object();
        this.mContext = context;
    }

    @Override // com.android.server.SystemService
    public void onStart() {
        if (ENABLE_MOBILE_DATA_STATS_AGGREGATED_PULLER == false) goto L6;
        LocalServices.addService(StatsPullAtomServiceInternal.class, new StatsPullAtomServiceInternalImpl(this, null));
        return;
    }

    @Override // com.android.server.SystemService
    public void onBootPhase(int phase) {
        super.onBootPhase(phase);
        if (phase != 500) goto L6;
        BackgroundThread.getHandler().post(new StatsPullAtomService$$ExternalSyntheticLambda23(this));
        return;
    L6:
        if (phase != 600) goto L10;
        initNetworkStatsManager();
        BackgroundThread.getHandler().post(new StatsPullAtomService$$ExternalSyntheticLambda24(this));
        return;
    }

    private /* synthetic */ void lambda$onBootPhase$0() {
        initializeNativePullers();
        initializePullersState();
        registerPullers();
        registerEventListeners();
    }

    private /* synthetic */ void lambda$onBootPhase$1() {
        initAndRegisterNetworkStatsPullers();
        initAndRegisterDeferredPullers();
    }

    void initializePullersState() {
        this.mStatsManager = (StatsManager) this.mContext.getSystemService("stats");
        this.mWifiManager = (WifiManager) this.mContext.getSystemService("wifi");
        this.mTelephony = (TelephonyManager) this.mContext.getSystemService(HintsHelper.AUTOFILL_HINT_PHONE);
        this.mSubscriptionManager = (SubscriptionManager) this.mContext.getSystemService("telephony_subscription_service");
        this.mStatsSubscriptionsListener = new StatsSubscriptionsListener(this, this.mSubscriptionManager);
        this.mStorageManager = (StorageManager) this.mContext.getSystemService(StorageManager.class);
        this.mStoragedUidIoStatsReader = new StoragedUidIoStatsReader();
        this.mBaseDir = new File(SystemServiceManager.ensureSystemDir(), "stats_pull");
        this.mBaseDir.mkdirs();
        this.mCpuUidUserSysTimeReader = new KernelCpuUidTimeReader.KernelCpuUidUserSysTimeReader(false);
        this.mCpuUidFreqTimeReader = new KernelCpuUidTimeReader.KernelCpuUidFreqTimeReader(false);
        this.mCpuUidActiveTimeReader = new KernelCpuUidTimeReader.KernelCpuUidActiveTimeReader(false);
        this.mCpuUidClusterTimeReader = new KernelCpuUidTimeReader.KernelCpuUidClusterTimeReader(false);
        this.mKernelWakelockReader = new KernelWakelockReader();
        this.mTmpWakelockStats = new KernelWakelockStats();
        this.mKernelCpuThreadReader = KernelCpuThreadReaderSettingsObserver.getSettingsModifiedReader(this.mContext);
        this.mHealthService = HealthServiceWrapper.create(null);     // Catch: Throwable -> L5
    L7:
        PackageManager pm = this.mContext.getPackageManager();
        int op = 0;
    L9:
        if (op >= 166) goto L22;
        String perm = AppOpsManager.opToPermission(op);
        if (perm == null) goto L21;
        PermissionInfo permInfo = pm.getPermissionInfo(perm, 0);     // Catch: PackageManager.NameNotFoundException -> L17
        if (permInfo.getProtection() != 1) goto L21;
        this.mDangerousAppOpsList.add(Integer.valueOf(op));     // Catch: PackageManager.NameNotFoundException -> L17
    L21:
        op = op + 1;
        goto L9
    L22:
        this.mSurfaceFlingerProcessCpuThreadReader = new SelectedProcessCpuThreadReader("/system/bin/surfaceflinger");
        getIKeystoreMetricsService();
        return;
    L6:
        Slog.e(TAG, "failed to initialize healthHalWrapper");
        goto L7
    }

    void registerEventListeners() {
        ConnectivityManager connectivityManager = (ConnectivityManager) this.mContext.getSystemService("connectivity");
        NetworkRequest request = new NetworkRequest.Builder().build();
        StatsPullAtomServiceIA r4 = null;
        connectivityManager.registerNetworkCallback(request, new ConnectivityStatsCallback(r4));
        IThermalService thermalService = getIThermalService();
        if (thermalService == null) goto L11;
        thermalService.registerThermalEventListener(new ThermalEventListener(r4));     // Catch: RemoteException -> L6
        Slog.i(TAG, "register thermal listener successfully");     // Catch: RemoteException -> L6
        return;
    L7:
        Slog.i(TAG, "failed to register thermal listener");
        return;
    }

    void registerPullers() {
        Slog.d(TAG, "Registering pullers with statsd");
        this.mStatsCallbackImpl = new StatsPullAtomCallbackImpl(this, null);
        registerBluetoothBytesTransfer();
        registerKernelWakelock();
        registerCpuTimePerClusterFreq();
        registerCpuTimePerUid();
        registerCpuCyclesPerUidCluster();
        registerCpuTimePerUidFreq();
        registerCpuCyclesPerThreadGroupCluster();
        registerCpuActiveTime();
        registerCpuClusterTime();
        registerWifiActivityInfo();
        registerModemActivityInfo();
        registerBluetoothActivityInfo();
        registerSystemElapsedRealtime();
        registerSystemUptime();
        registerProcessMemoryState();
        registerProcessMemoryHighWaterMark();
        registerProcessMemorySnapshot();
        registerSystemIonHeapSize();
        registerIonHeapSize();
        registerProcessSystemIonHeapSize();
        registerSystemMemory();
        registerProcessDmabufMemory();
        registerVmStat();
        registerTemperature();
        registerCoolingDevice();
        registerBinderCallsStats();
        registerBinderCallsStatsExceptions();
        registerLooperStats();
        registerDiskStats();
        registerDirectoryUsage();
        registerAppSize();
        registerCategorySize();
        registerNumFingerprintsEnrolled();
        registerNumFacesEnrolled();
        registerProcStats();
        registerProcStatsPkgProc();
        registerProcessState();
        registerProcessAssociation();
        registerDiskIO();
        registerPowerProfile();
        registerProcessCpuTime();
        registerCpuTimePerThreadFreq();
        registerDeviceCalculatedPowerUse();
        registerDebugElapsedClock();
        registerDebugFailingElapsedClock();
        registerBuildInformation();
        registerRoleHolder();
        registerTimeZoneDataInfo();
        registerTimeZoneDetectorState();
        registerExternalStorageInfo();
        registerAppsOnExternalStorageInfo();
        registerFaceSettings();
        registerAppOps();
        registerAttributedAppOps();
        registerRuntimeAppOpAccessMessage();
        registerNotificationRemoteViews();
        registerDangerousPermissionState();
        registerDangerousPermissionStateSampled();
        registerBatteryLevel();
        registerRemainingBatteryCapacity();
        registerFullBatteryCapacity();
        registerBatteryVoltage();
        registerBatteryCycleCount();
        registerBatteryHealth();
        registerSettingsStats();
        registerInstalledIncrementalPackages();
        registerKeystoreStorageStats();
        registerKeystoreKeyCreationWithGeneralInfo();
        registerKeystoreKeyCreationWithAuthInfo();
        registerKeystoreKeyCreationWithPurposeModesInfo();
        registerKeystoreAtomWithOverflow();
        registerKeystoreKeyOperationWithPurposeAndModesInfo();
        registerKeystoreKeyOperationWithGeneralInfo();
        registerRkpErrorStats();
        registerKeystoreCrashStats();
        registerAccessibilityShortcutStats();
        registerAccessibilityFloatingMenuStats();
        registerMediaCapabilitiesStats();
        registerPendingIntentsPerPackagePuller();
        registerPinnerServiceStats();
        registerHdrCapabilitiesPuller();
        registerCachedAppsHighWatermarkPuller();
        if (ENABLE_PRESSURE_STALL_INFORMATION_PULLER == false) goto L6;
        registerPressureStallInformation();
        return;
    }

    private void initMobileDataStatsPuller() {
        Slog.d(TAG, "ENABLE_MOBILE_DATA_STATS_AGGREGATED_PULLER = " + ENABLE_MOBILE_DATA_STATS_AGGREGATED_PULLER);
        if (ENABLE_MOBILE_DATA_STATS_AGGREGATED_PULLER == false) goto L6;
        this.mAggregatedMobileDataStatsPuller = new AggregatedMobileDataStatsPuller((NetworkStatsManager) this.mContext.getSystemService(NetworkStatsManager.class));
        return;
    }

    private NetworkStatsManager getNetworkStatsManager() {
        if (this.mNetworkStatsManager == null) goto L7;
        return this.mNetworkStatsManager;
    L7:
        throw new IllegalStateException("NetworkStatsManager is not ready");
    }

    private void initNetworkStatsManager() {
        this.mNetworkStatsManager = (NetworkStatsManager) this.mContext.getSystemService(NetworkStatsManager.class);
    }

    private void initAndRegisterNetworkStatsPullers() {
        Slog.d(TAG, "Registering NetworkStats pullers with statsd");
        boolean canQueryTypeProxy = canQueryNetworkStatsForTypeProxy();
        Object r1 = this.mDataBytesTransferLock;
        monitor-enter(r1);
        this.mNetworkStatsBaselines.addAll(collectNetworkStatsSnapshotForAtomLocked(10000));     // Catch: Throwable -> L7
        this.mNetworkStatsBaselines.addAll(collectNetworkStatsSnapshotForAtomLocked(10001));     // Catch: Throwable -> L7
        this.mNetworkStatsBaselines.addAll(collectNetworkStatsSnapshotForAtomLocked(10002));     // Catch: Throwable -> L7
        this.mNetworkStatsBaselines.addAll(collectNetworkStatsSnapshotForAtomLocked(10003));     // Catch: Throwable -> L7
        this.mNetworkStatsBaselines.addAll(collectNetworkStatsSnapshotForAtomLocked(FrameworkStatsLog.BYTES_TRANSFER_BY_TAG_AND_METERED));     // Catch: Throwable -> L7
        this.mNetworkStatsBaselines.addAll(collectNetworkStatsSnapshotForAtomLocked(FrameworkStatsLog.DATA_USAGE_BYTES_TRANSFER));     // Catch: Throwable -> L7
        this.mNetworkStatsBaselines.addAll(collectNetworkStatsSnapshotForAtomLocked(FrameworkStatsLog.OEM_MANAGED_BYTES_TRANSFER));     // Catch: Throwable -> L7
        if (canQueryTypeProxy == false) goto L9;
        this.mNetworkStatsBaselines.addAll(collectNetworkStatsSnapshotForAtomLocked(FrameworkStatsLog.PROXY_BYTES_TRANSFER_BY_FG_BG));     // Catch: Throwable -> L7
    L9:
        monitor-exit(r1);     // Catch: Throwable -> L7
        this.mSubscriptionManager.addOnSubscriptionsChangedListener(BackgroundThread.getExecutor(), this.mStatsSubscriptionsListener);
        registerWifiBytesTransfer();
        registerWifiBytesTransferBackground();
        registerMobileBytesTransfer();
        registerMobileBytesTransferBackground();
        if (ENABLE_MOBILE_DATA_STATS_AGGREGATED_PULLER == false) goto L13;
        initMobileDataStatsPuller();
        registerMobileBytesTransferByProcState();
    L13:
        registerBytesTransferByTagAndMetered();
        registerDataUsageBytesTransfer();
        registerOemManagedBytesTransfer();
        if (canQueryTypeProxy == false) goto L21;
        registerProxyBytesTransferBackground();
        return;
    L21:
        return;
    L7:
        th = move-exception;
        throw th;
    }

    private void registerMobileBytesTransferByProcState() {
        StatsManager.PullAtomMetadata metadata = new StatsManager.PullAtomMetadata.Builder().setAdditiveFields(new int[]{3, 4, 5, 6}).build();
        this.mStatsManager.setPullAtomCallback(FrameworkStatsLog.MOBILE_BYTES_TRANSFER_BY_PROC_STATE, metadata, ConcurrentUtils.DIRECT_EXECUTOR, this.mStatsCallbackImpl);
    }

    private void initAndRegisterDeferredPullers() {
        if (this.mContext.getPackageManager().hasSystemFeature("android.hardware.uwb") == false) goto L5;
        UwbManager r0 = (UwbManager) this.mContext.getSystemService(UwbManager.class);
    L6:
        this.mUwbManager = r0;
        registerUwbActivityInfo();
        return;
    L5:
        r0 = null;
        goto L6
    }

    private IThermalService getIThermalService() {
        Object r0 = this.mThermalLock;
        monitor-enter(r0);
    L10:
        th = move-exception;
        throw th;
    L5:
        if (this.mThermalService != null) goto L14;
        this.mThermalService = IThermalService.Stub.asInterface(ServiceManager.getService("thermalservice"));     // Catch: Throwable -> L10
        if (this.mThermalService == null) goto L14;
        this.mThermalService.asBinder().linkToDeath(new StatsPullAtomService$$ExternalSyntheticLambda25(this), 0);     // Catch: Throwable -> L10 RemoteException -> L12
    L12:
        e = move-exception;
        Slog.e(TAG, "linkToDeath with thermalService failed", e);     // Catch: Throwable -> L10
        this.mThermalService = null;     // Catch: Throwable -> L10
    L14:
        IThermalService r1 = this.mThermalService;     // Catch: Throwable -> L10
        monitor-exit(r0);     // Catch: Throwable -> L10
        return r1;
    }

    private /* synthetic */ void lambda$getIThermalService$2() {
        Object r0 = this.mThermalLock;
        monitor-enter(r0);
        this.mThermalService = null;     // Catch: Throwable -> L8
        monitor-exit(r0);     // Catch: Throwable -> L8
        return;
    L8:
        th = move-exception;
        throw th;
    }

    private IKeystoreMetrics getIKeystoreMetricsService() {
        Object r0 = this.mKeystoreLock;
        monitor-enter(r0);
    L10:
        th = move-exception;
        throw th;
    L5:
        if (this.mIKeystoreMetrics != null) goto L14;
        this.mIKeystoreMetrics = IKeystoreMetrics.Stub.asInterface(ServiceManager.getService("android.security.metrics"));     // Catch: Throwable -> L10
        if (this.mIKeystoreMetrics == null) goto L14;
        this.mIKeystoreMetrics.asBinder().linkToDeath(new StatsPullAtomService$$ExternalSyntheticLambda27(this), 0);     // Catch: Throwable -> L10 RemoteException -> L12
    L12:
        e = move-exception;
        Slog.e(TAG, "linkToDeath with IKeystoreMetrics failed", e);     // Catch: Throwable -> L10
        this.mIKeystoreMetrics = null;     // Catch: Throwable -> L10
    L14:
        IKeystoreMetrics r1 = this.mIKeystoreMetrics;     // Catch: Throwable -> L10
        monitor-exit(r0);     // Catch: Throwable -> L10
        return r1;
    }

    private /* synthetic */ void lambda$getIKeystoreMetricsService$3() {
        Object r0 = this.mKeystoreLock;
        monitor-enter(r0);
        this.mIKeystoreMetrics = null;     // Catch: Throwable -> L8
        monitor-exit(r0);     // Catch: Throwable -> L8
        return;
    L8:
        th = move-exception;
        throw th;
    }

    private IStoraged getIStoragedService() {
        Object r0 = this.mStoragedLock;
        monitor-enter(r0);
    L7:
        th = move-exception;
        throw th;
    L5:
        if (this.mStorageService != null) goto L10;
        this.mStorageService = IStoraged.Stub.asInterface(ServiceManager.getService("storaged"));     // Catch: Throwable -> L7
    L10:
        if (this.mStorageService != null) goto L22;
    L15:
        monitor-exit(r0);     // Catch: Throwable -> L7
        return this.mStorageService;
    L22:
        this.mStorageService.asBinder().linkToDeath(new StatsPullAtomService$$ExternalSyntheticLambda26(this), 0);     // Catch: Throwable -> L7 RemoteException -> L13
    L13:
        e = move-exception;
        Slog.e(TAG, "linkToDeath with storagedService failed", e);     // Catch: Throwable -> L7
        this.mStorageService = null;     // Catch: Throwable -> L7
        goto L15
    }

    private /* synthetic */ void lambda$getIStoragedService$4() {
        Object r0 = this.mStoragedLock;
        monitor-enter(r0);
        this.mStorageService = null;     // Catch: Throwable -> L8
        monitor-exit(r0);     // Catch: Throwable -> L8
        return;
    L8:
        th = move-exception;
        throw th;
    }

    private INotificationManager getINotificationManagerService() {
        Object r0 = this.mNotificationStatsLock;
        monitor-enter(r0);
    L7:
        th = move-exception;
        throw th;
    L5:
        if (this.mNotificationManagerService != null) goto L10;
        this.mNotificationManagerService = INotificationManager.Stub.asInterface(ServiceManager.getService("notification"));     // Catch: Throwable -> L7
    L10:
        if (this.mNotificationManagerService != null) goto L22;
    L15:
        monitor-exit(r0);     // Catch: Throwable -> L7
        return this.mNotificationManagerService;
    L22:
        this.mNotificationManagerService.asBinder().linkToDeath(new StatsPullAtomService$$ExternalSyntheticLambda9(this), 0);     // Catch: Throwable -> L7 RemoteException -> L13
    L13:
        e = move-exception;
        Slog.e(TAG, "linkToDeath with notificationManager failed", e);     // Catch: Throwable -> L7
        this.mNotificationManagerService = null;     // Catch: Throwable -> L7
        goto L15
    }

    private /* synthetic */ void lambda$getINotificationManagerService$5() {
        Object r0 = this.mNotificationStatsLock;
        monitor-enter(r0);
        this.mNotificationManagerService = null;     // Catch: Throwable -> L8
        monitor-exit(r0);     // Catch: Throwable -> L8
        return;
    L8:
        th = move-exception;
        throw th;
    }

    private IProcessStats getIProcessStatsService() {
        Object r0 = this.mProcStatsLock;
        monitor-enter(r0);
    L7:
        th = move-exception;
        throw th;
    L5:
        if (this.mProcessStatsService != null) goto L10;
        this.mProcessStatsService = IProcessStats.Stub.asInterface(ServiceManager.getService("procstats"));     // Catch: Throwable -> L7
    L10:
        if (this.mProcessStatsService != null) goto L22;
    L15:
        monitor-exit(r0);     // Catch: Throwable -> L7
        return this.mProcessStatsService;
    L22:
        this.mProcessStatsService.asBinder().linkToDeath(new StatsPullAtomService$$ExternalSyntheticLambda2(this), 0);     // Catch: Throwable -> L7 RemoteException -> L13
    L13:
        e = move-exception;
        Slog.e(TAG, "linkToDeath with ProcessStats failed", e);     // Catch: Throwable -> L7
        this.mProcessStatsService = null;     // Catch: Throwable -> L7
        goto L15
    }

    private /* synthetic */ void lambda$getIProcessStatsService$6() {
        Object r0 = this.mProcStatsLock;
        monitor-enter(r0);
        this.mProcessStatsService = null;     // Catch: Throwable -> L8
        monitor-exit(r0);     // Catch: Throwable -> L8
        return;
    L8:
        th = move-exception;
        throw th;
    }

    private void registerWifiBytesTransfer() {
        StatsManager.PullAtomMetadata metadata = new StatsManager.PullAtomMetadata.Builder().setAdditiveFields(new int[]{2, 3, 4, 5}).build();
        this.mStatsManager.setPullAtomCallback(10000, metadata, ConcurrentUtils.DIRECT_EXECUTOR, this.mStatsCallbackImpl);
    }

    private List<NetworkStatsExt> collectNetworkStatsSnapshotForAtomLocked(int atomTag) {
        List<NetworkStatsExt> ret = new ArrayList();
        switch(atomTag) {
            case 10000: goto L17;
            case 10001: goto L16;
            case 10002: goto L15;
            case 10003: goto L14;
            case 10082: goto L9;
            case 10083: goto L8;
            case 10100: goto L7;
            case 10200: goto L6;
            default: goto L5;
        };
    L6:
        NetworkStats stats = getUidNetworkStatsSnapshotForTemplateLocked(new NetworkTemplate.Builder(9).build(), false);
        ret.add(new NetworkStatsExt(sliceNetworkStatsByUidAndFgbg(stats), new int[]{2}, true, false, false, 0, null, -1, true));
    L18:
        return ret;
    L7:
        ret.addAll(getDataUsageBytesTransferSnapshotForOemManagedLocked());
        goto L18
    L8:
        NetworkStats wifiStats = getUidNetworkStatsSnapshotForTemplateLocked(new NetworkTemplate.Builder(4).build(), true);
        NetworkStats cellularStats = getUidNetworkStatsSnapshotForTemplateLocked(new NetworkTemplate.Builder(1).setMeteredness(1).build(), true);
        NetworkStats stats2 = wifiStats.add(cellularStats);
        ret.add(new NetworkStatsExt(sliceNetworkStatsByUidTagAndMetered(stats2), new int[]{1, 0}, false, true, true, 0, null, -1, false));
        goto L18
    L9:
        Iterator<SubInfo> r3 = this.mHistoricalSubs.iterator();
    L11:
        if (r3.hasNext() == false) goto L18;
        SubInfo subInfo = r3.next();
        ret.addAll(getDataUsageBytesTransferSnapshotForSubLocked(subInfo));
        goto L11
    L14:
        NetworkStats stats3 = getUidNetworkStatsSnapshotForTransportLocked(0);
        ret.add(new NetworkStatsExt(sliceNetworkStatsByUidAndFgbg(stats3), new int[]{0}, true));
        goto L18
    L15:
        NetworkStats stats4 = getUidNetworkStatsSnapshotForTransportLocked(0);
        ret.add(new NetworkStatsExt(sliceNetworkStatsByUid(stats4), new int[]{0}, false));
        goto L18
    L16:
        NetworkStats stats5 = getUidNetworkStatsSnapshotForTransportLocked(1);
        ret.add(new NetworkStatsExt(sliceNetworkStatsByUidAndFgbg(stats5), new int[]{1}, true));
        goto L18
    L17:
        NetworkStats stats6 = getUidNetworkStatsSnapshotForTransportLocked(1);
        ret.add(new NetworkStatsExt(sliceNetworkStatsByUid(stats6), new int[]{1}, false));
        goto L18
    L5:
        throw new IllegalArgumentException("Unknown atomTag " + atomTag);
    }

    private int pullDataBytesTransferLocked(int atomTag, List<StatsEvent> pulledData) {
        List<NetworkStatsExt> current = collectNetworkStatsSnapshotForAtomLocked(atomTag);
        int r4 = 1;
        if (current != null) goto L6;
        Slog.e(TAG, "current snapshot is null for " + atomTag + ", return.");
        return 1;
    L6:
        Iterator<NetworkStatsExt> r7 = current.iterator();
    L8:
        if (r7.hasNext() == false) goto L23;
        final NetworkStatsExt item = r7.next();
        NetworkStatsExt baseline = (NetworkStatsExt) CollectionUtils.find(this.mNetworkStatsBaselines, new StatsPullAtomService$$ExternalSyntheticLambda12(item));
        if (baseline == null) goto L11;
        current = current;
        NetworkStatsExt diff = new NetworkStatsExt(removeEmptyEntries(item.stats.subtract(baseline.stats)), item.transports, item.slicedByFgbg, item.slicedByTag, item.slicedByMetered, item.ratType, item.subInfo, item.oemManaged, item.isTypeProxy);
        if (diff.stats.iterator().hasNext() == false) goto L15;
        switch(atomTag) {
            case 10082: goto L20;
            case 10083: goto L19;
            case 10100: goto L18;
            default: goto L17;
        };
    L17:
        addNetworkStats(atomTag, pulledData, diff);
    L21:
        r4 = 1;
        goto L8
    L18:
        addOemDataUsageBytesTransferAtoms(diff, pulledData);
        goto L21
    L19:
        addBytesTransferByTagAndMeteredAtoms(diff, pulledData);
        goto L21
    L20:
        addDataUsageBytesTransferAtoms(diff, pulledData);
        goto L21
    L15:
        r4 = 1;
        goto L8
    L11:
        Slog.e(TAG, "baseline is null for " + atomTag + ", return.");
        return r4;
    L23:
        return 0;
    }

    private static /* synthetic */ boolean lambda$pullDataBytesTransferLocked$7(NetworkStatsExt item, NetworkStatsExt it) {
        return it.hasSameSlicing(item);
    }

    private static NetworkStats removeEmptyEntries(NetworkStats stats) {
        ArrayList<NetworkStats.Entry> entries = new ArrayList();
        Iterator r1 = stats.iterator();
    L4:
        if (r1.hasNext() == false) goto L18;
        NetworkStats.Entry e = (NetworkStats.Entry) r1.next();
        if (e.getRxBytes() != 0) goto L15;
        if (e.getRxPackets() != 0) goto L15;
        if (e.getTxBytes() != 0) goto L15;
        if (e.getTxPackets() != 0) goto L15;
        if (e.getOperations() == 0) goto L4;
    L15:
        entries.add(e);
        goto L4
    L18:
        if (NetworkStatsUtils.isAddEntriesSupported() == true) goto L20;
        NetworkStats outputStats = new NetworkStats(0, 1);
        Iterator<NetworkStats.Entry> r2 = entries.iterator();
    L23:
        if (r2.hasNext() == false) goto L25;
        outputStats = outputStats.addEntry(r2.next());
        goto L23
    L25:
        return outputStats;
    L20:
        return new NetworkStats(0, entries.size()).addEntries(entries);
    }

    private void addNetworkStats(int atomTag, List<StatsEvent> ret, NetworkStatsExt statsExt) {
        Iterator r1 = statsExt.stats.iterator();
    L4:
        if (r1.hasNext() == false) goto L16;
        NetworkStats.Entry entry = (NetworkStats.Entry) r1.next();
        if (statsExt.slicedByFgbg == false) goto L13;
        int r5 = entry.getUid();
        if (entry.getSet() <= 0) goto L11;
        boolean r3 = true;
    L10:
        boolean r6 = r3;
        StatsEvent statsEvent = FrameworkStatsLog.buildStatsEvent(atomTag, r5, r6, entry.getRxBytes(), entry.getRxPackets(), entry.getTxBytes(), entry.getTxPackets());
    L14:
        ret.add(statsEvent);
        goto L4
    L11:
        r3 = false;
        goto L10
    L13:
        statsEvent = FrameworkStatsLog.buildStatsEvent(atomTag, entry.getUid(), entry.getRxBytes(), entry.getRxPackets(), entry.getTxBytes(), entry.getTxPackets());
        goto L14
    }

    private void addBytesTransferByTagAndMeteredAtoms(NetworkStatsExt statsExt, List<StatsEvent> pulledData) {
        if (statsExt.ratType != (-2)) goto L5;
        boolean is5GNsa = true;
    L6:
        Iterator r2 = statsExt.stats.iterator();
    L8:
        if (r2.hasNext() == false) goto L20;
        NetworkStats.Entry entry = (NetworkStats.Entry) r2.next();
        int r7 = entry.getUid();
        if (entry.getMetered() != 1) goto L12;
        boolean r8 = true;
    L13:
        int r9 = entry.getTag();
        long r10 = entry.getRxBytes();
        long r12 = entry.getRxPackets();
        long r14 = entry.getTxBytes();
        long r16 = entry.getTxPackets();
        if (is5GNsa == false) goto L17;
        int r6 = 13;
    L18:
        pulledData.add(FrameworkStatsLog.buildStatsEvent(FrameworkStatsLog.BYTES_TRANSFER_BY_TAG_AND_METERED, r7, r8, r9, r10, r12, r14, r16, r6));
        goto L8
    L17:
        r6 = statsExt.ratType;
        goto L18
    L12:
        r8 = false;
        goto L13
    L20:
        return;
    L5:
        is5GNsa = false;
        goto L6
    }

    private void addDataUsageBytesTransferAtoms(NetworkStatsExt statsExt, List<StatsEvent> pulledData) {
        boolean r3 = false;
        if (statsExt.ratType != (-2)) goto L5;
        boolean is5GNsa = true;
    L6:
        if (is5GNsa == false) goto L8;
    L9:
        r3 = true;
    L10:
        boolean isNR = r3;
        Iterator r2 = statsExt.stats.iterator();
    L12:
        if (r2.hasNext() == false) goto L23;
        NetworkStats.Entry entry = (NetworkStats.Entry) r2.next();
        int r5 = entry.getSet();
        long r6 = entry.getRxBytes();
        long r8 = entry.getRxPackets();
        long r10 = entry.getTxBytes();
        long r12 = entry.getTxPackets();
        if (is5GNsa == false) goto L17;
        int r4 = 13;
    L16:
        int r14 = r4;
        String r15 = statsExt.subInfo.mcc;
        String r7 = statsExt.subInfo.mnc;
        boolean is5GNsa2 = is5GNsa;
        int r1 = statsExt.subInfo.carrierId;
        if (statsExt.subInfo.isOpportunistic == false) goto L21;
        int r9 = 2;
    L22:
        pulledData.add(FrameworkStatsLog.buildStatsEvent(FrameworkStatsLog.DATA_USAGE_BYTES_TRANSFER, r5, r6, r8, r10, r12, r14, r15, r7, r1, r9, isNR));
        is5GNsa = is5GNsa2;
        goto L12
    L21:
        r9 = 3;
        goto L22
    L17:
        r4 = statsExt.ratType;
        goto L16
    L23:
        return;
    L8:
        if (statsExt.ratType != 20) goto L10;
    L5:
        is5GNsa = false;
        goto L6
    }

    private void addOemDataUsageBytesTransferAtoms(NetworkStatsExt statsExt, List<StatsEvent> pulledData) {
        int oemManaged = statsExt.oemManaged;
        int[] r14 = statsExt.transports;
        int r15 = r14.length;
        int r1 = 0;
    L3:
        if (r1 >= r15) goto L14;
        int transport = r14[r1];
        Iterator r17 = statsExt.stats.iterator();
    L6:
        if (r17.hasNext() == false) goto L12;
        NetworkStats.Entry entry = (NetworkStats.Entry) r17.next();
        int r2 = entry.getUid();
        if (entry.getSet() <= 0) goto L10;
        boolean r3 = true;
    L11:
        pulledData.add(FrameworkStatsLog.buildStatsEvent(FrameworkStatsLog.OEM_MANAGED_BYTES_TRANSFER, r2, r3, oemManaged, transport, entry.getRxBytes(), entry.getRxPackets(), entry.getTxBytes(), entry.getTxPackets()));
        r1 = r1;
        goto L6
    L10:
        r3 = false;
        goto L11
    L12:
        r1 = r1 + 1;
        goto L3
    }

    private List<NetworkStatsExt> getDataUsageBytesTransferSnapshotForOemManagedLocked() {
        List<Pair<Integer, Integer>> matchRulesAndTransports = List.of(new Pair(5, 3), new Pair(1, 0), new Pair(4, 1));
        int[] oemManagedTypes = {3, 1, 2};
        List<NetworkStatsExt> ret = new ArrayList();
        Iterator<Pair<Integer, Integer>> r4 = matchRulesAndTransports.iterator();
    L4:
        if (r4.hasNext() == false) goto L10;
        Pair<Integer, Integer> ruleAndTransport = r4.next();
        Integer matchRule = (Integer) ruleAndTransport.first;
        int r8 = oemManagedTypes.length;
        int r9 = 0;
    L7:
        if (r9 >= r8) goto L4;
        int oemManaged = oemManagedTypes[r9];
        NetworkTemplate template = new NetworkTemplate.Builder(matchRule.intValue()).setOemManaged(oemManaged).build();
        NetworkStats stats = getUidNetworkStatsSnapshotForTemplateLocked(template, false);
        Integer transport = (Integer) ruleAndTransport.second;
        ret.add(new NetworkStatsExt(sliceNetworkStatsByUidAndFgbg(stats), new int[]{transport.intValue()}, true, false, false, 0, null, oemManaged, false));
        r9 = r9 + 1;
        goto L7
    L10:
        return ret;
    }

    private NetworkStats getUidNetworkStatsSnapshotForTransportLocked(int transport) {
        NetworkTemplate template = null;
        switch(transport) {
            case 0: goto L6;
            case 1: goto L5;
            default: goto L4;
        };
    L4:
        Log.wtf(TAG, "Unexpected transport.");
    L8:
        return getUidNetworkStatsSnapshotForTemplateLocked(template, false);
    L5:
        template = new NetworkTemplate.Builder(4).build();
        goto L8
    L6:
        template = new NetworkTemplate.Builder(1).setMeteredness(1).build();
        goto L8
    }

    private static boolean canQueryNetworkStatsForTypeProxy() {
        new NetworkTemplate.Builder(9).build();     // Catch: IllegalArgumentException -> L5
        return true;
    L6:
        Slog.w(TAG, "Querying network stats for TYPE_PROXY is not allowed");
        return false;
    }

    private NetworkStats getUidNetworkStatsSnapshotForTemplateLocked(final NetworkTemplate template, final boolean includeTags) {
        long elapsedMillisSinceBoot = SystemClock.elapsedRealtime();
        long currentTimeMillis = TimeUnit.MICROSECONDS.toMillis(SystemClock.currentTimeMicro());
        long bootTimeMillis = currentTimeMillis - elapsedMillisSinceBoot;
        long bucketDurationMillis = Settings.Global.getLong(this.mContext.getContentResolver(), "netstats_uid_bucket_duration", NETSTATS_UID_DEFAULT_BUCKET_DURATION_MS);
        NetworkStatsAccumulator accumulator = (NetworkStatsAccumulator) CollectionUtils.find(this.mNetworkStatsAccumulators, new StatsPullAtomService$$ExternalSyntheticLambda10(template, includeTags));
        if (accumulator != null) goto L6;
        accumulator = new NetworkStatsAccumulator(template, includeTags, bucketDurationMillis, bootTimeMillis - bucketDurationMillis);
        this.mNetworkStatsAccumulators.add(accumulator);
    L6:
        return accumulator.queryStats(currentTimeMillis, new StatsPullAtomService$$ExternalSyntheticLambda11(this));
    }

    private static /* synthetic */ boolean lambda$getUidNetworkStatsSnapshotForTemplateLocked$8(NetworkTemplate template, boolean includeTags, NetworkStatsAccumulator it) {
        return it.hasEqualParameters(template, includeTags);
    }

    private /* synthetic */ NetworkStats lambda$getUidNetworkStatsSnapshotForTemplateLocked$9(NetworkTemplate aTemplate, boolean aIncludeTags, long aStartTime, long aEndTime) {
        Object r1 = this.mDataBytesTransferLock;
        monitor-enter(r1);
        NetworkStats r0 = getUidNetworkStatsSnapshotForTemplateLocked(aTemplate, aIncludeTags, aStartTime, aEndTime);     // Catch: Throwable -> L7
        monitor-exit(r1);     // Catch: Throwable -> L7
        return r0;
    L7:
        th = move-exception;
        throw th;
    }

    private NetworkStats getUidNetworkStatsSnapshotForTemplateLocked(NetworkTemplate template, boolean includeTags, long startTime, long endTime) {
        long elapsedMillisSinceBoot = SystemClock.elapsedRealtime();
        if ((elapsedMillisSinceBoot - this.mLastNetworkStatsPollTime) < NETSTATS_POLL_RATE_LIMIT_MS) goto L5;
        this.mLastNetworkStatsPollTime = elapsedMillisSinceBoot;
        getNetworkStatsManager().forceUpdate();
    L5:
        android.app.usage.NetworkStats queryNonTaggedStats = getNetworkStatsManager().querySummary(template, startTime, endTime);
        NetworkStats nonTaggedStats = NetworkStatsUtils.fromPublicNetworkStats(queryNonTaggedStats);
        queryNonTaggedStats.close();
        if (includeTags == true) goto L8;
        return nonTaggedStats;
    L8:
        android.app.usage.NetworkStats queryTaggedStats = getNetworkStatsManager().queryTaggedSummary(template, startTime, endTime);
        NetworkStats taggedStats = NetworkStatsUtils.fromPublicNetworkStats(queryTaggedStats);
        queryTaggedStats.close();
        return nonTaggedStats.add(taggedStats);
    }

    private List<NetworkStatsExt> getDataUsageBytesTransferSnapshotForSubLocked(SubInfo subInfo) {
        List<NetworkStatsExt> ret = new ArrayList();
        int[] r2 = getAllCollapsedRatTypes();
        int r3 = r2.length;
        int r5 = 0;
    L3:
        if (r5 >= r3) goto L5;
        int ratType = r2[r5];
        NetworkTemplate template = new NetworkTemplate.Builder(1).setSubscriberIds(Set.of(subInfo.subscriberId)).setRatType(ratType).setMeteredness(1).build();
        NetworkStats stats = getUidNetworkStatsSnapshotForTemplateLocked(template, false);
        ret.add(new NetworkStatsExt(sliceNetworkStatsByFgbg(stats), new int[]{0}, true, false, false, ratType, subInfo, -1, false));
        r5 = r5 + 1;
        goto L3
    L5:
        return ret;
    }

    private static int[] getAllCollapsedRatTypes() {
        int[] ratTypes = TelephonyManager.getAllNetworkTypes();
        HashSet<Integer> collapsedRatTypes = new HashSet();
        int r2 = ratTypes.length;
        int r4 = 0;
    L3:
        if (r4 >= r2) goto L5;
        int ratType = ratTypes[r4];
        collapsedRatTypes.add(Integer.valueOf(NetworkStatsManager.getCollapsedRatType(ratType)));
        r4 = r4 + 1;
        goto L3
    L5:
        collapsedRatTypes.add(Integer.valueOf(NetworkStatsManager.getCollapsedRatType(-2)));
        collapsedRatTypes.add(0);
        return com.android.net.module.util.CollectionUtils.toIntArray(collapsedRatTypes);
    }

    private NetworkStats sliceNetworkStatsByUid(NetworkStats stats) {
        return sliceNetworkStats(stats, new StatsPullAtomService$$ExternalSyntheticLambda1());
    }

    private static /* synthetic */ NetworkStats.Entry lambda$sliceNetworkStatsByUid$10(NetworkStats.Entry entry) {
        return new NetworkStats.Entry(null, entry.getUid(), -1, 0, -1, -1, -1, entry.getRxBytes(), entry.getRxPackets(), entry.getTxBytes(), entry.getTxPackets(), 0);
    }

    private NetworkStats sliceNetworkStatsByFgbg(NetworkStats stats) {
        return sliceNetworkStats(stats, new StatsPullAtomService$$ExternalSyntheticLambda21());
    }

    private static /* synthetic */ NetworkStats.Entry lambda$sliceNetworkStatsByFgbg$11(NetworkStats.Entry entry) {
        return new NetworkStats.Entry(null, -1, entry.getSet(), 0, -1, -1, -1, entry.getRxBytes(), entry.getRxPackets(), entry.getTxBytes(), entry.getTxPackets(), 0);
    }

    private NetworkStats sliceNetworkStatsByUidAndFgbg(NetworkStats stats) {
        return sliceNetworkStats(stats, new StatsPullAtomService$$ExternalSyntheticLambda22());
    }

    private static /* synthetic */ NetworkStats.Entry lambda$sliceNetworkStatsByUidAndFgbg$12(NetworkStats.Entry entry) {
        return new NetworkStats.Entry(null, entry.getUid(), entry.getSet(), 0, -1, -1, -1, entry.getRxBytes(), entry.getRxPackets(), entry.getTxBytes(), entry.getTxPackets(), 0);
    }

    private NetworkStats sliceNetworkStatsByUidTagAndMetered(NetworkStats stats) {
        return sliceNetworkStats(stats, new StatsPullAtomService$$ExternalSyntheticLambda8());
    }

    private static /* synthetic */ NetworkStats.Entry lambda$sliceNetworkStatsByUidTagAndMetered$13(NetworkStats.Entry entry) {
        return new NetworkStats.Entry(null, entry.getUid(), -1, entry.getTag(), entry.getMetered(), -1, -1, entry.getRxBytes(), entry.getRxPackets(), entry.getTxBytes(), entry.getTxPackets(), 0);
    }

    private NetworkStats sliceNetworkStats(NetworkStats stats, Function<NetworkStats.Entry, NetworkStats.Entry> slicer) {
        ArrayList<NetworkStats.Entry> entries = new ArrayList();
        Iterator r1 = stats.iterator();
    L4:
        if (r1.hasNext() == false) goto L7;
        NetworkStats.Entry e = (NetworkStats.Entry) r1.next();
        entries.add(slicer.apply(e));
        goto L4
    L7:
        if (NetworkStatsUtils.isAddEntriesSupported() == true) goto L9;
        NetworkStats outputStats = new NetworkStats(0, 1);
        Iterator<NetworkStats.Entry> r2 = entries.iterator();
    L12:
        if (r2.hasNext() == false) goto L14;
        NetworkStats.Entry e2 = r2.next();
        outputStats = outputStats.addEntry(e2);
        goto L12
    L14:
        return outputStats;
    L9:
        return new NetworkStats(0, entries.size()).addEntries(entries);
    }

    private void registerWifiBytesTransferBackground() {
        StatsManager.PullAtomMetadata metadata = new StatsManager.PullAtomMetadata.Builder().setAdditiveFields(new int[]{3, 4, 5, 6}).build();
        this.mStatsManager.setPullAtomCallback(10001, metadata, ConcurrentUtils.DIRECT_EXECUTOR, this.mStatsCallbackImpl);
    }

    private void registerMobileBytesTransfer() {
        StatsManager.PullAtomMetadata metadata = new StatsManager.PullAtomMetadata.Builder().setAdditiveFields(new int[]{2, 3, 4, 5}).build();
        this.mStatsManager.setPullAtomCallback(10002, metadata, ConcurrentUtils.DIRECT_EXECUTOR, this.mStatsCallbackImpl);
    }

    private void registerMobileBytesTransferBackground() {
        StatsManager.PullAtomMetadata metadata = new StatsManager.PullAtomMetadata.Builder().setAdditiveFields(new int[]{3, 4, 5, 6}).build();
        this.mStatsManager.setPullAtomCallback(10003, metadata, ConcurrentUtils.DIRECT_EXECUTOR, this.mStatsCallbackImpl);
    }

    private void registerProxyBytesTransferBackground() {
        StatsManager.PullAtomMetadata metadata = new StatsManager.PullAtomMetadata.Builder().setAdditiveFields(new int[]{3, 4, 5, 6}).build();
        this.mStatsManager.setPullAtomCallback(FrameworkStatsLog.PROXY_BYTES_TRANSFER_BY_FG_BG, metadata, ConcurrentUtils.DIRECT_EXECUTOR, this.mStatsCallbackImpl);
    }

    private void registerBytesTransferByTagAndMetered() {
        StatsManager.PullAtomMetadata metadata = new StatsManager.PullAtomMetadata.Builder().setAdditiveFields(new int[]{4, 5, 6, 7}).build();
        this.mStatsManager.setPullAtomCallback(FrameworkStatsLog.BYTES_TRANSFER_BY_TAG_AND_METERED, metadata, ConcurrentUtils.DIRECT_EXECUTOR, this.mStatsCallbackImpl);
    }

    private void registerDataUsageBytesTransfer() {
        StatsManager.PullAtomMetadata metadata = new StatsManager.PullAtomMetadata.Builder().setAdditiveFields(new int[]{2, 3, 4, 5}).build();
        this.mStatsManager.setPullAtomCallback(FrameworkStatsLog.DATA_USAGE_BYTES_TRANSFER, metadata, ConcurrentUtils.DIRECT_EXECUTOR, this.mStatsCallbackImpl);
    }

    private void registerOemManagedBytesTransfer() {
        StatsManager.PullAtomMetadata metadata = new StatsManager.PullAtomMetadata.Builder().setAdditiveFields(new int[]{5, 6, 7, 8}).build();
        this.mStatsManager.setPullAtomCallback(FrameworkStatsLog.OEM_MANAGED_BYTES_TRANSFER, metadata, ConcurrentUtils.DIRECT_EXECUTOR, this.mStatsCallbackImpl);
    }

    private void registerBluetoothBytesTransfer() {
        StatsManager.PullAtomMetadata metadata = new StatsManager.PullAtomMetadata.Builder().setAdditiveFields(new int[]{2, 3}).build();
        this.mStatsManager.setPullAtomCallback(FrameworkStatsLog.BLUETOOTH_BYTES_TRANSFER, metadata, ConcurrentUtils.DIRECT_EXECUTOR, this.mStatsCallbackImpl);
    }

    private static <T extends Parcelable> T awaitControllerInfo(SynchronousResultReceiver r4) {
        if (r4 != null) goto L16;
        return null;
    L16:
        SynchronousResultReceiver.Result r1 = r4.awaitResult(2000);     // Catch: TimeoutException -> L11
        if (r1.bundle == null) goto L15;
        r1.bundle.setDefusable(true);     // Catch: TimeoutException -> L11
        T r2 = (T) r1.bundle.getParcelable(RESULT_RECEIVER_CONTROLLER_KEY);
        if (r2 == null) goto L15;
        return r2;
    L15:
        return null;
    L14:
        Slog.w(TAG, "timeout reading " + r4.getName() + " stats");
        goto L15
    }

    private BluetoothActivityEnergyInfo fetchBluetoothData() {
        BluetoothAdapter adapter = BluetoothAdapter.getDefaultAdapter();
        if (adapter == null) goto L6;
        final SynchronousResultReceiver bluetoothReceiver = new SynchronousResultReceiver("bluetooth");
        adapter.requestControllerActivityEnergyInfo(new SystemServerInitThreadPool$$ExternalSyntheticLambda0(), new AnonymousClass1(this, bluetoothReceiver));
        return awaitControllerInfo(bluetoothReceiver);
    L6:
        Slog.e(TAG, "Failed to get bluetooth adapter!");
        return null;
    }

    int pullBluetoothBytesTransferLocked(int atomTag, List<StatsEvent> pulledData) {
        BluetoothActivityEnergyInfo info = fetchBluetoothData();
        if (info != null) goto L6;
        return 1;
    L6:
        Iterator r1 = info.getUidTraffic().iterator();
    L8:
        if (r1.hasNext() == false) goto L11;
        UidTraffic traffic = (UidTraffic) r1.next();
        int atomTag2 = atomTag;
        pulledData.add(FrameworkStatsLog.buildStatsEvent(atomTag2, traffic.getUid(), traffic.getRxBytes(), traffic.getTxBytes()));
        atomTag = atomTag2;
        goto L8
    L11:
        return 0;
    }

    private void registerKernelWakelock() {
        this.mStatsManager.setPullAtomCallback(10004, null, ConcurrentUtils.DIRECT_EXECUTOR, this.mStatsCallbackImpl);
    }

    int pullKernelWakelockLocked(int atomTag, List<StatsEvent> pulledData) {
        KernelWakelockStats wakelockStats = this.mKernelWakelockReader.readKernelWakelockStats(this.mTmpWakelockStats);
        Iterator<Map.Entry<String, KernelWakelockStats.Entry>> r1 = wakelockStats.entrySet().iterator();
    L4:
        if (r1.hasNext() == false) goto L7;
        Map.Entry<String, KernelWakelockStats.Entry> ent = r1.next();
        String name = ent.getKey();
        KernelWakelockStats.Entry kws = ent.getValue();
        int atomTag2 = atomTag;
        pulledData.add(FrameworkStatsLog.buildStatsEvent(atomTag2, name, kws.count, kws.version, kws.totalTimeUs));
        atomTag = atomTag2;
        goto L4
    L7:
        return 0;
    }

    private void registerCpuTimePerClusterFreq() {
        if (KernelCpuBpfTracking.isSupported() == false) goto L6;
        StatsManager.PullAtomMetadata metadata = new StatsManager.PullAtomMetadata.Builder().setAdditiveFields(new int[]{3}).build();
        this.mStatsManager.setPullAtomCallback(FrameworkStatsLog.CPU_TIME_PER_CLUSTER_FREQ, metadata, ConcurrentUtils.DIRECT_EXECUTOR, this.mStatsCallbackImpl);
        return;
    }

    int pullCpuTimePerClusterFreqLocked(int atomTag, List<StatsEvent> pulledData) {
        int[] freqsClusters = KernelCpuBpfTracking.getFreqsClusters();
        long[] freqs = KernelCpuBpfTracking.getFreqs();
        long[] timesMs = KernelCpuTotalBpfMapReader.read();
        if (timesMs != null) goto L6;
        return 1;
    L6:
        int freqIndex = 0;
    L8:
        if (freqIndex >= timesMs.length) goto L10;
        int cluster = freqsClusters[freqIndex];
        int freq = (int) freqs[freqIndex];
        long timeMs = timesMs[freqIndex];
        pulledData.add(FrameworkStatsLog.buildStatsEvent(atomTag, cluster, freq, timeMs));
        freqIndex = freqIndex + 1;
        goto L8
    L10:
        return 0;
    }

    private void registerCpuTimePerUid() {
        StatsManager.PullAtomMetadata metadata = new StatsManager.PullAtomMetadata.Builder().setAdditiveFields(new int[]{2, 3}).build();
        this.mStatsManager.setPullAtomCallback(FrameworkStatsLog.CPU_TIME_PER_UID, metadata, ConcurrentUtils.DIRECT_EXECUTOR, this.mStatsCallbackImpl);
    }

    int pullCpuTimePerUidLocked(final int atomTag, final List<StatsEvent> pulledData) {
        this.mCpuUidUserSysTimeReader.readAbsolute(new StatsPullAtomService$$ExternalSyntheticLambda17(pulledData, atomTag));
        return 0;
    }

    private static /* synthetic */ void lambda$pullCpuTimePerUidLocked$14(List pulledData, int atomTag, int uid, long[] timesUs) {
        long userTimeUs = timesUs[0];
        long systemTimeUs = timesUs[1];
        pulledData.add(FrameworkStatsLog.buildStatsEvent(atomTag, uid, userTimeUs, systemTimeUs));
    }

    private void registerCpuCyclesPerUidCluster() {
        if (KernelCpuBpfTracking.isSupported() == false) goto L5;
    L6:
        StatsManager.PullAtomMetadata metadata = new StatsManager.PullAtomMetadata.Builder().setAdditiveFields(new int[]{3, 4, 5}).build();
        this.mStatsManager.setPullAtomCallback(FrameworkStatsLog.CPU_CYCLES_PER_UID_CLUSTER, metadata, ConcurrentUtils.DIRECT_EXECUTOR, this.mStatsCallbackImpl);
        return;
    L5:
        if (KernelCpuBpfTracking.getClusters() > 0) goto L6;
    }

    int pullCpuCyclesPerUidClusterLocked(int atomTag, List<StatsEvent> pulledData) {
        PowerProfile powerProfile = new PowerProfile(this.mContext);
        final int[] freqsClusters = KernelCpuBpfTracking.getFreqsClusters();
        final int clusters = KernelCpuBpfTracking.getClusters();
        final long[] freqs = KernelCpuBpfTracking.getFreqs();
        final double[] freqsPowers = new double[freqs.length];
        int freqClusterIndex = 0;
        int lastCluster = -1;
        int freqIndex = 0;
    L4:
        if (freqIndex >= freqs.length) goto L9;
        int cluster = freqsClusters[freqIndex];
        if (cluster == lastCluster) goto L8;
        freqClusterIndex = 0;
    L8:
        lastCluster = cluster;
        freqsPowers[freqIndex] = powerProfile.getAveragePowerForCpuCore(cluster, freqClusterIndex);
        freqIndex = freqIndex + 1;
        freqClusterIndex = freqClusterIndex + 1;
        goto L4
    L9:
        final SparseArray<double[]> aggregated = new SparseArray();
        this.mCpuUidFreqTimeReader.readAbsolute(new StatsPullAtomService$$ExternalSyntheticLambda13(aggregated, clusters, freqsClusters, freqs, freqsPowers));
        int size = aggregated.size();
        int i = 0;
    L10:
        if (i >= size) goto L15;
        int uid = aggregated.keyAt(i);
        double[] values = aggregated.valueAt(i);
        int cluster2 = 0;
    L12:
        if (cluster2 >= clusters) goto L14;
        pulledData.add(FrameworkStatsLog.buildStatsEvent(atomTag, uid, cluster2, (long) (values[cluster2 * 3] / 1000000.0d), (long) values[(cluster2 * 3) + 1], (long) (values[(cluster2 * 3) + 2] / 1000.0d)));
        cluster2 = cluster2 + 1;
        powerProfile = powerProfile;
        goto L12
    L14:
        i = i + 1;
        powerProfile = powerProfile;
        goto L10
    L15:
        return 0;
    }

    private static /* synthetic */ void lambda$pullCpuCyclesPerUidClusterLocked$15(SparseArray aggregated, int clusters, int[] freqsClusters, long[] freqs, double[] freqsPowers, int uid, long[] cpuFreqTimeMs) {
        if (UserHandle.isIsolated(uid) == false) goto L6;
        return;
    L6:
        if (UserHandle.isSharedAppGid(uid) == false) goto L8;
        int uid2 = 59999;
    L9:
        double[] values = (double[]) aggregated.get(uid2);
        if (values != null) goto L12;
        values = new double[clusters * 3];
        aggregated.put(uid2, values);
    L12:
        int freqIndex = 0;
    L14:
        if (freqIndex >= cpuFreqTimeMs.length) goto L17;
        int cluster = freqsClusters[freqIndex];
        long timeMs = cpuFreqTimeMs[freqIndex];
        int r7 = cluster * 3;
        values[r7] = values[r7] + (freqs[freqIndex] * timeMs);
        int r8 = (cluster * 3) + 1;
        values[r8] = values[r8] + timeMs;
        int r9 = (cluster * 3) + 2;
        values[r9] = values[r9] + (freqsPowers[freqIndex] * timeMs);
        freqIndex = freqIndex + 1;
        goto L14
    L17:
        return;
    L8:
        uid2 = UserHandle.getAppId(uid);
        goto L9
    }

    private void registerCpuTimePerUidFreq() {
        StatsManager.PullAtomMetadata metadata = new StatsManager.PullAtomMetadata.Builder().setAdditiveFields(new int[]{3}).build();
        this.mStatsManager.setPullAtomCallback(FrameworkStatsLog.CPU_TIME_PER_UID_FREQ, metadata, ConcurrentUtils.DIRECT_EXECUTOR, this.mStatsCallbackImpl);
    }

    int pullCpuTimePerUidFreqLocked(int atomTag, List<StatsEvent> pulledData) {
        final SparseArray<long[]> aggregated = new SparseArray();
        this.mCpuUidFreqTimeReader.readAbsolute(new StatsPullAtomService$$ExternalSyntheticLambda19(aggregated));
        int size = aggregated.size();
        int i = 0;
    L3:
        if (i >= size) goto L12;
        int uid = aggregated.keyAt(i);
        long[] aggCpuFreqTimeMs = aggregated.valueAt(i);
        int freqIndex = 0;
    L6:
        if (freqIndex >= aggCpuFreqTimeMs.length) goto L11;
        if (aggCpuFreqTimeMs[freqIndex] < 10) goto L10;
        pulledData.add(FrameworkStatsLog.buildStatsEvent(atomTag, uid, freqIndex, aggCpuFreqTimeMs[freqIndex]));
    L10:
        freqIndex = freqIndex + 1;
        goto L6
    L11:
        i = i + 1;
        goto L3
    L12:
        return 0;
    }

    private static /* synthetic */ void lambda$pullCpuTimePerUidFreqLocked$16(SparseArray aggregated, int uid, long[] cpuFreqTimeMs) {
        if (UserHandle.isIsolated(uid) == false) goto L6;
        return;
    L6:
        if (UserHandle.isSharedAppGid(uid) == false) goto L8;
        int uid2 = 59999;
    L9:
        long[] aggCpuFreqTimeMs = (long[]) aggregated.get(uid2);
        if (aggCpuFreqTimeMs != null) goto L12;
        aggCpuFreqTimeMs = new long[cpuFreqTimeMs.length];
        aggregated.put(uid2, aggCpuFreqTimeMs);
    L12:
        int freqIndex = 0;
    L14:
        if (freqIndex >= cpuFreqTimeMs.length) goto L17;
        aggCpuFreqTimeMs[freqIndex] = aggCpuFreqTimeMs[freqIndex] + cpuFreqTimeMs[freqIndex];
        freqIndex = freqIndex + 1;
        goto L14
    L17:
        return;
    L8:
        uid2 = UserHandle.getAppId(uid);
        goto L9
    }

    private void registerCpuCyclesPerThreadGroupCluster() {
        if (KernelCpuBpfTracking.isSupported() == true) goto L4;
    }

    int pullCpuCyclesPerThreadGroupCluster(int atomTag, List<StatsEvent> pulledData) {
        return 1;
    }

    private static void addCpuCyclesPerThreadGroupClusterAtoms(int atomTag, List<StatsEvent> pulledData, int threadGroup, long[] cpuTimesUs) {
        int[] freqsClusters = KernelCpuBpfTracking.getFreqsClusters();
        int clusters = KernelCpuBpfTracking.getClusters();
        long[] freqs = KernelCpuBpfTracking.getFreqs();
        long[] aggregatedCycles = new long[clusters];
        long[] aggregatedTimesUs = new long[clusters];
        int i = 0;
    L4:
        if (i >= cpuTimesUs.length) goto L6;
        int r7 = freqsClusters[i];
        aggregatedCycles[r7] = aggregatedCycles[r7] + ((freqs[i] * cpuTimesUs[i]) / 1000);
        int r8 = freqsClusters[i];
        aggregatedTimesUs[r8] = aggregatedTimesUs[r8] + cpuTimesUs[i];
        i = i + 1;
        goto L4
    L6:
        int cluster = 0;
    L7:
        if (cluster >= clusters) goto L10;
        pulledData.add(FrameworkStatsLog.buildStatsEvent(atomTag, threadGroup, cluster, aggregatedCycles[cluster] / 1000000, aggregatedTimesUs[cluster] / 1000));
        cluster = cluster + 1;
        goto L7
    }

    private void registerCpuActiveTime() {
        StatsManager.PullAtomMetadata metadata = new StatsManager.PullAtomMetadata.Builder().setAdditiveFields(new int[]{2}).build();
        this.mStatsManager.setPullAtomCallback(FrameworkStatsLog.CPU_ACTIVE_TIME, metadata, ConcurrentUtils.DIRECT_EXECUTOR, this.mStatsCallbackImpl);
    }

    int pullCpuActiveTimeLocked(final int atomTag, final List<StatsEvent> pulledData) {
        this.mCpuUidActiveTimeReader.readAbsolute(new StatsPullAtomService$$ExternalSyntheticLambda7(pulledData, atomTag));
        return 0;
    }

    private static /* synthetic */ void lambda$pullCpuActiveTimeLocked$17(List pulledData, int atomTag, int uid, Long cpuActiveTimesMs) {
        pulledData.add(FrameworkStatsLog.buildStatsEvent(atomTag, uid, cpuActiveTimesMs.longValue()));
    }

    private void registerCpuClusterTime() {
        StatsManager.PullAtomMetadata metadata = new StatsManager.PullAtomMetadata.Builder().setAdditiveFields(new int[]{3}).build();
        this.mStatsManager.setPullAtomCallback(FrameworkStatsLog.CPU_CLUSTER_TIME, metadata, ConcurrentUtils.DIRECT_EXECUTOR, this.mStatsCallbackImpl);
    }

    int pullCpuClusterTimeLocked(final int atomTag, final List<StatsEvent> pulledData) {
        this.mCpuUidClusterTimeReader.readAbsolute(new StatsPullAtomService$$ExternalSyntheticLambda30(pulledData, atomTag));
        return 0;
    }

    private static /* synthetic */ void lambda$pullCpuClusterTimeLocked$18(List pulledData, int atomTag, int uid, long[] cpuClusterTimesMs) {
        int i = 0;
    L4:
        if (i >= cpuClusterTimesMs.length) goto L7;
        pulledData.add(FrameworkStatsLog.buildStatsEvent(atomTag, uid, i, cpuClusterTimesMs[i]));
        i = i + 1;
        goto L4
    }

    private void registerWifiActivityInfo() {
        this.mStatsManager.setPullAtomCallback(FrameworkStatsLog.WIFI_ACTIVITY_INFO, null, ConcurrentUtils.DIRECT_EXECUTOR, this.mStatsCallbackImpl);
    }

    int pullWifiActivityInfoLocked(int atomTag, List<StatsEvent> pulledData) {
        long token = Binder.clearCallingIdentity();
        final SynchronousResultReceiver wifiReceiver = new SynchronousResultReceiver("wifi");     // Catch: Throwable -> L17 RuntimeException -> L19
        this.mWifiManager.getWifiActivityEnergyInfoAsync(new AnonymousClass2(this), new StatsPullAtomService$$ExternalSyntheticLambda6(wifiReceiver));     // Catch: Throwable -> L17 RuntimeException -> L19
        WifiActivityEnergyInfo wifiInfo = awaitControllerInfo(wifiReceiver);     // Catch: Throwable -> L17 RuntimeException -> L19
        if (wifiInfo != null) goto L8;
        Binder.restoreCallingIdentity(token);
        return 1;
    L8:
    L27:
        pulledData.add(FrameworkStatsLog.buildStatsEvent(atomTag, wifiInfo.getTimeSinceBootMillis(), wifiInfo.getStackState(), wifiInfo.getControllerTxDurationMillis(), wifiInfo.getControllerRxDurationMillis(), wifiInfo.getControllerIdleDurationMillis(), wifiInfo.getControllerEnergyUsedMicroJoules()));     // Catch: Throwable -> L13 RuntimeException -> L15
        Binder.restoreCallingIdentity(token);
        return 0;
    L15:
        e = e;
    L22:
        Slog.e(TAG, "failed to getWifiActivityEnergyInfoAsync", e);     // Catch: Throwable -> L13
        Binder.restoreCallingIdentity(token);
        return 1;
    L13:
        e = th;
    L25:
        Binder.restoreCallingIdentity(token);
        throw e;
    L19:
        e = e;
    L17:
        e = th;
        goto L25
    }

    private static /* synthetic */ void lambda$pullWifiActivityInfoLocked$19(SynchronousResultReceiver wifiReceiver, WifiActivityEnergyInfo info) {
        Bundle bundle = new Bundle();
        bundle.putParcelable(RESULT_RECEIVER_CONTROLLER_KEY, info);
        wifiReceiver.send(0, bundle);
    }

    private void registerModemActivityInfo() {
        this.mStatsManager.setPullAtomCallback(FrameworkStatsLog.MODEM_ACTIVITY_INFO, null, ConcurrentUtils.DIRECT_EXECUTOR, this.mStatsCallbackImpl);
    }

    int pullModemActivityInfoLocked(int atomTag, List<StatsEvent> pulledData) {
        long token = Binder.clearCallingIdentity();
        final CompletableFuture<ModemActivityInfo> modemFuture = new CompletableFuture();     // Catch: Throwable -> L17
        this.mTelephony.requestModemActivityInfo(new SystemServerInitThreadPool$$ExternalSyntheticLambda0(), new AnonymousClass3(this, modemFuture));     // Catch: Throwable -> L17
        ModemActivityInfo modemInfo = modemFuture.get(2000, TimeUnit.MILLISECONDS);     // Catch: Throwable -> L17 ExecutionException -> L19 Throwable -> L21
        if (modemInfo != null) goto L10;
        Binder.restoreCallingIdentity(token);
        return 1;
    L10:
        pulledData.add(FrameworkStatsLog.buildStatsEvent(atomTag, modemInfo.getTimestampMillis(), modemInfo.getSleepTimeMillis(), modemInfo.getIdleTimeMillis(), modemInfo.getTransmitDurationMillisAtPowerLevel(0), modemInfo.getTransmitDurationMillisAtPowerLevel(1), modemInfo.getTransmitDurationMillisAtPowerLevel(2), modemInfo.getTransmitDurationMillisAtPowerLevel(3), modemInfo.getTransmitDurationMillisAtPowerLevel(4), modemInfo.getReceiveTimeMillis(), -1));     // Catch: Throwable -> L15
        Binder.restoreCallingIdentity(token);
        return 0;
    L15:
        e = th;
    L31:
        Binder.restoreCallingIdentity(token);
        throw e;
    L21:
        e = move-exception;
        Slog.w(TAG, "timeout or interrupt reading modem stats: " + e);     // Catch: Throwable -> L15
        Binder.restoreCallingIdentity(token);
        return 1;
    L19:
        e = move-exception;
        Slog.w(TAG, "exception reading modem stats: " + e.getCause());     // Catch: Throwable -> L15
        Binder.restoreCallingIdentity(token);
        return 1;
    L17:
        e = th;
        goto L31
    }

    private void registerBluetoothActivityInfo() {
        this.mStatsManager.setPullAtomCallback(FrameworkStatsLog.BLUETOOTH_ACTIVITY_INFO, null, ConcurrentUtils.DIRECT_EXECUTOR, this.mStatsCallbackImpl);
    }

    int pullBluetoothActivityInfoLocked(int atomTag, List<StatsEvent> pulledData) {
        BluetoothActivityEnergyInfo info = fetchBluetoothData();
        if (info != null) goto L6;
        return 1;
    L6:
        pulledData.add(FrameworkStatsLog.buildStatsEvent(atomTag, info.getTimestampMillis(), info.getBluetoothStackState(), info.getControllerTxTimeMillis(), info.getControllerRxTimeMillis(), info.getControllerIdleTimeMillis(), info.getControllerEnergyUsed()));
        return 0;
    }

    private void registerUwbActivityInfo() {
        if (this.mUwbManager != null) goto L5;
        return;
    L5:
        this.mStatsManager.setPullAtomCallback(FrameworkStatsLog.UWB_ACTIVITY_INFO, null, ConcurrentUtils.DIRECT_EXECUTOR, this.mStatsCallbackImpl);
    }

    int pullUwbActivityInfoLocked(int atomTag, List<StatsEvent> pulledData) {
        long token = Binder.clearCallingIdentity();
        final SynchronousResultReceiver uwbReceiver = new SynchronousResultReceiver("uwb");     // Catch: Throwable -> L17 RuntimeException -> L19
        this.mUwbManager.getUwbActivityEnergyInfoAsync(new SystemServerInitThreadPool$$ExternalSyntheticLambda0(), new StatsPullAtomService$$ExternalSyntheticLambda29(uwbReceiver));     // Catch: Throwable -> L17 RuntimeException -> L19
        UwbActivityEnergyInfo uwbInfo = awaitControllerInfo(uwbReceiver);     // Catch: Throwable -> L17 RuntimeException -> L19
        if (uwbInfo != null) goto L8;
        Binder.restoreCallingIdentity(token);
        return 1;
    L8:
    L27:
        pulledData.add(FrameworkStatsLog.buildStatsEvent(atomTag, uwbInfo.getControllerTxDurationMillis(), uwbInfo.getControllerRxDurationMillis(), uwbInfo.getControllerIdleDurationMillis(), uwbInfo.getControllerWakeCount()));     // Catch: Throwable -> L13 RuntimeException -> L15
        Binder.restoreCallingIdentity(token);
        return 0;
    L15:
        e = e;
    L22:
        Slog.e(TAG, "failed to getUwbActivityEnergyInfoAsync", e);     // Catch: Throwable -> L13
        Binder.restoreCallingIdentity(token);
        return 1;
    L13:
        e = th;
    L25:
        Binder.restoreCallingIdentity(token);
        throw e;
    L19:
        e = e;
    L17:
        e = th;
        goto L25
    }

    private static /* synthetic */ void lambda$pullUwbActivityInfoLocked$20(SynchronousResultReceiver uwbReceiver, UwbActivityEnergyInfo info) {
        Bundle bundle = new Bundle();
        bundle.putParcelable(RESULT_RECEIVER_CONTROLLER_KEY, info);
        uwbReceiver.send(0, bundle);
    }

    private void registerSystemElapsedRealtime() {
        StatsManager.PullAtomMetadata metadata = new StatsManager.PullAtomMetadata.Builder().setCoolDownMillis(1000).setTimeoutMillis(500).build();
        this.mStatsManager.setPullAtomCallback(10014, metadata, ConcurrentUtils.DIRECT_EXECUTOR, this.mStatsCallbackImpl);
    }

    int pullSystemElapsedRealtimeLocked(int atomTag, List<StatsEvent> pulledData) {
        pulledData.add(FrameworkStatsLog.buildStatsEvent(atomTag, SystemClock.elapsedRealtime()));
        return 0;
    }

    private void registerSystemUptime() {
        this.mStatsManager.setPullAtomCallback(FrameworkStatsLog.SYSTEM_UPTIME, null, ConcurrentUtils.DIRECT_EXECUTOR, this.mStatsCallbackImpl);
    }

    int pullSystemUptimeLocked(int atomTag, List<StatsEvent> pulledData) {
        pulledData.add(FrameworkStatsLog.buildStatsEvent(atomTag, SystemClock.uptimeMillis()));
        return 0;
    }

    private void registerProcessMemoryState() {
        StatsManager.PullAtomMetadata metadata = new StatsManager.PullAtomMetadata.Builder().setAdditiveFields(new int[]{4, 5, 6, 7, 8}).build();
        this.mStatsManager.setPullAtomCallback(FrameworkStatsLog.PROCESS_MEMORY_STATE, metadata, ConcurrentUtils.DIRECT_EXECUTOR, this.mStatsCallbackImpl);
    }

    int pullProcessMemoryStateLocked(int atomTag, List<StatsEvent> pulledData) {
        List<ProcessMemoryState> processMemoryStates = ((ActivityManagerInternal) LocalServices.getService(ActivityManagerInternal.class)).getMemoryStateForProcesses();
        Iterator<ProcessMemoryState> r1 = processMemoryStates.iterator();
    L4:
        if (r1.hasNext() == false) goto L10;
        ProcessMemoryState processMemoryState = r1.next();
        MemoryStatUtil.MemoryStat memoryStat = MemoryStatUtil.readMemoryStatFromFilesystem(processMemoryState.uid, processMemoryState.pid);
        if (memoryStat == null) goto L4;
        List<ProcessMemoryState> processMemoryStates2 = processMemoryStates;
        pulledData.add(FrameworkStatsLog.buildStatsEvent(atomTag, processMemoryState.uid, processMemoryState.processName, processMemoryState.oomScore, memoryStat.pgfault, memoryStat.pgmajfault, memoryStat.rssInBytes, memoryStat.cacheInBytes, memoryStat.swapInBytes, -1, -1, -1));
        processMemoryStates = processMemoryStates2;
        r1 = r1;
        goto L4
    L10:
        return 0;
    }

    private void registerProcessMemoryHighWaterMark() {
        this.mStatsManager.setPullAtomCallback(FrameworkStatsLog.PROCESS_MEMORY_HIGH_WATER_MARK, null, ConcurrentUtils.DIRECT_EXECUTOR, this.mStatsCallbackImpl);
    }

    int pullProcessMemoryHighWaterMarkLocked(int atomTag, List<StatsEvent> pulledData) {
        List<ProcessMemoryState> managedProcessList = ((ActivityManagerInternal) LocalServices.getService(ActivityManagerInternal.class)).getMemoryStateForProcesses();
        Iterator<ProcessMemoryState> r1 = managedProcessList.iterator();
    L4:
        if (r1.hasNext() == false) goto L9;
        ProcessMemoryState managedProcess = r1.next();
        ProcfsMemoryUtil.MemorySnapshot snapshot = ProcfsMemoryUtil.readMemorySnapshotFromProcfs(managedProcess.pid);
        if (snapshot == null) goto L4;
        int atomTag2 = atomTag;
        pulledData.add(FrameworkStatsLog.buildStatsEvent(atomTag2, managedProcess.uid, managedProcess.processName, ((long) snapshot.rssHighWaterMarkInKilobytes) * DeviceStorageMonitorServiceSmtEx.TrafficStats.KB_IN_BYTES, snapshot.rssHighWaterMarkInKilobytes));
        atomTag = atomTag2;
        goto L4
    L9:
        int atomTag3 = atomTag;
        final SparseArray<String> processCmdlines = ProcfsMemoryUtil.getProcessCmdlines();
        managedProcessList.forEach(new StatsPullAtomService$$ExternalSyntheticLambda15(processCmdlines));
        int size = processCmdlines.size();
        int i = 0;
    L10:
        if (i >= size) goto L16;
        ProcfsMemoryUtil.MemorySnapshot snapshot2 = ProcfsMemoryUtil.readMemorySnapshotFromProcfs(processCmdlines.keyAt(i));
        if (snapshot2 == null) goto L15;
        pulledData.add(FrameworkStatsLog.buildStatsEvent(atomTag3, snapshot2.uid, processCmdlines.valueAt(i), ((long) snapshot2.rssHighWaterMarkInKilobytes) * DeviceStorageMonitorServiceSmtEx.TrafficStats.KB_IN_BYTES, snapshot2.rssHighWaterMarkInKilobytes));
    L15:
        i = i + 1;
        goto L10
    L16:
        SystemProperties.set("sys.rss_hwm_reset.on", "1");
        return 0;
    }

    private static /* synthetic */ void lambda$pullProcessMemoryHighWaterMarkLocked$21(SparseArray processCmdlines, ProcessMemoryState managedProcess) {
        processCmdlines.delete(managedProcess.pid);
    }

    private void registerProcessMemorySnapshot() {
        this.mStatsManager.setPullAtomCallback(FrameworkStatsLog.PROCESS_MEMORY_SNAPSHOT, null, ConcurrentUtils.DIRECT_EXECUTOR, this.mStatsCallbackImpl);
    }

    int pullProcessMemorySnapshot(int atomTag, List<StatsEvent> pulledData) {
        List<ProcessMemoryState> managedProcessList = ((ActivityManagerInternal) LocalServices.getService(ActivityManagerInternal.class)).getMemoryStateForProcesses();
        KernelAllocationStats.ProcessGpuMem[] gpuAllocations = KernelAllocationStats.getGpuAllocations();
        SparseIntArray gpuMemPerPid = new SparseIntArray(gpuAllocations.length);
        int r4 = gpuAllocations.length;
        int r6 = 0;
    L3:
        if (r6 >= r4) goto L5;
        KernelAllocationStats.ProcessGpuMem processGpuMem = gpuAllocations[r6];
        gpuMemPerPid.put(processGpuMem.pid, processGpuMem.gpuMemoryKb);
        r6 = r6 + 1;
        goto L3
    L5:
        Iterator<ProcessMemoryState> r5 = managedProcessList.iterator();
    L7:
        if (r5.hasNext() == false) goto L12;
        ProcessMemoryState managedProcess = r5.next();
        ProcfsMemoryUtil.MemorySnapshot snapshot = ProcfsMemoryUtil.readMemorySnapshotFromProcfs(managedProcess.pid);
        if (snapshot == null) goto L7;
        KernelAllocationStats.ProcessGpuMem[] gpuAllocations2 = gpuAllocations;
        pulledData.add(FrameworkStatsLog.buildStatsEvent(atomTag, managedProcess.uid, managedProcess.processName, managedProcess.pid, managedProcess.oomScore, snapshot.rssInKilobytes, snapshot.anonRssInKilobytes, snapshot.swapInKilobytes, snapshot.anonRssInKilobytes + snapshot.swapInKilobytes, gpuMemPerPid.get(managedProcess.pid), managedProcess.hasForegroundServices, snapshot.rssShmemKilobytes, managedProcess.mHostingComponentTypes, managedProcess.mHistoricalHostingComponentTypes));
        gpuAllocations = gpuAllocations2;
        goto L7
    L12:
        final SparseArray<String> processCmdlines = ProcfsMemoryUtil.getProcessCmdlines();
        managedProcessList.forEach(new StatsPullAtomService$$ExternalSyntheticLambda28(processCmdlines));
        int size = processCmdlines.size();
        int i = 0;
    L13:
        if (i >= size) goto L20;
        int pid = processCmdlines.keyAt(i);
        ProcfsMemoryUtil.MemorySnapshot snapshot2 = ProcfsMemoryUtil.readMemorySnapshotFromProcfs(pid);
        if (snapshot2 == null) goto L18;
        pulledData.add(FrameworkStatsLog.buildStatsEvent(atomTag, snapshot2.uid, processCmdlines.valueAt(i), pid, JobSchedulerShellCommand.CMD_ERR_NO_JOB, snapshot2.rssInKilobytes, snapshot2.anonRssInKilobytes, snapshot2.swapInKilobytes, snapshot2.anonRssInKilobytes + snapshot2.swapInKilobytes, gpuMemPerPid.get(pid), false, snapshot2.rssShmemKilobytes, 0, 0));
    L18:
        i = i + 1;
        goto L13
    L20:
        return 0;
    }

    private static /* synthetic */ void lambda$pullProcessMemorySnapshot$22(SparseArray processCmdlines, ProcessMemoryState managedProcess) {
        processCmdlines.delete(managedProcess.pid);
    }

    private void registerSystemIonHeapSize() {
        this.mStatsManager.setPullAtomCallback(FrameworkStatsLog.SYSTEM_ION_HEAP_SIZE, null, ConcurrentUtils.DIRECT_EXECUTOR, this.mStatsCallbackImpl);
    }

    int pullSystemIonHeapSizeLocked(int atomTag, List<StatsEvent> pulledData) {
        long systemIonHeapSizeInBytes = IonMemoryUtil.readSystemIonHeapSizeFromDebugfs();
        pulledData.add(FrameworkStatsLog.buildStatsEvent(atomTag, systemIonHeapSizeInBytes));
        return 0;
    }

    private void registerIonHeapSize() {
        if (new File("/sys/kernel/ion/total_heaps_kb").exists() == true) goto L5;
        return;
    L5:
        this.mStatsManager.setPullAtomCallback(FrameworkStatsLog.ION_HEAP_SIZE, null, ConcurrentUtils.DIRECT_EXECUTOR, this.mStatsCallbackImpl);
    }

    int pullIonHeapSizeLocked(int atomTag, List<StatsEvent> pulledData) {
        int ionHeapSizeInKilobytes = (int) Debug.getIonHeapsSizeKb();
        pulledData.add(FrameworkStatsLog.buildStatsEvent(atomTag, ionHeapSizeInKilobytes));
        return 0;
    }

    private void registerProcessSystemIonHeapSize() {
        this.mStatsManager.setPullAtomCallback(FrameworkStatsLog.PROCESS_SYSTEM_ION_HEAP_SIZE, null, ConcurrentUtils.DIRECT_EXECUTOR, this.mStatsCallbackImpl);
    }

    int pullProcessSystemIonHeapSizeLocked(int atomTag, List<StatsEvent> pulledData) {
        List<IonMemoryUtil.IonAllocations> result = IonMemoryUtil.readProcessSystemIonHeapSizesFromDebugfs();
        Iterator<IonMemoryUtil.IonAllocations> r1 = result.iterator();
    L4:
        if (r1.hasNext() == false) goto L7;
        IonMemoryUtil.IonAllocations allocations = r1.next();
        int atomTag2 = atomTag;
        pulledData.add(FrameworkStatsLog.buildStatsEvent(atomTag2, Process.getUidForPid(allocations.pid), ProcfsMemoryUtil.readCmdlineFromProcfs(allocations.pid), (int) (allocations.totalSizeInBytes / DeviceStorageMonitorServiceSmtEx.TrafficStats.KB_IN_BYTES), allocations.count, (int) (allocations.maxSizeInBytes / DeviceStorageMonitorServiceSmtEx.TrafficStats.KB_IN_BYTES)));
        atomTag = atomTag2;
        goto L4
    L7:
        return 0;
    }

    private void registerProcessDmabufMemory() {
        this.mStatsManager.setPullAtomCallback(FrameworkStatsLog.PROCESS_DMABUF_MEMORY, null, ConcurrentUtils.DIRECT_EXECUTOR, this.mStatsCallbackImpl);
    }

    int pullProcessDmabufMemory(int atomTag, List<StatsEvent> pulledData) {
        KernelAllocationStats.ProcessDmabuf[] procBufs = KernelAllocationStats.getDmabufAllocations();
        if (procBufs != null) goto L6;
        return 1;
    L6:
        int r1 = procBufs.length;
        int r3 = 0;
    L7:
        if (r3 >= r1) goto L10;
        KernelAllocationStats.ProcessDmabuf procBuf = procBufs[r3];
        pulledData.add(FrameworkStatsLog.buildStatsEvent(atomTag, procBuf.uid, procBuf.processName, procBuf.oomScore, procBuf.retainedSizeKb, procBuf.retainedBuffersCount, 0, 0, procBuf.surfaceFlingerSizeKb, procBuf.surfaceFlingerCount));
        r3 = r3 + 1;
        goto L7
    L10:
        return 0;
    }

    private void registerSystemMemory() {
        this.mStatsManager.setPullAtomCallback(FrameworkStatsLog.SYSTEM_MEMORY, null, ConcurrentUtils.DIRECT_EXECUTOR, this.mStatsCallbackImpl);
    }

    int pullSystemMemory(int atomTag, List<StatsEvent> pulledData) {
        SystemMemoryUtil.Metrics metrics = SystemMemoryUtil.getMetrics();
        pulledData.add(FrameworkStatsLog.buildStatsEvent(atomTag, metrics.unreclaimableSlabKb, metrics.vmallocUsedKb, metrics.pageTablesKb, metrics.kernelStackKb, metrics.totalIonKb, metrics.unaccountedKb, metrics.gpuTotalUsageKb, metrics.gpuPrivateAllocationsKb, metrics.dmaBufTotalExportedKb, metrics.shmemKb, metrics.totalKb, metrics.freeKb, metrics.availableKb, metrics.activeKb, metrics.inactiveKb, metrics.activeAnonKb, metrics.inactiveAnonKb, metrics.activeFileKb, metrics.inactiveFileKb, metrics.swapTotalKb, metrics.swapFreeKb, metrics.cmaTotalKb, metrics.cmaFreeKb));
        return 0;
    }

    private void registerVmStat() {
        this.mStatsManager.setPullAtomCallback(FrameworkStatsLog.VMSTAT, null, ConcurrentUtils.DIRECT_EXECUTOR, this.mStatsCallbackImpl);
    }

    int pullVmStat(int atomTag, List<StatsEvent> pulledData) {
        ProcfsMemoryUtil.VmStat vmStat = ProcfsMemoryUtil.readVmStat();
        if (vmStat == null) goto L7;
        pulledData.add(FrameworkStatsLog.buildStatsEvent(atomTag, vmStat.oomKillCount));
        return 0;
    L7:
        return 0;
    }

    private void registerTemperature() {
        this.mStatsManager.setPullAtomCallback(FrameworkStatsLog.TEMPERATURE, null, ConcurrentUtils.DIRECT_EXECUTOR, this.mStatsCallbackImpl);
    }

    int pullTemperatureLocked(int atomTag, List<StatsEvent> pulledData) {
        IThermalService thermalService = getIThermalService();
        if (thermalService != null) goto L5;
        return 1;
    L5:
        long callingToken = Binder.clearCallingIdentity();
        Temperature[] temperatures = thermalService.getCurrentTemperatures();     // Catch: Throwable -> L10 RemoteException -> L12
        int r5 = temperatures.length;     // Catch: Throwable -> L10 RemoteException -> L12
        int r7 = 0;
    L7:
        if (r7 >= r5) goto L14;
        Temperature temp = temperatures[r7];     // Catch: Throwable -> L10 RemoteException -> L12
        pulledData.add(FrameworkStatsLog.buildStatsEvent(atomTag, temp.getType(), temp.getName(), (int) (temp.getValue() * 10.0f), temp.getStatus()));     // Catch: Throwable -> L10 RemoteException -> L12
        r7 = r7 + 1;
        goto L7
        goto L17
    L14:
        Binder.restoreCallingIdentity(callingToken);
        return 0;
    L10:
        th = move-exception;
        Binder.restoreCallingIdentity(callingToken);
        throw th;
    L17:
        Slog.e(TAG, "Disconnected from thermal service. Cannot pull temperatures.");     // Catch: Throwable -> L10
        Binder.restoreCallingIdentity(callingToken);
        return 1;
    }

    private void registerCoolingDevice() {
        this.mStatsManager.setPullAtomCallback(FrameworkStatsLog.COOLING_DEVICE, null, ConcurrentUtils.DIRECT_EXECUTOR, this.mStatsCallbackImpl);
    }

    int pullCooldownDeviceLocked(int atomTag, List<StatsEvent> pulledData) {
        IThermalService thermalService = getIThermalService();
        if (thermalService != null) goto L5;
        return 1;
    L5:
        long callingToken = Binder.clearCallingIdentity();
        CoolingDevice[] devices = thermalService.getCurrentCoolingDevices();     // Catch: Throwable -> L10 RemoteException -> L12
        int r5 = devices.length;     // Catch: Throwable -> L10 RemoteException -> L12
        int r7 = 0;
    L7:
        if (r7 >= r5) goto L14;
        CoolingDevice device = devices[r7];     // Catch: Throwable -> L10 RemoteException -> L12
        pulledData.add(FrameworkStatsLog.buildStatsEvent(atomTag, device.getType(), device.getName(), (int) device.getValue()));     // Catch: Throwable -> L10 RemoteException -> L12
        r7 = r7 + 1;
        goto L7
        goto L17
    L14:
        Binder.restoreCallingIdentity(callingToken);
        return 0;
    L10:
        th = move-exception;
        Binder.restoreCallingIdentity(callingToken);
        throw th;
    L17:
        Slog.e(TAG, "Disconnected from thermal service. Cannot pull temperatures.");     // Catch: Throwable -> L10
        Binder.restoreCallingIdentity(callingToken);
        return 1;
    }

    private void registerBinderCallsStats() {
        StatsManager.PullAtomMetadata metadata = new StatsManager.PullAtomMetadata.Builder().setAdditiveFields(new int[]{4, 5, 6, 8, 12}).build();
        this.mStatsManager.setPullAtomCallback(FrameworkStatsLog.BINDER_CALLS, metadata, ConcurrentUtils.DIRECT_EXECUTOR, this.mStatsCallbackImpl);
    }

    int pullBinderCallsStatsLocked(int atomTag, List<StatsEvent> pulledData) {
        BinderCallsStatsService.Internal binderStats = (BinderCallsStatsService.Internal) LocalServices.getService(BinderCallsStatsService.Internal.class);
        if (binderStats != null) goto L6;
        Slog.e(TAG, "failed to get binderStats");
        return 1;
    L6:
        List<BinderCallsStats.ExportedCallStat> callStats = binderStats.getExportedCallStats();
        binderStats.reset();
        Iterator<BinderCallsStats.ExportedCallStat> r2 = callStats.iterator();
    L8:
        if (r2.hasNext() == false) goto L11;
        BinderCallsStats.ExportedCallStat callStat = r2.next();
        BinderCallsStatsService.Internal binderStats2 = binderStats;
        pulledData.add(FrameworkStatsLog.buildStatsEvent(atomTag, callStat.workSourceUid, callStat.className, callStat.methodName, callStat.callCount, callStat.exceptionCount, callStat.latencyMicros, callStat.maxLatencyMicros, callStat.cpuTimeMicros, callStat.maxCpuTimeMicros, callStat.maxReplySizeBytes, callStat.maxRequestSizeBytes, callStat.recordedCallCount, callStat.screenInteractive, callStat.callingUid));
        binderStats = binderStats2;
        callStats = callStats;
        goto L8
    L11:
        return 0;
    }

    private void registerBinderCallsStatsExceptions() {
        this.mStatsManager.setPullAtomCallback(FrameworkStatsLog.BINDER_CALLS_EXCEPTIONS, null, ConcurrentUtils.DIRECT_EXECUTOR, this.mStatsCallbackImpl);
    }

    int pullBinderCallsStatsExceptionsLocked(int atomTag, List<StatsEvent> pulledData) {
        BinderCallsStatsService.Internal binderStats = (BinderCallsStatsService.Internal) LocalServices.getService(BinderCallsStatsService.Internal.class);
        if (binderStats != null) goto L6;
        Slog.e(TAG, "failed to get binderStats");
        return 1;
    L6:
        ArrayMap<String, Integer> exceptionStats = binderStats.getExportedExceptionStats();
        Iterator<Map.Entry<String, Integer>> r2 = exceptionStats.entrySet().iterator();
    L8:
        if (r2.hasNext() == false) goto L10;
        Map.Entry<String, Integer> entry = r2.next();
        pulledData.add(FrameworkStatsLog.buildStatsEvent(atomTag, entry.getKey(), entry.getValue().intValue()));
        goto L8
    L10:
        return 0;
    }

    private void registerLooperStats() {
        StatsManager.PullAtomMetadata metadata = new StatsManager.PullAtomMetadata.Builder().setAdditiveFields(new int[]{5, 6, 7, 8, 9}).build();
        this.mStatsManager.setPullAtomCallback(FrameworkStatsLog.LOOPER_STATS, metadata, ConcurrentUtils.DIRECT_EXECUTOR, this.mStatsCallbackImpl);
    }

    int pullLooperStatsLocked(int atomTag, List<StatsEvent> pulledData) {
        LooperStats looperStats = (LooperStats) LocalServices.getService(LooperStats.class);
        if (looperStats != null) goto L6;
        return 1;
    L6:
        List<LooperStats.ExportedEntry> entries = looperStats.getEntries();
        looperStats.reset();
        Iterator<LooperStats.ExportedEntry> r2 = entries.iterator();
    L8:
        if (r2.hasNext() == false) goto L11;
        LooperStats.ExportedEntry entry = r2.next();
        LooperStats looperStats2 = looperStats;
        pulledData.add(FrameworkStatsLog.buildStatsEvent(atomTag, entry.workSourceUid, entry.handlerClassName, entry.threadName, entry.messageName, entry.messageCount, entry.exceptionCount, entry.recordedMessageCount, entry.totalLatencyMicros, entry.cpuUsageMicros, entry.isInteractive, entry.maxCpuUsageMicros, entry.maxLatencyMicros, entry.recordedDelayMessageCount, entry.delayMillis, entry.maxDelayMillis));
        looperStats = looperStats2;
        entries = entries;
        goto L8
    L11:
        return 0;
    }

    private void registerDiskStats() {
        this.mStatsManager.setPullAtomCallback(FrameworkStatsLog.DISK_STATS, null, ConcurrentUtils.DIRECT_EXECUTOR, this.mStatsCallbackImpl);
    }

    int pullDiskStatsLocked(int atomTag, List<StatsEvent> pulledData) {
        byte[] junk = new byte[512];
        int i = 0;
    L4:
        if (i >= junk.length) goto L6;
        junk[i] = (byte) i;
        i = i + 1;
        goto L4
    L6:
        File tmp = new File(Environment.getDataDirectory(), "system/statsdperftest.tmp");
        FileOutputStream fos = null;
        IOException error = null;
        long before = SystemClock.elapsedRealtime();
        fos = new FileOutputStream(tmp);     // Catch: Throwable -> L12 IOException -> L14
        fos.write(junk);     // Catch: Throwable -> L12 IOException -> L14
        fos.close();     // Catch: IOException -> L10
    L45:
        goto L27
    L14:
        e = move-exception;
        error = e;
        if (fos == null) goto L27;
        fos.close();     // Catch: IOException -> L10
    L12:
        th = move-exception;
        FileOutputStream fos2 = fos;
        if (fos2 == null) goto L52;
        fos2.close();     // Catch: IOException -> L19
        throw th;
    L22:
        throw th;
    L52:
        throw th;
    L27:
        long latency = SystemClock.elapsedRealtime() - before;
        if (tmp.exists() == false) goto L31;
        tmp.delete();
    L31:
        if (error == null) goto L33;
        Slog.e(TAG, "Error performing diskstats latency test");
        latency = -1;
    L33:
        boolean fileBased = StorageManager.isFileEncrypted();
        int writeSpeed = -1;
        IStoraged storaged = getIStoragedService();
        if (storaged != null) goto L43;
        return 1;
    L43:
        writeSpeed = storaged.getRecentPerf();     // Catch: RemoteException -> L39
    L41:
        pulledData.add(FrameworkStatsLog.buildStatsEvent(atomTag, latency, fileBased, writeSpeed));
        return 0;
    L40:
        Slog.e(TAG, "storaged not found");
        goto L41
    }

    private void registerDirectoryUsage() {
        this.mStatsManager.setPullAtomCallback(FrameworkStatsLog.DIRECTORY_USAGE, null, ConcurrentUtils.DIRECT_EXECUTOR, this.mStatsCallbackImpl);
    }

    int pullDirectoryUsageLocked(int atomTag, List<StatsEvent> pulledData) {
        StatFs statFsData = new StatFs(Environment.getDataDirectory().getAbsolutePath());
        StatFs statFsSystem = new StatFs(Environment.getRootDirectory().getAbsolutePath());
        StatFs statFsCache = new StatFs(Environment.getDownloadCacheDirectory().getAbsolutePath());
        StatFs metadataFsSystem = new StatFs(Environment.getMetadataDirectory().getAbsolutePath());
        pulledData.add(FrameworkStatsLog.buildStatsEvent(atomTag, 1, statFsData.getAvailableBytes(), statFsData.getTotalBytes()));
        pulledData.add(FrameworkStatsLog.buildStatsEvent(atomTag, 2, statFsCache.getAvailableBytes(), statFsCache.getTotalBytes()));
        pulledData.add(FrameworkStatsLog.buildStatsEvent(atomTag, 3, statFsSystem.getAvailableBytes(), statFsSystem.getTotalBytes()));
        pulledData.add(FrameworkStatsLog.buildStatsEvent(atomTag, 4, metadataFsSystem.getAvailableBytes(), metadataFsSystem.getTotalBytes()));
        return 0;
    }

    private void registerAppSize() {
        this.mStatsManager.setPullAtomCallback(FrameworkStatsLog.APP_SIZE, null, ConcurrentUtils.DIRECT_EXECUTOR, this.mStatsCallbackImpl);
    }

    int pullAppSizeLocked(int atomTag, List<StatsEvent> pulledData) {
        String jsonStr = IoUtils.readFileAsString(DiskStatsLoggingService.DUMPSYS_CACHE_PATH);     // Catch: Throwable -> L17
        JSONObject json = new JSONObject(jsonStr);     // Catch: Throwable -> L17
        long cache_time = json.optLong(DiskStatsFileLogger.LAST_QUERY_TIMESTAMP_KEY, -1);     // Catch: Throwable -> L17
        JSONArray pkg_names = json.getJSONArray(DiskStatsFileLogger.PACKAGE_NAMES_KEY);     // Catch: Throwable -> L17
        JSONArray app_sizes = json.getJSONArray(DiskStatsFileLogger.APP_SIZES_KEY);     // Catch: Throwable -> L17
        JSONArray app_data_sizes = json.getJSONArray(DiskStatsFileLogger.APP_DATA_KEY);     // Catch: Throwable -> L17
        JSONArray app_cache_sizes = json.getJSONArray(DiskStatsFileLogger.APP_CACHES_KEY);     // Catch: Throwable -> L17
        int length = pkg_names.length();     // Catch: Throwable -> L17
        if (app_sizes.length() != length) goto L22;
        if (app_data_sizes.length() != length) goto L22;
        if (app_cache_sizes.length() != length) goto L22;
        int i = 0;
    L11:
        if (i >= length) goto L20;
        int length2 = length;
        int i2 = i;
        JSONArray app_cache_sizes2 = app_cache_sizes;
        pulledData.add(FrameworkStatsLog.buildStatsEvent(atomTag, pkg_names.getString(i), app_sizes.optLong(i, -1), app_data_sizes.optLong(i, -1), app_cache_sizes.optLong(i, -1), cache_time));     // Catch: Throwable -> L15
        i = i2 + 1;     // Catch: Throwable -> L15
        app_cache_sizes = app_cache_sizes2;
        length = length2;
        goto L11
    L20:
        return 0;
    L22:
        Slog.e(TAG, "formatting error in diskstats cache file!");     // Catch: Throwable -> L15
        return 1;
    L24:
        Slog.w(TAG, "Unable to read diskstats cache file within pullAppSize");
        return 1;
    }

    private void registerCategorySize() {
        this.mStatsManager.setPullAtomCallback(FrameworkStatsLog.CATEGORY_SIZE, null, ConcurrentUtils.DIRECT_EXECUTOR, this.mStatsCallbackImpl);
    }

    int pullCategorySizeLocked(int atomTag, List<StatsEvent> pulledData) {
        String jsonStr = IoUtils.readFileAsString(DiskStatsLoggingService.DUMPSYS_CACHE_PATH);     // Catch: Throwable -> L9
        JSONObject json = new JSONObject(jsonStr);     // Catch: Throwable -> L9
        long cacheTime = json.optLong(DiskStatsFileLogger.LAST_QUERY_TIMESTAMP_KEY, -1);     // Catch: Throwable -> L9
        pulledData.add(FrameworkStatsLog.buildStatsEvent(atomTag, 1, json.optLong(DiskStatsFileLogger.APP_SIZE_AGG_KEY, -1), cacheTime));     // Catch: Throwable -> L7
        pulledData.add(FrameworkStatsLog.buildStatsEvent(atomTag, 2, json.optLong(DiskStatsFileLogger.APP_DATA_SIZE_AGG_KEY, -1), cacheTime));     // Catch: Throwable -> L7
        pulledData.add(FrameworkStatsLog.buildStatsEvent(atomTag, 3, json.optLong(DiskStatsFileLogger.APP_CACHE_AGG_KEY, -1), cacheTime));     // Catch: Throwable -> L7
        pulledData.add(FrameworkStatsLog.buildStatsEvent(atomTag, 4, json.optLong(DiskStatsFileLogger.PHOTOS_KEY, -1), cacheTime));     // Catch: Throwable -> L7
        pulledData.add(FrameworkStatsLog.buildStatsEvent(atomTag, 5, json.optLong(DiskStatsFileLogger.VIDEOS_KEY, -1), cacheTime));     // Catch: Throwable -> L7
        pulledData.add(FrameworkStatsLog.buildStatsEvent(atomTag, 6, json.optLong(DiskStatsFileLogger.AUDIO_KEY, -1), cacheTime));     // Catch: Throwable -> L7
        pulledData.add(FrameworkStatsLog.buildStatsEvent(atomTag, 7, json.optLong(DiskStatsFileLogger.DOWNLOADS_KEY, -1), cacheTime));     // Catch: Throwable -> L7
        pulledData.add(FrameworkStatsLog.buildStatsEvent(atomTag, 8, json.optLong(DiskStatsFileLogger.SYSTEM_KEY, -1), cacheTime));     // Catch: Throwable -> L7
        pulledData.add(FrameworkStatsLog.buildStatsEvent(atomTag, 9, json.optLong(DiskStatsFileLogger.MISC_KEY, -1), cacheTime));     // Catch: Throwable -> L7
        return 0;
    L11:
        Slog.w(TAG, "Unable to read diskstats cache file within pullCategorySize");
        return 1;
    }

    private void registerNumFingerprintsEnrolled() {
        this.mStatsManager.setPullAtomCallback(FrameworkStatsLog.NUM_FINGERPRINTS_ENROLLED, null, ConcurrentUtils.DIRECT_EXECUTOR, this.mStatsCallbackImpl);
    }

    private void registerNumFacesEnrolled() {
        this.mStatsManager.setPullAtomCallback(FrameworkStatsLog.NUM_FACES_ENROLLED, null, ConcurrentUtils.DIRECT_EXECUTOR, this.mStatsCallbackImpl);
    }

    private int pullNumBiometricsEnrolledLocked(int modality, int atomTag, List<StatsEvent> pulledData) {
        PackageManager pm = this.mContext.getPackageManager();
        FaceManager faceManager = null;
        if (pm.hasSystemFeature("android.hardware.fingerprint") == false) goto L5;
        FingerprintManager fingerprintManager = (FingerprintManager) this.mContext.getSystemService(FingerprintManager.class);
        FingerprintManager fingerprintManager2 = fingerprintManager;
    L7:
        if (pm.hasSystemFeature("android.hardware.biometrics.face") == false) goto L10;
        faceManager = (FaceManager) this.mContext.getSystemService(FaceManager.class);
    L10:
        if (modality != 1) goto L13;
        if (fingerprintManager2 != null) goto L13;
        return 1;
    L13:
        int r6 = 4;
        if (modality != 4) goto L17;
        if (faceManager != null) goto L17;
        return 1;
    L17:
        UserManager userManager = (UserManager) this.mContext.getSystemService(UserManager.class);
        if (userManager != null) goto L20;
        return 1;
    L20:
        long token = Binder.clearCallingIdentity();
        Iterator r10 = userManager.getUsers().iterator();     // Catch: Throwable -> L27
    L22:
        if (r10.hasNext() == false) goto L43;
        UserInfo user = (UserInfo) r10.next();     // Catch: Throwable -> L27
        int userId = user.getUserHandle().getIdentifier();     // Catch: Throwable -> L27
        if (modality != 1) goto L30;
        int numEnrolled = fingerprintManager2.getEnrolledFingerprints(userId).size();     // Catch: Throwable -> L27
    L49:
        pulledData.add(FrameworkStatsLog.buildStatsEvent(atomTag, userId, numEnrolled));     // Catch: Throwable -> L37
        r6 = 4;
    L37:
        th = th;
    L45:
        Binder.restoreCallingIdentity(token);
        throw th;
    L39:
        th = th;
        goto L45
    L30:
        if (modality != r6) goto L41;
        numEnrolled = faceManager.getEnrolledFaces(userId).size();     // Catch: Throwable -> L27
        goto L49
    L41:
        Binder.restoreCallingIdentity(token);
        return 1;
    L43:
        Binder.restoreCallingIdentity(token);
        return 0;
    L27:
        th = th;
        goto L45
    L5:
        fingerprintManager2 = null;
        goto L7
    }

    private void registerProcStats() {
        this.mStatsManager.setPullAtomCallback(FrameworkStatsLog.PROC_STATS, null, ConcurrentUtils.DIRECT_EXECUTOR, this.mStatsCallbackImpl);
    }

    private void registerProcStatsPkgProc() {
        this.mStatsManager.setPullAtomCallback(FrameworkStatsLog.PROC_STATS_PKG_PROC, null, ConcurrentUtils.DIRECT_EXECUTOR, this.mStatsCallbackImpl);
    }

    private void registerProcessState() {
        this.mStatsManager.setPullAtomCallback(FrameworkStatsLog.PROCESS_STATE, null, ConcurrentUtils.DIRECT_EXECUTOR, this.mStatsCallbackImpl);
    }

    private void registerProcessAssociation() {
        this.mStatsManager.setPullAtomCallback(FrameworkStatsLog.PROCESS_ASSOCIATION, null, ConcurrentUtils.DIRECT_EXECUTOR, this.mStatsCallbackImpl);
    }

    private ProcessStats getStatsFromProcessStatsService(int atomTag) {
        IProcessStats processStatsService = getIProcessStatsService();
        if (processStatsService != null) goto L5;
        return null;
    L5:
        long token = Binder.clearCallingIdentity();
        long lastHighWaterMark = readProcStatsHighWaterMark(atomTag);     // Catch: Throwable -> L9 Throwable -> L11
        ProcessStats procStats = new ProcessStats(false);     // Catch: Throwable -> L9 Throwable -> L11
        long highWaterMark = processStatsService.getCommittedStatsMerged(lastHighWaterMark, 31, true, null, procStats);     // Catch: Throwable -> L9 Throwable -> L11
        new File(this.mBaseDir.getAbsolutePath() + SliceClientPermissions.SliceAuthority.DELIMITER + highWaterMarkFilePrefix(atomTag) + "_" + lastHighWaterMark).delete();     // Catch: Throwable -> L9 Throwable -> L11
        new File(this.mBaseDir.getAbsolutePath() + SliceClientPermissions.SliceAuthority.DELIMITER + highWaterMarkFilePrefix(atomTag) + "_" + highWaterMark).createNewFile();     // Catch: Throwable -> L9 Throwable -> L11
        Binder.restoreCallingIdentity(token);
        return procStats;
    L9:
        th = move-exception;
        Binder.restoreCallingIdentity(token);
        throw th;
    L11:
        e = move-exception;
        Slog.e(TAG, "Getting procstats failed: ", e);     // Catch: Throwable -> L9
        Binder.restoreCallingIdentity(token);
        return null;
    }

    private int pullProcStatsLocked(int atomTag, List<StatsEvent> pulledData) {
        ProcessStats procStats = getStatsFromProcessStatsService(atomTag);
        if (procStats != null) goto L6;
        return 1;
    L6:
        ProtoOutputStream[] protoStreams = new ProtoOutputStream[5];
        int i = 0;
    L8:
        if (i >= protoStreams.length) goto L10;
        protoStreams[i] = new ProtoOutputStream();
        i = i + 1;
        goto L8
    L10:
        procStats.dumpAggregatedProtoForStatsd(protoStreams, 58982);
        int i2 = 0;
    L12:
        if (i2 >= protoStreams.length) goto L17;
        byte[] bytes = protoStreams[i2].getBytes();
        if (bytes.length <= 0) goto L16;
        pulledData.add(FrameworkStatsLog.buildStatsEvent(atomTag, bytes, i2));
    L16:
        i2 = i2 + 1;
        goto L12
    L17:
        return 0;
    }

    private int pullProcessStateLocked(int atomTag, List<StatsEvent> pulledData) {
        ProcessStats procStats = getStatsFromProcessStatsService(atomTag);
        if (procStats != null) goto L6;
        return 1;
    L6:
        procStats.dumpProcessState(atomTag, new StatsEventOutput(pulledData));
        return 0;
    }

    private int pullProcessAssociationLocked(int atomTag, List<StatsEvent> pulledData) {
        ProcessStats procStats = getStatsFromProcessStatsService(atomTag);
        if (procStats != null) goto L6;
        return 1;
    L6:
        procStats.dumpProcessAssociation(atomTag, new StatsEventOutput(pulledData));
        return 0;
    }

    private String highWaterMarkFilePrefix(int atomTag) {
        if (atomTag != 10029) goto L7;
        return String.valueOf(31);
    L7:
        if (atomTag != 10034) goto L11;
        return String.valueOf(2);
    L11:
        return "atom-" + atomTag;
    }

    private long readProcStatsHighWaterMark(final int atomTag) {
        File[] files = this.mBaseDir.listFiles(new StatsPullAtomService$$ExternalSyntheticLambda20(this, atomTag));     // Catch: NumberFormatException -> L11 SecurityException -> L13
        if (files == null) goto L17;
        if (files.length == 0) goto L17;
        if (files.length <= 1) goto L15;
        Slog.e(TAG, "Only 1 file expected for high water mark. Found " + files.length);     // Catch: NumberFormatException -> L11 SecurityException -> L13
    L15:
        return Long.valueOf(files[0].getName().split("_")[1]).longValue();
    L17:
        return 0;
    L11:
        e = move-exception;
        Slog.e(TAG, "Failed to parse file name.", e);
    L20:
        return 0;
    L13:
        e = move-exception;
        Slog.e(TAG, "Failed to get procstats high watermark file.", e);
        goto L20
    }

    private /* synthetic */ boolean lambda$readProcStatsHighWaterMark$23(int atomTag, File d, String name) {
        return name.toLowerCase().startsWith(highWaterMarkFilePrefix(atomTag) + '_');
    }

    private void registerDiskIO() {
        StatsManager.PullAtomMetadata metadata = new StatsManager.PullAtomMetadata.Builder().setAdditiveFields(new int[]{2, 3, 4, 5, 6, 7, 8, 9, 10, 11}).setCoolDownMillis(BackupAgentTimeoutParameters.DEFAULT_QUOTA_EXCEEDED_TIMEOUT_MILLIS).build();
        this.mStatsManager.setPullAtomCallback(FrameworkStatsLog.DISK_IO, metadata, ConcurrentUtils.DIRECT_EXECUTOR, this.mStatsCallbackImpl);
    }

    int pullDiskIOLocked(final int atomTag, final List<StatsEvent> pulledData) {
        this.mStoragedUidIoStatsReader.readAbsolute(new StatsPullAtomService$$ExternalSyntheticLambda14(pulledData, atomTag));
        return 0;
    }

    private static /* synthetic */ void lambda$pullDiskIOLocked$24(List pulledData, int atomTag, int uid, long fgCharsRead, long fgCharsWrite, long fgBytesRead, long fgBytesWrite, long bgCharsRead, long bgCharsWrite, long bgBytesRead, long bgBytesWrite, long fgFsync, long bgFsync) {
        pulledData.add(FrameworkStatsLog.buildStatsEvent(atomTag, uid, fgCharsRead, fgCharsWrite, fgBytesRead, fgBytesWrite, bgCharsRead, bgCharsWrite, bgBytesRead, bgBytesWrite, fgFsync, bgFsync));
    }

    private void registerPowerProfile() {
        this.mStatsManager.setPullAtomCallback(FrameworkStatsLog.POWER_PROFILE, null, ConcurrentUtils.DIRECT_EXECUTOR, this.mStatsCallbackImpl);
    }

    int pullPowerProfileLocked(int atomTag, List<StatsEvent> pulledData) {
        PowerProfile powerProfile = new PowerProfile(this.mContext);
        ProtoOutputStream proto = new ProtoOutputStream();
        powerProfile.dumpDebug(proto);
        proto.flush();
        pulledData.add(FrameworkStatsLog.buildStatsEvent(atomTag, proto.getBytes()));
        return 0;
    }

    private void registerProcessCpuTime() {
        StatsManager.PullAtomMetadata metadata = new StatsManager.PullAtomMetadata.Builder().setCoolDownMillis(5000).build();
        this.mStatsManager.setPullAtomCallback(FrameworkStatsLog.PROCESS_CPU_TIME, metadata, ConcurrentUtils.DIRECT_EXECUTOR, this.mStatsCallbackImpl);
    }

    int pullProcessCpuTimeLocked(int atomTag, List<StatsEvent> pulledData) {
        if (this.mProcessCpuTracker != null) goto L5;
        this.mProcessCpuTracker = new ProcessCpuTracker(false);
        this.mProcessCpuTracker.init();
    L5:
        this.mProcessCpuTracker.update();
        int i = 0;
    L7:
        if (i >= this.mProcessCpuTracker.countStats()) goto L10;
        ProcessCpuTracker.Stats st = this.mProcessCpuTracker.getStats(i);
        int atomTag2 = atomTag;
        pulledData.add(FrameworkStatsLog.buildStatsEvent(atomTag2, st.uid, st.name, st.base_utime, st.base_stime));
        i = i + 1;
        atomTag = atomTag2;
        goto L7
    L10:
        return 0;
    }

    private void registerCpuTimePerThreadFreq() {
        StatsManager.PullAtomMetadata metadata = new StatsManager.PullAtomMetadata.Builder().setAdditiveFields(new int[]{7, 9, 11, 13, 15, 17, 19, 21}).build();
        this.mStatsManager.setPullAtomCallback(FrameworkStatsLog.CPU_TIME_PER_THREAD_FREQ, metadata, ConcurrentUtils.DIRECT_EXECUTOR, this.mStatsCallbackImpl);
    }

    int pullCpuTimePerThreadFreqLocked(int atomTag, List<StatsEvent> pulledData) {
        int r3 = 1;
        if (this.mKernelCpuThreadReader != null) goto L6;
        Slog.e(TAG, "mKernelCpuThreadReader is null");
        return 1;
    L6:
        ArrayList<KernelCpuThreadReader.ProcessCpuUsage> processCpuUsages = this.mKernelCpuThreadReader.getProcessCpuUsageDiffed();
        if (processCpuUsages != null) goto L10;
        Slog.e(TAG, "processCpuUsages is null");
        return 1;
    L10:
        int[] cpuFrequencies = this.mKernelCpuThreadReader.getCpuFrequenciesKhz();
        int r6 = 8;
        if (cpuFrequencies.length <= 8) goto L14;
        String message = "Expected maximum 8 frequencies, but got " + cpuFrequencies.length;
        Slog.w(TAG, message);
        return 1;
    L14:
        int i = 0;
    L15:
        int r8 = 0;
        if (i >= processCpuUsages.size()) goto L34;
        KernelCpuThreadReader.ProcessCpuUsage processCpuUsage = processCpuUsages.get(i);
        ArrayList<KernelCpuThreadReader.ThreadCpuUsage> threadCpuUsages = processCpuUsage.threadCpuUsages;
        int j = 0;
    L19:
        if (j >= threadCpuUsages.size()) goto L32;
        KernelCpuThreadReader.ThreadCpuUsage threadCpuUsage = threadCpuUsages.get(j);
        if (threadCpuUsage.usageTimesMillis.length != cpuFrequencies.length) goto L22;
        int[] frequencies = new int[r6];
        int[] usageTimesMillis = new int[r6];
        int k = 0;
    L25:
        if (k >= r6) goto L31;
        if (k >= cpuFrequencies.length) goto L29;
        frequencies[k] = cpuFrequencies[k];
        usageTimesMillis[k] = threadCpuUsage.usageTimesMillis[k];
    L30:
        k = k + 1;
        goto L25
    L29:
        frequencies[k] = r8;
        usageTimesMillis[k] = r8;
        goto L30
    L31:
        int k2 = processCpuUsage.uid;
        int r37 = r3;
        int r38 = r8;
        pulledData.add(FrameworkStatsLog.buildStatsEvent(atomTag, k2, processCpuUsage.processId, threadCpuUsage.threadId, processCpuUsage.processName, threadCpuUsage.threadName, frequencies[r38], usageTimesMillis[r38], frequencies[r37], usageTimesMillis[r37], frequencies[2], usageTimesMillis[2], frequencies[3], usageTimesMillis[3], frequencies[4], usageTimesMillis[4], frequencies[5], usageTimesMillis[5], frequencies[6], usageTimesMillis[6], frequencies[7], usageTimesMillis[7]));
        j = j + 1;
        r3 = r37;
        r8 = r38;
        r6 = 8;
        goto L19
    L22:
        String message2 = "Unexpected number of usage times, expected " + cpuFrequencies.length + " but got " + threadCpuUsage.usageTimesMillis.length;
        Slog.w(TAG, message2);
        return r3;
    L32:
        i = i + 1;
        r6 = 8;
        goto L15
    L34:
        return 0;
    }

    private long milliAmpHrsToNanoAmpSecs(double mAh) {
        return (long) ((3.6E9d * mAh) + 0.5d);
    }

    private void registerDeviceCalculatedPowerUse() {
        this.mStatsManager.setPullAtomCallback(FrameworkStatsLog.DEVICE_CALCULATED_POWER_USE, null, ConcurrentUtils.DIRECT_EXECUTOR, this.mStatsCallbackImpl);
    }

    int pullDeviceCalculatedPowerUseLocked(int atomTag, List<StatsEvent> pulledData) {
        BatteryStatsManager bsm = (BatteryStatsManager) this.mContext.getSystemService(BatteryStatsManager.class);
        BatteryUsageStats stats = bsm.getBatteryUsageStats();     // Catch: Exception -> L6
        pulledData.add(FrameworkStatsLog.buildStatsEvent(atomTag, milliAmpHrsToNanoAmpSecs(stats.getConsumedPower())));     // Catch: Exception -> L6
        return 0;
    L6:
        e = move-exception;
        Log.e(TAG, "Could not obtain battery usage stats", e);
        return 1;
    }

    private void registerDebugElapsedClock() {
        StatsManager.PullAtomMetadata metadata = new StatsManager.PullAtomMetadata.Builder().setAdditiveFields(new int[]{1, 2, 3, 4}).build();
        this.mStatsManager.setPullAtomCallback(FrameworkStatsLog.DEBUG_ELAPSED_CLOCK, metadata, ConcurrentUtils.DIRECT_EXECUTOR, this.mStatsCallbackImpl);
    }

    int pullDebugElapsedClockLocked(int atomTag, List<StatsEvent> pulledData) {
        long elapsedMillis = SystemClock.elapsedRealtime();
        long r5 = 0;
        if (this.mDebugElapsedClockPreviousValue != 0) goto L5;
    L4:
        long clockDiffMillis = r5;
        pulledData.add(FrameworkStatsLog.buildStatsEvent(atomTag, this.mDebugElapsedClockPullCount, elapsedMillis, elapsedMillis, clockDiffMillis, 1));
        if ((this.mDebugElapsedClockPullCount % 2) != 1) goto L9;
        pulledData.add(FrameworkStatsLog.buildStatsEvent(atomTag, this.mDebugElapsedClockPullCount, elapsedMillis, elapsedMillis, clockDiffMillis, 2));
    L9:
        this.mDebugElapsedClockPullCount++;
        this.mDebugElapsedClockPreviousValue = elapsedMillis;
        return 0;
    L5:
        r5 = elapsedMillis - this.mDebugElapsedClockPreviousValue;
        goto L4
    }

    private void registerDebugFailingElapsedClock() {
        StatsManager.PullAtomMetadata metadata = new StatsManager.PullAtomMetadata.Builder().setAdditiveFields(new int[]{1, 2, 3, 4}).build();
        this.mStatsManager.setPullAtomCallback(FrameworkStatsLog.DEBUG_FAILING_ELAPSED_CLOCK, metadata, ConcurrentUtils.DIRECT_EXECUTOR, this.mStatsCallbackImpl);
    }

    int pullDebugFailingElapsedClockLocked(int atomTag, List<StatsEvent> pulledData) {
        long elapsedMillis = SystemClock.elapsedRealtime();
        long r0 = this.mDebugFailingElapsedClockPullCount;
        this.mDebugFailingElapsedClockPullCount = 1 + r0;
        if ((r0 % 5) != 0) goto L6;
        this.mDebugFailingElapsedClockPreviousValue = elapsedMillis;
        Slog.e(TAG, "Failing debug elapsed clock");
        return 1;
    L6:
        long r1 = this.mDebugFailingElapsedClockPullCount;
        if (this.mDebugFailingElapsedClockPreviousValue != 0) goto L9;
        long r7 = 0;
    L10:
        pulledData.add(FrameworkStatsLog.buildStatsEvent(atomTag, r1, elapsedMillis, elapsedMillis, r7));
        this.mDebugFailingElapsedClockPreviousValue = elapsedMillis;
        return 0;
    L9:
        r7 = elapsedMillis - this.mDebugFailingElapsedClockPreviousValue;
        goto L10
    }

    private void registerBuildInformation() {
        this.mStatsManager.setPullAtomCallback(FrameworkStatsLog.BUILD_INFORMATION, null, ConcurrentUtils.DIRECT_EXECUTOR, this.mStatsCallbackImpl);
    }

    int pullBuildInformationLocked(int atomTag, List<StatsEvent> pulledData) {
        pulledData.add(FrameworkStatsLog.buildStatsEvent(atomTag, Build.FINGERPRINT, Build.BRAND, Build.PRODUCT, Build.DEVICE, Build.VERSION.RELEASE_OR_CODENAME, Build.ID, Build.VERSION.INCREMENTAL, Build.TYPE, Build.TAGS));
        return 0;
    }

    private void registerRoleHolder() {
        this.mStatsManager.setPullAtomCallback(FrameworkStatsLog.ROLE_HOLDER, null, ConcurrentUtils.DIRECT_EXECUTOR, this.mStatsCallbackImpl);
    }

    int pullRoleHolderLocked(int atomTag, List<StatsEvent> pulledData) {
        long callingToken = Binder.clearCallingIdentity();
        PackageManager pm = this.mContext.getPackageManager();     // Catch: Throwable -> L33
        RoleManagerLocal roleManagerLocal = (RoleManagerLocal) LocalManagerRegistry.getManager(RoleManagerLocal.class);     // Catch: Throwable -> L33
        List<UserInfo> users = ((UserManager) this.mContext.getSystemService(UserManager.class)).getUsers();     // Catch: Throwable -> L33
        int numUsers = users.size();     // Catch: Throwable -> L33
        int userNum = 0;
    L4:
        int r12 = 0;
        if (userNum >= numUsers) goto L39;
        int userId = users.get(userNum).getUserHandle().getIdentifier();     // Catch: Throwable -> L33
        Map<String, Set<String>> roles = roleManagerLocal.getRolesAndHolders(userId);     // Catch: Throwable -> L33
        Iterator<Map.Entry<String, Set<String>>> r15 = roles.entrySet().iterator();     // Catch: Throwable -> L33
    L8:
        if (r15.hasNext() == false) goto L38;
        Map.Entry<String, Set<String>> roleEntry = r15.next();     // Catch: Throwable -> L33
        String roleName = roleEntry.getKey();     // Catch: Throwable -> L33
        Set<String> packageNames = roleEntry.getValue();     // Catch: Throwable -> L33
        if (packageNames.isEmpty() == true) goto L36;
        Iterator<String> r19 = packageNames.iterator();     // Catch: Throwable -> L33
    L13:
        if (r19.hasNext() == false) goto L35;
        String packageName = r19.next();     // Catch: Throwable -> L33
        PackageInfo pkg = pm.getPackageInfoAsUser(packageName, r12, userId);     // Catch: Throwable -> L20 PackageManager.NameNotFoundException -> L24
        int r20 = r12;
        int uid = pkg.applicationInfo.uid;     // Catch: Throwable -> L20 PackageManager.NameNotFoundException -> L22
        int uid2 = uid;
    L29:
        long callingToken2 = callingToken;
        String roleName2 = roleName;
        pulledData.add(FrameworkStatsLog.buildStatsEvent(atomTag, uid2, packageName, roleName2));     // Catch: Throwable -> L31
        roleName = roleName2;
        r12 = r20;
        callingToken = callingToken2;
    L31:
        t = th;
    L53:
        Log.e(TAG, "Could not read role holders", t);     // Catch: Throwable -> L45
        Binder.restoreCallingIdentity(callingToken2);
        return 1;
    L45:
        t = move-exception;
        Binder.restoreCallingIdentity(callingToken2);
        throw t;
    L22:
        e = e;
    L27:
        Slog.w(TAG, "Role holder " + packageName + " not found for user " + userId);     // Catch: Throwable -> L33
        uid2 = -1;
    L24:
        e = e;
        r20 = r12;
    L20:
        t = th;
        callingToken2 = callingToken;
        goto L53
    L35:
        long callingToken3 = callingToken;
        int r21 = r12;
    L37:
        r12 = r21;
        callingToken = callingToken3;
        goto L8
    L36:
        callingToken3 = callingToken;
        r21 = r12;
        pulledData.add(FrameworkStatsLog.buildStatsEvent(atomTag, -1, "", roleName));     // Catch: Throwable -> L31
        goto L37
    L38:
        userNum = userNum + 1;
        goto L4
    L39:
        Binder.restoreCallingIdentity(callingToken);
        return 0;
    L33:
        t = th;
        callingToken2 = callingToken;
        goto L53
    }

    private void registerDangerousPermissionState() {
        this.mStatsManager.setPullAtomCallback(FrameworkStatsLog.DANGEROUS_PERMISSION_STATE, null, ConcurrentUtils.DIRECT_EXECUTOR, this.mStatsCallbackImpl);
    }

    int pullDangerousPermissionStateLocked(int atomTag, List<StatsEvent> pulledData) {
        long token = Binder.clearCallingIdentity();
        float samplingRate = DeviceConfig.getFloat("permissions", DANGEROUS_PERMISSION_STATE_SAMPLE_RATE, 0.015f);
        Set<Integer> reportedUids = new HashSet();
        PackageManager pm = this.mContext.getPackageManager();     // Catch: Throwable -> L68
        List<UserInfo> users = ((UserManager) this.mContext.getSystemService(UserManager.class)).getUsers();     // Catch: Throwable -> L68
        int numUsers = users.size();     // Catch: Throwable -> L68
        int userNum = 0;
    L4:
        if (userNum >= numUsers) goto L70;
        UserHandle user = users.get(userNum).getUserHandle();     // Catch: Throwable -> L68
        List<PackageInfo> pkgs = pm.getInstalledPackagesAsUser(4096, user.getIdentifier());     // Catch: Throwable -> L68
        int numUsers2 = pkgs.size();     // Catch: Throwable -> L68
        int pkgNum = 0;
        int r17 = 1;
    L7:
        int numPkgs = numUsers2;
        if (pkgNum >= numPkgs) goto L67;
        PackageInfo pkg = pkgs.get(pkgNum);     // Catch: Throwable -> L64
        if (pkg.requestedPermissions != null) goto L13;
        List<UserInfo> users2 = users;
        int numUsers3 = numUsers;
        int userNum2 = userNum;
        int numPkgs2 = numPkgs;
        UserHandle user2 = user;
        List<PackageInfo> pkgs2 = pkgs;
        long token2 = token;
    L63:
        pkgNum = pkgNum + 1;
        atomTag = atomTag;
        numUsers = numUsers3;
        token = token2;
        users = users2;
        userNum = userNum2;
        user = user2;
        pkgs = pkgs2;
        numUsers2 = numPkgs2;
        goto L7
    L13:
        if (reportedUids.contains(Integer.valueOf(pkg.applicationInfo.uid)) == false) goto L15;
        users2 = users;
        numUsers3 = numUsers;
        userNum2 = userNum;
        numPkgs2 = numPkgs;
        user2 = user;
        pkgs2 = pkgs;
        token2 = token;
        goto L63
    L15:
        reportedUids.add(Integer.valueOf(pkg.applicationInfo.uid));     // Catch: Throwable -> L64
        if (atomTag == 10067) goto L85;
    L24:
        int numUsers4 = pkg.requestedPermissions.length;     // Catch: Throwable -> L64
        token2 = token;
        int permNum = 0;
    L26:
        int numPerms = numUsers4;
        if (permNum >= numPerms) goto L62;
        List<UserInfo> users3 = users;
        String permName = pkg.requestedPermissions[permNum];     // Catch: Throwable -> L35
        int numUsers5 = numUsers;
        PermissionInfo r0 = pm.getPermissionInfo(permName, 0);     // Catch: Throwable -> L35 PackageManager.NameNotFoundException -> L58
        int permissionFlags = pm.getPermissionFlags(permName, pkg.packageName, user);     // Catch: Throwable -> L35 PackageManager.NameNotFoundException -> L55
        if (permName.startsWith(COMMON_PERMISSION_PREFIX) == false) goto L39;
        permName = permName.substring(COMMON_PERMISSION_PREFIX.length());     // Catch: Throwable -> L35
    L39:
        if (atomTag != 10050) goto L45;
        int permissionFlags2 = pkg.applicationInfo.uid;     // Catch: Throwable -> L35
        int userNum3 = userNum;
        if ((pkg.requestedPermissionsFlags[permNum] & 2) == 0) goto L43;
        boolean r6 = true;
    L44:
        int userNum4 = userNum3;
        StatsEvent e = FrameworkStatsLog.buildStatsEvent(atomTag, permName, permissionFlags2, "", r6, permissionFlags, r0.getProtection() | r0.getProtectionFlags());     // Catch: Throwable -> L35
    L91:
        pulledData.add(e);     // Catch: Throwable -> L53
    L61:
        permNum = permNum + 1;
        atomTag = atomTag;
        numUsers = numUsers5;
        users = users3;
        userNum = userNum4;
        user = user;
        pkgs = pkgs;
        numPkgs = numPkgs;
        numUsers4 = numPerms;
    L53:
        t = th;
    L89:
        Log.e(TAG, "Could not read permissions", t);     // Catch: Throwable -> L76
        Binder.restoreCallingIdentity(token2);
        return r17;
    L76:
        t = move-exception;
        Binder.restoreCallingIdentity(token2);
        throw t;
    L43:
        r6 = false;
        goto L44
    L45:
        userNum4 = userNum;
        int r4 = pkg.applicationInfo.uid;     // Catch: Throwable -> L35
        if ((pkg.requestedPermissionsFlags[permNum] & 2) == 0) goto L48;
        boolean r5 = true;
    L49:
        e = FrameworkStatsLog.buildStatsEvent(atomTag, permName, r4, r5, permissionFlags, r0.getProtection() | r0.getProtectionFlags());     // Catch: Throwable -> L35
        goto L91
    L48:
        r5 = false;
    L56:
        userNum4 = userNum;
        numPkgs = numPkgs;
        user = user;
        pkgs = pkgs;
    L59:
        userNum4 = userNum;
        numPkgs = numPkgs;
        user = user;
        pkgs = pkgs;
    L35:
        t = th;
        goto L89
    L62:
        users2 = users;
        numUsers3 = numUsers;
        userNum2 = userNum;
        numPkgs2 = numPkgs;
        user2 = user;
        pkgs2 = pkgs;
        goto L63
    L85:
        if (ThreadLocalRandom.current().nextFloat() <= samplingRate) goto L24;
        users2 = users;
        numUsers3 = numUsers;
        userNum2 = userNum;
        numPkgs2 = numPkgs;
        user2 = user;
        pkgs2 = pkgs;
        token2 = token;
    L22:
        t = th;
        token2 = token;
    L64:
        t = th;
        token2 = token;
        goto L89
    L67:
        userNum = userNum + 1;
        goto L4
    L70:
        Binder.restoreCallingIdentity(token);
        return 0;
    L68:
        t = th;
        token2 = token;
        r17 = 1;
        goto L89
    }

    private void registerTimeZoneDataInfo() {
        this.mStatsManager.setPullAtomCallback(FrameworkStatsLog.TIME_ZONE_DATA_INFO, null, ConcurrentUtils.DIRECT_EXECUTOR, this.mStatsCallbackImpl);
    }

    int pullTimeZoneDataInfoLocked(int atomTag, List<StatsEvent> pulledData) {
        String tzDbVersion = TimeZone.getTZDataVersion();     // Catch: MissingResourceException -> L6
        pulledData.add(FrameworkStatsLog.buildStatsEvent(atomTag, tzDbVersion));
        return 0;
    L6:
        e = move-exception;
        Slog.e(TAG, "Getting tzdb version failed: ", e);
        return 1;
    }

    private void registerTimeZoneDetectorState() {
        this.mStatsManager.setPullAtomCallback(FrameworkStatsLog.TIME_ZONE_DETECTOR_STATE, null, ConcurrentUtils.DIRECT_EXECUTOR, this.mStatsCallbackImpl);
    }

    int pullTimeZoneDetectorStateLocked(int atomTag, List<StatsEvent> pulledData) {
        long token = Binder.clearCallingIdentity();
        TimeZoneDetectorInternal timeZoneDetectorInternal = (TimeZoneDetectorInternal) LocalServices.getService(TimeZoneDetectorInternal.class);     // Catch: Throwable -> L12 RuntimeException -> L14
        MetricsTimeZoneDetectorState metricsState = timeZoneDetectorInternal.generateMetricsState();     // Catch: Throwable -> L12 RuntimeException -> L14
    L22:
        pulledData.add(FrameworkStatsLog.buildStatsEvent(atomTag, metricsState.isTelephonyDetectionSupported(), metricsState.isGeoDetectionSupported(), metricsState.getUserLocationEnabledSetting(), metricsState.getAutoDetectionEnabledSetting(), metricsState.getGeoDetectionEnabledSetting(), convertToMetricsDetectionMode(metricsState.getDetectionMode()), metricsState.getDeviceTimeZoneIdOrdinal(), convertTimeZoneSuggestionToProtoBytes(metricsState.getLatestManualSuggestion()), convertTimeZoneSuggestionToProtoBytes(metricsState.getLatestTelephonySuggestion()), convertTimeZoneSuggestionToProtoBytes(metricsState.getLatestGeolocationSuggestion()), metricsState.isTelephonyTimeZoneFallbackSupported(), metricsState.getDeviceTimeZoneId(), metricsState.isEnhancedMetricsCollectionEnabled(), metricsState.getGeoDetectionRunInBackgroundEnabled()));     // Catch: Throwable -> L8 RuntimeException -> L10
        Binder.restoreCallingIdentity(token);
        return 0;
    L10:
        e = e;
    L17:
        Slog.e(TAG, "Getting time zone detection state failed: ", e);     // Catch: Throwable -> L8
        Binder.restoreCallingIdentity(token);
        return 1;
    L8:
        e = th;
    L20:
        Binder.restoreCallingIdentity(token);
        throw e;
    L14:
        e = e;
    L12:
        e = th;
        goto L20
    }

    private static int convertToMetricsDetectionMode(int detectionMode) {
        switch(detectionMode) {
            case 1: goto L9;
            case 2: goto L7;
            case 3: goto L5;
            default: goto L3;
        };
    L3:
        return 0;
    L5:
        return 2;
    L7:
        return 3;
    L9:
        return 1;
    }

    private static byte[] convertTimeZoneSuggestionToProtoBytes(MetricsTimeZoneDetectorState.MetricsTimeZoneSuggestion suggestion) {
        if (suggestion != null) goto L5;
        return null;
    L5:
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        ProtoOutputStream protoOutputStream = new ProtoOutputStream(byteArrayOutputStream);
        if (suggestion.isCertain() == false) goto L8;
        int typeProtoValue = 1;
    L9:
        protoOutputStream.write(1159641169921L, typeProtoValue);
        if (suggestion.isCertain() == false) goto L20;
        int[] r3 = suggestion.getZoneIdOrdinals();
        int r4 = r3.length;
        int r5 = 0;
        int r6 = 0;
    L12:
        if (r6 >= r4) goto L14;
        int zoneIdOrdinal = r3[r6];
        protoOutputStream.write(2220498092034L, zoneIdOrdinal);
        r6 = r6 + 1;
        goto L12
    L14:
        String[] zoneIds = suggestion.getZoneIds();
        if (zoneIds == null) goto L20;
        int r7 = zoneIds.length;
    L18:
        if (r5 >= r7) goto L20;
        String zoneId = zoneIds[r5];
        protoOutputStream.write(2237677961219L, zoneId);
        r5 = r5 + 1;
    L20:
        protoOutputStream.flush();
        IoUtils.closeQuietly(byteArrayOutputStream);
        return byteArrayOutputStream.toByteArray();
    L8:
        typeProtoValue = 2;
        goto L9
    }

    private void registerExternalStorageInfo() {
        this.mStatsManager.setPullAtomCallback(FrameworkStatsLog.EXTERNAL_STORAGE_INFO, null, ConcurrentUtils.DIRECT_EXECUTOR, this.mStatsCallbackImpl);
    }

    int pullExternalStorageInfoLocked(int atomTag, List<StatsEvent> pulledData) {
        if (this.mStorageManager != null) goto L5;
        return 1;
    L5:
        List<VolumeInfo> volumes = this.mStorageManager.getVolumes();
        Iterator<VolumeInfo> r2 = volumes.iterator();
    L7:
        if (r2.hasNext() == false) goto L27;
        VolumeInfo vol = r2.next();
        String envState = VolumeInfo.getEnvironmentForState(vol.getState());
        DiskInfo diskInfo = vol.getDisk();
        if (diskInfo == null) goto L7;
        if (envState.equals("mounted") == false) goto L7;
        int volumeType = 3;
        if (vol.getType() != 0) goto L16;
        volumeType = 1;
    L19:
        if (diskInfo.isSd() == false) goto L22;
        int externalStorageType = 1;
    L25:
        pulledData.add(FrameworkStatsLog.buildStatsEvent(atomTag, externalStorageType, volumeType, diskInfo.size));
        goto L7
    L22:
        if (diskInfo.isUsb() == false) goto L24;
        externalStorageType = 2;
        goto L25
    L24:
        externalStorageType = 3;
        goto L25
    L16:
        if (vol.getType() != 1) goto L19;
        volumeType = 2;
        goto L19
    L27:
        return 0;
    }

    private void registerAppsOnExternalStorageInfo() {
        this.mStatsManager.setPullAtomCallback(FrameworkStatsLog.APPS_ON_EXTERNAL_STORAGE_INFO, null, ConcurrentUtils.DIRECT_EXECUTOR, this.mStatsCallbackImpl);
    }

    int pullAppsOnExternalStorageInfoLocked(int atomTag, List<StatsEvent> pulledData) {
        if (this.mStorageManager != null) goto L6;
        return 1;
    L6:
        PackageManager pm = this.mContext.getPackageManager();
        List<ApplicationInfo> apps = pm.getInstalledApplications(0);
        Iterator<ApplicationInfo> r3 = apps.iterator();
    L8:
        if (r3.hasNext() == false) goto L31;
        ApplicationInfo appInfo = r3.next();
        UUID storageUuid = appInfo.storageUuid;
        if (storageUuid == null) goto L8;
        VolumeInfo volumeInfo = this.mStorageManager.findVolumeByUuid(appInfo.storageUuid.toString());
        if (volumeInfo == null) goto L8;
        DiskInfo diskInfo = volumeInfo.getDisk();
        if (diskInfo == null) goto L8;
        int externalStorageType = -1;
        if (diskInfo.isSd() == false) goto L22;
        externalStorageType = 1;
    L28:
        if (externalStorageType == (-1)) goto L8;
        pulledData.add(FrameworkStatsLog.buildStatsEvent(atomTag, externalStorageType, appInfo.packageName));
        goto L8
    L22:
        if (diskInfo.isUsb() == false) goto L25;
        externalStorageType = 2;
        goto L28
    L25:
        if (appInfo.isExternal() == false) goto L28;
        externalStorageType = 3;
        goto L28
    L31:
        return 0;
    }

    private void registerFaceSettings() {
        this.mStatsManager.setPullAtomCallback(FrameworkStatsLog.FACE_SETTINGS, null, ConcurrentUtils.DIRECT_EXECUTOR, this.mStatsCallbackImpl);
    }

    /* JADX WARN: Multi-variable type inference failed */
    int pullFaceSettingsLocked(int atomTag, List<StatsEvent> pulledData) {
        long callingToken = Binder.clearCallingIdentity();
        UserManager manager = (UserManager) this.mContext.getSystemService(UserManager.class);     // Catch: Throwable -> L36
        int r4 = 1;
        if (manager != null) goto L8;
        Binder.restoreCallingIdentity(callingToken);
        return 1;
    L8:
        List<UserInfo> users = manager.getUsers();     // Catch: Throwable -> L36
        int numUsers = users.size();     // Catch: Throwable -> L36
        int userNum = 0;
    L10:
        if (userNum >= numUsers) goto L38;
        int userId = users.get(userNum).getUserHandle().getIdentifier();     // Catch: Throwable -> L36
        int unlockKeyguardEnabled = Settings.Secure.getIntForUser(this.mContext.getContentResolver(), "face_unlock_keyguard_enabled", r4, userId);     // Catch: Throwable -> L36
        int unlockDismissesKeyguard = Settings.Secure.getIntForUser(this.mContext.getContentResolver(), "face_unlock_dismisses_keyguard", r4, userId);     // Catch: Throwable -> L36
        int unlockAttentionRequired = Settings.Secure.getIntForUser(this.mContext.getContentResolver(), "face_unlock_attention_required", 0, userId);     // Catch: Throwable -> L36
        int unlockAppEnabled = Settings.Secure.getIntForUser(this.mContext.getContentResolver(), "face_unlock_app_enabled", r4, userId);     // Catch: Throwable -> L36
        int unlockAlwaysRequireConfirmation = Settings.Secure.getIntForUser(this.mContext.getContentResolver(), "face_unlock_always_require_confirmation", 0, userId);     // Catch: Throwable -> L36
        int unlockDiversityRequired = Settings.Secure.getIntForUser(this.mContext.getContentResolver(), "face_unlock_diversity_required", r4, userId);     // Catch: Throwable -> L36
        if (unlockKeyguardEnabled == 0) goto L14;
        boolean r18 = r4;
    L15:
        if (unlockDismissesKeyguard == 0) goto L17;
        boolean r19 = r4;
    L18:
        if (unlockAttentionRequired == 0) goto L20;
        boolean r20 = r4;
    L21:
        if (unlockAppEnabled == 0) goto L23;
        boolean r21 = r4;
    L24:
        if (unlockAlwaysRequireConfirmation == 0) goto L26;
        boolean r22 = r4;
    L27:
        if (unlockDiversityRequired == 0) goto L29;
        boolean r23 = r4;
    L30:
        pulledData.add(FrameworkStatsLog.buildStatsEvent(atomTag, r18, r19, r20, r21, r22, r23));     // Catch: Throwable -> L34
        userNum = userNum + 1;
        r4 = 1;
    L34:
        th = th;
    L40:
        Binder.restoreCallingIdentity(callingToken);
        throw th;
    L29:
        r23 = 0;
        goto L30
    L26:
        r22 = 0;
        goto L27
    L23:
        r21 = 0;
        goto L24
    L20:
        r20 = 0;
        goto L21
    L17:
        r19 = 0;
        goto L18
    L14:
        r18 = 0;
        goto L15
    L38:
        Binder.restoreCallingIdentity(callingToken);
        return 0;
    L36:
        th = th;
        goto L40
    }

    private void registerAppOps() {
        this.mStatsManager.setPullAtomCallback(FrameworkStatsLog.APP_OPS, null, ConcurrentUtils.DIRECT_EXECUTOR, this.mStatsCallbackImpl);
    }

    private void registerRuntimeAppOpAccessMessage() {
        this.mStatsManager.setPullAtomCallback(FrameworkStatsLog.RUNTIME_APP_OP_ACCESS, null, ConcurrentUtils.DIRECT_EXECUTOR, this.mStatsCallbackImpl);
    }

    int pullAppOpsLocked(int atomTag, List<StatsEvent> pulledData) {
        long token = Binder.clearCallingIdentity();
        AppOpsManager appOps = (AppOpsManager) this.mContext.getSystemService(AppOpsManager.class);     // Catch: Throwable -> L7
        CompletableFuture<AppOpsManager.HistoricalOps> ops = new CompletableFuture();     // Catch: Throwable -> L7
        AppOpsManager.HistoricalOpsRequest histOpsRequest = new AppOpsManager.HistoricalOpsRequest.Builder(0, Long.MAX_VALUE).setFlags(9).build();     // Catch: Throwable -> L7
        appOps.getHistoricalOps(histOpsRequest, AsyncTask.THREAD_POOL_EXECUTOR, new StatsPullAtomService$$ExternalSyntheticLambda0(ops));     // Catch: Throwable -> L7
        AppOpsManager.HistoricalOps histOps = ops.get(2000, TimeUnit.MILLISECONDS);     // Catch: Throwable -> L7
        List<AppOpEntry> opsList = processHistoricalOps(histOps, atomTag, 100);     // Catch: Throwable -> L7
        int samplingRate = sampleAppOps(pulledData, opsList, atomTag, 100);     // Catch: Throwable -> L7
        if (samplingRate == 100) goto L9;
        Slog.e(TAG, "Atom 10060 downsampled - too many dimensions");     // Catch: Throwable -> L7
    L9:
        Binder.restoreCallingIdentity(token);
        return 0;
    L7:
        t = move-exception;
        Slog.e(TAG, "Could not read appops", t);     // Catch: Throwable -> L15
        Binder.restoreCallingIdentity(token);
        return 1;
    L15:
        th = move-exception;
        Binder.restoreCallingIdentity(token);
        throw th;
    }

    private int sampleAppOps(List<StatsEvent> pulledData, List<AppOpEntry> opsList, int atomTag, int samplingRate) {
        List<AppOpEntry> r2 = opsList;
        int r3 = atomTag;
        int r4 = samplingRate;
        int nOps = r2.size();
        int i = 0;
    L3:
        if (i >= nOps) goto L16;
        AppOpEntry entry = r2.get(i);
        if (entry.mHash < r4) goto L7;
        samplingRate = r4;
        int nOps2 = nOps;
        int i2 = i;
    L15:
        i = i2 + 1;
        r4 = samplingRate;
        nOps = nOps2;
        r2 = opsList;
        goto L3
    L7:
        if (isHealthAppOp(entry.mOp.getOpCode()) == false) goto L10;
        samplingRate = r4;
        nOps2 = nOps;
        i2 = i;
        goto L15
    L10:
        if (r3 != 10075) goto L12;
        int nOps3 = nOps;
        int i3 = i;
        r3 = atomTag;
        nOps2 = nOps3;
        i2 = i3;
        StatsEvent e = FrameworkStatsLog.buildStatsEvent(r3, entry.mUid, entry.mPackageName, entry.mAttributionTag, entry.mOp.getOpCode(), entry.mOp.getForegroundAccessCount(9), entry.mOp.getBackgroundAccessCount(9), entry.mOp.getForegroundRejectCount(9), entry.mOp.getBackgroundRejectCount(9), entry.mOp.getForegroundAccessDuration(9), entry.mOp.getBackgroundAccessDuration(9), this.mDangerousAppOpsList.contains(Integer.valueOf(entry.mOp.getOpCode())), samplingRate);
    L13:
        pulledData.add(e);
        goto L15
    L12:
        nOps2 = nOps;
        i2 = i;
        r3 = atomTag;
        e = FrameworkStatsLog.buildStatsEvent(r3, entry.mUid, entry.mPackageName, entry.mOp.getOpCode(), entry.mOp.getForegroundAccessCount(9), entry.mOp.getBackgroundAccessCount(9), entry.mOp.getForegroundRejectCount(9), entry.mOp.getBackgroundRejectCount(9), entry.mOp.getForegroundAccessDuration(9), entry.mOp.getBackgroundAccessDuration(9), this.mDangerousAppOpsList.contains(Integer.valueOf(entry.mOp.getOpCode())));
        goto L13
    L16:
        int r5 = r4;
        if (pulledData.size() <= 800) goto L21;
        int adjustedSamplingRate = MathUtils.constrain((r5 * 500) / pulledData.size(), 0, r5 - 1);
        pulledData.clear();
        return sampleAppOps(pulledData, opsList, r3, adjustedSamplingRate);
    L21:
        return r5;
    }

    private void registerAttributedAppOps() {
        this.mStatsManager.setPullAtomCallback(FrameworkStatsLog.ATTRIBUTED_APP_OPS, null, ConcurrentUtils.DIRECT_EXECUTOR, this.mStatsCallbackImpl);
    }

    int pullAttributedAppOpsLocked(int atomTag, List<StatsEvent> pulledData) {
        long token = Binder.clearCallingIdentity();
        AppOpsManager appOps = (AppOpsManager) this.mContext.getSystemService(AppOpsManager.class);     // Catch: Throwable -> L6
        CompletableFuture<AppOpsManager.HistoricalOps> ops = new CompletableFuture();     // Catch: Throwable -> L6
        AppOpsManager.HistoricalOpsRequest histOpsRequest = new AppOpsManager.HistoricalOpsRequest.Builder(0, Long.MAX_VALUE).setFlags(9).build();     // Catch: Throwable -> L6
        appOps.getHistoricalOps(histOpsRequest, AsyncTask.THREAD_POOL_EXECUTOR, new StatsPullAtomService$$ExternalSyntheticLambda0(ops));     // Catch: Throwable -> L6
        AppOpsManager.HistoricalOps histOps = ops.get(2000, TimeUnit.MILLISECONDS);     // Catch: Throwable -> L6
        if (this.mAppOpsSamplingRate != 0) goto L8;
        this.mContext.getMainThreadHandler().postDelayed(new AnonymousClass4(this), APP_OPS_SAMPLING_INITIALIZATION_DELAY_MILLIS);     // Catch: Throwable -> L6
        this.mAppOpsSamplingRate = 100;     // Catch: Throwable -> L6
    L8:
        List<AppOpEntry> opsList = processHistoricalOps(histOps, atomTag, this.mAppOpsSamplingRate);     // Catch: Throwable -> L6
        int newSamplingRate = sampleAppOps(pulledData, opsList, atomTag, this.mAppOpsSamplingRate);     // Catch: Throwable -> L6
        this.mAppOpsSamplingRate = Math.min(this.mAppOpsSamplingRate, newSamplingRate);     // Catch: Throwable -> L6
        Binder.restoreCallingIdentity(token);
        return 0;
    L6:
        t = move-exception;
        Slog.e(TAG, "Could not read appops", t);     // Catch: Throwable -> L15
        Binder.restoreCallingIdentity(token);
        return 1;
    L15:
        t = move-exception;
        Binder.restoreCallingIdentity(token);
        throw t;
    }

    private void estimateAppOpsSamplingRate() throws Exception {
        int appOpsTargetCollectionSize = DeviceConfig.getInt("permissions", APP_OPS_TARGET_COLLECTION_SIZE, 2000);
        AppOpsManager appOps = (AppOpsManager) this.mContext.getSystemService(AppOpsManager.class);
        CompletableFuture<AppOpsManager.HistoricalOps> ops = new CompletableFuture();
        AppOpsManager.HistoricalOpsRequest histOpsRequest = new AppOpsManager.HistoricalOpsRequest.Builder(Math.max(Instant.now().minus(1, ChronoUnit.DAYS).toEpochMilli(), 0), Long.MAX_VALUE).setFlags(9).build();
        appOps.getHistoricalOps(histOpsRequest, AsyncTask.THREAD_POOL_EXECUTOR, new StatsPullAtomService$$ExternalSyntheticLambda0(ops));
        AppOpsManager.HistoricalOps histOps = ops.get(2000, TimeUnit.MILLISECONDS);
        List<AppOpEntry> opsList = processHistoricalOps(histOps, FrameworkStatsLog.ATTRIBUTED_APP_OPS, 100);
        long estimatedSize = 0;
        int nOps = opsList.size();
        int i = 0;
    L3:
        if (i >= nOps) goto L9;
        AppOpEntry entry = opsList.get(i);
        int r12 = entry.mPackageName.length() + 32;
        if (entry.mAttributionTag != null) goto L7;
        int r13 = 1;
    L8:
        estimatedSize = estimatedSize + ((long) (r12 + r13));
        i = i + 1;
        goto L3
    L7:
        r13 = entry.mAttributionTag.length();
        goto L8
    L9:
        int i2 = appOpsTargetCollectionSize * 100;
        int estimatedSamplingRate = (int) MathUtils.constrain(((long) i2) / estimatedSize, 0, 100);
        Object r14 = this.mAttributedAppOpsLock;
        monitor-enter(r14);
        this.mAppOpsSamplingRate = Math.min(this.mAppOpsSamplingRate, estimatedSamplingRate);     // Catch: Throwable -> L14
        monitor-exit(r14);     // Catch: Throwable -> L14
        return;
    L14:
        th = move-exception;
        throw th;
    }

    private List<AppOpEntry> processHistoricalOps(AppOpsManager.HistoricalOps histOps, int atomTag, int samplingRatio) {
        List<AppOpEntry> opsList = new ArrayList();
        int uidIdx = 0;
    L4:
        if (uidIdx >= histOps.getUidCount()) goto L28;
        AppOpsManager.HistoricalUidOps uidOps = histOps.getUidOpsAt(uidIdx);
        int uid = uidOps.getUid();
        int pkgIdx = 0;
    L7:
        if (pkgIdx >= uidOps.getPackageCount()) goto L26;
        AppOpsManager.HistoricalPackageOps packageOps = uidOps.getPackageOpsAt(pkgIdx);
        if (atomTag != 10075) goto L20;
        int attributionIdx = 0;
    L12:
        if (attributionIdx >= packageOps.getAttributedOpsCount()) goto L25;
        AppOpsManager.AttributedHistoricalOps attributedOps = packageOps.getAttributedOpsAt(attributionIdx);
        int opIdx = 0;
    L15:
        if (opIdx >= attributedOps.getOpCount()) goto L17;
        AppOpsManager.HistoricalOp op = attributedOps.getOpAt(opIdx);
        processHistoricalOp(op, opsList, uid, samplingRatio, packageOps.getPackageName(), attributedOps.getTag());
        opIdx = opIdx + 1;
        goto L15
    L17:
        attributionIdx = attributionIdx + 1;
    L25:
        pkgIdx = pkgIdx + 1;
        goto L7
    L20:
        if (atomTag != 10060) goto L25;
        int opIdx2 = 0;
    L23:
        if (opIdx2 >= packageOps.getOpCount()) goto L25;
        AppOpsManager.HistoricalOp op2 = packageOps.getOpAt(opIdx2);
        processHistoricalOp(op2, opsList, uid, samplingRatio, packageOps.getPackageName(), null);
        opIdx2 = opIdx2 + 1;
        goto L23
    L26:
        uidIdx = uidIdx + 1;
        goto L4
    L28:
        return opsList;
    }

    private void processHistoricalOp(AppOpsManager.HistoricalOp op, List<AppOpEntry> opsList, int uid, int samplingRatio, String packageName, String attributionTag) {
        int firstChar = 0;
        if (attributionTag == null) goto L12;
        if (attributionTag.startsWith(packageName) == false) goto L12;
        firstChar = packageName.length();
        if (firstChar >= attributionTag.length()) goto L12;
        if (attributionTag.charAt(firstChar) != '.') goto L12;
        firstChar = firstChar + 1;
    L12:
        if (attributionTag != null) goto L15;
        String r2 = null;
    L16:
        AppOpEntry entry = new AppOpEntry(this, packageName, r2, op, uid);
        if (entry.mHash >= samplingRatio) goto L20;
        opsList.add(entry);
        return;
    L20:
        return;
    L15:
        r2 = attributionTag.substring(firstChar);
        goto L16
    }

    int pullRuntimeAppOpAccessMessageLocked(int atomTag, List<StatsEvent> pulledData) {
        long token = Binder.clearCallingIdentity();
        AppOpsManager appOps = (AppOpsManager) this.mContext.getSystemService(AppOpsManager.class);     // Catch: Throwable -> L8
        RuntimeAppOpAccessMessage message = appOps.collectRuntimeAppOpAccessMessage();     // Catch: Throwable -> L8
        if (message != null) goto L11;
        Slog.i(TAG, "No runtime appop access message collected");     // Catch: Throwable -> L8
        Binder.restoreCallingIdentity(token);
        return 0;
    L11:
        if (isHealthAppOp(AppOpsManager.strOpToOp(message.getOp())) == false) goto L14;
        Binder.restoreCallingIdentity(token);
        return 1;
    L14:
        int r10 = message.getUid();     // Catch: Throwable -> L8
        String r11 = message.getPackageName();     // Catch: Throwable -> L8
        if (message.getAttributionTag() != null) goto L18;
        String r8 = "";
    L17:
        String r13 = r8;
        pulledData.add(FrameworkStatsLog.buildStatsEvent(atomTag, r10, r11, "", r13, message.getMessage(), message.getSamplingStrategy(), AppOpsManager.strOpToOp(message.getOp())));     // Catch: Throwable -> L24
        Binder.restoreCallingIdentity(token);
        return 0;
    L24:
        t = th;
    L32:
        Slog.e(TAG, "Could not read runtime appop access message", t);     // Catch: Throwable -> L29
        Binder.restoreCallingIdentity(token);
        return 1;
    L29:
        t = move-exception;
        Binder.restoreCallingIdentity(token);
        throw t;
    L18:
        r8 = message.getAttributionTag();     // Catch: Throwable -> L8
    L8:
        t = th;
        goto L32
    }

    static void unpackStreamedData(int atomTag, List<StatsEvent> pulledData, List<ParcelFileDescriptor> statsFiles) throws IOException {
        InputStream stream = new ParcelFileDescriptor.AutoCloseInputStream(statsFiles.get(0));
        int[] len = new int[1];
        byte[] stats = readFully(stream, len);
        pulledData.add(FrameworkStatsLog.buildStatsEvent(atomTag, Arrays.copyOf(stats, len[0])));
    }

    static byte[] readFully(InputStream stream, int[] outLen) throws IOException {
        int pos = 0;
        int initialAvail = stream.available();
        if (initialAvail <= 0) goto L5;
        int r2 = initialAvail + 1;
    L6:
        byte[] data = new byte[r2];
    L7:
        int amt = stream.read(data, pos, data.length - pos);
        Slog.i(TAG, "Read " + amt + " bytes at " + pos + " of avail " + data.length);
        if (amt < 0) goto L9;
        pos = pos + amt;
        if (pos < data.length) goto L7;
        byte[] newData = new byte[pos + 16384];
        Slog.i(TAG, "Copying " + pos + " bytes to new array len " + newData.length);
        System.arraycopy(data, 0, newData, 0, pos);
        data = newData;
        goto L7
    L9:
        Slog.i(TAG, "**** FINISHED READING: pos=" + pos + " len=" + data.length);
        outLen[0] = pos;
        return data;
    L5:
        r2 = 16384;
        goto L6
    }

    private void registerNotificationRemoteViews() {
        this.mStatsManager.setPullAtomCallback(FrameworkStatsLog.NOTIFICATION_REMOTE_VIEWS, null, ConcurrentUtils.DIRECT_EXECUTOR, this.mStatsCallbackImpl);
    }

    int pullNotificationRemoteViewsLocked(int atomTag, List<StatsEvent> pulledData) {
        INotificationManager notificationManagerService = getINotificationManagerService();
        if (notificationManagerService != null) goto L5;
        return 1;
    L5:
        long callingToken = Binder.clearCallingIdentity();
        long wallClockNanos = SystemClock.currentTimeMicro() * 1000;     // Catch: Throwable -> L22 SecurityException -> L24 RemoteException -> L26 IOException -> L28
        long lastNotificationStatsNs = wallClockNanos - TimeUnit.NANOSECONDS.convert(1, TimeUnit.DAYS);     // Catch: Throwable -> L22 SecurityException -> L24 RemoteException -> L26 IOException -> L28
        List<ParcelFileDescriptor> statsFiles = new ArrayList();     // Catch: Throwable -> L22 SecurityException -> L24 RemoteException -> L26 IOException -> L28
        notificationManagerService.pullStats(lastNotificationStatsNs, 1, true, statsFiles);     // Catch: Throwable -> L22 SecurityException -> L24 RemoteException -> L26 IOException -> L28
        if (statsFiles.size() == 1) goto L45;
        Binder.restoreCallingIdentity(callingToken);
        return 1;
    L45:
        unpackStreamedData(atomTag, pulledData, statsFiles);     // Catch: Throwable -> L14 SecurityException -> L16 RemoteException -> L18 IOException -> L20
        Binder.restoreCallingIdentity(callingToken);
        return 0;
    L18:
        e = e;
    L35:
        Slog.e(TAG, "Getting notistats failed: ", e);     // Catch: Throwable -> L14
        Binder.restoreCallingIdentity(callingToken);
        return 1;
    L20:
        e = e;
    L39:
        Slog.e(TAG, "Getting notistats failed: ", e);     // Catch: Throwable -> L14
        Binder.restoreCallingIdentity(callingToken);
        return 1;
    L16:
        e = e;
    L31:
        Slog.e(TAG, "Getting notistats failed: ", e);     // Catch: Throwable -> L14
        Binder.restoreCallingIdentity(callingToken);
        return 1;
    L14:
        e = th;
    L42:
        Binder.restoreCallingIdentity(callingToken);
        throw e;
    L26:
        e = e;
    L28:
        e = e;
    L24:
        e = e;
    L22:
        e = th;
        goto L42
    }

    private void registerDangerousPermissionStateSampled() {
        this.mStatsManager.setPullAtomCallback(FrameworkStatsLog.DANGEROUS_PERMISSION_STATE_SAMPLED, null, ConcurrentUtils.DIRECT_EXECUTOR, this.mStatsCallbackImpl);
    }

    private void registerBatteryLevel() {
        this.mStatsManager.setPullAtomCallback(FrameworkStatsLog.BATTERY_LEVEL, null, ConcurrentUtils.DIRECT_EXECUTOR, this.mStatsCallbackImpl);
    }

    private void registerRemainingBatteryCapacity() {
        this.mStatsManager.setPullAtomCallback(FrameworkStatsLog.REMAINING_BATTERY_CAPACITY, null, ConcurrentUtils.DIRECT_EXECUTOR, this.mStatsCallbackImpl);
    }

    private void registerFullBatteryCapacity() {
        this.mStatsManager.setPullAtomCallback(FrameworkStatsLog.FULL_BATTERY_CAPACITY, null, ConcurrentUtils.DIRECT_EXECUTOR, this.mStatsCallbackImpl);
    }

    private void registerBatteryVoltage() {
        this.mStatsManager.setPullAtomCallback(FrameworkStatsLog.BATTERY_VOLTAGE, null, ConcurrentUtils.DIRECT_EXECUTOR, this.mStatsCallbackImpl);
    }

    private void registerBatteryCycleCount() {
        this.mStatsManager.setPullAtomCallback(FrameworkStatsLog.BATTERY_CYCLE_COUNT, null, ConcurrentUtils.DIRECT_EXECUTOR, this.mStatsCallbackImpl);
    }

    private void registerBatteryHealth() {
        this.mStatsManager.setPullAtomCallback(FrameworkStatsLog.BATTERY_HEALTH, null, ConcurrentUtils.DIRECT_EXECUTOR, this.mStatsCallbackImpl);
    }

    private int pullHealthHalLocked(int atomTag, List<StatsEvent> pulledData) {
        if (this.mHealthService != null) goto L42;
        return 1;
    L42:
        HealthInfo healthInfo = this.mHealthService.getHealthInfo();     // Catch: Throwable -> L38
        if (healthInfo != null) goto L9;
        return 1;
    L9:
        switch(atomTag) {
            case 10019: goto L35;
            case 10020: goto L34;
            case 10030: goto L33;
            case 10043: goto L32;
            case 10045: goto L31;
            case 10220: goto L40;
            default: goto L10;
        };
    L10:
        return 1;
    L31:
        int pulledValue = healthInfo.batteryCycleCount;
    L36:
        pulledData.add(FrameworkStatsLog.buildStatsEvent(atomTag, pulledValue));
        return 0;
    L32:
        pulledValue = healthInfo.batteryLevel;
        goto L36
    L33:
        pulledValue = healthInfo.batteryVoltageMillivolts;
        goto L36
    L34:
        pulledValue = healthInfo.batteryFullChargeUah;
        goto L36
    L35:
        pulledValue = healthInfo.batteryChargeCounterUah;
        goto L36
    L40:
        BatteryHealthData bhd = this.mHealthService.getBatteryHealthData();     // Catch: Throwable -> L29
        if (bhd != null) goto L44;
        return 1;
    L44:
        BatteryProperty chargeStatusProperty = new BatteryProperty();     // Catch: NoSuchAlgorithmException -> L22 Throwable -> L24
        BatteryProperty chargePolicyProperty = new BatteryProperty();     // Catch: NoSuchAlgorithmException -> L22 Throwable -> L24
        if (this.mHealthService.getProperty(6, chargeStatusProperty) >= 0) goto L18;
        return 1;
    L18:
        if (this.mHealthService.getProperty(9, chargePolicyProperty) >= 0) goto L20;
        return 1;
    L20:
        int chargeStatus = (int) chargeStatusProperty.getLong();     // Catch: NoSuchAlgorithmException -> L22 Throwable -> L24
        int chargePolicy = (int) chargePolicyProperty.getLong();     // Catch: NoSuchAlgorithmException -> L22 Throwable -> L24
        StatsEvent batteryHealthEvent = BatteryHealthUtility.buildStatsEvent(atomTag, bhd, chargeStatus, chargePolicy);     // Catch: NoSuchAlgorithmException -> L22 Throwable -> L24
        pulledData.add(batteryHealthEvent);     // Catch: NoSuchAlgorithmException -> L22 Throwable -> L24
        return 0;
    L24:
        e = move-exception;
        Slog.e(TAG, "Failed to add pulled data", e);
    L28:
        return 1;
    L22:
        e = move-exception;
        Slog.e(TAG, "Could not find message digest algorithm", e);
    L30:
        return 1;
    L39:
        return 1;
    }

    private void registerSettingsStats() {
        this.mStatsManager.setPullAtomCallback(FrameworkStatsLog.SETTING_SNAPSHOT, null, ConcurrentUtils.DIRECT_EXECUTOR, this.mStatsCallbackImpl);
    }

    int pullSettingsStatsLocked(int atomTag, List<StatsEvent> pulledData) {
        UserManager userManager = (UserManager) this.mContext.getSystemService(UserManager.class);
        if (userManager != null) goto L5;
        return 1;
    L5:
        long token = Binder.clearCallingIdentity();
        Iterator r4 = userManager.getUsers().iterator();     // Catch: Throwable -> L12 Exception -> L14
    L7:
        if (r4.hasNext() == false) goto L18;
        UserInfo user = (UserInfo) r4.next();     // Catch: Throwable -> L12 Exception -> L14
        int userId = user.getUserHandle().getIdentifier();     // Catch: Throwable -> L12 Exception -> L14
        if (userId != 0) goto L16;
        pulledData.addAll(SettingsStatsUtil.logGlobalSettings(this.mContext, atomTag, 0));     // Catch: Throwable -> L12 Exception -> L14
    L16:
        pulledData.addAll(SettingsStatsUtil.logSystemSettings(this.mContext, atomTag, userId));     // Catch: Throwable -> L12 Exception -> L14
        pulledData.addAll(SettingsStatsUtil.logSecureSettings(this.mContext, atomTag, userId));     // Catch: Throwable -> L12 Exception -> L14
        goto L7
    L18:
        Binder.restoreCallingIdentity(token);
        return 0;
    L14:
        e = move-exception;
        Slog.e(TAG, "failed to pullSettingsStats", e);     // Catch: Throwable -> L12
        Binder.restoreCallingIdentity(token);
        return 1;
    L12:
        th = move-exception;
        Binder.restoreCallingIdentity(token);
        throw th;
    }

    private void registerInstalledIncrementalPackages() {
        this.mStatsManager.setPullAtomCallback(FrameworkStatsLog.INSTALLED_INCREMENTAL_PACKAGE, null, ConcurrentUtils.DIRECT_EXECUTOR, this.mStatsCallbackImpl);
    }

    int pullInstalledIncrementalPackagesLocked(int atomTag, List<StatsEvent> pulledData) {
        PackageManager pm = this.mContext.getPackageManager();
        PackageManagerInternal pmIntenral = (PackageManagerInternal) LocalServices.getService(PackageManagerInternal.class);
        int r4 = 0;
        if (pm.hasSystemFeature("android.software.incremental_delivery") == true) goto L5;
        return 0;
    L5:
        long token = Binder.clearCallingIdentity();
        int[] userIds = ((UserManagerInternal) LocalServices.getService(UserManagerInternal.class)).getUserIds();     // Catch: Throwable -> L33 Exception -> L35
        int r7 = userIds.length;     // Catch: Throwable -> L33 Exception -> L35
        int r8 = 0;
    L7:
        if (r8 >= r7) goto L40;
        int userId = userIds[r8];     // Catch: Throwable -> L33 Exception -> L35
        List<PackageInfo> installedPackages = pm.getInstalledPackagesAsUser(r4, userId);     // Catch: Throwable -> L33 Exception -> L35
        Iterator<PackageInfo> r11 = installedPackages.iterator();     // Catch: Throwable -> L33 Exception -> L35
    L10:
        if (r11.hasNext() == false) goto L39;
        PackageInfo pi = r11.next();     // Catch: Throwable -> L33 Exception -> L35
        if (IncrementalManager.isIncrementalPath(pi.applicationInfo.getBaseCodePath()) == false) goto L37;
        IncrementalStatesInfo info = pmIntenral.getIncrementalStatesInfo(pi.packageName, 1000, userId);     // Catch: Throwable -> L33 Exception -> L35
        long token2 = token;
    L51:
    L49:
        pulledData.add(FrameworkStatsLog.buildStatsEvent(atomTag, pi.applicationInfo.uid, info.isLoading(), info.getLoadingCompletedTime()));     // Catch: Throwable -> L21 Exception -> L23
    L38:
        r4 = r4;
        token = token2;
    L23:
        e = e;
    L43:
        Slog.e(TAG, "failed to pullInstalledIncrementalPackagesLocked", e);     // Catch: Throwable -> L21
        Binder.restoreCallingIdentity(token2);
        return 1;
    L27:
        e = e;
    L25:
        e = th;
    L46:
        Binder.restoreCallingIdentity(token2);
        throw e;
    L31:
        e = e;
    L29:
        e = th;
        goto L46
    L37:
        token2 = token;
        goto L38
    L39:
        r8 = r8 + 1;
        token = token;
        goto L7
    L40:
        int r16 = r4;
        Binder.restoreCallingIdentity(token);
        return r16;
    L21:
        e = th;
    L35:
        e = e;
        token2 = token;
    L33:
        e = th;
        token2 = token;
        goto L46
    }

    private void registerKeystoreStorageStats() {
        this.mStatsManager.setPullAtomCallback(FrameworkStatsLog.KEYSTORE2_STORAGE_STATS, null, ConcurrentUtils.DIRECT_EXECUTOR, this.mStatsCallbackImpl);
    }

    private void registerKeystoreKeyCreationWithGeneralInfo() {
        this.mStatsManager.setPullAtomCallback(FrameworkStatsLog.KEYSTORE2_KEY_CREATION_WITH_GENERAL_INFO, null, ConcurrentUtils.DIRECT_EXECUTOR, this.mStatsCallbackImpl);
    }

    private void registerKeystoreKeyCreationWithAuthInfo() {
        this.mStatsManager.setPullAtomCallback(FrameworkStatsLog.KEYSTORE2_KEY_CREATION_WITH_AUTH_INFO, null, ConcurrentUtils.DIRECT_EXECUTOR, this.mStatsCallbackImpl);
    }

    private void registerKeystoreKeyCreationWithPurposeModesInfo() {
        this.mStatsManager.setPullAtomCallback(FrameworkStatsLog.KEYSTORE2_KEY_CREATION_WITH_PURPOSE_AND_MODES_INFO, null, ConcurrentUtils.DIRECT_EXECUTOR, this.mStatsCallbackImpl);
    }

    private void registerKeystoreAtomWithOverflow() {
        this.mStatsManager.setPullAtomCallback(FrameworkStatsLog.KEYSTORE2_ATOM_WITH_OVERFLOW, null, ConcurrentUtils.DIRECT_EXECUTOR, this.mStatsCallbackImpl);
    }

    private void registerKeystoreKeyOperationWithPurposeAndModesInfo() {
        this.mStatsManager.setPullAtomCallback(FrameworkStatsLog.KEYSTORE2_KEY_OPERATION_WITH_PURPOSE_AND_MODES_INFO, null, ConcurrentUtils.DIRECT_EXECUTOR, this.mStatsCallbackImpl);
    }

    private void registerKeystoreKeyOperationWithGeneralInfo() {
        this.mStatsManager.setPullAtomCallback(FrameworkStatsLog.KEYSTORE2_KEY_OPERATION_WITH_GENERAL_INFO, null, ConcurrentUtils.DIRECT_EXECUTOR, this.mStatsCallbackImpl);
    }

    private void registerRkpErrorStats() {
        this.mStatsManager.setPullAtomCallback(FrameworkStatsLog.RKP_ERROR_STATS, null, ConcurrentUtils.DIRECT_EXECUTOR, this.mStatsCallbackImpl);
    }

    private void registerKeystoreCrashStats() {
        this.mStatsManager.setPullAtomCallback(FrameworkStatsLog.KEYSTORE2_CRASH_STATS, null, ConcurrentUtils.DIRECT_EXECUTOR, this.mStatsCallbackImpl);
    }

    private void registerAccessibilityShortcutStats() {
        this.mStatsManager.setPullAtomCallback(FrameworkStatsLog.ACCESSIBILITY_SHORTCUT_STATS, null, ConcurrentUtils.DIRECT_EXECUTOR, this.mStatsCallbackImpl);
    }

    private void registerAccessibilityFloatingMenuStats() {
        this.mStatsManager.setPullAtomCallback(FrameworkStatsLog.ACCESSIBILITY_FLOATING_MENU_STATS, null, ConcurrentUtils.DIRECT_EXECUTOR, this.mStatsCallbackImpl);
    }

    private void registerMediaCapabilitiesStats() {
        this.mStatsManager.setPullAtomCallback(FrameworkStatsLog.MEDIA_CAPABILITIES, null, ConcurrentUtils.DIRECT_EXECUTOR, this.mStatsCallbackImpl);
    }

    int parseKeystoreStorageStats(KeystoreAtom[] atoms, List<StatsEvent> pulledData) {
        int r0 = atoms.length;
        int r2 = 0;
    L3:
        if (r2 >= r0) goto L9;
        KeystoreAtom atomWrapper = atoms[r2];
        if (atomWrapper.payload.getTag() != 0) goto L6;
        StorageStats atom = atomWrapper.payload.getStorageStats();
        pulledData.add(FrameworkStatsLog.buildStatsEvent(FrameworkStatsLog.KEYSTORE2_STORAGE_STATS, atom.storage_type, atom.size, atom.unused_size));
        r2 = r2 + 1;
        goto L3
    L6:
        return 1;
    L9:
        return 0;
    }

    int parseKeystoreKeyCreationWithGeneralInfo(KeystoreAtom[] atoms, List<StatsEvent> pulledData) {
        int r0 = atoms.length;
        int r2 = 0;
    L3:
        if (r2 >= r0) goto L8;
        KeystoreAtom atomWrapper = atoms[r2];
        if (atomWrapper.payload.getTag() != 1) goto L6;
        KeyCreationWithGeneralInfo atom = atomWrapper.payload.getKeyCreationWithGeneralInfo();
        pulledData.add(FrameworkStatsLog.buildStatsEvent(FrameworkStatsLog.KEYSTORE2_KEY_CREATION_WITH_GENERAL_INFO, atom.algorithm, atom.key_size, atom.ec_curve, atom.key_origin, atom.error_code, atom.attestation_requested, atomWrapper.count));
        r2 = r2 + 1;
        goto L3
    L6:
        return 1;
    L8:
        return 0;
    }

    int parseKeystoreKeyCreationWithAuthInfo(KeystoreAtom[] atoms, List<StatsEvent> pulledData) {
        int r0 = atoms.length;
        int r2 = 0;
    L3:
        if (r2 >= r0) goto L9;
        KeystoreAtom atomWrapper = atoms[r2];
        if (atomWrapper.payload.getTag() != 2) goto L6;
        KeyCreationWithAuthInfo atom = atomWrapper.payload.getKeyCreationWithAuthInfo();
        pulledData.add(FrameworkStatsLog.buildStatsEvent(FrameworkStatsLog.KEYSTORE2_KEY_CREATION_WITH_AUTH_INFO, atom.user_auth_type, atom.log10_auth_key_timeout_seconds, atom.security_level, atomWrapper.count));
        r2 = r2 + 1;
        goto L3
    L6:
        return 1;
    L9:
        return 0;
    }

    int parseKeystoreKeyCreationWithPurposeModesInfo(KeystoreAtom[] atoms, List<StatsEvent> pulledData) {
        int r0 = atoms.length;
        int r2 = 0;
    L3:
        if (r2 >= r0) goto L9;
        KeystoreAtom atomWrapper = atoms[r2];
        if (atomWrapper.payload.getTag() != 3) goto L6;
        KeyCreationWithPurposeAndModesInfo atom = atomWrapper.payload.getKeyCreationWithPurposeAndModesInfo();
        pulledData.add(FrameworkStatsLog.buildStatsEvent(FrameworkStatsLog.KEYSTORE2_KEY_CREATION_WITH_PURPOSE_AND_MODES_INFO, atom.algorithm, atom.purpose_bitmap, atom.padding_mode_bitmap, atom.digest_bitmap, atom.block_mode_bitmap, atomWrapper.count));
        r2 = r2 + 1;
        goto L3
    L6:
        return 1;
    L9:
        return 0;
    }

    int parseKeystoreAtomWithOverflow(KeystoreAtom[] atoms, List<StatsEvent> pulledData) {
        int r0 = atoms.length;
        int r2 = 0;
    L3:
        if (r2 >= r0) goto L9;
        KeystoreAtom atomWrapper = atoms[r2];
        if (atomWrapper.payload.getTag() != 4) goto L6;
        Keystore2AtomWithOverflow atom = atomWrapper.payload.getKeystore2AtomWithOverflow();
        pulledData.add(FrameworkStatsLog.buildStatsEvent(FrameworkStatsLog.KEYSTORE2_ATOM_WITH_OVERFLOW, atom.atom_id, atomWrapper.count));
        r2 = r2 + 1;
        goto L3
    L6:
        return 1;
    L9:
        return 0;
    }

    int parseKeystoreKeyOperationWithPurposeModesInfo(KeystoreAtom[] atoms, List<StatsEvent> pulledData) {
        int r0 = atoms.length;
        int r2 = 0;
    L3:
        if (r2 >= r0) goto L9;
        KeystoreAtom atomWrapper = atoms[r2];
        if (atomWrapper.payload.getTag() != 5) goto L6;
        KeyOperationWithPurposeAndModesInfo atom = atomWrapper.payload.getKeyOperationWithPurposeAndModesInfo();
        pulledData.add(FrameworkStatsLog.buildStatsEvent(FrameworkStatsLog.KEYSTORE2_KEY_OPERATION_WITH_PURPOSE_AND_MODES_INFO, atom.purpose, atom.padding_mode_bitmap, atom.digest_bitmap, atom.block_mode_bitmap, atomWrapper.count));
        r2 = r2 + 1;
        goto L3
    L6:
        return 1;
    L9:
        return 0;
    }

    int parseKeystoreKeyOperationWithGeneralInfo(KeystoreAtom[] atoms, List<StatsEvent> pulledData) {
        int r0 = atoms.length;
        int r2 = 0;
    L3:
        if (r2 >= r0) goto L9;
        KeystoreAtom atomWrapper = atoms[r2];
        if (atomWrapper.payload.getTag() != 6) goto L6;
        KeyOperationWithGeneralInfo atom = atomWrapper.payload.getKeyOperationWithGeneralInfo();
        pulledData.add(FrameworkStatsLog.buildStatsEvent(FrameworkStatsLog.KEYSTORE2_KEY_OPERATION_WITH_GENERAL_INFO, atom.outcome, atom.error_code, atom.key_upgraded, atom.security_level, atomWrapper.count));
        r2 = r2 + 1;
        goto L3
    L6:
        return 1;
    L9:
        return 0;
    }

    int parseRkpErrorStats(KeystoreAtom[] atoms, List<StatsEvent> pulledData) {
        int r0 = atoms.length;
        int r2 = 0;
    L3:
        if (r2 >= r0) goto L9;
        KeystoreAtom atomWrapper = atoms[r2];
        if (atomWrapper.payload.getTag() != 7) goto L6;
        RkpErrorStats atom = atomWrapper.payload.getRkpErrorStats();
        pulledData.add(FrameworkStatsLog.buildStatsEvent(FrameworkStatsLog.RKP_ERROR_STATS, atom.rkpError, atomWrapper.count, atom.security_level));
        r2 = r2 + 1;
        goto L3
    L6:
        return 1;
    L9:
        return 0;
    }

    int parseKeystoreCrashStats(KeystoreAtom[] atoms, List<StatsEvent> pulledData) {
        int r0 = atoms.length;
        int r2 = 0;
    L3:
        if (r2 >= r0) goto L9;
        KeystoreAtom atomWrapper = atoms[r2];
        if (atomWrapper.payload.getTag() != 8) goto L6;
        CrashStats atom = atomWrapper.payload.getCrashStats();
        pulledData.add(FrameworkStatsLog.buildStatsEvent(FrameworkStatsLog.KEYSTORE2_CRASH_STATS, atom.count_of_crash_events));
        r2 = r2 + 1;
        goto L3
    L6:
        return 1;
    L9:
        return 0;
    }

    int pullKeystoreAtoms(int atomTag, List<StatsEvent> pulledData) {
        IKeystoreMetrics keystoreMetricsService = getIKeystoreMetricsService();
        if (keystoreMetricsService != null) goto L6;
        Slog.w(TAG, "Keystore service is null");
        return 1;
    L6:
        long callingToken = Binder.clearCallingIdentity();
        KeystoreAtom[] atoms = keystoreMetricsService.pullMetrics(atomTag);     // Catch: Throwable -> L12 ServiceSpecificException -> L14 RemoteException -> L16
        switch(atomTag) {
            case 10103: goto L42;
            case 10118: goto L39;
            case 10119: goto L36;
            case 10120: goto L33;
            case 10121: goto L30;
            case 10122: goto L27;
            case 10123: goto L24;
            case 10124: goto L21;
            case 10125: goto L18;
            default: goto L9;
        };     // Catch: Throwable -> L12 ServiceSpecificException -> L14 RemoteException -> L16
    L9:
        Slog.w(TAG, "Unsupported keystore atom: " + atomTag);     // Catch: Throwable -> L12 ServiceSpecificException -> L14 RemoteException -> L16
        Binder.restoreCallingIdentity(callingToken);
        return 1;
    L18:
        int r1 = parseKeystoreCrashStats(atoms, pulledData);     // Catch: Throwable -> L12 ServiceSpecificException -> L14 RemoteException -> L16
        Binder.restoreCallingIdentity(callingToken);
        return r1;
    L21:
        int r2 = parseRkpErrorStats(atoms, pulledData);     // Catch: Throwable -> L12 ServiceSpecificException -> L14 RemoteException -> L16
        Binder.restoreCallingIdentity(callingToken);
        return r2;
    L24:
        int r3 = parseKeystoreKeyOperationWithGeneralInfo(atoms, pulledData);     // Catch: Throwable -> L12 ServiceSpecificException -> L14 RemoteException -> L16
        Binder.restoreCallingIdentity(callingToken);
        return r3;
    L27:
        int r4 = parseKeystoreKeyOperationWithPurposeModesInfo(atoms, pulledData);     // Catch: Throwable -> L12 ServiceSpecificException -> L14 RemoteException -> L16
        Binder.restoreCallingIdentity(callingToken);
        return r4;
    L30:
        int r5 = parseKeystoreAtomWithOverflow(atoms, pulledData);     // Catch: Throwable -> L12 ServiceSpecificException -> L14 RemoteException -> L16
        Binder.restoreCallingIdentity(callingToken);
        return r5;
    L33:
        int r6 = parseKeystoreKeyCreationWithPurposeModesInfo(atoms, pulledData);     // Catch: Throwable -> L12 ServiceSpecificException -> L14 RemoteException -> L16
        Binder.restoreCallingIdentity(callingToken);
        return r6;
    L36:
        int r7 = parseKeystoreKeyCreationWithAuthInfo(atoms, pulledData);     // Catch: Throwable -> L12 ServiceSpecificException -> L14 RemoteException -> L16
        Binder.restoreCallingIdentity(callingToken);
        return r7;
    L39:
        int r8 = parseKeystoreKeyCreationWithGeneralInfo(atoms, pulledData);     // Catch: Throwable -> L12 ServiceSpecificException -> L14 RemoteException -> L16
        Binder.restoreCallingIdentity(callingToken);
        return r8;
    L42:
        int r9 = parseKeystoreStorageStats(atoms, pulledData);     // Catch: Throwable -> L12 ServiceSpecificException -> L14 RemoteException -> L16
        Binder.restoreCallingIdentity(callingToken);
        return r9;
    L12:
        th = move-exception;
        Binder.restoreCallingIdentity(callingToken);
        throw th;
    L14:
        e = move-exception;
        Slog.e(TAG, "Pulling keystore atom with tag " + atomTag + " failed", e);     // Catch: Throwable -> L12
        Binder.restoreCallingIdentity(callingToken);
        return 1;
    L16:
        e = move-exception;
        Slog.e(TAG, "Disconnected from keystore service. Cannot pull.", e);     // Catch: Throwable -> L12
        Binder.restoreCallingIdentity(callingToken);
        return 1;
    }

    int pullAccessibilityShortcutStatsLocked(List<StatsEvent> pulledData) {
        UserManager userManager = (UserManager) this.mContext.getSystemService(UserManager.class);
        if (userManager != null) goto L5;
        return 1;
    L5:
        long token = Binder.clearCallingIdentity();
        ContentResolver resolver = this.mContext.getContentResolver();     // Catch: Throwable -> L23 RuntimeException -> L25
        Iterator r6 = userManager.getUsers().iterator();     // Catch: Throwable -> L23 RuntimeException -> L25
    L8:
        if (r6.hasNext() == false) goto L29;
        UserInfo userInfo = (UserInfo) r6.next();     // Catch: Throwable -> L23 RuntimeException -> L25
        int userId = userInfo.getUserHandle().getIdentifier();     // Catch: Throwable -> L23 RuntimeException -> L25
        if (isAccessibilityShortcutUser(this.mContext, userId) == false) goto L8;
        int software_shortcut_type = convertToAccessibilityShortcutType(Settings.Secure.getIntForUser(resolver, "accessibility_button_mode", 0, userId));     // Catch: Throwable -> L23 RuntimeException -> L25
        String software_shortcut_list = Settings.Secure.getStringForUser(resolver, "accessibility_button_targets", userId);     // Catch: Throwable -> L23 RuntimeException -> L25
        int software_shortcut_service_num = countAccessibilityServices(software_shortcut_list);     // Catch: Throwable -> L23 RuntimeException -> L25
        String hardware_shortcut_list = Settings.Secure.getStringForUser(resolver, "accessibility_shortcut_target_service", userId);     // Catch: Throwable -> L23 RuntimeException -> L25
        int hardware_shortcut_service_num = countAccessibilityServices(hardware_shortcut_list);     // Catch: Throwable -> L23 RuntimeException -> L25
        String qs_shortcut_list = Settings.Secure.getStringForUser(resolver, "accessibility_qs_targets", userId);     // Catch: Throwable -> L23 RuntimeException -> L25
        if (TextUtils.isEmpty(qs_shortcut_list) == true) goto L14;
        boolean qs_shortcut_enabled = true;
    L15:
        int triple_tap_service_num = Settings.Secure.getIntForUser(resolver, "accessibility_display_magnification_enabled", 0, userId);     // Catch: Throwable -> L23 RuntimeException -> L25
    L38:
        pulledData.add(FrameworkStatsLog.buildStatsEvent(FrameworkStatsLog.ACCESSIBILITY_SHORTCUT_STATS, software_shortcut_type, software_shortcut_service_num, 2, hardware_shortcut_service_num, 3, triple_tap_service_num, 9, qs_shortcut_enabled));     // Catch: Throwable -> L19 RuntimeException -> L21
    L21:
        e = e;
    L32:
        Slog.e(TAG, "pulling accessibility shortcuts stats failed at getUsers", e);     // Catch: Throwable -> L19
        Binder.restoreCallingIdentity(token);
        return 1;
    L14:
        qs_shortcut_enabled = false;
        goto L15
    L29:
        Binder.restoreCallingIdentity(token);
        return 0;
    L19:
        e = th;
    L35:
        Binder.restoreCallingIdentity(token);
        throw e;
    L25:
        e = e;
    L23:
        e = th;
        goto L35
    }

    /* JADX WARN: Multi-variable type inference failed */
    int pullAccessibilityFloatingMenuStatsLocked(int atomTag, List<StatsEvent> pulledData) {
        StatsPullAtomService r1 = this;
        UserManager userManager = (UserManager) r1.mContext.getSystemService(UserManager.class);
        int r3 = 1;
        if (userManager != null) goto L5;
        return 1;
    L5:
        long token = Binder.clearCallingIdentity();
        ContentResolver resolver = r1.mContext.getContentResolver();     // Catch: Throwable -> L30 RuntimeException -> L34
        Iterator r10 = userManager.getUsers().iterator();     // Catch: Throwable -> L30 RuntimeException -> L34
    L8:
        if (r10.hasNext() == false) goto L38;
        UserInfo userInfo = (UserInfo) r10.next();     // Catch: Throwable -> L30 RuntimeException -> L34
        int userId = userInfo.getUserHandle().getIdentifier();     // Catch: Throwable -> L30 RuntimeException -> L34
        if (r1.isAccessibilityFloatingMenuUser(r1.mContext, userId) == false) goto L36;
        int size = Settings.Secure.getIntForUser(resolver, "accessibility_floating_menu_size", 0, userId);     // Catch: Throwable -> L30 RuntimeException -> L34
        int type = Settings.Secure.getIntForUser(resolver, "accessibility_floating_menu_icon_type", 0, userId);     // Catch: Throwable -> L30 RuntimeException -> L34
        if (Settings.Secure.getIntForUser(resolver, "accessibility_floating_menu_fade_enabled", r3, userId) != r3) goto L14;
        boolean r12 = r3;
    L15:
        int r17 = r3;
        float opacity = Settings.Secure.getFloatForUser(resolver, "accessibility_floating_menu_opacity", 0.55f, userId);     // Catch: Throwable -> L30 RuntimeException -> L32
    L53:
    L46:
        pulledData.add(FrameworkStatsLog.buildStatsEvent(atomTag, size, type, r12, opacity));     // Catch: Throwable -> L22 RuntimeException -> L24
    L37:
        r1 = this;
        r3 = r17;
        resolver = resolver;
    L24:
        e = e;
    L41:
        Slog.e(TAG, "pulling accessibility floating menu stats failed at getUsers", e);     // Catch: Throwable -> L22
        Binder.restoreCallingIdentity(token);
        return r17;
    L22:
        e = th;
    L44:
        Binder.restoreCallingIdentity(token);
        throw e;
    L28:
        e = e;
    L26:
        e = th;
    L32:
        e = e;
        goto L41
    L14:
        r12 = 0;
        goto L15
    L36:
        r17 = r3;
        goto L37
    L38:
        Binder.restoreCallingIdentity(token);
        return 0;
    L30:
        e = th;
    L34:
        e = e;
        r17 = r3;
        goto L41
    }

    int pullMediaCapabilitiesStats(int atomTag, List<StatsEvent> pulledData) {
        if (this.mContext.getPackageManager().hasSystemFeature("android.software.leanback") == true) goto L5;
        return 1;
    L5:
        AudioManager r4 = (AudioManager) this.mContext.getSystemService(AudioManager.class);
        if (r4 != null) goto L8;
        return 1;
    L8:
        Map surroundEncodingsMap = r4.getSurroundFormats();
        byte[] surroundEncodings = toBytes(new ArrayList(surroundEncodingsMap.keySet()));
        byte[] sinkSurroundEncodings = toBytes(r4.getReportedSurroundFormats());
        List<Integer> disabledSurroundEncodingsList = new ArrayList();
        List<Integer> enabledSurroundEncodingsList = new ArrayList();
        Iterator<Integer> r0 = surroundEncodingsMap.keySet().iterator();
    L10:
        if (r0.hasNext() == false) goto L16;
        int surroundEncoding = r0.next().intValue();
        if (r4.isSurroundFormatEnabled(surroundEncoding) == false) goto L13;
        enabledSurroundEncodingsList.add(Integer.valueOf(surroundEncoding));
        goto L10
    L13:
        disabledSurroundEncodingsList.add(Integer.valueOf(surroundEncoding));
        goto L10
    L16:
        byte[] disabledSurroundEncodings = toBytes(disabledSurroundEncodingsList);
        byte[] enabledSurroundEncodings = toBytes(enabledSurroundEncodingsList);
        int surroundOutputMode = r4.getEncodedSurroundMode();
        DisplayManager displayManager = (DisplayManager) this.mContext.getSystemService(DisplayManager.class);
        Display display = displayManager.getDisplay(0);
        Display.HdrCapabilities hdrCapabilities = display.getHdrCapabilities();
        byte[] sinkHdrFormats = new byte[0];
        if (hdrCapabilities == null) goto L19;
        byte[] sinkHdrFormats2 = toBytes(hdrCapabilities.getSupportedHdrTypes());
        byte[] sinkHdrFormats3 = sinkHdrFormats2;
    L20:
        byte[] sinkDisplayModes = toBytes(display.getSupportedModes());
        int hdcpLevel = -1;
        List<UUID> uuids = MediaDrm.getSupportedCryptoSchemes();
    L25:
        exception = move-exception;
        Slog.e(TAG, "pulling hdcp level failed.", exception);
        hdcpLevel = -1;
    L29:
        int matchContentFrameRateUserPreference = displayManager.getMatchContentFrameRateUserPreference();
        byte[] userDisabledHdrTypes = toBytes(displayManager.getUserDisabledHdrTypes());
        Display.Mode userPreferredDisplayMode = displayManager.getGlobalUserPreferredDisplayMode();
        int r1 = -1;
        if (userPreferredDisplayMode == null) goto L32;
        int userPreferredWidth = userPreferredDisplayMode.getPhysicalWidth();
    L33:
        if (userPreferredDisplayMode == null) goto L36;
        r1 = userPreferredDisplayMode.getPhysicalHeight();
    L36:
        int userPreferredHeight = r1;
        if (userPreferredDisplayMode == null) goto L39;
        float r2 = userPreferredDisplayMode.getRefreshRate();
    L40:
        float userPreferredRefreshRate = r2;
        boolean hasUserDisabledAllm = true;
        if (Settings.Secure.getIntForUser(this.mContext.getContentResolver(), "minimal_post_processing_allowed", 1) == 0) goto L53;
        hasUserDisabledAllm = false;
    L53:
        pulledData.add(FrameworkStatsLog.buildStatsEvent(atomTag, surroundEncodings, sinkSurroundEncodings, disabledSurroundEncodings, enabledSurroundEncodings, surroundOutputMode, sinkHdrFormats3, sinkDisplayModes, hdcpLevel, matchContentFrameRateUserPreference, userDisabledHdrTypes, userPreferredWidth, userPreferredHeight, userPreferredRefreshRate, hasUserDisabledAllm));
        return 0;
    L48:
        exception = e;
    L52:
        Slog.e(TAG, "unable to find setting for MINIMAL_POST_PROCESSING_ALLOWED.", exception);
        hasUserDisabledAllm = false;
    L50:
        exception = e;
        goto L52
    L39:
        r2 = 0.0f;
        goto L40
    L32:
        userPreferredWidth = -1;
        goto L33
    L22:
        if (uuids.isEmpty() == true) goto L29;
        MediaDrm mediaDrm = new MediaDrm(uuids.get(0));     // Catch: UnsupportedSchemeException -> L25
        hdcpLevel = mediaDrm.getConnectedHdcpLevel();     // Catch: UnsupportedSchemeException -> L25
        goto L29
    L19:
        sinkHdrFormats3 = sinkHdrFormats;
        goto L20
    }

    private void registerPendingIntentsPerPackagePuller() {
        this.mStatsManager.setPullAtomCallback(FrameworkStatsLog.PENDING_INTENTS_PER_PACKAGE, null, ConcurrentUtils.DIRECT_EXECUTOR, this.mStatsCallbackImpl);
    }

    private int pullHdrCapabilities(int atomTag, List<StatsEvent> pulledData) {
        DisplayManager displayManager = (DisplayManager) this.mContext.getSystemService(DisplayManager.class);
        Display display = displayManager.getDisplay(0);
        int hdrConversionMode = displayManager.getHdrConversionMode().getConversionMode();
        int preferredHdrType = displayManager.getHdrConversionMode().getPreferredHdrOutputType();
        if (hdrConversionMode != 1) goto L5;
        boolean r6 = true;
    L6:
        boolean userDisabledHdrConversion = r6;
        if (preferredHdrType != (-1)) goto L9;
        int forceHdrFormat = 0;
    L10:
        boolean hasDolbyVisionIssue = hasDolbyVisionIssue(display);
        byte[] hdrOutputTypes = toBytes(displayManager.getSupportedHdrOutputTypes());
        if (hdrConversionMode == 0) goto L13;
        boolean hdrOutputControlSupported = true;
    L14:
        pulledData.add(FrameworkStatsLog.buildStatsEvent(atomTag, hdrOutputTypes, userDisabledHdrConversion, forceHdrFormat, hasDolbyVisionIssue, hdrOutputControlSupported));
        return 0;
    L13:
        hdrOutputControlSupported = false;
        goto L14
    L9:
        forceHdrFormat = preferredHdrType;
        goto L10
    L5:
        r6 = false;
        goto L6
    }

    private int pullCachedAppsHighWatermark(int atomTag, List<StatsEvent> pulledData) {
        pulledData.add((StatsEvent) ((ActivityManagerInternal) LocalServices.getService(ActivityManagerInternal.class)).getCachedAppsHighWatermarkStats(atomTag, true));
        return 0;
    }

    private boolean hasDolbyVisionIssue(Display display) {
        final AtomicInteger modesSupportingDolbyVision = new AtomicInteger();
        Arrays.stream(display.getSupportedModes()).map(new StatsPullAtomService$$ExternalSyntheticLambda3()).filter(new StatsPullAtomService$$ExternalSyntheticLambda4()).forEach(new StatsPullAtomService$$ExternalSyntheticLambda5(modesSupportingDolbyVision));
        if (modesSupportingDolbyVision.get() != 0) goto L5;
        return false;
    L5:
        if (modesSupportingDolbyVision.get() >= display.getSupportedModes().length) goto L10;
        return true;
    L10:
        return false;
    }

    private static /* synthetic */ boolean lambda$hasDolbyVisionIssue$25(int hdrType) {
        if (hdrType == 1) goto L7;
        return false;
    L7:
        return true;
    }

    private static /* synthetic */ boolean lambda$hasDolbyVisionIssue$26(int[] types) {
        return Arrays.stream(types).anyMatch(new StatsPullAtomService$$ExternalSyntheticLambda16());
    }

    private static /* synthetic */ void lambda$hasDolbyVisionIssue$27(AtomicInteger modesSupportingDolbyVision, int[] ignored) {
        modesSupportingDolbyVision.incrementAndGet();
    }

    private int pullPendingIntentsPerPackage(int atomTag, List<StatsEvent> pulledData) {
        List<PendingIntentStats> pendingIntentStats = ((ActivityManagerInternal) LocalServices.getService(ActivityManagerInternal.class)).getPendingIntentStats();
        Iterator<PendingIntentStats> r1 = pendingIntentStats.iterator();
    L4:
        if (r1.hasNext() == false) goto L6;
        PendingIntentStats stats = r1.next();
        pulledData.add(FrameworkStatsLog.buildStatsEvent(atomTag, stats.uid, stats.count, stats.sizeKb));
        goto L4
    L6:
        return 0;
    }

    private void registerPinnerServiceStats() {
        this.mStatsManager.setPullAtomCallback(FrameworkStatsLog.PINNED_FILE_SIZES_PER_PACKAGE, null, ConcurrentUtils.DIRECT_EXECUTOR, this.mStatsCallbackImpl);
    }

    private void registerHdrCapabilitiesPuller() {
        this.mStatsManager.setPullAtomCallback(FrameworkStatsLog.HDR_CAPABILITIES, null, ConcurrentUtils.DIRECT_EXECUTOR, this.mStatsCallbackImpl);
    }

    private void registerCachedAppsHighWatermarkPuller() {
        this.mStatsManager.setPullAtomCallback(FrameworkStatsLog.CACHED_APPS_HIGH_WATERMARK, null, ConcurrentUtils.DIRECT_EXECUTOR, this.mStatsCallbackImpl);
    }

    private void registerPressureStallInformation() {
        this.mStatsManager.setPullAtomCallback(FrameworkStatsLog.PRESSURE_STALL_INFORMATION, null, ConcurrentUtils.DIRECT_EXECUTOR, this.mStatsCallbackImpl);
    }

    int pullPressureStallInformation(int atomTag, List<StatsEvent> pulledData) {
        PsiExtractor psiExtractor = new PsiExtractor();
        PsiData.ResourceType[] r1 = PsiData.ResourceType.values();
        int r2 = r1.length;
        int r4 = 0;
    L3:
        if (r4 >= r2) goto L10;
        PsiData.ResourceType resourceType = r1[r4];
        PsiData psiData = psiExtractor.getPsiData(resourceType);
        if (psiData != null) goto L7;
        Slog.e(TAG, "Failed to pull PressureStallInformation atom for resource: " + resourceType.toString());
    L8:
        r4 = r4 + 1;
        goto L3
    L7:
        pulledData.add(FrameworkStatsLog.buildStatsEvent(atomTag, toProtoPsiResourceType(psiData.getResourceType()), psiData.getSomeAvg10SecPercentage(), psiData.getSomeAvg60SecPercentage(), psiData.getSomeAvg300SecPercentage(), psiData.getSomeTotalUsec(), psiData.getFullAvg10SecPercentage(), psiData.getFullAvg60SecPercentage(), psiData.getFullAvg300SecPercentage(), psiData.getFullTotalUsec()));
        goto L8
    L10:
        return 0;
    }

    private int toProtoPsiResourceType(PsiData.ResourceType resourceType) {
        if (resourceType != PsiData.ResourceType.CPU) goto L7;
        return 1;
    L7:
        if (resourceType != PsiData.ResourceType.MEMORY) goto L11;
        return 2;
    L11:
        if (resourceType != PsiData.ResourceType.IO) goto L14;
        return 3;
    L14:
        return 0;
    }

    int pullSystemServerPinnerStats(int atomTag, List<StatsEvent> pulledData) {
        PinnerService pinnerService = (PinnerService) LocalServices.getService(PinnerService.class);
        List<PinnerService.PinnedFileStats> pinnedFileStats = pinnerService.dumpDataForStatsd();
        Iterator<PinnerService.PinnedFileStats> r2 = pinnedFileStats.iterator();
    L4:
        if (r2.hasNext() == false) goto L6;
        PinnerService.PinnedFileStats pfstats = r2.next();
        pulledData.add(FrameworkStatsLog.buildStatsEvent(atomTag, pfstats.uid, pfstats.filename, pfstats.sizeKb));
        goto L4
    L6:
        return 0;
    }

    private byte[] toBytes(List<Integer> audioEncodings) {
        ProtoOutputStream protoOutputStream = new ProtoOutputStream();
        Iterator<Integer> r1 = audioEncodings.iterator();
    L4:
        if (r1.hasNext() == false) goto L7;
        int audioEncoding = r1.next().intValue();
        protoOutputStream.write(2259152797697L, audioEncoding);
        goto L4
    L7:
        return protoOutputStream.getBytes();
    }

    private byte[] toBytes(int[] array) {
        ProtoOutputStream protoOutputStream = new ProtoOutputStream();
        int r1 = array.length;
        int r2 = 0;
    L3:
        if (r2 >= r1) goto L6;
        int element = array[r2];
        protoOutputStream.write(2259152797697L, element);
        r2 = r2 + 1;
        goto L3
    L6:
        return protoOutputStream.getBytes();
    }

    private byte[] toBytes(Display.Mode[] displayModes) {
        Map<Integer, Integer> modeGroupIds = createModeGroups(displayModes);
        ProtoOutputStream protoOutputStream = new ProtoOutputStream();
        int r2 = displayModes.length;
        int r3 = 0;
    L3:
        if (r3 >= r2) goto L6;
        Display.Mode element = displayModes[r3];
        ProtoOutputStream protoOutputStreamMode = new ProtoOutputStream();
        protoOutputStreamMode.write(1120986464257L, element.getPhysicalHeight());
        protoOutputStreamMode.write(1120986464258L, element.getPhysicalWidth());
        protoOutputStreamMode.write(1108101562371L, element.getRefreshRate());
        protoOutputStreamMode.write(1120986464260L, modeGroupIds.get(Integer.valueOf(element.getModeId())).intValue());
        protoOutputStream.write(2246267895809L, protoOutputStreamMode.getBytes());
        r3 = r3 + 1;
        goto L3
    L6:
        return protoOutputStream.getBytes();
    }

    private Map<Integer, Integer> createModeGroups(Display.Mode[] supportedModes) {
        Map<Integer, Integer> modeGroupIds = new ArrayMap();
        int groupId = 1;
        int r2 = supportedModes.length;
        int r4 = 0;
    L3:
        if (r4 >= r2) goto L17;
        Display.Mode mode = supportedModes[r4];
        if (modeGroupIds.containsKey(Integer.valueOf(mode.getModeId())) == true) goto L16;
        modeGroupIds.put(Integer.valueOf(mode.getModeId()), Integer.valueOf(groupId));
        float[] r6 = mode.getAlternativeRefreshRates();
        int r7 = r6.length;
        int r8 = 0;
    L8:
        if (r8 >= r7) goto L15;
        float refreshRate = r6[r8];
        int alternativeModeId = findModeId(supportedModes, mode.getPhysicalWidth(), mode.getPhysicalHeight(), refreshRate);
        if (alternativeModeId == (-1)) goto L14;
        if (modeGroupIds.containsKey(Integer.valueOf(alternativeModeId)) == true) goto L14;
        modeGroupIds.put(Integer.valueOf(alternativeModeId), Integer.valueOf(groupId));
    L14:
        r8 = r8 + 1;
        goto L8
    L15:
        groupId = groupId + 1;
    L16:
        r4 = r4 + 1;
        goto L3
    L17:
        return modeGroupIds;
    }

    private int findModeId(Display.Mode[] modes, int width, int height, float refreshRate) {
        int r0 = modes.length;
        int r1 = 0;
    L3:
        if (r1 >= r0) goto L9;
        Display.Mode mode = modes[r1];
        if (mode.matches(width, height, refreshRate) == true) goto L7;
        r1 = r1 + 1;
        goto L3
    L7:
        return mode.getModeId();
    L9:
        return -1;
    }

    private int countAccessibilityServices(String semicolonList) {
        if (TextUtils.isEmpty(semicolonList) == false) goto L5;
        return 0;
    L5:
        int semiColonNums = (int) semicolonList.chars().filter(new StatsPullAtomService$$ExternalSyntheticLambda18()).count();
        if (TextUtils.isEmpty(semicolonList) == false) goto L9;
        return 0;
    L9:
        return semiColonNums + 1;
    }

    private static /* synthetic */ boolean lambda$countAccessibilityServices$28(int ch) {
        if (ch != 58) goto L5;
        return true;
    L5:
        return false;
    }

    private boolean isAccessibilityShortcutUser(Context context, int userId) {
        ContentResolver resolver = context.getContentResolver();
        String software_shortcut_list = Settings.Secure.getStringForUser(resolver, "accessibility_button_targets", userId);
        String hardware_shortcut_list = Settings.Secure.getStringForUser(resolver, "accessibility_shortcut_target_service", userId);
        String qs_shortcut_list = Settings.Secure.getStringForUser(resolver, "accessibility_qs_targets", userId);
        if (Settings.Secure.getIntForUser(resolver, "accessibility_shortcut_dialog_shown", 0, userId) != 1) goto L5;
        boolean hardware_shortcut_dialog_shown = true;
    L6:
        boolean software_shortcut_enabled = !TextUtils.isEmpty(software_shortcut_list);
        if (hardware_shortcut_dialog_shown == true) goto L9;
    L11:
        boolean hardware_shortcut_enabled = false;
    L12:
        boolean qs_shortcut_enabled = !TextUtils.isEmpty(qs_shortcut_list);
        if (Settings.Secure.getIntForUser(resolver, "accessibility_display_magnification_enabled", 0, userId) != 1) goto L15;
        boolean triple_tap_shortcut_enabled = true;
    L16:
        if (software_shortcut_enabled == true) goto L21;
        if (hardware_shortcut_enabled == true) goto L21;
        if (triple_tap_shortcut_enabled == true) goto L21;
        if (qs_shortcut_enabled == true) goto L21;
        return false;
    L21:
        return true;
    L15:
        triple_tap_shortcut_enabled = false;
        goto L16
    L9:
        if (TextUtils.isEmpty(hardware_shortcut_list) == true) goto L11;
        hardware_shortcut_enabled = true;
        goto L12
    L5:
        hardware_shortcut_dialog_shown = false;
        goto L6
    }

    private boolean isAccessibilityFloatingMenuUser(Context context, int userId) {
        ContentResolver resolver = context.getContentResolver();
        int mode = Settings.Secure.getIntForUser(resolver, "accessibility_button_mode", 0, userId);
        String software_string = Settings.Secure.getStringForUser(resolver, "accessibility_button_targets", userId);
        if (mode == 1) goto L5;
        return false;
    L5:
        if (TextUtils.isEmpty(software_string) == false) goto L8;
        return false;
    L8:
        return true;
    }

    private int convertToAccessibilityShortcutType(int shortcutType) {
        switch(shortcutType) {
            case 0: goto L9;
            case 1: goto L7;
            case 2: goto L5;
            default: goto L3;
        };
    L3:
        return 0;
    L5:
        return 6;
    L7:
        return 5;
    L9:
        return 1;
    }

    private boolean isHealthAppOp(int opCode) {
        String permission = AppOpsManager.opToPermission(opCode);
        if (permission != null) goto L5;
    L7:
        return false;
    L5:
        if (HealthConnectManager.isHealthPermission(this.mContext, permission) == false) goto L7;
        return true;
    }
}
