package com.bytedance.android.live.revlink.impl.multianchor.match;

/* JADX INFO: loaded from: classes47.dex */
public final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final boolean f94386a;

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof d) == true) goto L6;
        return false;
    L6:
        if (this.f94386a == ((d) r100).f94386a) goto L13;
        return false;
    L13:
        return true;
    }

    public final int hashCode() {
        boolean r100 = this.f94386a;
        if (r100 == false) goto L6;
        return 1;
    L6:
        return r100 ? 1 : 0;
    }

    public final String toString() {
        return "MultiMatchSuccessEvent(isMatchInviter=" + this.f94386a + ")";
    }

    public d(boolean r100) {
        this.f94386a = r100;
    }
}
