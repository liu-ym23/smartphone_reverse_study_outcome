package kotlinx.coroutines.b.a;

import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: compiled from: SafeCollector.kt */
/* JADX INFO: loaded from: classes4.dex */
public final class m implements d.c.g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Throwable f38933a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final /* synthetic */ d.c.g f38934b;

    @Override // d.c.g
    public <R> R fold(R r3, d.h.a.m<? super R, ? super d.c.g.b, ? extends R> r4) {
        d.h.a.m<? super R, ? super d.c.g.b, ? extends R> r5 = (d.h.a.m) ZeusTransformUtils.wrapperContextForParams(r4, d.h.a.m.class, "com.obric.aiagent.plugin");
        return (R) this.f38934b.fold(r3, r5);
    }

    @Override // d.c.g
    public <E extends d.c.g.b> E get(d.c.g.c<E> r3) {
        d.c.g.c<E> r4 = (d.c.g.c) ZeusTransformUtils.wrapperContextForParams(r3, d.c.g.c.class, "com.obric.aiagent.plugin");
        return (E) this.f38934b.get(r4);
    }

    @Override // d.c.g
    public d.c.g minusKey(d.c.g.c<?> r3) {
        d.c.g.c<?> r4 = (d.c.g.c) ZeusTransformUtils.wrapperContextForParams(r3, d.c.g.c.class, "com.obric.aiagent.plugin");
        return this.f38934b.minusKey(r4);
    }

    @Override // d.c.g
    public d.c.g plus(d.c.g r3) {
        d.c.g r4 = (d.c.g) ZeusTransformUtils.wrapperContextForParams(r3, d.c.g.class, "com.obric.aiagent.plugin");
        return this.f38934b.plus(r4);
    }

    public m(Throwable r3, d.c.g r4) {
        d.c.g r5 = (d.c.g) ZeusTransformUtils.wrapperContextForParams(r4, d.c.g.class, "com.obric.aiagent.plugin");
        this.f38933a = r3;
        this.f38934b = r5;
    }
}
