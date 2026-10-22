package io.ktor.client.plugins.websocket;

import Y8.t;
import e9.InterfaceC4014c;
import io.ktor.client.call.HttpClientCall;
import io.ktor.websocket.Frame;
import io.ktor.websocket.WebSocketSession;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\bf\u0018\u00002\u00020\u0001R\u0014\u0010\u0005\u001a\u00020\u00028&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0003\u0010\u0004¨\u0006\u0006À\u0006\u0003"}, d2 = {"Lio/ktor/client/plugins/websocket/ClientWebSocketSession;", "Lio/ktor/websocket/WebSocketSession;", "Lio/ktor/client/call/HttpClientCall;", "getCall", "()Lio/ktor/client/call/HttpClientCall;", "call", "ktor-client-core"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes4.dex */
public interface ClientWebSocketSession extends WebSocketSession {

    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    public static final class DefaultImpls {
        @Deprecated
        public static Object send(ClientWebSocketSession clientWebSocketSession, Frame frame, InterfaceC4014c<? super t> interfaceC4014c) {
            return ClientWebSocketSession.super.send(frame, interfaceC4014c);
        }
    }

    HttpClientCall getCall();

    @Override // io.ktor.websocket.WebSocketSession, Ua.M
    /* synthetic */ kotlin.coroutines.d getCoroutineContext();
}
