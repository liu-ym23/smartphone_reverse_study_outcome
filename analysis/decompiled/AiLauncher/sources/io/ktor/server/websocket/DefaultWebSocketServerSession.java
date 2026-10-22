package io.ktor.server.websocket;

import Y8.t;
import e9.InterfaceC4014c;
import f9.C4063a;
import io.ktor.websocket.DefaultWebSocketSession;
import io.ktor.websocket.Frame;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u00012\u00020\u0002¨\u0006\u0003"}, d2 = {"Lio/ktor/server/websocket/DefaultWebSocketServerSession;", "Lio/ktor/websocket/DefaultWebSocketSession;", "Lio/ktor/server/websocket/WebSocketServerSession;", "ktor-server-websockets"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes4.dex */
public interface DefaultWebSocketServerSession extends DefaultWebSocketSession, WebSocketServerSession {

    @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
    public static final class DefaultImpls {
        public static Object send(DefaultWebSocketServerSession defaultWebSocketServerSession, Frame frame, InterfaceC4014c<? super t> interfaceC4014c) {
            Object objSend = DefaultWebSocketSession.DefaultImpls.send(defaultWebSocketServerSession, frame, interfaceC4014c);
            return objSend == C4063a.g() ? objSend : t.f7040a;
        }
    }

    @Override // io.ktor.websocket.DefaultWebSocketSession, io.ktor.websocket.WebSocketSession, Ua.M
    /* synthetic */ kotlin.coroutines.d getCoroutineContext();
}
