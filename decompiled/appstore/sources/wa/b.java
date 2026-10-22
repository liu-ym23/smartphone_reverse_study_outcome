package wa;

import com.obric.appstore.util.ApiEvn;
import com.obric.appstore.util.GlobalUtilsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.q;
import okhttp3.HttpUrl;
import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import okhttp3.g;
import okhttp3.h;

/* JADX INFO: loaded from: classes3.dex */
public final class b implements Interceptor {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f25395a = null;

    public static final class a {
        public /* synthetic */ a(DefaultConstructorMarker r10) {
            this();
        }

        public a() {
        }
    }

    static {
        f25395a = new a(null);
    }

    public b() {
    }

    public final Request.a a(Request.a r10) {
        r10.a("locale", pa.a.f23414a.a().getResources().getConfiguration().getLocales().get(0).getLanguage());
        return r10;
    }

    public final Request.a b(Request.a r10, HttpUrl r11) {
        String r12 = pa.a.f23414a.a().getResources().getConfiguration().getLocales().get(0).getLanguage();
        if (r11.B("locale") == null) goto L5;
        return r10;
    L5:
        r10.k(r11.p().b("locale", r12).c());
        return r10;
    }

    @Override // okhttp3.Interceptor
    public Response intercept(Interceptor.Chain r10) {
        q.g(r10, "chain");
        Request r11 = r10.request();
        Request.a r12 = r11.h();
        RequestBody r13 = r11.a();
        String r14 = r11.g();
        q.d(r12);
        a(r12);
        HttpUrl r15 = r11.k();
        q.f(r15, "url(...)");
        b(r12, r15);
        String r16 = r11.c("obric_cache_expired");
        if (r16 != null) goto L5;
    L7:
        ApiEvn r17 = ApiEvn.f11052a;
        if (r17.a().length() <= 0) goto L11;
        r12.a("x-use-ppe", "1");
        r12.a("x-tt-env", r17.a());
    L11:
        if (q.b(r14, "POST") == true) goto L13;
    L17:
        Response r18 = r10.proceed(r12.b());
        q.f(r18, "proceed(...)");
        return r18;
    L13:
        if ((r13 instanceof g) == true) goto L17;
        if ((r13 instanceof h) == true) goto L17;
        r12.g(va.a.f25124a.a(r13));
        goto L17
    L5:
        if (GlobalUtilsKt.c(r16, 0, 1, null) != (-1)) goto L7;
        r12.c(okhttp3.a.f22830o);
        goto L7
    }
}
