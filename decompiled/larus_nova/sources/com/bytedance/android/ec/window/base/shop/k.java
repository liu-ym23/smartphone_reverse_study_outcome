package com.bytedance.android.ec.window.base.shop;

/* JADX INFO: loaded from: classes44.dex */
public final class k {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f49649a;

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof k) == true) goto L6;
        return false;
    L6:
        if (this.f49649a == ((k) r100).f49649a) goto L13;
        return false;
    L13:
        return true;
    }

    public final int hashCode() {
        return this.f49649a;
    }

    public final String toString() {
        return "WindowImagePlayEvent(actionType=" + this.f49649a + ")";
    }

    public k() {
        this.f49649a = 1;
    }
}
