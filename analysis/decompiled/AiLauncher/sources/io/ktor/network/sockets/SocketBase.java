package io.ktor.network.sockets;

import Ua.C1060i;
import Ua.C1086v0;
import Ua.CoroutineName;
import Ua.InterfaceC1089x;
import Ua.M;
import Y8.t;
import e9.InterfaceC4014c;
import f9.C4063a;
import g9.InterfaceC4112d;
import io.ktor.network.selector.SelectableBase;
import io.ktor.utils.io.ByteChannel;
import io.ktor.utils.io.ByteChannelUtilsKt;
import io.ktor.utils.io.ByteWriteChannelOperationsKt;
import io.ktor.utils.io.ReaderJob;
import io.ktor.utils.io.WriterJob;
import java.io.IOException;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import kotlin.C4849c;
import kotlin.Metadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import p9.InterfaceC5074l;
import p9.p;

@Metadata(d1 = {"\u0000^\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0003\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0007\b \u0018\u00002\u00020\u00012\u00020\u00022\u00020\u0003B\u000f\u0012\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0006\u0010\u0007J\u000f\u0010\t\u001a\u00020\bH\u0002¢\u0006\u0004\b\t\u0010\nJ%\u0010\u000e\u001a\u0004\u0018\u00010\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\u000b2\b\u0010\r\u001a\u0004\u0018\u00010\u000bH\u0002¢\u0006\u0004\b\u000e\u0010\u000fJ\u000f\u0010\u0010\u001a\u00020\bH\u0016¢\u0006\u0004\b\u0010\u0010\nJ\u000f\u0010\u0011\u001a\u00020\bH\u0016¢\u0006\u0004\b\u0011\u0010\nJ\u0015\u0010\u0015\u001a\u00020\u00142\u0006\u0010\u0013\u001a\u00020\u0012¢\u0006\u0004\b\u0015\u0010\u0016J\u0015\u0010\u0018\u001a\u00020\u00172\u0006\u0010\u0013\u001a\u00020\u0012¢\u0006\u0004\b\u0018\u0010\u0019J\u0017\u0010\u001a\u001a\u00020\u00142\u0006\u0010\u0013\u001a\u00020\u0012H&¢\u0006\u0004\b\u001a\u0010\u0016J\u0017\u0010\u001b\u001a\u00020\u00172\u0006\u0010\u0013\u001a\u00020\u0012H&¢\u0006\u0004\b\u001b\u0010\u0019J\u0011\u0010\u001e\u001a\u0004\u0018\u00010\u000bH ¢\u0006\u0004\b\u001c\u0010\u001dR\"\u0010 \u001a\u0010\u0012\u0006\u0012\u0004\u0018\u00010\u000b\u0012\u0004\u0012\u00020\b0\u001f8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b \u0010!R\u001a\u0010#\u001a\u00020\"8\u0016X\u0096\u0004¢\u0006\f\n\u0004\b#\u0010$\u001a\u0004\b%\u0010&R\u0014\u0010)\u001a\u00020\u00048VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b'\u0010(R#\u0010/\u001a\u00020,*\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010+0*8Â\u0002X\u0082\u0004¢\u0006\u0006\u001a\u0004\b-\u0010.R%\u00102\u001a\u0004\u0018\u00010\u000b*\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010+0*8Â\u0002X\u0082\u0004¢\u0006\u0006\u001a\u0004\b0\u00101¨\u00063"}, d2 = {"Lio/ktor/network/sockets/SocketBase;", "Lio/ktor/network/sockets/ReadWriteSocket;", "Lio/ktor/network/selector/SelectableBase;", "LUa/M;", "Lkotlin/coroutines/d;", "parent", "<init>", "(Lkotlin/coroutines/d;)V", "LY8/t;", "checkChannels", "()V", "", "e1", "e2", "combine", "(Ljava/lang/Throwable;Ljava/lang/Throwable;)Ljava/lang/Throwable;", "dispose", "close", "Lio/ktor/utils/io/ByteChannel;", "channel", "Lio/ktor/utils/io/WriterJob;", "attachForReading", "(Lio/ktor/utils/io/ByteChannel;)Lio/ktor/utils/io/WriterJob;", "Lio/ktor/utils/io/ReaderJob;", "attachForWriting", "(Lio/ktor/utils/io/ByteChannel;)Lio/ktor/utils/io/ReaderJob;", "attachForReadingImpl", "attachForWritingImpl", "actualClose$ktor_network", "()Ljava/lang/Throwable;", "actualClose", "Lkotlin/Function1;", "channelCompletionHandler", "Lp9/l;", "LUa/x;", "socketContext", "LUa/x;", "getSocketContext", "()LUa/x;", "getCoroutineContext", "()Lkotlin/coroutines/d;", "coroutineContext", "LOa/e;", "Lio/ktor/utils/io/ChannelJob;", "", "getCompletedOrNotStarted", "(LOa/e;)Z", "completedOrNotStarted", "getException", "(LOa/e;)Ljava/lang/Throwable;", "exception", "ktor-network"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes4.dex */
public abstract class SocketBase extends SelectableBase implements ReadWriteSocket, M {
    private volatile /* synthetic */ int actualCloseFlag;
    private final InterfaceC5074l<Throwable, t> channelCompletionHandler;
    private volatile /* synthetic */ int closeFlag;
    volatile /* synthetic */ Object readerJob;
    private final InterfaceC1089x socketContext;
    volatile /* synthetic */ Object writerJob;
    private static final /* synthetic */ AtomicIntegerFieldUpdater closeFlag$FU = AtomicIntegerFieldUpdater.newUpdater(SocketBase.class, "closeFlag");
    private static final /* synthetic */ AtomicIntegerFieldUpdater actualCloseFlag$FU = AtomicIntegerFieldUpdater.newUpdater(SocketBase.class, "actualCloseFlag");
    static final /* synthetic */ AtomicReferenceFieldUpdater readerJob$FU = AtomicReferenceFieldUpdater.newUpdater(SocketBase.class, Object.class, "readerJob");
    static final /* synthetic */ AtomicReferenceFieldUpdater writerJob$FU = AtomicReferenceFieldUpdater.newUpdater(SocketBase.class, Object.class, "writerJob");

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"LUa/M;", "LY8/t;", "<anonymous>", "(LUa/M;)V"}, k = 3, mv = {2, 2, 0})
    @InterfaceC4112d(c = "io.ktor.network.sockets.SocketBase$close$1", f = "SocketBase.kt", l = {42}, m = "invokeSuspend")
    /* renamed from: io.ktor.network.sockets.SocketBase$close$1, reason: invalid class name */
    public static final class AnonymousClass1 extends SuspendLambda implements p<M, InterfaceC4014c<? super t>, Object> {
        int label;

        public AnonymousClass1(InterfaceC4014c<? super AnonymousClass1> interfaceC4014c) {
            super(2, interfaceC4014c);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final InterfaceC4014c<t> create(Object obj, InterfaceC4014c<?> interfaceC4014c) {
            return SocketBase.this.new AnonymousClass1(interfaceC4014c);
        }

        @Override // p9.p
        public final Object invoke(M m10, InterfaceC4014c<? super t> interfaceC4014c) {
            return ((AnonymousClass1) create(m10, interfaceC4014c)).invokeSuspend(t.f7040a);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Throwable {
            Object objG = C4063a.g();
            int i10 = this.label;
            if (i10 == 0) {
                C4849c.b(obj);
                ReaderJob readerJob = (ReaderJob) SocketBase.this.readerJob;
                if (readerJob != null) {
                    this.label = 1;
                    if (readerJob.flushAndClose(this) == objG) {
                        return objG;
                    }
                }
            } else {
                if (i10 != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                C4849c.b(obj);
            }
            WriterJob writerJob = (WriterJob) SocketBase.this.writerJob;
            if (writerJob != null) {
                ByteWriteChannelOperationsKt.cancel(writerJob);
            }
            SocketBase.this.checkChannels();
            return t.f7040a;
        }
    }

    public SocketBase(kotlin.coroutines.d parent) {
        kotlin.jvm.internal.p.i(parent, "parent");
        this.closeFlag = 0;
        this.actualCloseFlag = 0;
        this.readerJob = null;
        this.writerJob = null;
        this.channelCompletionHandler = new InterfaceC5074l() { // from class: io.ktor.network.sockets.e
            @Override // p9.InterfaceC5074l
            public final Object invoke(Object obj) {
                return SocketBase.channelCompletionHandler$lambda$0(this.f33316a, (Throwable) obj);
            }
        };
        this.socketContext = C1086v0.a((kotlinx.coroutines.g) parent.get(kotlinx.coroutines.g.INSTANCE));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final t channelCompletionHandler$lambda$0(SocketBase socketBase, Throwable th) {
        socketBase.checkChannels();
        return t.f7040a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:29:0x0047  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void checkChannels() {
        /*
            r4 = this;
            int r0 = r4.closeFlag
            if (r0 == 0) goto L7b
            java.lang.Object r0 = r4.readerJob
            io.ktor.utils.io.ChannelJob r0 = (io.ktor.utils.io.ChannelJob) r0
            if (r0 == 0) goto L12
            boolean r0 = io.ktor.utils.io.ByteWriteChannelOperationsKt.isCompleted(r0)
            if (r0 == 0) goto L11
            goto L12
        L11:
            return
        L12:
            java.lang.Object r0 = r4.writerJob
            io.ktor.utils.io.ChannelJob r0 = (io.ktor.utils.io.ChannelJob) r0
            if (r0 == 0) goto L20
            boolean r0 = io.ktor.utils.io.ByteWriteChannelOperationsKt.isCompleted(r0)
            if (r0 == 0) goto L1f
            goto L20
        L1f:
            return
        L20:
            java.util.concurrent.atomic.AtomicIntegerFieldUpdater r0 = io.ktor.network.sockets.SocketBase.actualCloseFlag$FU
            r1 = 0
            r2 = 1
            boolean r0 = r0.compareAndSet(r4, r1, r2)
            if (r0 != 0) goto L2b
            goto L7b
        L2b:
            java.lang.Object r0 = r4.readerJob
            io.ktor.utils.io.ChannelJob r0 = (io.ktor.utils.io.ChannelJob) r0
            r1 = 0
            if (r0 == 0) goto L47
            boolean r2 = io.ktor.utils.io.ByteWriteChannelOperationsKt.isCancelled(r0)
            if (r2 == 0) goto L39
            goto L3a
        L39:
            r0 = r1
        L3a:
            if (r0 == 0) goto L47
            java.util.concurrent.CancellationException r0 = io.ktor.utils.io.ByteWriteChannelOperationsKt.getCancellationException(r0)
            if (r0 == 0) goto L47
            java.lang.Throwable r0 = r0.getCause()
            goto L48
        L47:
            r0 = r1
        L48:
            java.lang.Object r2 = r4.writerJob
            io.ktor.utils.io.ChannelJob r2 = (io.ktor.utils.io.ChannelJob) r2
            if (r2 == 0) goto L62
            boolean r3 = io.ktor.utils.io.ByteWriteChannelOperationsKt.isCancelled(r2)
            if (r3 == 0) goto L55
            goto L56
        L55:
            r2 = r1
        L56:
            if (r2 == 0) goto L62
            java.util.concurrent.CancellationException r2 = io.ktor.utils.io.ByteWriteChannelOperationsKt.getCancellationException(r2)
            if (r2 == 0) goto L62
            java.lang.Throwable r1 = r2.getCause()
        L62:
            java.lang.Throwable r2 = r4.actualClose$ktor_network()
            java.lang.Throwable r0 = r4.combine(r0, r1)
            java.lang.Throwable r0 = r4.combine(r0, r2)
            Ua.x r4 = r4.getSocketContext()
            if (r0 != 0) goto L78
            r4.complete()
            return
        L78:
            r4.e(r0)
        L7b:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: io.ktor.network.sockets.SocketBase.checkChannels():void");
    }

    private final Throwable combine(Throwable e12, Throwable e22) {
        if (e12 == null) {
            return e22;
        }
        if (e22 == null || e12 == e22) {
            return e12;
        }
        Y8.d.a(e12, e22);
        return e12;
    }

    public abstract Throwable actualClose$ktor_network();

    @Override // io.ktor.network.sockets.AReadable
    public final WriterJob attachForReading(ByteChannel channel) throws IOException {
        kotlin.jvm.internal.p.i(channel, "channel");
        if (this.closeFlag != 0) {
            IOException iOException = new IOException("Socket closed");
            ByteWriteChannelOperationsKt.close(channel, iOException);
            throw iOException;
        }
        WriterJob writerJobAttachForReadingImpl = attachForReadingImpl(channel);
        if (!writerJob$FU.compareAndSet(this, null, writerJobAttachForReadingImpl)) {
            IllegalStateException illegalStateException = new IllegalStateException("reading channel has already been set");
            ByteWriteChannelOperationsKt.cancel(writerJobAttachForReadingImpl);
            throw illegalStateException;
        }
        if (this.closeFlag == 0) {
            ByteChannelUtilsKt.attachJob(channel, writerJobAttachForReadingImpl);
            ByteWriteChannelOperationsKt.invokeOnCompletion(writerJobAttachForReadingImpl, this.channelCompletionHandler);
            return writerJobAttachForReadingImpl;
        }
        IOException iOException2 = new IOException("Socket closed");
        ByteWriteChannelOperationsKt.cancel(writerJobAttachForReadingImpl);
        ByteWriteChannelOperationsKt.close(channel, iOException2);
        throw iOException2;
    }

    public abstract WriterJob attachForReadingImpl(ByteChannel channel);

    @Override // io.ktor.network.sockets.AWritable
    public final ReaderJob attachForWriting(ByteChannel channel) throws IOException {
        kotlin.jvm.internal.p.i(channel, "channel");
        if (this.closeFlag != 0) {
            IOException iOException = new IOException("Socket closed");
            ByteWriteChannelOperationsKt.close(channel, iOException);
            throw iOException;
        }
        ReaderJob readerJobAttachForWritingImpl = attachForWritingImpl(channel);
        if (!readerJob$FU.compareAndSet(this, null, readerJobAttachForWritingImpl)) {
            IllegalStateException illegalStateException = new IllegalStateException("writing channel has already been set");
            ByteWriteChannelOperationsKt.cancel(readerJobAttachForWritingImpl);
            throw illegalStateException;
        }
        if (this.closeFlag == 0) {
            ByteChannelUtilsKt.attachJob(channel, readerJobAttachForWritingImpl);
            ByteWriteChannelOperationsKt.invokeOnCompletion(readerJobAttachForWritingImpl, this.channelCompletionHandler);
            return readerJobAttachForWritingImpl;
        }
        IOException iOException2 = new IOException("Socket closed");
        ByteWriteChannelOperationsKt.cancel(readerJobAttachForWritingImpl);
        ByteWriteChannelOperationsKt.close(channel, iOException2);
        throw iOException2;
    }

    public abstract ReaderJob attachForWritingImpl(ByteChannel channel);

    @Override // io.ktor.network.selector.SelectableBase, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        if (closeFlag$FU.compareAndSet(this, 0, 1)) {
            C1060i.d(this, new CoroutineName("socket-close"), null, new AnonymousClass1(null), 2, null);
        }
    }

    @Override // io.ktor.network.selector.SelectableBase, io.ktor.network.selector.Selectable, Ua.InterfaceC1045a0
    public void dispose() {
        close();
    }

    @Override // Ua.M
    public kotlin.coroutines.d getCoroutineContext() {
        return getSocketContext();
    }

    @Override // io.ktor.network.sockets.ASocket
    public InterfaceC1089x getSocketContext() {
        return this.socketContext;
    }
}
