package kotlinx.coroutines.internal;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import kotlinx.coroutines.ba;
import kotlinx.coroutines.bj;
import kotlinx.coroutines.cz;

/* JADX INFO: compiled from: DispatchedContinuation.kt */
/* JADX INFO: loaded from: classes4.dex */
public final class m<T> extends ba<T> implements d.c.b.a.e, d.c.d<T> {
    private static final /* synthetic */ AtomicReferenceFieldUpdater h = null;
    private volatile /* synthetic */ Object _reusableCancellableContinuation$volatile;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final kotlinx.coroutines.ai f39397b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final d.c.d<T> f39398c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public Object f39399d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Object f39400e;

    static {
        h = AtomicReferenceFieldUpdater.newUpdater(m.class, Object.class, "_reusableCancellableContinuation$volatile");
    }

    private static final /* synthetic */ AtomicReferenceFieldUpdater h() {
        return h;
    }

    @Override // d.c.d
    public d.c.g getContext() {
        return this.f39398c.getContext();
    }

    @Override // d.c.b.a.e
    public StackTraceElement getStackTraceElement() {
        return null;
    }

    public m(kotlinx.coroutines.ai r3, d.c.d<? super T> r4) {
        d.c.d<T> r5 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
        super(-1);
        this.f39397b = r3;
        this.f39398c = r5;
        this.f39399d = n.a();
        this.f39400e = ap.a(getContext());
    }

    @Override // d.c.b.a.e
    public d.c.b.a.e getCallerFrame() {
        d.c.d<T> r2 = this.f39398c;
        if (ZeusTransformUtils.instanceOf(r2, d.c.b.a.e.class) == true) goto L7;
        return null;
    L7:
        return (d.c.b.a.e) ZeusTransformUtils.preCheckCast(r2, d.c.b.a.e.class, "com.obric.aiagent.plugin");
    }

    private final kotlinx.coroutines.o<?> f() {
        Object r2 = h().get(this);
        if (ZeusTransformUtils.instanceOf(r2, kotlinx.coroutines.o.class) == true) goto L7;
        return null;
    L7:
        return (kotlinx.coroutines.o) ZeusTransformUtils.preCheckCast(r2, kotlinx.coroutines.o.class, "com.obric.aiagent.plugin");
    }

    public final boolean a() {
        if (h().get(this) == null) goto L5;
        return true;
    L5:
        return false;
    }

    public final void b() {
        AtomicReferenceFieldUpdater r0 = h();
    L4:
        if (r0.get(this) == n.f39401a) goto L4;
    }

    public final void d() {
        b();
        kotlinx.coroutines.o<?> r0 = f();
        if (r0 == null) goto L6;
        r0.j();
        return;
    }

    public final kotlinx.coroutines.o<T> e() {
        AtomicReferenceFieldUpdater r0 = h();
    L3:
        Object r1 = r0.get(this);
        if (r1 == null) goto L5;
        if (ZeusTransformUtils.instanceOf(r1, kotlinx.coroutines.o.class) == true) goto L10;
        if (r1 == n.f39401a) goto L3;
        if (ZeusTransformUtils.instanceOf(r1, Throwable.class) == true) goto L3;
        throw new IllegalStateException(("Inconsistent state " + r1).toString());
    L10:
        if (h().compareAndSet(this, r1, n.f39401a) == false) goto L3;
        return (kotlinx.coroutines.o) ZeusTransformUtils.preCheckCast(r1, kotlinx.coroutines.o.class, "com.obric.aiagent.plugin");
    L5:
        h().set(this, n.f39401a);
        return null;
    }

    public final Throwable a(kotlinx.coroutines.n<?> r6) {
        kotlinx.coroutines.n r7 = (kotlinx.coroutines.n) ZeusTransformUtils.wrapperContextForParams(r6, kotlinx.coroutines.n.class, "com.obric.aiagent.plugin");
        AtomicReferenceFieldUpdater r0 = h();
    L3:
        Object r2 = r0.get(this);
        if (r2 != n.f39401a) goto L9;
        if (h().compareAndSet(this, n.f39401a, r7) == false) goto L3;
        return null;
    L9:
        if (ZeusTransformUtils.instanceOf(r2, Throwable.class) == false) goto L17;
        if (h().compareAndSet(this, r2, null) == false) goto L15;
        return (Throwable) ZeusTransformUtils.preCheckCast(r2, Throwable.class, "com.obric.aiagent.plugin");
    L15:
        throw new IllegalArgumentException("Failed requirement.".toString());
    L17:
        throw new IllegalStateException(("Inconsistent state " + r2).toString());
    }

    public final boolean a(Throwable r5) {
        AtomicReferenceFieldUpdater r0 = h();
    L3:
        Object r1 = r0.get(this);
        if (d.h.b.o.a(r1, n.f39401a) == true) goto L6;
        if (ZeusTransformUtils.instanceOf(r1, Throwable.class) == true) goto L10;
        if (h().compareAndSet(this, r1, null) == false) goto L3;
        return false;
    L10:
        return true;
    L6:
        if (h().compareAndSet(this, n.f39401a, r5) == false) goto L3;
        return true;
    }

    @Override // kotlinx.coroutines.ba
    public Object g() {
        Object r0 = this.f39399d;
        if (kotlinx.coroutines.aq.a() == true) goto L5;
    L12:
        this.f39399d = n.a();
        return r0;
    L5:
        if (r0 == n.a()) goto L7;
        boolean r1 = true;
    L8:
        if (r1 == true) goto L12;
        throw new AssertionError();
    L7:
        r1 = false;
        goto L8
    }

    @Override // kotlinx.coroutines.ba
    public d.c.d<T> c() {
        return (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin");
    }

    @Override // d.c.d
    public void resumeWith(Object r8) {
        d.c.g r0 = this.f39398c.getContext();
        Object r3 = kotlinx.coroutines.ae.a(r8, null, 1, null);
        if (this.f39397b.a(r0) == false) goto L5;
        this.f39399d = r3;
        this.f39142a = 0;
        this.f39397b.a(r0, (Runnable) ZeusTransformUtils.preCheckCast(this, Runnable.class, "com.obric.aiagent.plugin"));
        return;
    L5:
        kotlinx.coroutines.aq.a();
        bj r1 = cz.f39215a.a();
        if (r1.h() == false) goto L8;
        this.f39399d = r3;
        this.f39142a = 0;
        r1.a((ba) ZeusTransformUtils.preCheckCast(this, ba.class, "com.obric.aiagent.plugin"));
        return;
    L8:
        ba r4 = (ba) ZeusTransformUtils.preCheckCast(this, ba.class, "com.obric.aiagent.plugin");
        r1.a(true);
        d.c.g r5 = getContext();     // Catch: Throwable -> L18
        Object r6 = ap.a(r5, this.f39400e);     // Catch: Throwable -> L18
        this.f39398c.resumeWith(r8);     // Catch: Throwable -> L15
        d.x r7 = d.x.f38692a;     // Catch: Throwable -> L15
        ap.b(r5, r6);     // Catch: Throwable -> L18
    L13:
        if (r1.f() == true) goto L13;
    L20:
        r1.b(true);
        return;
    L15:
        th = move-exception;
        ap.b(r5, r6);     // Catch: Throwable -> L18
        throw th;     // Catch: Throwable -> L18
    L18:
        th = move-exception;
        r4.a(th, null);     // Catch: Throwable -> L22
    L22:
        th = move-exception;
        r1.b(true);
        throw th;
    }

    @Override // kotlinx.coroutines.ba
    public void a(Object r2, Throwable r3) {
        if (ZeusTransformUtils.instanceOf(r2, kotlinx.coroutines.ac.class) == false) goto L6;
        ((kotlinx.coroutines.ac) ZeusTransformUtils.preCheckCast(r2, kotlinx.coroutines.ac.class, "com.obric.aiagent.plugin")).f38832b.invoke(r3);
        return;
    }

    public final void a(d.c.g r3, T r4) {
        d.c.g r5 = (d.c.g) ZeusTransformUtils.wrapperContextForParams(r3, d.c.g.class, "com.obric.aiagent.plugin");
        this.f39399d = r4;
        this.f39142a = 1;
        this.f39397b.b(r5, (Runnable) ZeusTransformUtils.preCheckCast(this, Runnable.class, "com.obric.aiagent.plugin"));
    }

    public String toString() {
        return "DispatchedContinuation[" + this.f39397b + ", " + kotlinx.coroutines.ar.a(this.f39398c) + ']';
    }
}
