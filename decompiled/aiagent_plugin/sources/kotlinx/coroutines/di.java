package kotlinx.coroutines;

import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: compiled from: CoroutineContext.kt */
/* JADX INFO: loaded from: classes4.dex */
public final class di<T> extends kotlinx.coroutines.internal.ah<T> {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final ThreadLocal<d.m<d.c.g, Object>> f39265b;
    private volatile boolean threadLocalIsSet;

    public di(d.c.g r4, d.c.d<? super T> r5) {
        d.c.g r6 = (d.c.g) ZeusTransformUtils.wrapperContextForParams(r4, d.c.g.class, "com.obric.aiagent.plugin");
        d.c.d r7 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r5, d.c.d.class, "com.obric.aiagent.plugin");
        if (r6.get((d.c.g.c) ZeusTransformUtils.preCheckCast(dj.f39266a, d.c.g.c.class, "com.obric.aiagent.plugin")) != null) goto L5;
        d.c.g r0 = r6.plus((d.c.g) ZeusTransformUtils.preCheckCast(dj.f39266a, d.c.g.class, "com.obric.aiagent.plugin"));
    L6:
        super(r0, r7);
        this.f39265b = new ThreadLocal();
        if (ZeusTransformUtils.instanceOf(r7.getContext().get((d.c.g.c) ZeusTransformUtils.preCheckCast(d.c.e.f38420b, d.c.g.c.class, "com.obric.aiagent.plugin")), ai.class) == true) goto L10;
        Object r8 = kotlinx.coroutines.internal.ap.a(r6, null);
        kotlinx.coroutines.internal.ap.b(r6, r8);
        a(r6, r8);
        return;
    L10:
        return;
    L5:
        r0 = r6;
        goto L6
    }

    public final void a(d.c.g r3, Object r4) {
        d.c.g r5 = (d.c.g) ZeusTransformUtils.wrapperContextForParams(r3, d.c.g.class, "com.obric.aiagent.plugin");
        this.threadLocalIsSet = true;
        this.f39265b.set(d.s.a(r5, r4));
    }

    public final boolean g() {
        if (this.threadLocalIsSet == true) goto L5;
    L7:
        boolean r0 = false;
    L8:
        this.f39265b.remove();
        return !r0;
    L5:
        if (this.f39265b.get() != null) goto L7;
        r0 = true;
        goto L8
    }

    @Override // kotlinx.coroutines.internal.ah, kotlinx.coroutines.a
    public void c(Object r6) {
        if (this.threadLocalIsSet == false) goto L8;
        d.m r0 = (d.m) ZeusTransformUtils.preCheckCast(this.f39265b.get(), d.m.class, "com.obric.aiagent.plugin");
        if (r0 == null) goto L7;
        kotlinx.coroutines.internal.ap.b((d.c.g) ZeusTransformUtils.preCheckCast(r0.c(), d.c.g.class, "com.obric.aiagent.plugin"), r0.d());
    L7:
        this.f39265b.remove();
    L8:
        Object r7 = ae.a(r6, this.f39362c);
        d.c.d<T> r1 = this.f39362c;
        d.c.g r2 = r1.getContext();
        di<?> r3 = null;
        Object r4 = kotlinx.coroutines.internal.ap.a(r2, null);
        if (r4 == kotlinx.coroutines.internal.ap.f39371a) goto L23;
        r3 = ah.a(r1, r2, r4);
    L23:
        this.f39362c.resumeWith(r7);     // Catch: Throwable -> L17
        d.x r5 = d.x.f38692a;     // Catch: Throwable -> L17
        if (r3 != null) goto L14;
    L15:
        kotlinx.coroutines.internal.ap.b(r2, r4);
        return;
    L14:
        if (r3.g() == true) goto L15;
        return;
    L17:
        th = move-exception;
        if (r3 != null) goto L20;
    L21:
        kotlinx.coroutines.internal.ap.b(r2, r4);
    L22:
        throw th;
    L20:
        if (r3.g() == false) goto L22;
        goto L21
    }
}
