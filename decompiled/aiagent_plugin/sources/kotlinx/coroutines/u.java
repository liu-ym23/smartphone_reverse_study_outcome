package kotlinx.coroutines;

import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: compiled from: JobSupport.kt */
/* JADX INFO: loaded from: classes4.dex */
public final class u extends cc implements t {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final v f39442a;

    public u(v r3) {
        this.f39442a = (v) ZeusTransformUtils.wrapperContextForParams(r3, v.class, "com.obric.aiagent.plugin");
    }

    @Override // kotlinx.coroutines.t
    public ca a() {
        return (ca) ZeusTransformUtils.preCheckCast(c(), ca.class, "com.obric.aiagent.plugin");
    }

    @Override // kotlinx.coroutines.bw
    public void a(Throwable r3) {
        this.f39442a.a((cr) ZeusTransformUtils.preCheckCast(c(), cr.class, "com.obric.aiagent.plugin"));
    }

    @Override // kotlinx.coroutines.t
    public boolean b(Throwable r1) {
        return c().c(r1);
    }
}
