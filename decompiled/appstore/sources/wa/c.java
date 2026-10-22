package wa;

import com.bytedanceos.common.toolbox.j;
import java.nio.charset.Charset;
import java.util.Iterator;
import java.util.Set;
import java.util.TreeSet;
import kotlin.Result;
import kotlin.Unit;
import kotlin.collections.b0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.q;
import kotlin.text.o;
import okhttp3.HttpUrl;
import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

/* JADX INFO: loaded from: classes3.dex */
public final class c implements Interceptor {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f25396a = null;

    public static final class a {
        public /* synthetic */ a(DefaultConstructorMarker r10) {
            this();
        }

        public a() {
        }
    }

    static {
        f25396a = new a(null);
    }

    public c() {
    }

    @Override // okhttp3.Interceptor
    public Response intercept(Interceptor.Chain r14) {
        q.g(r14, "chain");
        Request r13 = r14.request();
        Request.a r10 = r13.h();
        RequestBody r11 = r13.a();
        String r12 = r13.g();
        HttpUrl.Builder r15 = r13.k().p();
        r15.s("obric_cache_key_postfix");
        r15.b("timestamp", String.valueOf(System.currentTimeMillis()));
        HttpUrl r16 = r15.c();
        if (q.b("1", r16.B("nosign")) == false) goto L5;
        String r17 = "NO_AUTHORIZATION_REQUIRED:1";
    L22:
        Response r18 = r14.proceed(r10.k(r16).e(r13.e().f().a("X-Signature", r17).d()).b());
        Result.a r19 = Result.Companion;     // Catch: Throwable -> L25
        j.o("[Retrofit] " + r16 + " logId: " + r18.f("x-tt-logid"));     // Catch: Throwable -> L25
        Result.m35constructorimpl(Unit.f21064a);     // Catch: Throwable -> L25
    L27:
        Response r110 = r18.n().p(r13).c();
        q.f(r110, "build(...)");
        return r110;
    L25:
        th = move-exception;
        Result.a r20 = Result.Companion;
        Result.m35constructorimpl(kotlin.c.a(th));
        goto L27
    L5:
        TreeSet r21 = new TreeSet();
        Set r22 = r16.C();
        q.f(r22, "queryParameterNames(...)");
        Iterator r23 = r22.iterator();
    L7:
        if (r23.hasNext() == false) goto L9;
        String r24 = (String) r23.next();
        r21.add(r24 + '=' + r16.B(r24));
        goto L7
    L9:
        String r25 = b0.h0(r21, "&", null, null, 0, null, null, 62, null);
        if (q.b(r12, "POST") == false) goto L20;
        if (r11 == null) goto L13;
        String r26 = d.a(r11);
    L14:
        if (r26 != null) goto L16;
    L19:
        String r27 = r12 + '\n' + r25 + '\n';
    L21:
        Charset r28 = kotlin.text.c.f21252b;
        byte[] r29 = r27.getBytes(r28);
        q.f(r29, "getBytes(...)");
        com.obric.appstore.util.d r30 = com.obric.appstore.util.d.f11069a;
        byte[] r31 = com.obric.appstore.util.d.d(r30, "com.bytedanceos.appstore.sign_sk", null, 2, null).getBytes(r28);
        q.f(r31, "getBytes(...)");
        r17 = com.obric.appstore.util.d.d(r30, "com.bytedanceos.appstore.sign_ak", null, 2, null) + ':' + d.b(d.c(r29, r31));
        goto L22
    L16:
        if (o.r(r26) == true) goto L19;
        r27 = r12 + '\n' + r25 + '\n' + r26 + '\n';
        goto L21
    L13:
        r26 = null;
        goto L14
    L20:
        r27 = r12 + '\n' + r25 + '\n';
        goto L21
    }
}
