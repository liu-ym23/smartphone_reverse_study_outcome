package com.bytedance.android.live.profit.vip;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes47.dex */
public final class l {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final long f89147a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final py.k f89148b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final long f89149c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final c f89150d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final boolean f89151e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public boolean f89152f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final long f89153g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final int f89154h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final long f89155i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final String f89156j;

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof l) == false) goto L26;
        l r101 = (l) r100;
        if (this.f89147a == r101.f89147a) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.f89148b, r101.f89148b) == true) goto L10;
        return false;
    L10:
        if (this.f89149c == r101.f89149c) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f89150d, r101.f89150d) == true) goto L14;
        return false;
    L14:
        if (this.f89151e == r101.f89151e) goto L16;
        return false;
    L16:
        if (this.f89152f == r101.f89152f) goto L18;
        return false;
    L18:
        if (this.f89153g == r101.f89153g) goto L20;
        return false;
    L20:
        if (this.f89154h == r101.f89154h) goto L22;
        return false;
    L22:
        if (this.f89155i == r101.f89155i) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.f89156j, r101.f89156j) == true) goto L40;
        return false;
    L40:
        return true;
    L26:
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v10, types: [int] */
    /* JADX WARN: Type inference failed for: r0v16 */
    /* JADX WARN: Type inference failed for: r0v19 */
    /* JADX WARN: Type inference failed for: r1v8, types: [int] */
    /* JADX WARN: Type inference failed for: r4v2 */
    /* JADX WARN: Type inference failed for: r4v3, types: [int] */
    /* JADX WARN: Type inference failed for: r4v8 */
    public final int hashCode() {
        long r100 = this.f89147a;
        int r101 = ((int) (r100 ^ (r100 >>> 32))) * 31;
        py.k r102 = this.f89148b;
        int r103 = 0;
        if (r102 == null) goto L5;
        int r104 = r102.hashCode();
    L6:
        long r105 = this.f89149c;
        int r106 = (((r101 + r104) * 31) + ((int) (r105 ^ (r105 >>> 32)))) * 31;
        c r107 = this.f89150d;
        if (r107 == null) goto L9;
        int r108 = r107.hashCode();
    L10:
        int r109 = (r106 + r108) * 31;
        boolean r110 = this.f89151e;
        ?? r111 = 1;
        ?? r112 = r110;
        if (r110 == false) goto L13;
        r112 = 1;
    L13:
        int r113 = (r109 + r112) * 31;
        boolean r114 = this.f89152f;
        if (r114 == true) goto L17;
        r111 = r114;
    L17:
        int r115 = (r113 + r111) * 31;
        long r116 = this.f89153g;
        int r117 = (((r115 + ((int) (r116 ^ (r116 >>> 32)))) * 31) + this.f89154h) * 31;
        long r118 = this.f89155i;
        int r119 = (r117 + ((int) (r118 ^ (r118 >>> 32)))) * 31;
        String r120 = this.f89156j;
        if (r120 == null) goto L21;
        r103 = r120.hashCode();
    L21:
        return r119 + r103;
    L9:
        r108 = 0;
        goto L10
    L5:
        r104 = 0;
        goto L6
    }

    public final String toString() {
        return "VipEmojiData(id=" + this.f89147a + ", img=" + this.f89148b + ", emojiScaleType=" + this.f89149c + ", label=" + this.f89150d + ", isLock=" + this.f89151e + ", isNew=" + this.f89152f + ", type=" + this.f89153g + ", status=" + this.f89154h + ", canDelTime=" + this.f89155i + ", rejectReason=" + this.f89156j + ")";
    }

    public final long getType() {
        return this.f89153g;
    }

    public l(long r100, py.k r101, long r102, c r103, boolean r104, long r105, int r110, long r111, String r112) {
        this.f89147a = r100;
        this.f89148b = r101;
        this.f89149c = r102;
        this.f89150d = r103;
        this.f89151e = r104;
        this.f89152f = false;
        this.f89153g = r105;
        this.f89154h = r110;
        this.f89155i = r111;
        this.f89156j = r112;
    }
}
