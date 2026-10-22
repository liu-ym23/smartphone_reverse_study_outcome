package io.modelcontextprotocol.client;

import io.modelcontextprotocol.spec.McpSchema;
import java.util.function.BiFunction;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final /* synthetic */ class i implements BiFunction {

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ int f6125c;

    public /* synthetic */ i(int i) {
        this.f6125c = i;
    }

    @Override // java.util.function.BiFunction
    public final Object apply(Object obj, Object obj2) {
        switch (this.f6125c) {
            case 0:
                return McpAsyncClient.lambda$listPrompts$60((McpSchema.ListPromptsResult) obj, (McpSchema.ListPromptsResult) obj2);
            case 1:
                return McpAsyncClient.lambda$listTools$30((McpSchema.ListToolsResult) obj, (McpSchema.ListToolsResult) obj2);
            case 2:
                return McpAsyncClient.lambda$listResourceTemplates$46((McpSchema.ListResourceTemplatesResult) obj, (McpSchema.ListResourceTemplatesResult) obj2);
            default:
                return McpAsyncClient.lambda$listResources$41((McpSchema.ListResourcesResult) obj, (McpSchema.ListResourcesResult) obj2);
        }
    }
}
