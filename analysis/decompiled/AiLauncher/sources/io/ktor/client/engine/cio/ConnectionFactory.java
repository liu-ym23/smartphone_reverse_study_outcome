package io.ktor.client.engine.cio;

import Y8.t;
import com.autonavi.aps.amapapi.config.Const;
import com.stepos.deepbinder.core.constant.Constants;
import e9.InterfaceC4014c;
import g9.InterfaceC4112d;
import io.ktor.network.selector.SelectorManager;
import io.ktor.network.sockets.SocketAddress;
import io.ktor.network.sockets.SocketOptions;
import io.ktor.util.collections.ConcurrentMap;
import kotlin.Metadata;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.jvm.internal.p;
import p9.InterfaceC5074l;

@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0000\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\u0006\u0010\u0006\u001a\u00020\u0004¢\u0006\u0004\b\u0007\u0010\bJ.\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\n\u001a\u00020\t2\u0014\b\u0002\u0010\u000e\u001a\u000e\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\r0\u000bH\u0086@¢\u0006\u0004\b\u0010\u0010\u0011J\u0015\u0010\u0012\u001a\u00020\r2\u0006\u0010\n\u001a\u00020\t¢\u0006\u0004\b\u0012\u0010\u0013R\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0003\u0010\u0014R\u0014\u0010\u0006\u001a\u00020\u00048\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0006\u0010\u0015R\u0014\u0010\u0017\u001a\u00020\u00168\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0017\u0010\u0018R \u0010\u001a\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\u00160\u00198\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001a\u0010\u001b¨\u0006\u001c"}, d2 = {"Lio/ktor/client/engine/cio/ConnectionFactory;", "", "Lio/ktor/network/selector/SelectorManager;", "selector", "", "connectionsLimit", "addressConnectionsLimit", "<init>", "(Lio/ktor/network/selector/SelectorManager;II)V", "Lio/ktor/network/sockets/SocketAddress;", Const.JSON_KEY_ADDRESS, "Lkotlin/Function1;", "Lio/ktor/network/sockets/SocketOptions$TCPClientSocketOptions;", "LY8/t;", "configuration", "Lio/ktor/network/sockets/Socket;", Constants.METHOD_CONNECT, "(Lio/ktor/network/sockets/SocketAddress;Lp9/l;Le9/c;)Ljava/lang/Object;", "release", "(Lio/ktor/network/sockets/SocketAddress;)V", "Lio/ktor/network/selector/SelectorManager;", "I", "Leb/g;", "limit", "Leb/g;", "Lio/ktor/util/collections/ConcurrentMap;", "addressLimit", "Lio/ktor/util/collections/ConcurrentMap;", "ktor-client-cio"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class ConnectionFactory {
    private final int addressConnectionsLimit;
    private final ConcurrentMap<SocketAddress, eb.g> addressLimit;
    private final eb.g limit;
    private final SelectorManager selector;

    @InterfaceC4112d(c = "io.ktor.client.engine.cio.ConnectionFactory", f = "ConnectionFactory.kt", l = {24, 27, 30}, m = Constants.METHOD_CONNECT)
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    /* renamed from: io.ktor.client.engine.cio.ConnectionFactory$connect$1, reason: invalid class name */
    public static final class AnonymousClass1 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        Object L$2;
        int label;
        /* synthetic */ Object result;

        public AnonymousClass1(InterfaceC4014c<? super AnonymousClass1> interfaceC4014c) {
            super(interfaceC4014c);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return ConnectionFactory.this.connect(null, null, this);
        }
    }

    public ConnectionFactory(SelectorManager selector, int i10, int i11) {
        p.i(selector, "selector");
        this.selector = selector;
        this.addressConnectionsLimit = i11;
        this.limit = eb.j.b(i10, 0, 2, null);
        this.addressLimit = new ConcurrentMap<>(0, 1, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ Object connect$default(ConnectionFactory connectionFactory, SocketAddress socketAddress, InterfaceC5074l interfaceC5074l, InterfaceC4014c interfaceC4014c, int i10, Object obj) {
        if ((i10 & 2) != 0) {
            interfaceC5074l = new InterfaceC5074l() { // from class: io.ktor.client.engine.cio.d
                @Override // p9.InterfaceC5074l
                public final Object invoke(Object obj2) {
                    return ConnectionFactory.connect$lambda$0((SocketOptions.TCPClientSocketOptions) obj2);
                }
            };
        }
        return connectionFactory.connect(socketAddress, interfaceC5074l, interfaceC4014c);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final t connect$lambda$0(SocketOptions.TCPClientSocketOptions tCPClientSocketOptions) {
        p.i(tCPClientSocketOptions, "<this>");
        return t.f7040a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final eb.g connect$lambda$1(ConnectionFactory connectionFactory) {
        return eb.j.b(connectionFactory.addressConnectionsLimit, 0, 2, null);
    }

    /* JADX WARN: Code restructure failed: missing block: B:34:0x00b4, code lost:
    
        if (r9 != r1) goto L36;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /* JADX WARN: Type inference failed for: r7v0, types: [io.ktor.network.sockets.SocketAddress, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r7v1, types: [eb.g] */
    /* JADX WARN: Type inference failed for: r7v15 */
    /* JADX WARN: Type inference failed for: r7v16 */
    /* JADX WARN: Type inference failed for: r7v6 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object connect(io.ktor.network.sockets.SocketAddress r7, p9.InterfaceC5074l<? super io.ktor.network.sockets.SocketOptions.TCPClientSocketOptions, Y8.t> r8, e9.InterfaceC4014c<? super io.ktor.network.sockets.Socket> r9) throws java.lang.Throwable {
        /*
            r6 = this;
            boolean r0 = r9 instanceof io.ktor.client.engine.cio.ConnectionFactory.AnonymousClass1
            if (r0 == 0) goto L13
            r0 = r9
            io.ktor.client.engine.cio.ConnectionFactory$connect$1 r0 = (io.ktor.client.engine.cio.ConnectionFactory.AnonymousClass1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            io.ktor.client.engine.cio.ConnectionFactory$connect$1 r0 = new io.ktor.client.engine.cio.ConnectionFactory$connect$1
            r0.<init>(r9)
        L18:
            java.lang.Object r9 = r0.result
            java.lang.Object r1 = f9.C4063a.g()
            int r2 = r0.label
            r3 = 3
            r4 = 2
            r5 = 1
            if (r2 == 0) goto L66
            if (r2 == r5) goto L59
            if (r2 == r4) goto L47
            if (r2 != r3) goto L3f
            java.lang.Object r7 = r0.L$2
            eb.g r7 = (eb.g) r7
            java.lang.Object r8 = r0.L$1
            p9.l r8 = (p9.InterfaceC5074l) r8
            java.lang.Object r8 = r0.L$0
            io.ktor.network.sockets.SocketAddress r8 = (io.ktor.network.sockets.SocketAddress) r8
            kotlin.C4849c.b(r9)     // Catch: java.lang.Throwable -> L3c
            goto Lb7
        L3c:
            r8 = move-exception
            goto Lba
        L3f:
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
            java.lang.String r7 = "call to 'resume' before 'invoke' with coroutine"
            r6.<init>(r7)
            throw r6
        L47:
            java.lang.Object r7 = r0.L$2
            eb.g r7 = (eb.g) r7
            java.lang.Object r8 = r0.L$1
            p9.l r8 = (p9.InterfaceC5074l) r8
            java.lang.Object r2 = r0.L$0
            io.ktor.network.sockets.SocketAddress r2 = (io.ktor.network.sockets.SocketAddress) r2
            kotlin.C4849c.b(r9)     // Catch: java.lang.Throwable -> L57
            goto L96
        L57:
            r7 = move-exception
            goto Lbe
        L59:
            java.lang.Object r7 = r0.L$1
            r8 = r7
            p9.l r8 = (p9.InterfaceC5074l) r8
            java.lang.Object r7 = r0.L$0
            io.ktor.network.sockets.SocketAddress r7 = (io.ktor.network.sockets.SocketAddress) r7
            kotlin.C4849c.b(r9)
            goto L78
        L66:
            kotlin.C4849c.b(r9)
            eb.g r9 = r6.limit
            r0.L$0 = r7
            r0.L$1 = r8
            r0.label = r5
            java.lang.Object r9 = r9.c(r0)
            if (r9 != r1) goto L78
            goto Lb6
        L78:
            io.ktor.util.collections.ConcurrentMap<io.ktor.network.sockets.SocketAddress, eb.g> r9 = r6.addressLimit     // Catch: java.lang.Throwable -> L57
            io.ktor.client.engine.cio.c r2 = new io.ktor.client.engine.cio.c     // Catch: java.lang.Throwable -> L57
            r2.<init>()     // Catch: java.lang.Throwable -> L57
            java.lang.Object r9 = r9.computeIfAbsent(r7, r2)     // Catch: java.lang.Throwable -> L57
            eb.g r9 = (eb.g) r9     // Catch: java.lang.Throwable -> L57
            r0.L$0 = r7     // Catch: java.lang.Throwable -> L57
            r0.L$1 = r8     // Catch: java.lang.Throwable -> L57
            r0.L$2 = r9     // Catch: java.lang.Throwable -> L57
            r0.label = r4     // Catch: java.lang.Throwable -> L57
            java.lang.Object r2 = r9.c(r0)     // Catch: java.lang.Throwable -> L57
            if (r2 != r1) goto L94
            goto Lb6
        L94:
            r2 = r7
            r7 = r9
        L96:
            io.ktor.network.selector.SelectorManager r9 = r6.selector     // Catch: java.lang.Throwable -> L3c
            io.ktor.network.sockets.SocketBuilder r9 = io.ktor.network.sockets.BuildersKt.aSocket(r9)     // Catch: java.lang.Throwable -> L3c
            io.ktor.network.sockets.TcpSocketBuilder r9 = r9.tcp()     // Catch: java.lang.Throwable -> L3c
            java.lang.Object r4 = g9.h.a(r2)     // Catch: java.lang.Throwable -> L3c
            r0.L$0 = r4     // Catch: java.lang.Throwable -> L3c
            java.lang.Object r4 = g9.h.a(r8)     // Catch: java.lang.Throwable -> L3c
            r0.L$1 = r4     // Catch: java.lang.Throwable -> L3c
            r0.L$2 = r7     // Catch: java.lang.Throwable -> L3c
            r0.label = r3     // Catch: java.lang.Throwable -> L3c
            java.lang.Object r9 = r9.connect(r2, r8, r0)     // Catch: java.lang.Throwable -> L3c
            if (r9 != r1) goto Lb7
        Lb6:
            return r1
        Lb7:
            io.ktor.network.sockets.Socket r9 = (io.ktor.network.sockets.Socket) r9     // Catch: java.lang.Throwable -> L3c
            return r9
        Lba:
            r7.release()     // Catch: java.lang.Throwable -> L57
            throw r8     // Catch: java.lang.Throwable -> L57
        Lbe:
            eb.g r6 = r6.limit
            r6.release()
            throw r7
        */
        throw new UnsupportedOperationException("Method not decompiled: io.ktor.client.engine.cio.ConnectionFactory.connect(io.ktor.network.sockets.SocketAddress, p9.l, e9.c):java.lang.Object");
    }

    public final void release(SocketAddress address) {
        p.i(address, "address");
        eb.g gVar = this.addressLimit.get(address);
        if (gVar != null) {
            gVar.release();
        }
        this.limit.release();
    }
}
