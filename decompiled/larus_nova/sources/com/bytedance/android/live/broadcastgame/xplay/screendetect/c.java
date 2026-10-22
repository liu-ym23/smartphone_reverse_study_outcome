package com.bytedance.android.live.broadcastgame.xplay.screendetect;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes45.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final boolean f62362a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final long f62363b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f62364c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final long f62365d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final String f62366e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final String f62367f;

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof c) == false) goto L18;
        c r101 = (c) r100;
        if (this.f62362a == r101.f62362a) goto L8;
        return false;
    L8:
        if (this.f62363b == r101.f62363b) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.f62364c, r101.f62364c) == true) goto L12;
        return false;
    L12:
        if (this.f62365d == r101.f62365d) goto L14;
        return false;
    L14:
        if (Intrinsics.areEqual(this.f62366e, r101.f62366e) == true) goto L16;
        return false;
    L16:
        if (Intrinsics.areEqual(this.f62367f, r101.f62367f) == true) goto L28;
        return false;
    L28:
        return true;
    L18:
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v1, types: [int] */
    /* JADX WARN: Type inference failed for: r0v12 */
    /* JADX WARN: Type inference failed for: r0v13 */
    public final int hashCode() {
        boolean r100 = this.f62362a;
        ?? r101 = r100;
        if (r100 == false) goto L5;
        r101 = 1;
    L5:
        long r102 = this.f62363b;
        int r103 = ((r101 * 31) + ((int) (r102 ^ (r102 >>> 32)))) * 31;
        String r104 = this.f62364c;
        int r105 = 0;
        if (r104 == null) goto L8;
        int r106 = r104.hashCode();
    L9:
        long r107 = this.f62365d;
        int r108 = (((r103 + r106) * 31) + ((int) (r107 ^ (r107 >>> 32)))) * 31;
        String r109 = this.f62366e;
        if (r109 == null) goto L12;
        int r110 = r109.hashCode();
    L13:
        int r111 = (r108 + r110) * 31;
        String r112 = this.f62367f;
        if (r112 == null) goto L17;
        r105 = r112.hashCode();
    L17:
        return r111 + r105;
    L12:
        r110 = 0;
        goto L13
    L8:
        r106 = 0;
        goto L9
    }

    public final String toString() {
        return "ScreenDetectorParams(isAnchor=" + this.f62362a + ", roomId=" + this.f62363b + ", anchorId=" + this.f62364c + ", gameId=" + this.f62365d + ", appId=" + this.f62366e + ", gameName=" + this.f62367f + ")";
    }

    public c(boolean r100, long r101, String r102, long r103, String r104, String r105) {
        Intrinsics.checkNotNullParameter(r102, "anchorId");
        Intrinsics.checkNotNullParameter(r104, "appId");
        Intrinsics.checkNotNullParameter(r105, "gameName");
        this.f62362a = r100;
        this.f62363b = r101;
        this.f62364c = r102;
        this.f62365d = r103;
        this.f62366e = r104;
        this.f62367f = r105;
    }
}
