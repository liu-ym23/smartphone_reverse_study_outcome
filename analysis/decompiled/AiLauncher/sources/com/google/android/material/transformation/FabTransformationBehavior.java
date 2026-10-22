package com.google.android.material.transformation;

import E2.h;
import E2.i;
import E2.j;
import K2.c;
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
import com.google.android.material.R$id;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import e3.C3985a;
import e3.C3986b;
import java.util.ArrayList;
import java.util.List;

@Deprecated
/* loaded from: classes2.dex */
public abstract class FabTransformationBehavior extends ExpandableTransformationBehavior {

    /* renamed from: c, reason: collision with root package name */
    public final Rect f21772c;

    /* renamed from: d, reason: collision with root package name */
    public final RectF f21773d;

    /* renamed from: e, reason: collision with root package name */
    public final RectF f21774e;

    /* renamed from: f, reason: collision with root package name */
    public final int[] f21775f;

    /* renamed from: g, reason: collision with root package name */
    public float f21776g;

    /* renamed from: h, reason: collision with root package name */
    public float f21777h;

    public class a extends AnimatorListenerAdapter {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ boolean f21778a;

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ View f21779b;

        /* renamed from: c, reason: collision with root package name */
        public final /* synthetic */ View f21780c;

        public a(boolean z10, View view, View view2) {
            this.f21778a = z10;
            this.f21779b = view;
            this.f21780c = view2;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            if (this.f21778a) {
                return;
            }
            this.f21779b.setVisibility(4);
            this.f21780c.setAlpha(1.0f);
            this.f21780c.setVisibility(0);
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            if (this.f21778a) {
                this.f21779b.setVisibility(0);
                this.f21780c.setAlpha(0.0f);
                this.f21780c.setVisibility(4);
            }
        }
    }

    public class b implements ValueAnimator.AnimatorUpdateListener {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ View f21782a;

        public b(View view) {
            this.f21782a = view;
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            this.f21782a.invalidate();
        }
    }

    public class c extends AnimatorListenerAdapter {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ K2.c f21784a;

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ Drawable f21785b;

        public c(K2.c cVar, Drawable drawable) {
            this.f21784a = cVar;
            this.f21785b = drawable;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            this.f21784a.setCircularRevealOverlayDrawable(null);
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            this.f21784a.setCircularRevealOverlayDrawable(this.f21785b);
        }
    }

    public class d extends AnimatorListenerAdapter {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ K2.c f21787a;

        public d(K2.c cVar) {
            this.f21787a = cVar;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            c.e revealInfo = this.f21787a.getRevealInfo();
            revealInfo.f4101c = Float.MAX_VALUE;
            this.f21787a.setRevealInfo(revealInfo);
        }
    }

    public static class e {

        /* renamed from: a, reason: collision with root package name */
        public h f21789a;

        /* renamed from: b, reason: collision with root package name */
        public j f21790b;
    }

    public FabTransformationBehavior() {
        this.f21772c = new Rect();
        this.f21773d = new RectF();
        this.f21774e = new RectF();
        this.f21775f = new int[2];
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void A(View view, View view2, boolean z10, boolean z11, e eVar, float f10, float f11, List<Animator> list, List<Animator.AnimatorListener> list2) {
        Animator animatorA;
        if (view2 instanceof K2.c) {
            K2.c cVar = (K2.c) view2;
            float fQ = q(view, view2, eVar.f21790b);
            float fR = r(view, view2, eVar.f21790b);
            ((FloatingActionButton) view).h(this.f21772c);
            float fWidth = this.f21772c.width() / 2.0f;
            i iVarE = eVar.f21789a.e("expansion");
            if (z10) {
                if (!z11) {
                    cVar.setRevealInfo(new c.e(fQ, fR, fWidth));
                }
                if (z11) {
                    fWidth = cVar.getRevealInfo().f4101c;
                }
                animatorA = K2.a.a(cVar, fQ, fR, S2.a.c(fQ, fR, 0.0f, 0.0f, f10, f11));
                animatorA.addListener(new d(cVar));
                D(view2, iVarE.c(), (int) fQ, (int) fR, fWidth, list);
            } else {
                float f12 = cVar.getRevealInfo().f4101c;
                Animator animatorA2 = K2.a.a(cVar, fQ, fR, fWidth);
                int i10 = (int) fQ;
                int i11 = (int) fR;
                D(view2, iVarE.c(), i10, i11, f12, list);
                C(view2, iVarE.c(), iVarE.d(), eVar.f21789a.f(), i10, i11, fWidth, list);
                animatorA = animatorA2;
            }
            iVarE.a(animatorA);
            list.add(animatorA);
            list2.add(K2.a.b(cVar));
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void B(View view, View view2, boolean z10, boolean z11, e eVar, List<Animator> list, List<Animator.AnimatorListener> list2) {
        ObjectAnimator objectAnimatorOfInt;
        if ((view2 instanceof K2.c) && (view instanceof ImageView)) {
            K2.c cVar = (K2.c) view2;
            Drawable drawable = ((ImageView) view).getDrawable();
            if (drawable == null) {
                return;
            }
            drawable.mutate();
            if (z10) {
                if (!z11) {
                    drawable.setAlpha(255);
                }
                objectAnimatorOfInt = ObjectAnimator.ofInt(drawable, E2.e.f2346a, 0);
            } else {
                objectAnimatorOfInt = ObjectAnimator.ofInt(drawable, E2.e.f2346a, 255);
            }
            objectAnimatorOfInt.addUpdateListener(new b(view2));
            eVar.f21789a.e("iconFade").a(objectAnimatorOfInt);
            list.add(objectAnimatorOfInt);
            list2.add(new c(cVar, drawable));
        }
    }

    public final void C(View view, long j10, long j11, long j12, int i10, int i11, float f10, List<Animator> list) {
        long j13 = j10 + j11;
        if (j13 < j12) {
            Animator animatorCreateCircularReveal = ViewAnimationUtils.createCircularReveal(view, i10, i11, f10, f10);
            animatorCreateCircularReveal.setStartDelay(j13);
            animatorCreateCircularReveal.setDuration(j12 - j13);
            list.add(animatorCreateCircularReveal);
        }
    }

    public final void D(View view, long j10, int i10, int i11, float f10, List<Animator> list) {
        if (j10 > 0) {
            Animator animatorCreateCircularReveal = ViewAnimationUtils.createCircularReveal(view, i10, i11, f10, f10);
            animatorCreateCircularReveal.setStartDelay(0L);
            animatorCreateCircularReveal.setDuration(j10);
            list.add(animatorCreateCircularReveal);
        }
    }

    public final void E(View view, View view2, boolean z10, boolean z11, e eVar, List<Animator> list, List<Animator.AnimatorListener> list2, RectF rectF) {
        i iVar;
        i iVar2;
        ObjectAnimator objectAnimatorOfFloat;
        ObjectAnimator objectAnimatorOfFloat2;
        float fS = s(view, view2, eVar.f21790b);
        float fT = t(view, view2, eVar.f21790b);
        Pair<i, i> pairP = p(fS, fT, z10, eVar);
        i iVar3 = (i) pairP.first;
        i iVar4 = (i) pairP.second;
        if (z10) {
            if (!z11) {
                view2.setTranslationX(-fS);
                view2.setTranslationY(-fT);
            }
            objectAnimatorOfFloat = ObjectAnimator.ofFloat(view2, (Property<View, Float>) View.TRANSLATION_X, 0.0f);
            objectAnimatorOfFloat2 = ObjectAnimator.ofFloat(view2, (Property<View, Float>) View.TRANSLATION_Y, 0.0f);
            iVar = iVar4;
            iVar2 = iVar3;
            n(view2, eVar, iVar2, iVar, -fS, -fT, 0.0f, 0.0f, rectF);
        } else {
            iVar = iVar4;
            iVar2 = iVar3;
            objectAnimatorOfFloat = ObjectAnimator.ofFloat(view2, (Property<View, Float>) View.TRANSLATION_X, -fS);
            objectAnimatorOfFloat2 = ObjectAnimator.ofFloat(view2, (Property<View, Float>) View.TRANSLATION_Y, -fT);
        }
        iVar2.a(objectAnimatorOfFloat);
        iVar.a(objectAnimatorOfFloat2);
        list.add(objectAnimatorOfFloat);
        list.add(objectAnimatorOfFloat2);
    }

    public final int F(View view) {
        ColorStateList backgroundTintList = view.getBackgroundTintList();
        if (backgroundTintList != null) {
            return backgroundTintList.getColorForState(view.getDrawableState(), backgroundTintList.getDefaultColor());
        }
        return 0;
    }

    public abstract e G(Context context, boolean z10);

    public final ViewGroup H(View view) {
        if (view instanceof ViewGroup) {
            return (ViewGroup) view;
        }
        return null;
    }

    @Override // com.google.android.material.transformation.ExpandableTransformationBehavior
    public AnimatorSet l(View view, View view2, boolean z10, boolean z11) {
        e eVarG = G(view2.getContext(), z10);
        if (z10) {
            this.f21776g = view.getTranslationX();
            this.f21777h = view.getTranslationY();
        }
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        z(view, view2, z10, z11, eVarG, arrayList, arrayList2);
        RectF rectF = this.f21773d;
        E(view, view2, z10, z11, eVarG, arrayList, arrayList2, rectF);
        float fWidth = rectF.width();
        float fHeight = rectF.height();
        y(view, view2, z10, eVarG, arrayList);
        B(view, view2, z10, z11, eVarG, arrayList, arrayList2);
        A(view, view2, z10, z11, eVarG, fWidth, fHeight, arrayList, arrayList2);
        x(view, view2, z10, z11, eVarG, arrayList, arrayList2);
        w(view, view2, z10, z11, eVarG, arrayList, arrayList2);
        AnimatorSet animatorSet = new AnimatorSet();
        E2.b.a(animatorSet, arrayList);
        animatorSet.addListener(new a(z10, view2, view));
        int size = arrayList2.size();
        for (int i10 = 0; i10 < size; i10++) {
            animatorSet.addListener(arrayList2.get(i10));
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

    public final ViewGroup m(View view) {
        View viewFindViewById = view.findViewById(R$id.mtrl_child_content_container);
        return viewFindViewById != null ? H(viewFindViewById) : ((view instanceof C3986b) || (view instanceof C3985a)) ? H(((ViewGroup) view).getChildAt(0)) : H(view);
    }

    public final void n(View view, e eVar, i iVar, i iVar2, float f10, float f11, float f12, float f13, RectF rectF) {
        float fU = u(eVar, iVar, f10, f12);
        float fU2 = u(eVar, iVar2, f11, f13);
        Rect rect = this.f21772c;
        view.getWindowVisibleDisplayFrame(rect);
        RectF rectF2 = this.f21773d;
        rectF2.set(rect);
        RectF rectF3 = this.f21774e;
        v(view, rectF3);
        rectF3.offset(fU, fU2);
        rectF3.intersect(rectF2);
        rectF.set(rectF3);
    }

    public final void o(View view, RectF rectF) {
        v(view, rectF);
        rectF.offset(this.f21776g, this.f21777h);
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.c
    public void onAttachedToLayoutParams(CoordinatorLayout.f fVar) {
        if (fVar.f12914h == 0) {
            fVar.f12914h = 80;
        }
    }

    public final Pair<i, i> p(float f10, float f11, boolean z10, e eVar) {
        i iVarE;
        i iVarE2;
        if (f10 == 0.0f || f11 == 0.0f) {
            iVarE = eVar.f21789a.e("translationXLinear");
            iVarE2 = eVar.f21789a.e("translationYLinear");
        } else if ((!z10 || f11 >= 0.0f) && (z10 || f11 <= 0.0f)) {
            iVarE = eVar.f21789a.e("translationXCurveDownwards");
            iVarE2 = eVar.f21789a.e("translationYCurveDownwards");
        } else {
            iVarE = eVar.f21789a.e("translationXCurveUpwards");
            iVarE2 = eVar.f21789a.e("translationYCurveUpwards");
        }
        return new Pair<>(iVarE, iVarE2);
    }

    public final float q(View view, View view2, j jVar) {
        RectF rectF = this.f21773d;
        RectF rectF2 = this.f21774e;
        o(view, rectF);
        v(view2, rectF2);
        rectF2.offset(-s(view, view2, jVar), 0.0f);
        return rectF.centerX() - rectF2.left;
    }

    public final float r(View view, View view2, j jVar) {
        RectF rectF = this.f21773d;
        RectF rectF2 = this.f21774e;
        o(view, rectF);
        v(view2, rectF2);
        rectF2.offset(0.0f, -t(view, view2, jVar));
        return rectF.centerY() - rectF2.top;
    }

    public final float s(View view, View view2, j jVar) {
        float fCenterX;
        float fCenterX2;
        float f10;
        RectF rectF = this.f21773d;
        RectF rectF2 = this.f21774e;
        o(view, rectF);
        v(view2, rectF2);
        int i10 = jVar.f2358a & 7;
        if (i10 == 1) {
            fCenterX = rectF2.centerX();
            fCenterX2 = rectF.centerX();
        } else if (i10 == 3) {
            fCenterX = rectF2.left;
            fCenterX2 = rectF.left;
        } else {
            if (i10 != 5) {
                f10 = 0.0f;
                return f10 + jVar.f2359b;
            }
            fCenterX = rectF2.right;
            fCenterX2 = rectF.right;
        }
        f10 = fCenterX - fCenterX2;
        return f10 + jVar.f2359b;
    }

    public final float t(View view, View view2, j jVar) {
        float fCenterY;
        float fCenterY2;
        float f10;
        RectF rectF = this.f21773d;
        RectF rectF2 = this.f21774e;
        o(view, rectF);
        v(view2, rectF2);
        int i10 = jVar.f2358a & 112;
        if (i10 == 16) {
            fCenterY = rectF2.centerY();
            fCenterY2 = rectF.centerY();
        } else if (i10 == 48) {
            fCenterY = rectF2.top;
            fCenterY2 = rectF.top;
        } else {
            if (i10 != 80) {
                f10 = 0.0f;
                return f10 + jVar.f2360c;
            }
            fCenterY = rectF2.bottom;
            fCenterY2 = rectF.bottom;
        }
        f10 = fCenterY - fCenterY2;
        return f10 + jVar.f2360c;
    }

    public final float u(e eVar, i iVar, float f10, float f11) {
        long jC = iVar.c();
        long jD = iVar.d();
        i iVarE = eVar.f21789a.e("expansion");
        return E2.a.a(f10, f11, iVar.e().getInterpolation((((iVarE.c() + iVarE.d()) + 17) - jC) / jD));
    }

    public final void v(View view, RectF rectF) {
        rectF.set(0.0f, 0.0f, view.getWidth(), view.getHeight());
        view.getLocationInWindow(this.f21775f);
        rectF.offsetTo(r3[0], r3[1]);
        rectF.offset((int) (-view.getTranslationX()), (int) (-view.getTranslationY()));
    }

    public final void w(View view, View view2, boolean z10, boolean z11, e eVar, List<Animator> list, List<Animator.AnimatorListener> list2) {
        ViewGroup viewGroupM;
        ObjectAnimator objectAnimatorOfFloat;
        if ((view2 instanceof ViewGroup) && (viewGroupM = m(view2)) != null) {
            if (z10) {
                if (!z11) {
                    E2.d.f2345a.set(viewGroupM, Float.valueOf(0.0f));
                }
                objectAnimatorOfFloat = ObjectAnimator.ofFloat(viewGroupM, E2.d.f2345a, 1.0f);
            } else {
                objectAnimatorOfFloat = ObjectAnimator.ofFloat(viewGroupM, E2.d.f2345a, 0.0f);
            }
            eVar.f21789a.e("contentFade").a(objectAnimatorOfFloat);
            list.add(objectAnimatorOfFloat);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void x(View view, View view2, boolean z10, boolean z11, e eVar, List<Animator> list, List<Animator.AnimatorListener> list2) {
        ObjectAnimator objectAnimatorOfInt;
        if (view2 instanceof K2.c) {
            K2.c cVar = (K2.c) view2;
            int iF = F(view);
            int i10 = 16777215 & iF;
            if (z10) {
                if (!z11) {
                    cVar.setCircularRevealScrimColor(iF);
                }
                objectAnimatorOfInt = ObjectAnimator.ofInt(cVar, c.d.f4098a, i10);
            } else {
                objectAnimatorOfInt = ObjectAnimator.ofInt(cVar, c.d.f4098a, iF);
            }
            objectAnimatorOfInt.setEvaluator(E2.c.b());
            eVar.f21789a.e("color").a(objectAnimatorOfInt);
            list.add(objectAnimatorOfInt);
        }
    }

    public final void y(View view, View view2, boolean z10, e eVar, List<Animator> list) {
        float fS = s(view, view2, eVar.f21790b);
        float fT = t(view, view2, eVar.f21790b);
        Pair<i, i> pairP = p(fS, fT, z10, eVar);
        i iVar = (i) pairP.first;
        i iVar2 = (i) pairP.second;
        Property property = View.TRANSLATION_X;
        if (!z10) {
            fS = this.f21776g;
        }
        ObjectAnimator objectAnimatorOfFloat = ObjectAnimator.ofFloat(view, (Property<View, Float>) property, fS);
        Property property2 = View.TRANSLATION_Y;
        if (!z10) {
            fT = this.f21777h;
        }
        ObjectAnimator objectAnimatorOfFloat2 = ObjectAnimator.ofFloat(view, (Property<View, Float>) property2, fT);
        iVar.a(objectAnimatorOfFloat);
        iVar2.a(objectAnimatorOfFloat2);
        list.add(objectAnimatorOfFloat);
        list.add(objectAnimatorOfFloat2);
    }

    public final void z(View view, View view2, boolean z10, boolean z11, e eVar, List<Animator> list, List<Animator.AnimatorListener> list2) {
        ObjectAnimator objectAnimatorOfFloat;
        float elevation = view2.getElevation() - view.getElevation();
        if (z10) {
            if (!z11) {
                view2.setTranslationZ(-elevation);
            }
            objectAnimatorOfFloat = ObjectAnimator.ofFloat(view2, (Property<View, Float>) View.TRANSLATION_Z, 0.0f);
        } else {
            objectAnimatorOfFloat = ObjectAnimator.ofFloat(view2, (Property<View, Float>) View.TRANSLATION_Z, -elevation);
        }
        eVar.f21789a.e("elevation").a(objectAnimatorOfFloat);
        list.add(objectAnimatorOfFloat);
    }

    public FabTransformationBehavior(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f21772c = new Rect();
        this.f21773d = new RectF();
        this.f21774e = new RectF();
        this.f21775f = new int[2];
    }
}
