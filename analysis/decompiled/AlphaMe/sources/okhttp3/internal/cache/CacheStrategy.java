package okhttp3.internal.cache;

import h3.C0600i;
import h3.C0611u;
import h3.G;
import h3.H;
import h3.J;
import h3.U;
import h3.V;
import h3.a0;
import h3.b0;
import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsJVMKt;
import okhttp3.internal.Util;
import okhttp3.internal.http.DatesKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u0000 \u000e2\u00020\u0001:\u0002\u000e\u000fB\u001d\b\u0000\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\b\u001a\u0004\u0018\u00010\u0007¢\u0006\u0004\b\f\u0010\rR\u0019\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u0019\u0010\b\u001a\u0004\u0018\u00010\u00078\u0006¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000b¨\u0006\u0010"}, d2 = {"Lokhttp3/internal/cache/CacheStrategy;", "", "Lh3/V;", "networkRequest", "Lh3/V;", "getNetworkRequest", "()Lh3/V;", "Lh3/b0;", "cacheResponse", "Lh3/b0;", "getCacheResponse", "()Lh3/b0;", "<init>", "(Lh3/V;Lh3/b0;)V", "Companion", "Factory", "okhttp"}, k = 1, mv = {1, 6, 0})
/* loaded from: classes2.dex */
public final class CacheStrategy {

    /* renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    @Nullable
    private final b0 cacheResponse;

    @Nullable
    private final V networkRequest;

    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\t\u0010\nJ\u001d\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0007\u0010\b¨\u0006\u000b"}, d2 = {"Lokhttp3/internal/cache/CacheStrategy$Companion;", "", "Lh3/b0;", "response", "Lh3/V;", "request", "", "isCacheable", "(Lh3/b0;Lh3/V;)Z", "<init>", "()V", "okhttp"}, k = 1, mv = {1, 6, 0})
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        /* JADX WARN: Removed duplicated region for block: B:24:0x0039  */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public final boolean isCacheable(@org.jetbrains.annotations.NotNull h3.b0 r3, @org.jetbrains.annotations.NotNull h3.V r4) {
            /*
                r2 = this;
                java.lang.String r2 = "response"
                kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r3, r2)
                java.lang.String r2 = "request"
                kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r4, r2)
                int r2 = r3.f12867d
                r0 = 200(0xc8, float:2.8E-43)
                r1 = 0
                if (r2 == r0) goto L5b
                r0 = 410(0x19a, float:5.75E-43)
                if (r2 == r0) goto L5b
                r0 = 414(0x19e, float:5.8E-43)
                if (r2 == r0) goto L5b
                r0 = 501(0x1f5, float:7.02E-43)
                if (r2 == r0) goto L5b
                r0 = 203(0xcb, float:2.84E-43)
                if (r2 == r0) goto L5b
                r0 = 204(0xcc, float:2.86E-43)
                if (r2 == r0) goto L5b
                r0 = 307(0x133, float:4.3E-43)
                if (r2 == r0) goto L39
                r0 = 308(0x134, float:4.32E-43)
                if (r2 == r0) goto L5b
                r0 = 404(0x194, float:5.66E-43)
                if (r2 == r0) goto L5b
                r0 = 405(0x195, float:5.68E-43)
                if (r2 == r0) goto L5b
                switch(r2) {
                    case 300: goto L5b;
                    case 301: goto L5b;
                    case 302: goto L39;
                    default: goto L38;
                }
            L38:
                return r1
            L39:
                java.lang.String r2 = "Expires"
                java.lang.String r2 = h3.b0.b(r3, r2)
                if (r2 != 0) goto L5b
                h3.i r2 = r3.a()
                r0 = -1
                int r2 = r2.f12923c
                if (r2 != r0) goto L5b
                h3.i r2 = r3.a()
                boolean r2 = r2.f12926f
                if (r2 != 0) goto L5b
                h3.i r2 = r3.a()
                boolean r2 = r2.f12925e
                if (r2 != 0) goto L5b
                return r1
            L5b:
                h3.i r2 = r3.a()
                boolean r2 = r2.f12922b
                if (r2 != 0) goto L6c
                h3.i r2 = r4.a()
                boolean r2 = r2.f12922b
                if (r2 != 0) goto L6c
                r1 = 1
            L6c:
                return r1
            */
            throw new UnsupportedOperationException("Method not decompiled: okhttp3.internal.cache.CacheStrategy.Companion.isCacheable(h3.b0, h3.V):boolean");
        }
    }

    @Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0010\b\n\u0002\b\u0005\u0018\u00002\u00020\u0001B!\u0012\u0006\u0010\u0011\u001a\u00020\b\u0012\u0006\u0010\r\u001a\u00020\f\u0012\b\u0010\u0017\u001a\u0004\u0018\u00010\u0016¢\u0006\u0004\b(\u0010)J\u000f\u0010\u0003\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u0003\u0010\u0004J\u000f\u0010\u0006\u001a\u00020\u0005H\u0002¢\u0006\u0004\b\u0006\u0010\u0007J\u000f\u0010\t\u001a\u00020\bH\u0002¢\u0006\u0004\b\t\u0010\nJ\u000f\u0010\u000b\u001a\u00020\bH\u0002¢\u0006\u0004\b\u000b\u0010\nJ\u0017\u0010\u000e\u001a\u00020\u00022\u0006\u0010\r\u001a\u00020\fH\u0002¢\u0006\u0004\b\u000e\u0010\u000fJ\r\u0010\u0010\u001a\u00020\u0005¢\u0006\u0004\b\u0010\u0010\u0007R\u0014\u0010\u0011\u001a\u00020\b8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0011\u0010\u0012R\u001a\u0010\r\u001a\u00020\f8\u0000X\u0080\u0004¢\u0006\f\n\u0004\b\r\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015R\u0016\u0010\u0017\u001a\u0004\u0018\u00010\u00168\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0017\u0010\u0018R\u0018\u0010\u001a\u001a\u0004\u0018\u00010\u00198\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u001a\u0010\u001bR\u0018\u0010\u001d\u001a\u0004\u0018\u00010\u001c8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u001d\u0010\u001eR\u0018\u0010\u001f\u001a\u0004\u0018\u00010\u00198\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u001f\u0010\u001bR\u0018\u0010 \u001a\u0004\u0018\u00010\u001c8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b \u0010\u001eR\u0018\u0010!\u001a\u0004\u0018\u00010\u00198\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b!\u0010\u001bR\u0016\u0010\"\u001a\u00020\b8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\"\u0010\u0012R\u0016\u0010#\u001a\u00020\b8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b#\u0010\u0012R\u0018\u0010$\u001a\u0004\u0018\u00010\u001c8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b$\u0010\u001eR\u0016\u0010&\u001a\u00020%8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b&\u0010'¨\u0006*"}, d2 = {"Lokhttp3/internal/cache/CacheStrategy$Factory;", "", "", "isFreshnessLifetimeHeuristic", "()Z", "Lokhttp3/internal/cache/CacheStrategy;", "computeCandidate", "()Lokhttp3/internal/cache/CacheStrategy;", "", "computeFreshnessLifetime", "()J", "cacheResponseAge", "Lh3/V;", "request", "hasConditions", "(Lh3/V;)Z", "compute", "nowMillis", "J", "Lh3/V;", "getRequest$okhttp", "()Lh3/V;", "Lh3/b0;", "cacheResponse", "Lh3/b0;", "Ljava/util/Date;", "servedDate", "Ljava/util/Date;", "", "servedDateString", "Ljava/lang/String;", "lastModified", "lastModifiedString", "expires", "sentRequestMillis", "receivedResponseMillis", "etag", "", "ageSeconds", "I", "<init>", "(JLh3/V;Lh3/b0;)V", "okhttp"}, k = 1, mv = {1, 6, 0})
    public static final class Factory {
        private int ageSeconds;

        @Nullable
        private final b0 cacheResponse;

        @Nullable
        private String etag;

        @Nullable
        private Date expires;

        @Nullable
        private Date lastModified;

        @Nullable
        private String lastModifiedString;
        private final long nowMillis;
        private long receivedResponseMillis;

        @NotNull
        private final V request;
        private long sentRequestMillis;

        @Nullable
        private Date servedDate;

        @Nullable
        private String servedDateString;

        public Factory(long j4, @NotNull V request, @Nullable b0 b0Var) {
            Intrinsics.checkNotNullParameter(request, "request");
            this.nowMillis = j4;
            this.request = request;
            this.cacheResponse = b0Var;
            this.ageSeconds = -1;
            if (b0Var != null) {
                this.sentRequestMillis = b0Var.f12874k;
                this.receivedResponseMillis = b0Var.f12875l;
                H h4 = b0Var.f12869f;
                int size = h4.size();
                int i4 = 0;
                while (i4 < size) {
                    int i5 = i4 + 1;
                    String strC = h4.c(i4);
                    String strF = h4.f(i4);
                    if (StringsKt__StringsJVMKt.equals(strC, "Date", true)) {
                        this.servedDate = DatesKt.toHttpDateOrNull(strF);
                        this.servedDateString = strF;
                    } else if (StringsKt__StringsJVMKt.equals(strC, "Expires", true)) {
                        this.expires = DatesKt.toHttpDateOrNull(strF);
                    } else if (StringsKt__StringsJVMKt.equals(strC, "Last-Modified", true)) {
                        this.lastModified = DatesKt.toHttpDateOrNull(strF);
                        this.lastModifiedString = strF;
                    } else if (StringsKt__StringsJVMKt.equals(strC, "ETag", true)) {
                        this.etag = strF;
                    } else if (StringsKt__StringsJVMKt.equals(strC, "Age", true)) {
                        this.ageSeconds = Util.toNonNegativeInt(strF, -1);
                    }
                    i4 = i5;
                }
            }
        }

        private final long cacheResponseAge() {
            Date date = this.servedDate;
            long jMax = date != null ? Math.max(0L, this.receivedResponseMillis - date.getTime()) : 0L;
            int i4 = this.ageSeconds;
            if (i4 != -1) {
                jMax = Math.max(jMax, TimeUnit.SECONDS.toMillis(i4));
            }
            long j4 = this.receivedResponseMillis;
            return jMax + (j4 - this.sentRequestMillis) + (this.nowMillis - j4);
        }

        private final CacheStrategy computeCandidate() {
            String str;
            int i4;
            b0 b0Var = this.cacheResponse;
            if (b0Var == null) {
                return new CacheStrategy(this.request, null);
            }
            V v4 = this.request;
            if ((!v4.f12826a.f12731j || b0Var.f12868e != null) && CacheStrategy.INSTANCE.isCacheable(b0Var, v4)) {
                C0600i c0600iA = this.request.a();
                if (c0600iA.f12921a || hasConditions(this.request)) {
                    return new CacheStrategy(this.request, null);
                }
                C0600i c0600iA2 = this.cacheResponse.a();
                long jCacheResponseAge = cacheResponseAge();
                long jComputeFreshnessLifetime = computeFreshnessLifetime();
                int i5 = c0600iA.f12923c;
                if (i5 != -1) {
                    jComputeFreshnessLifetime = Math.min(jComputeFreshnessLifetime, TimeUnit.SECONDS.toMillis(i5));
                }
                long millis = 0;
                int i6 = c0600iA.f12929i;
                long millis2 = i6 != -1 ? TimeUnit.SECONDS.toMillis(i6) : 0L;
                if (!c0600iA2.f12927g && (i4 = c0600iA.f12928h) != -1) {
                    millis = TimeUnit.SECONDS.toMillis(i4);
                }
                if (!c0600iA2.f12921a) {
                    long j4 = millis2 + jCacheResponseAge;
                    if (j4 < millis + jComputeFreshnessLifetime) {
                        a0 a0VarE = this.cacheResponse.e();
                        if (j4 >= jComputeFreshnessLifetime) {
                            Intrinsics.checkNotNullParameter("Warning", "name");
                            Intrinsics.checkNotNullParameter("110 HttpURLConnection \"Response is stale\"", "value");
                            a0VarE.f12855f.a("Warning", "110 HttpURLConnection \"Response is stale\"");
                        }
                        if (jCacheResponseAge > 86400000 && isFreshnessLifetimeHeuristic()) {
                            Intrinsics.checkNotNullParameter("Warning", "name");
                            Intrinsics.checkNotNullParameter("113 HttpURLConnection \"Heuristic expiration\"", "value");
                            a0VarE.f12855f.a("Warning", "113 HttpURLConnection \"Heuristic expiration\"");
                        }
                        return new CacheStrategy(null, a0VarE.a());
                    }
                }
                String str2 = this.etag;
                if (str2 != null) {
                    str = "If-None-Match";
                } else {
                    if (this.lastModified != null) {
                        str2 = this.lastModifiedString;
                    } else {
                        if (this.servedDate == null) {
                            return new CacheStrategy(this.request, null);
                        }
                        str2 = this.servedDateString;
                    }
                    str = "If-Modified-Since";
                }
                G gD = this.request.f12828c.d();
                Intrinsics.checkNotNull(str2);
                gD.c(str, str2);
                U uC = this.request.c();
                H headers = gD.d();
                Intrinsics.checkNotNullParameter(headers, "headers");
                G gD2 = headers.d();
                Intrinsics.checkNotNullParameter(gD2, "<set-?>");
                uC.f12823c = gD2;
                return new CacheStrategy(uC.b(), this.cacheResponse);
            }
            return new CacheStrategy(this.request, null);
        }

        private final long computeFreshnessLifetime() {
            String string;
            Long lValueOf;
            b0 b0Var = this.cacheResponse;
            Intrinsics.checkNotNull(b0Var);
            int i4 = b0Var.a().f12923c;
            if (i4 != -1) {
                return TimeUnit.SECONDS.toMillis(i4);
            }
            Date date = this.expires;
            if (date != null) {
                Date date2 = this.servedDate;
                lValueOf = date2 != null ? Long.valueOf(date2.getTime()) : null;
                long time = date.getTime() - (lValueOf == null ? this.receivedResponseMillis : lValueOf.longValue());
                if (time > 0) {
                    return time;
                }
                return 0L;
            }
            if (this.lastModified == null) {
                return 0L;
            }
            List list = this.cacheResponse.f12864a.f12826a.f12728g;
            if (list == null) {
                string = null;
            } else {
                StringBuilder sb = new StringBuilder();
                char[] cArr = J.f12721k;
                C0611u.y(list, sb);
                string = sb.toString();
            }
            if (string != null) {
                return 0L;
            }
            Date date3 = this.servedDate;
            lValueOf = date3 != null ? Long.valueOf(date3.getTime()) : null;
            long jLongValue = lValueOf == null ? this.sentRequestMillis : lValueOf.longValue();
            Date date4 = this.lastModified;
            Intrinsics.checkNotNull(date4);
            long time2 = jLongValue - date4.getTime();
            if (time2 > 0) {
                return time2 / 10;
            }
            return 0L;
        }

        private final boolean hasConditions(V request) {
            return (request.b("If-Modified-Since") == null && request.b("If-None-Match") == null) ? false : true;
        }

        private final boolean isFreshnessLifetimeHeuristic() {
            b0 b0Var = this.cacheResponse;
            Intrinsics.checkNotNull(b0Var);
            return b0Var.a().f12923c == -1 && this.expires == null;
        }

        @NotNull
        public final CacheStrategy compute() {
            CacheStrategy cacheStrategyComputeCandidate = computeCandidate();
            return (cacheStrategyComputeCandidate.getNetworkRequest() == null || !this.request.a().f12930j) ? cacheStrategyComputeCandidate : new CacheStrategy(null, null);
        }

        @NotNull
        /* renamed from: getRequest$okhttp, reason: from getter */
        public final V getRequest() {
            return this.request;
        }
    }

    public CacheStrategy(@Nullable V v4, @Nullable b0 b0Var) {
        this.networkRequest = v4;
        this.cacheResponse = b0Var;
    }

    @Nullable
    public final b0 getCacheResponse() {
        return this.cacheResponse;
    }

    @Nullable
    public final V getNetworkRequest() {
        return this.networkRequest;
    }
}
