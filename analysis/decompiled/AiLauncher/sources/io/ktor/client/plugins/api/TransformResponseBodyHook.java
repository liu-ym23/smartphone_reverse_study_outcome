package io.ktor.client.plugins.api;

import Y8.t;
import e9.InterfaceC4014c;
import g9.InterfaceC4112d;
import io.ktor.client.HttpClient;
import io.ktor.client.call.HttpClientCall;
import io.ktor.client.statement.HttpResponse;
import io.ktor.client.statement.HttpResponseContainer;
import io.ktor.client.statement.HttpResponsePipeline;
import io.ktor.util.pipeline.PipelineContext;
import io.ktor.util.reflect.TypeInfo;
import io.ktor.utils.io.ByteReadChannel;
import kotlin.Metadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.internal.p;
import p9.q;
import p9.s;

@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÀ\u0002\u0018\u000028\u00124\u00122\b\u0001\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0006\u0012\f\u0012\n\u0012\u0006\u0012\u0004\u0018\u00010\b0\u0007\u0012\u0006\u0012\u0004\u0018\u00010\b0\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\t\u0010\nJO\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\f\u001a\u00020\u000b26\u0010\r\u001a2\b\u0001\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0006\u0012\f\u0012\n\u0012\u0006\u0012\u0004\u0018\u00010\b0\u0007\u0012\u0006\u0012\u0004\u0018\u00010\b0\u0002H\u0016¢\u0006\u0004\b\u000f\u0010\u0010¨\u0006\u0011"}, d2 = {"Lio/ktor/client/plugins/api/TransformResponseBodyHook;", "Lio/ktor/client/plugins/api/ClientHook;", "Lkotlin/Function5;", "Lio/ktor/client/plugins/api/TransformResponseBodyContext;", "Lio/ktor/client/statement/HttpResponse;", "Lio/ktor/utils/io/ByteReadChannel;", "Lio/ktor/util/reflect/TypeInfo;", "Le9/c;", "", "<init>", "()V", "Lio/ktor/client/HttpClient;", "client", "handler", "LY8/t;", W4.b.STEP_INSTALL, "(Lio/ktor/client/HttpClient;Lp9/s;)V", "ktor-client-core"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class TransformResponseBodyHook implements ClientHook<s<? super TransformResponseBodyContext, ? super HttpResponse, ? super ByteReadChannel, ? super TypeInfo, ? super InterfaceC4014c<? super Object>, ? extends Object>> {
    public static final TransformResponseBodyHook INSTANCE = new TransformResponseBodyHook();

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0005\u001a\u00020\u0004*\u000e\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u0001H\n¢\u0006\u0004\b\u0005\u0010\u0006"}, d2 = {"Lio/ktor/util/pipeline/PipelineContext;", "Lio/ktor/client/statement/HttpResponseContainer;", "Lio/ktor/client/call/HttpClientCall;", "it", "LY8/t;", "<anonymous>", "(Lio/ktor/util/pipeline/PipelineContext;Lio/ktor/client/statement/HttpResponseContainer;)V"}, k = 3, mv = {2, 2, 0})
    @InterfaceC4112d(c = "io.ktor.client.plugins.api.TransformResponseBodyHook$install$1", f = "KtorCallContexts.kt", l = {113, 120}, m = "invokeSuspend")
    /* renamed from: io.ktor.client.plugins.api.TransformResponseBodyHook$install$1, reason: invalid class name */
    public static final class AnonymousClass1 extends SuspendLambda implements q<PipelineContext<HttpResponseContainer, HttpClientCall>, HttpResponseContainer, InterfaceC4014c<? super t>, Object> {
        final /* synthetic */ s<TransformResponseBodyContext, HttpResponse, ByteReadChannel, TypeInfo, InterfaceC4014c<Object>, Object> $handler;
        private /* synthetic */ Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        public AnonymousClass1(s<? super TransformResponseBodyContext, ? super HttpResponse, ? super ByteReadChannel, ? super TypeInfo, ? super InterfaceC4014c<Object>, ? extends Object> sVar, InterfaceC4014c<? super AnonymousClass1> interfaceC4014c) {
            super(3, interfaceC4014c);
            this.$handler = sVar;
        }

        @Override // p9.q
        public final Object invoke(PipelineContext<HttpResponseContainer, HttpClientCall> pipelineContext, HttpResponseContainer httpResponseContainer, InterfaceC4014c<? super t> interfaceC4014c) {
            AnonymousClass1 anonymousClass1 = new AnonymousClass1(this.$handler, interfaceC4014c);
            anonymousClass1.L$0 = pipelineContext;
            return anonymousClass1.invokeSuspend(t.f7040a);
        }

        /* JADX WARN: Code restructure failed: missing block: B:29:0x00c3, code lost:
        
            if (r0.proceedWith(r11, r10) == r1) goto L30;
         */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public final java.lang.Object invokeSuspend(java.lang.Object r12) throws java.lang.Throwable {
            /*
                r11 = this;
                java.lang.Object r0 = r11.L$0
                io.ktor.util.pipeline.PipelineContext r0 = (io.ktor.util.pipeline.PipelineContext) r0
                java.lang.Object r1 = f9.C4063a.g()
                int r2 = r11.label
                r3 = 2
                r4 = 1
                if (r2 == 0) goto L2e
                if (r2 == r4) goto L23
                if (r2 != r3) goto L1b
                java.lang.Object r11 = r11.L$1
                io.ktor.util.reflect.TypeInfo r11 = (io.ktor.util.reflect.TypeInfo) r11
                kotlin.C4849c.b(r12)
                goto Lc6
            L1b:
                java.lang.IllegalStateException r11 = new java.lang.IllegalStateException
                java.lang.String r12 = "call to 'resume' before 'invoke' with coroutine"
                r11.<init>(r12)
                throw r11
            L23:
                java.lang.Object r2 = r11.L$2
                java.lang.Object r4 = r11.L$1
                io.ktor.util.reflect.TypeInfo r4 = (io.ktor.util.reflect.TypeInfo) r4
                kotlin.C4849c.b(r12)
                r10 = r11
                goto L6d
            L2e:
                kotlin.C4849c.b(r12)
                java.lang.Object r12 = r0.getSubject()
                io.ktor.client.statement.HttpResponseContainer r12 = (io.ktor.client.statement.HttpResponseContainer) r12
                io.ktor.util.reflect.TypeInfo r9 = r12.getExpectedType()
                java.lang.Object r8 = r12.getResponse()
                boolean r12 = r8 instanceof io.ktor.utils.io.ByteReadChannel
                if (r12 != 0) goto L46
                Y8.t r11 = Y8.t.f7040a
                return r11
            L46:
                p9.s<io.ktor.client.plugins.api.TransformResponseBodyContext, io.ktor.client.statement.HttpResponse, io.ktor.utils.io.ByteReadChannel, io.ktor.util.reflect.TypeInfo, e9.c<java.lang.Object>, java.lang.Object> r5 = r11.$handler
                io.ktor.client.plugins.api.TransformResponseBodyContext r6 = new io.ktor.client.plugins.api.TransformResponseBodyContext
                r6.<init>()
                java.lang.Object r12 = r0.getContext()
                io.ktor.client.call.HttpClientCall r12 = (io.ktor.client.call.HttpClientCall) r12
                io.ktor.client.statement.HttpResponse r7 = r12.getResponse()
                r11.L$0 = r0
                r11.L$1 = r9
                java.lang.Object r12 = g9.h.a(r8)
                r11.L$2 = r12
                r11.label = r4
                r10 = r11
                java.lang.Object r12 = r5.invoke(r6, r7, r8, r9, r10)
                if (r12 != r1) goto L6b
                goto Lc5
            L6b:
                r2 = r8
                r4 = r9
            L6d:
                if (r12 != 0) goto L72
                Y8.t r11 = Y8.t.f7040a
                return r11
            L72:
                boolean r11 = r12 instanceof io.ktor.http.content.NullBody
                if (r11 != 0) goto La0
                w9.d r11 = r4.getType()
                boolean r11 = r11.k(r12)
                if (r11 == 0) goto L81
                goto La0
            L81:
                java.lang.IllegalStateException r11 = new java.lang.IllegalStateException
                java.lang.StringBuilder r0 = new java.lang.StringBuilder
                r0.<init>()
                java.lang.String r1 = "transformResponseBody returned "
                r0.append(r1)
                r0.append(r12)
                java.lang.String r12 = " but expected value of type "
                r0.append(r12)
                r0.append(r4)
                java.lang.String r12 = r0.toString()
                r11.<init>(r12)
                throw r11
            La0:
                io.ktor.client.statement.HttpResponseContainer r11 = new io.ktor.client.statement.HttpResponseContainer
                r11.<init>(r4, r12)
                java.lang.Object r5 = g9.h.a(r0)
                r10.L$0 = r5
                java.lang.Object r4 = g9.h.a(r4)
                r10.L$1 = r4
                java.lang.Object r2 = g9.h.a(r2)
                r10.L$2 = r2
                java.lang.Object r12 = g9.h.a(r12)
                r10.L$3 = r12
                r10.label = r3
                java.lang.Object r11 = r0.proceedWith(r11, r10)
                if (r11 != r1) goto Lc6
            Lc5:
                return r1
            Lc6:
                Y8.t r11 = Y8.t.f7040a
                return r11
            */
            throw new UnsupportedOperationException("Method not decompiled: io.ktor.client.plugins.api.TransformResponseBodyHook.AnonymousClass1.invokeSuspend(java.lang.Object):java.lang.Object");
        }
    }

    private TransformResponseBodyHook() {
    }

    @Override // io.ktor.client.plugins.api.ClientHook
    public /* bridge */ /* synthetic */ void install(HttpClient httpClient, s<? super TransformResponseBodyContext, ? super HttpResponse, ? super ByteReadChannel, ? super TypeInfo, ? super InterfaceC4014c<? super Object>, ? extends Object> sVar) {
        install2(httpClient, (s<? super TransformResponseBodyContext, ? super HttpResponse, ? super ByteReadChannel, ? super TypeInfo, ? super InterfaceC4014c<Object>, ? extends Object>) sVar);
    }

    /* renamed from: install, reason: avoid collision after fix types in other method */
    public void install2(HttpClient client, s<? super TransformResponseBodyContext, ? super HttpResponse, ? super ByteReadChannel, ? super TypeInfo, ? super InterfaceC4014c<Object>, ? extends Object> handler) {
        p.i(client, "client");
        p.i(handler, "handler");
        client.getResponsePipeline().intercept(HttpResponsePipeline.INSTANCE.getTransform(), new AnonymousClass1(handler, null));
    }
}
