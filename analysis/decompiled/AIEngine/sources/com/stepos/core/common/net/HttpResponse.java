package com.stepos.core.common.net;

import gc.o;
import h0.e;
import java.util.Iterator;
import java.util.Map;
import kotlin.collections.b;
import kotlin.jvm.internal.g;
import v1.d;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class HttpResponse {
    private final String body;
    private final int code;
    private final Map<String, String> headers;

    public HttpResponse(int i10, String body, Map<String, String> headers) {
        g.f(body, "body");
        g.f(headers, "headers");
        this.code = i10;
        this.body = body;
        this.headers = headers;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ HttpResponse copy$default(HttpResponse httpResponse, int i10, String str, Map map, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            i10 = httpResponse.code;
        }
        if ((i11 & 2) != 0) {
            str = httpResponse.body;
        }
        if ((i11 & 4) != 0) {
            map = httpResponse.headers;
        }
        return httpResponse.copy(i10, str, map);
    }

    public final int component1() {
        return this.code;
    }

    public final String component2() {
        return this.body;
    }

    public final Map<String, String> component3() {
        return this.headers;
    }

    public final HttpResponse copy(int i10, String body, Map<String, String> headers) {
        g.f(body, "body");
        g.f(headers, "headers");
        return new HttpResponse(i10, body, headers);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof HttpResponse)) {
            return false;
        }
        HttpResponse httpResponse = (HttpResponse) obj;
        return this.code == httpResponse.code && g.b(this.body, httpResponse.body) && g.b(this.headers, httpResponse.headers);
    }

    public final String getBody() {
        return this.body;
    }

    public final int getCode() {
        return this.code;
    }

    public final Map<String, String> getHeaders() {
        return this.headers;
    }

    public int hashCode() {
        return this.headers.hashCode() + d.a(Integer.hashCode(this.code) * 31, 31, this.body);
    }

    public final String header(String name) {
        Object next;
        g.f(name, "name");
        Iterator<T> it = this.headers.entrySet().iterator();
        while (true) {
            if (!it.hasNext()) {
                next = null;
                break;
            }
            next = it.next();
            if (o.f0((String) ((Map.Entry) next).getKey(), name)) {
                break;
            }
        }
        Map.Entry entry = (Map.Entry) next;
        if (entry != null) {
            return (String) entry.getValue();
        }
        return null;
    }

    public final boolean isSuccessful() {
        int i10 = this.code;
        return 200 <= i10 && i10 < 300;
    }

    public String toString() {
        int i10 = this.code;
        String str = this.body;
        Map<String, String> map = this.headers;
        StringBuilder sbE = e.e("HttpResponse(code=", i10, ", body=", str, ", headers=");
        sbE.append(map);
        sbE.append(")");
        return sbE.toString();
    }

    public /* synthetic */ HttpResponse(int i10, String str, Map map, int i11, kotlin.jvm.internal.e eVar) {
        this(i10, str, (i11 & 4) != 0 ? b.d0() : map);
    }
}
