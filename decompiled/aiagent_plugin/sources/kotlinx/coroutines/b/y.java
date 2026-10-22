package kotlinx.coroutines.b;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlinx.coroutines.ca;

/* JADX INFO: compiled from: Share.kt */
/* JADX INFO: loaded from: classes4.dex */
final class y<T> implements kotlinx.coroutines.b.a.q<T>, ab<T>, c<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final ca f39138a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final /* synthetic */ ab<T> f39139b;

    @Override // kotlinx.coroutines.b.h
    public Object collect(i<? super T> r3, d.c.d<?> r4) {
        i<? super T> r5 = (i) ZeusTransformUtils.wrapperContextForParams(r3, i.class, "com.obric.aiagent.plugin");
        d.c.d<?> r6 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
        return this.f39139b.collect(r5, r6);
    }

    public y(ab<? extends T> r3, ca r4) {
        ab<T> r5 = (ab) ZeusTransformUtils.wrapperContextForParams(r3, ab.class, "com.obric.aiagent.plugin");
        this.f39138a = (ca) ZeusTransformUtils.wrapperContextForParams(r4, ca.class, "com.obric.aiagent.plugin");
        this.f39139b = r5;
    }

    @Override // kotlinx.coroutines.b.a.q
    public h<T> a_(d.c.g r3, int r4, kotlinx.coroutines.a.a r5) {
        d.c.g r6 = (d.c.g) ZeusTransformUtils.wrapperContextForParams(r3, d.c.g.class, "com.obric.aiagent.plugin");
        return ad.a((ab) ZeusTransformUtils.preCheckCast(this, ab.class, "com.obric.aiagent.plugin"), r6, r4, r5);
    }
}
