package io.ktor.client.plugins.api;

import Y8.t;
import e9.InterfaceC4014c;
import f9.C4063a;
import g9.InterfaceC4112d;
import g9.h;
import io.ktor.client.HttpClient;
import io.ktor.client.request.HttpRequestBuilder;
import io.ktor.client.request.HttpSendPipeline;
import io.ktor.http.content.OutgoingContent;
import io.ktor.util.pipeline.PipelineContext;
import kotlin.C4849c;
import kotlin.Metadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.internal.p;
import p9.q;

@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\bÆ\u0002\u0018\u00002*\u0012&\u0012$\b\u0001\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0004\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\u0005\u0012\u0006\u0012\u0004\u0018\u00010\u00070\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\b\u0010\tJA\u0010\r\u001a\u00020\u00062\u0006\u0010\u000b\u001a\u00020\n2(\u0010\f\u001a$\b\u0001\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0004\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\u0005\u0012\u0006\u0012\u0004\u0018\u00010\u00070\u0002H\u0016¢\u0006\u0004\b\r\u0010\u000e¨\u0006\u000f"}, d2 = {"Lio/ktor/client/plugins/api/SendingRequest;", "Lio/ktor/client/plugins/api/ClientHook;", "Lkotlin/Function3;", "Lio/ktor/client/request/HttpRequestBuilder;", "Lio/ktor/http/content/OutgoingContent;", "Le9/c;", "LY8/t;", "", "<init>", "()V", "Lio/ktor/client/HttpClient;", "client", "handler", W4.b.STEP_INSTALL, "(Lio/ktor/client/HttpClient;Lp9/q;)V", "ktor-client-core"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class SendingRequest implements ClientHook<q<? super HttpRequestBuilder, ? super OutgoingContent, ? super InterfaceC4014c<? super t>, ? extends Object>> {
    public static final SendingRequest INSTANCE = new SendingRequest();

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0005\u001a\u00020\u0004*\u000e\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u0001H\n¢\u0006\u0004\b\u0005\u0010\u0006"}, d2 = {"Lio/ktor/util/pipeline/PipelineContext;", "", "Lio/ktor/client/request/HttpRequestBuilder;", "it", "LY8/t;", "<anonymous>", "(Lio/ktor/util/pipeline/PipelineContext;Ljava/lang/Object;)V"}, k = 3, mv = {2, 2, 0})
    @InterfaceC4112d(c = "io.ktor.client.plugins.api.SendingRequest$install$1", f = "CommonHooks.kt", l = {73}, m = "invokeSuspend")
    /* renamed from: io.ktor.client.plugins.api.SendingRequest$install$1, reason: invalid class name */
    public static final class AnonymousClass1 extends SuspendLambda implements q<PipelineContext<Object, HttpRequestBuilder>, Object, InterfaceC4014c<? super t>, Object> {
        final /* synthetic */ q<HttpRequestBuilder, OutgoingContent, InterfaceC4014c<? super t>, Object> $handler;
        private /* synthetic */ Object L$0;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        public AnonymousClass1(q<? super HttpRequestBuilder, ? super OutgoingContent, ? super InterfaceC4014c<? super t>, ? extends Object> qVar, InterfaceC4014c<? super AnonymousClass1> interfaceC4014c) {
            super(3, interfaceC4014c);
            this.$handler = qVar;
        }

        @Override // p9.q
        public final Object invoke(PipelineContext<Object, HttpRequestBuilder> pipelineContext, Object obj, InterfaceC4014c<? super t> interfaceC4014c) {
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
                q<HttpRequestBuilder, OutgoingContent, InterfaceC4014c<? super t>, Object> qVar = this.$handler;
                Object context = pipelineContext.getContext();
                Object subject = pipelineContext.getSubject();
                p.g(subject, "null cannot be cast to non-null type io.ktor.http.content.OutgoingContent");
                this.L$0 = h.a(pipelineContext);
                this.label = 1;
                if (qVar.invoke(context, (OutgoingContent) subject, this) == objG) {
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

    private SendingRequest() {
    }

    @Override // io.ktor.client.plugins.api.ClientHook
    public void install(HttpClient client, q<? super HttpRequestBuilder, ? super OutgoingContent, ? super InterfaceC4014c<? super t>, ? extends Object> handler) {
        p.i(client, "client");
        p.i(handler, "handler");
        client.getSendPipeline().intercept(HttpSendPipeline.INSTANCE.getState(), new AnonymousClass1(handler, null));
    }
}
