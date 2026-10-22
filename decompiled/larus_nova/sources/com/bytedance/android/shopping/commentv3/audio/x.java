package com.bytedance.android.shopping.commentv3.audio;

/* JADX INFO: loaded from: classes13.dex */
public final class x {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final boolean f172651a;

    public x() {
        this(true);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof x) == true) goto L6;
        return false;
    L6:
        if (this.f172651a == ((x) r100).f172651a) goto L13;
        return false;
    L13:
        return true;
    }

    public final int hashCode() {
        boolean r100 = this.f172651a;
        if (r100 == false) goto L6;
        return 1;
    L6:
        return r100 ? 1 : 0;
    }

    public final String toString() {
        return "StopDecision(restoreExternalAudio=" + this.f172651a + ")";
    }

    public x(boolean r100) {
        this.f172651a = r100;
    }
}
