package com.bytedance.android.livesdk.interactivity.publicscreen.selectedmessage.strategy;

/* JADX INFO: loaded from: classes9.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f139455a;

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof c) == true) goto L6;
        return false;
    L6:
        if (this.f139455a == ((c) r100).f139455a) goto L13;
        return false;
    L13:
        return true;
    }

    public final int hashCode() {
        return this.f139455a;
    }

    public final String toString() {
        return "SelectedMessageUpdateInfo(size=" + this.f139455a + ")";
    }

    public c(int r100) {
        this.f139455a = r100;
    }
}
