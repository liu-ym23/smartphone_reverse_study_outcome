package ad;

import okhttp3.Response;
import okio.ByteString;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public abstract class w {
    public void onClosed(v webSocket, int i10, String reason) {
        kotlin.jvm.internal.g.f(webSocket, "webSocket");
        kotlin.jvm.internal.g.f(reason, "reason");
    }

    public void onClosing(v webSocket, int i10, String reason) {
        kotlin.jvm.internal.g.f(webSocket, "webSocket");
        kotlin.jvm.internal.g.f(reason, "reason");
    }

    public void onFailure(v webSocket, Throwable t8, Response response) {
        kotlin.jvm.internal.g.f(webSocket, "webSocket");
        kotlin.jvm.internal.g.f(t8, "t");
    }

    public void onMessage(v webSocket, String text) {
        kotlin.jvm.internal.g.f(webSocket, "webSocket");
        kotlin.jvm.internal.g.f(text, "text");
    }

    public void onOpen(v webSocket, Response response) {
        kotlin.jvm.internal.g.f(webSocket, "webSocket");
        kotlin.jvm.internal.g.f(response, "response");
    }

    public void onMessage(v webSocket, ByteString bytes) {
        kotlin.jvm.internal.g.f(webSocket, "webSocket");
        kotlin.jvm.internal.g.f(bytes, "bytes");
    }
}
