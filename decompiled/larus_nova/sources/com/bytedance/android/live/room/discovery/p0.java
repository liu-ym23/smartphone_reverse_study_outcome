package com.bytedance.android.live.room.discovery;

/* JADX INFO: loaded from: classes47.dex */
public final class p0 extends o70.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f99577a;

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof p0) == true) goto L6;
        return false;
    L6:
        if (this.f99577a == ((p0) r100).f99577a) goto L13;
        return false;
    L13:
        return true;
    }

    public final int hashCode() {
        return this.f99577a;
    }

    public final String toString() {
        return "SignalStatusEvent(status=" + this.f99577a + ")";
    }

    public p0() {
        this.f99577a = 1;
    }
}
