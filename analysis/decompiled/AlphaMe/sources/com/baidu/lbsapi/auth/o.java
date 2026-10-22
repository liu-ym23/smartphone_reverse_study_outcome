package com.baidu.lbsapi.auth;

import com.baidu.lbsapi.auth.g;

/* loaded from: classes.dex */
class o implements g.a {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ String f4958a;

    /* renamed from: b, reason: collision with root package name */
    final /* synthetic */ String f4959b;

    /* renamed from: c, reason: collision with root package name */
    final /* synthetic */ LBSAuthManager f4960c;

    public o(LBSAuthManager lBSAuthManager, String str, String str2) {
        this.f4960c = lBSAuthManager;
        this.f4958a = str;
        this.f4959b = str2;
    }

    @Override // com.baidu.lbsapi.auth.g.a
    public void a(String str) {
        this.f4960c.a(this.f4958a, str, this.f4959b);
    }
}
