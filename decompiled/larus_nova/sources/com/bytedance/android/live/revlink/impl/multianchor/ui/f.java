package com.bytedance.android.live.revlink.impl.multianchor.ui;

/* JADX INFO: loaded from: classes47.dex */
public final class f implements d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f94801a;

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof f) == true) goto L6;
        return false;
    L6:
        if (this.f94801a == ((f) r100).f94801a) goto L13;
        return false;
    L13:
        return true;
    }

    public final int hashCode() {
        return this.f94801a;
    }

    public final String toString() {
        return "FloatOffsetFromWindow(floatDistanceFromBase=" + this.f94801a + ")";
    }

    public f(int r100) {
        this.f94801a = r100;
    }
}
