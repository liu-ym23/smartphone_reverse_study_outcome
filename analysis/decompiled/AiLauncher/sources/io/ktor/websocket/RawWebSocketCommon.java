package io.ktor.websocket;

import Ua.C1056g;
import Ua.C1086v0;
import Ua.CoroutineName;
import Ua.InterfaceC1089x;
import Wa.r;
import Wa.s;
import Y8.t;
import Z8.C1173v;
import e9.InterfaceC4014c;
import f9.C4063a;
import g9.InterfaceC4112d;
import io.ktor.utils.io.ByteReadChannel;
import io.ktor.utils.io.ByteWriteChannel;
import java.util.List;
import kotlin.Metadata;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.jvm.internal.p;
import kotlinx.coroutines.CoroutineStart;

@Metadata(d1 = {"\u0000v\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0000\u0018\u00002\u00020\u0001:\u0001?B3\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0006\u0012\b\b\u0002\u0010\t\u001a\u00020\b\u0012\u0006\u0010\u000b\u001a\u00020\n¢\u0006\u0004\b\f\u0010\rJ\u0010\u0010\u000f\u001a\u00020\u000eH\u0096@¢\u0006\u0004\b\u000f\u0010\u0010J\u000f\u0010\u0011\u001a\u00020\u000eH\u0017¢\u0006\u0004\b\u0011\u0010\u0012R\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0003\u0010\u0013R\u0014\u0010\u0005\u001a\u00020\u00048\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0005\u0010\u0014R\"\u0010\u0007\u001a\u00020\u00068\u0016@\u0016X\u0096\u000e¢\u0006\u0012\n\u0004\b\u0007\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019R\"\u0010\t\u001a\u00020\b8\u0016@\u0016X\u0096\u000e¢\u0006\u0012\n\u0004\b\t\u0010\u001a\u001a\u0004\b\u001b\u0010\u001c\"\u0004\b\u001d\u0010\u001eR\u0014\u0010 \u001a\u00020\u001f8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b \u0010!R\u001a\u0010$\u001a\b\u0012\u0004\u0012\u00020#0\"8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b$\u0010%R\u001a\u0010'\u001a\b\u0012\u0004\u0012\u00020&0\"8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b'\u0010%R\u0016\u0010)\u001a\u00020(8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b)\u0010*R\u001a\u0010\u000b\u001a\u00020\n8\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u000b\u0010+\u001a\u0004\b,\u0010-R\u0014\u0010/\u001a\u00020.8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b/\u00100R\u0014\u00101\u001a\u00020.8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b1\u00100R\u001a\u00105\u001a\b\u0012\u0004\u0012\u00020#028VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b3\u00104R\u001a\u00109\u001a\b\u0012\u0004\u0012\u00020#068VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b7\u00108R\u001e\u0010>\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030;0:8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b<\u0010=¨\u0006@"}, d2 = {"Lio/ktor/websocket/RawWebSocketCommon;", "Lio/ktor/websocket/WebSocketSession;", "Lio/ktor/utils/io/ByteReadChannel;", "input", "Lio/ktor/utils/io/ByteWriteChannel;", "output", "", "maxFrameSize", "", "masking", "Lkotlin/coroutines/d;", "coroutineContext", "<init>", "(Lio/ktor/utils/io/ByteReadChannel;Lio/ktor/utils/io/ByteWriteChannel;JZLkotlin/coroutines/d;)V", "LY8/t;", "flush", "(Le9/c;)Ljava/lang/Object;", "terminate", "()V", "Lio/ktor/utils/io/ByteReadChannel;", "Lio/ktor/utils/io/ByteWriteChannel;", "J", "getMaxFrameSize", "()J", "setMaxFrameSize", "(J)V", "Z", "getMasking", "()Z", "setMasking", "(Z)V", "LUa/x;", "socketJob", "LUa/x;", "LWa/g;", "Lio/ktor/websocket/Frame;", "_incoming", "LWa/g;", "", "_outgoing", "", "lastOpcode", "I", "Lkotlin/coroutines/d;", "getCoroutineContext", "()Lkotlin/coroutines/d;", "Lkotlinx/coroutines/g;", "writerJob", "Lkotlinx/coroutines/g;", "readerJob", "LWa/r;", "getIncoming", "()LWa/r;", "incoming", "LWa/s;", "getOutgoing", "()LWa/s;", "outgoing", "", "Lio/ktor/websocket/WebSocketExtension;", "getExtensions", "()Ljava/util/List;", "extensions", "FlushRequest", "ktor-websockets"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class RawWebSocketCommon implements WebSocketSession {
    private final Wa.g<Frame> _incoming;
    private final Wa.g<Object> _outgoing;
    private final kotlin.coroutines.d coroutineContext;
    private final ByteReadChannel input;
    private int lastOpcode;
    private boolean masking;
    private long maxFrameSize;
    private final ByteWriteChannel output;
    private final kotlinx.coroutines.g readerJob;
    private final InterfaceC1089x socketJob;
    private final kotlinx.coroutines.g writerJob;

    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0002\u0018\u00002\u00020\u0001B\u0011\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\r\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\u0007\u0010\bJ\u0010\u0010\n\u001a\u00020\tH\u0086@¢\u0006\u0004\b\n\u0010\u000bR\u0014\u0010\r\u001a\u00020\f8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\r\u0010\u000e¨\u0006\u000f"}, d2 = {"Lio/ktor/websocket/RawWebSocketCommon$FlushRequest;", "", "Lkotlinx/coroutines/g;", "parent", "<init>", "(Lkotlinx/coroutines/g;)V", "", "complete", "()Z", "LY8/t;", "await", "(Le9/c;)Ljava/lang/Object;", "LUa/x;", "done", "LUa/x;", "ktor-websockets"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class FlushRequest {
        private final InterfaceC1089x done;

        public FlushRequest(kotlinx.coroutines.g gVar) {
            this.done = C1086v0.a(gVar);
        }

        public final Object await(InterfaceC4014c<? super t> interfaceC4014c) {
            Object objT0 = this.done.T0(interfaceC4014c);
            return objT0 == C4063a.g() ? objT0 : t.f7040a;
        }

        public final boolean complete() {
            return this.done.complete();
        }
    }

    @InterfaceC4112d(c = "io.ktor.websocket.RawWebSocketCommon", f = "RawWebSocketCommon.kt", l = {131, 134, 139}, m = "flush")
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    /* renamed from: io.ktor.websocket.RawWebSocketCommon$flush$1, reason: invalid class name */
    public static final class AnonymousClass1 extends ContinuationImpl {
        int I$0;
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
            return RawWebSocketCommon.this.flush(this);
        }
    }

    public RawWebSocketCommon(ByteReadChannel input, ByteWriteChannel output, long j10, boolean z10, kotlin.coroutines.d coroutineContext) {
        p.i(input, "input");
        p.i(output, "output");
        p.i(coroutineContext, "coroutineContext");
        this.input = input;
        this.output = output;
        this.maxFrameSize = j10;
        this.masking = z10;
        InterfaceC1089x interfaceC1089xA = C1086v0.a((kotlinx.coroutines.g) coroutineContext.get(kotlinx.coroutines.g.INSTANCE));
        this.socketJob = interfaceC1089xA;
        this._incoming = Wa.j.b(8, null, null, 6, null);
        this._outgoing = Wa.j.b(8, null, null, 6, null);
        this.coroutineContext = coroutineContext.plus(interfaceC1089xA).plus(new CoroutineName("raw-ws"));
        CoroutineName coroutineName = new CoroutineName("ws-writer");
        CoroutineStart coroutineStart = CoroutineStart.ATOMIC;
        this.writerJob = C1056g.c(this, coroutineName, coroutineStart, new RawWebSocketCommon$writerJob$1(this, null));
        this.readerJob = C1056g.c(this, new CoroutineName("ws-reader"), coroutineStart, new RawWebSocketCommon$readerJob$1(this, null));
        interfaceC1089xA.complete();
    }

    /* JADX WARN: Code restructure failed: missing block: B:41:0x00be, code lost:
    
        if (r6.await(r0) != r1) goto L43;
     */
    /* JADX WARN: Removed duplicated region for block: B:38:0x00af  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    @Override // io.ktor.websocket.WebSocketSession
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public java.lang.Object flush(e9.InterfaceC4014c<? super Y8.t> r9) throws java.lang.Throwable {
        /*
            Method dump skipped, instructions count: 196
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: io.ktor.websocket.RawWebSocketCommon.flush(e9.c):java.lang.Object");
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
        return this._incoming;
    }

    @Override // io.ktor.websocket.WebSocketSession
    public boolean getMasking() {
        return this.masking;
    }

    @Override // io.ktor.websocket.WebSocketSession
    public long getMaxFrameSize() {
        return this.maxFrameSize;
    }

    @Override // io.ktor.websocket.WebSocketSession
    public s<Frame> getOutgoing() {
        return this._outgoing;
    }

    @Override // io.ktor.websocket.WebSocketSession
    public Object send(Frame frame, InterfaceC4014c<? super t> interfaceC4014c) {
        return super.send(frame, interfaceC4014c);
    }

    @Override // io.ktor.websocket.WebSocketSession
    public void setMasking(boolean z10) {
        this.masking = z10;
    }

    @Override // io.ktor.websocket.WebSocketSession
    public void setMaxFrameSize(long j10) {
        this.maxFrameSize = j10;
    }

    @Override // io.ktor.websocket.WebSocketSession
    public void terminate() {
        s.a(getOutgoing(), null, 1, null);
        this.socketJob.complete();
    }

    public /* synthetic */ RawWebSocketCommon(ByteReadChannel byteReadChannel, ByteWriteChannel byteWriteChannel, long j10, boolean z10, kotlin.coroutines.d dVar, int i10, kotlin.jvm.internal.i iVar) {
        this(byteReadChannel, byteWriteChannel, (i10 & 4) != 0 ? 2147483647L : j10, (i10 & 8) != 0 ? false : z10, dVar);
    }
}
