package okhttp3.internal.http;

import fg.g;
import fg.j;
import java.io.IOException;
import java.util.List;
import okhttp3.CookieJar;
import okhttp3.Interceptor;
import okhttp3.MediaType;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import okhttp3.e;
import okhttp3.internal.Util;
import okhttp3.internal.Version;
import org.apache.http.protocol.HTTP;

/* JADX INFO: loaded from: classes4.dex */
public final class BridgeInterceptor implements Interceptor {
    private final CookieJar cookieJar;

    public BridgeInterceptor(CookieJar r10) {
        this.cookieJar = r10;
    }

    private String cookieHeader(List<e> r10) {
        StringBuilder r11 = new StringBuilder();
        int r12 = r10.size();
        int r13 = 0;
    L3:
        if (r13 >= r12) goto L8;
        if (r13 <= 0) goto L6;
        r11.append("; ");
    L6:
        e r14 = r10.get(r13);
        r11.append(r14.c());
        r11.append('=');
        r11.append(r14.k());
        r13 = r13 + 1;
        goto L3
    L8:
        return r11.toString();
    }

    @Override // okhttp3.Interceptor
    public Response intercept(Interceptor.Chain r11) throws IOException {
        Request r10 = r11.request();
        Request.a r12 = r10.h();
        RequestBody r13 = r10.a();
        if (r13 == null) goto L11;
        MediaType r14 = r13.b();
        if (r14 == null) goto L7;
        r12.d("Content-Type", r14.toString());
    L7:
        long r15 = r13.a();
        if (r15 == (-1)) goto L10;
        r12.d("Content-Length", Long.toString(r15));
        r12.h("Transfer-Encoding");
        goto L11
    L10:
        r12.d("Transfer-Encoding", HTTP.CHUNK_CODING);
        r12.h("Content-Length");
    L11:
        boolean r16 = false;
        if (r10.c("Host") != null) goto L15;
        r12.d("Host", Util.hostHeader(r10.k(), false));
    L15:
        if (r10.c("Connection") != null) goto L18;
        r12.d("Connection", HTTP.CONN_KEEP_ALIVE);
    L18:
        if (r10.c("Accept-Encoding") == null) goto L20;
    L22:
        List<e> r17 = this.cookieJar.loadForRequest(r10.k());
        if (r17.isEmpty() == true) goto L26;
        r12.d("Cookie", cookieHeader(r17));
    L26:
        if (r10.c("User-Agent") != null) goto L28;
        r12.d("User-Agent", Version.userAgent());
    L28:
        Response r18 = r11.proceed(r12.b());
        HttpHeaders.receiveHeaders(this.cookieJar, r10.k(), r18.i());
        Response.Builder r19 = r18.n().p(r10);
        if (r16 == false) goto L36;
        if ("gzip".equalsIgnoreCase(r18.f("Content-Encoding")) == false) goto L36;
        if (HttpHeaders.hasBody(r18) == false) goto L36;
        g r20 = new g(r18.a().source());
        r19.i(r18.i().f().g("Content-Encoding").g("Content-Length").d());
        r19.b(new RealResponseBody(r18.f("Content-Type"), -1, j.d(r20)));
    L36:
        return r19.c();
    L20:
        if (r10.c("Range") != null) goto L22;
        r12.d("Accept-Encoding", "gzip");
        r16 = true;
        goto L22
    }
}
