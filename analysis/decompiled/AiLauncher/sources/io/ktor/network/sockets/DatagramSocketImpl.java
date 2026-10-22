package io.ktor.network.sockets;

import Ua.Y;
import Wa.r;
import Wa.s;
import Y8.t;
import e9.InterfaceC4014c;
import fb.C4074a;
import g9.InterfaceC4112d;
import io.ktor.network.selector.SelectInterest;
import io.ktor.network.selector.SelectorManager;
import io.ktor.network.util.PoolsKt;
import io.ktor.utils.io.core.BytePacketBuilderExtensions_jvmKt;
import java.nio.ByteBuffer;
import java.nio.channels.DatagramChannel;
import kotlin.Metadata;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.jvm.internal.p;
import kotlinx.coroutines.channels.ProduceKt;

@Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\f\b\u0000\u0018\u00002\u00020\u00012\u00020\u00022\b\u0012\u0004\u0012\u00020\u00040\u0003B\u0017\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\u0006\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\b\u0010\tJ\u0010\u0010\u000b\u001a\u00020\nH\u0082@¢\u0006\u0004\b\u000b\u0010\fJ\u0018\u0010\u000f\u001a\u00020\n2\u0006\u0010\u000e\u001a\u00020\rH\u0082P¢\u0006\u0004\b\u000f\u0010\u0010J\u000f\u0010\u0012\u001a\u00020\u0011H\u0016¢\u0006\u0004\b\u0012\u0010\u0013R\u001a\u0010\u0005\u001a\u00020\u00048\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u0005\u0010\u0014\u001a\u0004\b\u0015\u0010\u0016R\u001a\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\n0\u00178\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0018\u0010\u0019R \u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\n0\u001a8\u0002X\u0082\u0004¢\u0006\f\n\u0004\b\u001b\u0010\u001c\u0012\u0004\b\u001d\u0010\u0013R\u0014\u0010!\u001a\u00020\u001e8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u001f\u0010 R\u0014\u0010#\u001a\u00020\u001e8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\"\u0010 R\u001a\u0010&\u001a\b\u0012\u0004\u0012\u00020\n0\u001a8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b$\u0010%R\u001a\u0010)\u001a\b\u0012\u0004\u0012\u00020\n0\u00178VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b'\u0010(¨\u0006*"}, d2 = {"Lio/ktor/network/sockets/DatagramSocketImpl;", "Lio/ktor/network/sockets/BoundDatagramSocket;", "Lio/ktor/network/sockets/ConnectedDatagramSocket;", "Lio/ktor/network/sockets/NIOSocketImpl;", "Ljava/nio/channels/DatagramChannel;", "channel", "Lio/ktor/network/selector/SelectorManager;", "selector", "<init>", "(Ljava/nio/channels/DatagramChannel;Lio/ktor/network/selector/SelectorManager;)V", "Lio/ktor/network/sockets/Datagram;", "receiveImpl", "(Le9/c;)Ljava/lang/Object;", "Ljava/nio/ByteBuffer;", "buffer", "receiveSuspend", "(Ljava/nio/ByteBuffer;Le9/c;)Ljava/lang/Object;", "LY8/t;", "close", "()V", "Ljava/nio/channels/DatagramChannel;", "getChannel", "()Ljava/nio/channels/DatagramChannel;", "LWa/s;", "sender", "LWa/s;", "LWa/r;", "receiver", "LWa/r;", "getReceiver$annotations", "Lio/ktor/network/sockets/SocketAddress;", "getLocalAddress", "()Lio/ktor/network/sockets/SocketAddress;", "localAddress", "getRemoteAddress", "remoteAddress", "getIncoming", "()LWa/r;", "incoming", "getOutgoing", "()LWa/s;", "outgoing", "ktor-network"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class DatagramSocketImpl extends NIOSocketImpl<DatagramChannel> implements BoundDatagramSocket, ConnectedDatagramSocket {
    private final DatagramChannel channel;
    private final r<Datagram> receiver;
    private final s<Datagram> sender;

    @InterfaceC4112d(c = "io.ktor.network.sockets.DatagramSocketImpl", f = "DatagramSocketImpl.kt", l = {90}, m = "receiveSuspend")
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    /* renamed from: io.ktor.network.sockets.DatagramSocketImpl$receiveSuspend$1, reason: invalid class name */
    public static final class AnonymousClass1 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        int label;
        /* synthetic */ Object result;

        public AnonymousClass1(InterfaceC4014c<? super AnonymousClass1> interfaceC4014c) {
            super(interfaceC4014c);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return DatagramSocketImpl.this.receiveSuspend(null, this);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DatagramSocketImpl(DatagramChannel channel, SelectorManager selector) {
        super(channel, selector, PoolsKt.getDefaultDatagramByteBufferPool(), null, 8, null);
        p.i(channel, "channel");
        p.i(selector, "selector");
        this.channel = channel;
        this.sender = new DatagramSendChannel(getChannel(), this);
        this.receiver = ProduceKt.e(this, Y.b(), 0, new DatagramSocketImpl$receiver$1(this, null), 2, null);
    }

    private static /* synthetic */ void getReceiver$annotations() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Object receiveImpl(InterfaceC4014c<? super Datagram> interfaceC4014c) {
        ByteBuffer byteBufferBorrow = PoolsKt.getDefaultDatagramByteBufferPool().borrow();
        try {
            java.net.SocketAddress socketAddressReceive = getChannel().receive(byteBufferBorrow);
            if (socketAddressReceive == null) {
                return receiveSuspend(byteBufferBorrow, interfaceC4014c);
            }
            interestOp(SelectInterest.READ, false);
            byteBufferBorrow.flip();
            C4074a c4074a = new C4074a();
            BytePacketBuilderExtensions_jvmKt.writeFully(c4074a, byteBufferBorrow);
            Datagram datagram = new Datagram(c4074a, JavaSocketAddressUtilsKt.toSocketAddress(socketAddressReceive));
            return datagram;
        } finally {
            PoolsKt.getDefaultDatagramByteBufferPool().recycle(byteBufferBorrow);
        }
    }

    /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxOverflowException: Regions count limit reached
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
        	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
        	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
        */
    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:17:0x0051 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:21:0x005d  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:16:0x004f -> B:26:0x0052). Please report as a decompilation issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object receiveSuspend(java.nio.ByteBuffer r5, e9.InterfaceC4014c<? super io.ktor.network.sockets.Datagram> r6) {
        /*
            r4 = this;
            boolean r0 = r6 instanceof io.ktor.network.sockets.DatagramSocketImpl.AnonymousClass1
            if (r0 == 0) goto L13
            r0 = r6
            io.ktor.network.sockets.DatagramSocketImpl$receiveSuspend$1 r0 = (io.ktor.network.sockets.DatagramSocketImpl.AnonymousClass1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            io.ktor.network.sockets.DatagramSocketImpl$receiveSuspend$1 r0 = new io.ktor.network.sockets.DatagramSocketImpl$receiveSuspend$1
            r0.<init>(r6)
        L18:
            java.lang.Object r6 = r0.result
            java.lang.Object r1 = f9.C4063a.g()
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L39
            if (r2 != r3) goto L31
            java.lang.Object r4 = r0.L$1
            io.ktor.network.sockets.DatagramSocketImpl r4 = (io.ktor.network.sockets.DatagramSocketImpl) r4
            java.lang.Object r5 = r0.L$0
            java.nio.ByteBuffer r5 = (java.nio.ByteBuffer) r5
            kotlin.C4849c.b(r6)
            goto L52
        L31:
            java.lang.IllegalStateException r4 = new java.lang.IllegalStateException
            java.lang.String r5 = "call to 'resume' before 'invoke' with coroutine"
            r4.<init>(r5)
            throw r4
        L39:
            kotlin.C4849c.b(r6)
        L3c:
            io.ktor.network.selector.SelectInterest r6 = io.ktor.network.selector.SelectInterest.READ
            r4.interestOp(r6, r3)
            io.ktor.network.selector.SelectorManager r2 = r4.getSelector()
            r0.L$0 = r5
            r0.L$1 = r4
            r0.label = r3
            java.lang.Object r6 = r2.select(r4, r6, r0)
            if (r6 != r1) goto L52
            return r1
        L52:
            java.nio.channels.DatagramChannel r6 = r4.getChannel()     // Catch: java.lang.Throwable -> L7f
            java.net.SocketAddress r6 = r6.receive(r5)     // Catch: java.lang.Throwable -> L7f
            if (r6 != 0) goto L5d
            goto L3c
        L5d:
            io.ktor.network.selector.SelectInterest r0 = io.ktor.network.selector.SelectInterest.READ
            r1 = 0
            r4.interestOp(r0, r1)
            r5.flip()
            fb.a r4 = new fb.a
            r4.<init>()
            io.ktor.utils.io.core.BytePacketBuilderExtensions_jvmKt.writeFully(r4, r5)
            io.ktor.network.sockets.SocketAddress r6 = io.ktor.network.sockets.JavaSocketAddressUtilsKt.toSocketAddress(r6)
            io.ktor.network.sockets.Datagram r0 = new io.ktor.network.sockets.Datagram
            r0.<init>(r4, r6)
            io.ktor.utils.io.pool.ObjectPool r4 = io.ktor.network.util.PoolsKt.getDefaultDatagramByteBufferPool()
            r4.recycle(r5)
            return r0
        L7f:
            r4 = move-exception
            io.ktor.utils.io.pool.ObjectPool r6 = io.ktor.network.util.PoolsKt.getDefaultDatagramByteBufferPool()
            r6.recycle(r5)
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: io.ktor.network.sockets.DatagramSocketImpl.receiveSuspend(java.nio.ByteBuffer, e9.c):java.lang.Object");
    }

    @Override // io.ktor.network.sockets.SocketBase, io.ktor.network.selector.SelectableBase, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        r.o(this.receiver, null, 1, null);
        super.close();
        s.a(this.sender, null, 1, null);
    }

    @Override // io.ktor.network.sockets.DatagramReadChannel
    public r<Datagram> getIncoming() {
        return this.receiver;
    }

    @Override // io.ktor.network.sockets.ABoundSocket
    public SocketAddress getLocalAddress() {
        SocketAddress socketAddress;
        java.net.SocketAddress localAddress = JavaSocketOptionsKt.getJava7NetworkApisAvailable() ? getChannel().getLocalAddress() : getChannel().socket().getLocalSocketAddress();
        if (localAddress == null || (socketAddress = JavaSocketAddressUtilsKt.toSocketAddress(localAddress)) == null) {
            throw new IllegalStateException("Channel is not yet bound");
        }
        return socketAddress;
    }

    @Override // io.ktor.network.sockets.DatagramWriteChannel
    public s<Datagram> getOutgoing() {
        return this.sender;
    }

    @Override // io.ktor.network.sockets.AConnectedSocket
    public SocketAddress getRemoteAddress() {
        SocketAddress socketAddress;
        java.net.SocketAddress remoteAddress = JavaSocketOptionsKt.getJava7NetworkApisAvailable() ? getChannel().getRemoteAddress() : getChannel().socket().getRemoteSocketAddress();
        if (remoteAddress == null || (socketAddress = JavaSocketAddressUtilsKt.toSocketAddress(remoteAddress)) == null) {
            throw new IllegalStateException("Channel is not yet connected");
        }
        return socketAddress;
    }

    @Override // io.ktor.network.sockets.DatagramReadChannel
    public Object receive(InterfaceC4014c<? super Datagram> interfaceC4014c) {
        return super.receive(interfaceC4014c);
    }

    @Override // io.ktor.network.sockets.DatagramWriteChannel
    public Object send(Datagram datagram, InterfaceC4014c<? super t> interfaceC4014c) {
        return super.send(datagram, interfaceC4014c);
    }

    @Override // io.ktor.network.sockets.NIOSocketImpl, io.ktor.network.selector.Selectable
    public DatagramChannel getChannel() {
        return this.channel;
    }
}
