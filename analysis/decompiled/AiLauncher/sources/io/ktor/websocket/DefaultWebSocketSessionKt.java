package io.ktor.websocket;

import Ua.CoroutineName;
import io.ktor.util.logging.KtorSimpleLoggerJvmKt;
import io.ktor.websocket.CloseReason;
import kotlin.Metadata;
import kotlin.jvm.internal.p;
import kotlin.time.DurationUnit;
import kotlin.time.a;

@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\f\u001a)\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0001\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u00022\b\b\u0002\u0010\u0004\u001a\u00020\u0002¢\u0006\u0004\b\u0006\u0010\u0007\"\u001e\u0010\n\u001a\u00060\bj\u0002`\t8\u0000X\u0080\u0004¢\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\r\"\u0014\u0010\u000e\u001a\u00020\u00028\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u000e\u0010\u000f\"\u0014\u0010\u0011\u001a\u00020\u00108\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0011\u0010\u0012\"\u0014\u0010\u0013\u001a\u00020\u00108\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0013\u0010\u0012\"\u0014\u0010\u0015\u001a\u00020\u00148\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0015\u0010\u0016\".\u0010\u001d\u001a\u0004\u0018\u00010\u0017*\u00020\u00052\b\u0010\u0018\u001a\u0004\u0018\u00010\u00178Æ\u0002@Æ\u0002X\u0086\u000e¢\u0006\f\u001a\u0004\b\u0019\u0010\u001a\"\u0004\b\u001b\u0010\u001c\"*\u0010\"\u001a\u00020\u0017*\u00020\u00052\u0006\u0010\u0018\u001a\u00020\u00178Æ\u0002@Æ\u0002X\u0086\u000e¢\u0006\f\u001a\u0004\b\u001e\u0010\u001f\"\u0004\b \u0010!¨\u0006#"}, d2 = {"Lio/ktor/websocket/WebSocketSession;", "session", "", "pingIntervalMillis", "timeoutMillis", "Lio/ktor/websocket/DefaultWebSocketSession;", "DefaultWebSocketSession", "(Lio/ktor/websocket/WebSocketSession;JJ)Lio/ktor/websocket/DefaultWebSocketSession;", "Lvc/c;", "Lio/ktor/util/logging/Logger;", "LOGGER", "Lvc/c;", "getLOGGER", "()Lvc/c;", "PINGER_DISABLED", "J", "LUa/L;", "IncomingProcessorCoroutineName", "LUa/L;", "OutgoingProcessorCoroutineName", "Lio/ktor/websocket/CloseReason;", "NORMAL_CLOSE", "Lio/ktor/websocket/CloseReason;", "Lkotlin/time/a;", "newDuration", "getPingInterval", "(Lio/ktor/websocket/DefaultWebSocketSession;)Lkotlin/time/a;", "setPingInterval-6Au4x4Y", "(Lio/ktor/websocket/DefaultWebSocketSession;Lkotlin/time/a;)V", "pingInterval", "getTimeout", "(Lio/ktor/websocket/DefaultWebSocketSession;)J", "setTimeout-HG0u8IE", "(Lio/ktor/websocket/DefaultWebSocketSession;J)V", "timeout", "ktor-websockets"}, k = 2, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class DefaultWebSocketSessionKt {
    public static final long PINGER_DISABLED = 0;
    private static final vc.c LOGGER = KtorSimpleLoggerJvmKt.KtorSimpleLogger("io.ktor.websocket.WebSocket");
    private static final CoroutineName IncomingProcessorCoroutineName = new CoroutineName("ws-incoming-processor");
    private static final CoroutineName OutgoingProcessorCoroutineName = new CoroutineName("ws-outgoing-processor");
    private static final CloseReason NORMAL_CLOSE = new CloseReason(CloseReason.Codes.NORMAL, "OK");

    public static final DefaultWebSocketSession DefaultWebSocketSession(WebSocketSession session, long j10, long j11) {
        p.i(session, "session");
        if (session instanceof DefaultWebSocketSession) {
            throw new IllegalArgumentException("Cannot wrap other DefaultWebSocketSession");
        }
        return new DefaultWebSocketSessionImpl(session, j10, j11);
    }

    public static /* synthetic */ DefaultWebSocketSession DefaultWebSocketSession$default(WebSocketSession webSocketSession, long j10, long j11, int i10, Object obj) {
        if ((i10 & 2) != 0) {
            j10 = 0;
        }
        if ((i10 & 4) != 0) {
            j11 = 15000;
        }
        return DefaultWebSocketSession(webSocketSession, j10, j11);
    }

    public static final vc.c getLOGGER() {
        return LOGGER;
    }

    public static final kotlin.time.a getPingInterval(DefaultWebSocketSession defaultWebSocketSession) {
        p.i(defaultWebSocketSession, "<this>");
        Long lValueOf = Long.valueOf(defaultWebSocketSession.getPingIntervalMillis());
        if (lValueOf.longValue() <= 0) {
            lValueOf = null;
        }
        if (lValueOf == null) {
            return null;
        }
        a.Companion companion = kotlin.time.a.INSTANCE;
        return kotlin.time.a.i(kotlin.time.b.t(lValueOf.longValue(), DurationUnit.MILLISECONDS));
    }

    public static final long getTimeout(DefaultWebSocketSession defaultWebSocketSession) {
        p.i(defaultWebSocketSession, "<this>");
        a.Companion companion = kotlin.time.a.INSTANCE;
        return kotlin.time.b.t(defaultWebSocketSession.getTimeoutMillis(), DurationUnit.MILLISECONDS);
    }

    /* renamed from: setPingInterval-6Au4x4Y, reason: not valid java name */
    public static final void m219setPingInterval6Au4x4Y(DefaultWebSocketSession pingInterval, kotlin.time.a aVar) {
        p.i(pingInterval, "$this$pingInterval");
        pingInterval.setPingIntervalMillis(aVar != null ? kotlin.time.a.s(aVar.getRawValue()) : 0L);
    }

    /* renamed from: setTimeout-HG0u8IE, reason: not valid java name */
    public static final void m220setTimeoutHG0u8IE(DefaultWebSocketSession timeout, long j10) {
        p.i(timeout, "$this$timeout");
        timeout.setTimeoutMillis(kotlin.time.a.s(j10));
    }
}
