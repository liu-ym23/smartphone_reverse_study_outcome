package com.android.server.pm.dex;

import android.app.AppOpsManager;
import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.IPackageManager;
import android.content.pm.PackageInfo;
import android.content.pm.dex.ArtManagerInternal;
import android.content.pm.dex.IArtManager;
import android.content.pm.dex.ISnapshotRuntimeProfileCallback;
import android.content.pm.dex.PackageOptimizationInfo;
import android.hardware.tv.mediaquality.ParameterName;
import android.os.Binder;
import android.os.Build;
import android.os.Handler;
import android.os.ParcelFileDescriptor;
import android.os.RemoteException;
import android.os.ServiceManager;
import android.os.SystemProperties;
import android.util.Log;
import android.util.Slog;
import com.android.internal.os.BackgroundThread;
import com.android.internal.os.RoSystemProperties;
import com.android.internal.util.Preconditions;
import com.android.server.LocalServices;
import com.android.server.pm.DexOptHelper;
import com.android.server.pm.Installer;
import com.android.server.pm.PackageManagerLocal;
import com.android.server.pm.PackageManagerServiceCompilerMapping;
import com.android.server.pm.PackageManagerServiceUtils;
import com.android.server.pm.Settings;
import dalvik.system.DexFile;
import dalvik.system.VMRuntime;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.LinkOption;
import java.nio.file.Path;
import java.nio.file.Paths;
import libcore.io.IoUtils;

/* JADX INFO: loaded from: classes2.dex */
public class ArtManagerService extends IArtManager.Stub {
    private static final String BOOT_IMAGE_ANDROID_PACKAGE = "android";
    private static final String BOOT_IMAGE_PROFILE_NAME = "android.prof";
    private static final boolean DEBUG = false;
    public static final String DEXOPT_REASON_WITH_DEX_METADATA_ANNOTATION = "-dm";
    private static final String TAG = "ArtManagerService";
    private static final int TRON_COMPILATION_FILTER_ASSUMED_VERIFIED = 2;
    private static final int TRON_COMPILATION_FILTER_ASSUMED_VERIFIED_IORAP = 15;
    private static final int TRON_COMPILATION_FILTER_ERROR = 0;
    private static final int TRON_COMPILATION_FILTER_EVERYTHING = 11;
    private static final int TRON_COMPILATION_FILTER_EVERYTHING_IORAP = 24;
    private static final int TRON_COMPILATION_FILTER_EVERYTHING_PROFILE = 10;
    private static final int TRON_COMPILATION_FILTER_EVERYTHING_PROFILE_IORAP = 23;
    private static final int TRON_COMPILATION_FILTER_EXTRACT = 3;
    private static final int TRON_COMPILATION_FILTER_EXTRACT_IORAP = 16;
    private static final int TRON_COMPILATION_FILTER_FAKE_RUN_FROM_APK = 12;
    private static final int TRON_COMPILATION_FILTER_FAKE_RUN_FROM_APK_FALLBACK = 13;
    private static final int TRON_COMPILATION_FILTER_FAKE_RUN_FROM_APK_FALLBACK_IORAP = 26;
    private static final int TRON_COMPILATION_FILTER_FAKE_RUN_FROM_APK_IORAP = 25;
    private static final int TRON_COMPILATION_FILTER_FAKE_RUN_FROM_VDEX_FALLBACK = 14;
    private static final int TRON_COMPILATION_FILTER_FAKE_RUN_FROM_VDEX_FALLBACK_IORAP = 27;
    private static final int TRON_COMPILATION_FILTER_QUICKEN = 5;
    private static final int TRON_COMPILATION_FILTER_QUICKEN_IORAP = 18;
    private static final int TRON_COMPILATION_FILTER_SPACE = 7;
    private static final int TRON_COMPILATION_FILTER_SPACE_IORAP = 20;
    private static final int TRON_COMPILATION_FILTER_SPACE_PROFILE = 6;
    private static final int TRON_COMPILATION_FILTER_SPACE_PROFILE_IORAP = 19;
    private static final int TRON_COMPILATION_FILTER_SPEED = 9;
    private static final int TRON_COMPILATION_FILTER_SPEED_IORAP = 22;
    private static final int TRON_COMPILATION_FILTER_SPEED_PROFILE = 8;
    private static final int TRON_COMPILATION_FILTER_SPEED_PROFILE_IORAP = 21;
    private static final int TRON_COMPILATION_FILTER_UNKNOWN = 1;
    private static final int TRON_COMPILATION_FILTER_VERIFY = 4;
    private static final int TRON_COMPILATION_FILTER_VERIFY_IORAP = 17;
    private static final int TRON_COMPILATION_REASON_AB_OTA = 6;
    private static final int TRON_COMPILATION_REASON_BG_DEXOPT = 5;
    private static final int TRON_COMPILATION_REASON_BOOT_AFTER_MAINLINE_UPDATE = 25;
    private static final int TRON_COMPILATION_REASON_BOOT_AFTER_OTA = 20;
    private static final int TRON_COMPILATION_REASON_BOOT_DEPRECATED_SINCE_S = 3;
    private static final int TRON_COMPILATION_REASON_CLOUD = 26;
    private static final int TRON_COMPILATION_REASON_CMDLINE = 22;
    private static final int TRON_COMPILATION_REASON_ERROR = 0;
    private static final int TRON_COMPILATION_REASON_FIRST_BOOT = 2;
    private static final int TRON_COMPILATION_REASON_INACTIVE = 7;
    private static final int TRON_COMPILATION_REASON_INSTALL = 4;
    private static final int TRON_COMPILATION_REASON_INSTALL_BULK = 11;
    private static final int TRON_COMPILATION_REASON_INSTALL_BULK_DOWNGRADED = 13;
    private static final int TRON_COMPILATION_REASON_INSTALL_BULK_DOWNGRADED_WITH_DM = 18;
    private static final int TRON_COMPILATION_REASON_INSTALL_BULK_SECONDARY = 12;
    private static final int TRON_COMPILATION_REASON_INSTALL_BULK_SECONDARY_DOWNGRADED = 14;
    private static final int TRON_COMPILATION_REASON_INSTALL_BULK_SECONDARY_DOWNGRADED_WITH_DM = 19;
    private static final int TRON_COMPILATION_REASON_INSTALL_BULK_SECONDARY_WITH_DM = 17;
    private static final int TRON_COMPILATION_REASON_INSTALL_BULK_WITH_DM = 16;
    private static final int TRON_COMPILATION_REASON_INSTALL_FAST = 10;
    private static final int TRON_COMPILATION_REASON_INSTALL_FAST_WITH_DM = 15;
    private static final int TRON_COMPILATION_REASON_INSTALL_WITH_DM = 9;
    private static final int TRON_COMPILATION_REASON_POST_BOOT = 21;
    private static final int TRON_COMPILATION_REASON_PREBUILT = 23;
    private static final int TRON_COMPILATION_REASON_SHARED = 8;
    private static final int TRON_COMPILATION_REASON_UNKNOWN = 1;
    private static final int TRON_COMPILATION_REASON_VDEX = 24;
    private final Context mContext;
    private final Handler mHandler;
    private final Installer mInstaller;
    private IPackageManager mPackageManager;

    private class ArtManagerInternalImpl extends ArtManagerInternal {
        private static final String IORAP_DIR = "/data/misc/iorapd";
        private static final String TAG = "ArtManagerInternalImpl";

        /* synthetic */ ArtManagerInternalImpl(ArtManagerService r1, ArtManagerServiceIA r2) {
            this(r1);
        }

        private ArtManagerInternalImpl(ArtManagerService r1) {
        }

        public PackageOptimizationInfo getPackageOptimizationInfo(ApplicationInfo info, String abi, String activityName) {
            if (info.packageName.equals("android") == true) goto L5;
            String isa = VMRuntime.getInstructionSet(abi);     // Catch: IllegalArgumentException -> L8 FileNotFoundException -> L10
            DexFile.OptimizationInfo optInfo = DexFile.getDexFileOptimizationInfo(info.getBaseCodePath(), isa);     // Catch: IllegalArgumentException -> L8 FileNotFoundException -> L10
            String compilationFilter = optInfo.getStatus();     // Catch: IllegalArgumentException -> L8 FileNotFoundException -> L10
            String compilationReason = optInfo.getReason();     // Catch: IllegalArgumentException -> L8 FileNotFoundException -> L10
        L15:
            if (checkIorapCompiledTrace(info.packageName, activityName, info.longVersionCode) == false) goto L17;
            compilationFilter = compilationFilter + "-iorap";
        L17:
            int compilationFilterTronValue = ArtManagerService.m7036$$Nest$smgetCompilationFilterTronValue(compilationFilter);
            int compilationReasonTronValue = ArtManagerService.m7037$$Nest$smgetCompilationReasonTronValue(compilationReason);
            return new PackageOptimizationInfo(compilationFilterTronValue, compilationReasonTronValue);
        L10:
            e = move-exception;
            Slog.e(TAG, "Could not get optimizations status for " + info.getBaseCodePath(), e);
            compilationFilter = "error";
            compilationReason = "error";
        L8:
            e = move-exception;
            Slog.wtf(TAG, "Requested optimization status for " + info.getBaseCodePath() + " due to an invalid abi " + abi, e);
            compilationFilter = "error";
            compilationReason = "error";
            goto L15
        L5:
            return PackageOptimizationInfo.createWithNoInfo();
        }

        private boolean checkIorapCompiledTrace(String packageName, String activityName, long version) {
            Path tracePath = Paths.get(IORAP_DIR, new String[]{packageName, Long.toString(version), activityName, "compiled_traces", "compiled_trace.pb"});
            boolean exists = Files.exists(tracePath, new LinkOption[0]);     // Catch: IOException -> L8
            if (ArtManagerService.m7035$$Nest$sfgetDEBUG() == false) goto L12;
            StringBuilder r4 = new StringBuilder();     // Catch: IOException -> L8
            r4.append(tracePath.toString());     // Catch: IOException -> L8
            if (exists == false) goto L10;
            String r5 = " exists";
        L11:
            r4.append(r5);     // Catch: IOException -> L8
            Log.d(TAG, r4.toString());     // Catch: IOException -> L8
            goto L12
        L10:
            r5 = " doesn't exist";
        L12:
            if (exists == false) goto L20;
            long bytes = Files.size(tracePath);     // Catch: IOException -> L8
            if (ArtManagerService.m7035$$Nest$sfgetDEBUG() == false) goto L17;
            Log.d(TAG, tracePath.toString() + " size is " + Long.toString(bytes));     // Catch: IOException -> L8
        L17:
            if (bytes <= 0) goto L25;
            return true;
        L25:
            return false;
        L20:
            return exists;
        L8:
            e = move-exception;
            Log.d(TAG, e.getMessage());
            return false;
        }
    }

    /* JADX INFO: renamed from: $r8$lambda$GNacBYR-hVAPKUlbQwQy97kOseI, reason: not valid java name */
    public static /* synthetic */ void m7033$r8$lambda$GNacBYRhVAPKUlbQwQy97kOseI(ParcelFileDescriptor r0, ISnapshotRuntimeProfileCallback r1, String r2) {
        lambda$postSuccess$1(r0, r1, r2);
    }

    /* JADX INFO: renamed from: $r8$lambda$zaKbCuBUQ9a-lDfPGRno4QUwo6w, reason: not valid java name */
    public static /* synthetic */ void m7034$r8$lambda$zaKbCuBUQ9alDfPGRno4QUwo6w(ISnapshotRuntimeProfileCallback r0, int r1, String r2) {
        lambda$postError$0(r0, r1, r2);
    }

    /* JADX INFO: renamed from: -$$Nest$sfgetDEBUG, reason: not valid java name */
    static /* bridge */ /* synthetic */ boolean m7035$$Nest$sfgetDEBUG() {
        return DEBUG;
    }

    /* JADX INFO: renamed from: -$$Nest$smgetCompilationFilterTronValue, reason: not valid java name */
    static /* bridge */ /* synthetic */ int m7036$$Nest$smgetCompilationFilterTronValue(String r0) {
        return getCompilationFilterTronValue(r0);
    }

    /* JADX INFO: renamed from: -$$Nest$smgetCompilationReasonTronValue, reason: not valid java name */
    static /* bridge */ /* synthetic */ int m7037$$Nest$smgetCompilationReasonTronValue(String r0) {
        return getCompilationReasonTronValue(r0);
    }

    static {
        DEBUG = Log.isLoggable(TAG, 3);
        verifyTronLoggingConstants();
    }

    public ArtManagerService(Context context, Installer installer, Object ignored) {
        this.mContext = context;
        this.mInstaller = installer;
        this.mHandler = new Handler(BackgroundThread.getHandler().getLooper());
        LocalServices.addService(ArtManagerInternal.class, new ArtManagerInternalImpl(this, null));
    }

    private IPackageManager getPackageManager() {
        if (this.mPackageManager != null) goto L6;
        this.mPackageManager = IPackageManager.Stub.asInterface(ServiceManager.getService(Settings.ATTR_PACKAGE));
    L6:
        return this.mPackageManager;
    }

    private boolean checkAndroidPermissions(int callingUid, String callingPackage) {
        this.mContext.enforceCallingOrSelfPermission("android.permission.READ_RUNTIME_PROFILES", TAG);
        switch(((AppOpsManager) this.mContext.getSystemService(AppOpsManager.class)).noteOp(43, callingUid, callingPackage)) {
            case 0: goto L8;
            case 3: goto L6;
            default: goto L4;
        };
    L4:
        return false;
    L6:
        this.mContext.enforceCallingOrSelfPermission("android.permission.PACKAGE_USAGE_STATS", TAG);
        return true;
    L8:
        return true;
    }

    private boolean checkShellPermissions(int profileType, String packageName, int callingUid) {
        if (callingUid == 2000) goto L6;
        return false;
    L6:
        if (RoSystemProperties.DEBUGGABLE == false) goto L8;
        return true;
    L8:
        if (profileType != 1) goto L10;
        return false;
    L10:
        PackageInfo info = null;
        info = getPackageManager().getPackageInfo(packageName, 0, 0);     // Catch: RemoteException -> L13
    L14:
        if (info != null) goto L17;
        return false;
    L17:
        if ((info.applicationInfo.flags & 2) == 2) goto L19;
        return false;
    L19:
        return true;
    }

    public void snapshotRuntimeProfile(int profileType, String packageName, String codePath, ISnapshotRuntimeProfileCallback callback, String callingPackage) {
        int callingUid = Binder.getCallingUid();
        if (checkShellPermissions(profileType, packageName, callingUid) == false) goto L5;
    L11:
        callback.getClass();
        boolean bootImageProfile = true;
        if (profileType == 1) goto L15;
        bootImageProfile = false;
    L15:
        if (bootImageProfile == true) goto L18;
        Preconditions.checkStringNotEmpty(codePath);
        Preconditions.checkStringNotEmpty(packageName);
    L18:
        if (isRuntimeProfilingEnabled(profileType, callingPackage) == false) goto L27;
        if (DEBUG == false) goto L22;
        Slog.d(TAG, "Requested snapshot for " + packageName + ":" + codePath);
    L22:
        if (bootImageProfile == false) goto L24;
        snapshotBootImageProfile(callback);
        return;
    L24:
        snapshotAppProfile(packageName, codePath, callback);
        return;
    L27:
        throw new IllegalStateException("Runtime profiling is not enabled for " + profileType);
    L5:
        if (checkAndroidPermissions(callingUid, callingPackage) == true) goto L11;
        callback.onError(2);     // Catch: RemoteException -> L9
        return;
    }

    private void snapshotAppProfile(String packageName, String codePath, ISnapshotRuntimeProfileCallback callback) {
        PackageInfo info = null;
        info = getPackageManager().getPackageInfo(packageName, 0, 0);     // Catch: RemoteException -> L5
    L6:
        if (info != null) goto L9;
        postError(callback, packageName, 0);
        return;
    L9:
        boolean pathFound = info.applicationInfo.getBaseCodePath().equals(codePath);
        String splitName = null;
        String[] splitCodePaths = info.applicationInfo.getSplitCodePaths();
        if (pathFound == true) goto L18;
        if (splitCodePaths == null) goto L18;
        int i = splitCodePaths.length - 1;
    L13:
        if (i < 0) goto L18;
        if (splitCodePaths[i].equals(codePath) == true) goto L16;
        i = i - 1;
        goto L13
    L16:
        pathFound = true;
        splitName = info.applicationInfo.splitNames[i];
    L18:
        if (pathFound == true) goto L44;
        postError(callback, packageName, 1);
        return;
    L44:
        PackageManagerLocal.FilteredSnapshot snapshot = PackageManagerServiceUtils.getPackageManagerLocal().withFilteredSnapshot();     // Catch: Throwable -> L26 IllegalArgumentException -> L28
        ParcelFileDescriptor fd = DexOptHelper.getArtManagerLocal().snapshotAppProfile(snapshot, packageName, splitName);     // Catch: Throwable -> L32
        if (snapshot == null) goto L30;
        snapshot.close();     // Catch: Throwable -> L26 Throwable -> L26 IllegalArgumentException -> L28
    L30:
        postSuccess(packageName, fd, callback);
        return;
    L32:
        th = move-exception;
        if (snapshot != null) goto L49;
    L39:
        throw th;     // Catch: Throwable -> L26 Throwable -> L26 IllegalArgumentException -> L28
    L49:
        snapshot.close();     // Catch: Throwable -> L36
    L36:
        th = move-exception;
        th.addSuppressed(th);     // Catch: Throwable -> L26 Throwable -> L26 IllegalArgumentException -> L28
        goto L39
    L42:
        postError(callback, packageName, 0);
        return;
    L40:
        postError(callback, packageName, 2);
    }

    public boolean isRuntimeProfilingEnabled(int profileType, String callingPackage) {
        int callingUid = Binder.getCallingUid();
        if (callingUid == 2000) goto L8;
        if (checkAndroidPermissions(callingUid, callingPackage) == true) goto L8;
        return false;
    L8:
        switch(profileType) {
            case 0: goto L18;
            case 1: goto L11;
            default: goto L10;
        };
    L11:
        boolean profileBootClassPath = SystemProperties.getBoolean("persist.device_config.runtime_native_boot.profilebootclasspath", SystemProperties.getBoolean("dalvik.vm.profilebootclasspath", false));
        if (Build.IS_USERDEBUG == false) goto L14;
    L15:
        if (profileBootClassPath == true) goto L17;
        return false;
    L17:
        return true;
    L14:
        if (Build.IS_ENG == true) goto L15;
        return false;
    L18:
        return true;
    L10:
        throw new IllegalArgumentException("Invalid profile type:" + profileType);
    }

    private void snapshotBootImageProfile(ISnapshotRuntimeProfileCallback callback) {
        PackageManagerLocal.FilteredSnapshot snapshot = PackageManagerServiceUtils.getPackageManagerLocal().withFilteredSnapshot();     // Catch: Throwable -> L8
        ParcelFileDescriptor fd = DexOptHelper.getArtManagerLocal().snapshotBootImageProfile(snapshot);     // Catch: Throwable -> L12
        if (snapshot == null) goto L10;
        snapshot.close();     // Catch: Throwable -> L8 Throwable -> L8
    L10:
        postSuccess("android", fd, callback);
        return;
    L12:
        th = move-exception;
        if (snapshot != null) goto L22;
    L19:
        throw th;     // Catch: Throwable -> L8 Throwable -> L8
    L22:
        snapshot.close();     // Catch: Throwable -> L16
    L16:
        th = move-exception;
        th.addSuppressed(th);     // Catch: Throwable -> L8 Throwable -> L8
        goto L19
    L20:
        postError(callback, "android", 2);
    }

    private void postError(final ISnapshotRuntimeProfileCallback callback, final String packageName, final int errCode) {
        if (DEBUG == false) goto L5;
        Slog.d(TAG, "Failed to snapshot profile for " + packageName + " with error: " + errCode);
    L5:
        this.mHandler.post(new ArtManagerService$$ExternalSyntheticLambda1(callback, errCode, packageName));
    }

    private static /* synthetic */ void lambda$postError$0(ISnapshotRuntimeProfileCallback callback, int errCode, String packageName) {
        callback.onError(errCode);     // Catch: Throwable -> L4
        return;
    L4:
        e = move-exception;
        Slog.w(TAG, "Failed to callback after profile snapshot for " + packageName, e);
    }

    private void postSuccess(final String packageName, final ParcelFileDescriptor fd, final ISnapshotRuntimeProfileCallback callback) {
        if (DEBUG == false) goto L5;
        Slog.d(TAG, "Successfully snapshot profile for " + packageName);
    L5:
        this.mHandler.post(new ArtManagerService$$ExternalSyntheticLambda0(fd, callback, packageName));
    }

    private static /* synthetic */ void lambda$postSuccess$1(ParcelFileDescriptor fd, ISnapshotRuntimeProfileCallback callback, String packageName) {
    L6:
        th = move-exception;
        IoUtils.closeQuietly(fd);
        throw th;
    L8:
        e = move-exception;
        Slog.w(TAG, "Failed to call onSuccess after profile snapshot for " + packageName, e);     // Catch: Throwable -> L6
    L12:
        IoUtils.closeQuietly(fd);
        return;
    L4:
        if (fd.getFileDescriptor().valid() == false) goto L10;
        callback.onSuccess(fd);     // Catch: Throwable -> L6 Throwable -> L8
    L21:
    L10:
        Slog.wtf(TAG, "The snapshot FD became invalid before posting the result for " + packageName);     // Catch: Throwable -> L6 Throwable -> L8
        callback.onError(2);     // Catch: Throwable -> L6 Throwable -> L8
        goto L21
    }

    private static int getCompilationReasonTronValue(String compilationReason) {
        switch(compilationReason.hashCode()) {
            case -1968171580: goto L81;
            case -1836520088: goto L78;
            case -1425983632: goto L75;
            case -1291894341: goto L72;
            case -1205769507: goto L69;
            case -1125526357: goto L66;
            case -903566235: goto L63;
            case -587828592: goto L60;
            case -525717262: goto L57;
            case -207505425: goto L54;
            case 3614689: goto L51;
            case 17118443: goto L48;
            case 24665195: goto L45;
            case 94756405: goto L42;
            case 96784904: goto L39;
            case 494519556: goto L36;
            case 884802606: goto L33;
            case 900392443: goto L30;
            case 1558537393: goto L27;
            case 1756645502: goto L24;
            case 1791051557: goto L21;
            case 1956259839: goto L18;
            case 1957569947: goto L15;
            case 1988662788: goto L12;
            case 1988762958: goto L9;
            case 2005174776: goto L6;
            default: goto L83;
        };
    L83:
        byte r1 = -1;
    L84:
        switch(r1) {
            case 0: goto L115;
            case 1: goto L114;
            case 2: goto L113;
            case 3: goto L112;
            case 4: goto L111;
            case 5: goto L109;
            case 6: goto L108;
            case 7: goto L107;
            case 8: goto L106;
            case 9: goto L105;
            case 10: goto L103;
            case 11: goto L102;
            case 12: goto L101;
            case 13: goto L100;
            case 14: goto L99;
            case 15: goto L98;
            case 16: goto L97;
            case 17: goto L96;
            case 18: goto L95;
            case 19: goto L93;
            case 20: goto L91;
            case 21: goto L90;
            case 22: goto L89;
            case 23: goto L88;
            case 24: goto L87;
            case 25: goto L86;
            default: goto L85;
        };
    L85:
        return 1;
    L86:
        return 19;
    L87:
        return 18;
    L88:
        return 17;
    L89:
        return 16;
    L90:
        return 15;
    L91:
        return 9;
    L93:
        return 26;
    L95:
        return 14;
    L96:
        return 13;
    L97:
        return 12;
    L98:
        return 11;
    L99:
        return 10;
    L100:
        return 24;
    L101:
        return 23;
    L102:
        return 8;
    L103:
        return 7;
    L105:
        return 6;
    L106:
        return 5;
    L107:
        return 5;
    L108:
        return 4;
    L109:
        return 21;
    L111:
        return 25;
    L112:
        return 20;
    L113:
        return 2;
    L114:
        return 0;
    L115:
        return 22;
    L6:
        if (compilationReason.equals("install-bulk-downgraded") == false) goto L83;
        r1 = 17;
        goto L84
    L9:
        if (compilationReason.equals("install-fast") == false) goto L83;
        r1 = 14;
        goto L84
    L12:
        if (compilationReason.equals("install-bulk") == false) goto L83;
        r1 = 15;
        goto L84
    L15:
        if (compilationReason.equals("install") == false) goto L83;
        r1 = 6;
        goto L84
    L18:
        if (compilationReason.equals("post-boot") == false) goto L83;
        r1 = 5;
        goto L84
    L21:
        if (compilationReason.equals("install-bulk-secondary-downgraded-dm") == false) goto L83;
        r1 = 25;
        goto L84
    L24:
        if (compilationReason.equals("install-bulk-downgraded-dm") == false) goto L83;
        r1 = 24;
        goto L84
    L27:
        if (compilationReason.equals("install-bulk-secondary-downgraded") == false) goto L83;
        r1 = 18;
        goto L84
    L30:
        if (compilationReason.equals("install-dm") == false) goto L83;
        r1 = 20;
        goto L84
    L33:
        if (compilationReason.equals("cmdline") == false) goto L83;
        r1 = 0;
        goto L84
    L36:
        if (compilationReason.equals("cold-start-targeted") == false) goto L83;
        r1 = 8;
        goto L84
    L39:
        if (compilationReason.equals("error") == false) goto L83;
        r1 = 1;
        goto L84
    L42:
        if (compilationReason.equals("cloud") == false) goto L83;
        r1 = 19;
        goto L84
    L45:
        if (compilationReason.equals("inactive") == false) goto L83;
        r1 = 10;
        goto L84
    L48:
        if (compilationReason.equals("install-bulk-secondary") == false) goto L83;
        r1 = 16;
        goto L84
    L51:
        if (compilationReason.equals("vdex") == false) goto L83;
        r1 = 13;
        goto L84
    L54:
        if (compilationReason.equals("first-boot") == false) goto L83;
        r1 = 2;
        goto L84
    L57:
        if (compilationReason.equals("install-bulk-dm") == false) goto L83;
        r1 = 22;
        goto L84
    L60:
        if (compilationReason.equals("boot-after-ota") == false) goto L83;
        r1 = 3;
        goto L84
    L63:
        if (compilationReason.equals("shared") == false) goto L83;
        r1 = 11;
        goto L84
    L66:
        if (compilationReason.equals("install-bulk-secondary-dm") == false) goto L83;
        r1 = 23;
        goto L84
    L69:
        if (compilationReason.equals("boot-after-mainline-update") == false) goto L83;
        r1 = 4;
        goto L84
    L72:
        if (compilationReason.equals("prebuilt") == false) goto L83;
        r1 = 12;
        goto L84
    L75:
        if (compilationReason.equals("ab-ota") == false) goto L83;
        r1 = 9;
        goto L84
    L78:
        if (compilationReason.equals("install-fast-dm") == false) goto L83;
        r1 = ParameterName.BLUE_STRETCH;
        goto L84
    L81:
        if (compilationReason.equals("bg-dexopt") == false) goto L83;
        r1 = 7;
        goto L84
    }

    private static int getCompilationFilterTronValue(String compilationFilter) {
        switch(compilationFilter.hashCode()) {
            case -2111392495: goto L87;
            case -1957514039: goto L84;
            case -1803365233: goto L81;
            case -1707970841: goto L78;
            case -1704485649: goto L75;
            case -1305289599: goto L72;
            case -1129892317: goto L69;
            case -1079751646: goto L66;
            case -902315795: goto L63;
            case -819951495: goto L60;
            case -701043824: goto L57;
            case -284840886: goto L54;
            case -44924837: goto L51;
            case 50732855: goto L48;
            case 96784904: goto L45;
            case 109637894: goto L42;
            case 109641799: goto L39;
            case 256996201: goto L36;
            case 348518370: goto L33;
            case 401590963: goto L30;
            case 590454177: goto L27;
            case 658336598: goto L24;
            case 863294077: goto L21;
            case 922064507: goto L18;
            case 979981365: goto L15;
            case 1316714932: goto L12;
            case 1482618884: goto L9;
            case 1906552308: goto L6;
            default: goto L89;
        };
    L89:
        byte r1 = -1;
    L90:
        switch(r1) {
            case 0: goto L125;
            case 1: goto L124;
            case 2: goto L122;
            case 3: goto L120;
            case 4: goto L119;
            case 5: goto L118;
            case 6: goto L117;
            case 7: goto L116;
            case 8: goto L115;
            case 9: goto L114;
            case 10: goto L112;
            case 11: goto L111;
            case 12: goto L110;
            case 13: goto L109;
            case 14: goto L108;
            case 15: goto L107;
            case 16: goto L105;
            case 17: goto L103;
            case 18: goto L102;
            case 19: goto L101;
            case 20: goto L100;
            case 21: goto L98;
            case 22: goto L97;
            case 23: goto L96;
            case 24: goto L95;
            case 25: goto L94;
            case 26: goto L93;
            case 27: goto L92;
            default: goto L91;
        };
    L91:
        return 1;
    L92:
        return 27;
    L93:
        return 26;
    L94:
        return 25;
    L95:
        return 24;
    L96:
        return 23;
    L97:
        return 22;
    L98:
        return 21;
    L100:
        return 20;
    L101:
        return 19;
    L102:
        return 18;
    L103:
        return 17;
    L105:
        return 16;
    L107:
        return 15;
    L108:
        return 14;
    L109:
        return 13;
    L110:
        return 12;
    L111:
        return 11;
    L112:
        return 10;
    L114:
        return 9;
    L115:
        return 8;
    L116:
        return 7;
    L117:
        return 6;
    L118:
        return 5;
    L119:
        return 4;
    L120:
        return 3;
    L122:
        return 2;
    L124:
        return 1;
    L125:
        return 0;
    L6:
        if (compilationFilter.equals("run-from-apk-fallback") == false) goto L89;
        r1 = 13;
        goto L90
    L9:
        if (compilationFilter.equals("quicken-iorap") == false) goto L89;
        r1 = 18;
        goto L90
    L12:
        if (compilationFilter.equals("space-iorap") == false) goto L89;
        r1 = 20;
        goto L90
    L15:
        if (compilationFilter.equals("speed-iorap") == false) goto L89;
        r1 = 22;
        goto L90
    L18:
        if (compilationFilter.equals("run-from-apk") == false) goto L89;
        r1 = 12;
        goto L90
    L21:
        if (compilationFilter.equals("everything-profile-iorap") == false) goto L89;
        r1 = 23;
        goto L90
    L24:
        if (compilationFilter.equals("quicken") == false) goto L89;
        r1 = 5;
        goto L90
    L27:
        if (compilationFilter.equals("everything-iorap") == false) goto L89;
        r1 = 24;
        goto L90
    L30:
        if (compilationFilter.equals("everything") == false) goto L89;
        r1 = 11;
        goto L90
    L33:
        if (compilationFilter.equals("space-profile") == false) goto L89;
        r1 = 6;
        goto L90
    L36:
        if (compilationFilter.equals("run-from-apk-iorap") == false) goto L89;
        r1 = 25;
        goto L90
    L39:
        if (compilationFilter.equals("speed") == false) goto L89;
        r1 = 9;
        goto L90
    L42:
        if (compilationFilter.equals("space") == false) goto L89;
        r1 = 7;
        goto L90
    L45:
        if (compilationFilter.equals("error") == false) goto L89;
        r1 = 0;
        goto L90
    L48:
        if (compilationFilter.equals("assume-verified-iorap") == false) goto L89;
        r1 = 15;
        goto L90
    L51:
        if (compilationFilter.equals("run-from-vdex-fallback-iorap") == false) goto L89;
        r1 = 27;
        goto L90
    L54:
        if (compilationFilter.equals("unknown") == false) goto L89;
        r1 = 1;
        goto L90
    L57:
        if (compilationFilter.equals("space-profile-iorap") == false) goto L89;
        r1 = 19;
        goto L90
    L60:
        if (compilationFilter.equals("verify") == false) goto L89;
        r1 = 4;
        goto L90
    L63:
        if (compilationFilter.equals("run-from-vdex-fallback") == false) goto L89;
        r1 = 14;
        goto L90
    L66:
        if (compilationFilter.equals("run-from-apk-fallback-iorap") == false) goto L89;
        r1 = 26;
        goto L90
    L69:
        if (compilationFilter.equals("speed-profile") == false) goto L89;
        r1 = 8;
        goto L90
    L72:
        if (compilationFilter.equals("extract") == false) goto L89;
        r1 = 3;
        goto L90
    L75:
        if (compilationFilter.equals("extract-iorap") == false) goto L89;
        r1 = 16;
        goto L90
    L78:
        if (compilationFilter.equals("verify-iorap") == false) goto L89;
        r1 = ParameterName.DE_CONTOUR;
        goto L90
    L81:
        if (compilationFilter.equals("everything-profile") == false) goto L89;
        r1 = 10;
        goto L90
    L84:
        if (compilationFilter.equals("assume-verified") == false) goto L89;
        r1 = 2;
        goto L90
    L87:
        if (compilationFilter.equals("speed-profile-iorap") == false) goto L89;
        r1 = ParameterName.BLUE_STRETCH;
        goto L90
    }

    private static void verifyTronLoggingConstants() {
        int i = 0;
    L4:
        if (i >= PackageManagerServiceCompilerMapping.REASON_STRINGS.length) goto L13;
        String reason = PackageManagerServiceCompilerMapping.REASON_STRINGS[i];
        int value = getCompilationReasonTronValue(reason);
        if (value == 0) goto L11;
        if (value == 1) goto L11;
        i = i + 1;
    L11:
        throw new IllegalArgumentException("Compilation reason not configured for TRON logging: " + reason);
    }
}
