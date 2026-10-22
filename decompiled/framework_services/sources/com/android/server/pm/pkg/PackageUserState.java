package com.android.server.pm.pkg;

import android.annotation.SystemApi;
import android.content.pm.overlay.OverlayPaths;
import android.util.ArraySet;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
@SystemApi(client = SystemApi.Client.SYSTEM_SERVER)
public interface PackageUserState {
    public static final PackageUserState DEFAULT = null;

    boolean dataExists();

    OverlayPaths getAllOverlayPaths();

    ArchiveState getArchiveState();

    long getCeDataInode();

    long getDeDataInode();

    ArraySet<String> getDisabledComponents();

    int getDistractionFlags();

    ArraySet<String> getEnabledComponents();

    int getEnabledState();

    long getFirstInstallTimeMillis();

    String getHarmfulAppWarning();

    int getInstallReason();

    String getLastDisableAppCaller();

    int getMinAspectRatio();

    OverlayPaths getOverlayPaths();

    Map<String, OverlayPaths> getSharedLibraryOverlayPaths();

    String getSplashScreenTheme();

    int getUninstallReason();

    boolean isComponentDisabled(String r1);

    boolean isComponentEnabled(String r1);

    boolean isHidden();

    boolean isInstalled();

    boolean isInstantApp();

    boolean isNotLaunched();

    boolean isQuarantined();

    boolean isStopped();

    boolean isSuspended();

    boolean isVirtualPreload();

    static {
        DEFAULT = PackageUserStateInternal.DEFAULT;
    }
}
