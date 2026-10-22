package com.bytedance.android.live.broadcastgame.opengame.message;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes45.dex */
public final class m0 implements com.bytedance.android.live.broadcastgame.v {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final long f60251a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f60252b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final long f60253c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f60254d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final int f60255e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final int f60256f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final String f60257g;

    public static final class a {
    }

    static {
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof m0) == false) goto L18;
        m0 r101 = (m0) r100;
        if (Intrinsics.areEqual(this.f60252b, r101.f60252b) == true) goto L8;
        return false;
    L8:
        if (this.f60253c == r101.f60253c) goto L10;
        return false;
    L10:
        if (this.f60254d == r101.f60254d) goto L12;
        return false;
    L12:
        if (this.f60255e == r101.f60255e) goto L14;
        return false;
    L14:
        if (this.f60256f == r101.f60256f) goto L16;
        return false;
    L16:
        if (Intrinsics.areEqual(this.f60257g, r101.f60257g) == true) goto L28;
        return false;
    L28:
        return true;
    L18:
        return false;
    }

    public final int hashCode() {
        String r100 = this.f60252b;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        long r103 = this.f60253c;
        int r104 = ((((((((r102 * 31) + ((int) (r103 ^ (r103 >>> 32)))) * 31) + this.f60254d) * 31) + this.f60255e) * 31) + this.f60256f) * 31;
        String r105 = this.f60257g;
        if (r105 == null) goto L10;
        r101 = r105.hashCode();
    L10:
        return r104 + r101;
    L5:
        r102 = 0;
        goto L6
    }

    public final String toString() {
        return "OpenReward(appId=" + this.f60252b + ", startId=" + this.f60253c + ", rewardId=" + this.f60254d + ", rewardCount=" + this.f60255e + ", rewardDiamonds=" + this.f60256f + ", rewardName=" + this.f60257g + ")";
    }

    public m0(String r100, long r101, int r102, int r103, int r104, String r105) {
        this.f60252b = r100;
        this.f60253c = r101;
        this.f60254d = r102;
        this.f60255e = r103;
        this.f60256f = r104;
        this.f60257g = r105;
        this.f60251a = System.currentTimeMillis();
    }
}
