package com.bytedance.android.shopping.deepfeed.slice.view;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes13.dex */
public final class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f173525a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f173526b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f173527c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final boolean f173528d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final int f173529e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final int f173530f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final boolean f173531g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final int f173532h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final boolean f173533i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final Float f173534j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final boolean f173535k;

    public f() {
        this(0);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof f) == false) goto L28;
        f r101 = (f) r100;
        if (Intrinsics.areEqual(this.f173525a, r101.f173525a) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.f173526b, r101.f173526b) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.f173527c, r101.f173527c) == true) goto L12;
        return false;
    L12:
        if (this.f173528d == r101.f173528d) goto L14;
        return false;
    L14:
        if (this.f173529e == r101.f173529e) goto L16;
        return false;
    L16:
        if (this.f173530f == r101.f173530f) goto L18;
        return false;
    L18:
        if (this.f173531g == r101.f173531g) goto L20;
        return false;
    L20:
        if (this.f173532h == r101.f173532h) goto L22;
        return false;
    L22:
        if (this.f173533i == r101.f173533i) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.f173534j, r101.f173534j) == true) goto L26;
        return false;
    L26:
        if (this.f173535k == r101.f173535k) goto L43;
        return false;
    L43:
        return true;
    L28:
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v22, types: [int] */
    /* JADX WARN: Type inference failed for: r0v8, types: [int] */
    /* JADX WARN: Type inference failed for: r2v11, types: [int] */
    /* JADX WARN: Type inference failed for: r2v14, types: [int] */
    /* JADX WARN: Type inference failed for: r2v16 */
    /* JADX WARN: Type inference failed for: r2v17 */
    /* JADX WARN: Type inference failed for: r2v18 */
    /* JADX WARN: Type inference failed for: r2v21 */
    /* JADX WARN: Type inference failed for: r2v22 */
    /* JADX WARN: Type inference failed for: r2v23 */
    /* JADX WARN: Type inference failed for: r2v7, types: [int] */
    /* JADX WARN: Type inference failed for: r3v0 */
    /* JADX WARN: Type inference failed for: r3v1, types: [int] */
    /* JADX WARN: Type inference failed for: r3v2 */
    public final int hashCode() {
        String r100 = this.f173525a;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = r102 * 31;
        String r104 = this.f173526b;
        if (r104 == null) goto L9;
        int r105 = r104.hashCode();
    L10:
        int r106 = (r103 + r105) * 31;
        String r107 = this.f173527c;
        if (r107 == null) goto L13;
        int r108 = r107.hashCode();
    L14:
        int r109 = (r106 + r108) * 31;
        boolean r110 = this.f173528d;
        ?? r111 = 1;
        ?? r112 = r110;
        if (r110 == false) goto L17;
        r112 = 1;
    L17:
        int r113 = (((((r109 + r112) * 31) + this.f173529e) * 31) + this.f173530f) * 31;
        boolean r114 = this.f173531g;
        ?? r115 = r114;
        if (r114 == false) goto L20;
        r115 = 1;
    L20:
        int r116 = (((r113 + r115) * 31) + this.f173532h) * 31;
        boolean r117 = this.f173533i;
        ?? r118 = r117;
        if (r117 == false) goto L23;
        r118 = 1;
    L23:
        int r119 = (r116 + r118) * 31;
        Float r120 = this.f173534j;
        if (r120 == null) goto L26;
        r101 = r120.hashCode();
    L26:
        int r121 = (r119 + r101) * 31;
        boolean r122 = this.f173535k;
        if (r122 == true) goto L31;
        r111 = r122;
    L31:
        return r121 + r111;
    L13:
        r108 = 0;
        goto L14
    L9:
        r105 = 0;
        goto L10
    L5:
        r102 = 0;
        goto L6
    }

    public final String toString() {
        return "VideoViewData(vid=" + this.f173525a + ", src=" + this.f173526b + ", image=" + this.f173527c + ", mute=" + this.f173528d + ", width=" + this.f173529e + ", height=" + this.f173530f + ", fullScreen=" + this.f173531g + ", topMargin=" + this.f173532h + ", visible=" + this.f173533i + ", progress=" + this.f173534j + ", isPlaying=" + this.f173535k + ")";
    }

    public /* synthetic */ f(int r110) {
        this("", "", "", true, 0, 0, true, 0, false, null, false);
    }

    public f(String r100, String r101, String r102, boolean r103, int r104, int r105, boolean r106, int r107, boolean r110, Float r111, boolean r112) {
        Intrinsics.checkNotNullParameter(r100, "vid");
        Intrinsics.checkNotNullParameter(r101, "src");
        Intrinsics.checkNotNullParameter(r102, "image");
        this.f173525a = r100;
        this.f173526b = r101;
        this.f173527c = r102;
        this.f173528d = r103;
        this.f173529e = r104;
        this.f173530f = r105;
        this.f173531g = r106;
        this.f173532h = r107;
        this.f173533i = r110;
        this.f173534j = r111;
        this.f173535k = r112;
    }
}
