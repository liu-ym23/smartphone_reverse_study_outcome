package io.ktor.client.plugins.websocket;

import io.ktor.util.AttributeKey;
import io.ktor.util.logging.KtorSimpleLoggerJvmKt;
import io.ktor.util.reflect.TypeInfo;
import io.ktor.websocket.WebSocketExtension;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.t;
import w9.C5757p;
import w9.InterfaceC5745d;
import w9.InterfaceC5755n;

@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\"$\u0010\u0003\u001a\u0012\u0012\u000e\u0012\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00020\u00010\u00008\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0003\u0010\u0004\"\u001e\u0010\u0007\u001a\u00060\u0005j\u0002`\u00068\u0000X\u0080\u0004¢\u0006\f\n\u0004\b\u0007\u0010\b\u001a\u0004\b\t\u0010\n¨\u0006\u000b"}, d2 = {"Lio/ktor/util/AttributeKey;", "", "Lio/ktor/websocket/WebSocketExtension;", "REQUEST_EXTENSIONS_KEY", "Lio/ktor/util/AttributeKey;", "Lvc/c;", "Lio/ktor/util/logging/Logger;", "LOGGER", "Lvc/c;", "getLOGGER", "()Lvc/c;", "ktor-client-core"}, k = 2, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class WebSocketsKt {
    private static final vc.c LOGGER;
    private static final AttributeKey<List<WebSocketExtension<?>>> REQUEST_EXTENSIONS_KEY;

    static {
        InterfaceC5755n interfaceC5755nN;
        InterfaceC5745d interfaceC5745dB = t.b(List.class);
        try {
            C5757p.Companion companion = C5757p.INSTANCE;
            interfaceC5755nN = t.n(List.class, companion.d(t.n(WebSocketExtension.class, companion.c())));
        } catch (Throwable unused) {
            interfaceC5755nN = null;
        }
        REQUEST_EXTENSIONS_KEY = new AttributeKey<>("Websocket extensions", new TypeInfo(interfaceC5745dB, interfaceC5755nN));
        LOGGER = KtorSimpleLoggerJvmKt.KtorSimpleLogger("io.ktor.client.plugins.websocket.WebSockets");
    }

    public static final vc.c getLOGGER() {
        return LOGGER;
    }
}
