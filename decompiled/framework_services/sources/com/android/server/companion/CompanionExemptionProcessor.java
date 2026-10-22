package com.android.server.companion;

import android.app.ActivityManagerInternal;
import android.app.AppOpsManager;
import android.companion.AssociationInfo;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManagerInternal;
import android.net.NetworkPolicyManager;
import android.os.Binder;
import android.os.Environment;
import android.os.PowerExemptionManager;
import android.util.ArraySet;
import android.util.Pair;
import android.util.Slog;
import com.android.internal.util.ArrayUtils;
import com.android.server.LocalServices;
import com.android.server.companion.association.AssociationStore;
import com.android.server.companion.utils.PackageUtils;
import com.android.server.pm.UserManagerInternal;
import com.android.server.wm.ActivityTaskManagerInternal;
import java.io.File;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

/* JADX INFO: loaded from: classes.dex */
public class CompanionExemptionProcessor {
    private static final String PREF_FILE_NAME = "companion_device_preferences.xml";
    private static final String PREF_KEY_AUTO_REVOKE_GRANTS_DONE = "auto_revoke_grants_done";
    private static final String TAG = "CDM_CompanionExemptionProcessor";
    private final ActivityManagerInternal mAmInternal;
    private final AppOpsManager mAppOpsManager;
    private final AssociationStore mAssociationStore;
    private final ActivityTaskManagerInternal mAtmInternal;
    private final Context mContext;
    private final PackageManagerInternal mPackageManager;
    private final PowerExemptionManager mPowerExemptionManager;

    /* JADX INFO: renamed from: $r8$lambda$ToR5gqUC2wI3TkFPVa5liwAr-YM, reason: not valid java name */
    public static /* synthetic */ void m2899$r8$lambda$ToR5gqUC2wI3TkFPVa5liwArYM(CompanionExemptionProcessor r0, int r1, PackageInfo r2, boolean r3) {
        r0.lambda$exemptPackage$0(r1, r2, r3);
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmAssociationStore, reason: not valid java name */
    static /* bridge */ /* synthetic */ AssociationStore m2900$$Nest$fgetmAssociationStore(CompanionExemptionProcessor r0) {
        return r0.mAssociationStore;
    }

    public CompanionExemptionProcessor(Context context, PowerExemptionManager powerExemptionManager, AppOpsManager appOpsManager, PackageManagerInternal packageManager, ActivityTaskManagerInternal atmInternal, ActivityManagerInternal amInternal, AssociationStore associationStore) {
        this.mContext = context;
        this.mPowerExemptionManager = powerExemptionManager;
        this.mAppOpsManager = appOpsManager;
        this.mPackageManager = packageManager;
        this.mAtmInternal = atmInternal;
        this.mAmInternal = amInternal;
        this.mAssociationStore = associationStore;
        this.mAssociationStore.registerLocalListener(new AnonymousClass1(this));
    }

    public void updateAtm(int userId, List<AssociationInfo> associations) {
        Set<Integer> companionAppUids = new ArraySet();
        Iterator<AssociationInfo> r1 = associations.iterator();
    L4:
        if (r1.hasNext() == false) goto L10;
        AssociationInfo association = r1.next();
        int uid = this.mPackageManager.getPackageUid(association.getPackageName(), 0, userId);
        if (uid < 0) goto L4;
        companionAppUids.add(Integer.valueOf(uid));
        goto L4
    L10:
        if (this.mAtmInternal == null) goto L13;
        this.mAtmInternal.setCompanionAppUids(userId, companionAppUids);
    L13:
        if (this.mAmInternal == null) goto L21;
        this.mAmInternal.setCompanionAppUids(userId, new ArraySet(companionAppUids));
        return;
    }

    public void exemptPackage(final int userId, String packageName, final boolean hasPresentDevices) {
        Slog.i(TAG, "Exempting package [" + packageName + "]...");
        final PackageInfo packageInfo = PackageUtils.getPackageInfo(this.mContext, userId, packageName);
        Binder.withCleanCallingIdentity(new CompanionExemptionProcessor$$ExternalSyntheticLambda0(this, userId, packageInfo, hasPresentDevices));
    }

    private /* synthetic */ void lambda$exemptPackage$0(int userId, PackageInfo packageInfo, boolean hasPresentDevices) throws Exception {
        exemptPackageAsSystem(userId, packageInfo, hasPresentDevices);
    }

    private void exemptPackageAsSystem(int userId, PackageInfo packageInfo, boolean hasPresentDevices) {
        if (packageInfo != null) goto L5;
        return;
    L5:
        if (containsEither(packageInfo.requestedPermissions, "android.permission.RUN_IN_BACKGROUND", "android.permission.REQUEST_COMPANION_RUN_IN_BACKGROUND") == false) goto L24;
        if (hasPresentDevices == false) goto L24;
        this.mPowerExemptionManager.addToPermanentAllowList(packageInfo.packageName);
    L12:
        NetworkPolicyManager networkPolicyManager = NetworkPolicyManager.from(this.mContext);
    L17:
        e = move-exception;
        Slog.e(TAG, e.getMessage());
    L22:
        updateAutoRevokeExemption(packageInfo.packageName, packageInfo.applicationInfo.uid, !this.mAssociationStore.getActiveAssociationsByPackage(userId, packageInfo.packageName).isEmpty());
        return;
    L14:
        if (containsEither(packageInfo.requestedPermissions, "android.permission.USE_DATA_IN_BACKGROUND", "android.permission.REQUEST_COMPANION_USE_DATA_IN_BACKGROUND") == false) goto L19;
        if (hasPresentDevices == false) goto L19;
        networkPolicyManager.addUidPolicy(packageInfo.applicationInfo.uid, 4);     // Catch: IllegalArgumentException -> L17
    L26:
    L19:
        networkPolicyManager.removeUidPolicy(packageInfo.applicationInfo.uid, 4);     // Catch: IllegalArgumentException -> L17
    L24:
        this.mPowerExemptionManager.removeFromPermanentAllowList(packageInfo.packageName);     // Catch: UnsupportedOperationException -> L10
    L11:
        Slog.w(TAG, packageInfo.packageName + " can't be removed from power save allowlist. It might be due to the package being allowlisted by the system.");
        goto L12
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r6v0 */
    /* JADX WARN: Type inference failed for: r6v1, types: [boolean, int] */
    /* JADX WARN: Type inference failed for: r6v2 */
    public void updateAutoRevokeExemptions() {
        Slog.d(TAG, "maybeGrantAutoRevokeExemptions()");
        PackageManager pm = this.mContext.getPackageManager();
        int[] r4 = ((UserManagerInternal) LocalServices.getService(UserManagerInternal.class)).getUserIds();
        int r5 = r4.length;
        ?? r6 = 0;
        int r7 = 0;
    L3:
        if (r7 >= r5) goto L28;
        int userId = r4[r7];
        SharedPreferences r9 = this.mContext.getSharedPreferences(new File(Environment.getUserSystemDirectory(userId), PREF_FILE_NAME), r6);
        if (r9.getBoolean(PREF_KEY_AUTO_REVOKE_GRANTS_DONE, r6) == true) goto L25;
        List<AssociationInfo> associations = this.mAssociationStore.getActiveAssociationsByUser(userId);     // Catch: Throwable -> L14
        Set<Pair<String, Integer>> exemptedPackages = new HashSet();     // Catch: Throwable -> L14
        Iterator<AssociationInfo> r14 = associations.iterator();     // Catch: Throwable -> L14
    L9:
        if (r14.hasNext() == false) goto L19;
        AssociationInfo a = r14.next();     // Catch: Throwable -> L14
        int uid = pm.getPackageUidAsUser(a.getPackageName(), userId);     // Catch: Throwable -> L14 PackageManager.NameNotFoundException -> L16
        exemptedPackages.add(new Pair(a.getPackageName(), Integer.valueOf(uid)));     // Catch: Throwable -> L14 PackageManager.NameNotFoundException -> L16
    L16:
        e = move-exception;
        Slog.w(TAG, "Unknown companion package: " + a.getPackageName(), e);     // Catch: Throwable -> L14
        goto L9
    L19:
        Iterator<Pair<String, Integer>> r0 = exemptedPackages.iterator();     // Catch: Throwable -> L14
    L21:
        if (r0.hasNext() == false) goto L24;
        Pair<String, Integer> exemptedPackage = r0.next();     // Catch: Throwable -> L14
        updateAutoRevokeExemption((String) exemptedPackage.first, ((Integer) exemptedPackage.second).intValue(), true);     // Catch: Throwable -> L14
        goto L21
    L24:
        r9.edit().putBoolean(PREF_KEY_AUTO_REVOKE_GRANTS_DONE, true).apply();
    L14:
        th = move-exception;
        r9.edit().putBoolean(PREF_KEY_AUTO_REVOKE_GRANTS_DONE, true).apply();
        throw th;
    L25:
        r7 = r7 + 1;
        r6 = 0;
        goto L3
    }

    private void updateAutoRevokeExemption(String packageName, int uid, boolean hasAssociations) {
        AppOpsManager r0 = this.mAppOpsManager;     // Catch: Exception -> L8
        if (hasAssociations == false) goto L5;
        int r1 = 1;
    L6:
        r0.setMode(97, uid, packageName, r1);     // Catch: Exception -> L8
        return;
    L5:
        r1 = 0;
    L8:
        e = move-exception;
        Slog.e(TAG, "Error while granting auto revoke exemption for " + packageName, e);
    }

    private <T> boolean containsEither(T[] array, T a, T b) {
        if (ArrayUtils.contains(array, a) == false) goto L5;
    L8:
        return true;
    L5:
        if (ArrayUtils.contains(array, b) == true) goto L8;
        return false;
    }
}
