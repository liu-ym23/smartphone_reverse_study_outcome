package kotlinx.coroutines;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.concurrent.CancellationException;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;

/* JADX INFO: compiled from: CancellableContinuationImpl.kt */
/* JADX INFO: loaded from: classes4.dex */
public class o<T> extends ba<T> implements d.c.b.a.e, dk, n<T> {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final /* synthetic */ AtomicIntegerFieldUpdater f39435d = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static final /* synthetic */ AtomicReferenceFieldUpdater f39436e = null;
    private static final /* synthetic */ AtomicReferenceFieldUpdater h = null;
    private volatile /* synthetic */ int _decisionAndIndex$volatile;
    private volatile /* synthetic */ Object _parentHandle$volatile;
    private volatile /* synthetic */ Object _state$volatile;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final d.c.d<T> f39437b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final d.c.g f39438c;

    static {
        f39435d = AtomicIntegerFieldUpdater.newUpdater(o.class, "_decisionAndIndex$volatile");
        f39436e = AtomicReferenceFieldUpdater.newUpdater(o.class, Object.class, "_state$volatile");
        h = AtomicReferenceFieldUpdater.newUpdater(o.class, Object.class, "_parentHandle$volatile");
    }

    private static final /* synthetic */ AtomicIntegerFieldUpdater s() {
        return f39435d;
    }

    private static final /* synthetic */ AtomicReferenceFieldUpdater t() {
        return f39436e;
    }

    private static final /* synthetic */ AtomicReferenceFieldUpdater u() {
        return h;
    }

    @Override // d.c.b.a.e
    public StackTraceElement getStackTraceElement() {
        return null;
    }

    public String k() {
        return "CancellableContinuation";
    }

    @Override // kotlinx.coroutines.ba
    public final d.c.d<T> c() {
        return this.f39437b;
    }

    public o(d.c.d<? super T> r3, int r4) {
        d.c.d<T> r5 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r3, d.c.d.class, "com.obric.aiagent.plugin");
        super(r4);
        this.f39437b = r5;
        if (aq.a() == true) goto L5;
    L12:
        this.f39438c = r5.getContext();
        this._decisionAndIndex$volatile = 536870911;
        this._state$volatile = d.f39217a;
        return;
    L5:
        if (r4 == (-1)) goto L7;
        boolean r6 = true;
    L8:
        if (r6 == true) goto L12;
        throw new AssertionError();
    L7:
        r6 = false;
        goto L8
    }

    @Override // d.c.d
    public d.c.g getContext() {
        return this.f39438c;
    }

    private final bf l() {
        return (bf) ZeusTransformUtils.preCheckCast(u().get(this), bf.class, "com.obric.aiagent.plugin");
    }

    public final Object d() {
        return t().get(this);
    }

    @Override // kotlinx.coroutines.n
    public boolean a() {
        return ZeusTransformUtils.instanceOf(d(), cq.class);
    }

    @Override // kotlinx.coroutines.n
    public boolean b() {
        return !ZeusTransformUtils.instanceOf(d(), cq.class);
    }

    private final String m() {
        Object r1 = d();
        if (ZeusTransformUtils.instanceOf(r1, cq.class) == false) goto L6;
        return "Active";
    L6:
        if (ZeusTransformUtils.instanceOf(r1, r.class) == false) goto L8;
        return "Cancelled";
    L8:
        return "Completed";
    }

    public void e() {
        bf r0 = q();
        if (r0 != null) goto L6;
        return;
    L6:
        if (b() == false) goto L9;
        r0.dispose();
        u().set(this, cp.f39210a);
        return;
    }

    private final boolean n() {
        if (bb.b(this.f39142a) == false) goto L7;
        d.c.d<T> r2 = this.f39437b;
        d.h.b.o.a(r2, "null cannot be cast to non-null type kotlinx.coroutines.internal.DispatchedContinuation<*>");
        if (((kotlinx.coroutines.internal.m) ZeusTransformUtils.preCheckCast(r2, kotlinx.coroutines.internal.m.class, "com.obric.aiagent.plugin")).a() == false) goto L7;
        return true;
    L7:
        return false;
    }

    public final boolean f() {
        if (aq.a() == false) goto L13;
        if (this.f39142a != 2) goto L7;
        boolean r0 = true;
    L8:
        if (r0 == true) goto L13;
        throw new AssertionError();
    L7:
        r0 = false;
    L13:
        if (aq.a() == true) goto L15;
    L22:
        Object r1 = t().get(this);
        if (aq.a() == false) goto L30;
        if ((!ZeusTransformUtils.instanceOf(r1, cq.class)) == true) goto L30;
        throw new AssertionError();
    L30:
        if (ZeusTransformUtils.instanceOf(r1, aa.class) == true) goto L32;
    L35:
        s().set(this, 536870911);
        t().set(this, d.f39217a);
        return true;
    L32:
        if (((aa) ZeusTransformUtils.preCheckCast(r1, aa.class, "com.obric.aiagent.plugin")).f38827d == null) goto L35;
        j();
        return false;
    L15:
        if (l() == cp.f39210a) goto L17;
        boolean r2 = true;
    L18:
        if (r2 == true) goto L22;
        throw new AssertionError();
    L17:
        r2 = false;
        goto L18
    }

    @Override // d.c.b.a.e
    public d.c.b.a.e getCallerFrame() {
        d.c.d<T> r2 = this.f39437b;
        if (ZeusTransformUtils.instanceOf(r2, d.c.b.a.e.class) == true) goto L7;
        return null;
    L7:
        return (d.c.b.a.e) ZeusTransformUtils.preCheckCast(r2, d.c.b.a.e.class, "com.obric.aiagent.plugin");
    }

    @Override // kotlinx.coroutines.ba
    public Object g() {
        return d();
    }

    @Override // kotlinx.coroutines.ba
    public void a(Object r20, Throwable r21) {
        AtomicReferenceFieldUpdater r1 = t();
    L3:
        Object r10 = r1.get(this);
        if (ZeusTransformUtils.instanceOf(r10, cq.class) == true) goto L23;
        if (ZeusTransformUtils.instanceOf(r10, ab.class) == true) goto L7;
        if (ZeusTransformUtils.instanceOf(r10, aa.class) == true) goto L11;
        if (t().compareAndSet(this, r10, new aa(r10, null, null, null, r21, 14, null)) == false) goto L3;
        return;
    L11:
        if ((!((aa) ZeusTransformUtils.preCheckCast(r10, aa.class, "com.obric.aiagent.plugin")).a()) == false) goto L18;
        if (t().compareAndSet(this, r10, aa.a((aa) ZeusTransformUtils.preCheckCast(r10, aa.class, "com.obric.aiagent.plugin"), null, null, null, null, r21, 15, null)) == false) goto L3;
        ((aa) ZeusTransformUtils.preCheckCast(r10, aa.class, "com.obric.aiagent.plugin")).a(this, r21);
        return;
    L18:
        throw new IllegalStateException("Must be called at most once".toString());
    L7:
        return;
    L23:
        throw new IllegalStateException("Not completed".toString());
    }

    private final boolean d(Throwable r3) {
        if (n() == true) goto L6;
        return false;
    L6:
        d.c.d<T> r2 = this.f39437b;
        d.h.b.o.a(r2, "null cannot be cast to non-null type kotlinx.coroutines.internal.DispatchedContinuation<*>");
        return ((kotlinx.coroutines.internal.m) ZeusTransformUtils.preCheckCast(r2, kotlinx.coroutines.internal.m.class, "com.obric.aiagent.plugin")).a(r3);
    }

    @Override // kotlinx.coroutines.n
    public boolean b(Throwable r9) {
        AtomicReferenceFieldUpdater r0 = t();
    L3:
        Object r1 = r0.get(this);
        boolean r3 = false;
        if (ZeusTransformUtils.instanceOf(r1, cq.class) == false) goto L5;
        d.c.d r4 = (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin");
        if (ZeusTransformUtils.instanceOf(r1, m.class) == false) goto L9;
    L10:
        r3 = true;
    L12:
        if (t().compareAndSet(this, r1, new r(r4, r9, r3)) == false) goto L3;
        cq r2 = (cq) ZeusTransformUtils.preCheckCast(r1, cq.class, "com.obric.aiagent.plugin");
        if (ZeusTransformUtils.instanceOf(r2, m.class) == false) goto L17;
        a((m) ZeusTransformUtils.preCheckCast(r1, m.class, "com.obric.aiagent.plugin"), r9);
    L19:
        r();
        a(this.f39142a);
        return true;
    L17:
        if (ZeusTransformUtils.instanceOf(r2, kotlinx.coroutines.internal.ai.class) == false) goto L19;
        a((kotlinx.coroutines.internal.ai) ZeusTransformUtils.preCheckCast(r1, kotlinx.coroutines.internal.ai.class, "com.obric.aiagent.plugin"), r9);
        goto L19
    L9:
        if (ZeusTransformUtils.instanceOf(r1, kotlinx.coroutines.internal.ai.class) == false) goto L12;
    L5:
        return false;
    }

    public final void c(Throwable r2) {
        if (d(r2) == false) goto L5;
        return;
    L5:
        b(r2);
        r();
    }

    public final void a(m r5, Throwable r6) {
        ((m) ZeusTransformUtils.wrapperContextForParams(r5, m.class, "com.obric.aiagent.plugin")).a(r6);     // Catch: Throwable -> L5
        return;
    L5:
        th = move-exception;
        aj.a(getContext(), (Throwable) ZeusTransformUtils.preCheckCast(new ad("Exception in invokeOnCancellation handler for " + this, th), Throwable.class, "com.obric.aiagent.plugin"));
    }

    private final void a(kotlinx.coroutines.internal.ai<?> r4, Throwable r5) {
        int r0 = s().get(this) & 536870911;
        if (r0 == 536870911) goto L5;
        boolean r1 = true;
    L6:
        if (r1 == false) goto L13;
        r4.a(r0, r5, getContext());     // Catch: Throwable -> L9
        return;
    L9:
        th = move-exception;
        aj.a(getContext(), (Throwable) ZeusTransformUtils.preCheckCast(new ad("Exception in invokeOnCancellation handler for " + this, th), Throwable.class, "com.obric.aiagent.plugin"));
        return;
    L13:
        throw new IllegalStateException("The index for Segment.onCancellation(..) is broken".toString());
    L5:
        r1 = false;
        goto L6
    }

    public final void a(d.h.a.b<? super Throwable, d.x> r5, Throwable r6) {
        ((d.h.a.b) ZeusTransformUtils.wrapperContextForParams(r5, d.h.a.b.class, "com.obric.aiagent.plugin")).invoke(r6);     // Catch: Throwable -> L5
        return;
    L5:
        th = move-exception;
        aj.a(getContext(), (Throwable) ZeusTransformUtils.preCheckCast(new ad("Exception in resume onCancellation handler for " + this, th), Throwable.class, "com.obric.aiagent.plugin"));
    }

    public Throwable a(ca r2) {
        return (Throwable) ZeusTransformUtils.preCheckCast(((ca) ZeusTransformUtils.wrapperContextForParams(r2, ca.class, "com.obric.aiagent.plugin")).k(), Throwable.class, "com.obric.aiagent.plugin");
    }

    private final boolean o() {
        AtomicIntegerFieldUpdater r0 = s();
    L3:
        int r1 = r0.get(this);
        int r2 = r1 >> 29;
        if (r2 != 0) goto L6;
        if (s().compareAndSet(this, r1, 536870912 + (536870911 & r1)) == false) goto L3;
        return true;
    L6:
        if (r2 != 2) goto L10;
        return false;
    L10:
        throw new IllegalStateException("Already suspended".toString());
    }

    private final boolean p() {
        AtomicIntegerFieldUpdater r0 = s();
    L3:
        int r1 = r0.get(this);
        int r2 = r1 >> 29;
        if (r2 != 0) goto L5;
        if (s().compareAndSet(this, r1, 1073741824 + (536870911 & r1)) == false) goto L3;
        return true;
    L5:
        if (r2 != 1) goto L9;
        return false;
    L9:
        throw new IllegalStateException("Already resumed".toString());
    }

    public final Object h() {
        boolean r0 = n();
        if (o() == true) goto L5;
        if (r0 == false) goto L13;
        i();
    L13:
        Object r1 = d();
        if (ZeusTransformUtils.instanceOf(r1, ab.class) == false) goto L23;
        Throwable r2 = ((ab) ZeusTransformUtils.preCheckCast(r1, ab.class, "com.obric.aiagent.plugin")).f38830a;
        if (aq.c() == true) goto L18;
        throw r2;
    L18:
        if (ZeusTransformUtils.instanceOf((d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin"), d.c.b.a.e.class) == true) goto L21;
        throw r2;
    L21:
        throw kotlinx.coroutines.internal.ak.a(r2, (d.c.b.a.e) ZeusTransformUtils.preCheckCast((d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin"), d.c.b.a.e.class, "com.obric.aiagent.plugin"));
    L23:
        if (bb.a(this.f39142a) == false) goto L37;
        ca r3 = (ca) ZeusTransformUtils.preCheckCast(getContext().get((d.c.g.c) ZeusTransformUtils.preCheckCast(ca.f39180a, d.c.g.c.class, "com.obric.aiagent.plugin")), ca.class, "com.obric.aiagent.plugin");
        if (r3 == null) goto L37;
        if (r3.b() == true) goto L37;
        CancellationException r4 = r3.k();
        a(r1, (Throwable) ZeusTransformUtils.preCheckCast(r4, Throwable.class, "com.obric.aiagent.plugin"));
        if (aq.c() == false) goto L35;
        if (ZeusTransformUtils.instanceOf((d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin"), d.c.b.a.e.class) == false) goto L35;
        throw kotlinx.coroutines.internal.ak.a((Throwable) ZeusTransformUtils.preCheckCast(r4, Throwable.class, "com.obric.aiagent.plugin"), (d.c.b.a.e) ZeusTransformUtils.preCheckCast((d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin"), d.c.b.a.e.class, "com.obric.aiagent.plugin"));
    L35:
        throw ((Throwable) ZeusTransformUtils.preCheckCast(r4, Throwable.class, "com.obric.aiagent.plugin"));
    L37:
        return b(r1);
    L5:
        if (l() != null) goto L7;
        q();
    L7:
        if (r0 == false) goto L10;
        i();
    L10:
        return d.c.a.b.a();
    }

    private final bf q() {
        ca r4 = (ca) ZeusTransformUtils.preCheckCast(getContext().get((d.c.g.c) ZeusTransformUtils.preCheckCast(ca.f39180a, d.c.g.c.class, "com.obric.aiagent.plugin")), ca.class, "com.obric.aiagent.plugin");
        if (r4 != null) goto L5;
        return null;
    L5:
        bf r1 = ce.a(r4, true, false, (bw) ZeusTransformUtils.preCheckCast(new s(this), bw.class, "com.obric.aiagent.plugin"), 2, null);
        u().compareAndSet(this, null, r1);
        return r1;
    }

    public final void i() {
        d.c.d<T> r0 = this.f39437b;
        if (ZeusTransformUtils.instanceOf(r0, kotlinx.coroutines.internal.m.class) == false) goto L5;
        kotlinx.coroutines.internal.m r1 = (kotlinx.coroutines.internal.m) ZeusTransformUtils.preCheckCast(r0, kotlinx.coroutines.internal.m.class, "com.obric.aiagent.plugin");
    L6:
        if (r1 == null) goto L12;
        Throwable r2 = r1.a((n) ZeusTransformUtils.preCheckCast(this, n.class, "com.obric.aiagent.plugin"));
        if (r2 == null) goto L13;
        j();
        b(r2);
        return;
    L13:
        return;
    L12:
        return;
    L5:
        r1 = null;
        goto L6
    }

    @Override // d.c.d
    public void resumeWith(Object r8) {
        a(this, ae.a(r8, (n) ZeusTransformUtils.preCheckCast(this, n.class, "com.obric.aiagent.plugin")), this.f39142a, null, 4, null);
    }

    @Override // kotlinx.coroutines.n
    public void a(T r3, d.h.a.b<? super Throwable, d.x> r4) {
        d.h.a.b<? super Throwable, d.x> r5 = (d.h.a.b) ZeusTransformUtils.wrapperContextForParams(r4, d.h.a.b.class, "com.obric.aiagent.plugin");
        a(r3, this.f39142a, r5);
    }

    @Override // kotlinx.coroutines.dk
    public void a(kotlinx.coroutines.internal.ai<?> r5, int r6) {
        AtomicIntegerFieldUpdater r0 = s();
    L3:
        int r1 = r0.get(this);
        if ((r1 & 536870911) != 536870911) goto L6;
        boolean r2 = true;
    L7:
        if (r2 == false) goto L13;
        if (r0.compareAndSet(this, r1, ((r1 >> 29) << 29) + r6) == false) goto L3;
        d(r5);
        return;
    L13:
        throw new IllegalStateException("invokeOnCancellation should be called at most once".toString());
    L6:
        r2 = false;
        goto L7
    }

    @Override // kotlinx.coroutines.n
    public void a(d.h.a.b<? super Throwable, d.x> r3) {
        d.h.a.b r4 = (d.h.a.b) ZeusTransformUtils.wrapperContextForParams(r3, d.h.a.b.class, "com.obric.aiagent.plugin");
        q.a((n) ZeusTransformUtils.preCheckCast(this, n.class, "com.obric.aiagent.plugin"), (m) ZeusTransformUtils.preCheckCast(new m.a(r4), m.class, "com.obric.aiagent.plugin"));
    }

    public final void a(m r3) {
        d((m) ZeusTransformUtils.wrapperContextForParams(r3, m.class, "com.obric.aiagent.plugin"));
    }

    private final void d(Object r22) {
        if (aq.a() == true) goto L5;
    L15:
        AtomicReferenceFieldUpdater r2 = t();
    L16:
        Object r12 = r2.get(this);
        if (ZeusTransformUtils.instanceOf(r12, d.class) == true) goto L19;
        if (ZeusTransformUtils.instanceOf(r12, m.class) == false) goto L24;
        boolean r4 = true;
    L25:
        if (r4 == true) goto L26;
        if (ZeusTransformUtils.instanceOf(r12, ab.class) == true) goto L30;
        if (ZeusTransformUtils.instanceOf(r12, aa.class) == true) goto L48;
        if (ZeusTransformUtils.instanceOf(r22, kotlinx.coroutines.internal.ai.class) == true) goto L62;
        d.h.b.o.a(r22, "null cannot be cast to non-null type kotlinx.coroutines.CancelHandler");
        m r5 = (m) ZeusTransformUtils.preCheckCast(r22, m.class, "com.obric.aiagent.plugin");
        if (t().compareAndSet(this, r12, new aa(r12, (m) ZeusTransformUtils.preCheckCast(r22, m.class, "com.obric.aiagent.plugin"), null, null, null, 28, null)) == false) goto L16;
        return;
    L62:
        return;
    L48:
        if (((aa) ZeusTransformUtils.preCheckCast(r12, aa.class, "com.obric.aiagent.plugin")).f38825b == null) goto L51;
        a(r22, r12);
    L51:
        if (ZeusTransformUtils.instanceOf(r22, kotlinx.coroutines.internal.ai.class) == true) goto L52;
        d.h.b.o.a(r22, "null cannot be cast to non-null type kotlinx.coroutines.CancelHandler");
        m r6 = (m) ZeusTransformUtils.preCheckCast(r22, m.class, "com.obric.aiagent.plugin");
        if (((aa) ZeusTransformUtils.preCheckCast(r12, aa.class, "com.obric.aiagent.plugin")).a() == true) goto L55;
        if (t().compareAndSet(this, r12, aa.a((aa) ZeusTransformUtils.preCheckCast(r12, aa.class, "com.obric.aiagent.plugin"), null, (m) ZeusTransformUtils.preCheckCast(r22, m.class, "com.obric.aiagent.plugin"), null, null, null, 29, null)) == false) goto L16;
        return;
    L55:
        a((m) ZeusTransformUtils.preCheckCast(r22, m.class, "com.obric.aiagent.plugin"), ((aa) ZeusTransformUtils.preCheckCast(r12, aa.class, "com.obric.aiagent.plugin")).f38828e);
        return;
    L52:
        return;
    L30:
        if (((ab) ZeusTransformUtils.preCheckCast(r12, ab.class, "com.obric.aiagent.plugin")).c() == true) goto L33;
        a(r22, r12);
    L33:
        if (ZeusTransformUtils.instanceOf(r12, r.class) == false) goto L84;
        Throwable r3 = null;
        if (ZeusTransformUtils.instanceOf(r12, ab.class) == false) goto L37;
        ab r7 = (ab) ZeusTransformUtils.preCheckCast(r12, ab.class, "com.obric.aiagent.plugin");
    L38:
        if (r7 == null) goto L41;
        r3 = r7.f38830a;
    L41:
        if (ZeusTransformUtils.instanceOf(r22, m.class) == false) goto L43;
        a((m) ZeusTransformUtils.preCheckCast(r22, m.class, "com.obric.aiagent.plugin"), r3);
        return;
    L43:
        d.h.b.o.a(r22, "null cannot be cast to non-null type kotlinx.coroutines.internal.Segment<*>");
        a((kotlinx.coroutines.internal.ai) ZeusTransformUtils.preCheckCast(r22, kotlinx.coroutines.internal.ai.class, "com.obric.aiagent.plugin"), r3);
        return;
    L37:
        r7 = null;
        goto L38
    L84:
        return;
    L26:
        a(r22, r12);
        goto L16
    L24:
        r4 = ZeusTransformUtils.instanceOf(r12, kotlinx.coroutines.internal.ai.class);
        goto L25
    L19:
        if (t().compareAndSet(this, r12, r22) == false) goto L16;
        return;
    L5:
        if (ZeusTransformUtils.instanceOf(r22, m.class) == false) goto L7;
    L10:
        boolean r8 = true;
    L11:
        if (r8 == true) goto L15;
        throw new AssertionError();
    L7:
        if (ZeusTransformUtils.instanceOf(r22, kotlinx.coroutines.internal.ai.class) == true) goto L10;
        r8 = false;
        goto L11
    }

    private final void a(Object r3, Object r4) {
        throw new IllegalStateException(("It's prohibited to register multiple handlers, tried to register " + r3 + ", already has " + r4).toString());
    }

    private final void a(int r3) {
        if (p() == false) goto L5;
        return;
    L5:
        bb.a((ba) ZeusTransformUtils.preCheckCast(this, ba.class, "com.obric.aiagent.plugin"), r3);
    }

    private final Object a(cq r10, Object r11, int r12, d.h.a.b<? super Throwable, d.x> r13, Object r14) {
        cq r9 = (cq) ZeusTransformUtils.wrapperContextForParams(r10, cq.class, "com.obric.aiagent.plugin");
        d.h.a.b r4 = (d.h.a.b) ZeusTransformUtils.wrapperContextForParams(r13, d.h.a.b.class, "com.obric.aiagent.plugin");
        if (ZeusTransformUtils.instanceOf(r11, ab.class) == false) goto L23;
        boolean r15 = true;
        if (aq.a() == false) goto L14;
        if (r14 != null) goto L8;
        boolean r16 = true;
    L9:
        if (r16 == true) goto L14;
        throw new AssertionError();
    L8:
        r16 = false;
    L14:
        if (aq.a() == false) goto L36;
        if (r4 == null) goto L18;
        r15 = false;
    L18:
        if (r15 == false) goto L21;
        return r11;
    L21:
        throw new AssertionError();
    L36:
        return r11;
    L23:
        if (bb.a(r12) == true) goto L26;
        if (r14 != null) goto L26;
        return r11;
    L26:
        if (r4 != null) goto L31;
        if (ZeusTransformUtils.instanceOf(r9, m.class) == true) goto L31;
        if (r14 != null) goto L31;
        return r11;
    L31:
        if (ZeusTransformUtils.instanceOf(r9, m.class) == false) goto L33;
        m r17 = (m) ZeusTransformUtils.preCheckCast(r9, m.class, "com.obric.aiagent.plugin");
    L35:
        return new aa(r11, r17, r4, r14, null, 16, null);
    L33:
        r17 = null;
        goto L35
    }

    private final void a(Object r10, int r11, d.h.a.b<? super Throwable, d.x> r12) {
        d.h.a.b<? super Throwable, d.x> r13 = (d.h.a.b) ZeusTransformUtils.wrapperContextForParams(r12, d.h.a.b.class, "com.obric.aiagent.plugin");
        AtomicReferenceFieldUpdater r0 = t();
    L3:
        Object r8 = r0.get(this);
        if (ZeusTransformUtils.instanceOf(r8, cq.class) == false) goto L10;
        Object r2 = a((cq) ZeusTransformUtils.preCheckCast(r8, cq.class, "com.obric.aiagent.plugin"), r10, r11, r13, null);
        if (t().compareAndSet(this, r8, r2) == false) goto L3;
        r();
        a(r11);
        return;
    L10:
        if (ZeusTransformUtils.instanceOf(r8, r.class) == true) goto L12;
    L16:
        e(r10);
        throw new d.d();
    L12:
        if (((r) ZeusTransformUtils.preCheckCast(r8, r.class, "com.obric.aiagent.plugin")).a() == false) goto L16;
        if (r13 == null) goto L21;
        a(r13, ((r) ZeusTransformUtils.preCheckCast(r8, r.class, "com.obric.aiagent.plugin")).f38830a);
        return;
    }

    static /* synthetic */ void a(o r2, Object r3, int r4, d.h.a.b r5, int r6, Object r7) {
        d.h.a.b<? super Throwable, d.x> r8 = (d.h.a.b) ZeusTransformUtils.wrapperContextForParams(r5, d.h.a.b.class, "com.obric.aiagent.plugin");
        if (r7 != null) goto L10;
        if ((r6 & 4) == 0) goto L7;
        r8 = null;
    L7:
        r2.a(r3, r4, r8);
        return;
    L10:
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: resumeImpl");
    }

    private final kotlinx.coroutines.internal.al b(Object r10, Object r11, d.h.a.b<? super Throwable, d.x> r12) {
        d.h.a.b<? super Throwable, d.x> r13 = (d.h.a.b) ZeusTransformUtils.wrapperContextForParams(r12, d.h.a.b.class, "com.obric.aiagent.plugin");
        AtomicReferenceFieldUpdater r0 = t();
    L3:
        Object r8 = r0.get(this);
        if (ZeusTransformUtils.instanceOf(r8, cq.class) == false) goto L10;
        Object r2 = a((cq) ZeusTransformUtils.preCheckCast(r8, cq.class, "com.obric.aiagent.plugin"), r10, this.f39142a, r13, r11);
        if (t().compareAndSet(this, r8, r2) == false) goto L3;
        r();
        return p.f39439a;
    L10:
        if (ZeusTransformUtils.instanceOf(r8, aa.class) == false) goto L26;
        if (r11 != null) goto L13;
        return null;
    L13:
        if (((aa) ZeusTransformUtils.preCheckCast(r8, aa.class, "com.obric.aiagent.plugin")).f38827d == r11) goto L15;
        return null;
    L15:
        if (aq.a() == false) goto L22;
        if (d.h.b.o.a(((aa) ZeusTransformUtils.preCheckCast(r8, aa.class, "com.obric.aiagent.plugin")).f38824a, r10) == true) goto L22;
        throw new AssertionError();
    L22:
        return p.f39439a;
    L26:
        return null;
    }

    private final Void e(Object r3) {
        throw new IllegalStateException(("Already resumed, but proposed with update " + r3).toString());
    }

    private final void r() {
        if (n() == true) goto L6;
        j();
        return;
    }

    public final void j() {
        bf r0 = l();
        if (r0 != null) goto L5;
        return;
    L5:
        r0.dispose();
        u().set(this, cp.f39210a);
    }

    @Override // kotlinx.coroutines.n
    public Object a(T r3, Object r4, d.h.a.b<? super Throwable, d.x> r5) {
        return b(r3, r4, (d.h.a.b) ZeusTransformUtils.wrapperContextForParams(r5, d.h.a.b.class, "com.obric.aiagent.plugin"));
    }

    @Override // kotlinx.coroutines.n
    public Object a(Throwable r5) {
        return b(new ab(r5, false, 2, null), null, null);
    }

    @Override // kotlinx.coroutines.n
    public void a(Object r2) {
        if (aq.a() == true) goto L5;
    L12:
        a(this.f39142a);
        return;
    L5:
        if (r2 != p.f39439a) goto L7;
        boolean r3 = true;
    L8:
        if (r3 == true) goto L12;
        throw new AssertionError();
    L7:
        r3 = false;
        goto L8
    }

    @Override // kotlinx.coroutines.n
    public void a(ai r7, T r8) {
        d.c.d<T> r0 = this.f39437b;
        ai r2 = null;
        if (ZeusTransformUtils.instanceOf(r0, kotlinx.coroutines.internal.m.class) == false) goto L5;
        kotlinx.coroutines.internal.m r1 = (kotlinx.coroutines.internal.m) ZeusTransformUtils.preCheckCast(r0, kotlinx.coroutines.internal.m.class, "com.obric.aiagent.plugin");
    L6:
        if (r1 == null) goto L8;
        r2 = r1.f39397b;
    L8:
        if (r2 != r7) goto L10;
        int r9 = 4;
    L11:
        a(this, r8, r9, null, 4, null);
        return;
    L10:
        r9 = this.f39142a;
        goto L11
    L5:
        r1 = null;
        goto L6
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // kotlinx.coroutines.ba
    public <T> T b(Object r2) {
        if (ZeusTransformUtils.instanceOf(r2, aa.class) == true) goto L5;
        return r2;
    L5:
        return (T) ((aa) ZeusTransformUtils.preCheckCast(r2, aa.class, "com.obric.aiagent.plugin")).f38824a;
    }

    @Override // kotlinx.coroutines.ba
    public Throwable c(Object r3) {
        Throwable r4 = super.c(r3);
        if (r4 == null) goto L10;
        d.c.d<T> r2 = this.f39437b;
        if (aq.c() == true) goto L7;
        return r4;
    L7:
        if (ZeusTransformUtils.instanceOf(r2, d.c.b.a.e.class) == true) goto L13;
        return r4;
    L13:
        return kotlinx.coroutines.internal.ak.a(r4, (d.c.b.a.e) ZeusTransformUtils.preCheckCast(r2, d.c.b.a.e.class, "com.obric.aiagent.plugin"));
    L10:
        return null;
    }

    public String toString() {
        return k() + '(' + ar.a(this.f39437b) + "){" + m() + "}@" + ar.a(this);
    }
}
