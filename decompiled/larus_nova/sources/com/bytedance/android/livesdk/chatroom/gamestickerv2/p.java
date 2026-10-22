package com.bytedance.android.livesdk.chatroom.gamestickerv2;

/* JADX INFO: loaded from: classes7.dex */
public final class p {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f106359a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f106360b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f106361c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f106362d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public boolean f106363e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public boolean f106364f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public boolean f106365g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public boolean f106366h;

    public p() {
        this(0);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof p) == false) goto L22;
        p r101 = (p) r100;
        if (this.f106359a == r101.f106359a) goto L8;
        return false;
    L8:
        if (this.f106360b == r101.f106360b) goto L10;
        return false;
    L10:
        if (this.f106361c == r101.f106361c) goto L12;
        return false;
    L12:
        if (this.f106362d == r101.f106362d) goto L14;
        return false;
    L14:
        if (this.f106363e == r101.f106363e) goto L16;
        return false;
    L16:
        if (this.f106364f == r101.f106364f) goto L18;
        return false;
    L18:
        if (this.f106365g == r101.f106365g) goto L20;
        return false;
    L20:
        if (this.f106366h == r101.f106366h) goto L34;
        return false;
    L34:
        return true;
    L22:
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v10, types: [int] */
    /* JADX WARN: Type inference failed for: r0v12, types: [int] */
    /* JADX WARN: Type inference failed for: r0v14, types: [int] */
    /* JADX WARN: Type inference failed for: r0v8, types: [int] */
    /* JADX WARN: Type inference failed for: r1v10 */
    /* JADX WARN: Type inference failed for: r1v11 */
    /* JADX WARN: Type inference failed for: r1v12 */
    /* JADX WARN: Type inference failed for: r1v13 */
    /* JADX WARN: Type inference failed for: r1v14 */
    /* JADX WARN: Type inference failed for: r1v15 */
    /* JADX WARN: Type inference failed for: r1v4, types: [int] */
    /* JADX WARN: Type inference failed for: r1v6, types: [int] */
    /* JADX WARN: Type inference failed for: r1v8, types: [int] */
    /* JADX WARN: Type inference failed for: r2v0 */
    /* JADX WARN: Type inference failed for: r2v1, types: [int] */
    /* JADX WARN: Type inference failed for: r2v2 */
    public final int hashCode() {
        int r100 = ((((((this.f106359a * 31) + this.f106360b) * 31) + this.f106361c) * 31) + this.f106362d) * 31;
        boolean r101 = this.f106363e;
        ?? r102 = 1;
        ?? r103 = r101;
        if (r101 == false) goto L5;
        r103 = 1;
    L5:
        int r104 = (r100 + r103) * 31;
        boolean r105 = this.f106364f;
        ?? r106 = r105;
        if (r105 == false) goto L8;
        r106 = 1;
    L8:
        int r107 = (r104 + r106) * 31;
        boolean r108 = this.f106365g;
        ?? r109 = r108;
        if (r108 == false) goto L11;
        r109 = 1;
    L11:
        int r110 = (r107 + r109) * 31;
        boolean r111 = this.f106366h;
        if (r111 == true) goto L16;
        r102 = r111;
    L16:
        return r110 + r102;
    }

    public final String toString() {
        return "GameStickerUIParams(topMargin=" + this.f106359a + ", leftMargin=" + this.f106360b + ", height=" + this.f106361c + ", width=" + this.f106362d + ", firstFrame=" + this.f106363e + ", hasStickerView=" + this.f106364f + ", stickerViewVisible=" + this.f106365g + ", layouted=" + this.f106366h + ")";
    }

    public p(int r100) {
        this.f106359a = 0;
        this.f106360b = 0;
        this.f106361c = 0;
        this.f106362d = 0;
        this.f106363e = false;
        this.f106364f = false;
        this.f106365g = true;
        this.f106366h = false;
    }
}
