package com.stepos.common.widget;

import android.animation.ValueAnimator;
import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.StateListDrawable;
import android.os.Parcelable;
import android.text.TextPaint;
import android.text.TextUtils;
import android.text.method.TransformationMethod;
import android.util.AttributeSet;
import android.util.StateSet;
import android.view.accessibility.AccessibilityNodeInfo;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.Interpolator;
import android.view.animation.PathInterpolator;
import android.widget.Button;
import com.stepos.agentsafetycenter.R;
import com.stepos.common.drawble.CircularAnimatedDrawable;
import com.stepos.common.drawble.CircularProgressDrawable;
import com.stepos.common.drawble.StrokeGradientDrawable;
import java.lang.invoke.VarHandle;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public class CircularProgressButton extends Button {
    public final int A;
    public final float B;
    public boolean C;
    public boolean D;
    public Drawable E;
    public boolean F;
    public boolean G;
    public d H;
    public final ColorStateList I;
    public final ColorStateList J;
    public final ColorStateList K;
    public final ColorStateList L;
    public final ColorStateList M;
    public final ColorStateList N;
    public boolean O;
    public boolean P;
    public final boolean Q;
    public int R;
    public int S;
    public boolean T;
    public boolean U;
    public int V;
    public final int W;

    /* renamed from: a0, reason: collision with root package name */
    public int f2558a0;

    /* renamed from: b0, reason: collision with root package name */
    public boolean f2559b0;

    /* renamed from: c, reason: collision with root package name */
    public final StrokeGradientDrawable f2560c;

    /* renamed from: c0, reason: collision with root package name */
    public ValueAnimator f2561c0;

    /* renamed from: d0, reason: collision with root package name */
    public int f2562d0;
    public boolean e0;

    /* renamed from: f, reason: collision with root package name */
    public CircularAnimatedDrawable f2563f;
    public final a f0;

    /* renamed from: g, reason: collision with root package name */
    public CircularProgressDrawable f2564g;

    /* renamed from: g0, reason: collision with root package name */
    public final a f2565g0;

    /* renamed from: h, reason: collision with root package name */
    public final ColorStateList f2566h;

    /* renamed from: h0, reason: collision with root package name */
    public final a f2567h0;
    public final ColorStateList i;

    /* renamed from: i0, reason: collision with root package name */
    public final a f2568i0;

    /* renamed from: j, reason: collision with root package name */
    public final ColorStateList f2569j;

    /* renamed from: k, reason: collision with root package name */
    public final StateListDrawable f2570k;

    /* renamed from: l, reason: collision with root package name */
    public final StateListDrawable f2571l;

    /* renamed from: m, reason: collision with root package name */
    public final StateListDrawable f2572m;

    /* renamed from: n, reason: collision with root package name */
    public StateListDrawable f2573n;

    /* renamed from: o, reason: collision with root package name */
    public StateListDrawable f2574o;

    /* renamed from: p, reason: collision with root package name */
    public f f2575p;

    /* renamed from: q, reason: collision with root package name */
    public String f2576q;

    /* renamed from: r, reason: collision with root package name */
    public String f2577r;

    /* renamed from: s, reason: collision with root package name */
    public String f2578s;

    /* renamed from: t, reason: collision with root package name */
    public final String f2579t;

    /* renamed from: u, reason: collision with root package name */
    public final int f2580u;

    /* renamed from: v, reason: collision with root package name */
    public int f2581v;

    /* renamed from: w, reason: collision with root package name */
    public int f2582w;

    /* renamed from: x, reason: collision with root package name */
    public final int f2583x;

    /* renamed from: y, reason: collision with root package name */
    public final int f2584y;

    /* renamed from: z, reason: collision with root package name */
    public final int f2585z;

    public CircularProgressButton(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.G = true;
        this.O = false;
        this.P = false;
        this.Q = true;
        this.S = 0;
        this.T = true;
        this.f2558a0 = 0;
        a aVar = new a(0);
        aVar.f2661b = this;
        VarHandle.storeStoreFence();
        this.f0 = aVar;
        a aVar2 = new a(1);
        aVar2.f2661b = this;
        VarHandle.storeStoreFence();
        this.f2565g0 = aVar2;
        a aVar3 = new a(2);
        aVar3.f2661b = this;
        VarHandle.storeStoreFence();
        this.f2567h0 = aVar3;
        a aVar4 = new a(4);
        aVar4.f2661b = this;
        VarHandle.storeStoreFence();
        this.f2568i0 = aVar4;
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, q9.a.f10198a, i, 0);
        if (typedArrayObtainStyledAttributes != null) {
            int dimensionPixelSize = typedArrayObtainStyledAttributes.getDimensionPixelSize(14, (int) getContext().getResources().getDimension(R.dimen.mc_cir_progress_button_stroke_width));
            this.f2585z = dimensionPixelSize;
            this.V = dimensionPixelSize;
            this.f2576q = typedArrayObtainStyledAttributes.getString(20);
            this.f2577r = typedArrayObtainStyledAttributes.getString(18);
            this.f2578s = typedArrayObtainStyledAttributes.getString(19);
            this.f2579t = typedArrayObtainStyledAttributes.getString(21);
            this.f2583x = typedArrayObtainStyledAttributes.getResourceId(5, 0);
            this.f2584y = typedArrayObtainStyledAttributes.getResourceId(6, 0);
            this.B = typedArrayObtainStyledAttributes.getDimension(4, 0.0f);
            this.A = typedArrayObtainStyledAttributes.getDimensionPixelSize(7, 0);
            int resourceId = typedArrayObtainStyledAttributes.getResourceId(10, R.color.mc_cir_progress_button_red);
            this.f2566h = getResources().getColorStateList(resourceId);
            this.L = getResources().getColorStateList(typedArrayObtainStyledAttributes.getResourceId(13, resourceId));
            int resourceId2 = typedArrayObtainStyledAttributes.getResourceId(8, R.color.mc_cir_progress_button_green);
            this.i = getResources().getColorStateList(resourceId2);
            this.M = getResources().getColorStateList(typedArrayObtainStyledAttributes.getResourceId(11, resourceId2));
            int resourceId3 = typedArrayObtainStyledAttributes.getResourceId(9, R.color.mc_cir_progress_button_red);
            this.f2569j = getResources().getColorStateList(resourceId3);
            this.N = getResources().getColorStateList(typedArrayObtainStyledAttributes.getResourceId(12, resourceId3));
            this.f2580u = typedArrayObtainStyledAttributes.getColor(3, getResources().getColor(R.color.mc_cir_progress_button_white));
            this.f2581v = typedArrayObtainStyledAttributes.getColor(1, getResources().getColor(R.color.mc_cir_progress_button_red));
            this.f2582w = typedArrayObtainStyledAttributes.getColor(2, getResources().getColor(R.color.mc_cir_progress_button_blank));
            ColorStateList colorStateList = typedArrayObtainStyledAttributes.getColorStateList(16);
            this.K = colorStateList;
            if (colorStateList == null) {
                this.K = getTextColors();
            }
            ColorStateList colorStateList2 = typedArrayObtainStyledAttributes.getColorStateList(17);
            this.I = colorStateList2;
            if (colorStateList2 == null) {
                this.I = getTextColors();
            }
            ColorStateList colorStateList3 = typedArrayObtainStyledAttributes.getColorStateList(15);
            this.J = colorStateList3;
            if (colorStateList3 == null) {
                this.J = getTextColors();
            }
            this.Q = typedArrayObtainStyledAttributes.getBoolean(0, true);
            typedArrayObtainStyledAttributes.recycle();
        }
        this.W = 100;
        this.f2575p = f.f2686f;
        setText(this.f2576q);
        s();
        int iF = f(this.f2566h);
        int iG = g(this.f2566h);
        int colorForState = this.f2566h.getColorForState(new int[]{android.R.attr.state_focused}, 0);
        int colorForState2 = this.f2566h.getColorForState(new int[]{-16842910}, 0);
        int iF2 = f(this.L);
        int iG2 = g(this.L);
        int colorForState3 = this.L.getColorForState(new int[]{android.R.attr.state_focused}, 0);
        int colorForState4 = this.L.getColorForState(new int[]{-16842910}, 0);
        if (this.f2560c == null) {
            this.f2560c = c(iF, iF2);
        }
        StrokeGradientDrawable strokeGradientDrawableC = c(colorForState2, colorForState4);
        StrokeGradientDrawable strokeGradientDrawableC2 = c(colorForState, colorForState3);
        StrokeGradientDrawable strokeGradientDrawableC3 = c(iG, iG2);
        if (this.f2570k == null) {
            StateListDrawable stateListDrawable = new StateListDrawable();
            this.f2570k = stateListDrawable;
            stateListDrawable.setCallback(this);
        }
        this.f2570k.addState(new int[]{android.R.attr.state_pressed}, strokeGradientDrawableC3.getGradientDrawable());
        this.f2570k.addState(new int[]{android.R.attr.state_focused}, strokeGradientDrawableC2.getGradientDrawable());
        this.f2570k.addState(new int[]{-16842910}, strokeGradientDrawableC.getGradientDrawable());
        StateListDrawable stateListDrawable2 = this.f2570k;
        int[] iArr = StateSet.WILD_CARD;
        stateListDrawable2.addState(iArr, this.f2560c.getGradientDrawable());
        this.f2570k.setBounds(0, 0, getRight() - getLeft(), getBottom() - getTop());
        StrokeGradientDrawable strokeGradientDrawableC4 = c(g(this.i), g(this.M));
        if (this.f2571l == null) {
            StateListDrawable stateListDrawable3 = new StateListDrawable();
            this.f2571l = stateListDrawable3;
            stateListDrawable3.setCallback(this);
        }
        this.f2571l.addState(new int[]{android.R.attr.state_pressed}, strokeGradientDrawableC4.getGradientDrawable());
        this.f2571l.addState(iArr, this.f2560c.getGradientDrawable());
        this.f2571l.setBounds(0, 0, getRight() - getLeft(), getBottom() - getTop());
        i();
        StrokeGradientDrawable strokeGradientDrawableC5 = c(g(this.f2569j), g(this.N));
        if (this.f2572m == null) {
            StateListDrawable stateListDrawable4 = new StateListDrawable();
            this.f2572m = stateListDrawable4;
            stateListDrawable4.setCallback(this);
        }
        this.f2572m.addState(new int[]{android.R.attr.state_pressed}, strokeGradientDrawableC5.getGradientDrawable());
        this.f2572m.addState(iArr, this.f2560c.getGradientDrawable());
        this.f2572m.setBounds(0, 0, getRight() - getLeft(), getBottom() - getTop());
        this.f2574o = this.f2570k;
        setBackgroundCompat(null);
        new r9.l().a(this);
    }

    public static int f(ColorStateList colorStateList) {
        return colorStateList.getColorForState(new int[]{android.R.attr.state_enabled}, 0);
    }

    public static int g(ColorStateList colorStateList) {
        return colorStateList.getColorForState(new int[]{android.R.attr.state_pressed}, 0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Interpolator getInterpolator() {
        return new PathInterpolator(0.2f, 0.38f, 0.1f, 1.0f);
    }

    private void setBackgroundFromState(f fVar) {
        int iOrdinal = fVar.ordinal();
        if (iOrdinal == 0) {
            this.f2574o = this.f2573n;
            return;
        }
        if (iOrdinal == 1) {
            this.f2574o = this.f2570k;
        } else if (iOrdinal == 2) {
            this.f2574o = this.f2571l;
        } else {
            if (iOrdinal != 3) {
                return;
            }
            this.f2574o = this.f2572m;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setIcon(int i) throws Resources.NotFoundException {
        Drawable drawable = getResources().getDrawable(i);
        if (drawable != null) {
            int width = (getWidth() / 2) - (drawable.getIntrinsicWidth() / 2);
            setCompoundDrawablesWithIntrinsicBounds(i, 0, 0, 0);
            setPadding(width, 0, 0, 0);
        }
    }

    private void setState(f fVar) {
        if (this.f2575p != fVar) {
            this.f2575p = fVar;
        }
    }

    private void setTextForState(f fVar) {
        int iOrdinal = fVar.ordinal();
        if (iOrdinal == 1) {
            setText(this.f2576q);
            s();
        } else if (iOrdinal == 2) {
            setText(this.f2577r);
            s();
        } else {
            if (iOrdinal != 3) {
                return;
            }
            setText(this.f2578s);
            s();
        }
    }

    public final StrokeGradientDrawable c(int i, int i3) {
        GradientDrawable gradientDrawable = (GradientDrawable) getResources().getDrawable(R.drawable.mc_cir_pro_btn_background).mutate();
        gradientDrawable.setColor(i);
        gradientDrawable.setCornerRadius(this.B);
        StrokeGradientDrawable strokeGradientDrawable = new StrokeGradientDrawable(gradientDrawable);
        strokeGradientDrawable.setStrokeColor(i3);
        return strokeGradientDrawable;
    }

    public final d d() {
        this.f2559b0 = true;
        setClickable(false);
        d dVar = new d(this, this, this.f2560c);
        this.H = dVar;
        float f5 = this.B;
        dVar.i = f5;
        dVar.f2674j = f5;
        dVar.f2668c = getWidth();
        this.H.f2669d = getWidth();
        if (this.D || !this.G) {
            this.H.f2667b = 1;
        } else {
            this.H.f2667b = 240;
        }
        this.D = false;
        return this.H;
    }

    @Override // android.view.View
    public final void draw(Canvas canvas) {
        StateListDrawable stateListDrawable;
        if (this.P || !this.f2559b0) {
            this.P = false;
            r(f.f2686f, this.f2570k);
            r(f.f2687g, this.f2571l);
            r(f.f2688h, this.f2572m);
            r(this.f2575p, this.f2560c.getGradientDrawable());
        }
        if (this.f2559b0 && isPressed()) {
            super.draw(canvas);
            return;
        }
        if (this.f2574o != null) {
            if ((getScrollX() | getScrollY()) == 0) {
                int iOrdinal = this.f2575p.ordinal();
                if (iOrdinal == 0) {
                    StateListDrawable stateListDrawable2 = this.f2573n;
                    if (stateListDrawable2 != null) {
                        stateListDrawable2.draw(canvas);
                    }
                } else if (iOrdinal == 1) {
                    StateListDrawable stateListDrawable3 = this.f2570k;
                    if (stateListDrawable3 != null) {
                        stateListDrawable3.draw(canvas);
                    }
                } else if (iOrdinal == 2) {
                    StateListDrawable stateListDrawable4 = this.f2571l;
                    if (stateListDrawable4 != null) {
                        stateListDrawable4.draw(canvas);
                    }
                } else if (iOrdinal == 3 && (stateListDrawable = this.f2572m) != null) {
                    stateListDrawable.draw(canvas);
                }
            } else {
                canvas.translate(getScrollX(), getScrollY());
                this.f2574o.draw(canvas);
                canvas.translate(-getScrollX(), -getScrollY());
            }
        }
        super.draw(canvas);
    }

    @Override // android.widget.TextView, android.view.View
    public final void drawableStateChanged() {
        Rect rect;
        if (this.f2559b0) {
            rect = new Rect();
            rect.set(this.f2560c.getGradientDrawable().getBounds());
        } else {
            rect = null;
        }
        int[] drawableState = getDrawableState();
        StateListDrawable stateListDrawable = this.f2570k;
        if (stateListDrawable != null) {
            stateListDrawable.setState(drawableState);
        }
        int[] drawableState2 = getDrawableState();
        StateListDrawable stateListDrawable2 = this.f2571l;
        if (stateListDrawable2 != null) {
            stateListDrawable2.setState(drawableState2);
        }
        int[] drawableState3 = getDrawableState();
        StateListDrawable stateListDrawable3 = this.f2572m;
        if (stateListDrawable3 != null) {
            stateListDrawable3.setState(drawableState3);
        }
        StateListDrawable stateListDrawable4 = this.f2573n;
        int[] drawableState4 = getDrawableState();
        if (stateListDrawable4 != null) {
            stateListDrawable4.setState(drawableState4);
        }
        if (this.f2559b0 && rect != null) {
            this.f2560c.getGradientDrawable().setBounds(rect);
        }
        super.drawableStateChanged();
    }

    public final d e(float f5, float f10, int i, int i3) {
        this.f2559b0 = true;
        setClickable(false);
        d dVar = new d(this, this, this.f2560c);
        this.H = dVar;
        dVar.i = f5;
        dVar.f2674j = f10;
        dVar.f2677m = this.A;
        dVar.f2668c = i;
        dVar.f2669d = i3;
        if (this.D || !this.G) {
            dVar.f2667b = 1;
        } else {
            dVar.f2667b = 240;
        }
        this.D = false;
        return dVar;
    }

    public String getCompleteText() {
        return this.f2577r;
    }

    public String getErrorText() {
        return this.f2578s;
    }

    public String getIdleText() {
        return this.f2576q;
    }

    public int getProgress() {
        return this.f2558a0;
    }

    public f getState() {
        return this.f2575p;
    }

    public final int h(TextPaint textPaint, String str) {
        TransformationMethod transformationMethod = getTransformationMethod();
        if (transformationMethod != null) {
            str = transformationMethod.getTransformation(str, this).toString();
        }
        return (int) textPaint.measureText(str);
    }

    public final void i() {
        if (this.f2573n == null) {
            StateListDrawable stateListDrawable = new StateListDrawable();
            this.f2573n = stateListDrawable;
            stateListDrawable.setCallback(this);
        }
        this.f2573n.addState(StateSet.WILD_CARD, this.f2560c.getGradientDrawable());
        int iAbs = (Math.abs(getWidth() - getHeight()) / 2) + this.A;
        int width = getWidth() - iAbs;
        int i = this.A;
        this.f2573n.setBounds(iAbs, i, width - i, getHeight() - this.A);
    }

    public final void j() {
        d dVarD = d();
        dVarD.f2670e = f(this.i);
        dVarD.f2671f = f(this.f2566h);
        dVarD.f2672g = f(this.M);
        dVarD.f2673h = f(this.L);
        dVarD.f2666a = this.f2567h0;
        setState(f.f2686f);
        this.f2574o = this.f2570k;
        dVarD.a();
    }

    public final void k() {
        d dVarD = d();
        dVarD.f2670e = f(this.f2569j);
        dVarD.f2671f = f(this.f2566h);
        dVarD.f2672g = f(this.N);
        dVarD.f2673h = f(this.L);
        dVarD.f2666a = this.f2567h0;
        setState(f.f2686f);
        this.f2574o = this.f2570k;
        dVarD.a();
    }

    public final void l() {
        d dVarD = d();
        dVarD.f2670e = f(this.f2566h);
        dVarD.f2672g = f(this.L);
        dVarD.f2671f = f(this.i);
        dVarD.f2673h = f(this.M);
        dVarD.f2666a = this.f2565g0;
        setState(f.f2687g);
        this.f2574o = this.f2571l;
        dVarD.a();
    }

    public final void m() {
        d dVarD = d();
        dVarD.f2670e = f(this.f2566h);
        dVarD.f2671f = f(this.f2569j);
        dVarD.f2672g = f(this.L);
        dVarD.f2673h = f(this.N);
        dVarD.f2666a = this.f2568i0;
        setState(f.f2688h);
        this.f2574o = this.f2572m;
        dVarD.a();
    }

    public final void n() {
        d dVarE = e(getHeight(), this.B, getHeight(), getWidth());
        dVarE.f2670e = this.f2580u;
        dVarE.f2672g = this.f2581v;
        dVarE.f2673h = f(this.M);
        dVarE.f2671f = f(this.i);
        dVarE.f2675k = this.V;
        dVarE.f2676l = this.f2585z;
        dVarE.f2666a = this.f2565g0;
        setState(f.f2687g);
        this.f2574o = this.f2571l;
        dVarE.a();
    }

    public final void o() {
        d dVarE = e(getHeight(), this.B, getHeight(), getWidth());
        dVarE.f2670e = this.f2580u;
        dVarE.f2671f = f(this.f2569j);
        dVarE.f2672g = this.f2581v;
        dVarE.f2673h = f(this.N);
        dVarE.f2675k = this.V;
        dVarE.f2676l = this.f2585z;
        dVarE.f2666a = this.f2568i0;
        setState(f.f2688h);
        this.f2574o = this.f2572m;
        dVarE.a();
    }

    @Override // android.view.View
    public final void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        d dVar = this.H;
        if (dVar != null) {
            dVar.f2680p.end();
            dVar.f2680p.removeAllListeners();
        }
    }

    @Override // android.widget.TextView, android.view.View
    public final void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (this.f2575p != f.f2685c || this.f2559b0) {
            CircularAnimatedDrawable circularAnimatedDrawable = this.f2563f;
            if (circularAnimatedDrawable != null) {
                circularAnimatedDrawable.setAllowLoading(false);
                return;
            }
            return;
        }
        if (this.C) {
            CircularAnimatedDrawable circularAnimatedDrawable2 = this.f2563f;
            if (circularAnimatedDrawable2 != null) {
                circularAnimatedDrawable2.setAllowLoading(true);
                this.f2563f.draw(canvas);
                return;
            }
            int width = (getWidth() - getHeight()) / 2;
            this.f2563f = new CircularAnimatedDrawable(this.f2581v, this.V);
            int i = this.A + width;
            int width2 = (getWidth() - width) - this.A;
            int height = getHeight();
            int i3 = this.A;
            this.f2563f.setBounds(i, i3, width2, height - i3);
            this.f2563f.setCallback(this);
            this.f2563f.start();
            return;
        }
        if (this.f2564g == null) {
            int width3 = (getWidth() - getHeight()) / 2;
            this.f2564g = new CircularProgressDrawable(getHeight() - (this.A * 2), this.V, this.f2581v);
            int i10 = width3 + this.A;
            float f5 = this.A;
            this.f2564g.setOffset(((getWidth() - getHeight()) / 2.0f) + f5, f5);
            CircularProgressDrawable circularProgressDrawable = this.f2564g;
            int i11 = this.A;
            circularProgressDrawable.setBounds(i10, i11, i10, i11);
        }
        if (this.F) {
            this.F = false;
            this.f2564g.setCenterIcon(this.E);
            if (this.E == null) {
                this.f2564g.setShowCenterIcon(this.O);
            }
        }
        this.f2564g.setStartAngle(-90.0f);
        this.f2564g.setSweepAngle((360.0f / this.W) * this.f2562d0);
        this.f2564g.draw(canvas);
    }

    @Override // android.view.View
    public final void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo accessibilityNodeInfo) {
        super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
        accessibilityNodeInfo.setClassName(CircularProgressButton.class.getName());
    }

    @Override // android.widget.TextView, android.view.View
    public final void onLayout(boolean z10, int i, int i3, int i10, int i11) {
        super.onLayout(z10, i, i3, i10, i11);
        if (z10) {
            t(this.f2575p, false);
        }
    }

    @Override // android.widget.TextView, android.view.View
    public final void onRestoreInstanceState(Parcelable parcelable) {
        if (!(parcelable instanceof e)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        e eVar = (e) parcelable;
        this.f2558a0 = eVar.f2684g;
        this.C = eVar.f2682c;
        this.D = eVar.f2683f;
        super.onRestoreInstanceState(eVar.getSuperState());
        setProgress(this.f2558a0);
    }

    @Override // android.widget.TextView, android.view.View
    public final Parcelable onSaveInstanceState() {
        e eVar = new e(super.onSaveInstanceState());
        eVar.f2684g = this.f2558a0;
        eVar.f2682c = this.C;
        eVar.f2683f = true;
        return eVar;
    }

    @Override // android.view.View
    public final void onSizeChanged(int i, int i3, int i10, int i11) {
        super.onSizeChanged(i, i3, i10, i11);
        this.f2563f = null;
        this.f2564g = null;
        this.F = true;
        this.P = true;
    }

    public final void p() {
        d dVarE = e(getHeight(), this.B, getHeight(), getWidth());
        dVarE.f2670e = this.f2580u;
        dVarE.f2671f = f(this.f2566h);
        dVarE.f2672g = this.f2581v;
        dVarE.f2673h = f(this.L);
        dVarE.f2675k = this.V;
        dVarE.f2676l = this.f2585z;
        a aVar = new a(5);
        aVar.f2661b = this;
        VarHandle.storeStoreFence();
        dVarE.f2666a = aVar;
        setState(f.f2686f);
        this.f2574o = this.f2570k;
        dVarE.a();
    }

    public final void q() {
        if (this.S == 0) {
            this.S = getWidth();
        }
        if (!this.T || this.U) {
            this.R = getCompoundPaddingRight() + getCompoundPaddingLeft() + h(getPaint(), this.f2578s);
        } else {
            this.R = getWidth();
        }
        setWidth(this.R);
        setText(this.f2579t);
        s();
        d dVarE = e(this.B, getHeight(), this.R, getHeight());
        dVarE.f2670e = f(this.f2566h);
        dVarE.f2671f = this.f2580u;
        dVarE.f2672g = f(this.L);
        dVarE.f2673h = this.f2582w;
        dVarE.f2675k = this.f2585z;
        dVarE.f2676l = this.V;
        dVarE.f2666a = this.f0;
        setState(f.f2685c);
        this.f2574o = this.f2573n;
        dVarE.a();
    }

    public final void r(f fVar, Drawable drawable) {
        if (drawable == null) {
            return;
        }
        if (fVar != f.f2685c) {
            drawable.setBounds(0, 0, getRight() - getLeft(), getBottom() - getTop());
            return;
        }
        int iAbs = (Math.abs(getWidth() - getHeight()) / 2) + this.A;
        int width = getWidth() - iAbs;
        int i = this.A;
        drawable.setBounds(iAbs, i, width - i, getHeight() - this.A);
    }

    public final float s() {
        setEllipsize(TextUtils.TruncateAt.END);
        setMaxLines(1);
        if (!this.Q || getText() == null) {
            return 0.0f;
        }
        float fH = h(getPaint(), getText().toString());
        int iE = (int) t1.e.e(12.0f, getContext());
        if ((iE * 2) + fH < ((int) t1.e.e(90.0f, getContext()))) {
            setPadding(iE, 0, iE, 0);
            return fH;
        }
        int iE2 = (int) t1.e.e(8.0f, getContext());
        setPadding(iE2, 0, iE2, 0);
        return fH;
    }

    @Override // android.view.View
    public void setBackgroundColor(int i) {
        this.f2560c.getGradientDrawable().setColor(i);
    }

    @SuppressLint({"NewApi"})
    public void setBackgroundCompat(Drawable drawable) {
        setBackground(drawable);
    }

    public void setCanSkipAnim(boolean z10) {
        this.e0 = z10;
    }

    public void setCompleteText(String str) {
        this.f2577r = str;
    }

    public void setErrorText(String str) {
        this.f2578s = str;
    }

    public void setIdleText(String str) {
        this.f2576q = str;
    }

    public void setIndeterminateProgressMode(boolean z10) {
        this.C = z10;
    }

    public void setIndicatorBackgroundColor(int i) {
        if (this.f2582w != i) {
            this.f2582w = i;
        }
    }

    @Override // android.view.View
    public void setPressed(boolean z10) {
        if (z10 && this.f2559b0) {
            return;
        }
        super.setPressed(z10);
    }

    @Deprecated
    public void setProgress(int i) {
        this.f2558a0 = i;
        this.G = true;
        if (this.f2559b0 || getWidth() == 0) {
            return;
        }
        int i3 = this.f2558a0;
        int i10 = this.W;
        f fVar = f.f2686f;
        f fVar2 = f.f2685c;
        if (i3 >= i10) {
            f fVar3 = this.f2575p;
            if (fVar3 == fVar2) {
                n();
                return;
            } else {
                if (fVar3 == fVar) {
                    l();
                    return;
                }
                return;
            }
        }
        f fVar4 = f.f2688h;
        if (i3 <= 0) {
            if (i3 == -1) {
                f fVar5 = this.f2575p;
                if (fVar5 == fVar2) {
                    o();
                    return;
                } else {
                    if (fVar5 == fVar) {
                        m();
                        return;
                    }
                    return;
                }
            }
            if (i3 == 0) {
                f fVar6 = this.f2575p;
                if (fVar6 == f.f2687g) {
                    j();
                    return;
                } else if (fVar6 == fVar2) {
                    p();
                    return;
                } else {
                    if (fVar6 == fVar4) {
                        k();
                        return;
                    }
                    return;
                }
            }
            return;
        }
        f fVar7 = this.f2575p;
        if (fVar7 == fVar || fVar7 == fVar4) {
            q();
            return;
        }
        if (fVar7 == fVar2) {
            ValueAnimator valueAnimator = this.f2561c0;
            if (valueAnimator != null) {
                valueAnimator.cancel();
                this.f2561c0.removeAllUpdateListeners();
                this.f2561c0.removeAllListeners();
            }
            ValueAnimator valueAnimatorOfInt = ValueAnimator.ofInt(this.f2562d0, this.f2558a0);
            this.f2561c0 = valueAnimatorOfInt;
            valueAnimatorOfInt.setDuration(800);
            this.f2561c0.setInterpolator(new AccelerateDecelerateInterpolator());
            ValueAnimator valueAnimator2 = this.f2561c0;
            b bVar = new b(0);
            bVar.f2663b = this;
            VarHandle.storeStoreFence();
            valueAnimator2.addUpdateListener(bVar);
            this.f2561c0.start();
        }
    }

    public void setProgressCenterIcon(Drawable drawable) {
        this.E = drawable;
        this.F = true;
    }

    public void setProgressForState(int i) {
        if (this.f2575p == f.f2685c) {
            this.f2558a0 = i;
            ValueAnimator valueAnimator = this.f2561c0;
            if (valueAnimator != null) {
                valueAnimator.cancel();
                this.f2561c0.removeAllUpdateListeners();
                this.f2561c0.removeAllListeners();
            }
            this.f2562d0 = this.f2558a0;
            invalidate();
        }
    }

    public void setProgressIndicatorColor(int i) {
        this.f2581v = i;
        this.f2563f = null;
        this.f2564g = null;
    }

    public void setProgressStrokeWidth(int i) {
        i();
        if (i <= 0 || this.V == i) {
            return;
        }
        this.V = i;
        CircularAnimatedDrawable circularAnimatedDrawable = this.f2563f;
        if (circularAnimatedDrawable != null) {
            circularAnimatedDrawable.setStrokeWidth(i);
        }
        CircularProgressDrawable circularProgressDrawable = this.f2564g;
        if (circularProgressDrawable != null) {
            circularProgressDrawable.setStrokeWidth(i);
        }
    }

    public void setShowCenterIcon(boolean z10) {
        this.O = z10;
        this.F = true;
    }

    public void setStrokeColor(int i) {
        this.f2560c.setStrokeColor(i);
    }

    /* JADX WARN: Removed duplicated region for block: B:26:0x00ae  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x00d0  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void t(com.stepos.common.widget.f r21, boolean r22) {
        /*
            Method dump skipped, instructions count: 561
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.common.widget.CircularProgressButton.t(com.stepos.common.widget.f, boolean):void");
    }

    @Override // android.widget.TextView, android.view.View
    public final boolean verifyDrawable(Drawable drawable) {
        return drawable == this.f2563f || drawable == this.f2573n || drawable == this.f2570k || drawable == this.f2572m || drawable == this.f2571l || super.verifyDrawable(drawable);
    }

    public CircularProgressButton(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, R.attr.StepOSCommon_CircularProgressButton);
    }

    public CircularProgressButton(Context context) {
        this(context, null);
    }
}
