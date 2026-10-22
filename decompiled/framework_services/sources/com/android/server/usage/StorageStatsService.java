package com.android.server.usage;

import android.app.AppOpsManager;
import android.app.usage.ExternalStorageStats;
import android.app.usage.IStorageStatsManager;
import android.app.usage.StorageStats;
import android.app.usage.UsageStatsManagerInternal;
import android.content.ContentResolver;
import android.content.Context;
import android.content.IntentFilter;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageStats;
import android.content.pm.ParceledListSlice;
import android.content.pm.UserInfo;
import android.net.Uri;
import android.os.Binder;
import android.os.Build;
import android.os.Environment;
import android.os.FileUtils;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.ParcelableException;
import android.os.StatFs;
import android.os.SystemProperties;
import android.os.Trace;
import android.os.UserHandle;
import android.os.UserManager;
import android.os.storage.CrateInfo;
import android.os.storage.CrateMetadata;
import android.os.storage.StorageManager;
import android.os.storage.VolumeInfo;
import android.provider.DeviceConfig;
import android.text.TextUtils;
import android.util.ArrayMap;
import android.util.DataUnit;
import android.util.Pair;
import android.util.Slog;
import android.util.SparseLongArray;
import com.android.internal.util.ArrayUtils;
import com.android.internal.util.Preconditions;
import com.android.server.IoThread;
import com.android.server.LocalManagerRegistry;
import com.android.server.LocalServices;
import com.android.server.SystemService;
import com.android.server.art.model.ArtManagedFileStats;
import com.android.server.pm.DexOptHelper;
import com.android.server.pm.Installer;
import com.android.server.pm.PackageManagerLocal;
import com.android.server.pm.PackageManagerService;
import com.android.server.pm.PackageManagerServiceUtils;
import com.android.server.pm.Settings;
import com.android.server.storage.CacheQuotaStrategy;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.function.Consumer;

/* JADX INFO: loaded from: classes3.dex */
public class StorageStatsService extends IStorageStatsManager.Stub {
    private static final long DEFAULT_QUOTA = 0;
    private static final long DELAY_CHECK_STORAGE_DELTA = 30000;
    private static final long DELAY_RECALCULATE_QUOTAS = 36000000;
    private static final String PROP_DISABLE_QUOTA = "fw.disable_quota";
    private static final String PROP_STORAGE_CRATES = "fw.storage_crates";
    private static final String PROP_VERIFY_STORAGE = "fw.verify_storage";
    private static final String TAG = "StorageStatsService";
    private final AppOpsManager mAppOps;
    private final ArrayMap<String, SparseLongArray> mCacheQuotas;
    private final Context mContext;
    private final H mHandler;
    private final Installer mInstaller;
    private final Object mLock;
    private final PackageManager mPackage;
    private final StorageManager mStorage;
    private final CopyOnWriteArrayList<Pair<String, StorageStatsManagerLocal.StorageStatsAugmenter>> mStorageStatsAugmenters;
    private int mStorageThresholdPercentHigh;
    private final UserManager mUser;

    private class H extends Handler {
        private static final boolean DEBUG = false;
        private static final long MINIMUM_CHANGE_DELTA_PERCENT_HIGH = 5;
        private static final long MINIMUM_CHANGE_DELTA_PERCENT_LOW = 2;
        private static final int MSG_CHECK_STORAGE_DELTA = 100;
        private static final int MSG_LOAD_CACHED_QUOTAS_FROM_FILE = 101;
        private static final int MSG_PACKAGE_REMOVED = 103;
        private static final int MSG_RECALCULATE_QUOTAS = 102;
        private static final int UNSET = -1;
        private long mPreviousBytes;
        private final StatFs mStats;
        private long mTotalBytes;
        final /* synthetic */ StorageStatsService this$0;

        public H(StorageStatsService r3, Looper looper) {
            this.this$0 = r3;
            super(looper);
            this.mStats = new StatFs(Environment.getDataDirectory().getAbsolutePath());
            this.mPreviousBytes = this.mStats.getAvailableBytes();
            this.mTotalBytes = this.mStats.getTotalBytes();
        }

        @Override // android.os.Handler
        public void handleMessage(Message msg) {
            if (StorageStatsService.isCacheQuotaCalculationsEnabled(StorageStatsService.m9102$$Nest$fgetmContext(this.this$0).getContentResolver()) == true) goto L6;
            return;
        L6:
            switch(msg.what) {
                case 100: goto L23;
                case 101: goto L10;
                case 102: goto L9;
                case 103: goto L8;
                default: goto L7;
            };
        L7:
            return;
        L8:
            recalculateQuotas(getInitializedStrategy());
            return;
        L9:
            recalculateQuotas(getInitializedStrategy());
            sendEmptyMessageDelayed(102, StorageStatsService.DELAY_RECALCULATE_QUOTAS);
            return;
        L10:
            CacheQuotaStrategy strategy = getInitializedStrategy();
            this.mPreviousBytes = -1;
            this.mPreviousBytes = strategy.setupQuotasFromFile();     // Catch: IllegalStateException -> L13 IOException -> L15
        L20:
            if (this.mPreviousBytes >= 0) goto L22;
            this.mStats.restat(Environment.getDataDirectory().getAbsolutePath());
            this.mPreviousBytes = this.mStats.getAvailableBytes();
            recalculateQuotas(strategy);
        L22:
            sendEmptyMessageDelayed(100, 30000);
            sendEmptyMessageDelayed(102, StorageStatsService.DELAY_RECALCULATE_QUOTAS);
            return;
        L15:
            e = move-exception;
            Slog.e(StorageStatsService.TAG, "An error occurred while reading the cache quota file.", e);
        L13:
            e = move-exception;
            Slog.e(StorageStatsService.TAG, "Cache quota XML file is malformed?", e);
            goto L20
        L23:
            this.mStats.restat(Environment.getDataDirectory().getAbsolutePath());
            long bytesDelta = Math.abs(this.mPreviousBytes - this.mStats.getAvailableBytes());
            Object r0 = StorageStatsService.m9105$$Nest$fgetmLock(this.this$0);
            monitor-enter(r0);
        L28:
            th = move-exception;
            throw th;
        L26:
            if (this.mStats.getAvailableBytes() <= ((this.mTotalBytes * ((long) StorageStatsService.m9107$$Nest$fgetmStorageThresholdPercentHigh(this.this$0))) / 100)) goto L30;
            long bytesDeltaThreshold = (this.mTotalBytes * 5) / 100;     // Catch: Throwable -> L28
        L31:
            monitor-exit(r0);     // Catch: Throwable -> L28
            if (bytesDelta <= bytesDeltaThreshold) goto L35;
            this.mPreviousBytes = this.mStats.getAvailableBytes();
            recalculateQuotas(getInitializedStrategy());
            this.this$0.notifySignificantDelta();
        L35:
            sendEmptyMessageDelayed(100, 30000);
            return;
        L30:
            bytesDeltaThreshold = (this.mTotalBytes * 2) / 100;     // Catch: Throwable -> L28
            goto L31
        }

        private void recalculateQuotas(CacheQuotaStrategy strategy) {
            strategy.recalculateQuotas();
        }

        private CacheQuotaStrategy getInitializedStrategy() {
            UsageStatsManagerInternal usageStatsManager = (UsageStatsManagerInternal) LocalServices.getService(UsageStatsManagerInternal.class);
            return new CacheQuotaStrategy(StorageStatsService.m9102$$Nest$fgetmContext(this.this$0), usageStatsManager, StorageStatsService.m9104$$Nest$fgetmInstaller(this.this$0), StorageStatsService.m9101$$Nest$fgetmCacheQuotas(this.this$0));
        }
    }

    public static class Lifecycle extends SystemService {
        private StorageStatsService mService;

        public Lifecycle(Context context) {
            super(context);
        }

        @Override // com.android.server.SystemService
        public void onStart() {
            this.mService = new StorageStatsService(getContext());
            publishBinderService("storagestats", this.mService);
        }
    }

    private class LocalService implements StorageStatsManagerLocal {
        final /* synthetic */ StorageStatsService this$0;

        /* synthetic */ LocalService(StorageStatsService r1, StorageStatsServiceIA r2) {
            this(r1);
        }

        private LocalService(StorageStatsService r1) {
            this.this$0 = r1;
        }

        @Override // com.android.server.usage.StorageStatsManagerLocal
        public void registerStorageStatsAugmenter(StorageStatsManagerLocal.StorageStatsAugmenter storageStatsAugmenter, String tag) {
            StorageStatsService.m9106$$Nest$fgetmStorageStatsAugmenters(this.this$0).add(Pair.create(tag, storageStatsAugmenter));
        }
    }

    /* JADX INFO: renamed from: $r8$lambda$-OD1kcELpUBub63x7K_2zL62Jt0, reason: not valid java name */
    public static /* synthetic */ void m9097$r8$lambda$OD1kcELpUBub63x7K_2zL62Jt0(PackageStats r0, String r1, UserHandle r2, boolean r3, StorageStatsManagerLocal.StorageStatsAugmenter r4) {
        lambda$queryStatsForPackage$1(r0, r1, r2, r3, r4);
    }

    /* JADX INFO: renamed from: $r8$lambda$26ynPRtYS3Uj_Y-_AG7k_MFaOcA, reason: not valid java name */
    public static /* synthetic */ void m9098$r8$lambda$26ynPRtYS3Uj_Y_AG7k_MFaOcA(PackageStats r0, UserHandle r1, StorageStatsManagerLocal.StorageStatsAugmenter r2) {
        lambda$queryStatsForUser$3(r0, r1, r2);
    }

    /* JADX INFO: renamed from: $r8$lambda$SuC9-9OYCDVQiGVkOIIESEPvimo, reason: not valid java name */
    public static /* synthetic */ void m9099$r8$lambda$SuC99OYCDVQiGVkOIIESEPvimo(StorageStatsService r0, DeviceConfig.Properties r1) {
        r0.lambda$new$0(r1);
    }

    /* JADX INFO: renamed from: $r8$lambda$kx9ufaJ8xB2vrPlVgrwxhzbgP-E, reason: not valid java name */
    public static /* synthetic */ void m9100$r8$lambda$kx9ufaJ8xB2vrPlVgrwxhzbgPE(PackageStats r0, int r1, boolean r2, StorageStatsManagerLocal.StorageStatsAugmenter r3) {
        lambda$queryStatsForUid$2(r0, r1, r2, r3);
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmCacheQuotas, reason: not valid java name */
    static /* bridge */ /* synthetic */ ArrayMap m9101$$Nest$fgetmCacheQuotas(StorageStatsService r0) {
        return r0.mCacheQuotas;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmContext, reason: not valid java name */
    static /* bridge */ /* synthetic */ Context m9102$$Nest$fgetmContext(StorageStatsService r0) {
        return r0.mContext;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmHandler, reason: not valid java name */
    static /* bridge */ /* synthetic */ H m9103$$Nest$fgetmHandler(StorageStatsService r0) {
        return r0.mHandler;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmInstaller, reason: not valid java name */
    static /* bridge */ /* synthetic */ Installer m9104$$Nest$fgetmInstaller(StorageStatsService r0) {
        return r0.mInstaller;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmLock, reason: not valid java name */
    static /* bridge */ /* synthetic */ Object m9105$$Nest$fgetmLock(StorageStatsService r0) {
        return r0.mLock;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmStorageStatsAugmenters, reason: not valid java name */
    static /* bridge */ /* synthetic */ CopyOnWriteArrayList m9106$$Nest$fgetmStorageStatsAugmenters(StorageStatsService r0) {
        return r0.mStorageStatsAugmenters;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmStorageThresholdPercentHigh, reason: not valid java name */
    static /* bridge */ /* synthetic */ int m9107$$Nest$fgetmStorageThresholdPercentHigh(StorageStatsService r0) {
        return r0.mStorageThresholdPercentHigh;
    }

    /* JADX INFO: renamed from: -$$Nest$minvalidateMounts, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m9108$$Nest$minvalidateMounts(StorageStatsService r0) {
        r0.invalidateMounts();
    }

    static {
        DEFAULT_QUOTA = DataUnit.MEBIBYTES.toBytes(64);
    }

    public StorageStatsService(Context context) {
        this.mStorageStatsAugmenters = new CopyOnWriteArrayList();
        this.mStorageThresholdPercentHigh = 20;
        this.mLock = new Object();
        this.mContext = (Context) Preconditions.checkNotNull(context);
        this.mAppOps = (AppOpsManager) Preconditions.checkNotNull((AppOpsManager) context.getSystemService(AppOpsManager.class));
        this.mUser = (UserManager) Preconditions.checkNotNull((UserManager) context.getSystemService(UserManager.class));
        this.mPackage = (PackageManager) Preconditions.checkNotNull(context.getPackageManager());
        this.mStorage = (StorageManager) Preconditions.checkNotNull((StorageManager) context.getSystemService(StorageManager.class));
        this.mCacheQuotas = new ArrayMap();
        this.mInstaller = new Installer(context);
        this.mInstaller.onStart();
        invalidateMounts();
        this.mHandler = new H(this, IoThread.get().getLooper());
        this.mHandler.sendEmptyMessage(101);
        this.mStorage.registerListener(new AnonymousClass1(this));
        LocalManagerRegistry.addManager(StorageStatsManagerLocal.class, new LocalService(this, null));
        IntentFilter prFilter = new IntentFilter();
        prFilter.addAction("android.intent.action.PACKAGE_REMOVED");
        prFilter.addAction("android.intent.action.PACKAGE_FULLY_REMOVED");
        prFilter.addDataScheme(Settings.ATTR_PACKAGE);
        this.mContext.registerReceiver(new AnonymousClass2(this), prFilter);
        updateConfig();
        DeviceConfig.addOnPropertiesChangedListener("storage_native_boot", this.mContext.getMainExecutor(), new StorageStatsService$$ExternalSyntheticLambda3(this));
    }

    private /* synthetic */ void lambda$new$0(DeviceConfig.Properties properties) {
        updateConfig();
    }

    private void updateConfig() {
        Object r0 = this.mLock;
        monitor-enter(r0);
        this.mStorageThresholdPercentHigh = DeviceConfig.getInt("storage_native_boot", "storage_threshold_percent_high", 20);     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    private void invalidateMounts() {
        this.mInstaller.invalidateMounts();     // Catch: Installer.InstallerException -> L4
        return;
    L4:
        e = move-exception;
        Slog.wtf(TAG, "Failed to invalidate mounts", e);
    }

    private void enforceStatsPermission(int callingUid, String callingPackage) {
        String errMsg = checkStatsPermission(callingUid, callingPackage, true);
        if (errMsg != null) goto L6;
        return;
    L6:
        throw new SecurityException(errMsg);
    }

    private String checkStatsPermission(int callingUid, String callingPackage, boolean noteOp) {
        if (NBUsageTimeStatsPolicy.skipCheckPermission(callingPackage) == false) goto L6;
        return null;
    L6:
        if (noteOp == false) goto L8;
        int mode = this.mAppOps.noteOp(43, callingUid, callingPackage);
    L9:
        switch(mode) {
            case 0: goto L17;
            case 3: goto L13;
            default: goto L11;
        };
    L17:
        return null;
    L11:
        return "Package " + callingPackage + " from UID " + callingUid + " blocked by mode " + mode;
    L13:
        if (this.mContext.checkCallingOrSelfPermission("android.permission.PACKAGE_USAGE_STATS") != 0) goto L16;
        return null;
    L16:
        return "Caller does not have android.permission.PACKAGE_USAGE_STATS; callingPackage=" + callingPackage + ", callingUid=" + callingUid;
    L8:
        mode = this.mAppOps.checkOp(43, callingUid, callingPackage);
        goto L9
    }

    public boolean isQuotaSupported(String volumeUuid, String callingPackage) {
        return this.mInstaller.isQuotaSupported(volumeUuid);
    L4:
        e = move-exception;
        throw new ParcelableException(new IOException(e.getMessage()));
    }

    public boolean isReservedSupported(String volumeUuid, String callingPackage) {
        if (volumeUuid == StorageManager.UUID_PRIVATE_INTERNAL) goto L5;
        return false;
    L5:
        if (SystemProperties.getBoolean("vold.has_reserved", false) == false) goto L7;
    L8:
        return true;
    L7:
        if (Build.IS_ARC == true) goto L8;
        return false;
    }

    public long getTotalBytes(String volumeUuid, String callingPackage) {
        if (volumeUuid != StorageManager.UUID_PRIVATE_INTERNAL) goto L11;
        long roundedUserspaceBytes = this.mStorage.getPrimaryStorageSize();
        if (roundedUserspaceBytes > DataUnit.GIGABYTES.toBytes(512)) goto L7;
        return roundedUserspaceBytes;
    L7:
        long totalBytes = this.mStorage.getInternalStorageBlockDeviceSize();
        long totalBytesRounded = FileUtils.roundStorageSize(totalBytes);
        if ((totalBytesRounded - totalBytes) > DataUnit.GIGABYTES.toBytes(3)) goto L10;
        return totalBytesRounded;
    L10:
        return totalBytes;
    L11:
        VolumeInfo vol = this.mStorage.findVolumeByUuid(volumeUuid);
        if (vol == null) goto L16;
        return FileUtils.roundStorageSize(vol.disk.size);
    L16:
        throw new ParcelableException(new IOException("Failed to find storage device for UUID " + volumeUuid));
    }

    public long getFreeBytes(String volumeUuid, String callingPackage) {
        long token = Binder.clearCallingIdentity();
        File path = this.mStorage.findPathForUuid(volumeUuid);     // Catch: Throwable -> L7 FileNotFoundException -> L13
    L5:
        if (isQuotaSupported(volumeUuid, PackageManagerService.PLATFORM_PACKAGE_NAME) == false) goto L9;
        long cacheTotal = getCacheBytes(volumeUuid, PackageManagerService.PLATFORM_PACKAGE_NAME);     // Catch: Throwable -> L7
        long cacheReserved = this.mStorage.getStorageCacheBytes(path, 0);     // Catch: Throwable -> L7
        long cacheClearable = Math.max(0, cacheTotal - cacheReserved);     // Catch: Throwable -> L7
        long freeBytes = path.getUsableSpace() + cacheClearable;     // Catch: Throwable -> L7
    L10:
        Slog.d(TAG, "getFreeBytes: " + freeBytes);     // Catch: Throwable -> L7
        Binder.restoreCallingIdentity(token);
        return freeBytes;
    L9:
        freeBytes = path.getUsableSpace();     // Catch: Throwable -> L7
    L13:
        e = move-exception;
        throw new ParcelableException(e);     // Catch: Throwable -> L7
    L7:
        th = move-exception;
        Binder.restoreCallingIdentity(token);
        throw th;
    }

    public long getCacheBytes(String volumeUuid, String callingPackage) {
        enforceStatsPermission(Binder.getCallingUid(), callingPackage);
        long cacheBytes = 0;
        Iterator r2 = this.mUser.getUsers().iterator();
    L4:
        if (r2.hasNext() == false) goto L6;
        UserInfo user = (UserInfo) r2.next();
        StorageStats stats = queryStatsForUser(volumeUuid, user.id, null);
        cacheBytes = cacheBytes + stats.cacheBytes;
        goto L4
    L6:
        return cacheBytes;
    }

    public long getCacheQuotaBytes(String volumeUuid, int uid, String callingPackage) {
        enforceStatsPermission(Binder.getCallingUid(), callingPackage);
        if (this.mCacheQuotas.containsKey(volumeUuid) == false) goto L7;
        SparseLongArray uidMap = this.mCacheQuotas.get(volumeUuid);
        return uidMap.get(uid, DEFAULT_QUOTA);
    L7:
        return DEFAULT_QUOTA;
    }

    public StorageStats queryArtManagedStats(String packageName, int userId, int uid) {
        if (userId == UserHandle.getCallingUserId()) goto L6;
        this.mContext.enforceCallingOrSelfPermission("android.permission.INTERACT_ACROSS_USERS", TAG);
    L6:
        if (TextUtils.isEmpty(packageName) == false) goto L34;
    L15:
        int callingUid = Binder.getCallingUid();
        String callingPackage = this.mPackage.getNameForUid(callingUid);
        if (Binder.getCallingUid() == uid) goto L18;
        enforceStatsPermission(Binder.getCallingUid(), callingPackage);
    L18:
        String[] packageNames = ArrayUtils.defeatNullable(this.mPackage.getPackagesForUid(uid));
        PackageStats stats = new PackageStats(TAG);
        int i = 0;
    L20:
        if (i >= packageNames.length) goto L33;
        ApplicationInfo appInfo = this.mPackage.getApplicationInfoAsUser(packageNames[i], 8192, userId);     // Catch: PackageManager.NameNotFoundException -> L26
        if (appInfo.isSystemApp() == true) goto L24;
    L28:
        computeAppArtStats(stats, packageNames[i]);     // Catch: PackageManager.NameNotFoundException -> L26
    L29:
        i = i + 1;
        goto L20
    L24:
        if (appInfo.isUpdatedSystemApp() == true) goto L28;
    L26:
        e = move-exception;
        throw new ParcelableException(e);
    L33:
        return translate(stats);
    L34:
        ApplicationInfo appInfo2 = this.mPackage.getApplicationInfoAsUser(packageName, 8192, userId);     // Catch: PackageManager.NameNotFoundException -> L12
        uid = appInfo2.uid;
        if (ArrayUtils.defeatNullable(this.mPackage.getPackagesForUid(appInfo2.uid)).length <= 1) goto L15;
        return translate(new PackageStats(TAG));
    L12:
        e = move-exception;
        throw new ParcelableException(e);
    }

    public StorageStats queryStatsForPackage(String volumeUuid, final String packageName, int userId, String callingPackage) {
        if (userId == UserHandle.getCallingUserId()) goto L49;
        this.mContext.enforceCallingOrSelfPermission("android.permission.INTERACT_ACROSS_USERS", TAG);
    L49:
        ApplicationInfo appInfo = this.mPackage.getApplicationInfoAsUser(packageName, 8192, userId);     // Catch: PackageManager.NameNotFoundException -> L42
        if (Binder.getCallingUid() == appInfo.uid) goto L9;
        enforceStatsPermission(Binder.getCallingUid(), callingPackage);
        final boolean callerHasStatsPermission = true;
    L15:
        if (ArrayUtils.defeatNullable(this.mPackage.getPackagesForUid(appInfo.uid)).length != 1) goto L17;
        StorageStats storageStats = queryStatsForUid(volumeUuid, appInfo.uid, callingPackage);
    L34:
        storageStats.packageName = packageName;
        storageStats.userHandle = userId;
        return storageStats;
    L17:
        int appId = UserHandle.getAppId(appInfo.uid);
        String[] packageNames = {packageName};
        long[] ceDataInodes = new long[1];
        String[] codePaths = new String[0];
        if (appInfo.isSystemApp() == false) goto L23;
        if (appInfo.isUpdatedSystemApp() == true) goto L23;
    L25:
        String[] codePaths2 = codePaths;
    L26:
        final PackageStats stats = new PackageStats(TAG);
        this.mInstaller.getAppSize(volumeUuid, packageNames, userId, 0, appId, ceDataInodes, codePaths2, stats);     // Catch: Installer.InstallerException -> L36
        if (volumeUuid != StorageManager.UUID_PRIVATE_INTERNAL) goto L33;
        final UserHandle userHandle = UserHandle.of(userId);
        forEachStorageStatsAugmenter(new StorageStatsService$$ExternalSyntheticLambda2(stats, packageName, userHandle, callerHasStatsPermission), "queryStatsForPackage");
    L33:
        storageStats = translate(stats);
    L36:
        e = e;
    L41:
        throw new ParcelableException(new IOException(e.getMessage()));
    L38:
        e = e;
    L23:
        if (appInfo.getCodePath() == null) goto L25;
        codePaths2 = (String[]) ArrayUtils.appendElement(String.class, codePaths, appInfo.getCodePath());
        goto L26
    L9:
        if (checkStatsPermission(Binder.getCallingUid(), callingPackage, false) != null) goto L11;
        boolean r0 = true;
    L12:
        callerHasStatsPermission = r0;
        goto L15
    L11:
        r0 = false;
    L42:
        e = move-exception;
        throw new ParcelableException(e);
    }

    private static /* synthetic */ void lambda$queryStatsForPackage$1(PackageStats stats, String packageName, UserHandle userHandle, boolean callerHasStatsPermission, StorageStatsManagerLocal.StorageStatsAugmenter storageStatsAugmenter) {
        storageStatsAugmenter.augmentStatsForPackageForUser(stats, packageName, userHandle, callerHasStatsPermission);
    }

    public StorageStats queryStatsForUid(String volumeUuid, final int uid, String callingPackage) {
        int userId = UserHandle.getUserId(uid);
        int appId = UserHandle.getAppId(uid);
        if (userId == UserHandle.getCallingUserId()) goto L6;
        this.mContext.enforceCallingOrSelfPermission("android.permission.INTERACT_ACROSS_USERS", TAG);
    L6:
        if (Binder.getCallingUid() == uid) goto L8;
        enforceStatsPermission(Binder.getCallingUid(), callingPackage);
        final boolean callerHasStatsPermission = true;
    L13:
        String[] packageNames = ArrayUtils.defeatNullable(this.mPackage.getPackagesForUid(uid));
        long[] ceDataInodes = new long[packageNames.length];
        String[] codePaths = new String[0];
        PackageStats stats = new PackageStats(TAG);
        int i = 0;
        String[] codePaths2 = codePaths;
    L15:
        if (i >= packageNames.length) goto L66;
        ApplicationInfo appInfo = this.mPackage.getApplicationInfoAsUser(packageNames[i], 8192, userId);     // Catch: PackageManager.NameNotFoundException -> L21
        if (appInfo.isSystemApp() == false) goto L24;
        if (appInfo.isUpdatedSystemApp() == true) goto L24;
    L27:
        i = i + 1;
    L24:
        if (appInfo.getCodePath() == null) goto L26;
        codePaths2 = (String[]) ArrayUtils.appendElement(String.class, codePaths2, appInfo.getCodePath());     // Catch: PackageManager.NameNotFoundException -> L21
    L26:
        computeAppStatsByDataTypes(stats, appInfo.sourceDir, packageNames[i]);     // Catch: PackageManager.NameNotFoundException -> L21
    L21:
        e = move-exception;
        throw new ParcelableException(e);
    L66:
    L51:
        e = e;
    L57:
        throw new ParcelableException(new IOException(e.getMessage()));
    L58:
        this.mInstaller.getAppSize(volumeUuid, packageNames, userId, getDefaultFlags(), appId, ceDataInodes, codePaths2, stats);     // Catch: Installer.InstallerException -> L54
        if (SystemProperties.getBoolean(PROP_VERIFY_STORAGE, false) == true) goto L64;
        final PackageStats stats2 = stats;
    L47:
        if (volumeUuid != StorageManager.UUID_PRIVATE_INTERNAL) goto L49;
        forEachStorageStatsAugmenter(new StorageStatsService$$ExternalSyntheticLambda1(stats2, uid, callerHasStatsPermission), "queryStatsForUid");
    L49:
        StorageStats storageStats = translate(stats2);
        storageStats.userHandle = userId;
        storageStats.uid = uid;
        return storageStats;
    L64:
        PackageStats manualStats = new PackageStats(TAG);     // Catch: Installer.InstallerException -> L42
        stats2 = stats;
        this.mInstaller.getAppSize(volumeUuid, packageNames, userId, 0, appId, ceDataInodes, codePaths2, manualStats);     // Catch: Installer.InstallerException -> L40
        checkEquals("UID " + uid, manualStats, stats2);     // Catch: Installer.InstallerException -> L40
    L40:
        e = e;
    L42:
        e = e;
    L54:
        e = e;
        goto L57
    L8:
        if (checkStatsPermission(Binder.getCallingUid(), callingPackage, false) != null) goto L10;
        boolean r0 = true;
    L11:
        callerHasStatsPermission = r0;
        goto L13
    L10:
        r0 = false;
        goto L11
    }

    private static /* synthetic */ void lambda$queryStatsForUid$2(PackageStats stats, int uid, boolean callerHasStatsPermission, StorageStatsManagerLocal.StorageStatsAugmenter storageStatsAugmenter) {
        storageStatsAugmenter.augmentStatsForUid(stats, uid, callerHasStatsPermission);
    }

    public StorageStats queryStatsForUser(String volumeUuid, int userId, String callingPackage) {
        if (userId == UserHandle.getCallingUserId()) goto L5;
        this.mContext.enforceCallingOrSelfPermission("android.permission.INTERACT_ACROSS_USERS", TAG);
    L5:
        enforceStatsPermission(Binder.getCallingUid(), callingPackage);
        int[] appIds = getAppIds(userId);
        final PackageStats stats = new PackageStats(TAG);
        this.mInstaller.getUserSize(volumeUuid, userId, getDefaultFlags(), appIds, stats);     // Catch: Installer.InstallerException -> L21
    L14:
        e = move-exception;
        Installer.InstallerException e = e;
    L26:
        throw new ParcelableException(new IOException(e.getMessage()));
    L11:
        if (SystemProperties.getBoolean(PROP_VERIFY_STORAGE, false) == false) goto L17;
        PackageStats manualStats = new PackageStats(TAG);     // Catch: Installer.InstallerException -> L14
        this.mInstaller.getUserSize(volumeUuid, userId, 0, appIds, manualStats);     // Catch: Installer.InstallerException -> L14
        checkEquals("User " + userId, manualStats, stats);     // Catch: Installer.InstallerException -> L14
    L17:
        if (volumeUuid != StorageManager.UUID_PRIVATE_INTERNAL) goto L20;
        final UserHandle userHandle = UserHandle.of(userId);
        forEachStorageStatsAugmenter(new StorageStatsService$$ExternalSyntheticLambda0(stats, userHandle), "queryStatsForUser");
    L20:
        return translate(stats);
    L21:
        e = move-exception;
        e = e;
    L23:
        e = move-exception;
        e = e;
        goto L26
    }

    private static /* synthetic */ void lambda$queryStatsForUser$3(PackageStats stats, UserHandle userHandle, StorageStatsManagerLocal.StorageStatsAugmenter storageStatsAugmenter) {
        storageStatsAugmenter.augmentStatsForUser(stats, userHandle);
    }

    public ExternalStorageStats queryExternalStatsForUser(String volumeUuid, int userId, String callingPackage) {
        if (userId == UserHandle.getCallingUserId()) goto L5;
        this.mContext.enforceCallingOrSelfPermission("android.permission.INTERACT_ACROSS_USERS", TAG);
    L5:
        enforceStatsPermission(Binder.getCallingUid(), callingPackage);
        int[] appIds = getAppIds(userId);
        long[] stats = this.mInstaller.getExternalSize(volumeUuid, userId, getDefaultFlags(), appIds);     // Catch: Installer.InstallerException -> L10
        if (SystemProperties.getBoolean(PROP_VERIFY_STORAGE, false) == false) goto L12;
        long[] manualStats = this.mInstaller.getExternalSize(volumeUuid, userId, 0, appIds);     // Catch: Installer.InstallerException -> L10
        checkEquals("External " + userId, manualStats, stats);     // Catch: Installer.InstallerException -> L10
    L12:
        ExternalStorageStats res = new ExternalStorageStats();
        res.totalBytes = stats[0];
        res.audioBytes = stats[1];
        res.videoBytes = stats[2];
        res.imageBytes = stats[3];
        res.appBytes = stats[4];
        res.obbBytes = stats[5];
        return res;
    L10:
        e = move-exception;
        throw new ParcelableException(new IOException(e.getMessage()));
    }

    private int[] getAppIds(int userId) {
        int[] appIds = null;
        Iterator r1 = this.mPackage.getInstalledApplicationsAsUser(8192, userId).iterator();
    L4:
        if (r1.hasNext() == false) goto L9;
        ApplicationInfo app = (ApplicationInfo) r1.next();
        int appId = UserHandle.getAppId(app.uid);
        if (ArrayUtils.contains(appIds, appId) == true) goto L4;
        appIds = ArrayUtils.appendInt(appIds, appId);
        goto L4
    L9:
        return appIds;
    }

    private static int getDefaultFlags() {
        if (SystemProperties.getBoolean(PROP_DISABLE_QUOTA, false) == false) goto L5;
        return 0;
    L5:
        return 4096;
    }

    private static void checkEquals(String msg, long[] a, long[] b) {
        int i = 0;
    L4:
        if (i >= a.length) goto L7;
        checkEquals(msg + "[" + i + "]", a[i], b[i]);
        i = i + 1;
        goto L4
    }

    private static void checkEquals(String msg, PackageStats a, PackageStats b) {
        checkEquals(msg + " codeSize", a.codeSize, b.codeSize);
        checkEquals(msg + " dataSize", a.dataSize, b.dataSize);
        checkEquals(msg + " cacheSize", a.cacheSize, b.cacheSize);
        checkEquals(msg + " externalCodeSize", a.externalCodeSize, b.externalCodeSize);
        checkEquals(msg + " externalDataSize", a.externalDataSize, b.externalDataSize);
        checkEquals(msg + " externalCacheSize", a.externalCacheSize, b.externalCacheSize);
    }

    private static void checkEquals(String msg, long expected, long actual) {
        if (expected == actual) goto L6;
        Slog.e(TAG, msg + " expected " + expected + " actual " + actual);
        return;
    }

    private StorageStats translate(PackageStats stats) {
        StorageStats res = new StorageStats();
        res.userHandle = stats.userHandle;
        res.codeBytes = stats.codeSize + stats.externalCodeSize;
        res.dataBytes = stats.dataSize + stats.externalDataSize;
        res.cacheBytes = stats.cacheSize + stats.externalCacheSize;
        res.dexoptBytes = stats.dexoptSize;
        res.curProfBytes = stats.curProfSize;
        res.refProfBytes = stats.refProfSize;
        res.apkBytes = stats.apkSize;
        res.libBytes = stats.libSize;
        res.dmBytes = stats.dmSize;
        res.externalCacheBytes = stats.externalCacheSize;
        return res;
    }

    static boolean isCacheQuotaCalculationsEnabled(ContentResolver resolver) {
        if (android.provider.Settings.Global.getInt(resolver, "enable_cache_quota_calculation", 1) != 0) goto L7;
        return false;
    L7:
        return true;
    }

    void notifySignificantDelta() {
        this.mContext.getContentResolver().notifyChange(Uri.parse("content://com.android.externalstorage.documents/"), null, false);
    }

    private static void checkCratesEnable() {
        boolean enable = SystemProperties.getBoolean(PROP_STORAGE_CRATES, false);
        if (enable == false) goto L6;
        return;
    L6:
        throw new IllegalStateException("Storage Crate feature is disabled.");
    }

    private void enforceCratesPermission(int callingUid, String callingPackage) {
        this.mContext.enforceCallingOrSelfPermission("android.permission.MANAGE_CRATES", callingPackage);
    }

    private static List<CrateInfo> convertCrateInfoFrom(CrateMetadata[] crateMetadatas) {
        if (ArrayUtils.isEmpty(crateMetadatas) == true) goto L5;
        ArrayList<CrateInfo> crateInfos = new ArrayList();
        int r1 = crateMetadatas.length;
        int r2 = 0;
    L7:
        if (r2 >= r1) goto L20;
        CrateMetadata crateMetadata = crateMetadatas[r2];
        if (crateMetadata == null) goto L19;
        if (TextUtils.isEmpty(crateMetadata.id) == true) goto L19;
        if (TextUtils.isEmpty(crateMetadata.packageName) == true) goto L19;
        CrateInfo crateInfo = CrateInfo.copyFrom(crateMetadata.uid, crateMetadata.packageName, crateMetadata.id);
        if (crateInfo == null) goto L19;
        crateInfos.add(crateInfo);
    L19:
        r2 = r2 + 1;
        goto L7
    L20:
        return crateInfos;
    L5:
        return Collections.EMPTY_LIST;
    }

    private ParceledListSlice<CrateInfo> getAppCrates(String volumeUuid, String[] packageNames, int userId) {
        CrateMetadata[] crateMetadatas = this.mInstaller.getAppCrates(volumeUuid, packageNames, userId);     // Catch: Installer.InstallerException -> L4
        return new ParceledListSlice(convertCrateInfoFrom(crateMetadatas));
    L4:
        e = move-exception;
        throw new ParcelableException(new IOException(e.getMessage()));
    }

    public ParceledListSlice<CrateInfo> queryCratesForPackage(String volumeUuid, String packageName, int userId, String callingPackage) {
        checkCratesEnable();
        if (userId == UserHandle.getCallingUserId()) goto L15;
        this.mContext.enforceCallingOrSelfPermission("android.permission.INTERACT_ACROSS_USERS", TAG);
    L15:
        ApplicationInfo appInfo = this.mPackage.getApplicationInfoAsUser(packageName, 8192, userId);     // Catch: PackageManager.NameNotFoundException -> L12
        if (Binder.getCallingUid() == appInfo.uid) goto L10;
        enforceCratesPermission(Binder.getCallingUid(), callingPackage);
    L10:
        String[] packageNames = {packageName};
        return getAppCrates(volumeUuid, packageNames, userId);
    L12:
        e = move-exception;
        throw new ParcelableException(e);
    }

    public ParceledListSlice<CrateInfo> queryCratesForUid(String volumeUuid, int uid, String callingPackage) {
        checkCratesEnable();
        int userId = UserHandle.getUserId(uid);
        if (userId == UserHandle.getCallingUserId()) goto L6;
        this.mContext.enforceCallingOrSelfPermission("android.permission.INTERACT_ACROSS_USERS", TAG);
    L6:
        if (Binder.getCallingUid() == uid) goto L9;
        enforceCratesPermission(Binder.getCallingUid(), callingPackage);
    L9:
        String[] packageNames = ArrayUtils.defeatNullable(this.mPackage.getPackagesForUid(uid));
        int r2 = 0;
        String[] validatedPackageNames = new String[0];
        int r4 = packageNames.length;
    L10:
        if (r2 >= r4) goto L24;
        String packageName = packageNames[r2];
        if (TextUtils.isEmpty(packageName) == true) goto L19;
        ApplicationInfo appInfo = this.mPackage.getApplicationInfoAsUser(packageName, 8192, userId);     // Catch: PackageManager.NameNotFoundException -> L20
        if (appInfo == null) goto L19;
        validatedPackageNames = (String[]) ArrayUtils.appendElement(String.class, validatedPackageNames, packageName);     // Catch: PackageManager.NameNotFoundException -> L20
    L20:
        e = move-exception;
        throw new ParcelableException(e);
    L19:
        r2 = r2 + 1;
        goto L10
    L24:
        return getAppCrates(volumeUuid, validatedPackageNames, userId);
    }

    public ParceledListSlice<CrateInfo> queryCratesForUser(String volumeUuid, int userId, String callingPackage) {
        checkCratesEnable();
        if (userId == UserHandle.getCallingUserId()) goto L5;
        this.mContext.enforceCallingOrSelfPermission("android.permission.INTERACT_ACROSS_USERS", TAG);
    L5:
        enforceCratesPermission(Binder.getCallingUid(), callingPackage);
        CrateMetadata[] crateMetadatas = this.mInstaller.getUserCrates(volumeUuid, userId);     // Catch: Installer.InstallerException -> L8
        return new ParceledListSlice(convertCrateInfoFrom(crateMetadatas));
    L8:
        e = move-exception;
        throw new ParcelableException(new IOException(e.getMessage()));
    }

    void forEachStorageStatsAugmenter(Consumer<StorageStatsManagerLocal.StorageStatsAugmenter> consumer, String queryTag) {
        int i = 0;
        int count = this.mStorageStatsAugmenters.size();
    L3:
        if (i >= count) goto L11;
        Pair<String, StorageStatsManagerLocal.StorageStatsAugmenter> pair = this.mStorageStatsAugmenters.get(i);
        String augmenterTag = (String) pair.first;
        StorageStatsManagerLocal.StorageStatsAugmenter storageStatsAugmenter = (StorageStatsManagerLocal.StorageStatsAugmenter) pair.second;
        Trace.traceBegin(524288, queryTag + ":" + augmenterTag);
        consumer.accept(storageStatsAugmenter);     // Catch: Throwable -> L7
        Trace.traceEnd(524288);
        i = i + 1;
    L7:
        th = move-exception;
        Trace.traceEnd(524288);
        throw th;
    }

    private long getDirBytes(File dir) {
        if (dir.isDirectory() == true) goto L6;
        return 0;
    L6:
        long size = 0;
        File[] r2 = dir.listFiles();     // Catch: NullPointerException -> L12
        int r3 = r2.length;     // Catch: NullPointerException -> L12
        int r4 = 0;
    L8:
        if (r4 >= r3) goto L21;
        File file = r2[r4];     // Catch: NullPointerException -> L12
        if (file.isFile() == false) goto L15;
        size = size + file.length();     // Catch: NullPointerException -> L12
    L18:
        r4 = r4 + 1;
        goto L8
    L15:
        if (file.isDirectory() == false) goto L18;
        size = size + getDirBytes(file);
    L21:
        return size;
    L20:
        Slog.w(TAG, "Failed to list directory " + dir.getName());
        goto L21
    }

    private long getFileBytesInDir(File dir, String suffix) {
        if (dir.isDirectory() == true) goto L6;
        return 0;
    L6:
        long size = 0;
        File[] r2 = dir.listFiles();     // Catch: NullPointerException -> L15
        int r3 = r2.length;     // Catch: NullPointerException -> L15
        int r4 = 0;
    L8:
        if (r4 >= r3) goto L20;
        File file = r2[r4];     // Catch: NullPointerException -> L15
        if (file.isFile() == false) goto L17;
        if (file.getName().endsWith(suffix) == false) goto L17;
        size = size + file.length();
    L17:
        r4 = r4 + 1;
    L20:
        return size;
    L19:
        Slog.w(TAG, "Failed to list directory " + dir.getName());
        goto L20
    }

    private void computeAppStatsByDataTypes(PackageStats stats, String sourceDirName, String packageName) {
        File srcDir = new File(sourceDirName);
        if (srcDir.isFile() == false) goto L5;
        sourceDirName = srcDir.getParent();
        srcDir = new File(sourceDirName);
    L5:
        stats.apkSize += getFileBytesInDir(srcDir, ".apk");
        stats.dmSize += getFileBytesInDir(srcDir, ".dm");
        stats.libSize = stats.libSize + getDirBytes(new File(sourceDirName + "/lib/"));
    }

    private void computeAppArtStats(PackageStats stats, String packageName) {
        PackageManagerLocal.FilteredSnapshot snapshot = PackageManagerServiceUtils.getPackageManagerLocal().withFilteredSnapshot();
        ArtManagedFileStats artManagedFileStats = DexOptHelper.getArtManagerLocal().getArtManagedFileStats(snapshot, packageName);     // Catch: Throwable -> L8
        if (snapshot == null) goto L6;
        snapshot.close();
    L6:
        stats.dexoptSize += artManagedFileStats.getTotalSizeBytesByType(0);
        stats.refProfSize += artManagedFileStats.getTotalSizeBytesByType(1);
        stats.curProfSize += artManagedFileStats.getTotalSizeBytesByType(2);
        return;
    L8:
        th = move-exception;
        if (snapshot != null) goto L17;
    L14:
        throw th;
    L17:
        snapshot.close();     // Catch: Throwable -> L12
    L12:
        th = move-exception;
        th.addSuppressed(th);
        goto L14
    }
}
