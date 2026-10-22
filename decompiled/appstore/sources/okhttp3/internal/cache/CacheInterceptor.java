package okhttp3.internal.cache;

import fg.j;
import java.io.IOException;
import okhttp3.Headers;
import okhttp3.Interceptor;
import okhttp3.Protocol;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.internal.Internal;
import okhttp3.internal.Util;
import okhttp3.internal.http.HttpHeaders;
import okhttp3.internal.http.HttpMethod;
import okhttp3.internal.http.RealResponseBody;
import okio.BufferedSink;
import okio.BufferedSource;
import okio.Sink;
import okio.Source;
import org.apache.http.protocol.HTTP;

/* JADX INFO: loaded from: classes4.dex */
public final class CacheInterceptor implements Interceptor {
    final InternalCache cache;

    public CacheInterceptor(InternalCache r10) {
        this.cache = r10;
    }

    private Response cacheWritingResponse(final CacheRequest r10, Response r11) throws IOException {
        if (r10 != null) goto L4;
        return r11;
    L4:
        Sink r12 = r10.body();
        if (r12 != null) goto L7;
        return r11;
    L7:
        final BufferedSource r13 = r11.a().source();
        final BufferedSink r14 = j.c(r12);
        Source r15 = new AnonymousClass1(this, r13, r10, r14);
        String r16 = r11.f("Content-Type");
        long r17 = r11.a().contentLength();
        return r11.n().b(new RealResponseBody(r16, r17, j.d(r15))).c();
    }

    private static Headers combine(Headers r10, Headers r11) {
        Headers.Builder r12 = new Headers.Builder();
        int r13 = r10.h();
        int r14 = 0;
        int r15 = 0;
    L3:
        if (r15 >= r13) goto L17;
        String r16 = r10.d(r15);
        String r17 = r10.j(r15);
        if ("Warning".equalsIgnoreCase(r16) == false) goto L10;
        if (r17.startsWith("1") == false) goto L10;
    L16:
        r15 = r15 + 1;
    L10:
        if (isContentSpecificHeader(r16) == false) goto L12;
    L15:
        Internal.instance.addLenient(r12, r16, r17);
        goto L16
    L12:
        if (isEndToEnd(r16) == false) goto L15;
        if (r11.b(r16) != null) goto L16;
    L17:
        int r18 = r11.h();
    L18:
        if (r14 >= r18) goto L26;
        String r19 = r11.d(r14);
        if (isContentSpecificHeader(r19) == true) goto L24;
        if (isEndToEnd(r19) == false) goto L24;
        Internal.instance.addLenient(r12, r19, r11.j(r14));
    L24:
        r14 = r14 + 1;
        goto L18
    L26:
        return r12.d();
    }

    public static boolean isContentSpecificHeader(String r10) {
        if ("Content-Length".equalsIgnoreCase(r10) == false) goto L5;
    L10:
        return true;
    L5:
        if ("Content-Encoding".equalsIgnoreCase(r10) == true) goto L10;
        if ("Content-Type".equalsIgnoreCase(r10) == true) goto L10;
        return false;
    }

    public static boolean isEndToEnd(String r10) {
        if ("Connection".equalsIgnoreCase(r10) == false) goto L5;
    L19:
        return false;
    L5:
        if (HTTP.CONN_KEEP_ALIVE.equalsIgnoreCase(r10) == true) goto L19;
        if ("Proxy-Authenticate".equalsIgnoreCase(r10) == true) goto L19;
        if ("Proxy-Authorization".equalsIgnoreCase(r10) == true) goto L19;
        if ("TE".equalsIgnoreCase(r10) == true) goto L19;
        if ("Trailers".equalsIgnoreCase(r10) == true) goto L19;
        if ("Transfer-Encoding".equalsIgnoreCase(r10) == true) goto L19;
        if ("Upgrade".equalsIgnoreCase(r10) == true) goto L19;
        return true;
    }

    private static Response stripBody(Response r10) {
        if (r10 != null) goto L4;
        return r10;
    L4:
        if (r10.a() != null) goto L6;
        return r10;
    L6:
        return r10.n().b(null).c();
    }

    @Override // okhttp3.Interceptor
    public Response intercept(Interceptor.Chain r10) throws IOException {
        InternalCache r11 = this.cache;
        if (r11 == null) goto L5;
        Response r12 = r11.get(r10.request());
    L6:
        CacheStrategy r13 = new CacheStrategy.Factory(System.currentTimeMillis(), r10.request(), r12).get();
        Request r14 = r13.networkRequest;
        Response r15 = r13.cacheResponse;
        InternalCache r16 = this.cache;
        if (r16 == null) goto L9;
        r16.trackResponse(r13);
    L9:
        if (r12 == null) goto L12;
        if (r15 != null) goto L12;
        Util.closeQuietly(r12.a());
    L12:
        if (r14 != null) goto L16;
        if (r15 != null) goto L16;
        return new Response.Builder().p(r10.request()).m(Protocol.HTTP_1_1).g(504).j("Unsatisfiable Request (only-if-cached)").b(Util.EMPTY_RESPONSE).q(-1).n(System.currentTimeMillis()).c();
    L16:
        if (r14 == null) goto L18;
        Response r17 = r10.proceed(r14);     // Catch: Throwable -> L41
        if (r17 != null) goto L23;
        if (r12 == null) goto L23;
        Util.closeQuietly(r12.a());
    L23:
        if (r15 != null) goto L25;
    L29:
        Response r18 = r17.n().d(stripBody(r15)).k(stripBody(r17)).c();
        if (this.cache != null) goto L32;
    L40:
        return r18;
    L32:
        if (HttpHeaders.hasBody(r18) == false) goto L38;
        if (CacheStrategy.isCacheable(r18, r14) == false) goto L38;
        return cacheWritingResponse(this.cache.put(r18), r18);
    L38:
        if (HttpMethod.invalidatesCache(r14.g()) == false) goto L40;
        this.cache.remove(r14);     // Catch: IOException -> L45
        goto L40
    L25:
        if (r17.d() != 304) goto L28;
        Response r19 = r15.n().i(combine(r15.i(), r17.i())).q(r17.s()).n(r17.q()).d(stripBody(r15)).k(stripBody(r17)).c();
        r17.a().close();
        this.cache.trackConditionalCacheHit();
        this.cache.update(r15, r19);
        return r19;
    L28:
        Util.closeQuietly(r15.a());
    L41:
        th = move-exception;
        if (r12 == null) goto L44;
        Util.closeQuietly(r12.a());
    L44:
        throw th;
    L18:
        return r15.n().d(stripBody(r15)).c();
    L5:
        r12 = null;
        goto L6
    }
}
