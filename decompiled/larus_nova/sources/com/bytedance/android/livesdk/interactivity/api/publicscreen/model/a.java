package com.bytedance.android.livesdk.interactivity.api.publicscreen.model;

/* JADX INFO: loaded from: classes9.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f133480a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final float f133481b;

    public a() {
        this(0);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof a) == false) goto L10;
        a r101 = (a) r100;
        if (this.f133480a == r101.f133480a) goto L8;
        return false;
    L8:
        if (Float.compare(this.f133481b, r101.f133481b) == 0) goto L16;
        return false;
    L16:
        return true;
    L10:
        return false;
    }

    public final int hashCode() {
        return (this.f133480a * 31) + Float.floatToIntBits(this.f133481b);
    }

    public final String toString() {
        return "DanmakuWaitMessageState(commentSize=" + this.f133480a + ", commentHotRate=" + this.f133481b + ")";
    }

    public /* synthetic */ a(int r100) {
        this(0, 0.0f);
    }

    public a(int r100, float r101) {
        this.f133480a = r100;
        this.f133481b = r101;
    }
}
