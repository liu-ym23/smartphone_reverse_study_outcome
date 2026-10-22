package com.bytedance.android.shopping.api.mall.feed;

/* JADX INFO: loaded from: classes13.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final boolean f170523a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f170524b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final boolean f170525c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f170526d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final int f170527e;

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof c) == false) goto L16;
        c r101 = (c) r100;
        if (this.f170523a == r101.f170523a) goto L8;
        return false;
    L8:
        if (this.f170524b == r101.f170524b) goto L10;
        return false;
    L10:
        if (this.f170525c == r101.f170525c) goto L12;
        return false;
    L12:
        if (this.f170526d == r101.f170526d) goto L14;
        return false;
    L14:
        if (this.f170527e == r101.f170527e) goto L25;
        return false;
    L25:
        return true;
    L16:
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v1, types: [int] */
    /* JADX WARN: Type inference failed for: r0v10 */
    /* JADX WARN: Type inference failed for: r0v11 */
    /* JADX WARN: Type inference failed for: r0v5, types: [int] */
    /* JADX WARN: Type inference failed for: r1v0 */
    /* JADX WARN: Type inference failed for: r1v1, types: [int] */
    /* JADX WARN: Type inference failed for: r1v4 */
    public final int hashCode() {
        boolean r100 = this.f170523a;
        ?? r101 = 1;
        ?? r102 = r100;
        if (r100 == false) goto L5;
        r102 = 1;
    L5:
        int r103 = ((r102 * 31) + this.f170524b) * 31;
        boolean r104 = this.f170525c;
        if (r104 == true) goto L10;
        r101 = r104;
    L10:
        return ((((r103 + r101) * 31) + this.f170526d) * 31) + this.f170527e;
    }

    public final String toString() {
        return "ECMallFeedImagePrefetchConfig(firstScreenEnable=" + this.f170523a + ", firstScreenCount=" + this.f170524b + ", loadMoreEnable=" + this.f170525c + ", loadMoreCount=" + this.f170526d + ", loadMoreImmPreloadNum=" + this.f170527e + ")";
    }

    public c(boolean r100, int r101, boolean r102, int r103, int r104) {
        this.f170523a = r100;
        this.f170524b = r101;
        this.f170525c = r102;
        this.f170526d = r103;
        this.f170527e = r104;
    }
}
