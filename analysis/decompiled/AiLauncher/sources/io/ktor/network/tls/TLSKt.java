package io.ktor.network.tls;

import Y8.t;
import e9.InterfaceC4014c;
import g9.InterfaceC4112d;
import io.ktor.network.sockets.Socket;
import java.security.SecureRandom;
import java.util.List;
import javax.net.ssl.X509TrustManager;
import kotlin.Metadata;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.jvm.internal.p;
import p9.InterfaceC5074l;

@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a$\u0010\u0005\u001a\u00020\u0000*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u00012\u0006\u0010\u0004\u001a\u00020\u0003H\u0086@¢\u0006\u0004\b\u0005\u0010\u0006\u001aN\u0010\u0005\u001a\u00020\u0000*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u00012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00072\b\b\u0002\u0010\n\u001a\u00020\t2\u000e\b\u0002\u0010\r\u001a\b\u0012\u0004\u0012\u00020\f0\u000b2\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\tH\u0086@¢\u0006\u0004\b\u0005\u0010\u000f\u001a0\u0010\u0005\u001a\u00020\u0000*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u00012\u0012\u0010\u0013\u001a\u000e\u0012\u0004\u0012\u00020\u0011\u0012\u0004\u0012\u00020\u00120\u0010H\u0086@¢\u0006\u0004\b\u0005\u0010\u0014¨\u0006\u0015"}, d2 = {"Lio/ktor/network/sockets/Socket;", "Lkotlin/coroutines/d;", "coroutineContext", "Lio/ktor/network/tls/TLSConfig;", "config", "tls", "(Lio/ktor/network/sockets/Socket;Lkotlin/coroutines/d;Lio/ktor/network/tls/TLSConfig;Le9/c;)Ljava/lang/Object;", "Ljavax/net/ssl/X509TrustManager;", "trustManager", "", "randomAlgorithm", "", "Lio/ktor/network/tls/CipherSuite;", "cipherSuites", "serverName", "(Lio/ktor/network/sockets/Socket;Lkotlin/coroutines/d;Ljavax/net/ssl/X509TrustManager;Ljava/lang/String;Ljava/util/List;Ljava/lang/String;Le9/c;)Ljava/lang/Object;", "Lkotlin/Function1;", "Lio/ktor/network/tls/TLSConfigBuilder;", "LY8/t;", "block", "(Lio/ktor/network/sockets/Socket;Lkotlin/coroutines/d;Lp9/l;Le9/c;)Ljava/lang/Object;", "ktor-network-tls"}, k = 2, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class TLSKt {

    @InterfaceC4112d(c = "io.ktor.network.tls.TLSKt", f = "TLS.kt", l = {33}, m = "tls")
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    /* renamed from: io.ktor.network.tls.TLSKt$tls$1, reason: invalid class name */
    public static final class AnonymousClass1 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        Object L$4;
        int label;
        /* synthetic */ Object result;

        public AnonymousClass1(InterfaceC4014c<? super AnonymousClass1> interfaceC4014c) {
            super(interfaceC4014c);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return TLSKt.tls((Socket) null, (kotlin.coroutines.d) null, (TLSConfig) null, this);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:8:0x0014  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final java.lang.Object tls(io.ktor.network.sockets.Socket r7, kotlin.coroutines.d r8, io.ktor.network.tls.TLSConfig r9, e9.InterfaceC4014c<? super io.ktor.network.sockets.Socket> r10) throws java.lang.Throwable {
        /*
            boolean r0 = r10 instanceof io.ktor.network.tls.TLSKt.AnonymousClass1
            if (r0 == 0) goto L14
            r0 = r10
            io.ktor.network.tls.TLSKt$tls$1 r0 = (io.ktor.network.tls.TLSKt.AnonymousClass1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L14
            int r1 = r1 - r2
            r0.label = r1
        L12:
            r6 = r0
            goto L1a
        L14:
            io.ktor.network.tls.TLSKt$tls$1 r0 = new io.ktor.network.tls.TLSKt$tls$1
            r0.<init>(r10)
            goto L12
        L1a:
            java.lang.Object r10 = r6.result
            java.lang.Object r0 = f9.C4063a.g()
            int r1 = r6.label
            r2 = 1
            if (r1 == 0) goto L4d
            if (r1 != r2) goto L45
            java.lang.Object r7 = r6.L$4
            io.ktor.utils.io.ByteWriteChannel r7 = (io.ktor.utils.io.ByteWriteChannel) r7
            java.lang.Object r8 = r6.L$3
            io.ktor.utils.io.ByteReadChannel r8 = (io.ktor.utils.io.ByteReadChannel) r8
            java.lang.Object r9 = r6.L$2
            io.ktor.network.tls.TLSConfig r9 = (io.ktor.network.tls.TLSConfig) r9
            java.lang.Object r9 = r6.L$1
            kotlin.coroutines.d r9 = (kotlin.coroutines.d) r9
            java.lang.Object r9 = r6.L$0
            io.ktor.network.sockets.Socket r9 = (io.ktor.network.sockets.Socket) r9
            kotlin.C4849c.b(r10)     // Catch: java.lang.Throwable -> L41
            r3 = r7
            r7 = r9
            goto L7b
        L41:
            r0 = move-exception
            r10 = r0
            r1 = r9
            goto L8a
        L45:
            java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
            java.lang.String r8 = "call to 'resume' before 'invoke' with coroutine"
            r7.<init>(r8)
            throw r7
        L4d:
            kotlin.C4849c.b(r10)
            r10 = r2
            io.ktor.utils.io.ByteReadChannel r2 = io.ktor.network.sockets.SocketsKt.openReadChannel(r7)
            r1 = 0
            r3 = 0
            io.ktor.utils.io.ByteWriteChannel r3 = io.ktor.network.sockets.SocketsKt.openWriteChannel$default(r7, r1, r10, r3)
            r6.L$0 = r7     // Catch: java.lang.Throwable -> L87
            java.lang.Object r1 = g9.h.a(r8)     // Catch: java.lang.Throwable -> L87
            r6.L$1 = r1     // Catch: java.lang.Throwable -> L87
            java.lang.Object r1 = g9.h.a(r9)     // Catch: java.lang.Throwable -> L87
            r6.L$2 = r1     // Catch: java.lang.Throwable -> L87
            r6.L$3 = r2     // Catch: java.lang.Throwable -> L87
            r6.L$4 = r3     // Catch: java.lang.Throwable -> L87
            r6.label = r10     // Catch: java.lang.Throwable -> L87
            r1 = r7
            r5 = r8
            r4 = r9
            java.lang.Object r10 = io.ktor.network.tls.TLSClientSessionJvmKt.openTLSSession(r1, r2, r3, r4, r5, r6)     // Catch: java.lang.Throwable -> L83
            if (r10 != r0) goto L79
            return r0
        L79:
            r7 = r1
            r8 = r2
        L7b:
            io.ktor.network.sockets.Socket r10 = (io.ktor.network.sockets.Socket) r10     // Catch: java.lang.Throwable -> L7e
            return r10
        L7e:
            r0 = move-exception
            r10 = r0
            r1 = r7
        L81:
            r7 = r3
            goto L8a
        L83:
            r0 = move-exception
        L84:
            r10 = r0
            r8 = r2
            goto L81
        L87:
            r0 = move-exception
            r1 = r7
            goto L84
        L8a:
            r8.cancel(r10)
            io.ktor.utils.io.ByteWriteChannelOperationsKt.close(r7, r10)
            r1.close()
            throw r10
        */
        throw new UnsupportedOperationException("Method not decompiled: io.ktor.network.tls.TLSKt.tls(io.ktor.network.sockets.Socket, kotlin.coroutines.d, io.ktor.network.tls.TLSConfig, e9.c):java.lang.Object");
    }

    public static /* synthetic */ Object tls$default(Socket socket, kotlin.coroutines.d dVar, X509TrustManager x509TrustManager, String str, List list, String str2, InterfaceC4014c interfaceC4014c, int i10, Object obj) {
        if ((i10 & 2) != 0) {
            x509TrustManager = null;
        }
        if ((i10 & 4) != 0) {
            str = "NativePRNGNonBlocking";
        }
        if ((i10 & 8) != 0) {
            list = CIOCipherSuites.INSTANCE.getSupportedSuites();
        }
        if ((i10 & 16) != 0) {
            str2 = null;
        }
        return tls(socket, dVar, x509TrustManager, str, list, str2, interfaceC4014c);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final t tls$lambda$0(X509TrustManager x509TrustManager, String str, List list, String str2, TLSConfigBuilder tls) {
        p.i(tls, "$this$tls");
        tls.setTrustManager(x509TrustManager);
        tls.setRandom(SecureRandom.getInstance(str));
        tls.setCipherSuites(list);
        tls.setServerName(str2);
        return t.f7040a;
    }

    public static final Object tls(Socket socket, kotlin.coroutines.d dVar, final X509TrustManager x509TrustManager, final String str, final List<CipherSuite> list, final String str2, InterfaceC4014c<? super Socket> interfaceC4014c) {
        return tls(socket, dVar, (InterfaceC5074l<? super TLSConfigBuilder, t>) new InterfaceC5074l() { // from class: io.ktor.network.tls.m
            @Override // p9.InterfaceC5074l
            public final Object invoke(Object obj) {
                return TLSKt.tls$lambda$0(x509TrustManager, str, list, str2, (TLSConfigBuilder) obj);
            }
        }, interfaceC4014c);
    }

    public static final Object tls(Socket socket, kotlin.coroutines.d dVar, InterfaceC5074l<? super TLSConfigBuilder, t> interfaceC5074l, InterfaceC4014c<? super Socket> interfaceC4014c) {
        TLSConfigBuilder tLSConfigBuilder = new TLSConfigBuilder();
        interfaceC5074l.invoke(tLSConfigBuilder);
        return tls(socket, dVar, tLSConfigBuilder.build(), interfaceC4014c);
    }
}
