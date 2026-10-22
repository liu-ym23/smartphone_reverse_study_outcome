package io.ktor.client.plugins;

import e9.InterfaceC4014c;
import g9.InterfaceC4112d;
import io.ktor.client.HttpClient;
import io.ktor.client.plugins.api.ClientHook;
import io.ktor.client.request.HttpRequest;
import io.ktor.client.request.HttpRequestBuilder;
import io.ktor.client.request.HttpRequestPipeline;
import io.ktor.util.pipeline.PipelineContext;
import kotlin.Metadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;

@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÀ\u0002\u0018\u00002,\u0012(\u0012&\b\u0001\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0004\u0012\f\u0012\n\u0012\u0006\u0012\u0004\u0018\u00010\u00040\u0005\u0012\u0006\u0012\u0004\u0018\u00010\u00060\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0007\u0010\bJC\u0010\r\u001a\u00020\f2\u0006\u0010\n\u001a\u00020\t2*\u0010\u000b\u001a&\b\u0001\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0004\u0012\f\u0012\n\u0012\u0006\u0012\u0004\u0018\u00010\u00040\u0005\u0012\u0006\u0012\u0004\u0018\u00010\u00060\u0002H\u0016¢\u0006\u0004\b\r\u0010\u000e¨\u0006\u000f"}, d2 = {"Lio/ktor/client/plugins/RequestError;", "Lio/ktor/client/plugins/api/ClientHook;", "Lkotlin/Function3;", "Lio/ktor/client/request/HttpRequest;", "", "Le9/c;", "", "<init>", "()V", "Lio/ktor/client/HttpClient;", "client", "handler", "LY8/t;", W4.b.STEP_INSTALL, "(Lio/ktor/client/HttpClient;Lp9/q;)V", "ktor-client-core"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class RequestError implements ClientHook<p9.q<? super HttpRequest, ? super Throwable, ? super InterfaceC4014c<? super Throwable>, ? extends Object>> {
    public static final RequestError INSTANCE = new RequestError();

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0005\u001a\u00020\u0004*\u000e\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u0001H\n¢\u0006\u0004\b\u0005\u0010\u0006"}, d2 = {"Lio/ktor/util/pipeline/PipelineContext;", "", "Lio/ktor/client/request/HttpRequestBuilder;", "it", "LY8/t;", "<anonymous>", "(Lio/ktor/util/pipeline/PipelineContext;Ljava/lang/Object;)V"}, k = 3, mv = {2, 2, 0})
    @InterfaceC4112d(c = "io.ktor.client.plugins.RequestError$install$1", f = "HttpCallValidator.kt", l = {com.stepos.ailauncher.chat.wake.circle.F.GESTURE_HEIGHT_DP, 152}, m = "invokeSuspend")
    /* renamed from: io.ktor.client.plugins.RequestError$install$1, reason: invalid class name */
    public static final class AnonymousClass1 extends SuspendLambda implements p9.q<PipelineContext<Object, HttpRequestBuilder>, Object, InterfaceC4014c<? super Y8.t>, Object> {
        final /* synthetic */ p9.q<HttpRequest, Throwable, InterfaceC4014c<? super Throwable>, Object> $handler;
        private /* synthetic */ Object L$0;
        Object L$1;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        public AnonymousClass1(p9.q<? super HttpRequest, ? super Throwable, ? super InterfaceC4014c<? super Throwable>, ? extends Object> qVar, InterfaceC4014c<? super AnonymousClass1> interfaceC4014c) {
            super(3, interfaceC4014c);
            this.$handler = qVar;
        }

        @Override // p9.q
        public final Object invoke(PipelineContext<Object, HttpRequestBuilder> pipelineContext, Object obj, InterfaceC4014c<? super Y8.t> interfaceC4014c) {
            AnonymousClass1 anonymousClass1 = new AnonymousClass1(this.$handler, interfaceC4014c);
            anonymousClass1.L$0 = pipelineContext;
            return anonymousClass1.invokeSuspend(Y8.t.f7040a);
        }

        /* JADX WARN: Code restructure failed: missing block: B:15:0x0033, code lost:
        
            if (r5 == r1) goto L19;
         */
        /* JADX WARN: Code restructure failed: missing block: B:18:0x0054, code lost:
        
            if (r6 != r1) goto L20;
         */
        /* JADX WARN: Code restructure failed: missing block: B:19:0x0056, code lost:
        
            return r1;
         */
        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r5v9 */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public final java.lang.Object invokeSuspend(java.lang.Object r6) throws java.lang.Throwable {
            /*
                r5 = this;
                java.lang.Object r0 = r5.L$0
                io.ktor.util.pipeline.PipelineContext r0 = (io.ktor.util.pipeline.PipelineContext) r0
                java.lang.Object r1 = f9.C4063a.g()
                int r2 = r5.label
                r3 = 2
                r4 = 1
                if (r2 == 0) goto L28
                if (r2 == r4) goto L22
                if (r2 != r3) goto L1a
                java.lang.Object r5 = r5.L$1
                java.lang.Throwable r5 = (java.lang.Throwable) r5
                kotlin.C4849c.b(r6)
                goto L57
            L1a:
                java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
                java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
                r5.<init>(r6)
                throw r5
            L22:
                kotlin.C4849c.b(r6)     // Catch: java.lang.Throwable -> L26
                goto L5b
            L26:
                r6 = move-exception
                goto L36
            L28:
                kotlin.C4849c.b(r6)
                r5.L$0 = r0     // Catch: java.lang.Throwable -> L26
                r5.label = r4     // Catch: java.lang.Throwable -> L26
                java.lang.Object r5 = r0.proceed(r5)     // Catch: java.lang.Throwable -> L26
                if (r5 != r1) goto L5b
                goto L56
            L36:
                p9.q<io.ktor.client.request.HttpRequest, java.lang.Throwable, e9.c<? super java.lang.Throwable>, java.lang.Object> r2 = r5.$handler
                java.lang.Object r4 = r0.getContext()
                io.ktor.client.request.HttpRequestBuilder r4 = (io.ktor.client.request.HttpRequestBuilder) r4
                io.ktor.client.request.HttpRequest r4 = io.ktor.client.plugins.HttpCallValidatorKt.access$HttpRequest(r4)
                java.lang.Object r0 = g9.h.a(r0)
                r5.L$0 = r0
                java.lang.Object r0 = g9.h.a(r6)
                r5.L$1 = r0
                r5.label = r3
                java.lang.Object r6 = r2.invoke(r4, r6, r5)
                if (r6 != r1) goto L57
            L56:
                return r1
            L57:
                java.lang.Throwable r6 = (java.lang.Throwable) r6
                if (r6 != 0) goto L5e
            L5b:
                Y8.t r5 = Y8.t.f7040a
                return r5
            L5e:
                throw r6
            */
            throw new UnsupportedOperationException("Method not decompiled: io.ktor.client.plugins.RequestError.AnonymousClass1.invokeSuspend(java.lang.Object):java.lang.Object");
        }
    }

    private RequestError() {
    }

    @Override // io.ktor.client.plugins.api.ClientHook
    public void install(HttpClient client, p9.q<? super HttpRequest, ? super Throwable, ? super InterfaceC4014c<? super Throwable>, ? extends Object> handler) {
        kotlin.jvm.internal.p.i(client, "client");
        kotlin.jvm.internal.p.i(handler, "handler");
        client.getRequestPipeline().intercept(HttpRequestPipeline.INSTANCE.getBefore(), new AnonymousClass1(handler, null));
    }
}
