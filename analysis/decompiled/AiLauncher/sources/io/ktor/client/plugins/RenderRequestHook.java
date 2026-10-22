package io.ktor.client.plugins;

import com.stepos.ame.sdk.SkillStoreKt;
import e9.InterfaceC4014c;
import g9.InterfaceC4112d;
import io.ktor.client.HttpClient;
import io.ktor.client.plugins.api.ClientHook;
import io.ktor.client.request.HttpRequestBuilder;
import io.ktor.client.request.HttpRequestPipeline;
import io.ktor.http.content.OutgoingContent;
import io.ktor.util.pipeline.PipelineContext;
import kotlin.Metadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;

@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÀ\u0002\u0018\u00002,\u0012(\u0012&\b\u0001\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0004\u0012\f\u0012\n\u0012\u0006\u0012\u0004\u0018\u00010\u00060\u0005\u0012\u0006\u0012\u0004\u0018\u00010\u00040\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0007\u0010\bJC\u0010\r\u001a\u00020\f2\u0006\u0010\n\u001a\u00020\t2*\u0010\u000b\u001a&\b\u0001\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0004\u0012\f\u0012\n\u0012\u0006\u0012\u0004\u0018\u00010\u00060\u0005\u0012\u0006\u0012\u0004\u0018\u00010\u00040\u0002H\u0016¢\u0006\u0004\b\r\u0010\u000e¨\u0006\u000f"}, d2 = {"Lio/ktor/client/plugins/RenderRequestHook;", "Lio/ktor/client/plugins/api/ClientHook;", "Lkotlin/Function3;", "Lio/ktor/client/request/HttpRequestBuilder;", "", "Le9/c;", "Lio/ktor/http/content/OutgoingContent;", "<init>", "()V", "Lio/ktor/client/HttpClient;", "client", "handler", "LY8/t;", W4.b.STEP_INSTALL, "(Lio/ktor/client/HttpClient;Lp9/q;)V", "ktor-client-core"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class RenderRequestHook implements ClientHook<p9.q<? super HttpRequestBuilder, ? super Object, ? super InterfaceC4014c<? super OutgoingContent>, ? extends Object>> {
    public static final RenderRequestHook INSTANCE = new RenderRequestHook();

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0005\u001a\u00020\u0004*\u000e\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u0001H\n¢\u0006\u0004\b\u0005\u0010\u0006"}, d2 = {"Lio/ktor/util/pipeline/PipelineContext;", "", "Lio/ktor/client/request/HttpRequestBuilder;", SkillStoreKt.SKILL_DOC_TYPE_CONTENT, "LY8/t;", "<anonymous>", "(Lio/ktor/util/pipeline/PipelineContext;Ljava/lang/Object;)V"}, k = 3, mv = {2, 2, 0})
    @InterfaceC4112d(c = "io.ktor.client.plugins.RenderRequestHook$install$1", f = "HttpPlainText.kt", l = {155, 156}, m = "invokeSuspend")
    /* renamed from: io.ktor.client.plugins.RenderRequestHook$install$1, reason: invalid class name */
    public static final class AnonymousClass1 extends SuspendLambda implements p9.q<PipelineContext<Object, HttpRequestBuilder>, Object, InterfaceC4014c<? super Y8.t>, Object> {
        final /* synthetic */ p9.q<HttpRequestBuilder, Object, InterfaceC4014c<? super OutgoingContent>, Object> $handler;
        private /* synthetic */ Object L$0;
        /* synthetic */ Object L$1;
        Object L$2;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        public AnonymousClass1(p9.q<? super HttpRequestBuilder, Object, ? super InterfaceC4014c<? super OutgoingContent>, ? extends Object> qVar, InterfaceC4014c<? super AnonymousClass1> interfaceC4014c) {
            super(3, interfaceC4014c);
            this.$handler = qVar;
        }

        @Override // p9.q
        public final Object invoke(PipelineContext<Object, HttpRequestBuilder> pipelineContext, Object obj, InterfaceC4014c<? super Y8.t> interfaceC4014c) {
            AnonymousClass1 anonymousClass1 = new AnonymousClass1(this.$handler, interfaceC4014c);
            anonymousClass1.L$0 = pipelineContext;
            anonymousClass1.L$1 = obj;
            return anonymousClass1.invokeSuspend(Y8.t.f7040a);
        }

        /* JADX WARN: Code restructure failed: missing block: B:16:0x005e, code lost:
        
            if (r0.proceedWith(r8, r7) == r2) goto L17;
         */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public final java.lang.Object invokeSuspend(java.lang.Object r8) throws java.lang.Throwable {
            /*
                r7 = this;
                java.lang.Object r0 = r7.L$0
                io.ktor.util.pipeline.PipelineContext r0 = (io.ktor.util.pipeline.PipelineContext) r0
                java.lang.Object r1 = r7.L$1
                java.lang.Object r2 = f9.C4063a.g()
                int r3 = r7.label
                r4 = 2
                r5 = 1
                if (r3 == 0) goto L28
                if (r3 == r5) goto L24
                if (r3 != r4) goto L1c
                java.lang.Object r7 = r7.L$2
                io.ktor.http.content.OutgoingContent r7 = (io.ktor.http.content.OutgoingContent) r7
                kotlin.C4849c.b(r8)
                goto L61
            L1c:
                java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
                java.lang.String r8 = "call to 'resume' before 'invoke' with coroutine"
                r7.<init>(r8)
                throw r7
            L24:
                kotlin.C4849c.b(r8)
                goto L42
            L28:
                kotlin.C4849c.b(r8)
                p9.q<io.ktor.client.request.HttpRequestBuilder, java.lang.Object, e9.c<? super io.ktor.http.content.OutgoingContent>, java.lang.Object> r8 = r7.$handler
                java.lang.Object r3 = r0.getContext()
                r7.L$0 = r0
                java.lang.Object r6 = g9.h.a(r1)
                r7.L$1 = r6
                r7.label = r5
                java.lang.Object r8 = r8.invoke(r3, r1, r7)
                if (r8 != r2) goto L42
                goto L60
            L42:
                io.ktor.http.content.OutgoingContent r8 = (io.ktor.http.content.OutgoingContent) r8
                if (r8 == 0) goto L61
                java.lang.Object r3 = g9.h.a(r0)
                r7.L$0 = r3
                java.lang.Object r1 = g9.h.a(r1)
                r7.L$1 = r1
                java.lang.Object r1 = g9.h.a(r8)
                r7.L$2 = r1
                r7.label = r4
                java.lang.Object r7 = r0.proceedWith(r8, r7)
                if (r7 != r2) goto L61
            L60:
                return r2
            L61:
                Y8.t r7 = Y8.t.f7040a
                return r7
            */
            throw new UnsupportedOperationException("Method not decompiled: io.ktor.client.plugins.RenderRequestHook.AnonymousClass1.invokeSuspend(java.lang.Object):java.lang.Object");
        }
    }

    private RenderRequestHook() {
    }

    @Override // io.ktor.client.plugins.api.ClientHook
    public /* bridge */ /* synthetic */ void install(HttpClient httpClient, p9.q<? super HttpRequestBuilder, ? super Object, ? super InterfaceC4014c<? super OutgoingContent>, ? extends Object> qVar) {
        install2(httpClient, (p9.q<? super HttpRequestBuilder, Object, ? super InterfaceC4014c<? super OutgoingContent>, ? extends Object>) qVar);
    }

    /* renamed from: install, reason: avoid collision after fix types in other method */
    public void install2(HttpClient client, p9.q<? super HttpRequestBuilder, Object, ? super InterfaceC4014c<? super OutgoingContent>, ? extends Object> handler) {
        kotlin.jvm.internal.p.i(client, "client");
        kotlin.jvm.internal.p.i(handler, "handler");
        client.getRequestPipeline().intercept(HttpRequestPipeline.INSTANCE.getRender(), new AnonymousClass1(handler, null));
    }
}
