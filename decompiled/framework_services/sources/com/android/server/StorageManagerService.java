package com.android.server;

import android.R;
import android.app.ActivityManager;
import android.app.ActivityManagerInternal;
import android.app.ActivityOptions;
import android.app.AnrController;
import android.app.AppOpsManager;
import android.app.IActivityManager;
import android.app.KeyguardManager;
import android.app.PendingIntent;
import android.app.admin.SecurityLog;
import android.app.usage.StorageStatsManager;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.pm.ApplicationInfo;
import android.content.pm.IPackageManager;
import android.content.pm.IPackageMoveObserver;
import android.content.pm.PackageManager;
import android.content.pm.PackageManagerInternal;
import android.content.pm.ProviderInfo;
import android.content.pm.UserInfo;
import android.content.res.ObbInfo;
import android.hardware.audio.common.V2_0.AudioFormat;
import android.media.MediaCodecInfo;
import android.media.MediaCodecList;
import android.net.Uri;
import android.os.Binder;
import android.os.Build;
import android.os.Environment;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.IBinder;
import android.os.IInstalld;
import android.os.IStoraged;
import android.os.IVold;
import android.os.IVoldListener;
import android.os.IVoldTaskListener;
import android.os.Looper;
import android.os.Message;
import android.os.ParcelFileDescriptor;
import android.os.ParcelableException;
import android.os.PermissionEnforcer;
import android.os.PersistableBundle;
import android.os.Process;
import android.os.RemoteCallbackList;
import android.os.RemoteException;
import android.os.ServiceManager;
import android.os.SystemClock;
import android.os.SystemProperties;
import android.os.Trace;
import android.os.UserHandle;
import android.os.UserManager;
import android.os.storage.DiskInfo;
import android.os.storage.ICeStorageLockEventListener;
import android.os.storage.IObbActionListener;
import android.os.storage.IStorageEventListener;
import android.os.storage.IStorageManager;
import android.os.storage.IStorageShutdownObserver;
import android.os.storage.StorageManager;
import android.os.storage.StorageManagerInternal;
import android.os.storage.StorageVolume;
import android.os.storage.VolumeInfo;
import android.os.storage.VolumeRecord;
import android.provider.DeviceConfig;
import android.provider.Settings;
import android.text.TextUtils;
import android.util.ArrayMap;
import android.util.ArraySet;
import android.util.AtomicFile;
import android.util.DataUnit;
import android.util.EventLog;
import android.util.Log;
import android.util.Pair;
import android.util.Slog;
import android.util.SparseArray;
import android.util.SparseIntArray;
import android.util.TimeUtils;
import android.util.Xml;
import com.android.internal.app.IAppOpsService;
import com.android.internal.content.PackageMonitor;
import com.android.internal.os.AppFuseMount;
import com.android.internal.os.BackgroundThread;
import com.android.internal.os.FuseUnavailableMountException;
import com.android.internal.os.SomeArgs;
import com.android.internal.util.ArrayUtils;
import com.android.internal.util.DumpUtils;
import com.android.internal.util.IndentingPrintWriter;
import com.android.internal.util.XmlUtils;
import com.android.modules.utils.TypedXmlPullParser;
import com.android.modules.utils.TypedXmlSerializer;
import com.android.server.pm.Installer;
import com.android.server.pm.UserManagerInternal;
import com.android.server.slice.SliceClientPermissions;
import com.android.server.storage.AppFuseBridge;
import com.android.server.storage.ImmutableVolumeInfo;
import com.android.server.storage.StorageSessionController;
import com.android.server.storage.WatchedVolumeInfo;
import com.android.server.usage.UnixCalendar;
import com.android.server.utils.WatchedArrayMap;
import com.android.server.wm.ActivityTaskManagerInternal;
import com.obric.utils.ObricImplFactory;
import java.io.File;
import java.io.FileDescriptor;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.CopyOnWriteArraySet;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import libcore.io.IoUtils;
import libcore.util.EmptyArray;
import org.tukaani.xz.LZMA2Options;
import org.xmlpull.v1.XmlPullParserException;

/* JADX INFO: loaded from: classes.dex */
class StorageManagerService extends IStorageManager.Stub implements Watchdog.Monitor, ActivityTaskManagerInternal.ScreenObserver {
    private static final String ANDROID_VOLD_APP_DATA_ISOLATION_ENABLED_PROPERTY = "persist.sys.vold_app_data_isolation_enabled";
    private static final String ANR_DELAY_MILLIS_DEVICE_CONFIG_KEY = "anr_delay_millis";
    private static final String ANR_DELAY_NOTIFY_EXTERNAL_STORAGE_SERVICE_DEVICE_CONFIG_KEY = "anr_delay_notify_external_storage_service";
    private static final String ATTR_CREATED_MILLIS = "createdMillis";
    private static final String ATTR_FS_UUID = "fsUuid";
    private static final String ATTR_LAST_BENCH_MILLIS = "lastBenchMillis";
    private static final String ATTR_LAST_SEEN_MILLIS = "lastSeenMillis";
    private static final String ATTR_LAST_TRIM_MILLIS = "lastTrimMillis";
    private static final String ATTR_NICKNAME = "nickname";
    private static final String ATTR_PART_GUID = "partGuid";
    private static final String ATTR_PRIMARY_STORAGE_UUID = "primaryStorageUuid";
    private static final String ATTR_TYPE = "type";
    private static final String ATTR_USER_FLAGS = "userFlags";
    private static final String ATTR_VERSION = "version";
    private static final boolean DEBUG_OBB = false;
    private static final boolean DEFAULT_CHARGING_REQUIRED = true;
    private static final float DEFAULT_DIRTY_RECLAIM_RATE = 0.5f;
    private static final int DEFAULT_LIFETIME_PERCENT_THRESHOLD = 70;
    private static final float DEFAULT_LOW_BATTERY_LEVEL = 20.0f;
    private static final int DEFAULT_MIN_GC_SLEEPTIME = 10000;
    private static final int DEFAULT_MIN_SEGMENTS_THRESHOLD = 512;
    private static final float DEFAULT_SEGMENT_RECLAIM_WEIGHT = 1.0f;
    private static final boolean DEFAULT_SMART_IDLE_MAINT_ENABLED = false;
    private static final int DEFAULT_SMART_IDLE_MAINT_PERIOD = 60;
    private static final int DEFAULT_TARGET_DIRTY_RATIO = 80;
    public static final int FAILED_MOUNT_RESET_TIMEOUT_SECONDS = 10;
    private static final int H_ABORT_IDLE_MAINT = 12;
    private static final int H_BOOT_COMPLETED = 13;
    private static final int H_CLOUD_MEDIA_PROVIDER_CHANGED = 16;
    private static final int H_COMPLETE_UNLOCK_USER = 14;
    private static final int H_DAEMON_CONNECTED = 2;
    private static final int H_FSTRIM = 4;
    private static final int H_INTERNAL_BROADCAST = 7;
    private static final int H_PARTITION_FORGET = 9;
    private static final int H_REMOUNT_VOLUMES_ON_MOVE = 18;
    private static final int H_RESET = 10;
    private static final int H_RUN_IDLE_MAINT = 11;
    private static final int H_SECURE_KEYGUARD_STATE_CHANGED = 17;
    private static final int H_SHUTDOWN = 3;
    private static final int H_SYSTEM_READY = 1;
    private static final int H_VOLUME_BROADCAST = 6;
    private static final int H_VOLUME_MOUNT = 5;
    private static final int H_VOLUME_STATE_CHANGED = 15;
    private static final int H_VOLUME_UNMOUNT = 8;
    public static final Pattern KNOWN_APP_DIR_PATHS = null;
    private static final String LAST_FSTRIM_FILE = "last-fstrim";
    private static final boolean LOCAL_LOGV = false;
    private static final int MAX_PERIOD_WRITE_RECORD = 4320;
    private static final int MAX_SMART_IDLE_MAINT_PERIOD = 1440;
    private static final int MIN_SMART_IDLE_MAINT_PERIOD = 10;
    private static final int MOVE_STATUS_COPY_FINISHED = 82;
    private static final Pattern OBB_FILE_PATH = null;
    private static final int OBB_FLUSH_MOUNT_STATE = 2;
    private static final int OBB_RUN_ACTION = 1;
    private static final int PARTITION_OPERATION_WATCHDOG_TIMEOUT_MS = 180000;
    private static final int SLOW_OPERATION_WATCHDOG_TIMEOUT_MS = 30000;
    private static final String TAG = "StorageManagerService";
    private static final String TAG_STORAGE_BENCHMARK = "storage_benchmark";
    private static final String TAG_STORAGE_TRIM = "storage_trim";
    private static final String TAG_VOLUME = "volume";
    private static final String TAG_VOLUMES = "volumes";
    private static final int VERSION_ADD_PRIMARY = 2;
    private static final int VERSION_FIX_PRIMARY = 3;
    private static final int VERSION_INIT = 1;
    private static final boolean WATCHDOG_ENABLE = true;
    private static final String ZRAM_ENABLED_PROPERTY = "persist.sys.zram_enabled";
    public static String sMediaStoreAuthorityProcessName;
    static StorageManagerService sSelf;
    static volatile int sSmartIdleMaintPeriod;
    private AppFuseBridge mAppFuseBridge;
    private final Object mAppFuseLock;
    private volatile boolean mBootCompleted;
    private final Callbacks mCallbacks;
    private final CopyOnWriteArrayList<ICeStorageLockEventListener> mCeStorageEventCallbacks;
    private final Set<Integer> mCeStoragePreparedUsers;
    private WatchedUnlockedUsers mCeUnlockedUsers;
    private volatile boolean mChargingRequired;
    private final SparseArray<String> mCloudMediaProviders;
    private final Context mContext;
    private volatile int mCurrentUserId;
    private volatile boolean mDaemonConnected;
    private volatile float mDirtyReclaimRate;
    private ArrayMap<String, CountDownLatch> mDiskScanLatches;
    private ArrayMap<String, DiskInfo> mDisks;
    private volatile int mDownloadsAuthorityAppId;
    private volatile int mExternalStorageAuthorityAppId;
    private final Set<Integer> mFuseMountedUser;
    private final Handler mHandler;
    private IAppOpsService mIAppOpsService;
    private IPackageManager mIPackageManager;
    private final Installer mInstaller;
    private volatile long mInternalStorageSize;
    private long mLastMaintenance;
    private final File mLastMaintenanceFile;
    private volatile int mLifetimePercentThreshold;
    private final IVoldListener mListener;
    private final Object mLock;
    private volatile float mLowBatteryLevel;
    private volatile int mMaxWriteRecords;
    private volatile int mMediaStoreAuthorityAppId;
    private volatile int mMinGCSleepTime;
    private volatile int mMinSegmentsThreshold;
    private IPackageMoveObserver mMoveCallback;
    private String mMoveTargetUuid;
    private volatile boolean mNeedGC;
    private int mNextAppFuseName;
    private final ObbActionHandler mObbActionHandler;
    private final Map<IBinder, List<ObbState>> mObbMounts;
    private final Map<String, ObbState> mObbPathToStateMap;
    private final SparseArray<PackageMonitor> mPackageMonitorsForUser;
    private volatile boolean mPassedLifetimeThresh;
    private PackageManagerInternal mPmInternal;
    private String mPrimaryStorageUuid;
    private ArrayMap<String, VolumeRecord> mRecords;
    private volatile boolean mRemountCurrentUserVolumesOnUnlock;
    private volatile boolean mSecureKeyguardShowing;
    private volatile float mSegmentReclaimWeight;
    private final AtomicFile mSettingsFile;
    private final StorageManagerInternalImpl mStorageManagerInternal;
    private final StorageSessionController mStorageSessionController;
    private volatile int[] mStorageWriteRecords;
    private volatile IStoraged mStoraged;
    private int[] mSystemUnlockedUsers;
    private volatile int mTargetDirtyRatio;
    private final Set<Integer> mUidsWithLegacyExternalStorage;
    private BroadcastReceiver mUserReceiver;
    private final SparseIntArray mUserSharesMediaWith;
    private volatile IVold mVold;
    private final boolean mVoldAppDataIsolationEnabled;
    private final WatchedArrayMap<String, WatchedVolumeInfo> mVolumes;
    private final AtomicFile mWriteRecordFile;

    class AppFuseMountScope extends AppFuseBridge.MountScope {
        private boolean mMounted;
        final /* synthetic */ StorageManagerService this$0;

        /* JADX INFO: renamed from: $r8$lambda$4kKaKLh9-s9xF3nc5qRomKq3iik, reason: not valid java name */
        public static /* synthetic */ void m382$r8$lambda$4kKaKLh9s9xF3nc5qRomKq3iik(AppFuseMountScope r0) {
            r0.lambda$close$0();
        }

        public AppFuseMountScope(StorageManagerService this$0, int uid, int mountId) {
            this.this$0 = this$0;
            super(uid, mountId);
            this.mMounted = false;
        }

        @Override // com.android.server.storage.AppFuseBridge.MountScope
        public ParcelFileDescriptor open() throws AppFuseMountException {
            StorageManagerService.m345$$Nest$mextendWatchdogTimeout(this.this$0, "#open might be slow");
            FileDescriptor fd = StorageManagerService.m331$$Nest$fgetmVold(this.this$0).mountAppFuse(this.uid, this.mountId);     // Catch: Exception -> L5
            this.mMounted = true;     // Catch: Exception -> L5
            return new ParcelFileDescriptor(fd);
        L5:
            e = move-exception;
            throw new AppFuseMountException("Failed to mount", e);
        }

        @Override // com.android.server.storage.AppFuseBridge.MountScope
        public ParcelFileDescriptor openFile(int mountId, int fileId, int flags) throws AppFuseMountException {
            StorageManagerService.m345$$Nest$mextendWatchdogTimeout(this.this$0, "#openFile might be slow");
            return new ParcelFileDescriptor(StorageManagerService.m331$$Nest$fgetmVold(this.this$0).openAppFuseFile(this.uid, mountId, fileId, flags));
        L5:
            e = move-exception;
            throw new AppFuseMountException("Failed to open", e);
        }

        @Override // java.lang.AutoCloseable
        public void close() throws Exception {
            StorageManagerService.m345$$Nest$mextendWatchdogTimeout(this.this$0, "#close might be slow");
            if (this.mMounted == false) goto L6;
            BackgroundThread.getHandler().post(new StorageManagerService$AppFuseMountScope$$ExternalSyntheticLambda0(this));
            this.mMounted = false;
            return;
        }

        private /* synthetic */ void lambda$close$0() {
            StorageManagerService.m331$$Nest$fgetmVold(this.this$0).unmountAppFuse(this.uid, this.mountId);     // Catch: RemoteException -> L4
            return;
        L4:
            e = move-exception;
            throw e.rethrowAsRuntimeException();
        }
    }

    private static class Callbacks extends Handler {
        private static final int MSG_DISK_DESTROYED = 6;
        private static final int MSG_DISK_SCANNED = 5;
        private static final int MSG_STORAGE_STATE_CHANGED = 1;
        private static final int MSG_VOLUME_FORGOTTEN = 4;
        private static final int MSG_VOLUME_RECORD_CHANGED = 3;
        private static final int MSG_VOLUME_STATE_CHANGED = 2;
        private final RemoteCallbackList<IStorageEventListener> mCallbacks;

        /* JADX INFO: renamed from: -$$Nest$mnotifyDiskDestroyed, reason: not valid java name */
        static /* bridge */ /* synthetic */ void m383$$Nest$mnotifyDiskDestroyed(Callbacks r0, DiskInfo r1) {
            r0.notifyDiskDestroyed(r1);
        }

        /* JADX INFO: renamed from: -$$Nest$mnotifyDiskScanned, reason: not valid java name */
        static /* bridge */ /* synthetic */ void m384$$Nest$mnotifyDiskScanned(Callbacks r0, DiskInfo r1, int r2) {
            r0.notifyDiskScanned(r1, r2);
        }

        /* JADX INFO: renamed from: -$$Nest$mnotifyStorageStateChanged, reason: not valid java name */
        static /* bridge */ /* synthetic */ void m385$$Nest$mnotifyStorageStateChanged(Callbacks r0, String r1, String r2, String r3) {
            r0.notifyStorageStateChanged(r1, r2, r3);
        }

        /* JADX INFO: renamed from: -$$Nest$mnotifyVolumeForgotten, reason: not valid java name */
        static /* bridge */ /* synthetic */ void m386$$Nest$mnotifyVolumeForgotten(Callbacks r0, String r1) {
            r0.notifyVolumeForgotten(r1);
        }

        /* JADX INFO: renamed from: -$$Nest$mnotifyVolumeRecordChanged, reason: not valid java name */
        static /* bridge */ /* synthetic */ void m387$$Nest$mnotifyVolumeRecordChanged(Callbacks r0, VolumeRecord r1) {
            r0.notifyVolumeRecordChanged(r1);
        }

        /* JADX INFO: renamed from: -$$Nest$mnotifyVolumeStateChanged, reason: not valid java name */
        static /* bridge */ /* synthetic */ void m388$$Nest$mnotifyVolumeStateChanged(Callbacks r0, WatchedVolumeInfo r1, int r2, int r3) {
            r0.notifyVolumeStateChanged(r1, r2, r3);
        }

        public Callbacks(Looper looper) {
            super(looper);
            this.mCallbacks = new RemoteCallbackList();
        }

        public void register(IStorageEventListener callback) {
            this.mCallbacks.register(callback);
        }

        public void unregister(IStorageEventListener callback) {
            this.mCallbacks.unregister(callback);
        }

        @Override // android.os.Handler
        public void handleMessage(Message msg) {
            SomeArgs args = (SomeArgs) msg.obj;
            int n = this.mCallbacks.beginBroadcast();
            int i = 0;
        L3:
            if (i >= n) goto L9;
            IStorageEventListener callback = (IStorageEventListener) this.mCallbacks.getBroadcastItem(i);
            invokeCallback(callback, msg.what, args);     // Catch: RemoteException -> L7
        L8:
            i = i + 1;
            goto L3
        L9:
            this.mCallbacks.finishBroadcast();
            args.recycle();
        }

        private void invokeCallback(IStorageEventListener callback, int what, SomeArgs args) throws RemoteException {
            switch(what) {
                case 1: goto L9;
                case 2: goto L8;
                case 3: goto L7;
                case 4: goto L6;
                case 5: goto L5;
                case 6: goto L4;
                default: goto L16;
            };
        L4:
            callback.onDiskDestroyed((DiskInfo) args.arg1);
            return;
        L5:
            callback.onDiskScanned((DiskInfo) args.arg1, args.argi2);
            return;
        L6:
            callback.onVolumeForgotten((String) args.arg1);
            return;
        L7:
            callback.onVolumeRecordChanged((VolumeRecord) args.arg1);
            return;
        L8:
            VolumeInfo volInfo = ((WatchedVolumeInfo) args.arg1).getVolumeInfo();
            callback.onVolumeStateChanged(volInfo, args.argi2, args.argi3);
            return;
        L9:
            callback.onStorageStateChanged((String) args.arg1, (String) args.arg2, (String) args.arg3);
            return;
        }

        private void notifyStorageStateChanged(String path, String oldState, String newState) {
            SomeArgs args = SomeArgs.obtain();
            args.arg1 = path;
            args.arg2 = oldState;
            args.arg3 = newState;
            obtainMessage(1, args).sendToTarget();
        }

        private void notifyVolumeStateChanged(WatchedVolumeInfo vol, int oldState, int newState) {
            SomeArgs args = SomeArgs.obtain();
            args.arg1 = vol.clone();
            args.argi2 = oldState;
            args.argi3 = newState;
            obtainMessage(2, args).sendToTarget();
        }

        private void notifyVolumeRecordChanged(VolumeRecord rec) {
            SomeArgs args = SomeArgs.obtain();
            args.arg1 = rec.clone();
            obtainMessage(3, args).sendToTarget();
        }

        private void notifyVolumeForgotten(String fsUuid) {
            SomeArgs args = SomeArgs.obtain();
            args.arg1 = fsUuid;
            obtainMessage(4, args).sendToTarget();
        }

        private void notifyDiskScanned(DiskInfo disk, int volumeCount) {
            SomeArgs args = SomeArgs.obtain();
            args.arg1 = disk.clone();
            args.argi2 = volumeCount;
            obtainMessage(5, args).sendToTarget();
        }

        private void notifyDiskDestroyed(DiskInfo disk) {
            SomeArgs args = SomeArgs.obtain();
            args.arg1 = disk.clone();
            obtainMessage(6, args).sendToTarget();
        }
    }

    private class ExternalStorageServiceAnrController implements AnrController {
        final /* synthetic */ StorageManagerService this$0;

        /* synthetic */ ExternalStorageServiceAnrController(StorageManagerService r1, StorageManagerServiceIA r2) {
            this(r1);
        }

        private ExternalStorageServiceAnrController(StorageManagerService r1) {
            this.this$0 = r1;
        }

        public long getAnrDelayMillis(String packageName, int uid) {
            if (StorageManagerService.m352$$Nest$misAppIoBlocked(this.this$0, uid) == true) goto L6;
            return 0;
        L6:
            int delay = DeviceConfig.getInt("storage_native_boot", StorageManagerService.ANR_DELAY_MILLIS_DEVICE_CONFIG_KEY, 5000);
            Slog.v(StorageManagerService.TAG, "getAnrDelayMillis for " + packageName + ". " + delay + "ms");
            return delay;
        }

        public void onAnrDelayStarted(String packageName, int uid) {
            if (StorageManagerService.m352$$Nest$misAppIoBlocked(this.this$0, uid) == true) goto L5;
            return;
        L5:
            boolean notifyExternalStorageService = DeviceConfig.getBoolean("storage_native_boot", StorageManagerService.ANR_DELAY_NOTIFY_EXTERNAL_STORAGE_SERVICE_DEVICE_CONFIG_KEY, true);
            if (notifyExternalStorageService == false) goto L15;
            Slog.d(StorageManagerService.TAG, "onAnrDelayStarted for " + packageName + ". Notifying external storage service");
            StorageManagerService.m329$$Nest$fgetmStorageSessionController(this.this$0).notifyAnrDelayStarted(packageName, uid, 0, 1);     // Catch: StorageSessionController.ExternalStorageServiceException -> L10
            return;
        L10:
            e = move-exception;
            Slog.e(StorageManagerService.TAG, "Failed to notify ANR delay started for " + packageName, e);
            return;
        }

        public boolean onAnrDelayCompleted(String packageName, int uid) {
            if (StorageManagerService.m352$$Nest$misAppIoBlocked(this.this$0, uid) == false) goto L6;
            Slog.d(StorageManagerService.TAG, "onAnrDelayCompleted for " + packageName + ". Showing ANR dialog...");
            return true;
        L6:
            Slog.d(StorageManagerService.TAG, "onAnrDelayCompleted for " + packageName + ". Skipping ANR dialog...");
            return false;
        }
    }

    public static class Lifecycle extends SystemService {
        private StorageManagerService mStorageManagerService;

        public Lifecycle(Context context) {
            super(context);
        }

        @Override // com.android.server.SystemService
        public void onStart() {
            this.mStorageManagerService = new StorageManagerService(getContext());
            publishBinderService("mount", this.mStorageManagerService);
            StorageManagerService.m375$$Nest$mstart(this.mStorageManagerService);
        }

        @Override // com.android.server.SystemService
        public void onBootPhase(int phase) {
            if (phase != 500) goto L6;
            StorageManagerService.m373$$Nest$mservicesReady(this.mStorageManagerService);
            return;
        L6:
            if (phase != 550) goto L9;
            StorageManagerService.m376$$Nest$msystemReady(this.mStorageManagerService);
            return;
        L9:
            if (phase != 1000) goto L14;
            StorageManagerService.m339$$Nest$mbootCompleted(this.mStorageManagerService);
            return;
        }

        @Override // com.android.server.SystemService
        public void onUserSwitching(SystemService.TargetUser from, SystemService.TargetUser to) {
            int currentUserId = to.getUserIdentifier();
            StorageManagerService.m333$$Nest$fputmCurrentUserId(this.mStorageManagerService, currentUserId);
            UserManagerInternal umInternal = (UserManagerInternal) LocalServices.getService(UserManagerInternal.class);
            if (umInternal.isUserUnlocked(currentUserId) == false) goto L5;
            Slog.d(StorageManagerService.TAG, "Attempt remount volumes for user: " + currentUserId);
            StorageManagerService.m355$$Nest$mmaybeRemountVolumes(this.mStorageManagerService, currentUserId);
            StorageManagerService.m335$$Nest$fputmRemountCurrentUserVolumesOnUnlock(this.mStorageManagerService, false);
            return;
        L5:
            Slog.d(StorageManagerService.TAG, "Attempt remount volumes for user: " + currentUserId + " on unlock");
            StorageManagerService.m335$$Nest$fputmRemountCurrentUserVolumesOnUnlock(this.mStorageManagerService, true);
        }

        @Override // com.android.server.SystemService
        public void onUserUnlocking(SystemService.TargetUser user) {
            StorageManagerService.m363$$Nest$monUserUnlocking(this.mStorageManagerService, user.getUserIdentifier());
        }

        @Override // com.android.server.SystemService
        public void onUserStopped(SystemService.TargetUser user) {
            StorageManagerService.m361$$Nest$monUserStopped(this.mStorageManagerService, user.getUserIdentifier());
        }

        @Override // com.android.server.SystemService
        public void onUserStopping(SystemService.TargetUser user) {
            StorageManagerService.m362$$Nest$monUserStopping(this.mStorageManagerService, user.getUserIdentifier());
        }

        @Override // com.android.server.SystemService
        public void onUserStarting(SystemService.TargetUser user) {
            StorageManagerService.m374$$Nest$msnapshotAndMonitorLegacyStorageAppOp(this.mStorageManagerService, user.getUserHandle());
        }
    }

    class MountObbAction extends ObbAction {
        private final int mCallingUid;
        private ObbInfo mObbInfo;
        final /* synthetic */ StorageManagerService this$0;

        MountObbAction(StorageManagerService this$0, ObbState obbState, int callingUid, ObbInfo obbInfo) {
            this.this$0 = this$0;
            super(obbState);
            this.mCallingUid = callingUid;
            this.mObbInfo = obbInfo;
        }

        @Override // com.android.server.StorageManagerService.ObbAction
        public void handleExecute() throws ObbException {
            StorageManagerService.m379$$Nest$mwarnOnNotMounted(this.this$0);
            if (StorageManagerService.m354$$Nest$misUidOwnerOfPackageOrSystem(this.this$0, this.mObbInfo.packageName, this.mCallingUid) == false) goto L29;
            Map r0 = StorageManagerService.m326$$Nest$fgetmObbMounts(this.this$0);
            monitor-enter(r0);
            boolean isMounted = StorageManagerService.m327$$Nest$fgetmObbPathToStateMap(this.this$0).containsKey(this.mObbState.rawPath);     // Catch: Throwable -> L25
            monitor-exit(r0);     // Catch: Throwable -> L25
            if (isMounted == true) goto L24;
            this.mObbState.volId = StorageManagerService.m331$$Nest$fgetmVold(this.this$0).createObb(this.mObbState.canonicalPath, this.mObbState.ownerGid);     // Catch: Exception -> L16
            StorageManagerService.m331$$Nest$fgetmVold(this.this$0).mount(this.mObbState.volId, 0, -1, null);     // Catch: Exception -> L16
            Map r1 = StorageManagerService.m326$$Nest$fgetmObbMounts(this.this$0);     // Catch: Exception -> L16
            monitor-enter(r1);     // Catch: Exception -> L16
            StorageManagerService.m338$$Nest$maddObbStateLocked(this.this$0, this.mObbState);     // Catch: Throwable -> L18
            monitor-exit(r1);     // Catch: Throwable -> L18
        L14:
            notifyObbStateChange(1);     // Catch: Exception -> L16
            return;
        L18:
            th = move-exception;
            throw th;     // Catch: Exception -> L16
        L16:
            e = move-exception;
            throw new ObbException(21, e);
        L24:
            throw new ObbException(24, "Attempt to mount OBB which is already mounted: " + this.mObbInfo.filename);
        L25:
            th = move-exception;
            throw th;
        L29:
            throw new ObbException(25, "Denied attempt to mount OBB " + this.mObbInfo.filename + " which is owned by " + this.mObbInfo.packageName);
        }

        public String toString() {
            return "MountObbAction{" + this.mObbState + '}';
        }
    }

    private static abstract class ObbAction {
        ObbState mObbState;

        abstract void handleExecute() throws ObbException;

        ObbAction(ObbState obbState) {
            this.mObbState = obbState;
        }

        public void execute(ObbActionHandler handler) {
            handleExecute();     // Catch: ObbException -> L4
            return;
        L4:
            e = move-exception;
            notifyObbStateChange(e);
        }

        protected void notifyObbStateChange(ObbException e) {
            Slog.w(StorageManagerService.TAG, e);
            notifyObbStateChange(e.status);
        }

        protected void notifyObbStateChange(int status) {
            if (this.mObbState != null) goto L5;
            return;
        L5:
            if (this.mObbState.token == null) goto L16;
            this.mObbState.token.onObbResult(this.mObbState.rawPath, this.mObbState.nonce, status);     // Catch: RemoteException -> L9
            return;
        L10:
            Slog.w(StorageManagerService.TAG, "StorageEventListener went away while calling onObbStateChanged");
            return;
        }
    }

    private class ObbActionHandler extends Handler {
        final /* synthetic */ StorageManagerService this$0;

        ObbActionHandler(StorageManagerService r1, Looper l) {
            this.this$0 = r1;
            super(l);
        }

        @Override // android.os.Handler
        public void handleMessage(Message msg) {
            switch(msg.what) {
                case 1: goto L29;
                case 2: goto L5;
                default: goto L42;
            };
        L5:
            String path = (String) msg.obj;
            Map r1 = StorageManagerService.m326$$Nest$fgetmObbMounts(this.this$0);
            monitor-enter(r1);
            List<ObbState> obbStatesToRemove = new ArrayList();     // Catch: Throwable -> L13
            Iterator<ObbState> i = StorageManagerService.m327$$Nest$fgetmObbPathToStateMap(this.this$0).values().iterator();     // Catch: Throwable -> L13
        L9:
            if (i.hasNext() == false) goto L16;
            ObbState state = i.next();     // Catch: Throwable -> L13
            if (state.canonicalPath.startsWith(path) == false) goto L9;
            obbStatesToRemove.add(state);     // Catch: Throwable -> L13
            goto L9
        L16:
            Iterator<ObbState> r4 = obbStatesToRemove.iterator();     // Catch: Throwable -> L13
        L18:
            if (r4.hasNext() == false) goto L25;
            ObbState obbState = r4.next();     // Catch: Throwable -> L13
            StorageManagerService.m370$$Nest$mremoveObbStateLocked(this.this$0, obbState);     // Catch: Throwable -> L13
            obbState.token.onObbResult(obbState.rawPath, obbState.nonce, 2);     // Catch: Throwable -> L13 RemoteException -> L22
        L23:
            Slog.i(StorageManagerService.TAG, "Couldn't send unmount notification for  OBB: " + obbState.rawPath);     // Catch: Throwable -> L13
            goto L18
        L25:
            monitor-exit(r1);     // Catch: Throwable -> L13
            return;
        L13:
            th = move-exception;
            throw th;
        L29:
            ObbAction action = (ObbAction) msg.obj;
            action.execute(this);
            return;
        }
    }

    private static class ObbException extends Exception {
        public final int status;

        public ObbException(int status, String message) {
            super(message);
            this.status = status;
        }

        public ObbException(int status, Throwable cause) {
            super(cause.getMessage(), cause);
            this.status = status;
        }
    }

    class ObbState implements IBinder.DeathRecipient {
        final String canonicalPath;
        final int nonce;
        final int ownerGid;
        final String rawPath;
        final /* synthetic */ StorageManagerService this$0;
        final IObbActionListener token;
        String volId;

        public ObbState(StorageManagerService this$0, String rawPath, String canonicalPath, int callingUid, IObbActionListener token, int nonce, String volId) {
            this.this$0 = this$0;
            this.rawPath = rawPath;
            this.canonicalPath = canonicalPath;
            this.ownerGid = UserHandle.getSharedAppGid(callingUid);
            this.token = token;
            this.nonce = nonce;
            this.volId = volId;
        }

        public IBinder getBinder() {
            return this.token.asBinder();
        }

        @Override // android.os.IBinder.DeathRecipient
        public void binderDied() {
            ObbAction action = new UnmountObbAction(this.this$0, this, true);
            StorageManagerService.m325$$Nest$fgetmObbActionHandler(this.this$0).sendMessage(StorageManagerService.m325$$Nest$fgetmObbActionHandler(this.this$0).obtainMessage(1, action));
        }

        public void link() throws RemoteException {
            getBinder().linkToDeath(this, 0);
        }

        public void unlink() {
            getBinder().unlinkToDeath(this, 0);
        }

        public String toString() {
            return "ObbState{rawPath=" + this.rawPath + ",canonicalPath=" + this.canonicalPath + ",ownerGid=" + this.ownerGid + ",token=" + this.token + ",binder=" + getBinder() + ",volId=" + this.volId + '}';
        }
    }

    private final class StorageManagerInternalImpl extends StorageManagerInternal {
        private final CopyOnWriteArraySet<StorageManagerInternal.CloudProviderChangeListener> mCloudProviderChangeListeners;
        private final List<StorageManagerInternal.ResetListener> mResetListeners;
        final /* synthetic */ StorageManagerService this$0;

        /* JADX INFO: renamed from: -$$Nest$fgetmCloudProviderChangeListeners, reason: not valid java name */
        static /* bridge */ /* synthetic */ CopyOnWriteArraySet m389$$Nest$fgetmCloudProviderChangeListeners(StorageManagerInternalImpl r0) {
            return r0.mCloudProviderChangeListeners;
        }

        /* synthetic */ StorageManagerInternalImpl(StorageManagerService r1, StorageManagerServiceIA r2) {
            this(r1);
        }

        private StorageManagerInternalImpl(StorageManagerService r1) {
            this.this$0 = r1;
            this.mResetListeners = new ArrayList();
            this.mCloudProviderChangeListeners = new CopyOnWriteArraySet();
        }

        public boolean isFuseMounted(int userId) {
            Object r0 = StorageManagerService.m323$$Nest$fgetmLock(this.this$0);
            monitor-enter(r0);
            boolean r1 = StorageManagerService.m316$$Nest$fgetmFuseMountedUser(this.this$0).contains(Integer.valueOf(userId));     // Catch: Throwable -> L7
            monitor-exit(r0);     // Catch: Throwable -> L7
            return r1;
        L7:
            th = move-exception;
            throw th;
        }

        public boolean prepareStorageDirs(int userId, Set<String> packageList, String processName) {
            Object r0 = StorageManagerService.m323$$Nest$fgetmLock(this.this$0);
            monitor-enter(r0);
        L9:
            th = move-exception;
            throw th;
        L5:
            if (StorageManagerService.m316$$Nest$fgetmFuseMountedUser(this.this$0).contains(Integer.valueOf(userId)) == true) goto L11;
            Slog.w(StorageManagerService.TAG, "User " + userId + " is not unlocked yet so skip mounting obb");     // Catch: Throwable -> L9
            monitor-exit(r0);     // Catch: Throwable -> L9
            return false;
        L11:
            monitor-exit(r0);     // Catch: Throwable -> L9
            IVold vold = IVold.Stub.asInterface(ServiceManager.getServiceOrThrow("vold"));     // Catch: Throwable -> L17
            Iterator<String> r1 = packageList.iterator();     // Catch: Throwable -> L17
        L14:
            if (r1.hasNext() == false) goto L19;
            String pkg = r1.next();     // Catch: Throwable -> L17
            String packageObbDir = String.format(Locale.US, "/storage/emulated/%d/Android/obb/%s/", new Object[]{Integer.valueOf(userId), pkg});     // Catch: Throwable -> L17
            String packageDataDir = String.format(Locale.US, "/storage/emulated/%d/Android/data/%s/", new Object[]{Integer.valueOf(userId), pkg});     // Catch: Throwable -> L17
            int appUid = UserHandle.getUid(userId, StorageManagerService.m328$$Nest$fgetmPmInternal(this.this$0).getPackage(pkg).getUid());     // Catch: Throwable -> L17
            vold.ensureAppDirsCreated(new String[]{packageObbDir, packageDataDir}, appUid);     // Catch: Throwable -> L17
            goto L14
        L19:
            return true;
        L17:
            e = move-exception;
            Slog.e(StorageManagerService.TAG, "Unable to create obb and data directories for " + processName, e);
            return false;
        }

        public int getExternalStorageMountMode(int uid, String packageName) {
            int mode = StorageManagerService.m348$$Nest$mgetMountModeInternal(this.this$0, uid, packageName);
            if (StorageManagerService.m381$$Nest$sfgetLOCAL_LOGV() == false) goto L5;
            Slog.v(StorageManagerService.TAG, "Resolved mode " + mode + " for " + packageName + SliceClientPermissions.SliceAuthority.DELIMITER + UserHandle.formatUid(uid));
        L5:
            return mode;
        }

        public boolean hasExternalStorageAccess(int uid, String packageName) {
            int opMode = StorageManagerService.m318$$Nest$fgetmIAppOpsService(this.this$0).checkOperation(92, uid, packageName);     // Catch: RemoteException -> L9
            if (opMode != 3) goto L11;
            if (StorageManagerService.m319$$Nest$fgetmIPackageManager(this.this$0).checkUidPermission("android.permission.MANAGE_EXTERNAL_STORAGE", uid) == 0) goto L8;
            return false;
        L8:
            return true;
        L11:
            if (opMode == 0) goto L13;
            return false;
        L13:
            return true;
        L9:
            e = move-exception;
            Slog.w("Failed to check MANAGE_EXTERNAL_STORAGE access for " + packageName, e);
            return false;
        }

        public void addResetListener(StorageManagerInternal.ResetListener listener) {
            List<StorageManagerInternal.ResetListener> r0 = this.mResetListeners;
            monitor-enter(r0);
            this.mResetListeners.add(listener);     // Catch: Throwable -> L7
            monitor-exit(r0);     // Catch: Throwable -> L7
            return;
        L7:
            th = move-exception;
            throw th;
        }

        public void onReset(IVold vold) {
            List<StorageManagerInternal.ResetListener> r0 = this.mResetListeners;
            monitor-enter(r0);
            Iterator<StorageManagerInternal.ResetListener> r1 = this.mResetListeners.iterator();     // Catch: Throwable -> L8
        L6:
            if (r1.hasNext() == false) goto L10;
            StorageManagerInternal.ResetListener listener = r1.next();     // Catch: Throwable -> L8
            listener.onReset(vold);     // Catch: Throwable -> L8
            goto L6
        L10:
            monitor-exit(r0);     // Catch: Throwable -> L8
            return;
        L8:
            th = move-exception;
            throw th;
        }

        public void resetUser(int userId) {
            StorageManagerService.m317$$Nest$fgetmHandler(this.this$0).obtainMessage(10).sendToTarget();
        }

        public boolean hasLegacyExternalStorage(int uid) {
            Object r0 = StorageManagerService.m323$$Nest$fgetmLock(this.this$0);
            monitor-enter(r0);
            boolean r1 = StorageManagerService.m330$$Nest$fgetmUidsWithLegacyExternalStorage(this.this$0).contains(Integer.valueOf(uid));     // Catch: Throwable -> L7
            monitor-exit(r0);     // Catch: Throwable -> L7
            return r1;
        L7:
            th = move-exception;
            throw th;
        }

        public void prepareAppDataAfterInstall(String packageName, int uid) {
            int userId = UserHandle.getUserId(uid);
            Environment.UserEnvironment userEnv = new Environment.UserEnvironment(userId);
            File[] packageObbDirs = userEnv.buildExternalStorageAppObbDirs(packageName);
            int r3 = packageObbDirs.length;
            int r4 = 0;
        L3:
            if (r4 >= r3) goto L16;
            File packageObbDir = packageObbDirs[r4];
            if (packageObbDir.getPath().startsWith(Environment.getDataPreloadsMediaDirectory().getPath()) == false) goto L17;
            Slog.i(StorageManagerService.TAG, "Skipping app data preparation for " + packageObbDir);
        L15:
            r4 = r4 + 1;
            goto L3
        L17:
            StorageManagerService.m331$$Nest$fgetmVold(this.this$0).fixupAppDir(packageObbDir.getCanonicalPath() + SliceClientPermissions.SliceAuthority.DELIMITER, uid);     // Catch: Throwable -> L9 IOException -> L11
        L9:
            e = move-exception;
            Log.e(StorageManagerService.TAG, "Failed to fixup app dir for " + packageName, e);
        L14:
            Log.e(StorageManagerService.TAG, "Failed to get canonical path for " + packageName);
            goto L15
        }

        public boolean isExternalStorageService(int uid) {
            if (StorageManagerService.m324$$Nest$fgetmMediaStoreAuthorityAppId(this.this$0) != UserHandle.getAppId(uid)) goto L5;
            return true;
        L5:
            return false;
        }

        public void freeCache(String volumeUuid, long freeBytes) {
            StorageManagerService.m329$$Nest$fgetmStorageSessionController(this.this$0).freeCache(volumeUuid, freeBytes);     // Catch: StorageSessionController.ExternalStorageServiceException -> L4
            return;
        L4:
            e = move-exception;
            Log.e(StorageManagerService.TAG, "Failed to free cache of vol : " + volumeUuid, e);
        }

        public boolean hasExternalStorage(int uid, String packageName) {
            if (uid != 1000) goto L6;
            return true;
        L6:
            if (getExternalStorageMountMode(uid, packageName) != 0) goto L10;
            return false;
        L10:
            return true;
        }

        private void killAppForOpChange(int code, int uid) {
            IActivityManager am = ActivityManager.getService();
            am.killUid(UserHandle.getAppId(uid), -1, AppOpsManager.opToName(code) + " changed.");     // Catch: RemoteException -> L5
            return;
        }

        public void onAppOpsChanged(int code, int uid, String packageName, int mode, int previousMode) {
            long token = Binder.clearCallingIdentity();
            switch(code) {
                case 66: goto L20;
                case 87: goto L13;
                case 92: goto L6;
                default: goto L4;
            };
        L4:
            Binder.restoreCallingIdentity(token);
            return;
        L6:
            if (mode == 0) goto L11;
            killAppForOpChange(code, uid);     // Catch: Throwable -> L9
        L11:
            Binder.restoreCallingIdentity(token);
            return;
        L13:
            StorageManagerService r2 = this.this$0;     // Catch: Throwable -> L9
            if (mode != 0) goto L16;
            boolean r3 = true;
        L17:
            StorageManagerService.m378$$Nest$mupdateLegacyStorageApps(r2, packageName, uid, r3);     // Catch: Throwable -> L9
            Binder.restoreCallingIdentity(token);
            return;
        L16:
            r3 = false;
            goto L17
        L20:
            if (previousMode != 0) goto L26;
            if (mode == 0) goto L26;
            killAppForOpChange(code, uid);     // Catch: Throwable -> L9
        L26:
            Binder.restoreCallingIdentity(token);
            return;
        L9:
            th = move-exception;
            Binder.restoreCallingIdentity(token);
            throw th;
        }

        public List<String> getPrimaryVolumeIds() {
            List<String> primaryVolumeIds = new ArrayList();
            Object r1 = StorageManagerService.m323$$Nest$fgetmLock(this.this$0);
            monitor-enter(r1);
            int i = 0;
        L18:
        L10:
            th = move-exception;
            throw th;
        L6:
            if (i >= StorageManagerService.m332$$Nest$fgetmVolumes(this.this$0).size()) goto L14;
            WatchedVolumeInfo vol = (WatchedVolumeInfo) StorageManagerService.m332$$Nest$fgetmVolumes(this.this$0).valueAt(i);     // Catch: Throwable -> L10
            if (vol.isPrimary() == false) goto L12;
            primaryVolumeIds.add(vol.getId());     // Catch: Throwable -> L10
        L12:
            i = i + 1;     // Catch: Throwable -> L10
            goto L18
        L14:
            monitor-exit(r1);     // Catch: Throwable -> L10
            return primaryVolumeIds;
        }

        public void markCeStoragePrepared(int userId) {
            Object r0 = StorageManagerService.m323$$Nest$fgetmLock(this.this$0);
            monitor-enter(r0);
            StorageManagerService.m313$$Nest$fgetmCeStoragePreparedUsers(this.this$0).add(Integer.valueOf(userId));     // Catch: Throwable -> L7
            monitor-exit(r0);     // Catch: Throwable -> L7
            return;
        L7:
            th = move-exception;
            throw th;
        }

        public boolean isCeStoragePrepared(int userId) {
            Object r0 = StorageManagerService.m323$$Nest$fgetmLock(this.this$0);
            monitor-enter(r0);
            boolean r1 = StorageManagerService.m313$$Nest$fgetmCeStoragePreparedUsers(this.this$0).contains(Integer.valueOf(userId));     // Catch: Throwable -> L7
            monitor-exit(r0);     // Catch: Throwable -> L7
            return r1;
        L7:
            th = move-exception;
            throw th;
        }

        public void registerCloudProviderChangeListener(StorageManagerInternal.CloudProviderChangeListener listener) {
            this.mCloudProviderChangeListeners.add(listener);
            StorageManagerService.m317$$Nest$fgetmHandler(this.this$0).obtainMessage(16, listener).sendToTarget();
        }

        public void prepareUserStorageForMove(String fromVolumeUuid, String toVolumeUuid, List<UserInfo> users) {
            StorageManagerService.m367$$Nest$mprepareUserStorageForMoveInternal(this.this$0, fromVolumeUuid, toVolumeUuid, users);     // Catch: Exception -> L4
            return;
        L4:
            e = move-exception;
            throw new RuntimeException(e);
        }

        public IInstalld.IFsveritySetupAuthToken createFsveritySetupAuthToken(ParcelFileDescriptor authFd, int uid) throws IOException {
            return StorageManagerService.m320$$Nest$fgetmInstaller(this.this$0).createFsveritySetupAuthToken(authFd, uid);
        L4:
            e = move-exception;
            throw new IOException(e);
        }

        public int enableFsverity(IInstalld.IFsveritySetupAuthToken authToken, String filePath, String packageName) throws IOException {
            return StorageManagerService.m320$$Nest$fgetmInstaller(this.this$0).enableFsverity(authToken, filePath, packageName);
        L4:
            e = move-exception;
            throw new IOException(e);
        }

        public void registerStorageLockEventListener(ICeStorageLockEventListener listener) {
            boolean registered = StorageManagerService.m312$$Nest$fgetmCeStorageEventCallbacks(this.this$0).add(listener);
            if (registered == true) goto L6;
            Slog.w(StorageManagerService.TAG, "Failed to register listener: " + listener);
            return;
        }

        public void unregisterStorageLockEventListener(ICeStorageLockEventListener listener) {
            boolean unregistered = StorageManagerService.m312$$Nest$fgetmCeStorageEventCallbacks(this.this$0).remove(listener);
            if (unregistered == true) goto L6;
            Slog.w(StorageManagerService.TAG, "Unregistering " + listener + " that was not registered");
            return;
        }
    }

    class StorageManagerServiceHandler extends Handler {
        final /* synthetic */ StorageManagerService this$0;

        public StorageManagerServiceHandler(StorageManagerService this$0, Looper looper) {
            this.this$0 = this$0;
            super(looper);
        }

        @Override // android.os.Handler
        public void handleMessage(Message msg) {
            int r1 = 0;
            switch(msg.what) {
                case 1: goto L52;
                case 2: goto L51;
                case 3: goto L38;
                case 4: goto L30;
                case 5: goto L26;
                case 6: goto L23;
                case 7: goto L22;
                case 8: goto L21;
                case 9: goto L20;
                case 10: goto L19;
                case 11: goto L18;
                case 12: goto L17;
                case 13: goto L16;
                case 14: goto L15;
                case 15: goto L14;
                case 16: goto L11;
                case 17: goto L60;
                case 18: goto L5;
                default: goto L83;
            };
        L5:
            StorageManagerService.m369$$Nest$mremountVolumesForRunningUsersOnMove(this.this$0);
            return;
        L14:
            SomeArgs args = (SomeArgs) msg.obj;
            StorageManagerService.m365$$Nest$monVolumeStateChangedAsync(this.this$0, (WatchedVolumeInfo) args.arg1, args.argi1, args.argi2);
            args.recycle();
            return;
        L15:
            StorageManagerService.m340$$Nest$mcompleteUnlockUser(this.this$0, msg.arg1);
            return;
        L16:
            StorageManagerService.m349$$Nest$mhandleBootCompleted(this.this$0);
            return;
        L17:
            Slog.i(StorageManagerService.TAG, "Aborting idle maintenance");
            this.this$0.abortIdleMaint((Runnable) msg.obj);
            return;
        L18:
            Slog.i(StorageManagerService.TAG, "Running idle maintenance");
            this.this$0.runIdleMaint((Runnable) msg.obj);
            return;
        L19:
            StorageManagerService.m371$$Nest$mresetIfBootedAndConnected(this.this$0);
            return;
        L20:
            VolumeRecord rec = (VolumeRecord) msg.obj;
            StorageManagerService.m347$$Nest$mforgetPartition(this.this$0, rec.partGuid, rec.fsUuid);
            return;
        L21:
            StorageManagerService.m377$$Nest$munmount(this.this$0, (ImmutableVolumeInfo) msg.obj);
            return;
        L22:
            StorageManagerService.m314$$Nest$fgetmContext(this.this$0).sendBroadcastAsUser((Intent) msg.obj, UserHandle.ALL, "android.permission.WRITE_MEDIA_STORAGE");
            return;
        L23:
            StorageVolume userVol = (StorageVolume) msg.obj;
            String envState = userVol.getState();
            Slog.d(StorageManagerService.TAG, "Volume " + userVol.getId() + " broadcasting " + envState + " to " + userVol.getOwner());
            String action = VolumeInfo.getBroadcastForEnvironment(envState);
            if (action == null) goto L75;
            Intent intent = new Intent(action, Uri.fromFile(userVol.getPathFile()));
            intent.putExtra("android.os.storage.extra.STORAGE_VOLUME", userVol);
            intent.addFlags(AudioFormat.HE_AAC_V1);
            StorageManagerService.m314$$Nest$fgetmContext(this.this$0).sendBroadcastAsUser(intent, userVol.getOwner());
            return;
        L75:
            return;
        L26:
            WatchedVolumeInfo vol = (WatchedVolumeInfo) msg.obj;
            if (StorageManagerService.m353$$Nest$misMountDisallowed(this.this$0, vol) == false) goto L29;
            Slog.i(StorageManagerService.TAG, "Ignoring mount " + vol.getId() + " due to policy");
            return;
        L29:
            StorageManagerService.m356$$Nest$mmount(this.this$0, vol);
            return;
        L30:
            Slog.i(StorageManagerService.TAG, "Running fstrim idle maintenance");
            StorageManagerService.m334$$Nest$fputmLastMaintenance(this.this$0, System.currentTimeMillis());     // Catch: Exception -> L33
            StorageManagerService.m322$$Nest$fgetmLastMaintenanceFile(this.this$0).setLastModified(StorageManagerService.m321$$Nest$fgetmLastMaintenance(this.this$0));     // Catch: Exception -> L33
        L35:
            this.this$0.fstrim(0, null);
            Runnable callback = (Runnable) msg.obj;
            if (callback == null) goto L79;
            callback.run();
            return;
        L79:
            return;
        L34:
            Slog.e(StorageManagerService.TAG, "Unable to record last fstrim!");
            goto L35
        L38:
            IStorageShutdownObserver obs = (IStorageShutdownObserver) msg.obj;
            boolean success = false;
            StorageManagerService.m331$$Nest$fgetmVold(this.this$0).shutdown();     // Catch: Exception -> L41
            success = true;
        L43:
            if (obs == null) goto L81;
            if (success == true) goto L58;
            r1 = -1;
        L58:
            obs.onShutDownComplete(r1);     // Catch: Exception -> L49
            return;
        L86:
            return;
        L81:
            return;
        L41:
            e = move-exception;
            Slog.wtf(StorageManagerService.TAG, e);
            goto L43
        L51:
            StorageManagerService.m350$$Nest$mhandleDaemonConnected(this.this$0);
            return;
        L52:
            StorageManagerService.m351$$Nest$mhandleSystemReady(this.this$0);
            return;
        L60:
            StorageManagerService.m331$$Nest$fgetmVold(this.this$0).onSecureKeyguardStateChanged(((Boolean) msg.obj).booleanValue());     // Catch: Exception -> L8
            return;
        L8:
            e = move-exception;
            Slog.wtf(StorageManagerService.TAG, e);
            return;
        L83:
            return;
        L11:
            if ((msg.obj instanceof StorageManagerInternal.CloudProviderChangeListener) == false) goto L13;
            StorageManagerInternal.CloudProviderChangeListener listener = (StorageManagerInternal.CloudProviderChangeListener) msg.obj;
            StorageManagerService.m357$$Nest$mnotifyCloudMediaProviderChangedAsync(this.this$0, listener);
            return;
        L13:
            int userId = msg.arg1;
            String authority = (String) msg.obj;
            StorageManagerService.m358$$Nest$monCloudMediaProviderChangedAsync(this.this$0, userId, authority);
        }
    }

    class UnmountObbAction extends ObbAction {
        private final boolean mForceUnmount;
        final /* synthetic */ StorageManagerService this$0;

        UnmountObbAction(StorageManagerService this$0, ObbState obbState, boolean force) {
            this.this$0 = this$0;
            super(obbState);
            this.mForceUnmount = force;
        }

        @Override // com.android.server.StorageManagerService.ObbAction
        public void handleExecute() throws ObbException {
            StorageManagerService.m379$$Nest$mwarnOnNotMounted(this.this$0);
            Map r0 = StorageManagerService.m326$$Nest$fgetmObbMounts(this.this$0);
            monitor-enter(r0);
            ObbState existingState = (ObbState) StorageManagerService.m327$$Nest$fgetmObbPathToStateMap(this.this$0).get(this.mObbState.rawPath);     // Catch: Throwable -> L27
            monitor-exit(r0);     // Catch: Throwable -> L27
            if (existingState == null) goto L26;
            if (existingState.ownerGid == this.mObbState.ownerGid) goto L32;
            notifyObbStateChange(new ObbException(25, "Permission denied to unmount OBB " + existingState.rawPath + " (owned by GID " + existingState.ownerGid + ")"));
            return;
        L32:
            StorageManagerService.m331$$Nest$fgetmVold(this.this$0).unmount(this.mObbState.volId);     // Catch: Exception -> L18
            StorageManagerService.m331$$Nest$fgetmVold(this.this$0).destroyObb(this.mObbState.volId);     // Catch: Exception -> L18
            this.mObbState.volId = null;     // Catch: Exception -> L18
            Map r1 = StorageManagerService.m326$$Nest$fgetmObbMounts(this.this$0);     // Catch: Exception -> L18
            monitor-enter(r1);     // Catch: Exception -> L18
            StorageManagerService.m370$$Nest$mremoveObbStateLocked(this.this$0, existingState);     // Catch: Throwable -> L20
            monitor-exit(r1);     // Catch: Throwable -> L20
        L16:
            notifyObbStateChange(2);     // Catch: Exception -> L18
            return;
        L20:
            th = move-exception;
            throw th;     // Catch: Exception -> L18
        L18:
            e = move-exception;
            throw new ObbException(22, e);
        L26:
            throw new ObbException(23, "Missing existingState");
        L27:
            th = move-exception;
            throw th;
        }

        public String toString() {
            return "UnmountObbAction{" + this.mObbState + ",force=" + this.mForceUnmount + '}';
        }
    }

    private static class WatchedUnlockedUsers {
        private int[] users;

        public WatchedUnlockedUsers() {
            this.users = EmptyArray.INT;
            invalidateIsUserUnlockedCache();
        }

        public void append(int userId) {
            this.users = ArrayUtils.appendInt(this.users, userId);
            invalidateIsUserUnlockedCache();
            StorageManager.invalidateVolumeListCache();
        }

        public void appendAll(int[] userIds) {
            int r0 = userIds.length;
            int r1 = 0;
        L3:
            if (r1 >= r0) goto L5;
            int userId = userIds[r1];
            this.users = ArrayUtils.appendInt(this.users, userId);
            r1 = r1 + 1;
            goto L3
        L5:
            invalidateIsUserUnlockedCache();
            StorageManager.invalidateVolumeListCache();
        }

        public void remove(int userId) {
            this.users = ArrayUtils.removeInt(this.users, userId);
            invalidateIsUserUnlockedCache();
            StorageManager.invalidateVolumeListCache();
        }

        public boolean contains(int userId) {
            return ArrayUtils.contains(this.users, userId);
        }

        public int[] all() {
            return this.users;
        }

        public String toString() {
            return Arrays.toString(this.users);
        }

        private void invalidateIsUserUnlockedCache() {
            UserManager.invalidateIsUserUnlockedCache();
        }
    }

    public static /* synthetic */ void $r8$lambda$3W1bgg_uBq6o73zqwNdqgsQVYZE(StorageManagerService r0) {
        r0.lambda$resetIfBootedAndConnected$0();
    }

    public static /* synthetic */ void $r8$lambda$9KNVwzbDcE0oi0TNlgOBSvnVbsE(StorageManagerService r0, int r1, WatchedVolumeInfo r2) {
        r0.lambda$onVolumeStateChangedLocked$1(r1, r2);
    }

    public static /* synthetic */ void $r8$lambda$JXjmxYc7cquI_I9b1hBqP4R6_WI(StorageManagerService r0) {
        r0.lambda$connectVold$3();
    }

    public static /* synthetic */ void $r8$lambda$hRq6f5rkXMm4O3FcKHexo6kLXiw(StorageManagerService r0) {
        r0.lambda$connectStoraged$2();
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmCallbacks, reason: not valid java name */
    static /* bridge */ /* synthetic */ Callbacks m311$$Nest$fgetmCallbacks(StorageManagerService r0) {
        return r0.mCallbacks;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmCeStorageEventCallbacks, reason: not valid java name */
    static /* bridge */ /* synthetic */ CopyOnWriteArrayList m312$$Nest$fgetmCeStorageEventCallbacks(StorageManagerService r0) {
        return r0.mCeStorageEventCallbacks;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmCeStoragePreparedUsers, reason: not valid java name */
    static /* bridge */ /* synthetic */ Set m313$$Nest$fgetmCeStoragePreparedUsers(StorageManagerService r0) {
        return r0.mCeStoragePreparedUsers;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmContext, reason: not valid java name */
    static /* bridge */ /* synthetic */ Context m314$$Nest$fgetmContext(StorageManagerService r0) {
        return r0.mContext;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmDisks, reason: not valid java name */
    static /* bridge */ /* synthetic */ ArrayMap m315$$Nest$fgetmDisks(StorageManagerService r0) {
        return r0.mDisks;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmFuseMountedUser, reason: not valid java name */
    static /* bridge */ /* synthetic */ Set m316$$Nest$fgetmFuseMountedUser(StorageManagerService r0) {
        return r0.mFuseMountedUser;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmHandler, reason: not valid java name */
    static /* bridge */ /* synthetic */ Handler m317$$Nest$fgetmHandler(StorageManagerService r0) {
        return r0.mHandler;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmIAppOpsService, reason: not valid java name */
    static /* bridge */ /* synthetic */ IAppOpsService m318$$Nest$fgetmIAppOpsService(StorageManagerService r0) {
        return r0.mIAppOpsService;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmIPackageManager, reason: not valid java name */
    static /* bridge */ /* synthetic */ IPackageManager m319$$Nest$fgetmIPackageManager(StorageManagerService r0) {
        return r0.mIPackageManager;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmInstaller, reason: not valid java name */
    static /* bridge */ /* synthetic */ Installer m320$$Nest$fgetmInstaller(StorageManagerService r0) {
        return r0.mInstaller;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmLastMaintenance, reason: not valid java name */
    static /* bridge */ /* synthetic */ long m321$$Nest$fgetmLastMaintenance(StorageManagerService r2) {
        return r2.mLastMaintenance;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmLastMaintenanceFile, reason: not valid java name */
    static /* bridge */ /* synthetic */ File m322$$Nest$fgetmLastMaintenanceFile(StorageManagerService r0) {
        return r0.mLastMaintenanceFile;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmLock, reason: not valid java name */
    static /* bridge */ /* synthetic */ Object m323$$Nest$fgetmLock(StorageManagerService r0) {
        return r0.mLock;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmMediaStoreAuthorityAppId, reason: not valid java name */
    static /* bridge */ /* synthetic */ int m324$$Nest$fgetmMediaStoreAuthorityAppId(StorageManagerService r0) {
        return r0.mMediaStoreAuthorityAppId;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmObbActionHandler, reason: not valid java name */
    static /* bridge */ /* synthetic */ ObbActionHandler m325$$Nest$fgetmObbActionHandler(StorageManagerService r0) {
        return r0.mObbActionHandler;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmObbMounts, reason: not valid java name */
    static /* bridge */ /* synthetic */ Map m326$$Nest$fgetmObbMounts(StorageManagerService r0) {
        return r0.mObbMounts;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmObbPathToStateMap, reason: not valid java name */
    static /* bridge */ /* synthetic */ Map m327$$Nest$fgetmObbPathToStateMap(StorageManagerService r0) {
        return r0.mObbPathToStateMap;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmPmInternal, reason: not valid java name */
    static /* bridge */ /* synthetic */ PackageManagerInternal m328$$Nest$fgetmPmInternal(StorageManagerService r0) {
        return r0.mPmInternal;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmStorageSessionController, reason: not valid java name */
    static /* bridge */ /* synthetic */ StorageSessionController m329$$Nest$fgetmStorageSessionController(StorageManagerService r0) {
        return r0.mStorageSessionController;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmUidsWithLegacyExternalStorage, reason: not valid java name */
    static /* bridge */ /* synthetic */ Set m330$$Nest$fgetmUidsWithLegacyExternalStorage(StorageManagerService r0) {
        return r0.mUidsWithLegacyExternalStorage;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmVold, reason: not valid java name */
    static /* bridge */ /* synthetic */ IVold m331$$Nest$fgetmVold(StorageManagerService r0) {
        return r0.mVold;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmVolumes, reason: not valid java name */
    static /* bridge */ /* synthetic */ WatchedArrayMap m332$$Nest$fgetmVolumes(StorageManagerService r0) {
        return r0.mVolumes;
    }

    /* JADX INFO: renamed from: -$$Nest$fputmCurrentUserId, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m333$$Nest$fputmCurrentUserId(StorageManagerService r0, int r1) {
        r0.mCurrentUserId = r1;
    }

    /* JADX INFO: renamed from: -$$Nest$fputmLastMaintenance, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m334$$Nest$fputmLastMaintenance(StorageManagerService r0, long r1) {
        r0.mLastMaintenance = r1;
    }

    /* JADX INFO: renamed from: -$$Nest$fputmRemountCurrentUserVolumesOnUnlock, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m335$$Nest$fputmRemountCurrentUserVolumesOnUnlock(StorageManagerService r0, boolean r1) {
        r0.mRemountCurrentUserVolumesOnUnlock = r1;
    }

    /* JADX INFO: renamed from: -$$Nest$fputmStoraged, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m336$$Nest$fputmStoraged(StorageManagerService r0, IStoraged r1) {
        r0.mStoraged = r1;
    }

    /* JADX INFO: renamed from: -$$Nest$fputmVold, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m337$$Nest$fputmVold(StorageManagerService r0, IVold r1) {
        r0.mVold = r1;
    }

    /* JADX INFO: renamed from: -$$Nest$maddObbStateLocked, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m338$$Nest$maddObbStateLocked(StorageManagerService r0, ObbState r1) {
        r0.addObbStateLocked(r1);
    }

    /* JADX INFO: renamed from: -$$Nest$mbootCompleted, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m339$$Nest$mbootCompleted(StorageManagerService r0) {
        r0.bootCompleted();
    }

    /* JADX INFO: renamed from: -$$Nest$mcompleteUnlockUser, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m340$$Nest$mcompleteUnlockUser(StorageManagerService r0, int r1) {
        r0.completeUnlockUser(r1);
    }

    /* JADX INFO: renamed from: -$$Nest$mconnectStoraged, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m341$$Nest$mconnectStoraged(StorageManagerService r0) {
        r0.connectStoraged();
    }

    /* JADX INFO: renamed from: -$$Nest$mconnectVold, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m342$$Nest$mconnectVold(StorageManagerService r0) {
        r0.connectVold();
    }

    /* JADX INFO: renamed from: -$$Nest$mdispatchOnFinished, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m343$$Nest$mdispatchOnFinished(StorageManagerService r0, IVoldTaskListener r1, int r2, PersistableBundle r3) {
        r0.dispatchOnFinished(r1, r2, r3);
    }

    /* JADX INFO: renamed from: -$$Nest$mdispatchOnStatus, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m344$$Nest$mdispatchOnStatus(StorageManagerService r0, IVoldTaskListener r1, int r2, PersistableBundle r3) {
        r0.dispatchOnStatus(r1, r2, r3);
    }

    /* JADX INFO: renamed from: -$$Nest$mextendWatchdogTimeout, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m345$$Nest$mextendWatchdogTimeout(StorageManagerService r0, String r1) {
        r0.extendWatchdogTimeout(r1);
    }

    /* JADX INFO: renamed from: -$$Nest$mfindRecordForPath, reason: not valid java name */
    static /* bridge */ /* synthetic */ VolumeRecord m346$$Nest$mfindRecordForPath(StorageManagerService r0, String r1) {
        return r0.findRecordForPath(r1);
    }

    /* JADX INFO: renamed from: -$$Nest$mforgetPartition, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m347$$Nest$mforgetPartition(StorageManagerService r0, String r1, String r2) {
        r0.forgetPartition(r1, r2);
    }

    /* JADX INFO: renamed from: -$$Nest$mgetMountModeInternal, reason: not valid java name */
    static /* bridge */ /* synthetic */ int m348$$Nest$mgetMountModeInternal(StorageManagerService r0, int r1, String r2) {
        return r0.getMountModeInternal(r1, r2);
    }

    /* JADX INFO: renamed from: -$$Nest$mhandleBootCompleted, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m349$$Nest$mhandleBootCompleted(StorageManagerService r0) {
        r0.handleBootCompleted();
    }

    /* JADX INFO: renamed from: -$$Nest$mhandleDaemonConnected, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m350$$Nest$mhandleDaemonConnected(StorageManagerService r0) {
        r0.handleDaemonConnected();
    }

    /* JADX INFO: renamed from: -$$Nest$mhandleSystemReady, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m351$$Nest$mhandleSystemReady(StorageManagerService r0) {
        r0.handleSystemReady();
    }

    /* JADX INFO: renamed from: -$$Nest$misAppIoBlocked, reason: not valid java name */
    static /* bridge */ /* synthetic */ boolean m352$$Nest$misAppIoBlocked(StorageManagerService r0, int r1) {
        return r0.isAppIoBlocked(r1);
    }

    /* JADX INFO: renamed from: -$$Nest$misMountDisallowed, reason: not valid java name */
    static /* bridge */ /* synthetic */ boolean m353$$Nest$misMountDisallowed(StorageManagerService r0, WatchedVolumeInfo r1) {
        return r0.isMountDisallowed(r1);
    }

    /* JADX INFO: renamed from: -$$Nest$misUidOwnerOfPackageOrSystem, reason: not valid java name */
    static /* bridge */ /* synthetic */ boolean m354$$Nest$misUidOwnerOfPackageOrSystem(StorageManagerService r0, String r1, int r2) {
        return r0.isUidOwnerOfPackageOrSystem(r1, r2);
    }

    /* JADX INFO: renamed from: -$$Nest$mmaybeRemountVolumes, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m355$$Nest$mmaybeRemountVolumes(StorageManagerService r0, int r1) {
        r0.maybeRemountVolumes(r1);
    }

    /* JADX INFO: renamed from: -$$Nest$mmount, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m356$$Nest$mmount(StorageManagerService r0, WatchedVolumeInfo r1) {
        r0.mount(r1);
    }

    /* JADX INFO: renamed from: -$$Nest$mnotifyCloudMediaProviderChangedAsync, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m357$$Nest$mnotifyCloudMediaProviderChangedAsync(StorageManagerService r0, StorageManagerInternal.CloudProviderChangeListener r1) {
        r0.notifyCloudMediaProviderChangedAsync(r1);
    }

    /* JADX INFO: renamed from: -$$Nest$monCloudMediaProviderChangedAsync, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m358$$Nest$monCloudMediaProviderChangedAsync(StorageManagerService r0, int r1, String r2) {
        r0.onCloudMediaProviderChangedAsync(r1, r2);
    }

    /* JADX INFO: renamed from: -$$Nest$monDiskScannedLocked, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m359$$Nest$monDiskScannedLocked(StorageManagerService r0, DiskInfo r1) {
        r0.onDiskScannedLocked(r1);
    }

    /* JADX INFO: renamed from: -$$Nest$monMoveStatusLocked, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m360$$Nest$monMoveStatusLocked(StorageManagerService r0, int r1) {
        r0.onMoveStatusLocked(r1);
    }

    /* JADX INFO: renamed from: -$$Nest$monUserStopped, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m361$$Nest$monUserStopped(StorageManagerService r0, int r1) {
        r0.onUserStopped(r1);
    }

    /* JADX INFO: renamed from: -$$Nest$monUserStopping, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m362$$Nest$monUserStopping(StorageManagerService r0, int r1) {
        r0.onUserStopping(r1);
    }

    /* JADX INFO: renamed from: -$$Nest$monUserUnlocking, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m363$$Nest$monUserUnlocking(StorageManagerService r0, int r1) {
        r0.onUserUnlocking(r1);
    }

    /* JADX INFO: renamed from: -$$Nest$monVolumeCreatedLocked, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m364$$Nest$monVolumeCreatedLocked(StorageManagerService r0, WatchedVolumeInfo r1) {
        r0.onVolumeCreatedLocked(r1);
    }

    /* JADX INFO: renamed from: -$$Nest$monVolumeStateChangedAsync, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m365$$Nest$monVolumeStateChangedAsync(StorageManagerService r0, WatchedVolumeInfo r1, int r2, int r3) {
        r0.onVolumeStateChangedAsync(r1, r2, r3);
    }

    /* JADX INFO: renamed from: -$$Nest$monVolumeStateChangedLocked, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m366$$Nest$monVolumeStateChangedLocked(StorageManagerService r0, WatchedVolumeInfo r1, int r2) {
        r0.onVolumeStateChangedLocked(r1, r2);
    }

    /* JADX INFO: renamed from: -$$Nest$mprepareUserStorageForMoveInternal, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m367$$Nest$mprepareUserStorageForMoveInternal(StorageManagerService r0, String r1, String r2, List r3) {
        r0.prepareUserStorageForMoveInternal(r1, r2, r3);
    }

    /* JADX INFO: renamed from: -$$Nest$mrefreshZramSettings, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m368$$Nest$mrefreshZramSettings(StorageManagerService r0) {
        r0.refreshZramSettings();
    }

    /* JADX INFO: renamed from: -$$Nest$mremountVolumesForRunningUsersOnMove, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m369$$Nest$mremountVolumesForRunningUsersOnMove(StorageManagerService r0) {
        r0.remountVolumesForRunningUsersOnMove();
    }

    /* JADX INFO: renamed from: -$$Nest$mremoveObbStateLocked, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m370$$Nest$mremoveObbStateLocked(StorageManagerService r0, ObbState r1) {
        r0.removeObbStateLocked(r1);
    }

    /* JADX INFO: renamed from: -$$Nest$mresetIfBootedAndConnected, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m371$$Nest$mresetIfBootedAndConnected(StorageManagerService r0) {
        r0.resetIfBootedAndConnected();
    }

    /* JADX INFO: renamed from: -$$Nest$mscrubPath, reason: not valid java name */
    static /* bridge */ /* synthetic */ String m372$$Nest$mscrubPath(StorageManagerService r0, String r1) {
        return r0.scrubPath(r1);
    }

    /* JADX INFO: renamed from: -$$Nest$mservicesReady, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m373$$Nest$mservicesReady(StorageManagerService r0) {
        r0.servicesReady();
    }

    /* JADX INFO: renamed from: -$$Nest$msnapshotAndMonitorLegacyStorageAppOp, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m374$$Nest$msnapshotAndMonitorLegacyStorageAppOp(StorageManagerService r0, UserHandle r1) {
        r0.snapshotAndMonitorLegacyStorageAppOp(r1);
    }

    /* JADX INFO: renamed from: -$$Nest$mstart, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m375$$Nest$mstart(StorageManagerService r0) {
        r0.start();
    }

    /* JADX INFO: renamed from: -$$Nest$msystemReady, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m376$$Nest$msystemReady(StorageManagerService r0) {
        r0.systemReady();
    }

    /* JADX INFO: renamed from: -$$Nest$munmount, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m377$$Nest$munmount(StorageManagerService r0, ImmutableVolumeInfo r1) {
        r0.unmount(r1);
    }

    /* JADX INFO: renamed from: -$$Nest$mupdateLegacyStorageApps, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m378$$Nest$mupdateLegacyStorageApps(StorageManagerService r0, String r1, int r2, boolean r3) {
        r0.updateLegacyStorageApps(r1, r2, r3);
    }

    /* JADX INFO: renamed from: -$$Nest$mwarnOnNotMounted, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m379$$Nest$mwarnOnNotMounted(StorageManagerService r0) {
        r0.warnOnNotMounted();
    }

    /* JADX INFO: renamed from: -$$Nest$mwriteSettingsLocked, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m380$$Nest$mwriteSettingsLocked(StorageManagerService r0) {
        r0.writeSettingsLocked();
    }

    /* JADX INFO: renamed from: -$$Nest$sfgetLOCAL_LOGV, reason: not valid java name */
    static /* bridge */ /* synthetic */ boolean m381$$Nest$sfgetLOCAL_LOGV() {
        return LOCAL_LOGV;
    }

    static {
        sSelf = null;
        OBB_FILE_PATH = Pattern.compile("(?i)(^/storage/[^/]+/(?:([0-9]+)/)?Android/obb/)([^/]+)/([^/]+\\.obb)");
        LOCAL_LOGV = Log.isLoggable(TAG, 2);
        sSmartIdleMaintPeriod = 60;
        KNOWN_APP_DIR_PATHS = Pattern.compile("(?i)(^/storage/[^/]+/(?:([0-9]+)/)?Android/(?:data|media|obb|sandbox)/)([^/]+)(/.*)?");
    }

    private WatchedVolumeInfo findVolumeByIdOrThrow(String id) {
        Object r0 = this.mLock;
        monitor-enter(r0);
        WatchedVolumeInfo vol = this.mVolumes.get(id);     // Catch: Throwable -> L8
        if (vol == null) goto L11;
        monitor-exit(r0);     // Catch: Throwable -> L8
        return vol;
    L11:
        monitor-exit(r0);     // Catch: Throwable -> L8
        throw new IllegalArgumentException("No volume found for ID " + id);
    L8:
        th = move-exception;
        throw th;
    }

    private VolumeRecord findRecordForPath(String path) {
        Object r0 = this.mLock;
        monitor-enter(r0);
        int i = 0;
    L23:
    L14:
        th = move-exception;
        throw th;
    L6:
        if (i >= this.mVolumes.size()) goto L18;
        WatchedVolumeInfo vol = this.mVolumes.valueAt(i);     // Catch: Throwable -> L14
        if (vol.getFsPath() == null) goto L16;
        if (path.startsWith(vol.getFsPath()) == false) goto L16;
        VolumeRecord r3 = this.mRecords.get(vol.getFsUuid());     // Catch: Throwable -> L14
        monitor-exit(r0);     // Catch: Throwable -> L14
        return r3;
    L16:
        i = i + 1;     // Catch: Throwable -> L14
        goto L23
    L18:
        monitor-exit(r0);     // Catch: Throwable -> L14
        return null;
    }

    private String scrubPath(String path) {
        if (path.startsWith(Environment.getDataDirectory().getAbsolutePath()) == false) goto L6;
        return "internal";
    L6:
        VolumeRecord rec = findRecordForPath(path);
        if (rec != null) goto L9;
        return "unknown";
    L9:
        if (rec.createdMillis != 0) goto L12;
        return "unknown";
    L12:
        return "ext:" + ((int) ((System.currentTimeMillis() - rec.createdMillis) / UnixCalendar.WEEK_IN_MILLIS)) + "w";
    }

    private VolumeInfo findStorageForUuidAsUser(String volumeUuid, int userId) {
        StorageManager storage = (StorageManager) this.mContext.getSystemService(StorageManager.class);
        if (Objects.equals(StorageManager.UUID_PRIVATE_INTERNAL, volumeUuid) == false) goto L7;
        return storage.findVolumeById("emulated;" + userId);
    L7:
        if (Objects.equals("primary_physical", volumeUuid) == true) goto L9;
        VolumeInfo info = storage.findVolumeByUuid(volumeUuid);
        if (info != null) goto L14;
        Slog.w(TAG, "findStorageForUuidAsUser cannot find volumeUuid:" + volumeUuid);
        return null;
    L14:
        String emulatedUuid = info.getId().replace("private", "emulated") + ";" + userId;
        return storage.findVolumeById(emulatedUuid);
    L9:
        return storage.getPrimaryPhysicalVolume();
    }

    private CountDownLatch findOrCreateDiskScanLatch(String diskId) {
        Object r0 = this.mLock;
        monitor-enter(r0);
        CountDownLatch latch = this.mDiskScanLatches.get(diskId);     // Catch: Throwable -> L7
        if (latch != null) goto L9;
        latch = new CountDownLatch(1);     // Catch: Throwable -> L7
        this.mDiskScanLatches.put(diskId, latch);     // Catch: Throwable -> L7
    L9:
        monitor-exit(r0);     // Catch: Throwable -> L7
        return latch;
    L7:
        th = move-exception;
        throw th;
    }

    private void waitForLatch(CountDownLatch latch, String condition, long timeoutMillis) throws TimeoutException {
        long startMillis = SystemClock.elapsedRealtime();
    L17:
        if (latch.await(5000, TimeUnit.MILLISECONDS) == true) goto L5;
        Slog.w(TAG, "Thread " + Thread.currentThread().getName() + " still waiting for " + condition + "...");     // Catch: InterruptedException -> L8
    L11:
        if (timeoutMillis <= 0) goto L17;
        if (SystemClock.elapsedRealtime() <= (startMillis + timeoutMillis)) goto L17;
        throw new TimeoutException("Thread " + Thread.currentThread().getName() + " gave up waiting for " + condition + " after " + timeoutMillis + "ms");
    L5:
        return;
    L9:
        Slog.w(TAG, "Interrupt while waiting for " + condition);
        goto L11
    }

    private void handleSystemReady() {
        if (prepareSmartIdleMaint() == false) goto L5;
        SmartStorageMaintIdler.scheduleSmartIdlePass(this.mContext, sSmartIdleMaintPeriod);
    L5:
        MountServiceIdler.scheduleIdlePass(this.mContext);
        final Handler r3 = null;
        this.mContext.getContentResolver().registerContentObserver(Settings.Global.getUriFor("zram_enabled"), false, new AnonymousClass2(this, r3));
        refreshZramSettings();
        String zramPropValue = SystemProperties.get(ZRAM_ENABLED_PROPERTY);
        if (zramPropValue.equals("0") == false) goto L8;
    L10:
        configureTranscoding();
        return;
    L8:
        if (this.mContext.getResources().getBoolean(R.bool.kg_sim_puk_account_full_screen) == false) goto L10;
        ZramWriteback.scheduleZramWriteback(this.mContext);
        goto L10
    }

    private void refreshZramSettings() {
        String propertyValue = SystemProperties.get(ZRAM_ENABLED_PROPERTY);
        if ("".equals(propertyValue) == false) goto L6;
        return;
    L6:
        if (Settings.Global.getInt(this.mContext.getContentResolver(), "zram_enabled", 1) == 0) goto L8;
        String desiredPropertyValue = "1";
    L10:
        if (desiredPropertyValue.equals(propertyValue) == true) goto L17;
        SystemProperties.set(ZRAM_ENABLED_PROPERTY, desiredPropertyValue);
        if (desiredPropertyValue.equals("1") == true) goto L14;
        return;
    L14:
        if (this.mContext.getResources().getBoolean(R.bool.kg_sim_puk_account_full_screen) == false) goto L19;
        ZramWriteback.scheduleZramWriteback(this.mContext);
        return;
    L19:
        return;
    L17:
        return;
    L8:
        desiredPropertyValue = "0";
        goto L10
    }

    private boolean isHevcDecoderSupported() {
        MediaCodecList codecList = new MediaCodecList(0);
        MediaCodecInfo[] codecInfos = codecList.getCodecInfos();
        int r3 = codecInfos.length;
        int r4 = 0;
    L3:
        if (r4 >= r3) goto L16;
        MediaCodecInfo codecInfo = codecInfos[r4];
        if (codecInfo.isEncoder() == true) goto L15;
        String[] supportedTypes = codecInfo.getSupportedTypes();
        int r7 = supportedTypes.length;
        int r8 = 0;
    L9:
        if (r8 >= r7) goto L15;
        String type = supportedTypes[r8];
        if (type.equalsIgnoreCase("video/hevc") == true) goto L12;
        r8 = r8 + 1;
        goto L9
    L12:
        return true;
    L15:
        r4 = r4 + 1;
        goto L3
    L16:
        return false;
    }

    private void configureTranscoding() {
        boolean defaultValue = isHevcDecoderSupported();
        if (SystemProperties.getBoolean("persist.sys.fuse.transcode_user_control", false) == false) goto L5;
        boolean transcodeEnabled = SystemProperties.getBoolean("persist.sys.fuse.transcode_enabled", defaultValue);
    L6:
        SystemProperties.set("sys.fuse.transcode_enabled", String.valueOf(transcodeEnabled));
        if (transcodeEnabled == false) goto L10;
        ((ActivityManagerInternal) LocalServices.getService(ActivityManagerInternal.class)).registerAnrController(new ExternalStorageServiceAnrController(this, null));
        return;
    L10:
        return;
    L5:
        transcodeEnabled = DeviceConfig.getBoolean("storage_native_boot", "transcode_enabled", defaultValue);
        goto L6
    }

    private void addInternalVolumeLocked() {
        VolumeInfo internal = new VolumeInfo("private", 1, null, null);
        internal.state = 2;
        internal.path = Environment.getDataDirectory().getAbsolutePath();
        this.mVolumes.put(internal.id, WatchedVolumeInfo.fromVolumeInfo(internal));
    }

    private void resetIfBootedAndConnected() {
        Slog.d(TAG, "Thinking about reset, mBootCompleted=" + this.mBootCompleted + ", mDaemonConnected=" + this.mDaemonConnected);
        if (this.mBootCompleted == true) goto L5;
        return;
    L5:
        if (this.mDaemonConnected == false) goto L38;
        UserManager userManager = (UserManager) this.mContext.getSystemService(UserManager.class);
        List<UserInfo> users = userManager.getUsers();
        extendWatchdogTimeout("#onReset might be slow");
        this.mStorageSessionController.onReset(this.mVold, new StorageManagerService$$ExternalSyntheticLambda1(this));
        Object r2 = this.mLock;
        monitor-enter(r2);
        int[] systemUnlockedUsers = Arrays.copyOf(this.mSystemUnlockedUsers, this.mSystemUnlockedUsers.length);     // Catch: Throwable -> L26
        this.mDisks.clear();     // Catch: Throwable -> L26
        this.mVolumes.clear();     // Catch: Throwable -> L26
        addInternalVolumeLocked();     // Catch: Throwable -> L26
        monitor-exit(r2);     // Catch: Throwable -> L26
        Slog.i(TAG, "Resetting vold...");     // Catch: Exception -> L16
        this.mVold.reset();     // Catch: Exception -> L16
        Slog.i(TAG, "Reset vold");     // Catch: Exception -> L16
        Iterator<UserInfo> r3 = users.iterator();     // Catch: Exception -> L16
    L12:
        if (r3.hasNext() == false) goto L20;
        UserInfo user = r3.next();     // Catch: Exception -> L16
        if (user.isCloneProfile() == false) goto L18;
        this.mVold.onUserAdded(user.id, user.serialNumber, user.profileGroupId);     // Catch: Exception -> L16
        goto L12
    L18:
        this.mVold.onUserAdded(user.id, user.serialNumber, -1);     // Catch: Exception -> L16
        goto L12
    L20:
        int r4 = systemUnlockedUsers.length;     // Catch: Exception -> L16
        int r5 = 0;
    L21:
        if (r5 >= r4) goto L23;
        int userId = systemUnlockedUsers[r5];     // Catch: Exception -> L16
        this.mVold.onUserStarted(userId);     // Catch: Exception -> L16
        this.mStoraged.onUserStarted(userId);     // Catch: Exception -> L16
        r5 = r5 + 1;     // Catch: Exception -> L16
        goto L21
    L23:
        restoreSystemUnlockedUsers(userManager, users, systemUnlockedUsers);     // Catch: Exception -> L16
        this.mVold.onSecureKeyguardStateChanged(this.mSecureKeyguardShowing);     // Catch: Exception -> L16
        this.mStorageManagerInternal.onReset(this.mVold);     // Catch: Exception -> L16
        return;
    L16:
        e = move-exception;
        Slog.wtf(TAG, e);
        return;
    L26:
        th = move-exception;
        throw th;
    }

    private /* synthetic */ void lambda$resetIfBootedAndConnected$0() {
        this.mHandler.removeCallbacksAndMessages(null);
    }

    private void restoreSystemUnlockedUsers(UserManager userManager, List<UserInfo> allUsers, int[] systemUnlockedUsers) throws Exception {
        Arrays.sort(systemUnlockedUsers);
        UserManager.invalidateIsUserUnlockedCache();
        Iterator<UserInfo> r0 = allUsers.iterator();
    L4:
        if (r0.hasNext() == false) goto L15;
        UserInfo user = r0.next();
        int userId = user.id;
        if (userManager.isUserRunning(userId) == false) goto L4;
        if (Arrays.binarySearch(systemUnlockedUsers, userId) >= 0) goto L4;
        boolean unlockingOrUnlocked = userManager.isUserUnlockingOrUnlocked(userId);
        if (unlockingOrUnlocked == false) goto L4;
        Slog.w(TAG, "UNLOCK_USER lost from vold reset, will retry, user:" + userId);
        this.mVold.onUserStarted(userId);
        this.mStoraged.onUserStarted(userId);
        this.mHandler.obtainMessage(14, userId, 0).sendToTarget();
        goto L4
    }

    private void restoreCeUnlockedUsers() {
        int[] userIds = this.mVold.getUnlockedUsers();     // Catch: Exception -> L14
        if (ArrayUtils.isEmpty(userIds) == true) goto L13;
        Slog.d(TAG, "CE storage for users " + Arrays.toString(userIds) + " is already unlocked");
        Object r1 = this.mLock;
        monitor-enter(r1);
        this.mCeUnlockedUsers.appendAll(userIds);     // Catch: Throwable -> L10
        monitor-exit(r1);     // Catch: Throwable -> L10
        return;
    L10:
        th = move-exception;
        throw th;
    L13:
        return;
    L14:
        e = move-exception;
        Slog.e(TAG, "Failed to get unlocked users from vold", e);
    }

    private void onUserUnlocking(int userId) {
        Slog.d(TAG, "onUserUnlocking " + userId);
        Trace.instant(524288, "SMS.onUserUnlocking: " + userId);
        if (userId != 0) goto L26;
    L24:
        this.mStorageSessionController.onUnlockUser(userId);     // Catch: Exception -> L16
        this.mVold.onUserStarted(userId);     // Catch: Exception -> L16
        this.mStoraged.onUserStarted(userId);     // Catch: Exception -> L16
    L18:
        this.mHandler.obtainMessage(14, userId, 0).sendToTarget();
        if (this.mRemountCurrentUserVolumesOnUnlock == true) goto L21;
        return;
    L21:
        if (userId != this.mCurrentUserId) goto L29;
        maybeRemountVolumes(userId);
        this.mRemountCurrentUserVolumesOnUnlock = false;
        return;
    L29:
        return;
    L16:
        e = move-exception;
        Slog.wtf(TAG, e);
        goto L18
    L26:
        Context userContext = this.mContext.createPackageContextAsUser("system", 0, UserHandle.of(userId));     // Catch: PackageManager.NameNotFoundException -> L10
        UserManager um = (UserManager) userContext.getSystemService(UserManager.class);     // Catch: PackageManager.NameNotFoundException -> L10
        if (um == null) goto L24;
        if (um.isMediaSharedWithParent() == false) goto L24;
        int parentUserId = um.getProfileParent(userId).id;     // Catch: PackageManager.NameNotFoundException -> L10
        this.mUserSharesMediaWith.put(userId, parentUserId);     // Catch: PackageManager.NameNotFoundException -> L10
        this.mUserSharesMediaWith.put(parentUserId, userId);     // Catch: PackageManager.NameNotFoundException -> L10
    L13:
        Log.e(TAG, "Failed to create user context for user " + userId);
        goto L24
    }

    private void completeUnlockUser(int userId) {
        onKeyguardStateChanged(false);
        Object r1 = this.mLock;
        monitor-enter(r1);
        int[] r2 = this.mSystemUnlockedUsers;     // Catch: Throwable -> L11
        int r3 = r2.length;     // Catch: Throwable -> L11
        int r4 = 0;
    L5:
        if (r4 >= r3) goto L14;
        int unlockedUser = r2[r4];     // Catch: Throwable -> L11
        if (unlockedUser == userId) goto L8;
        r4 = r4 + 1;     // Catch: Throwable -> L11
        goto L5
    L8:
        Log.i(TAG, "completeUnlockUser called for already unlocked user:" + userId);     // Catch: Throwable -> L11
        monitor-exit(r1);     // Catch: Throwable -> L11
        return;
    L14:
        int i = 0;
    L16:
        if (i >= this.mVolumes.size()) goto L23;
        WatchedVolumeInfo vol = this.mVolumes.valueAt(i);     // Catch: Throwable -> L11
        if (vol.isVisibleForUser(userId) == false) goto L22;
        if (vol.isMountedReadable() == false) goto L22;
        StorageVolume userVol = vol.buildStorageVolume(this.mContext, userId, false);     // Catch: Throwable -> L11
        this.mHandler.obtainMessage(6, userVol).sendToTarget();     // Catch: Throwable -> L11
        String envState = VolumeInfo.getEnvironmentForState(vol.getState());     // Catch: Throwable -> L11
        Callbacks.m385$$Nest$mnotifyStorageStateChanged(this.mCallbacks, userVol.getPath(), envState, envState);     // Catch: Throwable -> L11
    L22:
        i = i + 1;     // Catch: Throwable -> L11
        goto L16
    L23:
        this.mSystemUnlockedUsers = ArrayUtils.appendInt(this.mSystemUnlockedUsers, userId);     // Catch: Throwable -> L11
        monitor-exit(r1);     // Catch: Throwable -> L11
        StorageManager.invalidateVolumeListCache();
        return;
    L11:
        th = move-exception;
        throw th;
    }

    private void extendWatchdogTimeout(String reason) {
        Watchdog w = Watchdog.getInstance();
        w.pauseWatchingMonitorsFor(30000, reason);
        w.pauseWatchingCurrentThreadFor(30000, reason);
    }

    private void onUserStopped(int userId) {
        Slog.d(TAG, "onUserStopped " + userId);
        extendWatchdogTimeout("#onUserStopped might be slow");
        this.mVold.onUserStopped(userId);     // Catch: Exception -> L5
        this.mStoraged.onUserStopped(userId);     // Catch: Exception -> L5
    L7:
        Object r0 = this.mLock;
        monitor-enter(r0);
        this.mSystemUnlockedUsers = ArrayUtils.removeInt(this.mSystemUnlockedUsers, userId);     // Catch: Throwable -> L12
        monitor-exit(r0);     // Catch: Throwable -> L12
        return;
    L12:
        th = move-exception;
        throw th;
    L5:
        e = move-exception;
        Slog.wtf(TAG, e);
        goto L7
    }

    private void onUserStopping(int userId) {
        Slog.i(TAG, "onUserStopping " + userId);
        this.mStorageSessionController.onUserStopping(userId);     // Catch: Exception -> L5
    L7:
        PackageMonitor monitor = (PackageMonitor) this.mPackageMonitorsForUser.removeReturnOld(userId);
        if (monitor == null) goto L13;
        monitor.unregister();
        return;
    L13:
        return;
    L5:
        e = move-exception;
        Slog.wtf(TAG, e);
        goto L7
    }

    private void maybeRemountVolumes(int userId) {
        List<ImmutableVolumeInfo> volumesToUnmount = new ArrayList();
        List<WatchedVolumeInfo> volumesToMount = new ArrayList();
        Object r2 = this.mLock;
        monitor-enter(r2);
        int i = 0;
    L29:
    L16:
        th = move-exception;
        throw th;
    L6:
        if (i >= this.mVolumes.size()) goto L20;
        WatchedVolumeInfo vol = this.mVolumes.valueAt(i);     // Catch: Throwable -> L16
        if (vol.isPrimary() == true) goto L18;
        if (vol.isMountedWritable() == false) goto L18;
        if (vol.isVisible() == false) goto L18;
        if (vol.getMountUserId() == this.mCurrentUserId) goto L18;
        volumesToUnmount.add(vol.getClonedImmutableVolumeInfo());     // Catch: Throwable -> L16
        vol.setMountUserId(this.mCurrentUserId);     // Catch: Throwable -> L16
        volumesToMount.add(vol);     // Catch: Throwable -> L16
    L18:
        i = i + 1;     // Catch: Throwable -> L16
        goto L29
    L20:
        monitor-exit(r2);     // Catch: Throwable -> L16
        int i2 = 0;
    L23:
        if (i2 >= volumesToMount.size()) goto L26;
        Slog.i(TAG, "Remounting volume for user: " + userId + ". Volume: " + volumesToUnmount.get(i2));
        this.mHandler.obtainMessage(8, volumesToUnmount.get(i2)).sendToTarget();
        this.mHandler.obtainMessage(5, volumesToMount.get(i2)).sendToTarget();
        i2 = i2 + 1;
        goto L23
    }

    private void updateVolumeMountIdIfRequired(WatchedVolumeInfo vol) {
        Object r0 = this.mLock;
        monitor-enter(r0);
    L11:
        th = move-exception;
        throw th;
    L5:
        if (vol.isPrimary() == false) goto L7;
    L13:
        monitor-exit(r0);     // Catch: Throwable -> L11
        return;
    L7:
        if (vol.isVisible() == false) goto L13;
        if (vol.getMountUserId() == this.mCurrentUserId) goto L13;
        vol.setMountUserId(this.mCurrentUserId);     // Catch: Throwable -> L11
        goto L13
    }

    private void remountVolumesForRunningUsersOnMove() {
        List<Integer> unlockedUsers = new ArrayList();
        Object r1 = this.mLock;
        monitor-enter(r1);
        int[] r2 = this.mSystemUnlockedUsers;     // Catch: Throwable -> L11
        int r3 = r2.length;     // Catch: Throwable -> L11
        int r4 = 0;
    L5:
        if (r4 >= r3) goto L13;
        int userId = r2[r4];     // Catch: Throwable -> L11
        if (userId == this.mCurrentUserId) goto L10;
        unlockedUsers.add(Integer.valueOf(userId));     // Catch: Throwable -> L11
    L10:
        r4 = r4 + 1;     // Catch: Throwable -> L11
        goto L5
    L13:
        monitor-exit(r1);     // Catch: Throwable -> L11
        extendWatchdogTimeout("#onUserStopped might be slow");
        Iterator<Integer> r5 = unlockedUsers.iterator();
    L16:
        if (r5.hasNext() == false) goto L23;
        Integer userId2 = r5.next();
        this.mVold.onUserStopped(userId2.intValue());     // Catch: Exception -> L20
        this.mStoraged.onUserStopped(userId2.intValue());     // Catch: Exception -> L20
    L20:
        e = move-exception;
        Slog.wtf(TAG, e);
        goto L16
    L23:
        Iterator<Integer> r6 = unlockedUsers.iterator();
    L25:
        if (r6.hasNext() == false) goto L32;
        Integer userId3 = r6.next();
        this.mVold.onUserStarted(userId3.intValue());     // Catch: Exception -> L29
        this.mStoraged.onUserStarted(userId3.intValue());     // Catch: Exception -> L29
    L29:
        e = move-exception;
        Slog.wtf(TAG, e);
        goto L25
    L32:
        return;
    L11:
        th = move-exception;
        throw th;
    }

    private boolean supportsBlockCheckpoint() throws RemoteException {
        enforcePermission("android.permission.MOUNT_FORMAT_FILESYSTEMS");
        return this.mVold.supportsBlockCheckpoint();
    }

    private void prepareUserStorageForMoveInternal(String fromVolumeUuid, String toVolumeUuid, List<UserInfo> users) throws Exception {
        Iterator<UserInfo> r1 = users.iterator();
    L4:
        if (r1.hasNext() == false) goto L6;
        UserInfo user = r1.next();
        prepareUserStorageInternal(fromVolumeUuid, user.id, 3);
        prepareUserStorageInternal(toVolumeUuid, user.id, 3);
        goto L4
    }

    @Override // com.android.server.wm.ActivityTaskManagerInternal.ScreenObserver
    public void onAwakeStateChanged(boolean isAwake) {
    }

    @Override // com.android.server.wm.ActivityTaskManagerInternal.ScreenObserver
    public void onKeyguardStateChanged(boolean isShowing) {
        if (isShowing == true) goto L4;
    L6:
        boolean isSecureKeyguardShowing = false;
    L8:
        if (this.mSecureKeyguardShowing == isSecureKeyguardShowing) goto L11;
        this.mSecureKeyguardShowing = isSecureKeyguardShowing;
        this.mHandler.obtainMessage(17, Boolean.valueOf(this.mSecureKeyguardShowing)).sendToTarget();
        return;
    L11:
        return;
    L4:
        if (((KeyguardManager) this.mContext.getSystemService(KeyguardManager.class)).isDeviceSecure(this.mCurrentUserId) == false) goto L6;
        isSecureKeyguardShowing = true;
        goto L8
    }

    void runIdleMaintenance(Runnable callback) {
        this.mHandler.sendMessage(this.mHandler.obtainMessage(4, callback));
    }

    public void runMaintenance() {
        super.runMaintenance_enforcePermission();
        runIdleMaintenance(null);
    }

    public long lastMaintenance() {
        return this.mLastMaintenance;
    }

    public void onDaemonConnected() {
        this.mDaemonConnected = true;
        this.mHandler.obtainMessage(2).sendToTarget();
    }

    private void handleDaemonConnected() {
        resetIfBootedAndConnected();
    }

    private void onDiskScannedLocked(DiskInfo disk) {
        int volumeCount = 0;
        int i = 0;
    L4:
        if (i >= this.mVolumes.size()) goto L9;
        WatchedVolumeInfo vol = this.mVolumes.valueAt(i);
        if (Objects.equals(disk.id, vol.getDiskId()) == false) goto L8;
        volumeCount = volumeCount + 1;
    L8:
        i = i + 1;
        goto L4
    L9:
        Intent intent = new Intent("android.os.storage.action.DISK_SCANNED");
        intent.addFlags(AudioFormat.HE_AAC_V1);
        intent.putExtra("android.os.storage.extra.DISK_ID", disk.id);
        intent.putExtra("android.os.storage.extra.VOLUME_COUNT", volumeCount);
        this.mHandler.obtainMessage(7, intent).sendToTarget();
        CountDownLatch latch = this.mDiskScanLatches.remove(disk.id);
        if (latch == null) goto L12;
        latch.countDown();
    L12:
        disk.volumeCount = volumeCount;
        Callbacks.m384$$Nest$mnotifyDiskScanned(this.mCallbacks, disk, volumeCount);
    }

    private void onVolumeCreatedLocked(WatchedVolumeInfo vol) {
        ActivityManagerInternal amInternal = (ActivityManagerInternal) LocalServices.getService(ActivityManagerInternal.class);
        boolean isMediaSharedWithParent = false;
        if (vol.getMountUserId() < 0) goto L9;
        if (amInternal.isUserRunning(vol.getMountUserId(), 0) == true) goto L9;
        Slog.d(TAG, "Ignoring volume " + vol.getId() + " because user " + Integer.toString(vol.getMountUserId()) + " is no longer running.");
        return;
    L9:
        if (vol.getType() != 2) goto L29;
        Context volumeUserContext = this.mContext.createContextAsUser(UserHandle.of(vol.getMountUserId()), 0);
        if (volumeUserContext == null) goto L15;
        isMediaSharedWithParent = ((UserManager) volumeUserContext.getSystemService(UserManager.class)).isMediaSharedWithParent();
    L15:
        if (isMediaSharedWithParent == false) goto L17;
    L20:
        StorageManager storage = (StorageManager) this.mContext.getSystemService(StorageManager.class);
        VolumeInfo privateVol = storage.findPrivateForEmulated(vol.getVolumeInfo());
        if (Objects.equals(StorageManager.UUID_PRIVATE_INTERNAL, this.mPrimaryStorageUuid) == false) goto L25;
        if ("private".equals(privateVol.id) == false) goto L25;
    L26:
        Slog.v(TAG, "Found primary storage at " + vol);
        vol.setMountFlags(vol.getMountFlags() | 1);
        vol.setMountFlags(vol.getMountFlags() | 4);
        this.mHandler.obtainMessage(5, vol).sendToTarget();
        return;
    L25:
        if (Objects.equals(privateVol.getFsUuid(), this.mPrimaryStorageUuid) == true) goto L26;
        return;
    L17:
        if (this.mStorageSessionController.supportsExternalStorage(vol.getMountUserId()) == true) goto L20;
        Slog.d(TAG, "Ignoring volume " + vol.getId() + " because user " + Integer.toString(vol.getMountUserId()) + " does not support external storage.");
        return;
    L29:
        if (vol.getType() != 0) goto L42;
        if (Objects.equals("primary_physical", this.mPrimaryStorageUuid) == false) goto L36;
        if (vol.getDisk().isDefaultPrimary() == false) goto L36;
        Slog.v(TAG, "Found primary storage at " + vol);
        vol.setMountFlags(vol.getMountFlags() | 1);
        vol.setMountFlags(vol.getMountFlags() | 4);
    L36:
        if (vol.getDisk().isAdoptable() == false) goto L38;
    L39:
        vol.setMountFlags(vol.getMountFlags() | 4);
    L40:
        vol.setMountUserId(this.mCurrentUserId);
        this.mHandler.obtainMessage(5, vol).sendToTarget();
        return;
    L38:
        if (vol.getDisk().isUsb() == false) goto L40;
    L42:
        if (vol.getType() != 1) goto L45;
        this.mHandler.obtainMessage(5, vol).sendToTarget();
        return;
    L45:
        if (vol.getType() == 5) goto L47;
        Slog.d(TAG, "Skipping automatic mounting of " + vol);
        return;
    L47:
        if (vol.getDisk().isStubVisible() == false) goto L49;
        vol.setMountFlags(vol.getMountFlags() | 4);
    L50:
        vol.setMountUserId(this.mCurrentUserId);
        this.mHandler.obtainMessage(5, vol).sendToTarget();
        return;
    L49:
        vol.setMountFlags(vol.getMountFlags() | 2);
        goto L50
    }

    private boolean isBroadcastWorthy(WatchedVolumeInfo vol) {
        switch(vol.getType()) {
            case 0: goto L6;
            case 1: goto L6;
            case 2: goto L6;
            case 3: goto L4;
            case 4: goto L4;
            case 5: goto L6;
            default: goto L4;
        };
    L4:
        return false;
    L6:
        switch(vol.getState()) {
            case 0: goto L8;
            case 1: goto L7;
            case 2: goto L8;
            case 3: goto L8;
            case 4: goto L7;
            case 5: goto L8;
            case 6: goto L8;
            case 7: goto L7;
            case 8: goto L8;
            default: goto L7;
        };
    L7:
        return false;
    L8:
        return true;
    }

    private void onVolumeStateChangedLocked(final WatchedVolumeInfo vol, int newState) {
        if (vol.getType() != 2) goto L10;
        if (newState == 2) goto L7;
        this.mFuseMountedUser.remove(Integer.valueOf(vol.getMountUserId()));
        return;
    L7:
        if (this.mVoldAppDataIsolationEnabled == false) goto L12;
        final int userId = vol.getMountUserId();
        new Thread(new StorageManagerService$$ExternalSyntheticLambda2(this, userId, vol)).start();
        return;
    L12:
        return;
    }

    private /* synthetic */ void lambda$onVolumeStateChangedLocked$1(int userId, WatchedVolumeInfo vol) {
        if (userId == 0) goto L4;
    L6:
        Object r0 = this.mLock;
        monitor-enter(r0);
        this.mFuseMountedUser.add(Integer.valueOf(userId));     // Catch: Throwable -> L21
        monitor-exit(r0);     // Catch: Throwable -> L21
        Map<Integer, String> pidPkgMap = null;
        int i = 0;
    L12:
        if (i >= 5) goto L17;
        pidPkgMap = ((ActivityManagerInternal) LocalServices.getService(ActivityManagerInternal.class)).getProcessesWithPendingBindMounts(vol.getMountUserId());     // Catch: IllegalStateException -> L15
    L16:
        Slog.i(TAG, "Some processes are starting, retry");
        SystemClock.sleep(100);
        i = i + 1;
    L17:
        if (pidPkgMap == null) goto L19;
        remountAppStorageDirs(pidPkgMap, userId);
        return;
    L19:
        Slog.wtf(TAG, "Not able to getStorageNotOptimizedProcesses() after 5 retries");
        return;
    L21:
        th = move-exception;
        throw th;
    L4:
        if (Build.VERSION.DEVICE_INITIAL_SDK_INT >= 29) goto L6;
        this.mPmInternal.migrateLegacyObbData();
        goto L6
    }

    private void onVolumeStateChangedAsync(WatchedVolumeInfo vol, int oldState, int newState) {
        if (newState == 2) goto L70;
    L12:
        Object r1 = this.mLock;
        monitor-enter(r1);
    L21:
        th = move-exception;
        throw th;
    L15:
        if (TextUtils.isEmpty(vol.getFsUuid()) == true) goto L28;
        VolumeRecord rec = this.mRecords.get(vol.getFsUuid());     // Catch: Throwable -> L21
        if (rec != null) goto L25;
        rec = new VolumeRecord(vol.getType(), vol.getFsUuid());     // Catch: Throwable -> L21
        rec.partGuid = vol.getPartGuid();     // Catch: Throwable -> L21
        rec.createdMillis = System.currentTimeMillis();     // Catch: Throwable -> L21
        if (vol.getType() != 1) goto L23;
        rec.nickname = vol.getDisk().getDescription();     // Catch: Throwable -> L21
    L23:
        this.mRecords.put(rec.fsUuid, rec);     // Catch: Throwable -> L21
    L27:
        rec.lastSeenMillis = System.currentTimeMillis();     // Catch: Throwable -> L21
        writeSettingsLocked();     // Catch: Throwable -> L21
        goto L28
    L25:
        if (TextUtils.isEmpty(rec.partGuid) == false) goto L27;
        rec.partGuid = vol.getPartGuid();     // Catch: Throwable -> L21
    L28:
        monitor-exit(r1);     // Catch: Throwable -> L21
        this.mStorageSessionController.notifyVolumeStateChanged(vol.getImmutableVolumeInfo());     // Catch: StorageSessionController.ExternalStorageServiceException -> L31
    L33:
        Object r2 = this.mLock;
        monitor-enter(r2);
        Callbacks.m388$$Nest$mnotifyVolumeStateChanged(this.mCallbacks, vol, oldState, newState);     // Catch: Throwable -> L40
        if (this.mBootCompleted == true) goto L38;
    L42:
        String oldStateEnv = VolumeInfo.getEnvironmentForState(oldState);     // Catch: Throwable -> L40
        String newStateEnv = VolumeInfo.getEnvironmentForState(newState);     // Catch: Throwable -> L40
        if (Objects.equals(oldStateEnv, newStateEnv) == true) goto L51;
        int[] r4 = this.mSystemUnlockedUsers;     // Catch: Throwable -> L40
        int r5 = r4.length;     // Catch: Throwable -> L40
        int r7 = 0;
    L45:
        if (r7 >= r5) goto L51;
        int userId = r4[r7];     // Catch: Throwable -> L40
        if (vol.isVisibleForUser(userId) == false) goto L49;
        StorageVolume userVol = vol.buildStorageVolume(this.mContext, userId, false);     // Catch: Throwable -> L40
        this.mHandler.obtainMessage(6, userVol).sendToTarget();     // Catch: Throwable -> L40
        Callbacks.m385$$Nest$mnotifyStorageStateChanged(this.mCallbacks, userVol.getPath(), oldStateEnv, newStateEnv);     // Catch: Throwable -> L40
    L49:
        r7 = r7 + 1;     // Catch: Throwable -> L40
    L51:
        if (vol.getType() == 0) goto L55;
        if (vol.getType() == 5) goto L55;
    L57:
        maybeLogMediaMount(vol, newState);     // Catch: Throwable -> L40
        monitor-exit(r2);     // Catch: Throwable -> L40
        return;
    L55:
        if (vol.getState() != 5) goto L57;
        this.mObbActionHandler.sendMessage(this.mObbActionHandler.obtainMessage(2, vol.getFsPath()));     // Catch: Throwable -> L40
        goto L57
    L38:
        if (isBroadcastWorthy(vol) == false) goto L42;
        Intent intent = new Intent("android.os.storage.action.VOLUME_STATE_CHANGED");     // Catch: Throwable -> L40
        intent.putExtra("android.os.storage.extra.VOLUME_ID", vol.getId());     // Catch: Throwable -> L40
        intent.putExtra("android.os.storage.extra.VOLUME_STATE", newState);     // Catch: Throwable -> L40
        intent.putExtra("android.os.storage.extra.FS_UUID", vol.getFsUuid());     // Catch: Throwable -> L40
        intent.addFlags(AudioFormat.HE_AAC_V1);     // Catch: Throwable -> L40
        this.mHandler.obtainMessage(7, intent).sendToTarget();     // Catch: Throwable -> L40
    L40:
        th = move-exception;
        throw th;
    L31:
        e = move-exception;
        Log.e(TAG, "Failed to notify volume state changed to the Storage Service", e);
        goto L33
    L70:
        prepareUserStorageIfNeeded(vol);     // Catch: Exception -> L6
    L72:
        this.mVold.unmount(vol.getId());     // Catch: Exception -> L9
        return;
    L9:
        ee = move-exception;
        Slog.wtf(TAG, ee);
    }

    private void notifyCloudMediaProviderChangedAsync(StorageManagerInternal.CloudProviderChangeListener listener) {
        SparseArray<String> r0 = this.mCloudMediaProviders;
        monitor-enter(r0);
        int i = this.mCloudMediaProviders.size() - 1;     // Catch: Throwable -> L7
    L5:
        if (i < 0) goto L10;
        int userId = this.mCloudMediaProviders.keyAt(i);     // Catch: Throwable -> L7
        String authority = this.mCloudMediaProviders.valueAt(i);     // Catch: Throwable -> L7
        listener.onCloudProviderChanged(userId, authority);     // Catch: Throwable -> L7
        i = i - 1;     // Catch: Throwable -> L7
        goto L5
    L10:
        monitor-exit(r0);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    private void onCloudMediaProviderChangedAsync(int userId, String authority) {
        Iterator r0 = StorageManagerInternalImpl.m389$$Nest$fgetmCloudProviderChangeListeners(this.mStorageManagerInternal).iterator();
    L4:
        if (r0.hasNext() == false) goto L6;
        StorageManagerInternal.CloudProviderChangeListener listener = (StorageManagerInternal.CloudProviderChangeListener) r0.next();
        listener.onCloudProviderChanged(userId, authority);
        goto L4
    }

    private void maybeLogMediaMount(WatchedVolumeInfo vol, int newState) {
        if (SecurityLog.isLoggingEnabled() == true) goto L5;
        return;
    L5:
        DiskInfo disk = vol.getDisk();
        if (disk != null) goto L8;
        return;
    L8:
        if ((disk.flags & 12) != 0) goto L11;
        return;
    L11:
        if (disk.label == null) goto L13;
        String label = disk.label.trim();
    L15:
        if (newState != 2) goto L17;
    L23:
        SecurityLog.writeEvent(210013, new Object[]{vol.getFsPath(), label});
        return;
    L17:
        if (newState == 3) goto L23;
        if (newState != 0) goto L21;
    L22:
        SecurityLog.writeEvent(210014, new Object[]{vol.getFsPath(), label});
        return;
    L21:
        if (newState == 8) goto L22;
        return;
    L13:
        label = "";
        goto L15
    }

    private void onMoveStatusLocked(int status) {
        if (this.mMoveCallback != null) goto L16;
        Slog.w(TAG, "Odd, status but no move requested");
        return;
    L16:
        this.mMoveCallback.onStatusChanged(-1, status, -1);     // Catch: RemoteException -> L8
    L10:
        if (status != 82) goto L13;
        Slog.d(TAG, "Move to " + this.mMoveTargetUuid + " copy phase finshed; persisting");
        this.mPrimaryStorageUuid = this.mMoveTargetUuid;
        writeSettingsLocked();
        this.mHandler.obtainMessage(18).sendToTarget();
    L13:
        if (PackageManager.isMoveStatusFinished(status) == false) goto L18;
        Slog.d(TAG, "Move to " + this.mMoveTargetUuid + " finished with status " + status);
        this.mMoveCallback = null;
        this.mMoveTargetUuid = null;
        return;
    }

    private void enforcePermission(String perm) {
        this.mContext.enforceCallingOrSelfPermission(perm, perm);
    }

    private boolean isMountDisallowed(WatchedVolumeInfo vol) {
        UserManager userManager = (UserManager) this.mContext.getSystemService(UserManager.class);
        boolean isUsbRestricted = false;
        if (vol.getDisk() != null) goto L5;
    L7:
        boolean isTypeRestricted = false;
        if (vol.getType() != 0) goto L10;
    L14:
        isTypeRestricted = userManager.hasUserRestriction("no_physical_media", Binder.getCallingUserHandle());
    L15:
        if (isUsbRestricted == true) goto L20;
        if (isTypeRestricted == true) goto L21;
        return false;
    L21:
        return true;
    L20:
        return true;
    L10:
        if (vol.getType() == 1) goto L14;
        if (vol.getType() != 5) goto L15;
    L5:
        if (vol.getDisk().isUsb() == false) goto L7;
        isUsbRestricted = userManager.hasUserRestriction("no_usb_file_transfer", Binder.getCallingUserHandle());
        goto L7
    }

    private void enforceAdminUser() {
        UserManager um = (UserManager) this.mContext.getSystemService("user");
        int callingUserId = UserHandle.getCallingUserId();
        long token = Binder.clearCallingIdentity();
        boolean isAdmin = um.getUserInfo(callingUserId).isAdmin();     // Catch: Throwable -> L9
        Binder.restoreCallingIdentity(token);
        if (isAdmin == false) goto L8;
        return;
    L8:
        throw new SecurityException("Only admin users can adopt sd cards");
    L9:
        th = move-exception;
        Binder.restoreCallingIdentity(token);
        throw th;
    }

    public StorageManagerService(Context context) {
        this.mFuseMountedUser = new ArraySet();
        this.mCeStoragePreparedUsers = new ArraySet();
        this.mInternalStorageSize = 0;
        this.mNeedGC = true;
        this.mLock = LockGuard.installNewLock(4);
        this.mCeUnlockedUsers = new WatchedUnlockedUsers();
        this.mSystemUnlockedUsers = EmptyArray.INT;
        this.mDisks = new ArrayMap();
        this.mVolumes = new WatchedArrayMap();
        this.mRecords = new ArrayMap();
        this.mDiskScanLatches = new ArrayMap();
        this.mCloudMediaProviders = new SparseArray();
        this.mMediaStoreAuthorityAppId = -1;
        this.mDownloadsAuthorityAppId = -1;
        this.mExternalStorageAuthorityAppId = -1;
        this.mCurrentUserId = 0;
        this.mRemountCurrentUserVolumesOnUnlock = false;
        this.mAppFuseLock = new Object();
        this.mNextAppFuseName = 0;
        this.mAppFuseBridge = null;
        this.mUserSharesMediaWith = new SparseIntArray();
        this.mBootCompleted = false;
        this.mDaemonConnected = false;
        this.mSecureKeyguardShowing = true;
        this.mObbMounts = new HashMap();
        this.mObbPathToStateMap = new HashMap();
        this.mStorageManagerInternal = new StorageManagerInternalImpl(this, null);
        this.mUidsWithLegacyExternalStorage = new ArraySet();
        this.mPackageMonitorsForUser = new SparseArray();
        this.mCeStorageEventCallbacks = new CopyOnWriteArrayList();
        this.mUserReceiver = new AnonymousClass1(this);
        this.mListener = new AnonymousClass3(this);
        sSelf = this;
        this.mVoldAppDataIsolationEnabled = SystemProperties.getBoolean(ANDROID_VOLD_APP_DATA_ISOLATION_ENABLED_PROPERTY, false);
        this.mContext = context;
        this.mCallbacks = new Callbacks(FgThread.get().getLooper());
        this.mVolumes.registerObserver(new AnonymousClass4(this));
        HandlerThread hthread = new HandlerThread(TAG);
        hthread.start();
        this.mHandler = new StorageManagerServiceHandler(this, hthread.getLooper());
        this.mObbActionHandler = new ObbActionHandler(this, IoThread.get().getLooper());
        this.mStorageSessionController = new StorageSessionController(this.mContext);
        this.mInstaller = new Installer(this.mContext);
        this.mInstaller.onStart();
        File dataDir = Environment.getDataDirectory();
        File systemDir = new File(dataDir, "system");
        this.mLastMaintenanceFile = new File(systemDir, LAST_FSTRIM_FILE);
        if (this.mLastMaintenanceFile.exists() == false) goto L33;
        this.mLastMaintenance = this.mLastMaintenanceFile.lastModified();
    L9:
        this.mSettingsFile = new AtomicFile(new File(Environment.getDataSystemDirectory(), "storage.xml"), "storage-settings");
        this.mWriteRecordFile = new AtomicFile(new File(Environment.getDataSystemDirectory(), "storage-write-records"));
        sSmartIdleMaintPeriod = DeviceConfig.getInt("storage_native_boot", "smart_idle_maint_period", 60);
        if (sSmartIdleMaintPeriod >= 10) goto L13;
        sSmartIdleMaintPeriod = 10;
    L15:
        this.mMaxWriteRecords = MAX_PERIOD_WRITE_RECORD / sSmartIdleMaintPeriod;
        this.mStorageWriteRecords = new int[this.mMaxWriteRecords];
        Object r4 = this.mLock;
        monitor-enter(r4);
        readSettingsLocked();     // Catch: Throwable -> L28
        monitor-exit(r4);     // Catch: Throwable -> L28
        LocalServices.addService(StorageManagerInternal.class, this.mStorageManagerInternal);
        IntentFilter userFilter = new IntentFilter();
        userFilter.addAction("android.intent.action.USER_ADDED");
        userFilter.addAction("android.intent.action.USER_REMOVED");
        this.mContext.registerReceiver(this.mUserReceiver, userFilter, null, this.mHandler);
        Object r2 = this.mLock;
        monitor-enter(r2);
        addInternalVolumeLocked();     // Catch: Throwable -> L25
        monitor-exit(r2);     // Catch: Throwable -> L25
        Watchdog.getInstance().addMonitor(this);
        return;
    L25:
        th = move-exception;
        throw th;
    L28:
        th = move-exception;
        throw th;
    L13:
        if (sSmartIdleMaintPeriod <= MAX_SMART_IDLE_MAINT_PERIOD) goto L15;
        sSmartIdleMaintPeriod = MAX_SMART_IDLE_MAINT_PERIOD;
        goto L15
    L33:
        new FileOutputStream(this.mLastMaintenanceFile).close();     // Catch: IOException -> L6
    L7:
        Slog.e(TAG, "Unable to create fstrim record " + this.mLastMaintenanceFile.getPath());
        goto L9
    }

    private void start() {
        connectStoraged();
        connectVold();
    }

    private void connectStoraged() {
        IBinder binder = ServiceManager.getService("storaged");
        if (binder != null) goto L16;
    L8:
        if (binder == null) goto L10;
        this.mStoraged = IStoraged.Stub.asInterface(binder);
    L12:
        if (this.mStoraged != null) goto L14;
        BackgroundThread.getHandler().postDelayed(new StorageManagerService$$ExternalSyntheticLambda0(this), 1000);
        return;
    L14:
        onDaemonConnected();
        return;
    L10:
        Slog.w(TAG, "storaged not found; trying again");
        goto L12
    L16:
        binder.linkToDeath(new AnonymousClass5(this), 0);     // Catch: RemoteException -> L6
    L7:
        binder = null;
        goto L8
    }

    private /* synthetic */ void lambda$connectStoraged$2() {
        connectStoraged();
    }

    private void connectVold() {
        IBinder binder = ServiceManager.getService("vold");
        if (binder == null) goto L9;
        binder.linkToDeath(new AnonymousClass6(this), 0);     // Catch: RemoteException -> L6
    L7:
        binder = null;
    L9:
        if (binder == null) goto L15;
        this.mVold = IVold.Stub.asInterface(binder);
        this.mVold.setListener(this.mListener);     // Catch: RemoteException -> L13
    L17:
        if (this.mVold != null) goto L19;
        BackgroundThread.getHandler().postDelayed(new StorageManagerService$$ExternalSyntheticLambda3(this), 1000);
        return;
    L19:
        restoreCeUnlockedUsers();
        onDaemonConnected();
        return;
    L13:
        e = move-exception;
        this.mVold = null;
        Slog.w(TAG, "vold listener rejected; trying again", e);
        goto L17
    L15:
        Slog.w(TAG, "vold not found; trying again");
        goto L17
    }

    private /* synthetic */ void lambda$connectVold$3() {
        connectVold();
    }

    private void servicesReady() {
        this.mPmInternal = (PackageManagerInternal) LocalServices.getService(PackageManagerInternal.class);
        this.mIPackageManager = IPackageManager.Stub.asInterface(ServiceManager.getService(com.android.server.pm.Settings.ATTR_PACKAGE));
        this.mIAppOpsService = IAppOpsService.Stub.asInterface(ServiceManager.getService("appops"));
        ProviderInfo provider = getProviderInfo("media");
        if (provider == null) goto L5;
        this.mMediaStoreAuthorityAppId = UserHandle.getAppId(provider.applicationInfo.uid);
        sMediaStoreAuthorityProcessName = provider.applicationInfo.processName;
    L5:
        ProviderInfo provider2 = getProviderInfo("downloads");
        if (provider2 == null) goto L8;
        this.mDownloadsAuthorityAppId = UserHandle.getAppId(provider2.applicationInfo.uid);
    L8:
        ProviderInfo provider3 = getProviderInfo("com.android.externalstorage.documents");
        if (provider3 == null) goto L12;
        this.mExternalStorageAuthorityAppId = UserHandle.getAppId(provider3.applicationInfo.uid);
        return;
    }

    private ProviderInfo getProviderInfo(String authority) {
        return this.mPmInternal.resolveContentProvider(authority, 786432, UserHandle.getUserId(0), 1000);
    }

    private void updateLegacyStorageApps(String packageName, int uid, boolean hasLegacy) {
        Object r0 = this.mLock;
        monitor-enter(r0);
        if (hasLegacy == false) goto L8;
        Slog.v(TAG, "Package " + packageName + " has legacy storage");     // Catch: Throwable -> L6
        this.mUidsWithLegacyExternalStorage.add(Integer.valueOf(uid));     // Catch: Throwable -> L6
    L9:
        monitor-exit(r0);     // Catch: Throwable -> L6
        return;
    L8:
        Slog.v(TAG, "Package " + packageName + " does not have legacy storage");     // Catch: Throwable -> L6
        this.mUidsWithLegacyExternalStorage.remove(Integer.valueOf(uid));     // Catch: Throwable -> L6
    L6:
        th = move-exception;
        throw th;
    }

    private void snapshotAndMonitorLegacyStorageAppOp(UserHandle user) {
        int userId = user.getIdentifier();
        Iterator<ApplicationInfo> r1 = this.mPmInternal.getInstalledApplications(4988928, userId, Process.myUid()).iterator();
    L4:
        if (r1.hasNext() == false) goto L16;
        ApplicationInfo ai = r1.next();
    L12:
        e = move-exception;
        Slog.e(TAG, "Failed to check legacy op for package " + ai.packageName, e);
        goto L4
    L7:
        if (this.mIAppOpsService.checkOperation(87, ai.uid, ai.packageName) != 0) goto L9;
        boolean hasLegacy = true;
    L10:
        updateLegacyStorageApps(ai.packageName, ai.uid, hasLegacy);     // Catch: RemoteException -> L12
        goto L4
    L9:
        hasLegacy = false;
        goto L10
    L16:
        if (this.mPackageMonitorsForUser.get(userId) != null) goto L18;
        PackageMonitor monitor = new AnonymousClass7(this);
        monitor.register(this.mContext, user, this.mHandler);
        this.mPackageMonitorsForUser.put(userId, monitor);
        return;
    L18:
        Slog.w(TAG, "PackageMonitor is already registered for: " + userId);
    }

    private void systemReady() {
        ((ActivityTaskManagerInternal) LocalServices.getService(ActivityTaskManagerInternal.class)).registerScreenObserver(this);
        this.mHandler.obtainMessage(1).sendToTarget();
    }

    private void bootCompleted() {
        this.mBootCompleted = true;
        this.mHandler.obtainMessage(13).sendToTarget();
    }

    private void handleBootCompleted() {
        resetIfBootedAndConnected();
    }

    private String getDefaultPrimaryStorageUuid() {
        if (SystemProperties.getBoolean("ro.vold.primary_physical", false) == false) goto L7;
        return "primary_physical";
    L7:
        return StorageManager.UUID_PRIVATE_INTERNAL;
    }

    private void readSettingsLocked() {
        this.mRecords.clear();
        this.mPrimaryStorageUuid = getDefaultPrimaryStorageUuid();
        FileInputStream fis = null;
        fis = this.mSettingsFile.openRead();     // Catch: Throwable -> L18 XmlPullParserException -> L20 IOException -> L22 FileNotFoundException -> L24
        TypedXmlPullParser in = Xml.resolvePullParser(fis);     // Catch: Throwable -> L18 XmlPullParserException -> L20 IOException -> L22 FileNotFoundException -> L24
    L4:
        int type = in.next();     // Catch: Throwable -> L18 XmlPullParserException -> L20 IOException -> L22 FileNotFoundException -> L24
        boolean validAttr = true;
        if (type == 1) goto L33;
        if (type != 2) goto L4;
        String tag = in.getName();     // Catch: Throwable -> L18 XmlPullParserException -> L20 IOException -> L22 FileNotFoundException -> L24
        if (TAG_VOLUMES.equals(tag) == true) goto L10;
        if (TAG_VOLUME.equals(tag) == false) goto L4;
        VolumeRecord rec = readVolumeRecord(in);     // Catch: Throwable -> L18 XmlPullParserException -> L20 IOException -> L22 FileNotFoundException -> L24
        this.mRecords.put(rec.fsUuid, rec);     // Catch: Throwable -> L18 XmlPullParserException -> L20 IOException -> L22 FileNotFoundException -> L24
        goto L4
    L10:
        int version = in.getAttributeInt(null, ATTR_VERSION, 1);     // Catch: Throwable -> L18 XmlPullParserException -> L20 IOException -> L22 FileNotFoundException -> L24
        boolean primaryPhysical = SystemProperties.getBoolean("ro.vold.primary_physical", false);     // Catch: Throwable -> L18 XmlPullParserException -> L20 IOException -> L22 FileNotFoundException -> L24
        if (version >= 3) goto L16;
        if (version < 2) goto L15;
        if (primaryPhysical == false) goto L16;
    L15:
        validAttr = false;
    L16:
        if (validAttr == false) goto L4;
        this.mPrimaryStorageUuid = XmlUtils.readStringAttribute(in, ATTR_PRIMARY_STORAGE_UUID);     // Catch: Throwable -> L18 XmlPullParserException -> L20 IOException -> L22 FileNotFoundException -> L24
        goto L4
    L18:
        th = move-exception;
        IoUtils.closeQuietly(fis);
        throw th;
    L22:
        e = move-exception;
        Slog.wtf(TAG, "Failed reading metadata", e);     // Catch: Throwable -> L18
    L20:
        e = move-exception;
        Slog.wtf(TAG, "Failed reading metadata", e);     // Catch: Throwable -> L18
    L33:
        IoUtils.closeQuietly(fis);
    }

    private void writeSettingsLocked() {
        FileOutputStream fos = null;
        fos = this.mSettingsFile.startWrite();     // Catch: IOException -> L6
        TypedXmlSerializer out = Xml.resolveSerializer(fos);     // Catch: IOException -> L6
        out.startDocument(null, true);     // Catch: IOException -> L6
        out.startTag(null, TAG_VOLUMES);     // Catch: IOException -> L6
        out.attributeInt(null, ATTR_VERSION, 3);     // Catch: IOException -> L6
        XmlUtils.writeStringAttribute(out, ATTR_PRIMARY_STORAGE_UUID, this.mPrimaryStorageUuid);     // Catch: IOException -> L6
        int size = this.mRecords.size();     // Catch: IOException -> L6
        int i = 0;
    L4:
        if (i >= size) goto L8;
        VolumeRecord rec = this.mRecords.valueAt(i);     // Catch: IOException -> L6
        writeVolumeRecord(out, rec);     // Catch: IOException -> L6
        i = i + 1;     // Catch: IOException -> L6
        goto L4
    L8:
        out.endTag(null, TAG_VOLUMES);     // Catch: IOException -> L6
        out.endDocument();     // Catch: IOException -> L6
        this.mSettingsFile.finishWrite(fos);     // Catch: IOException -> L6
        return;
    L11:
        if (fos == null) goto L17;
        this.mSettingsFile.failWrite(fos);
        return;
    }

    public static VolumeRecord readVolumeRecord(TypedXmlPullParser in) throws IOException, XmlPullParserException {
        int type = in.getAttributeInt(null, "type");
        String fsUuid = XmlUtils.readStringAttribute(in, ATTR_FS_UUID);
        VolumeRecord meta = new VolumeRecord(type, fsUuid);
        meta.partGuid = XmlUtils.readStringAttribute(in, ATTR_PART_GUID);
        meta.nickname = XmlUtils.readStringAttribute(in, ATTR_NICKNAME);
        meta.userFlags = in.getAttributeInt(null, ATTR_USER_FLAGS);
        meta.createdMillis = in.getAttributeLong(null, ATTR_CREATED_MILLIS, 0);
        meta.lastSeenMillis = in.getAttributeLong(null, ATTR_LAST_SEEN_MILLIS, 0);
        meta.lastTrimMillis = in.getAttributeLong(null, ATTR_LAST_TRIM_MILLIS, 0);
        meta.lastBenchMillis = in.getAttributeLong(null, ATTR_LAST_BENCH_MILLIS, 0);
        return meta;
    }

    public static void writeVolumeRecord(TypedXmlSerializer out, VolumeRecord rec) throws IOException {
        out.startTag(null, TAG_VOLUME);
        out.attributeInt(null, "type", rec.type);
        XmlUtils.writeStringAttribute(out, ATTR_FS_UUID, rec.fsUuid);
        XmlUtils.writeStringAttribute(out, ATTR_PART_GUID, rec.partGuid);
        XmlUtils.writeStringAttribute(out, ATTR_NICKNAME, rec.nickname);
        out.attributeInt(null, ATTR_USER_FLAGS, rec.userFlags);
        out.attributeLong(null, ATTR_CREATED_MILLIS, rec.createdMillis);
        out.attributeLong(null, ATTR_LAST_SEEN_MILLIS, rec.lastSeenMillis);
        out.attributeLong(null, ATTR_LAST_TRIM_MILLIS, rec.lastTrimMillis);
        out.attributeLong(null, ATTR_LAST_BENCH_MILLIS, rec.lastBenchMillis);
        out.endTag(null, TAG_VOLUME);
    }

    public void registerListener(IStorageEventListener listener) {
        this.mCallbacks.register(listener);
    }

    public void unregisterListener(IStorageEventListener listener) {
        this.mCallbacks.unregister(listener);
    }

    public void shutdown(IStorageShutdownObserver observer) {
        super.shutdown_enforcePermission();
        Slog.i(TAG, "Shutting down");
        this.mHandler.obtainMessage(3, observer).sendToTarget();
    }

    public void mount(String volId) {
        super.mount_enforcePermission();
        WatchedVolumeInfo vol = findVolumeByIdOrThrow(volId);
        if (isMountDisallowed(vol) == true) goto L7;
        updateVolumeMountIdIfRequired(vol);
        mount(vol);
        return;
    L7:
        throw new SecurityException("Mounting " + volId + " restricted by policy");
    }

    private void remountAppStorageDirs(Map<Integer, String> pidPkgMap, int userId) {
        Iterator<Map.Entry<Integer, String>> r0 = pidPkgMap.entrySet().iterator();
    L4:
        if (r0.hasNext() == false) goto L14;
        Map.Entry<Integer, String> entry = r0.next();
        int pid = entry.getKey().intValue();
        String packageName = entry.getValue();
        Slog.i(TAG, "Remounting storage for pid: " + pid);
        String[] sharedPackages = this.mPmInternal.getSharedUserPackagesForPackage(packageName, userId);
        int uid = this.mPmInternal.getPackageUid(packageName, 0, userId);
        if (sharedPackages.length == 0) goto L8;
        String[] packages = sharedPackages;
    L15:
        this.mVold.remountAppStorageDirs(uid, pid, packages);     // Catch: RemoteException -> L11
    L11:
        e = move-exception;
        throw e.rethrowAsRuntimeException();
    L8:
        packages = new String[]{packageName};
        goto L15
    }

    private void mount(final WatchedVolumeInfo vol) {
        Trace.traceBegin(524288, "SMS.mount: " + vol.getId());     // Catch: Throwable -> L5 Exception -> L7
        Slog.i(TAG, "Mounting volume " + vol);     // Catch: Throwable -> L5 Exception -> L7
        extendWatchdogTimeout("#mount might be slow");     // Catch: Throwable -> L5 Exception -> L7
        this.mVold.mount(vol.getId(), vol.getMountFlags(), vol.getMountUserId(), new AnonymousClass8(this, vol));     // Catch: Throwable -> L5 Exception -> L7
        Slog.i(TAG, "Mounted volume " + vol);     // Catch: Throwable -> L5 Exception -> L7
    L4:
        Trace.traceEnd(524288);
        return;
    L5:
        th = move-exception;
        Trace.traceEnd(524288);
        throw th;
    L7:
        e = move-exception;
        Slog.wtf(TAG, e);     // Catch: Throwable -> L5
        goto L4
    }

    public void unmount(String volId) {
        super.unmount_enforcePermission();
        WatchedVolumeInfo vol = findVolumeByIdOrThrow(volId);
        unmount(vol.getClonedImmutableVolumeInfo());
    }

    private void unmount(ImmutableVolumeInfo vol) {
        /*  JADX ERROR: Simple mode code generation failed
            java.lang.IndexOutOfBoundsException: Index 0 out of bounds for length 0
            	at java.base/jdk.internal.util.Preconditions.outOfBounds(Preconditions.java:100)
            	at java.base/jdk.internal.util.Preconditions.outOfBoundsCheckIndex(Preconditions.java:106)
            	at java.base/jdk.internal.util.Preconditions.checkIndex(Preconditions.java:302)
            	at java.base/java.util.Objects.checkIndex(Objects.java:365)
            	at java.base/java.util.ArrayList.get(ArrayList.java:428)
            	at jadx.core.codegen.MethodGen.generateSimpleCode(MethodGen.java:354)
            	at jadx.core.codegen.MethodGen.addSimpleMethodCode(MethodGen.java:316)
            	at jadx.core.codegen.MethodGen.addInstructions(MethodGen.java:279)
            	at jadx.core.codegen.ClassGen.addMethodCode(ClassGen.java:420)
            	at jadx.core.codegen.ClassGen.addMethod(ClassGen.java:345)
            	at jadx.core.codegen.ClassGen.lambda$addInnerClsAndMethods$2(ClassGen.java:299)
            	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.accept(ForEachOps.java:186)
            	at java.base/java.util.ArrayList.forEach(ArrayList.java:1612)
            	at java.base/java.util.stream.SortedOps$RefSortingSink.end(SortedOps.java:395)
            	at java.base/java.util.stream.Sink$ChainedReference.end(Sink.java:261)
            	at java.base/java.util.stream.ReferencePipeline$7$1FlatMap.end(ReferencePipeline.java:284)
            	at java.base/java.util.stream.AbstractPipeline.copyInto(AbstractPipeline.java:571)
            	at java.base/java.util.stream.AbstractPipeline.wrapAndCopyInto(AbstractPipeline.java:560)
            	at java.base/java.util.stream.ForEachOps$ForEachOp.evaluateSequential(ForEachOps.java:153)
            	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.evaluateSequential(ForEachOps.java:176)
            	at java.base/java.util.stream.AbstractPipeline.evaluate(AbstractPipeline.java:265)
            	at java.base/java.util.stream.ReferencePipeline.forEach(ReferencePipeline.java:632)
            	at jadx.core.codegen.ClassGen.addInnerClsAndMethods(ClassGen.java:295)
            	at jadx.core.codegen.ClassGen.addClassBody(ClassGen.java:284)
            	at jadx.core.codegen.ClassGen.addClassBody(ClassGen.java:268)
            	at jadx.core.codegen.ClassGen.addClassCode(ClassGen.java:160)
            	at jadx.core.codegen.ClassGen.makeClass(ClassGen.java:104)
            	at jadx.core.codegen.CodeGen.wrapCodeGen(CodeGen.java:45)
            	at jadx.core.codegen.CodeGen.generateJavaCode(CodeGen.java:34)
            	at jadx.core.codegen.CodeGen.generate(CodeGen.java:22)
            	at jadx.core.ProcessClass.process(ProcessClass.java:89)
            	at jadx.core.ProcessClass.generateCode(ProcessClass.java:127)
            	at jadx.core.dex.nodes.ClassNode.generateClassCode(ClassNode.java:405)
            	at jadx.core.dex.nodes.ClassNode.decompile(ClassNode.java:393)
            	at jadx.core.dex.nodes.ClassNode.getCode(ClassNode.java:343)
            */
        /*
            this = this;
            java.lang.String r0 = "StorageManagerService"
            int r1 = r4.getType()     // Catch: java.lang.Exception -> L13 com.android.server.pm.Installer.InstallerException -> L15
            r2 = 1
            if (r1 != r2) goto L17
            com.android.server.pm.Installer r1 = r3.mInstaller     // Catch: java.lang.Exception -> L13 com.android.server.pm.Installer.InstallerException -> L15
            java.lang.String r2 = r4.getFsUuid()     // Catch: java.lang.Exception -> L13 com.android.server.pm.Installer.InstallerException -> L15
            r1.onPrivateVolumeRemoved(r2)     // Catch: java.lang.Exception -> L13 com.android.server.pm.Installer.InstallerException -> L15
            goto L17
        L13:
            r1 = move-exception
            goto L32
        L15:
            r1 = move-exception
            goto L18
        L17:
            goto L1e
        L18:
            java.lang.String r2 = "Failed unmount mirror data"
            android.util.Slog.e(r0, r2, r1)     // Catch: java.lang.Exception -> L13
        L1e:
            java.lang.String r1 = "#unmount might be slow"
            r3.extendWatchdogTimeout(r1)     // Catch: java.lang.Exception -> L13
            android.os.IVold r1 = r3.mVold     // Catch: java.lang.Exception -> L13
            java.lang.String r2 = r4.getId()     // Catch: java.lang.Exception -> L13
            r1.unmount(r2)     // Catch: java.lang.Exception -> L13
            com.android.server.storage.StorageSessionController r1 = r3.mStorageSessionController     // Catch: java.lang.Exception -> L13
            r1.onVolumeUnmount(r4)     // Catch: java.lang.Exception -> L13
            goto L36
        L32:
            android.util.Slog.wtf(r0, r1)
        L36:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.android.server.StorageManagerService.unmount(com.android.server.storage.ImmutableVolumeInfo):void");
    }

    public void format(String volId) {
        super.format_enforcePermission();
        WatchedVolumeInfo vol = findVolumeByIdOrThrow(volId);
        String fsUuid = vol.getFsUuid();
        this.mVold.format(vol.getId(), UiModeManagerService.Shell.NIGHT_MODE_STR_AUTO);     // Catch: Exception -> L7
        if (TextUtils.isEmpty(fsUuid) == true) goto L14;
        forgetVolume(fsUuid);     // Catch: Exception -> L7
        return;
    L14:
        return;
    L7:
        e = move-exception;
        Slog.wtf(TAG, e);
    }

    public void benchmark(String volId, final IVoldTaskListener listener) {
        super.benchmark_enforcePermission();
        this.mVold.benchmark(volId, new AnonymousClass9(this, listener));     // Catch: RemoteException -> L5
        return;
    L5:
        e = move-exception;
        throw e.rethrowAsRuntimeException();
    }

    public void partitionPublic(String diskId) {
        super.partitionPublic_enforcePermission();
        CountDownLatch latch = findOrCreateDiskScanLatch(diskId);
        extendWatchdogTimeout("#partition might be slow");
        this.mVold.partition(diskId, 0, -1);     // Catch: Exception -> L5
        waitForLatch(latch, "partitionPublic", 180000);     // Catch: Exception -> L5
        return;
    L5:
        e = move-exception;
        Slog.wtf(TAG, e);
    }

    public void partitionPrivate(String diskId) {
        super.partitionPrivate_enforcePermission();
        enforceAdminUser();
        CountDownLatch latch = findOrCreateDiskScanLatch(diskId);
        extendWatchdogTimeout("#partition might be slow");
        this.mVold.partition(diskId, 1, -1);     // Catch: Exception -> L5
        waitForLatch(latch, "partitionPrivate", 180000);     // Catch: Exception -> L5
        return;
    L5:
        e = move-exception;
        Slog.wtf(TAG, e);
    }

    public void partitionMixed(String diskId, int ratio) {
        super.partitionMixed_enforcePermission();
        enforceAdminUser();
        CountDownLatch latch = findOrCreateDiskScanLatch(diskId);
        extendWatchdogTimeout("#partition might be slow");
        this.mVold.partition(diskId, 2, ratio);     // Catch: Exception -> L5
        waitForLatch(latch, "partitionMixed", 180000);     // Catch: Exception -> L5
        return;
    L5:
        e = move-exception;
        Slog.wtf(TAG, e);
    }

    public void setVolumeNickname(String fsUuid, String nickname) {
        super.setVolumeNickname_enforcePermission();
        fsUuid.getClass();
        Object r0 = this.mLock;
        monitor-enter(r0);
        VolumeRecord rec = this.mRecords.get(fsUuid);     // Catch: Throwable -> L7
        rec.nickname = nickname;     // Catch: Throwable -> L7
        Callbacks.m387$$Nest$mnotifyVolumeRecordChanged(this.mCallbacks, rec);     // Catch: Throwable -> L7
        writeSettingsLocked();     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    public void setVolumeUserFlags(String fsUuid, int flags, int mask) {
        super.setVolumeUserFlags_enforcePermission();
        fsUuid.getClass();
        Object r0 = this.mLock;
        monitor-enter(r0);
        VolumeRecord rec = this.mRecords.get(fsUuid);     // Catch: Throwable -> L7
        rec.userFlags = (rec.userFlags & (~mask)) | (flags & mask);     // Catch: Throwable -> L7
        Callbacks.m387$$Nest$mnotifyVolumeRecordChanged(this.mCallbacks, rec);     // Catch: Throwable -> L7
        writeSettingsLocked();     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    public void forgetVolume(String fsUuid) {
        super.forgetVolume_enforcePermission();
        fsUuid.getClass();
        Object r0 = this.mLock;
        monitor-enter(r0);
        VolumeRecord rec = this.mRecords.remove(fsUuid);     // Catch: Throwable -> L9
        if (rec != null) goto L7;
    L11:
        Callbacks.m386$$Nest$mnotifyVolumeForgotten(this.mCallbacks, fsUuid);     // Catch: Throwable -> L9
        if (Objects.equals(this.mPrimaryStorageUuid, fsUuid) == false) goto L14;
        this.mPrimaryStorageUuid = getDefaultPrimaryStorageUuid();     // Catch: Throwable -> L9
        this.mHandler.obtainMessage(10).sendToTarget();     // Catch: Throwable -> L9
    L14:
        writeSettingsLocked();     // Catch: Throwable -> L9
        monitor-exit(r0);     // Catch: Throwable -> L9
        return;
    L7:
        if (TextUtils.isEmpty(rec.partGuid) == true) goto L11;
        this.mHandler.obtainMessage(9, rec).sendToTarget();     // Catch: Throwable -> L9
    L9:
        th = move-exception;
        throw th;
    }

    public void forgetAllVolumes() {
        super.forgetAllVolumes_enforcePermission();
        Object r0 = this.mLock;
        monitor-enter(r0);
        int i = 0;
    L21:
    L10:
        th = move-exception;
        throw th;
    L6:
        if (i >= this.mRecords.size()) goto L13;
        String fsUuid = this.mRecords.keyAt(i);     // Catch: Throwable -> L10
        VolumeRecord rec = this.mRecords.valueAt(i);     // Catch: Throwable -> L10
        if (TextUtils.isEmpty(rec.partGuid) == true) goto L12;
        this.mHandler.obtainMessage(9, rec).sendToTarget();     // Catch: Throwable -> L10
    L12:
        Callbacks.m386$$Nest$mnotifyVolumeForgotten(this.mCallbacks, fsUuid);     // Catch: Throwable -> L10
        i = i + 1;     // Catch: Throwable -> L10
        goto L21
    L13:
        this.mRecords.clear();     // Catch: Throwable -> L10
        if (Objects.equals(StorageManager.UUID_PRIVATE_INTERNAL, this.mPrimaryStorageUuid) == true) goto L16;
        this.mPrimaryStorageUuid = getDefaultPrimaryStorageUuid();     // Catch: Throwable -> L10
    L16:
        writeSettingsLocked();     // Catch: Throwable -> L10
        this.mHandler.obtainMessage(10).sendToTarget();     // Catch: Throwable -> L10
        monitor-exit(r0);     // Catch: Throwable -> L10
    }

    private void forgetPartition(String partGuid, String fsUuid) {
        this.mVold.forgetPartition(partGuid, fsUuid);     // Catch: Exception -> L4
        return;
    L4:
        e = move-exception;
        Slog.wtf(TAG, e);
    }

    public void fstrim(int flags, final IVoldTaskListener listener) {
        super.fstrim_enforcePermission();
    L9:
        e = move-exception;
        throw e.rethrowAsRuntimeException();
    L4:
        if (needsCheckpoint() == false) goto L11;
        if (supportsBlockCheckpoint() == false) goto L11;
        Slog.i(TAG, "Skipping fstrim - block based checkpoint in progress");     // Catch: RemoteException -> L9
        return;
    L11:
        this.mVold.fstrim(flags, new AnonymousClass10(this, listener));     // Catch: RemoteException -> L9
    }

    void runIdleMaint(final Runnable callback) {
        enforcePermission("android.permission.MOUNT_FORMAT_FILESYSTEMS");
    L9:
        e = move-exception;
        Slog.wtf(TAG, e);
        return;
    L4:
        if (needsCheckpoint() == false) goto L11;
        if (supportsBlockCheckpoint() == false) goto L11;
        Slog.i(TAG, "Skipping idle maintenance - block based checkpoint in progress");     // Catch: Exception -> L9
    L15:
        return;
    L11:
        this.mVold.runIdleMaint(this.mNeedGC, new AnonymousClass11(this, callback));     // Catch: Exception -> L9
        goto L15
    }

    public void runIdleMaintenance() {
        runIdleMaint(null);
    }

    void abortIdleMaint(final Runnable callback) {
        enforcePermission("android.permission.MOUNT_FORMAT_FILESYSTEMS");
        this.mVold.abortIdleMaint(new AnonymousClass12(this, callback));     // Catch: Exception -> L5
        return;
    L5:
        e = move-exception;
        Slog.wtf(TAG, e);
    }

    public void abortIdleMaintenance() {
        abortIdleMaint(null);
    }

    private boolean prepareSmartIdleMaint() {
        if (DeviceConfig.getBoolean("storage_native_boot", "smart_idle_maint_enabled", false) == true) goto L5;
    L7:
        boolean smartIdleMaintEnabled = false;
    L9:
        if (smartIdleMaintEnabled == false) goto L16;
        this.mLifetimePercentThreshold = DeviceConfig.getInt("storage_native_boot", "lifetime_threshold", 70);
        this.mMinSegmentsThreshold = DeviceConfig.getInt("storage_native_boot", "min_segments_threshold", 512);
        this.mDirtyReclaimRate = DeviceConfig.getFloat("storage_native_boot", "dirty_reclaim_rate", DEFAULT_DIRTY_RECLAIM_RATE);
        this.mSegmentReclaimWeight = DeviceConfig.getFloat("storage_native_boot", "segment_reclaim_weight", 1.0f);
        this.mLowBatteryLevel = DeviceConfig.getFloat("storage_native_boot", "low_battery_level", DEFAULT_LOW_BATTERY_LEVEL);
        this.mChargingRequired = DeviceConfig.getBoolean("storage_native_boot", "charging_required", true);
        this.mMinGCSleepTime = DeviceConfig.getInt("storage_native_boot", "min_gc_sleeptime", 10000);
        this.mTargetDirtyRatio = DeviceConfig.getInt("storage_native_boot", "target_dirty_ratio", 80);
        this.mNeedGC = false;
        loadStorageWriteRecords();
        this.mVold.refreshLatestWrite();     // Catch: Exception -> L13
    L15:
        refreshLifetimeConstraint();
    L13:
        e = move-exception;
        Slog.wtf(TAG, e);
    L16:
        return smartIdleMaintEnabled;
    L5:
        if (SystemProperties.getBoolean("ro.boot.zufs_provisioned", false) == true) goto L7;
        smartIdleMaintEnabled = true;
        goto L9
    }

    public boolean isPassedLifetimeThresh() {
        return this.mPassedLifetimeThresh;
    }

    private void loadStorageWriteRecords() {
        FileInputStream fis = null;
        fis = this.mWriteRecordFile.openRead();     // Catch: Throwable -> L7 Exception -> L9 FileNotFoundException -> L11
        ObjectInputStream ois = new ObjectInputStream(fis);     // Catch: Throwable -> L7 Exception -> L9 FileNotFoundException -> L11
        int periodValue = ois.readInt();     // Catch: Throwable -> L7 Exception -> L9 FileNotFoundException -> L11
        if (periodValue != sSmartIdleMaintPeriod) goto L20;
        this.mStorageWriteRecords = (int[]) ois.readObject();     // Catch: Throwable -> L7 Exception -> L9 FileNotFoundException -> L11
    L20:
    L7:
        th = move-exception;
        IoUtils.closeQuietly(fis);
        throw th;
    L9:
        e = move-exception;
        Slog.wtf(TAG, "Failed reading write records", e);     // Catch: Throwable -> L7
    L13:
        IoUtils.closeQuietly(fis);
    }

    private int getAverageWriteAmount() {
        return Arrays.stream(this.mStorageWriteRecords).sum() / this.mMaxWriteRecords;
    }

    private void updateStorageWriteRecords(int latestWrite) {
        FileOutputStream fos = null;
        System.arraycopy(this.mStorageWriteRecords, 0, this.mStorageWriteRecords, 1, this.mMaxWriteRecords - 1);
        this.mStorageWriteRecords[0] = latestWrite;
        fos = this.mWriteRecordFile.startWrite();     // Catch: IOException -> L5
        ObjectOutputStream oos = new ObjectOutputStream(fos);     // Catch: IOException -> L5
        oos.writeInt(sSmartIdleMaintPeriod);     // Catch: IOException -> L5
        oos.writeObject(this.mStorageWriteRecords);     // Catch: IOException -> L5
        this.mWriteRecordFile.finishWrite(fos);     // Catch: IOException -> L5
        return;
    L6:
        if (fos == null) goto L11;
        this.mWriteRecordFile.failWrite(fos);
        return;
    }

    private boolean checkChargeStatus() {
        IntentFilter ifilter = new IntentFilter("android.intent.action.BATTERY_CHANGED");
        Intent batteryStatus = this.mContext.registerReceiver(null, ifilter);
        if (this.mChargingRequired == false) goto L10;
        int status = batteryStatus.getIntExtra("status", -1);
        if (status == 2) goto L10;
        if (status == 5) goto L10;
        Slog.w(TAG, "Battery is not being charged");
        return false;
    L10:
        int level = batteryStatus.getIntExtra("level", -1);
        int scale = batteryStatus.getIntExtra("scale", -1);
        float chargePercent = (level * 100.0f) / scale;
        if (chargePercent >= this.mLowBatteryLevel) goto L14;
        Slog.w(TAG, "Battery level is " + chargePercent + ", which is lower than threshold: " + this.mLowBatteryLevel);
        return false;
    L14:
        return true;
    }

    private boolean refreshLifetimeConstraint() {
        int storageLifeTime = this.mVold.getStorageLifeTime();     // Catch: Exception -> L14
        if (storageLifeTime != (-1)) goto L9;
        Slog.w(TAG, "Failed to get storage lifetime");
        return false;
    L9:
        if (storageLifeTime <= this.mLifetimePercentThreshold) goto L12;
        Slog.w(TAG, "Ended smart idle maintenance, because of lifetime(" + storageLifeTime + "), lifetime threshold(" + this.mLifetimePercentThreshold + ")");
        this.mPassedLifetimeThresh = true;
        return false;
    L12:
        Slog.i(TAG, "Storage lifetime: " + storageLifeTime);
        return true;
    L14:
        e = move-exception;
        Slog.wtf(TAG, e);
        return false;
    }

    synchronized void runSmartIdleMaint(Runnable callback) {
        monitor-enter(this);
        enforcePermission("android.permission.MOUNT_FORMAT_FILESYSTEMS");     // Catch: Throwable -> L12
        int targetDirtyRatio = this.mTargetDirtyRatio;     // Catch: Throwable -> L39 Exception -> L41
        int latestWrite = this.mVold.getWriteAmount();     // Catch: Throwable -> L39 Exception -> L41
        if (latestWrite != (-1)) goto L20;
        Slog.w(TAG, "Failed to get storage write record");     // Catch: Throwable -> L16 Exception -> L18
        if (callback == null) goto L14;
        callback.run();     // Catch: Throwable -> L12
    L14:
        monitor-exit(this);
        return;
    L20:
        updateStorageWriteRecords(latestWrite);     // Catch: Throwable -> L39 Exception -> L41
        if (needsCheckpoint() == false) goto L28;
        if (supportsBlockCheckpoint() == false) goto L28;
        Slog.i(TAG, "Skipping smart idle maintenance - block based checkpoint in progress");     // Catch: Throwable -> L16 Exception -> L18
    L36:
        if (callback == null) goto L46;
        callback.run();     // Catch: Throwable -> L12
    L46:
        monitor-exit(this);
        return;
    L28:
        if (refreshLifetimeConstraint() == false) goto L34;
        if (checkChargeStatus() == false) goto L34;
        int avgWriteAmount = getAverageWriteAmount();     // Catch: Throwable -> L16 Exception -> L18
        int avgWriteAmount2 = avgWriteAmount;
        int targetDirtyRatio2 = targetDirtyRatio;
    L35:
        Slog.i(TAG, "Set smart idle maintenance: latest write amount: " + latestWrite + ", average write amount: " + avgWriteAmount2 + ", min segment threshold: " + this.mMinSegmentsThreshold + ", dirty reclaim rate: " + this.mDirtyReclaimRate + ", segment reclaim weight: " + this.mSegmentReclaimWeight + ", period(min): " + sSmartIdleMaintPeriod + ", min gc sleep time(ms): " + this.mMinGCSleepTime + ", target dirty ratio: " + targetDirtyRatio2);     // Catch: Throwable -> L39 Exception -> L41
        this.mVold.setGCUrgentPace(avgWriteAmount2, this.mMinSegmentsThreshold, this.mDirtyReclaimRate, this.mSegmentReclaimWeight, sSmartIdleMaintPeriod, this.mMinGCSleepTime, targetDirtyRatio2);     // Catch: Throwable -> L39 Exception -> L41
    L34:
        Slog.i(TAG, "Turn off gc_urgent based on checking lifetime and charge status");     // Catch: Throwable -> L39 Exception -> L41
        avgWriteAmount2 = 0;
        targetDirtyRatio2 = 100;
    L18:
        e = e;
    L43:
        Slog.wtf(TAG, e);     // Catch: Throwable -> L16
        if (callback == null) goto L46;
        callback.run();     // Catch: Throwable -> L12
    L16:
        th = th;
    L48:
        if (callback == null) goto L50;
        callback.run();     // Catch: Throwable -> L12
    L50:
        throw th;     // Catch: Throwable -> L12
    L41:
        e = e;
    L39:
        th = th;
    L12:
        th = move-exception;
        throw th;
    }

    public void setDebugFlags(int flags, int mask) {
        super.setDebugFlags_enforcePermission();
        if ((mask & 3) == 0) goto L18;
        if ((flags & 1) == 0) goto L8;
        String value = "force_on";
    L11:
        long token = Binder.clearCallingIdentity();
        SystemProperties.set("persist.sys.adoptable", value);     // Catch: Throwable -> L14
        this.mHandler.obtainMessage(10).sendToTarget();     // Catch: Throwable -> L14
        Binder.restoreCallingIdentity(token);
    L14:
        th = move-exception;
        Binder.restoreCallingIdentity(token);
        throw th;
    L8:
        if ((flags & 2) == 0) goto L10;
        value = "force_off";
        goto L11
    L10:
        value = "";
    L18:
        if ((mask & 12) == 0) goto L33;
        if ((flags & 4) == 0) goto L23;
        String value2 = "force_on";
    L26:
        long token2 = Binder.clearCallingIdentity();
        SystemProperties.set("persist.sys.sdcardfs", value2);     // Catch: Throwable -> L29
        this.mHandler.obtainMessage(10).sendToTarget();     // Catch: Throwable -> L29
        Binder.restoreCallingIdentity(token2);
    L29:
        th = move-exception;
        Binder.restoreCallingIdentity(token2);
        throw th;
    L23:
        if ((flags & 8) == 0) goto L25;
        value2 = "force_off";
        goto L26
    L25:
        value2 = "";
    L33:
        if ((mask & 16) != 0) goto L35;
        return;
    L35:
        if ((flags & 16) == 0) goto L37;
        boolean enabled = true;
    L38:
        long token3 = Binder.clearCallingIdentity();
        SystemProperties.set("persist.sys.virtual_disk", Boolean.toString(enabled));     // Catch: Throwable -> L41
        this.mHandler.obtainMessage(10).sendToTarget();     // Catch: Throwable -> L41
        Binder.restoreCallingIdentity(token3);
        return;
    L41:
        th = move-exception;
        Binder.restoreCallingIdentity(token3);
        throw th;
    L37:
        enabled = false;
        goto L38
    }

    public String getPrimaryStorageUuid() {
        Object r0 = this.mLock;
        monitor-enter(r0);
        String r1 = this.mPrimaryStorageUuid;     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r1;
    L7:
        th = move-exception;
        throw th;
    }

    public void setPrimaryStorageUuid(String volumeUuid, IPackageMoveObserver callback) {
        super.setPrimaryStorageUuid_enforcePermission();
        Object r0 = this.mLock;
        monitor-enter(r0);
    L18:
        th = move-exception;
        throw th;
    L5:
        if (Objects.equals(this.mPrimaryStorageUuid, volumeUuid) == true) goto L58;
        if (this.mMoveCallback != null) goto L56;
        this.mMoveCallback = callback;     // Catch: Throwable -> L18
        this.mMoveTargetUuid = volumeUuid;     // Catch: Throwable -> L18
        List users = ((UserManager) this.mContext.getSystemService(UserManager.class)).getUsers();     // Catch: Throwable -> L18
        Iterator<UserInfo> r2 = users.iterator();     // Catch: Throwable -> L18
    L10:
        if (r2.hasNext() == false) goto L22;
        UserInfo user = r2.next();     // Catch: Throwable -> L18
        if (StorageManager.isFileEncrypted() == false) goto L10;
        if (isCeStorageUnlocked(user.id) == true) goto L10;
        Slog.w(TAG, "Failing move due to locked user " + user.id);     // Catch: Throwable -> L18
        onMoveStatusLocked(-10);     // Catch: Throwable -> L18
        monitor-exit(r0);     // Catch: Throwable -> L18
        return;
    L22:
        if (Objects.equals("primary_physical", this.mPrimaryStorageUuid) == false) goto L24;
    L52:
        Slog.d(TAG, "Skipping move to/from primary physical");     // Catch: Throwable -> L18
        onMoveStatusLocked(82);     // Catch: Throwable -> L18
        onMoveStatusLocked(-100);     // Catch: Throwable -> L18
        this.mHandler.obtainMessage(10).sendToTarget();     // Catch: Throwable -> L18
        monitor-exit(r0);     // Catch: Throwable -> L18
        return;
    L24:
        if (Objects.equals("primary_physical", volumeUuid) == true) goto L52;
        int currentUserId = this.mCurrentUserId;     // Catch: Throwable -> L18
        VolumeInfo from = findStorageForUuidAsUser(this.mPrimaryStorageUuid, currentUserId);     // Catch: Throwable -> L18
        VolumeInfo to = findStorageForUuidAsUser(volumeUuid, currentUserId);     // Catch: Throwable -> L18
        if (from != null) goto L31;
        Slog.w(TAG, "Failing move due to missing from volume " + this.mPrimaryStorageUuid);     // Catch: Throwable -> L18
        onMoveStatusLocked(-6);     // Catch: Throwable -> L18
        monitor-exit(r0);     // Catch: Throwable -> L18
        return;
    L31:
        if (to != null) goto L36;
        Slog.w(TAG, "Failing move due to missing to volume " + volumeUuid);     // Catch: Throwable -> L18
        onMoveStatusLocked(-6);     // Catch: Throwable -> L18
        monitor-exit(r0);     // Catch: Throwable -> L18
        return;
    L36:
        monitor-exit(r0);     // Catch: Throwable -> L18
        prepareUserStorageForMoveInternal(this.mPrimaryStorageUuid, volumeUuid, users);     // Catch: Exception -> L43
        this.mVold.moveStorage(from.id, to.id, new AnonymousClass13(this));     // Catch: Exception -> L40
        return;
    L40:
        e = move-exception;
        Slog.wtf(TAG, e);
        return;
    L43:
        e = move-exception;
        Slog.w(TAG, "Failing move due to failure on prepare user data", e);
        monitor-enter(this.mLock);
        onMoveStatusLocked(-6);     // Catch: Throwable -> L49
        return;
    L49:
        th = move-exception;
        throw th;
    L56:
        throw new IllegalStateException("Move already in progress");     // Catch: Throwable -> L18
    L58:
        throw new IllegalArgumentException("Primary storage already at " + volumeUuid);     // Catch: Throwable -> L18
    }

    private void warnOnNotMounted() {
        Object r0 = this.mLock;
        monitor-enter(r0);
        int i = 0;
    L22:
    L13:
        th = move-exception;
        throw th;
    L6:
        if (i >= this.mVolumes.size()) goto L17;
        WatchedVolumeInfo vol = this.mVolumes.valueAt(i);     // Catch: Throwable -> L13
        if (vol.isPrimary() == false) goto L15;
        if (vol.isMountedWritable() == false) goto L15;
        monitor-exit(r0);     // Catch: Throwable -> L13
        return;
    L15:
        i = i + 1;     // Catch: Throwable -> L13
        goto L22
    L17:
        monitor-exit(r0);     // Catch: Throwable -> L13
        Slog.w(TAG, "No primary storage mounted!");
    }

    private boolean isUidOwnerOfPackageOrSystem(String packageName, int callerUid) {
        if (callerUid != 1000) goto L7;
        return true;
    L7:
        return this.mPmInternal.isSameApp(packageName, callerUid, UserHandle.getUserId(callerUid));
    }

    public String getMountedObbPath(String rawPath) {
        rawPath.getClass();
        warnOnNotMounted();
        Map<IBinder, List<ObbState>> r0 = this.mObbMounts;
        monitor-enter(r0);
        ObbState state = this.mObbPathToStateMap.get(rawPath);     // Catch: Throwable -> L11
        monitor-exit(r0);     // Catch: Throwable -> L11
        if (state != null) goto L10;
        Slog.w(TAG, "Failed to find OBB mounted at " + rawPath);
        return null;
    L10:
        return findVolumeByIdOrThrow(state.volId).getPath().getAbsolutePath();
    L11:
        th = move-exception;
        throw th;
    }

    public boolean isObbMounted(String rawPath) {
        rawPath.getClass();
        Map<IBinder, List<ObbState>> r0 = this.mObbMounts;
        monitor-enter(r0);
        boolean r1 = this.mObbPathToStateMap.containsKey(rawPath);     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r1;
    L7:
        th = move-exception;
        throw th;
    }

    public void mountObb(String rawPath, String canonicalPath, IObbActionListener token, int nonce, ObbInfo obbInfo) {
        rawPath.getClass();
        canonicalPath.getClass();
        token.getClass();
        obbInfo.getClass();
        validateObbInfo(obbInfo, rawPath);
        int callingUid = Binder.getCallingUid();
        ObbState obbState = new ObbState(this, rawPath, canonicalPath, callingUid, token, nonce, null);
        ObbAction action = new MountObbAction(this, obbState, callingUid, obbInfo);
        this.mObbActionHandler.sendMessage(this.mObbActionHandler.obtainMessage(1, action));
    }

    private void validateObbInfo(ObbInfo obbInfo, String rawPath) {
        String obbFilePath = new File(rawPath).getCanonicalPath();     // Catch: IOException -> L25
        Matcher matcher = OBB_FILE_PATH.matcher(obbFilePath);
        if (matcher.matches() == false) goto L24;
        int userId = UserHandle.getUserId(Binder.getCallingUid());
        String pathUserId = matcher.group(2);
        String pathPackageName = matcher.group(3);
        if (pathUserId != null) goto L8;
    L9:
        if (pathUserId == null) goto L11;
    L15:
        if (obbInfo != null) goto L17;
        return;
    L17:
        if (obbInfo.packageName.equals(pathPackageName) == false) goto L20;
        return;
    L20:
        throw new SecurityException("Path " + obbFilePath + " does not contain package name " + pathPackageName);
    L11:
        if (userId == this.mCurrentUserId) goto L15;
    L14:
        throw new SecurityException("Path " + obbFilePath + "does not correspond to calling userId " + userId);
    L8:
        if (Integer.parseInt(pathUserId) != userId) goto L14;
    L24:
        throw new SecurityException("Invalid path to Obb file : " + obbFilePath);
    L25:
        ex = move-exception;
        throw new RuntimeException("Failed to resolve path" + rawPath + " : " + ex);
    }

    public void unmountObb(String rawPath, boolean force, IObbActionListener token, int nonce) {
        rawPath.getClass();
        Map<IBinder, List<ObbState>> r1 = this.mObbMounts;
        monitor-enter(r1);
        ObbState existingState = this.mObbPathToStateMap.get(rawPath);     // Catch: Throwable -> L10
        monitor-exit(r1);     // Catch: Throwable -> L10
        if (existingState == null) goto L8;
        int callingUid = Binder.getCallingUid();
        ObbState newState = new ObbState(this, rawPath, existingState.canonicalPath, callingUid, token, nonce, existingState.volId);
        ObbAction action = new UnmountObbAction(this, newState, force);
        this.mObbActionHandler.sendMessage(this.mObbActionHandler.obtainMessage(1, action));
        return;
    L8:
        Slog.w(TAG, "Unknown OBB mount at " + rawPath);
        return;
    L10:
        th = th;
    L16:
        throw th;
    L14:
        th = th;
        goto L16
    }

    public boolean supportsCheckpoint() throws RemoteException {
        return this.mVold.supportsCheckpoint();
    }

    public void startCheckpoint(int numTries) throws RemoteException {
        int callingUid = Binder.getCallingUid();
        if (callingUid == 1000) goto L10;
        if (callingUid == 0) goto L10;
        if (callingUid == 2000) goto L10;
        throw new SecurityException("no permission to start filesystem checkpoint");
    L10:
        this.mVold.startCheckpoint(numTries);
    }

    public void commitChanges() throws RemoteException {
        if (Binder.getCallingUid() != 1000) goto L7;
        extendWatchdogTimeout("vold#commitChanges might be slow");
        this.mVold.commitChanges();
        return;
    L7:
        throw new SecurityException("no permission to commit checkpoint changes");
    }

    public boolean needsCheckpoint() throws RemoteException {
        super.needsCheckpoint_enforcePermission();
        return this.mVold.needsCheckpoint();
    }

    public void abortChanges(String message, boolean retry) throws RemoteException {
        if (Binder.getCallingUid() != 1000) goto L7;
        this.mVold.abortChanges(message, retry);
        return;
    L7:
        throw new SecurityException("no permission to commit checkpoint changes");
    }

    public void createUserStorageKeys(int userId, boolean ephemeral) {
        super.createUserStorageKeys_enforcePermission();
        this.mVold.createUserStorageKeys(userId, ephemeral);     // Catch: Exception -> L11
        Object r0 = this.mLock;     // Catch: Exception -> L11
        monitor-enter(r0);     // Catch: Exception -> L11
        this.mCeUnlockedUsers.append(userId);     // Catch: Throwable -> L8
        monitor-exit(r0);     // Catch: Throwable -> L8
    L18:
        return;
    L8:
        th = move-exception;
        throw th;     // Catch: Exception -> L11
    L11:
        e = move-exception;
        Slog.wtf(TAG, e);
    }

    public void destroyUserStorageKeys(int userId) {
        super.destroyUserStorageKeys_enforcePermission();
        this.mVold.destroyUserStorageKeys(userId);     // Catch: Exception -> L11
        Object r0 = this.mLock;     // Catch: Exception -> L11
        monitor-enter(r0);     // Catch: Exception -> L11
        this.mCeUnlockedUsers.remove(userId);     // Catch: Throwable -> L8
        monitor-exit(r0);     // Catch: Throwable -> L8
    L18:
        return;
    L8:
        th = move-exception;
        throw th;     // Catch: Exception -> L11
    L11:
        e = move-exception;
        Slog.wtf(TAG, e);
    }

    public void setCeStorageProtection(int userId, byte[] secret) throws RemoteException {
        super.setCeStorageProtection_enforcePermission();
        this.mVold.setCeStorageProtection(userId, secret);
    }

    public void unlockCeStorage(int userId, byte[] secret) throws RemoteException {
        super.unlockCeStorage_enforcePermission();
        if (StorageManager.isFileEncrypted() == false) goto L5;
        this.mVold.unlockCeStorage(userId, secret);
    L5:
        Object r0 = this.mLock;
        monitor-enter(r0);
        this.mCeUnlockedUsers.append(userId);     // Catch: Throwable -> L10
        monitor-exit(r0);     // Catch: Throwable -> L10
        return;
    L10:
        th = move-exception;
        throw th;
    }

    public void serviceKeyInit(int serviceId, int userId, byte[] secret) throws RemoteException {
        ((IObricStorageManagerService) ObricImplFactory.getImpl(IObricStorageManagerService.class, new Object[]{this})).serviceKeyInit(this.mContext, this.mVold, serviceId, userId, secret);
    }

    public void serviceKeyDelete(int serviceId, int userId) throws RemoteException {
        ((IObricStorageManagerService) ObricImplFactory.getImpl(IObricStorageManagerService.class, new Object[]{this})).serviceKeyDelete(this.mContext, this.mVold, serviceId, userId);
    }

    public void serviceLockStorage(int serviceId, int userId) throws RemoteException {
        ((IObricStorageManagerService) ObricImplFactory.getImpl(IObricStorageManagerService.class, new Object[]{this})).serviceLockStorage(this.mContext, this.mVold, serviceId, userId);
    }

    public void serviceUnlockStorage(int serviceId, int userId, byte[] secret) throws RemoteException {
        ((IObricStorageManagerService) ObricImplFactory.getImpl(IObricStorageManagerService.class, new Object[]{this})).serviceUnlockStorage(this.mContext, this.mVold, serviceId, userId, secret);
    }

    public void lockCeStorage(int userId) {
        super.lockCeStorage_enforcePermission();
        if (userId != 0) goto L10;
        if (UserManager.isHeadlessSystemUserMode() == false) goto L10;
        throw new IllegalArgumentException("Headless system user data cannot be locked..");
    L10:
        if (isCeStorageUnlocked(userId) == true) goto L26;
        Slog.d(TAG, "User " + userId + "'s CE storage is already locked");
        return;
    L26:
        this.mVold.lockCeStorage(userId);     // Catch: Exception -> L23
        Object r0 = this.mLock;
        monitor-enter(r0);
        this.mCeUnlockedUsers.remove(userId);     // Catch: Throwable -> L20
        monitor-exit(r0);     // Catch: Throwable -> L20
        dispatchCeStorageLockedEvent(userId);
        return;
    L20:
        th = move-exception;
        throw th;
    L23:
        e = move-exception;
        Slog.wtf(TAG, e);
    }

    public boolean isCeStorageUnlocked(int userId) {
        Object r0 = this.mLock;
        monitor-enter(r0);
        boolean r1 = this.mCeUnlockedUsers.contains(userId);     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r1;
    L7:
        th = move-exception;
        throw th;
    }

    private boolean isSystemUnlocked(int userId) {
        Object r0 = this.mLock;
        monitor-enter(r0);
        boolean r1 = ArrayUtils.contains(this.mSystemUnlockedUsers, userId);     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r1;
    L7:
        th = move-exception;
        throw th;
    }

    private void prepareUserStorageIfNeeded(WatchedVolumeInfo vol) throws Exception {
        if (vol.getType() == 1) goto L5;
        return;
    L5:
        UserManager um = (UserManager) this.mContext.getSystemService(UserManager.class);
        UserManagerInternal umInternal = (UserManagerInternal) LocalServices.getService(UserManagerInternal.class);
        Iterator r2 = um.getUsers().iterator();
    L7:
        if (r2.hasNext() == false) goto L15;
        UserInfo user = (UserInfo) r2.next();
        if (umInternal.isUserUnlockingOrUnlocked(user.id) == true) goto L10;
        int flags = user.id;
        if (umInternal.isUserRunning(flags) == false) goto L7;
        int flags2 = 1;
    L14:
        prepareUserStorageInternal(vol.getFsUuid(), user.id, flags2);
        goto L7
    L10:
        flags2 = 3;
        goto L14
    }

    public void prepareUserStorage(String volumeUuid, int userId, int flags) {
        super.prepareUserStorage_enforcePermission();
        prepareUserStorageInternal(volumeUuid, userId, flags);     // Catch: Exception -> L5
        return;
    L5:
        e = move-exception;
        throw new RuntimeException(e);
    }

    private void prepareUserStorageInternal(String volumeUuid, int userId, int flags) throws Exception {
        this.mVold.prepareUserStorage(volumeUuid, userId, flags);     // Catch: Exception -> L11
        if (volumeUuid == null) goto L14;
        StorageManager storage = (StorageManager) this.mContext.getSystemService(StorageManager.class);     // Catch: Exception -> L11
        VolumeInfo info = storage.findVolumeByUuid(volumeUuid);     // Catch: Exception -> L11
        if (info == null) goto L22;
        if (userId == 0) goto L8;
        return;
    L8:
        if (info.type != 1) goto L24;
        this.mInstaller.tryMountDataMirror(volumeUuid);     // Catch: Exception -> L11
        return;
    L24:
        return;
    L22:
        return;
    L14:
        return;
    L11:
        e = move-exception;
        EventLog.writeEvent(1397638484, new Object[]{"224585613", -1, ""});
        Slog.wtf(TAG, e);
        UserManagerInternal umInternal = (UserManagerInternal) LocalServices.getService(UserManagerInternal.class);
        if (umInternal.shouldIgnorePrepareStorageErrors(userId) == false) goto L19;
        Slog.wtf(TAG, "ignoring error preparing storage for existing user " + userId + "; device may be insecure!");
        return;
    L19:
        throw e;
    }

    public void destroyUserStorage(String volumeUuid, int userId, int flags) {
        super.destroyUserStorage_enforcePermission();
        this.mVold.destroyUserStorage(volumeUuid, userId, flags);     // Catch: Exception -> L5
        return;
    L5:
        e = move-exception;
        Slog.wtf(TAG, e);
    }

    public void fixupAppDir(String path) {
        Matcher matcher = KNOWN_APP_DIR_PATHS.matcher(path);
        if (matcher.matches() == true) goto L5;
        Log.e(TAG, "Path " + path + " is not a valid application-specific directory");
        return;
    L5:
        if (matcher.group(2) != null) goto L24;
        Log.e(TAG, "Asked to fixup an app dir without a userId: " + path);
        return;
    L24:
        int userId = Integer.parseInt(matcher.group(2));     // Catch: PackageManager.NameNotFoundException -> L11 NumberFormatException -> L13
        String packageName = matcher.group(3);     // Catch: PackageManager.NameNotFoundException -> L11 NumberFormatException -> L13
        int uid = this.mContext.getPackageManager().getPackageUidAsUser(packageName, userId);     // Catch: PackageManager.NameNotFoundException -> L11 NumberFormatException -> L13
        this.mVold.fixupAppDir(path + SliceClientPermissions.SliceAuthority.DELIMITER, uid);     // Catch: PackageManager.NameNotFoundException -> L11 NumberFormatException -> L13 Throwable -> L15
    L29:
        return;
    L15:
        e = move-exception;
        Log.e(TAG, "Failed to fixup app dir for " + packageName, e);     // Catch: PackageManager.NameNotFoundException -> L11 NumberFormatException -> L13
    L26:
        return;
    L11:
        e = move-exception;
        Log.e(TAG, "Couldn't find package to fixup app dir " + path, e);
        return;
    L13:
        e = move-exception;
        Log.e(TAG, "Invalid userId in path: " + path, e);
    }

    public void disableAppDataIsolation(String pkgName, int pid, int userId) {
        int callingUid = Binder.getCallingUid();
        if (callingUid != 0) goto L5;
    L9:
        String[] sharedPackages = this.mPmInternal.getSharedUserPackagesForPackage(pkgName, userId);
        int uid = this.mPmInternal.getPackageUid(pkgName, 0, userId);
        if (sharedPackages.length == 0) goto L12;
        String[] packages = sharedPackages;
    L18:
        this.mVold.unmountAppStorageDirs(uid, pid, packages);     // Catch: RemoteException -> L15
        return;
    L15:
        e = move-exception;
        throw e.rethrowAsRuntimeException();
    L12:
        packages = new String[]{pkgName};
        goto L18
    L5:
        if (callingUid == 2000) goto L9;
        throw new SecurityException("no permission to enable app visibility");
    }

    public PendingIntent getManageSpaceActivityIntent(String packageName, int requestCode) {
        int originalUid = Binder.getCallingUidOrThrow();
        String[] packagesFromUid = this.mIPackageManager.getPackagesForUid(originalUid);     // Catch: RemoteException -> L34
        if (packagesFromUid == null) goto L37;
        if (this.mStorageManagerInternal.hasExternalStorageAccess(originalUid, packagesFromUid[0]) == false) goto L33;
        ApplicationInfo appInfo = this.mIPackageManager.getApplicationInfo(packageName, 0, UserHandle.getUserId(originalUid));     // Catch: RemoteException -> L15
        if (appInfo == null) goto L29;
        if (appInfo.manageSpaceActivityName != null) goto L17;
        Log.i(TAG, packageName + " doesn't have a manageSpaceActivity");     // Catch: RemoteException -> L15
        return null;
    L17:
        long token = Binder.clearCallingIdentity();
        Context targetAppContext = this.mContext.createPackageContextAsUser(packageName, 0, UserHandle.of(UserHandle.getUserId(originalUid)));     // Catch: Throwable -> L21 PackageManager.NameNotFoundException -> L23
        Intent intent = new Intent("android.intent.action.VIEW");     // Catch: Throwable -> L21 PackageManager.NameNotFoundException -> L23
        intent.setClassName(packageName, appInfo.manageSpaceActivityName);     // Catch: Throwable -> L21 PackageManager.NameNotFoundException -> L23
        intent.setFlags(268435456);     // Catch: Throwable -> L21 PackageManager.NameNotFoundException -> L23
        ActivityOptions options = ActivityOptions.makeBasic().setPendingIntentCreatorBackgroundActivityStartMode(2);     // Catch: Throwable -> L21 PackageManager.NameNotFoundException -> L23
        PendingIntent activity = PendingIntent.getActivity(targetAppContext, requestCode, intent, 1409286144, options.toBundle());     // Catch: Throwable -> L21 PackageManager.NameNotFoundException -> L23
        Binder.restoreCallingIdentity(token);
        return activity;
    L21:
        th = move-exception;
        Binder.restoreCallingIdentity(token);
        throw th;
    L25:
        throw new IllegalArgumentException("packageName not found");     // Catch: Throwable -> L21
    L29:
        throw new IllegalArgumentException("Invalid packageName");     // Catch: RemoteException -> L15
    L31:
        throw new SecurityException("Only File Manager Apps permitted");
    L33:
        throw new SecurityException("Only File Manager Apps permitted");     // Catch: RemoteException -> L34
    L37:
        throw new SecurityException("Unknown uid " + originalUid);     // Catch: RemoteException -> L34
    L34:
        re = move-exception;
        throw new SecurityException("Unknown uid " + originalUid, re);
    }

    public void notifyAppIoBlocked(String volumeUuid, int uid, int tid, int reason) {
        enforceExternalStorageService();
        this.mStorageSessionController.notifyAppIoBlocked(volumeUuid, uid, tid, reason);
    }

    public void notifyAppIoResumed(String volumeUuid, int uid, int tid, int reason) {
        enforceExternalStorageService();
        this.mStorageSessionController.notifyAppIoResumed(volumeUuid, uid, tid, reason);
    }

    public boolean isAppIoBlocked(String volumeUuid, int uid, int tid, int reason) {
        return isAppIoBlocked(uid);
    }

    private boolean isAppIoBlocked(int uid) {
        return this.mStorageSessionController.isAppIoBlocked(uid);
    }

    public void setCloudMediaProvider(String authority) {
        enforceExternalStorageService();
        int userId = UserHandle.getUserId(Binder.getCallingUid());
        SparseArray<String> r1 = this.mCloudMediaProviders;
        monitor-enter(r1);
        String oldAuthority = this.mCloudMediaProviders.get(userId);     // Catch: Throwable -> L7
        if (Objects.equals(authority, oldAuthority) == true) goto L9;
        this.mCloudMediaProviders.put(userId, authority);     // Catch: Throwable -> L7
        this.mHandler.obtainMessage(16, userId, 0, authority).sendToTarget();     // Catch: Throwable -> L7
    L9:
        monitor-exit(r1);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    public String getCloudMediaProvider() {
        int callingUid = Binder.getCallingUid();
        int userId = UserHandle.getUserId(callingUid);
        SparseArray<String> r1 = this.mCloudMediaProviders;
        monitor-enter(r1);
        String authority = this.mCloudMediaProviders.get(userId);     // Catch: Throwable -> L16
        monitor-exit(r1);     // Catch: Throwable -> L16
        if (authority != null) goto L9;
        return null;
    L9:
        ProviderInfo pi = this.mPmInternal.resolveContentProvider(authority, 0, userId, callingUid);
        if (pi != null) goto L12;
    L15:
        return null;
    L12:
        if (this.mPmInternal.filterAppAccess(pi.packageName, callingUid, userId) == true) goto L15;
        return authority;
    L16:
        th = move-exception;
        throw th;
    }

    public long getInternalStorageBlockDeviceSize() throws RemoteException {
        if (this.mInternalStorageSize != 0) goto L6;
        this.mInternalStorageSize = this.mVold.getStorageSize();
    L6:
        return this.mInternalStorageSize;
    }

    public int getInternalStorageRemainingLifetime() throws RemoteException {
        PermissionEnforcer.fromContext(this.mContext).enforcePermissionAnyOf(new String[]{"android.permission.READ_PRIVILEGED_PHONE_STATE", "android.permission.ALLOCATE_AGGRESSIVE"}, IStorageManager.Stub.getCallingPid(), IStorageManager.Stub.getCallingUid());
        return this.mVold.getStorageRemainingLifetime();
    }

    private void enforceExternalStorageService() {
        enforcePermission("android.permission.WRITE_MEDIA_STORAGE");
        int callingAppId = UserHandle.getAppId(Binder.getCallingUid());
        if (callingAppId != this.mMediaStoreAuthorityAppId) goto L6;
        return;
    L6:
        throw new SecurityException("Only the ExternalStorageService is permitted");
    }

    public AppFuseMount mountProxyFileDescriptorBridge() {
        Slog.v(TAG, "mountProxyFileDescriptorBridge");
        int uid = Binder.getCallingUid();
    L3:
        Object r1 = this.mAppFuseLock;
        monitor-enter(r1);
        boolean newlyCreated = false;
    L10:
        th = move-exception;
        throw th;
    L7:
        if (this.mAppFuseBridge != null) goto L31;
        this.mAppFuseBridge = new AppFuseBridge();     // Catch: Throwable -> L10
        new Thread(this.mAppFuseBridge, AppFuseBridge.TAG).start();     // Catch: Throwable -> L10
        newlyCreated = true;
    L31:
        int name = this.mNextAppFuseName;     // Catch: Throwable -> L10 AppFuseMountException -> L16
        this.mNextAppFuseName = name + 1;     // Catch: Throwable -> L10 AppFuseMountException -> L16
        AppFuseMount r4 = new AppFuseMount(name, this.mAppFuseBridge.addBridge(new AppFuseMountScope(this, uid, name)));     // Catch: Throwable -> L10 AppFuseMountException -> L16 FuseUnavailableMountException -> L18
    L14:
        monitor-exit(r1);     // Catch: Throwable -> L10
        return r4;
    L18:
        e = move-exception;
        if (newlyCreated == true) goto L21;
        this.mAppFuseBridge = null;     // Catch: Throwable -> L10 AppFuseMountException -> L16
        goto L3
    L21:
        Slog.e(TAG, "", e);     // Catch: Throwable -> L10 AppFuseMountException -> L16
        return null;
    L16:
        e = move-exception;
        throw e.rethrowAsParcelableException();     // Catch: Throwable -> L10
    }

    public ParcelFileDescriptor openProxyFileDescriptor(int mountId, int fileId, int mode) {
        Slog.v(TAG, "mountProxyFileDescriptor");
        int mode2 = mode & LZMA2Options.DICT_SIZE_MAX;
        Object r1 = this.mAppFuseLock;     // Catch: Throwable -> L17
        monitor-enter(r1);     // Catch: Throwable -> L17
    L10:
        th = move-exception;
        throw th;     // Catch: Throwable -> L17 Throwable -> L17
    L6:
        if (this.mAppFuseBridge != null) goto L12;
        Slog.e(TAG, "FuseBridge has not been created");     // Catch: Throwable -> L10
        monitor-exit(r1);     // Catch: Throwable -> L10
        return null;
    L12:
        ParcelFileDescriptor r2 = this.mAppFuseBridge.openFile(mountId, fileId, mode2);     // Catch: Throwable -> L10
        monitor-exit(r1);     // Catch: Throwable -> L10
        return r2;
    L17:
        e = move-exception;
        Slog.v(TAG, "The mount point has already been invalid", e);
        return null;
    }

    public void mkdirs(String callingPkg, String appPath) {
        int callingUid = Binder.getCallingUid();
        int userId = UserHandle.getUserId(callingUid);
        String propertyName = "sys.user." + userId + ".ce_available";
        if (isCeStorageUnlocked(userId) == false) goto L54;
        if (userId == 0) goto L6;
    L10:
        AppOpsManager appOps = (AppOpsManager) this.mContext.getSystemService("appops");
        appOps.checkPackage(callingUid, callingPkg);
        PackageManager.Property noAppStorageProp = this.mContext.getPackageManager().getPropertyAsUser("android.internal.PROPERTY_NO_APP_DATA_STORAGE", callingPkg, null, userId);     // Catch: PackageManager.NameNotFoundException -> L18
        if (noAppStorageProp == null) goto L59;
        if (noAppStorageProp.getBoolean() == false) goto L59;
        throw new SecurityException(callingPkg + " should not have " + appPath);     // Catch: PackageManager.NameNotFoundException -> L18
    L59:
        File appFile = new File(appPath).getCanonicalFile();     // Catch: IOException -> L50
        String appPath2 = appFile.getAbsolutePath();
        if (appPath2.endsWith(SliceClientPermissions.SliceAuthority.DELIMITER) == true) goto L26;
        appPath2 = appPath2 + SliceClientPermissions.SliceAuthority.DELIMITER;
    L26:
        Matcher matcher = KNOWN_APP_DIR_PATHS.matcher(appPath2);
        if (matcher.matches() == false) goto L49;
        if (matcher.group(3).equals(callingPkg) == false) goto L47;
        if (matcher.group(2) == null) goto L35;
        if (matcher.group(2).equals(Integer.toString(userId)) == true) goto L35;
    L40:
        throw new SecurityException("Invalid mkdirs path: " + appFile + " does not match calling user id " + userId);
    L35:
        if (matcher.group(2) == null) goto L37;
    L57:
        this.mVold.setupAppDir(appPath2, callingUid);     // Catch: RemoteException -> L43
        return;
    L43:
        e = move-exception;
        throw new IllegalStateException("Failed to prepare " + appPath2 + ": " + e);
    L37:
        if (userId != this.mCurrentUserId) goto L40;
    L47:
        throw new SecurityException("Invalid mkdirs path: " + appFile + " does not contain calling package " + callingPkg);
    L49:
        throw new SecurityException("Invalid mkdirs path: " + appFile + " is not a known app path.");
    L50:
        e = move-exception;
        throw new IllegalStateException("Failed to resolve " + appPath + ": " + e);
    L6:
        if (SystemProperties.getBoolean(propertyName, false) == true) goto L10;
        throw new IllegalStateException("Failed to prepare " + appPath);
    L54:
        throw new IllegalStateException("Failed to prepare " + appPath);
    }

    /* JADX WARN: Unreachable blocks removed: 2, instructions: 6 */
    public StorageVolume[] getVolumeList(int userId, String callingPackage, int flags) {
        int callingUid = Binder.getCallingUid();
        int callingUserId = UserHandle.getUserId(callingUid);
        if (isUidOwnerOfPackageOrSystem(callingPackage, callingUid) == false) goto L199;
        if (callingUserId == userId) goto L7;
        this.mContext.enforceCallingOrSelfPermission("android.permission.INTERACT_ACROSS_USERS", "Need INTERACT_ACROSS_USERS to get volumes for another user");
    L7:
        if ((flags & 256) == 0) goto L9;
        boolean r0 = true;
    L10:
        boolean forWrite = r0;
        if ((flags & 512) == 0) goto L13;
        boolean r1 = true;
    L14:
        boolean realState = r1;
        if ((flags & 1024) == 0) goto L17;
        boolean r2 = true;
    L18:
        boolean includeInvisible = r2;
        if ((flags & 2048) == 0) goto L21;
        boolean r3 = true;
    L22:
        boolean includeRecent = r3;
        if ((flags & 4096) == 0) goto L25;
        boolean r4 = true;
    L26:
        boolean includeSharedProfile = r4;
        boolean callerIsMediaStore = UserHandle.isSameApp(callingUid, this.mMediaStoreAuthorityAppId);
        if (includeSharedProfile == true) goto L214;
    L43:
        boolean systemUserUnlocked = isSystemUnlocked(0);
        long token = Binder.clearCallingIdentity();
        boolean userIsDemo = ((UserManagerInternal) LocalServices.getService(UserManagerInternal.class)).getUserInfo(userId).isDemo();     // Catch: Throwable -> L195
        boolean storagePermission = this.mStorageManagerInternal.hasExternalStorage(callingUid, callingPackage);     // Catch: Throwable -> L195
        boolean ceStorageUnlocked = isCeStorageUnlocked(userId);     // Catch: Throwable -> L195
        Binder.restoreCallingIdentity(token);
        ArrayList<StorageVolume> res = new ArrayList();
        ArraySet<String> resUuids = new ArraySet();
        boolean foundPrimary = false;
        int userIdSharingMedia = this.mUserSharesMediaWith.get(userId, -1);
        Object r5 = this.mLock;
        monitor-enter(r5);
        int i = 0;
    L208:
        if (i >= this.mVolumes.size()) goto L163;
        String volId = this.mVolumes.keyAt(i);     // Catch: Throwable -> L161
        int callingUid2 = callingUid;
        WatchedVolumeInfo vol = this.mVolumes.valueAt(i);     // Catch: Throwable -> L159
        switch(vol.getType()) {
            case 0: goto L65;
            case 2: goto L55;
            case 5: goto L65;
            default: goto L54;
        };
    L54:
        int i2 = i;
    L96:
        int callingUserId2 = callingUserId;
        boolean systemUserUnlocked2 = systemUserUnlocked;
        ArrayList<StorageVolume> res2 = res;
        ArraySet<String> resUuids2 = resUuids;
    L152:
        i = i2 + 1;
        res = res2;
        resUuids = resUuids2;
        callingUid = callingUid2;
        callingUserId = callingUserId2;
        systemUserUnlocked = systemUserUnlocked2;
        goto L208
    L55:
        i2 = i;
        int i3 = vol.getMountUserId();     // Catch: Throwable -> L63
        if (i3 == userId) goto L67;
        if (includeSharedProfile == false) goto L96;
        if (vol.getMountUserId() != userIdSharingMedia) goto L96;
    L67:
        if (forWrite == true) goto L69;
        boolean match = vol.isVisibleForUser(userId);     // Catch: Throwable -> L159
        if (match == false) goto L80;
    L93:
        boolean match2 = true;
    L95:
        if (match2 == false) goto L96;
        if (callerIsMediaStore == false) goto L100;
        callingUserId2 = callingUserId;
        systemUserUnlocked2 = systemUserUnlocked;
    L126:
        boolean reportUnmounted = false;
    L127:
        int volUserId = userId;
        if (volUserId != vol.getMountUserId()) goto L212;
    L134:
        StorageVolume userVol = vol.buildStorageVolume(this.mContext, volUserId, reportUnmounted);     // Catch: Throwable -> L157
        if (vol.isPrimary() == true) goto L217;
        res2 = res;
    L148:
        res2.add(userVol);     // Catch: Throwable -> L155
    L206:
        resUuids2 = resUuids;
        resUuids2.add(userVol.getUuid());     // Catch: Throwable -> L153
    L153:
        th = th;
    L193:
        monitor-exit(r5);     // Catch: Throwable -> L177
        throw th;
    L155:
        th = th;
        goto L193
    L217:
        if (vol.getMountUserId() != userId) goto L144;
        res2 = res;
        res2.add(0, userVol);     // Catch: Throwable -> L142
        foundPrimary = true;
    L142:
        th = th;
        goto L193
    L144:
        res2 = res;
    L145:
        th = th;
        goto L193
    L212:
        if (vol.getMountUserId() < 0) goto L134;
        volUserId = vol.getMountUserId();     // Catch: Throwable -> L108
    L108:
        th = th;
    L157:
        th = th;
        goto L193
    L100:
        if (systemUserUnlocked == false) goto L103;
        callingUserId2 = callingUserId;
        systemUserUnlocked2 = systemUserUnlocked;
        if (vol.getType() != 2) goto L121;
        if (ceStorageUnlocked == true) goto L121;
        Slog.w(TAG, "Reporting " + volId + "unmounted due to " + userId + " locked");     // Catch: Throwable -> L108
        reportUnmounted = true;
    L121:
        if (storagePermission == true) goto L126;
        if (realState == true) goto L126;
        Slog.w(TAG, "Reporting " + volId + "unmounted due to missing permissions");     // Catch: Throwable -> L108
        reportUnmounted = true;
        goto L127
    L103:
        callingUserId2 = callingUserId;
        StringBuilder r6 = new StringBuilder();     // Catch: Throwable -> L110
        systemUserUnlocked2 = systemUserUnlocked;
        r6.append("Reporting ");     // Catch: Throwable -> L108
        r6.append(volId);     // Catch: Throwable -> L108
        r6.append(" unmounted due to system locked");     // Catch: Throwable -> L108
        Slog.w(TAG, r6.toString());     // Catch: Throwable -> L108
        reportUnmounted = true;
    L110:
        th = th;
        goto L193
    L80:
        if (vol.isVisible() == true) goto L85;
        if (includeInvisible == false) goto L85;
        if (vol.getPath() != null) goto L93;
    L85:
        if (vol.getType() == 0) goto L87;
    L88:
        if (includeSharedProfile == true) goto L90;
    L92:
        match2 = false;
        goto L95
    L90:
        if (vol.isVisibleForUser(userIdSharingMedia) == false) goto L92;
    L87:
        if (vol.isVisibleForUser(userIdSharingMedia) == true) goto L93;
    L69:
        if (vol.isVisibleForWrite(userId) == true) goto L75;
        if (includeSharedProfile == true) goto L72;
    L74:
        match2 = false;
        goto L95
    L72:
        if (vol.isVisibleForWrite(userIdSharingMedia) == false) goto L74;
    L75:
        match2 = true;
    L63:
        th = th;
        goto L193
    L65:
        i2 = i;
    L159:
        th = th;
    L161:
        th = th;
        goto L193
    L163:
        ArrayList<StorageVolume> res3 = res;
        ArraySet<String> resUuids3 = resUuids;
        if (includeRecent == false) goto L184;
        long lastWeek = System.currentTimeMillis() - UnixCalendar.WEEK_IN_MILLIS;     // Catch: Throwable -> L180
        int i4 = 0;
    L166:
        long lastWeek2 = lastWeek;
        if (i4 >= this.mRecords.size()) goto L184;
        VolumeRecord rec = this.mRecords.valueAt(i4);     // Catch: Throwable -> L180
        if (resUuids3.contains(rec.fsUuid) == false) goto L171;
        int userIdSharingMedia2 = userIdSharingMedia;
    L179:
        i4 = i4 + 1;     // Catch: Throwable -> L177
        userIdSharingMedia = userIdSharingMedia2;
        lastWeek = lastWeek2;
        goto L166
    L171:
        userIdSharingMedia2 = userIdSharingMedia;
        if (rec.lastSeenMillis <= 0) goto L179;
        if (rec.lastSeenMillis < lastWeek2) goto L179;
        StorageVolume userVol2 = rec.buildStorageVolume(this.mContext);     // Catch: Throwable -> L177
        res3.add(userVol2);     // Catch: Throwable -> L177
        resUuids3.add(userVol2.getUuid());     // Catch: Throwable -> L177
    L180:
        th = th;
    L184:
        monitor-exit(r5);     // Catch: Throwable -> L177
        if (userIsDemo == false) goto L187;
        File path = Environment.getDataPreloadsMediaDirectory();
        UserHandle user = new UserHandle(userId);
        String description = this.mContext.getString(R.string.unknownName);
        res3.add(new StorageVolume("demo", path, path, description, false, false, true, false, false, 0, user, null, "demo", "mounted_ro"));
    L187:
        if (foundPrimary == true) goto L190;
        Slog.w(TAG, "No primary storage defined yet; hacking together a stub");
        boolean primaryPhysical = SystemProperties.getBoolean("ro.vold.primary_physical", false);
        File path2 = Environment.getLegacyExternalStorageDirectory();
        String description2 = this.mContext.getString(R.string.unknownName);
        boolean emulated = !primaryPhysical;
        UserHandle owner = new UserHandle(userId);
        res3.add(0, new StorageVolume("stub_primary", path2, path2, description2, true, primaryPhysical, emulated, false, false, 0, owner, null, null, "removed"));
    L190:
        return (StorageVolume[]) res3.toArray(new StorageVolume[res3.size()]);
    L177:
        th = th;
    L191:
        th = th;
    L195:
        th = move-exception;
        Binder.restoreCallingIdentity(token);
        throw th;
    L214:
        String[] packagesFromUid = this.mIPackageManager.getPackagesForUid(callingUid);     // Catch: RemoteException -> L36
        if (packagesFromUid == null) goto L40;
        if (callerIsMediaStore == true) goto L43;
        if (this.mStorageManagerInternal.hasExternalStorageAccess(callingUid, packagesFromUid[0]) == true) goto L43;
        throw new SecurityException("Only File Manager Apps permitted");     // Catch: RemoteException -> L36
    L40:
        throw new SecurityException("Unknown uid " + callingUid);     // Catch: RemoteException -> L36
    L36:
        re = move-exception;
        throw new SecurityException("Unknown uid " + callingUid, re);
    L25:
        r4 = false;
        goto L26
    L21:
        r3 = false;
        goto L22
    L17:
        r2 = false;
        goto L18
    L13:
        r1 = false;
        goto L14
    L9:
        r0 = false;
        goto L10
    L199:
        throw new SecurityException("callingPackage does not match UID");
    }

    public DiskInfo[] getDisks() {
        Object r0 = this.mLock;
        monitor-enter(r0);
        DiskInfo[] res = new DiskInfo[this.mDisks.size()];     // Catch: Throwable -> L8
        int i = 0;
    L6:
        if (i >= this.mDisks.size()) goto L11;
        res[i] = this.mDisks.valueAt(i);     // Catch: Throwable -> L8
        i = i + 1;     // Catch: Throwable -> L8
        goto L6
    L11:
        monitor-exit(r0);     // Catch: Throwable -> L8
        return res;
    L8:
        th = move-exception;
        throw th;
    }

    public VolumeInfo[] getVolumes(int flags) {
        Object r0 = this.mLock;
        monitor-enter(r0);
        VolumeInfo[] res = new VolumeInfo[this.mVolumes.size()];     // Catch: Throwable -> L8
        int i = 0;
    L6:
        if (i >= this.mVolumes.size()) goto L11;
        res[i] = this.mVolumes.valueAt(i).getVolumeInfo();     // Catch: Throwable -> L8
        i = i + 1;     // Catch: Throwable -> L8
        goto L6
    L11:
        monitor-exit(r0);     // Catch: Throwable -> L8
        return res;
    L8:
        th = move-exception;
        throw th;
    }

    public VolumeRecord[] getVolumeRecords(int flags) {
        Object r0 = this.mLock;
        monitor-enter(r0);
        VolumeRecord[] res = new VolumeRecord[this.mRecords.size()];     // Catch: Throwable -> L8
        int i = 0;
    L6:
        if (i >= this.mRecords.size()) goto L11;
        res[i] = this.mRecords.valueAt(i);     // Catch: Throwable -> L8
        i = i + 1;     // Catch: Throwable -> L8
        goto L6
    L11:
        monitor-exit(r0);     // Catch: Throwable -> L8
        return res;
    L8:
        th = move-exception;
        throw th;
    }

    public long getCacheQuotaBytes(String volumeUuid, int uid) {
        if (uid == Binder.getCallingUid()) goto L5;
        this.mContext.enforceCallingPermission("android.permission.STORAGE_INTERNAL", TAG);
    L5:
        long token = Binder.clearCallingIdentity();
        StorageStatsManager stats = (StorageStatsManager) this.mContext.getSystemService(StorageStatsManager.class);     // Catch: Throwable -> L9
        long r3 = stats.getCacheQuotaBytes(volumeUuid, uid);     // Catch: Throwable -> L9
        Binder.restoreCallingIdentity(token);
        return r3;
    L9:
        th = move-exception;
        Binder.restoreCallingIdentity(token);
        throw th;
    }

    public long getCacheSizeBytes(String volumeUuid, int uid) {
        if (uid == Binder.getCallingUid()) goto L5;
        this.mContext.enforceCallingPermission("android.permission.STORAGE_INTERNAL", TAG);
    L5:
        long token = Binder.clearCallingIdentity();
        long r2 = ((StorageStatsManager) this.mContext.getSystemService(StorageStatsManager.class)).queryStatsForUid(volumeUuid, uid).getCacheBytes();     // Catch: Throwable -> L9 IOException -> L11
        Binder.restoreCallingIdentity(token);
        return r2;
    L9:
        th = move-exception;
        Binder.restoreCallingIdentity(token);
        throw th;
    L11:
        e = move-exception;
        throw new ParcelableException(e);     // Catch: Throwable -> L9
    }

    private int adjustAllocateFlags(int flags, int callingUid, String callingPackage) {
        if ((flags & 1) == 0) goto L5;
        this.mContext.enforceCallingOrSelfPermission("android.permission.ALLOCATE_AGGRESSIVE", TAG);
    L5:
        int flags2 = (flags & (-3)) & (-5);
        AppOpsManager appOps = (AppOpsManager) this.mContext.getSystemService(AppOpsManager.class);
        long token = Binder.clearCallingIdentity();
    L10:
        th = move-exception;
        Binder.restoreCallingIdentity(token);
        throw th;
    L7:
        if (appOps.isOperationActive(26, callingUid, callingPackage) == false) goto L12;
        Slog.d(TAG, "UID " + callingUid + " is actively using camera; letting them defy reserved cached data");     // Catch: Throwable -> L10
        flags2 = flags2 | 4;
    L12:
        Binder.restoreCallingIdentity(token);
        return flags2;
    }

    public long getAllocatableBytes(String volumeUuid, int flags, String callingPackage) {
        int flags2 = adjustAllocateFlags(flags, Binder.getCallingUid(), callingPackage);
        StorageManager storage = (StorageManager) this.mContext.getSystemService(StorageManager.class);
        StorageStatsManager stats = (StorageStatsManager) this.mContext.getSystemService(StorageStatsManager.class);
        long token = Binder.clearCallingIdentity();
        File path = storage.findPathForUuid(volumeUuid);     // Catch: Throwable -> L32 IOException -> L34
        long usable = 0;
        long lowReserved = 0;
        long fullReserved = 0;
        long cacheClearable = 0;
        if ((flags2 & 16) != 0) goto L13;
        usable = path.getUsableSpace();     // Catch: Throwable -> L8 IOException -> L10
        lowReserved = storage.getStorageLowBytes(path);     // Catch: Throwable -> L8 IOException -> L10
        fullReserved = storage.getStorageFullBytes(path);     // Catch: Throwable -> L8 IOException -> L10
        goto L13
    L10:
        e = e;
    L38:
        throw new ParcelableException(e);     // Catch: Throwable -> L17
    L8:
        e = th;
    L39:
        Binder.restoreCallingIdentity(token);
        throw e;
    L13:
        if ((flags2 & 8) != 0) goto L24;
    L19:
        e = e;
        goto L38
    L15:
        if (stats.isQuotaSupported(volumeUuid) == false) goto L24;
        long cacheTotal = stats.getCacheBytes(volumeUuid);     // Catch: Throwable -> L17 IOException -> L19
        long cacheReserved = storage.getStorageCacheBytes(path, flags2);     // Catch: Throwable -> L17 IOException -> L19
        cacheClearable = Math.max(0, cacheTotal - cacheReserved);     // Catch: Throwable -> L17 IOException -> L19
    L24:
        if ((flags2 & 1) == 0) goto L29;
        long r0 = Math.max(0, (usable + cacheClearable) - fullReserved);     // Catch: Throwable -> L17 IOException -> L19
        Binder.restoreCallingIdentity(token);
        return r0;
    L29:
        long r1 = Math.max(0, (usable + cacheClearable) - lowReserved);     // Catch: Throwable -> L17 IOException -> L19
        Binder.restoreCallingIdentity(token);
        return r1;
    L17:
        e = th;
    L34:
        e = e;
    L32:
        e = th;
        goto L39
    }

    public void allocateBytes(String volumeUuid, long bytes, int flags, String callingPackage) {
        int flags2 = adjustAllocateFlags(flags, Binder.getCallingUid(), callingPackage);
        long allocatableBytes = getAllocatableBytes(volumeUuid, flags2 | 8, callingPackage);
        if (bytes <= allocatableBytes) goto L9;
        long cacheClearable = getAllocatableBytes(volumeUuid, flags2 | 16, callingPackage);
        if (bytes <= (allocatableBytes + cacheClearable)) goto L9;
        throw new ParcelableException(new IOException("Failed to allocate " + bytes + " because only " + (allocatableBytes + cacheClearable) + " allocatable"));
    L9:
        StorageManager storage = (StorageManager) this.mContext.getSystemService(StorageManager.class);
        long token = Binder.clearCallingIdentity();
        File path = storage.findPathForUuid(volumeUuid);     // Catch: Throwable -> L13 IOException -> L15
        if ((flags2 & 1) == 0) goto L17;
        long bytes2 = bytes + storage.getStorageFullBytes(path);     // Catch: Throwable -> L13 IOException -> L15
    L18:
        this.mPmInternal.freeStorage(volumeUuid, bytes2, flags2);     // Catch: Throwable -> L13 IOException -> L15
        Binder.restoreCallingIdentity(token);
        return;
    L17:
        bytes2 = bytes + storage.getStorageLowBytes(path);     // Catch: Throwable -> L13 IOException -> L15
    L15:
        e = move-exception;
        throw new ParcelableException(e);     // Catch: Throwable -> L13
    L13:
        th = move-exception;
        Binder.restoreCallingIdentity(token);
        throw th;
    }

    private void addObbStateLocked(ObbState obbState) throws RemoteException {
        IBinder binder = obbState.getBinder();
        List<ObbState> obbStates = this.mObbMounts.get(binder);
        if (obbStates != null) goto L5;
        obbStates = new ArrayList();
        this.mObbMounts.put(binder, obbStates);
    L13:
        obbStates.add(obbState);
        obbState.link();     // Catch: RemoteException -> L17
        this.mObbPathToStateMap.put(obbState.rawPath, obbState);
        return;
    L17:
        e = move-exception;
        obbStates.remove(obbState);
        if (obbStates.isEmpty() == false) goto L21;
        this.mObbMounts.remove(binder);
    L21:
        throw e;
    L5:
        Iterator<ObbState> r2 = obbStates.iterator();
    L7:
        if (r2.hasNext() == false) goto L13;
        ObbState o = r2.next();
        if (o.rawPath.equals(obbState.rawPath) == false) goto L7;
        throw new IllegalStateException("Attempt to add ObbState twice. This indicates an error in the StorageManagerService logic.");
    }

    private void removeObbStateLocked(ObbState obbState) {
        IBinder binder = obbState.getBinder();
        List<ObbState> obbStates = this.mObbMounts.get(binder);
        if (obbStates != null) goto L5;
    L10:
        this.mObbPathToStateMap.remove(obbState.rawPath);
        return;
    L5:
        if (obbStates.remove(obbState) == false) goto L8;
        obbState.unlink();
    L8:
        if (obbStates.isEmpty() == false) goto L10;
        this.mObbMounts.remove(binder);
        goto L10
    }

    private void dispatchOnStatus(IVoldTaskListener listener, int status, PersistableBundle extras) {
        if (listener == null) goto L9;
        listener.onStatus(status, extras);     // Catch: RemoteException -> L5
        return;
    L6:
        return;
    }

    private void dispatchOnFinished(IVoldTaskListener listener, int status, PersistableBundle extras) {
        if (listener == null) goto L9;
        listener.onFinished(status, extras);     // Catch: RemoteException -> L5
        return;
    L6:
        return;
    }

    public int getExternalStorageMountMode(int uid, String packageName) {
        super.getExternalStorageMountMode_enforcePermission();
        return this.mStorageManagerInternal.getExternalStorageMountMode(uid, packageName);
    }

    private int getMountModeInternal(int uid, String packageName) {
        if (Process.isIsolated(uid) == true) goto L59;
        if (Process.isSdkSandboxUid(uid) == true) goto L59;
        String[] packagesForUid = this.mIPackageManager.getPackagesForUid(uid);     // Catch: RemoteException -> L13
        if (ArrayUtils.isEmpty(packagesForUid) == false) goto L11;
        return 0;
    L11:
        if (packageName != null) goto L15;
        packageName = packagesForUid[0];     // Catch: RemoteException -> L13
    L15:
        long token = Binder.clearCallingIdentity();     // Catch: RemoteException -> L13
        if (this.mPmInternal.isInstantApp(packageName, UserHandle.getUserId(uid)) == false) goto L20;
        Binder.restoreCallingIdentity(token);     // Catch: RemoteException -> L13
        return 0;
    L20:
        Binder.restoreCallingIdentity(token);     // Catch: RemoteException -> L13
        if (this.mStorageManagerInternal.isExternalStorageService(uid) == false) goto L25;
        return 3;
    L25:
        if (this.mDownloadsAuthorityAppId != UserHandle.getAppId(uid)) goto L27;
    L55:
        return 4;
    L27:
        if (this.mExternalStorageAuthorityAppId == UserHandle.getAppId(uid)) goto L55;
        if (this.mIPackageManager.checkUidPermission("android.permission.ACCESS_MTP", uid) != 0) goto L32;
        boolean hasMtp = true;
    L33:
        if (hasMtp == false) goto L40;
        ApplicationInfo ai = this.mIPackageManager.getApplicationInfo(packageName, 0, UserHandle.getUserId(uid));     // Catch: RemoteException -> L13
        if (ai == null) goto L40;
        if (ai.isSignedWithPlatformKey() == false) goto L40;
        return 4;
    L40:
        if (this.mIPackageManager.checkUidPermission("android.permission.INSTALL_PACKAGES", uid) != 0) goto L42;
        boolean hasInstall = true;
    L43:
        boolean hasInstallOp = false;
        int r8 = packagesForUid.length;     // Catch: RemoteException -> L13
        int r9 = 0;
    L44:
        if (r9 >= r8) goto L49;
        String uidPackageName = packagesForUid[r9];     // Catch: RemoteException -> L13
        if (this.mIAppOpsService.checkOperation(66, uid, uidPackageName) == 0) goto L47;
        r9 = r9 + 1;     // Catch: RemoteException -> L13
        goto L44
    L47:
        hasInstallOp = true;
    L49:
        if (hasInstall == true) goto L53;
        if (hasInstallOp == true) goto L53;
        return 1;
    L53:
        return 2;
    L42:
        hasInstall = false;
        goto L43
    L32:
        hasMtp = false;
        goto L33
    L56:
        th = move-exception;
        Binder.restoreCallingIdentity(token);     // Catch: RemoteException -> L13
        throw th;     // Catch: RemoteException -> L13
    L59:
        return 0;
    L61:
        return 0;
    }

    CopyOnWriteArrayList<ICeStorageLockEventListener> getCeStorageEventCallbacks() {
        return this.mCeStorageEventCallbacks;
    }

    void dispatchCeStorageLockedEvent(int userId) {
        Iterator<ICeStorageLockEventListener> r0 = this.mCeStorageEventCallbacks.iterator();
    L4:
        if (r0.hasNext() == false) goto L6;
        ICeStorageLockEventListener listener = r0.next();
        listener.onStorageLocked(userId);
        goto L4
    }

    protected void dump(FileDescriptor fd, PrintWriter writer, String[] args) {
        if (DumpUtils.checkDumpPermission(this.mContext, TAG, writer) == true) goto L5;
        return;
    L5:
        IndentingPrintWriter pw = new IndentingPrintWriter(writer, "  ", 160);
        Object r1 = this.mLock;
        monitor-enter(r1);
        pw.println("Disks:");     // Catch: Throwable -> L11
        pw.increaseIndent();     // Catch: Throwable -> L11
        int i = 0;
    L9:
        if (i >= this.mDisks.size()) goto L13;
        DiskInfo disk = this.mDisks.valueAt(i);     // Catch: Throwable -> L11
        disk.dump(pw);     // Catch: Throwable -> L11
        i = i + 1;     // Catch: Throwable -> L11
        goto L9
    L13:
        pw.decreaseIndent();     // Catch: Throwable -> L11
        pw.println();     // Catch: Throwable -> L11
        pw.println("Volumes:");     // Catch: Throwable -> L11
        pw.increaseIndent();     // Catch: Throwable -> L11
        int i2 = 0;
    L15:
        if (i2 >= this.mVolumes.size()) goto L21;
        WatchedVolumeInfo vol = this.mVolumes.valueAt(i2);     // Catch: Throwable -> L11
        if ("private".equals(vol.getId()) == true) goto L20;
        vol.dump(pw);     // Catch: Throwable -> L11
    L20:
        i2 = i2 + 1;     // Catch: Throwable -> L11
        goto L15
    L21:
        pw.decreaseIndent();     // Catch: Throwable -> L11
        pw.println();     // Catch: Throwable -> L11
        pw.println("Records:");     // Catch: Throwable -> L11
        pw.increaseIndent();     // Catch: Throwable -> L11
        int i3 = 0;
    L23:
        if (i3 >= this.mRecords.size()) goto L25;
        VolumeRecord note = this.mRecords.valueAt(i3);     // Catch: Throwable -> L11
        note.dump(pw);     // Catch: Throwable -> L11
        i3 = i3 + 1;     // Catch: Throwable -> L11
        goto L23
    L25:
        pw.decreaseIndent();     // Catch: Throwable -> L11
        pw.println();     // Catch: Throwable -> L11
        pw.println("Primary storage UUID: " + this.mPrimaryStorageUuid);     // Catch: Throwable -> L11
        pw.println();     // Catch: Throwable -> L11
        Pair<String, Long> pair = StorageManager.getPrimaryStoragePathAndSize();     // Catch: Throwable -> L11
        if (pair != null) goto L28;
        pw.println("Internal storage total size: N/A");     // Catch: Throwable -> L11
    L29:
        pw.println();     // Catch: Throwable -> L11
        pw.println("CE unlocked users: " + this.mCeUnlockedUsers);     // Catch: Throwable -> L11
        pw.println("System unlocked users: " + Arrays.toString(this.mSystemUnlockedUsers));     // Catch: Throwable -> L11
        monitor-exit(r1);     // Catch: Throwable -> L11
        Map<IBinder, List<ObbState>> r2 = this.mObbMounts;
        monitor-enter(r2);
        pw.println();     // Catch: Throwable -> L40
        pw.println("mObbMounts:");     // Catch: Throwable -> L40
        pw.increaseIndent();     // Catch: Throwable -> L40
        Iterator<Map.Entry<IBinder, List<ObbState>>> binders = this.mObbMounts.entrySet().iterator();     // Catch: Throwable -> L40
    L35:
        if (binders.hasNext() == false) goto L43;
        Map.Entry<IBinder, List<ObbState>> e = binders.next();     // Catch: Throwable -> L40
        pw.println(e.getKey() + ":");     // Catch: Throwable -> L40
        pw.increaseIndent();     // Catch: Throwable -> L40
        List<ObbState> obbStates = e.getValue();     // Catch: Throwable -> L40
        Iterator<ObbState> r5 = obbStates.iterator();     // Catch: Throwable -> L40
    L38:
        if (r5.hasNext() == false) goto L42;
        ObbState obbState = r5.next();     // Catch: Throwable -> L40
        pw.println(obbState);     // Catch: Throwable -> L40
        goto L38
    L42:
        pw.decreaseIndent();     // Catch: Throwable -> L40
        goto L35
    L43:
        pw.decreaseIndent();     // Catch: Throwable -> L40
        pw.println();     // Catch: Throwable -> L40
        pw.println("mObbPathToStateMap:");     // Catch: Throwable -> L40
        pw.increaseIndent();     // Catch: Throwable -> L40
        Iterator<Map.Entry<String, ObbState>> maps = this.mObbPathToStateMap.entrySet().iterator();     // Catch: Throwable -> L40
    L45:
        if (maps.hasNext() == false) goto L47;
        Map.Entry<String, ObbState> e2 = maps.next();     // Catch: Throwable -> L40
        pw.print(e2.getKey());     // Catch: Throwable -> L40
        pw.print(" -> ");     // Catch: Throwable -> L40
        pw.println(e2.getValue());     // Catch: Throwable -> L40
        goto L45
    L47:
        pw.decreaseIndent();     // Catch: Throwable -> L40
        monitor-exit(r2);     // Catch: Throwable -> L40
        SparseArray<String> r3 = this.mCloudMediaProviders;
        monitor-enter(r3);
        pw.println();     // Catch: Throwable -> L55
        pw.print("Media cloud providers: ");     // Catch: Throwable -> L55
        pw.println(this.mCloudMediaProviders);     // Catch: Throwable -> L55
        monitor-exit(r3);     // Catch: Throwable -> L55
        pw.println();
        pw.print("Last maintenance: ");
        pw.println(TimeUtils.formatForLogging(this.mLastMaintenance));
        return;
    L55:
        th = move-exception;
        throw th;
    L40:
        th = move-exception;
        throw th;
    L28:
        pw.print("Internal storage (");     // Catch: Throwable -> L11
        pw.print((String) pair.first);     // Catch: Throwable -> L11
        pw.print(") total size: ");     // Catch: Throwable -> L11
        pw.print(pair.second);     // Catch: Throwable -> L11
        pw.print(" (");     // Catch: Throwable -> L11
        pw.print(((Long) pair.second).longValue() / DataUnit.MEBIBYTES.toBytes(1));     // Catch: Throwable -> L11
        pw.println(" MiB)");     // Catch: Throwable -> L11
    L11:
        th = move-exception;
        throw th;
    }

    @Override // com.android.server.Watchdog.Monitor
    public void monitor() {
        this.mVold.monitor();     // Catch: Exception -> L4
        return;
    L4:
        e = move-exception;
        Slog.wtf(TAG, e);
    }
}
