package io.modelcontextprotocol.kotlin.sdk.client;

import e9.InterfaceC4014c;
import g9.InterfaceC4112d;
import io.ktor.client.HttpClient;
import io.ktor.client.request.HttpRequestBuilder;
import io.ktor.client.request.UtilsKt;
import io.ktor.http.HttpHeaders;
import io.ktor.websocket.WebSocketSession;
import io.modelcontextprotocol.kotlin.sdk.shared.WebSocketMcpTransport;
import io.modelcontextprotocol.kotlin.sdk.shared.WebSocketMcpTransportKt;
import kotlin.Metadata;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.jvm.internal.MutablePropertyReference1Impl;
import p9.InterfaceC5074l;
import s9.C5449a;
import s9.InterfaceC5453e;
import w9.InterfaceC5752k;

@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u00002\u00020\u0001B/\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u0012\u0014\b\u0002\u0010\t\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b0\u0006¢\u0006\u0004\b\n\u0010\u000bJ\u0010\u0010\f\u001a\u00020\bH\u0094@¢\u0006\u0004\b\f\u0010\rR\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0003\u0010\u000eR\u0016\u0010\u0005\u001a\u0004\u0018\u00010\u00048\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0005\u0010\u000fR \u0010\t\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b0\u00068\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\t\u0010\u0010R+\u0010\u0019\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00118T@TX\u0094\u008e\u0002¢\u0006\u0012\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018¨\u0006\u001a"}, d2 = {"Lio/modelcontextprotocol/kotlin/sdk/client/WebSocketClientTransport;", "Lio/modelcontextprotocol/kotlin/sdk/shared/WebSocketMcpTransport;", "Lio/ktor/client/HttpClient;", "client", "", "urlString", "Lkotlin/Function1;", "Lio/ktor/client/request/HttpRequestBuilder;", "LY8/t;", "requestBuilder", "<init>", "(Lio/ktor/client/HttpClient;Ljava/lang/String;Lp9/l;)V", "initializeSession", "(Le9/c;)Ljava/lang/Object;", "Lio/ktor/client/HttpClient;", "Ljava/lang/String;", "Lp9/l;", "Lio/ktor/websocket/WebSocketSession;", "<set-?>", "session$delegate", "Ls9/e;", "getSession", "()Lio/ktor/websocket/WebSocketSession;", "setSession", "(Lio/ktor/websocket/WebSocketSession;)V", "session", "kotlin-sdk"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class WebSocketClientTransport extends WebSocketMcpTransport {
    static final /* synthetic */ InterfaceC5752k<Object>[] $$delegatedProperties = {kotlin.jvm.internal.t.f(new MutablePropertyReference1Impl(WebSocketClientTransport.class, "session", "getSession()Lio/ktor/websocket/WebSocketSession;", 0))};
    private final HttpClient client;
    private final InterfaceC5074l<HttpRequestBuilder, Y8.t> requestBuilder;

    /* renamed from: session$delegate, reason: from kotlin metadata */
    private final InterfaceC5453e session;
    private final String urlString;

    @InterfaceC4112d(c = "io.modelcontextprotocol.kotlin.sdk.client.WebSocketClientTransport", f = "WebSocketClientTransport.kt", l = {25, 30}, m = "initializeSession")
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    /* renamed from: io.modelcontextprotocol.kotlin.sdk.client.WebSocketClientTransport$initializeSession$1, reason: invalid class name */
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
            return WebSocketClientTransport.this.initializeSession(this);
        }
    }

    public /* synthetic */ WebSocketClientTransport(HttpClient httpClient, String str, InterfaceC5074l interfaceC5074l, int i10, kotlin.jvm.internal.i iVar) {
        this(httpClient, str, (i10 & 4) != 0 ? new InterfaceC5074l() { // from class: io.modelcontextprotocol.kotlin.sdk.client.V
            @Override // p9.InterfaceC5074l
            public final Object invoke(Object obj) {
                return WebSocketClientTransport._init_$lambda$0((HttpRequestBuilder) obj);
            }
        } : interfaceC5074l);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Y8.t _init_$lambda$0(HttpRequestBuilder httpRequestBuilder) {
        kotlin.jvm.internal.p.i(httpRequestBuilder, "<this>");
        return Y8.t.f7040a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Y8.t initializeSession$lambda$2$lambda$1(WebSocketClientTransport webSocketClientTransport, HttpRequestBuilder webSocketSession) {
        kotlin.jvm.internal.p.i(webSocketSession, "$this$webSocketSession");
        webSocketClientTransport.requestBuilder.invoke(webSocketSession);
        UtilsKt.header(webSocketSession, HttpHeaders.INSTANCE.getSecWebSocketProtocol(), WebSocketMcpTransportKt.MCP_SUBPROTOCOL);
        return Y8.t.f7040a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Y8.t initializeSession$lambda$3(WebSocketClientTransport webSocketClientTransport, HttpRequestBuilder webSocketSession) {
        kotlin.jvm.internal.p.i(webSocketSession, "$this$webSocketSession");
        webSocketClientTransport.requestBuilder.invoke(webSocketSession);
        UtilsKt.header(webSocketSession, HttpHeaders.INSTANCE.getSecWebSocketProtocol(), WebSocketMcpTransportKt.MCP_SUBPROTOCOL);
        return Y8.t.f7040a;
    }

    @Override // io.modelcontextprotocol.kotlin.sdk.shared.WebSocketMcpTransport
    public WebSocketSession getSession() {
        return (WebSocketSession) this.session.getValue(this, $$delegatedProperties[0]);
    }

    /* JADX WARN: Code restructure failed: missing block: B:23:0x0069, code lost:
    
        if (r8 != null) goto L31;
     */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    @Override // io.modelcontextprotocol.kotlin.sdk.shared.WebSocketMcpTransport
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public java.lang.Object initializeSession(e9.InterfaceC4014c<? super Y8.t> r8) throws java.lang.Throwable {
        /*
            r7 = this;
            boolean r0 = r8 instanceof io.modelcontextprotocol.kotlin.sdk.client.WebSocketClientTransport.AnonymousClass1
            if (r0 == 0) goto L13
            r0 = r8
            io.modelcontextprotocol.kotlin.sdk.client.WebSocketClientTransport$initializeSession$1 r0 = (io.modelcontextprotocol.kotlin.sdk.client.WebSocketClientTransport.AnonymousClass1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            io.modelcontextprotocol.kotlin.sdk.client.WebSocketClientTransport$initializeSession$1 r0 = new io.modelcontextprotocol.kotlin.sdk.client.WebSocketClientTransport$initializeSession$1
            r0.<init>(r8)
        L18:
            java.lang.Object r8 = r0.result
            java.lang.Object r1 = f9.C4063a.g()
            int r2 = r0.label
            r3 = 2
            r4 = 1
            if (r2 == 0) goto L44
            if (r2 == r4) goto L38
            if (r2 != r3) goto L30
            java.lang.Object r7 = r0.L$0
            io.modelcontextprotocol.kotlin.sdk.client.WebSocketClientTransport r7 = (io.modelcontextprotocol.kotlin.sdk.client.WebSocketClientTransport) r7
            kotlin.C4849c.b(r8)
            goto L83
        L30:
            java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
            java.lang.String r8 = "call to 'resume' before 'invoke' with coroutine"
            r7.<init>(r8)
            throw r7
        L38:
            java.lang.Object r2 = r0.L$1
            io.modelcontextprotocol.kotlin.sdk.client.WebSocketClientTransport r2 = (io.modelcontextprotocol.kotlin.sdk.client.WebSocketClientTransport) r2
            java.lang.Object r4 = r0.L$0
            java.lang.String r4 = (java.lang.String) r4
            kotlin.C4849c.b(r8)
            goto L67
        L44:
            kotlin.C4849c.b(r8)
            java.lang.String r8 = r7.urlString
            if (r8 == 0) goto L6c
            io.ktor.client.HttpClient r2 = r7.client
            io.modelcontextprotocol.kotlin.sdk.client.T r5 = new io.modelcontextprotocol.kotlin.sdk.client.T
            r5.<init>()
            java.lang.Object r6 = g9.h.a(r8)
            r0.L$0 = r6
            r0.L$1 = r7
            r6 = 0
            r0.I$0 = r6
            r0.label = r4
            java.lang.Object r8 = io.ktor.client.plugins.websocket.BuildersKt.webSocketSession(r2, r8, r5, r0)
            if (r8 != r1) goto L66
            goto L81
        L66:
            r2 = r7
        L67:
            io.ktor.client.plugins.websocket.DefaultClientWebSocketSession r8 = (io.ktor.client.plugins.websocket.DefaultClientWebSocketSession) r8
            if (r8 == 0) goto L6d
            goto L86
        L6c:
            r2 = r7
        L6d:
            io.ktor.client.HttpClient r8 = r7.client
            io.modelcontextprotocol.kotlin.sdk.client.U r4 = new io.modelcontextprotocol.kotlin.sdk.client.U
            r4.<init>()
            r0.L$0 = r2
            r7 = 0
            r0.L$1 = r7
            r0.label = r3
            java.lang.Object r8 = io.ktor.client.plugins.websocket.BuildersKt.webSocketSession(r8, r4, r0)
            if (r8 != r1) goto L82
        L81:
            return r1
        L82:
            r7 = r2
        L83:
            io.ktor.websocket.WebSocketSession r8 = (io.ktor.websocket.WebSocketSession) r8
            r2 = r7
        L86:
            r2.setSession(r8)
            Y8.t r7 = Y8.t.f7040a
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: io.modelcontextprotocol.kotlin.sdk.client.WebSocketClientTransport.initializeSession(e9.c):java.lang.Object");
    }

    public void setSession(WebSocketSession webSocketSession) {
        kotlin.jvm.internal.p.i(webSocketSession, "<set-?>");
        this.session.setValue(this, $$delegatedProperties[0], webSocketSession);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public WebSocketClientTransport(HttpClient client, String str, InterfaceC5074l<? super HttpRequestBuilder, Y8.t> requestBuilder) {
        kotlin.jvm.internal.p.i(client, "client");
        kotlin.jvm.internal.p.i(requestBuilder, "requestBuilder");
        this.client = client;
        this.urlString = str;
        this.requestBuilder = requestBuilder;
        this.session = C5449a.f40169a.a();
    }
}
