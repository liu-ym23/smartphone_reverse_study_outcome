package io.ktor.websocket;

import Ua.Q;
import Y8.t;
import Z8.C1173v;
import e9.InterfaceC4014c;
import io.ktor.utils.io.InternalAPI;
import java.util.List;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\bf\u0018\u00002\u00020\u0001J#\u0010\u0006\u001a\u00020\u00052\u0012\b\u0002\u0010\u0004\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00030\u0002H'¢\u0006\u0004\b\u0006\u0010\u0007R\u001c\u0010\r\u001a\u00020\b8&@&X¦\u000e¢\u0006\f\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR\u001c\u0010\u0010\u001a\u00020\b8&@&X¦\u000e¢\u0006\f\u001a\u0004\b\u000e\u0010\n\"\u0004\b\u000f\u0010\fR\u001c\u0010\u0015\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00120\u00118&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0013\u0010\u0014¨\u0006\u0016À\u0006\u0003"}, d2 = {"Lio/ktor/websocket/DefaultWebSocketSession;", "Lio/ktor/websocket/WebSocketSession;", "", "Lio/ktor/websocket/WebSocketExtension;", "negotiatedExtensions", "LY8/t;", "start", "(Ljava/util/List;)V", "", "getPingIntervalMillis", "()J", "setPingIntervalMillis", "(J)V", "pingIntervalMillis", "getTimeoutMillis", "setTimeoutMillis", "timeoutMillis", "LUa/Q;", "Lio/ktor/websocket/CloseReason;", "getCloseReason", "()LUa/Q;", "closeReason", "ktor-websockets"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes4.dex */
public interface DefaultWebSocketSession extends WebSocketSession {

    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    public static final class DefaultImpls {
        @Deprecated
        public static Object send(DefaultWebSocketSession defaultWebSocketSession, Frame frame, InterfaceC4014c<? super t> interfaceC4014c) {
            return DefaultWebSocketSession.super.send(frame, interfaceC4014c);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    static /* synthetic */ void start$default(DefaultWebSocketSession defaultWebSocketSession, List list, int i10, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: start");
        }
        if ((i10 & 1) != 0) {
            list = C1173v.m();
        }
        defaultWebSocketSession.start(list);
    }

    Q<CloseReason> getCloseReason();

    @Override // io.ktor.websocket.WebSocketSession, Ua.M
    /* synthetic */ kotlin.coroutines.d getCoroutineContext();

    long getPingIntervalMillis();

    long getTimeoutMillis();

    void setPingIntervalMillis(long j10);

    void setTimeoutMillis(long j10);

    @InternalAPI
    void start(List<? extends WebSocketExtension<?>> negotiatedExtensions);
}
