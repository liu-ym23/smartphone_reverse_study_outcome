package io.modelcontextprotocol.server;

import io.modelcontextprotocol.common.McpTransportContext;
import io.modelcontextprotocol.server.McpServerFeatures;
import io.modelcontextprotocol.server.McpStatelessServerFeatures;
import io.modelcontextprotocol.spec.McpSchema;
import java.util.function.BiFunction;

/* loaded from: classes3.dex */
public final /* synthetic */ class y implements BiFunction {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f4737a;
    public final /* synthetic */ boolean b;
    public final /* synthetic */ B7.a c;

    public /* synthetic */ y(B7.a aVar, boolean z10, int i) {
        this.f4737a = i;
        this.c = aVar;
        this.b = z10;
    }

    @Override // java.util.function.BiFunction
    public final Object apply(Object obj, Object obj2) {
        switch (this.f4737a) {
            case 0:
                return McpServerFeatures.AsyncCompletionSpecification.lambda$fromSync$1((McpServerFeatures.SyncCompletionSpecification) this.c, this.b, (McpAsyncServerExchange) obj, (McpSchema.CompleteRequest) obj2);
            case 1:
                return McpServerFeatures.AsyncPromptSpecification.lambda$fromSync$1((McpServerFeatures.SyncPromptSpecification) this.c, this.b, (McpAsyncServerExchange) obj, (McpSchema.GetPromptRequest) obj2);
            case 2:
                return McpServerFeatures.AsyncResourceSpecification.lambda$fromSync$1((McpServerFeatures.SyncResourceSpecification) this.c, this.b, (McpAsyncServerExchange) obj, (McpSchema.ReadResourceRequest) obj2);
            case 3:
                return McpServerFeatures.AsyncResourceTemplateSpecification.lambda$fromSync$1((McpServerFeatures.SyncResourceTemplateSpecification) this.c, this.b, (McpAsyncServerExchange) obj, (McpSchema.ReadResourceRequest) obj2);
            case 4:
                return McpStatelessServerFeatures.AsyncCompletionSpecification.lambda$fromSync$1((McpStatelessServerFeatures.SyncCompletionSpecification) this.c, this.b, (McpTransportContext) obj, (McpSchema.CompleteRequest) obj2);
            case 5:
                return McpStatelessServerFeatures.AsyncPromptSpecification.lambda$fromSync$1((McpStatelessServerFeatures.SyncPromptSpecification) this.c, this.b, (McpTransportContext) obj, (McpSchema.GetPromptRequest) obj2);
            case 6:
                return McpStatelessServerFeatures.AsyncResourceSpecification.lambda$fromSync$1((McpStatelessServerFeatures.SyncResourceSpecification) this.c, this.b, (McpTransportContext) obj, (McpSchema.ReadResourceRequest) obj2);
            case 7:
                return McpStatelessServerFeatures.AsyncResourceTemplateSpecification.lambda$fromSync$1((McpStatelessServerFeatures.SyncResourceTemplateSpecification) this.c, this.b, (McpTransportContext) obj, (McpSchema.ReadResourceRequest) obj2);
            default:
                return McpStatelessServerFeatures.AsyncToolSpecification.lambda$fromSync$1((McpStatelessServerFeatures.SyncToolSpecification) this.c, this.b, (McpTransportContext) obj, (McpSchema.CallToolRequest) obj2);
        }
    }
}
