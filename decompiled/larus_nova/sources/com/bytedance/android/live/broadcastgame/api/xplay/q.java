package com.bytedance.android.live.broadcastgame.api.xplay;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes45.dex */
public final class q {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public String f59514a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public String f59515b;

    public q() {
        this(0);
    }

    public final String toString() {
        return "XplayPodRTCInfo(wtnToken=" + this.f59514a + ", wtnStreamId=" + this.f59515b + ")";
    }

    public final int hashCode() {
        return (this.f59514a.hashCode() * 31) + this.f59515b.hashCode();
    }

    public q(int r100) {
        Intrinsics.checkNotNullParameter("", "wtnToken");
        Intrinsics.checkNotNullParameter("", "wtnStreamId");
        this.f59514a = "";
        this.f59515b = "";
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if (r100 == null) goto L8;
        Class<?> r101 = r100.getClass();
    L10:
        if ((!Intrinsics.areEqual(q.class, r101)) == false) goto L12;
        return false;
    L12:
        if (r100 == null) goto L21;
        q r102 = (q) r100;
        if ((!Intrinsics.areEqual(this.f59514a, r102.f59514a)) == false) goto L17;
        return false;
    L17:
        if ((!Intrinsics.areEqual(this.f59515b, r102.f59515b)) == false) goto L19;
        return false;
    L19:
        return true;
    L21:
        throw new NullPointerException("null cannot be cast to non-null type com.bytedance.android.live.broadcastgame.api.xplay.XplayPodRTCInfo");
    L8:
        r101 = null;
        goto L10
    }
}
