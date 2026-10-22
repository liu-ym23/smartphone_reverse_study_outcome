package kotlinx.coroutines;

import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: compiled from: JobSupport.kt */
/* JADX INFO: loaded from: classes4.dex */
final class ct extends ch {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final d.c.d<d.x> f39212a;

    public ct(d.c.d<? super d.x> r3) {
        this.f39212a = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r3, d.c.d.class, "com.obric.aiagent.plugin");
    }

    @Override // kotlinx.coroutines.bw
    public void a(Throwable r1) {
        d.c.d<d.x> r0 = this.f39212a;
        d.n.a r2 = d.n.f38560a;
        r0.resumeWith(d.n.f(d.x.f38692a));
    }
}
