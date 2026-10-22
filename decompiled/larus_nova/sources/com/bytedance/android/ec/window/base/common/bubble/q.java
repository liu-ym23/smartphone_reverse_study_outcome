package com.bytedance.android.ec.window.base.common.bubble;

/* JADX INFO: loaded from: classes44.dex */
public final class q {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final float f49128a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final long f49129b;

    public q() {
        this(0);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof q) == false) goto L10;
        q r101 = (q) r100;
        if (Float.compare(this.f49128a, r101.f49128a) == 0) goto L8;
        return false;
    L8:
        if (this.f49129b == r101.f49129b) goto L16;
        return false;
    L16:
        return true;
    L10:
        return false;
    }

    public final int hashCode() {
        int r100 = Float.floatToIntBits(this.f49128a) * 31;
        long r101 = this.f49129b;
        return r100 + ((int) (r101 ^ (r101 >>> 32)));
    }

    public final String toString() {
        return "ECWindowBubbleTextConfig(textSize=" + this.f49128a + ", textColor=" + this.f49129b + ")";
    }

    public /* synthetic */ q(int r100) {
        this(13.0f, 4279638051L);
    }

    public q(float r100, long r101) {
        this.f49128a = r100;
        this.f49129b = r101;
    }
}
