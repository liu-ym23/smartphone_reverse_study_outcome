package com.google.android.material.transformation;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.util.AttributeSet;
import android.util.Pair;
import android.util.Property;
import android.view.View;
import android.view.ViewAnimationUtils;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.core.view.ViewCompat;
import com.bytedance.bdturing.localstorage.DbHelper;
import com.google.android.material.animation.ArgbEvaluatorCompat;
import com.google.android.material.animation.ChildrenAlphaProperty;
import com.google.android.material.animation.DrawableAlphaProperty;
import com.google.android.material.animation.b;
import com.google.android.material.animation.c;
import com.google.android.material.animation.d;
import com.google.android.material.animation.e;
import com.google.android.material.circularreveal.CircularRevealWidget;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.obric.aiagent.plugin.R;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
@Deprecated
public abstract class FabTransformationBehavior extends ExpandableTransformationBehavior {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Rect f13689a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final RectF f13690b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final RectF f13691c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final int[] f13692d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private float f13693e;
    private float f;

    protected static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public c f13694a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public e f13695b;

        public a() {
        }
    }

    public abstract a a(Context r1, boolean r2);

    public FabTransformationBehavior() {
        this.f13689a = new Rect();
        this.f13690b = new RectF();
        this.f13691c = new RectF();
        this.f13692d = new int[2];
    }

    public FabTransformationBehavior(Context r3, AttributeSet r4) {
        super((Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.aiagent.plugin"), (AttributeSet) ZeusTransformUtils.wrapperContextForParams(r4, AttributeSet.class, "com.obric.aiagent.plugin"));
        this.f13689a = new Rect();
        this.f13690b = new RectF();
        this.f13691c = new RectF();
        this.f13692d = new int[2];
    }

    @Override // com.google.android.material.transformation.ExpandableBehavior, androidx.coordinatorlayout.widget.CoordinatorLayout.b
    public boolean a(CoordinatorLayout r2, View r3, View r4) {
        if (r3.getVisibility() == 8) goto L13;
        if (ZeusTransformUtils.instanceOf(r4, FloatingActionButton.class) == false) goto L14;
        int r1 = ((FloatingActionButton) ZeusTransformUtils.preCheckCast(r4, FloatingActionButton.class, "com.obric.aiagent.plugin")).getExpandedComponentIdHint();
        if (r1 != 0) goto L9;
    L10:
        return true;
    L9:
        if (r1 == r3.getId()) goto L10;
        return false;
    L14:
        return false;
    L13:
        throw new IllegalStateException("This behavior cannot be attached to a GONE view. Set the view to INVISIBLE instead.");
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.b
    public void a(CoordinatorLayout.LayoutParams r1) {
        if (r1.dodgeInsetEdges != 0) goto L6;
        r1.dodgeInsetEdges = 80;
        return;
    }

    @Override // com.google.android.material.transformation.ExpandableTransformationBehavior
    public AnimatorSet b(final View r17, final View r18, final boolean r19, boolean r20) {
        a r13 = a((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r18.getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin"), r19);
        if (r19 == false) goto L5;
        this.f13693e = r17.getTranslationX();
        this.f = r17.getTranslationY();
    L5:
        ArrayList r14 = new ArrayList();
        ArrayList r15 = new ArrayList();
        if (Build.VERSION.SDK_INT < 21) goto L8;
        a(r17, r18, r19, r20, r13, r14, r15);
    L8:
        RectF r9 = this.f13690b;
        a(r17, r18, r19, r20, r13, r14, r15, r9);
        float r8 = r9.width();
        float r10 = r9.height();
        a(r17, r18, r19, r13, r14);
        b(r17, r18, r19, r20, r13, r14, r15);
        a(r17, r18, r19, r20, r13, r8, r10, r14, r15);
        c(r17, r18, r19, r20, r13, r14, r15);
        d(r17, r18, r19, r20, r13, r14, r15);
        AnimatorSet r0 = new AnimatorSet();
        b.a(r0, r14);
        r0.addListener(new AnonymousClass1(this, r19, r18, r17));
        int r1 = 0;
        int r2 = r15.size();
    L9:
        if (r1 >= r2) goto L11;
        r0.addListener((Animator.AnimatorListener) ZeusTransformUtils.preCheckCast(r15.get(r1), Animator.AnimatorListener.class, "com.obric.aiagent.plugin"));
        r1 = r1 + 1;
        goto L9
    L11:
        return r0;
    }

    private void a(View r2, View r3, boolean r4, boolean r5, a r6, List<Animator> r7, List<Animator.AnimatorListener> r8) {
        List r1 = (List) ZeusTransformUtils.wrapperContextForParams(r7, List.class, "com.obric.aiagent.plugin");
        List r9 = (List) ZeusTransformUtils.wrapperContextForParams(r8, List.class, "com.obric.aiagent.plugin");
        float r10 = ViewCompat.q(r3) - ViewCompat.q(r2);
        if (r4 == false) goto L7;
        if (r5 == true) goto L6;
        r3.setTranslationZ(-r10);
    L6:
        ObjectAnimator r11 = ObjectAnimator.ofFloat(r3, View.TRANSLATION_Z, new float[]{0.0f});
    L8:
        r6.f13694a.b("elevation").a(r11);
        r1.add(r11);
        return;
    L7:
        r11 = ObjectAnimator.ofFloat(r3, View.TRANSLATION_Z, new float[]{-r10});
        goto L8
    }

    private void a(View r7, View r8, boolean r9, a r10, List<Animator> r11) {
        List r12 = (List) ZeusTransformUtils.wrapperContextForParams(r11, List.class, "com.obric.aiagent.plugin");
        float r0 = a(r7, r8, r10.f13695b);
        float r13 = b(r7, r8, r10.f13695b);
        Pair<d, d> r14 = a(r0, r13, r9, r10);
        d r2 = (d) ZeusTransformUtils.preCheckCast(r14.first, d.class, "com.obric.aiagent.plugin");
        d r15 = (d) ZeusTransformUtils.preCheckCast(r14.second, d.class, "com.obric.aiagent.plugin");
        Property r1 = View.TRANSLATION_X;
        float[] r4 = new float[1];
        if (r9 == true) goto L6;
        r0 = this.f13693e;
    L6:
        r4[0] = r0;
        ObjectAnimator r3 = ObjectAnimator.ofFloat(r7, r1, r4);
        Property r5 = View.TRANSLATION_Y;
        float[] r6 = new float[1];
        if (r9 == true) goto L10;
        r13 = this.f;
    L10:
        r6[0] = r13;
        ObjectAnimator r16 = ObjectAnimator.ofFloat(r7, r5, r6);
        r2.a(r3);
        r15.a(r16);
        r12.add(r3);
        r12.add(r16);
    }

    private void a(View r16, View r17, boolean r18, boolean r19, a r20, List<Animator> r21, List<Animator.AnimatorListener> r22, RectF r23) {
        List r10 = (List) ZeusTransformUtils.wrapperContextForParams(r21, List.class, "com.obric.aiagent.plugin");
        List r5 = (List) ZeusTransformUtils.wrapperContextForParams(r22, List.class, "com.obric.aiagent.plugin");
        float r6 = a(r16, r17, r20.f13695b);
        float r1 = b(r16, r17, r20.f13695b);
        Pair<d, d> r7 = a(r6, r1, r18, r20);
        d r11 = (d) ZeusTransformUtils.preCheckCast(r7.first, d.class, "com.obric.aiagent.plugin");
        d r12 = (d) ZeusTransformUtils.preCheckCast(r7.second, d.class, "com.obric.aiagent.plugin");
        if (r18 == false) goto L7;
        if (r19 == true) goto L6;
        r17.setTranslationX(-r6);
        r17.setTranslationY(-r1);
    L6:
        ObjectAnimator r13 = ObjectAnimator.ofFloat(r17, View.TRANSLATION_X, new float[]{0.0f});
        ObjectAnimator r14 = ObjectAnimator.ofFloat(r17, View.TRANSLATION_Y, new float[]{0.0f});
        a(r17, r20, r11, r12, -r6, -r1, 0.0f, 0.0f, r23);
    L8:
        r11.a(r13);
        r12.a(r14);
        r10.add(r13);
        r10.add(r14);
        return;
    L7:
        r13 = ObjectAnimator.ofFloat(r17, View.TRANSLATION_X, new float[]{-r6});
        r14 = ObjectAnimator.ofFloat(r17, View.TRANSLATION_Y, new float[]{-r1});
        goto L8
    }

    private void b(View r5, final View r6, boolean r7, boolean r8, a r9, List<Animator> r10, List<Animator.AnimatorListener> r11) {
        List r12 = (List) ZeusTransformUtils.wrapperContextForParams(r10, List.class, "com.obric.aiagent.plugin");
        List r13 = (List) ZeusTransformUtils.wrapperContextForParams(r11, List.class, "com.obric.aiagent.plugin");
        if (ZeusTransformUtils.instanceOf(r6, CircularRevealWidget.class) == true) goto L5;
        return;
    L5:
        if (ZeusTransformUtils.instanceOf(r5, ImageView.class) == false) goto L19;
        final CircularRevealWidget r0 = (CircularRevealWidget) ZeusTransformUtils.preCheckCast(r6, CircularRevealWidget.class, "com.obric.aiagent.plugin");
        final Drawable r14 = ((ImageView) ZeusTransformUtils.preCheckCast(r5, ImageView.class, "com.obric.aiagent.plugin")).getDrawable();
        if (r14 != null) goto L10;
        return;
    L10:
        r14.mutate();
        if (r7 == false) goto L15;
        if (r8 == true) goto L14;
        r14.setAlpha(255);
    L14:
        ObjectAnimator r15 = ObjectAnimator.ofInt(r14, DrawableAlphaProperty.DRAWABLE_ALPHA_COMPAT, new int[]{0});
    L16:
        r15.addUpdateListener(new AnonymousClass2(this, r6));
        r9.f13694a.b("iconFade").a(r15);
        r12.add(r15);
        r13.add(new AnonymousClass3(this, r0, r14));
        return;
    L15:
        r15 = ObjectAnimator.ofInt(r14, DrawableAlphaProperty.DRAWABLE_ALPHA_COMPAT, new int[]{255});
        goto L16
    }

    private void a(View r22, View r23, boolean r24, boolean r25, a r26, float r27, float r28, List<Animator> r29, List<Animator.AnimatorListener> r30) {
        List<Animator> r12 = (List) ZeusTransformUtils.wrapperContextForParams(r29, List.class, "com.obric.aiagent.plugin");
        List r13 = (List) ZeusTransformUtils.wrapperContextForParams(r30, List.class, "com.obric.aiagent.plugin");
        if (ZeusTransformUtils.instanceOf(r23, CircularRevealWidget.class) == true) goto L5;
        return;
    L5:
        final CircularRevealWidget r14 = (CircularRevealWidget) ZeusTransformUtils.preCheckCast(r23, CircularRevealWidget.class, "com.obric.aiagent.plugin");
        float r1 = c(r22, r23, r26.f13695b);
        float r3 = d(r22, r23, r26.f13695b);
        ((FloatingActionButton) ZeusTransformUtils.preCheckCast(r22, FloatingActionButton.class, "com.obric.aiagent.plugin")).getContentRect(this.f13689a);
        float r11 = this.f13689a.width() / 2.0f;
        d r7 = r26.f13694a.b("expansion");
        if (r24 == false) goto L13;
        if (r25 == true) goto L9;
        r14.setRevealInfo(new CircularRevealWidget.a(r1, r3, r11));
    L9:
        if (r25 == false) goto L11;
        float r6 = r14.getRevealInfo().f13297c;
    L12:
        Animator r10 = com.google.android.material.circularreveal.a.a(r14, r1, r3, com.google.android.material.e.a.a(r1, r3, 0.0f, 0.0f, r27, r28));
        r10.addListener(new AnonymousClass4(this, r14));
        d r15 = r7;
        a(r23, r7.a(), (int) r1, (int) r3, r6, r12);
    L14:
        r15.a(r10);
        r12.add(r10);
        r13.add(com.google.android.material.circularreveal.a.a(r14));
        return;
    L11:
        r6 = r11;
        goto L12
    L13:
        r15 = r7;
        float r8 = r14.getRevealInfo().f13297c;
        Animator r16 = com.google.android.material.circularreveal.a.a(r14, r1, r3, r11);
        int r9 = (int) r1;
        int r2 = (int) r3;
        a(r23, r15.a(), r9, r2, r8, r12);
        a(r23, r15.a(), r15.b(), r26.f13694a.a(), r9, r2, r11, r12);
        r10 = r16;
        goto L14
    }

    private void c(View r3, View r4, boolean r5, boolean r6, a r7, List<Animator> r8, List<Animator.AnimatorListener> r9) {
        List r10 = (List) ZeusTransformUtils.wrapperContextForParams(r8, List.class, "com.obric.aiagent.plugin");
        List r11 = (List) ZeusTransformUtils.wrapperContextForParams(r9, List.class, "com.obric.aiagent.plugin");
        if (ZeusTransformUtils.instanceOf(r4, CircularRevealWidget.class) == true) goto L5;
        return;
    L5:
        CircularRevealWidget r12 = (CircularRevealWidget) ZeusTransformUtils.preCheckCast(r4, CircularRevealWidget.class, "com.obric.aiagent.plugin");
        int r2 = c(r3);
        int r13 = 16777215 & r2;
        if (r5 == false) goto L10;
        if (r6 == true) goto L9;
        r12.setCircularRevealScrimColor(r2);
    L9:
        ObjectAnimator r14 = ObjectAnimator.ofInt(r12, CircularRevealWidget.CircularRevealScrimColorProperty.CIRCULAR_REVEAL_SCRIM_COLOR, new int[]{r13});
    L11:
        r14.setEvaluator(ArgbEvaluatorCompat.getInstance());
        r7.f13694a.b("color").a(r14);
        r10.add(r14);
        return;
    L10:
        r14 = ObjectAnimator.ofInt(r12, CircularRevealWidget.CircularRevealScrimColorProperty.CIRCULAR_REVEAL_SCRIM_COLOR, new int[]{r2});
        goto L11
    }

    private void d(View r2, View r3, boolean r4, boolean r5, a r6, List<Animator> r7, List<Animator.AnimatorListener> r8) {
        List r9 = (List) ZeusTransformUtils.wrapperContextForParams(r7, List.class, "com.obric.aiagent.plugin");
        List r10 = (List) ZeusTransformUtils.wrapperContextForParams(r8, List.class, "com.obric.aiagent.plugin");
        if (ZeusTransformUtils.instanceOf(r3, ViewGroup.class) == true) goto L6;
        return;
    L6:
        if (ZeusTransformUtils.instanceOf(r3, CircularRevealWidget.class) == true) goto L8;
    L10:
        ViewGroup r1 = a(r3);
        if (r1 != null) goto L14;
        return;
    L14:
        if (r4 == false) goto L18;
        if (r5 == true) goto L17;
        ChildrenAlphaProperty.CHILDREN_ALPHA.set(r1, Float.valueOf(0.0f));
    L17:
        ObjectAnimator r11 = ObjectAnimator.ofFloat(r1, ChildrenAlphaProperty.CHILDREN_ALPHA, new float[]{1.0f});
    L19:
        r6.f13694a.b("contentFade").a(r11);
        r9.add(r11);
        return;
    L18:
        r11 = ObjectAnimator.ofFloat(r1, ChildrenAlphaProperty.CHILDREN_ALPHA, new float[]{0.0f});
        goto L19
    L8:
        if (com.google.android.material.circularreveal.b.f13298a != 0) goto L10;
    }

    private Pair<d, d> a(float r1, float r2, boolean r3, a r4) {
        if (r1 != 0.0f) goto L5;
    L14:
        d r0 = r4.f13694a.b("translationXLinear");
        d r5 = r4.f13694a.b("translationYLinear");
    L16:
        return new Pair(r0, r5);
    L5:
        if (r2 == 0.0f) goto L14;
        if (r3 == true) goto L9;
    L10:
        if (r3 == true) goto L13;
        if (r2 <= 0.0f) goto L13;
    L12:
        r0 = r4.f13694a.b("translationXCurveUpwards");
        r5 = r4.f13694a.b("translationYCurveUpwards");
    L13:
        r0 = r4.f13694a.b("translationXCurveDownwards");
        r5 = r4.f13694a.b("translationYCurveDownwards");
        goto L16
    L9:
        if (r2 < 0.0f) goto L12;
        goto L10
    }

    private float a(View r3, View r4, e r5) {
        RectF r0 = this.f13690b;
        RectF r1 = this.f13691c;
        b(r3, r0);
        a(r4, r1);
        int r2 = r5.f13154a & 7;
        if (r2 != 1) goto L5;
        float r6 = r1.centerX();
        float r7 = r0.centerX();
    L12:
        float r8 = r6 - r7;
    L14:
        return r8 + r5.f13155b;
    L5:
        if (r2 != 3) goto L7;
        r6 = r1.left;
        r7 = r0.left;
        goto L12
    L7:
        if (r2 == 5) goto L9;
        r8 = 0.0f;
        goto L14
    L9:
        r6 = r1.right;
        r7 = r0.right;
        goto L12
    }

    private float b(View r3, View r4, e r5) {
        RectF r0 = this.f13690b;
        RectF r1 = this.f13691c;
        b(r3, r0);
        a(r4, r1);
        int r2 = r5.f13154a & 112;
        if (r2 != 16) goto L5;
        float r6 = r1.centerY();
        float r7 = r0.centerY();
    L12:
        float r8 = r6 - r7;
    L14:
        return r8 + r5.f13156c;
    L5:
        if (r2 != 48) goto L7;
        r6 = r1.top;
        r7 = r0.top;
        goto L12
    L7:
        if (r2 == 80) goto L9;
        r8 = 0.0f;
        goto L14
    L9:
        r6 = r1.bottom;
        r7 = r0.bottom;
        goto L12
    }

    private void a(View r4, RectF r5) {
        r5.set(0.0f, 0.0f, r4.getWidth(), r4.getHeight());
        int[] r3 = this.f13692d;
        r4.getLocationInWindow(r3);
        r5.offsetTo(r3[0], r3[1]);
        r5.offset((int) (-r4.getTranslationX()), (int) (-r4.getTranslationY()));
    }

    private void b(View r1, RectF r2) {
        a(r1, r2);
        r2.offset(this.f13693e, this.f);
    }

    private float c(View r3, View r4, e r5) {
        RectF r0 = this.f13690b;
        RectF r1 = this.f13691c;
        b(r3, r0);
        a(r4, r1);
        r1.offset(-a(r3, r4, r5), 0.0f);
        return r0.centerX() - r1.left;
    }

    private float d(View r3, View r4, e r5) {
        RectF r0 = this.f13690b;
        RectF r1 = this.f13691c;
        b(r3, r0);
        a(r4, r1);
        r1.offset(0.0f, -b(r3, r4, r5));
        return r0.centerY() - r1.top;
    }

    private void a(View r1, a r2, d r3, d r4, float r5, float r6, float r7, float r8, RectF r9) {
        float r10 = a(r2, r3, r5, r7);
        float r11 = a(r2, r4, r6, r8);
        Rect r12 = this.f13689a;
        r1.getWindowVisibleDisplayFrame(r12);
        RectF r13 = this.f13690b;
        r13.set(r12);
        RectF r14 = this.f13691c;
        a(r1, r14);
        r14.offset(r10, r11);
        r14.intersect(r13);
        r9.set(r14);
    }

    private float a(a r7, d r8, float r9, float r10) {
        long r0 = r8.a();
        long r2 = r8.b();
        d r6 = r7.f13694a.b("expansion");
        return com.google.android.material.animation.a.a(r9, r10, r8.c().getInterpolation((((r6.a() + r6.b()) + 17) - r0) / r2));
    }

    private ViewGroup a(View r4) {
        View r0 = r4.findViewById(ZeusTransformUtils.mapRes(R.id.mtrl_child_content_container, DbHelper.COL_ID, "mtrl_child_content_container"));
        if (r0 == null) goto L7;
        return b(r0);
    L7:
        if (ZeusTransformUtils.instanceOf(r4, TransformationChildLayout.class) == true) goto L14;
        if (ZeusTransformUtils.instanceOf(r4, TransformationChildCard.class) == true) goto L14;
        return b(r4);
    L14:
        return b(((ViewGroup) ZeusTransformUtils.preCheckCast(r4, ViewGroup.class, "com.obric.aiagent.plugin")).getChildAt(0));
    }

    private ViewGroup b(View r2) {
        if (ZeusTransformUtils.instanceOf(r2, ViewGroup.class) == true) goto L5;
        return null;
    L5:
        return (ViewGroup) ZeusTransformUtils.preCheckCast(r2, ViewGroup.class, "com.obric.aiagent.plugin");
    }

    private int c(View r2) {
        ColorStateList r1 = ViewCompat.B(r2);
        if (r1 != null) goto L5;
        return 0;
    L5:
        return r1.getColorForState(r2.getDrawableState(), r1.getDefaultColor());
    }

    private void a(View r3, long r4, int r6, int r7, float r8, List<Animator> r9) {
        List r2 = (List) ZeusTransformUtils.wrapperContextForParams(r9, List.class, "com.obric.aiagent.plugin");
        if (Build.VERSION.SDK_INT >= 21) goto L5;
        return;
    L5:
        if (r4 <= 0) goto L9;
        Animator r5 = ViewAnimationUtils.createCircularReveal(r3, r6, r7, r8, r8);
        r5.setStartDelay(0);
        r5.setDuration(r4);
        r2.add(r5);
        return;
    }

    private void a(View r2, long r3, long r5, long r7, int r9, int r10, float r11, List<Animator> r12) {
        List r1 = (List) ZeusTransformUtils.wrapperContextForParams(r12, List.class, "com.obric.aiagent.plugin");
        if (Build.VERSION.SDK_INT < 21) goto L8;
        long r4 = r3 + r5;
        if (r4 >= r7) goto L9;
        Animator r6 = ViewAnimationUtils.createCircularReveal(r2, r9, r10, r11, r11);
        r6.setStartDelay(r4);
        r6.setDuration(r7 - r4);
        r1.add(r6);
        return;
    L9:
        return;
    }
}
