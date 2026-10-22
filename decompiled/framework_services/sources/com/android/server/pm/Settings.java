package com.android.server.pm;

import android.app.compat.ChangeIdStateCache;
import android.app.doppelganger.DoppelgangerConfigure;
import android.content.ComponentName;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.pm.ActivityInfo;
import android.content.pm.IntentFilterVerificationInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManagerInternal;
import android.content.pm.PackagePartitions;
import android.content.pm.PermissionInfo;
import android.content.pm.ResolveInfo;
import android.content.pm.Signature;
import android.content.pm.SuspendDialogInfo;
import android.content.pm.UserInfo;
import android.content.pm.UserPackage;
import android.content.pm.VerifierDeviceIdentity;
import android.content.pm.overlay.OverlayPaths;
import android.net.Uri;
import android.os.Binder;
import android.os.Build;
import android.os.CreateAppDataArgs;
import android.os.FileUtils;
import android.os.Handler;
import android.os.Message;
import android.os.PatternMatcher;
import android.os.PersistableBundle;
import android.os.SELinux;
import android.os.SystemClock;
import android.os.UserHandle;
import android.os.storage.StorageManager;
import android.text.TextUtils;
import android.util.ArrayMap;
import android.util.ArraySet;
import android.util.AtomicFile;
import android.util.IntArray;
import android.util.Log;
import android.util.Pair;
import android.util.Slog;
import android.util.SparseArray;
import android.util.SparseBooleanArray;
import android.util.SparseIntArray;
import android.util.SparseLongArray;
import android.util.Xml;
import android.util.proto.ProtoOutputStream;
import com.android.internal.logging.EventLogTags;
import com.android.internal.os.BackgroundThread;
import com.android.internal.pm.parsing.pkg.AndroidPackageInternal;
import com.android.internal.pm.pkg.component.ParsedComponent;
import com.android.internal.pm.pkg.component.ParsedIntentInfo;
import com.android.internal.pm.pkg.component.ParsedPermission;
import com.android.internal.pm.pkg.component.ParsedProcess;
import com.android.internal.util.ArrayUtils;
import com.android.internal.util.CollectionUtils;
import com.android.internal.util.FrameworkStatsLog;
import com.android.internal.util.IndentingPrintWriter;
import com.android.internal.util.JournaledFile;
import com.android.internal.util.XmlUtils;
import com.android.modules.utils.TypedXmlPullParser;
import com.android.modules.utils.TypedXmlSerializer;
import com.android.permission.persistence.RuntimePermissionsPersistence;
import com.android.permission.persistence.RuntimePermissionsState;
import com.android.server.LocalServices;
import com.android.server.pm.parsing.PackageInfoUtils;
import com.android.server.pm.permission.LegacyPermissionDataProvider;
import com.android.server.pm.permission.LegacyPermissionSettings;
import com.android.server.pm.permission.LegacyPermissionState;
import com.android.server.pm.pkg.AndroidPackage;
import com.android.server.pm.pkg.ArchiveState;
import com.android.server.pm.pkg.PackageStateInternal;
import com.android.server.pm.pkg.PackageUserState;
import com.android.server.pm.pkg.PackageUserStateInternal;
import com.android.server.pm.pkg.SharedUserApi;
import com.android.server.pm.pkg.SuspendParams;
import com.android.server.pm.resolution.ComponentResolver;
import com.android.server.pm.verify.domain.DomainVerificationLegacySettings;
import com.android.server.pm.verify.domain.DomainVerificationManagerInternal;
import com.android.server.pm.verify.domain.DomainVerificationPersistence;
import com.android.server.utils.Slogf;
import com.android.server.utils.Snappable;
import com.android.server.utils.SnapshotCache;
import com.android.server.utils.TimingsTraceAndSlog;
import com.android.server.utils.Watchable;
import com.android.server.utils.WatchableImpl;
import com.android.server.utils.Watched;
import com.android.server.utils.WatchedArrayList;
import com.android.server.utils.WatchedArrayMap;
import com.android.server.utils.WatchedArraySet;
import com.android.server.utils.WatchedSparseArray;
import com.android.server.utils.WatchedSparseIntArray;
import com.android.server.utils.Watcher;
import com.android.server.voiceinteraction.DatabaseHelper;
import dalvik.annotation.optimization.NeverCompile;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.Path;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Random;
import java.util.Set;
import java.util.UUID;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.function.Consumer;
import libcore.io.IoUtils;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
import org.xmlpull.v1.XmlSerializer;

/* JADX INFO: loaded from: classes2.dex */
public final class Settings implements Watchable, Snappable, ResilientAtomicFile.ReadEventLogger {
    private static final String ATTR_APP_LINK_GENERATION = "app-link-generation";
    private static final String ATTR_ARCHIVE_ACTIVITY_TITLE = "activity-title";
    private static final String ATTR_ARCHIVE_ICON_PATH = "icon-path";
    private static final String ATTR_ARCHIVE_INSTALLER_TITLE = "installer-title";
    private static final String ATTR_ARCHIVE_MONOCHROME_ICON_PATH = "monochrome-icon-path";
    private static final String ATTR_ARCHIVE_ORIGINAL_COMPONENT_NAME = "original-component-name";
    private static final String ATTR_ARCHIVE_TIME = "archive-time";
    private static final String ATTR_BLOCKED = "blocked";

    @Deprecated
    private static final String ATTR_BLOCK_UNINSTALL = "blockUninstall";
    private static final String ATTR_BUILD_FINGERPRINT = "buildFingerprint";
    private static final String ATTR_CE_DATA_INODE = "ceDataInode";
    private static final String ATTR_DATABASE_VERSION = "databaseVersion";
    private static final String ATTR_DE_DATA_INODE = "deDataInode";
    private static final String ATTR_DISTRACTION_FLAGS = "distraction_flags";
    private static final String ATTR_DOMAIN_VERIFICATION_STATE = "domainVerificationStatus";
    private static final String ATTR_ENABLED = "enabled";
    private static final String ATTR_ENABLED_CALLER = "enabledCaller";
    private static final String ATTR_ENFORCEMENT = "enforcement";
    private static final String ATTR_FINGERPRINT = "fingerprint";
    private static final String ATTR_FIRST_INSTALL_TIME = "first-install-time";
    private static final String ATTR_FLAGS = "flags";
    private static final String ATTR_GRANTED = "granted";
    private static final String ATTR_HARMFUL_APP_WARNING = "harmful-app-warning";
    private static final String ATTR_HIDDEN = "hidden";
    private static final String ATTR_INSTALLED = "inst";
    private static final String ATTR_INSTALL_REASON = "install-reason";
    private static final String ATTR_INSTANT_APP = "instant-app";
    private static final String ATTR_MIN_ASPECT_RATIO = "min-aspect-ratio";
    public static final String ATTR_NAME = "name";
    private static final String ATTR_NOT_LAUNCHED = "nl";
    private static final String ATTR_OPTIONAL = "optional";
    public static final String ATTR_PACKAGE = "package";
    private static final String ATTR_PACKAGE_NAME = "packageName";
    private static final String ATTR_SDK_VERSION = "sdkVersion";
    private static final String ATTR_SPLASH_SCREEN_THEME = "splash-screen-theme";
    private static final String ATTR_STOPPED = "stopped";
    private static final String ATTR_SUSPENDED = "suspended";
    private static final String ATTR_SUSPENDING_PACKAGE = "suspending-package";
    private static final String ATTR_SUSPENDING_USER = "suspending-user";

    @Deprecated
    private static final String ATTR_SUSPEND_DIALOG_MESSAGE = "suspend_dialog_message";
    private static final String ATTR_UNINSTALL_REASON = "uninstall-reason";
    private static final String ATTR_VALUE = "value";
    private static final String ATTR_VERSION = "version";
    private static final String ATTR_VIRTUAL_PRELOAD = "virtual-preload";
    private static final String ATTR_VOLUME_UUID = "volumeUuid";
    public static final int CURRENT_DATABASE_VERSION = 3;
    private static final boolean DEBUG_KERNEL = false;
    private static final boolean DEBUG_MU = false;
    private static final boolean DEBUG_PARSER = false;
    static final boolean DEBUG_STOPPED = false;
    static final Object[] FLAG_DUMP_SPEC = null;
    private static final int PRE_M_APP_INFO_FLAG_CANT_SAVE_STATE = 268435456;
    private static final int PRE_M_APP_INFO_FLAG_HIDDEN = 134217728;
    private static final int PRE_M_APP_INFO_FLAG_PRIVILEGED = 1073741824;
    private static final Object[] PRIVATE_FLAG_DUMP_SPEC = null;
    private static final String RUNTIME_PERMISSIONS_FILE_NAME = "runtime-permissions.xml";
    private static final String TAG = "PackageSettings";
    public static final String TAG_ALL_INTENT_FILTER_VERIFICATION = "all-intent-filter-verifications";
    private static final String TAG_ARCHIVE_ACTIVITY_INFO = "archive-activity-info";
    private static final String TAG_ARCHIVE_STATE = "archive-state";
    private static final String TAG_BLOCK_UNINSTALL = "block-uninstall";
    private static final String TAG_BLOCK_UNINSTALL_PACKAGES = "block-uninstall-packages";
    private static final String TAG_CHILD_PACKAGE = "child-package";
    static final String TAG_CROSS_PROFILE_INTENT_FILTERS = "crossProfile-intent-filters";
    private static final String TAG_DEFAULT_APPS = "default-apps";
    private static final String TAG_DEFAULT_BROWSER = "default-browser";
    private static final String TAG_DEFAULT_DIALER = "default-dialer";
    private static final String TAG_DISABLED_COMPONENTS = "disabled-components";
    public static final String TAG_DOMAIN_VERIFICATION = "domain-verification";
    private static final String TAG_ENABLED_COMPONENTS = "enabled-components";
    public static final String TAG_ITEM = "item";
    private static final String TAG_MIME_GROUP = "mime-group";
    private static final String TAG_MIME_TYPE = "mime-type";
    protected static final String TAG_PACKAGE = "pkg";
    private static final String TAG_PACKAGE_RESTRICTIONS = "package-restrictions";
    private static final String TAG_PERMISSIONS = "perms";
    private static final String TAG_PERSISTENT_PREFERRED_ACTIVITIES = "persistent-preferred-activities";
    private static final String TAG_READ_EXTERNAL_STORAGE = "read-external-storage";
    private static final String TAG_RUNTIME_PERMISSIONS = "runtime-permissions";
    private static final String TAG_SHARED_USER = "shared-user";
    private static final String TAG_SPLIT_VERSION = "split-version";

    @Deprecated
    private static final String TAG_SUSPENDED_APP_EXTRAS = "suspended-app-extras";

    @Deprecated
    private static final String TAG_SUSPENDED_DIALOG_INFO = "suspended-dialog-info";

    @Deprecated
    private static final String TAG_SUSPENDED_LAUNCHER_EXTRAS = "suspended-launcher-extras";
    private static final String TAG_SUSPEND_PARAMS = "suspend-params";
    private static final String TAG_USES_SDK_LIB = "uses-sdk-lib";
    private static final String TAG_USES_STATIC_LIB = "uses-static-lib";
    private static final String TAG_VERSION = "version";

    @Watched(manual = true)
    private final AppIdSettingMap mAppIds;
    private final File mBackupStoppedPackagesFilename;

    @Watched
    private final WatchedSparseArray<ArraySet<String>> mBlockUninstallPackages;

    @Watched
    private final WatchedSparseArray<CrossProfileIntentResolver> mCrossProfileIntentResolvers;
    private final SnapshotCache<WatchedSparseArray<CrossProfileIntentResolver>> mCrossProfileIntentResolversSnapshot;

    @Watched
    final WatchedArrayMap<String, PackageSetting> mDisabledSysPackages;

    @Watched(manual = true)
    private final DomainVerificationManagerInternal mDomainVerificationManager;
    private final Handler mHandler;

    @Watched
    private final WatchedArraySet<String> mInstallerPackages;
    private final SnapshotCache<WatchedArraySet<String>> mInstallerPackagesSnapshot;

    @Watched
    private final WatchedArrayMap<String, KernelPackageState> mKernelMapping;
    private final File mKernelMappingFilename;
    private final SnapshotCache<WatchedArrayMap<String, KernelPackageState>> mKernelMappingSnapshot;
    private final KeySetManagerService mKeySetManagerService;
    private final PackageManagerTracedLock mLock;

    @Watched
    private final WatchedSparseIntArray mNextAppLinkGeneration;
    private final Watcher mObserver;
    private final File mPackageListFilename;
    private final Object mPackageRestrictionsLock;

    @Watched
    final WatchedArrayMap<String, PackageSetting> mPackages;
    private final SnapshotCache<WatchedArrayMap<String, PackageSetting>> mPackagesSnapshot;
    private final SparseIntArray mPendingAsyncPackageRestrictionsWrites;

    @Watched
    final WatchedSparseArray<String> mPendingDefaultBrowser;

    @Watched
    private final WatchedArrayList<PackageSetting> mPendingPackages;
    private final SnapshotCache<WatchedArrayList<PackageSetting>> mPendingPackagesSnapshot;

    @Watched(manual = true)
    private final LegacyPermissionDataProvider mPermissionDataProvider;

    @Watched(manual = true)
    final LegacyPermissionSettings mPermissions;

    @Watched
    private final WatchedSparseArray<PersistentPreferredIntentResolver> mPersistentPreferredActivities;
    private final SnapshotCache<WatchedSparseArray<PersistentPreferredIntentResolver>> mPersistentPreferredActivitiesSnapshot;

    @Watched
    final WatchedSparseArray<PreferredIntentResolver> mPreferredActivities;
    private final SnapshotCache<WatchedSparseArray<PreferredIntentResolver>> mPreferredActivitiesSnapshot;
    private final File mPreviousSettingsFilename;
    final StringBuilder mReadMessages;

    @Watched
    private final WatchedArrayMap<String, String> mRenamedPackages;

    @Watched(manual = true)
    private final RuntimePermissionPersistence mRuntimePermissionsPersistence;
    private final File mSettingsFilename;
    private final File mSettingsReserveCopyFilename;

    @Watched
    final WatchedArrayMap<String, SharedUserSetting> mSharedUsers;
    private final SettingsSmtEx mSmtEx;
    private final SnapshotCache<Settings> mSnapshot;
    private final File mStoppedPackagesFilename;
    protected final File mSystemDir;

    @Watched(manual = true)
    private VerifierDeviceIdentity mVerifierDeviceIdentity;

    @Watched
    private final WatchedArrayMap<String, VersionInfo> mVersion;
    private final WatchableImpl mWatchable;

    public static class DatabaseVersion {
        public static final int FIRST_VERSION = 1;
        public static final int SIGNATURE_END_ENTITY = 2;
        public static final int SIGNATURE_MALFORMED_RECOVER = 3;

        public DatabaseVersion() {
        }
    }

    private static final class KernelPackageState {
        int appId;
        int[] excludedUserIds;

        /* synthetic */ KernelPackageState(SettingsIA r1) {
            this();
        }

        private KernelPackageState() {
        }
    }

    private static class KeySetToValueMap<K, V> implements Map<K, V> {
        private final Set<K> mKeySet;
        private final V mValue;

        KeySetToValueMap(Set<K> keySet, V value) {
            this.mKeySet = keySet;
            this.mValue = value;
        }

        @Override // java.util.Map
        public int size() {
            return this.mKeySet.size();
        }

        @Override // java.util.Map
        public boolean isEmpty() {
            return this.mKeySet.isEmpty();
        }

        @Override // java.util.Map
        public boolean containsKey(Object key) {
            return this.mKeySet.contains(key);
        }

        @Override // java.util.Map
        public boolean containsValue(Object value) {
            if (this.mValue != value) goto L5;
            return true;
        L5:
            return false;
        }

        @Override // java.util.Map
        public V get(Object key) {
            return this.mValue;
        }

        @Override // java.util.Map
        public V put(K key, V value) {
            throw new UnsupportedOperationException();
        }

        @Override // java.util.Map
        public V remove(Object key) {
            throw new UnsupportedOperationException();
        }

        @Override // java.util.Map
        public void putAll(Map<? extends K, ? extends V> m) {
            throw new UnsupportedOperationException();
        }

        @Override // java.util.Map
        public void clear() {
            throw new UnsupportedOperationException();
        }

        @Override // java.util.Map
        public Set<K> keySet() {
            return this.mKeySet;
        }

        @Override // java.util.Map
        public Collection<V> values() {
            throw new UnsupportedOperationException();
        }

        @Override // java.util.Map
        public Set<Map.Entry<K, V>> entrySet() {
            throw new UnsupportedOperationException();
        }
    }

    private static final class RuntimePermissionPersistence {
        private static final int INITIAL_VERSION = 0;
        private static final long MAX_WRITE_PERMISSIONS_DELAY_MILLIS = 2000;
        private static final int UPGRADE_VERSION = -1;
        private static final double WRITE_PERMISSIONS_DELAY_JITTER = 0.3d;
        private static final long WRITE_PERMISSIONS_DELAY_MILLIS = 1000;
        private static final Random sRandom = null;
        private final Handler mAsyncHandler;
        private String mExtendedFingerprint;
        private final SparseArray<String> mFingerprints;
        private final Consumer<Integer> mInvokeWriteUserStateAsyncCallback;
        private final AtomicBoolean mIsLegacyPermissionStateStale;
        private final SparseLongArray mLastNotWrittenMutationTimesMillis;
        private final Object mLock;
        private final SparseArray<RuntimePermissionsState> mPendingStatesToWrite;
        private final SparseBooleanArray mPermissionUpgradeNeeded;
        private final RuntimePermissionsPersistence mPersistence;
        private final Handler mPersistenceHandler;
        private final Object mPersistenceLock;
        private final SparseIntArray mVersions;
        private final SparseBooleanArray mWriteScheduled;

        private final class MyHandler extends Handler {
            final /* synthetic */ RuntimePermissionPersistence this$0;

            public MyHandler(RuntimePermissionPersistence r1) {
                this.this$0 = r1;
                super(BackgroundThread.getHandler().getLooper());
            }

            @Override // android.os.Handler
            public void handleMessage(Message message) {
                int userId = message.what;
                Runnable callback = (Runnable) message.obj;
                RuntimePermissionPersistence.m6894$$Nest$fgetmInvokeWriteUserStateAsyncCallback(this.this$0).accept(Integer.valueOf(userId));
                if (callback == null) goto L6;
                callback.run();
                return;
            }
        }

        private final class PersistenceHandler extends Handler {
            final /* synthetic */ RuntimePermissionPersistence this$0;

            PersistenceHandler(RuntimePermissionPersistence r1) {
                this.this$0 = r1;
                super(BackgroundThread.getHandler().getLooper());
            }

            @Override // android.os.Handler
            public void handleMessage(Message message) {
                RuntimePermissionPersistence.m6896$$Nest$mwritePendingStates(this.this$0);
            }
        }

        public static /* synthetic */ void $r8$lambda$jSdj7sarDYdqZlpU1yKlMrhFaeI(RuntimePermissionPersistence r0, PackageManagerTracedLock r1, boolean r2, LegacyPermissionDataProvider r3, int r4, WatchedArrayMap r5, WatchedArrayMap r6, Handler r7) {
            r0.lambda$writeStateForUser$0(r1, r2, r3, r4, r5, r6, r7);
        }

        /* JADX INFO: renamed from: -$$Nest$fgetmInvokeWriteUserStateAsyncCallback, reason: not valid java name */
        static /* bridge */ /* synthetic */ Consumer m6894$$Nest$fgetmInvokeWriteUserStateAsyncCallback(RuntimePermissionPersistence r0) {
            return r0.mInvokeWriteUserStateAsyncCallback;
        }

        /* JADX INFO: renamed from: -$$Nest$monUserRemoved, reason: not valid java name */
        static /* bridge */ /* synthetic */ void m6895$$Nest$monUserRemoved(RuntimePermissionPersistence r0, int r1) {
            r0.onUserRemoved(r1);
        }

        /* JADX INFO: renamed from: -$$Nest$mwritePendingStates, reason: not valid java name */
        static /* bridge */ /* synthetic */ void m6896$$Nest$mwritePendingStates(RuntimePermissionPersistence r0) {
            r0.writePendingStates();
        }

        static {
            sRandom = new Random();
        }

        public RuntimePermissionPersistence(RuntimePermissionsPersistence persistence, Consumer<Integer> invokeWriteUserStateAsyncCallback) {
            this.mPersistenceLock = new Object();
            this.mAsyncHandler = new MyHandler(this);
            this.mPersistenceHandler = new PersistenceHandler(this);
            this.mLock = new Object();
            this.mWriteScheduled = new SparseBooleanArray();
            this.mLastNotWrittenMutationTimesMillis = new SparseLongArray();
            this.mIsLegacyPermissionStateStale = new AtomicBoolean(false);
            this.mVersions = new SparseIntArray();
            this.mFingerprints = new SparseArray();
            this.mPermissionUpgradeNeeded = new SparseBooleanArray();
            this.mPendingStatesToWrite = new SparseArray();
            this.mPersistence = persistence;
            this.mInvokeWriteUserStateAsyncCallback = invokeWriteUserStateAsyncCallback;
        }

        int getVersion(int userId) {
            Object r0 = this.mLock;
            monitor-enter(r0);
            int r1 = this.mVersions.get(userId, 0);     // Catch: Throwable -> L7
            monitor-exit(r0);     // Catch: Throwable -> L7
            return r1;
        L7:
            th = move-exception;
            throw th;
        }

        void setVersion(int version, int userId) {
            Object r0 = this.mLock;
            monitor-enter(r0);
            this.mVersions.put(userId, version);     // Catch: Throwable -> L7
            writeStateForUserAsync(userId);     // Catch: Throwable -> L7
            monitor-exit(r0);     // Catch: Throwable -> L7
            return;
        L7:
            th = move-exception;
            throw th;
        }

        public boolean isPermissionUpgradeNeeded(int userId) {
            Object r0 = this.mLock;
            monitor-enter(r0);
            boolean r1 = this.mPermissionUpgradeNeeded.get(userId, true);     // Catch: Throwable -> L7
            monitor-exit(r0);     // Catch: Throwable -> L7
            return r1;
        L7:
            th = move-exception;
            throw th;
        }

        public void updateRuntimePermissionsFingerprint(int userId) {
            Object r0 = this.mLock;
            monitor-enter(r0);
        L9:
            th = move-exception;
            throw th;
        L5:
            if (this.mExtendedFingerprint == null) goto L12;
            this.mFingerprints.put(userId, this.mExtendedFingerprint);     // Catch: Throwable -> L9
            this.mPermissionUpgradeNeeded.put(userId, false);     // Catch: Throwable -> L9
            writeStateForUserAsync(userId);     // Catch: Throwable -> L9
            monitor-exit(r0);     // Catch: Throwable -> L9
            return;
        L12:
            throw new RuntimeException("The version of the permission controller hasn't been set before trying to update the fingerprint.");     // Catch: Throwable -> L9
        }

        public void setPermissionControllerVersion(long version) {
            Object r0 = this.mLock;
            monitor-enter(r0);
            int numUser = this.mFingerprints.size();     // Catch: Throwable -> L11
            this.mExtendedFingerprint = getExtendedFingerprint(version);     // Catch: Throwable -> L11
            int i = 0;
        L5:
            if (i >= numUser) goto L14;
            int userId = this.mFingerprints.keyAt(i);     // Catch: Throwable -> L11
            String fingerprint = this.mFingerprints.valueAt(i);     // Catch: Throwable -> L11
            SparseBooleanArray r5 = this.mPermissionUpgradeNeeded;     // Catch: Throwable -> L11
            if (TextUtils.equals(this.mExtendedFingerprint, fingerprint) == true) goto L9;
            boolean r6 = true;
        L10:
            r5.put(userId, r6);     // Catch: Throwable -> L11
            i = i + 1;     // Catch: Throwable -> L11
            goto L5
        L9:
            r6 = false;
            goto L10
        L14:
            monitor-exit(r0);     // Catch: Throwable -> L11
            return;
        L11:
            th = move-exception;
            throw th;
        }

        private String getExtendedFingerprint(long version) {
            return PackagePartitions.FINGERPRINT + "?pc_version=" + version;
        }

        private static long uniformRandom(double low, double high) {
            double mag = high - low;
            return (long) ((sRandom.nextDouble() * mag) + low);
        }

        private static long nextWritePermissionDelayMillis() {
            return uniformRandom(-300.0d, 300.0d) + 1000;
        }

        public void writeStateForUserAsync(int userId) {
            this.mIsLegacyPermissionStateStale.set(true);
            Object r4 = this.mLock;
            monitor-enter(r4);
            long currentTimeMillis = SystemClock.uptimeMillis();     // Catch: Throwable -> L11
            long writePermissionDelayMillis = nextWritePermissionDelayMillis();     // Catch: Throwable -> L11
            if (this.mWriteScheduled.get(userId) == false) goto L17;
            this.mAsyncHandler.removeMessages(userId);     // Catch: Throwable -> L11
            long lastNotWrittenMutationTimeMillis = this.mLastNotWrittenMutationTimesMillis.get(userId);     // Catch: Throwable -> L11
            long timeSinceLastNotWrittenMutationMillis = currentTimeMillis - lastNotWrittenMutationTimeMillis;     // Catch: Throwable -> L11
            if (timeSinceLastNotWrittenMutationMillis < 2000) goto L14;
            this.mAsyncHandler.obtainMessage(userId).sendToTarget();     // Catch: Throwable -> L11
            monitor-exit(r4);     // Catch: Throwable -> L11
            return;
        L14:
            long maxDelayMillis = Math.max((2000 + lastNotWrittenMutationTimeMillis) - currentTimeMillis, 0);     // Catch: Throwable -> L15
            long writeDelayMillis = Math.min(writePermissionDelayMillis, maxDelayMillis);     // Catch: Throwable -> L15
            Message message = this.mAsyncHandler.obtainMessage(userId);     // Catch: Throwable -> L15
            this.mAsyncHandler.sendMessageDelayed(message, writeDelayMillis);     // Catch: Throwable -> L15
        L18:
            monitor-exit(r4);     // Catch: Throwable -> L15
            return;
        L17:
            this.mLastNotWrittenMutationTimesMillis.put(userId, currentTimeMillis);     // Catch: Throwable -> L15
            Message message2 = this.mAsyncHandler.obtainMessage(userId);     // Catch: Throwable -> L15
            this.mAsyncHandler.sendMessageDelayed(message2, writePermissionDelayMillis);     // Catch: Throwable -> L15
            this.mWriteScheduled.put(userId, true);     // Catch: Throwable -> L15
        L15:
            th = th;
        L20:
            monitor-exit(r4);     // Catch: Throwable -> L15
            throw th;
        L11:
            th = th;
            goto L20
        }

        public void writeStateForUser(final int userId, final LegacyPermissionDataProvider legacyPermissionDataProvider, final WatchedArrayMap<String, ? extends PackageStateInternal> packageStates, final WatchedArrayMap<String, SharedUserSetting> sharedUsers, final Handler pmHandler, final PackageManagerTracedLock pmLock, final boolean sync) {
            Object r2 = this.mLock;
            monitor-enter(r2);
            this.mAsyncHandler.removeMessages(userId);     // Catch: Throwable -> L11
            this.mWriteScheduled.delete(userId);     // Catch: Throwable -> L11
            monitor-exit(r2);     // Catch: Throwable -> L11
            Runnable writer = new Settings$RuntimePermissionPersistence$$ExternalSyntheticLambda0(this, pmLock, sync, legacyPermissionDataProvider, userId, packageStates, sharedUsers, pmHandler);
            if (pmHandler == null) goto L9;
            pmHandler.post(writer);
            return;
        L9:
            writer.run();
            return;
        L11:
            th = move-exception;
            throw th;
        }

        private /* synthetic */ void lambda$writeStateForUser$0(PackageManagerTracedLock pmLock, boolean sync, LegacyPermissionDataProvider legacyPermissionDataProvider, int userId, WatchedArrayMap packageStates, WatchedArrayMap sharedUsers, Handler pmHandler) {
            boolean isLegacyPermissionStateStale = this.mIsLegacyPermissionStateStale.getAndSet(false);
            PackageManagerService.boostPriorityForPackageManagerTracedLockedSection();
            monitor-enter(pmLock);
            if (sync == true) goto L26;
            if (isLegacyPermissionStateStale == true) goto L26;
        L7:
            Map<String, List<RuntimePermissionsState.PermissionState>> packagePermissions = getPackagePermissions(userId, packageStates);     // Catch: Throwable -> L20
            Map<String, List<RuntimePermissionsState.PermissionState>> sharedUserPermissions = getShareUsersPermissions(userId, sharedUsers);     // Catch: Throwable -> L20
            monitor-exit(pmLock);     // Catch: Throwable -> L20
            PackageManagerService.resetPriorityAfterPackageManagerTracedLockedSection();
            Object r4 = this.mLock;
            monitor-enter(r4);
            int version = this.mVersions.get(userId, 0);     // Catch: Throwable -> L17
            String fingerprint = this.mFingerprints.get(userId);     // Catch: Throwable -> L17
            RuntimePermissionsState runtimePermissions = new RuntimePermissionsState(version, fingerprint, packagePermissions, sharedUserPermissions);     // Catch: Throwable -> L17
            this.mPendingStatesToWrite.put(userId, runtimePermissions);     // Catch: Throwable -> L17
            monitor-exit(r4);     // Catch: Throwable -> L17
            if (pmHandler == null) goto L15;
            this.mPersistenceHandler.obtainMessage(userId).sendToTarget();
            return;
        L15:
            writePendingStates();
            return;
        L17:
            th = move-exception;
            throw th;
        L20:
            th = move-exception;
            PackageManagerService.resetPriorityAfterPackageManagerTracedLockedSection();
            throw th;
        L26:
            legacyPermissionDataProvider.writeLegacyPermissionStateTEMP();     // Catch: Throwable -> L20
            goto L7
        }

        RuntimePermissionsState getLegacyPermissionsState(int userId, WatchedArrayMap<String, ? extends PackageStateInternal> packageStates, WatchedArrayMap<String, SharedUserSetting> sharedUsers) {
            Object r0 = this.mLock;
            monitor-enter(r0);
            int version = this.mVersions.get(userId, 0);     // Catch: Throwable -> L8
            String fingerprint = this.mFingerprints.get(userId);     // Catch: Throwable -> L8
            monitor-exit(r0);     // Catch: Throwable -> L8
            return new RuntimePermissionsState(version, fingerprint, getPackagePermissions(userId, packageStates), getShareUsersPermissions(userId, sharedUsers));
        L8:
            th = move-exception;
            throw th;
        }

        private Map<String, List<RuntimePermissionsState.PermissionState>> getPackagePermissions(int userId, WatchedArrayMap<String, ? extends PackageStateInternal> packageStates) {
            Map<String, List<RuntimePermissionsState.PermissionState>> packagePermissions = new ArrayMap();
            int packagesSize = packageStates.size();
            int i = 0;
        L3:
            if (i >= packagesSize) goto L14;
            String packageName = packageStates.keyAt(i);
            PackageStateInternal packageState = packageStates.valueAt(i);
            if (packageState.hasSharedUser() == true) goto L12;
            List<RuntimePermissionsState.PermissionState> permissions = getPermissionsFromPermissionsState(packageState.getLegacyPermissionState(), userId);
            if (permissions.isEmpty() == true) goto L9;
        L11:
            packagePermissions.put(packageName, permissions);
            goto L12
        L9:
            if (packageState.isInstallPermissionsFixed() == true) goto L11;
        L12:
            i = i + 1;
            goto L3
        L14:
            return packagePermissions;
        }

        private Map<String, List<RuntimePermissionsState.PermissionState>> getShareUsersPermissions(int userId, WatchedArrayMap<String, SharedUserSetting> sharedUsers) {
            Map<String, List<RuntimePermissionsState.PermissionState>> sharedUserPermissions = new ArrayMap();
            int sharedUsersSize = sharedUsers.size();
            int i = 0;
        L3:
            if (i >= sharedUsersSize) goto L6;
            String sharedUserName = sharedUsers.keyAt(i);
            SharedUserSetting sharedUserSetting = sharedUsers.valueAt(i);
            List<RuntimePermissionsState.PermissionState> permissions = getPermissionsFromPermissionsState(sharedUserSetting.getLegacyPermissionState(), userId);
            sharedUserPermissions.put(sharedUserName, permissions);
            i = i + 1;
            goto L3
        L6:
            return sharedUserPermissions;
        }

        private void writePendingStates() {
        L2:
            Object r0 = this.mLock;
            monitor-enter(r0);
        L8:
            th = move-exception;
            throw th;
        L5:
            if (this.mPendingStatesToWrite.size() == 0) goto L6;
            int userId = this.mPendingStatesToWrite.keyAt(0);     // Catch: Throwable -> L8
            RuntimePermissionsState runtimePermissions = this.mPendingStatesToWrite.valueAt(0);     // Catch: Throwable -> L8
            this.mPendingStatesToWrite.removeAt(0);     // Catch: Throwable -> L8
            monitor-exit(r0);     // Catch: Throwable -> L8
            Object r2 = this.mPersistenceLock;
            monitor-enter(r2);
            this.mPersistence.writeForUser(runtimePermissions, UserHandle.of(userId));     // Catch: Throwable -> L17
            monitor-exit(r2);     // Catch: Throwable -> L17
        L17:
            th = move-exception;
            throw th;
        L6:
            monitor-exit(r0);     // Catch: Throwable -> L8
        }

        private List<RuntimePermissionsState.PermissionState> getPermissionsFromPermissionsState(LegacyPermissionState permissionsState, int userId) {
            Collection<LegacyPermissionState.PermissionState> permissionStates = permissionsState.getPermissionStates(userId);
            List<RuntimePermissionsState.PermissionState> permissions = new ArrayList();
            Iterator<LegacyPermissionState.PermissionState> r2 = permissionStates.iterator();
        L4:
            if (r2.hasNext() == false) goto L6;
            LegacyPermissionState.PermissionState permissionState = r2.next();
            RuntimePermissionsState.PermissionState permission = new RuntimePermissionsState.PermissionState(permissionState.getName(), permissionState.isGranted(), permissionState.getFlags());
            permissions.add(permission);
            goto L4
        L6:
            return permissions;
        }

        private void onUserRemoved(int userId) {
            Object r0 = this.mLock;
            monitor-enter(r0);
            this.mAsyncHandler.removeMessages(userId);     // Catch: Throwable -> L7
            this.mPermissionUpgradeNeeded.delete(userId);     // Catch: Throwable -> L7
            this.mVersions.delete(userId);     // Catch: Throwable -> L7
            this.mFingerprints.remove(userId);     // Catch: Throwable -> L7
            monitor-exit(r0);     // Catch: Throwable -> L7
            return;
        L7:
            th = move-exception;
            throw th;
        }

        public void deleteUserRuntimePermissionsFile(int userId) {
            Object r0 = this.mPersistenceLock;
            monitor-enter(r0);
            this.mPersistence.deleteForUser(UserHandle.of(userId));     // Catch: Throwable -> L7
            monitor-exit(r0);     // Catch: Throwable -> L7
            return;
        L7:
            th = move-exception;
            throw th;
        }

        public void readStateForUserSync(int userId, VersionInfo internalVersion, WatchedArrayMap<String, PackageSetting> packageSettings, WatchedArrayMap<String, SharedUserSetting> sharedUsers, File userRuntimePermissionsFile) {
            RuntimePermissionPersistence r1 = this;
            WatchedArrayMap<String, PackageSetting> r3 = packageSettings;
            Object r5 = r1.mPersistenceLock;
            monitor-enter(r5);
            RuntimePermissionsState runtimePermissions = r1.mPersistence.readForUser(UserHandle.of(userId));     // Catch: Throwable -> L50
            monitor-exit(r5);     // Catch: Throwable -> L50
            if (runtimePermissions != null) goto L9;
            r1.readLegacyStateForUserSync(userId, userRuntimePermissionsFile, r3, sharedUsers);
            writeStateForUserAsync(userId);
            return;
        L9:
            Object r8 = r1.mLock;
            monitor-enter(r8);
            int version = runtimePermissions.getVersion();     // Catch: Throwable -> L46
            if (version != (-1)) goto L14;
            version = -1;
        L14:
            r1.mVersions.put(userId, version);     // Catch: Throwable -> L46
            String fingerprint = runtimePermissions.getFingerprint();     // Catch: Throwable -> L46
            r1.mFingerprints.put(userId, fingerprint);     // Catch: Throwable -> L46
            if (internalVersion.sdkVersion >= 30) goto L19;
            boolean isUpgradeToR = true;
        L20:
            Map<String, List<RuntimePermissionsState.PermissionState>> packagePermissions = runtimePermissions.getPackagePermissions();     // Catch: Throwable -> L25
            int packagesSize = r3.size();     // Catch: Throwable -> L25
            int i = 0;
        L21:
            if (i >= packagesSize) goto L33;
            String packageName = r3.keyAt(i);     // Catch: Throwable -> L25
            PackageSetting packageSetting = r3.valueAt(i);     // Catch: Throwable -> L25
            List<RuntimePermissionsState.PermissionState> permissions = packagePermissions.get(packageName);     // Catch: Throwable -> L25
            if (permissions == null) goto L27;
            int version2 = version;
            r1.readPermissionsState(permissions, packageSetting.getLegacyPermissionState(), userId);     // Catch: Throwable -> L25
            packageSetting.setInstallPermissionsFixed(true);     // Catch: Throwable -> L25
        L32:
            i = i + 1;     // Catch: Throwable -> L25
            r3 = packageSettings;
            version = version2;
            goto L21
        L27:
            version2 = version;
            if (packageSetting.hasSharedUser() == true) goto L32;
            if (isUpgradeToR == true) goto L32;
            Slogf.w(Settings.TAG, "Missing permission state for package %s on user %d", new Object[]{packageName, Integer.valueOf(userId)});     // Catch: Throwable -> L25
            packageSetting.getLegacyPermissionState().setMissing(true, userId);     // Catch: Throwable -> L25
            goto L32
        L33:
            Map<String, List<RuntimePermissionsState.PermissionState>> sharedUserPermissions = runtimePermissions.getSharedUserPermissions();     // Catch: Throwable -> L25
            int sharedUsersSize = sharedUsers.size();     // Catch: Throwable -> L25
            int i2 = 0;
        L34:
            if (i2 >= sharedUsersSize) goto L44;
            String sharedUserName = sharedUsers.keyAt(i2);     // Catch: Throwable -> L25
            SharedUserSetting sharedUserSetting = sharedUsers.valueAt(i2);     // Catch: Throwable -> L25
            List<RuntimePermissionsState.PermissionState> permissions2 = sharedUserPermissions.get(sharedUserName);     // Catch: Throwable -> L25
            if (permissions2 == null) goto L38;
            Map<String, List<RuntimePermissionsState.PermissionState>> sharedUserPermissions2 = sharedUserPermissions;
            int sharedUsersSize2 = sharedUsersSize;
            r1.readPermissionsState(permissions2, sharedUserSetting.getLegacyPermissionState(), userId);     // Catch: Throwable -> L25
        L42:
            i2 = i2 + 1;     // Catch: Throwable -> L25
            r1 = this;
            sharedUserPermissions = sharedUserPermissions2;
            sharedUsersSize = sharedUsersSize2;
            goto L34
        L38:
            sharedUserPermissions2 = sharedUserPermissions;
            sharedUsersSize2 = sharedUsersSize;
            if (isUpgradeToR == true) goto L42;
            Slog.w(Settings.TAG, "Missing permission state for shared user: " + sharedUserName);     // Catch: Throwable -> L25
            sharedUserSetting.getLegacyPermissionState().setMissing(true, userId);     // Catch: Throwable -> L25
            goto L42
        L44:
            monitor-exit(r8);     // Catch: Throwable -> L25
            return;
        L19:
            isUpgradeToR = false;
        L25:
            th = th;
        L48:
            monitor-exit(r8);     // Catch: Throwable -> L25
            throw th;
        L46:
            th = th;
        L50:
            th = th;
        L56:
            throw th;
        L54:
            th = th;
            goto L56
        }

        private void readPermissionsState(List<RuntimePermissionsState.PermissionState> permissions, LegacyPermissionState permissionsState, int userId) {
            int permissionsSize = permissions.size();
            int i = 0;
        L3:
            if (i >= permissionsSize) goto L6;
            RuntimePermissionsState.PermissionState permission = permissions.get(i);
            String name = permission.getName();
            boolean granted = permission.isGranted();
            int flags = permission.getFlags();
            permissionsState.putPermissionState(new LegacyPermissionState.PermissionState(name, true, granted, flags), userId);
            i = i + 1;
            goto L3
        }

        private void readLegacyStateForUserSync(int userId, File permissionsFile, WatchedArrayMap<String, ? extends PackageStateInternal> packageStates, WatchedArrayMap<String, SharedUserSetting> sharedUsers) {
            Object r0 = this.mLock;
            monitor-enter(r0);
        L8:
            th = move-exception;
            throw th;
        L5:
            if (permissionsFile.exists() == true) goto L29;
            monitor-exit(r0);     // Catch: Throwable -> L8
            return;
        L29:
            FileInputStream in = new AtomicFile(permissionsFile).openRead();     // Catch: Throwable -> L8 FileNotFoundException -> L22
            TypedXmlPullParser parser = Xml.resolvePullParser(in);     // Catch: Throwable -> L15 Throwable -> L17
            parseLegacyRuntimePermissions(parser, userId, packageStates, sharedUsers);     // Catch: Throwable -> L15 Throwable -> L17
            IoUtils.closeQuietly(in);     // Catch: Throwable -> L8
            monitor-exit(r0);     // Catch: Throwable -> L8
            return;
        L15:
            th = move-exception;
            IoUtils.closeQuietly(in);     // Catch: Throwable -> L8
            throw th;     // Catch: Throwable -> L8
        L17:
            e = move-exception;
            throw new IllegalStateException("Failed parsing permissions file: " + permissionsFile, e);     // Catch: Throwable -> L15
        L23:
            Slog.i(PackageManagerServiceMonitorEx.TAG, "No permissions state");     // Catch: Throwable -> L8
        }

        private void parseLegacyRuntimePermissions(TypedXmlPullParser parser, int userId, WatchedArrayMap<String, ? extends PackageStateInternal> packageStates, WatchedArrayMap<String, SharedUserSetting> sharedUsers) throws IOException, XmlPullParserException {
            Object r0 = this.mLock;
            monitor-enter(r0);
            int outerDepth = parser.getDepth();     // Catch: Throwable -> L12
        L5:
            int type = parser.next();     // Catch: Throwable -> L12
            byte r4 = 1;
            if (type == 1) goto L48;
            if (type == 3) goto L10;
        L15:
            if (type == 3) goto L5;
            if (type == 4) goto L5;
            String packageTagName = parser.getName();     // Catch: Throwable -> L12
            if (packageTagName == null) goto L5;
            switch(packageTagName.hashCode()) {
                case 111052: goto L32;
                case 160289295: goto L29;
                case 485578803: goto L26;
                default: goto L34;
            };     // Catch: Throwable -> L12
        L34:
            r4 = -1;
        L36:
            switch(r4) {
                case 0: goto L46;
                case 1: goto L42;
                case 2: goto L38;
                default: goto L5;
            };     // Catch: Throwable -> L12
        L42:
            String name = parser.getAttributeValue(null, "name");     // Catch: Throwable -> L12
            PackageStateInternal ps = packageStates.get(name);     // Catch: Throwable -> L12
            if (ps != null) goto L45;
            Slog.w(PackageManagerServiceMonitorEx.TAG, "Unknown package:" + name);     // Catch: Throwable -> L12
            XmlUtils.skipCurrentTag(parser);     // Catch: Throwable -> L12
            goto L5
        L45:
            parseLegacyPermissionsLPr(parser, ps.getLegacyPermissionState(), userId);     // Catch: Throwable -> L12
            goto L5
        L46:
            int version = parser.getAttributeInt(null, "version", -1);     // Catch: Throwable -> L12
            this.mVersions.put(userId, version);     // Catch: Throwable -> L12
            String fingerprint = parser.getAttributeValue(null, Settings.ATTR_FINGERPRINT);     // Catch: Throwable -> L12
            this.mFingerprints.put(userId, fingerprint);     // Catch: Throwable -> L12
            goto L5
        L38:
            String name2 = parser.getAttributeValue(null, "name");     // Catch: Throwable -> L12
            SharedUserSetting sus = sharedUsers.get(name2);     // Catch: Throwable -> L12
            if (sus != null) goto L41;
            Slog.w(PackageManagerServiceMonitorEx.TAG, "Unknown shared user:" + name2);     // Catch: Throwable -> L12
            XmlUtils.skipCurrentTag(parser);     // Catch: Throwable -> L12
            goto L5
        L41:
            parseLegacyPermissionsLPr(parser, sus.getLegacyPermissionState(), userId);     // Catch: Throwable -> L12
            goto L5
        L26:
            if (packageTagName.equals(Settings.TAG_SHARED_USER) == false) goto L34;
            r4 = 2;
            goto L36
        L29:
            if (packageTagName.equals(Settings.TAG_RUNTIME_PERMISSIONS) == false) goto L34;
            r4 = 0;
            goto L36
        L32:
            if (packageTagName.equals("pkg") == false) goto L34;
        L10:
            if (parser.getDepth() > outerDepth) goto L15;
        L48:
            monitor-exit(r0);     // Catch: Throwable -> L12
            return;
        L12:
            th = move-exception;
            throw th;
        }

        private void parseLegacyPermissionsLPr(TypedXmlPullParser parser, LegacyPermissionState permissionsState, int userId) throws IOException, XmlPullParserException {
            Object r0 = this.mLock;
            monitor-enter(r0);
            int outerDepth = parser.getDepth();     // Catch: Throwable -> L12
        L5:
            int type = parser.next();     // Catch: Throwable -> L12
            if (type == 1) goto L33;
            if (type == 3) goto L10;
        L15:
            if (type == 3) goto L5;
            if (type == 4) goto L5;
            String packageTagName = parser.getName();     // Catch: Throwable -> L12
            if (packageTagName == null) goto L5;
            switch(packageTagName.hashCode()) {
                case 3242771: goto L26;
                default: goto L28;
            };     // Catch: Throwable -> L12
        L28:
            byte r5 = -1;
        L29:
            switch(r5) {
                case 0: goto L31;
                default: goto L5;
            };     // Catch: Throwable -> L12
        L31:
            String name = parser.getAttributeValue(null, "name");     // Catch: Throwable -> L12
            boolean granted = parser.getAttributeBoolean(null, Settings.ATTR_GRANTED, true);     // Catch: Throwable -> L12
            int flags = parser.getAttributeIntHex(null, Settings.ATTR_FLAGS, 0);     // Catch: Throwable -> L12
            permissionsState.putPermissionState(new LegacyPermissionState.PermissionState(name, true, granted, flags), userId);     // Catch: Throwable -> L12
            goto L5
        L26:
            if (packageTagName.equals(Settings.TAG_ITEM) == false) goto L28;
            r5 = 0;
            goto L29
        L10:
            if (parser.getDepth() > outerDepth) goto L15;
        L33:
            monitor-exit(r0);     // Catch: Throwable -> L12
            return;
        L12:
            th = move-exception;
            throw th;
        }
    }

    public static class VersionInfo {
        String buildFingerprint;
        int databaseVersion;
        String fingerprint;
        int sdkVersion;

        public VersionInfo() {
        }

        public void forceCurrent() {
            this.sdkVersion = Build.VERSION.SDK_INT;
            this.databaseVersion = 3;
            this.buildFingerprint = Build.FINGERPRINT;
            this.fingerprint = PackagePartitions.FINGERPRINT;
        }
    }

    public static /* synthetic */ void $r8$lambda$53NmgrwLNm2y5xSEATqhfDNuHBU(Settings r0, SharedUserSetting r1) {
        r0.lambda$pruneSharedUsersLPw$0(r1);
    }

    public static /* synthetic */ void $r8$lambda$xF8vBosZYCuleRIdy4wr1C_PPCw(Settings r0, int r1, long r2, boolean r4) {
        r0.lambda$writePackageRestrictionsLPr$1(r1, r2, r4);
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmHandler, reason: not valid java name */
    static /* bridge */ /* synthetic */ Handler m6889$$Nest$fgetmHandler(Settings r0) {
        return r0.mHandler;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmLock, reason: not valid java name */
    static /* bridge */ /* synthetic */ PackageManagerTracedLock m6890$$Nest$fgetmLock(Settings r0) {
        return r0.mLock;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmPermissionDataProvider, reason: not valid java name */
    static /* bridge */ /* synthetic */ LegacyPermissionDataProvider m6891$$Nest$fgetmPermissionDataProvider(Settings r0) {
        return r0.mPermissionDataProvider;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmRuntimePermissionsPersistence, reason: not valid java name */
    static /* bridge */ /* synthetic */ RuntimePermissionPersistence m6892$$Nest$fgetmRuntimePermissionsPersistence(Settings r0) {
        return r0.mRuntimePermissionsPersistence;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmWatchable, reason: not valid java name */
    static /* bridge */ /* synthetic */ WatchableImpl m6893$$Nest$fgetmWatchable(Settings r0) {
        return r0.mWatchable;
    }

    /* synthetic */ Settings(Settings r1, SettingsIA r2) {
        this(r1);
    }

    @Override // com.android.server.utils.Snappable
    public /* bridge */ /* synthetic */ Object snapshot() {
        return snapshot();
    }

    @Override // com.android.server.utils.Watchable
    public void registerObserver(Watcher observer) {
        this.mWatchable.registerObserver(observer);
    }

    @Override // com.android.server.utils.Watchable
    public void unregisterObserver(Watcher observer) {
        this.mWatchable.unregisterObserver(observer);
    }

    @Override // com.android.server.utils.Watchable
    public boolean isRegisteredObserver(Watcher observer) {
        return this.mWatchable.isRegisteredObserver(observer);
    }

    @Override // com.android.server.utils.Watchable
    public void dispatchChange(Watchable what) {
        this.mWatchable.dispatchChange(what);
    }

    protected void onChanged() {
        dispatchChange(this);
    }

    private SnapshotCache<Settings> makeCache() {
        return new AnonymousClass2(this, this, this);
    }

    private void registerObservers() {
        this.mPackages.registerObserver(this.mObserver);
        this.mInstallerPackages.registerObserver(this.mObserver);
        this.mKernelMapping.registerObserver(this.mObserver);
        this.mDisabledSysPackages.registerObserver(this.mObserver);
        this.mBlockUninstallPackages.registerObserver(this.mObserver);
        this.mVersion.registerObserver(this.mObserver);
        this.mPreferredActivities.registerObserver(this.mObserver);
        this.mPersistentPreferredActivities.registerObserver(this.mObserver);
        this.mCrossProfileIntentResolvers.registerObserver(this.mObserver);
        this.mSharedUsers.registerObserver(this.mObserver);
        this.mAppIds.registerObserver(this.mObserver);
        this.mRenamedPackages.registerObserver(this.mObserver);
        this.mNextAppLinkGeneration.registerObserver(this.mObserver);
        this.mPendingDefaultBrowser.registerObserver(this.mObserver);
        this.mPendingPackages.registerObserver(this.mObserver);
    }

    public Settings(Map<String, PackageSetting> pkgSettings) {
        this.mWatchable = new WatchableImpl();
        this.mPackageRestrictionsLock = new Object();
        this.mPendingAsyncPackageRestrictionsWrites = new SparseIntArray();
        this.mDisabledSysPackages = new WatchedArrayMap();
        this.mBlockUninstallPackages = new WatchedSparseArray();
        this.mVersion = new WatchedArrayMap();
        this.mSharedUsers = new WatchedArrayMap();
        this.mRenamedPackages = new WatchedArrayMap();
        this.mPendingDefaultBrowser = new WatchedSparseArray();
        this.mNextAppLinkGeneration = new WatchedSparseIntArray();
        this.mReadMessages = new StringBuilder();
        this.mObserver = new AnonymousClass1(this);
        this.mPackages = new WatchedArrayMap();
        this.mPackagesSnapshot = new SnapshotCache.Auto(this.mPackages, this.mPackages, "Settings.mPackages");
        this.mKernelMapping = new WatchedArrayMap();
        this.mKernelMappingSnapshot = new SnapshotCache.Auto(this.mKernelMapping, this.mKernelMapping, "Settings.mKernelMapping");
        this.mInstallerPackages = new WatchedArraySet();
        this.mInstallerPackagesSnapshot = new SnapshotCache.Auto(this.mInstallerPackages, this.mInstallerPackages, "Settings.mInstallerPackages");
        this.mPreferredActivities = new WatchedSparseArray();
        this.mPreferredActivitiesSnapshot = new SnapshotCache.Auto(this.mPreferredActivities, this.mPreferredActivities, "Settings.mPreferredActivities");
        this.mPersistentPreferredActivities = new WatchedSparseArray();
        this.mPersistentPreferredActivitiesSnapshot = new SnapshotCache.Auto(this.mPersistentPreferredActivities, this.mPersistentPreferredActivities, "Settings.mPersistentPreferredActivities");
        this.mCrossProfileIntentResolvers = new WatchedSparseArray();
        this.mCrossProfileIntentResolversSnapshot = new SnapshotCache.Auto(this.mCrossProfileIntentResolvers, this.mCrossProfileIntentResolvers, "Settings.mCrossProfileIntentResolvers");
        this.mPendingPackages = new WatchedArrayList();
        this.mPendingPackagesSnapshot = new SnapshotCache.Auto(this.mPendingPackages, this.mPendingPackages, "Settings.mPendingPackages");
        this.mKeySetManagerService = new KeySetManagerService(this.mPackages);
        this.mHandler = new Handler(BackgroundThread.getHandler().getLooper());
        this.mLock = new PackageManagerTracedLock();
        this.mPackages.putAll(pkgSettings);
        this.mAppIds = new AppIdSettingMap();
        this.mSystemDir = null;
        this.mPermissions = null;
        this.mRuntimePermissionsPersistence = null;
        this.mPermissionDataProvider = null;
        this.mSettingsFilename = null;
        this.mSettingsReserveCopyFilename = null;
        this.mPreviousSettingsFilename = null;
        this.mPackageListFilename = null;
        this.mStoppedPackagesFilename = null;
        this.mBackupStoppedPackagesFilename = null;
        this.mKernelMappingFilename = null;
        this.mDomainVerificationManager = null;
        registerObservers();
        Watchable.verifyWatchedAttributes(this, this.mObserver);
        this.mSnapshot = makeCache();
        this.mSmtEx = new SettingsSmtEx(this);
    }

    Settings(File dataDir, RuntimePermissionsPersistence runtimePermissionsPersistence, LegacyPermissionDataProvider permissionDataProvider, DomainVerificationManagerInternal domainVerificationManager, Handler handler, PackageManagerTracedLock lock) {
        this.mWatchable = new WatchableImpl();
        this.mPackageRestrictionsLock = new Object();
        this.mPendingAsyncPackageRestrictionsWrites = new SparseIntArray();
        this.mDisabledSysPackages = new WatchedArrayMap();
        this.mBlockUninstallPackages = new WatchedSparseArray();
        this.mVersion = new WatchedArrayMap();
        this.mSharedUsers = new WatchedArrayMap();
        this.mRenamedPackages = new WatchedArrayMap();
        this.mPendingDefaultBrowser = new WatchedSparseArray();
        this.mNextAppLinkGeneration = new WatchedSparseIntArray();
        this.mReadMessages = new StringBuilder();
        this.mObserver = new AnonymousClass1(this);
        this.mPackages = new WatchedArrayMap();
        this.mPackagesSnapshot = new SnapshotCache.Auto(this.mPackages, this.mPackages, "Settings.mPackages");
        this.mKernelMapping = new WatchedArrayMap();
        this.mKernelMappingSnapshot = new SnapshotCache.Auto(this.mKernelMapping, this.mKernelMapping, "Settings.mKernelMapping");
        this.mInstallerPackages = new WatchedArraySet();
        this.mInstallerPackagesSnapshot = new SnapshotCache.Auto(this.mInstallerPackages, this.mInstallerPackages, "Settings.mInstallerPackages");
        this.mPreferredActivities = new WatchedSparseArray();
        this.mPreferredActivitiesSnapshot = new SnapshotCache.Auto(this.mPreferredActivities, this.mPreferredActivities, "Settings.mPreferredActivities");
        this.mPersistentPreferredActivities = new WatchedSparseArray();
        this.mPersistentPreferredActivitiesSnapshot = new SnapshotCache.Auto(this.mPersistentPreferredActivities, this.mPersistentPreferredActivities, "Settings.mPersistentPreferredActivities");
        this.mCrossProfileIntentResolvers = new WatchedSparseArray();
        this.mCrossProfileIntentResolversSnapshot = new SnapshotCache.Auto(this.mCrossProfileIntentResolvers, this.mCrossProfileIntentResolvers, "Settings.mCrossProfileIntentResolvers");
        this.mPendingPackages = new WatchedArrayList();
        this.mPendingPackagesSnapshot = new SnapshotCache.Auto(this.mPendingPackages, this.mPendingPackages, "Settings.mPendingPackages");
        this.mKeySetManagerService = new KeySetManagerService(this.mPackages);
        this.mHandler = handler;
        this.mLock = lock;
        this.mAppIds = new AppIdSettingMap();
        this.mPermissions = new LegacyPermissionSettings();
        this.mRuntimePermissionsPersistence = new RuntimePermissionPersistence(runtimePermissionsPersistence, new AnonymousClass3(this));
        this.mPermissionDataProvider = permissionDataProvider;
        this.mSystemDir = new File(dataDir, "system");
        this.mSystemDir.mkdirs();
        FileUtils.setPermissions(this.mSystemDir.toString(), 509, -1, -1);
        this.mSettingsFilename = new File(this.mSystemDir, "packages.xml");
        this.mSettingsReserveCopyFilename = new File(this.mSystemDir, "packages.xml.reservecopy");
        this.mPreviousSettingsFilename = new File(this.mSystemDir, "packages-backup.xml");
        this.mPackageListFilename = new File(this.mSystemDir, "packages.list");
        FileUtils.setPermissions(this.mPackageListFilename, FrameworkStatsLog.DISPLAY_HBM_STATE_CHANGED, 1000, 1032);
        File kernelDir = new File("/config/sdcardfs");
        if (kernelDir.exists() == false) goto L5;
        File r1 = kernelDir;
    L6:
        this.mKernelMappingFilename = r1;
        this.mStoppedPackagesFilename = new File(this.mSystemDir, "packages-stopped.xml");
        this.mBackupStoppedPackagesFilename = new File(this.mSystemDir, "packages-stopped-backup.xml");
        this.mDomainVerificationManager = domainVerificationManager;
        registerObservers();
        Watchable.verifyWatchedAttributes(this, this.mObserver);
        this.mSnapshot = makeCache();
        this.mSmtEx = new SettingsSmtEx(this);
        return;
    L5:
        r1 = null;
        goto L6
    }

    private Settings(Settings r) {
        this.mWatchable = new WatchableImpl();
        this.mPackageRestrictionsLock = new Object();
        this.mPendingAsyncPackageRestrictionsWrites = new SparseIntArray();
        this.mDisabledSysPackages = new WatchedArrayMap();
        this.mBlockUninstallPackages = new WatchedSparseArray();
        this.mVersion = new WatchedArrayMap();
        this.mSharedUsers = new WatchedArrayMap();
        this.mRenamedPackages = new WatchedArrayMap();
        this.mPendingDefaultBrowser = new WatchedSparseArray();
        this.mNextAppLinkGeneration = new WatchedSparseIntArray();
        this.mReadMessages = new StringBuilder();
        this.mObserver = new AnonymousClass1(this);
        this.mPackages = r.mPackagesSnapshot.snapshot();
        this.mPackagesSnapshot = new SnapshotCache.Sealed();
        this.mKernelMapping = r.mKernelMappingSnapshot.snapshot();
        this.mKernelMappingSnapshot = new SnapshotCache.Sealed();
        this.mInstallerPackages = r.mInstallerPackagesSnapshot.snapshot();
        this.mInstallerPackagesSnapshot = new SnapshotCache.Sealed();
        this.mKeySetManagerService = new KeySetManagerService(r.mKeySetManagerService, this.mPackages);
        this.mHandler = null;
        this.mLock = null;
        this.mRuntimePermissionsPersistence = r.mRuntimePermissionsPersistence;
        this.mSettingsFilename = null;
        this.mSettingsReserveCopyFilename = null;
        this.mPreviousSettingsFilename = null;
        this.mPackageListFilename = null;
        this.mStoppedPackagesFilename = null;
        this.mBackupStoppedPackagesFilename = null;
        this.mKernelMappingFilename = null;
        this.mDomainVerificationManager = r.mDomainVerificationManager;
        this.mDisabledSysPackages.snapshot(r.mDisabledSysPackages);
        this.mBlockUninstallPackages.snapshot(r.mBlockUninstallPackages);
        this.mVersion.putAll(r.mVersion);
        this.mVerifierDeviceIdentity = r.mVerifierDeviceIdentity;
        this.mPreferredActivities = r.mPreferredActivitiesSnapshot.snapshot();
        this.mPreferredActivitiesSnapshot = new SnapshotCache.Sealed();
        this.mPersistentPreferredActivities = r.mPersistentPreferredActivitiesSnapshot.snapshot();
        this.mPersistentPreferredActivitiesSnapshot = new SnapshotCache.Sealed();
        this.mCrossProfileIntentResolvers = r.mCrossProfileIntentResolversSnapshot.snapshot();
        this.mCrossProfileIntentResolversSnapshot = new SnapshotCache.Sealed();
        this.mSharedUsers.snapshot(r.mSharedUsers);
        this.mAppIds = r.mAppIds.snapshot();
        this.mRenamedPackages.snapshot(r.mRenamedPackages);
        this.mNextAppLinkGeneration.snapshot(r.mNextAppLinkGeneration);
        this.mPendingDefaultBrowser.snapshot(r.mPendingDefaultBrowser);
        this.mPendingPackages = r.mPendingPackagesSnapshot.snapshot();
        this.mPendingPackagesSnapshot = new SnapshotCache.Sealed();
        this.mSystemDir = null;
        this.mPermissions = r.mPermissions;
        this.mPermissionDataProvider = r.mPermissionDataProvider;
        this.mSnapshot = new SnapshotCache.Sealed();
        this.mSmtEx = r.getSmtEx();
    }

    @Override // com.android.server.utils.Snappable
    public Settings snapshot() {
        return this.mSnapshot.snapshot();
    }

    private void invalidatePackageCache() {
        PackageManagerService.invalidatePackageInfoCache();
        ChangeIdStateCache.invalidate();
        onChanged();
    }

    PackageSetting getPackageLPr(String pkgName) {
        return this.mPackages.get(pkgName);
    }

    WatchedArrayMap<String, PackageSetting> getPackagesLocked() {
        return this.mPackages;
    }

    WatchedArrayMap<String, PackageSetting> getDisabledSystemPackagesLocked() {
        return this.mDisabledSysPackages;
    }

    KeySetManagerService getKeySetManagerService() {
        return this.mKeySetManagerService;
    }

    String getRenamedPackageLPr(String pkgName) {
        return this.mRenamedPackages.get(pkgName);
    }

    String addRenamedPackageLPw(String pkgName, String origPkgName) {
        return this.mRenamedPackages.put(pkgName, origPkgName);
    }

    void removeRenamedPackageLPw(String pkgName) {
        this.mRenamedPackages.remove(pkgName);
    }

    void pruneRenamedPackagesLPw() {
        int i = this.mRenamedPackages.size() - 1;
    L3:
        if (i < 0) goto L9;
        PackageSetting ps = this.mPackages.get(this.mRenamedPackages.valueAt(i));
        if (ps != null) goto L7;
        this.mRenamedPackages.removeAt(i);
    L7:
        i = i - 1;
        goto L3
    }

    SharedUserSetting getSharedUserLPw(String name, int pkgFlags, int pkgPrivateFlags, boolean create) throws PackageManagerException {
        SharedUserSetting s = this.mSharedUsers.get(name);
        if (s != null) goto L10;
        if (create == false) goto L10;
        s = new SharedUserSetting(name, pkgFlags, pkgPrivateFlags);
        s.mAppId = this.mAppIds.acquireAndRegisterNewAppId(s);
        if (s.mAppId < 0) goto L9;
        Log.i(PackageManagerServiceMonitorEx.TAG, "New shared user " + name + ": id=" + s.mAppId);
        this.mSharedUsers.put(name, s);
        goto L10
    L9:
        throw new PackageManagerException(-4, "Creating shared user " + name + " failed");
    L10:
        return s;
    }

    WatchedArrayMap<String, ? extends SharedUserApi> getSharedUsersLocked() {
        return this.mSharedUsers;
    }

    Collection<SharedUserSetting> getAllSharedUsersLPw() {
        return this.mSharedUsers.values();
    }

    boolean disableSystemPackageLPw(String name, boolean replaced) {
        PackageSetting p = this.mPackages.get(name);
        if (p != null) goto L6;
        Log.w(PackageManagerServiceMonitorEx.TAG, "Package " + name + " is not an installed package");
        return false;
    L6:
        PackageSetting dp = this.mDisabledSysPackages.get(name);
        if (dp == null) goto L9;
    L21:
        return false;
    L9:
        if (p.getPkg() == null) goto L21;
        if (p.isSystem() == false) goto L21;
        if (p.isUpdatedSystemApp() == true) goto L21;
        if (replaced == false) goto L16;
        PackageSetting disabled = new PackageSetting(p);
    L17:
        p.getPkgState().setUpdatedSystemApp(true);
        this.mDisabledSysPackages.put(name, disabled);
        SharedUserSetting sharedUserSetting = getSharedUserSettingLPr(disabled);
        if (sharedUserSetting == null) goto L20;
        sharedUserSetting.mDisabledPackages.add(disabled);
    L20:
        return true;
    L16:
        disabled = p;
        goto L17
    }

    PackageSetting enableSystemPackageLPw(String name) {
        PackageSetting p = this.mDisabledSysPackages.get(name);
        if (p != null) goto L6;
        Log.w(PackageManagerServiceMonitorEx.TAG, "Package " + name + " is not disabled");
        return null;
    L6:
        SharedUserSetting sharedUserSetting = getSharedUserSettingLPr(p);
        if (sharedUserSetting == null) goto L9;
        sharedUserSetting.mDisabledPackages.remove(p);
    L9:
        p.getPkgState().setUpdatedSystemApp(false);
        AndroidPackageInternal pkg = p.getPkg();
        String r6 = p.getRealName();
        File r7 = p.getPath();
        int r8 = p.getAppId();
        int r9 = p.getFlags();
        int r10 = p.getPrivateFlags();
        UUID r11 = this.mDomainVerificationManager.generateNewId();
        if (pkg != null) goto L12;
        boolean r12 = false;
    L13:
        PackageSetting ret = addPackageLPw(name, r6, r7, r8, r9, r10, r11, r12, p.hasSharedUser());
        if (ret == null) goto L16;
        ret.setLegacyNativeLibraryPath(p.getLegacyNativeLibraryPath());
        ret.setPrimaryCpuAbi(p.getPrimaryCpuAbiLegacy());
        ret.setSecondaryCpuAbi(p.getSecondaryCpuAbiLegacy());
        ret.setCpuAbiOverride(p.getCpuAbiOverride());
        ret.setLongVersionCode(p.getVersionCode());
        ret.setUsesSdkLibraries(p.getUsesSdkLibraries());
        ret.setUsesSdkLibrariesVersionsMajor(p.getUsesSdkLibrariesVersionsMajor());
        ret.setUsesSdkLibrariesOptional(p.getUsesSdkLibrariesOptional());
        ret.setUsesStaticLibraries(p.getUsesStaticLibraries());
        ret.setUsesStaticLibrariesVersions(p.getUsesStaticLibrariesVersions());
        ret.setMimeGroups(p.getMimeGroups());
        ret.setAppMetadataFilePath(p.getAppMetadataFilePath());
        ret.setAppMetadataSource(p.getAppMetadataSource());
        ret.getPkgState().setUpdatedSystemApp(false);
        ret.setTargetSdkVersion(p.getTargetSdkVersion());
        ret.setRestrictUpdateHash(p.getRestrictUpdateHash());
        ret.setScannedAsStoppedSystemApp(p.isScannedAsStoppedSystemApp());
        ret.setInstallSource(p.getInstallSource());
        ret.setSharedUserAppId(p.getSharedUserAppId());
    L16:
        this.mDisabledSysPackages.remove(name);
        return ret;
    L12:
        r12 = pkg.isSdkLibrary();
        goto L13
    }

    boolean isDisabledSystemPackageLPr(String name) {
        return this.mDisabledSysPackages.containsKey(name);
    }

    void removeDisabledSystemPackageLPw(String name) {
        PackageSetting p = this.mDisabledSysPackages.remove(name);
        if (p == null) goto L8;
        SharedUserSetting sharedUserSetting = getSharedUserSettingLPr(p);
        if (sharedUserSetting == null) goto L9;
        sharedUserSetting.mDisabledPackages.remove(p);
        checkAndPruneSharedUserLPw(sharedUserSetting, false);
        return;
    L9:
        return;
    }

    PackageSetting addPackageLPw(String name, String realName, File codePath, int uid, int pkgFlags, int pkgPrivateFlags, UUID domainSetId, boolean isSdkLibrary, boolean hasSharedUser) {
        PackageSetting p = this.mPackages.get(name);
        if (p != null) goto L5;
        PackageSetting p2 = new PackageSetting(name, realName, codePath, pkgFlags, pkgPrivateFlags, domainSetId).setAppId(uid);
        if (this.mAppIds.registerExistingAppId(uid, p2, name) == true) goto L14;
        if (hasSharedUser == true) goto L14;
        return null;
    L14:
        this.mPackages.put(name, p2);
        return p2;
    L5:
        if (p.getAppId() != uid) goto L7;
        return p;
    L7:
        PackageManagerService.reportSettingsProblem(6, "Adding duplicate package, keeping first: " + name);
        return null;
    }

    SharedUserSetting addOemSharedUserLPw(String name, int uid, int pkgFlags, int pkgPrivateFlags) {
        if (name.startsWith("android.uid") == true) goto L7;
        PackageManagerService.reportSettingsProblem(6, "Failed to add oem defined shared user because of invalid name: " + name);
        return null;
    L7:
        if (uid >= 2900) goto L9;
    L13:
        PackageManagerService.reportSettingsProblem(6, "Failed to add oem defined shared user because of invalid uid: " + uid);
        return null;
    L9:
        if (uid > 2999) goto L13;
        return addSharedUserLPw(name, uid, pkgFlags, pkgPrivateFlags);
    }

    SharedUserSetting addSharedUserLPw(String name, int uid, int pkgFlags, int pkgPrivateFlags) {
        SharedUserSetting s = this.mSharedUsers.get(name);
        if (s != null) goto L5;
        SharedUserSetting s2 = new SharedUserSetting(name, pkgFlags, pkgPrivateFlags);
        s2.mAppId = uid;
        if (this.mAppIds.registerExistingAppId(uid, s2, name) == false) goto L13;
        this.mSharedUsers.put(name, s2);
        return s2;
    L13:
        return null;
    L5:
        if (s.mAppId != uid) goto L7;
        return s;
    L7:
        PackageManagerService.reportSettingsProblem(6, "Adding duplicate shared user, keeping first: " + name);
        return null;
    }

    void pruneSharedUsersLPw() {
        List<String> removeKeys = new ArrayList();
        List<SharedUserSetting> removeValues = new ArrayList();
        Iterator<Map.Entry<String, SharedUserSetting>> r2 = this.mSharedUsers.entrySet().iterator();
    L4:
        if (r2.hasNext() == false) goto L29;
        Map.Entry<String, SharedUserSetting> entry = r2.next();
        SharedUserSetting sus = entry.getValue();
        if (sus == null) goto L7;
        boolean changed = false;
        WatchedArraySet<PackageSetting> sharedUserPackageSettings = sus.getPackageSettings();
        int i = sharedUserPackageSettings.size() - 1;
    L9:
        if (i < 0) goto L14;
        PackageSetting ps = sharedUserPackageSettings.valueAt(i);
        if (this.mPackages.get(ps.getPackageName()) != null) goto L13;
        sharedUserPackageSettings.removeAt(i);
        changed = true;
    L13:
        i = i - 1;
        goto L9
    L14:
        WatchedArraySet<PackageSetting> sharedUserDisabledPackageSettings = sus.getDisabledPackageSettings();
        int i2 = sharedUserDisabledPackageSettings.size() - 1;
    L15:
        if (i2 < 0) goto L21;
        PackageSetting ps2 = sharedUserDisabledPackageSettings.valueAt(i2);
        if (this.mDisabledSysPackages.get(ps2.getPackageName()) != null) goto L19;
        sharedUserDisabledPackageSettings.removeAt(i2);
        changed = true;
    L19:
        i2 = i2 - 1;
        goto L15
    L21:
        if (changed == false) goto L24;
        sus.onChanged();
    L24:
        if (sharedUserPackageSettings.isEmpty() == false) goto L4;
        if (sharedUserDisabledPackageSettings.isEmpty() == false) goto L4;
        removeValues.add(sus);
        goto L4
    L7:
        removeKeys.add(entry.getKey());
        goto L4
    L29:
        final WatchedArrayMap<String, SharedUserSetting> r3 = this.mSharedUsers;
        r3.getClass();
        removeKeys.forEach(new Settings$$ExternalSyntheticLambda0(r3));
        removeValues.forEach(new Settings$$ExternalSyntheticLambda1(this));
    }

    private /* synthetic */ void lambda$pruneSharedUsersLPw$0(SharedUserSetting sus) {
        checkAndPruneSharedUserLPw(sus, true);
    }

    static PackageSetting createNewSetting(String pkgName, PackageSetting originalPkg, PackageSetting disabledPkg, String realPkgName, SharedUserSetting sharedUser, File codePath, String legacyNativeLibraryPath, String primaryCpuAbi, String secondaryCpuAbi, long versionCode, int pkgFlags, int pkgPrivateFlags, UserHandle installUser, boolean allowInstall, boolean instantApp, boolean virtualPreload, boolean isStoppedSystemApp, UserManagerService userManager, String[] usesSdkLibraries, long[] usesSdkLibrariesVersions, boolean[] usesSdkLibrariesOptional, String[] usesStaticLibraries, long[] usesStaticLibrariesVersions, Set<String> mimeGroupNames, UUID domainSetId, int targetSdkVersion, byte[] restrictUpdatedHash) {
        if (originalPkg == null) goto L6;
        PackageSetting pkgSetting = new PackageSetting(originalPkg, pkgName).setPath(codePath).setLegacyNativeLibraryPath(legacyNativeLibraryPath).setPrimaryCpuAbi(primaryCpuAbi).setSecondaryCpuAbi(secondaryCpuAbi).setSignatures(new PackageSignatures()).setLongVersionCode(versionCode).setUsesSdkLibraries(usesSdkLibraries).setUsesSdkLibrariesVersionsMajor(usesSdkLibrariesVersions).setUsesSdkLibrariesOptional(usesSdkLibrariesOptional).setUsesStaticLibraries(usesStaticLibraries).setUsesStaticLibrariesVersions(usesStaticLibrariesVersions).setLastModifiedTime(codePath.lastModified()).setDomainSetId(domainSetId).setTargetSdkVersion(targetSdkVersion).setRestrictUpdateHash(restrictUpdatedHash);
        pkgSetting.setFlags(pkgFlags).setPrivateFlags(pkgPrivateFlags);
        return pkgSetting;
    L6:
        if (installUser == null) goto L8;
        int r16 = installUser.getIdentifier();
    L9:
        int installUserId = r16;
        PackageSetting pkgSetting2 = new PackageSetting(pkgName, realPkgName, codePath, pkgFlags, pkgPrivateFlags, domainSetId).setUsesSdkLibraries(usesSdkLibraries).setUsesSdkLibrariesVersionsMajor(usesSdkLibrariesVersions).setUsesSdkLibrariesOptional(usesSdkLibrariesOptional).setUsesStaticLibraries(usesStaticLibraries).setUsesStaticLibrariesVersions(usesStaticLibrariesVersions).setLegacyNativeLibraryPath(legacyNativeLibraryPath).setPrimaryCpuAbi(primaryCpuAbi).setSecondaryCpuAbi(secondaryCpuAbi).setLongVersionCode(versionCode).setMimeGroups(createMimeGroups(mimeGroupNames)).setTargetSdkVersion(targetSdkVersion).setRestrictUpdateHash(restrictUpdatedHash).setLastModifiedTime(codePath.lastModified());
        if (sharedUser == null) goto L12;
        SharedUserSetting r11 = sharedUser;
        pkgSetting2.setSharedUserAppId(r11.mAppId);
    L14:
        if ((pkgFlags & 1) != 0) goto L47;
        List<UserInfo> users = getAllUsers(userManager);
        if (users == null) goto L45;
        if (allowInstall == false) goto L45;
        Iterator<UserInfo> r44 = users.iterator();
    L20:
        if (r44.hasNext() == false) goto L44;
        UserInfo user = r44.next();
        if (installUser == null) goto L35;
        int installUserId2 = installUserId;
        if (installUserId2 != (-1)) goto L32;
        if (isAdbInstallDisallowed(userManager, user.id) == true) goto L32;
        if (user.preCreated == true) goto L32;
    L36:
        boolean installed = true;
    L37:
        boolean installed2 = installed;
        if (user.id == 10) goto L40;
    L42:
        boolean installed3 = installed2;
    L43:
        PackageSetting pkgSetting3 = pkgSetting2;
        pkgSetting3.setUserState(user.id, 0, 0, 0, installed3, true, true, false, 0, null, instantApp, virtualPreload, null, null, null, 0, 0, null, null, 0, 0, null);
        pkgSetting2 = pkgSetting3;
        installUserId = installUserId2;
        goto L20
    L40:
        if (installUserId2 == user.id) goto L42;
        installed3 = false;
    L32:
        if (installUserId2 == user.id) goto L36;
        installed = false;
        goto L37
    L35:
        installUserId2 = installUserId;
        goto L36
    L44:
        PackageSetting pkgSetting4 = pkgSetting2;
        int installUserId3 = installUserId;
    L50:
        if (r11 == null) goto L52;
        pkgSetting4.setAppId(r11.mAppId);
        return pkgSetting4;
    L52:
        if (disabledPkg == null) goto L62;
        pkgSetting4.setSignatures(new PackageSignatures(disabledPkg.getSignatures()));
        pkgSetting4.setAppId(disabledPkg.getAppId());
        pkgSetting4.getLegacyPermissionState().copyFrom(disabledPkg.getLegacyPermissionState());
        List<UserInfo> users2 = getAllUsers(userManager);
        if (users2 == null) goto L70;
        Iterator<UserInfo> r8 = users2.iterator();
    L57:
        if (r8.hasNext() == false) goto L69;
        int userId = r8.next().id;
        pkgSetting4.setDisabledComponentsCopy(disabledPkg.getDisabledComponents(userId), userId);
        pkgSetting4.setEnabledComponentsCopy(disabledPkg.getEnabledComponents(userId), userId);
        installUserId3 = installUserId3;
        users2 = users2;
        goto L57
    L69:
        return pkgSetting4;
    L70:
        return pkgSetting4;
    L62:
        return pkgSetting4;
    L45:
        pkgSetting4 = pkgSetting2;
        installUserId3 = installUserId;
        goto L50
    L47:
        pkgSetting4 = pkgSetting2;
        installUserId3 = installUserId;
        if (isStoppedSystemApp == false) goto L50;
        pkgSetting4.setStopped(true, installUserId3);
        pkgSetting4.setScannedAsStoppedSystemApp(true);
        goto L50
    L12:
        r11 = sharedUser;
        goto L14
    L8:
        r16 = 0;
        goto L9
    }

    private static Map<String, Set<String>> createMimeGroups(Set<String> mimeGroupNames) {
        if (mimeGroupNames != null) goto L6;
        return null;
    L6:
        return new KeySetToValueMap(mimeGroupNames, new ArraySet());
    }

    static void updatePackageSetting(PackageSetting pkgSetting, PackageSetting disabledPkg, SharedUserSetting existingSharedUserSetting, SharedUserSetting sharedUser, File codePath, String legacyNativeLibraryPath, String primaryCpuAbi, String secondaryCpuAbi, int pkgFlags, int pkgPrivateFlags, UserManagerService userManager, String[] usesSdkLibraries, long[] usesSdkLibrariesVersions, boolean[] usesSdkLibrariesOptional, String[] usesStaticLibraries, long[] usesStaticLibrariesVersions, Set<String> mimeGroupNames, UUID domainSetId, int targetSdkVersion, byte[] restrictUpdatedHash, boolean isDontKill) throws PackageManagerException {
        String pkgName = pkgSetting.getPackageName();
        File oldCodePath = pkgSetting.getPath();
        if (sharedUser != null) goto L5;
        pkgSetting.setSharedUserAppId(-1);
    L15:
        if (oldCodePath.equals(codePath) == true) goto L40;
        boolean isSystem = pkgSetting.isSystem();
        StringBuilder r14 = new StringBuilder();
        r14.append("Update");
        if (isSystem == false) goto L19;
        String r15 = " system";
    L20:
        r14.append(r15);
        r14.append(" package ");
        r14.append(pkgName);
        r14.append(" code path from ");
        r14.append(pkgSetting.getPathString());
        r14.append(" to ");
        r14.append(codePath.toString());
        r14.append("; Retain data and using new");
        Slog.i(PackageManagerServiceMonitorEx.TAG, r14.toString());
        if (isSystem == true) goto L36;
        if ((pkgFlags & 1) == 0) goto L34;
        if (disabledPkg != null) goto L34;
        List<UserInfo> allUserInfos = getAllUsers(userManager);
        if (allUserInfos == null) goto L34;
        Iterator<UserInfo> r16 = allUserInfos.iterator();
    L29:
        if (r16.hasNext() == false) goto L34;
        UserInfo userInfo = r16.next();
        pkgSetting.setInstalled(true, userInfo.id);
        pkgSetting.setUninstallReason(0, userInfo.id);
    L34:
        pkgSetting.setLegacyNativeLibraryPath(legacyNativeLibraryPath);
    L36:
        pkgSetting.setPath(codePath);
        if (isDontKill == false) goto L40;
        pkgSetting.addOldPath(oldCodePath);
        goto L40
    L19:
        r15 = "";
    L40:
        pkgSetting.setPrimaryCpuAbi(primaryCpuAbi).setSecondaryCpuAbi(secondaryCpuAbi).updateMimeGroups(mimeGroupNames).setDomainSetId(domainSetId).setTargetSdkVersion(targetSdkVersion).setRestrictUpdateHash(restrictUpdatedHash);
        if (usesSdkLibraries == null) goto L49;
        if (usesSdkLibrariesVersions == null) goto L49;
        if (usesSdkLibrariesOptional == null) goto L49;
        if (usesSdkLibraries.length != usesSdkLibrariesVersions.length) goto L49;
        if (usesSdkLibraries.length != usesSdkLibrariesOptional.length) goto L49;
        pkgSetting.setUsesSdkLibraries(usesSdkLibraries).setUsesSdkLibrariesVersionsMajor(usesSdkLibrariesVersions).setUsesSdkLibrariesOptional(usesSdkLibrariesOptional);
    L50:
        if (usesStaticLibraries == null) goto L55;
        if (usesStaticLibrariesVersions == null) goto L55;
        if (usesStaticLibraries.length != usesStaticLibrariesVersions.length) goto L55;
        pkgSetting.setUsesStaticLibraries(usesStaticLibraries).setUsesStaticLibrariesVersions(usesStaticLibrariesVersions);
    L56:
        int newPkgFlags = pkgSetting.getFlags();
        pkgSetting.setFlags((newPkgFlags & (-2)) | (pkgFlags & 1));
        if ((pkgSetting.getPrivateFlags() & 512) == 0) goto L59;
        boolean wasRequiredForSystemUser = true;
    L60:
        if (wasRequiredForSystemUser == false) goto L62;
        int pkgPrivateFlags2 = pkgPrivateFlags | 512;
    L63:
        pkgSetting.setPrivateFlags(pkgPrivateFlags2);
        return;
    L62:
        pkgPrivateFlags2 = pkgPrivateFlags & (-513);
        goto L63
    L59:
        wasRequiredForSystemUser = false;
    L55:
        pkgSetting.setUsesStaticLibraries(null).setUsesStaticLibrariesVersions(null);
    L49:
        pkgSetting.setUsesSdkLibraries(null).setUsesSdkLibrariesVersionsMajor(null).setUsesSdkLibrariesOptional(null);
        goto L50
    L5:
        if (Objects.equals(existingSharedUserSetting, sharedUser) == true) goto L12;
        StringBuilder r13 = new StringBuilder();
        r13.append("Package ");
        r13.append(pkgName);
        r13.append(" shared user changed from ");
        if (existingSharedUserSetting == null) goto L9;
        String r17 = existingSharedUserSetting.name;
    L10:
        r13.append(r17);
        r13.append(" to ");
        r13.append(sharedUser.name);
        PackageManagerService.reportSettingsProblem(5, r13.toString());
        throw new PackageManagerException(-24, "Updating application package " + pkgName + " failed");
    L9:
        r17 = "<nothing>";
        goto L10
    L12:
        pkgSetting.setSharedUserAppId(sharedUser.mAppId);
        goto L15
    }

    boolean registerAppIdLPw(PackageSetting p, boolean forceNew) throws PackageManagerException {
        if (p.getAppId() == 0) goto L7;
        if (forceNew == true) goto L7;
        boolean createdNew = this.mAppIds.registerExistingAppId(p.getAppId(), p, p.getPackageName());
    L9:
        if (p.getAppId() < 0) goto L11;
        return createdNew;
    L11:
        PackageManagerService.reportSettingsProblem(5, "Package " + p.getPackageName() + " could not be assigned a valid UID");
        throw new PackageManagerException(-4, "Package " + p.getPackageName() + " could not be assigned a valid UID");
    L7:
        p.setAppId(this.mAppIds.acquireAndRegisterNewAppId(p));
        createdNew = true;
        goto L9
    }

    void writeUserRestrictionsLPw(PackageSetting newPackage, PackageSetting oldPackage) {
        if (getPackageLPr(newPackage.getPackageName()) != null) goto L5;
        return;
    L5:
        List<UserInfo> allUsers = getAllUsers(UserManagerService.getInstance());
        if (allUsers != null) goto L8;
        return;
    L8:
        Iterator<UserInfo> r1 = allUsers.iterator();
    L10:
        if (r1.hasNext() == false) goto L19;
        UserInfo user = r1.next();
        if (oldPackage != null) goto L14;
        PackageUserState oldUserState = PackageUserState.DEFAULT;
    L16:
        if (oldUserState.equals(newPackage.readUserState(user.id)) == true) goto L10;
        writePackageRestrictionsLPr(user.id);
        goto L10
    L14:
        oldUserState = oldPackage.readUserState(user.id);
        goto L16
    }

    static boolean isAdbInstallDisallowed(UserManagerService userManager, int userId) {
        return userManager.hasUserRestriction("no_debugging_features", userId);
    }

    void insertPackageSettingLPw(PackageSetting p, AndroidPackage pkg) {
        if (p.getSigningDetails().getSignatures() != null) goto L5;
        p.setSigningDetails(pkg.getSigningDetails());
    L5:
        SharedUserSetting sharedUserSetting = getSharedUserSettingLPr(p);
        if (sharedUserSetting != null) goto L8;
    L10:
        addPackageSettingLPw(p, sharedUserSetting);
        return;
    L8:
        if (sharedUserSetting.signatures.mSigningDetails.getSignatures() != null) goto L10;
        PackageSignatures r1 = sharedUserSetting.signatures;
        r1.mSigningDetails = pkg.getSigningDetails();
        goto L10
    }

    void addPackageSettingLPw(PackageSetting p, SharedUserSetting sharedUser) {
        this.mPackages.put(p.getPackageName(), p);
        if (sharedUser == null) goto L14;
        SharedUserSetting existingSharedUserSetting = getSharedUserSettingLPr(p);
        if (existingSharedUserSetting == null) goto L9;
        if (existingSharedUserSetting == sharedUser) goto L9;
        PackageManagerService.reportSettingsProblem(6, "Package " + p.getPackageName() + " was user " + existingSharedUserSetting + " but is now " + sharedUser + "; I am not changing its files so it will probably fail!");
        existingSharedUserSetting.removePackage(p);
    L13:
        sharedUser.addPackage(p);
        p.setSharedUserAppId(sharedUser.mAppId);
        p.setAppId(sharedUser.mAppId);
    L9:
        if (p.getAppId() == 0) goto L13;
        if (p.getAppId() == sharedUser.mAppId) goto L13;
        PackageManagerService.reportSettingsProblem(6, "Package " + p.getPackageName() + " was app id " + p.getAppId() + " but is now user " + sharedUser + " with app id " + sharedUser.mAppId + "; I am not changing its files so it will probably fail!");
    L14:
        Object appIdPs = getSettingLPr(p.getAppId());
        if (sharedUser != null) goto L19;
        if (appIdPs == null) goto L23;
        if (appIdPs == p) goto L24;
        this.mAppIds.replaceSetting(p.getAppId(), p);
        return;
    L24:
        return;
    L23:
        return;
    L19:
        if (appIdPs == null) goto L26;
        if (appIdPs == sharedUser) goto L27;
        this.mAppIds.replaceSetting(p.getAppId(), sharedUser);
        return;
    L27:
        return;
    }

    boolean checkAndPruneSharedUserLPw(SharedUserSetting s, boolean skipCheck) {
        if (skipCheck == true) goto L8;
        if (s.getPackageStates().isEmpty() == true) goto L6;
        return false;
    L6:
        if (s.getDisabledPackageStates().isEmpty() == true) goto L8;
        return false;
    L8:
        if (this.mSharedUsers.remove(s.name) == null) goto L14;
        removeAppIdLPw(s.mAppId);
        return true;
    L14:
        return false;
    }

    boolean removePackageAndAppIdLPw(String name) {
        PackageSetting p = this.mPackages.remove(name);
        if (p == null) goto L10;
        removeInstallerPackageStatus(name);
        SharedUserSetting sharedUserSetting = getSharedUserSettingLPr(p);
        if (sharedUserSetting == null) goto L8;
        sharedUserSetting.removePackage(p);
        return checkAndPruneSharedUserLPw(sharedUserSetting, false);
    L8:
        removeAppIdLPw(p.getAppId());
        return true;
    L10:
        return false;
    }

    private void removeInstallerPackageStatus(String packageName) {
        if (this.mInstallerPackages.contains(packageName) == true) goto L5;
        return;
    L5:
        int i = 0;
    L7:
        if (i >= this.mPackages.size()) goto L9;
        this.mPackages.valueAt(i).removeInstallerPackage(packageName);
        i = i + 1;
        goto L7
    L9:
        this.mInstallerPackages.remove(packageName);
    }

    public SettingBase getSettingLPr(int appId) {
        return this.mAppIds.getSetting(appId);
    }

    void removeAppIdLPw(int appId) {
        this.mAppIds.removeSetting(appId);
    }

    void convertSharedUserSettingsLPw(SharedUserSetting sharedUser) {
        PackageSetting ps = sharedUser.getPackageSettings().valueAt(0);
        this.mAppIds.replaceSetting(sharedUser.getAppId(), ps);
        ps.setSharedUserAppId(-1);
        if (sharedUser.getDisabledPackageSettings().isEmpty() == true) goto L5;
        PackageSetting disabledPs = sharedUser.getDisabledPackageSettings().valueAt(0);
        disabledPs.setSharedUserAppId(-1);
    L5:
        this.mSharedUsers.remove(sharedUser.getName());
    }

    void checkAndConvertSharedUserSettingsLPw(SharedUserSetting sharedUser) {
        if (sharedUser.isSingleUser() == true) goto L5;
        return;
    L5:
        AndroidPackageInternal r0 = sharedUser.getPackageSettings().valueAt(0).getPkg();
        if (r0 != null) goto L8;
        return;
    L8:
        if (r0.isLeavingSharedUser() == true) goto L10;
        return;
    L10:
        if (SharedUidMigration.applyStrategy(2) == false) goto L15;
        convertSharedUserSettingsLPw(sharedUser);
        return;
    }

    PreferredIntentResolver editPreferredActivitiesLPw(int userId) {
        PreferredIntentResolver pir = this.mPreferredActivities.get(userId);
        if (pir != null) goto L6;
        PreferredIntentResolver pir2 = new PreferredIntentResolver();
        this.mPreferredActivities.put(userId, pir2);
        return pir2;
    L6:
        return pir;
    }

    PersistentPreferredIntentResolver editPersistentPreferredActivitiesLPw(int userId) {
        PersistentPreferredIntentResolver ppir = this.mPersistentPreferredActivities.get(userId);
        if (ppir != null) goto L6;
        PersistentPreferredIntentResolver ppir2 = new PersistentPreferredIntentResolver();
        this.mPersistentPreferredActivities.put(userId, ppir2);
        return ppir2;
    L6:
        return ppir;
    }

    CrossProfileIntentResolver editCrossProfileIntentResolverLPw(int userId) {
        CrossProfileIntentResolver cpir = this.mCrossProfileIntentResolvers.get(userId);
        if (cpir != null) goto L6;
        CrossProfileIntentResolver cpir2 = new CrossProfileIntentResolver();
        this.mCrossProfileIntentResolvers.put(userId, cpir2);
        return cpir2;
    L6:
        return cpir;
    }

    String getPendingDefaultBrowserLPr(int userId) {
        return this.mPendingDefaultBrowser.get(userId);
    }

    void setPendingDefaultBrowserLPw(String defaultBrowser, int userId) {
        this.mPendingDefaultBrowser.put(userId, defaultBrowser);
    }

    String removePendingDefaultBrowserLPw(int userId) {
        return this.mPendingDefaultBrowser.removeReturnOld(userId);
    }

    private File getUserSystemDirectory(int userId) {
        return new File(new File(this.mSystemDir, DatabaseHelper.SoundModelContract.KEY_USERS), Integer.toString(userId));
    }

    private ResilientAtomicFile getUserPackagesStateFile(int userId) {
        File mainFile = new File(getUserSystemDirectory(userId), "package-restrictions.xml");
        File temporaryBackup = new File(getUserSystemDirectory(userId), "package-restrictions-backup.xml");
        File reserveCopy = new File(getUserSystemDirectory(userId), "package-restrictions.xml.reservecopy");
        return new ResilientAtomicFile(mainFile, temporaryBackup, reserveCopy, FrameworkStatsLog.HOTWORD_DETECTION_SERVICE_RESTARTED, "package restrictions", this);
    }

    private ResilientAtomicFile getSettingsFile() {
        return new ResilientAtomicFile(this.mSettingsFilename, this.mPreviousSettingsFilename, this.mSettingsReserveCopyFilename, FrameworkStatsLog.HOTWORD_DETECTION_SERVICE_RESTARTED, "package manager settings", this);
    }

    private File getUserRuntimePermissionsFile(int userId) {
        return new File(getUserSystemDirectory(userId), RUNTIME_PERMISSIONS_FILE_NAME);
    }

    void writeAllUsersPackageRestrictionsLPr() {
        writeAllUsersPackageRestrictionsLPr(false);
    }

    void writeAllUsersPackageRestrictionsLPr(boolean sync) {
        List<UserInfo> users = getAllUsers(UserManagerService.getInstance());
        if (users != null) goto L5;
        return;
    L5:
        if (sync == false) goto L14;
        Object r1 = this.mPackageRestrictionsLock;
        monitor-enter(r1);
        this.mPendingAsyncPackageRestrictionsWrites.clear();     // Catch: Throwable -> L11
        monitor-exit(r1);     // Catch: Throwable -> L11
        this.mHandler.removeMessages(30);
    L11:
        th = move-exception;
        throw th;
    L14:
        Iterator<UserInfo> r2 = users.iterator();
    L16:
        if (r2.hasNext() == false) goto L18;
        UserInfo user = r2.next();
        writePackageRestrictionsLPr(user.id, sync);
        goto L16
    }

    void writeAllRuntimePermissionsLPr() {
        int[] r0 = UserManagerService.getInstance().getUserIds();
        int r1 = r0.length;
        int r2 = 0;
    L3:
        if (r2 >= r1) goto L5;
        int userId = r0[r2];
        this.mRuntimePermissionsPersistence.writeStateForUserAsync(userId);
        r2 = r2 + 1;
        goto L3
    }

    boolean isPermissionUpgradeNeeded(int userId) {
        return this.mRuntimePermissionsPersistence.isPermissionUpgradeNeeded(userId);
    }

    void updateRuntimePermissionsFingerprint(int userId) {
        this.mRuntimePermissionsPersistence.updateRuntimePermissionsFingerprint(userId);
    }

    int getDefaultRuntimePermissionsVersion(int userId) {
        return this.mRuntimePermissionsPersistence.getVersion(userId);
    }

    void setDefaultRuntimePermissionsVersion(int version, int userId) {
        this.mRuntimePermissionsPersistence.setVersion(version, userId);
    }

    void setPermissionControllerVersion(long version) {
        this.mRuntimePermissionsPersistence.setPermissionControllerVersion(version);
    }

    public VersionInfo findOrCreateVersion(String volumeUuid) {
        VersionInfo ver = this.mVersion.get(volumeUuid);
        if (ver != null) goto L6;
        VersionInfo ver2 = new VersionInfo();
        this.mVersion.put(volumeUuid, ver2);
        return ver2;
    L6:
        return ver;
    }

    public VersionInfo getInternalVersion() {
        return this.mVersion.get(StorageManager.UUID_PRIVATE_INTERNAL);
    }

    public VersionInfo getExternalVersion() {
        return this.mVersion.get("primary_physical");
    }

    public void onVolumeForgotten(String fsUuid) {
        this.mVersion.remove(fsUuid);
    }

    void readPreferredActivitiesLPw(TypedXmlPullParser parser, int userId) throws XmlPullParserException, IOException {
        int outerDepth = parser.getDepth();
    L3:
        int type = parser.next();
        if (type == 1) goto L29;
        if (type == 3) goto L8;
    L10:
        if (type == 3) goto L3;
        if (type == 4) goto L3;
        String tagName = parser.getName();
        if (tagName == null) goto L3;
        if (tagName.equals(TAG_ITEM) == true) goto L19;
        PackageManagerService.reportSettingsProblem(5, "Unknown element under <preferred-activities>: " + parser.getName());
        XmlUtils.skipCurrentTag(parser);
        goto L3
    L19:
        PreferredActivity pa = new PreferredActivity(parser);
        if (pa.mPref.getParseError() == null) goto L21;
        PackageManagerService.reportSettingsProblem(5, "Error in package manager settings: <preferred-activity> " + pa.mPref.getParseError() + " at " + parser.getPositionDescription());
        goto L3
    L21:
        PreferredIntentResolver resolver = editPreferredActivitiesLPw(userId);
        if (resolver.shouldAddPreferredActivity(pa) == false) goto L3;
        resolver.addFilter(null, pa);
        goto L3
    L8:
        if (parser.getDepth() > outerDepth) goto L10;
        return;
    }

    private void readPersistentPreferredActivitiesLPw(TypedXmlPullParser parser, int userId) throws XmlPullParserException, IOException {
        int outerDepth = parser.getDepth();
    L3:
        int type = parser.next();
        if (type == 1) goto L22;
        if (type == 3) goto L8;
    L10:
        if (type == 3) goto L3;
        if (type == 4) goto L3;
        String tagName = parser.getName();
        if (tagName == null) goto L3;
        if (tagName.equals(TAG_ITEM) == true) goto L19;
        PackageManagerService.reportSettingsProblem(5, "Unknown element under <persistent-preferred-activities>: " + parser.getName());
        XmlUtils.skipCurrentTag(parser);
        goto L3
    L19:
        PersistentPreferredActivity ppa = new PersistentPreferredActivity(parser);
        editPersistentPreferredActivitiesLPw(userId).addFilter(null, ppa);
        goto L3
    L8:
        if (parser.getDepth() > outerDepth) goto L10;
        return;
    }

    private void readCrossProfileIntentFiltersLPw(TypedXmlPullParser parser, int userId) throws XmlPullParserException, IOException {
        int outerDepth = parser.getDepth();
    L3:
        int type = parser.next();
        if (type == 1) goto L22;
        if (type == 3) goto L8;
    L10:
        if (type == 3) goto L3;
        if (type == 4) goto L3;
        String tagName = parser.getName();
        if (tagName == null) goto L3;
        if (tagName.equals(TAG_ITEM) == true) goto L19;
        String msg = "Unknown element under crossProfile-intent-filters: " + tagName;
        PackageManagerService.reportSettingsProblem(5, msg);
        XmlUtils.skipCurrentTag(parser);
        goto L3
    L19:
        CrossProfileIntentFilter cpif = new CrossProfileIntentFilter(parser);
        editCrossProfileIntentResolverLPw(userId).addFilter(null, cpif);
        goto L3
    L8:
        if (parser.getDepth() > outerDepth) goto L10;
        return;
    }

    void readDefaultAppsLPw(XmlPullParser parser, int userId) throws XmlPullParserException, IOException {
        String defaultBrowser = readDefaultApps(parser);
        if (defaultBrowser == null) goto L6;
        this.mPendingDefaultBrowser.put(userId, defaultBrowser);
        return;
    }

    static String readDefaultApps(XmlPullParser parser) throws XmlPullParserException, IOException {
        String defaultBrowser = null;
        int outerDepth = parser.getDepth();
    L3:
        int type = parser.next();
        if (type == 1) goto L25;
        if (type == 3) goto L8;
    L10:
        if (type == 3) goto L3;
        if (type == 4) goto L3;
        String tagName = parser.getName();
        if (tagName == null) goto L3;
        if (tagName.equals(TAG_DEFAULT_BROWSER) == true) goto L19;
        if (tagName.equals(TAG_DEFAULT_DIALER) == true) goto L3;
        String msg = "Unknown element under default-apps: " + parser.getName();
        PackageManagerService.reportSettingsProblem(5, msg);
        XmlUtils.skipCurrentTag(parser);
        goto L3
    L19:
        defaultBrowser = parser.getAttributeValue(null, "packageName");
        goto L3
    L8:
        if (parser.getDepth() > outerDepth) goto L10;
    L25:
        return defaultBrowser;
    }

    void readBlockUninstallPackagesLPw(TypedXmlPullParser parser, int userId) throws XmlPullParserException, IOException {
        int outerDepth = parser.getDepth();
        ArraySet<String> packages = new ArraySet();
    L3:
        int type = parser.next();
        if (type == 1) goto L23;
        if (type == 3) goto L8;
    L10:
        if (type == 3) goto L3;
        if (type == 4) goto L3;
        String tagName = parser.getName();
        if (tagName == null) goto L3;
        if (tagName.equals(TAG_BLOCK_UNINSTALL) == true) goto L19;
        String msg = "Unknown element under block-uninstall-packages: " + parser.getName();
        PackageManagerService.reportSettingsProblem(5, msg);
        XmlUtils.skipCurrentTag(parser);
        goto L3
    L19:
        String packageName = parser.getAttributeValue(null, "packageName");
        packages.add(packageName);
        goto L3
    L8:
        if (parser.getDepth() > outerDepth) goto L10;
    L23:
        if (packages.isEmpty() == false) goto L25;
        this.mBlockUninstallPackages.remove(userId);
        return;
    L25:
        this.mBlockUninstallPackages.put(userId, packages);
    }

    @Override // com.android.server.pm.ResilientAtomicFile.ReadEventLogger
    public void logEvent(int priority, String msg) {
        this.mReadMessages.append(msg + "\n");
        PackageManagerService.reportSettingsProblem(priority, msg);
    }

    void readPackageRestrictionsLPr(int userId, ArrayMap<String, Long> origFirstInstallTimes) {
        ResilientAtomicFile atomicFile = getUserPackagesStateFile(userId);
        FileInputStream str = null;
        Object r5 = this.mPackageRestrictionsLock;     // Catch: Throwable -> L202 Throwable -> L204
        monitor-enter(r5);     // Catch: Throwable -> L202 Throwable -> L204
        FileInputStream str2 = atomicFile.openRead();     // Catch: Throwable -> L194
        if (str2 == null) goto L223;
        ResilientAtomicFile atomicFile2 = atomicFile;
        monitor-exit(r5);     // Catch: Throwable -> L14
        XmlPullParser r0 = Xml.resolvePullParser(str2);     // Catch: Throwable -> L34 Throwable -> L38
    L25:
        int type = r0.next();     // Catch: Throwable -> L34 Throwable -> L38
        char r6 = 2;
        boolean r7 = true;
        if (type == 2) goto L29;
        if (type != 1) goto L25;
    L29:
        int r2 = 5;
        if (type == 2) goto L41;
        this.mReadMessages.append("No start tag found in package restrictions file\n");     // Catch: Throwable -> L34 Throwable -> L38
        PackageManagerService.reportSettingsProblem(5, "No start tag found in package manager package restrictions file");     // Catch: Throwable -> L34 Throwable -> L38
        atomicFile2.close();
        return;
    L41:
        int outerDepth = r0.getDepth();     // Catch: Throwable -> L34 Throwable -> L38 Throwable -> L38
    L42:
        int type2 = r0.next();     // Catch: Throwable -> L34 Throwable -> L38 Throwable -> L38
        if (type2 == r7) goto L193;
        if (type2 == 3) goto L47;
    L50:
        if (type2 == 3) goto L191;
        if (type2 == 4) goto L191;
        String tagName = r0.getName();     // Catch: Throwable -> L34 Throwable -> L38 Throwable -> L38
        if (tagName == null) goto L191;
        if (tagName.equals("pkg") == false) goto L169;
        String name = r0.getAttributeValue(null, "name");     // Catch: Throwable -> L34 Throwable -> L38 Throwable -> L38
        PackageSetting ps = this.mPackages.get(name);     // Catch: Throwable -> L34 Throwable -> L38 Throwable -> L38
        if (ps == null) goto L61;
        long ceDataInode = r0.getAttributeLong(null, ATTR_CE_DATA_INODE, 0);     // Catch: Throwable -> L34 Throwable -> L38 Throwable -> L38
        long deDataInode = r0.getAttributeLong(null, ATTR_DE_DATA_INODE, 0);     // Catch: Throwable -> L34 Throwable -> L38 Throwable -> L38
        boolean installed = r0.getAttributeBoolean(null, ATTR_INSTALLED, r7);     // Catch: Throwable -> L34 Throwable -> L38 Throwable -> L38
        boolean stopped = r0.getAttributeBoolean(null, ATTR_STOPPED, false);     // Catch: Throwable -> L34 Throwable -> L38 Throwable -> L38
        boolean notLaunched = r0.getAttributeBoolean(null, ATTR_NOT_LAUNCHED, false);     // Catch: Throwable -> L34 Throwable -> L38 Throwable -> L38
        boolean hidden = r0.getAttributeBoolean(null, ATTR_HIDDEN, false);     // Catch: Throwable -> L34 Throwable -> L38 Throwable -> L38
        if (hidden == true) goto L65;
        hidden = r0.getAttributeBoolean(null, ATTR_BLOCKED, false);     // Catch: Throwable -> L34 Throwable -> L38 Throwable -> L38
    L65:
        int distractionFlags = r0.getAttributeInt(null, ATTR_DISTRACTION_FLAGS, 0);     // Catch: Throwable -> L34 Throwable -> L38 Throwable -> L38
        boolean suspended = r0.getAttributeBoolean(null, ATTR_SUSPENDED, false);     // Catch: Throwable -> L34 Throwable -> L38 Throwable -> L38
        String oldSuspendingPackage = r0.getAttributeValue(null, ATTR_SUSPENDING_PACKAGE);     // Catch: Throwable -> L34 Throwable -> L38 Throwable -> L38
        String dialogMessage = r0.getAttributeValue(null, ATTR_SUSPEND_DIALOG_MESSAGE);     // Catch: Throwable -> L34 Throwable -> L38 Throwable -> L38
        if (suspended == false) goto L69;
        if (oldSuspendingPackage != null) goto L69;
        oldSuspendingPackage = PackageManagerService.PLATFORM_PACKAGE_NAME;
    L69:
        boolean blockUninstall = r0.getAttributeBoolean(null, ATTR_BLOCK_UNINSTALL, false);     // Catch: Throwable -> L34 Throwable -> L38 Throwable -> L38
        boolean instantApp = r0.getAttributeBoolean(null, ATTR_INSTANT_APP, false);     // Catch: Throwable -> L34 Throwable -> L38 Throwable -> L38
        boolean virtualPreload = r0.getAttributeBoolean(null, ATTR_VIRTUAL_PRELOAD, false);     // Catch: Throwable -> L34 Throwable -> L38 Throwable -> L38
        int enabled = r0.getAttributeInt(null, "enabled", 0);     // Catch: Throwable -> L34 Throwable -> L38 Throwable -> L38
        String enabledCaller = r0.getAttributeValue(null, ATTR_ENABLED_CALLER);     // Catch: Throwable -> L34 Throwable -> L38 Throwable -> L38
        String harmfulAppWarning = r0.getAttributeValue(null, ATTR_HARMFUL_APP_WARNING);     // Catch: Throwable -> L34 Throwable -> L38 Throwable -> L38
        int verifState = r0.getAttributeInt(null, ATTR_DOMAIN_VERIFICATION_STATE, 0);     // Catch: Throwable -> L34 Throwable -> L38 Throwable -> L38
        int installReason = r0.getAttributeInt(null, ATTR_INSTALL_REASON, 0);     // Catch: Throwable -> L34 Throwable -> L38 Throwable -> L38
        int uninstallReason = r0.getAttributeInt(null, ATTR_UNINSTALL_REASON, 0);     // Catch: Throwable -> L34 Throwable -> L38 Throwable -> L38
        String splashScreenTheme = r0.getAttributeValue(null, ATTR_SPLASH_SCREEN_THEME);     // Catch: Throwable -> L34 Throwable -> L38 Throwable -> L38
        long firstInstallTime = r0.getAttributeLongHex(null, ATTR_FIRST_INSTALL_TIME, 0);     // Catch: Throwable -> L34 Throwable -> L38 Throwable -> L38
        int minAspectRatio = r0.getAttributeInt(null, ATTR_MIN_ASPECT_RATIO, 0);     // Catch: Throwable -> L34 Throwable -> L38 Throwable -> L38
        ArraySet<String> disabledComponents = null;
        SuspendDialogInfo oldSuspendDialogInfo = null;
        ArchiveState archiveState = null;
        int packageDepth = r0.getDepth();     // Catch: Throwable -> L34 Throwable -> L38 Throwable -> L38
        ArrayMap<UserPackage, SuspendParams> suspendParamsMap = null;
        PersistableBundle oldSuspendedAppExtras = null;
        ArraySet<String> enabledComponents = null;
        PersistableBundle oldSuspendedLauncherExtras = null;
    L70:
        ArraySet<String> disabledComponents2 = disabledComponents;
        int type3 = r0.next();     // Catch: Throwable -> L34 Throwable -> L38 Throwable -> L38
        SuspendDialogInfo oldSuspendDialogInfo2 = oldSuspendDialogInfo;
        if (type3 == 1) goto L142;
        if (type3 == 3) goto L75;
        ps = ps;
        int packageDepth2 = packageDepth;
    L81:
        if (type3 == 3) goto L140;
        if (type3 == 4) goto L84;
        String packageTagName = r0.getName();     // Catch: Throwable -> L136 Throwable -> L138
        if (packageTagName == null) goto L87;
        switch(packageTagName.hashCode()) {
            case -2096193594: goto L109;
            case -2027581689: goto L106;
            case -1963032286: goto L103;
            case -1592287551: goto L100;
            case -1422791362: goto L97;
            case -858175433: goto L94;
            case 1660896545: goto L91;
            default: goto L90;
        };
    L90:
        int type4 = type3;
        String packageTagName2 = packageTagName;
    L113:
        byte r8 = -1;
    L114:
        switch(r8) {
            case 0: goto L134;
            case 1: goto L133;
            case 2: goto L132;
            case 3: goto L131;
            case 4: goto L130;
            case 5: goto L118;
            case 6: goto L116;
            default: goto L115;
        };
    L118:
        int packageDepth3 = packageDepth2;
        Map.Entry<UserPackage, SuspendParams> entry = readSuspensionParamsLPr(userId, r0);     // Catch: Throwable -> L124 Throwable -> L126
        if (entry == null) goto L141;
        if (suspendParamsMap != null) goto L128;
        ArrayMap<UserPackage, SuspendParams> suspendParamsMap2 = new ArrayMap();     // Catch: Throwable -> L124 Throwable -> L126
    L129:
        suspendParamsMap2.put(entry.getKey(), entry.getValue());     // Catch: Throwable -> L124 Throwable -> L126
        suspendParamsMap = suspendParamsMap2;
        oldSuspendDialogInfo = oldSuspendDialogInfo2;
    L135:
        disabledComponents = disabledComponents2;
        packageDepth = packageDepth3;
        goto L70
    L128:
        suspendParamsMap2 = suspendParamsMap;
    L141:
        oldSuspendDialogInfo = oldSuspendDialogInfo2;
        disabledComponents = disabledComponents2;
        packageDepth = packageDepth3;
        goto L70
    L115:
        StringBuilder r9 = new StringBuilder();     // Catch: Throwable -> L34 Throwable -> L38 Throwable -> L38
        packageDepth3 = packageDepth2;
        r9.append("Unknown tag ");     // Catch: Throwable -> L34 Throwable -> L38 Throwable -> L38
        r9.append(r0.getName());     // Catch: Throwable -> L34 Throwable -> L38 Throwable -> L38
        r9.append(" under tag ");     // Catch: Throwable -> L34 Throwable -> L38 Throwable -> L38
        r9.append("pkg");     // Catch: Throwable -> L34 Throwable -> L38 Throwable -> L38
        Slog.wtf(TAG, r9.toString());     // Catch: Throwable -> L34 Throwable -> L38 Throwable -> L38
        oldSuspendDialogInfo = oldSuspendDialogInfo2;
        goto L135
    L116:
        packageDepth3 = packageDepth2;
        ArchiveState archiveState2 = parseArchiveState(r0);     // Catch: Throwable -> L34 Throwable -> L38 Throwable -> L38
        archiveState = archiveState2;
        oldSuspendDialogInfo = oldSuspendDialogInfo2;
        goto L135
    L130:
        packageDepth3 = packageDepth2;
        PersistableBundle oldSuspendedLauncherExtras2 = PersistableBundle.restoreFromXml(r0);     // Catch: Throwable -> L124 Throwable -> L126
        oldSuspendedLauncherExtras = oldSuspendedLauncherExtras2;
        oldSuspendDialogInfo = oldSuspendDialogInfo2;
        goto L135
    L131:
        packageDepth3 = packageDepth2;
        PersistableBundle oldSuspendedAppExtras2 = PersistableBundle.restoreFromXml(r0);     // Catch: Throwable -> L124 Throwable -> L126
        oldSuspendedAppExtras = oldSuspendedAppExtras2;
        oldSuspendDialogInfo = oldSuspendDialogInfo2;
        goto L135
    L132:
        packageDepth3 = packageDepth2;
        oldSuspendDialogInfo = SuspendDialogInfo.restoreFromXml(r0);     // Catch: Throwable -> L124 Throwable -> L126
        goto L135
    L133:
        packageDepth3 = packageDepth2;
        ArraySet<String> disabledComponents3 = readComponentsLPr(r0);     // Catch: Throwable -> L124 Throwable -> L126
        disabledComponents2 = disabledComponents3;
        oldSuspendDialogInfo = oldSuspendDialogInfo2;
        goto L135
    L134:
        packageDepth3 = packageDepth2;
        ArraySet<String> enabledComponents2 = readComponentsLPr(r0);     // Catch: Throwable -> L124 Throwable -> L126
        enabledComponents = enabledComponents2;
        oldSuspendDialogInfo = oldSuspendDialogInfo2;
        goto L135
    L91:
        type4 = type3;
        packageTagName2 = packageTagName;
        if (packageTagName2.equals(TAG_SUSPENDED_DIALOG_INFO) == false) goto L113;
        r8 = 2;
        goto L114
    L94:
        type4 = type3;
        packageTagName2 = packageTagName;
        if (packageTagName2.equals(TAG_SUSPEND_PARAMS) == false) goto L113;
        r8 = 5;
        goto L114
    L97:
        type4 = type3;
        packageTagName2 = packageTagName;
        if (packageTagName2.equals(TAG_SUSPENDED_LAUNCHER_EXTRAS) == false) goto L113;
        r8 = 4;
        goto L114
    L100:
        type4 = type3;
        packageTagName2 = packageTagName;
        if (packageTagName2.equals(TAG_SUSPENDED_APP_EXTRAS) == false) goto L113;
        r8 = 3;
        goto L114
    L103:
        type4 = type3;
        packageTagName2 = packageTagName;
        if (packageTagName2.equals(TAG_ENABLED_COMPONENTS) == false) goto L113;
        r8 = 0;
        goto L114
    L106:
        type4 = type3;
        packageTagName2 = packageTagName;
        if (packageTagName2.equals(TAG_DISABLED_COMPONENTS) == false) goto L113;
        r8 = 1;
        goto L114
    L109:
        type4 = type3;
        packageTagName2 = packageTagName;
        if (packageTagName2.equals(TAG_ARCHIVE_STATE) == false) goto L113;
        r8 = 6;
        goto L114
    L87:
        type4 = type3;
        packageDepth3 = packageDepth2;
    L136:
        th = th;
        userId = userId;
    L125:
        Throwable r3 = th;
    L37:
        ResilientAtomicFile atomicFile3 = atomicFile2;
    L213:
        if (atomicFile3 == null) goto L279;
        atomicFile3.close();     // Catch: Throwable -> L216
        throw r3;
    L216:
        th = move-exception;
        r3.addSuppressed(th);
        throw r3;
    L279:
        throw r3;
    L138:
        e = e;
        userId = userId;
    L40:
        str = str2;
    L206:
        atomicFile3 = atomicFile2;
        atomicFile3.failRead(str, e);     // Catch: Throwable -> L211
        readPackageRestrictionsLPr(userId, origFirstInstallTimes);     // Catch: Throwable -> L211
    L208:
        if (atomicFile3 == null) goto L278;
        atomicFile3.close();
        return;
    L278:
        return;
    L211:
        th = move-exception;
        r3 = th;
        goto L213
    L84:
        type4 = type3;
        packageDepth3 = packageDepth2;
        goto L141
    L140:
        type4 = type3;
        packageDepth3 = packageDepth2;
        goto L141
    L75:
        ps = ps;
        packageDepth2 = packageDepth;
        if (r0.getDepth() > packageDepth2) goto L81;
        int type5 = type3;
    L143:
        if (oldSuspendDialogInfo2 == null) goto L230;
    L147:
        SuspendDialogInfo oldSuspendDialogInfo3 = oldSuspendDialogInfo2;
    L148:
        if (suspended == false) goto L152;
        if (suspendParamsMap != null) goto L152;
        SuspendParams suspendParams = new SuspendParams(oldSuspendDialogInfo3, oldSuspendedAppExtras, oldSuspendedLauncherExtras, false);     // Catch: Throwable -> L124 Throwable -> L126
        ArrayMap<UserPackage, SuspendParams> suspendParamsMap3 = new ArrayMap();     // Catch: Throwable -> L124 Throwable -> L126
        suspendParamsMap3.put(UserPackage.of(userId, oldSuspendingPackage), suspendParams);     // Catch: Throwable -> L124 Throwable -> L126
        suspendParamsMap = suspendParamsMap3;
    L152:
        if (blockUninstall == false) goto L155;
        boolean r4 = true;
        setBlockUninstallLPw(userId, name, true);     // Catch: Throwable -> L124 Throwable -> L126
    L157:
        if (firstInstallTime == 0) goto L236;
        long r24 = firstInstallTime;
    L161:
        char r33 = 2;
        boolean virtualPreload2 = r4;
        int distractionFlags2 = 5;
        ps.setUserState(userId, ceDataInode, deDataInode, enabled, installed, stopped, notLaunched, hidden, distractionFlags, suspendParamsMap, instantApp, virtualPreload, enabledCaller, enabledComponents, disabledComponents2, installReason, uninstallReason, harmfulAppWarning, splashScreenTheme, r24, minAspectRatio, archiveState);     // Catch: Throwable -> L163 Throwable -> L165
        this.mDomainVerificationManager.setLegacyUserState(name, userId, verifState);     // Catch: Throwable -> L163 Throwable -> L165
    L189:
        r6 = r33;
        r7 = virtualPreload2;
        r2 = distractionFlags2;
        outerDepth = outerDepth;
    L165:
        e = e;
        goto L40
    L236:
        r24 = origFirstInstallTimes.getOrDefault(name, 0L).longValue();     // Catch: Throwable -> L126 Throwable -> L126 Throwable -> L167
    L167:
        th = th;
    L36:
        r3 = th;
        goto L37
    L155:
        r4 = true;
        goto L157
    L230:
        if (TextUtils.isEmpty(dialogMessage) == true) goto L147;
        oldSuspendDialogInfo3 = new SuspendDialogInfo.Builder().setMessage(dialogMessage).build();     // Catch: Throwable -> L124 Throwable -> L126
        goto L148
    L124:
        th = th;
    L126:
        e = e;
        goto L40
    L142:
        type5 = type3;
        ps = ps;
        goto L143
    L61:
        Slog.w(PackageManagerServiceMonitorEx.TAG, "No package known for package restrictions " + name);     // Catch: Throwable -> L34 Throwable -> L38 Throwable -> L38
        XmlUtils.skipCurrentTag(r0);     // Catch: Throwable -> L34 Throwable -> L38 Throwable -> L38
        goto L42
    L169:
        distractionFlags2 = r2;
        r33 = r6;
        virtualPreload2 = r7;
        if (tagName.equals("preferred-activities") == false) goto L173;
        readPreferredActivitiesLPw(r0, userId);     // Catch: Throwable -> L163 Throwable -> L165
        goto L189
    L173:
        if (tagName.equals(TAG_PERSISTENT_PREFERRED_ACTIVITIES) == false) goto L176;
        readPersistentPreferredActivitiesLPw(r0, userId);     // Catch: Throwable -> L163 Throwable -> L165
        goto L189
    L176:
        if (tagName.equals(TAG_CROSS_PROFILE_INTENT_FILTERS) == false) goto L179;
        readCrossProfileIntentFiltersLPw(r0, userId);     // Catch: Throwable -> L163 Throwable -> L165
        goto L189
    L179:
        if (tagName.equals(TAG_DEFAULT_APPS) == false) goto L182;
        readDefaultAppsLPw(r0, userId);     // Catch: Throwable -> L163 Throwable -> L165
        goto L189
    L182:
        if (tagName.equals(TAG_BLOCK_UNINSTALL_PACKAGES) == false) goto L185;
        readBlockUninstallPackagesLPw(r0, userId);     // Catch: Throwable -> L163 Throwable -> L165
        goto L189
    L185:
        if (tagName.equals("taskpersist-packages") == false) goto L187;
        Slog.w(TAG, "findstr taskpersist-packages!");     // Catch: Throwable -> L163 Throwable -> L165
        TaskPersistUtil.getInstance().readTaskPersistPackageLPr(this, r0, userId);     // Catch: Throwable -> L163 Throwable -> L165
        goto L189
    L187:
        Slog.w(PackageManagerServiceMonitorEx.TAG, "Unknown element under <stopped-packages>: " + r0.getName());     // Catch: Throwable -> L163 Throwable -> L165
        XmlUtils.skipCurrentTag(r0);     // Catch: Throwable -> L163 Throwable -> L165
    L191:
        r6 = r6;
        r7 = r7;
        r2 = r2;
        outerDepth = outerDepth;
        goto L42
    L47:
        if (r0.getDepth() > outerDepth) goto L50;
    L193:
        atomicFile3 = atomicFile2;
    L34:
        th = th;
    L38:
        e = e;
        goto L40
    L223:
        Iterator<PackageSetting> r1 = this.mPackages.values().iterator();     // Catch: Throwable -> L16
    L10:
        if (r1.hasNext() == false) goto L18;
        PackageSetting pkg = r1.next();     // Catch: Throwable -> L16
        ResilientAtomicFile atomicFile4 = atomicFile;
        Object r10 = r5;
        pkg.setUserState(userId, pkg.getCeDataInode(userId), pkg.getDeDataInode(userId), 0, true, false, false, false, 0, null, false, false, null, null, null, 0, 0, null, null, 0, 0, null);     // Catch: Throwable -> L14
        r5 = r10;
        atomicFile = atomicFile4;
        goto L10
    L18:
        ResilientAtomicFile atomicFile5 = atomicFile;
        monitor-exit(r5);     // Catch: Throwable -> L14
        atomicFile5.close();
        return;
    L16:
        th = th;
        atomicFile2 = atomicFile;
        Object r30 = r5;
        str = str2;
    L232:
        monitor-exit(r30);     // Catch: Throwable -> L200
        throw th;     // Catch: Throwable -> L163 Throwable -> L198
    L198:
        e = e;
    L200:
        th = th;
    L14:
        th = th;
        str = str2;
    L194:
        th = th;
        atomicFile2 = atomicFile;
        r30 = r5;
        goto L232
    L163:
        th = th;
    L204:
        e = e;
        atomicFile2 = atomicFile;
    L202:
        th = move-exception;
        r3 = th;
        atomicFile3 = atomicFile;
        goto L213
    }

    private static Map.Entry<UserPackage, SuspendParams> readSuspensionParamsLPr(int userId, TypedXmlPullParser parser) throws IOException {
        String suspendingPackage = parser.getAttributeValue(null, ATTR_SUSPENDING_PACKAGE);
        if (suspendingPackage != null) goto L7;
        Slog.wtf(TAG, "No suspendingPackage found inside tag suspend-params");
        return null;
    L7:
        return Map.entry(UserPackage.of(userId, suspendingPackage), SuspendParams.restoreFromXml(parser));
    }

    private static ArchiveState parseArchiveState(TypedXmlPullParser parser) throws XmlPullParserException, IOException {
        String installerTitle = parser.getAttributeValue(null, ATTR_ARCHIVE_INSTALLER_TITLE);
        long archiveTimeMillis = parser.getAttributeLongHex(null, ATTR_ARCHIVE_TIME, 0);
        List<ArchiveState.ArchiveActivityInfo> activityInfos = parseArchiveActivityInfos(parser);
        if (installerTitle != null) goto L7;
        Slog.wtf(TAG, "parseArchiveState: installerTitle is null");
        return null;
    L7:
        if (activityInfos.size() >= 1) goto L11;
        Slog.wtf(TAG, "parseArchiveState: activityInfos is empty");
        return null;
    L11:
        return new ArchiveState(activityInfos, installerTitle, archiveTimeMillis);
    }

    private static List<ArchiveState.ArchiveActivityInfo> parseArchiveActivityInfos(TypedXmlPullParser parser) throws XmlPullParserException, IOException {
        List<ArchiveState.ArchiveActivityInfo> activityInfos = new ArrayList();
        int outerDepth = parser.getDepth();
    L3:
        int type = parser.next();
        if (type == 1) goto L37;
        if (type == 3) goto L8;
    L10:
        if (type == 3) goto L3;
        if (type == 4) goto L3;
        String tagName = parser.getName();
        if (tagName == null) goto L3;
        if (tagName.equals(TAG_ARCHIVE_ACTIVITY_INFO) == false) goto L3;
        Path monochromeIconPath = null;
        String title = parser.getAttributeValue(null, ATTR_ARCHIVE_ACTIVITY_TITLE);
        String originalComponentName = parser.getAttributeValue(null, ATTR_ARCHIVE_ORIGINAL_COMPONENT_NAME);
        String iconAttribute = parser.getAttributeValue(null, ATTR_ARCHIVE_ICON_PATH);
        if (iconAttribute != null) goto L22;
        Path iconPath = null;
    L23:
        String monochromeAttribute = parser.getAttributeValue(null, ATTR_ARCHIVE_MONOCHROME_ICON_PATH);
        if (monochromeAttribute == null) goto L28;
        monochromeIconPath = Path.of(monochromeAttribute, new String[0]);
    L28:
        if (title == null) goto L36;
        if (originalComponentName == null) goto L36;
        if (iconPath == null) goto L36;
        ComponentName unflattenOriginalComponentName = ComponentName.unflattenFromString(originalComponentName);
        if (unflattenOriginalComponentName == null) goto L34;
        activityInfos.add(new ArchiveState.ArchiveActivityInfo(title, unflattenOriginalComponentName, iconPath, monochromeIconPath));
        goto L3
    L34:
        Slog.wtf(TAG, "Incorrect component name: " + originalComponentName + " from the attributes");
    L36:
        Slog.wtf(TAG, TextUtils.formatSimple("Missing attributes in tag %s. %s: %s, %s: %s, %s: %s", new Object[]{TAG_ARCHIVE_ACTIVITY_INFO, ATTR_ARCHIVE_ACTIVITY_TITLE, title, ATTR_ARCHIVE_ORIGINAL_COMPONENT_NAME, originalComponentName, ATTR_ARCHIVE_ICON_PATH, iconPath}));
        goto L3
    L22:
        iconPath = Path.of(iconAttribute, new String[0]);
        goto L23
    L8:
        if (parser.getDepth() > outerDepth) goto L10;
    L37:
        return activityInfos;
    }

    void setBlockUninstallLPw(int userId, String packageName, boolean blockUninstall) {
        ArraySet<String> packages = this.mBlockUninstallPackages.get(userId);
        if (blockUninstall == false) goto L7;
        if (packages != null) goto L6;
        packages = new ArraySet();
        this.mBlockUninstallPackages.put(userId, packages);
    L6:
        packages.add(packageName);
        return;
    L7:
        if (packages == null) goto L13;
        packages.remove(packageName);
        if (packages.isEmpty() == false) goto L14;
        this.mBlockUninstallPackages.remove(userId);
        return;
    L14:
        return;
    }

    void clearBlockUninstallLPw(int userId) {
        this.mBlockUninstallPackages.remove(userId);
    }

    boolean getBlockUninstallLPr(int userId, String packageName) {
        ArraySet<String> packages = this.mBlockUninstallPackages.get(userId);
        if (packages != null) goto L7;
        return false;
    L7:
        return packages.contains(packageName);
    }

    private ArraySet<String> readComponentsLPr(TypedXmlPullParser parser) throws IOException, XmlPullParserException {
        ArraySet<String> components = null;
        int outerDepth = parser.getDepth();
    L3:
        int type = parser.next();
        if (type == 1) goto L25;
        if (type == 3) goto L8;
    L10:
        if (type == 3) goto L3;
        if (type == 4) goto L3;
        String tagName = parser.getName();
        if (tagName == null) goto L3;
        if (tagName.equals(TAG_ITEM) == false) goto L3;
        String componentName = parser.getAttributeValue(null, "name");
        if (componentName == null) goto L3;
        if (components != null) goto L23;
        components = new ArraySet();
    L23:
        components.add(componentName);
        goto L3
    L8:
        if (parser.getDepth() > outerDepth) goto L10;
    L25:
        return components;
    }

    void writePreferredActivitiesLPr(TypedXmlSerializer serializer, int userId, boolean full) throws IllegalArgumentException, IllegalStateException, IOException {
        serializer.startTag(null, "preferred-activities");
        PreferredIntentResolver pir = this.mPreferredActivities.get(userId);
        if (pir == null) goto L8;
        Iterator r3 = pir.filterSet().iterator();
    L6:
        if (r3.hasNext() == false) goto L8;
        PreferredActivity pa = (PreferredActivity) r3.next();
        serializer.startTag(null, TAG_ITEM);
        pa.writeToXml(serializer, full);
        serializer.endTag(null, TAG_ITEM);
    L8:
        serializer.endTag(null, "preferred-activities");
    }

    void writePersistentPreferredActivitiesLPr(TypedXmlSerializer serializer, int userId) throws IllegalArgumentException, IllegalStateException, IOException {
        serializer.startTag(null, TAG_PERSISTENT_PREFERRED_ACTIVITIES);
        PersistentPreferredIntentResolver ppir = this.mPersistentPreferredActivities.get(userId);
        if (ppir == null) goto L8;
        Iterator r3 = ppir.filterSet().iterator();
    L6:
        if (r3.hasNext() == false) goto L8;
        PersistentPreferredActivity ppa = (PersistentPreferredActivity) r3.next();
        serializer.startTag(null, TAG_ITEM);
        ppa.writeToXml(serializer);
        serializer.endTag(null, TAG_ITEM);
    L8:
        serializer.endTag(null, TAG_PERSISTENT_PREFERRED_ACTIVITIES);
    }

    void writeCrossProfileIntentFiltersLPr(TypedXmlSerializer serializer, int userId) throws IllegalArgumentException, IllegalStateException, IOException {
        serializer.startTag(null, TAG_CROSS_PROFILE_INTENT_FILTERS);
        CrossProfileIntentResolver cpir = this.mCrossProfileIntentResolvers.get(userId);
        if (cpir == null) goto L8;
        Iterator r3 = cpir.filterSet().iterator();
    L6:
        if (r3.hasNext() == false) goto L8;
        CrossProfileIntentFilter cpif = (CrossProfileIntentFilter) r3.next();
        serializer.startTag(null, TAG_ITEM);
        cpif.writeToXml(serializer);
        serializer.endTag(null, TAG_ITEM);
    L8:
        serializer.endTag(null, TAG_CROSS_PROFILE_INTENT_FILTERS);
    }

    void writeDefaultAppsLPr(XmlSerializer serializer, int userId) throws IllegalArgumentException, IllegalStateException, IOException {
        String defaultBrowser = this.mPendingDefaultBrowser.get(userId);
        writeDefaultApps(serializer, defaultBrowser);
    }

    static void writeDefaultApps(XmlSerializer serializer, String defaultBrowser) throws IllegalArgumentException, IllegalStateException, IOException {
        serializer.startTag(null, TAG_DEFAULT_APPS);
        if (TextUtils.isEmpty(defaultBrowser) == true) goto L5;
        serializer.startTag(null, TAG_DEFAULT_BROWSER);
        serializer.attribute(null, "packageName", defaultBrowser);
        serializer.endTag(null, TAG_DEFAULT_BROWSER);
    L5:
        serializer.endTag(null, TAG_DEFAULT_APPS);
    }

    void writeBlockUninstallPackagesLPr(TypedXmlSerializer serializer, int userId) throws IOException {
        ArraySet<String> packages = this.mBlockUninstallPackages.get(userId);
        if (packages == null) goto L11;
        serializer.startTag(null, TAG_BLOCK_UNINSTALL_PACKAGES);
        int i = 0;
    L6:
        if (i >= packages.size()) goto L8;
        serializer.startTag(null, TAG_BLOCK_UNINSTALL);
        serializer.attribute(null, "packageName", packages.valueAt(i));
        serializer.endTag(null, TAG_BLOCK_UNINSTALL);
        i = i + 1;
        goto L6
    L8:
        serializer.endTag(null, TAG_BLOCK_UNINSTALL_PACKAGES);
        return;
    }

    void writePackageRestrictionsLPr(int userId) {
        writePackageRestrictionsLPr(userId, false);
    }

    void writePackageRestrictionsLPr(final int userId, final boolean sync) {
        invalidatePackageCache();
        final long startTime = SystemClock.uptimeMillis();
        if (sync == false) goto L5;
        writePackageRestrictions(userId, startTime, sync);
        return;
    L5:
        Object r1 = this.mPackageRestrictionsLock;
        monitor-enter(r1);
        int pending = this.mPendingAsyncPackageRestrictionsWrites.get(userId, 0) + 1;     // Catch: Throwable -> L11
        this.mPendingAsyncPackageRestrictionsWrites.put(userId, pending);     // Catch: Throwable -> L11
        monitor-exit(r1);     // Catch: Throwable -> L11
        Runnable r = new Settings$$ExternalSyntheticLambda2(this, userId, startTime, sync);
        this.mHandler.obtainMessage(30, r).sendToTarget();
        return;
    L11:
        th = th;
    L19:
        throw th;
    L15:
        th = th;
        goto L19
    }

    private /* synthetic */ void lambda$writePackageRestrictionsLPr$1(int userId, long startTime, boolean sync) {
        writePackageRestrictions(userId, startTime, sync);
    }

    void writePackageRestrictions(Integer[] userIds) {
        invalidatePackageCache();
        long startTime = SystemClock.uptimeMillis();
        int r2 = userIds.length;
        int r3 = 0;
    L3:
        if (r3 >= r2) goto L5;
        int userId = userIds[r3].intValue();
        writePackageRestrictions(userId, startTime, true);
        r3 = r3 + 1;
        goto L3
    }

    void writePackageRestrictions(int userId, long startTime, boolean sync) {
        ResilientAtomicFile atomicFile = getUserPackagesStateFile(userId);
        Object r5 = this.mPackageRestrictionsLock;     // Catch: Throwable -> L112 IOException -> L114
        monitor-enter(r5);     // Catch: Throwable -> L112 IOException -> L114
        boolean r0 = false;
        if (sync == false) goto L146;
    L144:
        FileOutputStream str = atomicFile.startWrite();     // Catch: Throwable -> L14 IOException -> L119
    L19:
        monitor-exit(r5);     // Catch: Throwable -> L14
        PackageManagerTracedLock r6 = this.mLock;     // Catch: Throwable -> L112 IOException -> L114
        PackageManagerService.boostPriorityForPackageManagerTracedLockedSection();     // Catch: Throwable -> L112 IOException -> L114
        monitor-enter(r6);     // Catch: Throwable -> L112 IOException -> L114
        TypedXmlSerializer serializer = Xml.resolveSerializer(str);     // Catch: Throwable -> L28
        serializer.startDocument(null, true);     // Catch: Throwable -> L28
        serializer.setFeature("http://xmlpull.org/v1/doc/features.html#indent-output", true);     // Catch: Throwable -> L28
        serializer.startTag(null, TAG_PACKAGE_RESTRICTIONS);     // Catch: Throwable -> L28
        Iterator<PackageSetting> r8 = this.mPackages.values().iterator();     // Catch: Throwable -> L28
    L24:
        if (r8.hasNext() == false) goto L107;
        PackageSetting pkg = r8.next();     // Catch: Throwable -> L28
        PackageUserStateInternal ustate = pkg.readUserState(userId);     // Catch: Throwable -> L28
        serializer.startTag(null, "pkg");     // Catch: Throwable -> L28
        serializer.attribute(null, "name", pkg.getPackageName());     // Catch: Throwable -> L28
        if (ustate.getCeDataInode() == 0) goto L32;
        serializer.attributeLong(null, ATTR_CE_DATA_INODE, ustate.getCeDataInode());     // Catch: Throwable -> L28
    L32:
        if (ustate.getDeDataInode() == 0) goto L35;
        serializer.attributeLong(null, ATTR_DE_DATA_INODE, ustate.getDeDataInode());     // Catch: Throwable -> L28
    L35:
        if (ustate.isInstalled() == true) goto L38;
        serializer.attributeBoolean(null, ATTR_INSTALLED, r0);     // Catch: Throwable -> L28
    L38:
        if (ustate.isStopped() == false) goto L41;
        serializer.attributeBoolean(null, ATTR_STOPPED, true);     // Catch: Throwable -> L28
    L41:
        if (ustate.isNotLaunched() == false) goto L44;
        serializer.attributeBoolean(null, ATTR_NOT_LAUNCHED, true);     // Catch: Throwable -> L28
    L44:
        if (ustate.isHidden() == false) goto L47;
        serializer.attributeBoolean(null, ATTR_HIDDEN, true);     // Catch: Throwable -> L28
    L47:
        if (ustate.getDistractionFlags() == 0) goto L50;
        serializer.attributeInt(null, ATTR_DISTRACTION_FLAGS, ustate.getDistractionFlags());     // Catch: Throwable -> L28
    L50:
        if (ustate.isSuspended() == false) goto L53;
        serializer.attributeBoolean(null, ATTR_SUSPENDED, true);     // Catch: Throwable -> L28
    L53:
        if (ustate.isInstantApp() == false) goto L56;
        serializer.attributeBoolean(null, ATTR_INSTANT_APP, true);     // Catch: Throwable -> L28
    L56:
        if (ustate.isVirtualPreload() == false) goto L59;
        serializer.attributeBoolean(null, ATTR_VIRTUAL_PRELOAD, true);     // Catch: Throwable -> L28
    L59:
        if (ustate.getEnabledState() == 0) goto L62;
        serializer.attributeInt(null, "enabled", ustate.getEnabledState());     // Catch: Throwable -> L28
    L62:
        if (ustate.getLastDisableAppCaller() == null) goto L65;
        serializer.attribute(null, ATTR_ENABLED_CALLER, ustate.getLastDisableAppCaller());     // Catch: Throwable -> L28
    L65:
        if (ustate.getInstallReason() == 0) goto L67;
        serializer.attributeInt(null, ATTR_INSTALL_REASON, ustate.getInstallReason());     // Catch: Throwable -> L28
    L67:
        serializer.attributeLongHex(null, ATTR_FIRST_INSTALL_TIME, ustate.getFirstInstallTimeMillis());     // Catch: Throwable -> L28
        if (ustate.getUninstallReason() == 0) goto L71;
        serializer.attributeInt(null, ATTR_UNINSTALL_REASON, ustate.getUninstallReason());     // Catch: Throwable -> L28
    L71:
        if (ustate.getHarmfulAppWarning() == null) goto L74;
        serializer.attribute(null, ATTR_HARMFUL_APP_WARNING, ustate.getHarmfulAppWarning());     // Catch: Throwable -> L28
    L74:
        if (ustate.getSplashScreenTheme() == null) goto L77;
        serializer.attribute(null, ATTR_SPLASH_SCREEN_THEME, ustate.getSplashScreenTheme());     // Catch: Throwable -> L28
    L77:
        if (ustate.getMinAspectRatio() == 0) goto L80;
        serializer.attributeInt(null, ATTR_MIN_ASPECT_RATIO, ustate.getMinAspectRatio());     // Catch: Throwable -> L28
    L80:
        if (ustate.isSuspended() == false) goto L88;
        int i = 0;
    L83:
        if (i >= ustate.getSuspendParams().size()) goto L88;
        UserPackage suspendingPackage = ustate.getSuspendParams().keyAt(i);     // Catch: Throwable -> L28
        serializer.startTag(null, TAG_SUSPEND_PARAMS);     // Catch: Throwable -> L28
        serializer.attribute(null, ATTR_SUSPENDING_PACKAGE, suspendingPackage.packageName);     // Catch: Throwable -> L28
        SuspendParams params = ustate.getSuspendParams().valueAt(i);     // Catch: Throwable -> L28
        if (params == null) goto L87;
        params.saveToXml(serializer);     // Catch: Throwable -> L28
    L87:
        serializer.endTag(null, TAG_SUSPEND_PARAMS);     // Catch: Throwable -> L28
        i = i + 1;     // Catch: Throwable -> L28
    L88:
        ArraySet<String> enabledComponents = ustate.getEnabledComponents();     // Catch: Throwable -> L28
        if (enabledComponents != null) goto L91;
    L97:
        ArraySet<String> disabledComponents = ustate.getDisabledComponents();     // Catch: Throwable -> L28
        if (disabledComponents == null) goto L106;
        if (disabledComponents.size() <= 0) goto L106;
        serializer.startTag(null, TAG_DISABLED_COMPONENTS);     // Catch: Throwable -> L28
        int i2 = 0;
    L103:
        if (i2 >= disabledComponents.size()) goto L105;
        serializer.startTag(null, TAG_ITEM);     // Catch: Throwable -> L28
        serializer.attribute(null, "name", disabledComponents.valueAt(i2));     // Catch: Throwable -> L28
        serializer.endTag(null, TAG_ITEM);     // Catch: Throwable -> L28
        i2 = i2 + 1;     // Catch: Throwable -> L28
        goto L103
    L105:
        serializer.endTag(null, TAG_DISABLED_COMPONENTS);     // Catch: Throwable -> L28
    L106:
        writeArchiveStateLPr(serializer, ustate.getArchiveState());     // Catch: Throwable -> L28
        serializer.endTag(null, "pkg");     // Catch: Throwable -> L28
        r0 = false;
        goto L24
    L91:
        if (enabledComponents.size() <= 0) goto L97;
        serializer.startTag(null, TAG_ENABLED_COMPONENTS);     // Catch: Throwable -> L28
        int i3 = 0;
    L94:
        if (i3 >= enabledComponents.size()) goto L96;
        serializer.startTag(null, TAG_ITEM);     // Catch: Throwable -> L28
        serializer.attribute(null, "name", enabledComponents.valueAt(i3));     // Catch: Throwable -> L28
        serializer.endTag(null, TAG_ITEM);     // Catch: Throwable -> L28
        i3 = i3 + 1;     // Catch: Throwable -> L28
        goto L94
    L96:
        serializer.endTag(null, TAG_ENABLED_COMPONENTS);     // Catch: Throwable -> L28
        goto L97
    L107:
        writePreferredActivitiesLPr(serializer, userId, true);     // Catch: Throwable -> L28
        writePersistentPreferredActivitiesLPr(serializer, userId);     // Catch: Throwable -> L28
        writeCrossProfileIntentFiltersLPr(serializer, userId);     // Catch: Throwable -> L28
        writeDefaultAppsLPr(serializer, userId);     // Catch: Throwable -> L28
        writeBlockUninstallPackagesLPr(serializer, userId);     // Catch: Throwable -> L28
        TaskPersistUtil.getInstance().writeTaskPersistPackageLPr(serializer, userId);     // Catch: Throwable -> L28
        serializer.endTag(null, TAG_PACKAGE_RESTRICTIONS);     // Catch: Throwable -> L28
        serializer.endDocument();     // Catch: Throwable -> L28
        monitor-exit(r6);     // Catch: Throwable -> L28
        PackageManagerService.resetPriorityAfterPackageManagerTracedLockedSection();     // Catch: Throwable -> L112 IOException -> L114
        atomicFile.finishWrite(str);     // Catch: Throwable -> L112 IOException -> L114
        EventLogTags.writeCommitSysConfigFile("package-user-" + userId, SystemClock.uptimeMillis() - startTime);     // Catch: Throwable -> L112 IOException -> L114
        atomicFile.close();
        return;
    L28:
        th = move-exception;
        PackageManagerService.resetPriorityAfterPackageManagerTracedLockedSection();     // Catch: Throwable -> L112 IOException -> L114
        throw th;     // Catch: Throwable -> L112 IOException -> L114
    L119:
        e = move-exception;
        Slog.wtf(PackageManagerServiceMonitorEx.TAG, "Unable to write package manager package restrictions,  current changes will be lost at reboot", e);     // Catch: Throwable -> L14
        if (atomicFile == null) goto L159;
        atomicFile.close();
        return;
    L159:
        return;
    L14:
        th = move-exception;
        throw th;     // Catch: Throwable -> L112 IOException -> L114
    L146:
        int pending = this.mPendingAsyncPackageRestrictionsWrites.get(userId, 0) - 1;     // Catch: Throwable -> L14
        if (pending >= 0) goto L16;
        Log.i(TAG, "Cancel writing package restrictions for user=" + userId);     // Catch: Throwable -> L14
        monitor-exit(r5);     // Catch: Throwable -> L14
        if (atomicFile == null) goto L158;
        atomicFile.close();
        return;
    L158:
        return;
    L16:
        this.mPendingAsyncPackageRestrictionsWrites.put(userId, pending);     // Catch: Throwable -> L14
    L114:
        e = move-exception;
        Slog.wtf(PackageManagerServiceMonitorEx.TAG, "Unable to write package manager package restrictions,  current changes will be lost at reboot", e);     // Catch: Throwable -> L112
        if (0 == 0) goto L131;
        atomicFile.failWrite(null);     // Catch: Throwable -> L112
    L131:
        if (atomicFile == null) goto L160;
        atomicFile.close();
        return;
    L160:
        return;
    L112:
        th = move-exception;
        if (atomicFile == null) goto L161;
        atomicFile.close();     // Catch: Throwable -> L137
        throw th;
    L137:
        th = move-exception;
        th.addSuppressed(th);
        throw th;
    L161:
        throw th;
    }

    private void writeArchiveStateLPr(TypedXmlSerializer serializer, ArchiveState archiveState) throws IOException {
        if (archiveState != null) goto L4;
        return;
    L4:
        serializer.startTag(null, TAG_ARCHIVE_STATE);
        serializer.attribute(null, ATTR_ARCHIVE_INSTALLER_TITLE, archiveState.getInstallerTitle());
        serializer.attributeLongHex(null, ATTR_ARCHIVE_TIME, archiveState.getArchiveTimeMillis());
        Iterator<ArchiveState.ArchiveActivityInfo> r2 = archiveState.getActivityInfos().iterator();
    L6:
        if (r2.hasNext() == false) goto L14;
        ArchiveState.ArchiveActivityInfo activityInfo = r2.next();
        serializer.startTag(null, TAG_ARCHIVE_ACTIVITY_INFO);
        serializer.attribute(null, ATTR_ARCHIVE_ACTIVITY_TITLE, activityInfo.getTitle());
        serializer.attribute(null, ATTR_ARCHIVE_ORIGINAL_COMPONENT_NAME, activityInfo.getOriginalComponentName().flattenToString());
        if (activityInfo.getIconBitmap() == null) goto L11;
        serializer.attribute(null, ATTR_ARCHIVE_ICON_PATH, activityInfo.getIconBitmap().toAbsolutePath().toString());
    L11:
        if (activityInfo.getMonochromeIconBitmap() == null) goto L13;
        serializer.attribute(null, ATTR_ARCHIVE_MONOCHROME_ICON_PATH, activityInfo.getMonochromeIconBitmap().toAbsolutePath().toString());
    L13:
        serializer.endTag(null, TAG_ARCHIVE_ACTIVITY_INFO);
        goto L6
    L14:
        serializer.endTag(null, TAG_ARCHIVE_STATE);
    }

    void readInstallPermissionsLPr(TypedXmlPullParser parser, LegacyPermissionState permissionsState, List<UserInfo> users) throws IOException, XmlPullParserException {
        int outerDepth = parser.getDepth();
    L3:
        int type = parser.next();
        if (type == 1) goto L26;
        if (type == 3) goto L8;
    L10:
        if (type == 3) goto L3;
        if (type == 4) goto L3;
        String tagName = parser.getName();
        if (tagName == null) goto L3;
        if (tagName.equals(TAG_ITEM) == true) goto L19;
        Slog.w(PackageManagerServiceMonitorEx.TAG, "Unknown element under <permissions>: " + parser.getName());
        XmlUtils.skipCurrentTag(parser);
        goto L3
    L19:
        String name = parser.getAttributeValue(null, "name");
        boolean granted = parser.getAttributeBoolean(null, ATTR_GRANTED, true);
        int flags = parser.getAttributeIntHex(null, ATTR_FLAGS, 0);
        Iterator<UserInfo> r6 = users.iterator();
    L21:
        if (r6.hasNext() == false) goto L3;
        UserInfo user = r6.next();
        permissionsState.putPermissionState(new LegacyPermissionState.PermissionState(name, false, granted, flags), user.id);
        goto L21
    L8:
        if (parser.getDepth() > outerDepth) goto L10;
        return;
    }

    void readUsesSdkLibLPw(TypedXmlPullParser parser, PackageSetting outPs) throws IOException, XmlPullParserException {
        String libName = parser.getAttributeValue(null, "name");
        long libVersion = parser.getAttributeLong(null, "version", -1);
        boolean optional = parser.getAttributeBoolean(null, ATTR_OPTIONAL, true);
        if (libName != null) goto L5;
    L10:
        XmlUtils.skipCurrentTag(parser);
        return;
    L5:
        if (libVersion < 0) goto L10;
        int beforeUsesSdkLibrariesLength = outPs.getUsesSdkLibraries().length;
        outPs.setUsesSdkLibraries((String[]) ArrayUtils.appendElement(String.class, outPs.getUsesSdkLibraries(), libName));
        int afterUsesSdkLibrariesLength = outPs.getUsesSdkLibraries().length;
        if (beforeUsesSdkLibrariesLength != afterUsesSdkLibrariesLength) goto L9;
        int index = ArrayUtils.indexOf(outPs.getUsesSdkLibraries(), libName);
        long[] usesSdkLibrariesVersionsMajor = outPs.getUsesSdkLibrariesVersionsMajor();
        usesSdkLibrariesVersionsMajor[index] = libVersion;
        outPs.setUsesSdkLibrariesVersionsMajor(usesSdkLibrariesVersionsMajor);
        boolean[] usesSdkLibrariesOptional = outPs.getUsesSdkLibrariesOptional();
        usesSdkLibrariesOptional[index] = optional;
        outPs.setUsesSdkLibrariesOptional(usesSdkLibrariesOptional);
        goto L10
    L9:
        outPs.setUsesSdkLibrariesVersionsMajor(ArrayUtils.appendLong(outPs.getUsesSdkLibrariesVersionsMajor(), libVersion, true));
        outPs.setUsesSdkLibrariesOptional(ArrayUtils.appendBooleanDuplicatesAllowed(outPs.getUsesSdkLibrariesOptional(), optional));
        goto L10
    }

    void readUsesStaticLibLPw(TypedXmlPullParser parser, PackageSetting outPs) throws IOException, XmlPullParserException {
        String libName = parser.getAttributeValue(null, "name");
        long libVersion = parser.getAttributeLong(null, "version", -1);
        if (libName != null) goto L5;
    L10:
        XmlUtils.skipCurrentTag(parser);
        return;
    L5:
        if (libVersion < 0) goto L10;
        int beforeUsesStaticLibrariesLength = outPs.getUsesStaticLibraries().length;
        outPs.setUsesStaticLibraries((String[]) ArrayUtils.appendElement(String.class, outPs.getUsesStaticLibraries(), libName));
        int afterUsesStaticLibrariesLength = outPs.getUsesStaticLibraries().length;
        if (beforeUsesStaticLibrariesLength != afterUsesStaticLibrariesLength) goto L9;
        int index = ArrayUtils.indexOf(outPs.getUsesStaticLibraries(), libName);
        long[] usesStaticLibrariesVersions = outPs.getUsesStaticLibrariesVersions();
        usesStaticLibrariesVersions[index] = libVersion;
        outPs.setUsesStaticLibrariesVersions(usesStaticLibrariesVersions);
        goto L10
    L9:
        outPs.setUsesStaticLibrariesVersions(ArrayUtils.appendLong(outPs.getUsesStaticLibrariesVersions(), libVersion, true));
        goto L10
    }

    void writeUsesSdkLibLPw(TypedXmlSerializer serializer, String[] usesSdkLibraries, long[] usesSdkLibraryVersions, boolean[] usesSdkLibrariesOptional) throws IOException {
        if (ArrayUtils.isEmpty(usesSdkLibraries) == false) goto L5;
        return;
    L5:
        if (ArrayUtils.isEmpty(usesSdkLibraryVersions) == false) goto L7;
        return;
    L7:
        if (usesSdkLibraries.length != usesSdkLibraryVersions.length) goto L17;
        int libCount = usesSdkLibraries.length;
        int i = 0;
    L10:
        if (i >= libCount) goto L13;
        String libName = usesSdkLibraries[i];
        long libVersion = usesSdkLibraryVersions[i];
        boolean libOptional = usesSdkLibrariesOptional[i];
        serializer.startTag(null, TAG_USES_SDK_LIB);
        serializer.attribute(null, "name", libName);
        serializer.attributeLong(null, "version", libVersion);
        serializer.attributeBoolean(null, ATTR_OPTIONAL, libOptional);
        serializer.endTag(null, TAG_USES_SDK_LIB);
        i = i + 1;
        goto L10
    L13:
        return;
    }

    void writeUsesStaticLibLPw(TypedXmlSerializer serializer, String[] usesStaticLibraries, long[] usesStaticLibraryVersions) throws IOException {
        if (ArrayUtils.isEmpty(usesStaticLibraries) == false) goto L5;
        return;
    L5:
        if (ArrayUtils.isEmpty(usesStaticLibraryVersions) == false) goto L7;
        return;
    L7:
        if (usesStaticLibraries.length != usesStaticLibraryVersions.length) goto L17;
        int libCount = usesStaticLibraries.length;
        int i = 0;
    L10:
        if (i >= libCount) goto L13;
        String libName = usesStaticLibraries[i];
        long libVersion = usesStaticLibraryVersions[i];
        serializer.startTag(null, TAG_USES_STATIC_LIB);
        serializer.attribute(null, "name", libName);
        serializer.attributeLong(null, "version", libVersion);
        serializer.endTag(null, TAG_USES_STATIC_LIB);
        i = i + 1;
        goto L10
    L13:
        return;
    }

    void readStoppedLPw() {
        FileInputStream str = null;
        int r3 = 4;
        if (this.mBackupStoppedPackagesFilename.exists() == true) goto L65;
    L11:
        int r0 = 0;
        if (str == null) goto L67;
    L25:
        TypedXmlPullParser parser = Xml.resolvePullParser(str);     // Catch: IOException -> L19 XmlPullParserException -> L21
    L26:
        int type = parser.next();     // Catch: IOException -> L19 XmlPullParserException -> L21
        if (type == 2) goto L30;
        if (type != 1) goto L26;
    L30:
        if (type == 2) goto L33;
        this.mReadMessages.append("No start tag found in stopped packages file\n");     // Catch: IOException -> L19 XmlPullParserException -> L21
        PackageManagerService.reportSettingsProblem(5, "No start tag found in package manager stopped packages");     // Catch: IOException -> L19 XmlPullParserException -> L21
        return;
    L33:
        int outerDepth = parser.getDepth();     // Catch: IOException -> L19 XmlPullParserException -> L21
    L34:
        int type2 = parser.next();     // Catch: IOException -> L19 XmlPullParserException -> L21
        if (type2 == 1) goto L60;
        if (type2 == 3) goto L39;
    L41:
        if (type2 == 3) goto L59;
        if (type2 == r3) goto L59;
        String tagName = parser.getName();     // Catch: IOException -> L19 XmlPullParserException -> L21
        if (tagName == null) goto L59;
        if (tagName.equals("pkg") == false) goto L57;
        String name = parser.getAttributeValue(null, "name");     // Catch: IOException -> L19 XmlPullParserException -> L21
        PackageSetting ps = this.mPackages.get(name);     // Catch: IOException -> L19 XmlPullParserException -> L21
        if (ps == null) goto L55;
        ps.setStopped(true, r0);     // Catch: IOException -> L19 XmlPullParserException -> L21
        if ("1".equals(parser.getAttributeValue(null, ATTR_NOT_LAUNCHED)) == false) goto L54;
        r0 = 0;
        ps.setNotLaunched(true, 0);     // Catch: IOException -> L19 XmlPullParserException -> L21
    L56:
        XmlUtils.skipCurrentTag(parser);     // Catch: IOException -> L19 XmlPullParserException -> L21
        goto L59
    L54:
        r0 = 0;
        goto L56
    L55:
        Slog.w(PackageManagerServiceMonitorEx.TAG, "No package known for stopped package " + name);     // Catch: IOException -> L19 XmlPullParserException -> L21
        goto L56
    L57:
        Slog.w(PackageManagerServiceMonitorEx.TAG, "Unknown element under <stopped-packages>: " + parser.getName());     // Catch: IOException -> L19 XmlPullParserException -> L21
        XmlUtils.skipCurrentTag(parser);     // Catch: IOException -> L19 XmlPullParserException -> L21
    L59:
        r3 = 4;
        goto L34
    L39:
        if (parser.getDepth() > outerDepth) goto L41;
    L60:
        str.close();     // Catch: IOException -> L19 XmlPullParserException -> L21
        return;
    L67:
    L19:
        e = move-exception;
        this.mReadMessages.append("Error reading: " + e.toString());
        PackageManagerService.reportSettingsProblem(6, "Error reading stopped packages: " + e);
        Slog.wtf(PackageManagerServiceMonitorEx.TAG, "Error reading package manager stopped packages", e);
        return;
    L21:
        e = move-exception;
        this.mReadMessages.append("Error reading: " + e.toString());
        PackageManagerService.reportSettingsProblem(6, "Error reading stopped packages: " + e);
        Slog.wtf(PackageManagerServiceMonitorEx.TAG, "Error reading package manager stopped packages", e);
        return;
    L14:
        if (this.mStoppedPackagesFilename.exists() == true) goto L24;
        this.mReadMessages.append("No stopped packages file found\n");     // Catch: IOException -> L19 XmlPullParserException -> L21
        PackageManagerService.reportSettingsProblem(4, "No stopped packages file file; assuming all started");     // Catch: IOException -> L19 XmlPullParserException -> L21
        Iterator<PackageSetting> r4 = this.mPackages.values().iterator();     // Catch: IOException -> L19 XmlPullParserException -> L21
    L17:
        if (r4.hasNext() == false) goto L23;
        PackageSetting pkg = r4.next();     // Catch: IOException -> L19 XmlPullParserException -> L21
        pkg.setStopped(false, 0);     // Catch: IOException -> L19 XmlPullParserException -> L21
        pkg.setNotLaunched(false, 0);     // Catch: IOException -> L19 XmlPullParserException -> L21
        goto L17
    L23:
        return;
    L24:
        str = new FileInputStream(this.mStoppedPackagesFilename);     // Catch: IOException -> L19 XmlPullParserException -> L21
        goto L25
    L65:
        str = new FileInputStream(this.mBackupStoppedPackagesFilename);     // Catch: IOException -> L8
        this.mReadMessages.append("Reading from backup stopped packages file\n");     // Catch: IOException -> L8
        PackageManagerService.reportSettingsProblem(4, "Need to read from backup stopped packages file");     // Catch: IOException -> L8
        if (this.mStoppedPackagesFilename.exists() == false) goto L11;
        Slog.w(PackageManagerServiceMonitorEx.TAG, "Cleaning up stopped packages file " + this.mStoppedPackagesFilename);     // Catch: IOException -> L8
        this.mStoppedPackagesFilename.delete();     // Catch: IOException -> L8
        goto L11
    }

    void writeLPr(Computer computer, boolean sync) {
        long startTime = SystemClock.uptimeMillis();
        invalidatePackageCache();
        ArrayList<Signature> writtenSignatures = new ArrayList();
        ResilientAtomicFile atomicFile = getSettingsFile();
        FileOutputStream str = null;
        str = atomicFile.startWrite();     // Catch: Throwable -> L68 IOException -> L70
        TypedXmlSerializer serializer = Xml.resolveSerializer(str);     // Catch: Throwable -> L68 IOException -> L70
        serializer.startDocument(null, true);     // Catch: Throwable -> L68 IOException -> L70
        serializer.setFeature("http://xmlpull.org/v1/doc/features.html#indent-output", true);     // Catch: Throwable -> L68 IOException -> L70
        serializer.startTag(null, "packages");     // Catch: Throwable -> L68 IOException -> L70
        int i = 0;
    L4:
        if (i >= this.mVersion.size()) goto L22;
        String volumeUuid = this.mVersion.keyAt(i);     // Catch: Throwable -> L16 IOException -> L19
        long startTime2 = startTime;
        VersionInfo ver = this.mVersion.valueAt(i);     // Catch: Throwable -> L9 IOException -> L13
        serializer.startTag(null, "version");     // Catch: Throwable -> L9 IOException -> L13
        XmlUtils.writeStringAttribute(serializer, ATTR_VOLUME_UUID, volumeUuid);     // Catch: Throwable -> L9 IOException -> L13
        int i2 = i;
        int i3 = ver.sdkVersion;     // Catch: Throwable -> L9 IOException -> L13
        serializer.attributeInt(null, ATTR_SDK_VERSION, i3);     // Catch: Throwable -> L9 IOException -> L13
        serializer.attributeInt(null, ATTR_DATABASE_VERSION, ver.databaseVersion);     // Catch: Throwable -> L9 IOException -> L13
        XmlUtils.writeStringAttribute(serializer, ATTR_BUILD_FINGERPRINT, ver.buildFingerprint);     // Catch: Throwable -> L9 IOException -> L13
        XmlUtils.writeStringAttribute(serializer, ATTR_FINGERPRINT, ver.fingerprint);     // Catch: Throwable -> L9 IOException -> L13
        serializer.endTag(null, "version");     // Catch: Throwable -> L9 IOException -> L13
        i = i2 + 1;     // Catch: Throwable -> L9 IOException -> L13
        startTime = startTime2;
    L13:
        e = e;
    L73:
        Slog.wtf(PackageManagerServiceMonitorEx.TAG, "Unable to write package manager settings, current changes will be lost at reboot", e);     // Catch: Throwable -> L60
        if (str == null) goto L76;
        atomicFile.failWrite(str);     // Catch: Throwable -> L60
    L60:
        Throwable th = th;
    L12:
        Throwable r3 = th;
    L79:
        if (atomicFile == null) goto L116;
        atomicFile.close();     // Catch: Throwable -> L82
        throw r3;
    L82:
        th = move-exception;
        r3.addSuppressed(th);
        throw r3;
    L116:
        throw r3;
    L76:
        if (atomicFile == null) goto L115;
        atomicFile.close();
        return;
    L115:
        return;
    L9:
        th = th;
        goto L12
    L19:
        e = e;
    L16:
        th = th;
    L18:
        r3 = th;
        goto L79
    L22:
        long startTime3 = startTime;
        if (this.mVerifierDeviceIdentity == null) goto L25;
        serializer.startTag(null, "verifier");     // Catch: Throwable -> L9 IOException -> L13
        serializer.attribute(null, "device", this.mVerifierDeviceIdentity.toString());     // Catch: Throwable -> L9 IOException -> L13
        serializer.endTag(null, "verifier");     // Catch: Throwable -> L9 IOException -> L13
    L25:
        serializer.startTag(null, "permission-trees");     // Catch: Throwable -> L9 IOException -> L13
        this.mPermissions.writePermissionTrees(serializer);     // Catch: Throwable -> L9 IOException -> L13
        serializer.endTag(null, "permission-trees");     // Catch: Throwable -> L9 IOException -> L13
        serializer.startTag(null, "permissions");     // Catch: Throwable -> L9 IOException -> L13
        this.mPermissions.writePermissions(serializer);     // Catch: Throwable -> L9 IOException -> L13
        serializer.endTag(null, "permissions");     // Catch: Throwable -> L9 IOException -> L13
        Iterator<PackageSetting> r4 = this.mPackages.values().iterator();     // Catch: Throwable -> L9 IOException -> L13
    L27:
        if (r4.hasNext() == false) goto L34;
        PackageSetting pkg = r4.next();     // Catch: Throwable -> L9 IOException -> L13
        if (pkg.getPkg() == null) goto L33;
        if (pkg.getPkg().isApex() == true) goto L27;
    L33:
        writePackageLPr(serializer, writtenSignatures, pkg);     // Catch: Throwable -> L9 IOException -> L13
        goto L27
    L34:
        Iterator<PackageSetting> r5 = this.mDisabledSysPackages.values().iterator();     // Catch: Throwable -> L9 IOException -> L13
    L36:
        if (r5.hasNext() == false) goto L43;
        PackageSetting pkg2 = r5.next();     // Catch: Throwable -> L9 IOException -> L13
        if (pkg2.getPkg() == null) goto L42;
        if (pkg2.getPkg().isApex() == true) goto L36;
    L42:
        writeDisabledSysPackageLPr(serializer, pkg2);     // Catch: Throwable -> L9 IOException -> L13
        goto L36
    L43:
        Iterator<SharedUserSetting> r6 = this.mSharedUsers.values().iterator();     // Catch: Throwable -> L9 IOException -> L13
    L45:
        if (r6.hasNext() == false) goto L48;
        SharedUserSetting usr = r6.next();     // Catch: Throwable -> L9 IOException -> L13
        serializer.startTag(null, TAG_SHARED_USER);     // Catch: Throwable -> L9 IOException -> L13
        serializer.attribute(null, "name", usr.name);     // Catch: Throwable -> L9 IOException -> L13
        serializer.attributeInt(null, "userId", usr.mAppId);     // Catch: Throwable -> L9 IOException -> L13
        usr.signatures.writeXml(serializer, "sigs", writtenSignatures);     // Catch: Throwable -> L9 IOException -> L13
        serializer.endTag(null, TAG_SHARED_USER);     // Catch: Throwable -> L9 IOException -> L13
        goto L45
    L48:
        if (this.mRenamedPackages.size() <= 0) goto L53;
        Iterator<Map.Entry<String, String>> r2 = this.mRenamedPackages.entrySet().iterator();     // Catch: Throwable -> L9 IOException -> L13
    L51:
        if (r2.hasNext() == false) goto L53;
        Map.Entry<String, String> e = r2.next();     // Catch: Throwable -> L9 IOException -> L13
        serializer.startTag(null, "renamed-package");     // Catch: Throwable -> L9 IOException -> L13
        serializer.attribute(null, "new", e.getKey());     // Catch: Throwable -> L9 IOException -> L13
        serializer.attribute(null, "old", e.getValue());     // Catch: Throwable -> L9 IOException -> L13
        serializer.endTag(null, "renamed-package");     // Catch: Throwable -> L9 IOException -> L13
    L53:
    L90:
        this.mDomainVerificationManager.writeSettings(computer, serializer, false, -1);     // Catch: Throwable -> L64 IOException -> L66
        this.mKeySetManagerService.writeKeySetManagerServiceLPr(serializer);     // Catch: Throwable -> L64 IOException -> L66
        serializer.endTag(null, "packages");     // Catch: Throwable -> L64 IOException -> L66
        serializer.endDocument();     // Catch: Throwable -> L64 IOException -> L66
        atomicFile.finishWrite(str);     // Catch: Throwable -> L64 IOException -> L66
        writeKernelMappingLPr();     // Catch: Throwable -> L64 IOException -> L66
        writePackageListLPr();     // Catch: Throwable -> L64 IOException -> L66
    L87:
        writeAllUsersPackageRestrictionsLPr(sync);     // Catch: Throwable -> L60 IOException -> L62
        writeAllRuntimePermissionsLPr();     // Catch: Throwable -> L60 IOException -> L62
        EventLogTags.writeCommitSysConfigFile(ATTR_PACKAGE, SystemClock.uptimeMillis() - startTime3);     // Catch: Throwable -> L60 IOException -> L62
        atomicFile.close();
        return;
    L62:
        e = e;
    L66:
        e = e;
    L64:
        th = th;
        goto L12
    L70:
        e = e;
    L68:
        th = th;
        goto L18
    }

    private void writeKernelRemoveUserLPr(int userId) {
        if (this.mKernelMappingFilename != null) goto L5;
        return;
    L5:
        File removeUserIdFile = new File(this.mKernelMappingFilename, "remove_userid");
        writeIntToFile(removeUserIdFile, userId);
    }

    void writeKernelMappingLPr() {
        if (this.mKernelMappingFilename != null) goto L5;
        return;
    L5:
        String[] known = this.mKernelMappingFilename.list();
        ArraySet<String> knownSet = new ArraySet(known.length);
        int r2 = known.length;
        int r3 = 0;
    L6:
        if (r3 >= r2) goto L8;
        knownSet.add(known[r3]);
        r3 = r3 + 1;
        goto L6
    L8:
        Iterator<PackageSetting> r4 = this.mPackages.values().iterator();
    L10:
        if (r4.hasNext() == false) goto L12;
        PackageSetting ps = r4.next();
        knownSet.remove(ps.getPackageName());
        writeKernelMappingLPr(ps);
        goto L10
    L12:
        int i = 0;
    L14:
        if (i >= knownSet.size()) goto L17;
        String name = knownSet.valueAt(i);
        this.mKernelMapping.remove(name);
        new File(this.mKernelMappingFilename, name).delete();
        i = i + 1;
        goto L14
    }

    void writeKernelMappingLPr(PackageSetting ps) {
        if (this.mKernelMappingFilename == null) goto L10;
        if (ps != null) goto L6;
        return;
    L6:
        if (ps.getPackageName() == null) goto L12;
        writeKernelMappingLPr(ps.getPackageName(), ps.getAppId(), ps.getNotInstalledUserIds());
        return;
    L12:
        return;
    }

    void writeKernelMappingLPr(String name, int appId, int[] excludedUserIds) {
        KernelPackageState cur = this.mKernelMapping.get(name);
        boolean userIdsChanged = false;
        if (cur != null) goto L5;
        boolean firstTime = true;
    L7:
        if (firstTime == false) goto L9;
    L10:
        userIdsChanged = true;
    L11:
        File dir = new File(this.mKernelMappingFilename, name);
        if (firstTime == false) goto L15;
        dir.mkdir();
        cur = new KernelPackageState(null);
        this.mKernelMapping.put(name, cur);
    L15:
        if (cur.appId == appId) goto L17;
        File appIdFile = new File(dir, "appid");
        writeIntToFile(appIdFile, appId);
    L17:
        if (userIdsChanged == false) goto L44;
        int i = 0;
    L20:
        if (i >= excludedUserIds.length) goto L28;
        if (cur.excludedUserIds != null) goto L24;
    L25:
        writeIntToFile(new File(dir, "excluded_userids"), excludedUserIds[i]);
    L26:
        i = i + 1;
        goto L20
    L24:
        if (ArrayUtils.contains(cur.excludedUserIds, excludedUserIds[i]) == true) goto L26;
    L28:
        if (cur.excludedUserIds == null) goto L36;
        int i2 = 0;
    L31:
        if (i2 >= cur.excludedUserIds.length) goto L36;
        if (ArrayUtils.contains(excludedUserIds, cur.excludedUserIds[i2]) == true) goto L35;
        writeIntToFile(new File(dir, "clear_userid"), cur.excludedUserIds[i2]);
    L35:
        i2 = i2 + 1;
    L36:
        cur.excludedUserIds = excludedUserIds;
        return;
    L44:
        return;
    L9:
        if (Arrays.equals(excludedUserIds, cur.excludedUserIds) == true) goto L11;
    L5:
        firstTime = false;
        goto L7
    }

    private void writeIntToFile(File file, int value) {
        FileUtils.bytesToFile(file.getAbsolutePath(), Integer.toString(value).getBytes(StandardCharsets.US_ASCII));     // Catch: IOException -> L4
        return;
    L5:
        Slog.w(TAG, "Couldn't write " + value + " to " + file.getAbsolutePath());
    }

    void writePackageListLPr() {
        writePackageListLPr(-1);
    }

    void writePackageListLPr(int creatingUserId) {
        String filename = this.mPackageListFilename.getAbsolutePath();
        String ctx = SELinux.fileSelabelLookup(filename);
        if (ctx != null) goto L6;
        Slog.wtf(TAG, "Failed to get SELinux context for " + this.mPackageListFilename.getAbsolutePath());
    L6:
        if (SELinux.setFSCreateContext(ctx) == true) goto L15;
        Slog.wtf(TAG, "Failed to set packages.list SELinux context");
    L15:
        writePackageListLPrInternal(creatingUserId);     // Catch: Throwable -> L12
        SELinux.setFSCreateContext(null);
        return;
    L12:
        th = move-exception;
        SELinux.setFSCreateContext(null);
        throw th;
    }

    private void writePackageListLPrInternal(int creatingUserId) {
        Settings r1 = this;
        List<UserInfo> users = getActiveUsers(UserManagerService.getInstance(), true);
        int[] userIds = new int[users.size()];
        int i = 0;
    L4:
        if (i >= userIds.length) goto L7;
        userIds[i] = users.get(i).id;
        i = i + 1;
        goto L4
    L7:
        if (creatingUserId == (-1)) goto L9;
        userIds = ArrayUtils.appendInt(userIds, creatingUserId);
    L9:
        File tempFile = new File(r1.mPackageListFilename.getAbsolutePath() + ".tmp");
        JournaledFile journal = new JournaledFile(r1.mPackageListFilename, tempFile);
        File writeTarget = journal.chooseForWrite();
        BufferedWriter writer = null;
        FileOutputStream fstr = new FileOutputStream(writeTarget);     // Catch: Exception -> L36
        writer = new BufferedWriter(new OutputStreamWriter(fstr, Charset.defaultCharset()));     // Catch: Exception -> L36
        FileUtils.setPermissions(fstr.getFD(), FrameworkStatsLog.DISPLAY_HBM_STATE_CHANGED, 1000, 1032);     // Catch: Exception -> L36
        StringBuilder sb = new StringBuilder();     // Catch: Exception -> L36
        Iterator<PackageSetting> r12 = r1.mPackages.values().iterator();     // Catch: Exception -> L36
    L11:
        if (r12.hasNext() == false) goto L73;
        PackageSetting ps = r12.next();     // Catch: Exception -> L36
        if (ps.getPkg() != null) goto L22;
    L19:
        e = e;
    L75:
        Slog.wtf(TAG, "Failed to write packages.list", e);
        IoUtils.closeQuietly(writer);
        journal.rollback();
        return;
    L16:
        if (PackageManagerService.PLATFORM_PACKAGE_NAME.equals(ps.getPackageName()) == true) goto L11;
        Slog.w(TAG, "Skipping " + ps + " due to missing metadata");     // Catch: Exception -> L19
        goto L11
    L22:
        if (ps.getPkg().isApex() == true) goto L11;
        File dataDir = PackageInfoUtils.getDataDir(ps, 0);     // Catch: Exception -> L36
        if (dataDir != null) goto L28;
        String r16 = "null";
    L29:
        String dataPath = r16;
        boolean isDebug = ps.getPkg().isDebuggable();     // Catch: Exception -> L36
        IntArray gids = new IntArray();     // Catch: Exception -> L36
        int r14 = userIds.length;     // Catch: Exception -> L36
        int r2 = 0;
    L30:
        if (r2 >= r14) goto L38;
        int userId = userIds[r2];     // Catch: Exception -> L36
        int r20 = r2;
        List<UserInfo> users2 = users;
        int[] r3 = r1.mPermissionDataProvider.getGidsForUid(UserHandle.getUid(userId, ps.getAppId()));     // Catch: Exception -> L34
        IntArray gids2 = gids;
        gids2.addAll(r3);     // Catch: Exception -> L34
        gids = gids2;
        users = users2;
        r2 = r20 + 1;     // Catch: Exception -> L34
        r1 = this;
    L34:
        e = e;
        goto L75
    L38:
        List<UserInfo> users3 = users;
        IntArray gids3 = gids;
        if (dataPath.indexOf(32) >= 0) goto L40;
        sb.setLength(0);     // Catch: Exception -> L34
        sb.append(ps.getPkg().getPackageName());     // Catch: Exception -> L34
        sb.append(" ");     // Catch: Exception -> L34
        sb.append(ps.getPkg().getUid());     // Catch: Exception -> L34
        if (isDebug == false) goto L44;
        String r4 = " 1 ";
    L45:
        sb.append(r4);     // Catch: Exception -> L34
        sb.append(dataPath);     // Catch: Exception -> L34
        sb.append(" ");     // Catch: Exception -> L34
        sb.append(ps.getSeInfo());     // Catch: Exception -> L34
        sb.append(" ");     // Catch: Exception -> L34
        int gidsSize = gids3.size();     // Catch: Exception -> L34
        if (gids3.size() <= 0) goto L51;
        sb.append(gids3.get(0));     // Catch: Exception -> L34
        int i2 = 1;
    L48:
        if (i2 >= gidsSize) goto L52;
        sb.append(",");     // Catch: Exception -> L34
        sb.append(gids3.get(i2));     // Catch: Exception -> L34
        i2 = i2 + 1;     // Catch: Exception -> L34
        gidsSize = gidsSize;
    L52:
        sb.append(" ");     // Catch: Exception -> L34
        String r15 = "0";
        if (ps.getPkg().isProfileableByShell() == false) goto L56;
        String r5 = "1";
    L57:
        sb.append(r5);     // Catch: Exception -> L34
        sb.append(" ");     // Catch: Exception -> L34
        sb.append(ps.getPkg().getLongVersionCode());     // Catch: Exception -> L34
        sb.append(" ");     // Catch: Exception -> L34
        if (ps.getPkg().isProfileable() == false) goto L60;
        r15 = "1";
    L60:
        sb.append(r15);     // Catch: Exception -> L34
        sb.append(" ");     // Catch: Exception -> L34
        if (ps.isSystem() == false) goto L64;
        sb.append("@system");     // Catch: Exception -> L34
    L72:
        sb.append("\n");     // Catch: Exception -> L34
        writer.append(sb);     // Catch: Exception -> L34
        r1 = this;
        users = users3;
        goto L11
    L64:
        if (ps.isProduct() == false) goto L67;
        sb.append("@product");     // Catch: Exception -> L34
        goto L72
    L67:
        if (ps.getInstallSource().mInstallerPackageName != null) goto L69;
    L71:
        sb.append("@null");     // Catch: Exception -> L34
        goto L72
    L69:
        if (ps.getInstallSource().mInstallerPackageName.isEmpty() == true) goto L71;
        sb.append(ps.getInstallSource().mInstallerPackageName);     // Catch: Exception -> L34
        goto L72
    L56:
        r5 = "0";
        goto L57
    L51:
        sb.append("none");     // Catch: Exception -> L34
        goto L52
    L44:
        r4 = " 0 ";
        goto L45
    L40:
        r1 = this;
        users = users3;
        goto L11
    L28:
        r16 = dataDir.getAbsolutePath();     // Catch: Exception -> L36
        goto L29
    L73:
        writer.flush();     // Catch: Exception -> L34
        FileUtils.sync(fstr);     // Catch: Exception -> L34
        writer.close();     // Catch: Exception -> L34
        journal.commit();     // Catch: Exception -> L34
        return;
    L36:
        e = e;
        goto L75
    }

    void writeDisabledSysPackageLPr(TypedXmlSerializer serializer, PackageSetting pkg) throws IOException {
        serializer.startTag(null, "updated-package");
        serializer.attribute(null, "name", pkg.getPackageName());
        if (pkg.getRealName() == null) goto L5;
        serializer.attribute(null, "realName", pkg.getRealName());
    L5:
        serializer.attribute(null, "codePath", pkg.getPathString());
        serializer.attributeLongHex(null, "ft", pkg.getLastModifiedTime());
        serializer.attributeLongHex(null, "ut", pkg.getLastUpdateTime());
        serializer.attributeLong(null, "version", pkg.getVersionCode());
        serializer.attributeInt(null, "targetSdkVersion", pkg.getTargetSdkVersion());
        if (pkg.getRestrictUpdateHash() == null) goto L8;
        serializer.attributeBytesBase64(null, "restrictUpdateHash", pkg.getRestrictUpdateHash());
    L8:
        serializer.attributeBoolean(null, "scannedAsStoppedSystemApp", pkg.isScannedAsStoppedSystemApp());
        if (pkg.getLegacyNativeLibraryPath() == null) goto L12;
        serializer.attribute(null, "nativeLibraryPath", pkg.getLegacyNativeLibraryPath());
    L12:
        if (pkg.getPrimaryCpuAbiLegacy() == null) goto L15;
        serializer.attribute(null, "primaryCpuAbi", pkg.getPrimaryCpuAbiLegacy());
    L15:
        if (pkg.getSecondaryCpuAbiLegacy() == null) goto L18;
        serializer.attribute(null, "secondaryCpuAbi", pkg.getSecondaryCpuAbiLegacy());
    L18:
        if (pkg.getCpuAbiOverride() == null) goto L21;
        serializer.attribute(null, "cpuAbiOverride", pkg.getCpuAbiOverride());
    L21:
        if (pkg.hasSharedUser() == true) goto L23;
        serializer.attributeInt(null, "userId", pkg.getAppId());
    L24:
        serializer.attributeFloat(null, "loadingProgress", pkg.getLoadingProgress());
        serializer.attributeLongHex(null, "loadingCompletedTime", pkg.getLoadingCompletedTime());
        if (pkg.getAppMetadataFilePath() == null) goto L27;
        serializer.attribute(null, "appMetadataFilePath", pkg.getAppMetadataFilePath());
    L27:
        serializer.attributeInt(null, "appMetadataSource", pkg.getAppMetadataSource());
        writeUsesSdkLibLPw(serializer, pkg.getUsesSdkLibraries(), pkg.getUsesSdkLibrariesVersionsMajor(), pkg.getUsesSdkLibrariesOptional());
        writeUsesStaticLibLPw(serializer, pkg.getUsesStaticLibraries(), pkg.getUsesStaticLibrariesVersions());
        serializer.endTag(null, "updated-package");
        return;
    L23:
        serializer.attributeInt(null, "sharedUserId", pkg.getAppId());
        goto L24
    }

    void writePackageLPr(TypedXmlSerializer serializer, ArrayList<Signature> writtenSignatures, PackageSetting pkg) throws IOException {
        serializer.startTag(null, ATTR_PACKAGE);
        serializer.attribute(null, "name", pkg.getPackageName());
        if (pkg.getRealName() == null) goto L5;
        serializer.attribute(null, "realName", pkg.getRealName());
    L5:
        serializer.attribute(null, "codePath", pkg.getPathString());
        if (pkg.getLegacyNativeLibraryPath() == null) goto L9;
        serializer.attribute(null, "nativeLibraryPath", pkg.getLegacyNativeLibraryPath());
    L9:
        if (pkg.getPrimaryCpuAbiLegacy() == null) goto L12;
        serializer.attribute(null, "primaryCpuAbi", pkg.getPrimaryCpuAbiLegacy());
    L12:
        if (pkg.getSecondaryCpuAbiLegacy() == null) goto L15;
        serializer.attribute(null, "secondaryCpuAbi", pkg.getSecondaryCpuAbiLegacy());
    L15:
        if (pkg.getCpuAbiOverride() == null) goto L17;
        serializer.attribute(null, "cpuAbiOverride", pkg.getCpuAbiOverride());
    L17:
        serializer.attributeInt(null, "publicFlags", pkg.getFlags());
        serializer.attributeInt(null, "privateFlags", pkg.getPrivateFlags());
        serializer.attributeLongHex(null, "ft", pkg.getLastModifiedTime());
        serializer.attributeLongHex(null, "ut", pkg.getLastUpdateTime());
        serializer.attributeLong(null, "version", pkg.getVersionCode());
        serializer.attributeInt(null, "targetSdkVersion", pkg.getTargetSdkVersion());
        if (pkg.getRestrictUpdateHash() == null) goto L20;
        serializer.attributeBytesBase64(null, "restrictUpdateHash", pkg.getRestrictUpdateHash());
    L20:
        serializer.attributeBoolean(null, "scannedAsStoppedSystemApp", pkg.isScannedAsStoppedSystemApp());
        if (pkg.hasSharedUser() == true) goto L29;
        serializer.attributeInt(null, "userId", pkg.getAppId());
        if (pkg.getAndroidPackage() != null) goto L25;
    L27:
        boolean r2 = false;
    L28:
        serializer.attributeBoolean(null, "isSdkLibrary", r2);
    L30:
        InstallSource installSource = pkg.getInstallSource();
        if (installSource.mInstallerPackageName == null) goto L34;
        serializer.attribute(null, "installer", installSource.mInstallerPackageName);
    L34:
        if (installSource.mInstallerPackageUid == (-1)) goto L37;
        serializer.attributeInt(null, "installerUid", installSource.mInstallerPackageUid);
    L37:
        if (installSource.mUpdateOwnerPackageName == null) goto L40;
        serializer.attribute(null, "updateOwner", installSource.mUpdateOwnerPackageName);
    L40:
        if (installSource.mInstallerAttributionTag == null) goto L42;
        serializer.attribute(null, "installerAttributionTag", installSource.mInstallerAttributionTag);
    L42:
        serializer.attributeInt(null, "packageSource", installSource.mPackageSource);
        if (installSource.mIsOrphaned == false) goto L46;
        serializer.attributeBoolean(null, "isOrphaned", true);
    L46:
        if (installSource.mInitiatingPackageName == null) goto L49;
        serializer.attribute(null, "installInitiator", installSource.mInitiatingPackageName);
    L49:
        if (installSource.mIsInitiatingPackageUninstalled == false) goto L52;
        serializer.attributeBoolean(null, "installInitiatorUninstalled", true);
    L52:
        if (installSource.mOriginatingPackageName == null) goto L55;
        serializer.attribute(null, "installOriginator", installSource.mOriginatingPackageName);
    L55:
        if (pkg.getVolumeUuid() == null) goto L58;
        serializer.attribute(null, ATTR_VOLUME_UUID, pkg.getVolumeUuid());
    L58:
        if (pkg.getCategoryOverride() == (-1)) goto L61;
        serializer.attributeInt(null, "categoryHint", pkg.getCategoryOverride());
    L61:
        if (pkg.isUpdateAvailable() == false) goto L64;
        serializer.attributeBoolean(null, "updateAvailable", true);
    L64:
        if (pkg.isForceQueryableOverride() == false) goto L67;
        serializer.attributeBoolean(null, "forceQueryable", true);
    L67:
        if (pkg.isPendingRestore() == false) goto L70;
        serializer.attributeBoolean(null, "pendingRestore", true);
    L70:
        if (pkg.isDebuggable() == false) goto L73;
        serializer.attributeBoolean(null, "debuggable", true);
    L73:
        if (pkg.isLoading() == false) goto L76;
        serializer.attributeBoolean(null, "isLoading", true);
    L76:
        if (pkg.getBaseRevisionCode() == 0) goto L79;
        serializer.attributeInt(null, "baseRevisionCode", pkg.getBaseRevisionCode());
    L79:
        if (pkg.getPageSizeAppCompatFlags() == 0) goto L81;
        serializer.attributeInt(null, "pageSizeCompat", pkg.getPageSizeAppCompatFlags());
    L81:
        serializer.attributeFloat(null, "loadingProgress", pkg.getLoadingProgress());
        serializer.attributeLongHex(null, "loadingCompletedTime", pkg.getLoadingCompletedTime());
        serializer.attribute(null, "domainSetId", pkg.getDomainSetId().toString());
        if (pkg.getAppMetadataFilePath() == null) goto L84;
        serializer.attribute(null, "appMetadataFilePath", pkg.getAppMetadataFilePath());
    L84:
        serializer.attributeInt(null, "appMetadataSource", pkg.getAppMetadataSource());
        writeUsesSdkLibLPw(serializer, pkg.getUsesSdkLibraries(), pkg.getUsesSdkLibrariesVersionsMajor(), pkg.getUsesSdkLibrariesOptional());
        writeUsesStaticLibLPw(serializer, pkg.getUsesStaticLibraries(), pkg.getUsesStaticLibrariesVersions());
        pkg.getSignatures().writeXml(serializer, "sigs", writtenSignatures);
        if (installSource.mInitiatingPackageSignatures == null) goto L87;
        installSource.mInitiatingPackageSignatures.writeXml(serializer, "install-initiator-sigs", writtenSignatures);
    L87:
        writeSigningKeySetLPr(serializer, pkg.getKeySetData());
        writeUpgradeKeySetsLPr(serializer, pkg.getKeySetData());
        writeKeySetAliasesLPr(serializer, pkg.getKeySetData());
        writeMimeGroupLPr(serializer, pkg.getMimeGroups());
        if (pkg.getPkg() != null) goto L90;
        writeSplitVersionsLPr(serializer, pkg.getSplitNames(), pkg.getSplitRevisionCodes());
    L90:
        serializer.endTag(null, ATTR_PACKAGE);
        return;
    L25:
        if (pkg.getAndroidPackage().isSdkLibrary() == false) goto L27;
        r2 = true;
        goto L28
    L29:
        serializer.attributeInt(null, "sharedUserId", pkg.getAppId());
        goto L30
    }

    void writeSigningKeySetLPr(TypedXmlSerializer serializer, PackageKeySetData data) throws IOException {
        serializer.startTag(null, "proper-signing-keyset");
        serializer.attributeLong(null, "identifier", data.getProperSigningKeySet());
        serializer.endTag(null, "proper-signing-keyset");
    }

    void writeUpgradeKeySetsLPr(TypedXmlSerializer serializer, PackageKeySetData data) throws IOException {
        if (data.isUsingUpgradeKeySets() == false) goto L8;
        long[] r0 = data.getUpgradeKeySets();
        int r1 = r0.length;
        int r2 = 0;
    L6:
        if (r2 >= r1) goto L10;
        long id = r0[r2];
        serializer.startTag(null, "upgrade-keyset");
        serializer.attributeLong(null, "identifier", id);
        serializer.endTag(null, "upgrade-keyset");
        r2 = r2 + 1;
        goto L6
    L10:
        return;
    }

    void writeKeySetAliasesLPr(TypedXmlSerializer serializer, PackageKeySetData data) throws IOException {
        Iterator<Map.Entry<String, Long>> r0 = data.getAliases().entrySet().iterator();
    L4:
        if (r0.hasNext() == false) goto L6;
        Map.Entry<String, Long> e = r0.next();
        serializer.startTag(null, "defined-keyset");
        serializer.attribute(null, "alias", e.getKey());
        serializer.attributeLong(null, "identifier", e.getValue().longValue());
        serializer.endTag(null, "defined-keyset");
        goto L4
    }

    boolean readSettingsLPw(Computer computer, List<UserInfo> users, ArrayMap<String, Long> originalFirstInstallTimes) {
        this.mPendingPackages.clear();
        this.mInstallerPackages.clear();
        originalFirstInstallTimes.clear();
        ArrayMap<Long, Integer> keySetRefs = new ArrayMap();
        ArrayList<Signature> readSignatures = new ArrayList();
        ResilientAtomicFile atomicFile = getSettingsFile();
        FileInputStream str = null;
        boolean r8 = true;
        FileInputStream str2 = atomicFile.openRead();     // Catch: Throwable -> L143 Throwable -> L155
        int r11 = 0;
        if (str2 != null) goto L182;
        findOrCreateVersion(StorageManager.UUID_PRIVATE_INTERNAL).forceCurrent();     // Catch: Throwable -> L9 Throwable -> L11
        findOrCreateVersion("primary_physical").forceCurrent();     // Catch: Throwable -> L9 Throwable -> L11
        atomicFile.close();
        return false;
    L182:
        TypedXmlPullParser parser = Xml.resolvePullParser(str2);     // Catch: Throwable -> L143 Throwable -> L148
    L15:
        int type = parser.next();     // Catch: Throwable -> L143 Throwable -> L148
        if (type == 2) goto L21;
        if (type != 1) goto L15;
    L21:
        if (type == 2) goto L25;
        this.mReadMessages.append("No start tag found in settings file\n");     // Catch: Throwable -> L9 Throwable -> L11 Throwable -> L11 Throwable -> L11 Throwable -> L11
        PackageManagerService.reportSettingsProblem(5, "No start tag found in package manager settings");     // Catch: Throwable -> L9 Throwable -> L11 Throwable -> L11 Throwable -> L11 Throwable -> L11
        Slog.wtf(PackageManagerServiceMonitorEx.TAG, "No start tag found in package manager settings");     // Catch: Throwable -> L9 Throwable -> L11 Throwable -> L11 Throwable -> L11 Throwable -> L11
        atomicFile.close();
        return false;
    L25:
        int outerDepth = parser.getDepth();     // Catch: Throwable -> L143 Throwable -> L148 Throwable -> L148 Throwable -> L148 Throwable -> L148
    L26:
        int type2 = parser.next();     // Catch: Throwable -> L143 Throwable -> L148 Throwable -> L148 Throwable -> L148 Throwable -> L148
        if (type2 == r8) goto L153;
        if (type2 == 3) goto L32;
    L35:
        if (type2 != 3) goto L37;
        ArrayList<Signature> readSignatures2 = readSignatures;
        r8 = r8;
        str2 = str2;
        int r9 = r11;
    L151:
        r11 = r9;
        r8 = r8;
        readSignatures = readSignatures2;
        str2 = str2;
        goto L26
    L37:
        if (type2 != 4) goto L39;
        readSignatures2 = readSignatures;
        r8 = r8;
        str2 = str2;
        r9 = r11;
        goto L151
    L39:
        String tagName = parser.getName();     // Catch: Throwable -> L143 Throwable -> L148 Throwable -> L148 Throwable -> L148 Throwable -> L148
        if (tagName != null) goto L43;
        readSignatures2 = readSignatures;
        r8 = r8;
        str2 = str2;
        r9 = r11;
        goto L151
    L43:
        if (tagName.equals(ATTR_PACKAGE) == false) goto L49;
        readPackageLPw(parser, readSignatures, keySetRefs, users, originalFirstInstallTimes);     // Catch: Throwable -> L9 Throwable -> L11 Throwable -> L11 Throwable -> L11 Throwable -> L11
        readSignatures2 = readSignatures;
        r8 = r8;
        str2 = str2;
        r9 = r11;
        goto L151
    L49:
        if (tagName.equals("permissions") == false) goto L53;
        this.mPermissions.readPermissions(parser);     // Catch: Throwable -> L9 Throwable -> L11 Throwable -> L11 Throwable -> L11 Throwable -> L11
        readSignatures2 = readSignatures;
        r8 = r8;
        str2 = str2;
        r9 = r11;
        goto L151
    L53:
        if (tagName.equals("permission-trees") == false) goto L57;
        this.mPermissions.readPermissionTrees(parser);     // Catch: Throwable -> L9 Throwable -> L11 Throwable -> L11 Throwable -> L11 Throwable -> L11
        readSignatures2 = readSignatures;
        r8 = r8;
        str2 = str2;
        r9 = r11;
        goto L151
    L57:
        if (tagName.equals(TAG_SHARED_USER) == false) goto L61;
        readSharedUserLPw(parser, readSignatures, users);     // Catch: Throwable -> L9 Throwable -> L11 Throwable -> L11 Throwable -> L11 Throwable -> L11
        readSignatures2 = readSignatures;
        r8 = r8;
        str2 = str2;
        r9 = r11;
        goto L151
    L61:
        if (tagName.equals("preferred-packages") == false) goto L64;
        readSignatures2 = readSignatures;
        r8 = r8;
        str2 = str2;
        r9 = r11;
        goto L151
    L64:
        if (tagName.equals("preferred-activities") == false) goto L68;
        readPreferredActivitiesLPw(parser, r11);     // Catch: Throwable -> L9 Throwable -> L11 Throwable -> L11 Throwable -> L11 Throwable -> L11
        readSignatures2 = readSignatures;
        r8 = r8;
        str2 = str2;
        r9 = r11;
        goto L151
    L68:
        if (tagName.equals(TAG_PERSISTENT_PREFERRED_ACTIVITIES) == false) goto L72;
        readPersistentPreferredActivitiesLPw(parser, r11);     // Catch: Throwable -> L9 Throwable -> L11 Throwable -> L11 Throwable -> L11 Throwable -> L11
        readSignatures2 = readSignatures;
        r8 = r8;
        str2 = str2;
        r9 = r11;
        goto L151
    L72:
        if (tagName.equals(TAG_CROSS_PROFILE_INTENT_FILTERS) == false) goto L76;
        readCrossProfileIntentFiltersLPw(parser, r11);     // Catch: Throwable -> L9 Throwable -> L11 Throwable -> L11 Throwable -> L11 Throwable -> L11
        readSignatures2 = readSignatures;
        r8 = r8;
        str2 = str2;
        r9 = r11;
        goto L151
    L76:
        if (tagName.equals(TAG_DEFAULT_BROWSER) == false) goto L80;
        readDefaultAppsLPw(parser, r11);     // Catch: Throwable -> L9 Throwable -> L11 Throwable -> L11 Throwable -> L11 Throwable -> L11
        readSignatures2 = readSignatures;
        r8 = r8;
        str2 = str2;
        r9 = r11;
        goto L151
    L80:
        if (tagName.equals("updated-package") == false) goto L83;
        readDisabledSysPackageLPw(parser, users);     // Catch: Throwable -> L9 Throwable -> L11 Throwable -> L11 Throwable -> L11 Throwable -> L11
        readSignatures2 = readSignatures;
        r8 = r8;
        str2 = str2;
        r9 = r11;
        goto L151
    L83:
        if (tagName.equals("renamed-package") == true) goto L177;
        r8 = r8;
        readSignatures2 = readSignatures;
        if (tagName.equals("last-platform-version") == true) goto L173;
        str2 = str2;
        if (tagName.equals("database-version") == false) goto L116;
        VersionInfo internal = findOrCreateVersion(StorageManager.UUID_PRIVATE_INTERNAL);     // Catch: Throwable -> L105 Throwable -> L108
        VersionInfo external = findOrCreateVersion("primary_physical");     // Catch: Throwable -> L105 Throwable -> L108
        r9 = 0;
        internal.databaseVersion = parser.getAttributeInt(null, "internal", 0);     // Catch: Throwable -> L105 Throwable -> L108
        external.databaseVersion = parser.getAttributeInt(null, "external", 0);     // Catch: Throwable -> L105 Throwable -> L108
        goto L151
    L116:
        r9 = 0;
        if (tagName.equals("verifier") == false) goto L121;
        String deviceIdentity = parser.getAttributeValue(null, "device");     // Catch: Throwable -> L105 Throwable -> L108
        this.mVerifierDeviceIdentity = VerifierDeviceIdentity.parse(deviceIdentity);     // Catch: Throwable -> L105 Throwable -> L108
        goto L151
    L121:
        if (TAG_READ_EXTERNAL_STORAGE.equals(tagName) == true) goto L151;
        if (tagName.equals("keyset-settings") == false) goto L127;
        this.mKeySetManagerService.readKeySetsLPw(parser, keySetRefs);     // Catch: Throwable -> L105 Throwable -> L108
        goto L151
    L127:
        if ("version".equals(tagName) == false) goto L130;
        String volumeUuid = XmlUtils.readStringAttribute(parser, ATTR_VOLUME_UUID);     // Catch: Throwable -> L105 Throwable -> L108
        VersionInfo ver = findOrCreateVersion(volumeUuid);     // Catch: Throwable -> L105 Throwable -> L108
        ver.sdkVersion = parser.getAttributeInt(null, ATTR_SDK_VERSION);     // Catch: Throwable -> L105 Throwable -> L108
        ver.databaseVersion = parser.getAttributeInt(null, ATTR_DATABASE_VERSION);     // Catch: Throwable -> L105 Throwable -> L108
        ver.buildFingerprint = XmlUtils.readStringAttribute(parser, ATTR_BUILD_FINGERPRINT);     // Catch: Throwable -> L105 Throwable -> L108
        ver.fingerprint = XmlUtils.readStringAttribute(parser, ATTR_FINGERPRINT);     // Catch: Throwable -> L105 Throwable -> L108
        goto L151
    L130:
        if (tagName.equals(DomainVerificationPersistence.TAG_DOMAIN_VERIFICATIONS) == false) goto L139;
        this.mDomainVerificationManager.readSettings(computer, parser);     // Catch: Throwable -> L134 Throwable -> L136
    L136:
        e = e;
    L110:
        str = str2;
    L158:
        atomicFile.failRead(str, e);     // Catch: Throwable -> L134
        readSettingsLPw(computer, users, originalFirstInstallTimes);     // Catch: Throwable -> L134
    L159:
        if (atomicFile == null) goto L161;
        atomicFile.close();
    L161:
        return r8;
    L134:
        Throwable th = th;
    L107:
        Throwable r2 = th;
    L162:
        if (atomicFile == null) goto L197;
        atomicFile.close();     // Catch: Throwable -> L165
        throw r2;
    L165:
        th = move-exception;
        r2.addSuppressed(th);
        throw r2;
    L197:
        throw r2;
    L139:
        if (tagName.equals(DomainVerificationLegacySettings.TAG_DOMAIN_VERIFICATIONS_LEGACY) == false) goto L141;
        this.mDomainVerificationManager.readLegacySettings(parser);     // Catch: Throwable -> L134 Throwable -> L136
        goto L151
    L141:
        Slog.w(PackageManagerServiceMonitorEx.TAG, "Unknown element under <packages>: " + parser.getName());     // Catch: Throwable -> L134 Throwable -> L136
        XmlUtils.skipCurrentTag(parser);     // Catch: Throwable -> L134 Throwable -> L136
        goto L151
    L173:
        VersionInfo internal2 = findOrCreateVersion(StorageManager.UUID_PRIVATE_INTERNAL);     // Catch: Throwable -> L105 Throwable -> L111
        VersionInfo external2 = findOrCreateVersion("primary_physical");     // Catch: Throwable -> L105 Throwable -> L111
        str2 = str2;
        internal2.sdkVersion = parser.getAttributeInt(null, "internal", 0);     // Catch: Throwable -> L105 Throwable -> L108
        external2.sdkVersion = parser.getAttributeInt(null, "external", 0);     // Catch: Throwable -> L105 Throwable -> L108
        String r3 = XmlUtils.readStringAttribute(parser, ATTR_BUILD_FINGERPRINT);     // Catch: Throwable -> L105 Throwable -> L108
        external2.buildFingerprint = r3;     // Catch: Throwable -> L105 Throwable -> L108
        internal2.buildFingerprint = r3;     // Catch: Throwable -> L105 Throwable -> L108
        String r4 = XmlUtils.readStringAttribute(parser, ATTR_FINGERPRINT);     // Catch: Throwable -> L105 Throwable -> L108
        external2.fingerprint = r4;     // Catch: Throwable -> L105 Throwable -> L108
        internal2.fingerprint = r4;     // Catch: Throwable -> L105 Throwable -> L108
        r9 = 0;
    L108:
        e = e;
        goto L110
    L105:
        th = th;
    L111:
        e = e;
        str = str2;
        goto L158
    L145:
        e = e;
    L147:
        str = str2;
        goto L158
    L177:
        String nname = parser.getAttributeValue(null, "new");     // Catch: Throwable -> L9 Throwable -> L96
        r8 = r8;
        String oname = parser.getAttributeValue(null, "old");     // Catch: Throwable -> L9 Throwable -> L93
        if (nname == null) goto L95;
        if (oname == null) goto L95;
        this.mRenamedPackages.put(nname, oname);     // Catch: Throwable -> L9 Throwable -> L93
    L95:
        readSignatures2 = readSignatures;
        str2 = str2;
        r9 = r11;
    L93:
        e = e;
    L13:
        str = str2;
    L96:
        e = e;
        r8 = r8;
        goto L13
    L32:
        if (parser.getDepth() > outerDepth) goto L35;
    L153:
        str2.close();     // Catch: Throwable -> L134 Throwable -> L136
    L148:
        e = e;
        r8 = r8;
    L9:
        th = move-exception;
        r2 = th;
    L11:
        e = e;
        r8 = true;
    L143:
        th = move-exception;
        r2 = th;
    L155:
        e = e;
        r8 = true;
        goto L158
    }

    boolean readLPw(Computer computer, List<UserInfo> users) {
        ArrayMap<String, Long> originalFirstInstallTimes = new ArrayMap();
        if (readSettingsLPw(computer, users, originalFirstInstallTimes) == true) goto L14;
        if (this.mVersion.containsKey(StorageManager.UUID_PRIVATE_INTERNAL) == true) goto L10;
        Slog.wtf(PackageManagerServiceMonitorEx.TAG, "No internal VersionInfo found in settings, using current.");
        findOrCreateVersion(StorageManager.UUID_PRIVATE_INTERNAL).forceCurrent();
    L10:
        if (this.mVersion.containsKey("primary_physical") == true) goto L12;
        Slog.wtf(PackageManagerServiceMonitorEx.TAG, "No external VersionInfo found in settings, using current.");
        findOrCreateVersion("primary_physical").forceCurrent();
    L12:
        return false;
    L14:
        if (this.mVersion.containsKey(StorageManager.UUID_PRIVATE_INTERNAL) == true) goto L17;
        Slog.wtf(PackageManagerServiceMonitorEx.TAG, "No internal VersionInfo found in settings, using current.");
        findOrCreateVersion(StorageManager.UUID_PRIVATE_INTERNAL).forceCurrent();
    L17:
        if (this.mVersion.containsKey("primary_physical") == true) goto L19;
        Slog.wtf(PackageManagerServiceMonitorEx.TAG, "No external VersionInfo found in settings, using current.");
        findOrCreateVersion("primary_physical").forceCurrent();
    L19:
        int N = this.mPendingPackages.size();
        int i = 0;
    L20:
        if (i >= N) goto L32;
        PackageSetting p = this.mPendingPackages.get(i);
        int sharedUserAppId = p.getSharedUserAppId();
        if (sharedUserAppId <= 0) goto L31;
        Object idObj = getSettingLPr(sharedUserAppId);
        if ((idObj instanceof SharedUserSetting) == false) goto L28;
        SharedUserSetting sharedUser = (SharedUserSetting) idObj;
        addPackageSettingLPw(p, sharedUser);
        goto L31
    L28:
        if (idObj == null) goto L30;
        String msg = "Bad package setting: package " + p.getPackageName() + " has shared uid " + sharedUserAppId + " that is not a shared uid\n";
        this.mReadMessages.append(msg);
        PackageManagerService.reportSettingsProblem(6, msg);
        goto L31
    L30:
        String msg2 = "Bad package setting: package " + p.getPackageName() + " has shared uid " + sharedUserAppId + " that is not defined\n";
        this.mReadMessages.append(msg2);
        PackageManagerService.reportSettingsProblem(6, msg2);
    L31:
        i = i + 1;
        goto L20
    L32:
        this.mPendingPackages.clear();
        if (this.mBackupStoppedPackagesFilename.exists() == false) goto L35;
    L41:
        readStoppedLPw();
        this.mBackupStoppedPackagesFilename.delete();
        this.mStoppedPackagesFilename.delete();
        writePackageRestrictionsLPr(0, true);
    L42:
        Iterator<UserInfo> r1 = users.iterator();
    L44:
        if (r1.hasNext() == false) goto L46;
        UserInfo user = r1.next();
        this.mRuntimePermissionsPersistence.readStateForUserSync(user.id, getInternalVersion(), this.mPackages, this.mSharedUsers, getUserRuntimePermissionsFile(user.id));
        goto L44
    L46:
        Iterator<PackageSetting> r2 = this.mDisabledSysPackages.values().iterator();
    L48:
        if (r2.hasNext() == false) goto L53;
        PackageSetting disabledPs = r2.next();
        Object id = getSettingLPr(disabledPs.getAppId());
        if ((id instanceof SharedUserSetting) == false) goto L48;
        SharedUserSetting sharedUserSetting = (SharedUserSetting) id;
        sharedUserSetting.mDisabledPackages.add(disabledPs);
        disabledPs.setSharedUserAppId(sharedUserSetting.mAppId);
        goto L48
    L53:
        StringBuilder r3 = this.mReadMessages;
        r3.append("Read completed successfully: ");
        r3.append(this.mPackages.size());
        r3.append(" packages, ");
        r3.append(this.mSharedUsers.size());
        r3.append(" shared uids\n");
        writeKernelMappingLPr();
        return true;
    L35:
        if (this.mStoppedPackagesFilename.exists() == true) goto L41;
        Iterator<UserInfo> r4 = users.iterator();
    L39:
        if (r4.hasNext() == false) goto L42;
        readPackageRestrictionsLPr(r4.next().id, originalFirstInstallTimes);
    L55:
        th = move-exception;
        if (this.mVersion.containsKey(StorageManager.UUID_PRIVATE_INTERNAL) == true) goto L60;
        Slog.wtf(PackageManagerServiceMonitorEx.TAG, "No internal VersionInfo found in settings, using current.");
        findOrCreateVersion(StorageManager.UUID_PRIVATE_INTERNAL).forceCurrent();
    L60:
        if (this.mVersion.containsKey("primary_physical") == true) goto L62;
        Slog.wtf(PackageManagerServiceMonitorEx.TAG, "No external VersionInfo found in settings, using current.");
        findOrCreateVersion("primary_physical").forceCurrent();
    L62:
        throw th;
    }

    void readPermissionStateForUserSyncLPr(int userId) {
        this.mRuntimePermissionsPersistence.readStateForUserSync(userId, getInternalVersion(), this.mPackages, this.mSharedUsers, getUserRuntimePermissionsFile(userId));
    }

    RuntimePermissionsState getLegacyPermissionsState(int userId) {
        return this.mRuntimePermissionsPersistence.getLegacyPermissionsState(userId, this.mPackages, this.mSharedUsers);
    }

    void applyDefaultPreferredAppsLPw(int userId) {
        PackageManagerInternal pmInternal = (PackageManagerInternal) LocalServices.getService(PackageManagerInternal.class);
        Iterator<PackageSetting> r0 = this.mPackages.values().iterator();
    L4:
        if (r0.hasNext() == false) goto L16;
        PackageSetting ps = r0.next();
        if ((1 & ps.getFlags()) == 0) goto L4;
        if (ps.getPkg() == null) goto L4;
        if (ps.getPkg().getPreferredActivityFilters().isEmpty() == true) goto L4;
        List<Pair<String, ParsedIntentInfo>> intents = ps.getPkg().getPreferredActivityFilters();
        int i = 0;
    L13:
        if (i >= intents.size()) goto L4;
        Pair<String, ParsedIntentInfo> pair = intents.get(i);
        applyDefaultPreferredActivityLPw(pmInternal, ((ParsedIntentInfo) pair.second).getIntentFilter(), new ComponentName(ps.getPackageName(), (String) pair.first), userId);
        i = i + 1;
        goto L13
    L16:
        int size = PackageManagerService.SYSTEM_PARTITIONS.size();
        int index = 0;
    L17:
        if (index >= size) goto L87;
        ScanPartition partition = PackageManagerService.SYSTEM_PARTITIONS.get(index);
        File preferredDir = new File(partition.getFolder(), "etc/preferred-apps");
        if (preferredDir.exists() == false) goto L85;
        if (preferredDir.isDirectory() == false) goto L85;
        if (preferredDir.canRead() == true) goto L26;
        Slog.w(TAG, "Directory " + preferredDir + " cannot be read");
        goto L85
    L26:
        File[] files = preferredDir.listFiles();
        if (ArrayUtils.isEmpty(files) == true) goto L85;
        int r13 = files.length;
        int r14 = 0;
    L30:
        if (r14 >= r13) goto L85;
        File f = files[r14];
        if (f.getPath().endsWith(".xml") == true) goto L35;
        Slog.i(TAG, "Non-xml file " + f + " in " + preferredDir + " directory, ignoring");
        PackageManagerInternal pmInternal2 = pmInternal;
        int size2 = size;
    L82:
        r14 = r14 + 1;
        pmInternal = pmInternal2;
        size = size2;
        goto L30
    L35:
        if (f.canRead() == true) goto L96;
        Slog.w(TAG, "Preferred apps file " + f + " cannot be read");
        pmInternal2 = pmInternal;
        size2 = size;
        goto L82
    L96:
        InputStream str = new FileInputStream(f);     // Catch: IOException -> L76 XmlPullParserException -> L78
    L94:
        TypedXmlPullParser parser = Xml.resolvePullParser(str);     // Catch: Throwable -> L69
    L40:
        pmInternal2 = pmInternal;
        int type = parser.next();     // Catch: Throwable -> L67
        size2 = size;
        if (type == 2) goto L47;
        int type2 = type;
        if (type2 == 1) goto L49;
        pmInternal = pmInternal2;
        size = size2;
    L49:
        if (type2 == 2) goto L60;
        Slog.w(TAG, "Preferred apps file " + f + " does not have start tag");     // Catch: Throwable -> L57
        str.close();     // Catch: IOException -> L53 XmlPullParserException -> L55
    L53:
        e = e;
    L80:
        Slog.w(TAG, "Error reading apps file " + f, e);
    L55:
        e = e;
    L81:
        Slog.w(TAG, "Error reading apps file " + f, e);
    L57:
        th = move-exception;
        Throwable r4 = th;
    L90:
        str.close();     // Catch: Throwable -> L73
    L75:
        throw r4;     // Catch: IOException -> L53 XmlPullParserException -> L55
    L73:
        th = move-exception;
        r4.addSuppressed(th);     // Catch: IOException -> L53 XmlPullParserException -> L55
        goto L75
    L60:
        if ("preferred-activities".equals(parser.getName()) == true) goto L64;
        Slog.w(TAG, "Preferred apps file " + f + " does not start with 'preferred-activities'");     // Catch: Throwable -> L57
        str.close();     // Catch: IOException -> L53 XmlPullParserException -> L55
        goto L82
    L64:
        readDefaultPreferredActivitiesLPw(parser, userId);     // Catch: Throwable -> L57
        str.close();     // Catch: IOException -> L53 XmlPullParserException -> L55
        goto L82
    L47:
        type2 = type;
    L67:
        th = move-exception;
        size2 = size;
        r4 = th;
    L69:
        th = move-exception;
        pmInternal2 = pmInternal;
        size2 = size;
        r4 = th;
    L76:
        e = e;
        pmInternal2 = pmInternal;
        size2 = size;
    L78:
        e = e;
        pmInternal2 = pmInternal;
        size2 = size;
    L85:
        index = index + 1;
        pmInternal = pmInternal;
        size = size;
        goto L17
    }

    static void removeFilters(PreferredIntentResolver pir, WatchedIntentFilter filter, List<PreferredActivity> existing) {
        int i = existing.size() - 1;
    L3:
        if (i < 0) goto L6;
        PreferredActivity pa = existing.get(i);
        pir.removeFilter(pa);
        i = i - 1;
        goto L3
    }

    private void applyDefaultPreferredActivityLPw(PackageManagerInternal pmInternal, IntentFilter tmpPa, ComponentName cn, int userId) {
        Intent intent = new Intent();
        boolean r2 = false;
        intent.setAction(tmpPa.getAction(0));
        int i = 0;
        int flags = 786432;
    L3:
        int flags2 = tmpPa.countCategories();
        if (i >= flags2) goto L10;
        String cat = tmpPa.getCategory(i);
        if (cat.equals("android.intent.category.DEFAULT") == false) goto L8;
        flags = 65536 | flags;
    L9:
        i = i + 1;
        goto L3
    L8:
        intent.addCategory(cat);
        goto L9
    L10:
        boolean doNonData = true;
        int dataSchemesCount = tmpPa.countDataSchemes();
        boolean hasSchemes = false;
        int ischeme = 0;
    L11:
        if (ischeme >= dataSchemesCount) goto L40;
        String scheme = tmpPa.getDataScheme(ischeme);
        if (scheme != null) goto L15;
    L17:
        int dataSchemeSpecificPartsCount = tmpPa.countDataSchemeSpecificParts();
        boolean doScheme = true;
        int issp = 0;
    L18:
        if (issp >= dataSchemeSpecificPartsCount) goto L20;
        Uri.Builder builder = new Uri.Builder();
        builder.scheme(scheme);
        PatternMatcher ssp = tmpPa.getDataSchemeSpecificPart(issp);
        builder.opaquePart(ssp.getPath());
        Intent finalIntent = new Intent(intent);
        finalIntent.setData(builder.build());
        applyDefaultPreferredActivityLPw(pmInternal, finalIntent, flags, cn, scheme, ssp, null, null, userId);
        doScheme = false;
        issp = issp + 1;
        dataSchemeSpecificPartsCount = dataSchemeSpecificPartsCount;
        goto L18
    L20:
        int dataAuthoritiesCount = tmpPa.countDataAuthorities();
        int iauth = 0;
    L21:
        if (iauth >= dataAuthoritiesCount) goto L36;
        IntentFilter.AuthorityEntry auth = tmpPa.getDataAuthority(iauth);
        int dataPathsCount = tmpPa.countDataPaths();
        boolean doScheme2 = doScheme;
        boolean doAuth = true;
        int ipath = 0;
    L23:
        if (ipath >= dataPathsCount) goto L28;
        Uri.Builder builder2 = new Uri.Builder();
        builder2.scheme(scheme);
        if (auth.getHost() == null) goto L27;
        builder2.authority(auth.getHost());
    L27:
        PatternMatcher path = tmpPa.getDataPath(ipath);
        builder2.path(path.getPath());
        Intent finalIntent2 = new Intent(intent);
        boolean r20 = r2;
        finalIntent2.setData(builder2.build());
        applyDefaultPreferredActivityLPw(pmInternal, finalIntent2, flags, cn, scheme, null, auth, path, userId);
        doScheme2 = r20;
        doAuth = r20;
        ipath = ipath + 1;
        dataAuthoritiesCount = dataAuthoritiesCount;
        r2 = r20;
        iauth = iauth;
        dataPathsCount = dataPathsCount;
        goto L23
    L28:
        boolean r21 = r2;
        int dataAuthoritiesCount2 = dataAuthoritiesCount;
        int iauth2 = iauth;
        if (doAuth == false) goto L34;
        Uri.Builder builder3 = new Uri.Builder();
        builder3.scheme(scheme);
        if (auth.getHost() == null) goto L33;
        builder3.authority(auth.getHost());
    L33:
        Intent finalIntent3 = new Intent(intent);
        finalIntent3.setData(builder3.build());
        applyDefaultPreferredActivityLPw(pmInternal, finalIntent3, flags, cn, scheme, null, auth, null, userId);
        doScheme = false;
    L35:
        iauth = iauth2 + 1;
        dataAuthoritiesCount = dataAuthoritiesCount2;
        r2 = r21;
        goto L21
    L34:
        doScheme = doScheme2;
        goto L35
    L36:
        boolean r22 = r2;
        if (doScheme == false) goto L39;
        Uri.Builder builder4 = new Uri.Builder();
        builder4.scheme(scheme);
        Intent finalIntent4 = new Intent(intent);
        finalIntent4.setData(builder4.build());
        applyDefaultPreferredActivityLPw(pmInternal, finalIntent4, flags, cn, scheme, null, null, null, userId);
    L39:
        doNonData = false;
        ischeme = ischeme + 1;
        r2 = r22;
        goto L11
    L15:
        if (scheme.isEmpty() == true) goto L17;
        hasSchemes = true;
        goto L17
    L40:
        int idata = 0;
    L42:
        if (idata >= tmpPa.countDataTypes()) goto L59;
        String mimeType = tmpPa.getDataType(idata);
        if (hasSchemes == false) goto L56;
        Uri.Builder builder5 = new Uri.Builder();
        int ischeme2 = 0;
    L47:
        if (ischeme2 >= tmpPa.countDataSchemes()) goto L57;
        String scheme2 = tmpPa.getDataScheme(ischeme2);
        if (scheme2 == null) goto L54;
        if (scheme2.isEmpty() == true) goto L54;
        Intent finalIntent5 = new Intent(intent);
        builder5.scheme(scheme2);
        finalIntent5.setDataAndType(builder5.build(), mimeType);
        applyDefaultPreferredActivityLPw(pmInternal, finalIntent5, flags, cn, scheme2, null, null, null, userId);
    L54:
        ischeme2 = ischeme2 + 1;
        builder5 = builder5;
    L57:
        doNonData = false;
        idata = idata + 1;
        goto L42
    L56:
        Intent finalIntent6 = new Intent(intent);
        finalIntent6.setType(mimeType);
        applyDefaultPreferredActivityLPw(pmInternal, finalIntent6, flags, cn, null, null, null, null, userId);
        goto L57
    L59:
        if (doNonData == false) goto L81;
        applyDefaultPreferredActivityLPw(pmInternal, intent, flags, cn, null, null, null, null, userId);
        return;
    }

    private void applyDefaultPreferredActivityLPw(PackageManagerInternal pmInternal, Intent intent, int flags, ComponentName cn, String scheme, PatternMatcher ssp, IntentFilter.AuthorityEntry auth, PatternMatcher path, int userId) {
        List<ResolveInfo> ri = pmInternal.queryIntentActivities(intent, intent.getType(), flags, Binder.getCallingUid(), userId);
        if (ri != null) goto L5;
        int numMatches = 0;
    L6:
        boolean r6 = true;
        if (numMatches >= 1) goto L10;
        Slog.w(TAG, "No potential matches found for " + intent + " while setting preferred " + cn.flattenToShortString());
        return;
    L10:
        ComponentName haveNonSys = null;
        ComponentName[] set = new ComponentName[ri.size()];
        int i = 0;
        boolean haveAct = false;
        int systemMatch = 0;
    L11:
        if (i >= numMatches) goto L24;
        ActivityInfo ai = ri.get(i).activityInfo;
        boolean r16 = r6;
        int numMatches2 = numMatches;
        set[i] = new ComponentName(ai.packageName, ai.name);
        if ((ai.applicationInfo.flags & 1) != 0) goto L18;
        if (ri.get(i).match < 0) goto L22;
        haveNonSys = set[i];
    L22:
        i = i + 1;
        r6 = r16;
        numMatches = numMatches2;
        goto L11
    L18:
        if (cn.getPackageName().equals(ai.packageName) == false) goto L22;
        if (cn.getClassName().equals(ai.name) == false) goto L22;
        haveAct = true;
        systemMatch = ri.get(i).match;
    L24:
        if (haveNonSys == null) goto L27;
        if (0 >= systemMatch) goto L27;
        haveNonSys = null;
    L27:
        if (haveAct == false) goto L61;
        if (haveNonSys != null) goto L61;
        WatchedIntentFilter filter = new WatchedIntentFilter();
        if (intent.getAction() == null) goto L33;
        filter.addAction(intent.getAction());
    L33:
        if (intent.getCategories() == null) goto L39;
        Iterator<String> r0 = intent.getCategories().iterator();
    L36:
        if (r0.hasNext() == false) goto L39;
        String cat = r0.next();
        filter.addCategory(cat);
    L39:
        if ((65536 & flags) == 0) goto L41;
        filter.addCategory("android.intent.category.DEFAULT");
    L41:
        if (scheme == null) goto L43;
        filter.addDataScheme(scheme);
    L43:
        if (ssp == null) goto L45;
        filter.addDataSchemeSpecificPart(ssp.getPath(), ssp.getType());
    L45:
        if (auth == null) goto L47;
        filter.addDataAuthority(auth);
    L47:
        if (path == null) goto L50;
        filter.addDataPath(path);
    L50:
        if (intent.getType() != null) goto L71;
        ComponentName r7 = cn;
    L56:
        PreferredIntentResolver pir = editPreferredActivitiesLPw(userId);
        List<PreferredActivity> existing = pir.findFilters(filter);
        if (existing == null) goto L59;
        removeFilters(pir, filter, existing);
    L59:
        PreferredActivity pa = new PreferredActivity(filter, systemMatch, set, r7, true);
        pir.addFilter(null, pa);
        return;
    L71:
        filter.addDataType(intent.getType());     // Catch: IntentFilter.MalformedMimeTypeException -> L53
        r7 = cn;
    L54:
        StringBuilder r4 = new StringBuilder();
        r4.append("Malformed mimetype ");
        r4.append(intent.getType());
        r4.append(" for ");
        r7 = cn;
        r4.append(r7);
        Slog.w(TAG, r4.toString());
    L61:
        if (haveNonSys != null) goto L69;
        StringBuilder sb = new StringBuilder();
        sb.append("No component ");
        sb.append(cn.flattenToShortString());
        sb.append(" found setting preferred ");
        sb.append(intent);
        sb.append("; possible matches are ");
        int i2 = 0;
    L64:
        if (i2 >= set.length) goto L68;
        if (i2 <= 0) goto L67;
        sb.append(", ");
    L67:
        sb.append(set[i2].flattenToShortString());
        i2 = i2 + 1;
        goto L64
    L68:
        Slog.w(TAG, sb.toString());
        return;
    L69:
        Slog.i(TAG, "Not setting preferred " + intent + "; found third party match " + haveNonSys.flattenToShortString());
        return;
    L5:
        numMatches = ri.size();
        goto L6
    }

    private void readDefaultPreferredActivitiesLPw(TypedXmlPullParser parser, int userId) throws XmlPullParserException, IOException {
        PackageManagerInternal pmInternal = (PackageManagerInternal) LocalServices.getService(PackageManagerInternal.class);
        int outerDepth = parser.getDepth();
    L3:
        int type = parser.next();
        if (type == 1) goto L26;
        if (type == 3) goto L8;
    L10:
        if (type == 3) goto L3;
        if (type == 4) goto L3;
        String tagName = parser.getName();
        if (tagName == null) goto L3;
        if (tagName.equals(TAG_ITEM) == true) goto L19;
        PackageManagerService.reportSettingsProblem(5, "Unknown element under <preferred-activities>: " + parser.getName());
        XmlUtils.skipCurrentTag(parser);
        goto L3
    L19:
        PreferredActivity tmpPa = new PreferredActivity(parser);
        if (tmpPa.mPref.getParseError() == null) goto L21;
        PackageManagerService.reportSettingsProblem(5, "Error in package manager settings: <preferred-activity> " + tmpPa.mPref.getParseError() + " at " + parser.getPositionDescription());
        goto L3
    L21:
        applyDefaultPreferredActivityLPw(pmInternal, tmpPa.getIntentFilter(), tmpPa.mPref.mComponent, userId);
        goto L3
    L8:
        if (parser.getDepth() > outerDepth) goto L10;
        return;
    }

    private void readDisabledSysPackageLPw(TypedXmlPullParser parser, List<UserInfo> users) throws XmlPullParserException, IOException {
        String name = parser.getAttributeValue(null, "name");
        String realName = parser.getAttributeValue(null, "realName");
        String codePathStr = parser.getAttributeValue(null, "codePath");
        String legacyCpuAbiStr = parser.getAttributeValue(null, "requiredCpuAbi");
        String legacyNativeLibraryPathStr = parser.getAttributeValue(null, "nativeLibraryPath");
        String primaryCpuAbiStr = parser.getAttributeValue(null, "primaryCpuAbi");
        String secondaryCpuAbiStr = parser.getAttributeValue(null, "secondaryCpuAbi");
        String cpuAbiOverrideStr = parser.getAttributeValue(null, "cpuAbiOverride");
        if (primaryCpuAbiStr != null) goto L6;
        if (legacyCpuAbiStr == null) goto L6;
        String primaryCpuAbiStr2 = legacyCpuAbiStr;
    L7:
        long versionCode = parser.getAttributeLong(null, "version", 0);
        int targetSdkVersion = parser.getAttributeInt(null, "targetSdkVersion", 0);
        byte[] restrictUpdateHash = parser.getAttributeBytesBase64(null, "restrictUpdateHash", null);
        boolean isScannedAsStoppedSystemApp = parser.getAttributeBoolean(null, "scannedAsStoppedSystemApp", false);
        int pkgPrivateFlags = 0;
        int pkgFlags = 0 | 1;
        if (codePathStr.contains("/priv-app/") == false) goto L10;
        pkgPrivateFlags = 0 | 8;
    L10:
        UUID domainSetId = DomainVerificationManagerInternal.DISABLED_ID;
        int targetSdkVersion2 = pkgPrivateFlags;
        PackageSetting ps = new PackageSetting(name, realName, new File(codePathStr), pkgFlags, targetSdkVersion2, domainSetId).setLegacyNativeLibraryPath(legacyNativeLibraryPathStr).setPrimaryCpuAbi(primaryCpuAbiStr2).setSecondaryCpuAbi(secondaryCpuAbiStr).setCpuAbiOverride(cpuAbiOverrideStr).setLongVersionCode(versionCode).setTargetSdkVersion(targetSdkVersion).setRestrictUpdateHash(restrictUpdateHash).setScannedAsStoppedSystemApp(isScannedAsStoppedSystemApp);
        TypedXmlPullParser r0 = parser;
        long timeStamp = r0.getAttributeLongHex(null, "ft", 0);
        if (timeStamp != 0) goto L13;
        long timeStamp2 = r0.getAttributeLong(null, "ts", 0);
    L14:
        ps.setLastModifiedTime(timeStamp2);
        ps.setLastUpdateTime(r0.getAttributeLongHex(null, "ut", 0));
        ps.setAppId(parseAppId(r0));
        if (ps.getAppId() > 0) goto L17;
        int sharedUserAppId = parseSharedUserAppId(r0);
        ps.setAppId(sharedUserAppId);
        ps.setSharedUserAppId(sharedUserAppId);
    L17:
        ps.setAppMetadataFilePath(r0.getAttributeValue(null, "appMetadataFilePath"));
        ps.setAppMetadataSource(r0.getAttributeInt(null, "appMetadataSource", 0));
        int outerDepth = r0.getDepth();
    L18:
        int type = r0.next();
        if (type == 1) goto L57;
        if (type == 3) goto L23;
    L26:
        if (type != 3) goto L28;
        r0 = parser;
        outerDepth = outerDepth;
        goto L18
    L28:
        if (type == 4) goto L18;
        String tagName = r0.getName();
        if (tagName == null) goto L18;
        if (tagName.equals(TAG_PERMISSIONS) == true) goto L36;
        outerDepth = outerDepth;
        if (tagName.equals(TAG_USES_STATIC_LIB) == false) goto L51;
        readUsesStaticLibLPw(r0, ps);
    L54:
        r0 = parser;
        outerDepth = outerDepth;
        goto L18
    L51:
        if (tagName.equals(TAG_USES_SDK_LIB) == false) goto L53;
        readUsesSdkLibLPw(r0, ps);
        goto L54
    L53:
        PackageManagerService.reportSettingsProblem(5, "Unknown element under <updated-package>: " + parser.getName());
        XmlUtils.skipCurrentTag(parser);
        goto L54
    L36:
        if (ps.hasSharedUser() == false) goto L42;
        Settings r1 = this;
        SettingBase sharedUserSettings = r1.getSettingLPr(ps.getSharedUserAppId());
        if (sharedUserSettings == null) goto L40;
        LegacyPermissionState legacyState = sharedUserSettings.getLegacyPermissionState();
    L41:
        LegacyPermissionState legacyState2 = legacyState;
    L43:
        if (legacyState2 == null) goto L54;
        r1.readInstallPermissionsLPr(r0, legacyState2, users);
        goto L54
    L40:
        legacyState = null;
        goto L41
    L42:
        r1 = this;
        legacyState2 = ps.getLegacyPermissionState();
        goto L43
    L23:
        if (r0.getDepth() > outerDepth) goto L26;
    L57:
        this.mDisabledSysPackages.put(name, ps);
        return;
    L13:
        timeStamp2 = timeStamp;
    L6:
        primaryCpuAbiStr2 = primaryCpuAbiStr;
        goto L7
    }

    /* JADX WARN: Unreachable blocks removed: 2, instructions: 10 */
    /* JADX WARN: Unreachable blocks removed: 2, instructions: 23 */
    /* JADX WARN: Unreachable blocks removed: 2, instructions: 26 */
    /* JADX WARN: Unreachable blocks removed: 2, instructions: 28 */
    /* JADX WARN: Unreachable blocks removed: 2, instructions: 30 */
    private void readPackageLPw(TypedXmlPullParser parser, ArrayList<Signature> readSignatures, ArrayMap<Long, Integer> keySetRefs, List<UserInfo> users, ArrayMap<String, Long> originalFirstInstallTimes) throws XmlPullParserException, IOException {
        String r15 = "true";
        String name = null;
        String realName = null;
        int appId = 0;
        int sharedUserAppId = 0;
        String legacyNativeLibraryPathStr = null;
        String secondaryCpuAbiString = null;
        String primaryCpuAbiString = null;
        String cpuAbiOverrideString = null;
        String cpuAbiOverrideString2 = null;
        String installerPackageName = null;
        int installerPackageUid = -1;
        String updateOwnerPackageName = null;
        String installerAttributionTag = null;
        int packageSource = 0;
        boolean isOrphaned = false;
        String installOriginatingPackageName = null;
        String installInitiatingPackageName = null;
        boolean installInitiatorUninstalled = false;
        String volumeUuid = null;
        boolean updateAvailable = false;
        int categoryHint = -1;
        int pkgFlags = 0;
        int pkgPrivateFlags = 0;
        long firstInstallTime = 0;
        PackageSetting packageSetting = null;
        long versionCode = 0;
        boolean installedForceQueryable = false;
        boolean isPendingRestore = false;
        boolean isDebuggable = false;
        float loadingProgress = 0.0f;
        long loadingCompletedTime = 0;
        String appMetadataFilePath = null;
        int appMetadataSource = 0;
        int targetSdkVersion = 0;
        byte[] restrictUpdateHash = null;
        boolean isScannedAsStoppedSystemApp = false;
        boolean isSdkLibrary = false;
        int baseRevisionCode = 0;
        int PageSizeCompat = 0;
        name = parser.getAttributeValue(null, "name");     // Catch: NumberFormatException -> L260
        realName = parser.getAttributeValue(null, "realName");     // Catch: NumberFormatException -> L258
        appId = parseAppId(parser);     // Catch: NumberFormatException -> L256
        isSdkLibrary = parser.getAttributeBoolean(null, "isSdkLibrary", false);     // Catch: NumberFormatException -> L252
        int sharedUserAppId2 = parseSharedUserAppId(parser);     // Catch: NumberFormatException -> L250
        String codePathStr = parser.getAttributeValue(null, "codePath");     // Catch: NumberFormatException -> L248
        secondaryCpuAbiString = parser.getAttributeValue(null, "requiredCpuAbi");     // Catch: NumberFormatException -> L246
        String legacyNativeLibraryPathStr2 = parser.getAttributeValue(null, "nativeLibraryPath");     // Catch: NumberFormatException -> L244
        primaryCpuAbiString = parser.getAttributeValue(null, "primaryCpuAbi");     // Catch: NumberFormatException -> L242
        cpuAbiOverrideString = parser.getAttributeValue(null, "secondaryCpuAbi");     // Catch: NumberFormatException -> L242
        String cpuAbiOverrideString3 = parser.getAttributeValue(null, "cpuAbiOverride");     // Catch: NumberFormatException -> L240
        updateAvailable = parser.getAttributeBoolean(null, "updateAvailable", false);     // Catch: NumberFormatException -> L238
        installedForceQueryable = parser.getAttributeBoolean(null, "forceQueryable", false);     // Catch: NumberFormatException -> L238
        isPendingRestore = parser.getAttributeBoolean(null, "pendingRestore", false);     // Catch: NumberFormatException -> L238
        isDebuggable = parser.getAttributeBoolean(null, "debuggable", false);     // Catch: NumberFormatException -> L238
        loadingProgress = parser.getAttributeFloat(null, "loadingProgress", 0.0f);     // Catch: NumberFormatException -> L238
        loadingCompletedTime = parser.getAttributeLongHex(null, "loadingCompletedTime", 0);     // Catch: NumberFormatException -> L236
        if (primaryCpuAbiString != null) goto L32;
        if (secondaryCpuAbiString == null) goto L32;
        primaryCpuAbiString = secondaryCpuAbiString;
    L436:
        versionCode = parser.getAttributeLong(null, "version", 0);     // Catch: NumberFormatException -> L232
        String r65 = " at ";
        targetSdkVersion = parser.getAttributeInt(null, "targetSdkVersion", 0);     // Catch: NumberFormatException -> L228
        restrictUpdateHash = parser.getAttributeBytesBase64(null, "restrictUpdateHash", null);     // Catch: NumberFormatException -> L228
        installerPackageName = parser.getAttributeValue(null, "installer");     // Catch: NumberFormatException -> L228
        installerPackageUid = parser.getAttributeInt(null, "installerUid", -1);     // Catch: NumberFormatException -> L228
        updateOwnerPackageName = parser.getAttributeValue(null, "updateOwner");     // Catch: NumberFormatException -> L228
        installerAttributionTag = parser.getAttributeValue(null, "installerAttributionTag");     // Catch: NumberFormatException -> L228
        packageSource = parser.getAttributeInt(null, "packageSource", 0);     // Catch: NumberFormatException -> L228
        isOrphaned = parser.getAttributeBoolean(null, "isOrphaned", false);     // Catch: NumberFormatException -> L228
        installInitiatingPackageName = parser.getAttributeValue(null, "installInitiator");     // Catch: NumberFormatException -> L228
        installOriginatingPackageName = parser.getAttributeValue(null, "installOriginator");     // Catch: NumberFormatException -> L228
        installInitiatorUninstalled = parser.getAttributeBoolean(null, "installInitiatorUninstalled", false);     // Catch: NumberFormatException -> L228
        volumeUuid = parser.getAttributeValue(null, ATTR_VOLUME_UUID);     // Catch: NumberFormatException -> L228
        categoryHint = parser.getAttributeInt(null, "categoryHint", -1);     // Catch: NumberFormatException -> L228
        appMetadataFilePath = parser.getAttributeValue(null, "appMetadataFilePath");     // Catch: NumberFormatException -> L228
        appMetadataSource = parser.getAttributeInt(null, "appMetadataSource", 0);     // Catch: NumberFormatException -> L228
        baseRevisionCode = parser.getAttributeInt(null, "baseRevisionCode", 0);     // Catch: NumberFormatException -> L228
        PageSizeCompat = parser.getAttributeInt(null, "pageSizeCompat", 0);     // Catch: NumberFormatException -> L228
        isScannedAsStoppedSystemApp = parser.getAttributeBoolean(null, "scannedAsStoppedSystemApp", false);     // Catch: NumberFormatException -> L228
        String domainSetIdString = parser.getAttributeValue(null, "domainSetId");     // Catch: NumberFormatException -> L228
        if (TextUtils.isEmpty(domainSetIdString) == true) goto L389;
        UUID domainSetId = UUID.fromString(domainSetIdString);     // Catch: NumberFormatException -> L228
    L46:
        String systemStr = parser.getAttributeValue(null, "publicFlags");     // Catch: NumberFormatException -> L228
        if (systemStr != null) goto L472;
        String systemStr2 = parser.getAttributeValue(null, ATTR_FLAGS);     // Catch: NumberFormatException -> L228
        if (systemStr2 != null) goto L409;
        String systemStr3 = parser.getAttributeValue(null, "system");     // Catch: NumberFormatException -> L228
        if (systemStr3 != null) goto L454;
        int pkgFlags2 = 0 | 1;
        int pkgPrivateFlags2 = 0;
    L87:
        String r73 = "Error in package manager settings: package ";
        long timeStamp = parser.getAttributeLongHex(null, "ft", 0);     // Catch: NumberFormatException -> L224
        if (timeStamp == 0) goto L403;
        long timeStamp2 = timeStamp;
    L97:
        long timeStamp3 = timeStamp2;
        firstInstallTime = parser.getAttributeLongHex(null, "it", 0);     // Catch: NumberFormatException -> L220
        long lastUpdateTime = parser.getAttributeLongHex(null, "ut", 0);     // Catch: NumberFormatException -> L220
        if (realName != null) goto L456;
        String realName2 = realName;
    L424:
        if (name != null) goto L110;
        PackageManagerService.reportSettingsProblem(5, "Error in package manager settings: <package> has no name at " + parser.getPositionDescription());     // Catch: NumberFormatException -> L108
    L423:
    L176:
        String r77 = r65;
        String name2 = name;
        String codePathStr2 = codePathStr;
        long versionCode2 = versionCode;
        r15 = "true";
        String cpuAbiOverrideString4 = cpuAbiOverrideString3;
        boolean isSdkLibrary2 = isSdkLibrary;
        realName2 = realName2;
        String r78 = r73;
        long r64 = 0;
        String secondaryCpuAbiString2 = cpuAbiOverrideString;
        long r86 = lastUpdateTime;
        int appId2 = appId;
        String legacyNativeLibraryPathStr3 = legacyNativeLibraryPathStr2;
        long lastUpdateTime2 = r86;
        long timeStamp4 = timeStamp3;
    L205:
        String updateOwnerPackageName2 = installerPackageName;
        String installerPackageName2 = installInitiatingPackageName;
        boolean isOrphaned2 = isOrphaned;
        String installerAttributionTag2 = installerAttributionTag;
        int installerPackageUid2 = installerPackageUid;
        String installOriginatingPackageName2 = installOriginatingPackageName;
        int packageSource2 = packageSource;
        String updateOwnerPackageName3 = updateOwnerPackageName;
        String legacyNativeLibraryPathStr4 = legacyNativeLibraryPathStr3;
        String primaryCpuAbiString2 = primaryCpuAbiString;
        String legacyCpuAbiString = secondaryCpuAbiString2;
        String volumeUuid2 = volumeUuid;
        boolean updateAvailable2 = updateAvailable;
        int categoryHint2 = categoryHint;
        String name3 = name2;
        String r74 = r78;
        PackageSetting packageSetting2 = packageSetting;
        boolean installedForceQueryable2 = installedForceQueryable;
        boolean isPendingRestore2 = isPendingRestore;
        float loadingProgress2 = loadingProgress;
        String legacyNativeLibraryPathStr5 = appMetadataFilePath;
        int appMetadataSource2 = appMetadataSource;
        int targetSdkVersion2 = targetSdkVersion;
        byte[] restrictUpdateHash2 = restrictUpdateHash;
        boolean isScannedAsStoppedSystemApp2 = isScannedAsStoppedSystemApp;
        int baseRevisionCode2 = baseRevisionCode;
        int PageSizeCompat2 = PageSizeCompat;
        boolean isDebuggable2 = isDebuggable;
        long loadingCompletedTime2 = loadingCompletedTime;
    L263:
        if (packageSetting2 == null) goto L377;
        int appMetadataSource3 = appMetadataSource2;
        InstallSource installSource = InstallSource.create(installerPackageName2, installOriginatingPackageName2, updateOwnerPackageName2, installerPackageUid2, updateOwnerPackageName3, installerAttributionTag2, packageSource2, isOrphaned2, installInitiatorUninstalled);
        packageSetting2.setInstallSource(installSource).setVolumeUuid(volumeUuid2).setCategoryOverride(categoryHint2).setLegacyNativeLibraryPath(legacyNativeLibraryPathStr4).setPrimaryCpuAbi(primaryCpuAbiString2).setSecondaryCpuAbi(legacyCpuAbiString).setUpdateAvailable(updateAvailable2).setForceQueryableOverride(installedForceQueryable2).setPendingRestore(isPendingRestore2).setDebuggable(isDebuggable2).setLoadingProgress(loadingProgress2).setLoadingCompletedTime(loadingCompletedTime2).setAppMetadataFilePath(legacyNativeLibraryPathStr5).setAppMetadataSource(appMetadataSource3).setTargetSdkVersion(targetSdkVersion2).setBaseRevisionCode(baseRevisionCode2).setRestrictUpdateHash(restrictUpdateHash2).setScannedAsStoppedSystemApp(isScannedAsStoppedSystemApp2).setPageSizeAppCompatFlags(PageSizeCompat2);
        String enabledStr = parser.getAttributeValue(null, "enabled");
        if (enabledStr != null) goto L387;
        String name4 = name3;
        packageSetting2.setEnabled(0, 0, "settings");
    L286:
        addInstallerPackageNames(installSource);
        int outerDepth = parser.getDepth();
    L287:
        int type = parser.next();
        enabledStr = enabledStr;
        if (type == 1) goto L373;
        if (type != 3) goto L296;
        if (parser.getDepth() <= outerDepth) goto L373;
    L296:
        if (type != 3) goto L298;
        installSource = installSource;
        name4 = name4;
        goto L287
    L298:
        if (type == 4) goto L287;
        String tagName = parser.getName();
        if (tagName == null) goto L287;
        int outerDepth2 = outerDepth;
        if (tagName.equals(TAG_DISABLED_COMPONENTS) == false) goto L306;
        InstallSource installSource2 = installSource;
        readDisabledComponentsLPw(packageSetting2, parser, 0);
        name4 = name4;
        String legacyNativeLibraryPathStr6 = legacyNativeLibraryPathStr4;
        String secondaryCpuAbiString3 = legacyCpuAbiString;
        String volumeUuid3 = volumeUuid2;
    L369:
        outerDepth = outerDepth2;
        installSource = installSource2;
        name4 = name4;
        legacyNativeLibraryPathStr4 = legacyNativeLibraryPathStr6;
        legacyCpuAbiString = secondaryCpuAbiString3;
        volumeUuid2 = volumeUuid3;
        goto L287
    L306:
        installSource2 = installSource;
        if (tagName.equals(TAG_ENABLED_COMPONENTS) == false) goto L310;
        readEnabledComponentsLPw(packageSetting2, parser, 0);
        name4 = name4;
        legacyNativeLibraryPathStr6 = legacyNativeLibraryPathStr4;
        secondaryCpuAbiString3 = legacyCpuAbiString;
        volumeUuid3 = volumeUuid2;
        goto L369
    L310:
        if (tagName.equals("sigs") == false) goto L313;
        packageSetting2.getSignatures().readXml(parser, readSignatures);
        name4 = name4;
        legacyNativeLibraryPathStr6 = legacyNativeLibraryPathStr4;
        secondaryCpuAbiString3 = legacyCpuAbiString;
        volumeUuid3 = volumeUuid2;
        goto L369
    L313:
        if (tagName.equals(TAG_PERMISSIONS) == true) goto L315;
        name4 = name4;
        if (tagName.equals("proper-signing-keyset") == false) goto L334;
        legacyNativeLibraryPathStr6 = legacyNativeLibraryPathStr4;
        secondaryCpuAbiString3 = legacyCpuAbiString;
        long id = parser.getAttributeLong(null, "identifier");
        Integer refCt = keySetRefs.get(Long.valueOf(id));
        if (refCt == null) goto L331;
        keySetRefs.put(Long.valueOf(id), Integer.valueOf(refCt.intValue() + 1));
    L332:
        packageSetting2.getKeySetData().setProperSigningKeySet(id);
    L333:
        volumeUuid3 = volumeUuid2;
        goto L369
    L331:
        keySetRefs.put(Long.valueOf(id), 1);
        goto L332
    L334:
        legacyNativeLibraryPathStr6 = legacyNativeLibraryPathStr4;
        secondaryCpuAbiString3 = legacyCpuAbiString;
        if (tagName.equals("signing-keyset") == true) goto L333;
        if (tagName.equals("upgrade-keyset") == false) goto L340;
        volumeUuid3 = volumeUuid2;
        packageSetting2.getKeySetData().addUpgradeKeySetById(parser.getAttributeLong(null, "identifier"));
        goto L369
    L340:
        volumeUuid3 = volumeUuid2;
        if (tagName.equals("defined-keyset") == false) goto L348;
        long id2 = parser.getAttributeLong(null, "identifier");
        String alias = parser.getAttributeValue(null, "alias");
        Integer refCt2 = keySetRefs.get(Long.valueOf(id2));
        if (refCt2 == null) goto L345;
        keySetRefs.put(Long.valueOf(id2), Integer.valueOf(refCt2.intValue() + 1));
    L346:
        packageSetting2.getKeySetData().addDefinedKeySet(id2, alias);
        goto L369
    L345:
        keySetRefs.put(Long.valueOf(id2), 1);
        goto L346
    L348:
        if (tagName.equals("install-initiator-sigs") == false) goto L351;
        PackageSignatures signatures = new PackageSignatures();
        signatures.readXml(parser, readSignatures);
        packageSetting2.setInstallSource(packageSetting2.getInstallSource().setInitiatingPackageSignatures(signatures));
        goto L369
    L351:
        if (tagName.equals(TAG_DOMAIN_VERIFICATION) == false) goto L354;
        IntentFilterVerificationInfo ivi = new IntentFilterVerificationInfo(parser);
        this.mDomainVerificationManager.addLegacySetting(packageSetting2.getPackageName(), ivi);
        goto L369
    L354:
        if (tagName.equals(TAG_MIME_GROUP) == false) goto L360;
        Pair<String, Set<String>> groupToMimeTypes = readMimeGroupLPw(parser);
        if (groupToMimeTypes == null) goto L369;
        packageSetting2.addMimeTypes((String) groupToMimeTypes.first, (Set) groupToMimeTypes.second);
        goto L369
    L360:
        if (tagName.equals(TAG_USES_STATIC_LIB) == false) goto L363;
        readUsesStaticLibLPw(parser, packageSetting2);
        goto L369
    L363:
        if (tagName.equals(TAG_USES_SDK_LIB) == false) goto L366;
        readUsesSdkLibLPw(parser, packageSetting2);
        goto L369
    L366:
        if (tagName.equals(TAG_SPLIT_VERSION) == false) goto L368;
        readSplitVersionsLPw(parser, packageSetting2);
        goto L369
    L368:
        PackageManagerService.reportSettingsProblem(5, "Unknown element under <package>: " + parser.getName());
        XmlUtils.skipCurrentTag(parser);
        goto L369
    L315:
        if (packageSetting2.hasSharedUser() == false) goto L321;
        SettingBase sharedUserSettings = getSettingLPr(packageSetting2.getSharedUserAppId());
        if (sharedUserSettings == null) goto L319;
        LegacyPermissionState legacyState = sharedUserSettings.getLegacyPermissionState();
    L320:
        LegacyPermissionState legacyState2 = legacyState;
    L322:
        if (legacyState2 == null) goto L325;
        readInstallPermissionsLPr(parser, legacyState2, users);
        packageSetting2.setInstallPermissionsFixed(true);
    L325:
        legacyNativeLibraryPathStr6 = legacyNativeLibraryPathStr4;
        secondaryCpuAbiString3 = legacyCpuAbiString;
        volumeUuid3 = volumeUuid2;
        goto L369
    L319:
        legacyState = null;
        goto L320
    L321:
        LegacyPermissionState legacyState3 = packageSetting2.getLegacyPermissionState();
        legacyState2 = legacyState3;
    L373:
        if (firstInstallTime == r64) goto L491;
        originalFirstInstallTimes.put(packageSetting2.getPackageName(), Long.valueOf(firstInstallTime));
        return;
    L491:
        return;
    L387:
        packageSetting2.setEnabled(Integer.parseInt(enabledStr), 0, "settings");     // Catch: NumberFormatException -> L270
        name4 = name3;
    L275:
        if (enabledStr.equalsIgnoreCase(r15) == false) goto L278;
        packageSetting2.setEnabled(1, 0, "settings");
        name4 = name3;
        goto L286
    L278:
        if (enabledStr.equalsIgnoreCase("false") == false) goto L281;
        packageSetting2.setEnabled(2, 0, "settings");
        name4 = name3;
        goto L286
    L281:
        if (enabledStr.equalsIgnoreCase("default") == false) goto L283;
        packageSetting2.setEnabled(0, 0, "settings");
        name4 = name3;
        goto L286
    L283:
        StringBuilder r2 = new StringBuilder();
        r2.append(r74);
        name4 = name3;
        r2.append(name4);
        r2.append(" has bad enabled value: ");
        r2.append(enabledStr);
        r2.append(r77);
        r2.append(parser.getPositionDescription());
        PackageManagerService.reportSettingsProblem(5, r2.toString());
        goto L286
    L377:
        XmlUtils.skipCurrentTag(parser);
        return;
    L110:
        if (codePathStr != null) goto L113;
        PackageManagerService.reportSettingsProblem(5, "Error in package manager settings: <package> has no codePath at " + parser.getPositionDescription());     // Catch: NumberFormatException -> L108
        goto L423
    L113:
        if (appId <= 0) goto L115;
        String realName3 = realName2;
        String r76 = " has bad appId ";
        codePathStr2 = codePathStr;
        legacyNativeLibraryPathStr3 = legacyNativeLibraryPathStr2;
        r15 = "true";
        name2 = name;
        r77 = r65;
        realName2 = realName3;
        int pkgPrivateFlags3 = pkgPrivateFlags2;
        r78 = r73;
        r64 = 0;
        secondaryCpuAbiString2 = cpuAbiOverrideString;
        versionCode2 = versionCode;
        cpuAbiOverrideString4 = cpuAbiOverrideString3;
        int appId3 = pkgFlags2;
        PackageSetting packageSetting3 = addPackageLPw(name.intern(), realName2, new File(codePathStr), appId, appId3, pkgPrivateFlags3, domainSetId, isSdkLibrary, false);     // Catch: NumberFormatException -> L214
        isSdkLibrary2 = isSdkLibrary;
        if (packageSetting3 == null) goto L468;
        packageSetting3.setLegacyNativeLibraryPath(legacyNativeLibraryPathStr3);     // Catch: NumberFormatException -> L212
        packageSetting3.setPrimaryCpuAbi(primaryCpuAbiString);     // Catch: NumberFormatException -> L212
        packageSetting3.setSecondaryCpuAbi(secondaryCpuAbiString2);     // Catch: NumberFormatException -> L212
        packageSetting3.setCpuAbiOverride(cpuAbiOverrideString4);     // Catch: NumberFormatException -> L212
        packageSetting3.setLongVersionCode(versionCode2);     // Catch: NumberFormatException -> L210
        timeStamp4 = timeStamp3;
        packageSetting3.setLastModifiedTime(timeStamp4);     // Catch: NumberFormatException -> L208
        appId2 = appId;
        versionCode2 = versionCode2;
        lastUpdateTime2 = lastUpdateTime;
        packageSetting3.setLastUpdateTime(lastUpdateTime2);     // Catch: NumberFormatException -> L206
    L204:
        packageSetting = packageSetting3;
    L207:
        packageSetting = packageSetting3;
        appId = appId2;
        String legacyNativeLibraryPathStr7 = legacyNativeLibraryPathStr3;
        cpuAbiOverrideString2 = cpuAbiOverrideString4;
        versionCode = versionCode2;
        sharedUserAppId = sharedUserAppId2;
        legacyNativeLibraryPathStr = codePathStr2;
        name = name2;
        secondaryCpuAbiString = secondaryCpuAbiString;
        pkgFlags = pkgFlags2;
        pkgPrivateFlags = pkgPrivateFlags2;
        isSdkLibrary = isSdkLibrary2;
        realName = realName2;
        primaryCpuAbiString = primaryCpuAbiString;
        cpuAbiOverrideString = secondaryCpuAbiString2;
    L262:
        StringBuilder r1 = new StringBuilder();
        String r3 = r78;
        r1.append(r3);
        r1.append(name);
        r1.append(r76);
        r1.append(appId);
        r1.append(r77);
        r1.append(parser.getPositionDescription());
        PackageManagerService.reportSettingsProblem(5, r1.toString());
        legacyNativeLibraryPathStr4 = legacyNativeLibraryPathStr7;
        volumeUuid2 = volumeUuid;
        String r4 = updateOwnerPackageName;
        updateOwnerPackageName2 = installerPackageName;
        installerPackageName2 = installInitiatingPackageName;
        isOrphaned2 = isOrphaned;
        installerAttributionTag2 = installerAttributionTag;
        installerPackageUid2 = installerPackageUid;
        installOriginatingPackageName2 = installOriginatingPackageName;
        packageSource2 = packageSource;
        updateOwnerPackageName3 = r4;
        r74 = r3;
        primaryCpuAbiString2 = primaryCpuAbiString;
        legacyCpuAbiString = cpuAbiOverrideString;
        updateAvailable2 = updateAvailable;
        categoryHint2 = categoryHint;
        name3 = name;
        isDebuggable2 = isDebuggable;
        loadingProgress2 = loadingProgress;
        loadingCompletedTime2 = loadingCompletedTime;
        legacyNativeLibraryPathStr5 = appMetadataFilePath;
        targetSdkVersion2 = targetSdkVersion;
        restrictUpdateHash2 = restrictUpdateHash;
        isScannedAsStoppedSystemApp2 = isScannedAsStoppedSystemApp;
        baseRevisionCode2 = baseRevisionCode;
        PageSizeCompat2 = PageSizeCompat;
        packageSetting2 = packageSetting;
        installedForceQueryable2 = installedForceQueryable;
        isPendingRestore2 = isPendingRestore;
        appMetadataSource2 = appMetadataSource;
    L209:
        packageSetting = packageSetting3;
        appId = appId;
        legacyNativeLibraryPathStr7 = legacyNativeLibraryPathStr3;
        cpuAbiOverrideString2 = cpuAbiOverrideString4;
        versionCode = versionCode2;
        sharedUserAppId = sharedUserAppId2;
        legacyNativeLibraryPathStr = codePathStr2;
        name = name2;
        secondaryCpuAbiString = secondaryCpuAbiString;
        pkgFlags = pkgFlags2;
        pkgPrivateFlags = pkgPrivateFlags2;
        isSdkLibrary = isSdkLibrary2;
        realName = realName2;
        primaryCpuAbiString = primaryCpuAbiString;
        cpuAbiOverrideString = secondaryCpuAbiString2;
    L211:
        packageSetting = packageSetting3;
        appId = appId;
        legacyNativeLibraryPathStr7 = legacyNativeLibraryPathStr3;
        cpuAbiOverrideString2 = cpuAbiOverrideString4;
        versionCode = versionCode2;
        sharedUserAppId = sharedUserAppId2;
        legacyNativeLibraryPathStr = codePathStr2;
        name = name2;
        secondaryCpuAbiString = secondaryCpuAbiString;
        pkgFlags = pkgFlags2;
        pkgPrivateFlags = pkgPrivateFlags2;
        isSdkLibrary = isSdkLibrary2;
        realName = realName2;
        primaryCpuAbiString = primaryCpuAbiString;
        cpuAbiOverrideString = secondaryCpuAbiString2;
    L213:
        packageSetting = packageSetting3;
        appId = appId;
        legacyNativeLibraryPathStr7 = legacyNativeLibraryPathStr3;
        cpuAbiOverrideString2 = cpuAbiOverrideString4;
        versionCode = versionCode2;
        sharedUserAppId = sharedUserAppId2;
        legacyNativeLibraryPathStr = codePathStr2;
        name = name2;
        secondaryCpuAbiString = secondaryCpuAbiString;
        pkgFlags = pkgFlags2;
        pkgPrivateFlags = pkgPrivateFlags2;
        isSdkLibrary = isSdkLibrary2;
        realName = realName2;
        primaryCpuAbiString = primaryCpuAbiString;
        cpuAbiOverrideString = secondaryCpuAbiString2;
        goto L262
    L468:
        PackageManagerService.reportSettingsProblem(6, "Failure adding appId " + appId + " while parsing settings at " + parser.getPositionDescription());     // Catch: NumberFormatException -> L195
        appId2 = appId;
        timeStamp4 = timeStamp3;
        lastUpdateTime2 = lastUpdateTime;
    L196:
        packageSetting = packageSetting3;
        appId = appId;
        legacyNativeLibraryPathStr7 = legacyNativeLibraryPathStr3;
        cpuAbiOverrideString2 = cpuAbiOverrideString4;
        versionCode = versionCode2;
        sharedUserAppId = sharedUserAppId2;
        legacyNativeLibraryPathStr = codePathStr2;
        name = name2;
        secondaryCpuAbiString = secondaryCpuAbiString;
        pkgFlags = pkgFlags2;
        pkgPrivateFlags = pkgPrivateFlags2;
        isSdkLibrary = isSdkLibrary2;
        realName = realName2;
        primaryCpuAbiString = primaryCpuAbiString;
        cpuAbiOverrideString = secondaryCpuAbiString2;
    L215:
        appId = appId;
        legacyNativeLibraryPathStr7 = legacyNativeLibraryPathStr3;
        cpuAbiOverrideString2 = cpuAbiOverrideString4;
        versionCode = versionCode2;
        sharedUserAppId = sharedUserAppId2;
        legacyNativeLibraryPathStr = codePathStr2;
        name = name2;
        secondaryCpuAbiString = secondaryCpuAbiString;
        pkgFlags = appId3;
        pkgPrivateFlags = pkgPrivateFlags3;
        isSdkLibrary = isSdkLibrary;
        realName = realName2;
        primaryCpuAbiString = primaryCpuAbiString;
        cpuAbiOverrideString = secondaryCpuAbiString2;
    L217:
        r76 = " has bad appId ";
        r15 = "true";
        r77 = r65;
        r78 = r73;
        r64 = 0;
        appId = appId;
        legacyNativeLibraryPathStr7 = legacyNativeLibraryPathStr2;
        cpuAbiOverrideString2 = cpuAbiOverrideString3;
        versionCode = versionCode;
        sharedUserAppId = sharedUserAppId2;
        legacyNativeLibraryPathStr = codePathStr;
        name = name;
        secondaryCpuAbiString = secondaryCpuAbiString;
        pkgFlags = pkgFlags2;
        pkgPrivateFlags = pkgPrivateFlags2;
        isSdkLibrary = isSdkLibrary;
        realName = realName3;
        primaryCpuAbiString = primaryCpuAbiString;
        cpuAbiOverrideString = cpuAbiOverrideString;
    L219:
        r76 = " has bad appId ";
        r15 = "true";
        r77 = r65;
        r78 = r73;
        r64 = 0;
        appId = appId;
        legacyNativeLibraryPathStr7 = legacyNativeLibraryPathStr2;
        cpuAbiOverrideString2 = cpuAbiOverrideString3;
        versionCode = versionCode;
        sharedUserAppId = sharedUserAppId2;
        legacyNativeLibraryPathStr = codePathStr;
        secondaryCpuAbiString = secondaryCpuAbiString;
        pkgFlags = pkgFlags2;
        pkgPrivateFlags = pkgPrivateFlags2;
        isSdkLibrary = isSdkLibrary;
        realName = realName3;
        primaryCpuAbiString = primaryCpuAbiString;
        cpuAbiOverrideString = cpuAbiOverrideString;
        goto L262
    L115:
        if (appId != (-1)) goto L117;
        if (isSdkLibrary == true) goto L117;
    L117:
        if (sharedUserAppId2 == 0) goto L168;
        if (sharedUserAppId2 > 0) goto L419;
        cpuAbiOverrideString3 = cpuAbiOverrideString3;
        lastUpdateTime = lastUpdateTime;
        StringBuilder r0 = new StringBuilder();     // Catch: NumberFormatException -> L166
        String r5 = r73;
        r0.append(r5);     // Catch: NumberFormatException -> L164
        r0.append(name);     // Catch: NumberFormatException -> L164
        r0.append(" has bad sharedUserAppId ");     // Catch: NumberFormatException -> L164
        r0.append(sharedUserAppId2);     // Catch: NumberFormatException -> L164
        r65 = r65;
        r0.append(r65);     // Catch: NumberFormatException -> L161
        realName2 = realName2;
        r0.append(parser.getPositionDescription());     // Catch: NumberFormatException -> L158
        PackageManagerService.reportSettingsProblem(5, r0.toString());     // Catch: NumberFormatException -> L158
        r73 = r5;
    L159:
        r78 = r5;
        r77 = r65;
        cpuAbiOverrideString2 = cpuAbiOverrideString3;
        r76 = " has bad appId ";
    L160:
        r64 = 0;
        legacyNativeLibraryPathStr7 = legacyNativeLibraryPathStr2;
        pkgFlags = pkgFlags2;
        pkgPrivateFlags = pkgPrivateFlags2;
        legacyNativeLibraryPathStr = codePathStr;
        sharedUserAppId = sharedUserAppId2;
        realName = realName2;
    L163:
        r78 = r5;
        r77 = r65;
        cpuAbiOverrideString = cpuAbiOverrideString;
        primaryCpuAbiString = primaryCpuAbiString;
        versionCode = versionCode;
        r15 = "true";
        cpuAbiOverrideString2 = cpuAbiOverrideString3;
        secondaryCpuAbiString = secondaryCpuAbiString;
        r76 = " has bad appId ";
        r64 = 0;
        legacyNativeLibraryPathStr7 = legacyNativeLibraryPathStr2;
        pkgFlags = pkgFlags2;
        pkgPrivateFlags = pkgPrivateFlags2;
        legacyNativeLibraryPathStr = codePathStr;
        sharedUserAppId = sharedUserAppId2;
        realName = realName2;
    L165:
        r65 = r65;
    L167:
        r65 = r65;
        r5 = r73;
        goto L163
    L419:
        String realName4 = realName2;
        PackageSetting packageSetting4 = new PackageSetting(name.intern(), realName4, new File(codePathStr), pkgFlags2, pkgPrivateFlags2, domainSetId).setLegacyNativeLibraryPath(legacyNativeLibraryPathStr2).setPrimaryCpuAbi(primaryCpuAbiString).setSecondaryCpuAbi(cpuAbiOverrideString).setCpuAbiOverride(cpuAbiOverrideString3).setLongVersionCode(versionCode).setSharedUserAppId(sharedUserAppId2).setLastModifiedTime(timeStamp3).setLastUpdateTime(lastUpdateTime);     // Catch: NumberFormatException -> L139
        this.mPendingPackages.add(packageSetting4);     // Catch: NumberFormatException -> L135
        packageSetting = packageSetting4;
        name2 = name;
        codePathStr2 = codePathStr;
        versionCode2 = versionCode;
        r15 = "true";
        cpuAbiOverrideString4 = cpuAbiOverrideString3;
        isSdkLibrary2 = isSdkLibrary;
        r77 = r65;
        r78 = r73;
        r64 = 0;
        secondaryCpuAbiString2 = cpuAbiOverrideString;
        appId2 = appId;
        legacyNativeLibraryPathStr3 = legacyNativeLibraryPathStr2;
        lastUpdateTime2 = lastUpdateTime;
        timeStamp4 = timeStamp3;
    L136:
        packageSetting = packageSetting4;
        cpuAbiOverrideString = cpuAbiOverrideString;
        primaryCpuAbiString = primaryCpuAbiString;
        versionCode = versionCode;
        r15 = "true";
        cpuAbiOverrideString2 = cpuAbiOverrideString3;
        secondaryCpuAbiString = secondaryCpuAbiString;
        r76 = " has bad appId ";
        r77 = r65;
        r78 = r73;
        r64 = 0;
        legacyNativeLibraryPathStr7 = legacyNativeLibraryPathStr2;
        pkgFlags = pkgFlags2;
        pkgPrivateFlags = pkgPrivateFlags2;
        legacyNativeLibraryPathStr = codePathStr;
        sharedUserAppId = sharedUserAppId2;
        realName = realName2;
    L138:
        packageSetting = packageSetting4;
        cpuAbiOverrideString = cpuAbiOverrideString;
        primaryCpuAbiString = primaryCpuAbiString;
        versionCode = versionCode;
        r15 = "true";
        cpuAbiOverrideString2 = cpuAbiOverrideString3;
        secondaryCpuAbiString = secondaryCpuAbiString;
        r76 = " has bad appId ";
        r77 = r65;
        r78 = r73;
        r64 = 0;
        legacyNativeLibraryPathStr7 = legacyNativeLibraryPathStr2;
        pkgFlags = pkgFlags2;
        pkgPrivateFlags = pkgPrivateFlags2;
        legacyNativeLibraryPathStr = codePathStr;
        sharedUserAppId = sharedUserAppId2;
        realName = realName2;
    L140:
        cpuAbiOverrideString = cpuAbiOverrideString;
        primaryCpuAbiString = primaryCpuAbiString;
        versionCode = versionCode;
        r15 = "true";
        cpuAbiOverrideString2 = cpuAbiOverrideString3;
        secondaryCpuAbiString = secondaryCpuAbiString;
        r76 = " has bad appId ";
        r77 = r65;
        r78 = r73;
        r64 = 0;
        legacyNativeLibraryPathStr7 = legacyNativeLibraryPathStr2;
        pkgFlags = pkgFlags2;
        pkgPrivateFlags = pkgPrivateFlags2;
        legacyNativeLibraryPathStr = codePathStr;
        sharedUserAppId = sharedUserAppId2;
        realName = realName2;
    L142:
        cpuAbiOverrideString = cpuAbiOverrideString;
        primaryCpuAbiString = primaryCpuAbiString;
        versionCode = versionCode;
        r15 = "true";
        cpuAbiOverrideString2 = cpuAbiOverrideString3;
        secondaryCpuAbiString = secondaryCpuAbiString;
        r76 = " has bad appId ";
        r77 = r65;
        r78 = r73;
        r64 = 0;
        legacyNativeLibraryPathStr7 = legacyNativeLibraryPathStr2;
        pkgFlags = pkgFlags2;
        pkgPrivateFlags = pkgPrivateFlags2;
        legacyNativeLibraryPathStr = codePathStr;
        sharedUserAppId = sharedUserAppId2;
        realName = realName2;
    L144:
        cpuAbiOverrideString = cpuAbiOverrideString;
        primaryCpuAbiString = primaryCpuAbiString;
        versionCode = versionCode;
        r15 = "true";
        cpuAbiOverrideString2 = cpuAbiOverrideString3;
        secondaryCpuAbiString = secondaryCpuAbiString;
        r76 = " has bad appId ";
        r77 = r65;
        r78 = r73;
        r64 = 0;
        legacyNativeLibraryPathStr7 = legacyNativeLibraryPathStr2;
        pkgFlags = pkgFlags2;
        pkgPrivateFlags = pkgPrivateFlags2;
        legacyNativeLibraryPathStr = codePathStr;
        sharedUserAppId = sharedUserAppId2;
        realName = realName2;
    L148:
        cpuAbiOverrideString = cpuAbiOverrideString;
        primaryCpuAbiString = primaryCpuAbiString;
        versionCode = versionCode;
        r15 = "true";
        cpuAbiOverrideString2 = cpuAbiOverrideString3;
        secondaryCpuAbiString = secondaryCpuAbiString;
        r76 = " has bad appId ";
        r77 = r65;
        r78 = r73;
        r64 = 0;
        legacyNativeLibraryPathStr7 = legacyNativeLibraryPathStr2;
        pkgFlags = pkgFlags2;
        pkgPrivateFlags = pkgPrivateFlags2;
        legacyNativeLibraryPathStr = codePathStr;
        sharedUserAppId = sharedUserAppId2;
        realName = realName4;
    L146:
        cpuAbiOverrideString = cpuAbiOverrideString;
        primaryCpuAbiString = primaryCpuAbiString;
        versionCode = versionCode;
        r15 = "true";
        cpuAbiOverrideString2 = cpuAbiOverrideString3;
        secondaryCpuAbiString = secondaryCpuAbiString;
        r76 = " has bad appId ";
        r77 = r65;
        r78 = r73;
        r64 = 0;
        legacyNativeLibraryPathStr7 = legacyNativeLibraryPathStr2;
        pkgFlags = pkgFlags2;
        pkgPrivateFlags = pkgPrivateFlags2;
        legacyNativeLibraryPathStr = codePathStr;
        sharedUserAppId = sharedUserAppId2;
        realName = realName2;
        goto L262
    L168:
        realName2 = realName2;
        cpuAbiOverrideString3 = cpuAbiOverrideString3;
        lastUpdateTime = lastUpdateTime;
        r65 = r65;
        StringBuilder r6 = new StringBuilder();     // Catch: NumberFormatException -> L183
        r6.append(r73);     // Catch: NumberFormatException -> L183
        r6.append(name);     // Catch: NumberFormatException -> L183
        String r7 = " has bad appId ";
        r6.append(r7);     // Catch: NumberFormatException -> L181
        r6.append(appId);     // Catch: NumberFormatException -> L181
        r6.append(r65);     // Catch: NumberFormatException -> L181
        r73 = r73;
        r6.append(parser.getPositionDescription());     // Catch: NumberFormatException -> L179
        PackageManagerService.reportSettingsProblem(5, r6.toString());     // Catch: NumberFormatException -> L177
    L178:
        r77 = r65;
        r76 = r7;
        cpuAbiOverrideString2 = cpuAbiOverrideString3;
        r78 = r73;
    L182:
        r73 = r73;
    L184:
        r73 = r73;
        r7 = " has bad appId ";
    L109:
        legacyNativeLibraryPathStr7 = legacyNativeLibraryPathStr2;
        primaryCpuAbiString = primaryCpuAbiString;
        versionCode = versionCode;
        r15 = "true";
        cpuAbiOverrideString2 = cpuAbiOverrideString3;
        r76 = " has bad appId ";
        r77 = r65;
        pkgFlags = pkgFlags2;
        pkgPrivateFlags = pkgPrivateFlags2;
        r78 = r73;
        r64 = 0;
        legacyNativeLibraryPathStr = codePathStr;
        cpuAbiOverrideString = cpuAbiOverrideString;
        secondaryCpuAbiString = secondaryCpuAbiString;
        sharedUserAppId = sharedUserAppId2;
        realName = realName2;
        goto L262
    L456:
        realName2 = realName.intern();     // Catch: NumberFormatException -> L103
    L104:
        legacyNativeLibraryPathStr7 = legacyNativeLibraryPathStr2;
        primaryCpuAbiString = primaryCpuAbiString;
        versionCode = versionCode;
        r15 = "true";
        cpuAbiOverrideString2 = cpuAbiOverrideString3;
        r76 = " has bad appId ";
        r77 = r65;
        pkgFlags = pkgFlags2;
        pkgPrivateFlags = pkgPrivateFlags2;
        r78 = r73;
        r64 = 0;
        legacyNativeLibraryPathStr = codePathStr;
        cpuAbiOverrideString = cpuAbiOverrideString;
        secondaryCpuAbiString = secondaryCpuAbiString;
        sharedUserAppId = sharedUserAppId2;
        realName = realName;
    L221:
        r15 = "true";
        r76 = " has bad appId ";
        r77 = r65;
        r78 = r73;
        r64 = 0;
        legacyNativeLibraryPathStr7 = legacyNativeLibraryPathStr2;
        cpuAbiOverrideString2 = cpuAbiOverrideString3;
        versionCode = versionCode;
        sharedUserAppId = sharedUserAppId2;
        legacyNativeLibraryPathStr = codePathStr;
        realName = realName;
        secondaryCpuAbiString = secondaryCpuAbiString;
        pkgFlags = pkgFlags2;
        pkgPrivateFlags = pkgPrivateFlags2;
        isSdkLibrary = isSdkLibrary;
        primaryCpuAbiString = primaryCpuAbiString;
        cpuAbiOverrideString = cpuAbiOverrideString;
        goto L262
    L403:
        timeStamp2 = parser.getAttributeLong(null, "ts", 0);     // Catch: NumberFormatException -> L93
    L94:
        legacyNativeLibraryPathStr7 = legacyNativeLibraryPathStr2;
        primaryCpuAbiString = primaryCpuAbiString;
        versionCode = versionCode;
        r15 = "true";
        cpuAbiOverrideString2 = cpuAbiOverrideString3;
        r76 = " has bad appId ";
        r77 = r65;
        pkgFlags = pkgFlags2;
        pkgPrivateFlags = pkgPrivateFlags2;
        r78 = r73;
        r64 = 0;
        legacyNativeLibraryPathStr = codePathStr;
        cpuAbiOverrideString = cpuAbiOverrideString;
        secondaryCpuAbiString = secondaryCpuAbiString;
        sharedUserAppId = sharedUserAppId2;
        realName = realName;
    L225:
        r15 = "true";
        r76 = " has bad appId ";
        r77 = r65;
        r78 = r73;
        r64 = 0;
        legacyNativeLibraryPathStr7 = legacyNativeLibraryPathStr2;
        cpuAbiOverrideString2 = cpuAbiOverrideString3;
        versionCode = versionCode;
        sharedUserAppId = sharedUserAppId2;
        legacyNativeLibraryPathStr = codePathStr;
        realName = realName;
        secondaryCpuAbiString = secondaryCpuAbiString;
        pkgFlags = pkgFlags2;
        pkgPrivateFlags = pkgPrivateFlags2;
        isSdkLibrary = isSdkLibrary;
        primaryCpuAbiString = primaryCpuAbiString;
        cpuAbiOverrideString = cpuAbiOverrideString;
        goto L262
    L454:
        if ("true".equalsIgnoreCase(systemStr3) == false) goto L81;
        int r8 = 1;
    L82:
        pkgFlags2 = 0 | r8;
        pkgPrivateFlags2 = 0;
        goto L87
    L81:
        r8 = 0;
    L84:
        r78 = "Error in package manager settings: package ";
        legacyNativeLibraryPathStr7 = legacyNativeLibraryPathStr2;
        primaryCpuAbiString = primaryCpuAbiString;
        versionCode = versionCode;
        r15 = "true";
        cpuAbiOverrideString2 = cpuAbiOverrideString3;
        r76 = " has bad appId ";
        r77 = r65;
        r64 = 0;
        legacyNativeLibraryPathStr = codePathStr;
        cpuAbiOverrideString = cpuAbiOverrideString;
        secondaryCpuAbiString = secondaryCpuAbiString;
        sharedUserAppId = sharedUserAppId2;
        realName = realName;
        goto L262
    L409:
        pkgFlags = Integer.parseInt(systemStr2);     // Catch: NumberFormatException -> L64
    L66:
        if ((pkgFlags & 134217728) == 0) goto L69;
        pkgPrivateFlags = 0 | 1;
    L69:
        if ((pkgFlags & 268435456) == 0) goto L72;
        pkgPrivateFlags = pkgPrivateFlags | 2;
    L72:
        if ((pkgFlags & 1073741824) == 0) goto L74;
        pkgPrivateFlags = pkgPrivateFlags | 8;
    L74:
        pkgFlags2 = pkgFlags & (-1476395009);
        pkgPrivateFlags2 = pkgPrivateFlags;
        goto L87
    L472:
        pkgFlags = Integer.parseInt(systemStr);     // Catch: NumberFormatException -> L51
    L52:
        String systemStr4 = parser.getAttributeValue(null, "privateFlags");     // Catch: NumberFormatException -> L43
        if (systemStr4 != null) goto L450;
    L58:
        pkgFlags2 = pkgFlags;
        pkgPrivateFlags2 = 0;
        goto L87
    L450:
        pkgFlags2 = pkgFlags;
        pkgPrivateFlags2 = Integer.parseInt(systemStr4);     // Catch: NumberFormatException -> L57
    L44:
        r78 = "Error in package manager settings: package ";
        legacyNativeLibraryPathStr7 = legacyNativeLibraryPathStr2;
        primaryCpuAbiString = primaryCpuAbiString;
        versionCode = versionCode;
        r15 = "true";
        cpuAbiOverrideString2 = cpuAbiOverrideString3;
        r76 = " has bad appId ";
        r77 = r65;
        r64 = 0;
        legacyNativeLibraryPathStr = codePathStr;
        cpuAbiOverrideString = cpuAbiOverrideString;
        secondaryCpuAbiString = secondaryCpuAbiString;
        sharedUserAppId = sharedUserAppId2;
        realName = realName;
        goto L262
    L389:
        domainSetId = this.mDomainVerificationManager.generateNewId();     // Catch: NumberFormatException -> L43
    L229:
        r78 = "Error in package manager settings: package ";
        r15 = "true";
        r76 = " has bad appId ";
        r77 = r65;
        r64 = 0;
        legacyNativeLibraryPathStr7 = legacyNativeLibraryPathStr2;
        cpuAbiOverrideString2 = cpuAbiOverrideString3;
        versionCode = versionCode;
        sharedUserAppId = sharedUserAppId2;
        legacyNativeLibraryPathStr = codePathStr;
        realName = realName;
        secondaryCpuAbiString = secondaryCpuAbiString;
        isSdkLibrary = isSdkLibrary;
        primaryCpuAbiString = primaryCpuAbiString;
        cpuAbiOverrideString = cpuAbiOverrideString;
    L233:
        r77 = " at ";
        r78 = "Error in package manager settings: package ";
        r15 = "true";
        r76 = " has bad appId ";
        r64 = 0;
        legacyNativeLibraryPathStr7 = legacyNativeLibraryPathStr2;
        primaryCpuAbiString = primaryCpuAbiString;
        cpuAbiOverrideString2 = cpuAbiOverrideString3;
        cpuAbiOverrideString = cpuAbiOverrideString;
        sharedUserAppId = sharedUserAppId2;
        legacyNativeLibraryPathStr = codePathStr;
        realName = realName;
        secondaryCpuAbiString = secondaryCpuAbiString;
        isSdkLibrary = isSdkLibrary;
    L32:
        primaryCpuAbiString = primaryCpuAbiString;
    L237:
        r77 = " at ";
        r78 = "Error in package manager settings: package ";
        r64 = 0;
        r76 = " has bad appId ";
        r15 = "true";
        legacyNativeLibraryPathStr7 = legacyNativeLibraryPathStr2;
        cpuAbiOverrideString2 = cpuAbiOverrideString3;
        cpuAbiOverrideString = cpuAbiOverrideString;
        sharedUserAppId = sharedUserAppId2;
        legacyNativeLibraryPathStr = codePathStr;
        realName = realName;
        secondaryCpuAbiString = secondaryCpuAbiString;
        isSdkLibrary = isSdkLibrary;
    L239:
        r77 = " at ";
        r78 = "Error in package manager settings: package ";
        r76 = " has bad appId ";
        r15 = "true";
        r64 = 0;
        legacyNativeLibraryPathStr7 = legacyNativeLibraryPathStr2;
        cpuAbiOverrideString2 = cpuAbiOverrideString3;
        cpuAbiOverrideString = cpuAbiOverrideString;
        sharedUserAppId = sharedUserAppId2;
        legacyNativeLibraryPathStr = codePathStr;
        realName = realName;
        secondaryCpuAbiString = secondaryCpuAbiString;
        isSdkLibrary = isSdkLibrary;
    L241:
        r77 = " at ";
        r78 = "Error in package manager settings: package ";
        r76 = " has bad appId ";
        r15 = "true";
        r64 = 0;
        legacyNativeLibraryPathStr7 = legacyNativeLibraryPathStr2;
        cpuAbiOverrideString = cpuAbiOverrideString;
        sharedUserAppId = sharedUserAppId2;
        legacyNativeLibraryPathStr = codePathStr;
        realName = realName;
        secondaryCpuAbiString = secondaryCpuAbiString;
        isSdkLibrary = isSdkLibrary;
    L243:
        r77 = " at ";
        r78 = "Error in package manager settings: package ";
        r76 = " has bad appId ";
        r15 = "true";
        r64 = 0;
        legacyNativeLibraryPathStr7 = legacyNativeLibraryPathStr2;
        sharedUserAppId = sharedUserAppId2;
        legacyNativeLibraryPathStr = codePathStr;
        realName = realName;
        secondaryCpuAbiString = secondaryCpuAbiString;
        isSdkLibrary = isSdkLibrary;
    L245:
        r77 = " at ";
        r78 = "Error in package manager settings: package ";
        r76 = " has bad appId ";
        r15 = "true";
        r64 = 0;
        sharedUserAppId = sharedUserAppId2;
        legacyNativeLibraryPathStr7 = null;
        legacyNativeLibraryPathStr = codePathStr;
        realName = realName;
        secondaryCpuAbiString = secondaryCpuAbiString;
        isSdkLibrary = isSdkLibrary;
    L247:
        r77 = " at ";
        r78 = "Error in package manager settings: package ";
        r76 = " has bad appId ";
        r15 = "true";
        r64 = 0;
        sharedUserAppId = sharedUserAppId2;
        legacyNativeLibraryPathStr7 = null;
        legacyNativeLibraryPathStr = codePathStr;
        realName = realName;
        isSdkLibrary = isSdkLibrary;
    L249:
        r77 = " at ";
        r78 = "Error in package manager settings: package ";
        r76 = " has bad appId ";
        r15 = "true";
        r64 = 0;
        sharedUserAppId = sharedUserAppId2;
        legacyNativeLibraryPathStr7 = null;
        realName = realName;
        isSdkLibrary = isSdkLibrary;
    L251:
        r77 = " at ";
        r78 = "Error in package manager settings: package ";
        r76 = " has bad appId ";
        r15 = "true";
        r64 = 0;
        legacyNativeLibraryPathStr7 = null;
        realName = realName;
    L253:
        r77 = " at ";
        r78 = "Error in package manager settings: package ";
        r76 = " has bad appId ";
        r15 = "true";
        r64 = 0;
        legacyNativeLibraryPathStr7 = null;
        realName = realName;
    L257:
        r77 = " at ";
        r78 = "Error in package manager settings: package ";
        r76 = " has bad appId ";
        r15 = "true";
        r64 = 0;
        legacyNativeLibraryPathStr7 = null;
    L259:
        r77 = " at ";
        r78 = "Error in package manager settings: package ";
        r76 = " has bad appId ";
        r15 = "true";
        r64 = 0;
        legacyNativeLibraryPathStr7 = null;
    L261:
        r77 = " at ";
        r78 = "Error in package manager settings: package ";
        r76 = " has bad appId ";
        r15 = "true";
        r64 = 0;
        legacyNativeLibraryPathStr7 = null;
        goto L262
    }

    private static int parseAppId(TypedXmlPullParser parser) {
        return parser.getAttributeInt(null, "userId", 0);
    }

    private static int parseSharedUserAppId(TypedXmlPullParser parser) {
        return parser.getAttributeInt(null, "sharedUserId", 0);
    }

    void addInstallerPackageNames(InstallSource installSource) {
        if (installSource.mInstallerPackageName == null) goto L6;
        this.mInstallerPackages.add(installSource.mInstallerPackageName);
    L6:
        if (installSource.mInitiatingPackageName == null) goto L9;
        this.mInstallerPackages.add(installSource.mInitiatingPackageName);
    L9:
        if (installSource.mOriginatingPackageName == null) goto L12;
        this.mInstallerPackages.add(installSource.mOriginatingPackageName);
        return;
    }

    private Pair<String, Set<String>> readMimeGroupLPw(TypedXmlPullParser parser) throws XmlPullParserException, IOException {
        String groupName = parser.getAttributeValue(null, "name");
        if (groupName != null) goto L6;
        XmlUtils.skipCurrentTag(parser);
        return null;
    L6:
        Set<String> mimeTypes = new ArraySet();
        int outerDepth = parser.getDepth();
    L7:
        int type = parser.next();
        if (type == 1) goto L30;
        if (type == 3) goto L12;
    L14:
        if (type == 3) goto L7;
        if (type == 4) goto L7;
        String tagName = parser.getName();
        if (tagName == null) goto L7;
        if (tagName.equals(TAG_MIME_TYPE) == true) goto L23;
        PackageManagerService.reportSettingsProblem(5, "Unknown element under <mime-group>: " + parser.getName());
        XmlUtils.skipCurrentTag(parser);
        goto L7
    L23:
        String typeName = parser.getAttributeValue(null, ATTR_VALUE);
        if (typeName == null) goto L7;
        mimeTypes.add(typeName);
        goto L7
    L12:
        if (parser.getDepth() > outerDepth) goto L14;
    L30:
        return Pair.create(groupName, mimeTypes);
    }

    private void writeMimeGroupLPr(TypedXmlSerializer serializer, Map<String, Set<String>> mimeGroups) throws IOException {
        if (mimeGroups != null) goto L4;
        return;
    L4:
        Iterator<String> r0 = mimeGroups.keySet().iterator();
    L6:
        if (r0.hasNext() == false) goto L12;
        String mimeGroup = r0.next();
        serializer.startTag(null, TAG_MIME_GROUP);
        serializer.attribute(null, "name", mimeGroup);
        Iterator<String> r4 = mimeGroups.get(mimeGroup).iterator();
    L9:
        if (r4.hasNext() == false) goto L11;
        String mimeType = r4.next();
        serializer.startTag(null, TAG_MIME_TYPE);
        serializer.attribute(null, ATTR_VALUE, mimeType);
        serializer.endTag(null, TAG_MIME_TYPE);
        goto L9
    L11:
        serializer.endTag(null, TAG_MIME_GROUP);
        goto L6
    }

    private void readSplitVersionsLPw(TypedXmlPullParser parser, PackageSetting outPs) throws IOException, XmlPullParserException {
        String splitName = parser.getAttributeValue(null, "name");
        int splitRevision = parser.getAttributeInt(null, "version", -1);
        if (splitName == null) goto L9;
        if (splitRevision < 0) goto L9;
        int beforeSplitNamesLength = outPs.getSplitNames().length;
        outPs.setSplitNames((String[]) ArrayUtils.appendElement(String.class, outPs.getSplitNames(), splitName));
        int afterSplitNamesLength = outPs.getSplitNames().length;
        if (beforeSplitNamesLength != afterSplitNamesLength) goto L8;
        int index = ArrayUtils.indexOf(outPs.getSplitNames(), splitName);
        int[] splitRevisionCodes = outPs.getSplitRevisionCodes();
        splitRevisionCodes[index] = splitRevision;
        outPs.setSplitRevisionCodes(splitRevisionCodes);
        goto L9
    L8:
        outPs.setSplitRevisionCodes(ArrayUtils.appendInt(outPs.getSplitRevisionCodes(), splitRevision, true));
    L9:
        XmlUtils.skipCurrentTag(parser);
    }

    private void writeSplitVersionsLPr(TypedXmlSerializer serializer, String[] splitNames, int[] splitRevisionCodes) throws IOException {
        if (ArrayUtils.isEmpty(splitNames) == false) goto L5;
        return;
    L5:
        if (ArrayUtils.isEmpty(splitRevisionCodes) == false) goto L7;
        return;
    L7:
        if (splitNames.length != splitRevisionCodes.length) goto L17;
        int libLength = splitNames.length;
        int i = 0;
    L10:
        if (i >= libLength) goto L13;
        String splitName = splitNames[i];
        int splitRevision = splitRevisionCodes[i];
        serializer.startTag(null, TAG_SPLIT_VERSION);
        serializer.attribute(null, "name", splitName);
        serializer.attributeInt(null, "version", splitRevision);
        serializer.endTag(null, TAG_SPLIT_VERSION);
        i = i + 1;
        goto L10
    L13:
        return;
    }

    private void readDisabledComponentsLPw(PackageSetting packageSetting, TypedXmlPullParser parser, int userId) throws IOException, XmlPullParserException {
        int outerDepth = parser.getDepth();
    L3:
        int type = parser.next();
        if (type == 1) goto L26;
        if (type == 3) goto L8;
    L10:
        if (type == 3) goto L3;
        if (type == 4) goto L3;
        String tagName = parser.getName();
        if (tagName == null) goto L3;
        if (tagName.equals(TAG_ITEM) == false) goto L24;
        String name = parser.getAttributeValue(null, "name");
        if (name == null) goto L22;
        packageSetting.addDisabledComponent(name.intern(), userId);
    L25:
        XmlUtils.skipCurrentTag(parser);
        goto L3
    L22:
        PackageManagerService.reportSettingsProblem(5, "Error in package manager settings: <disabled-components> has no name at " + parser.getPositionDescription());
        goto L25
    L24:
        PackageManagerService.reportSettingsProblem(5, "Unknown element under <disabled-components>: " + parser.getName());
        goto L25
    L8:
        if (parser.getDepth() > outerDepth) goto L10;
        return;
    }

    private void readEnabledComponentsLPw(PackageSetting packageSetting, TypedXmlPullParser parser, int userId) throws IOException, XmlPullParserException {
        int outerDepth = parser.getDepth();
    L3:
        int type = parser.next();
        if (type == 1) goto L26;
        if (type == 3) goto L8;
    L10:
        if (type == 3) goto L3;
        if (type == 4) goto L3;
        String tagName = parser.getName();
        if (tagName == null) goto L3;
        if (tagName.equals(TAG_ITEM) == false) goto L24;
        String name = parser.getAttributeValue(null, "name");
        if (name == null) goto L22;
        packageSetting.addEnabledComponent(name.intern(), userId);
    L25:
        XmlUtils.skipCurrentTag(parser);
        goto L3
    L22:
        PackageManagerService.reportSettingsProblem(5, "Error in package manager settings: <enabled-components> has no name at " + parser.getPositionDescription());
        goto L25
    L24:
        PackageManagerService.reportSettingsProblem(5, "Unknown element under <enabled-components>: " + parser.getName());
        goto L25
    L8:
        if (parser.getDepth() > outerDepth) goto L10;
        return;
    }

    private void readSharedUserLPw(TypedXmlPullParser parser, ArrayList<Signature> readSignatures, List<UserInfo> users) throws XmlPullParserException, IOException {
        int pkgFlags = 0;
        SharedUserSetting su = null;
        String name = parser.getAttributeValue(null, "name");
        int appId = parseAppId(parser);
        if (parser.getAttributeBoolean(null, "system", false) == false) goto L6;
        pkgFlags = 0 | 1;
    L6:
        if (name != null) goto L8;
        PackageManagerService.reportSettingsProblem(5, "Error in package manager settings: <shared-user> has no name at " + parser.getPositionDescription());
    L13:
        if (su == null) goto L38;
        int outerDepth = parser.getDepth();
    L15:
        int type = parser.next();
        if (type == 1) goto L56;
        if (type == 3) goto L20;
    L22:
        if (type == 3) goto L15;
        if (type == 4) goto L15;
        String tagName = parser.getName();
        if (tagName == null) goto L15;
        if (tagName.equals("sigs") == true) goto L31;
        if (tagName.equals(TAG_PERMISSIONS) == true) goto L34;
        PackageManagerService.reportSettingsProblem(5, "Unknown element under <shared-user>: " + parser.getName());
        XmlUtils.skipCurrentTag(parser);
        goto L15
    L34:
        readInstallPermissionsLPr(parser, su.getLegacyPermissionState(), users);
        goto L15
    L31:
        su.signatures.readXml(parser, readSignatures);
        goto L15
    L20:
        if (parser.getDepth() > outerDepth) goto L22;
        return;
    L56:
        return;
    L38:
        XmlUtils.skipCurrentTag(parser);
        return;
    L8:
        if (appId != 0) goto L10;
        PackageManagerService.reportSettingsProblem(5, "Error in package manager settings: shared-user " + name + " has bad appId " + appId + " at " + parser.getPositionDescription());
        goto L13
    L10:
        SharedUserSetting r6 = addSharedUserLPw(name.intern(), appId, pkgFlags, 0);
        su = r6;
        if (r6 != null) goto L13;
        PackageManagerService.reportSettingsProblem(6, "Occurred while parsing settings at " + parser.getPositionDescription());
        goto L13
    }

    void createNewUserLI(PackageManagerService service, Installer installer, int userHandle, Set<String> userTypeInstallablePackages, String[] disallowedPackages) {
        TimingsTraceAndSlog t = new TimingsTraceAndSlog("PackageSettingsTiming", 262144);
        t.traceBegin("createNewUser-" + userHandle);
        Installer.Batch batch = new Installer.Batch();
        boolean r0 = false;
        if (userTypeInstallablePackages != null) goto L5;
        boolean r3 = true;
    L6:
        boolean skipPackageAllowList = r3;
        long currentTimeMillis = System.currentTimeMillis();
        PackageManagerTracedLock r6 = this.mLock;
        PackageManagerService.boostPriorityForPackageManagerTracedLockedSection();
        monitor-enter(r6);
        int size = this.mPackages.size();     // Catch: Throwable -> L87
        int i = 0;
    L9:
        if (i >= size) goto L89;
        PackageSetting ps = this.mPackages.valueAt(i);     // Catch: Throwable -> L87
        if (ps.getPkg() == null) goto L119;
        if (ps.isSystem() == false) goto L28;
        if (ArrayUtils.contains(disallowedPackages, ps.getPackageName()) == true) goto L28;
        if (ps.getPkgState().isHiddenUntilInstalled() == true) goto L28;
        boolean r10 = true;
    L29:
        boolean shouldMaybeInstall = r10;
        if (shouldMaybeInstall == false) goto L35;
        if (skipPackageAllowList == false) goto L33;
    L34:
        boolean shouldReallyInstall = true;
    L37:
        if (userHandle != 10) goto L41;
        ps.setInstalled(DoppelgangerConfigure.DOPPELGANGER_NECESSARY_PACKAGES.contains(ps.getPackageName()), userHandle);     // Catch: Throwable -> L25
    L42:
        if (shouldReallyInstall == false) goto L127;
        ps.setFirstInstallTime(currentTimeMillis, userHandle);     // Catch: Throwable -> L25
    L127:
        if (service.mShouldStopSystemPackagesByDefault == true) goto L47;
    L53:
        boolean shouldBeStopped = false;
    L55:
        if (shouldBeStopped == false) goto L60;
        Intent launcherIntent = new Intent("android.intent.action.MAIN");     // Catch: Throwable -> L25
        launcherIntent.addCategory("android.intent.category.LAUNCHER");     // Catch: Throwable -> L25
        launcherIntent.setPackage(ps.getPackageName());     // Catch: Throwable -> L25
        List<ResolveInfo> launcherActivities = service.snapshotComputer().queryIntentActivitiesInternal(launcherIntent, null, 786432, 0);     // Catch: Throwable -> L25
        if (launcherActivities.isEmpty() == false) goto L60;
        boolean shouldBeStopped2 = false;
    L61:
        ps.setStopped(shouldBeStopped2, userHandle);     // Catch: Throwable -> L83
        if (shouldMaybeInstall == false) goto L65;
        if (shouldReallyInstall == true) goto L65;
        int uninstallReason = 1;
    L66:
        ps.setUninstallReason(uninstallReason, userHandle);     // Catch: Throwable -> L83
        if (shouldReallyInstall == true) goto L69;
        writeKernelMappingLPr(ps);     // Catch: Throwable -> L79
    L115:
        i = i + 1;     // Catch: Throwable -> L79
        size = size;
        currentTimeMillis = currentTimeMillis;
        r6 = r6;
        r0 = false;
    L79:
        th = th;
    L117:
        monitor-exit(r6);     // Catch: Throwable -> L109
        PackageManagerService.resetPriorityAfterPackageManagerTracedLockedSection();
        throw th;
    L109:
        th = th;
        goto L117
    L69:
        if (ps.getAppId() < 0) goto L115;
        String seInfo = ps.getSeInfo();     // Catch: Throwable -> L83
        if (ps.getPkg().getUsesSdkLibraries().isEmpty() == true) goto L74;
        boolean usesSdk = true;
    L121:
        String r4 = ps.getVolumeUuid();     // Catch: Throwable -> L81
        String r5 = ps.getPackageName();     // Catch: Throwable -> L81
        int uninstallReason2 = ps.getAppId();     // Catch: Throwable -> L81
        int uninstallReason3 = ps.getPkg().getTargetSdkVersion();     // Catch: Throwable -> L81
        CreateAppDataArgs args = Installer.buildCreateAppDataArgs(r4, r5, userHandle, 1, uninstallReason2, seInfo, uninstallReason3, usesSdk);     // Catch: Throwable -> L79
        batch.createAppData(args);     // Catch: Throwable -> L79
    L81:
        th = th;
        r6 = r6;
        goto L117
    L74:
        usesSdk = false;
    L65:
        uninstallReason = 0;
    L60:
        shouldBeStopped2 = shouldBeStopped;
        goto L61
    L47:
        if (ps.isSystem() == false) goto L53;
        if (ps.isApex() == true) goto L53;
        if (service.mInitialNonStoppedSystemPackages.contains(ps.getPackageName()) == true) goto L53;
        shouldBeStopped = true;
    L83:
        th = th;
    L84:
        r6 = r6;
        goto L117
    L41:
        ps.setInstalled(shouldReallyInstall, userHandle);     // Catch: Throwable -> L83
        goto L42
    L33:
        if (userTypeInstallablePackages.contains(ps.getPackageName()) == true) goto L34;
    L35:
        shouldReallyInstall = r0;
    L25:
        th = th;
        r6 = r6;
    L28:
        r10 = r0;
        goto L29
    L119:
        ps.setInstalled(r0, userHandle);     // Catch: Throwable -> L14
        writeKernelMappingLPr(ps);     // Catch: Throwable -> L14
        size = size;
    L14:
        th = th;
        r6 = r6;
        goto L117
    L89:
        r6 = r6;
        monitor-exit(r6);     // Catch: Throwable -> L79
        PackageManagerService.resetPriorityAfterPackageManagerTracedLockedSection();
        t.traceBegin("createAppData");
        batch.execute(installer);     // Catch: Installer.InstallerException -> L94
    L96:
        t.traceEnd();
        PackageManagerTracedLock r7 = this.mLock;
        PackageManagerService.boostPriorityForPackageManagerTracedLockedSection();
        monitor-enter(r7);
        applyDefaultPreferredAppsLPw(userHandle);     // Catch: Throwable -> L102
        monitor-exit(r7);     // Catch: Throwable -> L102
        PackageManagerService.resetPriorityAfterPackageManagerTracedLockedSection();
        t.traceEnd();
        return;
    L102:
        th = move-exception;
        PackageManagerService.resetPriorityAfterPackageManagerTracedLockedSection();
        throw th;
    L94:
        e = move-exception;
        Slog.w(TAG, "Failed to prepare app data", e);
    L87:
        th = th;
        goto L84
    L5:
        r3 = false;
        goto L6
    }

    void removeUserLPw(int userId) {
        Set<Map.Entry<String, PackageSetting>> entries = this.mPackages.entrySet();
        Iterator<Map.Entry<String, PackageSetting>> r1 = entries.iterator();
    L4:
        if (r1.hasNext() == false) goto L6;
        Map.Entry<String, PackageSetting> entry = r1.next();
        entry.getValue().removeUser(userId);
        goto L4
    L6:
        this.mPreferredActivities.remove(userId);
        Object r2 = this.mPackageRestrictionsLock;
        monitor-enter(r2);
        getUserPackagesStateFile(userId).delete();     // Catch: Throwable -> L12
        this.mPendingAsyncPackageRestrictionsWrites.delete(userId);     // Catch: Throwable -> L12
        monitor-exit(r2);     // Catch: Throwable -> L12
        removeCrossProfileIntentFiltersLPw(userId);
        RuntimePermissionPersistence.m6895$$Nest$monUserRemoved(this.mRuntimePermissionsPersistence, userId);
        this.mDomainVerificationManager.clearUser(userId);
        writePackageListLPr();
        writeKernelRemoveUserLPr(userId);
        return;
    L12:
        th = move-exception;
        throw th;
    }

    void removeCrossProfileIntentFiltersLPw(int userId) {
        WatchedSparseArray<CrossProfileIntentResolver> r0 = this.mCrossProfileIntentResolvers;
        monitor-enter(r0);
    L7:
        th = move-exception;
        throw th;
    L5:
        if (this.mCrossProfileIntentResolvers.get(userId) == null) goto L9;
        this.mCrossProfileIntentResolvers.remove(userId);     // Catch: Throwable -> L7
        writePackageRestrictionsLPr(userId);     // Catch: Throwable -> L7
    L9:
        int count = this.mCrossProfileIntentResolvers.size();     // Catch: Throwable -> L7
        int i = 0;
    L10:
        if (i >= count) goto L22;
        int sourceUserId = this.mCrossProfileIntentResolvers.keyAt(i);     // Catch: Throwable -> L7
        CrossProfileIntentResolver cpir = this.mCrossProfileIntentResolvers.get(sourceUserId);     // Catch: Throwable -> L7
        boolean needsWriting = false;
        ArraySet<CrossProfileIntentFilter> cpifs = new ArraySet(cpir.filterSet());     // Catch: Throwable -> L7
        Iterator<CrossProfileIntentFilter> r7 = cpifs.iterator();     // Catch: Throwable -> L7
    L13:
        if (r7.hasNext() == false) goto L18;
        CrossProfileIntentFilter cpif = r7.next();     // Catch: Throwable -> L7
        if (cpif.getTargetUserId() != userId) goto L13;
        needsWriting = true;
        cpir.removeFilter(cpif);     // Catch: Throwable -> L7
        goto L13
    L18:
        if (needsWriting == false) goto L20;
        writePackageRestrictionsLPr(sourceUserId);     // Catch: Throwable -> L7
    L20:
        i = i + 1;     // Catch: Throwable -> L7
        goto L10
    L22:
        monitor-exit(r0);     // Catch: Throwable -> L7
    }

    public VerifierDeviceIdentity getVerifierDeviceIdentityLPw(Computer computer) {
        if (this.mVerifierDeviceIdentity != null) goto L6;
        this.mVerifierDeviceIdentity = VerifierDeviceIdentity.generate();
        writeLPr(computer, false);
    L6:
        return this.mVerifierDeviceIdentity;
    }

    public PackageSetting getDisabledSystemPkgLPr(String name) {
        PackageSetting ps = this.mDisabledSysPackages.get(name);
        return ps;
    }

    public PackageSetting getDisabledSystemPkgLPr(PackageSetting enabledPackageSetting) {
        if (enabledPackageSetting != null) goto L6;
        return null;
    L6:
        return getDisabledSystemPkgLPr(enabledPackageSetting.getPackageName());
    }

    int getApplicationEnabledSettingLPr(String packageName, int userId) throws PackageManager.NameNotFoundException {
        PackageSetting pkg = this.mPackages.get(packageName);
        if (pkg == null) goto L7;
        return pkg.getEnabled(userId);
    L7:
        throw new PackageManager.NameNotFoundException(packageName);
    }

    int getComponentEnabledSettingLPr(ComponentName componentName, int userId) throws PackageManager.NameNotFoundException {
        String packageName = componentName.getPackageName();
        PackageSetting pkg = this.mPackages.get(packageName);
        if (pkg == null) goto L7;
        String classNameStr = componentName.getClassName();
        return pkg.getCurrentEnabledStateLPr(classNameStr, userId);
    L7:
        throw new PackageManager.NameNotFoundException(componentName.getPackageName());
    }

    SharedUserSetting getSharedUserSettingLPr(String packageName) {
        PackageSetting ps = this.mPackages.get(packageName);
        return getSharedUserSettingLPr(ps);
    }

    SharedUserSetting getSharedUserSettingLPr(PackageSetting ps) {
        if (ps != null) goto L4;
        return null;
    L4:
        if (ps.hasSharedUser() == true) goto L7;
        return null;
    L7:
        return (SharedUserSetting) getSettingLPr(ps.getSharedUserAppId());
    }

    protected static List<UserInfo> getAllUsers(UserManagerService userManager) {
        return getUsers(userManager, false, false);
    }

    private static List<UserInfo> getActiveUsers(UserManagerService userManager, boolean excludeDying) {
        return getUsers(userManager, excludeDying, true);
    }

    private static List<UserInfo> getUsers(UserManagerService userManager, boolean excludeDying, boolean excludePreCreated) {
        long id = Binder.clearCallingIdentity();
        List<UserInfo> r2 = userManager.getUsers(true, excludeDying, excludePreCreated);     // Catch: Throwable -> L6 NullPointerException -> L9
        Binder.restoreCallingIdentity(id);
        return r2;
    L6:
        th = move-exception;
        Binder.restoreCallingIdentity(id);
        throw th;
    L10:
        Binder.restoreCallingIdentity(id);
        return null;
    }

    List<? extends PackageStateInternal> getVolumePackagesLPr(String volumeUuid) {
        ArrayList<PackageStateInternal> res = new ArrayList();
        int i = 0;
    L4:
        if (i >= this.mPackages.size()) goto L10;
        PackageSetting setting = this.mPackages.valueAt(i);
        if (Objects.equals(volumeUuid, setting.getVolumeUuid()) == false) goto L8;
        res.add(setting);
    L8:
        i = i + 1;
        goto L4
    L10:
        return res;
    }

    static void printFlags(PrintWriter pw, int val, Object[] spec) {
        pw.print("[ ");
        int i = 0;
    L4:
        if (i >= spec.length) goto L9;
        int mask = ((Integer) spec[i]).intValue();
        if ((val & mask) == 0) goto L8;
        pw.print(spec[i + 1]);
        pw.print(" ");
    L8:
        i = i + 2;
        goto L4
    L9:
        pw.print("]");
    }

    static {
        FLAG_DUMP_SPEC = new Object[]{1, "SYSTEM", 2, "DEBUGGABLE", 4, "HAS_CODE", 8, "PERSISTENT", 16, "FACTORY_TEST", 32, "ALLOW_TASK_REPARENTING", 64, "ALLOW_CLEAR_USER_DATA", 128, "UPDATED_SYSTEM_APP", 256, "TEST_ONLY", 16384, "VM_SAFE_MODE", 32768, "ALLOW_BACKUP", 65536, "KILL_AFTER_RESTORE", 131072, "RESTORE_ANY_VERSION", 262144, "EXTERNAL_STORAGE", 1048576, "LARGE_HEAP"};
        PRIVATE_FLAG_DUMP_SPEC = new Object[]{1024, "PRIVATE_FLAG_ACTIVITIES_RESIZE_MODE_RESIZEABLE", 4096, "PRIVATE_FLAG_ACTIVITIES_RESIZE_MODE_RESIZEABLE_VIA_SDK_VERSION", 2048, "PRIVATE_FLAG_ACTIVITIES_RESIZE_MODE_UNRESIZEABLE", 134217728, "ALLOW_AUDIO_PLAYBACK_CAPTURE", 536870912, "PRIVATE_FLAG_REQUEST_LEGACY_EXTERNAL_STORAGE", 8192, "BACKUP_IN_FOREGROUND", 2, "CANT_SAVE_STATE", 32, "DEFAULT_TO_DEVICE_PROTECTED_STORAGE", 64, "DIRECT_BOOT_AWARE", 16, "HAS_DOMAIN_URLS", 1, "HIDDEN", 128, "EPHEMERAL", 32768, "ISOLATED_SPLIT_LOADING", 131072, "OEM", 256, "PARTIALLY_DIRECT_BOOT_AWARE", 8, "PRIVILEGED", 512, "REQUIRED_FOR_SYSTEM_USER", 16384, "STATIC_SHARED_LIBRARY", 262144, "VENDOR", 524288, "PRODUCT", 2097152, "SYSTEM_EXT", 65536, "VIRTUAL_PRELOAD", 1073741824, "ODM", Integer.MIN_VALUE, "PRIVATE_FLAG_ALLOW_NATIVE_HEAP_POINTER_TAGGING", 16777216, "PRIVATE_FLAG_HAS_FRAGILE_USER_DATA"};
    }

    void dumpVersionLPr(IndentingPrintWriter pw) {
        pw.increaseIndent();
        int i = 0;
    L4:
        if (i >= this.mVersion.size()) goto L13;
        String volumeUuid = this.mVersion.keyAt(i);
        VersionInfo ver = this.mVersion.valueAt(i);
        if (Objects.equals(StorageManager.UUID_PRIVATE_INTERNAL, volumeUuid) == false) goto L9;
        pw.println("Internal:");
    L12:
        pw.increaseIndent();
        pw.printPair(ATTR_SDK_VERSION, Integer.valueOf(ver.sdkVersion));
        pw.printPair(ATTR_DATABASE_VERSION, Integer.valueOf(ver.databaseVersion));
        pw.println();
        pw.printPair(ATTR_BUILD_FINGERPRINT, ver.buildFingerprint);
        pw.printPair(ATTR_FINGERPRINT, ver.fingerprint);
        pw.println();
        pw.decreaseIndent();
        i = i + 1;
        goto L4
    L9:
        if (Objects.equals("primary_physical", volumeUuid) == false) goto L11;
        pw.println("External:");
        goto L12
    L11:
        pw.println("UUID " + volumeUuid + ":");
        goto L12
    L13:
        pw.decreaseIndent();
    }

    @NeverCompile
    void dumpPackageLPr(PrintWriter pw, String prefix, String checkinTag, ArraySet<String> permissionNames, PackageSetting ps, LegacyPermissionState permissionsState, SimpleDateFormat sdf, Date date, List<UserInfo> users, boolean dumpAll, boolean dumpAllComponents) {
        String r6 = prefix;
        AndroidPackageInternal r10 = ps.getPkg();
        if (checkinTag == null) goto L71;
        pw.print(checkinTag);
        pw.print(",");
        if (ps.getRealName() == null) goto L7;
        String r4 = ps.getRealName();
    L8:
        pw.print(r4);
        pw.print(",");
        pw.print(ps.getAppId());
        pw.print(",");
        pw.print(ps.getVersionCode());
        pw.print(",");
        pw.print(ps.getLastUpdateTime());
        pw.print(",");
        String r5 = "?";
        if (ps.getInstallSource().mInstallerPackageName == null) goto L11;
        String r7 = ps.getInstallSource().mInstallerPackageName;
    L12:
        pw.print(r7);
        pw.print(ps.getInstallSource().mInstallerPackageUid);
        if (ps.getInstallSource().mUpdateOwnerPackageName == null) goto L15;
        String r8 = ps.getInstallSource().mUpdateOwnerPackageName;
    L16:
        pw.print(r8);
        if (ps.getInstallSource().mInstallerAttributionTag == null) goto L19;
        String r9 = "(" + ps.getInstallSource().mInstallerAttributionTag + ")";
    L20:
        pw.print(r9);
        pw.print(",");
        pw.print(ps.getInstallSource().mPackageSource);
        pw.println();
        String r11 = "-";
        if (r10 == null) goto L26;
        pw.print(checkinTag);
        pw.print("-");
        pw.print("splt,");
        pw.print("base,");
        pw.println(r10.getBaseRevisionCode());
        int[] splitRevisionCodes = r10.getSplitRevisionCodes();
        int i = 0;
    L24:
        if (i >= r10.getSplitNames().length) goto L26;
        pw.print(checkinTag);
        pw.print("-");
        pw.print("splt,");
        pw.print(r10.getSplitNames()[i]);
        pw.print(",");
        pw.println(splitRevisionCodes[i]);
        i = i + 1;
    L26:
        Iterator<UserInfo> r12 = users.iterator();
    L28:
        if (r12.hasNext() == false) goto L70;
        UserInfo user = r12.next();
        PackageUserStateInternal userState = ps.getUserStateOrDefault(user.id);
        pw.print(checkinTag);
        pw.print(r11);
        pw.print("usr");
        pw.print(",");
        pw.print(user.id);
        pw.print(",");
        if (userState.isInstalled() == false) goto L32;
        String r14 = "I";
    L33:
        pw.print(r14);
        if (userState.isHidden() == false) goto L36;
        String r15 = "B";
    L37:
        pw.print(r15);
        if (userState.isSuspended() == false) goto L40;
        String r16 = "SU";
    L41:
        pw.print(r16);
        if (userState.isStopped() == false) goto L44;
        String r17 = "S";
    L45:
        pw.print(r17);
        if (userState.isNotLaunched() == false) goto L48;
        String r18 = "l";
    L49:
        pw.print(r18);
        if (userState.isInstantApp() == false) goto L52;
        String r19 = "IA";
    L53:
        pw.print(r19);
        if (userState.isVirtualPreload() == false) goto L56;
        String r110 = "VPI";
    L57:
        pw.print(r110);
        if (userState.isQuarantined() == false) goto L60;
        String r111 = "Q";
    L61:
        pw.print(r111);
        if (userState.getHarmfulAppWarning() == null) goto L64;
        String r112 = "HA";
    L65:
        pw.print(r112);
        pw.print(",");
        pw.print(userState.getEnabledState());
        String lastDisabledAppCaller = userState.getLastDisableAppCaller();
        pw.print(",");
        String r113 = r11;
        if (lastDisabledAppCaller == null) goto L68;
        String r13 = lastDisabledAppCaller;
    L69:
        pw.print(r13);
        pw.print(",");
        pw.print(ps.readUserState(user.id).getFirstInstallTimeMillis());
        pw.print(",");
        pw.println();
        r11 = r113;
        r5 = r5;
        goto L28
    L68:
        r13 = r5;
        goto L69
    L64:
        r112 = "ha";
        goto L65
    L60:
        r111 = "q";
        goto L61
    L56:
        r110 = "vpi";
        goto L57
    L52:
        r19 = "ia";
        goto L53
    L48:
        r18 = "L";
        goto L49
    L44:
        r17 = "s";
        goto L45
    L40:
        r16 = "su";
        goto L41
    L36:
        r15 = "b";
        goto L37
    L32:
        r14 = "i";
        goto L33
    L70:
        return;
    L19:
        r9 = "";
        goto L20
    L15:
        r8 = "?";
        goto L16
    L11:
        r7 = "?";
        goto L12
    L7:
        r4 = ps.getPackageName();
        goto L8
    L71:
        pw.print(prefix);
        pw.print("Package [");
        if (ps.getRealName() == null) goto L74;
        String r2 = ps.getRealName();
    L75:
        pw.print(r2);
        pw.print("] (");
        pw.print(Integer.toHexString(System.identityHashCode(ps)));
        pw.println("):");
        if (ps.getRealName() == null) goto L78;
        pw.print(prefix);
        pw.print("  compat name=");
        pw.println(ps.getPackageName());
    L78:
        pw.print(prefix);
        pw.print("  appId=");
        pw.println(ps.getAppId());
        SharedUserSetting sharedUserSetting = getSharedUserSettingLPr(ps);
        if (sharedUserSetting == null) goto L81;
        pw.print(prefix);
        pw.print("  sharedUser=");
        pw.println(sharedUserSetting);
    L81:
        pw.print(prefix);
        pw.print("  pkg=");
        pw.println(r10);
        pw.print(prefix);
        pw.print("  codePath=");
        pw.println(ps.getPathString());
        if (ps.getOldPaths() != null) goto L84;
    L89:
        if (permissionNames != null) goto L95;
        pw.print(prefix);
        pw.print("  resourcePath=");
        pw.println(ps.getPathString());
        pw.print(prefix);
        pw.print("  legacyNativeLibraryDir=");
        pw.println(ps.getLegacyNativeLibraryPath());
        pw.print(prefix);
        pw.print("  extractNativeLibs=");
        if ((ps.getFlags() & 268435456) == 0) goto L93;
        String r3 = "true";
    L94:
        pw.println(r3);
        pw.print(prefix);
        pw.print("  primaryCpuAbi=");
        pw.println(ps.getPrimaryCpuAbiLegacy());
        pw.print(prefix);
        pw.print("  secondaryCpuAbi=");
        pw.println(ps.getSecondaryCpuAbiLegacy());
        pw.print(prefix);
        pw.print("  cpuAbiOverride=");
        pw.println(ps.getCpuAbiOverride());
        goto L95
    L93:
        r3 = "false";
    L95:
        pw.print(prefix);
        pw.print("  versionCode=");
        pw.print(ps.getVersionCode());
        if (r10 == null) goto L98;
        pw.print(" minSdk=");
        pw.print(r10.getMinSdkVersion());
    L98:
        pw.print(" targetSdk=");
        pw.println(ps.getTargetSdkVersion());
        if (r10 == null) goto L108;
        SparseIntArray minExtensionVersions = r10.getMinExtensionVersions();
        pw.print(prefix);
        pw.print("  minExtensionVersions=[");
        if (minExtensionVersions == null) goto L107;
        List<String> minExtVerStrings = new ArrayList();
        int size = minExtensionVersions.size();
        int index = 0;
    L103:
        if (index >= size) goto L105;
        int key = minExtensionVersions.keyAt(index);
        int value = minExtensionVersions.valueAt(index);
        minExtVerStrings.add(key + "=" + value);
        index = index + 1;
        minExtensionVersions = minExtensionVersions;
        goto L103
    L105:
        pw.print(TextUtils.join(", ", minExtVerStrings));
    L107:
        pw.print("]");
    L108:
        pw.println();
        if (r10 == null) goto L242;
        pw.print(prefix);
        pw.print("  versionName=");
        pw.println(r10.getVersionName());
        pw.print(prefix);
        pw.print("  hiddenApiEnforcementPolicy=");
        pw.println(ps.getHiddenApiEnforcementPolicy());
        pw.print(prefix);
        pw.print("  usesNonSdkApi=");
        pw.println(r10.isNonSdkApiRequested());
        pw.print(prefix);
        pw.print("  splits=");
        dumpSplitNames(pw, r10);
        pw.println();
        int apkSigningVersion = r10.getSigningDetails().getSignatureSchemeVersion();
        pw.print(prefix);
        pw.print("  apkSigningVersion=");
        pw.println(apkSigningVersion);
        pw.print(prefix);
        pw.print("  flags=");
        printFlags(pw, PackageInfoUtils.appInfoFlags(r10, ps), FLAG_DUMP_SPEC);
        pw.println();
        int privateFlags = PackageInfoUtils.appInfoPrivateFlags(r10, ps);
        if (privateFlags == 0) goto L114;
        pw.print(prefix);
        pw.print("  privateFlags=");
        printFlags(pw, privateFlags, PRIVATE_FLAG_DUMP_SPEC);
        pw.println();
    L114:
        if (ps.isPendingRestore() == false) goto L117;
        pw.print(prefix);
        pw.print("  pendingRestore=true");
        pw.println();
    L117:
        if (r10.isUpdatableSystem() == true) goto L120;
        pw.print(prefix);
        pw.print("  updatableSystem=false");
        pw.println();
    L120:
        if (r10.getEmergencyInstaller() == null) goto L123;
        pw.print(prefix);
        pw.print("  emergencyInstaller=");
        pw.println(r10.getEmergencyInstaller());
    L123:
        if (r10.hasPreserveLegacyExternalStorage() == false) goto L125;
        pw.print(prefix);
        pw.print("  hasPreserveLegacyExternalStorage=true");
        pw.println();
    L125:
        pw.print(prefix);
        pw.print("  forceQueryable=");
        pw.print(ps.getPkg().isForceQueryable());
        if (ps.isForceQueryableOverride() == false) goto L128;
        pw.print(" (override=true)");
    L128:
        pw.println();
        pw.print(prefix);
        pw.print("  pageSizeCompat=");
        pw.print(ps.getPageSizeAppCompatFlags());
        pw.println();
        if (ps.getPkg().getQueriesPackages().isEmpty() == true) goto L132;
        pw.append(prefix).append("  queriesPackages=").println(ps.getPkg().getQueriesPackages());
    L132:
        if (ps.getPkg().getQueriesIntents().isEmpty() == true) goto L134;
        pw.append(prefix).append("  queriesIntents=").println(ps.getPkg().getQueriesIntents());
    L134:
        pw.print(prefix);
        pw.print("  scannedAsStoppedSystemApp=");
        pw.println(ps.isScannedAsStoppedSystemApp());
        pw.print(prefix);
        pw.print("  supportsScreens=[");
        boolean first = true;
        if (r10.isSmallScreensSupported() == false) goto L140;
        if (1 != 0) goto L138;
        pw.print(", ");
    L138:
        first = false;
        pw.print("small");
    L140:
        if (r10.isNormalScreensSupported() == false) goto L145;
        if (first == true) goto L143;
        pw.print(", ");
    L143:
        first = false;
        pw.print("medium");
    L145:
        if (r10.isLargeScreensSupported() == false) goto L150;
        if (first == true) goto L148;
        pw.print(", ");
    L148:
        first = false;
        pw.print("large");
    L150:
        if (r10.isExtraLargeScreensSupported() == false) goto L155;
        if (first == true) goto L153;
        pw.print(", ");
    L153:
        first = false;
        pw.print("xlarge");
    L155:
        if (r10.isResizeable() == false) goto L160;
        if (first == true) goto L158;
        pw.print(", ");
    L158:
        first = false;
        pw.print("resizeable");
    L160:
        if (r10.isAnyDensity() == false) goto L164;
        if (first == true) goto L163;
        pw.print(", ");
    L163:
        pw.print("anyDensity");
    L164:
        pw.println("]");
        List<String> libraryNames = r10.getLibraryNames();
        if (libraryNames == null) goto L173;
        if (libraryNames.size() <= 0) goto L173;
        pw.print(prefix);
        pw.println("  dynamic libraries:");
        int i2 = 0;
    L170:
        if (i2 >= libraryNames.size()) goto L173;
        pw.print(prefix);
        pw.print("    ");
        pw.println(libraryNames.get(i2));
        i2 = i2 + 1;
    L173:
        if (r10.getStaticSharedLibraryName() == null) goto L177;
        pw.print(prefix);
        pw.println("  static library:");
        pw.print(prefix);
        pw.print("    ");
        pw.print("name:");
        pw.print(r10.getStaticSharedLibraryName());
        pw.print(" version:");
        pw.println(r10.getStaticSharedLibraryVersion());
    L177:
        if (r10.getSdkLibraryName() == null) goto L179;
        pw.print(prefix);
        pw.println("  SDK library:");
        pw.print(prefix);
        pw.print("    ");
        pw.print("name:");
        pw.print(r10.getSdkLibraryName());
        pw.print(" versionMajor:");
        pw.println(r10.getSdkLibVersionMajor());
    L179:
        List<String> usesLibraries = r10.getUsesLibraries();
        if (usesLibraries.size() <= 0) goto L185;
        pw.print(prefix);
        pw.println("  usesLibraries:");
        int i3 = 0;
    L183:
        if (i3 >= usesLibraries.size()) goto L185;
        pw.print(prefix);
        pw.print("    ");
        pw.println(usesLibraries.get(i3));
        i3 = i3 + 1;
    L185:
        List<String> usesStaticLibraries = r10.getUsesStaticLibraries();
        long[] usesStaticLibrariesVersions = r10.getUsesStaticLibrariesVersions();
        if (usesStaticLibraries.size() <= 0) goto L193;
        pw.print(prefix);
        pw.println("  usesStaticLibraries:");
        int i4 = 0;
    L188:
        List<String> usesLibraries2 = usesLibraries;
        if (i4 >= usesStaticLibraries.size()) goto L193;
        pw.print(prefix);
        pw.print("    ");
        pw.print(usesStaticLibraries.get(i4));
        pw.print(" version:");
        pw.println(usesStaticLibrariesVersions[i4]);
        i4 = i4 + 1;
        usesLibraries = usesLibraries2;
        usesStaticLibraries = usesStaticLibraries;
    L193:
        List<String> usesSdkLibraries = r10.getUsesSdkLibraries();
        long[] usesSdkLibrariesVersionsMajor = r10.getUsesSdkLibrariesVersionsMajor();
        boolean[] usesSdkLibrariesOptional = r10.getUsesSdkLibrariesOptional();
        if (usesSdkLibraries.size() <= 0) goto L200;
        pw.print(prefix);
        pw.println("  usesSdkLibraries:");
        int size2 = usesSdkLibraries.size();
        int i5 = 0;
    L196:
        if (i5 >= size2) goto L200;
        pw.print(prefix);
        pw.print("    ");
        List<String> usesSdkLibraries2 = usesSdkLibraries;
        pw.print(usesSdkLibraries.get(i5));
        pw.print(" version:");
        int i6 = i5;
        pw.println(usesSdkLibrariesVersionsMajor[i6]);
        pw.print(" optional:");
        pw.println(usesSdkLibrariesOptional[i6]);
        i5 = i6 + 1;
        size2 = size2;
        usesSdkLibraries = usesSdkLibraries2;
    L200:
        List<String> usesOptionalLibraries = r10.getUsesOptionalLibraries();
        if (usesOptionalLibraries.size() <= 0) goto L206;
        pw.print(prefix);
        pw.println("  usesOptionalLibraries:");
        int i7 = 0;
    L204:
        if (i7 >= usesOptionalLibraries.size()) goto L206;
        pw.print(prefix);
        pw.print("    ");
        pw.println(usesOptionalLibraries.get(i7));
        i7 = i7 + 1;
    L206:
        List<String> usesNativeLibraries = r10.getUsesNativeLibraries();
        if (usesNativeLibraries.size() <= 0) goto L212;
        pw.print(prefix);
        pw.println("  usesNativeLibraries:");
        int i8 = 0;
    L210:
        if (i8 >= usesNativeLibraries.size()) goto L212;
        pw.print(prefix);
        pw.print("    ");
        pw.println(usesNativeLibraries.get(i8));
        i8 = i8 + 1;
    L212:
        List<String> usesOptionalNativeLibraries = r10.getUsesOptionalNativeLibraries();
        if (usesOptionalNativeLibraries.size() <= 0) goto L219;
        pw.print(prefix);
        pw.println("  usesOptionalNativeLibraries:");
        int i9 = 0;
    L215:
        List<String> usesOptionalLibraries2 = usesOptionalLibraries;
        if (i9 >= usesOptionalNativeLibraries.size()) goto L219;
        pw.print(prefix);
        pw.print("    ");
        pw.println(usesOptionalNativeLibraries.get(i9));
        i9 = i9 + 1;
        usesOptionalLibraries = usesOptionalLibraries2;
    L219:
        List<String> usesLibraryFiles = ps.getPkgState().getUsesLibraryFiles();
        if (usesLibraryFiles.size() <= 0) goto L226;
        pw.print(prefix);
        pw.println("  usesLibraryFiles:");
        int i10 = 0;
    L222:
        List<String> usesNativeLibraries2 = usesNativeLibraries;
        if (i10 >= usesLibraryFiles.size()) goto L226;
        pw.print(prefix);
        pw.print("    ");
        pw.println(usesLibraryFiles.get(i10));
        i10 = i10 + 1;
        usesNativeLibraries = usesNativeLibraries2;
    L226:
        Map<String, ParsedProcess> procs = r10.getProcesses();
        if (procs.isEmpty() == true) goto L242;
        pw.print(prefix);
        pw.println("  processes:");
        Iterator<ParsedProcess> r114 = procs.values().iterator();
    L230:
        if (r114.hasNext() == false) goto L242;
        ParsedProcess proc = r114.next();
        pw.print(prefix);
        pw.print("    ");
        List<String> usesLibraryFiles2 = usesLibraryFiles;
        pw.println(proc.getName());
        if (proc.getDeniedPermissions() == null) goto L239;
        Iterator r20 = proc.getDeniedPermissions().iterator();
    L235:
        if (r20.hasNext() == false) goto L239;
        Iterator r28 = r20;
        String deniedPermission = (String) r20.next();
        pw.print(prefix);
        pw.print("      deny: ");
        pw.println(deniedPermission);
        procs = procs;
        r20 = r28;
    L239:
        usesLibraryFiles = usesLibraryFiles2;
        procs = procs;
    L242:
        pw.print(prefix);
        pw.print("  timeStamp=");
        date.setTime(ps.getLastModifiedTime());
        pw.println(sdf.format(date));
        pw.print(prefix);
        pw.print("  lastUpdateTime=");
        date.setTime(ps.getLastUpdateTime());
        pw.println(sdf.format(date));
        pw.print(prefix);
        pw.print("  installerPackageName=");
        pw.println(ps.getInstallSource().mInstallerPackageName);
        pw.print(prefix);
        pw.print("  installerPackageUid=");
        pw.println(ps.getInstallSource().mInstallerPackageUid);
        pw.print(prefix);
        pw.print("  initiatingPackageName=");
        pw.println(ps.getInstallSource().mInitiatingPackageName);
        pw.print(prefix);
        pw.print("  originatingPackageName=");
        pw.println(ps.getInstallSource().mOriginatingPackageName);
        if (ps.getInstallSource().mUpdateOwnerPackageName == null) goto L246;
        pw.print(prefix);
        pw.print("  updateOwnerPackageName=");
        pw.println(ps.getInstallSource().mUpdateOwnerPackageName);
    L246:
        if (ps.getInstallSource().mInstallerAttributionTag == null) goto L248;
        pw.print(prefix);
        pw.print("  installerAttributionTag=");
        pw.println(ps.getInstallSource().mInstallerAttributionTag);
    L248:
        pw.print(prefix);
        pw.print("  packageSource=");
        pw.println(ps.getInstallSource().mPackageSource);
        if (ps.isIncremental() == false) goto L251;
        pw.print(prefix);
        pw.println("  loadingProgress=" + ((int) (ps.getLoadingProgress() * 100.0f)) + "%");
        date.setTime(ps.getLoadingCompletedTime());
        pw.print(prefix);
        pw.println("  loadingCompletedTime=" + sdf.format(date));
    L251:
        pw.print(prefix);
        pw.print("  appMetadataFilePath=");
        pw.println(ps.getAppMetadataFilePath());
        pw.print(prefix);
        pw.print("  appMetadataSource=");
        pw.println(ps.getAppMetadataSource());
        if (ps.getVolumeUuid() == null) goto L254;
        pw.print(prefix);
        pw.print("  volumeUuid=");
        pw.println(ps.getVolumeUuid());
    L254:
        pw.print(prefix);
        pw.print("  signatures=");
        pw.println(ps.getSignatures());
        pw.print(prefix);
        pw.print("  installPermissionsFixed=");
        pw.print(ps.isInstallPermissionsFixed());
        pw.println();
        pw.print(prefix);
        pw.print("  pkgFlags=");
        printFlags(pw, ps.getFlags(), FLAG_DUMP_SPEC);
        pw.println();
        pw.print(prefix);
        pw.print("  privatePkgFlags=");
        printFlags(pw, ps.getPrivateFlags(), PRIVATE_FLAG_DUMP_SPEC);
        pw.println();
        if (ps.isPendingRestore() == false) goto L257;
        pw.print(prefix);
        pw.println("  pendingRestore=true");
    L257:
        pw.print(prefix);
        pw.print("  apexModuleName=");
        pw.println(ps.getApexModuleName());
        if (r10 != null) goto L260;
    L262:
        if (r10 != null) goto L264;
    L284:
        if (permissionNames != null) goto L286;
        if (dumpAll == true) goto L286;
    L301:
        if (ps.hasSharedUser() == false) goto L306;
        if (permissionNames != null) goto L306;
        if (dumpAll == true) goto L306;
        Settings r0 = this;
    L307:
        if (dumpAllComponents == false) goto L309;
        r0.dumpComponents(pw, r6 + "  ", ps);
    L309:
        Iterator<UserInfo> r115 = users.iterator();
    L311:
        if (r115.hasNext() == false) goto L396;
        UserInfo user2 = r115.next();
        PackageUserStateInternal userState2 = ps.getUserStateOrDefault(user2.id);
        pw.print(prefix);
        pw.print("  User ");
        pw.print(user2.id);
        pw.print(": ");
        pw.print("ceDataInode=");
        pw.print(userState2.getCeDataInode());
        pw.print(" deDataInode=");
        pw.print(userState2.getDeDataInode());
        pw.print(" installed=");
        pw.print(userState2.isInstalled());
        pw.print(" hidden=");
        pw.print(userState2.isHidden());
        pw.print(" suspended=");
        pw.print(userState2.isSuspended());
        pw.print(" distractionFlags=");
        pw.print(userState2.getDistractionFlags());
        pw.print(" stopped=");
        pw.print(userState2.isStopped());
        pw.print(" notLaunched=");
        pw.print(userState2.isNotLaunched());
        pw.print(" enabled=");
        pw.print(userState2.getEnabledState());
        pw.print(" instant=");
        pw.print(userState2.isInstantApp());
        pw.print(" virtual=");
        pw.print(userState2.isVirtualPreload());
        pw.print(" quarantined=");
        pw.print(userState2.isQuarantined());
        pw.println();
        pw.print("      installReason=");
        pw.println(userState2.getInstallReason());
        File dataDir = PackageInfoUtils.getDataDir(ps, user2.id);
        pw.print("      dataDir=");
        if (dataDir != null) goto L315;
        String r21 = "null";
    L316:
        pw.println(r21);
        PackageUserStateInternal pus = ps.readUserState(user2.id);
        pw.print("      firstInstallTime=");
        date.setTime(pus.getFirstInstallTimeMillis());
        pw.println(sdf.format(date));
        if (pus.getArchiveState() == null) goto L323;
        ArchiveState archiveState = pus.getArchiveState();
        pw.print("      archiveTime=");
        date.setTime(archiveState.getArchiveTimeMillis());
        pw.println(sdf.format(date));
        pw.print("      unarchiveInstallerTitle=");
        pw.println(archiveState.getInstallerTitle());
        Iterator<ArchiveState.ArchiveActivityInfo> r22 = archiveState.getActivityInfos().iterator();
    L320:
        if (r22.hasNext() == false) goto L323;
        ArchiveState.ArchiveActivityInfo activity = r22.next();
        pw.print("        archiveActivityInfo=");
        pw.println(activity.toString());
        archiveState = archiveState;
    L323:
        pw.print("      uninstallReason=");
        pw.println(userState2.getUninstallReason());
        if (userState2.isSuspended() == false) goto L332;
        pw.print(prefix);
        pw.println("  Suspend params:");
        int i11 = 0;
    L327:
        if (i11 >= userState2.getSuspendParams().size()) goto L332;
        pw.print(prefix);
        pw.print("    suspendingPackage=");
        pw.print(userState2.getSuspendParams().keyAt(i11));
        SuspendParams params = userState2.getSuspendParams().valueAt(i11);
        if (params == null) goto L331;
        pw.print(" dialogInfo=");
        pw.print(params.getDialogInfo());
        pw.print(" quarantined=");
        pw.println(params.isQuarantined());
    L331:
        pw.println();
        i11 = i11 + 1;
    L332:
        OverlayPaths overlayPaths = userState2.getOverlayPaths();
        if (overlayPaths != null) goto L335;
    L346:
        Map<String, OverlayPaths> sharedLibraryOverlayPaths = userState2.getSharedLibraryOverlayPaths();
        if (sharedLibraryOverlayPaths == null) goto L368;
        Iterator<Map.Entry<String, OverlayPaths>> r23 = sharedLibraryOverlayPaths.entrySet().iterator();
    L350:
        if (r23.hasNext() == false) goto L368;
        Map.Entry<String, OverlayPaths> libOverlayPaths = r23.next();
        OverlayPaths paths = libOverlayPaths.getValue();
        if (paths == null) goto L350;
        if (paths.getOverlayPaths().isEmpty() == true) goto L362;
        pw.print(prefix);
        pw.print("    ");
        pw.print(libOverlayPaths.getKey());
        pw.println(" overlay paths:");
        Iterator r24 = paths.getOverlayPaths().iterator();
    L358:
        if (r24.hasNext() == false) goto L362;
        Iterator r25 = r24;
        String path = (String) r24.next();
        pw.print(prefix);
        pw.print("      ");
        pw.println(path);
        r24 = r25;
    L362:
        if (paths.getResourceDirs().isEmpty() == true) goto L367;
        pw.print(prefix);
        pw.print("    ");
        pw.print(libOverlayPaths.getKey());
        pw.println(" legacy overlay paths:");
        Iterator r26 = paths.getResourceDirs().iterator();
    L365:
        if (r26.hasNext() == false) goto L367;
        Iterator r27 = r26;
        String path2 = (String) r26.next();
        pw.print(prefix);
        pw.print("      ");
        pw.println(path2);
        r26 = r27;
    L367:
        r23 = r23;
    L368:
        String lastDisabledAppCaller2 = userState2.getLastDisableAppCaller();
        if (lastDisabledAppCaller2 == null) goto L372;
        pw.print(prefix);
        pw.print("    lastDisabledCaller: ");
        pw.println(lastDisabledAppCaller2);
    L372:
        if (ps.hasSharedUser() == true) goto L374;
        r0.dumpGidsLPr(pw, r6 + "    ", r0.mPermissionDataProvider.getGidsForUid(UserHandle.getUid(user2.id, ps.getAppId())));
        String r29 = "      ";
        r0.dumpRuntimePermissionsLPr(pw, r6 + "    ", permissionNames, permissionsState.getPermissionStates(user2.id), dumpAll);
    L375:
        String harmfulAppWarning = userState2.getHarmfulAppWarning();
        if (harmfulAppWarning == null) goto L378;
        pw.print(prefix);
        pw.print("      harmfulAppWarning: ");
        pw.println(harmfulAppWarning);
    L378:
        if (permissionNames != null) goto L395;
        WatchedArraySet<String> cmp = userState2.getDisabledComponentsNoCopy();
        if (cmp != null) goto L382;
    L387:
        WatchedArraySet<String> cmp2 = userState2.getEnabledComponentsNoCopy();
        if (cmp2 == null) goto L395;
        if (cmp2.size() <= 0) goto L395;
        pw.print(prefix);
        pw.println("    enabledComponents:");
        int i12 = 0;
    L393:
        if (i12 >= cmp2.size()) goto L395;
        pw.print(prefix);
        pw.print(r29);
        pw.println(cmp2.valueAt(i12));
        i12 = i12 + 1;
        goto L393
    L382:
        if (cmp.size() <= 0) goto L387;
        pw.print(prefix);
        pw.println("    disabledComponents:");
        int i13 = 0;
    L385:
        if (i13 >= cmp.size()) goto L387;
        pw.print(prefix);
        pw.print(r29);
        pw.println(cmp.valueAt(i13));
        i13 = i13 + 1;
    L395:
        r0 = this;
        r6 = prefix;
        goto L311
    L374:
        r29 = "      ";
        goto L375
    L335:
        if (overlayPaths.getOverlayPaths().isEmpty() == true) goto L341;
        pw.print(prefix);
        pw.println("    overlay paths:");
        Iterator r30 = overlayPaths.getOverlayPaths().iterator();
    L338:
        if (r30.hasNext() == false) goto L341;
        String path3 = (String) r30.next();
        pw.print(prefix);
        pw.print("      ");
        pw.println(path3);
    L341:
        if (overlayPaths.getResourceDirs().isEmpty() == true) goto L346;
        pw.print(prefix);
        pw.println("    legacy overlay paths:");
        Iterator r31 = overlayPaths.getResourceDirs().iterator();
    L344:
        if (r31.hasNext() == false) goto L346;
        String path4 = (String) r31.next();
        pw.print(prefix);
        pw.print("      ");
        pw.println(path4);
        goto L344
    L315:
        r21 = dataDir.getAbsolutePath();
        goto L316
    L396:
        return;
    L306:
        r0 = this;
        r0.dumpInstallPermissionsLPr(pw, r6 + "  ", permissionNames, permissionsState, users);
    L286:
        if (r10 == null) goto L301;
        if (r10.getRequestedPermissions() == null) goto L301;
        if (r10.getRequestedPermissions().size() <= 0) goto L301;
        Set<String> perms = r10.getRequestedPermissions();
        pw.print(prefix);
        pw.println("  requested permissions:");
        Iterator<String> r32 = perms.iterator();
    L293:
        if (r32.hasNext() == false) goto L301;
        String perm = r32.next();
        if (permissionNames == null) goto L299;
        if (permissionNames.contains(perm) == false) goto L293;
    L299:
        pw.print(prefix);
        pw.print("    ");
        pw.println(perm);
        goto L293
    L264:
        if (r10.getPermissions().isEmpty() == true) goto L284;
        List<ParsedPermission> perms2 = r10.getPermissions();
        pw.print(prefix);
        pw.println("  declared permissions:");
        int i14 = 0;
    L267:
        if (i14 >= perms2.size()) goto L284;
        ParsedPermission perm2 = perms2.get(i14);
        if (permissionNames != null) goto L271;
    L273:
        pw.print(prefix);
        pw.print("    ");
        pw.print(perm2.getName());
        pw.print(": prot=");
        pw.print(PermissionInfo.protectionToString(perm2.getProtectionLevel()));
        if ((perm2.getFlags() & 1) == 0) goto L277;
        pw.print(", COSTS_MONEY");
    L277:
        if ((perm2.getFlags() & 2) == 0) goto L280;
        pw.print(", HIDDEN");
    L280:
        if ((perm2.getFlags() & 1073741824) == 0) goto L282;
        pw.print(", INSTALLED");
    L282:
        pw.println();
    L283:
        i14 = i14 + 1;
        goto L267
    L271:
        if (permissionNames.contains(perm2.getName()) == true) goto L273;
    L260:
        if (r10.getOverlayTarget() == null) goto L262;
        pw.print(prefix);
        pw.print("  overlayTarget=");
        pw.println(r10.getOverlayTarget());
        pw.print(prefix);
        pw.print("  overlayCategory=");
        pw.println(r10.getOverlayCategory());
        goto L262
    L84:
        if (ps.getOldPaths().size() <= 0) goto L89;
        Iterator<File> r33 = ps.getOldPaths().iterator();
    L87:
        if (r33.hasNext() == false) goto L89;
        File oldPath = r33.next();
        pw.print(prefix);
        pw.println("    oldCodePath=" + oldPath.getAbsolutePath());
        goto L87
    L74:
        r2 = ps.getPackageName();
        goto L75
    }

    void dumpPackagesLPr(PrintWriter pw, String packageName, ArraySet<String> permissionNames, DumpState dumpState, boolean checkin) {
        Settings r0 = this;
        PrintWriter r1 = pw;
        ArraySet<String> r4 = permissionNames;
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date date = new Date();
        boolean printedSomething = false;
        boolean dumpAllComponents = dumpState.isOptionEnabled(2);
        List<UserInfo> users = getAllUsers(UserManagerService.getInstance());
        Iterator<PackageSetting> r14 = r0.mPackages.values().iterator();
    L3:
        String r17 = null;
        int r5 = 8;
        if (r14.hasNext() == false) goto L40;
        PackageSetting ps = r14.next();
        if (packageName == null) goto L13;
        if (packageName.equals(ps.getRealName()) == true) goto L13;
        if (packageName.equals(ps.getPackageName()) == false) goto L3;
    L13:
        if (ps.getPkg() == null) goto L19;
        if (ps.getPkg().isApex() == false) goto L19;
        if (dumpState.isOptionEnabled(8) == false) goto L3;
    L19:
        LegacyPermissionState permissionsState = r0.mPermissionDataProvider.getLegacyPermissionState(ps.getAppId());
        if (r4 == null) goto L24;
        if (permissionsState.hasPermissionState(r4) == false) goto L3;
    L24:
        if (checkin == true) goto L27;
        if (packageName == null) goto L27;
        dumpState.setSharedUser(r0.getSharedUserSettingLPr(ps));
    L27:
        if (checkin == true) goto L33;
        if (printedSomething == true) goto L33;
        if (dumpState.onTitlePrinted() == false) goto L32;
        r1.println();
    L32:
        r1.println("Packages:");
        boolean printedSomething2 = true;
    L34:
        if (checkin == false) goto L36;
        r17 = "pkg";
    L36:
        if (packageName == null) goto L38;
        boolean r10 = true;
    L39:
        r0.dumpPackageLPr(r1, "  ", r17, r4, ps, permissionsState, sdf, date, users, r10, dumpAllComponents);
        r4 = permissionNames;
        printedSomething = printedSomething2;
        goto L3
    L38:
        r10 = false;
    L33:
        printedSomething2 = printedSomething;
        goto L34
    L40:
        boolean printedSomething3 = false;
        if (r0.mRenamedPackages.size() <= 0) goto L66;
        if (permissionNames != null) goto L66;
        Iterator<Map.Entry<String, String>> r3 = r0.mRenamedPackages.entrySet().iterator();
    L45:
        if (r3.hasNext() == false) goto L66;
        Map.Entry<String, String> e = r3.next();
        if (packageName == null) goto L53;
        if (packageName.equals(e.getKey()) == true) goto L53;
        if (packageName.equals(e.getValue()) == false) goto L45;
    L53:
        if (checkin == true) goto L60;
        if (printedSomething3 == false) goto L56;
    L59:
        r1.print("  ");
    L61:
        r1.print(e.getKey());
        if (checkin == false) goto L64;
        String r6 = " -> ";
    L65:
        r1.print(r6);
        r1.println(e.getValue());
        goto L45
    L64:
        r6 = ",";
        goto L65
    L56:
        if (dumpState.onTitlePrinted() == false) goto L58;
        r1.println();
    L58:
        r1.println("Renamed packages:");
        printedSomething3 = true;
        goto L59
    L60:
        r1.print("ren,");
    L66:
        boolean printedSomething4 = false;
        if (r0.mDisabledSysPackages.size() <= 0) goto L101;
        if (permissionNames != null) goto L134;
        Iterator<PackageSetting> r15 = r0.mDisabledSysPackages.values().iterator();
    L71:
        if (r15.hasNext() == false) goto L135;
        PackageSetting ps2 = r15.next();
        if (packageName == null) goto L80;
        if (packageName.equals(ps2.getRealName()) == true) goto L80;
        if (packageName.equals(ps2.getPackageName()) == false) goto L71;
    L80:
        if (ps2.getPkg() == null) goto L86;
        if (ps2.getPkg().isApex() == false) goto L86;
        if (dumpState.isOptionEnabled(r5) == false) goto L71;
    L86:
        if (checkin == true) goto L92;
        if (printedSomething4 == true) goto L92;
        if (dumpState.onTitlePrinted() == false) goto L91;
        r1.println();
    L91:
        r1.println("Hidden system packages:");
        boolean printedSomething5 = true;
    L93:
        LegacyPermissionState permissionsState2 = r0.mPermissionDataProvider.getLegacyPermissionState(ps2.getAppId());
        if (checkin == false) goto L96;
        String r2 = "dis";
    L97:
        if (packageName == null) goto L99;
        boolean r11 = true;
    L100:
        r0.dumpPackageLPr(r1, "  ", r2, permissionNames, ps2, permissionsState2, sdf, date, users, r11, dumpAllComponents);
        r0 = this;
        r1 = pw;
        printedSomething4 = printedSomething5;
        r5 = r5;
        goto L71
    L99:
        r11 = false;
        goto L100
    L96:
        r2 = null;
    L92:
        printedSomething5 = printedSomething4;
        goto L93
    L135:
        return;
    L134:
        return;
    }

    void dumpPackagesProto(ProtoOutputStream proto) {
        List<UserInfo> users = getAllUsers(UserManagerService.getInstance());
        int count = this.mPackages.size();
        int i = 0;
    L3:
        if (i >= count) goto L6;
        PackageSetting ps = this.mPackages.valueAt(i);
        ps.dumpDebug(proto, 2246267895813L, users, this.mPermissionDataProvider);
        i = i + 1;
        goto L3
    }

    void dumpPermissions(PrintWriter pw, String packageName, ArraySet<String> permissionNames, DumpState dumpState) {
        LegacyPermissionSettings.dumpPermissions(pw, packageName, permissionNames, this.mPermissionDataProvider.getLegacyPermissions(), this.mPermissionDataProvider.getAllAppOpPermissionPackages(), true, dumpState);
    }

    void dumpSharedUsersLPr(PrintWriter pw, String packageName, ArraySet<String> permissionNames, DumpState dumpState, boolean checkin) {
        Settings r0 = this;
        ArraySet<String> r3 = permissionNames;
        boolean printedSomething = false;
        Iterator<SharedUserSetting> r6 = r0.mSharedUsers.values().iterator();
    L4:
        if (r6.hasNext() == false) goto L50;
        SharedUserSetting su = r6.next();
        if (packageName == null) goto L10;
        if (su != dumpState.getSharedUser()) goto L4;
    L10:
        LegacyPermissionState permissionsState = r0.mPermissionDataProvider.getLegacyPermissionState(su.mAppId);
        if (r3 == null) goto L15;
        if (permissionsState.hasPermissionState(r3) == false) goto L4;
    L15:
        if (checkin == true) goto L47;
        if (printedSomething == false) goto L18;
        boolean printedSomething2 = printedSomething;
    L22:
        pw.print("  SharedUser [");
        pw.print(su.name);
        pw.print("] (");
        pw.print(Integer.toHexString(System.identityHashCode(su)));
        pw.println("):");
        pw.print("    ");
        pw.print("appId=");
        pw.println(su.mAppId);
        pw.print("    ");
        pw.println("Packages");
        ArraySet<? extends PackageStateInternal> r9 = su.getPackageStates();
        int numPackages = r9.size();
        int i = 0;
    L24:
        if (i >= numPackages) goto L31;
        PackageStateInternal ps = r9.valueAt(i);
        if (ps == null) goto L28;
        pw.print("      ");
        pw.println(ps);
    L29:
        i = i + 1;
        goto L24
    L28:
        pw.print("      ");
        pw.println("NULL?!");
        goto L29
    L31:
        if (dumpState.isOptionEnabled(4) == true) goto L32;
        List<UserInfo> users = getAllUsers(UserManagerService.getInstance());
        r0.dumpInstallPermissionsLPr(pw, "    ", r3, permissionsState, users);
        Iterator<UserInfo> r16 = users.iterator();
    L35:
        if (r16.hasNext() == false) goto L46;
        UserInfo user = r16.next();
        int userId = user.id;
        int[] gids = r0.mPermissionDataProvider.getGidsForUid(UserHandle.getUid(userId, su.mAppId));
        Collection<LegacyPermissionState.PermissionState> permissions = permissionsState.getPermissionStates(userId);
        if (ArrayUtils.isEmpty(gids) == true) goto L39;
    L40:
        pw.print("    ");
        pw.print("User ");
        pw.print(userId);
        pw.println(": ");
        r0.dumpGidsLPr(pw, "      ", gids);
        String r2 = "      ";
        if (packageName == null) goto L43;
        boolean r18 = true;
    L44:
        r0.dumpRuntimePermissionsLPr(pw, r2, permissionNames, permissions, r18);
    L45:
        r0 = this;
        goto L35
    L43:
        r18 = false;
        goto L44
    L39:
        if (permissions.isEmpty() == true) goto L45;
    L46:
        printedSomething = printedSomething2;
    L48:
        r0 = this;
        r3 = permissionNames;
        goto L4
    L32:
        printedSomething = printedSomething2;
        goto L4
    L18:
        if (dumpState.onTitlePrinted() == false) goto L20;
        pw.println();
    L20:
        pw.println("Shared users:");
        printedSomething2 = true;
        goto L22
    L47:
        pw.print("suid,");
        pw.print(su.mAppId);
        pw.print(",");
        pw.println(su.name);
        goto L48
    }

    void dumpSharedUsersProto(ProtoOutputStream proto) {
        int count = this.mSharedUsers.size();
        int i = 0;
    L3:
        if (i >= count) goto L6;
        this.mSharedUsers.valueAt(i).dumpDebug(proto, 2246267895814L);
        i = i + 1;
        goto L3
    }

    void dumpReadMessages(PrintWriter pw, DumpState dumpState) {
        pw.println("Settings parse messages:");
        pw.print(this.mReadMessages.toString());
    }

    private static void dumpSplitNames(PrintWriter pw, AndroidPackage pkg) {
        if (pkg != null) goto L4;
        pw.print("unknown");
        return;
    L4:
        pw.print("[");
        pw.print("base");
        if (pkg.getBaseRevisionCode() == 0) goto L7;
        pw.print(":");
        pw.print(pkg.getBaseRevisionCode());
    L7:
        String[] splitNames = pkg.getSplitNames();
        int[] splitRevisionCodes = pkg.getSplitRevisionCodes();
        int i = 0;
    L9:
        if (i >= splitNames.length) goto L14;
        pw.print(", ");
        pw.print(splitNames[i]);
        if (splitRevisionCodes[i] == 0) goto L13;
        pw.print(":");
        pw.print(splitRevisionCodes[i]);
    L13:
        i = i + 1;
        goto L9
    L14:
        pw.print("]");
    }

    void dumpGidsLPr(PrintWriter pw, String prefix, int[] gids) {
        if (ArrayUtils.isEmpty(gids) == true) goto L6;
        pw.print(prefix);
        pw.print("gids=");
        pw.println(PackageManagerServiceUtils.arrayToString(gids));
        return;
    }

    void dumpRuntimePermissionsLPr(PrintWriter pw, String prefix, ArraySet<String> permissionNames, Collection<LegacyPermissionState.PermissionState> permissionStates, boolean dumpAll) {
        boolean hasRuntimePermissions = false;
        Iterator<LegacyPermissionState.PermissionState> r1 = permissionStates.iterator();
    L4:
        if (r1.hasNext() == false) goto L9;
        if (r1.next().isRuntime() == false) goto L4;
        hasRuntimePermissions = true;
    L9:
        if (hasRuntimePermissions == true) goto L11;
        if (dumpAll == true) goto L11;
        return;
    L11:
        pw.print(prefix);
        pw.println("runtime permissions:");
        Iterator<LegacyPermissionState.PermissionState> r2 = permissionStates.iterator();
    L13:
        if (r2.hasNext() == false) goto L34;
        LegacyPermissionState.PermissionState permissionState = r2.next();
        if (permissionState.isRuntime() == false) goto L13;
        if (permissionNames == null) goto L21;
        if (permissionNames.contains(permissionState.getName()) == false) goto L13;
    L21:
        pw.print(prefix);
        pw.print("  ");
        pw.print(permissionState.getName());
        pw.print(": granted=");
        pw.print(permissionState.isGranted());
        pw.println(permissionFlagsToString(", flags=", permissionState.getFlags()));
        goto L13
    }

    private static String permissionFlagsToString(String prefix, int flags) {
        StringBuilder flagsString = null;
    L3:
        if (flags == 0) goto L10;
        if (flagsString != null) goto L6;
        StringBuilder flagsString2 = new StringBuilder();
        flagsString2.append(prefix);
        flagsString2.append("[ ");
        flagsString = flagsString2;
    L6:
        int flag = 1 << Integer.numberOfTrailingZeros(flags);
        flags = flags & (~flag);
        flagsString.append(PackageManager.permissionFlagToString(flag));
        if (flags == 0) goto L3;
        flagsString.append('|');
        goto L3
    L10:
        if (flagsString == null) goto L13;
        flagsString.append(']');
        return flagsString.toString();
    L13:
        return "";
    }

    void dumpInstallPermissionsLPr(PrintWriter pw, String prefix, ArraySet<String> filterPermissionNames, LegacyPermissionState permissionsState, List<UserInfo> users) {
        ArraySet<String> dumpPermissionNames = new ArraySet();
        Iterator<UserInfo> r4 = users.iterator();
    L4:
        if (r4.hasNext() == false) goto L18;
        UserInfo user = r4.next();
        Collection<LegacyPermissionState.PermissionState> permissionStates = permissionsState.getPermissionStates(user.id);
        Iterator<LegacyPermissionState.PermissionState> r8 = permissionStates.iterator();
    L7:
        if (r8.hasNext() == false) goto L4;
        LegacyPermissionState.PermissionState permissionState = r8.next();
        if (permissionState.isRuntime() == true) goto L7;
        String permissionName = permissionState.getName();
        if (filterPermissionNames == null) goto L16;
        if (filterPermissionNames.contains(permissionName) == false) goto L7;
    L16:
        dumpPermissionNames.add(permissionName);
        goto L7
    L18:
        boolean printedSomething = false;
        Iterator<String> r5 = dumpPermissionNames.iterator();
    L20:
        if (r5.hasNext() == false) goto L48;
        String permissionName2 = r5.next();
        LegacyPermissionState.PermissionState systemPermissionState = permissionsState.getPermissionState(permissionName2, 0);
        Iterator<UserInfo> r9 = users.iterator();
    L23:
        if (r9.hasNext() == false) goto L20;
        UserInfo user2 = r9.next();
        int userId = user2.id;
        if (userId == 0) goto L26;
        LegacyPermissionState.PermissionState permissionState2 = permissionsState.getPermissionState(permissionName2, userId);
        if (Objects.equals(permissionState2, systemPermissionState) == true) goto L23;
    L30:
        if (printedSomething == true) goto L32;
        pw.print(prefix);
        pw.println("install permissions:");
        printedSomething = true;
    L32:
        pw.print(prefix);
        pw.print("  ");
        pw.print(permissionName2);
        pw.print(": granted=");
        if (permissionState2 != null) goto L35;
    L37:
        boolean r13 = false;
    L38:
        pw.print(r13);
        if (permissionState2 == null) goto L41;
        int r14 = permissionState2.getFlags();
    L42:
        pw.print(permissionFlagsToString(", flags=", r14));
        if (userId == 0) goto L44;
        pw.print(", userId=");
        pw.println(userId);
        goto L23
    L44:
        pw.println();
        goto L23
    L41:
        r14 = 0;
        goto L42
    L35:
        if (permissionState2.isGranted() == false) goto L37;
        r13 = true;
        goto L38
    L26:
        permissionState2 = systemPermissionState;
        goto L30
    }

    void dumpComponents(PrintWriter pw, String prefix, PackageSetting ps) {
        dumpComponents(pw, prefix, "activities:", ps.getPkg().getActivities());
        dumpComponents(pw, prefix, "services:", ps.getPkg().getServices());
        dumpComponents(pw, prefix, "receivers:", ps.getPkg().getReceivers());
        dumpComponents(pw, prefix, "providers:", ps.getPkg().getProviders());
        dumpComponents(pw, prefix, "instrumentations:", ps.getPkg().getInstrumentations());
    }

    void dumpComponents(PrintWriter pw, String prefix, String label, List<? extends ParsedComponent> list) {
        int size = CollectionUtils.size(list);
        if (size != 0) goto L5;
        return;
    L5:
        pw.print(prefix);
        pw.println(label);
        int i = 0;
    L6:
        if (i >= size) goto L9;
        ParsedComponent component = list.get(i);
        pw.print(prefix);
        pw.print("  ");
        pw.println(component.getComponentName().flattenToShortString());
        i = i + 1;
        goto L6
    }

    public void writePermissionStateForUserLPr(int userId, boolean sync) {
        if (sync == false) goto L4;
        this.mRuntimePermissionsPersistence.writeStateForUser(userId, this.mPermissionDataProvider, this.mPackages, this.mSharedUsers, null, this.mLock, true);
        return;
    L4:
        this.mRuntimePermissionsPersistence.writeStateForUserAsync(userId);
    }

    PersistentPreferredIntentResolver getPersistentPreferredActivities(int userId) {
        return this.mPersistentPreferredActivities.get(userId);
    }

    PreferredIntentResolver getPreferredActivities(int userId) {
        return this.mPreferredActivities.get(userId);
    }

    CrossProfileIntentResolver getCrossProfileIntentResolver(int userId) {
        return this.mCrossProfileIntentResolvers.get(userId);
    }

    void clearPackagePreferredActivities(String packageName, SparseBooleanArray outUserChanged, int userId) {
        clearPackagePreferredActivities(packageName, outUserChanged, userId, null);
    }

    void clearPackagePreferredActivities(String packageName, SparseBooleanArray outUserChanged, int userId, PackageManagerService packageManagerService) {
        boolean changed = false;
        ArrayList<PreferredActivity> removed = null;
        int i = 0;
    L4:
        if (i >= this.mPreferredActivities.size()) goto L32;
        int thisUserId = this.mPreferredActivities.keyAt(i);
        PreferredIntentResolver pir = this.mPreferredActivities.valueAt(i);
        if (userId == (-1)) goto L9;
        if (userId == thisUserId) goto L9;
    L30:
        i = i + 1;
    L9:
        Iterator<F> r5 = pir.filterIterator();
    L11:
        if (r5.hasNext() == false) goto L22;
        PreferredActivity pa = (PreferredActivity) r5.next();
        if (packageName == null) goto L18;
        if (pa.mPref.mComponent.getPackageName().equals(packageName) == false) goto L11;
        if (pa.mPref.mAlways == false) goto L11;
    L18:
        if (removed != null) goto L20;
        removed = new ArrayList();
    L20:
        removed.add(pa);
        goto L11
    L22:
        if (removed == null) goto L30;
        int j = 0;
    L25:
        if (j >= removed.size()) goto L27;
        pir.removeFilter(removed.get(j));
        j = j + 1;
        goto L25
    L27:
        outUserChanged.put(thisUserId, true);
        changed = true;
        if (packageManagerService == null) goto L30;
        packageManagerService.getSmtEx().postPreferredActivityClearBroadcast(removed, packageName);
        goto L30
    L32:
        if (changed == false) goto L49;
        onChanged();
        return;
    }

    boolean clearPackagePersistentPreferredActivities(String packageName, int userId) {
        ArrayList<PersistentPreferredActivity> removed = null;
        boolean changed = false;
        int i = 0;
    L4:
        if (i >= this.mPersistentPreferredActivities.size()) goto L25;
        int thisUserId = this.mPersistentPreferredActivities.keyAt(i);
        PersistentPreferredIntentResolver ppir = this.mPersistentPreferredActivities.valueAt(i);
        if (userId != thisUserId) goto L23;
        Iterator<F> r5 = ppir.filterIterator();
    L10:
        if (r5.hasNext() == false) goto L17;
        PersistentPreferredActivity ppa = (PersistentPreferredActivity) r5.next();
        if (ppa.mComponent.getPackageName().equals(packageName) == false) goto L10;
        if (removed != null) goto L15;
        removed = new ArrayList();
    L15:
        removed.add(ppa);
        goto L10
    L17:
        if (removed == null) goto L23;
        int j = 0;
    L20:
        if (j >= removed.size()) goto L22;
        ppir.removeFilter(removed.get(j));
        j = j + 1;
        goto L20
    L22:
        changed = true;
    L23:
        i = i + 1;
        goto L4
    L25:
        if (changed == false) goto L27;
        onChanged();
    L27:
        return changed;
    }

    boolean clearPersistentPreferredActivity(IntentFilter filter, int userId) {
        ArrayList<PersistentPreferredActivity> removed = null;
        PersistentPreferredIntentResolver ppir = this.mPersistentPreferredActivities.get(userId);
        Iterator<F> r2 = ppir.filterIterator();
        boolean changed = false;
    L4:
        if (r2.hasNext() == false) goto L11;
        PersistentPreferredActivity ppa = (PersistentPreferredActivity) r2.next();
        if (IntentFilter.filterEquals(ppa.getIntentFilter(), filter) == false) goto L4;
        if (removed != null) goto L9;
        removed = new ArrayList();
    L9:
        removed.add(ppa);
        goto L4
    L11:
        if (removed == null) goto L17;
        int i = 0;
    L14:
        if (i >= removed.size()) goto L16;
        ppir.removeFilter(removed.get(i));
        i = i + 1;
        goto L14
    L16:
        changed = true;
    L17:
        if (changed == false) goto L19;
        onChanged();
    L19:
        return changed;
    }

    ArrayList<Integer> systemReady(ComponentResolver resolver) {
        ArrayList<Integer> changed = new ArrayList();
        ArrayList<PreferredActivity> removed = new ArrayList();
        int i = 0;
    L4:
        if (i >= this.mPreferredActivities.size()) goto L20;
        PreferredIntentResolver pir = this.mPreferredActivities.valueAt(i);
        removed.clear();
        Iterator r4 = pir.filterSet().iterator();
    L7:
        if (r4.hasNext() == false) goto L13;
        PreferredActivity pa = (PreferredActivity) r4.next();
        if (resolver.isActivityDefined(pa.mPref.mComponent) == true) goto L7;
        removed.add(pa);
        goto L7
    L13:
        if (removed.size() <= 0) goto L19;
        int r = 0;
    L16:
        if (r >= removed.size()) goto L18;
        PreferredActivity pa2 = removed.get(r);
        Slog.w(TAG, "Removing dangling preferred activity: " + pa2.mPref.mComponent);
        pir.removeFilter(pa2);
        r = r + 1;
        goto L16
    L18:
        changed.add(Integer.valueOf(this.mPreferredActivities.keyAt(i)));
    L19:
        i = i + 1;
        goto L4
    L20:
        onChanged();
        return changed;
    }

    void dumpPreferred(PrintWriter pw, DumpState dumpState, String packageName) {
        int i = 0;
    L4:
        if (i >= this.mPreferredActivities.size()) goto L14;
        PreferredIntentResolver pir = this.mPreferredActivities.valueAt(i);
        int user = this.mPreferredActivities.keyAt(i);
        if (dumpState.getTitlePrinted() == false) goto L8;
        String r4 = "\nPreferred Activities User " + user + ":";
    L9:
        PrintWriter pw2 = pw;
        String packageName2 = packageName;
        if (pir.dump(pw2, r4, "  ", packageName2, true, false) == false) goto L12;
        dumpState.setTitlePrinted(true);
    L12:
        i = i + 1;
        pw = pw2;
        packageName = packageName2;
        goto L4
    L8:
        r4 = "Preferred Activities User " + user + ":";
        goto L9
    }

    boolean isInstallerPackage(String packageName) {
        return this.mInstallerPackages.contains(packageName);
    }

    public SettingsSmtEx getSmtEx() {
        return this.mSmtEx;
    }
}
