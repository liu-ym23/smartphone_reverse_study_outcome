package androidx.appcompat.widget;

import android.R;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.Region;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.os.IBinder;
import android.text.InputFilter;
import android.text.Layout;
import android.text.StaticLayout;
import android.text.TextPaint;
import android.text.TextUtils;
import android.text.method.TransformationMethod;
import android.util.AttributeSet;
import android.view.ActionMode;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;
import android.widget.CompoundButton;
import androidx.annotation.FloatRange;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.mapapi.map.WeightedLatLng;
import com.stepos.alphame.utils.Property;
import g.AbstractC0560a;
import i.C0617a;
import java.util.WeakHashMap;

/* loaded from: classes.dex */
public class SwitchCompat extends CompoundButton {

    /* renamed from: R, reason: collision with root package name */
    public static final T0 f2916R = new T0(Float.class, "thumbPos", 0);

    /* renamed from: S, reason: collision with root package name */
    public static final int[] f2917S = {R.attr.state_checked};

    /* renamed from: A, reason: collision with root package name */
    public int f2918A;

    /* renamed from: B, reason: collision with root package name */
    public int f2919B;

    /* renamed from: C, reason: collision with root package name */
    public int f2920C;

    /* renamed from: D, reason: collision with root package name */
    public int f2921D;

    /* renamed from: E, reason: collision with root package name */
    public int f2922E;

    /* renamed from: F, reason: collision with root package name */
    public int f2923F;

    /* renamed from: G, reason: collision with root package name */
    public int f2924G;

    /* renamed from: H, reason: collision with root package name */
    public boolean f2925H;

    /* renamed from: I, reason: collision with root package name */
    public final TextPaint f2926I;

    /* renamed from: J, reason: collision with root package name */
    public final ColorStateList f2927J;

    /* renamed from: K, reason: collision with root package name */
    public StaticLayout f2928K;

    /* renamed from: L, reason: collision with root package name */
    public StaticLayout f2929L;

    /* renamed from: M, reason: collision with root package name */
    public final C0617a f2930M;

    /* renamed from: N, reason: collision with root package name */
    public ObjectAnimator f2931N;

    /* renamed from: O, reason: collision with root package name */
    public D f2932O;

    /* renamed from: P, reason: collision with root package name */
    public U0 f2933P;

    /* renamed from: Q, reason: collision with root package name */
    public final Rect f2934Q;

    /* renamed from: a, reason: collision with root package name */
    public Drawable f2935a;

    /* renamed from: b, reason: collision with root package name */
    public ColorStateList f2936b;

    /* renamed from: c, reason: collision with root package name */
    public PorterDuff.Mode f2937c;

    /* renamed from: d, reason: collision with root package name */
    public boolean f2938d;

    /* renamed from: e, reason: collision with root package name */
    public boolean f2939e;

    /* renamed from: f, reason: collision with root package name */
    public Drawable f2940f;

    /* renamed from: g, reason: collision with root package name */
    public ColorStateList f2941g;

    /* renamed from: h, reason: collision with root package name */
    public PorterDuff.Mode f2942h;

    /* renamed from: i, reason: collision with root package name */
    public boolean f2943i;

    /* renamed from: j, reason: collision with root package name */
    public boolean f2944j;

    /* renamed from: k, reason: collision with root package name */
    public int f2945k;

    /* renamed from: l, reason: collision with root package name */
    public int f2946l;

    /* renamed from: m, reason: collision with root package name */
    public int f2947m;

    /* renamed from: n, reason: collision with root package name */
    public boolean f2948n;

    /* renamed from: o, reason: collision with root package name */
    public CharSequence f2949o;

    /* renamed from: p, reason: collision with root package name */
    public CharSequence f2950p;

    /* renamed from: q, reason: collision with root package name */
    public CharSequence f2951q;

    /* renamed from: r, reason: collision with root package name */
    public CharSequence f2952r;

    /* renamed from: s, reason: collision with root package name */
    public boolean f2953s;

    /* renamed from: t, reason: collision with root package name */
    public int f2954t;

    /* renamed from: u, reason: collision with root package name */
    public final int f2955u;

    /* renamed from: v, reason: collision with root package name */
    public float f2956v;

    /* renamed from: w, reason: collision with root package name */
    public float f2957w;

    /* renamed from: x, reason: collision with root package name */
    public final VelocityTracker f2958x;

    /* renamed from: y, reason: collision with root package name */
    public final int f2959y;

    /* renamed from: z, reason: collision with root package name */
    public float f2960z;

    public SwitchCompat(@NonNull Context context, @Nullable AttributeSet attributeSet) throws Resources.NotFoundException {
        int resourceId;
        super(context, attributeSet, com.stepos.alphame.R.attr.switchStyle);
        this.f2936b = null;
        this.f2937c = null;
        this.f2938d = false;
        this.f2939e = false;
        this.f2941g = null;
        this.f2942h = null;
        this.f2943i = false;
        this.f2944j = false;
        this.f2958x = VelocityTracker.obtain();
        this.f2925H = true;
        this.f2934Q = new Rect();
        V0.a(getContext(), this);
        TextPaint textPaint = new TextPaint(1);
        this.f2926I = textPaint;
        textPaint.density = getResources().getDisplayMetrics().density;
        int[] iArr = AbstractC0560a.f12609v;
        android.support.v4.media.session.c cVarY = android.support.v4.media.session.c.y(com.stepos.alphame.R.attr.switchStyle, 0, context, attributeSet, iArr);
        TypedArray typedArray = (TypedArray) cVarY.f2365c;
        WeakHashMap weakHashMap = K.S.f939a;
        K.O.d(this, context, iArr, attributeSet, typedArray, com.stepos.alphame.R.attr.switchStyle, 0);
        Drawable drawableL = cVarY.l(2);
        this.f2935a = drawableL;
        if (drawableL != null) {
            drawableL.setCallback(this);
        }
        Drawable drawableL2 = cVarY.l(11);
        this.f2940f = drawableL2;
        if (drawableL2 != null) {
            drawableL2.setCallback(this);
        }
        setTextOnInternal(cVarY.u(0));
        setTextOffInternal(cVarY.u(1));
        this.f2953s = cVarY.g(3, true);
        this.f2945k = cVarY.j(8, 0);
        this.f2946l = cVarY.j(5, 0);
        this.f2947m = cVarY.j(6, 0);
        this.f2948n = cVarY.g(4, false);
        ColorStateList colorStateListH = cVarY.h(9);
        if (colorStateListH != null) {
            this.f2936b = colorStateListH;
            this.f2938d = true;
        }
        PorterDuff.Mode modeB = AbstractC0220p0.b(cVarY.p(10, -1), null);
        if (this.f2937c != modeB) {
            this.f2937c = modeB;
            this.f2939e = true;
        }
        if (this.f2938d || this.f2939e) {
            a();
        }
        ColorStateList colorStateListH2 = cVarY.h(12);
        if (colorStateListH2 != null) {
            this.f2941g = colorStateListH2;
            this.f2943i = true;
        }
        PorterDuff.Mode modeB2 = AbstractC0220p0.b(cVarY.p(13, -1), null);
        if (this.f2942h != modeB2) {
            this.f2942h = modeB2;
            this.f2944j = true;
        }
        if (this.f2943i || this.f2944j) {
            b();
        }
        int iR = cVarY.r(7, 0);
        if (iR != 0) {
            TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(iR, AbstractC0560a.f12610w);
            ColorStateList colorStateList = (!typedArrayObtainStyledAttributes.hasValue(3) || (resourceId = typedArrayObtainStyledAttributes.getResourceId(3, 0)) == 0 || (colorStateList = B0.f.x(resourceId, context)) == null) ? typedArrayObtainStyledAttributes.getColorStateList(3) : colorStateList;
            if (colorStateList != null) {
                this.f2927J = colorStateList;
            } else {
                this.f2927J = getTextColors();
            }
            int dimensionPixelSize = typedArrayObtainStyledAttributes.getDimensionPixelSize(0, 0);
            if (dimensionPixelSize != 0) {
                float f4 = dimensionPixelSize;
                if (f4 != textPaint.getTextSize()) {
                    textPaint.setTextSize(f4);
                    requestLayout();
                }
            }
            int i4 = typedArrayObtainStyledAttributes.getInt(1, -1);
            int i5 = typedArrayObtainStyledAttributes.getInt(2, -1);
            Typeface typeface = i4 != 1 ? i4 != 2 ? i4 != 3 ? null : Typeface.MONOSPACE : Typeface.SERIF : Typeface.SANS_SERIF;
            float f5 = Property.DEFAULT_FLOAT_VALUE;
            if (i5 > 0) {
                Typeface typefaceDefaultFromStyle = typeface == null ? Typeface.defaultFromStyle(i5) : Typeface.create(typeface, i5);
                setSwitchTypeface(typefaceDefaultFromStyle);
                int i6 = (~(typefaceDefaultFromStyle != null ? typefaceDefaultFromStyle.getStyle() : 0)) & i5;
                textPaint.setFakeBoldText((i6 & 1) != 0);
                textPaint.setTextSkewX((2 & i6) != 0 ? -0.25f : f5);
            } else {
                textPaint.setFakeBoldText(false);
                textPaint.setTextSkewX(Property.DEFAULT_FLOAT_VALUE);
                setSwitchTypeface(typeface);
            }
            if (typedArrayObtainStyledAttributes.getBoolean(14, false)) {
                Context context2 = getContext();
                C0617a c0617a = new C0617a();
                c0617a.f12993a = context2.getResources().getConfiguration().locale;
                this.f2930M = c0617a;
            } else {
                this.f2930M = null;
            }
            setTextOnInternal(this.f2949o);
            setTextOffInternal(this.f2951q);
            typedArrayObtainStyledAttributes.recycle();
        }
        new C0192b0(this).f(attributeSet, com.stepos.alphame.R.attr.switchStyle);
        cVarY.A();
        ViewConfiguration viewConfiguration = ViewConfiguration.get(context);
        this.f2955u = viewConfiguration.getScaledTouchSlop();
        this.f2959y = viewConfiguration.getScaledMinimumFlingVelocity();
        getEmojiTextViewHelper().b(attributeSet, com.stepos.alphame.R.attr.switchStyle);
        refreshDrawableState();
        setChecked(isChecked());
    }

    @NonNull
    private D getEmojiTextViewHelper() {
        if (this.f2932O == null) {
            this.f2932O = new D(this);
        }
        return this.f2932O;
    }

    private boolean getTargetCheckedState() {
        return this.f2960z > 0.5f;
    }

    private int getThumbOffset() {
        return (int) (((getLayoutDirection() == 1 ? 1.0f - this.f2960z : this.f2960z) * getThumbScrollRange()) + 0.5f);
    }

    private int getThumbScrollRange() {
        Drawable drawable = this.f2940f;
        if (drawable == null) {
            return 0;
        }
        Rect rect = this.f2934Q;
        drawable.getPadding(rect);
        Drawable drawable2 = this.f2935a;
        Rect rectA = drawable2 != null ? AbstractC0220p0.a(drawable2) : AbstractC0220p0.f3149a;
        return ((((this.f2918A - this.f2920C) - rect.left) - rect.right) - rectA.left) - rectA.right;
    }

    private void setTextOffInternal(CharSequence charSequence) {
        this.f2951q = charSequence;
        D emojiTextViewHelper = getEmojiTextViewHelper();
        TransformationMethod transformationMethodQ = ((y1.f) emojiTextViewHelper.f2809b.f12410b).q(this.f2930M);
        if (transformationMethodQ != null) {
            charSequence = transformationMethodQ.getTransformation(charSequence, this);
        }
        this.f2952r = charSequence;
        this.f2929L = null;
        if (this.f2953s) {
            d();
        }
    }

    private void setTextOnInternal(CharSequence charSequence) {
        this.f2949o = charSequence;
        D emojiTextViewHelper = getEmojiTextViewHelper();
        TransformationMethod transformationMethodQ = ((y1.f) emojiTextViewHelper.f2809b.f12410b).q(this.f2930M);
        if (transformationMethodQ != null) {
            charSequence = transformationMethodQ.getTransformation(charSequence, this);
        }
        this.f2950p = charSequence;
        this.f2928K = null;
        if (this.f2953s) {
            d();
        }
    }

    public final void a() {
        Drawable drawable = this.f2935a;
        if (drawable != null) {
            if (this.f2938d || this.f2939e) {
                Drawable drawableMutate = drawable.mutate();
                this.f2935a = drawableMutate;
                if (this.f2938d) {
                    E.a.h(drawableMutate, this.f2936b);
                }
                if (this.f2939e) {
                    E.a.i(this.f2935a, this.f2937c);
                }
                if (this.f2935a.isStateful()) {
                    this.f2935a.setState(getDrawableState());
                }
            }
        }
    }

    public final void b() {
        Drawable drawable = this.f2940f;
        if (drawable != null) {
            if (this.f2943i || this.f2944j) {
                Drawable drawableMutate = drawable.mutate();
                this.f2940f = drawableMutate;
                if (this.f2943i) {
                    E.a.h(drawableMutate, this.f2941g);
                }
                if (this.f2944j) {
                    E.a.i(this.f2940f, this.f2942h);
                }
                if (this.f2940f.isStateful()) {
                    this.f2940f.setState(getDrawableState());
                }
            }
        }
    }

    public final void c() {
        setTextOnInternal(this.f2949o);
        setTextOffInternal(this.f2951q);
        requestLayout();
    }

    public final void d() {
        if (this.f2933P == null && ((y1.f) this.f2932O.f2809b.f12410b).k() && X.j.f2054k != null) {
            X.j jVarA = X.j.a();
            int iB = jVarA.b();
            if (iB == 3 || iB == 0) {
                U0 u02 = new U0(this);
                this.f2933P = u02;
                jVarA.g(u02);
            }
        }
    }

    @Override // android.view.View
    public final void draw(Canvas canvas) {
        int i4;
        int i5;
        int i6 = this.f2921D;
        int i7 = this.f2922E;
        int i8 = this.f2923F;
        int i9 = this.f2924G;
        int thumbOffset = getThumbOffset() + i6;
        Drawable drawable = this.f2935a;
        Rect rectA = drawable != null ? AbstractC0220p0.a(drawable) : AbstractC0220p0.f3149a;
        Drawable drawable2 = this.f2940f;
        Rect rect = this.f2934Q;
        if (drawable2 != null) {
            drawable2.getPadding(rect);
            int i10 = rect.left;
            thumbOffset += i10;
            if (rectA != null) {
                int i11 = rectA.left;
                if (i11 > i10) {
                    i6 += i11 - i10;
                }
                int i12 = rectA.top;
                int i13 = rect.top;
                i4 = i12 > i13 ? (i12 - i13) + i7 : i7;
                int i14 = rectA.right;
                int i15 = rect.right;
                if (i14 > i15) {
                    i8 -= i14 - i15;
                }
                int i16 = rectA.bottom;
                int i17 = rect.bottom;
                if (i16 > i17) {
                    i5 = i9 - (i16 - i17);
                }
                this.f2940f.setBounds(i6, i4, i8, i5);
            } else {
                i4 = i7;
            }
            i5 = i9;
            this.f2940f.setBounds(i6, i4, i8, i5);
        }
        Drawable drawable3 = this.f2935a;
        if (drawable3 != null) {
            drawable3.getPadding(rect);
            int i18 = thumbOffset - rect.left;
            int i19 = thumbOffset + this.f2920C + rect.right;
            this.f2935a.setBounds(i18, i7, i19, i9);
            Drawable background = getBackground();
            if (background != null) {
                E.a.f(background, i18, i7, i19, i9);
            }
        }
        super.draw(canvas);
    }

    @Override // android.widget.CompoundButton, android.widget.TextView, android.view.View
    public final void drawableHotspotChanged(float f4, float f5) {
        super.drawableHotspotChanged(f4, f5);
        Drawable drawable = this.f2935a;
        if (drawable != null) {
            E.a.e(drawable, f4, f5);
        }
        Drawable drawable2 = this.f2940f;
        if (drawable2 != null) {
            E.a.e(drawable2, f4, f5);
        }
    }

    @Override // android.widget.CompoundButton, android.widget.TextView, android.view.View
    public final void drawableStateChanged() {
        super.drawableStateChanged();
        int[] drawableState = getDrawableState();
        Drawable drawable = this.f2935a;
        boolean state = (drawable == null || !drawable.isStateful()) ? false : drawable.setState(drawableState);
        Drawable drawable2 = this.f2940f;
        if (drawable2 != null && drawable2.isStateful()) {
            state |= drawable2.setState(drawableState);
        }
        if (state) {
            invalidate();
        }
    }

    @Override // android.widget.CompoundButton, android.widget.TextView
    public int getCompoundPaddingLeft() {
        if (getLayoutDirection() != 1) {
            return super.getCompoundPaddingLeft();
        }
        int compoundPaddingLeft = super.getCompoundPaddingLeft() + this.f2918A;
        return !TextUtils.isEmpty(getText()) ? compoundPaddingLeft + this.f2947m : compoundPaddingLeft;
    }

    @Override // android.widget.CompoundButton, android.widget.TextView
    public int getCompoundPaddingRight() {
        if (getLayoutDirection() == 1) {
            return super.getCompoundPaddingRight();
        }
        int compoundPaddingRight = super.getCompoundPaddingRight() + this.f2918A;
        return !TextUtils.isEmpty(getText()) ? compoundPaddingRight + this.f2947m : compoundPaddingRight;
    }

    @Override // android.widget.TextView
    @Nullable
    public ActionMode.Callback getCustomSelectionActionModeCallback() {
        return super.getCustomSelectionActionModeCallback();
    }

    public boolean getShowText() {
        return this.f2953s;
    }

    public boolean getSplitTrack() {
        return this.f2948n;
    }

    public int getSwitchMinWidth() {
        return this.f2946l;
    }

    public int getSwitchPadding() {
        return this.f2947m;
    }

    public CharSequence getTextOff() {
        return this.f2951q;
    }

    public CharSequence getTextOn() {
        return this.f2949o;
    }

    public Drawable getThumbDrawable() {
        return this.f2935a;
    }

    @FloatRange(from = 0.0d, to = WeightedLatLng.DEFAULT_INTENSITY)
    public final float getThumbPosition() {
        return this.f2960z;
    }

    public int getThumbTextPadding() {
        return this.f2945k;
    }

    @Nullable
    public ColorStateList getThumbTintList() {
        return this.f2936b;
    }

    @Nullable
    public PorterDuff.Mode getThumbTintMode() {
        return this.f2937c;
    }

    public Drawable getTrackDrawable() {
        return this.f2940f;
    }

    @Nullable
    public ColorStateList getTrackTintList() {
        return this.f2941g;
    }

    @Nullable
    public PorterDuff.Mode getTrackTintMode() {
        return this.f2942h;
    }

    @Override // android.widget.CompoundButton, android.widget.TextView, android.view.View
    public final void jumpDrawablesToCurrentState() {
        super.jumpDrawablesToCurrentState();
        Drawable drawable = this.f2935a;
        if (drawable != null) {
            drawable.jumpToCurrentState();
        }
        Drawable drawable2 = this.f2940f;
        if (drawable2 != null) {
            drawable2.jumpToCurrentState();
        }
        ObjectAnimator objectAnimator = this.f2931N;
        if (objectAnimator == null || !objectAnimator.isStarted()) {
            return;
        }
        this.f2931N.end();
        this.f2931N = null;
    }

    @Override // android.widget.CompoundButton, android.widget.TextView, android.view.View
    public final int[] onCreateDrawableState(int i4) {
        int[] iArrOnCreateDrawableState = super.onCreateDrawableState(i4 + 1);
        if (isChecked()) {
            View.mergeDrawableStates(iArrOnCreateDrawableState, f2917S);
        }
        return iArrOnCreateDrawableState;
    }

    @Override // android.widget.CompoundButton, android.widget.TextView, android.view.View
    public final void onDraw(Canvas canvas) {
        int width;
        super.onDraw(canvas);
        Drawable drawable = this.f2940f;
        Rect rect = this.f2934Q;
        if (drawable != null) {
            drawable.getPadding(rect);
        } else {
            rect.setEmpty();
        }
        int i4 = this.f2922E;
        int i5 = this.f2924G;
        int i6 = i4 + rect.top;
        int i7 = i5 - rect.bottom;
        Drawable drawable2 = this.f2935a;
        if (drawable != null) {
            if (!this.f2948n || drawable2 == null) {
                drawable.draw(canvas);
            } else {
                Rect rectA = AbstractC0220p0.a(drawable2);
                drawable2.copyBounds(rect);
                rect.left += rectA.left;
                rect.right -= rectA.right;
                int iSave = canvas.save();
                canvas.clipRect(rect, Region.Op.DIFFERENCE);
                drawable.draw(canvas);
                canvas.restoreToCount(iSave);
            }
        }
        int iSave2 = canvas.save();
        if (drawable2 != null) {
            drawable2.draw(canvas);
        }
        StaticLayout staticLayout = getTargetCheckedState() ? this.f2928K : this.f2929L;
        if (staticLayout != null) {
            int[] drawableState = getDrawableState();
            ColorStateList colorStateList = this.f2927J;
            TextPaint textPaint = this.f2926I;
            if (colorStateList != null) {
                textPaint.setColor(colorStateList.getColorForState(drawableState, 0));
            }
            textPaint.drawableState = drawableState;
            if (drawable2 != null) {
                Rect bounds = drawable2.getBounds();
                width = bounds.left + bounds.right;
            } else {
                width = getWidth();
            }
            canvas.translate((width / 2) - (staticLayout.getWidth() / 2), ((i6 + i7) / 2) - (staticLayout.getHeight() / 2));
            staticLayout.draw(canvas);
        }
        canvas.restoreToCount(iSave2);
    }

    @Override // android.view.View
    public final void onInitializeAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        super.onInitializeAccessibilityEvent(accessibilityEvent);
        accessibilityEvent.setClassName("android.widget.Switch");
    }

    @Override // android.view.View
    public final void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo accessibilityNodeInfo) {
        super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
        accessibilityNodeInfo.setClassName("android.widget.Switch");
    }

    @Override // android.widget.TextView, android.view.View
    public final void onLayout(boolean z4, int i4, int i5, int i6, int i7) {
        int iMax;
        int iE;
        int paddingLeft;
        int height;
        int paddingTop;
        super.onLayout(z4, i4, i5, i6, i7);
        int iMax2 = 0;
        if (this.f2935a != null) {
            Drawable drawable = this.f2940f;
            Rect rect = this.f2934Q;
            if (drawable != null) {
                drawable.getPadding(rect);
            } else {
                rect.setEmpty();
            }
            Rect rectA = AbstractC0220p0.a(this.f2935a);
            iMax = Math.max(0, rectA.left - rect.left);
            iMax2 = Math.max(0, rectA.right - rect.right);
        } else {
            iMax = 0;
        }
        if (getLayoutDirection() == 1) {
            paddingLeft = getPaddingLeft() + iMax;
            iE = B0.g.e(paddingLeft, this.f2918A, iMax, iMax2);
        } else {
            int width = (getWidth() - getPaddingRight()) - iMax2;
            int i8 = iMax2 + (width - this.f2918A) + iMax;
            iE = width;
            paddingLeft = i8;
        }
        int gravity = getGravity() & 112;
        if (gravity == 16) {
            int height2 = ((getHeight() + getPaddingTop()) - getPaddingBottom()) / 2;
            int i9 = this.f2919B;
            int i10 = height2 - (i9 / 2);
            height = i9 + i10;
            paddingTop = i10;
        } else if (gravity != 80) {
            paddingTop = getPaddingTop();
            height = this.f2919B + paddingTop;
        } else {
            height = getHeight() - getPaddingBottom();
            paddingTop = height - this.f2919B;
        }
        this.f2921D = paddingLeft;
        this.f2922E = paddingTop;
        this.f2924G = height;
        this.f2923F = iE;
    }

    @Override // android.widget.TextView, android.view.View
    public final void onMeasure(int i4, int i5) {
        int intrinsicWidth;
        int intrinsicHeight;
        int intrinsicHeight2 = 0;
        if (this.f2953s) {
            StaticLayout staticLayout = this.f2928K;
            TextPaint textPaint = this.f2926I;
            if (staticLayout == null) {
                CharSequence charSequence = this.f2950p;
                this.f2928K = new StaticLayout(charSequence, textPaint, charSequence != null ? (int) Math.ceil(Layout.getDesiredWidth(charSequence, textPaint)) : 0, Layout.Alignment.ALIGN_NORMAL, 1.0f, Property.DEFAULT_FLOAT_VALUE, true);
            }
            if (this.f2929L == null) {
                CharSequence charSequence2 = this.f2952r;
                this.f2929L = new StaticLayout(charSequence2, textPaint, charSequence2 != null ? (int) Math.ceil(Layout.getDesiredWidth(charSequence2, textPaint)) : 0, Layout.Alignment.ALIGN_NORMAL, 1.0f, Property.DEFAULT_FLOAT_VALUE, true);
            }
        }
        Drawable drawable = this.f2935a;
        Rect rect = this.f2934Q;
        if (drawable != null) {
            drawable.getPadding(rect);
            intrinsicWidth = (this.f2935a.getIntrinsicWidth() - rect.left) - rect.right;
            intrinsicHeight = this.f2935a.getIntrinsicHeight();
        } else {
            intrinsicWidth = 0;
            intrinsicHeight = 0;
        }
        this.f2920C = Math.max(this.f2953s ? (this.f2945k * 2) + Math.max(this.f2928K.getWidth(), this.f2929L.getWidth()) : 0, intrinsicWidth);
        Drawable drawable2 = this.f2940f;
        if (drawable2 != null) {
            drawable2.getPadding(rect);
            intrinsicHeight2 = this.f2940f.getIntrinsicHeight();
        } else {
            rect.setEmpty();
        }
        int iMax = rect.left;
        int iMax2 = rect.right;
        Drawable drawable3 = this.f2935a;
        if (drawable3 != null) {
            Rect rectA = AbstractC0220p0.a(drawable3);
            iMax = Math.max(iMax, rectA.left);
            iMax2 = Math.max(iMax2, rectA.right);
        }
        int iMax3 = this.f2925H ? Math.max(this.f2946l, (this.f2920C * 2) + iMax + iMax2) : this.f2946l;
        int iMax4 = Math.max(intrinsicHeight2, intrinsicHeight);
        this.f2918A = iMax3;
        this.f2919B = iMax4;
        super.onMeasure(i4, i5);
        if (getMeasuredHeight() < iMax4) {
            setMeasuredDimension(getMeasuredWidthAndState(), iMax4);
        }
    }

    @Override // android.view.View
    public final void onPopulateAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        super.onPopulateAccessibilityEvent(accessibilityEvent);
        CharSequence charSequence = isChecked() ? this.f2949o : this.f2951q;
        if (charSequence != null) {
            accessibilityEvent.getText().add(charSequence);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:40:0x008d  */
    @Override // android.widget.TextView, android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final boolean onTouchEvent(android.view.MotionEvent r10) throws android.content.res.Resources.NotFoundException {
        /*
            Method dump skipped, instructions count: 326
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.appcompat.widget.SwitchCompat.onTouchEvent(android.view.MotionEvent):boolean");
    }

    @Override // android.widget.TextView
    public void setAllCaps(boolean z4) {
        super.setAllCaps(z4);
        getEmojiTextViewHelper().c(z4);
    }

    @Override // android.widget.CompoundButton, android.widget.Checkable
    public void setChecked(boolean z4) throws Resources.NotFoundException {
        super.setChecked(z4);
        boolean zIsChecked = isChecked();
        if (zIsChecked) {
            Object string = this.f2949o;
            if (string == null) {
                string = getResources().getString(com.stepos.alphame.R.string.abc_capital_on);
            }
            WeakHashMap weakHashMap = K.S.f939a;
            new K.E(com.stepos.alphame.R.id.tag_state_description, 64, 30, 2).b(this, string);
        } else {
            Object string2 = this.f2951q;
            if (string2 == null) {
                string2 = getResources().getString(com.stepos.alphame.R.string.abc_capital_off);
            }
            WeakHashMap weakHashMap2 = K.S.f939a;
            new K.E(com.stepos.alphame.R.id.tag_state_description, 64, 30, 2).b(this, string2);
        }
        IBinder windowToken = getWindowToken();
        float f4 = Property.DEFAULT_FLOAT_VALUE;
        if (windowToken == null || !isLaidOut()) {
            ObjectAnimator objectAnimator = this.f2931N;
            if (objectAnimator != null) {
                objectAnimator.cancel();
            }
            if (zIsChecked) {
                f4 = 1.0f;
            }
            setThumbPosition(f4);
            return;
        }
        if (zIsChecked) {
            f4 = 1.0f;
        }
        ObjectAnimator objectAnimatorOfFloat = ObjectAnimator.ofFloat(this, f2916R, f4);
        this.f2931N = objectAnimatorOfFloat;
        objectAnimatorOfFloat.setDuration(250L);
        this.f2931N.setAutoCancel(true);
        this.f2931N.start();
    }

    @Override // android.widget.TextView
    public void setCustomSelectionActionModeCallback(@Nullable ActionMode.Callback callback) {
        super.setCustomSelectionActionModeCallback(callback);
    }

    public void setEmojiCompatEnabled(boolean z4) {
        getEmojiTextViewHelper().d(z4);
        setTextOnInternal(this.f2949o);
        setTextOffInternal(this.f2951q);
        requestLayout();
    }

    public final void setEnforceSwitchWidth(boolean z4) {
        this.f2925H = z4;
        invalidate();
    }

    @Override // android.widget.TextView
    public void setFilters(@NonNull InputFilter[] inputFilterArr) {
        super.setFilters(getEmojiTextViewHelper().a(inputFilterArr));
    }

    public void setShowText(boolean z4) {
        if (this.f2953s != z4) {
            this.f2953s = z4;
            requestLayout();
            if (z4) {
                d();
            }
        }
    }

    public void setSplitTrack(boolean z4) {
        this.f2948n = z4;
        invalidate();
    }

    public void setSwitchMinWidth(int i4) {
        this.f2946l = i4;
        requestLayout();
    }

    public void setSwitchPadding(int i4) {
        this.f2947m = i4;
        requestLayout();
    }

    public void setSwitchTypeface(Typeface typeface) {
        TextPaint textPaint = this.f2926I;
        if ((textPaint.getTypeface() == null || textPaint.getTypeface().equals(typeface)) && (textPaint.getTypeface() != null || typeface == null)) {
            return;
        }
        textPaint.setTypeface(typeface);
        requestLayout();
        invalidate();
    }

    public void setTextOff(CharSequence charSequence) throws Resources.NotFoundException {
        setTextOffInternal(charSequence);
        requestLayout();
        if (isChecked()) {
            return;
        }
        Object string = this.f2951q;
        if (string == null) {
            string = getResources().getString(com.stepos.alphame.R.string.abc_capital_off);
        }
        WeakHashMap weakHashMap = K.S.f939a;
        new K.E(com.stepos.alphame.R.id.tag_state_description, 64, 30, 2).b(this, string);
    }

    public void setTextOn(CharSequence charSequence) throws Resources.NotFoundException {
        setTextOnInternal(charSequence);
        requestLayout();
        if (isChecked()) {
            Object string = this.f2949o;
            if (string == null) {
                string = getResources().getString(com.stepos.alphame.R.string.abc_capital_on);
            }
            WeakHashMap weakHashMap = K.S.f939a;
            new K.E(com.stepos.alphame.R.id.tag_state_description, 64, 30, 2).b(this, string);
        }
    }

    public void setThumbDrawable(Drawable drawable) {
        Drawable drawable2 = this.f2935a;
        if (drawable2 != null) {
            drawable2.setCallback(null);
        }
        this.f2935a = drawable;
        if (drawable != null) {
            drawable.setCallback(this);
        }
        requestLayout();
    }

    public void setThumbPosition(float f4) {
        this.f2960z = f4;
        invalidate();
    }

    public void setThumbResource(int i4) {
        setThumbDrawable(Z2.I.o(getContext(), i4));
    }

    public void setThumbTextPadding(int i4) {
        this.f2945k = i4;
        requestLayout();
    }

    public void setThumbTintList(@Nullable ColorStateList colorStateList) {
        this.f2936b = colorStateList;
        this.f2938d = true;
        a();
    }

    public void setThumbTintMode(@Nullable PorterDuff.Mode mode) {
        this.f2937c = mode;
        this.f2939e = true;
        a();
    }

    public void setTrackDrawable(Drawable drawable) {
        Drawable drawable2 = this.f2940f;
        if (drawable2 != null) {
            drawable2.setCallback(null);
        }
        this.f2940f = drawable;
        if (drawable != null) {
            drawable.setCallback(this);
        }
        requestLayout();
    }

    public void setTrackResource(int i4) {
        setTrackDrawable(Z2.I.o(getContext(), i4));
    }

    public void setTrackTintList(@Nullable ColorStateList colorStateList) {
        this.f2941g = colorStateList;
        this.f2943i = true;
        b();
    }

    public void setTrackTintMode(@Nullable PorterDuff.Mode mode) {
        this.f2942h = mode;
        this.f2944j = true;
        b();
    }

    @Override // android.widget.CompoundButton, android.widget.Checkable
    public final void toggle() throws Resources.NotFoundException {
        setChecked(!isChecked());
    }

    @Override // android.widget.CompoundButton, android.widget.TextView, android.view.View
    public final boolean verifyDrawable(Drawable drawable) {
        return super.verifyDrawable(drawable) || drawable == this.f2935a || drawable == this.f2940f;
    }
}
