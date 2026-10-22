package io.modelcontextprotocol.server;

import io.modelcontextprotocol.spec.DefaultMcpTransportStream;
import io.modelcontextprotocol.spec.McpSchema;
import io.modelcontextprotocol.spec.McpServerSession;
import io.modelcontextprotocol.spec.McpStreamableServerSession;
import java.util.List;
import java.util.function.BiFunction;
import java.util.function.Function;
import reactor.core.publisher.Flux;
import reactor.util.context.ContextView;
import reactor.util.retry.Retry;
import reactor.util.retry.RetryBackoffSpec;
import reactor.util.retry.RetrySpec;

/* renamed from: io.modelcontextprotocol.server.f, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public final /* synthetic */ class C1588f implements Function {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f4706a;
    public final /* synthetic */ Object b;
    public final /* synthetic */ Object c;

    public /* synthetic */ C1588f(int i, Object obj, Object obj2) {
        this.f4706a = i;
        this.b = obj;
        this.c = obj2;
    }

    @Override // java.util.function.Function
    public final Object apply(Object obj) {
        switch (this.f4706a) {
            case 0:
                return McpAsyncServer.lambda$asyncRootsListChangedNotificationHandler$7((McpAsyncServerExchange) this.b, (McpSchema.ListRootsResult) this.c, (BiFunction) obj);
            case 1:
                return McpAsyncServer.lambda$asyncRootsListChangedNotificationHandler$9((List) this.c, (McpAsyncServerExchange) this.b, (McpSchema.ListRootsResult) obj);
            case 2:
                return ((DefaultMcpTransportStream) this.b).lambda$consumeSseStream$3((Z9.c) this.c, (ContextView) obj);
            case 3:
                return ((McpServerSession) this.b).lambda$handle$6((McpSchema.JSONRPCMessage) this.c, (ContextView) obj);
            case 4:
                return ((McpServerSession) this.b).lambda$handle$4((McpSchema.JSONRPCRequest) this.c, (Throwable) obj);
            case 5:
                return ((McpStreamableServerSession) this.b).lambda$accept$6((McpSchema.JSONRPCNotification) this.c, (ContextView) obj);
            case 6:
                return ((RetryBackoffSpec) this.b).lambda$null$4((ContextView) this.c, (Retry.RetrySignal) obj);
            case 7:
                return ((RetryBackoffSpec) this.b).lambda$generateCompanion$5((Flux) this.c, (ContextView) obj);
            case 8:
                return ((RetrySpec) this.b).lambda$generateCompanion$6((Flux) this.c, (ContextView) obj);
            default:
                return ((RetrySpec) this.b).lambda$null$5((ContextView) this.c, (Retry.RetrySignal) obj);
        }
    }

    public /* synthetic */ C1588f(McpAsyncServerExchange mcpAsyncServerExchange, List list) {
        this.f4706a = 1;
        this.c = list;
        this.b = mcpAsyncServerExchange;
    }
}
