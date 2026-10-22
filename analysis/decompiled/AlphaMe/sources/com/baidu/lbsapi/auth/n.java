package com.baidu.lbsapi.auth;

import com.baidu.lbsapi.auth.e;

/* loaded from: classes.dex */
class n implements e.a {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ String f4955a;

    /* renamed from: b, reason: collision with root package name */
    final /* synthetic */ String f4956b;

    /* renamed from: c, reason: collision with root package name */
    final /* synthetic */ LBSAuthManager f4957c;

    public n(LBSAuthManager lBSAuthManager, String str, String str2) {
        this.f4957c = lBSAuthManager;
        this.f4955a = str;
        this.f4956b = str2;
    }

    @Override // com.baidu.lbsapi.auth.e.a
    public void a(String str) {
        this.f4957c.a(this.f4955a, str, this.f4956b);
    }
}
