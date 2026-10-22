package io.ktor.server.websocket;

import Wa.r;
import Wa.s;
import Y8.t;
import e9.InterfaceC4014c;
import io.ktor.server.application.ApplicationCall;
import io.ktor.websocket.Frame;
import io.ktor.websocket.WebSocketExtension;
import io.ktor.websocket.WebSocketSession;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.p;

@Metadata(d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0002\u0018\u00002\u00020\u00012\u00020\u0002B\u0017\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0002¢\u0006\u0004\b\u0006\u0010\u0007J\u0018\u0010\u000b\u001a\u00020\n2\u0006\u0010\t\u001a\u00020\bH\u0096A¢\u0006\u0004\b\u000b\u0010\fJ\u0010\u0010\r\u001a\u00020\nH\u0096A¢\u0006\u0004\b\r\u0010\u000eJ\u0010\u0010\u000f\u001a\u00020\nH\u0097\u0001¢\u0006\u0004\b\u000f\u0010\u0010R\u001a\u0010\u0004\u001a\u00020\u00038\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u0004\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013R\u0017\u0010\u0005\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0005\u0010\u0014\u001a\u0004\b\u0015\u0010\u0016R\u001c\u0010\u001c\u001a\u00020\u00178\u0016@\u0016X\u0096\u000f¢\u0006\f\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001bR\u001c\u0010\"\u001a\u00020\u001d8\u0016@\u0016X\u0096\u000f¢\u0006\f\u001a\u0004\b\u001e\u0010\u001f\"\u0004\b \u0010!R\u001a\u0010&\u001a\b\u0012\u0004\u0012\u00020\b0#8\u0016X\u0096\u0005¢\u0006\u0006\u001a\u0004\b$\u0010%R\u001a\u0010*\u001a\b\u0012\u0004\u0012\u00020\b0'8\u0016X\u0096\u0005¢\u0006\u0006\u001a\u0004\b(\u0010)R\u001e\u0010/\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030,0+8\u0016X\u0096\u0005¢\u0006\u0006\u001a\u0004\b-\u0010.R\u0014\u00103\u001a\u0002008\u0016X\u0096\u0005¢\u0006\u0006\u001a\u0004\b1\u00102¨\u00064"}, d2 = {"Lio/ktor/server/websocket/DelegatedWebSocketServerSession;", "Lio/ktor/server/websocket/WebSocketServerSession;", "Lio/ktor/websocket/WebSocketSession;", "Lio/ktor/server/application/ApplicationCall;", "call", "delegate", "<init>", "(Lio/ktor/server/application/ApplicationCall;Lio/ktor/websocket/WebSocketSession;)V", "Lio/ktor/websocket/Frame;", "frame", "LY8/t;", "send", "(Lio/ktor/websocket/Frame;Le9/c;)Ljava/lang/Object;", "flush", "(Le9/c;)Ljava/lang/Object;", "terminate", "()V", "Lio/ktor/server/application/ApplicationCall;", "getCall", "()Lio/ktor/server/application/ApplicationCall;", "Lio/ktor/websocket/WebSocketSession;", "getDelegate", "()Lio/ktor/websocket/WebSocketSession;", "", "getMasking", "()Z", "setMasking", "(Z)V", "masking", "", "getMaxFrameSize", "()J", "setMaxFrameSize", "(J)V", "maxFrameSize", "LWa/r;", "getIncoming", "()LWa/r;", "incoming", "LWa/s;", "getOutgoing", "()LWa/s;", "outgoing", "", "Lio/ktor/websocket/WebSocketExtension;", "getExtensions", "()Ljava/util/List;", "extensions", "Lkotlin/coroutines/d;", "getCoroutineContext", "()Lkotlin/coroutines/d;", "coroutineContext", "ktor-server-websockets"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes4.dex */
final class DelegatedWebSocketServerSession implements WebSocketServerSession, WebSocketSession {
    private final ApplicationCall call;
    private final WebSocketSession delegate;

    public DelegatedWebSocketServerSession(ApplicationCall call, WebSocketSession delegate) {
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

    @Override // io.ktor.server.websocket.WebSocketServerSession, io.ktor.websocket.WebSocketSession, Ua.M
    public kotlin.coroutines.d getCoroutineContext() {
        return this.delegate.getCoroutineContext();
    }

    public final WebSocketSession getDelegate() {
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

    @Override // io.ktor.websocket.WebSocketSession
    public void terminate() {
        this.delegate.terminate();
    }
}
