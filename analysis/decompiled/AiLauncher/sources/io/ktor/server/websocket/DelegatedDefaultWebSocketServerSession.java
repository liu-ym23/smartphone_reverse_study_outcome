package io.ktor.server.websocket;

import Ua.Q;
import Wa.r;
import Wa.s;
import Y8.t;
import e9.InterfaceC4014c;
import io.ktor.server.application.ApplicationCall;
import io.ktor.utils.io.InternalAPI;
import io.ktor.websocket.CloseReason;
import io.ktor.websocket.DefaultWebSocketSession;
import io.ktor.websocket.Frame;
import io.ktor.websocket.WebSocketExtension;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.p;

@Metadata(d1 = {"\u0000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0010\t\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0002\u0018\u00002\u00020\u00012\u00020\u0002B\u0017\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0002¢\u0006\u0004\b\u0006\u0010\u0007J\"\u0010\f\u001a\u00020\u000b2\u0010\u0010\n\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\t0\bH\u0097\u0001¢\u0006\u0004\b\f\u0010\rJ\u0018\u0010\u0010\u001a\u00020\u000b2\u0006\u0010\u000f\u001a\u00020\u000eH\u0096A¢\u0006\u0004\b\u0010\u0010\u0011J\u0010\u0010\u0012\u001a\u00020\u000bH\u0096A¢\u0006\u0004\b\u0012\u0010\u0013J\u0010\u0010\u0014\u001a\u00020\u000bH\u0097\u0001¢\u0006\u0004\b\u0014\u0010\u0015R\u001a\u0010\u0004\u001a\u00020\u00038\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u0004\u0010\u0016\u001a\u0004\b\u0017\u0010\u0018R\u0017\u0010\u0005\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0005\u0010\u0019\u001a\u0004\b\u001a\u0010\u001bR\u001c\u0010!\u001a\u00020\u001c8\u0016@\u0016X\u0096\u000f¢\u0006\f\u001a\u0004\b\u001d\u0010\u001e\"\u0004\b\u001f\u0010 R\u001c\u0010$\u001a\u00020\u001c8\u0016@\u0016X\u0096\u000f¢\u0006\f\u001a\u0004\b\"\u0010\u001e\"\u0004\b#\u0010 R\u001c\u0010)\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010&0%8\u0016X\u0096\u0005¢\u0006\u0006\u001a\u0004\b'\u0010(R\u001c\u0010/\u001a\u00020*8\u0016@\u0016X\u0096\u000f¢\u0006\f\u001a\u0004\b+\u0010,\"\u0004\b-\u0010.R\u001c\u00102\u001a\u00020\u001c8\u0016@\u0016X\u0096\u000f¢\u0006\f\u001a\u0004\b0\u0010\u001e\"\u0004\b1\u0010 R\u001a\u00106\u001a\b\u0012\u0004\u0012\u00020\u000e038\u0016X\u0096\u0005¢\u0006\u0006\u001a\u0004\b4\u00105R\u001a\u0010:\u001a\b\u0012\u0004\u0012\u00020\u000e078\u0016X\u0096\u0005¢\u0006\u0006\u001a\u0004\b8\u00109R\u001e\u0010=\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\t0\b8\u0016X\u0096\u0005¢\u0006\u0006\u001a\u0004\b;\u0010<R\u0014\u0010A\u001a\u00020>8\u0016X\u0096\u0005¢\u0006\u0006\u001a\u0004\b?\u0010@¨\u0006B"}, d2 = {"Lio/ktor/server/websocket/DelegatedDefaultWebSocketServerSession;", "Lio/ktor/server/websocket/DefaultWebSocketServerSession;", "Lio/ktor/websocket/DefaultWebSocketSession;", "Lio/ktor/server/application/ApplicationCall;", "call", "delegate", "<init>", "(Lio/ktor/server/application/ApplicationCall;Lio/ktor/websocket/DefaultWebSocketSession;)V", "", "Lio/ktor/websocket/WebSocketExtension;", "negotiatedExtensions", "LY8/t;", "start", "(Ljava/util/List;)V", "Lio/ktor/websocket/Frame;", "frame", "send", "(Lio/ktor/websocket/Frame;Le9/c;)Ljava/lang/Object;", "flush", "(Le9/c;)Ljava/lang/Object;", "terminate", "()V", "Lio/ktor/server/application/ApplicationCall;", "getCall", "()Lio/ktor/server/application/ApplicationCall;", "Lio/ktor/websocket/DefaultWebSocketSession;", "getDelegate", "()Lio/ktor/websocket/DefaultWebSocketSession;", "", "getPingIntervalMillis", "()J", "setPingIntervalMillis", "(J)V", "pingIntervalMillis", "getTimeoutMillis", "setTimeoutMillis", "timeoutMillis", "LUa/Q;", "Lio/ktor/websocket/CloseReason;", "getCloseReason", "()LUa/Q;", "closeReason", "", "getMasking", "()Z", "setMasking", "(Z)V", "masking", "getMaxFrameSize", "setMaxFrameSize", "maxFrameSize", "LWa/r;", "getIncoming", "()LWa/r;", "incoming", "LWa/s;", "getOutgoing", "()LWa/s;", "outgoing", "getExtensions", "()Ljava/util/List;", "extensions", "Lkotlin/coroutines/d;", "getCoroutineContext", "()Lkotlin/coroutines/d;", "coroutineContext", "ktor-server-websockets"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes4.dex */
final class DelegatedDefaultWebSocketServerSession implements DefaultWebSocketServerSession, DefaultWebSocketSession {
    private final ApplicationCall call;
    private final DefaultWebSocketSession delegate;

    public DelegatedDefaultWebSocketServerSession(ApplicationCall call, DefaultWebSocketSession delegate) {
        p.i(call, "call");
        p.i(delegate, "delegate");
        this.call = call;
        this.delegate = delegate;
    }

    @Override // io.ktor.websocket.WebSocketSession
    public Object flush(InterfaceC4014c<? super t> interfaceC4014c) {
        return this.delegate.flush(interfaceC4014c);
    }

    @Override // io.ktor.server.websocket.WebSocketServerSession
    public ApplicationCall getCall() {
        return this.call;
    }

    @Override // io.ktor.websocket.DefaultWebSocketSession
    public Q<CloseReason> getCloseReason() {
        return this.delegate.getCloseReason();
    }

    @Override // io.ktor.server.websocket.DefaultWebSocketServerSession, io.ktor.websocket.DefaultWebSocketSession, io.ktor.websocket.WebSocketSession, Ua.M
    public kotlin.coroutines.d getCoroutineContext() {
        return this.delegate.getCoroutineContext();
    }

    public final DefaultWebSocketSession getDelegate() {
        return this.delegate;
    }

    @Override // io.ktor.websocket.WebSocketSession
    public List<WebSocketExtension<?>> getExtensions() {
        return this.delegate.getExtensions();
    }

    @Override // io.ktor.websocket.WebSocketSession
    public r<Frame> getIncoming() {
        return this.delegate.getIncoming();
    }

    @Override // io.ktor.websocket.WebSocketSession
    public boolean getMasking() {
        return this.delegate.getMasking();
    }

    @Override // io.ktor.websocket.WebSocketSession
    public long getMaxFrameSize() {
        return this.delegate.getMaxFrameSize();
    }

    @Override // io.ktor.websocket.WebSocketSession
    public s<Frame> getOutgoing() {
        return this.delegate.getOutgoing();
    }

    @Override // io.ktor.websocket.DefaultWebSocketSession
    public long getPingIntervalMillis() {
        return this.delegate.getPingIntervalMillis();
    }

    @Override // io.ktor.websocket.DefaultWebSocketSession
    public long getTimeoutMillis() {
        return this.delegate.getTimeoutMillis();
    }

    @Override // io.ktor.websocket.WebSocketSession
    public Object send(Frame frame, InterfaceC4014c<? super t> interfaceC4014c) {
        return this.delegate.send(frame, interfaceC4014c);
    }

    @Override // io.ktor.websocket.WebSocketSession
    public void setMasking(boolean z10) {
        this.delegate.setMasking(z10);
    }

    @Override // io.ktor.websocket.WebSocketSession
    public void setMaxFrameSize(long j10) {
        this.delegate.setMaxFrameSize(j10);
    }

    @Override // io.ktor.websocket.DefaultWebSocketSession
    public void setPingIntervalMillis(long j10) {
        this.delegate.setPingIntervalMillis(j10);
    }

    @Override // io.ktor.websocket.DefaultWebSocketSession
    public void setTimeoutMillis(long j10) {
        this.delegate.setTimeoutMillis(j10);
    }

    @Override // io.ktor.websocket.DefaultWebSocketSession
    @InternalAPI
    public void start(List<? extends WebSocketExtension<?>> negotiatedExtensions) {
        p.i(negotiatedExtensions, "negotiatedExtensions");
        this.delegate.start(negotiatedExtensions);
    }

    @Override // io.ktor.websocket.WebSocketSession
    public void terminate() {
        this.delegate.terminate();
    }
}
