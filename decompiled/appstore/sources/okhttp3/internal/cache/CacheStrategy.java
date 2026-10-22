package okhttp3.internal.cache;

import java.util.Date;
import java.util.concurrent.TimeUnit;
import javax.annotation.Nullable;
import okhttp3.Headers;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.a;
import okhttp3.internal.Internal;
import okhttp3.internal.http.HttpDate;
import okhttp3.internal.http.HttpHeaders;

/* JADX INFO: loaded from: classes4.dex */
public final class CacheStrategy {

    @Nullable
    public final Response cacheResponse;

    @Nullable
    public final Request networkRequest;

    public static class Factory {
        private int ageSeconds;
        final Response cacheResponse;
        private String etag;
        private Date expires;
        private Date lastModified;
        private String lastModifiedString;
        final long nowMillis;
        private long receivedResponseMillis;
        final Request request;
        private long sentRequestMillis;
        private Date servedDate;
        private String servedDateString;

        public Factory(long r10, Request r11, Response r12) {
            this.ageSeconds = -1;
            this.nowMillis = r10;
            this.request = r11;
            this.cacheResponse = r12;
            if (r12 == null) goto L22;
            this.sentRequestMillis = r12.s();
            this.receivedResponseMillis = r12.q();
            Headers r13 = r12.i();
            int r14 = r13.h();
            int r15 = 0;
        L5:
            if (r15 >= r14) goto L30;
            String r16 = r13.d(r15);
            String r17 = r13.j(r15);
            if ("Date".equalsIgnoreCase(r16) == false) goto L10;
            this.servedDate = HttpDate.parse(r17);
            this.servedDateString = r17;
        L21:
            r15 = r15 + 1;
            goto L5
        L10:
            if ("Expires".equalsIgnoreCase(r16) == false) goto L13;
            this.expires = HttpDate.parse(r17);
            goto L21
        L13:
            if ("Last-Modified".equalsIgnoreCase(r16) == false) goto L16;
            this.lastModified = HttpDate.parse(r17);
            this.lastModifiedString = r17;
            goto L21
        L16:
            if ("ETag".equalsIgnoreCase(r16) == false) goto L19;
            this.etag = r17;
            goto L21
        L19:
            if ("Age".equalsIgnoreCase(r16) == false) goto L21;
            this.ageSeconds = HttpHeaders.parseSeconds(r17, -1);
            goto L21
        L30:
            return;
        }

        private long cacheResponseAge() {
            Date r10 = this.servedDate;
            long r11 = 0;
            if (r10 == null) goto L5;
            r11 = Math.max(0, this.receivedResponseMillis - r10.getTime());
        L5:
            int r12 = this.ageSeconds;
            if (r12 == (-1)) goto L8;
            r11 = Math.max(r11, TimeUnit.SECONDS.toMillis(r12));
        L8:
            long r13 = this.receivedResponseMillis;
            return (r11 + (r13 - this.sentRequestMillis)) + (this.nowMillis - r13);
        }

        private long computeFreshnessLifetime() {
            a r10 = this.cacheResponse.b();
            if (r10.e() == (-1)) goto L7;
            return TimeUnit.SECONDS.toMillis(r10.e());
        L7:
            if (this.expires == null) goto L17;
            Date r11 = this.servedDate;
            if (r11 == null) goto L11;
            long r12 = r11.getTime();
        L12:
            long r13 = this.expires.getTime() - r12;
            if (r13 > 0) goto L15;
            return 0;
        L15:
            return r13;
        L11:
            r12 = this.receivedResponseMillis;
            goto L12
        L17:
            if (this.lastModified != null) goto L19;
            return 0;
        L19:
            if (this.cacheResponse.r().k().A() != null) goto L30;
            Date r14 = this.servedDate;
            if (r14 == null) goto L23;
            long r15 = r14.getTime();
        L24:
            long r16 = r15 - this.lastModified.getTime();
            if (r16 > 0) goto L27;
            return 0;
        L27:
            return r16 / 10;
        L23:
            r15 = this.sentRequestMillis;
            goto L24
        L30:
            return 0;
        }

        private CacheStrategy getCandidate() {
            if (this.cacheResponse != null) goto L7;
            return new CacheStrategy(this.request, null);
        L7:
            if (this.request.f() == false) goto L13;
            if (this.cacheResponse.e() != null) goto L13;
            return new CacheStrategy(this.request, null);
        L13:
            if (CacheStrategy.isCacheable(this.cacheResponse, this.request) == false) goto L15;
            a r10 = this.request.b();
            if (r10.i() == true) goto L66;
            if (hasConditions(this.request) == true) goto L66;
            a r11 = this.cacheResponse.b();
            if (r11.b() == true) goto L24;
            long r12 = cacheResponseAge();
            long r13 = computeFreshnessLifetime();
            if (r10.e() == (-1)) goto L28;
            r13 = Math.min(r13, TimeUnit.SECONDS.toMillis(r10.e()));
        L28:
            long r14 = 0;
            if (r10.g() == (-1)) goto L31;
            long r15 = TimeUnit.SECONDS.toMillis(r10.g());
        L33:
            if (r11.h() == true) goto L38;
            if (r10.f() == (-1)) goto L38;
            r14 = TimeUnit.SECONDS.toMillis(r10.f());
        L38:
            if (r11.i() == true) goto L51;
            long r16 = r15 + r12;
            if (r16 >= (r14 + r13)) goto L51;
            Response.Builder r17 = this.cacheResponse.n();
            if (r16 < r13) goto L45;
            r17.a("Warning", "110 HttpURLConnection \"Response is stale\"");
        L45:
            if (r12 <= 86400000) goto L50;
            if (isFreshnessLifetimeHeuristic() == false) goto L50;
            r17.a("Warning", "113 HttpURLConnection \"Heuristic expiration\"");
        L50:
            return new CacheStrategy(null, r17.c());
        L51:
            String r18 = this.etag;
            if (r18 == null) goto L55;
            String r19 = "If-None-Match";
        L61:
            Headers.Builder r20 = this.request.e().f();
            Internal.instance.addLenient(r20, r19, r18);
            return new CacheStrategy(this.request.h().e(r20.d()).b(), this.cacheResponse);
        L55:
            if (this.lastModified == null) goto L59;
            r18 = this.lastModifiedString;
        L57:
            r19 = "If-Modified-Since";
            goto L61
        L59:
            if (this.servedDate == null) goto L64;
            r18 = this.servedDateString;
            goto L57
        L64:
            return new CacheStrategy(this.request, null);
        L31:
            r15 = 0;
            goto L33
        L24:
            return new CacheStrategy(null, this.cacheResponse);
        L66:
            return new CacheStrategy(this.request, null);
        L15:
            return new CacheStrategy(this.request, null);
        }

        private static boolean hasConditions(Request r10) {
            if (r10.c("If-Modified-Since") == null) goto L5;
        L8:
            return true;
        L5:
            if (r10.c("If-None-Match") != null) goto L8;
            return false;
        }

        private boolean isFreshnessLifetimeHeuristic() {
            if (this.cacheResponse.b().e() == (-1)) goto L5;
        L7:
            return false;
        L5:
            if (this.expires != null) goto L7;
            return true;
        }

        public CacheStrategy get() {
            CacheStrategy r10 = getCandidate();
            if (r10.networkRequest != null) goto L5;
        L8:
            return r10;
        L5:
            if (this.request.b().k() == false) goto L8;
            return new CacheStrategy(null, null);
        }
    }

    public CacheStrategy(Request r10, Response r11) {
        this.networkRequest = r10;
        this.cacheResponse = r11;
    }

    public static boolean isCacheable(Response r10, Request r11) {
        int r12 = r10.d();
        if (r12 == 200) goto L35;
        if (r12 == 410) goto L35;
        if (r12 == 414) goto L35;
        if (r12 == 501) goto L35;
        if (r12 == 203) goto L35;
        if (r12 == 204) goto L35;
        if (r12 == 307) goto L25;
        if (r12 == 308) goto L35;
        if (r12 == 404) goto L35;
        if (r12 == 405) goto L35;
        switch(r12) {
            case 300: goto L35;
            case 301: goto L35;
            case 302: goto L25;
            default: goto L33;
        };
    L33:
        return false;
    L25:
        if (r10.f("Expires") != null) goto L35;
        if (r10.b().e() != (-1)) goto L35;
        if (r10.b().d() == true) goto L35;
        if (r10.b().c() == false) goto L33;
    L35:
        if (r10.b().j() == false) goto L37;
        return false;
    L37:
        if (r11.b().j() == true) goto L41;
        return true;
    L41:
        return false;
    }
}
