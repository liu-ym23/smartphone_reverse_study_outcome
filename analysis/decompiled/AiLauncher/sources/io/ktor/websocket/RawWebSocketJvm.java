package io.ktor.websocket;

import Ua.C1060i;
import Ua.C1086v0;
import Ua.CoroutineName;
import Ua.InterfaceC1089x;
import Ua.M;
import Wa.r;
import Wa.s;
import Z8.C1173v;
import e9.InterfaceC4014c;
import f9.C4063a;
import g9.InterfaceC4112d;
import io.ktor.util.cio.ByteBufferPoolKt;
import io.ktor.utils.io.ByteReadChannel;
import io.ktor.utils.io.ByteWriteChannel;
import io.ktor.utils.io.pool.ObjectPool;
import java.nio.ByteBuffer;
import java.util.List;
import kotlin.Metadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.internal.MutablePropertyReference1Impl;
import kotlin.jvm.internal.t;
import p9.p;
import s9.C5449a;
import s9.InterfaceC5453e;
import s9.ObservableProperty;
import w9.InterfaceC5752k;

@Metadata(d1 = {"\u0000z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0000\u0018\u00002\u00020\u0001BC\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0006\u0012\b\b\u0002\u0010\t\u001a\u00020\b\u0012\u0006\u0010\u000b\u001a\u00020\n\u0012\u000e\b\u0002\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\r0\f¢\u0006\u0004\b\u000f\u0010\u0010J\u0010\u0010\u0012\u001a\u00020\u0011H\u0096@¢\u0006\u0004\b\u0012\u0010\u0013J\u000f\u0010\u0014\u001a\u00020\u0011H\u0017¢\u0006\u0004\b\u0014\u0010\u0015R\u0014\u0010\u0017\u001a\u00020\u00168\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0017\u0010\u0018R\u001a\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u001a0\u00198\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001b\u0010\u001cR\u001a\u0010\u000b\u001a\u00020\n8\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u000b\u0010\u001d\u001a\u0004\b\u001e\u0010\u001fR+\u0010\u0007\u001a\u00020\u00062\u0006\u0010 \u001a\u00020\u00068V@VX\u0096\u008e\u0002¢\u0006\u0012\n\u0004\b!\u0010\"\u001a\u0004\b#\u0010$\"\u0004\b%\u0010&R+\u0010\t\u001a\u00020\b2\u0006\u0010 \u001a\u00020\b8V@VX\u0096\u008e\u0002¢\u0006\u0012\n\u0004\b'\u0010\"\u001a\u0004\b(\u0010)\"\u0004\b*\u0010+R\u001a\u0010-\u001a\u00020,8\u0000X\u0080\u0004¢\u0006\f\n\u0004\b-\u0010.\u001a\u0004\b/\u00100R\u001a\u00102\u001a\u0002018\u0000X\u0080\u0004¢\u0006\f\n\u0004\b2\u00103\u001a\u0004\b4\u00105R\u001a\u00109\u001a\b\u0012\u0004\u0012\u00020\u001a068VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b7\u00108R\u001a\u0010=\u001a\b\u0012\u0004\u0012\u00020\u001a0:8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b;\u0010<R\u001e\u0010B\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030?0>8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b@\u0010A¨\u0006C"}, d2 = {"Lio/ktor/websocket/RawWebSocketJvm;", "Lio/ktor/websocket/WebSocketSession;", "Lio/ktor/utils/io/ByteReadChannel;", "input", "Lio/ktor/utils/io/ByteWriteChannel;", "output", "", "maxFrameSize", "", "masking", "Lkotlin/coroutines/d;", "coroutineContext", "Lio/ktor/utils/io/pool/ObjectPool;", "Ljava/nio/ByteBuffer;", "pool", "<init>", "(Lio/ktor/utils/io/ByteReadChannel;Lio/ktor/utils/io/ByteWriteChannel;JZLkotlin/coroutines/d;Lio/ktor/utils/io/pool/ObjectPool;)V", "LY8/t;", "flush", "(Le9/c;)Ljava/lang/Object;", "terminate", "()V", "LUa/x;", "socketJob", "LUa/x;", "LWa/g;", "Lio/ktor/websocket/Frame;", "filtered", "LWa/g;", "Lkotlin/coroutines/d;", "getCoroutineContext", "()Lkotlin/coroutines/d;", "<set-?>", "maxFrameSize$delegate", "Ls9/e;", "getMaxFrameSize", "()J", "setMaxFrameSize", "(J)V", "masking$delegate", "getMasking", "()Z", "setMasking", "(Z)V", "Lio/ktor/websocket/WebSocketWriter;", "writer", "Lio/ktor/websocket/WebSocketWriter;", "getWriter$ktor_websockets", "()Lio/ktor/websocket/WebSocketWriter;", "Lio/ktor/websocket/WebSocketReader;", "reader", "Lio/ktor/websocket/WebSocketReader;", "getReader$ktor_websockets", "()Lio/ktor/websocket/WebSocketReader;", "LWa/r;", "getIncoming", "()LWa/r;", "incoming", "LWa/s;", "getOutgoing", "()LWa/s;", "outgoing", "", "Lio/ktor/websocket/WebSocketExtension;", "getExtensions", "()Ljava/util/List;", "extensions", "ktor-websockets"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class RawWebSocketJvm implements WebSocketSession {
    static final /* synthetic */ InterfaceC5752k<Object>[] $$delegatedProperties = {t.f(new MutablePropertyReference1Impl(RawWebSocketJvm.class, "maxFrameSize", "getMaxFrameSize()J", 0)), t.f(new MutablePropertyReference1Impl(RawWebSocketJvm.class, "masking", "getMasking()Z", 0))};
    private final kotlin.coroutines.d coroutineContext;
    private final Wa.g<Frame> filtered;

    /* renamed from: masking$delegate, reason: from kotlin metadata */
    private final InterfaceC5453e masking;

    /* renamed from: maxFrameSize$delegate, reason: from kotlin metadata */
    private final InterfaceC5453e maxFrameSize;
    private final WebSocketReader reader;
    private final InterfaceC1089x socketJob;
    private final WebSocketWriter writer;

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"LUa/M;", "LY8/t;", "<anonymous>", "(LUa/M;)V"}, k = 3, mv = {2, 2, 0})
    @InterfaceC4112d(c = "io.ktor.websocket.RawWebSocketJvm$1", f = "RawWebSocketJvm.kt", l = {70, 71}, m = "invokeSuspend")
    /* renamed from: io.ktor.websocket.RawWebSocketJvm$1, reason: invalid class name */
    public static final class AnonymousClass1 extends SuspendLambda implements p<M, InterfaceC4014c<? super Y8.t>, Object> {
        Object L$0;
        Object L$1;
        int label;

        public AnonymousClass1(InterfaceC4014c<? super AnonymousClass1> interfaceC4014c) {
            super(2, interfaceC4014c);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final InterfaceC4014c<Y8.t> create(Object obj, InterfaceC4014c<?> interfaceC4014c) {
            return RawWebSocketJvm.this.new AnonymousClass1(interfaceC4014c);
        }

        @Override // p9.p
        public final Object invoke(M m10, InterfaceC4014c<? super Y8.t> interfaceC4014c) {
            return ((AnonymousClass1) create(m10, interfaceC4014c)).invokeSuspend(Y8.t.f7040a);
        }

        /* JADX WARN: Code restructure failed: missing block: B:31:0x007a, code lost:
        
            if (r5.send(r9, r8) == r0) goto L32;
         */
        /* JADX WARN: Removed duplicated region for block: B:26:0x0054  */
        /* JADX WARN: Removed duplicated region for block: B:27:0x0055  */
        /* JADX WARN: Removed duplicated region for block: B:30:0x0060 A[Catch: all -> 0x001c, CancellationException -> 0x001e, ProtocolViolationException -> 0x0021, FrameTooBigException -> 0x0024, TRY_LEAVE, TryCatch #1 {FrameTooBigException -> 0x0024, blocks: (B:7:0x0017, B:24:0x0048, B:28:0x0058, B:30:0x0060, B:20:0x0033, B:23:0x003a), top: B:45:0x0009, outer: #0 }] */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:31:0x007a -> B:8:0x001a). Please report as a decompilation issue!!! */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public final java.lang.Object invokeSuspend(java.lang.Object r9) throws java.lang.Throwable {
            /*
                Method dump skipped, instructions count: 244
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: io.ktor.websocket.RawWebSocketJvm.AnonymousClass1.invokeSuspend(java.lang.Object):java.lang.Object");
        }
    }

    public RawWebSocketJvm(ByteReadChannel input, ByteWriteChannel output, long j10, boolean z10, kotlin.coroutines.d coroutineContext, ObjectPool<ByteBuffer> pool) {
        kotlin.jvm.internal.p.i(input, "input");
        kotlin.jvm.internal.p.i(output, "output");
        kotlin.jvm.internal.p.i(coroutineContext, "coroutineContext");
        kotlin.jvm.internal.p.i(pool, "pool");
        InterfaceC1089x interfaceC1089xA = C1086v0.a((kotlinx.coroutines.g) coroutineContext.get(kotlinx.coroutines.g.INSTANCE));
        this.socketJob = interfaceC1089xA;
        this.filtered = Wa.j.b(0, null, null, 6, null);
        this.coroutineContext = coroutineContext.plus(interfaceC1089xA).plus(new CoroutineName("raw-ws"));
        C5449a c5449a = C5449a.f40169a;
        final Long lValueOf = Long.valueOf(j10);
        this.maxFrameSize = new ObservableProperty<Long>(lValueOf) { // from class: io.ktor.websocket.RawWebSocketJvm$special$$inlined$observable$1
            @Override // s9.ObservableProperty
            public void afterChange(InterfaceC5752k<?> property, Long oldValue, Long newValue) {
                kotlin.jvm.internal.p.i(property, "property");
                long jLongValue = newValue.longValue();
                oldValue.longValue();
                this.getReader().setMaxFrameSize(jLongValue);
            }
        };
        final Boolean boolValueOf = Boolean.valueOf(z10);
        this.masking = new ObservableProperty<Boolean>(boolValueOf) { // from class: io.ktor.websocket.RawWebSocketJvm$special$$inlined$observable$2
            @Override // s9.ObservableProperty
            public void afterChange(InterfaceC5752k<?> property, Boolean oldValue, Boolean newValue) {
                kotlin.jvm.internal.p.i(property, "property");
                boolean zBooleanValue = newValue.booleanValue();
                oldValue.getClass();
                this.getWriter().setMasking(zBooleanValue);
            }
        };
        this.writer = new WebSocketWriter(output, getCoroutineContext(), z10, pool);
        this.reader = new WebSocketReader(input, getCoroutineContext(), j10, pool);
        C1060i.d(this, null, null, new AnonymousClass1(null), 3, null);
        interfaceC1089xA.complete();
    }

    @Override // io.ktor.websocket.WebSocketSession
    public Object flush(InterfaceC4014c<? super Y8.t> interfaceC4014c) throws Throwable {
        Object objFlush = this.writer.flush(interfaceC4014c);
        return objFlush == C4063a.g() ? objFlush : Y8.t.f7040a;
    }

    @Override // io.ktor.websocket.WebSocketSession, Ua.M
    public kotlin.coroutines.d getCoroutineContext() {
        return this.coroutineContext;
    }

    @Override // io.ktor.websocket.WebSocketSession
    public List<WebSocketExtension<?>> getExtensions() {
        return C1173v.m();
    }

    @Override // io.ktor.websocket.WebSocketSession
    public r<Frame> getIncoming() {
        return this.filtered;
    }

    @Override // io.ktor.websocket.WebSocketSession
    public boolean getMasking() {
        return ((Boolean) this.masking.getValue(this, $$delegatedProperties[1])).booleanValue();
    }

    @Override // io.ktor.websocket.WebSocketSession
    public long getMaxFrameSize() {
        return ((Number) this.maxFrameSize.getValue(this, $$delegatedProperties[0])).longValue();
    }

    @Override // io.ktor.websocket.WebSocketSession
    public s<Frame> getOutgoing() {
        return this.writer.getOutgoing();
    }

    /* renamed from: getReader$ktor_websockets, reason: from getter */
    public final WebSocketReader getReader() {
        return this.reader;
    }

    /* renamed from: getWriter$ktor_websockets, reason: from getter */
    public final WebSocketWriter getWriter() {
        return this.writer;
    }

    @Override // io.ktor.websocket.WebSocketSession
    public Object send(Frame frame, InterfaceC4014c<? super Y8.t> interfaceC4014c) {
        return super.send(frame, interfaceC4014c);
    }

    @Override // io.ktor.websocket.WebSocketSession
    public void setMasking(boolean z10) {
        this.masking.setValue(this, $$delegatedProperties[1], Boolean.valueOf(z10));
    }

    @Override // io.ktor.websocket.WebSocketSession
    public void setMaxFrameSize(long j10) {
        this.maxFrameSize.setValue(this, $$delegatedProperties[0], Long.valueOf(j10));
    }

    @Override // io.ktor.websocket.WebSocketSession
    public void terminate() {
        s.a(getOutgoing(), null, 1, null);
        this.socketJob.complete();
    }

    public /* synthetic */ RawWebSocketJvm(ByteReadChannel byteReadChannel, ByteWriteChannel byteWriteChannel, long j10, boolean z10, kotlin.coroutines.d dVar, ObjectPool objectPool, int i10, kotlin.jvm.internal.i iVar) {
        this(byteReadChannel, byteWriteChannel, (i10 & 4) != 0 ? 2147483647L : j10, (i10 & 8) != 0 ? false : z10, dVar, (i10 & 32) != 0 ? ByteBufferPoolKt.getKtorDefaultPool() : objectPool);
    }
}
