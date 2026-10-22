package d.c;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.a.m;
import d.h.b.o;
import d.n;
import d.x;

/* JADX INFO: compiled from: Continuation.kt */
/* JADX INFO: loaded from: classes4.dex */
public final class f {
    public static final <R, T> void a(m<? super R, ? super d<? super T>, ? extends Object> r2, R r3, d<? super T> r4) {
        m r5 = (m) ZeusTransformUtils.wrapperContextForParams(r2, m.class, "com.obric.aiagent.plugin");
        d r6 = (d) ZeusTransformUtils.wrapperContextForParams(r4, d.class, "com.obric.aiagent.plugin");
        o.e(r5, "<this>");
        o.e(r6, "completion");
        d r7 = d.c.a.b.a(d.c.a.b.b(r5, r3, r6));
        n.a r8 = n.f38560a;
        r7.resumeWith(n.f(x.f38692a));
    }
}
