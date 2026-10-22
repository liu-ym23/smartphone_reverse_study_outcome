package com.bytedance.android.gamecp.business.gamedetail.component.orderbutton;

/* JADX INFO: loaded from: classes44.dex */
public final class o implements com.bytedance.ies.sve_core.i {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final boolean f54875a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f54876b;

    @Override // com.bytedance.ies.sve_core.i
    public final boolean a() {
        return true;
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof o) == false) goto L10;
        o r101 = (o) r100;
        if (this.f54875a == r101.f54875a) goto L8;
        return false;
    L8:
        if (this.f54876b == r101.f54876b) goto L16;
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
        boolean r100 = this.f54875a;
        ?? r101 = r100;
        if (r100 == false) goto L6;
        r101 = 1;
    L6:
        return (r101 * 31) + this.f54876b;
    }

    public final String toString() {
        return "OrderButtonClickIntent(trigger=" + this.f54875a + ", interactiveStyle=" + this.f54876b + ")";
    }

    public o(boolean r100, int r101) {
        this.f54875a = r100;
        this.f54876b = r101;
    }
}
