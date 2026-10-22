package io.modelcontextprotocol.server;

import io.modelcontextprotocol.server.McpServerFeatures;
import io.modelcontextprotocol.spec.McpSchema;
import java.util.Map;
import java.util.function.BiFunction;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final /* synthetic */ class z implements BiFunction {

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ int f6338c;

    /* renamed from: f, reason: collision with root package name */
    public /* synthetic */ McpServerFeatures.SyncToolSpecification f6339f;

    /* renamed from: g, reason: collision with root package name */
    public /* synthetic */ boolean f6340g;

    public /* synthetic */ z(int i) {
        this.f6338c = i;
    }

    @Override // java.util.function.BiFunction
    public final Object apply(Object obj, Object obj2) {
        switch (this.f6338c) {
            case 0:
                return McpServerFeatures.AsyncToolSpecification.lambda$fromSync$2(this.f6339f, this.f6340g, (McpAsyncServerExchange) obj, (Map) obj2);
            default:
                return McpServerFeatures.AsyncToolSpecification.lambda$fromSync$4(this.f6339f, this.f6340g, (McpAsyncServerExchange) obj, (McpSchema.CallToolRequest) obj2);
        }
    }
}
