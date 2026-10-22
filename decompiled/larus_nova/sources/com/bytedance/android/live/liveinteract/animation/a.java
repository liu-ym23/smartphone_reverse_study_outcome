package com.bytedance.android.live.liveinteract.animation;

/* JADX INFO: loaded from: classes46.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f70963a;

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof a) == true) goto L6;
        return false;
    L6:
        if (this.f70963a == ((a) r100).f70963a) goto L13;
        return false;
    L13:
        return true;
    }

    public final int hashCode() {
        return this.f70963a;
    }

    public final String toString() {
        return "AnimationViewExtraInfo(level=" + this.f70963a + ")";
    }

    public a(int r100) {
        this.f70963a = r100;
    }
}
