package kotlinx.coroutines.b;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.concurrent.atomic.AtomicReference;
import kotlinx.coroutines.aq;

/* JADX INFO: compiled from: StateFlow.kt */
/* JADX INFO: loaded from: classes4.dex */
final class an extends kotlinx.coroutines.b.a.d<al<?>> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final AtomicReference<Object> f39002a;

    public an() {
        this.f39002a = new AtomicReference(null);
    }

    public static final /* synthetic */ AtomicReference a(an r0) {
        return r0.f39002a;
    }

    @Override // kotlinx.coroutines.b.a.d
    public /* synthetic */ boolean a(al<?> r3) {
        return a2((al) ZeusTransformUtils.preCheckCast(r3, al.class, "com.obric.aiagent.plugin"));
    }

    @Override // kotlinx.coroutines.b.a.d
    public /* synthetic */ d.c.d[] b(al<?> r3) {
        return b2((al) ZeusTransformUtils.preCheckCast(r3, al.class, "com.obric.aiagent.plugin"));
    }

    /* JADX INFO: renamed from: a, reason: avoid collision after fix types in other method */
    public boolean a2(al<?> r1) {
        if (kotlinx.coroutines.internal.g.a(this.f39002a) == null) goto L6;
        return false;
    L6:
        kotlinx.coroutines.internal.g.a(this.f39002a, am.a());
        return true;
    }

    /* JADX INFO: renamed from: b, reason: avoid collision after fix types in other method */
    public d.c.d<d.x>[] b2(al<?> r1) {
        kotlinx.coroutines.internal.g.a(this.f39002a, null);
        return kotlinx.coroutines.b.a.c.f38881a;
    }

    public final void a() {
        AtomicReference<Object> r0 = this.f39002a;
    L3:
        Object r1 = kotlinx.coroutines.internal.g.a(r0);
        if (r1 == null) goto L5;
        if (r1 == am.b()) goto L8;
        if (r1 == am.a()) goto L12;
        if (this.f39002a.compareAndSet(r1, am.a()) == false) goto L3;
        d.c.d r4 = (d.c.d) ZeusTransformUtils.preCheckCast((kotlinx.coroutines.o) ZeusTransformUtils.preCheckCast(r1, kotlinx.coroutines.o.class, "com.obric.aiagent.plugin"), d.c.d.class, "com.obric.aiagent.plugin");
        d.n.a r2 = d.n.f38560a;
        r4.resumeWith(d.n.f(d.x.f38692a));
        return;
    L12:
        if (this.f39002a.compareAndSet(r1, am.b()) == false) goto L3;
        return;
    L8:
        return;
    }

    public final boolean b() {
        Object r2 = this.f39002a.getAndSet(am.a());
        d.h.b.o.a(r2);
        if (aq.a() == false) goto L10;
        if ((!ZeusTransformUtils.instanceOf(r2, kotlinx.coroutines.o.class)) == true) goto L10;
        throw new AssertionError();
    L10:
        if (r2 == am.b()) goto L14;
        return false;
    L14:
        return true;
    }

    public final Object a(d.c.d<? super d.x> r7) {
        d.c.d r8 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r7, d.c.d.class, "com.obric.aiagent.plugin");
        boolean r3 = true;
        kotlinx.coroutines.o r0 = new kotlinx.coroutines.o(d.c.a.b.a(r8), 1);
        r0.e();
        kotlinx.coroutines.n r2 = (kotlinx.coroutines.n) ZeusTransformUtils.preCheckCast(r0, kotlinx.coroutines.n.class, "com.obric.aiagent.plugin");
        if (aq.a() == false) goto L10;
        if ((!ZeusTransformUtils.instanceOf(kotlinx.coroutines.internal.g.a(a(this)), kotlinx.coroutines.o.class)) == true) goto L10;
        throw new AssertionError();
    L10:
        if (a(this).compareAndSet(am.a(), r2) == false) goto L12;
    L22:
        Object r6 = r0.h();
        if (r6 != d.c.a.b.a()) goto L26;
        d.c.b.a.h.c(r8);
    L26:
        if (r6 != d.c.a.b.a()) goto L29;
        return r6;
    L29:
        return d.x.f38692a;
    L12:
        if (aq.a() == true) goto L14;
    L21:
        d.c.d r9 = (d.c.d) ZeusTransformUtils.preCheckCast(r2, d.c.d.class, "com.obric.aiagent.plugin");
        d.n.a r1 = d.n.f38560a;
        r9.resumeWith(d.n.f(d.x.f38692a));
        goto L22
    L14:
        if (kotlinx.coroutines.internal.g.a(a(this)) == am.b()) goto L17;
        r3 = false;
    L17:
        if (r3 == true) goto L21;
        throw new AssertionError();
    }
}
