package io.modelcontextprotocol.kotlin.sdk.shared;

import io.modelcontextprotocol.kotlin.sdk.JSONRPCMessage;
import kotlin.Metadata;
import qb.AbstractC5171a;

@Metadata(d1 = {"\u0000\u000e\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\u001a\u0017\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\u0000¢\u0006\u0004\b\u0003\u0010\u0004\u001a\u0017\u0010\u0006\u001a\u00020\u00002\u0006\u0010\u0005\u001a\u00020\u0002H\u0000¢\u0006\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"", "line", "Lio/modelcontextprotocol/kotlin/sdk/JSONRPCMessage;", "deserializeMessage", "(Ljava/lang/String;)Lio/modelcontextprotocol/kotlin/sdk/JSONRPCMessage;", "message", "serializeMessage", "(Lio/modelcontextprotocol/kotlin/sdk/JSONRPCMessage;)Ljava/lang/String;", "kotlin-sdk"}, k = 2, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class ReadBufferKt {
    public static final JSONRPCMessage deserializeMessage(String line) {
        kotlin.jvm.internal.p.i(line, "line");
        AbstractC5171a mcpJson = ProtocolKt.getMcpJson();
        mcpJson.getSerializersModule();
        return (JSONRPCMessage) mcpJson.c(JSONRPCMessage.INSTANCE.serializer(), line);
    }

    public static final String serializeMessage(JSONRPCMessage message) {
        kotlin.jvm.internal.p.i(message, "message");
        StringBuilder sb2 = new StringBuilder();
        AbstractC5171a mcpJson = ProtocolKt.getMcpJson();
        mcpJson.getSerializersModule();
        sb2.append(mcpJson.a(JSONRPCMessage.INSTANCE.serializer(), message));
        sb2.append('\n');
        return sb2.toString();
    }
}
