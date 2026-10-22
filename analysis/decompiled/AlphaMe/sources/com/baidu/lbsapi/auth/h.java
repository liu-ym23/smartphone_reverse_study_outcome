package com.baidu.lbsapi.auth;

/* loaded from: classes.dex */
class h implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ String f4933a;

    /* renamed from: b, reason: collision with root package name */
    final /* synthetic */ int f4934b;

    /* renamed from: c, reason: collision with root package name */
    final /* synthetic */ String f4935c;

    /* renamed from: d, reason: collision with root package name */
    final /* synthetic */ String f4936d;

    /* renamed from: e, reason: collision with root package name */
    final /* synthetic */ g f4937e;

    public h(g gVar, String str, int i4, String str2, String str3) {
        this.f4937e = gVar;
        this.f4933a = str;
        this.f4934b = i4;
        this.f4935c = str2;
        this.f4936d = str3;
    }

    @Override // java.lang.Runnable
    public void run() throws Throwable {
        g gVar = this.f4937e;
        gVar.a(gVar.f4931b, this.f4933a, this.f4934b, this.f4935c, this.f4936d);
    }
}
