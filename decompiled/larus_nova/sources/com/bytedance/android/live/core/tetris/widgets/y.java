package com.bytedance.android.live.core.tetris.widgets;

/* JADX INFO: loaded from: classes45.dex */
public final class y {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final boolean f66042a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f66043b;

    public static final class a {
    }

    static {
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof y) == false) goto L10;
        y r101 = (y) r100;
        if (this.f66042a == r101.f66042a) goto L8;
        return false;
    L8:
        if (this.f66043b == r101.f66043b) goto L16;
        return false;
    L16:
        return true;
    L10:
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v1, types: [int] */
    /* JADX WARN: Type inference failed for: r0v4 */
    /* JADX WARN: Type inference failed for: r0v5 */
    public final int hashCode() {
        boolean r100 = this.f66042a;
        ?? r101 = r100;
        if (r100 == false) goto L6;
        r101 = 1;
    L6:
        return (r101 * 31) + this.f66043b;
    }

    public final String toString() {
        return "WidgetClearEvent(isClear=" + this.f66042a + ", scene=" + this.f66043b + ")";
    }

    public y(boolean r100, int r101) {
        this.f66042a = r100;
        this.f66043b = r101;
    }
}
