package kotlinx.coroutines.c;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.c.b.a.e;
import d.c.b.a.h;
import d.c.d;
import d.c.g;
import d.h.a.m;
import d.h.b.ae;
import d.n;
import d.o;
import kotlinx.coroutines.ab;
import kotlinx.coroutines.aq;
import kotlinx.coroutines.cj;
import kotlinx.coroutines.de;
import kotlinx.coroutines.internal.ah;
import kotlinx.coroutines.internal.ak;
import kotlinx.coroutines.internal.ap;

/* JADX INFO: compiled from: Undispatched.kt */
/* JADX INFO: loaded from: classes4.dex */
public final class b {
    public static final <T, R> Object a(ah<? super T> r4, R r5, m<? super R, ? super d<? super T>, ? extends Object> r6) {
        m r7 = (m) ZeusTransformUtils.wrapperContextForParams(r6, m.class, "com.obric.aiagent.plugin");
    L8:
        th = move-exception;
        Object r8 = new ab(th, false, 2, null);
    L11:
        if (r8 == d.c.a.b.a()) goto L32;
        Object r9 = r4.g(r8);
        if (r9 != cj.f39202a) goto L17;
        return d.c.a.b.a();
    L17:
        if (ZeusTransformUtils.instanceOf(r9, ab.class) == false) goto L26;
        Throwable r10 = ((ab) ZeusTransformUtils.preCheckCast(r9, ab.class, "com.obric.aiagent.plugin")).f38830a;
        Throwable r11 = ((ab) ZeusTransformUtils.preCheckCast(r9, ab.class, "com.obric.aiagent.plugin")).f38830a;
        d<? super T> r12 = r4.f39362c;
        if (aq.c() == true) goto L21;
        throw r11;
    L21:
        if (ZeusTransformUtils.instanceOf(r12, e.class) == true) goto L24;
        throw r11;
    L24:
        throw ak.a(r11, (e) ZeusTransformUtils.preCheckCast(r12, e.class, "com.obric.aiagent.plugin"));
    L26:
        return cj.b(r9);
    L32:
        return d.c.a.b.a();
    L4:
        if (ZeusTransformUtils.instanceOf(r7, d.c.b.a.a.class) == true) goto L6;
        r8 = d.c.a.b.a(r7, r5, (d) ZeusTransformUtils.preCheckCast(r4, d.class, "com.obric.aiagent.plugin"));     // Catch: Throwable -> L8
    L27:
        goto L11
    L6:
        r8 = ((m) ZeusTransformUtils.preCheckCast(ae.b(r7, 2), m.class, "com.obric.aiagent.plugin")).invoke(r5, (d) ZeusTransformUtils.preCheckCast(r4, d.class, "com.obric.aiagent.plugin"));     // Catch: Throwable -> L8
        goto L27
    }

    public static final <T, R> Object b(ah<? super T> r4, R r5, m<? super R, ? super d<? super T>, ? extends Object> r6) {
        m r7 = (m) ZeusTransformUtils.wrapperContextForParams(r6, m.class, "com.obric.aiagent.plugin");
        boolean r2 = false;
    L8:
        th = move-exception;
        Object r8 = new ab(th, false, 2, null);
    L11:
        if (r8 == d.c.a.b.a()) goto L50;
        Object r9 = r4.g(r8);
        if (r9 != cj.f39202a) goto L17;
        return d.c.a.b.a();
    L17:
        if (ZeusTransformUtils.instanceOf(r9, ab.class) == false) goto L40;
        Throwable r0 = ((ab) ZeusTransformUtils.preCheckCast(r9, ab.class, "com.obric.aiagent.plugin")).f38830a;
        if (ZeusTransformUtils.instanceOf(r0, de.class) == true) goto L21;
    L22:
        r2 = true;
    L23:
        if (r2 == false) goto L32;
        Throwable r10 = ((ab) ZeusTransformUtils.preCheckCast(r9, ab.class, "com.obric.aiagent.plugin")).f38830a;
        d<? super T> r11 = r4.f39362c;
        if (aq.c() == true) goto L27;
        throw r10;
    L27:
        if (ZeusTransformUtils.instanceOf(r11, e.class) == true) goto L30;
        throw r10;
    L30:
        throw ak.a(r10, (e) ZeusTransformUtils.preCheckCast(r11, e.class, "com.obric.aiagent.plugin"));
    L32:
        if (ZeusTransformUtils.instanceOf(r8, ab.class) == false) goto L42;
        Throwable r12 = ((ab) ZeusTransformUtils.preCheckCast(r8, ab.class, "com.obric.aiagent.plugin")).f38830a;
        d<? super T> r13 = r4.f39362c;
        if (aq.c() == true) goto L36;
        throw r12;
    L36:
        if (ZeusTransformUtils.instanceOf(r13, e.class) == true) goto L39;
        throw r12;
    L39:
        throw ak.a(r12, (e) ZeusTransformUtils.preCheckCast(r13, e.class, "com.obric.aiagent.plugin"));
    L42:
        return r8;
    L21:
        if (((de) ZeusTransformUtils.preCheckCast(r0, de.class, "com.obric.aiagent.plugin")).f39257a == r4) goto L23;
    L40:
        r8 = cj.b(r9);
        goto L42
    L50:
        return d.c.a.b.a();
    L4:
        if (ZeusTransformUtils.instanceOf(r7, d.c.b.a.a.class) == true) goto L6;
        r8 = d.c.a.b.a(r7, r5, (d) ZeusTransformUtils.preCheckCast(r4, d.class, "com.obric.aiagent.plugin"));     // Catch: Throwable -> L8
    L43:
        goto L11
    L6:
        r8 = ((m) ZeusTransformUtils.preCheckCast(ae.b(r7, 2), m.class, "com.obric.aiagent.plugin")).invoke(r5, (d) ZeusTransformUtils.preCheckCast(r4, d.class, "com.obric.aiagent.plugin"));     // Catch: Throwable -> L8
        goto L43
    }

    public static final <R, T> void a(m<? super R, ? super d<? super T>, ? extends Object> r4, R r5, d<? super T> r6) {
        m r7 = (m) ZeusTransformUtils.wrapperContextForParams(r4, m.class, "com.obric.aiagent.plugin");
        d r8 = (d) ZeusTransformUtils.wrapperContextForParams(r6, d.class, "com.obric.aiagent.plugin");
        d r0 = h.a(r8);
        g r9 = r8.getContext();     // Catch: Throwable -> L15
        Object r2 = ap.a(r9, null);     // Catch: Throwable -> L15
    L12:
        th = move-exception;
        ap.b(r9, r2);     // Catch: Throwable -> L15
        throw th;     // Catch: Throwable -> L15
    L5:
        if (ZeusTransformUtils.instanceOf(r7, d.c.b.a.a.class) == true) goto L7;
        Object r10 = d.c.a.b.a(r7, r5, r0);     // Catch: Throwable -> L12
    L8:
        ap.b(r9, r2);     // Catch: Throwable -> L15
        if (r10 == d.c.a.b.a()) goto L20;
        n.a r11 = n.f38560a;
        r0.resumeWith(n.f(r10));
        return;
    L20:
        return;
    L7:
        r10 = ((m) ZeusTransformUtils.preCheckCast(ae.b(r7, 2), m.class, "com.obric.aiagent.plugin")).invoke(r5, r0);     // Catch: Throwable -> L12
    L15:
        th = move-exception;
        n.a r12 = n.f38560a;
        r0.resumeWith(n.f(o.a(th)));
    }
}
