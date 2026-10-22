package io.modelcontextprotocol.server;

import io.modelcontextprotocol.server.McpAsyncServer;
import io.modelcontextprotocol.server.McpStatelessAsyncServer;
import io.modelcontextprotocol.spec.McpSchema;
import java.util.function.Function;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final /* synthetic */ class t implements Function {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f6290a;

    /* renamed from: b, reason: collision with root package name */
    public /* synthetic */ Object f6291b;

    public /* synthetic */ t(int i) {
        this.f6290a = i;
    }

    @Override // java.util.function.Function
    public final Object apply(Object obj) {
        int i = this.f6290a;
        Object obj2 = this.f6291b;
        switch (i) {
            case 0:
                return ((McpAsyncServer.StructuredOutputCallToolHandler) obj2).lambda$apply$0((McpSchema.CallToolResult) obj);
            case 1:
                return ((McpStatelessAsyncServer.StructuredOutputCallToolHandler) obj2).lambda$apply$0((McpSchema.CallToolResult) obj);
            default:
                return ((McpAsyncServerExchange) obj2).lambda$listRoots$0((McpSchema.ListRootsResult) obj);
        }
    }
}
