package com.google.android.material.transformation;

import a1.C0413f;
import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.util.Pair;
import android.util.Property;
import android.view.View;
import android.view.ViewAnimationUtils;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import b1.C0553a;
import b1.C0554b;
import b1.C0555c;
import b1.C0556d;
import b1.C0557e;
import b1.h;
import b1.i;
import b1.j;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import h1.C0746a;
import h1.InterfaceC0748c;
import java.util.ArrayList;
import java.util.List;
import n1.C0873a;
import y1.C1318a;
import y1.C1319b;

@Deprecated
/* loaded from: classes.dex */
public abstract class FabTransformationBehavior extends ExpandableTransformationBehavior {

    /* renamed from: c, reason: collision with root package name */
    private final Rect f13512c;

    /* renamed from: d, reason: collision with root package name */
    private final RectF f13513d;

    /* renamed from: e, reason: collision with root package name */
    private final RectF f13514e;

    /* renamed from: f, reason: collision with root package name */
    private final int[] f13515f;

    /* renamed from: g, reason: collision with root package name */
    private float f13516g;

    /* renamed from: h, reason: collision with root package name */
    private float f13517h;

    class a extends AnimatorListenerAdapter {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ boolean f13518a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ View f13519b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ View f13520c;

        a(boolean z5, View view, View view2) {
            this.f13518a = z5;
            this.f13519b = view;
            this.f13520c = view2;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            if (this.f13518a) {
                return;
            }
            this.f13519b.setVisibility(4);
            this.f13520c.setAlpha(1.0f);
            this.f13520c.setVisibility(0);
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            if (this.f13518a) {
                this.f13519b.setVisibility(0);
                this.f13520c.setAlpha(0.0f);
                this.f13520c.setVisibility(4);
            }
        }
    }

    class b implements ValueAnimator.AnimatorUpdateListener {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ View f13522a;

        b(View view) {
            this.f13522a = view;
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            this.f13522a.invalidate();
        }
    }

    class c extends AnimatorListenerAdapter {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ InterfaceC0748c f13524a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ Drawable f13525b;

        c(InterfaceC0748c interfaceC0748c, Drawable drawable) {
            this.f13524a = interfaceC0748c;
            this.f13525b = drawable;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            this.f13524a.setCircularRevealOverlayDrawable(null);
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            this.f13524a.setCircularRevealOverlayDrawable(this.f13525b);
        }
    }

    class d extends AnimatorListenerAdapter {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ InterfaceC0748c f13527a;

        d(InterfaceC0748c interfaceC0748c) {
            this.f13527a = interfaceC0748c;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            InterfaceC0748c.e revealInfo = this.f13527a.getRevealInfo();
            revealInfo.f17591c = Float.MAX_VALUE;
            this.f13527a.setRevealInfo(revealInfo);
        }
    }

    protected static class e {

        /* renamed from: a, reason: collision with root package name */
        public h f13529a;

        /* renamed from: b, reason: collision with root package name */
        public j f13530b;

        protected e() {
        }
    }

    public FabTransformationBehavior() {
        this.f13512c = new Rect();
        this.f13513d = new RectF();
        this.f13514e = new RectF();
        this.f13515f = new int[2];
    }

    private void A(View view, View view2, boolean z5, boolean z6, e eVar, List<Animator> list, List<Animator.AnimatorListener> list2, RectF rectF) {
        i iVar;
        i iVar2;
        ObjectAnimator objectAnimatorOfFloat;
        ObjectAnimator objectAnimatorOfFloat2;
        float fO = o(view, view2, eVar.f13530b);
        float fP = p(view, view2, eVar.f13530b);
        Pair<i, i> pairL = l(fO, fP, z5, eVar);
        i iVar3 = (i) pairL.first;
        i iVar4 = (i) pairL.second;
        if (z5) {
            if (!z6) {
                view2.setTranslationX(-fO);
                view2.setTranslationY(-fP);
            }
            objectAnimatorOfFloat = ObjectAnimator.ofFloat(view2, (Property<View, Float>) View.TRANSLATION_X, 0.0f);
            objectAnimatorOfFloat2 = ObjectAnimator.ofFloat(view2, (Property<View, Float>) View.TRANSLATION_Y, 0.0f);
            iVar = iVar4;
            iVar2 = iVar3;
            j(view2, eVar, iVar2, iVar, -fO, -fP, 0.0f, 0.0f, rectF);
        } else {
            iVar = iVar4;
            iVar2 = iVar3;
            objectAnimatorOfFloat = ObjectAnimator.ofFloat(view2, (Property<View, Float>) View.TRANSLATION_X, -fO);
            objectAnimatorOfFloat2 = ObjectAnimator.ofFloat(view2, (Property<View, Float>) View.TRANSLATION_Y, -fP);
        }
        iVar2.a(objectAnimatorOfFloat);
        iVar.a(objectAnimatorOfFloat2);
        list.add(objectAnimatorOfFloat);
        list.add(objectAnimatorOfFloat2);
    }

    private int B(View view) {
        ColorStateList backgroundTintList = view.getBackgroundTintList();
        if (backgroundTintList != null) {
            return backgroundTintList.getColorForState(view.getDrawableState(), backgroundTintList.getDefaultColor());
        }
        return 0;
    }

    private ViewGroup D(View view) {
        if (view instanceof ViewGroup) {
            return (ViewGroup) view;
        }
        return null;
    }

    private ViewGroup i(View view) {
        View viewFindViewById = view.findViewById(C0413f.f6819B);
        return viewFindViewById != null ? D(viewFindViewById) : ((view instanceof C1319b) || (view instanceof C1318a)) ? D(((ViewGroup) view).getChildAt(0)) : D(view);
    }

    private void j(View view, e eVar, i iVar, i iVar2, float f5, float f6, float f7, float f8, RectF rectF) {
        float fQ = q(eVar, iVar, f5, f7);
        float fQ2 = q(eVar, iVar2, f6, f8);
        Rect rect = this.f13512c;
        view.getWindowVisibleDisplayFrame(rect);
        RectF rectF2 = this.f13513d;
        rectF2.set(rect);
        RectF rectF3 = this.f13514e;
        r(view, rectF3);
        rectF3.offset(fQ, fQ2);
        rectF3.intersect(rectF2);
        rectF.set(rectF3);
    }

    private void k(View view, RectF rectF) {
        r(view, rectF);
        rectF.offset(this.f13516g, this.f13517h);
    }

    private Pair<i, i> l(float f5, float f6, boolean z5, e eVar) {
        i iVarE;
        i iVarE2;
        if (f5 == 0.0f || f6 == 0.0f) {
            iVarE = eVar.f13529a.e("translationXLinear");
            iVarE2 = eVar.f13529a.e("translationYLinear");
        } else if ((!z5 || f6 >= 0.0f) && (z5 || f6 <= 0.0f)) {
            iVarE = eVar.f13529a.e("translationXCurveDownwards");
            iVarE2 = eVar.f13529a.e("translationYCurveDownwards");
        } else {
            iVarE = eVar.f13529a.e("translationXCurveUpwards");
            iVarE2 = eVar.f13529a.e("translationYCurveUpwards");
        }
        return new Pair<>(iVarE, iVarE2);
    }

    private float m(View view, View view2, j jVar) {
        RectF rectF = this.f13513d;
        RectF rectF2 = this.f13514e;
        k(view, rectF);
        r(view2, rectF2);
        rectF2.offset(-o(view, view2, jVar), 0.0f);
        return rectF.centerX() - rectF2.left;
    }

    private float n(View view, View view2, j jVar) {
        RectF rectF = this.f13513d;
        RectF rectF2 = this.f13514e;
        k(view, rectF);
        r(view2, rectF2);
        rectF2.offset(0.0f, -p(view, view2, jVar));
        return rectF.centerY() - rectF2.top;
    }

    private float o(View view, View view2, j jVar) {
        float fCenterX;
        float fCenterX2;
        float f5;
        RectF rectF = this.f13513d;
        RectF rectF2 = this.f13514e;
        k(view, rectF);
        r(view2, rectF2);
        int i5 = jVar.f11802a & 7;
        if (i5 == 1) {
            fCenterX = rectF2.centerX();
            fCenterX2 = rectF.centerX();
        } else if (i5 == 3) {
            fCenterX = rectF2.left;
            fCenterX2 = rectF.left;
        } else {
            if (i5 != 5) {
                f5 = 0.0f;
                return f5 + jVar.f11803b;
            }
            fCenterX = rectF2.right;
            fCenterX2 = rectF.right;
        }
        f5 = fCenterX - fCenterX2;
        return f5 + jVar.f11803b;
    }

    private float p(View view, View view2, j jVar) {
        float fCenterY;
        float fCenterY2;
        float f5;
        RectF rectF = this.f13513d;
        RectF rectF2 = this.f13514e;
        k(view, rectF);
        r(view2, rectF2);
        int i5 = jVar.f11802a & 112;
        if (i5 == 16) {
            fCenterY = rectF2.centerY();
            fCenterY2 = rectF.centerY();
        } else if (i5 == 48) {
            fCenterY = rectF2.top;
            fCenterY2 = rectF.top;
        } else {
            if (i5 != 80) {
                f5 = 0.0f;
                return f5 + jVar.f11804c;
            }
            fCenterY = rectF2.bottom;
            fCenterY2 = rectF.bottom;
        }
        f5 = fCenterY - fCenterY2;
        return f5 + jVar.f11804c;
    }

    private float q(e eVar, i iVar, float f5, float f6) {
        long jC = iVar.c();
        long jD = iVar.d();
        i iVarE = eVar.f13529a.e("expansion");
        return C0553a.a(f5, f6, iVar.e().getInterpolation((((iVarE.c() + iVarE.d()) + 17) - jC) / jD));
    }

    private void r(View view, RectF rectF) {
        rectF.set(0.0f, 0.0f, view.getWidth(), view.getHeight());
        view.getLocationInWindow(this.f13515f);
        rectF.offsetTo(r3[0], r3[1]);
        rectF.offset((int) (-view.getTranslationX()), (int) (-view.getTranslationY()));
    }

    private void s(View view, View view2, boolean z5, boolean z6, e eVar, List<Animator> list, List<Animator.AnimatorListener> list2) {
        ViewGroup viewGroupI;
        ObjectAnimator objectAnimatorOfFloat;
        if ((view2 instanceof ViewGroup) && (viewGroupI = i(view2)) != null) {
            if (z5) {
                if (!z6) {
                    C0556d.f11789a.set(viewGroupI, Float.valueOf(0.0f));
                }
                objectAnimatorOfFloat = ObjectAnimator.ofFloat(viewGroupI, C0556d.f11789a, 1.0f);
            } else {
                objectAnimatorOfFloat = ObjectAnimator.ofFloat(viewGroupI, C0556d.f11789a, 0.0f);
            }
            eVar.f13529a.e("contentFade").a(objectAnimatorOfFloat);
            list.add(objectAnimatorOfFloat);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void t(View view, View view2, boolean z5, boolean z6, e eVar, List<Animator> list, List<Animator.AnimatorListener> list2) {
        ObjectAnimator objectAnimatorOfInt;
        if (view2 instanceof InterfaceC0748c) {
            InterfaceC0748c interfaceC0748c = (InterfaceC0748c) view2;
            int iB = B(view);
            int i5 = 16777215 & iB;
            if (z5) {
                if (!z6) {
                    interfaceC0748c.setCircularRevealScrimColor(iB);
                }
                objectAnimatorOfInt = ObjectAnimator.ofInt(interfaceC0748c, InterfaceC0748c.d.f17588a, i5);
            } else {
                objectAnimatorOfInt = ObjectAnimator.ofInt(interfaceC0748c, InterfaceC0748c.d.f17588a, iB);
            }
            objectAnimatorOfInt.setEvaluator(C0555c.b());
            eVar.f13529a.e("color").a(objectAnimatorOfInt);
            list.add(objectAnimatorOfInt);
        }
    }

    private void u(View view, View view2, boolean z5, e eVar, List<Animator> list) {
        float fO = o(view, view2, eVar.f13530b);
        float fP = p(view, view2, eVar.f13530b);
        Pair<i, i> pairL = l(fO, fP, z5, eVar);
        i iVar = (i) pairL.first;
        i iVar2 = (i) pairL.second;
        Property property = View.TRANSLATION_X;
        if (!z5) {
            fO = this.f13516g;
        }
        ObjectAnimator objectAnimatorOfFloat = ObjectAnimator.ofFloat(view, (Property<View, Float>) property, fO);
        Property property2 = View.TRANSLATION_Y;
        if (!z5) {
            fP = this.f13517h;
        }
        ObjectAnimator objectAnimatorOfFloat2 = ObjectAnimator.ofFloat(view, (Property<View, Float>) property2, fP);
        iVar.a(objectAnimatorOfFloat);
        iVar2.a(objectAnimatorOfFloat2);
        list.add(objectAnimatorOfFloat);
        list.add(objectAnimatorOfFloat2);
    }

    private void v(View view, View view2, boolean z5, boolean z6, e eVar, List<Animator> list, List<Animator.AnimatorListener> list2) {
        ObjectAnimator objectAnimatorOfFloat;
        float elevation = view2.getElevation() - view.getElevation();
        if (z5) {
            if (!z6) {
                view2.setTranslationZ(-elevation);
            }
            objectAnimatorOfFloat = ObjectAnimator.ofFloat(view2, (Property<View, Float>) View.TRANSLATION_Z, 0.0f);
        } else {
            objectAnimatorOfFloat = ObjectAnimator.ofFloat(view2, (Property<View, Float>) View.TRANSLATION_Z, -elevation);
        }
        eVar.f13529a.e("elevation").a(objectAnimatorOfFloat);
        list.add(objectAnimatorOfFloat);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void w(View view, View view2, boolean z5, boolean z6, e eVar, float f5, float f6, List<Animator> list, List<Animator.AnimatorListener> list2) {
        Animator animatorA;
        if (view2 instanceof InterfaceC0748c) {
            InterfaceC0748c interfaceC0748c = (InterfaceC0748c) view2;
            float fM = m(view, view2, eVar.f13530b);
            float fN = n(view, view2, eVar.f13530b);
            ((FloatingActionButton) view).h(this.f13512c);
            float fWidth = this.f13512c.width() / 2.0f;
            i iVarE = eVar.f13529a.e("expansion");
            if (z5) {
                if (!z6) {
                    interfaceC0748c.setRevealInfo(new InterfaceC0748c.e(fM, fN, fWidth));
                }
                if (z6) {
                    fWidth = interfaceC0748c.getRevealInfo().f17591c;
                }
                animatorA = C0746a.a(interfaceC0748c, fM, fN, C0873a.c(fM, fN, 0.0f, 0.0f, f5, f6));
                animatorA.addListener(new d(interfaceC0748c));
                z(view2, iVarE.c(), (int) fM, (int) fN, fWidth, list);
            } else {
                float f7 = interfaceC0748c.getRevealInfo().f17591c;
                Animator animatorA2 = C0746a.a(interfaceC0748c, fM, fN, fWidth);
                int i5 = (int) fM;
                int i6 = (int) fN;
                z(view2, iVarE.c(), i5, i6, f7, list);
                y(view2, iVarE.c(), iVarE.d(), eVar.f13529a.f(), i5, i6, fWidth, list);
                animatorA = animatorA2;
            }
            iVarE.a(animatorA);
            list.add(animatorA);
            list2.add(C0746a.b(interfaceC0748c));
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void x(View view, View view2, boolean z5, boolean z6, e eVar, List<Animator> list, List<Animator.AnimatorListener> list2) {
        ObjectAnimator objectAnimatorOfInt;
        if ((view2 instanceof InterfaceC0748c) && (view instanceof ImageView)) {
            InterfaceC0748c interfaceC0748c = (InterfaceC0748c) view2;
            Drawable drawable = ((ImageView) view).getDrawable();
            if (drawable == null) {
                return;
            }
            drawable.mutate();
            if (z5) {
                if (!z6) {
                    drawable.setAlpha(255);
                }
                objectAnimatorOfInt = ObjectAnimator.ofInt(drawable, C0557e.f11790a, 0);
            } else {
                objectAnimatorOfInt = ObjectAnimator.ofInt(drawable, C0557e.f11790a, 255);
            }
            objectAnimatorOfInt.addUpdateListener(new b(view2));
            eVar.f13529a.e("iconFade").a(objectAnimatorOfInt);
            list.add(objectAnimatorOfInt);
            list2.add(new c(interfaceC0748c, drawable));
        }
    }

    private void y(View view, long j5, long j6, long j7, int i5, int i6, float f5, List<Animator> list) {
        long j8 = j5 + j6;
        if (j8 < j7) {
            Animator animatorCreateCircularReveal = ViewAnimationUtils.createCircularReveal(view, i5, i6, f5, f5);
            animatorCreateCircularReveal.setStartDelay(j8);
            animatorCreateCircularReveal.setDuration(j7 - j8);
            list.add(animatorCreateCircularReveal);
        }
    }

    private void z(View view, long j5, int i5, int i6, float f5, List<Animator> list) {
        if (j5 > 0) {
            Animator animatorCreateCircularReveal = ViewAnimationUtils.createCircularReveal(view, i5, i6, f5, f5);
            animatorCreateCircularReveal.setStartDelay(0L);
            animatorCreateCircularReveal.setDuration(j5);
            list.add(animatorCreateCircularReveal);
        }
    }

    protected abstract e C(Context context, boolean z5);

    @Override // com.google.android.material.transformation.ExpandableTransformationBehavior
    protected AnimatorSet h(View view, View view2, boolean z5, boolean z6) {
        e eVarC = C(view2.getContext(), z5);
        if (z5) {
            this.f13516g = view.getTranslationX();
            this.f13517h = view.getTranslationY();
        }
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        v(view, view2, z5, z6, eVarC, arrayList, arrayList2);
        RectF rectF = this.f13513d;
        A(view, view2, z5, z6, eVarC, arrayList, arrayList2, rectF);
        float fWidth = rectF.width();
        float fHeight = rectF.height();
        u(view, view2, z5, eVarC, arrayList);
        x(view, view2, z5, z6, eVarC, arrayList, arrayList2);
        w(view, view2, z5, z6, eVarC, fWidth, fHeight, arrayList, arrayList2);
        t(view, view2, z5, z6, eVarC, arrayList, arrayList2);
        s(view, view2, z5, z6, eVarC, arrayList, arrayList2);
        AnimatorSet animatorSet = new AnimatorSet();
        C0554b.a(animatorSet, arrayList);
        animatorSet.addListener(new a(z5, view2, view));
        int size = arrayList2.size();
        for (int i5 = 0; i5 < size; i5++) {
            animatorSet.addListener(arrayList2.get(i5));
        }
        return animatorSet;
    }

    @Override // com.google.android.material.transformation.ExpandableBehavior, androidx.coordinatorlayout.widget.CoordinatorLayout.c
    public boolean layoutDependsOn(CoordinatorLayout coordinatorLayout, View view, View view2) {
        if (view.getVisibility() == 8) {
            throw new IllegalStateException("This behavior cannot be attached to a GONE view. Set the view to INVISIBLE instead.");
        }
        if (!(view2 instanceof FloatingActionButton)) {
            return false;
        }
        int expandedComponentIdHint = ((FloatingActionButton) view2).getExpandedComponentIdHint();
        return expandedComponentIdHint == 0 || expandedComponentIdHint == view.getId();
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.c
    public void onAttachedToLayoutParams(CoordinatorLayout.f fVar) {
        if (fVar.f9432h == 0) {
            fVar.f9432h = 80;
        }
    }

    public FabTransformationBehavior(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f13512c = new Rect();
        this.f13513d = new RectF();
        this.f13514e = new RectF();
        this.f13515f = new int[2];
    }
}
