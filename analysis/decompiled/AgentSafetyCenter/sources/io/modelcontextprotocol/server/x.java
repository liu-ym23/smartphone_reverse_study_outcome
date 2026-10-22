package io.modelcontextprotocol.server;

import io.modelcontextprotocol.common.McpTransportContext;
import io.modelcontextprotocol.server.McpServerFeatures;
import io.modelcontextprotocol.server.McpStatelessServerFeatures;
import io.modelcontextprotocol.spec.McpSchema;
import java.util.Map;
import java.util.concurrent.Callable;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final /* synthetic */ class x implements Callable {

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ int f6332c;

    /* renamed from: f, reason: collision with root package name */
    public /* synthetic */ Object f6333f;

    /* renamed from: g, reason: collision with root package name */
    public /* synthetic */ androidx.activity.b f6334g;

    /* renamed from: h, reason: collision with root package name */
    public /* synthetic */ Object f6335h;

    public /* synthetic */ x(int i) {
        this.f6332c = i;
    }

    @Override // java.util.concurrent.Callable
    public final Object call() {
        switch (this.f6332c) {
            case 0:
                return McpServerFeatures.AsyncCompletionSpecification.lambda$fromSync$0((McpServerFeatures.SyncCompletionSpecification) this.f6334g, (McpAsyncServerExchange) this.f6333f, (McpSchema.CompleteRequest) this.f6335h);
            case 1:
                return McpServerFeatures.AsyncPromptSpecification.lambda$fromSync$0((McpServerFeatures.SyncPromptSpecification) this.f6334g, (McpAsyncServerExchange) this.f6333f, (McpSchema.GetPromptRequest) this.f6335h);
            case 2:
                return McpServerFeatures.AsyncResourceSpecification.lambda$fromSync$0((McpServerFeatures.SyncResourceSpecification) this.f6334g, (McpAsyncServerExchange) this.f6333f, (McpSchema.ReadResourceRequest) this.f6335h);
            case 3:
                return McpServerFeatures.AsyncResourceTemplateSpecification.lambda$fromSync$0((McpServerFeatures.SyncResourceTemplateSpecification) this.f6334g, (McpAsyncServerExchange) this.f6333f, (McpSchema.ReadResourceRequest) this.f6335h);
            case 4:
                return McpServerFeatures.AsyncToolSpecification.lambda$fromSync$1((McpServerFeatures.SyncToolSpecification) this.f6334g, (McpAsyncServerExchange) this.f6333f, (Map) this.f6335h);
            case 5:
                return McpServerFeatures.AsyncToolSpecification.lambda$fromSync$3((McpServerFeatures.SyncToolSpecification) this.f6334g, (McpAsyncServerExchange) this.f6333f, (McpSchema.CallToolRequest) this.f6335h);
            case 6:
                return McpStatelessServerFeatures.AsyncCompletionSpecification.lambda$fromSync$0((McpStatelessServerFeatures.SyncCompletionSpecification) this.f6334g, (McpTransportContext) this.f6333f, (McpSchema.CompleteRequest) this.f6335h);
            case 7:
                return McpStatelessServerFeatures.AsyncPromptSpecification.lambda$fromSync$0((McpStatelessServerFeatures.SyncPromptSpecification) this.f6334g, (McpTransportContext) this.f6333f, (McpSchema.GetPromptRequest) this.f6335h);
            case 8:
                return McpStatelessServerFeatures.AsyncResourceSpecification.lambda$fromSync$0((McpStatelessServerFeatures.SyncResourceSpecification) this.f6334g, (McpTransportContext) this.f6333f, (McpSchema.ReadResourceRequest) this.f6335h);
            case 9:
                return McpStatelessServerFeatures.AsyncResourceTemplateSpecification.lambda$fromSync$0((McpStatelessServerFeatures.SyncResourceTemplateSpecification) this.f6334g, (McpTransportContext) this.f6333f, (McpSchema.ReadResourceRequest) this.f6335h);
            default:
                return McpStatelessServerFeatures.AsyncToolSpecification.lambda$fromSync$0((McpStatelessServerFeatures.SyncToolSpecification) this.f6334g, (McpTransportContext) this.f6333f, (McpSchema.CallToolRequest) this.f6335h);
        }
    }
}
