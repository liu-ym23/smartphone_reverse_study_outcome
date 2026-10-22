package kotlinx.coroutines.b;

import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: compiled from: Builders.kt */
/* JADX INFO: loaded from: classes4.dex */
final class aa<T> extends a<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final d.h.a.m<i<? super T>, d.c.d<? super d.x>, Object> f38953a;

    public aa(d.h.a.m<? super i<? super T>, ? super d.c.d<? super d.x>, ? extends Object> r3) {
        this.f38953a = (d.h.a.m) ZeusTransformUtils.wrapperContextForParams(r3, d.h.a.m.class, "com.obric.aiagent.plugin");
    }

    @Override // kotlinx.coroutines.b.a
    public Object a(i<? super T> r3, d.c.d<? super d.x> r4) {
        i<? super T> r5 = (i) ZeusTransformUtils.wrapperContextForParams(r3, i.class, "com.obric.aiagent.plugin");
        d.c.d<? super d.x> r6 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
        Object r2 = this.f38953a.invoke(r5, r6);
        if (r2 != d.c.a.b.a()) goto L6;
        return r2;
    L6:
        return d.x.f38692a;
    }
}
