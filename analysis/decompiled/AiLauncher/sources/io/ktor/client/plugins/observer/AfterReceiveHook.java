package io.ktor.client.plugins.observer;

import Y8.t;
import com.stepos.statsapp.v3.lib.plugin.constants.UxipConstants;
import e9.InterfaceC4014c;
import f9.C4063a;
import g9.InterfaceC4112d;
import g9.h;
import io.ktor.client.HttpClient;
import io.ktor.client.plugins.api.ClientHook;
import io.ktor.client.statement.HttpReceivePipeline;
import io.ktor.client.statement.HttpResponse;
import io.ktor.util.pipeline.PipelineContext;
import kotlin.C4849c;
import kotlin.Metadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.internal.p;
import p9.q;

@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\bÂ\u0002\u0018\u00002*\u0012&\u0012$\b\u0001\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0004\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\u0005\u0012\u0006\u0012\u0004\u0018\u00010\u00070\u00020\u0001:\u0001\u000fB\t\b\u0002¢\u0006\u0004\b\b\u0010\tJA\u0010\r\u001a\u00020\u00062\u0006\u0010\u000b\u001a\u00020\n2(\u0010\f\u001a$\b\u0001\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0004\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\u0005\u0012\u0006\u0012\u0004\u0018\u00010\u00070\u0002H\u0016¢\u0006\u0004\b\r\u0010\u000e¨\u0006\u0010"}, d2 = {"Lio/ktor/client/plugins/observer/AfterReceiveHook;", "Lio/ktor/client/plugins/api/ClientHook;", "Lkotlin/Function3;", "Lio/ktor/client/plugins/observer/AfterReceiveHook$Context;", "Lio/ktor/client/statement/HttpResponse;", "Le9/c;", "LY8/t;", "", "<init>", "()V", "Lio/ktor/client/HttpClient;", "client", "handler", W4.b.STEP_INSTALL, "(Lio/ktor/client/HttpClient;Lp9/q;)V", "Context", "ktor-client-core"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes4.dex */
final class AfterReceiveHook implements ClientHook<q<? super Context, ? super HttpResponse, ? super InterfaceC4014c<? super t>, ? extends Object>> {
    public static final AfterReceiveHook INSTANCE = new AfterReceiveHook();

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\u00020\u0001B\u001b\u0012\u0012\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00040\u0002¢\u0006\u0004\b\u0006\u0010\u0007J\u0018\u0010\t\u001a\u00020\u00032\u0006\u0010\b\u001a\u00020\u0003H\u0086@¢\u0006\u0004\b\t\u0010\nR \u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00040\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0005\u0010\u000b¨\u0006\f"}, d2 = {"Lio/ktor/client/plugins/observer/AfterReceiveHook$Context;", "", "Lio/ktor/util/pipeline/PipelineContext;", "Lio/ktor/client/statement/HttpResponse;", "LY8/t;", "context", "<init>", "(Lio/ktor/util/pipeline/PipelineContext;)V", UxipConstants.f30685x, "proceedWith", "(Lio/ktor/client/statement/HttpResponse;Le9/c;)Ljava/lang/Object;", "Lio/ktor/util/pipeline/PipelineContext;", "ktor-client-core"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class Context {
        private final PipelineContext<HttpResponse, t> context;

        public Context(PipelineContext<HttpResponse, t> context) {
            p.i(context, "context");
            this.context = context;
        }

        public final Object proceedWith(HttpResponse httpResponse, InterfaceC4014c<? super HttpResponse> interfaceC4014c) {
            return this.context.proceedWith(httpResponse, interfaceC4014c);
        }
    }

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0004\u001a\u00020\u0002*\u000e\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u0001H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"Lio/ktor/util/pipeline/PipelineContext;", "Lio/ktor/client/statement/HttpResponse;", "LY8/t;", "it", "<anonymous>", "(Lio/ktor/util/pipeline/PipelineContext;Lio/ktor/client/statement/HttpResponse;)V"}, k = 3, mv = {2, 2, 0})
    @InterfaceC4112d(c = "io.ktor.client.plugins.observer.AfterReceiveHook$install$1", f = "ResponseObserver.kt", l = {99}, m = "invokeSuspend")
    /* renamed from: io.ktor.client.plugins.observer.AfterReceiveHook$install$1, reason: invalid class name */
    public static final class AnonymousClass1 extends SuspendLambda implements q<PipelineContext<HttpResponse, t>, HttpResponse, InterfaceC4014c<? super t>, Object> {
        final /* synthetic */ q<Context, HttpResponse, InterfaceC4014c<? super t>, Object> $handler;
        private /* synthetic */ Object L$0;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        public AnonymousClass1(q<? super Context, ? super HttpResponse, ? super InterfaceC4014c<? super t>, ? extends Object> qVar, InterfaceC4014c<? super AnonymousClass1> interfaceC4014c) {
            super(3, interfaceC4014c);
            this.$handler = qVar;
        }

        @Override // p9.q
        public final Object invoke(PipelineContext<HttpResponse, t> pipelineContext, HttpResponse httpResponse, InterfaceC4014c<? super t> interfaceC4014c) {
            AnonymousClass1 anonymousClass1 = new AnonymousClass1(this.$handler, interfaceC4014c);
            anonymousClass1.L$0 = pipelineContext;
            return anonymousClass1.invokeSuspend(t.f7040a);
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Throwable {
            PipelineContext pipelineContext = (PipelineContext) this.L$0;
            Object objG = C4063a.g();
            int i10 = this.label;
            if (i10 == 0) {
                C4849c.b(obj);
                q<Context, HttpResponse, InterfaceC4014c<? super t>, Object> qVar = this.$handler;
                Context context = new Context(pipelineContext);
                Object subject = pipelineContext.getSubject();
                this.L$0 = h.a(pipelineContext);
                this.label = 1;
                if (qVar.invoke(context, subject, this) == objG) {
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

    private AfterReceiveHook() {
    }

    @Override // io.ktor.client.plugins.api.ClientHook
    public void install(HttpClient client, q<? super Context, ? super HttpResponse, ? super InterfaceC4014c<? super t>, ? extends Object> handler) {
        p.i(client, "client");
        p.i(handler, "handler");
        client.getReceivePipeline().intercept(HttpReceivePipeline.INSTANCE.getAfter(), new AnonymousClass1(handler, null));
    }
}
