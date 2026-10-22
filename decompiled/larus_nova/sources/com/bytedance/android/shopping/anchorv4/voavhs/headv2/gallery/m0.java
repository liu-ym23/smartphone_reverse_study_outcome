package com.bytedance.android.shopping.anchorv4.voavhs.headv2.gallery;

/* JADX INFO: loaded from: classes13.dex */
public final class m0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final boolean f169342a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final boolean f169343b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final boolean f169344c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f169345d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final boolean f169346e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final boolean f169347f;

    public m0() {
        this(false, false, false, 0, false, 63);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof m0) == false) goto L18;
        m0 r101 = (m0) r100;
        if (this.f169342a == r101.f169342a) goto L8;
        return false;
    L8:
        if (this.f169343b == r101.f169343b) goto L10;
        return false;
    L10:
        if (this.f169344c == r101.f169344c) goto L12;
        return false;
    L12:
        if (this.f169345d == r101.f169345d) goto L14;
        return false;
    L14:
        if (this.f169346e == r101.f169346e) goto L16;
        return false;
    L16:
        if (this.f169347f == r101.f169347f) goto L28;
        return false;
    L28:
        return true;
    L18:
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v1, types: [int] */
    /* JADX WARN: Type inference failed for: r0v11, types: [int] */
    /* JADX WARN: Type inference failed for: r0v12 */
    /* JADX WARN: Type inference failed for: r0v13 */
    /* JADX WARN: Type inference failed for: r0v3, types: [int] */
    /* JADX WARN: Type inference failed for: r0v5, types: [int] */
    /* JADX WARN: Type inference failed for: r0v9, types: [int] */
    /* JADX WARN: Type inference failed for: r1v0 */
    /* JADX WARN: Type inference failed for: r1v1, types: [int] */
    /* JADX WARN: Type inference failed for: r1v2 */
    /* JADX WARN: Type inference failed for: r2v1, types: [int] */
    /* JADX WARN: Type inference failed for: r2v10 */
    /* JADX WARN: Type inference failed for: r2v11 */
    /* JADX WARN: Type inference failed for: r2v12 */
    /* JADX WARN: Type inference failed for: r2v13 */
    /* JADX WARN: Type inference failed for: r2v3, types: [int] */
    /* JADX WARN: Type inference failed for: r2v6, types: [int] */
    /* JADX WARN: Type inference failed for: r2v8 */
    /* JADX WARN: Type inference failed for: r2v9 */
    public final int hashCode() {
        boolean r100 = this.f169342a;
        ?? r101 = 1;
        ?? r102 = r100;
        if (r100 == false) goto L5;
        r102 = 1;
    L5:
        int r103 = r102 * 31;
        boolean r104 = this.f169343b;
        ?? r105 = r104;
        if (r104 == false) goto L8;
        r105 = 1;
    L8:
        int r106 = (r103 + r105) * 31;
        boolean r107 = this.f169344c;
        ?? r108 = r107;
        if (r107 == false) goto L11;
        r108 = 1;
    L11:
        int r109 = (((r106 + r108) * 31) + this.f169345d) * 31;
        boolean r110 = this.f169346e;
        ?? r111 = r110;
        if (r110 == false) goto L14;
        r111 = 1;
    L14:
        int r112 = (r109 + r111) * 31;
        boolean r113 = this.f169347f;
        if (r113 == true) goto L19;
        r101 = r113;
    L19:
        return r112 + r101;
    }

    public final String toString() {
        return "LayerItemConfig(enableZoom=" + this.f169342a + ", enableDrag=" + this.f169343b + ", enableSwitch=" + this.f169344c + ", scrollVisibilityType=" + this.f169345d + ", enableScrollTranslation=" + this.f169346e + ", enableHideOnEnter=" + this.f169347f + ")";
    }

    public m0(boolean r100, boolean r101, boolean r102, int r103, boolean r104, int r105) {
        if ((r105 & 1) == 0) goto L6;
        r100 = false;
    L6:
        if ((r105 & 2) == 0) goto L9;
        r101 = false;
    L9:
        if ((r105 & 4) == 0) goto L12;
        r102 = false;
    L12:
        if ((r105 & 8) == 0) goto L15;
        r103 = -1;
    L15:
        if ((r105 & 32) == 0) goto L17;
        r104 = true;
    L17:
        this.f169342a = r100;
        this.f169343b = r101;
        this.f169344c = r102;
        this.f169345d = r103;
        this.f169346e = false;
        this.f169347f = r104;
    }
}
