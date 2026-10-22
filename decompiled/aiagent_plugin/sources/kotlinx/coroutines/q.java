package kotlinx.coroutines;

import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: compiled from: CancellableContinuation.kt */
/* JADX INFO: loaded from: classes4.dex */
public final class q {
    public static final <T> void a(n<? super T> r2, m r3) {
        n r4 = (n) ZeusTransformUtils.wrapperContextForParams(r2, n.class, "com.obric.aiagent.plugin");
        m r5 = (m) ZeusTransformUtils.wrapperContextForParams(r3, m.class, "com.obric.aiagent.plugin");
        if (ZeusTransformUtils.instanceOf(r4, o.class) == false) goto L7;
        ((o) ZeusTransformUtils.preCheckCast(r4, o.class, "com.obric.aiagent.plugin")).a(r5);
        return;
    L7:
        throw new UnsupportedOperationException("third-party implementation of CancellableContinuation is not supported");
    }

    public static final <T> o<T> a(d.c.d<? super T> r2) {
        d.c.d r3 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r2, d.c.d.class, "com.obric.aiagent.plugin");
        if (ZeusTransformUtils.instanceOf(r3, kotlinx.coroutines.internal.m.class) == false) goto L5;
        o<T> r0 = ((kotlinx.coroutines.internal.m) ZeusTransformUtils.preCheckCast(r3, kotlinx.coroutines.internal.m.class, "com.obric.aiagent.plugin")).e();
        if (r0 == null) goto L16;
        if (r0.f() == true) goto L12;
        r0 = null;
    L12:
        if (r0 == null) goto L16;
        return r0;
    L16:
        return new o(r3, 2);
    L5:
        return new o(r3, 1);
    }

    public static final void a(n<?> r2, bf r3) {
        a((n) ZeusTransformUtils.wrapperContextForParams(r2, n.class, "com.obric.aiagent.plugin"), (m) ZeusTransformUtils.preCheckCast(new bg((bf) ZeusTransformUtils.wrapperContextForParams(r3, bf.class, "com.obric.aiagent.plugin")), m.class, "com.obric.aiagent.plugin"));
    }
}
