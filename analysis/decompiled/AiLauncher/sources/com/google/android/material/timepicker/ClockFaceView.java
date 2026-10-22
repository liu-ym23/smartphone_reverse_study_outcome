package com.google.android.material.timepicker;

import C0.c;
import android.R;
import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.RadialGradient;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Shader;
import android.os.Bundle;
import android.os.SystemClock;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.view.accessibility.AccessibilityNodeInfo;
import android.widget.TextView;
import androidx.core.view.C1313a;
import androidx.core.view.N;
import com.google.android.material.R$attr;
import com.google.android.material.R$color;
import com.google.android.material.R$dimen;
import com.google.android.material.R$id;
import com.google.android.material.R$layout;
import com.google.android.material.R$style;
import com.google.android.material.R$styleable;
import com.google.android.material.timepicker.ClockHandView;
import f.C4027a;
import java.util.Arrays;

/* loaded from: classes2.dex */
class ClockFaceView extends d implements ClockHandView.b {

    /* renamed from: d, reason: collision with root package name */
    public final ClockHandView f21710d;

    /* renamed from: e, reason: collision with root package name */
    public final Rect f21711e;

    /* renamed from: f, reason: collision with root package name */
    public final RectF f21712f;

    /* renamed from: g, reason: collision with root package name */
    public final Rect f21713g;

    /* renamed from: h, reason: collision with root package name */
    public final SparseArray<TextView> f21714h;

    /* renamed from: i, reason: collision with root package name */
    public final C1313a f21715i;

    /* renamed from: j, reason: collision with root package name */
    public final int[] f21716j;

    /* renamed from: k, reason: collision with root package name */
    public final float[] f21717k;

    /* renamed from: l, reason: collision with root package name */
    public final int f21718l;

    /* renamed from: m, reason: collision with root package name */
    public final int f21719m;

    /* renamed from: n, reason: collision with root package name */
    public final int f21720n;

    /* renamed from: o, reason: collision with root package name */
    public final int f21721o;

    /* renamed from: p, reason: collision with root package name */
    public String[] f21722p;

    /* renamed from: q, reason: collision with root package name */
    public float f21723q;

    /* renamed from: r, reason: collision with root package name */
    public final ColorStateList f21724r;

    public class a implements ViewTreeObserver.OnPreDrawListener {
        public a() {
        }

        @Override // android.view.ViewTreeObserver.OnPreDrawListener
        public boolean onPreDraw() {
            if (!ClockFaceView.this.isShown()) {
                return true;
            }
            ClockFaceView.this.getViewTreeObserver().removeOnPreDrawListener(this);
            ClockFaceView.this.g(((ClockFaceView.this.getHeight() / 2) - ClockFaceView.this.f21710d.i()) - ClockFaceView.this.f21718l);
            return true;
        }
    }

    public class b extends C1313a {
        public b() {
        }

        @Override // androidx.core.view.C1313a
        public void onInitializeAccessibilityNodeInfo(View view, C0.c cVar) {
            super.onInitializeAccessibilityNodeInfo(view, cVar);
            int iIntValue = ((Integer) view.getTag(R$id.material_value_index)).intValue();
            if (iIntValue > 0) {
                cVar.P0((View) ClockFaceView.this.f21714h.get(iIntValue - 1));
            }
            cVar.p0(c.g.a(0, 1, iIntValue, 1, false, view.isSelected()));
            cVar.n0(true);
            cVar.b(c.a.f1654i);
        }

        @Override // androidx.core.view.C1313a
        public boolean performAccessibilityAction(View view, int i10, Bundle bundle) {
            if (i10 != 16) {
                return super.performAccessibilityAction(view, i10, bundle);
            }
            long jUptimeMillis = SystemClock.uptimeMillis();
            view.getHitRect(ClockFaceView.this.f21711e);
            float fCenterX = ClockFaceView.this.f21711e.centerX();
            float fCenterY = ClockFaceView.this.f21711e.centerY();
            ClockFaceView.this.f21710d.onTouchEvent(MotionEvent.obtain(jUptimeMillis, jUptimeMillis, 0, fCenterX, fCenterY, 0));
            ClockFaceView.this.f21710d.onTouchEvent(MotionEvent.obtain(jUptimeMillis, jUptimeMillis, 1, fCenterX, fCenterY, 0));
            return true;
        }
    }

    public ClockFaceView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, R$attr.materialClockStyle);
    }

    public static float r(float f10, float f11, float f12) {
        return Math.max(Math.max(f10, f11), f12);
    }

    @Override // com.google.android.material.timepicker.ClockHandView.b
    public void b(float f10, boolean z10) {
        if (Math.abs(this.f21723q - f10) > 0.001f) {
            this.f21723q = f10;
            o();
        }
    }

    @Override // com.google.android.material.timepicker.d
    public void g(int i10) {
        if (i10 != f()) {
            super.g(i10);
            this.f21710d.m(f());
        }
    }

    @Override // com.google.android.material.timepicker.d
    public void i() {
        super.i();
        for (int i10 = 0; i10 < this.f21714h.size(); i10++) {
            this.f21714h.get(i10).setVisibility(0);
        }
    }

    public final void o() {
        RectF rectFE = this.f21710d.e();
        TextView textViewQ = q(rectFE);
        for (int i10 = 0; i10 < this.f21714h.size(); i10++) {
            TextView textView = this.f21714h.get(i10);
            if (textView != null) {
                textView.setSelected(textView == textViewQ);
                textView.getPaint().setShader(p(rectFE, textView));
                textView.invalidate();
            }
        }
    }

    @Override // android.view.View
    public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo accessibilityNodeInfo) {
        super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
        C0.c.S0(accessibilityNodeInfo).o0(c.f.b(1, this.f21722p.length, false, 1));
    }

    @Override // androidx.constraintlayout.widget.ConstraintLayout, android.view.ViewGroup, android.view.View
    public void onLayout(boolean z10, int i10, int i11, int i12, int i13) {
        super.onLayout(z10, i10, i11, i12, i13);
        o();
    }

    @Override // androidx.constraintlayout.widget.ConstraintLayout, android.view.View
    public void onMeasure(int i10, int i11) {
        DisplayMetrics displayMetrics = getResources().getDisplayMetrics();
        int iR = (int) (this.f21721o / r(this.f21719m / displayMetrics.heightPixels, this.f21720n / displayMetrics.widthPixels, 1.0f));
        int iMakeMeasureSpec = View.MeasureSpec.makeMeasureSpec(iR, 1073741824);
        setMeasuredDimension(iR, iR);
        super.onMeasure(iMakeMeasureSpec, iMakeMeasureSpec);
    }

    public final RadialGradient p(RectF rectF, TextView textView) {
        textView.getHitRect(this.f21711e);
        this.f21712f.set(this.f21711e);
        textView.getLineBounds(0, this.f21713g);
        RectF rectF2 = this.f21712f;
        Rect rect = this.f21713g;
        rectF2.inset(rect.left, rect.top);
        if (RectF.intersects(rectF, this.f21712f)) {
            return new RadialGradient(rectF.centerX() - this.f21712f.left, rectF.centerY() - this.f21712f.top, rectF.width() * 0.5f, this.f21716j, this.f21717k, Shader.TileMode.CLAMP);
        }
        return null;
    }

    public final TextView q(RectF rectF) {
        float f10 = Float.MAX_VALUE;
        TextView textView = null;
        for (int i10 = 0; i10 < this.f21714h.size(); i10++) {
            TextView textView2 = this.f21714h.get(i10);
            if (textView2 != null) {
                textView2.getHitRect(this.f21711e);
                this.f21712f.set(this.f21711e);
                this.f21712f.union(rectF);
                float fWidth = this.f21712f.width() * this.f21712f.height();
                if (fWidth < f10) {
                    textView = textView2;
                    f10 = fWidth;
                }
            }
        }
        return textView;
    }

    public void s(String[] strArr, int i10) {
        this.f21722p = strArr;
        t(i10);
    }

    public final void t(int i10) {
        LayoutInflater layoutInflaterFrom = LayoutInflater.from(getContext());
        int size = this.f21714h.size();
        boolean z10 = false;
        for (int i11 = 0; i11 < Math.max(this.f21722p.length, size); i11++) {
            TextView textView = this.f21714h.get(i11);
            if (i11 >= this.f21722p.length) {
                removeView(textView);
                this.f21714h.remove(i11);
            } else {
                if (textView == null) {
                    textView = (TextView) layoutInflaterFrom.inflate(R$layout.material_clockface_textview, (ViewGroup) this, false);
                    this.f21714h.put(i11, textView);
                    addView(textView);
                }
                textView.setText(this.f21722p[i11]);
                textView.setTag(R$id.material_value_index, Integer.valueOf(i11));
                int i12 = (i11 / 12) + 1;
                textView.setTag(R$id.material_clock_level, Integer.valueOf(i12));
                if (i12 > 1) {
                    z10 = true;
                }
                N.i0(textView, this.f21715i);
                textView.setTextColor(this.f21724r);
                if (i10 != 0) {
                    textView.setContentDescription(getResources().getString(i10, this.f21722p[i11]));
                }
            }
        }
        this.f21710d.q(z10);
    }

    @SuppressLint({"ClickableViewAccessibility"})
    public ClockFaceView(Context context, AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        this.f21711e = new Rect();
        this.f21712f = new RectF();
        this.f21713g = new Rect();
        this.f21714h = new SparseArray<>();
        this.f21717k = new float[]{0.0f, 0.9f, 1.0f};
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R$styleable.ClockFaceView, i10, R$style.Widget_MaterialComponents_TimePicker_Clock);
        Resources resources = getResources();
        ColorStateList colorStateListA = W2.c.a(context, typedArrayObtainStyledAttributes, R$styleable.ClockFaceView_clockNumberTextColor);
        this.f21724r = colorStateListA;
        LayoutInflater.from(context).inflate(R$layout.material_clockface_view, (ViewGroup) this, true);
        ClockHandView clockHandView = (ClockHandView) findViewById(R$id.material_clock_hand);
        this.f21710d = clockHandView;
        this.f21718l = resources.getDimensionPixelSize(R$dimen.material_clock_hand_padding);
        int colorForState = colorStateListA.getColorForState(new int[]{R.attr.state_selected}, colorStateListA.getDefaultColor());
        this.f21716j = new int[]{colorForState, colorForState, colorStateListA.getDefaultColor()};
        clockHandView.b(this);
        int defaultColor = C4027a.a(context, R$color.material_timepicker_clockface).getDefaultColor();
        ColorStateList colorStateListA2 = W2.c.a(context, typedArrayObtainStyledAttributes, R$styleable.ClockFaceView_clockFaceBackgroundColor);
        setBackgroundColor(colorStateListA2 != null ? colorStateListA2.getDefaultColor() : defaultColor);
        getViewTreeObserver().addOnPreDrawListener(new a());
        setFocusable(false);
        typedArrayObtainStyledAttributes.recycle();
        this.f21715i = new b();
        String[] strArr = new String[12];
        Arrays.fill(strArr, "");
        s(strArr, 0);
        this.f21719m = resources.getDimensionPixelSize(R$dimen.material_time_picker_minimum_screen_height);
        this.f21720n = resources.getDimensionPixelSize(R$dimen.material_time_picker_minimum_screen_width);
        this.f21721o = resources.getDimensionPixelSize(R$dimen.material_clock_size);
    }
}
