package io.ktor.network.tls;

import Y8.t;
import e9.InterfaceC4014c;
import g9.InterfaceC4112d;
import io.ktor.network.sockets.Connection;
import io.ktor.network.sockets.Socket;
import kotlin.Metadata;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.jvm.internal.p;
import p9.InterfaceC5074l;

@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a\u001c\u0010\u0003\u001a\u00020\u0000*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u0001H\u0086@¢\u0006\u0004\b\u0003\u0010\u0004\u001a$\u0010\u0003\u001a\u00020\u0000*\u00020\u00052\u0006\u0010\u0002\u001a\u00020\u00012\u0006\u0010\u0007\u001a\u00020\u0006H\u0086@¢\u0006\u0004\b\u0003\u0010\b\u001a\u001c\u0010\u0003\u001a\u00020\u0000*\u00020\u00052\u0006\u0010\u0002\u001a\u00020\u0001H\u0086@¢\u0006\u0004\b\u0003\u0010\t\u001a0\u0010\u0003\u001a\u00020\u0000*\u00020\u00052\u0006\u0010\u0002\u001a\u00020\u00012\u0012\u0010\r\u001a\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\f0\nH\u0086@¢\u0006\u0004\b\u0003\u0010\u000e¨\u0006\u000f"}, d2 = {"Lio/ktor/network/sockets/Socket;", "Lkotlin/coroutines/d;", "coroutineContext", "tls", "(Lio/ktor/network/sockets/Socket;Lkotlin/coroutines/d;Le9/c;)Ljava/lang/Object;", "Lio/ktor/network/sockets/Connection;", "Lio/ktor/network/tls/TLSConfig;", "config", "(Lio/ktor/network/sockets/Connection;Lkotlin/coroutines/d;Lio/ktor/network/tls/TLSConfig;Le9/c;)Ljava/lang/Object;", "(Lio/ktor/network/sockets/Connection;Lkotlin/coroutines/d;Le9/c;)Ljava/lang/Object;", "Lkotlin/Function1;", "Lio/ktor/network/tls/TLSConfigBuilder;", "LY8/t;", "block", "(Lio/ktor/network/sockets/Connection;Lkotlin/coroutines/d;Lp9/l;Le9/c;)Ljava/lang/Object;", "ktor-network-tls"}, k = 2, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class TLSCommonKt {

    @InterfaceC4112d(c = "io.ktor.network.tls.TLSCommonKt", f = "TLSCommon.kt", l = {47}, m = "tls")
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    /* renamed from: io.ktor.network.tls.TLSCommonKt$tls$3, reason: invalid class name */
    public static final class AnonymousClass3 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        Object L$2;
        int label;
        /* synthetic */ Object result;

        public AnonymousClass3(InterfaceC4014c<? super AnonymousClass3> interfaceC4014c) {
            super(interfaceC4014c);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return TLSCommonKt.tls((Connection) null, (kotlin.coroutines.d) null, (TLSConfig) null, this);
        }
    }

    public static final Object tls(Socket socket, kotlin.coroutines.d dVar, InterfaceC4014c<? super Socket> interfaceC4014c) {
        return TLSKt.tls(socket, dVar, (InterfaceC5074l<? super TLSConfigBuilder, t>) new InterfaceC5074l() { // from class: io.ktor.network.tls.l
            @Override // p9.InterfaceC5074l
            public final Object invoke(Object obj) {
                return TLSCommonKt.tls$lambda$0((TLSConfigBuilder) obj);
            }
        }, interfaceC4014c);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final t tls$lambda$0(TLSConfigBuilder tls) {
        p.i(tls, "$this$tls");
        return t.f7040a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final t tls$lambda$1(TLSConfigBuilder tls) {
        p.i(tls, "$this$tls");
        return t.f7040a;
    }

    /* JADX WARN: Removed duplicated region for block: B:8:0x0014  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final java.lang.Object tls(io.ktor.network.sockets.Connection r7, kotlin.coroutines.d r8, io.ktor.network.tls.TLSConfig r9, e9.InterfaceC4014c<? super io.ktor.network.sockets.Socket> r10) throws java.lang.Throwable {
        /*
            boolean r0 = r10 instanceof io.ktor.network.tls.TLSCommonKt.AnonymousClass3
            if (r0 == 0) goto L14
            r0 = r10
            io.ktor.network.tls.TLSCommonKt$tls$3 r0 = (io.ktor.network.tls.TLSCommonKt.AnonymousClass3) r0
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
            io.ktor.network.tls.TLSCommonKt$tls$3 r0 = new io.ktor.network.tls.TLSCommonKt$tls$3
            r0.<init>(r10)
            goto L12
        L1a:
            java.lang.Object r10 = r6.result
            java.lang.Object r0 = f9.C4063a.g()
            int r1 = r6.label
            r2 = 1
            if (r1 == 0) goto L42
            if (r1 != r2) goto L3a
            java.lang.Object r7 = r6.L$2
            io.ktor.network.tls.TLSConfig r7 = (io.ktor.network.tls.TLSConfig) r7
            java.lang.Object r7 = r6.L$1
            kotlin.coroutines.d r7 = (kotlin.coroutines.d) r7
            java.lang.Object r7 = r6.L$0
            io.ktor.network.sockets.Connection r7 = (io.ktor.network.sockets.Connection) r7
            kotlin.C4849c.b(r10)     // Catch: java.lang.Throwable -> L37
            goto L6b
        L37:
            r0 = move-exception
            r8 = r0
            goto L6e
        L3a:
            java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
            java.lang.String r8 = "call to 'resume' before 'invoke' with coroutine"
            r7.<init>(r8)
            throw r7
        L42:
            kotlin.C4849c.b(r10)
            io.ktor.network.sockets.Socket r1 = r7.getSocket()     // Catch: java.lang.Throwable -> L37
            r10 = r2
            io.ktor.utils.io.ByteReadChannel r2 = r7.getInput()     // Catch: java.lang.Throwable -> L37
            io.ktor.utils.io.ByteWriteChannel r3 = r7.getOutput()     // Catch: java.lang.Throwable -> L37
            r6.L$0 = r7     // Catch: java.lang.Throwable -> L37
            java.lang.Object r4 = g9.h.a(r8)     // Catch: java.lang.Throwable -> L37
            r6.L$1 = r4     // Catch: java.lang.Throwable -> L37
            java.lang.Object r4 = g9.h.a(r9)     // Catch: java.lang.Throwable -> L37
            r6.L$2 = r4     // Catch: java.lang.Throwable -> L37
            r6.label = r10     // Catch: java.lang.Throwable -> L37
            r5 = r8
            r4 = r9
            java.lang.Object r10 = io.ktor.network.tls.TLSClientSessionJvmKt.openTLSSession(r1, r2, r3, r4, r5, r6)     // Catch: java.lang.Throwable -> L37
            if (r10 != r0) goto L6b
            return r0
        L6b:
            io.ktor.network.sockets.Socket r10 = (io.ktor.network.sockets.Socket) r10     // Catch: java.lang.Throwable -> L37
            return r10
        L6e:
            io.ktor.utils.io.ByteReadChannel r9 = r7.getInput()
            r9.cancel(r8)
            io.ktor.utils.io.ByteWriteChannel r9 = r7.getOutput()
            io.ktor.utils.io.ByteWriteChannelOperationsKt.close(r9, r8)
            io.ktor.network.sockets.Socket r7 = r7.getSocket()
            r7.close()
            throw r8
        */
        throw new UnsupportedOperationException("Method not decompiled: io.ktor.network.tls.TLSCommonKt.tls(io.ktor.network.sockets.Connection, kotlin.coroutines.d, io.ktor.network.tls.TLSConfig, e9.c):java.lang.Object");
    }

    public static final Object tls(Connection connection, kotlin.coroutines.d dVar, InterfaceC4014c<? super Socket> interfaceC4014c) {
        return tls(connection, dVar, (InterfaceC5074l<? super TLSConfigBuilder, t>) new InterfaceC5074l() { // from class: io.ktor.network.tls.k
            @Override // p9.InterfaceC5074l
            public final Object invoke(Object obj) {
                return TLSCommonKt.tls$lambda$1((TLSConfigBuilder) obj);
            }
        }, interfaceC4014c);
    }

    public static final Object tls(Connection connection, kotlin.coroutines.d dVar, InterfaceC5074l<? super TLSConfigBuilder, t> interfaceC5074l, InterfaceC4014c<? super Socket> interfaceC4014c) {
        TLSConfigBuilder tLSConfigBuilder = new TLSConfigBuilder();
        interfaceC5074l.invoke(tLSConfigBuilder);
        return tls(connection, dVar, tLSConfigBuilder.build(), interfaceC4014c);
    }
}
