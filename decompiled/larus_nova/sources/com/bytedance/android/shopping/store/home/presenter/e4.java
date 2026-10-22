package com.bytedance.android.shopping.store.home.presenter;

/* JADX INFO: loaded from: classes14.dex */
public final class e4 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final boolean f184157a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f184158b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f184159c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final boolean f184160d;

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof e4) == false) goto L14;
        e4 r101 = (e4) r100;
        if (this.f184157a == r101.f184157a) goto L8;
        return false;
    L8:
        if (this.f184158b == r101.f184158b) goto L10;
        return false;
    L10:
        if (this.f184159c == r101.f184159c) goto L12;
        return false;
    L12:
        if (this.f184160d == r101.f184160d) goto L22;
        return false;
    L22:
        return true;
    L14:
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v1, types: [int] */
    /* JADX WARN: Type inference failed for: r0v7, types: [int] */
    /* JADX WARN: Type inference failed for: r0v8 */
    /* JADX WARN: Type inference failed for: r0v9 */
    /* JADX WARN: Type inference failed for: r1v0 */
    /* JADX WARN: Type inference failed for: r1v1, types: [int] */
    /* JADX WARN: Type inference failed for: r1v2 */
    public final int hashCode() {
        boolean r100 = this.f184157a;
        ?? r101 = 1;
        ?? r102 = r100;
        if (r100 == false) goto L5;
        r102 = 1;
    L5:
        int r103 = ((((r102 * 31) + this.f184158b) * 31) + this.f184159c) * 31;
        boolean r104 = this.f184160d;
        if (r104 == true) goto L10;
        r101 = r104;
    L10:
        return r103 + r101;
    }

    public final String toString() {
        return "ShopFrameConfig(isDraggable=" + this.f184157a + ", peekHeight=" + this.f184158b + ", bottomSheetInitState=" + this.f184159c + ", skipHideabled=" + this.f184160d + ")";
    }

    public e4(boolean r100, int r101, int r102, boolean r103) {
        this.f184157a = r100;
        this.f184158b = r101;
        this.f184159c = r102;
        this.f184160d = r103;
    }
}
