package kotlinx.coroutines;

import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: compiled from: CompletableDeferred.kt */
/* JADX INFO: loaded from: classes4.dex */
final class x<T> extends ci implements w<T> {
    @Override // kotlinx.coroutines.ci
    public boolean m_() {
        return true;
    }

    public x(ca r3) {
        ca r4 = (ca) ZeusTransformUtils.wrapperContextForParams(r3, ca.class, "com.obric.aiagent.plugin");
        super(true);
        a(r4);
    }

    @Override // kotlinx.coroutines.au
    public T f() {
        return (T) r();
    }

    @Override // kotlinx.coroutines.au
    public Object a(d.c.d<? super T> r3) {
        Object r2 = c((d.c.d) ZeusTransformUtils.wrapperContextForParams(r3, d.c.d.class, "com.obric.aiagent.plugin"));
        d.c.a.b.a();
        return r2;
    }

    @Override // kotlinx.coroutines.au
    public kotlinx.coroutines.e.g<T> g() {
        kotlinx.coroutines.e.g<T> r1 = (kotlinx.coroutines.e.g<T>) s();
        d.h.b.o.a(r1, "null cannot be cast to non-null type kotlinx.coroutines.selects.SelectClause1<T of kotlinx.coroutines.CompletableDeferredImpl>");
        return r1;
    }

    @Override // kotlinx.coroutines.w
    public boolean a(T r1) {
        return f(r1);
    }

    @Override // kotlinx.coroutines.w
    public boolean a(Throwable r5) {
        return f(new ab(r5, false, 2, null));
    }
}
