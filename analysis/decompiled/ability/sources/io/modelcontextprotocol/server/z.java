package io.modelcontextprotocol.server;

import io.modelcontextprotocol.common.McpTransportContext;
import io.modelcontextprotocol.server.McpServerFeatures;
import io.modelcontextprotocol.server.McpStatelessServerFeatures;
import io.modelcontextprotocol.spec.McpSchema;
import java.util.Map;
import java.util.concurrent.Callable;

/* loaded from: classes3.dex */
public final /* synthetic */ class z implements Callable {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f4738a;
    public final /* synthetic */ Object b;
    public final /* synthetic */ B7.a c;
    public final /* synthetic */ Object d;

    public /* synthetic */ z(B7.a aVar, Object obj, Object obj2, int i) {
        this.f4738a = i;
        this.c = aVar;
        this.b = obj;
        this.d = obj2;
    }

    @Override // java.util.concurrent.Callable
    public final Object call() {
        switch (this.f4738a) {
            case 0:
                return McpServerFeatures.AsyncCompletionSpecification.lambda$fromSync$0((McpServerFeatures.SyncCompletionSpecification) this.c, (McpAsyncServerExchange) this.b, (McpSchema.CompleteRequest) this.d);
            case 1:
                return McpServerFeatures.AsyncPromptSpecification.lambda$fromSync$0((McpServerFeatures.SyncPromptSpecification) this.c, (McpAsyncServerExchange) this.b, (McpSchema.GetPromptRequest) this.d);
            case 2:
                return McpServerFeatures.AsyncResourceSpecification.lambda$fromSync$0((McpServerFeatures.SyncResourceSpecification) this.c, (McpAsyncServerExchange) this.b, (McpSchema.ReadResourceRequest) this.d);
            case 3:
                return McpServerFeatures.AsyncResourceTemplateSpecification.lambda$fromSync$0((McpServerFeatures.SyncResourceTemplateSpecification) this.c, (McpAsyncServerExchange) this.b, (McpSchema.ReadResourceRequest) this.d);
            case 4:
                return McpServerFeatures.AsyncToolSpecification.lambda$fromSync$1((McpServerFeatures.SyncToolSpecification) this.c, (McpAsyncServerExchange) this.b, (Map) this.d);
            case 5:
                return McpServerFeatures.AsyncToolSpecification.lambda$fromSync$3((McpServerFeatures.SyncToolSpecification) this.c, (McpAsyncServerExchange) this.b, (McpSchema.CallToolRequest) this.d);
            case 6:
                return McpStatelessServerFeatures.AsyncCompletionSpecification.lambda$fromSync$0((McpStatelessServerFeatures.SyncCompletionSpecification) this.c, (McpTransportContext) this.b, (McpSchema.CompleteRequest) this.d);
            case 7:
                return McpStatelessServerFeatures.AsyncPromptSpecification.lambda$fromSync$0((McpStatelessServerFeatures.SyncPromptSpecification) this.c, (McpTransportContext) this.b, (McpSchema.GetPromptRequest) this.d);
            case 8:
                return McpStatelessServerFeatures.AsyncResourceSpecification.lambda$fromSync$0((McpStatelessServerFeatures.SyncResourceSpecification) this.c, (McpTransportContext) this.b, (McpSchema.ReadResourceRequest) this.d);
            case 9:
                return McpStatelessServerFeatures.AsyncResourceTemplateSpecification.lambda$fromSync$0((McpStatelessServerFeatures.SyncResourceTemplateSpecification) this.c, (McpTransportContext) this.b, (McpSchema.ReadResourceRequest) this.d);
            default:
                return McpStatelessServerFeatures.AsyncToolSpecification.lambda$fromSync$0((McpStatelessServerFeatures.SyncToolSpecification) this.c, (McpTransportContext) this.b, (McpSchema.CallToolRequest) this.d);
        }
    }
}
