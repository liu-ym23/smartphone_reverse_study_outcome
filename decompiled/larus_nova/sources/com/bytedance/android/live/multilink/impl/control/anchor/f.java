package com.bytedance.android.live.multilink.impl.control.anchor;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes46.dex */
public final class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final boolean f83388a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final boolean f83389b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f83390c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final boolean f83391d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final String f83392e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final boolean f83393f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final Integer f83394g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final Integer f83395h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final Integer f83396i;

    public f() {
        this(false, false, -1, false, null, false, null, null, null);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof f) == false) goto L24;
        f r101 = (f) r100;
        if (this.f83388a == r101.f83388a) goto L8;
        return false;
    L8:
        if (this.f83389b == r101.f83389b) goto L10;
        return false;
    L10:
        if (this.f83390c == r101.f83390c) goto L12;
        return false;
    L12:
        if (this.f83391d == r101.f83391d) goto L14;
        return false;
    L14:
        if (Intrinsics.areEqual(this.f83392e, r101.f83392e) == true) goto L16;
        return false;
    L16:
        if (this.f83393f == r101.f83393f) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.f83394g, r101.f83394g) == true) goto L20;
        return false;
    L20:
        if (Intrinsics.areEqual(this.f83395h, r101.f83395h) == true) goto L22;
        return false;
    L22:
        if (Intrinsics.areEqual(this.f83396i, r101.f83396i) == true) goto L37;
        return false;
    L37:
        return true;
    L24:
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v1, types: [int] */
    /* JADX WARN: Type inference failed for: r0v11, types: [int] */
    /* JADX WARN: Type inference failed for: r0v18 */
    /* JADX WARN: Type inference failed for: r0v19 */
    /* JADX WARN: Type inference failed for: r0v3, types: [int] */
    /* JADX WARN: Type inference failed for: r0v7, types: [int] */
    /* JADX WARN: Type inference failed for: r1v0 */
    /* JADX WARN: Type inference failed for: r1v1, types: [int] */
    /* JADX WARN: Type inference failed for: r1v11 */
    /* JADX WARN: Type inference failed for: r2v1, types: [int] */
    /* JADX WARN: Type inference failed for: r2v10 */
    /* JADX WARN: Type inference failed for: r2v11 */
    /* JADX WARN: Type inference failed for: r2v12 */
    /* JADX WARN: Type inference failed for: r2v13 */
    /* JADX WARN: Type inference failed for: r2v4, types: [int] */
    public final int hashCode() {
        boolean r100 = this.f83388a;
        ?? r101 = 1;
        ?? r102 = r100;
        if (r100 == false) goto L5;
        r102 = 1;
    L5:
        int r103 = r102 * 31;
        boolean r104 = this.f83389b;
        ?? r105 = r104;
        if (r104 == false) goto L8;
        r105 = 1;
    L8:
        int r106 = (((r103 + r105) * 31) + this.f83390c) * 31;
        boolean r107 = this.f83391d;
        ?? r108 = r107;
        if (r107 == false) goto L11;
        r108 = 1;
    L11:
        int r109 = (r106 + r108) * 31;
        String r110 = this.f83392e;
        int r111 = 0;
        if (r110 == null) goto L14;
        int r112 = r110.hashCode();
    L15:
        int r113 = (r109 + r112) * 31;
        boolean r114 = this.f83393f;
        if (r114 == true) goto L19;
        r101 = r114;
    L19:
        int r115 = (r113 + r101) * 31;
        Integer r116 = this.f83394g;
        if (r116 == null) goto L22;
        int r117 = r116.hashCode();
    L23:
        int r118 = (r115 + r117) * 31;
        Integer r119 = this.f83395h;
        if (r119 == null) goto L26;
        int r120 = r119.hashCode();
    L27:
        int r121 = (r118 + r120) * 31;
        Integer r122 = this.f83396i;
        if (r122 == null) goto L31;
        r111 = r122.hashCode();
    L31:
        return r121 + r111;
    L26:
        r120 = 0;
        goto L27
    L22:
        r117 = 0;
        goto L23
    L14:
        r112 = 0;
        goto L15
    }

    public final String toString() {
        return "InitParams(isOpenAudioScence=" + this.f83388a + ", isOpenByServer=" + this.f83389b + ", subMode=" + this.f83390c + ", subModeToUILayout=" + this.f83391d + ", requestPage=" + this.f83392e + ", ignoreAnyMode=" + this.f83393f + ", uiLayout=" + this.f83394g + ", toScene=" + this.f83395h + ", initSource=" + this.f83396i + ")";
    }

    public f(boolean r100, boolean r101, int r102, boolean r103, String r104, boolean r105, Integer r106, Integer r107, Integer r108) {
        this.f83388a = r100;
        this.f83389b = r101;
        this.f83390c = r102;
        this.f83391d = r103;
        this.f83392e = r104;
        this.f83393f = r105;
        this.f83394g = r106;
        this.f83395h = r107;
        this.f83396i = r108;
    }
}
