package q7;

import com.bytedanceos.common.toolbox.k;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.Iterator;
import java.util.Set;
import java.util.TreeSet;
import kotlin.collections.b0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.q;
import kotlin.text.o;
import okhttp3.HttpUrl;
import okhttp3.Interceptor;
import okhttp3.MediaType;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import okio.Buffer;

/* JADX INFO: loaded from: classes2.dex */
public final class d implements Interceptor {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f23558a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final String f23559b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final String f23560c = null;

    public static final class a {
        public /* synthetic */ a(DefaultConstructorMarker r10) {
            this();
        }

        public final String a() {
            return d.a();
        }

        public a() {
        }
    }

    static {
        f23558a = new a(null);
        f23559b = "F82F3C3E65D83E231C7EE84747F55123";
        f23560c = "lkp_appstore";
    }

    public d() {
    }

    public static final /* synthetic */ String a() {
        return f23560c;
    }

    public final String b(RequestBody r10) {
        Buffer r11 = new Buffer();
        r10.g(r11);
        MediaType r12 = r10.b();
        if (r12 == null) goto L5;
        Charset r13 = r12.b(StandardCharsets.UTF_8);
    L6:
        if (r13 != null) goto L9;
        r13 = StandardCharsets.UTF_8;
        q.f(r13, "UTF_8");
    L9:
        if (e.a(r11) == false) goto L14;
        String r14 = r11.readString(r13);
        if (o.r(r14) == false) goto L13;
        return null;
    L13:
        return k.f(r14);
    L14:
        return null;
    L5:
        r13 = null;
        goto L6
    }

    @Override // okhttp3.Interceptor
    public Response intercept(Interceptor.Chain r14) {
        q.g(r14, "chain");
        Request r10 = r14.request();
        Request.a r11 = r10.h();
        RequestBody r12 = r10.a();
        String r13 = r10.g();
        HttpUrl r15 = r10.k();
        TreeSet r16 = new TreeSet();
        Set r17 = r15.C();
        q.f(r17, "queryParameterNames(...)");
        Iterator r18 = r17.iterator();
    L4:
        if (r18.hasNext() == false) goto L6;
        String r19 = (String) r18.next();
        r16.add(r19 + '=' + r15.B(r19));
        goto L4
    L6:
        String r20 = b0.h0(r16, "&", null, null, 0, null, null, 62, null);
        if (q.b(r13, "POST") == false) goto L17;
        if (r12 == null) goto L10;
        String r110 = b(r12);
    L11:
        if (r110 != null) goto L13;
    L16:
        String r111 = r13 + '\n' + r20 + '\n';
    L18:
        Charset r21 = kotlin.text.c.f21252b;
        byte[] r112 = r111.getBytes(r21);
        q.f(r112, "getBytes(...)");
        byte[] r22 = f23559b.getBytes(r21);
        q.f(r22, "getBytes(...)");
        Response r113 = r14.proceed(r11.a("X-Signature", com.blankj.utilcode.util.b.a(com.blankj.utilcode.util.c.a(r112, r22))).b());
        q.f(r113, "proceed(...)");
        return r113;
    L13:
        if (o.r(r110) == true) goto L16;
        r111 = r13 + '\n' + r20 + '\n' + r110 + '\n';
        goto L18
    L10:
        r110 = null;
        goto L11
    L17:
        r111 = r13 + '\n' + r20 + '\n';
        goto L18
    }
}
