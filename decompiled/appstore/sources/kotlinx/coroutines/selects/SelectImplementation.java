package kotlinx.coroutines.selects;

import com.bytedance.common.wschannel.WsConstants;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import kotlin.Unit;
import kotlin.collections.b0;
import kotlin.collections.s;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsJvmKt;
import kotlin.jvm.Volatile;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.q;
import kotlinx.coroutines.CancellableContinuation;
import kotlinx.coroutines.DisposableHandle;
import kotlinx.coroutines.internal.y;
import kotlinx.coroutines.l;
import kotlinx.coroutines.n;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes4.dex */
public class SelectImplementation extends l implements SelectBuilder, SelectInstanceInternal {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final AtomicReferenceFieldUpdater f21700f = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final CoroutineContext f21701a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public List f21702b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public Object f21703c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f21704d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public Object f21705e;

    @Volatile
    @Nullable
    private volatile Object state;

    public final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Object f21706a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final Function3 f21707b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final Function3 f21708c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final Object f21709d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final Object f21710e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final Function3 f21711f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public Object f21712g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public int f21713h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public final /* synthetic */ SelectImplementation f21714i;

        public a(SelectImplementation r10, Object r11, Function3 r12, Function3 r13, Object r14, Object r15, Function3 r16) {
            this.f21714i = r10;
            this.f21706a = r11;
            this.f21707b = r12;
            this.f21708c = r13;
            this.f21709d = r14;
            this.f21710e = r15;
            this.f21711f = r16;
            this.f21713h = -1;
        }

        public final Function1 a(SelectInstance r10, Object r11) {
            Function3 r12 = this.f21711f;
            if (r12 != null) goto L7;
            return null;
        L7:
            return (Function1) r12.invoke(r10, this.f21709d, r11);
        }

        public final void b() {
            Object r10 = this.f21712g;
            SelectImplementation r11 = this.f21714i;
            DisposableHandle r12 = null;
            if ((r10 instanceof y) == false) goto L6;
            ((y) r10).o(this.f21713h, null, r11.getContext());
            return;
        L6:
            if ((r10 instanceof DisposableHandle) == false) goto L8;
            r12 = (DisposableHandle) r10;
        L8:
            if (r12 == null) goto L12;
            r12.dispose();
            return;
        }

        public final Object c(Object r10, Continuation r11) {
            Object r12 = this.f21710e;
            if (this.f21709d != SelectKt.i()) goto L6;
            q.e(r12, "null cannot be cast to non-null type kotlin.coroutines.SuspendFunction0<R of kotlinx.coroutines.selects.SelectImplementation>");
            return ((Function1) r12).invoke(r11);
        L6:
            q.e(r12, "null cannot be cast to non-null type kotlin.coroutines.SuspendFunction1<kotlin.Any?, R of kotlinx.coroutines.selects.SelectImplementation>");
            return ((Function2) r12).mo0invoke(r10, r11);
        }

        public final Object d(Object r10) {
            return this.f21708c.invoke(this.f21706a, this.f21709d, r10);
        }

        public final boolean e(SelectImplementation r10) {
            this.f21707b.invoke(this.f21706a, r10, this.f21709d);
            if (SelectImplementation.c(r10) != SelectKt.d()) goto L5;
            return true;
        L5:
            return false;
        }
    }

    static {
        f21700f = AtomicReferenceFieldUpdater.newUpdater(SelectImplementation.class, Object.class, WsConstants.KEY_CONNECTION_STATE);
    }

    public SelectImplementation(CoroutineContext r10) {
        this.f21701a = r10;
        this.state = SelectKt.g();
        this.f21702b = new ArrayList(2);
        this.f21704d = -1;
        this.f21705e = SelectKt.d();
    }

    public static final /* synthetic */ Object b(SelectImplementation r10, Continuation r11) {
        return r10.l(r11);
    }

    public static final /* synthetic */ Object c(SelectImplementation r10) {
        return r10.f21705e;
    }

    public static final /* synthetic */ AtomicReferenceFieldUpdater d() {
        return f21700f;
    }

    public static final /* synthetic */ Object e(SelectImplementation r10, a r11, Object r12, Continuation r13) {
        return r10.o(r11, r12, r13);
    }

    public static final /* synthetic */ void f(SelectImplementation r10, Object r11) {
        r10.r(r11);
    }

    public static /* synthetic */ Object k(SelectImplementation r10, Continuation r11) {
        if (r10.n() == false) goto L7;
        return r10.i(r11);
    L7:
        return r10.l(r11);
    }

    private final boolean n() {
        return f21700f.get(this) instanceof a;
    }

    public static /* synthetic */ void q(SelectImplementation r10, a r11, boolean r12, int r13, Object r14) {
        if (r14 != null) goto L9;
        if ((r13 & 1) == 0) goto L6;
        r12 = false;
    L6:
        r10.p(r11, r12);
        return;
    L9:
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: register");
    }

    @Override // kotlinx.coroutines.m
    public void a(Throwable r10) {
        AtomicReferenceFieldUpdater r11 = f21700f;
    L3:
        Object r12 = r11.get(this);
        if (r12 == SelectKt.f()) goto L5;
        if (androidx.concurrent.futures.a.a(r11, this, r12, SelectKt.e()) == false) goto L3;
        List r13 = this.f21702b;
        if (r13 != null) goto L11;
        return;
    L11:
        Iterator r14 = r13.iterator();
    L13:
        if (r14.hasNext() == false) goto L15;
        ((a) r14.next()).b();
        goto L13
    L15:
        this.f21705e = SelectKt.d();
        this.f21702b = null;
        return;
    }

    @Override // kotlinx.coroutines.selects.SelectInstance
    public void disposeOnCompletion(DisposableHandle r10) {
        this.f21703c = r10;
    }

    public final void g(Object r10) {
        List r11 = this.f21702b;
        q.d(r11);
        if (r11 != null) goto L5;
    L7:
        Iterator r12 = r11.iterator();
    L9:
        if (r12.hasNext() == false) goto L19;
        if (((a) r12.next()).f21706a != r10) goto L9;
        throw new IllegalStateException(("Cannot use select clauses on the same object: " + r10).toString());
    L19:
        return;
    L5:
        if (r11.isEmpty() == false) goto L7;
    }

    @Override // kotlinx.coroutines.selects.SelectInstance
    public CoroutineContext getContext() {
        return this.f21701a;
    }

    public final void h(a r10) {
        List r11 = this.f21702b;
        if (r11 != null) goto L5;
        return;
    L5:
        Iterator r12 = r11.iterator();
    L7:
        if (r12.hasNext() == false) goto L11;
        a r13 = (a) r12.next();
        if (r13 == r10) goto L7;
        r13.b();
        goto L7
    L11:
        f21700f.set(this, SelectKt.f());
        this.f21705e = SelectKt.d();
        this.f21702b = null;
    }

    public final Object i(Continuation r10) {
        Object r11 = f21700f.get(this);
        q.e(r11, "null cannot be cast to non-null type kotlinx.coroutines.selects.SelectImplementation.ClauseData<R of kotlinx.coroutines.selects.SelectImplementation>");
        a r12 = (a) r11;
        Object r13 = this.f21705e;
        h(r12);
        return r12.c(r12.d(r13), r10);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Object invoke(Object r10) {
        a((Throwable) r10);
        return Unit.f21064a;
    }

    @Override // kotlinx.coroutines.Waiter
    public void invokeOnCancellation(y r10, int r11) {
        this.f21703c = r10;
        this.f21704d = r11;
    }

    public Object j(Continuation r10) {
        return k(this, r10);
    }

    public final Object l(Continuation r10) {
        if ((r10 instanceof SelectImplementation$doSelectSuspend$1) == false) goto L7;
        SelectImplementation$doSelectSuspend$1 r11 = (SelectImplementation$doSelectSuspend$1) r10;
        int r12 = r11.label;
        if ((r12 & Integer.MIN_VALUE) == 0) goto L7;
        r11.label = r12 - Integer.MIN_VALUE;
    L8:
        Object r13 = r11.result;
        Object r14 = kotlin.coroutines.intrinsics.a.d();
        int r15 = r11.label;
        if (r15 == 0) goto L16;
        if (r15 == 1) goto L15;
        if (r15 != 2) goto L14;
        kotlin.c.b(r13);
    L22:
        return r13;
    L14:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L15:
        SelectImplementation this = (SelectImplementation) r11.L$0;
        kotlin.c.b(r13);
    L19:
        r11.L$0 = null;
        r11.label = 2;
        r13 = this.i(r11);
        if (r13 != r14) goto L22;
        return r14;
    L16:
        kotlin.c.b(r13);
        r11.L$0 = this;
        r11.label = 1;
        if (u(r11) != r14) goto L19;
        return r14;
    L7:
        r11 = new SelectImplementation$doSelectSuspend$1(this, r10);
        goto L8
    }

    public final a m(Object r10) {
        List r11 = this.f21702b;
        Object r12 = null;
        if (r11 != null) goto L5;
        return null;
    L5:
        Iterator r13 = r11.iterator();
    L7:
        if (r13.hasNext() == false) goto L11;
        Object r14 = r13.next();
        if (((a) r14).f21706a != r10) goto L7;
        r12 = r14;
    L11:
        a r15 = (a) r12;
        if (r15 == null) goto L15;
        return r15;
    L15:
        throw new IllegalStateException(("Clause with object " + r10 + " is not found").toString());
    }

    public final Object o(a r10, Object r11, Continuation r12) {
        if ((r12 instanceof SelectImplementation$processResultAndInvokeBlockRecoveringException$1) == false) goto L7;
        SelectImplementation$processResultAndInvokeBlockRecoveringException$1 r13 = (SelectImplementation$processResultAndInvokeBlockRecoveringException$1) r12;
        int r14 = r13.label;
        if ((r14 & Integer.MIN_VALUE) == 0) goto L7;
        r13.label = r14 - Integer.MIN_VALUE;
    L8:
        Object r15 = r13.result;
        Object r16 = kotlin.coroutines.intrinsics.a.d();
        int r17 = r13.label;
        if (r17 == 0) goto L14;
        if (r17 != 1) goto L13;
        kotlin.c.b(r15);
    L17:
        return r15;
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        kotlin.c.b(r15);
        Object r18 = r10.d(r11);
        r13.label = 1;
        r15 = r10.c(r18, r13);
        if (r15 != r16) goto L17;
        return r16;
    L7:
        r13 = new SelectImplementation$processResultAndInvokeBlockRecoveringException$1(this, r12);
        goto L8
    }

    @Override // kotlinx.coroutines.selects.SelectBuilder
    public void onTimeout(long r10, Function1 r11) {
        SelectBuilder.a.b(this, r10, r11);
    }

    public final void p(a r10, boolean r11) {
        AtomicReferenceFieldUpdater r12 = f21700f;
        if ((r12.get(this) instanceof a) == false) goto L5;
        return;
    L5:
        if (r11 == true) goto L8;
        g(r10.f21706a);
    L8:
        if (r10.e(this) == false) goto L12;
        if (r11 == true) goto L11;
        List r13 = this.f21702b;
        q.d(r13);
        r13.add(r10);
    L11:
        r10.f21712g = this.f21703c;
        r10.f21713h = this.f21704d;
        this.f21703c = null;
        this.f21704d = -1;
        return;
    L12:
        r12.set(this, r10);
    }

    public final void r(Object r10) {
        a r11 = m(r10);
        q.d(r11);
        r11.f21712g = null;
        r11.f21713h = -1;
        p(r11, true);
    }

    public final TrySelectDetailedResult s(Object r10, Object r11) {
        return SelectKt.b(t(r10, r11));
    }

    @Override // kotlinx.coroutines.selects.SelectInstance
    public void selectInRegistrationPhase(Object r10) {
        this.f21705e = r10;
    }

    public final int t(Object r10, Object r11) {
    L2:
        AtomicReferenceFieldUpdater r12 = f21700f;
        Object r13 = r12.get(this);
        if ((r13 instanceof CancellableContinuation) == true) goto L4;
        if (q.b(r13, SelectKt.f()) == false) goto L18;
        boolean r14 = true;
    L19:
        if (r14 == true) goto L20;
        if (q.b(r13, SelectKt.e()) == true) goto L24;
        if (q.b(r13, SelectKt.g()) == true) goto L28;
        if ((r13 instanceof List) == false) goto L36;
        if (androidx.concurrent.futures.a.a(r12, this, r13, b0.o0((Collection) r13, r10)) == false) goto L2;
        return 1;
    L36:
        throw new IllegalStateException(("Unexpected state: " + r13).toString());
    L28:
        if (androidx.concurrent.futures.a.a(r12, this, r13, s.e(r10)) == false) goto L2;
        return 1;
    L24:
        return 2;
    L20:
        return 3;
    L18:
        r14 = r13 instanceof a;
        goto L19
    L4:
        a r15 = m(r10);
        if (r15 == null) goto L2;
        Function1 r16 = r15.a(this, r11);
        if (androidx.concurrent.futures.a.a(r12, this, r13, r15) == false) goto L2;
        this.f21705e = r11;
        if (SelectKt.h((CancellableContinuation) r13, r16) == false) goto L13;
        return 0;
    L13:
        this.f21705e = null;
        return 2;
    }

    @Override // kotlinx.coroutines.selects.SelectInstance
    public boolean trySelect(Object r10, Object r11) {
        if (t(r10, r11) != 0) goto L5;
        return true;
    L5:
        return false;
    }

    public final Object u(Continuation r10) {
        n r11 = new n(IntrinsicsKt__IntrinsicsJvmKt.c(r10), 1);
        r11.initCancellability();
        AtomicReferenceFieldUpdater r12 = d();
    L3:
        Object r13 = r12.get(this);
        if (r13 == SelectKt.g()) goto L6;
        if ((r13 instanceof List) == false) goto L17;
        if (androidx.concurrent.futures.a.a(d(), this, r13, SelectKt.g()) == false) goto L3;
        Iterator r14 = ((Iterable) r13).iterator();
    L14:
        if (r14.hasNext() == false) goto L3;
        f(this, r14.next());
        goto L14
    L17:
        if ((r13 instanceof a) == false) goto L28;
        r11.resume(Unit.f21064a, ((a) r13).a(this, c(this)));
    L19:
        Object r15 = r11.q();
        if (r15 != kotlin.coroutines.intrinsics.a.d()) goto L23;
        tf.d.c(r10);
    L23:
        if (r15 != kotlin.coroutines.intrinsics.a.d()) goto L26;
        return r15;
    L26:
        return Unit.f21064a;
    L28:
        throw new IllegalStateException(("unexpected state: " + r13).toString());
    L6:
        if (androidx.concurrent.futures.a.a(d(), this, r13, r11) == false) goto L3;
        r11.invokeOnCancellation(this);
        goto L19
    }

    @Override // kotlinx.coroutines.selects.SelectBuilder
    public void invoke(SelectClause2 r10, Function2 r11) {
        SelectBuilder.a.a(this, r10, r11);
    }

    @Override // kotlinx.coroutines.selects.SelectBuilder
    public void invoke(SelectClause0 r10, Function1 r11) {
        q(this, new a(this, r10.getClauseObject(), r10.getRegFunc(), r10.getProcessResFunc(), SelectKt.i(), r11, r10.getOnCancellationConstructor()), false, 1, null);
    }

    @Override // kotlinx.coroutines.selects.SelectBuilder
    public void invoke(SelectClause1 r10, Function2 r11) {
        q(this, new a(this, r10.getClauseObject(), r10.getRegFunc(), r10.getProcessResFunc(), null, r11, r10.getOnCancellationConstructor()), false, 1, null);
    }

    @Override // kotlinx.coroutines.selects.SelectBuilder
    public void invoke(SelectClause2 r10, Object r11, Function2 r12) {
        q(this, new a(this, r10.getClauseObject(), r10.getRegFunc(), r10.getProcessResFunc(), r11, r12, r10.getOnCancellationConstructor()), false, 1, null);
    }
}
