package com.android.server.pm;

import android.os.UserHandle;
import android.util.ArraySet;
import android.util.IntArray;
import android.util.Slog;
import com.android.internal.util.ArrayUtils;
import com.android.server.pm.pkg.PackageStateInternal;
import com.android.server.pm.pkg.mutate.PackageStateMutator;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public final class DistractingPackageHelper {
    private final BroadcastHelper mBroadcastHelper;
    private final PackageManagerService mPm;
    private final SuspendPackageHelper mSuspendPackageHelper;

    public static /* synthetic */ void $r8$lambda$DZDHlgoessaqEHS3cLRDns80JRc(ArraySet r0, int r1, int r2, PackageStateMutator r3) {
        lambda$setDistractingPackageRestrictionsAsUser$0(r0, r1, r2, r3);
    }

    /* JADX INFO: renamed from: $r8$lambda$qn_7_AoiWbWhl1sl7eqo-qWR1jY, reason: not valid java name */
    public static /* synthetic */ void m6639$r8$lambda$qn_7_AoiWbWhl1sl7eqoqWR1jY(List r0, int r1, PackageStateMutator r2) {
        lambda$removeDistractingPackageRestrictions$1(r0, r1, r2);
    }

    DistractingPackageHelper(PackageManagerService pm, BroadcastHelper broadcastHelper, SuspendPackageHelper suspendPackageHelper) {
        this.mPm = pm;
        this.mBroadcastHelper = broadcastHelper;
        this.mSuspendPackageHelper = suspendPackageHelper;
    }

    String[] setDistractingPackageRestrictionsAsUser(Computer snapshot, String[] packageNames, final int restrictionFlags, final int userId, int callingUid) {
        Computer r1 = snapshot;
        if (ArrayUtils.isEmpty(packageNames) == false) goto L6;
        return packageNames;
    L6:
        if (restrictionFlags != 0) goto L8;
    L11:
        List<String> changedPackagesList = new ArrayList(packageNames.length);
        IntArray changedUids = new IntArray(packageNames.length);
        List<String> unactionedPackages = new ArrayList(packageNames.length);
        final ArraySet<String> changesToCommit = new ArraySet();
        if (restrictionFlags == 0) goto L14;
        boolean[] r5 = this.mSuspendPackageHelper.canSuspendPackageForUser(r1, packageNames, userId, callingUid);
    L15:
        boolean[] canRestrict = r5;
        int i = 0;
    L17:
        if (i >= packageNames.length) goto L29;
        String packageName = packageNames[i];
        PackageStateInternal packageState = r1.getPackageStateForInstalledAndFiltered(packageName, callingUid, userId);
        if (packageState != null) goto L21;
        Slog.w(PackageManagerServiceMonitorEx.TAG, "Could not find package setting for package: " + packageName + ". Skipping...");
        unactionedPackages.add(packageName);
    L28:
        i = i + 1;
        r1 = snapshot;
        goto L17
    L21:
        if (canRestrict != null) goto L23;
    L25:
        int oldDistractionFlags = packageState.getUserStateOrDefault(userId).getDistractionFlags();
        if (restrictionFlags == oldDistractionFlags) goto L28;
        changedPackagesList.add(packageName);
        changedUids.add(UserHandle.getUid(userId, packageState.getAppId()));
        changesToCommit.add(packageName);
        goto L28
    L23:
        if (canRestrict[i] == true) goto L25;
        unactionedPackages.add(packageName);
        goto L28
    L29:
        this.mPm.commitPackageStateMutation(null, new DistractingPackageHelper$$ExternalSyntheticLambda0(changesToCommit, userId, restrictionFlags));
        if (changedPackagesList.isEmpty() == true) goto L33;
        String[] changedPackages = (String[]) changedPackagesList.toArray(new String[changedPackagesList.size()]);
        BroadcastHelper r3 = this.mBroadcastHelper;
        PackageManagerService r2 = this.mPm;
        r2.getClass();
        r3.sendDistractingPackagesChanged(new DistractingPackageHelper$$ExternalSyntheticLambda1(r2), changedPackages, changedUids.toArray(), userId, restrictionFlags);
        this.mPm.scheduleWritePackageRestrictions(userId);
    L33:
        return (String[]) unactionedPackages.toArray(new String[0]);
    L14:
        r5 = null;
        goto L15
    L8:
        if (this.mSuspendPackageHelper.isSuspendAllowedForUser(r1, userId, callingUid) == true) goto L11;
        Slog.w(PackageManagerServiceMonitorEx.TAG, "Cannot restrict packages due to restrictions on user " + userId);
        return packageNames;
    }

    private static /* synthetic */ void lambda$setDistractingPackageRestrictionsAsUser$0(ArraySet changesToCommit, int userId, int restrictionFlags, PackageStateMutator mutator) {
        int size = changesToCommit.size();
        int index = 0;
    L3:
        if (index >= size) goto L6;
        mutator.forPackage((String) changesToCommit.valueAt(index)).userState(userId).setDistractionFlags(restrictionFlags);
        index = index + 1;
        goto L3
    }

    int[] getDistractingPackageRestrictionsAsUser(Computer snapshot, String[] packageNames, int userId, int callingUid) {
        int[] res = new int[packageNames.length];
        Arrays.fill(res, -1);
        if (ArrayUtils.isEmpty(packageNames) == false) goto L5;
        return res;
    L5:
        int i = 0;
    L7:
        if (i >= packageNames.length) goto L14;
        String packageName = packageNames[i];
        PackageStateInternal packageState = snapshot.getPackageStateForInstalledAndFiltered(packageName, callingUid, userId);
        if (packageState == null) goto L12;
        res[i] = packageState.getUserStateOrDefault(userId).getDistractionFlags();
    L12:
        i = i + 1;
        goto L7
    L14:
        return res;
    }

    void removeDistractingPackageRestrictions(Computer snapshot, String[] packagesToChange, final int userId) {
        if (ArrayUtils.isEmpty(packagesToChange) == false) goto L5;
        return;
    L5:
        final List<String> changedPackages = new ArrayList(packagesToChange.length);
        IntArray changedUids = new IntArray(packagesToChange.length);
        int i = 0;
    L7:
        if (i >= packagesToChange.length) goto L14;
        String packageName = packagesToChange[i];
        PackageStateInternal ps = snapshot.getPackageStateInternal(packageName);
        if (ps == null) goto L13;
        if (ps.getUserStateOrDefault(userId).getDistractionFlags() == 0) goto L13;
        changedPackages.add(ps.getPackageName());
        changedUids.add(UserHandle.getUid(userId, ps.getAppId()));
    L13:
        i = i + 1;
        goto L7
    L14:
        this.mPm.commitPackageStateMutation(null, new DistractingPackageHelper$$ExternalSyntheticLambda2(changedPackages, userId));
        if (changedPackages.isEmpty() == true) goto L18;
        String[] packageArray = (String[]) changedPackages.toArray(new String[changedPackages.size()]);
        BroadcastHelper r3 = this.mBroadcastHelper;
        PackageManagerService r2 = this.mPm;
        r2.getClass();
        r3.sendDistractingPackagesChanged(new DistractingPackageHelper$$ExternalSyntheticLambda1(r2), packageArray, changedUids.toArray(), userId, 0);
        this.mPm.scheduleWritePackageRestrictions(userId);
        return;
    }

    private static /* synthetic */ void lambda$removeDistractingPackageRestrictions$1(List changedPackages, int userId, PackageStateMutator mutator) {
        int index = 0;
    L4:
        if (index >= changedPackages.size()) goto L7;
        mutator.forPackage((String) changedPackages.get(index)).userState(userId).setDistractionFlags(0);
        index = index + 1;
        goto L4
    }
}
