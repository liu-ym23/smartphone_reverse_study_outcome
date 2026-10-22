package com.stepos.mcp.sdk.java.transport;

import com.stepos.mcp.sdk.java.transport.ServerTransportProvider;
import io.modelcontextprotocol.spec.McpSchema;
import io.modelcontextprotocol.spec.McpTransport;
import java.util.function.Supplier;

/* loaded from: classes3.dex */
public final /* synthetic */ class k implements Supplier {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f3841a;
    public final /* synthetic */ McpSchema.JSONRPCMessage b;
    public final /* synthetic */ McpTransport c;

    public /* synthetic */ k(McpTransport mcpTransport, McpSchema.JSONRPCMessage jSONRPCMessage, int i) {
        this.f3841a = i;
        this.c = mcpTransport;
        this.b = jSONRPCMessage;
    }

    @Override // java.util.function.Supplier
    public final Object get() {
        switch (this.f3841a) {
            case 0:
                return ((ServerTransportProvider.ServerSessionTransport) this.c).lambda$sendMessage$0(this.b);
            default:
                return ((AndroidClientTransport) this.c).lambda$sendMessage$4(this.b);
        }
    }
}
