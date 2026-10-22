package io.ktor.server.routing;

import e9.InterfaceC4014c;
import f9.C4063a;
import g9.InterfaceC4112d;
import io.ktor.server.application.PipelineCall;
import io.ktor.server.application.PipelineCallKt;
import io.ktor.util.pipeline.PipelineContext;
import java.util.List;
import kotlin.C4849c;
import kotlin.Metadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;

@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0004\u001a\u00020\u0001*\u000e\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u0001H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"Lio/ktor/util/pipeline/PipelineContext;", "LY8/t;", "Lio/ktor/server/application/PipelineCall;", "it", "<anonymous>", "(Lio/ktor/util/pipeline/PipelineContext;V)V"}, k = 3, mv = {2, 1, 0})
@InterfaceC4112d(c = "io.ktor.server.routing.RoutingNode$buildPipeline$1$1", f = "RoutingNode.kt", l = {126}, m = "invokeSuspend")
/* loaded from: classes4.dex */
public final class RoutingNode$buildPipeline$1$1 extends SuspendLambda implements p9.q<PipelineContext<Y8.t, PipelineCall>, Y8.t, InterfaceC4014c<? super Y8.t>, Object> {
    final /* synthetic */ List<p9.p<RoutingContext, InterfaceC4014c<? super Y8.t>, Object>> $handlers;
    final /* synthetic */ int $index;
    private /* synthetic */ Object L$0;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public RoutingNode$buildPipeline$1$1(List<p9.p<RoutingContext, InterfaceC4014c<? super Y8.t>, Object>> list, int i10, InterfaceC4014c<? super RoutingNode$buildPipeline$1$1> interfaceC4014c) {
        super(3, interfaceC4014c);
        this.$handlers = list;
        this.$index = i10;
    }

    @Override // p9.q
    public final Object invoke(PipelineContext<Y8.t, PipelineCall> pipelineContext, Y8.t tVar, InterfaceC4014c<? super Y8.t> interfaceC4014c) {
        RoutingNode$buildPipeline$1$1 routingNode$buildPipeline$1$1 = new RoutingNode$buildPipeline$1$1(this.$handlers, this.$index, interfaceC4014c);
        routingNode$buildPipeline$1$1.L$0 = pipelineContext;
        return routingNode$buildPipeline$1$1.invokeSuspend(Y8.t.f7040a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        Object objG = C4063a.g();
        int i10 = this.label;
        if (i10 == 0) {
            C4849c.b(obj);
            PipelineCall pipelineCall = (PipelineCall) ((PipelineContext) this.L$0).getContext();
            kotlin.jvm.internal.p.g(pipelineCall, "null cannot be cast to non-null type io.ktor.server.routing.RoutingPipelineCall");
            RoutingApplicationCall routingApplicationCall = (RoutingApplicationCall) pipelineCall;
            RoutingContext routingContext = new RoutingContext(new RoutingCall(routingApplicationCall));
            if (PipelineCallKt.isHandled(routingApplicationCall)) {
                return Y8.t.f7040a;
            }
            p9.p<RoutingContext, InterfaceC4014c<? super Y8.t>, Object> pVar = this.$handlers.get(this.$index);
            this.label = 1;
            if (pVar.invoke(routingContext, this) == objG) {
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
