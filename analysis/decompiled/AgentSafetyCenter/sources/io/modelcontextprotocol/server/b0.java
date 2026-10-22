package io.modelcontextprotocol.server;

import io.modelcontextprotocol.common.McpTransportContext;
import io.modelcontextprotocol.server.McpStatelessServerFeatures;
import io.modelcontextprotocol.spec.McpSchema;
import java.util.function.Function;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final /* synthetic */ class b0 implements Function {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f6246a;

    /* renamed from: b, reason: collision with root package name */
    public /* synthetic */ McpTransportContext f6247b;

    /* renamed from: c, reason: collision with root package name */
    public /* synthetic */ McpSchema.ReadResourceRequest f6248c;

    public /* synthetic */ b0(int i) {
        this.f6246a = i;
    }

    @Override // java.util.function.Function
    public final Object apply(Object obj) {
        switch (this.f6246a) {
            case 0:
                return McpStatelessAsyncServer.lambda$resourcesReadRequestHandler$17(this.f6247b, this.f6248c, (McpStatelessServerFeatures.AsyncResourceSpecification) obj);
            default:
                return McpStatelessAsyncServer.lambda$resourcesReadRequestHandler$18(this.f6247b, this.f6248c, (McpStatelessServerFeatures.AsyncResourceTemplateSpecification) obj);
        }
    }
}
