package io.ktor.client.plugins.websocket;

import com.autonavi.aps.amapapi.config.Const;
import io.ktor.client.plugins.websocket.WebSockets;
import io.ktor.websocket.WebSocketExtensionsConfig;
import kotlin.Metadata;
import kotlin.time.DurationUnit;
import kotlin.time.a;

@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\u001a!\u0010\u0007\u001a\u00020\u00042\b\u0010\u0001\u001a\u0004\u0018\u00010\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0005\u0010\u0006\"\u0018\u0010\u0001\u001a\u0004\u0018\u00010\u0000*\u00020\u00048Æ\u0002¢\u0006\u0006\u001a\u0004\b\b\u0010\t\".\u0010\u0001\u001a\u0004\u0018\u00010\u0000*\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\u00008Æ\u0002@Æ\u0002X\u0086\u000e¢\u0006\f\u001a\u0004\b\b\u0010\f\"\u0004\b\r\u0010\u000e¨\u0006\u000f"}, d2 = {"Lkotlin/time/a;", "pingInterval", "", "maxFrameSize", "Lio/ktor/client/plugins/websocket/WebSockets;", "WebSockets-dnQKTGw", "(Lkotlin/time/a;J)Lio/ktor/client/plugins/websocket/WebSockets;", "WebSockets", "getPingInterval", "(Lio/ktor/client/plugins/websocket/WebSockets;)Lkotlin/time/a;", "Lio/ktor/client/plugins/websocket/WebSockets$Config;", Const.STR_NEW, "(Lio/ktor/client/plugins/websocket/WebSockets$Config;)Lkotlin/time/a;", "setPingInterval-6Au4x4Y", "(Lio/ktor/client/plugins/websocket/WebSockets$Config;Lkotlin/time/a;)V", "ktor-client-core"}, k = 2, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class DurationsKt {
    /* renamed from: WebSockets-dnQKTGw, reason: not valid java name */
    public static final WebSockets m137WebSocketsdnQKTGw(kotlin.time.a aVar, long j10) {
        return new WebSockets(aVar != null ? kotlin.time.a.s(aVar.getRawValue()) : 0L, j10, new WebSocketExtensionsConfig(), null, 8, null);
    }

    /* renamed from: WebSockets-dnQKTGw$default, reason: not valid java name */
    public static /* synthetic */ WebSockets m138WebSocketsdnQKTGw$default(kotlin.time.a aVar, long j10, int i10, Object obj) {
        if ((i10 & 2) != 0) {
            j10 = 2147483647L;
        }
        return m137WebSocketsdnQKTGw(aVar, j10);
    }

    public static final kotlin.time.a getPingInterval(WebSockets webSockets) {
        kotlin.jvm.internal.p.i(webSockets, "<this>");
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

    /* renamed from: setPingInterval-6Au4x4Y, reason: not valid java name */
    public static final void m139setPingInterval6Au4x4Y(WebSockets.Config pingInterval, kotlin.time.a aVar) {
        kotlin.jvm.internal.p.i(pingInterval, "$this$pingInterval");
        pingInterval.setPingIntervalMillis(aVar != null ? kotlin.time.a.s(aVar.getRawValue()) : 0L);
    }

    public static final kotlin.time.a getPingInterval(WebSockets.Config config) {
        kotlin.jvm.internal.p.i(config, "<this>");
        Long lValueOf = Long.valueOf(config.getPingIntervalMillis());
        if (lValueOf.longValue() <= 0) {
            lValueOf = null;
        }
        if (lValueOf == null) {
            return null;
        }
        a.Companion companion = kotlin.time.a.INSTANCE;
        return kotlin.time.a.i(kotlin.time.b.t(lValueOf.longValue(), DurationUnit.MILLISECONDS));
    }
}
