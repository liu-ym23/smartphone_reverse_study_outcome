package com.baidu.lbsapi.auth;

import android.text.TextUtils;
import java.net.Authenticator;
import java.net.PasswordAuthentication;

/* loaded from: classes.dex */
class j extends Authenticator {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ i f4946a;

    public j(i iVar) {
        this.f4946a = iVar;
    }

    @Override // java.net.Authenticator
    public PasswordAuthentication getPasswordAuthentication() {
        if (!TextUtils.isEmpty(this.f4946a.f4944g) && !TextUtils.isEmpty(this.f4946a.f4945h)) {
            return new PasswordAuthentication(this.f4946a.f4944g, this.f4946a.f4945h.toCharArray());
        }
        b.a("Proxy Username or Password is null");
        return null;
    }
}
