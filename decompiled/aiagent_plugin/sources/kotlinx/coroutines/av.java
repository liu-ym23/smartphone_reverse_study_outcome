package kotlinx.coroutines;

import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: compiled from: Builders.common.kt */
/* JADX INFO: loaded from: classes4.dex */
class av<T> extends a<T> implements au<T> {
    @Override // kotlinx.coroutines.au
    public Object a(d.c.d<? super T> r3) {
        return a(this, (d.c.d) ZeusTransformUtils.wrapperContextForParams(r3, d.c.d.class, "com.obric.aiagent.plugin"));
    }

    public av(d.c.g r3, boolean r4) {
        super((d.c.g) ZeusTransformUtils.wrapperContextForParams(r3, d.c.g.class, "com.obric.aiagent.plugin"), true, r4);
    }

    @Override // kotlinx.coroutines.au
    public T f() {
        return (T) r();
    }

    static /* synthetic */ <T> Object a(av<T> r2, d.c.d<? super T> r3) {
        Object r4 = r2.c((d.c.d) ZeusTransformUtils.wrapperContextForParams(r3, d.c.d.class, "com.obric.aiagent.plugin"));
        d.c.a.b.a();
        return r4;
    }

    @Override // kotlinx.coroutines.au
    public kotlinx.coroutines.e.g<T> g() {
        kotlinx.coroutines.e.g<T> r1 = (kotlinx.coroutines.e.g<T>) s();
        d.h.b.o.a(r1, "null cannot be cast to non-null type kotlinx.coroutines.selects.SelectClause1<T of kotlinx.coroutines.DeferredCoroutine>");
        return r1;
    }
}
