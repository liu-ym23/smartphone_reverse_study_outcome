package kotlinx.coroutines.b.a;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.b.ae;
import kotlinx.coroutines.internal.ap;

/* JADX INFO: compiled from: ChannelFlow.kt */
/* JADX INFO: loaded from: classes4.dex */
public final class f {
    public static final /* synthetic */ kotlinx.coroutines.b.i a(kotlinx.coroutines.b.i r2, d.c.g r3) {
        return b((kotlinx.coroutines.b.i) ZeusTransformUtils.wrapperContextForParams(r2, kotlinx.coroutines.b.i.class, "com.obric.aiagent.plugin"), (d.c.g) ZeusTransformUtils.wrapperContextForParams(r3, d.c.g.class, "com.obric.aiagent.plugin"));
    }

    private static final <T> kotlinx.coroutines.b.i<T> b(kotlinx.coroutines.b.i<? super T> r2, d.c.g r3) {
        kotlinx.coroutines.b.i<T> r4 = (kotlinx.coroutines.b.i) ZeusTransformUtils.wrapperContextForParams(r2, kotlinx.coroutines.b.i.class, "com.obric.aiagent.plugin");
        d.c.g r5 = (d.c.g) ZeusTransformUtils.wrapperContextForParams(r3, d.c.g.class, "com.obric.aiagent.plugin");
        if (ZeusTransformUtils.instanceOf(r4, x.class) == false) goto L5;
        boolean r0 = true;
    L6:
        if (r0 == false) goto L9;
        return r4;
    L9:
        return (kotlinx.coroutines.b.i) ZeusTransformUtils.preCheckCast(new aa(r4, r5), kotlinx.coroutines.b.i.class, "com.obric.aiagent.plugin");
    L5:
        r0 = ZeusTransformUtils.instanceOf(r4, s.class);
        goto L6
    }

    public static /* synthetic */ Object a(d.c.g r1, Object r2, Object r3, d.h.a.m r4, d.c.d r5, int r6, Object r7) {
        d.c.g r8 = (d.c.g) ZeusTransformUtils.wrapperContextForParams(r1, d.c.g.class, "com.obric.aiagent.plugin");
        d.h.a.m r9 = (d.h.a.m) ZeusTransformUtils.wrapperContextForParams(r4, d.h.a.m.class, "com.obric.aiagent.plugin");
        d.c.d r10 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r5, d.c.d.class, "com.obric.aiagent.plugin");
        if ((r6 & 4) == 0) goto L6;
        r3 = ap.a(r8);
    L6:
        return a(r8, r2, r3, r9, r10);
    }

    public static final <T, V> Object a(d.c.g r3, V r4, Object r5, d.h.a.m<? super V, ? super d.c.d<? super T>, ? extends Object> r6, d.c.d<? super T> r7) {
        d.c.g r8 = (d.c.g) ZeusTransformUtils.wrapperContextForParams(r3, d.c.g.class, "com.obric.aiagent.plugin");
        d.h.a.m r9 = (d.h.a.m) ZeusTransformUtils.wrapperContextForParams(r6, d.h.a.m.class, "com.obric.aiagent.plugin");
        d.c.d r10 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r7, d.c.d.class, "com.obric.aiagent.plugin");
        Object r11 = ap.a(r8, r5);
        d.c.d r0 = (d.c.d) ZeusTransformUtils.preCheckCast(new y(r10, r8), d.c.d.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L11
        if (ZeusTransformUtils.instanceOf(r9, d.c.b.a.a.class) == true) goto L6;
        Object r12 = d.c.a.b.a(r9, r4, r0);     // Catch: Throwable -> L11
    L7:
        ap.b(r8, r11);
        if (r12 != d.c.a.b.a()) goto L10;
        d.c.b.a.h.c(r10);
    L10:
        return r12;
    L6:
        r12 = ((d.h.a.m) ZeusTransformUtils.preCheckCast(ae.b(r9, 2), d.h.a.m.class, "com.obric.aiagent.plugin")).invoke(r4, r0);     // Catch: Throwable -> L11
    L11:
        th = move-exception;
        ap.b(r8, r11);
        throw th;
    }
}
