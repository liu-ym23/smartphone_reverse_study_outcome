package com.stepos.agentframework.adapter.bff;

import com.bytedance.apm.agent.v2.instrumentation.AppAgent;
import com.stepos.aiengine.args.SingleFileBundle;
import com.stepos.taskrobot.settingsprovider.SettingsConfig;
import java.net.URI;
import java.nio.ByteBuffer;
import kotlin.Metadata;
import kotlin.jvm.internal.k;
import org.java_websocket.client.WebSocketClient;
import org.java_websocket.handshake.ServerHandshake;

@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0006\u0010\u0007J\u0019\u0010\u000b\u001a\u00020\n2\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0016¢\u0006\u0004\b\u000b\u0010\fJ\u0019\u0010\u000f\u001a\u00020\n2\b\u0010\u000e\u001a\u0004\u0018\u00010\rH\u0016¢\u0006\u0004\b\u000f\u0010\u0010J\u0019\u0010\u000f\u001a\u00020\n2\b\u0010\u0012\u001a\u0004\u0018\u00010\u0011H\u0016¢\u0006\u0004\b\u000f\u0010\u0013J)\u0010\u0019\u001a\u00020\n2\u0006\u0010\u0015\u001a\u00020\u00142\b\u0010\u0016\u001a\u0004\u0018\u00010\r2\u0006\u0010\u0018\u001a\u00020\u0017H\u0016¢\u0006\u0004\b\u0019\u0010\u001aJ\u0019\u0010\u001d\u001a\u00020\n2\b\u0010\u001c\u001a\u0004\u0018\u00010\u001bH\u0016¢\u0006\u0004\b\u001d\u0010\u001eR\u0017\u0010\u0005\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\u0005\u0010\u001f\u001a\u0004\b \u0010!¨\u0006\""}, d2 = {"Lcom/stepos/agentframework/adapter/bff/ZyqlWebSocketClient;", "Lorg/java_websocket/client/WebSocketClient;", "Ljava/net/URI;", "uri", "Lcom/stepos/agentframework/adapter/bff/IOriDataCallback;", "callback", AppAgent.CONSTRUCT, "(Ljava/net/URI;Lcom/stepos/agentframework/adapter/bff/IOriDataCallback;)V", "Lorg/java_websocket/handshake/ServerHandshake;", "handshakedata", "LC7/r;", "onOpen", "(Lorg/java_websocket/handshake/ServerHandshake;)V", "", SettingsConfig.KEY_DATA, "onMessage", "(Ljava/lang/String;)V", "Ljava/nio/ByteBuffer;", SingleFileBundle.KEY_BYTES, "(Ljava/nio/ByteBuffer;)V", "", "code", "reason", "", "remote", "onClose", "(ILjava/lang/String;Z)V", "Ljava/lang/Exception;", "ex", "onError", "(Ljava/lang/Exception;)V", "Lcom/stepos/agentframework/adapter/bff/IOriDataCallback;", "getCallback", "()Lcom/stepos/agentframework/adapter/bff/IOriDataCallback;", "bff_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class ZyqlWebSocketClient extends WebSocketClient {
    private final IOriDataCallback callback;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ZyqlWebSocketClient(URI uri, IOriDataCallback callback) {
        super(uri);
        k.f(uri, "uri");
        k.f(callback, "callback");
        this.callback = callback;
    }

    public final IOriDataCallback getCallback() {
        return this.callback;
    }

    @Override // org.java_websocket.client.WebSocketClient
    public void onClose(int code, String reason, boolean remote) {
        this.callback.onClose(code, reason, remote);
    }

    @Override // org.java_websocket.client.WebSocketClient
    public void onError(Exception ex) {
        this.callback.onError(ex);
    }

    @Override // org.java_websocket.client.WebSocketClient
    public void onMessage(String data) {
        this.callback.onDataReceived(data);
    }

    @Override // org.java_websocket.client.WebSocketClient
    public void onOpen(ServerHandshake handshakedata) {
        this.callback.onConnect();
    }

    @Override // org.java_websocket.client.WebSocketClient
    public void onMessage(ByteBuffer bytes) {
        super.onMessage(bytes);
        this.callback.onDataReceived(bytes);
    }
}
