package io.ktor.client.request;

import Z8.Y;
import androidx.exifinterface.media.ExifInterface;
import io.ktor.client.engine.HttpClientEngineCapability;
import io.ktor.client.engine.HttpClientEngineCapabilityKt;
import io.ktor.http.Headers;
import io.ktor.http.HttpMethod;
import io.ktor.http.Url;
import io.ktor.http.content.OutgoingContent;
import io.ktor.util.Attributes;
import io.ktor.utils.io.InternalAPI;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0014\n\u0002\u0010\"\n\u0002\b\u0005\u0018\u00002\u00020\u0001B9\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\u0006\u0010\u0007\u001a\u00020\u0006\u0012\u0006\u0010\t\u001a\u00020\b\u0012\u0006\u0010\u000b\u001a\u00020\n\u0012\u0006\u0010\r\u001a\u00020\f¢\u0006\u0004\b\u000e\u0010\u000fJ#\u0010\u0013\u001a\u0004\u0018\u00018\u0000\"\u0004\b\u0000\u0010\u00102\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00028\u00000\u0011¢\u0006\u0004\b\u0013\u0010\u0014J\u000f\u0010\u0016\u001a\u00020\u0015H\u0016¢\u0006\u0004\b\u0016\u0010\u0017R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0018\u001a\u0004\b\u0019\u0010\u001aR\u0017\u0010\u0005\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\u0005\u0010\u001b\u001a\u0004\b\u001c\u0010\u001dR\u0017\u0010\u0007\u001a\u00020\u00068\u0006¢\u0006\f\n\u0004\b\u0007\u0010\u001e\u001a\u0004\b\u001f\u0010 R\u0017\u0010\t\u001a\u00020\b8\u0006¢\u0006\f\n\u0004\b\t\u0010!\u001a\u0004\b\"\u0010#R\u0017\u0010\u000b\u001a\u00020\n8\u0006¢\u0006\f\n\u0004\b\u000b\u0010$\u001a\u0004\b%\u0010&R\u0017\u0010\r\u001a\u00020\f8\u0006¢\u0006\f\n\u0004\b\r\u0010'\u001a\u0004\b(\u0010)R$\u0010+\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00110*8\u0000X\u0080\u0004¢\u0006\f\n\u0004\b+\u0010,\u001a\u0004\b-\u0010.¨\u0006/"}, d2 = {"Lio/ktor/client/request/HttpRequestData;", "", "Lio/ktor/http/Url;", "url", "Lio/ktor/http/HttpMethod;", "method", "Lio/ktor/http/Headers;", "headers", "Lio/ktor/http/content/OutgoingContent;", "body", "Lkotlinx/coroutines/g;", "executionContext", "Lio/ktor/util/Attributes;", "attributes", "<init>", "(Lio/ktor/http/Url;Lio/ktor/http/HttpMethod;Lio/ktor/http/Headers;Lio/ktor/http/content/OutgoingContent;Lkotlinx/coroutines/g;Lio/ktor/util/Attributes;)V", ExifInterface.GPS_DIRECTION_TRUE, "Lio/ktor/client/engine/HttpClientEngineCapability;", "key", "getCapabilityOrNull", "(Lio/ktor/client/engine/HttpClientEngineCapability;)Ljava/lang/Object;", "", "toString", "()Ljava/lang/String;", "Lio/ktor/http/Url;", "getUrl", "()Lio/ktor/http/Url;", "Lio/ktor/http/HttpMethod;", "getMethod", "()Lio/ktor/http/HttpMethod;", "Lio/ktor/http/Headers;", "getHeaders", "()Lio/ktor/http/Headers;", "Lio/ktor/http/content/OutgoingContent;", "getBody", "()Lio/ktor/http/content/OutgoingContent;", "Lkotlinx/coroutines/g;", "getExecutionContext", "()Lkotlinx/coroutines/g;", "Lio/ktor/util/Attributes;", "getAttributes", "()Lio/ktor/util/Attributes;", "", "requiredCapabilities", "Ljava/util/Set;", "getRequiredCapabilities$ktor_client_core", "()Ljava/util/Set;", "ktor-client-core"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class HttpRequestData {
    private final Attributes attributes;
    private final OutgoingContent body;
    private final kotlinx.coroutines.g executionContext;
    private final Headers headers;
    private final HttpMethod method;
    private final Set<HttpClientEngineCapability<?>> requiredCapabilities;
    private final Url url;

    @InternalAPI
    public HttpRequestData(Url url, HttpMethod method, Headers headers, OutgoingContent body, kotlinx.coroutines.g executionContext, Attributes attributes) {
        Set<HttpClientEngineCapability<?>> setKeySet;
        kotlin.jvm.internal.p.i(url, "url");
        kotlin.jvm.internal.p.i(method, "method");
        kotlin.jvm.internal.p.i(headers, "headers");
        kotlin.jvm.internal.p.i(body, "body");
        kotlin.jvm.internal.p.i(executionContext, "executionContext");
        kotlin.jvm.internal.p.i(attributes, "attributes");
        this.url = url;
        this.method = method;
        this.headers = headers;
        this.body = body;
        this.executionContext = executionContext;
        this.attributes = attributes;
        Map map = (Map) attributes.getOrNull(HttpClientEngineCapabilityKt.getENGINE_CAPABILITIES_KEY());
        this.requiredCapabilities = (map == null || (setKeySet = map.keySet()) == null) ? Y.e() : setKeySet;
    }

    public final Attributes getAttributes() {
        return this.attributes;
    }

    public final OutgoingContent getBody() {
        return this.body;
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

    public final Headers getHeaders() {
        return this.headers;
    }

    public final HttpMethod getMethod() {
        return this.method;
    }

    public final Set<HttpClientEngineCapability<?>> getRequiredCapabilities$ktor_client_core() {
        return this.requiredCapabilities;
    }

    public final Url getUrl() {
        return this.url;
    }

    public String toString() {
        return "HttpRequestData(url=" + this.url + ", method=" + this.method + ')';
    }
}
