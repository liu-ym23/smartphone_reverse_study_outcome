package io.ktor.client.engine;

import Ua.I;
import Ua.M;
import Y8.t;
import Z8.Y;
import com.stepos.ailauncher.foundation.appui.card.provider.alipay.AlipayXuiIsland;
import com.stepos.ame.sdk.SkillStoreKt;
import com.zyql.ai.selector.config.PictureConfig;
import e9.InterfaceC4014c;
import f9.C4063a;
import g9.InterfaceC4112d;
import io.ktor.client.HttpClient;
import io.ktor.client.request.HttpRequestBuilder;
import io.ktor.client.request.HttpRequestData;
import io.ktor.client.request.HttpResponseData;
import io.ktor.client.request.HttpSendPipeline;
import io.ktor.client.statement.HttpResponse;
import io.ktor.client.utils.ClientEventsKt;
import io.ktor.util.pipeline.PipelineContext;
import io.ktor.utils.io.InternalAPI;
import java.io.Closeable;
import java.util.Set;
import kotlin.C4849c;
import kotlin.Metadata;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.internal.p;
import p9.q;

@Metadata(d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\"\n\u0002\u0018\u0002\n\u0002\b\u0004\bf\u0018\u00002\u00020\u00012\u00060\u0002j\u0002`\u0003J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0082@¢\u0006\u0004\b\u0007\u0010\bJ\u0017\u0010\n\u001a\u00020\t2\u0006\u0010\u0005\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\n\u0010\u000bJ\u0018\u0010\r\u001a\u00020\u00062\u0006\u0010\f\u001a\u00020\u0004H§@¢\u0006\u0004\b\r\u0010\bJ\u0017\u0010\u0010\u001a\u00020\t2\u0006\u0010\u000f\u001a\u00020\u000eH\u0017¢\u0006\u0004\b\u0010\u0010\u0011R\u0014\u0010\u0015\u001a\u00020\u00128BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u0013\u0010\u0014R\u0014\u0010\u0019\u001a\u00020\u00168&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0017\u0010\u0018R\u0014\u0010\u001d\u001a\u00020\u001a8&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u001b\u0010\u001cR\u001e\u0010\"\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u001f0\u001e8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b \u0010!¨\u0006#À\u0006\u0003"}, d2 = {"Lio/ktor/client/engine/HttpClientEngine;", "LUa/M;", "Ljava/io/Closeable;", "Lio/ktor/utils/io/core/Closeable;", "Lio/ktor/client/request/HttpRequestData;", "requestData", "Lio/ktor/client/request/HttpResponseData;", "executeWithinCallContext", "(Lio/ktor/client/request/HttpRequestData;Le9/c;)Ljava/lang/Object;", "LY8/t;", "checkExtensions", "(Lio/ktor/client/request/HttpRequestData;)V", "data", "execute", "Lio/ktor/client/HttpClient;", "client", W4.b.STEP_INSTALL, "(Lio/ktor/client/HttpClient;)V", "", "getClosed", "()Z", AlipayXuiIsland.REASON_CLOSED, "LUa/I;", "getDispatcher", "()LUa/I;", "dispatcher", "Lio/ktor/client/engine/HttpClientEngineConfig;", "getConfig", "()Lio/ktor/client/engine/HttpClientEngineConfig;", "config", "", "Lio/ktor/client/engine/HttpClientEngineCapability;", "getSupportedCapabilities", "()Ljava/util/Set;", "supportedCapabilities", "ktor-client-core"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes4.dex */
public interface HttpClientEngine extends M, Closeable {

    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    public static final class DefaultImpls {
        @Deprecated
        public static Set<HttpClientEngineCapability<?>> getSupportedCapabilities(HttpClientEngine httpClientEngine) {
            return HttpClientEngine.super.getSupportedCapabilities();
        }

        @InternalAPI
        @Deprecated
        public static void install(HttpClientEngine httpClientEngine, HttpClient client) {
            p.i(client, "client");
            HttpClientEngine.super.install(client);
        }
    }

    @InterfaceC4112d(c = "io.ktor.client.engine.HttpClientEngine", f = "HttpClientEngine.kt", l = {175, 184}, m = "executeWithinCallContext")
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    /* renamed from: io.ktor.client.engine.HttpClientEngine$executeWithinCallContext$1, reason: invalid class name */
    public static final class AnonymousClass1 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        Object L$2;
        int label;
        /* synthetic */ Object result;

        public AnonymousClass1(InterfaceC4014c<? super AnonymousClass1> interfaceC4014c) {
            super(interfaceC4014c);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return HttpClientEngine.this.executeWithinCallContext(null, this);
        }
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"LUa/M;", "Lio/ktor/client/request/HttpResponseData;", "<anonymous>", "(LUa/M;)Lio/ktor/client/request/HttpResponseData;"}, k = 3, mv = {2, 2, 0})
    @InterfaceC4112d(c = "io.ktor.client.engine.HttpClientEngine$executeWithinCallContext$2", f = "HttpClientEngine.kt", l = {183}, m = "invokeSuspend")
    /* renamed from: io.ktor.client.engine.HttpClientEngine$executeWithinCallContext$2, reason: invalid class name */
    public static final class AnonymousClass2 extends SuspendLambda implements p9.p<M, InterfaceC4014c<? super HttpResponseData>, Object> {
        final /* synthetic */ HttpRequestData $requestData;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass2(HttpRequestData httpRequestData, InterfaceC4014c<? super AnonymousClass2> interfaceC4014c) {
            super(2, interfaceC4014c);
            this.$requestData = httpRequestData;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final InterfaceC4014c<t> create(Object obj, InterfaceC4014c<?> interfaceC4014c) {
            return HttpClientEngine.this.new AnonymousClass2(this.$requestData, interfaceC4014c);
        }

        @Override // p9.p
        public final Object invoke(M m10, InterfaceC4014c<? super HttpResponseData> interfaceC4014c) {
            return ((AnonymousClass2) create(m10, interfaceC4014c)).invokeSuspend(t.f7040a);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Throwable {
            Object objG = C4063a.g();
            int i10 = this.label;
            if (i10 != 0) {
                if (i10 != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                C4849c.b(obj);
                return obj;
            }
            C4849c.b(obj);
            if (HttpClientEngine.this.getClosed()) {
                throw new ClientEngineClosedException(null, 1, null);
            }
            HttpClientEngine httpClientEngine = HttpClientEngine.this;
            HttpRequestData httpRequestData = this.$requestData;
            this.label = 1;
            Object objExecute = httpClientEngine.execute(httpRequestData, this);
            return objExecute == objG ? objG : objExecute;
        }
    }

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0005\u001a\u00020\u0004*\u000e\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u0001H\n¢\u0006\u0004\b\u0005\u0010\u0006"}, d2 = {"Lio/ktor/util/pipeline/PipelineContext;", "", "Lio/ktor/client/request/HttpRequestBuilder;", SkillStoreKt.SKILL_DOC_TYPE_CONTENT, "LY8/t;", "<anonymous>", "(Lio/ktor/util/pipeline/PipelineContext;Ljava/lang/Object;)V"}, k = 3, mv = {2, 2, 0})
    @InterfaceC4112d(c = "io.ktor.client.engine.HttpClientEngine$install$1", f = "HttpClientEngine.kt", l = {154, PictureConfig.PREVIEW_VIDEO_CODE}, m = "invokeSuspend")
    /* renamed from: io.ktor.client.engine.HttpClientEngine$install$1, reason: invalid class name and case insensitive filesystem */
    public static final class C42001 extends SuspendLambda implements q<PipelineContext<Object, HttpRequestBuilder>, Object, InterfaceC4014c<? super t>, Object> {
        final /* synthetic */ HttpClient $client;
        private /* synthetic */ Object L$0;
        /* synthetic */ Object L$1;
        Object L$2;
        Object L$3;
        Object L$4;
        Object L$5;
        Object L$6;
        int label;
        final /* synthetic */ HttpClientEngine this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C42001(HttpClient httpClient, HttpClientEngine httpClientEngine, InterfaceC4014c<? super C42001> interfaceC4014c) {
            super(3, interfaceC4014c);
            this.$client = httpClient;
            this.this$0 = httpClientEngine;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final t invokeSuspend$lambda$2(HttpClient httpClient, HttpResponse httpResponse, Throwable th) {
            if (th != null) {
                httpClient.getMonitor().raise(ClientEventsKt.getHttpResponseCancelled(), httpResponse);
            }
            return t.f7040a;
        }

        @Override // p9.q
        public final Object invoke(PipelineContext<Object, HttpRequestBuilder> pipelineContext, Object obj, InterfaceC4014c<? super t> interfaceC4014c) {
            C42001 c42001 = new C42001(this.$client, this.this$0, interfaceC4014c);
            c42001.L$0 = pipelineContext;
            c42001.L$1 = obj;
            return c42001.invokeSuspend(t.f7040a);
        }

        /* JADX WARN: Code restructure failed: missing block: B:26:0x0130, code lost:
        
            if (r0.proceedWith(r6, r12) == r2) goto L27;
         */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public final java.lang.Object invokeSuspend(java.lang.Object r13) throws java.lang.Throwable {
            /*
                Method dump skipped, instructions count: 310
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: io.ktor.client.engine.HttpClientEngine.C42001.invokeSuspend(java.lang.Object):java.lang.Object");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    default void checkExtensions(HttpRequestData requestData) {
        for (HttpClientEngineCapability<?> httpClientEngineCapability : requestData.getRequiredCapabilities$ktor_client_core()) {
            if (!getSupportedCapabilities().contains(httpClientEngineCapability)) {
                throw new IllegalArgumentException(("Engine doesn't support " + httpClientEngineCapability).toString());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    default java.lang.Object executeWithinCallContext(io.ktor.client.request.HttpRequestData r11, e9.InterfaceC4014c<? super io.ktor.client.request.HttpResponseData> r12) throws java.lang.Throwable {
        /*
            r10 = this;
            boolean r0 = r12 instanceof io.ktor.client.engine.HttpClientEngine.AnonymousClass1
            if (r0 == 0) goto L13
            r0 = r12
            io.ktor.client.engine.HttpClientEngine$executeWithinCallContext$1 r0 = (io.ktor.client.engine.HttpClientEngine.AnonymousClass1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            io.ktor.client.engine.HttpClientEngine$executeWithinCallContext$1 r0 = new io.ktor.client.engine.HttpClientEngine$executeWithinCallContext$1
            r0.<init>(r12)
        L18:
            java.lang.Object r12 = r0.result
            java.lang.Object r1 = f9.C4063a.g()
            int r2 = r0.label
            r3 = 2
            r4 = 1
            if (r2 == 0) goto L48
            if (r2 == r4) goto L40
            if (r2 != r3) goto L38
            java.lang.Object r10 = r0.L$2
            kotlin.coroutines.d r10 = (kotlin.coroutines.d) r10
            java.lang.Object r10 = r0.L$1
            kotlin.coroutines.d r10 = (kotlin.coroutines.d) r10
            java.lang.Object r10 = r0.L$0
            io.ktor.client.request.HttpRequestData r10 = (io.ktor.client.request.HttpRequestData) r10
            kotlin.C4849c.b(r12)
            return r12
        L38:
            java.lang.IllegalStateException r10 = new java.lang.IllegalStateException
            java.lang.String r11 = "call to 'resume' before 'invoke' with coroutine"
            r10.<init>(r11)
            throw r10
        L40:
            java.lang.Object r11 = r0.L$0
            io.ktor.client.request.HttpRequestData r11 = (io.ktor.client.request.HttpRequestData) r11
            kotlin.C4849c.b(r12)
            goto L5a
        L48:
            kotlin.C4849c.b(r12)
            kotlinx.coroutines.g r12 = r11.getExecutionContext()
            r0.L$0 = r11
            r0.label = r4
            java.lang.Object r12 = io.ktor.client.engine.HttpClientEngineKt.createCallContext(r10, r12, r0)
            if (r12 != r1) goto L5a
            goto L8d
        L5a:
            kotlin.coroutines.d r12 = (kotlin.coroutines.d) r12
            io.ktor.client.engine.KtorCallContextElement r2 = new io.ktor.client.engine.KtorCallContextElement
            r2.<init>(r12)
            kotlin.coroutines.d r5 = r12.plus(r2)
            io.ktor.client.engine.HttpClientEngine$executeWithinCallContext$2 r7 = new io.ktor.client.engine.HttpClientEngine$executeWithinCallContext$2
            r2 = 0
            r7.<init>(r11, r2)
            r8 = 2
            r9 = 0
            r6 = 0
            r4 = r10
            Ua.Q r10 = Ua.C1056g.b(r4, r5, r6, r7, r8, r9)
            java.lang.Object r11 = g9.h.a(r11)
            r0.L$0 = r11
            java.lang.Object r11 = g9.h.a(r12)
            r0.L$1 = r11
            java.lang.Object r11 = g9.h.a(r5)
            r0.L$2 = r11
            r0.label = r3
            java.lang.Object r10 = r10.a1(r0)
            if (r10 != r1) goto L8e
        L8d:
            return r1
        L8e:
            return r10
        */
        throw new UnsupportedOperationException("Method not decompiled: io.ktor.client.engine.HttpClientEngine.executeWithinCallContext(io.ktor.client.request.HttpRequestData, e9.c):java.lang.Object");
    }

    /* JADX INFO: Access modifiers changed from: private */
    default boolean getClosed() {
        return !(((kotlinx.coroutines.g) getCoroutineContext().get(kotlinx.coroutines.g.INSTANCE)) != null ? r1.b() : false);
    }

    @InternalAPI
    Object execute(HttpRequestData httpRequestData, InterfaceC4014c<? super HttpResponseData> interfaceC4014c);

    HttpClientEngineConfig getConfig();

    @Override // Ua.M
    /* synthetic */ kotlin.coroutines.d getCoroutineContext();

    I getDispatcher();

    default Set<HttpClientEngineCapability<?>> getSupportedCapabilities() {
        return Y.e();
    }

    @InternalAPI
    default void install(HttpClient client) {
        p.i(client, "client");
        client.getSendPipeline().intercept(HttpSendPipeline.INSTANCE.getEngine(), new C42001(client, this, null));
    }
}
