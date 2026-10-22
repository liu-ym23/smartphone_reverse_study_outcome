package io.ktor.server.engine;

import e9.InterfaceC4014c;
import f9.C4063a;
import g9.InterfaceC4112d;
import io.ktor.http.content.OutgoingContent;
import io.ktor.server.application.PipelineCall;
import io.ktor.server.application.PipelineCallKt;
import io.ktor.server.response.PipelineResponse;
import io.ktor.util.pipeline.PipelineContext;
import kotlin.C4849c;
import kotlin.Metadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;

@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0005\u001a\u00020\u0004*\u000e\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u0001H\n¢\u0006\u0004\b\u0005\u0010\u0006"}, d2 = {"Lio/ktor/util/pipeline/PipelineContext;", "", "Lio/ktor/server/application/PipelineCall;", "body", "LY8/t;", "<anonymous>", "(Lio/ktor/util/pipeline/PipelineContext;Ljava/lang/Object;)V"}, k = 3, mv = {2, 1, 0})
@InterfaceC4112d(c = "io.ktor.server.engine.BaseApplicationResponse$Companion$setupSendPipeline$1", f = "BaseApplicationResponse.kt", l = {341}, m = "invokeSuspend")
/* loaded from: classes4.dex */
public final class BaseApplicationResponse$Companion$setupSendPipeline$1 extends SuspendLambda implements p9.q<PipelineContext<Object, PipelineCall>, Object, InterfaceC4014c<? super Y8.t>, Object> {
    private /* synthetic */ Object L$0;
    /* synthetic */ Object L$1;
    int label;

    public BaseApplicationResponse$Companion$setupSendPipeline$1(InterfaceC4014c<? super BaseApplicationResponse$Companion$setupSendPipeline$1> interfaceC4014c) {
        super(3, interfaceC4014c);
    }

    @Override // p9.q
    public final Object invoke(PipelineContext<Object, PipelineCall> pipelineContext, Object obj, InterfaceC4014c<? super Y8.t> interfaceC4014c) {
        BaseApplicationResponse$Companion$setupSendPipeline$1 baseApplicationResponse$Companion$setupSendPipeline$1 = new BaseApplicationResponse$Companion$setupSendPipeline$1(interfaceC4014c);
        baseApplicationResponse$Companion$setupSendPipeline$1.L$0 = pipelineContext;
        baseApplicationResponse$Companion$setupSendPipeline$1.L$1 = obj;
        return baseApplicationResponse$Companion$setupSendPipeline$1.invokeSuspend(Y8.t.f7040a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        Object objG = C4063a.g();
        int i10 = this.label;
        if (i10 == 0) {
            C4849c.b(obj);
            PipelineContext pipelineContext = (PipelineContext) this.L$0;
            Object obj2 = this.L$1;
            if (PipelineCallKt.isHandled((PipelineCall) pipelineContext.getContext())) {
                return Y8.t.f7040a;
            }
            if (!(obj2 instanceof OutgoingContent)) {
                throw new IllegalArgumentException("Response pipeline couldn't transform '" + kotlin.jvm.internal.t.b(obj2.getClass()) + "' to the OutgoingContent");
            }
            PipelineResponse response = ((PipelineCall) pipelineContext.getContext()).getResponse();
            BaseApplicationResponse baseApplicationResponse = response instanceof BaseApplicationResponse ? (BaseApplicationResponse) response : null;
            if (baseApplicationResponse == null) {
                baseApplicationResponse = (BaseApplicationResponse) ((PipelineCall) pipelineContext.getContext()).getAttributes().get(BaseApplicationResponse.INSTANCE.getEngineResponseAttributeKey());
            }
            this.L$0 = null;
            this.label = 1;
            if (baseApplicationResponse.respondOutgoingContent((OutgoingContent) obj2, this) == objG) {
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
