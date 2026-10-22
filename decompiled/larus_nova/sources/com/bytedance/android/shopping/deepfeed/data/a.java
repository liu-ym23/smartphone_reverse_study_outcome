package com.bytedance.android.shopping.deepfeed.data;

/* JADX INFO: loaded from: classes13.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final boolean f173084a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f173085b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final boolean f173086c;

    public a() {
        this(false, 0, false, 7);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof a) == false) goto L12;
        a r101 = (a) r100;
        if (this.f173084a == r101.f173084a) goto L8;
        return false;
    L8:
        if (this.f173085b == r101.f173085b) goto L10;
        return false;
    L10:
        if (this.f173086c == r101.f173086c) goto L19;
        return false;
    L19:
        return true;
    L12:
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v1, types: [int] */
    /* JADX WARN: Type inference failed for: r0v5, types: [int] */
    /* JADX WARN: Type inference failed for: r0v6 */
    /* JADX WARN: Type inference failed for: r0v7 */
    /* JADX WARN: Type inference failed for: r1v0 */
    /* JADX WARN: Type inference failed for: r1v1, types: [int] */
    /* JADX WARN: Type inference failed for: r1v2 */
    public final int hashCode() {
        boolean r100 = this.f173084a;
        ?? r101 = 1;
        ?? r102 = r100;
        if (r100 == false) goto L5;
        r102 = 1;
    L5:
        int r103 = ((r102 * 31) + this.f173085b) * 31;
        boolean r104 = this.f173086c;
        if (r104 == true) goto L10;
        r101 = r104;
    L10:
        return r103 + r101;
    }

    public final String toString() {
        return "DeepFeedCardUpdateState(insertCardToFullScreen=" + this.f173084a + ", insertCardPosition=" + this.f173085b + ", updateCard=" + this.f173086c + ")";
    }

    public a(boolean r100, int r101, boolean r102, int r103) {
        if ((r103 & 1) == 0) goto L6;
        r100 = false;
    L6:
        if ((r103 & 2) == 0) goto L9;
        r101 = -1;
    L9:
        if ((r103 & 4) == 0) goto L11;
        r102 = false;
    L11:
        this.f173084a = r100;
        this.f173085b = r101;
        this.f173086c = r102;
    }
}
