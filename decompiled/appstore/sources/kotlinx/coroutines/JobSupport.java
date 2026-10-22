package kotlinx.coroutines;

import java.util.ArrayList;
import java.util.Collections;
import java.util.IdentityHashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.CancellationException;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsJvmKt;
import kotlin.jvm.Volatile;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Ref$ObjectRef;
import kotlin.sequences.Sequence;
import kotlinx.coroutines.internal.LockFreeLinkedListNode;
import kotlinx.coroutines.selects.SelectClause0;
import kotlinx.coroutines.selects.SelectClause1;
import kotlinx.coroutines.selects.SelectInstance;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes4.dex */
public class JobSupport implements Job, ChildJob, ParentJob {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final AtomicReferenceFieldUpdater f21284a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final AtomicReferenceFieldUpdater f21285b = null;

    @Volatile
    @Nullable
    private volatile Object _parentHandle;

    @Volatile
    @Nullable
    private volatile Object _state;

    public static final class a extends n {

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public final JobSupport f21286i;

        public a(Continuation r10, JobSupport r11) {
            super(r10, 1);
            this.f21286i = r11;
        }

        @Override // kotlinx.coroutines.n
        public Throwable o(Job r10) {
            Object r11 = this.f21286i.E();
            if ((r11 instanceof c) == false) goto L8;
            Throwable r12 = ((c) r11).d();
            if (r12 == null) goto L8;
            return r12;
        L8:
            if ((r11 instanceof w) == false) goto L12;
            return ((w) r11).f21768a;
        L12:
            return r10.getCancellationException();
        }

        @Override // kotlinx.coroutines.n
        public String y() {
            return "AwaitContinuation";
        }
    }

    public static final class b extends k1 {

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final JobSupport f21287e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final c f21288f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public final s f21289g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public final Object f21290h;

        public b(JobSupport r10, c r11, s r12, Object r13) {
            this.f21287e = r10;
            this.f21288f = r11;
            this.f21289g = r12;
            this.f21290h = r13;
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Object invoke(Object r10) {
            o((Throwable) r10);
            return Unit.f21064a;
        }

        @Override // kotlinx.coroutines.y
        public void o(Throwable r10) {
            JobSupport.b(this.f21287e, this.f21288f, this.f21289g, this.f21290h);
        }
    }

    public static final class c implements Incomplete {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final AtomicIntegerFieldUpdater f21291b = null;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public static final AtomicReferenceFieldUpdater f21292c = null;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public static final AtomicReferenceFieldUpdater f21293d = null;

        @Volatile
        @Nullable
        private volatile Object _exceptionsHolder;

        @Volatile
        private volatile int _isCompleting;

        @Volatile
        @Nullable
        private volatile Object _rootCause;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final p1 f21294a;

        static {
            f21291b = AtomicIntegerFieldUpdater.newUpdater(c.class, "_isCompleting");
            f21292c = AtomicReferenceFieldUpdater.newUpdater(c.class, Object.class, "_rootCause");
            f21293d = AtomicReferenceFieldUpdater.newUpdater(c.class, Object.class, "_exceptionsHolder");
        }

        public c(p1 r10, boolean r11, Throwable r12) {
            this.f21294a = r10;
            this._isCompleting = r11 ? 1 : 0;
            this._rootCause = r12;
        }

        public final void a(Throwable r10) {
            Throwable r11 = d();
            if (r11 != null) goto L6;
            k(r10);
            return;
        L6:
            if (r10 != r11) goto L8;
            return;
        L8:
            Object r12 = c();
            if (r12 != null) goto L12;
            j(r10);
            return;
        L12:
            if ((r12 instanceof Throwable) == false) goto L17;
            if (r10 != r12) goto L15;
            return;
        L15:
            ArrayList r13 = b();
            r13.add(r12);
            r13.add(r10);
            j(r13);
            return;
        L17:
            if ((r12 instanceof ArrayList) == false) goto L21;
            ((ArrayList) r12).add(r10);
            return;
        L21:
            throw new IllegalStateException(("State is " + r12).toString());
        }

        public final ArrayList b() {
            return new ArrayList(4);
        }

        public final Object c() {
            return f21293d.get(this);
        }

        public final Throwable d() {
            return (Throwable) f21292c.get(this);
        }

        public final boolean e() {
            if (d() == null) goto L5;
            return true;
        L5:
            return false;
        }

        public final boolean f() {
            if (f21291b.get(this) == 0) goto L5;
            return true;
        L5:
            return false;
        }

        public final boolean g() {
            if (c() != l1.e()) goto L5;
            return true;
        L5:
            return false;
        }

        @Override // kotlinx.coroutines.Incomplete
        public p1 getList() {
            return this.f21294a;
        }

        public final List h(Throwable r10) {
            Object r11 = c();
            if (r11 != null) goto L6;
            ArrayList r12 = b();
        L11:
            Throwable r13 = d();
            if (r13 == null) goto L14;
            r12.add(0, r13);
        L14:
            if (r10 != null) goto L16;
        L18:
            j(l1.e());
            return r12;
        L16:
            if (kotlin.jvm.internal.q.b(r10, r13) == true) goto L18;
            r12.add(r10);
            goto L18
        L6:
            if ((r11 instanceof Throwable) == false) goto L9;
            ArrayList r14 = b();
            r14.add(r11);
            r12 = r14;
            goto L11
        L9:
            if ((r11 instanceof ArrayList) == false) goto L21;
            r12 = (ArrayList) r11;
            goto L11
        L21:
            throw new IllegalStateException(("State is " + r11).toString());
        }

        public final void i(boolean r10) {
            f21291b.set(this, r10 ? 1 : 0);
        }

        @Override // kotlinx.coroutines.Incomplete
        public boolean isActive() {
            if (d() != null) goto L5;
            return true;
        L5:
            return false;
        }

        public final void j(Object r10) {
            f21293d.set(this, r10);
        }

        public final void k(Throwable r10) {
            f21292c.set(this, r10);
        }

        public String toString() {
            return "Finishing[cancelling=" + e() + ", completing=" + f() + ", rootCause=" + d() + ", exceptions=" + c() + ", list=" + getList() + ']';
        }
    }

    public final class d extends k1 {

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final SelectInstance f21295e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final /* synthetic */ JobSupport f21296f;

        public d(JobSupport r10, SelectInstance r11) {
            this.f21296f = r10;
            this.f21295e = r11;
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Object invoke(Object r10) {
            o((Throwable) r10);
            return Unit.f21064a;
        }

        @Override // kotlinx.coroutines.y
        public void o(Throwable r10) {
            Object r11 = this.f21296f.E();
            if ((r11 instanceof w) == true) goto L6;
            r11 = l1.h(r11);
        L6:
            this.f21295e.trySelect(this.f21296f, r11);
        }
    }

    public final class e extends k1 {

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final SelectInstance f21297e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final /* synthetic */ JobSupport f21298f;

        public e(JobSupport r10, SelectInstance r11) {
            this.f21298f = r10;
            this.f21297e = r11;
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Object invoke(Object r10) {
            o((Throwable) r10);
            return Unit.f21064a;
        }

        @Override // kotlinx.coroutines.y
        public void o(Throwable r10) {
            this.f21297e.trySelect(this.f21298f, Unit.f21064a);
        }
    }

    public static final class f extends LockFreeLinkedListNode.a {

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final /* synthetic */ JobSupport f21299d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final /* synthetic */ Object f21300e;

        public f(LockFreeLinkedListNode r10, JobSupport r11, Object r12) {
            this.f21299d = r11;
            this.f21300e = r12;
            super(r10);
        }

        @Override // kotlinx.coroutines.internal.b
        public /* bridge */ /* synthetic */ Object d(Object r10) {
            return f((LockFreeLinkedListNode) r10);
        }

        public Object f(LockFreeLinkedListNode r10) {
            if (this.f21299d.E() != this.f21300e) goto L6;
            return null;
        L6:
            return kotlinx.coroutines.internal.o.a();
        }
    }

    static {
        f21284a = AtomicReferenceFieldUpdater.newUpdater(JobSupport.class, Object.class, "_state");
        f21285b = AtomicReferenceFieldUpdater.newUpdater(JobSupport.class, Object.class, "_parentHandle");
    }

    public JobSupport(boolean r10) {
        if (r10 == false) goto L5;
        p0 r11 = l1.c();
    L6:
        this._state = r11;
        return;
    L5:
        r11 = l1.d();
        goto L6
    }

    public static final /* synthetic */ String a(JobSupport r10) {
        return r10.p();
    }

    public static final /* synthetic */ void b(JobSupport r10, c r11, s r12, Object r13) {
        r10.s(r11, r12, r13);
    }

    public static final /* synthetic */ Object c(JobSupport r10, Object r11, Object r12) {
        return r10.T(r11, r12);
    }

    public static final /* synthetic */ void d(JobSupport r10, SelectInstance r11, Object r12) {
        r10.U(r11, r12);
    }

    public static final /* synthetic */ void e(JobSupport r10, SelectInstance r11, Object r12) {
        r10.a0(r11, r12);
    }

    public static /* synthetic */ CancellationException g0(JobSupport r10, Throwable r11, String r12, int r13, Object r14) {
        if (r14 != null) goto L9;
        if ((r13 & 1) == 0) goto L7;
        r12 = null;
    L7:
        return r10.f0(r11, r12);
    L9:
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: toCancellationException");
    }

    public final SelectClause1 A() {
        JobSupport$onAwaitInternal$1 r10 = JobSupport$onAwaitInternal$1.INSTANCE;
        kotlin.jvm.internal.q.e(r10, "null cannot be cast to non-null type kotlin.Function3<@[ParameterName(name = 'clauseObject')] kotlin.Any, @[ParameterName(name = 'select')] kotlinx.coroutines.selects.SelectInstance<*>, @[ParameterName(name = 'param')] kotlin.Any?, kotlin.Unit>{ kotlinx.coroutines.selects.SelectKt.RegistrationFunction }");
        Function3 r11 = (Function3) kotlin.jvm.internal.y.e(r10, 3);
        JobSupport$onAwaitInternal$2 r12 = JobSupport$onAwaitInternal$2.INSTANCE;
        kotlin.jvm.internal.q.e(r12, "null cannot be cast to non-null type kotlin.Function3<@[ParameterName(name = 'clauseObject')] kotlin.Any, @[ParameterName(name = 'param')] kotlin.Any?, @[ParameterName(name = 'clauseResult')] kotlin.Any?, kotlin.Any?>{ kotlinx.coroutines.selects.SelectKt.ProcessResultFunction }");
        return new kotlinx.coroutines.selects.d(this, r11, (Function3) kotlin.jvm.internal.y.e(r12, 3), null, 8, null);
    }

    public boolean B() {
        return false;
    }

    public final p1 C(Incomplete r10) {
        p1 r11 = r10.getList();
        if (r11 == null) goto L5;
        return r11;
    L5:
        if ((r10 instanceof p0) == false) goto L8;
        return new p1();
    L8:
        if ((r10 instanceof k1) == false) goto L11;
        Z((k1) r10);
        return null;
    L11:
        throw new IllegalStateException(("State should have list: " + r10).toString());
    }

    public final ChildHandle D() {
        return (ChildHandle) f21285b.get(this);
    }

    public final Object E() {
        AtomicReferenceFieldUpdater r10 = f21284a;
    L3:
        Object r11 = r10.get(this);
        if ((r11 instanceof kotlinx.coroutines.internal.u) == false) goto L5;
        ((kotlinx.coroutines.internal.u) r11).a(this);
        goto L3
    L5:
        return r11;
    }

    public boolean F(Throwable r10) {
        return false;
    }

    public void G(Throwable r10) {
        throw r10;
    }

    public final void H(Job r10) {
        if (r10 != null) goto L5;
        c0(r1.f21672a);
        return;
    L5:
        r10.start();
        ChildHandle r11 = r10.attachChild(this);
        c0(r11);
        if (isCompleted() == false) goto L9;
        r11.dispose();
        c0(r1.f21672a);
        return;
    }

    public boolean I() {
        return false;
    }

    public final boolean J() {
    L2:
        Object r10 = E();
        if ((r10 instanceof Incomplete) == false) goto L4;
        if (d0(r10) < 0) goto L2;
        return true;
    L4:
        return false;
    }

    public final Object K(Continuation r10) {
        n r11 = new n(IntrinsicsKt__IntrinsicsJvmKt.c(r10), 1);
        r11.initCancellability();
        p.a(r11, invokeOnCompletion(new t1(r11)));
        Object r12 = r11.q();
        if (r12 != kotlin.coroutines.intrinsics.a.d()) goto L6;
        tf.d.c(r10);
    L6:
        if (r12 != kotlin.coroutines.intrinsics.a.d()) goto L9;
        return r12;
    L9:
        return Unit.f21064a;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final Object L(Object r10) {
        Throwable r11 = null;
        Object[] r12 = 0;
        Throwable r13 = null;
    L3:
        Object r14 = E();
        if ((r14 instanceof c) == true) goto L5;
        if ((r14 instanceof Incomplete) == false) goto L47;
        if (r13 != null) goto L33;
        r13 = t(r10);
    L33:
        Incomplete r15 = (Incomplete) r14;
        if (r15.isActive() == true) goto L36;
        Object r16 = k0(r14, new w(r13, false, 2, r12 == true ? 1 : 0));
        if (r16 == l1.a()) goto L45;
        if (r16 == l1.b()) goto L3;
        return r16;
    L45:
        throw new IllegalStateException(("Cannot happen in " + r14).toString());
    L36:
        if (j0(r15, r13) == false) goto L3;
        return l1.a();
    L47:
        return l1.f();
    L5:
        monitor-enter(r14);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (((c) r14).g() == false) goto L13;
        kotlinx.coroutines.internal.b0 r17 = l1.f();     // Catch: Throwable -> L11
        monitor-exit(r14);
        return r17;
    L13:
        boolean r18 = ((c) r14).e();     // Catch: Throwable -> L11
        if (r10 != null) goto L16;
        if (r18 == false) goto L16;
    L19:
        Throwable r19 = ((c) r14).d();     // Catch: Throwable -> L11
        if (r18 == true) goto L22;
        r11 = r19;
    L22:
        monitor-exit(r14);
        if (r11 == null) goto L26;
        R(((c) r14).getList(), r11);
    L26:
        return l1.a();
    L16:
        if (r13 != null) goto L18;
        r13 = t(r10);     // Catch: Throwable -> L11
    L18:
        ((c) r14).a(r13);     // Catch: Throwable -> L11
        goto L19
    }

    public final boolean M(Object r10) {
    L2:
        Object r11 = k0(E(), r10);
        if (r11 == l1.a()) goto L4;
        if (r11 == l1.f21639b) goto L8;
        if (r11 == l1.b()) goto L2;
        h(r11);
        return true;
    L8:
        return true;
    L4:
        return false;
    }

    public final Object N(Object r10) {
    L2:
        Object r11 = k0(E(), r10);
        if (r11 == l1.a()) goto L8;
        if (r11 == l1.b()) goto L2;
        return r11;
    L8:
        throw new IllegalStateException("Job " + this + " is already complete or completing, but is being completed with " + r10, x(r10));
    }

    public final k1 O(Function1 r10, boolean r11) {
        k1 r12 = null;
        if (r11 == false) goto L10;
        if ((r10 instanceof f1) == false) goto L7;
        r12 = (f1) r10;
    L7:
        if (r12 != null) goto L15;
        r12 = new d1(r10);
    L15:
        r12.q(this);
        return r12;
    L10:
        if ((r10 instanceof k1) == false) goto L12;
        r12 = (k1) r10;
    L12:
        if (r12 != null) goto L15;
        r12 = new e1(r10);
        goto L15
    }

    public String P() {
        return e0.a(this);
    }

    public final s Q(LockFreeLinkedListNode r10) {
    L3:
        if (r10.j() == false) goto L5;
        r10 = r10.i();
    L5:
        r10 = r10.h();
        if (r10.j() == true) goto L5;
        if ((r10 instanceof s) == true) goto L10;
        if ((r10 instanceof p1) == false) goto L5;
        return null;
    L10:
        return (s) r10;
    }

    public final void R(p1 r10, Throwable r11) {
        V(r11);
        Object r12 = r10.g();
        kotlin.jvm.internal.q.e(r12, "null cannot be cast to non-null type kotlinx.coroutines.internal.LockFreeLinkedListNode{ kotlinx.coroutines.internal.LockFreeLinkedListKt.Node }");
        LockFreeLinkedListNode r13 = (LockFreeLinkedListNode) r12;
        CompletionHandlerException r14 = null;
    L4:
        if (kotlin.jvm.internal.q.b(r13, r10) == true) goto L15;
        if ((r13 instanceof f1) == false) goto L14;
        k1 r15 = (k1) r13;
        r15.o(r11);     // Catch: Throwable -> L10
    L10:
        th = move-exception;
        if (r14 == null) goto L13;
        kotlin.a.a(r14, th);
        goto L14
    L13:
        r14 = new CompletionHandlerException("Exception in completion handler " + r15 + " for " + this, th);
        Unit r16 = Unit.f21064a;
    L14:
        r13 = r13.h();
        goto L4
    L15:
        if (r14 == null) goto L17;
        G(r14);
    L17:
        o(r11);
    }

    public final void S(p1 r10, Throwable r11) {
        Object r12 = r10.g();
        kotlin.jvm.internal.q.e(r12, "null cannot be cast to non-null type kotlinx.coroutines.internal.LockFreeLinkedListNode{ kotlinx.coroutines.internal.LockFreeLinkedListKt.Node }");
        LockFreeLinkedListNode r13 = (LockFreeLinkedListNode) r12;
        CompletionHandlerException r14 = null;
    L4:
        if (kotlin.jvm.internal.q.b(r13, r10) == true) goto L15;
        if ((r13 instanceof k1) == false) goto L14;
        k1 r15 = (k1) r13;
        r15.o(r11);     // Catch: Throwable -> L10
    L10:
        th = move-exception;
        if (r14 == null) goto L13;
        kotlin.a.a(r14, th);
        goto L14
    L13:
        r14 = new CompletionHandlerException("Exception in completion handler " + r15 + " for " + this, th);
        Unit r16 = Unit.f21064a;
    L14:
        r13 = r13.h();
        goto L4
    L15:
        if (r14 == null) goto L25;
        G(r14);
        return;
    }

    public final Object T(Object r10, Object r11) {
        if ((r11 instanceof w) == true) goto L6;
        return r11;
    L6:
        throw ((w) r11).f21768a;
    }

    public final void U(SelectInstance r10, Object r11) {
    L2:
        Object r12 = E();
        if ((r12 instanceof Incomplete) == false) goto L5;
        if (d0(r12) < 0) goto L2;
        r10.disposeOnCompletion(invokeOnCompletion(new d(this, r10)));
        return;
    L5:
        if ((r12 instanceof w) == true) goto L8;
        r12 = l1.h(r12);
    L8:
        r10.selectInRegistrationPhase(r12);
    }

    public void V(Throwable r10) {
    }

    public void W(Object r10) {
    }

    public void X() {
    }

    public final void Y(p0 r10) {
        p1 r11 = new p1();
        Object r12 = r11;
        if (r10.isActive() == true) goto L6;
        r12 = new z0(r11);
    L6:
        androidx.concurrent.futures.a.a(f21284a, this, r10, r12);
    }

    public final void Z(k1 r10) {
        r10.c(new p1());
        LockFreeLinkedListNode r11 = r10.h();
        androidx.concurrent.futures.a.a(f21284a, this, r10, r11);
    }

    public final void a0(SelectInstance r10, Object r11) {
        if (J() == true) goto L6;
        r10.selectInRegistrationPhase(Unit.f21064a);
        return;
    L6:
        r10.disposeOnCompletion(invokeOnCompletion(new e(this, r10)));
    }

    @Override // kotlinx.coroutines.Job
    public final ChildHandle attachChild(ChildJob r10) {
        DisposableHandle r11 = Job.a.e(this, true, false, new s(r10), 2, null);
        kotlin.jvm.internal.q.e(r11, "null cannot be cast to non-null type kotlinx.coroutines.ChildHandle");
        return (ChildHandle) r11;
    }

    public final void b0(k1 r10) {
    L2:
        Object r11 = E();
        if ((r11 instanceof k1) == false) goto L10;
        if (r11 != r10) goto L5;
        if (androidx.concurrent.futures.a.a(f21284a, this, r11, l1.c()) == false) goto L2;
        return;
    L5:
        return;
    L10:
        if ((r11 instanceof Incomplete) == true) goto L12;
        return;
    L12:
        if (((Incomplete) r11).getList() == null) goto L20;
        r10.k();
        return;
    }

    public final void c0(ChildHandle r10) {
        f21285b.set(this, r10);
    }

    @Override // kotlinx.coroutines.Job
    public /* synthetic */ void cancel() {
        Job.a.a(this);
    }

    public final int d0(Object r10) {
        if ((r10 instanceof p0) == false) goto L13;
        if (((p0) r10).isActive() == false) goto L8;
        return 0;
    L8:
        if (androidx.concurrent.futures.a.a(f21284a, this, r10, l1.c()) == true) goto L10;
        return -1;
    L10:
        X();
        return 1;
    L13:
        if ((r10 instanceof z0) == true) goto L15;
        return 0;
    L15:
        if (androidx.concurrent.futures.a.a(f21284a, this, r10, ((z0) r10).getList()) == true) goto L17;
        return -1;
    L17:
        X();
        return 1;
    }

    public final String e0(Object r10) {
        if ((r10 instanceof c) == false) goto L11;
        c r11 = (c) r10;
        if (r11.e() == false) goto L8;
        return "Cancelling";
    L8:
        if (r11.f() == false) goto L22;
        return "Completing";
    L22:
        return "Active";
    L11:
        if ((r10 instanceof Incomplete) == false) goto L17;
        if (((Incomplete) r10).isActive() == true) goto L26;
        return "New";
    L26:
        return "Active";
    L17:
        if ((r10 instanceof w) == false) goto L19;
        return "Cancelled";
    L19:
        return "Completed";
    }

    public final boolean f(Object r10, p1 r11, k1 r12) {
        f r13 = new f(r12, this, r10);
    L3:
        int r14 = r11.i().n(r12, r11, r13);
        if (r14 == 1) goto L13;
        if (r14 != 2) goto L3;
        return false;
    L13:
        return true;
    }

    public final CancellationException f0(Throwable r10, String r11) {
        if ((r10 instanceof CancellationException) == false) goto L5;
        CancellationException r12 = (CancellationException) r10;
    L6:
        if (r12 == null) goto L8;
    L11:
        return r12;
    L8:
        if (r11 != null) goto L10;
        r11 = a(this);
    L10:
        r12 = new JobCancellationException(r11, r10, this);
        goto L11
    L5:
        r12 = null;
        goto L6
    }

    @Override // kotlin.coroutines.CoroutineContext.Element, kotlin.coroutines.CoroutineContext
    public Object fold(Object r10, Function2 r11) {
        return Job.a.c(this, r10, r11);
    }

    public final void g(Throwable r10, List r11) {
        if (r11.size() > 1) goto L5;
        return;
    L5:
        Set r12 = Collections.newSetFromMap(new IdentityHashMap(r11.size()));
        Iterator r13 = r11.iterator();
    L7:
        if (r13.hasNext() == false) goto L16;
        Throwable r14 = (Throwable) r13.next();
        if (r14 == r10) goto L7;
        if (r14 == r10) goto L7;
        if ((r14 instanceof CancellationException) == true) goto L7;
        if (r12.add(r14) == false) goto L7;
        kotlin.a.a(r10, r14);
        goto L7
    }

    @Override // kotlin.coroutines.CoroutineContext.Element, kotlin.coroutines.CoroutineContext
    public CoroutineContext.Element get(CoroutineContext.Key r10) {
        return Job.a.d(this, r10);
    }

    @Override // kotlinx.coroutines.Job
    public final CancellationException getCancellationException() {
        Object r10 = E();
        if ((r10 instanceof c) == false) goto L12;
        Throwable r11 = ((c) r10).d();
        if (r11 == null) goto L10;
        CancellationException r12 = f0(r11, e0.a(this) + " is cancelling");
        if (r12 == null) goto L10;
        return r12;
    L10:
        throw new IllegalStateException(("Job is still new or active: " + this).toString());
    L12:
        if ((r10 instanceof Incomplete) == true) goto L19;
        if ((r10 instanceof w) == false) goto L17;
        return g0(this, ((w) r10).f21768a, null, 1, null);
    L17:
        return new JobCancellationException(e0.a(this) + " has completed normally", null, this);
    L19:
        throw new IllegalStateException(("Job is still new or active: " + this).toString());
    }

    @Override // kotlinx.coroutines.ParentJob
    public CancellationException getChildJobCancellationCause() {
        Object r10 = E();
        CancellationException r11 = null;
        if ((r10 instanceof c) == false) goto L6;
        Throwable r12 = ((c) r10).d();
    L12:
        if ((r12 instanceof CancellationException) == false) goto L14;
        r11 = (CancellationException) r12;
    L14:
        if (r11 == null) goto L16;
        return r11;
    L16:
        return new JobCancellationException("Parent job is " + e0(r10), r12, this);
    L6:
        if ((r10 instanceof w) == false) goto L9;
        r12 = ((w) r10).f21768a;
        goto L12
    L9:
        if ((r10 instanceof Incomplete) == true) goto L18;
        r12 = null;
        goto L12
    L18:
        throw new IllegalStateException(("Cannot be cancelling child in this state: " + r10).toString());
    }

    @Override // kotlinx.coroutines.Job
    public final Sequence getChildren() {
        return kotlin.sequences.h.b(new JobSupport$children$1(this, null));
    }

    public final Throwable getCompletionExceptionOrNull() {
        Object r10 = E();
        if ((r10 instanceof Incomplete) == true) goto L7;
        return x(r10);
    L7:
        throw new IllegalStateException("This job has not completed yet");
    }

    @Override // kotlin.coroutines.CoroutineContext.Element
    public final CoroutineContext.Key getKey() {
        return Job.Key;
    }

    @Override // kotlinx.coroutines.Job
    public final SelectClause0 getOnJoin() {
        JobSupport$onJoin$1 r10 = JobSupport$onJoin$1.INSTANCE;
        kotlin.jvm.internal.q.e(r10, "null cannot be cast to non-null type kotlin.Function3<@[ParameterName(name = 'clauseObject')] kotlin.Any, @[ParameterName(name = 'select')] kotlinx.coroutines.selects.SelectInstance<*>, @[ParameterName(name = 'param')] kotlin.Any?, kotlin.Unit>{ kotlinx.coroutines.selects.SelectKt.RegistrationFunction }");
        Function3 r11 = null;
        return new kotlinx.coroutines.selects.c(this, (Function3) kotlin.jvm.internal.y.e(r10, 3), r11, 4, null);
    }

    @Override // kotlinx.coroutines.Job
    public Job getParent() {
        ChildHandle r10 = D();
        if (r10 != null) goto L7;
        return null;
    L7:
        return r10.getParent();
    }

    public void h(Object r10) {
    }

    public final String h0() {
        return P() + '{' + e0(E()) + '}';
    }

    public final Object i(Continuation r10) {
    L2:
        Object r11 = E();
        if ((r11 instanceof Incomplete) == false) goto L5;
        if (d0(r11) < 0) goto L2;
        return j(r10);
    L5:
        if ((r11 instanceof w) == true) goto L9;
        return l1.h(r11);
    L9:
        throw ((w) r11).f21768a;
    }

    public final boolean i0(Incomplete r10, Object r11) {
        if (androidx.concurrent.futures.a.a(f21284a, this, r10, l1.g(r11)) == true) goto L6;
        return false;
    L6:
        V(null);
        W(r11);
        r(r10, r11);
        return true;
    }

    @Override // kotlinx.coroutines.Job
    public final DisposableHandle invokeOnCompletion(Function1 r10) {
        return invokeOnCompletion(false, true, r10);
    }

    @Override // kotlinx.coroutines.Job
    public boolean isActive() {
        Object r10 = E();
        if ((r10 instanceof Incomplete) == true) goto L5;
    L7:
        return false;
    L5:
        if (((Incomplete) r10).isActive() == false) goto L7;
        return true;
    }

    @Override // kotlinx.coroutines.Job
    public final boolean isCancelled() {
        Object r10 = E();
        if ((r10 instanceof w) == false) goto L5;
    L10:
        return true;
    L5:
        if ((r10 instanceof c) == true) goto L7;
    L9:
        return false;
    L7:
        if (((c) r10).e() == false) goto L9;
        goto L9
    }

    @Override // kotlinx.coroutines.Job
    public final boolean isCompleted() {
        return !(E() instanceof Incomplete);
    }

    public final Object j(Continuation r10) {
        a r11 = new a(IntrinsicsKt__IntrinsicsJvmKt.c(r10), this);
        r11.initCancellability();
        p.a(r11, invokeOnCompletion(new s1(r11)));
        Object r12 = r11.q();
        if (r12 != kotlin.coroutines.intrinsics.a.d()) goto L5;
        tf.d.c(r10);
    L5:
        return r12;
    }

    public final boolean j0(Incomplete r10, Throwable r11) {
        p1 r12 = C(r10);
        if (r12 != null) goto L5;
        return false;
    L5:
        c r13 = new c(r12, false, r11);
        if (androidx.concurrent.futures.a.a(f21284a, this, r10, r13) == true) goto L8;
        return false;
    L8:
        R(r12, r11);
        return true;
    }

    @Override // kotlinx.coroutines.Job
    public final Object join(Continuation r10) {
        if (J() == true) goto L6;
        h1.h(r10.getContext());
        return Unit.f21064a;
    L6:
        Object r11 = K(r10);
        if (r11 != kotlin.coroutines.intrinsics.a.d()) goto L10;
        return r11;
    L10:
        return Unit.f21064a;
    }

    public final boolean k(Throwable r10) {
        return l(r10);
    }

    public final Object k0(Object r10, Object r11) {
        if ((r10 instanceof Incomplete) == true) goto L7;
        return l1.a();
    L7:
        if ((r10 instanceof p0) == true) goto L11;
        if ((r10 instanceof k1) == true) goto L11;
    L20:
        return l0((Incomplete) r10, r11);
    L11:
        if ((r10 instanceof s) == true) goto L20;
        if ((r11 instanceof w) == true) goto L20;
        if (i0((Incomplete) r10, r11) == false) goto L18;
        return r11;
    L18:
        return l1.b();
    }

    public final boolean l(Object r10) {
        Object r11 = l1.a();
        if (B() == false) goto L8;
        r11 = n(r10);
        if (r11 != l1.f21639b) goto L8;
        return true;
    L8:
        if (r11 != l1.a()) goto L11;
        r11 = L(r10);
    L11:
        if (r11 != l1.a()) goto L14;
        return true;
    L14:
        if (r11 != l1.f21639b) goto L17;
        return true;
    L17:
        if (r11 != l1.f()) goto L19;
        return false;
    L19:
        h(r11);
        return true;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r2v0 */
    /* JADX WARN: Type inference failed for: r2v1, types: [T, java.lang.Throwable] */
    /* JADX WARN: Type inference failed for: r2v2 */
    public final Object l0(Incomplete r10, Object r11) {
        p1 r12 = C(r10);
        if (r12 == null) goto L5;
        ?? r13 = 0;
        if ((r10 instanceof c) == false) goto L9;
        c r14 = (c) r10;
    L11:
        if (r14 != null) goto L13;
        r14 = new c(r12, false, null);
    L13:
        Ref$ObjectRef r15 = new Ref$ObjectRef();
        monitor-enter(r14);
    L20:
        th = move-exception;
        throw th;
    L16:
        if (r14.f() == false) goto L23;
        kotlinx.coroutines.internal.b0 r16 = l1.a();     // Catch: Throwable -> L20
        monitor-exit(r14);
        return r16;
    L23:
        r14.i(true);     // Catch: Throwable -> L20
        if (r14 != r10) goto L26;
    L30:
        boolean r17 = r14.e();     // Catch: Throwable -> L20
        if ((r11 instanceof w) == false) goto L33;
        w r18 = (w) r11;     // Catch: Throwable -> L20
    L34:
        if (r18 == null) goto L36;
        r14.a(r18.f21768a);     // Catch: Throwable -> L20
    L36:
        Throwable r19 = r14.d();     // Catch: Throwable -> L20
        if (r17 == true) goto L39;
        r13 = r19;
    L39:
        r15.element = r13;     // Catch: Throwable -> L20
        Unit r20 = Unit.f21064a;     // Catch: Throwable -> L20
        monitor-exit(r14);
        if (r13 == 0) goto L43;
        R(r12, r13);
    L43:
        s r21 = v(r10);
        if (r21 == null) goto L50;
        if (m0(r14, r21, r11) == false) goto L50;
        return l1.f21639b;
    L50:
        return u(r14, r11);
    L33:
        r18 = null;
        goto L34
    L26:
        if (androidx.concurrent.futures.a.a(f21284a, this, r10, r14) == true) goto L30;
        kotlinx.coroutines.internal.b0 r22 = l1.b();     // Catch: Throwable -> L20
        monitor-exit(r14);
        return r22;
    L9:
        r14 = null;
        goto L11
    L5:
        return l1.b();
    }

    public void m(Throwable r10) {
        l(r10);
    }

    public final boolean m0(c r10, s r11, Object r12) {
    L3:
        if (Job.a.e(r11.f21673e, false, false, new b(this, r10, r11, r12), 1, null) != r1.f21672a) goto L4;
        r11 = Q(r11);
        if (r11 != null) goto L3;
        return false;
    L4:
        return true;
    }

    @Override // kotlin.coroutines.CoroutineContext.Element, kotlin.coroutines.CoroutineContext
    public CoroutineContext minusKey(CoroutineContext.Key r10) {
        return Job.a.f(this, r10);
    }

    public final Object n(Object r10) {
    L2:
        Object r11 = E();
        if ((r11 instanceof Incomplete) == false) goto L13;
        if ((r11 instanceof c) == true) goto L7;
    L9:
        boolean r12 = false;
        Object r13 = k0(r11, new w(t(r10), r12, 2, null));
        if (r13 == l1.b()) goto L2;
        return r13;
    L7:
        if (((c) r11).f() == false) goto L9;
    L13:
        return l1.a();
    }

    public final boolean o(Throwable r10) {
        if (I() == false) goto L5;
        return true;
    L5:
        boolean r11 = r10 instanceof CancellationException;
        ChildHandle r12 = D();
        if (r12 != null) goto L8;
    L16:
        return r11;
    L8:
        if (r12 == r1.f21672a) goto L16;
        if (r12.childCancelled(r10) == true) goto L17;
        if (r11 == true) goto L18;
        return false;
    L18:
        return true;
    L17:
        return true;
    }

    public String p() {
        return "Job was cancelled";
    }

    @Override // kotlinx.coroutines.ChildJob
    public final void parentCancelled(ParentJob r10) {
        l(r10);
    }

    @Override // kotlin.coroutines.CoroutineContext
    public CoroutineContext plus(CoroutineContext r10) {
        return Job.a.g(this, r10);
    }

    public boolean q(Throwable r10) {
        if ((r10 instanceof CancellationException) == false) goto L6;
        return true;
    L6:
        if (l(r10) == true) goto L8;
    L10:
        return false;
    L8:
        if (z() == false) goto L10;
        return true;
    }

    public final void r(Incomplete r10, Object r11) {
        ChildHandle r12 = D();
        if (r12 == null) goto L5;
        r12.dispose();
        c0(r1.f21672a);
    L5:
        Throwable r13 = null;
        if ((r11 instanceof w) == false) goto L8;
        w r14 = (w) r11;
    L9:
        if (r14 == null) goto L12;
        r13 = r14.f21768a;
    L12:
        if ((r10 instanceof k1) == true) goto L21;
        p1 r15 = r10.getList();
        if (r15 == null) goto L24;
        S(r15, r13);
        return;
    L24:
        return;
    L21:
        ((k1) r10).o(r13);     // Catch: Throwable -> L15
        return;
    L15:
        th = move-exception;
        G(new CompletionHandlerException("Exception in completion handler " + r10 + " for " + this, th));
        return;
    L8:
        r14 = null;
        goto L9
    }

    public final void s(c r10, s r11, Object r12) {
        s r13 = Q(r11);
        if (r13 != null) goto L5;
    L7:
        h(u(r10, r12));
        return;
    L5:
        if (m0(r10, r13, r12) == false) goto L7;
    }

    @Override // kotlinx.coroutines.Job
    public final boolean start() {
    L2:
        int r10 = d0(E());
        if (r10 == 0) goto L8;
        if (r10 != 1) goto L2;
        return true;
    L8:
        return false;
    }

    public final Throwable t(Object r10) {
        if (r10 != null) goto L4;
        boolean r11 = true;
    L5:
        if (r11 == false) goto L9;
        Throwable r12 = (Throwable) r10;
        if (r12 == null) goto L12;
        return r12;
    L12:
        return new JobCancellationException(a(this), null, this);
    L9:
        kotlin.jvm.internal.q.e(r10, "null cannot be cast to non-null type kotlinx.coroutines.ParentJob");
        return ((ParentJob) r10).getChildJobCancellationCause();
    L4:
        r11 = r10 instanceof Throwable;
        goto L5
    }

    public String toString() {
        return h0() + '@' + e0.b(this);
    }

    public final Object u(c r10, Object r11) {
        DefaultConstructorMarker r12 = null;
        if ((r11 instanceof w) == false) goto L5;
        w r13 = (w) r11;
    L6:
        if (r13 == null) goto L8;
        Throwable r14 = r13.f21768a;
    L9:
        monitor-enter(r10);
        boolean r15 = r10.e();     // Catch: Throwable -> L14
        List r16 = r10.h(r14);     // Catch: Throwable -> L14
        Throwable r17 = y(r10, r16);     // Catch: Throwable -> L14
        if (r17 == null) goto L16;
        g(r17, r16);     // Catch: Throwable -> L14
    L16:
        monitor-exit(r10);
        if (r17 == null) goto L22;
        if (r17 == r14) goto L22;
        r11 = new w(r17, false, 2, r12);
    L22:
        if (r17 != null) goto L24;
    L28:
        if (r15 == true) goto L30;
        V(r17);
    L30:
        W(r11);
        androidx.concurrent.futures.a.a(f21284a, this, r10, l1.g(r11));
        r(r10, r11);
        return r11;
    L24:
        if (o(r17) == false) goto L26;
    L27:
        kotlin.jvm.internal.q.e(r11, "null cannot be cast to non-null type kotlinx.coroutines.CompletedExceptionally");
        ((w) r11).b();
        goto L28
    L26:
        if (F(r17) == false) goto L28;
    L14:
        th = move-exception;
        throw th;
    L8:
        r14 = null;
        goto L9
    L5:
        r13 = null;
        goto L6
    }

    public final s v(Incomplete r10) {
        if ((r10 instanceof s) == false) goto L5;
        s r11 = (s) r10;
    L6:
        if (r11 != null) goto L11;
        p1 r12 = r10.getList();
        if (r12 != null) goto L13;
        return null;
    L13:
        return Q(r12);
    L11:
        return r11;
    L5:
        r11 = null;
        goto L6
    }

    public final Object w() {
        Object r10 = E();
        if ((r10 instanceof Incomplete) == true) goto L11;
        if ((r10 instanceof w) == true) goto L9;
        return l1.h(r10);
    L9:
        throw ((w) r10).f21768a;
    L11:
        throw new IllegalStateException("This job has not completed yet");
    }

    public final Throwable x(Object r10) {
        if ((r10 instanceof w) == false) goto L5;
        w r11 = (w) r10;
    L6:
        if (r11 != null) goto L8;
        return null;
    L8:
        return r11.f21768a;
    L5:
        r11 = null;
        goto L6
    }

    public final Throwable y(c r10, List r11) {
        Object r12 = null;
        if (r11.isEmpty() == true) goto L5;
        Iterator r13 = r11.iterator();
    L11:
        if (r13.hasNext() == false) goto L15;
        Object r14 = r13.next();
        if ((((Throwable) r14) instanceof CancellationException) == true) goto L11;
    L16:
        Throwable r15 = (Throwable) r14;
        if (r15 == null) goto L19;
        return r15;
    L19:
        Throwable r16 = (Throwable) r11.get(0);
        if ((r16 instanceof TimeoutCancellationException) == false) goto L32;
        Iterator r17 = r11.iterator();
    L23:
        if (r17.hasNext() == false) goto L29;
        Object r18 = r17.next();
        Throwable r19 = (Throwable) r18;
        if (r19 == r16) goto L23;
        if ((r19 instanceof TimeoutCancellationException) == false) goto L23;
        r12 = r18;
    L29:
        Throwable r20 = (Throwable) r12;
        if (r20 == null) goto L32;
        return r20;
    L32:
        return r16;
    L15:
        r14 = null;
        goto L16
    L5:
        if (r10.e() == true) goto L7;
        return null;
    L7:
        return new JobCancellationException(a(this), null, this);
    }

    public boolean z() {
        return true;
    }

    @Override // kotlinx.coroutines.Job
    public /* synthetic */ boolean cancel(Throwable r10) {
        if (r10 == null) goto L6;
        Throwable r11 = g0(this, r10, null, 1, null);
        if (r11 == null) goto L6;
    L7:
        m(r11);
        return true;
    L6:
        r11 = new JobCancellationException(a(this), null, this);
        goto L7
    }

    @Override // kotlinx.coroutines.Job
    public final DisposableHandle invokeOnCompletion(boolean r10, boolean r11, Function1 r12) {
        k1 r13 = O(r12, r10);
    L3:
        Object r14 = E();
        if ((r14 instanceof p0) == true) goto L5;
        Throwable r15 = null;
        if ((r14 instanceof Incomplete) == false) goto L50;
        p1 r16 = ((Incomplete) r14).getList();
        if (r16 == null) goto L15;
        DisposableHandle r17 = r1.f21672a;
        if (r10 == false) goto L43;
        if ((r14 instanceof c) == false) goto L43;
        monitor-enter(r14);
        r15 = ((c) r14).d();     // Catch: Throwable -> L28
        if (r15 == null) goto L31;
        if ((r12 instanceof s) == false) goto L38;
        if (((c) r14).f() == false) goto L31;
    L38:
        Unit r18 = Unit.f21064a;     // Catch: Throwable -> L28
        monitor-exit(r14);
    L31:
        if (f(r14, r16, r13) == false) goto L32;
        if (r15 == null) goto L35;
        r17 = r13;
        goto L38
    L35:
        monitor-exit(r14);
        return r13;
    L32:
        monitor-exit(r14);
    L28:
        th = move-exception;
        throw th;
    L43:
        if (r15 != null) goto L44;
        if (f(r14, r16, r13) == false) goto L3;
        return r13;
    L44:
        if (r11 == false) goto L46;
        r12.invoke(r15);
    L46:
        return r17;
    L15:
        kotlin.jvm.internal.q.e(r14, "null cannot be cast to non-null type kotlinx.coroutines.JobNode");
        Z((k1) r14);
        goto L3
    L50:
        if (r11 == false) goto L59;
        if ((r14 instanceof w) == false) goto L54;
        w r19 = (w) r14;
    L55:
        if (r19 == null) goto L57;
        r15 = r19.f21768a;
    L57:
        r12.invoke(r15);
        goto L59
    L54:
        r19 = null;
    L59:
        return r1.f21672a;
    L5:
        p0 r20 = (p0) r14;
        if (r20.isActive() == true) goto L8;
        Y(r20);
        goto L3
    L8:
        if (androidx.concurrent.futures.a.a(f21284a, this, r14, r13) == false) goto L3;
        return r13;
    }

    @Override // kotlinx.coroutines.Job
    public Job plus(Job r10) {
        return Job.a.h(this, r10);
    }

    @Override // kotlinx.coroutines.Job
    public void cancel(CancellationException r10) {
        if (r10 != null) goto L4;
        r10 = new JobCancellationException(a(this), null, this);
    L4:
        m(r10);
    }
}
