package kotlinx.coroutines.internal;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.concurrent.CancellationException;
import kotlinx.coroutines.ba;
import kotlinx.coroutines.bj;
import kotlinx.coroutines.ca;
import kotlinx.coroutines.cz;
import kotlinx.coroutines.di;

/* JADX INFO: compiled from: DispatchedContinuation.kt */
/* JADX INFO: loaded from: classes4.dex */
public final class n {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final al f39401a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final al f39402b = null;

    public static final /* synthetic */ al a() {
        return f39402b;
    }

    static {
        f39402b = new al("UNDEFINED");
        f39401a = new al("REUSABLE_CLAIMED");
    }

    public static /* synthetic */ void a(d.c.d r1, Object r2, d.h.a.b r3, int r4, Object r5) {
        d.c.d r6 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r1, d.c.d.class, "com.obric.aiagent.plugin");
        d.h.a.b r7 = (d.h.a.b) ZeusTransformUtils.wrapperContextForParams(r3, d.h.a.b.class, "com.obric.aiagent.plugin");
        if ((r4 & 2) == 0) goto L5;
        r7 = null;
    L5:
        a(r6, r2, r7);
    }

    public static final <T> void a(d.c.d<? super T> r8, Object r9, d.h.a.b<? super Throwable, d.x> r10) {
        d.c.d r11 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r8, d.c.d.class, "com.obric.aiagent.plugin");
        d.h.a.b r12 = (d.h.a.b) ZeusTransformUtils.wrapperContextForParams(r10, d.h.a.b.class, "com.obric.aiagent.plugin");
        if (ZeusTransformUtils.instanceOf(r11, m.class) == false) goto L43;
        m r13 = (m) ZeusTransformUtils.preCheckCast(r11, m.class, "com.obric.aiagent.plugin");
        Object r14 = kotlinx.coroutines.ae.a(r9, r12);
        if (r13.f39397b.a(r13.getContext()) == false) goto L7;
        r13.f39399d = r14;
        r13.f39142a = 1;
        r13.f39397b.a(r13.getContext(), (Runnable) ZeusTransformUtils.preCheckCast(r13, Runnable.class, "com.obric.aiagent.plugin"));
        return;
    L7:
        kotlinx.coroutines.aq.a();
        bj r0 = cz.f39215a.a();
        if (r0.h() == false) goto L10;
        r13.f39399d = r14;
        r13.f39142a = 1;
        r0.a((ba) ZeusTransformUtils.preCheckCast(r13, ba.class, "com.obric.aiagent.plugin"));
        return;
    L10:
        ba r3 = (ba) ZeusTransformUtils.preCheckCast(r13, ba.class, "com.obric.aiagent.plugin");
        r0.a(true);
        ca r5 = (ca) ZeusTransformUtils.preCheckCast(r13.getContext().get((d.c.g.c) ZeusTransformUtils.preCheckCast(ca.f39180a, d.c.g.c.class, "com.obric.aiagent.plugin")), ca.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L37
        if (r5 != null) goto L14;
    L16:
        boolean r15 = false;
    L17:
        if (r15 == true) goto L35;
        d.c.d<T> r16 = r13.f39398c;     // Catch: Throwable -> L37
        Object r1 = r13.f39400e;     // Catch: Throwable -> L37
        d.c.g r6 = r16.getContext();     // Catch: Throwable -> L37
        Object r2 = ap.a(r6, r1);     // Catch: Throwable -> L37
        if (r2 == ap.f39371a) goto L22;
        di<?> r17 = kotlinx.coroutines.ah.a(r16, r6, r2);     // Catch: Throwable -> L37
    L45:
        r13.f39398c.resumeWith(r9);     // Catch: Throwable -> L28
        d.x r18 = d.x.f38692a;     // Catch: Throwable -> L28
        if (r17 != null) goto L26;
    L27:
        ap.b(r6, r2);     // Catch: Throwable -> L37
        goto L35
    L26:
        if (r17.g() == false) goto L35;
    L28:
        th = move-exception;
        if (r17 != null) goto L31;
    L32:
        ap.b(r6, r2);     // Catch: Throwable -> L37
    L33:
        throw th;     // Catch: Throwable -> L37
    L31:
        if (r17.g() == false) goto L33;
    L22:
        r17 = null;
    L35:
        if (r0.f() == true) goto L35;
    L39:
        r0.b(true);
        return;
    L14:
        if (r5.b() == true) goto L16;
        CancellationException r7 = r5.k();     // Catch: Throwable -> L37
        r13.a(r14, (Throwable) ZeusTransformUtils.preCheckCast(r7, Throwable.class, "com.obric.aiagent.plugin"));     // Catch: Throwable -> L37
        d.c.d r19 = (d.c.d) ZeusTransformUtils.preCheckCast(r13, d.c.d.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L37
        d.n.a r20 = d.n.f38560a;     // Catch: Throwable -> L37
        r19.resumeWith(d.n.f(d.o.a((Throwable) ZeusTransformUtils.preCheckCast(r7, Throwable.class, "com.obric.aiagent.plugin"))));     // Catch: Throwable -> L37
        r15 = true;
    L37:
        th = move-exception;
        r3.a(th, null);     // Catch: Throwable -> L40
    L40:
        th = move-exception;
        r0.b(true);
        throw th;
    L43:
        r11.resumeWith(r9);
    }

    public static final boolean a(m<? super d.x> r6) {
        d.x r0 = d.x.f38692a;
        kotlinx.coroutines.aq.a();
        bj r1 = cz.f39215a.a();
        if (r1.i() == false) goto L6;
        return false;
    L6:
        if (r1.h() == false) goto L8;
        r6.f39399d = r0;
        r6.f39142a = 1;
        r1.a((ba) ZeusTransformUtils.preCheckCast(r6, ba.class, "com.obric.aiagent.plugin"));
        return true;
    L8:
        ba r2 = (ba) ZeusTransformUtils.preCheckCast(r6, ba.class, "com.obric.aiagent.plugin");
        r1.a(true);
        r6.run();     // Catch: Throwable -> L13
    L10:
        if (r1.f() == true) goto L10;
    L16:
        r1.b(true);
        return false;
    L13:
        th = move-exception;
        r2.a(th, null);     // Catch: Throwable -> L18
    L18:
        th = move-exception;
        r1.b(true);
        throw th;
    }
}
