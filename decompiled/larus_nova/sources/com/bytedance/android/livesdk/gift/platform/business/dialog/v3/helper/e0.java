package com.bytedance.android.livesdk.gift.platform.business.dialog.v3.helper;

/* JADX INFO: loaded from: classes9.dex */
public final class e0 implements mb.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public volatile int f127397a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public volatile long f127398b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public volatile int f127399c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public volatile long f127400d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public volatile boolean f127401e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public volatile int f127402f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public volatile long f127403g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public volatile int f127404h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public volatile long f127405i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public volatile long f127406j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public volatile long f127407k;

    public e0() {
    }

    @Override // mb.b
    public final void a(long r100) {
        this.f127399c++;
        this.f127400d += System.currentTimeMillis() - r100;
        if (this.f127401e == false) goto L6;
        this.f127404h++;
        this.f127405i += System.currentTimeMillis() - r100;
        this.f127407k += (System.currentTimeMillis() - this.f127406j) - this.f127405i;
        return;
    }

    @Override // mb.b
    public final void b(long r100) {
        this.f127397a++;
        this.f127398b += System.currentTimeMillis() - r100;
        if (this.f127401e == false) goto L6;
        this.f127402f++;
        this.f127403g += System.currentTimeMillis() - r100;
        this.f127406j = System.currentTimeMillis();
        return;
    }
}
