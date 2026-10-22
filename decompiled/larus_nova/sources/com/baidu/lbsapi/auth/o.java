package com.baidu.lbsapi.auth;

/* JADX INFO: loaded from: classes39.dex */
class o implements g.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ String f30481a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ String f30482b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final /* synthetic */ LBSAuthManager f30483c;

    public o(LBSAuthManager r100, String r101, String r102) {
        this.f30483c = r100;
        this.f30481a = r101;
        this.f30482b = r102;
    }

    @Override // com.baidu.lbsapi.auth.g.a
    public /* bridge */ /* synthetic */ void a(Object r100) {
        a((String) r100);
    }

    public void a(String r100) {
        LBSAuthManager.a(this.f30483c, this.f30481a, r100, this.f30482b);
    }
}
