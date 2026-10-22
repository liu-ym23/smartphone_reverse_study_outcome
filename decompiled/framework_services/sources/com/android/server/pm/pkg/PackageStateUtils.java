package com.android.server.pm.pkg;

import android.content.pm.ComponentInfo;
import android.util.SparseArray;
import com.android.internal.pm.parsing.pkg.AndroidPackageInternal;
import com.android.internal.pm.pkg.component.ParsedMainComponent;
import com.android.server.storage.DeviceStorageMonitorServiceSmtEx;

/* JADX INFO: loaded from: classes2.dex */
public class PackageStateUtils {
    public PackageStateUtils() {
    }

    public static boolean isMatch(PackageState packageState, long flags) {
        if ((DeviceStorageMonitorServiceSmtEx.TrafficStats.MB_IN_BYTES & flags) != 0) goto L5;
        return true;
    L5:
        return packageState.isSystem();
    }

    public static int[] queryInstalledUsers(PackageStateInternal pkgState, int[] users, boolean installed) {
        int num = 0;
        int r1 = users.length;
        int r2 = 0;
        int r3 = 0;
    L3:
        if (r3 >= r1) goto L8;
        if (pkgState.getUserStateOrDefault(users[r3]).isInstalled() != installed) goto L7;
        num = num + 1;
    L7:
        r3 = r3 + 1;
        goto L3
    L8:
        int[] res = new int[num];
        int num2 = 0;
        int r4 = users.length;
    L9:
        if (r2 >= r4) goto L14;
        int user = users[r2];
        if (pkgState.getUserStateOrDefault(user).isInstalled() != installed) goto L13;
        res[num2] = user;
        num2 = num2 + 1;
    L13:
        r2 = r2 + 1;
        goto L9
    L14:
        return res;
    }

    public static boolean isEnabledAndMatches(PackageStateInternal packageState, ComponentInfo componentInfo, long flags, int userId) {
        if (packageState != null) goto L5;
        return false;
    L5:
        PackageUserStateInternal userState = packageState.getUserStateOrDefault(userId);
        return PackageUserStateUtils.isMatch(userState, componentInfo, flags);
    }

    public static boolean isEnabledAndMatches(PackageStateInternal packageState, ParsedMainComponent component, long flags, int userId) {
        if (packageState != null) goto L5;
        return false;
    L5:
        AndroidPackageInternal r1 = packageState.getPkg();
        if (r1 != null) goto L8;
        return false;
    L8:
        PackageUserStateInternal userState = packageState.getUserStateOrDefault(userId);
        return PackageUserStateUtils.isMatch(userState, packageState.isSystem(), r1.isEnabled(), component, flags);
    }

    public static long getEarliestFirstInstallTime(SparseArray<? extends PackageUserStateInternal> userStatesInternal) {
        if (userStatesInternal != null) goto L5;
    L21:
        return 0;
    L5:
        if (userStatesInternal.size() == 0) goto L21;
        long earliestFirstInstallTime = Long.MAX_VALUE;
        int i = 0;
    L9:
        if (i >= userStatesInternal.size()) goto L17;
        long firstInstallTime = userStatesInternal.valueAt(i).getFirstInstallTimeMillis();
        if (firstInstallTime == 0) goto L15;
        if (firstInstallTime >= earliestFirstInstallTime) goto L15;
        earliestFirstInstallTime = firstInstallTime;
    L15:
        i = i + 1;
        goto L9
    L17:
        if (earliestFirstInstallTime != Long.MAX_VALUE) goto L20;
        return 0;
    L20:
        return earliestFirstInstallTime;
    }
}
