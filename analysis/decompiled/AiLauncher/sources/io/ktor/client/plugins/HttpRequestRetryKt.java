package io.ktor.client.plugins;

import Ua.InterfaceC1089x;
import e9.InterfaceC4014c;
import g9.InterfaceC4112d;
import io.ktor.client.call.HttpClientCall;
import io.ktor.client.network.sockets.ConnectTimeoutException;
import io.ktor.client.plugins.api.ClientPlugin;
import io.ktor.client.plugins.api.ClientPluginBuilder;
import io.ktor.client.plugins.api.CreatePluginUtilsKt;
import io.ktor.client.plugins.api.Send;
import io.ktor.client.request.HttpRequest;
import io.ktor.client.request.HttpRequestBuilder;
import io.ktor.client.statement.HttpResponse;
import io.ktor.client.utils.ExceptionUtilsJvmKt;
import io.ktor.events.EventDefinition;
import io.ktor.util.AttributeKey;
import io.ktor.util.logging.KtorSimpleLoggerJvmKt;
import io.ktor.util.reflect.TypeInfo;
import java.net.SocketTimeoutException;
import kotlin.Metadata;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import p9.InterfaceC5074l;
import w9.C5757p;
import w9.InterfaceC5745d;
import w9.InterfaceC5755n;

@Metadata(d1 = {"\u0000z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\b\u0002\u001a%\u0010\u0005\u001a\u00020\u0003*\u00020\u00002\u0012\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001¢\u0006\u0004\b\u0005\u0010\u0006\u001a\u0013\u0010\t\u001a\u00020\b*\u00020\u0007H\u0002¢\u0006\u0004\b\t\u0010\n\u001a\u0014\u0010\f\u001a\u00020\b*\u00020\u000bH\u0082@¢\u0006\u0004\b\f\u0010\r\"\u0018\u0010\u0010\u001a\u00060\u000ej\u0002`\u000f8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0010\u0010\u0011\"\u001d\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00130\u00128\u0006¢\u0006\f\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017\"#\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u00020\u00188\u0006¢\u0006\u0012\n\u0004\b\u0019\u0010\u001a\u0012\u0004\b\u001d\u0010\u001e\u001a\u0004\b\u001b\u0010\u001c\"\u001a\u0010!\u001a\b\u0012\u0004\u0012\u00020 0\u001f8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b!\u0010\"\"2\u0010&\u001a \u0012\u001c\u0012\u001a\u0012\u0004\u0012\u00020$\u0012\u0004\u0012\u00020%\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\b0#0\u001f8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b&\u0010\"\"2\u0010'\u001a \u0012\u001c\u0012\u001a\u0012\u0004\u0012\u00020$\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b0#0\u001f8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b'\u0010\"\",\u0010*\u001a\u001a\u0012\u0016\u0012\u0014\u0012\u0004\u0012\u00020)\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u00030(0\u001f8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b*\u0010\"\",\u0010-\u001a\u001a\u0012\u0016\u0012\u0014\u0012\u0004\u0012\u00020+\u0012\u0004\u0012\u00020 \u0012\u0004\u0012\u00020,0(0\u001f8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b-\u0010\"¨\u0006."}, d2 = {"Lio/ktor/client/request/HttpRequestBuilder;", "Lkotlin/Function1;", "Lio/ktor/client/plugins/HttpRequestRetryConfig;", "LY8/t;", "block", "retry", "(Lio/ktor/client/request/HttpRequestBuilder;Lp9/l;)V", "", "", "isTimeoutException", "(Ljava/lang/Throwable;)Z", "Lio/ktor/client/statement/HttpResponse;", "throwOnInvalidResponseBody", "(Lio/ktor/client/statement/HttpResponse;Le9/c;)Ljava/lang/Object;", "Lvc/c;", "Lio/ktor/util/logging/Logger;", "LOGGER", "Lvc/c;", "Lio/ktor/events/EventDefinition;", "Lio/ktor/client/plugins/HttpRetryEventData;", "HttpRequestRetryEvent", "Lio/ktor/events/EventDefinition;", "getHttpRequestRetryEvent", "()Lio/ktor/events/EventDefinition;", "Lio/ktor/client/plugins/api/ClientPlugin;", "HttpRequestRetry", "Lio/ktor/client/plugins/api/ClientPlugin;", "getHttpRequestRetry", "()Lio/ktor/client/plugins/api/ClientPlugin;", "getHttpRequestRetry$annotations", "()V", "Lio/ktor/util/AttributeKey;", "", "MaxRetriesPerRequestAttributeKey", "Lio/ktor/util/AttributeKey;", "Lkotlin/Function3;", "Lio/ktor/client/plugins/HttpRetryShouldRetryContext;", "Lio/ktor/client/request/HttpRequest;", "ShouldRetryPerRequestAttributeKey", "ShouldRetryOnExceptionPerRequestAttributeKey", "Lkotlin/Function2;", "Lio/ktor/client/plugins/HttpRetryModifyRequestContext;", "ModifyRequestPerRequestAttributeKey", "Lio/ktor/client/plugins/HttpRetryDelayContext;", "", "RetryDelayPerRequestAttributeKey", "ktor-client-core"}, k = 2, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class HttpRequestRetryKt {
    private static final ClientPlugin<HttpRequestRetryConfig> HttpRequestRetry;
    private static final EventDefinition<HttpRetryEventData> HttpRequestRetryEvent;
    private static final vc.c LOGGER;
    private static final AttributeKey<Integer> MaxRetriesPerRequestAttributeKey;
    private static final AttributeKey<p9.p<HttpRetryModifyRequestContext, HttpRequestBuilder, Y8.t>> ModifyRequestPerRequestAttributeKey;
    private static final AttributeKey<p9.p<HttpRetryDelayContext, Integer, Long>> RetryDelayPerRequestAttributeKey;
    private static final AttributeKey<p9.q<HttpRetryShouldRetryContext, HttpRequestBuilder, Throwable, Boolean>> ShouldRetryOnExceptionPerRequestAttributeKey;
    private static final AttributeKey<p9.q<HttpRetryShouldRetryContext, HttpRequest, HttpResponse, Boolean>> ShouldRetryPerRequestAttributeKey;

    @InterfaceC4112d(c = "io.ktor.client.plugins.HttpRequestRetryKt", f = "HttpRequestRetry.kt", l = {484}, m = "throwOnInvalidResponseBody")
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    /* renamed from: io.ktor.client.plugins.HttpRequestRetryKt$throwOnInvalidResponseBody$1, reason: invalid class name */
    public static final class AnonymousClass1 extends ContinuationImpl {
        int I$0;
        Object L$0;
        Object L$1;
        int label;
        /* synthetic */ Object result;

        public AnonymousClass1(InterfaceC4014c<? super AnonymousClass1> interfaceC4014c) {
            super(interfaceC4014c);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return HttpRequestRetryKt.throwOnInvalidResponseBody(null, this);
        }
    }

    static {
        InterfaceC5755n interfaceC5755nM;
        InterfaceC5755n interfaceC5755nP;
        InterfaceC5755n interfaceC5755nP2;
        InterfaceC5755n interfaceC5755nP3;
        Class cls = Boolean.TYPE;
        Class cls2 = Integer.TYPE;
        LOGGER = KtorSimpleLoggerJvmKt.KtorSimpleLogger("io.ktor.client.plugins.HttpRequestRetry");
        HttpRequestRetryEvent = new EventDefinition<>();
        HttpRequestRetry = CreatePluginUtilsKt.createClientPlugin("RetryFeature", HttpRequestRetryKt$HttpRequestRetry$1.INSTANCE, new InterfaceC5074l() { // from class: io.ktor.client.plugins.A
            @Override // p9.InterfaceC5074l
            public final Object invoke(Object obj) {
                return HttpRequestRetryKt.HttpRequestRetry$lambda$1((ClientPluginBuilder) obj);
            }
        });
        InterfaceC5745d interfaceC5745dB = kotlin.jvm.internal.t.b(Integer.class);
        InterfaceC5755n interfaceC5755nP4 = null;
        try {
            interfaceC5755nM = kotlin.jvm.internal.t.m(cls2);
        } catch (Throwable unused) {
            interfaceC5755nM = null;
        }
        MaxRetriesPerRequestAttributeKey = new AttributeKey<>("MaxRetriesPerRequestAttributeKey", new TypeInfo(interfaceC5745dB, interfaceC5755nM));
        InterfaceC5745d interfaceC5745dB2 = kotlin.jvm.internal.t.b(p9.q.class);
        try {
            C5757p.Companion companion = C5757p.INSTANCE;
            interfaceC5755nP = kotlin.jvm.internal.t.p(p9.q.class, companion.d(kotlin.jvm.internal.t.m(HttpRetryShouldRetryContext.class)), companion.d(kotlin.jvm.internal.t.m(HttpRequest.class)), companion.d(kotlin.jvm.internal.t.m(HttpResponse.class)), companion.d(kotlin.jvm.internal.t.m(cls)));
        } catch (Throwable unused2) {
            interfaceC5755nP = null;
        }
        ShouldRetryPerRequestAttributeKey = new AttributeKey<>("ShouldRetryPerRequestAttributeKey", new TypeInfo(interfaceC5745dB2, interfaceC5755nP));
        InterfaceC5745d interfaceC5745dB3 = kotlin.jvm.internal.t.b(p9.q.class);
        try {
            C5757p.Companion companion2 = C5757p.INSTANCE;
            interfaceC5755nP2 = kotlin.jvm.internal.t.p(p9.q.class, companion2.d(kotlin.jvm.internal.t.m(HttpRetryShouldRetryContext.class)), companion2.d(kotlin.jvm.internal.t.m(HttpRequestBuilder.class)), companion2.d(kotlin.jvm.internal.t.m(Throwable.class)), companion2.d(kotlin.jvm.internal.t.m(cls)));
        } catch (Throwable unused3) {
            interfaceC5755nP2 = null;
        }
        ShouldRetryOnExceptionPerRequestAttributeKey = new AttributeKey<>("ShouldRetryOnExceptionPerRequestAttributeKey", new TypeInfo(interfaceC5745dB3, interfaceC5755nP2));
        InterfaceC5745d interfaceC5745dB4 = kotlin.jvm.internal.t.b(p9.p.class);
        try {
            C5757p.Companion companion3 = C5757p.INSTANCE;
            interfaceC5755nP3 = kotlin.jvm.internal.t.p(p9.p.class, companion3.d(kotlin.jvm.internal.t.m(HttpRetryModifyRequestContext.class)), companion3.d(kotlin.jvm.internal.t.m(HttpRequestBuilder.class)), companion3.d(kotlin.jvm.internal.t.m(Y8.t.class)));
        } catch (Throwable unused4) {
            interfaceC5755nP3 = null;
        }
        ModifyRequestPerRequestAttributeKey = new AttributeKey<>("ModifyRequestPerRequestAttributeKey", new TypeInfo(interfaceC5745dB4, interfaceC5755nP3));
        InterfaceC5745d interfaceC5745dB5 = kotlin.jvm.internal.t.b(p9.p.class);
        try {
            C5757p.Companion companion4 = C5757p.INSTANCE;
            interfaceC5755nP4 = kotlin.jvm.internal.t.p(p9.p.class, companion4.d(kotlin.jvm.internal.t.m(HttpRetryDelayContext.class)), companion4.d(kotlin.jvm.internal.t.m(cls2)), companion4.d(kotlin.jvm.internal.t.m(Long.TYPE)));
        } catch (Throwable unused5) {
        }
        RetryDelayPerRequestAttributeKey = new AttributeKey<>("RetryDelayPerRequestAttributeKey", new TypeInfo(interfaceC5745dB5, interfaceC5755nP4));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Y8.t HttpRequestRetry$lambda$1(ClientPluginBuilder createClientPlugin) {
        kotlin.jvm.internal.p.i(createClientPlugin, "$this$createClientPlugin");
        p9.q<HttpRetryShouldRetryContext, HttpRequest, HttpResponse, Boolean> shouldRetry$ktor_client_core = ((HttpRequestRetryConfig) createClientPlugin.getPluginConfig()).getShouldRetry$ktor_client_core();
        p9.q<HttpRetryShouldRetryContext, HttpRequestBuilder, Throwable, Boolean> shouldRetryOnException$ktor_client_core = ((HttpRequestRetryConfig) createClientPlugin.getPluginConfig()).getShouldRetryOnException$ktor_client_core();
        p9.p<HttpRetryDelayContext, Integer, Long> delayMillis$ktor_client_core = ((HttpRequestRetryConfig) createClientPlugin.getPluginConfig()).getDelayMillis$ktor_client_core();
        p9.p<Long, InterfaceC4014c<? super Y8.t>, Object> delay$ktor_client_core = ((HttpRequestRetryConfig) createClientPlugin.getPluginConfig()).getDelay$ktor_client_core();
        createClientPlugin.on(Send.INSTANCE, new HttpRequestRetryKt$HttpRequestRetry$2$1(shouldRetry$ktor_client_core, shouldRetryOnException$ktor_client_core, ((HttpRequestRetryConfig) createClientPlugin.getPluginConfig()).getMaxRetries(), delayMillis$ktor_client_core, ((HttpRequestRetryConfig) createClientPlugin.getPluginConfig()).getModifyRequest(), createClientPlugin, delay$ktor_client_core, null));
        return Y8.t.f7040a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final HttpRequestBuilder HttpRequestRetry$lambda$1$prepareRequest(HttpRequestBuilder httpRequestBuilder) {
        final HttpRequestBuilder httpRequestBuilderTakeFrom = new HttpRequestBuilder().takeFrom(httpRequestBuilder);
        httpRequestBuilder.getExecutionContext().J(new InterfaceC5074l() { // from class: io.ktor.client.plugins.B
            @Override // p9.InterfaceC5074l
            public final Object invoke(Object obj) {
                return HttpRequestRetryKt.HttpRequestRetry$lambda$1$prepareRequest$lambda$0(httpRequestBuilderTakeFrom, (Throwable) obj);
            }
        });
        return httpRequestBuilderTakeFrom;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Y8.t HttpRequestRetry$lambda$1$prepareRequest$lambda$0(HttpRequestBuilder httpRequestBuilder, Throwable th) {
        kotlinx.coroutines.g executionContext = httpRequestBuilder.getExecutionContext();
        kotlin.jvm.internal.p.g(executionContext, "null cannot be cast to non-null type kotlinx.coroutines.CompletableJob");
        InterfaceC1089x interfaceC1089x = (InterfaceC1089x) executionContext;
        if (th == null) {
            interfaceC1089x.complete();
        } else {
            interfaceC1089x.e(th);
        }
        return Y8.t.f7040a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean HttpRequestRetry$lambda$1$shouldRetry(int i10, int i11, p9.q<? super HttpRetryShouldRetryContext, ? super HttpRequest, ? super HttpResponse, Boolean> qVar, HttpClientCall httpClientCall) {
        return i10 < i11 && qVar.invoke(new HttpRetryShouldRetryContext(i10 + 1), httpClientCall.getRequest(), httpClientCall.getResponse()).booleanValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean HttpRequestRetry$lambda$1$shouldRetryOnException(int i10, int i11, p9.q<? super HttpRetryShouldRetryContext, ? super HttpRequestBuilder, ? super Throwable, Boolean> qVar, HttpRequestBuilder httpRequestBuilder, Throwable th) {
        return i10 < i11 && qVar.invoke(new HttpRetryShouldRetryContext(i10 + 1), httpRequestBuilder, th).booleanValue();
    }

    public static final ClientPlugin<HttpRequestRetryConfig> getHttpRequestRetry() {
        return HttpRequestRetry;
    }

    public static /* synthetic */ void getHttpRequestRetry$annotations() {
    }

    public static final EventDefinition<HttpRetryEventData> getHttpRequestRetryEvent() {
        return HttpRequestRetryEvent;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean isTimeoutException(Throwable th) {
        Throwable thUnwrapCancellationException = ExceptionUtilsJvmKt.unwrapCancellationException(th);
        return (thUnwrapCancellationException instanceof HttpRequestTimeoutException) || (thUnwrapCancellationException instanceof ConnectTimeoutException) || (thUnwrapCancellationException instanceof SocketTimeoutException);
    }

    public static final void retry(HttpRequestBuilder httpRequestBuilder, InterfaceC5074l<? super HttpRequestRetryConfig, Y8.t> block) {
        kotlin.jvm.internal.p.i(httpRequestBuilder, "<this>");
        kotlin.jvm.internal.p.i(block, "block");
        HttpRequestRetryConfig httpRequestRetryConfig = new HttpRequestRetryConfig();
        block.invoke(httpRequestRetryConfig);
        httpRequestBuilder.getAttributes().put(ShouldRetryPerRequestAttributeKey, httpRequestRetryConfig.getShouldRetry$ktor_client_core());
        httpRequestBuilder.getAttributes().put(ShouldRetryOnExceptionPerRequestAttributeKey, httpRequestRetryConfig.getShouldRetryOnException$ktor_client_core());
        httpRequestBuilder.getAttributes().put(RetryDelayPerRequestAttributeKey, httpRequestRetryConfig.getDelayMillis$ktor_client_core());
        httpRequestBuilder.getAttributes().put(MaxRetriesPerRequestAttributeKey, Integer.valueOf(httpRequestRetryConfig.getMaxRetries()));
        httpRequestBuilder.getAttributes().put(ModifyRequestPerRequestAttributeKey, httpRequestRetryConfig.getModifyRequest());
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Can't wrap try/catch for region: R(13:0|2|(2:4|(1:6)(1:7))(0)|8|(1:(3:11|49|12)(2:16|17))(4:18|(4:20|51|21|(1:23)(1:24))|45|46)|25|47|26|30|(1:32)|(1:34)|45|46) */
    /* JADX WARN: Code restructure failed: missing block: B:28:0x0074, code lost:
    
        r7 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:29:0x0075, code lost:
    
        r0 = kotlin.Result.INSTANCE;
        r7 = kotlin.Result.b(kotlin.C4849c.a(r7));
     */
    /* JADX WARN: Removed duplicated region for block: B:43:0x00af  */
    /* JADX WARN: Removed duplicated region for block: B:55:? A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final java.lang.Object throwOnInvalidResponseBody(io.ktor.client.statement.HttpResponse r7, e9.InterfaceC4014c<? super java.lang.Boolean> r8) throws java.lang.Throwable {
        /*
            boolean r0 = r8 instanceof io.ktor.client.plugins.HttpRequestRetryKt.AnonymousClass1
            if (r0 == 0) goto L13
            r0 = r8
            io.ktor.client.plugins.HttpRequestRetryKt$throwOnInvalidResponseBody$1 r0 = (io.ktor.client.plugins.HttpRequestRetryKt.AnonymousClass1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            io.ktor.client.plugins.HttpRequestRetryKt$throwOnInvalidResponseBody$1 r0 = new io.ktor.client.plugins.HttpRequestRetryKt$throwOnInvalidResponseBody$1
            r0.<init>(r8)
        L18:
            java.lang.Object r8 = r0.result
            java.lang.Object r1 = f9.C4063a.g()
            int r2 = r0.label
            java.lang.String r3 = "Failed to close response body channel"
            r4 = 0
            r5 = 1
            if (r2 == 0) goto L3e
            if (r2 != r5) goto L36
            java.lang.Object r7 = r0.L$1
            io.ktor.utils.io.ByteReadChannel r7 = (io.ktor.utils.io.ByteReadChannel) r7
            java.lang.Object r0 = r0.L$0
            io.ktor.client.statement.HttpResponse r0 = (io.ktor.client.statement.HttpResponse) r0
            kotlin.C4849c.b(r8)     // Catch: java.lang.Throwable -> L34
            goto L62
        L34:
            r8 = move-exception
            goto L92
        L36:
            java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
            java.lang.String r8 = "call to 'resume' before 'invoke' with coroutine"
            r7.<init>(r8)
            throw r7
        L3e:
            kotlin.C4849c.b(r8)
            boolean r8 = io.ktor.client.plugins.DoubleReceivePluginKt.isSaved(r7)
            if (r8 == 0) goto Lb5
            io.ktor.utils.io.ByteReadChannel r8 = r7.getRawContent()
            java.lang.Object r7 = g9.h.a(r7)     // Catch: java.lang.Throwable -> L8e
            r0.L$0 = r7     // Catch: java.lang.Throwable -> L8e
            r0.L$1 = r8     // Catch: java.lang.Throwable -> L8e
            r0.I$0 = r4     // Catch: java.lang.Throwable -> L8e
            r0.label = r5     // Catch: java.lang.Throwable -> L8e
            r7 = 0
            java.lang.Object r7 = io.ktor.utils.io.ByteReadChannel.awaitContent$default(r8, r4, r0, r5, r7)     // Catch: java.lang.Throwable -> L8e
            if (r7 != r1) goto L5f
            return r1
        L5f:
            r6 = r8
            r8 = r7
            r7 = r6
        L62:
            java.lang.Boolean r8 = (java.lang.Boolean) r8     // Catch: java.lang.Throwable -> L34
            boolean r8 = r8.booleanValue()     // Catch: java.lang.Throwable -> L34
            kotlin.Result$a r0 = kotlin.Result.INSTANCE     // Catch: java.lang.Throwable -> L74
            io.ktor.utils.io.ByteReadChannelKt.cancel(r7)     // Catch: java.lang.Throwable -> L74
            Y8.t r7 = Y8.t.f7040a     // Catch: java.lang.Throwable -> L74
            java.lang.Object r7 = kotlin.Result.b(r7)     // Catch: java.lang.Throwable -> L74
            goto L7f
        L74:
            r7 = move-exception
            kotlin.Result$a r0 = kotlin.Result.INSTANCE
            java.lang.Object r7 = kotlin.C4849c.a(r7)
            java.lang.Object r7 = kotlin.Result.b(r7)
        L7f:
            java.lang.Throwable r7 = kotlin.Result.e(r7)
            if (r7 == 0) goto L8a
            vc.c r0 = io.ktor.client.plugins.HttpRequestRetryKt.LOGGER
            r0.debug(r3, r7)
        L8a:
            if (r8 == 0) goto Lb5
            r4 = r5
            goto Lb5
        L8e:
            r7 = move-exception
            r6 = r8
            r8 = r7
            r7 = r6
        L92:
            kotlin.Result$a r0 = kotlin.Result.INSTANCE     // Catch: java.lang.Throwable -> L9e
            io.ktor.utils.io.ByteReadChannelKt.cancel(r7)     // Catch: java.lang.Throwable -> L9e
            Y8.t r7 = Y8.t.f7040a     // Catch: java.lang.Throwable -> L9e
            java.lang.Object r7 = kotlin.Result.b(r7)     // Catch: java.lang.Throwable -> L9e
            goto La9
        L9e:
            r7 = move-exception
            kotlin.Result$a r0 = kotlin.Result.INSTANCE
            java.lang.Object r7 = kotlin.C4849c.a(r7)
            java.lang.Object r7 = kotlin.Result.b(r7)
        La9:
            java.lang.Throwable r7 = kotlin.Result.e(r7)
            if (r7 == 0) goto Lb4
            vc.c r0 = io.ktor.client.plugins.HttpRequestRetryKt.LOGGER
            r0.debug(r3, r7)
        Lb4:
            throw r8
        Lb5:
            java.lang.Boolean r7 = g9.C4109a.a(r4)
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: io.ktor.client.plugins.HttpRequestRetryKt.throwOnInvalidResponseBody(io.ktor.client.statement.HttpResponse, e9.c):java.lang.Object");
    }
}
