package com.stepos.mcp.sdk.java.transport;

import com.stepos.mcp.sdk.IMCPBinderCallback;
import io.modelcontextprotocol.json.McpJsonMapper;
import io.modelcontextprotocol.spec.McpClientTransport;
import io.modelcontextprotocol.spec.McpSchema;
import q7.C5157a;
import reactor.core.publisher.Sinks;

/* loaded from: classes.dex */
public class AndroidClientTransport implements McpClientTransport {

    /* renamed from: com.stepos.mcp.sdk.java.transport.AndroidClientTransport$2, reason: invalid class name */
    public class AnonymousClass2 extends IMCPBinderCallback.Stub {
        final /* synthetic */ AndroidClientTransport this$0;

        public AnonymousClass2(AndroidClientTransport androidClientTransport) {
        }

        @Override // com.stepos.mcp.sdk.IMCPBinderCallback
        public void onFailure(String str) {
            C5157a.a("AndroidClientTransport", "Received error response: " + str);
        }

        @Override // com.stepos.mcp.sdk.IMCPBinderCallback
        public void onSuccess(String str) {
            C5157a.a("AndroidClientTransport", "Received success response: " + str);
            try {
                McpSchema.JSONRPCMessage jSONRPCMessageDeserializeJsonRpcMessage = McpSchema.deserializeJsonRpcMessage(AndroidClientTransport.c(null), str);
                if (AndroidClientTransport.a(null).tryEmitNext(jSONRPCMessageDeserializeJsonRpcMessage).isSuccess() || AndroidClientTransport.b(null)) {
                    return;
                }
                C5157a.a("AndroidClientTransport", "Failed to enqueue inbound message: " + jSONRPCMessageDeserializeJsonRpcMessage);
            } catch (Exception e10) {
                if (AndroidClientTransport.b(null)) {
                    return;
                }
                C5157a.a("AndroidClientTransport", "Error processing inbound message for line: " + str);
                C5157a.a("AndroidClientTransport", "Error processing inbound message for line: " + e10);
            }
        }
    }

    public static /* bridge */ /* synthetic */ Sinks.Many a(AndroidClientTransport androidClientTransport) {
        throw null;
    }

    public static /* bridge */ /* synthetic */ boolean b(AndroidClientTransport androidClientTransport) {
        throw null;
    }

    public static /* bridge */ /* synthetic */ McpJsonMapper c(AndroidClientTransport androidClientTransport) {
        throw null;
    }
}
