package com.bytedance.android.live.liveinteract.animation.glflymic;

/* JADX INFO: loaded from: classes46.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final float f71044a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final float f71045b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final float f71046c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final float f71047d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final float f71048e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final float f71049f;

    public final float[] a(float r100, float r101) {
        float[] r102 = {0.0f, 0.0f};
        float r103 = (((r100 - this.f71046c) * 2.0f) / this.f71044a) - 1.0f;
        float r104 = 1.0f - (((r101 - this.f71047d) * 2.0f) / this.f71045b);
        r102[0] = r103 * (this.f71048e / 2.0f);
        r102[1] = r104 * (this.f71049f / 2.0f);
        return r102;
    }

    public a(float r100, float r101, float r102) {
        this.f71044a = r100;
        this.f71045b = r101;
        this.f71046c = 0.0f;
        this.f71047d = 0.0f;
        this.f71048e = 375.0f;
        this.f71049f = r102;
    }
}
