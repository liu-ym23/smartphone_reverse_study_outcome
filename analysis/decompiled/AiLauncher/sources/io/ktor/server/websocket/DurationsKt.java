package io.ktor.server.websocket;

import com.autonavi.aps.amapapi.config.Const;
import io.ktor.server.websocket.WebSockets;
import kotlin.Metadata;
import kotlin.jvm.internal.p;
import kotlin.time.DurationUnit;
import kotlin.time.a;

@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\n\u001a/\u0010\n\u001a\u00020\u00072\b\u0010\u0001\u001a\u0004\u0018\u00010\u00002\u0006\u0010\u0002\u001a\u00020\u00002\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0005¢\u0006\u0004\b\b\u0010\t\"\u0018\u0010\u0001\u001a\u0004\u0018\u00010\u0000*\u00020\u00078Æ\u0002¢\u0006\u0006\u001a\u0004\b\u000b\u0010\f\"\u0016\u0010\u0002\u001a\u00020\u0000*\u00020\u00078Æ\u0002¢\u0006\u0006\u001a\u0004\b\r\u0010\u000e\".\u0010\u0015\u001a\u0004\u0018\u00010\u0000*\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u00008Æ\u0002@Æ\u0002X\u0086\u000e¢\u0006\f\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014\"*\u0010\u0002\u001a\u00020\u0000*\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00008Æ\u0002@Æ\u0002X\u0086\u000e¢\u0006\f\u001a\u0004\b\r\u0010\u0016\"\u0004\b\u0017\u0010\u0018¨\u0006\u0019"}, d2 = {"Lkotlin/time/a;", "pingInterval", "timeout", "", "maxFrameSize", "", "masking", "Lio/ktor/server/websocket/WebSockets;", "WebSockets-EBYhdyk", "(Lkotlin/time/a;JJZ)Lio/ktor/server/websocket/WebSockets;", "WebSockets", "getPingInterval", "(Lio/ktor/server/websocket/WebSockets;)Lkotlin/time/a;", "getTimeout", "(Lio/ktor/server/websocket/WebSockets;)J", "Lio/ktor/server/websocket/WebSockets$WebSocketOptions;", Const.STR_NEW, "getPingPeriod", "(Lio/ktor/server/websocket/WebSockets$WebSocketOptions;)Lkotlin/time/a;", "setPingPeriod-6Au4x4Y", "(Lio/ktor/server/websocket/WebSockets$WebSocketOptions;Lkotlin/time/a;)V", "pingPeriod", "(Lio/ktor/server/websocket/WebSockets$WebSocketOptions;)J", "setTimeout-HG0u8IE", "(Lio/ktor/server/websocket/WebSockets$WebSocketOptions;J)V", "ktor-server-websockets"}, k = 2, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class DurationsKt {
    /* renamed from: WebSockets-EBYhdyk, reason: not valid java name */
    public static final WebSockets m181WebSocketsEBYhdyk(kotlin.time.a aVar, long j10, long j11, boolean z10) {
        return new WebSockets(aVar != null ? kotlin.time.a.s(aVar.getRawValue()) : 0L, kotlin.time.a.s(j10), j11, z10);
    }

    public static final kotlin.time.a getPingInterval(WebSockets webSockets) {
        p.i(webSockets, "<this>");
        Long lValueOf = Long.valueOf(webSockets.getPingIntervalMillis());
        if (lValueOf.longValue() <= 0) {
            lValueOf = null;
        }
        if (lValueOf == null) {
            return null;
        }
        a.Companion companion = kotlin.time.a.INSTANCE;
        return kotlin.time.a.i(kotlin.time.b.t(lValueOf.longValue(), DurationUnit.MILLISECONDS));
    }

    public static final kotlin.time.a getPingPeriod(WebSockets.WebSocketOptions webSocketOptions) {
        p.i(webSocketOptions, "<this>");
        Long lValueOf = Long.valueOf(webSocketOptions.getPingPeriodMillis());
        if (lValueOf.longValue() <= 0) {
            lValueOf = null;
        }
        if (lValueOf == null) {
            return null;
        }
        a.Companion companion = kotlin.time.a.INSTANCE;
        return kotlin.time.a.i(kotlin.time.b.t(lValueOf.longValue(), DurationUnit.MILLISECONDS));
    }

    public static final long getTimeout(WebSockets webSockets) {
        p.i(webSockets, "<this>");
        a.Companion companion = kotlin.time.a.INSTANCE;
        return kotlin.time.b.t(webSockets.getTimeoutMillis(), DurationUnit.MILLISECONDS);
    }

    /* renamed from: setPingPeriod-6Au4x4Y, reason: not valid java name */
    public static final void m182setPingPeriod6Au4x4Y(WebSockets.WebSocketOptions pingPeriod, kotlin.time.a aVar) {
        p.i(pingPeriod, "$this$pingPeriod");
        pingPeriod.setPingPeriodMillis(aVar != null ? kotlin.time.a.s(aVar.getRawValue()) : 0L);
    }

    /* renamed from: setTimeout-HG0u8IE, reason: not valid java name */
    public static final void m183setTimeoutHG0u8IE(WebSockets.WebSocketOptions timeout, long j10) {
        p.i(timeout, "$this$timeout");
        timeout.setTimeoutMillis(kotlin.time.a.s(j10));
    }

    public static final long getTimeout(WebSockets.WebSocketOptions webSocketOptions) {
        p.i(webSocketOptions, "<this>");
        a.Companion companion = kotlin.time.a.INSTANCE;
        return kotlin.time.b.t(webSocketOptions.getTimeoutMillis(), DurationUnit.MILLISECONDS);
    }
}
