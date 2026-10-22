package com.android.server;

import android.R;
import android.app.ActivityThread;
import android.app.AppCompatCallbacks;
import android.app.ApplicationErrorReport;
import android.app.INotificationManager;
import android.app.SysMonitorFwBridge;
import android.app.SystemServiceRegistry;
import android.app.admin.DevicePolicySafetyChecker;
import android.app.appfunctions.AppFunctionManagerConfiguration;
import android.app.usage.UsageStatsManagerInternal;
import android.content.ComponentName;
import android.content.ContentResolver;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageItemInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManagerInternal;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.database.sqlite.SQLiteCompatibilityWalFlags;
import android.database.sqlite.SQLiteGlobal;
import android.graphics.GraphicsStatsService;
import android.hardware.IConsumerIrService;
import android.hardware.display.DisplayManagerInternal;
import android.media.IMediaRouterService;
import android.net.ConnectivityManager;
import android.net.ConnectivityModuleConnector;
import android.net.IPacProxyManager;
import android.net.NetworkStackClient;
import android.os.ArtModuleServiceManager;
import android.os.BaseBundle;
import android.os.Binder;
import android.os.Build;
import android.os.Debug;
import android.os.Environment;
import android.os.FactoryTest;
import android.os.FileUtils;
import android.os.IBinder;
import android.os.IIncidentManager;
import android.os.INetworkManagementService;
import android.os.Looper;
import android.os.Message;
import android.os.Parcel;
import android.os.Process;
import android.os.ServiceManager;
import android.os.StrictMode;
import android.os.SystemClock;
import android.os.SystemProperties;
import android.os.Trace;
import android.os.UserHandle;
import android.os.UserManager;
import android.os.storage.IStorageManager;
import android.prometheus.ExtRuntimeInit;
import android.provider.DeviceConfig;
import android.provider.Settings;
import android.system.ErrnoException;
import android.system.Os;
import android.system.OsConstants;
import android.text.TextUtils;
import android.tracing.perfetto.InitArguments;
import android.tracing.perfetto.Producer;
import android.util.ArrayMap;
import android.util.DisplayMetrics;
import android.util.Dumpable;
import android.util.EventLog;
import android.util.IndentingPrintWriter;
import android.util.Pair;
import android.util.Slog;
import android.util.TimeUtils;
import com.android.i18n.timezone.ZoneInfoDb;
import com.android.internal.hidden_from_bootclasspath.com.android.ranging.flags.Flags;
import com.android.internal.notification.SystemNotificationChannels;
import com.android.internal.os.ApplicationSharedMemory;
import com.android.internal.os.BinderInternal;
import com.android.internal.os.RuntimeInit;
import com.android.internal.pm.RoSystemFeatures;
import com.android.internal.policy.AttributeCache;
import com.android.internal.protolog.ProtoLog;
import com.android.internal.protolog.WmProtoLogGroups;
import com.android.internal.util.ConcurrentUtils;
import com.android.internal.util.FrameworkStatsLog;
import com.android.internal.widget.ILockSettings;
import com.android.internal.widget.LockSettingsInternal;
import com.android.modules.utils.build.SdkLevel;
import com.android.server.accessibility.AccessibilityManagerService;
import com.android.server.accounts.AccountManagerService;
import com.android.server.adb.AdbService;
import com.android.server.alarm.AlarmManagerService;
import com.android.server.alwaysonrecord.AlwaysOnRecordService;
import com.android.server.am.ActivityManagerService;
import com.android.server.am.SysMonitorSvcBridge;
import com.android.server.ambientcontext.AmbientContextManagerService;
import com.android.server.app.GameManagerService;
import com.android.server.appbinding.AppBindingService;
import com.android.server.appfunctions.AppFunctionManagerService;
import com.android.server.apphibernation.AppHibernationService;
import com.android.server.appop.AppOpMigrationHelper;
import com.android.server.appop.AppOpMigrationHelperImpl;
import com.android.server.appprediction.AppPredictionManagerService;
import com.android.server.appwidget.AppWidgetService;
import com.android.server.art.ArtModuleServiceInitializer;
import com.android.server.art.DexUseManagerLocal;
import com.android.server.attention.AttentionManagerService;
import com.android.server.audio.AudioService;
import com.android.server.autofill.AutofillManagerService;
import com.android.server.backup.BackupManagerService;
import com.android.server.biometrics.AuthService;
import com.android.server.biometrics.BiometricService;
import com.android.server.biometrics.sensors.face.FaceService;
import com.android.server.biometrics.sensors.fingerprint.FingerprintService;
import com.android.server.biometrics.sensors.iris.IrisService;
import com.android.server.blob.BlobStoreManagerService;
import com.android.server.broadcastradio.BroadcastRadioService;
import com.android.server.camera.CameraServiceProxy;
import com.android.server.clipboard.ClipboardService;
import com.android.server.companion.CompanionDeviceManagerService;
import com.android.server.companion.virtual.VirtualDeviceManagerService;
import com.android.server.compat.PlatformCompat;
import com.android.server.compat.PlatformCompatNative;
import com.android.server.compat.overrides.AppCompatOverridesService;
import com.android.server.connectivity.IpConnectivityMetrics;
import com.android.server.connectivity.PacProxyService;
import com.android.server.content.ContentService;
import com.android.server.contentcapture.ContentCaptureManagerInternal;
import com.android.server.contentcapture.ContentCaptureManagerService;
import com.android.server.contentsuggestions.ContentSuggestionsManagerService;
import com.android.server.contextualsearch.ContextualSearchManagerService;
import com.android.server.coverage.CoverageService;
import com.android.server.cpu.CpuMonitorService;
import com.android.server.crashrecovery.CrashRecoveryAdaptor;
import com.android.server.credentials.CredentialManagerService;
import com.android.server.criticalevents.CriticalEventLog;
import com.android.server.devicepolicy.DevicePolicyManagerService;
import com.android.server.devicestate.DeviceStateManagerService;
import com.android.server.display.DisplayManagerService;
import com.android.server.display.color.ColorDisplayService;
import com.android.server.dreams.DreamManagerService;
import com.android.server.emergency.EmergencyAffordanceService;
import com.android.server.flags.FeatureFlagsService;
import com.android.server.gpu.GpuService;
import com.android.server.grammaticalinflection.GrammaticalInflectionService;
import com.android.server.graphics.fonts.FontManagerService;
import com.android.server.hdmi.HdmiControlService;
import com.android.server.incident.IncidentCompanionService;
import com.android.server.input.InputManagerService;
import com.android.server.inputmethod.InputMethodManagerService;
import com.android.server.integrity.AppIntegrityManagerService;
import com.android.server.job.JobSchedulerService;
import com.android.server.lights.LightsService;
import com.android.server.locales.LocaleManagerService;
import com.android.server.localtonemapping.LocalToneMappingService;
import com.android.server.location.LocationManagerService;
import com.android.server.location.altitude.AltitudeService;
import com.android.server.locksettings.LockSettingsService;
import com.android.server.logcat.LogcatManagerService;
import com.android.server.media.MediaResourceMonitorService;
import com.android.server.media.MediaRouterService;
import com.android.server.media.MediaSessionService;
import com.android.server.media.metrics.MediaMetricsManagerService;
import com.android.server.media.projection.MediaProjectionManagerService;
import com.android.server.media.quality.MediaQualityService;
import com.android.server.midi.MidiService;
import com.android.server.musicrecognition.MusicRecognitionManagerService;
import com.android.server.net.NetworkManagementService;
import com.android.server.net.NetworkPolicyManagerService;
import com.android.server.net.watchlist.NetworkWatchlistService;
import com.android.server.notification.NotificationManagerService;
import com.android.server.oemlock.OemLockService;
import com.android.server.om.OverlayManagerService;
import com.android.server.os.BugreportManagerService;
import com.android.server.os.DeviceIdentifiersPolicyService;
import com.android.server.os.NativeTombstoneManagerService;
import com.android.server.os.SchedulingPolicyService;
import com.android.server.os.instrumentation.DynamicInstrumentationManagerService;
import com.android.server.pdb.PersistentDataBlockService;
import com.android.server.people.PeopleService;
import com.android.server.permission.access.AccessCheckingService;
import com.android.server.pinner.PinnerService;
import com.android.server.pm.ApexManager;
import com.android.server.pm.ApexSystemServiceInfo;
import com.android.server.pm.BackgroundInstallControlService;
import com.android.server.pm.CrossProfileAppsService;
import com.android.server.pm.DataLoaderManagerService;
import com.android.server.pm.DexOptHelper;
import com.android.server.pm.DynamicCodeLoggingService;
import com.android.server.pm.Installer;
import com.android.server.pm.LauncherAppsService;
import com.android.server.pm.OtaDexoptService;
import com.android.server.pm.PackageManagerService;
import com.android.server.pm.ShortcutService;
import com.android.server.pm.UserManagerService;
import com.android.server.pm.dex.OdsignStatsLogger;
import com.android.server.pm.permission.PermissionMigrationHelper;
import com.android.server.pm.permission.PermissionMigrationHelperImpl;
import com.android.server.pm.verify.domain.DomainVerificationService;
import com.android.server.policy.AppOpsPolicy;
import com.android.server.policy.PermissionPolicyService;
import com.android.server.policy.PhoneWindowManager;
import com.android.server.policy.role.RoleServicePlatformHelperImpl;
import com.android.server.power.PowerManagerService;
import com.android.server.power.ShutdownThread;
import com.android.server.power.ThermalManagerService;
import com.android.server.power.hint.HintManagerService;
import com.android.server.powerstats.PowerStatsService;
import com.android.server.print.PrintManagerService;
import com.android.server.profcollect.ProfcollectForwardingService;
import com.android.server.recoverysystem.RecoverySystemService;
import com.android.server.resources.ResourcesManagerService;
import com.android.server.restrictions.RestrictionsManagerService;
import com.android.server.role.RoleServicePlatformHelper;
import com.android.server.rollback.RollbackManagerService;
import com.android.server.rotationresolver.RotationResolverManagerService;
import com.android.server.search.SearchManagerService;
import com.android.server.searchui.SearchUiManagerService;
import com.android.server.security.AttestationVerificationManagerService;
import com.android.server.security.FileIntegrityService;
import com.android.server.security.KeyAttestationApplicationIdProviderService;
import com.android.server.security.KeyChainSystemService;
import com.android.server.security.advancedprotection.AdvancedProtectionService;
import com.android.server.security.authenticationpolicy.AuthenticationPolicyService;
import com.android.server.security.intrusiondetection.IntrusionDetectionService;
import com.android.server.security.rkp.RemoteProvisioningService;
import com.android.server.selinux.SelinuxAuditLogsService;
import com.android.server.sensorprivacy.SensorPrivacyService;
import com.android.server.sensors.SensorService;
import com.android.server.signedconfig.SignedConfigService;
import com.android.server.slice.SliceManagerService;
import com.android.server.smartspace.SmartspaceManagerService;
import com.android.server.soundtrigger.SoundTriggerService;
import com.android.server.soundtrigger_middleware.SoundTriggerMiddlewareService;
import com.android.server.speech.SpeechRecognitionManagerService;
import com.android.server.stats.bootstrap.StatsBootstrapAtomService;
import com.android.server.stats.pull.StatsPullAtomService;
import com.android.server.statusbar.StatusBarManagerService;
import com.android.server.storage.DeviceStorageMonitorService;
import com.android.server.supervision.SupervisionService;
import com.android.server.systemcaptions.SystemCaptionsManagerService;
import com.android.server.telecom.TelecomLoaderService;
import com.android.server.testharness.TestHarnessModeService;
import com.android.server.textclassifier.TextClassificationManagerService;
import com.android.server.textservices.TextServicesManagerService;
import com.android.server.texttospeech.TextToSpeechManagerService;
import com.android.server.timedetector.GnssTimeUpdateService;
import com.android.server.timedetector.NetworkTimeUpdateService;
import com.android.server.timedetector.TimeDetectorService;
import com.android.server.timezonedetector.TimeZoneDetectorService;
import com.android.server.timezonedetector.location.LocationTimeZoneManagerService;
import com.android.server.touch.TouchService;
import com.android.server.tracing.TracingServiceProxy;
import com.android.server.translation.TranslationManagerService;
import com.android.server.trust.TrustManagerService;
import com.android.server.tv.TvInputManagerService;
import com.android.server.tv.TvRemoteService;
import com.android.server.tv.interactive.TvInteractiveAppManagerService;
import com.android.server.tv.tunerresourcemanager.TunerResourceManagerService;
import com.android.server.twilight.TwilightService;
import com.android.server.uri.UriGrantsManagerService;
import com.android.server.usage.StorageStatsService;
import com.android.server.usage.UsageStatsService;
import com.android.server.usb.UsbService;
import com.android.server.utils.TimingsTraceAndSlog;
import com.android.server.vibrator.VibratorManagerService;
import com.android.server.voiceinteraction.VoiceInteractionManagerService;
import com.android.server.vr.VrManagerService;
import com.android.server.wallpaper.WallpaperManagerService;
import com.android.server.wallpapereffectsgeneration.WallpaperEffectsGenerationManagerService;
import com.android.server.wearable.WearableSensingManagerService;
import com.android.server.webkit.WebViewUpdateService;
import com.android.server.wm.ActivityTaskManagerService;
import com.android.server.wm.WindowManagerGlobalLock;
import com.android.server.wm.WindowManagerService;
import com.android.server.wm.ZTEActivityEventsService;
import com.android.server.zte.VendorConfigService;
import com.bytedance.server.oms.deviceinfo.DeviceInfoManagerService;
import com.bytedance.server.oms.monitor.OmsMonitorManagerService;
import com.bytedance.server.security.BDSecurityService;
import com.bytedance.server.virt.VirtService;
import com.obric.utils.ObricImplFactory;
import dalvik.system.PathClassLoader;
import dalvik.system.VMRuntime;
import java.io.File;
import java.io.FileDescriptor;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Locale;
import java.util.Timer;
import java.util.TreeSet;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Future;

/* JADX INFO: loaded from: classes.dex */
public final class SystemServer implements Dumpable {
    private static final String AD_SERVICES_MANAGER_SERVICE_CLASS = "com.android.server.adservices.AdServicesManagerService$Lifecycle";
    private static final String APPSEARCH_MODULE_LIFECYCLE_CLASS = "com.android.server.appsearch.AppSearchModule$Lifecycle";
    private static final String ARC_PERSISTENT_DATA_BLOCK_SERVICE_CLASS = "com.android.server.arc.persistent_data_block.ArcPersistentDataBlockService";
    private static final String ARC_SYSTEM_HEALTH_SERVICE = "com.android.server.arc.health.ArcSystemHealthService";
    private static final String BLOCK_MAP_FILE = "/cache/recovery/block.map";
    private static final String BLUETOOTH_APEX_SERVICE_JAR_PATH = "/apex/com.android.bt/javalib/service-bluetooth.jar";
    private static final String BLUETOOTH_SERVICE_CLASS = "com.android.server.bluetooth.BluetoothService";
    private static final String CAR_SERVICE_HELPER_SERVICE_CLASS = "com.android.internal.car.CarServiceHelperService";
    private static final String CONNECTIVITY_SERVICE_APEX_PATH = "/apex/com.android.tethering/javalib/service-connectivity.jar";
    private static final String CONNECTIVITY_SERVICE_INITIALIZER_B_CLASS = "com.android.server.ConnectivityServiceInitializerB";
    private static final String CONNECTIVITY_SERVICE_INITIALIZER_CLASS = "com.android.server.ConnectivityServiceInitializer";
    private static final int DEFAULT_SYSTEM_THEME = 16975060;
    private static final String DEVICE_LOCK_APEX_PATH = "/apex/com.android.devicelock/javalib/service-devicelock.jar";
    private static final String DEVICE_LOCK_SERVICE_CLASS = "com.android.server.devicelock.DeviceLockService";
    private static final String ENHANCED_CONFIRMATION_SERVICE_CLASS = "com.android.ecm.EnhancedConfirmationService";
    private static final String HEALTHCONNECT_MANAGER_SERVICE_CLASS = "com.android.server.healthconnect.HealthConnectManagerService";
    private static final String HEALTH_SERVICE_CLASS = "com.android.clockwork.healthservices.HealthService";
    private static final File HEAP_DUMP_PATH = null;
    private static final String IOT_SERVICE_CLASS = "com.android.things.server.IoTSystemService";
    private static final String ISOLATED_COMPILATION_SERVICE_CLASS = "com.android.server.compos.IsolatedCompilationService";
    private static final String LOWPAN_SERVICE_CLASS = "com.android.server.lowpan.LowpanService";
    private static final int MAX_HEAP_DUMPS = 2;
    private static final String MEDIA_COMMUNICATION_SERVICE_CLASS = "com.android.server.media.MediaCommunicationService";
    private static final String NETWORK_STATS_SERVICE_INITIALIZER_CLASS = "com.android.server.NetworkStatsServiceInitializer";
    private static final String ON_DEVICE_INTELLIGENCE_MANAGER_SERVICE_CLASS = "com.android.server.ondeviceintelligence.OnDeviceIntelligenceManagerService";
    private static final String ON_DEVICE_PERSONALIZATION_SYSTEM_SERVICE_CLASS = "com.android.server.ondevicepersonalization.OnDevicePersonalizationSystemService$Lifecycle";
    private static final String PERSISTENT_DATA_BLOCK_PROP = "ro.frp.pst";
    private static final String PROFILING_SERVICE_JAR_PATH = "/apex/com.android.profiling/javalib/service-profiling.jar";
    private static final String PROFILING_SERVICE_LIFECYCLE_CLASS = "android.os.profiling.ProfilingService$Lifecycle";
    private static final String RANGING_APEX_SERVICE_JAR_PATH = "/apex/com.android.uwb/javalib/service-ranging.jar";
    private static final String RANGING_SERVICE_CLASS = "com.android.server.ranging.RangingService";
    private static final String REBOOT_READINESS_LIFECYCLE_CLASS = "com.android.server.scheduling.RebootReadinessManagerService$Lifecycle";
    private static final String ROLE_SERVICE_CLASS = "com.android.role.RoleService";
    private static final String SAFETY_CENTER_SERVICE_CLASS = "com.android.safetycenter.SafetyCenterService";
    private static final String SCHEDULING_APEX_PATH = "/apex/com.android.scheduling/javalib/service-scheduling.jar";
    private static final String SDK_SANDBOX_MANAGER_SERVICE_CLASS = "com.android.server.sdksandbox.SdkSandboxManagerService$Lifecycle";
    private static final long SLOW_DELIVERY_THRESHOLD_MS = 200;
    private static final long SLOW_DISPATCH_THRESHOLD_MS = 100;
    private static final String START_BLOB_STORE_SERVICE = "startBlobStoreManagerService";
    private static final String START_HIDL_SERVICES = "StartHidlServices";
    private static final String START_SENSOR_MANAGER_SERVICE = "StartISensorManagerService";
    private static final String STATS_COMPANION_APEX_PATH = "/apex/com.android.os.statsd/javalib/service-statsd.jar";
    private static final String STATS_COMPANION_LIFECYCLE_CLASS = "com.android.server.stats.StatsCompanion$Lifecycle";
    private static final String SYSPROP_FDTRACK_ABORT_THRESHOLD = "persist.sys.debug.fdtrack_abort_threshold";
    private static final String SYSPROP_FDTRACK_ENABLE_THRESHOLD = "persist.sys.debug.fdtrack_enable_threshold";
    private static final String SYSPROP_FDTRACK_INTERVAL = "persist.sys.debug.fdtrack_interval";
    private static final String SYSPROP_START_COUNT = "sys.system_server.start_count";
    private static final String SYSPROP_START_ELAPSED = "sys.system_server.start_elapsed";
    private static final String SYSPROP_START_UPTIME = "sys.system_server.start_uptime";
    private static final String SYSTEM_STATE_DISPLAY_SERVICE_CLASS = "com.android.clockwork.systemstatedisplay.SystemStateDisplayService";
    private static final String TAG = "SystemServer";
    private static final String TETHERING_CONNECTOR_CLASS = "android.net.ITetheringConnector";
    private static final String THERMAL_OBSERVER_CLASS = "com.android.clockwork.ThermalObserver";
    private static final String UNCRYPT_PACKAGE_FILE = "/cache/recovery/uncrypt_file";
    private static final String UPDATABLE_DEVICE_CONFIG_SERVICE_CLASS = "com.android.server.deviceconfig.DeviceConfigInit$Lifecycle";
    private static final String UWB_APEX_SERVICE_JAR_PATH = "/apex/com.android.uwb/javalib/service-uwb.jar";
    private static final String UWB_SERVICE_CLASS = "com.android.server.uwb.UwbService";
    private static final String WEAR_CONNECTIVITY_SERVICE_CLASS = "com.android.clockwork.connectivity.WearConnectivityService";
    private static final String WEAR_DEBUG_SERVICE_CLASS = "com.android.clockwork.debug.WearDebugService";
    private static final String WEAR_DISPLAYOFFLOAD_SERVICE_CLASS = "com.android.clockwork.displayoffload.DisplayOffloadService";
    private static final String WEAR_DISPLAY_SERVICE_CLASS = "com.android.clockwork.display.WearDisplayService";
    private static final String WEAR_GESTURE_SERVICE_CLASS = "com.android.clockwork.gesture.WearGestureService";
    private static final String WEAR_MODE_SERVICE_CLASS = "com.android.clockwork.modes.ModeManagerService";
    private static final String WEAR_POWER_SERVICE_CLASS = "com.android.clockwork.power.WearPowerService";
    private static final String WEAR_SETTINGS_SERVICE_CLASS = "com.android.clockwork.settings.WearSettingsService";
    private static final String WEAR_TIME_SERVICE_CLASS = "com.android.clockwork.time.WearTimeService";
    private static final String WIFI_APEX_SERVICE_JAR_PATH = "/apex/com.android.wifi/javalib/service-wifi.jar";
    private static final String WIFI_AWARE_SERVICE_CLASS = "com.android.server.wifi.aware.WifiAwareService";
    private static final String WIFI_P2P_SERVICE_CLASS = "com.android.server.wifi.p2p.WifiP2pService";
    private static final String WIFI_RTT_SERVICE_CLASS = "com.android.server.wifi.rtt.RttService";
    private static final String WIFI_SCANNING_SERVICE_CLASS = "com.android.server.wifi.scanner.WifiScanningService";
    private static final String WIFI_SERVICE_CLASS = "com.android.server.wifi.WifiService";
    private static final String WIFI_USD_SERVICE_CLASS = "com.android.server.wifi.usd.UsdService";
    private static final String WRIST_ORIENTATION_SERVICE_CLASS = "com.android.clockwork.wristorientation.WristOrientationService";
    private static final int sMaxBinderThreads = 31;
    private static LinkedList<Pair<String, ApplicationErrorReport.CrashInfo>> sPendingWtfs;
    private ActivityManagerService mActivityManagerService;
    private ContentResolver mContentResolver;
    private DataLoaderManagerService mDataLoaderManagerService;
    private DisplayManagerService mDisplayManagerService;
    private final SystemServerDumper mDumper;
    private EntropyMixer mEntropyMixer;
    private final int mFactoryTestMode;
    private boolean mFirstBoot;
    private long mIncrementalServiceHandle;
    private IObricSystemServer mObricExt;
    private PackageManager mPackageManager;
    private PackageManagerService mPackageManagerService;
    private PowerManagerService mPowerManagerService;
    private Timer mProfilerSnapshotTimer;
    private final boolean mRuntimeRestart;
    private final long mRuntimeStartElapsedTime;
    private final long mRuntimeStartUptime;
    private final int mStartCount;
    private Context mSystemContext;
    private SystemServiceManager mSystemServiceManager;
    private WebViewUpdateService mWebViewUpdateService;
    private WindowManagerGlobalLock mWindowManagerGlobalLock;
    private Future<?> mZygotePreload;

    private final class SystemServerDumper extends Binder {
        private final ArrayMap<String, Dumpable> mDumpables;

        /* JADX INFO: renamed from: -$$Nest$maddDumpable, reason: not valid java name */
        static /* bridge */ /* synthetic */ void m395$$Nest$maddDumpable(SystemServerDumper r0, Dumpable r1) {
            r0.addDumpable(r1);
        }

        /* synthetic */ SystemServerDumper(SystemServer r1, SystemServerIA r2) {
            this(r1);
        }

        private SystemServerDumper(SystemServer r2) {
            this.mDumpables = new ArrayMap(4);
        }

        @Override // android.os.Binder
        protected void dump(FileDescriptor fd, PrintWriter pw, String[] args) {
            if (args != null) goto L5;
        L7:
            boolean hasArgs = false;
        L8:
            ArrayMap<String, Dumpable> r3 = this.mDumpables;
            monitor-enter(r3);
            if (hasArgs == true) goto L61;
        L21:
            if (hasArgs == true) goto L23;
        L45:
            int dumpablesSize = this.mDumpables.size();     // Catch: Throwable -> L16
            PrintWriter r1 = new IndentingPrintWriter(pw, "  ");     // Catch: Throwable -> L16
            int i = 0;
        L47:
            if (i >= dumpablesSize) goto L56;
            Dumpable dumpable = this.mDumpables.valueAt(i);     // Catch: Throwable -> L50
            r1.printf("%s:\n", new Object[]{dumpable.getDumpableName()});     // Catch: Throwable -> L50
            r1.increaseIndent();     // Catch: Throwable -> L50
            dumpable.dump(r1, args);     // Catch: Throwable -> L50
            r1.decreaseIndent();     // Catch: Throwable -> L50
            r1.println();     // Catch: Throwable -> L50
            i = i + 1;
            goto L47
        L50:
            th = move-exception;
            r1.close();     // Catch: Throwable -> L53
        L55:
            throw th;     // Catch: Throwable -> L16
        L53:
            th = move-exception;
            th.addSuppressed(th);     // Catch: Throwable -> L16
        L16:
            th = move-exception;
            throw th;
        L56:
            r1.close();     // Catch: Throwable -> L16
            monitor-exit(r3);     // Catch: Throwable -> L16
            return;
        L23:
            if ("--name".equals(args[0]) == false) goto L45;
            if (args.length >= 2) goto L29;
            pw.println("Must pass at least one argument to --name");     // Catch: Throwable -> L16
            monitor-exit(r3);     // Catch: Throwable -> L16
            return;
        L29:
            String name = args[1];     // Catch: Throwable -> L16
            Dumpable dumpable2 = this.mDumpables.get(name);     // Catch: Throwable -> L16
            if (dumpable2 != null) goto L34;
            pw.printf("No dumpable named %s\n", new Object[]{name});     // Catch: Throwable -> L16
            monitor-exit(r3);     // Catch: Throwable -> L16
            return;
        L34:
            IndentingPrintWriter ipw = new IndentingPrintWriter(pw, "  ");     // Catch: Throwable -> L16
            String[] actualArgs = (String[]) Arrays.copyOfRange(args, 2, args.length);     // Catch: Throwable -> L39
            dumpable2.dump(ipw, actualArgs);     // Catch: Throwable -> L39
            ipw.close();     // Catch: Throwable -> L16
            monitor-exit(r3);     // Catch: Throwable -> L16
            return;
        L39:
            th = move-exception;
            ipw.close();     // Catch: Throwable -> L42
        L44:
            throw th;     // Catch: Throwable -> L16
        L42:
            th = move-exception;
            th.addSuppressed(th);     // Catch: Throwable -> L16
            goto L44
        L61:
            if ("--list".equals(args[0]) == false) goto L21;
            int dumpablesSize2 = this.mDumpables.size();     // Catch: Throwable -> L16
            int i2 = 0;
        L14:
            if (i2 >= dumpablesSize2) goto L19;
            pw.println(this.mDumpables.keyAt(i2));     // Catch: Throwable -> L16
            i2 = i2 + 1;     // Catch: Throwable -> L16
            goto L14
        L19:
            monitor-exit(r3);     // Catch: Throwable -> L16
            return;
        L5:
            if (args.length <= 0) goto L7;
            hasArgs = true;
            goto L8
        }

        private void addDumpable(Dumpable dumpable) {
            ArrayMap<String, Dumpable> r0 = this.mDumpables;
            monitor-enter(r0);
            this.mDumpables.put(dumpable.getDumpableName(), dumpable);     // Catch: Throwable -> L7
            monitor-exit(r0);     // Catch: Throwable -> L7
            return;
        L7:
            th = move-exception;
            throw th;
        }
    }

    public static /* synthetic */ void $r8$lambda$0ek3wX68xKbgZMUwZfiBRkUNTFs() {
        lambda$startOtherServices$3();
    }

    public static /* synthetic */ void $r8$lambda$2PdG6KuU0ZTvilD515PGrttj0sk(int r0, int r1, int r2) {
        lambda$spawnFdLeakCheckThread$0(r0, r1, r2);
    }

    /* JADX INFO: renamed from: $r8$lambda$CJLFlg8wnqihjN12r-2Qq_1qSd8, reason: not valid java name */
    public static /* synthetic */ void m393$r8$lambda$CJLFlg8wnqihjN12r2Qq_1qSd8() {
        lambda$startOtherServices$2();
    }

    public static /* synthetic */ boolean $r8$lambda$CKXj3ds6gqFm1f6gBL5oAqAHviY(IBinder r0, String r1, boolean r2, ApplicationErrorReport.ParcelableCrashInfo r3, int r4) {
        return handleEarlySystemWtf(r0, r1, r2, r3, r4);
    }

    public static /* synthetic */ void $r8$lambda$CQoJ9no8PBCQWigXqZnOQkSAyrE(SystemServer r0, TimingsTraceAndSlog r1, boolean r2, DevicePolicyManagerService.Lifecycle r3, boolean r4, Context r5, boolean r6, ConnectivityManager r7, NetworkManagementService r8, NetworkPolicyManagerService r9, VpnManagerService r10, HsumBootUserInitializer r11, CountryDetectorService r12, NetworkTimeUpdateService r13, InputManagerService r14, TelephonyRegistry r15, MediaRouterService r16, MmsServiceBroker r17) {
        r0.lambda$startOtherServices$6(r1, r2, r3, r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r15, r16, r17);
    }

    public static /* synthetic */ void $r8$lambda$SEp7M2CWq7mEDzo8pfMdSQNkGv4() {
        lambda$startOtherServices$1();
    }

    public static /* synthetic */ void $r8$lambda$W9fBdZlq2B12i1BBxZIhG9kbSqM(IBinder r0) {
        lambda$startOtherServices$5(r0);
    }

    public static /* synthetic */ void $r8$lambda$YJe3jwfhMH0kZGfHy8OK7gif2ac(SystemServer r0) {
        r0.lambda$startOtherServices$4();
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmActivityManagerService, reason: not valid java name */
    static /* bridge */ /* synthetic */ ActivityManagerService m394$$Nest$fgetmActivityManagerService(SystemServer r0) {
        return r0.mActivityManagerService;
    }

    private static native void fdtrackAbort();

    private static native void initZygoteChildHeapProfiling();

    private static native void setIncrementalServiceSystemReady(long r0);

    private static native void startHidlServices();

    private static native void startISensorManagerService();

    private static native void startIStatsService();

    private static native long startIncrementalService();

    private static native void startMemtrackProxyService();

    private static int getMaxFd() {
        FileDescriptor fd = null;
        fd = Os.open("/dev/null", OsConstants.O_RDONLY | OsConstants.O_CLOEXEC, 0);     // Catch: Throwable -> L9 ErrnoException -> L11
        int r1 = fd.getInt$();     // Catch: Throwable -> L9 ErrnoException -> L11
    L34:
        Os.close(fd);     // Catch: ErrnoException -> L6
        return r1;
    L6:
        ex = move-exception;
        throw new RuntimeException(ex);
    L11:
        ex = move-exception;
        Slog.e("System", "Failed to get maximum fd: " + ex);     // Catch: Throwable -> L9
        if (fd != null) goto L32;
        return Integer.MAX_VALUE;
    L32:
        Os.close(fd);     // Catch: ErrnoException -> L16
        return Integer.MAX_VALUE;
    L16:
        ex = move-exception;
        throw new RuntimeException(ex);
    L9:
        ex = move-exception;
        if (fd != null) goto L28;
    L27:
        throw ex;
    L28:
        Os.close(fd);     // Catch: ErrnoException -> L24
    L24:
        ex = move-exception;
        throw new RuntimeException(ex);
    }

    static {
        HEAP_DUMP_PATH = new File("/data/system/heapdump/");
    }

    private static void dumpHprof() {
        TreeSet<File> existingTombstones = new TreeSet();
        File[] r1 = HEAP_DUMP_PATH.listFiles();
        int r2 = r1.length;
        int r3 = 0;
    L3:
        if (r3 >= r2) goto L13;
        File file = r1[r3];
        if (file.isFile() == false) goto L11;
        if (file.getName().startsWith("fdtrack-") == false) goto L11;
        existingTombstones.add(file);
    L11:
        r3 = r3 + 1;
        goto L3
    L13:
        if (existingTombstones.size() < 2) goto L30;
        int i = 0;
    L16:
        if (i >= 1) goto L18;
        existingTombstones.pollLast();
        i = i + 1;
        goto L16
    L18:
        Iterator<File> r4 = existingTombstones.iterator();
    L20:
        if (r4.hasNext() == false) goto L30;
        File file2 = r4.next();
        if (file2.delete() == true) goto L20;
        Slog.w("System", "Failed to clean up hprof " + file2);
    L30:
        String date = new SimpleDateFormat("yyyy-MM-dd-HH-mm-ss").format(new Date());     // Catch: IOException -> L27
        String filename = "/data/system/heapdump/fdtrack-" + date + ".hprof";     // Catch: IOException -> L27
        Debug.dumpHprofData(filename);     // Catch: IOException -> L27
        return;
    L27:
        ex = move-exception;
        Slog.e("System", "Failed to dump fdtrack hprof", ex);
    }

    private static void spawnFdLeakCheckThread() {
        final int enableThreshold = SystemProperties.getInt(SYSPROP_FDTRACK_ENABLE_THRESHOLD, 3000);
        final int abortThreshold = SystemProperties.getInt(SYSPROP_FDTRACK_ABORT_THRESHOLD, 4400);
        final int checkInterval = SystemProperties.getInt(SYSPROP_FDTRACK_INTERVAL, 120);
        new Thread(new SystemServer$$ExternalSyntheticLambda0(enableThreshold, abortThreshold, checkInterval)).start();
    }

    /* JADX INFO: Infinite loop detected, blocks: 24, insns: 0 */
    private static /* synthetic */ void lambda$spawnFdLeakCheckThread$0(int enableThreshold, int abortThreshold, int checkInterval) {
        boolean enabled = false;
        long nextWrite = 0;
    L3:
        int maxFd = getMaxFd();
        if (maxFd <= enableThreshold) goto L6;
        System.gc();
        System.runFinalization();
        maxFd = getMaxFd();
    L6:
        int r4 = 2;
        if (maxFd <= enableThreshold) goto L10;
        if (enabled == true) goto L10;
        Slog.i("System", "fdtrack enable threshold reached, enabling");
        FrameworkStatsLog.write(364, 2, maxFd);
        System.loadLibrary("fdtrack");
        enabled = true;
    L24:
        Thread.sleep(checkInterval * 1000);     // Catch: InterruptedException -> L22
    L10:
        if (maxFd <= abortThreshold) goto L12;
        Slog.i("System", "fdtrack abort threshold reached, dumping and aborting");
        FrameworkStatsLog.write(364, 3, maxFd);
        dumpHprof();
        fdtrackAbort();
        goto L24
    L12:
        long now = SystemClock.elapsedRealtime();
        if (now <= nextWrite) goto L24;
        long nextWrite2 = 3600000 + now;
        if (enabled == true) goto L18;
        r4 = 1;
    L18:
        FrameworkStatsLog.write(364, r4, maxFd);
        nextWrite = nextWrite2;
        goto L24
    }

    public static void main(String[] args) {
        new SystemServer().run();
    }

    public SystemServer() {
        this.mIncrementalServiceHandle = 0;
        this.mDumper = new SystemServerDumper(this, null);
        boolean r1 = false;
        this.mObricExt = (IObricSystemServer) ObricImplFactory.getImpl(IObricSystemServer.class, new Object[0]);
        this.mFactoryTestMode = FactoryTest.getMode();
        this.mStartCount = SystemProperties.getInt(SYSPROP_START_COUNT, 0) + 1;
        this.mRuntimeStartElapsedTime = SystemClock.elapsedRealtime();
        this.mRuntimeStartUptime = SystemClock.uptimeMillis();
        Process.setStartTimes(this.mRuntimeStartElapsedTime, this.mRuntimeStartUptime, this.mRuntimeStartElapsedTime, this.mRuntimeStartUptime);
        if (this.mStartCount <= 1) goto L5;
        r1 = true;
    L5:
        this.mRuntimeRestart = r1;
    }

    @Override // android.util.Dumpable
    public String getDumpableName() {
        return SystemServer.class.getSimpleName();
    }

    @Override // android.util.Dumpable
    public void dump(PrintWriter pw, String[] args) {
        pw.printf("Runtime restart: %b\n", new Object[]{Boolean.valueOf(this.mRuntimeRestart)});
        pw.printf("Start count: %d\n", new Object[]{Integer.valueOf(this.mStartCount)});
        pw.print("Runtime start-up time: ");
        TimeUtils.formatDuration(this.mRuntimeStartUptime, pw);
        pw.println();
        pw.print("Runtime start-elapsed time: ");
        TimeUtils.formatDuration(this.mRuntimeStartElapsedTime, pw);
        pw.println();
    }

    private void run() {
        TimingsTraceAndSlog t = new TimingsTraceAndSlog();
        Producer.init(new InitArguments(2, 4096));     // Catch: Throwable -> L6
        t.traceBegin("InitBeforeStartServices");     // Catch: Throwable -> L6
        ExtRuntimeInit.preloadExt(SystemServer.class.getClassLoader(), "system_server_classes");     // Catch: Throwable -> L6
        SystemProperties.set(SYSPROP_START_COUNT, String.valueOf(this.mStartCount));     // Catch: Throwable -> L6
        SystemProperties.set(SYSPROP_START_ELAPSED, String.valueOf(this.mRuntimeStartElapsedTime));     // Catch: Throwable -> L6
        SystemProperties.set(SYSPROP_START_UPTIME, String.valueOf(this.mRuntimeStartUptime));     // Catch: Throwable -> L6
        EventLog.writeEvent(EventLogTags.SYSTEM_SERVER_START, new Object[]{Integer.valueOf(this.mStartCount), Long.valueOf(this.mRuntimeStartUptime), Long.valueOf(this.mRuntimeStartElapsedTime)});     // Catch: Throwable -> L6
        SystemTimeZone.initializeTimeZoneSettingsIfRequired();     // Catch: Throwable -> L6
        if (SystemProperties.get("persist.sys.language").isEmpty() == true) goto L8;
        String languageTag = Locale.getDefault().toLanguageTag();     // Catch: Throwable -> L6
        SystemProperties.set("persist.sys.locale", languageTag);     // Catch: Throwable -> L6
        SystemProperties.set("persist.sys.language", "");     // Catch: Throwable -> L6
        SystemProperties.set("persist.sys.country", "");     // Catch: Throwable -> L6
        SystemProperties.set("persist.sys.localevar", "");     // Catch: Throwable -> L6
    L8:
        Binder.setWarnOnBlocking(true);     // Catch: Throwable -> L6
        PackageItemInfo.forceSafeLabels();     // Catch: Throwable -> L6
        SQLiteGlobal.sDefaultSyncMode = "FULL";     // Catch: Throwable -> L6
        SQLiteCompatibilityWalFlags.init(null);     // Catch: Throwable -> L6
        Slog.i(TAG, "Entered the Android system server!");     // Catch: Throwable -> L6
        long uptimeMillis = SystemClock.elapsedRealtime();     // Catch: Throwable -> L6
        EventLog.writeEvent(EventLogTags.BOOT_PROGRESS_SYSTEM_RUN, uptimeMillis);     // Catch: Throwable -> L6
        SysOptBridge.getFactory().getBootEventStat().writeEvent("boot_event_sys_run", uptimeMillis);     // Catch: Throwable -> L6
        if (this.mRuntimeRestart == true) goto L11;
        FrameworkStatsLog.write(FrameworkStatsLog.BOOT_TIME_EVENT_ELAPSED_TIME_REPORTED, 19, uptimeMillis);     // Catch: Throwable -> L6
    L11:
        SystemProperties.set("persist.sys.dalvik.vm.lib.2", VMRuntime.getRuntime().vmLibrary());     // Catch: Throwable -> L6
        VMRuntime.getRuntime().clearGrowthLimit();     // Catch: Throwable -> L6
        Build.ensureFingerprintProperty();     // Catch: Throwable -> L6
        Environment.setUserRequired(true);     // Catch: Throwable -> L6
        BaseBundle.setShouldDefuse(true);     // Catch: Throwable -> L6
        Parcel.setStackTraceParceling(true);     // Catch: Throwable -> L6
        BinderInternal.disableBackgroundScheduling(true);     // Catch: Throwable -> L6
        BinderInternal.setMaxThreads(31);     // Catch: Throwable -> L6
        Process.setThreadPriority(-2);     // Catch: Throwable -> L6
        Process.setCanSelfBackground(false);     // Catch: Throwable -> L6
        Looper.prepareMainLooper();     // Catch: Throwable -> L6
        Looper.getMainLooper().setSlowLogThresholdMs(SLOW_DISPATCH_THRESHOLD_MS, SLOW_DELIVERY_THRESHOLD_MS);     // Catch: Throwable -> L6
        SystemServiceRegistry.sEnableServiceNotFoundWtf = true;     // Catch: Throwable -> L6
        SystemServerInitThreadPool tp = SystemServerInitThreadPool.start();     // Catch: Throwable -> L6
        SystemServerDumper.m395$$Nest$maddDumpable(this.mDumper, tp);     // Catch: Throwable -> L6
        startSystemConfigInit(t);     // Catch: Throwable -> L6
        System.loadLibrary("android_servers");     // Catch: Throwable -> L6
        initZygoteChildHeapProfiling();     // Catch: Throwable -> L6
        if (Build.IS_DEBUGGABLE == false) goto L14;
        spawnFdLeakCheckThread();     // Catch: Throwable -> L6
    L14:
        performPendingShutdown();     // Catch: Throwable -> L6
        createSystemContext();     // Catch: Throwable -> L6
        ActivityThread.initializeMainlineModules();     // Catch: Throwable -> L6
        ServiceManager.addService("system_server_dumper", this.mDumper);     // Catch: Throwable -> L6
        SystemServerDumper.m395$$Nest$maddDumpable(this.mDumper, this);     // Catch: Throwable -> L6
        this.mSystemServiceManager = new SystemServiceManager(this.mSystemContext);     // Catch: Throwable -> L6
        this.mSystemServiceManager.setStartInfo(this.mRuntimeRestart, this.mRuntimeStartElapsedTime, this.mRuntimeStartUptime);     // Catch: Throwable -> L6
        SystemServerDumper.m395$$Nest$maddDumpable(this.mDumper, this.mSystemServiceManager);     // Catch: Throwable -> L6
        LocalServices.addService(SystemServiceManager.class, this.mSystemServiceManager);     // Catch: Throwable -> L6
        if (Build.IS_DEBUGGABLE == false) goto L25;
        String jvmtiAgent = SystemProperties.get("persist.sys.dalvik.jvmtiagent");     // Catch: Throwable -> L6
        if (jvmtiAgent.isEmpty() == true) goto L25;
        int equalIndex = jvmtiAgent.indexOf(61);     // Catch: Throwable -> L6
        String libraryPath = jvmtiAgent.substring(0, equalIndex);     // Catch: Throwable -> L6
        String parameterList = jvmtiAgent.substring(equalIndex + 1, jvmtiAgent.length());     // Catch: Throwable -> L6
        Debug.attachJvmtiAgent(libraryPath, parameterList, null);     // Catch: Throwable -> L6 Exception -> L23
    L24:
        Slog.e("System", "*************************************************");     // Catch: Throwable -> L6
        Slog.e("System", "********** Failed to load jvmti plugin: " + jvmtiAgent);     // Catch: Throwable -> L6
    L25:
        t.traceEnd();
        t.traceBegin("InitSysMonitorService.");     // Catch: Throwable -> L47
        SysOptBridge.getFactory().getSysMonitorService().initContext(this.mSystemContext);     // Catch: Throwable -> L47
        t.traceEnd();
        RuntimeInit.setDefaultApplicationWtfHandler(new SystemServer$$ExternalSyntheticLambda4());
        ApplicationSharedMemory instance = ApplicationSharedMemory.create();
        ApplicationSharedMemory.setInstance(instance);
        t.traceBegin("StartServices");     // Catch: Throwable -> L41
        ServiceManager.addService(VendorConfigService.SERVICE_NAME, new VendorConfigService(this.mSystemContext));     // Catch: Throwable -> L41
        startBootstrapServices(t);     // Catch: Throwable -> L41
        startCoreServices(t);     // Catch: Throwable -> L41
        startOtherServices(t);     // Catch: Throwable -> L41
        startApexServices(t);     // Catch: Throwable -> L41
        updateWatchdogTimeout(t);     // Catch: Throwable -> L41
        CriticalEventLog.getInstance().logSystemServerStarted();     // Catch: Throwable -> L41
        t.traceEnd();
        StrictMode.initVmDefaults(null);
        if (this.mRuntimeRestart == false) goto L32;
    L36:
        SysOptBridge.getFactory().getBootEventStat().writeEvent("boot_event_sys_ready", SystemClock.elapsedRealtime());
        if (this.mRuntimeRestart == false) goto L39;
        SysOptBridge.getFactory().getBootEventStat().setBootType(3);
        EventLog.writeEvent(EventLogTags.BOOT_SYS_BOOTTYPE, 3);
    L39:
        Binder.setTransactionCallback(new AnonymousClass1(this));
        VMRuntime.addPostCleanupCallback(new AnonymousClass2(this));
        Looper.loop();
        throw new RuntimeException("Main thread loop unexpectedly exited");
    L32:
        if (isFirstBootOrUpgrade() == true) goto L36;
        long uptimeMillis2 = SystemClock.elapsedRealtime();
        FrameworkStatsLog.write(FrameworkStatsLog.BOOT_TIME_EVENT_ELAPSED_TIME_REPORTED, 20, uptimeMillis2);
        if (uptimeMillis2 <= 60000) goto L36;
        Slog.wtf(TimingsTraceAndSlog.SYSTEM_SERVER_TIMING_TAG, "SystemServer init took too long. uptimeMillis=" + uptimeMillis2);
    L41:
        ex = move-exception;
        Slog.e("System", "******************************************");     // Catch: Throwable -> L44
        Slog.e("System", "************ Failure starting system services", ex);     // Catch: Throwable -> L44
        throw ex;     // Catch: Throwable -> L44
    L44:
        ex = move-exception;
        t.traceEnd();
        throw ex;
    L47:
        ex = move-exception;
        Slog.e("System", "******************************************");     // Catch: Throwable -> L50
        Slog.e("System", "************ Failure init SysMonitorService", ex);     // Catch: Throwable -> L50
        throw ex;     // Catch: Throwable -> L50
    L50:
        ex = move-exception;
        t.traceEnd();
        throw ex;
    L6:
        th = move-exception;
        t.traceEnd();
        throw th;
    }

    private static boolean isValidTimeZoneId(String timezoneProperty) {
        if (timezoneProperty != null) goto L4;
    L8:
        return false;
    L4:
        if (timezoneProperty.isEmpty() == true) goto L8;
        if (ZoneInfoDb.getInstance().hasTimeZone(timezoneProperty) == false) goto L8;
        return true;
    }

    private boolean isFirstBootOrUpgrade() {
        if (this.mPackageManagerService.isFirstBoot() == false) goto L5;
    L8:
        return true;
    L5:
        if (this.mPackageManagerService.isDeviceUpgrading() == true) goto L8;
        return false;
    }

    private void reportWtf(String msg, Throwable e) {
        Slog.w(TAG, "***********************************************");
        Slog.wtf(TAG, "BOOT FAILURE " + msg, e);
    }

    private void performPendingShutdown() {
        String shutdownAction = SystemProperties.get(ShutdownThread.SHUTDOWN_ACTION_PROPERTY, "");
        if (shutdownAction != null) goto L5;
        return;
    L5:
        if (shutdownAction.length() > 0) goto L7;
        return;
    L7:
        if (shutdownAction.charAt(0) != '1') goto L9;
        final boolean reboot = true;
    L11:
        if (shutdownAction.length() <= 1) goto L13;
        final String reason = shutdownAction.substring(1, shutdownAction.length());
    L14:
        if (reason != null) goto L16;
    L31:
        Runnable runnable = new AnonymousClass3(this, reboot, reason);
        Message msg = Message.obtain(UiThread.getHandler(), runnable);
        msg.setAsynchronous(true);
        UiThread.getHandler().sendMessage(msg);
        return;
    L16:
        if (reason.startsWith("recovery-update") == false) goto L31;
        File packageFile = new File(UNCRYPT_PACKAGE_FILE);
        if (packageFile.exists() == false) goto L31;
        String filename = null;
        filename = FileUtils.readTextFile(packageFile, 0, null);     // Catch: IOException -> L22
    L24:
        if (filename == null) goto L31;
        if (filename.startsWith("/data") == false) goto L31;
        if (new File(BLOCK_MAP_FILE).exists() == true) goto L31;
        Slog.e(TAG, "Can't find block map file, uncrypt failed or unexpected runtime restart?");
        return;
    L22:
        e = move-exception;
        Slog.e(TAG, "Error reading uncrypt package file", e);
        goto L24
    L13:
        reason = null;
        goto L14
    L9:
        reboot = false;
        goto L11
    }

    private void startSystemConfigInit(TimingsTraceAndSlog t) {
        Slog.i(TAG, "Reading configuration...");
        t.traceBegin("ReadingSystemConfig");
        SystemServerInitThreadPool.submit(new SystemServer$$ExternalSyntheticLambda1(), "ReadingSystemConfig");
        t.traceEnd();
    }

    private void createSystemContext() {
        ActivityThread activityThread = ActivityThread.systemMain();
        this.mSystemContext = activityThread.getSystemContext();
        this.mSystemContext.setTheme(16975060);
        Context systemUiContext = activityThread.getSystemUiContext();
        systemUiContext.setTheme(16975060);
        Trace.registerWithPerfetto();
    }

    /* JADX WARN: Type inference failed for: r3v4, types: [android.os.IBinder, com.android.server.compat.PlatformCompat] */
    private void startBootstrapServices(TimingsTraceAndSlog t) {
        t.traceBegin("startBootstrapServices");
        t.traceBegin("ArtModuleServiceInitializer");
        ArtModuleServiceInitializer.setArtModuleServiceManager(new ArtModuleServiceManager());
        t.traceEnd();
        t.traceBegin("StartWatchdog");
        Watchdog watchdog = Watchdog.getInstance();
        watchdog.start();
        SystemServerDumper.m395$$Nest$maddDumpable(this.mDumper, watchdog);
        t.traceEnd();
        t.traceBegin("InitializeProtoLog");
        ProtoLog.init(WmProtoLogGroups.values());
        t.traceEnd();
        t.traceBegin("PlatformCompat");
        ?? r3 = new PlatformCompat(this.mSystemContext);
        ServiceManager.addService("platform_compat", r3);
        ServiceManager.addService("platform_compat_native", new PlatformCompatNative(r3));
        AppCompatCallbacks.install(new long[0], new long[0]);
        t.traceEnd();
        t.traceBegin("StartFileIntegrityService");
        this.mSystemServiceManager.startService(FileIntegrityService.class);
        t.traceEnd();
        t.traceBegin("StartInstaller");
        Installer installer = (Installer) this.mSystemServiceManager.startService(Installer.class);
        t.traceEnd();
        t.traceBegin("DeviceIdentifiersPolicyService");
        this.mSystemServiceManager.startService(DeviceIdentifiersPolicyService.class);
        t.traceEnd();
        t.traceBegin("StartFeatureFlagsService");
        this.mSystemServiceManager.startService(FeatureFlagsService.class);
        t.traceEnd();
        t.traceBegin("UriGrantsManagerService");
        this.mSystemServiceManager.startService(UriGrantsManagerService.Lifecycle.class);
        t.traceEnd();
        t.traceBegin("StartPowerStatsService");
        this.mSystemServiceManager.startService(PowerStatsService.class);
        t.traceEnd();
        t.traceBegin("StartIStatsService");
        startIStatsService();
        t.traceEnd();
        t.traceBegin("MemtrackProxyService");
        startMemtrackProxyService();
        t.traceEnd();
        t.traceBegin("StartAccessCheckingService");
        LocalServices.addService(PermissionMigrationHelper.class, new PermissionMigrationHelperImpl());
        LocalServices.addService(AppOpMigrationHelper.class, new AppOpMigrationHelperImpl());
        this.mSystemServiceManager.startService(AccessCheckingService.class);
        t.traceEnd();
        t.traceBegin("StartActivityManager");
        ActivityTaskManagerService atm = ((ActivityTaskManagerService.Lifecycle) this.mSystemServiceManager.startService(ActivityTaskManagerService.Lifecycle.class)).getService();
        this.mActivityManagerService = ActivityManagerService.Lifecycle.startService(this.mSystemServiceManager, atm);
        this.mActivityManagerService.setSystemServiceManager(this.mSystemServiceManager);
        this.mActivityManagerService.setInstaller(installer);
        this.mWindowManagerGlobalLock = atm.getGlobalLock();
        t.traceEnd();
        SysMonitorSvcBridge.getFactory().getSysMonitorService().initActivityManagerService(this.mActivityManagerService);
        t.traceBegin("StartDataLoaderManagerService");
        this.mDataLoaderManagerService = (DataLoaderManagerService) this.mSystemServiceManager.startService(DataLoaderManagerService.class);
        t.traceEnd();
        t.traceBegin("StartIncrementalService");
        this.mIncrementalServiceHandle = startIncrementalService();
        t.traceEnd();
        t.traceBegin("StartPowerManager");
        this.mPowerManagerService = (PowerManagerService) this.mSystemServiceManager.startService(PowerManagerService.class);
        t.traceEnd();
        SysMonitorSvcBridge.getFactory().getSysMonitorService().initPowerManagerService(this.mPowerManagerService);
        t.traceBegin("StartBytedancePowerAdvisor");
        SysOptBridge.getFactory().startBytedancePowerAdvisor(this.mSystemServiceManager);
        t.traceEnd();
        t.traceBegin("StartThermalManager");
        this.mSystemServiceManager.startService(ThermalManagerService.class);
        t.traceEnd();
        t.traceBegin("InitPowerManagement");
        this.mActivityManagerService.initPowerManagement();
        t.traceEnd();
        t.traceBegin("StartRecoverySystemService");
        this.mSystemServiceManager.startService(RecoverySystemService.Lifecycle.class);
        t.traceEnd();
        t.traceBegin("StartLightsService");
        this.mSystemServiceManager.startService(LightsService.class);
        t.traceEnd();
        t.traceBegin("StartTouchService");
        this.mSystemServiceManager.startService(TouchService.class);
        t.traceEnd();
        t.traceBegin("StartLocalToneMappingService");
        this.mSystemServiceManager.startService(LocalToneMappingService.class);
        t.traceEnd();
        t.traceBegin("StartDisplayOffloadService");
        if (SystemProperties.getBoolean("config.enable_display_offload", false) == false) goto L6;
        this.mSystemServiceManager.startService(WEAR_DISPLAYOFFLOAD_SERVICE_CLASS);
    L6:
        if (SystemProperties.getBoolean("config.enable_qti_display_offload", false) == false) goto L8;
        this.mSystemServiceManager.startService("com.qualcomm.qti.server.offloadservice.OffloadManagerService");
    L8:
        t.traceEnd();
        t.traceBegin("StartSuspendManagerService");
        if (SystemProperties.getBoolean("config.enable_qti_suspend_manager", false) == false) goto L11;
        this.mSystemServiceManager.startService("com.qualcomm.qti.server.suspendservice.SuspendManagerService");
    L11:
        t.traceEnd();
        t.traceBegin("StartDisplayManager");
        this.mDisplayManagerService = (DisplayManagerService) this.mSystemServiceManager.startService(DisplayManagerService.class);
        t.traceEnd();
        t.traceBegin("WaitForDisplay");
        this.mSystemServiceManager.startBootPhase(t, 100);
        t.traceEnd();
        if (this.mRuntimeRestart == true) goto L14;
        FrameworkStatsLog.write(FrameworkStatsLog.BOOT_TIME_EVENT_ELAPSED_TIME_REPORTED, 14, SystemClock.elapsedRealtime());
    L14:
        t.traceBegin("StartDomainVerificationService");
        DomainVerificationService domainVerificationService = new DomainVerificationService(this.mSystemContext, SystemConfig.getInstance(), r3);
        this.mSystemServiceManager.startService(domainVerificationService);
        t.traceEnd();
        t.traceBegin("StartPackageManagerService");
        Watchdog.getInstance().pauseWatchingCurrentThread("packagemanagermain");     // Catch: Throwable -> L49
        Context r9 = this.mSystemContext;     // Catch: Throwable -> L49
        if (this.mFactoryTestMode == 0) goto L18;
        boolean r10 = true;
    L19:
        this.mPackageManagerService = PackageManagerService.main(r9, installer, domainVerificationService, r10);     // Catch: Throwable -> L49
        Watchdog.getInstance().resumeWatchingCurrentThread("packagemanagermain");
        SysMonitorSvcBridge.getFactory().getSysMonitorService().initPackageManagerService(this.mPackageManagerService);
        this.mFirstBoot = this.mPackageManagerService.isFirstBoot();
        this.mPackageManager = this.mSystemContext.getPackageManager();
        t.traceEnd();
        t.traceBegin("DexUseManagerLocal");
        LocalManagerRegistry.addManager(DexUseManagerLocal.class, DexUseManagerLocal.createInstance(this.mSystemContext));
        t.traceEnd();
        if (this.mRuntimeRestart == false) goto L23;
    L25:
        boolean disableOtaDexopt = SystemProperties.getBoolean("config.disable_otadexopt", false);
        if (disableOtaDexopt == true) goto L37;
        t.traceBegin("StartOtaDexOptService");
        Watchdog.getInstance().pauseWatchingCurrentThread("moveab");     // Catch: Throwable -> L30
        OtaDexoptService.main(this.mSystemContext, this.mPackageManagerService);     // Catch: Throwable -> L30
    L29:
        Watchdog.getInstance().resumeWatchingCurrentThread("moveab");
        t.traceEnd();
    L30:
        e = move-exception;
        reportWtf("starting OtaDexOptService", e);     // Catch: Throwable -> L33
    L33:
        th = move-exception;
        Watchdog.getInstance().resumeWatchingCurrentThread("moveab");
        t.traceEnd();
        throw th;
    L37:
        if (Build.IS_ARC == false) goto L39;
        t.traceBegin("StartArcSystemHealthService");
        this.mSystemServiceManager.startService(ARC_SYSTEM_HEALTH_SERVICE);
        t.traceEnd();
    L39:
        t.traceBegin("StartUserManagerService");
        this.mSystemServiceManager.startService(UserManagerService.LifeCycle.class);
        t.traceEnd();
        t.traceBegin("InitAttributerCache");
        AttributeCache.init(this.mSystemContext);
        t.traceEnd();
        t.traceBegin("SetSystemProcess");
        this.mActivityManagerService.setSystemProcess();
        t.traceEnd();
        r3.registerPackageReceiver(this.mSystemContext);
        t.traceBegin("InitWatchdog");
        watchdog.init(this.mSystemContext, this.mActivityManagerService);
        t.traceEnd();
        this.mDisplayManagerService.setupSchedulerPolicies();
        t.traceBegin("StartOverlayManagerService");
        this.mSystemServiceManager.startService(new OverlayManagerService(this.mSystemContext));
        t.traceEnd();
        t.traceBegin("StartResourcesManagerService");
        ResourcesManagerService resourcesService = new ResourcesManagerService(this.mSystemContext);
        resourcesService.setActivityManagerService(this.mActivityManagerService);
        this.mSystemServiceManager.startService(resourcesService);
        t.traceEnd();
        t.traceBegin("StartSensorPrivacyService");
        this.mSystemServiceManager.startService(new SensorPrivacyService(this.mSystemContext));
        t.traceEnd();
        t.traceBegin("StartBDSecurityService");
        this.mSystemServiceManager.startService(BDSecurityService.class);
        t.traceEnd();
        t.traceBegin("StartVirtService");
        this.mSystemServiceManager.startService(VirtService.class);
        t.traceEnd();
        t.traceBegin("StartObricSecurityService");
        this.mSystemServiceManager.startService("com.obric.server.security.ObricSecurityService");     // Catch: Throwable -> L42
    L44:
        t.traceEnd();
        if (SystemProperties.getInt("persist.sys.displayinset.top", 0) <= 0) goto L47;
        this.mActivityManagerService.updateSystemUiContext();
        ((DisplayManagerInternal) LocalServices.getService(DisplayManagerInternal.class)).onOverlayChanged();
    L47:
        t.traceBegin("StartSensorService");
        this.mSystemServiceManager.startService(SensorService.class);
        t.traceEnd();
        t.traceEnd();
        return;
    L42:
        e = move-exception;
        reportWtf("starting ObricSecurityService", e);
        goto L44
    L23:
        if (isFirstBootOrUpgrade() == true) goto L25;
        FrameworkStatsLog.write(FrameworkStatsLog.BOOT_TIME_EVENT_ELAPSED_TIME_REPORTED, 15, SystemClock.elapsedRealtime());
        goto L25
    L18:
        r10 = false;
    L49:
        th = move-exception;
        Watchdog.getInstance().resumeWatchingCurrentThread("packagemanagermain");
        throw th;
    }

    private void startCoreServices(TimingsTraceAndSlog t) {
        t.traceBegin("startCoreServices");
        t.traceBegin("StartSystemConfigService");
        this.mSystemServiceManager.startService(SystemConfigService.class);
        t.traceEnd();
        t.traceBegin("StartBatteryService");
        this.mSystemServiceManager.startService(BatteryService.class);
        t.traceEnd();
        t.traceBegin("StartUsageService");
        this.mSystemServiceManager.startService(UsageStatsService.class);
        this.mActivityManagerService.setUsageStatsManager((UsageStatsManagerInternal) LocalServices.getService(UsageStatsManagerInternal.class));
        t.traceEnd();
        if (this.mPackageManager.hasSystemFeature("android.software.webview") == false) goto L5;
        t.traceBegin("StartWebViewUpdateService");
        this.mWebViewUpdateService = (WebViewUpdateService) this.mSystemServiceManager.startService(WebViewUpdateService.class);
        t.traceEnd();
    L5:
        t.traceBegin("StartCachedDeviceStateService");
        this.mSystemServiceManager.startService(CachedDeviceStateService.class);
        t.traceEnd();
        t.traceBegin("StartBinderCallsStatsService");
        this.mSystemServiceManager.startService(BinderCallsStatsService.LifeCycle.class);
        t.traceEnd();
        t.traceBegin("StartLooperStatsService");
        this.mSystemServiceManager.startService(LooperStatsService.Lifecycle.class);
        t.traceEnd();
        t.traceBegin("StartRollbackManagerService");
        this.mSystemServiceManager.startService(RollbackManagerService.class);
        t.traceEnd();
        t.traceBegin("StartNativeTombstoneManagerService");
        this.mSystemServiceManager.startService(NativeTombstoneManagerService.class);
        t.traceEnd();
        t.traceBegin("StartBugreportManagerService");
        this.mSystemServiceManager.startService(BugreportManagerService.class);
        t.traceEnd();
        t.traceBegin(GpuService.TAG);
        this.mSystemServiceManager.startService(GpuService.class);
        t.traceEnd();
        t.traceBegin("StartRemoteProvisioningService");
        this.mSystemServiceManager.startService(RemoteProvisioningService.class);
        t.traceEnd();
        if (Build.IS_DEBUGGABLE == false) goto L8;
    L9:
        t.traceBegin("CpuMonitorService");
        this.mSystemServiceManager.startService(CpuMonitorService.class);
        t.traceEnd();
    L10:
        t.traceEnd();
        return;
    L8:
        if (Build.IS_ENG == false) goto L10;
        goto L9
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r10v30, types: [com.android.server.net.NetworkPolicyManagerService] */
    /* JADX WARN: Type inference failed for: r11v12, types: [android.os.IBinder, com.android.server.wm.WindowManagerService] */
    /* JADX WARN: Type inference failed for: r11v18, types: [com.android.server.am.ActivityManagerService] */
    /* JADX WARN: Type inference failed for: r11v49 */
    /* JADX WARN: Type inference failed for: r11v50 */
    /* JADX WARN: Type inference failed for: r11v51 */
    /* JADX WARN: Type inference failed for: r11v52 */
    /* JADX WARN: Type inference failed for: r11v53, types: [android.os.IBinder, com.android.server.statusbar.StatusBarManagerService] */
    /* JADX WARN: Type inference failed for: r11v66, types: [com.android.server.VpnManagerService] */
    /* JADX WARN: Type inference failed for: r11v83 */
    /* JADX WARN: Type inference failed for: r11v84 */
    /* JADX WARN: Type inference failed for: r13v10 */
    /* JADX WARN: Type inference failed for: r13v11 */
    /* JADX WARN: Type inference failed for: r13v12 */
    /* JADX WARN: Type inference failed for: r13v13, types: [android.os.IBinder] */
    /* JADX WARN: Type inference failed for: r13v22, types: [com.android.server.CountryDetectorService] */
    /* JADX WARN: Type inference failed for: r13v23 */
    /* JADX WARN: Type inference failed for: r13v24 */
    /* JADX WARN: Type inference failed for: r15v0 */
    /* JADX WARN: Type inference failed for: r15v1 */
    /* JADX WARN: Type inference failed for: r15v2 */
    /* JADX WARN: Type inference failed for: r15v3, types: [android.os.IBinder] */
    /* JADX WARN: Type inference failed for: r15v7 */
    /* JADX WARN: Type inference failed for: r15v8 */
    /* JADX WARN: Type inference failed for: r17v6, types: [com.android.server.media.MediaRouterService] */
    /* JADX WARN: Type inference failed for: r34v12 */
    /* JADX WARN: Type inference failed for: r34v13 */
    /* JADX WARN: Type inference failed for: r34v14 */
    /* JADX WARN: Type inference failed for: r39v14 */
    /* JADX WARN: Type inference failed for: r39v15 */
    /* JADX WARN: Type inference failed for: r39v16 */
    /* JADX WARN: Type inference failed for: r39v17 */
    /* JADX WARN: Type inference failed for: r39v18 */
    /* JADX WARN: Type inference failed for: r39v26 */
    /* JADX WARN: Type inference failed for: r39v27 */
    /* JADX WARN: Type inference failed for: r3v28, types: [android.os.IBinder, com.android.server.TelephonyRegistry] */
    /* JADX WARN: Type inference failed for: r3v292 */
    /* JADX WARN: Type inference failed for: r3v293 */
    /* JADX WARN: Type inference failed for: r3v79 */
    /* JADX WARN: Type inference failed for: r3v80 */
    /* JADX WARN: Type inference failed for: r3v81 */
    /* JADX WARN: Type inference failed for: r3v82, types: [android.os.IBinder] */
    /* JADX WARN: Type inference failed for: r43v1 */
    /* JADX WARN: Type inference failed for: r43v2 */
    /* JADX WARN: Type inference failed for: r43v3 */
    /* JADX WARN: Type inference failed for: r45v0 */
    /* JADX WARN: Type inference failed for: r47v0 */
    /* JADX WARN: Type inference failed for: r47v1 */
    /* JADX WARN: Type inference failed for: r47v2 */
    /* JADX WARN: Type inference failed for: r48v0 */
    /* JADX WARN: Type inference failed for: r50v0 */
    /* JADX WARN: Type inference failed for: r50v1 */
    /* JADX WARN: Type inference failed for: r50v2 */
    /* JADX WARN: Type inference failed for: r8v19, types: [android.os.IBinder] */
    /* JADX WARN: Type inference failed for: r8v5 */
    /* JADX WARN: Type inference failed for: r8v6 */
    /* JADX WARN: Type inference failed for: r8v7, types: [com.android.server.net.NetworkPolicyManagerService] */
    /* JADX WARN: Type inference failed for: r8v83 */
    /* JADX WARN: Type inference failed for: r8v84 */
    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    private void startOtherServices(final TimingsTraceAndSlog r57) {
        r57.traceBegin("startOtherServices");
        this.mSystemServiceManager.updateOtherServicesStartIndex();
        final Context r6 = this.mSystemContext;
        ?? r15 = 0;
        IPacProxyManager.Stub r16 = null;
        Object r17 = null;
        Object r18 = null;
        boolean r20 = SystemProperties.getBoolean("config.disable_systemtextclassifier", false);
        boolean r21 = SystemProperties.getBoolean("config.disable_networktime", false);
        boolean r22 = SystemProperties.getBoolean("config.disable_cameraservice", false);
        boolean r23 = SystemProperties.getBoolean("persist.vendor.wigig.enable", false);
        boolean r25 = r6.getPackageManager().hasSystemFeature("android.hardware.type.pc");
        boolean r5 = RoSystemFeatures.hasFeatureWatch(r6);
        boolean r27 = r6.getPackageManager().hasSystemFeature("org.chromium.arc");
        boolean r28 = r6.getPackageManager().hasSystemFeature("android.software.leanback");
        final boolean r3 = RoSystemFeatures.hasFeatureAutomotive(r6);
        boolean r30 = r6.getPackageManager().hasSystemFeature("android.hardware.vr.high_performance");
        this.mZygotePreload = SystemServerInitThreadPool.submit(new SystemServer$$ExternalSyntheticLambda5(), "SecondaryZygotePreload");     // Catch: Throwable -> L804
        r57.traceBegin("StartKeyAttestationApplicationIdProviderService");     // Catch: Throwable -> L804
        ServiceManager.addService("sec_key_att_app_id_provider", new KeyAttestationApplicationIdProviderService(r6));     // Catch: Throwable -> L804
        r57.traceEnd();     // Catch: Throwable -> L804
        r57.traceBegin("StartKeyChainSystemService");     // Catch: Throwable -> L804
        this.mSystemServiceManager.startService(KeyChainSystemService.class);     // Catch: Throwable -> L804
        r57.traceEnd();     // Catch: Throwable -> L804
        r57.traceBegin("StartBinaryTransparencyService");     // Catch: Throwable -> L804
        this.mSystemServiceManager.startService(BinaryTransparencyService.class);     // Catch: Throwable -> L804
        r57.traceEnd();     // Catch: Throwable -> L804
        r57.traceBegin("StartSchedulingPolicyService");     // Catch: Throwable -> L804
        ServiceManager.addService("scheduling_policy", new SchedulingPolicyService());     // Catch: Throwable -> L804
        r57.traceEnd();     // Catch: Throwable -> L804
        if (this.mPackageManager.hasSystemFeature("android.hardware.microphone") == false) goto L904;
    L14:
        r57.traceBegin("StartTelecomLoaderService");     // Catch: Throwable -> L804
        this.mSystemServiceManager.startService(TelecomLoaderService.class);     // Catch: Throwable -> L804
        r57.traceEnd();     // Catch: Throwable -> L804
    L15:
        r57.traceBegin("StartTelephonyRegistry");     // Catch: Throwable -> L804
        final ?? r4 = new TelephonyRegistry(r6, new TelephonyRegistry.ConfigurationProvider());     // Catch: Throwable -> L804
        ServiceManager.addService("telephony.registry", r4);     // Catch: Throwable -> L802
        r57.traceEnd();     // Catch: Throwable -> L802
        r57.traceBegin("StartEntropyMixer");     // Catch: Throwable -> L802
        this.mEntropyMixer = new EntropyMixer(r6);     // Catch: Throwable -> L802
        r57.traceEnd();     // Catch: Throwable -> L802
        this.mContentResolver = r6.getContentResolver();     // Catch: Throwable -> L802
        r57.traceBegin("StartAccountManagerService");     // Catch: Throwable -> L802
        this.mSystemServiceManager.startService(AccountManagerService.Lifecycle.class);     // Catch: Throwable -> L802
        r57.traceEnd();     // Catch: Throwable -> L802
        r57.traceBegin("StartContentService");     // Catch: Throwable -> L802
        this.mSystemServiceManager.startService(ContentService.Lifecycle.class);     // Catch: Throwable -> L802
        r57.traceEnd();     // Catch: Throwable -> L802
        r57.traceBegin("InstallSystemProviders");     // Catch: Throwable -> L802
        this.mActivityManagerService.getContentProviderHelper().installSystemProviders();     // Catch: Throwable -> L802
        this.mSystemServiceManager.startService(UPDATABLE_DEVICE_CONFIG_SERVICE_CLASS);     // Catch: Throwable -> L802
        SQLiteCompatibilityWalFlags.reset();     // Catch: Throwable -> L802
        r57.traceEnd();     // Catch: Throwable -> L802
        if (Build.isDebuggable() == true) goto L932;
    L22:
        r57.traceBegin("StartDropBoxManager");     // Catch: Throwable -> L802
        this.mSystemServiceManager.startService(DropBoxManagerService.class);     // Catch: Throwable -> L802
        r57.traceEnd();     // Catch: Throwable -> L802
        r57.traceBegin("StartEnhancedConfirmationService");     // Catch: Throwable -> L802
        this.mSystemServiceManager.startService(ENHANCED_CONFIRMATION_SERVICE_CLASS);     // Catch: Throwable -> L802
        r57.traceEnd();     // Catch: Throwable -> L802
        r57.traceBegin("StartHintManager");     // Catch: Throwable -> L802
        this.mSystemServiceManager.startService(HintManagerService.class);     // Catch: Throwable -> L802
        r57.traceEnd();     // Catch: Throwable -> L802
        r57.traceBegin("StartRoleManagerService");     // Catch: Throwable -> L802
        LocalManagerRegistry.addManager(RoleServicePlatformHelper.class, new RoleServicePlatformHelperImpl(this.mSystemContext));     // Catch: Throwable -> L800
        this.mSystemServiceManager.startService(ROLE_SERVICE_CLASS);     // Catch: Throwable -> L800
        r57.traceEnd();     // Catch: Throwable -> L800
        r57.traceBegin("StartOmsDeviceInfoManagerService");     // Catch: Throwable -> L800
        this.mSystemServiceManager.startService(DeviceInfoManagerService.class);     // Catch: Throwable -> L800
        r57.traceEnd();     // Catch: Throwable -> L800
        r57.traceBegin("StartOmsMonitorManagerService");     // Catch: Throwable -> L800
        this.mSystemServiceManager.startService(OmsMonitorManagerService.class);     // Catch: Throwable -> L800
        r57.traceEnd();     // Catch: Throwable -> L800
        if (r5 == true) goto L26;
    L26:
        r57.traceBegin("StartSupervisionService");     // Catch: Throwable -> L800
        this.mSystemServiceManager.startService(SupervisionService.Lifecycle.class);     // Catch: Throwable -> L800
        r57.traceEnd();     // Catch: Throwable -> L800
        if (r28 == true) goto L33;
        if (r25 == true) goto L33;
        r57.traceBegin("StartVibratorManagerService");     // Catch: Throwable -> L31
        this.mSystemServiceManager.startService(VibratorManagerService.Lifecycle.class);     // Catch: Throwable -> L31
        r57.traceEnd();     // Catch: Throwable -> L31
    L31:
        th = th;
    L808:
        Slog.e("System", "******************************************");
        Slog.e("System", "************ Failure starting core service");
        throw th;
    L33:
        r57.traceBegin("StartDynamicSystemService");     // Catch: Throwable -> L800
        ServiceManager.addService("dynamic_system", new DynamicSystemService(r6));     // Catch: Throwable -> L798
        r57.traceEnd();     // Catch: Throwable -> L798
        if (r6.getPackageManager().hasSystemFeature("android.hardware.consumerir") == true) goto L894;
        IConsumerIrService.Stub r19 = null;
    L896:
        r57.traceBegin("StartAlarmManagerService");     // Catch: Throwable -> L796
        this.mSystemServiceManager.startService(AlarmManagerService.class);     // Catch: Throwable -> L796
        r57.traceEnd();     // Catch: Throwable -> L796
        r57.traceBegin("StartInputManagerService");     // Catch: Throwable -> L796
        InputManagerService r7 = ((InputManagerService.Lifecycle) this.mSystemServiceManager.startService(InputManagerService.Lifecycle.class)).getService();     // Catch: Throwable -> L796
        r57.traceEnd();     // Catch: Throwable -> L794
        r57.traceBegin("DeviceStateManagerService");     // Catch: Throwable -> L794
        this.mSystemServiceManager.startService(DeviceStateManagerService.class);     // Catch: Throwable -> L794
        r57.traceEnd();     // Catch: Throwable -> L794
        if (r22 == false) goto L840;
    L48:
        r57.traceBegin("StartWindowManagerService");     // Catch: Throwable -> L794
        this.mSystemServiceManager.startBootPhase(r57, 200);     // Catch: Throwable -> L794
        if (this.mFirstBoot == true) goto L51;
        boolean r11 = true;
    L52:
        ?? r12 = WindowManagerService.main(r6, r7, r11, new PhoneWindowManager(), this.mActivityManagerService.mActivityTaskManager);     // Catch: Throwable -> L794
        ServiceManager.addService("window", r12, false, 19);     // Catch: Throwable -> L792
        r57.traceEnd();     // Catch: Throwable -> L792
        r57.traceBegin("StartActivityEventsService");     // Catch: Throwable -> L792
        ServiceManager.addService("activityevent", new ZTEActivityEventsService(r6, r12));     // Catch: Throwable -> L792
        r57.traceEnd();     // Catch: Throwable -> L792
        r57.traceBegin("SetWindowManagerService");     // Catch: Throwable -> L792
        this.mActivityManagerService.setWindowManager(r12);     // Catch: Throwable -> L792
        r57.traceEnd();     // Catch: Throwable -> L792
        r57.traceBegin("WindowManagerServiceOnInitReady");     // Catch: Throwable -> L792
        r12.onInitReady();     // Catch: Throwable -> L792
        r57.traceEnd();     // Catch: Throwable -> L792
        SystemServerInitThreadPool.submit(new SystemServer$$ExternalSyntheticLambda6(), START_SENSOR_MANAGER_SERVICE);     // Catch: Throwable -> L792
        SystemServerInitThreadPool.submit(new SystemServer$$ExternalSyntheticLambda7(), START_HIDL_SERVICES);     // Catch: Throwable -> L792
        if (r5 == true) goto L58;
        if (r30 == false) goto L58;
        r57.traceBegin("StartVrManagerService");     // Catch: Throwable -> L46
        this.mSystemServiceManager.startService(VrManagerService.class);     // Catch: Throwable -> L46
        r57.traceEnd();     // Catch: Throwable -> L46
    L58:
        r57.traceBegin("StartInputManager");     // Catch: Throwable -> L792
        r7.setWindowManagerCallbacks(r12.getInputManagerCallback());     // Catch: Throwable -> L792
        r7.start();     // Catch: Throwable -> L792
        r57.traceEnd();     // Catch: Throwable -> L792
        r57.traceBegin("DisplayManagerWindowManagerAndInputReady");     // Catch: Throwable -> L792
        this.mDisplayManagerService.windowManagerAndInputReady();     // Catch: Throwable -> L792
        r57.traceEnd();     // Catch: Throwable -> L792
        if (this.mFactoryTestMode != 1) goto L64;
        Slog.i(TAG, "No Bluetooth Service (factory test)");     // Catch: Throwable -> L46
    L68:
        r57.traceBegin("IpConnectivityMetrics");     // Catch: Throwable -> L792
        this.mSystemServiceManager.startService(IpConnectivityMetrics.class);     // Catch: Throwable -> L792
        r57.traceEnd();     // Catch: Throwable -> L792
        r57.traceBegin("NetworkWatchlistService");     // Catch: Throwable -> L792
        this.mSystemServiceManager.startService(NetworkWatchlistService.Lifecycle.class);     // Catch: Throwable -> L792
        r57.traceEnd();     // Catch: Throwable -> L792
        r57.traceBegin("PinnerService");     // Catch: Throwable -> L792
        this.mSystemServiceManager.startService(PinnerService.class);     // Catch: Throwable -> L792
        r57.traceEnd();     // Catch: Throwable -> L792
        this.mSystemServiceManager.startService(ActivityTriggerService.class);     // Catch: Throwable -> L792
        if (Build.IS_DEBUGGABLE == true) goto L71;
    L73:
        r57.traceBegin("SignedConfigService");     // Catch: Throwable -> L792
        SignedConfigService.registerUpdateReceiver(this.mSystemContext);     // Catch: Throwable -> L792
        r57.traceEnd();     // Catch: Throwable -> L792
        r57.traceBegin("AppIntegrityService");     // Catch: Throwable -> L792
        this.mSystemServiceManager.startService(AppIntegrityManagerService.class);     // Catch: Throwable -> L792
        r57.traceEnd();     // Catch: Throwable -> L792
        r57.traceBegin("StartLogcatManager");     // Catch: Throwable -> L792
        this.mSystemServiceManager.startService(LogcatManagerService.class);     // Catch: Throwable -> L792
        r57.traceEnd();     // Catch: Throwable -> L792
        if (r5 == true) goto L79;
        if (r28 == true) goto L79;
        if (r3 == true) goto L79;
        if (r25 == true) goto L79;
        r57.traceBegin("StartIntrusionDetectionService");     // Catch: Throwable -> L46
        this.mSystemServiceManager.startService(IntrusionDetectionService.class);     // Catch: Throwable -> L46
        r57.traceEnd();     // Catch: Throwable -> L46
    L79:
        if (AppFunctionManagerConfiguration.isSupported(r6) == false) goto L82;
        r57.traceBegin("StartAppFunctionManager");     // Catch: Throwable -> L46
        this.mSystemServiceManager.startService(AppFunctionManagerService.class);     // Catch: Throwable -> L46
        r57.traceEnd();     // Catch: Throwable -> L46
    L82:
        if (r5 == true) goto L87;
        if (r28 == true) goto L87;
        if (r3 == true) goto L87;
        if (r25 == true) goto L87;
        r57.traceBegin("StartAdvancedProtectionService");     // Catch: Throwable -> L46
        this.mSystemServiceManager.startService(AdvancedProtectionService.Lifecycle.class);     // Catch: Throwable -> L46
        r57.traceEnd();     // Catch: Throwable -> L46
    L87:
        if (r5 == true) goto L91;
        if (r28 == true) goto L91;
        if (r3 == true) goto L91;
        r57.traceBegin("StartTradeInModeService");     // Catch: Throwable -> L46
        this.mSystemServiceManager.startService(TradeInModeService.class);     // Catch: Throwable -> L46
        r57.traceEnd();     // Catch: Throwable -> L46
    L46:
        th = th;
    L91:
        ?? r34 = 0;
        final boolean r8 = r12.detectSafeMode();
        if (r8 == false) goto L95;
        Settings.Global.putInt(r6.getContentResolver(), "airplane_mode_on", 1);
    L97:
        ?? r13 = 0;
        ?? r14 = 0;
        ILockSettings r35 = null;
        IMediaRouterService.Stub r36 = null;
        if (this.mFactoryTestMode == 1) goto L118;
        r57.traceBegin("StartInputMethodManagerLifecycle");
        String r9 = r6.getResources().getString(R.string.config_mms_user_agent);
        if (r9.isEmpty() == false) goto L102;
        boolean r38 = r5;
        this.mSystemServiceManager.startService(InputMethodManagerService.Lifecycle.class);
        Object r39 = null;
    L112:
        r57.traceEnd();
        r57.traceBegin("StartAccessibilityManagerService");
        this.mSystemServiceManager.startService(AccessibilityManagerService.Lifecycle.class);     // Catch: Throwable -> L115
    L117:
        r57.traceEnd();
    L119:
        r57.traceBegin("MakeDisplayReady");
        r12.displayReady();     // Catch: Throwable -> L122
    L124:
        r57.traceEnd();
        if (this.mFactoryTestMode != 1) goto L127;
    L139:
        r57.traceBegin("StartUiModeManager");
        this.mSystemServiceManager.startService(UiModeManagerService.class);
        r57.traceEnd();
        r57.traceBegin("StartLocaleManagerService");
        this.mSystemServiceManager.startService(LocaleManagerService.class);     // Catch: Throwable -> L142
    L144:
        r57.traceEnd();
        r57.traceBegin("StartGrammarInflectionService");
        this.mSystemServiceManager.startService(GrammaticalInflectionService.class);     // Catch: Throwable -> L147
    L149:
        r57.traceEnd();
        r57.traceBegin("StartAppHibernationService");
        this.mSystemServiceManager.startService(AppHibernationService.class);
        r57.traceEnd();
        r57.traceBegin("ArtManagerLocal");
        DexOptHelper.initializeArtManagerLocal(r6, this.mPackageManagerService);
        r57.traceEnd();
        r57.traceBegin("StartCompilationMonitorService");
        SysMonitorSvcBridge.getFactory().getCompileMonitorService().startIfNeeded(this.mSystemServiceManager, r6);
        r57.traceEnd();
        r57.traceBegin("UpdatePackagesIfNeeded");
        Watchdog.getInstance().pauseWatchingCurrentThread("dexopt");     // Catch: Throwable -> L152
        this.mPackageManagerService.updatePackagesIfNeeded();     // Catch: Throwable -> L152
    L151:
        Watchdog.getInstance().resumeWatchingCurrentThread("dexopt");
        r57.traceEnd();
        r57.traceBegin("UpdateMetricsIfNeeded");
        this.mPackageManagerService.updateMetricsIfNeeded();
        r57.traceEnd();
        r57.traceBegin("PerformFstrimIfNeeded");
        this.mPackageManagerService.performFstrimIfNeeded();     // Catch: Throwable -> L158
    L160:
        r57.traceEnd();
        if (this.mFactoryTestMode != 1) goto L163;
        DevicePolicyManagerService.Lifecycle r41 = null;
        NetworkTimeUpdateService r44 = null;
        ?? r47 = 0;
        Object r10 = null;
        Object r24 = null;
        INetworkManagementService r40 = null;
        ?? r50 = 0;
        ILockSettings r51 = null;
        IMediaRouterService.Stub r52 = null;
        ?? r43 = r39;
    L559:
        r57.traceBegin("StartMediaProjectionManager");
        this.mSystemServiceManager.startService(MediaProjectionManagerService.class);
        r57.traceEnd();
        if (r38 == false) goto L614;
        r57.traceBegin("StartWearPowerService");
        this.mSystemServiceManager.startService(WEAR_POWER_SERVICE_CLASS);     // Catch: Throwable -> L564
    L566:
        r57.traceEnd();
        r57.traceBegin("StartHealthService");
        this.mSystemServiceManager.startService(HEALTH_SERVICE_CLASS);     // Catch: Throwable -> L569
    L571:
        r57.traceEnd();
        r57.traceBegin("StartSystemStateDisplayService");
        this.mSystemServiceManager.startService(SYSTEM_STATE_DISPLAY_SERVICE_CLASS);     // Catch: Throwable -> L574
    L576:
        r57.traceEnd();
        r57.traceBegin("StartWearConnectivityService");
        this.mSystemServiceManager.startService(WEAR_CONNECTIVITY_SERVICE_CLASS);     // Catch: Throwable -> L579
    L581:
        r57.traceEnd();
        r57.traceBegin("StartWearDisplayService");
        this.mSystemServiceManager.startService(WEAR_DISPLAY_SERVICE_CLASS);     // Catch: Throwable -> L584
    L586:
        r57.traceEnd();
        if (Build.IS_DEBUGGABLE == false) goto L594;
        r57.traceBegin("StartWearDebugService");
        this.mSystemServiceManager.startService(WEAR_DEBUG_SERVICE_CLASS);     // Catch: Throwable -> L591
    L593:
        r57.traceEnd();
    L591:
        th = move-exception;
        reportWtf("starting StartWearDebugService", th);
    L594:
        r57.traceBegin("StartWearTimeService");
        this.mSystemServiceManager.startService(WEAR_TIME_SERVICE_CLASS);     // Catch: Throwable -> L597
    L599:
        r57.traceEnd();
        r57.traceBegin("StartWearSettingsService");
        this.mSystemServiceManager.startService(WEAR_SETTINGS_SERVICE_CLASS);     // Catch: Throwable -> L602
    L604:
        r57.traceEnd();
        r57.traceBegin("StartWearModeService");
        this.mSystemServiceManager.startService(WEAR_MODE_SERVICE_CLASS);     // Catch: Throwable -> L607
    L609:
        r57.traceEnd();
        if (0 == 0) goto L614;
        r57.traceBegin("StartWristOrientationService");
        this.mSystemServiceManager.startService(WRIST_ORIENTATION_SERVICE_CLASS);
        r57.traceEnd();
    L607:
        th = move-exception;
        reportWtf("starting StartWearModeService", th);
    L602:
        th = move-exception;
        reportWtf("starting StartWearSettingsService", th);
    L597:
        th = move-exception;
        reportWtf("starting StartWearTimeService", th);
    L584:
        th = move-exception;
        reportWtf("starting StartWearDisplayService", th);
    L579:
        th = move-exception;
        reportWtf("starting StartWearConnectivityService", th);
    L574:
        th = move-exception;
        reportWtf("starting StartSystemStateDisplayService", th);
    L569:
        th = move-exception;
        reportWtf("starting StartHealthService", th);
    L564:
        th = move-exception;
        reportWtf("starting StartWearPowerService", th);
    L614:
        if (this.mPackageManager.hasSystemFeature("android.software.slices_disabled") == true) goto L617;
        r57.traceBegin("StartSliceManagerService");
        this.mSystemServiceManager.startService(SliceManagerService.Lifecycle.class);
        r57.traceEnd();
    L617:
        if (RoSystemFeatures.hasFeatureEmbedded(r6) == false) goto L619;
        r57.traceBegin("StartIoTSystemService");
        this.mSystemServiceManager.startService(IOT_SERVICE_CLASS);
        r57.traceEnd();
    L619:
        r57.traceBegin("StartStatsCompanion");
        this.mSystemServiceManager.startServiceFromJar(STATS_COMPANION_LIFECYCLE_CLASS, STATS_COMPANION_APEX_PATH);
        r57.traceEnd();
        r57.traceBegin("StartRebootReadinessManagerService");
        this.mSystemServiceManager.startServiceFromJar(REBOOT_READINESS_LIFECYCLE_CLASS, SCHEDULING_APEX_PATH);
        r57.traceEnd();
        r57.traceBegin("StartStatsPullAtomService");
        this.mSystemServiceManager.startService(StatsPullAtomService.class);
        r57.traceEnd();
        r57.traceBegin("StatsBootstrapAtomService");
        this.mSystemServiceManager.startService(StatsBootstrapAtomService.Lifecycle.class);
        r57.traceEnd();
        r57.traceBegin("StartIncidentCompanionService");
        this.mSystemServiceManager.startService(IncidentCompanionService.class);
        r57.traceEnd();
        r57.traceBegin("StarSdkSandboxManagerService");
        this.mSystemServiceManager.startService(SDK_SANDBOX_MANAGER_SERVICE_CLASS);
        r57.traceEnd();
        r57.traceBegin("StartAdServicesManagerService");
        this.mSystemServiceManager.startService(AD_SERVICES_MANAGER_SERVICE_CLASS);
        r57.traceEnd();
        if (SystemProperties.getBoolean("ro.system_settings.service.odp_enabled", true) == false) goto L622;
        r57.traceBegin("StartOnDevicePersonalizationSystemService");
        this.mSystemServiceManager.startService(ON_DEVICE_PERSONALIZATION_SYSTEM_SERVICE_CLASS);
        r57.traceEnd();
    L622:
        r57.traceBegin("StartProfilingCompanion");
        this.mSystemServiceManager.startServiceFromJar(PROFILING_SERVICE_LIFECYCLE_CLASS, PROFILING_SERVICE_JAR_PATH);
        r57.traceEnd();
        if (r8 == false) goto L626;
        this.mActivityManagerService.enterSafeMode();
    L626:
        if (this.mPackageManager.hasSystemFeature("android.hardware.telephony") == false) goto L628;
        r57.traceBegin("StartMmsService");
        MmsServiceBroker r110 = (MmsServiceBroker) this.mSystemServiceManager.startService(MmsServiceBroker.class);
        r57.traceEnd();
        MmsServiceBroker r53 = r110;
    L630:
        if (this.mPackageManager.hasSystemFeature("android.software.autofill") == false) goto L633;
        r57.traceBegin("StartAutoFillService");
        this.mSystemServiceManager.startService(AutofillManagerService.class);
        r57.traceEnd();
    L633:
        if (this.mPackageManager.hasSystemFeature("android.software.credentials") == false) goto L639;
        if (DeviceConfig.getBoolean("credential_manager", "enable_credential_manager", true) == false) goto L637;
        r57.traceBegin("StartCredentialManagerService");
        this.mSystemServiceManager.startService(CredentialManagerService.class);
        r57.traceEnd();
        goto L639
    L637:
        Slog.d(TAG, "CredentialManager disabled.");
    L639:
        if (deviceHasConfigString(r6, R.string.config_icon_mask) == false) goto L641;
        r57.traceBegin("StartTranslationManagerService");
        this.mSystemServiceManager.startService(TranslationManagerService.class);
        r57.traceEnd();
    L642:
        r57.traceBegin("StartClipboardService");
        this.mSystemServiceManager.startService(ClipboardService.class);
        r57.traceEnd();
        r57.traceBegin("AppServiceManager");
        this.mSystemServiceManager.startService(AppBindingService.Lifecycle.class);
        r57.traceEnd();
        this.mObricExt.startMemoryManagerService(r6, r57);
        r57.traceBegin("startTracingServiceProxy");
        this.mSystemServiceManager.startService(TracingServiceProxy.class);
        r57.traceEnd();
        r57.traceBegin("StartDynamicInstrumentationManager");
        this.mSystemServiceManager.startService(DynamicInstrumentationManagerService.class);
        r57.traceEnd();
        r57.traceBegin("MakeLockSettingsServiceReady");
        if (r51 != null) goto L972;
    L648:
        r57.traceEnd();
        r57.traceBegin("StartBootPhaseLockSettingsReady");
        this.mSystemServiceManager.startBootPhase(r57, SystemService.PHASE_LOCK_SETTINGS_READY);
        r57.traceEnd();
        final HsumBootUserInitializer r111 = HsumBootUserInitializer.createInstance(this.mActivityManagerService, this.mPackageManagerService, this.mContentResolver, r6.getResources().getBoolean(R.bool.config_keepRestrictedProfilesInBackground));
        if (r111 == null) goto L652;
        r57.traceBegin("HsumBootUserInitializer.init");
        r111.init(r57);
        r57.traceEnd();
    L652:
        if (UserManager.isCommunalProfileEnabled() == false) goto L654;
        r57.traceBegin("CommunalProfileInitializer.init");
        new CommunalProfileInitializer(this.mActivityManagerService).init(r57);
        r57.traceEnd();
    L986:
    L658:
        th = move-exception;
        Slog.d(TAG, "Not starting ZteDeviceIdentifyService e:" + th);
        reportWtf("starting ZteDeviceIdentifyService service", th);
    L663:
        r57.traceBegin("StartBootPhaseSystemServicesReady");
        this.mSystemServiceManager.startBootPhase(r57, 500);
        r57.traceEnd();
        if (r23 == true) goto L989;
    L669:
        r57.traceBegin("MakeWindowManagerServiceReady");
        r12.systemReady();     // Catch: Throwable -> L672
    L674:
        r57.traceEnd();
        r57.traceBegin("RegisterLogMteState");
        LogMteState.register(r6);     // Catch: Throwable -> L677
    L679:
        r57.traceEnd();
        monitor-enter(SystemService.class);
    L783:
        th = th;
    L982:
        monitor-exit(SystemService.class);     // Catch: Throwable -> L787
        throw th;
    L787:
        th = th;
        goto L982
    L682:
        if (sPendingWtfs != null) goto L888;
    L687:
        monitor-exit(SystemService.class);     // Catch: Throwable -> L783
        if (r8 == false) goto L690;
        this.mActivityManagerService.showSafeModeOverlay();
    L690:
        Configuration r26 = r12.computeNewConfiguration(0);
        DisplayMetrics r0 = new DisplayMetrics();
        r6.getDisplay().getMetrics(r0);
        r6.getResources().updateConfiguration(r26, r0);
        Resources.Theme r29 = r6.getTheme();
        if (r29.getChangingConfigurations() == 0) goto L693;
        r29.rebase();
    L693:
        r57.traceBegin("StartPermissionPolicyService");
        this.mSystemServiceManager.startService(PermissionPolicyService.class);
        r57.traceEnd();
        r57.traceBegin("MakePackageManagerServiceReady");
        this.mPackageManagerService.systemReady();
        r57.traceEnd();
        r57.traceBegin("StartCrashRecoveryModule");
        CrashRecoveryAdaptor.initializeCrashrecoveryModuleService(this.mSystemServiceManager);
        r57.traceEnd();
        r57.traceBegin("MakeDisplayManagerServiceReady");
        this.mDisplayManagerService.systemReady(r8);     // Catch: Throwable -> L696
    L698:
        r57.traceEnd();
        this.mSystemServiceManager.setSafeMode(r8);
        r57.traceBegin("StartDeviceSpecificServices");
        String[] r112 = this.mSystemContext.getResources().getStringArray(R.array.config_displayWhiteBalanceDecreaseThresholds);
        int r113 = r112.length;
        int r114 = 0;
    L699:
        if (r114 >= r113) goto L706;
        String r115 = r112[r114];
        StringBuilder r1 = new StringBuilder();
        Object r116 = r10;
        r1.append("StartDeviceSpecificServices ");
        r1.append(r115);
        r57.traceBegin(r1.toString());
        this.mSystemServiceManager.startService(r115);     // Catch: Throwable -> L703
    L705:
        r57.traceEnd();
        r114 = r114 + 1;
        r10 = r116;
        r7 = r7;
    L703:
        th = move-exception;
        reportWtf("starting " + r115, th);
        goto L705
    L706:
        final InputManagerService r33 = r7;
        r57.traceEnd();
        if (SystemProperties.getBoolean("ro.vendor.feature.zte_feature_mindsync", false) == false) goto L709;
        r57.traceBegin("MindSyncService");
        this.mSystemServiceManager.startService("com.android.server.am.MindSyncService");
        r57.traceEnd();
    L710:
        r57.traceBegin("NetworkStatsTrackerService");
        this.mSystemServiceManager.startService("com.android.server.am.NetworkStatsTrackerService");
        r57.traceEnd();
        if (SystemProperties.getBoolean("ro.vendor.feature.zte_feature_heartyservice", false) == false) goto L713;
        r57.traceBegin("AppLockManagerService");
        this.mSystemServiceManager.startService("com.android.server.AppLockManagerService$Lifecycle");
        r57.traceEnd();
    L715:
        if (r38 == false) goto L717;
        Slog.d(TAG, "Not starting GameManagerService");
    L719:
        if (r6.getPackageManager().hasSystemFeature("android.hardware.uwb") == false) goto L722;
        r57.traceBegin("UwbService");
        this.mSystemServiceManager.startServiceFromJar(UWB_SERVICE_CLASS, UWB_APEX_SERVICE_JAR_PATH);
        r57.traceEnd();
    L722:
        if (Flags.rangingStackEnabled() == true) goto L724;
    L732:
        r57.traceBegin("StartBootPhaseDeviceSpecificServicesReady");
        this.mSystemServiceManager.startBootPhase(r57, SystemService.PHASE_DEVICE_SPECIFIC_SERVICES_READY);
        r57.traceEnd();
        r57.traceBegin("StartSafetyCenterService");
        this.mSystemServiceManager.startService(SAFETY_CENTER_SERVICE_CLASS);
        r57.traceEnd();
        r57.traceBegin("AppSearchModule");
        this.mSystemServiceManager.startService(APPSEARCH_MODULE_LIFECYCLE_CLASS);
        r57.traceEnd();
        if (SystemProperties.getBoolean("ro.config.isolated_compilation_enabled", false) == false) goto L735;
        r57.traceBegin("IsolatedCompilationService");
        this.mSystemServiceManager.startService(ISOLATED_COMPILATION_SERVICE_CLASS);
        r57.traceEnd();
    L735:
        r57.traceBegin("StartMediaCommunicationService");
        this.mSystemServiceManager.startService(MEDIA_COMMUNICATION_SERVICE_CLASS);
        r57.traceEnd();
        r57.traceBegin("AppCompatOverridesService");
        this.mSystemServiceManager.startService(AppCompatOverridesService.Lifecycle.class);
        r57.traceEnd();
        r57.traceBegin("HealthConnectManagerService");
        this.mSystemServiceManager.startService(HEALTHCONNECT_MANAGER_SERVICE_CLASS);
        r57.traceEnd();
        if (this.mPackageManager.hasSystemFeature("android.software.device_lock") == false) goto L738;
        r57.traceBegin("DeviceLockService");
        this.mSystemServiceManager.startServiceFromJar(DEVICE_LOCK_SERVICE_CLASS, DEVICE_LOCK_APEX_PATH);
        r57.traceEnd();
    L738:
        r57.traceBegin("StartSensitiveContentProtectionManager");
        this.mSystemServiceManager.startService(SensitiveContentProtectionManagerService.class);
        r57.traceEnd();
        r57.traceBegin("GameAssistServer");
        ZteGameServiceFactory.getInstance().startGameAssistService(r6);
        r57.traceEnd();
        final INetworkManagementService r31 = r40;
        final ?? r117 = r43;
        final ?? r118 = r47;
        final NetworkTimeUpdateService r119 = r44;
        final ?? r120 = r52;
        final MmsServiceBroker r121 = r53;
        final ?? r122 = r50;
        final ConnectivityManager r37 = (ConnectivityManager) r6.getSystemService("connectivity");
        final boolean r55 = r38;
        final DevicePolicyManagerService.Lifecycle r32 = r41;
        this.mActivityManagerService.systemReady(new SystemServer$$ExternalSyntheticLambda8(this, r57, r3, r32, r55, r6, r8, r37, r31, r117, r122, r111, r118, r119, r33, r4, r120, r121), r57);
        r57.traceBegin("LockSettingsThirdPartyAppsStarted");
        LockSettingsInternal r42 = (LockSettingsInternal) LocalServices.getService(LockSettingsInternal.class);
        if (r42 == null) goto L741;
        r42.onThirdPartyAppsStarted();
    L741:
        r57.traceEnd();
        r57.traceBegin("StartSystemUI");
        startSystemUi(r6, r12);     // Catch: Throwable -> L744
    L746:
        r57.traceEnd();
        r57.traceBegin("MakeSmartServiceReady");
        SysOptBridge.getFactory().getSmartService().systemReady(this.mSystemContext);     // Catch: Throwable -> L749
        Slog.d(TAG, "SmartService systemReady");     // Catch: Throwable -> L749
    L751:
        r57.traceEnd();
        r57.traceBegin("MakeBytedancePowerAdvisorReady");
        SysOptBridge.getFactory().getBytedancePowerAdvisorInstance().systemReady();     // Catch: Throwable -> L754
    L756:
        r57.traceEnd();
        r57.traceBegin("MakeSmartPowerDataReady");
        SysOptBridge.getFactory().getSmartPowerDataInstance().systemReady(this.mSystemContext);     // Catch: Throwable -> L759
    L761:
        r57.traceEnd();
        r57.traceBegin("MakeSysMonitorServiceReady");
        SysOptBridge.getFactory().getSysMonitorService().systemReady();     // Catch: Throwable -> L764
    L766:
        r57.traceEnd();
        r57.traceBegin("PerfThermalMonitor");
        SysOptBridge.getFactory().getPerfThermalMonitorInstance().systemReady(this.mActivityManagerService, this.mSystemContext);     // Catch: Exception -> L771
    L776:
        r57.traceEnd();
        Slog.i(TAG, "start FreqOptimize");
        r57.traceBegin("FreqOptimize");
        SysOptBridge.getFactory().getFreqOptimize().systemReady();     // Catch: Exception -> L779
    L781:
        r57.traceEnd();
        r57.traceEnd();
        return;
    L779:
        e = move-exception;
        Slog.e(TAG, "start FreqOptimize failed", e);
    L771:
        e = e;
    L775:
        Slog.e(TAG, "start PerfThermalMonitor failed", e);
    L773:
        e = e;
    L764:
        th = move-exception;
        reportWtf("making SysMonitor Service ready", th);
    L759:
        th = move-exception;
        reportWtf("making Smart Power Data ready", th);
    L754:
        th = move-exception;
        reportWtf("making Bytedance Power Advisor ready", th);
    L749:
        th = move-exception;
        reportWtf("making Smart Service ready", th);
    L744:
        th = move-exception;
        reportWtf("starting System UI", th);
        goto L746
    L724:
        if (r6.getPackageManager().hasSystemFeature("android.hardware.uwb") == false) goto L726;
    L731:
        r57.traceBegin("RangingService");
        this.mSystemServiceManager.startServiceFromJar(RANGING_SERVICE_CLASS, RANGING_APEX_SERVICE_JAR_PATH);
        r57.traceEnd();
        goto L732
    L726:
        if (r6.getPackageManager().hasSystemFeature("android.hardware.wifi.aware") == true) goto L731;
        if (Flags.rangingCsEnabled() == false) goto L732;
        if (r6.getPackageManager().hasSystemFeature("android.hardware.bluetooth_le") == false) goto L732;
    L717:
        r57.traceBegin(GameManagerService.TAG);
        this.mSystemServiceManager.startService(GameManagerService.Lifecycle.class);
        r57.traceEnd();
        goto L719
    L713:
        Slog.d(TAG, "Not starting AppLockManagerService");
        goto L715
    L709:
        Slog.d(TAG, "Not starting MindSyncService");
    L696:
        th = move-exception;
        reportWtf("making Display Manager Service ready", th);
        goto L698
    L888:
        this.mActivityManagerService.schedulePendingSystemServerWtfs(sPendingWtfs);     // Catch: Throwable -> L685
        sPendingWtfs = null;     // Catch: Throwable -> L685
    L685:
        th = th;
    L677:
        th = move-exception;
        reportWtf("RegisterLogMteState", th);
    L672:
        th = move-exception;
        reportWtf("making Window Manager Service ready", th);
        goto L674
    L989:
        Slog.i(TAG, "calling onBootPhase for Wigig Services");     // Catch: Throwable -> L667
        r10.getClass().getMethod("onBootPhase", new Class[]{Integer.TYPE}).invoke(r10, new Object[]{new Integer(500)});     // Catch: Throwable -> L667
        r24.getClass().getMethod("onBootPhase", new Class[]{Integer.TYPE}).invoke(r24, new Object[]{new Integer(500)});     // Catch: Throwable -> L667
    L667:
        th = move-exception;
        reportWtf("Wigig services ready", th);
        goto L669
    L656:
        if (SystemProperties.getBoolean("ro.vendor.feature.zte_feature_amid", true) == false) goto L660;
        r57.traceBegin("ZteDeviceIdentifyService");     // Catch: Throwable -> L658
        Slog.d(TAG, "starting ZteDeviceIdentifyService ..");     // Catch: Throwable -> L658
        this.mSystemServiceManager.startService("com.android.server.zte.ZteDeviceIdentifyService$Lifecycle");     // Catch: Throwable -> L658
        r57.traceEnd();     // Catch: Throwable -> L658
        goto L663
    L660:
        Slog.d(TAG, "Not starting ZteDeviceIdentifyService");     // Catch: Throwable -> L658
        goto L663
    L654:
        r57.traceBegin("CommunalProfileInitializer.removeCommunalProfileIfPresent");
        CommunalProfileInitializer.removeCommunalProfileIfPresent();
        r57.traceEnd();
        goto L986
    L972:
        r51.systemReady();     // Catch: Throwable -> L646
    L646:
        th = move-exception;
        reportWtf("making Lock Settings Service ready", th);
        goto L648
    L641:
        Slog.d(TAG, "TranslationService not defined by OEM");
        goto L642
    L628:
        r53 = null;
        goto L630
    L163:
        r57.traceBegin("StartLockSettingsService");
        this.mSystemServiceManager.startService(LockSettingsService.Lifecycle.class);     // Catch: Throwable -> L166
        r35 = ILockSettings.Stub.asInterface(ServiceManager.getService("lock_settings"));     // Catch: Throwable -> L166
    L168:
        r57.traceEnd();
        boolean r2 = !SystemProperties.get(PERSISTENT_DATA_BLOCK_PROP).equals("");
        if (r2 == false) goto L172;
        r57.traceBegin("StartPersistentDataBlock");
        this.mSystemServiceManager.startService(PersistentDataBlockService.class);
        r57.traceEnd();
    L172:
        if (Build.IS_ARC == true) goto L174;
    L176:
        r57.traceBegin("StartTestHarnessMode");
        this.mSystemServiceManager.startService(TestHarnessModeService.class);
        r57.traceEnd();
        if (r2 == false) goto L179;
    L180:
        r57.traceBegin("StartOemLockService");
        this.mSystemServiceManager.startService(OemLockService.class);
        r57.traceEnd();
    L181:
        r57.traceBegin("StartDeviceIdleController");
        this.mSystemServiceManager.startService(DeviceIdleController.class);
        r57.traceEnd();
        r57.traceBegin("StartDevicePolicyManager");
        DevicePolicyManagerService.Lifecycle r45 = (DevicePolicyManagerService.Lifecycle) this.mSystemServiceManager.startService(DevicePolicyManagerService.Lifecycle.class);
        r57.traceEnd();
        r57.traceBegin("StartStatusBarManagerService");
        r13 = new StatusBarManagerService(r6);     // Catch: Throwable -> L188
        r13.publishGlobalActionsProvider();     // Catch: Throwable -> L188
        ServiceManager.addService("statusbar", r13, false, 20);     // Catch: Throwable -> L186
        ?? r123 = r13;
    L191:
        r57.traceEnd();
        if (deviceHasConfigString(r6, R.string.config_fallbackCredentialManagerDialogComponent) == false) goto L194;
        r57.traceBegin("StartMusicRecognitionManagerService");
        this.mSystemServiceManager.startService(MusicRecognitionManagerService.class);
        r57.traceEnd();
    L195:
        startContentCaptureService(r6, r57);
        startAttentionService(r6, r57);
        startRotationResolverService(r6, r57);
        startSystemCaptionsManagerService(r6, r57);
        startTextToSpeechManagerService(r6, r57);
        if (r38 == false) goto L198;
        Slog.d(TAG, "Not starting WearableSensingService");
    L199:
        startOnDeviceIntelligenceService(r57);
        if (deviceHasConfigString(r6, R.string.config_deviceConfiguratorPackageName) == false) goto L202;
        r57.traceBegin("StartAmbientContextService");
        this.mSystemServiceManager.startService(AmbientContextManagerService.class);
        r57.traceEnd();
    L203:
        r57.traceBegin("StartSpeechRecognitionManagerService");
        this.mSystemServiceManager.startService(SpeechRecognitionManagerService.class);
        r57.traceEnd();
        if (deviceHasConfigString(r6, R.string.config_devicePolicyManagementUpdater) == false) goto L206;
        r57.traceBegin("StartAppPredictionService");
        this.mSystemServiceManager.startService(AppPredictionManagerService.class);
        r57.traceEnd();
    L208:
        if (deviceHasConfigString(r6, R.string.config_display_features) == false) goto L210;
        r57.traceBegin("StartContentSuggestionsService");
        this.mSystemServiceManager.startService(ContentSuggestionsManagerService.class);
        r57.traceEnd();
    L212:
        if (deviceHasConfigString(r6, R.string.config_hdmiCecSetMenuLanguageActivity) == false) goto L215;
        r57.traceBegin("StartSearchUiService");
        this.mSystemServiceManager.startService(SearchUiManagerService.class);
        r57.traceEnd();
    L215:
        if (deviceHasConfigString(r6, R.string.config_headlineFontFeatureSettings) == false) goto L217;
        r57.traceBegin("StartSmartspaceService");
        this.mSystemServiceManager.startService(SmartspaceManagerService.class);
        r57.traceEnd();
    L219:
        if (deviceHasConfigString(r6, R.string.config_dozeDoubleTapSensorType) == false) goto L221;
        r57.traceBegin("StartContextualSearchService");
        this.mSystemServiceManager.startService(ContextualSearchManagerService.class);
        r57.traceEnd();
    L222:
        r57.traceBegin("InitConnectivityModuleConnector");
        ConnectivityModuleConnector.getInstance().init(r6);     // Catch: Throwable -> L225
    L227:
        r57.traceEnd();
        r57.traceBegin("InitNetworkStackClient");
        NetworkStackClient.getInstance().init();     // Catch: Throwable -> L230
    L232:
        r57.traceEnd();
        r57.traceBegin("StartNetworkManagementService");
        INetworkManagementService r46 = NetworkManagementService.create(r6);     // Catch: Throwable -> L239
        ServiceManager.addService("network_management", r46);     // Catch: Throwable -> L237
    L242:
        r57.traceEnd();
        r57.traceBegin("StartFontManagerService");
        this.mSystemServiceManager.startService(new FontManagerService.Lifecycle(r6, r8));
        r57.traceEnd();
        if (r38 == true) goto L246;
        r57.traceBegin("StartTextServicesManager");
        this.mSystemServiceManager.startService(TextServicesManagerService.Lifecycle.class);
        r57.traceEnd();
    L246:
        if (r20 == true) goto L248;
        r57.traceBegin("StartTextClassificationManagerService");
        this.mSystemServiceManager.startService(TextClassificationManagerService.Lifecycle.class);
        r57.traceEnd();
    L248:
        r57.traceBegin("StartNetworkScoreService");
        this.mSystemServiceManager.startService(NetworkScoreService.Lifecycle.class);
        r57.traceEnd();
        r57.traceBegin("StartNetworkStatsService");
        r41 = r45;
        this.mSystemServiceManager.startServiceFromJar(NETWORK_STATS_SERVICE_INITIALIZER_CLASS, CONNECTIVITY_SERVICE_APEX_PATH);
        r57.traceEnd();
        r57.traceBegin("StartNetworkPolicyManagerService");
        ?? r48 = new NetworkPolicyManagerService(r6, this.mActivityManagerService, r46);     // Catch: Throwable -> L255
        ServiceManager.addService("netpolicy", r48);     // Catch: Throwable -> L253
        ?? r49 = r48;
    L258:
        r57.traceEnd();
        if (r6.getPackageManager().hasSystemFeature("android.hardware.wifi") == false) goto L263;
        r57.traceBegin("StartWifi");
        this.mSystemServiceManager.startServiceFromJar(WIFI_SERVICE_CLASS, WIFI_APEX_SERVICE_JAR_PATH);
        r57.traceEnd();
        r57.traceBegin("StartWifiScanning");
        this.mSystemServiceManager.startServiceFromJar(WIFI_SCANNING_SERVICE_CLASS, WIFI_APEX_SERVICE_JAR_PATH);
        r57.traceEnd();
    L263:
        if (r6.getResources().getBoolean(R.bool.config_device_vt_available) == false) goto L266;
        r57.traceBegin("StartWifiUsd");
        this.mSystemServiceManager.startServiceFromJar(WIFI_USD_SERVICE_CLASS, WIFI_APEX_SERVICE_JAR_PATH);
        r57.traceEnd();
    L266:
        if (r6.getPackageManager().hasSystemFeature("android.hardware.wifi.rtt") == false) goto L269;
        r57.traceBegin("StartRttService");
        this.mSystemServiceManager.startServiceFromJar(WIFI_RTT_SERVICE_CLASS, WIFI_APEX_SERVICE_JAR_PATH);
        r57.traceEnd();
    L269:
        if (r6.getPackageManager().hasSystemFeature("android.hardware.wifi.aware") == false) goto L272;
        r57.traceBegin("StartWifiAware");
        this.mSystemServiceManager.startServiceFromJar(WIFI_AWARE_SERVICE_CLASS, WIFI_APEX_SERVICE_JAR_PATH);
        r57.traceEnd();
    L272:
        if (r6.getPackageManager().hasSystemFeature("android.hardware.wifi.direct") == false) goto L275;
        r57.traceBegin("StartWifiP2P");
        this.mSystemServiceManager.startServiceFromJar(WIFI_P2P_SERVICE_CLASS, WIFI_APEX_SERVICE_JAR_PATH);
        r57.traceEnd();
    L275:
        if (r6.getPackageManager().hasSystemFeature("android.hardware.lowpan") == false) goto L277;
        r57.traceBegin("StartLowpan");
        this.mSystemServiceManager.startService(LOWPAN_SERVICE_CLASS);
        r57.traceEnd();
    L277:
        r57.traceBegin("StartPacProxyService");
        IPacProxyManager.Stub r54 = new PacProxyService(r6);     // Catch: Throwable -> L284
        ServiceManager.addService("pac_proxy", r54);     // Catch: Throwable -> L282
        r16 = r54;
    L286:
        r57.traceEnd();
        r57.traceBegin("StartConnectivityService");
        this.mSystemServiceManager.startServiceFromJar(CONNECTIVITY_SERVICE_INITIALIZER_CLASS, CONNECTIVITY_SERVICE_APEX_PATH);
        r49.bindConnectivityManager();
        r57.traceEnd();
        r57.traceBegin("StartSecurityStateManagerService");
        ServiceManager.addService("security_state", new SecurityStateManagerService(r6));     // Catch: Throwable -> L289
    L291:
        r57.traceEnd();
        if (r38 == false) goto L294;
        Slog.i(TAG, "Not starting VpnManagerService");
    L306:
        if (SdkLevel.isAtLeastB() == true) goto L313;
        r57.traceBegin("StartVcnManagementService");
        this.mSystemServiceManager.startServiceFromJar(CONNECTIVITY_SERVICE_INITIALIZER_B_CLASS, CONNECTIVITY_SERVICE_APEX_PATH);     // Catch: Throwable -> L310
    L312:
        r57.traceEnd();
    L310:
        th = move-exception;
        reportWtf("starting VCN Management Service", th);
    L313:
        if (r23 == true) goto L882;
        ?? r310 = r49;
        NetworkTimeUpdateService r410 = null;
    L324:
        r57.traceBegin("StartSystemUpdateManagerService");
        ServiceManager.addService("system_update", new SystemUpdateManagerService(r6));     // Catch: Throwable -> L327
    L329:
        r57.traceEnd();
        r57.traceBegin("StartUpdateLockService");
        ServiceManager.addService("updatelock", new UpdateLockService(r6));     // Catch: Throwable -> L332
    L334:
        r57.traceEnd();
        r57.traceBegin("StartNotificationManager");
        this.mSystemServiceManager.startService(NotificationManagerService.class);
        SystemNotificationChannels.removeDeprecated(r6);
        SystemNotificationChannels.createAll(r6);
        INotificationManager r124 = INotificationManager.Stub.asInterface(ServiceManager.getService("notification"));
        r57.traceEnd();
        r57.traceBegin("StartDeviceMonitor");
        this.mSystemServiceManager.startService(DeviceStorageMonitorService.class);
        r57.traceEnd();
        r57.traceBegin("StartTimeDetectorService");
        this.mSystemServiceManager.startService(TimeDetectorService.Lifecycle.class);     // Catch: Throwable -> L337
    L339:
        r57.traceEnd();
        r57.traceBegin("StartLocationManagerService");
        this.mSystemServiceManager.startService(LocationManagerService.Lifecycle.class);
        r57.traceEnd();
        r57.traceBegin("StartCountryDetectorService");
        r14 = new CountryDetectorService(r6);     // Catch: Throwable -> L342
        ServiceManager.addService("country_detector", r14);     // Catch: Throwable -> L342
        ?? r125 = r14;
    L344:
        r57.traceEnd();
        r57.traceBegin("StartTimeZoneDetectorService");
        this.mSystemServiceManager.startService(TimeZoneDetectorService.Lifecycle.class);     // Catch: Throwable -> L347
    L349:
        r57.traceEnd();
        r57.traceBegin("StartAltitudeService");
        this.mSystemServiceManager.startService(AltitudeService.Lifecycle.class);     // Catch: Throwable -> L352
    L354:
        r57.traceEnd();
        r57.traceBegin("StartLocationTimeZoneManagerService");
        this.mSystemServiceManager.startService(LocationTimeZoneManagerService.Lifecycle.class);     // Catch: Throwable -> L357
    L359:
        r57.traceEnd();
        if (r6.getResources().getBoolean(R.bool.config_enableMotionPrediction) == false) goto L367;
        r57.traceBegin("StartGnssTimeUpdateService");
        this.mSystemServiceManager.startService(GnssTimeUpdateService.Lifecycle.class);     // Catch: Throwable -> L364
    L366:
        r57.traceEnd();
    L364:
        th = move-exception;
        reportWtf("starting GnssTimeUpdateService service", th);
    L367:
        if (r38 == true) goto L375;
        r57.traceBegin("StartSearchManagerService");
        this.mSystemServiceManager.startService(SearchManagerService.Lifecycle.class);     // Catch: Throwable -> L371
    L373:
        r57.traceEnd();
    L371:
        th = move-exception;
        reportWtf("starting Search Service", th);
    L375:
        if (r6.getResources().getBoolean(R.bool.config_enable_cellular_on_boot_default) == false) goto L377;
        r57.traceBegin("StartWallpaperManagerService");
        this.mSystemServiceManager.startService(WallpaperManagerService.Lifecycle.class);
        r57.traceEnd();
    L379:
        if (deviceHasConfigString(r6, R.string.config_incidentReportApproverPackage) == false) goto L381;
        r57.traceBegin("StartWallpaperEffectsGenerationService");
        this.mSystemServiceManager.startService(WallpaperEffectsGenerationManagerService.class);
        r57.traceEnd();
    L381:
        r57.traceBegin("StartAudioService");
        if (r27 == true) goto L384;
        this.mSystemServiceManager.startService(AudioService.Lifecycle.class);
    L389:
        r57.traceEnd();
        r57.traceBegin("StartSoundTriggerMiddlewareService");
        this.mSystemServiceManager.startService(SoundTriggerMiddlewareService.Lifecycle.class);
        r57.traceEnd();
        r57.traceBegin("StartAlwaysOnRecordService");
        this.mSystemServiceManager.startService(AlwaysOnRecordService.Lifecycle.class);
        r57.traceEnd();
        if (this.mPackageManager.hasSystemFeature("android.hardware.broadcastradio") == false) goto L392;
        r57.traceBegin("StartBroadcastRadioService");
        this.mSystemServiceManager.startService(BroadcastRadioService.class);
        r57.traceEnd();
    L392:
        if (r28 == true) goto L394;
        r57.traceBegin("StartDockObserver");
        this.mSystemServiceManager.startService(DockObserver.class);
        r57.traceEnd();
    L394:
        if (r38 == false) goto L401;
        r57.traceBegin("StartThermalObserver");
        this.mSystemServiceManager.startService(THERMAL_OBSERVER_CLASS);     // Catch: Throwable -> L398
    L400:
        r57.traceEnd();
    L398:
        th = move-exception;
        reportWtf("starting StartThermalObserver", th);
    L401:
        if (r38 == true) goto L409;
        r57.traceBegin("StartWiredAccessoryManager");
        r7.setWiredAccessoryCallbacks(new WiredAccessoryManager(r6, r7));     // Catch: Throwable -> L405
    L407:
        r57.traceEnd();
    L405:
        th = move-exception;
        reportWtf("starting WiredAccessoryManager", th);
    L409:
        if (this.mPackageManager.hasSystemFeature("android.software.midi") == false) goto L411;
        r57.traceBegin("StartMidiManager");
        this.mSystemServiceManager.startService(MidiService.Lifecycle.class);
        r57.traceEnd();
    L411:
        r57.traceBegin("StartAdbService");
        this.mSystemServiceManager.startService(AdbService.Lifecycle.class);     // Catch: Throwable -> L414
    L416:
        r57.traceEnd();
        if (this.mPackageManager.hasSystemFeature("android.hardware.usb.host") == false) goto L419;
    L422:
        r57.traceBegin("StartUsbService");
        this.mSystemServiceManager.startService(UsbService.Lifecycle.class);
        r57.traceEnd();
    L423:
        if (r38 == true) goto L425;
        r57.traceBegin("StartSerialService");
        this.mSystemServiceManager.startService(SerialService.Lifecycle.class);
        r57.traceEnd();
    L425:
        r57.traceBegin("StartHardwarePropertiesManagerService");
        r15 = new HardwarePropertiesManagerService(r6);     // Catch: Throwable -> L428
        ServiceManager.addService("hardware_properties", r15);     // Catch: Throwable -> L428
        ?? r126 = r15;
    L430:
        r57.traceEnd();
        if (r38 == true) goto L433;
        r57.traceBegin("StartTwilightService");
        this.mSystemServiceManager.startService(TwilightService.class);
        r57.traceEnd();
    L433:
        r57.traceBegin("StartColorDisplay");
        this.mSystemServiceManager.startService(ColorDisplayService.class);
        r57.traceEnd();
        r57.traceBegin("StartJobScheduler");
        this.mSystemServiceManager.startService(JobSchedulerService.class);
        r57.traceEnd();
        r57.traceBegin("StartSoundTrigger");
        this.mSystemServiceManager.startService(SoundTriggerService.class);
        r57.traceEnd();
        r57.traceBegin("StartTrustManager");
        this.mSystemServiceManager.startService(TrustManagerService.class);
        r57.traceEnd();
        if (this.mPackageManager.hasSystemFeature("android.software.backup") == false) goto L437;
        r57.traceBegin("StartBackupManager");
        this.mSystemServiceManager.startService(BackupManagerService.Lifecycle.class);
        r57.traceEnd();
    L437:
        if (this.mPackageManager.hasSystemFeature("android.software.app_widgets") == false) goto L439;
    L440:
        r57.traceBegin("StartAppWidgetService");
        this.mSystemServiceManager.startService(AppWidgetService.class);
        r57.traceEnd();
    L441:
        r57.traceBegin("StartVoiceRecognitionManager");
        this.mSystemServiceManager.startService(VoiceInteractionManagerService.class);
        r57.traceEnd();
        if (GestureLauncherService.isGestureLauncherEnabled(r6.getResources()) == false) goto L444;
        r57.traceBegin("StartGestureLauncher");
        this.mSystemServiceManager.startService(GestureLauncherService.class);
        r57.traceEnd();
    L444:
        r57.traceBegin("StartSensorNotification");
        this.mSystemServiceManager.startService(SensorNotificationService.class);
        r57.traceEnd();
        if (this.mPackageManager.hasSystemFeature("android.hardware.context_hub") == false) goto L447;
        r57.traceBegin("StartContextHubSystemService");
        this.mSystemServiceManager.startService(ContextHubSystemService.class);
        r57.traceEnd();
    L447:
        r57.traceBegin("StartDiskStatsService");
        ServiceManager.addService("diskstats", new DiskStatsService(r6));     // Catch: Throwable -> L450
    L452:
        r57.traceEnd();
        r57.traceBegin("RuntimeService");
        ServiceManager.addService("runtime", new RuntimeService(r6));     // Catch: Throwable -> L455
    L457:
        r57.traceEnd();
        if (r21 == true) goto L472;
        if (r38 == false) goto L461;
        if (r38 == false) goto L472;
    L461:
        r57.traceBegin("StartNetworkTimeUpdateService");
        NetworkTimeUpdateService r127 = new NetworkTimeUpdateService(r6);     // Catch: Throwable -> L468
        ServiceManager.addService("network_time_update_service", r127);     // Catch: Throwable -> L466
    L471:
        r57.traceEnd();
    L473:
        r57.traceBegin("CertBlocklister");
        new CertBlocklister(r6);     // Catch: Throwable -> L476
    L478:
        r57.traceEnd();
        r57.traceBegin("StartEmergencyAffordanceService");
        this.mSystemServiceManager.startService(EmergencyAffordanceService.class);
        r57.traceEnd();
        r57.traceBegin(START_BLOB_STORE_SERVICE);
        this.mSystemServiceManager.startService(BlobStoreManagerService.class);
        r57.traceEnd();
        r57.traceBegin("StartDreamManager");
        this.mSystemServiceManager.startService(DreamManagerService.class);
        r57.traceEnd();
        r57.traceBegin("AddGraphicsStatsService");
        ServiceManager.addService("graphicsstats", new GraphicsStatsService(r6));
        r57.traceEnd();
        if (CoverageService.ENABLED == false) goto L482;
        r57.traceBegin("AddCoverageService");
        ServiceManager.addService(CoverageService.COVERAGE_SERVICE, new CoverageService());
        r57.traceEnd();
    L482:
        if (this.mPackageManager.hasSystemFeature("android.software.print") == false) goto L484;
        r57.traceBegin("StartPrintManager");
        this.mSystemServiceManager.startService(PrintManagerService.class);
        r57.traceEnd();
    L484:
        r57.traceBegin("StartAttestationVerificationService");
        this.mSystemServiceManager.startService(AttestationVerificationManagerService.class);
        r57.traceEnd();
        if (this.mPackageManager.hasSystemFeature("android.software.companion_device_setup") == false) goto L488;
        r57.traceBegin("StartCompanionDeviceManager");
        this.mSystemServiceManager.startService(CompanionDeviceManagerService.class);
        r57.traceEnd();
    L488:
        if (r6.getResources().getBoolean(R.bool.config_enable_a11y_magnification_single_panning) == false) goto L490;
        r57.traceBegin("StartVirtualDeviceManager");
        this.mSystemServiceManager.startService(VirtualDeviceManagerService.class);
        r57.traceEnd();
    L490:
        r57.traceBegin("StartRestrictionManager");
        this.mSystemServiceManager.startService(RestrictionsManagerService.class);
        r57.traceEnd();
        r57.traceBegin("StartMediaSessionService");
        this.mSystemServiceManager.startService(MediaSessionService.class);
        r57.traceEnd();
        if (this.mPackageManager.hasSystemFeature("android.hardware.hdmi.cec") == false) goto L494;
        r57.traceBegin("StartHdmiControlService");
        this.mSystemServiceManager.startService(HdmiControlService.class);
        r57.traceEnd();
    L494:
        if (this.mPackageManager.hasSystemFeature("android.software.live_tv") == false) goto L496;
    L497:
        r57.traceBegin("StartTvInteractiveAppManager");
        this.mSystemServiceManager.startService(TvInteractiveAppManagerService.class);
        r57.traceEnd();
    L499:
        if (this.mPackageManager.hasSystemFeature("android.software.live_tv") == false) goto L501;
    L502:
        r57.traceBegin("StartTvInputManager");
        this.mSystemServiceManager.startService(TvInputManagerService.class);
        r57.traceEnd();
    L504:
        if (this.mPackageManager.hasSystemFeature("android.hardware.tv.tuner") == false) goto L506;
        r57.traceBegin("StartTunerResourceManager");
        this.mSystemServiceManager.startService(TunerResourceManagerService.class);
        r57.traceEnd();
    L506:
        if (r28 == false) goto L509;
        r57.traceBegin("StartMediaQuality");
        this.mSystemServiceManager.startService(MediaQualityService.class);
        r57.traceEnd();
    L509:
        if (this.mPackageManager.hasSystemFeature("android.software.picture_in_picture") == false) goto L512;
        r57.traceBegin("StartMediaResourceMonitor");
        this.mSystemServiceManager.startService(MediaResourceMonitorService.class);
        r57.traceEnd();
    L512:
        if (this.mPackageManager.hasSystemFeature("android.software.leanback") == false) goto L514;
        r57.traceBegin("StartTvRemoteService");
        this.mSystemServiceManager.startService(TvRemoteService.class);
        r57.traceEnd();
    L514:
        r57.traceBegin("StartMediaRouterService");
        IMediaRouterService.Stub r56 = new MediaRouterService(r6);     // Catch: Throwable -> L521
        ServiceManager.addService("media_router", r56);     // Catch: Throwable -> L519
        r36 = r56;
    L523:
        r57.traceEnd();
        boolean r58 = this.mPackageManager.hasSystemFeature("android.hardware.biometrics.face");
        boolean r59 = this.mPackageManager.hasSystemFeature("android.hardware.biometrics.iris");
        boolean r60 = this.mPackageManager.hasSystemFeature("android.hardware.fingerprint");
        if (r58 == false) goto L527;
        r57.traceBegin("StartFaceSensor");
        FaceService r61 = (FaceService) this.mSystemServiceManager.startService(FaceService.class);
        r57.traceEnd();
    L527:
        if (r59 == false) goto L529;
        r57.traceBegin("StartIrisSensor");
        this.mSystemServiceManager.startService(IrisService.class);
        r57.traceEnd();
    L529:
        if (r60 == false) goto L531;
        r57.traceBegin("StartFingerprintSensor");
        FingerprintService r62 = (FingerprintService) this.mSystemServiceManager.startService(FingerprintService.class);
        r57.traceEnd();
    L531:
        r57.traceBegin("StartBiometricService");
        this.mSystemServiceManager.startService(BiometricService.class);
        r57.traceEnd();
        r57.traceBegin("StartAuthService");
        this.mSystemServiceManager.startService(AuthService.class);
        r57.traceEnd();
        if (r38 == true) goto L536;
        if (r28 == true) goto L536;
        if (r3 == true) goto L536;
        r57.traceBegin("StartAuthenticationPolicyService");
        this.mSystemServiceManager.startService(AuthenticationPolicyService.class);
        r57.traceEnd();
    L536:
        if (r38 == true) goto L543;
        r57.traceBegin("StartDynamicCodeLoggingService");
        DynamicCodeLoggingService.schedule(r6);     // Catch: Throwable -> L540
    L542:
        r57.traceEnd();
    L540:
        th = move-exception;
        reportWtf("starting DynamicCodeLoggingService", th);
    L543:
        if (r38 == true) goto L550;
        r57.traceBegin("StartPruneInstantAppsJobService");
        PruneInstantAppsJobService.schedule(r6);     // Catch: Throwable -> L547
    L549:
        r57.traceEnd();
    L547:
        th = move-exception;
        reportWtf("StartPruneInstantAppsJobService", th);
    L550:
        r57.traceBegin("StartSelinuxAuditLogsService");
        SelinuxAuditLogsService.schedule(r6);     // Catch: Throwable -> L553
    L555:
        r57.traceEnd();
        r57.traceBegin("StartShortcutServiceLifecycle");
        this.mSystemServiceManager.startService(ShortcutService.Lifecycle.class);
        r57.traceEnd();
        r57.traceBegin("StartLauncherAppsService");
        this.mSystemServiceManager.startService(LauncherAppsService.class);
        r57.traceEnd();
        r57.traceBegin("StartCrossProfileAppsService");
        this.mSystemServiceManager.startService(CrossProfileAppsService.class);
        r57.traceEnd();
        r57.traceBegin("StartPeopleService");
        this.mSystemServiceManager.startService(PeopleService.class);
        r57.traceEnd();
        r57.traceBegin("StartMediaMetricsManager");
        this.mSystemServiceManager.startService(MediaMetricsManagerService.class);
        r57.traceEnd();
        if (SystemProperties.getBoolean("ro.system_settings.service.backgound_install_control_enabled", true) == false) goto L558;
        r57.traceBegin("StartBackgroundInstallControlService");
        this.mSystemServiceManager.startService(BackgroundInstallControlService.class);
        r57.traceEnd();
    L558:
        r57.traceBegin("StartSystemAppProfileCollectionManagerService");
        SysMonitorSvcBridge.getFactory().getSystemAppProfileCollectionManagerService().startIfNeeded(this.mSystemServiceManager);
        r57.traceEnd();
        r44 = r127;
        r47 = r125;
        r10 = r17;
        r24 = r18;
        r40 = r46;
        r50 = r34;
        r51 = r35;
        r52 = r36;
        r43 = r310;
    L553:
        th = move-exception;
        reportWtf("starting SelinuxAuditLogsService", th);
    L519:
        th = th;
        r36 = r56;
    L522:
        reportWtf("starting MediaRouterService", th);
    L521:
        th = th;
        goto L522
    L501:
        if (this.mPackageManager.hasSystemFeature("android.software.leanback") == false) goto L504;
    L496:
        if (this.mPackageManager.hasSystemFeature("android.software.leanback") == false) goto L499;
    L476:
        th = move-exception;
        reportWtf("starting CertBlocklister", th);
    L466:
        th = th;
    L470:
        reportWtf("starting NetworkTimeUpdate service", th);
    L468:
        th = th;
        r127 = r410;
    L472:
        r127 = r410;
    L455:
        th = move-exception;
        reportWtf("starting RuntimeService", th);
    L450:
        th = move-exception;
        reportWtf("starting DiskStats Service", th);
        goto L452
    L439:
        if (r6.getResources().getBoolean(R.bool.config_enableCarDockHomeLaunch) == false) goto L441;
    L428:
        th = move-exception;
        Slog.e(TAG, "Failure starting HardwarePropertiesManagerService", th);
        r126 = r15;
        goto L430
    L419:
        if (this.mPackageManager.hasSystemFeature("android.hardware.usb.accessory") == true) goto L422;
        if (Build.IS_EMULATOR == false) goto L423;
    L415:
        Slog.e(TAG, "Failure starting AdbService");
        goto L416
    L384:
        String r63 = r6.getResources().getString(R.string.config_managed_provisioning_package);
        this.mSystemServiceManager.startService(r63 + "$Lifecycle");     // Catch: Throwable -> L387
    L387:
        th = move-exception;
        reportWtf("starting " + r63, th);
        goto L389
    L377:
        Slog.i(TAG, "Wallpaper service disabled by config");
    L357:
        th = move-exception;
        reportWtf("starting LocationTimeZoneManagerService service", th);
    L352:
        th = move-exception;
        reportWtf("starting AltitudeService service", th);
    L347:
        th = move-exception;
        reportWtf("starting TimeZoneDetectorService service", th);
    L342:
        th = move-exception;
        reportWtf("starting Country Detector", th);
        r125 = r14;
    L337:
        th = move-exception;
        reportWtf("starting TimeDetectorService service", th);
    L332:
        th = move-exception;
        reportWtf("starting UpdateLockService", th);
    L327:
        th = move-exception;
        reportWtf("starting SystemUpdateManagerService", th);
        goto L329
    L882:
        Slog.i(TAG, "Wigig Service");     // Catch: Throwable -> L320
        PathClassLoader r64 = new PathClassLoader("/system/system_ext/framework/wigig-service.jar:/system/system_ext/framework/vendor.qti.hardware.wigig.supptunnel-V1.0-java.jar:/system/system_ext/framework/vendor.qti.hardware.wigig.netperftuner-V1.0-java.jar:/system/system_ext/framework/vendor.qti.hardware.capabilityconfigstore-V1.0-java.jar", getClass().getClassLoader());     // Catch: Throwable -> L320
        ?? r311 = r49;
        r410 = null;
        r17 = r64.loadClass("com.qualcomm.qti.server.wigig.p2p.WigigP2pServiceImpl").getConstructor(new Class[]{Context.class}).newInstance(new Object[]{r6});     // Catch: Throwable -> L318
        Slog.i(TAG, "Successfully loaded WigigP2pServiceImpl class");     // Catch: Throwable -> L318
        ServiceManager.addService("wigigp2p", (IBinder) r17);     // Catch: Throwable -> L318
        r18 = r64.loadClass("com.qualcomm.qti.server.wigig.WigigService").getConstructor(new Class[]{Context.class}).newInstance(new Object[]{r6});     // Catch: Throwable -> L318
        Slog.i(TAG, "Successfully loaded WigigService class");     // Catch: Throwable -> L318
        ServiceManager.addService("wigig", (IBinder) r18);     // Catch: Throwable -> L318
        r310 = r311;
    L318:
        th = th;
    L322:
        reportWtf("starting WigigService", th);
        r310 = r311;
    L320:
        th = th;
        r311 = r49;
        r410 = null;
        goto L322
    L294:
        r57.traceBegin("StartVpnManagerService");
        ?? r65 = VpnManagerService.create(r6);     // Catch: Throwable -> L301
        ServiceManager.addService("vpn_management", r65);     // Catch: Throwable -> L299
        ?? r66 = r65;
    L304:
        r57.traceEnd();
        r34 = r66;
    L299:
        th = th;
    L303:
        reportWtf("starting VPN Manager Service", th);
        r66 = r65;
    L301:
        th = th;
        r65 = 0;
    L289:
        th = move-exception;
        reportWtf("starting SecurityStateManagerService", th);
    L282:
        th = th;
        r16 = r54;
    L285:
        reportWtf("starting PacProxyService", th);
    L284:
        th = th;
    L253:
        th = th;
    L257:
        reportWtf("starting NetworkPolicy Service", th);
        r49 = r48;
    L255:
        th = th;
        r48 = r39;
    L237:
        th = th;
    L241:
        reportWtf("starting NetworkManagement Service", th);
    L239:
        th = th;
        r46 = null;
    L230:
        th = move-exception;
        reportWtf("initializing NetworkStackClient", th);
    L225:
        th = move-exception;
        reportWtf("initializing ConnectivityModuleConnector", th);
        goto L227
    L221:
        Slog.d(TAG, "ContextualSearchManagerService not defined or disabled by flag");
        goto L222
    L217:
        Slog.d(TAG, "SmartspaceManagerService not defined by OEM or disabled by flag");
        goto L219
    L210:
        Slog.d(TAG, "ContentSuggestionsService not defined by OEM");
        goto L212
    L206:
        Slog.d(TAG, "AppPredictionService not defined by OEM");
        goto L208
    L202:
        Slog.d(TAG, "AmbientContextManagerService not defined by OEM or disabled by flag");
        goto L203
    L198:
        startWearableSensingService(r57);
        goto L199
    L194:
        Slog.d(TAG, "MusicRecognitionManagerService not defined by OEM or disabled by flag");
    L186:
        th = th;
    L190:
        reportWtf("starting StatusBarManagerService", th);
        r123 = r13;
    L188:
        th = th;
        goto L190
    L179:
        if (OemLockService.isHalPresent() == false) goto L181;
    L174:
        if (SystemProperties.getInt("ro.boot.dev_mode", 0) != 1) goto L176;
        r57.traceBegin("StartArcPersistentDataBlock");
        this.mSystemServiceManager.startService(ARC_PERSISTENT_DATA_BLOCK_SERVICE_CLASS);
        r57.traceEnd();
    L166:
        th = move-exception;
        reportWtf("starting LockSettingsService service", th);
    L158:
        th = move-exception;
        reportWtf("performing fstrim", th);
    L152:
        th = move-exception;
        reportWtf("update packages", th);     // Catch: Throwable -> L789
    L789:
        th = move-exception;
        Watchdog.getInstance().resumeWatchingCurrentThread("dexopt");
        throw th;
    L147:
        th = move-exception;
        reportWtf("starting GrammarInflectionService service", th);
    L142:
        th = move-exception;
        reportWtf("starting LocaleManagerService service", th);
        goto L144
    L127:
        if ("0".equals(SystemProperties.get("system_init.startmountservice")) == true) goto L139;
        r57.traceBegin("StartStorageManagerService");
        this.mSystemServiceManager.startService(StorageManagerService.Lifecycle.class);     // Catch: Throwable -> L131
        IStorageManager r67 = IStorageManager.Stub.asInterface(ServiceManager.getService("mount"));     // Catch: Throwable -> L131
    L133:
        r57.traceEnd();
        r57.traceBegin("StartStorageStatsService");
        this.mSystemServiceManager.startService(StorageStatsService.Lifecycle.class);     // Catch: Throwable -> L136
    L138:
        r57.traceEnd();
    L136:
        th = move-exception;
        reportWtf("starting StorageStatsService", th);
    L131:
        th = move-exception;
        reportWtf("starting StorageManagerService", th);
    L122:
        th = move-exception;
        reportWtf("making display ready", th);
    L115:
        th = move-exception;
        reportWtf("starting Accessibility Manager", th);
        goto L117
    L102:
        r38 = r5;
        StringBuilder r68 = new StringBuilder();     // Catch: Throwable -> L109
        r39 = null;
        r68.append("Starting custom IMMS: ");     // Catch: Throwable -> L107
        r68.append(r9);     // Catch: Throwable -> L107
        Slog.i(TAG, r68.toString());     // Catch: Throwable -> L107
        this.mSystemServiceManager.startService(r9);     // Catch: Throwable -> L107
    L107:
        th = th;
    L111:
        reportWtf("starting " + r9, th);
    L109:
        th = th;
        r39 = null;
        goto L111
    L118:
        r38 = r5;
        r39 = null;
        goto L119
    L95:
        if (r6.getResources().getBoolean(R.bool.config_avoidGfxAccel) == false) goto L97;
        Settings.Global.putInt(r6.getContentResolver(), "airplane_mode_on", 0);
        goto L97
    L71:
        if (ProfcollectForwardingService.enabled() == false) goto L73;
        r57.traceBegin(ProfcollectForwardingService.LOG_TAG);     // Catch: Throwable -> L46
        this.mSystemServiceManager.startService(ProfcollectForwardingService.class);     // Catch: Throwable -> L46
        r57.traceEnd();     // Catch: Throwable -> L46
        goto L73
    L64:
        if (r6.getPackageManager().hasSystemFeature("android.hardware.bluetooth") == true) goto L67;
        Slog.i(TAG, "No Bluetooth Service (Bluetooth Hardware Not Present)");     // Catch: Throwable -> L46
        goto L68
    L67:
        r57.traceBegin("StartBluetoothService");     // Catch: Throwable -> L792
        this.mSystemServiceManager.startServiceFromJar(BLUETOOTH_SERVICE_CLASS, BLUETOOTH_APEX_SERVICE_JAR_PATH);     // Catch: Throwable -> L792
        r57.traceEnd();     // Catch: Throwable -> L792
    L792:
        th = th;
        goto L808
    L51:
        r11 = false;
        goto L52
    L840:
        r57.traceBegin("StartCameraServiceProxy");     // Catch: Throwable -> L46
        this.mSystemServiceManager.startService(CameraServiceProxy.class);     // Catch: Throwable -> L46
        r57.traceEnd();     // Catch: Throwable -> L46
    L794:
        th = th;
    L796:
        th = th;
        goto L808
    L894:
        r57.traceBegin("StartConsumerIrService");     // Catch: Throwable -> L38
        IConsumerIrService.Stub r69 = new ConsumerIrService(r6);     // Catch: Throwable -> L38
        ServiceManager.addService("consumer_ir", r69);     // Catch: Throwable -> L38
        r57.traceEnd();     // Catch: Throwable -> L38
        r19 = r69;
    L38:
        th = th;
    L798:
        th = th;
    L800:
        th = th;
        goto L808
    L932:
        SysMonitorFwBridge.getFactory().getCustomLeakCanaryUtils().registerSettingObserver(r6);     // Catch: Throwable -> L20
    L20:
        th = th;
    L802:
        th = th;
        goto L808
    L904:
    L12:
        th = th;
        goto L808
    L8:
        if (this.mPackageManager.hasSystemFeature("android.software.telecom") == true) goto L14;
        if (this.mPackageManager.hasSystemFeature("android.hardware.telephony") == false) goto L15;
    L804:
        th = th;
    L806:
        th = th;
        goto L808
    }

    private static /* synthetic */ void lambda$startOtherServices$1() {
        Slog.i(TAG, "SecondaryZygotePreload");     // Catch: Exception -> L8
        TimingsTraceAndSlog traceLog = TimingsTraceAndSlog.newAsyncLog();     // Catch: Exception -> L8
        traceLog.traceBegin("SecondaryZygotePreload");     // Catch: Exception -> L8
        String[] abis32 = Build.SUPPORTED_32_BIT_ABIS;     // Catch: Exception -> L8
        if (abis32.length > 0) goto L6;
    L10:
        traceLog.traceEnd();     // Catch: Exception -> L8
        return;
    L6:
        if (Process.ZYGOTE_PROCESS.preloadDefault(abis32[0]) == true) goto L10;
        Slog.e(TAG, "Unable to preload default resources for secondary");     // Catch: Exception -> L8
    L8:
        ex = move-exception;
        Slog.e(TAG, "Exception preloading default resources", ex);
    }

    private static /* synthetic */ void lambda$startOtherServices$2() {
        TimingsTraceAndSlog traceLog = TimingsTraceAndSlog.newAsyncLog();
        traceLog.traceBegin(START_SENSOR_MANAGER_SERVICE);
        startISensorManagerService();
        traceLog.traceEnd();
    }

    private static /* synthetic */ void lambda$startOtherServices$3() {
        TimingsTraceAndSlog traceLog = TimingsTraceAndSlog.newAsyncLog();
        traceLog.traceBegin(START_HIDL_SERVICES);
        startHidlServices();
        traceLog.traceEnd();
    }

    private /* synthetic */ void lambda$startOtherServices$6(TimingsTraceAndSlog t, boolean isAutomotive, DevicePolicyManagerService.Lifecycle dpms, boolean isWatch, Context context, boolean safeMode, ConnectivityManager connectivityF, NetworkManagementService networkManagementF, NetworkPolicyManagerService networkPolicyF, VpnManagerService vpnManagerF, HsumBootUserInitializer hsumBootUserInitializer, CountryDetectorService countryDetectorF, NetworkTimeUpdateService networkTimeUpdaterF, InputManagerService inputManagerF, TelephonyRegistry telephonyRegistryF, MediaRouterService mediaRouterF, MmsServiceBroker mmsServiceF) {
        Slog.i(TAG, "Making services ready");
        t.traceBegin("StartActivityManagerReadyPhase");
        this.mSystemServiceManager.startBootPhase(t, 550);
        t.traceEnd();
        t.traceBegin("StartObservingNativeCrashes");
        this.mActivityManagerService.startObservingNativeCrashes();     // Catch: Throwable -> L5
    L7:
        t.traceEnd();
        t.traceBegin("RegisterAppOpsPolicy");
        this.mActivityManagerService.setAppOpsPolicy(new AppOpsPolicy(this.mSystemContext));     // Catch: Throwable -> L10
    L12:
        t.traceEnd();
        if (this.mWebViewUpdateService == null) goto L15;
        Future<?> webviewPrep = SystemServerInitThreadPool.submit(new SystemServer$$ExternalSyntheticLambda2(this), "WebViewFactoryPreparation");
        Future<?> webviewPrep2 = webviewPrep;
    L16:
        if (isAutomotive == false) goto L26;
        t.traceBegin("StartCarServiceHelperService");
        DevicePolicySafetyChecker r0 = this.mSystemServiceManager.startService(CAR_SERVICE_HELPER_SERVICE_CLASS);
        if ((r0 instanceof Dumpable) == false) goto L21;
        SystemServerDumper.m395$$Nest$maddDumpable(this.mDumper, (Dumpable) r0);
    L21:
        if ((r0 instanceof DevicePolicySafetyChecker) == false) goto L24;
        dpms.setDevicePolicySafetyChecker(r0);
    L24:
        t.traceEnd();
    L26:
        if (isWatch == false) goto L35;
        t.traceBegin("StartWearService");
        String wearServiceComponentNameString = context.getString(R.string.date_picker_day_typeface);
        if (TextUtils.isEmpty(wearServiceComponentNameString) == true) goto L33;
        ComponentName wearServiceComponentName = ComponentName.unflattenFromString(wearServiceComponentNameString);
        if (wearServiceComponentName == null) goto L32;
        Intent intent = new Intent();
        intent.setComponent(wearServiceComponentName);
        intent.addFlags(256);
        context.startServiceAsUser(intent, UserHandle.SYSTEM);
        goto L33
    L32:
        Slog.d(TAG, "Null wear service component name.");
    L33:
        t.traceEnd();
    L35:
        if (safeMode == false) goto L42;
        t.traceBegin("EnableAirplaneModeInSafeMode");
        connectivityF.setAirplaneMode(true);     // Catch: Throwable -> L39
    L41:
        t.traceEnd();
    L39:
        e = move-exception;
        reportWtf("enabling Airplane Mode during Safe Mode bootup", e);
    L42:
        t.traceBegin("MakeNetworkManagementServiceReady");
        if (networkManagementF == null) goto L50;
        networkManagementF.systemReady();     // Catch: Throwable -> L46
    L46:
        e = move-exception;
        reportWtf("making Network Managment Service ready", e);
    L50:
        if (networkPolicyF == null) goto L52;
        CountDownLatch networkPolicyInitReadySignal = networkPolicyF.networkScoreAndNetworkManagementServiceReady();
        CountDownLatch networkPolicyInitReadySignal2 = networkPolicyInitReadySignal;
    L53:
        t.traceEnd();
        t.traceBegin("MakeConnectivityServiceReady");
        if (connectivityF != null) goto L164;
    L60:
        t.traceEnd();
        t.traceBegin("MakeVpnManagerServiceReady");
        if (vpnManagerF != null) goto L154;
    L67:
        t.traceEnd();
        t.traceBegin("MakeNetworkPolicyServiceReady");
        if (networkPolicyF != null) goto L180;
    L74:
        t.traceEnd();
        this.mPackageManagerService.waitForAppDataPrepared();
        t.traceBegin("PhaseThirdPartyAppsCanStart");
        if (webviewPrep2 == null) goto L77;
        ConcurrentUtils.waitForFutureNoInterrupt(webviewPrep2, "WebViewFactoryPreparation");
    L77:
        this.mSystemServiceManager.startBootPhase(t, 600);
        t.traceEnd();
        if (hsumBootUserInitializer == null) goto L80;
        t.traceBegin("HsumBootUserInitializer.systemRunning");
        hsumBootUserInitializer.systemRunning(t);
        t.traceEnd();
    L80:
        t.traceBegin("StartNetworkStack");
        NetworkStackClient.getInstance().start();     // Catch: Throwable -> L83
    L85:
        t.traceEnd();
        t.traceBegin("StartTethering");
        ConnectivityModuleConnector.getInstance().startModuleService(TETHERING_CONNECTOR_CLASS, "android.permission.MAINLINE_NETWORK_STACK", new SystemServer$$ExternalSyntheticLambda3());     // Catch: Throwable -> L88
    L90:
        t.traceEnd();
        t.traceBegin("MakeCountryDetectionServiceReady");
        if (countryDetectorF != null) goto L166;
    L97:
        t.traceEnd();
        t.traceBegin("MakeNetworkTimeUpdateReady");
        if (networkTimeUpdaterF != null) goto L156;
    L104:
        t.traceEnd();
        t.traceBegin("MakeTelephonyRegistryReady");
        if (telephonyRegistryF != null) goto L182;
    L111:
        t.traceEnd();
        t.traceBegin("MakeMediaRouterServiceReady");
        if (mediaRouterF != null) goto L170;
    L118:
        t.traceEnd();
        if (this.mPackageManager.hasSystemFeature("android.hardware.telephony") == false) goto L128;
        t.traceBegin("MakeMmsServiceReady");
        if (mmsServiceF != null) goto L168;
    L127:
        t.traceEnd();
        goto L128
    L168:
        mmsServiceF.systemRunning();     // Catch: Throwable -> L124
    L124:
        e = move-exception;
        reportWtf("Notifying MmsService running", e);
    L128:
        t.traceBegin("IncidentDaemonReady");
        IIncidentManager incident = IIncidentManager.Stub.asInterface(ServiceManager.getService("incident"));     // Catch: Throwable -> L133
        if (incident == null) goto L137;
        incident.systemRunning();     // Catch: Throwable -> L133
    L137:
        t.traceEnd();
        if (this.mIncrementalServiceHandle == 0) goto L140;
        t.traceBegin("MakeIncrementalServiceReady");
        setIncrementalServiceSystemReady(this.mIncrementalServiceHandle);
        t.traceEnd();
    L140:
        t.traceBegin("OdsignStatsLogger");
        OdsignStatsLogger.triggerStatsWrite();     // Catch: Throwable -> L143
    L145:
        t.traceEnd();
        if (SysMonitorFwBridge.getFactory().getResprobe().isFeatureEnabled() == false) goto L184;
        boolean ok = SysMonitorFwBridge.getFactory().getResprobe().init();
        if (ok != true) goto L150;
        Slog.d(TAG, "Resprobe init success");
        return;
    L150:
        Slog.e(TAG, "Resprobe init failed");
        return;
    L184:
        return;
    L143:
        e = move-exception;
        reportWtf("Triggering OdsignStatsLogger", e);
    L133:
        e = move-exception;
        reportWtf("Notifying incident daemon running", e);
        goto L137
    L170:
        mediaRouterF.systemRunning();     // Catch: Throwable -> L115
    L115:
        e = move-exception;
        reportWtf("Notifying MediaRouterService running", e);
        goto L118
    L182:
        telephonyRegistryF.systemRunning();     // Catch: Throwable -> L108
    L108:
        e = move-exception;
        reportWtf("Notifying TelephonyRegistry running", e);
        goto L111
    L156:
        networkTimeUpdaterF.systemRunning();     // Catch: Throwable -> L101
    L101:
        e = move-exception;
        reportWtf("Notifying NetworkTimeService running", e);
        goto L104
    L166:
        countryDetectorF.systemRunning();     // Catch: Throwable -> L94
    L94:
        e = move-exception;
        reportWtf("Notifying CountryDetectorService running", e);
    L88:
        e = move-exception;
        reportWtf("starting Tethering", e);
    L83:
        e = move-exception;
        reportWtf("starting Network Stack", e);
        goto L85
    L180:
        networkPolicyF.systemReady(networkPolicyInitReadySignal2);     // Catch: Throwable -> L71
    L71:
        e = move-exception;
        reportWtf("making Network Policy Service ready", e);
        goto L74
    L154:
        vpnManagerF.systemReady();     // Catch: Throwable -> L64
    L64:
        e = move-exception;
        reportWtf("making VpnManagerService ready", e);
        goto L67
    L164:
        connectivityF.systemReady();     // Catch: Throwable -> L57
    L57:
        e = move-exception;
        reportWtf("making Connectivity Service ready", e);
        goto L60
    L52:
        networkPolicyInitReadySignal2 = null;
        goto L53
    L15:
        webviewPrep2 = null;
    L10:
        e = move-exception;
        reportWtf("registering app ops policy", e);
    L5:
        e = move-exception;
        reportWtf("observing native crashes", e);
        goto L7
    }

    private /* synthetic */ void lambda$startOtherServices$4() {
        Slog.i(TAG, "WebViewFactoryPreparation");
        TimingsTraceAndSlog traceLog = TimingsTraceAndSlog.newAsyncLog();
        traceLog.traceBegin("WebViewFactoryPreparation");
        ConcurrentUtils.waitForFutureNoInterrupt(this.mZygotePreload, "Zygote preload");
        this.mZygotePreload = null;
        this.mWebViewUpdateService.prepareWebViewInSystemServer();
        traceLog.traceEnd();
    }

    private static /* synthetic */ void lambda$startOtherServices$5(IBinder service) {
        ServiceManager.addService("tethering", service, false, 6);
    }

    private void startOnDeviceIntelligenceService(TimingsTraceAndSlog t) {
        t.traceBegin("startOnDeviceIntelligenceManagerService");
        this.mSystemServiceManager.startService(ON_DEVICE_INTELLIGENCE_MANAGER_SERVICE_CLASS);
        t.traceEnd();
    }

    private void startApexServices(TimingsTraceAndSlog t) {
        if (Build.IS_DEBUGGABLE == true) goto L5;
    L9:
        t.traceBegin("startApexServices");
        List<ApexSystemServiceInfo> services = ApexManager.getInstance().getApexSystemServices();
        Iterator<ApexSystemServiceInfo> r1 = services.iterator();
    L11:
        if (r1.hasNext() == false) goto L17;
        ApexSystemServiceInfo info = r1.next();
        String name = info.getName();
        String jarPath = info.getJarPath();
        t.traceBegin("starting " + name);
        if (TextUtils.isEmpty(jarPath) == false) goto L15;
        this.mSystemServiceManager.startService(name);
    L16:
        t.traceEnd();
        goto L11
    L15:
        this.mSystemServiceManager.startServiceFromJar(name, jarPath);
        goto L16
    L17:
        this.mSystemServiceManager.sealStartedServices();
        t.traceEnd();
        return;
    L5:
        if (SystemProperties.getBoolean("debug.crash_system", false) == false) goto L9;
        throw new RuntimeException();
    }

    private void updateWatchdogTimeout(TimingsTraceAndSlog t) {
        t.traceBegin("UpdateWatchdogTimeout");
        Watchdog.getInstance().registerSettingsObserver(this.mSystemContext);
        t.traceEnd();
    }

    private boolean deviceHasConfigString(Context context, int resId) {
        String serviceName = context.getString(resId);
        return !TextUtils.isEmpty(serviceName);
    }

    private void startSystemCaptionsManagerService(Context context, TimingsTraceAndSlog t) {
        if (deviceHasConfigString(context, R.string.config_help_url_action_disabled_by_advanced_protection) == true) goto L6;
        Slog.d(TAG, "SystemCaptionsManagerService disabled because resource is not overlaid");
        return;
    L6:
        t.traceBegin("StartSystemCaptionsManagerService");
        this.mSystemServiceManager.startService(SystemCaptionsManagerService.class);
        t.traceEnd();
    }

    private void startTextToSpeechManagerService(Context context, TimingsTraceAndSlog t) {
        t.traceBegin("StartTextToSpeechManagerService");
        this.mSystemServiceManager.startService(TextToSpeechManagerService.class);
        t.traceEnd();
    }

    private void startContentCaptureService(Context context, TimingsTraceAndSlog t) {
        boolean explicitlyEnabled = false;
        String settings = DeviceConfig.getProperty("content_capture", "service_explicitly_enabled");
        if (settings != null) goto L5;
    L11:
        if (explicitlyEnabled == false) goto L13;
    L19:
        t.traceBegin("StartContentCaptureService");
        this.mSystemServiceManager.startService(ContentCaptureManagerService.class);
        ContentCaptureManagerInternal ccmi = (ContentCaptureManagerInternal) LocalServices.getService(ContentCaptureManagerInternal.class);
        if (ccmi != null) goto L22;
    L24:
        t.traceEnd();
        return;
    L22:
        if (this.mActivityManagerService == null) goto L24;
        this.mActivityManagerService.setContentCaptureManager(ccmi);
        goto L24
    L13:
        if (deviceHasConfigString(context, R.string.config_displayLightSensorType) == true) goto L17;
        Slog.d(TAG, "ContentCaptureService disabled because resource is not overlaid");
        return;
    L17:
        if (deviceHasConfigString(context, R.string.config_displayWhiteBalanceColorTemperatureSensorName) == true) goto L19;
        Slog.d(TAG, "ContentProtectionService disabled because resource is not overlaid, ContentCaptureService still enabled");
        goto L19
    L5:
        if (settings.equalsIgnoreCase("default") == true) goto L11;
        explicitlyEnabled = Boolean.parseBoolean(settings);
        if (explicitlyEnabled == false) goto L9;
        Slog.d(TAG, "ContentCaptureService explicitly enabled by DeviceConfig");
        goto L11
    L9:
        Slog.d(TAG, "ContentCaptureService explicitly disabled by DeviceConfig");
    }

    private void startAttentionService(Context context, TimingsTraceAndSlog t) {
        if (AttentionManagerService.isServiceConfigured(context) == true) goto L6;
        Slog.d(TAG, "AttentionService is not configured on this device");
        return;
    L6:
        t.traceBegin("StartAttentionManagerService");
        this.mSystemServiceManager.startService(AttentionManagerService.class);
        t.traceEnd();
    }

    private void startRotationResolverService(Context context, TimingsTraceAndSlog t) {
        if (RotationResolverManagerService.isServiceConfigured(context) == true) goto L6;
        Slog.d(TAG, "RotationResolverService is not configured on this device");
        return;
    L6:
        t.traceBegin("StartRotationResolverService");
        this.mSystemServiceManager.startService(RotationResolverManagerService.class);
        t.traceEnd();
    }

    private void startWearableSensingService(TimingsTraceAndSlog t) {
        t.traceBegin("startWearableSensingService");
        this.mSystemServiceManager.startService(WearableSensingManagerService.class);
        t.traceEnd();
    }

    private static void startSystemUi(Context context, WindowManagerService windowManager) {
        PackageManagerInternal pm = (PackageManagerInternal) LocalServices.getService(PackageManagerInternal.class);
        Intent intent = new Intent();
        intent.setComponent(pm.getSystemUiServiceComponent());
        intent.addFlags(256);
        context.startServiceAsUser(intent, UserHandle.SYSTEM);
        windowManager.onSystemUiStarted();
    }

    private static boolean handleEarlySystemWtf(IBinder app, String tag, boolean system, ApplicationErrorReport.ParcelableCrashInfo crashInfo, int immediateCallerPid) {
        int myPid = Process.myPid();
        com.android.server.am.EventLogTags.writeAmWtf(UserHandle.getUserId(1000), myPid, "system_server", -1, tag, crashInfo.exceptionMessage);
        FrameworkStatsLog.write(80, 1000, tag, "system_server", myPid, 3);
        monitor-enter(SystemServer.class);
    L7:
        th = move-exception;
        throw th;
    L5:
        if (sPendingWtfs != null) goto L9;
        sPendingWtfs = new LinkedList();     // Catch: Throwable -> L7
    L9:
        sPendingWtfs.add(new Pair(tag, crashInfo));     // Catch: Throwable -> L7
        monitor-exit(SystemServer.class);     // Catch: Throwable -> L7
        return false;
    }
}
