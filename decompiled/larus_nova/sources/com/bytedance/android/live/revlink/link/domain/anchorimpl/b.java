package com.bytedance.android.live.revlink.link.domain.anchorimpl;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes47.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f98425a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f98426b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final boolean f98427c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final boolean f98428d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final String f98429e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final boolean f98430f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final boolean f98431g;

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof b) == false) goto L20;
        b r101 = (b) r100;
        if (Intrinsics.areEqual(this.f98425a, r101.f98425a) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.f98426b, r101.f98426b) == true) goto L10;
        return false;
    L10:
        if (this.f98427c == r101.f98427c) goto L12;
        return false;
    L12:
        if (this.f98428d == r101.f98428d) goto L14;
        return false;
    L14:
        if (Intrinsics.areEqual(this.f98429e, r101.f98429e) == true) goto L16;
        return false;
    L16:
        if (this.f98430f == r101.f98430f) goto L18;
        return false;
    L18:
        if (this.f98431g == r101.f98431g) goto L31;
        return false;
    L31:
        return true;
    L20:
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v12, types: [int] */
    /* JADX WARN: Type inference failed for: r0v14, types: [int] */
    /* JADX WARN: Type inference failed for: r0v6, types: [int] */
    /* JADX WARN: Type inference failed for: r1v3, types: [int] */
    /* JADX WARN: Type inference failed for: r1v5 */
    /* JADX WARN: Type inference failed for: r1v7 */
    /* JADX WARN: Type inference failed for: r2v11 */
    /* JADX WARN: Type inference failed for: r2v12 */
    /* JADX WARN: Type inference failed for: r2v4, types: [int] */
    /* JADX WARN: Type inference failed for: r2v6, types: [int] */
    /* JADX WARN: Type inference failed for: r2v8 */
    /* JADX WARN: Type inference failed for: r2v9 */
    /* JADX WARN: Type inference failed for: r3v0 */
    /* JADX WARN: Type inference failed for: r3v1, types: [int] */
    /* JADX WARN: Type inference failed for: r3v2 */
    public final int hashCode() {
        String r100 = this.f98425a;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = r102 * 31;
        String r104 = this.f98426b;
        if (r104 == null) goto L9;
        int r105 = r104.hashCode();
    L10:
        int r106 = (r103 + r105) * 31;
        boolean r107 = this.f98427c;
        ?? r108 = 1;
        ?? r109 = r107;
        if (r107 == false) goto L13;
        r109 = 1;
    L13:
        int r110 = (r106 + r109) * 31;
        boolean r111 = this.f98428d;
        ?? r112 = r111;
        if (r111 == false) goto L16;
        r112 = 1;
    L16:
        int r113 = (r110 + r112) * 31;
        String r114 = this.f98429e;
        if (r114 == null) goto L19;
        r101 = r114.hashCode();
    L19:
        int r115 = (r113 + r101) * 31;
        boolean r116 = this.f98430f;
        ?? r117 = r116;
        if (r116 == false) goto L22;
        r117 = 1;
    L22:
        int r118 = (r115 + r117) * 31;
        boolean r119 = this.f98431g;
        if (r119 == true) goto L27;
        r108 = r119;
    L27:
        return r118 + r108;
    L9:
        r105 = 0;
        goto L10
    L5:
        r102 = 0;
        goto L6
    }

    public final String toString() {
        return "BackgroundConfig(topBg=" + this.f98425a + ", bottomBg=" + this.f98426b + ", isTopAnim=" + this.f98427c + ", isBottomAnim=" + this.f98428d + ", fullBg=" + this.f98429e + ", needLeftBg=" + this.f98430f + ", needRightBg=" + this.f98431g + ")";
    }

    public b(String r100, String r101, boolean r102, boolean r103, boolean r104, boolean r105) {
        Intrinsics.checkNotNullParameter(r100, "topBg");
        Intrinsics.checkNotNullParameter(r101, "bottomBg");
        this.f98425a = r100;
        this.f98426b = r101;
        this.f98427c = r102;
        this.f98428d = r103;
        this.f98429e = null;
        this.f98430f = r104;
        this.f98431g = r105;
    }
}
