package io.ktor.websocket;

import Ua.M;
import Wa.r;
import Wa.s;
import Y8.t;
import e9.InterfaceC4014c;
import f9.C4063a;
import java.util.List;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\bf\u0018\u00002\u00020\u0001J\u0018\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0096@¢\u0006\u0004\b\u0005\u0010\u0006J\u0010\u0010\u0007\u001a\u00020\u0004H¦@¢\u0006\u0004\b\u0007\u0010\bJ\u000f\u0010\t\u001a\u00020\u0004H'¢\u0006\u0004\b\t\u0010\nR\u001c\u0010\u0010\u001a\u00020\u000b8&@&X¦\u000e¢\u0006\f\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u001c\u0010\u0016\u001a\u00020\u00118&@&X¦\u000e¢\u0006\f\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R\u001a\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u00020\u00178&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0018\u0010\u0019R\u001a\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\u00020\u001b8&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u001c\u0010\u001dR\u001e\u0010#\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030 0\u001f8&X¦\u0004¢\u0006\u0006\u001a\u0004\b!\u0010\"¨\u0006$À\u0006\u0003"}, d2 = {"Lio/ktor/websocket/WebSocketSession;", "LUa/M;", "Lio/ktor/websocket/Frame;", "frame", "LY8/t;", "send", "(Lio/ktor/websocket/Frame;Le9/c;)Ljava/lang/Object;", "flush", "(Le9/c;)Ljava/lang/Object;", "terminate", "()V", "", "getMasking", "()Z", "setMasking", "(Z)V", "masking", "", "getMaxFrameSize", "()J", "setMaxFrameSize", "(J)V", "maxFrameSize", "LWa/r;", "getIncoming", "()LWa/r;", "incoming", "LWa/s;", "getOutgoing", "()LWa/s;", "outgoing", "", "Lio/ktor/websocket/WebSocketExtension;", "getExtensions", "()Ljava/util/List;", "extensions", "ktor-websockets"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes4.dex */
public interface WebSocketSession extends M {

    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    public static final class DefaultImpls {
        @Deprecated
        public static Object send(WebSocketSession webSocketSession, Frame frame, InterfaceC4014c<? super t> interfaceC4014c) {
            return WebSocketSession.super.send(frame, interfaceC4014c);
        }
    }

    static /* synthetic */ Object send$suspendImpl(WebSocketSession webSocketSession, Frame frame, InterfaceC4014c<? super t> interfaceC4014c) {
        Object objSend = webSocketSession.getOutgoing().send(frame, interfaceC4014c);
        return objSend == C4063a.g() ? objSend : t.f7040a;
    }

    Object flush(InterfaceC4014c<? super t> interfaceC4014c);

    @Override // Ua.M
    /* synthetic */ kotlin.coroutines.d getCoroutineContext();

    List<WebSocketExtension<?>> getExtensions();

    r<Frame> getIncoming();

    boolean getMasking();

    long getMaxFrameSize();

    s<Frame> getOutgoing();

    default Object send(Frame frame, InterfaceC4014c<? super t> interfaceC4014c) {
        return send$suspendImpl(this, frame, interfaceC4014c);
    }

    void setMasking(boolean z10);

    void setMaxFrameSize(long j10);

    void terminate();
}
