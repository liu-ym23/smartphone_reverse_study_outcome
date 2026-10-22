package com.bytedance.android.shopping.store.home;

/* JADX INFO: loaded from: classes14.dex */
public final class c0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f183615a;

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof c0) == true) goto L6;
        return false;
    L6:
        if (this.f183615a == ((c0) r100).f183615a) goto L13;
        return false;
    L13:
        return true;
    }

    public final int hashCode() {
        return this.f183615a;
    }

    public final String toString() {
        return "ShopImagePlayEvent(actionType=" + this.f183615a + ")";
    }

    public c0() {
        this.f183615a = 1;
    }
}
