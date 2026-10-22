package com.bytedance.android.livesdk.chatroom.model;

/* JADX INFO: loaded from: classes7.dex */
public final class b4 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final boolean f106910a;

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof b4) == true) goto L6;
        return false;
    L6:
        if (this.f106910a == ((b4) r100).f106910a) goto L13;
        return false;
    L13:
        return true;
    }

    public final int hashCode() {
        boolean r100 = this.f106910a;
        if (r100 == false) goto L6;
        return 1;
    L6:
        return r100 ? 1 : 0;
    }

    public final String toString() {
        return "WirelessHeadsetState(wirelessHeadsetState=" + this.f106910a + ")";
    }

    public b4(boolean r100) {
        this.f106910a = r100;
    }
}
