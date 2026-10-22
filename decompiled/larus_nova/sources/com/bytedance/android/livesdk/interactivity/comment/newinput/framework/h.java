package com.bytedance.android.livesdk.interactivity.comment.newinput.framework;

/* JADX INFO: loaded from: classes9.dex */
public final class h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f135510a;

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof h) == true) goto L6;
        return false;
    L6:
        if (this.f135510a == ((h) r100).f135510a) goto L13;
        return false;
    L13:
        return true;
    }

    public final int hashCode() {
        return this.f135510a;
    }

    public final String toString() {
        return "InputPanelRedDot(sdkVersion=" + this.f135510a + ")";
    }

    public h(int r100) {
        this.f135510a = r100;
    }
}
