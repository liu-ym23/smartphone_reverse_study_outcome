package com.volcengine.tos.internal;

import V9.i;
import a.AbstractC0291a;
import com.volcengine.tos.model.RequestInfo;
import java.io.IOException;
import java.io.InputStream;
import java.io.Serializable;
import java.util.Collections;
import java.util.Map;

/* loaded from: classes3.dex */
public class TosResponse implements AutoCloseable, Serializable {

    /* renamed from: a, reason: collision with root package name */
    public int f4236a;
    public long b;
    public Map c = Collections.EMPTY_MAP;
    public transient InputStream d;
    public transient i e;

    public final RequestInfo b() {
        return new RequestInfo(f(), (String) this.c.get("X-Tos-Id-2".toLowerCase()), this.f4236a, this.c);
    }

    public final String c(String str) {
        if (AbstractC0291a.x(str) || this.c.size() == 0) {
            return null;
        }
        return (String) this.c.get(str.toLowerCase());
    }

    @Override // java.lang.AutoCloseable
    public final void close() throws IOException {
        InputStream inputStream = this.d;
        if (inputStream != null) {
            inputStream.close();
        }
    }

    public final String f() {
        return (String) this.c.get("X-Tos-Request-Id".toLowerCase());
    }

    public final String toString() {
        return "TosResponse{statusCode=" + this.f4236a + ", contentLength=" + this.b + ", headers=" + this.c + '}';
    }
}
