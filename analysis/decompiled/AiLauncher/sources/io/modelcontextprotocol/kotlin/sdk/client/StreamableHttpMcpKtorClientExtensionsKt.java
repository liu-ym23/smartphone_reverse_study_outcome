package io.modelcontextprotocol.kotlin.sdk.client;

import e9.InterfaceC4014c;
import io.ktor.client.HttpClient;
import io.ktor.client.request.HttpRequestBuilder;
import kotlin.Metadata;
import p9.InterfaceC5074l;

@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\u001a;\u0010\f\u001a\u00020\t*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u00012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\u0014\b\u0002\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u0005¢\u0006\u0004\b\n\u0010\u000b\u001a>\u0010\u0010\u001a\u00020\r*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u00012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\u0014\b\u0002\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u0005H\u0086@¢\u0006\u0004\b\u000e\u0010\u000f¨\u0006\u0011"}, d2 = {"Lio/ktor/client/HttpClient;", "", "url", "Lkotlin/time/a;", "reconnectionTime", "Lkotlin/Function1;", "Lio/ktor/client/request/HttpRequestBuilder;", "LY8/t;", "requestBuilder", "Lio/modelcontextprotocol/kotlin/sdk/client/StreamableHttpClientTransport;", "mcpStreamableHttpTransport-5_5nbZA", "(Lio/ktor/client/HttpClient;Ljava/lang/String;Lkotlin/time/a;Lp9/l;)Lio/modelcontextprotocol/kotlin/sdk/client/StreamableHttpClientTransport;", "mcpStreamableHttpTransport", "Lio/modelcontextprotocol/kotlin/sdk/client/Client;", "mcpStreamableHttp-BZiP2OM", "(Lio/ktor/client/HttpClient;Ljava/lang/String;Lkotlin/time/a;Lp9/l;Le9/c;)Ljava/lang/Object;", "mcpStreamableHttp", "kotlin-sdk"}, k = 2, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class StreamableHttpMcpKtorClientExtensionsKt {
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /* renamed from: mcpStreamableHttp-BZiP2OM, reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final java.lang.Object m234mcpStreamableHttpBZiP2OM(io.ktor.client.HttpClient r7, java.lang.String r8, kotlin.time.a r9, p9.InterfaceC5074l<? super io.ktor.client.request.HttpRequestBuilder, Y8.t> r10, e9.InterfaceC4014c<? super io.modelcontextprotocol.kotlin.sdk.client.Client> r11) throws java.lang.Throwable {
        /*
            boolean r0 = r11 instanceof io.modelcontextprotocol.kotlin.sdk.client.StreamableHttpMcpKtorClientExtensionsKt$mcpStreamableHttp$1
            if (r0 == 0) goto L13
            r0 = r11
            io.modelcontextprotocol.kotlin.sdk.client.StreamableHttpMcpKtorClientExtensionsKt$mcpStreamableHttp$1 r0 = (io.modelcontextprotocol.kotlin.sdk.client.StreamableHttpMcpKtorClientExtensionsKt$mcpStreamableHttp$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            io.modelcontextprotocol.kotlin.sdk.client.StreamableHttpMcpKtorClientExtensionsKt$mcpStreamableHttp$1 r0 = new io.modelcontextprotocol.kotlin.sdk.client.StreamableHttpMcpKtorClientExtensionsKt$mcpStreamableHttp$1
            r0.<init>(r11)
        L18:
            java.lang.Object r11 = r0.result
            java.lang.Object r1 = f9.C4063a.g()
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L49
            if (r2 != r3) goto L41
            java.lang.Object r7 = r0.L$5
            io.modelcontextprotocol.kotlin.sdk.client.Client r7 = (io.modelcontextprotocol.kotlin.sdk.client.Client) r7
            java.lang.Object r8 = r0.L$4
            io.modelcontextprotocol.kotlin.sdk.client.StreamableHttpClientTransport r8 = (io.modelcontextprotocol.kotlin.sdk.client.StreamableHttpClientTransport) r8
            java.lang.Object r8 = r0.L$3
            p9.l r8 = (p9.InterfaceC5074l) r8
            java.lang.Object r8 = r0.L$2
            kotlin.time.a r8 = (kotlin.time.a) r8
            java.lang.Object r8 = r0.L$1
            java.lang.String r8 = (java.lang.String) r8
            java.lang.Object r8 = r0.L$0
            io.ktor.client.HttpClient r8 = (io.ktor.client.HttpClient) r8
            kotlin.C4849c.b(r11)
            return r7
        L41:
            java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
            java.lang.String r8 = "call to 'resume' before 'invoke' with coroutine"
            r7.<init>(r8)
            throw r7
        L49:
            kotlin.C4849c.b(r11)
            io.modelcontextprotocol.kotlin.sdk.client.StreamableHttpClientTransport r11 = m236mcpStreamableHttpTransport5_5nbZA(r7, r8, r9, r10)
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
            java.lang.Object r7 = g9.h.a(r11)
            r0.L$4 = r7
            r0.L$5 = r2
            r0.label = r3
            java.lang.Object r7 = r2.connect(r11, r0)
            if (r7 != r1) goto L89
            return r1
        L89:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: io.modelcontextprotocol.kotlin.sdk.client.StreamableHttpMcpKtorClientExtensionsKt.m234mcpStreamableHttpBZiP2OM(io.ktor.client.HttpClient, java.lang.String, kotlin.time.a, p9.l, e9.c):java.lang.Object");
    }

    /* renamed from: mcpStreamableHttp-BZiP2OM$default, reason: not valid java name */
    public static /* synthetic */ Object m235mcpStreamableHttpBZiP2OM$default(HttpClient httpClient, String str, kotlin.time.a aVar, InterfaceC5074l interfaceC5074l, InterfaceC4014c interfaceC4014c, int i10, Object obj) {
        if ((i10 & 2) != 0) {
            aVar = null;
        }
        if ((i10 & 4) != 0) {
            interfaceC5074l = new InterfaceC5074l() { // from class: io.modelcontextprotocol.kotlin.sdk.client.Q
                @Override // p9.InterfaceC5074l
                public final Object invoke(Object obj2) {
                    return StreamableHttpMcpKtorClientExtensionsKt.mcpStreamableHttp_BZiP2OM$lambda$1((HttpRequestBuilder) obj2);
                }
            };
        }
        return m234mcpStreamableHttpBZiP2OM(httpClient, str, aVar, interfaceC5074l, interfaceC4014c);
    }

    /* renamed from: mcpStreamableHttpTransport-5_5nbZA, reason: not valid java name */
    public static final StreamableHttpClientTransport m236mcpStreamableHttpTransport5_5nbZA(HttpClient mcpStreamableHttpTransport, String url, kotlin.time.a aVar, InterfaceC5074l<? super HttpRequestBuilder, Y8.t> requestBuilder) {
        kotlin.jvm.internal.p.i(mcpStreamableHttpTransport, "$this$mcpStreamableHttpTransport");
        kotlin.jvm.internal.p.i(url, "url");
        kotlin.jvm.internal.p.i(requestBuilder, "requestBuilder");
        return new StreamableHttpClientTransport(mcpStreamableHttpTransport, url, aVar, requestBuilder, null);
    }

    /* renamed from: mcpStreamableHttpTransport-5_5nbZA$default, reason: not valid java name */
    public static /* synthetic */ StreamableHttpClientTransport m237mcpStreamableHttpTransport5_5nbZA$default(HttpClient httpClient, String str, kotlin.time.a aVar, InterfaceC5074l interfaceC5074l, int i10, Object obj) {
        if ((i10 & 2) != 0) {
            aVar = null;
        }
        if ((i10 & 4) != 0) {
            interfaceC5074l = new InterfaceC5074l() { // from class: io.modelcontextprotocol.kotlin.sdk.client.S
                @Override // p9.InterfaceC5074l
                public final Object invoke(Object obj2) {
                    return StreamableHttpMcpKtorClientExtensionsKt.mcpStreamableHttpTransport_5_5nbZA$lambda$0((HttpRequestBuilder) obj2);
                }
            };
        }
        return m236mcpStreamableHttpTransport5_5nbZA(httpClient, str, aVar, interfaceC5074l);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Y8.t mcpStreamableHttpTransport_5_5nbZA$lambda$0(HttpRequestBuilder httpRequestBuilder) {
        kotlin.jvm.internal.p.i(httpRequestBuilder, "<this>");
        return Y8.t.f7040a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Y8.t mcpStreamableHttp_BZiP2OM$lambda$1(HttpRequestBuilder httpRequestBuilder) {
        kotlin.jvm.internal.p.i(httpRequestBuilder, "<this>");
        return Y8.t.f7040a;
    }
}
