package com.bytedance.android.shopping.commentv3.audio;

/* JADX INFO: loaded from: classes13.dex */
public final class y {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final boolean f172652a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final boolean f172653b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final boolean f172654c;

    public y() {
        this(false, 7);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof y) == false) goto L12;
        y r101 = (y) r100;
        if (this.f172652a == r101.f172652a) goto L8;
        return false;
    L8:
        if (this.f172653b == r101.f172653b) goto L10;
        return false;
    L10:
        if (this.f172654c == r101.f172654c) goto L19;
        return false;
    L19:
        return true;
    L12:
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v1, types: [int] */
    /* JADX WARN: Type inference failed for: r0v3, types: [int] */
    /* JADX WARN: Type inference failed for: r0v5, types: [int] */
    /* JADX WARN: Type inference failed for: r0v6 */
    /* JADX WARN: Type inference failed for: r0v7 */
    /* JADX WARN: Type inference failed for: r1v0 */
    /* JADX WARN: Type inference failed for: r1v1, types: [int] */
    /* JADX WARN: Type inference failed for: r1v2 */
    /* JADX WARN: Type inference failed for: r2v1, types: [int] */
    /* JADX WARN: Type inference failed for: r2v3 */
    /* JADX WARN: Type inference failed for: r2v4 */
    public final int hashCode() {
        boolean r100 = this.f172652a;
        ?? r101 = 1;
        ?? r102 = r100;
        if (r100 == false) goto L5;
        r102 = 1;
    L5:
        int r103 = r102 * 31;
        boolean r104 = this.f172653b;
        ?? r105 = r104;
        if (r104 == false) goto L8;
        r105 = 1;
    L8:
        int r106 = (r103 + r105) * 31;
        boolean r107 = this.f172654c;
        if (r107 == true) goto L13;
        r101 = r107;
    L13:
        return r106 + r101;
    }

    public final String toString() {
        return "StopOptions(executeOnStop=" + this.f172652a + ", releasePlayer=" + this.f172653b + ", restoreExternalAudio=" + this.f172654c + ")";
    }

    public /* synthetic */ y(boolean r100, int r101) {
        boolean r102 = true;
        if ((r101 & 1) == 0) goto L6;
        r100 = true;
    L6:
        if ((r101 & 2) == 0) goto L8;
        boolean r103 = true;
    L10:
        if ((r101 & 4) != 0) goto L13;
        r102 = false;
    L13:
        this(r100, r103, r102);
        return;
    L8:
        r103 = false;
        goto L10
    }

    public y(boolean r100, boolean r101, boolean r102) {
        this.f172652a = r100;
        this.f172653b = r101;
        this.f172654c = r102;
    }
}
