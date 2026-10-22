package io.modelcontextprotocol.server;

import io.modelcontextprotocol.server.McpServerFeatures;
import io.modelcontextprotocol.server.McpStatelessServerFeatures;
import java.util.function.Predicate;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final /* synthetic */ class c implements Predicate {

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ int f6249c;

    /* renamed from: f, reason: collision with root package name */
    public /* synthetic */ androidx.activity.b f6250f;

    public /* synthetic */ c(int i) {
        this.f6249c = i;
    }

    @Override // java.util.function.Predicate
    public final boolean test(Object obj) {
        int i = this.f6249c;
        androidx.activity.b bVar = this.f6250f;
        switch (i) {
            case 0:
                return McpAsyncServer.lambda$addTool$11((McpServerFeatures.AsyncToolSpecification) bVar, (McpServerFeatures.AsyncToolSpecification) obj);
            default:
                return McpStatelessAsyncServer.lambda$addTool$4((McpStatelessServerFeatures.AsyncToolSpecification) bVar, (McpStatelessServerFeatures.AsyncToolSpecification) obj);
        }
    }
}
