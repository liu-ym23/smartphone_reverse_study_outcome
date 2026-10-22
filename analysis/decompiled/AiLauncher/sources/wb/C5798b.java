package wb;

import La.D;
import com.autonavi.aps.amapapi.config.Const;
import com.stepos.statsapp.v3.lib.plugin.constants.UxipConstants;
import com.stepos.statsapp.v3.lib.plugin.net.multipart.e;
import java.util.Date;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.jvm.internal.i;
import kotlin.jvm.internal.p;
import tb.C5528A;
import tb.C5530C;
import tb.C5537d;
import tb.u;
import ub.n;
import zb.C6479c;

@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\u0018\u0000 \u000e2\u00020\u0001:\u0002\n\bB\u001d\b\u0000\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004¢\u0006\u0004\b\u0006\u0010\u0007R\u0019\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000bR\u0019\u0010\u0005\u001a\u0004\u0018\u00010\u00048\u0006¢\u0006\f\n\u0004\b\n\u0010\f\u001a\u0004\b\b\u0010\r¨\u0006\u000f"}, d2 = {"Lwb/b;", "", "Ltb/A;", "networkRequest", "Ltb/C;", "cacheResponse", "<init>", "(Ltb/A;Ltb/C;)V", Const.INTENT_KEY_APIKEY, "Ltb/A;", Const.INTENT_KEY_PKGNAME, "()Ltb/A;", "Ltb/C;", "()Ltb/C;", "c", "okhttp"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* renamed from: wb.b, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C5798b {

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    public final C5528A networkRequest;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    public final C5530C cacheResponse;

    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u001d\u0010\t\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\t\u0010\n¨\u0006\u000b"}, d2 = {"Lwb/b$a;", "", "<init>", "()V", "Ltb/C;", UxipConstants.f30685x, "Ltb/A;", "request", "", Const.INTENT_KEY_APIKEY, "(Ltb/C;Ltb/A;)Z", "okhttp"}, k = 1, mv = {2, 1, 0}, xi = 48)
    /* renamed from: wb.b$a, reason: from kotlin metadata */
    public static final class Companion {
        public /* synthetic */ Companion(i iVar) {
            this();
        }

        /* JADX WARN: Removed duplicated region for block: B:24:0x003b  */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public final boolean a(tb.C5530C r4, tb.C5528A r5) {
            /*
                r3 = this;
                java.lang.String r3 = "response"
                kotlin.jvm.internal.p.i(r4, r3)
                java.lang.String r3 = "request"
                kotlin.jvm.internal.p.i(r5, r3)
                int r3 = r4.getCode()
                r0 = 200(0xc8, float:2.8E-43)
                r1 = 0
                if (r3 == r0) goto L65
                r0 = 410(0x19a, float:5.75E-43)
                if (r3 == r0) goto L65
                r0 = 414(0x19e, float:5.8E-43)
                if (r3 == r0) goto L65
                r0 = 501(0x1f5, float:7.02E-43)
                if (r3 == r0) goto L65
                r0 = 203(0xcb, float:2.84E-43)
                if (r3 == r0) goto L65
                r0 = 204(0xcc, float:2.86E-43)
                if (r3 == r0) goto L65
                r0 = 307(0x133, float:4.3E-43)
                if (r3 == r0) goto L3b
                r0 = 308(0x134, float:4.32E-43)
                if (r3 == r0) goto L65
                r0 = 404(0x194, float:5.66E-43)
                if (r3 == r0) goto L65
                r0 = 405(0x195, float:5.68E-43)
                if (r3 == r0) goto L65
                switch(r3) {
                    case 300: goto L65;
                    case 301: goto L65;
                    case 302: goto L3b;
                    default: goto L3a;
                }
            L3a:
                return r1
            L3b:
                java.lang.String r3 = "Expires"
                r0 = 2
                r2 = 0
                java.lang.String r3 = tb.C5530C.J(r4, r3, r2, r0, r2)
                if (r3 != 0) goto L65
                tb.d r3 = r4.g()
                int r3 = r3.getMaxAgeSeconds()
                r0 = -1
                if (r3 != r0) goto L65
                tb.d r3 = r4.g()
                boolean r3 = r3.getIsPublic()
                if (r3 != 0) goto L65
                tb.d r3 = r4.g()
                boolean r3 = r3.getIsPrivate()
                if (r3 != 0) goto L65
                return r1
            L65:
                tb.d r3 = r4.g()
                boolean r3 = r3.getNoStore()
                if (r3 != 0) goto L7b
                tb.d r3 = r5.b()
                boolean r3 = r3.getNoStore()
                if (r3 != 0) goto L7b
                r3 = 1
                return r3
            L7b:
                return r1
            */
            throw new UnsupportedOperationException("Method not decompiled: wb.C5798b.Companion.a(tb.C, tb.A):boolean");
        }

        public Companion() {
        }
    }

    @Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\r\n\u0002\u0010\b\n\u0002\b\u0004\u0018\u00002\u00020\u0001B!\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006¢\u0006\u0004\b\b\u0010\tJ\r\u0010\u000b\u001a\u00020\n¢\u0006\u0004\b\u000b\u0010\fJ\u000f\u0010\u000e\u001a\u00020\rH\u0002¢\u0006\u0004\b\u000e\u0010\u000fJ\u000f\u0010\u0010\u001a\u00020\nH\u0002¢\u0006\u0004\b\u0010\u0010\fJ\u000f\u0010\u0011\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u0011\u0010\u0012J\u000f\u0010\u0013\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u0013\u0010\u0012J\u0017\u0010\u0014\u001a\u00020\r2\u0006\u0010\u0005\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0014\u0010\u0015R\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0013\u0010\u0016R\u001a\u0010\u0005\u001a\u00020\u00048\u0000X\u0080\u0004¢\u0006\f\n\u0004\b\u000b\u0010\u0017\u001a\u0004\b\u0018\u0010\u0019R\u0016\u0010\u0007\u001a\u0004\u0018\u00010\u00068\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0010\u0010\u001aR\u0018\u0010\u001d\u001a\u0004\u0018\u00010\u001b8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0011\u0010\u001cR\u0018\u0010 \u001a\u0004\u0018\u00010\u001e8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0014\u0010\u001fR\u0018\u0010!\u001a\u0004\u0018\u00010\u001b8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u000e\u0010\u001cR\u0018\u0010#\u001a\u0004\u0018\u00010\u001e8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\"\u0010\u001fR\u0018\u0010%\u001a\u0004\u0018\u00010\u001b8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b$\u0010\u001cR\u0016\u0010'\u001a\u00020\u00028\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b&\u0010\u0016R\u0016\u0010)\u001a\u00020\u00028\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b(\u0010\u0016R\u0018\u0010+\u001a\u0004\u0018\u00010\u001e8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b*\u0010\u001fR\u0016\u0010/\u001a\u00020,8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b-\u0010.¨\u00060"}, d2 = {"Lwb/b$b;", "", "", "nowMillis", "Ltb/A;", "request", "Ltb/C;", "cacheResponse", "<init>", "(JLtb/A;Ltb/C;)V", "Lwb/b;", Const.INTENT_KEY_PKGNAME, "()Lwb/b;", "", "f", "()Z", "c", Const.INTENT_KEY_UMID, "()J", Const.INTENT_KEY_APIKEY, "e", "(Ltb/A;)Z", "J", "Ltb/A;", "getRequest$okhttp", "()Ltb/A;", "Ltb/C;", "Ljava/util/Date;", "Ljava/util/Date;", "servedDate", "", "Ljava/lang/String;", "servedDateString", "lastModified", Const.INTENT_KEY_BACKGROUND_COMMAND, "lastModifiedString", Const.INTENT_KEY_BACKGROUND_NOTIFICATION, "expires", Const.INTENT_KEY_BACKGROUND_NOTIFICATION_ID, "sentRequestMillis", Const.INTENT_KEY_BACKGROUND_NOTIFICATION_REMOVE, "receivedResponseMillis", "k", "etag", "", "l", "I", "ageSeconds", "okhttp"}, k = 1, mv = {2, 1, 0}, xi = 48)
    /* renamed from: wb.b$b, reason: collision with other inner class name */
    public static final class C0549b {

        /* renamed from: a, reason: collision with root package name and from kotlin metadata */
        public final long nowMillis;

        /* renamed from: b, reason: collision with root package name and from kotlin metadata */
        public final C5528A request;

        /* renamed from: c, reason: collision with root package name and from kotlin metadata */
        public final C5530C cacheResponse;

        /* renamed from: d, reason: collision with root package name and from kotlin metadata */
        public Date servedDate;

        /* renamed from: e, reason: collision with root package name and from kotlin metadata */
        public String servedDateString;

        /* renamed from: f, reason: collision with root package name and from kotlin metadata */
        public Date lastModified;

        /* renamed from: g, reason: collision with root package name and from kotlin metadata */
        public String lastModifiedString;

        /* renamed from: h, reason: collision with root package name and from kotlin metadata */
        public Date expires;

        /* renamed from: i, reason: collision with root package name and from kotlin metadata */
        public long sentRequestMillis;

        /* renamed from: j, reason: collision with root package name and from kotlin metadata */
        public long receivedResponseMillis;

        /* renamed from: k, reason: collision with root package name and from kotlin metadata */
        public String etag;

        /* renamed from: l, reason: collision with root package name and from kotlin metadata */
        public int ageSeconds;

        public C0549b(long j10, C5528A request, C5530C c5530c) {
            p.i(request, "request");
            this.nowMillis = j10;
            this.request = request;
            this.cacheResponse = c5530c;
            this.ageSeconds = -1;
            if (c5530c != null) {
                this.sentRequestMillis = c5530c.getSentRequestAtMillis();
                this.receivedResponseMillis = c5530c.getReceivedResponseAtMillis();
                u headers = c5530c.getHeaders();
                int size = headers.size();
                for (int i10 = 0; i10 < size; i10++) {
                    String strF = headers.f(i10);
                    String strK = headers.k(i10);
                    if (D.L(strF, e.f30854m, true)) {
                        this.servedDate = C6479c.a(strK);
                        this.servedDateString = strK;
                    } else if (D.L(strF, "Expires", true)) {
                        this.expires = C6479c.a(strK);
                    } else if (D.L(strF, "Last-Modified", true)) {
                        this.lastModified = C6479c.a(strK);
                        this.lastModifiedString = strK;
                    } else if (D.L(strF, "ETag", true)) {
                        this.etag = strK;
                    } else if (D.L(strF, "Age", true)) {
                        this.ageSeconds = n.A(strK, -1);
                    }
                }
            }
        }

        public final long a() {
            Date date = this.servedDate;
            long jMax = date != null ? Math.max(0L, this.receivedResponseMillis - date.getTime()) : 0L;
            int i10 = this.ageSeconds;
            if (i10 != -1) {
                jMax = Math.max(jMax, TimeUnit.SECONDS.toMillis(i10));
            }
            return jMax + Math.max(0L, this.receivedResponseMillis - this.sentRequestMillis) + Math.max(0L, this.nowMillis - this.receivedResponseMillis);
        }

        public final C5798b b() {
            C5798b c5798bC = c();
            return (c5798bC.getNetworkRequest() == null || !this.request.b().getOnlyIfCached()) ? c5798bC : new C5798b(null, null);
        }

        public final C5798b c() {
            String str;
            if (this.cacheResponse == null) {
                return new C5798b(this.request, null);
            }
            if ((!this.request.g() || this.cacheResponse.getHandshake() != null) && C5798b.INSTANCE.a(this.cacheResponse, this.request)) {
                C5537d c5537dB = this.request.b();
                if (c5537dB.getNoCache() || e(this.request)) {
                    return new C5798b(this.request, null);
                }
                C5537d c5537dG = this.cacheResponse.g();
                long jA = a();
                long jD = d();
                if (c5537dB.getMaxAgeSeconds() != -1) {
                    jD = Math.min(jD, TimeUnit.SECONDS.toMillis(c5537dB.getMaxAgeSeconds()));
                }
                long millis = 0;
                long millis2 = c5537dB.getMinFreshSeconds() != -1 ? TimeUnit.SECONDS.toMillis(c5537dB.getMinFreshSeconds()) : 0L;
                if (!c5537dG.getMustRevalidate() && c5537dB.getMaxStaleSeconds() != -1) {
                    millis = TimeUnit.SECONDS.toMillis(c5537dB.getMaxStaleSeconds());
                }
                if (!c5537dG.getNoCache()) {
                    long j10 = millis2 + jA;
                    if (j10 < millis + jD) {
                        C5530C.a aVarE0 = this.cacheResponse.e0();
                        if (j10 >= jD) {
                            aVarE0.a("Warning", "110 HttpURLConnection \"Response is stale\"");
                        }
                        if (jA > 86400000 && f()) {
                            aVarE0.a("Warning", "113 HttpURLConnection \"Heuristic expiration\"");
                        }
                        return new C5798b(null, aVarE0.c());
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
                            return new C5798b(this.request, null);
                        }
                        str2 = this.servedDateString;
                    }
                    str = "If-Modified-Since";
                }
                u.a aVarI = this.request.getHeaders().i();
                p.f(str2);
                aVarI.d(str, str2);
                return new C5798b(this.request.i().m(aVarI.f()).b(), this.cacheResponse);
            }
            return new C5798b(this.request, null);
        }

        public final long d() {
            C5530C c5530c = this.cacheResponse;
            p.f(c5530c);
            if (c5530c.g().getMaxAgeSeconds() != -1) {
                return TimeUnit.SECONDS.toMillis(r0.getMaxAgeSeconds());
            }
            Date date = this.expires;
            if (date != null) {
                Date date2 = this.servedDate;
                long time = date.getTime() - (date2 != null ? date2.getTime() : this.receivedResponseMillis);
                if (time > 0) {
                    return time;
                }
                return 0L;
            }
            if (this.lastModified != null && this.cacheResponse.getRequest().getUrl().n() == null) {
                Date date3 = this.servedDate;
                long time2 = date3 != null ? date3.getTime() : this.sentRequestMillis;
                Date date4 = this.lastModified;
                p.f(date4);
                long time3 = time2 - date4.getTime();
                if (time3 > 0) {
                    return time3 / 10;
                }
            }
            return 0L;
        }

        public final boolean e(C5528A request) {
            return (request.e("If-Modified-Since") == null && request.e("If-None-Match") == null) ? false : true;
        }

        public final boolean f() {
            C5530C c5530c = this.cacheResponse;
            p.f(c5530c);
            return c5530c.g().getMaxAgeSeconds() == -1 && this.expires == null;
        }
    }

    public C5798b(C5528A c5528a, C5530C c5530c) {
        this.networkRequest = c5528a;
        this.cacheResponse = c5530c;
    }

    /* renamed from: a, reason: from getter */
    public final C5530C getCacheResponse() {
        return this.cacheResponse;
    }

    /* renamed from: b, reason: from getter */
    public final C5528A getNetworkRequest() {
        return this.networkRequest;
    }
}
