package h5;

import android.view.Choreographer;
import c1.q;
import c7.r;
import i7.i;
import ia.b0;
import java.io.IOException;
import java.net.Socket;
import java.security.MessageDigest;
import java.security.cert.Certificate;
import javax.net.SocketFactory;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.SSLSocketFactory;
import la.k;
import p7.n;
import s1.u;
import w5.m;
import w7.e0;

/* loaded from: classes.dex */
public final class c extends i implements n {

    /* renamed from: f, reason: collision with root package name */
    public final /* synthetic */ int f4184f;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ c(int i2, g7.d dVar, int i10) {
        super(i2, dVar);
        this.f4184f = i10;
    }

    @Override // i7.a
    public final g7.d create(Object obj, g7.d dVar) {
        switch (this.f4184f) {
            case 0:
                return new c(2, dVar, 0);
            case 1:
                return new c(2, dVar, 1);
            case 2:
                return new c(2, dVar, 2);
            case 3:
                return new c(2, dVar, 3);
            case 4:
                return new c(2, dVar, 4);
            case 5:
                return new c(2, dVar, 5);
            case 6:
                return new c(2, dVar, 6);
            default:
                return new c(2, dVar, 7);
        }
    }

    @Override // p7.n
    public final Object invoke(Object obj, Object obj2) throws IOException {
        switch (this.f4184f) {
            case 0:
                c cVar = (c) create((d) obj, (g7.d) obj2);
                r rVar = r.f1986a;
                cVar.invokeSuspend(rVar);
                return rVar;
            case 1:
                return ((c) create((b0) obj, (g7.d) obj2)).invokeSuspend(r.f1986a);
            case 2:
                c cVar2 = (c) create((k) obj, (g7.d) obj2);
                r rVar2 = r.f1986a;
                cVar2.invokeSuspend(rVar2);
                return rVar2;
            case 3:
                return ((c) create((b0) obj, (g7.d) obj2)).invokeSuspend(r.f1986a);
            case 4:
                return ((c) create((b0) obj, (g7.d) obj2)).invokeSuspend(r.f1986a);
            case 5:
                return ((c) create((b0) obj, (g7.d) obj2)).invokeSuspend(r.f1986a);
            case 6:
                return ((c) create((b0) obj, (g7.d) obj2)).invokeSuspend(r.f1986a);
            default:
                c cVar3 = (c) create((q) obj, (g7.d) obj2);
                r rVar3 = r.f1986a;
                cVar3.invokeSuspend(rVar3);
                return rVar3;
        }
    }

    @Override // i7.a
    public final Object invokeSuspend(Object obj) throws IOException {
        String strN0;
        int i2 = this.f4184f;
        r rVar = r.f1986a;
        switch (i2) {
            case 0:
                h7.a aVar = h7.a.f4212f;
                e0.N(obj);
                return rVar;
            case 1:
                h7.a aVar2 = h7.a.f4212f;
                e0.N(obj);
                return Choreographer.getInstance();
            case 2:
                h7.a aVar3 = h7.a.f4212f;
                e0.N(obj);
                return rVar;
            case 3:
                h7.a aVar4 = h7.a.f4212f;
                e0.N(obj);
                SocketFactory socketFactory = SSLSocketFactory.getDefault();
                q7.k.c(socketFactory, "null cannot be cast to non-null type javax.net.ssl.SSLSocketFactory");
                Socket socketCreateSocket = ((SSLSocketFactory) socketFactory).createSocket("claw-connection-socket-mtls.stepaos.com", 443);
                q7.k.c(socketCreateSocket, "null cannot be cast to non-null type javax.net.ssl.SSLSocket");
                SSLSocket sSLSocket = (SSLSocket) socketCreateSocket;
                try {
                    sSLSocket.startHandshake();
                    Certificate[] peerCertificates = sSLSocket.getSession().getPeerCertificates();
                    q7.k.b(peerCertificates);
                    Certificate certificate = (Certificate) d7.n.h0(peerCertificates);
                    if (certificate != null) {
                        byte[] bArrDigest = MessageDigest.getInstance("SHA-256").digest(certificate.getEncoded());
                        q7.k.d(bArrDigest, "digest(...)");
                        strN0 = d7.n.n0(bArrDigest, "", new u(10), 30);
                        if (strN0 == null) {
                            strN0 = "no cert";
                        }
                    } else {
                        strN0 = "no cert";
                    }
                    sSLSocket.close();
                    return strN0;
                } finally {
                }
            case 4:
                h7.a aVar5 = h7.a.f4212f;
                e0.N(obj);
                return m.d("TCP_CLOUD_PROD", "TCP (生产)", "claw-connection-socket-mtls.stepaos.com");
            case 5:
                h7.a aVar6 = h7.a.f4212f;
                e0.N(obj);
                return m.d("TCP_CLOUD_NODE", "TCP (节点)", "claw-node-connection-socket.stepos.com");
            case 6:
                h7.a aVar7 = h7.a.f4212f;
                e0.N(obj);
                return m.d("TCP_BASELINE", "TCP (基准)", "www.baidu.com");
            default:
                h7.a aVar8 = h7.a.f4212f;
                e0.N(obj);
                return rVar;
        }
    }
}
