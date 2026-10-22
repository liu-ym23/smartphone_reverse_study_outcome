package androidx.appcompat.widget;

import android.R;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
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
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;
import android.widget.CompoundButton;
import androidx.emoji2.text.e;
import g.C0728a;
import h.C0744a;
import java.lang.ref.Reference;
import java.lang.ref.WeakReference;
import k.C0794a;

/* loaded from: classes.dex */
public class SwitchCompat extends CompoundButton {

    /* renamed from: V, reason: collision with root package name */
    private static final Property<SwitchCompat, Float> f8303V = new a(Float.class, "thumbPos");

    /* renamed from: W, reason: collision with root package name */
    private static final int[] f8304W = {R.attr.state_checked};

    /* renamed from: A, reason: collision with root package name */
    private int f8305A;

    /* renamed from: B, reason: collision with root package name */
    private int f8306B;

    /* renamed from: C, reason: collision with root package name */
    private int f8307C;

    /* renamed from: D, reason: collision with root package name */
    private int f8308D;

    /* renamed from: E, reason: collision with root package name */
    private int f8309E;

    /* renamed from: F, reason: collision with root package name */
    private int f8310F;

    /* renamed from: G, reason: collision with root package name */
    private int f8311G;

    /* renamed from: H, reason: collision with root package name */
    private boolean f8312H;

    /* renamed from: I, reason: collision with root package name */
    private final TextPaint f8313I;

    /* renamed from: J, reason: collision with root package name */
    private ColorStateList f8314J;

    /* renamed from: K, reason: collision with root package name */
    private Layout f8315K;

    /* renamed from: L, reason: collision with root package name */
    private Layout f8316L;

    /* renamed from: M, reason: collision with root package name */
    private TransformationMethod f8317M;

    /* renamed from: Q, reason: collision with root package name */
    ObjectAnimator f8318Q;

    /* renamed from: R, reason: collision with root package name */
    private final C f8319R;

    /* renamed from: S, reason: collision with root package name */
    private C0444n f8320S;

    /* renamed from: T, reason: collision with root package name */
    private b f8321T;

    /* renamed from: U, reason: collision with root package name */
    private final Rect f8322U;

    /* renamed from: a, reason: collision with root package name */
    private Drawable f8323a;

    /* renamed from: b, reason: collision with root package name */
    private ColorStateList f8324b;

    /* renamed from: c, reason: collision with root package name */
    private PorterDuff.Mode f8325c;

    /* renamed from: d, reason: collision with root package name */
    private boolean f8326d;

    /* renamed from: e, reason: collision with root package name */
    private boolean f8327e;

    /* renamed from: f, reason: collision with root package name */
    private Drawable f8328f;

    /* renamed from: g, reason: collision with root package name */
    private ColorStateList f8329g;

    /* renamed from: h, reason: collision with root package name */
    private PorterDuff.Mode f8330h;

    /* renamed from: i, reason: collision with root package name */
    private boolean f8331i;

    /* renamed from: j, reason: collision with root package name */
    private boolean f8332j;

    /* renamed from: k, reason: collision with root package name */
    private int f8333k;

    /* renamed from: l, reason: collision with root package name */
    private int f8334l;

    /* renamed from: m, reason: collision with root package name */
    private int f8335m;

    /* renamed from: n, reason: collision with root package name */
    private boolean f8336n;

    /* renamed from: o, reason: collision with root package name */
    private CharSequence f8337o;

    /* renamed from: p, reason: collision with root package name */
    private CharSequence f8338p;

    /* renamed from: q, reason: collision with root package name */
    private CharSequence f8339q;

    /* renamed from: r, reason: collision with root package name */
    private CharSequence f8340r;

    /* renamed from: s, reason: collision with root package name */
    private boolean f8341s;

    /* renamed from: t, reason: collision with root package name */
    private int f8342t;

    /* renamed from: u, reason: collision with root package name */
    private int f8343u;

    /* renamed from: v, reason: collision with root package name */
    private float f8344v;

    /* renamed from: w, reason: collision with root package name */
    private float f8345w;

    /* renamed from: x, reason: collision with root package name */
    private VelocityTracker f8346x;

    /* renamed from: y, reason: collision with root package name */
    private int f8347y;

    /* renamed from: z, reason: collision with root package name */
    float f8348z;

    class a extends Property<SwitchCompat, Float> {
        a(Class cls, String str) {
            super(cls, str);
        }

        @Override // android.util.Property
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public Float get(SwitchCompat switchCompat) {
            return Float.valueOf(switchCompat.f8348z);
        }

        @Override // android.util.Property
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public void set(SwitchCompat switchCompat, Float f5) {
            switchCompat.setThumbPosition(f5.floatValue());
        }
    }

    static class b extends e.f {

        /* renamed from: a, reason: collision with root package name */
        private final Reference<SwitchCompat> f8349a;

        b(SwitchCompat switchCompat) {
            this.f8349a = new WeakReference(switchCompat);
        }

        @Override // androidx.emoji2.text.e.f
        public void a(Throwable th) {
            SwitchCompat switchCompat = this.f8349a.get();
            if (switchCompat != null) {
                switchCompat.j();
            }
        }

        @Override // androidx.emoji2.text.e.f
        public void b() {
            SwitchCompat switchCompat = this.f8349a.get();
            if (switchCompat != null) {
                switchCompat.j();
            }
        }
    }

    public SwitchCompat(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, C0728a.f16819P);
    }

    private void a(boolean z5) {
        ObjectAnimator objectAnimatorOfFloat = ObjectAnimator.ofFloat(this, f8303V, z5 ? 1.0f : 0.0f);
        this.f8318Q = objectAnimatorOfFloat;
        objectAnimatorOfFloat.setDuration(250L);
        this.f8318Q.setAutoCancel(true);
        this.f8318Q.start();
    }

    private void b() {
        Drawable drawable = this.f8323a;
        if (drawable != null) {
            if (this.f8326d || this.f8327e) {
                Drawable drawableMutate = androidx.core.graphics.drawable.a.r(drawable).mutate();
                this.f8323a = drawableMutate;
                if (this.f8326d) {
                    androidx.core.graphics.drawable.a.o(drawableMutate, this.f8324b);
                }
                if (this.f8327e) {
                    androidx.core.graphics.drawable.a.p(this.f8323a, this.f8325c);
                }
                if (this.f8323a.isStateful()) {
                    this.f8323a.setState(getDrawableState());
                }
            }
        }
    }

    private void c() {
        Drawable drawable = this.f8328f;
        if (drawable != null) {
            if (this.f8331i || this.f8332j) {
                Drawable drawableMutate = androidx.core.graphics.drawable.a.r(drawable).mutate();
                this.f8328f = drawableMutate;
                if (this.f8331i) {
                    androidx.core.graphics.drawable.a.o(drawableMutate, this.f8329g);
                }
                if (this.f8332j) {
                    androidx.core.graphics.drawable.a.p(this.f8328f, this.f8330h);
                }
                if (this.f8328f.isStateful()) {
                    this.f8328f.setState(getDrawableState());
                }
            }
        }
    }

    private void d() {
        ObjectAnimator objectAnimator = this.f8318Q;
        if (objectAnimator != null) {
            objectAnimator.cancel();
        }
    }

    private void e(MotionEvent motionEvent) {
        MotionEvent motionEventObtain = MotionEvent.obtain(motionEvent);
        motionEventObtain.setAction(3);
        super.onTouchEvent(motionEventObtain);
        motionEventObtain.recycle();
    }

    private static float f(float f5, float f6, float f7) {
        return f5 < f6 ? f6 : f5 > f7 ? f7 : f5;
    }

    private CharSequence g(CharSequence charSequence) {
        TransformationMethod transformationMethodF = getEmojiTextViewHelper().f(this.f8317M);
        return transformationMethodF != null ? transformationMethodF.getTransformation(charSequence, this) : charSequence;
    }

    private C0444n getEmojiTextViewHelper() {
        if (this.f8320S == null) {
            this.f8320S = new C0444n(this);
        }
        return this.f8320S;
    }

    private boolean getTargetCheckedState() {
        return this.f8348z > 0.5f;
    }

    private int getThumbOffset() {
        return (int) (((h0.b(this) ? 1.0f - this.f8348z : this.f8348z) * getThumbScrollRange()) + 0.5f);
    }

    private int getThumbScrollRange() {
        Drawable drawable = this.f8328f;
        if (drawable == null) {
            return 0;
        }
        Rect rect = this.f8322U;
        drawable.getPadding(rect);
        Drawable drawable2 = this.f8323a;
        Rect rectC = drawable2 != null ? I.c(drawable2) : I.f8143c;
        return ((((this.f8305A - this.f8307C) - rect.left) - rect.right) - rectC.left) - rectC.right;
    }

    private boolean h(float f5, float f6) {
        if (this.f8323a == null) {
            return false;
        }
        int thumbOffset = getThumbOffset();
        this.f8323a.getPadding(this.f8322U);
        int i5 = this.f8309E;
        int i6 = this.f8343u;
        int i7 = i5 - i6;
        int i8 = (this.f8308D + thumbOffset) - i6;
        int i9 = this.f8307C + i8;
        Rect rect = this.f8322U;
        return f5 > ((float) i8) && f5 < ((float) (((i9 + rect.left) + rect.right) + i6)) && f6 > ((float) i7) && f6 < ((float) (this.f8311G + i6));
    }

    private Layout i(CharSequence charSequence) {
        return new StaticLayout(charSequence, this.f8313I, charSequence != null ? (int) Math.ceil(Layout.getDesiredWidth(charSequence, r2)) : 0, Layout.Alignment.ALIGN_NORMAL, 1.0f, 0.0f, true);
    }

    private void k() throws Resources.NotFoundException {
        CharSequence string = this.f8339q;
        if (string == null) {
            string = getResources().getString(g.h.f16964c);
        }
        androidx.core.view.H.C0(this, string);
    }

    private void l() throws Resources.NotFoundException {
        CharSequence string = this.f8337o;
        if (string == null) {
            string = getResources().getString(g.h.f16965d);
        }
        androidx.core.view.H.C0(this, string);
    }

    private void o(int i5, int i6) {
        n(i5 != 1 ? i5 != 2 ? i5 != 3 ? null : Typeface.MONOSPACE : Typeface.SERIF : Typeface.SANS_SERIF, i6);
    }

    private void p() {
        if (this.f8321T == null && this.f8320S.b() && androidx.emoji2.text.e.i()) {
            androidx.emoji2.text.e eVarC = androidx.emoji2.text.e.c();
            int iE = eVarC.e();
            if (iE == 3 || iE == 0) {
                b bVar = new b(this);
                this.f8321T = bVar;
                eVarC.t(bVar);
            }
        }
    }

    private void q(MotionEvent motionEvent) throws Resources.NotFoundException {
        this.f8342t = 0;
        boolean targetCheckedState = true;
        boolean z5 = motionEvent.getAction() == 1 && isEnabled();
        boolean zIsChecked = isChecked();
        if (z5) {
            this.f8346x.computeCurrentVelocity(1000);
            float xVelocity = this.f8346x.getXVelocity();
            if (Math.abs(xVelocity) <= this.f8347y) {
                targetCheckedState = getTargetCheckedState();
            } else if (!h0.b(this) ? xVelocity <= 0.0f : xVelocity >= 0.0f) {
                targetCheckedState = false;
            }
        } else {
            targetCheckedState = zIsChecked;
        }
        if (targetCheckedState != zIsChecked) {
            playSoundEffect(0);
        }
        setChecked(targetCheckedState);
        e(motionEvent);
    }

    private void setTextOffInternal(CharSequence charSequence) {
        this.f8339q = charSequence;
        this.f8340r = g(charSequence);
        this.f8316L = null;
        if (this.f8341s) {
            p();
        }
    }

    private void setTextOnInternal(CharSequence charSequence) {
        this.f8337o = charSequence;
        this.f8338p = g(charSequence);
        this.f8315K = null;
        if (this.f8341s) {
            p();
        }
    }

    @Override // android.view.View
    public void draw(Canvas canvas) {
        int i5;
        int i6;
        Rect rect = this.f8322U;
        int i7 = this.f8308D;
        int i8 = this.f8309E;
        int i9 = this.f8310F;
        int i10 = this.f8311G;
        int thumbOffset = getThumbOffset() + i7;
        Drawable drawable = this.f8323a;
        Rect rectC = drawable != null ? I.c(drawable) : I.f8143c;
        Drawable drawable2 = this.f8328f;
        if (drawable2 != null) {
            drawable2.getPadding(rect);
            int i11 = rect.left;
            thumbOffset += i11;
            if (rectC != null) {
                int i12 = rectC.left;
                if (i12 > i11) {
                    i7 += i12 - i11;
                }
                int i13 = rectC.top;
                int i14 = rect.top;
                i5 = i13 > i14 ? (i13 - i14) + i8 : i8;
                int i15 = rectC.right;
                int i16 = rect.right;
                if (i15 > i16) {
                    i9 -= i15 - i16;
                }
                int i17 = rectC.bottom;
                int i18 = rect.bottom;
                if (i17 > i18) {
                    i6 = i10 - (i17 - i18);
                }
                this.f8328f.setBounds(i7, i5, i9, i6);
            } else {
                i5 = i8;
            }
            i6 = i10;
            this.f8328f.setBounds(i7, i5, i9, i6);
        }
        Drawable drawable3 = this.f8323a;
        if (drawable3 != null) {
            drawable3.getPadding(rect);
            int i19 = thumbOffset - rect.left;
            int i20 = thumbOffset + this.f8307C + rect.right;
            this.f8323a.setBounds(i19, i8, i20, i10);
            Drawable background = getBackground();
            if (background != null) {
                androidx.core.graphics.drawable.a.l(background, i19, i8, i20, i10);
            }
        }
        super.draw(canvas);
    }

    @Override // android.widget.CompoundButton, android.widget.TextView, android.view.View
    public void drawableHotspotChanged(float f5, float f6) {
        super.drawableHotspotChanged(f5, f6);
        Drawable drawable = this.f8323a;
        if (drawable != null) {
            androidx.core.graphics.drawable.a.k(drawable, f5, f6);
        }
        Drawable drawable2 = this.f8328f;
        if (drawable2 != null) {
            androidx.core.graphics.drawable.a.k(drawable2, f5, f6);
        }
    }

    @Override // android.widget.CompoundButton, android.widget.TextView, android.view.View
    protected void drawableStateChanged() {
        super.drawableStateChanged();
        int[] drawableState = getDrawableState();
        Drawable drawable = this.f8323a;
        boolean state = (drawable == null || !drawable.isStateful()) ? false : drawable.setState(drawableState);
        Drawable drawable2 = this.f8328f;
        if (drawable2 != null && drawable2.isStateful()) {
            state |= drawable2.setState(drawableState);
        }
        if (state) {
            invalidate();
        }
    }

    @Override // android.widget.CompoundButton, android.widget.TextView
    public int getCompoundPaddingLeft() {
        if (!h0.b(this)) {
            return super.getCompoundPaddingLeft();
        }
        int compoundPaddingLeft = super.getCompoundPaddingLeft() + this.f8305A;
        return !TextUtils.isEmpty(getText()) ? compoundPaddingLeft + this.f8335m : compoundPaddingLeft;
    }

    @Override // android.widget.CompoundButton, android.widget.TextView
    public int getCompoundPaddingRight() {
        if (h0.b(this)) {
            return super.getCompoundPaddingRight();
        }
        int compoundPaddingRight = super.getCompoundPaddingRight() + this.f8305A;
        return !TextUtils.isEmpty(getText()) ? compoundPaddingRight + this.f8335m : compoundPaddingRight;
    }

    @Override // android.widget.TextView
    public ActionMode.Callback getCustomSelectionActionModeCallback() {
        return androidx.core.widget.i.o(super.getCustomSelectionActionModeCallback());
    }

    public boolean getShowText() {
        return this.f8341s;
    }

    public boolean getSplitTrack() {
        return this.f8336n;
    }

    public int getSwitchMinWidth() {
        return this.f8334l;
    }

    public int getSwitchPadding() {
        return this.f8335m;
    }

    public CharSequence getTextOff() {
        return this.f8339q;
    }

    public CharSequence getTextOn() {
        return this.f8337o;
    }

    public Drawable getThumbDrawable() {
        return this.f8323a;
    }

    protected final float getThumbPosition() {
        return this.f8348z;
    }

    public int getThumbTextPadding() {
        return this.f8333k;
    }

    public ColorStateList getThumbTintList() {
        return this.f8324b;
    }

    public PorterDuff.Mode getThumbTintMode() {
        return this.f8325c;
    }

    public Drawable getTrackDrawable() {
        return this.f8328f;
    }

    public ColorStateList getTrackTintList() {
        return this.f8329g;
    }

    public PorterDuff.Mode getTrackTintMode() {
        return this.f8330h;
    }

    void j() {
        setTextOnInternal(this.f8337o);
        setTextOffInternal(this.f8339q);
        requestLayout();
    }

    @Override // android.widget.CompoundButton, android.widget.TextView, android.view.View
    public void jumpDrawablesToCurrentState() {
        super.jumpDrawablesToCurrentState();
        Drawable drawable = this.f8323a;
        if (drawable != null) {
            drawable.jumpToCurrentState();
        }
        Drawable drawable2 = this.f8328f;
        if (drawable2 != null) {
            drawable2.jumpToCurrentState();
        }
        ObjectAnimator objectAnimator = this.f8318Q;
        if (objectAnimator == null || !objectAnimator.isStarted()) {
            return;
        }
        this.f8318Q.end();
        this.f8318Q = null;
    }

    public void m(Context context, int i5) {
        a0 a0VarT = a0.t(context, i5, g.j.f16995C2);
        ColorStateList colorStateListC = a0VarT.c(g.j.f17015G2);
        if (colorStateListC != null) {
            this.f8314J = colorStateListC;
        } else {
            this.f8314J = getTextColors();
        }
        int iF = a0VarT.f(g.j.f17000D2, 0);
        if (iF != 0) {
            float f5 = iF;
            if (f5 != this.f8313I.getTextSize()) {
                this.f8313I.setTextSize(f5);
                requestLayout();
            }
        }
        o(a0VarT.k(g.j.f17005E2, -1), a0VarT.k(g.j.f17010F2, -1));
        if (a0VarT.a(g.j.f17061R2, false)) {
            this.f8317M = new C0794a(getContext());
        } else {
            this.f8317M = null;
        }
        setTextOnInternal(this.f8337o);
        setTextOffInternal(this.f8339q);
        a0VarT.x();
    }

    public void n(Typeface typeface, int i5) {
        if (i5 <= 0) {
            this.f8313I.setFakeBoldText(false);
            this.f8313I.setTextSkewX(0.0f);
            setSwitchTypeface(typeface);
        } else {
            Typeface typefaceDefaultFromStyle = typeface == null ? Typeface.defaultFromStyle(i5) : Typeface.create(typeface, i5);
            setSwitchTypeface(typefaceDefaultFromStyle);
            int i6 = (~(typefaceDefaultFromStyle != null ? typefaceDefaultFromStyle.getStyle() : 0)) & i5;
            this.f8313I.setFakeBoldText((i6 & 1) != 0);
            this.f8313I.setTextSkewX((i6 & 2) != 0 ? -0.25f : 0.0f);
        }
    }

    @Override // android.widget.CompoundButton, android.widget.TextView, android.view.View
    protected int[] onCreateDrawableState(int i5) {
        int[] iArrOnCreateDrawableState = super.onCreateDrawableState(i5 + 1);
        if (isChecked()) {
            View.mergeDrawableStates(iArrOnCreateDrawableState, f8304W);
        }
        return iArrOnCreateDrawableState;
    }

    @Override // android.widget.CompoundButton, android.widget.TextView, android.view.View
    protected void onDraw(Canvas canvas) {
        int width;
        super.onDraw(canvas);
        Rect rect = this.f8322U;
        Drawable drawable = this.f8328f;
        if (drawable != null) {
            drawable.getPadding(rect);
        } else {
            rect.setEmpty();
        }
        int i5 = this.f8309E;
        int i6 = this.f8311G;
        int i7 = i5 + rect.top;
        int i8 = i6 - rect.bottom;
        Drawable drawable2 = this.f8323a;
        if (drawable != null) {
            if (!this.f8336n || drawable2 == null) {
                drawable.draw(canvas);
            } else {
                Rect rectC = I.c(drawable2);
                drawable2.copyBounds(rect);
                rect.left += rectC.left;
                rect.right -= rectC.right;
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
        Layout layout = getTargetCheckedState() ? this.f8315K : this.f8316L;
        if (layout != null) {
            int[] drawableState = getDrawableState();
            ColorStateList colorStateList = this.f8314J;
            if (colorStateList != null) {
                this.f8313I.setColor(colorStateList.getColorForState(drawableState, 0));
            }
            this.f8313I.drawableState = drawableState;
            if (drawable2 != null) {
                Rect bounds = drawable2.getBounds();
                width = bounds.left + bounds.right;
            } else {
                width = getWidth();
            }
            canvas.translate((width / 2) - (layout.getWidth() / 2), ((i7 + i8) / 2) - (layout.getHeight() / 2));
            layout.draw(canvas);
        }
        canvas.restoreToCount(iSave2);
    }

    @Override // android.view.View
    public void onInitializeAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        super.onInitializeAccessibilityEvent(accessibilityEvent);
        accessibilityEvent.setClassName("android.widget.Switch");
    }

    @Override // android.view.View
    public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo accessibilityNodeInfo) {
        super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
        accessibilityNodeInfo.setClassName("android.widget.Switch");
    }

    @Override // android.widget.TextView, android.view.View
    protected void onLayout(boolean z5, int i5, int i6, int i7, int i8) {
        int iMax;
        int width;
        int paddingLeft;
        int i9;
        int paddingTop;
        int height;
        super.onLayout(z5, i5, i6, i7, i8);
        int iMax2 = 0;
        if (this.f8323a != null) {
            Rect rect = this.f8322U;
            Drawable drawable = this.f8328f;
            if (drawable != null) {
                drawable.getPadding(rect);
            } else {
                rect.setEmpty();
            }
            Rect rectC = I.c(this.f8323a);
            iMax = Math.max(0, rectC.left - rect.left);
            iMax2 = Math.max(0, rectC.right - rect.right);
        } else {
            iMax = 0;
        }
        if (h0.b(this)) {
            paddingLeft = getPaddingLeft() + iMax;
            width = ((this.f8305A + paddingLeft) - iMax) - iMax2;
        } else {
            width = (getWidth() - getPaddingRight()) - iMax2;
            paddingLeft = (width - this.f8305A) + iMax + iMax2;
        }
        int gravity = getGravity() & 112;
        if (gravity == 16) {
            int paddingTop2 = ((getPaddingTop() + getHeight()) - getPaddingBottom()) / 2;
            i9 = this.f8306B;
            paddingTop = paddingTop2 - (i9 / 2);
        } else {
            if (gravity == 80) {
                height = getHeight() - getPaddingBottom();
                paddingTop = height - this.f8306B;
                this.f8308D = paddingLeft;
                this.f8309E = paddingTop;
                this.f8311G = height;
                this.f8310F = width;
            }
            paddingTop = getPaddingTop();
            i9 = this.f8306B;
        }
        height = i9 + paddingTop;
        this.f8308D = paddingLeft;
        this.f8309E = paddingTop;
        this.f8311G = height;
        this.f8310F = width;
    }

    @Override // android.widget.TextView, android.view.View
    public void onMeasure(int i5, int i6) {
        int intrinsicWidth;
        int intrinsicHeight;
        if (this.f8341s) {
            if (this.f8315K == null) {
                this.f8315K = i(this.f8338p);
            }
            if (this.f8316L == null) {
                this.f8316L = i(this.f8340r);
            }
        }
        Rect rect = this.f8322U;
        Drawable drawable = this.f8323a;
        int intrinsicHeight2 = 0;
        if (drawable != null) {
            drawable.getPadding(rect);
            intrinsicWidth = (this.f8323a.getIntrinsicWidth() - rect.left) - rect.right;
            intrinsicHeight = this.f8323a.getIntrinsicHeight();
        } else {
            intrinsicWidth = 0;
            intrinsicHeight = 0;
        }
        this.f8307C = Math.max(this.f8341s ? Math.max(this.f8315K.getWidth(), this.f8316L.getWidth()) + (this.f8333k * 2) : 0, intrinsicWidth);
        Drawable drawable2 = this.f8328f;
        if (drawable2 != null) {
            drawable2.getPadding(rect);
            intrinsicHeight2 = this.f8328f.getIntrinsicHeight();
        } else {
            rect.setEmpty();
        }
        int iMax = rect.left;
        int iMax2 = rect.right;
        Drawable drawable3 = this.f8323a;
        if (drawable3 != null) {
            Rect rectC = I.c(drawable3);
            iMax = Math.max(iMax, rectC.left);
            iMax2 = Math.max(iMax2, rectC.right);
        }
        int iMax3 = this.f8312H ? Math.max(this.f8334l, (this.f8307C * 2) + iMax + iMax2) : this.f8334l;
        int iMax4 = Math.max(intrinsicHeight2, intrinsicHeight);
        this.f8305A = iMax3;
        this.f8306B = iMax4;
        super.onMeasure(i5, i6);
        if (getMeasuredHeight() < iMax4) {
            setMeasuredDimension(getMeasuredWidthAndState(), iMax4);
        }
    }

    @Override // android.view.View
    public void onPopulateAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        super.onPopulateAccessibilityEvent(accessibilityEvent);
        CharSequence charSequence = isChecked() ? this.f8337o : this.f8339q;
        if (charSequence != null) {
            accessibilityEvent.getText().add(charSequence);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:34:0x0089  */
    @Override // android.widget.TextView, android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public boolean onTouchEvent(android.view.MotionEvent r7) throws android.content.res.Resources.NotFoundException {
        /*
            r6 = this;
            android.view.VelocityTracker r0 = r6.f8346x
            r0.addMovement(r7)
            int r0 = r7.getActionMasked()
            r1 = 1
            if (r0 == 0) goto L9d
            r2 = 2
            if (r0 == r1) goto L89
            if (r0 == r2) goto L16
            r3 = 3
            if (r0 == r3) goto L89
            goto Lb7
        L16:
            int r0 = r6.f8342t
            if (r0 == r1) goto L55
            if (r0 == r2) goto L1e
            goto Lb7
        L1e:
            float r7 = r7.getX()
            int r0 = r6.getThumbScrollRange()
            float r2 = r6.f8344v
            float r2 = r7 - r2
            r3 = 1065353216(0x3f800000, float:1.0)
            r4 = 0
            if (r0 == 0) goto L32
            float r0 = (float) r0
            float r2 = r2 / r0
            goto L3b
        L32:
            int r0 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1))
            if (r0 <= 0) goto L38
            r2 = r3
            goto L3b
        L38:
            r0 = -1082130432(0xffffffffbf800000, float:-1.0)
            r2 = r0
        L3b:
            boolean r0 = androidx.appcompat.widget.h0.b(r6)
            if (r0 == 0) goto L42
            float r2 = -r2
        L42:
            float r0 = r6.f8348z
            float r0 = r0 + r2
            float r0 = f(r0, r4, r3)
            float r2 = r6.f8348z
            int r2 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            if (r2 == 0) goto L54
            r6.f8344v = r7
            r6.setThumbPosition(r0)
        L54:
            return r1
        L55:
            float r0 = r7.getX()
            float r3 = r7.getY()
            float r4 = r6.f8344v
            float r4 = r0 - r4
            float r4 = java.lang.Math.abs(r4)
            int r5 = r6.f8343u
            float r5 = (float) r5
            int r4 = (r4 > r5 ? 1 : (r4 == r5 ? 0 : -1))
            if (r4 > 0) goto L7b
            float r4 = r6.f8345w
            float r4 = r3 - r4
            float r4 = java.lang.Math.abs(r4)
            int r5 = r6.f8343u
            float r5 = (float) r5
            int r4 = (r4 > r5 ? 1 : (r4 == r5 ? 0 : -1))
            if (r4 <= 0) goto Lb7
        L7b:
            r6.f8342t = r2
            android.view.ViewParent r7 = r6.getParent()
            r7.requestDisallowInterceptTouchEvent(r1)
            r6.f8344v = r0
            r6.f8345w = r3
            return r1
        L89:
            int r0 = r6.f8342t
            if (r0 != r2) goto L94
            r6.q(r7)
            super.onTouchEvent(r7)
            return r1
        L94:
            r0 = 0
            r6.f8342t = r0
            android.view.VelocityTracker r0 = r6.f8346x
            r0.clear()
            goto Lb7
        L9d:
            float r0 = r7.getX()
            float r2 = r7.getY()
            boolean r3 = r6.isEnabled()
            if (r3 == 0) goto Lb7
            boolean r3 = r6.h(r0, r2)
            if (r3 == 0) goto Lb7
            r6.f8342t = r1
            r6.f8344v = r0
            r6.f8345w = r2
        Lb7:
            boolean r6 = super.onTouchEvent(r7)
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.appcompat.widget.SwitchCompat.onTouchEvent(android.view.MotionEvent):boolean");
    }

    @Override // android.widget.TextView
    public void setAllCaps(boolean z5) {
        super.setAllCaps(z5);
        getEmojiTextViewHelper().d(z5);
    }

    @Override // android.widget.CompoundButton, android.widget.Checkable
    public void setChecked(boolean z5) throws Resources.NotFoundException {
        super.setChecked(z5);
        boolean zIsChecked = isChecked();
        if (zIsChecked) {
            l();
        } else {
            k();
        }
        if (getWindowToken() != null && isLaidOut()) {
            a(zIsChecked);
        } else {
            d();
            setThumbPosition(zIsChecked ? 1.0f : 0.0f);
        }
    }

    @Override // android.widget.TextView
    public void setCustomSelectionActionModeCallback(ActionMode.Callback callback) {
        super.setCustomSelectionActionModeCallback(androidx.core.widget.i.p(this, callback));
    }

    public void setEmojiCompatEnabled(boolean z5) {
        getEmojiTextViewHelper().e(z5);
        setTextOnInternal(this.f8337o);
        setTextOffInternal(this.f8339q);
        requestLayout();
    }

    protected final void setEnforceSwitchWidth(boolean z5) {
        this.f8312H = z5;
        invalidate();
    }

    @Override // android.widget.TextView
    public void setFilters(InputFilter[] inputFilterArr) {
        super.setFilters(getEmojiTextViewHelper().a(inputFilterArr));
    }

    public void setShowText(boolean z5) {
        if (this.f8341s != z5) {
            this.f8341s = z5;
            requestLayout();
            if (z5) {
                p();
            }
        }
    }

    public void setSplitTrack(boolean z5) {
        this.f8336n = z5;
        invalidate();
    }

    public void setSwitchMinWidth(int i5) {
        this.f8334l = i5;
        requestLayout();
    }

    public void setSwitchPadding(int i5) {
        this.f8335m = i5;
        requestLayout();
    }

    public void setSwitchTypeface(Typeface typeface) {
        if ((this.f8313I.getTypeface() == null || this.f8313I.getTypeface().equals(typeface)) && (this.f8313I.getTypeface() != null || typeface == null)) {
            return;
        }
        this.f8313I.setTypeface(typeface);
        requestLayout();
        invalidate();
    }

    public void setTextOff(CharSequence charSequence) throws Resources.NotFoundException {
        setTextOffInternal(charSequence);
        requestLayout();
        if (isChecked()) {
            return;
        }
        k();
    }

    public void setTextOn(CharSequence charSequence) throws Resources.NotFoundException {
        setTextOnInternal(charSequence);
        requestLayout();
        if (isChecked()) {
            l();
        }
    }

    public void setThumbDrawable(Drawable drawable) {
        Drawable drawable2 = this.f8323a;
        if (drawable2 != null) {
            drawable2.setCallback(null);
        }
        this.f8323a = drawable;
        if (drawable != null) {
            drawable.setCallback(this);
        }
        requestLayout();
    }

    void setThumbPosition(float f5) {
        this.f8348z = f5;
        invalidate();
    }

    public void setThumbResource(int i5) {
        setThumbDrawable(C0744a.b(getContext(), i5));
    }

    public void setThumbTextPadding(int i5) {
        this.f8333k = i5;
        requestLayout();
    }

    public void setThumbTintList(ColorStateList colorStateList) {
        this.f8324b = colorStateList;
        this.f8326d = true;
        b();
    }

    public void setThumbTintMode(PorterDuff.Mode mode) {
        this.f8325c = mode;
        this.f8327e = true;
        b();
    }

    public void setTrackDrawable(Drawable drawable) {
        Drawable drawable2 = this.f8328f;
        if (drawable2 != null) {
            drawable2.setCallback(null);
        }
        this.f8328f = drawable;
        if (drawable != null) {
            drawable.setCallback(this);
        }
        requestLayout();
    }

    public void setTrackResource(int i5) {
        setTrackDrawable(C0744a.b(getContext(), i5));
    }

    public void setTrackTintList(ColorStateList colorStateList) {
        this.f8329g = colorStateList;
        this.f8331i = true;
        c();
    }

    public void setTrackTintMode(PorterDuff.Mode mode) {
        this.f8330h = mode;
        this.f8332j = true;
        c();
    }

    @Override // android.widget.CompoundButton, android.widget.Checkable
    public void toggle() throws Resources.NotFoundException {
        setChecked(!isChecked());
    }

    @Override // android.widget.CompoundButton, android.widget.TextView, android.view.View
    protected boolean verifyDrawable(Drawable drawable) {
        return super.verifyDrawable(drawable) || drawable == this.f8323a || drawable == this.f8328f;
    }

    public SwitchCompat(Context context, AttributeSet attributeSet, int i5) throws Resources.NotFoundException {
        super(context, attributeSet, i5);
        this.f8324b = null;
        this.f8325c = null;
        this.f8326d = false;
        this.f8327e = false;
        this.f8329g = null;
        this.f8330h = null;
        this.f8331i = false;
        this.f8332j = false;
        this.f8346x = VelocityTracker.obtain();
        this.f8312H = true;
        this.f8322U = new Rect();
        V.a(this, getContext());
        TextPaint textPaint = new TextPaint(1);
        this.f8313I = textPaint;
        textPaint.density = getResources().getDisplayMetrics().density;
        int[] iArr = g.j.f17162n2;
        a0 a0VarV = a0.v(context, attributeSet, iArr, i5, 0);
        androidx.core.view.H.i0(this, context, iArr, attributeSet, a0VarV.r(), i5, 0);
        Drawable drawableG = a0VarV.g(g.j.f17177q2);
        this.f8323a = drawableG;
        if (drawableG != null) {
            drawableG.setCallback(this);
        }
        Drawable drawableG2 = a0VarV.g(g.j.f17222z2);
        this.f8328f = drawableG2;
        if (drawableG2 != null) {
            drawableG2.setCallback(this);
        }
        setTextOnInternal(a0VarV.p(g.j.f17167o2));
        setTextOffInternal(a0VarV.p(g.j.f17172p2));
        this.f8341s = a0VarV.a(g.j.f17182r2, true);
        this.f8333k = a0VarV.f(g.j.f17207w2, 0);
        this.f8334l = a0VarV.f(g.j.f17192t2, 0);
        this.f8335m = a0VarV.f(g.j.f17197u2, 0);
        this.f8336n = a0VarV.a(g.j.f17187s2, false);
        ColorStateList colorStateListC = a0VarV.c(g.j.f17212x2);
        if (colorStateListC != null) {
            this.f8324b = colorStateListC;
            this.f8326d = true;
        }
        PorterDuff.Mode modeD = I.d(a0VarV.k(g.j.f17217y2, -1), null);
        if (this.f8325c != modeD) {
            this.f8325c = modeD;
            this.f8327e = true;
        }
        if (this.f8326d || this.f8327e) {
            b();
        }
        ColorStateList colorStateListC2 = a0VarV.c(g.j.f16985A2);
        if (colorStateListC2 != null) {
            this.f8329g = colorStateListC2;
            this.f8331i = true;
        }
        PorterDuff.Mode modeD2 = I.d(a0VarV.k(g.j.f16990B2, -1), null);
        if (this.f8330h != modeD2) {
            this.f8330h = modeD2;
            this.f8332j = true;
        }
        if (this.f8331i || this.f8332j) {
            c();
        }
        int iN = a0VarV.n(g.j.f17202v2, 0);
        if (iN != 0) {
            m(context, iN);
        }
        C c6 = new C(this);
        this.f8319R = c6;
        c6.m(attributeSet, i5);
        a0VarV.x();
        ViewConfiguration viewConfiguration = ViewConfiguration.get(context);
        this.f8343u = viewConfiguration.getScaledTouchSlop();
        this.f8347y = viewConfiguration.getScaledMinimumFlingVelocity();
        getEmojiTextViewHelper().c(attributeSet, i5);
        refreshDrawableState();
        setChecked(isChecked());
    }
}
