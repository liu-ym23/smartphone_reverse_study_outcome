package com.baidu.lbsapi.auth;

import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLSession;

/* JADX INFO: loaded from: classes39.dex */
class k implements HostnameVerifier {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ i f30470a;

    public k(i r100) {
        this.f30470a = r100;
    }

    @Override // javax.net.ssl.HostnameVerifier
    public boolean verify(String r100, SSLSession r101) {
        if ("api.map.baidu.com".equals(r100) == false) goto L7;
        return true;
    L7:
        return HttpsURLConnection.getDefaultHostnameVerifier().verify(r100, r101);
    }
}
