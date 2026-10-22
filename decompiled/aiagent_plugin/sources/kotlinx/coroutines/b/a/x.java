package kotlinx.coroutines.b.a;

import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: compiled from: SendingCollector.kt */
/* JADX INFO: loaded from: classes4.dex */
public final class x<T> implements kotlinx.coroutines.b.i<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final kotlinx.coroutines.a.t<T> f38950a;

    public x(kotlinx.coroutines.a.t<? super T> r3) {
        this.f38950a = (kotlinx.coroutines.a.t) ZeusTransformUtils.wrapperContextForParams(r3, kotlinx.coroutines.a.t.class, "com.obric.aiagent.plugin");
    }

    @Override // kotlinx.coroutines.b.i
    public Object emit(T r3, d.c.d<? super d.x> r4) {
        d.c.d<? super d.x> r5 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
        Object r2 = this.f38950a.a(r3, r5);
        if (r2 != d.c.a.b.a()) goto L6;
        return r2;
    L6:
        return d.x.f38692a;
    }
}
