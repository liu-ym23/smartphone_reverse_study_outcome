package com.baidu.lbsapi.auth;

/* loaded from: classes.dex */
class f implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ String f4925a;

    /* renamed from: b, reason: collision with root package name */
    final /* synthetic */ int f4926b;

    /* renamed from: c, reason: collision with root package name */
    final /* synthetic */ String f4927c;

    /* renamed from: d, reason: collision with root package name */
    final /* synthetic */ String f4928d;

    /* renamed from: e, reason: collision with root package name */
    final /* synthetic */ e f4929e;

    public f(e eVar, String str, int i4, String str2, String str3) {
        this.f4929e = eVar;
        this.f4925a = str;
        this.f4926b = i4;
        this.f4927c = str2;
        this.f4928d = str3;
    }

    @Override // java.lang.Runnable
    public void run() throws Throwable {
        b.a("postWithHttps start Thread id = " + String.valueOf(Thread.currentThread().getId()));
        this.f4929e.a(new i(this.f4929e.f4922a).a(this.f4929e.f4923b, this.f4925a, this.f4926b, this.f4927c, this.f4928d));
    }
}
