package io.ktor.client.plugins.websocket;

import Y8.t;
import io.ktor.client.engine.HttpClientEngineCapability;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\bÆ\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0006\u001a\u00020\u0005HÖ\u0001¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\t\u001a\u00020\bHÖ\u0001¢\u0006\u0004\b\t\u0010\nJ\u001a\u0010\u000e\u001a\u00020\r2\b\u0010\f\u001a\u0004\u0018\u00010\u000bHÖ\u0003¢\u0006\u0004\b\u000e\u0010\u000f¨\u0006\u0010"}, d2 = {"Lio/ktor/client/plugins/websocket/WebSocketCapability;", "Lio/ktor/client/engine/HttpClientEngineCapability;", "LY8/t;", "<init>", "()V", "", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "ktor-client-core"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes4.dex */
public final /* data */ class WebSocketCapability implements HttpClientEngineCapability<t> {
    public static final WebSocketCapability INSTANCE = new WebSocketCapability();

    private WebSocketCapability() {
    }

    public boolean equals(Object other) {
        return this == other || (other instanceof WebSocketCapability);
    }

    public int hashCode() {
        return -1146563391;
    }

    public String toString() {
        return "WebSocketCapability";
    }
}
