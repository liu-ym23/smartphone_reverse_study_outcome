package androidx.fragment.app;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.content.Context;
import android.graphics.Rect;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import androidx.collection.ArrayMap;
import androidx.core.app.SharedElementCallback;
import androidx.core.os.CancellationSignal;
import androidx.core.view.ViewCompat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;
import java.util.Set;
import kotlin.Pair;

/* JADX INFO: loaded from: classes.dex */
public final class DefaultSpecialEffectsController extends SpecialEffectsController {

    public static final class a extends b {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final boolean f3111c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public boolean f3112d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public o.a f3113e;

        public a(SpecialEffectsController.Operation r10, CancellationSignal r11, boolean r12) {
            kotlin.jvm.internal.q.g(r10, "operation");
            kotlin.jvm.internal.q.g(r11, "signal");
            super(r10, r11);
            this.f3111c = r12;
        }

        public final o.a e(Context r10) {
            kotlin.jvm.internal.q.g(r10, "context");
            if (this.f3112d == true) goto L11;
            Fragment r11 = b().h();
            if (b().g() != SpecialEffectsController.Operation.State.VISIBLE) goto L8;
            boolean r12 = true;
        L9:
            o.a r13 = o.b(r10, r11, r12, this.f3111c);
            this.f3113e = r13;
            this.f3112d = true;
            return r13;
        L8:
            r12 = false;
            goto L9
        L11:
            return this.f3113e;
        }
    }

    public static class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final SpecialEffectsController.Operation f3114a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final CancellationSignal f3115b;

        public b(SpecialEffectsController.Operation r10, CancellationSignal r11) {
            kotlin.jvm.internal.q.g(r10, "operation");
            kotlin.jvm.internal.q.g(r11, "signal");
            this.f3114a = r10;
            this.f3115b = r11;
        }

        public final void a() {
            this.f3114a.f(this.f3115b);
        }

        public final SpecialEffectsController.Operation b() {
            return this.f3114a;
        }

        public final CancellationSignal c() {
            return this.f3115b;
        }

        public final boolean d() {
            SpecialEffectsController.Operation.State.a r10 = SpecialEffectsController.Operation.State.Companion;
            View r11 = this.f3114a.h().mView;
            kotlin.jvm.internal.q.f(r11, "operation.fragment.mView");
            SpecialEffectsController.Operation.State r12 = r10.a(r11);
            SpecialEffectsController.Operation.State r13 = this.f3114a.g();
            if (r12 == r13) goto L9;
            SpecialEffectsController.Operation.State r14 = SpecialEffectsController.Operation.State.VISIBLE;
            if (r12 == r14) goto L8;
            if (r13 != r14) goto L9;
        L8:
            return false;
        L9:
            return true;
        }
    }

    public static final class c extends b {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final Object f3116c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final boolean f3117d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final Object f3118e;

        public c(SpecialEffectsController.Operation r10, CancellationSignal r11, boolean r12, boolean r13) {
            kotlin.jvm.internal.q.g(r10, "operation");
            kotlin.jvm.internal.q.g(r11, "signal");
            super(r10, r11);
            SpecialEffectsController.Operation.State r14 = r10.g();
            SpecialEffectsController.Operation.State r15 = SpecialEffectsController.Operation.State.VISIBLE;
            if (r14 != r15) goto L8;
            Fragment r16 = r10.h();
            if (r12 == false) goto L7;
            Object r17 = r16.getReenterTransition();
        L12:
            this.f3116c = r17;
            if (r10.g() != r15) goto L17;
            if (r12 == false) goto L16;
            boolean r18 = r10.h().getAllowReturnTransitionOverlap();
        L18:
            this.f3117d = r18;
            if (r13 == false) goto L23;
            if (r12 == false) goto L22;
            Object r19 = r10.h().getSharedElementReturnTransition();
        L24:
            this.f3118e = r19;
            return;
        L22:
            r19 = r10.h().getSharedElementEnterTransition();
            goto L24
        L23:
            r19 = null;
            goto L24
        L16:
            r18 = r10.h().getAllowEnterTransitionOverlap();
            goto L18
        L17:
            r18 = true;
            goto L18
        L7:
            r17 = r16.getEnterTransition();
            goto L12
        L8:
            Fragment r20 = r10.h();
            if (r12 == false) goto L11;
            r17 = r20.getReturnTransition();
            goto L12
        L11:
            r17 = r20.getExitTransition();
            goto L12
        }

        public final f0 e() {
            f0 r10 = f(this.f3116c);
            f0 r11 = f(this.f3118e);
            if (r10 == null) goto L9;
            if (r11 == null) goto L9;
            if (r10 == r11) goto L9;
            throw new IllegalArgumentException(("Mixing framework transitions and AndroidX transitions is not allowed. Fragment " + b().h() + " returned Transition " + this.f3116c + " which uses a different Transition  type than its shared element transition " + this.f3118e).toString());
        L9:
            if (r10 == null) goto L11;
            return r10;
        L11:
            return r11;
        }

        public final f0 f(Object r10) {
            if (r10 != null) goto L5;
            return null;
        L5:
            f0 r11 = d0.f3320b;
            if (r11 != null) goto L8;
        L10:
            f0 r12 = d0.f3321c;
            if (r12 == null) goto L16;
            if (r12.e(r10) == false) goto L16;
            return r12;
        L16:
            throw new IllegalArgumentException("Transition " + r10 + " for fragment " + b().h() + " is not a valid framework Transition or AndroidX Transition");
        L8:
            if (r11.e(r10) == false) goto L10;
            return r11;
        }

        public final Object g() {
            return this.f3118e;
        }

        public final Object h() {
            return this.f3116c;
        }

        public final boolean i() {
            if (this.f3118e == null) goto L5;
            return true;
        L5:
            return false;
        }

        public final boolean j() {
            return this.f3117d;
        }
    }

    public static final class d extends AnimatorListenerAdapter {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ DefaultSpecialEffectsController f3119a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ View f3120b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ boolean f3121c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final /* synthetic */ SpecialEffectsController.Operation f3122d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final /* synthetic */ a f3123e;

        public d(DefaultSpecialEffectsController r10, View r11, boolean r12, SpecialEffectsController.Operation r13, a r14) {
            this.f3119a = r10;
            this.f3120b = r11;
            this.f3121c = r12;
            this.f3122d = r13;
            this.f3123e = r14;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator r10) {
            kotlin.jvm.internal.q.g(r10, "anim");
            this.f3119a.q().endViewTransition(this.f3120b);
            if (this.f3121c == false) goto L5;
            SpecialEffectsController.Operation.State r11 = this.f3122d.g();
            View r12 = this.f3120b;
            kotlin.jvm.internal.q.f(r12, "viewToAnimate");
            r11.applyState(r12);
        L5:
            this.f3123e.a();
            if (FragmentManager.L0(2) == false) goto L9;
            Log.v("FragmentManager", "Animator from operation " + this.f3122d + " has ended.");
            return;
        }
    }

    public static final class e implements Animation.AnimationListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ SpecialEffectsController.Operation f3124a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ DefaultSpecialEffectsController f3125b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ View f3126c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final /* synthetic */ a f3127d;

        public e(SpecialEffectsController.Operation r10, DefaultSpecialEffectsController r11, View r12, a r13) {
            this.f3124a = r10;
            this.f3125b = r11;
            this.f3126c = r12;
            this.f3127d = r13;
        }

        public static /* synthetic */ void a(DefaultSpecialEffectsController r10, View r11, a r12) {
            b(r10, r11, r12);
        }

        public static final void b(DefaultSpecialEffectsController r10, View r11, a r12) {
            kotlin.jvm.internal.q.g(r10, "this$0");
            kotlin.jvm.internal.q.g(r12, "$animationInfo");
            r10.q().endViewTransition(r11);
            r12.a();
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationEnd(Animation r10) {
            kotlin.jvm.internal.q.g(r10, "animation");
            ViewGroup r11 = this.f3125b.q();
            final DefaultSpecialEffectsController r12 = this.f3125b;
            final View r13 = this.f3126c;
            final a r14 = this.f3127d;
            r11.post(new i(r12, r13, r14));
            if (FragmentManager.L0(2) == false) goto L6;
            Log.v("FragmentManager", "Animation from operation " + this.f3124a + " has ended.");
            return;
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationRepeat(Animation r10) {
            kotlin.jvm.internal.q.g(r10, "animation");
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationStart(Animation r10) {
            kotlin.jvm.internal.q.g(r10, "animation");
            if (FragmentManager.L0(2) == false) goto L6;
            Log.v("FragmentManager", "Animation from operation " + this.f3124a + " has reached onAnimationStart.");
            return;
        }
    }

    public DefaultSpecialEffectsController(ViewGroup r10) {
        kotlin.jvm.internal.q.g(r10, "container");
        super(r10);
    }

    public static /* synthetic */ void A(ArrayList r10) {
        N(r10);
    }

    public static /* synthetic */ void B(c r10, SpecialEffectsController.Operation r11) {
        O(r10, r11);
    }

    public static /* synthetic */ void C(f0 r10, View r11, Rect r12) {
        M(r10, r11, r12);
    }

    public static final void F(List r10, SpecialEffectsController.Operation r11, DefaultSpecialEffectsController r12) {
        kotlin.jvm.internal.q.g(r10, "$awaitingContainerChanges");
        kotlin.jvm.internal.q.g(r11, "$operation");
        kotlin.jvm.internal.q.g(r12, "this$0");
        if (r10.contains(r11) == false) goto L6;
        r10.remove(r11);
        r12.D(r11);
        return;
    }

    public static final void J(Animator r10, SpecialEffectsController.Operation r11) {
        kotlin.jvm.internal.q.g(r11, "$operation");
        r10.end();
        if (FragmentManager.L0(2) == false) goto L6;
        Log.v("FragmentManager", "Animator from operation " + r11 + " has been canceled.");
        return;
    }

    public static final void K(View r10, DefaultSpecialEffectsController r11, a r12, SpecialEffectsController.Operation r13) {
        kotlin.jvm.internal.q.g(r11, "this$0");
        kotlin.jvm.internal.q.g(r12, "$animationInfo");
        kotlin.jvm.internal.q.g(r13, "$operation");
        r10.clearAnimation();
        r11.q().endViewTransition(r10);
        r12.a();
        if (FragmentManager.L0(2) == false) goto L6;
        Log.v("FragmentManager", "Animation from operation " + r13 + " has been cancelled.");
        return;
    }

    public static final void M(f0 r10, View r11, Rect r12) {
        kotlin.jvm.internal.q.g(r10, "$impl");
        kotlin.jvm.internal.q.g(r12, "$lastInEpicenterRect");
        r10.h(r11, r12);
    }

    public static final void N(ArrayList r10) {
        kotlin.jvm.internal.q.g(r10, "$transitioningViews");
        d0.e(r10, 4);
    }

    public static final void O(c r10, SpecialEffectsController.Operation r11) {
        kotlin.jvm.internal.q.g(r10, "$transitionInfo");
        kotlin.jvm.internal.q.g(r11, "$operation");
        r10.a();
        if (FragmentManager.L0(2) == false) goto L6;
        Log.v("FragmentManager", "Transition for operation " + r11 + " has completed");
        return;
    }

    public static final void P(SpecialEffectsController.Operation r10, SpecialEffectsController.Operation r11, boolean r12, ArrayMap r13) {
        kotlin.jvm.internal.q.g(r13, "$lastInViews");
        d0.a(r10.h(), r11.h(), r12, r13, false);
    }

    public static /* synthetic */ void w(List r10, SpecialEffectsController.Operation r11, DefaultSpecialEffectsController r12) {
        F(r10, r11, r12);
    }

    public static /* synthetic */ void x(SpecialEffectsController.Operation r10, SpecialEffectsController.Operation r11, boolean r12, ArrayMap r13) {
        P(r10, r11, r12, r13);
    }

    public static /* synthetic */ void y(Animator r10, SpecialEffectsController.Operation r11) {
        J(r10, r11);
    }

    public static /* synthetic */ void z(View r10, DefaultSpecialEffectsController r11, a r12, SpecialEffectsController.Operation r13) {
        K(r10, r11, r12, r13);
    }

    public final void D(SpecialEffectsController.Operation r10) {
        View r11 = r10.h().mView;
        SpecialEffectsController.Operation.State r12 = r10.g();
        kotlin.jvm.internal.q.f(r11, "view");
        r12.applyState(r11);
    }

    public final void E(ArrayList r10, View r11) {
        if ((r11 instanceof ViewGroup) == false) goto L16;
        ViewGroup r12 = (ViewGroup) r11;
        if (androidx.core.view.o.a(r12) == true) goto L7;
        int r13 = r12.getChildCount();
        int r14 = 0;
    L10:
        if (r14 >= r13) goto L25;
        View r15 = r12.getChildAt(r14);
        if (r15.getVisibility() != 0) goto L14;
        kotlin.jvm.internal.q.f(r15, "child");
        E(r10, r15);
    L14:
        r14 = r14 + 1;
        goto L10
    L25:
        return;
    L7:
        if (r10.contains(r11) == true) goto L22;
        r10.add(r11);
        return;
    L22:
        return;
    L16:
        if (r10.contains(r11) == true) goto L24;
        r10.add(r11);
        return;
    }

    public final void G(Map r10, View r11) {
        String r12 = ViewCompat.J(r11);
        if (r12 == null) goto L6;
        r10.put(r12, r11);
    L6:
        if ((r11 instanceof ViewGroup) == false) goto L13;
        ViewGroup r13 = (ViewGroup) r11;
        int r14 = r13.getChildCount();
        int r15 = 0;
    L8:
        if (r15 >= r14) goto L17;
        View r16 = r13.getChildAt(r15);
        if (r16.getVisibility() != 0) goto L12;
        kotlin.jvm.internal.q.f(r16, "child");
        G(r10, r16);
    L12:
        r15 = r15 + 1;
        goto L8
    L17:
        return;
    }

    public final void H(ArrayMap r10, final Collection r11) {
        Set<Map.Entry<Object, Object>> r12 = r10.entrySet();
        kotlin.jvm.internal.q.f(r12, "entries");
        kotlin.collections.y.E(r12, new DefaultSpecialEffectsController$retainMatchingViews$1(r11));
    }

    public final void I(List r19, List r20, boolean r21, Map r22) {
        Context r10 = q().getContext();
        ArrayList r11 = new ArrayList();
        Iterator r12 = r19.iterator();
        boolean r13 = false;
    L4:
        if (r12.hasNext() == false) goto L32;
        a r14 = (a) r12.next();
        if (r14.d() == true) goto L7;
        kotlin.jvm.internal.q.f(r10, "context");
        o.a r15 = r14.e(r10);
        if (r15 == null) goto L11;
        final Animator r16 = r15.f3370b;
        if (r16 == null) goto L14;
        final SpecialEffectsController.Operation r17 = r14.b();
        Fragment r18 = r17.h();
        if (kotlin.jvm.internal.q.b(r22.get(r17), Boolean.TRUE) == true) goto L18;
        if (r17.g() != SpecialEffectsController.Operation.State.GONE) goto L24;
        boolean r23 = true;
    L26:
        if (r23 == false) goto L28;
        r20.remove(r17);
    L28:
        View r24 = r18.mView;
        q().startViewTransition(r24);
        r16.addListener(new d(this, r24, r23, r17, r14));
        r16.setTarget(r24);
        r16.start();
        if (FragmentManager.L0(2) == false) goto L31;
        Log.v("FragmentManager", "Animator from operation " + r17 + " has started.");
    L31:
        r14.c().setOnCancelListener(new androidx.fragment.app.c(r16, r17));
        r13 = true;
        goto L4
    L24:
        r23 = false;
        goto L26
    L18:
        if (FragmentManager.L0(2) == false) goto L20;
        Log.v("FragmentManager", "Ignoring Animator set on " + r18 + " as this Fragment was involved in a Transition.");
    L20:
        r14.a();
        goto L4
    L14:
        r11.add(r14);
        goto L4
    L11:
        r14.a();
        goto L4
    L7:
        r14.a();
        goto L4
    L32:
        Iterator r25 = r11.iterator();
    L34:
        if (r25.hasNext() == false) goto L61;
        final a r26 = (a) r25.next();
        final SpecialEffectsController.Operation r27 = r26.b();
        Fragment r28 = r27.h();
        if (r21 == true) goto L38;
        if (r13 == true) goto L43;
        final View r29 = r28.mView;
        kotlin.jvm.internal.q.f(r10, "context");
        o.a r30 = r26.e(r10);
        if (r30 == null) goto L60;
        Animation r31 = r30.f3369a;
        if (r31 == null) goto L58;
        if (r27.g() == SpecialEffectsController.Operation.State.REMOVED) goto L53;
        r29.startAnimation(r31);
        r26.a();
    L56:
        r26.c().setOnCancelListener(new androidx.fragment.app.d(r29, this, r26, r27));
        goto L34
    L53:
        q().startViewTransition(r29);
        o.b r32 = new o.b(r31, q(), r29);
        r32.setAnimationListener(new e(r27, this, r29, r26));
        r29.startAnimation(r32);
        if (FragmentManager.L0(2) == false) goto L56;
        Log.v("FragmentManager", "Animation from operation " + r27 + " has started.");
        goto L56
    L58:
        throw new IllegalStateException("Required value was null.");
    L60:
        throw new IllegalStateException("Required value was null.");
    L43:
        if (FragmentManager.L0(2) == false) goto L45;
        Log.v("FragmentManager", "Ignoring Animation set on " + r28 + " as Animations cannot run alongside Animators.");
    L45:
        r26.a();
        goto L34
    L38:
        if (FragmentManager.L0(2) == false) goto L40;
        Log.v("FragmentManager", "Ignoring Animation set on " + r28 + " as Animations cannot run alongside Transitions.");
    L40:
        r26.a();
        goto L34
    }

    public final Map L(List r37, List r38, boolean r39, final SpecialEffectsController.Operation r40, final SpecialEffectsController.Operation r41) {
        DefaultSpecialEffectsController r10 = this;
        final boolean r11 = r39;
        LinkedHashMap r12 = new LinkedHashMap();
        ArrayList r13 = new ArrayList();
        Iterator r14 = r37.iterator();
    L4:
        if (r14.hasNext() == false) goto L8;
        Object r15 = r14.next();
        if (((c) r15).d() == true) goto L4;
        r13.add(r15);
        goto L4
    L8:
        ArrayList r16 = new ArrayList();
        Iterator r17 = r13.iterator();
    L10:
        if (r17.hasNext() == false) goto L14;
        Object r18 = r17.next();
        if (((c) r18).e() == null) goto L10;
        r16.add(r18);
        goto L10
    L14:
        Iterator r19 = r16.iterator();
        f0 r110 = null;
    L16:
        if (r19.hasNext() == false) goto L24;
        c r20 = (c) r19.next();
        f0 r21 = r20.e();
        if (r110 == null) goto L23;
        if (r21 == r110) goto L23;
        throw new IllegalArgumentException(("Mixing framework transitions and AndroidX transitions is not allowed. Fragment " + r20.b().h() + " returned Transition " + r20.h() + " which uses a different Transition type than other Fragments.").toString());
    L23:
        r110 = r21;
        goto L16
    L24:
        if (r110 != null) goto L30;
        Iterator r22 = r37.iterator();
    L27:
        if (r22.hasNext() == false) goto L29;
        c r23 = (c) r22.next();
        r12.put(r23.b(), Boolean.FALSE);
        r23.a();
        goto L27
    L29:
        return r12;
    L30:
        View r24 = new View(q().getContext());
        Rect r111 = new Rect();
        ArrayList r112 = new ArrayList();
        ArrayList r113 = new ArrayList();
        ArrayMap r114 = new ArrayMap();
        Iterator r115 = r37.iterator();
        View r25 = null;
        Object r26 = null;
        boolean r116 = false;
    L31:
        String r117 = "FragmentManager";
        if (r115.hasNext() == false) goto L118;
        c r27 = (c) r115.next();
        if (r27.i() == false) goto L117;
        if (r40 == null) goto L117;
        if (r41 == null) goto L117;
        Object r28 = r110.u(r110.f(r27.g()));
        ArrayList<String> r29 = r41.h().getSharedElementSourceNames();
        kotlin.jvm.internal.q.f(r29, "lastIn.fragment.sharedElementSourceNames");
        ArrayList<String> r30 = r40.h().getSharedElementSourceNames();
        View r210 = r25;
        kotlin.jvm.internal.q.f(r30, "firstOut.fragment.sharedElementSourceNames");
        ArrayList<String> r31 = r40.h().getSharedElementTargetNames();
        LinkedHashMap r211 = r12;
        kotlin.jvm.internal.q.f(r31, "firstOut.fragment.sharedElementTargetNames");
        int r32 = r31.size();
        View r212 = r24;
        Rect r213 = r111;
        int r33 = 0;
    L39:
        if (r33 >= r32) goto L44;
        int r214 = r32;
        int r34 = r29.indexOf(r31.get(r33));
        if (r34 == (-1)) goto L43;
        r29.set(r34, r30.get(r33));
    L43:
        r33 = r33 + 1;
        r32 = r214;
        goto L39
    L44:
        ArrayList<String> r35 = r41.h().getSharedElementTargetNames();
        kotlin.jvm.internal.q.f(r35, "lastIn.fragment.sharedElementTargetNames");
        if (r11 == true) goto L47;
        Pair r36 = kotlin.d.a(r40.h().getExitTransitionCallback(), r41.h().getEnterTransitionCallback());
    L48:
        SharedElementCallback r42 = (SharedElementCallback) r36.component1();
        SharedElementCallback r43 = (SharedElementCallback) r36.component2();
        int r44 = r29.size();
        int r118 = 0;
    L49:
        if (r118 >= r44) goto L51;
        r114.put(r29.get(r118), r35.get(r118));
        r118 = r118 + 1;
        r44 = r44;
        r28 = r28;
        goto L49
    L51:
        Object r215 = r28;
        if (FragmentManager.L0(2) == false) goto L61;
        Log.v("FragmentManager", ">>> entering view names <<<");
        Iterator<String> r45 = r35.iterator();
    L55:
        if (r45.hasNext() == false) goto L57;
        Log.v("FragmentManager", "Name: " + r45.next());
        r45 = r45;
        goto L55
    L57:
        Log.v("FragmentManager", ">>> exiting view names <<<");
        Iterator<String> r46 = r29.iterator();
    L59:
        if (r46.hasNext() == false) goto L61;
        Log.v("FragmentManager", "Name: " + r46.next());
        r46 = r46;
    L61:
        ArrayMap r47 = new ArrayMap();
        View r48 = r40.h().mView;
        kotlin.jvm.internal.q.f(r48, "firstOut.fragment.mView");
        r10.G(r47, r48);
        r47.retainAll(r29);
        if (r42 != null) goto L64;
        f0 r216 = r110;
        r114.retainAll(r47.keySet());
    L79:
        final ArrayMap r49 = new ArrayMap();
        View r50 = r41.h().mView;
        kotlin.jvm.internal.q.f(r50, "lastIn.fragment.mView");
        r10.G(r49, r50);
        r49.retainAll(r35);
        r49.retainAll(r114.values());
        if (r43 != null) goto L82;
        d0.d(r114, r49);
    L100:
        Collection r51 = r114.keySet();
        kotlin.jvm.internal.q.f(r51, "sharedElementNameMapping.keys");
        r10.H(r47, r51);
        Collection r52 = r114.values();
        kotlin.jvm.internal.q.f(r52, "sharedElementNameMapping.values");
        r10.H(r49, r52);
        if (r114.isEmpty() == true) goto L102;
        d0.a(r41.h(), r40.h(), r11, r47, true);
        androidx.core.view.j.a(q(), new androidx.fragment.app.e(r41, r40, r11, r49));
        r112.addAll(r47.values());
        if (r29.isEmpty() == true) goto L106;
        View r53 = (View) r47.get((String) r29.get(0));
        final f0 r119 = r216;
        Object r54 = r215;
        r119.p(r54, r53);
    L107:
        r113.addAll(r49.values());
        if (r35.isEmpty() == true) goto L114;
        final View r55 = (View) r49.get((String) r35.get(0));
        if (r55 == null) goto L113;
        final Rect r56 = r213;
        androidx.core.view.j.a(q(), new f(r119, r55, r56));
        r116 = true;
    L112:
        View r57 = r212;
        r119.s(r54, r57, r112);
        Object r217 = r54;
        ArrayList r58 = r113;
        View r120 = r53;
        f0 r59 = r119;
        Rect r60 = r56;
        r119.n(r54, null, null, null, null, r217, r58);
        Boolean r61 = Boolean.TRUE;
        LinkedHashMap r121 = r211;
        r121.put(r40, r61);
        r121.put(r41, r61);
        r113 = r58;
        r112 = r112;
        r25 = r120;
        r114 = r114;
        r26 = r217;
    L116:
        r110 = r59;
        r11 = r39;
        Rect r310 = r60;
        r24 = r57;
        r12 = r121;
        r111 = r310;
        goto L31
    L113:
        r56 = r213;
        goto L112
    L114:
        r56 = r213;
        goto L112
    L106:
        r119 = r216;
        r54 = r215;
        r53 = r210;
        goto L107
    L102:
        r112.clear();
        r113.clear();
        r25 = r210;
        r12 = r211;
        r24 = r212;
        r111 = r213;
        r110 = r216;
        r26 = null;
        goto L31
    L82:
        if (FragmentManager.L0(2) == false) goto L84;
        Log.v("FragmentManager", "Executing enter callback for operation " + r41);
    L84:
        r43.d(r35, r49);
        int r62 = r35.size() - 1;
        if (r62 < 0) goto L100;
    L86:
        int r63 = r62 - 1;
        String r64 = r35.get(r62);
        View r122 = (View) r49.get(r64);
        if (r122 != null) goto L92;
        kotlin.jvm.internal.q.f(r64, "name");
        String r65 = d0.b(r114, r64);
        if (r65 == null) goto L96;
        r114.remove(r65);
    L96:
        if (r63 < 0) goto L100;
        r62 = r63;
        goto L86
    L92:
        if (kotlin.jvm.internal.q.b(r64, ViewCompat.J(r122)) == true) goto L96;
        kotlin.jvm.internal.q.f(r64, "name");
        String r66 = d0.b(r114, r64);
        if (r66 == null) goto L96;
        r114.put(r66, ViewCompat.J(r122));
        goto L96
    L64:
        if (FragmentManager.L0(2) == false) goto L66;
        Log.v("FragmentManager", "Executing exit callback for operation " + r40);
    L66:
        r42.d(r29, r47);
        int r67 = r29.size() - 1;
        if (r67 < 0) goto L77;
    L68:
        int r68 = r67 - 1;
        Object r69 = (String) r29.get(r67);
        View r123 = (View) r47.get(r69);
        if (r123 != null) goto L71;
        r114.remove(r69);
        r216 = r110;
    L74:
        if (r68 < 0) goto L79;
        r67 = r68;
        r110 = r216;
        goto L68
    L71:
        r216 = r110;
        if (kotlin.jvm.internal.q.b(r69, ViewCompat.J(r123)) == true) goto L74;
        r114.put(ViewCompat.J(r123), (String) r114.remove(r69));
        goto L74
    L77:
        r216 = r110;
        goto L79
    L47:
        r36 = kotlin.d.a(r40.h().getEnterTransitionCallback(), r41.h().getExitTransitionCallback());
    L117:
        r59 = r110;
        Rect r311 = r111;
        r121 = r12;
        r57 = r24;
        r60 = r311;
        r113 = r113;
        r112 = r112;
        r114 = r114;
        r25 = r25;
        goto L116
    L118:
        View r218 = r25;
        ArrayMap r124 = r114;
        ArrayList r70 = r113;
        f0 r71 = r110;
        Rect r312 = r111;
        LinkedHashMap r125 = r12;
        View r72 = r24;
        ArrayList r126 = new ArrayList();
        Iterator r127 = r37.iterator();
        Object r73 = null;
        Object r128 = null;
    L120:
        if (r127.hasNext() == false) goto L158;
        c r219 = (c) r127.next();
        if (r219.d() == true) goto L123;
        Object r129 = r71.f(r219.h());
        SpecialEffectsController.Operation r74 = r219.b();
        if (r26 == null) goto L129;
        if (r74 == r40) goto L128;
        if (r74 != r41) goto L129;
    L128:
        boolean r220 = true;
    L130:
        if (r129 == null) goto L131;
        LinkedHashMap r221 = r125;
        ArrayList r130 = new ArrayList();
        Object r313 = r73;
        View r75 = r74.h().mView;
        Object r222 = r26;
        kotlin.jvm.internal.q.f(r75, "operation.fragment.mView");
        r10.E(r130, r75);
        if (r220 == false) goto L140;
        if (r74 != r40) goto L138;
        r130.removeAll(kotlin.collections.b0.B0(r112));
        goto L140
    L138:
        r130.removeAll(kotlin.collections.b0.B0(r70));
    L140:
        if (r130.isEmpty() == false) goto L142;
        r71.a(r129, r72);
        Object r223 = r313;
        View r224 = r72;
        SpecialEffectsController.Operation r76 = r74;
        String r314 = r117;
        Object r315 = r128;
        ArrayList r316 = r126;
        final ArrayList r77 = r130;
        View r317 = r218;
        r125 = r221;
        Object r318 = r222;
        r112 = r112;
    L147:
        if (r76.g() != SpecialEffectsController.Operation.State.VISIBLE) goto L152;
        r126 = r316;
        r126.addAll(r77);
        if (r116 == false) goto L151;
        r71.o(r129, r312);
    L151:
        View r78 = r317;
    L153:
        r125.put(r76, Boolean.TRUE);
        if (r219.j() == false) goto L157;
        r128 = r71.k(r315, r129, null);
        r73 = r223;
    L156:
        r26 = r318;
        r117 = r314;
        r10 = this;
        r218 = r78;
        r72 = r224;
        goto L120
    L157:
        r128 = r315;
        r73 = r71.k(r223, r129, null);
        goto L156
    L152:
        r78 = r317;
        r126 = r316;
        r71.p(r129, r78);
        goto L153
    L142:
        r71.b(r129, r130);
        r223 = r313;
        r317 = r218;
        r318 = r222;
        r314 = r117;
        r315 = r128;
        r316 = r126;
        r112 = r112;
        r224 = r72;
        r77 = r130;
        r125 = r221;
        r71.n(r129, r129, r130, null, null, null, null);
        if (r74.g() != SpecialEffectsController.Operation.State.GONE) goto L145;
        r76 = r74;
        r38.remove(r76);
        ArrayList r79 = new ArrayList(r77);
        r79.remove(r76.h().mView);
        r71.m(r129, r76.h().mView, r79);
        androidx.core.view.j.a(q(), new g(r77));
        goto L147
    L145:
        r76 = r74;
        goto L147
    L131:
        if (r220 == true) goto L120;
        r125.put(r74, Boolean.FALSE);
        r219.a();
    L129:
        r220 = false;
        goto L130
    L123:
        r125.put(r219.b(), Boolean.FALSE);
        r219.a();
        goto L120
    L158:
        String r319 = r117;
        ArrayList r225 = r112;
        LinkedHashMap r80 = r125;
        ArrayList r320 = r126;
        Object r131 = r26;
        Object r81 = r71.j(r128, r73, r131);
        if (r81 != null) goto L161;
        return r80;
    L161:
        ArrayList r82 = new ArrayList();
        Iterator r83 = r37.iterator();
    L163:
        if (r83.hasNext() == false) goto L167;
        Object r84 = r83.next();
        if (((c) r84).d() == true) goto L163;
        r82.add(r84);
        goto L163
    L167:
        Iterator r85 = r82.iterator();
    L169:
        if (r85.hasNext() == false) goto L189;
        final c r86 = (c) r85.next();
        Object r87 = r86.h();
        final SpecialEffectsController.Operation r132 = r86.b();
        if (r131 == null) goto L175;
        if (r132 == r40) goto L174;
        if (r132 != r41) goto L175;
    L174:
        boolean r133 = true;
    L176:
        if (r87 != null) goto L181;
        if (r133 == true) goto L181;
        String r134 = r319;
    L188:
        r319 = r134;
    L181:
        if (ViewCompat.T(q()) == false) goto L183;
        r134 = r319;
        r71.q(r86.b().h(), r81, r86.c(), new h(r86, r132));
        goto L188
    L183:
        if (FragmentManager.L0(2) == false) goto L185;
        r134 = r319;
        Log.v(r134, "SpecialEffectsController: Container " + q() + " has not been laid out. Completing operation " + r132);
    L186:
        r86.a();
        goto L188
    L185:
        r134 = r319;
    L175:
        r133 = false;
        goto L176
    L189:
        String r135 = r319;
        if (ViewCompat.T(q()) == true) goto L192;
        return r80;
    L192:
        d0.e(r320, 4);
        ArrayList r88 = r71.l(r70);
        if (FragmentManager.L0(2) == false) goto L202;
        Log.v(r135, ">>>>> Beginning transition <<<<<");
        Log.v(r135, ">>>>> SharedElementFirstOutViews <<<<<");
        Iterator r89 = r225.iterator();
    L196:
        if (r89.hasNext() == false) goto L198;
        Object r90 = r89.next();
        kotlin.jvm.internal.q.f(r90, "sharedElementFirstOutViews");
        View r91 = (View) r90;
        Log.v(r135, "View: " + r91 + " Name: " + ViewCompat.J(r91));
        goto L196
    L198:
        Log.v(r135, ">>>>> SharedElementLastInViews <<<<<");
        Iterator r92 = r70.iterator();
    L200:
        if (r92.hasNext() == false) goto L202;
        Object r93 = r92.next();
        kotlin.jvm.internal.q.f(r93, "sharedElementLastInViews");
        View r94 = (View) r93;
        Log.v(r135, "View: " + r94 + " Name: " + ViewCompat.J(r94));
    L202:
        r71.c(q(), r81);
        r71.r(q(), r225, r70, r88, r124);
        d0.e(r320, 0);
        r71.t(r131, r225, r70);
        return r80;
    }

    public final void Q(List r10) {
        Fragment r11 = ((SpecialEffectsController.Operation) kotlin.collections.b0.i0(r10)).h();
        Iterator r12 = r10.iterator();
    L4:
        if (r12.hasNext() == false) goto L6;
        SpecialEffectsController.Operation r13 = (SpecialEffectsController.Operation) r12.next();
        Fragment.AnimationInfo r14 = r13.h().mAnimationInfo;
        r14.f3136c = r11.mAnimationInfo.f3136c;
        Fragment.AnimationInfo r15 = r13.h().mAnimationInfo;
        r15.f3137d = r11.mAnimationInfo.f3137d;
        Fragment.AnimationInfo r16 = r13.h().mAnimationInfo;
        r16.f3138e = r11.mAnimationInfo.f3138e;
        Fragment.AnimationInfo r17 = r13.h().mAnimationInfo;
        r17.f3139f = r11.mAnimationInfo.f3139f;
        goto L4
    }

    @Override // androidx.fragment.app.SpecialEffectsController
    public void j(List r14, boolean r15) {
        kotlin.jvm.internal.q.g(r14, "operations");
        Iterator r10 = r14.iterator();
    L3:
        Object r11 = null;
        if (r10.hasNext() == false) goto L10;
        Object r12 = r10.next();
        SpecialEffectsController.Operation r13 = (SpecialEffectsController.Operation) r12;
        SpecialEffectsController.Operation.State.a r16 = SpecialEffectsController.Operation.State.Companion;
        View r17 = r13.h().mView;
        kotlin.jvm.internal.q.f(r17, "operation.fragment.mView");
        SpecialEffectsController.Operation.State r18 = r16.a(r17);
        SpecialEffectsController.Operation.State r19 = SpecialEffectsController.Operation.State.VISIBLE;
        if (r18 != r19) goto L3;
        if (r13.g() == r19) goto L3;
    L11:
        SpecialEffectsController.Operation r20 = (SpecialEffectsController.Operation) r12;
        ListIterator r21 = r14.listIterator(r14.size());
    L13:
        if (r21.hasPrevious() == false) goto L19;
        Object r22 = r21.previous();
        SpecialEffectsController.Operation r23 = (SpecialEffectsController.Operation) r22;
        SpecialEffectsController.Operation.State.a r24 = SpecialEffectsController.Operation.State.Companion;
        View r25 = r23.h().mView;
        kotlin.jvm.internal.q.f(r25, "operation.fragment.mView");
        SpecialEffectsController.Operation.State r26 = r24.a(r25);
        SpecialEffectsController.Operation.State r27 = SpecialEffectsController.Operation.State.VISIBLE;
        if (r26 == r27) goto L13;
        if (r23.g() != r27) goto L13;
        r11 = r22;
    L19:
        SpecialEffectsController.Operation r28 = (SpecialEffectsController.Operation) r11;
        if (FragmentManager.L0(2) == false) goto L22;
        Log.v("FragmentManager", "Executing operations from " + r20 + " to " + r28);
    L22:
        ArrayList r29 = new ArrayList();
        ArrayList r30 = new ArrayList();
        final List r110 = kotlin.collections.b0.z0(r14);
        Q(r14);
        Iterator r111 = r14.iterator();
    L24:
        if (r111.hasNext() == false) goto L32;
        final SpecialEffectsController.Operation r31 = (SpecialEffectsController.Operation) r111.next();
        CancellationSignal r32 = new CancellationSignal();
        r31.l(r32);
        r29.add(new a(r31, r32, r15));
        CancellationSignal r33 = new CancellationSignal();
        r31.l(r33);
        boolean r34 = false;
        if (r15 == false) goto L29;
        if (r31 != r20) goto L31;
    L28:
        r34 = true;
    L31:
        r30.add(new c(r31, r33, r15, r34));
        r31.c(new androidx.fragment.app.b(r110, r31, this));
        goto L24
    L29:
        if (r31 != r28) goto L31;
    L32:
        Map r112 = L(r30, r110, r15, r20, r28);
        I(r29, r110, r112.containsValue(Boolean.TRUE), r112);
        Iterator r113 = r110.iterator();
    L34:
        if (r113.hasNext() == false) goto L36;
        D((SpecialEffectsController.Operation) r113.next());
        goto L34
    L36:
        r110.clear();
        if (FragmentManager.L0(2) == false) goto L57;
        Log.v("FragmentManager", "Completed executing operations from " + r20 + " to " + r28);
        return;
    L57:
        return;
    L10:
        r12 = null;
        goto L11
    }
}
