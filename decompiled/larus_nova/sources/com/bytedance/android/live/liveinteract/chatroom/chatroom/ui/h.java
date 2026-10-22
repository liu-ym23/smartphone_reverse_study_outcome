package com.bytedance.android.live.liveinteract.chatroom.chatroom.ui;

/* JADX INFO: loaded from: classes46.dex */
public final class h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final boolean f72465a;

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof h) == true) goto L6;
        return false;
    L6:
        if (this.f72465a == ((h) r100).f72465a) goto L13;
        return false;
    L13:
        return true;
    }

    public final int hashCode() {
        boolean r100 = this.f72465a;
        if (r100 == false) goto L6;
        return 1;
    L6:
        return r100 ? 1 : 0;
    }

    public final String toString() {
        return "PaidLinkMIcCloseEvent(isClosed=" + this.f72465a + ")";
    }

    public h() {
        this.f72465a = true;
    }
}
