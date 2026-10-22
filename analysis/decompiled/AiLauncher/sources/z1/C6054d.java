package z1;

import F1.j;
import La.D;
import coil.util.Time;
import com.autonavi.aps.amapapi.config.Const;
import com.stepos.statsapp.v3.lib.plugin.constants.UxipConstants;
import java.util.Date;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.jvm.internal.i;
import kotlin.jvm.internal.p;
import tb.C5528A;
import tb.C5530C;
import tb.C5537d;
import tb.u;

@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\b\u0000\u0018\u0000 \u000e2\u00020\u0001:\u0002\n\bB\u001d\b\u0002\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004¢\u0006\u0004\b\u0006\u0010\u0007R\u0019\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000bR\u0019\u0010\u0005\u001a\u0004\u0018\u00010\u00048\u0006¢\u0006\f\n\u0004\b\n\u0010\f\u001a\u0004\b\b\u0010\r¨\u0006\u000f"}, d2 = {"Lz1/d;", "", "Ltb/A;", "networkRequest", "Lz1/c;", "cacheResponse", "<init>", "(Ltb/A;Lz1/c;)V", Const.INTENT_KEY_APIKEY, "Ltb/A;", Const.INTENT_KEY_PKGNAME, "()Ltb/A;", "Lz1/c;", "()Lz1/c;", "c", "coil-base_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* renamed from: z1.d, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C6054d {

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    public final C5528A networkRequest;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    public final C6053c cacheResponse;

    @Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u001d\u0010\t\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\t\u0010\nJ\u001d\u0010\f\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u000b¢\u0006\u0004\b\f\u0010\rJ\u001d\u0010\u0011\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0010\u001a\u00020\u000e¢\u0006\u0004\b\u0011\u0010\u0012J\u0017\u0010\u0015\u001a\u00020\b2\u0006\u0010\u0014\u001a\u00020\u0013H\u0002¢\u0006\u0004\b\u0015\u0010\u0016J\u0017\u0010\u0017\u001a\u00020\b2\u0006\u0010\u0014\u001a\u00020\u0013H\u0002¢\u0006\u0004\b\u0017\u0010\u0016¨\u0006\u0018"}, d2 = {"Lz1/d$a;", "", "<init>", "()V", "Ltb/A;", "request", "Ltb/C;", UxipConstants.f30685x, "", Const.INTENT_KEY_PKGNAME, "(Ltb/A;Ltb/C;)Z", "Lz1/c;", "c", "(Ltb/A;Lz1/c;)Z", "Ltb/u;", "cachedHeaders", "networkHeaders", Const.INTENT_KEY_APIKEY, "(Ltb/u;Ltb/u;)Ltb/u;", "", "name", "e", "(Ljava/lang/String;)Z", Const.INTENT_KEY_UMID, "coil-base_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    /* renamed from: z1.d$a, reason: from kotlin metadata */
    public static final class Companion {
        public /* synthetic */ Companion(i iVar) {
            this();
        }

        public final u a(u cachedHeaders, u networkHeaders) {
            u.a aVar = new u.a();
            int size = cachedHeaders.size();
            for (int i10 = 0; i10 < size; i10++) {
                String strF = cachedHeaders.f(i10);
                String strK = cachedHeaders.k(i10);
                if ((!D.L("Warning", strF, true) || !D.X(strK, "1", false, 2, null)) && (d(strF) || !e(strF) || networkHeaders.b(strF) == null)) {
                    aVar.e(strF, strK);
                }
            }
            int size2 = networkHeaders.size();
            for (int i11 = 0; i11 < size2; i11++) {
                String strF2 = networkHeaders.f(i11);
                if (!d(strF2) && e(strF2)) {
                    aVar.e(strF2, networkHeaders.k(i11));
                }
            }
            return aVar.f();
        }

        public final boolean b(C5528A request, C5530C response) {
            return (request.b().getNoStore() || response.g().getNoStore() || p.d(response.getHeaders().b("Vary"), "*")) ? false : true;
        }

        public final boolean c(C5528A request, C6053c response) {
            return (request.b().getNoStore() || response.e().getNoStore() || p.d(response.getResponseHeaders().b("Vary"), "*")) ? false : true;
        }

        public final boolean d(String name) {
            return D.L("Content-Length", name, true) || D.L(com.stepos.statsapp.v3.lib.plugin.net.multipart.e.f30849h, name, true) || D.L("Content-Type", name, true);
        }

        public final boolean e(String name) {
            return (D.L(com.stepos.statsapp.v3.lib.plugin.net.multipart.e.f30851j, name, true) || D.L(com.stepos.statsapp.v3.lib.plugin.net.multipart.e.f30858q, name, true) || D.L("Proxy-Authenticate", name, true) || D.L("Proxy-Authorization", name, true) || D.L("TE", name, true) || D.L("Trailers", name, true) || D.L(com.stepos.statsapp.v3.lib.plugin.net.multipart.e.f30846e, name, true) || D.L("Upgrade", name, true)) ? false : true;
        }

        public Companion() {
        }
    }

    @Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u000f\n\u0002\u0010\b\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0019\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004¢\u0006\u0004\b\u0006\u0010\u0007J\r\u0010\t\u001a\u00020\b¢\u0006\u0004\b\t\u0010\nJ\u000f\u0010\f\u001a\u00020\u000bH\u0002¢\u0006\u0004\b\f\u0010\rJ\u000f\u0010\u000e\u001a\u00020\u000bH\u0002¢\u0006\u0004\b\u000e\u0010\rJ\u0017\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0003\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u0010\u0010\u0011R\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000e\u0010\u0012R\u0016\u0010\u0005\u001a\u0004\u0018\u00010\u00048\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\t\u0010\u0013R\u0018\u0010\u0016\u001a\u0004\u0018\u00010\u00148\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\f\u0010\u0015R\u0018\u0010\u0019\u001a\u0004\u0018\u00010\u00178\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0010\u0010\u0018R\u0018\u0010\u001b\u001a\u0004\u0018\u00010\u00148\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u001a\u0010\u0015R\u0018\u0010\u001d\u001a\u0004\u0018\u00010\u00178\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u001c\u0010\u0018R\u0018\u0010\u001f\u001a\u0004\u0018\u00010\u00148\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u001e\u0010\u0015R\u0016\u0010\"\u001a\u00020\u000b8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b \u0010!R\u0016\u0010$\u001a\u00020\u000b8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b#\u0010!R\u0018\u0010&\u001a\u0004\u0018\u00010\u00178\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b%\u0010\u0018R\u0016\u0010*\u001a\u00020'8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b(\u0010)¨\u0006+"}, d2 = {"Lz1/d$b;", "", "Ltb/A;", "request", "Lz1/c;", "cacheResponse", "<init>", "(Ltb/A;Lz1/c;)V", "Lz1/d;", Const.INTENT_KEY_PKGNAME, "()Lz1/d;", "", "c", "()J", Const.INTENT_KEY_APIKEY, "", Const.INTENT_KEY_UMID, "(Ltb/A;)Z", "Ltb/A;", "Lz1/c;", "Ljava/util/Date;", "Ljava/util/Date;", "servedDate", "", "Ljava/lang/String;", "servedDateString", "e", "lastModified", "f", "lastModifiedString", Const.INTENT_KEY_BACKGROUND_COMMAND, "expires", Const.INTENT_KEY_BACKGROUND_NOTIFICATION, "J", "sentRequestMillis", Const.INTENT_KEY_BACKGROUND_NOTIFICATION_ID, "receivedResponseMillis", Const.INTENT_KEY_BACKGROUND_NOTIFICATION_REMOVE, "etag", "", "k", "I", "ageSeconds", "coil-base_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    /* renamed from: z1.d$b */
    public static final class b {

        /* renamed from: a, reason: collision with root package name and from kotlin metadata */
        public final C5528A request;

        /* renamed from: b, reason: collision with root package name and from kotlin metadata */
        public final C6053c cacheResponse;

        /* renamed from: c, reason: collision with root package name and from kotlin metadata */
        public Date servedDate;

        /* renamed from: d, reason: collision with root package name and from kotlin metadata */
        public String servedDateString;

        /* renamed from: e, reason: collision with root package name and from kotlin metadata */
        public Date lastModified;

        /* renamed from: f, reason: collision with root package name and from kotlin metadata */
        public String lastModifiedString;

        /* renamed from: g, reason: collision with root package name and from kotlin metadata */
        public Date expires;

        /* renamed from: h, reason: collision with root package name and from kotlin metadata */
        public long sentRequestMillis;

        /* renamed from: i, reason: collision with root package name and from kotlin metadata */
        public long receivedResponseMillis;

        /* renamed from: j, reason: collision with root package name and from kotlin metadata */
        public String etag;

        /* renamed from: k, reason: collision with root package name and from kotlin metadata */
        public int ageSeconds;

        public b(C5528A c5528a, C6053c c6053c) {
            this.request = c5528a;
            this.cacheResponse = c6053c;
            this.ageSeconds = -1;
            if (c6053c != null) {
                this.sentRequestMillis = c6053c.getSentRequestAtMillis();
                this.receivedResponseMillis = c6053c.getReceivedResponseAtMillis();
                u responseHeaders = c6053c.getResponseHeaders();
                int size = responseHeaders.size();
                for (int i10 = 0; i10 < size; i10++) {
                    String strF = responseHeaders.f(i10);
                    if (D.L(strF, com.stepos.statsapp.v3.lib.plugin.net.multipart.e.f30854m, true)) {
                        this.servedDate = responseHeaders.c(com.stepos.statsapp.v3.lib.plugin.net.multipart.e.f30854m);
                        this.servedDateString = responseHeaders.k(i10);
                    } else if (D.L(strF, "Expires", true)) {
                        this.expires = responseHeaders.c("Expires");
                    } else if (D.L(strF, "Last-Modified", true)) {
                        this.lastModified = responseHeaders.c("Last-Modified");
                        this.lastModifiedString = responseHeaders.k(i10);
                    } else if (D.L(strF, "ETag", true)) {
                        this.etag = responseHeaders.k(i10);
                    } else if (D.L(strF, "Age", true)) {
                        this.ageSeconds = j.z(responseHeaders.k(i10), -1);
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
            return jMax + (this.receivedResponseMillis - this.sentRequestMillis) + (Time.f15818a.a() - this.receivedResponseMillis);
        }

        /* JADX WARN: Multi-variable type inference failed */
        public final C6054d b() {
            String str;
            C6053c c6053c = null;
            Object[] objArr = 0;
            Object[] objArr2 = 0;
            Object[] objArr3 = 0;
            Object[] objArr4 = 0;
            Object[] objArr5 = 0;
            Object[] objArr6 = 0;
            Object[] objArr7 = 0;
            Object[] objArr8 = 0;
            Object[] objArr9 = 0;
            Object[] objArr10 = 0;
            Object[] objArr11 = 0;
            Object[] objArr12 = 0;
            if (this.cacheResponse == null) {
                return new C6054d(this.request, c6053c, objArr12 == true ? 1 : 0);
            }
            if (this.request.g() && !this.cacheResponse.getIsTls()) {
                return new C6054d(this.request, objArr11 == true ? 1 : 0, objArr10 == true ? 1 : 0);
            }
            C5537d c5537dE = this.cacheResponse.e();
            if (!C6054d.INSTANCE.c(this.request, this.cacheResponse)) {
                return new C6054d(this.request, objArr9 == true ? 1 : 0, objArr8 == true ? 1 : 0);
            }
            C5537d c5537dB = this.request.b();
            if (c5537dB.getNoCache() || d(this.request)) {
                return new C6054d(this.request, objArr2 == true ? 1 : 0, objArr == true ? 1 : 0);
            }
            long jA = a();
            long jC = c();
            if (c5537dB.getMaxAgeSeconds() != -1) {
                jC = Math.min(jC, TimeUnit.SECONDS.toMillis(c5537dB.getMaxAgeSeconds()));
            }
            long millis = 0;
            long millis2 = c5537dB.getMinFreshSeconds() != -1 ? TimeUnit.SECONDS.toMillis(c5537dB.getMinFreshSeconds()) : 0L;
            if (!c5537dE.getMustRevalidate() && c5537dB.getMaxStaleSeconds() != -1) {
                millis = TimeUnit.SECONDS.toMillis(c5537dB.getMaxStaleSeconds());
            }
            if (!c5537dE.getNoCache() && jA + millis2 < jC + millis) {
                return new C6054d(objArr7 == true ? 1 : 0, this.cacheResponse, objArr6 == true ? 1 : 0);
            }
            String str2 = this.etag;
            if (str2 != null) {
                p.f(str2);
                str = "If-None-Match";
            } else {
                str = "If-Modified-Since";
                if (this.lastModified != null) {
                    str2 = this.lastModifiedString;
                    p.f(str2);
                } else {
                    if (this.servedDate == null) {
                        return new C6054d(this.request, objArr4 == true ? 1 : 0, objArr3 == true ? 1 : 0);
                    }
                    str2 = this.servedDateString;
                    p.f(str2);
                }
            }
            return new C6054d(this.request.i().a(str, str2).b(), this.cacheResponse, objArr5 == true ? 1 : 0);
        }

        public final long c() {
            C6053c c6053c = this.cacheResponse;
            p.f(c6053c);
            if (c6053c.e().getMaxAgeSeconds() != -1) {
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
            if (this.lastModified != null && this.request.getUrl().n() == null) {
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

        public final boolean d(C5528A request) {
            return (request.e("If-Modified-Since") == null && request.e("If-None-Match") == null) ? false : true;
        }
    }

    public /* synthetic */ C6054d(C5528A c5528a, C6053c c6053c, i iVar) {
        this(c5528a, c6053c);
    }

    /* renamed from: a, reason: from getter */
    public final C6053c getCacheResponse() {
        return this.cacheResponse;
    }

    /* renamed from: b, reason: from getter */
    public final C5528A getNetworkRequest() {
        return this.networkRequest;
    }

    public C6054d(C5528A c5528a, C6053c c6053c) {
        this.networkRequest = c5528a;
        this.cacheResponse = c6053c;
    }
}
