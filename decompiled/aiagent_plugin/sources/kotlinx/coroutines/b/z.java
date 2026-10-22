package kotlinx.coroutines.b;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlinx.coroutines.ca;

/* JADX INFO: compiled from: Share.kt */
/* JADX INFO: loaded from: classes4.dex */
final class z<T> implements kotlinx.coroutines.b.a.q<T>, ak<T>, c<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final ca f39140a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final /* synthetic */ ak<T> f39141b;

    @Override // kotlinx.coroutines.b.ak
    public T c() {
        return this.f39141b.c();
    }

    @Override // kotlinx.coroutines.b.h
    public Object collect(i<? super T> r3, d.c.d<?> r4) {
        i<? super T> r5 = (i) ZeusTransformUtils.wrapperContextForParams(r3, i.class, "com.obric.aiagent.plugin");
        d.c.d<?> r6 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
        return this.f39141b.collect(r5, r6);
    }

    public z(ak<? extends T> r3, ca r4) {
        ak<T> r5 = (ak) ZeusTransformUtils.wrapperContextForParams(r3, ak.class, "com.obric.aiagent.plugin");
        this.f39140a = (ca) ZeusTransformUtils.wrapperContextForParams(r4, ca.class, "com.obric.aiagent.plugin");
        this.f39141b = r5;
    }

    @Override // kotlinx.coroutines.b.a.q
    public h<T> a_(d.c.g r3, int r4, kotlinx.coroutines.a.a r5) {
        d.c.g r6 = (d.c.g) ZeusTransformUtils.wrapperContextForParams(r3, d.c.g.class, "com.obric.aiagent.plugin");
        return am.a((ak) ZeusTransformUtils.preCheckCast(this, ak.class, "com.obric.aiagent.plugin"), r6, r4, r5);
    }
}
