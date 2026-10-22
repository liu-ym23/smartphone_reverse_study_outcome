package com.bytedance.frameworks.baselib.network.http.ok3.impl;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.net.InetAddress;
import java.net.Socket;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.SSLSocketFactory;

/* JADX INFO: compiled from: Tls12SocketFactory.java */
/* JADX INFO: loaded from: classes.dex */
public class t extends SSLSocketFactory {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final String[] f8569b = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final SSLSocketFactory f8570a;

    static {
        f8569b = new String[]{"TLSv1.2"};
    }

    public t(SSLSocketFactory r1) {
        this.f8570a = r1;
    }

    @Override // javax.net.ssl.SSLSocketFactory
    public String[] getDefaultCipherSuites() {
        return this.f8570a.getDefaultCipherSuites();
    }

    @Override // javax.net.ssl.SSLSocketFactory
    public String[] getSupportedCipherSuites() {
        return this.f8570a.getSupportedCipherSuites();
    }

    @Override // javax.net.ssl.SSLSocketFactory
    public Socket createSocket(Socket r2, String r3, int r4, boolean r5) {
        return a(this.f8570a.createSocket(r2, r3, r4, r5));
    }

    @Override // javax.net.SocketFactory
    public Socket createSocket(String r2, int r3) {
        return a(this.f8570a.createSocket(r2, r3));
    }

    @Override // javax.net.SocketFactory
    public Socket createSocket(String r2, int r3, InetAddress r4, int r5) {
        return a(this.f8570a.createSocket(r2, r3, r4, r5));
    }

    @Override // javax.net.SocketFactory
    public Socket createSocket(InetAddress r2, int r3) {
        return a(this.f8570a.createSocket(r2, r3));
    }

    @Override // javax.net.SocketFactory
    public Socket createSocket(InetAddress r2, int r3, InetAddress r4, int r5) {
        return a(this.f8570a.createSocket(r2, r3, r4, r5));
    }

    private Socket a(Socket r2) {
        if (ZeusTransformUtils.instanceOf(r2, SSLSocket.class) == false) goto L5;
        ((SSLSocket) ZeusTransformUtils.preCheckCast(r2, SSLSocket.class, "com.obric.aiagent.plugin")).setEnabledProtocols(f8569b);
    L5:
        return r2;
    }
}
