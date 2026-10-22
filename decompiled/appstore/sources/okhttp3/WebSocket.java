package okhttp3;

import javax.annotation.Nullable;
import okio.ByteString;

/* JADX INFO: loaded from: classes4.dex */
public interface WebSocket {

    public interface Factory {
        WebSocket newWebSocket(Request r10, WebSocketListener r11);
    }

    void cancel();

    boolean close(int r10, @Nullable String r11);

    long queueSize();

    Request request();

    boolean send(String r10);

    boolean send(ByteString r10);
}
