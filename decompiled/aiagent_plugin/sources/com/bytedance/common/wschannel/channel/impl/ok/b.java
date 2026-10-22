package com.bytedance.common.wschannel.channel.impl.ok;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.net.InetAddress;
import java.net.Socket;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.SSLSocketFactory;

/* JADX INFO: compiled from: Tls12SocketFactory.java */
/* JADX INFO: loaded from: classes.dex */
public class b extends SSLSocketFactory {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final String[] f6828b = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final SSLSocketFactory f6829a;

    static {
        f6828b = new String[]{"TLSv1.2"};
    }

    public b(SSLSocketFactory r1) {
        this.f6829a = r1;
    }

    @Override // javax.net.ssl.SSLSocketFactory
    public String[] getDefaultCipherSuites() {
        return this.f6829a.getDefaultCipherSuites();
    }

    @Override // javax.net.ssl.SSLSocketFactory
    public String[] getSupportedCipherSuites() {
        return this.f6829a.getSupportedCipherSuites();
    }

    @Override // javax.net.ssl.SSLSocketFactory
    public Socket createSocket(Socket r2, String r3, int r4, boolean r5) {
        return a(this.f6829a.createSocket(r2, r3, r4, r5));
    }

    @Override // javax.net.SocketFactory
    public Socket createSocket(String r2, int r3) {
        return a(this.f6829a.createSocket(r2, r3));
    }

    @Override // javax.net.SocketFactory
    public Socket createSocket(String r2, int r3, InetAddress r4, int r5) {
        return a(this.f6829a.createSocket(r2, r3, r4, r5));
    }

    @Override // javax.net.SocketFactory
    public Socket createSocket(InetAddress r2, int r3) {
        return a(this.f6829a.createSocket(r2, r3));
    }

    @Override // javax.net.SocketFactory
    public Socket createSocket(InetAddress r2, int r3, InetAddress r4, int r5) {
        return a(this.f6829a.createSocket(r2, r3, r4, r5));
    }

    private Socket a(Socket r2) {
        if (ZeusTransformUtils.instanceOf(r2, SSLSocket.class) == false) goto L5;
        ((SSLSocket) ZeusTransformUtils.preCheckCast(r2, SSLSocket.class, "com.obric.aiagent.plugin")).setEnabledProtocols(f6828b);
    L5:
        return r2;
    }
}
