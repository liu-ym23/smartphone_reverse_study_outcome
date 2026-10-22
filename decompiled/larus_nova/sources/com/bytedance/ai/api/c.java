package com.bytedance.ai.api;

/* JADX INFO: loaded from: classes43.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final boolean f34004a;

    public c() {
        this(true);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof c) == true) goto L9;
        return false;
    L9:
        if (this.f34004a == ((c) r100).f34004a) goto L11;
        return false;
    L11:
        return true;
    }

    public final int hashCode() {
        if (this.f34004a == false) goto L5;
        return 1231;
    L5:
        return 1237;
    }

    public final String toString() {
        return "AppletBottomSheetBehavior(dismissOnMaskTap=" + this.f34004a + ')';
    }

    public c(boolean r100) {
        this.f34004a = r100;
    }
}
