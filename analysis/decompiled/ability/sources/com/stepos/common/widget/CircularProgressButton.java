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
import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextPaint;
import android.text.TextUtils;
import android.text.method.TransformationMethod;
import android.util.AttributeSet;
import android.util.StateSet;
import android.view.View;
import android.view.accessibility.AccessibilityNodeInfo;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.Interpolator;
import android.view.animation.PathInterpolator;
import android.widget.Button;
import com.stepos.ability.R;
import com.stepos.common.drawble.CircularAnimatedDrawable;
import com.stepos.common.drawble.CircularProgressDrawable;
import com.stepos.common.drawble.StrokeGradientDrawable;

/* loaded from: classes3.dex */
public class CircularProgressButton extends Button {

    /* renamed from: A, reason: collision with root package name */
    public Drawable f3624A;

    /* renamed from: B, reason: collision with root package name */
    public boolean f3625B;

    /* renamed from: C, reason: collision with root package name */
    public boolean f3626C;

    /* renamed from: D, reason: collision with root package name */
    public C1104i f3627D;
    public final ColorStateList E;

    /* renamed from: F, reason: collision with root package name */
    public final ColorStateList f3628F;

    /* renamed from: G, reason: collision with root package name */
    public final ColorStateList f3629G;

    /* renamed from: L, reason: collision with root package name */
    public final ColorStateList f3630L;

    /* renamed from: M, reason: collision with root package name */
    public final ColorStateList f3631M;

    /* renamed from: N, reason: collision with root package name */
    public final ColorStateList f3632N;

    /* renamed from: O, reason: collision with root package name */
    public boolean f3633O;

    /* renamed from: P, reason: collision with root package name */
    public boolean f3634P;

    /* renamed from: Q, reason: collision with root package name */
    public final boolean f3635Q;

    /* renamed from: R, reason: collision with root package name */
    public int f3636R;

    /* renamed from: S, reason: collision with root package name */
    public int f3637S;

    /* renamed from: T, reason: collision with root package name */
    public boolean f3638T;

    /* renamed from: U, reason: collision with root package name */
    public boolean f3639U;

    /* renamed from: V, reason: collision with root package name */
    public int f3640V;

    /* renamed from: W, reason: collision with root package name */
    public final int f3641W;

    /* renamed from: a, reason: collision with root package name */
    public final StrokeGradientDrawable f3642a;

    /* renamed from: a0, reason: collision with root package name */
    public int f3643a0;
    public CircularAnimatedDrawable b;
    public boolean b0;
    public CircularProgressDrawable c;

    /* renamed from: c0, reason: collision with root package name */
    public ValueAnimator f3644c0;
    public final ColorStateList d;

    /* renamed from: d0, reason: collision with root package name */
    public int f3645d0;
    public final ColorStateList e;

    /* renamed from: e0, reason: collision with root package name */
    public boolean f3646e0;
    public final ColorStateList f;

    /* renamed from: f0, reason: collision with root package name */
    public final C1100e f3647f0;
    public final StateListDrawable g;

    /* renamed from: g0, reason: collision with root package name */
    public final C1101f f3648g0;
    public final StateListDrawable h;

    /* renamed from: h0, reason: collision with root package name */
    public final C1101f f3649h0;
    public final StateListDrawable i;

    /* renamed from: i0, reason: collision with root package name */
    public final C1101f f3650i0;

    /* renamed from: j, reason: collision with root package name */
    public StateListDrawable f3651j;
    public StateListDrawable k;
    public State l;
    public String m;
    public String n;
    public String o;
    public final String p;

    /* renamed from: q, reason: collision with root package name */
    public final int f3652q;

    /* renamed from: r, reason: collision with root package name */
    public int f3653r;

    /* renamed from: s, reason: collision with root package name */
    public int f3654s;

    /* renamed from: t, reason: collision with root package name */
    public final int f3655t;
    public final int u;

    /* renamed from: v, reason: collision with root package name */
    public final int f3656v;

    /* renamed from: w, reason: collision with root package name */
    public final int f3657w;

    /* renamed from: x, reason: collision with root package name */
    public final float f3658x;
    public boolean y;

    /* renamed from: z, reason: collision with root package name */
    public boolean f3659z;

    public static class SavedState extends View.BaseSavedState {
        public static final Parcelable.Creator<SavedState> CREATOR = new C1106k();
        private boolean mConfigurationChanged;
        private boolean mIndeterminateProgressMode;
        private int mProgress;

        public /* synthetic */ SavedState(Parcel parcel, C1100e c1100e) {
            this(parcel);
        }

        @Override // android.view.View.BaseSavedState, android.view.AbsSavedState, android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
            parcel.writeInt(this.mProgress);
            parcel.writeInt(this.mIndeterminateProgressMode ? 1 : 0);
            parcel.writeInt(this.mConfigurationChanged ? 1 : 0);
        }

        public SavedState(Parcelable parcelable) {
            super(parcelable);
        }

        private SavedState(Parcel parcel) {
            super(parcel);
            this.mProgress = parcel.readInt();
            this.mIndeterminateProgressMode = parcel.readInt() == 1;
            this.mConfigurationChanged = parcel.readInt() == 1;
        }
    }

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    public static final class State {

        /* renamed from: a, reason: collision with root package name */
        public static final State f3660a;
        public static final State b;
        public static final State c;
        public static final State d;
        public static final /* synthetic */ State[] e;

        static {
            State state = new State("PROGRESS", 0);
            f3660a = state;
            State state2 = new State("IDLE", 1);
            b = state2;
            State state3 = new State("COMPLETE", 2);
            c = state3;
            State state4 = new State("ERROR", 3);
            d = state4;
            e = new State[]{state, state2, state3, state4};
        }

        public static State valueOf(String str) {
            return (State) Enum.valueOf(State.class, str);
        }

        public static State[] values() {
            return (State[]) e.clone();
        }
    }

    public CircularProgressButton(Context context, AttributeSet attributeSet) {
        super(context, attributeSet, R.attr.StepOSCommon_CircularProgressButton);
        this.f3626C = true;
        this.f3633O = false;
        this.f3634P = false;
        this.f3635Q = true;
        this.f3637S = 0;
        this.f3638T = true;
        this.f3643a0 = 0;
        this.f3647f0 = new C1100e(this);
        this.f3648g0 = new C1101f(this, 0);
        this.f3649h0 = new C1101f(this, 1);
        this.f3650i0 = new C1101f(this, 3);
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, V4.s.f1371a, R.attr.StepOSCommon_CircularProgressButton, 0);
        if (typedArrayObtainStyledAttributes != null) {
            int dimensionPixelSize = typedArrayObtainStyledAttributes.getDimensionPixelSize(14, (int) getContext().getResources().getDimension(R.dimen.mc_cir_progress_button_stroke_width));
            this.f3656v = dimensionPixelSize;
            this.f3640V = dimensionPixelSize;
            this.m = typedArrayObtainStyledAttributes.getString(20);
            this.n = typedArrayObtainStyledAttributes.getString(18);
            this.o = typedArrayObtainStyledAttributes.getString(19);
            this.p = typedArrayObtainStyledAttributes.getString(21);
            this.f3655t = typedArrayObtainStyledAttributes.getResourceId(5, 0);
            this.u = typedArrayObtainStyledAttributes.getResourceId(6, 0);
            this.f3658x = typedArrayObtainStyledAttributes.getDimension(4, 0.0f);
            this.f3657w = typedArrayObtainStyledAttributes.getDimensionPixelSize(7, 0);
            int resourceId = typedArrayObtainStyledAttributes.getResourceId(10, R.color.mc_cir_progress_button_red);
            this.d = getResources().getColorStateList(resourceId);
            this.f3630L = getResources().getColorStateList(typedArrayObtainStyledAttributes.getResourceId(13, resourceId));
            int resourceId2 = typedArrayObtainStyledAttributes.getResourceId(8, R.color.mc_cir_progress_button_green);
            this.e = getResources().getColorStateList(resourceId2);
            this.f3631M = getResources().getColorStateList(typedArrayObtainStyledAttributes.getResourceId(11, resourceId2));
            int resourceId3 = typedArrayObtainStyledAttributes.getResourceId(9, R.color.mc_cir_progress_button_red);
            this.f = getResources().getColorStateList(resourceId3);
            this.f3632N = getResources().getColorStateList(typedArrayObtainStyledAttributes.getResourceId(12, resourceId3));
            this.f3652q = typedArrayObtainStyledAttributes.getColor(3, getResources().getColor(R.color.mc_cir_progress_button_white));
            this.f3653r = typedArrayObtainStyledAttributes.getColor(1, getResources().getColor(R.color.mc_cir_progress_button_red));
            this.f3654s = typedArrayObtainStyledAttributes.getColor(2, getResources().getColor(R.color.mc_cir_progress_button_blank));
            ColorStateList colorStateList = typedArrayObtainStyledAttributes.getColorStateList(16);
            this.f3629G = colorStateList;
            if (colorStateList == null) {
                this.f3629G = getTextColors();
            }
            ColorStateList colorStateList2 = typedArrayObtainStyledAttributes.getColorStateList(17);
            this.E = colorStateList2;
            if (colorStateList2 == null) {
                this.E = getTextColors();
            }
            ColorStateList colorStateList3 = typedArrayObtainStyledAttributes.getColorStateList(15);
            this.f3628F = colorStateList3;
            if (colorStateList3 == null) {
                this.f3628F = getTextColors();
            }
            this.f3635Q = typedArrayObtainStyledAttributes.getBoolean(0, true);
            typedArrayObtainStyledAttributes.recycle();
        }
        this.f3641W = 100;
        this.l = State.b;
        setText(this.m);
        s();
        int iF = f(this.d);
        int iG = g(this.d);
        int colorForState = this.d.getColorForState(new int[]{android.R.attr.state_focused}, 0);
        int colorForState2 = this.d.getColorForState(new int[]{-16842910}, 0);
        int iF2 = f(this.f3630L);
        int iG2 = g(this.f3630L);
        int colorForState3 = this.f3630L.getColorForState(new int[]{android.R.attr.state_focused}, 0);
        int colorForState4 = this.f3630L.getColorForState(new int[]{-16842910}, 0);
        if (this.f3642a == null) {
            this.f3642a = c(iF, iF2);
        }
        StrokeGradientDrawable strokeGradientDrawableC = c(colorForState2, colorForState4);
        StrokeGradientDrawable strokeGradientDrawableC2 = c(colorForState, colorForState3);
        StrokeGradientDrawable strokeGradientDrawableC3 = c(iG, iG2);
        if (this.g == null) {
            StateListDrawable stateListDrawable = new StateListDrawable();
            this.g = stateListDrawable;
            stateListDrawable.setCallback(this);
        }
        this.g.addState(new int[]{android.R.attr.state_pressed}, strokeGradientDrawableC3.getGradientDrawable());
        this.g.addState(new int[]{android.R.attr.state_focused}, strokeGradientDrawableC2.getGradientDrawable());
        this.g.addState(new int[]{-16842910}, strokeGradientDrawableC.getGradientDrawable());
        StateListDrawable stateListDrawable2 = this.g;
        int[] iArr = StateSet.WILD_CARD;
        stateListDrawable2.addState(iArr, this.f3642a.getGradientDrawable());
        this.g.setBounds(0, 0, getRight() - getLeft(), getBottom() - getTop());
        StrokeGradientDrawable strokeGradientDrawableC4 = c(g(this.e), g(this.f3631M));
        if (this.h == null) {
            StateListDrawable stateListDrawable3 = new StateListDrawable();
            this.h = stateListDrawable3;
            stateListDrawable3.setCallback(this);
        }
        this.h.addState(new int[]{android.R.attr.state_pressed}, strokeGradientDrawableC4.getGradientDrawable());
        this.h.addState(iArr, this.f3642a.getGradientDrawable());
        this.h.setBounds(0, 0, getRight() - getLeft(), getBottom() - getTop());
        i();
        StrokeGradientDrawable strokeGradientDrawableC5 = c(g(this.f), g(this.f3632N));
        if (this.i == null) {
            StateListDrawable stateListDrawable4 = new StateListDrawable();
            this.i = stateListDrawable4;
            stateListDrawable4.setCallback(this);
        }
        this.i.addState(new int[]{android.R.attr.state_pressed}, strokeGradientDrawableC5.getGradientDrawable());
        this.i.addState(iArr, this.f3642a.getGradientDrawable());
        this.i.setBounds(0, 0, getRight() - getLeft(), getBottom() - getTop());
        this.k = this.g;
        setBackgroundCompat(null);
        new com.stepos.common.animator.m().a(this, false);
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

    private void setBackgroundFromState(State state) {
        int iOrdinal = state.ordinal();
        if (iOrdinal == 0) {
            this.k = this.f3651j;
            return;
        }
        if (iOrdinal == 1) {
            this.k = this.g;
        } else if (iOrdinal == 2) {
            this.k = this.h;
        } else {
            if (iOrdinal != 3) {
                return;
            }
            this.k = this.i;
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

    private void setState(State state) {
        if (this.l != state) {
            this.l = state;
        }
    }

    private void setTextForState(State state) {
        int iOrdinal = state.ordinal();
        if (iOrdinal == 1) {
            setText(this.m);
            s();
        } else if (iOrdinal == 2) {
            setText(this.n);
            s();
        } else {
            if (iOrdinal != 3) {
                return;
            }
            setText(this.o);
            s();
        }
    }

    public final StrokeGradientDrawable c(int i, int i6) {
        GradientDrawable gradientDrawable = (GradientDrawable) getResources().getDrawable(R.drawable.mc_cir_pro_btn_background).mutate();
        gradientDrawable.setColor(i);
        gradientDrawable.setCornerRadius(this.f3658x);
        StrokeGradientDrawable strokeGradientDrawable = new StrokeGradientDrawable(gradientDrawable);
        strokeGradientDrawable.setStrokeColor(i6);
        return strokeGradientDrawable;
    }

    public final C1104i d() {
        this.b0 = true;
        setClickable(false);
        C1104i c1104i = new C1104i(this, this, this.f3642a);
        this.f3627D = c1104i;
        float f = this.f3658x;
        c1104i.i = f;
        c1104i.f3806j = f;
        c1104i.c = getWidth();
        this.f3627D.d = getWidth();
        if (this.f3659z || !this.f3626C) {
            this.f3627D.b = 1;
        } else {
            this.f3627D.b = 240;
        }
        this.f3659z = false;
        return this.f3627D;
    }

    @Override // android.view.View
    public final void draw(Canvas canvas) {
        StateListDrawable stateListDrawable;
        if (this.f3634P || !this.b0) {
            this.f3634P = false;
            r(State.b, this.g);
            r(State.c, this.h);
            r(State.d, this.i);
            r(this.l, this.f3642a.getGradientDrawable());
        }
        if (this.b0 && isPressed()) {
            super.draw(canvas);
            return;
        }
        if (this.k != null) {
            if ((getScrollX() | getScrollY()) == 0) {
                int iOrdinal = this.l.ordinal();
                if (iOrdinal == 0) {
                    StateListDrawable stateListDrawable2 = this.f3651j;
                    if (stateListDrawable2 != null) {
                        stateListDrawable2.draw(canvas);
                    }
                } else if (iOrdinal == 1) {
                    StateListDrawable stateListDrawable3 = this.g;
                    if (stateListDrawable3 != null) {
                        stateListDrawable3.draw(canvas);
                    }
                } else if (iOrdinal == 2) {
                    StateListDrawable stateListDrawable4 = this.h;
                    if (stateListDrawable4 != null) {
                        stateListDrawable4.draw(canvas);
                    }
                } else if (iOrdinal == 3 && (stateListDrawable = this.i) != null) {
                    stateListDrawable.draw(canvas);
                }
            } else {
                canvas.translate(getScrollX(), getScrollY());
                this.k.draw(canvas);
                canvas.translate(-getScrollX(), -getScrollY());
            }
        }
        super.draw(canvas);
    }

    @Override // android.widget.TextView, android.view.View
    public final void drawableStateChanged() {
        Rect rect;
        if (this.b0) {
            rect = new Rect();
            rect.set(this.f3642a.getGradientDrawable().getBounds());
        } else {
            rect = null;
        }
        int[] drawableState = getDrawableState();
        StateListDrawable stateListDrawable = this.g;
        if (stateListDrawable != null) {
            stateListDrawable.setState(drawableState);
        }
        int[] drawableState2 = getDrawableState();
        StateListDrawable stateListDrawable2 = this.h;
        if (stateListDrawable2 != null) {
            stateListDrawable2.setState(drawableState2);
        }
        int[] drawableState3 = getDrawableState();
        StateListDrawable stateListDrawable3 = this.i;
        if (stateListDrawable3 != null) {
            stateListDrawable3.setState(drawableState3);
        }
        StateListDrawable stateListDrawable4 = this.f3651j;
        int[] drawableState4 = getDrawableState();
        if (stateListDrawable4 != null) {
            stateListDrawable4.setState(drawableState4);
        }
        if (this.b0 && rect != null) {
            this.f3642a.getGradientDrawable().setBounds(rect);
        }
        super.drawableStateChanged();
    }

    public final C1104i e(float f, float f7, int i, int i6) {
        this.b0 = true;
        setClickable(false);
        C1104i c1104i = new C1104i(this, this, this.f3642a);
        this.f3627D = c1104i;
        c1104i.i = f;
        c1104i.f3806j = f7;
        c1104i.m = this.f3657w;
        c1104i.c = i;
        c1104i.d = i6;
        if (this.f3659z || !this.f3626C) {
            c1104i.b = 1;
        } else {
            c1104i.b = 240;
        }
        this.f3659z = false;
        return c1104i;
    }

    public String getCompleteText() {
        return this.n;
    }

    public String getErrorText() {
        return this.o;
    }

    public String getIdleText() {
        return this.m;
    }

    public int getProgress() {
        return this.f3643a0;
    }

    public State getState() {
        return this.l;
    }

    public final int h(TextPaint textPaint, String str) {
        TransformationMethod transformationMethod = getTransformationMethod();
        if (transformationMethod != null) {
            str = transformationMethod.getTransformation(str, this).toString();
        }
        return (int) textPaint.measureText(str);
    }

    public final void i() {
        if (this.f3651j == null) {
            StateListDrawable stateListDrawable = new StateListDrawable();
            this.f3651j = stateListDrawable;
            stateListDrawable.setCallback(this);
        }
        this.f3651j.addState(StateSet.WILD_CARD, this.f3642a.getGradientDrawable());
        int iAbs = (Math.abs(getWidth() - getHeight()) / 2) + this.f3657w;
        int width = getWidth() - iAbs;
        int i = this.f3657w;
        this.f3651j.setBounds(iAbs, i, width - i, getHeight() - this.f3657w);
    }

    public final void j() {
        C1104i c1104iD = d();
        c1104iD.e = f(this.e);
        c1104iD.f = f(this.d);
        c1104iD.g = f(this.f3631M);
        c1104iD.h = f(this.f3630L);
        c1104iD.f3805a = this.f3649h0;
        setState(State.b);
        this.k = this.g;
        c1104iD.a();
    }

    public final void k() {
        C1104i c1104iD = d();
        c1104iD.e = f(this.f);
        c1104iD.f = f(this.d);
        c1104iD.g = f(this.f3632N);
        c1104iD.h = f(this.f3630L);
        c1104iD.f3805a = this.f3649h0;
        setState(State.b);
        this.k = this.g;
        c1104iD.a();
    }

    public final void l() {
        C1104i c1104iD = d();
        c1104iD.e = f(this.d);
        c1104iD.g = f(this.f3630L);
        c1104iD.f = f(this.e);
        c1104iD.h = f(this.f3631M);
        c1104iD.f3805a = this.f3648g0;
        setState(State.c);
        this.k = this.h;
        c1104iD.a();
    }

    public final void m() {
        C1104i c1104iD = d();
        c1104iD.e = f(this.d);
        c1104iD.f = f(this.f);
        c1104iD.g = f(this.f3630L);
        c1104iD.h = f(this.f3632N);
        c1104iD.f3805a = this.f3650i0;
        setState(State.d);
        this.k = this.i;
        c1104iD.a();
    }

    public final void n() {
        C1104i c1104iE = e(getHeight(), this.f3658x, getHeight(), getWidth());
        c1104iE.e = this.f3652q;
        c1104iE.g = this.f3653r;
        c1104iE.h = f(this.f3631M);
        c1104iE.f = f(this.e);
        c1104iE.k = this.f3640V;
        c1104iE.l = this.f3656v;
        c1104iE.f3805a = this.f3648g0;
        setState(State.c);
        this.k = this.h;
        c1104iE.a();
    }

    public final void o() {
        C1104i c1104iE = e(getHeight(), this.f3658x, getHeight(), getWidth());
        c1104iE.e = this.f3652q;
        c1104iE.f = f(this.f);
        c1104iE.g = this.f3653r;
        c1104iE.h = f(this.f3632N);
        c1104iE.k = this.f3640V;
        c1104iE.l = this.f3656v;
        c1104iE.f3805a = this.f3650i0;
        setState(State.d);
        this.k = this.i;
        c1104iE.a();
    }

    @Override // android.view.View
    public final void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        C1104i c1104i = this.f3627D;
        if (c1104i != null) {
            c1104i.p.end();
            c1104i.p.removeAllListeners();
        }
    }

    @Override // android.widget.TextView, android.view.View
    public final void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (this.l != State.f3660a || this.b0) {
            CircularAnimatedDrawable circularAnimatedDrawable = this.b;
            if (circularAnimatedDrawable != null) {
                circularAnimatedDrawable.setAllowLoading(false);
                return;
            }
            return;
        }
        if (this.y) {
            CircularAnimatedDrawable circularAnimatedDrawable2 = this.b;
            if (circularAnimatedDrawable2 != null) {
                circularAnimatedDrawable2.setAllowLoading(true);
                this.b.draw(canvas);
                return;
            }
            int width = (getWidth() - getHeight()) / 2;
            this.b = new CircularAnimatedDrawable(this.f3653r, this.f3640V);
            int i = this.f3657w + width;
            int width2 = (getWidth() - width) - this.f3657w;
            int height = getHeight();
            int i6 = this.f3657w;
            this.b.setBounds(i, i6, width2, height - i6);
            this.b.setCallback(this);
            this.b.start();
            return;
        }
        if (this.c == null) {
            int width3 = (getWidth() - getHeight()) / 2;
            this.c = new CircularProgressDrawable(getHeight() - (this.f3657w * 2), this.f3640V, this.f3653r);
            int i10 = width3 + this.f3657w;
            float f = this.f3657w;
            this.c.setOffset(((getWidth() - getHeight()) / 2.0f) + f, f);
            CircularProgressDrawable circularProgressDrawable = this.c;
            int i11 = this.f3657w;
            circularProgressDrawable.setBounds(i10, i11, i10, i11);
        }
        if (this.f3625B) {
            this.f3625B = false;
            this.c.setCenterIcon(this.f3624A);
            if (this.f3624A == null) {
                this.c.setShowCenterIcon(this.f3633O);
            }
        }
        this.c.setStartAngle(-90.0f);
        this.c.setSweepAngle((360.0f / this.f3641W) * this.f3645d0);
        this.c.draw(canvas);
    }

    @Override // android.view.View
    public final void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo accessibilityNodeInfo) {
        super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
        accessibilityNodeInfo.setClassName(CircularProgressButton.class.getName());
    }

    @Override // android.widget.TextView, android.view.View
    public final void onLayout(boolean z10, int i, int i6, int i10, int i11) {
        super.onLayout(z10, i, i6, i10, i11);
        if (z10) {
            t(this.l, false);
        }
    }

    @Override // android.widget.TextView, android.view.View
    public final void onRestoreInstanceState(Parcelable parcelable) {
        if (!(parcelable instanceof SavedState)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        SavedState savedState = (SavedState) parcelable;
        this.f3643a0 = savedState.mProgress;
        this.y = savedState.mIndeterminateProgressMode;
        this.f3659z = savedState.mConfigurationChanged;
        super.onRestoreInstanceState(savedState.getSuperState());
        setProgress(this.f3643a0);
    }

    @Override // android.widget.TextView, android.view.View
    public final Parcelable onSaveInstanceState() {
        SavedState savedState = new SavedState(super.onSaveInstanceState());
        savedState.mProgress = this.f3643a0;
        savedState.mIndeterminateProgressMode = this.y;
        savedState.mConfigurationChanged = true;
        return savedState;
    }

    @Override // android.view.View
    public final void onSizeChanged(int i, int i6, int i10, int i11) {
        super.onSizeChanged(i, i6, i10, i11);
        this.b = null;
        this.c = null;
        this.f3625B = true;
        this.f3634P = true;
    }

    public final void p() {
        C1104i c1104iE = e(getHeight(), this.f3658x, getHeight(), getWidth());
        c1104iE.e = this.f3652q;
        c1104iE.f = f(this.d);
        c1104iE.g = this.f3653r;
        c1104iE.h = f(this.f3630L);
        c1104iE.k = this.f3640V;
        c1104iE.l = this.f3656v;
        c1104iE.f3805a = new C1101f(this, 4);
        setState(State.b);
        this.k = this.g;
        c1104iE.a();
    }

    public final void q() {
        if (this.f3637S == 0) {
            this.f3637S = getWidth();
        }
        if (!this.f3638T || this.f3639U) {
            this.f3636R = getCompoundPaddingRight() + getCompoundPaddingLeft() + h(getPaint(), this.o);
        } else {
            this.f3636R = getWidth();
        }
        setWidth(this.f3636R);
        setText(this.p);
        s();
        C1104i c1104iE = e(this.f3658x, getHeight(), this.f3636R, getHeight());
        c1104iE.e = f(this.d);
        c1104iE.f = this.f3652q;
        c1104iE.g = f(this.f3630L);
        c1104iE.h = this.f3654s;
        c1104iE.k = this.f3656v;
        c1104iE.l = this.f3640V;
        c1104iE.f3805a = this.f3647f0;
        setState(State.f3660a);
        this.k = this.f3651j;
        c1104iE.a();
    }

    public final void r(State state, Drawable drawable) {
        if (drawable == null) {
            return;
        }
        if (state != State.f3660a) {
            drawable.setBounds(0, 0, getRight() - getLeft(), getBottom() - getTop());
            return;
        }
        int iAbs = (Math.abs(getWidth() - getHeight()) / 2) + this.f3657w;
        int width = getWidth() - iAbs;
        int i = this.f3657w;
        drawable.setBounds(iAbs, i, width - i, getHeight() - this.f3657w);
    }

    public final float s() {
        setEllipsize(TextUtils.TruncateAt.END);
        setMaxLines(1);
        if (!this.f3635Q || getText() == null) {
            return 0.0f;
        }
        float fH = h(getPaint(), getText().toString());
        int iC = (int) a5.l.c(12.0f, getContext());
        if ((iC * 2) + fH < ((int) a5.l.c(90.0f, getContext()))) {
            setPadding(iC, 0, iC, 0);
            return fH;
        }
        int iC2 = (int) a5.l.c(8.0f, getContext());
        setPadding(iC2, 0, iC2, 0);
        return fH;
    }

    @Override // android.view.View
    public void setBackgroundColor(int i) {
        this.f3642a.getGradientDrawable().setColor(i);
    }

    @SuppressLint({"NewApi"})
    public void setBackgroundCompat(Drawable drawable) {
        setBackground(drawable);
    }

    public void setCanSkipAnim(boolean z10) {
        this.f3646e0 = z10;
    }

    public void setCompleteText(String str) {
        this.n = str;
    }

    public void setErrorText(String str) {
        this.o = str;
    }

    public void setIdleText(String str) {
        this.m = str;
    }

    public void setIndeterminateProgressMode(boolean z10) {
        this.y = z10;
    }

    public void setIndicatorBackgroundColor(int i) {
        if (this.f3654s != i) {
            this.f3654s = i;
        }
    }

    @Override // android.view.View
    public void setPressed(boolean z10) {
        if (z10 && this.b0) {
            return;
        }
        super.setPressed(z10);
    }

    @Deprecated
    public void setProgress(int i) {
        this.f3643a0 = i;
        this.f3626C = true;
        if (this.b0 || getWidth() == 0) {
            return;
        }
        int i6 = this.f3643a0;
        int i10 = this.f3641W;
        State state = State.b;
        State state2 = State.f3660a;
        if (i6 >= i10) {
            State state3 = this.l;
            if (state3 == state2) {
                n();
                return;
            } else {
                if (state3 == state) {
                    l();
                    return;
                }
                return;
            }
        }
        State state4 = State.d;
        if (i6 > 0) {
            State state5 = this.l;
            if (state5 == state || state5 == state4) {
                q();
                return;
            }
            if (state5 == state2) {
                ValueAnimator valueAnimator = this.f3644c0;
                if (valueAnimator != null) {
                    valueAnimator.cancel();
                    this.f3644c0.removeAllUpdateListeners();
                    this.f3644c0.removeAllListeners();
                }
                ValueAnimator valueAnimatorOfInt = ValueAnimator.ofInt(this.f3645d0, this.f3643a0);
                this.f3644c0 = valueAnimatorOfInt;
                valueAnimatorOfInt.setDuration(800);
                this.f3644c0.setInterpolator(new AccelerateDecelerateInterpolator());
                this.f3644c0.addUpdateListener(new J4.c(this, 4));
                this.f3644c0.start();
                return;
            }
            return;
        }
        if (i6 == -1) {
            State state6 = this.l;
            if (state6 == state2) {
                o();
                return;
            } else {
                if (state6 == state) {
                    m();
                    return;
                }
                return;
            }
        }
        if (i6 == 0) {
            State state7 = this.l;
            if (state7 == State.c) {
                j();
            } else if (state7 == state2) {
                p();
            } else if (state7 == state4) {
                k();
            }
        }
    }

    public void setProgressCenterIcon(Drawable drawable) {
        this.f3624A = drawable;
        this.f3625B = true;
    }

    public void setProgressForState(int i) {
        if (this.l == State.f3660a) {
            this.f3643a0 = i;
            ValueAnimator valueAnimator = this.f3644c0;
            if (valueAnimator != null) {
                valueAnimator.cancel();
                this.f3644c0.removeAllUpdateListeners();
                this.f3644c0.removeAllListeners();
            }
            this.f3645d0 = this.f3643a0;
            invalidate();
        }
    }

    public void setProgressIndicatorColor(int i) {
        this.f3653r = i;
        this.b = null;
        this.c = null;
    }

    public void setProgressStrokeWidth(int i) {
        i();
        if (i <= 0 || this.f3640V == i) {
            return;
        }
        this.f3640V = i;
        CircularAnimatedDrawable circularAnimatedDrawable = this.b;
        if (circularAnimatedDrawable != null) {
            circularAnimatedDrawable.setStrokeWidth(i);
        }
        CircularProgressDrawable circularProgressDrawable = this.c;
        if (circularProgressDrawable != null) {
            circularProgressDrawable.setStrokeWidth(i);
        }
    }

    public void setShowCenterIcon(boolean z10) {
        this.f3633O = z10;
        this.f3625B = true;
    }

    public void setStrokeColor(int i) {
        this.f3642a.setStrokeColor(i);
    }

    /* JADX WARN: Removed duplicated region for block: B:26:0x00ae  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x00d0  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void t(com.stepos.common.widget.CircularProgressButton.State r21, boolean r22) {
        /*
            Method dump skipped, instructions count: 546
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.common.widget.CircularProgressButton.t(com.stepos.common.widget.CircularProgressButton$State, boolean):void");
    }

    @Override // android.widget.TextView, android.view.View
    public final boolean verifyDrawable(Drawable drawable) {
        return drawable == this.b || drawable == this.f3651j || drawable == this.g || drawable == this.i || drawable == this.h || super.verifyDrawable(drawable);
    }
}
