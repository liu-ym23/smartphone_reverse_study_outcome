package com.android.server.rollback;

import android.content.Context;
import android.content.Intent;
import android.content.IntentSender;
import android.content.pm.PackageInstaller;
import android.content.pm.PackageManager;
import android.content.pm.PackageManagerInternal;
import android.content.pm.VersionedPackage;
import android.content.rollback.PackageRollbackInfo;
import android.content.rollback.RollbackInfo;
import android.os.Binder;
import android.os.Handler;
import android.os.Looper;
import android.os.ParcelFileDescriptor;
import android.os.UserHandle;
import android.os.UserManager;
import android.os.ext.SdkExtensions;
import android.text.TextUtils;
import android.util.ArraySet;
import android.util.Slog;
import android.util.SparseIntArray;
import com.android.internal.util.ArrayUtils;
import com.android.internal.util.IndentingPrintWriter;
import com.android.internal.util.Preconditions;
import com.android.server.LocalServices;
import com.android.server.pm.pkg.AndroidPackage;
import java.io.File;
import java.io.IOException;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.text.ParseException;
import java.time.Instant;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

/* JADX INFO: loaded from: classes3.dex */
class Rollback {
    static final int ROLLBACK_STATE_AVAILABLE = 1;
    static final int ROLLBACK_STATE_COMMITTED = 3;
    static final int ROLLBACK_STATE_DELETED = 4;
    static final int ROLLBACK_STATE_ENABLING = 0;
    private static final String TAG = "RollbackManager";
    public final RollbackInfo info;
    private final File mBackupDir;
    private final SparseIntArray mExtensionVersions;
    private final Handler mHandler;
    private final String mInstallerPackageName;
    private final int mOriginalSessionId;
    private final int[] mPackageSessionIds;
    private boolean mRestoreUserDataInProgress;
    private long mRollbackLifetimeMillis;
    private int mState;
    private String mStateDescription;
    private Instant mTimestamp;
    private final int mUserId;

    @Retention(RetentionPolicy.SOURCE)
    @interface RollbackState {
    }

    public static /* synthetic */ void $r8$lambda$EV_4fww3LkkzUz86CfOhisXHCM0(Rollback r0, Intent r1, Context r2, IntentSender r3, List r4) {
        r0.lambda$commit$0(r1, r2, r3, r4);
    }

    /* JADX INFO: renamed from: $r8$lambda$W4pSxIl5T0I_NQwl-0NMTqjomsM, reason: not valid java name */
    public static /* synthetic */ void m7974$r8$lambda$W4pSxIl5T0I_NQwl0NMTqjomsM(Rollback r0, Context r1, IntentSender r2, List r3, Intent r4) {
        r0.lambda$commit$1(r1, r2, r3, r4);
    }

    Rollback(int rollbackId, File backupDir, int originalSessionId, boolean isStaged, int userId, String installerPackageName, int[] packageSessionIds, SparseIntArray extensionVersions) {
        this.mStateDescription = "";
        this.mRestoreUserDataInProgress = false;
        this.mRollbackLifetimeMillis = 0;
        this.info = new RollbackInfo(rollbackId, new ArrayList(), isStaged, new ArrayList(), -1, 0);
        this.mUserId = userId;
        this.mInstallerPackageName = installerPackageName;
        this.mBackupDir = backupDir;
        this.mOriginalSessionId = originalSessionId;
        this.mState = 0;
        this.mTimestamp = Instant.now();
        if (packageSessionIds == null) goto L5;
        int[] r0 = packageSessionIds;
    L6:
        this.mPackageSessionIds = r0;
        extensionVersions.getClass();
        this.mExtensionVersions = extensionVersions;
        if (Looper.myLooper() == null) goto L9;
        Handler r2 = new Handler(Looper.myLooper());
    L10:
        this.mHandler = r2;
        return;
    L9:
        r2 = null;
        goto L10
    L5:
        r0 = new int[0];
        goto L6
    }

    Rollback(RollbackInfo info, File backupDir, Instant timestamp, int originalSessionId, int state, String stateDescription, boolean restoreUserDataInProgress, int userId, String installerPackageName, SparseIntArray extensionVersions) {
        this.mStateDescription = "";
        this.mRestoreUserDataInProgress = false;
        this.mRollbackLifetimeMillis = 0;
        this.info = info;
        this.mUserId = userId;
        this.mInstallerPackageName = installerPackageName;
        this.mBackupDir = backupDir;
        this.mTimestamp = timestamp;
        this.mOriginalSessionId = originalSessionId;
        this.mState = state;
        this.mStateDescription = stateDescription;
        this.mRestoreUserDataInProgress = restoreUserDataInProgress;
        extensionVersions.getClass();
        this.mExtensionVersions = extensionVersions;
        this.mPackageSessionIds = new int[0];
        if (Looper.myLooper() == null) goto L5;
        Handler r0 = new Handler(Looper.myLooper());
    L6:
        this.mHandler = r0;
        return;
    L5:
        r0 = null;
        goto L6
    }

    private void assertInWorkerThread() {
        if (this.mHandler != null) goto L5;
    L8:
        boolean r0 = true;
    L9:
        Preconditions.checkState(r0);
        return;
    L5:
        if (this.mHandler.getLooper().isCurrentThread() == true) goto L8;
        r0 = false;
        goto L9
    }

    boolean isStaged() {
        return this.info.isStaged();
    }

    File getBackupDir() {
        return this.mBackupDir;
    }

    Instant getTimestamp() {
        assertInWorkerThread();
        return this.mTimestamp;
    }

    void setTimestamp(Instant timestamp) {
        assertInWorkerThread();
        this.mTimestamp = timestamp;
        RollbackStore.saveRollback(this);
    }

    void setRollbackLifetimeMillis(long lifetimeMillis) {
        assertInWorkerThread();
        this.mRollbackLifetimeMillis = lifetimeMillis;
    }

    long getRollbackLifetimeMillis() {
        assertInWorkerThread();
        return this.mRollbackLifetimeMillis;
    }

    int getOriginalSessionId() {
        return this.mOriginalSessionId;
    }

    int getUserId() {
        return this.mUserId;
    }

    String getInstallerPackageName() {
        return this.mInstallerPackageName;
    }

    SparseIntArray getExtensionVersions() {
        return this.mExtensionVersions;
    }

    boolean isEnabling() {
        assertInWorkerThread();
        if (this.mState != 0) goto L5;
        return true;
    L5:
        return false;
    }

    boolean isAvailable() {
        assertInWorkerThread();
        if (this.mState == 1) goto L7;
        return false;
    L7:
        return true;
    }

    boolean isCommitted() {
        assertInWorkerThread();
        if (this.mState != 3) goto L5;
        return true;
    L5:
        return false;
    }

    boolean isDeleted() {
        assertInWorkerThread();
        if (this.mState != 4) goto L5;
        return true;
    L5:
        return false;
    }

    void saveRollback() {
        assertInWorkerThread();
        RollbackStore.saveRollback(this);
    }

    boolean enableForPackage(String packageName, long newVersion, long installedVersion, boolean isApex, String sourceDir, String[] splitSourceDirs, int rollbackDataPolicy, int rollbackImpactLevel) {
        assertInWorkerThread();
        RollbackStore.backupPackageCodePath(this, packageName, sourceDir);     // Catch: IOException -> L9
        if (ArrayUtils.isEmpty(splitSourceDirs) == true) goto L11;
        int r0 = splitSourceDirs.length;     // Catch: IOException -> L9
        int r7 = 0;
    L6:
        if (r7 >= r0) goto L11;
        String dir = splitSourceDirs[r7];     // Catch: IOException -> L9
        RollbackStore.backupPackageCodePath(this, packageName, dir);     // Catch: IOException -> L9
        r7 = r7 + 1;
    L11:
        PackageRollbackInfo packageRollbackInfo = new PackageRollbackInfo(new VersionedPackage(packageName, newVersion), new VersionedPackage(packageName, installedVersion), new ArrayList(), new ArrayList(), isApex, false, new ArrayList(), rollbackDataPolicy);
        this.info.getPackages().add(packageRollbackInfo);
        if (this.info.getRollbackImpactLevel() >= rollbackImpactLevel) goto L21;
        this.info.setRollbackImpactLevel(rollbackImpactLevel);
        return true;
    L21:
        return true;
    L9:
        e = move-exception;
        Slog.e(TAG, "Unable to copy package for rollback for " + packageName, e);
        return false;
    }

    boolean enableForPackageInApex(String packageName, long installedVersion, int rollbackDataPolicy) {
        assertInWorkerThread();
        PackageRollbackInfo packageRollbackInfo = new PackageRollbackInfo(new VersionedPackage(packageName, 0), new VersionedPackage(packageName, installedVersion), new ArrayList(), new ArrayList(), false, true, new ArrayList(), rollbackDataPolicy);
        this.info.getPackages().add(packageRollbackInfo);
        return true;
    }

    private static void addAll(List<Integer> list, int[] arr) {
        int i = 0;
    L4:
        if (i >= arr.length) goto L7;
        list.add(Integer.valueOf(arr[i]));
        i = i + 1;
        goto L4
    }

    void snapshotUserData(String packageName, int[] userIds, AppDataRollbackHelper dataHelper) {
        assertInWorkerThread();
        if (isEnabling() == true) goto L5;
        return;
    L5:
        Iterator r0 = this.info.getPackages().iterator();
    L7:
        if (r0.hasNext() == false) goto L19;
        PackageRollbackInfo pkgRollbackInfo = (PackageRollbackInfo) r0.next();
        if (pkgRollbackInfo.getPackageName().equals(packageName) == false) goto L7;
        if (pkgRollbackInfo.getRollbackDataPolicy() != 0) goto L14;
        dataHelper.snapshotAppData(this.info.getRollbackId(), pkgRollbackInfo, userIds);
        addAll(pkgRollbackInfo.getSnapshottedUsers(), userIds);
        RollbackStore.saveRollback(this);
        return;
    L14:
        return;
    }

    void commitPendingBackupAndRestoreForUser(int userId, AppDataRollbackHelper dataHelper) {
        assertInWorkerThread();
        if (dataHelper.commitPendingBackupAndRestoreForUser(userId, this) == false) goto L6;
        RollbackStore.saveRollback(this);
        return;
    }

    void makeAvailable() {
        assertInWorkerThread();
        if (isDeleted() == false) goto L6;
        Slog.w(TAG, "Cannot make deleted rollback available.");
        return;
    L6:
        setState(1, "");
        this.mTimestamp = Instant.now();
        RollbackStore.saveRollback(this);
    }

    /* JADX WARN: Multi-variable type inference failed */
    void commit(final Context r32, final List<VersionedPackage> r33, String r34, final IntentSender r35) {
        assertInWorkerThread();
        if (isAvailable() == true) goto L6;
        RollbackManagerServiceImpl.sendFailure(r32, r35, 2, "Rollback unavailable");
        return;
    L6:
        boolean r4 = true;
        if (containsApex() == true) goto L9;
    L102:
        PackageManager r8 = r32.createPackageContextAsUser(r34, 0, UserHandle.of(this.mUserId)).getPackageManager();
        PackageInstaller r0 = r8.getPackageInstaller();     // Catch: IOException -> L19
        PackageInstaller.SessionParams r1 = new PackageInstaller.SessionParams(1);     // Catch: IOException -> L19
        r1.setRequestDowngrade(true);     // Catch: IOException -> L19
        r1.setMultiPackage();     // Catch: IOException -> L19
        if (isStaged() == false) goto L21;
        r1.setStaged();     // Catch: IOException -> L19
    L21:
        r1.setInstallReason(5);     // Catch: IOException -> L19
        int r2 = r0.createSession(r1);     // Catch: IOException -> L19
        PackageInstaller.Session r3 = r0.openSession(r2);     // Catch: IOException -> L19
        ArrayList r5 = new ArrayList(this.info.getPackages().size());     // Catch: IOException -> L19
        Iterator r15 = this.info.getPackages().iterator();     // Catch: IOException -> L19
    L23:
        if (r15.hasNext() == false) goto L106;
        PackageRollbackInfo r6 = (PackageRollbackInfo) r15.next();     // Catch: IOException -> L19
        r5.add(r6.getPackageName());     // Catch: IOException -> L19
        if (r6.isApkInApex() == true) goto L23;
        PackageInstaller.SessionParams r7 = new PackageInstaller.SessionParams(r4 ? 1 : 0);     // Catch: IOException -> L19
        String r9 = this.mInstallerPackageName;     // Catch: IOException -> L19
        if (TextUtils.isEmpty(this.mInstallerPackageName) == false) goto L30;
        String r10 = r8.getInstallerPackageName(r6.getPackageName());     // Catch: IOException -> L19
    L31:
        if (r10 == null) goto L33;
        PackageInstaller.SessionParams r11 = r7;
        r11.setInstallerPackageName(r10);     // Catch: IOException -> L19
    L34:
        r11.setRequestDowngrade(r4);     // Catch: IOException -> L19
        r11.setRequiredInstalledVersionCode(r6.getVersionRolledBackFrom().getLongVersionCode());     // Catch: IOException -> L19
        r11.setInstallReason(5);     // Catch: IOException -> L19
        if (isStaged() == false) goto L38;
        r11.setStaged();     // Catch: IOException -> L19
    L38:
        if (r6.isApex() == false) goto L40;
        r11.setInstallAsApex();     // Catch: IOException -> L19
    L40:
        int r12 = r0.createSession(r11);     // Catch: IOException -> L19
        PackageInstaller.Session r20 = r0.openSession(r12);     // Catch: IOException -> L19
        File[] r13 = RollbackStore.getPackageCodePaths(this, r6.getPackageName());     // Catch: IOException -> L19
        if (r13 == null) goto L42;
        int r14 = r13.length;     // Catch: IOException -> L19
        int r16 = 0;
    L45:
        if (r16 >= r14) goto L86;
        File r17 = r13[r16];     // Catch: IOException -> L19
        int r28 = r16;
        ParcelFileDescriptor r26 = ParcelFileDescriptor.open(r17, 268435456);     // Catch: IOException -> L19
        long r21 = Binder.clearCallingIdentity();     // Catch: Throwable -> L77
        File r27 = r17;
        PackageInstaller.Session r18 = r20;
        r18.stageViaHardLink(r17.getAbsolutePath());     // Catch: Throwable -> L53 Exception -> L55
        Object[] r19 = false;
    L62:
        if (r19 == true) goto L104;
    L110:
        Binder.restoreCallingIdentity(r21);     // Catch: Throwable -> L71
        if (r26 == null) goto L76;
        r26.close();     // Catch: IOException -> L19
    L76:
        r20 = r18;
        r16 = r28 + 1;
    L71:
        th = move-exception;
        Throwable r22 = th;
    L79:
        if (r26 == null) goto L124;
        r26.close();     // Catch: Throwable -> L82
    L125:
        throw r22;     // Catch: IOException -> L19
    L82:
        th = move-exception;
        r22.addSuppressed(th);     // Catch: IOException -> L19
        throw r22;     // Catch: IOException -> L19
    L124:
        throw r22;     // Catch: IOException -> L19
    L104:
        r18.write(r27.getName(), 0, r27.length(), r26);     // Catch: Throwable -> L67
    L67:
        th = th;
    L69:
        Binder.restoreCallingIdentity(r21);     // Catch: Throwable -> L71
        throw th;     // Catch: Throwable -> L71
    L53:
        th = th;
    L61:
        r19 = true;
        goto L62
    L57:
        th = th;
    L60:
        r27 = r17;
        r18 = r20;
    L77:
        th = move-exception;
        r22 = th;
        goto L79
    L86:
        r3.addChildSessionId(r12);     // Catch: IOException -> L19
        r4 = true;
        goto L23
    L42:
        RollbackManagerServiceImpl.sendFailure(r32, r35, 1, "Backup copy of package: " + r6.getPackageName() + " is inaccessible");     // Catch: IOException -> L19
        return;
    L33:
        r11 = r7;
        goto L34
    L30:
        r10 = r9;
        goto L31
    L106:
        LocalIntentReceiver r23 = new LocalIntentReceiver(new Rollback$$ExternalSyntheticLambda1(this, r32, r35, r33));     // Catch: IOException -> L91
        setState(3, "");     // Catch: IOException -> L91
        this.info.setCommittedSessionId(r2);     // Catch: IOException -> L91
        this.mRestoreUserDataInProgress = true;     // Catch: IOException -> L91
        r3.commit(r23.getIntentSender());     // Catch: IOException -> L91
        return;
    L91:
        e = e;
    L92:
        Slog.e(TAG, "Rollback failed", e);
        RollbackManagerServiceImpl.sendFailure(r32, r35, 1, "IOException: " + e.toString());
        return;
    L19:
        e = e;
    L95:
        RollbackManagerServiceImpl.sendFailure(r32, r35, 1, "Invalid callerPackageName");
        return;
    L9:
        if (wasCreatedAtLowerExtensionVersion() == false) goto L102;
        if (extensionVersionReductionWouldViolateConstraint(this.mExtensionVersions, (PackageManagerInternal) LocalServices.getService(PackageManagerInternal.class)) == false) goto L102;
        RollbackManagerServiceImpl.sendFailure(r32, r35, 1, "Rollback may violate a minExtensionVersion constraint");
    }

    private /* synthetic */ void lambda$commit$1(final Context context, final IntentSender statusReceiver, final List causePackages, final Intent result) {
        this.mHandler.post(new Rollback$$ExternalSyntheticLambda0(this, result, context, statusReceiver, causePackages));
    }

    private /* synthetic */ void lambda$commit$0(Intent result, Context context, IntentSender statusReceiver, List causePackages) {
        assertInWorkerThread();
        int status = result.getIntExtra("android.content.pm.extra.STATUS", 1);
        if (status == 0) goto L7;
        setState(1, "Commit failed");
        this.mRestoreUserDataInProgress = false;
        this.info.setCommittedSessionId(-1);
        RollbackManagerServiceImpl.sendFailure(context, statusReceiver, 3, "Rollback downgrade install failed: " + result.getStringExtra("android.content.pm.extra.STATUS_MESSAGE"));
        return;
    L7:
        if (isStaged() == true) goto L9;
        this.mRestoreUserDataInProgress = false;
    L9:
        this.info.getCausePackages().addAll(causePackages);
        RollbackStore.deletePackageCodePaths(this);
        RollbackStore.saveRollback(this);
        Intent fillIn = new Intent();     // Catch: IntentSender.SendIntentException -> L16
        fillIn.putExtra("android.content.rollback.extra.STATUS", 0);     // Catch: IntentSender.SendIntentException -> L16
        Context context2 = context;
        statusReceiver.sendIntent(context2, 0, fillIn, null, null);     // Catch: IntentSender.SendIntentException -> L14
    L18:
        Intent broadcast = new Intent("android.intent.action.ROLLBACK_COMMITTED");
        UserManager userManager = (UserManager) context2.getSystemService(UserManager.class);
        Iterator r0 = userManager.getUserHandles(true).iterator();
    L20:
        if (r0.hasNext() == false) goto L22;
        UserHandle user = (UserHandle) r0.next();
        context2.sendBroadcastAsUser(broadcast, user, "android.permission.MANAGE_ROLLBACKS");
        goto L20
    L22:
        return;
    L17:
        context2 = context;
        goto L18
    }

    boolean restoreUserDataForPackageIfInProgress(String packageName, int[] userIds, int appId, String seInfo, AppDataRollbackHelper dataHelper) {
        assertInWorkerThread();
        int r1 = 0;
        if (isRestoreUserDataInProgress() == true) goto L5;
        return false;
    L5:
        boolean foundPackage = false;
        Iterator r2 = this.info.getPackages().iterator();
    L7:
        if (r2.hasNext() == false) goto L18;
        PackageRollbackInfo pkgRollbackInfo = (PackageRollbackInfo) r2.next();
        if (pkgRollbackInfo.getPackageName().equals(packageName) == false) goto L7;
        foundPackage = true;
        boolean changedRollback = false;
        int r3 = userIds.length;
    L11:
        if (r1 >= r3) goto L14;
        int userId = userIds[r1];
        int appId2 = appId;
        changedRollback = changedRollback | dataHelper.restoreAppData(this.info.getRollbackId(), pkgRollbackInfo, userId, appId2, seInfo);
        r1 = r1 + 1;
        appId = appId2;
        goto L11
    L14:
        if (changedRollback == false) goto L18;
        RollbackStore.saveRollback(this);
    L18:
        return foundPackage;
    }

    void delete(AppDataRollbackHelper dataHelper, String reason) {
        assertInWorkerThread();
        boolean containsApex = false;
        Set<Integer> apexUsers = new ArraySet();
        Iterator r2 = this.info.getPackages().iterator();
    L4:
        if (r2.hasNext() == false) goto L13;
        PackageRollbackInfo pkgInfo = (PackageRollbackInfo) r2.next();
        List<Integer> snapshottedUsers = pkgInfo.getSnapshottedUsers();
        if (pkgInfo.isApex() == true) goto L7;
        int i = 0;
    L10:
        if (i >= snapshottedUsers.size()) goto L4;
        int userId = snapshottedUsers.get(i).intValue();
        dataHelper.destroyAppDataSnapshot(this.info.getRollbackId(), pkgInfo, userId);
        i = i + 1;
        goto L10
    L7:
        containsApex = true;
        apexUsers.addAll(snapshottedUsers);
        goto L4
    L13:
        if (containsApex == false) goto L18;
        dataHelper.destroyApexDeSnapshots(this.info.getRollbackId());
        Iterator<Integer> r3 = apexUsers.iterator();
    L16:
        if (r3.hasNext() == false) goto L18;
        int user = r3.next().intValue();
        dataHelper.destroyApexCeSnapshots(user, this.info.getRollbackId());
    L18:
        RollbackStore.deleteRollback(this);
        setState(4, reason);
    }

    boolean isRestoreUserDataInProgress() {
        assertInWorkerThread();
        return this.mRestoreUserDataInProgress;
    }

    void setRestoreUserDataInProgress(boolean restoreUserDataInProgress) {
        assertInWorkerThread();
        this.mRestoreUserDataInProgress = restoreUserDataInProgress;
        RollbackStore.saveRollback(this);
    }

    boolean includesPackage(String packageName) {
        assertInWorkerThread();
        Iterator r0 = this.info.getPackages().iterator();
    L4:
        if (r0.hasNext() == false) goto L10;
        PackageRollbackInfo packageRollbackInfo = (PackageRollbackInfo) r0.next();
        if (packageRollbackInfo.getPackageName().equals(packageName) == false) goto L4;
        return true;
    L10:
        return false;
    }

    boolean includesPackageWithDifferentVersion(String packageName, long versionCode) {
        assertInWorkerThread();
        Iterator r0 = this.info.getPackages().iterator();
    L4:
        if (r0.hasNext() == false) goto L12;
        PackageRollbackInfo pkgRollbackInfo = (PackageRollbackInfo) r0.next();
        if (pkgRollbackInfo.getPackageName().equals(packageName) == false) goto L4;
        if (pkgRollbackInfo.getVersionRolledBackFrom().getLongVersionCode() == versionCode) goto L4;
        return true;
    L12:
        return false;
    }

    List<String> getPackageNames() {
        assertInWorkerThread();
        List<String> result = new ArrayList();
        Iterator r1 = this.info.getPackages().iterator();
    L4:
        if (r1.hasNext() == false) goto L6;
        PackageRollbackInfo pkgRollbackInfo = (PackageRollbackInfo) r1.next();
        result.add(pkgRollbackInfo.getPackageName());
        goto L4
    L6:
        return result;
    }

    List<String> getApexPackageNames() {
        assertInWorkerThread();
        List<String> result = new ArrayList();
        Iterator r1 = this.info.getPackages().iterator();
    L4:
        if (r1.hasNext() == false) goto L9;
        PackageRollbackInfo pkgRollbackInfo = (PackageRollbackInfo) r1.next();
        if (pkgRollbackInfo.isApex() == false) goto L4;
        result.add(pkgRollbackInfo.getPackageName());
        goto L4
    L9:
        return result;
    }

    boolean containsSessionId(int packageSessionId) {
        int[] r0 = this.mPackageSessionIds;
        int r1 = r0.length;
        int r3 = 0;
    L3:
        if (r3 >= r1) goto L9;
        int id = r0[r3];
        if (id == packageSessionId) goto L6;
        r3 = r3 + 1;
        goto L3
    L6:
        return true;
    L9:
        return false;
    }

    boolean allPackagesEnabled() {
        assertInWorkerThread();
        int packagesWithoutApkInApex = 0;
        Iterator r1 = this.info.getPackages().iterator();
    L4:
        if (r1.hasNext() == false) goto L10;
        PackageRollbackInfo rollbackInfo = (PackageRollbackInfo) r1.next();
        if (rollbackInfo.isApkInApex() == true) goto L4;
        packagesWithoutApkInApex = packagesWithoutApkInApex + 1;
        goto L4
    L10:
        if (packagesWithoutApkInApex != this.mPackageSessionIds.length) goto L12;
        return true;
    L12:
        return false;
    }

    static String rollbackStateToString(int state) {
        switch(state) {
            case 0: goto L11;
            case 1: goto L9;
            case 2: goto L4;
            case 3: goto L7;
            case 4: goto L5;
            default: goto L4;
        };
    L5:
        return "deleted";
    L7:
        return "committed";
    L9:
        return "available";
    L11:
        return "enabling";
    L4:
        throw new AssertionError("Invalid rollback state: " + state);
    }

    static int rollbackStateFromString(String state) throws ParseException {
        switch(state.hashCode()) {
            case -1491142788: goto L15;
            case -733902135: goto L12;
            case 1550463001: goto L9;
            case 1642196352: goto L6;
            default: goto L17;
        };
    L17:
        byte r0 = -1;
    L18:
        switch(r0) {
            case 0: goto L25;
            case 1: goto L24;
            case 2: goto L23;
            case 3: goto L21;
            default: goto L20;
        };
    L21:
        return 4;
    L23:
        return 3;
    L24:
        return 1;
    L25:
        return 0;
    L20:
        throw new ParseException("Invalid rollback state: " + state, 0);
    L6:
        if (state.equals("enabling") == false) goto L17;
        r0 = 0;
        goto L18
    L9:
        if (state.equals("deleted") == false) goto L17;
        r0 = 3;
        goto L18
    L12:
        if (state.equals("available") == false) goto L17;
        r0 = 1;
        goto L18
    L15:
        if (state.equals("committed") == false) goto L17;
        r0 = 2;
        goto L18
    }

    String getStateAsString() {
        assertInWorkerThread();
        return rollbackStateToString(this.mState);
    }

    static boolean extensionVersionReductionWouldViolateConstraint(SparseIntArray rollbackExtVers, PackageManagerInternal pmi) {
        if (rollbackExtVers.size() != 0) goto L5;
        return false;
    L5:
        List<String> packages = pmi.getPackageList().getPackageNames();
        int i = 0;
    L7:
        if (i >= packages.size()) goto L21;
        AndroidPackage pkg = pmi.getPackage(packages.get(i));
        SparseIntArray minExtVers = pkg.getMinExtensionVersions();
        if (minExtVers == null) goto L19;
        int j = 0;
    L13:
        if (j >= rollbackExtVers.size()) goto L19;
        int minExt = minExtVers.get(rollbackExtVers.keyAt(j), -1);
        if (rollbackExtVers.valueAt(j) < minExt) goto L16;
        j = j + 1;
        goto L13
    L16:
        return true;
    L19:
        i = i + 1;
        goto L7
    L21:
        return false;
    }

    private boolean wasCreatedAtLowerExtensionVersion() {
        int i = 0;
    L4:
        if (i >= this.mExtensionVersions.size()) goto L10;
        if (SdkExtensions.getExtensionVersion(this.mExtensionVersions.keyAt(i)) > this.mExtensionVersions.valueAt(i)) goto L7;
        i = i + 1;
        goto L4
    L7:
        return true;
    L10:
        return false;
    }

    private boolean containsApex() {
        Iterator r0 = this.info.getPackages().iterator();
    L4:
        if (r0.hasNext() == false) goto L10;
        PackageRollbackInfo pkgInfo = (PackageRollbackInfo) r0.next();
        if (pkgInfo.isApex() == false) goto L4;
        return true;
    L10:
        return false;
    }

    void dump(IndentingPrintWriter ipw) {
        assertInWorkerThread();
        ipw.println(this.info.getRollbackId() + ":");
        ipw.increaseIndent();
        ipw.println("-state: " + getStateAsString());
        ipw.println("-stateDescription: " + this.mStateDescription);
        ipw.println("-timestamp: " + getTimestamp());
        ipw.println("-rollbackLifetimeMillis: " + getRollbackLifetimeMillis());
        ipw.println("-rollbackImpactLevel: " + this.info.getRollbackImpactLevel());
        ipw.println("-isStaged: " + isStaged());
        ipw.println("-originalSessionId: " + getOriginalSessionId());
        ipw.println("-packages:");
        ipw.increaseIndent();
        Iterator r0 = this.info.getPackages().iterator();
    L4:
        if (r0.hasNext() == false) goto L6;
        PackageRollbackInfo pkg = (PackageRollbackInfo) r0.next();
        ipw.println(pkg.getPackageName() + " " + pkg.getVersionRolledBackFrom().getLongVersionCode() + " -> " + pkg.getVersionRolledBackTo().getLongVersionCode() + " [" + pkg.getRollbackDataPolicy() + "]");
        goto L4
    L6:
        ipw.decreaseIndent();
        if (isCommitted() == false) goto L14;
        ipw.println("-causePackages:");
        ipw.increaseIndent();
        Iterator r1 = this.info.getCausePackages().iterator();
    L10:
        if (r1.hasNext() == false) goto L12;
        VersionedPackage cPkg = (VersionedPackage) r1.next();
        ipw.println(cPkg.getPackageName() + " " + cPkg.getLongVersionCode());
        goto L10
    L12:
        ipw.decreaseIndent();
        ipw.println("-committedSessionId: " + this.info.getCommittedSessionId());
    L14:
        if (this.mExtensionVersions.size() <= 0) goto L16;
        ipw.println("-extensionVersions:");
        ipw.increaseIndent();
        ipw.println(this.mExtensionVersions.toString());
        ipw.decreaseIndent();
    L16:
        ipw.decreaseIndent();
    }

    String getStateDescription() {
        assertInWorkerThread();
        return this.mStateDescription;
    }

    void setState(int state, String description) {
        assertInWorkerThread();
        this.mState = state;
        this.mStateDescription = description;
    }
}
