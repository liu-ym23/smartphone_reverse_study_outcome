package io.ktor.client.plugins;

import e9.InterfaceC4014c;
import f9.C4063a;
import g9.InterfaceC4112d;
import io.ktor.client.HttpClient;
import io.ktor.client.plugins.api.ClientHook;
import io.ktor.client.request.HttpRequestBuilder;
import io.ktor.client.request.HttpRequestPipeline;
import io.ktor.util.pipeline.PipelineContext;
import kotlin.C4849c;
import kotlin.Metadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.internal.AdaptedFunctionReference;
import p9.InterfaceC5074l;

@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\bÆ\u0002\u0018\u00002@\u0012<\u0012:\b\u0001\u0012\u0004\u0012\u00020\u0003\u0012\u001a\u0012\u0018\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\u0005\u0012\u0006\u0012\u0004\u0018\u00010\u00070\u0004\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\u0005\u0012\u0006\u0012\u0004\u0018\u00010\u00070\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\b\u0010\tJW\u0010\r\u001a\u00020\u00062\u0006\u0010\u000b\u001a\u00020\n2>\u0010\f\u001a:\b\u0001\u0012\u0004\u0012\u00020\u0003\u0012\u001a\u0012\u0018\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\u0005\u0012\u0006\u0012\u0004\u0018\u00010\u00070\u0004\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\u0005\u0012\u0006\u0012\u0004\u0018\u00010\u00070\u0002H\u0016¢\u0006\u0004\b\r\u0010\u000e¨\u0006\u000f"}, d2 = {"Lio/ktor/client/plugins/SetupRequestContext;", "Lio/ktor/client/plugins/api/ClientHook;", "Lkotlin/Function3;", "Lio/ktor/client/request/HttpRequestBuilder;", "Lkotlin/Function1;", "Le9/c;", "LY8/t;", "", "<init>", "()V", "Lio/ktor/client/HttpClient;", "client", "handler", W4.b.STEP_INSTALL, "(Lio/ktor/client/HttpClient;Lp9/q;)V", "ktor-client-core"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class SetupRequestContext implements ClientHook<p9.q<? super HttpRequestBuilder, ? super InterfaceC5074l<? super InterfaceC4014c<? super Y8.t>, ? extends Object>, ? super InterfaceC4014c<? super Y8.t>, ? extends Object>> {
    public static final SetupRequestContext INSTANCE = new SetupRequestContext();

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0005\u001a\u00020\u0004*\u000e\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u0001H\n¢\u0006\u0004\b\u0005\u0010\u0006"}, d2 = {"Lio/ktor/util/pipeline/PipelineContext;", "", "Lio/ktor/client/request/HttpRequestBuilder;", "it", "LY8/t;", "<anonymous>", "(Lio/ktor/util/pipeline/PipelineContext;Ljava/lang/Object;)V"}, k = 3, mv = {2, 2, 0})
    @InterfaceC4112d(c = "io.ktor.client.plugins.SetupRequestContext$install$1", f = "HttpRequestLifecycle.kt", l = {42}, m = "invokeSuspend")
    /* renamed from: io.ktor.client.plugins.SetupRequestContext$install$1, reason: invalid class name */
    public static final class AnonymousClass1 extends SuspendLambda implements p9.q<PipelineContext<Object, HttpRequestBuilder>, Object, InterfaceC4014c<? super Y8.t>, Object> {
        final /* synthetic */ p9.q<HttpRequestBuilder, InterfaceC5074l<? super InterfaceC4014c<? super Y8.t>, ? extends Object>, InterfaceC4014c<? super Y8.t>, Object> $handler;
        private /* synthetic */ Object L$0;
        int label;

        @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
        /* renamed from: io.ktor.client.plugins.SetupRequestContext$install$1$1, reason: invalid class name and collision with other inner class name */
        public static final /* synthetic */ class C04101 extends AdaptedFunctionReference implements InterfaceC5074l<InterfaceC4014c<? super Y8.t>, Object> {
            public C04101(Object obj) {
                super(1, obj, PipelineContext.class, "proceed", "proceed(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", 8);
            }

            @Override // p9.InterfaceC5074l
            public final Object invoke(InterfaceC4014c<? super Y8.t> interfaceC4014c) {
                return AnonymousClass1.invokeSuspend$proceed((PipelineContext) this.receiver, interfaceC4014c);
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        public AnonymousClass1(p9.q<? super HttpRequestBuilder, ? super InterfaceC5074l<? super InterfaceC4014c<? super Y8.t>, ? extends Object>, ? super InterfaceC4014c<? super Y8.t>, ? extends Object> qVar, InterfaceC4014c<? super AnonymousClass1> interfaceC4014c) {
            super(3, interfaceC4014c);
            this.$handler = qVar;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final /* synthetic */ Object invokeSuspend$proceed(PipelineContext pipelineContext, InterfaceC4014c interfaceC4014c) {
            Object objProceed = pipelineContext.proceed(interfaceC4014c);
            return objProceed == C4063a.g() ? objProceed : Y8.t.f7040a;
        }

        @Override // p9.q
        public final Object invoke(PipelineContext<Object, HttpRequestBuilder> pipelineContext, Object obj, InterfaceC4014c<? super Y8.t> interfaceC4014c) {
            AnonymousClass1 anonymousClass1 = new AnonymousClass1(this.$handler, interfaceC4014c);
            anonymousClass1.L$0 = pipelineContext;
            return anonymousClass1.invokeSuspend(Y8.t.f7040a);
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Throwable {
            PipelineContext pipelineContext = (PipelineContext) this.L$0;
            Object objG = C4063a.g();
            int i10 = this.label;
            if (i10 == 0) {
                C4849c.b(obj);
                p9.q<HttpRequestBuilder, InterfaceC5074l<? super InterfaceC4014c<? super Y8.t>, ? extends Object>, InterfaceC4014c<? super Y8.t>, Object> qVar = this.$handler;
                Object context = pipelineContext.getContext();
                C04101 c04101 = new C04101(pipelineContext);
                this.L$0 = g9.h.a(pipelineContext);
                this.label = 1;
                if (qVar.invoke(context, c04101, this) == objG) {
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

    private SetupRequestContext() {
    }

    @Override // io.ktor.client.plugins.api.ClientHook
    public void install(HttpClient client, p9.q<? super HttpRequestBuilder, ? super InterfaceC5074l<? super InterfaceC4014c<? super Y8.t>, ? extends Object>, ? super InterfaceC4014c<? super Y8.t>, ? extends Object> handler) {
        kotlin.jvm.internal.p.i(client, "client");
        kotlin.jvm.internal.p.i(handler, "handler");
        client.getRequestPipeline().intercept(HttpRequestPipeline.INSTANCE.getBefore(), new AnonymousClass1(handler, null));
    }
}
