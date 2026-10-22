package wa;

import com.obric.appstore.util.GlobalUtilsKt;
import kotlin.jvm.internal.q;
import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;

/* JADX INFO: loaded from: classes3.dex */
public final class e implements Interceptor {
    public e() {
    }

    @Override // okhttp3.Interceptor
    public Response intercept(Interceptor.Chain r10) {
        q.g(r10, "chain");
        Request r11 = r10.request();
        String r12 = r11.c("obric_cache_expired");
        Request.a r13 = null;
        int r14 = 0;
        if (r12 == null) goto L5;
        Request.a r15 = r11.h().h("obric_cache_expired");
        r14 = GlobalUtilsKt.c(r12, 0, 1, null);
        r13 = r15;
    L5:
        if (r13 == null) goto L10;
        Request r16 = r13.b();
        if (r16 == null) goto L10;
        r11 = r16;
    L10:
        Response r17 = r10.proceed(r11);
        if (r14 > 0) goto L14;
        Response r18 = r17.n().o("pragma").o("Cache-Control").c();
        q.f(r18, "build(...)");
        return r18;
    L14:
        Response r19 = r17.n().o("pragma").a("Cache-Control", "max-age=" + r14).c();
        q.f(r19, "build(...)");
        return r19;
    }
}
