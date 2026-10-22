package com.bytedance.android.livesdk.chatroom.model;

/* JADX INFO: loaded from: classes7.dex */
public final class a4 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final boolean f106909a;

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof a4) == true) goto L6;
        return false;
    L6:
        if (this.f106909a == ((a4) r100).f106909a) goto L13;
        return false;
    L13:
        return true;
    }

    public final int hashCode() {
        boolean r100 = this.f106909a;
        if (r100 == false) goto L6;
        return 1;
    L6:
        return r100 ? 1 : 0;
    }

    public final String toString() {
        return "WiredHeadsetConnectState(wiredHeadsetConnectState=" + this.f106909a + ")";
    }

    public a4(boolean r100) {
        this.f106909a = r100;
    }
}
