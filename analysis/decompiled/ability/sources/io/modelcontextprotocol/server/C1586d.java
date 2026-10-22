package io.modelcontextprotocol.server;

import io.modelcontextprotocol.server.McpServerFeatures;
import io.modelcontextprotocol.server.McpStatelessServerFeatures;
import io.modelcontextprotocol.spec.McpClientSession;
import io.modelcontextprotocol.spec.McpSchema;
import io.modelcontextprotocol.spec.McpStreamableServerSession;
import java.util.function.Supplier;

/* renamed from: io.modelcontextprotocol.server.d, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public final /* synthetic */ class C1586d implements Supplier {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f4704a;
    public final /* synthetic */ Object b;
    public final /* synthetic */ Object c;

    public /* synthetic */ C1586d(int i, Object obj, Object obj2) {
        this.f4704a = i;
        this.b = obj;
        this.c = obj2;
    }

    @Override // java.util.function.Supplier
    public final Object get() {
        switch (this.f4704a) {
            case 0:
                return ((McpAsyncServer) this.b).lambda$addResource$19((McpServerFeatures.AsyncResourceSpecification) this.c);
            case 1:
                return ((McpAsyncServer) this.b).lambda$addResourceTemplate$21((McpServerFeatures.AsyncResourceTemplateSpecification) this.c);
            case 2:
                return ((McpAsyncServer) this.b).lambda$addTool$12((McpServerFeatures.AsyncToolSpecification) this.c);
            case 3:
                return ((McpAsyncServer) this.b).lambda$addPrompt$32((McpServerFeatures.AsyncPromptSpecification) this.c);
            case 4:
                return ((McpAsyncServer) this.b).lambda$asyncInitializeRequestHandler$5((McpSchema.InitializeRequest) this.c);
            case 5:
                return ((McpAsyncServerExchange) this.b).lambda$loggingNotification$3((McpSchema.LoggingMessageNotification) this.c);
            case 6:
                return ((McpStatelessAsyncServer) this.b).lambda$asyncInitializeRequestHandler$1(this.c);
            case 7:
                return ((McpStatelessAsyncServer) this.b).lambda$addPrompt$24((McpStatelessServerFeatures.AsyncPromptSpecification) this.c);
            case 8:
                return ((McpStatelessAsyncServer) this.b).lambda$addResource$11((McpStatelessServerFeatures.AsyncResourceSpecification) this.c);
            case 9:
                return ((McpStatelessAsyncServer) this.b).lambda$addResourceTemplate$13((McpStatelessServerFeatures.AsyncResourceTemplateSpecification) this.c);
            case 10:
                return ((McpStatelessAsyncServer) this.b).lambda$addTool$5((McpStatelessServerFeatures.AsyncToolSpecification) this.c);
            case 11:
                return ((McpClientSession) this.b).lambda$handleIncomingNotification$7((McpSchema.JSONRPCNotification) this.c);
            case 12:
                return ((McpClientSession) this.b).lambda$handleIncomingRequest$6((McpSchema.JSONRPCRequest) this.c);
            default:
                return ((McpStreamableServerSession) this.b).lambda$accept$7((McpSchema.JSONRPCResponse) this.c);
        }
    }
}
