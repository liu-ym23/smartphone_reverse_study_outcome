package io.modelcontextprotocol.server;

import io.modelcontextprotocol.server.McpServerFeatures;
import io.modelcontextprotocol.spec.McpSchema;
import java.util.function.Function;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final /* synthetic */ class g implements Function {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f6267a;

    /* renamed from: b, reason: collision with root package name */
    public /* synthetic */ McpAsyncServerExchange f6268b;

    /* renamed from: c, reason: collision with root package name */
    public /* synthetic */ McpSchema.ReadResourceRequest f6269c;

    public /* synthetic */ g(int i) {
        this.f6267a = i;
    }

    @Override // java.util.function.Function
    public final Object apply(Object obj) {
        switch (this.f6267a) {
            case 0:
                return McpAsyncServer.lambda$resourcesReadRequestHandler$25(this.f6268b, this.f6269c, (McpServerFeatures.AsyncResourceSpecification) obj);
            default:
                return McpAsyncServer.lambda$resourcesReadRequestHandler$26(this.f6268b, this.f6269c, (McpServerFeatures.AsyncResourceTemplateSpecification) obj);
        }
    }
}
