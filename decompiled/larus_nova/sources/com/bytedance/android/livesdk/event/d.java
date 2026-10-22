package com.bytedance.android.livesdk.event;

/* JADX INFO: loaded from: classes8.dex */
public final class d extends o70.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final boolean f123336a;

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof d) == true) goto L6;
        return false;
    L6:
        if (this.f123336a == ((d) r100).f123336a) goto L13;
        return false;
    L13:
        return true;
    }

    public final int hashCode() {
        boolean r100 = this.f123336a;
        if (r100 == false) goto L6;
        return 1;
    L6:
        return r100 ? 1 : 0;
    }

    public final String toString() {
        return "BarrageCleanScreenEvent(isClear=" + this.f123336a + ")";
    }

    public d(boolean r100) {
        this.f123336a = r100;
    }
}
