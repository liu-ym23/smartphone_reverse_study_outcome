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
import com.stepos.alphame.R;
import com.stepos.alphame.utils.Property;
import com.stepos.common.drawble.CircularAnimatedDrawable;
import com.stepos.common.drawble.CircularProgressDrawable;
import com.stepos.common.drawble.StrokeGradientDrawable;
import i2.AbstractC0620a;

/* loaded from: classes.dex */
public class CircularProgressButton extends Button {

    /* renamed from: A, reason: collision with root package name */
    public Drawable f11448A;

    /* renamed from: B, reason: collision with root package name */
    public boolean f11449B;

    /* renamed from: C, reason: collision with root package name */
    public boolean f11450C;

    /* renamed from: D, reason: collision with root package name */
    public C0490f f11451D;

    /* renamed from: E, reason: collision with root package name */
    public final ColorStateList f11452E;

    /* renamed from: F, reason: collision with root package name */
    public final ColorStateList f11453F;

    /* renamed from: G, reason: collision with root package name */
    public final ColorStateList f11454G;

    /* renamed from: H, reason: collision with root package name */
    public final ColorStateList f11455H;

    /* renamed from: I, reason: collision with root package name */
    public final ColorStateList f11456I;

    /* renamed from: J, reason: collision with root package name */
    public final ColorStateList f11457J;

    /* renamed from: K, reason: collision with root package name */
    public boolean f11458K;

    /* renamed from: L, reason: collision with root package name */
    public boolean f11459L;

    /* renamed from: M, reason: collision with root package name */
    public final boolean f11460M;

    /* renamed from: N, reason: collision with root package name */
    public int f11461N;

    /* renamed from: O, reason: collision with root package name */
    public int f11462O;

    /* renamed from: P, reason: collision with root package name */
    public boolean f11463P;

    /* renamed from: Q, reason: collision with root package name */
    public boolean f11464Q;

    /* renamed from: R, reason: collision with root package name */
    public int f11465R;

    /* renamed from: S, reason: collision with root package name */
    public final int f11466S;
    public int T;

    /* renamed from: U, reason: collision with root package name */
    public boolean f11467U;

    /* renamed from: V, reason: collision with root package name */
    public ValueAnimator f11468V;

    /* renamed from: W, reason: collision with root package name */
    public int f11469W;

    /* renamed from: a, reason: collision with root package name */
    public final StrokeGradientDrawable f11470a;

    /* renamed from: b, reason: collision with root package name */
    public CircularAnimatedDrawable f11471b;

    /* renamed from: c, reason: collision with root package name */
    public CircularProgressDrawable f11472c;

    /* renamed from: d, reason: collision with root package name */
    public final ColorStateList f11473d;

    /* renamed from: e, reason: collision with root package name */
    public final ColorStateList f11474e;

    /* renamed from: f, reason: collision with root package name */
    public final ColorStateList f11475f;

    /* renamed from: g, reason: collision with root package name */
    public final StateListDrawable f11476g;

    /* renamed from: h, reason: collision with root package name */
    public final StateListDrawable f11477h;

    /* renamed from: i, reason: collision with root package name */
    public final StateListDrawable f11478i;

    /* renamed from: j, reason: collision with root package name */
    public StateListDrawable f11479j;

    /* renamed from: k, reason: collision with root package name */
    public StateListDrawable f11480k;

    /* renamed from: k0, reason: collision with root package name */
    public boolean f11481k0;

    /* renamed from: l, reason: collision with root package name */
    public EnumC0493i f11482l;

    /* renamed from: l0, reason: collision with root package name */
    public final C0488d f11483l0;

    /* renamed from: m, reason: collision with root package name */
    public String f11484m;

    /* renamed from: m0, reason: collision with root package name */
    public final C0488d f11485m0;

    /* renamed from: n, reason: collision with root package name */
    public String f11486n;

    /* renamed from: n0, reason: collision with root package name */
    public final C0488d f11487n0;

    /* renamed from: o, reason: collision with root package name */
    public String f11488o;

    /* renamed from: o0, reason: collision with root package name */
    public final C0488d f11489o0;

    /* renamed from: p, reason: collision with root package name */
    public final String f11490p;

    /* renamed from: q, reason: collision with root package name */
    public final int f11491q;

    /* renamed from: r, reason: collision with root package name */
    public int f11492r;

    /* renamed from: s, reason: collision with root package name */
    public int f11493s;

    /* renamed from: t, reason: collision with root package name */
    public final int f11494t;

    /* renamed from: u, reason: collision with root package name */
    public final int f11495u;

    /* renamed from: v, reason: collision with root package name */
    public final int f11496v;

    /* renamed from: w, reason: collision with root package name */
    public final int f11497w;

    /* renamed from: x, reason: collision with root package name */
    public final float f11498x;

    /* renamed from: y, reason: collision with root package name */
    public boolean f11499y;

    /* renamed from: z, reason: collision with root package name */
    public boolean f11500z;

    public static class SavedState extends View.BaseSavedState {
        public static final Parcelable.Creator<SavedState> CREATOR = new C0492h();

        /* renamed from: a, reason: collision with root package name */
        public boolean f11501a;

        /* renamed from: b, reason: collision with root package name */
        public boolean f11502b;

        /* renamed from: c, reason: collision with root package name */
        public int f11503c;

        @Override // android.view.View.BaseSavedState, android.view.AbsSavedState, android.os.Parcelable
        public final void writeToParcel(Parcel parcel, int i4) {
            super.writeToParcel(parcel, i4);
            parcel.writeInt(this.f11503c);
            parcel.writeInt(this.f11501a ? 1 : 0);
            parcel.writeInt(this.f11502b ? 1 : 0);
        }
    }

    public CircularProgressButton(Context context, AttributeSet attributeSet) {
        super(context, attributeSet, R.attr.StepOSCommon_CircularProgressButton);
        this.f11450C = true;
        this.f11458K = false;
        this.f11459L = false;
        this.f11460M = true;
        this.f11462O = 0;
        this.f11463P = true;
        this.T = 0;
        this.f11483l0 = new C0488d(this, 0);
        this.f11485m0 = new C0488d(this, 1);
        this.f11487n0 = new C0488d(this, 2);
        this.f11489o0 = new C0488d(this, 4);
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, AbstractC0620a.f13019a, R.attr.StepOSCommon_CircularProgressButton, 0);
        if (typedArrayObtainStyledAttributes != null) {
            int dimensionPixelSize = typedArrayObtainStyledAttributes.getDimensionPixelSize(14, (int) getContext().getResources().getDimension(R.dimen.mc_cir_progress_button_stroke_width));
            this.f11496v = dimensionPixelSize;
            this.f11465R = dimensionPixelSize;
            this.f11484m = typedArrayObtainStyledAttributes.getString(20);
            this.f11486n = typedArrayObtainStyledAttributes.getString(18);
            this.f11488o = typedArrayObtainStyledAttributes.getString(19);
            this.f11490p = typedArrayObtainStyledAttributes.getString(21);
            this.f11494t = typedArrayObtainStyledAttributes.getResourceId(5, 0);
            this.f11495u = typedArrayObtainStyledAttributes.getResourceId(6, 0);
            this.f11498x = typedArrayObtainStyledAttributes.getDimension(4, Property.DEFAULT_FLOAT_VALUE);
            this.f11497w = typedArrayObtainStyledAttributes.getDimensionPixelSize(7, 0);
            int resourceId = typedArrayObtainStyledAttributes.getResourceId(10, R.color.mc_cir_progress_button_red);
            this.f11473d = getResources().getColorStateList(resourceId);
            this.f11455H = getResources().getColorStateList(typedArrayObtainStyledAttributes.getResourceId(13, resourceId));
            int resourceId2 = typedArrayObtainStyledAttributes.getResourceId(8, R.color.mc_cir_progress_button_green);
            this.f11474e = getResources().getColorStateList(resourceId2);
            this.f11456I = getResources().getColorStateList(typedArrayObtainStyledAttributes.getResourceId(11, resourceId2));
            int resourceId3 = typedArrayObtainStyledAttributes.getResourceId(9, R.color.mc_cir_progress_button_red);
            this.f11475f = getResources().getColorStateList(resourceId3);
            this.f11457J = getResources().getColorStateList(typedArrayObtainStyledAttributes.getResourceId(12, resourceId3));
            this.f11491q = typedArrayObtainStyledAttributes.getColor(3, getResources().getColor(R.color.mc_cir_progress_button_white));
            this.f11492r = typedArrayObtainStyledAttributes.getColor(1, getResources().getColor(R.color.mc_cir_progress_button_red));
            this.f11493s = typedArrayObtainStyledAttributes.getColor(2, getResources().getColor(R.color.mc_cir_progress_button_blank));
            ColorStateList colorStateList = typedArrayObtainStyledAttributes.getColorStateList(16);
            this.f11454G = colorStateList;
            if (colorStateList == null) {
                this.f11454G = getTextColors();
            }
            ColorStateList colorStateList2 = typedArrayObtainStyledAttributes.getColorStateList(17);
            this.f11452E = colorStateList2;
            if (colorStateList2 == null) {
                this.f11452E = getTextColors();
            }
            ColorStateList colorStateList3 = typedArrayObtainStyledAttributes.getColorStateList(15);
            this.f11453F = colorStateList3;
            if (colorStateList3 == null) {
                this.f11453F = getTextColors();
            }
            this.f11460M = typedArrayObtainStyledAttributes.getBoolean(0, true);
            typedArrayObtainStyledAttributes.recycle();
        }
        this.f11466S = 100;
        this.f11482l = EnumC0493i.f11912b;
        setText(this.f11484m);
        s();
        int iF = f(this.f11473d);
        int iG = g(this.f11473d);
        int colorForState = this.f11473d.getColorForState(new int[]{android.R.attr.state_focused}, 0);
        int colorForState2 = this.f11473d.getColorForState(new int[]{-16842910}, 0);
        int iF2 = f(this.f11455H);
        int iG2 = g(this.f11455H);
        int colorForState3 = this.f11455H.getColorForState(new int[]{android.R.attr.state_focused}, 0);
        int colorForState4 = this.f11455H.getColorForState(new int[]{-16842910}, 0);
        if (this.f11470a == null) {
            this.f11470a = c(iF, iF2);
        }
        StrokeGradientDrawable strokeGradientDrawableC = c(colorForState2, colorForState4);
        StrokeGradientDrawable strokeGradientDrawableC2 = c(colorForState, colorForState3);
        StrokeGradientDrawable strokeGradientDrawableC3 = c(iG, iG2);
        if (this.f11476g == null) {
            StateListDrawable stateListDrawable = new StateListDrawable();
            this.f11476g = stateListDrawable;
            stateListDrawable.setCallback(this);
        }
        this.f11476g.addState(new int[]{android.R.attr.state_pressed}, strokeGradientDrawableC3.getGradientDrawable());
        this.f11476g.addState(new int[]{android.R.attr.state_focused}, strokeGradientDrawableC2.getGradientDrawable());
        this.f11476g.addState(new int[]{-16842910}, strokeGradientDrawableC.getGradientDrawable());
        StateListDrawable stateListDrawable2 = this.f11476g;
        int[] iArr = StateSet.WILD_CARD;
        stateListDrawable2.addState(iArr, this.f11470a.getGradientDrawable());
        this.f11476g.setBounds(0, 0, getRight() - getLeft(), getBottom() - getTop());
        StrokeGradientDrawable strokeGradientDrawableC4 = c(g(this.f11474e), g(this.f11456I));
        if (this.f11477h == null) {
            StateListDrawable stateListDrawable3 = new StateListDrawable();
            this.f11477h = stateListDrawable3;
            stateListDrawable3.setCallback(this);
        }
        this.f11477h.addState(new int[]{android.R.attr.state_pressed}, strokeGradientDrawableC4.getGradientDrawable());
        this.f11477h.addState(iArr, this.f11470a.getGradientDrawable());
        this.f11477h.setBounds(0, 0, getRight() - getLeft(), getBottom() - getTop());
        i();
        StrokeGradientDrawable strokeGradientDrawableC5 = c(g(this.f11475f), g(this.f11457J));
        if (this.f11478i == null) {
            StateListDrawable stateListDrawable4 = new StateListDrawable();
            this.f11478i = stateListDrawable4;
            stateListDrawable4.setCallback(this);
        }
        this.f11478i.addState(new int[]{android.R.attr.state_pressed}, strokeGradientDrawableC5.getGradientDrawable());
        this.f11478i.addState(iArr, this.f11470a.getGradientDrawable());
        this.f11478i.setBounds(0, 0, getRight() - getLeft(), getBottom() - getTop());
        this.f11480k = this.f11476g;
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

    private void setBackgroundFromState(EnumC0493i enumC0493i) {
        int iOrdinal = enumC0493i.ordinal();
        if (iOrdinal == 0) {
            this.f11480k = this.f11479j;
            return;
        }
        if (iOrdinal == 1) {
            this.f11480k = this.f11476g;
        } else if (iOrdinal == 2) {
            this.f11480k = this.f11477h;
        } else {
            if (iOrdinal != 3) {
                return;
            }
            this.f11480k = this.f11478i;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setIcon(int i4) throws Resources.NotFoundException {
        Drawable drawable = getResources().getDrawable(i4);
        if (drawable != null) {
            int width = (getWidth() / 2) - (drawable.getIntrinsicWidth() / 2);
            setCompoundDrawablesWithIntrinsicBounds(i4, 0, 0, 0);
            setPadding(width, 0, 0, 0);
        }
    }

    private void setState(EnumC0493i enumC0493i) {
        if (this.f11482l != enumC0493i) {
            this.f11482l = enumC0493i;
        }
    }

    private void setTextForState(EnumC0493i enumC0493i) {
        int iOrdinal = enumC0493i.ordinal();
        if (iOrdinal == 1) {
            setText(this.f11484m);
            s();
        } else if (iOrdinal == 2) {
            setText(this.f11486n);
            s();
        } else {
            if (iOrdinal != 3) {
                return;
            }
            setText(this.f11488o);
            s();
        }
    }

    public final StrokeGradientDrawable c(int i4, int i5) {
        GradientDrawable gradientDrawable = (GradientDrawable) getResources().getDrawable(R.drawable.mc_cir_pro_btn_background).mutate();
        gradientDrawable.setColor(i4);
        gradientDrawable.setCornerRadius(this.f11498x);
        StrokeGradientDrawable strokeGradientDrawable = new StrokeGradientDrawable(gradientDrawable);
        strokeGradientDrawable.setStrokeColor(i5);
        return strokeGradientDrawable;
    }

    public final C0490f d() {
        this.f11467U = true;
        setClickable(false);
        C0490f c0490f = new C0490f(this, this, this.f11470a);
        this.f11451D = c0490f;
        float f4 = this.f11498x;
        c0490f.f11902i = f4;
        c0490f.f11903j = f4;
        c0490f.f11896c = getWidth();
        this.f11451D.f11897d = getWidth();
        if (this.f11500z || !this.f11450C) {
            this.f11451D.f11895b = 1;
        } else {
            this.f11451D.f11895b = 240;
        }
        this.f11500z = false;
        return this.f11451D;
    }

    @Override // android.view.View
    public final void draw(Canvas canvas) {
        StateListDrawable stateListDrawable;
        if (this.f11459L || !this.f11467U) {
            this.f11459L = false;
            r(EnumC0493i.f11912b, this.f11476g);
            r(EnumC0493i.f11913c, this.f11477h);
            r(EnumC0493i.f11914d, this.f11478i);
            r(this.f11482l, this.f11470a.getGradientDrawable());
        }
        if (this.f11467U && isPressed()) {
            super.draw(canvas);
            return;
        }
        if (this.f11480k != null) {
            if ((getScrollX() | getScrollY()) == 0) {
                int iOrdinal = this.f11482l.ordinal();
                if (iOrdinal == 0) {
                    StateListDrawable stateListDrawable2 = this.f11479j;
                    if (stateListDrawable2 != null) {
                        stateListDrawable2.draw(canvas);
                    }
                } else if (iOrdinal == 1) {
                    StateListDrawable stateListDrawable3 = this.f11476g;
                    if (stateListDrawable3 != null) {
                        stateListDrawable3.draw(canvas);
                    }
                } else if (iOrdinal == 2) {
                    StateListDrawable stateListDrawable4 = this.f11477h;
                    if (stateListDrawable4 != null) {
                        stateListDrawable4.draw(canvas);
                    }
                } else if (iOrdinal == 3 && (stateListDrawable = this.f11478i) != null) {
                    stateListDrawable.draw(canvas);
                }
            } else {
                canvas.translate(getScrollX(), getScrollY());
                this.f11480k.draw(canvas);
                canvas.translate(-getScrollX(), -getScrollY());
            }
        }
        super.draw(canvas);
    }

    @Override // android.widget.TextView, android.view.View
    public final void drawableStateChanged() {
        Rect rect;
        if (this.f11467U) {
            rect = new Rect();
            rect.set(this.f11470a.getGradientDrawable().getBounds());
        } else {
            rect = null;
        }
        StateListDrawable stateListDrawable = this.f11476g;
        int[] drawableState = getDrawableState();
        if (stateListDrawable != null) {
            stateListDrawable.setState(drawableState);
        }
        StateListDrawable stateListDrawable2 = this.f11477h;
        int[] drawableState2 = getDrawableState();
        if (stateListDrawable2 != null) {
            stateListDrawable2.setState(drawableState2);
        }
        StateListDrawable stateListDrawable3 = this.f11478i;
        int[] drawableState3 = getDrawableState();
        if (stateListDrawable3 != null) {
            stateListDrawable3.setState(drawableState3);
        }
        StateListDrawable stateListDrawable4 = this.f11479j;
        int[] drawableState4 = getDrawableState();
        if (stateListDrawable4 != null) {
            stateListDrawable4.setState(drawableState4);
        }
        if (this.f11467U && rect != null) {
            this.f11470a.getGradientDrawable().setBounds(rect);
        }
        super.drawableStateChanged();
    }

    public final C0490f e(float f4, float f5, int i4, int i5) {
        this.f11467U = true;
        setClickable(false);
        C0490f c0490f = new C0490f(this, this, this.f11470a);
        this.f11451D = c0490f;
        c0490f.f11902i = f4;
        c0490f.f11903j = f5;
        c0490f.f11906m = this.f11497w;
        c0490f.f11896c = i4;
        c0490f.f11897d = i5;
        if (this.f11500z || !this.f11450C) {
            c0490f.f11895b = 1;
        } else {
            c0490f.f11895b = 240;
        }
        this.f11500z = false;
        return c0490f;
    }

    public String getCompleteText() {
        return this.f11486n;
    }

    public String getErrorText() {
        return this.f11488o;
    }

    public String getIdleText() {
        return this.f11484m;
    }

    public int getProgress() {
        return this.T;
    }

    public EnumC0493i getState() {
        return this.f11482l;
    }

    public final int h(TextPaint textPaint, String str) {
        TransformationMethod transformationMethod = getTransformationMethod();
        if (transformationMethod != null) {
            str = transformationMethod.getTransformation(str, this).toString();
        }
        return (int) textPaint.measureText(str);
    }

    public final void i() {
        if (this.f11479j == null) {
            StateListDrawable stateListDrawable = new StateListDrawable();
            this.f11479j = stateListDrawable;
            stateListDrawable.setCallback(this);
        }
        this.f11479j.addState(StateSet.WILD_CARD, this.f11470a.getGradientDrawable());
        int iAbs = (Math.abs(getWidth() - getHeight()) / 2) + this.f11497w;
        int width = getWidth() - iAbs;
        int i4 = this.f11497w;
        this.f11479j.setBounds(iAbs, i4, width - i4, getHeight() - this.f11497w);
    }

    public final void j() {
        C0490f c0490fD = d();
        c0490fD.f11898e = f(this.f11474e);
        c0490fD.f11899f = f(this.f11473d);
        c0490fD.f11900g = f(this.f11456I);
        c0490fD.f11901h = f(this.f11455H);
        c0490fD.f11894a = this.f11487n0;
        setState(EnumC0493i.f11912b);
        this.f11480k = this.f11476g;
        c0490fD.a();
    }

    public final void k() {
        C0490f c0490fD = d();
        c0490fD.f11898e = f(this.f11475f);
        c0490fD.f11899f = f(this.f11473d);
        c0490fD.f11900g = f(this.f11457J);
        c0490fD.f11901h = f(this.f11455H);
        c0490fD.f11894a = this.f11487n0;
        setState(EnumC0493i.f11912b);
        this.f11480k = this.f11476g;
        c0490fD.a();
    }

    public final void l() {
        C0490f c0490fD = d();
        c0490fD.f11898e = f(this.f11473d);
        c0490fD.f11900g = f(this.f11455H);
        c0490fD.f11899f = f(this.f11474e);
        c0490fD.f11901h = f(this.f11456I);
        c0490fD.f11894a = this.f11485m0;
        setState(EnumC0493i.f11913c);
        this.f11480k = this.f11477h;
        c0490fD.a();
    }

    public final void m() {
        C0490f c0490fD = d();
        c0490fD.f11898e = f(this.f11473d);
        c0490fD.f11899f = f(this.f11475f);
        c0490fD.f11900g = f(this.f11455H);
        c0490fD.f11901h = f(this.f11457J);
        c0490fD.f11894a = this.f11489o0;
        setState(EnumC0493i.f11914d);
        this.f11480k = this.f11478i;
        c0490fD.a();
    }

    public final void n() {
        C0490f c0490fE = e(getHeight(), this.f11498x, getHeight(), getWidth());
        c0490fE.f11898e = this.f11491q;
        c0490fE.f11900g = this.f11492r;
        c0490fE.f11901h = f(this.f11456I);
        c0490fE.f11899f = f(this.f11474e);
        c0490fE.f11904k = this.f11465R;
        c0490fE.f11905l = this.f11496v;
        c0490fE.f11894a = this.f11485m0;
        setState(EnumC0493i.f11913c);
        this.f11480k = this.f11477h;
        c0490fE.a();
    }

    public final void o() {
        C0490f c0490fE = e(getHeight(), this.f11498x, getHeight(), getWidth());
        c0490fE.f11898e = this.f11491q;
        c0490fE.f11899f = f(this.f11475f);
        c0490fE.f11900g = this.f11492r;
        c0490fE.f11901h = f(this.f11457J);
        c0490fE.f11904k = this.f11465R;
        c0490fE.f11905l = this.f11496v;
        c0490fE.f11894a = this.f11489o0;
        setState(EnumC0493i.f11914d);
        this.f11480k = this.f11478i;
        c0490fE.a();
    }

    @Override // android.view.View
    public final void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        C0490f c0490f = this.f11451D;
        if (c0490f != null) {
            c0490f.f11909p.end();
            c0490f.f11909p.removeAllListeners();
        }
    }

    @Override // android.widget.TextView, android.view.View
    public final void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (this.f11482l != EnumC0493i.f11911a || this.f11467U) {
            CircularAnimatedDrawable circularAnimatedDrawable = this.f11471b;
            if (circularAnimatedDrawable != null) {
                circularAnimatedDrawable.setAllowLoading(false);
                return;
            }
            return;
        }
        if (this.f11499y) {
            CircularAnimatedDrawable circularAnimatedDrawable2 = this.f11471b;
            if (circularAnimatedDrawable2 != null) {
                circularAnimatedDrawable2.setAllowLoading(true);
                this.f11471b.draw(canvas);
                return;
            }
            int width = (getWidth() - getHeight()) / 2;
            this.f11471b = new CircularAnimatedDrawable(this.f11492r, this.f11465R);
            int i4 = this.f11497w + width;
            int width2 = (getWidth() - width) - this.f11497w;
            int height = getHeight();
            int i5 = this.f11497w;
            this.f11471b.setBounds(i4, i5, width2, height - i5);
            this.f11471b.setCallback(this);
            this.f11471b.start();
            return;
        }
        if (this.f11472c == null) {
            int width3 = (getWidth() - getHeight()) / 2;
            this.f11472c = new CircularProgressDrawable(getHeight() - (this.f11497w * 2), this.f11465R, this.f11492r);
            int i6 = width3 + this.f11497w;
            float f4 = this.f11497w;
            this.f11472c.setOffset(((getWidth() - getHeight()) / 2.0f) + f4, f4);
            CircularProgressDrawable circularProgressDrawable = this.f11472c;
            int i7 = this.f11497w;
            circularProgressDrawable.setBounds(i6, i7, i6, i7);
        }
        if (this.f11449B) {
            this.f11449B = false;
            this.f11472c.setCenterIcon(this.f11448A);
            if (this.f11448A == null) {
                this.f11472c.setShowCenterIcon(this.f11458K);
            }
        }
        this.f11472c.setStartAngle(-90.0f);
        this.f11472c.setSweepAngle((360.0f / this.f11466S) * this.f11469W);
        this.f11472c.draw(canvas);
    }

    @Override // android.view.View
    public final void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo accessibilityNodeInfo) {
        super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
        accessibilityNodeInfo.setClassName(CircularProgressButton.class.getName());
    }

    @Override // android.widget.TextView, android.view.View
    public final void onLayout(boolean z4, int i4, int i5, int i6, int i7) {
        super.onLayout(z4, i4, i5, i6, i7);
        if (z4) {
            t(this.f11482l, false);
        }
    }

    @Override // android.widget.TextView, android.view.View
    public final void onRestoreInstanceState(Parcelable parcelable) {
        if (!(parcelable instanceof SavedState)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        SavedState savedState = (SavedState) parcelable;
        this.T = savedState.f11503c;
        this.f11499y = savedState.f11501a;
        this.f11500z = savedState.f11502b;
        super.onRestoreInstanceState(savedState.getSuperState());
        setProgress(this.T);
    }

    @Override // android.widget.TextView, android.view.View
    public final Parcelable onSaveInstanceState() {
        SavedState savedState = new SavedState(super.onSaveInstanceState());
        savedState.f11503c = this.T;
        savedState.f11501a = this.f11499y;
        savedState.f11502b = true;
        return savedState;
    }

    @Override // android.view.View
    public final void onSizeChanged(int i4, int i5, int i6, int i7) {
        super.onSizeChanged(i4, i5, i6, i7);
        this.f11471b = null;
        this.f11472c = null;
        this.f11449B = true;
        this.f11459L = true;
    }

    public final void p() {
        C0490f c0490fE = e(getHeight(), this.f11498x, getHeight(), getWidth());
        c0490fE.f11898e = this.f11491q;
        c0490fE.f11899f = f(this.f11473d);
        c0490fE.f11900g = this.f11492r;
        c0490fE.f11901h = f(this.f11455H);
        c0490fE.f11904k = this.f11465R;
        c0490fE.f11905l = this.f11496v;
        c0490fE.f11894a = new C0488d(this, 5);
        setState(EnumC0493i.f11912b);
        this.f11480k = this.f11476g;
        c0490fE.a();
    }

    public final void q() {
        if (this.f11462O == 0) {
            this.f11462O = getWidth();
        }
        if (!this.f11463P || this.f11464Q) {
            this.f11461N = getCompoundPaddingRight() + getCompoundPaddingLeft() + h(getPaint(), this.f11488o);
        } else {
            this.f11461N = getWidth();
        }
        setWidth(this.f11461N);
        setText(this.f11490p);
        s();
        C0490f c0490fE = e(this.f11498x, getHeight(), this.f11461N, getHeight());
        c0490fE.f11898e = f(this.f11473d);
        c0490fE.f11899f = this.f11491q;
        c0490fE.f11900g = f(this.f11455H);
        c0490fE.f11901h = this.f11493s;
        c0490fE.f11904k = this.f11496v;
        c0490fE.f11905l = this.f11465R;
        c0490fE.f11894a = this.f11483l0;
        setState(EnumC0493i.f11911a);
        this.f11480k = this.f11479j;
        c0490fE.a();
    }

    public final void r(EnumC0493i enumC0493i, Drawable drawable) {
        if (drawable == null) {
            return;
        }
        if (enumC0493i != EnumC0493i.f11911a) {
            drawable.setBounds(0, 0, getRight() - getLeft(), getBottom() - getTop());
            return;
        }
        int iAbs = (Math.abs(getWidth() - getHeight()) / 2) + this.f11497w;
        int width = getWidth() - iAbs;
        int i4 = this.f11497w;
        drawable.setBounds(iAbs, i4, width - i4, getHeight() - this.f11497w);
    }

    public final float s() {
        setEllipsize(TextUtils.TruncateAt.END);
        setMaxLines(1);
        if (!this.f11460M || getText() == null) {
            return Property.DEFAULT_FLOAT_VALUE;
        }
        float fH = h(getPaint(), getText().toString());
        int iC = (int) m2.o.c(getContext(), 12.0f);
        if ((iC * 2) + fH < ((int) m2.o.c(getContext(), 90.0f))) {
            setPadding(iC, 0, iC, 0);
            return fH;
        }
        int iC2 = (int) m2.o.c(getContext(), 8.0f);
        setPadding(iC2, 0, iC2, 0);
        return fH;
    }

    @Override // android.view.View
    public void setBackgroundColor(int i4) {
        this.f11470a.getGradientDrawable().setColor(i4);
    }

    @SuppressLint({"NewApi"})
    public void setBackgroundCompat(Drawable drawable) {
        setBackground(drawable);
    }

    public void setCanSkipAnim(boolean z4) {
        this.f11481k0 = z4;
    }

    public void setCompleteText(String str) {
        this.f11486n = str;
    }

    public void setErrorText(String str) {
        this.f11488o = str;
    }

    public void setIdleText(String str) {
        this.f11484m = str;
    }

    public void setIndeterminateProgressMode(boolean z4) {
        this.f11499y = z4;
    }

    public void setIndicatorBackgroundColor(int i4) {
        if (this.f11493s != i4) {
            this.f11493s = i4;
        }
    }

    @Override // android.view.View
    public void setPressed(boolean z4) {
        if (z4 && this.f11467U) {
            return;
        }
        super.setPressed(z4);
    }

    @Deprecated
    public void setProgress(int i4) {
        this.T = i4;
        this.f11450C = true;
        if (this.f11467U || getWidth() == 0) {
            return;
        }
        int i5 = this.T;
        int i6 = this.f11466S;
        EnumC0493i enumC0493i = EnumC0493i.f11912b;
        EnumC0493i enumC0493i2 = EnumC0493i.f11911a;
        if (i5 >= i6) {
            EnumC0493i enumC0493i3 = this.f11482l;
            if (enumC0493i3 == enumC0493i2) {
                n();
                return;
            } else {
                if (enumC0493i3 == enumC0493i) {
                    l();
                    return;
                }
                return;
            }
        }
        EnumC0493i enumC0493i4 = EnumC0493i.f11914d;
        if (i5 > 0) {
            EnumC0493i enumC0493i5 = this.f11482l;
            if (enumC0493i5 == enumC0493i || enumC0493i5 == enumC0493i4) {
                q();
                return;
            }
            if (enumC0493i5 == enumC0493i2) {
                ValueAnimator valueAnimator = this.f11468V;
                if (valueAnimator != null) {
                    valueAnimator.cancel();
                    this.f11468V.removeAllUpdateListeners();
                    this.f11468V.removeAllListeners();
                }
                ValueAnimator valueAnimatorOfInt = ValueAnimator.ofInt(this.f11469W, this.T);
                this.f11468V = valueAnimatorOfInt;
                valueAnimatorOfInt.setDuration(800);
                this.f11468V.setInterpolator(new AccelerateDecelerateInterpolator());
                this.f11468V.addUpdateListener(new com.airbnb.lottie.q(3, this));
                this.f11468V.start();
                return;
            }
            return;
        }
        if (i5 == -1) {
            EnumC0493i enumC0493i6 = this.f11482l;
            if (enumC0493i6 == enumC0493i2) {
                o();
                return;
            } else {
                if (enumC0493i6 == enumC0493i) {
                    m();
                    return;
                }
                return;
            }
        }
        if (i5 == 0) {
            EnumC0493i enumC0493i7 = this.f11482l;
            if (enumC0493i7 == EnumC0493i.f11913c) {
                j();
            } else if (enumC0493i7 == enumC0493i2) {
                p();
            } else if (enumC0493i7 == enumC0493i4) {
                k();
            }
        }
    }

    public void setProgressCenterIcon(Drawable drawable) {
        this.f11448A = drawable;
        this.f11449B = true;
    }

    public void setProgressForState(int i4) {
        if (this.f11482l == EnumC0493i.f11911a) {
            this.T = i4;
            ValueAnimator valueAnimator = this.f11468V;
            if (valueAnimator != null) {
                valueAnimator.cancel();
                this.f11468V.removeAllUpdateListeners();
                this.f11468V.removeAllListeners();
            }
            this.f11469W = this.T;
            invalidate();
        }
    }

    public void setProgressIndicatorColor(int i4) {
        this.f11492r = i4;
        this.f11471b = null;
        this.f11472c = null;
    }

    public void setProgressStrokeWidth(int i4) {
        i();
        if (i4 <= 0 || this.f11465R == i4) {
            return;
        }
        this.f11465R = i4;
        CircularAnimatedDrawable circularAnimatedDrawable = this.f11471b;
        if (circularAnimatedDrawable != null) {
            circularAnimatedDrawable.setStrokeWidth(i4);
        }
        CircularProgressDrawable circularProgressDrawable = this.f11472c;
        if (circularProgressDrawable != null) {
            circularProgressDrawable.setStrokeWidth(i4);
        }
    }

    public void setShowCenterIcon(boolean z4) {
        this.f11458K = z4;
        this.f11449B = true;
    }

    public void setStrokeColor(int i4) {
        this.f11470a.setStrokeColor(i4);
    }

    /* JADX WARN: Removed duplicated region for block: B:27:0x00ab  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x00cc  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void t(com.stepos.common.widget.EnumC0493i r19, boolean r20) {
        /*
            Method dump skipped, instructions count: 550
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.common.widget.CircularProgressButton.t(com.stepos.common.widget.i, boolean):void");
    }

    @Override // android.widget.TextView, android.view.View
    public final boolean verifyDrawable(Drawable drawable) {
        return drawable == this.f11471b || drawable == this.f11479j || drawable == this.f11476g || drawable == this.f11478i || drawable == this.f11477h || super.verifyDrawable(drawable);
    }
}
