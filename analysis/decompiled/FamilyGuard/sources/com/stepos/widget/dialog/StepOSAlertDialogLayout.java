package com.stepos.widget.dialog;

import K2.o;
import V3.m;
import V3.r;
import V3.v;
import W3.C;
import W3.C0403n;
import android.R;
import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Outline;
import android.graphics.drawable.Drawable;
import android.provider.Settings;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewOutlineProvider;
import android.view.ViewTreeObserver;
import android.view.WindowInsets;
import android.view.WindowManager;
import android.view.WindowMetrics;
import android.view.animation.AnimationUtils;
import android.view.animation.LinearInterpolator;
import androidx.appcompat.widget.LinearLayoutCompat;
import androidx.core.view.A;
import com.stepos.widget.dialog.StepOSAlertDialogLayout;
import g4.C0743a;
import i4.InterfaceC0761a;
import j4.g;
import j4.k;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.ranges.h;
import kotlin.ranges.l;
import l3.C0845c;
import l3.C0847e;
import l3.f;
import l3.i;
import p3.s;
import r3.C1009e;
import r3.C1012h;

/* loaded from: classes.dex */
public final class StepOSAlertDialogLayout extends LinearLayoutCompat {

    /* renamed from: A, reason: collision with root package name */
    private o f16128A;

    /* renamed from: B, reason: collision with root package name */
    private int f16129B;

    /* renamed from: C, reason: collision with root package name */
    private int f16130C;

    /* renamed from: D, reason: collision with root package name */
    private boolean f16131D;

    /* renamed from: p, reason: collision with root package name */
    private final C1009e f16132p;

    /* renamed from: q, reason: collision with root package name */
    private Drawable f16133q;

    /* renamed from: r, reason: collision with root package name */
    private m<Integer, Integer> f16134r;

    /* renamed from: s, reason: collision with root package name */
    private A f16135s;

    /* renamed from: t, reason: collision with root package name */
    private int f16136t;

    /* renamed from: u, reason: collision with root package name */
    private ValueAnimator f16137u;

    /* renamed from: v, reason: collision with root package name */
    private Runnable f16138v;

    /* renamed from: w, reason: collision with root package name */
    private ViewTreeObserver f16139w;

    /* renamed from: x, reason: collision with root package name */
    private final Runnable f16140x;

    /* renamed from: y, reason: collision with root package name */
    private final C1012h f16141y;

    /* renamed from: z, reason: collision with root package name */
    private boolean f16142z;

    public static final class a extends ViewOutlineProvider {
        a() {
        }

        @Override // android.view.ViewOutlineProvider
        public void getOutline(View view, Outline outline) {
            k.g(view, "view");
            k.g(outline, "outline");
            outline.setRoundRect(0, 0, view.getWidth(), view.getHeight(), StepOSAlertDialogLayout.this.getResources().getDimension(C0847e.f18364j));
        }
    }

    public static final class b implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ WeakReference<StepOSAlertDialogLayout> f16144a;

        b(WeakReference<StepOSAlertDialogLayout> weakReference) {
            this.f16144a = weakReference;
        }

        @Override // java.lang.Runnable
        public void run() {
            StepOSAlertDialogLayout stepOSAlertDialogLayout = this.f16144a.get();
            if (stepOSAlertDialogLayout != null && stepOSAlertDialogLayout.f16138v == this) {
                stepOSAlertDialogLayout.f16138v = null;
                stepOSAlertDialogLayout.f16139w = null;
                if (stepOSAlertDialogLayout.isAttachedToWindow() && stepOSAlertDialogLayout.Q() && stepOSAlertDialogLayout.f16132p.l()) {
                    stepOSAlertDialogLayout.postOnAnimationDelayed(stepOSAlertDialogLayout.f16140x, stepOSAlertDialogLayout.M());
                }
            }
        }
    }

    public static final class c extends AnimatorListenerAdapter {
        c() {
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            k.g(animator, "animation");
            StepOSAlertDialogLayout.this.f16137u = null;
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public StepOSAlertDialogLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, null);
        k.g(context, "context");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final long M() throws Exception {
        long integer = getResources().getInteger(i.f18452a);
        ViewGroup.LayoutParams layoutParams = getRootView().getLayoutParams();
        Float f5 = null;
        WindowManager.LayoutParams layoutParams2 = layoutParams instanceof WindowManager.LayoutParams ? (WindowManager.LayoutParams) layoutParams : null;
        int i5 = layoutParams2 != null ? layoutParams2.windowAnimations : 0;
        long jComputeDurationHint = 0;
        if (i5 != 0) {
            try {
                TypedArray typedArrayObtainStyledAttributes = getContext().obtainStyledAttributes(i5, new int[]{R.attr.windowEnterAnimation});
                try {
                    int resourceId = typedArrayObtainStyledAttributes.getResourceId(0, 0);
                    C0743a.a(typedArrayObtainStyledAttributes, null);
                    if (resourceId != 0) {
                        jComputeDurationHint = AnimationUtils.loadAnimation(getContext(), resourceId).computeDurationHint();
                    }
                } finally {
                }
            } catch (Resources.NotFoundException unused) {
                jComputeDurationHint = integer;
            }
        }
        float fFloatValue = 1.0f;
        try {
            Float fValueOf = Float.valueOf(Settings.Global.getFloat(getContext().getContentResolver(), "window_animation_scale", 1.0f));
            float fFloatValue2 = fValueOf.floatValue();
            if (!Float.isInfinite(fFloatValue2) && !Float.isNaN(fFloatValue2) && fFloatValue2 >= 0.0f) {
                f5 = fValueOf;
            }
            if (f5 != null) {
                fFloatValue = f5.floatValue();
            }
        } catch (SecurityException unused2) {
        }
        return Math.max(integer, (long) (jComputeDurationHint * fFloatValue));
    }

    private final void N() {
        A a6 = this.f16135s;
        if (a6 != null) {
            a6.b();
        }
        this.f16135s = null;
    }

    private final int O(View view, int i5) {
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        k.e(layoutParams, "null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
        return ViewGroup.getChildMeasureSpec(i5, getPaddingLeft() + getPaddingRight() + marginLayoutParams.leftMargin + marginLayoutParams.rightMargin, marginLayoutParams.width);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final v P(StepOSAlertDialogLayout stepOSAlertDialogLayout, Context context) {
        Drawable drawableE = androidx.core.content.a.e(context, f.f18398d);
        stepOSAlertDialogLayout.f16133q = drawableE != null ? drawableE.mutate() : null;
        stepOSAlertDialogLayout.S();
        return v.f5542a;
    }

    private final void R() {
        if (isHardwareAccelerated()) {
            b bVar = new b(new WeakReference(this));
            this.f16138v = bVar;
            ViewTreeObserver viewTreeObserver = getViewTreeObserver();
            viewTreeObserver.registerFrameCommitCallback(bVar);
            this.f16139w = viewTreeObserver;
        }
    }

    private final void S() {
        N();
        W();
        this.f16132p.m();
        this.f16134r = null;
        if (this.f16142z) {
            U();
        }
        invalidate();
    }

    private final void T() {
        if (!isAttachedToWindow() || !this.f16142z || getWidth() <= 0 || getHeight() <= 0) {
            return;
        }
        m<Integer, Integer> mVarA = r.a(Integer.valueOf(getWidth()), Integer.valueOf(getHeight()));
        if (k.b(mVarA, this.f16134r)) {
            return;
        }
        if (!this.f16132p.k()) {
            this.f16132p.d(1, getResources().getDimension(C0847e.f18364j), X());
            if (this.f16132p.l()) {
                R();
            }
        }
        this.f16134r = mVarA;
        invalidate();
    }

    private final void U() {
        if (this.f16142z && isAttachedToWindow() && this.f16135s == null) {
            this.f16135s = A.a(this, new Runnable() { // from class: p3.k
                @Override // java.lang.Runnable
                public final void run() {
                    StepOSAlertDialogLayout.V(this.f19515a);
                }
            });
            invalidate();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void V(StepOSAlertDialogLayout stepOSAlertDialogLayout) {
        stepOSAlertDialogLayout.f16135s = null;
        stepOSAlertDialogLayout.T();
    }

    private final void W() {
        ViewTreeObserver viewTreeObserver;
        Runnable runnable = this.f16138v;
        if (runnable != null && (viewTreeObserver = this.f16139w) != null) {
            if (!viewTreeObserver.isAlive()) {
                viewTreeObserver = null;
            }
            if (viewTreeObserver != null) {
                viewTreeObserver.unregisterFrameCommitCallback(runnable);
            }
        }
        this.f16138v = null;
        this.f16139w = null;
        removeCallbacks(this.f16140x);
        ValueAnimator valueAnimator = this.f16137u;
        if (valueAnimator != null) {
            valueAnimator.removeAllUpdateListeners();
            valueAnimator.removeAllListeners();
            valueAnimator.cancel();
        }
        this.f16137u = null;
        this.f16136t = 255;
    }

    private final o X() {
        o oVar = this.f16128A;
        return oVar == null ? getResources().getBoolean(C0845c.f18289a) ? o.f3626h.j() : o.f3626h.h() : oVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Y(final StepOSAlertDialogLayout stepOSAlertDialogLayout) {
        if (stepOSAlertDialogLayout.isAttachedToWindow() && stepOSAlertDialogLayout.f16142z && stepOSAlertDialogLayout.f16132p.l()) {
            ValueAnimator valueAnimatorOfInt = ValueAnimator.ofInt(255, 0);
            valueAnimatorOfInt.setDuration(stepOSAlertDialogLayout.getResources().getInteger(R.integer.config_shortAnimTime));
            valueAnimatorOfInt.setInterpolator(new LinearInterpolator());
            valueAnimatorOfInt.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: p3.n
                @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                    StepOSAlertDialogLayout.Z(this.f19519a, valueAnimator);
                }
            });
            valueAnimatorOfInt.addListener(stepOSAlertDialogLayout.new c());
            stepOSAlertDialogLayout.f16137u = valueAnimatorOfInt;
            valueAnimatorOfInt.start();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Z(StepOSAlertDialogLayout stepOSAlertDialogLayout, ValueAnimator valueAnimator) {
        k.g(valueAnimator, "it");
        Object animatedValue = valueAnimator.getAnimatedValue();
        k.e(animatedValue, "null cannot be cast to non-null type kotlin.Int");
        stepOSAlertDialogLayout.f16136t = ((Integer) animatedValue).intValue();
        stepOSAlertDialogLayout.invalidate();
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r4v10 */
    /* JADX WARN: Type inference failed for: r4v35, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r4v36, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r4v7 */
    /* JADX WARN: Type inference failed for: r4v8 */
    /* JADX WARN: Type inference failed for: r4v9 */
    private final boolean a0(int i5, int i6) {
        Object obj;
        View view;
        View view2;
        Integer num;
        h hVarJ = l.j(0, getChildCount());
        ArrayList arrayList = new ArrayList(C0403n.r(hVarJ, 10));
        Iterator<Integer> it = hVarJ.iterator();
        while (it.hasNext()) {
            arrayList.add(getChildAt(((C) it).nextInt()));
        }
        ArrayList arrayList2 = new ArrayList();
        int size = arrayList.size();
        int i7 = 0;
        while (i7 < size) {
            Object obj2 = arrayList.get(i7);
            i7++;
            if (((View) obj2).getVisibility() != 8) {
                arrayList2.add(obj2);
            }
        }
        int size2 = arrayList2.size();
        int i8 = 0;
        while (true) {
            if (i8 >= size2) {
                obj = null;
                break;
            }
            obj = arrayList2.get(i8);
            i8++;
            if (((View) obj).getId() == l3.h.f18450y) {
                break;
            }
        }
        View view3 = (View) obj;
        int size3 = arrayList2.size();
        int i9 = 0;
        while (true) {
            if (i9 >= size3) {
                view = 0;
                break;
            }
            view = arrayList2.get(i9);
            i9++;
            if (((View) view).getId() == l3.h.f18428c) {
                break;
            }
        }
        View view4 = view;
        int size4 = arrayList2.size();
        int i10 = 0;
        while (true) {
            if (i10 >= size4) {
                view2 = 0;
                break;
            }
            view2 = arrayList2.get(i10);
            i10++;
            if (((View) view2).getId() == l3.h.f18438m) {
                break;
            }
        }
        View view5 = view2;
        if (!arrayList2.isEmpty()) {
            int size5 = arrayList2.size();
            int i11 = 0;
            while (i11 < size5) {
                Object obj3 = arrayList2.get(i11);
                i11++;
                View view6 = (View) obj3;
                if (view6 != view3 && view6 != view4 && view6 != view5) {
                    return false;
                }
            }
        }
        int size6 = arrayList2.size();
        int i12 = 0;
        int i13 = 0;
        while (i12 < size6) {
            Object obj4 = arrayList2.get(i12);
            i12++;
            ViewGroup.LayoutParams layoutParams = ((View) obj4).getLayoutParams();
            k.e(layoutParams, "null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
            i13 += marginLayoutParams.topMargin + marginLayoutParams.bottomMargin;
        }
        int iB = l.b(((View.MeasureSpec.getSize(i6) - getPaddingTop()) - getPaddingBottom()) - i13, 0);
        b0(this, i5, view3, 0, 0);
        b0(this, i5, view4, 0, 0);
        int measuredHeight = view3 != null ? view3.getMeasuredHeight() : 0;
        int measuredHeight2 = view4 != null ? view4.getMeasuredHeight() : 0;
        Resources resources = getResources();
        int i14 = C0847e.f18356f;
        int iMin = Math.min(iB / 4, resources.getDimensionPixelSize(i14));
        int i15 = measuredHeight2;
        c0(this, i5, view5, iMin, 0, 16, null);
        int iMin2 = Math.min(view5 != null ? view5.getMeasuredHeight() : 0, iMin);
        int iE = l.e(i15, iB);
        if (measuredHeight + i15 + iMin2 > iB) {
            iE = Math.min(i15, l.e(Math.max(iB / 3, getResources().getDimensionPixelSize(i14)), iB));
        }
        c0(this, i5, view4, iE, 0, 16, null);
        c0(this, i5, view3, l.b((iB - (view4 != null ? view4.getMeasuredHeight() : 0)) - iMin2, 0), 0, 16, null);
        c0(this, i5, view5, (iB - (view3 != null ? view3.getMeasuredHeight() : 0)) - (view4 != null ? view4.getMeasuredHeight() : 0), 0, 16, null);
        int paddingTop = getPaddingTop() + getPaddingBottom() + i13;
        int size7 = arrayList2.size();
        int measuredHeight3 = 0;
        int i16 = 0;
        while (i16 < size7) {
            Object obj5 = arrayList2.get(i16);
            i16++;
            measuredHeight3 += ((View) obj5).getMeasuredHeight();
        }
        int i17 = paddingTop + measuredHeight3;
        int paddingLeft = getPaddingLeft() + getPaddingRight();
        Iterator it2 = arrayList2.iterator();
        if (it2.hasNext()) {
            View view7 = (View) it2.next();
            ViewGroup.LayoutParams layoutParams2 = view7.getLayoutParams();
            k.e(layoutParams2, "null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
            ViewGroup.MarginLayoutParams marginLayoutParams2 = (ViewGroup.MarginLayoutParams) layoutParams2;
            Integer numValueOf = Integer.valueOf(view7.getMeasuredWidth() + marginLayoutParams2.leftMargin + marginLayoutParams2.rightMargin);
            loop9: while (true) {
                num = numValueOf;
                while (it2.hasNext()) {
                    View view8 = (View) it2.next();
                    ViewGroup.LayoutParams layoutParams3 = view8.getLayoutParams();
                    k.e(layoutParams3, "null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
                    ViewGroup.MarginLayoutParams marginLayoutParams3 = (ViewGroup.MarginLayoutParams) layoutParams3;
                    numValueOf = Integer.valueOf(view8.getMeasuredWidth() + marginLayoutParams3.leftMargin + marginLayoutParams3.rightMargin);
                    if (num.compareTo(numValueOf) < 0) {
                        break;
                    }
                }
            }
        } else {
            num = null;
        }
        int iIntValue = paddingLeft + (num != null ? num.intValue() : 0);
        int size8 = arrayList2.size();
        int iCombineMeasuredStates = 0;
        int i18 = 0;
        while (i18 < size8) {
            Object obj6 = arrayList2.get(i18);
            i18++;
            iCombineMeasuredStates = View.combineMeasuredStates(iCombineMeasuredStates, ((View) obj6).getMeasuredState());
        }
        setMeasuredDimension(View.resolveSizeAndState(iIntValue, i5, iCombineMeasuredStates), View.resolveSizeAndState(i17, i6, 0));
        if (View.MeasureSpec.getMode(i5) == 1073741824) {
            return true;
        }
        l(getChildCount(), i6);
        return true;
    }

    private static final void b0(StepOSAlertDialogLayout stepOSAlertDialogLayout, int i5, View view, int i6, int i7) {
        if (view != null) {
            view.measure(stepOSAlertDialogLayout.O(view, i5), View.MeasureSpec.makeMeasureSpec(l.b(i6, 0), i7));
        }
    }

    static /* synthetic */ void c0(StepOSAlertDialogLayout stepOSAlertDialogLayout, int i5, View view, int i6, int i7, int i8, Object obj) {
        if ((i8 & 16) != 0) {
            i7 = Integer.MIN_VALUE;
        }
        b0(stepOSAlertDialogLayout, i5, view, i6, i7);
    }

    /* JADX WARN: Removed duplicated region for block: B:9:0x003b  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private final void l(int r10, int r11) {
        /*
            r9 = this;
            int r0 = r9.getMeasuredWidth()
            r1 = 1073741824(0x40000000, float:2.0)
            int r4 = android.view.View.MeasureSpec.makeMeasureSpec(r0, r1)
            r0 = 0
        Lb:
            if (r0 >= r10) goto L42
            android.view.View r3 = r9.getChildAt(r0)
            int r1 = r3.getVisibility()
            r2 = 8
            if (r1 == r2) goto L3b
            android.view.ViewGroup$LayoutParams r1 = r3.getLayoutParams()
            java.lang.String r2 = "null cannot be cast to non-null type androidx.appcompat.widget.LinearLayoutCompat.LayoutParams"
            j4.k.e(r1, r2)
            androidx.appcompat.widget.LinearLayoutCompat$a r1 = (androidx.appcompat.widget.LinearLayoutCompat.a) r1
            int r2 = r1.width
            r5 = -1
            if (r2 != r5) goto L3b
            int r8 = r1.height
            int r2 = r3.getMeasuredHeight()
            r1.height = r2
            r5 = 0
            r7 = 0
            r2 = r9
            r6 = r11
            r2.measureChildWithMargins(r3, r4, r5, r6, r7)
            r1.height = r8
            goto L3d
        L3b:
            r2 = r9
            r6 = r11
        L3d:
            int r0 = r0 + 1
            r9 = r2
            r11 = r6
            goto Lb
        L42:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.widget.dialog.StepOSAlertDialogLayout.l(int, int):void");
    }

    public final boolean Q() {
        return this.f16142z;
    }

    public final int getBottomWindowMargin$StepOSWidget_release() {
        return this.f16130C;
    }

    public final boolean getFitInputMethod$StepOSWidget_release() {
        return this.f16131D;
    }

    public final o getGlassEffect() {
        return this.f16128A;
    }

    public final int getMaxHeight() {
        return this.f16129B;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        W();
        U();
    }

    @Override // android.view.View
    protected void onConfigurationChanged(Configuration configuration) {
        k.g(configuration, "newConfig");
        super.onConfigurationChanged(configuration);
        this.f16141y.c(configuration);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        N();
        this.f16141y.b();
        W();
        this.f16132p.i();
        this.f16132p.m();
        this.f16134r = null;
        super.onDetachedFromWindow();
    }

    @Override // androidx.appcompat.widget.LinearLayoutCompat, android.view.View
    protected void onDraw(Canvas canvas) {
        k.g(canvas, "canvas");
        int i5 = this.f16132p.l() ? this.f16136t : 255;
        if (i5 > 0) {
            Drawable drawable = this.f16133q;
            if (drawable != null) {
                drawable.setAlpha(i5);
            }
            Drawable drawable2 = this.f16133q;
            if (drawable2 != null) {
                drawable2.setBounds(0, 0, getWidth(), getHeight());
            }
            Drawable drawable3 = this.f16133q;
            if (drawable3 != null) {
                drawable3.draw(canvas);
            }
        }
        super.onDraw(canvas);
    }

    @Override // androidx.appcompat.widget.LinearLayoutCompat, android.view.View
    protected void onMeasure(int i5, int i6) {
        int iMin = this.f16129B;
        if (this.f16130C > 0) {
            WindowMetrics currentWindowMetrics = ((WindowManager) getContext().getSystemService(WindowManager.class)).getCurrentWindowMetrics();
            k.f(currentWindowMetrics, "getCurrentWindowMetrics(...)");
            WindowInsets windowInsets = currentWindowMetrics.getWindowInsets();
            k.f(windowInsets, "getWindowInsets(...)");
            iMin = Math.min(iMin, s.f19586a.a(currentWindowMetrics.getBounds().height(), windowInsets.getInsets(WindowInsets.Type.statusBars() | WindowInsets.Type.captionBar() | WindowInsets.Type.displayCutout()).top, this.f16131D ? windowInsets.getInsets(WindowInsets.Type.ime()).bottom : 0, this.f16130C));
        }
        if (View.MeasureSpec.getMode(i6) != 0) {
            iMin = Math.min(iMin, View.MeasureSpec.getSize(i6));
        }
        int iMakeMeasureSpec = View.MeasureSpec.makeMeasureSpec(iMin, Integer.MIN_VALUE);
        if (a0(i5, iMakeMeasureSpec)) {
            return;
        }
        super.onMeasure(i5, iMakeMeasureSpec);
    }

    @Override // android.view.View
    protected void onSizeChanged(int i5, int i6, int i7, int i8) {
        super.onSizeChanged(i5, i6, i7, i8);
        U();
    }

    public final void setBottomWindowMargin$StepOSWidget_release(int i5) {
        this.f16130C = i5;
    }

    public final void setFitInputMethod$StepOSWidget_release(boolean z5) {
        this.f16131D = z5;
    }

    public final void setGlassEffect(o oVar) {
        if (k.b(this.f16128A, oVar)) {
            return;
        }
        this.f16128A = oVar;
        S();
    }

    public final void setGlassEnabled(boolean z5) {
        if (this.f16142z == z5) {
            return;
        }
        this.f16142z = z5;
        S();
    }

    public final void setMaxHeight(int i5) {
        if (i5 <= 0) {
            throw new IllegalArgumentException(("maxHeight must be > 0 but was " + i5).toString());
        }
        if (this.f16129B == i5) {
            return;
        }
        this.f16129B = i5;
        requestLayout();
    }

    public /* synthetic */ StepOSAlertDialogLayout(Context context, AttributeSet attributeSet, int i5, int i6, g gVar) {
        this(context, (i6 & 2) != 0 ? null : attributeSet, (i6 & 4) != 0 ? 0 : i5);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public StepOSAlertDialogLayout(final Context context, AttributeSet attributeSet, int i5) {
        super(context, attributeSet, i5);
        k.g(context, "context");
        this.f16132p = new C1009e(this);
        Drawable drawableE = androidx.core.content.a.e(context, f.f18398d);
        this.f16133q = drawableE != null ? drawableE.mutate() : null;
        this.f16136t = 255;
        this.f16140x = new Runnable() { // from class: p3.l
            @Override // java.lang.Runnable
            public final void run() {
                StepOSAlertDialogLayout.Y(this.f19516a);
            }
        };
        this.f16141y = new C1012h(this, new InterfaceC0761a() { // from class: p3.m
            @Override // i4.InterfaceC0761a
            public final Object invoke() {
                return StepOSAlertDialogLayout.P(this.f19517a, context);
            }
        });
        this.f16142z = true;
        setWillNotDraw(false);
        setClipToOutline(true);
        setOutlineProvider(new a());
        this.f16129B = Integer.MAX_VALUE;
    }
}
