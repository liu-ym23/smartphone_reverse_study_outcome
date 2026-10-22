package kotlinx.coroutines.b;

import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: compiled from: Builders.kt */
/* JADX INFO: loaded from: classes4.dex */
class e<T> extends kotlinx.coroutines.b.a.e<T> {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final d.h.a.m<kotlinx.coroutines.a.q<? super T>, d.c.d<? super d.x>, Object> f39018d;

    @Override // kotlinx.coroutines.b.a.e
    public Object a(kotlinx.coroutines.a.q<? super T> r3, d.c.d<? super d.x> r4) {
        return a(this, (kotlinx.coroutines.a.q) ZeusTransformUtils.wrapperContextForParams(r3, kotlinx.coroutines.a.q.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin"));
    }

    public /* synthetic */ e(d.h.a.m r2, d.c.g r3, int r4, kotlinx.coroutines.a.a r5, int r6, d.h.b.h r7) {
        d.h.a.m r8 = (d.h.a.m) ZeusTransformUtils.wrapperContextForParams(r2, d.h.a.m.class, "com.obric.aiagent.plugin");
        d.c.g r9 = (d.c.g) ZeusTransformUtils.wrapperContextForParams(r3, d.c.g.class, "com.obric.aiagent.plugin");
        if ((r6 & 2) == 0) goto L6;
        r9 = (d.c.g) ZeusTransformUtils.preCheckCast(d.c.h.f38423a, d.c.g.class, "com.obric.aiagent.plugin");
    L6:
        if ((r6 & 4) == 0) goto L9;
        r4 = -2;
    L9:
        if ((r6 & 8) == 0) goto L11;
        r5 = kotlinx.coroutines.a.a.f38771a;
    L11:
        this(r8, r9, r4, r5);
    }

    public e(d.h.a.m<? super kotlinx.coroutines.a.q<? super T>, ? super d.c.d<? super d.x>, ? extends Object> r3, d.c.g r4, int r5, kotlinx.coroutines.a.a r6) {
        d.h.a.m<kotlinx.coroutines.a.q<? super T>, d.c.d<? super d.x>, Object> r7 = (d.h.a.m) ZeusTransformUtils.wrapperContextForParams(r3, d.h.a.m.class, "com.obric.aiagent.plugin");
        super((d.c.g) ZeusTransformUtils.wrapperContextForParams(r4, d.c.g.class, "com.obric.aiagent.plugin"), r5, r6);
        this.f39018d = r7;
    }

    @Override // kotlinx.coroutines.b.a.e
    public kotlinx.coroutines.b.a.e<T> a(d.c.g r3, int r4, kotlinx.coroutines.a.a r5) {
        d.c.g r6 = (d.c.g) ZeusTransformUtils.wrapperContextForParams(r3, d.c.g.class, "com.obric.aiagent.plugin");
        return (kotlinx.coroutines.b.a.e) ZeusTransformUtils.preCheckCast(new e(this.f39018d, r6, r4, r5), kotlinx.coroutines.b.a.e.class, "com.obric.aiagent.plugin");
    }

    static /* synthetic */ <T> Object a(e<T> r2, kotlinx.coroutines.a.q<? super T> r3, d.c.d<? super d.x> r4) {
        kotlinx.coroutines.a.q<? super T> r5 = (kotlinx.coroutines.a.q) ZeusTransformUtils.wrapperContextForParams(r3, kotlinx.coroutines.a.q.class, "com.obric.aiagent.plugin");
        d.c.d<? super d.x> r6 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
        Object r7 = ((e) r2).f39018d.invoke(r5, r6);
        if (r7 != d.c.a.b.a()) goto L6;
        return r7;
    L6:
        return d.x.f38692a;
    }

    @Override // kotlinx.coroutines.b.a.e
    public String toString() {
        return "block[" + this.f39018d + "] -> " + super.toString();
    }
}
