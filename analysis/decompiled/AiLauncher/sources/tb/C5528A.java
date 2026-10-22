package tb;

import Z8.C1173v;
import androidx.exifinterface.media.ExifInterface;
import com.autonavi.aps.amapapi.config.Const;
import com.stepos.statsapp.v3.lib.plugin.constants.UxipConstants;
import io.modelcontextprotocol.spec.HttpHeaders;
import kotlin.Metadata;
import kotlin.Pair;
import o9.C5013a;
import tb.u;
import ub.C5641a;
import w9.InterfaceC5745d;

@Metadata(d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0005\u0018\u00002\u00020\u0001:\u0001\u0017B\u0011\b\u0000\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u0017\u0010\b\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\b\u0010\tJ'\u0010\r\u001a\u0004\u0018\u00018\u0000\"\b\b\u0000\u0010\n*\u00020\u00012\f\u0010\f\u001a\b\u0012\u0004\u0012\u00028\u00000\u000b¢\u0006\u0004\b\r\u0010\u000eJ%\u0010\u0010\u001a\u0004\u0018\u00018\u0000\"\u0004\b\u0000\u0010\n2\u000e\u0010\f\u001a\n\u0012\u0006\b\u0001\u0012\u00028\u00000\u000f¢\u0006\u0004\b\u0010\u0010\u0011J\r\u0010\u0012\u001a\u00020\u0002¢\u0006\u0004\b\u0012\u0010\u0013J\u000f\u0010\u0014\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\u0014\u0010\u0015R\u0017\u0010\u001b\u001a\u00020\u00168\u0007¢\u0006\f\n\u0004\b\u0017\u0010\u0018\u001a\u0004\b\u0019\u0010\u001aR\u0017\u0010\u001f\u001a\u00020\u00068\u0007¢\u0006\f\n\u0004\b\u001c\u0010\u001d\u001a\u0004\b\u001e\u0010\u0015R\u0017\u0010%\u001a\u00020 8\u0007¢\u0006\f\n\u0004\b!\u0010\"\u001a\u0004\b#\u0010$R\u0019\u0010*\u001a\u0004\u0018\u00010&8\u0007¢\u0006\f\n\u0004\b'\u0010(\u001a\u0004\b\u0017\u0010)R\u0019\u0010+\u001a\u0004\u0018\u00010\u00168\u0007¢\u0006\f\n\u0004\b\b\u0010\u0018\u001a\u0004\b!\u0010\u001aR\u001a\u0010/\u001a\u00020,8\u0000X\u0080\u0004¢\u0006\f\n\u0004\b#\u0010-\u001a\u0004\b'\u0010.R\u0018\u00103\u001a\u0004\u0018\u0001008\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b1\u00102R\u0011\u00106\u001a\u0002048F¢\u0006\u0006\u001a\u0004\b1\u00105R\u0011\u00108\u001a\u0002008G¢\u0006\u0006\u001a\u0004\b\u001c\u00107¨\u00069"}, d2 = {"Ltb/A;", "", "Ltb/A$a;", "builder", "<init>", "(Ltb/A$a;)V", "", "name", "e", "(Ljava/lang/String;)Ljava/lang/String;", ExifInterface.GPS_DIRECTION_TRUE, "Lw9/d;", "type", "k", "(Lw9/d;)Ljava/lang/Object;", "Ljava/lang/Class;", Const.INTENT_KEY_BACKGROUND_NOTIFICATION_REMOVE, "(Ljava/lang/Class;)Ljava/lang/Object;", Const.INTENT_KEY_BACKGROUND_NOTIFICATION_ID, "()Ltb/A$a;", "toString", "()Ljava/lang/String;", "Ltb/v;", Const.INTENT_KEY_APIKEY, "Ltb/v;", "l", "()Ltb/v;", "url", Const.INTENT_KEY_PKGNAME, "Ljava/lang/String;", Const.INTENT_KEY_BACKGROUND_NOTIFICATION, "method", "Ltb/u;", "c", "Ltb/u;", "f", "()Ltb/u;", "headers", "Ltb/B;", Const.INTENT_KEY_UMID, "Ltb/B;", "()Ltb/B;", "body", "cacheUrlOverride", "Lub/g;", "Lub/g;", "()Lub/g;", "tags", "Ltb/d;", Const.INTENT_KEY_BACKGROUND_COMMAND, "Ltb/d;", "lazyCacheControl", "", "()Z", "isHttps", "()Ltb/d;", "cacheControl", "okhttp"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* renamed from: tb.A, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C5528A {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    public final v url;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    public final String method;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    public final u headers;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    public final AbstractC5529B body;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    public final v cacheUrlOverride;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    public final ub.g tags;

    /* renamed from: g, reason: collision with root package name and from kotlin metadata */
    public C5537d lazyCacheControl;

    public C5528A(a builder) {
        kotlin.jvm.internal.p.i(builder, "builder");
        v url = builder.getUrl();
        if (url == null) {
            throw new IllegalStateException("url == null");
        }
        this.url = url;
        this.method = builder.getMethod();
        this.headers = builder.getHeaders().f();
        this.body = builder.getBody();
        this.cacheUrlOverride = builder.getCacheUrlOverride();
        this.tags = builder.getTags();
    }

    /* renamed from: a, reason: from getter */
    public final AbstractC5529B getBody() {
        return this.body;
    }

    public final C5537d b() {
        C5537d c5537d = this.lazyCacheControl;
        if (c5537d != null) {
            return c5537d;
        }
        C5537d c5537dA = C5537d.INSTANCE.a(this.headers);
        this.lazyCacheControl = c5537dA;
        return c5537dA;
    }

    /* renamed from: c, reason: from getter */
    public final v getCacheUrlOverride() {
        return this.cacheUrlOverride;
    }

    /* renamed from: d, reason: from getter */
    public final ub.g getTags() {
        return this.tags;
    }

    public final String e(String name) {
        kotlin.jvm.internal.p.i(name, "name");
        return this.headers.b(name);
    }

    /* renamed from: f, reason: from getter */
    public final u getHeaders() {
        return this.headers;
    }

    public final boolean g() {
        return this.url.i();
    }

    /* renamed from: h, reason: from getter */
    public final String getMethod() {
        return this.method;
    }

    public final a i() {
        return new a(this);
    }

    public final <T> T j(Class<? extends T> type) {
        kotlin.jvm.internal.p.i(type, "type");
        return (T) k(C5013a.e(type));
    }

    public final <T> T k(InterfaceC5745d<T> type) {
        kotlin.jvm.internal.p.i(type, "type");
        return (T) C5013a.b(type).cast(this.tags.a(type));
    }

    /* renamed from: l, reason: from getter */
    public final v getUrl() {
        return this.url;
    }

    public String toString() {
        StringBuilder sb2 = new StringBuilder(32);
        sb2.append("Request{method=");
        sb2.append(this.method);
        sb2.append(", url=");
        sb2.append(this.url);
        if (this.headers.size() != 0) {
            sb2.append(", headers=[");
            int i10 = 0;
            for (Pair<? extends String, ? extends String> pair : this.headers) {
                int i11 = i10 + 1;
                if (i10 < 0) {
                    C1173v.w();
                }
                Pair<? extends String, ? extends String> pair2 = pair;
                String strA = pair2.a();
                String strB = pair2.b();
                if (i10 > 0) {
                    sb2.append(", ");
                }
                sb2.append(strA);
                sb2.append(':');
                if (ub.n.v(strA)) {
                    strB = "██";
                }
                sb2.append(strB);
                i10 = i11;
            }
            sb2.append(']');
        }
        if (!kotlin.jvm.internal.p.d(this.tags, C5641a.f42661a)) {
            sb2.append(", tags=");
            sb2.append(this.tags);
        }
        sb2.append('}');
        return sb2.toString();
    }

    @Metadata(d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0016\u0018\u00002\u00020\u0001B\t\b\u0016¢\u0006\u0004\b\u0002\u0010\u0003B\u0011\b\u0010\u0012\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0002\u0010\u0006J\u0017\u0010\t\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u0007H\u0002¢\u0006\u0004\b\t\u0010\nJ\u0017\u0010\f\u001a\u00020\u00002\u0006\u0010\b\u001a\u00020\u000bH\u0016¢\u0006\u0004\b\f\u0010\rJ\u0017\u0010\u000e\u001a\u00020\u00002\u0006\u0010\b\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\u000e\u0010\u000fJ\u001f\u0010\u0012\u001a\u00020\u00002\u0006\u0010\u0010\u001a\u00020\u00072\u0006\u0010\u0011\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\u0012\u0010\u0013J\u001f\u0010\u0014\u001a\u00020\u00002\u0006\u0010\u0010\u001a\u00020\u00072\u0006\u0010\u0011\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\u0014\u0010\u0013J\u0017\u0010\u0015\u001a\u00020\u00002\u0006\u0010\u0010\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\u0015\u0010\u000fJ\u0017\u0010\u0018\u001a\u00020\u00002\u0006\u0010\u0017\u001a\u00020\u0016H\u0016¢\u0006\u0004\b\u0018\u0010\u0019J\u0017\u0010\u001c\u001a\u00020\u00002\u0006\u0010\u001b\u001a\u00020\u001aH\u0016¢\u0006\u0004\b\u001c\u0010\u001dJ\u000f\u0010\u001e\u001a\u00020\u0000H\u0016¢\u0006\u0004\b\u001e\u0010\u001fJ\u0017\u0010\"\u001a\u00020\u00002\u0006\u0010!\u001a\u00020 H\u0016¢\u0006\u0004\b\"\u0010#J\u0017\u0010$\u001a\u00020\u00002\u0006\u0010!\u001a\u00020 H\u0016¢\u0006\u0004\b$\u0010#J!\u0010&\u001a\u00020\u00002\u0006\u0010%\u001a\u00020\u00072\b\u0010!\u001a\u0004\u0018\u00010 H\u0016¢\u0006\u0004\b&\u0010'J/\u0010,\u001a\u00020\u0000\"\b\b\u0000\u0010(*\u00020\u00012\f\u0010*\u001a\b\u0012\u0004\u0012\u00028\u00000)2\b\u0010+\u001a\u0004\u0018\u00018\u0000¢\u0006\u0004\b,\u0010-J/\u0010/\u001a\u00020\u0000\"\u0004\b\u0000\u0010(2\u000e\u0010*\u001a\n\u0012\u0006\b\u0000\u0012\u00028\u00000.2\b\u0010+\u001a\u0004\u0018\u00018\u0000H\u0016¢\u0006\u0004\b/\u00100J\u000f\u00101\u001a\u00020\u0004H\u0016¢\u0006\u0004\b1\u00102R$\u0010\b\u001a\u0004\u0018\u00010\u000b8\u0000@\u0000X\u0080\u000e¢\u0006\u0012\n\u0004\b\u0014\u00103\u001a\u0004\b4\u00105\"\u0004\b6\u00107R\"\u0010%\u001a\u00020\u00078\u0000@\u0000X\u0080\u000e¢\u0006\u0012\n\u0004\b1\u00108\u001a\u0004\b9\u0010:\"\u0004\b;\u0010<R\"\u0010\u0017\u001a\u00020=8\u0000@\u0000X\u0080\u000e¢\u0006\u0012\n\u0004\b\u001c\u0010>\u001a\u0004\b?\u0010@\"\u0004\bA\u0010BR$\u0010!\u001a\u0004\u0018\u00010 8\u0000@\u0000X\u0080\u000e¢\u0006\u0012\n\u0004\b\t\u0010C\u001a\u0004\bD\u0010E\"\u0004\bF\u0010GR$\u0010J\u001a\u0004\u0018\u00010\u000b8\u0000@\u0000X\u0080\u000e¢\u0006\u0012\n\u0004\b\u001e\u00103\u001a\u0004\bH\u00105\"\u0004\bI\u00107R\"\u0010Q\u001a\u00020K8\u0000@\u0000X\u0080\u000e¢\u0006\u0012\n\u0004\bD\u0010L\u001a\u0004\bM\u0010N\"\u0004\bO\u0010P¨\u0006R"}, d2 = {"Ltb/A$a;", "", "<init>", "()V", "Ltb/A;", "request", "(Ltb/A;)V", "", "url", Const.INTENT_KEY_UMID, "(Ljava/lang/String;)Ljava/lang/String;", "Ltb/v;", "u", "(Ltb/v;)Ltb/A$a;", "t", "(Ljava/lang/String;)Ltb/A$a;", "name", UxipConstants.f30680s, "l", "(Ljava/lang/String;Ljava/lang/String;)Ltb/A$a;", Const.INTENT_KEY_APIKEY, "q", "Ltb/u;", "headers", "m", "(Ltb/u;)Ltb/A$a;", "Ltb/d;", "cacheControl", "c", "(Ltb/d;)Ltb/A$a;", "e", "()Ltb/A$a;", "Ltb/B;", "body", "o", "(Ltb/B;)Ltb/A$a;", "p", "method", "n", "(Ljava/lang/String;Ltb/B;)Ltb/A$a;", ExifInterface.GPS_DIRECTION_TRUE, "Lw9/d;", "type", "tag", "s", "(Lw9/d;Ljava/lang/Object;)Ltb/A$a;", "Ljava/lang/Class;", "r", "(Ljava/lang/Class;Ljava/lang/Object;)Ltb/A$a;", Const.INTENT_KEY_PKGNAME, "()Ltb/A;", "Ltb/v;", "k", "()Ltb/v;", "setUrl$okhttp", "(Ltb/v;)V", "Ljava/lang/String;", Const.INTENT_KEY_BACKGROUND_NOTIFICATION_ID, "()Ljava/lang/String;", "setMethod$okhttp", "(Ljava/lang/String;)V", "Ltb/u$a;", "Ltb/u$a;", Const.INTENT_KEY_BACKGROUND_NOTIFICATION, "()Ltb/u$a;", "setHeaders$okhttp", "(Ltb/u$a;)V", "Ltb/B;", "f", "()Ltb/B;", "setBody$okhttp", "(Ltb/B;)V", Const.INTENT_KEY_BACKGROUND_COMMAND, "setCacheUrlOverride$okhttp", "cacheUrlOverride", "Lub/g;", "Lub/g;", Const.INTENT_KEY_BACKGROUND_NOTIFICATION_REMOVE, "()Lub/g;", "setTags$okhttp", "(Lub/g;)V", "tags", "okhttp"}, k = 1, mv = {2, 1, 0}, xi = 48)
    /* renamed from: tb.A$a */
    public static class a {

        /* renamed from: a, reason: collision with root package name and from kotlin metadata */
        public v url;

        /* renamed from: b, reason: collision with root package name and from kotlin metadata */
        public String method;

        /* renamed from: c, reason: collision with root package name and from kotlin metadata */
        public u.a headers;

        /* renamed from: d, reason: collision with root package name and from kotlin metadata */
        public AbstractC5529B body;

        /* renamed from: e, reason: collision with root package name and from kotlin metadata */
        public v cacheUrlOverride;

        /* renamed from: f, reason: collision with root package name and from kotlin metadata */
        public ub.g tags;

        public a() {
            this.tags = C5641a.f42661a;
            this.method = "GET";
            this.headers = new u.a();
        }

        public a a(String name, String value) {
            kotlin.jvm.internal.p.i(name, "name");
            kotlin.jvm.internal.p.i(value, "value");
            this.headers.a(name, value);
            return this;
        }

        public C5528A b() {
            return new C5528A(this);
        }

        public a c(C5537d cacheControl) {
            kotlin.jvm.internal.p.i(cacheControl, "cacheControl");
            String string = cacheControl.toString();
            return string.length() == 0 ? q(HttpHeaders.CACHE_CONTROL) : l(HttpHeaders.CACHE_CONTROL, string);
        }

        public final String d(String url) {
            if (La.D.V(url, "ws:", true)) {
                StringBuilder sb2 = new StringBuilder();
                sb2.append(Const.HTTP_START);
                String strSubstring = url.substring(3);
                kotlin.jvm.internal.p.h(strSubstring, "substring(...)");
                sb2.append(strSubstring);
                return sb2.toString();
            }
            if (!La.D.V(url, "wss:", true)) {
                return url;
            }
            StringBuilder sb3 = new StringBuilder();
            sb3.append(Const.HTTPS_START);
            String strSubstring2 = url.substring(4);
            kotlin.jvm.internal.p.h(strSubstring2, "substring(...)");
            sb3.append(strSubstring2);
            return sb3.toString();
        }

        public a e() {
            return n("GET", null);
        }

        /* renamed from: f, reason: from getter */
        public final AbstractC5529B getBody() {
            return this.body;
        }

        /* renamed from: g, reason: from getter */
        public final v getCacheUrlOverride() {
            return this.cacheUrlOverride;
        }

        /* renamed from: h, reason: from getter */
        public final u.a getHeaders() {
            return this.headers;
        }

        /* renamed from: i, reason: from getter */
        public final String getMethod() {
            return this.method;
        }

        /* renamed from: j, reason: from getter */
        public final ub.g getTags() {
            return this.tags;
        }

        /* renamed from: k, reason: from getter */
        public final v getUrl() {
            return this.url;
        }

        public a l(String name, String value) {
            kotlin.jvm.internal.p.i(name, "name");
            kotlin.jvm.internal.p.i(value, "value");
            this.headers.i(name, value);
            return this;
        }

        public a m(u headers) {
            kotlin.jvm.internal.p.i(headers, "headers");
            this.headers = headers.i();
            return this;
        }

        public a n(String method, AbstractC5529B body) {
            kotlin.jvm.internal.p.i(method, "method");
            if (method.length() <= 0) {
                throw new IllegalArgumentException("method.isEmpty() == true");
            }
            if (body == null) {
                if (zb.f.d(method)) {
                    throw new IllegalArgumentException(("method " + method + " must have a request body.").toString());
                }
            } else if (!zb.f.a(method)) {
                throw new IllegalArgumentException(("method " + method + " must not have a request body.").toString());
            }
            this.method = method;
            this.body = body;
            return this;
        }

        public a o(AbstractC5529B body) {
            kotlin.jvm.internal.p.i(body, "body");
            return n("POST", body);
        }

        public a p(AbstractC5529B body) {
            kotlin.jvm.internal.p.i(body, "body");
            return n("PUT", body);
        }

        public a q(String name) {
            kotlin.jvm.internal.p.i(name, "name");
            this.headers.h(name);
            return this;
        }

        public <T> a r(Class<? super T> type, T tag) {
            kotlin.jvm.internal.p.i(type, "type");
            return s(C5013a.e(type), tag);
        }

        public final <T> a s(InterfaceC5745d<T> type, T tag) {
            kotlin.jvm.internal.p.i(type, "type");
            this.tags = this.tags.b(type, tag);
            return this;
        }

        public a t(String url) {
            kotlin.jvm.internal.p.i(url, "url");
            return u(v.INSTANCE.c(d(url)));
        }

        public a u(v url) {
            kotlin.jvm.internal.p.i(url, "url");
            this.url = url;
            return this;
        }

        public a(C5528A request) {
            kotlin.jvm.internal.p.i(request, "request");
            this.tags = C5641a.f42661a;
            this.url = request.getUrl();
            this.method = request.getMethod();
            this.body = request.getBody();
            this.tags = request.getTags();
            this.headers = request.getHeaders().i();
            this.cacheUrlOverride = request.getCacheUrlOverride();
        }
    }
}
