package com.stepos.widget.dialog;

import A6.h;
import A6.i;
import A6.l;
import B7.a;
import D6.f;
import D7.w;
import Y7.e;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.Configuration;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.view.WindowInsets;
import android.view.WindowManager;
import android.view.WindowMetrics;
import android.widget.LinearLayout;
import androidx.annotation.Px;
import androidx.annotation.RestrictTo;
import androidx.appcompat.widget.LinearLayoutCompat;
import androidx.constraintlayout.core.widgets.analyzer.BasicMeasure;
import androidx.core.content.ContextCompat;
import androidx.core.view.OneShotPreDrawListener;
import com.stepos.ability.R;
import com.stepos.motionkit.fx.material.GlassEffect;
import g1.AbstractC1451a;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.jvm.internal.k;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\b\n\u0002\b\u0010\b\u0007\u0018\u00002\u00020\u0001R*\u0010\u0006\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00028\u0006@FX\u0086\u000e¢\u0006\u0012\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR.\u0010\u0011\u001a\u0004\u0018\u00010\n2\b\u0010\u0003\u001a\u0004\u0018\u00010\n8\u0006@FX\u0086\u000e¢\u0006\u0012\n\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R,\u0010\u0019\u001a\u00020\u00122\b\b\u0001\u0010\u0003\u001a\u00020\u00128G@FX\u0086\u000e¢\u0006\u0012\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018R\"\u0010\u001d\u001a\u00020\u00128\u0000@\u0000X\u0080\u000e¢\u0006\u0012\n\u0004\b\u001a\u0010\u0014\u001a\u0004\b\u001b\u0010\u0016\"\u0004\b\u001c\u0010\u0018R\"\u0010!\u001a\u00020\u00028\u0000@\u0000X\u0080\u000e¢\u0006\u0012\n\u0004\b\u001e\u0010\u0005\u001a\u0004\b\u001f\u0010\u0007\"\u0004\b \u0010\t¨\u0006\""}, d2 = {"Lcom/stepos/widget/dialog/StepOSAlertDialogLayout;", "Landroidx/appcompat/widget/LinearLayoutCompat;", "", "value", "k", "Z", "isGlassEnabled", "()Z", "setGlassEnabled", "(Z)V", "Lcom/stepos/motionkit/fx/material/GlassEffect;", "l", "Lcom/stepos/motionkit/fx/material/GlassEffect;", "getGlassEffect", "()Lcom/stepos/motionkit/fx/material/GlassEffect;", "setGlassEffect", "(Lcom/stepos/motionkit/fx/material/GlassEffect;)V", "glassEffect", "", "m", "I", "getMaxHeight", "()I", "setMaxHeight", "(I)V", "maxHeight", "n", "getBottomWindowMargin$StepOSWidget_release", "setBottomWindowMargin$StepOSWidget_release", "bottomWindowMargin", "o", "getFitInputMethod$StepOSWidget_release", "setFitInputMethod$StepOSWidget_release", "fitInputMethod", "StepOSWidget_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
@RestrictTo({RestrictTo.Scope.LIBRARY})
/* loaded from: classes3.dex */
public final class StepOSAlertDialogLayout extends LinearLayoutCompat {
    public static final /* synthetic */ int p = 0;

    /* renamed from: a, reason: collision with root package name */
    public final f f4103a;
    public Drawable b;
    public Pair c;
    public OneShotPreDrawListener d;
    public int e;
    public ValueAnimator f;
    public l g;
    public ViewTreeObserver h;
    public final h i;

    /* renamed from: j, reason: collision with root package name */
    public final D6.h f4104j;

    /* renamed from: k, reason: from kotlin metadata */
    public boolean isGlassEnabled;

    /* renamed from: l, reason: from kotlin metadata */
    public GlassEffect glassEffect;

    /* renamed from: m, reason: from kotlin metadata */
    public int maxHeight;

    /* renamed from: n, reason: from kotlin metadata */
    public int bottomWindowMargin;

    /* renamed from: o, reason: from kotlin metadata */
    public boolean fitInputMethod;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public StepOSAlertDialogLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet, 0);
        k.f(context, "context");
        this.f4103a = new f(this);
        Drawable drawable = ContextCompat.getDrawable(context, R.drawable.stepos_bg_dialog);
        this.b = drawable != null ? drawable.mutate() : null;
        this.e = 255;
        this.i = new h(this, 1);
        this.f4104j = new D6.h(this, new i(0, this, context));
        this.isGlassEnabled = true;
        setWillNotDraw(false);
        setClipToOutline(true);
        setOutlineProvider(new A6.k(this, 0));
        this.maxHeight = Integer.MAX_VALUE;
    }

    public static final void f(StepOSAlertDialogLayout stepOSAlertDialogLayout, int i, View view, int i6, int i10) {
        if (view != null) {
            ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
            k.d(layoutParams, "null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
            int childMeasureSpec = ViewGroup.getChildMeasureSpec(i, stepOSAlertDialogLayout.getPaddingRight() + stepOSAlertDialogLayout.getPaddingLeft() + marginLayoutParams.leftMargin + marginLayoutParams.rightMargin, marginLayoutParams.width);
            if (i6 < 0) {
                i6 = 0;
            }
            view.measure(childMeasureSpec, View.MeasureSpec.makeMeasureSpec(i6, i10));
        }
    }

    public final void c() {
        OneShotPreDrawListener oneShotPreDrawListener = this.d;
        if (oneShotPreDrawListener != null) {
            oneShotPreDrawListener.removeListener();
        }
        this.d = null;
        e();
        this.f4103a.d();
        this.c = null;
        if (this.isGlassEnabled) {
            d();
        }
        invalidate();
    }

    public final void d() {
        if (this.isGlassEnabled && isAttachedToWindow() && this.d == null) {
            this.d = OneShotPreDrawListener.add(this, new h(this, 0));
            invalidate();
        }
    }

    public final void e() {
        ViewTreeObserver viewTreeObserver;
        l lVar = this.g;
        if (lVar != null && (viewTreeObserver = this.h) != null) {
            if (!viewTreeObserver.isAlive()) {
                viewTreeObserver = null;
            }
            if (viewTreeObserver != null) {
                viewTreeObserver.unregisterFrameCommitCallback(lVar);
            }
        }
        this.g = null;
        this.h = null;
        removeCallbacks(this.i);
        ValueAnimator valueAnimator = this.f;
        if (valueAnimator != null) {
            valueAnimator.removeAllUpdateListeners();
            valueAnimator.removeAllListeners();
            valueAnimator.cancel();
        }
        this.f = null;
        this.e = 255;
    }

    /* renamed from: getBottomWindowMargin$StepOSWidget_release, reason: from getter */
    public final int getBottomWindowMargin() {
        return this.bottomWindowMargin;
    }

    /* renamed from: getFitInputMethod$StepOSWidget_release, reason: from getter */
    public final boolean getFitInputMethod() {
        return this.fitInputMethod;
    }

    public final GlassEffect getGlassEffect() {
        return this.glassEffect;
    }

    @Px
    public final int getMaxHeight() {
        return this.maxHeight;
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onAttachedToWindow() {
        super.onAttachedToWindow();
        e();
        d();
    }

    @Override // android.view.View
    public final void onConfigurationChanged(Configuration newConfig) {
        k.f(newConfig, "newConfig");
        super.onConfigurationChanged(newConfig);
        this.f4104j.a(newConfig);
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onDetachedFromWindow() {
        OneShotPreDrawListener oneShotPreDrawListener = this.d;
        if (oneShotPreDrawListener != null) {
            oneShotPreDrawListener.removeListener();
        }
        this.d = null;
        D6.h hVar = this.f4104j;
        hVar.f384a.removeCallbacks(hVar.f);
        hVar.e = false;
        e();
        f fVar = this.f4103a;
        fVar.f383a.removeCallbacks(fVar.c);
        fVar.d();
        this.c = null;
        super.onDetachedFromWindow();
    }

    @Override // androidx.appcompat.widget.LinearLayoutCompat, android.view.View
    public final void onDraw(Canvas canvas) {
        k.f(canvas, "canvas");
        int i = this.f4103a.d ? this.e : 255;
        if (i > 0) {
            Drawable drawable = this.b;
            if (drawable != null) {
                drawable.setAlpha(i);
            }
            Drawable drawable2 = this.b;
            if (drawable2 != null) {
                drawable2.setBounds(0, 0, getWidth(), getHeight());
            }
            Drawable drawable3 = this.b;
            if (drawable3 != null) {
                drawable3.draw(canvas);
            }
        }
        super.onDraw(canvas);
    }

    @Override // androidx.appcompat.widget.LinearLayoutCompat, android.view.View
    public final void onMeasure(int i, int i6) {
        Object next;
        Object next2;
        Object next3;
        Integer numValueOf;
        StepOSAlertDialogLayout stepOSAlertDialogLayout = this;
        int iMin = stepOSAlertDialogLayout.maxHeight;
        if (stepOSAlertDialogLayout.bottomWindowMargin > 0) {
            WindowMetrics currentWindowMetrics = ((WindowManager) stepOSAlertDialogLayout.getContext().getSystemService(WindowManager.class)).getCurrentWindowMetrics();
            k.e(currentWindowMetrics, "getCurrentWindowMetrics(...)");
            WindowInsets windowInsets = currentWindowMetrics.getWindowInsets();
            k.e(windowInsets, "getWindowInsets(...)");
            int iHeight = ((currentWindowMetrics.getBounds().height() - windowInsets.getInsets((WindowInsets.Type.statusBars() | WindowInsets.Type.captionBar()) | WindowInsets.Type.displayCutout()).top) - (stepOSAlertDialogLayout.fitInputMethod ? windowInsets.getInsets(WindowInsets.Type.ime()).bottom : 0)) - stepOSAlertDialogLayout.bottomWindowMargin;
            if (iHeight < 0) {
                iHeight = 0;
            }
            iMin = Math.min(iMin, iHeight);
        }
        if (View.MeasureSpec.getMode(i6) != 0) {
            iMin = Math.min(iMin, View.MeasureSpec.getSize(i6));
        }
        int iMakeMeasureSpec = View.MeasureSpec.makeMeasureSpec(iMin, Integer.MIN_VALUE);
        Y7.f fVarX = AbstractC1451a.X(0, stepOSAlertDialogLayout.getChildCount());
        ArrayList arrayList = new ArrayList(w.c0(fVarX, 10));
        e it = fVarX.iterator();
        while (it.c) {
            arrayList.add(stepOSAlertDialogLayout.getChildAt(it.nextInt()));
        }
        ArrayList arrayList2 = new ArrayList();
        Iterator it2 = arrayList.iterator();
        while (it2.hasNext()) {
            Object next4 = it2.next();
            if (((View) next4).getVisibility() != 8) {
                arrayList2.add(next4);
            }
        }
        Iterator it3 = arrayList2.iterator();
        while (true) {
            if (!it3.hasNext()) {
                next = null;
                break;
            } else {
                next = it3.next();
                if (((View) next).getId() == R.id.stepos_dialog_top_panel) {
                    break;
                }
            }
        }
        View view = (View) next;
        Iterator it4 = arrayList2.iterator();
        while (true) {
            if (!it4.hasNext()) {
                next2 = null;
                break;
            } else {
                next2 = it4.next();
                if (((View) next2).getId() == R.id.stepos_dialog_button_panel) {
                    break;
                }
            }
        }
        View view2 = (View) next2;
        Iterator it5 = arrayList2.iterator();
        while (true) {
            if (!it5.hasNext()) {
                next3 = null;
                break;
            } else {
                next3 = it5.next();
                if (((View) next3).getId() == R.id.stepos_dialog_middle_panel) {
                    break;
                }
            }
        }
        View view3 = (View) next3;
        if (!arrayList2.isEmpty()) {
            Iterator it6 = arrayList2.iterator();
            while (it6.hasNext()) {
                View view4 = (View) it6.next();
                if (view4 != view && view4 != view2 && view4 != view3) {
                    super.onMeasure(i, iMakeMeasureSpec);
                    return;
                }
            }
        }
        Iterator it7 = arrayList2.iterator();
        int i10 = 0;
        while (it7.hasNext()) {
            ViewGroup.LayoutParams layoutParams = ((View) it7.next()).getLayoutParams();
            k.d(layoutParams, "null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
            i10 += marginLayoutParams.topMargin + marginLayoutParams.bottomMargin;
        }
        int size = ((View.MeasureSpec.getSize(iMakeMeasureSpec) - stepOSAlertDialogLayout.getPaddingTop()) - stepOSAlertDialogLayout.getPaddingBottom()) - i10;
        if (size < 0) {
            size = 0;
        }
        f(stepOSAlertDialogLayout, i, view, 0, 0);
        f(stepOSAlertDialogLayout, i, view2, 0, 0);
        int measuredHeight = view != null ? view.getMeasuredHeight() : 0;
        int measuredHeight2 = view2 != null ? view2.getMeasuredHeight() : 0;
        int iMin2 = Math.min(size / 4, stepOSAlertDialogLayout.getResources().getDimensionPixelSize(R.dimen.stepos_dialog_button_height));
        f(stepOSAlertDialogLayout, i, view3, iMin2, Integer.MIN_VALUE);
        int iMin3 = Math.min(view3 != null ? view3.getMeasuredHeight() : 0, iMin2);
        int iMin4 = measuredHeight2 > size ? size : measuredHeight2;
        if (measuredHeight + measuredHeight2 + iMin3 > size) {
            int iMax = Math.max(size / 3, stepOSAlertDialogLayout.getResources().getDimensionPixelSize(R.dimen.stepos_dialog_button_height));
            if (iMax > size) {
                iMax = size;
            }
            iMin4 = Math.min(measuredHeight2, iMax);
        }
        f(stepOSAlertDialogLayout, i, view2, iMin4, Integer.MIN_VALUE);
        int measuredHeight3 = (size - (view2 != null ? view2.getMeasuredHeight() : 0)) - iMin3;
        if (measuredHeight3 < 0) {
            measuredHeight3 = 0;
        }
        f(stepOSAlertDialogLayout, i, view, measuredHeight3, Integer.MIN_VALUE);
        f(stepOSAlertDialogLayout, i, view3, (size - (view != null ? view.getMeasuredHeight() : 0)) - (view2 != null ? view2.getMeasuredHeight() : 0), Integer.MIN_VALUE);
        int paddingBottom = stepOSAlertDialogLayout.getPaddingBottom() + stepOSAlertDialogLayout.getPaddingTop() + i10;
        Iterator it8 = arrayList2.iterator();
        int measuredHeight4 = 0;
        while (it8.hasNext()) {
            measuredHeight4 += ((View) it8.next()).getMeasuredHeight();
        }
        int i11 = paddingBottom + measuredHeight4;
        int paddingRight = stepOSAlertDialogLayout.getPaddingRight() + stepOSAlertDialogLayout.getPaddingLeft();
        Iterator it9 = arrayList2.iterator();
        if (it9.hasNext()) {
            View view5 = (View) it9.next();
            ViewGroup.LayoutParams layoutParams2 = view5.getLayoutParams();
            k.d(layoutParams2, "null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
            ViewGroup.MarginLayoutParams marginLayoutParams2 = (ViewGroup.MarginLayoutParams) layoutParams2;
            numValueOf = Integer.valueOf(view5.getMeasuredWidth() + marginLayoutParams2.leftMargin + marginLayoutParams2.rightMargin);
            while (it9.hasNext()) {
                View view6 = (View) it9.next();
                ViewGroup.LayoutParams layoutParams3 = view6.getLayoutParams();
                k.d(layoutParams3, "null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
                ViewGroup.MarginLayoutParams marginLayoutParams3 = (ViewGroup.MarginLayoutParams) layoutParams3;
                Integer numValueOf2 = Integer.valueOf(view6.getMeasuredWidth() + marginLayoutParams3.leftMargin + marginLayoutParams3.rightMargin);
                if (numValueOf.compareTo(numValueOf2) < 0) {
                    numValueOf = numValueOf2;
                }
            }
        } else {
            numValueOf = null;
        }
        int iIntValue = paddingRight + (numValueOf != null ? numValueOf.intValue() : 0);
        Iterator it10 = arrayList2.iterator();
        int iCombineMeasuredStates = 0;
        while (it10.hasNext()) {
            iCombineMeasuredStates = View.combineMeasuredStates(iCombineMeasuredStates, ((View) it10.next()).getMeasuredState());
        }
        stepOSAlertDialogLayout.setMeasuredDimension(View.resolveSizeAndState(iIntValue, i, iCombineMeasuredStates), View.resolveSizeAndState(i11, iMakeMeasureSpec, 0));
        if (View.MeasureSpec.getMode(i) != 1073741824) {
            int childCount = stepOSAlertDialogLayout.getChildCount();
            int iMakeMeasureSpec2 = View.MeasureSpec.makeMeasureSpec(stepOSAlertDialogLayout.getMeasuredWidth(), BasicMeasure.EXACTLY);
            int i12 = 0;
            while (i12 < childCount) {
                int i13 = iMakeMeasureSpec;
                int i14 = iMakeMeasureSpec2;
                View childAt = stepOSAlertDialogLayout.getChildAt(i12);
                if (childAt.getVisibility() != 8) {
                    ViewGroup.LayoutParams layoutParams4 = childAt.getLayoutParams();
                    k.d(layoutParams4, "null cannot be cast to non-null type androidx.appcompat.widget.LinearLayoutCompat.LayoutParams");
                    LinearLayoutCompat.LayoutParams layoutParams5 = (LinearLayoutCompat.LayoutParams) layoutParams4;
                    if (((LinearLayout.LayoutParams) layoutParams5).width == -1) {
                        int i15 = ((LinearLayout.LayoutParams) layoutParams5).height;
                        ((LinearLayout.LayoutParams) layoutParams5).height = childAt.getMeasuredHeight();
                        stepOSAlertDialogLayout.measureChildWithMargins(childAt, i14, 0, i13, 0);
                        ((LinearLayout.LayoutParams) layoutParams5).height = i15;
                    }
                }
                i12++;
                stepOSAlertDialogLayout = this;
                iMakeMeasureSpec2 = i14;
                iMakeMeasureSpec = i13;
            }
        }
    }

    @Override // android.view.View
    public final void onSizeChanged(int i, int i6, int i10, int i11) {
        super.onSizeChanged(i, i6, i10, i11);
        d();
    }

    public final void setBottomWindowMargin$StepOSWidget_release(int i) {
        this.bottomWindowMargin = i;
    }

    public final void setFitInputMethod$StepOSWidget_release(boolean z10) {
        this.fitInputMethod = z10;
    }

    public final void setGlassEffect(GlassEffect glassEffect) {
        if (k.b(this.glassEffect, glassEffect)) {
            return;
        }
        this.glassEffect = glassEffect;
        c();
    }

    public final void setGlassEnabled(boolean z10) {
        if (this.isGlassEnabled == z10) {
            return;
        }
        this.isGlassEnabled = z10;
        c();
    }

    public final void setMaxHeight(@Px int i) {
        if (i <= 0) {
            throw new IllegalArgumentException(a.h(i, "maxHeight must be > 0 but was ").toString());
        }
        if (this.maxHeight == i) {
            return;
        }
        this.maxHeight = i;
        requestLayout();
    }
}
