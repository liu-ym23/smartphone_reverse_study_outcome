package io.ktor.network.tls;

import Ua.CoroutineName;
import Ua.M;
import Y8.t;
import e9.InterfaceC4014c;
import f9.C4063a;
import g9.InterfaceC4112d;
import io.ktor.network.sockets.Socket;
import io.ktor.network.sockets.SocketAddress;
import io.ktor.utils.io.ByteChannel;
import io.ktor.utils.io.ByteReadChannel;
import io.ktor.utils.io.ByteReadChannelOperationsKt;
import io.ktor.utils.io.ByteWriteChannel;
import io.ktor.utils.io.ByteWriteChannelOperationsKt;
import io.ktor.utils.io.ReaderJob;
import io.ktor.utils.io.ReaderScope;
import io.ktor.utils.io.WriterJob;
import io.ktor.utils.io.WriterScope;
import java.io.IOException;
import kotlin.C4849c;
import kotlin.Metadata;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import p9.InterfaceC5074l;
import p9.p;

@Metadata(d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0002\u0018\u00002\u00020\u00012\u00020\u0002B\u001f\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0002\u0012\u0006\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\b\u0010\tJ\u0018\u0010\r\u001a\u00020\f2\u0006\u0010\u000b\u001a\u00020\nH\u0082@¢\u0006\u0004\b\r\u0010\u000eJ\u0018\u0010\u0010\u001a\u00020\f2\u0006\u0010\u000b\u001a\u00020\u000fH\u0082@¢\u0006\u0004\b\u0010\u0010\u0011J\u0017\u0010\u0015\u001a\u00020\u00142\u0006\u0010\u0013\u001a\u00020\u0012H\u0016¢\u0006\u0004\b\u0015\u0010\u0016J\u0017\u0010\u0018\u001a\u00020\u00172\u0006\u0010\u0013\u001a\u00020\u0012H\u0016¢\u0006\u0004\b\u0018\u0010\u0019J\u000f\u0010\u001a\u001a\u00020\fH\u0016¢\u0006\u0004\b\u001a\u0010\u001bJ\u000f\u0010\u001c\u001a\u00020\fH\u0016¢\u0006\u0004\b\u001c\u0010\u001bR\u0014\u0010\u0004\u001a\u00020\u00038\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0004\u0010\u001dR\u0014\u0010\u0005\u001a\u00020\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0005\u0010\u001eR\u001a\u0010\u0007\u001a\u00020\u00068\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u0007\u0010\u001f\u001a\u0004\b \u0010!R\u0014\u0010%\u001a\u00020\"8\u0016X\u0096\u0005¢\u0006\u0006\u001a\u0004\b#\u0010$R\u0014\u0010)\u001a\u00020&8\u0016X\u0096\u0005¢\u0006\u0006\u001a\u0004\b'\u0010(R\u0014\u0010+\u001a\u00020&8\u0016X\u0096\u0005¢\u0006\u0006\u001a\u0004\b*\u0010(¨\u0006,"}, d2 = {"Lio/ktor/network/tls/TLSSocket;", "LUa/M;", "Lio/ktor/network/sockets/Socket;", "Lio/ktor/network/tls/TLSClientHandshake;", "base", "socket", "Lkotlin/coroutines/d;", "coroutineContext", "<init>", "(Lio/ktor/network/tls/TLSClientHandshake;Lio/ktor/network/sockets/Socket;Lkotlin/coroutines/d;)V", "Lio/ktor/utils/io/ByteWriteChannel;", "pipe", "LY8/t;", "appDataInputLoop", "(Lio/ktor/utils/io/ByteWriteChannel;Le9/c;)Ljava/lang/Object;", "Lio/ktor/utils/io/ByteReadChannel;", "appDataOutputLoop", "(Lio/ktor/utils/io/ByteReadChannel;Le9/c;)Ljava/lang/Object;", "Lio/ktor/utils/io/ByteChannel;", "channel", "Lio/ktor/utils/io/WriterJob;", "attachForReading", "(Lio/ktor/utils/io/ByteChannel;)Lio/ktor/utils/io/WriterJob;", "Lio/ktor/utils/io/ReaderJob;", "attachForWriting", "(Lio/ktor/utils/io/ByteChannel;)Lio/ktor/utils/io/ReaderJob;", "dispose", "()V", "close", "Lio/ktor/network/tls/TLSClientHandshake;", "Lio/ktor/network/sockets/Socket;", "Lkotlin/coroutines/d;", "getCoroutineContext", "()Lkotlin/coroutines/d;", "Lkotlinx/coroutines/g;", "getSocketContext", "()Lkotlinx/coroutines/g;", "socketContext", "Lio/ktor/network/sockets/SocketAddress;", "getLocalAddress", "()Lio/ktor/network/sockets/SocketAddress;", "localAddress", "getRemoteAddress", "remoteAddress", "ktor-network-tls"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes4.dex */
final class TLSSocket implements M, Socket {
    private final TLSClientHandshake base;
    private final kotlin.coroutines.d coroutineContext;
    private final Socket socket;

    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    public static final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[TLSRecordType.values().length];
            try {
                iArr[TLSRecordType.ApplicationData.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    @InterfaceC4112d(c = "io.ktor.network.tls.TLSSocket", f = "TLSClientSessionJvm.kt", l = {119, 70, 71, 78, 78, 78}, m = "appDataInputLoop")
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    /* renamed from: io.ktor.network.tls.TLSSocket$appDataInputLoop$1, reason: invalid class name */
    public static final class AnonymousClass1 extends ContinuationImpl {
        int I$0;
        int I$1;
        int I$2;
        int I$3;
        long J$0;
        Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        Object L$4;
        Object L$5;
        Object L$6;
        Object L$7;
        int label;
        /* synthetic */ Object result;

        public AnonymousClass1(InterfaceC4014c<? super AnonymousClass1> interfaceC4014c) {
            super(interfaceC4014c);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return TLSSocket.this.appDataInputLoop(null, this);
        }
    }

    @InterfaceC4112d(c = "io.ktor.network.tls.TLSSocket", f = "TLSClientSessionJvm.kt", l = {88, 92}, m = "appDataOutputLoop")
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    /* renamed from: io.ktor.network.tls.TLSSocket$appDataOutputLoop$1, reason: invalid class name and case insensitive filesystem */
    public static final class C43171 extends ContinuationImpl {
        int I$0;
        int I$1;
        int I$2;
        Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        int label;
        /* synthetic */ Object result;

        public C43171(InterfaceC4014c<? super C43171> interfaceC4014c) {
            super(interfaceC4014c);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return TLSSocket.this.appDataOutputLoop(null, this);
        }
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lio/ktor/utils/io/WriterScope;", "LY8/t;", "<anonymous>", "(Lio/ktor/utils/io/WriterScope;)V"}, k = 3, mv = {2, 2, 0})
    @InterfaceC4112d(c = "io.ktor.network.tls.TLSSocket$attachForReading$1", f = "TLSClientSessionJvm.kt", l = {55}, m = "invokeSuspend")
    /* renamed from: io.ktor.network.tls.TLSSocket$attachForReading$1, reason: invalid class name and case insensitive filesystem */
    public static final class C43181 extends SuspendLambda implements p<WriterScope, InterfaceC4014c<? super t>, Object> {
        private /* synthetic */ Object L$0;
        int label;

        public C43181(InterfaceC4014c<? super C43181> interfaceC4014c) {
            super(2, interfaceC4014c);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final InterfaceC4014c<t> create(Object obj, InterfaceC4014c<?> interfaceC4014c) {
            C43181 c43181 = TLSSocket.this.new C43181(interfaceC4014c);
            c43181.L$0 = obj;
            return c43181;
        }

        @Override // p9.p
        public final Object invoke(WriterScope writerScope, InterfaceC4014c<? super t> interfaceC4014c) {
            return ((C43181) create(writerScope, interfaceC4014c)).invokeSuspend(t.f7040a);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Throwable {
            WriterScope writerScope = (WriterScope) this.L$0;
            Object objG = C4063a.g();
            int i10 = this.label;
            if (i10 == 0) {
                C4849c.b(obj);
                TLSSocket tLSSocket = TLSSocket.this;
                ByteWriteChannel channel = writerScope.getChannel();
                this.L$0 = g9.h.a(writerScope);
                this.label = 1;
                if (tLSSocket.appDataInputLoop(channel, this) == objG) {
                    return objG;
                }
            } else {
                if (i10 != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                C4849c.b(obj);
            }
            return t.f7040a;
        }
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lio/ktor/utils/io/ReaderScope;", "LY8/t;", "<anonymous>", "(Lio/ktor/utils/io/ReaderScope;)V"}, k = 3, mv = {2, 2, 0})
    @InterfaceC4112d(c = "io.ktor.network.tls.TLSSocket$attachForWriting$1", f = "TLSClientSessionJvm.kt", l = {60}, m = "invokeSuspend")
    /* renamed from: io.ktor.network.tls.TLSSocket$attachForWriting$1, reason: invalid class name and case insensitive filesystem */
    public static final class C43191 extends SuspendLambda implements p<ReaderScope, InterfaceC4014c<? super t>, Object> {
        private /* synthetic */ Object L$0;
        int label;

        public C43191(InterfaceC4014c<? super C43191> interfaceC4014c) {
            super(2, interfaceC4014c);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final InterfaceC4014c<t> create(Object obj, InterfaceC4014c<?> interfaceC4014c) {
            C43191 c43191 = TLSSocket.this.new C43191(interfaceC4014c);
            c43191.L$0 = obj;
            return c43191;
        }

        @Override // p9.p
        public final Object invoke(ReaderScope readerScope, InterfaceC4014c<? super t> interfaceC4014c) {
            return ((C43191) create(readerScope, interfaceC4014c)).invokeSuspend(t.f7040a);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Throwable {
            ReaderScope readerScope = (ReaderScope) this.L$0;
            Object objG = C4063a.g();
            int i10 = this.label;
            if (i10 == 0) {
                C4849c.b(obj);
                TLSSocket tLSSocket = TLSSocket.this;
                ByteReadChannel channel = readerScope.getChannel();
                this.L$0 = g9.h.a(readerScope);
                this.label = 1;
                if (tLSSocket.appDataOutputLoop(channel, this) == objG) {
                    return objG;
                }
            } else {
                if (i10 != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                C4849c.b(obj);
            }
            return t.f7040a;
        }
    }

    public TLSSocket(TLSClientHandshake base, Socket socket, kotlin.coroutines.d coroutineContext) {
        kotlin.jvm.internal.p.i(base, "base");
        kotlin.jvm.internal.p.i(socket, "socket");
        kotlin.jvm.internal.p.i(coroutineContext, "coroutineContext");
        this.base = base;
        this.socket = socket;
        this.coroutineContext = coroutineContext;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code restructure failed: missing block: B:61:0x022e, code lost:
    
        if (r1.flushAndClose(r2) == r3) goto L73;
     */
    /* JADX WARN: Code restructure failed: missing block: B:72:0x025b, code lost:
    
        if (r1.flushAndClose(r2) != r3) goto L74;
     */
    /* JADX WARN: Removed duplicated region for block: B:38:0x0127  */
    /* JADX WARN: Removed duplicated region for block: B:39:0x0129 A[Catch: all -> 0x01e5, PHI: r0 r1 r2 r4 r5 r6 r7 r8 r9 r11
      0x0129: PHI (r0v19 int) = (r0v5 int), (r0v25 int) binds: [B:29:0x00e0, B:37:0x0125] A[DONT_GENERATE, DONT_INLINE]
      0x0129: PHI (r1v13 io.ktor.utils.io.ByteWriteChannel) = (r1v6 io.ktor.utils.io.ByteWriteChannel), (r1v14 io.ktor.utils.io.ByteWriteChannel) binds: [B:29:0x00e0, B:37:0x0125] A[DONT_GENERATE, DONT_INLINE]
      0x0129: PHI (r2v12 io.ktor.network.tls.TLSSocket$appDataInputLoop$1) = (r2v2 io.ktor.network.tls.TLSSocket$appDataInputLoop$1), (r2v14 io.ktor.network.tls.TLSSocket$appDataInputLoop$1) binds: [B:29:0x00e0, B:37:0x0125] A[DONT_GENERATE, DONT_INLINE]
      0x0129: PHI (r4v11 int) = (r4v2 int), (r4v15 int) binds: [B:29:0x00e0, B:37:0x0125] A[DONT_GENERATE, DONT_INLINE]
      0x0129: PHI (r5v6 int) = (r5v1 int), (r5v12 int) binds: [B:29:0x00e0, B:37:0x0125] A[DONT_GENERATE, DONT_INLINE]
      0x0129: PHI (r6v5 Wa.i<io.ktor.network.tls.TLSRecord>) = (r6v2 Wa.i<io.ktor.network.tls.TLSRecord>), (r6v6 Wa.i<io.ktor.network.tls.TLSRecord>) binds: [B:29:0x00e0, B:37:0x0125] A[DONT_GENERATE, DONT_INLINE]
      0x0129: PHI (r7v13 Wa.r<io.ktor.network.tls.TLSRecord>) = (r7v2 Wa.r<io.ktor.network.tls.TLSRecord>), (r7v25 Wa.r<io.ktor.network.tls.TLSRecord>) binds: [B:29:0x00e0, B:37:0x0125] A[DONT_GENERATE, DONT_INLINE]
      0x0129: PHI (r8v7 Wa.r<io.ktor.network.tls.TLSRecord>) = (r8v3 Wa.r<io.ktor.network.tls.TLSRecord>), (r8v9 Wa.r<io.ktor.network.tls.TLSRecord>) binds: [B:29:0x00e0, B:37:0x0125] A[DONT_GENERATE, DONT_INLINE]
      0x0129: PHI (r9v6 java.lang.Object) = (r9v2 java.lang.Object), (r9v17 java.lang.Object) binds: [B:29:0x00e0, B:37:0x0125] A[DONT_GENERATE, DONT_INLINE]
      0x0129: PHI (r11v9 Wa.r<io.ktor.network.tls.TLSRecord>) = (r11v2 Wa.r<io.ktor.network.tls.TLSRecord>), (r11v10 Wa.r<io.ktor.network.tls.TLSRecord>) binds: [B:29:0x00e0, B:37:0x0125] A[DONT_GENERATE, DONT_INLINE], TryCatch #3 {all -> 0x01e5, blocks: (B:36:0x00ff, B:39:0x0129, B:41:0x0131, B:43:0x0151, B:55:0x01e9, B:56:0x0212, B:57:0x0213), top: B:83:0x00ff }] */
    /* JADX WARN: Removed duplicated region for block: B:41:0x0131 A[Catch: all -> 0x01e5, TryCatch #3 {all -> 0x01e5, blocks: (B:36:0x00ff, B:39:0x0129, B:41:0x0131, B:43:0x0151, B:55:0x01e9, B:56:0x0212, B:57:0x0213), top: B:83:0x00ff }] */
    /* JADX WARN: Removed duplicated region for block: B:50:0x01dc  */
    /* JADX WARN: Removed duplicated region for block: B:57:0x0213 A[Catch: all -> 0x01e5, TRY_LEAVE, TryCatch #3 {all -> 0x01e5, blocks: (B:36:0x00ff, B:39:0x0129, B:41:0x0131, B:43:0x0151, B:55:0x01e9, B:56:0x0212, B:57:0x0213), top: B:83:0x00ff }] */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0017  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:50:0x01dc -> B:18:0x006b). Please report as a decompilation issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object appDataInputLoop(io.ktor.utils.io.ByteWriteChannel r21, e9.InterfaceC4014c<? super Y8.t> r22) throws java.lang.Throwable {
        /*
            Method dump skipped, instructions count: 628
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: io.ktor.network.tls.TLSSocket.appDataInputLoop(io.ktor.utils.io.ByteWriteChannel, e9.c):java.lang.Object");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code restructure failed: missing block: B:32:0x00e3, code lost:
    
        if (r13.send(r14, r2) == r3) goto L33;
     */
    /* JADX WARN: Removed duplicated region for block: B:27:0x0097  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x0098  */
    /* JADX WARN: Removed duplicated region for block: B:31:0x00ad A[Catch: all -> 0x0049, ClosedSendChannelException -> 0x0100, TRY_LEAVE, TryCatch #4 {ClosedSendChannelException -> 0x0100, all -> 0x0049, blocks: (B:13:0x003f, B:25:0x0080, B:29:0x00a4, B:31:0x00ad, B:20:0x0066), top: B:48:0x0027, outer: #1 }] */
    /* JADX WARN: Removed duplicated region for block: B:34:0x00e6 A[Catch: all -> 0x00f2, TRY_ENTER, TryCatch #1 {all -> 0x00f2, blocks: (B:34:0x00e6, B:35:0x00ec, B:38:0x00f6, B:39:0x00ff, B:40:0x0100, B:13:0x003f, B:25:0x0080, B:29:0x00a4, B:31:0x00ad, B:20:0x0066), top: B:48:0x0027, inners: #4 }] */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0017  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:32:0x00e3 -> B:14:0x0042). Please report as a decompilation issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object appDataOutputLoop(io.ktor.utils.io.ByteReadChannel r22, e9.InterfaceC4014c<? super Y8.t> r23) throws java.lang.Throwable {
        /*
            Method dump skipped, instructions count: 276
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: io.ktor.network.tls.TLSSocket.appDataOutputLoop(io.ktor.utils.io.ByteReadChannel, e9.c):java.lang.Object");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final t close$lambda$3(TLSSocket tLSSocket, Throwable th) throws IOException {
        tLSSocket.socket.close();
        return t.f7040a;
    }

    @Override // io.ktor.network.sockets.AReadable
    public WriterJob attachForReading(ByteChannel channel) {
        kotlin.jvm.internal.p.i(channel, "channel");
        return ByteWriteChannelOperationsKt.writer(this, getCoroutineContext().plus(new CoroutineName("cio-tls-input-loop")), channel, new C43181(null));
    }

    @Override // io.ktor.network.sockets.AWritable
    public ReaderJob attachForWriting(ByteChannel channel) {
        kotlin.jvm.internal.p.i(channel, "channel");
        return ByteReadChannelOperationsKt.reader(this, getCoroutineContext().plus(new CoroutineName("cio-tls-output-loop")), channel, new C43191(null));
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        this.base.close().J(new InterfaceC5074l() { // from class: io.ktor.network.tls.n
            @Override // p9.InterfaceC5074l
            public final Object invoke(Object obj) {
                return TLSSocket.close$lambda$3(this.f33336a, (Throwable) obj);
            }
        });
    }

    @Override // io.ktor.network.sockets.ASocket, Ua.InterfaceC1045a0
    public void dispose() {
        close();
    }

    @Override // Ua.M
    public kotlin.coroutines.d getCoroutineContext() {
        return this.coroutineContext;
    }

    @Override // io.ktor.network.sockets.ABoundSocket
    public SocketAddress getLocalAddress() {
        return this.socket.getLocalAddress();
    }

    @Override // io.ktor.network.sockets.AConnectedSocket
    public SocketAddress getRemoteAddress() {
        return this.socket.getRemoteAddress();
    }

    @Override // io.ktor.network.sockets.ASocket
    public kotlinx.coroutines.g getSocketContext() {
        return this.socket.getSocketContext();
    }
}
