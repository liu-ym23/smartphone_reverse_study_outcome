package io.modelcontextprotocol.server;

import io.modelcontextprotocol.server.McpServerFeatures;
import io.modelcontextprotocol.spec.McpSchema;
import java.util.function.BiFunction;
import java.util.function.Supplier;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final /* synthetic */ class i implements Supplier {

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ int f6272c;

    /* renamed from: f, reason: collision with root package name */
    public /* synthetic */ McpAsyncServerExchange f6273f;

    /* renamed from: g, reason: collision with root package name */
    public /* synthetic */ Object f6274g;

    /* renamed from: h, reason: collision with root package name */
    public /* synthetic */ Object f6275h;

    public /* synthetic */ i(int i) {
        this.f6272c = i;
    }

    @Override // java.util.function.Supplier
    public final Object get() {
        switch (this.f6272c) {
            case 0:
                return ((McpAsyncServer) this.f6274g).lambda$setLoggerRequestHandler$37(this.f6275h, this.f6273f);
            case 1:
                return McpAsyncServer.lambda$promptsGetRequestHandler$35((McpServerFeatures.AsyncPromptSpecification) this.f6274g, this.f6273f, (McpSchema.GetPromptRequest) this.f6275h);
            case 2:
                return McpAsyncServer.lambda$asyncRootsListChangedNotificationHandler$6((BiFunction) this.f6274g, this.f6273f, (McpSchema.ListRootsResult) this.f6275h);
            default:
                return McpAsyncServer.lambda$completionCompleteRequestHandler$40((McpServerFeatures.AsyncCompletionSpecification) this.f6274g, this.f6273f, (McpSchema.CompleteRequest) this.f6275h);
        }
    }
}
