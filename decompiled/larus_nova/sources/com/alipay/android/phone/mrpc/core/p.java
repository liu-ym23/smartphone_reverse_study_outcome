package com.alipay.android.phone.mrpc.core;

/* JADX INFO: loaded from: classes28.dex */
public final class p extends u {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f25045c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public String f25046d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public long f25047e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public long f25048f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public String f25049g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public HttpUrlHeader f25050h;

    public p(HttpUrlHeader r100, int r101, String r102, byte[] r103) {
        this.f25050h = r100;
        this.f25045c = r101;
        this.f25046d = r102;
        this.f25071a = r103;
    }

    public final HttpUrlHeader a() {
        return this.f25050h;
    }

    public final void a(long r100) {
        this.f25047e = r100;
    }

    public final void a(String r100) {
        this.f25049g = r100;
    }

    public final void b(long r100) {
        this.f25048f = r100;
    }
}
