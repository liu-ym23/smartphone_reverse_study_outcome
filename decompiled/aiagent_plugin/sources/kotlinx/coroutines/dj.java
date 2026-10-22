package kotlinx.coroutines;

import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: compiled from: CoroutineContext.kt */
/* JADX INFO: loaded from: classes4.dex */
final class dj implements d.c.g.b, d.c.g.c<dj> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final dj f39266a = null;

    static {
        f39266a = new dj();
    }

    private dj() {
    }

    @Override // d.c.g
    public <R> R fold(R r3, d.h.a.m<? super R, ? super d.c.g.b, ? extends R> r4) {
        return (R) d.c.g.b.a.a(this, r3, (d.h.a.m) ZeusTransformUtils.wrapperContextForParams(r4, d.h.a.m.class, "com.obric.aiagent.plugin"));
    }

    @Override // d.c.g.b, d.c.g
    public <E extends d.c.g.b> E get(d.c.g.c<E> r3) {
        return (E) d.c.g.b.a.a(this, (d.c.g.c) ZeusTransformUtils.wrapperContextForParams(r3, d.c.g.c.class, "com.obric.aiagent.plugin"));
    }

    @Override // d.c.g
    public d.c.g minusKey(d.c.g.c<?> r3) {
        return d.c.g.b.a.b(this, (d.c.g.c) ZeusTransformUtils.wrapperContextForParams(r3, d.c.g.c.class, "com.obric.aiagent.plugin"));
    }

    @Override // d.c.g
    public d.c.g plus(d.c.g r3) {
        return d.c.g.b.a.a(this, (d.c.g) ZeusTransformUtils.wrapperContextForParams(r3, d.c.g.class, "com.obric.aiagent.plugin"));
    }

    @Override // d.c.g.b
    public d.c.g.c<?> getKey() {
        return (d.c.g.c) ZeusTransformUtils.preCheckCast(this, d.c.g.c.class, "com.obric.aiagent.plugin");
    }
}
