package com.bytedance.android.livesdk.config;

/* JADX INFO: loaded from: classes8.dex */
public final class di1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final boolean f120036a;

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof di1) == true) goto L6;
        return false;
    L6:
        if (this.f120036a == ((di1) r100).f120036a) goto L13;
        return false;
    L13:
        return true;
    }

    public final int hashCode() {
        boolean r100 = this.f120036a;
        if (r100 == false) goto L6;
        return 1;
    L6:
        return r100 ? 1 : 0;
    }

    public final String toString() {
        return "ToolBarButtonEntranceConfig(enable=" + this.f120036a + ")";
    }

    public di1(boolean r100) {
        this.f120036a = r100;
    }
}
