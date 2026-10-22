package com.google.android.material.timepicker;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.RadialGradient;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Shader;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityNodeInfo;
import android.widget.TextView;
import com.google.android.material.timepicker.ClockHandView;
import com.stepos.aiengine.R;
import java.util.Arrays;
import v0.e0;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
class ClockFaceView extends i implements ClockHandView.a {
    public final SparseArray<TextView> A;
    public final c B;
    public final int[] C;
    public final float[] D;
    public final int E;
    public final int F;
    public final int G;
    public final int H;
    public String[] I;
    public float J;
    public final ColorStateList K;

    /* renamed from: w, reason: collision with root package name */
    public final ClockHandView f5348w;

    /* renamed from: x, reason: collision with root package name */
    public final Rect f5349x;

    /* renamed from: y, reason: collision with root package name */
    public final RectF f5350y;
    public final Rect z;

    public ClockFaceView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet, R.attr.materialClockStyle);
        this.f5349x = new Rect();
        this.f5350y = new RectF();
        this.z = new Rect();
        this.A = new SparseArray<>();
        this.D = new float[]{0.0f, 0.9f, 1.0f};
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, k4.a.f9902f, R.attr.materialClockStyle, R.style.Widget_MaterialComponents_TimePicker_Clock);
        Resources resources = getResources();
        ColorStateList colorStateListA = w4.c.a(context, typedArrayObtainStyledAttributes, 1);
        this.K = colorStateListA;
        LayoutInflater.from(context).inflate(R.layout.material_clockface_view, (ViewGroup) this, true);
        ClockHandView clockHandView = (ClockHandView) findViewById(R.id.material_clock_hand);
        this.f5348w = clockHandView;
        this.E = resources.getDimensionPixelSize(R.dimen.material_clock_hand_padding);
        int colorForState = colorStateListA.getColorForState(new int[]{android.R.attr.state_selected}, colorStateListA.getDefaultColor());
        this.C = new int[]{colorForState, colorForState, colorStateListA.getDefaultColor()};
        clockHandView.f5360m.add(this);
        int defaultColor = androidx.core.content.a.b(R.color.material_timepicker_clockface, context).getDefaultColor();
        ColorStateList colorStateListA2 = w4.c.a(context, typedArrayObtainStyledAttributes, 0);
        setBackgroundColor(colorStateListA2 != null ? colorStateListA2.getDefaultColor() : defaultColor);
        getViewTreeObserver().addOnPreDrawListener(new b(this));
        setFocusable(false);
        typedArrayObtainStyledAttributes.recycle();
        this.B = new c(this);
        String[] strArr = new String[12];
        Arrays.fill(strArr, "");
        o(strArr, 0);
        this.F = resources.getDimensionPixelSize(R.dimen.material_time_picker_minimum_screen_height);
        this.G = resources.getDimensionPixelSize(R.dimen.material_time_picker_minimum_screen_width);
        this.H = resources.getDimensionPixelSize(R.dimen.material_clock_size);
    }

    @Override // com.google.android.material.timepicker.ClockHandView.a
    public final void a(float f8, boolean z) {
        if (Math.abs(this.J - f8) > 0.001f) {
            this.J = f8;
            n();
        }
    }

    @Override // com.google.android.material.timepicker.i
    public final void m() {
        super.m();
        int i10 = 0;
        while (true) {
            SparseArray<TextView> sparseArray = this.A;
            if (i10 >= sparseArray.size()) {
                return;
            }
            sparseArray.get(i10).setVisibility(0);
            i10++;
        }
    }

    public final void n() {
        SparseArray<TextView> sparseArray;
        Rect rect;
        RectF rectF;
        RectF rectF2 = this.f5348w.f5364q;
        float f8 = Float.MAX_VALUE;
        TextView textView = null;
        int i10 = 0;
        while (true) {
            sparseArray = this.A;
            int size = sparseArray.size();
            rect = this.f5349x;
            rectF = this.f5350y;
            if (i10 >= size) {
                break;
            }
            TextView textView2 = sparseArray.get(i10);
            if (textView2 != null) {
                textView2.getHitRect(rect);
                rectF.set(rect);
                rectF.union(rectF2);
                float fHeight = rectF.height() * rectF.width();
                if (fHeight < f8) {
                    textView = textView2;
                    f8 = fHeight;
                }
            }
            i10++;
        }
        for (int i11 = 0; i11 < sparseArray.size(); i11++) {
            TextView textView3 = sparseArray.get(i11);
            if (textView3 != null) {
                textView3.setSelected(textView3 == textView);
                textView3.getHitRect(rect);
                rectF.set(rect);
                textView3.getLineBounds(0, this.z);
                rectF.inset(r8.left, r8.top);
                textView3.getPaint().setShader(!RectF.intersects(rectF2, rectF) ? null : new RadialGradient(rectF2.centerX() - rectF.left, rectF2.centerY() - rectF.top, 0.5f * rectF2.width(), this.C, this.D, Shader.TileMode.CLAMP));
                textView3.invalidate();
            }
        }
    }

    public final void o(String[] strArr, int i10) {
        this.I = strArr;
        LayoutInflater layoutInflaterFrom = LayoutInflater.from(getContext());
        SparseArray<TextView> sparseArray = this.A;
        int size = sparseArray.size();
        boolean z = false;
        for (int i11 = 0; i11 < Math.max(this.I.length, size); i11++) {
            TextView textView = sparseArray.get(i11);
            if (i11 >= this.I.length) {
                removeView(textView);
                sparseArray.remove(i11);
            } else {
                if (textView == null) {
                    textView = (TextView) layoutInflaterFrom.inflate(R.layout.material_clockface_textview, (ViewGroup) this, false);
                    sparseArray.put(i11, textView);
                    addView(textView);
                }
                textView.setText(this.I[i11]);
                textView.setTag(R.id.material_value_index, Integer.valueOf(i11));
                int i12 = (i11 / 12) + 1;
                textView.setTag(R.id.material_clock_level, Integer.valueOf(i12));
                if (i12 > 1) {
                    z = true;
                }
                e0.j(textView, this.B);
                textView.setTextColor(this.K);
                if (i10 != 0) {
                    textView.setContentDescription(getResources().getString(i10, this.I[i11]));
                }
            }
        }
        ClockHandView clockHandView = this.f5348w;
        if (clockHandView.f5359l && !z) {
            clockHandView.f5370x = 1;
        }
        clockHandView.f5359l = z;
        clockHandView.invalidate();
    }

    @Override // android.view.View
    public final void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo accessibilityNodeInfo) {
        super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
        accessibilityNodeInfo.setCollectionInfo(AccessibilityNodeInfo.CollectionInfo.obtain(1, this.I.length, false, 1));
    }

    @Override // androidx.constraintlayout.widget.ConstraintLayout, android.view.ViewGroup, android.view.View
    public final void onLayout(boolean z, int i10, int i11, int i12, int i13) {
        super.onLayout(z, i10, i11, i12, i13);
        n();
    }

    @Override // androidx.constraintlayout.widget.ConstraintLayout, android.view.View
    public final void onMeasure(int i10, int i11) throws Resources.NotFoundException, NumberFormatException {
        DisplayMetrics displayMetrics = getResources().getDisplayMetrics();
        int iMax = (int) (this.H / Math.max(Math.max(this.F / displayMetrics.heightPixels, this.G / displayMetrics.widthPixels), 1.0f));
        int iMakeMeasureSpec = View.MeasureSpec.makeMeasureSpec(iMax, 1073741824);
        setMeasuredDimension(iMax, iMax);
        super.onMeasure(iMakeMeasureSpec, iMakeMeasureSpec);
    }
}
