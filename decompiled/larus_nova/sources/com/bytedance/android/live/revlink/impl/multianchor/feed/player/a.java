package com.bytedance.android.live.revlink.impl.multianchor.feed.player;

/* JADX INFO: loaded from: classes47.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final boolean f94264a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f94265b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f94266c;

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof a) == false) goto L12;
        a r101 = (a) r100;
        if (this.f94264a == r101.f94264a) goto L8;
        return false;
    L8:
        if (this.f94265b == r101.f94265b) goto L10;
        return false;
    L10:
        if (this.f94266c == r101.f94266c) goto L19;
        return false;
    L19:
        return true;
    L12:
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v1, types: [int] */
    /* JADX WARN: Type inference failed for: r0v6 */
    /* JADX WARN: Type inference failed for: r0v7 */
    public final int hashCode() {
        boolean r100 = this.f94264a;
        ?? r101 = r100;
        if (r100 == false) goto L6;
        r101 = 1;
    L6:
        return (((r101 * 31) + this.f94265b) * 31) + this.f94266c;
    }

    public final String toString() {
        return "FeedMultiContainerSize(isPortrait=" + this.f94264a + ", width=" + this.f94265b + ", height=" + this.f94266c + ")";
    }

    public a(boolean r100, int r101, int r102) {
        this.f94264a = r100;
        this.f94265b = r101;
        this.f94266c = r102;
    }
}
