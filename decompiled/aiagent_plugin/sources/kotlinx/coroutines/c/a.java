package kotlinx.coroutines.c;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.c.d;
import d.h.a.m;
import d.n;
import d.o;
import d.x;

/* JADX INFO: compiled from: Cancellable.kt */
/* JADX INFO: loaded from: classes4.dex */
public final class a {
    public static /* synthetic */ void a(m r1, Object r2, d r3, d.h.a.b r4, int r5, Object r6) {
        m r7 = (m) ZeusTransformUtils.wrapperContextForParams(r1, m.class, "com.obric.aiagent.plugin");
        d r8 = (d) ZeusTransformUtils.wrapperContextForParams(r3, d.class, "com.obric.aiagent.plugin");
        d.h.a.b r9 = (d.h.a.b) ZeusTransformUtils.wrapperContextForParams(r4, d.h.a.b.class, "com.obric.aiagent.plugin");
        if ((r5 & 4) == 0) goto L5;
        r9 = null;
    L5:
        a(r7, r2, r8, r9);
    }

    public static final <R, T> void a(m<? super R, ? super d<? super T>, ? extends Object> r2, R r3, d<? super T> r4, d.h.a.b<? super Throwable, x> r5) {
        m r6 = (m) ZeusTransformUtils.wrapperContextForParams(r2, m.class, "com.obric.aiagent.plugin");
        d r7 = (d) ZeusTransformUtils.wrapperContextForParams(r4, d.class, "com.obric.aiagent.plugin");
        d.h.a.b r8 = (d.h.a.b) ZeusTransformUtils.wrapperContextForParams(r5, d.h.a.b.class, "com.obric.aiagent.plugin");
        d r9 = d.c.a.b.a(d.c.a.b.b(r6, r3, r7));     // Catch: Throwable -> L5
        n.a r10 = n.f38560a;     // Catch: Throwable -> L5
        kotlinx.coroutines.internal.n.a(r9, n.f(x.f38692a), r8);     // Catch: Throwable -> L5
        return;
    L5:
        th = move-exception;
        a(r7, th);
    }

    public static final void a(d<? super x> r3, d<?> r4) {
        d r5 = (d) ZeusTransformUtils.wrapperContextForParams(r3, d.class, "com.obric.aiagent.plugin");
        d r6 = (d) ZeusTransformUtils.wrapperContextForParams(r4, d.class, "com.obric.aiagent.plugin");
        d r7 = d.c.a.b.a(r5);     // Catch: Throwable -> L5
        n.a r0 = n.f38560a;     // Catch: Throwable -> L5
        kotlinx.coroutines.internal.n.a(r7, n.f(x.f38692a), null, 2, null);     // Catch: Throwable -> L5
        return;
    L5:
        th = move-exception;
        a(r6, th);
    }

    private static final void a(d<?> r2, Throwable r3) {
        d r4 = (d) ZeusTransformUtils.wrapperContextForParams(r2, d.class, "com.obric.aiagent.plugin");
        n.a r0 = n.f38560a;
        r4.resumeWith(n.f(o.a(r3)));
        throw r3;
    }
}
