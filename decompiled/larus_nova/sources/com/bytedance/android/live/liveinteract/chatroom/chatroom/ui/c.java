package com.bytedance.android.live.liveinteract.chatroom.chatroom.ui;

/* JADX INFO: loaded from: classes46.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f72457a;

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof c) == true) goto L6;
        return false;
    L6:
        if (this.f72457a == ((c) r100).f72457a) goto L13;
        return false;
    L13:
        return true;
    }

    public final int hashCode() {
        return this.f72457a;
    }

    public final String toString() {
        return "FirstDiscountModeChangeEvent(discountMode=" + this.f72457a + ")";
    }

    public c(int r100) {
        this.f72457a = r100;
    }
}
