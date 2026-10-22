package io.modelcontextprotocol.server;

import io.modelcontextprotocol.server.McpAsyncServer;
import io.modelcontextprotocol.server.McpStatelessAsyncServer;
import io.modelcontextprotocol.spec.McpSchema;
import java.util.function.Function;

/* loaded from: classes3.dex */
public final /* synthetic */ class v implements Function {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f4734a;
    public final /* synthetic */ Object b;

    public /* synthetic */ v(Object obj, int i) {
        this.f4734a = i;
        this.b = obj;
    }

    @Override // java.util.function.Function
    public final Object apply(Object obj) {
        int i = this.f4734a;
        Object obj2 = this.b;
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
