package io.modelcontextprotocol.client;

import io.modelcontextprotocol.spec.McpSchema;
import java.util.function.Consumer;

/* loaded from: classes2.dex */
public final /* synthetic */ class k implements Consumer {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f4640a;
    public final /* synthetic */ McpAsyncClient b;

    public /* synthetic */ k(McpAsyncClient mcpAsyncClient, int i) {
        this.f4640a = i;
        this.b = mcpAsyncClient;
    }

    @Override // java.util.function.Consumer
    public final void accept(Object obj) {
        int i = this.f4640a;
        McpAsyncClient mcpAsyncClient = this.b;
        switch (i) {
            case 0:
                mcpAsyncClient.lambda$listToolsInternal$34((McpSchema.Tool) obj);
                break;
            case 1:
                mcpAsyncClient.lambda$new$15((McpSchema.Tool) obj);
                break;
            case 2:
                mcpAsyncClient.lambda$listToolsInternal$35((McpSchema.ListToolsResult) obj);
                break;
            default:
                mcpAsyncClient.lambda$new$16((McpSchema.ListToolsResult) obj);
                break;
        }
    }
}
