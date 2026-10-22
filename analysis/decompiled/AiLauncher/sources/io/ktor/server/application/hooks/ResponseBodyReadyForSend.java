package io.ktor.server.application.hooks;

import W4.b;
import Y8.t;
import e9.InterfaceC4014c;
import f9.C4063a;
import g9.InterfaceC4112d;
import io.ktor.http.content.OutgoingContent;
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
import p9.q;
import p9.r;

@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\bÆ\u0002\u0018\u000020\u0012,\u0012*\b\u0001\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0005\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00070\u0006\u0012\u0006\u0012\u0004\u0018\u00010\b0\u00020\u0001:\u0001\u0010B\t\b\u0002¢\u0006\u0004\b\t\u0010\nJG\u0010\u000e\u001a\u00020\u00072\u0006\u0010\f\u001a\u00020\u000b2.\u0010\r\u001a*\b\u0001\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0005\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00070\u0006\u0012\u0006\u0012\u0004\u0018\u00010\b0\u0002H\u0016¢\u0006\u0004\b\u000e\u0010\u000f¨\u0006\u0011"}, d2 = {"Lio/ktor/server/application/hooks/ResponseBodyReadyForSend;", "Lio/ktor/server/application/Hook;", "Lkotlin/Function4;", "Lio/ktor/server/application/hooks/ResponseBodyReadyForSend$Context;", "Lio/ktor/server/application/ApplicationCall;", "Lio/ktor/http/content/OutgoingContent;", "Le9/c;", "LY8/t;", "", "<init>", "()V", "Lio/ktor/server/application/ApplicationCallPipeline;", "pipeline", "handler", b.STEP_INSTALL, "(Lio/ktor/server/application/ApplicationCallPipeline;Lp9/r;)V", "Context", "ktor-server-core"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class ResponseBodyReadyForSend implements Hook<r<? super Context, ? super ApplicationCall, ? super OutgoingContent, ? super InterfaceC4014c<? super t>, ? extends Object>> {
    public static final ResponseBodyReadyForSend INSTANCE = new ResponseBodyReadyForSend();

    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u001b\u0012\u0012\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u00030\u0002¢\u0006\u0004\b\u0005\u0010\u0006J\u0015\u0010\n\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\u0007¢\u0006\u0004\b\n\u0010\u000bR \u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u00030\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0004\u0010\f¨\u0006\r"}, d2 = {"Lio/ktor/server/application/hooks/ResponseBodyReadyForSend$Context;", "", "Lio/ktor/util/pipeline/PipelineContext;", "Lio/ktor/server/application/PipelineCall;", "context", "<init>", "(Lio/ktor/util/pipeline/PipelineContext;)V", "Lio/ktor/http/content/OutgoingContent;", "body", "LY8/t;", "transformBodyTo", "(Lio/ktor/http/content/OutgoingContent;)V", "Lio/ktor/util/pipeline/PipelineContext;", "ktor-server-core"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class Context {
        private final PipelineContext<Object, PipelineCall> context;

        public Context(PipelineContext<Object, PipelineCall> context) {
            p.i(context, "context");
            this.context = context;
        }

        public final void transformBodyTo(OutgoingContent body) {
            p.i(body, "body");
            this.context.setSubject(body);
        }
    }

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0005\u001a\u00020\u0004*\u000e\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u0001H\n¢\u0006\u0004\b\u0005\u0010\u0006"}, d2 = {"Lio/ktor/util/pipeline/PipelineContext;", "", "Lio/ktor/server/application/PipelineCall;", "it", "LY8/t;", "<anonymous>", "(Lio/ktor/util/pipeline/PipelineContext;Ljava/lang/Object;)V"}, k = 3, mv = {2, 1, 0})
    @InterfaceC4112d(c = "io.ktor.server.application.hooks.ResponseBodyReadyForSend$install$1", f = "CommonHooks.kt", l = {114}, m = "invokeSuspend")
    /* renamed from: io.ktor.server.application.hooks.ResponseBodyReadyForSend$install$1, reason: invalid class name */
    public static final class AnonymousClass1 extends SuspendLambda implements q<PipelineContext<Object, PipelineCall>, Object, InterfaceC4014c<? super t>, Object> {
        final /* synthetic */ r<Context, ApplicationCall, OutgoingContent, InterfaceC4014c<? super t>, Object> $handler;
        private /* synthetic */ Object L$0;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        public AnonymousClass1(r<? super Context, ? super ApplicationCall, ? super OutgoingContent, ? super InterfaceC4014c<? super t>, ? extends Object> rVar, InterfaceC4014c<? super AnonymousClass1> interfaceC4014c) {
            super(3, interfaceC4014c);
            this.$handler = rVar;
        }

        @Override // p9.q
        public final Object invoke(PipelineContext<Object, PipelineCall> pipelineContext, Object obj, InterfaceC4014c<? super t> interfaceC4014c) {
            AnonymousClass1 anonymousClass1 = new AnonymousClass1(this.$handler, interfaceC4014c);
            anonymousClass1.L$0 = pipelineContext;
            return anonymousClass1.invokeSuspend(t.f7040a);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Throwable {
            Object objG = C4063a.g();
            int i10 = this.label;
            if (i10 == 0) {
                C4849c.b(obj);
                PipelineContext pipelineContext = (PipelineContext) this.L$0;
                r<Context, ApplicationCall, OutgoingContent, InterfaceC4014c<? super t>, Object> rVar = this.$handler;
                Context context = new Context(pipelineContext);
                PipelineCall pipelineCall = (PipelineCall) pipelineContext.getContext();
                Object subject = pipelineContext.getSubject();
                p.g(subject, "null cannot be cast to non-null type io.ktor.http.content.OutgoingContent");
                this.label = 1;
                if (rVar.invoke(context, pipelineCall, (OutgoingContent) subject, this) == objG) {
                    return objG;
                }
            } else {
                if (i10 != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                C4849c.b(obj);
            }
            return t.f7040a;
        }
    }

    private ResponseBodyReadyForSend() {
    }

    @Override // io.ktor.server.application.Hook
    public void install(ApplicationCallPipeline pipeline, r<? super Context, ? super ApplicationCall, ? super OutgoingContent, ? super InterfaceC4014c<? super t>, ? extends Object> handler) {
        p.i(pipeline, "pipeline");
        p.i(handler, "handler");
        pipeline.getSendPipeline().intercept(ApplicationSendPipeline.INSTANCE.getAfter(), new AnonymousClass1(handler, null));
    }
}
