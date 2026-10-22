package com.stepos.core.common.net;

import com.stepos.core.ability.speech.TtsCloudConfig;
import com.stepos.core.common.cloud.FileStorageUploader;
import java.util.Map;
import kotlin.collections.b;
import kotlin.jvm.internal.e;
import kotlin.jvm.internal.g;
import sb.a;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class HttpRequest {
    private final HttpBody body;
    private final long connectTimeoutMs;
    private final Map<String, String> headers;
    private final Method method;
    private final long readTimeoutMs;
    private final String tag;
    private final String url;

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public static final class Method {
        private static final /* synthetic */ a $ENTRIES;
        private static final /* synthetic */ Method[] $VALUES;
        public static final Method GET = new Method("GET", 0);
        public static final Method POST = new Method("POST", 1);
        public static final Method PUT = new Method("PUT", 2);
        public static final Method DELETE = new Method("DELETE", 3);

        private static final /* synthetic */ Method[] $values() {
            return new Method[]{GET, POST, PUT, DELETE};
        }

        static {
            Method[] methodArr$values = $values();
            $VALUES = methodArr$values;
            $ENTRIES = kotlin.enums.a.a(methodArr$values);
        }

        private Method(String str, int i10) {
        }

        public static a<Method> getEntries() {
            return $ENTRIES;
        }

        public static Method valueOf(String str) {
            return (Method) Enum.valueOf(Method.class, str);
        }

        public static Method[] values() {
            return (Method[]) $VALUES.clone();
        }
    }

    public HttpRequest(String url, Method method, Map<String, String> headers, HttpBody httpBody, long j10, long j11, String tag) {
        g.f(url, "url");
        g.f(method, "method");
        g.f(headers, "headers");
        g.f(tag, "tag");
        this.url = url;
        this.method = method;
        this.headers = headers;
        this.body = httpBody;
        this.connectTimeoutMs = j10;
        this.readTimeoutMs = j11;
        this.tag = tag;
    }

    public static /* synthetic */ HttpRequest copy$default(HttpRequest httpRequest, String str, Method method, Map map, HttpBody httpBody, long j10, long j11, String str2, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            str = httpRequest.url;
        }
        if ((i10 & 2) != 0) {
            method = httpRequest.method;
        }
        if ((i10 & 4) != 0) {
            map = httpRequest.headers;
        }
        if ((i10 & 8) != 0) {
            httpBody = httpRequest.body;
        }
        if ((i10 & 16) != 0) {
            j10 = httpRequest.connectTimeoutMs;
        }
        if ((i10 & 32) != 0) {
            j11 = httpRequest.readTimeoutMs;
        }
        if ((i10 & 64) != 0) {
            str2 = httpRequest.tag;
        }
        String str3 = str2;
        long j12 = j11;
        long j13 = j10;
        return httpRequest.copy(str, method, map, httpBody, j13, j12, str3);
    }

    public final String component1() {
        return this.url;
    }

    public final Method component2() {
        return this.method;
    }

    public final Map<String, String> component3() {
        return this.headers;
    }

    public final HttpBody component4() {
        return this.body;
    }

    public final long component5() {
        return this.connectTimeoutMs;
    }

    public final long component6() {
        return this.readTimeoutMs;
    }

    public final String component7() {
        return this.tag;
    }

    public final HttpRequest copy(String url, Method method, Map<String, String> headers, HttpBody httpBody, long j10, long j11, String tag) {
        g.f(url, "url");
        g.f(method, "method");
        g.f(headers, "headers");
        g.f(tag, "tag");
        return new HttpRequest(url, method, headers, httpBody, j10, j11, tag);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof HttpRequest)) {
            return false;
        }
        HttpRequest httpRequest = (HttpRequest) obj;
        return g.b(this.url, httpRequest.url) && this.method == httpRequest.method && g.b(this.headers, httpRequest.headers) && g.b(this.body, httpRequest.body) && this.connectTimeoutMs == httpRequest.connectTimeoutMs && this.readTimeoutMs == httpRequest.readTimeoutMs && g.b(this.tag, httpRequest.tag);
    }

    public final HttpBody getBody() {
        return this.body;
    }

    public final long getConnectTimeoutMs() {
        return this.connectTimeoutMs;
    }

    public final Map<String, String> getHeaders() {
        return this.headers;
    }

    public final Method getMethod() {
        return this.method;
    }

    public final long getReadTimeoutMs() {
        return this.readTimeoutMs;
    }

    public final String getTag() {
        return this.tag;
    }

    public final String getUrl() {
        return this.url;
    }

    public int hashCode() {
        int iHashCode = (this.headers.hashCode() + ((this.method.hashCode() + (this.url.hashCode() * 31)) * 31)) * 31;
        HttpBody httpBody = this.body;
        return this.tag.hashCode() + a0.a.c(a0.a.c((iHashCode + (httpBody == null ? 0 : httpBody.hashCode())) * 31, this.connectTimeoutMs, 31), this.readTimeoutMs, 31);
    }

    public String toString() {
        String str = this.url;
        Method method = this.method;
        Map<String, String> map = this.headers;
        HttpBody httpBody = this.body;
        long j10 = this.connectTimeoutMs;
        long j11 = this.readTimeoutMs;
        String str2 = this.tag;
        StringBuilder sb2 = new StringBuilder("HttpRequest(url=");
        sb2.append(str);
        sb2.append(", method=");
        sb2.append(method);
        sb2.append(", headers=");
        sb2.append(map);
        sb2.append(", body=");
        sb2.append(httpBody);
        sb2.append(", connectTimeoutMs=");
        sb2.append(j10);
        a0.a.s(j11, ", readTimeoutMs=", ", tag=", sb2);
        return ai.onnxruntime.a.o(sb2, str2, ")");
    }

    public /* synthetic */ HttpRequest(String str, Method method, Map map, HttpBody httpBody, long j10, long j11, String str2, int i10, e eVar) {
        this(str, (i10 & 2) != 0 ? Method.GET : method, (i10 & 4) != 0 ? b.d0() : map, (i10 & 8) != 0 ? null : httpBody, (i10 & 16) != 0 ? FileStorageUploader.LOG_HEARTBEAT_MS : j10, (i10 & 32) != 0 ? TtsCloudConfig.DEFAULT_AUDIO_DONE_IDLE_WATCHDOG_MS : j11, (i10 & 64) != 0 ? "" : str2);
    }
}
