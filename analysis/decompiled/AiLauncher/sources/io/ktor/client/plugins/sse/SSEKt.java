package io.ktor.client.plugins.sse;

import androidx.exifinterface.media.ExifInterface;
import com.stepos.statsapp.v3.lib.plugin.constants.UxipConstants;
import e9.InterfaceC4014c;
import g9.InterfaceC4112d;
import io.ktor.client.HttpClient;
import io.ktor.client.plugins.api.ClientPlugin;
import io.ktor.client.plugins.api.ClientPluginBuilder;
import io.ktor.client.plugins.api.CreatePluginUtilsKt;
import io.ktor.client.request.HttpRequestBuilder;
import io.ktor.client.statement.HttpResponsePipeline;
import io.ktor.util.AttributeKey;
import io.ktor.util.logging.KtorSimpleLoggerJvmKt;
import io.ktor.util.reflect.TypeInfo;
import kotlin.Metadata;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import p9.InterfaceC5074l;
import w9.InterfaceC5745d;
import w9.InterfaceC5755n;

@Metadata(d1 = {"\u0000J\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0003\u001a1\u0010\u0006\u001a\u0004\u0018\u00018\u0000\"\b\b\u0000\u0010\u0001*\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u00022\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00028\u00000\u0004H\u0002¢\u0006\u0004\b\u0006\u0010\u0007\u001a\u0018\u0010\u000b\u001a\u00020\n2\u0006\u0010\t\u001a\u00020\bH\u0080@¢\u0006\u0004\b\u000b\u0010\f\u001a\u0014\u0010\r\u001a\u00020\b*\u00020\bH\u0080@¢\u0006\u0004\b\r\u0010\f\"\u001e\u0010\u0010\u001a\u00060\u000ej\u0002`\u000f8\u0000X\u0080\u0004¢\u0006\f\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013\"#\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00150\u00148\u0006¢\u0006\u0012\n\u0004\b\u0016\u0010\u0017\u0012\u0004\b\u001a\u0010\u001b\u001a\u0004\b\u0018\u0010\u0019\" \u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u001c0\u00048\u0000X\u0080\u0004¢\u0006\f\n\u0004\b\u001d\u0010\u001e\u001a\u0004\b\u001f\u0010 \" \u0010\"\u001a\b\u0012\u0004\u0012\u00020!0\u00048\u0000X\u0080\u0004¢\u0006\f\n\u0004\b\"\u0010\u001e\u001a\u0004\b#\u0010 ¨\u0006$"}, d2 = {"", ExifInterface.GPS_DIRECTION_TRUE, "Lio/ktor/client/request/HttpRequestBuilder;", "request", "Lio/ktor/util/AttributeKey;", "attributeKey", "getAttributeValue", "(Lio/ktor/client/request/HttpRequestBuilder;Lio/ktor/util/AttributeKey;)Ljava/lang/Object;", "Lio/ktor/client/statement/HttpResponse;", UxipConstants.f30685x, "LY8/t;", "checkResponse", "(Lio/ktor/client/statement/HttpResponse;Le9/c;)Ljava/lang/Object;", "saved", "Lvc/c;", "Lio/ktor/util/logging/Logger;", "LOGGER", "Lvc/c;", "getLOGGER", "()Lvc/c;", "Lio/ktor/client/plugins/api/ClientPlugin;", "Lio/ktor/client/plugins/sse/SSEConfig;", "SSE", "Lio/ktor/client/plugins/api/ClientPlugin;", "getSSE", "()Lio/ktor/client/plugins/api/ClientPlugin;", "getSSE$annotations", "()V", "Lio/ktor/client/HttpClient;", "SSEClientForReconnectionAttr", "Lio/ktor/util/AttributeKey;", "getSSEClientForReconnectionAttr", "()Lio/ktor/util/AttributeKey;", "", "SSEReconnectionRequestAttr", "getSSEReconnectionRequestAttr", "ktor-client-core"}, k = 2, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class SSEKt {
    private static final vc.c LOGGER = KtorSimpleLoggerJvmKt.KtorSimpleLogger("io.ktor.client.plugins.sse.SSE");
    private static final ClientPlugin<SSEConfig> SSE = CreatePluginUtilsKt.createClientPlugin("SSE", SSEKt$SSE$1.INSTANCE, new InterfaceC5074l() { // from class: io.ktor.client.plugins.sse.A
        @Override // p9.InterfaceC5074l
        public final Object invoke(Object obj) {
            return SSEKt.SSE$lambda$0((ClientPluginBuilder) obj);
        }
    });
    private static final AttributeKey<HttpClient> SSEClientForReconnectionAttr;
    private static final AttributeKey<Boolean> SSEReconnectionRequestAttr;

    @InterfaceC4112d(c = "io.ktor.client.plugins.sse.SSEKt", f = "SSE.kt", l = {202, 208}, m = "checkResponse")
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    /* renamed from: io.ktor.client.plugins.sse.SSEKt$checkResponse$1, reason: invalid class name */
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
            return SSEKt.checkResponse(null, this);
        }
    }

    @InterfaceC4112d(c = "io.ktor.client.plugins.sse.SSEKt", f = "SSE.kt", l = {215}, m = "saved")
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    /* renamed from: io.ktor.client.plugins.sse.SSEKt$saved$1, reason: invalid class name and case insensitive filesystem */
    public static final class C42351 extends ContinuationImpl {
        Object L$0;
        int label;
        /* synthetic */ Object result;

        public C42351(InterfaceC4014c<? super C42351> interfaceC4014c) {
            super(interfaceC4014c);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return SSEKt.saved(null, this);
        }
    }

    static {
        InterfaceC5755n interfaceC5755nM;
        InterfaceC5745d interfaceC5745dB = kotlin.jvm.internal.t.b(HttpClient.class);
        InterfaceC5755n interfaceC5755nM2 = null;
        try {
            interfaceC5755nM = kotlin.jvm.internal.t.m(HttpClient.class);
        } catch (Throwable unused) {
            interfaceC5755nM = null;
        }
        SSEClientForReconnectionAttr = new AttributeKey<>("SSEClientForReconnection", new TypeInfo(interfaceC5745dB, interfaceC5755nM));
        InterfaceC5745d interfaceC5745dB2 = kotlin.jvm.internal.t.b(Boolean.class);
        try {
            interfaceC5755nM2 = kotlin.jvm.internal.t.m(Boolean.TYPE);
        } catch (Throwable unused2) {
        }
        SSEReconnectionRequestAttr = new AttributeKey<>("SSEReconnectionRequestAttr", new TypeInfo(interfaceC5745dB2, interfaceC5755nM2));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Y8.t SSE$lambda$0(ClientPluginBuilder createClientPlugin) {
        kotlin.jvm.internal.p.i(createClientPlugin, "$this$createClientPlugin");
        createClientPlugin.on(AfterRender.INSTANCE, new SSEKt$SSE$2$1(createClientPlugin, ((SSEConfig) createClientPlugin.getPluginConfig()).getReconnectionTime(), ((SSEConfig) createClientPlugin.getPluginConfig()).getShowCommentEvents(), ((SSEConfig) createClientPlugin.getPluginConfig()).getShowRetryEvents(), ((SSEConfig) createClientPlugin.getPluginConfig()).getMaxReconnectionAttempts(), ((SSEConfig) createClientPlugin.getPluginConfig()).getBufferPolicy(), null));
        createClientPlugin.getClient().getResponsePipeline().intercept(HttpResponsePipeline.INSTANCE.getTransform(), new SSEKt$SSE$2$2(null));
        return Y8.t.f7040a;
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final java.lang.Object checkResponse(io.ktor.client.statement.HttpResponse r11, e9.InterfaceC4014c<? super Y8.t> r12) throws java.lang.Throwable {
        /*
            Method dump skipped, instructions count: 318
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: io.ktor.client.plugins.sse.SSEKt.checkResponse(io.ktor.client.statement.HttpResponse, e9.c):java.lang.Object");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final <T> T getAttributeValue(HttpRequestBuilder httpRequestBuilder, AttributeKey<T> attributeKey) {
        return (T) httpRequestBuilder.getAttributes().getOrNull(attributeKey);
    }

    public static final vc.c getLOGGER() {
        return LOGGER;
    }

    public static final ClientPlugin<SSEConfig> getSSE() {
        return SSE;
    }

    public static /* synthetic */ void getSSE$annotations() {
    }

    public static final AttributeKey<HttpClient> getSSEClientForReconnectionAttr() {
        return SSEClientForReconnectionAttr;
    }

    public static final AttributeKey<Boolean> getSSEReconnectionRequestAttr() {
        return SSEReconnectionRequestAttr;
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final java.lang.Object saved(io.ktor.client.statement.HttpResponse r4, e9.InterfaceC4014c<? super io.ktor.client.statement.HttpResponse> r5) throws java.lang.Throwable {
        /*
            boolean r0 = r5 instanceof io.ktor.client.plugins.sse.SSEKt.C42351
            if (r0 == 0) goto L13
            r0 = r5
            io.ktor.client.plugins.sse.SSEKt$saved$1 r0 = (io.ktor.client.plugins.sse.SSEKt.C42351) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            io.ktor.client.plugins.sse.SSEKt$saved$1 r0 = new io.ktor.client.plugins.sse.SSEKt$saved$1
            r0.<init>(r5)
        L18:
            java.lang.Object r5 = r0.result
            java.lang.Object r1 = f9.C4063a.g()
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L35
            if (r2 != r3) goto L2d
            java.lang.Object r4 = r0.L$0
            io.ktor.client.statement.HttpResponse r4 = (io.ktor.client.statement.HttpResponse) r4
            kotlin.C4849c.b(r5)
            goto L4b
        L2d:
            java.lang.IllegalStateException r4 = new java.lang.IllegalStateException
            java.lang.String r5 = "call to 'resume' before 'invoke' with coroutine"
            r4.<init>(r5)
            throw r4
        L35:
            kotlin.C4849c.b(r5)
            io.ktor.client.call.HttpClientCall r5 = r4.getCall()
            java.lang.Object r4 = g9.h.a(r4)
            r0.L$0 = r4
            r0.label = r3
            java.lang.Object r5 = io.ktor.client.call.SavedCallKt.save(r5, r0)
            if (r5 != r1) goto L4b
            return r1
        L4b:
            io.ktor.client.call.HttpClientCall r5 = (io.ktor.client.call.HttpClientCall) r5
            io.ktor.client.request.HttpRequest r4 = r5.getRequest()
            io.ktor.util.Attributes r4 = r4.getAttributes()
            io.ktor.util.AttributeKey r0 = io.ktor.client.plugins.sse.BuildersKt.getSseRequestAttr()
            r4.remove(r0)
            io.ktor.client.statement.HttpResponse r4 = r5.getResponse()
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: io.ktor.client.plugins.sse.SSEKt.saved(io.ktor.client.statement.HttpResponse, e9.c):java.lang.Object");
    }
}
