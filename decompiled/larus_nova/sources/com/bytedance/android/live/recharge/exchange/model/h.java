package com.bytedance.android.live.recharge.exchange.model;

/* JADX INFO: loaded from: classes47.dex */
public final class h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final boolean f89866a;

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof h) == true) goto L6;
        return false;
    L6:
        if (this.f89866a == ((h) r100).f89866a) goto L13;
        return false;
    L13:
        return true;
    }

    public final int hashCode() {
        boolean r100 = this.f89866a;
        if (r100 == false) goto L6;
        return 1;
    L6:
        return r100 ? 1 : 0;
    }

    public final String toString() {
        return "XiguaWalletInfo(showXiguaDiamondExchange=" + this.f89866a + ")";
    }

    public h(boolean r100) {
        this.f89866a = r100;
    }
}
