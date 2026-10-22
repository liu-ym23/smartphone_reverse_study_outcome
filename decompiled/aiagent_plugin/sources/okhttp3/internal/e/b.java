package okhttp3.internal.e;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.b.o;
import java.io.IOException;
import java.net.ProtocolException;
import okhttp3.ab;
import okhttp3.ac;
import okhttp3.ad;
import okhttp3.ae;
import okhttp3.w;

/* JADX INFO: compiled from: CallServerInterceptor.kt */
/* JADX INFO: loaded from: classes4.dex */
public final class b implements w {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final boolean f39915a;

    private final boolean a(int r3) {
        if (r3 != 100) goto L6;
    L13:
        return true;
    L6:
        if (102 <= r3) goto L8;
    L10:
        boolean r4 = false;
    L11:
        if (r4 == true) goto L13;
        return false;
    L8:
        if (r3 >= 200) goto L10;
        r4 = true;
        goto L11
    }

    public b(boolean r1) {
        this.f39915a = r1;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r10v0 */
    /* JADX WARN: Type inference failed for: r10v1 */
    /* JADX WARN: Type inference failed for: r10v14, types: [boolean] */
    /* JADX WARN: Type inference failed for: r10v15 */
    /* JADX WARN: Type inference failed for: r10v16 */
    /* JADX WARN: Type inference failed for: r10v17 */
    /* JADX WARN: Type inference failed for: r10v2 */
    /* JADX WARN: Type inference failed for: r10v20 */
    /* JADX WARN: Type inference failed for: r10v21 */
    /* JADX WARN: Type inference failed for: r10v22, types: [okhttp3.ad$a] */
    /* JADX WARN: Type inference failed for: r10v23 */
    /* JADX WARN: Type inference failed for: r10v24 */
    /* JADX WARN: Type inference failed for: r10v25 */
    /* JADX WARN: Type inference failed for: r10v26 */
    /* JADX WARN: Type inference failed for: r10v27 */
    /* JADX WARN: Type inference failed for: r10v28 */
    /* JADX WARN: Type inference failed for: r10v29 */
    /* JADX WARN: Type inference failed for: r10v3 */
    /* JADX WARN: Type inference failed for: r10v4, types: [java.lang.Object, okhttp3.ad$a] */
    /* JADX WARN: Type inference failed for: r10v5, types: [okhttp3.ad$a] */
    @Override // okhttp3.w
    public ad intercept(w.a r15) {
        w.a r16 = (w.a) ZeusTransformUtils.wrapperContextForParams(r15, w.a.class, "com.obric.aiagent.plugin");
        o.e(r16, "chain");
        g r17 = (g) ZeusTransformUtils.preCheckCast(r16, g.class, "com.obric.aiagent.plugin");
        okhttp3.internal.d.c r2 = r17.d();
        o.a(r2);
        ab r18 = r17.e();
        ac r4 = r18.d();
        long r5 = System.currentTimeMillis();
        Long r8 = null;
        r2.a(r18);     // Catch: IOException -> L32
        ?? r10 = f.c(r18.b());     // Catch: IOException -> L32
        if (r10 == 0) goto L23;
        if (r4 == null) goto L23;
        if (d.o.o.a("100-continue", r18.a("Expect"), true) == false) goto L13;
        r2.h();     // Catch: IOException -> L32
        r10 = r2.a(true);     // Catch: IOException -> L32
        r2.j();     // Catch: IOException -> L11
        boolean r11 = false;
        ?? r12 = r10;
    L14:
        if (r12 == 0) goto L16;
        r2.n();     // Catch: IOException -> L30
        r10 = r12;
        if (r2.f().g() == true) goto L25;
        r2.k();     // Catch: IOException -> L30
        r10 = r12;
    L25:
        if (r4 != null) goto L27;
    L28:
        r2.i();     // Catch: IOException -> L30
    L29:
        e = null;
        ?? r13 = r10;
    L39:
        if (r13 == 0) goto L88;
    L43:
        ad r14 = r13.a(r18).a(r2.f().l()).a(r5).b(System.currentTimeMillis()).b();     // Catch: IOException -> L76
        int r19 = r14.d();     // Catch: IOException -> L76
        if (a(r19) == false) goto L49;
        ad.a r7 = r2.a(false);     // Catch: IOException -> L76
        o.a(r7);     // Catch: IOException -> L76
        if (r11 == false) goto L48;
        r2.j();     // Catch: IOException -> L76
    L48:
        r14 = r7.a(r18).a(r2.f().l()).a(r5).b(System.currentTimeMillis()).b();     // Catch: IOException -> L76
        r19 = r14.d();     // Catch: IOException -> L76
    L49:
        r2.a(r14);     // Catch: IOException -> L76
        if (this.f39915a == true) goto L52;
    L54:
        ad r110 = r14.o().a(r2.b(r14)).b();     // Catch: IOException -> L76
    L56:
        if (d.o.o.a("close", r110.a().a("Connection"), true) == false) goto L58;
    L59:
        r2.k();     // Catch: IOException -> L76
    L61:
        if (r19 != 204) goto L63;
    L64:
        ae r111 = r110.g();     // Catch: IOException -> L76
        if (r111 == null) goto L67;
        long r0 = r111.c();     // Catch: IOException -> L76
    L69:
        if (r0 <= 0) goto L75;
        StringBuilder r1 = new StringBuilder().append("HTTP ").append(r19).append(" had non-zero Content-Length: ");     // Catch: IOException -> L76
        ae r112 = r110.g();     // Catch: IOException -> L76
        if (r112 == null) goto L74;
        r8 = Long.valueOf(r112.c());     // Catch: IOException -> L76
    L74:
        throw new ProtocolException(r1.append(r8).toString());     // Catch: IOException -> L76
    L76:
        e = move-exception;
        if (e == null) goto L80;
        d.a.a((Throwable) ZeusTransformUtils.preCheckCast(e, Throwable.class, "com.obric.aiagent.plugin"), (Throwable) ZeusTransformUtils.preCheckCast(e, Throwable.class, "com.obric.aiagent.plugin"));
        throw e;
    L80:
        throw e;
    L75:
        return r110;
    L67:
        r0 = -1;
        goto L69
    L63:
        if (r19 != 205) goto L75;
    L58:
        if (d.o.o.a("close", ad.a(r110, "Connection", null, 2, null), true) == false) goto L61;
    L52:
        if (r19 != 101) goto L54;
        r110 = r14.o().a(okhttp3.internal.c.f39835c).b();     // Catch: IOException -> L76
        goto L56
    L88:
        r13 = r2.a(false);     // Catch: IOException -> L76
        o.a(r13);     // Catch: IOException -> L76
        if (r11 == false) goto L43;
        r2.j();     // Catch: IOException -> L76
        r11 = false;
        goto L43
    L27:
        if (r4.d() == true) goto L29;
    L16:
        if (r4.d() == false) goto L18;
        r2.h();     // Catch: IOException -> L30
        r4.a(e.o.a(r2.a(r18, true)));     // Catch: IOException -> L30
        r10 = r12;
        goto L25
    L18:
        e.f r113 = e.o.a(r2.a(r18, false));     // Catch: IOException -> L30
        r4.a(r113);     // Catch: IOException -> L30
        r113.close();     // Catch: IOException -> L30
        r10 = r12;
    L11:
        e = e;
    L34:
        r11 = true;
    L36:
        if (ZeusTransformUtils.instanceOf(e, okhttp3.internal.g.a.class) == true) goto L82;
        r13 = r10;
        if (r2.e() == true) goto L39;
        throw e;
    L82:
        throw e;
    L13:
        r12 = 0;
        r11 = true;
    L23:
        r2.n();     // Catch: IOException -> L32
        r10 = 0;
        r11 = true;
    L30:
        e = e;
    L32:
        e = e;
        r10 = 0;
        goto L34
    }
}
