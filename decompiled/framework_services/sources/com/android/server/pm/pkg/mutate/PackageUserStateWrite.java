package com.android.server.pm.pkg.mutate;

import android.content.ComponentName;
import android.content.pm.UserPackage;
import android.content.pm.overlay.OverlayPaths;
import com.android.server.pm.pkg.SuspendParams;

/* JADX INFO: loaded from: classes2.dex */
public interface PackageUserStateWrite {
    PackageUserStateWrite putSuspendParams(UserPackage r1, SuspendParams r2);

    PackageUserStateWrite removeSuspension(UserPackage r1);

    PackageUserStateWrite setComponentLabelIcon(ComponentName r1, String r2, Integer r3);

    PackageUserStateWrite setDistractionFlags(int r1);

    PackageUserStateWrite setHarmfulAppWarning(String r1);

    PackageUserStateWrite setHidden(boolean r1);

    PackageUserStateWrite setInstalled(boolean r1);

    PackageUserStateWrite setMinAspectRatio(int r1);

    PackageUserStateWrite setNotLaunched(boolean r1);

    PackageUserStateWrite setOverlayPaths(OverlayPaths r1);

    PackageUserStateWrite setOverlayPathsForLibrary(String r1, OverlayPaths r2);

    PackageUserStateWrite setSplashScreenTheme(String r1);

    PackageUserStateWrite setStopped(boolean r1);

    PackageUserStateWrite setUninstallReason(int r1);
}
