package io.ktor.client.request;

import Ua.L0;
import androidx.exifinterface.media.ExifInterface;
import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;
import com.stepos.statsapp.v3.lib.plugin.constants.UxipConstants;
import io.ktor.client.engine.HttpClientEngineCapability;
import io.ktor.client.engine.HttpClientEngineCapabilityKt;
import io.ktor.client.utils.EmptyContent;
import io.ktor.http.Headers;
import io.ktor.http.HeadersBuilder;
import io.ktor.http.HttpMessageBuilder;
import io.ktor.http.HttpMethod;
import io.ktor.http.URLBuilder;
import io.ktor.http.URLUtilsKt;
import io.ktor.http.Url;
import io.ktor.http.content.OutgoingContent;
import io.ktor.util.Attributes;
import io.ktor.util.AttributesJvmKt;
import io.ktor.util.AttributesKt;
import io.ktor.util.StringValuesKt;
import io.ktor.util.reflect.TypeInfo;
import io.ktor.utils.io.InternalAPI;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import p9.InterfaceC5063a;
import p9.InterfaceC5074l;

@Metadata(d1 = {"\u0000^\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 E2\u00020\u0001:\u0001EB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J'\u0010\b\u001a\u00020\u00062\u0018\u0010\u0007\u001a\u0014\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u0004¢\u0006\u0004\b\b\u0010\tJ\r\u0010\u000b\u001a\u00020\n¢\u0006\u0004\b\u000b\u0010\fJ!\u0010\u000f\u001a\u00020\u00062\u0012\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u00060\r¢\u0006\u0004\b\u000f\u0010\u0010J\u0017\u0010\u0012\u001a\u00020\u00002\u0006\u0010\u0011\u001a\u00020\u0000H\u0007¢\u0006\u0004\b\u0012\u0010\u0013J\u0015\u0010\u0014\u001a\u00020\u00002\u0006\u0010\u0011\u001a\u00020\u0000¢\u0006\u0004\b\u0014\u0010\u0013J-\u0010\u001a\u001a\u00020\u0006\"\b\b\u0000\u0010\u0016*\u00020\u00152\f\u0010\u0018\u001a\b\u0012\u0004\u0012\u00028\u00000\u00172\u0006\u0010\u0019\u001a\u00028\u0000¢\u0006\u0004\b\u001a\u0010\u001bJ'\u0010\u001c\u001a\u0004\u0018\u00018\u0000\"\b\b\u0000\u0010\u0016*\u00020\u00152\f\u0010\u0018\u001a\b\u0012\u0004\u0012\u00028\u00000\u0017¢\u0006\u0004\b\u001c\u0010\u001dR\u0017\u0010\b\u001a\u00020\u00058\u0006¢\u0006\f\n\u0004\b\b\u0010\u001e\u001a\u0004\b\u001f\u0010 R\"\u0010\"\u001a\u00020!8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\"\u0010#\u001a\u0004\b$\u0010%\"\u0004\b&\u0010'R\u001a\u0010)\u001a\u00020(8\u0016X\u0096\u0004¢\u0006\f\n\u0004\b)\u0010*\u001a\u0004\b+\u0010,R*\u0010.\u001a\u00020\u00152\u0006\u0010-\u001a\u00020\u00158\u0006@GX\u0086\u000e¢\u0006\u0012\n\u0004\b.\u0010/\u001a\u0004\b0\u00101\"\u0004\b2\u00103R*\u00105\u001a\u0002042\u0006\u0010-\u001a\u0002048\u0006@@X\u0086\u000e¢\u0006\u0012\n\u0004\b5\u00106\u001a\u0004\b7\u00108\"\u0004\b9\u0010:R\u0017\u0010;\u001a\u00020\u000e8\u0006¢\u0006\f\n\u0004\b;\u0010<\u001a\u0004\b=\u0010>R(\u0010D\u001a\u0004\u0018\u00010?2\b\u0010-\u001a\u0004\u0018\u00010?8F@GX\u0086\u000e¢\u0006\f\u001a\u0004\b@\u0010A\"\u0004\bB\u0010C¨\u0006F"}, d2 = {"Lio/ktor/client/request/HttpRequestBuilder;", "Lio/ktor/http/HttpMessageBuilder;", "<init>", "()V", "Lkotlin/Function2;", "Lio/ktor/http/URLBuilder;", "LY8/t;", "block", "url", "(Lp9/p;)V", "Lio/ktor/client/request/HttpRequestData;", JsonPOJOBuilder.DEFAULT_BUILD_METHOD, "()Lio/ktor/client/request/HttpRequestData;", "Lkotlin/Function1;", "Lio/ktor/util/Attributes;", "setAttributes", "(Lp9/l;)V", "builder", "takeFromWithExecutionContext", "(Lio/ktor/client/request/HttpRequestBuilder;)Lio/ktor/client/request/HttpRequestBuilder;", "takeFrom", "", ExifInterface.GPS_DIRECTION_TRUE, "Lio/ktor/client/engine/HttpClientEngineCapability;", "key", "capability", "setCapability", "(Lio/ktor/client/engine/HttpClientEngineCapability;Ljava/lang/Object;)V", "getCapabilityOrNull", "(Lio/ktor/client/engine/HttpClientEngineCapability;)Ljava/lang/Object;", "Lio/ktor/http/URLBuilder;", "getUrl", "()Lio/ktor/http/URLBuilder;", "Lio/ktor/http/HttpMethod;", "method", "Lio/ktor/http/HttpMethod;", "getMethod", "()Lio/ktor/http/HttpMethod;", "setMethod", "(Lio/ktor/http/HttpMethod;)V", "Lio/ktor/http/HeadersBuilder;", "headers", "Lio/ktor/http/HeadersBuilder;", "getHeaders", "()Lio/ktor/http/HeadersBuilder;", UxipConstants.f30680s, "body", "Ljava/lang/Object;", "getBody", "()Ljava/lang/Object;", "setBody", "(Ljava/lang/Object;)V", "Lkotlinx/coroutines/g;", "executionContext", "Lkotlinx/coroutines/g;", "getExecutionContext", "()Lkotlinx/coroutines/g;", "setExecutionContext$ktor_client_core", "(Lkotlinx/coroutines/g;)V", "attributes", "Lio/ktor/util/Attributes;", "getAttributes", "()Lio/ktor/util/Attributes;", "Lio/ktor/util/reflect/TypeInfo;", "getBodyType", "()Lio/ktor/util/reflect/TypeInfo;", "setBodyType", "(Lio/ktor/util/reflect/TypeInfo;)V", "bodyType", "Companion", "ktor-client-core"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class HttpRequestBuilder implements HttpMessageBuilder {
    private final URLBuilder url = new URLBuilder(null, null, 0, null, null, null, null, null, false, 511, null);
    private HttpMethod method = HttpMethod.INSTANCE.getGet();
    private final HeadersBuilder headers = new HeadersBuilder(0, 1, null);
    private Object body = EmptyContent.INSTANCE;
    private kotlinx.coroutines.g executionContext = L0.b(null, 1, null);
    private final Attributes attributes = AttributesJvmKt.Attributes(true);

    /* JADX INFO: Access modifiers changed from: private */
    public static final Map setCapability$lambda$0() {
        return new LinkedHashMap();
    }

    public final HttpRequestData build() {
        Url urlBuild = this.url.build();
        HttpMethod httpMethod = this.method;
        Headers headersBuild = getHeaders().build();
        Object obj = this.body;
        OutgoingContent outgoingContent = obj instanceof OutgoingContent ? (OutgoingContent) obj : null;
        if (outgoingContent != null) {
            return new HttpRequestData(urlBuild, httpMethod, headersBuild, outgoingContent, this.executionContext, this.attributes);
        }
        throw new IllegalStateException(("No request transformation found: " + this.body).toString());
    }

    public final Attributes getAttributes() {
        return this.attributes;
    }

    public final Object getBody() {
        return this.body;
    }

    public final TypeInfo getBodyType() {
        return (TypeInfo) this.attributes.getOrNull(RequestBodyKt.getBodyTypeAttributeKey());
    }

    public final <T> T getCapabilityOrNull(HttpClientEngineCapability<T> key) {
        kotlin.jvm.internal.p.i(key, "key");
        Map map = (Map) this.attributes.getOrNull(HttpClientEngineCapabilityKt.getENGINE_CAPABILITIES_KEY());
        if (map != null) {
            return (T) map.get(key);
        }
        return null;
    }

    public final kotlinx.coroutines.g getExecutionContext() {
        return this.executionContext;
    }

    @Override // io.ktor.http.HttpMessageBuilder
    public HeadersBuilder getHeaders() {
        return this.headers;
    }

    public final HttpMethod getMethod() {
        return this.method;
    }

    public final URLBuilder getUrl() {
        return this.url;
    }

    public final void setAttributes(InterfaceC5074l<? super Attributes, Y8.t> block) {
        kotlin.jvm.internal.p.i(block, "block");
        block.invoke(this.attributes);
    }

    @InternalAPI
    public final void setBody(Object obj) {
        kotlin.jvm.internal.p.i(obj, "<set-?>");
        this.body = obj;
    }

    @InternalAPI
    public final void setBodyType(TypeInfo typeInfo) {
        if (typeInfo != null) {
            this.attributes.put(RequestBodyKt.getBodyTypeAttributeKey(), typeInfo);
        } else {
            this.attributes.remove(RequestBodyKt.getBodyTypeAttributeKey());
        }
    }

    public final <T> void setCapability(HttpClientEngineCapability<T> key, T capability) {
        kotlin.jvm.internal.p.i(key, "key");
        kotlin.jvm.internal.p.i(capability, "capability");
        ((Map) this.attributes.computeIfAbsent(HttpClientEngineCapabilityKt.getENGINE_CAPABILITIES_KEY(), new InterfaceC5063a() { // from class: io.ktor.client.request.r
            @Override // p9.InterfaceC5063a
            public final Object invoke() {
                return HttpRequestBuilder.setCapability$lambda$0();
            }
        })).put(key, capability);
    }

    public final void setExecutionContext$ktor_client_core(kotlinx.coroutines.g gVar) {
        kotlin.jvm.internal.p.i(gVar, "<set-?>");
        this.executionContext = gVar;
    }

    public final void setMethod(HttpMethod httpMethod) {
        kotlin.jvm.internal.p.i(httpMethod, "<set-?>");
        this.method = httpMethod;
    }

    public final HttpRequestBuilder takeFrom(HttpRequestBuilder builder) {
        kotlin.jvm.internal.p.i(builder, "builder");
        this.method = builder.method;
        this.body = builder.body;
        setBodyType(builder.getBodyType());
        URLUtilsKt.takeFrom(this.url, builder.url);
        URLBuilder uRLBuilder = this.url;
        uRLBuilder.setEncodedPathSegments(uRLBuilder.getEncodedPathSegments());
        StringValuesKt.appendAll(getHeaders(), builder.getHeaders());
        AttributesKt.putAll(this.attributes, builder.attributes);
        return this;
    }

    @InternalAPI
    public final HttpRequestBuilder takeFromWithExecutionContext(HttpRequestBuilder builder) {
        kotlin.jvm.internal.p.i(builder, "builder");
        this.executionContext = builder.executionContext;
        return takeFrom(builder);
    }

    public final void url(p9.p<? super URLBuilder, ? super URLBuilder, Y8.t> block) {
        kotlin.jvm.internal.p.i(block, "block");
        URLBuilder uRLBuilder = this.url;
        block.invoke(uRLBuilder, uRLBuilder);
    }
}
