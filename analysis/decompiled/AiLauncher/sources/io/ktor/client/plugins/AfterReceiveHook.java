package io.ktor.client.plugins;

import com.stepos.statsapp.v3.lib.plugin.constants.UxipConstants;
import e9.InterfaceC4014c;
import g9.InterfaceC4112d;
import io.ktor.client.HttpClient;
import io.ktor.client.plugins.api.ClientHook;
import io.ktor.client.statement.HttpReceivePipeline;
import io.ktor.client.statement.HttpResponse;
import io.ktor.util.pipeline.PipelineContext;
import kotlin.Metadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;

@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÀ\u0002\u0018\u00002&\u0012\"\u0012 \b\u0001\u0012\u0004\u0012\u00020\u0003\u0012\f\u0012\n\u0012\u0006\u0012\u0004\u0018\u00010\u00030\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u00050\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0006\u0010\u0007J=\u0010\f\u001a\u00020\u000b2\u0006\u0010\t\u001a\u00020\b2$\u0010\n\u001a \b\u0001\u0012\u0004\u0012\u00020\u0003\u0012\f\u0012\n\u0012\u0006\u0012\u0004\u0018\u00010\u00030\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u00050\u0002H\u0016¢\u0006\u0004\b\f\u0010\r¨\u0006\u000e"}, d2 = {"Lio/ktor/client/plugins/AfterReceiveHook;", "Lio/ktor/client/plugins/api/ClientHook;", "Lkotlin/Function2;", "Lio/ktor/client/statement/HttpResponse;", "Le9/c;", "", "<init>", "()V", "Lio/ktor/client/HttpClient;", "client", "handler", "LY8/t;", W4.b.STEP_INSTALL, "(Lio/ktor/client/HttpClient;Lp9/p;)V", "ktor-client-core"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class AfterReceiveHook implements ClientHook<p9.p<? super HttpResponse, ? super InterfaceC4014c<? super HttpResponse>, ? extends Object>> {
    public static final AfterReceiveHook INSTANCE = new AfterReceiveHook();

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0004\u001a\u00020\u0002*\u000e\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u0001H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"Lio/ktor/util/pipeline/PipelineContext;", "Lio/ktor/client/statement/HttpResponse;", "LY8/t;", UxipConstants.f30685x, "<anonymous>", "(Lio/ktor/util/pipeline/PipelineContext;Lio/ktor/client/statement/HttpResponse;)V"}, k = 3, mv = {2, 2, 0})
    @InterfaceC4112d(c = "io.ktor.client.plugins.AfterReceiveHook$install$1", f = "BodyProgress.kt", l = {50, 51}, m = "invokeSuspend")
    /* renamed from: io.ktor.client.plugins.AfterReceiveHook$install$1, reason: invalid class name */
    public static final class AnonymousClass1 extends SuspendLambda implements p9.q<PipelineContext<HttpResponse, Y8.t>, HttpResponse, InterfaceC4014c<? super Y8.t>, Object> {
        final /* synthetic */ p9.p<HttpResponse, InterfaceC4014c<? super HttpResponse>, Object> $handler;
        private /* synthetic */ Object L$0;
        /* synthetic */ Object L$1;
        Object L$2;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        public AnonymousClass1(p9.p<? super HttpResponse, ? super InterfaceC4014c<? super HttpResponse>, ? extends Object> pVar, InterfaceC4014c<? super AnonymousClass1> interfaceC4014c) {
            super(3, interfaceC4014c);
            this.$handler = pVar;
        }

        @Override // p9.q
        public final Object invoke(PipelineContext<HttpResponse, Y8.t> pipelineContext, HttpResponse httpResponse, InterfaceC4014c<? super Y8.t> interfaceC4014c) {
            AnonymousClass1 anonymousClass1 = new AnonymousClass1(this.$handler, interfaceC4014c);
            anonymousClass1.L$0 = pipelineContext;
            anonymousClass1.L$1 = httpResponse;
            return anonymousClass1.invokeSuspend(Y8.t.f7040a);
        }

        /* JADX WARN: Code restructure failed: missing block: B:16:0x005c, code lost:
        
            if (r0.proceedWith(r7, r6) == r2) goto L17;
         */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public final java.lang.Object invokeSuspend(java.lang.Object r7) throws java.lang.Throwable {
            /*
                r6 = this;
                java.lang.Object r0 = r6.L$0
                io.ktor.util.pipeline.PipelineContext r0 = (io.ktor.util.pipeline.PipelineContext) r0
                java.lang.Object r1 = r6.L$1
                io.ktor.client.statement.HttpResponse r1 = (io.ktor.client.statement.HttpResponse) r1
                java.lang.Object r2 = f9.C4063a.g()
                int r3 = r6.label
                r4 = 2
                r5 = 1
                if (r3 == 0) goto L2a
                if (r3 == r5) goto L26
                if (r3 != r4) goto L1e
                java.lang.Object r6 = r6.L$2
                io.ktor.client.statement.HttpResponse r6 = (io.ktor.client.statement.HttpResponse) r6
                kotlin.C4849c.b(r7)
                goto L5f
            L1e:
                java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
                java.lang.String r7 = "call to 'resume' before 'invoke' with coroutine"
                r6.<init>(r7)
                throw r6
            L26:
                kotlin.C4849c.b(r7)
                goto L40
            L2a:
                kotlin.C4849c.b(r7)
                p9.p<io.ktor.client.statement.HttpResponse, e9.c<? super io.ktor.client.statement.HttpResponse>, java.lang.Object> r7 = r6.$handler
                r6.L$0 = r0
                java.lang.Object r3 = g9.h.a(r1)
                r6.L$1 = r3
                r6.label = r5
                java.lang.Object r7 = r7.invoke(r1, r6)
                if (r7 != r2) goto L40
                goto L5e
            L40:
                io.ktor.client.statement.HttpResponse r7 = (io.ktor.client.statement.HttpResponse) r7
                if (r7 == 0) goto L5f
                java.lang.Object r3 = g9.h.a(r0)
                r6.L$0 = r3
                java.lang.Object r1 = g9.h.a(r1)
                r6.L$1 = r1
                java.lang.Object r1 = g9.h.a(r7)
                r6.L$2 = r1
                r6.label = r4
                java.lang.Object r6 = r0.proceedWith(r7, r6)
                if (r6 != r2) goto L5f
            L5e:
                return r2
            L5f:
                Y8.t r6 = Y8.t.f7040a
                return r6
            */
            throw new UnsupportedOperationException("Method not decompiled: io.ktor.client.plugins.AfterReceiveHook.AnonymousClass1.invokeSuspend(java.lang.Object):java.lang.Object");
        }
    }

    private AfterReceiveHook() {
    }

    @Override // io.ktor.client.plugins.api.ClientHook
    public void install(HttpClient client, p9.p<? super HttpResponse, ? super InterfaceC4014c<? super HttpResponse>, ? extends Object> handler) {
        kotlin.jvm.internal.p.i(client, "client");
        kotlin.jvm.internal.p.i(handler, "handler");
        client.getReceivePipeline().intercept(HttpReceivePipeline.INSTANCE.getAfter(), new AnonymousClass1(handler, null));
    }
}
