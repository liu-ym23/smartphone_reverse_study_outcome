package com.bytedance.android.live.liveinteract.plantform.datamerge;

/* JADX INFO: loaded from: classes46.dex */
public final class k {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f76576a;

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof k) == true) goto L6;
        return false;
    L6:
        if (this.f76576a == ((k) r100).f76576a) goto L13;
        return false;
    L13:
        return true;
    }

    public final int hashCode() {
        return this.f76576a;
    }

    public final String toString() {
        return "WindowConfig(maxStubCount=" + this.f76576a + ')';
    }

    public k(int r100) {
        this.f76576a = r100;
    }
}
