package com.stepos.core.ota.domain;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class UserUninstallPolicy {
    public static final UserUninstallPolicy INSTANCE = new UserUninstallPolicy();

    private UserUninstallPolicy() {
    }

    public final boolean acceptInstalledOverlay(boolean z) {
        return !z;
    }

    public final boolean allowBackgroundDownload(boolean z) {
        return !z;
    }

    public final boolean allowPresetRestore(boolean z) {
        return !z;
    }

    public final boolean keepSnapshotKey(boolean z) {
        return !z;
    }
}
