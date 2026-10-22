package com.bytedance.android.livesdk.interactivity.medialink.contract;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes9.dex */
public final class g implements x32.d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final long f138001a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final com.bytedance.android.livesdk.interactivity.medialink.widget.presenter.b f138002b;

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof g) == false) goto L10;
        g r101 = (g) r100;
        if (this.f138001a == r101.f138001a) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.f138002b, r101.f138002b) == true) goto L16;
        return false;
    L16:
        return true;
    L10:
        return false;
    }

    public final int hashCode() {
        long r100 = this.f138001a;
        int r101 = ((int) (r100 ^ (r100 >>> 32))) * 31;
        com.bytedance.android.livesdk.interactivity.medialink.widget.presenter.b r102 = this.f138002b;
        if (r102 == null) goto L5;
        int r103 = r102.hashCode();
    L7:
        return r101 + r103;
    L5:
        r103 = 0;
        goto L7
    }

    public final String toString() {
        return "MediaMultiLinkAudienceLaunchContext(channelID=" + this.f138001a + ", source=" + this.f138002b + ")";
    }

    public g(long r100, com.bytedance.android.livesdk.interactivity.medialink.widget.presenter.b r101) {
        Intrinsics.checkNotNullParameter(r101, "source");
        this.f138001a = r100;
        this.f138002b = r101;
    }
}
