package com.baidu.lbsapi.auth;

import android.text.TextUtils;
import java.net.Authenticator;
import java.net.PasswordAuthentication;

/* JADX INFO: loaded from: classes39.dex */
class j extends Authenticator {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ i f30469a;

    public j(i r100) {
        this.f30469a = r100;
    }

    @Override // java.net.Authenticator
    public PasswordAuthentication getPasswordAuthentication() {
        if (TextUtils.isEmpty(i.a(this.f30469a)) == false) goto L5;
    L9:
        b.a("Proxy Username or Password is null");
        return null;
    L5:
        if (TextUtils.isEmpty(i.b(this.f30469a)) == true) goto L9;
        return new PasswordAuthentication(i.a(this.f30469a), i.b(this.f30469a).toCharArray());
    }
}
