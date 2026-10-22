package q7;

import com.bytedanceos.common.networkv2.params.NetKey;
import java.net.URLEncoder;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.Iterator;
import java.util.Locale;
import java.util.Set;
import java.util.TreeSet;
import kotlin.collections.b0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.q;
import kotlin.text.o;
import okhttp3.HttpUrl;
import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

/* JADX INFO: loaded from: classes2.dex */
public final class f implements Interceptor {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f23561a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static String f23562b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final String f23563c = null;

    public static final class a {
        public /* synthetic */ a(DefaultConstructorMarker r10) {
            this();
        }

        public a() {
        }
    }

    static {
        f23561a = new a(null);
        f23562b = "29fc518df8c2d86e564a8f7c1f9afd01";
        f23563c = "e405aaa6f97bad8752a4e2251d1e8c49";
    }

    public f() {
    }

    @Override // okhttp3.Interceptor
    public Response intercept(Interceptor.Chain r14) {
        q.g(r14, "chain");
        Request r13 = r14.request();
        Request.a r10 = r13.h();
        RequestBody r11 = r13.a();
        String r12 = r13.g();
        HttpUrl.Builder r15 = r13.k().p().s(NetKey.OSVER).s(NetKey.MODEL);
        r7.a r16 = r7.a.f23768a;
        HttpUrl.Builder r17 = r15.b(NetKey.MODEL, o.x(r16.g(), " ", "", false, 4, null));
        Locale r18 = Locale.getDefault();
        q.f(r18, "getDefault(...)");
        String r19 = NetKey.OSVER.toLowerCase(r18);
        q.f(r19, "toLowerCase(...)");
        HttpUrl r20 = r17.b(r19, r16.i()).b("app_id", "ocean_store").b("udid", r16.m()).b("app_version", "100003070").b("_nonce", r16.h()).b("timestamp", r16.l()).c();
        TreeSet r21 = new TreeSet();
        Set r22 = r20.C();
        q.f(r22, "queryParameterNames(...)");
        Iterator r23 = r22.iterator();
    L4:
        if (r23.hasNext() == false) goto L6;
        String r24 = (String) r23.next();
        r21.add(r24 + '=' + URLEncoder.encode(r20.B(r24), StandardCharsets.UTF_8.name()));
        goto L4
    L6:
        String r25 = b0.h0(r21, "&", null, null, 0, null, null, 62, null);
        if (q.b(r12, "POST") == false) goto L17;
        if (r11 == null) goto L10;
        String r26 = g.a(r11);
    L11:
        if (r26 != null) goto L13;
    L16:
        String r27 = r12 + '\n' + r25 + '\n';
    L18:
        Charset r28 = kotlin.text.c.f21252b;
        byte[] r29 = r27.getBytes(r28);
        q.f(r29, "getBytes(...)");
        byte[] r30 = f23562b.getBytes(r28);
        q.f(r30, "getBytes(...)");
        String r31 = g.b(g.c(r29, r30));
        Response r110 = r14.proceed(r10.k(r20).e(r13.e().f().a("X-Signature", f23563c + ':' + r31).d()).b());
        q.f(r110, "proceed(...)");
        return r110;
    L13:
        if (o.r(r26) == true) goto L16;
        r27 = r12 + '\n' + r25 + '\n' + r26 + '\n';
        goto L18
    L10:
        r26 = null;
        goto L11
    L17:
        r27 = r12 + '\n' + r25 + '\n';
        goto L18
    }
}
