package com.bytedance.android.live.broadcastgame.opengame.message;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes45.dex */
public final class r implements com.bytedance.android.live.broadcastgame.v {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f60271a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final long f60272b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f60273c;

    public static final class a {
    }

    static {
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof r) == false) goto L12;
        r r101 = (r) r100;
        if (Intrinsics.areEqual(this.f60271a, r101.f60271a) == true) goto L8;
        return false;
    L8:
        if (this.f60272b == r101.f60272b) goto L10;
        return false;
    L10:
        if (this.f60273c == r101.f60273c) goto L19;
        return false;
    L19:
        return true;
    L12:
        return false;
    }

    public final int hashCode() {
        String r100 = this.f60271a;
        if (r100 == null) goto L5;
        int r101 = r100.hashCode();
    L6:
        long r102 = this.f60272b;
        return (((r101 * 31) + ((int) (r102 ^ (r102 >>> 32)))) * 31) + this.f60273c;
    L5:
        r101 = 0;
        goto L6
    }

    public final String toString() {
        return "DiamondPay(appId=" + this.f60271a + ", startId=" + this.f60272b + ", diamond=" + this.f60273c + ")";
    }

    public r(String r100, long r101, int r102) {
        this.f60271a = r100;
        this.f60272b = r101;
        this.f60273c = r102;
    }
}
