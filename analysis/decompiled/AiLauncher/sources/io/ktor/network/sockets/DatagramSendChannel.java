package io.ktor.network.sockets;

import Wa.s;
import Y8.t;
import com.autonavi.aps.amapapi.config.Const;
import com.stepos.ailauncher.foundation.appui.card.provider.alipay.AlipayXuiIsland;
import e9.InterfaceC4014c;
import eb.InterfaceC4021a;
import fb.C4074a;
import fb.o;
import g9.InterfaceC4112d;
import io.ktor.network.util.PoolsKt;
import io.ktor.utils.io.core.ByteReadPacketKt;
import io.ktor.utils.io.pool.ObjectPool;
import java.nio.ByteBuffer;
import java.nio.channels.DatagramChannel;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import kb.C4845d;
import kotlin.Metadata;
import kotlin.NotImplementedError;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.jvm.internal.p;
import p9.InterfaceC5074l;

@Metadata(d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0003\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0000\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0017\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0005¢\u0006\u0004\b\u0007\u0010\bJ \u0010\u000e\u001a\u00020\r2\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\u000bH\u0082@¢\u0006\u0004\b\u000e\u0010\u000fJ\u000f\u0010\u0010\u001a\u00020\rH\u0002¢\u0006\u0004\b\u0010\u0010\u0011J\u0019\u0010\u0015\u001a\u00020\u00142\b\u0010\u0013\u001a\u0004\u0018\u00010\u0012H\u0016¢\u0006\u0004\b\u0015\u0010\u0016J\u001d\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\r0\u00182\u0006\u0010\u0017\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0019\u0010\u001aJ\u0018\u0010\u001c\u001a\u00020\r2\u0006\u0010\u0017\u001a\u00020\u0002H\u0096@¢\u0006\u0004\b\u001c\u0010\u001dJ%\u0010 \u001a\u00020\r2\u0014\u0010\u001f\u001a\u0010\u0012\u0006\u0012\u0004\u0018\u00010\u0012\u0012\u0004\u0012\u00020\r0\u001eH\u0017¢\u0006\u0004\b \u0010!R\u0017\u0010\u0004\u001a\u00020\u00038\u0006¢\u0006\f\n\u0004\b\u0004\u0010\"\u001a\u0004\b#\u0010$R\u0017\u0010\u0006\u001a\u00020\u00058\u0006¢\u0006\f\n\u0004\b\u0006\u0010%\u001a\u0004\b&\u0010'R\u0014\u0010)\u001a\u00020(8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b)\u0010*R\u001a\u0010+\u001a\u00020\u00148VX\u0097\u0004¢\u0006\f\u0012\u0004\b-\u0010\u0011\u001a\u0004\b+\u0010,R&\u00101\u001a\u0014\u0012\u0004\u0012\u00020\u0002\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00020\u00010.8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b/\u00100¨\u00062"}, d2 = {"Lio/ktor/network/sockets/DatagramSendChannel;", "LWa/s;", "Lio/ktor/network/sockets/Datagram;", "Ljava/nio/channels/DatagramChannel;", "channel", "Lio/ktor/network/sockets/DatagramSocketImpl;", "socket", "<init>", "(Ljava/nio/channels/DatagramChannel;Lio/ktor/network/sockets/DatagramSocketImpl;)V", "Ljava/nio/ByteBuffer;", "buffer", "Lio/ktor/network/sockets/SocketAddress;", Const.JSON_KEY_ADDRESS, "LY8/t;", "sendSuspend", "(Ljava/nio/ByteBuffer;Lio/ktor/network/sockets/SocketAddress;Le9/c;)Ljava/lang/Object;", "closeAndCheckHandler", "()V", "", "cause", "", "close", "(Ljava/lang/Throwable;)Z", "element", "Lkotlinx/coroutines/channels/a;", "trySend-JP2dKIU", "(Lio/ktor/network/sockets/Datagram;)Ljava/lang/Object;", "trySend", "send", "(Lio/ktor/network/sockets/Datagram;Le9/c;)Ljava/lang/Object;", "Lkotlin/Function1;", "handler", "invokeOnClose", "(Lp9/l;)V", "Ljava/nio/channels/DatagramChannel;", "getChannel", "()Ljava/nio/channels/DatagramChannel;", "Lio/ktor/network/sockets/DatagramSocketImpl;", "getSocket", "()Lio/ktor/network/sockets/DatagramSocketImpl;", "Leb/a;", "lock", "Leb/a;", "isClosedForSend", "()Z", "isClosedForSend$annotations", "Lcb/h;", "getOnSend", "()Lcb/h;", "onSend", "ktor-network"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class DatagramSendChannel implements s<Datagram> {
    private final DatagramChannel channel;
    private volatile /* synthetic */ int closed;
    private volatile /* synthetic */ Object closedCause;
    private final InterfaceC4021a lock;
    private volatile /* synthetic */ Object onCloseHandler;
    private final DatagramSocketImpl socket;
    private static final /* synthetic */ AtomicReferenceFieldUpdater onCloseHandler$FU = AtomicReferenceFieldUpdater.newUpdater(DatagramSendChannel.class, Object.class, "onCloseHandler");
    private static final /* synthetic */ AtomicIntegerFieldUpdater closed$FU = AtomicIntegerFieldUpdater.newUpdater(DatagramSendChannel.class, AlipayXuiIsland.REASON_CLOSED);

    @InterfaceC4112d(c = "io.ktor.network.sockets.DatagramSendChannel", f = "DatagramSendChannel.kt", l = {201, 95}, m = "send")
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    /* renamed from: io.ktor.network.sockets.DatagramSendChannel$send$1, reason: invalid class name */
    public static final class AnonymousClass1 extends ContinuationImpl {
        int I$0;
        int I$1;
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
            return DatagramSendChannel.this.send2((Datagram) null, (InterfaceC4014c<? super t>) this);
        }
    }

    @InterfaceC4112d(c = "io.ktor.network.sockets.DatagramSendChannel", f = "DatagramSendChannel.kt", l = {136}, m = "sendSuspend")
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    /* renamed from: io.ktor.network.sockets.DatagramSendChannel$sendSuspend$1, reason: invalid class name and case insensitive filesystem */
    public static final class C43071 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        int label;
        /* synthetic */ Object result;

        public C43071(InterfaceC4014c<? super C43071> interfaceC4014c) {
            super(interfaceC4014c);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return DatagramSendChannel.this.sendSuspend(null, null, this);
        }
    }

    public DatagramSendChannel(DatagramChannel channel, DatagramSocketImpl socket) {
        p.i(channel, "channel");
        p.i(socket, "socket");
        this.channel = channel;
        this.socket = socket;
        this.onCloseHandler = null;
        this.closed = 0;
        this.closedCause = null;
        this.lock = eb.f.b(false, 1, null);
    }

    private final void closeAndCheckHandler() {
        do {
            InterfaceC5074l interfaceC5074l = (InterfaceC5074l) this.onCloseHandler;
            if (interfaceC5074l == DatagramSendChannelKt.CLOSED_INVOKED) {
                return;
            }
            if (interfaceC5074l != null) {
                if (!onCloseHandler$FU.compareAndSet(this, interfaceC5074l, DatagramSendChannelKt.CLOSED_INVOKED)) {
                    throw new IllegalArgumentException("Failed requirement.");
                }
                interfaceC5074l.invoke(this.closedCause);
                return;
            }
        } while (!onCloseHandler$FU.compareAndSet(this, null, DatagramSendChannelKt.CLOSED));
    }

    public static /* synthetic */ void isClosedForSend$annotations() {
    }

    /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxOverflowException: Regions count limit reached
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
        	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
        	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
        */
    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:17:0x005a A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:20:0x0067  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:16:0x0058 -> B:18:0x005b). Please report as a decompilation issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object sendSuspend(java.nio.ByteBuffer r7, io.ktor.network.sockets.SocketAddress r8, e9.InterfaceC4014c<? super Y8.t> r9) {
        /*
            r6 = this;
            boolean r0 = r9 instanceof io.ktor.network.sockets.DatagramSendChannel.C43071
            if (r0 == 0) goto L13
            r0 = r9
            io.ktor.network.sockets.DatagramSendChannel$sendSuspend$1 r0 = (io.ktor.network.sockets.DatagramSendChannel.C43071) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            io.ktor.network.sockets.DatagramSendChannel$sendSuspend$1 r0 = new io.ktor.network.sockets.DatagramSendChannel$sendSuspend$1
            r0.<init>(r9)
        L18:
            java.lang.Object r9 = r0.result
            java.lang.Object r1 = f9.C4063a.g()
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L3c
            if (r2 != r3) goto L34
            java.lang.Object r7 = r0.L$1
            io.ktor.network.sockets.SocketAddress r7 = (io.ktor.network.sockets.SocketAddress) r7
            java.lang.Object r8 = r0.L$0
            java.nio.ByteBuffer r8 = (java.nio.ByteBuffer) r8
            kotlin.C4849c.b(r9)
            r5 = r8
            r8 = r7
            r7 = r5
            goto L5b
        L34:
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
            java.lang.String r7 = "call to 'resume' before 'invoke' with coroutine"
            r6.<init>(r7)
            throw r6
        L3c:
            kotlin.C4849c.b(r9)
        L3f:
            io.ktor.network.sockets.DatagramSocketImpl r9 = r6.socket
            io.ktor.network.selector.SelectInterest r2 = io.ktor.network.selector.SelectInterest.WRITE
            r9.interestOp(r2, r3)
            io.ktor.network.sockets.DatagramSocketImpl r9 = r6.socket
            io.ktor.network.selector.SelectorManager r9 = r9.getSelector()
            io.ktor.network.sockets.DatagramSocketImpl r4 = r6.socket
            r0.L$0 = r7
            r0.L$1 = r8
            r0.label = r3
            java.lang.Object r9 = r9.select(r4, r2, r0)
            if (r9 != r1) goto L5b
            return r1
        L5b:
            java.nio.channels.DatagramChannel r9 = r6.channel
            java.net.SocketAddress r2 = io.ktor.network.sockets.JavaSocketAddressUtilsKt.toJavaAddress(r8)
            int r9 = r9.send(r7, r2)
            if (r9 == 0) goto L3f
            io.ktor.network.sockets.DatagramSocketImpl r6 = r6.socket
            io.ktor.network.selector.SelectInterest r7 = io.ktor.network.selector.SelectInterest.WRITE
            r8 = 0
            r6.interestOp(r7, r8)
            Y8.t r6 = Y8.t.f7040a
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: io.ktor.network.sockets.DatagramSendChannel.sendSuspend(java.nio.ByteBuffer, io.ktor.network.sockets.SocketAddress, e9.c):java.lang.Object");
    }

    @Override // Wa.s
    public boolean close(Throwable cause) {
        if (!closed$FU.compareAndSet(this, 0, 1)) {
            return false;
        }
        this.closedCause = cause;
        if (!this.socket.isClosed()) {
            this.socket.close();
        }
        closeAndCheckHandler();
        return true;
    }

    public final DatagramChannel getChannel() {
        return this.channel;
    }

    public cb.h<Datagram, s<Datagram>> getOnSend() {
        throw new NotImplementedError("An operation is not implemented: [DatagramSendChannel] doesn't support [onSend] select clause");
    }

    public final DatagramSocketImpl getSocket() {
        return this.socket;
    }

    @Override // Wa.s
    public void invokeOnClose(InterfaceC5074l<? super Throwable, t> handler) {
        p.i(handler, "handler");
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = onCloseHandler$FU;
        if (atomicReferenceFieldUpdater.compareAndSet(this, null, handler)) {
            return;
        }
        if (this.onCloseHandler != DatagramSendChannelKt.CLOSED) {
            DatagramSendChannelKt.failInvokeOnClose((InterfaceC5074l) this.onCloseHandler);
        } else {
            if (!atomicReferenceFieldUpdater.compareAndSet(this, DatagramSendChannelKt.CLOSED, DatagramSendChannelKt.CLOSED_INVOKED)) {
                throw new IllegalArgumentException("Failed requirement.");
            }
            handler.invoke(this.closedCause);
        }
    }

    /* JADX WARN: Type inference failed for: r0v1, types: [boolean, int] */
    @Override // Wa.s
    public boolean isClosedForSend() {
        return this.closed;
    }

    @Override // Wa.s
    public boolean offer(Datagram datagram) {
        return s.a.b(this, datagram);
    }

    @Override // Wa.s
    public /* bridge */ /* synthetic */ Object send(Datagram datagram, InterfaceC4014c interfaceC4014c) {
        return send2(datagram, (InterfaceC4014c<? super t>) interfaceC4014c);
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /* renamed from: send, reason: avoid collision after fix types in other method */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public java.lang.Object send2(io.ktor.network.sockets.Datagram r9, e9.InterfaceC4014c<? super Y8.t> r10) throws java.lang.Throwable {
        /*
            r8 = this;
            boolean r0 = r10 instanceof io.ktor.network.sockets.DatagramSendChannel.AnonymousClass1
            if (r0 == 0) goto L13
            r0 = r10
            io.ktor.network.sockets.DatagramSendChannel$send$1 r0 = (io.ktor.network.sockets.DatagramSendChannel.AnonymousClass1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            io.ktor.network.sockets.DatagramSendChannel$send$1 r0 = new io.ktor.network.sockets.DatagramSendChannel$send$1
            r0.<init>(r10)
        L18:
            java.lang.Object r10 = r0.result
            java.lang.Object r1 = f9.C4063a.g()
            int r2 = r0.label
            r3 = 0
            r4 = 2
            r5 = 1
            r6 = 0
            if (r2 == 0) goto L51
            if (r2 == r5) goto L40
            if (r2 != r4) goto L38
            java.lang.Object r8 = r0.L$1
            eb.a r8 = (eb.InterfaceC4021a) r8
            java.lang.Object r9 = r0.L$0
            io.ktor.network.sockets.Datagram r9 = (io.ktor.network.sockets.Datagram) r9
            kotlin.C4849c.b(r10)     // Catch: java.lang.Throwable -> L36
            goto L85
        L36:
            r9 = move-exception
            goto L8f
        L38:
            java.lang.IllegalStateException r8 = new java.lang.IllegalStateException
            java.lang.String r9 = "call to 'resume' before 'invoke' with coroutine"
            r8.<init>(r9)
            throw r8
        L40:
            int r9 = r0.I$0
            java.lang.Object r2 = r0.L$1
            eb.a r2 = (eb.InterfaceC4021a) r2
            java.lang.Object r5 = r0.L$0
            io.ktor.network.sockets.Datagram r5 = (io.ktor.network.sockets.Datagram) r5
            kotlin.C4849c.b(r10)
            r10 = r2
            r2 = r9
            r9 = r5
            goto L66
        L51:
            kotlin.C4849c.b(r10)
            eb.a r10 = r8.lock
            r0.L$0 = r9
            r0.L$1 = r10
            r0.I$0 = r3
            r0.label = r5
            java.lang.Object r2 = r10.m(r6, r0)
            if (r2 != r1) goto L65
            goto L83
        L65:
            r2 = r3
        L66:
            Ua.I r5 = Ua.Y.b()     // Catch: java.lang.Throwable -> L8d
            io.ktor.network.sockets.DatagramSendChannel$send$2$1 r7 = new io.ktor.network.sockets.DatagramSendChannel$send$2$1     // Catch: java.lang.Throwable -> L8d
            r7.<init>(r9, r8, r6)     // Catch: java.lang.Throwable -> L8d
            java.lang.Object r8 = g9.h.a(r9)     // Catch: java.lang.Throwable -> L8d
            r0.L$0 = r8     // Catch: java.lang.Throwable -> L8d
            r0.L$1 = r10     // Catch: java.lang.Throwable -> L8d
            r0.I$0 = r2     // Catch: java.lang.Throwable -> L8d
            r0.I$1 = r3     // Catch: java.lang.Throwable -> L8d
            r0.label = r4     // Catch: java.lang.Throwable -> L8d
            java.lang.Object r8 = Ua.C1056g.j(r5, r7, r0)     // Catch: java.lang.Throwable -> L8d
            if (r8 != r1) goto L84
        L83:
            return r1
        L84:
            r8 = r10
        L85:
            Y8.t r9 = Y8.t.f7040a     // Catch: java.lang.Throwable -> L36
            r8.l(r6)
            Y8.t r8 = Y8.t.f7040a
            return r8
        L8d:
            r9 = move-exception
            r8 = r10
        L8f:
            r8.l(r6)
            throw r9
        */
        throw new UnsupportedOperationException("Method not decompiled: io.ktor.network.sockets.DatagramSendChannel.send2(io.ktor.network.sockets.Datagram, e9.c):java.lang.Object");
    }

    @Override // Wa.s
    /* renamed from: trySend-JP2dKIU, reason: avoid collision after fix types in other method and not valid java name and merged with bridge method [inline-methods] */
    public Object mo0trySendJP2dKIU(Datagram element) {
        boolean z10;
        p.i(element, "element");
        if (!InterfaceC4021a.b(this.lock, null, 1, null)) {
            return kotlinx.coroutines.channels.a.INSTANCE.b();
        }
        try {
            long remaining = ByteReadPacketKt.getRemaining(element.getPacket());
            C4845d c4845d = C4845d.f34666a;
            C4074a bufferField = element.getPacket().getBufferField();
            if (bufferField.k()) {
                throw new IllegalArgumentException("Buffer is empty");
            }
            o head = bufferField.getHead();
            p.f(head);
            byte[] bArrB = head.b(true);
            int pos = head.getPos();
            ByteBuffer byteBufferAsReadOnlyBuffer = ByteBuffer.wrap(bArrB, pos, head.getLimit() - pos).slice().asReadOnlyBuffer();
            p.f(byteBufferAsReadOnlyBuffer);
            if (byteBufferAsReadOnlyBuffer.remaining() < remaining) {
                z10 = true;
            } else {
                z10 = false;
                if (this.channel.send(byteBufferAsReadOnlyBuffer, JavaSocketAddressUtilsKt.toJavaAddress(element.getAddress())) == 0) {
                    byteBufferAsReadOnlyBuffer.position(byteBufferAsReadOnlyBuffer.limit());
                } else {
                    byteBufferAsReadOnlyBuffer.position(0);
                }
            }
            int iPosition = byteBufferAsReadOnlyBuffer.position();
            if (iPosition != 0) {
                if (iPosition < 0) {
                    throw new IllegalStateException("Returned negative read bytes count");
                }
                if (iPosition > head.j()) {
                    throw new IllegalStateException("Returned too many bytes");
                }
                bufferField.skip(iPosition);
            }
            if (z10) {
                ObjectPool<ByteBuffer> defaultDatagramByteBufferPool = PoolsKt.getDefaultDatagramByteBufferPool();
                ByteBuffer byteBufferBorrow = defaultDatagramByteBufferPool.borrow();
                try {
                    ByteBuffer byteBuffer = byteBufferBorrow;
                    DatagramSendChannelKt.writeMessageTo(element.getPacket().peek(), byteBuffer);
                    if (this.channel.send(byteBuffer, JavaSocketAddressUtilsKt.toJavaAddress(element.getAddress())) == 0) {
                        ByteReadPacketKt.discard$default(element.getPacket(), 0L, 1, null);
                    }
                    t tVar = t.f7040a;
                    defaultDatagramByteBufferPool.recycle(byteBufferBorrow);
                } catch (Throwable th) {
                    defaultDatagramByteBufferPool.recycle(byteBufferBorrow);
                    throw th;
                }
            }
            InterfaceC4021a.i(this.lock, null, 1, null);
            return kotlinx.coroutines.channels.a.INSTANCE.c(t.f7040a);
        } catch (Throwable th2) {
            InterfaceC4021a.i(this.lock, null, 1, null);
            throw th2;
        }
    }
}
