package io.modelcontextprotocol.kotlin.sdk.client;

import e9.InterfaceC4014c;
import g9.InterfaceC4112d;
import io.ktor.client.HttpClient;
import io.ktor.client.request.HttpRequestBuilder;
import kotlin.Metadata;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import p9.InterfaceC5074l;

@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a3\u0010\b\u001a\u00020\u0007*\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00012\u0014\b\u0002\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0003¢\u0006\u0004\b\b\u0010\t\u001a6\u0010\u000b\u001a\u00020\n*\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00012\u0014\b\u0002\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0003H\u0086@¢\u0006\u0004\b\u000b\u0010\f¨\u0006\r"}, d2 = {"Lio/ktor/client/HttpClient;", "", "urlString", "Lkotlin/Function1;", "Lio/ktor/client/request/HttpRequestBuilder;", "LY8/t;", "requestBuilder", "Lio/modelcontextprotocol/kotlin/sdk/client/WebSocketClientTransport;", "mcpWebSocketTransport", "(Lio/ktor/client/HttpClient;Ljava/lang/String;Lp9/l;)Lio/modelcontextprotocol/kotlin/sdk/client/WebSocketClientTransport;", "Lio/modelcontextprotocol/kotlin/sdk/client/Client;", "mcpWebSocket", "(Lio/ktor/client/HttpClient;Ljava/lang/String;Lp9/l;Le9/c;)Ljava/lang/Object;", "kotlin-sdk"}, k = 2, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class WebSocketMcpKtorClientExtensionsKt {

    @InterfaceC4112d(c = "io.modelcontextprotocol.kotlin.sdk.client.WebSocketMcpKtorClientExtensionsKt", f = "WebSocketMcpKtorClientExtensions.kt", l = {39}, m = "mcpWebSocket")
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    /* renamed from: io.modelcontextprotocol.kotlin.sdk.client.WebSocketMcpKtorClientExtensionsKt$mcpWebSocket$1, reason: invalid class name */
    public static final class AnonymousClass1 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        Object L$4;
        int label;
        /* synthetic */ Object result;

        public AnonymousClass1(InterfaceC4014c<? super AnonymousClass1> interfaceC4014c) {
            super(interfaceC4014c);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return WebSocketMcpKtorClientExtensionsKt.mcpWebSocket(null, null, null, this);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final java.lang.Object mcpWebSocket(io.ktor.client.HttpClient r7, java.lang.String r8, p9.InterfaceC5074l<? super io.ktor.client.request.HttpRequestBuilder, Y8.t> r9, e9.InterfaceC4014c<? super io.modelcontextprotocol.kotlin.sdk.client.Client> r10) throws java.lang.Throwable {
        /*
            boolean r0 = r10 instanceof io.modelcontextprotocol.kotlin.sdk.client.WebSocketMcpKtorClientExtensionsKt.AnonymousClass1
            if (r0 == 0) goto L13
            r0 = r10
            io.modelcontextprotocol.kotlin.sdk.client.WebSocketMcpKtorClientExtensionsKt$mcpWebSocket$1 r0 = (io.modelcontextprotocol.kotlin.sdk.client.WebSocketMcpKtorClientExtensionsKt.AnonymousClass1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            io.modelcontextprotocol.kotlin.sdk.client.WebSocketMcpKtorClientExtensionsKt$mcpWebSocket$1 r0 = new io.modelcontextprotocol.kotlin.sdk.client.WebSocketMcpKtorClientExtensionsKt$mcpWebSocket$1
            r0.<init>(r10)
        L18:
            java.lang.Object r10 = r0.result
            java.lang.Object r1 = f9.C4063a.g()
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L45
            if (r2 != r3) goto L3d
            java.lang.Object r7 = r0.L$4
            io.modelcontextprotocol.kotlin.sdk.client.Client r7 = (io.modelcontextprotocol.kotlin.sdk.client.Client) r7
            java.lang.Object r8 = r0.L$3
            io.modelcontextprotocol.kotlin.sdk.client.WebSocketClientTransport r8 = (io.modelcontextprotocol.kotlin.sdk.client.WebSocketClientTransport) r8
            java.lang.Object r8 = r0.L$2
            p9.l r8 = (p9.InterfaceC5074l) r8
            java.lang.Object r8 = r0.L$1
            java.lang.String r8 = (java.lang.String) r8
            java.lang.Object r8 = r0.L$0
            io.ktor.client.HttpClient r8 = (io.ktor.client.HttpClient) r8
            kotlin.C4849c.b(r10)
            return r7
        L3d:
            java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
            java.lang.String r8 = "call to 'resume' before 'invoke' with coroutine"
            r7.<init>(r8)
            throw r7
        L45:
            kotlin.C4849c.b(r10)
            io.modelcontextprotocol.kotlin.sdk.client.WebSocketClientTransport r10 = mcpWebSocketTransport(r7, r8, r9)
            io.modelcontextprotocol.kotlin.sdk.client.Client r2 = new io.modelcontextprotocol.kotlin.sdk.client.Client
            io.modelcontextprotocol.kotlin.sdk.Implementation r4 = new io.modelcontextprotocol.kotlin.sdk.Implementation
            java.lang.String r5 = "mcp-ktor"
            java.lang.String r6 = "0.6.0"
            r4.<init>(r5, r6)
            r5 = 2
            r6 = 0
            r2.<init>(r4, r6, r5, r6)
            java.lang.Object r7 = g9.h.a(r7)
            r0.L$0 = r7
            java.lang.Object r7 = g9.h.a(r8)
            r0.L$1 = r7
            java.lang.Object r7 = g9.h.a(r9)
            r0.L$2 = r7
            java.lang.Object r7 = g9.h.a(r10)
            r0.L$3 = r7
            r0.L$4 = r2
            r0.label = r3
            java.lang.Object r7 = r2.connect(r10, r0)
            if (r7 != r1) goto L7f
            return r1
        L7f:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: io.modelcontextprotocol.kotlin.sdk.client.WebSocketMcpKtorClientExtensionsKt.mcpWebSocket(io.ktor.client.HttpClient, java.lang.String, p9.l, e9.c):java.lang.Object");
    }

    public static /* synthetic */ Object mcpWebSocket$default(HttpClient httpClient, String str, InterfaceC5074l interfaceC5074l, InterfaceC4014c interfaceC4014c, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            str = null;
        }
        if ((i10 & 2) != 0) {
            interfaceC5074l = new InterfaceC5074l() { // from class: io.modelcontextprotocol.kotlin.sdk.client.X
                @Override // p9.InterfaceC5074l
                public final Object invoke(Object obj2) {
                    return WebSocketMcpKtorClientExtensionsKt.mcpWebSocket$lambda$1((HttpRequestBuilder) obj2);
                }
            };
        }
        return mcpWebSocket(httpClient, str, interfaceC5074l, interfaceC4014c);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Y8.t mcpWebSocket$lambda$1(HttpRequestBuilder httpRequestBuilder) {
        kotlin.jvm.internal.p.i(httpRequestBuilder, "<this>");
        return Y8.t.f7040a;
    }

    public static final WebSocketClientTransport mcpWebSocketTransport(HttpClient httpClient, String str, InterfaceC5074l<? super HttpRequestBuilder, Y8.t> requestBuilder) {
        kotlin.jvm.internal.p.i(httpClient, "<this>");
        kotlin.jvm.internal.p.i(requestBuilder, "requestBuilder");
        return new WebSocketClientTransport(httpClient, str, requestBuilder);
    }

    public static /* synthetic */ WebSocketClientTransport mcpWebSocketTransport$default(HttpClient httpClient, String str, InterfaceC5074l interfaceC5074l, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            str = null;
        }
        if ((i10 & 2) != 0) {
            interfaceC5074l = new InterfaceC5074l() { // from class: io.modelcontextprotocol.kotlin.sdk.client.W
                @Override // p9.InterfaceC5074l
                public final Object invoke(Object obj2) {
                    return WebSocketMcpKtorClientExtensionsKt.mcpWebSocketTransport$lambda$0((HttpRequestBuilder) obj2);
                }
            };
        }
        return mcpWebSocketTransport(httpClient, str, interfaceC5074l);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Y8.t mcpWebSocketTransport$lambda$0(HttpRequestBuilder httpRequestBuilder) {
        kotlin.jvm.internal.p.i(httpRequestBuilder, "<this>");
        return Y8.t.f7040a;
    }
}
