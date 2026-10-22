package com.android.server.pm;

import android.app.ApplicationPackageManager;
import android.app.doppelganger.DoppelgangerManager;
import android.content.Intent;
import android.content.pm.IPackageDeleteObserver2;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.SharedLibraryInfo;
import android.content.pm.Signature;
import android.content.pm.UserInfo;
import android.content.pm.UserProperties;
import android.content.pm.VersionedPackage;
import android.net.Uri;
import android.os.Binder;
import android.os.Bundle;
import android.os.RemoteException;
import android.os.SystemProperties;
import android.os.UserHandle;
import android.pico.utils.ExtImplFactory;
import android.text.TextUtils;
import android.util.ArraySet;
import android.util.BoostFramework;
import android.util.EventLog;
import android.util.Log;
import android.util.Pair;
import android.util.Slog;
import android.util.SparseArray;
import android.util.SparseBooleanArray;
import com.android.internal.pm.parsing.pkg.AndroidPackageInternal;
import com.android.internal.util.ArrayUtils;
import com.android.internal.util.Preconditions;
import com.android.server.pm.pkg.AndroidPackage;
import com.android.server.pm.pkg.ArchiveState;
import com.android.server.pm.pkg.PackageStateInternal;
import com.android.server.pm.pkg.PackageUserStateInternal;
import com.android.server.wm.ActivityTaskManagerInternal;
import com.zte.performance.mindsync.MindSyncManager;
import dalvik.system.VMRuntime;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
final class DeletePackageHelper {
    private static final boolean DEBUG_CLEAN_APKS = false;
    private static final boolean DEBUG_SD_INSTALL = false;
    private final BroadcastHelper mBroadcastHelper;
    private final IExtDeletePackageHelper mExt;
    private final PackageManagerService mPm;
    private final RemovePackageHelper mRemovePackageHelper;
    private final UserManagerInternal mUserManagerInternal;

    private static class TempUserState {
        public final int enabledState;
        public final boolean installed;
        public final String lastDisableAppCaller;

        /* synthetic */ TempUserState(int r1, String r2, boolean r3, DeletePackageHelperIA r4) {
            this(r1, r2, r3);
        }

        private TempUserState(int enabledState, String lastDisableAppCaller, boolean installed) {
            this.enabledState = enabledState;
            this.lastDisableAppCaller = lastDisableAppCaller;
            this.installed = installed;
        }
    }

    /* JADX INFO: renamed from: $r8$lambda$-oeUp2P8o8iDLUc_n3ggTncXCE8, reason: not valid java name */
    public static /* synthetic */ void m6629$r8$lambda$oeUp2P8o8iDLUc_n3ggTncXCE8(String r0, IPackageDeleteObserver2 r1, int r2) {
        lambda$deletePackageVersionedInternal$0(r0, r1, r2);
    }

    public static /* synthetic */ void $r8$lambda$B3H6ZiauPhFtwkYPwrr4doywBxU(DeletePackageHelper r0, String r1, int r2, boolean r3, boolean r4, long r5, int r7, int r8, int[] r9, IPackageDeleteObserver2 r10, String r11) {
        r0.lambda$deletePackageVersionedInternal$6(r1, r2, r3, r4, r5, r7, r8, r9, r10, r11);
    }

    public static /* synthetic */ void $r8$lambda$G3cruqtpCcQygfkEvDmcojwrheo(IPackageDeleteObserver2 r0, String r1) {
        lambda$deletePackageVersionedInternal$5(r0, r1);
    }

    public static /* synthetic */ void $r8$lambda$OmU3_QuZgW_Cze1CVHdRM6F2mcY(IPackageDeleteObserver2 r0, String r1) {
        lambda$deletePackageVersionedInternal$4(r0, r1);
    }

    public static /* synthetic */ void $r8$lambda$RQQgPNIc9pnksz9sGvFB4kTgrj8(String r0, IPackageDeleteObserver2 r1) {
        lambda$deletePackageVersionedInternal$2(r0, r1);
    }

    public static /* synthetic */ void $r8$lambda$RyGjxnAmVI6hOWbZUp4LdSS4Ml0(IPackageDeleteObserver2 r0, String r1) {
        lambda$deletePackageVersionedInternal$1(r0, r1);
    }

    /* JADX INFO: renamed from: $r8$lambda$b82gN-33vUEE8d86YmpiQ3c5GEc, reason: not valid java name */
    public static /* synthetic */ void m6630$r8$lambda$b82gN33vUEE8d86YmpiQ3c5GEc(String r0, IPackageDeleteObserver2 r1) {
        lambda$deletePackageVersionedInternal$3(r0, r1);
    }

    public static /* synthetic */ void $r8$lambda$hcYxn1rgX0BdkldADTpPsGUNP8A(DeletePackageHelper r0, String r1, int r2) {
        r0.lambda$removeUnusedPackagesLPw$7(r1, r2);
    }

    DeletePackageHelper(PackageManagerService pm, RemovePackageHelper removePackageHelper, BroadcastHelper broadcastHelper) {
        this.mExt = (IExtDeletePackageHelper) ExtImplFactory.getImpl(IExtDeletePackageHelper.class, new Object[]{this});
        this.mPm = pm;
        this.mUserManagerInternal = this.mPm.mInjector.getUserManagerInternal();
        this.mRemovePackageHelper = removePackageHelper;
        this.mBroadcastHelper = broadcastHelper;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r22v6 */
    /* JADX WARN: Type inference failed for: r7v22 */
    /* JADX WARN: Type inference failed for: r7v23 */
    /* JADX WARN: Type inference failed for: r7v34 */
    /* JADX WARN: Unreachable blocks removed: 2, instructions: 12 */
    public int deletePackageX(String r29, long r30, int r32, int r33, boolean r34) {
        PackageRemovedInfo r8 = new PackageRemovedInfo();
        if ((r33 & 2) == 0) goto L5;
        int r0 = -1;
    L6:
        int r13 = r0;
        PackageManagerTracedLock r3 = this.mPm.mLock;
        PackageManagerService.boostPriorityForPackageManagerTracedLockedSection();
        monitor-enter(r3);
        Computer r1 = this.mPm.snapshotComputer();     // Catch: Throwable -> L345
        PackageSetting r2 = this.mPm.mSettings.getPackageLPr(r29);     // Catch: Throwable -> L345
        if (r2 != null) goto L19;
        Slog.w(PackageManagerServiceMonitorEx.TAG, "Not removing non-existent package " + r29);     // Catch: Throwable -> L15
        monitor-exit(r3);     // Catch: Throwable -> L15
        PackageManagerService.resetPriorityAfterPackageManagerTracedLockedSection();
        return -1;
    L19:
        if (r30 == (-1)) goto L27;
        if (r2.getVersionCode() == r30) goto L27;
        Slog.w(PackageManagerServiceMonitorEx.TAG, "Not removing package " + r29 + " with versionCode " + r2.getVersionCode() + " != " + r30);     // Catch: Throwable -> L15
        monitor-exit(r3);     // Catch: Throwable -> L15
        PackageManagerService.resetPriorityAfterPackageManagerTracedLockedSection();
        return -1;
    L27:
        if (PackageManagerServiceUtils.isUpdatedSystemApp(r2) == true) goto L29;
    L40:
        PackageSetting r4 = this.mPm.mSettings.getDisabledSystemPkgLPr(r29);     // Catch: Throwable -> L345
        AndroidPackage r5 = this.mPm.mPackages.get(r29);     // Catch: Throwable -> L345
        int[] r6 = this.mUserManagerInternal.getUserIds();     // Catch: Throwable -> L345
        if (r5 != null) goto L391;
        AndroidPackage r19 = r5;
        int r23 = r13;
        boolean r21 = false;
    L406:
        r8.mOrigUsers = r2.queryInstalledUsers(r6, true);     // Catch: Throwable -> L343
        if (PackageManagerServiceUtils.isUpdatedSystemApp(r2) == true) goto L117;
    L131:
        PackageRemovedInfo r18 = r8;
        AndroidPackageInternal r9 = null;
        SparseArray r10 = null;
        int r7 = r23;
    L397:
        boolean r11 = this.mPm.mSettings.isInstallerPackage(r29);     // Catch: Throwable -> L341
        monitor-exit(r3);     // Catch: Throwable -> L341
        PackageManagerService.resetPriorityAfterPackageManagerTracedLockedSection();
        PackageManagerTracedLock r14 = this.mPm.mInstallLock.acquireLock();
        Slog.d(PackageManagerServiceMonitorEx.TAG, "deletePackageX: pkg=" + r29 + " user=" + r32);     // Catch: Throwable -> L333
        int r15 = r23;
        PackageFreezer r12 = this.mPm.freezePackageForDelete(r29, r7, r33, "deletePackageX", 13);     // Catch: Throwable -> L326
        AndroidPackageInternal r16 = r9;
        PackageRemovedInfo r17 = r18;
        AndroidPackage r110 = r19;
        boolean r20 = deletePackageLIF(r29, UserHandle.of(r15), true, r6, r33 | Integer.MIN_VALUE, r17, true);     // Catch: Throwable -> L315
        PackageRemovedInfo r22 = r17;
        if (r12 != null) goto L376;
    L151:
        if (r20 == false) goto L401;
        if (r110 == null) goto L401;
        PackageManagerTracedLock r24 = this.mPm.mLock;     // Catch: Throwable -> L149
        PackageManagerService.boostPriorityForPackageManagerTracedLockedSection();     // Catch: Throwable -> L149
        monitor-enter(r24);     // Catch: Throwable -> L149
    L162:
        th = move-exception;
        PackageManagerService.resetPriorityAfterPackageManagerTracedLockedSection();     // Catch: Throwable -> L149
        throw th;     // Catch: Throwable -> L149
    L149:
        th = move-exception;
        Throwable r25 = th;
    L335:
        if (r14 == null) goto L444;
        r14.close();     // Catch: Throwable -> L338
        throw r25;
    L338:
        th = move-exception;
        r25.addSuppressed(th);
        throw r25;
    L444:
        throw r25;
    L156:
        if (this.mPm.mPackages.get(r110.getPackageName()) == null) goto L158;
        boolean r26 = true;
    L159:
        monitor-exit(r24);     // Catch: Throwable -> L162
        PackageManagerService.resetPriorityAfterPackageManagerTracedLockedSection();     // Catch: Throwable -> L149
        this.mPm.mInstantAppRegistry.onPackageUninstalled(r110, r2, r22.mRemovedUsers, r26);     // Catch: Throwable -> L149
        goto L401
    L158:
        r26 = r21;
    L401:
        PackageManagerTracedLock r27 = this.mPm.mLock;     // Catch: Throwable -> L304
        PackageManagerService.boostPriorityForPackageManagerTracedLockedSection();     // Catch: Throwable -> L304
        monitor-enter(r27);     // Catch: Throwable -> L304
        if (r20 == false) goto L404;
        this.mPm.updateSequenceNumberLP(r2, r22.mRemovedUsers);     // Catch: Throwable -> L171
        this.mPm.updateInstantAppInstallerLocked(r29);     // Catch: Throwable -> L171
    L171:
        th = th;
    L413:
        monitor-exit(r27);     // Catch: Throwable -> L313
        PackageManagerService.resetPriorityAfterPackageManagerTracedLockedSection();     // Catch: Throwable -> L311
        throw th;     // Catch: Throwable -> L311
    L313:
        th = th;
    L404:
        monitor-exit(r27);     // Catch: Throwable -> L306
        PackageManagerService.resetPriorityAfterPackageManagerTracedLockedSection();     // Catch: Throwable -> L304
        ApplicationPackageManager.invalidateGetPackagesForUidCache();     // Catch: Throwable -> L304
        if (r14 == null) goto L177;
        r14.close();
    L177:
        if (r20 == false) goto L188;
        this.mExt.clearTaskPersistData(r29, r22.mIsUpdate, r22.mRemovedUsers, r22.mUid);
        if ((r33 & 8) != 0) goto L181;
        boolean r28 = true;
    L183:
        if ((r33 & 16) == 0) goto L185;
        boolean r31 = true;
    L186:
        this.mBroadcastHelper.sendPackageRemovedBroadcasts(r22, this.mPm, r28, r34, r31);
        this.mBroadcastHelper.sendSystemPackageUpdatedBroadcasts(r22);
        PackageMetrics.onUninstallSucceeded(r22, r33, r15);
        goto L188
    L185:
        r31 = r21;
        goto L186
    L181:
        r28 = r21;
    L188:
        VMRuntime.getRuntime().requestConcurrentGC();
        PackageManagerTracedLock r35 = this.mPm.mInstallLock.acquireLock();
    L252:
        th = move-exception;
        PackageManagerTracedLock r210 = r35;
        Throwable r36 = th;
    L298:
        if (r210 == null) goto L440;
        r210.close();     // Catch: Throwable -> L301
        throw r36;
    L301:
        th = move-exception;
        r36.addSuppressed(th);
        throw r36;
    L440:
        throw r36;
    L190:
        if (r22.mArgs != null) goto L374;
    L195:
        boolean r37 = false;
        if (r10 == null) goto L254;
        PackageManagerTracedLock r38 = this.mPm.mLock;     // Catch: Throwable -> L252
        PackageManagerService.boostPriorityForPackageManagerTracedLockedSection();     // Catch: Throwable -> L252
        monitor-enter(r38);     // Catch: Throwable -> L252
        PackageSetting r39 = this.mPm.getPackageSettingForMutation(r29);     // Catch: Throwable -> L238
        if (r39 == null) goto L240;
        AndroidPackageInternal r40 = r39.getPkg();     // Catch: Throwable -> L238
        if (r40 != null) goto L419;
    L208:
        boolean r211 = r21;
    L209:
        int r111 = 0;
    L210:
        PackageRemovedInfo r212 = r22;
    L235:
        th = th;
    L249:
        monitor-exit(r38);     // Catch: Throwable -> L248
        PackageManagerService.resetPriorityAfterPackageManagerTracedLockedSection();     // Catch: Throwable -> L246
        throw th;     // Catch: Throwable -> L246
    L212:
        if (r111 >= r6.length) goto L237;
        TempUserState r41 = (TempUserState) r10.get(r6[r111]);     // Catch: Throwable -> L235
        PackageManagerTracedLock r213 = r35;
        int r42 = r41.enabledState;     // Catch: Throwable -> L233
        boolean r214 = r37;
        AndroidPackageInternal r215 = r40;
        r39.setEnabled(r42, r6[r111], r41.lastDisableAppCaller);     // Catch: Throwable -> L229
        if (r214 == true) goto L231;
        if (r41.installed == false) goto L231;
        if (r42 != 0) goto L226;
        if (r211 == false) goto L226;
    L227:
        r37 = true;
    L232:
        r111 = r111 + 1;
        r22 = r212;
        r35 = r213;
        r40 = r215;
    L226:
        if (r42 == 1) goto L227;
    L231:
        r37 = r214;
    L229:
        th = th;
    L233:
        th = th;
        goto L249
    L237:
        r210 = r35;
        int r43 = 1;
    L242:
        this.mPm.mSettings.writeAllUsersPackageRestrictionsLPr();     // Catch: Throwable -> L248
        monitor-exit(r38);     // Catch: Throwable -> L248
        PackageManagerService.resetPriorityAfterPackageManagerTracedLockedSection();     // Catch: Throwable -> L246
    L255:
        if (r4 != null) goto L257;
        AndroidPackageInternal r44 = r16;
    L258:
        AndroidPackageInternal r45 = r44;
        if (r45 != null) goto L261;
    L281:
        if (r210 == null) goto L283;
        r210.close();
    L283:
        if (r20 == false) goto L286;
        if (r11 == false) goto L286;
        this.mPm.mInjector.getPackageInstallerService().onInstallerPackageDeleted(r2.getAppId(), r15);
    L286:
        if (r20 == false) goto L294;
        if (r29 == null) goto L294;
        BoostFramework r46 = new BoostFramework();
        if (r46.board_first_api_lvl < 33) goto L291;
    L293:
        r46.perfEvent(4260, r29, 2, new int[]{r32, 0});
        goto L294
    L291:
        if (r46.board_api_lvl >= 33) goto L293;
        r46.perfUXEngine_events(7, 0, r29, r32);
    L294:
        if (r20 == true) goto L439;
        return -1;
    L439:
        return r43;
    L261:
        if (r45.isStub() == false) goto L281;
        PackageManagerTracedLock r47 = this.mPm.mLock;     // Catch: Throwable -> L246
        PackageManagerService.boostPriorityForPackageManagerTracedLockedSection();     // Catch: Throwable -> L246
        monitor-enter(r47);     // Catch: Throwable -> L246
        PackageSetting r48 = this.mPm.mSettings.getPackageLPr(r45.getPackageName());     // Catch: Throwable -> L277
        monitor-exit(r47);     // Catch: Throwable -> L277
        PackageManagerService.resetPriorityAfterPackageManagerTracedLockedSection();     // Catch: Throwable -> L246
        if (r48 == null) goto L281;
        if (r37 == false) goto L274;
        if (PackageManagerService.DEBUG_COMPRESSION == false) goto L272;
        Slog.i(PackageManagerServiceMonitorEx.TAG, "Enabling system stub after removal; pkg: " + r45.getPackageName());     // Catch: Throwable -> L246
    L272:
        this.mPm.enableCompressedPackage(r45, r48);     // Catch: Throwable -> L246
        goto L281
    L274:
        if (PackageManagerService.DEBUG_COMPRESSION == false) goto L281;
        Slog.i(PackageManagerServiceMonitorEx.TAG, "System stub disabled for all users, leaving uncompressed after removal; pkg: " + r45.getPackageName());     // Catch: Throwable -> L246
        goto L281
    L277:
        th = move-exception;
        PackageManagerService.resetPriorityAfterPackageManagerTracedLockedSection();     // Catch: Throwable -> L246
        throw th;     // Catch: Throwable -> L246
    L257:
        r44 = r4.getPkg();     // Catch: Throwable -> L246
        goto L258
    L419:
        if (r40.isEnabled() == false) goto L208;
        r211 = true;
    L206:
        th = th;
        goto L249
    L240:
        r210 = r35;
        r43 = 1;
        Slog.w(PackageManagerServiceMonitorEx.TAG, "Missing PackageSetting after uninstalling the update for system app: " + r29 + ". This should not happen.");     // Catch: Throwable -> L248
    L238:
        th = th;
    L248:
        th = th;
        goto L249
    L254:
        r210 = r35;
        r43 = 1;
    L246:
        th = move-exception;
        r36 = th;
        goto L298
    L374:
        this.mRemovePackageHelper.cleanUpResources(r22.mArgs.getPackageName(), r22.mArgs.getCodeFile(), r22.mArgs.getInstructionSets());     // Catch: Throwable -> L193
    L193:
        th = move-exception;
        r210 = r35;
        r36 = th;
    L306:
        th = th;
    L304:
        th = move-exception;
        r25 = th;
        goto L335
    L376:
        r12.close();     // Catch: Throwable -> L149
    L315:
        th = move-exception;
        Throwable r49 = th;
    L319:
        if (r12 == null) goto L442;
        r12.close();     // Catch: Throwable -> L322
    L443:
        throw r49;     // Catch: Throwable -> L311
    L322:
        th = move-exception;
        r49.addSuppressed(th);     // Catch: Throwable -> L311
        throw r49;     // Catch: Throwable -> L311
    L442:
        throw r49;     // Catch: Throwable -> L311
    L317:
        th = move-exception;
        r49 = th;
    L311:
        th = move-exception;
        r25 = th;
    L326:
        th = move-exception;
        r25 = th;
    L330:
        th = th;
    L332:
        r25 = th;
    L333:
        th = th;
    L341:
        th = th;
    L362:
        monitor-exit(r3);     // Catch: Throwable -> L350
        PackageManagerService.resetPriorityAfterPackageManagerTracedLockedSection();
        throw th;
    L350:
        th = th;
        goto L362
    L117:
        if ((r33 & 4) != 0) goto L131;
        SparseArray r50 = new SparseArray();     // Catch: Throwable -> L128
        int r51 = 0;
    L121:
        if (r51 >= r6.length) goto L130;
        PackageUserStateInternal r52 = r2.readUserState(r6[r51]);     // Catch: Throwable -> L128
        PackageRemovedInfo r112 = r8;
        r50.put(r6[r51], new TempUserState(r52.getEnabledState(), r52.getLastDisableAppCaller(), r52.isInstalled(), null));     // Catch: Throwable -> L126
        r51 = r51 + 1;
        r8 = r112;
    L126:
        th = th;
        goto L362
    L130:
        r18 = r8;
        r9 = null;
        r10 = r50;
        r7 = -1;
    L128:
        th = th;
    L343:
        th = th;
        goto L362
    L391:
    L110:
        th = th;
        goto L362
    L45:
        if (r5.getStaticSharedLibraryName() != null) goto L360;
        r21 = false;
        if (r5.getSdkLibraryName() != null) goto L408;
        int r216 = r13;
        SharedLibraryInfo r113 = null;
    L62:
        if (r113 == null) goto L109;
        boolean r53 = r21;
        int r54 = r6.length;     // Catch: Throwable -> L106
        ?? r55 = r21;
    L65:
        if (r55 >= r54) goto L108;
        int r114 = r6[r55];     // Catch: Throwable -> L106
        int r115 = r216;
        ?? r217 = r55;
        if (r115 == (-1)) goto L368;
        if (r115 == r114) goto L368;
        boolean r116 = r53;
        AndroidPackage r117 = r5;
        int r218 = r115;
    L105:
        int r56 = (r217 == true ? 1 : 0) + 1;
        r53 = r116;
        r54 = r54;
        r5 = r117;
        r216 = r218;
        r55 = r56;
    L368:
        Pair<List<VersionedPackage>, List<Boolean>> r118 = r1.getPackagesUsingSharedLibrary(r113, 4202496, 1000, r114);     // Catch: Throwable -> L92
        r116 = r53;
        List r57 = (List) r118.first;     // Catch: Throwable -> L92
        List r58 = (List) r118.second;     // Catch: Throwable -> L92
        boolean r119 = false;
        if (r5.getSdkLibraryName() != null) goto L75;
        r117 = r5;
        r218 = r115;
    L98:
        if (ArrayUtils.isEmpty(r57) == true) goto L105;
        if (r119 == true) goto L105;
        Slog.w(PackageManagerServiceMonitorEx.TAG, "Not removing package " + r117.getManifestPackageName() + " hosting lib " + r113.getName() + " version " + r113.getLongVersion() + " used by " + r57 + " for user " + r114);     // Catch: Throwable -> L90
        monitor-exit(r3);     // Catch: Throwable -> L90
        PackageManagerService.resetPriorityAfterPackageManagerTracedLockedSection();
        return -6;
    L90:
        th = th;
        goto L362
    L75:
        if (ArrayUtils.isEmpty(r57) == false) goto L77;
        r117 = r5;
        r218 = r115;
        goto L98
    L77:
        if (ArrayUtils.isEmpty(r58) == true) goto L94;
        r117 = r5;
        r218 = r115;
        if (r57.size() != r58.size()) goto L98;
        if (r116 == false) goto L98;
        r119 = true;
        int r59 = 0;
    L85:
        if (r59 >= r57.size()) goto L98;
        if (((Boolean) r58.get(r59)).booleanValue() == false) goto L88;
        r59 = r59 + 1;     // Catch: Throwable -> L90
        goto L85
    L88:
        r119 = false;
        goto L98
    L94:
        r117 = r5;
        r218 = r115;
    L92:
        th = th;
        goto L362
    L108:
        r19 = r5;
        r23 = r216;
    L106:
        th = th;
        goto L362
    L109:
        r19 = r5;
        r23 = r216;
        goto L406
    L408:
        r216 = r13;
        r113 = r1.getSharedLibraryInfo(r5.getSdkLibraryName(), r5.getSdkLibVersionMajor());     // Catch: Throwable -> L57
    L57:
        th = th;
    L59:
        th = th;
        goto L362
    L360:
        r21 = false;
        r113 = r1.getSharedLibraryInfo(r5.getStaticSharedLibraryName(), r5.getStaticSharedLibraryVersion());     // Catch: Throwable -> L48
        r216 = r13;
    L48:
        th = th;
        goto L362
    L29:
        if ((r33 & 4) != 0) goto L40;
        UserInfo r60 = this.mUserManagerInternal.getUserInfo(r32);     // Catch: Throwable -> L15
        if (r60 != null) goto L33;
    L36:
        Slog.w(PackageManagerServiceMonitorEx.TAG, "Not removing package " + r29 + " as only admin user (or their profile) may downgrade system apps");     // Catch: Throwable -> L15
        EventLog.writeEvent(1397638484, new Object[]{"170646036", -1, r29});     // Catch: Throwable -> L15
        monitor-exit(r3);     // Catch: Throwable -> L15
        PackageManagerService.resetPriorityAfterPackageManagerTracedLockedSection();
        return -3;
    L33:
        if (r60.isAdmin() == true) goto L40;
        if (this.mUserManagerInternal.getUserInfo(this.mUserManagerInternal.getProfileParentId(r32)).isAdmin() == true) goto L40;
    L15:
        th = th;
    L345:
        th = th;
        goto L362
    L5:
        r0 = r32;
        goto L6
    }

    private void deleteArtDexoptArtifacts(String packageName) {
        PackageManagerLocal.FilteredSnapshot filteredSnapshot = PackageManagerServiceUtils.getPackageManagerLocal().withFilteredSnapshot();
        DexOptHelper.getArtManagerLocal().deleteDexoptArtifacts(filteredSnapshot, packageName);     // Catch: Throwable -> L5 Throwable -> L7
    L9:
        if (filteredSnapshot == null) goto L23;
        filteredSnapshot.close();
        return;
    L23:
        return;
    L5:
        th = move-exception;
        if (filteredSnapshot != null) goto L21;
    L17:
        throw th;
    L21:
        filteredSnapshot.close();     // Catch: Throwable -> L15
    L15:
        th = move-exception;
        th.addSuppressed(th);
    L7:
        e = move-exception;
        Slog.w(PackageManagerServiceMonitorEx.TAG, e.toString());     // Catch: Throwable -> L5
        goto L9
    }

    public boolean deletePackageLIF(String packageName, UserHandle user, boolean deleteCodeAndResources, int[] allUserHandles, int flags, PackageRemovedInfo outInfo, boolean writeSettings) {
        PackageManagerTracedLock r2 = this.mPm.mLock;
        PackageManagerService.boostPriorityForPackageManagerTracedLockedSection();
        monitor-enter(r2);
        PackageSetting ps = this.mPm.mSettings.getPackageLPr(packageName);     // Catch: Throwable -> L10
        if (ps != null) goto L12;
        Slog.d(PackageManagerServiceMonitorEx.TAG, "Attempted to remove non-existent package " + packageName);     // Catch: Throwable -> L10
        monitor-exit(r2);     // Catch: Throwable -> L10
        PackageManagerService.resetPriorityAfterPackageManagerTracedLockedSection();
        return false;
    L12:
        PackageSetting disabledPs = this.mPm.mSettings.getDisabledSystemPkgLPr(ps);     // Catch: Throwable -> L10
        if (PackageManagerServiceUtils.isSystemApp(ps) == false) goto L21;
        if (this.mPm.checkPermission("android.permission.CONTROL_KEYGUARD", packageName, 0) != 0) goto L21;
        Slog.w(PackageManagerServiceMonitorEx.TAG, "Attempt to delete keyguard system package " + packageName);     // Catch: Throwable -> L10
        monitor-exit(r2);     // Catch: Throwable -> L10
        PackageManagerService.resetPriorityAfterPackageManagerTracedLockedSection();
        return false;
    L21:
        DeletePackageAction action = mayDeletePackageLocked(outInfo, ps, disabledPs, flags, user);     // Catch: Throwable -> L34
        monitor-exit(r2);     // Catch: Throwable -> L34
        PackageManagerService.resetPriorityAfterPackageManagerTracedLockedSection();
        Slog.d(PackageManagerServiceMonitorEx.TAG, "deletePackageLI: " + packageName + " user " + user);
        if (action != null) goto L39;
        Slog.d(PackageManagerServiceMonitorEx.TAG, "deletePackageLI: action was null");
        return false;
    L39:
        executeDeletePackageLIF(action, packageName, deleteCodeAndResources, allUserHandles, writeSettings, false);     // Catch: SystemDeleteException -> L31
        return true;
    L31:
        e = move-exception;
        Slog.d(PackageManagerServiceMonitorEx.TAG, "deletePackageLI: system deletion failure", e);
        return false;
    L34:
        e = th;
    L35:
        monitor-exit(r2);     // Catch: Throwable -> L34
        PackageManagerService.resetPriorityAfterPackageManagerTracedLockedSection();
        throw e;
    L10:
        e = th;
        goto L35
    }

    public static DeletePackageAction mayDeletePackageLocked(PackageRemovedInfo outInfo, PackageSetting ps, PackageSetting disabledPs, int flags, UserHandle user) {
        if (ps != null) goto L6;
        return null;
    L6:
        if (PackageManagerServiceUtils.isSystemApp(ps) == false) goto L21;
        boolean deleteAllUsers = false;
        if ((flags & 4) == 0) goto L10;
        boolean deleteSystem = true;
    L11:
        if (user != null) goto L13;
    L14:
        deleteAllUsers = true;
    L15:
        if (deleteSystem == false) goto L17;
        if (deleteAllUsers == false) goto L21;
    L17:
        if (disabledPs != null) goto L21;
        Slog.w(PackageManagerServiceMonitorEx.TAG, "Attempt to delete unknown system package " + ps.getName());
        return null;
    L13:
        if (user.getIdentifier() != (-1)) goto L15;
    L10:
        deleteSystem = false;
    L21:
        return new DeletePackageAction(ps, disabledPs, outInfo, flags, user);
    }

    public void executeDeletePackage(DeletePackageAction action, String packageName, boolean deleteCodeAndResources, int[] allUserHandles, boolean writeSettings, boolean keepArtProfile) throws SystemDeleteException {
        PackageManagerTracedLock installLock = this.mPm.mInstallLock.acquireLock();
        executeDeletePackageLIF(action, packageName, deleteCodeAndResources, allUserHandles, writeSettings, keepArtProfile);     // Catch: Throwable -> L7
        if (installLock == null) goto L19;
        installLock.close();
        return;
    L19:
        return;
    L7:
        th = move-exception;
        if (installLock == null) goto L20;
        installLock.close();     // Catch: Throwable -> L12
        throw th;
    L12:
        th = move-exception;
        th.addSuppressed(th);
        throw th;
    L20:
        throw th;
    }

    private void executeDeletePackageLIF(DeletePackageAction action, String packageName, boolean deleteCodeAndResources, int[] allUserHandles, boolean writeSettings, boolean keepArtProfile) throws SystemDeleteException {
        PackageSetting ps = action.mDeletingPs;
        PackageRemovedInfo outInfo = action.mRemovedInfo;
        UserHandle user = action.mUser;
        if (keepArtProfile == false) goto L5;
        int flags = action.mFlags | 131072;
    L6:
        boolean systemApp = PackageManagerServiceUtils.isSystemApp(ps);
        SparseBooleanArray hadSuspendAppsPermission = new SparseBooleanArray();
        int r0 = allUserHandles.length;
        int r3 = 0;
    L7:
        if (r3 >= r0) goto L14;
        int userId = allUserHandles[r3];
        if (this.mPm.checkPermission("android.permission.SUSPEND_APPS", packageName, userId) != 0) goto L11;
        boolean r15 = true;
    L12:
        hadSuspendAppsPermission.put(userId, r15);
        r3 = r3 + 1;
        goto L7
    L11:
        r15 = false;
        goto L12
    L14:
        if (user != null) goto L16;
        int userId2 = -1;
    L17:
        if (userId2 != (-1)) goto L19;
        int[] r4 = ps.queryUsersInstalledOrHasData(allUserHandles);
    L20:
        outInfo.mRemovedUsers = r4;
        outInfo.populateBroadcastUsers(ps);
        if ((flags & 1) != 0) goto L23;
        boolean r5 = true;
    L24:
        outInfo.mDataRemoved = r5;
        outInfo.mRemovedPackage = ps.getPackageName();
        outInfo.mInstallerPackageName = ps.getInstallSource().mInstallerPackageName;
        if (ps.getPkg() != null) goto L27;
    L29:
        boolean r6 = false;
    L30:
        outInfo.mIsStaticSharedLib = r6;
        outInfo.mIsExternal = ps.isExternalStorage();
        outInfo.mRemovedPackageVersionCode = ps.getVersionCode();
        if (systemApp == true) goto L33;
    L36:
        if (userId2 == (-1)) goto L64;
        PackageManagerTracedLock r7 = this.mPm.mLock;
        PackageManagerService.boostPriorityForPackageManagerTracedLockedSection();
        monitor-enter(r7);
        markPackageUninstalledForUserLPw(ps, user, flags);     // Catch: Throwable -> L46
        if (systemApp == true) goto L50;
        boolean keepUninstalledPackage = this.mPm.shouldKeepUninstalledPackageLPr(packageName);     // Catch: Throwable -> L46
        if (ps.isInstalledOnAnyOtherUser(this.mUserManagerInternal.getUserIds(), userId2) == true) goto L48;
        if (keepUninstalledPackage == true) goto L48;
        Slog.d(PackageManagerServiceMonitorEx.TAG, "Not installed by other users, full delete");     // Catch: Throwable -> L46
        this.mPm.mSettings.writeKernelMappingLPr(ps);     // Catch: Throwable -> L46
        boolean clearPackageStateAndReturn = false;
    L51:
        monitor-exit(r7);     // Catch: Throwable -> L46
        PackageManagerService.resetPriorityAfterPackageManagerTracedLockedSection();
        if (clearPackageStateAndReturn == false) goto L64;
        this.mRemovePackageHelper.clearPackageStateForUserLIF(ps, userId2, flags);
        outInfo.mUid = ps.getAppId();
        if (outInfo.mDataRemoved == false) goto L57;
        outInfo.mIsAppIdRemoved = true;
    L57:
        this.mPm.scheduleWritePackageRestrictions(user);
        return;
    L48:
        Slog.d(PackageManagerServiceMonitorEx.TAG, "Still installed by other users");     // Catch: Throwable -> L46
        clearPackageStateAndReturn = true;
        goto L51
    L50:
        Slog.d(PackageManagerServiceMonitorEx.TAG, "Deleting system app");     // Catch: Throwable -> L46
        clearPackageStateAndReturn = true;
    L46:
        th = move-exception;
        PackageManagerService.resetPriorityAfterPackageManagerTracedLockedSection();
        throw th;
    L64:
        if (systemApp == false) goto L66;
        Slog.d(PackageManagerServiceMonitorEx.TAG, "Removing system package: " + ps.getPackageName());
        deleteInstalledSystemPackage(action, allUserHandles, writeSettings);
        this.mPm.restoreDisabledSystemPackageLIF(action, allUserHandles, writeSettings);
    L70:
        Computer snapshot = this.mPm.snapshotComputer();
        int[] r1 = outInfo.mRemovedUsers;
        int r8 = r1.length;
        int r9 = 0;
    L71:
        if (r9 >= r8) goto L77;
        int affectedUserId = r1[r9];
        if (hadSuspendAppsPermission.get(affectedUserId) == false) goto L76;
        this.mPm.unsuspendForSuspendingPackage(snapshot, packageName, affectedUserId, -1);
        this.mPm.removeAllDistractingPackageRestrictions(snapshot, affectedUserId);
    L76:
        r9 = r9 + 1;
        r1 = r1;
        goto L71
    L77:
        PackageManagerTracedLock r10 = this.mPm.mLock;
        PackageManagerService.boostPriorityForPackageManagerTracedLockedSection();
        monitor-enter(r10);
    L87:
        th = move-exception;
        PackageManagerService.resetPriorityAfterPackageManagerTracedLockedSection();
        throw th;
    L80:
        if (this.mPm.mPackages.get(ps.getPackageName()) != null) goto L82;
        boolean r14 = true;
    L83:
        outInfo.mRemovedForAllUsers = r14;     // Catch: Throwable -> L87
        monitor-exit(r10);     // Catch: Throwable -> L87
        PackageManagerService.resetPriorityAfterPackageManagerTracedLockedSection();
        return;
    L82:
        r14 = false;
        goto L83
    L66:
        Slog.d(PackageManagerServiceMonitorEx.TAG, "Removing non-system package: " + ps.getPackageName());
        if (ps.isIncremental() == false) goto L69;
        deleteArtDexoptArtifacts(packageName);
    L69:
        deleteInstalledPackageLIF(ps, userId2, deleteCodeAndResources, flags, allUserHandles, outInfo, writeSettings);
        goto L70
    L33:
        if ((flags & 4) == 0) goto L64;
    L27:
        if (ps.getPkg().getStaticSharedLibraryName() == null) goto L29;
        r6 = true;
        goto L30
    L23:
        r5 = false;
        goto L24
    L19:
        r4 = new int[]{userId2};
        goto L20
    L16:
        userId2 = user.getIdentifier();
        goto L17
    L5:
        flags = action.mFlags;
        goto L6
    }

    private void deleteInstalledPackageLIF(PackageSetting ps, int userId, boolean deleteCodeAndResources, int flags, int[] allUserHandles, PackageRemovedInfo outInfo, boolean writeSettings) {
        PackageManagerTracedLock r1 = this.mPm.mLock;
        PackageManagerService.boostPriorityForPackageManagerTracedLockedSection();
        monitor-enter(r1);
        outInfo.mUid = ps.getAppId();     // Catch: Throwable -> L10
        outInfo.mBroadcastAllowList = this.mPm.mAppsFilter.getVisibilityAllowList(this.mPm.snapshotComputer(), ps, allUserHandles, this.mPm.mSettings.getPackagesLocked());     // Catch: Throwable -> L10
        monitor-exit(r1);     // Catch: Throwable -> L10
        PackageManagerService.resetPriorityAfterPackageManagerTracedLockedSection();
        this.mRemovePackageHelper.removePackageDataLIF(ps, userId, allUserHandles, outInfo, flags, writeSettings);
        if (deleteCodeAndResources == false) goto L16;
        outInfo.mArgs = new CleanUpArgs(ps.getName(), ps.getPathString(), InstructionSets.getAppDexInstructionSets(ps.getPrimaryCpuAbiLegacy(), ps.getSecondaryCpuAbiLegacy()));
        return;
    L16:
        return;
    L10:
        th = move-exception;
        PackageManagerService.resetPriorityAfterPackageManagerTracedLockedSection();
        throw th;
    }

    private void markPackageUninstalledForUserLPw(PackageSetting ps, UserHandle user, int flags) {
        int nextUserId = 0;
        if (user != null) goto L5;
    L8:
        int[] userIds = this.mUserManagerInternal.getUserIds();
    L9:
        int r4 = userIds.length;
    L10:
        if (nextUserId >= r4) goto L24;
        int r5 = nextUserId;
        int nextUserId2 = userIds[r5];
        Slog.d(PackageManagerServiceMonitorEx.TAG, "Marking package:" + ps.getPackageName() + " uninstalled for user:" + nextUserId2);
        if ((flags & 1) == 0) goto L14;
        ArraySet<String> enabledComponents = new ArraySet(ps.readUserState(nextUserId2).getEnabledComponents());
        ArraySet<String> disabledComponents = new ArraySet(ps.readUserState(nextUserId2).getDisabledComponents());
        ArraySet<String> enabledComponents2 = enabledComponents;
        ArraySet<String> disabledComponents2 = disabledComponents;
    L16:
        if ((flags & 1) != 0) goto L18;
        ArchiveState archiveState = null;
    L20:
        if ((flags & 1) != 0) goto L22;
        long r6 = 0;
    L23:
        long firstInstallTime = r6;
        ps.setUserState(nextUserId2, ps.getCeDataInode(nextUserId2), ps.getDeDataInode(nextUserId2), 0, false, true, true, false, 0, null, false, false, null, enabledComponents2, disabledComponents2, 0, 0, null, null, firstInstallTime, 0, archiveState);
        nextUserId = r5 + 1;
        r4 = r4;
        userIds = userIds;
        goto L10
    L22:
        r6 = ps.getUserStateOrDefault(nextUserId2).getFirstInstallTimeMillis();
        goto L23
    L18:
        archiveState = ps.getUserStateOrDefault(nextUserId2).getArchiveState();
        goto L20
    L14:
        enabledComponents2 = null;
        disabledComponents2 = null;
        goto L16
    L24:
        this.mPm.mSettings.writeKernelMappingLPr(ps);
        return;
    L5:
        if (user.getIdentifier() == (-1)) goto L8;
        userIds = new int[]{user.getIdentifier()};
        goto L9
    }

    private void deleteInstalledSystemPackage(DeletePackageAction action, int[] allUserHandles, boolean writeSettings) {
        int flags = action.mFlags;
        PackageSetting deletedPs = action.mDeletingPs;
        PackageRemovedInfo outInfo = action.mRemovedInfo;
        int r4 = 0;
        if (outInfo.mOrigUsers == null) goto L5;
        boolean r2 = true;
    L6:
        boolean applyUserRestrictions = r2;
        AndroidPackageInternal r11 = deletedPs.getPkg();
        PackageSetting disabledPs = action.mDisabledPs;
        Slog.d(PackageManagerServiceMonitorEx.TAG, "deleteSystemPackageLI: newPs=" + r11.getPackageName() + " disabledPs=" + disabledPs);
        Slog.d(PackageManagerServiceMonitorEx.TAG, "Deleting system pkg from data partition");
        if (applyUserRestrictions == false) goto L12;
        Slog.d(PackageManagerServiceMonitorEx.TAG, "Remembering install states:");
        int r3 = allUserHandles.length;
    L10:
        if (r4 >= r3) goto L12;
        int userId = allUserHandles[r4];
        boolean finstalled = ArrayUtils.contains(outInfo.mOrigUsers, userId);
        Slog.d(PackageManagerServiceMonitorEx.TAG, "   u=" + userId + " inst=" + finstalled);
        r4 = r4 + 1;
    L12:
        outInfo.mIsRemovedPackageSystemUpdate = true;
        if (disabledPs.getVersionCode() >= deletedPs.getVersionCode()) goto L15;
    L18:
        int flags2 = flags & (-2);
    L19:
        PackageManagerTracedLock installLock = this.mPm.mInstallLock.acquireLock();
        deleteInstalledPackageLIF(deletedPs, -1, true, flags2, allUserHandles, outInfo, writeSettings);     // Catch: Throwable -> L24
        if (installLock == null) goto L37;
        installLock.close();
        return;
    L37:
        return;
    L24:
        th = move-exception;
        if (installLock == null) goto L38;
        installLock.close();     // Catch: Throwable -> L29
        throw th;
    L29:
        th = move-exception;
        th.addSuppressed(th);
        throw th;
    L38:
        throw th;
    L15:
        if (disabledPs.getAppId() != deletedPs.getAppId()) goto L18;
        flags2 = flags | 1;
        goto L19
    L5:
        r2 = false;
        goto L6
    }

    public void deletePackageVersionedInternal(VersionedPackage versionedPackage, IPackageDeleteObserver2 observer, int userId, int deleteFlags, boolean allowSilentUninstall) {
        deletePackageVersionedInternal(versionedPackage, observer, userId, deleteFlags, Binder.getCallingUid(), allowSilentUninstall);
    }

    public void deletePackageVersionedInternal(VersionedPackage versionedPackage, final IPackageDeleteObserver2 observer, final int userId, final int deleteFlags, final int callingUid, boolean allowSilentUninstall) {
        this.mPm.mContext.enforceCallingOrSelfPermission("android.permission.DELETE_PACKAGES", null);
        Computer snapshot = this.mPm.snapshotComputer();
        final boolean canViewInstantApps = snapshot.canViewInstantApps(callingUid, userId);
        Preconditions.checkNotNull(versionedPackage);
        Preconditions.checkNotNull(observer);
        Preconditions.checkArgumentInRange(versionedPackage.getLongVersionCode(), -1, Long.MAX_VALUE, "versionCode must be >= -1");
        final String packageName = versionedPackage.getPackageName();
        final long versionCode = versionedPackage.getLongVersionCode();
    L7:
        e = move-exception;
        e.rethrowFromSystemServer();
    L11:
        final String internalPackageName = snapshot.resolveInternalPackageName(packageName, versionCode);
        if ((deleteFlags & 2) == 0) goto L14;
        boolean r0 = true;
    L15:
        final boolean deleteAllUsers = r0;
        if (deleteAllUsers == false) goto L18;
        int[] r1 = this.mUserManagerInternal.getUserIds();
    L19:
        final int[] users = r1;
        if (isOrphaned(snapshot, internalPackageName) == true) goto L27;
        if (allowSilentUninstall == true) goto L27;
        if (isCallerAllowedToSilentlyUninstall(snapshot, callingUid, internalPackageName, users) == true) goto L27;
        this.mPm.mHandler.post(new DeletePackageHelper$$ExternalSyntheticLambda1(packageName, observer, deleteFlags));
        return;
    L27:
        if (UserHandle.getUserId(callingUid) != userId) goto L32;
        if (deleteAllUsers == false) goto L35;
        if (users.length > 1) goto L32;
    L35:
        if ("1".equals(SystemProperties.get("persist.sys.ismaint", "0")) == false) goto L42;
        Log.d(PackageManagerServiceMonitorEx.TAG, "start to enter Maintenance User");
        int mUid = Integer.parseInt(SystemProperties.get("persist.sys.maintid", "0"));
        if (mUid != userId) goto L42;
        Log.d(PackageManagerServiceMonitorEx.TAG, "now is Maintenance mode and UserId is " + mUid);
        if ("com.zte.handservice".equals(packageName) == false) goto L42;
        this.mPm.mHandler.post(new DeletePackageHelper$$ExternalSyntheticLambda2(observer, packageName));
        return;
    L42:
        long token = Binder.clearCallingIdentity();
        int r2 = users.length;     // Catch: Throwable -> L74
        int r5 = 0;
    L45:
        if (r5 >= r2) goto L59;
        int user = users[r5];     // Catch: Throwable -> L51
        int r16 = r2;
        if (this.mPm.isPackageDeviceAdmin(packageName, user) == true) goto L48;
        if (this.mPm.mProtectedPackages.isPackageDataProtected(user, packageName) == true) goto L55;
        r5 = r5 + 1;
        r2 = r16;
        goto L45
    L55:
        this.mPm.mHandler.post(new DeletePackageHelper$$ExternalSyntheticLambda4(packageName, observer));     // Catch: Throwable -> L51
        Binder.restoreCallingIdentity(token);
        return;
    L48:
        this.mPm.mHandler.post(new DeletePackageHelper$$ExternalSyntheticLambda3(packageName, observer));     // Catch: Throwable -> L51
        Binder.restoreCallingIdentity(token);
        return;
    L51:
        th = th;
    L76:
        Binder.restoreCallingIdentity(token);
        throw th;
    L59:
        Binder.restoreCallingIdentity(token);
        if (this.mPm.isUserRestricted(userId, "no_uninstall_apps") == false) goto L63;
        this.mPm.mHandler.post(new DeletePackageHelper$$ExternalSyntheticLambda5(observer, packageName));
        return;
    L63:
        if (deleteAllUsers == false) goto L65;
    L68:
        StringBuilder r3 = new StringBuilder();
        r3.append("deletePackageAsUser: pkg=");
        r3.append(internalPackageName);
        r3.append(" user=");
        r3.append(userId);
        r3.append(" deleteAllUsers: ");
        r3.append(deleteAllUsers);
        r3.append(" version=");
        if (versionCode != (-1)) goto L71;
        Object r4 = "VERSION_CODE_HIGHEST";
    L72:
        r3.append(r4);
        Slog.d(PackageManagerServiceMonitorEx.TAG, r3.toString());
        this.mPm.mHandler.post(new DeletePackageHelper$$ExternalSyntheticLambda7(this, internalPackageName, callingUid, canViewInstantApps, deleteAllUsers, versionCode, userId, deleteFlags, users, observer, packageName));
        return;
    L71:
        r4 = Long.valueOf(versionCode);
        goto L72
    L65:
        if (snapshot.getBlockUninstallForUser(internalPackageName, userId) == false) goto L68;
        this.mPm.mHandler.post(new DeletePackageHelper$$ExternalSyntheticLambda6(observer, packageName));
        return;
    L74:
        th = th;
    L32:
        if (DoppelgangerManager.allowCrossUser(UserHandle.getUserId(callingUid), userId) == true) goto L35;
        this.mPm.mContext.enforceCallingOrSelfPermission("android.permission.INTERACT_ACROSS_USERS_FULL", "deletePackage for user " + userId);
        goto L35
    L18:
        r1 = new int[]{userId};
        goto L19
    L14:
        r0 = false;
        goto L15
    L4:
        if (((ActivityTaskManagerInternal) this.mPm.mInjector.getLocalService(ActivityTaskManagerInternal.class)).isBaseOfLockedTask(packageName) == false) goto L11;
        observer.onPackageDeleted(packageName, -7, null);     // Catch: RemoteException -> L7
        EventLog.writeEvent(1397638484, new Object[]{"127605586", -1, ""});     // Catch: RemoteException -> L7
    }

    private static /* synthetic */ void lambda$deletePackageVersionedInternal$0(String packageName, IPackageDeleteObserver2 observer, int deleteFlags) {
        Intent intent = new Intent("android.intent.action.UNINSTALL_PACKAGE");     // Catch: RemoteException -> L5
        intent.setData(Uri.fromParts(Settings.ATTR_PACKAGE, packageName, null));     // Catch: RemoteException -> L5
        intent.putExtra("android.content.pm.extra.CALLBACK", new PackageManager.UninstallCompleteCallback(observer.asBinder()));     // Catch: RemoteException -> L5
        if ((deleteFlags & 16) == 0) goto L7;
        intent.putExtra("android.content.pm.extra.DELETE_FLAGS", deleteFlags);     // Catch: RemoteException -> L5
    L7:
        observer.onUserActionRequired(intent);     // Catch: RemoteException -> L5
        return;
    }

    private static /* synthetic */ void lambda$deletePackageVersionedInternal$1(IPackageDeleteObserver2 observer, String packageName) {
        observer.onPackageDeleted(packageName, -3, null);     // Catch: RemoteException -> L5
        return;
    L5:
        re = move-exception;
        Slog.e(PackageManagerServiceMonitorEx.TAG, "remove handservice app fail, e=" + re);
    }

    private static /* synthetic */ void lambda$deletePackageVersionedInternal$2(String packageName, IPackageDeleteObserver2 observer) {
        Slog.w(PackageManagerServiceMonitorEx.TAG, "Not removing package " + packageName + ": has active device admin");     // Catch: RemoteException -> L4
        observer.onPackageDeleted(packageName, -2, null);     // Catch: RemoteException -> L4
        return;
    }

    private static /* synthetic */ void lambda$deletePackageVersionedInternal$3(String packageName, IPackageDeleteObserver2 observer) {
        Slog.w(PackageManagerServiceMonitorEx.TAG, "Attempted to delete protected package: " + packageName);     // Catch: RemoteException -> L4
        observer.onPackageDeleted(packageName, -1, null);     // Catch: RemoteException -> L4
        return;
    }

    private static /* synthetic */ void lambda$deletePackageVersionedInternal$4(IPackageDeleteObserver2 observer, String packageName) {
        observer.onPackageDeleted(packageName, -3, null);     // Catch: RemoteException -> L5
        return;
    }

    private static /* synthetic */ void lambda$deletePackageVersionedInternal$5(IPackageDeleteObserver2 observer, String packageName) {
        observer.onPackageDeleted(packageName, -4, null);     // Catch: RemoteException -> L5
        return;
    }

    private /* synthetic */ void lambda$deletePackageVersionedInternal$6(String internalPackageName, int callingUid, boolean canViewInstantApps, boolean deleteAllUsers, long versionCode, int userId, int deleteFlags, int[] users, IPackageDeleteObserver2 observer, String packageName) {
        DeletePackageHelper r1 = this;
        Computer innerSnapshot = r1.mPm.snapshotComputer();
        PackageStateInternal packageState = innerSnapshot.getPackageStateInternal(internalPackageName);
        if (packageState == null) goto L11;
        boolean targetIsInstantApp = packageState.getUserStateOrDefault(UserHandle.getUserId(callingUid)).isInstantApp();
        if (targetIsInstantApp == false) goto L9;
        if (canViewInstantApps == true) goto L9;
        boolean r4 = false;
    L10:
        boolean doDeletePackage = r4;
        boolean doDeletePackage2 = doDeletePackage;
    L13:
        if (doDeletePackage2 == true) goto L15;
        int returnCode = -1;
    L68:
        observer.onPackageDeleted(packageName, returnCode, null);     // Catch: RemoteException -> L59
    L62:
        if (MindSyncManager.ZTE_FEATURE_MINDSYNC == false) goto L66;
        if (returnCode != 1) goto L66;
        Bundle bundle = r1.getUninstallInfo(packageName, userId);
        MindSyncManager.Trigger.uninstallEvent(bundle);
    L66:
        r1.mPm.schedulePruneUnusedStaticSharedLibraries(true);
        return;
    L60:
        Log.i(PackageManagerServiceMonitorEx.TAG, "Observer no longer exists.");
        goto L62
    L15:
        if (deleteAllUsers == true) goto L41;
        returnCode = r1.deletePackageX(internalPackageName, versionCode, userId, deleteFlags, false);
        int r2 = userId;
        if (returnCode != 1) goto L68;
        if (packageState == null) goto L68;
        int[] childUserIds = r1.mUserManagerInternal.getProfileIds(r2, true);
        int r5 = childUserIds.length;
        int returnCode2 = returnCode;
        int childId = 0;
    L20:
        if (childId >= r5) goto L39;
        int r6 = childId;
        int childId2 = childUserIds[r6];
        if (childId2 != r2) goto L25;
        int[] childUserIds2 = childUserIds;
        int r19 = r5;
        int r20 = r6;
    L38:
        childId = r20 + 1;
        r2 = userId;
        childUserIds = childUserIds2;
        r5 = r19;
        goto L20
    L25:
        if (r1.mUserManagerInternal.getProfileParentId(childId2) == r2) goto L28;
        childUserIds2 = childUserIds;
        r19 = r5;
        r20 = r6;
        goto L38
    L28:
        if (packageState.getUserStateOrDefault(childId2).isInstalled() == true) goto L30;
        childUserIds2 = childUserIds;
        r19 = r5;
        r20 = r6;
        goto L38
    L30:
        UserProperties userProperties = r1.mUserManagerInternal.getUserProperties(childId2);
        if (userProperties != null) goto L33;
    L37:
        childUserIds2 = childUserIds;
        r19 = r5;
        r20 = r6;
        goto L38
    L33:
        if (userProperties.getDeleteAppWithParent() == false) goto L37;
        childUserIds2 = childUserIds;
        r19 = r5;
        r20 = r6;
        int returnCodeOfChild = r1.deletePackageX(internalPackageName, versionCode, childId2, deleteFlags, false);
        if (returnCodeOfChild == 1) goto L38;
        Slog.w(PackageManagerServiceMonitorEx.TAG, "Package delete failed for user " + childId2 + ", returnCode " + returnCodeOfChild);
        returnCode2 = -8;
        goto L38
    L39:
        returnCode = returnCode2;
        goto L68
    L41:
        int[] blockUninstallUserIds = r1.getBlockUninstallForUsers(innerSnapshot, internalPackageName, users);
        if (ArrayUtils.isEmpty(blockUninstallUserIds) == false) goto L44;
        returnCode = r1.deletePackageX(internalPackageName, versionCode, userId, deleteFlags, false);
        r1 = this;
        goto L68
    L44:
        int[] blockUninstallUserIds2 = blockUninstallUserIds;
        int userFlags = deleteFlags & (-3);
        int r3 = users.length;
        int r7 = 0;
    L45:
        if (r7 >= r3) goto L53;
        int userId1 = users[r7];
        if (ArrayUtils.contains(blockUninstallUserIds2, userId1) == true) goto L51;
        int[] blockUninstallUserIds3 = blockUninstallUserIds2;
        int r17 = r3;
        int r18 = r7;
        int returnCode3 = deletePackageX(internalPackageName, versionCode, userId1, userFlags, false);
        if (returnCode3 == 1) goto L52;
        Slog.w(PackageManagerServiceMonitorEx.TAG, "Package delete failed for user " + userId1 + ", returnCode " + returnCode3);
    L52:
        r7 = r18 + 1;
        blockUninstallUserIds2 = blockUninstallUserIds3;
        r3 = r17;
        goto L45
    L51:
        blockUninstallUserIds3 = blockUninstallUserIds2;
        r17 = r3;
        r18 = r7;
        goto L52
    L53:
        r1 = this;
        returnCode = -4;
    L9:
        r4 = true;
        goto L10
    L11:
        doDeletePackage2 = true;
        goto L13
    }

    private boolean isOrphaned(Computer snapshot, String packageName) {
        PackageStateInternal packageState = snapshot.getPackageStateInternal(packageName);
        if (packageState != null) goto L5;
    L7:
        return false;
    L5:
        if (packageState.getInstallSource().mIsOrphaned == false) goto L7;
        return true;
    }

    private boolean isCallerAllowedToSilentlyUninstall(Computer snapshot, int callingUid, String pkgName, int[] targetUserIds) {
        if (PackageManagerServiceUtils.isRootOrShell(callingUid) == false) goto L5;
    L41:
        return true;
    L5:
        if (UserHandle.getAppId(callingUid) == 1000) goto L41;
        int callingUserId = UserHandle.getUserId(callingUid);
        int r2 = targetUserIds.length;
        int r4 = 0;
    L9:
        if (r4 >= r2) goto L17;
        int user = targetUserIds[r4];
        if (callingUid != snapshot.getPackageUid(snapshot.getInstallerPackageName(pkgName, user), 0, callingUserId)) goto L16;
        return true;
    L16:
        r4 = r4 + 1;
        goto L9
    L17:
        String[] r3 = this.mPm.mRequiredVerifierPackages;
        int r5 = r3.length;
        int r7 = 0;
    L18:
        if (r7 >= r5) goto L24;
        String verifierPackageName = r3[r7];
        if (callingUid == snapshot.getPackageUid(verifierPackageName, 0, callingUserId)) goto L21;
        r7 = r7 + 1;
        goto L18
    L21:
        return true;
    L24:
        if (this.mPm.mRequiredUninstallerPackage == null) goto L29;
        if (callingUid != snapshot.getPackageUid(this.mPm.mRequiredUninstallerPackage, 0, callingUserId)) goto L29;
        return true;
    L29:
        if (this.mPm.mStorageManagerPackage == null) goto L34;
        if (callingUid != snapshot.getPackageUid(this.mPm.mStorageManagerPackage, 0, callingUserId)) goto L34;
        return true;
    L34:
        if (this.mPm.getSmtEx().checkSmtApp(callingUid, callingUserId) == false) goto L37;
        return true;
    L37:
        if (snapshot.checkUidPermission("android.permission.MANAGE_PROFILE_AND_DEVICE_OWNERS", callingUid) != 0) goto L40;
        return true;
    L40:
        return false;
    }

    private int[] getBlockUninstallForUsers(Computer snapshot, String packageName, int[] userIds) {
        int[] result = PackageManagerService.EMPTY_INT_ARRAY;
        int r1 = userIds.length;
        int r2 = 0;
    L3:
        if (r2 >= r1) goto L8;
        int userId = userIds[r2];
        if (snapshot.getBlockUninstallForUser(packageName, userId) == false) goto L7;
        result = ArrayUtils.appendInt(result, userId);
    L7:
        r2 = r2 + 1;
        goto L3
    L8:
        return result;
    }

    public void removeUnusedPackagesLPw(UserManagerService userManager, final int userId) {
        int[] users = userManager.getUserIds();
        int numPackages = this.mPm.mSettings.getPackagesLocked().size();
        int index = 0;
    L3:
        if (index >= numPackages) goto L30;
        PackageSetting ps = this.mPm.mSettings.getPackagesLocked().valueAt(index);
        if (ps.getPkg() == null) goto L28;
        final String packageName = ps.getPkg().getPackageName();
        if ((ps.getFlags() & 1) != 0) goto L28;
        if (TextUtils.isEmpty(ps.getPkg().getStaticSharedLibraryName()) == false) goto L28;
        if (TextUtils.isEmpty(ps.getPkg().getSdkLibraryName()) == false) goto L28;
        boolean keep = this.mPm.shouldKeepUninstalledPackageLPr(packageName);
        if (keep == true) goto L26;
        int i = 0;
    L19:
        if (i >= users.length) goto L26;
        if (users[i] == userId) goto L25;
        if (ps.getInstalled(users[i]) == false) goto L25;
        keep = true;
    L25:
        i = i + 1;
    L26:
        if (keep == true) goto L28;
        this.mPm.mHandler.post(new DeletePackageHelper$$ExternalSyntheticLambda0(this, packageName, userId));
    L28:
        index = index + 1;
        goto L3
    }

    private /* synthetic */ void lambda$removeUnusedPackagesLPw$7(String packageName, int userId) {
        deletePackageX(packageName, -1, userId, 0, true);
    }

    public void deleteExistingPackageAsUser(VersionedPackage versionedPackage, IPackageDeleteObserver2 observer, int userId) {
        this.mPm.mContext.enforceCallingOrSelfPermission("android.permission.DELETE_PACKAGES", null);
        Preconditions.checkNotNull(versionedPackage);
        Preconditions.checkNotNull(observer);
        String packageName = versionedPackage.getPackageName();
        long versionCode = versionedPackage.getLongVersionCode();
        PackageManagerTracedLock r4 = this.mPm.mLock;
        PackageManagerService.boostPriorityForPackageManagerTracedLockedSection();
        monitor-enter(r4);
        String internalPkgName = this.mPm.snapshotComputer().resolveInternalPackageName(packageName, versionCode);     // Catch: Throwable -> L8
        PackageSetting ps = this.mPm.mSettings.getPackageLPr(internalPkgName);     // Catch: Throwable -> L8
        if (ps == null) goto L10;
        int[] installedUsers = ps.queryInstalledUsers(this.mUserManagerInternal.getUserIds(), true);     // Catch: Throwable -> L8
        int installedForUsersCount = installedUsers.length;     // Catch: Throwable -> L8
        int installedForUsersCount2 = installedForUsersCount;
    L28:
        monitor-exit(r4);     // Catch: Throwable -> L20
        PackageManagerService.resetPriorityAfterPackageManagerTracedLockedSection();
        if (installedForUsersCount2 <= 1) goto L26;
        deletePackageVersionedInternal(versionedPackage, observer, userId, 0, true);
        return;
    L26:
        observer.onPackageDeleted(packageName, -1, null);     // Catch: RemoteException -> L18
        return;
    L19:
        return;
    L20:
        th = th;
    L22:
        monitor-exit(r4);     // Catch: Throwable -> L8
        PackageManagerService.resetPriorityAfterPackageManagerTracedLockedSection();
        throw th;
    L10:
        installedForUsersCount2 = 0;
    L8:
        th = th;
        goto L22
    }

    private Bundle getUninstallInfo(String packageName, int userId) {
        Bundle bundle = new Bundle();
        PackageInfo packageInfo = this.mPm.snapshotComputer().getPackageInfo(packageName, 8192, userId);
        bundle.putString("app_package", packageName);
        if (packageInfo == null) goto L5;
        bundle.putString("app_name", packageInfo.applicationInfo.loadLabel(this.mPm.mContext.getPackageManager()).toString());
        bundle.putInt("app_version", packageInfo.versionCode);
    L5:
        return bundle;
    }

    private Bundle getInstallInfo(String packageName, int userId) {
        Bundle bundle = new Bundle();
        PackageInfo packageInfo = this.mPm.snapshotComputer().getPackageInfo(packageName, 16, userId);
        bundle.putString("app_package", packageName);
        if (packageInfo == null) goto L8;
        bundle.putString("app_name", packageInfo.applicationInfo.loadLabel(this.mPm.mContext.getPackageManager()).toString());
        bundle.putInt("app_version", packageInfo.versionCode);
        StringBuilder builder = new StringBuilder();
        Signature[] r3 = packageInfo.signatures;
        int r4 = r3.length;
        int r5 = 0;
    L5:
        if (r5 >= r4) goto L7;
        Signature signature = r3[r5];
        builder.append(signature.toCharsString());
        r5 = r5 + 1;
        goto L5
    L7:
        bundle.putString("signature", builder.toString());
    L8:
        return bundle;
    }

    public IExtDeletePackageHelper getExt() {
        return this.mExt;
    }
}
