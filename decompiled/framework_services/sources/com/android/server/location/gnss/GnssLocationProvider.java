package com.android.server.location.gnss;

import android.app.AlarmManager;
import android.app.AppOpsManager;
import android.content.BroadcastReceiver;
import android.content.ContentResolver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.pm.PackageManager;
import android.location.GnssCapabilities;
import android.location.GnssStatus;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.location.LocationRequest;
import android.location.LocationResult;
import android.location.provider.ProviderProperties;
import android.location.provider.ProviderRequest;
import android.location.util.identity.CallerIdentity;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.PersistableBundle;
import android.os.PowerManager;
import android.os.RemoteException;
import android.os.ServiceManager;
import android.os.SystemClock;
import android.os.SystemProperties;
import android.os.UserHandle;
import android.os.UserManager;
import android.os.WorkSource;
import android.provider.Settings;
import android.provider.Telephony;
import android.telephony.CarrierConfigManager;
import android.telephony.CellIdentity;
import android.telephony.CellIdentityGsm;
import android.telephony.CellIdentityLte;
import android.telephony.CellIdentityNr;
import android.telephony.CellIdentityWcdma;
import android.telephony.CellInfo;
import android.telephony.CellInfoGsm;
import android.telephony.CellInfoLte;
import android.telephony.CellInfoNr;
import android.telephony.CellInfoWcdma;
import android.telephony.SmsMessage;
import android.telephony.SubscriptionManager;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import android.util.Log;
import android.util.Pair;
import android.util.TimeUtils;
import com.android.internal.app.IBatteryStats;
import com.android.internal.location.GpsNetInitiatedHandler;
import com.android.internal.util.ConcurrentUtils;
import com.android.internal.util.FrameworkStatsLog;
import com.android.internal.util.HexDump;
import com.android.server.FgThread;
import com.android.server.SysOptBridge;
import com.android.server.SystemServerInitThreadPool$$ExternalSyntheticLambda0;
import com.android.server.am.HostingRecord;
import com.android.server.am.IZswContentProviderHelper;
import com.android.server.am.SysMonitorSvcBridge;
import com.android.server.autofill.HintsHelper;
import com.android.server.location.LocationCldReport;
import com.android.server.location.LocationEventsTracker;
import com.android.server.location.LocationLogsRecorder;
import com.android.server.location.StarLocation;
import com.android.server.location.gnss.hal.GnssNative;
import com.android.server.location.provider.AbstractLocationProvider;
import com.android.server.power.IBytedancePowerAdvisor;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes2.dex */
public class GnssLocationProvider extends AbstractLocationProvider implements NetworkTimeHelper.InjectTimeCallback, GnssSatelliteBlocklistHelper.GnssSatelliteBlocklistCallback, GnssNative.BaseCallbacks, GnssNative.LocationCallbacks, GnssNative.SvStatusCallbacks, GnssNative.AGpsCallbacks, GnssNative.PsdsCallbacks, GnssNative.NotificationCallbacks, GnssNative.LocationRequestCallbacks, GnssNative.TimeCallbacks {
    private static final int AGPS_SUPL_MODE_MSA = 2;
    private static final int AGPS_SUPL_MODE_MSB = 1;
    private static boolean DEBUG = false;
    private static final long DOWNLOAD_PSDS_DATA_TIMEOUT_MS = 60000;
    private static final int EMERGENCY_LOCATION_UPDATE_DURATION_MULTIPLIER = 3;
    private static final int GPS_POLLING_THRESHOLD_INTERVAL = 10000;
    private static final long LOCATION_OFF_DELAY_THRESHOLD_ERROR_MILLIS = 15000;
    private static final long LOCATION_OFF_DELAY_THRESHOLD_WARN_MILLIS = 2000;
    private static final long LOCATION_UPDATE_DURATION_MILLIS = 10000;
    private static final long LOCATION_UPDATE_MIN_TIME_INTERVAL_MILLIS = 1000;
    private static final long MAX_BATCH_LENGTH_MS = 86400000;
    private static final long MAX_BATCH_TIMESTAMP_DELTA_MS = 500;
    private static final long MAX_RETRY_INTERVAL = 14400000;
    private static final int MIN_BATCH_INTERVAL_MS = 1000;
    private static final int NO_FIX_TIMEOUT = 60000;
    private static final ProviderProperties PROPERTIES = null;
    private static final long RETRY_INTERVAL = 300000;
    private static final String TAG = "GnssLocationProvider";
    private static final int TCP_MAX_PORT = 65535;
    private static final int TCP_MIN_PORT = 0;
    private static boolean VERBOSE = false;
    private static final long WAKELOCK_TIMEOUT_MILLIS = 30000;
    private final AlarmManager mAlarmManager;
    private final AppOpsManager mAppOps;
    private boolean mAutomotiveSuspend;
    private AlarmManager.OnAlarmListener mBatchingAlarm;
    private boolean mBatchingEnabled;
    private boolean mBatchingStarted;
    private final IBatteryStats mBatteryStats;
    private String mC2KServerHost;
    private int mC2KServerPort;
    private final WorkSource mClientSource;
    private final Context mContext;
    private final Set<Integer> mDownloadInProgressPsdsTypes;
    private final PowerManager.WakeLock mDownloadPsdsWakeLock;
    private int mFixInterval;
    private long mFixRequestTime;
    private final ArrayList<Runnable> mFlushListeners;
    private final GnssConfiguration mGnssConfiguration;
    private final GnssMetrics mGnssMetrics;
    private final GnssNative mGnssNative;
    private final GnssSatelliteBlocklistHelper mGnssSatelliteBlocklistHelper;
    private GnssVisibilityControl mGnssVisibilityControl;
    private boolean mGpsEnabled;
    private final Handler mHandler;
    private boolean mInitialized;
    private BroadcastReceiver mIntentReceiver;
    private long mLastFixTime;
    private GnssPositionMode mLastPositionMode;
    private final LocationExtras mLocationExtras;
    private final Object mLock;
    private final GpsNetInitiatedHandler mNIHandler;
    private final GnssNetworkConnectivityHandler mNetworkConnectivityHandler;
    private final NetworkTimeHelper mNetworkTimeHelper;
    private BroadcastReceiver mNiSuplIntentReceiver;
    private boolean mNiSuplMessageListenerRegistered;
    private final Set<Integer> mPendingDownloadPsdsTypes;
    private int mPositionMode;
    private ProviderRequest mProviderRequest;
    private final ExponentialBackOff mPsdsBackOff;
    private final Object mPsdsPeriodicDownloadToken;
    private boolean mShutdown;
    private boolean mStarted;
    private long mStartedChangedElapsedRealtime;
    private boolean mSuplEsEnabled;
    private String mSuplServerHost;
    private int mSuplServerPort;
    private boolean mSupportsPsds;
    private int mTimeToFirstFix;
    private final AlarmManager.OnAlarmListener mTimeoutListener;
    private final PowerManager.WakeLock mWakeLock;
    private final AlarmManager.OnAlarmListener mWakeupListener;

    /* JADX INFO: renamed from: com.android.server.location.gnss.GnssLocationProvider$1, reason: invalid class name */
    class AnonymousClass1 implements GpsNetInitiatedHandler.EmergencyCallCallback {
        final /* synthetic */ GnssLocationProvider this$0;

        /* JADX INFO: renamed from: $r8$lambda$2-H6ZQuWNTPstOo-QkS4tf6KazI, reason: not valid java name */
        public static /* synthetic */ void m5252$r8$lambda$2H6ZQuWNTPstOoQkS4tf6KazI(AnonymousClass1 r0) {
            r0.lambda$onEmergencyCallEnd$1();
        }

        /* JADX INFO: renamed from: $r8$lambda$QYNinWcFs0QTrBihkIxRs3buc-4, reason: not valid java name */
        public static /* synthetic */ void m5253$r8$lambda$QYNinWcFs0QTrBihkIxRs3buc4(AnonymousClass1 r0, int r1) {
            r0.lambda$onEmergencyCallStart$0(r1);
        }

        AnonymousClass1(GnssLocationProvider this$0) {
            this.this$0 = this$0;
        }

        public void onEmergencyCallStart(final int subId) {
            if (GnssLocationProvider.m5244$$Nest$fgetmGnssConfiguration(this.this$0).isActiveSimEmergencySuplEnabled() == true) goto L5;
            return;
        L5:
            GnssLocationProvider.m5245$$Nest$fgetmHandler(this.this$0).post(new GnssLocationProvider$1$$ExternalSyntheticLambda1(this, subId));
        }

        private /* synthetic */ void lambda$onEmergencyCallStart$0(int subId) {
            GnssLocationProvider.m5244$$Nest$fgetmGnssConfiguration(this.this$0).reloadGpsProperties(GnssLocationProvider.m5246$$Nest$fgetmNIHandler(this.this$0).getInEmergency(), subId);
        }

        public void onEmergencyCallEnd() {
            if (GnssLocationProvider.m5244$$Nest$fgetmGnssConfiguration(this.this$0).isActiveSimEmergencySuplEnabled() == true) goto L5;
            return;
        L5:
            GnssLocationProvider.m5245$$Nest$fgetmHandler(this.this$0).postDelayed(new GnssLocationProvider$1$$ExternalSyntheticLambda0(this), TimeUnit.SECONDS.toMillis(GnssLocationProvider.m5244$$Nest$fgetmGnssConfiguration(this.this$0).getEsExtensionSec()));
        }

        private /* synthetic */ void lambda$onEmergencyCallEnd$1() {
            GnssLocationProvider.m5244$$Nest$fgetmGnssConfiguration(this.this$0).reloadGpsProperties(false, SubscriptionManager.getDefaultDataSubscriptionId());
        }
    }

    private static class LocationExtras {
        private final Bundle mBundle;
        private int mMaxCn0;
        private int mMeanCn0;
        private int mSvCount;

        LocationExtras() {
            this.mBundle = new Bundle();
        }

        public void set(int svCount, int meanCn0, int maxCn0) {
            monitor-enter(this);
            this.mSvCount = svCount;     // Catch: Throwable -> L7
            this.mMeanCn0 = meanCn0;     // Catch: Throwable -> L7
            this.mMaxCn0 = maxCn0;     // Catch: Throwable -> L7
            monitor-exit(this);     // Catch: Throwable -> L7
            setBundle(this.mBundle);
            return;
        L7:
            th = move-exception;
            throw th;
        }

        public void reset() {
            set(0, 0, 0);
        }

        public void setBundle(Bundle extras) {
            if (extras == null) goto L10;
            monitor-enter(this);
            extras.putInt("satellites", this.mSvCount);     // Catch: Throwable -> L7
            extras.putInt("meanCn0", this.mMeanCn0);     // Catch: Throwable -> L7
            extras.putInt("maxCn0", this.mMaxCn0);     // Catch: Throwable -> L7
            monitor-exit(this);     // Catch: Throwable -> L7
            return;
        L7:
            th = move-exception;
            throw th;
        }

        public Bundle getBundle() {
            monitor-enter(this);
            Bundle r0 = new Bundle(this.mBundle);     // Catch: Throwable -> L6
            monitor-exit(this);     // Catch: Throwable -> L6
            return r0;
        L6:
            th = move-exception;
            throw th;
        }
    }

    public static /* synthetic */ void $r8$lambda$3pKaQ0RBuHNqDj71WwFuuusMO2o(GnssLocationProvider r0, long r1) {
        r0.lambda$startBatching$9(r1);
    }

    public static /* synthetic */ int $r8$lambda$AvK5I9nU8V4PHJh3ove0xQCeK3Q(CellInfo r0) {
        return lambda$requestRefLocation$10(r0);
    }

    public static /* synthetic */ void $r8$lambda$EY8a1qeh3ZgniOkxszZv7ArYamM(GnssLocationProvider r0, boolean r1, Location r2) {
        r0.lambda$onReportLocation$13(r1, r2);
    }

    public static /* synthetic */ void $r8$lambda$P4av5E7_VcXCDWc2O4WPS0B6dK8(GnssLocationProvider r0, int[] r1, int[] r2) {
        r0.lambda$onUpdateSatelliteBlocklist$0(r1, r2);
    }

    public static /* synthetic */ void $r8$lambda$Q1JQZl5ahtIx0Fbaz5e32hr8rfA(GnssLocationProvider r0, int r1) {
        r0.lambda$handleDownloadPsdsData$5(r1);
    }

    public static /* synthetic */ void $r8$lambda$QBjFeJKafgCc5986nVYh4e27hOk(GnssLocationProvider r0) {
        r0.lambda$onCapabilitiesChanged$12();
    }

    public static /* synthetic */ void $r8$lambda$QpmxIfDSErMpNqzK6n45r7JR7DA(GnssLocationProvider r0, boolean r1, boolean r2) {
        r0.lambda$onRequestLocation$16(r1, r2);
    }

    /* JADX INFO: renamed from: $r8$lambda$SI-a_a7cUYrR9ZOZ1L2KweRWu2U, reason: not valid java name */
    public static /* synthetic */ void m5236$r8$lambda$SIa_a7cUYrR9ZOZ1L2KweRWu2U(GnssLocationProvider r0) {
        r0.hibernate();
    }

    public static /* synthetic */ void $r8$lambda$SWsvjniE06w04QP9JgVeKN4OgX8(GnssLocationProvider r0, int r1) {
        r0.lambda$onRequestPsdsDownload$15(r1);
    }

    public static /* synthetic */ void $r8$lambda$THONdAwhixn4fmf3peUPVkvJxVo(GnssLocationProvider r0, Location r1) {
        r0.injectBestLocation(r1);
    }

    public static /* synthetic */ void $r8$lambda$UCriMPE9cCf3aUZBmohJ2c88IPM(Location r0) {
        lambda$handleRequestLocation$2(r0);
    }

    public static /* synthetic */ void $r8$lambda$a5MvCvM35QBPzxzq6uUT9CwYXVE(GnssLocationProvider r0, Runnable r1) {
        r0.lambda$postWithWakeLockHeld$11(r1);
    }

    /* JADX INFO: renamed from: $r8$lambda$bhbO-HcVDgwXGgj22odDaBV5fiU, reason: not valid java name */
    public static /* synthetic */ void m5237$r8$lambda$bhbOHcVDgwXGgj22odDaBV5fiU(GnssLocationProvider r0, Location r1) {
        r0.injectLocation(r1);
    }

    public static /* synthetic */ void $r8$lambda$c3gg2KOLPvZx2mtEXA6Nl2_8vYs(GnssLocationProvider r0) {
        r0.lambda$onExtraCommand$7();
    }

    /* JADX INFO: renamed from: $r8$lambda$cEG9-g_JtFLDSLinwbxH0FoQxTg, reason: not valid java name */
    public static /* synthetic */ void m5238$r8$lambda$cEG9g_JtFLDSLinwbxH0FoQxTg(GnssLocationProvider r0) {
        r0.startNavigating();
    }

    /* JADX INFO: renamed from: $r8$lambda$cU4NcLLLKiB1Z-LYN_VMBLlJB3Q, reason: not valid java name */
    public static /* synthetic */ void m5239$r8$lambda$cU4NcLLLKiB1ZLYN_VMBLlJB3Q(GnssLocationProvider r0, int r1) {
        r0.lambda$onNetworkAvailable$1(r1);
    }

    public static /* synthetic */ void $r8$lambda$ex9GcuAvo3Q1U9kW7Ndg7dGgHEQ(GnssLocationProvider r0) {
        r0.onNetworkAvailable();
    }

    /* JADX INFO: renamed from: $r8$lambda$fppbpJzeT915qgBxeBn44K0Vy-Q, reason: not valid java name */
    public static /* synthetic */ void m5240$r8$lambda$fppbpJzeT915qgBxeBn44K0VyQ(GnssLocationProvider r0, int r1, byte[] r2) {
        r0.lambda$handleDownloadPsdsData$3(r1, r2);
    }

    public static /* synthetic */ void $r8$lambda$kD9u4g7PESErb_hjv9eGI2NrlpM(GnssLocationProvider r0, GnssStatus r1) {
        r0.lambda$onReportSvStatus$14(r1);
    }

    public static /* synthetic */ void $r8$lambda$kqBSBJ9GE54IiDgU2gJFUO_y9qg(GnssPowerStats r0) {
        lambda$onExtraCommand$8(r0);
    }

    /* JADX INFO: renamed from: $r8$lambda$nkrBJygdb8wO-Swy2t8Lu4Qnk5s, reason: not valid java name */
    public static /* synthetic */ void m5241$r8$lambda$nkrBJygdb8wOSwy2t8Lu4Qnk5s(GnssLocationProvider r0, int r1) {
        r0.lambda$handleDownloadPsdsData$6(r1);
    }

    public static /* synthetic */ void $r8$lambda$pvaCHGEUSphUSz5n1PWLLEnhwVM(GnssLocationProvider r0) {
        r0.handleInitialize();
    }

    /* JADX INFO: renamed from: $r8$lambda$xYueuUp3I00EscyFv18dWc47-NQ, reason: not valid java name */
    public static /* synthetic */ void m5242$r8$lambda$xYueuUp3I00EscyFv18dWc47NQ(GnssLocationProvider r0, int r1) {
        r0.lambda$handleDownloadPsdsData$4(r1);
    }

    /* JADX INFO: renamed from: $r8$lambda$z-H4YUNse8SpWrTtpqf0yp95bA8, reason: not valid java name */
    public static /* synthetic */ void m5243$r8$lambda$zH4YUNse8SpWrTtpqf0yp95bA8(GnssLocationProvider r0) {
        r0.updateEnabled();
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmGnssConfiguration, reason: not valid java name */
    static /* bridge */ /* synthetic */ GnssConfiguration m5244$$Nest$fgetmGnssConfiguration(GnssLocationProvider r0) {
        return r0.mGnssConfiguration;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmHandler, reason: not valid java name */
    static /* bridge */ /* synthetic */ Handler m5245$$Nest$fgetmHandler(GnssLocationProvider r0) {
        return r0.mHandler;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmNIHandler, reason: not valid java name */
    static /* bridge */ /* synthetic */ GpsNetInitiatedHandler m5246$$Nest$fgetmNIHandler(GnssLocationProvider r0) {
        return r0.mNIHandler;
    }

    /* JADX INFO: renamed from: -$$Nest$fputmShutdown, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m5247$$Nest$fputmShutdown(GnssLocationProvider r0, boolean r1) {
        r0.mShutdown = r1;
    }

    /* JADX INFO: renamed from: -$$Nest$minjectSuplInit, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m5248$$Nest$minjectSuplInit(GnssLocationProvider r0, Intent r1) {
        r0.injectSuplInit(r1);
    }

    /* JADX INFO: renamed from: -$$Nest$msubscriptionOrCarrierConfigChanged, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m5249$$Nest$msubscriptionOrCarrierConfigChanged(GnssLocationProvider r0) {
        r0.subscriptionOrCarrierConfigChanged();
    }

    /* JADX INFO: renamed from: -$$Nest$mupdateEnabled, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m5250$$Nest$mupdateEnabled(GnssLocationProvider r0) {
        r0.updateEnabled();
    }

    /* JADX INFO: renamed from: -$$Nest$sfgetDEBUG, reason: not valid java name */
    static /* bridge */ /* synthetic */ boolean m5251$$Nest$sfgetDEBUG() {
        return DEBUG;
    }

    static {
        DEBUG = Log.isLoggable(TAG, 3);
        VERBOSE = Log.isLoggable(TAG, 2);
        PROPERTIES = new ProviderProperties.Builder().setHasSatelliteRequirement(true).setHasAltitudeSupport(true).setHasSpeedSupport(true).setHasBearingSupport(true).setPowerUsage(3).setAccuracy(1).build();
    }

    private /* synthetic */ void lambda$onUpdateSatelliteBlocklist$0(int[] constellations, int[] svids) {
        this.mGnssConfiguration.setSatelliteBlocklist(constellations, svids);
    }

    @Override // com.android.server.location.gnss.GnssSatelliteBlocklistHelper.GnssSatelliteBlocklistCallback
    public void onUpdateSatelliteBlocklist(final int[] constellations, final int[] svids) {
        this.mHandler.post(new GnssLocationProvider$$ExternalSyntheticLambda13(this, constellations, svids));
        LocationLogsRecorder.getInstance().writeLocationLogsAsync(LocationLogsRecorder.KEY_FILE_GNSS, "satellite blacklist changed");
        this.mGnssMetrics.resetConstellationTypes();
    }

    private void subscriptionOrCarrierConfigChanged() {
        if (DEBUG == false) goto L5;
        Log.d(TAG, "received SIM related action: ");
    L5:
        TelephonyManager phone = (TelephonyManager) this.mContext.getSystemService(HintsHelper.AUTOFILL_HINT_PHONE);
        CarrierConfigManager configManager = (CarrierConfigManager) this.mContext.getSystemService("carrier_config");
        int ddSubId = SubscriptionManager.getDefaultDataSubscriptionId();
        if (SubscriptionManager.isValidSubscriptionId(ddSubId) == false) goto L8;
        phone = phone.createForSubscriptionId(ddSubId);
    L8:
        String mccMnc = phone.getSimOperator();
        boolean isKeepLppProfile = false;
        if (TextUtils.isEmpty(mccMnc) == true) goto L29;
        if (DEBUG == false) goto L13;
        Log.d(TAG, "SIM MCC/MNC is available: " + mccMnc);
    L13:
        if (configManager == null) goto L21;
        if (SubscriptionManager.isValidSubscriptionId(ddSubId) == false) goto L17;
        PersistableBundle b = configManager.getConfigForSubId(ddSubId);
    L18:
        if (b == null) goto L21;
        isKeepLppProfile = b.getBoolean("gps.persist_lpp_mode_bool");
        goto L21
    L17:
        b = null;
    L21:
        if (isKeepLppProfile == false) goto L26;
        this.mGnssConfiguration.loadPropertiesFromCarrierConfig(false, -1);
        String lpp_profile = this.mGnssConfiguration.getLppProfile();
        if (lpp_profile == null) goto L27;
        SystemProperties.set("persist.sys.gps.lpp", lpp_profile);
    L27:
        reloadGpsProperties();
    L32:
        updateNiSuplMessageListenerRegistration(this.mGnssConfiguration.isNiSuplMessageInjectionEnabled());
        return;
    L26:
        SystemProperties.set("persist.sys.gps.lpp", "");
        goto L27
    L29:
        if (DEBUG == false) goto L31;
        Log.d(TAG, "SIM MCC/MNC is still not available");
    L31:
        this.mGnssConfiguration.reloadGpsProperties();
        goto L32
    }

    private void reloadGpsProperties() {
        LocationLogsRecorder.getInstance().writeLocationLogsAsync(LocationLogsRecorder.KEY_FILE_GNSS, "reloadGpsProperties");
        this.mGnssConfiguration.reloadGpsProperties();
        setSuplHostPort();
        this.mC2KServerHost = this.mGnssConfiguration.getC2KHost();
        boolean r1 = false;
        this.mC2KServerPort = this.mGnssConfiguration.getC2KPort(0);
        this.mNIHandler.setEmergencyExtensionSeconds(this.mGnssConfiguration.getEsExtensionSec());
        if (this.mGnssConfiguration.getSuplEs(0) != 1) goto L5;
        r1 = true;
    L5:
        this.mSuplEsEnabled = r1;
        if (this.mGnssVisibilityControl == null) goto L9;
        this.mGnssVisibilityControl.onConfigurationUpdated(this.mGnssConfiguration);
        return;
    }

    public GnssLocationProvider(Context context, GnssNative gnssNative, GnssMetrics gnssMetrics) {
        super(FgThread.getExecutor(), CallerIdentity.fromContext(context), PROPERTIES, Collections.emptySet());
        this.mLock = new Object();
        this.mPsdsBackOff = new ExponentialBackOff(300000, 14400000);
        this.mFixInterval = 1000;
        this.mFixRequestTime = 0;
        this.mTimeToFirstFix = 0;
        this.mClientSource = new WorkSource();
        this.mPsdsPeriodicDownloadToken = new Object();
        this.mPendingDownloadPsdsTypes = new HashSet();
        this.mDownloadInProgressPsdsTypes = new HashSet();
        this.mSuplServerPort = 0;
        this.mSuplEsEnabled = false;
        this.mNiSuplMessageListenerRegistered = false;
        this.mLocationExtras = new LocationExtras();
        this.mWakeupListener = new GnssLocationProvider$$ExternalSyntheticLambda24(this);
        this.mTimeoutListener = new GnssLocationProvider$$ExternalSyntheticLambda25(this);
        this.mFlushListeners = new ArrayList(0);
        this.mIntentReceiver = new AnonymousClass4(this);
        this.mNiSuplIntentReceiver = new AnonymousClass5(this);
        this.mContext = context;
        this.mGnssNative = gnssNative;
        this.mGnssMetrics = gnssMetrics;
        PowerManager powerManager = (PowerManager) this.mContext.getSystemService(PowerManager.class);
        powerManager.getClass();
        this.mWakeLock = powerManager.newWakeLock(1, "*location*:GnssLocationProvider");
        this.mWakeLock.setReferenceCounted(true);
        this.mDownloadPsdsWakeLock = powerManager.newWakeLock(1, "*location*:PsdsDownload");
        this.mDownloadPsdsWakeLock.setReferenceCounted(true);
        this.mAlarmManager = (AlarmManager) this.mContext.getSystemService(HostingRecord.TRIGGER_TYPE_ALARM);
        this.mAppOps = (AppOpsManager) this.mContext.getSystemService(AppOpsManager.class);
        this.mBatteryStats = IBatteryStats.Stub.asInterface(ServiceManager.getService("batterystats"));
        this.mHandler = FgThread.getHandler();
        this.mGnssConfiguration = this.mGnssNative.getConfiguration();
        GpsNetInitiatedHandler.EmergencyCallCallback emergencyCallCallback = new AnonymousClass1(this);
        this.mNIHandler = new GpsNetInitiatedHandler(context, emergencyCallCallback, this.mSuplEsEnabled);
        this.mPendingDownloadPsdsTypes.add(1);
        this.mNetworkConnectivityHandler = new GnssNetworkConnectivityHandler(context, new GnssLocationProvider$$ExternalSyntheticLambda26(this), this.mHandler.getLooper(), this.mNIHandler);
        this.mNetworkTimeHelper = NetworkTimeHelper.create(this.mContext, this.mHandler.getLooper(), this);
        this.mGnssSatelliteBlocklistHelper = new GnssSatelliteBlocklistHelper(this.mContext, this.mHandler.getLooper(), this);
        setAllowed(true);
        this.mGnssNative.addBaseCallbacks(this);
        this.mGnssNative.addLocationCallbacks(this);
        this.mGnssNative.addSvStatusCallbacks(this);
        this.mGnssNative.setAGpsCallbacks(this);
        this.mGnssNative.setPsdsCallbacks(this);
        this.mGnssNative.setNotificationCallbacks(this);
        this.mGnssNative.setLocationRequestCallbacks(this);
        this.mGnssNative.setTimeCallbacks(this);
    }

    public synchronized void onSystemReady() {
        monitor-enter(this);
        this.mContext.registerReceiverAsUser(new AnonymousClass2(this), UserHandle.ALL, new IntentFilter("android.intent.action.ACTION_SHUTDOWN"), null, this.mHandler);     // Catch: Throwable -> L6
        ContentResolver r0 = this.mContext.getContentResolver();     // Catch: Throwable -> L6
        Uri r1 = Settings.Secure.getUriFor("location_mode");     // Catch: Throwable -> L6
        final Handler r3 = this.mHandler;     // Catch: Throwable -> L6
        r0.registerContentObserver(r1, true, new AnonymousClass3(this, r3), -1);     // Catch: Throwable -> L6
        this.mHandler.post(new GnssLocationProvider$$ExternalSyntheticLambda11(this));     // Catch: Throwable -> L6
        Handler r2 = this.mHandler;     // Catch: Throwable -> L6
        final GnssSatelliteBlocklistHelper r4 = this.mGnssSatelliteBlocklistHelper;     // Catch: Throwable -> L6
        r4.getClass();     // Catch: Throwable -> L6
        r2.post(new GnssLocationProvider$$ExternalSyntheticLambda12(r4));     // Catch: Throwable -> L6
        monitor-exit(this);
        return;
    L6:
        th = move-exception;
        throw th;
    }

    private void handleInitialize() {
        if (this.mGnssNative.isGnssVisibilityControlSupported() == false) goto L5;
        this.mGnssVisibilityControl = new GnssVisibilityControl(this.mContext, this.mHandler.getLooper(), this.mNIHandler);
    L5:
        reloadGpsProperties();
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("android.telephony.action.CARRIER_CONFIG_CHANGED");
        intentFilter.addAction("android.intent.action.ACTION_DEFAULT_DATA_SUBSCRIPTION_CHANGED");
        this.mContext.registerReceiver(this.mIntentReceiver, intentFilter, null, this.mHandler);
        this.mNetworkConnectivityHandler.registerNetworkCallbacks();
        LocationManager locationManager = (LocationManager) this.mContext.getSystemService(LocationManager.class);
        locationManager.getClass();
        if (locationManager.getAllProviders().contains("network") == false) goto L8;
        locationManager.requestLocationUpdates("network", new LocationRequest.Builder(Long.MAX_VALUE).setMinUpdateIntervalMillis(0).setHiddenFromAppOps(true).build(), ConcurrentUtils.DIRECT_EXECUTOR, new GnssLocationProvider$$ExternalSyntheticLambda20(this));
    L8:
        updateEnabled();
        Object r2 = this.mLock;
        monitor-enter(r2);
        this.mInitialized = true;     // Catch: Throwable -> L13
        monitor-exit(r2);     // Catch: Throwable -> L13
        return;
    L13:
        th = move-exception;
        throw th;
    }

    private void injectSuplInit(Intent intent) {
        if (isNfwLocationAccessAllowed() == true) goto L6;
        Log.w(TAG, "Reject SUPL INIT as no NFW location access");
        return;
    L6:
        int slotIndex = intent.getIntExtra("android.telephony.extra.SLOT_INDEX", -1);
        if (slotIndex != (-1)) goto L10;
        Log.e(TAG, "Invalid slot index");
        return;
    L10:
        String action = intent.getAction();
        if (action.equals("android.intent.action.DATA_SMS_RECEIVED") == false) goto L22;
        SmsMessage[] messages = Telephony.Sms.Intents.getMessagesFromIntent(intent);
        if (messages != null) goto L16;
        Log.e(TAG, "Message does not exist in the intent");
        return;
    L16:
        int r1 = messages.length;
        int r5 = 0;
    L18:
        if (r5 >= r1) goto L27;
        SmsMessage message = messages[r5];
        byte[] suplInit = message.getUserData();
        injectSuplInit(suplInit, slotIndex);
        r5 = r5 + 1;
        goto L18
    L27:
        return;
    L22:
        if (action.equals("android.provider.Telephony.WAP_PUSH_RECEIVED") == false) goto L26;
        byte[] suplInit2 = intent.getByteArrayExtra("data");
        injectSuplInit(suplInit2, slotIndex);
        return;
    }

    private void injectSuplInit(byte[] suplInit, int slotIndex) {
        if (suplInit != null) goto L4;
        return;
    L4:
        if (DEBUG == false) goto L6;
        Log.d(TAG, "suplInit = " + HexDump.toHexString(suplInit) + " slotIndex = " + slotIndex);
    L6:
        this.mGnssNative.injectNiSuplMessageData(suplInit, suplInit.length, slotIndex);
    }

    private boolean isNfwLocationAccessAllowed() {
        if (this.mGnssNative.isInEmergencySession() == false) goto L6;
        return true;
    L6:
        if (this.mGnssVisibilityControl != null) goto L8;
        return false;
    L8:
        if (this.mGnssVisibilityControl.hasLocationPermissionEnabledProxyApps() == false) goto L12;
        return true;
    L12:
        return false;
    }

    @Override // com.android.server.location.gnss.NetworkTimeHelper.InjectTimeCallback
    public void injectTime(long unixEpochTimeMillis, long elapsedRealtimeMillis, int uncertaintyMillis) {
        this.mGnssNative.injectTime(unixEpochTimeMillis, elapsedRealtimeMillis, uncertaintyMillis);
    }

    private void onNetworkAvailable() {
        this.mNetworkTimeHelper.onNetworkAvailable();
        if (this.mSupportsPsds == false) goto L17;
        Object r0 = this.mLock;
        monitor-enter(r0);
        Iterator<Integer> r1 = this.mPendingDownloadPsdsTypes.iterator();     // Catch: Throwable -> L10
    L8:
        if (r1.hasNext() == false) goto L12;
        final int psdsType = r1.next().intValue();     // Catch: Throwable -> L10
        postWithWakeLockHeld(new GnssLocationProvider$$ExternalSyntheticLambda19(this, psdsType));     // Catch: Throwable -> L10
        LocationLogsRecorder.getInstance().writeLocationLogsAsync(LocationLogsRecorder.KEY_FILE_GNSS, "network available, try to download PSDS, type: " + psdsType);     // Catch: Throwable -> L10
        goto L8
    L12:
        this.mPendingDownloadPsdsTypes.clear();     // Catch: Throwable -> L10
        monitor-exit(r0);     // Catch: Throwable -> L10
        return;
    L10:
        th = move-exception;
        throw th;
    }

    private /* synthetic */ void lambda$onNetworkAvailable$1(int psdsType) {
        handleDownloadPsdsData(psdsType);
    }

    private void handleRequestLocation(boolean independentFromGnss, boolean isUserEmergency) {
        if (isRequestLocationRateLimited() == false) goto L9;
        if (DEBUG == false) goto L33;
        Log.d(TAG, "RequestLocation is denied due to too frequent requests.");
        return;
    L33:
        return;
    L9:
        if (independentFromGnss == true) goto L11;
    L14:
        ContentResolver resolver = this.mContext.getContentResolver();
        long durationMillis = Settings.Global.getLong(resolver, "gnss_hal_location_request_duration_millis", 10000);
        if (durationMillis != 0) goto L18;
        Log.i(TAG, "GNSS HAL location request is disabled by Settings.");
        return;
    L18:
        LocationManager locationManager = (LocationManager) this.mContext.getSystemService(LocationLogsRecorder.KEY_FILE_LOCATION);
        LocationRequest.Builder locationRequest = new LocationRequest.Builder(1000).setMaxUpdates(1);
        if (independentFromGnss == false) goto L21;
        String provider = "network";
        LocationListener locationListener = new GnssLocationProvider$$ExternalSyntheticLambda14();
        locationRequest.setQuality(104);
    L23:
        if (this.mNIHandler.getInEmergency() == false) goto L29;
        GnssConfiguration.HalInterfaceVersion halVersion = this.mGnssConfiguration.getHalInterfaceVersion();
        if (isUserEmergency == false) goto L27;
    L28:
        locationRequest.setLocationSettingsIgnored(true);
        durationMillis = durationMillis * 3;
        goto L29
    L27:
        if (halVersion.mMajor < 2) goto L28;
    L29:
        locationRequest.setDurationMillis(durationMillis);
        Log.i(TAG, String.format("GNSS HAL Requesting location updates from %s provider for %d millis.", new Object[]{provider, Long.valueOf(durationMillis)}));
        LocationLogsRecorder.getInstance().writeLocationLogsAsync(LocationLogsRecorder.KEY_FILE_GNSS, "GNSS HAL Requesting location updates from " + provider + " provider for " + durationMillis + " millis.");
        LocationCldReport.getInstance().addNfwRequestNum();
        if (locationManager.getProvider(provider) == null) goto L34;
        locationManager.requestLocationUpdates(provider, locationRequest.build(), ConcurrentUtils.DIRECT_EXECUTOR, locationListener);
        return;
    L34:
        return;
    L21:
        provider = "fused";
        locationListener = new GnssLocationProvider$$ExternalSyntheticLambda15(this);
        locationRequest.setQuality(100);
        goto L23
    L11:
        if (StarLocation.getInstance().isNetworkValid() == true) goto L14;
        LocationLogsRecorder.getInstance().writeLocationLogsAsync(LocationLogsRecorder.KEY_FILE_GNSS, "ignore ODCPI request while network is Invalid");
    }

    private static /* synthetic */ void lambda$handleRequestLocation$2(Location location) {
    }

    private void injectBestLocation(Location location) {
        if (DEBUG == false) goto L6;
        Log.d(TAG, "injectBestLocation: " + location);
    L6:
        if (location.isMock() == false) goto L8;
        return;
    L8:
        LocationLogsRecorder.getInstance().writeLocationLogsAsync(LocationLogsRecorder.KEY_FILE_GNSS, "injectBestLocation " + location);
        this.mGnssNative.injectBestLocation(location);
    }

    private boolean isRequestLocationRateLimited() {
        return false;
    }

    private void handleDownloadPsdsData(final int psdsType) {
        if (this.mSupportsPsds == true) goto L7;
        Log.d(TAG, "handleDownloadPsdsData() called when PSDS not supported");
        return;
    L7:
        if (this.mNetworkConnectivityHandler.isDataNetworkConnected() == true) goto L16;
        Object r0 = this.mLock;
        monitor-enter(r0);
        this.mPendingDownloadPsdsTypes.add(Integer.valueOf(psdsType));     // Catch: Throwable -> L13
        monitor-exit(r0);     // Catch: Throwable -> L13
        return;
    L13:
        th = move-exception;
        throw th;
    L16:
        Object r1 = this.mLock;
        monitor-enter(r1);
    L23:
        th = move-exception;
        throw th;
    L19:
        if (this.mDownloadInProgressPsdsTypes.contains(Integer.valueOf(psdsType)) == true) goto L21;
        this.mDownloadPsdsWakeLock.acquire(60000);     // Catch: Throwable -> L23
        this.mDownloadInProgressPsdsTypes.add(Integer.valueOf(psdsType));     // Catch: Throwable -> L23
        monitor-exit(r1);     // Catch: Throwable -> L23
        Log.i(TAG, "WakeLock acquired by handleDownloadPsdsData()");
        Executors.newSingleThreadExecutor().execute(new GnssLocationProvider$$ExternalSyntheticLambda0(this, psdsType));
        return;
    L21:
        if (DEBUG == false) goto L25;
        Log.d(TAG, "PSDS type " + psdsType + " download in progress. Ignore the request.");     // Catch: Throwable -> L23
    L25:
        monitor-exit(r1);     // Catch: Throwable -> L23
    }

    private /* synthetic */ void lambda$handleDownloadPsdsData$6(final int psdsType) {
        GnssPsdsDownloader psdsDownloader = new GnssPsdsDownloader(this.mGnssConfiguration.getProperties());
        final byte[] data = psdsDownloader.downloadPsdsData(psdsType);
        if (data == null) goto L17;
        this.mHandler.post(new GnssLocationProvider$$ExternalSyntheticLambda16(this, psdsType, data));
        PackageManager pm = this.mContext.getPackageManager();
        if (pm != null) goto L7;
    L22:
        Object r3 = this.mLock;
        monitor-enter(r3);
    L29:
        th = move-exception;
        throw th;
    L25:
        if (this.mDownloadPsdsWakeLock.isHeld() == false) goto L31;
        this.mDownloadPsdsWakeLock.release();     // Catch: Throwable -> L29
        if (DEBUG == false) goto L32;
        Log.d(TAG, "WakeLock released by handleDownloadPsdsData()");     // Catch: Throwable -> L29
    L32:
        this.mDownloadInProgressPsdsTypes.remove(Integer.valueOf(psdsType));     // Catch: Throwable -> L29
        monitor-exit(r3);     // Catch: Throwable -> L29
        return;
    L31:
        Log.e(TAG, "WakeLock expired before release in handleDownloadPsdsData()");     // Catch: Throwable -> L29
        goto L32
    L7:
        if (pm.hasSystemFeature("android.hardware.type.watch") == false) goto L22;
        if (psdsType != 1) goto L22;
        if (this.mGnssConfiguration.isPsdsPeriodicDownloadEnabled() == false) goto L22;
        if (DEBUG == false) goto L15;
        Log.d(TAG, "scheduling next long term Psds download");
    L15:
        this.mHandler.removeCallbacksAndMessages(this.mPsdsPeriodicDownloadToken);
        this.mHandler.postDelayed(new GnssLocationProvider$$ExternalSyntheticLambda17(this, psdsType), this.mPsdsPeriodicDownloadToken, 86400000);
        goto L22
    L17:
        Object r2 = this.mLock;
        monitor-enter(r2);
        long backoffMillis = this.mPsdsBackOff.nextBackoffMillis();     // Catch: Throwable -> L37
        monitor-exit(r2);     // Catch: Throwable -> L37
        this.mHandler.postDelayed(new GnssLocationProvider$$ExternalSyntheticLambda18(this, psdsType), backoffMillis);
    L37:
        th = move-exception;
        throw th;
    }

    private /* synthetic */ void lambda$handleDownloadPsdsData$3(int psdsType, byte[] data) {
        FrameworkStatsLog.write(FrameworkStatsLog.GNSS_PSDS_DOWNLOAD_REPORTED, psdsType);
        if (DEBUG == false) goto L5;
        Log.d(TAG, "calling native_inject_psds_data");
    L5:
        LocationLogsRecorder.getInstance().writeLocationLogsAsync(LocationLogsRecorder.KEY_FILE_GNSS, "injectPsdsData, data length is: " + data.length + " bytes, psdsType is: " + psdsType);
        this.mGnssNative.injectPsdsData(data, data.length, psdsType);
        Object r0 = this.mLock;
        monitor-enter(r0);
        this.mPsdsBackOff.reset();     // Catch: Throwable -> L10
        monitor-exit(r0);     // Catch: Throwable -> L10
        return;
    L10:
        th = move-exception;
        throw th;
    }

    private /* synthetic */ void lambda$handleDownloadPsdsData$4(int psdsType) {
        handleDownloadPsdsData(psdsType);
    }

    private /* synthetic */ void lambda$handleDownloadPsdsData$5(int psdsType) {
        handleDownloadPsdsData(psdsType);
    }

    private void injectLocation(Location location) {
        if (location.isMock() == true) goto L6;
        this.mGnssNative.injectLocation(location);
        LocationLogsRecorder.getInstance().writeLocationLogsAsync(LocationLogsRecorder.KEY_FILE_GNSS, "injectLocation " + location);
        return;
    }

    private void setSuplHostPort() {
        this.mSuplServerHost = this.mGnssConfiguration.getSuplHost();
        this.mSuplServerPort = this.mGnssConfiguration.getSuplPort(0);
        if (this.mSuplServerHost != null) goto L5;
        return;
    L5:
        if (this.mSuplServerPort > 0) goto L7;
        return;
    L7:
        if (this.mSuplServerPort > 65535) goto L12;
        this.mGnssNative.setAgpsServer(1, this.mSuplServerHost, this.mSuplServerPort);
        LocationLogsRecorder.getInstance().writeLocationLogsAsync(LocationLogsRecorder.KEY_FILE_GNSS, "set supl " + this.mSuplServerHost + ":" + this.mSuplServerPort);
        return;
    }

    private int getSuplMode(boolean agpsEnabled) {
        if (agpsEnabled == false) goto L13;
        int suplMode = this.mGnssConfiguration.getSuplMode(0);
        if (suplMode != 0) goto L8;
        return 0;
    L8:
        if (this.mGnssNative.getCapabilities().hasMsb() == false) goto L13;
        if ((suplMode & 1) == 0) goto L13;
        return 1;
    L13:
        return 0;
    }

    private void setGpsEnabled(boolean enabled) {
        Object r0 = this.mLock;
        monitor-enter(r0);
        this.mGpsEnabled = enabled;     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    public void setAutomotiveGnssSuspended(boolean suspended) {
        Object r0 = this.mLock;
        monitor-enter(r0);
        this.mAutomotiveSuspend = suspended;     // Catch: Throwable -> L8
        monitor-exit(r0);     // Catch: Throwable -> L8
        this.mHandler.post(new GnssLocationProvider$$ExternalSyntheticLambda8(this));
        return;
    L8:
        th = move-exception;
        throw th;
    }

    public boolean isAutomotiveGnssSuspended() {
        Object r0 = this.mLock;
        monitor-enter(r0);
    L9:
        th = move-exception;
        throw th;
    L5:
        if (this.mAutomotiveSuspend == true) goto L7;
    L11:
        boolean r1 = false;
    L12:
        monitor-exit(r0);     // Catch: Throwable -> L9
        return r1;
    L7:
        if (this.mGpsEnabled == true) goto L11;
        r1 = true;
        goto L12
    }

    private void handleEnable() {
        if (DEBUG == false) goto L5;
        Log.d(TAG, "handleEnable");
    L5:
        boolean inited = this.mGnssNative.init();
        boolean r2 = false;
        if (inited == false) goto L21;
        setGpsEnabled(true);
        this.mSupportsPsds = this.mGnssNative.isPsdsSupported();
        if (this.mSuplServerHost == null) goto L11;
        this.mGnssNative.setAgpsServer(1, this.mSuplServerHost, this.mSuplServerPort);
    L11:
        if (this.mC2KServerHost == null) goto L14;
        this.mGnssNative.setAgpsServer(2, this.mC2KServerHost, this.mC2KServerPort);
    L14:
        if (this.mGnssNative.initBatching() == true) goto L16;
    L18:
        this.mBatchingEnabled = r2;
        if (this.mGnssVisibilityControl == null) goto L23;
        this.mGnssVisibilityControl.onGpsEnabledChanged(true);
        return;
    L23:
        return;
    L16:
        if (this.mGnssNative.getBatchSize() <= 1) goto L18;
        r2 = true;
        goto L18
    L21:
        setGpsEnabled(false);
        Log.w(TAG, "Failed to enable location provider");
    }

    private void handleDisable() {
        if (DEBUG == false) goto L5;
        Log.d(TAG, "handleDisable");
    L5:
        setGpsEnabled(false);
        updateClientUids(new WorkSource());
        stopNavigating();
        stopBatching();
        if (this.mGnssVisibilityControl == null) goto L8;
        this.mGnssVisibilityControl.onGpsEnabledChanged(false);
    L8:
        this.mGnssNative.cleanupBatching();
        this.mGnssNative.cleanup();
    }

    private void updateEnabled() {
        boolean enabled = false;
        LocationManager locationManager = (LocationManager) this.mContext.getSystemService(LocationManager.class);
        Set<UserHandle> visibleUserHandles = ((UserManager) this.mContext.getSystemService(UserManager.class)).getVisibleUsers();
        Iterator<UserHandle> r3 = visibleUserHandles.iterator();
    L4:
        if (r3.hasNext() == false) goto L6;
        UserHandle visibleUserHandle = r3.next();
        enabled = enabled | locationManager.isLocationEnabledForUser(visibleUserHandle);
        goto L4
    L6:
        boolean r4 = false;
        if (this.mProviderRequest != null) goto L9;
    L13:
        boolean r5 = false;
    L14:
        boolean enabled2 = enabled | r5;
        Object r6 = this.mLock;
        monitor-enter(r6);
    L33:
        th = move-exception;
        throw th;
    L17:
        if (this.mAutomotiveSuspend == true) goto L19;
        r4 = true;
    L19:
        boolean enabled3 = enabled2 & r4;     // Catch: Throwable -> L33
        monitor-exit(r6);     // Catch: Throwable -> L33
        boolean enabled4 = enabled3 & (!this.mShutdown);
        if (enabled4 != isGpsEnabled()) goto L24;
        return;
    L24:
        if (enabled4 == false) goto L26;
        handleEnable();
    L27:
        LocationLogsRecorder r7 = LocationLogsRecorder.getInstance();
        StringBuilder r8 = new StringBuilder();
        if (enabled4 == false) goto L30;
        String r9 = "enable";
    L31:
        r8.append(r9);
        r8.append(" gnss");
        r7.writeLocationLogsAsync(LocationLogsRecorder.KEY_FILE_GNSS, r8.toString());
        return;
    L30:
        r9 = "disable";
        goto L31
    L26:
        handleDisable();
        goto L27
    L9:
        if (this.mProviderRequest.isActive() == false) goto L13;
        if (this.mProviderRequest.isBypass() == false) goto L13;
        r5 = true;
        goto L14
    }

    private boolean isGpsEnabled() {
        Object r0 = this.mLock;
        monitor-enter(r0);
        boolean r1 = this.mGpsEnabled;     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r1;
    L7:
        th = move-exception;
        throw th;
    }

    public int getBatchSize() {
        return this.mGnssNative.getBatchSize();
    }

    @Override // com.android.server.location.provider.AbstractLocationProvider
    protected void onFlush(Runnable listener) {
        boolean added = false;
        Object r1 = this.mLock;
        monitor-enter(r1);
    L7:
        th = move-exception;
        throw th;
    L5:
        if (this.mBatchingEnabled == false) goto L9;
        added = this.mFlushListeners.add(listener);     // Catch: Throwable -> L7
    L9:
        monitor-exit(r1);     // Catch: Throwable -> L7
        if (added == true) goto L12;
        listener.run();
        return;
    L12:
        this.mGnssNative.flushBatch();
    }

    @Override // com.android.server.location.provider.AbstractLocationProvider
    public void onSetRequest(ProviderRequest request) {
        this.mProviderRequest = request;
        updateEnabled();
        updateRequirements();
    }

    private void updateRequirements() {
        if (this.mProviderRequest != null) goto L5;
        return;
    L5:
        if (this.mProviderRequest.getWorkSource() != null) goto L8;
        return;
    L8:
        if (DEBUG == false) goto L11;
        Log.d(TAG, "setRequest " + this.mProviderRequest);
    L11:
        if (this.mProviderRequest.isActive() == true) goto L13;
    L37:
        updateClientUids(new WorkSource());
        stopNavigating();
        stopBatching();
    L38:
        LocationEventsTracker.getInstance().trackGnssPositioning(6, new int[]{this.mFixInterval});
        return;
    L13:
        if (isGpsEnabled() == false) goto L37;
        updateClientUids(this.mProviderRequest.getWorkSource());
        if (this.mProviderRequest.getIntervalMillis() > 2147483647L) goto L17;
        this.mFixInterval = (int) this.mProviderRequest.getIntervalMillis();
    L18:
        int batchIntervalMs = Math.max(this.mFixInterval, 1000);
        long batchLengthMs = Math.min(this.mProviderRequest.getMaxUpdateDelayMillis(), 86400000);
        if (this.mBatchingEnabled == true) goto L21;
    L23:
        stopBatching();
        if (this.mStarted == false) goto L31;
        if (this.mGnssNative.getCapabilities().hasScheduling() == false) goto L31;
        if (setPositionMode(this.mPositionMode, 0, this.mFixInterval, this.mProviderRequest.isLowPower()) == true) goto L38;
        Log.e(TAG, "set_position_mode failed in updateRequirements");
    L31:
        if (this.mStarted == true) goto L33;
        startNavigating();
        goto L38
    L33:
        this.mAlarmManager.cancel(this.mTimeoutListener);
        if (this.mFixInterval < 60000) goto L38;
        this.mAlarmManager.set(2, SystemClock.elapsedRealtime() + 60000, TAG, this.mTimeoutListener, this.mHandler);
        goto L38
    L21:
        if ((batchLengthMs / 2) < batchIntervalMs) goto L23;
        stopNavigating();
        this.mFixInterval = batchIntervalMs;
        startBatching(batchLengthMs);
        goto L38
    L17:
        Log.w(TAG, "interval overflow: " + this.mProviderRequest.getIntervalMillis());
        this.mFixInterval = Integer.MAX_VALUE;
        goto L18
    }

    private boolean setPositionMode(int mode, int recurrence, int minInterval, boolean lowPowerMode) {
        GnssPositionMode positionMode = new GnssPositionMode(mode, recurrence, minInterval, 0, 0, lowPowerMode);
        if (this.mLastPositionMode != null) goto L5;
    L8:
        boolean result = this.mGnssNative.setPositionMode(mode, recurrence, minInterval, 0, 0, lowPowerMode);
        LocationLogsRecorder.getInstance().writeLocationLogsAsync(LocationLogsRecorder.KEY_FILE_GNSS, "setPositionMode, mode: " + mode + ", recurrence: " + recurrence + ", minInterval: " + minInterval + ", lowPowerMode: " + lowPowerMode);
        if (result == false) goto L11;
        this.mLastPositionMode = positionMode;
    L12:
        return result;
    L11:
        this.mLastPositionMode = null;
        goto L12
    L5:
        if (this.mLastPositionMode.equals(positionMode) == false) goto L8;
        return true;
    }

    private void updateClientUids(WorkSource source) {
        if (source.equals(this.mClientSource) == false) goto L49;
        return;
    L49:
        this.mBatteryStats.noteGpsChanged(this.mClientSource, source);     // Catch: RemoteException -> L7
    L9:
        List<WorkSource.WorkChain>[] diffs = WorkSource.diffChains(this.mClientSource, source);
        if (diffs == null) goto L29;
        List<WorkSource.WorkChain> newChains = diffs[0];
        List<WorkSource.WorkChain> goneChains = diffs[1];
        if (newChains == null) goto L20;
        Iterator<WorkSource.WorkChain> r6 = newChains.iterator();
    L15:
        if (r6.hasNext() == false) goto L20;
        WorkSource.WorkChain newChain = r6.next();
        this.mAppOps.startOpNoThrow(2, newChain.getAttributionUid(), newChain.getAttributionTag());
        SysMonitorSvcBridge.getFactory().getSmartPowerDataInstance().noteStartGps(newChain.getAttributionUid(), newChain.getAttributionTag());
        SysOptBridge.getFactory().getSmartScenes().noteStartGps(newChain.getAttributionUid());
        IBytedancePowerAdvisor powerAdvisor = SysOptBridge.getFactory().getBytedancePowerAdvisorInstance();
        if (powerAdvisor == null) goto L15;
        powerAdvisor.noteGpsChanged(newChain.getAttributionUid(), true);
    L20:
        if (goneChains == null) goto L28;
        Iterator<WorkSource.WorkChain> r7 = goneChains.iterator();
    L23:
        if (r7.hasNext() == false) goto L28;
        WorkSource.WorkChain goneChain = r7.next();
        this.mAppOps.finishOp(2, goneChain.getAttributionUid(), goneChain.getAttributionTag());
        SysMonitorSvcBridge.getFactory().getSmartPowerDataInstance().noteStopGps(goneChain.getAttributionUid(), goneChain.getAttributionTag());
        SysOptBridge.getFactory().getSmartScenes().noteStopGps(goneChain.getAttributionUid());
        IBytedancePowerAdvisor powerAdvisor2 = SysOptBridge.getFactory().getBytedancePowerAdvisorInstance();
        if (powerAdvisor2 == null) goto L23;
        powerAdvisor2.noteGpsChanged(goneChain.getAttributionUid(), false);
    L28:
        this.mClientSource.transferWorkChains(source);
    L29:
        WorkSource[] changes = this.mClientSource.setReturningDiffs(source);
        if (changes == null) goto L48;
        WorkSource newWork = changes[0];
        WorkSource goneWork = changes[1];
        if (newWork == null) goto L40;
        int i = 0;
    L35:
        if (i >= newWork.size()) goto L40;
        this.mAppOps.startOpNoThrow(2, newWork.getUid(i), newWork.getPackageName(i));
        SysMonitorSvcBridge.getFactory().getSmartPowerDataInstance().noteStartGps(newWork.getUid(i), newWork.getPackageName(i));
        SysOptBridge.getFactory().getSmartScenes().noteStartGps(newWork.get(i));
        IBytedancePowerAdvisor powerAdvisor3 = SysOptBridge.getFactory().getBytedancePowerAdvisorInstance();
        if (powerAdvisor3 == null) goto L39;
        powerAdvisor3.noteGpsChanged(newWork.getUid(i), true);
    L39:
        i = i + 1;
    L40:
        if (goneWork == null) goto L67;
        int i2 = 0;
    L43:
        if (i2 >= goneWork.size()) goto L68;
        this.mAppOps.finishOp(2, goneWork.getUid(i2), goneWork.getPackageName(i2));
        SysMonitorSvcBridge.getFactory().getSmartPowerDataInstance().noteStopGps(goneWork.getUid(i2), goneWork.getPackageName(i2));
        SysOptBridge.getFactory().getSmartScenes().noteStopGps(goneWork.get(i2));
        IBytedancePowerAdvisor powerAdvisor4 = SysOptBridge.getFactory().getBytedancePowerAdvisorInstance();
        if (powerAdvisor4 == null) goto L47;
        powerAdvisor4.noteGpsChanged(goneWork.getUid(i2), false);
    L47:
        i2 = i2 + 1;
        goto L43
    L68:
        return;
    L67:
        return;
    L48:
        return;
    L7:
        e = move-exception;
        Log.w(TAG, "RemoteException", e);
        goto L9
    }

    @Override // com.android.server.location.provider.AbstractLocationProvider
    public void onExtraCommand(int uid, int pid, String command, Bundle extras) {
        LocationLogsRecorder.getInstance().writeLocationLogsAsync(LocationLogsRecorder.KEY_FILE_GNSS, "extraCommand " + command);
        if ("delete_aiding_data".equals(command) == false) goto L10;
        if (Build.IS_USER == true) goto L7;
    L8:
        deleteAidingData(extras);
        return;
    L7:
        if (StarLocation.getInstance().isCtsGnssTestCaller(uid, pid) == true) goto L8;
        return;
    L10:
        if ("force_time_injection".equals(command) == false) goto L13;
        demandUtcTimeInjection();
        return;
    L13:
        if ("force_psds_injection".equals(command) == false) goto L18;
        if (this.mSupportsPsds == false) goto L25;
        postWithWakeLockHeld(new GnssLocationProvider$$ExternalSyntheticLambda5(this));
        return;
    L25:
        return;
    L18:
        if ("request_power_stats".equals(command) == false) goto L20;
        this.mGnssNative.requestPowerStats(new SystemServerInitThreadPool$$ExternalSyntheticLambda0(), new GnssLocationProvider$$ExternalSyntheticLambda6());
        return;
    L20:
        Log.w(TAG, "sendExtraCommand: unknown command " + command);
    }

    private /* synthetic */ void lambda$onExtraCommand$7() {
        handleDownloadPsdsData(1);
    }

    private static /* synthetic */ void lambda$onExtraCommand$8(GnssPowerStats powerStats) {
    }

    private void deleteAidingData(Bundle extras) {
        if (extras != null) goto L4;
        int flags = 65535;
    L43:
        if (flags == 0) goto L46;
        this.mGnssNative.deleteAidingData(flags);
        LocationLogsRecorder.getInstance().writeLocationLogsAsync(LocationLogsRecorder.KEY_FILE_GNSS, "delete aiding data, flag: " + flags);
        return;
    L46:
        return;
    L4:
        flags = 0;
        if (extras.getBoolean("ephemeris") == false) goto L8;
        flags = 0 | 1;
    L8:
        if (extras.getBoolean("almanac") == false) goto L11;
        flags = flags | 2;
    L11:
        if (extras.getBoolean("position") == false) goto L14;
        flags = flags | 4;
    L14:
        if (extras.getBoolean("time") == false) goto L17;
        flags = flags | 8;
    L17:
        if (extras.getBoolean("iono") == false) goto L20;
        flags = flags | 16;
    L20:
        if (extras.getBoolean("utc") == false) goto L23;
        flags = flags | 32;
    L23:
        if (extras.getBoolean("health") == false) goto L26;
        flags = flags | 64;
    L26:
        if (extras.getBoolean("svdir") == false) goto L29;
        flags = flags | 128;
    L29:
        if (extras.getBoolean("svsteer") == false) goto L32;
        flags = flags | 256;
    L32:
        if (extras.getBoolean("sadata") == false) goto L35;
        flags = flags | 512;
    L35:
        if (extras.getBoolean("rti") == false) goto L38;
        flags = flags | 1024;
    L38:
        if (extras.getBoolean("celldb-info") == false) goto L41;
        flags = flags | 32768;
    L41:
        if (extras.getBoolean(IZswContentProviderHelper.DUMP_ALL) == false) goto L43;
        flags = flags | 65535;
        goto L43
    }

    private void startNavigating() {
        if (this.mStarted == false) goto L5;
        return;
    L5:
        if (DEBUG == false) goto L7;
        Log.d(TAG, "startNavigating");
    L7:
        this.mTimeToFirstFix = 0;
        this.mLastFixTime = 0;
        boolean agpsEnabled = true;
        setStarted(true);
        this.mPositionMode = 0;
        if (Settings.Global.getInt(this.mContext.getContentResolver(), "assisted_gps_enabled", 1) != 0) goto L11;
        agpsEnabled = false;
    L11:
        this.mPositionMode = getSuplMode(agpsEnabled);
        if (DEBUG == false) goto L21;
        switch(this.mPositionMode) {
            case 0: goto L18;
            case 1: goto L17;
            case 2: goto L16;
            default: goto L15;
        };
    L15:
        String mode = "unknown";
    L19:
        Log.d(TAG, "setting position_mode to " + mode);
        goto L21
    L16:
        mode = "MS_ASSISTED";
        goto L19
    L17:
        mode = "MS_BASED";
        goto L19
    L18:
        mode = "standalone";
    L21:
        if (this.mGnssNative.getCapabilities().hasScheduling() == false) goto L23;
        int interval = this.mFixInterval;
    L25:
        if (setPositionMode(this.mPositionMode, 0, interval, this.mProviderRequest.isLowPower()) == true) goto L29;
        setStarted(false);
        Log.e(TAG, "set_position_mode failed in startNavigating()");
        return;
    L29:
        if (this.mGnssNative.start() == true) goto L32;
        setStarted(false);
        Log.e(TAG, "native_start failed in startNavigating()");
        return;
    L32:
        this.mLocationExtras.reset();
        this.mFixRequestTime = SystemClock.elapsedRealtime();
        if (this.mGnssNative.getCapabilities().hasScheduling() == false) goto L35;
        return;
    L35:
        if (this.mFixInterval < 60000) goto L40;
        this.mAlarmManager.set(2, SystemClock.elapsedRealtime() + 60000, TAG, this.mTimeoutListener, this.mHandler);
        return;
    L40:
        return;
    L23:
        interval = 1000;
        goto L25
    }

    private void stopNavigating() {
        if (DEBUG == false) goto L6;
        Log.d(TAG, "stopNavigating");
    L6:
        if (this.mStarted == false) goto L8;
        setStarted(false);
        this.mGnssNative.stop();
        this.mLastFixTime = 0;
        this.mLastPositionMode = null;
        this.mLocationExtras.reset();
    L8:
        this.mAlarmManager.cancel(this.mTimeoutListener);
        this.mAlarmManager.cancel(this.mWakeupListener);
    }

    private void startBatching(final long batchLengthMs) {
        long batchSize = batchLengthMs / ((long) this.mFixInterval);
        if (DEBUG == false) goto L6;
        Log.d(TAG, "startBatching " + this.mFixInterval + " " + batchLengthMs);
    L6:
        if (this.mGnssNative.startBatch(TimeUnit.MILLISECONDS.toNanos(this.mFixInterval), 0.0f, true) == false) goto L10;
        this.mBatchingStarted = true;
        if (batchSize >= getBatchSize()) goto L12;
        this.mBatchingAlarm = new GnssLocationProvider$$ExternalSyntheticLambda10(this, batchLengthMs);
        this.mAlarmManager.setExact(2, SystemClock.elapsedRealtime() + batchLengthMs, TAG, this.mBatchingAlarm, FgThread.getHandler());
        return;
    L12:
        return;
    L10:
        Log.e(TAG, "native_start_batch failed in startBatching()");
    }

    private /* synthetic */ void lambda$startBatching$9(long batchLengthMs) {
        boolean flush = false;
        Object r2 = this.mLock;
        monitor-enter(r2);
    L7:
        th = move-exception;
        throw th;
    L5:
        if (this.mBatchingAlarm == null) goto L9;
        flush = true;
        this.mAlarmManager.setExact(2, SystemClock.elapsedRealtime() + batchLengthMs, TAG, this.mBatchingAlarm, FgThread.getHandler());     // Catch: Throwable -> L7
    L9:
        monitor-exit(r2);     // Catch: Throwable -> L7
        if (flush == false) goto L17;
        this.mGnssNative.flushBatch();
        return;
    }

    private void stopBatching() {
        if (DEBUG == false) goto L6;
        Log.d(TAG, "stopBatching");
    L6:
        if (this.mBatchingStarted == true) goto L8;
        return;
    L8:
        if (this.mBatchingAlarm == null) goto L10;
        this.mAlarmManager.cancel(this.mBatchingAlarm);
        this.mBatchingAlarm = null;
    L10:
        this.mGnssNative.flushBatch();
        this.mGnssNative.stopBatch();
        this.mBatchingStarted = false;
    }

    private void setStarted(boolean started) {
        if (this.mStarted == started) goto L6;
        this.mStarted = started;
        this.mStartedChangedElapsedRealtime = SystemClock.elapsedRealtime();
        return;
    }

    private void hibernate() {
        stopNavigating();
        long now = SystemClock.elapsedRealtime();
        this.mAlarmManager.set(2, now + ((long) this.mFixInterval), TAG, this.mWakeupListener, this.mHandler);
    }

    private void handleReportLocation(boolean hasLatLong, Location location) {
        if (VERBOSE == false) goto L5;
        Log.v(TAG, "reportLocation " + location.toString());
    L5:
        location.setExtras(this.mLocationExtras.getBundle());
        reportLocation(LocationResult.wrap(new Location[]{location}).validate());     // Catch: LocationResult.BadLocationException -> L50
        if (this.mStarted == false) goto L17;
        this.mGnssMetrics.logReceivedLocationStatus(hasLatLong);
        if (hasLatLong == true) goto L12;
    L23:
        this.mLastFixTime = SystemClock.elapsedRealtime();
        if (this.mTimeToFirstFix != 0) goto L33;
        if (hasLatLong == false) goto L33;
        this.mTimeToFirstFix = (int) (this.mLastFixTime - this.mFixRequestTime);
        if (DEBUG == false) goto L29;
        Log.d(TAG, "TTFF: " + this.mTimeToFirstFix);
    L29:
        LocationLogsRecorder.getInstance().writeLocationLogsAsync(LocationLogsRecorder.KEY_FILE_GNSS, "TTFF: " + this.mTimeToFirstFix + ", gnss " + location);
        if (this.mStarted == false) goto L33;
        this.mGnssMetrics.logTimeToFirstFixMilliSecs(this.mTimeToFirstFix);
    L33:
        if (this.mStarted == false) goto L40;
        if (this.mGnssNative.getCapabilities().hasScheduling() == true) goto L40;
        if (this.mFixInterval >= 60000) goto L40;
        this.mAlarmManager.cancel(this.mTimeoutListener);
    L40:
        if (this.mGnssNative.getCapabilities().hasScheduling() == false) goto L42;
        return;
    L42:
        if (this.mStarted == true) goto L44;
        return;
    L44:
        if (this.mFixInterval > 10000) goto L46;
        return;
    L46:
        if (DEBUG == false) goto L48;
        Log.d(TAG, "got fix, hibernating");
    L48:
        hibernate();
        return;
    L12:
        if (location.hasAccuracy() == false) goto L15;
        this.mGnssMetrics.logPositionAccuracyMeters(location.getAccuracy());
    L15:
        if (this.mTimeToFirstFix <= 0) goto L23;
        int timeBetweenFixes = (int) (SystemClock.elapsedRealtime() - this.mLastFixTime);
        this.mGnssMetrics.logMissedReports(this.mFixInterval, timeBetweenFixes);
        goto L23
    L17:
        long locationAfterStartedFalseMillis = SystemClock.elapsedRealtime() - this.mStartedChangedElapsedRealtime;
        if (locationAfterStartedFalseMillis <= 2000) goto L23;
        String logMessage = "Unexpected GNSS Location report " + TimeUtils.formatDuration(locationAfterStartedFalseMillis) + " after location turned off";
        if (locationAfterStartedFalseMillis <= LOCATION_OFF_DELAY_THRESHOLD_ERROR_MILLIS) goto L22;
        Log.e(TAG, logMessage);
        goto L23
    L22:
        Log.w(TAG, logMessage);
    L50:
        e = move-exception;
        Log.e(TAG, "Dropping invalid location: " + e);
    }

    private void handleReportSvStatus(GnssStatus gnssStatus) {
        this.mGnssMetrics.logCn0(gnssStatus);
        if (VERBOSE == false) goto L5;
        Log.v(TAG, "SV count: " + gnssStatus.getSatelliteCount());
    L5:
        Set<Pair<Integer, Integer>> satellites = new HashSet();
        int usedInFixCount = 0;
        int maxCn0 = 0;
        int meanCn0 = 0;
        int visibleSvCnt = 0;
        int meanSvCn0 = 0;
        int i = 0;
    L7:
        if (i >= gnssStatus.getSatelliteCount()) goto L18;
        if (gnssStatus.usedInFix(i) == false) goto L15;
        satellites.add(new Pair(Integer.valueOf(gnssStatus.getConstellationType(i)), Integer.valueOf(gnssStatus.getSvid(i))));
        usedInFixCount = usedInFixCount + 1;
        if (gnssStatus.getCn0DbHz(i) <= maxCn0) goto L13;
        maxCn0 = (int) gnssStatus.getCn0DbHz(i);
    L13:
        meanCn0 = (int) (meanCn0 + gnssStatus.getCn0DbHz(i));
        this.mGnssMetrics.logConstellationType(gnssStatus.getConstellationType(i));
    L15:
        if (gnssStatus.getCn0DbHz(i) <= 0.0f) goto L17;
        visibleSvCnt = visibleSvCnt + 1;
        meanSvCn0 = (int) (meanSvCn0 + gnssStatus.getCn0DbHz(i));
    L17:
        i = i + 1;
        goto L7
    L18:
        LocationLogsRecorder r6 = LocationLogsRecorder.getInstance();
        StringBuilder r7 = new StringBuilder();
        r7.append("Visible sv count: ");
        r7.append(visibleSvCnt);
        r7.append(", meanSvCn0: ");
        if (visibleSvCnt <= 0) goto L21;
        int r8 = meanSvCn0 / visibleSvCnt;
    L22:
        r7.append(r8);
        r6.writeLocationLogsAsync(LocationLogsRecorder.KEY_FILE_GNSS, r7.toString());
        if (usedInFixCount <= 0) goto L25;
        meanCn0 = meanCn0 / usedInFixCount;
        LocationLogsRecorder.getInstance().writeLocationLogsAsync(LocationLogsRecorder.KEY_FILE_GNSS, "Used in fix count: " + usedInFixCount + ", maxCn0: " + maxCn0 + ", meanCn0: " + meanCn0);
    L25:
        this.mLocationExtras.set(satellites.size(), meanCn0, maxCn0);
        this.mGnssMetrics.logSvStatus(gnssStatus);
        return;
    L21:
        r8 = 0;
        goto L22
    }

    private void updateNiSuplMessageListenerRegistration(boolean shouldRegister) {
        if (this.mNetworkConnectivityHandler.isNativeAgpsRilSupported() == true) goto L6;
        return;
    L6:
        if (this.mNiSuplMessageListenerRegistered != shouldRegister) goto L8;
        return;
    L8:
        IntentFilter wapPushNiIntentFilter = new IntentFilter();
        wapPushNiIntentFilter.addAction("android.provider.Telephony.WAP_PUSH_RECEIVED");
        wapPushNiIntentFilter.addDataType("application/vnd.omaloc-supl-init");     // Catch: IntentFilter.MalformedMimeTypeException -> L11
    L13:
        IntentFilter mtSmsNiIntentFilter = new IntentFilter();
        mtSmsNiIntentFilter.addAction("android.intent.action.DATA_SMS_RECEIVED");
        mtSmsNiIntentFilter.addDataScheme("sms");
        mtSmsNiIntentFilter.addDataAuthority("localhost", "7275");
        if (shouldRegister == false) goto L16;
        this.mContext.registerReceiver(this.mNiSuplIntentReceiver, wapPushNiIntentFilter, null, this.mHandler);
        this.mContext.registerReceiver(this.mNiSuplIntentReceiver, mtSmsNiIntentFilter, null, this.mHandler);
        this.mNiSuplMessageListenerRegistered = true;
        return;
    L16:
        this.mContext.unregisterReceiver(this.mNiSuplIntentReceiver);
        this.mNiSuplMessageListenerRegistered = false;
        return;
    L12:
        Log.w(TAG, "Malformed SUPL init mime type");
        goto L13
    }

    private void restartLocationRequest() {
        if (DEBUG == false) goto L5;
        Log.d(TAG, "restartLocationRequest");
    L5:
        setStarted(false);
        updateRequirements();
    }

    private void demandUtcTimeInjection() {
        if (DEBUG == false) goto L5;
        Log.d(TAG, "demandUtcTimeInjection");
    L5:
        final NetworkTimeHelper r0 = this.mNetworkTimeHelper;
        r0.getClass();
        postWithWakeLockHeld(new GnssLocationProvider$$ExternalSyntheticLambda21(r0));
    }

    private static int getCellType(CellInfo ci) {
        if ((ci instanceof CellInfoGsm) == false) goto L7;
        return 1;
    L7:
        if ((ci instanceof CellInfoWcdma) == false) goto L11;
        return 4;
    L11:
        if ((ci instanceof CellInfoLte) == false) goto L15;
        return 3;
    L15:
        if ((ci instanceof CellInfoNr) == false) goto L18;
        return 6;
    L18:
        return 0;
    }

    private static long getCidFromCellIdentity(CellIdentity id) {
        if (id != null) goto L5;
        return -1;
    L5:
        long cid = -1;
        switch(id.getType()) {
            case 1: goto L11;
            case 2: goto L13;
            case 3: goto L10;
            case 4: goto L9;
            case 5: goto L13;
            case 6: goto L8;
            default: goto L13;
        };
    L8:
        cid = ((CellIdentityNr) id).getNci();
        goto L13
    L9:
        cid = ((CellIdentityWcdma) id).getCid();
        goto L13
    L10:
        cid = ((CellIdentityLte) id).getCi();
        goto L13
    L11:
        cid = ((CellIdentityGsm) id).getCid();
    L13:
        if (id.getType() != 6) goto L15;
        long r2 = Long.MAX_VALUE;
    L17:
        if (cid != r2) goto L20;
        return -1;
    L20:
        return cid;
    L15:
        r2 = 2147483647L;
        goto L17
    }

    private void setRefLocation(int type, CellIdentity ci) {
        String mcc_str = ci.getMccString();
        String mnc_str = ci.getMncString();
        int r2 = Integer.MAX_VALUE;
        if (mcc_str == null) goto L5;
        int r3 = Integer.parseInt(mcc_str);
    L6:
        int mcc = r3;
        if (mnc_str == null) goto L9;
        r2 = Integer.parseInt(mnc_str);
    L9:
        int mnc = r2;
        switch(type) {
            case 1: goto L15;
            case 2: goto L14;
            case 4: goto L13;
            case 8: goto L12;
            default: goto L11;
        };
    L11:
        int tac = Integer.MAX_VALUE;
        int pcid = Integer.MAX_VALUE;
        int arfcn = Integer.MAX_VALUE;
        long cid = Long.MAX_VALUE;
        int lac = Integer.MAX_VALUE;
    L16:
        this.mGnssNative.setAgpsReferenceLocationCellId(type, mcc, mnc, lac, cid, tac, pcid, arfcn);
        return;
    L12:
        CellIdentityNr cin = (CellIdentityNr) ci;
        long cid2 = cin.getNci();
        int tac2 = cin.getTac();
        int pcid2 = cin.getPci();
        int arfcn2 = cin.getNrarfcn();
        tac = tac2;
        pcid = pcid2;
        arfcn = arfcn2;
        cid = cid2;
        lac = Integer.MAX_VALUE;
        goto L16
    L13:
        CellIdentityLte cil = (CellIdentityLte) ci;
        long cid3 = cil.getCi();
        int tac3 = cil.getTac();
        int pcid3 = cil.getPci();
        tac = tac3;
        pcid = pcid3;
        arfcn = Integer.MAX_VALUE;
        cid = cid3;
        lac = Integer.MAX_VALUE;
        goto L16
    L14:
        CellIdentityWcdma ciw = (CellIdentityWcdma) ci;
        long cid4 = ciw.getCid();
        int lac2 = ciw.getLac();
        tac = Integer.MAX_VALUE;
        pcid = Integer.MAX_VALUE;
        arfcn = Integer.MAX_VALUE;
        cid = cid4;
        lac = lac2;
        goto L16
    L15:
        CellIdentityGsm cig = (CellIdentityGsm) ci;
        long cid5 = cig.getCid();
        int lac3 = cig.getLac();
        tac = Integer.MAX_VALUE;
        pcid = Integer.MAX_VALUE;
        arfcn = Integer.MAX_VALUE;
        cid = cid5;
        lac = lac3;
        goto L16
    L5:
        r3 = Integer.MAX_VALUE;
        goto L6
    }

    private void requestRefLocation() {
        TelephonyManager phone = (TelephonyManager) this.mContext.getSystemService(HintsHelper.AUTOFILL_HINT_PHONE);
        int phoneType = phone.getPhoneType();
        if (phoneType != 1) goto L35;
        LocationLogsRecorder.getInstance().writeLocationLogsAsync(LocationLogsRecorder.KEY_FILE_GNSS, "request Cell Location");
        List<CellInfo> cil = phone.getAllCellInfo();
        if (cil == null) goto L33;
        HashMap<Integer, CellIdentity> cellIdentityMap = new HashMap();
        cil.sort(Comparator.comparingInt(new GnssLocationProvider$$ExternalSyntheticLambda23()).reversed());
        Iterator<CellInfo> r9 = cil.iterator();
    L8:
        if (r9.hasNext() == false) goto L20;
        CellInfo ci = r9.next();
        int status = ci.getCellConnectionStatus();
        if (ci.isRegistered() == true) goto L13;
        if (status == 1) goto L13;
        if (status != 2) goto L8;
    L13:
        CellIdentity c = ci.getCellIdentity();
        int t = getCellType(ci);
        if (getCidFromCellIdentity(c) == (-1)) goto L8;
        if (cellIdentityMap.containsKey(Integer.valueOf(t)) == true) goto L8;
        cellIdentityMap.put(Integer.valueOf(t), c);
        goto L8
    L20:
        if (cellIdentityMap.containsKey(1) == false) goto L23;
        setRefLocation(1, cellIdentityMap.get(1));
        return;
    L23:
        if (cellIdentityMap.containsKey(4) == false) goto L26;
        setRefLocation(2, cellIdentityMap.get(4));
        return;
    L26:
        if (cellIdentityMap.containsKey(3) == false) goto L29;
        setRefLocation(4, cellIdentityMap.get(3));
        return;
    L29:
        if (cellIdentityMap.containsKey(6) == false) goto L31;
        setRefLocation(8, cellIdentityMap.get(6));
        return;
    L31:
        Log.e(TAG, "No available serving cell information.");
        return;
    L33:
        Log.e(TAG, "Error getting cell location info.");
        return;
    L35:
        if (phoneType != 2) goto L50;
        Log.e(TAG, "CDMA not supported.");
        return;
    }

    private static /* synthetic */ int lambda$requestRefLocation$10(CellInfo ci) {
        return ci.getCellSignalStrength().getAsuLevel();
    }

    private void postWithWakeLockHeld(final Runnable runnable) {
        this.mWakeLock.acquire(30000);
        boolean success = this.mHandler.post(new GnssLocationProvider$$ExternalSyntheticLambda27(this, runnable));
        if (success == true) goto L6;
        this.mWakeLock.release();
        return;
    }

    private /* synthetic */ void lambda$postWithWakeLockHeld$11(Runnable runnable) {
        runnable.run();     // Catch: Throwable -> L5
        this.mWakeLock.release();
        return;
    L5:
        th = move-exception;
        this.mWakeLock.release();
        throw th;
    }

    @Override // com.android.server.location.provider.AbstractLocationProvider
    public void dump(FileDescriptor fd, PrintWriter pw, String[] args) {
        boolean dumpAll = false;
        int opti = 0;
    L4:
        if (opti >= args.length) goto L16;
        String opt = args[opti];
        if (opt == null) goto L16;
        if (opt.length() <= 0) goto L16;
        if (opt.charAt(0) != '-') goto L16;
        opti = opti + 1;
        if ("-a".equals(opt) == false) goto L4;
        dumpAll = true;
    L16:
        pw.print("mStarted=" + this.mStarted + "   (changed ");
        TimeUtils.formatDuration(SystemClock.elapsedRealtime() - this.mStartedChangedElapsedRealtime, pw);
        pw.println(" ago)");
        pw.println("mBatchingEnabled=" + this.mBatchingEnabled);
        pw.println("mBatchingStarted=" + this.mBatchingStarted);
        pw.println("mBatchSize=" + getBatchSize());
        pw.println("mFixInterval=" + this.mFixInterval);
        pw.print(this.mGnssMetrics.dumpGnssMetricsAsText());
        if (dumpAll == false) goto L26;
        this.mNetworkTimeHelper.dump(pw);
        pw.println("mSupportsPsds=" + this.mSupportsPsds);
        pw.println("mNiSuplMessageListenerRegistered=" + this.mNiSuplMessageListenerRegistered);
        pw.println("PsdsServerConfigured=" + this.mGnssConfiguration.isLongTermPsdsServerConfigured());
        pw.println("native internal state: ");
        pw.println("  " + this.mGnssNative.getInternalState());
        return;
    }

    @Override // com.android.server.location.gnss.hal.GnssNative.BaseCallbacks
    public void onHalRestarted() {
        reloadGpsProperties();
        if (isGpsEnabled() == false) goto L5;
        setGpsEnabled(false);
        updateEnabled();
        restartLocationRequest();
    L5:
        Object r0 = this.mLock;
        monitor-enter(r0);
    L10:
        th = move-exception;
        throw th;
    L8:
        if (this.mInitialized == false) goto L12;
        this.mNetworkConnectivityHandler.unregisterNetworkCallbacks();     // Catch: Throwable -> L10
        this.mNetworkConnectivityHandler.registerNetworkCallbacks();     // Catch: Throwable -> L10
    L12:
        monitor-exit(r0);     // Catch: Throwable -> L10
    }

    @Override // com.android.server.location.gnss.hal.GnssNative.BaseCallbacks
    public void onCapabilitiesChanged(GnssCapabilities oldCapabilities, GnssCapabilities newCapabilities) {
        this.mHandler.post(new GnssLocationProvider$$ExternalSyntheticLambda1(this));
    }

    private /* synthetic */ void lambda$onCapabilitiesChanged$12() {
        boolean useOnDemandTimeInjection = this.mGnssNative.getCapabilities().hasOnDemandTime();
        this.mNetworkTimeHelper.setPeriodicTimeInjectionMode(useOnDemandTimeInjection);
        if (useOnDemandTimeInjection == false) goto L5;
        demandUtcTimeInjection();
    L5:
        restartLocationRequest();
    }

    private /* synthetic */ void lambda$onReportLocation$13(boolean hasLatLong, Location location) {
        handleReportLocation(hasLatLong, location);
    }

    @Override // com.android.server.location.gnss.hal.GnssNative.LocationCallbacks
    public void onReportLocation(final boolean hasLatLong, final Location location) {
        postWithWakeLockHeld(new GnssLocationProvider$$ExternalSyntheticLambda9(this, hasLatLong, location));
    }

    @Override // com.android.server.location.gnss.hal.GnssNative.LocationCallbacks
    public void onReportLocations(Location[] locations) {
        if (DEBUG == false) goto L6;
        Log.d(TAG, "Location batch of size " + locations.length + " reported");
    L6:
        if (locations.length > 0) goto L8;
    L26:
        Object r0 = this.mLock;
        monitor-enter(r0);
        int r2 = 0;
        Runnable[] listeners = (Runnable[]) this.mFlushListeners.toArray(new Runnable[0]);     // Catch: Throwable -> L34
        this.mFlushListeners.clear();     // Catch: Throwable -> L34
        monitor-exit(r0);     // Catch: Throwable -> L34
        int r1 = listeners.length;
    L31:
        if (r2 >= r1) goto L33;
        Runnable listener = listeners[r2];
        listener.run();
        r2 = r2 + 1;
        goto L31
    L33:
        return;
    L34:
        th = move-exception;
        throw th;
    L8:
        if (locations.length <= 1) goto L37;
        boolean fixRealtime = false;
        int i = locations.length - 2;
    L10:
        if (i < 0) goto L15;
        long timeDeltaMs = locations[i + 1].getTime() - locations[i].getTime();
        long realtimeDeltaMs = locations[i + 1].getElapsedRealtimeMillis() - locations[i].getElapsedRealtimeMillis();
        if (Math.abs(timeDeltaMs - realtimeDeltaMs) > 500) goto L13;
        i = i - 1;
        goto L10
    L13:
        fixRealtime = true;
    L15:
        if (fixRealtime == false) goto L20;
        Arrays.sort(locations, Comparator.comparingLong(new GnssLocationProvider$$ExternalSyntheticLambda2()));
        long expectedDeltaMs = locations[locations.length - 1].getTime() - locations[locations.length - 1].getElapsedRealtimeMillis();
        int i2 = locations.length - 2;
    L17:
        if (i2 < 0) goto L37;
        locations[i2].setElapsedRealtimeNanos(TimeUnit.MILLISECONDS.toNanos(Math.max(locations[i2].getTime() - expectedDeltaMs, 0)));
        i2 = i2 - 1;
        goto L17
    L20:
        Arrays.sort(locations, Comparator.comparingLong(new GnssLocationProvider$$ExternalSyntheticLambda3()));
    L37:
        reportLocation(LocationResult.wrap(locations).validate());     // Catch: LocationResult.BadLocationException -> L23
    L23:
        e = move-exception;
        Log.e(TAG, "Dropping invalid locations: " + e);
    }

    private /* synthetic */ void lambda$onReportSvStatus$14(GnssStatus gnssStatus) {
        handleReportSvStatus(gnssStatus);
    }

    @Override // com.android.server.location.gnss.hal.GnssNative.SvStatusCallbacks
    public void onReportSvStatus(final GnssStatus gnssStatus) {
        postWithWakeLockHeld(new GnssLocationProvider$$ExternalSyntheticLambda22(this, gnssStatus));
    }

    @Override // com.android.server.location.gnss.hal.GnssNative.AGpsCallbacks
    public void onReportAGpsStatus(int agpsType, int agpsStatus, byte[] suplIpAddr) {
        this.mNetworkConnectivityHandler.onReportAGpsStatus(agpsType, agpsStatus, suplIpAddr);
    }

    private /* synthetic */ void lambda$onRequestPsdsDownload$15(int psdsType) {
        handleDownloadPsdsData(psdsType);
    }

    @Override // com.android.server.location.gnss.hal.GnssNative.PsdsCallbacks
    public void onRequestPsdsDownload(final int psdsType) {
        postWithWakeLockHeld(new GnssLocationProvider$$ExternalSyntheticLambda4(this, psdsType));
    }

    @Override // com.android.server.location.gnss.hal.GnssNative.AGpsCallbacks
    public void onRequestSetID(int flags) {
        TelephonyManager phone = (TelephonyManager) this.mContext.getSystemService(HintsHelper.AUTOFILL_HINT_PHONE);
        int type = 0;
        String setId = null;
        int subId = SubscriptionManager.getDefaultDataSubscriptionId();
        if (this.mGnssConfiguration.isActiveSimEmergencySuplEnabled() == false) goto L10;
        if (this.mNIHandler.getInEmergency() == false) goto L10;
        if (this.mNetworkConnectivityHandler.getActiveSubId() < 0) goto L10;
        subId = this.mNetworkConnectivityHandler.getActiveSubId();
    L10:
        if (SubscriptionManager.isValidSubscriptionId(subId) == false) goto L13;
        phone = phone.createForSubscriptionId(subId);
    L13:
        if ((flags & 1) != 1) goto L18;
        setId = phone.getSubscriberId();
        if (setId == null) goto L22;
        type = 1;
    L22:
        GnssNative r4 = this.mGnssNative;
        if (setId != null) goto L25;
        String r5 = "";
    L26:
        r4.setAgpsSetId(type, r5);
        LocationLogsRecorder.getInstance().writeLocationLogsAsync(LocationLogsRecorder.KEY_FILE_GNSS, "setAgpsSetId: " + setId);
        return;
    L25:
        r5 = setId;
        goto L26
    L18:
        if ((flags & 2) != 2) goto L22;
        setId = phone.getLine1Number();
        if (setId == null) goto L22;
        type = 2;
        goto L22
    }

    @Override // com.android.server.location.gnss.hal.GnssNative.LocationRequestCallbacks
    public void onRequestLocation(final boolean independentFromGnss, final boolean isUserEmergency) {
        if (DEBUG == false) goto L5;
        Log.d(TAG, "requestLocation. independentFromGnss: " + independentFromGnss + ", isUserEmergency: " + isUserEmergency);
    L5:
        postWithWakeLockHeld(new GnssLocationProvider$$ExternalSyntheticLambda7(this, independentFromGnss, isUserEmergency));
    }

    private /* synthetic */ void lambda$onRequestLocation$16(boolean independentFromGnss, boolean isUserEmergency) {
        handleRequestLocation(independentFromGnss, isUserEmergency);
    }

    @Override // com.android.server.location.gnss.hal.GnssNative.TimeCallbacks
    public void onRequestUtcTime() {
        demandUtcTimeInjection();
        LocationLogsRecorder.getInstance().writeLocationLogsAsync(LocationLogsRecorder.KEY_FILE_GNSS, "onRequestUtcTime");
    }

    @Override // com.android.server.location.gnss.hal.GnssNative.LocationRequestCallbacks
    public void onRequestRefLocation() {
        requestRefLocation();
    }

    @Override // com.android.server.location.gnss.hal.GnssNative.NotificationCallbacks
    public void onReportNfwNotification(String proxyAppPackageName, byte protocolStack, String otherProtocolStackName, byte requestor, String requestorId, byte responseType, boolean inEmergencyMode, boolean isCachedLocation) {
        if (this.mGnssVisibilityControl != null) goto L6;
        Log.e(TAG, "reportNfwNotification: mGnssVisibilityControl uninitialized.");
        return;
    L6:
        this.mGnssVisibilityControl.reportNfwNotification(proxyAppPackageName, protocolStack, otherProtocolStackName, requestor, requestorId, responseType, inEmergencyMode, isCachedLocation);
        LocationLogsRecorder.getInstance().writeLocationLogsAsync(LocationLogsRecorder.KEY_FILE_GNSS, "reportNfwNotification. proxyApp: " + proxyAppPackageName + " protocolStack: " + protocolStack + " otherProtocolStackName: " + otherProtocolStackName + " requestor: " + requestor + " requestorId: " + requestorId + " responseType: " + responseType + " inEmergencyMode: " + inEmergencyMode + " isCachedLocation: " + isCachedLocation);
    }

    public static synchronized void enableGnssLocationProviderLogs(boolean enable) {
        monitor-enter(GnssLocationProvider.class);
        DEBUG = enable;     // Catch: Throwable -> L7
        VERBOSE = enable;     // Catch: Throwable -> L7
        monitor-exit(GnssLocationProvider.class);
        return;
    L7:
        th = move-exception;
        throw th;
    }
}
