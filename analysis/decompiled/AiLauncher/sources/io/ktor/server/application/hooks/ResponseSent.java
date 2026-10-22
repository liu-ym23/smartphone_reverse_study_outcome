package io.ktor.server.application.hooks;

import W4.b;
import Y8.t;
import e9.InterfaceC4014c;
import f9.C4063a;
import g9.InterfaceC4112d;
import io.ktor.server.application.ApplicationCall;
import io.ktor.server.application.ApplicationCallPipeline;
import io.ktor.server.application.Hook;
import io.ktor.server.application.PipelineCall;
import io.ktor.server.response.ApplicationSendPipeline;
import io.ktor.util.pipeline.PipelineContext;
import kotlin.C4849c;
import kotlin.Metadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.internal.p;
import p9.InterfaceC5074l;
import p9.q;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\bÆ\u0002\u0018\u00002\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00040\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0005\u0010\u0006J+\u0010\n\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u00072\u0012\u0010\t\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00040\u0002H\u0016¢\u0006\u0004\b\n\u0010\u000b¨\u0006\f"}, d2 = {"Lio/ktor/server/application/hooks/ResponseSent;", "Lio/ktor/server/application/Hook;", "Lkotlin/Function1;", "Lio/ktor/server/application/ApplicationCall;", "LY8/t;", "<init>", "()V", "Lio/ktor/server/application/ApplicationCallPipeline;", "pipeline", "handler", b.STEP_INSTALL, "(Lio/ktor/server/application/ApplicationCallPipeline;Lp9/l;)V", "ktor-server-core"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class ResponseSent implements Hook<InterfaceC5074l<? super ApplicationCall, ? extends t>> {
    public static final ResponseSent INSTANCE = new ResponseSent();

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0005\u001a\u00020\u0004*\u000e\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u0001H\n¢\u0006\u0004\b\u0005\u0010\u0006"}, d2 = {"Lio/ktor/util/pipeline/PipelineContext;", "", "Lio/ktor/server/application/PipelineCall;", "it", "LY8/t;", "<anonymous>", "(Lio/ktor/util/pipeline/PipelineContext;Ljava/lang/Object;)V"}, k = 3, mv = {2, 1, 0})
    @InterfaceC4112d(c = "io.ktor.server.application.hooks.ResponseSent$install$1", f = "CommonHooks.kt", l = {128}, m = "invokeSuspend")
    /* renamed from: io.ktor.server.application.hooks.ResponseSent$install$1, reason: invalid class name */
    public static final class AnonymousClass1 extends SuspendLambda implements q<PipelineContext<Object, PipelineCall>, Object, InterfaceC4014c<? super t>, Object> {
        final /* synthetic */ InterfaceC5074l<ApplicationCall, t> $handler;
        private /* synthetic */ Object L$0;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        public AnonymousClass1(InterfaceC5074l<? super ApplicationCall, t> interfaceC5074l, InterfaceC4014c<? super AnonymousClass1> interfaceC4014c) {
            super(3, interfaceC4014c);
            this.$handler = interfaceC5074l;
        }

        @Override // p9.q
        public final Object invoke(PipelineContext<Object, PipelineCall> pipelineContext, Object obj, InterfaceC4014c<? super t> interfaceC4014c) {
            AnonymousClass1 anonymousClass1 = new AnonymousClass1(this.$handler, interfaceC4014c);
            anonymousClass1.L$0 = pipelineContext;
            return anonymousClass1.invokeSuspend(t.f7040a);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Throwable {
            PipelineContext pipelineContext;
            Object objG = C4063a.g();
            int i10 = this.label;
            if (i10 == 0) {
                C4849c.b(obj);
                PipelineContext pipelineContext2 = (PipelineContext) this.L$0;
                this.L$0 = pipelineContext2;
                this.label = 1;
                if (pipelineContext2.proceed(this) == objG) {
                    return objG;
                }
                pipelineContext = pipelineContext2;
            } else {
                if (i10 != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                pipelineContext = (PipelineContext) this.L$0;
                C4849c.b(obj);
            }
            this.$handler.invoke((PipelineCall) pipelineContext.getContext());
            return t.f7040a;
        }
    }

    private ResponseSent() {
    }

    @Override // io.ktor.server.application.Hook
    public /* bridge */ /* synthetic */ void install(ApplicationCallPipeline applicationCallPipeline, InterfaceC5074l<? super ApplicationCall, ? extends t> interfaceC5074l) {
        install2(applicationCallPipeline, (InterfaceC5074l<? super ApplicationCall, t>) interfaceC5074l);
    }

    /* renamed from: install, reason: avoid collision after fix types in other method */
    public void install2(ApplicationCallPipeline pipeline, InterfaceC5074l<? super ApplicationCall, t> handler) {
        p.i(pipeline, "pipeline");
        p.i(handler, "handler");
        pipeline.getSendPipeline().intercept(ApplicationSendPipeline.INSTANCE.getEngine(), new AnonymousClass1(handler, null));
    }
}
