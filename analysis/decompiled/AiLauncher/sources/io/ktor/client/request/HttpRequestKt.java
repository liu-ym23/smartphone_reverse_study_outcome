package io.ktor.client.request;

import io.ktor.client.plugins.sse.SSEClientContent;
import io.ktor.client.plugins.sse.SSEKt;
import io.ktor.client.request.HttpRequestBuilder;
import io.ktor.http.HeadersBuilder;
import io.ktor.http.HttpHeaders;
import io.ktor.http.HttpMessageBuilder;
import io.ktor.http.HttpMethodKt;
import io.ktor.http.URLBuilder;
import io.ktor.http.URLBuilderKt;
import io.ktor.http.URLParserKt;
import io.ktor.http.URLUtilsKt;
import io.ktor.http.content.OutgoingContentKt;
import io.ktor.util.AttributeKey;
import io.ktor.util.AttributesKt;
import io.ktor.util.reflect.TypeInfo;
import io.ktor.utils.io.InternalAPI;
import kotlin.Metadata;
import p9.InterfaceC5074l;
import w9.InterfaceC5745d;
import w9.InterfaceC5755n;

@Metadata(d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\u001a3\u0010\u0005\u001a\u00020\u0003*\u00020\u00002\u001a\b\u0004\u0010\u0004\u001a\u0014\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001H\u0087\bø\u0001\u0000¢\u0006\u0004\b\u0005\u0010\u0006\u001a%\u0010\n\u001a\u00020\t*\u00020\u00072\u0012\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\u00030\b¢\u0006\u0004\b\n\u0010\u000b\u001a\u0019\u0010\u000f\u001a\u00020\f*\u00020\f2\u0006\u0010\u000e\u001a\u00020\r¢\u0006\u0004\b\u000f\u0010\u0010\u001a%\u0010\u0012\u001a\u00020\u0003*\u00020\f2\u0012\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0011\u0012\u0004\u0012\u00020\u00030\b¢\u0006\u0004\b\u0012\u0010\u0013\u001a\u0019\u0010\u000f\u001a\u00020\f*\u00020\f2\u0006\u0010\u000e\u001a\u00020\u0000¢\u0006\u0004\b\u000f\u0010\u0014\u001a(\u0010\u0016\u001a\u00020\f*\u00020\u00152\u0012\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0011\u0012\u0004\u0012\u00020\u00030\bH\u0086\u0002¢\u0006\u0004\b\u0016\u0010\u0017\u001aW\u0010\u0012\u001a\u00020\u0003*\u00020\f2\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\u0019\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\u001b\u001a\u0004\u0018\u00010\u001a2\n\b\u0002\u0010\u001c\u001a\u0004\u0018\u00010\u00022\u0014\b\u0002\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0011\u0012\u0004\u0012\u00020\u00030\b¢\u0006\u0004\b\u0012\u0010\u001d\u001aZ\u0010\u0016\u001a\u00020\f*\u00020\u00152\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\u0019\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\u001b\u001a\u0004\u0018\u00010\u001a2\n\b\u0002\u0010\u001c\u001a\u0004\u0018\u00010\u00022\u0014\b\u0002\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0011\u0012\u0004\u0012\u00020\u00030\bH\u0086\u0002¢\u0006\u0004\b\u0016\u0010\u001e\u001a\u0019\u0010\u0012\u001a\u00020\u0003*\u00020\f2\u0006\u0010\u001f\u001a\u00020\u0002¢\u0006\u0004\b\u0012\u0010 \u001a\u0013\u0010\"\u001a\u00020!*\u00020\u0000H\u0007¢\u0006\u0004\b\"\u0010#\u001a\u0013\u0010$\u001a\u00020!*\u00020\u0000H\u0007¢\u0006\u0004\b$\u0010#\u001a\u0013\u0010%\u001a\u00020!*\u00020\u0000H\u0007¢\u0006\u0004\b%\u0010#\"&\u0010(\u001a\b\u0012\u0004\u0012\u00020'0&8\u0006X\u0087\u0004¢\u0006\u0012\n\u0004\b(\u0010)\u0012\u0004\b,\u0010-\u001a\u0004\b*\u0010+\u0082\u0002\u0007\n\u0005\b\u009920\u0001¨\u0006."}, d2 = {"Lio/ktor/client/request/HttpRequestData;", "Lkotlin/Function2;", "", "LY8/t;", "block", "forEachHeader", "(Lio/ktor/client/request/HttpRequestData;Lp9/p;)V", "Lio/ktor/http/HttpMessageBuilder;", "Lkotlin/Function1;", "Lio/ktor/http/HeadersBuilder;", "headers", "(Lio/ktor/http/HttpMessageBuilder;Lp9/l;)Lio/ktor/http/HeadersBuilder;", "Lio/ktor/client/request/HttpRequestBuilder;", "Lio/ktor/client/request/HttpRequest;", "request", "takeFrom", "(Lio/ktor/client/request/HttpRequestBuilder;Lio/ktor/client/request/HttpRequest;)Lio/ktor/client/request/HttpRequestBuilder;", "Lio/ktor/http/URLBuilder;", "url", "(Lio/ktor/client/request/HttpRequestBuilder;Lp9/l;)V", "(Lio/ktor/client/request/HttpRequestBuilder;Lio/ktor/client/request/HttpRequestData;)Lio/ktor/client/request/HttpRequestBuilder;", "Lio/ktor/client/request/HttpRequestBuilder$Companion;", "invoke", "(Lio/ktor/client/request/HttpRequestBuilder$Companion;Lp9/l;)Lio/ktor/client/request/HttpRequestBuilder;", "scheme", "host", "", "port", "path", "(Lio/ktor/client/request/HttpRequestBuilder;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;Lp9/l;)V", "(Lio/ktor/client/request/HttpRequestBuilder$Companion;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;Lp9/l;)Lio/ktor/client/request/HttpRequestBuilder;", "urlString", "(Lio/ktor/client/request/HttpRequestBuilder;Ljava/lang/String;)V", "", "isUpgradeRequest", "(Lio/ktor/client/request/HttpRequestData;)Z", "isSseRequest", "isSseReconnectionRequest", "Lio/ktor/util/AttributeKey;", "Lio/ktor/client/request/ResponseAdapter;", "ResponseAdapterAttributeKey", "Lio/ktor/util/AttributeKey;", "getResponseAdapterAttributeKey", "()Lio/ktor/util/AttributeKey;", "getResponseAdapterAttributeKey$annotations", "()V", "ktor-client-core"}, k = 2, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class HttpRequestKt {
    private static final AttributeKey<ResponseAdapter> ResponseAdapterAttributeKey;

    static {
        InterfaceC5755n interfaceC5755nM;
        InterfaceC5745d interfaceC5745dB = kotlin.jvm.internal.t.b(ResponseAdapter.class);
        try {
            interfaceC5755nM = kotlin.jvm.internal.t.m(ResponseAdapter.class);
        } catch (Throwable unused) {
            interfaceC5755nM = null;
        }
        ResponseAdapterAttributeKey = new AttributeKey<>("ResponseAdapterAttributeKey", new TypeInfo(interfaceC5745dB, interfaceC5755nM));
    }

    @InternalAPI
    public static final void forEachHeader(HttpRequestData httpRequestData, final p9.p<? super String, ? super String, Y8.t> block) {
        kotlin.jvm.internal.p.i(httpRequestData, "<this>");
        kotlin.jvm.internal.p.i(block, "block");
        final boolean z10 = !HttpMethodKt.getSupportsRequestBody(httpRequestData.getMethod()) && OutgoingContentKt.isEmpty(httpRequestData.getBody());
        io.ktor.client.engine.UtilsKt.mergeHeaders(httpRequestData.getHeaders(), httpRequestData.getBody(), new p9.p<String, String, Y8.t>() { // from class: io.ktor.client.request.HttpRequestKt.forEachHeader.1
            @Override // p9.p
            public /* bridge */ /* synthetic */ Y8.t invoke(String str, String str2) {
                invoke2(str, str2);
                return Y8.t.f7040a;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(String key, String value) {
                kotlin.jvm.internal.p.i(key, "key");
                kotlin.jvm.internal.p.i(value, "value");
                if (z10 && kotlin.jvm.internal.p.d(key, HttpHeaders.INSTANCE.getContentLength())) {
                    return;
                }
                block.invoke(key, value);
            }
        });
    }

    public static final AttributeKey<ResponseAdapter> getResponseAdapterAttributeKey() {
        return ResponseAdapterAttributeKey;
    }

    @InternalAPI
    public static /* synthetic */ void getResponseAdapterAttributeKey$annotations() {
    }

    public static final HeadersBuilder headers(HttpMessageBuilder httpMessageBuilder, InterfaceC5074l<? super HeadersBuilder, Y8.t> block) {
        kotlin.jvm.internal.p.i(httpMessageBuilder, "<this>");
        kotlin.jvm.internal.p.i(block, "block");
        HeadersBuilder headers = httpMessageBuilder.getHeaders();
        block.invoke(headers);
        return headers;
    }

    public static final HttpRequestBuilder invoke(HttpRequestBuilder.Companion companion, InterfaceC5074l<? super URLBuilder, Y8.t> block) {
        kotlin.jvm.internal.p.i(companion, "<this>");
        kotlin.jvm.internal.p.i(block, "block");
        HttpRequestBuilder httpRequestBuilder = new HttpRequestBuilder();
        url(httpRequestBuilder, block);
        return httpRequestBuilder;
    }

    public static /* synthetic */ HttpRequestBuilder invoke$default(HttpRequestBuilder.Companion companion, String str, String str2, Integer num, String str3, InterfaceC5074l interfaceC5074l, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            str = null;
        }
        if ((i10 & 2) != 0) {
            str2 = null;
        }
        if ((i10 & 4) != 0) {
            num = null;
        }
        if ((i10 & 8) != 0) {
            str3 = null;
        }
        if ((i10 & 16) != 0) {
            interfaceC5074l = new InterfaceC5074l() { // from class: io.ktor.client.request.s
                @Override // p9.InterfaceC5074l
                public final Object invoke(Object obj2) {
                    return HttpRequestKt.invoke$lambda$2((URLBuilder) obj2);
                }
            };
        }
        return invoke(companion, str, str2, num, str3, interfaceC5074l);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Y8.t invoke$lambda$2(URLBuilder uRLBuilder) {
        kotlin.jvm.internal.p.i(uRLBuilder, "<this>");
        return Y8.t.f7040a;
    }

    @InternalAPI
    public static final boolean isSseReconnectionRequest(HttpRequestData httpRequestData) {
        kotlin.jvm.internal.p.i(httpRequestData, "<this>");
        return kotlin.jvm.internal.p.d(httpRequestData.getAttributes().getOrNull(SSEKt.getSSEReconnectionRequestAttr()), Boolean.TRUE);
    }

    @InternalAPI
    public static final boolean isSseRequest(HttpRequestData httpRequestData) {
        kotlin.jvm.internal.p.i(httpRequestData, "<this>");
        return httpRequestData.getBody() instanceof SSEClientContent;
    }

    @InternalAPI
    public static final boolean isUpgradeRequest(HttpRequestData httpRequestData) {
        kotlin.jvm.internal.p.i(httpRequestData, "<this>");
        return httpRequestData.getBody() instanceof ClientUpgradeContent;
    }

    public static final HttpRequestBuilder takeFrom(HttpRequestBuilder httpRequestBuilder, HttpRequest request) {
        kotlin.jvm.internal.p.i(httpRequestBuilder, "<this>");
        kotlin.jvm.internal.p.i(request, "request");
        httpRequestBuilder.setMethod(request.getMethod());
        httpRequestBuilder.setBody(request.getContent());
        httpRequestBuilder.setBodyType((TypeInfo) httpRequestBuilder.getAttributes().getOrNull(RequestBodyKt.getBodyTypeAttributeKey()));
        URLUtilsKt.takeFrom(httpRequestBuilder.getUrl(), request.getUrl());
        httpRequestBuilder.getHeaders().appendAll(request.getHeaders());
        AttributesKt.putAll(httpRequestBuilder.getAttributes(), request.getAttributes());
        return httpRequestBuilder;
    }

    public static final void url(HttpRequestBuilder httpRequestBuilder, InterfaceC5074l<? super URLBuilder, Y8.t> block) {
        kotlin.jvm.internal.p.i(httpRequestBuilder, "<this>");
        kotlin.jvm.internal.p.i(block, "block");
        block.invoke(httpRequestBuilder.getUrl());
    }

    public static /* synthetic */ void url$default(HttpRequestBuilder httpRequestBuilder, String str, String str2, Integer num, String str3, InterfaceC5074l interfaceC5074l, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            str = null;
        }
        if ((i10 & 2) != 0) {
            str2 = null;
        }
        if ((i10 & 4) != 0) {
            num = null;
        }
        if ((i10 & 8) != 0) {
            str3 = null;
        }
        if ((i10 & 16) != 0) {
            interfaceC5074l = new InterfaceC5074l() { // from class: io.ktor.client.request.t
                @Override // p9.InterfaceC5074l
                public final Object invoke(Object obj2) {
                    return HttpRequestKt.url$lambda$1((URLBuilder) obj2);
                }
            };
        }
        url(httpRequestBuilder, str, str2, num, str3, interfaceC5074l);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Y8.t url$lambda$1(URLBuilder uRLBuilder) {
        kotlin.jvm.internal.p.i(uRLBuilder, "<this>");
        return Y8.t.f7040a;
    }

    public static final HttpRequestBuilder invoke(HttpRequestBuilder.Companion companion, String str, String str2, Integer num, String str3, InterfaceC5074l<? super URLBuilder, Y8.t> block) {
        kotlin.jvm.internal.p.i(companion, "<this>");
        kotlin.jvm.internal.p.i(block, "block");
        HttpRequestBuilder httpRequestBuilder = new HttpRequestBuilder();
        url(httpRequestBuilder, str, str2, num, str3, block);
        return httpRequestBuilder;
    }

    public static final void url(HttpRequestBuilder httpRequestBuilder, String str, String str2, Integer num, String str3, InterfaceC5074l<? super URLBuilder, Y8.t> block) {
        kotlin.jvm.internal.p.i(httpRequestBuilder, "<this>");
        kotlin.jvm.internal.p.i(block, "block");
        URLBuilderKt.set(httpRequestBuilder.getUrl(), str, str2, num, str3, block);
    }

    public static final void url(HttpRequestBuilder httpRequestBuilder, String urlString) {
        kotlin.jvm.internal.p.i(httpRequestBuilder, "<this>");
        kotlin.jvm.internal.p.i(urlString, "urlString");
        URLParserKt.takeFrom(httpRequestBuilder.getUrl(), urlString);
    }

    public static final HttpRequestBuilder takeFrom(HttpRequestBuilder httpRequestBuilder, HttpRequestData request) {
        kotlin.jvm.internal.p.i(httpRequestBuilder, "<this>");
        kotlin.jvm.internal.p.i(request, "request");
        httpRequestBuilder.setMethod(request.getMethod());
        httpRequestBuilder.setBody(request.getBody());
        httpRequestBuilder.setBodyType((TypeInfo) httpRequestBuilder.getAttributes().getOrNull(RequestBodyKt.getBodyTypeAttributeKey()));
        URLUtilsKt.takeFrom(httpRequestBuilder.getUrl(), request.getUrl());
        httpRequestBuilder.getHeaders().appendAll(request.getHeaders());
        AttributesKt.putAll(httpRequestBuilder.getAttributes(), request.getAttributes());
        return httpRequestBuilder;
    }
}
