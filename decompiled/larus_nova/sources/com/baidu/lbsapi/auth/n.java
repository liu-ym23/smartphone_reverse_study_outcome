package com.baidu.lbsapi.auth;

/* JADX INFO: loaded from: classes39.dex */
class n implements e.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ String f30478a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ String f30479b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final /* synthetic */ LBSAuthManager f30480c;

    public n(LBSAuthManager r100, String r101, String r102) {
        this.f30480c = r100;
        this.f30478a = r101;
        this.f30479b = r102;
    }

    @Override // com.baidu.lbsapi.auth.e.a
    public /* bridge */ /* synthetic */ void a(Object r100) {
        a((String) r100);
    }

    public void a(String r100) {
        LBSAuthManager.a(this.f30480c, this.f30478a, r100, this.f30479b);
    }
}
