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

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final /* synthetic */ class e implements Function {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f6260a;

    /* renamed from: b, reason: collision with root package name */
    public /* synthetic */ Object f6261b;

    /* renamed from: c, reason: collision with root package name */
    public /* synthetic */ Object f6262c;

    public /* synthetic */ e(int i) {
        this.f6260a = i;
    }

    @Override // java.util.function.Function
    public final Object apply(Object obj) {
        switch (this.f6260a) {
            case 0:
                return McpAsyncServer.lambda$asyncRootsListChangedNotificationHandler$7((McpAsyncServerExchange) this.f6261b, (McpSchema.ListRootsResult) this.f6262c, (BiFunction) obj);
            case 1:
                return McpAsyncServer.lambda$asyncRootsListChangedNotificationHandler$9((List) this.f6262c, (McpAsyncServerExchange) this.f6261b, (McpSchema.ListRootsResult) obj);
            case 2:
                return ((DefaultMcpTransportStream) this.f6261b).lambda$consumeSseStream$3((qd.c) this.f6262c, (ContextView) obj);
            case 3:
                return ((McpServerSession) this.f6261b).lambda$handle$6((McpSchema.JSONRPCMessage) this.f6262c, (ContextView) obj);
            case 4:
                return ((McpServerSession) this.f6261b).lambda$handle$4((McpSchema.JSONRPCRequest) this.f6262c, (Throwable) obj);
            case 5:
                return ((McpStreamableServerSession) this.f6261b).lambda$accept$6((McpSchema.JSONRPCNotification) this.f6262c, (ContextView) obj);
            case 6:
                return ((RetryBackoffSpec) this.f6261b).lambda$null$4((ContextView) this.f6262c, (Retry.RetrySignal) obj);
            case 7:
                return ((RetryBackoffSpec) this.f6261b).lambda$generateCompanion$5((Flux) this.f6262c, (ContextView) obj);
            case 8:
                return ((RetrySpec) this.f6261b).lambda$generateCompanion$6((Flux) this.f6262c, (ContextView) obj);
            default:
                return ((RetrySpec) this.f6261b).lambda$null$5((ContextView) this.f6262c, (Retry.RetrySignal) obj);
        }
    }
}
