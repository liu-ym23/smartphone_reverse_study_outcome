package androidx.lifecycle;

import com.bytedance.apm.battery.dao.DBHelper;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlinx.coroutines.bd;
import kotlinx.coroutines.ce;

/* JADX INFO: compiled from: Lifecycle.kt */
/* JADX INFO: loaded from: classes.dex */
public final class LifecycleCoroutineScopeImpl extends k implements m {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final i f1923a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final d.c.g f1924b;

    /* JADX INFO: compiled from: Lifecycle.kt */
    @d.c.b.a.f(b = "Lifecycle.kt", c = {}, d = "invokeSuspend", e = "androidx.lifecycle.LifecycleCoroutineScopeImpl$register$1")
    static final class a extends d.c.b.a.l implements d.h.a.m<kotlinx.coroutines.am, d.c.d<? super d.x>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f1925a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ LifecycleCoroutineScopeImpl f1926b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private /* synthetic */ Object f1927c;

        a(LifecycleCoroutineScopeImpl r3, d.c.d<? super a> r4) {
            d.c.d r5 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
            this.f1926b = r3;
            super(2, r5);
        }

        public final Object a(kotlinx.coroutines.am r3, d.c.d<? super d.x> r4) {
            return ((a) ZeusTransformUtils.preCheckCast(create((kotlinx.coroutines.am) ZeusTransformUtils.wrapperContextForParams(r3, kotlinx.coroutines.am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin")), a.class, "com.obric.aiagent.plugin")).invokeSuspend(d.x.f38692a);
        }

        @Override // d.c.b.a.a
        public final d.c.d<d.x> create(Object r3, d.c.d<?> r4) {
            d.c.d r5 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
            a r0 = new a(this.f1926b, r5);
            r0.f1927c = r3;
            return (d.c.d) ZeusTransformUtils.preCheckCast(r0, d.c.d.class, "com.obric.aiagent.plugin");
        }

        @Override // d.h.a.m
        public /* synthetic */ Object invoke(kotlinx.coroutines.am r3, d.c.d<? super d.x> r4) {
            return a((kotlinx.coroutines.am) ZeusTransformUtils.preCheckCast(r3, kotlinx.coroutines.am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.preCheckCast(r4, d.c.d.class, "com.obric.aiagent.plugin"));
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r5) {
            d.c.a.b.a();
            if (this.f1925a != 0) goto L11;
            d.o.a(r5);
            kotlinx.coroutines.am r6 = (kotlinx.coroutines.am) ZeusTransformUtils.preCheckCast(this.f1927c, kotlinx.coroutines.am.class, "com.obric.aiagent.plugin");
            if (this.f1926b.b().b().compareTo((Enum) ZeusTransformUtils.preCheckCast(i.b.f2055b, Enum.class, "com.obric.aiagent.plugin")) < 0) goto L7;
            this.f1926b.b().a((o) ZeusTransformUtils.preCheckCast(this.f1926b, o.class, "com.obric.aiagent.plugin"));
        L9:
            return d.x.f38692a;
        L7:
            ce.a(r6.a(), null, 1, null);
            goto L9
        L11:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    @Override // androidx.lifecycle.k
    public i b() {
        return this.f1923a;
    }

    @Override // kotlinx.coroutines.am
    public d.c.g a() {
        return this.f1924b;
    }

    public LifecycleCoroutineScopeImpl(i r3, d.c.g r4) {
        d.c.g r5 = (d.c.g) ZeusTransformUtils.wrapperContextForParams(r4, d.c.g.class, "com.obric.aiagent.plugin");
        d.h.b.o.e(r3, "lifecycle");
        d.h.b.o.e(r5, "coroutineContext");
        this.f1923a = r3;
        this.f1924b = r5;
        if (b().b() != i.b.f2054a) goto L6;
        ce.a(a(), null, 1, null);
        return;
    }

    public final void c() {
        kotlinx.coroutines.i.a((kotlinx.coroutines.am) ZeusTransformUtils.preCheckCast(this, kotlinx.coroutines.am.class, "com.obric.aiagent.plugin"), (d.c.g) ZeusTransformUtils.preCheckCast(bd.b().a(), d.c.g.class, "com.obric.aiagent.plugin"), null, (d.h.a.m) ZeusTransformUtils.preCheckCast(new a(this, null), d.h.a.m.class, "com.obric.aiagent.plugin"), 2, null);
    }

    @Override // androidx.lifecycle.m
    public void onStateChanged(p r3, i.a r4) {
        d.h.b.o.e((p) ZeusTransformUtils.wrapperContextForParams(r3, p.class, "com.obric.aiagent.plugin"), DBHelper.BATTERY_COL_SOURCE);
        d.h.b.o.e(r4, "event");
        if (b().b().compareTo((Enum) ZeusTransformUtils.preCheckCast(i.b.f2054a, Enum.class, "com.obric.aiagent.plugin")) > 0) goto L6;
        b().b((o) ZeusTransformUtils.preCheckCast(this, o.class, "com.obric.aiagent.plugin"));
        ce.a(a(), null, 1, null);
        return;
    }
}
