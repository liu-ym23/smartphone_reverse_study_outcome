package io.modelcontextprotocol.client;

import io.modelcontextprotocol.client.LifecycleInitializer;
import io.modelcontextprotocol.spec.McpSchema;
import java.util.function.Function;

/* loaded from: classes2.dex */
public final /* synthetic */ class n implements Function {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f4643a;
    public final /* synthetic */ McpAsyncClient b;
    public final /* synthetic */ McpSchema.CallToolRequest c;

    public /* synthetic */ n(McpAsyncClient mcpAsyncClient, McpSchema.CallToolRequest callToolRequest, int i) {
        this.f4643a = i;
        this.b = mcpAsyncClient;
        this.c = callToolRequest;
    }

    @Override // java.util.function.Function
    public final Object apply(Object obj) {
        switch (this.f4643a) {
            case 0:
                return this.b.lambda$callTool$28(this.c, (LifecycleInitializer.Initialization) obj);
            default:
                return this.b.lambda$callTool$27(this.c, (McpSchema.CallToolResult) obj);
        }
    }
}
