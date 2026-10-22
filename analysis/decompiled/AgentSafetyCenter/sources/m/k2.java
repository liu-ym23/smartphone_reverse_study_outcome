package m;

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
import android.view.ActionMode;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;
import android.widget.CompoundButton;
import java.lang.invoke.VarHandle;
import java.lang.ref.WeakReference;
import java.util.WeakHashMap;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public abstract class k2 extends CompoundButton {
    public static final i2 V = new i2(Float.class, "thumbPos");
    public static final int[] W = {R.attr.state_checked};
    public float A;
    public final VelocityTracker B;
    public final int C;
    public float D;
    public int E;
    public int F;
    public int G;
    public int H;
    public int I;
    public int J;
    public int K;
    public boolean L;
    public final TextPaint M;
    public final ColorStateList N;
    public StaticLayout O;
    public StaticLayout P;
    public final j.a Q;
    public ObjectAnimator R;
    public v S;
    public j2 T;
    public final Rect U;

    /* renamed from: c, reason: collision with root package name */
    public Drawable f7965c;

    /* renamed from: f, reason: collision with root package name */
    public ColorStateList f7966f;

    /* renamed from: g, reason: collision with root package name */
    public PorterDuff.Mode f7967g;

    /* renamed from: h, reason: collision with root package name */
    public boolean f7968h;
    public boolean i;

    /* renamed from: j, reason: collision with root package name */
    public Drawable f7969j;

    /* renamed from: k, reason: collision with root package name */
    public ColorStateList f7970k;

    /* renamed from: l, reason: collision with root package name */
    public PorterDuff.Mode f7971l;

    /* renamed from: m, reason: collision with root package name */
    public boolean f7972m;

    /* renamed from: n, reason: collision with root package name */
    public boolean f7973n;

    /* renamed from: o, reason: collision with root package name */
    public int f7974o;

    /* renamed from: p, reason: collision with root package name */
    public int f7975p;

    /* renamed from: q, reason: collision with root package name */
    public int f7976q;

    /* renamed from: r, reason: collision with root package name */
    public boolean f7977r;

    /* renamed from: s, reason: collision with root package name */
    public CharSequence f7978s;

    /* renamed from: t, reason: collision with root package name */
    public CharSequence f7979t;

    /* renamed from: u, reason: collision with root package name */
    public CharSequence f7980u;

    /* renamed from: v, reason: collision with root package name */
    public CharSequence f7981v;

    /* renamed from: w, reason: collision with root package name */
    public boolean f7982w;

    /* renamed from: x, reason: collision with root package name */
    public int f7983x;

    /* renamed from: y, reason: collision with root package name */
    public final int f7984y;

    /* renamed from: z, reason: collision with root package name */
    public float f7985z;

    public k2(Context context) throws Resources.NotFoundException {
        int resourceId;
        super(context, null, com.stepos.agentsafetycenter.R.attr.switchStyle);
        this.f7966f = null;
        this.f7967g = null;
        this.f7968h = false;
        this.i = false;
        this.f7970k = null;
        this.f7971l = null;
        this.f7972m = false;
        this.f7973n = false;
        this.B = VelocityTracker.obtain();
        this.L = true;
        this.U = new Rect();
        l2.a(this, getContext());
        TextPaint textPaint = new TextPaint(1);
        this.M = textPaint;
        textPaint.density = getResources().getDisplayMetrics().density;
        int[] iArr = g.a.f4118v;
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(null, iArr, com.stepos.agentsafetycenter.R.attr.switchStyle, 0);
        p5.m mVar = new p5.m(context, typedArrayObtainStyledAttributes);
        WeakHashMap weakHashMap = n3.k0.f8724a;
        n3.i0.b(this, context, iArr, null, typedArrayObtainStyledAttributes, com.stepos.agentsafetycenter.R.attr.switchStyle, 0);
        Drawable drawableA = mVar.A(2);
        this.f7965c = drawableA;
        if (drawableA != null) {
            drawableA.setCallback(this);
        }
        Drawable drawableA2 = mVar.A(11);
        this.f7969j = drawableA2;
        if (drawableA2 != null) {
            drawableA2.setCallback(this);
        }
        setTextOnInternal(typedArrayObtainStyledAttributes.getText(0));
        setTextOffInternal(typedArrayObtainStyledAttributes.getText(1));
        this.f7982w = typedArrayObtainStyledAttributes.getBoolean(3, true);
        this.f7974o = typedArrayObtainStyledAttributes.getDimensionPixelSize(8, 0);
        this.f7975p = typedArrayObtainStyledAttributes.getDimensionPixelSize(5, 0);
        this.f7976q = typedArrayObtainStyledAttributes.getDimensionPixelSize(6, 0);
        this.f7977r = typedArrayObtainStyledAttributes.getBoolean(4, false);
        ColorStateList colorStateListZ = mVar.z(9);
        if (colorStateListZ != null) {
            this.f7966f = colorStateListZ;
            this.f7968h = true;
        }
        PorterDuff.Mode modeB = e1.b(typedArrayObtainStyledAttributes.getInt(10, -1), null);
        if (this.f7967g != modeB) {
            this.f7967g = modeB;
            this.i = true;
        }
        if (this.f7968h || this.i) {
            a();
        }
        ColorStateList colorStateListZ2 = mVar.z(12);
        if (colorStateListZ2 != null) {
            this.f7970k = colorStateListZ2;
            this.f7972m = true;
        }
        PorterDuff.Mode modeB2 = e1.b(typedArrayObtainStyledAttributes.getInt(13, -1), null);
        if (this.f7971l != modeB2) {
            this.f7971l = modeB2;
            this.f7973n = true;
        }
        if (this.f7972m || this.f7973n) {
            b();
        }
        int resourceId2 = typedArrayObtainStyledAttributes.getResourceId(7, 0);
        if (resourceId2 != 0) {
            TypedArray typedArrayObtainStyledAttributes2 = context.obtainStyledAttributes(resourceId2, g.a.f4119w);
            ColorStateList colorStateList = (!typedArrayObtainStyledAttributes2.hasValue(3) || (resourceId = typedArrayObtainStyledAttributes2.getResourceId(3, 0)) == 0 || (colorStateList = id.k.u(resourceId, context)) == null) ? typedArrayObtainStyledAttributes2.getColorStateList(3) : colorStateList;
            if (colorStateList != null) {
                this.N = colorStateList;
            } else {
                this.N = getTextColors();
            }
            int dimensionPixelSize = typedArrayObtainStyledAttributes2.getDimensionPixelSize(0, 0);
            if (dimensionPixelSize != 0) {
                float f5 = dimensionPixelSize;
                if (f5 != textPaint.getTextSize()) {
                    textPaint.setTextSize(f5);
                    requestLayout();
                }
            }
            int i = typedArrayObtainStyledAttributes2.getInt(1, -1);
            int i3 = typedArrayObtainStyledAttributes2.getInt(2, -1);
            Typeface typeface = i != 1 ? i != 2 ? i != 3 ? null : Typeface.MONOSPACE : Typeface.SERIF : Typeface.SANS_SERIF;
            if (i3 > 0) {
                Typeface typefaceDefaultFromStyle = typeface == null ? Typeface.defaultFromStyle(i3) : Typeface.create(typeface, i3);
                setSwitchTypeface(typefaceDefaultFromStyle);
                int i10 = (~(typefaceDefaultFromStyle != null ? typefaceDefaultFromStyle.getStyle() : 0)) & i3;
                textPaint.setFakeBoldText((i10 & 1) != 0);
                textPaint.setTextSkewX((2 & i10) != 0 ? -0.25f : 0.0f);
            } else {
                textPaint.setFakeBoldText(false);
                textPaint.setTextSkewX(0.0f);
                setSwitchTypeface(typeface);
            }
            if (typedArrayObtainStyledAttributes2.getBoolean(14, false)) {
                Context context2 = getContext();
                j.a aVar = new j.a();
                aVar.f6370c = context2.getResources().getConfiguration().locale;
                this.Q = aVar;
            } else {
                this.Q = null;
            }
            setTextOnInternal(this.f7978s);
            setTextOffInternal(this.f7980u);
            typedArrayObtainStyledAttributes2.recycle();
        }
        new s0(this).f(null, com.stepos.agentsafetycenter.R.attr.switchStyle);
        mVar.M();
        ViewConfiguration viewConfiguration = ViewConfiguration.get(context);
        this.f7984y = viewConfiguration.getScaledTouchSlop();
        this.C = viewConfiguration.getScaledMinimumFlingVelocity();
        getEmojiTextViewHelper().b(null, com.stepos.agentsafetycenter.R.attr.switchStyle);
        refreshDrawableState();
        setChecked(isChecked());
    }

    private v getEmojiTextViewHelper() {
        if (this.S == null) {
            this.S = new v(this);
        }
        return this.S;
    }

    private boolean getTargetCheckedState() {
        return this.D > 0.5f;
    }

    private int getThumbOffset() {
        int layoutDirection = getLayoutDirection();
        float f5 = this.D;
        if (layoutDirection == 1) {
            f5 = 1.0f - f5;
        }
        return (int) ((f5 * getThumbScrollRange()) + 0.5f);
    }

    private int getThumbScrollRange() {
        Drawable drawable = this.f7969j;
        if (drawable == null) {
            return 0;
        }
        Rect rect = this.U;
        drawable.getPadding(rect);
        Drawable drawable2 = this.f7965c;
        Rect rectA = drawable2 != null ? e1.a(drawable2) : e1.f7901a;
        return ((((this.E - this.G) - rect.left) - rect.right) - rectA.left) - rectA.right;
    }

    private void setTextOffInternal(CharSequence charSequence) {
        this.f7980u = charSequence;
        TransformationMethod transformationMethodK0 = ((ac.a) getEmojiTextViewHelper().f8090b.f19f).k0(this.Q);
        if (transformationMethodK0 != null) {
            charSequence = transformationMethodK0.getTransformation(charSequence, this);
        }
        this.f7981v = charSequence;
        this.P = null;
        if (this.f7982w) {
            d();
        }
    }

    private void setTextOnInternal(CharSequence charSequence) {
        this.f7978s = charSequence;
        TransformationMethod transformationMethodK0 = ((ac.a) getEmojiTextViewHelper().f8090b.f19f).k0(this.Q);
        if (transformationMethodK0 != null) {
            charSequence = transformationMethodK0.getTransformation(charSequence, this);
        }
        this.f7979t = charSequence;
        this.O = null;
        if (this.f7982w) {
            d();
        }
    }

    public final void a() {
        Drawable drawable = this.f7965c;
        if (drawable != null) {
            if (this.f7968h || this.i) {
                Drawable drawableMutate = drawable.mutate();
                this.f7965c = drawableMutate;
                if (this.f7968h) {
                    drawableMutate.setTintList(this.f7966f);
                }
                if (this.i) {
                    this.f7965c.setTintMode(this.f7967g);
                }
                if (this.f7965c.isStateful()) {
                    this.f7965c.setState(getDrawableState());
                }
            }
        }
    }

    public final void b() {
        Drawable drawable = this.f7969j;
        if (drawable != null) {
            if (this.f7972m || this.f7973n) {
                Drawable drawableMutate = drawable.mutate();
                this.f7969j = drawableMutate;
                if (this.f7972m) {
                    drawableMutate.setTintList(this.f7970k);
                }
                if (this.f7973n) {
                    this.f7969j.setTintMode(this.f7971l);
                }
                if (this.f7969j.isStateful()) {
                    this.f7969j.setState(getDrawableState());
                }
            }
        }
    }

    public final void c() {
        setTextOnInternal(this.f7978s);
        setTextOffInternal(this.f7980u);
        requestLayout();
    }

    public final void d() {
        if (this.T == null && ((ac.a) this.S.f8090b.f19f).B() && a4.j.c()) {
            a4.j jVarA = a4.j.a();
            int iB = jVarA.b();
            if (iB == 3 || iB == 0) {
                j2 j2Var = new j2();
                j2Var.f7943c = new WeakReference(this);
                VarHandle.storeStoreFence();
                this.T = j2Var;
                jVarA.g(j2Var);
            }
        }
    }

    @Override // android.view.View
    public final void draw(Canvas canvas) {
        int i;
        int i3;
        int i10 = this.H;
        int i11 = this.I;
        int i12 = this.J;
        int i13 = this.K;
        int thumbOffset = getThumbOffset() + i10;
        Drawable drawable = this.f7965c;
        Rect rectA = drawable != null ? e1.a(drawable) : e1.f7901a;
        Drawable drawable2 = this.f7969j;
        Rect rect = this.U;
        if (drawable2 != null) {
            drawable2.getPadding(rect);
            int i14 = rect.left;
            thumbOffset += i14;
            if (rectA != null) {
                int i15 = rectA.left;
                if (i15 > i14) {
                    i10 += i15 - i14;
                }
                int i16 = rectA.top;
                int i17 = rect.top;
                i = i16 > i17 ? (i16 - i17) + i11 : i11;
                int i18 = rectA.right;
                int i19 = rect.right;
                if (i18 > i19) {
                    i12 -= i18 - i19;
                }
                int i20 = rectA.bottom;
                int i21 = rect.bottom;
                if (i20 > i21) {
                    i3 = i13 - (i20 - i21);
                }
                this.f7969j.setBounds(i10, i, i12, i3);
            } else {
                i = i11;
            }
            i3 = i13;
            this.f7969j.setBounds(i10, i, i12, i3);
        }
        Drawable drawable3 = this.f7965c;
        if (drawable3 != null) {
            drawable3.getPadding(rect);
            int i22 = thumbOffset - rect.left;
            int i23 = thumbOffset + this.G + rect.right;
            this.f7965c.setBounds(i22, i11, i23, i13);
            Drawable background = getBackground();
            if (background != null) {
                background.setHotspotBounds(i22, i11, i23, i13);
            }
        }
        super.draw(canvas);
    }

    @Override // android.widget.CompoundButton, android.widget.TextView, android.view.View
    public final void drawableHotspotChanged(float f5, float f10) {
        super.drawableHotspotChanged(f5, f10);
        Drawable drawable = this.f7965c;
        if (drawable != null) {
            drawable.setHotspot(f5, f10);
        }
        Drawable drawable2 = this.f7969j;
        if (drawable2 != null) {
            drawable2.setHotspot(f5, f10);
        }
    }

    @Override // android.widget.CompoundButton, android.widget.TextView, android.view.View
    public final void drawableStateChanged() {
        super.drawableStateChanged();
        int[] drawableState = getDrawableState();
        Drawable drawable = this.f7965c;
        boolean state = (drawable == null || !drawable.isStateful()) ? false : drawable.setState(drawableState);
        Drawable drawable2 = this.f7969j;
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
        int compoundPaddingLeft = super.getCompoundPaddingLeft() + this.E;
        return !TextUtils.isEmpty(getText()) ? compoundPaddingLeft + this.f7976q : compoundPaddingLeft;
    }

    @Override // android.widget.CompoundButton, android.widget.TextView
    public int getCompoundPaddingRight() {
        if (getLayoutDirection() == 1) {
            return super.getCompoundPaddingRight();
        }
        int compoundPaddingRight = super.getCompoundPaddingRight() + this.E;
        return !TextUtils.isEmpty(getText()) ? compoundPaddingRight + this.f7976q : compoundPaddingRight;
    }

    @Override // android.widget.TextView
    public ActionMode.Callback getCustomSelectionActionModeCallback() {
        return super.getCustomSelectionActionModeCallback();
    }

    public boolean getShowText() {
        return this.f7982w;
    }

    public boolean getSplitTrack() {
        return this.f7977r;
    }

    public int getSwitchMinWidth() {
        return this.f7975p;
    }

    public int getSwitchPadding() {
        return this.f7976q;
    }

    public CharSequence getTextOff() {
        return this.f7980u;
    }

    public CharSequence getTextOn() {
        return this.f7978s;
    }

    public Drawable getThumbDrawable() {
        return this.f7965c;
    }

    public final float getThumbPosition() {
        return this.D;
    }

    public int getThumbTextPadding() {
        return this.f7974o;
    }

    public ColorStateList getThumbTintList() {
        return this.f7966f;
    }

    public PorterDuff.Mode getThumbTintMode() {
        return this.f7967g;
    }

    public Drawable getTrackDrawable() {
        return this.f7969j;
    }

    public ColorStateList getTrackTintList() {
        return this.f7970k;
    }

    public PorterDuff.Mode getTrackTintMode() {
        return this.f7971l;
    }

    @Override // android.widget.CompoundButton, android.widget.TextView, android.view.View
    public final void jumpDrawablesToCurrentState() {
        super.jumpDrawablesToCurrentState();
        Drawable drawable = this.f7965c;
        if (drawable != null) {
            drawable.jumpToCurrentState();
        }
        Drawable drawable2 = this.f7969j;
        if (drawable2 != null) {
            drawable2.jumpToCurrentState();
        }
        ObjectAnimator objectAnimator = this.R;
        if (objectAnimator == null || !objectAnimator.isStarted()) {
            return;
        }
        this.R.end();
        this.R = null;
    }

    @Override // android.widget.CompoundButton, android.widget.TextView, android.view.View
    public final int[] onCreateDrawableState(int i) {
        int[] iArrOnCreateDrawableState = super.onCreateDrawableState(i + 1);
        if (isChecked()) {
            View.mergeDrawableStates(iArrOnCreateDrawableState, W);
        }
        return iArrOnCreateDrawableState;
    }

    @Override // android.widget.CompoundButton, android.widget.TextView, android.view.View
    public final void onDraw(Canvas canvas) {
        int width;
        super.onDraw(canvas);
        Drawable drawable = this.f7969j;
        Rect rect = this.U;
        if (drawable != null) {
            drawable.getPadding(rect);
        } else {
            rect.setEmpty();
        }
        int i = this.I;
        int i3 = this.K;
        int i10 = i + rect.top;
        int i11 = i3 - rect.bottom;
        Drawable drawable2 = this.f7965c;
        if (drawable != null) {
            if (!this.f7977r || drawable2 == null) {
                drawable.draw(canvas);
            } else {
                Rect rectA = e1.a(drawable2);
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
        StaticLayout staticLayout = getTargetCheckedState() ? this.O : this.P;
        if (staticLayout != null) {
            int[] drawableState = getDrawableState();
            TextPaint textPaint = this.M;
            ColorStateList colorStateList = this.N;
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
            canvas.translate((width / 2) - (staticLayout.getWidth() / 2), ((i10 + i11) / 2) - (staticLayout.getHeight() / 2));
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
    public final void onLayout(boolean z10, int i, int i3, int i10, int i11) {
        int iMax;
        int width;
        int paddingLeft;
        int height;
        int paddingTop;
        super.onLayout(z10, i, i3, i10, i11);
        int iMax2 = 0;
        if (this.f7965c != null) {
            Drawable drawable = this.f7969j;
            Rect rect = this.U;
            if (drawable != null) {
                drawable.getPadding(rect);
            } else {
                rect.setEmpty();
            }
            Rect rectA = e1.a(this.f7965c);
            iMax = Math.max(0, rectA.left - rect.left);
            iMax2 = Math.max(0, rectA.right - rect.right);
        } else {
            iMax = 0;
        }
        if (getLayoutDirection() == 1) {
            paddingLeft = getPaddingLeft() + iMax;
            width = ((this.E + paddingLeft) - iMax) - iMax2;
        } else {
            width = (getWidth() - getPaddingRight()) - iMax2;
            paddingLeft = (width - this.E) + iMax + iMax2;
        }
        int gravity = getGravity() & 112;
        if (gravity == 16) {
            int height2 = ((getHeight() + getPaddingTop()) - getPaddingBottom()) / 2;
            int i12 = this.F;
            int i13 = height2 - (i12 / 2);
            height = i12 + i13;
            paddingTop = i13;
        } else if (gravity != 80) {
            paddingTop = getPaddingTop();
            height = this.F + paddingTop;
        } else {
            height = getHeight() - getPaddingBottom();
            paddingTop = height - this.F;
        }
        this.H = paddingLeft;
        this.I = paddingTop;
        this.K = height;
        this.J = width;
    }

    @Override // android.widget.TextView, android.view.View
    public final void onMeasure(int i, int i3) {
        int intrinsicWidth;
        int intrinsicHeight;
        int intrinsicHeight2 = 0;
        if (this.f7982w) {
            StaticLayout staticLayout = this.O;
            TextPaint textPaint = this.M;
            if (staticLayout == null) {
                CharSequence charSequence = this.f7979t;
                this.O = new StaticLayout(charSequence, textPaint, charSequence != null ? (int) Math.ceil(Layout.getDesiredWidth(charSequence, textPaint)) : 0, Layout.Alignment.ALIGN_NORMAL, 1.0f, 0.0f, true);
            }
            if (this.P == null) {
                CharSequence charSequence2 = this.f7981v;
                this.P = new StaticLayout(charSequence2, textPaint, charSequence2 != null ? (int) Math.ceil(Layout.getDesiredWidth(charSequence2, textPaint)) : 0, Layout.Alignment.ALIGN_NORMAL, 1.0f, 0.0f, true);
            }
        }
        Drawable drawable = this.f7965c;
        Rect rect = this.U;
        if (drawable != null) {
            drawable.getPadding(rect);
            intrinsicWidth = (this.f7965c.getIntrinsicWidth() - rect.left) - rect.right;
            intrinsicHeight = this.f7965c.getIntrinsicHeight();
        } else {
            intrinsicWidth = 0;
            intrinsicHeight = 0;
        }
        this.G = Math.max(this.f7982w ? (this.f7974o * 2) + Math.max(this.O.getWidth(), this.P.getWidth()) : 0, intrinsicWidth);
        Drawable drawable2 = this.f7969j;
        if (drawable2 != null) {
            drawable2.getPadding(rect);
            intrinsicHeight2 = this.f7969j.getIntrinsicHeight();
        } else {
            rect.setEmpty();
        }
        int iMax = rect.left;
        int iMax2 = rect.right;
        Drawable drawable3 = this.f7965c;
        if (drawable3 != null) {
            Rect rectA = e1.a(drawable3);
            iMax = Math.max(iMax, rectA.left);
            iMax2 = Math.max(iMax2, rectA.right);
        }
        boolean z10 = this.L;
        int iMax3 = this.f7975p;
        if (z10) {
            iMax3 = Math.max(iMax3, (this.G * 2) + iMax + iMax2);
        }
        int iMax4 = Math.max(intrinsicHeight2, intrinsicHeight);
        this.E = iMax3;
        this.F = iMax4;
        super.onMeasure(i, i3);
        if (getMeasuredHeight() < iMax4) {
            setMeasuredDimension(getMeasuredWidthAndState(), iMax4);
        }
    }

    @Override // android.view.View
    public final void onPopulateAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        super.onPopulateAccessibilityEvent(accessibilityEvent);
        CharSequence charSequence = isChecked() ? this.f7978s : this.f7980u;
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
    public boolean onTouchEvent(android.view.MotionEvent r10) throws android.content.res.Resources.NotFoundException {
        /*
            Method dump skipped, instructions count: 325
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: m.k2.onTouchEvent(android.view.MotionEvent):boolean");
    }

    @Override // android.widget.TextView
    public void setAllCaps(boolean z10) {
        super.setAllCaps(z10);
        getEmojiTextViewHelper().c(z10);
    }

    @Override // android.widget.CompoundButton, android.widget.Checkable
    public void setChecked(boolean z10) throws Resources.NotFoundException {
        super.setChecked(z10);
        boolean zIsChecked = isChecked();
        if (zIsChecked) {
            CharSequence string = this.f7978s;
            if (string == null) {
                string = getResources().getString(com.stepos.agentsafetycenter.R.string.abc_capital_on);
            }
            CharSequence charSequence = string;
            WeakHashMap weakHashMap = n3.k0.f8724a;
            new n3.b0(com.stepos.agentsafetycenter.R.id.tag_state_description, CharSequence.class, 64, 30, 1).f(this, charSequence);
        } else {
            CharSequence string2 = this.f7980u;
            if (string2 == null) {
                string2 = getResources().getString(com.stepos.agentsafetycenter.R.string.abc_capital_off);
            }
            CharSequence charSequence2 = string2;
            WeakHashMap weakHashMap2 = n3.k0.f8724a;
            new n3.b0(com.stepos.agentsafetycenter.R.id.tag_state_description, CharSequence.class, 64, 30, 1).f(this, charSequence2);
        }
        if (getWindowToken() == null || !isLaidOut()) {
            ObjectAnimator objectAnimator = this.R;
            if (objectAnimator != null) {
                objectAnimator.cancel();
            }
            setThumbPosition(zIsChecked ? 1.0f : 0.0f);
            return;
        }
        ObjectAnimator objectAnimatorOfFloat = ObjectAnimator.ofFloat(this, V, zIsChecked ? 1.0f : 0.0f);
        this.R = objectAnimatorOfFloat;
        objectAnimatorOfFloat.setDuration(250L);
        this.R.setAutoCancel(true);
        this.R.start();
    }

    @Override // android.widget.TextView
    public void setCustomSelectionActionModeCallback(ActionMode.Callback callback) {
        super.setCustomSelectionActionModeCallback(callback);
    }

    public void setEmojiCompatEnabled(boolean z10) {
        getEmojiTextViewHelper().d(z10);
        setTextOnInternal(this.f7978s);
        setTextOffInternal(this.f7980u);
        requestLayout();
    }

    public final void setEnforceSwitchWidth(boolean z10) {
        this.L = z10;
        invalidate();
    }

    @Override // android.widget.TextView
    public void setFilters(InputFilter[] inputFilterArr) {
        super.setFilters(getEmojiTextViewHelper().a(inputFilterArr));
    }

    public void setShowText(boolean z10) {
        if (this.f7982w != z10) {
            this.f7982w = z10;
            requestLayout();
            if (z10) {
                d();
            }
        }
    }

    public void setSplitTrack(boolean z10) {
        this.f7977r = z10;
        invalidate();
    }

    public void setSwitchMinWidth(int i) {
        this.f7975p = i;
        requestLayout();
    }

    public void setSwitchPadding(int i) {
        this.f7976q = i;
        requestLayout();
    }

    public void setSwitchTypeface(Typeface typeface) {
        TextPaint textPaint = this.M;
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
        CharSequence string = this.f7980u;
        if (string == null) {
            string = getResources().getString(com.stepos.agentsafetycenter.R.string.abc_capital_off);
        }
        WeakHashMap weakHashMap = n3.k0.f8724a;
        new n3.b0(com.stepos.agentsafetycenter.R.id.tag_state_description, CharSequence.class, 64, 30, 1).f(this, string);
    }

    public void setTextOn(CharSequence charSequence) throws Resources.NotFoundException {
        setTextOnInternal(charSequence);
        requestLayout();
        if (isChecked()) {
            CharSequence string = this.f7978s;
            if (string == null) {
                string = getResources().getString(com.stepos.agentsafetycenter.R.string.abc_capital_on);
            }
            WeakHashMap weakHashMap = n3.k0.f8724a;
            new n3.b0(com.stepos.agentsafetycenter.R.id.tag_state_description, CharSequence.class, 64, 30, 1).f(this, string);
        }
    }

    public void setThumbDrawable(Drawable drawable) {
        Drawable drawable2 = this.f7965c;
        if (drawable2 != null) {
            drawable2.setCallback(null);
        }
        this.f7965c = drawable;
        if (drawable != null) {
            drawable.setCallback(this);
        }
        requestLayout();
    }

    public void setThumbPosition(float f5) {
        this.D = f5;
        invalidate();
    }

    public void setThumbResource(int i) {
        setThumbDrawable(id.k.v(i, getContext()));
    }

    public void setThumbTextPadding(int i) {
        this.f7974o = i;
        requestLayout();
    }

    public void setThumbTintList(ColorStateList colorStateList) {
        this.f7966f = colorStateList;
        this.f7968h = true;
        a();
    }

    public void setThumbTintMode(PorterDuff.Mode mode) {
        this.f7967g = mode;
        this.i = true;
        a();
    }

    public void setTrackDrawable(Drawable drawable) {
        Drawable drawable2 = this.f7969j;
        if (drawable2 != null) {
            drawable2.setCallback(null);
        }
        this.f7969j = drawable;
        if (drawable != null) {
            drawable.setCallback(this);
        }
        requestLayout();
    }

    public void setTrackResource(int i) {
        setTrackDrawable(id.k.v(i, getContext()));
    }

    public void setTrackTintList(ColorStateList colorStateList) {
        this.f7970k = colorStateList;
        this.f7972m = true;
        b();
    }

    public void setTrackTintMode(PorterDuff.Mode mode) {
        this.f7971l = mode;
        this.f7973n = true;
        b();
    }

    @Override // android.widget.CompoundButton, android.widget.TextView, android.view.View
    public final boolean verifyDrawable(Drawable drawable) {
        return super.verifyDrawable(drawable) || drawable == this.f7965c || drawable == this.f7969j;
    }
}
