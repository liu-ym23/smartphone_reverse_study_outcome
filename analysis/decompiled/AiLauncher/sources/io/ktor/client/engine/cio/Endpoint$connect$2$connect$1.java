package io.ktor.client.engine.cio;

import Ua.M;
import Y8.t;
import e9.InterfaceC4014c;
import f9.C4063a;
import g9.InterfaceC4112d;
import io.ktor.network.sockets.Socket;
import io.ktor.network.sockets.SocketAddress;
import io.ktor.network.sockets.SocketOptions;
import kotlin.C4849c;
import kotlin.Metadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import p9.InterfaceC5074l;
import p9.p;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"LUa/M;", "Lio/ktor/network/sockets/Socket;", "<anonymous>", "(LUa/M;)Lio/ktor/network/sockets/Socket;"}, k = 3, mv = {2, 2, 0})
@InterfaceC4112d(c = "io.ktor.client.engine.cio.Endpoint$connect$2$connect$1", f = "Endpoint.kt", l = {215}, m = "invokeSuspend")
/* loaded from: classes4.dex */
public final class Endpoint$connect$2$connect$1 extends SuspendLambda implements p<M, InterfaceC4014c<? super Socket>, Object> {
    final /* synthetic */ SocketAddress $address;
    final /* synthetic */ long $socketTimeout;
    int label;
    final /* synthetic */ Endpoint this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public Endpoint$connect$2$connect$1(Endpoint endpoint, SocketAddress socketAddress, long j10, InterfaceC4014c<? super Endpoint$connect$2$connect$1> interfaceC4014c) {
        super(2, interfaceC4014c);
        this.this$0 = endpoint;
        this.$address = socketAddress;
        this.$socketTimeout = j10;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final t invokeSuspend$lambda$0(long j10, SocketOptions.TCPClientSocketOptions tCPClientSocketOptions) {
        tCPClientSocketOptions.setSocketTimeout(j10);
        return t.f7040a;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final InterfaceC4014c<t> create(Object obj, InterfaceC4014c<?> interfaceC4014c) {
        return new Endpoint$connect$2$connect$1(this.this$0, this.$address, this.$socketTimeout, interfaceC4014c);
    }

    @Override // p9.p
    public final Object invoke(M m10, InterfaceC4014c<? super Socket> interfaceC4014c) {
        return ((Endpoint$connect$2$connect$1) create(m10, interfaceC4014c)).invokeSuspend(t.f7040a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        Object objG = C4063a.g();
        int i10 = this.label;
        if (i10 != 0) {
            if (i10 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            C4849c.b(obj);
            return obj;
        }
        C4849c.b(obj);
        ConnectionFactory connectionFactory = this.this$0.connectionFactory;
        SocketAddress socketAddress = this.$address;
        final long j10 = this.$socketTimeout;
        InterfaceC5074l<? super SocketOptions.TCPClientSocketOptions, t> interfaceC5074l = new InterfaceC5074l() { // from class: io.ktor.client.engine.cio.j
            @Override // p9.InterfaceC5074l
            public final Object invoke(Object obj2) {
                return Endpoint$connect$2$connect$1.invokeSuspend$lambda$0(j10, (SocketOptions.TCPClientSocketOptions) obj2);
            }
        };
        this.label = 1;
        Object objConnect = connectionFactory.connect(socketAddress, interfaceC5074l, this);
        return objConnect == objG ? objG : objConnect;
    }
}
