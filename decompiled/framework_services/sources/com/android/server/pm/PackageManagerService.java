package com.android.server.pm;

import android.R;
import android.app.ActivityManager;
import android.app.ActivityManagerInternal;
import android.app.AppOpsManager;
import android.app.AppOpsManagerInternal;
import android.app.ApplicationPackageManager;
import android.app.BroadcastOptions;
import android.app.IActivityManager;
import android.app.admin.DevicePolicyManagerInternal;
import android.app.admin.IDevicePolicyManager;
import android.app.admin.SecurityLog;
import android.app.backup.IBackupManager;
import android.app.role.RoleManager;
import android.content.ComponentName;
import android.content.ContentResolver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.IntentSender;
import android.content.pm.ActivityInfo;
import android.content.pm.ApplicationInfo;
import android.content.pm.ArchivedPackageParcel;
import android.content.pm.AuxiliaryResolveInfo;
import android.content.pm.ChangedPackages;
import android.content.pm.ComponentInfo;
import android.content.pm.FallbackCategoryProvider;
import android.content.pm.FeatureInfo;
import android.content.pm.IDexModuleRegisterCallback;
import android.content.pm.IObricPackageManager;
import android.content.pm.IOnChecksumsReadyListener;
import android.content.pm.IPackageDataObserver;
import android.content.pm.IPackageDeleteObserver2;
import android.content.pm.IPackageManagerExt;
import android.content.pm.IPackageManagerSmtEx;
import android.content.pm.IPackageMoveObserver;
import android.content.pm.IncrementalStatesInfo;
import android.content.pm.InstallSourceInfo;
import android.content.pm.InstantAppInfo;
import android.content.pm.InstantAppRequest;
import android.content.pm.LauncherActivityInfo;
import android.content.pm.ModuleInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageInfoLite;
import android.content.pm.PackageInstaller;
import android.content.pm.PackageManager;
import android.content.pm.PackageManagerInternal;
import android.content.pm.PackagePartitions;
import android.content.pm.ParceledListSlice;
import android.content.pm.PermissionGroupInfo;
import android.content.pm.ProviderInfo;
import android.content.pm.ResolveInfo;
import android.content.pm.SharedLibraryInfo;
import android.content.pm.Signature;
import android.content.pm.SigningDetails;
import android.content.pm.SuspendDialogInfo;
import android.content.pm.TestUtilityService;
import android.content.pm.UserInfo;
import android.content.pm.UserPackage;
import android.content.pm.VerifierDeviceIdentity;
import android.content.pm.VerifierInfo;
import android.content.pm.VersionedPackage;
import android.content.pm.overlay.OverlayPaths;
import android.content.pm.parsing.PackageLite;
import android.content.res.Resources;
import android.database.ContentObserver;
import android.graphics.Bitmap;
import android.hardware.audio.common.V2_0.AudioFormat;
import android.hardware.display.DisplayManager;
import android.net.Uri;
import android.os.Binder;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.os.FileUtils;
import android.os.Handler;
import android.os.IBinder;
import android.os.IRemoteCallback;
import android.os.Message;
import android.os.Parcel;
import android.os.ParcelFileDescriptor;
import android.os.ParcelableException;
import android.os.PersistableBundle;
import android.os.Process;
import android.os.ReconcileSdkDataArgs;
import android.os.RemoteException;
import android.os.ResultReceiver;
import android.os.ServiceManager;
import android.os.ShellCallback;
import android.os.SystemClock;
import android.os.SystemProperties;
import android.os.Trace;
import android.os.UserHandle;
import android.os.incremental.IncrementalManager;
import android.os.incremental.PerUidReadTimeouts;
import android.os.storage.StorageManager;
import android.os.storage.StorageManagerInternal;
import android.permission.PermissionManager;
import android.pico.utils.ExtImplFactory;
import android.provider.DeviceConfig;
import android.text.TextUtils;
import android.util.ArrayMap;
import android.util.ArraySet;
import android.util.BoostFramework;
import android.util.DisplayMetrics;
import android.util.EventLog;
import android.util.ExceptionUtils;
import android.util.Log;
import android.util.Pair;
import android.util.Slog;
import android.util.SparseArray;
import android.util.SparseBooleanArray;
import android.util.Xml;
import android.view.Display;
import com.android.internal.app.ResolverActivity;
import com.android.internal.content.F2fsUtils;
import com.android.internal.content.om.OverlayConfig;
import com.android.internal.pm.parsing.PackageParser2;
import com.android.internal.pm.parsing.pkg.AndroidPackageInternal;
import com.android.internal.pm.parsing.pkg.ParsedPackage;
import com.android.internal.pm.pkg.component.ParsedInstrumentation;
import com.android.internal.pm.pkg.component.ParsedMainComponent;
import com.android.internal.pm.pkg.parsing.ParsingPackageUtils;
import com.android.internal.telephony.CarrierAppUtils;
import com.android.internal.util.ArrayUtils;
import com.android.internal.util.CollectionUtils;
import com.android.internal.util.ConcurrentUtils;
import com.android.internal.util.DumpUtils;
import com.android.internal.util.FrameworkStatsLog;
import com.android.internal.util.FunctionalUtils;
import com.android.internal.util.Preconditions;
import com.android.modules.utils.TypedXmlPullParser;
import com.android.modules.utils.TypedXmlSerializer;
import com.android.permission.persistence.RuntimePermissionsPersistence;
import com.android.permission.persistence.RuntimePermissionsState;
import com.android.server.EventLogTags;
import com.android.server.FgThread;
import com.android.server.LocalManagerRegistry;
import com.android.server.LocalServices;
import com.android.server.LockGuard;
import com.android.server.ServiceThread;
import com.android.server.SysOptBridge;
import com.android.server.SystemConfig;
import com.android.server.ThreadPriorityBooster;
import com.android.server.Watchdog;
import com.android.server.am.HostingRecord;
import com.android.server.am.SettingsToPropertiesMapper;
import com.android.server.apphibernation.AppHibernationManagerInternal;
import com.android.server.art.DexUseManagerLocal;
import com.android.server.art.model.DeleteResult;
import com.android.server.compat.CompatChange;
import com.android.server.compat.PlatformCompat;
import com.android.server.location.settings.SettingsStore$$ExternalSyntheticLambda0;
import com.android.server.pm.dex.ArtManagerService;
import com.android.server.pm.dex.DexManager;
import com.android.server.pm.dex.DynamicCodeLogger;
import com.android.server.pm.local.PackageManagerLocalImpl;
import com.android.server.pm.parsing.PackageCacher;
import com.android.server.pm.parsing.PackageInfoUtils;
import com.android.server.pm.parsing.pkg.AndroidPackageUtils;
import com.android.server.pm.permission.LegacyPermissionManagerInternal;
import com.android.server.pm.permission.LegacyPermissionManagerService;
import com.android.server.pm.permission.LegacyPermissionSettings;
import com.android.server.pm.permission.ObricPermissionCheckHelper;
import com.android.server.pm.permission.PermissionManagerService;
import com.android.server.pm.permission.PermissionManagerServiceInternal;
import com.android.server.pm.pkg.AndroidPackage;
import com.android.server.pm.pkg.ArchiveState;
import com.android.server.pm.pkg.PackageState;
import com.android.server.pm.pkg.PackageStateInternal;
import com.android.server.pm.pkg.PackageUserState;
import com.android.server.pm.pkg.PackageUserStateInternal;
import com.android.server.pm.pkg.SharedUserApi;
import com.android.server.pm.pkg.mutate.PackageStateMutator;
import com.android.server.pm.pkg.mutate.PackageStateWrite;
import com.android.server.pm.pkg.mutate.PackageUserStateWrite;
import com.android.server.pm.resolution.ComponentResolver;
import com.android.server.pm.resolution.ComponentResolverApi;
import com.android.server.pm.verify.domain.DomainVerificationManagerInternal;
import com.android.server.pm.verify.domain.DomainVerificationService;
import com.android.server.pm.verify.domain.proxy.DomainVerificationProxy;
import com.android.server.slice.SliceClientPermissions;
import com.android.server.storage.DeviceStorageMonitorInternal;
import com.android.server.storage.DeviceStorageMonitorServiceSmtEx;
import com.android.server.utils.SnapshotCache;
import com.android.server.utils.TimingsTraceAndSlog;
import com.android.server.utils.Watchable;
import com.android.server.utils.Watched;
import com.android.server.utils.WatchedArrayMap;
import com.android.server.utils.WatchedArraySet;
import com.android.server.utils.WatchedSparseBooleanArray;
import com.android.server.utils.WatchedSparseIntArray;
import com.android.server.utils.Watcher;
import com.obric.utils.ObricImplFactory;
import dalvik.system.VMRuntime;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileDescriptor;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.cert.Certificate;
import java.security.cert.CertificateException;
import java.security.cert.CertificateFactory;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Executor;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;
import java.util.function.Consumer;
import java.util.function.Predicate;
import libcore.util.EmptyArray;
import libcore.util.HexEncoding;

/* JADX INFO: loaded from: classes2.dex */
public class PackageManagerService implements PackageSender, TestUtilityService {
    private static final String AIKERNEL_PACKAGE_NAME = "com.obric.aikernel";
    public static final String APP_METADATA_FILE_NAME = "app.metadata";
    private static final Map<String, String> AUTHORIZED_6939_PACKAGES = null;
    private static final Handler.Callback BACKGROUND_HANDLER_CALLBACK = null;
    private static final int BLUETOOTH_UID = 1002;
    private static final long BROADCAST_DELAY = 1000;
    private static final long BROADCAST_DELAY_DURING_STARTUP = 10000;
    static final int CHECK_PENDING_VERIFICATION = 16;
    private static final String COMPANION_PACKAGE_NAME = "com.android.companiondevicemanager";
    public static final String COMPRESSED_EXTENSION = ".gz";
    static final boolean DEBUG_ABI_SELECTION = false;
    static final boolean DEBUG_BACKUP = false;
    public static final boolean DEBUG_COMPRESSION = false;
    public static final boolean DEBUG_DEXOPT = false;
    static final boolean DEBUG_DOMAIN_VERIFICATION = false;
    public static final boolean DEBUG_INSTALL = false;
    public static final boolean DEBUG_INSTANT = false;
    static final boolean DEBUG_INTENT_MATCHING = false;
    static final boolean DEBUG_PACKAGE_INFO = false;
    public static final boolean DEBUG_PACKAGE_SCANNING = false;
    public static final boolean DEBUG_PERMISSIONS = false;
    private static final boolean DEBUG_PER_UID_READ_TIMEOUTS = false;
    static final boolean DEBUG_PREFERRED = false;
    public static final boolean DEBUG_REMOVE = true;
    public static final boolean DEBUG_SETTINGS = false;
    static final boolean DEBUG_UPGRADE = false;
    static final boolean DEBUG_VERIFY = false;
    static final int DEFAULT_FILE_ACCESS_MODE = 420;
    static final int DEFAULT_NATIVE_LIBRARY_FILE_ACCESS_MODE = 493;
    static final long DEFAULT_UNUSED_STATIC_SHARED_LIB_MIN_CACHE_PERIOD = 0;
    static final int DEFAULT_VERIFICATION_RESPONSE = 1;
    static final int DEFERRED_NO_KILL_INSTALL_OBSERVER = 24;
    private static final int DEFERRED_NO_KILL_INSTALL_OBSERVER_DELAY_MS = 500;
    static final int DEFERRED_NO_KILL_POST_DELETE = 23;
    private static final int DEFERRED_NO_KILL_POST_DELETE_DELAY_MS = 3000;
    private static final long DEFERRED_NO_KILL_POST_DELETE_DELAY_MS_EXTENDED = 0;
    static final int DEFERRED_PENDING_KILL_INSTALL_OBSERVER = 29;
    private static final int DEFERRED_PENDING_KILL_INSTALL_OBSERVER_DELAY_MS = 1000;
    static final int DOMAIN_VERIFICATION = 27;
    static final int[] EMPTY_INT_ARRAY = null;
    private static final PerUidReadTimeouts[] EMPTY_PER_UID_READ_TIMEOUTS_ARRAY = null;
    private static final boolean ENABLE_BOOST = false;
    static final int ENABLE_ROLLBACK_STATUS = 21;
    static final int ENABLE_ROLLBACK_TIMEOUT = 22;
    static final boolean HIDE_EPHEMERAL_APIS = false;
    static final int INSTANT_APP_RESOLUTION_PHASE_TWO = 20;
    private static final int LOG_UID = 1007;
    public static final int MIN_INSTALLABLE_TARGET_SDK = 0;
    private static final int NETWORKSTACK_UID = 1073;
    private static final int NFC_UID = 1027;
    static final String PACKAGE_MIME_TYPE = "application/vnd.android.package-archive";
    static final String PACKAGE_SCHEME = "package";
    public static final int PACKAGE_STARTABILITY_DIRECT_BOOT_UNSUPPORTED = 4;
    public static final int PACKAGE_STARTABILITY_FROZEN = 3;
    public static final int PACKAGE_STARTABILITY_NOT_FOUND = 1;
    public static final int PACKAGE_STARTABILITY_NOT_SYSTEM = 2;
    public static final int PACKAGE_STARTABILITY_OK = 0;
    static final int PACKAGE_VERIFIED = 15;
    public static final String PLATFORM_PACKAGE_NAME = "android";
    static final int POST_INSTALL = 9;
    static final String PRECOMPILE_LAYOUTS = "pm.precompile_layouts";
    private static final String PROPERTY_DEFERRED_NO_KILL_POST_DELETE_DELAY_MS_EXTENDED = "deferred_no_kill_post_delete_delay_ms_extended";
    private static final String PROPERTY_INCFS_DEFAULT_TIMEOUTS = "incfs_default_timeouts";
    private static final String PROPERTY_IS_PRE_APPROVAL_REQUEST_AVAILABLE = "is_preapproval_available";
    private static final String PROPERTY_IS_UPDATE_OWNERSHIP_ENFORCEMENT_AVAILABLE = "is_update_ownership_enforcement_available";
    private static final String PROPERTY_KNOWN_DIGESTERS_LIST = "known_digesters_list";
    private static final long PRUNE_UNUSED_SHARED_LIBRARIES_DELAY = 0;
    static final int PRUNE_UNUSED_STATIC_SHARED_LIBRARIES = 28;
    private static final int RADIO_UID = 1001;
    static final char RANDOM_CODEPATH_PREFIX = '-';
    static final String RANDOM_DIR_PREFIX = "~~";
    public static final int REASON_AB_OTA = 10;
    public static final int REASON_BACKGROUND_DEXOPT = 9;
    public static final int REASON_BOOT_AFTER_MAINLINE_UPDATE = 13;
    public static final int REASON_BOOT_AFTER_OTA = 1;
    public static final int REASON_CMDLINE = 12;
    public static final int REASON_FIRST_BOOT = 0;
    public static final int REASON_INACTIVE_PACKAGE_DOWNGRADE = 11;
    public static final int REASON_INSTALL = 3;
    public static final int REASON_INSTALL_BULK = 5;
    public static final int REASON_INSTALL_BULK_DOWNGRADED = 7;
    public static final int REASON_INSTALL_BULK_SECONDARY = 6;
    public static final int REASON_INSTALL_BULK_SECONDARY_DOWNGRADED = 8;
    public static final int REASON_INSTALL_FAST = 4;
    public static final int REASON_LAST = 14;
    public static final int REASON_POST_BOOT = 2;
    public static final int REASON_SHARED = 14;
    private static final int REQUIRED_VERIFIERS_MAX_COUNT = 2;
    static final int SCAN_AS_APEX = 67108864;
    static final int SCAN_AS_APK_IN_APEX = 8388608;
    static final int SCAN_AS_FACTORY = 33554432;
    static final int SCAN_AS_FULL_APP = 16384;
    static final int SCAN_AS_INSTANT_APP = 8192;
    static final int SCAN_AS_ODM = 4194304;
    static final int SCAN_AS_OEM = 262144;
    static final int SCAN_AS_PRIVILEGED = 131072;
    static final int SCAN_AS_PRODUCT = 1048576;
    static final int SCAN_AS_STOPPED_SYSTEM_APP = 134217728;
    static final int SCAN_AS_SYSTEM = 65536;
    static final int SCAN_AS_SYSTEM_EXT = 2097152;
    static final int SCAN_AS_VENDOR = 524288;
    static final int SCAN_AS_VIRTUAL_PRELOAD = 32768;
    static final int SCAN_BOOTING = 16;
    static final int SCAN_DONT_KILL_APP = 1024;
    static final int SCAN_DROP_CACHE = 16777216;
    static final int SCAN_FIRST_BOOT_OR_UPGRADE = 4096;
    static final int SCAN_IGNORE_FROZEN = 2048;
    static final int SCAN_INITIAL = 512;
    static final int SCAN_MOVE = 256;
    static final int SCAN_NEW_INSTALL = 4;
    static final int SCAN_NO_DEX = 1;
    static final int SCAN_REQUIRE_KNOWN = 128;
    static final int SCAN_UPDATE_SIGNATURE = 2;
    static final int SCAN_UPDATE_TIME = 8;
    static final int SEND_PENDING_BROADCAST = 1;
    private static final int SE_UID = 1068;
    static final String SHELL_PACKAGE_NAME = "com.android.shell";
    private static final int SHELL_UID = 2000;
    private static final String STATIC_SHARED_LIB_DELIMITER = "_";
    public static final String STUB_SUFFIX = "-Stub";
    public static final List<ScanPartition> SYSTEM_PARTITIONS = null;
    static final String TAG = "PackageManager";
    private static final long THROW_EXCEPTION_ON_REQUIRE_INSTALL_PACKAGES_TO_ADD_INSTALLER_PACKAGE = 150857253;
    public static final boolean TRACE_SNAPSHOTS = false;
    private static final int UWB_UID = 1083;
    static final long WATCHDOG_TIMEOUT = 600000;
    static final int WRITE_DIRTY_PACKAGE_RESTRICTIONS = 14;
    static final int WRITE_PACKAGE_LIST = 19;
    static final int WRITE_SETTINGS = 13;
    static final int WRITE_SETTINGS_DELAY = 10000;
    static final int WRITE_USER_PACKAGE_RESTRICTIONS = 30;
    private static final HashSet<Integer> sAuhthorized6939UidCache = null;
    private static final AtomicReference<Computer> sSnapshot = null;
    private static final AtomicInteger sSnapshotPendingVersion = null;
    private static ThreadPriorityBooster sThreadPriorityBooster;
    final String mAmbientContextDetectionPackage;

    @Watched(manual = true)
    private ApplicationInfo mAndroidApplication;
    final ApexManager mApexManager;
    protected final AppDataHelper mAppDataHelper;
    private final File mAppInstallDir;
    final String mAppPredictionServicePackage;

    @Watched
    final AppsFilterImpl mAppsFilter;
    final ArtManagerService mArtManagerService;
    private final ArrayMap<String, FeatureInfo> mAvailableFeatures;
    final Handler mBackgroundHandler;
    final BroadcastHelper mBroadcastHelper;
    private File mCacheDir;
    final ChangedPackagesTracker mChangedPackagesTracker;
    final CompilerStats mCompilerStats;

    @Watched
    final ComponentResolver mComponentResolver;
    final String mConfiguratorPackage;
    final Context mContext;
    ComponentName mCustomResolverComponentName;
    private final int mDefParseFlags;
    private final DefaultAppProvider mDefaultAppProvider;
    final String mDefaultTextClassifierPackage;
    final DeletePackageHelper mDeletePackageHelper;
    private IDevicePolicyManager mDevicePolicyManager;
    private final DexManager mDexManager;
    protected final DexOptHelper mDexOptHelper;
    final ArraySet<Integer> mDirtyUsers;
    private final DistractingPackageHelper mDistractingPackageHelper;
    private final DomainVerificationConnection mDomainVerificationConnection;
    final DomainVerificationManagerInternal mDomainVerificationManager;
    private final DynamicCodeLogger mDynamicCodeLogger;
    private ArraySet<String> mExistingPackages;
    private final IExtPackageManagerService mExt;
    PackageManagerInternal.ExternalSourcesPolicy mExternalSourcesPolicy;
    final boolean mFactoryTest;
    boolean mFirstBoot;
    private final FreeStorageHelper mFreeStorageHelper;
    final WatchedArrayMap<String, Integer> mFrozenPackages;
    private final SnapshotCache<WatchedArrayMap<String, Integer>> mFrozenPackagesSnapshot;
    final Handler mHandler;
    final String mIncidentReportApproverPackage;
    final IncrementalManager mIncrementalManager;
    private final String mIncrementalVersion;
    private final InitAppsHelper mInitAppsHelper;
    final Set<String> mInitialNonStoppedSystemPackages;
    final PackageManagerServiceInjector mInjector;
    final PackageManagerTracedLock mInstallLock;
    private final InstallPackageHelper mInstallPackageHelper;
    final Installer mInstaller;
    final PackageInstallerService mInstallerService;

    @Watched(manual = true)
    ActivityInfo mInstantAppInstallerActivity;

    @Watched(manual = true)
    private final ResolveInfo mInstantAppInstallerInfo;

    @Watched
    final InstantAppRegistry mInstantAppRegistry;
    final InstantAppResolverConnection mInstantAppResolverConnection;
    final ComponentName mInstantAppResolverSettingsComponent;

    @Watched
    private final WatchedArrayMap<ComponentName, ParsedInstrumentation> mInstrumentation;
    private final SnapshotCache<WatchedArrayMap<ComponentName, ParsedInstrumentation>> mInstrumentationSnapshot;
    final boolean mIsEngBuild;
    private final boolean mIsPreNMR1Upgrade;
    private final boolean mIsPreQUpgrade;
    final boolean mIsUpgrade;
    private final boolean mIsUserDebugBuild;

    @Watched
    final WatchedSparseIntArray mIsolatedOwners;
    private final SnapshotCache<WatchedSparseIntArray> mIsolatedOwnersSnapshot;
    private final ArraySet<String> mKeepUninstalledPackages;
    final LegacyPermissionManagerInternal mLegacyPermissionManager;
    private ComputerLocked mLiveComputer;
    final PackageManagerTracedLock mLock;
    final DisplayMetrics mMetrics;
    private final ModuleInfoProvider mModuleInfoProvider;
    final MovePackageHelper.MoveCallbacks mMoveCallbacks;
    int mNextInstallToken;
    private final AtomicInteger mNextMoveId;
    private final Map<String, InstallRequest> mNoKillInstallObservers;
    private IObricPackageManagerService mObricExt;
    final String mOptionalVerifierPackage;
    private final OverlayConfig mOverlayConfig;
    final String mOverlayConfigSignaturePackage;
    private final PackageManagerTracedLock mOverlayPathsLock;
    final PackageDexOptimizer mPackageDexOptimizer;
    private final PackageManagerServiceMonitorEx mPackageManagerServiceMonitorEx;
    private final PackageManagerServiceSmtEx mPackageManagerServiceSmtEx;
    private final PackageMonitorCallbackHelper mPackageMonitorCallbackHelper;
    private final PackageObserverHelper mPackageObserverHelper;
    final PackageParser2.Callback mPackageParserCallback;
    private final PackageProperty mPackageProperty;
    private final PackageStateMutator mPackageStateMutator;
    private final PackageManagerTracedLock mPackageStateWriteLock;
    private final PackageUsage mPackageUsage;

    @Watched
    final WatchedArrayMap<String, AndroidPackage> mPackages;
    private final SnapshotCache<WatchedArrayMap<String, AndroidPackage>> mPackagesSnapshot;
    final PendingPackageBroadcasts mPendingBroadcasts;
    final SparseArray<VerifyingSession> mPendingEnableRollback;
    int mPendingEnableRollbackToken;
    private final Map<String, InstallRequest> mPendingKillInstallObservers;
    final SparseArray<PackageVerificationState> mPendingVerification;
    int mPendingVerificationToken;
    PerUidReadTimeouts[] mPerUidReadTimeoutsCache;
    final PermissionManagerServiceInternal mPermissionManager;
    private AndroidPackage mPlatformPackage;
    private String[] mPlatformPackageOverlayPaths;
    private String[] mPlatformPackageOverlayResourceDirs;
    private final PreferredActivityHelper mPreferredActivityHelper;
    private Future<?> mPrepareAppDataFuture;
    private final int mPriorSdkVersion;
    final ProcessLoggingHandler mProcessLoggingHandler;
    boolean mPromoteSystemApps;
    final ArraySet<String> mProtectedBroadcasts;
    final ProtectedPackages mProtectedPackages;
    final String mRecentsPackage;
    List<File> mReleaseOnSystemReady;
    private final RemovableSystemAppHelper mRemovableSystemAppHelper;
    private final RemovePackageHelper mRemovePackageHelper;
    private String[] mReplacedResolverPackageOverlayPaths;
    private String[] mReplacedResolverPackageOverlayResourceDirs;
    final String mRequiredInstallerPackage;
    final String mRequiredPermissionControllerPackage;
    private final String mRequiredSdkSandboxPackage;
    final String mRequiredUninstallerPackage;
    final String[] mRequiredVerifierPackages;

    @Watched(manual = true)
    private final ActivityInfo mResolveActivity;

    @Watched(manual = true)
    ComponentName mResolveComponentName;
    private final ResolveInfo mResolveInfo;
    private final ResolveIntentHelper mResolveIntentHelper;
    private boolean mResolverReplaced;
    final String mRetailDemoPackage;
    final SparseArray<InstallRequest> mRunningInstalls;

    @Watched(manual = true)
    private volatile boolean mSafeMode;
    private final int mSdkVersion;
    private final String[] mSeparateProcesses;
    private long mServiceStartWithDelay;
    final String mServicesExtensionPackageName;

    @Watched
    final Settings mSettings;
    final String mSetupWizardPackage;

    @Watched
    private final SharedLibrariesImpl mSharedLibraries;
    final String mSharedSystemSharedLibraryPackageName;
    final boolean mShouldStopSystemPackagesByDefault;
    private final Object mSnapshotLock;
    private final SnapshotStatistics mSnapshotStatistics;
    private final StorageEventHelper mStorageEventHelper;
    final String mStorageManagerPackage;
    private final SuspendPackageHelper mSuspendPackageHelper;

    @Watched(manual = true)
    volatile boolean mSystemReady;
    final String mSystemTextClassifierPackageName;
    private final TestUtilityService mTestUtilityService;
    final ArraySet<String> mTransferredPackages;
    final UserManagerService mUserManager;
    final UserNeedsBadgingCache mUserNeedsBadging;
    private final Watcher mWatcher;
    final String mWearableSensingPackage;

    @Watched
    private final WatchedSparseBooleanArray mWebInstantAppsDisabled;

    private static class DefaultSystemWrapper implements PackageManagerServiceInjector.SystemWrapper {
        /* synthetic */ DefaultSystemWrapper(PackageManagerServiceIA r1) {
            this();
        }

        private DefaultSystemWrapper() {
        }

        @Override // com.android.server.pm.PackageManagerServiceInjector.SystemWrapper
        public void disablePackageCaches() {
            PackageManager.disableApplicationInfoCache();
            PackageManager.disablePackageInfoCache();
            ApplicationPackageManager.invalidateGetPackagesForUidCache();
            ApplicationPackageManager.disableGetPackagesForUidCache();
            ApplicationPackageManager.invalidateHasSystemFeatureCache();
            PackageManager.corkPackageInfoCache();
        }

        @Override // com.android.server.pm.PackageManagerServiceInjector.SystemWrapper
        public void enablePackageCaches() {
            PackageManager.uncorkPackageInfoCache();
        }
    }

    static class FindPreferredActivityBodyResult {
        boolean mChanged;
        ResolveInfo mPreferredResolveInfo;

        FindPreferredActivityBodyResult() {
        }
    }

    public class IPackageManagerImpl extends IPackageManagerBase {
        final Object mDo6939CommandLock;
        final Object mGetAllFilesPathLock;
        final Object mUidCheck6939Lock;
        final /* synthetic */ PackageManagerService this$0;

        /* JADX INFO: renamed from: $r8$lambda$-WnwDDeInCym2X53IW0Td3Vy25Q, reason: not valid java name */
        public static /* synthetic */ void m6860$r8$lambda$WnwDDeInCym2X53IW0Td3Vy25Q(IPackageManagerImpl r0, String r1, int r2, int r3, int r4, IPackageDataObserver r5) {
            r0.lambda$deleteApplicationCacheFilesAsUser$1(r1, r2, r3, r4, r5);
        }

        /* JADX INFO: renamed from: $r8$lambda$107O-99MWAqaO6h5r6u1g7EngjI, reason: not valid java name */
        public static /* synthetic */ void m6861$r8$lambda$107O99MWAqaO6h5r6u1g7EngjI(IPackageManagerImpl r0, String r1, long r2, int r4, IPackageDataObserver r5) {
            r0.lambda$freeStorageAndNotify$4(r1, r2, r4, r5);
        }

        public static /* synthetic */ void $r8$lambda$1ThB1_MVixkgV9lRpo84oBSDvvY(int r0, CharSequence r1, PackageStateWrite r2) {
            lambda$setHarmfulAppWarning$12(r0, r1, r2);
        }

        public static /* synthetic */ void $r8$lambda$2NddH3htADh36HyI3YxBub1FK4o(IPackageManagerImpl r0, int r1, int r2, int r3) {
            r0.lambda$verifyPendingInstall$23(r1, r2, r3);
        }

        /* JADX INFO: renamed from: $r8$lambda$3qEint7AQ9Mzq6gVTIPNnWim-wc, reason: not valid java name */
        public static /* synthetic */ void m6862$r8$lambda$3qEint7AQ9Mzq6gVTIPNnWimwc(IDexModuleRegisterCallback r0, String r1, DexManager.RegisterDexModuleResult r2) {
            lambda$registerDexModule$7(r0, r1, r2);
        }

        public static /* synthetic */ void $r8$lambda$5HOMIWkD7FzApasIIZgs1M7NI4U(IPackageManagerImpl r0, String r1, long r2, int r4, IntentSender r5) {
            r0.lambda$freeStorage$3(r1, r2, r4, r5);
        }

        public static /* synthetic */ void $r8$lambda$5xPjBimifLxcG9GYgS9c4BAnyh8(int r0, PackageStateWrite r1) {
            lambda$setApplicationCategoryHint$8(r0, r1);
        }

        public static /* synthetic */ void $r8$lambda$CaZ04l8HtG7Y61tWA_YcGmrDnCU(IPackageManagerImpl r0, int r1, int r2, int r3, long r4) {
            r0.lambda$extendVerificationTimeout$2(r1, r2, r3, r4);
        }

        public static /* synthetic */ Boolean $r8$lambda$CqB8bxC4gDP0_fWNoqvGiZU5pnI(IPackageManagerImpl r0, int r1, String r2, int r3, String r4, Computer r5) {
            return r0.lambda$setInstallerPackageName$13(r1, r2, r3, r4, r5);
        }

        public static /* synthetic */ void $r8$lambda$IUC2njBA6F_S5cBzr2babfko2QQ(PackageStateWrite r0) {
            lambda$relinquishUpdateOwnership$16(r0);
        }

        /* JADX INFO: renamed from: $r8$lambda$K-IU-J3gey18tj9poi6l48dFgqk, reason: not valid java name */
        public static /* synthetic */ boolean m6863$r8$lambda$KIUJ3gey18tj9poi6l48dFgqk(Computer r0, int r1, int r2, String r3) {
            return lambda$queryProperty$6(r0, r1, r2, r3);
        }

        /* JADX INFO: renamed from: $r8$lambda$LkYZxaA-VNUTmLOD_icXu8eEv08, reason: not valid java name */
        public static /* synthetic */ void m6864$r8$lambda$LkYZxaAVNUTmLOD_icXu8eEv08(int r0, boolean r1, PackageStateWrite r2) {
            lambda$setApplicationHiddenSettingAsUser$11(r0, r1, r2);
        }

        /* JADX INFO: renamed from: $r8$lambda$Mcfwl54XiGnEHpRH3a7UDE6tg-M, reason: not valid java name */
        public static /* synthetic */ void m6865$r8$lambda$Mcfwl54XiGnEHpRH3a7UDE6tgM(IPackageManagerImpl r0, String r1, PackageStateInternal r2, int r3) {
            r0.lambda$setMimeGroup$18(r1, r2, r3);
        }

        public static /* synthetic */ void $r8$lambda$OCkFQ7taVAoQTB34utwzETeAwAw(IPackageDataObserver r0, String r1) {
            lambda$clearApplicationUserData$0(r0, r1);
        }

        /* JADX INFO: renamed from: $r8$lambda$Pe8vbhpdl0Jq5-S3wgyqrQj-wOQ, reason: not valid java name */
        public static /* synthetic */ void m6866$r8$lambda$Pe8vbhpdl0Jq5S3wgyqrQjwOQ(boolean r0, PackageStateWrite r1) {
            lambda$setUpdateAvailable$22(r0, r1);
        }

        public static /* synthetic */ void $r8$lambda$RsVa2mF45EoVYf3CpE8scb7kg4A(boolean r0, PackageStateWrite r1) {
            lambda$setRequiredForSystemUser$19(r0, r1);
        }

        public static /* synthetic */ void $r8$lambda$WLAVyYP3V__zIRx7NCQfUF8Jb4M(int r0, String r1, PackageStateWrite r2) {
            lambda$setSplashScreenTheme$21(r0, r1, r2);
        }

        public static /* synthetic */ void $r8$lambda$c2heQtlO6TofUAIsLSKx7u0f7_s(IPackageManagerImpl r0, String r1, String r2, int r3, int r4, UserHandle r5) {
            r0.lambda$movePackage$5(r1, r2, r3, r4, r5);
        }

        public static /* synthetic */ void $r8$lambda$dF4NNU2jLw1TkoeDVn3FmcWWLoY(String r0, ArraySet r1, PackageStateWrite r2) {
            lambda$setMimeGroup$17(r0, r1, r2);
        }

        public static /* synthetic */ void $r8$lambda$kCQ2BqcsdLUsUaXqxeER8T489SI(int r0, int r1, PackageStateWrite r2) {
            lambda$setUserMinAspectRatio$20(r0, r1, r2);
        }

        /* JADX INFO: renamed from: $r8$lambda$tIC3HLOKgh-Lj48Ibj4WTyOEG7U, reason: not valid java name */
        public static /* synthetic */ void m6867$r8$lambda$tIC3HLOKghLj48Ibj4WTyOEG7U(String r0, int r1, PackageStateWrite r2) {
            lambda$setInstallerPackageName$15(r0, r1, r2);
        }

        public static /* synthetic */ void $r8$lambda$uG5lRCL0U9tFlrQwzWyTBhTh6SE(int r0, PackageStateWrite r1) {
            lambda$setPageSizeAppCompatFlagsSettingsOverride$10(r0, r1);
        }

        public static /* synthetic */ void $r8$lambda$wiOPGFx4UPFnjd8jvuyQq_2aeAM(String r0, int r1, PackageStateWrite r2) {
            lambda$setInstallerPackageName$14(r0, r1, r2);
        }

        public static /* synthetic */ PackageStateMutator.Result $r8$lambda$zOtQV_eqmOwOvY2WrNe4NKLNCXY(IPackageManagerImpl r0, int r1, String r2, int r3, String r4, int r5, PackageStateMutator.InitialState r6, Computer r7) {
            return r0.lambda$setApplicationCategoryHint$9(r1, r2, r3, r4, r5, r6, r7);
        }

        public IPackageManagerSmtEx getISmtEx() {
            return PackageManagerService.m6828$$Nest$fgetmPackageManagerServiceSmtEx(this.this$0).getISmtEx();
        }

        public IPackageManagerImpl(PackageManagerService this$0) {
            this.this$0 = this$0;
            super(this$0, this$0.mContext, this$0.mDexOptHelper, PackageManagerService.m6825$$Nest$fgetmModuleInfoProvider(this$0), PackageManagerService.m6835$$Nest$fgetmPreferredActivityHelper(this$0), PackageManagerService.m6839$$Nest$fgetmResolveIntentHelper(this$0), this$0.mDomainVerificationManager, PackageManagerService.m6815$$Nest$fgetmDomainVerificationConnection(this$0), this$0.mInstallerService, PackageManagerService.m6831$$Nest$fgetmPackageProperty(this$0), this$0.mResolveComponentName, this$0.mInstantAppResolverSettingsComponent, this$0.mServicesExtensionPackageName, this$0.mSharedSystemSharedLibraryPackageName);
            this.mUidCheck6939Lock = new Object();
            this.mDo6939CommandLock = new Object();
            this.mGetAllFilesPathLock = new Object();
        }

        public void checkPackageStartable(String packageName, int userId) {
            this.this$0.checkPackageStartable(this.this$0.snapshotComputer(), packageName, userId);
        }

        public void clearApplicationProfileData(String packageName) {
            PackageManagerServiceUtils.enforceSystemOrRootOrShell("Only the system or shell can clear all profile data");
            Computer snapshot = this.this$0.snapshotComputer();
            AndroidPackage pkg = snapshot.getPackage(packageName);
            PackageFreezer ignored = this.this$0.freezePackage(packageName, -1, "clearApplicationProfileData", 13, null);
            PackageManagerTracedLock installLock = this.this$0.mInstallLock.acquireLock();     // Catch: Throwable -> L9
            this.this$0.mAppDataHelper.clearAppProfilesLIF(pkg);     // Catch: Throwable -> L14
            if (installLock == null) goto L11;
            installLock.close();     // Catch: Throwable -> L9
        L11:
            if (ignored == null) goto L36;
            ignored.close();
            return;
        L36:
            return;
        L14:
            th = move-exception;
            if (installLock == null) goto L37;
            installLock.close();     // Catch: Throwable -> L19
        L38:
            throw th;     // Catch: Throwable -> L9
        L19:
            th = move-exception;
            th.addSuppressed(th);     // Catch: Throwable -> L9
            throw th;     // Catch: Throwable -> L9
        L37:
            throw th;     // Catch: Throwable -> L9
        L9:
            th = move-exception;
            if (ignored == null) goto L39;
            ignored.close();     // Catch: Throwable -> L26
            throw th;
        L26:
            th = move-exception;
            th.addSuppressed(th);
            throw th;
        L39:
            throw th;
        }

        public void clearApplicationUserData(final String packageName, final IPackageDataObserver observer, final int userId, final boolean restorePregrantedPermissions) {
            clearApplicationUserData_enforcePermission();
            final int callingUid = Binder.getCallingUid();
            Computer snapshot = this.this$0.snapshotComputer();
            snapshot.enforceCrossUserPermission(callingUid, userId, true, false, "clear application data");
            if (snapshot.getPackageStateForInstalledAndFiltered(packageName, callingUid, userId) != null) goto L8;
            if (observer == null) goto L13;
            this.this$0.mHandler.post(new PackageManagerService$IPackageManagerImpl$$ExternalSyntheticLambda12(observer, packageName));
            return;
        L13:
            return;
        L8:
            if (this.this$0.mProtectedPackages.isPackageDataProtected(userId, packageName) == true) goto L12;
            int callingPid = Binder.getCallingPid();
            EventLog.writeEvent(EventLogTags.PM_CLEAR_APP_DATA_CALLER, new Object[]{Integer.valueOf(callingPid), Integer.valueOf(callingUid), packageName});
            this.this$0.mHandler.post(new AnonymousClass1(this, packageName, userId, restorePregrantedPermissions, callingUid, observer));
            return;
        L12:
            throw new SecurityException("Cannot clear data for a protected package: " + packageName);
        }

        private static /* synthetic */ void lambda$clearApplicationUserData$0(IPackageDataObserver observer, String packageName) {
            observer.onRemoveCompleted(packageName, false);     // Catch: RemoteException -> L5
            return;
        L6:
            Log.i("PackageManager", "Observer no longer exists.");
        }

        public void clearCrossProfileIntentFilters(int sourceUserId, String ownerPackage) {
            clearCrossProfileIntentFilters_enforcePermission();
            int callingUid = Binder.getCallingUid();
            Computer snapshot = this.this$0.snapshotComputer();
            PackageManagerService.m6851$$Nest$menforceOwnerRights(this.this$0, snapshot, ownerPackage, callingUid);
            PackageManagerServiceUtils.enforceShellRestriction(this.this$0.mInjector.getUserManagerInternal(), "no_debugging_features", callingUid, sourceUserId);
            this.this$0.mInjector.getCrossProfileIntentFilterHelper().clearCrossProfileIntentFilters(sourceUserId, ownerPackage, null);
            this.this$0.scheduleWritePackageRestrictions(sourceUserId);
        }

        public boolean removeCrossProfileIntentFilter(IntentFilter intentFilter, String ownerPackage, int sourceUserId, int targetUserId, int flags) {
            removeCrossProfileIntentFilter_enforcePermission();
            int callingUid = Binder.getCallingUid();
            PackageManagerService.m6851$$Nest$menforceOwnerRights(this.this$0, this.this$0.snapshotComputer(), ownerPackage, callingUid);
            this.this$0.mUserManager.enforceCrossProfileIntentFilterAccess(sourceUserId, targetUserId, callingUid, false);
            PackageManagerServiceUtils.enforceShellRestriction(this.this$0.mInjector.getUserManagerInternal(), "no_debugging_features", callingUid, sourceUserId);
            boolean removedMatchingFilter = false;
            PackageManagerTracedLock r2 = this.this$0.mLock;
            PackageManagerService.boostPriorityForPackageManagerTracedLockedSection();
            monitor-enter(r2);
            CrossProfileIntentResolver resolver = this.this$0.mSettings.editCrossProfileIntentResolverLPw(sourceUserId);     // Catch: Throwable -> L16
            ArraySet<CrossProfileIntentFilter> set = new ArraySet(resolver.filterSet());     // Catch: Throwable -> L16
            int i = 0;
        L6:
            if (i >= set.size()) goto L19;
            CrossProfileIntentFilter filter = set.valueAt(i);     // Catch: Throwable -> L16
            if (IntentFilter.filterEquals(filter.mFilter, intentFilter) == false) goto L18;
            if (filter.getOwnerPackage().equals(ownerPackage) == false) goto L18;
            if (filter.getTargetUserId() != targetUserId) goto L18;
            if (filter.getFlags() != flags) goto L18;
            resolver.removeFilter(filter);     // Catch: Throwable -> L16
            removedMatchingFilter = true;
        L18:
            i = i + 1;     // Catch: Throwable -> L16
        L19:
            monitor-exit(r2);     // Catch: Throwable -> L16
            PackageManagerService.resetPriorityAfterPackageManagerTracedLockedSection();
            if (removedMatchingFilter == false) goto L23;
            this.this$0.scheduleWritePackageRestrictions(sourceUserId);
        L23:
            return removedMatchingFilter;
        L16:
            th = move-exception;
            PackageManagerService.resetPriorityAfterPackageManagerTracedLockedSection();
            throw th;
        }

        public final void deleteApplicationCacheFiles(String packageName, IPackageDataObserver observer) {
            int userId = UserHandle.getCallingUserId();
            deleteApplicationCacheFilesAsUser(packageName, userId, observer);
        }

        public void deleteApplicationCacheFilesAsUser(final String packageName, final int userId, final IPackageDataObserver observer) {
            final int callingUid = Binder.getCallingUid();
            if (this.this$0.mContext.checkCallingOrSelfPermission("android.permission.INTERNAL_DELETE_CACHE_FILES") != 0) goto L5;
        L9:
            Computer snapshot = this.this$0.snapshotComputer();
            snapshot.enforceCrossUserPermission(callingUid, userId, true, false, "delete application cache files");
            final int hasAccessInstantApps = this.this$0.mContext.checkCallingOrSelfPermission("android.permission.ACCESS_INSTANT_APPS");
            int callingPid = Binder.getCallingPid();
            EventLog.writeEvent(EventLogTags.PM_CLEAR_APP_DATA_CALLER, new Object[]{Integer.valueOf(callingPid), Integer.valueOf(callingUid), packageName});
            this.this$0.mHandler.post(new PackageManagerService$IPackageManagerImpl$$ExternalSyntheticLambda20(this, packageName, callingUid, hasAccessInstantApps, userId, observer));
            return;
        L5:
            if (this.this$0.mContext.checkCallingOrSelfPermission("android.permission.DELETE_CACHE_FILES") != 0) goto L8;
            Slog.w("PackageManager", "Calling uid " + callingUid + " does not have android.permission.INTERNAL_DELETE_CACHE_FILES, silently ignoring");
            return;
        L8:
            this.this$0.mContext.enforceCallingOrSelfPermission("android.permission.INTERNAL_DELETE_CACHE_FILES", null);
            goto L9
        }

        private /* synthetic */ void lambda$deleteApplicationCacheFilesAsUser$1(String packageName, int callingUid, int hasAccessInstantApps, int userId, IPackageDataObserver observer) {
            Computer newSnapshot = this.this$0.snapshotComputer();
            PackageStateInternal ps = newSnapshot.getPackageStateInternal(packageName);
            boolean doClearData = true;
            if (ps == null) goto L11;
            boolean targetIsInstantApp = ps.getUserStateOrDefault(UserHandle.getUserId(callingUid)).isInstantApp();
            if (targetIsInstantApp == false) goto L9;
            if (hasAccessInstantApps == 0) goto L9;
            boolean r5 = false;
        L10:
            doClearData = r5;
        L9:
            r5 = true;
        L11:
            if (doClearData == false) goto L23;
            PackageManagerTracedLock installLock = this.this$0.mInstallLock.acquireLock();
            AndroidPackage pkg = this.this$0.snapshotComputer().getPackage(packageName);     // Catch: Throwable -> L16
            this.this$0.mAppDataHelper.clearAppDataLIF(pkg, userId, 23);     // Catch: Throwable -> L16
            this.this$0.mAppDataHelper.clearAppDataLIF(pkg, userId, 39);     // Catch: Throwable -> L16
            if (installLock == null) goto L23;
            installLock.close();
        L16:
            th = move-exception;
            if (installLock != null) goto L33;
        L22:
            throw th;
        L33:
            installLock.close();     // Catch: Throwable -> L20
        L20:
            th = move-exception;
            th.addSuppressed(th);
        L23:
            if (observer == null) goto L35;
            observer.onRemoveCompleted(packageName, true);     // Catch: RemoteException -> L26
            return;
        L27:
            Log.i("PackageManager", "Observer no longer exists.");
            return;
        }

        public void enterSafeMode() {
            PackageManagerServiceUtils.enforceSystemOrRoot("Only the system can request entering safe mode");
            if (this.this$0.mSystemReady == true) goto L6;
            PackageManagerService.m6846$$Nest$fputmSafeMode(this.this$0, true);
            return;
        }

        public void extendVerificationTimeout(final int verificationId, final int verificationCodeAtTimeout, final long millisecondsToDelay) {
            if (verificationId < 0) goto L4;
            this.this$0.mContext.enforceCallingOrSelfPermission("android.permission.PACKAGE_VERIFICATION_AGENT", "Only package verification agents can extend verification timeouts");
        L4:
            final int callingUid = Binder.getCallingUid();
            this.this$0.mHandler.post(new PackageManagerService$IPackageManagerImpl$$ExternalSyntheticLambda15(this, verificationId, callingUid, verificationCodeAtTimeout, millisecondsToDelay));
        }

        private /* synthetic */ void lambda$extendVerificationTimeout$2(int verificationId, int callingUid, int verificationCodeAtTimeout, long millisecondsToDelay) {
            if (verificationId < 0) goto L4;
            int id = verificationId;
        L5:
            PackageVerificationState state = this.this$0.mPendingVerification.get(id);
            if (state != null) goto L8;
            return;
        L8:
            if (state.extendTimeout(callingUid) == false) goto L19;
            PackageVerificationResponse response = new PackageVerificationResponse(verificationCodeAtTimeout, callingUid);
            long delay = millisecondsToDelay;
            if (delay <= 3600000) goto L14;
            delay = 3600000;
        L14:
            if (delay >= 0) goto L16;
            delay = 0;
        L16:
            Message msg = this.this$0.mHandler.obtainMessage(15);
            msg.arg1 = id;
            msg.obj = response;
            this.this$0.mHandler.sendMessageDelayed(msg, delay);
            return;
        L19:
            return;
        L4:
            id = -verificationId;
            goto L5
        }

        public void flushPackageRestrictionsAsUser(int userId) {
            Computer snapshot = this.this$0.snapshotComputer();
            int callingUid = Binder.getCallingUid();
            if (snapshot.getInstantAppPackageName(callingUid) == null) goto L6;
            return;
        L6:
            if (this.this$0.mUserManager.exists(userId) == true) goto L8;
            return;
        L8:
            snapshot.enforceCrossUserPermission(callingUid, userId, false, false, "flushPackageRestrictions");
            PackageManagerTracedLock r8 = this.this$0.mLock;
            PackageManagerService.boostPriorityForPackageManagerTracedLockedSection();
            monitor-enter(r8);
            PackageManagerService.m6852$$Nest$mflushPackageRestrictionsAsUserInternalLocked(this.this$0, userId);     // Catch: Throwable -> L14
            monitor-exit(r8);     // Catch: Throwable -> L14
            PackageManagerService.resetPriorityAfterPackageManagerTracedLockedSection();
            return;
        L14:
            th = move-exception;
            PackageManagerService.resetPriorityAfterPackageManagerTracedLockedSection();
            throw th;
        }

        public void freeStorage(final String volumeUuid, final long freeStorageSize, final int flags, final IntentSender pi) {
            freeStorage_enforcePermission();
            this.this$0.mHandler.post(new PackageManagerService$IPackageManagerImpl$$ExternalSyntheticLambda21(this, volumeUuid, freeStorageSize, flags, pi));
        }

        private /* synthetic */ void lambda$freeStorage$3(String volumeUuid, long freeStorageSize, int flags, IntentSender pi) {
            boolean success = false;
            this.this$0.freeStorage(volumeUuid, freeStorageSize, flags);     // Catch: IOException -> L7
            success = true;
        L12:
            if (pi == null) goto L27;
            BroadcastOptions options = BroadcastOptions.makeBasic();     // Catch: IntentSender.SendIntentException -> L18
            int r8 = 0;
            options.setPendingIntentBackgroundActivityLaunchAllowed(false);     // Catch: IntentSender.SendIntentException -> L18
            if (success == false) goto L16;
            r8 = 1;
        L16:
            pi.sendIntent(null, r8, null, null, options.toBundle(), null, null);     // Catch: IntentSender.SendIntentException -> L18
            return;
        L18:
            e = move-exception;
            Slog.w("PackageManager", e);
            return;
        L27:
            return;
        L7:
            e = e;
        L11:
            Slog.w("PackageManager", e);
        L9:
            e = e;
            goto L11
        }

        public void freeStorageAndNotify(final String volumeUuid, final long freeStorageSize, final int flags, final IPackageDataObserver observer) {
            freeStorageAndNotify_enforcePermission();
            this.this$0.mHandler.post(new PackageManagerService$IPackageManagerImpl$$ExternalSyntheticLambda11(this, volumeUuid, freeStorageSize, flags, observer));
        }

        private /* synthetic */ void lambda$freeStorageAndNotify$4(String volumeUuid, long freeStorageSize, int flags, IPackageDataObserver observer) {
            boolean success = false;
            this.this$0.freeStorage(volumeUuid, freeStorageSize, flags);     // Catch: IOException -> L5
            success = true;
        L7:
            if (observer != null) goto L16;
            return;
        L16:
            observer.onRemoveCompleted(null, success);     // Catch: RemoteException -> L11
            return;
        L11:
            e = move-exception;
            Slog.w("PackageManager", e);
            return;
        L5:
            e = move-exception;
            Slog.w("PackageManager", e);
            goto L7
        }

        public ChangedPackages getChangedPackages(int sequenceNumber, int userId) {
            int callingUid = Binder.getCallingUid();
            Computer snapshot = this.this$0.snapshotComputer();
            if (snapshot.getInstantAppPackageName(callingUid) == null) goto L6;
            return null;
        L6:
            if (this.this$0.mUserManager.exists(userId) == true) goto L8;
            return null;
        L8:
            snapshot.enforceCrossUserPermission(callingUid, userId, false, false, "getChangedPackages");
            ChangedPackages changedPackages = this.this$0.mChangedPackagesTracker.getChangedPackages(sequenceNumber, userId);
            if (changedPackages == null) goto L16;
            List<String> packageNames = changedPackages.getPackageNames();
            int index = packageNames.size() - 1;
        L11:
            if (index < 0) goto L16;
            PackageStateInternal packageState = snapshot.getPackageStateInternal(packageNames.get(index));
            if (snapshot.shouldFilterApplication(packageState, callingUid, userId) == false) goto L15;
            packageNames.remove(index);
        L15:
            index = index - 1;
        L16:
            return changedPackages;
        }

        public byte[] getDomainVerificationBackup(int userId) {
            if (Binder.getCallingUid() != 1000) goto L19;
            ByteArrayOutputStream output = new ByteArrayOutputStream();     // Catch: Exception -> L8
            TypedXmlSerializer serializer = Xml.resolveSerializer(output);     // Catch: Throwable -> L10
            this.this$0.mDomainVerificationManager.writeSettings(this.this$0.snapshotComputer(), serializer, true, userId);     // Catch: Throwable -> L10
            byte[] r2 = output.toByteArray();     // Catch: Throwable -> L10
            output.close();     // Catch: Exception -> L8
            return r2;
        L10:
            th = move-exception;
            output.close();     // Catch: Throwable -> L13
        L15:
            throw th;     // Catch: Exception -> L8
        L13:
            th = move-exception;
            th.addSuppressed(th);     // Catch: Exception -> L8
        L16:
            return null;
        L19:
            throw new SecurityException("Only the system may call getDomainVerificationBackup()");
        }

        /* JADX WARN: Multi-variable type inference failed */
        public IBinder getHoldLockToken() {
            if (Build.IS_DEBUGGABLE == false) goto L7;
            this.this$0.mContext.enforceCallingPermission("android.permission.INJECT_EVENTS", "getHoldLockToken requires INJECT_EVENTS permission");
            Binder token = new Binder();
            token.attachInterface(this, "holdLock:" + Binder.getCallingUid());
            return token;
        L7:
            throw new SecurityException("getHoldLockToken requires a debuggable build");
        }

        public String getInstantAppAndroidId(String packageName, int userId) {
            getInstantAppAndroidId_enforcePermission();
            Computer snapshot = this.this$0.snapshotComputer();
            snapshot.enforceCrossUserPermission(Binder.getCallingUid(), userId, true, false, "getInstantAppAndroidId");
            if (snapshot.isInstantApp(packageName, userId) == true) goto L7;
            return null;
        L7:
            return this.this$0.mInstantAppRegistry.getInstantAppAndroidId(packageName, userId);
        }

        public byte[] getInstantAppCookie(String packageName, int userId) {
            Computer snapshot = this.this$0.snapshotComputer();
            snapshot.enforceCrossUserPermission(Binder.getCallingUid(), userId, true, false, "getInstantAppCookie");
            if (snapshot.isCallerSameApp(packageName, Binder.getCallingUid()) == true) goto L5;
            return null;
        L5:
            PackageStateInternal packageState = snapshot.getPackageStateInternal(packageName);
            if (packageState != null) goto L8;
        L12:
            return null;
        L8:
            if (packageState.getPkg() == null) goto L12;
            return this.this$0.mInstantAppRegistry.getInstantAppCookie(packageState.getPkg(), userId);
        }

        public Bitmap getInstantAppIcon(String packageName, int userId) {
            Computer snapshot = this.this$0.snapshotComputer();
            if (snapshot.canViewInstantApps(Binder.getCallingUid(), userId) == true) goto L5;
            this.this$0.mContext.enforceCallingOrSelfPermission("android.permission.ACCESS_INSTANT_APPS", "getInstantAppIcon");
        L5:
            snapshot.enforceCrossUserPermission(Binder.getCallingUid(), userId, true, false, "getInstantAppIcon");
            return this.this$0.mInstantAppRegistry.getInstantAppIcon(packageName, userId);
        }

        public ParceledListSlice<InstantAppInfo> getInstantApps(int userId) {
            Computer snapshot = this.this$0.snapshotComputer();
            if (snapshot.canViewInstantApps(Binder.getCallingUid(), userId) == true) goto L5;
            this.this$0.mContext.enforceCallingOrSelfPermission("android.permission.ACCESS_INSTANT_APPS", "getEphemeralApplications");
        L5:
            snapshot.enforceCrossUserPermission(Binder.getCallingUid(), userId, true, false, "getEphemeralApplications");
            List<InstantAppInfo> instantApps = this.this$0.mInstantAppRegistry.getInstantApps(snapshot, userId);
            if (instantApps != null) goto L8;
            return null;
        L8:
            return new ParceledListSlice(instantApps);
        }

        public ResolveInfo getLastChosenActivity(Intent intent, String resolvedType, int flags) {
            return PackageManagerService.m6835$$Nest$fgetmPreferredActivityHelper(this.this$0).getLastChosenActivity(this.this$0.snapshotComputer(), intent, resolvedType, flags);
        }

        public IntentSender getLaunchIntentSenderForPackage(String packageName, String callingPackage, String featureId, int userId) throws RemoteException {
            return PackageManagerService.m6839$$Nest$fgetmResolveIntentHelper(this.this$0).getLaunchIntentSenderForPackage(this.this$0.snapshotComputer(), packageName, callingPackage, featureId, userId);
        }

        public List<String> getMimeGroup(String packageName, String mimeGroup) {
            Computer snapshot = this.this$0.snapshotComputer();
            PackageManagerService.m6851$$Nest$menforceOwnerRights(this.this$0, snapshot, packageName, Binder.getCallingUid());
            return this.this$0.getMimeGroupInternal(snapshot, packageName, mimeGroup);
        }

        public int getMoveStatus(int moveId) {
            getMoveStatus_enforcePermission();
            return this.this$0.mMoveCallbacks.mLastStatus.get(moveId);
        }

        public ParcelFileDescriptor getAppMetadataFd(String packageName, int userId) {
            getAppMetadataFd_enforcePermission();
            int callingUid = Binder.getCallingUid();
            Computer snapshot = this.this$0.snapshotComputer();
            PackageStateInternal ps = snapshot.getPackageStateForInstalledAndFiltered(packageName, callingUid, userId);
            if (ps == null) goto L13;
            String filePath = ps.getAppMetadataFilePath();
            if (filePath != null) goto L7;
            return null;
        L7:
            File file = new File(filePath);
            return ParcelFileDescriptor.open(file, 268435456);
        L11:
            return null;
        L13:
            throw new ParcelableException(new PackageManager.NameNotFoundException(packageName));
        }

        public int getAppMetadataSource(String packageName, int userId) {
            getAppMetadataSource_enforcePermission();
            int callingUid = Binder.getCallingUid();
            Computer snapshot = this.this$0.snapshotComputer();
            PackageStateInternal ps = snapshot.getPackageStateForInstalledAndFiltered(packageName, callingUid, userId);
            if (ps == null) goto L7;
            return ps.getAppMetadataSource();
        L7:
            throw new ParcelableException(new PackageManager.NameNotFoundException(packageName));
        }

        public String getPermissionControllerPackageName() {
            int callingUid = Binder.getCallingUid();
            int callingUserId = UserHandle.getUserId(callingUid);
            Computer snapshot = this.this$0.snapshotComputer();
            if (snapshot.getPackageStateForInstalledAndFiltered(this.this$0.mRequiredPermissionControllerPackage, callingUid, callingUserId) == null) goto L7;
            return this.this$0.mRequiredPermissionControllerPackage;
        L7:
            throw new IllegalStateException("PermissionController is not found");
        }

        public int getRuntimePermissionsVersion(int userId) {
            Preconditions.checkArgumentNonnegative(userId);
            PackageManagerService.m6848x2d683684(this.this$0, "getRuntimePermissionVersion");
            return this.this$0.mSettings.getDefaultRuntimePermissionsVersion(userId);
        }

        public String getSplashScreenTheme(String packageName, int userId) {
            Computer snapshot = this.this$0.snapshotComputer();
            int callingUid = Binder.getCallingUid();
            snapshot.enforceCrossUserPermission(callingUid, userId, false, false, "getSplashScreenTheme");
            PackageStateInternal packageState = snapshot.getPackageStateForInstalledAndFiltered(packageName, callingUid, userId);
            if (packageState != null) goto L6;
            return null;
        L6:
            return packageState.getUserStateOrDefault(userId).getSplashScreenTheme();
        }

        public int getUserMinAspectRatio(String packageName, int userId) {
            Computer snapshot = this.this$0.snapshotComputer();
            int callingUid = Binder.getCallingUid();
            PackageStateInternal packageState = snapshot.getPackageStateForInstalledAndFiltered(packageName, callingUid, userId);
            if (packageState != null) goto L6;
            return 0;
        L6:
            return packageState.getUserStateOrDefault(userId).getMinAspectRatio();
        }

        public Bundle getSuspendedPackageAppExtras(String packageName, int userId) {
            int callingUid = Binder.getCallingUid();
            Computer snapshot = snapshot();
            if (snapshot.getPackageUid(packageName, 0, userId) != callingUid) goto L7;
            return SuspendPackageHelper.getSuspendedPackageAppExtras(snapshot, packageName, userId, callingUid);
        L7:
            throw new SecurityException("Calling package " + packageName + " does not belong to calling uid " + callingUid);
        }

        public String getSuspendingPackage(String packageName, int userId) {
            int callingUid = Binder.getCallingUid();     // Catch: PackageManager.NameNotFoundException -> L10
            Computer snapshot = snapshot();     // Catch: PackageManager.NameNotFoundException -> L10
            if (snapshot.isPackageSuspendedForUser(packageName, userId) == true) goto L6;
            return null;
        L6:
            UserPackage suspender = PackageManagerService.m6843$$Nest$fgetmSuspendPackageHelper(this.this$0).getSuspendingPackage(snapshot, packageName, userId, callingUid);     // Catch: PackageManager.NameNotFoundException -> L10
            if (suspender == null) goto L12;
            return suspender.packageName;
        L12:
            return null;
        L14:
            return null;
        }

        public ParceledListSlice<FeatureInfo> getSystemAvailableFeatures() {
            ArrayList<FeatureInfo> res = new ArrayList(PackageManagerService.m6811$$Nest$fgetmAvailableFeatures(this.this$0).size() + 1);
            res.addAll(PackageManagerService.m6811$$Nest$fgetmAvailableFeatures(this.this$0).values());
            FeatureInfo fi = new FeatureInfo();
            fi.reqGlEsVersion = SystemProperties.getInt("ro.opengles.version", 0);
            res.add(fi);
            return new ParceledListSlice(res);
        }

        public List<String> getInitialNonStoppedSystemPackages() {
            if (this.this$0.mInitialNonStoppedSystemPackages == null) goto L6;
            return new ArrayList(this.this$0.mInitialNonStoppedSystemPackages);
        L6:
            return new ArrayList();
        }

        public String[] getUnsuspendablePackagesForUser(String[] packageNames, int userId) {
            packageNames.getClass();
            this.this$0.mContext.enforceCallingOrSelfPermission("android.permission.SUSPEND_APPS", "getUnsuspendablePackagesForUser");
            int callingUid = Binder.getCallingUid();
            if (UserHandle.getUserId(callingUid) == userId) goto L6;
            this.this$0.mContext.enforceCallingOrSelfPermission("android.permission.INTERACT_ACROSS_USERS_FULL", "Calling uid " + callingUid + " cannot query getUnsuspendablePackagesForUser for user " + userId);
        L6:
            return PackageManagerService.m6843$$Nest$fgetmSuspendPackageHelper(this.this$0).getUnsuspendablePackagesForUser(this.this$0.snapshotComputer(), packageNames, userId, callingUid);
        }

        public VerifierDeviceIdentity getVerifierDeviceIdentity() throws RemoteException {
            getVerifierDeviceIdentity_enforcePermission();
            PackageManagerTracedLock r0 = this.this$0.mLock;
            PackageManagerService.boostPriorityForPackageManagerTracedLockedSection();
            monitor-enter(r0);
            VerifierDeviceIdentity r1 = this.this$0.mSettings.getVerifierDeviceIdentityLPw(PackageManagerService.m6824$$Nest$fgetmLiveComputer(this.this$0));     // Catch: Throwable -> L8
            monitor-exit(r0);     // Catch: Throwable -> L8
            PackageManagerService.resetPriorityAfterPackageManagerTracedLockedSection();
            return r1;
        L8:
            th = move-exception;
            PackageManagerService.resetPriorityAfterPackageManagerTracedLockedSection();
            throw th;
        }

        public void makeProviderVisible(int recipientUid, String visibleAuthority) {
            Computer snapshot = this.this$0.snapshotComputer();
            int recipientUserId = UserHandle.getUserId(recipientUid);
            ProviderInfo providerInfo = snapshot.getGrantImplicitAccessProviderInfo(recipientUid, visibleAuthority);
            if (providerInfo != null) goto L5;
            return;
        L5:
            int visibleUid = providerInfo.applicationInfo.uid;
            this.this$0.grantImplicitAccess(snapshot, recipientUserId, null, UserHandle.getAppId(recipientUid), visibleUid, false, false);
        }

        public void makeUidVisible(int recipientUid, int visibleUid) {
            makeUidVisible_enforcePermission();
            int callingUid = Binder.getCallingUid();
            int recipientUserId = UserHandle.getUserId(recipientUid);
            int visibleUserId = UserHandle.getUserId(visibleUid);
            Computer snapshot = this.this$0.snapshotComputer();
            snapshot.enforceCrossUserPermission(callingUid, recipientUserId, false, false, "makeUidVisible");
            snapshot.enforceCrossUserPermission(callingUid, visibleUserId, false, false, "makeUidVisible");
            snapshot.enforceCrossUserPermission(recipientUid, visibleUserId, false, false, "makeUidVisible");
            this.this$0.grantImplicitAccess(snapshot, recipientUserId, null, UserHandle.getAppId(recipientUid), visibleUid, false, false);
        }

        public void holdLock(IBinder token, int durationMs) {
            PackageManagerService.m6844$$Nest$fgetmTestUtilityService(this.this$0).verifyHoldLockToken(token);
            PackageManagerTracedLock r0 = this.this$0.mLock;
            PackageManagerService.boostPriorityForPackageManagerTracedLockedSection();
            monitor-enter(r0);
            SystemClock.sleep(durationMs);     // Catch: Throwable -> L9
            monitor-exit(r0);     // Catch: Throwable -> L9
            PackageManagerService.resetPriorityAfterPackageManagerTracedLockedSection();
            return;
        L9:
            th = move-exception;
            PackageManagerService.resetPriorityAfterPackageManagerTracedLockedSection();
            throw th;
        }

        public int installExistingPackageAsUser(String packageName, int userId, int installFlags, int installReason, List<String> whiteListedPermissions) {
            return ((Integer) PackageManagerService.m6819$$Nest$fgetmInstallPackageHelper(this.this$0).installExistingPackageAsUser(packageName, userId, installFlags, installReason, whiteListedPermissions, null).first).intValue();
        }

        public boolean isAutoRevokeWhitelisted(String packageName) {
            int mode = ((AppOpsManager) this.this$0.mInjector.getSystemService(AppOpsManager.class)).checkOpNoThrow(97, Binder.getCallingUid(), packageName);
            if (mode == 1) goto L7;
            return false;
        L7:
            return true;
        }

        public boolean isPackageStateProtected(String packageName, int userId) {
            int callingUid = Binder.getCallingUid();
            int callingAppId = UserHandle.getAppId(callingUid);
            Computer snapshot = this.this$0.snapshotComputer();
            snapshot.enforceCrossUserPermission(callingUid, userId, false, true, "isPackageStateProtected");
            if (PackageManagerServiceUtils.isSystemOrRoot(callingAppId) == true) goto L10;
            if (snapshot.checkUidPermission("android.permission.MANAGE_DEVICE_ADMINS", callingUid) == 0) goto L10;
            throw new SecurityException("Caller must have the android.permission.MANAGE_DEVICE_ADMINS permission.");
        L10:
            return this.this$0.mProtectedPackages.isPackageStateProtected(userId, packageName);
        }

        public boolean isProtectedBroadcast(String actionName) {
            if (actionName != null) goto L4;
        L13:
            ArraySet<String> r0 = this.this$0.mProtectedBroadcasts;
            monitor-enter(r0);
            boolean r1 = this.this$0.mProtectedBroadcasts.contains(actionName);     // Catch: Throwable -> L18
            monitor-exit(r0);     // Catch: Throwable -> L18
            return r1;
        L18:
            th = move-exception;
            throw th;
        L4:
            if (actionName.startsWith("android.net.netmon.lingerExpired") == false) goto L6;
            return true;
        L6:
            if (actionName.startsWith("com.android.server.sip.SipWakeupTimer") == false) goto L8;
            return true;
        L8:
            if (actionName.startsWith("com.android.internal.telephony.data-reconnect") == false) goto L10;
            return true;
        L10:
            if (actionName.startsWith("android.net.netmon.launchCaptivePortalApp") == false) goto L13;
            return true;
        }

        public void logAppProcessStartIfNeeded(String packageName, String processName, int uid, String seinfo, String apkFile, int pid) {
            Computer snapshot = this.this$0.snapshotComputer();
            if (snapshot.getInstantAppPackageName(Binder.getCallingUid()) == null) goto L6;
            return;
        L6:
            if (SecurityLog.isLoggingEnabled() == true) goto L8;
            return;
        L8:
            this.this$0.mProcessLoggingHandler.logAppProcessStart(this.this$0.mContext, (PackageManagerInternal) LocalServices.getService(PackageManagerInternal.class), apkFile, packageName, processName, uid, seinfo, pid);
        }

        public int movePackage(final String packageName, final String volumeUuid) {
            movePackage_enforcePermission();
            final int callingUid = Binder.getCallingUid();
            final UserHandle user = new UserHandle(UserHandle.getUserId(callingUid));
            final int moveId = PackageManagerService.m6826$$Nest$fgetmNextMoveId(this.this$0).getAndIncrement();
            this.this$0.mHandler.post(new PackageManagerService$IPackageManagerImpl$$ExternalSyntheticLambda6(this, packageName, volumeUuid, moveId, callingUid, user));
            return moveId;
        }

        private /* synthetic */ void lambda$movePackage$5(String packageName, String volumeUuid, int moveId, int callingUid, UserHandle user) {
            MovePackageHelper movePackageHelper = new MovePackageHelper(this.this$0);     // Catch: PackageManagerException -> L8
            String packageName2 = packageName;
            int moveId2 = moveId;
            movePackageHelper.movePackageInternal(packageName2, volumeUuid, moveId2, callingUid, user);     // Catch: PackageManagerException -> L6
            return;
        L6:
            e = move-exception;
            PackageManagerException e = e;
        L10:
            Slog.w("PackageManager", "Failed to move " + packageName2, e);
            this.this$0.mMoveCallbacks.notifyStatusChanged(moveId2, e.error);
            return;
        L8:
            e = move-exception;
            packageName2 = packageName;
            moveId2 = moveId;
            e = e;
            goto L10
        }

        public int movePrimaryStorage(String volumeUuid) throws RemoteException {
            movePrimaryStorage_enforcePermission();
            final int realMoveId = PackageManagerService.m6826$$Nest$fgetmNextMoveId(this.this$0).getAndIncrement();
            Bundle extras = new Bundle();
            extras.putString("android.os.storage.extra.FS_UUID", volumeUuid);
            this.this$0.mMoveCallbacks.notifyCreated(realMoveId, extras);
            IPackageMoveObserver callback = new AnonymousClass2(this, realMoveId);
            StorageManager storage = (StorageManager) this.this$0.mInjector.getSystemService(StorageManager.class);
            storage.setPrimaryStorageUuid(volumeUuid, callback);
            return realMoveId;
        }

        public void notifyDexLoad(String loadingPackageName, Map<String, String> classLoaderContextMap, String loaderIsa) {
            int callingUid = Binder.getCallingUid();
            Computer snapshot = snapshot();
            if (PackageManagerServiceUtils.isSystemOrRoot() == false) goto L5;
        L8:
            UserHandle user = Binder.getCallingUserHandle();
            int userId = user.getIdentifier();
            DexUseManagerLocal dexUseManager = DexOptHelper.getDexUseManagerLocal();
            if (dexUseManager == null) goto L34;
            PackageManagerLocal.FilteredSnapshot filteredSnapshot = ((PackageManagerLocal) LocalManagerRegistry.getManager(PackageManagerLocal.class)).withFilteredSnapshot(callingUid, user);
            if (loaderIsa != null) goto L40;
        L24:
            dexUseManager.notifyDexContainersLoaded(filteredSnapshot, loadingPackageName, classLoaderContextMap);     // Catch: Throwable -> L17
            if (filteredSnapshot == null) goto L45;
            filteredSnapshot.close();
        L45:
            return;
        L40:
            PackageState loadingPkgState = filteredSnapshot.getPackageState(loadingPackageName);     // Catch: Throwable -> L17
            if (loadingPkgState == null) goto L24;
            String loadingPkgAbi = loadingPkgState.getPrimaryCpuAbi();     // Catch: Throwable -> L17
            if (loadingPkgAbi != null) goto L19;
            loadingPkgAbi = Build.SUPPORTED_ABIS[0];     // Catch: Throwable -> L17
        L19:
            String loadingPkgDexCodeIsa = InstructionSets.getDexCodeInstructionSet(VMRuntime.getInstructionSet(loadingPkgAbi));     // Catch: Throwable -> L17
            if (loaderIsa.equals(loadingPkgDexCodeIsa) == true) goto L24;
            Log.wtf("PackageManager", "Invalid loaderIsa in notifyDexLoad call from " + loadingPackageName + ", uid " + callingUid + ": expected " + loadingPkgDexCodeIsa + ", got " + loaderIsa);     // Catch: Throwable -> L17
            filteredSnapshot.close();
            return;
        L17:
            th = move-exception;
            if (filteredSnapshot == null) goto L43;
            filteredSnapshot.close();     // Catch: Throwable -> L31
            throw th;
        L31:
            th = move-exception;
            th.addSuppressed(th);
            throw th;
        L43:
            throw th;
        L34:
            ApplicationInfo ai = snapshot.getApplicationInfo(loadingPackageName, 0, userId);
            if (ai != null) goto L38;
            Slog.w("PackageManager", "Loading a package that does not exist for the calling user. package=" + loadingPackageName + ", user=" + userId);
            return;
        L38:
            PackageManagerService.m6813$$Nest$fgetmDexManager(this.this$0).notifyDexLoad(ai, classLoaderContextMap, loaderIsa, userId, Process.isIsolated(callingUid));
            return;
        L5:
            if (snapshot.isCallerSameApp(loadingPackageName, callingUid, true) == true) goto L8;
            Slog.w("PackageManager", TextUtils.formatSimple("Invalid dex load report. loadingPackageName=%s, uid=%d", new Object[]{loadingPackageName, Integer.valueOf(callingUid)}));
        }

        public void notifyPackageUse(String packageName, int reason) {
            int callingUid = Binder.getCallingUid();
            int callingUserId = UserHandle.getUserId(callingUid);
            Computer snapshot = this.this$0.snapshotComputer();
            if (snapshot.getInstantAppPackageName(callingUid) == null) goto L5;
            boolean notify = snapshot.isCallerSameApp(packageName, callingUid);
        L6:
            if (notify == true) goto L8;
            return;
        L8:
            PackageManagerService.m6854$$Nest$mnotifyPackageUseInternal(this.this$0, packageName, reason);
            return;
        L5:
            notify = !snapshot.isInstantAppInternal(packageName, callingUserId, 1000);
            goto L6
        }

        public void overrideLabelAndIcon(ComponentName componentName, String nonLocalizedLabel, int icon, int userId) {
            if (TextUtils.isEmpty(nonLocalizedLabel) == true) goto L7;
            this.this$0.updateComponentLabelIcon(componentName, nonLocalizedLabel, Integer.valueOf(icon), userId);
            return;
        L7:
            throw new IllegalArgumentException("Override label should be a valid String");
        }

        public ParceledListSlice<PackageManager.Property> queryProperty(String propertyName, int componentType) {
            propertyName.getClass();
            final int callingUid = Binder.getCallingUid();
            final int callingUserId = UserHandle.getCallingUserId();
            final Computer snapshot = this.this$0.snapshotComputer();
            List<PackageManager.Property> result = PackageManagerService.m6831$$Nest$fgetmPackageProperty(this.this$0).queryProperty(propertyName, componentType, new PackageManagerService$IPackageManagerImpl$$ExternalSyntheticLambda4(snapshot, callingUid, callingUserId));
            if (result != null) goto L7;
            return ParceledListSlice.emptyList();
        L7:
            return new ParceledListSlice(result);
        }

        private static /* synthetic */ boolean lambda$queryProperty$6(Computer snapshot, int callingUid, int callingUserId, String packageName) {
            if (snapshot.getPackageStateForInstalledAndFiltered(packageName, callingUid, callingUserId) != null) goto L5;
            return true;
        L5:
            return false;
        }

        public void registerDexModule(String packageName, final String dexModulePath, boolean isSharedModule, final IDexModuleRegisterCallback callback) {
            Slog.i("PackageManager", "Ignored unsupported registerDexModule call for " + dexModulePath + " in " + packageName);
            final DexManager.RegisterDexModuleResult result = new DexManager.RegisterDexModuleResult(false, "registerDexModule call not supported since Android U");
            if (callback == null) goto L6;
            this.this$0.mHandler.post(new PackageManagerService$IPackageManagerImpl$$ExternalSyntheticLambda13(callback, dexModulePath, result));
            return;
        }

        private static /* synthetic */ void lambda$registerDexModule$7(IDexModuleRegisterCallback callback, String dexModulePath, DexManager.RegisterDexModuleResult result) {
            callback.onDexModuleRegistered(dexModulePath, result.success, result.message);     // Catch: RemoteException -> L4
            return;
        L4:
            e = move-exception;
            Slog.w("PackageManager", "Failed to callback after module registration " + dexModulePath, e);
        }

        public void registerMoveCallback(IPackageMoveObserver callback) {
            registerMoveCallback_enforcePermission();
            this.this$0.mMoveCallbacks.register(callback);
        }

        public void restoreDomainVerification(byte[] backup, int userId) {
            if (Binder.getCallingUid() != 1000) goto L9;
            ByteArrayInputStream input = new ByteArrayInputStream(backup);     // Catch: Exception -> L6
            TypedXmlPullParser parser = Xml.resolvePullParser(input);     // Catch: Exception -> L6
            this.this$0.mDomainVerificationManager.restoreSettings(this.this$0.snapshotComputer(), parser);     // Catch: Exception -> L6
            input.close();     // Catch: Exception -> L6
            return;
        L7:
            return;
        L9:
            throw new SecurityException("Only the system may call restorePreferredActivities()");
        }

        public void restoreLabelAndIcon(ComponentName componentName, int userId) {
            this.this$0.updateComponentLabelIcon(componentName, null, null, userId);
        }

        public void sendDeviceCustomizationReadyBroadcast() {
            this.this$0.mContext.enforceCallingPermission("android.permission.SEND_DEVICE_CUSTOMIZATION_READY", "sendDeviceCustomizationReadyBroadcast");
            long ident = Binder.clearCallingIdentity();
            BroadcastHelper.sendDeviceCustomizationReadyBroadcast();     // Catch: Throwable -> L6
            Binder.restoreCallingIdentity(ident);
            return;
        L6:
            th = move-exception;
            Binder.restoreCallingIdentity(ident);
            throw th;
        }

        public void setApplicationCategoryHint(final String packageName, final int categoryHint, final String callerPackageName) {
            final int callingUid = Binder.getCallingUid();
            final int userId = UserHandle.getCallingUserId();
            FunctionalUtils.ThrowingBiFunction<PackageStateMutator.InitialState, Computer, PackageStateMutator.Result> implementation = new PackageManagerService$IPackageManagerImpl$$ExternalSyntheticLambda22(this, callingUid, callerPackageName, userId, packageName, categoryHint);
            PackageStateMutator.Result result = (PackageStateMutator.Result) implementation.apply(this.this$0.recordInitialState(), this.this$0.snapshotComputer());
            if (result != null) goto L5;
        L17:
            if (result != null) goto L19;
            return;
        L19:
            if (result.isCommitted() == false) goto L25;
            this.this$0.scheduleWriteSettings();
            return;
        L25:
            return;
        L5:
            if (result.isStateChanged() == false) goto L17;
            if (result.isSpecificPackageNull() == true) goto L17;
            PackageManagerTracedLock r11 = PackageManagerService.m6832$$Nest$fgetmPackageStateWriteLock(this.this$0);
            PackageManagerService.boostPriorityForPackageManagerTracedLockedSection();
            monitor-enter(r11);
            result = (PackageStateMutator.Result) implementation.apply(this.this$0.recordInitialState(), this.this$0.snapshotComputer());     // Catch: Throwable -> L13
            monitor-exit(r11);     // Catch: Throwable -> L13
            PackageManagerService.resetPriorityAfterPackageManagerTracedLockedSection();
        L13:
            th = move-exception;
            PackageManagerService.resetPriorityAfterPackageManagerTracedLockedSection();
            throw th;
        }

        private /* synthetic */ PackageStateMutator.Result lambda$setApplicationCategoryHint$9(int callingUid, String callerPackageName, int userId, String packageName, final int categoryHint, PackageStateMutator.InitialState initialState, Computer computer) throws Exception {
            if (computer.getInstantAppPackageName(callingUid) != null) goto L23;
            int callerPackageUid = computer.getPackageUid(callerPackageName, 0, userId);
            if (callerPackageUid != callingUid) goto L21;
            PackageStateInternal packageState = computer.getPackageStateForInstalledAndFiltered(packageName, callingUid, userId);
            if (packageState == null) goto L19;
            if (Objects.equals(callerPackageName, packageState.getInstallSource().mInstallerPackageName) == false) goto L17;
            if (packageState.getCategoryOverride() != categoryHint) goto L13;
            return null;
        L13:
            return this.this$0.commitPackageStateMutation(initialState, packageName, new PackageManagerService$IPackageManagerImpl$$ExternalSyntheticLambda19(categoryHint));
        L17:
            throw new IllegalArgumentException("Calling package " + callerPackageName + " is not installer for " + packageName);
        L19:
            throw new IllegalArgumentException("Unknown target package " + packageName);
        L21:
            throw new SecurityException("Package " + callerPackageName + " does not belong to " + callingUid);
        L23:
            throw new SecurityException("Instant applications don't have access to this method");
        }

        private static /* synthetic */ void lambda$setApplicationCategoryHint$8(int categoryHint, PackageStateWrite state) {
            state.setCategoryOverride(categoryHint);
        }

        public void setApplicationEnabledSetting(String appPackageName, int newState, int flags, int userId, String callingPackage) {
            if (this.this$0.mUserManager.exists(userId) == true) goto L5;
            return;
        L5:
            if (callingPackage != null) goto L7;
            callingPackage = Integer.toString(Binder.getCallingUid());
        L7:
            PackageManagerService.m6857$$Nest$msetEnabledSettings(this.this$0, List.of(new PackageManager.ComponentEnabledSetting(appPackageName, newState, flags)), userId, callingPackage);
        }

        public void setPageSizeAppCompatFlagsSettingsOverride(String packageName, boolean enabled) {
            int callingUid = Binder.getCallingUid();
            int callingAppId = UserHandle.getAppId(callingUid);
            if (PackageManagerServiceUtils.isSystemOrRoot(callingAppId) == false) goto L14;
            if (enabled == false) goto L6;
            final int settingsMode = 8;
        L7:
            PackageStateMutator.Result result = this.this$0.commitPackageStateMutation(null, packageName, new PackageManagerService$IPackageManagerImpl$$ExternalSyntheticLambda10(settingsMode));
            if (result.isSpecificPackageNull() == true) goto L12;
            this.this$0.scheduleWriteSettings();
            return;
        L12:
            throw new IllegalArgumentException("Unknown package: " + packageName);
        L6:
            settingsMode = 16;
            goto L7
        L14:
            throw new SecurityException("Caller must be the system or root.");
        }

        private static /* synthetic */ void lambda$setPageSizeAppCompatFlagsSettingsOverride$10(int settingsMode, PackageStateWrite packageState) {
            packageState.setPageSizeAppCompatFlags(settingsMode);
        }

        public boolean isPageSizeCompatEnabled(String packageName) {
            int callingUid = Binder.getCallingUid();
            int callingAppId = UserHandle.getAppId(callingUid);
            int userId = UserHandle.getCallingUserId();
            if (PackageManagerServiceUtils.isSystemOrRoot(callingAppId) == false) goto L10;
            PackageStateInternal packageState = this.this$0.snapshotComputer().getPackageStateForInstalledAndFiltered(packageName, callingUid, userId);
            if (packageState != null) goto L8;
            return false;
        L8:
            return packageState.isPageSizeAppCompatEnabled();
        L10:
            throw new SecurityException("Caller must be the system or root.");
        }

        public String getPageSizeCompatWarningMessage(String packageName) {
            int callingUid = Binder.getCallingUid();
            int callingAppId = UserHandle.getAppId(callingUid);
            int userId = UserHandle.getCallingUserId();
            if (PackageManagerServiceUtils.isSystemOrRoot(callingAppId) == false) goto L10;
            PackageStateInternal packageState = this.this$0.snapshotComputer().getPackageStateForInstalledAndFiltered(packageName, callingUid, userId);
            if (packageState != null) goto L8;
            return null;
        L8:
            return packageState.getPageSizeCompatWarningMessage(this.this$0.mContext);
        L10:
            throw new SecurityException("Caller must be the system or root.");
        }

        /* JADX WARN: Unreachable blocks removed: 2, instructions: 3 */
        public boolean setApplicationHiddenSettingAsUser(String packageName, final boolean hidden, int userId) {
            final int r6 = userId;
            setApplicationHiddenSettingAsUser_enforcePermission();
            int callingUid = Binder.getCallingUid();
            Computer snapshot = this.this$0.snapshotComputer();
            snapshot.enforceCrossUserPermission(callingUid, r6, true, true, "setApplicationHiddenSetting for user " + r6);
            if (hidden == false) goto L9;
            if (this.this$0.isPackageDeviceAdmin(packageName, r6) == false) goto L9;
            Slog.w("PackageManager", "Not hiding package " + packageName + ": has active device admin");
            return false;
        L9:
            if (PackageManagerService.PLATFORM_PACKAGE_NAME.equals(packageName) == false) goto L11;
        L73:
            Slog.w("PackageManager", "Cannot hide package: " + packageName);
            return false;
        L11:
            if (((PackageManagerInternal) LocalServices.getService(PackageManagerInternal.class)).getSystemUiServiceComponent().getPackageName().equals(packageName) == true) goto L73;
            long callingId = Binder.clearCallingIdentity();
            PackageStateInternal packageState = snapshot.getPackageStateInternal(packageName);     // Catch: Throwable -> L33
            if (packageState != null) goto L19;
            Binder.restoreCallingIdentity(callingId);
            return false;
        L19:
            PackageUserStateInternal userState = packageState.getUserStateOrDefault(r6);     // Catch: Throwable -> L33
            if (userState.isHidden() != hidden) goto L22;
        L69:
            Binder.restoreCallingIdentity(callingId);
            return false;
        L22:
            if (userState.isInstalled() == false) goto L69;
            if (snapshot.shouldFilterApplication(packageState, callingUid, r6) == true) goto L69;
            AndroidPackageInternal r4 = packageState.getPkg();     // Catch: Throwable -> L33
            if (r4 != null) goto L29;
        L40:
            if (hidden == true) goto L42;
        L48:
            this.this$0.commitPackageStateMutation(null, packageName, new PackageManagerService$IPackageManagerImpl$$ExternalSyntheticLambda8(r6, hidden));     // Catch: Throwable -> L33
            Computer newSnapshot = this.this$0.snapshotComputer();     // Catch: Throwable -> L33
            PackageStateInternal newPackageState = newSnapshot.getPackageStateInternal(packageName);     // Catch: Throwable -> L33
            if (hidden == false) goto L78;
            this.this$0.killApplication(packageName, newPackageState.getAppId(), userId, "hiding pkg", 13);     // Catch: Throwable -> L56
            r6 = userId;
            this.this$0.mBroadcastHelper.sendApplicationHiddenForUser(packageName, newPackageState, r6, this.this$0);     // Catch: Throwable -> L33
        L64:
            this.this$0.scheduleWritePackageRestrictions(r6);     // Catch: Throwable -> L33
            Binder.restoreCallingIdentity(callingId);
            return true;
        L56:
            th = th;
        L71:
            Binder.restoreCallingIdentity(callingId);
            throw th;
        L78:
            this.this$0.mBroadcastHelper.sendPackageAddedForUser(newSnapshot, packageName, newPackageState, r6, false, 0, this.this$0.mAppPredictionServicePackage);     // Catch: Throwable -> L67
        L67:
            th = th;
            goto L71
        L42:
            if (UserHandle.isSameApp(callingUid, packageState.getAppId()) == true) goto L48;
            if (this.this$0.mProtectedPackages.isPackageStateProtected(r6, packageName) == false) goto L48;
            Slog.w("PackageManager", "Not hiding protected package: " + packageName);     // Catch: Throwable -> L33
            Binder.restoreCallingIdentity(callingId);
            return false;
        L29:
            if (r4.getSdkLibraryName() == null) goto L36;
            Slog.w("PackageManager", "Cannot hide package: " + packageName + " providing SDK library: " + r4.getSdkLibraryName());     // Catch: Throwable -> L33
            Binder.restoreCallingIdentity(callingId);
            return false;
        L36:
            if (r4.getStaticSharedLibraryName() == null) goto L40;
            Slog.w("PackageManager", "Cannot hide package: " + packageName + " providing static shared library: " + r4.getStaticSharedLibraryName());     // Catch: Throwable -> L33
            Binder.restoreCallingIdentity(callingId);
            return false;
        L33:
            th = th;
            goto L71
        }

        private static /* synthetic */ void lambda$setApplicationHiddenSettingAsUser$11(int userId, boolean hidden, PackageStateWrite packageState1) {
            packageState1.userState(userId).setHidden(hidden);
        }

        public boolean setBlockUninstallForUser(String packageName, boolean blockUninstall, int userId) {
            setBlockUninstallForUser_enforcePermission();
            Computer snapshot = this.this$0.snapshotComputer();
            PackageStateInternal packageState = snapshot.getPackageStateInternal(packageName);
            if (packageState != null) goto L5;
        L14:
            PackageManagerTracedLock r2 = this.this$0.mLock;
            PackageManagerService.boostPriorityForPackageManagerTracedLockedSection();
            monitor-enter(r2);
            this.this$0.mSettings.setBlockUninstallLPw(userId, packageName, blockUninstall);     // Catch: Throwable -> L20
            monitor-exit(r2);     // Catch: Throwable -> L20
            PackageManagerService.resetPriorityAfterPackageManagerTracedLockedSection();
            this.this$0.scheduleWritePackageRestrictions(userId);
            return true;
        L20:
            th = move-exception;
            PackageManagerService.resetPriorityAfterPackageManagerTracedLockedSection();
            throw th;
        L5:
            if (packageState.getPkg() == null) goto L14;
            AndroidPackageInternal r3 = packageState.getPkg();
            if (r3.getSdkLibraryName() == null) goto L11;
            Slog.w("PackageManager", "Cannot block uninstall of package: " + packageName + " providing SDK library: " + r3.getSdkLibraryName());
            return false;
        L11:
            if (r3.getStaticSharedLibraryName() == null) goto L14;
            Slog.w("PackageManager", "Cannot block uninstall of package: " + packageName + " providing static shared library: " + r3.getStaticSharedLibraryName());
            return false;
        }

        public void setComponentEnabledSetting(ComponentName componentName, int newState, int flags, int userId, String callingPackage) {
            if (this.this$0.mUserManager.exists(userId) == true) goto L5;
            return;
        L5:
            if (callingPackage != null) goto L7;
            callingPackage = Integer.toString(Binder.getCallingUid());
        L7:
            PackageManagerService.m6857$$Nest$msetEnabledSettings(this.this$0, List.of(new PackageManager.ComponentEnabledSetting(componentName, newState, flags)), userId, callingPackage);
        }

        public void setComponentEnabledSettings(List<PackageManager.ComponentEnabledSetting> settings, int userId, String callingPackage) {
            if (this.this$0.mUserManager.exists(userId) == true) goto L5;
            return;
        L5:
            if (settings == null) goto L13;
            if (settings.isEmpty() == true) goto L13;
            if (callingPackage != null) goto L10;
            callingPackage = Integer.toString(Binder.getCallingUid());
        L10:
            PackageManagerService.m6857$$Nest$msetEnabledSettings(this.this$0, settings, userId, callingPackage);
            return;
        L13:
            throw new IllegalArgumentException("The list of enabled settings is empty");
        }

        public String[] setDistractingPackageRestrictionsAsUser(String[] packageNames, int restrictionFlags, int userId) {
            int callingUid = Binder.getCallingUid();
            Computer snapshot = this.this$0.snapshotComputer();
            PackageManagerService.m6849$$Nest$menforceCanSetDistractingPackageRestrictionsAsUser(this.this$0, callingUid, userId, "setDistractingPackageRestrictionsAsUser");
            packageNames.getClass();
            return PackageManagerService.m6814$$Nest$fgetmDistractingPackageHelper(this.this$0).setDistractingPackageRestrictionsAsUser(snapshot, packageNames, restrictionFlags, userId, callingUid);
        }

        public void setHarmfulAppWarning(String packageName, final CharSequence warning, final int userId) {
            int callingUid = Binder.getCallingUid();
            int callingAppId = UserHandle.getAppId(callingUid);
            Computer snapshot = this.this$0.snapshotComputer();
            snapshot.enforceCrossUserPermission(callingUid, userId, true, true, "setHarmfulAppInfo");
            if (PackageManagerServiceUtils.isSystemOrRoot(callingAppId) == false) goto L5;
        L9:
            PackageStateMutator.Result result = this.this$0.commitPackageStateMutation(null, packageName, new PackageManagerService$IPackageManagerImpl$$ExternalSyntheticLambda14(userId, warning));
            if (result.isSpecificPackageNull() == true) goto L14;
            this.this$0.scheduleWritePackageRestrictions(userId);
            return;
        L14:
            throw new IllegalArgumentException("Unknown package: " + packageName);
        L5:
            if (snapshot.checkUidPermission("android.permission.SET_HARMFUL_APP_WARNINGS", callingUid) == 0) goto L9;
            throw new SecurityException("Caller must have the android.permission.SET_HARMFUL_APP_WARNINGS permission.");
        }

        private static /* synthetic */ void lambda$setHarmfulAppWarning$12(int userId, CharSequence warning, PackageStateWrite packageState) {
            PackageUserStateWrite r0 = packageState.userState(userId);
            if (warning != null) goto L5;
            String r1 = null;
        L6:
            r0.setHarmfulAppWarning(r1);
            return;
        L5:
            r1 = warning.toString();
            goto L6
        }

        public boolean setInstallLocation(int loc) {
            setInstallLocation_enforcePermission();
            if (getInstallLocation() != loc) goto L5;
            return true;
        L5:
            if (loc == 0) goto L12;
            if (loc == 1) goto L12;
            if (loc == 2) goto L12;
            return false;
        L12:
            android.provider.Settings.Global.putInt(this.this$0.mContext.getContentResolver(), "default_install_location", loc);
            return true;
        }

        public void setInstallerPackageName(final String targetPackage, final String installerPackageName) {
            final int callingUid = Binder.getCallingUid();
            final int callingUserId = UserHandle.getUserId(callingUid);
            FunctionalUtils.ThrowingCheckedFunction<Computer, Boolean, RuntimeException> implementation = new PackageManagerService$IPackageManagerImpl$$ExternalSyntheticLambda1(this, callingUid, targetPackage, callingUserId, installerPackageName);
            PackageStateMutator.InitialState initialState = this.this$0.recordInitialState();
            boolean allowed = ((Boolean) implementation.apply(this.this$0.snapshotComputer())).booleanValue();
            if (allowed == false) goto L39;
            if (installerPackageName != null) goto L6;
            int r0 = -1;
        L7:
            final int installerPackageUid = r0;
            PackageManagerTracedLock r8 = this.this$0.mLock;
            PackageManagerService.boostPriorityForPackageManagerTracedLockedSection();
            monitor-enter(r8);
            PackageStateMutator.Result result = this.this$0.commitPackageStateMutation(initialState, targetPackage, new PackageManagerService$IPackageManagerImpl$$ExternalSyntheticLambda2(installerPackageName, installerPackageUid));     // Catch: Throwable -> L14
            if (result.isPackagesChanged() == true) goto L16;
            if (result.isStateChanged() == true) goto L16;
        L23:
            PackageStateInternal targetPackageState = this.this$0.snapshotComputer().getPackageStateInternal(targetPackage);     // Catch: Throwable -> L14
            this.this$0.mSettings.addInstallerPackageNames(targetPackageState.getInstallSource());     // Catch: Throwable -> L14
            monitor-exit(r8);     // Catch: Throwable -> L14
            PackageManagerService.resetPriorityAfterPackageManagerTracedLockedSection();
            this.this$0.mAppsFilter.addPackage(this.this$0.snapshotComputer(), targetPackageState);
            this.this$0.scheduleWriteSettings();
            return;
        L16:
            PackageManagerTracedLock r10 = PackageManagerService.m6832$$Nest$fgetmPackageStateWriteLock(this.this$0);     // Catch: Throwable -> L14
            PackageManagerService.boostPriorityForPackageManagerTracedLockedSection();     // Catch: Throwable -> L14
            monitor-enter(r10);     // Catch: Throwable -> L14
            boolean allowed2 = ((Boolean) implementation.apply(this.this$0.snapshotComputer())).booleanValue();     // Catch: Throwable -> L26
            if (allowed2 == false) goto L28;
            this.this$0.commitPackageStateMutation(null, targetPackage, new PackageManagerService$IPackageManagerImpl$$ExternalSyntheticLambda3(installerPackageName, installerPackageUid));     // Catch: Throwable -> L26
            monitor-exit(r10);     // Catch: Throwable -> L26
            PackageManagerService.resetPriorityAfterPackageManagerTracedLockedSection();     // Catch: Throwable -> L14
            goto L23
        L28:
            monitor-exit(r10);     // Catch: Throwable -> L26
            PackageManagerService.resetPriorityAfterPackageManagerTracedLockedSection();     // Catch: Throwable -> L14
            monitor-exit(r8);     // Catch: Throwable -> L14
            PackageManagerService.resetPriorityAfterPackageManagerTracedLockedSection();
            return;
        L26:
            th = move-exception;
            PackageManagerService.resetPriorityAfterPackageManagerTracedLockedSection();     // Catch: Throwable -> L14
            throw th;     // Catch: Throwable -> L14
        L14:
            th = move-exception;
            PackageManagerService.resetPriorityAfterPackageManagerTracedLockedSection();
            throw th;
        L6:
            r0 = this.this$0.snapshotComputer().getPackageUid(installerPackageName, 0, callingUserId);
            goto L7
        }

        private /* synthetic */ Boolean lambda$setInstallerPackageName$13(int callingUid, String targetPackage, int callingUserId, String installerPackageName, Computer snapshot) throws RuntimeException {
            if (snapshot.getInstantAppPackageName(callingUid) == null) goto L5;
            return false;
        L5:
            PackageStateInternal targetPackageState = snapshot.getPackageStateForInstalledAndFiltered(targetPackage, callingUid, callingUserId);
            if (targetPackageState == null) goto L60;
            if (installerPackageName == null) goto L14;
            PackageStateInternal installerPackageState = snapshot.getPackageStateForInstalledAndFiltered(installerPackageName, callingUid, callingUserId);
            if (installerPackageState == null) goto L13;
            PackageStateInternal installerPackageState2 = installerPackageState;
        L15:
            int appId = UserHandle.getAppId(callingUid);
            Pair<PackageStateInternal, SharedUserApi> either = snapshot.getPackageOrSharedUser(appId);
            if (either == null) goto L58;
            if (either.first == null) goto L20;
            SigningDetails callerSigningDetails = ((PackageStateInternal) either.first).getSigningDetails();
        L21:
            if (installerPackageState2 != null) goto L23;
        L27:
            String targetInstallerPackageName = targetPackageState.getInstallSource().mInstallerPackageName;
            if (targetInstallerPackageName != null) goto L30;
            PackageStateInternal r0 = null;
        L31:
            PackageStateInternal targetInstallerPkgSetting = r0;
            if (targetInstallerPkgSetting == null) goto L39;
            if (PackageManagerServiceUtils.compareSignatures(callerSigningDetails, targetInstallerPkgSetting.getSigningDetails()) == 0) goto L56;
            throw new SecurityException("Caller does not have same cert as old installer package " + targetInstallerPackageName);
        L56:
            return true;
        L39:
            if (this.this$0.mContext.checkCallingOrSelfPermission("android.permission.INSTALL_PACKAGES") == 0) goto L56;
            EventLog.writeEvent(1397638484, new Object[]{"150857253", Integer.valueOf(callingUid), ""});
            long binderToken = Binder.clearCallingIdentity();
            long binderToken2 = binderToken;
        L49:
            th = th;
        L53:
            Binder.restoreCallingIdentity(binderToken2);
            throw th;
        L44:
            if (this.this$0.mInjector.getCompatibility().isChangeEnabledByUid(PackageManagerService.THROW_EXCEPTION_ON_REQUIRE_INSTALL_PACKAGES_TO_ADD_INSTALLER_PACKAGE, callingUid) == true) goto L48;
            Binder.restoreCallingIdentity(binderToken2);
            return false;
        L48:
            throw new SecurityException("Neither user " + callingUid + " nor current process has android.permission.INSTALL_PACKAGES");     // Catch: Throwable -> L49
        L51:
            th = th;
            binderToken2 = binderToken;
            goto L53
        L30:
            r0 = snapshot.getPackageStateInternal(targetInstallerPackageName);
            goto L31
        L23:
            if (PackageManagerServiceUtils.compareSignatures(callerSigningDetails, installerPackageState2.getSigningDetails()) == 0) goto L27;
            throw new SecurityException("Caller does not have same cert as new installer package " + installerPackageName);
        L20:
            callerSigningDetails = ((SharedUserApi) either.second).getSigningDetails();
            goto L21
        L58:
            throw new SecurityException("Unknown calling UID: " + callingUid);
        L13:
            throw new IllegalArgumentException("Unknown installer package: " + installerPackageName);
        L14:
            installerPackageState2 = null;
            goto L15
        L60:
            throw new IllegalArgumentException("Unknown target package: " + targetPackage);
        }

        private static /* synthetic */ void lambda$setInstallerPackageName$14(String installerPackageName, int installerPackageUid, PackageStateWrite state) {
            state.setInstaller(installerPackageName, installerPackageUid);
        }

        private static /* synthetic */ void lambda$setInstallerPackageName$15(String installerPackageName, int installerPackageUid, PackageStateWrite state) {
            state.setInstaller(installerPackageName, installerPackageUid);
        }

        public void relinquishUpdateOwnership(String targetPackage) {
            int callingUid = Binder.getCallingUid();
            int callingUserId = UserHandle.getUserId(callingUid);
            Computer snapshot = this.this$0.snapshotComputer();
            PackageStateInternal targetPackageState = snapshot.getPackageStateForInstalledAndFiltered(targetPackage, callingUid, callingUserId);
            if (targetPackageState == null) goto L22;
            String targetUpdateOwnerPackageName = targetPackageState.getInstallSource().mUpdateOwnerPackageName;
            if (targetUpdateOwnerPackageName != null) goto L7;
            PackageStateInternal targetUpdateOwnerPkgSetting = null;
        L9:
            if (targetUpdateOwnerPkgSetting != null) goto L11;
            return;
        L11:
            int callingAppId = UserHandle.getAppId(callingUid);
            int targetUpdateOwnerAppId = targetUpdateOwnerPkgSetting.getAppId();
            if (callingAppId != 1000) goto L14;
        L19:
            this.this$0.commitPackageStateMutation(null, targetPackage, new PackageManagerService$IPackageManagerImpl$$ExternalSyntheticLambda23());
            this.this$0.scheduleWriteSettings();
            return;
        L14:
            if (callingAppId == 2000) goto L19;
            if (callingAppId == targetUpdateOwnerAppId) goto L19;
            throw new SecurityException("Caller is not the current update owner.");
        L7:
            targetUpdateOwnerPkgSetting = snapshot.getPackageStateInternal(targetUpdateOwnerPackageName);
            goto L9
        L22:
            throw new IllegalArgumentException("Unknown target package: " + targetPackage);
        }

        private static /* synthetic */ void lambda$relinquishUpdateOwnership$16(PackageStateWrite state) {
            state.setUpdateOwner(null);
        }

        public boolean setInstantAppCookie(String packageName, byte[] cookie, int userId) {
            Computer snapshot = this.this$0.snapshotComputer();
            snapshot.enforceCrossUserPermission(Binder.getCallingUid(), userId, true, true, "setInstantAppCookie");
            if (snapshot.isCallerSameApp(packageName, Binder.getCallingUid()) == true) goto L5;
            return false;
        L5:
            PackageStateInternal packageState = snapshot.getPackageStateInternal(packageName);
            if (packageState != null) goto L8;
        L12:
            return false;
        L8:
            if (packageState.getPkg() == null) goto L12;
            return this.this$0.mInstantAppRegistry.setInstantAppCookie(packageState.getPkg(), cookie, this.this$0.mContext.getPackageManager().getInstantAppCookieMaxBytes(), userId);
        }

        public void setKeepUninstalledPackages(List<String> packageList) {
            this.this$0.mContext.enforceCallingPermission("android.permission.KEEP_UNINSTALLED_PACKAGES", "setKeepUninstalledPackages requires KEEP_UNINSTALLED_PACKAGES permission");
            packageList.getClass();
            this.this$0.setKeepUninstalledPackagesInternal(snapshot(), packageList);
        }

        public void setMimeGroup(final String packageName, final String mimeGroup, List<String> mimeTypes) {
            Computer snapshot = this.this$0.snapshotComputer();
            final int callingUid = Binder.getCallingUid();
            PackageManagerService.m6851$$Nest$menforceOwnerRights(this.this$0, snapshot, packageName, callingUid);
            List<String> mimeTypes2 = CollectionUtils.emptyIfNull(mimeTypes);
            int i = 0;
        L4:
            if (i >= mimeTypes2.size()) goto L10;
            if (mimeTypes2.get(i).length() > 255) goto L9;
            i = i + 1;
            goto L4
        L9:
            throw new IllegalArgumentException("MIME type length exceeds 255 characters");
        L10:
            final PackageStateInternal packageState = snapshot.getPackageStateInternal(packageName);
            Set<String> existingMimeTypes = packageState.getMimeGroups().get(mimeGroup);
            if (existingMimeTypes == null) goto L27;
            if (existingMimeTypes.size() != mimeTypes2.size()) goto L18;
            if (existingMimeTypes.containsAll(mimeTypes2) == false) goto L18;
            return;
        L18:
            if (mimeTypes2.size() > 500) goto L25;
            final ArraySet<String> mimeTypesSet = new ArraySet(mimeTypes2);
            this.this$0.commitPackageStateMutation(null, packageName, new PackageManagerService$IPackageManagerImpl$$ExternalSyntheticLambda17(mimeGroup, mimeTypesSet));
            if (this.this$0.mComponentResolver.updateMimeGroup(this.this$0.snapshotComputer(), packageName, mimeGroup) == false) goto L22;
            Binder.withCleanCallingIdentity(new PackageManagerService$IPackageManagerImpl$$ExternalSyntheticLambda18(this, packageName, packageState, callingUid));
        L22:
            this.this$0.scheduleWriteSettings();
            return;
        L25:
            throw new IllegalStateException("Max limit on MIME types for MIME group " + mimeGroup + " exceeded for package " + packageName);
        L27:
            throw new IllegalArgumentException("Unknown MIME group " + mimeGroup + " for package " + packageName);
        }

        private static /* synthetic */ void lambda$setMimeGroup$17(String mimeGroup, ArraySet mimeTypesSet, PackageStateWrite packageStateWrite) {
            packageStateWrite.setMimeGroup(mimeGroup, mimeTypesSet);
        }

        private /* synthetic */ void lambda$setMimeGroup$18(String packageName, PackageStateInternal packageState, int callingUid) throws Exception {
            PackageManagerService.m6835$$Nest$fgetmPreferredActivityHelper(this.this$0).clearPackagePreferredActivities(packageName, -1);
            Computer snapShot = this.this$0.snapshotComputer();
            ArrayList<String> components = new ArrayList(Collections.singletonList(packageName));
            int appId = packageState.getAppId();
            int[] userIds = this.this$0.resolveUserIds(-1);
            int i = 0;
        L4:
            if (i >= userIds.length) goto L12;
            PackageUserStateInternal pkgUserState = packageState.getUserStates().get(userIds[i]);
            if (pkgUserState == null) goto L10;
            if (pkgUserState.isInstalled() == false) goto L10;
            int packageUid = UserHandle.getUid(userIds[i], appId);
            this.this$0.mBroadcastHelper.sendPackageChangedBroadcast(snapShot, packageName, true, components, packageUid, "The mimeGroup is changed", "mime_group_changed", callingUid);
        L10:
            i = i + 1;
            goto L4
        }

        public void setPackageStoppedState(String packageName, boolean stopped, int userId) {
            this.this$0.setPackageStoppedState(this.this$0.snapshotComputer(), packageName, stopped, userId);
        }

        public String[] setPackagesSuspendedAsUser(String[] packageNames, boolean suspended, PersistableBundle appExtras, PersistableBundle launcherExtras, SuspendDialogInfo dialogInfo, int flags, String suspendingPackage, int suspendingUserId, int targetUserId) {
            int callingUid = Binder.getCallingUid();
            if ((flags & 1) != 0) goto L4;
        L4:
            Computer snapshot = this.this$0.snapshotComputer();
            UserPackage suspender = UserPackage.of(targetUserId, suspendingPackage);
            PackageManagerService.m6850$$Nest$menforceCanSetPackagesSuspendedAsUser(this.this$0, snapshot, false, suspender, callingUid, targetUserId, "setPackagesSuspendedAsUser");
            return PackageManagerService.m6843$$Nest$fgetmSuspendPackageHelper(this.this$0).setPackagesSuspended(snapshot, packageNames, suspended, appExtras, launcherExtras, dialogInfo, suspender, targetUserId, callingUid, false);
        }

        public boolean setRequiredForSystemUser(String packageName, final boolean requiredForSystemUser) {
            PackageManagerServiceUtils.enforceSystemOrRoot("setRequiredForSystemUser can only be run by the system or root");
            PackageStateMutator.Result result = this.this$0.commitPackageStateMutation(null, packageName, new PackageManagerService$IPackageManagerImpl$$ExternalSyntheticLambda16(requiredForSystemUser));
            if (result.isCommitted() == true) goto L6;
            return false;
        L6:
            this.this$0.scheduleWriteSettings();
            return true;
        }

        private static /* synthetic */ void lambda$setRequiredForSystemUser$19(boolean requiredForSystemUser, PackageStateWrite packageState) {
            packageState.setRequiredForSystemUser(requiredForSystemUser);
        }

        public void setUserMinAspectRatio(String packageName, final int userId, final int aspectRatio) {
            setUserMinAspectRatio_enforcePermission();
            int callingUid = Binder.getCallingUid();
            Computer snapshot = this.this$0.snapshotComputer();
            snapshot.enforceCrossUserPermission(callingUid, userId, false, false, "setUserMinAspectRatio");
            PackageManagerService.m6851$$Nest$menforceOwnerRights(this.this$0, snapshot, packageName, callingUid);
            PackageStateInternal packageState = snapshot.getPackageStateForInstalledAndFiltered(packageName, callingUid, userId);
            if (packageState != null) goto L6;
            return;
        L6:
            if (packageState.getUserStateOrDefault(userId).getMinAspectRatio() != aspectRatio) goto L8;
            return;
        L8:
            this.this$0.commitPackageStateMutation(null, packageName, new PackageManagerService$IPackageManagerImpl$$ExternalSyntheticLambda5(userId, aspectRatio));
        }

        private static /* synthetic */ void lambda$setUserMinAspectRatio$20(int userId, int aspectRatio, PackageStateWrite state) {
            state.userState(userId).setMinAspectRatio(aspectRatio);
        }

        public void setRuntimePermissionsVersion(int version, int userId) {
            Preconditions.checkArgumentNonnegative(version);
            Preconditions.checkArgumentNonnegative(userId);
            PackageManagerService.m6848x2d683684(this.this$0, "setRuntimePermissionVersion");
            this.this$0.mSettings.setDefaultRuntimePermissionsVersion(version, userId);
        }

        public void setSplashScreenTheme(String packageName, final String themeId, final int userId) {
            int callingUid = Binder.getCallingUid();
            Computer snapshot = this.this$0.snapshotComputer();
            snapshot.enforceCrossUserPermission(callingUid, userId, false, false, "setSplashScreenTheme");
            PackageManagerService.m6851$$Nest$menforceOwnerRights(this.this$0, snapshot, packageName, callingUid);
            PackageStateInternal packageState = snapshot.getPackageStateForInstalledAndFiltered(packageName, callingUid, userId);
            if (packageState != null) goto L5;
            return;
        L5:
            this.this$0.commitPackageStateMutation(null, packageName, new PackageManagerService$IPackageManagerImpl$$ExternalSyntheticLambda9(userId, themeId));
        }

        private static /* synthetic */ void lambda$setSplashScreenTheme$21(int userId, String themeId, PackageStateWrite state) {
            state.userState(userId).setSplashScreenTheme(themeId);
        }

        public void setUpdateAvailable(String packageName, final boolean updateAvailable) {
            setUpdateAvailable_enforcePermission();
            this.this$0.commitPackageStateMutation(null, packageName, new PackageManagerService$IPackageManagerImpl$$ExternalSyntheticLambda0(updateAvailable));
        }

        private static /* synthetic */ void lambda$setUpdateAvailable$22(boolean updateAvailable, PackageStateWrite state) {
            state.setUpdateAvailable(updateAvailable);
        }

        public void unregisterMoveCallback(IPackageMoveObserver callback) {
            unregisterMoveCallback_enforcePermission();
            this.this$0.mMoveCallbacks.unregister(callback);
        }

        public void verifyPendingInstall(final int verificationId, final int verificationCode) throws RemoteException {
            if (verificationId < 0) goto L4;
            this.this$0.mContext.enforceCallingOrSelfPermission("android.permission.PACKAGE_VERIFICATION_AGENT", "Only package verification agents can verify applications");
        L4:
            final int callingUid = Binder.getCallingUid();
            this.this$0.mHandler.post(new PackageManagerService$IPackageManagerImpl$$ExternalSyntheticLambda7(this, verificationId, callingUid, verificationCode));
        }

        private /* synthetic */ void lambda$verifyPendingInstall$23(int verificationId, int callingUid, int verificationCode) {
            if (verificationId < 0) goto L4;
            int id = verificationId;
        L5:
            PackageVerificationState state = this.this$0.mPendingVerification.get(id);
            if (state != null) goto L9;
            return;
        L9:
            if (state.checkRequiredVerifierUid(callingUid) == false) goto L11;
        L13:
            Message msg = this.this$0.mHandler.obtainMessage(15);
            PackageVerificationResponse response = new PackageVerificationResponse(verificationCode, callingUid);
            msg.arg1 = id;
            msg.obj = response;
            this.this$0.mHandler.sendMessage(msg);
            return;
        L11:
            if (state.checkSufficientVerifierUid(callingUid) == true) goto L13;
            return;
        L4:
            id = -verificationId;
            goto L5
        }

        public void registerPackageMonitorCallback(IRemoteCallback callback, int userId) {
            int uid = Binder.getCallingUid();
            int targetUserId = ActivityManager.handleIncomingUser(Binder.getCallingPid(), uid, userId, true, true, "registerPackageMonitorCallback", this.this$0.mContext.getPackageName());
            PackageManagerService.m6829$$Nest$fgetmPackageMonitorCallbackHelper(this.this$0).registerPackageMonitorCallback(callback, targetUserId, uid);
        }

        public void unregisterPackageMonitorCallback(IRemoteCallback callback) {
            PackageManagerService.m6829$$Nest$fgetmPackageMonitorCallbackHelper(this.this$0).unregisterPackageMonitorCallback(callback);
        }

        public void requestPackageChecksums(String packageName, boolean includeSplits, int optional, int required, List trustedInstallers, IOnChecksumsReadyListener onChecksumsReadyListener, int userId) {
            this.this$0.requestChecksumsInternal(this.this$0.snapshotComputer(), packageName, includeSplits, optional, required, trustedInstallers, onChecksumsReadyListener, userId, this.this$0.mInjector.getBackgroundExecutor(), this.this$0.mInjector.getBackgroundHandler());
        }

        public void notifyPackagesReplacedReceived(String[] packages) {
            Computer computer = this.this$0.snapshotComputer();
            ArraySet<String> packagesToNotify = computer.getNotifyPackagesForReplacedReceived(packages);
            int index = 0;
        L4:
            if (index >= packagesToNotify.size()) goto L7;
            this.this$0.notifyInstallObserver(packagesToNotify.valueAt(index), false);
            index = index + 1;
            goto L4
        }

        public ArchivedPackageParcel getArchivedPackage(String packageName, int userId) {
            return this.this$0.getArchivedPackageInternal(packageName, userId);
        }

        public Bitmap getArchivedAppIcon(String packageName, UserHandle user, String callingPackageName) {
            return this.this$0.mInstallerService.mPackageArchiver.getArchivedAppIcon(packageName, user, callingPackageName);
        }

        public boolean isAppArchivable(String packageName, UserHandle user) {
            return this.this$0.mInstallerService.mPackageArchiver.isAppArchivable(packageName, user);
        }

        public boolean waitForHandler(long timeoutMillis, boolean forBackgroundHandler) {
            boolean r1 = true;
            CountDownLatch latch = new CountDownLatch(1);
            if (forBackgroundHandler == false) goto L5;
            this.this$0.mBackgroundHandler.post(new SettingsStore$$ExternalSyntheticLambda0(latch));
        L6:
            long endTimeMillis = System.currentTimeMillis() + timeoutMillis;
        L8:
            if (latch.getCount() <= 0) goto L17;
            long remainingTimeMillis = endTimeMillis - System.currentTimeMillis();     // Catch: InterruptedException -> L15
            if (remainingTimeMillis <= 0) goto L11;
            return latch.await(remainingTimeMillis, TimeUnit.MILLISECONDS);
        L11:
            return false;
        L17:
            return r1;
        L5:
            this.this$0.mHandler.post(new SettingsStore$$ExternalSyntheticLambda0(latch));
            goto L6
        }

        public ComponentName getDomainVerificationAgent(int userId) {
            int callerUid = Binder.getCallingUid();
            if (PackageManagerServiceUtils.isRootOrShell(callerUid) == false) goto L14;
            Computer snapshot = this.this$0.snapshotComputer();
            ComponentName agent = this.this$0.mDomainVerificationManager.getProxy().getComponentName();
            PackageStateInternal ps = snapshot.getPackageStateForInstalledAndFiltered(agent.getPackageName(), callerUid, userId);
            if (ps != null) goto L7;
            return null;
        L7:
            WatchedArraySet<String> disabledComponents = ps.getUserStateOrDefault(userId).getDisabledComponentsNoCopy();
            if (disabledComponents != null) goto L10;
        L12:
            return agent;
        L10:
            if (disabledComponents.contains(agent.getClassName()) == false) goto L12;
            return null;
        L14:
            throw new SecurityException("Not allowed to query domain verification agent");
        }

        public List<String> getAllApexDirectories() {
            PackageManagerServiceUtils.enforceSystemOrRoot("getAllApexDirectories can only be called by system or root");
            List<String> apexDirectories = new ArrayList();
            List<ApexManager.ActiveApexInfo> apexes = this.this$0.mApexManager.getActiveApexInfos();
            int i = 0;
        L4:
            if (i >= apexes.size()) goto L7;
            ApexManager.ActiveApexInfo apex = apexes.get(i);
            apexDirectories.add(apex.apexDirectory.getAbsolutePath());
            i = i + 1;
            goto L4
        L7:
            return apexDirectories;
        }

        public boolean onTransact(int code, Parcel data, Parcel reply, int flags) throws RemoteException {
            return super.onTransact(code, data, reply, flags);
        L4:
            e = move-exception;
            if ((e instanceof SecurityException) == false) goto L8;
        L12:
            throw e;
        L8:
            if ((e instanceof IllegalArgumentException) == true) goto L12;
            if ((e instanceof ParcelableException) == true) goto L12;
            Slog.wtf("PackageManager", "Package Manager Unexpected Exception", e);
            goto L12
        }

        /* JADX WARN: Multi-variable type inference failed */
        public void onShellCommand(FileDescriptor in, FileDescriptor out, FileDescriptor err, String[] args, ShellCallback callback, ResultReceiver resultReceiver) {
            new PackageManagerShellCommand(this, this.this$0.mContext, this.this$0.mDomainVerificationManager.getShell()).exec(this, in, out, err, args, callback, resultReceiver);
        }

        protected void dump(FileDescriptor fd, PrintWriter pw, String[] args) {
            if (args.length <= 1) goto L18;
            if ("--ObricInstall".equals(args[0]) == false) goto L18;
            String pkgName = args[1];
            pw.println("ObricInstall: " + pkgName);
            long identity = Binder.clearCallingIdentity();
            PackageManagerService.m6827$$Nest$fgetmObricExt(this.this$0).recoveryRemovableSystemApp("", pkgName);     // Catch: Throwable -> L9 Exception -> L11
        L8:
            Binder.restoreCallingIdentity(identity);
            return;
        L11:
            e = move-exception;
            Slog.e("PackageManager", "ObricInstall: " + pkgName + " failed", e);     // Catch: Throwable -> L9
        L9:
            th = move-exception;
            Binder.restoreCallingIdentity(identity);
            throw th;
        L18:
            if (args.length <= 0) goto L29;
            if ("--cloudconfig".equals(args[0]) == true) goto L24;
            if ("--preinstall".equals(args[0]) == false) goto L29;
        L24:
            if (DumpUtils.checkDumpAndUsageStatsPermission(this.this$0.mContext, "PackageManager", pw) == true) goto L26;
            return;
        L26:
            PackageManagerService.m6817$$Nest$fgetmExt(this.this$0).dump(pw, args);
            return;
        L29:
            if (DumpUtils.checkDumpAndUsageStatsPermission(this.this$0.mContext, "PackageManager", pw) == true) goto L31;
            return;
        L31:
            Computer snapshot = this.this$0.snapshotComputer();
            KnownPackages knownPackages = new KnownPackages(PackageManagerService.m6812$$Nest$fgetmDefaultAppProvider(this.this$0), this.this$0.mRequiredInstallerPackage, this.this$0.mRequiredUninstallerPackage, this.this$0.mSetupWizardPackage, this.this$0.mRequiredVerifierPackages, this.this$0.mDefaultTextClassifierPackage, this.this$0.mSystemTextClassifierPackageName, this.this$0.mRequiredPermissionControllerPackage, this.this$0.mConfiguratorPackage, this.this$0.mIncidentReportApproverPackage, this.this$0.mAmbientContextDetectionPackage, this.this$0.mWearableSensingPackage, this.this$0.mAppPredictionServicePackage, PackageManagerService.COMPANION_PACKAGE_NAME, this.this$0.mRetailDemoPackage, this.this$0.mOverlayConfigSignaturePackage, this.this$0.mRecentsPackage);
            ArrayMap<String, FeatureInfo> availableFeatures = new ArrayMap(PackageManagerService.m6811$$Nest$fgetmAvailableFeatures(this.this$0));
            ArraySet<String> r5 = this.this$0.mProtectedBroadcasts;
            monitor-enter(r5);
            ArraySet<String> protectedBroadcasts = new ArraySet(this.this$0.mProtectedBroadcasts);     // Catch: Throwable -> L37
            monitor-exit(r5);     // Catch: Throwable -> L37
            new DumpHelper(this.this$0.mPermissionManager, PackageManagerService.m6842$$Nest$fgetmStorageEventHelper(this.this$0), this.this$0.mDomainVerificationManager, this.this$0.mInstallerService, this.this$0.mRequiredVerifierPackages, knownPackages, this.this$0.mChangedPackagesTracker, availableFeatures, protectedBroadcasts, this.this$0.getPerUidReadTimeouts(snapshot), PackageManagerService.m6841$$Nest$fgetmSnapshotStatistics(this.this$0)).doDump(snapshot, fd, pw, args);
            PackageManagerService.m6817$$Nest$fgetmExt(this.this$0).dump(pw, args);
            return;
        L37:
            th = th;
        L45:
            throw th;
        L41:
            th = th;
            goto L45
        }

        private byte[] hexStringToByteArray(String str) {
            if (str != null) goto L4;
            return null;
        L4:
            if (str.isEmpty() == false) goto L6;
            return null;
        L6:
            if ((str.length() % 2) != 0) goto L18;
            byte[] result = new byte[str.length() / 2];
            int i = 0;
        L10:
            if (i >= str.length()) goto L13;
            int digit = Character.digit(str.charAt(i), 16);
            int digit2 = (digit << 4) + Character.digit(str.charAt(i + 1), 16);
            result[i / 2] = (byte) digit2;
            i = i + 2;
            goto L10
        L13:
            return result;
        L18:
            return null;
        }

        private boolean checkPackageIs6939Authorized(String packageName, int callingUid) {
            String authorizedShaSumCode = (String) PackageManagerService.m6858$$Nest$sfgetAUTHORIZED_6939_PACKAGES().get(packageName);
            if (authorizedShaSumCode != null) goto L5;
            return false;
        L5:
            byte[] authorizedShaSumArray = hexStringToByteArray(authorizedShaSumCode);
            if (authorizedShaSumArray != null) goto L27;
            Slog.w("PackageManager", "zbackup invalid hash code:" + authorizedShaSumCode);
            return false;
        L27:
            int callingUser = UserHandle.getUserId(callingUid);     // Catch: Throwable -> L14
            PackageInfo packageInfo = getPackageInfo(packageName, 64, callingUser);     // Catch: Throwable -> L14
            if (packageInfo.signatures != null) goto L17;
            Slog.w("PackageManager", "zbackup " + packageName + " signatures is null");     // Catch: Throwable -> L14 Throwable -> L14
            return false;
        L17:
            if (packageInfo.signatures.length <= 1) goto L20;
            Slog.w("PackageManager", "zbackup " + packageName + " signatures length=" + packageInfo.signatures.length + " is over");     // Catch: Throwable -> L14 Throwable -> L14
            return false;
        L20:
            MessageDigest md = MessageDigest.getInstance("SHA-256");     // Catch: Throwable -> L14 Throwable -> L14
            byte[] binaryCert = packageInfo.signatures[0].toByteArray();     // Catch: Throwable -> L14 Throwable -> L14
            byte[] pkgShaSumArray = md.digest(binaryCert);     // Catch: Throwable -> L14 Throwable -> L14
            if (MessageDigest.isEqual(pkgShaSumArray, authorizedShaSumArray) == true) goto L24;
            return false;
        L24:
            return true;
        L14:
            e = move-exception;
            Slog.e("PackageManager", "zbackup check signature fail", e);
            return false;
        }

        public boolean checkUidIs6939Authorized(int callingUid) {
            Object r0 = this.mUidCheck6939Lock;
            monitor-enter(r0);
        L9:
            th = move-exception;
            throw th;
        L5:
            if (PackageManagerService.m6859$$Nest$sfgetsAuhthorized6939UidCache().contains(Integer.valueOf(callingUid)) == false) goto L11;
            Slog.i("PackageManager", "zbackup Uid:" + callingUid + ", Package(" + getNameForUid(callingUid) + ") is cached authorized");     // Catch: Throwable -> L9
            monitor-exit(r0);     // Catch: Throwable -> L9
            return true;
        L11:
            String callingPkg = getNameForUid(callingUid);     // Catch: Throwable -> L9
            if (checkPackageIs6939Authorized(callingPkg, callingUid) == true) goto L17;
            Slog.w("PackageManager", "zbackup not allow Package(" + callingPkg + ", Uid:" + callingUid + ") do 6939 command.");     // Catch: Throwable -> L9
            monitor-exit(r0);     // Catch: Throwable -> L9
            return false;
        L17:
            PackageManagerService.m6859$$Nest$sfgetsAuhthorized6939UidCache().add(Integer.valueOf(callingUid));     // Catch: Throwable -> L9
            Slog.i("PackageManager", "zbackup allow Package(" + callingPkg + ", Uid:" + callingUid + ") do 6939 command.");     // Catch: Throwable -> L9
            monitor-exit(r0);     // Catch: Throwable -> L9
            return true;
        }

        public int do6939Service(String[] cmdAndArgs) {
            int rc = -1;
            int callingUid = Binder.getCallingUid();
            if (checkUidIs6939Authorized(callingUid) == true) goto L7;
            return -1;
        L7:
            if (cmdAndArgs[0].equals("command") == false) goto L20;
            Object r2 = this.mDo6939CommandLock;
            monitor-enter(r2);
            int rc2 = this.this$0.mInstaller.do6939Service(cmdAndArgs);     // Catch: Throwable -> L12 Installer.InstallerException -> L14
            rc = rc2;
        L16:
            monitor-exit(r2);     // Catch: Throwable -> L12
            goto L20
        L14:
            e = move-exception;
            Slog.w("PackageManager", "zbackup do command get InstallerException ", e);     // Catch: Throwable -> L12
            rc = -1;
        L12:
            th = move-exception;
            throw th;
        L20:
            return rc;
        }

        public String getAllFilesPathsForPackage(String packageName) {
            Slog.d("PackageManager", "zbackup getAllFilesPathsForPackage " + packageName);
            int callingUid = Binder.getCallingUid();
            if (checkUidIs6939Authorized(callingUid) == true) goto L6;
            Slog.d("PackageManager", "zbackup getAllFilesPathsForPackage checkUidIs6939Authorized fail");
            return null;
        L6:
            Object r1 = this.mGetAllFilesPathLock;
            monitor-enter(r1);
            String r2 = this.this$0.mInstaller.getAllFilesPathsForPackage(packageName);     // Catch: Throwable -> L11 Installer.InstallerException -> L13
            monitor-exit(r1);     // Catch: Throwable -> L11
            return r2;
        L13:
            e = move-exception;
            Slog.w("PackageManager", "zbackup getAllFilesPathsForPackage InstallerException ", e);     // Catch: Throwable -> L11
            return null;
        L11:
            th = move-exception;
            throw th;
        }

        public IPackageManagerExt getIExt() {
            return PackageManagerService.m6817$$Nest$fgetmExt(this.this$0).getIExt();
        }

        public ParceledListSlice<PackageInfo> getDeletedSystemApp() {
            int callingUid = Binder.getCallingUid();
            int callingUserId = UserHandle.getUserId(callingUid);
            Computer snapshot = this.this$0.snapshotComputer();
            List<PackageInfo> res = new ArrayList();
            Iterator<String> r4 = RemovableSystemAppHelper.getRemovableSysApp().iterator();
        L4:
            if (r4.hasNext() == false) goto L12;
            String packageName = r4.next();
            PackageStateInternal ps = snapshot().getPackageStateInternal(packageName);
            if (ps == null) goto L4;
            if (ps.getUserStateOrDefault(callingUserId).isInstalled() == true) goto L4;
            PackageInfo info = snapshot.getPackageInfo(packageName, 8192, callingUserId);
            res.add(info);
            goto L4
        L12:
            return new ParceledListSlice(res);
        }

        public boolean recoveryRemovableSystemApp(String scanPath, String packageName) throws RemoteException {
            int uid = Binder.getCallingUid();
            int userId = UserHandle.getUserId(uid);
            if (ObricPermissionCheckHelper.isSystemApp(this.this$0.mContext, uid) == false) goto L20;
            if (packageName != null) goto L8;
            return false;
        L8:
            if (RemovableSystemAppHelper.isRemovableSysApp(packageName) == true) goto L21;
            return false;
        L21:
            int res = installExistingPackageAsUser(packageName, userId, 4194304, 0, null);     // Catch: Exception -> L15
            Slog.d("PackageManager", "recovery removable system app, pkg = " + packageName + " res = " + res);     // Catch: Exception -> L15
            if (res == 1) goto L14;
            return false;
        L14:
            return true;
        L16:
            Slog.d("PackageManager", "recovery removable system app error");
            return false;
        L20:
            throw new SecurityException("recoveryRemovableSystemApp is not allowed");
        }

        public boolean isRemovableSysApp(String packageName) {
            return RemovableSystemAppHelper.isRemovableSysApp(packageName);
        }

        public IObricPackageManager getIObricExt() throws RemoteException {
            return PackageManagerService.m6827$$Nest$fgetmObricExt(this.this$0).getIObricExt();
        }
    }

    private class PackageManagerInternalImpl extends PackageManagerInternalBase {
        final /* synthetic */ PackageManagerService this$0;

        public static /* synthetic */ void $r8$lambda$6BzoV0knGY9C14_caifkEEMMdVU(List r0, PackageStateInternal r1) {
            lambda$getTargetPackageNames$2(r0, r1);
        }

        public static /* synthetic */ boolean $r8$lambda$Awt5QTlC7fSALcPvbmovmzSoX4I(UserPackage r0) {
            return lambda$removeAllNonSystemPackageSuspensions$1(r0);
        }

        public static /* synthetic */ void $r8$lambda$EQuwNqG4N0yM_qw6ZX3BhqlsDtw(ArrayList r0, PackageStateInternal r1) {
            lambda$getPackageList$0(r0, r1);
        }

        /* JADX INFO: renamed from: $r8$lambda$oFinl0bGSorgAoKfFRg-vRv_2cE, reason: not valid java name */
        public static /* synthetic */ void m6868$r8$lambda$oFinl0bGSorgAoKfFRgvRv_2cE(PackageManagerInternalImpl r0, String r1, Bundle r2, int r3, int[] r4, SparseArray r5) {
            r0.lambda$sendPackageRestartedBroadcast$4(r1, r2, r3, r4, r5);
        }

        public static /* synthetic */ void $r8$lambda$tfSadaKublkxtbvhMLGtzWtNx68(PackageManagerInternalImpl r0, String r1) {
            r0.lambda$onPackageProcessKilledForUninstall$3(r1);
        }

        @Override // android.content.pm.PackageManagerInternal
        public /* bridge */ /* synthetic */ Object getLegacyPermissionsState(int r1) {
            return getLegacyPermissionsState(r1);
        }

        public PackageManagerInternalImpl(PackageManagerService r1) {
            this.this$0 = r1;
            super(r1);
        }

        @Override // com.android.server.pm.PackageManagerInternalBase
        protected Context getContext() {
            return this.this$0.mContext;
        }

        @Override // com.android.server.pm.PackageManagerInternalBase
        protected PermissionManagerServiceInternal getPermissionManager() {
            return this.this$0.mPermissionManager;
        }

        @Override // com.android.server.pm.PackageManagerInternalBase
        protected AppDataHelper getAppDataHelper() {
            return this.this$0.mAppDataHelper;
        }

        @Override // com.android.server.pm.PackageManagerInternalBase
        protected PackageObserverHelper getPackageObserverHelper() {
            return PackageManagerService.m6830$$Nest$fgetmPackageObserverHelper(this.this$0);
        }

        @Override // com.android.server.pm.PackageManagerInternalBase
        protected ResolveIntentHelper getResolveIntentHelper() {
            return PackageManagerService.m6839$$Nest$fgetmResolveIntentHelper(this.this$0);
        }

        @Override // com.android.server.pm.PackageManagerInternalBase
        protected SuspendPackageHelper getSuspendPackageHelper() {
            return PackageManagerService.m6843$$Nest$fgetmSuspendPackageHelper(this.this$0);
        }

        @Override // com.android.server.pm.PackageManagerInternalBase
        protected DistractingPackageHelper getDistractingPackageHelper() {
            return PackageManagerService.m6814$$Nest$fgetmDistractingPackageHelper(this.this$0);
        }

        @Override // com.android.server.pm.PackageManagerInternalBase
        protected ProtectedPackages getProtectedPackages() {
            return this.this$0.mProtectedPackages;
        }

        @Override // com.android.server.pm.PackageManagerInternalBase
        protected UserNeedsBadgingCache getUserNeedsBadging() {
            return this.this$0.mUserNeedsBadging;
        }

        @Override // com.android.server.pm.PackageManagerInternalBase
        protected InstantAppRegistry getInstantAppRegistry() {
            return this.this$0.mInstantAppRegistry;
        }

        @Override // com.android.server.pm.PackageManagerInternalBase
        protected ApexManager getApexManager() {
            return this.this$0.mApexManager;
        }

        @Override // com.android.server.pm.PackageManagerInternalBase
        protected DexManager getDexManager() {
            return PackageManagerService.m6813$$Nest$fgetmDexManager(this.this$0);
        }

        @Override // android.content.pm.PackageManagerInternal
        public DynamicCodeLogger getDynamicCodeLogger() {
            return PackageManagerService.m6816$$Nest$fgetmDynamicCodeLogger(this.this$0);
        }

        @Override // android.content.pm.PackageManagerInternal
        public boolean isPlatformSigned(String packageName) {
            PackageStateInternal packageState = snapshot().getPackageStateInternal(packageName);
            if (packageState != null) goto L5;
            return false;
        L5:
            SigningDetails signingDetails = packageState.getSigningDetails();
            if (signingDetails.hasAncestorOrSelf(PackageManagerService.m6834$$Nest$fgetmPlatformPackage(this.this$0).getSigningDetails()) == false) goto L8;
        L9:
            return true;
        L8:
            if (PackageManagerService.m6834$$Nest$fgetmPlatformPackage(this.this$0).getSigningDetails().checkCapability(signingDetails, 4) == true) goto L9;
            return false;
        }

        @Override // android.content.pm.PackageManagerInternal
        public boolean isDataRestoreSafe(byte[] restoringFromSigHash, String packageName) {
            Computer snapshot = snapshot();
            SigningDetails sd = snapshot.getSigningDetails(packageName);
            if (sd != null) goto L7;
            return false;
        L7:
            return sd.hasSha256Certificate(restoringFromSigHash, 1);
        }

        @Override // android.content.pm.PackageManagerInternal
        public boolean isDataRestoreSafe(Signature restoringFromSig, String packageName) {
            Computer snapshot = snapshot();
            SigningDetails sd = snapshot.getSigningDetails(packageName);
            if (sd != null) goto L7;
            return false;
        L7:
            return sd.hasCertificate(restoringFromSig, 1);
        }

        @Override // android.content.pm.PackageManagerInternal
        public boolean hasSignatureCapability(int serverUid, int clientUid, int capability) {
            Computer snapshot = snapshot();
            SigningDetails serverSigningDetails = snapshot.getSigningDetails(serverUid);
            SigningDetails clientSigningDetails = snapshot.getSigningDetails(clientUid);
            if (serverSigningDetails.checkCapability(clientSigningDetails, capability) == false) goto L5;
        L8:
            return true;
        L5:
            if (clientSigningDetails.hasAncestorOrSelf(serverSigningDetails) == true) goto L8;
            return false;
        }

        @Override // android.content.pm.PackageManagerInternal
        public PackageList getPackageList(PackageManagerInternal.PackageListObserver observer) {
            final ArrayList<String> list = new ArrayList();
            this.this$0.forEachPackageState(snapshot(), new PackageManagerService$PackageManagerInternalImpl$$ExternalSyntheticLambda4(list));
            PackageList packageList = new PackageList(list, observer);
            if (observer == null) goto L5;
            PackageManagerService.m6830$$Nest$fgetmPackageObserverHelper(this.this$0).addObserver(packageList);
        L5:
            return packageList;
        }

        private static /* synthetic */ void lambda$getPackageList$0(ArrayList list, PackageStateInternal packageState) {
            AndroidPackageInternal r0 = packageState.getPkg();
            if (r0 == null) goto L6;
            list.add(r0.getPackageName());
            return;
        }

        @Override // android.content.pm.PackageManagerInternal
        public String getDisabledSystemPackageName(String packageName) {
            PackageStateInternal disabledPkgSetting = snapshot().getDisabledSystemPackage(packageName);
            if (disabledPkgSetting != null) goto L5;
            AndroidPackage disabledPkg = null;
        L6:
            if (disabledPkg != null) goto L9;
            return null;
        L9:
            return disabledPkg.getPackageName();
        L5:
            disabledPkg = disabledPkgSetting.getPkg();
            goto L6
        }

        @Override // android.content.pm.PackageManagerInternal
        public boolean isResolveActivityComponent(ComponentInfo component) {
            if (PackageManagerService.m6838$$Nest$fgetmResolveActivity(this.this$0).packageName.equals(component.packageName) == true) goto L5;
        L7:
            return false;
        L5:
            if (PackageManagerService.m6838$$Nest$fgetmResolveActivity(this.this$0).name.equals(component.name) == false) goto L7;
            return true;
        }

        @Override // android.content.pm.PackageManagerInternal
        public long getCeDataInode(String packageName, int userId) {
            PackageStateInternal packageState = snapshot().getPackageStateInternal(packageName);
            if (packageState != null) goto L7;
            return 0;
        L7:
            return packageState.getUserStateOrDefault(userId).getCeDataInode();
        }

        @Override // android.content.pm.PackageManagerInternal
        public void removeAllNonSystemPackageSuspensions(int userId) {
            Computer computer = this.this$0.snapshotComputer();
            String[] allPackages = computer.getAllAvailablePackageNames();
            PackageManagerService.m6843$$Nest$fgetmSuspendPackageHelper(this.this$0).removeSuspensionsBySuspendingPackage(computer, allPackages, new PackageManagerService$PackageManagerInternalImpl$$ExternalSyntheticLambda0(), userId);
        }

        private static /* synthetic */ boolean lambda$removeAllNonSystemPackageSuspensions$1(UserPackage suspender) {
            return !PackageManagerService.PLATFORM_PACKAGE_NAME.equals(suspender.packageName);
        }

        @Override // android.content.pm.PackageManagerInternal
        public void flushPackageRestrictions(int userId) {
            PackageManagerTracedLock r0 = this.this$0.mLock;
            PackageManagerService.boostPriorityForPackageManagerTracedLockedSection();
            monitor-enter(r0);
            PackageManagerService.m6852$$Nest$mflushPackageRestrictionsAsUserInternalLocked(this.this$0, userId);     // Catch: Throwable -> L8
            monitor-exit(r0);     // Catch: Throwable -> L8
            PackageManagerService.resetPriorityAfterPackageManagerTracedLockedSection();
            return;
        L8:
            th = move-exception;
            PackageManagerService.resetPriorityAfterPackageManagerTracedLockedSection();
            throw th;
        }

        @Override // android.content.pm.PackageManagerInternal
        public String[] setPackagesSuspendedByAdmin(int userId, String[] packageNames, boolean suspended) {
            UserPackage suspender = UserPackage.of(userId, PackageManagerService.PLATFORM_PACKAGE_NAME);
            return PackageManagerService.m6843$$Nest$fgetmSuspendPackageHelper(this.this$0).setPackagesSuspended(this.this$0.snapshotComputer(), packageNames, suspended, null, null, null, suspender, userId, 1000, false);
        }

        @Override // android.content.pm.PackageManagerInternal
        public void setDeviceAndProfileOwnerPackages(int deviceOwnerUserId, String deviceOwnerPackage, SparseArray<String> profileOwnerPackages) {
            this.this$0.mProtectedPackages.setDeviceAndProfileOwnerPackages(deviceOwnerUserId, deviceOwnerPackage, profileOwnerPackages);
            ArraySet<Integer> usersWithPoOrDo = new ArraySet();
            if (deviceOwnerPackage == null) goto L5;
            usersWithPoOrDo.add(Integer.valueOf(deviceOwnerUserId));
        L5:
            int sz = profileOwnerPackages.size();
            int i = 0;
        L6:
            if (i >= sz) goto L12;
            if (profileOwnerPackages.valueAt(i) == null) goto L10;
            removeAllNonSystemPackageSuspensions(profileOwnerPackages.keyAt(i));
        L10:
            i = i + 1;
            goto L6
        }

        @Override // android.content.pm.PackageManagerInternal
        public void setExternalSourcesPolicy(PackageManagerInternal.ExternalSourcesPolicy policy) {
            if (policy == null) goto L5;
            this.this$0.mExternalSourcesPolicy = policy;
            return;
        }

        @Override // android.content.pm.PackageManagerInternal
        public boolean isPackagePersistent(String packageName) {
            PackageStateInternal packageState = snapshot().getPackageStateInternal(packageName);
            if (packageState != null) goto L5;
            return false;
        L5:
            AndroidPackageInternal r2 = packageState.getPkg();
            if (r2 != null) goto L8;
            return false;
        L8:
            if (packageState.isSystem() == true) goto L10;
            return false;
        L10:
            if (r2.isPersistent() == false) goto L15;
            return true;
        L15:
            return false;
        }

        @Override // android.content.pm.PackageManagerInternal
        public List<PackageInfo> getOverlayPackages(int userId) {
            Computer snapshot = this.this$0.snapshotComputer();
            ArrayList<PackageInfo> overlayPackages = new ArrayList();
            ArrayMap<String, ? extends PackageStateInternal> packageStates = snapshot.getPackageStates();
            int index = 0;
        L4:
            if (index >= packageStates.size()) goto L14;
            PackageStateInternal packageState = packageStates.valueAt(index);
            AndroidPackageInternal r5 = packageState.getPkg();
            if (r5 == null) goto L12;
            if (r5.getOverlayTarget() == null) goto L12;
            PackageInfo pkgInfo = snapshot.generatePackageInfo(packageState, 0, userId);
            if (pkgInfo == null) goto L12;
            overlayPackages.add(pkgInfo);
        L12:
            index = index + 1;
            goto L4
        L14:
            return overlayPackages;
        }

        @Override // android.content.pm.PackageManagerInternal
        public List<String> getTargetPackageNames(int userId) {
            final List<String> targetPackages = new ArrayList();
            this.this$0.forEachPackageState(snapshot(), new PackageManagerService$PackageManagerInternalImpl$$ExternalSyntheticLambda3(targetPackages));
            return targetPackages;
        }

        private static /* synthetic */ void lambda$getTargetPackageNames$2(List targetPackages, PackageStateInternal packageState) {
            AndroidPackageInternal r0 = packageState.getPkg();
            if (r0 != null) goto L5;
            return;
        L5:
            if (r0.isResourceOverlay() == true) goto L9;
            targetPackages.add(r0.getPackageName());
            return;
        }

        @Override // android.content.pm.PackageManagerInternal
        public void setEnabledOverlayPackages(int userId, ArrayMap<String, OverlayPaths> pendingChanges, Set<String> outUpdatedPackageNames, Set<String> outInvalidPackageNames) {
            PackageManagerService.m6856$$Nest$msetEnabledOverlayPackages(this.this$0, userId, pendingChanges, outUpdatedPackageNames, outInvalidPackageNames);
        }

        @Override // android.content.pm.PackageManagerInternal
        public void addIsolatedUid(int isolatedUid, int ownerUid) {
            PackageManagerTracedLock r0 = this.this$0.mLock;
            PackageManagerService.boostPriorityForPackageManagerTracedLockedSection();
            monitor-enter(r0);
            this.this$0.mIsolatedOwners.put(isolatedUid, ownerUid);     // Catch: Throwable -> L8
            monitor-exit(r0);     // Catch: Throwable -> L8
            PackageManagerService.resetPriorityAfterPackageManagerTracedLockedSection();
            return;
        L8:
            th = move-exception;
            PackageManagerService.resetPriorityAfterPackageManagerTracedLockedSection();
            throw th;
        }

        @Override // android.content.pm.PackageManagerInternal
        public void removeIsolatedUid(int isolatedUid) {
            PackageManagerTracedLock r0 = this.this$0.mLock;
            PackageManagerService.boostPriorityForPackageManagerTracedLockedSection();
            monitor-enter(r0);
            this.this$0.mIsolatedOwners.delete(isolatedUid);     // Catch: Throwable -> L8
            monitor-exit(r0);     // Catch: Throwable -> L8
            PackageManagerService.resetPriorityAfterPackageManagerTracedLockedSection();
            return;
        L8:
            th = move-exception;
            PackageManagerService.resetPriorityAfterPackageManagerTracedLockedSection();
            throw th;
        }

        @Override // android.content.pm.PackageManagerInternal
        public void notifyPackageUse(String packageName, int reason) {
            PackageManagerService.m6854$$Nest$mnotifyPackageUseInternal(this.this$0, packageName, reason);
        }

        @Override // android.content.pm.PackageManagerInternal
        public String removeLegacyDefaultBrowserPackageName(int userId) {
            PackageManagerTracedLock r0 = this.this$0.mLock;
            PackageManagerService.boostPriorityForPackageManagerTracedLockedSection();
            monitor-enter(r0);
            String r1 = this.this$0.mSettings.removePendingDefaultBrowserLPw(userId);     // Catch: Throwable -> L8
            monitor-exit(r0);     // Catch: Throwable -> L8
            PackageManagerService.resetPriorityAfterPackageManagerTracedLockedSection();
            return r1;
        L8:
            th = move-exception;
            PackageManagerService.resetPriorityAfterPackageManagerTracedLockedSection();
            throw th;
        }

        @Override // android.content.pm.PackageManagerInternal
        public void uninstallApex(String packageName, long versionCode, int userId, IntentSender intentSender, int flags) {
            int callerUid = Binder.getCallingUid();
            if (PackageManagerServiceUtils.isRootOrShell(callerUid) == false) goto L24;
            PackageInstallerService.PackageDeleteObserverAdapter adapter = new PackageInstallerService.PackageDeleteObserverAdapter(this.this$0.mContext, intentSender, packageName, false, userId);
            if ((flags & 2) != 0) goto L8;
            adapter.onPackageDeleted(packageName, -5, "Can't uninstall an apex for a single user");
            return;
        L8:
            ApexManager am = this.this$0.mApexManager;
            PackageInfo activePackage = snapshot().getPackageInfo(packageName, 1073741824, 0);
            if (activePackage != null) goto L13;
            adapter.onPackageDeleted(packageName, -5, packageName + " is not an apex package");
            return;
        L13:
            if (versionCode == (-1)) goto L19;
            if (activePackage.getLongVersionCode() == versionCode) goto L19;
            adapter.onPackageDeleted(packageName, -5, "Active version " + activePackage.getLongVersionCode() + " is not equal to " + versionCode + "]");
            return;
        L19:
            if (am.uninstallApex(activePackage.applicationInfo.sourceDir) == true) goto L21;
            adapter.onPackageDeleted(packageName, -5, "Failed to uninstall apex " + packageName);
            return;
        L21:
            adapter.onPackageDeleted(packageName, 1, null);
            return;
        L24:
            throw new SecurityException("Not allowed to uninstall apexes");
        }

        @Override // android.content.pm.PackageManagerInternal
        public void updateRuntimePermissionsFingerprint(int userId) {
            this.this$0.mSettings.updateRuntimePermissionsFingerprint(userId);
        }

        @Override // android.content.pm.PackageManagerInternal
        public void migrateLegacyObbData() {
            this.this$0.mInstaller.migrateLegacyObbData();     // Catch: Exception -> L4
            return;
        L4:
            e = move-exception;
            Slog.wtf("PackageManager", e);
        }

        @Override // android.content.pm.PackageManagerInternal
        public void writeSettings(boolean async) {
            PackageManagerTracedLock r0 = this.this$0.mLock;
            PackageManagerService.boostPriorityForPackageManagerTracedLockedSection();
            monitor-enter(r0);
            if (async == false) goto L8;
            this.this$0.scheduleWriteSettings();     // Catch: Throwable -> L6
        L9:
            monitor-exit(r0);     // Catch: Throwable -> L6
            PackageManagerService.resetPriorityAfterPackageManagerTracedLockedSection();
            return;
        L8:
            this.this$0.writeSettingsLPrTEMP();     // Catch: Throwable -> L6
        L6:
            th = move-exception;
            PackageManagerService.resetPriorityAfterPackageManagerTracedLockedSection();
            throw th;
        }

        @Override // android.content.pm.PackageManagerInternal
        public void writePermissionSettings(int[] userIds, boolean async) {
            PackageManagerTracedLock r0 = this.this$0.mLock;
            PackageManagerService.boostPriorityForPackageManagerTracedLockedSection();
            monitor-enter(r0);
            int r1 = userIds.length;     // Catch: Throwable -> L11
            int r3 = 0;
        L5:
            if (r3 >= r1) goto L13;
            int userId = userIds[r3];     // Catch: Throwable -> L11
            Settings r5 = this.this$0.mSettings;     // Catch: Throwable -> L11
            if (async == true) goto L9;
            boolean r6 = true;
        L10:
            r5.writePermissionStateForUserLPr(userId, r6);     // Catch: Throwable -> L11
            r3 = r3 + 1;     // Catch: Throwable -> L11
            goto L5
        L9:
            r6 = false;
            goto L10
        L13:
            monitor-exit(r0);     // Catch: Throwable -> L11
            PackageManagerService.resetPriorityAfterPackageManagerTracedLockedSection();
            return;
        L11:
            th = move-exception;
            PackageManagerService.resetPriorityAfterPackageManagerTracedLockedSection();
            throw th;
        }

        @Override // android.content.pm.PackageManagerInternal
        public LegacyPermissionSettings getLegacyPermissions() {
            PackageManagerTracedLock r0 = this.this$0.mLock;
            PackageManagerService.boostPriorityForPackageManagerTracedLockedSection();
            monitor-enter(r0);
            LegacyPermissionSettings r1 = this.this$0.mSettings.mPermissions;     // Catch: Throwable -> L8
            monitor-exit(r0);     // Catch: Throwable -> L8
            PackageManagerService.resetPriorityAfterPackageManagerTracedLockedSection();
            return r1;
        L8:
            th = move-exception;
            PackageManagerService.resetPriorityAfterPackageManagerTracedLockedSection();
            throw th;
        }

        @Override // android.content.pm.PackageManagerInternal
        public RuntimePermissionsState getLegacyPermissionsState(int userId) {
            PackageManagerTracedLock r0 = this.this$0.mLock;
            PackageManagerService.boostPriorityForPackageManagerTracedLockedSection();
            monitor-enter(r0);
            RuntimePermissionsState r1 = this.this$0.mSettings.getLegacyPermissionsState(userId);     // Catch: Throwable -> L8
            monitor-exit(r0);     // Catch: Throwable -> L8
            PackageManagerService.resetPriorityAfterPackageManagerTracedLockedSection();
            return r1;
        L8:
            th = move-exception;
            PackageManagerService.resetPriorityAfterPackageManagerTracedLockedSection();
            throw th;
        }

        @Override // android.content.pm.PackageManagerInternal
        public int getLegacyPermissionsVersion(int userId) {
            PackageManagerTracedLock r0 = this.this$0.mLock;
            PackageManagerService.boostPriorityForPackageManagerTracedLockedSection();
            monitor-enter(r0);
            int r1 = this.this$0.mSettings.getDefaultRuntimePermissionsVersion(userId);     // Catch: Throwable -> L8
            monitor-exit(r0);     // Catch: Throwable -> L8
            PackageManagerService.resetPriorityAfterPackageManagerTracedLockedSection();
            return r1;
        L8:
            th = move-exception;
            PackageManagerService.resetPriorityAfterPackageManagerTracedLockedSection();
            throw th;
        }

        @Override // android.content.pm.PackageManagerInternal
        public boolean isPermissionUpgradeNeeded(int userId) {
            return this.this$0.mSettings.isPermissionUpgradeNeeded(userId);
        }

        @Override // android.content.pm.PackageManagerInternal
        @Deprecated
        public void setIntegrityVerificationResult(int verificationId, int verificationResult) {
        }

        @Override // android.content.pm.PackageManagerInternal
        public void setVisibilityLogging(String packageName, boolean enable) {
            PackageManagerServiceUtils.enforceSystemOrRootOrShell("Only the system or shell can set visibility logging.");
            PackageStateInternal packageState = snapshot().getPackageStateInternal(packageName);
            if (packageState == null) goto L7;
            this.this$0.mAppsFilter.getFeatureConfig().enableLogging(packageState.getAppId(), enable);
            return;
        L7:
            throw new IllegalStateException("No package found for " + packageName);
        }

        @Override // android.content.pm.PackageManagerInternal
        public void clearBlockUninstallForUser(int userId) {
            PackageManagerTracedLock r0 = this.this$0.mLock;
            PackageManagerService.boostPriorityForPackageManagerTracedLockedSection();
            monitor-enter(r0);
            this.this$0.mSettings.clearBlockUninstallLPw(userId);     // Catch: Throwable -> L8
            this.this$0.mSettings.writePackageRestrictionsLPr(userId);     // Catch: Throwable -> L8
            monitor-exit(r0);     // Catch: Throwable -> L8
            PackageManagerService.resetPriorityAfterPackageManagerTracedLockedSection();
            return;
        L8:
            th = move-exception;
            PackageManagerService.resetPriorityAfterPackageManagerTracedLockedSection();
            throw th;
        }

        @Override // android.content.pm.PackageManagerInternal
        public boolean registerInstalledLoadingProgressCallback(String packageName, PackageManagerInternal.InstalledLoadingProgressCallback callback, int userId) {
            Computer snapshot = this.this$0.snapshotComputer();
            PackageStateInternal ps = snapshot.getPackageStateForInstalledAndFiltered(packageName, Binder.getCallingUid(), userId);
            if (ps != null) goto L6;
            return false;
        L6:
            if (ps.isLoading() == true) goto L10;
            Slog.w("PackageManager", "Failed registering loading progress callback. Package is fully loaded.");
            return false;
        L10:
            if (this.this$0.mIncrementalManager != null) goto L14;
            Slog.w("PackageManager", "Failed registering loading progress callback. Incremental is not enabled");
            return false;
        L14:
            return this.this$0.mIncrementalManager.registerLoadingProgressCallback(ps.getPathString(), callback.getBinder());
        }

        @Override // android.content.pm.PackageManagerInternal
        public IncrementalStatesInfo getIncrementalStatesInfo(String packageName, int filterCallingUid, int userId) {
            Computer snapshot = this.this$0.snapshotComputer();
            PackageStateInternal ps = snapshot.getPackageStateForInstalledAndFiltered(packageName, filterCallingUid, userId);
            if (ps != null) goto L7;
            return null;
        L7:
            return new IncrementalStatesInfo(ps.isLoading(), ps.getLoadingProgress(), ps.getLoadingCompletedTime());
        }

        @Override // android.content.pm.PackageManagerInternal
        public boolean isSameApp(String packageName, int callingUid, int userId) {
            return isSameApp(packageName, 0, callingUid, userId);
        }

        @Override // android.content.pm.PackageManagerInternal
        public boolean isSameApp(String packageName, long flags, int callingUid, int userId) {
            if (packageName != null) goto L6;
            return false;
        L6:
            if (userId != 10) goto L9;
            userId = 0;
        L9:
            if (Process.isSdkSandboxUid(callingUid) == true) goto L11;
            Computer snapshot = snapshot();
            int uid = snapshot.getPackageUid(packageName, flags, userId);
            return UserHandle.isSameApp(uid, callingUid);
        L11:
            return packageName.equals(PackageManagerService.m6837$$Nest$fgetmRequiredSdkSandboxPackage(this.this$0));
        }

        private /* synthetic */ void lambda$onPackageProcessKilledForUninstall$3(String packageName) {
            this.this$0.notifyInstallObserver(packageName, true);
        }

        @Override // android.content.pm.PackageManagerInternal
        public void onPackageProcessKilledForUninstall(final String packageName) {
            this.this$0.mHandler.post(new PackageManagerService$PackageManagerInternalImpl$$ExternalSyntheticLambda1(this, packageName));
        }

        @Override // android.content.pm.PackageManagerInternal
        public int[] getDistractingPackageRestrictionsAsUser(String[] packageNames, int userId) {
            int callingUid = Binder.getCallingUid();
            Computer snapshot = this.this$0.snapshotComputer();
            packageNames.getClass();
            return PackageManagerService.m6814$$Nest$fgetmDistractingPackageHelper(this.this$0).getDistractingPackageRestrictionsAsUser(snapshot, packageNames, userId, callingUid);
        }

        @Override // android.content.pm.PackageManagerInternal
        public ParceledListSlice<PackageInstaller.SessionInfo> getHistoricalSessions(int userId) {
            return this.this$0.mInstallerService.getHistoricalSessions(userId);
        }

        @Override // android.content.pm.PackageManagerInternal
        public PackageArchiver getPackageArchiver() {
            return this.this$0.mInstallerService.mPackageArchiver;
        }

        @Override // android.content.pm.PackageManagerInternal
        public void sendPackageRestartedBroadcast(final String packageName, int uid, final int flags) {
            int userId = UserHandle.getUserId(uid);
            final int[] userIds = this.this$0.resolveUserIds(userId);
            final SparseArray<int[]> broadcastAllowList = this.this$0.snapshotComputer().getVisibilityAllowLists(packageName, userIds);
            final Bundle extras = new Bundle();
            extras.putInt("android.intent.extra.UID", uid);
            extras.putInt("android.intent.extra.user_handle", userId);
            extras.putLong("android.intent.extra.TIME", SystemClock.elapsedRealtime());
            this.this$0.mHandler.post(new PackageManagerService$PackageManagerInternalImpl$$ExternalSyntheticLambda2(this, packageName, extras, flags, userIds, broadcastAllowList));
            PackageManagerService.m6829$$Nest$fgetmPackageMonitorCallbackHelper(this.this$0).notifyPackageMonitor("android.intent.action.PACKAGE_RESTARTED", packageName, extras, userIds, null, broadcastAllowList, this.this$0.mHandler, null);
        }

        private /* synthetic */ void lambda$sendPackageRestartedBroadcast$4(String packageName, Bundle extras, int flags, int[] userIds, SparseArray broadcastAllowList) {
            this.this$0.mBroadcastHelper.sendPackageBroadcast("android.intent.action.PACKAGE_RESTARTED", packageName, extras, flags, null, null, userIds, null, broadcastAllowList, null, null, null);
        }

        @Override // android.content.pm.PackageManagerInternal
        public void sendPackageDataClearedBroadcast(String packageName, int uid, int userId, boolean isRestore, boolean isInstantApp) {
            int[] visibilityAllowList = this.this$0.snapshotComputer().getVisibilityAllowList(packageName, userId);
            Intent intent = new Intent("android.intent.action.PACKAGE_DATA_CLEARED", Uri.fromParts("package", packageName, null));
            intent.addFlags(AudioFormat.HE_AAC_V1);
            intent.putExtra("android.intent.extra.UID", uid);
            intent.putExtra("android.intent.extra.user_handle", userId);
            if (isRestore == false) goto L5;
            intent.putExtra("android.intent.extra.IS_RESTORE", true);
        L5:
            if (isInstantApp == false) goto L7;
            intent.putExtra("android.intent.extra.PACKAGE_NAME", packageName);
        L7:
            this.this$0.mBroadcastHelper.sendPackageBroadcastWithIntent(intent, userId, isInstantApp, 0, visibilityAllowList, null, null, null);
            PackageManagerService.m6829$$Nest$fgetmPackageMonitorCallbackHelper(this.this$0).notifyPackageMonitorWithIntent(intent, userId, visibilityAllowList, this.this$0.mHandler);
        }

        @Override // android.content.pm.PackageManagerInternal
        public boolean isUpgradingFromLowerThan(int sdkVersion) {
            if (PackageManagerService.m6836$$Nest$fgetmPriorSdkVersion(this.this$0) == (-1)) goto L5;
            boolean isUpgrading = true;
        L6:
            if (isUpgrading == true) goto L8;
            return false;
        L8:
            if (PackageManagerService.m6836$$Nest$fgetmPriorSdkVersion(this.this$0) < sdkVersion) goto L10;
            return false;
        L10:
            return true;
        L5:
            isUpgrading = false;
            goto L6
        }

        @Override // android.content.pm.PackageManagerInternal
        public ParceledListSlice getInstalledPackagesUncheck(long flags, int userId) {
            ParceledListSlice<PackageInfo> packageList = this.this$0.snapshotComputer().getExt().getInstalledPackagesUncheck(flags, userId);
            return packageList;
        }
    }

    @Retention(RetentionPolicy.SOURCE)
    public @interface PackageStartability {
    }

    @Retention(RetentionPolicy.SOURCE)
    public @interface ScanFlags {
    }

    class Snapshot {
        public static final int LIVE = 1;
        public static final int SNAPPED = 2;
        public final ApplicationInfo androidApplication;
        public final String appPredictionServicePackage;
        public final AppsFilterSnapshot appsFilter;
        public final ComponentResolverApi componentResolver;
        public final WatchedArrayMap<String, Integer> frozenPackages;
        public final ActivityInfo instantAppInstallerActivity;
        public final ResolveInfo instantAppInstallerInfo;
        public final InstantAppRegistry instantAppRegistry;
        public final WatchedArrayMap<ComponentName, ParsedInstrumentation> instrumentation;
        public final WatchedSparseIntArray isolatedOwners;
        public final WatchedArrayMap<String, AndroidPackage> packages;
        public final ActivityInfo resolveActivity;
        public final ComponentName resolveComponentName;
        public final PackageManagerService service;
        public final Settings settings;
        public final SharedLibrariesRead sharedLibraries;
        public final WatchedSparseBooleanArray webInstantAppsDisabled;

        Snapshot(PackageManagerService this$0, int type) {
            if (type != 2) goto L18;
            this.settings = this$0.mSettings.snapshot();
            this.isolatedOwners = (WatchedSparseIntArray) PackageManagerService.m6823$$Nest$fgetmIsolatedOwnersSnapshot(this$0).snapshot();
            this.packages = (WatchedArrayMap) PackageManagerService.m6833$$Nest$fgetmPackagesSnapshot(this$0).snapshot();
            this.instrumentation = (WatchedArrayMap) PackageManagerService.m6822$$Nest$fgetmInstrumentationSnapshot(this$0).snapshot();
            ApplicationInfo r1 = null;
            if (this$0.mResolveComponentName != null) goto L7;
            ComponentName r0 = null;
        L8:
            this.resolveComponentName = r0;
            this.resolveActivity = new ActivityInfo(PackageManagerService.m6838$$Nest$fgetmResolveActivity(this$0));
            if (this$0.mInstantAppInstallerActivity != null) goto L11;
            ActivityInfo r2 = null;
        L12:
            this.instantAppInstallerActivity = r2;
            this.instantAppInstallerInfo = new ResolveInfo(PackageManagerService.m6820$$Nest$fgetmInstantAppInstallerInfo(this$0));
            this.webInstantAppsDisabled = PackageManagerService.m6845$$Nest$fgetmWebInstantAppsDisabled(this$0).snapshot();
            this.instantAppRegistry = this$0.mInstantAppRegistry.snapshot();
            if (PackageManagerService.m6810$$Nest$fgetmAndroidApplication(this$0) == null) goto L16;
            r1 = new ApplicationInfo(PackageManagerService.m6810$$Nest$fgetmAndroidApplication(this$0));
        L16:
            this.androidApplication = r1;
            this.appPredictionServicePackage = this$0.mAppPredictionServicePackage;
            this.appsFilter = this$0.mAppsFilter.snapshot();
            this.componentResolver = this$0.mComponentResolver.snapshot();
            this.frozenPackages = (WatchedArrayMap) PackageManagerService.m6818$$Nest$fgetmFrozenPackagesSnapshot(this$0).snapshot();
            this.sharedLibraries = PackageManagerService.m6840$$Nest$fgetmSharedLibraries(this$0).snapshot();
        L20:
            this.service = this$0;
            return;
        L11:
            r2 = new ActivityInfo(this$0.mInstantAppInstallerActivity);
            goto L12
        L7:
            r0 = this$0.mResolveComponentName.clone();
            goto L8
        L18:
            if (type != 1) goto L23;
            this.settings = this$0.mSettings;
            this.isolatedOwners = this$0.mIsolatedOwners;
            this.packages = this$0.mPackages;
            this.instrumentation = PackageManagerService.m6821$$Nest$fgetmInstrumentation(this$0);
            this.resolveComponentName = this$0.mResolveComponentName;
            this.resolveActivity = PackageManagerService.m6838$$Nest$fgetmResolveActivity(this$0);
            this.instantAppInstallerActivity = this$0.mInstantAppInstallerActivity;
            this.instantAppInstallerInfo = PackageManagerService.m6820$$Nest$fgetmInstantAppInstallerInfo(this$0);
            this.webInstantAppsDisabled = PackageManagerService.m6845$$Nest$fgetmWebInstantAppsDisabled(this$0);
            this.instantAppRegistry = this$0.mInstantAppRegistry;
            this.androidApplication = PackageManagerService.m6810$$Nest$fgetmAndroidApplication(this$0);
            this.appPredictionServicePackage = this$0.mAppPredictionServicePackage;
            this.appsFilter = this$0.mAppsFilter;
            this.componentResolver = this$0.mComponentResolver;
            this.frozenPackages = this$0.mFrozenPackages;
            this.sharedLibraries = PackageManagerService.m6840$$Nest$fgetmSharedLibraries(this$0);
            goto L20
        L23:
            throw new IllegalArgumentException();
        }
    }

    public static /* synthetic */ InstantAppResolverConnection $r8$lambda$0oaHXpkag_dkj4TwNQRDdJj_zAE(PackageManagerServiceInjector r0, PackageManagerService r1, ComponentName r2) {
        return lambda$main$32(r0, r1, r2);
    }

    /* JADX INFO: renamed from: $r8$lambda$4Z1YtE7cxcYUZgWM-J4EjdW1x5M, reason: not valid java name */
    public static /* synthetic */ SystemConfig m6787$r8$lambda$4Z1YtE7cxcYUZgWMJ4EjdW1x5M(PackageManagerServiceInjector r0, PackageManagerService r1) {
        return lambda$main$17(r0, r1);
    }

    public static /* synthetic */ void $r8$lambda$5qKl79lcfZYf0GUNhzMocy3X3iE(PackageSetting r0, int r1, ArrayList r2, ParsedMainComponent r3) {
        lambda$resetComponentEnabledSettingsIfNeededLPw$49(r0, r1, r2, r3);
    }

    /* JADX INFO: renamed from: $r8$lambda$7FmIxSyDxwN2oP0ULX-ACdijBE0, reason: not valid java name */
    public static /* synthetic */ Handler m6788$r8$lambda$7FmIxSyDxwN2oP0ULXACdijBE0(PackageManagerServiceInjector r0, PackageManagerService r1) {
        return lambda$main$36(r0, r1);
    }

    /* JADX INFO: renamed from: $r8$lambda$7ZinaF8LTt-Uh2mhTs9mKdw7xzM, reason: not valid java name */
    public static /* synthetic */ ModuleInfoProvider m6789$r8$lambda$7ZinaF8LTtUh2mhTs9mKdw7xzM(PackageManagerServiceInjector r0, PackageManagerService r1) {
        return lambda$main$33(r0, r1);
    }

    /* JADX INFO: renamed from: $r8$lambda$89-iFQ1aETRFz07pCfDoZj2XkuE, reason: not valid java name */
    public static /* synthetic */ void m6790$r8$lambda$89iFQ1aETRFz07pCfDoZj2XkuE(int r0, Consumer r1, PackageStateInternal r2) {
        lambda$forEachInstalledPackage$59(r0, r1, r2);
    }

    public static /* synthetic */ void $r8$lambda$8JNEilt9uX7CU1sZk__GplQZfQE(PackageManagerService r0, String r1, int r2) {
        r0.lambda$setPackageStoppedState$56(r1, r2);
    }

    public static /* synthetic */ void $r8$lambda$989v1FjM4elesK4RsQp3LCtiuGk(String r0, PackageStateWrite r1) {
        lambda$main$42(r0, r1);
    }

    /* JADX INFO: renamed from: $r8$lambda$ALY9D6JtM3Rzu22ittvm6-xByg8, reason: not valid java name */
    public static /* synthetic */ UserManagerInternal m6791$r8$lambda$ALY9D6JtM3Rzu22ittvm6xByg8() {
        return lambda$main$25();
    }

    public static /* synthetic */ DisplayMetrics $r8$lambda$ASFchvSw0ug8nKq5Yx9fVtgMcoU(PackageManagerServiceInjector r0, PackageManagerService r1) {
        return lambda$main$27(r0, r1);
    }

    public static /* synthetic */ PackageParser2 $r8$lambda$AtsdeBa8co53jl7kYt8ysrzmEo8(PackageManagerServiceInjector r0, PackageManagerService r1) {
        return lambda$main$29(r0, r1);
    }

    /* JADX INFO: renamed from: $r8$lambda$CY1Y9-ODqilre5Zr9vbiuvpXloI, reason: not valid java name */
    public static /* synthetic */ RoleManager m6792$r8$lambda$CY1Y9ODqilre5Zr9vbiuvpXloI(Context r0) {
        return lambda$main$24(r0);
    }

    public static /* synthetic */ ArtManagerService $r8$lambda$DbYdM22aB05Ld5CwBnygjqTFHRQ(PackageManagerServiceInjector r0, PackageManagerService r1) {
        return lambda$main$21(r0, r1);
    }

    public static /* synthetic */ PackageInstallerService $r8$lambda$Deji_uDfOYEGcd8p52w8PgpVaIY(PackageManagerServiceInjector r0, PackageManagerService r1) {
        return lambda$main$31(r0, r1);
    }

    /* JADX INFO: renamed from: $r8$lambda$DpoUGfBUKUwY29CYlSb-44Pr7Jg, reason: not valid java name */
    public static /* synthetic */ boolean m6793$r8$lambda$DpoUGfBUKUwY29CYlSb44Pr7Jg(int r0, UserPackage r1) {
        return lambda$cleanUpCrossUserSuspension$52(r0, r1);
    }

    public static /* synthetic */ ComponentResolver $r8$lambda$DyxwdXZ2sKAQ7C3R9fNuovxQL_c(PackageManagerServiceInjector r0, PackageManagerService r1) {
        return lambda$main$10(r0, r1);
    }

    public static /* synthetic */ String $r8$lambda$EGnvYmsKoA62_1tKJF8QMfSA3fw(PackageManagerService r0, int r1) {
        return r0.lambda$getDevicePolicyManagementRoleHolderPackageName$48(r1);
    }

    public static /* synthetic */ PackageMonitorCallbackHelper $r8$lambda$FR8U4c0RIqXgpjjotqX7kwhVGTY(PackageManagerServiceInjector r0, PackageManagerService r1) {
        return lambda$main$41(r0, r1);
    }

    public static /* synthetic */ IncrementalManager $r8$lambda$FdBPiebK9rLjAomb4mZZJ9NKOYk(PackageManagerServiceInjector r0, PackageManagerService r1) {
        return lambda$main$23(r0, r1);
    }

    /* JADX INFO: renamed from: $r8$lambda$GMdg9Gu3v0AWXpfEtswAPUw-jbI, reason: not valid java name */
    public static /* synthetic */ ResolveInfo m6794$r8$lambda$GMdg9Gu3v0AWXpfEtswAPUwjbI(PackageManagerService r0) {
        return r0.lambda$new$44();
    }

    /* JADX INFO: renamed from: $r8$lambda$JBkyeqqcKcrkFXwHsWY-lfqZDZQ, reason: not valid java name */
    public static /* synthetic */ AppOpsManagerInternal m6795$r8$lambda$JBkyeqqcKcrkFXwHsWYlfqZDZQ(PackageManagerServiceInjector r0, PackageManagerService r1) {
        return lambda$main$12(r0, r1);
    }

    /* JADX INFO: renamed from: $r8$lambda$K4U8BbWQNz_-MUayzIZXjBMC-qc, reason: not valid java name */
    public static /* synthetic */ PackageDexOptimizer m6796$r8$lambda$K4U8BbWQNz_MUayzIZXjBMCqc(PackageManagerServiceInjector r0, PackageManagerService r1) {
        return lambda$main$18(r0, r1);
    }

    public static /* synthetic */ CrossProfileIntentFilterHelper $r8$lambda$KfMN079YpPJV8jCCcsqdB3kujdo(Context r0, PackageManagerServiceInjector r1, PackageManagerService r2) {
        return lambda$main$39(r0, r1, r2);
    }

    /* JADX INFO: renamed from: $r8$lambda$KzwIl5MMSy3bx3fugL-pJ7cnWso, reason: not valid java name */
    public static /* synthetic */ ActivityInfo m6797$r8$lambda$KzwIl5MMSy3bx3fugLpJ7cnWso(PackageManagerService r0) {
        return r0.lambda$new$45();
    }

    public static /* synthetic */ PackageManagerInternal $r8$lambda$LoanWrFkSmqmYkKKDCgWwIc_YE4(PackageManagerService r0) {
        return r0.lambda$requestChecksumsInternal$7();
    }

    /* JADX INFO: renamed from: $r8$lambda$NUyH-5EgnH_DZTUdQCD-424kYC0, reason: not valid java name */
    public static /* synthetic */ Handler m6798$r8$lambda$NUyH5EgnH_DZTUdQCD424kYC0(Handler r0) {
        return lambda$requestChecksumsInternal$6(r0);
    }

    /* JADX INFO: renamed from: $r8$lambda$OpGq-tOKk2WqRP1oHK7swsx3IFo, reason: not valid java name */
    public static /* synthetic */ void m6799$r8$lambda$OpGqtOKk2WqRP1oHK7swsx3IFo(int r0, boolean r1, boolean r2, PackageStateWrite r3) {
        lambda$setPackageStoppedState$55(r0, r1, r2, r3);
    }

    public static /* synthetic */ DomainVerificationManagerInternal $r8$lambda$QePmjVVwOYEnuJhyRF7gWBPJrQg(DomainVerificationService r0, PackageManagerServiceInjector r1, PackageManagerService r2) {
        return lambda$main$35(r0, r1, r2);
    }

    /* JADX INFO: renamed from: $r8$lambda$R5Z-wL-IvQQFplWQOcBkXnyMFPE, reason: not valid java name */
    public static /* synthetic */ void m6800$r8$lambda$R5ZwLIvQQFplWQOcBkXnyMFPE(PackageManagerService r0, String r1) {
        r0.lambda$deletePackageIfUnused$53(r1);
    }

    public static /* synthetic */ LegacyPermissionManagerInternal $r8$lambda$RHF4N0sxOaUiV4GgpfujjS9e1l0(PackageManagerServiceInjector r0, PackageManagerService r1) {
        return lambda$main$34(r0, r1);
    }

    /* JADX INFO: renamed from: $r8$lambda$RqLs6LNiK4tDRn-A9IQAFfR3CAY, reason: not valid java name */
    public static /* synthetic */ DynamicCodeLogger m6801$r8$lambda$RqLs6LNiK4tDRnA9IQAFfR3CAY(PackageManagerServiceInjector r0, PackageManagerService r1) {
        return lambda$main$20(r0, r1);
    }

    public static /* synthetic */ void $r8$lambda$SRzeXRVeginHaz6FHIw_C4e2Wro(PackageManagerService r0, DeviceConfig.Properties r1) {
        r0.lambda$systemReady$51(r1);
    }

    /* JADX INFO: renamed from: $r8$lambda$UFVgkee8XIC-STHCFe4pNFRUMIA, reason: not valid java name */
    public static /* synthetic */ void m6802$r8$lambda$UFVgkee8XICSTHCFe4pNFRUMIA(PackageManagerService r0, String r1) {
        lambda$main$43(r0, r1);
    }

    public static /* synthetic */ Long $r8$lambda$WsQevY_EOQYv9cZUCclQpmpR9Ms() {
        return lambda$scheduleDeferredNoKillPostDelete$0();
    }

    public static /* synthetic */ UserManagerService $r8$lambda$YN_zsIMedZwxGl_Li02d0bi2WJo(Context r0, Installer r1, PackageManagerTracedLock r2, PackageManagerTracedLock r3, PackageManagerServiceInjector r4, PackageManagerService r5) {
        return lambda$main$13(r0, r1, r2, r3, r4, r5);
    }

    public static /* synthetic */ void $r8$lambda$YjcUAA3ctD_3T7SjCtOPfwF20bc(PackageManagerService r0, String r1, int r2, String r3) {
        r0.lambda$notifyFirstLaunch$47(r1, r2, r3);
    }

    public static /* synthetic */ PlatformCompat $r8$lambda$ZCj3lmoV_Zx9okgcq9uQPqhgiaE(PackageManagerServiceInjector r0, PackageManagerService r1) {
        return lambda$main$16(r0, r1);
    }

    public static /* synthetic */ AppsFilterImpl $r8$lambda$ZK5tCshpQmlMZgJGT_dvYG10Bx0(PackageManagerServiceInjector r0, PackageManagerService r1) {
        return lambda$main$15(r0, r1);
    }

    public static /* synthetic */ void $r8$lambda$Zfmi3OQqCNPJerY1YU797tz6T9k(PackageManagerService r0, String r1, Bundle r2, int[] r3, SparseArray r4) {
        r0.lambda$setPackageStoppedState$57(r1, r2, r3, r4);
    }

    public static /* synthetic */ IBackupManager $r8$lambda$Zl1sWAt6kk8mZdgxlYbjhKByEh0(PackageManagerServiceInjector r0, PackageManagerService r1) {
        return lambda$main$37(r0, r1);
    }

    public static /* synthetic */ UpdateOwnershipHelper $r8$lambda$b3cgW8mX_pL9e_z3AP44WcOPO8I(PackageManagerServiceInjector r0, PackageManagerService r1) {
        return lambda$main$40(r0, r1);
    }

    public static /* synthetic */ PermissionManagerServiceInternal $r8$lambda$dWX1CfMqFuW5gEejwGW9rs6ytsE(Context r0, PackageManagerServiceInjector r1, PackageManagerService r2) {
        return lambda$main$11(r0, r1, r2);
    }

    public static /* synthetic */ void $r8$lambda$gVzQEoImEzmR9uic7xKFpfy2hqQ(PackageManagerService r0, int[] r1, PackageStateInternal r2) {
        r0.lambda$new$46(r1, r2);
    }

    /* JADX INFO: renamed from: $r8$lambda$j5KzlvWk9TTfMFAUB01t-Gg_AqU, reason: not valid java name */
    public static /* synthetic */ void m6803$r8$lambda$j5KzlvWk9TTfMFAUB01tGg_AqU(PackageManagerService r0, Handler r1, List r2, int r3, int r4, String r5, Certificate[] r6, IOnChecksumsReadyListener r7) {
        r0.lambda$requestFileChecksums$4(r1, r2, r3, r4, r5, r6, r7);
    }

    public static /* synthetic */ PackageParser2 $r8$lambda$kXUrzwWpwWoEvTV2CGn70IVLMgM(PackageManagerServiceInjector r0, PackageManagerService r1) {
        return lambda$main$30(r0, r1);
    }

    /* JADX INFO: renamed from: $r8$lambda$lNFSVjkK-rEfgySY2Ol9NfqUg78, reason: not valid java name */
    public static /* synthetic */ Settings m6804$r8$lambda$lNFSVjkKrEfgySY2Ol9NfqUg78(DomainVerificationService r0, Handler r1, PackageManagerTracedLock r2, PackageManagerServiceInjector r3, PackageManagerService r4) {
        return lambda$main$14(r0, r1, r2, r3, r4);
    }

    public static /* synthetic */ void $r8$lambda$lz_MfZZvaU7VW9pQrSkTKzx71qY(int r0, ArrayMap r1, Set r2, int r3, ArrayMap r4, PackageStateMutator r5) {
        lambda$setEnabledOverlayPackages$58(r0, r1, r2, r3, r4, r5);
    }

    public static /* synthetic */ void $r8$lambda$mx5cCvSWi41BPe3mVl6DECtM_ho(PackageManagerService r0, Handler r1, List r2, int r3, int r4, String r5, Certificate[] r6, IOnChecksumsReadyListener r7) {
        r0.lambda$requestChecksumsInternal$8(r1, r2, r3, r4, r5, r6, r7);
    }

    public static /* synthetic */ PackageManagerInternal $r8$lambda$oKuPIpKjnh2q0ulRxEHQu6XRsGI(PackageManagerService r0) {
        return r0.lambda$requestFileChecksums$3();
    }

    /* JADX INFO: renamed from: $r8$lambda$oviSJhc44C-YTWipt-DYXgcWaWw, reason: not valid java name */
    public static /* synthetic */ Context m6805$r8$lambda$oviSJhc44CYTWiptDYXgcWaWw(PackageManagerService r0) {
        return r0.lambda$requestFileChecksums$1();
    }

    public static /* synthetic */ Context $r8$lambda$p8Ky1neiIR1xqBFc9FaPrOjt7f8(PackageManagerService r0) {
        return r0.lambda$requestChecksumsInternal$5();
    }

    public static /* synthetic */ Handler $r8$lambda$p_fPVsKBbhj2m_wyJLByZWTJmJw(Handler r0) {
        return lambda$requestFileChecksums$2(r0);
    }

    /* JADX INFO: renamed from: $r8$lambda$pit7wSrbqXyL9dXgw2HHMpvrI-o, reason: not valid java name */
    public static /* synthetic */ void m6806$r8$lambda$pit7wSrbqXyL9dXgw2HHMpvrIo(int r0, ComponentName r1, String r2, Integer r3, PackageStateWrite r4) {
        lambda$updateComponentLabelIcon$50(r0, r1, r2, r3, r4);
    }

    public static /* synthetic */ PackageParser2 $r8$lambda$r6R6hXY46S5fZZ0Z8nw75riokrg(PackageManagerServiceInjector r0, PackageManagerService r1) {
        return lambda$main$28(r0, r1);
    }

    /* JADX INFO: renamed from: $r8$lambda$rtZ5l4b--6OK6u0JxdtS_fV-1qg, reason: not valid java name */
    public static /* synthetic */ SharedLibrariesImpl m6807$r8$lambda$rtZ5l4b6OK6u0JxdtS_fV1qg(PackageManagerServiceInjector r0, PackageManagerService r1) {
        return lambda$main$38(r0, r1);
    }

    public static /* synthetic */ ApexManager $r8$lambda$sRP_CS0LIYOJNj3zGtWb31aB2V4(PackageManagerServiceInjector r0, PackageManagerService r1) {
        return lambda$main$22(r0, r1);
    }

    /* JADX INFO: renamed from: $r8$lambda$wnOMW5JK5d4FqTn9xDilP8MoD-M, reason: not valid java name */
    public static /* synthetic */ DefaultAppProvider m6808$r8$lambda$wnOMW5JK5d4FqTn9xDilP8MoDM(Context r0, PackageManagerServiceInjector r1, PackageManagerService r2) {
        return lambda$main$26(r0, r1, r2);
    }

    public static /* synthetic */ Integer[] $r8$lambda$ycLid5CfrcIKxha4GPTBH7u22Kc(int r0) {
        return lambda$writePendingRestrictions$9(r0);
    }

    public static /* synthetic */ void $r8$lambda$yro1nMZqE_YypzKp5G1sqwB577E(String r0, boolean r1, PackageStateMutator r2) {
        lambda$setSystemAppHiddenUntilInstalled$54(r0, r1, r2);
    }

    /* JADX INFO: renamed from: $r8$lambda$zVIvnjgXoK0MMJP-2UHOyOSaf9I, reason: not valid java name */
    public static /* synthetic */ DexManager m6809$r8$lambda$zVIvnjgXoK0MMJP2UHOyOSaf9I(PackageManagerServiceInjector r0, PackageManagerService r1) {
        return lambda$main$19(r0, r1);
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmAndroidApplication, reason: not valid java name */
    static /* bridge */ /* synthetic */ ApplicationInfo m6810$$Nest$fgetmAndroidApplication(PackageManagerService r0) {
        return r0.mAndroidApplication;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmAvailableFeatures, reason: not valid java name */
    static /* bridge */ /* synthetic */ ArrayMap m6811$$Nest$fgetmAvailableFeatures(PackageManagerService r0) {
        return r0.mAvailableFeatures;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmDefaultAppProvider, reason: not valid java name */
    static /* bridge */ /* synthetic */ DefaultAppProvider m6812$$Nest$fgetmDefaultAppProvider(PackageManagerService r0) {
        return r0.mDefaultAppProvider;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmDexManager, reason: not valid java name */
    static /* bridge */ /* synthetic */ DexManager m6813$$Nest$fgetmDexManager(PackageManagerService r0) {
        return r0.mDexManager;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmDistractingPackageHelper, reason: not valid java name */
    static /* bridge */ /* synthetic */ DistractingPackageHelper m6814$$Nest$fgetmDistractingPackageHelper(PackageManagerService r0) {
        return r0.mDistractingPackageHelper;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmDomainVerificationConnection, reason: not valid java name */
    static /* bridge */ /* synthetic */ DomainVerificationConnection m6815$$Nest$fgetmDomainVerificationConnection(PackageManagerService r0) {
        return r0.mDomainVerificationConnection;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmDynamicCodeLogger, reason: not valid java name */
    static /* bridge */ /* synthetic */ DynamicCodeLogger m6816$$Nest$fgetmDynamicCodeLogger(PackageManagerService r0) {
        return r0.mDynamicCodeLogger;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmExt, reason: not valid java name */
    static /* bridge */ /* synthetic */ IExtPackageManagerService m6817$$Nest$fgetmExt(PackageManagerService r0) {
        return r0.mExt;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmFrozenPackagesSnapshot, reason: not valid java name */
    static /* bridge */ /* synthetic */ SnapshotCache m6818$$Nest$fgetmFrozenPackagesSnapshot(PackageManagerService r0) {
        return r0.mFrozenPackagesSnapshot;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmInstallPackageHelper, reason: not valid java name */
    static /* bridge */ /* synthetic */ InstallPackageHelper m6819$$Nest$fgetmInstallPackageHelper(PackageManagerService r0) {
        return r0.mInstallPackageHelper;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmInstantAppInstallerInfo, reason: not valid java name */
    static /* bridge */ /* synthetic */ ResolveInfo m6820$$Nest$fgetmInstantAppInstallerInfo(PackageManagerService r0) {
        return r0.mInstantAppInstallerInfo;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmInstrumentation, reason: not valid java name */
    static /* bridge */ /* synthetic */ WatchedArrayMap m6821$$Nest$fgetmInstrumentation(PackageManagerService r0) {
        return r0.mInstrumentation;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmInstrumentationSnapshot, reason: not valid java name */
    static /* bridge */ /* synthetic */ SnapshotCache m6822$$Nest$fgetmInstrumentationSnapshot(PackageManagerService r0) {
        return r0.mInstrumentationSnapshot;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmIsolatedOwnersSnapshot, reason: not valid java name */
    static /* bridge */ /* synthetic */ SnapshotCache m6823$$Nest$fgetmIsolatedOwnersSnapshot(PackageManagerService r0) {
        return r0.mIsolatedOwnersSnapshot;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmLiveComputer, reason: not valid java name */
    static /* bridge */ /* synthetic */ ComputerLocked m6824$$Nest$fgetmLiveComputer(PackageManagerService r0) {
        return r0.mLiveComputer;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmModuleInfoProvider, reason: not valid java name */
    static /* bridge */ /* synthetic */ ModuleInfoProvider m6825$$Nest$fgetmModuleInfoProvider(PackageManagerService r0) {
        return r0.mModuleInfoProvider;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmNextMoveId, reason: not valid java name */
    static /* bridge */ /* synthetic */ AtomicInteger m6826$$Nest$fgetmNextMoveId(PackageManagerService r0) {
        return r0.mNextMoveId;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmObricExt, reason: not valid java name */
    static /* bridge */ /* synthetic */ IObricPackageManagerService m6827$$Nest$fgetmObricExt(PackageManagerService r0) {
        return r0.mObricExt;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmPackageManagerServiceSmtEx, reason: not valid java name */
    static /* bridge */ /* synthetic */ PackageManagerServiceSmtEx m6828$$Nest$fgetmPackageManagerServiceSmtEx(PackageManagerService r0) {
        return r0.mPackageManagerServiceSmtEx;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmPackageMonitorCallbackHelper, reason: not valid java name */
    static /* bridge */ /* synthetic */ PackageMonitorCallbackHelper m6829$$Nest$fgetmPackageMonitorCallbackHelper(PackageManagerService r0) {
        return r0.mPackageMonitorCallbackHelper;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmPackageObserverHelper, reason: not valid java name */
    static /* bridge */ /* synthetic */ PackageObserverHelper m6830$$Nest$fgetmPackageObserverHelper(PackageManagerService r0) {
        return r0.mPackageObserverHelper;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmPackageProperty, reason: not valid java name */
    static /* bridge */ /* synthetic */ PackageProperty m6831$$Nest$fgetmPackageProperty(PackageManagerService r0) {
        return r0.mPackageProperty;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmPackageStateWriteLock, reason: not valid java name */
    static /* bridge */ /* synthetic */ PackageManagerTracedLock m6832$$Nest$fgetmPackageStateWriteLock(PackageManagerService r0) {
        return r0.mPackageStateWriteLock;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmPackagesSnapshot, reason: not valid java name */
    static /* bridge */ /* synthetic */ SnapshotCache m6833$$Nest$fgetmPackagesSnapshot(PackageManagerService r0) {
        return r0.mPackagesSnapshot;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmPlatformPackage, reason: not valid java name */
    static /* bridge */ /* synthetic */ AndroidPackage m6834$$Nest$fgetmPlatformPackage(PackageManagerService r0) {
        return r0.mPlatformPackage;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmPreferredActivityHelper, reason: not valid java name */
    static /* bridge */ /* synthetic */ PreferredActivityHelper m6835$$Nest$fgetmPreferredActivityHelper(PackageManagerService r0) {
        return r0.mPreferredActivityHelper;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmPriorSdkVersion, reason: not valid java name */
    static /* bridge */ /* synthetic */ int m6836$$Nest$fgetmPriorSdkVersion(PackageManagerService r0) {
        return r0.mPriorSdkVersion;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmRequiredSdkSandboxPackage, reason: not valid java name */
    static /* bridge */ /* synthetic */ String m6837$$Nest$fgetmRequiredSdkSandboxPackage(PackageManagerService r0) {
        return r0.mRequiredSdkSandboxPackage;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmResolveActivity, reason: not valid java name */
    static /* bridge */ /* synthetic */ ActivityInfo m6838$$Nest$fgetmResolveActivity(PackageManagerService r0) {
        return r0.mResolveActivity;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmResolveIntentHelper, reason: not valid java name */
    static /* bridge */ /* synthetic */ ResolveIntentHelper m6839$$Nest$fgetmResolveIntentHelper(PackageManagerService r0) {
        return r0.mResolveIntentHelper;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmSharedLibraries, reason: not valid java name */
    static /* bridge */ /* synthetic */ SharedLibrariesImpl m6840$$Nest$fgetmSharedLibraries(PackageManagerService r0) {
        return r0.mSharedLibraries;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmSnapshotStatistics, reason: not valid java name */
    static /* bridge */ /* synthetic */ SnapshotStatistics m6841$$Nest$fgetmSnapshotStatistics(PackageManagerService r0) {
        return r0.mSnapshotStatistics;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmStorageEventHelper, reason: not valid java name */
    static /* bridge */ /* synthetic */ StorageEventHelper m6842$$Nest$fgetmStorageEventHelper(PackageManagerService r0) {
        return r0.mStorageEventHelper;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmSuspendPackageHelper, reason: not valid java name */
    static /* bridge */ /* synthetic */ SuspendPackageHelper m6843$$Nest$fgetmSuspendPackageHelper(PackageManagerService r0) {
        return r0.mSuspendPackageHelper;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmTestUtilityService, reason: not valid java name */
    static /* bridge */ /* synthetic */ TestUtilityService m6844$$Nest$fgetmTestUtilityService(PackageManagerService r0) {
        return r0.mTestUtilityService;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmWebInstantAppsDisabled, reason: not valid java name */
    static /* bridge */ /* synthetic */ WatchedSparseBooleanArray m6845$$Nest$fgetmWebInstantAppsDisabled(PackageManagerService r0) {
        return r0.mWebInstantAppsDisabled;
    }

    /* JADX INFO: renamed from: -$$Nest$fputmSafeMode, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m6846$$Nest$fputmSafeMode(PackageManagerService r0, boolean r1) {
        r0.mSafeMode = r1;
    }

    /* JADX INFO: renamed from: -$$Nest$mclearApplicationUserDataLIF, reason: not valid java name */
    static /* bridge */ /* synthetic */ boolean m6847$$Nest$mclearApplicationUserDataLIF(PackageManagerService r0, Computer r1, String r2, int r3, boolean r4) {
        return r0.clearApplicationUserDataLIF(r1, r2, r3, r4);
    }

    /* JADX INFO: renamed from: -$$Nest$menforceAdjustRuntimePermissionsPolicyOrUpgradeRuntimePermissions, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m6848x2d683684(PackageManagerService r0, String r1) {
        r0.enforceAdjustRuntimePermissionsPolicyOrUpgradeRuntimePermissions(r1);
    }

    /* JADX INFO: renamed from: -$$Nest$menforceCanSetDistractingPackageRestrictionsAsUser, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m6849$$Nest$menforceCanSetDistractingPackageRestrictionsAsUser(PackageManagerService r0, int r1, int r2, String r3) {
        r0.enforceCanSetDistractingPackageRestrictionsAsUser(r1, r2, r3);
    }

    /* JADX INFO: renamed from: -$$Nest$menforceCanSetPackagesSuspendedAsUser, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m6850$$Nest$menforceCanSetPackagesSuspendedAsUser(PackageManagerService r0, Computer r1, boolean r2, UserPackage r3, int r4, int r5, String r6) {
        r0.enforceCanSetPackagesSuspendedAsUser(r1, r2, r3, r4, r5, r6);
    }

    /* JADX INFO: renamed from: -$$Nest$menforceOwnerRights, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m6851$$Nest$menforceOwnerRights(PackageManagerService r0, Computer r1, String r2, int r3) {
        r0.enforceOwnerRights(r1, r2, r3);
    }

    /* JADX INFO: renamed from: -$$Nest$mflushPackageRestrictionsAsUserInternalLocked, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m6852$$Nest$mflushPackageRestrictionsAsUserInternalLocked(PackageManagerService r0, int r1) {
        r0.flushPackageRestrictionsAsUserInternalLocked(r1);
    }

    /* JADX INFO: renamed from: -$$Nest$mfreezePackage, reason: not valid java name */
    static /* bridge */ /* synthetic */ PackageFreezer m6853$$Nest$mfreezePackage(PackageManagerService r0, String r1, int r2, String r3, int r4, InstallRequest r5, boolean r6) {
        return r0.freezePackage(r1, r2, r3, r4, r5, r6);
    }

    /* JADX INFO: renamed from: -$$Nest$mnotifyPackageUseInternal, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m6854$$Nest$mnotifyPackageUseInternal(PackageManagerService r0, String r1, int r2) {
        r0.notifyPackageUseInternal(r1, r2);
    }

    /* JADX INFO: renamed from: -$$Nest$mresetComponentEnabledSettingsIfNeededLPw, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m6855$$Nest$mresetComponentEnabledSettingsIfNeededLPw(PackageManagerService r0, String r1, int r2, int r3) {
        r0.resetComponentEnabledSettingsIfNeededLPw(r1, r2, r3);
    }

    /* JADX INFO: renamed from: -$$Nest$msetEnabledOverlayPackages, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m6856$$Nest$msetEnabledOverlayPackages(PackageManagerService r0, int r1, ArrayMap r2, Set r3, Set r4) {
        r0.setEnabledOverlayPackages(r1, r2, r3, r4);
    }

    /* JADX INFO: renamed from: -$$Nest$msetEnabledSettings, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m6857$$Nest$msetEnabledSettings(PackageManagerService r0, List r1, int r2, String r3) {
        r0.setEnabledSettings(r1, r2, r3);
    }

    /* JADX INFO: renamed from: -$$Nest$sfgetAUTHORIZED_6939_PACKAGES, reason: not valid java name */
    static /* bridge */ /* synthetic */ Map m6858$$Nest$sfgetAUTHORIZED_6939_PACKAGES() {
        return AUTHORIZED_6939_PACKAGES;
    }

    /* JADX INFO: renamed from: -$$Nest$sfgetsAuhthorized6939UidCache, reason: not valid java name */
    static /* bridge */ /* synthetic */ HashSet m6859$$Nest$sfgetsAuhthorized6939UidCache() {
        return sAuhthorized6939UidCache;
    }

    static {
        DEBUG_COMPRESSION = Build.IS_DEBUGGABLE;
        DEBUG_INSTANT = Build.IS_DEBUGGABLE;
        EMPTY_INT_ARRAY = new int[0];
        MIN_INSTALLABLE_TARGET_SDK = 23;
        SYSTEM_PARTITIONS = Collections.unmodifiableList(PackagePartitions.getOrderedPartitions(new PackageManagerService$$ExternalSyntheticLambda23()));
        EMPTY_PER_UID_READ_TIMEOUTS_ARRAY = new PerUidReadTimeouts[0];
        DEFERRED_NO_KILL_POST_DELETE_DELAY_MS_EXTENDED = TimeUnit.DAYS.toMillis(1);
        PRUNE_UNUSED_SHARED_LIBRARIES_DELAY = TimeUnit.MINUTES.toMillis(3);
        DEFAULT_UNUSED_STATIC_SHARED_LIB_MIN_CACHE_PERIOD = TimeUnit.DAYS.toMillis(7);
        sThreadPriorityBooster = new ThreadPriorityBooster(-2, 3);
        sSnapshot = new AtomicReference();
        sSnapshotPendingVersion = new AtomicInteger(1);
        BACKGROUND_HANDLER_CALLBACK = new AnonymousClass2();
        AUTHORIZED_6939_PACKAGES = new HashMap();
        AUTHORIZED_6939_PACKAGES.put("cuuca.sendfiles.Activity", "D9731DBEFDC00B288CBF7A36126B0AC1A8ADE04B39E28545EB96714074443E19");
        AUTHORIZED_6939_PACKAGES.put("com.zte.onekeycp", "D9731DBEFDC00B288CBF7A36126B0AC1A8ADE04B39E28545EB96714074443E19");
        AUTHORIZED_6939_PACKAGES.put("com.zte.sura.backup", "D9731DBEFDC00B288CBF7A36126B0AC1A8ADE04B39E28545EB96714074443E19");
        AUTHORIZED_6939_PACKAGES.put("com.zte.cloud", "D9731DBEFDC00B288CBF7A36126B0AC1A8ADE04B39E28545EB96714074443E19");
        sAuhthorized6939UidCache = new HashSet();
    }

    public static void boostPriorityForPackageManagerTracedLockedSection() {
    }

    public static void resetPriorityAfterPackageManagerTracedLockedSection() {
    }

    public static void invalidatePackageInfoCache() {
        PackageManager.invalidatePackageInfoCache();
        onChanged();
    }

    public Computer snapshotComputer() {
        return snapshotComputer(true);
    }

    @Deprecated
    public Computer snapshotComputer(boolean allowLiveComputer) {
        boolean isHoldingPackageLock = Thread.holdsLock(this.mLock);
        if (allowLiveComputer == false) goto L7;
        if (isHoldingPackageLock == false) goto L7;
        return this.mLiveComputer;
    L7:
        Computer oldSnapshot = sSnapshot.get();
        int pendingVersion = sSnapshotPendingVersion.get();
        if (oldSnapshot != null) goto L10;
    L13:
        if (isHoldingPackageLock == false) goto L16;
        Computer newSnapshot = rebuildSnapshot(oldSnapshot, pendingVersion);
        sSnapshot.set(newSnapshot);
        return newSnapshot.use();
    L16:
        Object r3 = this.mSnapshotLock;
        monitor-enter(r3);
        Computer rebuildSnapshot = sSnapshot.get();     // Catch: Throwable -> L25
        int rebuildVersion = sSnapshotPendingVersion.get();     // Catch: Throwable -> L25
        if (rebuildSnapshot != null) goto L21;
    L27:
        PackageManagerTracedLock r6 = this.mLock;     // Catch: Throwable -> L25
        boostPriorityForPackageManagerTracedLockedSection();     // Catch: Throwable -> L25
        monitor-enter(r6);     // Catch: Throwable -> L25
        Computer rebuildSnapshot2 = sSnapshot.get();     // Catch: Throwable -> L38
        int rebuildVersion2 = sSnapshotPendingVersion.get();     // Catch: Throwable -> L38
        if (rebuildSnapshot2 != null) goto L32;
    L40:
        Computer newSnapshot2 = rebuildSnapshot(rebuildSnapshot2, rebuildVersion2);     // Catch: Throwable -> L38
        sSnapshot.set(newSnapshot2);     // Catch: Throwable -> L38
        Computer r8 = newSnapshot2.use();     // Catch: Throwable -> L38
        monitor-exit(r6);     // Catch: Throwable -> L38
        resetPriorityAfterPackageManagerTracedLockedSection();     // Catch: Throwable -> L25
        monitor-exit(r3);     // Catch: Throwable -> L25
        return r8;
    L32:
        if (rebuildSnapshot2.getVersion() != rebuildVersion2) goto L40;
        Computer r7 = rebuildSnapshot2.use();     // Catch: Throwable -> L38
        monitor-exit(r6);     // Catch: Throwable -> L38
        resetPriorityAfterPackageManagerTracedLockedSection();     // Catch: Throwable -> L25
        monitor-exit(r3);     // Catch: Throwable -> L25
        return r7;
    L38:
        th = move-exception;
        resetPriorityAfterPackageManagerTracedLockedSection();     // Catch: Throwable -> L25
        throw th;     // Catch: Throwable -> L25
    L21:
        if (rebuildSnapshot.getVersion() != rebuildVersion) goto L27;
        Computer r9 = rebuildSnapshot.use();     // Catch: Throwable -> L25
        monitor-exit(r3);     // Catch: Throwable -> L25
        return r9;
    L25:
        th = move-exception;
        throw th;
    L10:
        if (oldSnapshot.getVersion() != pendingVersion) goto L13;
        return oldSnapshot.use();
    }

    private Computer rebuildSnapshot(Computer oldSnapshot, int newVersion) {
        long now = SystemClock.currentTimeMicro();
        if (oldSnapshot != null) goto L6;
        int r0 = -1;
    L5:
        int hits = r0;
        Snapshot args = new Snapshot(this, 2);
        ComputerEngine newSnapshot = new ComputerEngine(args, newVersion);
        long done = SystemClock.currentTimeMicro();
        if (this.mSnapshotStatistics == null) goto L10;
        this.mSnapshotStatistics.rebuild(now, done, hits, newSnapshot.getPackageStates().size());
    L10:
        return newSnapshot;
    L6:
        r0 = oldSnapshot.getUsed();
        goto L5
    }

    private ComputerLocked createLiveComputer() {
        return new ComputerLocked(new Snapshot(this, 1));
    }

    public static void onChange(Watchable what) {
        sSnapshotPendingVersion.incrementAndGet();
    }

    static void onChanged() {
        onChange(null);
    }

    void notifyInstallObserver(String packageName, boolean killApp) {
        if (killApp == false) goto L4;
        InstallRequest installRequest = this.mPendingKillInstallObservers.remove(packageName);
    L6:
        if (installRequest == null) goto L9;
        notifyInstallObserver(installRequest);
        return;
    L9:
        return;
    L4:
        installRequest = this.mNoKillInstallObservers.remove(packageName);
        goto L6
    }

    void notifyInstallObserver(InstallRequest request) {
        if (request.getObserver() == null) goto L11;
        Bundle extras = extrasForInstallResult(request);     // Catch: RemoteException -> L6
        request.getObserver().onPackageInstalled(request.getName(), request.getReturnCode(), request.getReturnMsg(), extras);     // Catch: RemoteException -> L6
        return;
    L7:
        Slog.i("PackageManager", "Observer no longer exists.");
        return;
    }

    void scheduleDeferredNoKillInstallObserver(InstallRequest request) {
        String packageName = request.getPkg().getPackageName();
        this.mNoKillInstallObservers.put(packageName, request);
        Message message = this.mHandler.obtainMessage(24, packageName);
        this.mHandler.sendMessageDelayed(message, 500);
    }

    void scheduleDeferredNoKillPostDelete(CleanUpArgs args) {
        Message message = this.mHandler.obtainMessage(23, args);
        long deleteDelayMillis = ((Long) Binder.withCleanCallingIdentity(new PackageManagerService$$ExternalSyntheticLambda7())).longValue();
        Slog.w("PackageManager", "Delaying the deletion of <" + args.getCodePath() + "> by " + deleteDelayMillis + "ms or till the next reboot");
        this.mHandler.sendMessageDelayed(message, deleteDelayMillis);
    }

    private static /* synthetic */ Long lambda$scheduleDeferredNoKillPostDelete$0() throws Exception {
        return Long.valueOf(DeviceConfig.getLong("package_manager_service", PROPERTY_DEFERRED_NO_KILL_POST_DELETE_DELAY_MS_EXTENDED, DEFERRED_NO_KILL_POST_DELETE_DELAY_MS_EXTENDED));
    }

    void schedulePruneUnusedStaticSharedLibraries(boolean delay) {
        this.mHandler.removeMessages(28);
        Handler r0 = this.mHandler;
        if (delay == false) goto L5;
        long r2 = getPruneUnusedSharedLibrariesDelay();
    L6:
        r0.sendEmptyMessageDelayed(28, r2);
        return;
    L5:
        r2 = 0;
        goto L6
    }

    void scheduleDeferredPendingKillInstallObserver(InstallRequest request) {
        String packageName = request.getPkg().getPackageName();
        this.mPendingKillInstallObservers.put(packageName, request);
        Message message = this.mHandler.obtainMessage(29, packageName);
        this.mHandler.sendMessageDelayed(message, 1000);
    }

    private static long getPruneUnusedSharedLibrariesDelay() {
        return SystemProperties.getLong("debug.pm.prune_unused_shared_libraries_delay", PRUNE_UNUSED_SHARED_LIBRARIES_DELAY);
    }

    public void requestFileChecksums(File file, final String installerPackageName, final int optional, final int required, List trustedInstallers, final IOnChecksumsReadyListener onChecksumsReadyListener) throws FileNotFoundException {
        if (file.exists() == false) goto L11;
        Executor executor = this.mInjector.getBackgroundExecutor();
        final Handler handler = this.mInjector.getBackgroundHandler();
        if (trustedInstallers == null) goto L7;
        final Certificate[] trustedCerts = decodeCertificates(trustedInstallers);
    L8:
        final List<Pair<String, File>> filesToChecksum = new ArrayList(1);
        filesToChecksum.add(Pair.create(null, file));
        executor.execute(new PackageManagerService$$ExternalSyntheticLambda13(this, handler, filesToChecksum, optional, required, installerPackageName, trustedCerts, onChecksumsReadyListener));
        return;
    L7:
        trustedCerts = null;
        goto L8
    L11:
        throw new FileNotFoundException(file.getAbsolutePath());
    }

    private /* synthetic */ void lambda$requestFileChecksums$4(final Handler handler, List filesToChecksum, int optional, int required, String installerPackageName, Certificate[] trustedCerts, IOnChecksumsReadyListener onChecksumsReadyListener) {
        ApkChecksums.Injector.Producer r1 = new PackageManagerService$$ExternalSyntheticLambda26(this);
        ApkChecksums.Injector.Producer r2 = new PackageManagerService$$ExternalSyntheticLambda27(handler);
        PackageManagerServiceInjector r3 = this.mInjector;
        r3.getClass();
        ApkChecksums.Injector injector = new ApkChecksums.Injector(r1, r2, new PackageManagerService$$ExternalSyntheticLambda17(r3), new PackageManagerService$$ExternalSyntheticLambda28(this));
        ApkChecksums.getChecksums(filesToChecksum, optional, required, installerPackageName, trustedCerts, onChecksumsReadyListener, injector);
    }

    private /* synthetic */ Context lambda$requestFileChecksums$1() {
        return this.mContext;
    }

    private static /* synthetic */ Handler lambda$requestFileChecksums$2(Handler handler) {
        return handler;
    }

    private /* synthetic */ PackageManagerInternal lambda$requestFileChecksums$3() {
        return (PackageManagerInternal) this.mInjector.getLocalService(PackageManagerInternal.class);
    }

    void requestChecksumsInternal(Computer snapshot, String packageName, boolean includeSplits, final int optional, final int required, List trustedInstallers, final IOnChecksumsReadyListener onChecksumsReadyListener, int userId, Executor executor, final Handler handler) {
        packageName.getClass();
        onChecksumsReadyListener.getClass();
        executor.getClass();
        handler.getClass();
        ApplicationInfo applicationInfo = snapshot.getApplicationInfoInternal(packageName, 0, Binder.getCallingUid(), userId);
        if (applicationInfo == null) goto L25;
        InstallSourceInfo installSourceInfo = snapshot.getInstallSourceInfo(packageName, userId);
        if (installSourceInfo == null) goto L11;
        String initiatingPackageName = installSourceInfo.getInitiatingPackageName();
        if (PackageManagerServiceUtils.isInstalledByAdb(initiatingPackageName) == true) goto L9;
        String installerPackageName = initiatingPackageName;
    L10:
        final String installerPackageName2 = installerPackageName;
    L12:
        final List<Pair<String, File>> filesToChecksum = new ArrayList();
        filesToChecksum.add(Pair.create(null, new File(applicationInfo.sourceDir)));
        if (includeSplits == true) goto L15;
    L19:
        if (trustedInstallers == null) goto L21;
        final Certificate[] trustedCerts = decodeCertificates(trustedInstallers);
    L22:
        executor.execute(new PackageManagerService$$ExternalSyntheticLambda64(this, handler, filesToChecksum, optional, required, installerPackageName2, trustedCerts, onChecksumsReadyListener));
        return;
    L21:
        trustedCerts = null;
        goto L22
    L15:
        if (applicationInfo.splitNames == null) goto L19;
        int i = 0;
        int size = applicationInfo.splitNames.length;
    L17:
        if (i >= size) goto L19;
        filesToChecksum.add(Pair.create(applicationInfo.splitNames[i], new File(applicationInfo.splitSourceDirs[i])));
        i = i + 1;
        goto L17
    L9:
        installerPackageName = installSourceInfo.getInstallingPackageName();
        goto L10
    L11:
        installerPackageName2 = null;
        goto L12
    L25:
        throw new ParcelableException(new PackageManager.NameNotFoundException(packageName));
    }

    private /* synthetic */ void lambda$requestChecksumsInternal$8(final Handler handler, List filesToChecksum, int optional, int required, String installerPackageName, Certificate[] trustedCerts, IOnChecksumsReadyListener onChecksumsReadyListener) {
        ApkChecksums.Injector.Producer r1 = new PackageManagerService$$ExternalSyntheticLambda15(this);
        ApkChecksums.Injector.Producer r2 = new PackageManagerService$$ExternalSyntheticLambda16(handler);
        PackageManagerServiceInjector r3 = this.mInjector;
        r3.getClass();
        ApkChecksums.Injector injector = new ApkChecksums.Injector(r1, r2, new PackageManagerService$$ExternalSyntheticLambda17(r3), new PackageManagerService$$ExternalSyntheticLambda18(this));
        ApkChecksums.getChecksums(filesToChecksum, optional, required, installerPackageName, trustedCerts, onChecksumsReadyListener, injector);
    }

    private /* synthetic */ Context lambda$requestChecksumsInternal$5() {
        return this.mContext;
    }

    private static /* synthetic */ Handler lambda$requestChecksumsInternal$6(Handler handler) {
        return handler;
    }

    private /* synthetic */ PackageManagerInternal lambda$requestChecksumsInternal$7() {
        return (PackageManagerInternal) this.mInjector.getLocalService(PackageManagerInternal.class);
    }

    private static Certificate[] decodeCertificates(List certs) {
        CertificateFactory cf = CertificateFactory.getInstance("X.509");     // Catch: CertificateException -> L6
        Certificate[] result = new Certificate[certs.size()];     // Catch: CertificateException -> L6
        int i = 0;
        int size = certs.size();     // Catch: CertificateException -> L6
    L3:
        if (i >= size) goto L9;
        InputStream is = new ByteArrayInputStream((byte[]) certs.get(i));     // Catch: CertificateException -> L6
        X509Certificate cert = (X509Certificate) cf.generateCertificate(is);     // Catch: CertificateException -> L6
        result[i] = cert;     // Catch: CertificateException -> L6
        i = i + 1;
        goto L3
    L9:
        return result;
    L6:
        e = move-exception;
        throw ExceptionUtils.propagate(e);
    }

    private static Bundle extrasForInstallResult(InstallRequest request) {
        Bundle extras = null;
        switch(request.getReturnCode()) {
            case -112: goto L12;
            case 1: goto L5;
            default: goto L14;
        };
    L5:
        extras = new Bundle();
        if (request.getRemovedInfo() != null) goto L8;
    L10:
        boolean r1 = false;
    L11:
        extras.putBoolean("android.intent.extra.REPLACING", r1);
        goto L14
    L8:
        if (request.getRemovedInfo().mRemovedPackage == null) goto L10;
        r1 = true;
        goto L11
    L12:
        extras = new Bundle();
        extras.putString("android.content.pm.extra.FAILURE_EXISTING_PERMISSION", request.getOrigPermission());
        extras.putString("android.content.pm.extra.FAILURE_EXISTING_PACKAGE", request.getOrigPackage());
    L14:
        if (request.getWarnings().isEmpty() == true) goto L16;
        extras.putStringArrayList("android.content.pm.extra.WARNINGS", request.getWarnings());
    L16:
        return extras;
    }

    ArchivedPackageParcel getArchivedPackageInternal(String packageName, int userId) {
        packageName.getClass();
        int binderUid = Binder.getCallingUid();
        Computer snapshot = snapshotComputer();
        snapshot.enforceCrossUserPermission(binderUid, userId, true, true, "getArchivedPackage");
        ArchivedPackageParcel archPkg = new ArchivedPackageParcel();
        archPkg.packageName = packageName;
        PackageManagerTracedLock r4 = this.mLock;
        boostPriorityForPackageManagerTracedLockedSection();
        monitor-enter(r4);
        PackageSetting ps = this.mSettings.getPackageLPr(packageName);     // Catch: Throwable -> L16
        if (ps == null) goto L30;
        if (snapshot.shouldFilterApplication(ps, binderUid, userId) == true) goto L30;
        PackageUserStateInternal psi = ps.getUserStateOrDefault(userId);     // Catch: Throwable -> L16
        ArchiveState archiveState = psi.getArchiveState();     // Catch: Throwable -> L16
        if (archiveState == null) goto L12;
    L18:
        archPkg.signingDetails = ps.getSigningDetails();     // Catch: Throwable -> L16
        long longVersionCode = ps.getVersionCode();     // Catch: Throwable -> L16
        archPkg.versionCodeMajor = (int) (longVersionCode >> 32);     // Catch: Throwable -> L16
        archPkg.versionCode = (int) longVersionCode;     // Catch: Throwable -> L16
        archPkg.targetSdkVersion = ps.getTargetSdkVersion();     // Catch: Throwable -> L16
        archPkg.defaultToDeviceProtectedStorage = String.valueOf(ps.isDefaultToDeviceProtectedStorage());     // Catch: Throwable -> L16
        archPkg.requestLegacyExternalStorage = String.valueOf(ps.isRequestLegacyExternalStorage());     // Catch: Throwable -> L16
        archPkg.userDataFragile = String.valueOf(ps.isUserDataFragile());     // Catch: Throwable -> L16
        monitor-exit(r4);     // Catch: Throwable -> L16
        resetPriorityAfterPackageManagerTracedLockedSection();
        if (archiveState == null) goto L25;
        archPkg.archivedActivities = PackageArchiver.createArchivedActivities(archiveState);     // Catch: Exception -> L23
    L36:
        return archPkg;
    L25:
        int iconSize = ((ActivityManager) this.mContext.getSystemService(ActivityManager.class)).getLauncherLargeIconSize();     // Catch: Exception -> L23
        List<LauncherActivityInfo> mainActivities = this.mInstallerService.mPackageArchiver.getLauncherActivityInfos(packageName, userId);     // Catch: Exception -> L23
        archPkg.archivedActivities = PackageArchiver.createArchivedActivities(mainActivities, iconSize);     // Catch: Exception -> L23
    L23:
        e = move-exception;
        throw new IllegalArgumentException("Package does not have a main activity", e);
    L12:
        if (psi.isInstalled() == true) goto L18;
        monitor-exit(r4);     // Catch: Throwable -> L16
        resetPriorityAfterPackageManagerTracedLockedSection();
        return null;
    L30:
        monitor-exit(r4);     // Catch: Throwable -> L16
        resetPriorityAfterPackageManagerTracedLockedSection();
        return null;
    L16:
        th = move-exception;
        resetPriorityAfterPackageManagerTracedLockedSection();
        throw th;
    }

    void markPackageAsArchivedIfNeeded(PackageSetting pkgSetting, ArchivedPackageParcel archivePackage, SparseArray<String> responsibleInstallerTitles, int[] userIds) {
        if (pkgSetting == null) goto L25;
        if (archivePackage != null) goto L5;
        return;
    L5:
        if (archivePackage.archivedActivities == null) goto L31;
        if (responsibleInstallerTitles == null) goto L32;
        if (userIds != null) goto L9;
        return;
    L9:
        if (userIds.length == 0) goto L34;
        pkgSetting.setPkg(null).setPendingRestore(true);
        int r0 = userIds.length;
        int r1 = 0;
        int r2 = 0;
    L12:
        if (r2 >= r0) goto L14;
        pkgSetting.modifyUserState(userIds[r2]).setInstalled(false);
        r2 = r2 + 1;
        goto L12
    L14:
        String responsibleInstallerPackage = PackageArchiver.getResponsibleInstallerPackage(pkgSetting);
        if (TextUtils.isEmpty(responsibleInstallerPackage) == false) goto L18;
        Slog.e("PackageManager", "Can't create archive state: responsible installer is empty");
        return;
    L18:
        int r3 = userIds.length;
    L19:
        if (r1 >= r3) goto L24;
        int userId = userIds[r1];
        ArchiveState archiveState = this.mInstallerService.mPackageArchiver.createArchiveState(archivePackage, userId, responsibleInstallerPackage, responsibleInstallerTitles.get(userId));
        if (archiveState == null) goto L23;
        pkgSetting.modifyUserState(userId).setArchiveState(archiveState);
    L23:
        r1 = r1 + 1;
        goto L19
    L24:
        return;
    L34:
        return;
    L32:
        return;
    L31:
        return;
    }

    void scheduleWriteSettings() {
        invalidatePackageInfoCache();
        if (this.mHandler.hasMessages(13) == true) goto L6;
        this.mHandler.sendEmptyMessageDelayed(13, 10000);
        return;
    }

    void scheduleWritePackageListLocked(int userId) {
        invalidatePackageInfoCache();
        if (this.mHandler.hasMessages(19) == true) goto L6;
        Message msg = this.mHandler.obtainMessage(19);
        msg.arg1 = userId;
        this.mHandler.sendMessageDelayed(msg, 10000);
        return;
    }

    void scheduleWritePackageRestrictions(UserHandle user) {
        if (user != null) goto L4;
        int userId = -1;
    L5:
        scheduleWritePackageRestrictions(userId);
        return;
    L4:
        userId = user.getIdentifier();
        goto L5
    }

    void scheduleWritePackageRestrictions(int userId) {
        invalidatePackageInfoCache();
        if (userId != (-1)) goto L16;
        ArraySet<Integer> r0 = this.mDirtyUsers;
        monitor-enter(r0);
        int[] r1 = this.mUserManager.getUserIds();     // Catch: Throwable -> L9
        int r2 = r1.length;     // Catch: Throwable -> L9
        int r3 = 0;
    L7:
        if (r3 >= r2) goto L11;
        int aUserId = r1[r3];     // Catch: Throwable -> L9
        this.mDirtyUsers.add(Integer.valueOf(aUserId));     // Catch: Throwable -> L9
        r3 = r3 + 1;     // Catch: Throwable -> L9
        goto L7
    L11:
        monitor-exit(r0);     // Catch: Throwable -> L9
    L23:
        if (this.mBackgroundHandler.hasMessages(14) == true) goto L34;
        this.mBackgroundHandler.sendMessageDelayed(this.mBackgroundHandler.obtainMessage(14, this), 10000);
        return;
    L34:
        return;
    L9:
        th = move-exception;
        throw th;
    L16:
        if (this.mUserManager.exists(userId) == true) goto L18;
        return;
    L18:
        ArraySet<Integer> r4 = this.mDirtyUsers;
        monitor-enter(r4);
        this.mDirtyUsers.add(Integer.valueOf(userId));     // Catch: Throwable -> L26
        monitor-exit(r4);     // Catch: Throwable -> L26
    L26:
        th = move-exception;
        throw th;
    }

    void writePendingRestrictions() {
        PackageManagerTracedLock r0 = this.mLock;
        boostPriorityForPackageManagerTracedLockedSection();
        monitor-enter(r0);
        this.mBackgroundHandler.removeMessages(14);     // Catch: Throwable -> L12
        ArraySet<Integer> r1 = this.mDirtyUsers;     // Catch: Throwable -> L12
        monitor-enter(r1);     // Catch: Throwable -> L12
    L14:
        th = move-exception;
        throw th;     // Catch: Throwable -> L12
    L7:
        if (this.mDirtyUsers.isEmpty() == false) goto L16;
        monitor-exit(r1);     // Catch: Throwable -> L14
        monitor-exit(r0);     // Catch: Throwable -> L12
        resetPriorityAfterPackageManagerTracedLockedSection();
        return;
    L16:
        Integer[] dirtyUsers = (Integer[]) this.mDirtyUsers.toArray(new PackageManagerService$$ExternalSyntheticLambda67());     // Catch: Throwable -> L14
        this.mDirtyUsers.clear();     // Catch: Throwable -> L14
        monitor-exit(r1);     // Catch: Throwable -> L14
        monitor-exit(r0);     // Catch: Throwable -> L12
        resetPriorityAfterPackageManagerTracedLockedSection();
        this.mSettings.writePackageRestrictions(dirtyUsers);
        return;
    L12:
        th = move-exception;
        resetPriorityAfterPackageManagerTracedLockedSection();
        throw th;
    }

    private static /* synthetic */ Integer[] lambda$writePendingRestrictions$9(int x$0) {
        return new Integer[x$0];
    }

    void writeSettings(boolean sync) {
        PackageManagerTracedLock r0 = this.mLock;
        boostPriorityForPackageManagerTracedLockedSection();
        monitor-enter(r0);
        this.mHandler.removeMessages(13);     // Catch: Throwable -> L11
        this.mBackgroundHandler.removeMessages(14);     // Catch: Throwable -> L11
        writeSettingsLPrTEMP(sync);     // Catch: Throwable -> L11
        ArraySet<Integer> r1 = this.mDirtyUsers;     // Catch: Throwable -> L11
        monitor-enter(r1);     // Catch: Throwable -> L11
        this.mDirtyUsers.clear();     // Catch: Throwable -> L13
        monitor-exit(r1);     // Catch: Throwable -> L13
        monitor-exit(r0);     // Catch: Throwable -> L11
        resetPriorityAfterPackageManagerTracedLockedSection();
        return;
    L13:
        th = move-exception;
        throw th;     // Catch: Throwable -> L11
    L11:
        th = move-exception;
        resetPriorityAfterPackageManagerTracedLockedSection();
        throw th;
    }

    void writePackageList(int userId) {
        PackageManagerTracedLock r0 = this.mLock;
        boostPriorityForPackageManagerTracedLockedSection();
        monitor-enter(r0);
        this.mHandler.removeMessages(19);     // Catch: Throwable -> L8
        this.mSettings.writePackageListLPr(userId);     // Catch: Throwable -> L8
        monitor-exit(r0);     // Catch: Throwable -> L8
        resetPriorityAfterPackageManagerTracedLockedSection();
        return;
    L8:
        th = move-exception;
        resetPriorityAfterPackageManagerTracedLockedSection();
        throw th;
    }

    public static PackageManagerService main(final Context context, final Installer installer, final DomainVerificationService domainVerificationService, boolean factoryTest) {
        PackageManagerServiceCompilerMapping.checkProperties();
        TimingsTraceAndSlog t = new TimingsTraceAndSlog("PackageManagerTiming", 262144);
        t.traceBegin("create package manager");
        final PackageManagerTracedLock lock = new PackageManagerTracedLock("mLock");
        final PackageManagerTracedLock installLock = new PackageManagerTracedLock("mInstallLock");
        ServiceThread r5 = new ServiceThread("PackageManagerBg", 10, true);
        r5.start();
        final Handler backgroundHandler = new Handler(r5.getLooper(), BACKGROUND_HANDLER_CALLBACK);
        PackageAbiHelperImpl r6 = new PackageAbiHelperImpl();
        List<ScanPartition> r7 = SYSTEM_PARTITIONS;
        PackageManagerServiceInjector.Producer r8 = new PackageManagerService$$ExternalSyntheticLambda30();
        PackageManagerServiceInjector.Producer r9 = new PackageManagerService$$ExternalSyntheticLambda41(context);
        PackageManagerServiceInjector.Producer r10 = new PackageManagerService$$ExternalSyntheticLambda52();
        PackageManagerServiceInjector.Producer r11 = new PackageManagerService$$ExternalSyntheticLambda56(context, installer, installLock, lock);
        PackageManagerServiceInjector.Producer r12 = new PackageManagerService$$ExternalSyntheticLambda57(domainVerificationService, backgroundHandler, lock);
        PackageManagerServiceInjector.Producer r13 = new PackageManagerService$$ExternalSyntheticLambda58();
        PackageManagerServiceInjector.Producer r14 = new PackageManagerService$$ExternalSyntheticLambda59();
        PackageManagerServiceInjector.Producer r15 = new PackageManagerService$$ExternalSyntheticLambda60();
        PackageManagerServiceInjector.Producer r16 = new PackageManagerService$$ExternalSyntheticLambda61();
        PackageManagerServiceInjector.Producer r17 = new PackageManagerService$$ExternalSyntheticLambda62();
        PackageManagerServiceInjector.Producer r18 = new PackageManagerService$$ExternalSyntheticLambda31();
        PackageManagerServiceInjector.Producer r19 = new PackageManagerService$$ExternalSyntheticLambda32();
        PackageManagerServiceInjector.Producer r20 = new PackageManagerService$$ExternalSyntheticLambda33();
        PackageManagerServiceInjector.Producer r21 = new PackageManagerService$$ExternalSyntheticLambda34();
        PackageManagerServiceInjector.Producer r2 = new PackageManagerService$$ExternalSyntheticLambda35(context);
        PackageManagerServiceInjector.Producer r23 = new PackageManagerService$$ExternalSyntheticLambda36();
        PackageManagerServiceInjector.Producer r24 = new PackageManagerService$$ExternalSyntheticLambda37();
        PackageManagerServiceInjector.Producer r25 = new PackageManagerService$$ExternalSyntheticLambda38();
        PackageManagerServiceInjector.Producer r26 = new PackageManagerService$$ExternalSyntheticLambda39();
        PackageManagerServiceInjector.Producer r27 = new PackageManagerService$$ExternalSyntheticLambda40();
        PackageManagerServiceInjector.ProducerWithArgument r28 = new PackageManagerService$$ExternalSyntheticLambda42();
        PackageManagerServiceInjector.Producer r29 = new PackageManagerService$$ExternalSyntheticLambda43();
        PackageManagerServiceInjector.Producer r30 = new PackageManagerService$$ExternalSyntheticLambda44();
        PackageManagerServiceInjector.Producer r3 = new PackageManagerService$$ExternalSyntheticLambda45(domainVerificationService);
        PackageManagerServiceInjector.Producer r32 = new PackageManagerService$$ExternalSyntheticLambda46();
        DefaultSystemWrapper r0 = new DefaultSystemWrapper(null);
        PackageManagerServiceInjector.ServiceProducer r34 = new PackageManagerService$$ExternalSyntheticLambda47();
        context.getClass();
        PackageManagerServiceInjector injector = new PackageManagerServiceInjector(context, lock, installer, installLock, r6, backgroundHandler, r7, r8, r9, r10, r11, r12, r13, r14, r15, r16, r17, r18, r19, r20, r21, r2, r23, r24, r25, r26, r27, r28, r29, r30, r3, r32, r0, r34, new PackageManagerService$$ExternalSyntheticLambda48(context), new PackageManagerService$$ExternalSyntheticLambda49(), new PackageManagerService$$ExternalSyntheticLambda50(), new PackageManagerService$$ExternalSyntheticLambda51(context), new PackageManagerService$$ExternalSyntheticLambda53(), new PackageManagerService$$ExternalSyntheticLambda54());
        final PackageManagerService m = new PackageManagerService(injector, factoryTest, PackagePartitions.FINGERPRINT, Build.IS_ENG, Build.IS_USERDEBUG, Build.VERSION.SDK_INT, Build.VERSION.INCREMENTAL);
        t.traceEnd();
        CompatChange.ChangeListener selinuxChangeListener = new PackageManagerService$$ExternalSyntheticLambda55(m);
        injector.getCompatibility().registerListener(143539591, selinuxChangeListener);
        injector.getCompatibility().registerListener(168782947, selinuxChangeListener);
        m.installAllowlistedSystemPackages();
        ServiceManager.addService("package", new IPackageManagerImpl(m));
        ServiceManager.addService("package_native", new PackageManagerNative(m));
        return m;
    }

    private static /* synthetic */ ComponentResolver lambda$main$10(PackageManagerServiceInjector i, PackageManagerService pm) {
        return new ComponentResolver(i.getUserManagerService(), pm.mUserNeedsBadging);
    }

    private static /* synthetic */ PermissionManagerServiceInternal lambda$main$11(Context context, PackageManagerServiceInjector i, PackageManagerService pm) {
        return PermissionManagerService.create(context, i.getSystemConfig().getAvailableFeatures());
    }

    private static /* synthetic */ AppOpsManagerInternal lambda$main$12(PackageManagerServiceInjector i, PackageManagerService pm) {
        return (AppOpsManagerInternal) LocalServices.getService(AppOpsManagerInternal.class);
    }

    private static /* synthetic */ UserManagerService lambda$main$13(Context context, Installer installer, PackageManagerTracedLock installLock, PackageManagerTracedLock lock, PackageManagerServiceInjector i, PackageManagerService pm) {
        return new UserManagerService(context, pm, new UserDataPreparer(installer, installLock, context), lock);
    }

    private static /* synthetic */ Settings lambda$main$14(DomainVerificationService domainVerificationService, Handler backgroundHandler, PackageManagerTracedLock lock, PackageManagerServiceInjector i, PackageManagerService pm) {
        return new Settings(Environment.getDataDirectory(), RuntimePermissionsPersistence.createInstance(), i.getPermissionManagerServiceInternal(), domainVerificationService, backgroundHandler, lock);
    }

    private static /* synthetic */ AppsFilterImpl lambda$main$15(PackageManagerServiceInjector i, PackageManagerService pm) {
        return AppsFilterImpl.create(i, (PackageManagerInternal) i.getLocalService(PackageManagerInternal.class));
    }

    private static /* synthetic */ PlatformCompat lambda$main$16(PackageManagerServiceInjector i, PackageManagerService pm) {
        return (PlatformCompat) ServiceManager.getService("platform_compat");
    }

    private static /* synthetic */ SystemConfig lambda$main$17(PackageManagerServiceInjector i, PackageManagerService pm) {
        return SystemConfig.getInstance();
    }

    private static /* synthetic */ PackageDexOptimizer lambda$main$18(PackageManagerServiceInjector i, PackageManagerService pm) {
        return new PackageDexOptimizer(i.getInstaller(), i.getInstallLock(), i.getContext(), "*dexopt*");
    }

    private static /* synthetic */ DexManager lambda$main$19(PackageManagerServiceInjector i, PackageManagerService pm) {
        return new DexManager(i.getContext(), i.getPackageDexOptimizer(), i.getDynamicCodeLogger());
    }

    private static /* synthetic */ DynamicCodeLogger lambda$main$20(PackageManagerServiceInjector i, PackageManagerService pm) {
        return new DynamicCodeLogger(i.getInstaller());
    }

    private static /* synthetic */ ArtManagerService lambda$main$21(PackageManagerServiceInjector i, PackageManagerService pm) {
        return new ArtManagerService(i.getContext(), i.getInstaller(), i.getInstallLock());
    }

    private static /* synthetic */ ApexManager lambda$main$22(PackageManagerServiceInjector i, PackageManagerService pm) {
        return ApexManager.getInstance();
    }

    private static /* synthetic */ IncrementalManager lambda$main$23(PackageManagerServiceInjector i, PackageManagerService pm) {
        return (IncrementalManager) i.getContext().getSystemService("incremental");
    }

    private static /* synthetic */ RoleManager lambda$main$24(Context context) {
        return (RoleManager) context.getSystemService(RoleManager.class);
    }

    private static /* synthetic */ DefaultAppProvider lambda$main$26(final Context context, PackageManagerServiceInjector i, PackageManagerService pm) {
        return new DefaultAppProvider(new PackageManagerService$$ExternalSyntheticLambda3(context), new PackageManagerService$$ExternalSyntheticLambda4());
    }

    private static /* synthetic */ UserManagerInternal lambda$main$25() {
        return (UserManagerInternal) LocalServices.getService(UserManagerInternal.class);
    }

    private static /* synthetic */ DisplayMetrics lambda$main$27(PackageManagerServiceInjector i, PackageManagerService pm) {
        return new DisplayMetrics();
    }

    private static /* synthetic */ PackageParser2 lambda$main$28(PackageManagerServiceInjector i, PackageManagerService pm) {
        return new PackageParser2(pm.mSeparateProcesses, i.getDisplayMetrics(), new PackageCacher(pm.mCacheDir, pm.mPackageParserCallback), pm.mPackageParserCallback);
    }

    private static /* synthetic */ PackageParser2 lambda$main$29(PackageManagerServiceInjector i, PackageManagerService pm) {
        return new PackageParser2(pm.mSeparateProcesses, i.getDisplayMetrics(), null, pm.mPackageParserCallback);
    }

    private static /* synthetic */ PackageParser2 lambda$main$30(PackageManagerServiceInjector i, PackageManagerService pm) {
        return new PackageParser2(pm.mSeparateProcesses, i.getDisplayMetrics(), null, pm.mPackageParserCallback);
    }

    private static /* synthetic */ PackageInstallerService lambda$main$31(final PackageManagerServiceInjector i, PackageManagerService pm) {
        Context r1 = i.getContext();
        i.getClass();
        return new PackageInstallerService(r1, pm, new PackageManagerService$$ExternalSyntheticLambda66(i));
    }

    private static /* synthetic */ InstantAppResolverConnection lambda$main$32(PackageManagerServiceInjector i, PackageManagerService pm, ComponentName cn) {
        return new InstantAppResolverConnection(i.getContext(), cn, "android.intent.action.RESOLVE_INSTANT_APP_PACKAGE");
    }

    private static /* synthetic */ ModuleInfoProvider lambda$main$33(PackageManagerServiceInjector i, PackageManagerService pm) {
        return new ModuleInfoProvider(i.getContext());
    }

    private static /* synthetic */ LegacyPermissionManagerInternal lambda$main$34(PackageManagerServiceInjector i, PackageManagerService pm) {
        return LegacyPermissionManagerService.create(i.getContext());
    }

    private static /* synthetic */ DomainVerificationManagerInternal lambda$main$35(DomainVerificationService domainVerificationService, PackageManagerServiceInjector i, PackageManagerService pm) {
        return domainVerificationService;
    }

    private static /* synthetic */ Handler lambda$main$36(PackageManagerServiceInjector i, PackageManagerService pm) {
        ServiceThread r0 = new ServiceThread("PackageManager", 0, true);
        r0.start();
        return new PackageHandler(r0.getLooper(), pm);
    }

    private static /* synthetic */ IBackupManager lambda$main$37(PackageManagerServiceInjector i, PackageManagerService pm) {
        return IBackupManager.Stub.asInterface(ServiceManager.getService(HostingRecord.HOSTING_TYPE_BACKUP));
    }

    private static /* synthetic */ SharedLibrariesImpl lambda$main$38(PackageManagerServiceInjector i, PackageManagerService pm) {
        return new SharedLibrariesImpl(pm, i);
    }

    private static /* synthetic */ CrossProfileIntentFilterHelper lambda$main$39(Context context, PackageManagerServiceInjector i, PackageManagerService pm) {
        return new CrossProfileIntentFilterHelper(i.getSettings(), i.getUserManagerService(), i.getLock(), i.getUserManagerInternal(), context);
    }

    private static /* synthetic */ UpdateOwnershipHelper lambda$main$40(PackageManagerServiceInjector i, PackageManagerService pm) {
        return new UpdateOwnershipHelper();
    }

    private static /* synthetic */ PackageMonitorCallbackHelper lambda$main$41(PackageManagerServiceInjector i, PackageManagerService pm) {
        return new PackageMonitorCallbackHelper();
    }

    private static /* synthetic */ void lambda$main$43(PackageManagerService m, String packageName) {
        PackageManagerTracedLock r0 = m.mInstallLock;
        boostPriorityForPackageManagerTracedLockedSection();
        monitor-enter(r0);
        Computer snapshot = m.snapshotComputer();     // Catch: Throwable -> L10
        PackageStateInternal packageState = snapshot.getPackageStateInternal(packageName);     // Catch: Throwable -> L10
        if (packageState != null) goto L12;
        Slog.e("PackageManager", "Failed to find package setting " + packageName);     // Catch: Throwable -> L10
        monitor-exit(r0);     // Catch: Throwable -> L10
        resetPriorityAfterPackageManagerTracedLockedSection();
        return;
    L12:
        AndroidPackage pkg = packageState.getPkg();     // Catch: Throwable -> L10
        SharedUserApi sharedUser = snapshot.getSharedUser(packageState.getSharedUserAppId());     // Catch: Throwable -> L10
        String oldSeInfo = packageState.getSeInfo();     // Catch: Throwable -> L10
        if (pkg != null) goto L18;
        Slog.e("PackageManager", "Failed to find package " + packageName);     // Catch: Throwable -> L10
        monitor-exit(r0);     // Catch: Throwable -> L10
        resetPriorityAfterPackageManagerTracedLockedSection();
        return;
    L18:
        final String newSeInfo = SELinuxMMAC.getSeInfo(packageState, pkg, sharedUser, m.mInjector.getCompatibility());     // Catch: Throwable -> L10
        if (newSeInfo.equals(oldSeInfo) == true) goto L21;
        Slog.i("PackageManager", "Updating seInfo for package " + packageName + " from: " + oldSeInfo + " to: " + newSeInfo);     // Catch: Throwable -> L10
        m.commitPackageStateMutation(null, packageName, new PackageManagerService$$ExternalSyntheticLambda1(newSeInfo));     // Catch: Throwable -> L10
        m.mAppDataHelper.prepareAppDataAfterInstallLIF(pkg);     // Catch: Throwable -> L10
    L21:
        monitor-exit(r0);     // Catch: Throwable -> L10
        resetPriorityAfterPackageManagerTracedLockedSection();
        return;
    L10:
        th = move-exception;
        resetPriorityAfterPackageManagerTracedLockedSection();
        throw th;
    }

    private static /* synthetic */ void lambda$main$42(String newSeInfo, PackageStateWrite state) {
        state.setOverrideSeInfo(newSeInfo);
    }

    private void installAllowlistedSystemPackages() {
        if (this.mUserManager.installWhitelistedSystemPackages(isFirstBoot(), isDeviceUpgrading(), this.mExistingPackages) == false) goto L6;
        scheduleWritePackageRestrictions(-1);
        scheduleWriteSettings();
        return;
    }

    private void registerObservers(boolean verify) {
        if (this.mPackages == null) goto L6;
        this.mPackages.registerObserver(this.mWatcher);
    L6:
        if (this.mSharedLibraries == null) goto L9;
        this.mSharedLibraries.registerObserver(this.mWatcher);
    L9:
        if (this.mInstrumentation == null) goto L12;
        this.mInstrumentation.registerObserver(this.mWatcher);
    L12:
        if (this.mWebInstantAppsDisabled == null) goto L15;
        this.mWebInstantAppsDisabled.registerObserver(this.mWatcher);
    L15:
        if (this.mAppsFilter == null) goto L18;
        this.mAppsFilter.registerObserver(this.mWatcher);
    L18:
        if (this.mInstantAppRegistry == null) goto L21;
        this.mInstantAppRegistry.registerObserver(this.mWatcher);
    L21:
        if (this.mSettings == null) goto L24;
        this.mSettings.registerObserver(this.mWatcher);
    L24:
        if (this.mIsolatedOwners == null) goto L27;
        this.mIsolatedOwners.registerObserver(this.mWatcher);
    L27:
        if (this.mComponentResolver == null) goto L30;
        this.mComponentResolver.registerObserver(this.mWatcher);
    L30:
        if (this.mFrozenPackages == null) goto L32;
        this.mFrozenPackages.registerObserver(this.mWatcher);
    L32:
        if (verify == false) goto L41;
        Watcher r0 = this.mWatcher;
        if (this.mIsEngBuild == false) goto L36;
    L38:
        boolean r1 = false;
    L39:
        Watchable.verifyWatchedAttributes(this, r0, r1);
        return;
    L36:
        if (this.mIsUserDebugBuild == true) goto L38;
        r1 = true;
        goto L39
    }

    public PackageManagerService(PackageManagerServiceInjector injector, PackageManagerServiceTestParams testParams) {
        this.mOverlayPathsLock = new PackageManagerTracedLock();
        this.mPackageStateMutator = new PackageStateMutator(new PackageManagerService$$ExternalSyntheticLambda8(this), new PackageManagerService$$ExternalSyntheticLambda9(this));
        this.mPackages = new WatchedArrayMap();
        this.mPackagesSnapshot = new SnapshotCache.Auto(this.mPackages, this.mPackages, "PackageManagerService.mPackages");
        this.mIsolatedOwners = new WatchedSparseIntArray();
        this.mIsolatedOwnersSnapshot = new SnapshotCache.Auto(this.mIsolatedOwners, this.mIsolatedOwners, "PackageManagerService.mIsolatedOwners");
        this.mExistingPackages = null;
        this.mFrozenPackages = new WatchedArrayMap();
        this.mFrozenPackagesSnapshot = new SnapshotCache.Auto(this.mFrozenPackages, this.mFrozenPackages, "PackageManagerService.mFrozenPackages");
        this.mPackageObserverHelper = new PackageObserverHelper();
        this.mInstrumentation = new WatchedArrayMap();
        this.mInstrumentationSnapshot = new SnapshotCache.Auto(this.mInstrumentation, this.mInstrumentation, "PackageManagerService.mInstrumentation");
        this.mTransferredPackages = new ArraySet();
        this.mProtectedBroadcasts = new ArraySet();
        this.mPendingVerification = new SparseArray();
        this.mPendingEnableRollback = new SparseArray();
        this.mNextMoveId = new AtomicInteger();
        this.mPendingVerificationToken = 0;
        this.mPendingEnableRollbackToken = 0;
        this.mWebInstantAppsDisabled = new WatchedSparseBooleanArray();
        this.mResolveActivity = new ActivityInfo();
        this.mResolveInfo = new ResolveInfo();
        this.mPlatformPackageOverlayPaths = null;
        this.mPlatformPackageOverlayResourceDirs = null;
        this.mReplacedResolverPackageOverlayPaths = null;
        this.mReplacedResolverPackageOverlayResourceDirs = null;
        this.mResolverReplaced = false;
        this.mInstantAppInstallerInfo = new ResolveInfo();
        this.mNoKillInstallObservers = Collections.synchronizedMap(new HashMap());
        this.mPendingKillInstallObservers = Collections.synchronizedMap(new HashMap());
        this.mKeepUninstalledPackages = new ArraySet();
        this.mDevicePolicyManager = null;
        this.mPackageProperty = new PackageProperty();
        this.mDirtyUsers = new ArraySet();
        this.mRunningInstalls = new SparseArray();
        this.mNextInstallToken = 1;
        this.mPackageUsage = new PackageUsage();
        this.mCompilerStats = new CompilerStats();
        this.mRemovableSystemAppHelper = RemovableSystemAppHelper.getInstance();
        this.mWatcher = new AnonymousClass1(this);
        this.mSnapshotLock = new Object();
        this.mObricExt = (IObricPackageManagerService) ObricImplFactory.getImpl(IObricPackageManagerService.class, new Object[]{this});
        this.mExt = (IExtPackageManagerService) ExtImplFactory.getImpl(IExtPackageManagerService.class, new Object[]{this});
        this.mPackageManagerServiceMonitorEx = new PackageManagerServiceMonitorEx(this);
        this.mInjector = injector;
        this.mInjector.bootstrap(this);
        this.mAppsFilter = injector.getAppsFilter();
        this.mComponentResolver = injector.getComponentResolver();
        this.mContext = injector.getContext();
        this.mInstaller = injector.getInstaller();
        this.mInstallLock = injector.getInstallLock();
        this.mLock = injector.getLock();
        this.mPackageStateWriteLock = this.mLock;
        this.mPermissionManager = injector.getPermissionManagerServiceInternal();
        TaskPersistUtil.getInstance().init(this, this.mPermissionManager);
        this.mSettings = injector.getSettings();
        this.mUserManager = injector.getUserManagerService();
        this.mUserNeedsBadging = new UserNeedsBadgingCache(this.mUserManager);
        this.mDomainVerificationManager = injector.getDomainVerificationManagerInternal();
        this.mHandler = injector.getHandler();
        this.mBackgroundHandler = injector.getBackgroundHandler();
        this.mSharedLibraries = injector.getSharedLibrariesImpl();
        this.mApexManager = testParams.apexManager;
        this.mArtManagerService = testParams.artManagerService;
        this.mAvailableFeatures = testParams.availableFeatures;
        this.mDefParseFlags = testParams.defParseFlags;
        this.mDefaultAppProvider = testParams.defaultAppProvider;
        this.mLegacyPermissionManager = testParams.legacyPermissionManagerInternal;
        this.mDexManager = testParams.dexManager;
        this.mDynamicCodeLogger = testParams.dynamicCodeLogger;
        this.mFactoryTest = testParams.factoryTest;
        this.mIncrementalManager = testParams.incrementalManager;
        this.mInstallerService = testParams.installerService;
        this.mInstantAppRegistry = testParams.instantAppRegistry;
        this.mChangedPackagesTracker = testParams.changedPackagesTracker;
        this.mInstantAppResolverConnection = testParams.instantAppResolverConnection;
        this.mInstantAppResolverSettingsComponent = testParams.instantAppResolverSettingsComponent;
        this.mIsPreNMR1Upgrade = testParams.isPreNmr1Upgrade;
        this.mIsPreQUpgrade = testParams.isPreQupgrade;
        this.mPriorSdkVersion = testParams.priorSdkVersion;
        this.mIsUpgrade = testParams.isUpgrade;
        this.mMetrics = testParams.Metrics;
        this.mModuleInfoProvider = testParams.moduleInfoProvider;
        this.mMoveCallbacks = testParams.moveCallbacks;
        this.mOverlayConfig = testParams.overlayConfig;
        this.mPackageDexOptimizer = testParams.packageDexOptimizer;
        this.mPackageParserCallback = testParams.packageParserCallback;
        this.mPendingBroadcasts = testParams.pendingPackageBroadcasts;
        this.mTestUtilityService = testParams.testUtilityService;
        this.mProcessLoggingHandler = testParams.processLoggingHandler;
        this.mProtectedPackages = testParams.protectedPackages;
        this.mSeparateProcesses = testParams.separateProcesses;
        this.mRequiredVerifierPackages = testParams.requiredVerifierPackages;
        this.mOptionalVerifierPackage = testParams.optionalVerifierPackage;
        this.mRequiredInstallerPackage = testParams.requiredInstallerPackage;
        this.mRequiredUninstallerPackage = testParams.requiredUninstallerPackage;
        this.mRequiredPermissionControllerPackage = testParams.requiredPermissionControllerPackage;
        this.mSetupWizardPackage = testParams.setupWizardPackage;
        this.mStorageManagerPackage = testParams.storageManagerPackage;
        this.mDefaultTextClassifierPackage = testParams.defaultTextClassifierPackage;
        this.mSystemTextClassifierPackageName = testParams.systemTextClassifierPackage;
        this.mRetailDemoPackage = testParams.retailDemoPackage;
        this.mRecentsPackage = testParams.recentsPackage;
        this.mAmbientContextDetectionPackage = testParams.ambientContextDetectionPackage;
        this.mWearableSensingPackage = testParams.wearableSensingPackage;
        this.mConfiguratorPackage = testParams.configuratorPackage;
        this.mAppPredictionServicePackage = testParams.appPredictionServicePackage;
        this.mIncidentReportApproverPackage = testParams.incidentReportApproverPackage;
        this.mServicesExtensionPackageName = testParams.servicesExtensionPackageName;
        this.mSharedSystemSharedLibraryPackageName = testParams.sharedSystemSharedLibraryPackageName;
        this.mOverlayConfigSignaturePackage = testParams.overlayConfigSignaturePackage;
        this.mResolveComponentName = testParams.resolveComponentName;
        this.mRequiredSdkSandboxPackage = testParams.requiredSdkSandboxPackage;
        this.mInitialNonStoppedSystemPackages = testParams.initialNonStoppedSystemPackages;
        this.mShouldStopSystemPackagesByDefault = testParams.shouldStopSystemPackagesByDefault;
        this.mLiveComputer = createLiveComputer();
        this.mSnapshotStatistics = null;
        this.mPackages.putAll(testParams.packages);
        this.mFreeStorageHelper = testParams.freeStorageHelper;
        this.mSdkVersion = testParams.sdkVersion;
        this.mAppInstallDir = testParams.appInstallDir;
        this.mIsEngBuild = testParams.isEngBuild;
        this.mIsUserDebugBuild = testParams.isUserDebugBuild;
        this.mIncrementalVersion = testParams.incrementalVersion;
        this.mDomainVerificationConnection = new DomainVerificationConnection(this);
        this.mBroadcastHelper = testParams.broadcastHelper;
        this.mAppDataHelper = testParams.appDataHelper;
        this.mInstallPackageHelper = testParams.installPackageHelper;
        this.mRemovePackageHelper = testParams.removePackageHelper;
        this.mInitAppsHelper = testParams.initAndSystemPackageHelper;
        this.mDeletePackageHelper = testParams.deletePackageHelper;
        this.mPreferredActivityHelper = testParams.preferredActivityHelper;
        this.mResolveIntentHelper = testParams.resolveIntentHelper;
        this.mDexOptHelper = testParams.dexOptHelper;
        this.mSuspendPackageHelper = testParams.suspendPackageHelper;
        this.mDistractingPackageHelper = testParams.distractingPackageHelper;
        this.mSharedLibraries.setDeletePackageHelper(this.mDeletePackageHelper);
        this.mStorageEventHelper = testParams.storageEventHelper;
        this.mPackageMonitorCallbackHelper = testParams.packageMonitorCallbackHelper;
        registerObservers(false);
        invalidatePackageInfoCache();
        this.mPackageManagerServiceSmtEx = new PackageManagerServiceSmtEx(this, this.mPackageManagerServiceMonitorEx, this.mDexOptHelper);
        this.mPackageManagerServiceSmtEx.BytedanceOSInit();
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r22v1 */
    /* JADX WARN: Type inference failed for: r22v2, types: [com.android.server.pm.PackageManagerTracedLock] */
    /* JADX WARN: Type inference failed for: r22v7 */
    public PackageManagerService(PackageManagerServiceInjector r45, boolean r46, String r47, boolean r48, boolean r49, int r50, String r51) {
        this.mOverlayPathsLock = new PackageManagerTracedLock();
        this.mPackageStateMutator = new PackageStateMutator(new PackageManagerService$$ExternalSyntheticLambda8(this), new PackageManagerService$$ExternalSyntheticLambda9(this));
        this.mPackages = new WatchedArrayMap();
        this.mPackagesSnapshot = new SnapshotCache.Auto(this.mPackages, this.mPackages, "PackageManagerService.mPackages");
        this.mIsolatedOwners = new WatchedSparseIntArray();
        this.mIsolatedOwnersSnapshot = new SnapshotCache.Auto(this.mIsolatedOwners, this.mIsolatedOwners, "PackageManagerService.mIsolatedOwners");
        this.mExistingPackages = null;
        this.mFrozenPackages = new WatchedArrayMap();
        this.mFrozenPackagesSnapshot = new SnapshotCache.Auto(this.mFrozenPackages, this.mFrozenPackages, "PackageManagerService.mFrozenPackages");
        this.mPackageObserverHelper = new PackageObserverHelper();
        this.mInstrumentation = new WatchedArrayMap();
        this.mInstrumentationSnapshot = new SnapshotCache.Auto(this.mInstrumentation, this.mInstrumentation, "PackageManagerService.mInstrumentation");
        this.mTransferredPackages = new ArraySet();
        this.mProtectedBroadcasts = new ArraySet();
        this.mPendingVerification = new SparseArray();
        this.mPendingEnableRollback = new SparseArray();
        this.mNextMoveId = new AtomicInteger();
        this.mPendingVerificationToken = 0;
        this.mPendingEnableRollbackToken = 0;
        this.mWebInstantAppsDisabled = new WatchedSparseBooleanArray();
        this.mResolveActivity = new ActivityInfo();
        this.mResolveInfo = new ResolveInfo();
        this.mPlatformPackageOverlayPaths = null;
        this.mPlatformPackageOverlayResourceDirs = null;
        this.mReplacedResolverPackageOverlayPaths = null;
        this.mReplacedResolverPackageOverlayResourceDirs = null;
        this.mResolverReplaced = false;
        this.mInstantAppInstallerInfo = new ResolveInfo();
        this.mNoKillInstallObservers = Collections.synchronizedMap(new HashMap());
        this.mPendingKillInstallObservers = Collections.synchronizedMap(new HashMap());
        this.mKeepUninstalledPackages = new ArraySet();
        this.mDevicePolicyManager = null;
        this.mPackageProperty = new PackageProperty();
        this.mDirtyUsers = new ArraySet();
        this.mRunningInstalls = new SparseArray();
        this.mNextInstallToken = 1;
        this.mPackageUsage = new PackageUsage();
        this.mCompilerStats = new CompilerStats();
        this.mRemovableSystemAppHelper = RemovableSystemAppHelper.getInstance();
        this.mWatcher = new AnonymousClass1(this);
        this.mSnapshotLock = new Object();
        this.mObricExt = (IObricPackageManagerService) ObricImplFactory.getImpl(IObricPackageManagerService.class, new Object[]{this});
        this.mExt = (IExtPackageManagerService) ExtImplFactory.getImpl(IExtPackageManagerService.class, new Object[]{this});
        this.mPackageManagerServiceMonitorEx = new PackageManagerServiceMonitorEx(this);
        this.mIsEngBuild = r48;
        this.mIsUserDebugBuild = r49;
        this.mSdkVersion = r50;
        this.mIncrementalVersion = r51;
        this.mInjector = r45;
        this.mInjector.getSystemWrapper().disablePackageCaches();
        TimingsTraceAndSlog r0 = new TimingsTraceAndSlog("PackageManagerTiming", 262144);
        this.mPendingBroadcasts = new PendingPackageBroadcasts();
        this.mInjector.bootstrap(this);
        this.mLock = r45.getLock();
        this.mPackageStateWriteLock = this.mLock;
        this.mInstallLock = r45.getInstallLock();
        LockGuard.installLock(this.mLock, 3);
        EventLog.writeEvent(EventLogTags.BOOT_PROGRESS_PMS_START, SystemClock.uptimeMillis());
        SysOptBridge.getFactory().getBootEventStat().writeEvent("boot_event_pms_start", SystemClock.elapsedRealtime());
        this.mContext = r45.getContext();
        this.mFactoryTest = r46;
        this.mMetrics = r45.getDisplayMetrics();
        this.mInstaller = r45.getInstaller();
        this.mFreeStorageHelper = new FreeStorageHelper(this);
        r0.traceBegin("createSubComponents");
        LocalServices.addService(PackageManagerInternal.class, new PackageManagerInternalImpl(this));
        LocalManagerRegistry.addManager(PackageManagerLocal.class, new PackageManagerLocalImpl(this));
        LocalServices.addService(TestUtilityService.class, this);
        this.mTestUtilityService = (TestUtilityService) LocalServices.getService(TestUtilityService.class);
        this.mUserManager = r45.getUserManagerService();
        this.mUserNeedsBadging = new UserNeedsBadgingCache(this.mUserManager);
        this.mComponentResolver = r45.getComponentResolver();
        this.mPermissionManager = r45.getPermissionManagerServiceInternal();
        TaskPersistUtil.getInstance().init(this, this.mPermissionManager);
        this.mSettings = r45.getSettings();
        this.mIncrementalManager = this.mInjector.getIncrementalManager();
        this.mDefaultAppProvider = this.mInjector.getDefaultAppProvider();
        this.mLegacyPermissionManager = this.mInjector.getLegacyPermissionManagerInternal();
        final PlatformCompat r3 = this.mInjector.getCompatibility();
        this.mPackageParserCallback = new AnonymousClass3(this, r3);
        this.mComponentResolver.getSmtEx().setSettings(this.mSettings);
        r0.traceEnd();
        r0.traceBegin("get system config");
        SystemConfig r16 = r45.getSystemConfig();
        r0.traceEnd();
        r0.traceBegin("addSharedUsers");
        this.mSettings.addSharedUserLPw("android.uid.system", 1000, 1, 8);
        this.mSettings.addSharedUserLPw("android.uid.phone", 1001, 1, 8);
        this.mSettings.addSharedUserLPw("android.uid.log", 1007, 1, 8);
        this.mSettings.addSharedUserLPw("android.uid.nfc", 1027, 1, 8);
        this.mSettings.addSharedUserLPw("android.uid.bluetooth", 1002, 1, 8);
        this.mSettings.addSharedUserLPw("android.uid.shell", 2000, 1, 8);
        this.mSettings.addSharedUserLPw("android.uid.se", SE_UID, 1, 8);
        this.mSettings.addSharedUserLPw("android.uid.networkstack", NETWORKSTACK_UID, 1, 8);
        this.mSettings.addSharedUserLPw("android.uid.uwb", UWB_UID, 1, 8);
        ArrayMap<String, Integer> r4 = r16.getOemDefinedUids();
        int r5 = r4.size();
        int r1 = 0;
    L3:
        if (r1 >= r5) goto L5;
        this.mSettings.addOemSharedUserLPw(r4.keyAt(r1), r4.valueAt(r1).intValue(), 1, 8);
        r1 = r1 + 1;
        goto L3
    L5:
        r0.traceEnd();
        String r6 = SystemProperties.get("debug.separate_processes");
        if (r6 != null) goto L8;
    L13:
        this.mDefParseFlags = 0;
        this.mSeparateProcesses = null;
    L14:
        this.mPackageDexOptimizer = r45.getPackageDexOptimizer();
        this.mDexManager = r45.getDexManager();
        this.mDynamicCodeLogger = r45.getDynamicCodeLogger();
        this.mArtManagerService = r45.getArtManagerService();
        this.mMoveCallbacks = new MovePackageHelper.MoveCallbacks(FgThread.get().getLooper());
        this.mSharedLibraries = this.mInjector.getSharedLibrariesImpl();
        this.mBackgroundHandler = r45.getBackgroundHandler();
        ((DisplayManager) this.mContext.getSystemService(DisplayManager.class)).getDisplay(0).getMetrics(this.mMetrics);
        this.mAvailableFeatures = r16.getAvailableFeatures();
        this.mProtectedPackages = new ProtectedPackages(this.mContext);
        this.mApexManager = r45.getApexManager();
        this.mAppsFilter = this.mInjector.getAppsFilter();
        this.mChangedPackagesTracker = new ChangedPackagesTracker();
        this.mAppInstallDir = new File(Environment.getDataDirectory(), "app");
        this.mDomainVerificationConnection = new DomainVerificationConnection(this);
        this.mDomainVerificationManager = r45.getDomainVerificationManagerInternal();
        this.mDomainVerificationManager.setConnection(this.mDomainVerificationConnection);
        this.mBroadcastHelper = new BroadcastHelper(this.mInjector);
        this.mPackageMonitorCallbackHelper = r45.getPackageMonitorCallbackHelper();
        this.mAppDataHelper = new AppDataHelper(this);
        this.mRemovePackageHelper = new RemovePackageHelper(this, this.mAppDataHelper, this.mBroadcastHelper);
        this.mDeletePackageHelper = new DeletePackageHelper(this, this.mRemovePackageHelper, this.mBroadcastHelper);
        this.mInstallPackageHelper = new InstallPackageHelper(this, this.mAppDataHelper, this.mRemovePackageHelper, this.mDeletePackageHelper, this.mBroadcastHelper);
        this.mInstantAppRegistry = new InstantAppRegistry(this.mContext, this.mPermissionManager, this.mInjector.getUserManagerInternal(), this.mDeletePackageHelper);
        this.mSharedLibraries.setDeletePackageHelper(this.mDeletePackageHelper);
        this.mPreferredActivityHelper = new PreferredActivityHelper(this, this.mBroadcastHelper);
        Context r22 = this.mContext;
        this.mResolveIntentHelper = new ResolveIntentHelper(r22, this.mPreferredActivityHelper, r45.getCompatibility(), this.mUserManager, this.mDomainVerificationManager, this.mUserNeedsBadging, new PackageManagerService$$ExternalSyntheticLambda10(this), new PackageManagerService$$ExternalSyntheticLambda11(this));
        this.mDexOptHelper = new DexOptHelper(this);
        this.mSuspendPackageHelper = new SuspendPackageHelper(this, this.mInjector, this.mBroadcastHelper, this.mProtectedPackages);
        this.mDistractingPackageHelper = new DistractingPackageHelper(this, this.mBroadcastHelper, this.mSuspendPackageHelper);
        this.mStorageEventHelper = new StorageEventHelper(this, this.mDeletePackageHelper, this.mRemovePackageHelper);
        r0.traceBegin("readListOfTelephonyPackagesToBeDisabled");
        this.mInstallPackageHelper.readListOfTelephonyPackagesToBeDisabled();
        r0.traceEnd();
        r0.traceBegin("readListOfPackagesToBeDisabled");
        this.mInstallPackageHelper.readListOfPackagesToBeDisabled();
        r0.traceEnd();
        this.mPackageManagerServiceSmtEx = new PackageManagerServiceSmtEx(this, this.mPackageManagerServiceMonitorEx, this.mDexOptHelper);
        this.mPackageManagerServiceSmtEx.BytedanceOSInit();
        PackageManagerTracedLock r2 = this.mLock;
        boostPriorityForPackageManagerTracedLockedSection();
        monitor-enter(r2);
        this.mSnapshotStatistics = new SnapshotStatistics();     // Catch: Throwable -> L247
        sSnapshotPendingVersion.incrementAndGet();     // Catch: Throwable -> L247
        this.mLiveComputer = createLiveComputer();     // Catch: Throwable -> L247
        registerObservers(true);     // Catch: Throwable -> L247
        monitor-exit(r2);     // Catch: Throwable -> L247
        resetPriorityAfterPackageManagerTracedLockedSection();
        ComputerLocked r7 = this.mLiveComputer;
        PackageManagerTracedLock r8 = this.mInstallLock.acquireLock();
        PackageManagerTracedLock r9 = this.mLock;     // Catch: Throwable -> L239
        boostPriorityForPackageManagerTracedLockedSection();     // Catch: Throwable -> L239
        monitor-enter(r9);     // Catch: Throwable -> L239
        this.mHandler = r45.getHandler();     // Catch: Throwable -> L234
        this.mProcessLoggingHandler = new ProcessLoggingHandler();     // Catch: Throwable -> L234
        Watchdog.getInstance().addThread(this.mHandler, 600000);     // Catch: Throwable -> L234
        ArrayMap<String, SystemConfig.SharedLibraryEntry> r10 = r16.getSharedLibraries();     // Catch: Throwable -> L234
        int r11 = r10.size();     // Catch: Throwable -> L234
        int r12 = 0;
    L23:
        if (r12 >= r11) goto L32;
        PackageManagerTracedLock r23 = r8;
        this.mSharedLibraries.addBuiltInSharedLibraryLPw(r10.valueAt(r12));     // Catch: Throwable -> L28
        r12 = r12 + 1;
        r8 = r23;
    L28:
        th = th;
        PackageManagerTracedLock r13 = r9;
    L236:
        monitor-exit(r13);     // Catch: Throwable -> L213
        resetPriorityAfterPackageManagerTracedLockedSection();     // Catch: Throwable -> L230
        throw th;     // Catch: Throwable -> L230
    L30:
        th = th;
        r13 = r9;
        goto L236
    L32:
        PackageManagerTracedLock r24 = r8;
        int r14 = 0;
    L33:
        if (r14 >= r11) goto L256;
        String r25 = r10.keyAt(r14);     // Catch: Throwable -> L47
        ArrayMap<String, SystemConfig.SharedLibraryEntry> r21 = r10;
        SystemConfig.SharedLibraryEntry r15 = r10.valueAt(r14);     // Catch: Throwable -> L47
        String r26 = r6;
        int r17 = r15.dependencies.length;     // Catch: Throwable -> L42
        int r27 = r11;
        int r18 = 0;
    L37:
        if (r18 >= r17) goto L46;
        int r28 = r17;
        SharedLibraryInfo r19 = r7.getSharedLibraryInfo(r15.dependencies[r18], -1);     // Catch: Throwable -> L42
        if (r19 == null) goto L44;
        String r20 = r25;
        r7.getSharedLibraryInfo(r20, -1).addDependency(r19);     // Catch: Throwable -> L42
    L45:
        r18 = r18 + 1;
        r25 = r20;
        r17 = r28;
        r15 = r15;
        goto L37
    L44:
        r20 = r25;
        goto L45
    L46:
        r14 = r14 + 1;
        r10 = r21;
        r6 = r26;
        r11 = r27;
    L42:
        th = th;
        r13 = r9;
    L47:
        th = th;
        r13 = r9;
        goto L236
    L256:
        SELinuxMMAC.readInstallPolicy();     // Catch: Throwable -> L232
        r0.traceBegin("loadFallbacks");     // Catch: Throwable -> L232
        FallbackCategoryProvider.loadFallbacks();     // Catch: Throwable -> L232
        r0.traceEnd();     // Catch: Throwable -> L232
        r0.traceBegin("read user settings");     // Catch: Throwable -> L232
        if (this.mSettings.readLPw(r7, this.mInjector.getUserManagerInternal().getUsers(true, false, false)) == true) goto L53;
        boolean r29 = true;
    L54:
        this.mFirstBoot = r29;     // Catch: Throwable -> L232
        r0.traceEnd();     // Catch: Throwable -> L232
        if (this.mFirstBoot == false) goto L62;
        r0.traceBegin("setFirstBoot: ");     // Catch: Throwable -> L42
        this.mInstaller.setFirstBoot();     // Catch: Throwable -> L42 Installer.InstallerException -> L59
    L61:
        r0.traceEnd();     // Catch: Throwable -> L42
        goto L62
    L59:
        e = move-exception;
        Slog.w("PackageManager", "Could not set First Boot: ", e);     // Catch: Throwable -> L42
    L62:
        this.mPermissionManager.readLegacyPermissionsTEMP(this.mSettings.mPermissions);     // Catch: Throwable -> L232
        this.mPermissionManager.readLegacyPermissionStateTEMP();     // Catch: Throwable -> L232
        if (this.mFirstBoot == false) goto L65;
        DexOptHelper.requestCopyPreoptedFiles();     // Catch: Throwable -> L42
    L65:
        String r30 = Resources.getSystem().getString(R.string.config_defaultTextClassifierPackage);     // Catch: Throwable -> L232
        if (TextUtils.isEmpty(r30) == true) goto L68;
        this.mCustomResolverComponentName = ComponentName.unflattenFromString(r30);     // Catch: Throwable -> L42
    L68:
        long r31 = SystemClock.uptimeMillis();     // Catch: Throwable -> L232
        EventLog.writeEvent(EventLogTags.BOOT_PROGRESS_PMS_SYSTEM_SCAN_START, r31);     // Catch: Throwable -> L232
        SysOptBridge.getFactory().getBootEventStat().writeEvent("boot_event_pms_system_scan_start", SystemClock.elapsedRealtime());     // Catch: Throwable -> L232
        String r32 = System.getenv("BOOTCLASSPATH");     // Catch: Throwable -> L232
        String r33 = System.getenv("SYSTEMSERVERCLASSPATH");     // Catch: Throwable -> L232
        if (r32 != null) goto L71;
        Slog.w("PackageManager", "No BOOTCLASSPATH found!");     // Catch: Throwable -> L42
    L71:
        if (r33 != null) goto L73;
        Slog.w("PackageManager", "No SYSTEMSERVERCLASSPATH found!");     // Catch: Throwable -> L42
    L73:
        Settings.VersionInfo r34 = this.mSettings.getInternalVersion();     // Catch: Throwable -> L232
        if (r47.equals(r34.fingerprint) == true) goto L76;
        boolean r35 = true;
    L77:
        this.mIsUpgrade = r35;     // Catch: Throwable -> L232
        if (this.mIsUpgrade == false) goto L83;
        PackageManagerServiceUtils.logCriticalInfo(4, "Upgrading from " + r34.fingerprint + " (" + r34.buildFingerprint + ") to " + PackagePartitions.FINGERPRINT + " (" + Build.FINGERPRINT + ")");     // Catch: Throwable -> L42
    L83:
        if (this.mIsUpgrade == false) goto L86;
        int r36 = r34.sdkVersion;     // Catch: Throwable -> L42
    L87:
        this.mPriorSdkVersion = r36;     // Catch: Throwable -> L232
        this.mInitAppsHelper = new InitAppsHelper(this, this.mApexManager, this.mInstallPackageHelper, this.mInjector.getSystemPartitions());     // Catch: Throwable -> L232
        if (this.mIsUpgrade == true) goto L91;
    L93:
        boolean r37 = false;
    L94:
        this.mPromoteSystemApps = r37;     // Catch: Throwable -> L232
        if (this.mIsUpgrade == true) goto L98;
    L100:
        boolean r38 = false;
    L101:
        this.mIsPreNMR1Upgrade = r38;     // Catch: Throwable -> L232
        if (this.mIsUpgrade == true) goto L105;
    L107:
        boolean r39 = false;
    L108:
        this.mIsPreQUpgrade = r39;     // Catch: Throwable -> L232
        WatchedArrayMap<String, PackageSetting> r310 = this.mSettings.getPackagesLocked();     // Catch: Throwable -> L232
        String r40 = SystemProperties.get("ro.os.ota.version", "unknown");     // Catch: Throwable -> L232
        if ("unknown".equals(r40) == false) goto L113;
        r40 = SystemProperties.get("ro.pico.ota.version", "unknown");     // Catch: Throwable -> L42
    L113:
        if ("unknown".equals(r40) == false) goto L117;
        r40 = Build.FINGERPRINT;     // Catch: Throwable -> L42
    L117:
        if (this.mIsUpgrade == false) goto L121;
        SysOptBridge.getFactory().getBootEventStat().setBootType(2);     // Catch: Throwable -> L42
        EventLog.writeEvent(EventLogTags.BOOT_SYS_BOOTTYPE, 2);     // Catch: Throwable -> L42
        Slog.i("PackageManager", "This boot is upgrading, upgrading version to " + r40);     // Catch: Throwable -> L42
    L126:
        if (isDeviceUpgrading() == false) goto L132;
        this.mExistingPackages = new ArraySet(r310.size());     // Catch: Throwable -> L42
        int r41 = 0;
    L129:
        if (r41 >= r310.size()) goto L131;
        this.mExistingPackages.add(r310.valueAt(r41).getPackageName());     // Catch: Throwable -> L42
        r41 = r41 + 1;     // Catch: Throwable -> L42
        goto L129
    L131:
        r0.traceBegin("cross profile intent filter update");     // Catch: Throwable -> L42
        this.mInjector.getCrossProfileIntentFilterHelper().updateDefaultCrossProfileIntentFilter();     // Catch: Throwable -> L42
        r0.traceEnd();     // Catch: Throwable -> L42
    L132:
        this.mCacheDir = PackageManagerServiceUtils.preparePackageParserCache(this.mIsEngBuild, this.mIsUserDebugBuild, this.mIncrementalVersion);     // Catch: Throwable -> L232
        this.mInitialNonStoppedSystemPackages = this.mInjector.getSystemConfig().getInitialNonStoppedSystemPackages();     // Catch: Throwable -> L232
        this.mShouldStopSystemPackagesByDefault = this.mContext.getResources().getBoolean(R.bool.config_supportShortPressPowerWhenDefaultDisplayOn);     // Catch: Throwable -> L232
        this.mRemovableSystemAppHelper.init(this, this.mUserManager);     // Catch: Throwable -> L232
        this.mRemovableSystemAppHelper.initBeforeScan();     // Catch: Throwable -> L232
        this.mObricExt.beforeScan();     // Catch: Throwable -> L232
        int[] r311 = this.mUserManager.getUserIds();     // Catch: Throwable -> L232
        PackageParser2 r312 = this.mInjector.getScanningCachingPackageParser();     // Catch: Throwable -> L232
        PackageParser2 r110 = r312;
        final int[] r42 = r311;
        this.mOverlayConfig = this.mInitAppsHelper.initSystemApps(r312, r310, r311, r31);     // Catch: Throwable -> L232
        this.mInitAppsHelper.initNonSystemApps(r110, r42, r31);     // Catch: Throwable -> L232
        r110.close();     // Catch: Throwable -> L232
        this.mRequiredVerifierPackages = getRequiredButNotReallyRequiredVerifiersLPr(r7);     // Catch: Throwable -> L232
        this.mRequiredInstallerPackage = getRequiredInstallerLPr(r7);     // Catch: Throwable -> L232
        this.mRequiredUninstallerPackage = getRequiredUninstallerLPr(r7);     // Catch: Throwable -> L232
        this.mRequiredPermissionControllerPackage = getRequiredPermissionControllerLPr(r7);     // Catch: Throwable -> L232
        this.mStorageManagerPackage = getStorageManagerPackageName(r7);     // Catch: Throwable -> L232
        this.mSetupWizardPackage = getSetupWizardPackageNameImpl(r7);     // Catch: Throwable -> L232
        this.mComponentResolver.fixProtectedFilterPriorities(this.mSetupWizardPackage);     // Catch: Throwable -> L232
        this.mDefaultTextClassifierPackage = ensureSystemPackageName(r7, this.mContext.getString(R.string.content_description_sliding_handle));     // Catch: Throwable -> L232
        this.mSystemTextClassifierPackageName = ensureSystemPackageName(r7, this.mContext.getString(R.string.config_iccHotswapPromptForRestartDialogComponent));     // Catch: Throwable -> L232
        this.mConfiguratorPackage = ensureSystemPackageName(r7, this.mContext.getString(R.string.config_mainBuiltInDisplayCutout));     // Catch: Throwable -> L232
        this.mAppPredictionServicePackage = ensureSystemPackageName(r7, getPackageFromComponentString(R.string.config_devicePolicyManagementUpdater));     // Catch: Throwable -> L232
        this.mIncidentReportApproverPackage = ensureSystemPackageName(r7, this.mContext.getString(R.string.config_satellite_carrier_roaming_esos_provisioned_class));     // Catch: Throwable -> L232
        this.mRetailDemoPackage = getRetailDemoPackageName();     // Catch: Throwable -> L232
        this.mOverlayConfigSignaturePackage = ensureSystemPackageName(r7, this.mInjector.getSystemConfig().getOverlayConfigSignaturePackage());     // Catch: Throwable -> L232
        this.mRecentsPackage = ensureSystemPackageName(r7, getPackageFromComponentString(R.string.config_wimaxManagerClassname));     // Catch: Throwable -> L232
        this.mAmbientContextDetectionPackage = ensureSystemPackageName(r7, getPackageFromComponentString(R.string.config_deviceConfiguratorPackageName));     // Catch: Throwable -> L232
        this.mWearableSensingPackage = ensureSystemPackageName(r7, getPackageFromComponentString(R.string.config_intrusionDetectionEventTransport));     // Catch: Throwable -> L232
        this.mSharedLibraries.updateAllSharedLibrariesLPw(null, null, Collections.unmodifiableMap(this.mPackages));     // Catch: Throwable -> L232
        Iterator<SharedUserSetting> r43 = this.mSettings.getAllSharedUsersLPw().iterator();     // Catch: Throwable -> L232
    L134:
        if (r43.hasNext() == false) goto L138;
        SharedUserSetting r44 = r43.next();     // Catch: Throwable -> L42
        Iterator<SharedUserSetting> r313 = r43;
        PackageParser2 r314 = r110;
        ScanPackageUtils.applyAdjustedAbiToSharedUser(r44, null, this.mInjector.getAbiHelper().getAdjustedAbiForSharedUser(r44.getPackageStates(), null));     // Catch: Throwable -> L42
        r44.fixSeInfoLocked();     // Catch: Throwable -> L42
        r44.updateProcesses();     // Catch: Throwable -> L42
        r43 = r313;
        r110 = r314;
        goto L134
    L138:
        this.mPackageUsage.read(r310);     // Catch: Throwable -> L232
        this.mCompilerStats.read();     // Catch: Throwable -> L232
        EventLog.writeEvent(EventLogTags.BOOT_PROGRESS_PMS_SCAN_END, SystemClock.uptimeMillis());     // Catch: Throwable -> L232
        r13 = r9;
        SysOptBridge.getFactory().getBootEventStat().writeEvent("boot_event_pms_scan_end", SystemClock.elapsedRealtime());     // Catch: Throwable -> L219
        Slog.i("PackageManager", "Time to scan packages: " + ((SystemClock.uptimeMillis() - r31) / 1000.0f) + " seconds");     // Catch: Throwable -> L219
        if (this.mIsUpgrade == true) goto L275;
    L146:
        this.mPermissionManager.onStorageVolumeMounted(StorageManager.UUID_PRIVATE_INTERNAL, this.mIsUpgrade);     // Catch: Throwable -> L219
        r34.sdkVersion = this.mSdkVersion;     // Catch: Throwable -> L219
        if (this.mPromoteSystemApps == false) goto L149;
    L150:
        List<UserInfo> r52 = this.mInjector.getUserManagerInternal().getUsers(true);     // Catch: Throwable -> L219
        int r53 = 0;
    L152:
        if (r53 >= r52.size()) goto L156;
        this.mSettings.applyDefaultPreferredAppsLPw(r52.get(r53).id);     // Catch: Throwable -> L144
        r53 = r53 + 1;
    L156:
        if (this.mIsUpgrade == false) goto L166;
        Slog.i("PackageManager", "Build fingerprint changed; clearing code caches");     // Catch: Throwable -> L144
        int r54 = 0;
    L159:
        if (r54 >= r310.size()) goto L165;
        PackageSetting r55 = r310.valueAt(r54);     // Catch: Throwable -> L144
        if (Objects.equals(StorageManager.UUID_PRIVATE_INTERNAL, r55.getVolumeUuid()) == false) goto L164;
        this.mAppDataHelper.clearAppDataLIF(r55.getPkg(), -1, 131111);     // Catch: Throwable -> L144
    L164:
        r54 = r54 + 1;     // Catch: Throwable -> L144
        goto L159
    L165:
        r34.buildFingerprint = Build.FINGERPRINT;     // Catch: Throwable -> L144
        r34.fingerprint = PackagePartitions.FINGERPRINT;     // Catch: Throwable -> L144
    L166:
        this.mPrepareAppDataFuture = this.mAppDataHelper.fixAppsDataOnBoot();     // Catch: Throwable -> L219
        if (this.mIsPreQUpgrade == false) goto L177;
        Slog.i("PackageManager", "Allowlisting all existing apps to hide their icons");     // Catch: Throwable -> L144
        int r56 = r310.size();     // Catch: Throwable -> L144
        int r57 = 0;
    L169:
        if (r57 >= r56) goto L177;
        PackageSetting r58 = r310.valueAt(r57);     // Catch: Throwable -> L144
        if ((r58.getFlags() & 1) != 0) goto L174;
        r58.disableComponentLPw(PackageManager.APP_DETAILS_ACTIVITY_CLASS_NAME, 0);     // Catch: Throwable -> L144
    L174:
        r57 = r57 + 1;
        r56 = r56;
    L177:
        this.mPromoteSystemApps = false;     // Catch: Throwable -> L219
        r34.databaseVersion = 3;     // Catch: Throwable -> L219
        r0.traceBegin("write settings");     // Catch: Throwable -> L219
        writeSettingsLPrTEMP();     // Catch: Throwable -> L219
        r0.traceEnd();     // Catch: Throwable -> L219
        EventLog.writeEvent(EventLogTags.BOOT_PROGRESS_PMS_READY, SystemClock.uptimeMillis());     // Catch: Throwable -> L219
        SysOptBridge.getFactory().getBootEventStat().writeEvent("boot_event_pms_ready", SystemClock.elapsedRealtime());     // Catch: Throwable -> L219
        this.mOptionalVerifierPackage = getOptionalVerifierLPr(r7);     // Catch: Throwable -> L219
        this.mDomainVerificationManager.setProxy(DomainVerificationProxy.makeProxy(getIntentFilterVerifierComponentNameLPr(r7), getDomainVerificationAgentComponentNameLPr(r7, 0), this.mContext, this.mDomainVerificationManager, this.mDomainVerificationManager.getCollector(), this.mDomainVerificationConnection));     // Catch: Throwable -> L219
        this.mServicesExtensionPackageName = getRequiredServicesExtensionPackageLPr(r7);     // Catch: Throwable -> L219
        this.mSharedSystemSharedLibraryPackageName = getRequiredSharedLibrary(r7, "android.ext.shared", -1);     // Catch: Throwable -> L219
        int r59 = 0;
        this.mSettings.setPermissionControllerVersion(r7.getPackageInfo(this.mRequiredPermissionControllerPackage, 0, 0).getLongVersionCode());     // Catch: Throwable -> L219
        this.mRequiredSdkSandboxPackage = getRequiredSdkSandboxPackageName(r7);     // Catch: Throwable -> L219
        forEachPackageState(r7, new PackageManagerService$$ExternalSyntheticLambda12(this, r42));     // Catch: Throwable -> L219
        this.mInstallerService = this.mInjector.getPackageInstallerService();     // Catch: Throwable -> L219
        ComponentName r60 = getInstantAppResolver(r7);     // Catch: Throwable -> L219
        if (r60 != null) goto L180;
        String r61 = null;
        this.mInstantAppResolverConnection = null;     // Catch: Throwable -> L219
        this.mInstantAppResolverSettingsComponent = null;     // Catch: Throwable -> L219
    L186:
        updateInstantAppInstallerLocked(r61);     // Catch: Throwable -> L219
        HashMap r62 = new HashMap();     // Catch: Throwable -> L219
        int r63 = r42.length;     // Catch: Throwable -> L219
    L187:
        if (r59 >= r63) goto L191;
        int r64 = r42[r59];     // Catch: Throwable -> L144
        int r111 = r59;
        int[] r315 = r42;
        Settings.VersionInfo r112 = r34;
        r62.put(Integer.valueOf(r64), r7.getInstalledPackages(0, r64).getList());     // Catch: Throwable -> L144
        r59 = r111 + 1;
        r34 = r112;
        r42 = r315;
        goto L187
    L191:
        this.mDexManager.load(r62);     // Catch: Throwable -> L219
        this.mDynamicCodeLogger.load(r62);     // Catch: Throwable -> L219
        if (this.mIsUpgrade == false) goto L195;
        FrameworkStatsLog.write(239, 13, SystemClock.uptimeMillis() - r31);     // Catch: Throwable -> L144
    L195:
        if (this.mFirstBoot == true) goto L200;
        if (isDeviceUpgrading() == true) goto L200;
    L223:
        this.mLiveComputer = createLiveComputer();     // Catch: Throwable -> L213
        monitor-exit(r13);     // Catch: Throwable -> L213
        resetPriorityAfterPackageManagerTracedLockedSection();     // Catch: Throwable -> L230
        if (r24 == null) goto L228;
        r24.close();
    L228:
        this.mModuleInfoProvider = this.mInjector.getModuleInfoProvider();
        this.mInjector.getSystemWrapper().enablePackageCaches();
        this.mInstaller.setWarnIfHeld(this.mLock);
        ParsingPackageUtils.readConfigUseRoundIcon(this.mContext.getResources());
        this.mServiceStartWithDelay = SystemClock.uptimeMillis() + 60000;
        SysOptBridge.getFactory().getAppRecordManagerService().initAppRecord(this, this.mPackages);
        Slog.i("PackageManager", "Fix for b/169414761 is applied");
        return;
    L144:
        th = th;
    L200:
        ArrayMap<String, String> r65 = r16.getAppMetadataFilePaths();     // Catch: Throwable -> L219
        Iterator<Map.Entry<String, String>> r66 = r65.entrySet().iterator();     // Catch: Throwable -> L219
    L201:
        if (r66.hasNext() == false) goto L223;
        Map.Entry<String, String> r67 = r66.next();     // Catch: Throwable -> L219
        String r68 = r67.getKey();     // Catch: Throwable -> L219
        String r69 = r67.getValue();     // Catch: Throwable -> L219
        ComputerLocked r113 = r7;
    L213:
        th = th;
        goto L236
    L206:
        if (new File(r69).exists() == true) goto L208;
        r69 = null;
    L208:
        PackageSetting r70 = this.mSettings.getDisabledSystemPkgLPr(r68);     // Catch: Throwable -> L213
        if (r70 != null) goto L217;
        PackageSetting r71 = this.mSettings.getPackageLPr(r68);     // Catch: Throwable -> L213
        if (r71 == null) goto L215;
        r71.setAppMetadataFilePath(r69);     // Catch: Throwable -> L213
        r71.setAppMetadataSource(3);     // Catch: Throwable -> L213
    L218:
        r7 = r113;
        r65 = r65;
        r66 = r66;
        goto L201
    L215:
        Slog.w("PackageManager", "Cannot set app metadata file for nonexistent package " + r68);     // Catch: Throwable -> L213
        goto L218
    L217:
        r66 = r66;
        r70.setAppMetadataFilePath(r69);     // Catch: Throwable -> L213
        r70.setAppMetadataSource(3);     // Catch: Throwable -> L213
        goto L218
    L180:
        if (DEBUG_INSTANT == false) goto L182;
        Slog.d("PackageManager", "Set ephemeral resolver: " + r60);     // Catch: Throwable -> L144
    L182:
        this.mInstantAppResolverConnection = this.mInjector.getInstantAppResolverConnection(r60);     // Catch: Throwable -> L144
        this.mInstantAppResolverSettingsComponent = getInstantAppResolverSettingsLPr(r7, r60);     // Catch: Throwable -> L144
        r61 = null;
        goto L186
    L149:
        if (this.mFirstBoot == false) goto L156;
    L275:
        Slog.i("PackageManager", "Partitions fingerprint changed from " + r34.fingerprint + " to " + PackagePartitions.FINGERPRINT + "; regranting permissions for internal storage");     // Catch: Throwable -> L144
    L219:
        th = th;
        goto L236
    L121:
        if (this.mFirstBoot == false) goto L124;
        SysOptBridge.getFactory().getBootEventStat().setBootType(1);     // Catch: Throwable -> L42
        EventLog.writeEvent(EventLogTags.BOOT_SYS_BOOTTYPE, 1);     // Catch: Throwable -> L42
        Slog.i("PackageManager", "This boot is the first boot, version is " + r40);     // Catch: Throwable -> L42
        goto L126
    L124:
        Slog.i("PackageManager", "This boot is a normal boot, version is " + r40);     // Catch: Throwable -> L232
        goto L126
    L105:
        if (r34.sdkVersion >= 29) goto L107;
        r39 = true;
        goto L108
    L98:
        if (r34.sdkVersion >= 25) goto L100;
        r38 = true;
        goto L101
    L91:
        if (r34.sdkVersion > 22) goto L93;
        r37 = true;
        goto L94
    L86:
        r36 = -1;
        goto L87
    L76:
        r35 = false;
        goto L77
    L53:
        r29 = false;
    L232:
        th = th;
        r13 = r9;
    L234:
        th = th;
        r13 = r9;
    L230:
        th = move-exception;
        Throwable r72 = th;
        ?? r210 = r22;
    L241:
        if (r210 == 0) goto L302;
        r210.close();     // Catch: Throwable -> L244
        throw r72;
    L244:
        th = move-exception;
        r72.addSuppressed(th);
        throw r72;
    L302:
        throw r72;
    L239:
        th = move-exception;
        r210 = r8;
        r72 = th;
    L247:
        th = th;
    L270:
        resetPriorityAfterPackageManagerTracedLockedSection();
        throw th;
    L252:
        th = th;
        goto L270
    L8:
        if (r6.length() <= 0) goto L13;
        if (SettingsToPropertiesMapper.NAMESPACE_REBOOT_STAGING_DELIMITER.equals(r6) == false) goto L12;
        this.mDefParseFlags = 2;
        this.mSeparateProcesses = null;
        Slog.w("PackageManager", "Running with debug.separate_processes: * (ALL)");
        goto L14
    L12:
        this.mDefParseFlags = 0;
        this.mSeparateProcesses = r6.split(",");
        Slog.w("PackageManager", "Running with debug.separate_processes: " + r6);
        goto L14
    }

    private /* synthetic */ ResolveInfo lambda$new$44() {
        return this.mResolveInfo;
    }

    private /* synthetic */ ActivityInfo lambda$new$45() {
        return this.mInstantAppInstallerActivity;
    }

    private /* synthetic */ void lambda$new$46(int[] userIds, PackageStateInternal packageState) {
        AndroidPackage pkg = packageState.getAndroidPackage();
        if (pkg != null) goto L5;
        return;
    L5:
        if (packageState.isSystem() == true) goto L22;
        int r1 = userIds.length;
        int r2 = 0;
    L8:
        if (r2 >= r1) goto L16;
        int userId = userIds[r2];
        if (packageState.getUserStateOrDefault(userId).isInstantApp() == false) goto L15;
        if (packageState.getUserStateOrDefault(userId).isInstalled() == false) goto L15;
        this.mInstantAppRegistry.addInstantApp(userId, packageState.getAppId());
    L15:
        r2 = r2 + 1;
        goto L8
    L16:
        return;
    }

    void updateInstantAppInstallerLocked(String modifiedPackage) {
        if (this.mInstantAppInstallerActivity != null) goto L5;
    L7:
        setUpInstantAppInstallerActivityLP(getInstantAppInstallerLPr());
        return;
    L5:
        if (this.mInstantAppInstallerActivity.getComponentName().getPackageName().equals(modifiedPackage) == true) goto L7;
    }

    public boolean isFirstBoot() {
        return this.mFirstBoot;
    }

    public boolean isDeviceUpgrading() {
        if (this.mIsUpgrade == false) goto L5;
    L6:
        return true;
    L5:
        if (SystemProperties.getBoolean("persist.pm.mock-upgrade", false) == true) goto L6;
        return false;
    }

    private String[] getRequiredButNotReallyRequiredVerifiersLPr(Computer computer) {
        Intent intent = new Intent("android.intent.action.PACKAGE_NEEDS_VERIFICATION");
        List<ResolveInfo> matches = this.mResolveIntentHelper.queryIntentReceiversInternal(computer, intent, PACKAGE_MIME_TYPE, 1835008, 0, Binder.getCallingUid());
        int size = matches.size();
        if (size != 0) goto L7;
        Log.w("PackageManager", "There should probably be a verifier, but, none were found");
        return EmptyArray.STRING;
    L7:
        if (size > 2) goto L18;
        String[] verifiers = new String[size];
        int i = 0;
    L9:
        if (i >= size) goto L16;
        verifiers[i] = matches.get(i).getComponentInfo().packageName;
        if (TextUtils.isEmpty(verifiers[i]) == true) goto L14;
        i = i + 1;
        goto L9
    L14:
        throw new RuntimeException("Invalid verifier: " + matches);
    L16:
        return verifiers;
    L18:
        throw new RuntimeException("There must be no more than 2 verifiers; found " + matches);
    }

    private String getOptionalVerifierLPr(Computer computer) {
        Intent intent = new Intent("com.qualcomm.qti.intent.action.PACKAGE_NEEDS_OPTIONAL_VERIFICATION");
        List<ResolveInfo> matches = this.mResolveIntentHelper.queryIntentReceiversInternal(computer, intent, PACKAGE_MIME_TYPE, 1835008, 0, Binder.getCallingUid());
        if (matches.size() < 1) goto L15;
        String optionalVerifierName = this.mContext.getResources().getString(R.string.config_supervisedUserCreationPackage);
        if (TextUtils.isEmpty(optionalVerifierName) == false) goto L7;
        return null;
    L7:
        int i = 0;
    L9:
        if (i >= matches.size()) goto L15;
        if (matches.get(i).getComponentInfo().packageName.contains(optionalVerifierName) == true) goto L13;
        i = i + 1;
        goto L9
    L13:
        return matches.get(i).getComponentInfo().packageName;
    L15:
        return null;
    }

    private String getRequiredSharedLibrary(Computer snapshot, String name, int version) {
        SharedLibraryInfo libraryInfo = snapshot.getSharedLibraryInfo(name, version);
        if (libraryInfo == null) goto L10;
        String packageName = libraryInfo.getPackageName();
        if (packageName == null) goto L8;
        return packageName;
    L8:
        throw new IllegalStateException("Expected a package for shared library " + name);
    L10:
        throw new IllegalStateException("Missing required shared library:" + name);
    }

    private String getRequiredServicesExtensionPackageLPr(Computer computer) {
        String configServicesExtensionPackage = this.mContext.getString(R.string.content_description_sliding_handle);
        if (TextUtils.isEmpty(configServicesExtensionPackage) == true) goto L10;
        String servicesExtensionPackage = ensureSystemPackageName(computer, configServicesExtensionPackage);
        if (TextUtils.isEmpty(servicesExtensionPackage) == true) goto L8;
        return servicesExtensionPackage;
    L8:
        throw new RuntimeException("Required services extension package is missing, config_servicesExtensionPackage had defined with " + configServicesExtensionPackage + ", but can not find the package info on the system image, check if the package has a problem.");
    L10:
        throw new RuntimeException("Required services extension package failed due to config_servicesExtensionPackage is empty.");
    }

    private String getRequiredInstallerLPr(Computer computer) {
        Intent intent = new Intent("android.intent.action.INSTALL_PACKAGE");
        intent.addCategory("android.intent.category.DEFAULT");
        intent.setDataAndType(Uri.parse("content://com.example/foo.apk"), PACKAGE_MIME_TYPE);
        List<ResolveInfo> matches = computer.queryIntentActivitiesInternal(intent, PACKAGE_MIME_TYPE, 1835008, 0);
        if (matches.size() != 1) goto L11;
        ResolveInfo resolveInfo = matches.get(0);
        if (resolveInfo.activityInfo.applicationInfo.isPrivilegedApp() == false) goto L9;
        return matches.get(0).getComponentInfo().packageName;
    L9:
        throw new RuntimeException("The installer must be a privileged app");
    L11:
        throw new RuntimeException("There must be exactly one installer; found " + matches);
    }

    private String getRequiredUninstallerLPr(Computer computer) {
        Intent intent = new Intent("android.intent.action.UNINSTALL_PACKAGE");
        intent.addCategory("android.intent.category.DEFAULT");
        intent.setData(Uri.fromParts("package", "foo.bar", null));
        ResolveInfo resolveInfo = this.mResolveIntentHelper.resolveIntentInternal(computer, intent, null, 1835008, 0, 0, false, Binder.getCallingUid(), Binder.getCallingPid());
        if (resolveInfo == null) goto L9;
        if (this.mResolveActivity.name.equals(resolveInfo.getComponentInfo().name) == true) goto L9;
        return resolveInfo.getComponentInfo().packageName;
    L9:
        throw new RuntimeException("There must be exactly one uninstaller; found " + resolveInfo);
    }

    private String getRequiredPermissionControllerLPr(Computer computer) {
        Intent intent = new Intent("android.intent.action.MANAGE_PERMISSIONS");
        intent.addCategory("android.intent.category.DEFAULT");
        List<ResolveInfo> matches = computer.queryIntentActivitiesInternal(intent, null, 1835008, 0);
        if (matches.size() != 1) goto L11;
        ResolveInfo resolveInfo = matches.get(0);
        if (resolveInfo.activityInfo.applicationInfo.isPrivilegedApp() == false) goto L9;
        return matches.get(0).getComponentInfo().packageName;
    L9:
        throw new RuntimeException("The permissions manager must be a privileged app");
    L11:
        throw new RuntimeException("There must be exactly one permissions manager; found " + matches);
    }

    private ComponentName getIntentFilterVerifierComponentNameLPr(Computer computer) {
        Intent intent = new Intent("android.intent.action.INTENT_FILTER_NEEDS_VERIFICATION");
        List<ResolveInfo> matches = this.mResolveIntentHelper.queryIntentReceiversInternal(computer, intent, PACKAGE_MIME_TYPE, 1835008, 0, Binder.getCallingUid());
        ResolveInfo best = null;
        int N = matches.size();
        int i = 0;
    L3:
        if (i >= N) goto L13;
        ResolveInfo cur = matches.get(i);
        String packageName = cur.getComponentInfo().packageName;
        if (checkPermission("android.permission.INTENT_FILTER_VERIFICATION_AGENT", packageName, 0) != 0) goto L11;
        if (best != null) goto L9;
    L10:
        best = cur;
        goto L11
    L9:
        if (cur.priority > best.priority) goto L10;
    L11:
        i = i + 1;
        goto L3
    L13:
        if (best != null) goto L15;
        Slog.w("PackageManager", "Intent filter verifier not found");
        return null;
    L15:
        return best.getComponentInfo().getComponentName();
    }

    private ComponentName getDomainVerificationAgentComponentNameLPr(Computer computer, int userId) {
        Intent intent = new Intent("android.intent.action.DOMAINS_NEED_VERIFICATION");
        List<ResolveInfo> matches = this.mResolveIntentHelper.queryIntentReceiversInternal(computer, intent, null, 1835008, userId, Binder.getCallingUid());
        ResolveInfo best = null;
        int N = matches.size();
        int i = 0;
    L4:
        if (i >= N) goto L17;
        ResolveInfo cur = matches.get(i);
        String packageName = cur.getComponentInfo().packageName;
        if (checkPermission("android.permission.DOMAIN_VERIFICATION_AGENT", packageName, userId) == 0) goto L8;
        Slog.w("PackageManager", "Domain verification agent found but does not hold permission: " + packageName);
    L15:
        i = i + 1;
        goto L4
    L8:
        if (best == null) goto L12;
        if (cur.priority <= best.priority) goto L15;
    L12:
        if (computer.isComponentEffectivelyEnabled(cur.getComponentInfo(), UserHandle.of(userId)) == false) goto L14;
        best = cur;
        goto L15
    L14:
        Slog.w("PackageManager", "Domain verification agent found but not enabled");
        goto L15
    L17:
        if (best != null) goto L19;
        Slog.w("PackageManager", "Domain verification agent not found");
        return null;
    L19:
        return best.getComponentInfo().getComponentName();
    }

    ComponentName getInstantAppResolver(Computer snapshot) {
        String[] packageArray = this.mContext.getResources().getStringArray(R.array.config_healthConnectRestoreKnownSigners);
        if (packageArray.length == 0) goto L5;
    L10:
        int callingUid = Binder.getCallingUid();
        if (Build.IS_DEBUGGABLE == true) goto L13;
        int r2 = 1048576;
    L14:
        int resolveFlags = r2 | 786432;
        Intent resolverIntent = new Intent("android.intent.action.RESOLVE_INSTANT_APP_PACKAGE");
        List<ResolveInfo> resolvers = snapshot.queryIntentServicesInternal(resolverIntent, null, resolveFlags, 0, callingUid, -1, false, false);
        int N = resolvers.size();
        if (N == 0) goto L17;
        Set<String> possiblePackages = new ArraySet(Arrays.asList(packageArray));
        int i = 0;
    L21:
        if (i >= N) goto L39;
        ResolveInfo info = resolvers.get(i);
        if (info.serviceInfo == null) goto L32;
        String packageName = info.serviceInfo.packageName;
        if (possiblePackages.contains(packageName) == true) goto L34;
        if (Build.IS_DEBUGGABLE == true) goto L34;
        if (DEBUG_INSTANT == false) goto L32;
        Slog.d("PackageManager", "Ephemeral resolver not in allowed package list; pkg: " + packageName + ", info:" + info);
    L34:
        if (DEBUG_INSTANT == false) goto L37;
        Slog.v("PackageManager", "Ephemeral resolver found; pkg: " + packageName + ", info:" + info);
    L37:
        return new ComponentName(packageName, info.serviceInfo.name);
    L32:
        i = i + 1;
        goto L21
    L39:
        if (DEBUG_INSTANT == false) goto L41;
        Slog.v("PackageManager", "Ephemeral resolver NOT found");
    L41:
        return null;
    L17:
        if (DEBUG_INSTANT == false) goto L19;
        Slog.d("PackageManager", "Ephemeral resolver NOT found; no matching intent filters");
    L19:
        return null;
    L13:
        r2 = 0;
        goto L14
    L5:
        if (Build.IS_DEBUGGABLE == true) goto L10;
        if (DEBUG_INSTANT == false) goto L9;
        Slog.d("PackageManager", "Ephemeral resolver NOT found; empty package list");
    L9:
        return null;
    }

    private ActivityInfo getInstantAppInstallerLPr() {
        if (this.mIsEngBuild == false) goto L5;
        String[] orderedActions = {"android.intent.action.INSTALL_INSTANT_APP_PACKAGE_TEST", "android.intent.action.INSTALL_INSTANT_APP_PACKAGE"};
    L7:
        if (this.mIsEngBuild == false) goto L9;
        int r1 = 0;
    L10:
        int resolveFlags = r1 | (-2146697216);
        Computer computer = snapshotComputer();
        Intent intent = new Intent();
        intent.addCategory("android.intent.category.DEFAULT");
        intent.setDataAndType(Uri.fromFile(new File("foo.apk")), PACKAGE_MIME_TYPE);
        int r10 = orderedActions.length;
        int r12 = 0;
        List<ResolveInfo> matches = null;
    L12:
        if (r12 >= r10) goto L19;
        String action = orderedActions[r12];
        intent.setAction(action);
        matches = computer.queryIntentActivitiesInternal(intent, PACKAGE_MIME_TYPE, resolveFlags, 0);
        if (matches.isEmpty() == false) goto L19;
        if (DEBUG_INSTANT == false) goto L18;
        Slog.d("PackageManager", "Instant App installer not found with " + action);
    L18:
        r12 = r12 + 1;
    L19:
        Iterator<ResolveInfo> iter = matches.iterator();
    L21:
        if (iter.hasNext() == false) goto L29;
        ResolveInfo rInfo = iter.next();
        if (checkPermission("android.permission.INSTALL_PACKAGES", rInfo.activityInfo.packageName, 0) == 0) goto L21;
        if (this.mIsEngBuild == true) goto L21;
        iter.remove();
        goto L21
    L29:
        if (matches.size() != 0) goto L33;
        return null;
    L33:
        if (matches.size() != 1) goto L37;
        return (ActivityInfo) matches.get(0).getComponentInfo();
    L37:
        throw new RuntimeException("There must be at most one ephemeral installer; found " + matches);
    L9:
        r1 = 1048576;
        goto L10
    L5:
        orderedActions = new String[]{"android.intent.action.INSTALL_INSTANT_APP_PACKAGE"};
        goto L7
    }

    private ComponentName getInstantAppResolverSettingsLPr(Computer computer, ComponentName resolver) {
        Intent intent = new Intent("android.intent.action.INSTANT_APP_RESOLVER_SETTINGS").addCategory("android.intent.category.DEFAULT").setPackage(resolver.getPackageName());
        List<ResolveInfo> matches = computer.queryIntentActivitiesInternal(intent, null, 786432, 0);
        if (matches.isEmpty() == false) goto L7;
        return null;
    L7:
        return matches.get(0).getComponentInfo().getComponentName();
    }

    public PermissionGroupInfo getPermissionGroupInfo(String groupName, int flags) {
        return ((PermissionManager) this.mContext.getSystemService(PermissionManager.class)).getPermissionGroupInfo(groupName, flags);
    }

    public void freeAllAppCacheAboveQuota(String volumeUuid) throws IOException {
        PackageManagerTracedLock installLock = this.mInstallLock.acquireLock();     // Catch: Installer.InstallerException -> L7
        this.mInstaller.freeCache(volumeUuid, Long.MAX_VALUE, 2304);     // Catch: Throwable -> L10
        if (installLock == null) goto L24;
        installLock.close();     // Catch: Installer.InstallerException -> L7
        return;
    L24:
        return;
    L10:
        th = move-exception;
        if (installLock != null) goto L19;
    L17:
        throw th;     // Catch: Installer.InstallerException -> L7
    L19:
        installLock.close();     // Catch: Throwable -> L14
    L14:
        th = move-exception;
        th.addSuppressed(th);     // Catch: Installer.InstallerException -> L7
    }

    public void freeStorage(String volumeUuid, long bytes, int flags) throws IOException {
        this.mFreeStorageHelper.freeStorage(volumeUuid, bytes, flags);
    }

    int freeCacheForInstallation(int recommendedInstallLocation, PackageLite pkgLite, String resolvedPath, String mPackageAbiOverride, int installFlags) {
        return this.mFreeStorageHelper.freeCacheForInstallation(recommendedInstallLocation, pkgLite, resolvedPath, mPackageAbiOverride, installFlags);
    }

    public ModuleInfo getModuleInfo(String packageName, int flags) {
        return this.mModuleInfoProvider.getModuleInfo(packageName, flags);
    }

    void updateSequenceNumberLP(PackageSetting pkgSetting, int[] userList) {
        this.mChangedPackagesTracker.updateSequenceNumber(pkgSetting.getPackageName(), userList);
    }

    public boolean hasSystemFeature(String name, int version) {
        FeatureInfo feat = this.mAvailableFeatures.get(name);
        if (feat != null) goto L6;
        return false;
    L6:
        if (feat.version < version) goto L9;
        return true;
    L9:
        return false;
    }

    public int checkPermission(String permName, String pkgName, int userId) {
        return this.mPermissionManager.checkPermission(pkgName, permName, "default:0", userId);
    }

    public String getSdkSandboxPackageName() {
        return this.mRequiredSdkSandboxPackage;
    }

    String getPackageInstallerPackageName() {
        return this.mRequiredInstallerPackage;
    }

    void requestInstantAppResolutionPhaseTwo(AuxiliaryResolveInfo responseObj, Intent origIntent, String resolvedType, String callingPackage, String callingFeatureId, boolean isRequesterInstantApp, Bundle verificationBundle, int userId) {
        Message msg = this.mHandler.obtainMessage(20, new InstantAppRequest(responseObj, origIntent, resolvedType, callingPackage, callingFeatureId, isRequesterInstantApp, userId, verificationBundle, false, responseObj.hostDigestPrefixSecure, responseObj.token));
        this.mHandler.sendMessage(msg);
    }

    public ParceledListSlice<ResolveInfo> queryIntentReceivers(Computer snapshot, Intent intent, String resolvedType, long flags, int userId) {
        return new ParceledListSlice(this.mResolveIntentHelper.queryIntentReceiversInternal(snapshot, intent, resolvedType, flags, userId, Binder.getCallingUid()));
    }

    public static void reportSettingsProblem(int priority, String msg) {
        PackageManagerServiceUtils.logCriticalInfo(priority, msg);
    }

    static void renameStaticSharedLibraryPackage(ParsedPackage parsedPackage) {
        parsedPackage.setPackageName(toStaticSharedLibraryPackageName(parsedPackage.getPackageName(), parsedPackage.getStaticSharedLibraryVersion()));
    }

    private static String toStaticSharedLibraryPackageName(String packageName, long libraryVersion) {
        return packageName + STATIC_SHARED_LIB_DELIMITER + libraryVersion;
    }

    public void performFstrimIfNeeded() {
        this.mFreeStorageHelper.performFstrimIfNeeded();
    }

    public void updatePackagesIfNeeded() {
        this.mDexOptHelper.performPackageDexOptUpgradeIfNeeded();
    }

    public void updateMetricsIfNeeded() {
        DisplayManager displayManager = (DisplayManager) this.mContext.getSystemService(DisplayManager.class);
        if (displayManager == null) goto L8;
        Display display = displayManager.getDisplay(0);
        if (display == null) goto L9;
        display.getMetrics(this.mMetrics);
        return;
    L9:
        return;
    }

    private void notifyPackageUseInternal(String packageName, int reason) {
        long time = System.currentTimeMillis();
        PackageManagerTracedLock r2 = this.mLock;
        boostPriorityForPackageManagerTracedLockedSection();
        monitor-enter(r2);
        PackageSetting pkgSetting = this.mSettings.getPackageLPr(packageName);     // Catch: Throwable -> L9
        if (pkgSetting != null) goto L11;
        monitor-exit(r2);     // Catch: Throwable -> L9
        resetPriorityAfterPackageManagerTracedLockedSection();
        return;
    L11:
        pkgSetting.getPkgState().setLastPackageUsageTimeInMills(reason, time);     // Catch: Throwable -> L9
        monitor-exit(r2);     // Catch: Throwable -> L9
        resetPriorityAfterPackageManagerTracedLockedSection();
        return;
    L9:
        th = move-exception;
        resetPriorityAfterPackageManagerTracedLockedSection();
        throw th;
    }

    DexManager getDexManager() {
        return this.mDexManager;
    }

    DexOptHelper getDexOptHelper() {
        return this.mDexOptHelper;
    }

    DynamicCodeLogger getDynamicCodeLogger() {
        return this.mDynamicCodeLogger;
    }

    public void shutdown() {
        this.mExt.shutdown();
        this.mCompilerStats.writeNow();
        this.mDexManager.writePackageDexUsageNow();
        this.mDynamicCodeLogger.writeNow();
        PackageManagerTracedLock r0 = this.mLock;
        boostPriorityForPackageManagerTracedLockedSection();
        monitor-enter(r0);
        this.mPackageUsage.writeNow(this.mSettings.getPackagesLocked());     // Catch: Throwable -> L11
        if (this.mHandler.hasMessages(13) == false) goto L7;
    L13:
        writeSettings(true);     // Catch: Throwable -> L11
    L14:
        monitor-exit(r0);     // Catch: Throwable -> L11
        resetPriorityAfterPackageManagerTracedLockedSection();
        return;
    L7:
        if (this.mBackgroundHandler.hasMessages(14) == true) goto L13;
        if (this.mHandler.hasMessages(19) == false) goto L14;
    L11:
        th = move-exception;
        resetPriorityAfterPackageManagerTracedLockedSection();
        throw th;
    }

    int[] resolveUserIds(int userId) {
        if (userId != (-1)) goto L6;
        return this.mUserManager.getUserIds();
    L6:
        return new int[]{userId};
    }

    private void setUpInstantAppInstallerActivityLP(ActivityInfo installerActivity) {
        if (installerActivity != null) goto L10;
        if (DEBUG_INSTANT == false) goto L7;
        Slog.d("PackageManager", "Clear ephemeral installer activity");
    L7:
        this.mInstantAppInstallerActivity = null;
        onChanged();
        return;
    L10:
        if (DEBUG_INSTANT == false) goto L12;
        Slog.d("PackageManager", "Set ephemeral installer activity: " + installerActivity.getComponentName());
    L12:
        this.mInstantAppInstallerActivity = installerActivity;
        this.mInstantAppInstallerActivity.flags |= 288;
        this.mInstantAppInstallerActivity.exported = true;
        this.mInstantAppInstallerActivity.enabled = true;
        this.mInstantAppInstallerInfo.activityInfo = this.mInstantAppInstallerActivity;
        this.mInstantAppInstallerInfo.priority = 1;
        this.mInstantAppInstallerInfo.preferredOrder = 1;
        this.mInstantAppInstallerInfo.isDefault = true;
        this.mInstantAppInstallerInfo.match = 5799936;
        onChanged();
    }

    void killApplication(String pkgName, int appId, String reason, int exitInfoReason) {
        killApplication(pkgName, appId, -1, reason, exitInfoReason);
    }

    void killApplication(String pkgName, int appId, int userId, String reason, int exitInfoReason) {
        long token = Binder.clearCallingIdentity();
        IActivityManager am = ActivityManager.getService();     // Catch: Throwable -> L16
        if (am == null) goto L14;
        am.killApplication(pkgName, appId, userId, reason, exitInfoReason);     // Catch: Throwable -> L9 RemoteException -> L11
    L9:
        th = move-exception;
        Throwable r10 = th;
    L18:
        Binder.restoreCallingIdentity(token);
        throw r10;
    L14:
        Binder.restoreCallingIdentity(token);
        return;
    L16:
        th = move-exception;
        r10 = th;
        goto L18
    }

    void killApplicationSync(String pkgName, int appId, int userId, String reason, int exitInfoReason) {
        ActivityManagerInternal mAmi = (ActivityManagerInternal) LocalServices.getService(ActivityManagerInternal.class);
        if (Thread.holdsLock(this.mLock) == true) goto L18;
        if (mAmi == null) goto L18;
        KillAppBlocker blocker = new KillAppBlocker();
        blocker.register();     // Catch: Throwable -> L12
        mAmi.killApplicationSync(pkgName, appId, userId, reason, exitInfoReason);     // Catch: Throwable -> L14
        blocker.waitAppProcessGone(mAmi, snapshotComputer(), this.mUserManager, pkgName);     // Catch: Throwable -> L12
        blocker.unregister();
        return;
    L14:
        th = th;
    L16:
        blocker.unregister();
        throw th;
    L12:
        th = th;
    L18:
        Slog.e("PackageManager", "Holds PM's lock, unable kill application synchronized");
        killApplication(pkgName, appId, userId, reason, exitInfoReason);
    }

    @Override // com.android.server.pm.PackageSender
    public void notifyPackageAdded(String packageName, int uid) {
        this.mPackageObserverHelper.notifyAdded(packageName, uid);
        getSmtEx().notifyPkgChangeEventToResManager(uid, 0, packageName);
    }

    @Override // com.android.server.pm.PackageSender
    public void notifyPackageChanged(String packageName, int uid) {
        this.mPackageObserverHelper.notifyChanged(packageName, uid);
        getSmtEx().notifyPkgChangeEventToResManager(uid, 1, packageName);
    }

    @Override // com.android.server.pm.PackageSender
    public void notifyPackageRemoved(String packageName, int uid) {
        this.mPackageObserverHelper.notifyRemoved(packageName, uid);
        UserPackage.removeFromCache(UserHandle.getUserId(uid), packageName);
        getSmtEx().notifyPkgChangeEventToResManager(uid, 2, packageName);
    }

    boolean isUserRestricted(int userId, String restrictionKey) {
        Bundle restrictions = this.mUserManager.getUserRestrictions(userId);
        if (restrictions.getBoolean(restrictionKey, false) == false) goto L6;
        Log.w("PackageManager", "User is restricted: " + restrictionKey);
        return true;
    L6:
        return false;
    }

    private void enforceCanSetPackagesSuspendedAsUser(Computer snapshot, boolean quarantined, UserPackage suspender, int callingUid, int targetUserId, String callingMethod) {
        if (callingUid != 0) goto L4;
        return;
    L4:
        if (UserHandle.getAppId(callingUid) == 1000) goto L33;
        String ownerPackage = this.mProtectedPackages.getDeviceOwnerOrProfileOwnerPackage(targetUserId);
        if (ownerPackage == null) goto L11;
        int ownerUid = snapshot.getPackageUid(ownerPackage, 0, targetUserId);
        if (ownerUid != callingUid) goto L11;
        return;
    L11:
        if (quarantined == false) goto L13;
        this.mContext.enforceCallingOrSelfPermission("android.permission.QUARANTINE_APPS", callingMethod);
    L14:
        int packageUid = snapshot.getPackageUid(suspender.packageName, 0, targetUserId);
        boolean allowedShell = false;
        if (packageUid != callingUid) goto L17;
        boolean allowedPackageUid = true;
    L19:
        if (callingUid == 2000) goto L21;
    L25:
        if (allowedShell == true) goto L30;
        if (allowedPackageUid == false) goto L29;
        return;
    L29:
        throw new SecurityException("Suspending package " + suspender.packageName + " in user " + targetUserId + " does not belong to calling uid " + callingUid);
    L30:
        return;
    L21:
        if (UserHandle.isSameApp(packageUid, callingUid) == false) goto L25;
        allowedShell = true;
        goto L25
    L17:
        allowedPackageUid = false;
        goto L19
    L13:
        this.mContext.enforceCallingOrSelfPermission("android.permission.SUSPEND_APPS", callingMethod);
        goto L14
    }

    void unsuspendForSuspendingPackage(Computer computer, String suspendingPackage, int suspendingUserId, int targetUserId) {
        String[] allPackages = (String[]) computer.getPackageStates().keySet().toArray(new String[0]);
        final UserPackage r1 = UserPackage.of(suspendingUserId, suspendingPackage);
        r1.getClass();
        Predicate<UserPackage> suspenderPredicate = new PackageManagerService$$ExternalSyntheticLambda19(r1);
        this.mSuspendPackageHelper.removeSuspensionsBySuspendingPackage(computer, allPackages, suspenderPredicate, targetUserId);
    }

    void removeAllDistractingPackageRestrictions(Computer snapshot, int userId) {
        String[] allPackages = snapshot.getAllAvailablePackageNames();
        this.mDistractingPackageHelper.removeDistractingPackageRestrictions(snapshot, allPackages, userId);
    }

    private void enforceCanSetDistractingPackageRestrictionsAsUser(int callingUid, int userId, String callingMethod) {
        this.mContext.enforceCallingOrSelfPermission("android.permission.SUSPEND_APPS", callingMethod);
        if (PackageManagerServiceUtils.isSystemOrRoot(callingUid) == false) goto L5;
        return;
    L5:
        if (UserHandle.getUserId(callingUid) != userId) goto L8;
        return;
    L8:
        throw new SecurityException("Calling uid " + callingUid + " cannot call for user " + userId);
    }

    void setEnableRollbackCode(int token, int enableRollbackCode) {
        Message msg = this.mHandler.obtainMessage(21);
        msg.arg1 = token;
        msg.arg2 = enableRollbackCode;
        this.mHandler.sendMessage(msg);
    }

    void notifyFirstLaunch(final String packageName, final String installerPackage, final int userId) {
        this.mHandler.post(new PackageManagerService$$ExternalSyntheticLambda25(this, packageName, userId, installerPackage));
    }

    private /* synthetic */ void lambda$notifyFirstLaunch$47(String packageName, int userId, String installerPackage) {
        SparseArray<InstallRequest> r0 = this.mRunningInstalls;
        monitor-enter(r0);
        int i = 0;
    L36:
    L19:
        th = move-exception;
        throw th;
    L6:
        if (i >= this.mRunningInstalls.size()) goto L24;
        InstallRequest installRequest = this.mRunningInstalls.valueAt(i);     // Catch: Throwable -> L19
        if (installRequest.getReturnCode() != 1) goto L22;
        int[] newUsers = installRequest.getNewUsers();     // Catch: Throwable -> L19
        if (packageName.equals(installRequest.getPkg().getPackageName()) == false) goto L22;
        int uIndex = 0;
    L14:
        if (uIndex >= newUsers.length) goto L22;
        if (userId == newUsers[uIndex]) goto L17;
        uIndex = uIndex + 1;     // Catch: Throwable -> L19
        goto L14
    L17:
        monitor-exit(r0);     // Catch: Throwable -> L19
        return;
    L22:
        i = i + 1;     // Catch: Throwable -> L19
        goto L36
    L24:
        monitor-exit(r0);     // Catch: Throwable -> L19
        boolean isInstantApp = snapshotComputer().isInstantAppInternal(packageName, userId, 1000);
        if (isInstantApp == false) goto L28;
        int[] userIds = EMPTY_INT_ARRAY;
    L29:
        if (isInstantApp == false) goto L31;
        int[] instantUserIds = {userId};
    L32:
        this.mBroadcastHelper.sendFirstLaunchBroadcast(packageName, installerPackage, userIds, instantUserIds);
        return;
    L31:
        instantUserIds = EMPTY_INT_ARRAY;
        goto L32
    L28:
        userIds = new int[]{userId};
        goto L29
    }

    Settings.VersionInfo getSettingsVersionForPackage(AndroidPackage pkg) {
        if (pkg.isExternalStorage() == false) goto L11;
        if (TextUtils.isEmpty(pkg.getVolumeUuid()) == false) goto L9;
        return this.mSettings.getExternalVersion();
    L9:
        return this.mSettings.findOrCreateVersion(pkg.getVolumeUuid());
    L11:
        return this.mSettings.getInternalVersion();
    }

    public void deleteExistingPackageAsUser(VersionedPackage versionedPackage, IPackageDeleteObserver2 observer, int userId) {
        this.mDeletePackageHelper.deleteExistingPackageAsUser(versionedPackage, observer, userId);
    }

    public void deletePackageVersioned(VersionedPackage versionedPackage, IPackageDeleteObserver2 observer, int userId, int deleteFlags, int callingUid) {
        int deleteFlags2 = this.mObricExt.deletePackageVersionedBefore(versionedPackage, deleteFlags, userId);
        if (RemovableSystemAppHelper.isRemovableSysApp(versionedPackage.getPackageName()) == false) goto L16;
        PackageManagerTracedLock r5 = this.mLock;
        boostPriorityForPackageManagerTracedLockedSection();
        monitor-enter(r5);
        PackageSetting ps = this.mSettings.getPackageLPr(versionedPackage.getPackageName());     // Catch: Throwable -> L12
        boolean isUpdatedRemovableSysApp = ps.getPkgState().isUpdatedSystemApp();     // Catch: Throwable -> L12
        monitor-exit(r5);     // Catch: Throwable -> L12
        resetPriorityAfterPackageManagerTracedLockedSection();
        if (isUpdatedRemovableSysApp == true) goto L11;
        boolean isUpdatedRemovableSysApp2 = isUpdatedRemovableSysApp;
        int deleteFlags3 = deleteFlags2 | 4;
    L18:
        if (this.mObricExt.isRemovableSysApp(versionedPackage.getPackageName()) == false) goto L20;
        this.mObricExt.deletePackageVersioned(versionedPackage, deleteFlags3, this.mDeletePackageHelper, observer, userId, callingUid);
    L21:
        if (isUpdatedRemovableSysApp2 == false) goto L23;
        int deleteFlags4 = deleteFlags3 | 4;
        this.mDeletePackageHelper.deletePackageVersionedInternal(versionedPackage, observer, userId, deleteFlags4, callingUid, false);
        deleteFlags3 = deleteFlags4;
    L23:
        this.mObricExt.deletePackageVersionedAfter(versionedPackage, deleteFlags3, this.mDeletePackageHelper, observer, userId, callingUid);
        return;
    L20:
        int deleteFlags5 = deleteFlags3;
        this.mDeletePackageHelper.deletePackageVersionedInternal(versionedPackage, observer, userId, deleteFlags5, callingUid, false);
        deleteFlags3 = deleteFlags5;
        goto L21
    L11:
        isUpdatedRemovableSysApp2 = isUpdatedRemovableSysApp;
        deleteFlags3 = deleteFlags2;
    L12:
        th = move-exception;
        resetPriorityAfterPackageManagerTracedLockedSection();
        throw th;
    L16:
        isUpdatedRemovableSysApp2 = false;
        deleteFlags3 = deleteFlags2;
        goto L18
    }

    public void deletePackageVersioned(VersionedPackage versionedPackage, IPackageDeleteObserver2 observer, int userId, int deleteFlags) {
        if (this.mObricExt.isRemovableSysApp(versionedPackage.getPackageName()) == false) goto L5;
        this.mObricExt.deletePackageVersioned(versionedPackage, deleteFlags, this.mDeletePackageHelper, observer, userId, Binder.getCallingUid());
        return;
    L5:
        deletePackageVersioned(versionedPackage, observer, userId, deleteFlags, Binder.getCallingUid());
    }

    boolean isCallerVerifier(Computer snapshot, int callingUid) {
        int callingUserId = UserHandle.getUserId(callingUid);
        String[] r1 = this.mRequiredVerifierPackages;
        int r2 = r1.length;
        int r4 = 0;
    L3:
        if (r4 >= r2) goto L9;
        String requiredVerifierPackage = r1[r4];
        if (callingUid == snapshot.getPackageUid(requiredVerifierPackage, 0, callingUserId)) goto L6;
        r4 = r4 + 1;
        goto L3
    L6:
        return true;
    L9:
        return false;
    }

    public boolean isPackageDeviceAdminOnAnyUser(Computer snapshot, String packageName) {
        int callingUid = Binder.getCallingUid();
        if (snapshot.checkUidPermission("android.permission.MANAGE_USERS", callingUid) == 0) goto L5;
        EventLog.writeEvent(1397638484, new Object[]{"128599183", -1, ""});
        throw new SecurityException("android.permission.MANAGE_USERS permission is required to call this API");
    L5:
        if (snapshot.getInstantAppPackageName(callingUid) == null) goto L11;
        if (snapshot.isCallerSameApp(packageName, callingUid) == true) goto L11;
        return false;
    L11:
        return isPackageDeviceAdmin(packageName, -1);
    }

    boolean isPackageDeviceAdmin(String packageName, int userId) {
        IDevicePolicyManager dpm = getDevicePolicyManager();
        DevicePolicyManagerInternal dpmi = (DevicePolicyManagerInternal) this.mInjector.getLocalService(DevicePolicyManagerInternal.class);
        if (dpm == null) goto L45;
        if (dpmi == null) goto L45;
        ComponentName deviceOwnerComponentName = dpm.getDeviceOwnerComponent(false);     // Catch: RemoteException -> L41
        if (deviceOwnerComponentName != null) goto L8;
        String deviceOwnerPackageName = null;
    L10:
        if (packageName.equals(deviceOwnerPackageName) == false) goto L12;
        return true;
    L12:
        int[] allUsers = this.mUserManager.getUserIds();     // Catch: RemoteException -> L41
        if (userId != (-1)) goto L46;
        int[] targetUsers = allUsers;
    L17:
        int i = 0;
    L19:
        if (i >= targetUsers.length) goto L26;
        if (dpm.packageHasActiveAdmins(packageName, targetUsers[i]) == true) goto L22;
        i = i + 1;     // Catch: RemoteException -> L24
        goto L19
    L22:
        return true;
    L26:
        PackageStateInternal packageState = snapshotComputer().getPackageStateInternal(packageName);     // Catch: RemoteException -> L24
        if (packageState != null) goto L30;
        return false;
    L30:
        if (packageState.isSystem() == false) goto L32;
        int[] r12 = allUsers;
    L33:
        int r13 = r12.length;     // Catch: RemoteException -> L24
        int r14 = 0;
    L34:
        if (r14 >= r13) goto L45;
        int user = r12[r14];     // Catch: RemoteException -> L24
        if (isDeviceManagementRoleHolder(packageName, user) == false) goto L40;
        if (dpmi.isUserOrganizationManaged(user) == false) goto L40;
        return true;
    L40:
        r14 = r14 + 1;
        goto L34
    L32:
        r12 = targetUsers;
        goto L33
    L46:
        targetUsers = new int[]{userId};     // Catch: RemoteException -> L24
        goto L17
    L8:
        deviceOwnerPackageName = deviceOwnerComponentName.getPackageName();     // Catch: RemoteException -> L41
    L45:
        return false;
    }

    private boolean isDeviceManagementRoleHolder(String packageName, int userId) {
        return Objects.equals(packageName, getDevicePolicyManagementRoleHolderPackageName(userId));
    }

    public String getDevicePolicyManagementRoleHolderPackageName(final int userId) {
        return (String) Binder.withCleanCallingIdentity(new PackageManagerService$$ExternalSyntheticLambda24(this, userId));
    }

    private /* synthetic */ String lambda$getDevicePolicyManagementRoleHolderPackageName$48(int userId) throws Exception {
        RoleManager roleManager = (RoleManager) this.mContext.getSystemService(RoleManager.class);
        List<String> roleHolders = roleManager.getRoleHoldersAsUser("android.app.role.DEVICE_POLICY_MANAGEMENT", UserHandle.of(userId));
        if (roleHolders.isEmpty() == false) goto L7;
        return null;
    L7:
        return roleHolders.get(0);
    }

    private IDevicePolicyManager getDevicePolicyManager() {
        if (this.mDevicePolicyManager != null) goto L6;
        this.mDevicePolicyManager = IDevicePolicyManager.Stub.asInterface(ServiceManager.getService("device_policy"));
    L6:
        return this.mDevicePolicyManager;
    }

    private boolean clearApplicationUserDataLIF(Computer snapshot, String packageName, int userId, boolean restorePregrantedPermissions) {
        if (packageName != null) goto L6;
        Slog.w("PackageManager", "Attempt to delete null packageName.");
        return false;
    L6:
        AndroidPackage pkg = snapshot.getPackage(packageName);
        if (pkg != null) goto L10;
        Slog.w("PackageManager", "Package named '" + packageName + "' doesn't exist.");
        return false;
    L10:
        this.mPermissionManager.resetRuntimePermissions(pkg, userId, restorePregrantedPermissions);
        this.mAppDataHelper.clearAppDataLIF(pkg, userId, 7);
        int appId = UserHandle.getAppId(pkg.getUid());
        this.mAppDataHelper.clearKeystoreData(userId, appId);
        UserManagerInternal umInternal = this.mInjector.getUserManagerInternal();
        StorageManagerInternal smInternal = (StorageManagerInternal) this.mInjector.getLocalService(StorageManagerInternal.class);
        if (StorageManager.isCeStorageUnlocked(userId) == false) goto L16;
        if (smInternal.isCeStoragePrepared(userId) == false) goto L16;
        int flags = 3;
    L19:
        this.mAppDataHelper.prepareAppDataContentsLIF(pkg, snapshot.getPackageStateInternal(packageName), userId, flags);
        return true;
    L16:
        if (umInternal.isUserRunning(userId) == false) goto L18;
        flags = 1;
        goto L19
    L18:
        flags = 0;
        goto L19
    }

    private void resetComponentEnabledSettingsIfNeededLPw(String packageName, final int userId, int callingUid) {
        if (packageName == null) goto L4;
        AndroidPackage pkg = this.mPackages.get(packageName);
    L5:
        if (pkg != null) goto L7;
        return;
    L7:
        if (pkg.isResetEnabledSettingsOnAppDataCleared() == false) goto L41;
        final PackageSetting pkgSetting = this.mSettings.getPackageLPr(packageName);
        if (pkgSetting != null) goto L12;
        return;
    L12:
        final ArrayList<String> updatedComponents = new ArrayList();
        Consumer<? super ParsedMainComponent> resetSettings = new PackageManagerService$$ExternalSyntheticLambda63(pkgSetting, userId, updatedComponents);
        int i = 0;
    L14:
        if (i >= pkg.getActivities().size()) goto L16;
        resetSettings.accept(pkg.getActivities().get(i));
        i = i + 1;
        goto L14
    L16:
        int i2 = 0;
    L18:
        if (i2 >= pkg.getReceivers().size()) goto L20;
        resetSettings.accept(pkg.getReceivers().get(i2));
        i2 = i2 + 1;
        goto L18
    L20:
        int i3 = 0;
    L22:
        if (i3 >= pkg.getServices().size()) goto L24;
        resetSettings.accept(pkg.getServices().get(i3));
        i3 = i3 + 1;
        goto L22
    L24:
        int i4 = 0;
    L26:
        if (i4 >= pkg.getProviders().size()) goto L29;
        resetSettings.accept(pkg.getProviders().get(i4));
        i4 = i4 + 1;
        goto L26
    L29:
        if (ArrayUtils.isEmpty(updatedComponents) == false) goto L31;
        return;
    L31:
        updateSequenceNumberLP(pkgSetting, new int[]{userId});
        updateInstantAppInstallerLocked(packageName);
        scheduleWritePackageRestrictions(userId);
        this.mPendingBroadcasts.addComponents(userId, packageName, updatedComponents);
        if (this.mHandler.hasMessages(1) == true) goto L40;
        this.mHandler.sendMessageDelayed(this.mHandler.obtainMessage(1, callingUid, 0, "reset_component_state_changed"), 1000);
        return;
    L40:
        return;
    L41:
        return;
    L4:
        pkg = null;
        goto L5
    }

    private static /* synthetic */ void lambda$resetComponentEnabledSettingsIfNeededLPw$49(PackageSetting pkgSetting, int userId, ArrayList updatedComponents, ParsedMainComponent component) {
        if (pkgSetting.restoreComponentLPw(component.getClassName(), userId) == false) goto L6;
        updatedComponents.add(component.getClassName());
        return;
    }

    void clearPackagePreferredActivitiesLPw(String packageName, SparseBooleanArray outUserChanged, int userId) {
        this.mSettings.clearPackagePreferredActivities(packageName, outUserChanged, userId, this);
    }

    void restorePermissionsAndUpdateRolesForNewUserInstall(String packageName, int userId) {
        this.mPermissionManager.restoreDelayedRuntimePermissions(packageName, userId);
        PackageManagerTracedLock r0 = this.mLock;
        boostPriorityForPackageManagerTracedLockedSection();
        monitor-enter(r0);
        String defaultBrowser = this.mSettings.getPendingDefaultBrowserLPr(userId);     // Catch: Throwable -> L19
        monitor-exit(r0);     // Catch: Throwable -> L19
        resetPriorityAfterPackageManagerTracedLockedSection();
        if (Objects.equals(packageName, defaultBrowser) == false) goto L17;
        this.mDefaultAppProvider.setDefaultBrowser(packageName, userId);
        PackageManagerTracedLock r1 = this.mLock;
        boostPriorityForPackageManagerTracedLockedSection();
        monitor-enter(r1);
        this.mSettings.removePendingDefaultBrowserLPw(userId);     // Catch: Throwable -> L13
        monitor-exit(r1);     // Catch: Throwable -> L13
        resetPriorityAfterPackageManagerTracedLockedSection();
    L13:
        th = move-exception;
        resetPriorityAfterPackageManagerTracedLockedSection();
        throw th;
    L17:
        this.mPreferredActivityHelper.updateDefaultHomeNotLocked(snapshotComputer(), userId);
        return;
    L19:
        th = move-exception;
        resetPriorityAfterPackageManagerTracedLockedSection();
        throw th;
    }

    public void addCrossProfileIntentFilter(Computer snapshot, WatchedIntentFilter intentFilter, String ownerPackage, int sourceUserId, int targetUserId, int flags) {
        this.mContext.enforceCallingOrSelfPermission("android.permission.INTERACT_ACROSS_USERS_FULL", null);
        int callingUid = Binder.getCallingUid();
        enforceOwnerRights(snapshot, ownerPackage, callingUid);
        this.mUserManager.enforceCrossProfileIntentFilterAccess(sourceUserId, targetUserId, callingUid, true);
        PackageManagerServiceUtils.enforceShellRestriction(this.mInjector.getUserManagerInternal(), "no_debugging_features", callingUid, sourceUserId);
        if (intentFilter.checkDataPathAndSchemeSpecificParts() == true) goto L5;
        EventLog.writeEvent(1397638484, new Object[]{"246749936", Integer.valueOf(callingUid)});
        throw new IllegalArgumentException("Invalid intent data paths or scheme specific parts in the filter.");
    L5:
        if (intentFilter.countActions() != 0) goto L8;
        Slog.w("PackageManager", "Cannot set a crossProfile intent filter with no filter actions");
        return;
    L8:
        PackageManagerTracedLock r2 = this.mLock;
        boostPriorityForPackageManagerTracedLockedSection();
        monitor-enter(r2);
        CrossProfileIntentFilter newFilter = new CrossProfileIntentFilter(intentFilter, ownerPackage, targetUserId, flags, this.mUserManager.getCrossProfileIntentFilterAccessControl(sourceUserId, targetUserId));     // Catch: Throwable -> L21
        CrossProfileIntentResolver resolver = this.mSettings.editCrossProfileIntentResolverLPw(sourceUserId);     // Catch: Throwable -> L21
        ArrayList<CrossProfileIntentFilter> existing = resolver.findFilters(intentFilter);     // Catch: Throwable -> L21
        if (existing == null) goto L24;
        int size = existing.size();     // Catch: Throwable -> L21
        int i = 0;
    L15:
        if (i >= size) goto L24;
        if (newFilter.equalsIgnoreFilter(existing.get(i)) == true) goto L18;
        i = i + 1;
        goto L15
    L18:
        monitor-exit(r2);     // Catch: Throwable -> L21
        resetPriorityAfterPackageManagerTracedLockedSection();
        return;
    L24:
        resolver.addFilter(snapshotComputer(), newFilter);     // Catch: Throwable -> L21
        monitor-exit(r2);     // Catch: Throwable -> L21
        resetPriorityAfterPackageManagerTracedLockedSection();
        scheduleWritePackageRestrictions(sourceUserId);
        return;
    L28:
        th = move-exception;
        Throwable r11 = th;
    L30:
        monitor-exit(r2);     // Catch: Throwable -> L21
        resetPriorityAfterPackageManagerTracedLockedSection();
        throw r11;
    L21:
        th = move-exception;
        r11 = th;
        goto L30
    }

    private void enforceOwnerRights(Computer snapshot, String pkg, int callingUid) {
        if (UserHandle.getAppId(callingUid) != 1000) goto L5;
        return;
    L5:
        String[] callerPackageNames = snapshot.getPackagesForUid(callingUid);
        if (ArrayUtils.contains(callerPackageNames, pkg) == false) goto L13;
        int callingUserId = UserHandle.getUserId(callingUid);
        PackageInfo pi = snapshot.getPackageInfo(pkg, 0, callingUserId);
        if (pi == null) goto L11;
        return;
    L11:
        throw new IllegalArgumentException("Unknown package " + pkg + " on user " + callingUserId);
    L13:
        throw new SecurityException("Calling uid " + callingUid + " does not own package " + pkg);
    }

    public void sendSessionCommitBroadcast(PackageInstaller.SessionInfo sessionInfo, int userId) {
        this.mBroadcastHelper.sendSessionCommitBroadcast(snapshotComputer(), sessionInfo, userId, this.mAppPredictionServicePackage);
    }

    private String getSetupWizardPackageNameImpl(Computer computer) {
        Intent intent = new Intent("android.intent.action.MAIN");
        intent.addCategory("android.intent.category.SETUP_WIZARD");
        List<ResolveInfo> matches = computer.queryIntentActivitiesInternal(intent, null, 1835520, UserHandle.myUserId());
        if (matches.size() == 1) goto L5;
        Slog.e("PackageManager", "There should probably be exactly one setup wizard; found " + matches.size() + ": matches=" + matches);
        return null;
    L5:
        return matches.get(0).getComponentInfo().packageName;
    }

    private String getStorageManagerPackageName(Computer computer) {
        Intent intent = new Intent("android.os.storage.action.MANAGE_STORAGE");
        List<ResolveInfo> matches = computer.queryIntentActivitiesInternal(intent, null, 1835520, UserHandle.myUserId());
        if (matches.size() == 1) goto L5;
        Slog.w("PackageManager", "There should probably be exactly one storage manager; found " + matches.size() + ": matches=" + matches);
        return null;
    L5:
        return matches.get(0).getComponentInfo().packageName;
    }

    private static String getRequiredSdkSandboxPackageName(Computer computer) {
        Intent intent = new Intent("com.android.sdksandbox.SdkSandboxService");
        List<ResolveInfo> matches = computer.queryIntentServicesInternal(intent, null, 1835008, 0, Process.myUid(), -1, false, false);
        if (matches.size() != 1) goto L7;
        return matches.get(0).getComponentInfo().packageName;
    L7:
        throw new RuntimeException("There should exactly one sdk sandbox package; found " + matches.size() + ": matches=" + matches);
    }

    private String getRetailDemoPackageName() {
        String predefinedPkgName = this.mContext.getString(R.string.config_wimaxNativeLibLocation);
        String predefinedSignature = this.mContext.getString(R.string.config_wimaxServiceClassname);
        if (TextUtils.isEmpty(predefinedPkgName) == false) goto L5;
    L24:
        return null;
    L5:
        if (TextUtils.isEmpty(predefinedSignature) == true) goto L24;
        AndroidPackage androidPkg = this.mPackages.get(predefinedPkgName);
        if (androidPkg == null) goto L23;
        SigningDetails signingDetail = androidPkg.getSigningDetails();
        if (signingDetail == null) goto L23;
        if (signingDetail.getSignatures() == null) goto L23;
        MessageDigest msgDigest = MessageDigest.getInstance("SHA-256");     // Catch: NoSuchAlgorithmException -> L19
        Signature[] r6 = signingDetail.getSignatures();     // Catch: NoSuchAlgorithmException -> L19
        int r7 = r6.length;     // Catch: NoSuchAlgorithmException -> L19
        int r9 = 0;
    L14:
        if (r9 >= r7) goto L23;
        Signature signature = r6[r9];     // Catch: NoSuchAlgorithmException -> L19
        if (TextUtils.equals(predefinedSignature, HexEncoding.encodeToString(msgDigest.digest(signature.toByteArray()), false)) == true) goto L17;
        r9 = r9 + 1;
        goto L14
    L17:
        return predefinedPkgName;
    L19:
        e = move-exception;
        Slog.e("PackageManager", "Unable to verify signatures as getting the retail demo package name", e);
    L23:
        return null;
    }

    String getPackageFromComponentString(int stringResId) {
        String componentString = this.mContext.getString(stringResId);
        if (TextUtils.isEmpty(componentString) == false) goto L5;
        return null;
    L5:
        ComponentName component = ComponentName.unflattenFromString(componentString);
        if (component != null) goto L9;
        return null;
    L9:
        return component.getPackageName();
    }

    String ensureSystemPackageName(Computer snapshot, String packageName) {
        if (packageName != null) goto L5;
        return null;
    L5:
        long token = Binder.clearCallingIdentity();
    L11:
        th = move-exception;
        Binder.restoreCallingIdentity(token);
        throw th;
    L7:
        if (snapshot.getPackageInfo(packageName, 2097152, 0) != null) goto L20;
        PackageInfo packageInfo = snapshot.getPackageInfo(packageName, 0, 0);     // Catch: Throwable -> L11
        if (packageInfo == null) goto L13;
        EventLog.writeEvent(1397638484, new Object[]{"145981139", Integer.valueOf(packageInfo.applicationInfo.uid), ""});     // Catch: Throwable -> L11
    L13:
        StringBuilder r5 = new StringBuilder();     // Catch: Throwable -> L11
        r5.append("Missing required system package: ");     // Catch: Throwable -> L11
        r5.append(packageName);     // Catch: Throwable -> L11
        if (packageInfo == null) goto L16;
        String r6 = ", but found with extended search.";
    L17:
        r5.append(r6);     // Catch: Throwable -> L11
        Log.w("PackageManager", r5.toString());     // Catch: Throwable -> L11
        Binder.restoreCallingIdentity(token);
        return null;
    L16:
        r6 = ".";
        goto L17
    L20:
        Binder.restoreCallingIdentity(token);
        return packageName;
    }

    public void updateComponentLabelIcon(final ComponentName componentName, final String nonLocalizedLabel, final Integer icon, final int userId) {
        if (componentName == null) goto L52;
        int callingUid = Binder.getCallingUid();
        String componentPkgName = componentName.getPackageName();
        Computer computer = snapshotComputer();
        int componentUid = computer.getPackageUid(componentPkgName, 0, userId);
        if (UserHandle.isSameApp(callingUid, componentUid) == false) goto L50;
        String allowedCallerPkg = this.mContext.getString(R.string.config_systemGameService);
        if (TextUtils.isEmpty(allowedCallerPkg) == true) goto L48;
        int allowedCallerUid = computer.getPackageUid(allowedCallerPkg, DeviceStorageMonitorServiceSmtEx.TrafficStats.MB_IN_BYTES, userId);
        if (allowedCallerUid == (-1)) goto L46;
        if (UserHandle.isSameApp(callingUid, allowedCallerUid) == false) goto L46;
        PackageStateInternal packageState = computer.getPackageStateInternal(componentPkgName);
        if (packageState == null) goto L44;
        if (packageState.getPkg() == null) goto L44;
        if (packageState.isSystem() == true) goto L23;
        if (packageState.isUpdatedSystemApp() == false) goto L44;
    L23:
        if (computer.getComponentResolver().componentExists(componentName) == false) goto L41;
        Pair<String, Integer> overrideLabelIcon = packageState.getUserStateOrDefault(userId).getOverrideLabelIconForComponent(componentName);
        if (overrideLabelIcon != null) goto L27;
        String existingLabel = null;
    L28:
        if (overrideLabelIcon != null) goto L30;
        Integer existingIcon = null;
    L32:
        if (TextUtils.equals(existingLabel, nonLocalizedLabel) == true) goto L34;
    L36:
        commitPackageStateMutation(null, componentPkgName, new PackageManagerService$$ExternalSyntheticLambda5(userId, componentName, nonLocalizedLabel, icon));
        this.mPendingBroadcasts.addComponent(userId, componentPkgName, componentName.getClassName());
        if (this.mHandler.hasMessages(1) == true) goto L53;
        this.mHandler.sendMessageDelayed(this.mHandler.obtainMessage(1, callingUid, 0, "component_label_icon_changed"), 1000);
        return;
    L53:
        return;
    L34:
        if (Objects.equals(existingIcon, icon) == false) goto L36;
        return;
    L30:
        existingIcon = (Integer) overrideLabelIcon.second;
        goto L32
    L27:
        existingLabel = (String) overrideLabelIcon.first;
        goto L28
    L41:
        throw new IllegalArgumentException("Component " + componentName + " not found");
    L44:
        throw new SecurityException("Changing the label is not allowed for " + componentName);
    L46:
        throw new SecurityException("The calling UID (" + callingUid + ") is not allowed to change a component's label or icon");
    L48:
        throw new SecurityException("There is no package defined as allowed to change a component's label or icon");
    L50:
        throw new SecurityException("The calling UID (" + callingUid + ") does not match the target UID");
    L52:
        throw new IllegalArgumentException("Must specify a component");
    }

    private static /* synthetic */ void lambda$updateComponentLabelIcon$50(int userId, ComponentName componentName, String nonLocalizedLabel, Integer icon, PackageStateWrite state) {
        state.userState(userId).setComponentLabelIcon(componentName, nonLocalizedLabel, icon);
    }

    private void setEnabledSettings(List<PackageManager.ComponentEnabledSetting> settings, int userId, String callingPackage) {
        PackageManagerService r1 = this;
        List<PackageManager.ComponentEnabledSetting> r7 = settings;
        int callingUid = Binder.getCallingUid();
        Computer preLockSnapshot = r1.snapshotComputer();
        int callingUid2 = callingUid;
        preLockSnapshot.enforceCrossUserPermission(callingUid2, userId, false, true, "set enabled");
        int targetSize = r7.size();
        int i = 0;
    L3:
        char r10 = 2;
        if (i >= targetSize) goto L16;
        int newState = r7.get(i).getEnabledState();
        if (newState == 0) goto L15;
        if (newState == 1) goto L15;
        if (newState == 2) goto L15;
        if (newState == 3) goto L15;
        if (newState == 4) goto L15;
        throw new IllegalArgumentException("Invalid new component state: " + newState);
    L15:
        i = i + 1;
        goto L3
    L16:
        int i2 = 0;
    L17:
        if (i2 >= targetSize) goto L23;
        PackageManager.ComponentEnabledSetting setting = r7.get(i2);
        if (AIKERNEL_PACKAGE_NAME.equals(setting.getPackageName()) == false) goto L21;
        Slog.w("PackageManager", "AIKernel setEnabledSettings package=" + setting.getPackageName() + " callingUid=" + callingUid2, new RuntimeException("AIKernel setEnabledSettings callstack"));
    L21:
        i2 = i2 + 1;
        goto L17
    L23:
        if (targetSize <= 1) goto L49;
        ArraySet<String> checkDuplicatedPackage = new ArraySet();
        ArraySet<ComponentName> checkDuplicatedComponent = new ArraySet();
        ArrayMap<String, Integer> checkConflictFlag = new ArrayMap();
        int i3 = 0;
    L25:
        if (i3 >= targetSize) goto L49;
        PackageManager.ComponentEnabledSetting setting2 = r7.get(i3);
        String packageName = setting2.getPackageName();
        if (setting2.isComponent() == false) goto L41;
        ComponentName componentName = setting2.getComponentName();
        if (checkDuplicatedComponent.contains(componentName) == true) goto L39;
        checkDuplicatedComponent.add(componentName);
        Integer enabledFlags = checkConflictFlag.get(packageName);
        if (enabledFlags != null) goto L34;
        checkConflictFlag.put(packageName, Integer.valueOf(setting2.getEnabledFlags()));
    L43:
        i3 = i3 + 1;
        r10 = r10;
        goto L25
    L34:
        if ((enabledFlags.intValue() & 1) == (setting2.getEnabledFlags() & 1)) goto L43;
        throw new IllegalArgumentException("A conflict of the DONT_KILL_APP flag between components in the package " + packageName);
    L39:
        throw new IllegalArgumentException("The component " + componentName + " is duplicated");
    L41:
        if (checkDuplicatedPackage.contains(packageName) == true) goto L45;
        checkDuplicatedPackage.add(packageName);
        goto L43
    L45:
        throw new IllegalArgumentException("The package " + packageName + " is duplicated");
    L49:
        if (r1.mContext.checkCallingOrSelfPermission("android.permission.CHANGE_COMPONENT_ENABLED_STATE") != 0) goto L51;
        boolean r0 = true;
    L52:
        boolean allowedByPermission = r0;
        boolean[] updateAllowed = new boolean[targetSize];
        Arrays.fill(updateAllowed, true);
        Map<String, PackageSetting> pkgSettings = new ArrayMap(targetSize);
        PackageManagerTracedLock r2 = r1.mLock;
        boostPriorityForPackageManagerTracedLockedSection();
        monitor-enter(r2);
        Computer snapshot = r1.snapshotComputer();     // Catch: Throwable -> L269
        int i4 = 0;
    L56:
        if (i4 >= targetSize) goto L110;
        PackageManager.ComponentEnabledSetting setting3 = r7.get(i4);     // Catch: Throwable -> L66
        String packageName2 = setting3.getPackageName();     // Catch: Throwable -> L66
        r1.getExt().interceptSetEnabledSettingsIfNeeded(setting3.getEnabledState(), packageName2);     // Catch: Throwable -> L66
        if (pkgSettings.containsKey(packageName2) == false) goto L60;
        snapshot = snapshot;
    L102:
        i4 = i4 + 1;     // Catch: Throwable -> L66
        snapshot = snapshot;
        goto L56
    L60:
        boolean isCallerTargetApp = ArrayUtils.contains(snapshot.getPackagesForUid(callingUid2), packageName2);     // Catch: Throwable -> L66
        PackageSetting pkgSetting = r1.mSettings.getPackageLPr(packageName2);     // Catch: Throwable -> L66
        if (isCallerTargetApp == true) goto L72;
        if (allowedByPermission == true) goto L72;
        StringBuilder r11 = new StringBuilder();     // Catch: Throwable -> L66
        r11.append("Attempt to change component state; pid=");     // Catch: Throwable -> L66
        r11.append(Binder.getCallingPid());     // Catch: Throwable -> L66
        r11.append(", uid=");     // Catch: Throwable -> L66
        r11.append(callingUid2);     // Catch: Throwable -> L66
        if (setting3.isComponent() == true) goto L68;
        String r3 = ", package=" + packageName2;     // Catch: Throwable -> L66
    L69:
        r11.append(r3);     // Catch: Throwable -> L66
        throw new SecurityException(r11.toString());     // Catch: Throwable -> L66
    L68:
        r3 = ", component=" + setting3.getComponentName();     // Catch: Throwable -> L66
    L72:
        if (pkgSetting == null) goto L105;
        if (snapshot.shouldFilterApplicationIncludingUninstalled(pkgSetting, callingUid2, userId) == true) goto L105;
        if (isCallerTargetApp == true) goto L83;
        if (r1.mProtectedPackages.isPackageStateProtected(userId, packageName2) == false) goto L83;
        throw new SecurityException("Cannot disable a protected package: " + packageName2);     // Catch: Throwable -> L66
    L83:
        if (callingUid2 != 2000) goto L101;
        if ((pkgSetting.getFlags() & 256) != 0) goto L101;
        int oldState = pkgSetting.getEnabled(userId);     // Catch: Throwable -> L66
        int newState2 = setting3.getEnabledState();     // Catch: Throwable -> L66
        if (setting3.isComponent() == true) goto L98;
        if (oldState == 3) goto L93;
        if (oldState == 0) goto L93;
        if (oldState != 1) goto L98;
    L93:
        if (newState2 == 3) goto L101;
        if (newState2 == 0) goto L101;
        if (newState2 == 1) goto L101;
    L98:
        throw new SecurityException("Shell cannot change component state for " + setting3.getComponentName() + " to " + newState2);     // Catch: Throwable -> L66
    L101:
        pkgSettings.put(packageName2, pkgSetting);     // Catch: Throwable -> L66
    L105:
        if (setting3.isComponent() == false) goto L107;
        String r4 = "Unknown component: " + setting3.getComponentName();     // Catch: Throwable -> L66
    L109:
        throw new IllegalArgumentException(r4);     // Catch: Throwable -> L66
    L107:
        r4 = "Unknown package: " + packageName2;     // Catch: Throwable -> L66
    L66:
        th = th;
    L296:
        monitor-exit(r2);     // Catch: Throwable -> L274
        resetPriorityAfterPackageManagerTracedLockedSection();
        throw th;
    L274:
        th = th;
        goto L296
    L110:
        int i5 = 0;
    L111:
        if (i5 >= targetSize) goto L135;
        PackageManager.ComponentEnabledSetting setting4 = r7.get(i5);     // Catch: Throwable -> L66
        if (setting4.isComponent() == false) goto L133;
        String packageName3 = setting4.getPackageName();     // Catch: Throwable -> L66
        String className = setting4.getClassName();     // Catch: Throwable -> L66
        if (allowedByPermission == false) goto L118;
    L122:
        AndroidPackageInternal r12 = pkgSettings.get(packageName3).getPkg();     // Catch: Throwable -> L66
        if (r12 != null) goto L125;
    L126:
        if (r12 != null) goto L128;
    L132:
        Slog.w("PackageManager", "Failed setComponentEnabledSetting: component class " + className + " does not exist in " + packageName3);     // Catch: Throwable -> L66
        updateAllowed[i5] = false;     // Catch: Throwable -> L66
        goto L133
    L128:
        if (r12.getTargetSdkVersion() < 16) goto L132;
        throw new IllegalArgumentException("Component class " + className + " does not exist in " + packageName3);     // Catch: Throwable -> L66
    L125:
        if (AndroidPackageUtils.hasComponentClassName(r12, className) == true) goto L133;
    L118:
        if (PackageManager.APP_DETAILS_ACTIVITY_CLASS_NAME.equals(className) == false) goto L122;
        throw new SecurityException("Cannot disable a system-generated component");     // Catch: Throwable -> L66
    L133:
        i5 = i5 + 1;
        goto L111
    L135:
        monitor-exit(r2);     // Catch: Throwable -> L269
        resetPriorityAfterPackageManagerTracedLockedSection();
        int i6 = 0;
    L137:
        if (i6 >= targetSize) goto L171;
        PackageManager.ComponentEnabledSetting setting5 = r7.get(i6);
        if (setting5.isComponent() == true) goto L167;
        PackageSetting pkgSetting2 = pkgSettings.get(setting5.getPackageName());
        int newState3 = setting5.getEnabledState();
        PackageManagerTracedLock r13 = r1.mLock;
        boostPriorityForPackageManagerTracedLockedSection();
        monitor-enter(r13);
        if (pkgSetting2.getEnabled(userId) != newState3) goto L150;
        updateAllowed[i6] = false;     // Catch: Throwable -> L148
        monitor-exit(r13);     // Catch: Throwable -> L148
        resetPriorityAfterPackageManagerTracedLockedSection();
        goto L167
    L150:
        monitor-exit(r13);     // Catch: Throwable -> L148
        resetPriorityAfterPackageManagerTracedLockedSection();
        AndroidPackageInternal r5 = pkgSetting2.getPkg();
        if (r5 != null) goto L154;
    L158:
        boolean isSystemStub = false;
    L160:
        if (isSystemStub == false) goto L167;
        if (newState3 == 0) goto L165;
        if (newState3 != 1) goto L167;
    L165:
        if (r1.enableCompressedPackage(r5, pkgSetting2) == true) goto L167;
        Slog.w("PackageManager", "Failed setApplicationEnabledSetting: failed to enable commpressed package " + setting5.getPackageName());
        updateAllowed[i6] = false;
        goto L167
    L154:
        if (r5.isStub() == false) goto L158;
        if (pkgSetting2.isSystem() == false) goto L158;
        isSystemStub = true;
    L148:
        th = move-exception;
        resetPriorityAfterPackageManagerTracedLockedSection();
        throw th;
    L167:
        i6 = i6 + 1;
        goto L137
    L171:
        ArrayMap<String, ArrayList<String>> sendNowBroadcasts = new ArrayMap(targetSize);
        List<PackageMetrics.ComponentStateMetrics> componentStateMetricsList = new ArrayList();
        PackageManagerTracedLock r14 = r1.mLock;
        boostPriorityForPackageManagerTracedLockedSection();
        monitor-enter(r14);
        Computer computer = r1.snapshotComputer();     // Catch: Throwable -> L262
        boolean scheduleBroadcastMessage = false;
        boolean isSynchronous = false;
        boolean anyChanged = false;
        int i7 = 0;
    L175:
        if (i7 >= targetSize) goto L213;
    L198:
        th = th;
    L283:
        monitor-exit(r14);     // Catch: Throwable -> L267
        resetPriorityAfterPackageManagerTracedLockedSection();
        throw th;
    L267:
        th = th;
        goto L283
    L177:
        if (updateAllowed[i7] == true) goto L179;
        boolean scheduleBroadcastMessage2 = scheduleBroadcastMessage;
        i7 = i7;
    L191:
        Computer computer2 = computer;
        scheduleBroadcastMessage = scheduleBroadcastMessage2;
    L212:
        i7 = i7 + 1;     // Catch: Throwable -> L198
        r7 = settings;
        computer = computer2;
        goto L175
    L179:
        PackageManager.ComponentEnabledSetting setting6 = r7.get(i7);     // Catch: Throwable -> L198
        String packageName4 = setting6.getPackageName();     // Catch: Throwable -> L198
        PackageSetting packageSetting = pkgSettings.get(packageName4);     // Catch: Throwable -> L198
        scheduleBroadcastMessage2 = scheduleBroadcastMessage;
        int r6 = UserHandle.getUid(userId, packageSetting.getAppId());     // Catch: Throwable -> L183
        if (setting6.isComponent() == false) goto L186;
        int r8 = computer.getComponentEnabledSettingInternal(setting6.getComponentName(), callingUid2, userId);     // Catch: Throwable -> L183
        PackageSetting packageSetting2 = packageSetting;
    L187:
        PackageMetrics.ComponentStateMetrics componentStateMetrics = new PackageMetrics.ComponentStateMetrics(setting6, r6, r8, callingUid2);     // Catch: Throwable -> L183
        r1 = this;
        computer = computer;
        if (r1.setEnabledSettingInternalLocked(computer, packageSetting2, setting6, userId, callingPackage) == false) goto L191;
        componentStateMetricsList.add(componentStateMetrics);     // Catch: Throwable -> L198
        if ((setting6.getEnabledFlags() & 2) == 0) goto L196;
        isSynchronous = true;
    L196:
        if (setting6.isComponent() == false) goto L200;
        String r19 = setting6.getClassName();     // Catch: Throwable -> L198
    L201:
        String componentName2 = r19;
        if ((setting6.getEnabledFlags() & 1) != 0) goto L211;
        ArrayList<String> componentList = sendNowBroadcasts.get(packageName4);     // Catch: Throwable -> L198
        if (componentList != null) goto L206;
        ArrayList<String> r25 = new ArrayList();     // Catch: Throwable -> L198
    L207:
        ArrayList<String> componentList2 = r25;
        computer2 = computer;
        if (componentList2.contains(componentName2) == true) goto L210;
        componentList2.add(componentName2);     // Catch: Throwable -> L198
    L210:
        sendNowBroadcasts.put(packageName4, componentList2);     // Catch: Throwable -> L198
        r1.mPendingBroadcasts.remove(userId, packageName4);     // Catch: Throwable -> L198
        anyChanged = true;
        scheduleBroadcastMessage = scheduleBroadcastMessage2;
        goto L212
    L206:
        r25 = componentList;
        goto L207
    L211:
        computer2 = computer;
        r1.mPendingBroadcasts.addComponent(userId, packageName4, componentName2);     // Catch: Throwable -> L198
        Trace.instant(262144, "setEnabledSetting broadcast: " + componentName2 + ": " + setting6.getEnabledState());     // Catch: Throwable -> L198
        scheduleBroadcastMessage = true;
        anyChanged = true;
        goto L212
    L200:
        r19 = packageName4;
        goto L201
    L186:
        packageSetting2 = packageSetting;
        r8 = packageSetting2.getEnabled(userId);     // Catch: Throwable -> L183
    L183:
        th = th;
        goto L283
    L213:
        boolean scheduleBroadcastMessage3 = scheduleBroadcastMessage;
        if (anyChanged == true) goto L218;
        monitor-exit(r14);     // Catch: Throwable -> L198
        resetPriorityAfterPackageManagerTracedLockedSection();
        return;
    L218:
        if (isSynchronous == false) goto L221;
        r1.flushPackageRestrictionsAsUserInternalLocked(userId);     // Catch: Throwable -> L198
    L222:
        if (scheduleBroadcastMessage3 == true) goto L292;
        int targetSize2 = targetSize;
    L290:
        monitor-exit(r14);     // Catch: Throwable -> L260
        resetPriorityAfterPackageManagerTracedLockedSection();
        PackageMetrics.reportComponentStateChanged(r1.snapshotComputer(), componentStateMetricsList, userId);
        long callingId = Binder.clearCallingIdentity();
        Computer newSnapshot = r1.snapshotComputer();     // Catch: Throwable -> L254
        int i8 = 0;
    L243:
        if (i8 >= sendNowBroadcasts.size()) goto L256;
        String packageName5 = sendNowBroadcasts.keyAt(i8);     // Catch: Throwable -> L254
        ArrayList<String> components = sendNowBroadcasts.valueAt(i8);     // Catch: Throwable -> L254
        int packageUid = UserHandle.getUid(userId, pkgSettings.get(packageName5).getAppId());     // Catch: Throwable -> L254
        Map<String, PackageSetting> pkgSettings2 = pkgSettings;
        List<PackageMetrics.ComponentStateMetrics> componentStateMetricsList2 = componentStateMetricsList;
        boolean[] updateAllowed2 = updateAllowed;
        ArrayMap<String, ArrayList<String>> sendNowBroadcasts2 = sendNowBroadcasts;
        int targetSize3 = targetSize2;
        int targetSize4 = callingUid2;
        r1.mBroadcastHelper.sendPackageChangedBroadcast(newSnapshot, packageName5, false, components, packageUid, null, "component_state_changed", targetSize4);     // Catch: Throwable -> L250
        callingUid2 = targetSize4;
        i8 = i8 + 1;
        targetSize2 = targetSize3;
        updateAllowed = updateAllowed2;
        sendNowBroadcasts = sendNowBroadcasts2;
        pkgSettings = pkgSettings2;
        componentStateMetricsList = componentStateMetricsList2;
    L250:
        th = th;
    L258:
        Binder.restoreCallingIdentity(callingId);
        throw th;
    L252:
        th = th;
        goto L258
    L256:
        Binder.restoreCallingIdentity(callingId);
        return;
    L254:
        th = th;
    L260:
        th = th;
        goto L283
    L292:
    L235:
        th = th;
        goto L283
    L224:
        if (r1.mHandler.hasMessages(1) == false) goto L226;
        targetSize2 = targetSize;
        goto L290
    L226:
        if (SystemClock.uptimeMillis() <= r1.mServiceStartWithDelay) goto L228;
        long broadcastDelay = 1000;
    L229:
        targetSize2 = targetSize;
        r1.mHandler.sendMessageDelayed(r1.mHandler.obtainMessage(1, callingUid2, 0, "component_state_changed"), broadcastDelay);     // Catch: Throwable -> L233
    L233:
        th = th;
        goto L283
    L228:
        broadcastDelay = 10000;
        goto L229
    L221:
        r1.scheduleWritePackageRestrictions(userId);     // Catch: Throwable -> L262
    L262:
        th = th;
    L269:
        th = th;
        goto L296
    L51:
        r0 = false;
        goto L52
    }

    private boolean setEnabledSettingInternalLocked(Computer computer, PackageSetting pkgSetting, PackageManager.ComponentEnabledSetting setting, int userId, String callingPackage) {
        int newState = setting.getEnabledState();
        String packageName = setting.getPackageName();
        boolean success = false;
        if (setting.isComponent() == true) goto L12;
        pkgSetting.setEnabled(newState, userId, callingPackage);
        if (newState == 3) goto L9;
        if (newState == 2) goto L9;
    L11:
        success = true;
    L18:
        if (success == true) goto L21;
        return false;
    L21:
        updateSequenceNumberLP(pkgSetting, new int[]{userId});
        long callingId = Binder.clearCallingIdentity();
        updateInstantAppInstallerLocked(packageName);     // Catch: Throwable -> L25
        Binder.restoreCallingIdentity(callingId);
        return true;
    L25:
        th = move-exception;
        Binder.restoreCallingIdentity(callingId);
        throw th;
    L9:
        if (checkPermission("android.permission.SUSPEND_APPS", packageName, userId) != 0) goto L11;
        unsuspendForSuspendingPackage(computer, packageName, userId, -1);
        removeAllDistractingPackageRestrictions(computer, userId);
        goto L11
    L12:
        String className = setting.getClassName();
        switch(newState) {
            case 0: goto L17;
            case 1: goto L16;
            case 2: goto L15;
            default: goto L14;
        };
    L14:
        Slog.e("PackageManager", "Failed setComponentEnabledSetting: component " + packageName + SliceClientPermissions.SliceAuthority.DELIMITER + className + " requested an invalid new component state: " + newState);
        goto L18
    L15:
        success = pkgSetting.disableComponentLPw(className, userId);
        goto L18
    L16:
        success = pkgSetting.enableComponentLPw(className, userId);
        goto L18
    L17:
        success = pkgSetting.restoreComponentLPw(className, userId);
        goto L18
    }

    private void flushPackageRestrictionsAsUserInternalLocked(int userId) {
        this.mSettings.writePackageRestrictionsLPr(userId);
        ArraySet<Integer> r0 = this.mDirtyUsers;
        monitor-enter(r0);
        this.mDirtyUsers.remove(Integer.valueOf(userId));     // Catch: Throwable -> L7
        if (this.mDirtyUsers.isEmpty() == false) goto L9;
        this.mBackgroundHandler.removeMessages(14);     // Catch: Throwable -> L7
    L9:
        monitor-exit(r0);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    public void waitForAppDataPrepared() {
        if (this.mPrepareAppDataFuture != null) goto L5;
        return;
    L5:
        ConcurrentUtils.waitForFutureNoInterrupt(this.mPrepareAppDataFuture, "wait for prepareAppData");
        this.mPrepareAppDataFuture = null;
    }

    public void systemReady() {
        PackageManagerServiceUtils.enforceSystemOrRoot("Only the system can claim the system is ready");
        final ContentResolver resolver = this.mContext.getContentResolver();
        if (this.mReleaseOnSystemReady == null) goto L8;
        int i = this.mReleaseOnSystemReady.size() - 1;
    L5:
        if (i < 0) goto L7;
        File dstCodePath = this.mReleaseOnSystemReady.get(i);
        F2fsUtils.releaseCompressedBlocks(resolver, dstCodePath);
        i = i - 1;
        goto L5
    L7:
        this.mReleaseOnSystemReady = null;
    L8:
        this.mSystemReady = true;
        final Handler r4 = this.mHandler;
        ContentObserver co2 = new AnonymousClass4(this, r4, resolver);
        this.mContext.getContentResolver().registerContentObserver(android.provider.Settings.Global.getUriFor("enable_ephemeral_feature"), false, co2, -1);
        this.mContext.getContentResolver().registerContentObserver(android.provider.Settings.Secure.getUriFor("instant_apps_enabled"), false, co2, -1);
        co2.onChange(true);
        this.mAppsFilter.onSystemReady((PackageManagerInternal) LocalServices.getService(PackageManagerInternal.class));
        CarrierAppUtils.disableCarrierAppsUntilPrivileged(this.mContext.getOpPackageName(), 0, this.mContext);
        if (android.provider.Settings.Global.getInt(this.mContext.getContentResolver(), "compatibility_mode", 1) != 1) goto L11;
        boolean compatibilityModeEnabled = true;
    L12:
        ParsingPackageUtils.setCompatibilityModeEnabled(compatibilityModeEnabled);
        if (PackageManagerServiceSmtBase.DEBUGGABLE == false) goto L15;
        this.mPackageManagerServiceSmtEx.mAdbInstallDebuggable = SystemProperties.getBoolean("persist.sys.install_debuggable", false);
    L15:
        PackageManagerTracedLock r5 = this.mLock;
        boostPriorityForPackageManagerTracedLockedSection();
        monitor-enter(r5);
        ArrayList<Integer> changed = this.mSettings.systemReady(this.mComponentResolver);     // Catch: Throwable -> L21
        int i2 = 0;
    L19:
        if (i2 >= changed.size()) goto L24;
        this.mSettings.writePackageRestrictionsLPr(changed.get(i2).intValue());     // Catch: Throwable -> L21
        i2 = i2 + 1;     // Catch: Throwable -> L21
        goto L19
    L24:
        monitor-exit(r5);     // Catch: Throwable -> L21
        resetPriorityAfterPackageManagerTracedLockedSection();
        this.mUserManager.systemReady();
        StorageManager storage = (StorageManager) this.mInjector.getSystemService(StorageManager.class);
        storage.registerListener(this.mStorageEventHelper);
        this.mInstallerService.systemReady();
        this.mPackageDexOptimizer.systemReady();
        this.mUserManager.reconcileUsers(StorageManager.UUID_PRIVATE_INTERNAL);
        this.mStorageEventHelper.reconcileApps(snapshotComputer(), StorageManager.UUID_PRIVATE_INTERNAL);
        this.mPermissionManager.onSystemReady();
        int[] grantPermissionsUserIds = EMPTY_INT_ARRAY;
        List<UserInfo> livingUsers = this.mInjector.getUserManagerInternal().getUsers(true, true, false);
        int livingUserCount = livingUsers.size();
        int i3 = 0;
    L26:
        if (i3 >= livingUserCount) goto L31;
        int userId = livingUsers.get(i3).id;
        boolean isPermissionUpgradeNeeded = !Objects.equals(this.mPermissionManager.getDefaultPermissionGrantFingerprint(userId), Build.FINGERPRINT);
        if (isPermissionUpgradeNeeded == false) goto L30;
        grantPermissionsUserIds = ArrayUtils.appendInt(grantPermissionsUserIds, userId);
    L30:
        i3 = i3 + 1;
        goto L26
    L31:
        int i4 = grantPermissionsUserIds.length;
        int r11 = 0;
    L32:
        if (r11 >= i4) goto L35;
        int userId2 = grantPermissionsUserIds[r11];
        this.mLegacyPermissionManager.grantDefaultPermissions(userId2);
        this.mPermissionManager.setDefaultPermissionGrantFingerprint(Build.FINGERPRINT, userId2);
        r11 = r11 + 1;
        goto L32
    L35:
        if (grantPermissionsUserIds != EMPTY_INT_ARRAY) goto L38;
        this.mLegacyPermissionManager.scheduleReadDefaultPermissionExceptions();
    L38:
        if (this.mInstantAppResolverConnection == null) goto L40;
        this.mContext.registerReceiver(new AnonymousClass5(this), new IntentFilter("android.intent.action.BOOT_COMPLETED"));
    L40:
        IntentFilter overlayFilter = new IntentFilter("android.intent.action.OVERLAY_CHANGED");
        overlayFilter.addDataScheme("package");
        this.mContext.registerReceiver(new AnonymousClass6(this), overlayFilter);
        this.mModuleInfoProvider.systemReady();
        new BoostFramework(this.mContext, true);
        this.mInstallerService.restoreAndApplyStagedSessionIfNeeded();
        this.mExistingPackages = null;
        DeviceConfig.addOnPropertiesChangedListener("package_manager_service", this.mInjector.getBackgroundExecutor(), new PackageManagerService$$ExternalSyntheticLambda14(this));
        schedulePruneUnusedStaticSharedLibraries(false);
        DexUseManagerLocal dexUseManager = DexOptHelper.getDexUseManagerLocal();
        if (dexUseManager == null) goto L43;
        dexUseManager.systemReady();
    L43:
        PackageManagerServiceSmtEx.atSystemReadyBeginning(this.mContext, this.mHandler);
        this.mPackageManagerServiceSmtEx.clearStatement(this.mContext);
        this.mExt.systemReady();
        this.mObricExt.systemReady();
        return;
    L21:
        th = move-exception;
        resetPriorityAfterPackageManagerTracedLockedSection();
        throw th;
    L11:
        compatibilityModeEnabled = false;
        goto L12
    }

    private /* synthetic */ void lambda$systemReady$51(DeviceConfig.Properties properties) {
        Set<String> keyset = properties.getKeyset();
        if (keyset.contains(PROPERTY_INCFS_DEFAULT_TIMEOUTS) == false) goto L5;
    L6:
        this.mPerUidReadTimeoutsCache = null;
        return;
    L5:
        if (keyset.contains(PROPERTY_KNOWN_DIGESTERS_LIST) == true) goto L6;
    }

    public PackageFreezer freezePackage(String packageName, int userId, String killReason, int exitInfoReason, InstallRequest request) {
        return freezePackage(packageName, userId, killReason, exitInfoReason, request, false);
    }

    private PackageFreezer freezePackage(String packageName, int userId, String killReason, int exitInfoReason, InstallRequest request, boolean waitAppKilled) {
        return new PackageFreezer(packageName, userId, killReason, this, exitInfoReason, request, waitAppKilled);
    }

    public PackageFreezer freezePackageForDelete(String packageName, int userId, int deleteFlags, String killReason, int exitInfoReason) {
        if ((deleteFlags & 8) == 0) goto L7;
        return new PackageFreezer(this, null);
    L7:
        return freezePackage(packageName, userId, killReason, exitInfoReason, null);
    }

    void cleanUpUser(UserManagerService userManager, int userId) {
        PackageManagerTracedLock r0 = this.mLock;
        boostPriorityForPackageManagerTracedLockedSection();
        monitor-enter(r0);
        ArraySet<Integer> r1 = this.mDirtyUsers;     // Catch: Throwable -> L12
        monitor-enter(r1);     // Catch: Throwable -> L12
        this.mDirtyUsers.remove(Integer.valueOf(userId));     // Catch: Throwable -> L14
        monitor-exit(r1);     // Catch: Throwable -> L14
        this.mUserNeedsBadging.delete(userId);     // Catch: Throwable -> L12
        this.mDeletePackageHelper.removeUnusedPackagesLPw(userManager, userId);     // Catch: Throwable -> L12
        this.mSettings.removeUserLPw(userId);     // Catch: Throwable -> L12
        this.mPendingBroadcasts.remove(userId);     // Catch: Throwable -> L12
        this.mAppsFilter.onUserDeleted(snapshotComputer(), userId);     // Catch: Throwable -> L12
        this.mPermissionManager.onUserRemoved(userId);     // Catch: Throwable -> L12
        monitor-exit(r0);     // Catch: Throwable -> L12
        resetPriorityAfterPackageManagerTracedLockedSection();
        this.mInstantAppRegistry.onUserRemoved(userId);
        this.mPackageMonitorCallbackHelper.onUserRemoved(userId);
        return;
    L14:
        th = move-exception;
        throw th;     // Catch: Throwable -> L12
    L12:
        th = move-exception;
        resetPriorityAfterPackageManagerTracedLockedSection();
        throw th;
    }

    private void cleanUpCrossUserSuspension(final int removedUser) {
        Computer computer = snapshotComputer();
        String[] allPackages = computer.getAllAvailablePackageNames();
        int[] r2 = this.mUserManager.getUserIds();
        int r3 = r2.length;
        int r4 = 0;
    L3:
        if (r4 >= r3) goto L9;
        int targetUserId = r2[r4];
        if (targetUserId == removedUser) goto L8;
        this.mSuspendPackageHelper.removeSuspensionsBySuspendingPackage(computer, allPackages, new PackageManagerService$$ExternalSyntheticLambda6(removedUser), targetUserId);
    L8:
        r4 = r4 + 1;
        goto L3
    }

    private static /* synthetic */ boolean lambda$cleanUpCrossUserSuspension$52(int removedUser, UserPackage userPackage) {
        if (userPackage.userId != removedUser) goto L5;
        return true;
    L5:
        return false;
    }

    void createNewUser(int userId, Set<String> userTypeInstallablePackages, String[] disallowedPackages) {
        PackageManagerTracedLock installLock = this.mInstallLock.acquireLock();
        this.mSettings.createNewUserLI(this, this.mInstaller, userId, userTypeInstallablePackages, disallowedPackages);     // Catch: Throwable -> L19
        if (installLock == null) goto L8;
        installLock.close();
    L8:
        PackageManagerTracedLock r9 = this.mLock;
        boostPriorityForPackageManagerTracedLockedSection();
        monitor-enter(r9);
        scheduleWritePackageRestrictions(userId);     // Catch: Throwable -> L14
        scheduleWritePackageListLocked(userId);     // Catch: Throwable -> L14
        this.mAppsFilter.onUserCreated(snapshotComputer(), userId);     // Catch: Throwable -> L14
        monitor-exit(r9);     // Catch: Throwable -> L14
        resetPriorityAfterPackageManagerTracedLockedSection();
        return;
    L14:
        th = move-exception;
        resetPriorityAfterPackageManagerTracedLockedSection();
        throw th;
    L19:
        th = move-exception;
        Throwable r10 = th;
    L23:
        if (installLock == null) goto L37;
        installLock.close();     // Catch: Throwable -> L26
        throw r10;
    L26:
        th = move-exception;
        r10.addSuppressed(th);
        throw r10;
    L37:
        throw r10;
    L21:
        th = move-exception;
        r10 = th;
        goto L23
    }

    void onNewUserCreated(int userId, boolean convertedFromPreCreated) {
        if (convertedFromPreCreated == true) goto L4;
    L5:
        this.mPermissionManager.onUserCreated(userId);
        this.mLegacyPermissionManager.grantDefaultPermissions(userId);
        this.mPermissionManager.setDefaultPermissionGrantFingerprint(Build.FINGERPRINT, userId);
        this.mDomainVerificationManager.clearUser(userId);
        return;
    L4:
        if (readPermissionStateForUser(userId) == false) goto L5;
    }

    private boolean readPermissionStateForUser(int userId) {
        PackageManagerTracedLock r0 = this.mLock;
        boostPriorityForPackageManagerTracedLockedSection();
        monitor-enter(r0);
        this.mPermissionManager.writeLegacyPermissionStateTEMP();     // Catch: Throwable -> L11
        this.mSettings.readPermissionStateForUserSyncLPr(userId);     // Catch: Throwable -> L11
        this.mPermissionManager.readLegacyPermissionStateTEMP();     // Catch: Throwable -> L11
        if (Objects.equals(this.mPermissionManager.getDefaultPermissionGrantFingerprint(userId), Build.FINGERPRINT) == true) goto L7;
        boolean isPermissionUpgradeNeeded = true;
    L8:
        monitor-exit(r0);     // Catch: Throwable -> L11
        resetPriorityAfterPackageManagerTracedLockedSection();
        return isPermissionUpgradeNeeded;
    L7:
        isPermissionUpgradeNeeded = false;
    L11:
        th = move-exception;
        resetPriorityAfterPackageManagerTracedLockedSection();
        throw th;
    }

    public boolean isStorageLow() {
        long token = Binder.clearCallingIdentity();
        DeviceStorageMonitorInternal dsm = (DeviceStorageMonitorInternal) this.mInjector.getLocalService(DeviceStorageMonitorInternal.class);     // Catch: Throwable -> L8
        if (dsm == null) goto L10;
        boolean r3 = dsm.isMemoryLow();     // Catch: Throwable -> L8
        Binder.restoreCallingIdentity(token);
        return r3;
    L10:
        Binder.restoreCallingIdentity(token);
        return false;
    L8:
        th = move-exception;
        Binder.restoreCallingIdentity(token);
        throw th;
    }

    private void deletePackageIfUnused(Computer snapshot, final String packageName) {
        PackageStateInternal ps = snapshot.getPackageStateInternal(packageName);
        if (ps != null) goto L5;
        return;
    L5:
        SparseArray<? extends PackageUserStateInternal> userStates = ps.getUserStates();
        int index = 0;
    L7:
        if (index >= userStates.size()) goto L12;
        if (userStates.valueAt(index).isInstalled() == true) goto L10;
        index = index + 1;
        goto L7
    L10:
        return;
    L12:
        this.mHandler.post(new PackageManagerService$$ExternalSyntheticLambda29(this, packageName));
    }

    private /* synthetic */ void lambda$deletePackageIfUnused$53(String packageName) {
        this.mDeletePackageHelper.deletePackageX(packageName, -1, 0, 2, true);
    }

    void deletePreloadsFileCache() {
        this.mContext.enforceCallingOrSelfPermission("android.permission.CLEAR_APP_CACHE", "deletePreloadsFileCache");
        File dir = Environment.getDataPreloadsFileCacheDirectory();
        Slog.i("PackageManager", "Deleting preloaded file cache " + dir);
        FileUtils.deleteContents(dir);
    }

    void setSystemAppHiddenUntilInstalled(Computer snapshot, final String packageName, final boolean hidden) {
        int callingUid = Binder.getCallingUid();
        boolean calledFromSystemOrPhone = isSystemOrPhone(callingUid);
        if (calledFromSystemOrPhone == true) goto L5;
        this.mContext.enforceCallingOrSelfPermission("android.permission.SUSPEND_APPS", "setSystemAppHiddenUntilInstalled");
    L5:
        PackageStateInternal stateRead = snapshot.getPackageStateInternal(packageName);
        if (stateRead != null) goto L8;
        return;
    L8:
        if (stateRead.isSystem() == true) goto L10;
        return;
    L10:
        if (stateRead.getPkg() != null) goto L13;
        return;
    L13:
        if (stateRead.getPkg().isCoreApp() == false) goto L18;
        if (calledFromSystemOrPhone == true) goto L18;
        throw new SecurityException("Only system or phone callers can modify core apps");
    L18:
        commitPackageStateMutation(null, new PackageManagerService$$ExternalSyntheticLambda65(packageName, hidden));
    }

    private static /* synthetic */ void lambda$setSystemAppHiddenUntilInstalled$54(String packageName, boolean hidden, PackageStateMutator mutator) {
        mutator.forPackage(packageName).setHiddenUntilInstalled(hidden);
        mutator.forDisabledSystemPackage(packageName).setHiddenUntilInstalled(hidden);
    }

    boolean setSystemAppInstallState(Computer snapshot, String packageName, boolean installed, int userId) {
        int callingUid = Binder.getCallingUid();
        boolean calledFromSystemOrPhone = isSystemOrPhone(callingUid);
        if (calledFromSystemOrPhone == true) goto L5;
        this.mContext.enforceCallingOrSelfPermission("android.permission.SUSPEND_APPS", "setSystemAppHiddenUntilInstalled");
    L5:
        PackageStateInternal packageState = snapshot.getPackageStateInternal(packageName);
        if (packageState == null) goto L37;
        if (packageState.isSystem() == false) goto L37;
        if (packageState.getPkg() == null) goto L37;
        if (packageState.getPkg().isCoreApp() == false) goto L19;
        if (calledFromSystemOrPhone == true) goto L19;
        throw new SecurityException("Only system or phone callers can modify core apps");
    L19:
        if (packageState.getUserStateOrDefault(userId).isInstalled() != installed) goto L21;
        return false;
    L21:
        long callingId = Binder.clearCallingIdentity();
        if (installed == false) goto L38;
        this.mInstallPackageHelper.installExistingPackageAsUser(packageName, userId, 4194304, 3, null, null);     // Catch: Throwable -> L26
        Binder.restoreCallingIdentity(callingId);
        return true;
    L38:
        deletePackageVersioned(new VersionedPackage(packageName, -1), new PackageManager.LegacyPackageDeleteObserver(null).getBinder(), userId, 4);     // Catch: Throwable -> L33
        Binder.restoreCallingIdentity(callingId);
        return true;
    L33:
        th = th;
    L34:
        Binder.restoreCallingIdentity(callingId);
        throw th;
    L26:
        th = th;
    L37:
        return false;
    }

    void finishPackageInstall(int r4, boolean r5) {
        PackageManagerServiceUtils.enforceSystemOrRoot("Only the system is allowed to finish installs");
        Trace.asyncTraceEnd(262144, "restore", r4);
        Message r0 = this.mHandler.obtainMessage(9, r4, r5 ? 1 : 0);
        this.mHandler.sendMessage(r0);
    }

    void checkPackageStartable(Computer snapshot, String packageName, int userId) {
        int callingUid = Binder.getCallingUid();
        if (snapshot.getInstantAppPackageName(callingUid) != null) goto L20;
        if (this.mUserManager.exists(userId) == false) goto L18;
        snapshot.enforceCrossUserPermission(callingUid, userId, false, false, "checkPackageStartable");
        switch(snapshot.getPackageStartability(this.mSafeMode, packageName, callingUid, userId)) {
            case 1: goto L16;
            case 2: goto L14;
            case 3: goto L12;
            case 4: goto L10;
            default: goto L8;
        };
    L8:
        return;
    L10:
        throw new SecurityException("Package " + packageName + " is not encryption aware!");
    L12:
        throw new SecurityException("Package " + packageName + " is currently frozen!");
    L14:
        throw new SecurityException("Package " + packageName + " not a system app!");
    L16:
        throw new SecurityException("Package " + packageName + " was not found!");
    L18:
        throw new SecurityException("User doesn't exist");
    L20:
        throw new SecurityException("Instant applications don't have access to this method");
    }

    void setPackageStoppedState(Computer snapshot, final String packageName, final boolean stopped, int userId) {
        if (this.mUserManager.exists(userId) == true) goto L5;
        return;
    L5:
        int callingUid = Binder.getCallingUid();
        if (snapshot.getInstantAppPackageName(callingUid) != null) goto L31;
        int permission = this.mContext.checkCallingOrSelfPermission("android.permission.CHANGE_COMPONENT_ENABLED_STATE");
        if (permission != 0) goto L10;
        boolean r5 = true;
    L11:
        boolean allowedByPermission = r5;
        if (allowedByPermission == false) goto L14;
    L18:
        snapshot.enforceCrossUserPermission(callingUid, userId, true, true, "stop package");
        final int r13 = userId;
        PackageStateInternal packageState = snapshot.getPackageStateForInstalledAndFiltered(packageName, callingUid, r13);
        if (packageState != null) goto L21;
        PackageUserState packageUserState = null;
    L22:
        if (packageState != null) goto L24;
    L32:
        boolean wasStopped = false;
    L33:
        if (stopped == true) goto L38;
        this.mHandler.post(new PackageManagerService$$ExternalSyntheticLambda21(this, packageName, r13));
        if (wasStopped == false) goto L39;
        Trace.traceBegin(262144, "unstoppedBroadcast");
        PackageManagerInternal pmi = (PackageManagerInternal) this.mInjector.getLocalService(PackageManagerInternal.class);
        final int[] userIds = resolveUserIds(r13);
        final SparseArray<int[]> broadcastAllowList = snapshotComputer().getVisibilityAllowLists(packageName, userIds);
        final Bundle extras = new Bundle();
        extras.putInt("android.intent.extra.UID", pmi.getPackageUid(packageName, 0, r13));
        extras.putInt("android.intent.extra.user_handle", r13);
        extras.putLong("android.intent.extra.TIME", SystemClock.elapsedRealtime());
        this.mHandler.post(new PackageManagerService$$ExternalSyntheticLambda22(this, packageName, extras, userIds, broadcastAllowList));
        this.mPackageMonitorCallbackHelper.notifyPackageMonitor("android.intent.action.PACKAGE_UNSTOPPED", packageName, extras, userIds, null, broadcastAllowList, this.mHandler, null);
        Trace.traceEnd(262144);
        return;
    L39:
        return;
    L38:
        return;
    L24:
        if (packageUserState.isStopped() == stopped) goto L32;
        final boolean wasNotLaunched = packageUserState.isNotLaunched();
        boolean wasStopped2 = packageUserState.isStopped();
        commitPackageStateMutation(null, packageName, new PackageManagerService$$ExternalSyntheticLambda20(r13, stopped, wasNotLaunched));
        if (wasNotLaunched == false) goto L30;
        String installerPackageName = packageState.getInstallSource().mInstallerPackageName;
        if (installerPackageName == null) goto L30;
        notifyFirstLaunch(packageName, installerPackageName, r13);
    L30:
        scheduleWritePackageRestrictions(r13);
        wasStopped = wasStopped2;
        goto L33
    L21:
        packageUserState = packageState.getUserStateOrDefault(r13);
        goto L22
    L14:
        if (ArrayUtils.contains(snapshot.getPackagesForUid(callingUid), packageName) == true) goto L18;
        throw new SecurityException("Permission Denial: attempt to change stopped state from pid=" + Binder.getCallingPid() + ", uid=" + callingUid + ", package=" + packageName);
    L10:
        r5 = false;
        goto L11
    L31:
        r13 = userId;
        goto L32
    }

    private static /* synthetic */ void lambda$setPackageStoppedState$55(int userId, boolean stopped, boolean wasNotLaunched, PackageStateWrite state) {
        PackageUserStateWrite userState = state.userState(userId);
        userState.setStopped(stopped);
        if (wasNotLaunched == false) goto L6;
        userState.setNotLaunched(false);
        return;
    }

    private /* synthetic */ void lambda$setPackageStoppedState$56(String packageName, int userId) {
        AppHibernationManagerInternal ah = (AppHibernationManagerInternal) this.mInjector.getLocalService(AppHibernationManagerInternal.class);
        if (ah != null) goto L5;
        return;
    L5:
        if (ah.isHibernatingForUser(packageName, userId) == false) goto L9;
        ah.setHibernatingForUser(packageName, userId, false);
        ah.setHibernatingGlobally(packageName, false);
        return;
    }

    private /* synthetic */ void lambda$setPackageStoppedState$57(String packageName, Bundle extras, int[] userIds, SparseArray broadcastAllowList) {
        this.mBroadcastHelper.sendPackageBroadcast("android.intent.action.PACKAGE_UNSTOPPED", packageName, extras, 1073741824, null, null, userIds, null, broadcastAllowList, null, null, null);
    }

    void notifyComponentUsed(Computer snapshot, String packageName, int userId, String recentCallingPackage, String debugInfo) {
        PackageManagerTracedLock r0 = this.mLock;
        boostPriorityForPackageManagerTracedLockedSection();
        monitor-enter(r0);
        PackageSetting pkgSetting = this.mSettings.getPackageLPr(packageName);     // Catch: Throwable -> L9
        if (pkgSetting != null) goto L12;
        monitor-exit(r0);     // Catch: Throwable -> L9
        resetPriorityAfterPackageManagerTracedLockedSection();
        return;
    L12:
        if (pkgSetting.getUserStateOrDefault(userId).isQuarantined() == false) goto L14;
        Slog.i("PackageManager", "Component is quarantined+suspended but being used: " + packageName + " by " + recentCallingPackage + ", debugInfo: " + debugInfo);     // Catch: Throwable -> L9
    L14:
        monitor-exit(r0);     // Catch: Throwable -> L9
        resetPriorityAfterPackageManagerTracedLockedSection();
        setPackageStoppedState(snapshot, packageName, false, userId);
        return;
    L9:
        th = move-exception;
        resetPriorityAfterPackageManagerTracedLockedSection();
        throw th;
    }

    private void setEnabledOverlayPackages(int userId, final ArrayMap<String, OverlayPaths> pendingChanges, final Set<String> outUpdatedPackageNames, Set<String> outInvalidPackageNames) {
        final int r6 = userId;
        ArrayMap<String, OverlayPaths> r8 = pendingChanges;
        final ArrayMap<String, ArrayMap<String, ArraySet<String>>> targetPkgToLibNameToModifiedDependents = new ArrayMap();
        final int numberOfPendingChanges = r8.size();
        PackageManagerTracedLock r12 = this.mOverlayPathsLock;
        boostPriorityForPackageManagerTracedLockedSection();
        monitor-enter(r12);
        Computer computer = snapshotComputer();     // Catch: Throwable -> L88
        int i = 0;
    L6:
        AndroidPackage targetPkg = null;
        if (i >= numberOfPendingChanges) goto L94;
        String targetPackageName = r8.keyAt(i);     // Catch: Throwable -> L69
        OverlayPaths newOverlayPaths = r8.valueAt(i);     // Catch: Throwable -> L69
        PackageStateInternal packageState = computer.getPackageStateInternal(targetPackageName);     // Catch: Throwable -> L69
        if (packageState == null) goto L13;
        targetPkg = packageState.getPkg();     // Catch: Throwable -> L69
    L13:
        if (targetPackageName == null) goto L63;
        if (targetPkg == null) goto L63;
        if (Objects.equals(packageState.getUserStateOrDefault(r6).getOverlayPaths(), newOverlayPaths) == false) goto L20;
        i = i;
        computer = computer;
    L66:
        i = i + 1;
        r8 = pendingChanges;
        computer = computer;
        goto L6
    L20:
        if (targetPkg.getLibraryNames() == null) goto L56;
        List<String> libraryNames = targetPkg.getLibraryNames();     // Catch: Throwable -> L42
        int j = 0;
    L23:
        if (j >= libraryNames.size()) goto L55;
        String libName = libraryNames.get(j);     // Catch: Throwable -> L42
        PackageStateInternal packageState2 = packageState;
        List<String> libraryNames2 = libraryNames;
        SharedLibraryInfo info = computer.getSharedLibraryInfo(libName, -1);     // Catch: Throwable -> L42
        if (info != null) goto L27;
        int i2 = i;
        Computer computer2 = computer;
        int j2 = j;
        PackageStateInternal packageState3 = packageState2;
    L52:
        j = j2 + 1;     // Catch: Throwable -> L42
        packageState = packageState3;
        libraryNames = libraryNames2;
        i = i2;
        computer = computer2;
        goto L23
    L27:
        j2 = j;
        i2 = i;
        packageState3 = packageState2;
        Pair<List<VersionedPackage>, List<Boolean>> usingSharedLibraryPair = computer.getPackagesUsingSharedLibrary(info, 0, 1000, userId);     // Catch: Throwable -> L53
        r6 = userId;
        List<VersionedPackage> dependents = (List) usingSharedLibraryPair.first;     // Catch: Throwable -> L42
        if (dependents != null) goto L33;
        computer2 = computer;
        goto L52
    L33:
        int k = 0;
        ArraySet<String> modifiedDependents = null;
    L34:
        Pair<List<VersionedPackage>, List<Boolean>> usingSharedLibraryPair2 = usingSharedLibraryPair;
        if (k >= dependents.size()) goto L46;
        VersionedPackage dependent = dependents.get(k);     // Catch: Throwable -> L42
        PackageStateInternal dependentState = computer.getPackageStateInternal(dependent.getPackageName());     // Catch: Throwable -> L42
        if (dependentState != null) goto L39;
        Computer computer3 = computer;
    L45:
        k = k + 1;     // Catch: Throwable -> L42
        usingSharedLibraryPair = usingSharedLibraryPair2;
        computer = computer3;
        goto L34
    L39:
        computer3 = computer;
        if (canSetOverlayPaths(dependentState.getUserStateOrDefault(r6).getSharedLibraryOverlayPaths().get(libName), newOverlayPaths) == false) goto L45;
        String dependentPackageName = dependent.getPackageName();     // Catch: Throwable -> L42
        ArraySet<String> modifiedDependents2 = ArrayUtils.add(modifiedDependents, dependentPackageName);     // Catch: Throwable -> L42
        outUpdatedPackageNames.add(dependentPackageName);     // Catch: Throwable -> L42
        modifiedDependents = modifiedDependents2;
        goto L45
    L46:
        computer2 = computer;
        if (modifiedDependents == null) goto L52;
        ArrayMap<String, ArraySet<String>> libNameToModifiedDependents = targetPkgToLibNameToModifiedDependents.get(targetPackageName);     // Catch: Throwable -> L42
        if (libNameToModifiedDependents != null) goto L51;
        libNameToModifiedDependents = new ArrayMap();     // Catch: Throwable -> L42
        targetPkgToLibNameToModifiedDependents.put(targetPackageName, libNameToModifiedDependents);     // Catch: Throwable -> L42
    L51:
        libNameToModifiedDependents.put(libName, modifiedDependents);     // Catch: Throwable -> L42
    L53:
        th = th;
    L90:
        monitor-exit(r12);     // Catch: Throwable -> L83
        resetPriorityAfterPackageManagerTracedLockedSection();
        throw th;
    L55:
        i = i;
        computer = computer;
        PackageStateInternal packageState4 = packageState;
    L58:
        if (canSetOverlayPaths(packageState4.getUserStateOrDefault(r6).getOverlayPaths(), newOverlayPaths) == false) goto L66;
        outUpdatedPackageNames.add(targetPackageName);     // Catch: Throwable -> L42
        goto L66
    L56:
        i = i;
        computer = computer;
        packageState4 = packageState;
    L42:
        th = th;
    L63:
        Slog.e("PackageManager", "failed to find package " + targetPackageName);     // Catch: Throwable -> L69
        outInvalidPackageNames.add(targetPackageName);     // Catch: Throwable -> L67
    L67:
        th = th;
    L69:
        th = th;
        goto L90
    L94:
        commitPackageStateMutation(null, new PackageManagerService$$ExternalSyntheticLambda0(numberOfPendingChanges, pendingChanges, outUpdatedPackageNames, r6, targetPkgToLibNameToModifiedDependents));     // Catch: Throwable -> L83
        monitor-exit(r12);     // Catch: Throwable -> L83
        resetPriorityAfterPackageManagerTracedLockedSection();
        if (userId != 0) goto L81;
        int i3 = 0;
    L79:
        if (i3 >= numberOfPendingChanges) goto L81;
        maybeUpdateSystemOverlays(pendingChanges.keyAt(i3), pendingChanges.valueAt(i3));
        i3 = i3 + 1;
    L81:
        invalidatePackageInfoCache();
        return;
    L85:
        th = th;
    L83:
        th = th;
    L88:
        th = th;
        goto L90
    }

    private static /* synthetic */ void lambda$setEnabledOverlayPackages$58(int numberOfPendingChanges, ArrayMap pendingChanges, Set outUpdatedPackageNames, int userId, ArrayMap targetPkgToLibNameToModifiedDependents, PackageStateMutator mutator) {
        int i = 0;
    L3:
        if (i >= numberOfPendingChanges) goto L20;
        String targetPackageName = (String) pendingChanges.keyAt(i);
        OverlayPaths newOverlayPaths = (OverlayPaths) pendingChanges.valueAt(i);
        if (outUpdatedPackageNames.contains(targetPackageName) == false) goto L18;
        mutator.forPackage(targetPackageName).userState(userId).setOverlayPaths(newOverlayPaths);
        ArrayMap<String, ArraySet<String>> libNameToModifiedDependents = (ArrayMap) targetPkgToLibNameToModifiedDependents.get(targetPackageName);
        if (libNameToModifiedDependents == null) goto L18;
        int mapIndex = 0;
    L12:
        if (mapIndex >= libNameToModifiedDependents.size()) goto L18;
        String libName = libNameToModifiedDependents.keyAt(mapIndex);
        ArraySet<String> modifiedDependents = libNameToModifiedDependents.valueAt(mapIndex);
        int setIndex = 0;
    L15:
        if (setIndex >= modifiedDependents.size()) goto L17;
        mutator.forPackage(modifiedDependents.valueAt(setIndex)).userState(userId).setOverlayPathsForLibrary(libName, newOverlayPaths);
        setIndex = setIndex + 1;
        goto L15
    L17:
        mapIndex = mapIndex + 1;
    L18:
        i = i + 1;
        goto L3
    }

    private boolean canSetOverlayPaths(OverlayPaths origPaths, OverlayPaths newPaths) {
        if (Objects.equals(origPaths, newPaths) == false) goto L5;
        return false;
    L5:
        if (origPaths == null) goto L7;
    L8:
        if (newPaths == null) goto L10;
        return true;
    L10:
        if (origPaths.isEmpty() == false) goto L14;
    L11:
        return false;
    L14:
        return true;
    L7:
        if (newPaths.isEmpty() == true) goto L11;
        goto L8
    }

    private void maybeUpdateSystemOverlays(String targetPackageName, OverlayPaths newOverlayPaths) {
        if (this.mResolverReplaced == true) goto L11;
        if (targetPackageName.equals(PLATFORM_PACKAGE_NAME) == false) goto L17;
        if (newOverlayPaths != null) goto L8;
        this.mPlatformPackageOverlayPaths = null;
        this.mPlatformPackageOverlayResourceDirs = null;
    L9:
        applyUpdatedSystemOverlayPaths();
        return;
    L8:
        this.mPlatformPackageOverlayPaths = (String[]) newOverlayPaths.getOverlayPaths().toArray(new String[0]);
        this.mPlatformPackageOverlayResourceDirs = (String[]) newOverlayPaths.getResourceDirs().toArray(new String[0]);
        goto L9
    L17:
        return;
    L11:
        if (targetPackageName.equals(this.mResolveActivity.applicationInfo.packageName) == false) goto L19;
        if (newOverlayPaths != null) goto L14;
        this.mReplacedResolverPackageOverlayPaths = null;
        this.mReplacedResolverPackageOverlayResourceDirs = null;
    L15:
        applyUpdatedSystemOverlayPaths();
        return;
    L14:
        this.mReplacedResolverPackageOverlayPaths = (String[]) newOverlayPaths.getOverlayPaths().toArray(new String[0]);
        this.mReplacedResolverPackageOverlayResourceDirs = (String[]) newOverlayPaths.getResourceDirs().toArray(new String[0]);
        goto L15
    }

    private void applyUpdatedSystemOverlayPaths() {
        if (this.mAndroidApplication != null) goto L5;
        Slog.i("PackageManager", "Skipped the AndroidApplication overlay paths update - no app yet");
    L7:
        if (this.mResolverReplaced == false) goto L10;
        ApplicationInfo r0 = this.mResolveActivity.applicationInfo;
        r0.overlayPaths = this.mReplacedResolverPackageOverlayPaths;
        ApplicationInfo r1 = this.mResolveActivity.applicationInfo;
        r1.resourceDirs = this.mReplacedResolverPackageOverlayResourceDirs;
        return;
    L10:
        return;
    L5:
        ApplicationInfo r2 = this.mAndroidApplication;
        r2.overlayPaths = this.mPlatformPackageOverlayPaths;
        ApplicationInfo r3 = this.mAndroidApplication;
        r3.resourceDirs = this.mPlatformPackageOverlayResourceDirs;
        goto L7
    }

    private void enforceAdjustRuntimePermissionsPolicyOrUpgradeRuntimePermissions(String message) {
        if (this.mContext.checkCallingOrSelfPermission("android.permission.ADJUST_RUNTIME_PERMISSIONS_POLICY") != 0) goto L5;
        return;
    L5:
        if (this.mContext.checkCallingOrSelfPermission("android.permission.UPGRADE_RUNTIME_PERMISSIONS") != 0) goto L8;
        return;
    L8:
        throw new SecurityException(message + " requires android.permission.ADJUST_RUNTIME_PERMISSIONS_POLICY or android.permission.UPGRADE_RUNTIME_PERMISSIONS");
    }

    @Deprecated
    PackageSetting getPackageSettingForMutation(String packageName) {
        return this.mSettings.getPackageLPr(packageName);
    }

    @Deprecated
    PackageSetting getDisabledPackageSettingForMutation(String packageName) {
        return this.mSettings.getDisabledSystemPkgLPr(packageName);
    }

    @Deprecated
    void forEachPackageSetting(Consumer<PackageSetting> actionLocked) {
        PackageManagerTracedLock r0 = this.mLock;
        boostPriorityForPackageManagerTracedLockedSection();
        monitor-enter(r0);
        int size = this.mSettings.getPackagesLocked().size();     // Catch: Throwable -> L7
        int index = 0;
    L5:
        if (index >= size) goto L10;
        actionLocked.accept(this.mSettings.getPackagesLocked().valueAt(index));     // Catch: Throwable -> L7
        index = index + 1;     // Catch: Throwable -> L7
        goto L5
    L10:
        monitor-exit(r0);     // Catch: Throwable -> L7
        resetPriorityAfterPackageManagerTracedLockedSection();
        return;
    L7:
        th = move-exception;
        resetPriorityAfterPackageManagerTracedLockedSection();
        throw th;
    }

    void forEachPackageState(Computer snapshot, Consumer<PackageStateInternal> consumer) {
        forEachPackageState(snapshot.getPackageStates(), consumer);
    }

    void forEachPackage(Computer snapshot, Consumer<AndroidPackage> consumer) {
        ArrayMap<String, ? extends PackageStateInternal> packageStates = snapshot.getPackageStates();
        int size = packageStates.size();
        int index = 0;
    L3:
        if (index >= size) goto L9;
        PackageStateInternal packageState = packageStates.valueAt(index);
        if (packageState.getPkg() == null) goto L7;
        consumer.accept(packageState.getPkg());
    L7:
        index = index + 1;
        goto L3
    }

    void forEachPackageInternal(Computer snapshot, Consumer<AndroidPackageInternal> consumer) {
        ArrayMap<String, ? extends PackageStateInternal> packageStates = snapshot.getPackageStates();
        int size = packageStates.size();
        int index = 0;
    L3:
        if (index >= size) goto L9;
        PackageStateInternal packageState = packageStates.valueAt(index);
        if (packageState.getPkg() == null) goto L7;
        consumer.accept(packageState.getPkg());
    L7:
        index = index + 1;
        goto L3
    }

    private void forEachPackageState(ArrayMap<String, ? extends PackageStateInternal> packageStates, Consumer<PackageStateInternal> consumer) {
        int size = packageStates.size();
        int index = 0;
    L3:
        if (index >= size) goto L6;
        PackageStateInternal packageState = packageStates.valueAt(index);
        consumer.accept(packageState);
        index = index + 1;
        goto L3
    }

    void forEachInstalledPackage(Computer snapshot, final Consumer<AndroidPackage> action, final int userId) {
        Consumer<PackageStateInternal> actionWrapped = new PackageManagerService$$ExternalSyntheticLambda2(userId, action);
        forEachPackageState(snapshot.getPackageStates(), actionWrapped);
    }

    private static /* synthetic */ void lambda$forEachInstalledPackage$59(int userId, Consumer action, PackageStateInternal packageState) {
        if (packageState.getPkg() != null) goto L5;
        return;
    L5:
        if (packageState.getUserStateOrDefault(userId).isInstalled() == false) goto L9;
        action.accept(packageState.getPkg());
        return;
    }

    boolean isHistoricalPackageUsageAvailable() {
        return this.mPackageUsage.isHistoricalPackageUsageAvailable();
    }

    public CompilerStats.PackageStats getOrCreateCompilerPackageStats(AndroidPackage pkg) {
        return getOrCreateCompilerPackageStats(pkg.getPackageName());
    }

    public CompilerStats.PackageStats getOrCreateCompilerPackageStats(String pkgName) {
        return this.mCompilerStats.getOrCreatePackageStats(pkgName);
    }

    void grantImplicitAccess(Computer snapshot, int userId, Intent intent, int recipientAppId, int visibleUid, boolean direct, boolean retainOnUpdate) {
        AndroidPackage visiblePackage = snapshot.getPackage(visibleUid);
        int recipientUid = UserHandle.getUid(userId, recipientAppId);
        if (visiblePackage != null) goto L5;
        return;
    L5:
        if (snapshot.getPackage(recipientUid) == null) goto L18;
        boolean instantApp = snapshot.isInstantAppInternal(visiblePackage.getPackageName(), userId, visibleUid);
        if (instantApp == false) goto L12;
        if (direct == true) goto L11;
        return;
    L11:
        boolean accessGranted = this.mInstantAppRegistry.grantInstantAccess(userId, intent, recipientAppId, UserHandle.getAppId(visibleUid));
    L13:
        if (accessGranted == false) goto L17;
        ApplicationPackageManager.invalidateGetPackagesForUidCache();
        return;
    L17:
        return;
    L12:
        accessGranted = this.mAppsFilter.grantImplicitAccess(recipientUid, visibleUid, retainOnUpdate);
        goto L13
    }

    boolean canHaveOatDir(Computer snapshot, String packageName) {
        PackageStateInternal packageState = snapshot.getPackageStateInternal(packageName);
        if (packageState != null) goto L5;
        return false;
    L5:
        if (packageState.getPkg() != null) goto L8;
        return false;
    L8:
        return AndroidPackageUtils.canHaveOatDir(packageState, packageState.getPkg());
    }

    long deleteOatArtifactsOfPackage(Computer snapshot, String packageName) {
        PackageManagerServiceUtils.enforceSystemOrRootOrShell("Only the system or shell can delete oat artifacts");
        PackageManagerLocal.FilteredSnapshot filteredSnapshot = PackageManagerServiceUtils.getPackageManagerLocal().withFilteredSnapshot();
        DeleteResult res = DexOptHelper.getArtManagerLocal().deleteDexoptArtifacts(filteredSnapshot, packageName);     // Catch: Throwable -> L7 IllegalStateException -> L9 IllegalArgumentException -> L11
        long r2 = res.getFreedBytes();     // Catch: Throwable -> L7 IllegalStateException -> L9 IllegalArgumentException -> L11
        if (filteredSnapshot == null) goto L6;
        filteredSnapshot.close();
    L6:
        return r2;
    L7:
        th = move-exception;
        if (filteredSnapshot != null) goto L31;
    L28:
        throw th;
    L31:
        filteredSnapshot.close();     // Catch: Throwable -> L26
    L26:
        th = move-exception;
        th.addSuppressed(th);
    L9:
        e = move-exception;
        Slog.wtfStack("PackageManager", e.toString());     // Catch: Throwable -> L7
        if (filteredSnapshot == null) goto L17;
        filteredSnapshot.close();
    L17:
        return -1;
    L11:
        e = move-exception;
        Log.e("PackageManager", e.toString());     // Catch: Throwable -> L7
        if (filteredSnapshot == null) goto L22;
        filteredSnapshot.close();
    L22:
        return -1;
    }

    List<String> getMimeGroupInternal(Computer snapshot, String packageName, String mimeGroup) {
        PackageStateInternal packageState = snapshot.getPackageStateInternal(packageName);
        if (packageState == null) goto L5;
        Map<String, Set<String>> mimeGroups = packageState.getMimeGroups();
        if (mimeGroups == null) goto L9;
        Set<String> mimeTypes = mimeGroups.get(mimeGroup);
    L10:
        if (mimeTypes == null) goto L14;
        return new ArrayList(mimeTypes);
    L14:
        throw new IllegalArgumentException("Unknown MIME group " + mimeGroup + " for package " + packageName);
    L9:
        mimeTypes = null;
        goto L10
    L5:
        return Collections.emptyList();
    }

    void writeSettingsLPrTEMP(boolean sync) {
        snapshotComputer(false);
        this.mPermissionManager.writeLegacyPermissionsTEMP(this.mSettings.mPermissions);
        this.mSettings.writeLPr(this.mLiveComputer, sync);
    }

    void writeSettingsLPrTEMP() {
        writeSettingsLPrTEMP(false);
    }

    @Override // android.content.pm.TestUtilityService
    public void verifyHoldLockToken(IBinder token) {
        if (Build.IS_DEBUGGABLE == false) goto L13;
        if (token == null) goto L11;
        if (token.queryLocalInterface("holdLock:" + Binder.getCallingUid()) != this) goto L9;
        return;
    L9:
        throw new SecurityException("Invalid holdLock() token");
    L11:
        throw new SecurityException("null holdLockToken");
    L13:
        throw new SecurityException("holdLock requires a debuggable build");
    }

    static String getDefaultTimeouts() {
        long token = Binder.clearCallingIdentity();
        String r2 = DeviceConfig.getString("package_manager_service", PROPERTY_INCFS_DEFAULT_TIMEOUTS, "");     // Catch: Throwable -> L6
        Binder.restoreCallingIdentity(token);
        return r2;
    L6:
        th = move-exception;
        Binder.restoreCallingIdentity(token);
        throw th;
    }

    static String getKnownDigestersList() {
        long token = Binder.clearCallingIdentity();
        String r2 = DeviceConfig.getString("package_manager_service", PROPERTY_KNOWN_DIGESTERS_LIST, "");     // Catch: Throwable -> L6
        Binder.restoreCallingIdentity(token);
        return r2;
    L6:
        th = move-exception;
        Binder.restoreCallingIdentity(token);
        throw th;
    }

    static boolean isPreapprovalRequestAvailable() {
        long token = Binder.clearCallingIdentity();
    L10:
        th = move-exception;
        Binder.restoreCallingIdentity(token);
        throw th;
    L4:
        if (Resources.getSystem().getBoolean(R.bool.config_keyboardVibrationSettingsSupported) == true) goto L7;
        Binder.restoreCallingIdentity(token);
        return false;
    L7:
        boolean r2 = DeviceConfig.getBoolean("package_manager_service", PROPERTY_IS_PRE_APPROVAL_REQUEST_AVAILABLE, true);     // Catch: Throwable -> L10
        Binder.restoreCallingIdentity(token);
        return r2;
    }

    static boolean isUpdateOwnershipEnforcementAvailable() {
        long token = Binder.clearCallingIdentity();
        boolean r2 = DeviceConfig.getBoolean("package_manager_service", PROPERTY_IS_UPDATE_OWNERSHIP_ENFORCEMENT_AVAILABLE, true);     // Catch: Throwable -> L6
        Binder.restoreCallingIdentity(token);
        return r2;
    L6:
        th = move-exception;
        Binder.restoreCallingIdentity(token);
        throw th;
    }

    public PerUidReadTimeouts[] getPerUidReadTimeouts(Computer snapshot) {
        PerUidReadTimeouts[] result = this.mPerUidReadTimeoutsCache;
        if (result != null) goto L6;
        PerUidReadTimeouts[] result2 = parsePerUidReadTimeouts(snapshot);
        this.mPerUidReadTimeoutsCache = result2;
        return result2;
    L6:
        return result;
    }

    private PerUidReadTimeouts[] parsePerUidReadTimeouts(Computer snapshot) {
        String defaultTimeouts = getDefaultTimeouts();
        String knownDigestersList = getKnownDigestersList();
        List<PerPackageReadTimeouts> perPackageReadTimeouts = PerPackageReadTimeouts.parseDigestersList(defaultTimeouts, knownDigestersList);
        if (perPackageReadTimeouts.size() == 0) goto L5;
        int[] allUsers = this.mInjector.getUserManagerService().getUserIds();
        List<PerUidReadTimeouts> result = new ArrayList(perPackageReadTimeouts.size());
        int i = 0;
        int size = perPackageReadTimeouts.size();
    L7:
        if (i >= size) goto L35;
        PerPackageReadTimeouts perPackage = perPackageReadTimeouts.get(i);
        PackageStateInternal ps = snapshot.getPackageStateInternal(perPackage.packageName);
        if (ps == null) goto L33;
        if (ps.getAppId() < 10000) goto L33;
        AndroidPackageInternal r11 = ps.getPkg();
        if (r11.getLongVersionCode() < perPackage.versionCodes.minVersionCode) goto L33;
        if (r11.getLongVersionCode() > perPackage.versionCodes.maxVersionCode) goto L33;
        if (perPackage.sha256certificate != null) goto L22;
    L24:
        int r12 = allUsers.length;
        int r13 = 0;
    L25:
        if (r13 >= r12) goto L33;
        int userId = allUsers[r13];
        if (ps.getUserStateOrDefault(userId).isInstalled() == false) goto L30;
        int uid = UserHandle.getUid(userId, ps.getAppId());
        PerUidReadTimeouts perUid = new PerUidReadTimeouts();
        perUid.uid = uid;
        perUid.minTimeUs = perPackage.timeouts.minTimeUs;
        perUid.minPendingTimeUs = perPackage.timeouts.minPendingTimeUs;
        perUid.maxPendingTimeUs = perPackage.timeouts.maxPendingTimeUs;
        result.add(perUid);
    L30:
        r13 = r13 + 1;
        defaultTimeouts = defaultTimeouts;
        knownDigestersList = knownDigestersList;
        perPackageReadTimeouts = perPackageReadTimeouts;
        goto L25
    L22:
        if (r11.getSigningDetails().hasSha256Certificate(perPackage.sha256certificate) == true) goto L24;
    L33:
        i = i + 1;
        defaultTimeouts = defaultTimeouts;
        knownDigestersList = knownDigestersList;
        perPackageReadTimeouts = perPackageReadTimeouts;
        goto L7
    L35:
        return (PerUidReadTimeouts[]) result.toArray(new PerUidReadTimeouts[result.size()]);
    L5:
        return EMPTY_PER_UID_READ_TIMEOUTS_ARRAY;
    }

    void setKeepUninstalledPackagesInternal(Computer snapshot, List<String> packageList) {
        Preconditions.checkNotNull(packageList);
        ArraySet<String> r0 = this.mKeepUninstalledPackages;
        monitor-enter(r0);
        List<String> toRemove = new ArrayList(this.mKeepUninstalledPackages);     // Catch: Throwable -> L8
        toRemove.removeAll(packageList);     // Catch: Throwable -> L8
        this.mKeepUninstalledPackages.clear();     // Catch: Throwable -> L8
        this.mKeepUninstalledPackages.addAll(packageList);     // Catch: Throwable -> L8
        int i = 0;
    L6:
        if (i >= toRemove.size()) goto L11;
        deletePackageIfUnused(snapshot, toRemove.get(i));     // Catch: Throwable -> L8
        i = i + 1;     // Catch: Throwable -> L8
        goto L6
    L11:
        monitor-exit(r0);     // Catch: Throwable -> L8
        return;
    L8:
        th = move-exception;
        throw th;
    }

    boolean shouldKeepUninstalledPackageLPr(String packageName) {
        ArraySet<String> r0 = this.mKeepUninstalledPackages;
        monitor-enter(r0);
        boolean r1 = this.mKeepUninstalledPackages.contains(packageName);     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r1;
    L7:
        th = move-exception;
        throw th;
    }

    boolean getSafeMode() {
        return this.mSafeMode;
    }

    ComponentName getResolveComponentName() {
        return this.mResolveComponentName;
    }

    DefaultAppProvider getDefaultAppProvider() {
        return this.mDefaultAppProvider;
    }

    File getCacheDir() {
        return this.mCacheDir;
    }

    PackageProperty getPackageProperty() {
        return this.mPackageProperty;
    }

    WatchedArrayMap<ComponentName, ParsedInstrumentation> getInstrumentation() {
        return this.mInstrumentation;
    }

    int getSdkVersion() {
        return this.mSdkVersion;
    }

    void addAllPackageProperties(AndroidPackage pkg) {
        this.mPackageProperty.addAllProperties(pkg);
    }

    void addInstrumentation(ComponentName name, ParsedInstrumentation instrumentation) {
        this.mInstrumentation.put(name, instrumentation);
    }

    String[] getKnownPackageNamesInternal(Computer snapshot, int knownPackage, int userId) {
        return new KnownPackages(this.mDefaultAppProvider, this.mRequiredInstallerPackage, this.mRequiredUninstallerPackage, this.mSetupWizardPackage, this.mRequiredVerifierPackages, this.mDefaultTextClassifierPackage, this.mSystemTextClassifierPackageName, this.mRequiredPermissionControllerPackage, this.mConfiguratorPackage, this.mIncidentReportApproverPackage, this.mAmbientContextDetectionPackage, this.mWearableSensingPackage, this.mAppPredictionServicePackage, COMPANION_PACKAGE_NAME, this.mRetailDemoPackage, this.mOverlayConfigSignaturePackage, this.mRecentsPackage).getKnownPackageNames(snapshot, knownPackage, userId);
    }

    String getActiveLauncherPackageName(int userId) {
        return this.mDefaultAppProvider.getDefaultHome(userId);
    }

    boolean setActiveLauncherPackage(String packageName, int userId, Consumer<Boolean> callback) {
        return this.mDefaultAppProvider.setDefaultHome(packageName, userId, this.mContext.getMainExecutor(), callback);
    }

    String getDefaultBrowser(int userId) {
        return this.mDefaultAppProvider.getDefaultBrowser(userId);
    }

    void setDefaultBrowser(String packageName, int userId) {
        this.mDefaultAppProvider.setDefaultBrowser(packageName, userId);
    }

    PackageUsage getPackageUsage() {
        return this.mPackageUsage;
    }

    String getModuleMetadataPackageName() {
        return this.mModuleInfoProvider.getPackageName();
    }

    File getAppInstallDir() {
        return this.mAppInstallDir;
    }

    boolean isExpectingBetter(String packageName) {
        return this.mInitAppsHelper.isExpectingBetter(packageName);
    }

    int getDefParseFlags() {
        return this.mDefParseFlags;
    }

    void setUpCustomResolverActivity(AndroidPackage pkg, PackageSetting pkgSetting) {
        PackageManagerTracedLock r1 = this.mLock;
        boostPriorityForPackageManagerTracedLockedSection();
        monitor-enter(r1);
        this.mResolverReplaced = true;     // Catch: Throwable -> L13
        ApplicationInfo appInfo = PackageInfoUtils.generateApplicationInfo(pkg, 0, PackageUserStateInternal.DEFAULT, 0, pkgSetting);     // Catch: Throwable -> L11
        this.mResolveActivity.applicationInfo = appInfo;     // Catch: Throwable -> L11
        this.mResolveActivity.name = this.mCustomResolverComponentName.getClassName();     // Catch: Throwable -> L11
        this.mResolveActivity.packageName = pkg.getPackageName();     // Catch: Throwable -> L11
        this.mResolveActivity.processName = "system:ui";     // Catch: Throwable -> L11
        this.mResolveActivity.launchMode = 1;     // Catch: Throwable -> L11
        this.mResolveActivity.flags = 65824;     // Catch: Throwable -> L11
        this.mResolveActivity.theme = R.style.Widget.GestureOverlayView.White;     // Catch: Throwable -> L11
        this.mResolveActivity.exported = true;     // Catch: Throwable -> L11
        this.mResolveActivity.enabled = true;     // Catch: Throwable -> L11
        this.mResolveInfo.activityInfo = this.mResolveActivity;     // Catch: Throwable -> L11
        this.mResolveInfo.priority = 0;     // Catch: Throwable -> L11
        this.mResolveInfo.preferredOrder = 0;     // Catch: Throwable -> L11
        this.mResolveInfo.match = 0;     // Catch: Throwable -> L11
        this.mResolveComponentName = this.mCustomResolverComponentName;     // Catch: Throwable -> L11
        onChanged();     // Catch: Throwable -> L11
        Slog.i("PackageManager", "Replacing default ResolverActivity with custom activity: " + this.mResolveComponentName);     // Catch: Throwable -> L11
        monitor-exit(r1);     // Catch: Throwable -> L11
        resetPriorityAfterPackageManagerTracedLockedSection();
        return;
    L11:
        th = move-exception;
        Throwable r9 = th;
    L15:
        monitor-exit(r1);     // Catch: Throwable -> L11
        resetPriorityAfterPackageManagerTracedLockedSection();
        throw r9;
    L13:
        th = move-exception;
        r9 = th;
        goto L15
    }

    void setPlatformPackage(AndroidPackage pkg, PackageSetting pkgSetting) {
        PackageManagerTracedLock r1 = this.mLock;
        boostPriorityForPackageManagerTracedLockedSection();
        monitor-enter(r1);
        this.mPlatformPackage = pkg;     // Catch: Throwable -> L15
        this.mAndroidApplication = PackageInfoUtils.generateApplicationInfo(pkg, 0, PackageUserStateInternal.DEFAULT, 0, pkgSetting);     // Catch: Throwable -> L9
        if (this.mResolverReplaced == true) goto L11;
        ActivityInfo r9 = this.mResolveActivity;     // Catch: Throwable -> L9
        r9.applicationInfo = this.mAndroidApplication;     // Catch: Throwable -> L9
        ActivityInfo r10 = this.mResolveActivity;     // Catch: Throwable -> L9
        r10.name = ResolverActivity.class.getName();     // Catch: Throwable -> L9
        ActivityInfo r11 = this.mResolveActivity;     // Catch: Throwable -> L9
        r11.packageName = this.mAndroidApplication.packageName;     // Catch: Throwable -> L9
        this.mResolveActivity.processName = "system:ui";     // Catch: Throwable -> L9
        this.mResolveActivity.launchMode = 0;     // Catch: Throwable -> L9
        this.mResolveActivity.documentLaunchMode = 3;     // Catch: Throwable -> L9
        this.mResolveActivity.flags = 70176;     // Catch: Throwable -> L9
        this.mResolveActivity.theme = R.style.Theme.Material.Dialog.Alert;     // Catch: Throwable -> L9
        this.mResolveActivity.exported = true;     // Catch: Throwable -> L9
        this.mResolveActivity.enabled = true;     // Catch: Throwable -> L9
        this.mResolveActivity.resizeMode = 2;     // Catch: Throwable -> L9
        this.mResolveActivity.configChanges = 3504;     // Catch: Throwable -> L9
        ResolveInfo r12 = this.mResolveInfo;     // Catch: Throwable -> L9
        r12.activityInfo = this.mResolveActivity;     // Catch: Throwable -> L9
        this.mResolveInfo.priority = 0;     // Catch: Throwable -> L9
        this.mResolveInfo.preferredOrder = 0;     // Catch: Throwable -> L9
        this.mResolveInfo.match = 0;     // Catch: Throwable -> L9
        this.mResolveComponentName = new ComponentName(this.mAndroidApplication.packageName, this.mResolveActivity.name);     // Catch: Throwable -> L9
    L11:
        onChanged();     // Catch: Throwable -> L9
        monitor-exit(r1);     // Catch: Throwable -> L9
        resetPriorityAfterPackageManagerTracedLockedSection();
        applyUpdatedSystemOverlayPaths();
        return;
    L15:
        th = move-exception;
        Throwable r13 = th;
    L17:
        monitor-exit(r1);     // Catch: Throwable -> L9
        resetPriorityAfterPackageManagerTracedLockedSection();
        throw r13;
    L9:
        th = move-exception;
        r13 = th;
        goto L17
    }

    ApplicationInfo getCoreAndroidApplication() {
        return this.mAndroidApplication;
    }

    boolean isSystemReady() {
        return this.mSystemReady;
    }

    AndroidPackage getPlatformPackage() {
        return this.mPlatformPackage;
    }

    boolean isPreNMR1Upgrade() {
        return this.mIsPreNMR1Upgrade;
    }

    boolean isOverlayMutable(String packageName) {
        return this.mOverlayConfig.isMutable(packageName);
    }

    int getSystemPackageScanFlags(File codePath) {
        List<ScanPartition> dirsToScanAsSystem = this.mInitAppsHelper.getDirsToScanAsSystem();
        int i = dirsToScanAsSystem.size() - 1;
    L3:
        if (i < 0) goto L14;
        ScanPartition partition = dirsToScanAsSystem.get(i);
        if (partition.containsFile(codePath) == true) goto L6;
        i = i - 1;
        goto L3
    L6:
        int scanFlags = 65536 | partition.scanFlag;
        if (partition.containsPrivApp(codePath) == true) goto L13;
        return scanFlags;
    L13:
        return scanFlags | 131072;
    L14:
        return 65536;
    }

    Pair<Integer, Integer> getSystemPackageRescanFlagsAndReparseFlags(File scanFile, int systemScanFlags, int systemParseFlags) {
        List<ScanPartition> dirsToScanAsSystem = this.mInitAppsHelper.getDirsToScanAsSystem();
        int reparseFlags = 0;
        int rescanFlags = 0;
        int i1 = dirsToScanAsSystem.size() - 1;
    L3:
        if (i1 < 0) goto L12;
        ScanPartition partition = dirsToScanAsSystem.get(i1);
        if (partition.containsPrivApp(scanFile) == true) goto L6;
        if (partition.containsApp(scanFile) == true) goto L9;
        i1 = i1 - 1;
        goto L3
    L9:
        reparseFlags = systemParseFlags;
        rescanFlags = systemScanFlags | partition.scanFlag;
        goto L12
    L6:
        reparseFlags = systemParseFlags;
        rescanFlags = (131072 | systemScanFlags) | partition.scanFlag;
    L12:
        return new Pair(Integer.valueOf(rescanFlags), Integer.valueOf(reparseFlags));
    }

    public PackageStateMutator.InitialState recordInitialState() {
        return this.mPackageStateMutator.initialState(this.mChangedPackagesTracker.getSequenceNumber());
    }

    public PackageStateMutator.Result commitPackageStateMutation(PackageStateMutator.InitialState initialState, Consumer<PackageStateMutator> consumer) {
        PackageManagerTracedLock r0 = this.mPackageStateWriteLock;
        boostPriorityForPackageManagerTracedLockedSection();
        monitor-enter(r0);
        PackageStateMutator.Result result = this.mPackageStateMutator.generateResult(initialState, this.mChangedPackagesTracker.getSequenceNumber());     // Catch: Throwable -> L9
        if (result == PackageStateMutator.Result.SUCCESS) goto L11;
        monitor-exit(r0);     // Catch: Throwable -> L9
        resetPriorityAfterPackageManagerTracedLockedSection();
        return result;
    L11:
        consumer.accept(this.mPackageStateMutator);     // Catch: Throwable -> L9
        this.mPackageStateMutator.onFinished();     // Catch: Throwable -> L9
        monitor-exit(r0);     // Catch: Throwable -> L9
        resetPriorityAfterPackageManagerTracedLockedSection();
        return PackageStateMutator.Result.SUCCESS;
    L9:
        th = move-exception;
        resetPriorityAfterPackageManagerTracedLockedSection();
        throw th;
    }

    public PackageStateMutator.Result commitPackageStateMutation(PackageStateMutator.InitialState initialState, String packageName, Consumer<PackageStateWrite> consumer) {
        PackageStateMutator.Result result = null;
        if (Thread.holdsLock(this.mPackageStateWriteLock) == false) goto L5;
        result = PackageStateMutator.Result.SUCCESS;
    L5:
        PackageManagerTracedLock r1 = this.mPackageStateWriteLock;
        boostPriorityForPackageManagerTracedLockedSection();
        monitor-enter(r1);
        if (result != null) goto L12;
        result = this.mPackageStateMutator.generateResult(initialState, this.mChangedPackagesTracker.getSequenceNumber());     // Catch: Throwable -> L9
    L9:
        th = move-exception;
        resetPriorityAfterPackageManagerTracedLockedSection();
        throw th;
    L12:
        if (result == PackageStateMutator.Result.SUCCESS) goto L16;
        monitor-exit(r1);     // Catch: Throwable -> L9
        resetPriorityAfterPackageManagerTracedLockedSection();
        return result;
    L16:
        PackageStateWrite state = this.mPackageStateMutator.forPackage(packageName);     // Catch: Throwable -> L9
        if (state != null) goto L22;
        PackageStateMutator.Result r3 = PackageStateMutator.Result.SPECIFIC_PACKAGE_NULL;     // Catch: Throwable -> L9
        monitor-exit(r1);     // Catch: Throwable -> L9
        resetPriorityAfterPackageManagerTracedLockedSection();
        return r3;
    L22:
        consumer.accept(state);     // Catch: Throwable -> L9
        state.onChanged();     // Catch: Throwable -> L9
        monitor-exit(r1);     // Catch: Throwable -> L9
        resetPriorityAfterPackageManagerTracedLockedSection();
        return PackageStateMutator.Result.SUCCESS;
    }

    void notifyInstantAppPackageInstalled(String packageName, int[] newUsers) {
        this.mInstantAppRegistry.onPackageInstalled(snapshotComputer(), packageName, newUsers);
    }

    void addInstallerPackageName(InstallSource installSource) {
        PackageManagerTracedLock r0 = this.mLock;
        boostPriorityForPackageManagerTracedLockedSection();
        monitor-enter(r0);
        this.mSettings.addInstallerPackageNames(installSource);     // Catch: Throwable -> L8
        monitor-exit(r0);     // Catch: Throwable -> L8
        resetPriorityAfterPackageManagerTracedLockedSection();
        return;
    L8:
        th = move-exception;
        resetPriorityAfterPackageManagerTracedLockedSection();
        throw th;
    }

    public void reconcileSdkData(String volumeUuid, String packageName, List<String> subDirNames, int userId, int appId, int previousAppId, String seInfo, int flags) throws IOException {
        ReconcileSdkDataArgs args = Installer.buildReconcileSdkDataArgs(volumeUuid, packageName, subDirNames, userId, appId, seInfo, flags);
        args.previousAppId = previousAppId;
        PackageManagerTracedLock installLock = this.mInstallLock.acquireLock();     // Catch: Installer.InstallerException -> L9
        this.mInstaller.reconcileSdkData(args);     // Catch: Throwable -> L13
        if (installLock == null) goto L12;
        installLock.close();     // Catch: Installer.InstallerException -> L9
        return;
    L12:
        return;
    L13:
        th = move-exception;
        if (installLock == null) goto L30;
        installLock.close();     // Catch: Throwable -> L18
    L31:
        throw th;     // Catch: Installer.InstallerException -> L9
    L18:
        th = move-exception;
        th.addSuppressed(th);     // Catch: Installer.InstallerException -> L9
        throw th;     // Catch: Installer.InstallerException -> L9
    L30:
        throw th;     // Catch: Installer.InstallerException -> L9
    L9:
        e = move-exception;
        throw new IOException(e.getMessage());
    }

    void removeCodePath(File codePath) {
        this.mRemovePackageHelper.removeCodePath(codePath);
    }

    void cleanUpResources(String packageName, File codeFile, String[] instructionSets) {
        this.mRemovePackageHelper.cleanUpResources(packageName, codeFile, instructionSets);
    }

    void cleanUpForMoveInstall(String volumeUuid, String packageName, String fromCodePath) {
        this.mRemovePackageHelper.cleanUpForMoveInstall(volumeUuid, packageName, fromCodePath);
    }

    void sendPendingBroadcasts(String reasonForTrace, int callingUidForTrace) {
        this.mInstallPackageHelper.sendPendingBroadcasts(reasonForTrace, callingUidForTrace);
    }

    void handlePackagePostInstall(InstallRequest request, boolean launchedForRestore) {
        this.mInstallPackageHelper.handlePackagePostInstall(request, launchedForRestore);
    }

    Pair<Integer, IntentSender> installExistingPackageAsUser(String packageName, int userId, int installFlags, int installReason, List<String> allowlistedRestrictedPermissions, IntentSender intentSender) {
        return this.mInstallPackageHelper.installExistingPackageAsUser(packageName, userId, installFlags, installReason, allowlistedRestrictedPermissions, intentSender);
    }

    AndroidPackage initPackageTracedLI(File scanFile, int parseFlags, int scanFlags) throws PackageManagerException {
        return this.mInstallPackageHelper.initPackageTracedLI(scanFile, parseFlags, scanFlags);
    }

    void restoreDisabledSystemPackageLIF(DeletePackageAction action, int[] allUserHandles, boolean writeSettings) throws SystemDeleteException {
        this.mInstallPackageHelper.restoreDisabledSystemPackageLIF(action, allUserHandles, writeSettings);
    }

    boolean enableCompressedPackage(AndroidPackage stubPkg, PackageSetting stubPs) {
        return this.mInstallPackageHelper.enableCompressedPackage(stubPkg, stubPs);
    }

    void installPackagesTraced(List<InstallRequest> requests, MoveInfo moveInfo) {
        this.mInstallPackageHelper.installPackagesTraced(requests, moveInfo);
    }

    void restoreAndPostInstall(InstallRequest request) {
        this.mInstallPackageHelper.restoreAndPostInstall(request);
    }

    Pair<Integer, String> verifyReplacingVersionCode(PackageInfoLite pkgLite, long requiredInstalledVersionCode, int installFlags) {
        return this.mInstallPackageHelper.verifyReplacingVersionCode(pkgLite, requiredInstalledVersionCode, installFlags);
    }

    int getUidForVerifier(VerifierInfo verifierInfo) {
        return this.mInstallPackageHelper.getUidForVerifier(verifierInfo);
    }

    int deletePackageX(String packageName, long versionCode, int userId, int deleteFlags, boolean removedBySystem) {
        return this.mDeletePackageHelper.deletePackageX(packageName, -1, 0, 2, true);
    }

    private static boolean isSystemOrPhone(int uid) {
        if (UserHandle.isSameApp(uid, 1000) == false) goto L5;
    L8:
        return true;
    L5:
        if (UserHandle.isSameApp(uid, 1001) == true) goto L8;
        return false;
    }

    public IPackageManagerSmtEx getISmtEx() {
        return this.mPackageManagerServiceSmtEx.getISmtEx();
    }

    public PackageManagerServiceSmtEx getSmtEx() {
        return this.mPackageManagerServiceSmtEx;
    }

    public PackageManagerServiceMonitorEx getMonitorEx() {
        return this.mPackageManagerServiceMonitorEx;
    }

    public IExtPackageManagerService getExt() {
        return this.mExt;
    }

    public IObricPackageManagerService getObricExt() {
        return this.mObricExt;
    }

    public ComponentResolver getComponentResolver() {
        return this.mComponentResolver;
    }
}
