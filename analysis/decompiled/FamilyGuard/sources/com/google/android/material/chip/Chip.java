package com.google.android.material.chip;

import E.c;
import a1.C0409b;
import a1.C0416i;
import a1.C0417j;
import a1.C0418k;
import android.R;
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
import androidx.appcompat.widget.C0437g;
import androidx.core.view.H;
import b1.h;
import com.google.android.material.chip.Chip;
import com.google.android.material.chip.a;
import com.google.android.material.internal.j;
import java.util.List;
import org.libpag.BuildConfig;
import q1.C0980b;
import q1.C0982d;
import q1.f;
import r1.C0994a;
import t1.C1116i;
import t1.l;
import t1.o;
import x1.C1282a;

/* loaded from: classes.dex */
public class Chip extends C0437g implements a.InterfaceC0162a, o, Checkable {

    /* renamed from: w, reason: collision with root package name */
    private static final int f12549w = C0417j.f6926q;

    /* renamed from: x, reason: collision with root package name */
    private static final Rect f12550x = new Rect();

    /* renamed from: y, reason: collision with root package name */
    private static final int[] f12551y = {R.attr.state_selected};

    /* renamed from: z, reason: collision with root package name */
    private static final int[] f12552z = {R.attr.state_checkable};

    /* renamed from: e, reason: collision with root package name */
    private com.google.android.material.chip.a f12553e;

    /* renamed from: f, reason: collision with root package name */
    private InsetDrawable f12554f;

    /* renamed from: g, reason: collision with root package name */
    private RippleDrawable f12555g;

    /* renamed from: h, reason: collision with root package name */
    private View.OnClickListener f12556h;

    /* renamed from: i, reason: collision with root package name */
    private CompoundButton.OnCheckedChangeListener f12557i;

    /* renamed from: j, reason: collision with root package name */
    private boolean f12558j;

    /* renamed from: k, reason: collision with root package name */
    private boolean f12559k;

    /* renamed from: l, reason: collision with root package name */
    private boolean f12560l;

    /* renamed from: m, reason: collision with root package name */
    private boolean f12561m;

    /* renamed from: n, reason: collision with root package name */
    private boolean f12562n;

    /* renamed from: o, reason: collision with root package name */
    private int f12563o;

    /* renamed from: p, reason: collision with root package name */
    private int f12564p;

    /* renamed from: q, reason: collision with root package name */
    private CharSequence f12565q;

    /* renamed from: r, reason: collision with root package name */
    private final c f12566r;

    /* renamed from: s, reason: collision with root package name */
    private boolean f12567s;

    /* renamed from: t, reason: collision with root package name */
    private final Rect f12568t;

    /* renamed from: u, reason: collision with root package name */
    private final RectF f12569u;

    /* renamed from: v, reason: collision with root package name */
    private final f f12570v;

    class a extends f {
        a() {
        }

        @Override // q1.f
        public void a(int i5) {
        }

        @Override // q1.f
        public void b(Typeface typeface, boolean z5) {
            Chip chip = Chip.this;
            chip.setText(chip.f12553e.Z2() ? Chip.this.f12553e.t1() : Chip.this.getText());
            Chip.this.requestLayout();
            Chip.this.invalidate();
        }
    }

    class b extends ViewOutlineProvider {
        b() {
        }

        @Override // android.view.ViewOutlineProvider
        public void getOutline(View view, Outline outline) {
            if (Chip.this.f12553e != null) {
                Chip.this.f12553e.getOutline(outline);
            } else {
                outline.setAlpha(0.0f);
            }
        }
    }

    private class c extends J.a {
        c(Chip chip) {
            super(chip);
        }

        @Override // J.a
        protected void A(int i5, E.c cVar) {
            CharSequence charSequence = BuildConfig.FLAVOR;
            if (i5 != 1) {
                cVar.h0(BuildConfig.FLAVOR);
                cVar.Z(Chip.f12550x);
                return;
            }
            CharSequence closeIconContentDescription = Chip.this.getCloseIconContentDescription();
            if (closeIconContentDescription != null) {
                cVar.h0(closeIconContentDescription);
            } else {
                CharSequence text = Chip.this.getText();
                Context context = Chip.this.getContext();
                int i6 = C0416i.f6895k;
                if (!TextUtils.isEmpty(text)) {
                    charSequence = text;
                }
                cVar.h0(context.getString(i6, charSequence).trim());
            }
            cVar.Z(Chip.this.getCloseIconTouchBoundsInt());
            cVar.b(c.a.f1250i);
            cVar.j0(Chip.this.isEnabled());
            cVar.d0(Button.class.getName());
        }

        @Override // J.a
        protected void B(int i5, boolean z5) {
            if (i5 == 1) {
                Chip.this.f12561m = z5;
            }
            if (Chip.this.f12553e.J1(Chip.this.f12561m)) {
                Chip.this.refreshDrawableState();
            }
        }

        @Override // J.a
        protected int o(float f5, float f6) {
            return (Chip.this.n() && Chip.this.getCloseIconTouchBounds().contains(f5, f6)) ? 1 : 0;
        }

        @Override // J.a
        protected void p(List<Integer> list) {
            list.add(0);
            if (Chip.this.n() && Chip.this.s() && Chip.this.f12556h != null) {
                list.add(1);
            }
        }

        @Override // J.a
        protected boolean w(int i5, int i6, Bundle bundle) {
            if (i6 != 16) {
                return false;
            }
            if (i5 == 0) {
                return Chip.this.performClick();
            }
            if (i5 == 1) {
                return Chip.this.t();
            }
            return false;
        }

        @Override // J.a
        protected void z(E.c cVar) {
            cVar.b0(Chip.this.r());
            cVar.e0(Chip.this.isClickable());
            cVar.d0(Chip.this.getAccessibilityClassName());
            cVar.A0(Chip.this.getText());
        }
    }

    public Chip(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, C0409b.f6716c);
    }

    private void A() {
        com.google.android.material.chip.a aVar;
        if (TextUtils.isEmpty(getText()) || (aVar = this.f12553e) == null) {
            return;
        }
        int iV0 = (int) (aVar.V0() + this.f12553e.v1() + this.f12553e.C0());
        int iA1 = (int) (this.f12553e.a1() + this.f12553e.w1() + this.f12553e.y0());
        if (this.f12554f != null) {
            Rect rect = new Rect();
            this.f12554f.getPadding(rect);
            iA1 += rect.left;
            iV0 += rect.right;
        }
        setPaddingRelative(iA1, getPaddingTop(), iV0, getPaddingBottom());
    }

    private void B() {
        TextPaint paint = getPaint();
        com.google.android.material.chip.a aVar = this.f12553e;
        if (aVar != null) {
            paint.drawableState = aVar.getState();
        }
        C0982d textAppearance = getTextAppearance();
        if (textAppearance != null) {
            textAppearance.p(getContext(), paint, this.f12570v);
        }
    }

    private void C(AttributeSet attributeSet) {
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

    public static /* synthetic */ void b(Chip chip, CompoundButton compoundButton, boolean z5) {
        CompoundButton.OnCheckedChangeListener onCheckedChangeListener = chip.f12557i;
        if (onCheckedChangeListener != null) {
            onCheckedChangeListener.onCheckedChanged(compoundButton, z5);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public RectF getCloseIconTouchBounds() {
        this.f12569u.setEmpty();
        if (n() && this.f12556h != null) {
            this.f12553e.k1(this.f12569u);
        }
        return this.f12569u;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Rect getCloseIconTouchBoundsInt() {
        RectF closeIconTouchBounds = getCloseIconTouchBounds();
        this.f12568t.set((int) closeIconTouchBounds.left, (int) closeIconTouchBounds.top, (int) closeIconTouchBounds.right, (int) closeIconTouchBounds.bottom);
        return this.f12568t;
    }

    private C0982d getTextAppearance() {
        com.google.android.material.chip.a aVar = this.f12553e;
        if (aVar != null) {
            return aVar.u1();
        }
        return null;
    }

    private void k(com.google.android.material.chip.a aVar) {
        aVar.C2(this);
    }

    /* JADX WARN: Type inference failed for: r0v0, types: [boolean, int] */
    private int[] l() {
        ?? IsEnabled = isEnabled();
        int i5 = IsEnabled;
        if (this.f12561m) {
            i5 = IsEnabled + 1;
        }
        int i6 = i5;
        if (this.f12560l) {
            i6 = i5 + 1;
        }
        int i7 = i6;
        if (this.f12559k) {
            i7 = i6 + 1;
        }
        int i8 = i7;
        if (isChecked()) {
            i8 = i7 + 1;
        }
        int[] iArr = new int[i8];
        int i9 = 0;
        if (isEnabled()) {
            iArr[0] = 16842910;
            i9 = 1;
        }
        if (this.f12561m) {
            iArr[i9] = 16842908;
            i9++;
        }
        if (this.f12560l) {
            iArr[i9] = 16843623;
            i9++;
        }
        if (this.f12559k) {
            iArr[i9] = 16842919;
            i9++;
        }
        if (isChecked()) {
            iArr[i9] = 16842913;
        }
        return iArr;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean n() {
        com.google.android.material.chip.a aVar = this.f12553e;
        return (aVar == null || aVar.d1() == null) ? false : true;
    }

    private void o(Context context, AttributeSet attributeSet, int i5) {
        TypedArray typedArrayI = com.google.android.material.internal.o.i(context, attributeSet, C0418k.f7055U, i5, f12549w, new int[0]);
        this.f12562n = typedArrayI.getBoolean(C0418k.f6936A0, false);
        this.f12564p = (int) Math.ceil(typedArrayI.getDimension(C0418k.f7181o0, C0980b.e(context)));
        typedArrayI.recycle();
    }

    private void p() {
        setOutlineProvider(new b());
    }

    private void q(int i5, int i6, int i7, int i8) {
        this.f12554f = new InsetDrawable((Drawable) this.f12553e, i5, i6, i7, i8);
    }

    private void setCloseIconHovered(boolean z5) {
        if (this.f12560l != z5) {
            this.f12560l = z5;
            refreshDrawableState();
        }
    }

    private void setCloseIconPressed(boolean z5) {
        if (this.f12559k != z5) {
            this.f12559k = z5;
            refreshDrawableState();
        }
    }

    private void u() {
        if (this.f12554f != null) {
            this.f12554f = null;
            setMinWidth(0);
            setMinHeight((int) getChipMinHeight());
            y();
        }
    }

    private void w(com.google.android.material.chip.a aVar) {
        if (aVar != null) {
            aVar.C2(null);
        }
    }

    private void x() {
        if (n() && s() && this.f12556h != null) {
            H.k0(this, this.f12566r);
            this.f12567s = true;
        } else {
            H.k0(this, null);
            this.f12567s = false;
        }
    }

    private void y() {
        z();
    }

    private void z() {
        this.f12555g = new RippleDrawable(C0994a.a(this.f12553e.r1()), getBackgroundDrawable(), null);
        this.f12553e.Y2(false);
        setBackground(this.f12555g);
        A();
    }

    @Override // com.google.android.material.chip.a.InterfaceC0162a
    public void a() {
        m(this.f12564p);
        requestLayout();
        invalidateOutline();
    }

    @Override // android.view.View
    protected boolean dispatchHoverEvent(MotionEvent motionEvent) {
        return !this.f12567s ? super.dispatchHoverEvent(motionEvent) : this.f12566r.i(motionEvent) || super.dispatchHoverEvent(motionEvent);
    }

    @Override // android.view.View
    public boolean dispatchKeyEvent(KeyEvent keyEvent) {
        if (!this.f12567s) {
            return super.dispatchKeyEvent(keyEvent);
        }
        if (!this.f12566r.j(keyEvent) || this.f12566r.n() == Integer.MIN_VALUE) {
            return super.dispatchKeyEvent(keyEvent);
        }
        return true;
    }

    @Override // androidx.appcompat.widget.C0437g, android.widget.CompoundButton, android.widget.TextView, android.view.View
    protected void drawableStateChanged() {
        super.drawableStateChanged();
        com.google.android.material.chip.a aVar = this.f12553e;
        if ((aVar == null || !aVar.B1()) ? false : this.f12553e.y2(l())) {
            invalidate();
        }
    }

    @Override // android.widget.CheckBox, android.widget.CompoundButton, android.widget.Button, android.widget.TextView, android.view.View
    public CharSequence getAccessibilityClassName() {
        if (!TextUtils.isEmpty(this.f12565q)) {
            return this.f12565q;
        }
        if (!r()) {
            return isClickable() ? "android.widget.Button" : "android.view.View";
        }
        ViewParent parent = getParent();
        return ((parent instanceof com.google.android.material.chip.b) && ((com.google.android.material.chip.b) parent).f()) ? "android.widget.RadioButton" : "android.widget.Button";
    }

    public Drawable getBackgroundDrawable() {
        InsetDrawable insetDrawable = this.f12554f;
        return insetDrawable == null ? this.f12553e : insetDrawable;
    }

    public Drawable getCheckedIcon() {
        com.google.android.material.chip.a aVar = this.f12553e;
        if (aVar != null) {
            return aVar.R0();
        }
        return null;
    }

    public ColorStateList getCheckedIconTint() {
        com.google.android.material.chip.a aVar = this.f12553e;
        if (aVar != null) {
            return aVar.S0();
        }
        return null;
    }

    public ColorStateList getChipBackgroundColor() {
        com.google.android.material.chip.a aVar = this.f12553e;
        if (aVar != null) {
            return aVar.T0();
        }
        return null;
    }

    public float getChipCornerRadius() {
        com.google.android.material.chip.a aVar = this.f12553e;
        if (aVar != null) {
            return Math.max(0.0f, aVar.U0());
        }
        return 0.0f;
    }

    public Drawable getChipDrawable() {
        return this.f12553e;
    }

    public float getChipEndPadding() {
        com.google.android.material.chip.a aVar = this.f12553e;
        if (aVar != null) {
            return aVar.V0();
        }
        return 0.0f;
    }

    public Drawable getChipIcon() {
        com.google.android.material.chip.a aVar = this.f12553e;
        if (aVar != null) {
            return aVar.W0();
        }
        return null;
    }

    public float getChipIconSize() {
        com.google.android.material.chip.a aVar = this.f12553e;
        if (aVar != null) {
            return aVar.X0();
        }
        return 0.0f;
    }

    public ColorStateList getChipIconTint() {
        com.google.android.material.chip.a aVar = this.f12553e;
        if (aVar != null) {
            return aVar.Y0();
        }
        return null;
    }

    public float getChipMinHeight() {
        com.google.android.material.chip.a aVar = this.f12553e;
        if (aVar != null) {
            return aVar.Z0();
        }
        return 0.0f;
    }

    public float getChipStartPadding() {
        com.google.android.material.chip.a aVar = this.f12553e;
        if (aVar != null) {
            return aVar.a1();
        }
        return 0.0f;
    }

    public ColorStateList getChipStrokeColor() {
        com.google.android.material.chip.a aVar = this.f12553e;
        if (aVar != null) {
            return aVar.b1();
        }
        return null;
    }

    public float getChipStrokeWidth() {
        com.google.android.material.chip.a aVar = this.f12553e;
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
        com.google.android.material.chip.a aVar = this.f12553e;
        if (aVar != null) {
            return aVar.d1();
        }
        return null;
    }

    public CharSequence getCloseIconContentDescription() {
        com.google.android.material.chip.a aVar = this.f12553e;
        if (aVar != null) {
            return aVar.e1();
        }
        return null;
    }

    public float getCloseIconEndPadding() {
        com.google.android.material.chip.a aVar = this.f12553e;
        if (aVar != null) {
            return aVar.f1();
        }
        return 0.0f;
    }

    public float getCloseIconSize() {
        com.google.android.material.chip.a aVar = this.f12553e;
        if (aVar != null) {
            return aVar.g1();
        }
        return 0.0f;
    }

    public float getCloseIconStartPadding() {
        com.google.android.material.chip.a aVar = this.f12553e;
        if (aVar != null) {
            return aVar.h1();
        }
        return 0.0f;
    }

    public ColorStateList getCloseIconTint() {
        com.google.android.material.chip.a aVar = this.f12553e;
        if (aVar != null) {
            return aVar.j1();
        }
        return null;
    }

    @Override // android.widget.TextView
    public TextUtils.TruncateAt getEllipsize() {
        com.google.android.material.chip.a aVar = this.f12553e;
        if (aVar != null) {
            return aVar.n1();
        }
        return null;
    }

    @Override // android.widget.TextView, android.view.View
    public void getFocusedRect(Rect rect) {
        if (this.f12567s && (this.f12566r.n() == 1 || this.f12566r.k() == 1)) {
            rect.set(getCloseIconTouchBoundsInt());
        } else {
            super.getFocusedRect(rect);
        }
    }

    public h getHideMotionSpec() {
        com.google.android.material.chip.a aVar = this.f12553e;
        if (aVar != null) {
            return aVar.o1();
        }
        return null;
    }

    public float getIconEndPadding() {
        com.google.android.material.chip.a aVar = this.f12553e;
        if (aVar != null) {
            return aVar.p1();
        }
        return 0.0f;
    }

    public float getIconStartPadding() {
        com.google.android.material.chip.a aVar = this.f12553e;
        if (aVar != null) {
            return aVar.q1();
        }
        return 0.0f;
    }

    public ColorStateList getRippleColor() {
        com.google.android.material.chip.a aVar = this.f12553e;
        if (aVar != null) {
            return aVar.r1();
        }
        return null;
    }

    public l getShapeAppearanceModel() {
        return this.f12553e.I();
    }

    public h getShowMotionSpec() {
        com.google.android.material.chip.a aVar = this.f12553e;
        if (aVar != null) {
            return aVar.s1();
        }
        return null;
    }

    public float getTextEndPadding() {
        com.google.android.material.chip.a aVar = this.f12553e;
        if (aVar != null) {
            return aVar.v1();
        }
        return 0.0f;
    }

    public float getTextStartPadding() {
        com.google.android.material.chip.a aVar = this.f12553e;
        if (aVar != null) {
            return aVar.w1();
        }
        return 0.0f;
    }

    public boolean m(int i5) {
        this.f12564p = i5;
        if (!v()) {
            if (this.f12554f != null) {
                u();
            } else {
                y();
            }
            return false;
        }
        int iMax = Math.max(0, i5 - this.f12553e.getIntrinsicHeight());
        int iMax2 = Math.max(0, i5 - this.f12553e.getIntrinsicWidth());
        if (iMax2 <= 0 && iMax <= 0) {
            if (this.f12554f != null) {
                u();
            } else {
                y();
            }
            return false;
        }
        int i6 = iMax2 > 0 ? iMax2 / 2 : 0;
        int i7 = iMax > 0 ? iMax / 2 : 0;
        if (this.f12554f != null) {
            Rect rect = new Rect();
            this.f12554f.getPadding(rect);
            if (rect.top == i7 && rect.bottom == i7 && rect.left == i6 && rect.right == i6) {
                y();
                return true;
            }
        }
        if (getMinHeight() != i5) {
            setMinHeight(i5);
        }
        if (getMinWidth() != i5) {
            setMinWidth(i5);
        }
        q(i6, i7, i6, i7);
        y();
        return true;
    }

    @Override // android.widget.TextView, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        C1116i.f(this, this.f12553e);
    }

    @Override // android.widget.CompoundButton, android.widget.TextView, android.view.View
    protected int[] onCreateDrawableState(int i5) {
        int[] iArrOnCreateDrawableState = super.onCreateDrawableState(i5 + 2);
        if (isChecked()) {
            View.mergeDrawableStates(iArrOnCreateDrawableState, f12551y);
        }
        if (r()) {
            View.mergeDrawableStates(iArrOnCreateDrawableState, f12552z);
        }
        return iArrOnCreateDrawableState;
    }

    @Override // android.widget.TextView, android.view.View
    protected void onFocusChanged(boolean z5, int i5, Rect rect) {
        super.onFocusChanged(z5, i5, rect);
        if (this.f12567s) {
            this.f12566r.v(z5, i5, rect);
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
        if (getParent() instanceof com.google.android.material.chip.b) {
            com.google.android.material.chip.b bVar = (com.google.android.material.chip.b) getParent();
            E.c.E0(accessibilityNodeInfo).g0(c.f.a(bVar.b(this), 1, bVar.c() ? bVar.d(this) : -1, 1, false, isChecked()));
        }
    }

    @Override // android.widget.Button, android.widget.TextView, android.view.View
    public PointerIcon onResolvePointerIcon(MotionEvent motionEvent, int i5) {
        return (getCloseIconTouchBounds().contains(motionEvent.getX(), motionEvent.getY()) && isEnabled()) ? PointerIcon.getSystemIcon(getContext(), 1002) : super.onResolvePointerIcon(motionEvent, i5);
    }

    @Override // android.widget.TextView, android.view.View
    public void onRtlPropertiesChanged(int i5) {
        super.onRtlPropertiesChanged(i5);
        if (this.f12563o != i5) {
            this.f12563o = i5;
            A();
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:8:0x001e, code lost:
    
        if (r0 != 3) goto L22;
     */
    @Override // android.widget.TextView, android.view.View
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
            boolean r0 = r5.f12559k
            if (r0 == 0) goto L40
            if (r1 != 0) goto L2a
            r5.setCloseIconPressed(r3)
        L2a:
            r0 = r2
            goto L41
        L2c:
            boolean r0 = r5.f12559k
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

    public boolean r() {
        com.google.android.material.chip.a aVar = this.f12553e;
        return aVar != null && aVar.A1();
    }

    public boolean s() {
        com.google.android.material.chip.a aVar = this.f12553e;
        return aVar != null && aVar.C1();
    }

    public void setAccessibilityClassName(CharSequence charSequence) {
        this.f12565q = charSequence;
    }

    @Override // android.view.View
    public void setBackground(Drawable drawable) {
        if (drawable == getBackgroundDrawable() || drawable == this.f12555g) {
            super.setBackground(drawable);
        } else {
            Log.w("Chip", "Do not set the background; Chip manages its own background drawable.");
        }
    }

    @Override // android.view.View
    public void setBackgroundColor(int i5) {
        Log.w("Chip", "Do not set the background color; Chip manages its own background drawable.");
    }

    @Override // androidx.appcompat.widget.C0437g, android.view.View
    public void setBackgroundDrawable(Drawable drawable) {
        if (drawable == getBackgroundDrawable() || drawable == this.f12555g) {
            super.setBackgroundDrawable(drawable);
        } else {
            Log.w("Chip", "Do not set the background drawable; Chip manages its own background drawable.");
        }
    }

    @Override // androidx.appcompat.widget.C0437g, android.view.View
    public void setBackgroundResource(int i5) {
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

    public void setCheckable(boolean z5) {
        com.google.android.material.chip.a aVar = this.f12553e;
        if (aVar != null) {
            aVar.K1(z5);
        }
    }

    public void setCheckableResource(int i5) {
        com.google.android.material.chip.a aVar = this.f12553e;
        if (aVar != null) {
            aVar.L1(i5);
        }
    }

    @Override // android.widget.CompoundButton, android.widget.Checkable
    public void setChecked(boolean z5) {
        com.google.android.material.chip.a aVar = this.f12553e;
        if (aVar == null) {
            this.f12558j = z5;
        } else if (aVar.A1()) {
            super.setChecked(z5);
        }
    }

    public void setCheckedIcon(Drawable drawable) {
        com.google.android.material.chip.a aVar = this.f12553e;
        if (aVar != null) {
            aVar.M1(drawable);
        }
    }

    @Deprecated
    public void setCheckedIconEnabled(boolean z5) {
        setCheckedIconVisible(z5);
    }

    @Deprecated
    public void setCheckedIconEnabledResource(int i5) {
        setCheckedIconVisible(i5);
    }

    public void setCheckedIconResource(int i5) {
        com.google.android.material.chip.a aVar = this.f12553e;
        if (aVar != null) {
            aVar.N1(i5);
        }
    }

    public void setCheckedIconTint(ColorStateList colorStateList) {
        com.google.android.material.chip.a aVar = this.f12553e;
        if (aVar != null) {
            aVar.O1(colorStateList);
        }
    }

    public void setCheckedIconTintResource(int i5) {
        com.google.android.material.chip.a aVar = this.f12553e;
        if (aVar != null) {
            aVar.P1(i5);
        }
    }

    public void setCheckedIconVisible(int i5) {
        com.google.android.material.chip.a aVar = this.f12553e;
        if (aVar != null) {
            aVar.Q1(i5);
        }
    }

    public void setChipBackgroundColor(ColorStateList colorStateList) {
        com.google.android.material.chip.a aVar = this.f12553e;
        if (aVar != null) {
            aVar.S1(colorStateList);
        }
    }

    public void setChipBackgroundColorResource(int i5) {
        com.google.android.material.chip.a aVar = this.f12553e;
        if (aVar != null) {
            aVar.T1(i5);
        }
    }

    @Deprecated
    public void setChipCornerRadius(float f5) {
        com.google.android.material.chip.a aVar = this.f12553e;
        if (aVar != null) {
            aVar.U1(f5);
        }
    }

    @Deprecated
    public void setChipCornerRadiusResource(int i5) {
        com.google.android.material.chip.a aVar = this.f12553e;
        if (aVar != null) {
            aVar.V1(i5);
        }
    }

    public void setChipDrawable(com.google.android.material.chip.a aVar) {
        com.google.android.material.chip.a aVar2 = this.f12553e;
        if (aVar2 != aVar) {
            w(aVar2);
            this.f12553e = aVar;
            aVar.N2(false);
            k(this.f12553e);
            m(this.f12564p);
        }
    }

    public void setChipEndPadding(float f5) {
        com.google.android.material.chip.a aVar = this.f12553e;
        if (aVar != null) {
            aVar.W1(f5);
        }
    }

    public void setChipEndPaddingResource(int i5) {
        com.google.android.material.chip.a aVar = this.f12553e;
        if (aVar != null) {
            aVar.X1(i5);
        }
    }

    public void setChipIcon(Drawable drawable) {
        com.google.android.material.chip.a aVar = this.f12553e;
        if (aVar != null) {
            aVar.Y1(drawable);
        }
    }

    @Deprecated
    public void setChipIconEnabled(boolean z5) {
        setChipIconVisible(z5);
    }

    @Deprecated
    public void setChipIconEnabledResource(int i5) {
        setChipIconVisible(i5);
    }

    public void setChipIconResource(int i5) {
        com.google.android.material.chip.a aVar = this.f12553e;
        if (aVar != null) {
            aVar.Z1(i5);
        }
    }

    public void setChipIconSize(float f5) {
        com.google.android.material.chip.a aVar = this.f12553e;
        if (aVar != null) {
            aVar.a2(f5);
        }
    }

    public void setChipIconSizeResource(int i5) {
        com.google.android.material.chip.a aVar = this.f12553e;
        if (aVar != null) {
            aVar.b2(i5);
        }
    }

    public void setChipIconTint(ColorStateList colorStateList) {
        com.google.android.material.chip.a aVar = this.f12553e;
        if (aVar != null) {
            aVar.c2(colorStateList);
        }
    }

    public void setChipIconTintResource(int i5) {
        com.google.android.material.chip.a aVar = this.f12553e;
        if (aVar != null) {
            aVar.d2(i5);
        }
    }

    public void setChipIconVisible(int i5) {
        com.google.android.material.chip.a aVar = this.f12553e;
        if (aVar != null) {
            aVar.e2(i5);
        }
    }

    public void setChipMinHeight(float f5) {
        com.google.android.material.chip.a aVar = this.f12553e;
        if (aVar != null) {
            aVar.g2(f5);
        }
    }

    public void setChipMinHeightResource(int i5) {
        com.google.android.material.chip.a aVar = this.f12553e;
        if (aVar != null) {
            aVar.h2(i5);
        }
    }

    public void setChipStartPadding(float f5) {
        com.google.android.material.chip.a aVar = this.f12553e;
        if (aVar != null) {
            aVar.i2(f5);
        }
    }

    public void setChipStartPaddingResource(int i5) {
        com.google.android.material.chip.a aVar = this.f12553e;
        if (aVar != null) {
            aVar.j2(i5);
        }
    }

    public void setChipStrokeColor(ColorStateList colorStateList) {
        com.google.android.material.chip.a aVar = this.f12553e;
        if (aVar != null) {
            aVar.k2(colorStateList);
        }
    }

    public void setChipStrokeColorResource(int i5) {
        com.google.android.material.chip.a aVar = this.f12553e;
        if (aVar != null) {
            aVar.l2(i5);
        }
    }

    public void setChipStrokeWidth(float f5) {
        com.google.android.material.chip.a aVar = this.f12553e;
        if (aVar != null) {
            aVar.m2(f5);
        }
    }

    public void setChipStrokeWidthResource(int i5) {
        com.google.android.material.chip.a aVar = this.f12553e;
        if (aVar != null) {
            aVar.n2(i5);
        }
    }

    @Deprecated
    public void setChipText(CharSequence charSequence) {
        setText(charSequence);
    }

    @Deprecated
    public void setChipTextResource(int i5) {
        setText(getResources().getString(i5));
    }

    public void setCloseIcon(Drawable drawable) {
        com.google.android.material.chip.a aVar = this.f12553e;
        if (aVar != null) {
            aVar.p2(drawable);
        }
        x();
    }

    public void setCloseIconContentDescription(CharSequence charSequence) {
        com.google.android.material.chip.a aVar = this.f12553e;
        if (aVar != null) {
            aVar.q2(charSequence);
        }
    }

    @Deprecated
    public void setCloseIconEnabled(boolean z5) {
        setCloseIconVisible(z5);
    }

    @Deprecated
    public void setCloseIconEnabledResource(int i5) {
        setCloseIconVisible(i5);
    }

    public void setCloseIconEndPadding(float f5) {
        com.google.android.material.chip.a aVar = this.f12553e;
        if (aVar != null) {
            aVar.r2(f5);
        }
    }

    public void setCloseIconEndPaddingResource(int i5) {
        com.google.android.material.chip.a aVar = this.f12553e;
        if (aVar != null) {
            aVar.s2(i5);
        }
    }

    public void setCloseIconResource(int i5) {
        com.google.android.material.chip.a aVar = this.f12553e;
        if (aVar != null) {
            aVar.t2(i5);
        }
        x();
    }

    public void setCloseIconSize(float f5) {
        com.google.android.material.chip.a aVar = this.f12553e;
        if (aVar != null) {
            aVar.u2(f5);
        }
    }

    public void setCloseIconSizeResource(int i5) {
        com.google.android.material.chip.a aVar = this.f12553e;
        if (aVar != null) {
            aVar.v2(i5);
        }
    }

    public void setCloseIconStartPadding(float f5) {
        com.google.android.material.chip.a aVar = this.f12553e;
        if (aVar != null) {
            aVar.w2(f5);
        }
    }

    public void setCloseIconStartPaddingResource(int i5) {
        com.google.android.material.chip.a aVar = this.f12553e;
        if (aVar != null) {
            aVar.x2(i5);
        }
    }

    public void setCloseIconTint(ColorStateList colorStateList) {
        com.google.android.material.chip.a aVar = this.f12553e;
        if (aVar != null) {
            aVar.z2(colorStateList);
        }
    }

    public void setCloseIconTintResource(int i5) {
        com.google.android.material.chip.a aVar = this.f12553e;
        if (aVar != null) {
            aVar.A2(i5);
        }
    }

    public void setCloseIconVisible(int i5) {
        setCloseIconVisible(getResources().getBoolean(i5));
    }

    @Override // androidx.appcompat.widget.C0437g, android.widget.TextView
    public void setCompoundDrawables(Drawable drawable, Drawable drawable2, Drawable drawable3, Drawable drawable4) {
        if (drawable != null) {
            throw new UnsupportedOperationException("Please set start drawable using R.attr#chipIcon.");
        }
        if (drawable3 != null) {
            throw new UnsupportedOperationException("Please set end drawable using R.attr#closeIcon.");
        }
        super.setCompoundDrawables(drawable, drawable2, drawable3, drawable4);
    }

    @Override // androidx.appcompat.widget.C0437g, android.widget.TextView
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
    public void setCompoundDrawablesRelativeWithIntrinsicBounds(int i5, int i6, int i7, int i8) {
        if (i5 != 0) {
            throw new UnsupportedOperationException("Please set start drawable using R.attr#chipIcon.");
        }
        if (i7 != 0) {
            throw new UnsupportedOperationException("Please set end drawable using R.attr#closeIcon.");
        }
        super.setCompoundDrawablesRelativeWithIntrinsicBounds(i5, i6, i7, i8);
    }

    @Override // android.widget.TextView
    public void setCompoundDrawablesWithIntrinsicBounds(int i5, int i6, int i7, int i8) {
        if (i5 != 0) {
            throw new UnsupportedOperationException("Please set start drawable using R.attr#chipIcon.");
        }
        if (i7 != 0) {
            throw new UnsupportedOperationException("Please set end drawable using R.attr#closeIcon.");
        }
        super.setCompoundDrawablesWithIntrinsicBounds(i5, i6, i7, i8);
    }

    @Override // android.view.View
    public void setElevation(float f5) {
        super.setElevation(f5);
        com.google.android.material.chip.a aVar = this.f12553e;
        if (aVar != null) {
            aVar.f0(f5);
        }
    }

    @Override // android.widget.TextView
    public void setEllipsize(TextUtils.TruncateAt truncateAt) {
        if (this.f12553e == null) {
            return;
        }
        if (truncateAt == TextUtils.TruncateAt.MARQUEE) {
            throw new UnsupportedOperationException("Text within a chip are not allowed to scroll.");
        }
        super.setEllipsize(truncateAt);
        com.google.android.material.chip.a aVar = this.f12553e;
        if (aVar != null) {
            aVar.D2(truncateAt);
        }
    }

    public void setEnsureMinTouchTargetSize(boolean z5) {
        this.f12562n = z5;
        m(this.f12564p);
    }

    @Override // android.widget.TextView
    public void setGravity(int i5) {
        if (i5 != 8388627) {
            Log.w("Chip", "Chip text must be vertically center and start aligned");
        } else {
            super.setGravity(i5);
        }
    }

    public void setHideMotionSpec(h hVar) {
        com.google.android.material.chip.a aVar = this.f12553e;
        if (aVar != null) {
            aVar.E2(hVar);
        }
    }

    public void setHideMotionSpecResource(int i5) {
        com.google.android.material.chip.a aVar = this.f12553e;
        if (aVar != null) {
            aVar.F2(i5);
        }
    }

    public void setIconEndPadding(float f5) {
        com.google.android.material.chip.a aVar = this.f12553e;
        if (aVar != null) {
            aVar.G2(f5);
        }
    }

    public void setIconEndPaddingResource(int i5) {
        com.google.android.material.chip.a aVar = this.f12553e;
        if (aVar != null) {
            aVar.H2(i5);
        }
    }

    public void setIconStartPadding(float f5) {
        com.google.android.material.chip.a aVar = this.f12553e;
        if (aVar != null) {
            aVar.I2(f5);
        }
    }

    public void setIconStartPaddingResource(int i5) {
        com.google.android.material.chip.a aVar = this.f12553e;
        if (aVar != null) {
            aVar.J2(i5);
        }
    }

    public void setInternalOnCheckedChangeListener(j<Chip> jVar) {
    }

    @Override // android.view.View
    public void setLayoutDirection(int i5) {
        if (this.f12553e == null) {
            return;
        }
        super.setLayoutDirection(i5);
    }

    @Override // android.widget.TextView
    public void setLines(int i5) {
        if (i5 > 1) {
            throw new UnsupportedOperationException("Chip does not support multi-line text");
        }
        super.setLines(i5);
    }

    @Override // android.widget.TextView
    public void setMaxLines(int i5) {
        if (i5 > 1) {
            throw new UnsupportedOperationException("Chip does not support multi-line text");
        }
        super.setMaxLines(i5);
    }

    @Override // android.widget.TextView
    public void setMaxWidth(int i5) {
        super.setMaxWidth(i5);
        com.google.android.material.chip.a aVar = this.f12553e;
        if (aVar != null) {
            aVar.K2(i5);
        }
    }

    @Override // android.widget.TextView
    public void setMinLines(int i5) {
        if (i5 > 1) {
            throw new UnsupportedOperationException("Chip does not support multi-line text");
        }
        super.setMinLines(i5);
    }

    @Override // android.widget.CompoundButton
    public void setOnCheckedChangeListener(CompoundButton.OnCheckedChangeListener onCheckedChangeListener) {
        this.f12557i = onCheckedChangeListener;
    }

    public void setOnCloseIconClickListener(View.OnClickListener onClickListener) {
        this.f12556h = onClickListener;
        x();
    }

    public void setRippleColor(ColorStateList colorStateList) {
        com.google.android.material.chip.a aVar = this.f12553e;
        if (aVar != null) {
            aVar.L2(colorStateList);
        }
        if (this.f12553e.y1()) {
            return;
        }
        z();
    }

    public void setRippleColorResource(int i5) {
        com.google.android.material.chip.a aVar = this.f12553e;
        if (aVar != null) {
            aVar.M2(i5);
            if (this.f12553e.y1()) {
                return;
            }
            z();
        }
    }

    @Override // t1.o
    public void setShapeAppearanceModel(l lVar) {
        this.f12553e.setShapeAppearanceModel(lVar);
    }

    public void setShowMotionSpec(h hVar) {
        com.google.android.material.chip.a aVar = this.f12553e;
        if (aVar != null) {
            aVar.O2(hVar);
        }
    }

    public void setShowMotionSpecResource(int i5) {
        com.google.android.material.chip.a aVar = this.f12553e;
        if (aVar != null) {
            aVar.P2(i5);
        }
    }

    @Override // android.widget.TextView
    public void setSingleLine(boolean z5) {
        if (!z5) {
            throw new UnsupportedOperationException("Chip does not support multi-line text");
        }
        super.setSingleLine(z5);
    }

    @Override // android.widget.TextView
    public void setText(CharSequence charSequence, TextView.BufferType bufferType) {
        com.google.android.material.chip.a aVar = this.f12553e;
        if (aVar == null) {
            return;
        }
        if (charSequence == null) {
            charSequence = BuildConfig.FLAVOR;
        }
        super.setText(aVar.Z2() ? null : charSequence, bufferType);
        com.google.android.material.chip.a aVar2 = this.f12553e;
        if (aVar2 != null) {
            aVar2.Q2(charSequence);
        }
    }

    public void setTextAppearance(C0982d c0982d) {
        com.google.android.material.chip.a aVar = this.f12553e;
        if (aVar != null) {
            aVar.R2(c0982d);
        }
        B();
    }

    public void setTextAppearanceResource(int i5) {
        setTextAppearance(getContext(), i5);
    }

    public void setTextEndPadding(float f5) {
        com.google.android.material.chip.a aVar = this.f12553e;
        if (aVar != null) {
            aVar.T2(f5);
        }
    }

    public void setTextEndPaddingResource(int i5) {
        com.google.android.material.chip.a aVar = this.f12553e;
        if (aVar != null) {
            aVar.U2(i5);
        }
    }

    @Override // android.widget.TextView
    public void setTextSize(int i5, float f5) {
        super.setTextSize(i5, f5);
        com.google.android.material.chip.a aVar = this.f12553e;
        if (aVar != null) {
            aVar.V2(TypedValue.applyDimension(i5, f5, getResources().getDisplayMetrics()));
        }
        B();
    }

    public void setTextStartPadding(float f5) {
        com.google.android.material.chip.a aVar = this.f12553e;
        if (aVar != null) {
            aVar.W2(f5);
        }
    }

    public void setTextStartPaddingResource(int i5) {
        com.google.android.material.chip.a aVar = this.f12553e;
        if (aVar != null) {
            aVar.X2(i5);
        }
    }

    public boolean t() {
        boolean z5 = false;
        playSoundEffect(0);
        View.OnClickListener onClickListener = this.f12556h;
        if (onClickListener != null) {
            onClickListener.onClick(this);
            z5 = true;
        }
        if (this.f12567s) {
            this.f12566r.H(1, 1);
        }
        return z5;
    }

    public boolean v() {
        return this.f12562n;
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public Chip(Context context, AttributeSet attributeSet, int i5) {
        int i6 = f12549w;
        super(C1282a.d(context, attributeSet, i5, i6), attributeSet, i5);
        this.f12568t = new Rect();
        this.f12569u = new RectF();
        this.f12570v = new a();
        Context context2 = getContext();
        C(attributeSet);
        com.google.android.material.chip.a aVarH0 = com.google.android.material.chip.a.H0(context2, attributeSet, i5, i6);
        o(context2, attributeSet, i5);
        setChipDrawable(aVarH0);
        aVarH0.f0(getElevation());
        TypedArray typedArrayI = com.google.android.material.internal.o.i(context2, attributeSet, C0418k.f7055U, i5, i6, new int[0]);
        boolean zHasValue = typedArrayI.hasValue(C0418k.f6966F0);
        typedArrayI.recycle();
        this.f12566r = new c(this);
        x();
        if (!zHasValue) {
            p();
        }
        setChecked(this.f12558j);
        setText(aVarH0.t1());
        setEllipsize(aVarH0.n1());
        B();
        if (!this.f12553e.Z2()) {
            setLines(1);
            setHorizontallyScrolling(true);
        }
        setGravity(8388627);
        A();
        if (v()) {
            setMinHeight(this.f12564p);
        }
        this.f12563o = getLayoutDirection();
        super.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() { // from class: g1.a
            @Override // android.widget.CompoundButton.OnCheckedChangeListener
            public final void onCheckedChanged(CompoundButton compoundButton, boolean z5) {
                Chip.b(this.f17226a, compoundButton, z5);
            }
        });
    }

    public void setCloseIconVisible(boolean z5) {
        com.google.android.material.chip.a aVar = this.f12553e;
        if (aVar != null) {
            aVar.B2(z5);
        }
        x();
    }

    public void setCheckedIconVisible(boolean z5) {
        com.google.android.material.chip.a aVar = this.f12553e;
        if (aVar != null) {
            aVar.R1(z5);
        }
    }

    public void setChipIconVisible(boolean z5) {
        com.google.android.material.chip.a aVar = this.f12553e;
        if (aVar != null) {
            aVar.f2(z5);
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
    public void setTextAppearance(Context context, int i5) {
        super.setTextAppearance(context, i5);
        com.google.android.material.chip.a aVar = this.f12553e;
        if (aVar != null) {
            aVar.S2(i5);
        }
        B();
    }

    @Override // android.widget.TextView
    public void setTextAppearance(int i5) {
        super.setTextAppearance(i5);
        com.google.android.material.chip.a aVar = this.f12553e;
        if (aVar != null) {
            aVar.S2(i5);
        }
        B();
    }
}
