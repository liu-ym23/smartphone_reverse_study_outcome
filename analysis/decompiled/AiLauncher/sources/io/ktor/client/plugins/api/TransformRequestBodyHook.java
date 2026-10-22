package io.ktor.client.plugins.api;

import Y8.t;
import e9.InterfaceC4014c;
import g9.InterfaceC4112d;
import io.ktor.client.HttpClient;
import io.ktor.client.request.HttpRequestBuilder;
import io.ktor.client.request.HttpRequestPipeline;
import io.ktor.http.content.OutgoingContent;
import io.ktor.util.pipeline.PipelineContext;
import io.ktor.util.reflect.TypeInfo;
import kotlin.Metadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.internal.p;
import p9.q;
import p9.s;

@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÀ\u0002\u0018\u00002:\u00126\u00124\b\u0001\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0005\u0012\u0006\u0012\u0004\u0018\u00010\u0006\u0012\f\u0012\n\u0012\u0006\u0012\u0004\u0018\u00010\b0\u0007\u0012\u0006\u0012\u0004\u0018\u00010\u00050\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\t\u0010\nJQ\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\f\u001a\u00020\u000b28\u0010\r\u001a4\b\u0001\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0005\u0012\u0006\u0012\u0004\u0018\u00010\u0006\u0012\f\u0012\n\u0012\u0006\u0012\u0004\u0018\u00010\b0\u0007\u0012\u0006\u0012\u0004\u0018\u00010\u00050\u0002H\u0016¢\u0006\u0004\b\u000f\u0010\u0010¨\u0006\u0011"}, d2 = {"Lio/ktor/client/plugins/api/TransformRequestBodyHook;", "Lio/ktor/client/plugins/api/ClientHook;", "Lkotlin/Function5;", "Lio/ktor/client/plugins/api/TransformRequestBodyContext;", "Lio/ktor/client/request/HttpRequestBuilder;", "", "Lio/ktor/util/reflect/TypeInfo;", "Le9/c;", "Lio/ktor/http/content/OutgoingContent;", "<init>", "()V", "Lio/ktor/client/HttpClient;", "client", "handler", "LY8/t;", W4.b.STEP_INSTALL, "(Lio/ktor/client/HttpClient;Lp9/s;)V", "ktor-client-core"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class TransformRequestBodyHook implements ClientHook<s<? super TransformRequestBodyContext, ? super HttpRequestBuilder, ? super Object, ? super TypeInfo, ? super InterfaceC4014c<? super OutgoingContent>, ? extends Object>> {
    public static final TransformRequestBodyHook INSTANCE = new TransformRequestBodyHook();

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0005\u001a\u00020\u0004*\u000e\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u0001H\n¢\u0006\u0004\b\u0005\u0010\u0006"}, d2 = {"Lio/ktor/util/pipeline/PipelineContext;", "", "Lio/ktor/client/request/HttpRequestBuilder;", "it", "LY8/t;", "<anonymous>", "(Lio/ktor/util/pipeline/PipelineContext;Ljava/lang/Object;)V"}, k = 3, mv = {2, 2, 0})
    @InterfaceC4112d(c = "io.ktor.client.plugins.api.TransformRequestBodyHook$install$1", f = "KtorCallContexts.kt", l = {87, 88}, m = "invokeSuspend")
    /* renamed from: io.ktor.client.plugins.api.TransformRequestBodyHook$install$1, reason: invalid class name */
    public static final class AnonymousClass1 extends SuspendLambda implements q<PipelineContext<Object, HttpRequestBuilder>, Object, InterfaceC4014c<? super t>, Object> {
        final /* synthetic */ s<TransformRequestBodyContext, HttpRequestBuilder, Object, TypeInfo, InterfaceC4014c<? super OutgoingContent>, Object> $handler;
        private /* synthetic */ Object L$0;
        Object L$1;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        public AnonymousClass1(s<? super TransformRequestBodyContext, ? super HttpRequestBuilder, Object, ? super TypeInfo, ? super InterfaceC4014c<? super OutgoingContent>, ? extends Object> sVar, InterfaceC4014c<? super AnonymousClass1> interfaceC4014c) {
            super(3, interfaceC4014c);
            this.$handler = sVar;
        }

        @Override // p9.q
        public final Object invoke(PipelineContext<Object, HttpRequestBuilder> pipelineContext, Object obj, InterfaceC4014c<? super t> interfaceC4014c) {
            AnonymousClass1 anonymousClass1 = new AnonymousClass1(this.$handler, interfaceC4014c);
            anonymousClass1.L$0 = pipelineContext;
            return anonymousClass1.invokeSuspend(t.f7040a);
        }

        /* JADX WARN: Code restructure failed: missing block: B:16:0x0066, code lost:
        
            if (r0.proceedWith(r11, r9) == r1) goto L17;
         */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public final java.lang.Object invokeSuspend(java.lang.Object r11) throws java.lang.Throwable {
            /*
                r10 = this;
                java.lang.Object r0 = r10.L$0
                io.ktor.util.pipeline.PipelineContext r0 = (io.ktor.util.pipeline.PipelineContext) r0
                java.lang.Object r1 = f9.C4063a.g()
                int r2 = r10.label
                r3 = 2
                r4 = 1
                if (r2 == 0) goto L27
                if (r2 == r4) goto L22
                if (r2 != r3) goto L1a
                java.lang.Object r10 = r10.L$1
                io.ktor.http.content.OutgoingContent r10 = (io.ktor.http.content.OutgoingContent) r10
                kotlin.C4849c.b(r11)
                goto L69
            L1a:
                java.lang.IllegalStateException r10 = new java.lang.IllegalStateException
                java.lang.String r11 = "call to 'resume' before 'invoke' with coroutine"
                r10.<init>(r11)
                throw r10
            L22:
                kotlin.C4849c.b(r11)
                r9 = r10
                goto L50
            L27:
                kotlin.C4849c.b(r11)
                r11 = r4
                p9.s<io.ktor.client.plugins.api.TransformRequestBodyContext, io.ktor.client.request.HttpRequestBuilder, java.lang.Object, io.ktor.util.reflect.TypeInfo, e9.c<? super io.ktor.http.content.OutgoingContent>, java.lang.Object> r4 = r10.$handler
                io.ktor.client.plugins.api.TransformRequestBodyContext r5 = new io.ktor.client.plugins.api.TransformRequestBodyContext
                r5.<init>()
                java.lang.Object r6 = r0.getContext()
                java.lang.Object r7 = r0.getSubject()
                java.lang.Object r2 = r0.getContext()
                io.ktor.client.request.HttpRequestBuilder r2 = (io.ktor.client.request.HttpRequestBuilder) r2
                io.ktor.util.reflect.TypeInfo r8 = r2.getBodyType()
                r10.L$0 = r0
                r10.label = r11
                r9 = r10
                java.lang.Object r11 = r4.invoke(r5, r6, r7, r8, r9)
                if (r11 != r1) goto L50
                goto L68
            L50:
                io.ktor.http.content.OutgoingContent r11 = (io.ktor.http.content.OutgoingContent) r11
                if (r11 == 0) goto L69
                java.lang.Object r10 = g9.h.a(r0)
                r9.L$0 = r10
                java.lang.Object r10 = g9.h.a(r11)
                r9.L$1 = r10
                r9.label = r3
                java.lang.Object r10 = r0.proceedWith(r11, r9)
                if (r10 != r1) goto L69
            L68:
                return r1
            L69:
                Y8.t r10 = Y8.t.f7040a
                return r10
            */
            throw new UnsupportedOperationException("Method not decompiled: io.ktor.client.plugins.api.TransformRequestBodyHook.AnonymousClass1.invokeSuspend(java.lang.Object):java.lang.Object");
        }
    }

    private TransformRequestBodyHook() {
    }

    @Override // io.ktor.client.plugins.api.ClientHook
    public /* bridge */ /* synthetic */ void install(HttpClient httpClient, s<? super TransformRequestBodyContext, ? super HttpRequestBuilder, ? super Object, ? super TypeInfo, ? super InterfaceC4014c<? super OutgoingContent>, ? extends Object> sVar) {
        install2(httpClient, (s<? super TransformRequestBodyContext, ? super HttpRequestBuilder, Object, ? super TypeInfo, ? super InterfaceC4014c<? super OutgoingContent>, ? extends Object>) sVar);
    }

    /* renamed from: install, reason: avoid collision after fix types in other method */
    public void install2(HttpClient client, s<? super TransformRequestBodyContext, ? super HttpRequestBuilder, Object, ? super TypeInfo, ? super InterfaceC4014c<? super OutgoingContent>, ? extends Object> handler) {
        p.i(client, "client");
        p.i(handler, "handler");
        client.getRequestPipeline().intercept(HttpRequestPipeline.INSTANCE.getTransform(), new AnonymousClass1(handler, null));
    }
}
