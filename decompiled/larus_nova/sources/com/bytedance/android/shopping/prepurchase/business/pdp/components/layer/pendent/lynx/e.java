package com.bytedance.android.shopping.prepurchase.business.pdp.components.layer.pendent.lynx;

/* JADX INFO: loaded from: classes13.dex */
public final class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f181489a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f181490b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f181491c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f181492d;

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof e) == false) goto L14;
        e r101 = (e) r100;
        if (this.f181489a == r101.f181489a) goto L8;
        return false;
    L8:
        if (this.f181490b == r101.f181490b) goto L10;
        return false;
    L10:
        if (this.f181491c == r101.f181491c) goto L12;
        return false;
    L12:
        if (this.f181492d == r101.f181492d) goto L22;
        return false;
    L22:
        return true;
    L14:
        return false;
    }

    public final int hashCode() {
        return (((((this.f181489a * 31) + this.f181490b) * 31) + this.f181491c) * 31) + this.f181492d;
    }

    public final String toString() {
        return "ProtectArea(leftMargin=" + this.f181489a + ", topMargin=" + this.f181490b + ", rightMargin=" + this.f181491c + ", bottomMargin=" + this.f181492d + ")";
    }

    public e(int r100) {
        this.f181489a = 0;
        this.f181490b = 0;
        this.f181491c = 0;
        this.f181492d = r100;
    }
}
