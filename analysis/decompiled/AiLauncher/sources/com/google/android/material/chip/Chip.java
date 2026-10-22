package com.google.android.material.chip;

import C0.c;
import E2.h;
import W2.d;
import W2.f;
import Z2.i;
import Z2.l;
import Z2.o;
import android.R;
import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.Outline;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.InsetDrawable;
import android.graphics.drawable.RippleDrawable;
import android.os.Bundle;
import android.text.TextPaint;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.Log;
import android.util.TypedValue;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.PointerIcon;
import android.view.View;
import android.view.ViewOutlineProvider;
import android.view.ViewParent;
import android.view.accessibility.AccessibilityNodeInfo;
import android.widget.Button;
import android.widget.Checkable;
import android.widget.CompoundButton;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatCheckBox;
import androidx.core.view.N;
import com.google.android.material.R$attr;
import com.google.android.material.R$string;
import com.google.android.material.R$style;
import com.google.android.material.R$styleable;
import com.google.android.material.chip.Chip;
import com.google.android.material.chip.a;
import com.google.android.material.internal.j;
import com.google.android.material.internal.r;
import d3.C3953a;
import java.util.List;

/* loaded from: classes2.dex */
public class Chip extends AppCompatCheckBox implements a.InterfaceC0232a, o, Checkable {

    /* renamed from: w, reason: collision with root package name */
    public static final int f20614w = R$style.Widget_MaterialComponents_Chip_Action;

    /* renamed from: x, reason: collision with root package name */
    public static final Rect f20615x = new Rect();

    /* renamed from: y, reason: collision with root package name */
    public static final int[] f20616y = {R.attr.state_selected};

    /* renamed from: z, reason: collision with root package name */
    public static final int[] f20617z = {R.attr.state_checkable};

    /* renamed from: e, reason: collision with root package name */
    public com.google.android.material.chip.a f20618e;

    /* renamed from: f, reason: collision with root package name */
    public InsetDrawable f20619f;

    /* renamed from: g, reason: collision with root package name */
    public RippleDrawable f20620g;

    /* renamed from: h, reason: collision with root package name */
    public View.OnClickListener f20621h;

    /* renamed from: i, reason: collision with root package name */
    public CompoundButton.OnCheckedChangeListener f20622i;

    /* renamed from: j, reason: collision with root package name */
    public boolean f20623j;

    /* renamed from: k, reason: collision with root package name */
    public boolean f20624k;

    /* renamed from: l, reason: collision with root package name */
    public boolean f20625l;

    /* renamed from: m, reason: collision with root package name */
    public boolean f20626m;

    /* renamed from: n, reason: collision with root package name */
    public boolean f20627n;

    /* renamed from: o, reason: collision with root package name */
    public int f20628o;

    /* renamed from: p, reason: collision with root package name */
    public int f20629p;

    /* renamed from: q, reason: collision with root package name */
    public CharSequence f20630q;

    /* renamed from: r, reason: collision with root package name */
    public final c f20631r;

    /* renamed from: s, reason: collision with root package name */
    public boolean f20632s;

    /* renamed from: t, reason: collision with root package name */
    public final Rect f20633t;

    /* renamed from: u, reason: collision with root package name */
    public final RectF f20634u;

    /* renamed from: v, reason: collision with root package name */
    public final f f20635v;

    public class a extends f {
        public a() {
        }

        @Override // W2.f
        public void a(int i10) {
        }

        @Override // W2.f
        public void b(Typeface typeface, boolean z10) {
            Chip chip = Chip.this;
            chip.setText(chip.f20618e.Z2() ? Chip.this.f20618e.t1() : Chip.this.getText());
            Chip.this.requestLayout();
            Chip.this.invalidate();
        }
    }

    public class b extends ViewOutlineProvider {
        public b() {
        }

        @Override // android.view.ViewOutlineProvider
        public void getOutline(View view, Outline outline) {
            if (Chip.this.f20618e != null) {
                Chip.this.f20618e.getOutline(outline);
            } else {
                outline.setAlpha(0.0f);
            }
        }
    }

    public class c extends H0.a {
        public c(Chip chip) {
            super(chip);
        }

        @Override // H0.a
        public void A(int i10, C0.c cVar) {
            if (i10 != 1) {
                cVar.q0("");
                cVar.i0(Chip.f20615x);
                return;
            }
            CharSequence closeIconContentDescription = Chip.this.getCloseIconContentDescription();
            if (closeIconContentDescription != null) {
                cVar.q0(closeIconContentDescription);
            } else {
                CharSequence text = Chip.this.getText();
                cVar.q0(Chip.this.getContext().getString(R$string.mtrl_chip_close_icon_content_description, TextUtils.isEmpty(text) ? "" : text).trim());
            }
            cVar.i0(Chip.this.getCloseIconTouchBoundsInt());
            cVar.b(c.a.f1654i);
            cVar.t0(Chip.this.isEnabled());
            cVar.m0(Button.class.getName());
        }

        @Override // H0.a
        public void B(int i10, boolean z10) {
            if (i10 == 1) {
                Chip.this.f20626m = z10;
            }
            if (Chip.this.f20618e.J1(Chip.this.f20626m)) {
                Chip.this.refreshDrawableState();
            }
        }

        @Override // H0.a
        public int o(float f10, float f11) {
            return (Chip.this.n() && Chip.this.getCloseIconTouchBounds().contains(f10, f11)) ? 1 : 0;
        }

        @Override // H0.a
        public void p(List<Integer> list) {
            list.add(0);
            if (Chip.this.n() && Chip.this.s() && Chip.this.f20621h != null) {
                list.add(1);
            }
        }

        @Override // H0.a
        public boolean w(int i10, int i11, Bundle bundle) {
            if (i11 != 16) {
                return false;
            }
            if (i10 == 0) {
                return Chip.this.performClick();
            }
            if (i10 == 1) {
                return Chip.this.t();
            }
            return false;
        }

        @Override // H0.a
        public void z(C0.c cVar) {
            cVar.k0(Chip.this.r());
            cVar.n0(Chip.this.isClickable());
            cVar.m0(Chip.this.getAccessibilityClassName());
            cVar.O0(Chip.this.getText());
        }
    }

    public Chip(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, R$attr.chipStyle);
    }

    public static /* synthetic */ void b(Chip chip, CompoundButton compoundButton, boolean z10) {
        CompoundButton.OnCheckedChangeListener onCheckedChangeListener = chip.f20622i;
        if (onCheckedChangeListener != null) {
            onCheckedChangeListener.onCheckedChanged(compoundButton, z10);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public RectF getCloseIconTouchBounds() {
        this.f20634u.setEmpty();
        if (n() && this.f20621h != null) {
            this.f20618e.k1(this.f20634u);
        }
        return this.f20634u;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Rect getCloseIconTouchBoundsInt() {
        RectF closeIconTouchBounds = getCloseIconTouchBounds();
        this.f20633t.set((int) closeIconTouchBounds.left, (int) closeIconTouchBounds.top, (int) closeIconTouchBounds.right, (int) closeIconTouchBounds.bottom);
        return this.f20633t;
    }

    private d getTextAppearance() {
        com.google.android.material.chip.a aVar = this.f20618e;
        if (aVar != null) {
            return aVar.u1();
        }
        return null;
    }

    private void setCloseIconHovered(boolean z10) {
        if (this.f20625l != z10) {
            this.f20625l = z10;
            refreshDrawableState();
        }
    }

    private void setCloseIconPressed(boolean z10) {
        if (this.f20624k != z10) {
            this.f20624k = z10;
            refreshDrawableState();
        }
    }

    public final void A() {
        com.google.android.material.chip.a aVar;
        if (TextUtils.isEmpty(getText()) || (aVar = this.f20618e) == null) {
            return;
        }
        int iV0 = (int) (aVar.V0() + this.f20618e.v1() + this.f20618e.C0());
        int iA1 = (int) (this.f20618e.a1() + this.f20618e.w1() + this.f20618e.y0());
        if (this.f20619f != null) {
            Rect rect = new Rect();
            this.f20619f.getPadding(rect);
            iA1 += rect.left;
            iV0 += rect.right;
        }
        setPaddingRelative(iA1, getPaddingTop(), iV0, getPaddingBottom());
    }

    public final void B() {
        TextPaint paint = getPaint();
        com.google.android.material.chip.a aVar = this.f20618e;
        if (aVar != null) {
            paint.drawableState = aVar.getState();
        }
        d textAppearance = getTextAppearance();
        if (textAppearance != null) {
            textAppearance.p(getContext(), paint, this.f20635v);
        }
    }

    public final void C(AttributeSet attributeSet) {
        if (attributeSet == null) {
            return;
        }
        if (attributeSet.getAttributeValue("http://schemas.android.com/apk/res/android", "background") != null) {
            Log.w("Chip", "Do not set the background; Chip manages its own background drawable.");
        }
        if (attributeSet.getAttributeValue("http://schemas.android.com/apk/res/android", "drawableLeft") != null) {
            throw new UnsupportedOperationException("Please set left drawable using R.attr#chipIcon.");
        }
        if (attributeSet.getAttributeValue("http://schemas.android.com/apk/res/android", "drawableStart") != null) {
            throw new UnsupportedOperationException("Please set start drawable using R.attr#chipIcon.");
        }
        if (attributeSet.getAttributeValue("http://schemas.android.com/apk/res/android", "drawableEnd") != null) {
            throw new UnsupportedOperationException("Please set end drawable using R.attr#closeIcon.");
        }
        if (attributeSet.getAttributeValue("http://schemas.android.com/apk/res/android", "drawableRight") != null) {
            throw new UnsupportedOperationException("Please set end drawable using R.attr#closeIcon.");
        }
        if (!attributeSet.getAttributeBooleanValue("http://schemas.android.com/apk/res/android", "singleLine", true) || attributeSet.getAttributeIntValue("http://schemas.android.com/apk/res/android", "lines", 1) != 1 || attributeSet.getAttributeIntValue("http://schemas.android.com/apk/res/android", "minLines", 1) != 1 || attributeSet.getAttributeIntValue("http://schemas.android.com/apk/res/android", "maxLines", 1) != 1) {
            throw new UnsupportedOperationException("Chip does not support multi-line text");
        }
        if (attributeSet.getAttributeIntValue("http://schemas.android.com/apk/res/android", "gravity", 8388627) != 8388627) {
            Log.w("Chip", "Chip text must be vertically center and start aligned");
        }
    }

    @Override // com.google.android.material.chip.a.InterfaceC0232a
    public void a() {
        m(this.f20629p);
        requestLayout();
        invalidateOutline();
    }

    @Override // android.view.View
    public boolean dispatchHoverEvent(MotionEvent motionEvent) {
        return !this.f20632s ? super.dispatchHoverEvent(motionEvent) : this.f20631r.i(motionEvent) || super.dispatchHoverEvent(motionEvent);
    }

    @Override // android.view.View
    public boolean dispatchKeyEvent(KeyEvent keyEvent) {
        if (!this.f20632s) {
            return super.dispatchKeyEvent(keyEvent);
        }
        if (!this.f20631r.j(keyEvent) || this.f20631r.n() == Integer.MIN_VALUE) {
            return super.dispatchKeyEvent(keyEvent);
        }
        return true;
    }

    @Override // androidx.appcompat.widget.AppCompatCheckBox, android.widget.CompoundButton, android.widget.TextView, android.view.View
    public void drawableStateChanged() {
        super.drawableStateChanged();
        com.google.android.material.chip.a aVar = this.f20618e;
        if ((aVar == null || !aVar.B1()) ? false : this.f20618e.y2(l())) {
            invalidate();
        }
    }

    @Override // android.widget.CheckBox, android.widget.CompoundButton, android.widget.Button, android.widget.TextView, android.view.View
    public CharSequence getAccessibilityClassName() {
        if (!TextUtils.isEmpty(this.f20630q)) {
            return this.f20630q;
        }
        if (!r()) {
            return isClickable() ? "android.widget.Button" : "android.view.View";
        }
        ViewParent parent = getParent();
        return ((parent instanceof J2.b) && ((J2.b) parent).f()) ? "android.widget.RadioButton" : "android.widget.Button";
    }

    public Drawable getBackgroundDrawable() {
        InsetDrawable insetDrawable = this.f20619f;
        return insetDrawable == null ? this.f20618e : insetDrawable;
    }

    public Drawable getCheckedIcon() {
        com.google.android.material.chip.a aVar = this.f20618e;
        if (aVar != null) {
            return aVar.R0();
        }
        return null;
    }

    public ColorStateList getCheckedIconTint() {
        com.google.android.material.chip.a aVar = this.f20618e;
        if (aVar != null) {
            return aVar.S0();
        }
        return null;
    }

    public ColorStateList getChipBackgroundColor() {
        com.google.android.material.chip.a aVar = this.f20618e;
        if (aVar != null) {
            return aVar.T0();
        }
        return null;
    }

    public float getChipCornerRadius() {
        com.google.android.material.chip.a aVar = this.f20618e;
        if (aVar != null) {
            return Math.max(0.0f, aVar.U0());
        }
        return 0.0f;
    }

    public Drawable getChipDrawable() {
        return this.f20618e;
    }

    public float getChipEndPadding() {
        com.google.android.material.chip.a aVar = this.f20618e;
        if (aVar != null) {
            return aVar.V0();
        }
        return 0.0f;
    }

    public Drawable getChipIcon() {
        com.google.android.material.chip.a aVar = this.f20618e;
        if (aVar != null) {
            return aVar.W0();
        }
        return null;
    }

    public float getChipIconSize() {
        com.google.android.material.chip.a aVar = this.f20618e;
        if (aVar != null) {
            return aVar.X0();
        }
        return 0.0f;
    }

    public ColorStateList getChipIconTint() {
        com.google.android.material.chip.a aVar = this.f20618e;
        if (aVar != null) {
            return aVar.Y0();
        }
        return null;
    }

    public float getChipMinHeight() {
        com.google.android.material.chip.a aVar = this.f20618e;
        if (aVar != null) {
            return aVar.Z0();
        }
        return 0.0f;
    }

    public float getChipStartPadding() {
        com.google.android.material.chip.a aVar = this.f20618e;
        if (aVar != null) {
            return aVar.a1();
        }
        return 0.0f;
    }

    public ColorStateList getChipStrokeColor() {
        com.google.android.material.chip.a aVar = this.f20618e;
        if (aVar != null) {
            return aVar.b1();
        }
        return null;
    }

    public float getChipStrokeWidth() {
        com.google.android.material.chip.a aVar = this.f20618e;
        if (aVar != null) {
            return aVar.c1();
        }
        return 0.0f;
    }

    @Deprecated
    public CharSequence getChipText() {
        return getText();
    }

    public Drawable getCloseIcon() {
        com.google.android.material.chip.a aVar = this.f20618e;
        if (aVar != null) {
            return aVar.d1();
        }
        return null;
    }

    public CharSequence getCloseIconContentDescription() {
        com.google.android.material.chip.a aVar = this.f20618e;
        if (aVar != null) {
            return aVar.e1();
        }
        return null;
    }

    public float getCloseIconEndPadding() {
        com.google.android.material.chip.a aVar = this.f20618e;
        if (aVar != null) {
            return aVar.f1();
        }
        return 0.0f;
    }

    public float getCloseIconSize() {
        com.google.android.material.chip.a aVar = this.f20618e;
        if (aVar != null) {
            return aVar.g1();
        }
        return 0.0f;
    }

    public float getCloseIconStartPadding() {
        com.google.android.material.chip.a aVar = this.f20618e;
        if (aVar != null) {
            return aVar.h1();
        }
        return 0.0f;
    }

    public ColorStateList getCloseIconTint() {
        com.google.android.material.chip.a aVar = this.f20618e;
        if (aVar != null) {
            return aVar.j1();
        }
        return null;
    }

    @Override // android.widget.TextView
    public TextUtils.TruncateAt getEllipsize() {
        com.google.android.material.chip.a aVar = this.f20618e;
        if (aVar != null) {
            return aVar.n1();
        }
        return null;
    }

    @Override // android.widget.TextView, android.view.View
    public void getFocusedRect(Rect rect) {
        if (this.f20632s && (this.f20631r.n() == 1 || this.f20631r.k() == 1)) {
            rect.set(getCloseIconTouchBoundsInt());
        } else {
            super.getFocusedRect(rect);
        }
    }

    public h getHideMotionSpec() {
        com.google.android.material.chip.a aVar = this.f20618e;
        if (aVar != null) {
            return aVar.o1();
        }
        return null;
    }

    public float getIconEndPadding() {
        com.google.android.material.chip.a aVar = this.f20618e;
        if (aVar != null) {
            return aVar.p1();
        }
        return 0.0f;
    }

    public float getIconStartPadding() {
        com.google.android.material.chip.a aVar = this.f20618e;
        if (aVar != null) {
            return aVar.q1();
        }
        return 0.0f;
    }

    public ColorStateList getRippleColor() {
        com.google.android.material.chip.a aVar = this.f20618e;
        if (aVar != null) {
            return aVar.r1();
        }
        return null;
    }

    public l getShapeAppearanceModel() {
        return this.f20618e.I();
    }

    public h getShowMotionSpec() {
        com.google.android.material.chip.a aVar = this.f20618e;
        if (aVar != null) {
            return aVar.s1();
        }
        return null;
    }

    public float getTextEndPadding() {
        com.google.android.material.chip.a aVar = this.f20618e;
        if (aVar != null) {
            return aVar.v1();
        }
        return 0.0f;
    }

    public float getTextStartPadding() {
        com.google.android.material.chip.a aVar = this.f20618e;
        if (aVar != null) {
            return aVar.w1();
        }
        return 0.0f;
    }

    public final void k(com.google.android.material.chip.a aVar) {
        aVar.C2(this);
    }

    /* JADX WARN: Type inference failed for: r0v0, types: [boolean, int] */
    public final int[] l() {
        ?? IsEnabled = isEnabled();
        int i10 = IsEnabled;
        if (this.f20626m) {
            i10 = IsEnabled + 1;
        }
        int i11 = i10;
        if (this.f20625l) {
            i11 = i10 + 1;
        }
        int i12 = i11;
        if (this.f20624k) {
            i12 = i11 + 1;
        }
        int i13 = i12;
        if (isChecked()) {
            i13 = i12 + 1;
        }
        int[] iArr = new int[i13];
        int i14 = 0;
        if (isEnabled()) {
            iArr[0] = 16842910;
            i14 = 1;
        }
        if (this.f20626m) {
            iArr[i14] = 16842908;
            i14++;
        }
        if (this.f20625l) {
            iArr[i14] = 16843623;
            i14++;
        }
        if (this.f20624k) {
            iArr[i14] = 16842919;
            i14++;
        }
        if (isChecked()) {
            iArr[i14] = 16842913;
        }
        return iArr;
    }

    public boolean m(int i10) {
        this.f20629p = i10;
        if (!v()) {
            if (this.f20619f != null) {
                u();
            } else {
                y();
            }
            return false;
        }
        int iMax = Math.max(0, i10 - this.f20618e.getIntrinsicHeight());
        int iMax2 = Math.max(0, i10 - this.f20618e.getIntrinsicWidth());
        if (iMax2 <= 0 && iMax <= 0) {
            if (this.f20619f != null) {
                u();
            } else {
                y();
            }
            return false;
        }
        int i11 = iMax2 > 0 ? iMax2 / 2 : 0;
        int i12 = iMax > 0 ? iMax / 2 : 0;
        if (this.f20619f != null) {
            Rect rect = new Rect();
            this.f20619f.getPadding(rect);
            if (rect.top == i12 && rect.bottom == i12 && rect.left == i11 && rect.right == i11) {
                y();
                return true;
            }
        }
        if (getMinHeight() != i10) {
            setMinHeight(i10);
        }
        if (getMinWidth() != i10) {
            setMinWidth(i10);
        }
        q(i11, i12, i11, i12);
        y();
        return true;
    }

    public final boolean n() {
        com.google.android.material.chip.a aVar = this.f20618e;
        return (aVar == null || aVar.d1() == null) ? false : true;
    }

    public final void o(Context context, AttributeSet attributeSet, int i10) {
        TypedArray typedArrayI = r.i(context, attributeSet, R$styleable.Chip, i10, f20614w, new int[0]);
        this.f20627n = typedArrayI.getBoolean(R$styleable.Chip_ensureMinTouchTargetSize, false);
        this.f20629p = (int) Math.ceil(typedArrayI.getDimension(R$styleable.Chip_chipMinTouchTargetSize, W2.b.e(context)));
        typedArrayI.recycle();
    }

    @Override // android.widget.TextView, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        i.f(this, this.f20618e);
    }

    @Override // android.widget.CompoundButton, android.widget.TextView, android.view.View
    public int[] onCreateDrawableState(int i10) {
        int[] iArrOnCreateDrawableState = super.onCreateDrawableState(i10 + 2);
        if (isChecked()) {
            View.mergeDrawableStates(iArrOnCreateDrawableState, f20616y);
        }
        if (r()) {
            View.mergeDrawableStates(iArrOnCreateDrawableState, f20617z);
        }
        return iArrOnCreateDrawableState;
    }

    @Override // android.widget.TextView, android.view.View
    public void onFocusChanged(boolean z10, int i10, Rect rect) {
        super.onFocusChanged(z10, i10, rect);
        if (this.f20632s) {
            this.f20631r.v(z10, i10, rect);
        }
    }

    @Override // android.view.View
    public boolean onHoverEvent(MotionEvent motionEvent) {
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked == 7) {
            setCloseIconHovered(getCloseIconTouchBounds().contains(motionEvent.getX(), motionEvent.getY()));
        } else if (actionMasked == 10) {
            setCloseIconHovered(false);
        }
        return super.onHoverEvent(motionEvent);
    }

    @Override // android.view.View
    public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo accessibilityNodeInfo) {
        super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
        accessibilityNodeInfo.setClassName(getAccessibilityClassName());
        accessibilityNodeInfo.setCheckable(r());
        accessibilityNodeInfo.setClickable(isClickable());
        if (getParent() instanceof J2.b) {
            J2.b bVar = (J2.b) getParent();
            C0.c.S0(accessibilityNodeInfo).p0(c.g.a(bVar.b(this), 1, bVar.c() ? bVar.d(this) : -1, 1, false, isChecked()));
        }
    }

    @Override // android.widget.Button, android.widget.TextView, android.view.View
    @TargetApi(24)
    public PointerIcon onResolvePointerIcon(MotionEvent motionEvent, int i10) {
        return (getCloseIconTouchBounds().contains(motionEvent.getX(), motionEvent.getY()) && isEnabled()) ? PointerIcon.getSystemIcon(getContext(), 1002) : super.onResolvePointerIcon(motionEvent, i10);
    }

    @Override // android.widget.TextView, android.view.View
    public void onRtlPropertiesChanged(int i10) {
        super.onRtlPropertiesChanged(i10);
        if (this.f20628o != i10) {
            this.f20628o = i10;
            A();
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:8:0x001e, code lost:
    
        if (r0 != 3) goto L22;
     */
    @Override // android.widget.TextView, android.view.View
    @android.annotation.SuppressLint({"ClickableViewAccessibility"})
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public boolean onTouchEvent(android.view.MotionEvent r6) {
        /*
            r5 = this;
            int r0 = r6.getActionMasked()
            android.graphics.RectF r1 = r5.getCloseIconTouchBounds()
            float r2 = r6.getX()
            float r3 = r6.getY()
            boolean r1 = r1.contains(r2, r3)
            r2 = 1
            r3 = 0
            if (r0 == 0) goto L3a
            if (r0 == r2) goto L2c
            r4 = 2
            if (r0 == r4) goto L21
            r1 = 3
            if (r0 == r1) goto L35
            goto L40
        L21:
            boolean r0 = r5.f20624k
            if (r0 == 0) goto L40
            if (r1 != 0) goto L2a
            r5.setCloseIconPressed(r3)
        L2a:
            r0 = r2
            goto L41
        L2c:
            boolean r0 = r5.f20624k
            if (r0 == 0) goto L35
            r5.t()
            r0 = r2
            goto L36
        L35:
            r0 = r3
        L36:
            r5.setCloseIconPressed(r3)
            goto L41
        L3a:
            if (r1 == 0) goto L40
            r5.setCloseIconPressed(r2)
            goto L2a
        L40:
            r0 = r3
        L41:
            if (r0 != 0) goto L4b
            boolean r5 = super.onTouchEvent(r6)
            if (r5 == 0) goto L4a
            goto L4b
        L4a:
            return r3
        L4b:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.material.chip.Chip.onTouchEvent(android.view.MotionEvent):boolean");
    }

    public final void p() {
        setOutlineProvider(new b());
    }

    public final void q(int i10, int i11, int i12, int i13) {
        this.f20619f = new InsetDrawable((Drawable) this.f20618e, i10, i11, i12, i13);
    }

    public boolean r() {
        com.google.android.material.chip.a aVar = this.f20618e;
        return aVar != null && aVar.A1();
    }

    public boolean s() {
        com.google.android.material.chip.a aVar = this.f20618e;
        return aVar != null && aVar.C1();
    }

    public void setAccessibilityClassName(CharSequence charSequence) {
        this.f20630q = charSequence;
    }

    @Override // android.view.View
    public void setBackground(Drawable drawable) {
        if (drawable == getBackgroundDrawable() || drawable == this.f20620g) {
            super.setBackground(drawable);
        } else {
            Log.w("Chip", "Do not set the background; Chip manages its own background drawable.");
        }
    }

    @Override // android.view.View
    public void setBackgroundColor(int i10) {
        Log.w("Chip", "Do not set the background color; Chip manages its own background drawable.");
    }

    @Override // androidx.appcompat.widget.AppCompatCheckBox, android.view.View
    public void setBackgroundDrawable(Drawable drawable) {
        if (drawable == getBackgroundDrawable() || drawable == this.f20620g) {
            super.setBackgroundDrawable(drawable);
        } else {
            Log.w("Chip", "Do not set the background drawable; Chip manages its own background drawable.");
        }
    }

    @Override // androidx.appcompat.widget.AppCompatCheckBox, android.view.View
    public void setBackgroundResource(int i10) {
        Log.w("Chip", "Do not set the background resource; Chip manages its own background drawable.");
    }

    @Override // android.view.View
    public void setBackgroundTintList(ColorStateList colorStateList) {
        Log.w("Chip", "Do not set the background tint list; Chip manages its own background drawable.");
    }

    @Override // android.view.View
    public void setBackgroundTintMode(PorterDuff.Mode mode) {
        Log.w("Chip", "Do not set the background tint mode; Chip manages its own background drawable.");
    }

    public void setCheckable(boolean z10) {
        com.google.android.material.chip.a aVar = this.f20618e;
        if (aVar != null) {
            aVar.K1(z10);
        }
    }

    public void setCheckableResource(int i10) {
        com.google.android.material.chip.a aVar = this.f20618e;
        if (aVar != null) {
            aVar.L1(i10);
        }
    }

    @Override // android.widget.CompoundButton, android.widget.Checkable
    public void setChecked(boolean z10) {
        com.google.android.material.chip.a aVar = this.f20618e;
        if (aVar == null) {
            this.f20623j = z10;
        } else if (aVar.A1()) {
            super.setChecked(z10);
        }
    }

    public void setCheckedIcon(Drawable drawable) {
        com.google.android.material.chip.a aVar = this.f20618e;
        if (aVar != null) {
            aVar.M1(drawable);
        }
    }

    @Deprecated
    public void setCheckedIconEnabled(boolean z10) {
        setCheckedIconVisible(z10);
    }

    @Deprecated
    public void setCheckedIconEnabledResource(int i10) {
        setCheckedIconVisible(i10);
    }

    public void setCheckedIconResource(int i10) {
        com.google.android.material.chip.a aVar = this.f20618e;
        if (aVar != null) {
            aVar.N1(i10);
        }
    }

    public void setCheckedIconTint(ColorStateList colorStateList) {
        com.google.android.material.chip.a aVar = this.f20618e;
        if (aVar != null) {
            aVar.O1(colorStateList);
        }
    }

    public void setCheckedIconTintResource(int i10) {
        com.google.android.material.chip.a aVar = this.f20618e;
        if (aVar != null) {
            aVar.P1(i10);
        }
    }

    public void setCheckedIconVisible(int i10) {
        com.google.android.material.chip.a aVar = this.f20618e;
        if (aVar != null) {
            aVar.Q1(i10);
        }
    }

    public void setChipBackgroundColor(ColorStateList colorStateList) {
        com.google.android.material.chip.a aVar = this.f20618e;
        if (aVar != null) {
            aVar.S1(colorStateList);
        }
    }

    public void setChipBackgroundColorResource(int i10) {
        com.google.android.material.chip.a aVar = this.f20618e;
        if (aVar != null) {
            aVar.T1(i10);
        }
    }

    @Deprecated
    public void setChipCornerRadius(float f10) {
        com.google.android.material.chip.a aVar = this.f20618e;
        if (aVar != null) {
            aVar.U1(f10);
        }
    }

    @Deprecated
    public void setChipCornerRadiusResource(int i10) {
        com.google.android.material.chip.a aVar = this.f20618e;
        if (aVar != null) {
            aVar.V1(i10);
        }
    }

    public void setChipDrawable(com.google.android.material.chip.a aVar) {
        com.google.android.material.chip.a aVar2 = this.f20618e;
        if (aVar2 != aVar) {
            w(aVar2);
            this.f20618e = aVar;
            aVar.N2(false);
            k(this.f20618e);
            m(this.f20629p);
        }
    }

    public void setChipEndPadding(float f10) {
        com.google.android.material.chip.a aVar = this.f20618e;
        if (aVar != null) {
            aVar.W1(f10);
        }
    }

    public void setChipEndPaddingResource(int i10) {
        com.google.android.material.chip.a aVar = this.f20618e;
        if (aVar != null) {
            aVar.X1(i10);
        }
    }

    public void setChipIcon(Drawable drawable) {
        com.google.android.material.chip.a aVar = this.f20618e;
        if (aVar != null) {
            aVar.Y1(drawable);
        }
    }

    @Deprecated
    public void setChipIconEnabled(boolean z10) {
        setChipIconVisible(z10);
    }

    @Deprecated
    public void setChipIconEnabledResource(int i10) {
        setChipIconVisible(i10);
    }

    public void setChipIconResource(int i10) {
        com.google.android.material.chip.a aVar = this.f20618e;
        if (aVar != null) {
            aVar.Z1(i10);
        }
    }

    public void setChipIconSize(float f10) {
        com.google.android.material.chip.a aVar = this.f20618e;
        if (aVar != null) {
            aVar.a2(f10);
        }
    }

    public void setChipIconSizeResource(int i10) {
        com.google.android.material.chip.a aVar = this.f20618e;
        if (aVar != null) {
            aVar.b2(i10);
        }
    }

    public void setChipIconTint(ColorStateList colorStateList) {
        com.google.android.material.chip.a aVar = this.f20618e;
        if (aVar != null) {
            aVar.c2(colorStateList);
        }
    }

    public void setChipIconTintResource(int i10) {
        com.google.android.material.chip.a aVar = this.f20618e;
        if (aVar != null) {
            aVar.d2(i10);
        }
    }

    public void setChipIconVisible(int i10) {
        com.google.android.material.chip.a aVar = this.f20618e;
        if (aVar != null) {
            aVar.e2(i10);
        }
    }

    public void setChipMinHeight(float f10) {
        com.google.android.material.chip.a aVar = this.f20618e;
        if (aVar != null) {
            aVar.g2(f10);
        }
    }

    public void setChipMinHeightResource(int i10) {
        com.google.android.material.chip.a aVar = this.f20618e;
        if (aVar != null) {
            aVar.h2(i10);
        }
    }

    public void setChipStartPadding(float f10) {
        com.google.android.material.chip.a aVar = this.f20618e;
        if (aVar != null) {
            aVar.i2(f10);
        }
    }

    public void setChipStartPaddingResource(int i10) {
        com.google.android.material.chip.a aVar = this.f20618e;
        if (aVar != null) {
            aVar.j2(i10);
        }
    }

    public void setChipStrokeColor(ColorStateList colorStateList) {
        com.google.android.material.chip.a aVar = this.f20618e;
        if (aVar != null) {
            aVar.k2(colorStateList);
        }
    }

    public void setChipStrokeColorResource(int i10) {
        com.google.android.material.chip.a aVar = this.f20618e;
        if (aVar != null) {
            aVar.l2(i10);
        }
    }

    public void setChipStrokeWidth(float f10) {
        com.google.android.material.chip.a aVar = this.f20618e;
        if (aVar != null) {
            aVar.m2(f10);
        }
    }

    public void setChipStrokeWidthResource(int i10) {
        com.google.android.material.chip.a aVar = this.f20618e;
        if (aVar != null) {
            aVar.n2(i10);
        }
    }

    @Deprecated
    public void setChipText(CharSequence charSequence) {
        setText(charSequence);
    }

    @Deprecated
    public void setChipTextResource(int i10) {
        setText(getResources().getString(i10));
    }

    public void setCloseIcon(Drawable drawable) {
        com.google.android.material.chip.a aVar = this.f20618e;
        if (aVar != null) {
            aVar.p2(drawable);
        }
        x();
    }

    public void setCloseIconContentDescription(CharSequence charSequence) {
        com.google.android.material.chip.a aVar = this.f20618e;
        if (aVar != null) {
            aVar.q2(charSequence);
        }
    }

    @Deprecated
    public void setCloseIconEnabled(boolean z10) {
        setCloseIconVisible(z10);
    }

    @Deprecated
    public void setCloseIconEnabledResource(int i10) {
        setCloseIconVisible(i10);
    }

    public void setCloseIconEndPadding(float f10) {
        com.google.android.material.chip.a aVar = this.f20618e;
        if (aVar != null) {
            aVar.r2(f10);
        }
    }

    public void setCloseIconEndPaddingResource(int i10) {
        com.google.android.material.chip.a aVar = this.f20618e;
        if (aVar != null) {
            aVar.s2(i10);
        }
    }

    public void setCloseIconResource(int i10) {
        com.google.android.material.chip.a aVar = this.f20618e;
        if (aVar != null) {
            aVar.t2(i10);
        }
        x();
    }

    public void setCloseIconSize(float f10) {
        com.google.android.material.chip.a aVar = this.f20618e;
        if (aVar != null) {
            aVar.u2(f10);
        }
    }

    public void setCloseIconSizeResource(int i10) {
        com.google.android.material.chip.a aVar = this.f20618e;
        if (aVar != null) {
            aVar.v2(i10);
        }
    }

    public void setCloseIconStartPadding(float f10) {
        com.google.android.material.chip.a aVar = this.f20618e;
        if (aVar != null) {
            aVar.w2(f10);
        }
    }

    public void setCloseIconStartPaddingResource(int i10) {
        com.google.android.material.chip.a aVar = this.f20618e;
        if (aVar != null) {
            aVar.x2(i10);
        }
    }

    public void setCloseIconTint(ColorStateList colorStateList) {
        com.google.android.material.chip.a aVar = this.f20618e;
        if (aVar != null) {
            aVar.z2(colorStateList);
        }
    }

    public void setCloseIconTintResource(int i10) {
        com.google.android.material.chip.a aVar = this.f20618e;
        if (aVar != null) {
            aVar.A2(i10);
        }
    }

    public void setCloseIconVisible(int i10) {
        setCloseIconVisible(getResources().getBoolean(i10));
    }

    @Override // androidx.appcompat.widget.AppCompatCheckBox, android.widget.TextView
    public void setCompoundDrawables(Drawable drawable, Drawable drawable2, Drawable drawable3, Drawable drawable4) {
        if (drawable != null) {
            throw new UnsupportedOperationException("Please set start drawable using R.attr#chipIcon.");
        }
        if (drawable3 != null) {
            throw new UnsupportedOperationException("Please set end drawable using R.attr#closeIcon.");
        }
        super.setCompoundDrawables(drawable, drawable2, drawable3, drawable4);
    }

    @Override // androidx.appcompat.widget.AppCompatCheckBox, android.widget.TextView
    public void setCompoundDrawablesRelative(Drawable drawable, Drawable drawable2, Drawable drawable3, Drawable drawable4) {
        if (drawable != null) {
            throw new UnsupportedOperationException("Please set start drawable using R.attr#chipIcon.");
        }
        if (drawable3 != null) {
            throw new UnsupportedOperationException("Please set end drawable using R.attr#closeIcon.");
        }
        super.setCompoundDrawablesRelative(drawable, drawable2, drawable3, drawable4);
    }

    @Override // android.widget.TextView
    public void setCompoundDrawablesRelativeWithIntrinsicBounds(int i10, int i11, int i12, int i13) {
        if (i10 != 0) {
            throw new UnsupportedOperationException("Please set start drawable using R.attr#chipIcon.");
        }
        if (i12 != 0) {
            throw new UnsupportedOperationException("Please set end drawable using R.attr#closeIcon.");
        }
        super.setCompoundDrawablesRelativeWithIntrinsicBounds(i10, i11, i12, i13);
    }

    @Override // android.widget.TextView
    public void setCompoundDrawablesWithIntrinsicBounds(int i10, int i11, int i12, int i13) {
        if (i10 != 0) {
            throw new UnsupportedOperationException("Please set start drawable using R.attr#chipIcon.");
        }
        if (i12 != 0) {
            throw new UnsupportedOperationException("Please set end drawable using R.attr#closeIcon.");
        }
        super.setCompoundDrawablesWithIntrinsicBounds(i10, i11, i12, i13);
    }

    @Override // android.view.View
    public void setElevation(float f10) {
        super.setElevation(f10);
        com.google.android.material.chip.a aVar = this.f20618e;
        if (aVar != null) {
            aVar.f0(f10);
        }
    }

    @Override // android.widget.TextView
    public void setEllipsize(TextUtils.TruncateAt truncateAt) {
        if (this.f20618e == null) {
            return;
        }
        if (truncateAt == TextUtils.TruncateAt.MARQUEE) {
            throw new UnsupportedOperationException("Text within a chip are not allowed to scroll.");
        }
        super.setEllipsize(truncateAt);
        com.google.android.material.chip.a aVar = this.f20618e;
        if (aVar != null) {
            aVar.D2(truncateAt);
        }
    }

    public void setEnsureMinTouchTargetSize(boolean z10) {
        this.f20627n = z10;
        m(this.f20629p);
    }

    @Override // android.widget.TextView
    public void setGravity(int i10) {
        if (i10 != 8388627) {
            Log.w("Chip", "Chip text must be vertically center and start aligned");
        } else {
            super.setGravity(i10);
        }
    }

    public void setHideMotionSpec(h hVar) {
        com.google.android.material.chip.a aVar = this.f20618e;
        if (aVar != null) {
            aVar.E2(hVar);
        }
    }

    public void setHideMotionSpecResource(int i10) {
        com.google.android.material.chip.a aVar = this.f20618e;
        if (aVar != null) {
            aVar.F2(i10);
        }
    }

    public void setIconEndPadding(float f10) {
        com.google.android.material.chip.a aVar = this.f20618e;
        if (aVar != null) {
            aVar.G2(f10);
        }
    }

    public void setIconEndPaddingResource(int i10) {
        com.google.android.material.chip.a aVar = this.f20618e;
        if (aVar != null) {
            aVar.H2(i10);
        }
    }

    public void setIconStartPadding(float f10) {
        com.google.android.material.chip.a aVar = this.f20618e;
        if (aVar != null) {
            aVar.I2(f10);
        }
    }

    public void setIconStartPaddingResource(int i10) {
        com.google.android.material.chip.a aVar = this.f20618e;
        if (aVar != null) {
            aVar.J2(i10);
        }
    }

    public void setInternalOnCheckedChangeListener(j<Chip> jVar) {
    }

    @Override // android.view.View
    public void setLayoutDirection(int i10) {
        if (this.f20618e == null) {
            return;
        }
        super.setLayoutDirection(i10);
    }

    @Override // android.widget.TextView
    public void setLines(int i10) {
        if (i10 > 1) {
            throw new UnsupportedOperationException("Chip does not support multi-line text");
        }
        super.setLines(i10);
    }

    @Override // android.widget.TextView
    public void setMaxLines(int i10) {
        if (i10 > 1) {
            throw new UnsupportedOperationException("Chip does not support multi-line text");
        }
        super.setMaxLines(i10);
    }

    @Override // android.widget.TextView
    public void setMaxWidth(int i10) {
        super.setMaxWidth(i10);
        com.google.android.material.chip.a aVar = this.f20618e;
        if (aVar != null) {
            aVar.K2(i10);
        }
    }

    @Override // android.widget.TextView
    public void setMinLines(int i10) {
        if (i10 > 1) {
            throw new UnsupportedOperationException("Chip does not support multi-line text");
        }
        super.setMinLines(i10);
    }

    @Override // android.widget.CompoundButton
    public void setOnCheckedChangeListener(CompoundButton.OnCheckedChangeListener onCheckedChangeListener) {
        this.f20622i = onCheckedChangeListener;
    }

    public void setOnCloseIconClickListener(View.OnClickListener onClickListener) {
        this.f20621h = onClickListener;
        x();
    }

    public void setRippleColor(ColorStateList colorStateList) {
        com.google.android.material.chip.a aVar = this.f20618e;
        if (aVar != null) {
            aVar.L2(colorStateList);
        }
        if (this.f20618e.y1()) {
            return;
        }
        z();
    }

    public void setRippleColorResource(int i10) {
        com.google.android.material.chip.a aVar = this.f20618e;
        if (aVar != null) {
            aVar.M2(i10);
            if (this.f20618e.y1()) {
                return;
            }
            z();
        }
    }

    @Override // Z2.o
    public void setShapeAppearanceModel(l lVar) {
        this.f20618e.setShapeAppearanceModel(lVar);
    }

    public void setShowMotionSpec(h hVar) {
        com.google.android.material.chip.a aVar = this.f20618e;
        if (aVar != null) {
            aVar.O2(hVar);
        }
    }

    public void setShowMotionSpecResource(int i10) {
        com.google.android.material.chip.a aVar = this.f20618e;
        if (aVar != null) {
            aVar.P2(i10);
        }
    }

    @Override // android.widget.TextView
    public void setSingleLine(boolean z10) {
        if (!z10) {
            throw new UnsupportedOperationException("Chip does not support multi-line text");
        }
        super.setSingleLine(z10);
    }

    @Override // android.widget.TextView
    public void setText(CharSequence charSequence, TextView.BufferType bufferType) {
        com.google.android.material.chip.a aVar = this.f20618e;
        if (aVar == null) {
            return;
        }
        if (charSequence == null) {
            charSequence = "";
        }
        super.setText(aVar.Z2() ? null : charSequence, bufferType);
        com.google.android.material.chip.a aVar2 = this.f20618e;
        if (aVar2 != null) {
            aVar2.Q2(charSequence);
        }
    }

    public void setTextAppearance(d dVar) {
        com.google.android.material.chip.a aVar = this.f20618e;
        if (aVar != null) {
            aVar.R2(dVar);
        }
        B();
    }

    public void setTextAppearanceResource(int i10) {
        setTextAppearance(getContext(), i10);
    }

    public void setTextEndPadding(float f10) {
        com.google.android.material.chip.a aVar = this.f20618e;
        if (aVar != null) {
            aVar.T2(f10);
        }
    }

    public void setTextEndPaddingResource(int i10) {
        com.google.android.material.chip.a aVar = this.f20618e;
        if (aVar != null) {
            aVar.U2(i10);
        }
    }

    @Override // android.widget.TextView
    public void setTextSize(int i10, float f10) {
        super.setTextSize(i10, f10);
        com.google.android.material.chip.a aVar = this.f20618e;
        if (aVar != null) {
            aVar.V2(TypedValue.applyDimension(i10, f10, getResources().getDisplayMetrics()));
        }
        B();
    }

    public void setTextStartPadding(float f10) {
        com.google.android.material.chip.a aVar = this.f20618e;
        if (aVar != null) {
            aVar.W2(f10);
        }
    }

    public void setTextStartPaddingResource(int i10) {
        com.google.android.material.chip.a aVar = this.f20618e;
        if (aVar != null) {
            aVar.X2(i10);
        }
    }

    public boolean t() {
        boolean z10 = false;
        playSoundEffect(0);
        View.OnClickListener onClickListener = this.f20621h;
        if (onClickListener != null) {
            onClickListener.onClick(this);
            z10 = true;
        }
        if (this.f20632s) {
            this.f20631r.H(1, 1);
        }
        return z10;
    }

    public final void u() {
        if (this.f20619f != null) {
            this.f20619f = null;
            setMinWidth(0);
            setMinHeight((int) getChipMinHeight());
            y();
        }
    }

    public boolean v() {
        return this.f20627n;
    }

    public final void w(com.google.android.material.chip.a aVar) {
        if (aVar != null) {
            aVar.C2(null);
        }
    }

    public final void x() {
        if (n() && s() && this.f20621h != null) {
            N.i0(this, this.f20631r);
            this.f20632s = true;
        } else {
            N.i0(this, null);
            this.f20632s = false;
        }
    }

    public final void y() {
        z();
    }

    public final void z() {
        this.f20620g = new RippleDrawable(X2.a.d(this.f20618e.r1()), getBackgroundDrawable(), null);
        this.f20618e.Y2(false);
        setBackground(this.f20620g);
        A();
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public Chip(Context context, AttributeSet attributeSet, int i10) {
        int i11 = f20614w;
        super(C3953a.d(context, attributeSet, i10, i11), attributeSet, i10);
        this.f20633t = new Rect();
        this.f20634u = new RectF();
        this.f20635v = new a();
        Context context2 = getContext();
        C(attributeSet);
        com.google.android.material.chip.a aVarH0 = com.google.android.material.chip.a.H0(context2, attributeSet, i10, i11);
        o(context2, attributeSet, i10);
        setChipDrawable(aVarH0);
        aVarH0.f0(getElevation());
        TypedArray typedArrayI = r.i(context2, attributeSet, R$styleable.Chip, i10, i11, new int[0]);
        boolean zHasValue = typedArrayI.hasValue(R$styleable.Chip_shapeAppearance);
        typedArrayI.recycle();
        this.f20631r = new c(this);
        x();
        if (!zHasValue) {
            p();
        }
        setChecked(this.f20623j);
        setText(aVarH0.t1());
        setEllipsize(aVarH0.n1());
        B();
        if (!this.f20618e.Z2()) {
            setLines(1);
            setHorizontallyScrolling(true);
        }
        setGravity(8388627);
        A();
        if (v()) {
            setMinHeight(this.f20629p);
        }
        this.f20628o = getLayoutDirection();
        super.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() { // from class: J2.a
            @Override // android.widget.CompoundButton.OnCheckedChangeListener
            public final void onCheckedChanged(CompoundButton compoundButton, boolean z10) {
                Chip.b(this.f3698a, compoundButton, z10);
            }
        });
    }

    public void setCloseIconVisible(boolean z10) {
        com.google.android.material.chip.a aVar = this.f20618e;
        if (aVar != null) {
            aVar.B2(z10);
        }
        x();
    }

    public void setCheckedIconVisible(boolean z10) {
        com.google.android.material.chip.a aVar = this.f20618e;
        if (aVar != null) {
            aVar.R1(z10);
        }
    }

    public void setChipIconVisible(boolean z10) {
        com.google.android.material.chip.a aVar = this.f20618e;
        if (aVar != null) {
            aVar.f2(z10);
        }
    }

    @Override // android.widget.TextView
    public void setCompoundDrawablesRelativeWithIntrinsicBounds(Drawable drawable, Drawable drawable2, Drawable drawable3, Drawable drawable4) {
        if (drawable != null) {
            throw new UnsupportedOperationException("Please set start drawable using R.attr#chipIcon.");
        }
        if (drawable3 == null) {
            super.setCompoundDrawablesRelativeWithIntrinsicBounds(drawable, drawable2, drawable3, drawable4);
            return;
        }
        throw new UnsupportedOperationException("Please set end drawable using R.attr#closeIcon.");
    }

    @Override // android.widget.TextView
    public void setCompoundDrawablesWithIntrinsicBounds(Drawable drawable, Drawable drawable2, Drawable drawable3, Drawable drawable4) {
        if (drawable != null) {
            throw new UnsupportedOperationException("Please set left drawable using R.attr#chipIcon.");
        }
        if (drawable3 == null) {
            super.setCompoundDrawablesWithIntrinsicBounds(drawable, drawable2, drawable3, drawable4);
            return;
        }
        throw new UnsupportedOperationException("Please set right drawable using R.attr#closeIcon.");
    }

    @Override // android.widget.TextView
    public void setTextAppearance(Context context, int i10) {
        super.setTextAppearance(context, i10);
        com.google.android.material.chip.a aVar = this.f20618e;
        if (aVar != null) {
            aVar.S2(i10);
        }
        B();
    }

    @Override // android.widget.TextView
    public void setTextAppearance(int i10) {
        super.setTextAppearance(i10);
        com.google.android.material.chip.a aVar = this.f20618e;
        if (aVar != null) {
            aVar.S2(i10);
        }
        B();
    }
}
