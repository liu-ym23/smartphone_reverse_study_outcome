package com.bytedance.android.livesdk.ktvimpl.ktvcomponent.ui.viewmodel;

/* JADX INFO: loaded from: classes10.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final boolean f144527a;

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof a) == true) goto L6;
        return false;
    L6:
        if (this.f144527a == ((a) r100).f144527a) goto L13;
        return false;
    L13:
        return true;
    }

    public final int hashCode() {
        boolean r100 = this.f144527a;
        if (r100 == false) goto L6;
        return 1;
    L6:
        return r100 ? 1 : 0;
    }

    public final String toString() {
        return "ShowOrHideAdjustDialogEvent(show=" + this.f144527a + ")";
    }

    public a() {
        this.f144527a = true;
    }
}
