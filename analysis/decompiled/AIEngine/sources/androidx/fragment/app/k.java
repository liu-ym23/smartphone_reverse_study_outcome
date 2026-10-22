package androidx.fragment.app;

import android.animation.Animator;
import android.animation.AnimatorInflater;
import android.content.Context;
import android.content.res.Resources;
import android.transition.Transition;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import androidx.fragment.app.SpecialEffectsController;
import androidx.fragment.app.p;
import com.stepos.aiengine.R;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.WeakHashMap;
import p.a;
import v0.e0;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class k extends SpecialEffectsController {

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public static class a extends b {

        /* renamed from: c, reason: collision with root package name */
        public boolean f2151c;

        /* renamed from: d, reason: collision with root package name */
        public boolean f2152d;

        /* renamed from: e, reason: collision with root package name */
        public p.a f2153e;

        public final p.a c(Context context) throws Resources.NotFoundException {
            Animation animationLoadAnimation;
            p.a aVar;
            if (this.f2152d) {
                return this.f2153e;
            }
            SpecialEffectsController.Operation operation = this.f2154a;
            Fragment fragment = operation.f2056c;
            boolean z = operation.f2054a == SpecialEffectsController.Operation.State.f2066b;
            boolean z3 = this.f2151c;
            int nextTransition = fragment.getNextTransition();
            int popEnterAnim = z3 ? z ? fragment.getPopEnterAnim() : fragment.getPopExitAnim() : z ? fragment.getEnterAnim() : fragment.getExitAnim();
            fragment.setAnimations(0, 0, 0, 0);
            ViewGroup viewGroup = fragment.mContainer;
            p.a aVar2 = null;
            if (viewGroup != null && viewGroup.getTag(R.id.visible_removing_fragment_view_tag) != null) {
                fragment.mContainer.setTag(R.id.visible_removing_fragment_view_tag, null);
            }
            ViewGroup viewGroup2 = fragment.mContainer;
            if (viewGroup2 == null || viewGroup2.getLayoutTransition() == null) {
                Animation animationOnCreateAnimation = fragment.onCreateAnimation(nextTransition, z, popEnterAnim);
                if (animationOnCreateAnimation != null) {
                    aVar2 = new p.a(animationOnCreateAnimation);
                } else {
                    Animator animatorOnCreateAnimator = fragment.onCreateAnimator(nextTransition, z, popEnterAnim);
                    if (animatorOnCreateAnimator != null) {
                        aVar2 = new p.a(animatorOnCreateAnimator);
                    } else {
                        if (popEnterAnim == 0 && nextTransition != 0) {
                            popEnterAnim = nextTransition != 4097 ? nextTransition != 8194 ? nextTransition != 8197 ? nextTransition != 4099 ? nextTransition != 4100 ? -1 : z ? p.a(android.R.attr.activityOpenEnterAnimation, context) : p.a(android.R.attr.activityOpenExitAnimation, context) : z ? R.animator.fragment_fade_enter : R.animator.fragment_fade_exit : z ? p.a(android.R.attr.activityCloseEnterAnimation, context) : p.a(android.R.attr.activityCloseExitAnimation, context) : z ? R.animator.fragment_close_enter : R.animator.fragment_close_exit : z ? R.animator.fragment_open_enter : R.animator.fragment_open_exit;
                        }
                        if (popEnterAnim != 0) {
                            boolean zEquals = "anim".equals(context.getResources().getResourceTypeName(popEnterAnim));
                            if (zEquals) {
                                try {
                                    animationLoadAnimation = AnimationUtils.loadAnimation(context, popEnterAnim);
                                } catch (Resources.NotFoundException e10) {
                                    throw e10;
                                } catch (RuntimeException unused) {
                                }
                                if (animationLoadAnimation != null) {
                                    aVar = new p.a(animationLoadAnimation);
                                    aVar2 = aVar;
                                }
                            } else {
                                try {
                                    Animator animatorLoadAnimator = AnimatorInflater.loadAnimator(context, popEnterAnim);
                                    if (animatorLoadAnimator != null) {
                                        aVar = new p.a(animatorLoadAnimator);
                                        aVar2 = aVar;
                                    }
                                } catch (RuntimeException e11) {
                                    if (zEquals) {
                                        throw e11;
                                    }
                                    Animation animationLoadAnimation2 = AnimationUtils.loadAnimation(context, popEnterAnim);
                                    if (animationLoadAnimation2 != null) {
                                        aVar2 = new p.a(animationLoadAnimation2);
                                    }
                                }
                            }
                        }
                    }
                }
            }
            this.f2153e = aVar2;
            this.f2152d = true;
            return aVar2;
        }
    }

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public static class b {

        /* renamed from: a, reason: collision with root package name */
        public final SpecialEffectsController.Operation f2154a;

        /* renamed from: b, reason: collision with root package name */
        public final r0.c f2155b;

        public b(SpecialEffectsController.Operation operation, r0.c cVar) {
            this.f2154a = operation;
            this.f2155b = cVar;
        }

        public final void a() {
            SpecialEffectsController.Operation operation = this.f2154a;
            HashSet<r0.c> hashSet = operation.f2058e;
            if (hashSet.remove(this.f2155b) && hashSet.isEmpty()) {
                operation.b();
            }
        }

        public final boolean b() {
            SpecialEffectsController.Operation operation = this.f2154a;
            SpecialEffectsController.Operation.State stateC = SpecialEffectsController.Operation.State.c(operation.f2056c.mView);
            SpecialEffectsController.Operation.State state = operation.f2054a;
            if (stateC == state) {
                return true;
            }
            SpecialEffectsController.Operation.State state2 = SpecialEffectsController.Operation.State.f2066b;
            return (stateC == state2 || state == state2) ? false : true;
        }
    }

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public static class c extends b {

        /* renamed from: c, reason: collision with root package name */
        public final Object f2156c;

        /* renamed from: d, reason: collision with root package name */
        public final boolean f2157d;

        /* renamed from: e, reason: collision with root package name */
        public final Object f2158e;

        public c(SpecialEffectsController.Operation operation, r0.c cVar, boolean z, boolean z3) {
            super(operation, cVar);
            SpecialEffectsController.Operation.State state = operation.f2054a;
            Fragment fragment = operation.f2056c;
            if (state == SpecialEffectsController.Operation.State.f2066b) {
                this.f2156c = z ? fragment.getReenterTransition() : fragment.getEnterTransition();
                this.f2157d = z ? fragment.getAllowReturnTransitionOverlap() : fragment.getAllowEnterTransitionOverlap();
            } else {
                this.f2156c = z ? fragment.getReturnTransition() : fragment.getExitTransition();
                this.f2157d = true;
            }
            if (!z3) {
                this.f2158e = null;
            } else if (z) {
                this.f2158e = fragment.getSharedElementReturnTransition();
            } else {
                this.f2158e = fragment.getSharedElementEnterTransition();
            }
        }

        public final j0 c(Object obj) {
            if (obj == null) {
                return null;
            }
            f0 f0Var = e0.f2123a;
            if (f0Var != null && (obj instanceof Transition)) {
                return f0Var;
            }
            j0 j0Var = e0.f2124b;
            if (j0Var != null && j0Var.e(obj)) {
                return j0Var;
            }
            throw new IllegalArgumentException("Transition " + obj + " for fragment " + this.f2154a.f2056c + " is not a valid framework Transition or AndroidX Transition");
        }
    }

    public static void j(View view, ArrayList arrayList) {
        if (!(view instanceof ViewGroup)) {
            if (arrayList.contains(view)) {
                return;
            }
            arrayList.add(view);
            return;
        }
        ViewGroup viewGroup = (ViewGroup) view;
        int i10 = v0.f0.f13285a;
        if (viewGroup.isTransitionGroup()) {
            if (arrayList.contains(view)) {
                return;
            }
            arrayList.add(viewGroup);
            return;
        }
        int childCount = viewGroup.getChildCount();
        for (int i11 = 0; i11 < childCount; i11++) {
            View childAt = viewGroup.getChildAt(i11);
            if (childAt.getVisibility() == 0) {
                j(childAt, arrayList);
            }
        }
    }

    public static void k(p.a aVar, View view) {
        WeakHashMap<View, v0.h0> weakHashMap = v0.e0.f13274a;
        String strE = e0.d.e(view);
        if (strE != null) {
            aVar.put(strE, view);
        }
        if (view instanceof ViewGroup) {
            ViewGroup viewGroup = (ViewGroup) view;
            int childCount = viewGroup.getChildCount();
            for (int i10 = 0; i10 < childCount; i10++) {
                View childAt = viewGroup.getChildAt(i10);
                if (childAt.getVisibility() == 0) {
                    k(aVar, childAt);
                }
            }
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static void l(p.a aVar, Collection collection) {
        Iterator it = ((a.C0124a) aVar.entrySet()).iterator();
        while (true) {
            a.d dVar = (a.d) it;
            if (!dVar.hasNext()) {
                return;
            }
            dVar.next();
            View view = (View) dVar.getValue();
            WeakHashMap<View, v0.h0> weakHashMap = v0.e0.f13274a;
            if (!collection.contains(e0.d.e(view))) {
                dVar.remove();
            }
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:217:0x06f9  */
    /* JADX WARN: Removed duplicated region for block: B:247:0x07d7  */
    /* JADX WARN: Removed duplicated region for block: B:267:0x0884 A[LOOP:7: B:266:0x0882->B:267:0x0884, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:270:0x089f  */
    /* JADX WARN: Removed duplicated region for block: B:354:? A[RETURN, SYNTHETIC] */
    @Override // androidx.fragment.app.SpecialEffectsController
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void b(java.util.ArrayList r39, boolean r40) throws android.content.res.Resources.NotFoundException {
        /*
            Method dump skipped, instructions count: 2233
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.fragment.app.k.b(java.util.ArrayList, boolean):void");
    }
}
