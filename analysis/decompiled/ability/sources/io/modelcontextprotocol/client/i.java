package io.modelcontextprotocol.client;

import io.modelcontextprotocol.spec.McpSchema;
import java.util.function.BiFunction;

/* loaded from: classes2.dex */
public final /* synthetic */ class i implements BiFunction {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f4638a;

    public /* synthetic */ i(int i) {
        this.f4638a = i;
    }

    @Override // java.util.function.BiFunction
    public final Object apply(Object obj, Object obj2) {
        switch (this.f4638a) {
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
