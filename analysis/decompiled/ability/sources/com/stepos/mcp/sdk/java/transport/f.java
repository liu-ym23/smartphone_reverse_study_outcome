package com.stepos.mcp.sdk.java.transport;

import com.stepos.mcp.sdk.java.transport.AIDLServerTransportProvider;
import io.modelcontextprotocol.spec.McpSchema;
import io.modelcontextprotocol.spec.McpTransport;
import java.util.function.Function;

/* loaded from: classes3.dex */
public final /* synthetic */ class f implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f3837a;
    public final /* synthetic */ McpTransport b;
    public final /* synthetic */ Object c;

    public /* synthetic */ f(McpTransport mcpTransport, Object obj, int i) {
        this.f3837a = i;
        this.b = mcpTransport;
        this.c = obj;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.f3837a) {
            case 0:
                ((AIDLServerTransportProvider.Transport) this.b).lambda$sendMessage$0((McpSchema.JSONRPCMessage) this.c);
                break;
            default:
                ((AndroidClientTransport) this.b).lambda$connect$1((Function) this.c);
                break;
        }
    }
}
