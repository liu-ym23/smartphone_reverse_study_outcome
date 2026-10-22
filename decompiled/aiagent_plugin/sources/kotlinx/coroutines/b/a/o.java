package kotlinx.coroutines.b.a;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlinx.coroutines.am;
import kotlinx.coroutines.internal.ah;

/* JADX INFO: compiled from: FlowCoroutine.kt */
/* JADX INFO: loaded from: classes4.dex */
public final class o {
    public static final <R> Object a(d.h.a.m<? super am, ? super d.c.d<? super R>, ? extends Object> r3, d.c.d<? super R> r4) {
        d.h.a.m r5 = (d.h.a.m) ZeusTransformUtils.wrapperContextForParams(r3, d.h.a.m.class, "com.obric.aiagent.plugin");
        d.c.d r6 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
        n r0 = new n(r6.getContext(), r6);
        Object r7 = kotlinx.coroutines.c.b.a((ah) ZeusTransformUtils.preCheckCast(r0, ah.class, "com.obric.aiagent.plugin"), r0, r5);
        if (r7 != d.c.a.b.a()) goto L5;
        d.c.b.a.h.c(r6);
    L5:
        return r7;
    }
}
