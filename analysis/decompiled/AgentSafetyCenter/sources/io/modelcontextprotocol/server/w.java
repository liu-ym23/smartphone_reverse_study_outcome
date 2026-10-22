package io.modelcontextprotocol.server;

import io.modelcontextprotocol.common.McpTransportContext;
import io.modelcontextprotocol.server.McpServerFeatures;
import io.modelcontextprotocol.server.McpStatelessServerFeatures;
import io.modelcontextprotocol.spec.McpSchema;
import java.util.function.BiFunction;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final /* synthetic */ class w implements BiFunction {

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ int f6329c;

    /* renamed from: f, reason: collision with root package name */
    public /* synthetic */ boolean f6330f;

    /* renamed from: g, reason: collision with root package name */
    public /* synthetic */ androidx.activity.b f6331g;

    public /* synthetic */ w(int i) {
        this.f6329c = i;
    }

    @Override // java.util.function.BiFunction
    public final Object apply(Object obj, Object obj2) {
        switch (this.f6329c) {
            case 0:
                return McpServerFeatures.AsyncCompletionSpecification.lambda$fromSync$1((McpServerFeatures.SyncCompletionSpecification) this.f6331g, this.f6330f, (McpAsyncServerExchange) obj, (McpSchema.CompleteRequest) obj2);
            case 1:
                return McpServerFeatures.AsyncPromptSpecification.lambda$fromSync$1((McpServerFeatures.SyncPromptSpecification) this.f6331g, this.f6330f, (McpAsyncServerExchange) obj, (McpSchema.GetPromptRequest) obj2);
            case 2:
                return McpServerFeatures.AsyncResourceSpecification.lambda$fromSync$1((McpServerFeatures.SyncResourceSpecification) this.f6331g, this.f6330f, (McpAsyncServerExchange) obj, (McpSchema.ReadResourceRequest) obj2);
            case 3:
                return McpServerFeatures.AsyncResourceTemplateSpecification.lambda$fromSync$1((McpServerFeatures.SyncResourceTemplateSpecification) this.f6331g, this.f6330f, (McpAsyncServerExchange) obj, (McpSchema.ReadResourceRequest) obj2);
            case 4:
                return McpStatelessServerFeatures.AsyncCompletionSpecification.lambda$fromSync$1((McpStatelessServerFeatures.SyncCompletionSpecification) this.f6331g, this.f6330f, (McpTransportContext) obj, (McpSchema.CompleteRequest) obj2);
            case 5:
                return McpStatelessServerFeatures.AsyncPromptSpecification.lambda$fromSync$1((McpStatelessServerFeatures.SyncPromptSpecification) this.f6331g, this.f6330f, (McpTransportContext) obj, (McpSchema.GetPromptRequest) obj2);
            case 6:
                return McpStatelessServerFeatures.AsyncResourceSpecification.lambda$fromSync$1((McpStatelessServerFeatures.SyncResourceSpecification) this.f6331g, this.f6330f, (McpTransportContext) obj, (McpSchema.ReadResourceRequest) obj2);
            case 7:
                return McpStatelessServerFeatures.AsyncResourceTemplateSpecification.lambda$fromSync$1((McpStatelessServerFeatures.SyncResourceTemplateSpecification) this.f6331g, this.f6330f, (McpTransportContext) obj, (McpSchema.ReadResourceRequest) obj2);
            default:
                return McpStatelessServerFeatures.AsyncToolSpecification.lambda$fromSync$1((McpStatelessServerFeatures.SyncToolSpecification) this.f6331g, this.f6330f, (McpTransportContext) obj, (McpSchema.CallToolRequest) obj2);
        }
    }
}
