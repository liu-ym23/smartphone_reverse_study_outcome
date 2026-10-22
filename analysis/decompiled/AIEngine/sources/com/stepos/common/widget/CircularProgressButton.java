package com.stepos.common.widget;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ArgbEvaluator;
import android.animation.ObjectAnimator;
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
import com.stepos.aiengine.R;
import com.stepos.common.drawble.CircularAnimatedDrawable;
import com.stepos.common.drawble.CircularProgressDrawable;
import com.stepos.common.drawble.StrokeGradientDrawable;
import com.stepos.core.common.notification.LiveNotification;
import com.stepos.core.common.runtime.EngineRuntimeConfig;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public class CircularProgressButton extends Button {
    public final float A;
    public boolean B;
    public boolean C;
    public Drawable D;
    public boolean E;
    public boolean F;
    public f G;
    public final ColorStateList H;
    public final ColorStateList I;
    public final ColorStateList J;
    public final ColorStateList K;
    public final ColorStateList L;
    public final ColorStateList M;
    public boolean N;
    public boolean O;
    public final boolean P;
    public int Q;
    public int R;
    public boolean S;
    public boolean T;
    public int U;
    public final int V;
    public int W;

    /* renamed from: a, reason: collision with root package name */
    public final StrokeGradientDrawable f6776a;

    /* renamed from: a0, reason: collision with root package name */
    public boolean f6777a0;

    /* renamed from: b, reason: collision with root package name */
    public CircularAnimatedDrawable f6778b;
    public ValueAnimator b0;

    /* renamed from: c, reason: collision with root package name */
    public CircularProgressDrawable f6779c;
    public int c0;

    /* renamed from: d, reason: collision with root package name */
    public final ColorStateList f6780d;

    /* renamed from: d0, reason: collision with root package name */
    public boolean f6781d0;

    /* renamed from: e, reason: collision with root package name */
    public final ColorStateList f6782e;

    /* renamed from: e0, reason: collision with root package name */
    public final a f6783e0;

    /* renamed from: f0, reason: collision with root package name */
    public final b f6784f0;

    /* renamed from: g0, reason: collision with root package name */
    public final c f6785g0;
    public final ColorStateList h;

    /* renamed from: h0, reason: collision with root package name */
    public final d f6786h0;

    /* renamed from: j, reason: collision with root package name */
    public final StateListDrawable f6787j;

    /* renamed from: k, reason: collision with root package name */
    public final StateListDrawable f6788k;

    /* renamed from: l, reason: collision with root package name */
    public final StateListDrawable f6789l;

    /* renamed from: m, reason: collision with root package name */
    public StateListDrawable f6790m;

    /* renamed from: n, reason: collision with root package name */
    public StateListDrawable f6791n;

    /* renamed from: o, reason: collision with root package name */
    public State f6792o;

    /* renamed from: p, reason: collision with root package name */
    public String f6793p;

    /* renamed from: q, reason: collision with root package name */
    public String f6794q;
    public String r;

    /* renamed from: s, reason: collision with root package name */
    public final String f6795s;

    /* renamed from: t, reason: collision with root package name */
    public final int f6796t;

    /* renamed from: u, reason: collision with root package name */
    public int f6797u;

    /* renamed from: v, reason: collision with root package name */
    public int f6798v;

    /* renamed from: w, reason: collision with root package name */
    public final int f6799w;

    /* renamed from: x, reason: collision with root package name */
    public final int f6800x;

    /* renamed from: y, reason: collision with root package name */
    public final int f6801y;
    public final int z;

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public static class SavedState extends View.BaseSavedState {
        public static final Parcelable.Creator<SavedState> CREATOR = new a();
        private boolean mConfigurationChanged;
        private boolean mIndeterminateProgressMode;
        private int mProgress;

        /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
        public class a implements Parcelable.Creator<SavedState> {
            @Override // android.os.Parcelable.Creator
            public final SavedState createFromParcel(Parcel parcel) {
                return new SavedState(parcel, null);
            }

            @Override // android.os.Parcelable.Creator
            public final SavedState[] newArray(int i10) {
                return new SavedState[i10];
            }
        }

        public /* synthetic */ SavedState(Parcel parcel, a aVar) {
            this(parcel);
        }

        @Override // android.view.View.BaseSavedState, android.view.AbsSavedState, android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i10) {
            super.writeToParcel(parcel, i10);
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
    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public static final class State {

        /* renamed from: a, reason: collision with root package name */
        public static final State f6802a;

        /* renamed from: b, reason: collision with root package name */
        public static final State f6803b;

        /* renamed from: c, reason: collision with root package name */
        public static final State f6804c;

        /* renamed from: d, reason: collision with root package name */
        public static final State f6805d;

        /* renamed from: e, reason: collision with root package name */
        public static final /* synthetic */ State[] f6806e;

        static {
            State state = new State(LiveNotification.EVENT_PROGRESS, 0);
            f6802a = state;
            State state2 = new State("IDLE", 1);
            f6803b = state2;
            State state3 = new State("COMPLETE", 2);
            f6804c = state3;
            State state4 = new State("ERROR", 3);
            f6805d = state4;
            f6806e = new State[]{state, state2, state3, state4};
        }

        public State() {
            throw null;
        }

        public static State valueOf(String str) {
            return (State) Enum.valueOf(State.class, str);
        }

        public static State[] values() {
            return (State[]) f6806e.clone();
        }
    }

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public class a implements g {
        public a() {
        }

        @Override // com.stepos.common.widget.CircularProgressButton.g
        public final void a() {
            CircularProgressButton circularProgressButton = CircularProgressButton.this;
            circularProgressButton.f6777a0 = false;
            circularProgressButton.setClickable(true);
            circularProgressButton.setText((CharSequence) null);
            circularProgressButton.requestLayout();
        }
    }

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public class b implements g {
        public b() {
        }

        @Override // com.stepos.common.widget.CircularProgressButton.g
        public final void a() throws Resources.NotFoundException {
            CircularProgressButton circularProgressButton = CircularProgressButton.this;
            if (circularProgressButton.f6799w != 0) {
                circularProgressButton.setText((CharSequence) null);
                circularProgressButton.setIcon(circularProgressButton.f6799w);
            } else {
                circularProgressButton.setText(circularProgressButton.f6794q);
            }
            circularProgressButton.s();
            circularProgressButton.f6777a0 = false;
            circularProgressButton.setClickable(true);
            circularProgressButton.setTextColor(circularProgressButton.I);
        }
    }

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public class c implements g {
        public c() {
        }

        @Override // com.stepos.common.widget.CircularProgressButton.g
        public final void a() {
            CircularProgressButton circularProgressButton = CircularProgressButton.this;
            circularProgressButton.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, 0);
            circularProgressButton.setPadding(0, 0, 0, 0);
            circularProgressButton.setText(circularProgressButton.f6793p);
            circularProgressButton.s();
            circularProgressButton.f6777a0 = false;
            circularProgressButton.setClickable(true);
            circularProgressButton.setTextColor(circularProgressButton.H);
        }
    }

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public class d implements g {
        public d() {
        }

        @Override // com.stepos.common.widget.CircularProgressButton.g
        public final void a() throws Resources.NotFoundException {
            CircularProgressButton circularProgressButton = CircularProgressButton.this;
            if (circularProgressButton.f6800x != 0) {
                circularProgressButton.setText((CharSequence) null);
                circularProgressButton.setIcon(circularProgressButton.f6800x);
            } else {
                circularProgressButton.setText(circularProgressButton.r);
            }
            circularProgressButton.f6777a0 = false;
            circularProgressButton.setClickable(true);
            circularProgressButton.setTextColor(circularProgressButton.J);
        }
    }

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public class e implements g {
        public e() {
        }

        @Override // com.stepos.common.widget.CircularProgressButton.g
        public final void a() {
            CircularProgressButton circularProgressButton = CircularProgressButton.this;
            circularProgressButton.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, 0);
            circularProgressButton.setPadding(0, 0, 0, 0);
            circularProgressButton.setText(circularProgressButton.f6793p);
            circularProgressButton.s();
            circularProgressButton.f6777a0 = false;
            circularProgressButton.setClickable(true);
        }
    }

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public interface g {
        void a();
    }

    public CircularProgressButton(Context context, AttributeSet attributeSet) {
        super(context, attributeSet, R.attr.StepOSCommon_CircularProgressButton);
        this.F = true;
        this.N = false;
        this.O = false;
        this.P = true;
        this.R = 0;
        this.S = true;
        this.W = 0;
        this.f6783e0 = new a();
        this.f6784f0 = new b();
        this.f6785g0 = new c();
        this.f6786h0 = new d();
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, g8.a.f9075a, R.attr.StepOSCommon_CircularProgressButton, 0);
        if (typedArrayObtainStyledAttributes != null) {
            int dimensionPixelSize = typedArrayObtainStyledAttributes.getDimensionPixelSize(14, (int) getContext().getResources().getDimension(R.dimen.mc_cir_progress_button_stroke_width));
            this.f6801y = dimensionPixelSize;
            this.U = dimensionPixelSize;
            this.f6793p = typedArrayObtainStyledAttributes.getString(20);
            this.f6794q = typedArrayObtainStyledAttributes.getString(18);
            this.r = typedArrayObtainStyledAttributes.getString(19);
            this.f6795s = typedArrayObtainStyledAttributes.getString(21);
            this.f6799w = typedArrayObtainStyledAttributes.getResourceId(5, 0);
            this.f6800x = typedArrayObtainStyledAttributes.getResourceId(6, 0);
            this.A = typedArrayObtainStyledAttributes.getDimension(4, 0.0f);
            this.z = typedArrayObtainStyledAttributes.getDimensionPixelSize(7, 0);
            int resourceId = typedArrayObtainStyledAttributes.getResourceId(10, R.color.mc_cir_progress_button_red);
            this.f6780d = getResources().getColorStateList(resourceId);
            this.K = getResources().getColorStateList(typedArrayObtainStyledAttributes.getResourceId(13, resourceId));
            int resourceId2 = typedArrayObtainStyledAttributes.getResourceId(8, R.color.mc_cir_progress_button_green);
            this.f6782e = getResources().getColorStateList(resourceId2);
            this.L = getResources().getColorStateList(typedArrayObtainStyledAttributes.getResourceId(11, resourceId2));
            int resourceId3 = typedArrayObtainStyledAttributes.getResourceId(9, R.color.mc_cir_progress_button_red);
            this.h = getResources().getColorStateList(resourceId3);
            this.M = getResources().getColorStateList(typedArrayObtainStyledAttributes.getResourceId(12, resourceId3));
            this.f6796t = typedArrayObtainStyledAttributes.getColor(3, getResources().getColor(R.color.mc_cir_progress_button_white));
            this.f6797u = typedArrayObtainStyledAttributes.getColor(1, getResources().getColor(R.color.mc_cir_progress_button_red));
            this.f6798v = typedArrayObtainStyledAttributes.getColor(2, getResources().getColor(R.color.mc_cir_progress_button_blank));
            ColorStateList colorStateList = typedArrayObtainStyledAttributes.getColorStateList(16);
            this.J = colorStateList;
            if (colorStateList == null) {
                this.J = getTextColors();
            }
            ColorStateList colorStateList2 = typedArrayObtainStyledAttributes.getColorStateList(17);
            this.H = colorStateList2;
            if (colorStateList2 == null) {
                this.H = getTextColors();
            }
            ColorStateList colorStateList3 = typedArrayObtainStyledAttributes.getColorStateList(15);
            this.I = colorStateList3;
            if (colorStateList3 == null) {
                this.I = getTextColors();
            }
            this.P = typedArrayObtainStyledAttributes.getBoolean(0, true);
            typedArrayObtainStyledAttributes.recycle();
        }
        this.V = 100;
        this.f6792o = State.f6803b;
        setText(this.f6793p);
        s();
        int iF = f(this.f6780d);
        int iG = g(this.f6780d);
        int colorForState = this.f6780d.getColorForState(new int[]{android.R.attr.state_focused}, 0);
        int colorForState2 = this.f6780d.getColorForState(new int[]{-16842910}, 0);
        int iF2 = f(this.K);
        int iG2 = g(this.K);
        int colorForState3 = this.K.getColorForState(new int[]{android.R.attr.state_focused}, 0);
        int colorForState4 = this.K.getColorForState(new int[]{-16842910}, 0);
        if (this.f6776a == null) {
            this.f6776a = c(iF, iF2);
        }
        StrokeGradientDrawable strokeGradientDrawableC = c(colorForState2, colorForState4);
        StrokeGradientDrawable strokeGradientDrawableC2 = c(colorForState, colorForState3);
        StrokeGradientDrawable strokeGradientDrawableC3 = c(iG, iG2);
        if (this.f6787j == null) {
            StateListDrawable stateListDrawable = new StateListDrawable();
            this.f6787j = stateListDrawable;
            stateListDrawable.setCallback(this);
        }
        this.f6787j.addState(new int[]{android.R.attr.state_pressed}, strokeGradientDrawableC3.getGradientDrawable());
        this.f6787j.addState(new int[]{android.R.attr.state_focused}, strokeGradientDrawableC2.getGradientDrawable());
        this.f6787j.addState(new int[]{-16842910}, strokeGradientDrawableC.getGradientDrawable());
        StateListDrawable stateListDrawable2 = this.f6787j;
        int[] iArr = StateSet.WILD_CARD;
        stateListDrawable2.addState(iArr, this.f6776a.getGradientDrawable());
        this.f6787j.setBounds(0, 0, getRight() - getLeft(), getBottom() - getTop());
        StrokeGradientDrawable strokeGradientDrawableC4 = c(g(this.f6782e), g(this.L));
        if (this.f6788k == null) {
            StateListDrawable stateListDrawable3 = new StateListDrawable();
            this.f6788k = stateListDrawable3;
            stateListDrawable3.setCallback(this);
        }
        this.f6788k.addState(new int[]{android.R.attr.state_pressed}, strokeGradientDrawableC4.getGradientDrawable());
        this.f6788k.addState(iArr, this.f6776a.getGradientDrawable());
        this.f6788k.setBounds(0, 0, getRight() - getLeft(), getBottom() - getTop());
        i();
        StrokeGradientDrawable strokeGradientDrawableC5 = c(g(this.h), g(this.M));
        if (this.f6789l == null) {
            StateListDrawable stateListDrawable4 = new StateListDrawable();
            this.f6789l = stateListDrawable4;
            stateListDrawable4.setCallback(this);
        }
        this.f6789l.addState(new int[]{android.R.attr.state_pressed}, strokeGradientDrawableC5.getGradientDrawable());
        this.f6789l.addState(iArr, this.f6776a.getGradientDrawable());
        this.f6789l.setBounds(0, 0, getRight() - getLeft(), getBottom() - getTop());
        this.f6791n = this.f6787j;
        setBackgroundCompat(null);
        new com.stepos.common.animator.g().a(this, false);
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
            this.f6791n = this.f6790m;
            return;
        }
        if (iOrdinal == 1) {
            this.f6791n = this.f6787j;
        } else if (iOrdinal == 2) {
            this.f6791n = this.f6788k;
        } else {
            if (iOrdinal != 3) {
                return;
            }
            this.f6791n = this.f6789l;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setIcon(int i10) throws Resources.NotFoundException {
        Drawable drawable = getResources().getDrawable(i10);
        if (drawable != null) {
            int width = (getWidth() / 2) - (drawable.getIntrinsicWidth() / 2);
            setCompoundDrawablesWithIntrinsicBounds(i10, 0, 0, 0);
            setPadding(width, 0, 0, 0);
        }
    }

    private void setState(State state) {
        if (this.f6792o != state) {
            this.f6792o = state;
        }
    }

    private void setTextForState(State state) {
        int iOrdinal = state.ordinal();
        if (iOrdinal == 1) {
            setText(this.f6793p);
            s();
        } else if (iOrdinal == 2) {
            setText(this.f6794q);
            s();
        } else {
            if (iOrdinal != 3) {
                return;
            }
            setText(this.r);
            s();
        }
    }

    public final StrokeGradientDrawable c(int i10, int i11) {
        GradientDrawable gradientDrawable = (GradientDrawable) getResources().getDrawable(R.drawable.mc_cir_pro_btn_background).mutate();
        gradientDrawable.setColor(i10);
        gradientDrawable.setCornerRadius(this.A);
        StrokeGradientDrawable strokeGradientDrawable = new StrokeGradientDrawable(gradientDrawable);
        strokeGradientDrawable.setStrokeColor(i11);
        return strokeGradientDrawable;
    }

    public final f d() {
        this.f6777a0 = true;
        setClickable(false);
        f fVar = new f(this, this.f6776a);
        this.G = fVar;
        float f8 = this.A;
        fVar.f6819i = f8;
        fVar.f6820j = f8;
        fVar.f6814c = getWidth();
        this.G.f6815d = getWidth();
        if (this.C || !this.F) {
            this.G.f6813b = 1;
        } else {
            this.G.f6813b = 240;
        }
        this.C = false;
        return this.G;
    }

    @Override // android.view.View
    public final void draw(Canvas canvas) {
        StateListDrawable stateListDrawable;
        if (this.O || !this.f6777a0) {
            this.O = false;
            r(State.f6803b, this.f6787j);
            r(State.f6804c, this.f6788k);
            r(State.f6805d, this.f6789l);
            r(this.f6792o, this.f6776a.getGradientDrawable());
        }
        if (this.f6777a0 && isPressed()) {
            super.draw(canvas);
            return;
        }
        if (this.f6791n != null) {
            if ((getScrollX() | getScrollY()) == 0) {
                int iOrdinal = this.f6792o.ordinal();
                if (iOrdinal == 0) {
                    StateListDrawable stateListDrawable2 = this.f6790m;
                    if (stateListDrawable2 != null) {
                        stateListDrawable2.draw(canvas);
                    }
                } else if (iOrdinal == 1) {
                    StateListDrawable stateListDrawable3 = this.f6787j;
                    if (stateListDrawable3 != null) {
                        stateListDrawable3.draw(canvas);
                    }
                } else if (iOrdinal == 2) {
                    StateListDrawable stateListDrawable4 = this.f6788k;
                    if (stateListDrawable4 != null) {
                        stateListDrawable4.draw(canvas);
                    }
                } else if (iOrdinal == 3 && (stateListDrawable = this.f6789l) != null) {
                    stateListDrawable.draw(canvas);
                }
            } else {
                canvas.translate(getScrollX(), getScrollY());
                this.f6791n.draw(canvas);
                canvas.translate(-getScrollX(), -getScrollY());
            }
        }
        super.draw(canvas);
    }

    @Override // android.widget.TextView, android.view.View
    public final void drawableStateChanged() {
        Rect rect;
        if (this.f6777a0) {
            rect = new Rect();
            rect.set(this.f6776a.getGradientDrawable().getBounds());
        } else {
            rect = null;
        }
        int[] drawableState = getDrawableState();
        StateListDrawable stateListDrawable = this.f6787j;
        if (stateListDrawable != null) {
            stateListDrawable.setState(drawableState);
        }
        int[] drawableState2 = getDrawableState();
        StateListDrawable stateListDrawable2 = this.f6788k;
        if (stateListDrawable2 != null) {
            stateListDrawable2.setState(drawableState2);
        }
        int[] drawableState3 = getDrawableState();
        StateListDrawable stateListDrawable3 = this.f6789l;
        if (stateListDrawable3 != null) {
            stateListDrawable3.setState(drawableState3);
        }
        StateListDrawable stateListDrawable4 = this.f6790m;
        int[] drawableState4 = getDrawableState();
        if (stateListDrawable4 != null) {
            stateListDrawable4.setState(drawableState4);
        }
        if (this.f6777a0 && rect != null) {
            this.f6776a.getGradientDrawable().setBounds(rect);
        }
        super.drawableStateChanged();
    }

    public final f e(float f8, float f9, int i10, int i11) {
        this.f6777a0 = true;
        setClickable(false);
        f fVar = new f(this, this.f6776a);
        this.G = fVar;
        fVar.f6819i = f8;
        fVar.f6820j = f9;
        fVar.f6823m = this.z;
        fVar.f6814c = i10;
        fVar.f6815d = i11;
        if (this.C || !this.F) {
            fVar.f6813b = 1;
        } else {
            fVar.f6813b = 240;
        }
        this.C = false;
        return fVar;
    }

    public String getCompleteText() {
        return this.f6794q;
    }

    public String getErrorText() {
        return this.r;
    }

    public String getIdleText() {
        return this.f6793p;
    }

    public int getProgress() {
        return this.W;
    }

    public State getState() {
        return this.f6792o;
    }

    public final int h(TextPaint textPaint, String str) {
        TransformationMethod transformationMethod = getTransformationMethod();
        if (transformationMethod != null) {
            str = transformationMethod.getTransformation(str, this).toString();
        }
        return (int) textPaint.measureText(str);
    }

    public final void i() {
        if (this.f6790m == null) {
            StateListDrawable stateListDrawable = new StateListDrawable();
            this.f6790m = stateListDrawable;
            stateListDrawable.setCallback(this);
        }
        this.f6790m.addState(StateSet.WILD_CARD, this.f6776a.getGradientDrawable());
        int iAbs = (Math.abs(getWidth() - getHeight()) / 2) + this.z;
        int width = getWidth() - iAbs;
        int i10 = this.z;
        this.f6790m.setBounds(iAbs, i10, width - i10, getHeight() - this.z);
    }

    public final void j() {
        f fVarD = d();
        fVarD.f6816e = f(this.f6782e);
        fVarD.f6817f = f(this.f6780d);
        fVarD.f6818g = f(this.L);
        fVarD.h = f(this.K);
        fVarD.f6812a = this.f6785g0;
        setState(State.f6803b);
        this.f6791n = this.f6787j;
        fVarD.a();
    }

    public final void k() {
        f fVarD = d();
        fVarD.f6816e = f(this.h);
        fVarD.f6817f = f(this.f6780d);
        fVarD.f6818g = f(this.M);
        fVarD.h = f(this.K);
        fVarD.f6812a = this.f6785g0;
        setState(State.f6803b);
        this.f6791n = this.f6787j;
        fVarD.a();
    }

    public final void l() {
        f fVarD = d();
        fVarD.f6816e = f(this.f6780d);
        fVarD.f6818g = f(this.K);
        fVarD.f6817f = f(this.f6782e);
        fVarD.h = f(this.L);
        fVarD.f6812a = this.f6784f0;
        setState(State.f6804c);
        this.f6791n = this.f6788k;
        fVarD.a();
    }

    public final void m() {
        f fVarD = d();
        fVarD.f6816e = f(this.f6780d);
        fVarD.f6817f = f(this.h);
        fVarD.f6818g = f(this.K);
        fVarD.h = f(this.M);
        fVarD.f6812a = this.f6786h0;
        setState(State.f6805d);
        this.f6791n = this.f6789l;
        fVarD.a();
    }

    public final void n() {
        f fVarE = e(getHeight(), this.A, getHeight(), getWidth());
        fVarE.f6816e = this.f6796t;
        fVarE.f6818g = this.f6797u;
        fVarE.h = f(this.L);
        fVarE.f6817f = f(this.f6782e);
        fVarE.f6821k = this.U;
        fVarE.f6822l = this.f6801y;
        fVarE.f6812a = this.f6784f0;
        setState(State.f6804c);
        this.f6791n = this.f6788k;
        fVarE.a();
    }

    public final void o() {
        f fVarE = e(getHeight(), this.A, getHeight(), getWidth());
        fVarE.f6816e = this.f6796t;
        fVarE.f6817f = f(this.h);
        fVarE.f6818g = this.f6797u;
        fVarE.h = f(this.M);
        fVarE.f6821k = this.U;
        fVarE.f6822l = this.f6801y;
        fVarE.f6812a = this.f6786h0;
        setState(State.f6805d);
        this.f6791n = this.f6789l;
        fVarE.a();
    }

    @Override // android.view.View
    public final void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        f fVar = this.G;
        if (fVar != null) {
            fVar.f6826p.end();
            fVar.f6826p.removeAllListeners();
        }
    }

    @Override // android.widget.TextView, android.view.View
    public final void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (this.f6792o != State.f6802a || this.f6777a0) {
            CircularAnimatedDrawable circularAnimatedDrawable = this.f6778b;
            if (circularAnimatedDrawable != null) {
                circularAnimatedDrawable.setAllowLoading(false);
                return;
            }
            return;
        }
        if (this.B) {
            CircularAnimatedDrawable circularAnimatedDrawable2 = this.f6778b;
            if (circularAnimatedDrawable2 != null) {
                circularAnimatedDrawable2.setAllowLoading(true);
                this.f6778b.draw(canvas);
                return;
            }
            int width = (getWidth() - getHeight()) / 2;
            this.f6778b = new CircularAnimatedDrawable(this.f6797u, this.U);
            int i10 = this.z + width;
            int width2 = (getWidth() - width) - this.z;
            int height = getHeight();
            int i11 = this.z;
            this.f6778b.setBounds(i10, i11, width2, height - i11);
            this.f6778b.setCallback(this);
            this.f6778b.start();
            return;
        }
        if (this.f6779c == null) {
            int width3 = (getWidth() - getHeight()) / 2;
            this.f6779c = new CircularProgressDrawable(getHeight() - (this.z * 2), this.U, this.f6797u);
            int i12 = width3 + this.z;
            float f8 = this.z;
            this.f6779c.setOffset(((getWidth() - getHeight()) / 2.0f) + f8, f8);
            CircularProgressDrawable circularProgressDrawable = this.f6779c;
            int i13 = this.z;
            circularProgressDrawable.setBounds(i12, i13, i12, i13);
        }
        if (this.E) {
            this.E = false;
            this.f6779c.setCenterIcon(this.D);
            if (this.D == null) {
                this.f6779c.setShowCenterIcon(this.N);
            }
        }
        this.f6779c.setStartAngle(-90.0f);
        this.f6779c.setSweepAngle((360.0f / this.V) * this.c0);
        this.f6779c.draw(canvas);
    }

    @Override // android.view.View
    public final void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo accessibilityNodeInfo) {
        super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
        accessibilityNodeInfo.setClassName(CircularProgressButton.class.getName());
    }

    @Override // android.widget.TextView, android.view.View
    public final void onLayout(boolean z, int i10, int i11, int i12, int i13) {
        super.onLayout(z, i10, i11, i12, i13);
        if (z) {
            t(this.f6792o, false);
        }
    }

    @Override // android.widget.TextView, android.view.View
    public final void onRestoreInstanceState(Parcelable parcelable) {
        if (!(parcelable instanceof SavedState)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        SavedState savedState = (SavedState) parcelable;
        this.W = savedState.mProgress;
        this.B = savedState.mIndeterminateProgressMode;
        this.C = savedState.mConfigurationChanged;
        super.onRestoreInstanceState(savedState.getSuperState());
        setProgress(this.W);
    }

    @Override // android.widget.TextView, android.view.View
    public final Parcelable onSaveInstanceState() {
        SavedState savedState = new SavedState(super.onSaveInstanceState());
        savedState.mProgress = this.W;
        savedState.mIndeterminateProgressMode = this.B;
        savedState.mConfigurationChanged = true;
        return savedState;
    }

    @Override // android.view.View
    public final void onSizeChanged(int i10, int i11, int i12, int i13) {
        super.onSizeChanged(i10, i11, i12, i13);
        this.f6778b = null;
        this.f6779c = null;
        this.E = true;
        this.O = true;
    }

    public final void p() {
        f fVarE = e(getHeight(), this.A, getHeight(), getWidth());
        fVarE.f6816e = this.f6796t;
        fVarE.f6817f = f(this.f6780d);
        fVarE.f6818g = this.f6797u;
        fVarE.h = f(this.K);
        fVarE.f6821k = this.U;
        fVarE.f6822l = this.f6801y;
        fVarE.f6812a = new e();
        setState(State.f6803b);
        this.f6791n = this.f6787j;
        fVarE.a();
    }

    public final void q() {
        if (this.R == 0) {
            this.R = getWidth();
        }
        if (!this.S || this.T) {
            this.Q = getCompoundPaddingRight() + getCompoundPaddingLeft() + h(getPaint(), this.r);
        } else {
            this.Q = getWidth();
        }
        setWidth(this.Q);
        setText(this.f6795s);
        s();
        f fVarE = e(this.A, getHeight(), this.Q, getHeight());
        fVarE.f6816e = f(this.f6780d);
        fVarE.f6817f = this.f6796t;
        fVarE.f6818g = f(this.K);
        fVarE.h = this.f6798v;
        fVarE.f6821k = this.f6801y;
        fVarE.f6822l = this.U;
        fVarE.f6812a = this.f6783e0;
        setState(State.f6802a);
        this.f6791n = this.f6790m;
        fVarE.a();
    }

    public final void r(State state, Drawable drawable) {
        if (drawable == null) {
            return;
        }
        if (state != State.f6802a) {
            drawable.setBounds(0, 0, getRight() - getLeft(), getBottom() - getTop());
            return;
        }
        int iAbs = (Math.abs(getWidth() - getHeight()) / 2) + this.z;
        int width = getWidth() - iAbs;
        int i10 = this.z;
        drawable.setBounds(iAbs, i10, width - i10, getHeight() - this.z);
    }

    public final float s() {
        setEllipsize(TextUtils.TruncateAt.END);
        setMaxLines(1);
        if (!this.P || getText() == null) {
            return 0.0f;
        }
        float fH = h(getPaint(), getText().toString());
        int iA = (int) l8.f.a(12.0f, getContext());
        if ((iA * 2) + fH < ((int) l8.f.a(90.0f, getContext()))) {
            setPadding(iA, 0, iA, 0);
            return fH;
        }
        int iA2 = (int) l8.f.a(8.0f, getContext());
        setPadding(iA2, 0, iA2, 0);
        return fH;
    }

    @Override // android.view.View
    public void setBackgroundColor(int i10) {
        this.f6776a.getGradientDrawable().setColor(i10);
    }

    @SuppressLint({"NewApi"})
    public void setBackgroundCompat(Drawable drawable) {
        setBackground(drawable);
    }

    public void setCanSkipAnim(boolean z) {
        this.f6781d0 = z;
    }

    public void setCompleteText(String str) {
        this.f6794q = str;
    }

    public void setErrorText(String str) {
        this.r = str;
    }

    public void setIdleText(String str) {
        this.f6793p = str;
    }

    public void setIndeterminateProgressMode(boolean z) {
        this.B = z;
    }

    public void setIndicatorBackgroundColor(int i10) {
        if (this.f6798v != i10) {
            this.f6798v = i10;
        }
    }

    @Override // android.view.View
    public void setPressed(boolean z) {
        if (z && this.f6777a0) {
            return;
        }
        super.setPressed(z);
    }

    @Deprecated
    public void setProgress(int i10) {
        this.W = i10;
        this.F = true;
        if (this.f6777a0 || getWidth() == 0) {
            return;
        }
        int i11 = this.W;
        int i12 = this.V;
        State state = State.f6803b;
        State state2 = State.f6802a;
        if (i11 >= i12) {
            State state3 = this.f6792o;
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
        State state4 = State.f6805d;
        if (i11 > 0) {
            State state5 = this.f6792o;
            if (state5 == state || state5 == state4) {
                q();
                return;
            }
            if (state5 == state2) {
                ValueAnimator valueAnimator = this.b0;
                if (valueAnimator != null) {
                    valueAnimator.cancel();
                    this.b0.removeAllUpdateListeners();
                    this.b0.removeAllListeners();
                }
                ValueAnimator valueAnimatorOfInt = ValueAnimator.ofInt(this.c0, this.W);
                this.b0 = valueAnimatorOfInt;
                valueAnimatorOfInt.setDuration(EngineRuntimeConfig.MIN_ABSOLUTE_TARGET_MB);
                this.b0.setInterpolator(new AccelerateDecelerateInterpolator());
                this.b0.addUpdateListener(new com.stepos.common.widget.f(this));
                this.b0.start();
                return;
            }
            return;
        }
        if (i11 == -1) {
            State state6 = this.f6792o;
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
        if (i11 == 0) {
            State state7 = this.f6792o;
            if (state7 == State.f6804c) {
                j();
            } else if (state7 == state2) {
                p();
            } else if (state7 == state4) {
                k();
            }
        }
    }

    public void setProgressCenterIcon(Drawable drawable) {
        this.D = drawable;
        this.E = true;
    }

    public void setProgressForState(int i10) {
        if (this.f6792o == State.f6802a) {
            this.W = i10;
            ValueAnimator valueAnimator = this.b0;
            if (valueAnimator != null) {
                valueAnimator.cancel();
                this.b0.removeAllUpdateListeners();
                this.b0.removeAllListeners();
            }
            this.c0 = this.W;
            invalidate();
        }
    }

    public void setProgressIndicatorColor(int i10) {
        this.f6797u = i10;
        this.f6778b = null;
        this.f6779c = null;
    }

    public void setProgressStrokeWidth(int i10) {
        i();
        if (i10 <= 0 || this.U == i10) {
            return;
        }
        this.U = i10;
        CircularAnimatedDrawable circularAnimatedDrawable = this.f6778b;
        if (circularAnimatedDrawable != null) {
            circularAnimatedDrawable.setStrokeWidth(i10);
        }
        CircularProgressDrawable circularProgressDrawable = this.f6779c;
        if (circularProgressDrawable != null) {
            circularProgressDrawable.setStrokeWidth(i10);
        }
    }

    public void setShowCenterIcon(boolean z) {
        this.N = z;
        this.E = true;
    }

    public void setStrokeColor(int i10) {
        this.f6776a.setStrokeColor(i10);
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
        return drawable == this.f6778b || drawable == this.f6790m || drawable == this.f6787j || drawable == this.f6789l || drawable == this.f6788k || super.verifyDrawable(drawable);
    }

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public class f {

        /* renamed from: a, reason: collision with root package name */
        public g f6812a;

        /* renamed from: b, reason: collision with root package name */
        public int f6813b;

        /* renamed from: c, reason: collision with root package name */
        public int f6814c;

        /* renamed from: d, reason: collision with root package name */
        public int f6815d;

        /* renamed from: e, reason: collision with root package name */
        public int f6816e;

        /* renamed from: f, reason: collision with root package name */
        public int f6817f;

        /* renamed from: g, reason: collision with root package name */
        public int f6818g;
        public int h;

        /* renamed from: i, reason: collision with root package name */
        public float f6819i;

        /* renamed from: j, reason: collision with root package name */
        public float f6820j;

        /* renamed from: k, reason: collision with root package name */
        public int f6821k;

        /* renamed from: l, reason: collision with root package name */
        public int f6822l;

        /* renamed from: m, reason: collision with root package name */
        public float f6823m;

        /* renamed from: n, reason: collision with root package name */
        public final CircularProgressButton f6824n;

        /* renamed from: o, reason: collision with root package name */
        public final StrokeGradientDrawable f6825o;

        /* renamed from: p, reason: collision with root package name */
        public AnimatorSet f6826p;

        /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
        public class a implements ValueAnimator.AnimatorUpdateListener {

            /* renamed from: a, reason: collision with root package name */
            public final /* synthetic */ GradientDrawable f6828a;

            public a(GradientDrawable gradientDrawable) {
                this.f6828a = gradientDrawable;
            }

            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                int iIntValue;
                int i10;
                int animatedFraction;
                Integer num = (Integer) valueAnimator.getAnimatedValue();
                f fVar = f.this;
                int i11 = fVar.f6814c;
                int i12 = fVar.f6815d;
                if (i11 > i12) {
                    iIntValue = (i11 - num.intValue()) / 2;
                    i10 = fVar.f6814c - iIntValue;
                    animatedFraction = (int) (valueAnimator.getAnimatedFraction() * fVar.f6823m);
                } else {
                    iIntValue = (i12 - num.intValue()) / 2;
                    i10 = fVar.f6815d - iIntValue;
                    float f8 = fVar.f6823m;
                    animatedFraction = (int) (f8 - (valueAnimator.getAnimatedFraction() * f8));
                }
                this.f6828a.setBounds(iIntValue + animatedFraction, animatedFraction, (i10 - animatedFraction) - 1, (fVar.f6824n.getHeight() - animatedFraction) - 1);
                CircularProgressButton.this.invalidate();
            }
        }

        public f(CircularProgressButton circularProgressButton, StrokeGradientDrawable strokeGradientDrawable) {
            this.f6824n = circularProgressButton;
            this.f6825o = strokeGradientDrawable;
        }

        public final void a() {
            ValueAnimator valueAnimatorOfInt = ValueAnimator.ofInt(this.f6814c, this.f6815d);
            StrokeGradientDrawable strokeGradientDrawable = this.f6825o;
            GradientDrawable gradientDrawable = strokeGradientDrawable.getGradientDrawable();
            valueAnimatorOfInt.addUpdateListener(new a(gradientDrawable));
            ObjectAnimator objectAnimatorOfInt = ObjectAnimator.ofInt(gradientDrawable, "color", this.f6816e, this.f6817f);
            objectAnimatorOfInt.setEvaluator(new ArgbEvaluator());
            ObjectAnimator objectAnimatorOfInt2 = ObjectAnimator.ofInt(strokeGradientDrawable, "strokeColor", this.f6818g, this.h);
            objectAnimatorOfInt2.setEvaluator(new ArgbEvaluator());
            ObjectAnimator objectAnimatorOfFloat = ObjectAnimator.ofFloat(gradientDrawable, "cornerRadius", this.f6819i, this.f6820j);
            ObjectAnimator objectAnimatorOfInt3 = ObjectAnimator.ofInt(strokeGradientDrawable, "strokeWidth", this.f6821k, this.f6822l);
            AnimatorSet animatorSet = new AnimatorSet();
            this.f6826p = animatorSet;
            animatorSet.setInterpolator(CircularProgressButton.this.getInterpolator());
            this.f6826p.setDuration(this.f6813b);
            this.f6826p.playTogether(valueAnimatorOfInt, objectAnimatorOfInt, objectAnimatorOfInt2, objectAnimatorOfFloat, objectAnimatorOfInt3);
            this.f6826p.addListener(new b());
            this.f6826p.start();
        }

        /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
        public class b implements Animator.AnimatorListener {
            public b() {
            }

            @Override // android.animation.Animator.AnimatorListener
            public final void onAnimationEnd(Animator animator) {
                g gVar = f.this.f6812a;
                if (gVar != null) {
                    gVar.a();
                }
            }

            @Override // android.animation.Animator.AnimatorListener
            public final void onAnimationCancel(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public final void onAnimationRepeat(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public final void onAnimationStart(Animator animator) {
            }
        }
    }
}
