package com.bytedance.android.livesdk.event;

/* JADX INFO: loaded from: classes8.dex */
public final class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final boolean f123343a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f123344b;

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof e) == false) goto L10;
        e r101 = (e) r100;
        if (this.f123343a == r101.f123343a) goto L8;
        return false;
    L8:
        if (this.f123344b == r101.f123344b) goto L16;
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
        boolean r100 = this.f123343a;
        ?? r101 = r100;
        if (r100 == false) goto L6;
        r101 = 1;
    L6:
        return (r101 * 31) + this.f123344b;
    }

    public final String toString() {
        return "BottomCardEvent(isShow=" + this.f123343a + ", height=" + this.f123344b + ")";
    }

    public e(boolean r100, int r101) {
        this.f123343a = r100;
        this.f123344b = r101;
    }
}
