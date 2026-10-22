package io.modelcontextprotocol.client;

import io.modelcontextprotocol.spec.McpSchema;
import java.util.function.Consumer;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final /* synthetic */ class k implements Consumer {

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ int f6127c;

    /* renamed from: f, reason: collision with root package name */
    public /* synthetic */ McpAsyncClient f6128f;

    public /* synthetic */ k(int i) {
        this.f6127c = i;
    }

    @Override // java.util.function.Consumer
    public final void accept(Object obj) {
        int i = this.f6127c;
        McpAsyncClient mcpAsyncClient = this.f6128f;
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
