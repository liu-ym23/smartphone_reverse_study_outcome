package io.modelcontextprotocol.kotlin.sdk.server;

import e9.InterfaceC4014c;
import f9.C4063a;
import g9.InterfaceC4112d;
import io.ktor.server.routing.RoutingContext;
import io.ktor.util.collections.ConcurrentMap;
import kotlin.C4849c;
import kotlin.Metadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lio/ktor/server/routing/RoutingContext;", "LY8/t;", "<anonymous>", "(Lio/ktor/server/routing/RoutingContext;)V"}, k = 3, mv = {2, 2, 0})
@InterfaceC4112d(c = "io.modelcontextprotocol.kotlin.sdk.server.KtorServerKt$mcp$4$2", f = "KtorServer.kt", l = {62}, m = "invokeSuspend")
/* loaded from: classes4.dex */
public final class KtorServerKt$mcp$4$2 extends SuspendLambda implements p9.p<RoutingContext, InterfaceC4014c<? super Y8.t>, Object> {
    final /* synthetic */ ConcurrentMap<String, SseServerTransport> $transports;
    private /* synthetic */ Object L$0;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public KtorServerKt$mcp$4$2(ConcurrentMap<String, SseServerTransport> concurrentMap, InterfaceC4014c<? super KtorServerKt$mcp$4$2> interfaceC4014c) {
        super(2, interfaceC4014c);
        this.$transports = concurrentMap;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final InterfaceC4014c<Y8.t> create(Object obj, InterfaceC4014c<?> interfaceC4014c) {
        KtorServerKt$mcp$4$2 ktorServerKt$mcp$4$2 = new KtorServerKt$mcp$4$2(this.$transports, interfaceC4014c);
        ktorServerKt$mcp$4$2.L$0 = obj;
        return ktorServerKt$mcp$4$2;
    }

    @Override // p9.p
    public final Object invoke(RoutingContext routingContext, InterfaceC4014c<? super Y8.t> interfaceC4014c) {
        return ((KtorServerKt$mcp$4$2) create(routingContext, interfaceC4014c)).invokeSuspend(Y8.t.f7040a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        RoutingContext routingContext = (RoutingContext) this.L$0;
        Object objG = C4063a.g();
        int i10 = this.label;
        if (i10 == 0) {
            C4849c.b(obj);
            ConcurrentMap<String, SseServerTransport> concurrentMap = this.$transports;
            this.L$0 = g9.h.a(routingContext);
            this.label = 1;
            if (KtorServerKt.mcpPostEndpoint(routingContext, concurrentMap, this) == objG) {
                return objG;
            }
        } else {
            if (i10 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            C4849c.b(obj);
        }
        return Y8.t.f7040a;
    }
}
