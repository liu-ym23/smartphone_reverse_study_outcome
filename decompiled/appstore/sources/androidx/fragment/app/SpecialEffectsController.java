package androidx.fragment.app;

import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import androidx.core.os.CancellationSignal;
import androidx.core.view.ViewCompat;
import androidx.fragment.R$id;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.ListIterator;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: classes.dex */
public abstract class SpecialEffectsController {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final a f3277f = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ViewGroup f3278a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final List f3279b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final List f3280c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public boolean f3281d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public boolean f3282e;

    public static class Operation {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public State f3283a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public LifecycleImpact f3284b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final Fragment f3285c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final List f3286d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final Set f3287e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public boolean f3288f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public boolean f3289g;

        @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0080\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Landroidx/fragment/app/SpecialEffectsController$Operation$LifecycleImpact;", "", "(Ljava/lang/String;I)V", "NONE", "ADDING", "REMOVING", "fragment_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
        public static final enum LifecycleImpact extends Enum<LifecycleImpact> {
            private static final /* synthetic */ LifecycleImpact[] $VALUES = null;
            public static final LifecycleImpact ADDING = null;
            public static final LifecycleImpact NONE = null;
            public static final LifecycleImpact REMOVING = null;

            private static final /* synthetic */ LifecycleImpact[] $values() {
                return new LifecycleImpact[]{NONE, ADDING, REMOVING};
            }

            static {
                NONE = new LifecycleImpact("NONE", 0);
                ADDING = new LifecycleImpact("ADDING", 1);
                REMOVING = new LifecycleImpact("REMOVING", 2);
                $VALUES = $values();
            }

            private LifecycleImpact(String r10, int r11) {
                super(r10, r11);
            }

            public static LifecycleImpact valueOf(String r10) {
                return (LifecycleImpact) Enum.valueOf(LifecycleImpact.class, r10);
            }

            public static LifecycleImpact[] values() {
                return (LifecycleImpact[]) $VALUES.clone();
            }
        }

        @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\t\b\u0080\u0001\u0018\u0000 \t2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\nB\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0015\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0007\u0010\bj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000e¨\u0006\u000f"}, d2 = {"Landroidx/fragment/app/SpecialEffectsController$Operation$State;", "", "<init>", "(Ljava/lang/String;I)V", "Landroid/view/View;", "view", "", "applyState", "(Landroid/view/View;)V", "Companion", "a", "REMOVED", "VISIBLE", "GONE", "INVISIBLE", "fragment_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
        public static final enum State extends Enum<State> {
            private static final /* synthetic */ State[] $VALUES = null;

            @NotNull
            public static final a Companion = null;
            public static final State GONE = null;
            public static final State INVISIBLE = null;
            public static final State REMOVED = null;
            public static final State VISIBLE = null;

            public static final class a {
                public /* synthetic */ a(DefaultConstructorMarker r10) {
                    this();
                }

                public final State a(View r10) {
                    kotlin.jvm.internal.q.g(r10, "<this>");
                    if (r10.getAlpha() != 0.0f) goto L8;
                    if (r10.getVisibility() != 0) goto L8;
                    return State.INVISIBLE;
                L8:
                    return b(r10.getVisibility());
                }

                public final State b(int r10) {
                    if (r10 == 0) goto L12;
                    if (r10 == 4) goto L14;
                    if (r10 != 8) goto L9;
                    return State.GONE;
                L9:
                    throw new IllegalArgumentException("Unknown visibility " + r10);
                L14:
                    return State.INVISIBLE;
                L12:
                    return State.VISIBLE;
                }

                public a() {
                }
            }

            public /* synthetic */ class b {

                /* JADX INFO: renamed from: a, reason: collision with root package name */
                public static final /* synthetic */ int[] f3290a = null;

                static {
                    int[] r10 = new int[State.values().length];
                    r10[State.REMOVED.ordinal()] = 1;     // Catch: NoSuchFieldError -> L9
                L13:
                    r10[State.VISIBLE.ordinal()] = 2;     // Catch: NoSuchFieldError -> L10
                L19:
                    r10[State.GONE.ordinal()] = 3;     // Catch: NoSuchFieldError -> L11
                L15:
                    r10[State.INVISIBLE.ordinal()] = 4;     // Catch: NoSuchFieldError -> L12
                L7:
                    f3290a = r10;
                }
            }

            private static final /* synthetic */ State[] $values() {
                return new State[]{REMOVED, VISIBLE, GONE, INVISIBLE};
            }

            static {
                REMOVED = new State("REMOVED", 0);
                VISIBLE = new State("VISIBLE", 1);
                GONE = new State("GONE", 2);
                INVISIBLE = new State("INVISIBLE", 3);
                $VALUES = $values();
                Companion = new a(null);
            }

            private State(String r10, int r11) {
                super(r10, r11);
            }

            @JvmStatic
            @NotNull
            public static final State from(int r10) {
                return Companion.b(r10);
            }

            public static State valueOf(String r10) {
                return (State) Enum.valueOf(State.class, r10);
            }

            public static State[] values() {
                return (State[]) $VALUES.clone();
            }

            public final void applyState(@NotNull View r10) {
                kotlin.jvm.internal.q.g(r10, "view");
                int r11 = b.f3290a[ordinal()];
                if (r11 != 1) goto L5;
                ViewParent r12 = r10.getParent();
                if ((r12 instanceof ViewGroup) == false) goto L26;
                ViewGroup r13 = (ViewGroup) r12;
            L27:
                if (r13 != null) goto L29;
                return;
            L29:
                if (FragmentManager.L0(2) == false) goto L31;
                Log.v("FragmentManager", "SpecialEffectsController: Removing view " + r10 + " from container " + r13);
            L31:
                r13.removeView(r10);
                return;
            L26:
                r13 = null;
                goto L27
            L5:
                if (r11 == 2) goto L20;
                if (r11 == 3) goto L16;
                if (r11 == 4) goto L12;
                return;
            L12:
                if (FragmentManager.L0(2) == false) goto L14;
                Log.v("FragmentManager", "SpecialEffectsController: Setting view " + r10 + " to INVISIBLE");
            L14:
                r10.setVisibility(4);
                return;
            L16:
                if (FragmentManager.L0(2) == false) goto L18;
                Log.v("FragmentManager", "SpecialEffectsController: Setting view " + r10 + " to GONE");
            L18:
                r10.setVisibility(8);
                return;
            L20:
                if (FragmentManager.L0(2) == false) goto L22;
                Log.v("FragmentManager", "SpecialEffectsController: Setting view " + r10 + " to VISIBLE");
            L22:
                r10.setVisibility(0);
            }
        }

        public /* synthetic */ class a {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public static final /* synthetic */ int[] f3291a = null;

            static {
                int[] r10 = new int[LifecycleImpact.values().length];
                r10[LifecycleImpact.ADDING.ordinal()] = 1;     // Catch: NoSuchFieldError -> L8
            L11:
                r10[LifecycleImpact.REMOVING.ordinal()] = 2;     // Catch: NoSuchFieldError -> L9
            L15:
                r10[LifecycleImpact.NONE.ordinal()] = 3;     // Catch: NoSuchFieldError -> L10
            L6:
                f3291a = r10;
            }
        }

        public Operation(State r10, LifecycleImpact r11, Fragment r12, CancellationSignal r13) {
            kotlin.jvm.internal.q.g(r10, "finalState");
            kotlin.jvm.internal.q.g(r11, "lifecycleImpact");
            kotlin.jvm.internal.q.g(r12, "fragment");
            kotlin.jvm.internal.q.g(r13, "cancellationSignal");
            this.f3283a = r10;
            this.f3284b = r11;
            this.f3285c = r12;
            this.f3286d = new ArrayList();
            this.f3287e = new LinkedHashSet();
            r13.setOnCancelListener(new j0(this));
        }

        public static /* synthetic */ void a(Operation r10) {
            b(r10);
        }

        public static final void b(Operation r10) {
            kotlin.jvm.internal.q.g(r10, "this$0");
            r10.d();
        }

        public final void c(Runnable r10) {
            kotlin.jvm.internal.q.g(r10, "listener");
            this.f3286d.add(r10);
        }

        public final void d() {
            if (this.f3288f == false) goto L5;
            return;
        L5:
            this.f3288f = true;
            if (this.f3287e.isEmpty() == false) goto L8;
            e();
            return;
        L8:
            Iterator r10 = kotlin.collections.b0.A0(this.f3287e).iterator();
        L10:
            if (r10.hasNext() == false) goto L14;
            ((CancellationSignal) r10.next()).a();
            goto L10
        }

        public void e() {
            if (this.f3289g == false) goto L6;
            return;
        L6:
            if (FragmentManager.L0(2) == false) goto L8;
            Log.v("FragmentManager", "SpecialEffectsController: " + this + " has called complete.");
        L8:
            this.f3289g = true;
            Iterator r10 = this.f3286d.iterator();
        L10:
            if (r10.hasNext() == false) goto L12;
            ((Runnable) r10.next()).run();
            goto L10
        }

        public final void f(CancellationSignal r10) {
            kotlin.jvm.internal.q.g(r10, "signal");
            if (this.f3287e.remove(r10) == true) goto L5;
            return;
        L5:
            if (this.f3287e.isEmpty() == false) goto L9;
            e();
            return;
        }

        public final State g() {
            return this.f3283a;
        }

        public final Fragment h() {
            return this.f3285c;
        }

        public final LifecycleImpact i() {
            return this.f3284b;
        }

        public final boolean j() {
            return this.f3288f;
        }

        public final boolean k() {
            return this.f3289g;
        }

        public final void l(CancellationSignal r10) {
            kotlin.jvm.internal.q.g(r10, "signal");
            n();
            this.f3287e.add(r10);
        }

        public final void m(State r10, LifecycleImpact r11) {
            kotlin.jvm.internal.q.g(r10, "finalState");
            kotlin.jvm.internal.q.g(r11, "lifecycleImpact");
            int r12 = a.f3291a[r11.ordinal()];
            if (r12 == 1) goto L20;
            if (r12 == 2) goto L16;
            if (r12 == 3) goto L10;
            return;
        L10:
            if (this.f3283a != State.REMOVED) goto L12;
            return;
        L12:
            if (FragmentManager.L0(2) == false) goto L14;
            Log.v("FragmentManager", "SpecialEffectsController: For fragment " + this.f3285c + " mFinalState = " + this.f3283a + " -> " + r10 + '.');
        L14:
            this.f3283a = r10;
            return;
        L16:
            if (FragmentManager.L0(2) == false) goto L18;
            Log.v("FragmentManager", "SpecialEffectsController: For fragment " + this.f3285c + " mFinalState = " + this.f3283a + " -> REMOVED. mLifecycleImpact  = " + this.f3284b + " to REMOVING.");
        L18:
            this.f3283a = State.REMOVED;
            this.f3284b = LifecycleImpact.REMOVING;
            return;
        L20:
            if (this.f3283a == State.REMOVED) goto L22;
            return;
        L22:
            if (FragmentManager.L0(2) == false) goto L24;
            Log.v("FragmentManager", "SpecialEffectsController: For fragment " + this.f3285c + " mFinalState = REMOVED -> VISIBLE. mLifecycleImpact = " + this.f3284b + " to ADDING.");
        L24:
            this.f3283a = State.VISIBLE;
            this.f3284b = LifecycleImpact.ADDING;
        }

        public abstract void n();

        public String toString() {
            return "Operation {" + Integer.toHexString(System.identityHashCode(this)) + "} {finalState = " + this.f3283a + " lifecycleImpact = " + this.f3284b + " fragment = " + this.f3285c + '}';
        }
    }

    public static final class a {
        public /* synthetic */ a(DefaultConstructorMarker r10) {
            this();
        }

        public final SpecialEffectsController a(ViewGroup r10, FragmentManager r11) {
            kotlin.jvm.internal.q.g(r10, "container");
            kotlin.jvm.internal.q.g(r11, "fragmentManager");
            SpecialEffectsControllerFactory r12 = r11.D0();
            kotlin.jvm.internal.q.f(r12, "fragmentManager.specialEffectsControllerFactory");
            return b(r10, r12);
        }

        public final SpecialEffectsController b(ViewGroup r10, SpecialEffectsControllerFactory r11) {
            kotlin.jvm.internal.q.g(r10, "container");
            kotlin.jvm.internal.q.g(r11, "factory");
            int r12 = R$id.special_effects_controller_view_tag;
            Object r13 = r10.getTag(r12);
            if ((r13 instanceof SpecialEffectsController) == true) goto L5;
            SpecialEffectsController r14 = r11.createController(r10);
            kotlin.jvm.internal.q.f(r14, "factory.createController(container)");
            r10.setTag(r12, r14);
            return r14;
        L5:
            return (SpecialEffectsController) r13;
        }

        public a() {
        }
    }

    public static final class b extends Operation {

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public final a0 f3292h;

        public b(Operation.State r10, Operation.LifecycleImpact r11, a0 r12, CancellationSignal r13) {
            kotlin.jvm.internal.q.g(r10, "finalState");
            kotlin.jvm.internal.q.g(r11, "lifecycleImpact");
            kotlin.jvm.internal.q.g(r12, "fragmentStateManager");
            kotlin.jvm.internal.q.g(r13, "cancellationSignal");
            Fragment r14 = r12.k();
            kotlin.jvm.internal.q.f(r14, "fragmentStateManager.fragment");
            super(r10, r11, r14, r13);
            this.f3292h = r12;
        }

        @Override // androidx.fragment.app.SpecialEffectsController.Operation
        public void e() {
            super.e();
            this.f3292h.m();
        }

        @Override // androidx.fragment.app.SpecialEffectsController.Operation
        public void n() {
            if (i() != Operation.LifecycleImpact.ADDING) goto L19;
            Fragment r10 = this.f3292h.k();
            kotlin.jvm.internal.q.f(r10, "fragmentStateManager.fragment");
            View r11 = r10.mView.findFocus();
            if (r11 == null) goto L9;
            r10.setFocusedView(r11);
            if (FragmentManager.L0(2) == false) goto L9;
            Log.v("FragmentManager", "requestFocus: Saved focused view " + r11 + " for Fragment " + r10);
        L9:
            View r12 = h().requireView();
            kotlin.jvm.internal.q.f(r12, "this.fragment.requireView()");
            if (r12.getParent() != null) goto L13;
            this.f3292h.b();
            r12.setAlpha(0.0f);
        L13:
            if (r12.getAlpha() == 0.0f) goto L15;
        L17:
            r12.setAlpha(r10.getPostOnViewCreatedAlpha());
            return;
        L15:
            if (r12.getVisibility() != 0) goto L17;
            r12.setVisibility(4);
            goto L17
        L19:
            if (i() != Operation.LifecycleImpact.REMOVING) goto L26;
            Fragment r13 = this.f3292h.k();
            kotlin.jvm.internal.q.f(r13, "fragmentStateManager.fragment");
            View r14 = r13.requireView();
            kotlin.jvm.internal.q.f(r14, "fragment.requireView()");
            if (FragmentManager.L0(2) == false) goto L23;
            Log.v("FragmentManager", "Clearing focus " + r14.findFocus() + " on view " + r14 + " for Fragment " + r13);
        L23:
            r14.clearFocus();
            return;
        }
    }

    public /* synthetic */ class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f3293a = null;

        static {
            int[] r10 = new int[Operation.LifecycleImpact.values().length];
            r10[Operation.LifecycleImpact.NONE.ordinal()] = 1;     // Catch: NoSuchFieldError -> L6
        L4:
            f3293a = r10;
        }
    }

    static {
        f3277f = new a(null);
    }

    public SpecialEffectsController(ViewGroup r10) {
        kotlin.jvm.internal.q.g(r10, "container");
        this.f3278a = r10;
        this.f3279b = new ArrayList();
        this.f3280c = new ArrayList();
    }

    public static /* synthetic */ void a(SpecialEffectsController r10, b r11) {
        d(r10, r11);
    }

    public static /* synthetic */ void b(SpecialEffectsController r10, b r11) {
        e(r10, r11);
    }

    public static final void d(SpecialEffectsController r10, b r11) {
        kotlin.jvm.internal.q.g(r10, "this$0");
        kotlin.jvm.internal.q.g(r11, "$operation");
        if (r10.f3279b.contains(r11) == false) goto L6;
        Operation.State r12 = r11.g();
        View r13 = r11.h().mView;
        kotlin.jvm.internal.q.f(r13, "operation.fragment.mView");
        r12.applyState(r13);
        return;
    }

    public static final void e(SpecialEffectsController r10, b r11) {
        kotlin.jvm.internal.q.g(r10, "this$0");
        kotlin.jvm.internal.q.g(r11, "$operation");
        r10.f3279b.remove(r11);
        r10.f3280c.remove(r11);
    }

    public static final SpecialEffectsController r(ViewGroup r10, FragmentManager r11) {
        return f3277f.a(r10, r11);
    }

    public static final SpecialEffectsController s(ViewGroup r10, SpecialEffectsControllerFactory r11) {
        return f3277f.b(r10, r11);
    }

    public final void c(Operation.State r10, Operation.LifecycleImpact r11, a0 r12) {
        List r13 = this.f3279b;
        monitor-enter(r13);
        CancellationSignal r14 = new CancellationSignal();     // Catch: Throwable -> L9
        Fragment r15 = r12.k();     // Catch: Throwable -> L9
        kotlin.jvm.internal.q.f(r15, "fragmentStateManager.fragment");     // Catch: Throwable -> L9
        Operation r16 = l(r15);     // Catch: Throwable -> L9
        if (r16 == null) goto L11;
        r16.m(r10, r11);     // Catch: Throwable -> L9
        monitor-exit(r13);
        return;
    L11:
        final b r17 = new b(r10, r11, r12, r14);     // Catch: Throwable -> L9
        this.f3279b.add(r17);     // Catch: Throwable -> L9
        r17.c(new h0(this, r17));     // Catch: Throwable -> L9
        r17.c(new i0(this, r17));     // Catch: Throwable -> L9
        Unit r18 = Unit.f21064a;     // Catch: Throwable -> L9
        monitor-exit(r13);
        return;
    L9:
        th = move-exception;
        throw th;
    }

    public final void f(Operation.State r10, a0 r11) {
        kotlin.jvm.internal.q.g(r10, "finalState");
        kotlin.jvm.internal.q.g(r11, "fragmentStateManager");
        if (FragmentManager.L0(2) == false) goto L5;
        Log.v("FragmentManager", "SpecialEffectsController: Enqueuing add operation for fragment " + r11.k());
    L5:
        c(r10, Operation.LifecycleImpact.ADDING, r11);
    }

    public final void g(a0 r10) {
        kotlin.jvm.internal.q.g(r10, "fragmentStateManager");
        if (FragmentManager.L0(2) == false) goto L5;
        Log.v("FragmentManager", "SpecialEffectsController: Enqueuing hide operation for fragment " + r10.k());
    L5:
        c(Operation.State.GONE, Operation.LifecycleImpact.NONE, r10);
    }

    public final void h(a0 r10) {
        kotlin.jvm.internal.q.g(r10, "fragmentStateManager");
        if (FragmentManager.L0(2) == false) goto L5;
        Log.v("FragmentManager", "SpecialEffectsController: Enqueuing remove operation for fragment " + r10.k());
    L5:
        c(Operation.State.REMOVED, Operation.LifecycleImpact.REMOVING, r10);
    }

    public final void i(a0 r10) {
        kotlin.jvm.internal.q.g(r10, "fragmentStateManager");
        if (FragmentManager.L0(2) == false) goto L5;
        Log.v("FragmentManager", "SpecialEffectsController: Enqueuing show operation for fragment " + r10.k());
    L5:
        c(Operation.State.VISIBLE, Operation.LifecycleImpact.NONE, r10);
    }

    public abstract void j(List r10, boolean r11);

    public final void k() {
        if (this.f3282e == false) goto L6;
        return;
    L6:
        if (ViewCompat.S(this.f3278a) == true) goto L9;
        n();
        this.f3281d = false;
        return;
    L9:
        List r10 = this.f3279b;
        monitor-enter(r10);
    L19:
        th = move-exception;
        throw th;
    L12:
        if (this.f3279b.isEmpty() == true) goto L34;
        List r11 = kotlin.collections.b0.z0(this.f3280c);     // Catch: Throwable -> L19
        this.f3280c.clear();     // Catch: Throwable -> L19
        Iterator r12 = r11.iterator();     // Catch: Throwable -> L19
    L15:
        if (r12.hasNext() == false) goto L24;
        Operation r13 = (Operation) r12.next();     // Catch: Throwable -> L19
        if (FragmentManager.L0(2) == false) goto L21;
        Log.v("FragmentManager", "SpecialEffectsController: Cancelling operation " + r13);     // Catch: Throwable -> L19
    L21:
        r13.d();     // Catch: Throwable -> L19
        if (r13.k() == true) goto L15;
        this.f3280c.add(r13);     // Catch: Throwable -> L19
        goto L15
    L24:
        u();     // Catch: Throwable -> L19
        List r14 = kotlin.collections.b0.z0(this.f3279b);     // Catch: Throwable -> L19
        this.f3279b.clear();     // Catch: Throwable -> L19
        this.f3280c.addAll(r14);     // Catch: Throwable -> L19
        if (FragmentManager.L0(2) == false) goto L27;
        Log.v("FragmentManager", "SpecialEffectsController: Executing pending operations");     // Catch: Throwable -> L19
    L27:
        Iterator r15 = r14.iterator();     // Catch: Throwable -> L19
    L29:
        if (r15.hasNext() == false) goto L31;
        ((Operation) r15.next()).n();     // Catch: Throwable -> L19
        goto L29
    L31:
        j(r14, this.f3281d);     // Catch: Throwable -> L19
        this.f3281d = false;     // Catch: Throwable -> L19
        if (FragmentManager.L0(2) == false) goto L34;
        Log.v("FragmentManager", "SpecialEffectsController: Finished executing pending operations");     // Catch: Throwable -> L19
    L34:
        Unit r16 = Unit.f21064a;     // Catch: Throwable -> L19
        monitor-exit(r10);
    }

    public final Operation l(Fragment r10) {
        Iterator r11 = this.f3279b.iterator();
    L4:
        if (r11.hasNext() == false) goto L10;
        Object r12 = r11.next();
        Operation r13 = (Operation) r12;
        if (kotlin.jvm.internal.q.b(r13.h(), r10) == false) goto L4;
        if (r13.j() == true) goto L4;
    L12:
        return (Operation) r12;
    L10:
        r12 = null;
        goto L12
    }

    public final Operation m(Fragment r10) {
        Iterator r11 = this.f3280c.iterator();
    L4:
        if (r11.hasNext() == false) goto L10;
        Object r12 = r11.next();
        Operation r13 = (Operation) r12;
        if (kotlin.jvm.internal.q.b(r13.h(), r10) == false) goto L4;
        if (r13.j() == true) goto L4;
    L12:
        return (Operation) r12;
    L10:
        r12 = null;
        goto L12
    }

    public final void n() {
        if (FragmentManager.L0(2) == false) goto L5;
        Log.v("FragmentManager", "SpecialEffectsController: Forcing all operations to complete");
    L5:
        boolean r10 = ViewCompat.S(this.f3278a);
        List r11 = this.f3279b;
        monitor-enter(r11);
        u();     // Catch: Throwable -> L11
        Iterator r12 = this.f3279b.iterator();     // Catch: Throwable -> L11
    L9:
        if (r12.hasNext() == false) goto L13;
        ((Operation) r12.next()).n();     // Catch: Throwable -> L11
        goto L9
    L13:
        Iterator r13 = kotlin.collections.b0.z0(this.f3280c).iterator();     // Catch: Throwable -> L11
    L15:
        if (r13.hasNext() == false) goto L23;
        Operation r14 = (Operation) r13.next();     // Catch: Throwable -> L11
        if (FragmentManager.L0(2) == false) goto L22;
        if (r10 == false) goto L20;
        String r15 = "";
    L21:
        Log.v("FragmentManager", "SpecialEffectsController: " + r15 + "Cancelling running operation " + r14);     // Catch: Throwable -> L11
        goto L22
    L20:
        r15 = "Container " + this.f3278a + " is not attached to window. ";     // Catch: Throwable -> L11
    L22:
        r14.d();     // Catch: Throwable -> L11
        goto L15
    L23:
        Iterator r16 = kotlin.collections.b0.z0(this.f3279b).iterator();     // Catch: Throwable -> L11
    L25:
        if (r16.hasNext() == false) goto L33;
        Operation r17 = (Operation) r16.next();     // Catch: Throwable -> L11
        if (FragmentManager.L0(2) == false) goto L32;
        if (r10 == false) goto L30;
        String r18 = "";
    L31:
        Log.v("FragmentManager", "SpecialEffectsController: " + r18 + "Cancelling pending operation " + r17);     // Catch: Throwable -> L11
        goto L32
    L30:
        r18 = "Container " + this.f3278a + " is not attached to window. ";     // Catch: Throwable -> L11
    L32:
        r17.d();     // Catch: Throwable -> L11
        goto L25
    L33:
        Unit r19 = Unit.f21064a;     // Catch: Throwable -> L11
        monitor-exit(r11);
        return;
    L11:
        th = move-exception;
        throw th;
    }

    public final void o() {
        if (this.f3282e == true) goto L5;
        return;
    L5:
        if (FragmentManager.L0(2) == false) goto L7;
        Log.v("FragmentManager", "SpecialEffectsController: Forcing postponed operations");
    L7:
        this.f3282e = false;
        k();
    }

    public final Operation.LifecycleImpact p(a0 r10) {
        kotlin.jvm.internal.q.g(r10, "fragmentStateManager");
        Fragment r11 = r10.k();
        kotlin.jvm.internal.q.f(r11, "fragmentStateManager.fragment");
        Operation r12 = l(r11);
        Operation.LifecycleImpact r13 = null;
        if (r12 == null) goto L5;
        Operation.LifecycleImpact r14 = r12.i();
    L6:
        Operation r15 = m(r11);
        if (r15 == null) goto L10;
        r13 = r15.i();
    L10:
        if (r14 != null) goto L12;
        int r16 = -1;
    L13:
        if (r16 == (-1)) goto L18;
        if (r16 == 1) goto L18;
        return r14;
    L18:
        return r13;
    L12:
        r16 = c.f3293a[r14.ordinal()];
        goto L13
    L5:
        r14 = null;
        goto L6
    }

    public final ViewGroup q() {
        return this.f3278a;
    }

    public final void t() {
        List r10 = this.f3279b;
        monitor-enter(r10);
        u();     // Catch: Throwable -> L11
        List r11 = this.f3279b;     // Catch: Throwable -> L11
        ListIterator r12 = r11.listIterator(r11.size());     // Catch: Throwable -> L11
    L5:
        Fragment r13 = null;
        if (r12.hasPrevious() == false) goto L13;
        Object r14 = r12.previous();     // Catch: Throwable -> L11
        Operation r15 = (Operation) r14;     // Catch: Throwable -> L11
        Operation.State.a r16 = Operation.State.Companion;     // Catch: Throwable -> L11
        View r17 = r15.h().mView;     // Catch: Throwable -> L11
        kotlin.jvm.internal.q.f(r17, "operation.fragment.mView");     // Catch: Throwable -> L11
        Operation.State r18 = r16.a(r17);     // Catch: Throwable -> L11
        Operation.State r19 = r15.g();     // Catch: Throwable -> L11
        Operation.State r20 = Operation.State.VISIBLE;     // Catch: Throwable -> L11
        if (r19 != r20) goto L5;
        if (r18 == r20) goto L5;
    L14:
        Operation r21 = (Operation) r14;     // Catch: Throwable -> L11
        if (r21 == null) goto L17;
        r13 = r21.h();     // Catch: Throwable -> L11
    L17:
        if (r13 == null) goto L19;
        boolean r22 = r13.isPostponed();     // Catch: Throwable -> L11
    L20:
        this.f3282e = r22;     // Catch: Throwable -> L11
        Unit r23 = Unit.f21064a;     // Catch: Throwable -> L11
        monitor-exit(r10);
        return;
    L19:
        r22 = false;
        goto L20
    L13:
        r14 = null;
    L11:
        th = move-exception;
        throw th;
    }

    public final void u() {
        Iterator r10 = this.f3279b.iterator();
    L4:
        if (r10.hasNext() == false) goto L8;
        Operation r11 = (Operation) r10.next();
        if (r11.i() != Operation.LifecycleImpact.ADDING) goto L4;
        View r12 = r11.h().requireView();
        kotlin.jvm.internal.q.f(r12, "fragment.requireView()");
        r11.m(Operation.State.Companion.b(r12.getVisibility()), Operation.LifecycleImpact.NONE);
        goto L4
    }

    public final void v(boolean r10) {
        this.f3281d = r10;
    }
}
