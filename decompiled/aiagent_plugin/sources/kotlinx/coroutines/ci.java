package kotlinx.coroutines;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.ArrayList;
import java.util.Collections;
import java.util.IdentityHashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.CancellationException;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;

/* JADX INFO: compiled from: JobSupport.kt */
/* JADX INFO: loaded from: classes4.dex */
public class ci implements ca, cr, v {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final /* synthetic */ AtomicReferenceFieldUpdater f39185b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final /* synthetic */ AtomicReferenceFieldUpdater f39186c = null;
    private volatile /* synthetic */ Object _parentHandle$volatile;
    private volatile /* synthetic */ Object _state$volatile;

    /* JADX INFO: compiled from: JobSupport.kt */
    private static final class a<T> extends o<T> {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final ci f39187b;

        @Override // kotlinx.coroutines.o
        public String k() {
            return "AwaitContinuation";
        }

        public a(d.c.d<? super T> r3, ci r4) {
            super((d.c.d) ZeusTransformUtils.wrapperContextForParams(r3, d.c.d.class, "com.obric.aiagent.plugin"), 1);
            this.f39187b = r4;
        }

        @Override // kotlinx.coroutines.o
        public Throwable a(ca r3) {
            ca r4 = (ca) ZeusTransformUtils.wrapperContextForParams(r3, ca.class, "com.obric.aiagent.plugin");
            Object r2 = this.f39187b.n();
            if (ZeusTransformUtils.instanceOf(r2, c.class) == false) goto L8;
            Throwable r0 = ((c) ZeusTransformUtils.preCheckCast(r2, c.class, "com.obric.aiagent.plugin")).d();
            if (r0 == null) goto L8;
            return r0;
        L8:
            if (ZeusTransformUtils.instanceOf(r2, ab.class) == false) goto L12;
            return ((ab) ZeusTransformUtils.preCheckCast(r2, ab.class, "com.obric.aiagent.plugin")).f38830a;
        L12:
            return (Throwable) ZeusTransformUtils.preCheckCast(r4.k(), Throwable.class, "com.obric.aiagent.plugin");
        }
    }

    /* JADX INFO: compiled from: JobSupport.kt */
    private static final class b extends ch {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final ci f39188a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final c f39189b;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private final u f39190d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private final Object f39191e;

        public b(ci r1, c r2, u r3, Object r4) {
            this.f39188a = r1;
            this.f39189b = r2;
            this.f39190d = r3;
            this.f39191e = r4;
        }

        @Override // kotlinx.coroutines.bw
        public void a(Throwable r3) {
            ci.a(this.f39188a, this.f39189b, this.f39190d, this.f39191e);
        }
    }

    /* JADX INFO: compiled from: JobSupport.kt */
    private static final class c implements bu {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private static final /* synthetic */ AtomicIntegerFieldUpdater f39192b = null;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private static final /* synthetic */ AtomicReferenceFieldUpdater f39193c = null;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private static final /* synthetic */ AtomicReferenceFieldUpdater f39194d = null;
        private volatile /* synthetic */ Object _exceptionsHolder$volatile;
        private volatile /* synthetic */ int _isCompleting$volatile;
        private volatile /* synthetic */ Object _rootCause$volatile;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final cn f39195a;

        static {
            f39192b = AtomicIntegerFieldUpdater.newUpdater(c.class, "_isCompleting$volatile");
            f39193c = AtomicReferenceFieldUpdater.newUpdater(c.class, Object.class, "_rootCause$volatile");
            f39194d = AtomicReferenceFieldUpdater.newUpdater(c.class, Object.class, "_exceptionsHolder$volatile");
        }

        private static final /* synthetic */ AtomicIntegerFieldUpdater i() {
            return f39192b;
        }

        private static final /* synthetic */ AtomicReferenceFieldUpdater j() {
            return f39193c;
        }

        private static final /* synthetic */ AtomicReferenceFieldUpdater k() {
            return f39194d;
        }

        @Override // kotlinx.coroutines.bu
        public cn o_() {
            return this.f39195a;
        }

        public c(cn r1, boolean r2, Throwable r3) {
            this.f39195a = r1;
            this._isCompleting$volatile = r2 ? 1 : 0;
            this._rootCause$volatile = r3;
        }

        public final boolean c() {
            if (i().get(this) == 0) goto L5;
            return true;
        L5:
            return false;
        }

        public final void a(boolean r2) {
            i().set(this, r2 ? 1 : 0);
        }

        public final Throwable d() {
            return (Throwable) ZeusTransformUtils.preCheckCast(j().get(this), Throwable.class, "com.obric.aiagent.plugin");
        }

        public final void a(Throwable r2) {
            j().set(this, r2);
        }

        private final Object g() {
            return k().get(this);
        }

        private final void a(Object r2) {
            k().set(this, r2);
        }

        public final boolean e() {
            if (g() != cj.f()) goto L5;
            return true;
        L5:
            return false;
        }

        public final boolean f() {
            if (d() == null) goto L5;
            return true;
        L5:
            return false;
        }

        @Override // kotlinx.coroutines.bu
        public boolean n_() {
            if (d() != null) goto L5;
            return true;
        L5:
            return false;
        }

        public final List<Throwable> b(Throwable r5) {
            Object r0 = g();
            if (r0 != null) goto L6;
            ArrayList<Throwable> r1 = h();
        L11:
            Throwable r2 = d();
            if (r2 == null) goto L14;
            r1.add(0, r2);
        L14:
            if (r5 != null) goto L16;
        L18:
            a(cj.f());
            return (List) ZeusTransformUtils.preCheckCast(r1, List.class, "com.obric.aiagent.plugin");
        L16:
            if (d.h.b.o.a(r5, r2) == true) goto L18;
            r1.add(r5);
            goto L18
        L6:
            if (ZeusTransformUtils.instanceOf(r0, Throwable.class) == false) goto L9;
            ArrayList<Throwable> r3 = h();
            r3.add(r0);
            r1 = r3;
            goto L11
        L9:
            if (ZeusTransformUtils.instanceOf(r0, ArrayList.class) == false) goto L21;
            r1 = (ArrayList) ZeusTransformUtils.preCheckCast(r0, ArrayList.class, "com.obric.aiagent.plugin");
            goto L11
        L21:
            throw new IllegalStateException(("State is " + r0).toString());
        }

        public final void c(Throwable r3) {
            Throwable r0 = d();
            if (r0 != null) goto L6;
            a(r3);
            return;
        L6:
            if (r3 != r0) goto L8;
            return;
        L8:
            Object r1 = g();
            if (r1 != null) goto L12;
            a(r3);
            return;
        L12:
            if (ZeusTransformUtils.instanceOf(r1, Throwable.class) == false) goto L17;
            if (r3 != r1) goto L15;
            return;
        L15:
            ArrayList<Throwable> r2 = h();
            r2.add(r1);
            r2.add(r3);
            a(r2);
            return;
        L17:
            if (ZeusTransformUtils.instanceOf(r1, ArrayList.class) == false) goto L21;
            ((ArrayList) ZeusTransformUtils.preCheckCast(r1, ArrayList.class, "com.obric.aiagent.plugin")).add(r3);
            return;
        L21:
            throw new IllegalStateException(("State is " + r1).toString());
        }

        private final ArrayList<Throwable> h() {
            return new ArrayList(4);
        }

        public String toString() {
            return "Finishing[cancelling=" + f() + ", completing=" + c() + ", rootCause=" + d() + ", exceptions=" + g() + ", list=" + o_() + ']';
        }
    }

    /* JADX INFO: compiled from: JobSupport.kt */
    private final class d extends ch {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ ci f39196a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final kotlinx.coroutines.e.j<?> f39197b;

        public d(ci r3, kotlinx.coroutines.e.j<?> r4) {
            kotlinx.coroutines.e.j<?> r5 = (kotlinx.coroutines.e.j) ZeusTransformUtils.wrapperContextForParams(r4, kotlinx.coroutines.e.j.class, "com.obric.aiagent.plugin");
            this.f39196a = r3;
            this.f39197b = r5;
        }

        @Override // kotlinx.coroutines.bw
        public void a(Throwable r2) {
            Object r3 = this.f39196a.n();
            if (ZeusTransformUtils.instanceOf(r3, ab.class) == true) goto L6;
            r3 = cj.b(r3);
        L6:
            this.f39197b.a(this.f39196a, r3);
        }
    }

    /* JADX INFO: compiled from: LockFreeLinkedList.kt */
    public static final class e extends kotlinx.coroutines.internal.x.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ ci f39198a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ Object f39199b;

        public e(kotlinx.coroutines.internal.x r1, ci r2, Object r3) {
            this.f39198a = r2;
            this.f39199b = r3;
            super(r1);
        }

        @Override // kotlinx.coroutines.internal.b
        public /* synthetic */ Object a(kotlinx.coroutines.internal.x r3) {
            return a2((kotlinx.coroutines.internal.x) ZeusTransformUtils.preCheckCast(r3, kotlinx.coroutines.internal.x.class, "com.obric.aiagent.plugin"));
        }

        /* JADX INFO: renamed from: a, reason: avoid collision after fix types in other method */
        public Object a2(kotlinx.coroutines.internal.x r1) {
            if (this.f39198a.n() != this.f39199b) goto L5;
            boolean r0 = true;
        L6:
            if (r0 == false) goto L9;
            return null;
        L9:
            return kotlinx.coroutines.internal.w.a();
        L5:
            r0 = false;
            goto L6
        }
    }

    /* JADX INFO: compiled from: JobSupport.kt */
    /* synthetic */ class f extends d.h.b.l implements d.h.a.q<ci, kotlinx.coroutines.e.j<?>, Object, d.x> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final f f39200a = null;

        static {
            f39200a = new f();
        }

        f() {
            super(3, ci.class, "onAwaitInternalRegFunc", "onAwaitInternalRegFunc(Lkotlinx/coroutines/selects/SelectInstance;Ljava/lang/Object;)V", 0);
        }

        public final void a(ci r2, kotlinx.coroutines.e.j<?> r3, Object r4) {
            ci.a(r2, (kotlinx.coroutines.e.j) ZeusTransformUtils.wrapperContextForParams(r3, kotlinx.coroutines.e.j.class, "com.obric.aiagent.plugin"), r4);
        }

        @Override // d.h.a.q
        public /* synthetic */ d.x invoke(ci r3, kotlinx.coroutines.e.j<?> r4, Object r5) {
            a((ci) ZeusTransformUtils.preCheckCast(r3, ci.class, "com.obric.aiagent.plugin"), (kotlinx.coroutines.e.j) ZeusTransformUtils.preCheckCast(r4, kotlinx.coroutines.e.j.class, "com.obric.aiagent.plugin"), r5);
            return d.x.f38692a;
        }
    }

    /* JADX INFO: compiled from: JobSupport.kt */
    /* synthetic */ class g extends d.h.b.l implements d.h.a.q<ci, Object, Object, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final g f39201a = null;

        static {
            f39201a = new g();
        }

        g() {
            super(3, ci.class, "onAwaitInternalProcessResFunc", "onAwaitInternalProcessResFunc(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;", 0);
        }

        public final Object a(ci r1, Object r2, Object r3) {
            return ci.a(r1, r2, r3);
        }

        @Override // d.h.a.q
        public /* synthetic */ Object invoke(ci r3, Object r4, Object r5) {
            return a((ci) ZeusTransformUtils.preCheckCast(r3, ci.class, "com.obric.aiagent.plugin"), r4, r5);
        }
    }

    static {
        f39185b = AtomicReferenceFieldUpdater.newUpdater(ci.class, Object.class, "_state$volatile");
        f39186c = AtomicReferenceFieldUpdater.newUpdater(ci.class, Object.class, "_parentHandle$volatile");
    }

    private static final /* synthetic */ AtomicReferenceFieldUpdater t() {
        return f39185b;
    }

    private static final /* synthetic */ AtomicReferenceFieldUpdater u() {
        return f39186c;
    }

    public void b(Object r1) {
    }

    public String c() {
        return "Job was cancelled";
    }

    public void d(Object r1) {
    }

    public void e(Throwable r1) {
    }

    public boolean e() {
        return false;
    }

    public boolean f(Throwable r1) {
        return false;
    }

    public boolean m_() {
        return false;
    }

    public void o() {
    }

    public boolean q_() {
        return true;
    }

    public ci(boolean r1) {
        if (r1 == false) goto L5;
        bi r2 = cj.a();
    L6:
        this._state$volatile = r2;
        return;
    L5:
        r2 = cj.b();
        goto L6
    }

    public static final /* synthetic */ Object a(ci r0, Object r1, Object r2) {
        return r0.b(r1, r2);
    }

    public static final /* synthetic */ String a(ci r0) {
        return r0.c();
    }

    public static final /* synthetic */ void a(ci r0, c r1, u r2, Object r3) {
        r0.b(r1, r2, r3);
    }

    public static final /* synthetic */ void a(ci r2, kotlinx.coroutines.e.j r3, Object r4) {
        r2.a((kotlinx.coroutines.e.j) ZeusTransformUtils.wrapperContextForParams(r3, kotlinx.coroutines.e.j.class, "com.obric.aiagent.plugin"), r4);
    }

    @Override // d.c.g
    public <R> R fold(R r3, d.h.a.m<? super R, ? super d.c.g.b, ? extends R> r4) {
        return (R) ca.a.a(this, r3, (d.h.a.m) ZeusTransformUtils.wrapperContextForParams(r4, d.h.a.m.class, "com.obric.aiagent.plugin"));
    }

    @Override // d.c.g.b, d.c.g
    public <E extends d.c.g.b> E get(d.c.g.c<E> r3) {
        return (E) ca.a.a(this, (d.c.g.c) ZeusTransformUtils.wrapperContextForParams(r3, d.c.g.c.class, "com.obric.aiagent.plugin"));
    }

    @Override // d.c.g
    public d.c.g minusKey(d.c.g.c<?> r3) {
        return ca.a.b(this, (d.c.g.c) ZeusTransformUtils.wrapperContextForParams(r3, d.c.g.c.class, "com.obric.aiagent.plugin"));
    }

    @Override // d.c.g
    public d.c.g plus(d.c.g r3) {
        return ca.a.a(this, (d.c.g) ZeusTransformUtils.wrapperContextForParams(r3, d.c.g.class, "com.obric.aiagent.plugin"));
    }

    @Override // d.c.g.b
    public final d.c.g.c<?> getKey() {
        return (d.c.g.c) ZeusTransformUtils.preCheckCast(ca.f39180a, d.c.g.c.class, "com.obric.aiagent.plugin");
    }

    public final t m() {
        return (t) ZeusTransformUtils.preCheckCast(u().get(this), t.class, "com.obric.aiagent.plugin");
    }

    public final void a(t r3) {
        t r4 = (t) ZeusTransformUtils.wrapperContextForParams(r3, t.class, "com.obric.aiagent.plugin");
        u().set(this, r4);
    }

    @Override // kotlinx.coroutines.ca
    public ca h() {
        t r0 = m();
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.a();
    }

    public final void a(ca r3) {
        ca r4 = (ca) ZeusTransformUtils.wrapperContextForParams(r3, ca.class, "com.obric.aiagent.plugin");
        if (aq.a() == true) goto L5;
    L12:
        if (r4 != null) goto L15;
        a((t) ZeusTransformUtils.preCheckCast(cp.f39210a, t.class, "com.obric.aiagent.plugin"));
        return;
    L15:
        r4.s_();
        t r5 = r4.a((v) ZeusTransformUtils.preCheckCast(this, v.class, "com.obric.aiagent.plugin"));
        a(r5);
        if (i() == false) goto L19;
        r5.dispose();
        a((t) ZeusTransformUtils.preCheckCast(cp.f39210a, t.class, "com.obric.aiagent.plugin"));
        return;
    L19:
        return;
    L5:
        if (m() != null) goto L7;
        boolean r0 = true;
    L8:
        if (r0 == true) goto L12;
        throw new AssertionError();
    L7:
        r0 = false;
        goto L8
    }

    public final Object n() {
        AtomicReferenceFieldUpdater r0 = t();
    L3:
        Object r1 = r0.get(this);
        if (ZeusTransformUtils.instanceOf(r1, kotlinx.coroutines.internal.ae.class) == false) goto L5;
        ((kotlinx.coroutines.internal.ae) ZeusTransformUtils.preCheckCast(r1, kotlinx.coroutines.internal.ae.class, "com.obric.aiagent.plugin")).b(this);
        goto L3
    L5:
        return r1;
    }

    @Override // kotlinx.coroutines.ca
    public boolean b() {
        Object r2 = n();
        if (ZeusTransformUtils.instanceOf(r2, bu.class) == true) goto L5;
    L7:
        return false;
    L5:
        if (((bu) ZeusTransformUtils.preCheckCast(r2, bu.class, "com.obric.aiagent.plugin")).n_() == false) goto L7;
        return true;
    }

    @Override // kotlinx.coroutines.ca
    public final boolean i() {
        return !ZeusTransformUtils.instanceOf(n(), bu.class);
    }

    @Override // kotlinx.coroutines.ca
    public final boolean j() {
        Object r2 = n();
        if (ZeusTransformUtils.instanceOf(r2, ab.class) == false) goto L5;
    L10:
        return true;
    L5:
        if (ZeusTransformUtils.instanceOf(r2, c.class) == true) goto L7;
    L9:
        return false;
    L7:
        if (((c) ZeusTransformUtils.preCheckCast(r2, c.class, "com.obric.aiagent.plugin")).f() == false) goto L9;
        goto L9
    }

    private final Object a(c r8, Object r9) {
        boolean r1 = true;
        if (aq.a() == false) goto L13;
        if (n() != r8) goto L7;
        boolean r0 = true;
    L8:
        if (r0 == true) goto L13;
        throw new AssertionError();
    L7:
        r0 = false;
    L13:
        if (aq.a() == false) goto L20;
        if ((!r8.e()) == true) goto L20;
        throw new AssertionError();
    L20:
        if (aq.a() == false) goto L27;
        if (r8.c() == true) goto L27;
        throw new AssertionError();
    L27:
        if (ZeusTransformUtils.instanceOf(r9, ab.class) == false) goto L29;
        ab r2 = (ab) ZeusTransformUtils.preCheckCast(r9, ab.class, "com.obric.aiagent.plugin");
    L30:
        if (r2 == null) goto L32;
        Throwable r3 = r2.f38830a;
    L33:
        monitor-enter(r8);
        boolean r4 = r8.f();     // Catch: Throwable -> L62
        List<Throwable> r5 = r8.b(r3);     // Catch: Throwable -> L62
        Throwable r6 = a(r8, r5);     // Catch: Throwable -> L62
        if (r6 == null) goto L37;
        a(r6, r5);     // Catch: Throwable -> L62
    L37:
        monitor-exit(r8);
        if (r6 == null) goto L43;
        if (r6 == r3) goto L43;
        r9 = new ab(r6, false, 2, null);
    L43:
        if (r6 != null) goto L45;
    L52:
        if (r4 == true) goto L54;
        e(r6);
    L54:
        b(r9);
        boolean r7 = t().compareAndSet(this, r8, cj.a(r9));
        if (aq.a() == false) goto L60;
        if (r7 == true) goto L60;
        throw new AssertionError();
    L60:
        b((bu) ZeusTransformUtils.preCheckCast(r8, bu.class, "com.obric.aiagent.plugin"), r9);
        return r9;
    L45:
        if (g(r6) == false) goto L47;
    L50:
        if (r1 == false) goto L52;
        d.h.b.o.a(r9, "null cannot be cast to non-null type kotlinx.coroutines.CompletedExceptionally");
        ((ab) ZeusTransformUtils.preCheckCast(r9, ab.class, "com.obric.aiagent.plugin")).c();
        goto L52
    L47:
        if (f(r6) == true) goto L50;
        r1 = false;
    L62:
        th = move-exception;
        throw th;
    L32:
        r3 = null;
        goto L33
    L29:
        r2 = null;
        goto L30
    }

    private final Throwable a(c r7, List<? extends Throwable> r8) {
        List r9 = (List) ZeusTransformUtils.wrapperContextForParams(r8, List.class, "com.obric.aiagent.plugin");
        Object r2 = null;
        if (r9.isEmpty() == true) goto L5;
        Iterator r6 = ((Iterable) ZeusTransformUtils.preCheckCast(r9, Iterable.class, "com.obric.aiagent.plugin")).iterator();
    L11:
        if (r6.hasNext() == false) goto L15;
        Object r10 = r6.next();
        if ((!ZeusTransformUtils.instanceOf((Throwable) ZeusTransformUtils.preCheckCast(r10, Throwable.class, "com.obric.aiagent.plugin"), CancellationException.class)) == false) goto L11;
    L16:
        Throwable r11 = (Throwable) ZeusTransformUtils.preCheckCast(r10, Throwable.class, "com.obric.aiagent.plugin");
        if (r11 == null) goto L19;
        return r11;
    L19:
        Throwable r12 = (Throwable) ZeusTransformUtils.preCheckCast(r9.get(0), Throwable.class, "com.obric.aiagent.plugin");
        if (ZeusTransformUtils.instanceOf(r12, de.class) == false) goto L35;
        Iterator r13 = ((Iterable) ZeusTransformUtils.preCheckCast(r9, Iterable.class, "com.obric.aiagent.plugin")).iterator();
    L23:
        if (r13.hasNext() == false) goto L32;
        Object r3 = r13.next();
        Throwable r4 = (Throwable) ZeusTransformUtils.preCheckCast(r3, Throwable.class, "com.obric.aiagent.plugin");
        if (r4 != r12) goto L27;
    L29:
        boolean r5 = false;
    L30:
        if (r5 == false) goto L23;
        r2 = r3;
        goto L32
    L27:
        if (ZeusTransformUtils.instanceOf(r4, de.class) == false) goto L29;
        r5 = true;
    L32:
        Throwable r14 = (Throwable) ZeusTransformUtils.preCheckCast(r2, Throwable.class, "com.obric.aiagent.plugin");
        if (r14 == null) goto L35;
        return r14;
    L35:
        return r12;
    L15:
        r10 = null;
        goto L16
    L5:
        if (r7.f() == true) goto L7;
        return null;
    L7:
        return (Throwable) ZeusTransformUtils.preCheckCast(new cb(a(this), null, (ca) ZeusTransformUtils.preCheckCast(this, ca.class, "com.obric.aiagent.plugin")), Throwable.class, "com.obric.aiagent.plugin");
    }

    private final void a(Throwable r5, List<? extends Throwable> r6) {
        List r4 = (List) ZeusTransformUtils.wrapperContextForParams(r6, List.class, "com.obric.aiagent.plugin");
        if (r4.size() > 1) goto L5;
        return;
    L5:
        Set r7 = Collections.newSetFromMap((Map) ZeusTransformUtils.preCheckCast(new IdentityHashMap(r4.size()), Map.class, "com.obric.aiagent.plugin"));
        if (aq.c() == true) goto L8;
        Throwable r1 = r5;
    L9:
        Iterator r8 = r4.iterator();
    L11:
        if (r8.hasNext() == false) goto L23;
        Throwable r2 = (Throwable) ZeusTransformUtils.preCheckCast(r8.next(), Throwable.class, "com.obric.aiagent.plugin");
        if (aq.c() == false) goto L16;
        r2 = kotlinx.coroutines.internal.ak.b(r2);
    L16:
        if (r2 == r5) goto L11;
        if (r2 == r1) goto L11;
        if (ZeusTransformUtils.instanceOf(r2, CancellationException.class) == true) goto L11;
        if (r7.add(r2) == false) goto L11;
        d.a.a(r5, r2);
        goto L11
    L23:
        return;
    L8:
        r1 = kotlinx.coroutines.internal.ak.b(r5);
        goto L9
    }

    private final boolean a(bu r5, Object r6) {
        bu r7 = (bu) ZeusTransformUtils.wrapperContextForParams(r5, bu.class, "com.obric.aiagent.plugin");
        if (aq.a() == false) goto L16;
        if (ZeusTransformUtils.instanceOf(r7, bi.class) == false) goto L7;
    L10:
        boolean r0 = true;
    L11:
        if (r0 == true) goto L16;
        throw new AssertionError();
    L7:
        if (ZeusTransformUtils.instanceOf(r7, ch.class) == true) goto L10;
        r0 = false;
    L16:
        if (aq.a() == false) goto L23;
        if ((!ZeusTransformUtils.instanceOf(r6, ab.class)) == true) goto L23;
        throw new AssertionError();
    L23:
        if (t().compareAndSet(this, r7, cj.a(r6)) == true) goto L25;
        return false;
    L25:
        e(null);
        b(r6);
        b(r7, r6);
        return true;
    }

    private final void b(bu r5, Object r6) {
        bu r7 = (bu) ZeusTransformUtils.wrapperContextForParams(r5, bu.class, "com.obric.aiagent.plugin");
        t r0 = m();
        if (r0 == null) goto L5;
        r0.dispose();
        a((t) ZeusTransformUtils.preCheckCast(cp.f39210a, t.class, "com.obric.aiagent.plugin"));
    L5:
        Throwable r2 = null;
        if (ZeusTransformUtils.instanceOf(r6, ab.class) == false) goto L8;
        ab r8 = (ab) ZeusTransformUtils.preCheckCast(r6, ab.class, "com.obric.aiagent.plugin");
    L9:
        if (r8 == null) goto L12;
        r2 = r8.f38830a;
    L12:
        if (ZeusTransformUtils.instanceOf(r7, ch.class) == true) goto L21;
        cn r9 = r7.o_();
        if (r9 == null) goto L24;
        b(r9, r2);
        return;
    L24:
        return;
    L21:
        ((ch) ZeusTransformUtils.preCheckCast(r7, ch.class, "com.obric.aiagent.plugin")).a(r2);     // Catch: Throwable -> L15
        return;
    L15:
        th = move-exception;
        a_((Throwable) ZeusTransformUtils.preCheckCast(new ad("Exception in completion handler " + r7 + " for " + this, th), Throwable.class, "com.obric.aiagent.plugin"));
        return;
    L8:
        r8 = null;
        goto L9
    }

    private final void a(cn r8, Throwable r9) {
        e(r9);
        kotlinx.coroutines.internal.v r10 = (kotlinx.coroutines.internal.v) ZeusTransformUtils.preCheckCast(r8, kotlinx.coroutines.internal.v.class, "com.obric.aiagent.plugin");
        Object r0 = r10.f();
        d.h.b.o.a(r0, "null cannot be cast to non-null type kotlinx.coroutines.internal.LockFreeLinkedListNode{ kotlinx.coroutines.internal.LockFreeLinkedListKt.Node }");
        kotlinx.coroutines.internal.x r1 = (kotlinx.coroutines.internal.x) ZeusTransformUtils.preCheckCast(r0, kotlinx.coroutines.internal.x.class, "com.obric.aiagent.plugin");
        ad r2 = null;
    L4:
        if (d.h.b.o.a(r1, r10) == true) goto L17;
        if (ZeusTransformUtils.instanceOf(r1, cc.class) == false) goto L16;
        ch r3 = (ch) ZeusTransformUtils.preCheckCast(r1, ch.class, "com.obric.aiagent.plugin");
        r3.a(r9);     // Catch: Throwable -> L10
    L10:
        th = move-exception;
        Throwable r5 = (Throwable) ZeusTransformUtils.preCheckCast(r2, Throwable.class, "com.obric.aiagent.plugin");
        if (r5 == null) goto L15;
        d.a.a(r5, th);
        if (r5 != null) goto L16;
    L15:
        r2 = new ad("Exception in completion handler " + r3 + " for " + this, th);
        d.x r4 = d.x.f38692a;
    L16:
        r1 = r1.g();
        goto L4
    L17:
        Throwable r11 = (Throwable) ZeusTransformUtils.preCheckCast(r2, Throwable.class, "com.obric.aiagent.plugin");
        if (r11 == null) goto L20;
        a_(r11);
    L20:
        g(r9);
    }

    private final boolean g(Throwable r4) {
        if (e() == false) goto L5;
        return true;
    L5:
        boolean r0 = ZeusTransformUtils.instanceOf(r4, CancellationException.class);
        t r3 = m();
        if (r3 != null) goto L8;
    L16:
        return r0;
    L8:
        if (r3 == cp.f39210a) goto L16;
        if (r3.b(r4) == true) goto L17;
        if (r0 == true) goto L18;
        return false;
    L18:
        return true;
    L17:
        return true;
    }

    private final int a(Object r6) {
        if (ZeusTransformUtils.instanceOf(r6, bi.class) == false) goto L13;
        if (((bi) ZeusTransformUtils.preCheckCast(r6, bi.class, "com.obric.aiagent.plugin")).n_() == false) goto L8;
        return 0;
    L8:
        if (t().compareAndSet(this, r6, cj.a()) == true) goto L10;
        return -1;
    L10:
        o();
        return 1;
    L13:
        if (ZeusTransformUtils.instanceOf(r6, bt.class) == true) goto L15;
        return 0;
    L15:
        if (t().compareAndSet(this, r6, ((bt) ZeusTransformUtils.preCheckCast(r6, bt.class, "com.obric.aiagent.plugin")).o_()) == true) goto L17;
        return -1;
    L17:
        o();
        return 1;
    }

    @Override // kotlinx.coroutines.ca
    public final CancellationException k() {
        Object r0 = n();
        if (ZeusTransformUtils.instanceOf(r0, c.class) == false) goto L12;
        Throwable r1 = ((c) ZeusTransformUtils.preCheckCast(r0, c.class, "com.obric.aiagent.plugin")).d();
        if (r1 == null) goto L10;
        CancellationException r2 = a(r1, ar.b(this) + " is cancelling");
        if (r2 == null) goto L10;
        return r2;
    L10:
        throw new IllegalStateException(("Job is still new or active: " + this).toString());
    L12:
        if (ZeusTransformUtils.instanceOf(r0, bu.class) == true) goto L19;
        if (ZeusTransformUtils.instanceOf(r0, ab.class) == false) goto L17;
        return a(this, ((ab) ZeusTransformUtils.preCheckCast(r0, ab.class, "com.obric.aiagent.plugin")).f38830a, null, 1, null);
    L17:
        return (CancellationException) ZeusTransformUtils.preCheckCast(new cb(ar.b(this) + " has completed normally", null, (ca) ZeusTransformUtils.preCheckCast(this, ca.class, "com.obric.aiagent.plugin")), CancellationException.class, "com.obric.aiagent.plugin");
    L19:
        throw new IllegalStateException(("Job is still new or active: " + this).toString());
    }

    public static /* synthetic */ CancellationException a(ci r0, Throwable r1, String r2, int r3, Object r4) {
        if (r4 != null) goto L9;
        if ((r3 & 1) == 0) goto L7;
        r2 = null;
    L7:
        return r0.a(r1, r2);
    L9:
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: toCancellationException");
    }

    public final CancellationException a(Throwable r4, String r5) {
        if (ZeusTransformUtils.instanceOf(r4, CancellationException.class) == false) goto L5;
        CancellationException r0 = (CancellationException) ZeusTransformUtils.preCheckCast(r4, CancellationException.class, "com.obric.aiagent.plugin");
    L6:
        if (r0 == null) goto L8;
        return r0;
    L8:
        if (r5 != null) goto L11;
        r5 = a(this);
    L11:
        return (CancellationException) ZeusTransformUtils.preCheckCast(new cb(r5, r4, (ca) ZeusTransformUtils.preCheckCast(this, ca.class, "com.obric.aiagent.plugin")), CancellationException.class, "com.obric.aiagent.plugin");
    L5:
        r0 = null;
        goto L6
    }

    @Override // kotlinx.coroutines.ca
    public final bf a_(d.h.a.b<? super Throwable, d.x> r3) {
        return a(false, true, (bw) ZeusTransformUtils.preCheckCast(new bw.a((d.h.a.b) ZeusTransformUtils.wrapperContextForParams(r3, d.h.a.b.class, "com.obric.aiagent.plugin")), bw.class, "com.obric.aiagent.plugin"));
    }

    @Override // kotlinx.coroutines.ca
    public final bf a(boolean r3, boolean r4, d.h.a.b<? super Throwable, d.x> r5) {
        return a(r3, r4, (bw) ZeusTransformUtils.preCheckCast(new bw.a((d.h.a.b) ZeusTransformUtils.wrapperContextForParams(r5, d.h.a.b.class, "com.obric.aiagent.plugin")), bw.class, "com.obric.aiagent.plugin"));
    }

    public final bf a(boolean r8, boolean r9, bw r10) {
        bw r11 = (bw) ZeusTransformUtils.wrapperContextForParams(r10, bw.class, "com.obric.aiagent.plugin");
        ch r0 = a(r11, r8);
    L3:
        Object r1 = n();
        if (ZeusTransformUtils.instanceOf(r1, bi.class) == true) goto L6;
        Throwable r3 = null;
        if (ZeusTransformUtils.instanceOf(r1, bu.class) == false) goto L52;
        cn r2 = ((bu) ZeusTransformUtils.preCheckCast(r1, bu.class, "com.obric.aiagent.plugin")).o_();
        if (r2 == null) goto L16;
        Object r4 = cp.f39210a;
        if (r8 == false) goto L43;
        if (ZeusTransformUtils.instanceOf(r1, c.class) == false) goto L43;
        monitor-enter(r1);
        r3 = ((c) ZeusTransformUtils.preCheckCast(r1, c.class, "com.obric.aiagent.plugin")).d();     // Catch: Throwable -> L40
        if (r3 == null) goto L29;
        if (ZeusTransformUtils.instanceOf(r11, u.class) == false) goto L37;
        if (((c) ZeusTransformUtils.preCheckCast(r1, c.class, "com.obric.aiagent.plugin")).c() == false) goto L29;
    L37:
        d.x r5 = d.x.f38692a;     // Catch: Throwable -> L40
        monitor-exit(r1);
    L29:
        if (a(r1, r2, r0) == false) goto L30;
        if (r3 == null) goto L33;
        r4 = r0;
        goto L37
    L33:
        bf r7 = (bf) ZeusTransformUtils.preCheckCast(r0, bf.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L40
        monitor-exit(r1);
        return r7;
    L30:
        monitor-exit(r1);
    L40:
        th = move-exception;
        throw th;
    L43:
        if (r3 != null) goto L44;
        if (a(r1, r2, r0) == false) goto L3;
        return (bf) ZeusTransformUtils.preCheckCast(r0, bf.class, "com.obric.aiagent.plugin");
    L44:
        if (r9 == false) goto L47;
        r11.a(r3);
    L47:
        return (bf) ZeusTransformUtils.preCheckCast(r4, bf.class, "com.obric.aiagent.plugin");
    L16:
        d.h.b.o.a(r1, "null cannot be cast to non-null type kotlinx.coroutines.JobNode");
        b((ch) ZeusTransformUtils.preCheckCast(r1, ch.class, "com.obric.aiagent.plugin"));
        goto L3
    L52:
        if (r9 == false) goto L61;
        if (ZeusTransformUtils.instanceOf(r1, ab.class) == false) goto L56;
        ab r12 = (ab) ZeusTransformUtils.preCheckCast(r1, ab.class, "com.obric.aiagent.plugin");
    L57:
        if (r12 == null) goto L59;
        r3 = r12.f38830a;
    L59:
        r11.a(r3);
        goto L61
    L56:
        r12 = null;
    L61:
        return (bf) ZeusTransformUtils.preCheckCast(cp.f39210a, bf.class, "com.obric.aiagent.plugin");
    L6:
        if (((bi) ZeusTransformUtils.preCheckCast(r1, bi.class, "com.obric.aiagent.plugin")).n_() == true) goto L8;
        a((bi) ZeusTransformUtils.preCheckCast(r1, bi.class, "com.obric.aiagent.plugin"));
        goto L3
    L8:
        if (t().compareAndSet(this, r1, r0) == false) goto L3;
        return (bf) ZeusTransformUtils.preCheckCast(r0, bf.class, "com.obric.aiagent.plugin");
    }

    private final ch a(bw r3, boolean r4) {
        bw r5 = (bw) ZeusTransformUtils.wrapperContextForParams(r3, bw.class, "com.obric.aiagent.plugin");
        ch r0 = null;
        if (r4 == false) goto L11;
        if (ZeusTransformUtils.instanceOf(r5, cc.class) == false) goto L7;
        r0 = (cc) ZeusTransformUtils.preCheckCast(r5, cc.class, "com.obric.aiagent.plugin");
    L7:
        if (r0 != null) goto L9;
        r0 = (cc) ZeusTransformUtils.preCheckCast(new by(r5), cc.class, "com.obric.aiagent.plugin");
    L9:
        ch r6 = (ch) ZeusTransformUtils.preCheckCast(r0, ch.class, "com.obric.aiagent.plugin");
    L23:
        r6.a(this);
        return r6;
    L11:
        if (ZeusTransformUtils.instanceOf(r5, ch.class) == false) goto L13;
        r0 = (ch) ZeusTransformUtils.preCheckCast(r5, ch.class, "com.obric.aiagent.plugin");
    L13:
        if (r0 != null) goto L15;
        r6 = (ch) ZeusTransformUtils.preCheckCast(new bz(r5), ch.class, "com.obric.aiagent.plugin");
        goto L23
    L15:
        if (aq.a() == true) goto L17;
    L21:
        r6 = r0;
        goto L23
    L17:
        if ((!ZeusTransformUtils.instanceOf(r0, cc.class)) == true) goto L21;
        throw new AssertionError();
    }

    private final boolean a(Object r4, cn r5, ch r6) {
        kotlinx.coroutines.internal.x r7 = (kotlinx.coroutines.internal.x) ZeusTransformUtils.preCheckCast(r5, kotlinx.coroutines.internal.x.class, "com.obric.aiagent.plugin");
        kotlinx.coroutines.internal.x.a r3 = (kotlinx.coroutines.internal.x.a) ZeusTransformUtils.preCheckCast(new e((kotlinx.coroutines.internal.x) ZeusTransformUtils.preCheckCast(r6, kotlinx.coroutines.internal.x.class, "com.obric.aiagent.plugin"), this, r4), kotlinx.coroutines.internal.x.a.class, "com.obric.aiagent.plugin");
    L3:
        int r8 = r7.h().a((kotlinx.coroutines.internal.x) ZeusTransformUtils.preCheckCast(r6, kotlinx.coroutines.internal.x.class, "com.obric.aiagent.plugin"), r7, r3);
        if (r8 == 1) goto L13;
        if (r8 != 2) goto L3;
        return false;
    L13:
        return true;
    }

    private final void a(bi r4) {
        cn r0 = new cn();
        if (r4.n_() == false) goto L5;
        Object r1 = ZeusTransformUtils.preCheckCast(r0, bu.class, "com.obric.aiagent.plugin");
    L6:
        AtomicReferenceFieldUpdater r2 = t();
        r2.compareAndSet(this, r4, (bu) r1);
        return;
    L5:
        r1 = ZeusTransformUtils.preCheckCast(new bt(r0), bu.class, "com.obric.aiagent.plugin");
        goto L6
    }

    private final void b(ch r4) {
        r4.a((kotlinx.coroutines.internal.x) ZeusTransformUtils.preCheckCast(new cn(), kotlinx.coroutines.internal.x.class, "com.obric.aiagent.plugin"));
        kotlinx.coroutines.internal.x r0 = r4.g();
        t().compareAndSet(this, r4, r0);
    }

    @Override // kotlinx.coroutines.ca
    public final Object b(d.c.d<? super d.x> r3) {
        d.c.d<? super d.x> r4 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r3, d.c.d.class, "com.obric.aiagent.plugin");
        if (g() == true) goto L6;
        ce.b(r4.getContext());
        return d.x.f38692a;
    L6:
        Object r2 = a(r4);
        if (r2 != d.c.a.b.a()) goto L10;
        return r2;
    L10:
        return d.x.f38692a;
    }

    public void b(Throwable r1) {
        e(r1);
    }

    @Override // kotlinx.coroutines.v
    public final void a(cr r3) {
        e((cr) ZeusTransformUtils.wrapperContextForParams(r3, cr.class, "com.obric.aiagent.plugin"));
    }

    public boolean c(Throwable r3) {
        if (ZeusTransformUtils.instanceOf(r3, CancellationException.class) == false) goto L6;
        return true;
    L6:
        if (e(r3) == true) goto L8;
    L10:
        return false;
    L8:
        if (q_() == false) goto L10;
        return true;
    }

    public final boolean d(Throwable r1) {
        return e(r1);
    }

    public final boolean e(Object r4) {
        Object r0 = cj.c();
        if (m_() == false) goto L8;
        r0 = c(r4);
        if (r0 != cj.f39202a) goto L8;
        return true;
    L8:
        if (r0 != cj.c()) goto L11;
        r0 = i(r4);
    L11:
        if (r0 != cj.c()) goto L14;
        return true;
    L14:
        if (r0 != cj.f39202a) goto L17;
        return true;
    L17:
        if (r0 != cj.d()) goto L19;
        return false;
    L19:
        d(r0);
        return true;
    }

    @Override // kotlinx.coroutines.cr
    public CancellationException p() {
        Object r0 = n();
        CancellationException r2 = null;
        if (ZeusTransformUtils.instanceOf(r0, c.class) == false) goto L6;
        Throwable r1 = ((c) ZeusTransformUtils.preCheckCast(r0, c.class, "com.obric.aiagent.plugin")).d();
    L12:
        if (ZeusTransformUtils.instanceOf(r1, CancellationException.class) == false) goto L14;
        r2 = (CancellationException) ZeusTransformUtils.preCheckCast(r1, CancellationException.class, "com.obric.aiagent.plugin");
    L14:
        if (r2 == null) goto L16;
        return r2;
    L16:
        return (CancellationException) ZeusTransformUtils.preCheckCast(new cb("Parent job is " + k(r0), r1, (ca) ZeusTransformUtils.preCheckCast(this, ca.class, "com.obric.aiagent.plugin")), CancellationException.class, "com.obric.aiagent.plugin");
    L6:
        if (ZeusTransformUtils.instanceOf(r0, ab.class) == false) goto L9;
        r1 = ((ab) ZeusTransformUtils.preCheckCast(r0, ab.class, "com.obric.aiagent.plugin")).f38830a;
        goto L12
    L9:
        if (ZeusTransformUtils.instanceOf(r0, bu.class) == true) goto L18;
        r1 = null;
        goto L12
    L18:
        throw new IllegalStateException(("Cannot be cancelling child in this state: " + r0).toString());
    }

    private final Throwable h(Object r5) {
        if (r5 != null) goto L4;
        boolean r0 = true;
    L6:
        if (r0 == false) goto L10;
        Throwable r6 = (Throwable) ZeusTransformUtils.preCheckCast(r5, Throwable.class, "com.obric.aiagent.plugin");
        if (r6 == null) goto L13;
        return r6;
    L13:
        return (Throwable) ZeusTransformUtils.preCheckCast(new cb(a(this), null, (ca) ZeusTransformUtils.preCheckCast(this, ca.class, "com.obric.aiagent.plugin")), Throwable.class, "com.obric.aiagent.plugin");
    L10:
        d.h.b.o.a(r5, "null cannot be cast to non-null type kotlinx.coroutines.ParentJob");
        return (Throwable) ZeusTransformUtils.preCheckCast(((cr) ZeusTransformUtils.preCheckCast(r5, cr.class, "com.obric.aiagent.plugin")).p(), Throwable.class, "com.obric.aiagent.plugin");
    L4:
        r0 = ZeusTransformUtils.instanceOf(r5, Throwable.class);
        goto L6
    }

    private final cn a(bu r3) {
        bu r4 = (bu) ZeusTransformUtils.wrapperContextForParams(r3, bu.class, "com.obric.aiagent.plugin");
        cn r0 = r4.o_();
        if (r0 == null) goto L5;
        return r0;
    L5:
        if (ZeusTransformUtils.instanceOf(r4, bi.class) == false) goto L8;
        return new cn();
    L8:
        if (ZeusTransformUtils.instanceOf(r4, ch.class) == false) goto L11;
        b((ch) ZeusTransformUtils.preCheckCast(r4, ch.class, "com.obric.aiagent.plugin"));
        return null;
    L11:
        throw new IllegalStateException(("State should have list: " + r4).toString());
    }

    private final boolean a(bu r6, Throwable r7) {
        bu r8 = (bu) ZeusTransformUtils.wrapperContextForParams(r6, bu.class, "com.obric.aiagent.plugin");
        if (aq.a() == false) goto L10;
        if ((!ZeusTransformUtils.instanceOf(r8, c.class)) == true) goto L10;
        throw new AssertionError();
    L10:
        if (aq.a() == true) goto L12;
    L16:
        cn r0 = a(r8);
        if (r0 != null) goto L20;
        return false;
    L20:
        if (t().compareAndSet(this, r8, new c(r0, false, r7)) == true) goto L22;
        return false;
    L22:
        a(r0, r7);
        return true;
    L12:
        if (r8.n_() == true) goto L16;
        throw new AssertionError();
    }

    private final Object a(Object r3, Object r4) {
        if (ZeusTransformUtils.instanceOf(r3, bu.class) == true) goto L7;
        return cj.c();
    L7:
        if (ZeusTransformUtils.instanceOf(r3, bi.class) == true) goto L11;
        if (ZeusTransformUtils.instanceOf(r3, ch.class) == true) goto L11;
    L20:
        return c((bu) ZeusTransformUtils.preCheckCast(r3, bu.class, "com.obric.aiagent.plugin"), r4);
    L11:
        if (ZeusTransformUtils.instanceOf(r3, u.class) == true) goto L20;
        if (ZeusTransformUtils.instanceOf(r4, ab.class) == true) goto L20;
        if (a((bu) ZeusTransformUtils.preCheckCast(r3, bu.class, "com.obric.aiagent.plugin"), r4) == false) goto L18;
        return r4;
    L18:
        return cj.e();
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final Object c(bu r10, Object r11) {
        bu r12 = (bu) ZeusTransformUtils.wrapperContextForParams(r10, bu.class, "com.obric.aiagent.plugin");
        cn r0 = a(r12);
        if (r0 == null) goto L5;
        T r2 = 0;
        if (ZeusTransformUtils.instanceOf(r12, c.class) == false) goto L9;
        c r1 = (c) ZeusTransformUtils.preCheckCast(r12, c.class, "com.obric.aiagent.plugin");
    L10:
        boolean r3 = false;
        if (r1 != null) goto L13;
        r1 = new c(r0, false, null);
    L13:
        d.h.b.z.f r4 = new d.h.b.z.f();
        monitor-enter(r1);
    L60:
        th = move-exception;
        throw th;
    L16:
        if (r1.c() == false) goto L21;
        kotlinx.coroutines.internal.al r9 = cj.c();     // Catch: Throwable -> L60
        monitor-exit(r1);
        return r9;
    L21:
        r1.a(true);     // Catch: Throwable -> L60
        if (r1 == r12) goto L29;
        if (t().compareAndSet(this, r12, r1) == true) goto L29;
        kotlinx.coroutines.internal.al r13 = cj.e();     // Catch: Throwable -> L60
        monitor-exit(r1);
        return r13;
    L29:
        if (aq.a() == true) goto L31;
    L35:
        boolean r6 = r1.f();     // Catch: Throwable -> L60
        if (ZeusTransformUtils.instanceOf(r11, ab.class) == false) goto L38;
        ab r7 = (ab) ZeusTransformUtils.preCheckCast(r11, ab.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L60
    L39:
        if (r7 == null) goto L41;
        r1.c(r7.f38830a);     // Catch: Throwable -> L60
    L41:
        Throwable r8 = r1.d();     // Catch: Throwable -> L60
        if (r6 == true) goto L45;
        r3 = true;
    L45:
        if (Boolean.valueOf(r3).booleanValue() == false) goto L47;
        r2 = r8;
    L47:
        r4.f38504a = r2;     // Catch: Throwable -> L60
        d.x r5 = d.x.f38692a;     // Catch: Throwable -> L60
        monitor-exit(r1);
        Throwable r14 = (Throwable) ZeusTransformUtils.preCheckCast(r4.f38504a, Throwable.class, "com.obric.aiagent.plugin");
        if (r14 == null) goto L52;
        a(r0, r14);
    L52:
        u r15 = b(r12);
        if (r15 == null) goto L59;
        if (a(r1, r15, r11) == false) goto L59;
        return cj.f39202a;
    L59:
        return a(r1, r11);
    L38:
        r7 = null;
        goto L39
    L31:
        if ((!r1.e()) == true) goto L35;
        throw new AssertionError();     // Catch: Throwable -> L60
    L9:
        r1 = null;
        goto L10
    L5:
        return cj.e();
    }

    private final Throwable j(Object r3) {
        if (ZeusTransformUtils.instanceOf(r3, ab.class) == false) goto L5;
        ab r2 = (ab) ZeusTransformUtils.preCheckCast(r3, ab.class, "com.obric.aiagent.plugin");
    L6:
        if (r2 != null) goto L8;
        return null;
    L8:
        return r2.f38830a;
    L5:
        r2 = null;
        goto L6
    }

    private final u b(bu r4) {
        bu r5 = (bu) ZeusTransformUtils.wrapperContextForParams(r4, bu.class, "com.obric.aiagent.plugin");
        if (ZeusTransformUtils.instanceOf(r5, u.class) == false) goto L5;
        u r0 = (u) ZeusTransformUtils.preCheckCast(r5, u.class, "com.obric.aiagent.plugin");
    L6:
        if (r0 != null) goto L11;
        cn r6 = r5.o_();
        if (r6 != null) goto L13;
        return null;
    L13:
        return a((kotlinx.coroutines.internal.x) ZeusTransformUtils.preCheckCast(r6, kotlinx.coroutines.internal.x.class, "com.obric.aiagent.plugin"));
    L11:
        return r0;
    L5:
        r0 = null;
        goto L6
    }

    private final boolean a(c r10, u r11, Object r12) {
    L3:
        if (ce.a((ca) ZeusTransformUtils.preCheckCast(r11.f39442a, ca.class, "com.obric.aiagent.plugin"), false, false, (bw) ZeusTransformUtils.preCheckCast(new b(this, r10, r11, r12), bw.class, "com.obric.aiagent.plugin"), 1, null) != cp.f39210a) goto L4;
        r11 = a((kotlinx.coroutines.internal.x) ZeusTransformUtils.preCheckCast(r11, kotlinx.coroutines.internal.x.class, "com.obric.aiagent.plugin"));
        if (r11 != null) goto L3;
        return false;
    L4:
        return true;
    }

    private final void b(c r3, u r4, Object r5) {
        if (aq.a() == true) goto L5;
    L12:
        u r6 = a((kotlinx.coroutines.internal.x) ZeusTransformUtils.preCheckCast(r4, kotlinx.coroutines.internal.x.class, "com.obric.aiagent.plugin"));
        if (r6 != null) goto L15;
    L17:
        d(a(r3, r5));
        return;
    L15:
        if (a(r3, r6, r5) == false) goto L17;
        return;
    L5:
        if (n() != r3) goto L7;
        boolean r0 = true;
    L8:
        if (r0 == true) goto L12;
        throw new AssertionError();
    L7:
        r0 = false;
        goto L8
    }

    private final u a(kotlinx.coroutines.internal.x r2) {
    L3:
        if (r2.d() == false) goto L5;
        r2 = r2.h();
    L5:
        r2 = r2.g();
        if (r2.d() == true) goto L5;
        if (ZeusTransformUtils.instanceOf(r2, u.class) == true) goto L10;
        if (ZeusTransformUtils.instanceOf(r2, cn.class) == false) goto L5;
        return null;
    L10:
        return (u) ZeusTransformUtils.preCheckCast(r2, u.class, "com.obric.aiagent.plugin");
    }

    @Override // kotlinx.coroutines.ca
    public final t a(v r9) {
        v r10 = (v) ZeusTransformUtils.wrapperContextForParams(r9, v.class, "com.obric.aiagent.plugin");
        bf r8 = ce.a((ca) ZeusTransformUtils.preCheckCast(this, ca.class, "com.obric.aiagent.plugin"), true, false, (bw) ZeusTransformUtils.preCheckCast(new u(r10), bw.class, "com.obric.aiagent.plugin"), 2, null);
        d.h.b.o.a(r8, "null cannot be cast to non-null type kotlinx.coroutines.ChildHandle");
        return (t) ZeusTransformUtils.preCheckCast(r8, t.class, "com.obric.aiagent.plugin");
    }

    public void a_(Throwable r1) {
        throw r1;
    }

    public String toString() {
        return q() + '@' + ar.a(this);
    }

    public final String q() {
        return d() + '{' + k(n()) + '}';
    }

    public String d() {
        return ar.b(this);
    }

    private final String k(Object r3) {
        if (ZeusTransformUtils.instanceOf(r3, c.class) == false) goto L11;
        if (((c) ZeusTransformUtils.preCheckCast(r3, c.class, "com.obric.aiagent.plugin")).f() == false) goto L8;
        return "Cancelling";
    L8:
        if (((c) ZeusTransformUtils.preCheckCast(r3, c.class, "com.obric.aiagent.plugin")).c() == false) goto L22;
        return "Completing";
    L22:
        return "Active";
    L11:
        if (ZeusTransformUtils.instanceOf(r3, bu.class) == false) goto L17;
        if (((bu) ZeusTransformUtils.preCheckCast(r3, bu.class, "com.obric.aiagent.plugin")).n_() == true) goto L26;
        return "New";
    L26:
        return "Active";
    L17:
        if (ZeusTransformUtils.instanceOf(r3, ab.class) == false) goto L19;
        return "Cancelled";
    L19:
        return "Completed";
    }

    public final Object r() {
        Object r2 = n();
        if ((!ZeusTransformUtils.instanceOf(r2, bu.class)) == false) goto L11;
        if (ZeusTransformUtils.instanceOf(r2, ab.class) == true) goto L9;
        return cj.b(r2);
    L9:
        throw ((ab) ZeusTransformUtils.preCheckCast(r2, ab.class, "com.obric.aiagent.plugin")).f38830a;
    L11:
        throw new IllegalStateException("This job has not completed yet".toString());
    }

    public final Object c(d.c.d<Object> r4) {
        d.c.d<Object> r5 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
    L3:
        Object r0 = n();
        if (ZeusTransformUtils.instanceOf(r0, bu.class) == false) goto L6;
        if (a(r0) < 0) goto L3;
        return d(r5);
    L6:
        if (ZeusTransformUtils.instanceOf(r0, ab.class) == false) goto L16;
        Throwable r3 = ((ab) ZeusTransformUtils.preCheckCast(r0, ab.class, "com.obric.aiagent.plugin")).f38830a;
        if (aq.c() == true) goto L10;
        throw r3;
    L10:
        if (ZeusTransformUtils.instanceOf(r5, d.c.b.a.e.class) == true) goto L13;
        throw r3;
    L13:
        throw kotlinx.coroutines.internal.ak.a(r3, (d.c.b.a.e) ZeusTransformUtils.preCheckCast(r5, d.c.b.a.e.class, "com.obric.aiagent.plugin"));
    L16:
        return cj.b(r0);
    }

    private final Object d(d.c.d<Object> r10) {
        d.c.d r11 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r10, d.c.d.class, "com.obric.aiagent.plugin");
        a r0 = new a(d.c.a.b.a(r11), this);
        r0.e();
        q.a((n) ZeusTransformUtils.preCheckCast(r0, n.class, "com.obric.aiagent.plugin"), ce.a((ca) ZeusTransformUtils.preCheckCast(this, ca.class, "com.obric.aiagent.plugin"), false, false, (bw) ZeusTransformUtils.preCheckCast(new cs((o) ZeusTransformUtils.preCheckCast(r0, o.class, "com.obric.aiagent.plugin")), bw.class, "com.obric.aiagent.plugin"), 3, null));
        Object r9 = r0.h();
        if (r9 != d.c.a.b.a()) goto L5;
        d.c.b.a.h.c(r11);
    L5:
        return r9;
    }

    public final kotlinx.coroutines.e.g<?> s() {
        f r0 = f.f39200a;
        d.h.b.o.a(r0, "null cannot be cast to non-null type kotlin.Function3<@[ParameterName(name = 'clauseObject')] kotlin.Any, @[ParameterName(name = 'select')] kotlinx.coroutines.selects.SelectInstance<*>, @[ParameterName(name = 'param')] kotlin.Any?, kotlin.Unit>{ kotlinx.coroutines.selects.SelectKt.RegistrationFunction }");
        d.h.a.q r2 = (d.h.a.q) ZeusTransformUtils.preCheckCast(d.h.b.ae.b(r0, 3), d.h.a.q.class, "com.obric.aiagent.plugin");
        g r1 = g.f39201a;
        d.h.b.o.a(r1, "null cannot be cast to non-null type kotlin.Function3<@[ParameterName(name = 'clauseObject')] kotlin.Any, @[ParameterName(name = 'param')] kotlin.Any?, @[ParameterName(name = 'clauseResult')] kotlin.Any?, kotlin.Any?>{ kotlinx.coroutines.selects.SelectKt.ProcessResultFunction }");
        return (kotlinx.coroutines.e.g) ZeusTransformUtils.preCheckCast(new kotlinx.coroutines.e.h(this, r2, (d.h.a.q) ZeusTransformUtils.preCheckCast(d.h.b.ae.b(r1, 3), d.h.a.q.class, "com.obric.aiagent.plugin"), null, 8, null), kotlinx.coroutines.e.g.class, "com.obric.aiagent.plugin");
    }

    private final void a(kotlinx.coroutines.e.j<?> r8, Object r9) {
        kotlinx.coroutines.e.j r10 = (kotlinx.coroutines.e.j) ZeusTransformUtils.wrapperContextForParams(r8, kotlinx.coroutines.e.j.class, "com.obric.aiagent.plugin");
    L3:
        Object r11 = n();
        if (ZeusTransformUtils.instanceOf(r11, bu.class) == false) goto L6;
        if (a(r11) < 0) goto L3;
        r10.a(ce.a((ca) ZeusTransformUtils.preCheckCast(this, ca.class, "com.obric.aiagent.plugin"), false, false, (bw) ZeusTransformUtils.preCheckCast(new d(this, r10), bw.class, "com.obric.aiagent.plugin"), 3, null));
        return;
    L6:
        if (ZeusTransformUtils.instanceOf(r11, ab.class) == true) goto L9;
        r11 = cj.b(r11);
    L9:
        r10.a(r11);
    }

    private final Object b(Object r1, Object r2) {
        if (ZeusTransformUtils.instanceOf(r2, ab.class) == true) goto L6;
        return r2;
    L6:
        throw ((ab) ZeusTransformUtils.preCheckCast(r2, ab.class, "com.obric.aiagent.plugin")).f38830a;
    }

    private final void b(cn r8, Throwable r9) {
        kotlinx.coroutines.internal.v r10 = (kotlinx.coroutines.internal.v) ZeusTransformUtils.preCheckCast(r8, kotlinx.coroutines.internal.v.class, "com.obric.aiagent.plugin");
        Object r0 = r10.f();
        d.h.b.o.a(r0, "null cannot be cast to non-null type kotlinx.coroutines.internal.LockFreeLinkedListNode{ kotlinx.coroutines.internal.LockFreeLinkedListKt.Node }");
        kotlinx.coroutines.internal.x r1 = (kotlinx.coroutines.internal.x) ZeusTransformUtils.preCheckCast(r0, kotlinx.coroutines.internal.x.class, "com.obric.aiagent.plugin");
        ad r2 = null;
    L4:
        if (d.h.b.o.a(r1, r10) == true) goto L17;
        if (ZeusTransformUtils.instanceOf(r1, ch.class) == false) goto L16;
        ch r3 = (ch) ZeusTransformUtils.preCheckCast(r1, ch.class, "com.obric.aiagent.plugin");
        r3.a(r9);     // Catch: Throwable -> L10
    L10:
        th = move-exception;
        Throwable r5 = (Throwable) ZeusTransformUtils.preCheckCast(r2, Throwable.class, "com.obric.aiagent.plugin");
        if (r5 == null) goto L15;
        d.a.a(r5, th);
        if (r5 != null) goto L16;
    L15:
        r2 = new ad("Exception in completion handler " + r3 + " for " + this, th);
        d.x r4 = d.x.f38692a;
    L16:
        r1 = r1.g();
        goto L4
    L17:
        Throwable r11 = (Throwable) ZeusTransformUtils.preCheckCast(r2, Throwable.class, "com.obric.aiagent.plugin");
        if (r11 == null) goto L28;
        a_(r11);
        return;
    }

    @Override // kotlinx.coroutines.ca
    public final boolean s_() {
    L2:
        int r0 = a(n());
        if (r0 == 0) goto L8;
        if (r0 != 1) goto L2;
        return true;
    L8:
        return false;
    }

    private final boolean g() {
    L2:
        Object r0 = n();
        if (ZeusTransformUtils.instanceOf(r0, bu.class) == false) goto L4;
        if (a(r0) < 0) goto L2;
        return true;
    L4:
        return false;
    }

    private final Object a(d.c.d<? super d.x> r10) {
        d.c.d r11 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r10, d.c.d.class, "com.obric.aiagent.plugin");
        o r0 = new o(d.c.a.b.a(r11), 1);
        r0.e();
        n r2 = (n) ZeusTransformUtils.preCheckCast(r0, n.class, "com.obric.aiagent.plugin");
        q.a(r2, ce.a((ca) ZeusTransformUtils.preCheckCast(this, ca.class, "com.obric.aiagent.plugin"), false, false, (bw) ZeusTransformUtils.preCheckCast(new ct((d.c.d) ZeusTransformUtils.preCheckCast(r2, d.c.d.class, "com.obric.aiagent.plugin")), bw.class, "com.obric.aiagent.plugin"), 3, null));
        Object r9 = r0.h();
        if (r9 != d.c.a.b.a()) goto L6;
        d.c.b.a.h.c(r11);
    L6:
        if (r9 != d.c.a.b.a()) goto L9;
        return r9;
    L9:
        return d.x.f38692a;
    }

    public final void a(ch r4) {
    L2:
        Object r0 = n();
        if (ZeusTransformUtils.instanceOf(r0, ch.class) == false) goto L10;
        if (r0 != r4) goto L5;
        if (t().compareAndSet(this, r0, cj.a()) == false) goto L2;
        return;
    L5:
        return;
    L10:
        if (ZeusTransformUtils.instanceOf(r0, bu.class) == true) goto L12;
        return;
    L12:
        if (((bu) ZeusTransformUtils.preCheckCast(r0, bu.class, "com.obric.aiagent.plugin")).o_() == null) goto L20;
        r4.e();
        return;
    }

    @Override // kotlinx.coroutines.ca, kotlinx.coroutines.a.s
    public void a(CancellationException r5) {
        if (r5 != null) goto L5;
        r5 = (CancellationException) ZeusTransformUtils.preCheckCast(new cb(a(this), null, (ca) ZeusTransformUtils.preCheckCast(this, ca.class, "com.obric.aiagent.plugin")), CancellationException.class, "com.obric.aiagent.plugin");
    L5:
        b((Throwable) ZeusTransformUtils.preCheckCast(r5, Throwable.class, "com.obric.aiagent.plugin"));
    }

    private final Object c(Object r7) {
    L2:
        Object r0 = n();
        if (ZeusTransformUtils.instanceOf(r0, bu.class) == false) goto L13;
        if (ZeusTransformUtils.instanceOf(r0, c.class) == true) goto L7;
    L9:
        Object r1 = a(r0, new ab(h(r7), false, 2, null));
        if (r1 == cj.e()) goto L2;
        return r1;
    L7:
        if (((c) ZeusTransformUtils.preCheckCast(r0, c.class, "com.obric.aiagent.plugin")).c() == false) goto L9;
    L13:
        return cj.c();
    }

    private final Object i(Object r7) {
        Throwable r0 = null;
        Throwable r1 = null;
    L3:
        Object r2 = n();
        if (ZeusTransformUtils.instanceOf(r2, c.class) == true) goto L5;
        if (ZeusTransformUtils.instanceOf(r2, bu.class) == false) goto L47;
        if (r1 != null) goto L34;
        r1 = h(r7);
    L34:
        if (((bu) ZeusTransformUtils.preCheckCast(r2, bu.class, "com.obric.aiagent.plugin")).n_() == true) goto L36;
        Object r3 = a(r2, new ab(r1, false, 2, null));
        if (r3 == cj.c()) goto L45;
        if (r3 == cj.e()) goto L3;
        return r3;
    L45:
        throw new IllegalStateException(("Cannot happen in " + r2).toString());
    L36:
        if (a((bu) ZeusTransformUtils.preCheckCast(r2, bu.class, "com.obric.aiagent.plugin"), r1) == false) goto L3;
        return cj.c();
    L47:
        return cj.d();
    L5:
        monitor-enter(r2);
    L26:
        th = move-exception;
        throw th;
    L7:
        if (((c) ZeusTransformUtils.preCheckCast(r2, c.class, "com.obric.aiagent.plugin")).e() == false) goto L11;
        kotlinx.coroutines.internal.al r6 = cj.d();     // Catch: Throwable -> L26
        monitor-exit(r2);
        return r6;
    L11:
        boolean r4 = ((c) ZeusTransformUtils.preCheckCast(r2, c.class, "com.obric.aiagent.plugin")).f();     // Catch: Throwable -> L26
        if (r7 != null) goto L14;
        if (r4 == false) goto L14;
    L17:
        Throwable r8 = ((c) ZeusTransformUtils.preCheckCast(r2, c.class, "com.obric.aiagent.plugin")).d();     // Catch: Throwable -> L26
        if ((!r4) == false) goto L21;
        r0 = r8;
    L21:
        monitor-exit(r2);
        if (r0 == null) goto L25;
        a(((c) ZeusTransformUtils.preCheckCast(r2, c.class, "com.obric.aiagent.plugin")).o_(), r0);
    L25:
        return cj.c();
    L14:
        if (r1 != null) goto L16;
        r1 = h(r7);     // Catch: Throwable -> L26
    L16:
        ((c) ZeusTransformUtils.preCheckCast(r2, c.class, "com.obric.aiagent.plugin")).c(r1);     // Catch: Throwable -> L26
        goto L17
    }

    public final boolean f(Object r4) {
    L2:
        Object r0 = a(n(), r4);
        if (r0 == cj.c()) goto L4;
        if (r0 == cj.f39202a) goto L8;
        if (r0 == cj.e()) goto L2;
        d(r0);
        return true;
    L8:
        return true;
    L4:
        return false;
    }

    public final Object g(Object r4) {
    L2:
        Object r0 = a(n(), r4);
        if (r0 == cj.c()) goto L8;
        if (r0 == cj.e()) goto L2;
        return r0;
    L8:
        throw new IllegalStateException("Job " + this + " is already complete or completing, but is being completed with " + r4, j(r4));
    }
}
