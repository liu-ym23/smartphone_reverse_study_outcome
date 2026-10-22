package com.android.server.pm;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.ParceledListSlice;
import android.pico.utils.IExtBase;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public interface IExtComputerEngine extends IExtBase {
    ParceledListSlice<PackageInfo> getInstalledPackagesUncheck(long r1, int r3);

    void recordGetInstallAppsBehavior(boolean r1, int r2);

    boolean skipHoldingPermissionsForXts(String r1);

    default boolean checkGetInstallAppsPermission(Context context, int userId, int callingUid, long flags) {
        return true;
    }

    default boolean shouldDelayDropStalePreferred(Intent intent, String resolvedType) {
        return false;
    }

    default int recordFirstDelayedDropIndex(int delayedIndex, int currentIndex) {
        if (delayedIndex == (-1)) goto L6;
        return delayedIndex;
    L6:
        return currentIndex;
    }

    default boolean applyDelayedStalePreferredDrop(ComputerEngine computerEngine, int delayedIndex, PreferredIntentResolver pir, List<PreferredActivity> prefs, Intent intent, String resolvedType) {
        return false;
    }
}
