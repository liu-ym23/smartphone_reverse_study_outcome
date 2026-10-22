package io.ktor.server.websocket;

import Y8.t;
import e9.InterfaceC4014c;
import f9.C4063a;
import io.ktor.server.application.ApplicationCall;
import io.ktor.websocket.Frame;
import io.ktor.websocket.WebSocketSession;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\bf\u0018\u00002\u00020\u0001R\u0014\u0010\u0005\u001a\u00020\u00028&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0003\u0010\u0004¨\u0006\u0006"}, d2 = {"Lio/ktor/server/websocket/WebSocketServerSession;", "Lio/ktor/websocket/WebSocketSession;", "Lio/ktor/server/application/ApplicationCall;", "getCall", "()Lio/ktor/server/application/ApplicationCall;", "call", "ktor-server-websockets"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes4.dex */
public interface WebSocketServerSession extends WebSocketSession {

    @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
    public static final class DefaultImpls {
        public static Object send(WebSocketServerSession webSocketServerSession, Frame frame, InterfaceC4014c<? super t> interfaceC4014c) {
            Object objSend = WebSocketSession.DefaultImpls.send(webSocketServerSession, frame, interfaceC4014c);
            return objSend == C4063a.g() ? objSend : t.f7040a;
        }
    }

    ApplicationCall getCall();

    @Override // io.ktor.websocket.WebSocketSession, Ua.M
    /* synthetic */ kotlin.coroutines.d getCoroutineContext();
}
