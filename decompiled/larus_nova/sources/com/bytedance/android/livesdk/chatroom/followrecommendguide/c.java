package com.bytedance.android.livesdk.chatroom.followrecommendguide;

/* JADX INFO: loaded from: classes7.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f106245a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final boolean f106246b;

    public c() {
        this(0, false);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof c) == false) goto L10;
        c r101 = (c) r100;
        if (this.f106245a == r101.f106245a) goto L8;
        return false;
    L8:
        if (this.f106246b == r101.f106246b) goto L16;
        return false;
    L16:
        return true;
    L10:
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v2, types: [int] */
    /* JADX WARN: Type inference failed for: r1v1, types: [int] */
    /* JADX WARN: Type inference failed for: r1v2 */
    /* JADX WARN: Type inference failed for: r1v3 */
    public final int hashCode() {
        int r100 = this.f106245a * 31;
        boolean r101 = this.f106246b;
        ?? r102 = r101;
        if (r101 == false) goto L6;
        r102 = 1;
    L6:
        return r100 + r102;
    }

    public final String toString() {
        return "RecommendSwipeEvent(position=" + this.f106245a + ", isSlideUp=" + this.f106246b + ")";
    }

    public c(int r100, boolean r101) {
        this.f106245a = r100;
        this.f106246b = r101;
    }
}
