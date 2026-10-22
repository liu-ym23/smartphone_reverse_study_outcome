package io.ktor.client.plugins.websocket;

import Ua.Q;
import Wa.s;
import Y8.t;
import e9.InterfaceC4014c;
import io.ktor.client.call.HttpClientCall;
import io.ktor.utils.io.InternalAPI;
import io.ktor.websocket.CloseReason;
import io.ktor.websocket.DefaultWebSocketSession;
import io.ktor.websocket.Frame;
import io.ktor.websocket.WebSocketExtension;
import java.util.List;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u00012\u00020\u0002B\u0017\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0002¢\u0006\u0004\b\u0006\u0010\u0007J\u0018\u0010\u000b\u001a\u00020\n2\u0006\u0010\t\u001a\u00020\bH\u0096A¢\u0006\u0004\b\u000b\u0010\fJ\u0010\u0010\r\u001a\u00020\nH\u0096A¢\u0006\u0004\b\r\u0010\u000eJ\u0010\u0010\u000f\u001a\u00020\nH\u0097\u0001¢\u0006\u0004\b\u000f\u0010\u0010J\"\u0010\u0014\u001a\u00020\n2\u0010\u0010\u0013\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00120\u0011H\u0097\u0001¢\u0006\u0004\b\u0014\u0010\u0015R\u001a\u0010\u0004\u001a\u00020\u00038\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u0004\u0010\u0016\u001a\u0004\b\u0017\u0010\u0018R\u001c\u0010\u001e\u001a\u00020\u00198\u0016@\u0016X\u0096\u000f¢\u0006\f\u001a\u0004\b\u001a\u0010\u001b\"\u0004\b\u001c\u0010\u001dR\u001c\u0010$\u001a\u00020\u001f8\u0016@\u0016X\u0096\u000f¢\u0006\f\u001a\u0004\b \u0010!\"\u0004\b\"\u0010#R\u001a\u0010(\u001a\b\u0012\u0004\u0012\u00020\b0%8\u0016X\u0096\u0005¢\u0006\u0006\u001a\u0004\b&\u0010'R\u001a\u0010,\u001a\b\u0012\u0004\u0012\u00020\b0)8\u0016X\u0096\u0005¢\u0006\u0006\u001a\u0004\b*\u0010+R\u001e\u0010/\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00120\u00118\u0016X\u0096\u0005¢\u0006\u0006\u001a\u0004\b-\u0010.R\u0014\u00103\u001a\u0002008\u0016X\u0096\u0005¢\u0006\u0006\u001a\u0004\b1\u00102R\u001c\u00106\u001a\u00020\u001f8\u0016@\u0016X\u0096\u000f¢\u0006\f\u001a\u0004\b4\u0010!\"\u0004\b5\u0010#R\u001c\u00109\u001a\u00020\u001f8\u0016@\u0016X\u0096\u000f¢\u0006\f\u001a\u0004\b7\u0010!\"\u0004\b8\u0010#R\u001c\u0010>\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010;0:8\u0016X\u0096\u0005¢\u0006\u0006\u001a\u0004\b<\u0010=¨\u0006?"}, d2 = {"Lio/ktor/client/plugins/websocket/DefaultClientWebSocketSession;", "Lio/ktor/client/plugins/websocket/ClientWebSocketSession;", "Lio/ktor/websocket/DefaultWebSocketSession;", "Lio/ktor/client/call/HttpClientCall;", "call", "delegate", "<init>", "(Lio/ktor/client/call/HttpClientCall;Lio/ktor/websocket/DefaultWebSocketSession;)V", "Lio/ktor/websocket/Frame;", "frame", "LY8/t;", "send", "(Lio/ktor/websocket/Frame;Le9/c;)Ljava/lang/Object;", "flush", "(Le9/c;)Ljava/lang/Object;", "terminate", "()V", "", "Lio/ktor/websocket/WebSocketExtension;", "negotiatedExtensions", "start", "(Ljava/util/List;)V", "Lio/ktor/client/call/HttpClientCall;", "getCall", "()Lio/ktor/client/call/HttpClientCall;", "", "getMasking", "()Z", "setMasking", "(Z)V", "masking", "", "getMaxFrameSize", "()J", "setMaxFrameSize", "(J)V", "maxFrameSize", "LWa/r;", "getIncoming", "()LWa/r;", "incoming", "LWa/s;", "getOutgoing", "()LWa/s;", "outgoing", "getExtensions", "()Ljava/util/List;", "extensions", "Lkotlin/coroutines/d;", "getCoroutineContext", "()Lkotlin/coroutines/d;", "coroutineContext", "getPingIntervalMillis", "setPingIntervalMillis", "pingIntervalMillis", "getTimeoutMillis", "setTimeoutMillis", "timeoutMillis", "LUa/Q;", "Lio/ktor/websocket/CloseReason;", "getCloseReason", "()LUa/Q;", "closeReason", "ktor-client-core"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class DefaultClientWebSocketSession implements ClientWebSocketSession, DefaultWebSocketSession {
    private final /* synthetic */ DefaultWebSocketSession $$delegate_0;
    private final HttpClientCall call;

    public DefaultClientWebSocketSession(HttpClientCall call, DefaultWebSocketSession delegate) {
        kotlin.jvm.internal.p.i(call, "call");
        kotlin.jvm.internal.p.i(delegate, "delegate");
        this.$$delegate_0 = delegate;
        this.call = call;
    }

    @Override // io.ktor.websocket.WebSocketSession
    public Object flush(InterfaceC4014c<? super t> interfaceC4014c) {
        return this.$$delegate_0.flush(interfaceC4014c);
    }

    @Override // io.ktor.client.plugins.websocket.ClientWebSocketSession
    public HttpClientCall getCall() {
        return this.call;
    }

    @Override // io.ktor.websocket.DefaultWebSocketSession
    public Q<CloseReason> getCloseReason() {
        return this.$$delegate_0.getCloseReason();
    }

    @Override // io.ktor.client.plugins.websocket.ClientWebSocketSession, io.ktor.websocket.WebSocketSession, Ua.M
    public kotlin.coroutines.d getCoroutineContext() {
        return this.$$delegate_0.getCoroutineContext();
    }

    @Override // io.ktor.websocket.WebSocketSession
    public List<WebSocketExtension<?>> getExtensions() {
        return this.$$delegate_0.getExtensions();
    }

    @Override // io.ktor.websocket.WebSocketSession
    public Wa.r<Frame> getIncoming() {
        return this.$$delegate_0.getIncoming();
    }

    @Override // io.ktor.websocket.WebSocketSession
    public boolean getMasking() {
        return this.$$delegate_0.getMasking();
    }

    @Override // io.ktor.websocket.WebSocketSession
    public long getMaxFrameSize() {
        return this.$$delegate_0.getMaxFrameSize();
    }

    @Override // io.ktor.websocket.WebSocketSession
    public s<Frame> getOutgoing() {
        return this.$$delegate_0.getOutgoing();
    }

    @Override // io.ktor.websocket.DefaultWebSocketSession
    public long getPingIntervalMillis() {
        return this.$$delegate_0.getPingIntervalMillis();
    }

    @Override // io.ktor.websocket.DefaultWebSocketSession
    public long getTimeoutMillis() {
        return this.$$delegate_0.getTimeoutMillis();
    }

    @Override // io.ktor.websocket.WebSocketSession
    public Object send(Frame frame, InterfaceC4014c<? super t> interfaceC4014c) {
        return this.$$delegate_0.send(frame, interfaceC4014c);
    }

    @Override // io.ktor.websocket.WebSocketSession
    public void setMasking(boolean z10) {
        this.$$delegate_0.setMasking(z10);
    }

    @Override // io.ktor.websocket.WebSocketSession
    public void setMaxFrameSize(long j10) {
        this.$$delegate_0.setMaxFrameSize(j10);
    }

    @Override // io.ktor.websocket.DefaultWebSocketSession
    public void setPingIntervalMillis(long j10) {
        this.$$delegate_0.setPingIntervalMillis(j10);
    }

    @Override // io.ktor.websocket.DefaultWebSocketSession
    public void setTimeoutMillis(long j10) {
        this.$$delegate_0.setTimeoutMillis(j10);
    }

    @Override // io.ktor.websocket.DefaultWebSocketSession
    @InternalAPI
    public void start(List<? extends WebSocketExtension<?>> negotiatedExtensions) {
        kotlin.jvm.internal.p.i(negotiatedExtensions, "negotiatedExtensions");
        this.$$delegate_0.start(negotiatedExtensions);
    }

    @Override // io.ktor.websocket.WebSocketSession
    public void terminate() {
        this.$$delegate_0.terminate();
    }
}
