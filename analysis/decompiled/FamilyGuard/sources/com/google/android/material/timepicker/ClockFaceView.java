package com.google.android.material.timepicker;

import E.c;
import a1.C0409b;
import a1.C0410c;
import a1.C0411d;
import a1.C0413f;
import a1.C0415h;
import a1.C0417j;
import a1.C0418k;
import android.R;
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
import androidx.core.view.C0456a;
import androidx.core.view.H;
import com.google.android.material.timepicker.ClockHandView;
import h.C0744a;
import java.util.Arrays;
import org.libpag.BuildConfig;
import q1.C0981c;

/* loaded from: classes.dex */
class ClockFaceView extends d implements ClockHandView.b {

    /* renamed from: B, reason: collision with root package name */
    private final ClockHandView f13443B;

    /* renamed from: C, reason: collision with root package name */
    private final Rect f13444C;

    /* renamed from: D, reason: collision with root package name */
    private final RectF f13445D;

    /* renamed from: E, reason: collision with root package name */
    private final Rect f13446E;

    /* renamed from: F, reason: collision with root package name */
    private final SparseArray<TextView> f13447F;

    /* renamed from: G, reason: collision with root package name */
    private final C0456a f13448G;

    /* renamed from: H, reason: collision with root package name */
    private final int[] f13449H;

    /* renamed from: I, reason: collision with root package name */
    private final float[] f13450I;

    /* renamed from: J, reason: collision with root package name */
    private final int f13451J;

    /* renamed from: K, reason: collision with root package name */
    private final int f13452K;

    /* renamed from: L, reason: collision with root package name */
    private final int f13453L;

    /* renamed from: M, reason: collision with root package name */
    private final int f13454M;

    /* renamed from: Q, reason: collision with root package name */
    private String[] f13455Q;

    /* renamed from: R, reason: collision with root package name */
    private float f13456R;

    /* renamed from: S, reason: collision with root package name */
    private final ColorStateList f13457S;

    class a implements ViewTreeObserver.OnPreDrawListener {
        a() {
        }

        @Override // android.view.ViewTreeObserver.OnPreDrawListener
        public boolean onPreDraw() {
            if (!ClockFaceView.this.isShown()) {
                return true;
            }
            ClockFaceView.this.getViewTreeObserver().removeOnPreDrawListener(this);
            ClockFaceView.this.F(((ClockFaceView.this.getHeight() / 2) - ClockFaceView.this.f13443B.i()) - ClockFaceView.this.f13451J);
            return true;
        }
    }

    class b extends C0456a {
        b() {
        }

        @Override // androidx.core.view.C0456a
        public void onInitializeAccessibilityNodeInfo(View view, E.c cVar) {
            super.onInitializeAccessibilityNodeInfo(view, cVar);
            int iIntValue = ((Integer) view.getTag(C0413f.f6853p)).intValue();
            if (iIntValue > 0) {
                cVar.B0((View) ClockFaceView.this.f13447F.get(iIntValue - 1));
            }
            cVar.g0(c.f.a(0, 1, iIntValue, 1, false, view.isSelected()));
            cVar.e0(true);
            cVar.b(c.a.f1250i);
        }

        @Override // androidx.core.view.C0456a
        public boolean performAccessibilityAction(View view, int i5, Bundle bundle) {
            if (i5 != 16) {
                return super.performAccessibilityAction(view, i5, bundle);
            }
            long jUptimeMillis = SystemClock.uptimeMillis();
            view.getHitRect(ClockFaceView.this.f13444C);
            float fCenterX = ClockFaceView.this.f13444C.centerX();
            float fCenterY = ClockFaceView.this.f13444C.centerY();
            ClockFaceView.this.f13443B.onTouchEvent(MotionEvent.obtain(jUptimeMillis, jUptimeMillis, 0, fCenterX, fCenterY, 0));
            ClockFaceView.this.f13443B.onTouchEvent(MotionEvent.obtain(jUptimeMillis, jUptimeMillis, 1, fCenterX, fCenterY, 0));
            return true;
        }
    }

    public ClockFaceView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, C0409b.f6731r);
    }

    private void N() {
        RectF rectFE = this.f13443B.e();
        TextView textViewP = P(rectFE);
        for (int i5 = 0; i5 < this.f13447F.size(); i5++) {
            TextView textView = this.f13447F.get(i5);
            if (textView != null) {
                textView.setSelected(textView == textViewP);
                textView.getPaint().setShader(O(rectFE, textView));
                textView.invalidate();
            }
        }
    }

    private RadialGradient O(RectF rectF, TextView textView) {
        textView.getHitRect(this.f13444C);
        this.f13445D.set(this.f13444C);
        textView.getLineBounds(0, this.f13446E);
        RectF rectF2 = this.f13445D;
        Rect rect = this.f13446E;
        rectF2.inset(rect.left, rect.top);
        if (RectF.intersects(rectF, this.f13445D)) {
            return new RadialGradient(rectF.centerX() - this.f13445D.left, rectF.centerY() - this.f13445D.top, rectF.width() * 0.5f, this.f13449H, this.f13450I, Shader.TileMode.CLAMP);
        }
        return null;
    }

    private TextView P(RectF rectF) {
        float f5 = Float.MAX_VALUE;
        TextView textView = null;
        for (int i5 = 0; i5 < this.f13447F.size(); i5++) {
            TextView textView2 = this.f13447F.get(i5);
            if (textView2 != null) {
                textView2.getHitRect(this.f13444C);
                this.f13445D.set(this.f13444C);
                this.f13445D.union(rectF);
                float fWidth = this.f13445D.width() * this.f13445D.height();
                if (fWidth < f5) {
                    textView = textView2;
                    f5 = fWidth;
                }
            }
        }
        return textView;
    }

    private static float Q(float f5, float f6, float f7) {
        return Math.max(Math.max(f5, f6), f7);
    }

    private void S(int i5) {
        LayoutInflater layoutInflaterFrom = LayoutInflater.from(getContext());
        int size = this.f13447F.size();
        boolean z5 = false;
        for (int i6 = 0; i6 < Math.max(this.f13455Q.length, size); i6++) {
            TextView textView = this.f13447F.get(i6);
            if (i6 >= this.f13455Q.length) {
                removeView(textView);
                this.f13447F.remove(i6);
            } else {
                if (textView == null) {
                    textView = (TextView) layoutInflaterFrom.inflate(C0415h.f6870d, (ViewGroup) this, false);
                    this.f13447F.put(i6, textView);
                    addView(textView);
                }
                textView.setText(this.f13455Q[i6]);
                textView.setTag(C0413f.f6853p, Integer.valueOf(i6));
                int i7 = (i6 / 12) + 1;
                textView.setTag(C0413f.f6848k, Integer.valueOf(i7));
                if (i7 > 1) {
                    z5 = true;
                }
                H.k0(textView, this.f13448G);
                textView.setTextColor(this.f13457S);
                if (i5 != 0) {
                    textView.setContentDescription(getResources().getString(i5, this.f13455Q[i6]));
                }
            }
        }
        this.f13443B.q(z5);
    }

    @Override // com.google.android.material.timepicker.d
    public void F(int i5) {
        if (i5 != E()) {
            super.F(i5);
            this.f13443B.m(E());
        }
    }

    @Override // com.google.android.material.timepicker.d
    protected void H() {
        super.H();
        for (int i5 = 0; i5 < this.f13447F.size(); i5++) {
            this.f13447F.get(i5).setVisibility(0);
        }
    }

    public void R(String[] strArr, int i5) {
        this.f13455Q = strArr;
        S(i5);
    }

    @Override // com.google.android.material.timepicker.ClockHandView.b
    public void a(float f5, boolean z5) {
        if (Math.abs(this.f13456R - f5) > 0.001f) {
            this.f13456R = f5;
            N();
        }
    }

    @Override // android.view.View
    public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo accessibilityNodeInfo) {
        super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
        E.c.E0(accessibilityNodeInfo).f0(c.e.a(1, this.f13455Q.length, false, 1));
    }

    @Override // androidx.constraintlayout.widget.ConstraintLayout, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z5, int i5, int i6, int i7, int i8) {
        super.onLayout(z5, i5, i6, i7, i8);
        N();
    }

    @Override // androidx.constraintlayout.widget.ConstraintLayout, android.view.View
    protected void onMeasure(int i5, int i6) {
        DisplayMetrics displayMetrics = getResources().getDisplayMetrics();
        int iQ = (int) (this.f13454M / Q(this.f13452K / displayMetrics.heightPixels, this.f13453L / displayMetrics.widthPixels, 1.0f));
        int iMakeMeasureSpec = View.MeasureSpec.makeMeasureSpec(iQ, 1073741824);
        setMeasuredDimension(iQ, iQ);
        super.onMeasure(iMakeMeasureSpec, iMakeMeasureSpec);
    }

    public ClockFaceView(Context context, AttributeSet attributeSet, int i5) {
        super(context, attributeSet, i5);
        this.f13444C = new Rect();
        this.f13445D = new RectF();
        this.f13446E = new Rect();
        this.f13447F = new SparseArray<>();
        this.f13450I = new float[]{0.0f, 0.9f, 1.0f};
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, C0418k.f7002L0, i5, C0417j.f6933x);
        Resources resources = getResources();
        ColorStateList colorStateListA = C0981c.a(context, typedArrayObtainStyledAttributes, C0418k.f7014N0);
        this.f13457S = colorStateListA;
        LayoutInflater.from(context).inflate(C0415h.f6871e, (ViewGroup) this, true);
        ClockHandView clockHandView = (ClockHandView) findViewById(C0413f.f6847j);
        this.f13443B = clockHandView;
        this.f13451J = resources.getDimensionPixelSize(C0411d.f6805y);
        int colorForState = colorStateListA.getColorForState(new int[]{R.attr.state_selected}, colorStateListA.getDefaultColor());
        this.f13449H = new int[]{colorForState, colorForState, colorStateListA.getDefaultColor()};
        clockHandView.b(this);
        int defaultColor = C0744a.a(context, C0410c.f6741b).getDefaultColor();
        ColorStateList colorStateListA2 = C0981c.a(context, typedArrayObtainStyledAttributes, C0418k.f7008M0);
        setBackgroundColor(colorStateListA2 != null ? colorStateListA2.getDefaultColor() : defaultColor);
        getViewTreeObserver().addOnPreDrawListener(new a());
        setFocusable(false);
        typedArrayObtainStyledAttributes.recycle();
        this.f13448G = new b();
        String[] strArr = new String[12];
        Arrays.fill(strArr, BuildConfig.FLAVOR);
        R(strArr, 0);
        this.f13452K = resources.getDimensionPixelSize(C0411d.f6758M);
        this.f13453L = resources.getDimensionPixelSize(C0411d.f6759N);
        this.f13454M = resources.getDimensionPixelSize(C0411d.f6746A);
    }
}
