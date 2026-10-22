package kotlinx.coroutines.a;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.x;
import kotlinx.coroutines.aj;

/* JADX INFO: compiled from: Produce.kt */
/* JADX INFO: loaded from: classes4.dex */
final class p<E> extends e<E> implements q<E> {
    @Override // kotlinx.coroutines.a
    public /* synthetic */ void a(x r3) {
        a2((x) ZeusTransformUtils.preCheckCast(r3, x.class, "com.obric.aiagent.plugin"));
    }

    public p(d.c.g r3, d<E> r4) {
        super((d.c.g) ZeusTransformUtils.wrapperContextForParams(r3, d.c.g.class, "com.obric.aiagent.plugin"), (d) ZeusTransformUtils.wrapperContextForParams(r4, d.class, "com.obric.aiagent.plugin"), true, true);
    }

    @Override // kotlinx.coroutines.a, kotlinx.coroutines.ci, kotlinx.coroutines.ca
    public boolean b() {
        return super.b();
    }

    /* JADX INFO: renamed from: a, reason: avoid collision after fix types in other method */
    public void a2(x r2) {
        t.a.a((t) ZeusTransformUtils.preCheckCast(t(), t.class, "com.obric.aiagent.plugin"), null, 1, null);
    }

    @Override // kotlinx.coroutines.a
    public void a(Throwable r2, boolean r3) {
        if (t().a(r2) == true) goto L7;
        if (r3 == true) goto L8;
        aj.a(getContext(), r2);
        return;
    L8:
        return;
    }
}
