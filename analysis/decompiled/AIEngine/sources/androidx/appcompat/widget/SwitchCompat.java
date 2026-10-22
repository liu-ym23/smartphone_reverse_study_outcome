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
import android.text.InputFilter;
import android.text.Layout;
import android.text.StaticLayout;
import android.text.TextPaint;
import android.text.TextUtils;
import android.text.method.TransformationMethod;
import android.util.AttributeSet;
import android.util.Property;
import android.view.ActionMode;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;
import android.widget.CompoundButton;
import androidx.emoji2.text.d;
import java.lang.ref.WeakReference;
import java.util.WeakHashMap;
import v0.e0;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public class SwitchCompat extends CompoundButton {
    public static final a U = new a(Float.class, "thumbPos");
    public static final int[] V = {R.attr.state_checked};
    public final VelocityTracker A;
    public final int B;
    public float C;
    public int D;
    public int E;
    public int F;
    public int G;
    public int H;
    public int I;
    public int J;
    public boolean K;
    public final TextPaint L;
    public final ColorStateList M;
    public StaticLayout N;
    public StaticLayout O;
    public final j.a P;
    public ObjectAnimator Q;
    public m R;
    public b S;
    public final Rect T;

    /* renamed from: a, reason: collision with root package name */
    public Drawable f684a;

    /* renamed from: b, reason: collision with root package name */
    public ColorStateList f685b;

    /* renamed from: c, reason: collision with root package name */
    public PorterDuff.Mode f686c;

    /* renamed from: d, reason: collision with root package name */
    public boolean f687d;

    /* renamed from: e, reason: collision with root package name */
    public boolean f688e;
    public Drawable h;

    /* renamed from: j, reason: collision with root package name */
    public ColorStateList f689j;

    /* renamed from: k, reason: collision with root package name */
    public PorterDuff.Mode f690k;

    /* renamed from: l, reason: collision with root package name */
    public boolean f691l;

    /* renamed from: m, reason: collision with root package name */
    public boolean f692m;

    /* renamed from: n, reason: collision with root package name */
    public int f693n;

    /* renamed from: o, reason: collision with root package name */
    public int f694o;

    /* renamed from: p, reason: collision with root package name */
    public int f695p;

    /* renamed from: q, reason: collision with root package name */
    public boolean f696q;
    public CharSequence r;

    /* renamed from: s, reason: collision with root package name */
    public CharSequence f697s;

    /* renamed from: t, reason: collision with root package name */
    public CharSequence f698t;

    /* renamed from: u, reason: collision with root package name */
    public CharSequence f699u;

    /* renamed from: v, reason: collision with root package name */
    public boolean f700v;

    /* renamed from: w, reason: collision with root package name */
    public int f701w;

    /* renamed from: x, reason: collision with root package name */
    public final int f702x;

    /* renamed from: y, reason: collision with root package name */
    public float f703y;
    public float z;

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public class a extends Property<SwitchCompat, Float> {
        @Override // android.util.Property
        public final Float get(SwitchCompat switchCompat) {
            return Float.valueOf(switchCompat.C);
        }

        @Override // android.util.Property
        public final void set(SwitchCompat switchCompat, Float f8) {
            switchCompat.setThumbPosition(f8.floatValue());
        }
    }

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public static class b extends d.f {

        /* renamed from: a, reason: collision with root package name */
        public final WeakReference f704a;

        public b(SwitchCompat switchCompat) {
            this.f704a = new WeakReference(switchCompat);
        }

        @Override // androidx.emoji2.text.d.f
        public final void a() {
            SwitchCompat switchCompat = (SwitchCompat) this.f704a.get();
            if (switchCompat != null) {
                switchCompat.c();
            }
        }

        @Override // androidx.emoji2.text.d.f
        public final void b() {
            SwitchCompat switchCompat = (SwitchCompat) this.f704a.get();
            if (switchCompat != null) {
                switchCompat.c();
            }
        }
    }

    public SwitchCompat(Context context, AttributeSet attributeSet) throws Resources.NotFoundException {
        int resourceId;
        super(context, attributeSet, com.stepos.aiengine.R.attr.switchStyle);
        this.f685b = null;
        this.f686c = null;
        this.f687d = false;
        this.f688e = false;
        this.f689j = null;
        this.f690k = null;
        this.f691l = false;
        this.f692m = false;
        this.A = VelocityTracker.obtain();
        this.K = true;
        this.T = new Rect();
        s0.a(this, getContext());
        TextPaint textPaint = new TextPaint(1);
        this.L = textPaint;
        textPaint.density = getResources().getDisplayMetrics().density;
        int[] iArr = g.a.f8940v;
        x0 x0VarE = x0.e(context, attributeSet, iArr, com.stepos.aiengine.R.attr.switchStyle);
        TypedArray typedArray = x0VarE.f948b;
        WeakHashMap<View, v0.h0> weakHashMap = v0.e0.f13274a;
        e0.h.b(this, context, iArr, attributeSet, typedArray, com.stepos.aiengine.R.attr.switchStyle, 0);
        Drawable drawableB = x0VarE.b(2);
        this.f684a = drawableB;
        if (drawableB != null) {
            drawableB.setCallback(this);
        }
        Drawable drawableB2 = x0VarE.b(11);
        this.h = drawableB2;
        if (drawableB2 != null) {
            drawableB2.setCallback(this);
        }
        setTextOnInternal(typedArray.getText(0));
        setTextOffInternal(typedArray.getText(1));
        this.f700v = typedArray.getBoolean(3, true);
        this.f693n = typedArray.getDimensionPixelSize(8, 0);
        this.f694o = typedArray.getDimensionPixelSize(5, 0);
        this.f695p = typedArray.getDimensionPixelSize(6, 0);
        this.f696q = typedArray.getBoolean(4, false);
        ColorStateList colorStateListA = x0VarE.a(9);
        if (colorStateListA != null) {
            this.f685b = colorStateListA;
            this.f687d = true;
        }
        PorterDuff.Mode modeC = f0.c(typedArray.getInt(10, -1), null);
        if (this.f686c != modeC) {
            this.f686c = modeC;
            this.f688e = true;
        }
        if (this.f687d || this.f688e) {
            a();
        }
        ColorStateList colorStateListA2 = x0VarE.a(12);
        if (colorStateListA2 != null) {
            this.f689j = colorStateListA2;
            this.f691l = true;
        }
        PorterDuff.Mode modeC2 = f0.c(typedArray.getInt(13, -1), null);
        if (this.f690k != modeC2) {
            this.f690k = modeC2;
            this.f692m = true;
        }
        if (this.f691l || this.f692m) {
            b();
        }
        int resourceId2 = typedArray.getResourceId(7, 0);
        if (resourceId2 != 0) {
            TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(resourceId2, g.a.f8941w);
            ColorStateList colorStateList = (!typedArrayObtainStyledAttributes.hasValue(3) || (resourceId = typedArrayObtainStyledAttributes.getResourceId(3, 0)) == 0 || (colorStateList = androidx.core.content.a.b(resourceId, context)) == null) ? typedArrayObtainStyledAttributes.getColorStateList(3) : colorStateList;
            if (colorStateList != null) {
                this.M = colorStateList;
            } else {
                this.M = getTextColors();
            }
            int dimensionPixelSize = typedArrayObtainStyledAttributes.getDimensionPixelSize(0, 0);
            if (dimensionPixelSize != 0) {
                float f8 = dimensionPixelSize;
                if (f8 != textPaint.getTextSize()) {
                    textPaint.setTextSize(f8);
                    requestLayout();
                }
            }
            int i10 = typedArrayObtainStyledAttributes.getInt(1, -1);
            int i11 = typedArrayObtainStyledAttributes.getInt(2, -1);
            Typeface typeface = i10 != 1 ? i10 != 2 ? i10 != 3 ? null : Typeface.MONOSPACE : Typeface.SERIF : Typeface.SANS_SERIF;
            if (i11 > 0) {
                Typeface typefaceDefaultFromStyle = typeface == null ? Typeface.defaultFromStyle(i11) : Typeface.create(typeface, i11);
                setSwitchTypeface(typefaceDefaultFromStyle);
                int i12 = (~(typefaceDefaultFromStyle != null ? typefaceDefaultFromStyle.getStyle() : 0)) & i11;
                textPaint.setFakeBoldText((i12 & 1) != 0);
                textPaint.setTextSkewX((2 & i12) != 0 ? -0.25f : 0.0f);
            } else {
                textPaint.setFakeBoldText(false);
                textPaint.setTextSkewX(0.0f);
                setSwitchTypeface(typeface);
            }
            if (typedArrayObtainStyledAttributes.getBoolean(14, false)) {
                Context context2 = getContext();
                j.a aVar = new j.a();
                aVar.f9623a = context2.getResources().getConfiguration().locale;
                this.P = aVar;
            } else {
                this.P = null;
            }
            setTextOnInternal(this.r);
            setTextOffInternal(this.f698t);
            typedArrayObtainStyledAttributes.recycle();
        }
        new z(this).f(attributeSet, com.stepos.aiengine.R.attr.switchStyle);
        x0VarE.f();
        ViewConfiguration viewConfiguration = ViewConfiguration.get(context);
        this.f702x = viewConfiguration.getScaledTouchSlop();
        this.B = viewConfiguration.getScaledMinimumFlingVelocity();
        getEmojiTextViewHelper().b(attributeSet, com.stepos.aiengine.R.attr.switchStyle);
        refreshDrawableState();
        setChecked(isChecked());
    }

    private m getEmojiTextViewHelper() {
        if (this.R == null) {
            this.R = new m(this);
        }
        return this.R;
    }

    private boolean getTargetCheckedState() {
        return this.C > 0.5f;
    }

    private int getThumbOffset() {
        return (int) (((getLayoutDirection() == 1 ? 1.0f - this.C : this.C) * getThumbScrollRange()) + 0.5f);
    }

    private int getThumbScrollRange() {
        Drawable drawable = this.h;
        if (drawable == null) {
            return 0;
        }
        Rect rect = this.T;
        drawable.getPadding(rect);
        Drawable drawable2 = this.f684a;
        Rect rectB = drawable2 != null ? f0.b(drawable2) : f0.f801c;
        return ((((this.D - this.F) - rect.left) - rect.right) - rectB.left) - rectB.right;
    }

    private void setTextOffInternal(CharSequence charSequence) {
        this.f698t = charSequence;
        TransformationMethod transformationMethodE = getEmojiTextViewHelper().f889b.f9848a.e(this.P);
        if (transformationMethodE != null) {
            charSequence = transformationMethodE.getTransformation(charSequence, this);
        }
        this.f699u = charSequence;
        this.O = null;
        if (this.f700v) {
            d();
        }
    }

    private void setTextOnInternal(CharSequence charSequence) {
        this.r = charSequence;
        TransformationMethod transformationMethodE = getEmojiTextViewHelper().f889b.f9848a.e(this.P);
        if (transformationMethodE != null) {
            charSequence = transformationMethodE.getTransformation(charSequence, this);
        }
        this.f697s = charSequence;
        this.N = null;
        if (this.f700v) {
            d();
        }
    }

    public final void a() {
        Drawable drawable = this.f684a;
        if (drawable != null) {
            if (this.f687d || this.f688e) {
                Drawable drawableMutate = drawable.mutate();
                this.f684a = drawableMutate;
                if (this.f687d) {
                    drawableMutate.setTintList(this.f685b);
                }
                if (this.f688e) {
                    this.f684a.setTintMode(this.f686c);
                }
                if (this.f684a.isStateful()) {
                    this.f684a.setState(getDrawableState());
                }
            }
        }
    }

    public final void b() {
        Drawable drawable = this.h;
        if (drawable != null) {
            if (this.f691l || this.f692m) {
                Drawable drawableMutate = drawable.mutate();
                this.h = drawableMutate;
                if (this.f691l) {
                    drawableMutate.setTintList(this.f689j);
                }
                if (this.f692m) {
                    this.h.setTintMode(this.f690k);
                }
                if (this.h.isStateful()) {
                    this.h.setState(getDrawableState());
                }
            }
        }
    }

    public final void c() {
        setTextOnInternal(this.r);
        setTextOffInternal(this.f698t);
        requestLayout();
    }

    public final void d() {
        if (this.S == null && this.R.f889b.f9848a.b() && androidx.emoji2.text.d.f1927k != null) {
            androidx.emoji2.text.d dVarA = androidx.emoji2.text.d.a();
            int iB = dVarA.b();
            if (iB == 3 || iB == 0) {
                b bVar = new b(this);
                this.S = bVar;
                dVarA.f(bVar);
            }
        }
    }

    @Override // android.view.View
    public final void draw(Canvas canvas) {
        int i10;
        int i11;
        int i12 = this.G;
        int i13 = this.H;
        int i14 = this.I;
        int i15 = this.J;
        int thumbOffset = getThumbOffset() + i12;
        Drawable drawable = this.f684a;
        Rect rectB = drawable != null ? f0.b(drawable) : f0.f801c;
        Drawable drawable2 = this.h;
        Rect rect = this.T;
        if (drawable2 != null) {
            drawable2.getPadding(rect);
            int i16 = rect.left;
            thumbOffset += i16;
            if (rectB != null) {
                int i17 = rectB.left;
                if (i17 > i16) {
                    i12 += i17 - i16;
                }
                int i18 = rectB.top;
                int i19 = rect.top;
                i10 = i18 > i19 ? (i18 - i19) + i13 : i13;
                int i20 = rectB.right;
                int i21 = rect.right;
                if (i20 > i21) {
                    i14 -= i20 - i21;
                }
                int i22 = rectB.bottom;
                int i23 = rect.bottom;
                if (i22 > i23) {
                    i11 = i15 - (i22 - i23);
                }
                this.h.setBounds(i12, i10, i14, i11);
            } else {
                i10 = i13;
            }
            i11 = i15;
            this.h.setBounds(i12, i10, i14, i11);
        }
        Drawable drawable3 = this.f684a;
        if (drawable3 != null) {
            drawable3.getPadding(rect);
            int i24 = thumbOffset - rect.left;
            int i25 = thumbOffset + this.F + rect.right;
            this.f684a.setBounds(i24, i13, i25, i15);
            Drawable background = getBackground();
            if (background != null) {
                background.setHotspotBounds(i24, i13, i25, i15);
            }
        }
        super.draw(canvas);
    }

    @Override // android.widget.CompoundButton, android.widget.TextView, android.view.View
    public final void drawableHotspotChanged(float f8, float f9) {
        super.drawableHotspotChanged(f8, f9);
        Drawable drawable = this.f684a;
        if (drawable != null) {
            drawable.setHotspot(f8, f9);
        }
        Drawable drawable2 = this.h;
        if (drawable2 != null) {
            drawable2.setHotspot(f8, f9);
        }
    }

    @Override // android.widget.CompoundButton, android.widget.TextView, android.view.View
    public final void drawableStateChanged() {
        super.drawableStateChanged();
        int[] drawableState = getDrawableState();
        Drawable drawable = this.f684a;
        boolean state = (drawable == null || !drawable.isStateful()) ? false : drawable.setState(drawableState);
        Drawable drawable2 = this.h;
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
        int compoundPaddingLeft = super.getCompoundPaddingLeft() + this.D;
        return !TextUtils.isEmpty(getText()) ? compoundPaddingLeft + this.f695p : compoundPaddingLeft;
    }

    @Override // android.widget.CompoundButton, android.widget.TextView
    public int getCompoundPaddingRight() {
        if (getLayoutDirection() == 1) {
            return super.getCompoundPaddingRight();
        }
        int compoundPaddingRight = super.getCompoundPaddingRight() + this.D;
        return !TextUtils.isEmpty(getText()) ? compoundPaddingRight + this.f695p : compoundPaddingRight;
    }

    @Override // android.widget.TextView
    public ActionMode.Callback getCustomSelectionActionModeCallback() {
        return androidx.core.widget.e.c(super.getCustomSelectionActionModeCallback());
    }

    public boolean getShowText() {
        return this.f700v;
    }

    public boolean getSplitTrack() {
        return this.f696q;
    }

    public int getSwitchMinWidth() {
        return this.f694o;
    }

    public int getSwitchPadding() {
        return this.f695p;
    }

    public CharSequence getTextOff() {
        return this.f698t;
    }

    public CharSequence getTextOn() {
        return this.r;
    }

    public Drawable getThumbDrawable() {
        return this.f684a;
    }

    public final float getThumbPosition() {
        return this.C;
    }

    public int getThumbTextPadding() {
        return this.f693n;
    }

    public ColorStateList getThumbTintList() {
        return this.f685b;
    }

    public PorterDuff.Mode getThumbTintMode() {
        return this.f686c;
    }

    public Drawable getTrackDrawable() {
        return this.h;
    }

    public ColorStateList getTrackTintList() {
        return this.f689j;
    }

    public PorterDuff.Mode getTrackTintMode() {
        return this.f690k;
    }

    @Override // android.widget.CompoundButton, android.widget.TextView, android.view.View
    public final void jumpDrawablesToCurrentState() {
        super.jumpDrawablesToCurrentState();
        Drawable drawable = this.f684a;
        if (drawable != null) {
            drawable.jumpToCurrentState();
        }
        Drawable drawable2 = this.h;
        if (drawable2 != null) {
            drawable2.jumpToCurrentState();
        }
        ObjectAnimator objectAnimator = this.Q;
        if (objectAnimator == null || !objectAnimator.isStarted()) {
            return;
        }
        this.Q.end();
        this.Q = null;
    }

    @Override // android.widget.CompoundButton, android.widget.TextView, android.view.View
    public final int[] onCreateDrawableState(int i10) {
        int[] iArrOnCreateDrawableState = super.onCreateDrawableState(i10 + 1);
        if (isChecked()) {
            CompoundButton.mergeDrawableStates(iArrOnCreateDrawableState, V);
        }
        return iArrOnCreateDrawableState;
    }

    @Override // android.widget.CompoundButton, android.widget.TextView, android.view.View
    public final void onDraw(Canvas canvas) {
        int width;
        super.onDraw(canvas);
        Drawable drawable = this.h;
        Rect rect = this.T;
        if (drawable != null) {
            drawable.getPadding(rect);
        } else {
            rect.setEmpty();
        }
        int i10 = this.H;
        int i11 = this.J;
        int i12 = i10 + rect.top;
        int i13 = i11 - rect.bottom;
        Drawable drawable2 = this.f684a;
        if (drawable != null) {
            if (!this.f696q || drawable2 == null) {
                drawable.draw(canvas);
            } else {
                Rect rectB = f0.b(drawable2);
                drawable2.copyBounds(rect);
                rect.left += rectB.left;
                rect.right -= rectB.right;
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
        StaticLayout staticLayout = getTargetCheckedState() ? this.N : this.O;
        if (staticLayout != null) {
            int[] drawableState = getDrawableState();
            TextPaint textPaint = this.L;
            ColorStateList colorStateList = this.M;
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
            canvas.translate((width / 2) - (staticLayout.getWidth() / 2), ((i12 + i13) / 2) - (staticLayout.getHeight() / 2));
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
    public final void onLayout(boolean z, int i10, int i11, int i12, int i13) {
        int iMax;
        int width;
        int paddingLeft;
        int height;
        int paddingTop;
        super.onLayout(z, i10, i11, i12, i13);
        int iMax2 = 0;
        if (this.f684a != null) {
            Drawable drawable = this.h;
            Rect rect = this.T;
            if (drawable != null) {
                drawable.getPadding(rect);
            } else {
                rect.setEmpty();
            }
            Rect rectB = f0.b(this.f684a);
            iMax = Math.max(0, rectB.left - rect.left);
            iMax2 = Math.max(0, rectB.right - rect.right);
        } else {
            iMax = 0;
        }
        if (getLayoutDirection() == 1) {
            paddingLeft = getPaddingLeft() + iMax;
            width = ((this.D + paddingLeft) - iMax) - iMax2;
        } else {
            width = (getWidth() - getPaddingRight()) - iMax2;
            paddingLeft = (width - this.D) + iMax + iMax2;
        }
        int gravity = getGravity() & 112;
        if (gravity == 16) {
            int height2 = ((getHeight() + getPaddingTop()) - getPaddingBottom()) / 2;
            int i14 = this.E;
            int i15 = height2 - (i14 / 2);
            height = i14 + i15;
            paddingTop = i15;
        } else if (gravity != 80) {
            paddingTop = getPaddingTop();
            height = this.E + paddingTop;
        } else {
            height = getHeight() - getPaddingBottom();
            paddingTop = height - this.E;
        }
        this.G = paddingLeft;
        this.H = paddingTop;
        this.J = height;
        this.I = width;
    }

    @Override // android.widget.TextView, android.view.View
    public final void onMeasure(int i10, int i11) {
        int intrinsicWidth;
        int intrinsicHeight;
        int intrinsicHeight2 = 0;
        if (this.f700v) {
            StaticLayout staticLayout = this.N;
            TextPaint textPaint = this.L;
            if (staticLayout == null) {
                CharSequence charSequence = this.f697s;
                this.N = new StaticLayout(charSequence, textPaint, charSequence != null ? (int) Math.ceil(Layout.getDesiredWidth(charSequence, textPaint)) : 0, Layout.Alignment.ALIGN_NORMAL, 1.0f, 0.0f, true);
            }
            if (this.O == null) {
                CharSequence charSequence2 = this.f699u;
                this.O = new StaticLayout(charSequence2, textPaint, charSequence2 != null ? (int) Math.ceil(Layout.getDesiredWidth(charSequence2, textPaint)) : 0, Layout.Alignment.ALIGN_NORMAL, 1.0f, 0.0f, true);
            }
        }
        Drawable drawable = this.f684a;
        Rect rect = this.T;
        if (drawable != null) {
            drawable.getPadding(rect);
            intrinsicWidth = (this.f684a.getIntrinsicWidth() - rect.left) - rect.right;
            intrinsicHeight = this.f684a.getIntrinsicHeight();
        } else {
            intrinsicWidth = 0;
            intrinsicHeight = 0;
        }
        this.F = Math.max(this.f700v ? (this.f693n * 2) + Math.max(this.N.getWidth(), this.O.getWidth()) : 0, intrinsicWidth);
        Drawable drawable2 = this.h;
        if (drawable2 != null) {
            drawable2.getPadding(rect);
            intrinsicHeight2 = this.h.getIntrinsicHeight();
        } else {
            rect.setEmpty();
        }
        int iMax = rect.left;
        int iMax2 = rect.right;
        Drawable drawable3 = this.f684a;
        if (drawable3 != null) {
            Rect rectB = f0.b(drawable3);
            iMax = Math.max(iMax, rectB.left);
            iMax2 = Math.max(iMax2, rectB.right);
        }
        int iMax3 = this.K ? Math.max(this.f694o, (this.F * 2) + iMax + iMax2) : this.f694o;
        int iMax4 = Math.max(intrinsicHeight2, intrinsicHeight);
        this.D = iMax3;
        this.E = iMax4;
        super.onMeasure(i10, i11);
        if (getMeasuredHeight() < iMax4) {
            setMeasuredDimension(getMeasuredWidthAndState(), iMax4);
        }
    }

    @Override // android.view.View
    public final void onPopulateAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        super.onPopulateAccessibilityEvent(accessibilityEvent);
        CharSequence charSequence = isChecked() ? this.r : this.f698t;
        if (charSequence != null) {
            accessibilityEvent.getText().add(charSequence);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:40:0x008c  */
    @Override // android.widget.TextView, android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final boolean onTouchEvent(android.view.MotionEvent r10) throws android.content.res.Resources.NotFoundException {
        /*
            Method dump skipped, instructions count: 325
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.appcompat.widget.SwitchCompat.onTouchEvent(android.view.MotionEvent):boolean");
    }

    @Override // android.widget.TextView
    public void setAllCaps(boolean z) {
        super.setAllCaps(z);
        getEmojiTextViewHelper().c(z);
    }

    @Override // android.widget.CompoundButton, android.widget.Checkable
    public void setChecked(boolean z) throws Resources.NotFoundException {
        super.setChecked(z);
        boolean zIsChecked = isChecked();
        if (zIsChecked) {
            Object string = this.r;
            if (string == null) {
                string = getResources().getString(com.stepos.aiengine.R.string.abc_capital_on);
            }
            WeakHashMap<View, v0.h0> weakHashMap = v0.e0.f13274a;
            new v0.c0(com.stepos.aiengine.R.id.tag_state_description, CharSequence.class, 64, 30).c(this, string);
        } else {
            Object string2 = this.f698t;
            if (string2 == null) {
                string2 = getResources().getString(com.stepos.aiengine.R.string.abc_capital_off);
            }
            WeakHashMap<View, v0.h0> weakHashMap2 = v0.e0.f13274a;
            new v0.c0(com.stepos.aiengine.R.id.tag_state_description, CharSequence.class, 64, 30).c(this, string2);
        }
        if (getWindowToken() == null || !isLaidOut()) {
            ObjectAnimator objectAnimator = this.Q;
            if (objectAnimator != null) {
                objectAnimator.cancel();
            }
            setThumbPosition(zIsChecked ? 1.0f : 0.0f);
            return;
        }
        ObjectAnimator objectAnimatorOfFloat = ObjectAnimator.ofFloat(this, U, zIsChecked ? 1.0f : 0.0f);
        this.Q = objectAnimatorOfFloat;
        objectAnimatorOfFloat.setDuration(250L);
        this.Q.setAutoCancel(true);
        this.Q.start();
    }

    @Override // android.widget.TextView
    public void setCustomSelectionActionModeCallback(ActionMode.Callback callback) {
        super.setCustomSelectionActionModeCallback(callback);
    }

    public void setEmojiCompatEnabled(boolean z) {
        getEmojiTextViewHelper().d(z);
        setTextOnInternal(this.r);
        setTextOffInternal(this.f698t);
        requestLayout();
    }

    public final void setEnforceSwitchWidth(boolean z) {
        this.K = z;
        invalidate();
    }

    @Override // android.widget.TextView
    public void setFilters(InputFilter[] inputFilterArr) {
        super.setFilters(getEmojiTextViewHelper().a(inputFilterArr));
    }

    public void setShowText(boolean z) {
        if (this.f700v != z) {
            this.f700v = z;
            requestLayout();
            if (z) {
                d();
            }
        }
    }

    public void setSplitTrack(boolean z) {
        this.f696q = z;
        invalidate();
    }

    public void setSwitchMinWidth(int i10) {
        this.f694o = i10;
        requestLayout();
    }

    public void setSwitchPadding(int i10) {
        this.f695p = i10;
        requestLayout();
    }

    public void setSwitchTypeface(Typeface typeface) {
        TextPaint textPaint = this.L;
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
        Object string = this.f698t;
        if (string == null) {
            string = getResources().getString(com.stepos.aiengine.R.string.abc_capital_off);
        }
        WeakHashMap<View, v0.h0> weakHashMap = v0.e0.f13274a;
        new v0.c0(com.stepos.aiengine.R.id.tag_state_description, CharSequence.class, 64, 30).c(this, string);
    }

    public void setTextOn(CharSequence charSequence) throws Resources.NotFoundException {
        setTextOnInternal(charSequence);
        requestLayout();
        if (isChecked()) {
            Object string = this.r;
            if (string == null) {
                string = getResources().getString(com.stepos.aiengine.R.string.abc_capital_on);
            }
            WeakHashMap<View, v0.h0> weakHashMap = v0.e0.f13274a;
            new v0.c0(com.stepos.aiengine.R.id.tag_state_description, CharSequence.class, 64, 30).c(this, string);
        }
    }

    public void setThumbDrawable(Drawable drawable) {
        Drawable drawable2 = this.f684a;
        if (drawable2 != null) {
            drawable2.setCallback(null);
        }
        this.f684a = drawable;
        if (drawable != null) {
            drawable.setCallback(this);
        }
        requestLayout();
    }

    public void setThumbPosition(float f8) {
        this.C = f8;
        invalidate();
    }

    public void setThumbResource(int i10) {
        setThumbDrawable(androidx.datastore.preferences.protobuf.b1.L(i10, getContext()));
    }

    public void setThumbTextPadding(int i10) {
        this.f693n = i10;
        requestLayout();
    }

    public void setThumbTintList(ColorStateList colorStateList) {
        this.f685b = colorStateList;
        this.f687d = true;
        a();
    }

    public void setThumbTintMode(PorterDuff.Mode mode) {
        this.f686c = mode;
        this.f688e = true;
        a();
    }

    public void setTrackDrawable(Drawable drawable) {
        Drawable drawable2 = this.h;
        if (drawable2 != null) {
            drawable2.setCallback(null);
        }
        this.h = drawable;
        if (drawable != null) {
            drawable.setCallback(this);
        }
        requestLayout();
    }

    public void setTrackResource(int i10) {
        setTrackDrawable(androidx.datastore.preferences.protobuf.b1.L(i10, getContext()));
    }

    public void setTrackTintList(ColorStateList colorStateList) {
        this.f689j = colorStateList;
        this.f691l = true;
        b();
    }

    public void setTrackTintMode(PorterDuff.Mode mode) {
        this.f690k = mode;
        this.f692m = true;
        b();
    }

    @Override // android.widget.CompoundButton, android.widget.Checkable
    public final void toggle() throws Resources.NotFoundException {
        setChecked(!isChecked());
    }

    @Override // android.widget.CompoundButton, android.widget.TextView, android.view.View
    public final boolean verifyDrawable(Drawable drawable) {
        return super.verifyDrawable(drawable) || drawable == this.f684a || drawable == this.h;
    }
}
