package io.ktor.websocket;

import Y8.t;
import io.ktor.util.AttributeKey;
import io.ktor.websocket.WebSocketExtension;
import kotlin.Metadata;
import p9.InterfaceC5074l;

@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\b\bf\u0018\u0000*\b\b\u0000\u0010\u0002*\u00020\u0001*\u000e\b\u0001\u0010\u0004*\b\u0012\u0004\u0012\u00028\u00000\u00032\u00020\u0001J#\u0010\b\u001a\u00028\u00012\u0012\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\u00060\u0005H&¢\u0006\u0004\b\b\u0010\tR\u001a\u0010\r\u001a\b\u0012\u0004\u0012\u00028\u00010\n8&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u000b\u0010\fR\u0014\u0010\u0011\u001a\u00020\u000e8&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u000f\u0010\u0010R\u0014\u0010\u0013\u001a\u00020\u000e8&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0012\u0010\u0010R\u0014\u0010\u0015\u001a\u00020\u000e8&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0014\u0010\u0010¨\u0006\u0016À\u0006\u0003"}, d2 = {"Lio/ktor/websocket/WebSocketExtensionFactory;", "", "ConfigType", "Lio/ktor/websocket/WebSocketExtension;", "ExtensionType", "Lkotlin/Function1;", "LY8/t;", "config", W4.b.STEP_INSTALL, "(Lp9/l;)Lio/ktor/websocket/WebSocketExtension;", "Lio/ktor/util/AttributeKey;", "getKey", "()Lio/ktor/util/AttributeKey;", "key", "", "getRsv1", "()Z", "rsv1", "getRsv2", "rsv2", "getRsv3", "rsv3", "ktor-websockets"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes4.dex */
public interface WebSocketExtensionFactory<ConfigType, ExtensionType extends WebSocketExtension<ConfigType>> {
    AttributeKey<ExtensionType> getKey();

    boolean getRsv1();

    boolean getRsv2();

    boolean getRsv3();

    ExtensionType install(InterfaceC5074l<? super ConfigType, t> config);
}
