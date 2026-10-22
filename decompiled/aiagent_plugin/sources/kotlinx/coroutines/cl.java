package kotlinx.coroutines;

import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: compiled from: Builders.common.kt */
/* JADX INFO: loaded from: classes4.dex */
final class cl extends cv {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final d.c.d<d.x> f39208b;

    public cl(d.c.g r3, d.h.a.m<? super am, ? super d.c.d<? super d.x>, ? extends Object> r4) {
        d.c.g r5 = (d.c.g) ZeusTransformUtils.wrapperContextForParams(r3, d.c.g.class, "com.obric.aiagent.plugin");
        d.h.a.m r6 = (d.h.a.m) ZeusTransformUtils.wrapperContextForParams(r4, d.h.a.m.class, "com.obric.aiagent.plugin");
        super(r5, false);
        this.f39208b = d.c.a.b.b(r6, this, (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin"));
    }

    @Override // kotlinx.coroutines.ci
    public void o() {
        kotlinx.coroutines.c.a.a(this.f39208b, (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin"));
    }
}
