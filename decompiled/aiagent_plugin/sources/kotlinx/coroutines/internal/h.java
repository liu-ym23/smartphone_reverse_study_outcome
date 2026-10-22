package kotlinx.coroutines.internal;

import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: compiled from: Scopes.kt */
/* JADX INFO: loaded from: classes4.dex */
public final class h implements kotlinx.coroutines.am {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final d.c.g f39394a;

    public h(d.c.g r3) {
        this.f39394a = (d.c.g) ZeusTransformUtils.wrapperContextForParams(r3, d.c.g.class, "com.obric.aiagent.plugin");
    }

    @Override // kotlinx.coroutines.am
    public d.c.g a() {
        return this.f39394a;
    }

    public String toString() {
        return "CoroutineScope(coroutineContext=" + a() + ')';
    }
}
