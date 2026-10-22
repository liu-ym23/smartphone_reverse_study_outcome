package com.google.android.material.chip;

import V2.a;
import V2.b;
import V2.c;
import V2.d;
import android.R;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.InsetDrawable;
import android.graphics.drawable.RippleDrawable;
import android.text.TextPaint;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.Log;
import android.util.TypedValue;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.PointerIcon;
import android.view.View;
import android.view.accessibility.AccessibilityNodeInfo;
import android.widget.Checkable;
import android.widget.CompoundButton;
import android.widget.TextView;
import androidx.annotation.AnimatorRes;
import androidx.annotation.BoolRes;
import androidx.annotation.ColorRes;
import androidx.annotation.DimenRes;
import androidx.annotation.DrawableRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.Px;
import androidx.annotation.RestrictTo;
import androidx.annotation.StringRes;
import androidx.annotation.StyleRes;
import androidx.appcompat.content.res.AppCompatResources;
import androidx.appcompat.widget.AppCompatCheckBox;
import androidx.compose.ui.platform.AndroidComposeViewAccessibilityDelegateCompat;
import androidx.core.graphics.drawable.DrawableCompat;
import androidx.core.text.BidiFormatter;
import androidx.core.view.ViewCompat;
import c3.AbstractC0872b;
import c3.AbstractC0873c;
import c3.C0876f;
import com.google.android.material.internal.f;
import com.google.android.material.internal.i;
import com.google.android.material.internal.k;
import e3.InterfaceC1407A;
import e3.p;
import g1.AbstractC1451a;
import java.lang.ref.WeakReference;

/* loaded from: classes3.dex */
public class Chip extends AppCompatCheckBox implements c, InterfaceC1407A, Checkable {

    /* renamed from: s, reason: collision with root package name */
    public static final Rect f2389s = new Rect();

    /* renamed from: t, reason: collision with root package name */
    public static final int[] f2390t = {R.attr.state_selected};
    public static final int[] u = {R.attr.state_checkable};

    /* renamed from: a, reason: collision with root package name */
    public d f2391a;
    public InsetDrawable b;
    public RippleDrawable c;
    public View.OnClickListener d;
    public CompoundButton.OnCheckedChangeListener e;
    public boolean f;
    public boolean g;
    public boolean h;
    public boolean i;

    /* renamed from: j, reason: collision with root package name */
    public boolean f2392j;
    public int k;
    public int l;
    public CharSequence m;
    public final b n;
    public boolean o;
    public final Rect p;

    /* renamed from: q, reason: collision with root package name */
    public final RectF f2393q;

    /* renamed from: r, reason: collision with root package name */
    public final a f2394r;

    public Chip(Context context, AttributeSet attributeSet) {
        int resourceId;
        int resourceId2;
        int resourceId3;
        super(i3.a.a(context, attributeSet, com.stepos.ability.R.attr.chipStyle, com.stepos.ability.R.style.Widget_MaterialComponents_Chip_Action), attributeSet, com.stepos.ability.R.attr.chipStyle);
        this.p = new Rect();
        this.f2393q = new RectF();
        this.f2394r = new a(this, 0);
        Context context2 = getContext();
        if (attributeSet != null) {
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
        d dVar = new d(context2, attributeSet);
        Context context3 = dVar.s0;
        int[] iArr = P2.a.e;
        TypedArray typedArrayD = k.d(context3, attributeSet, iArr, com.stepos.ability.R.attr.chipStyle, com.stepos.ability.R.style.Widget_MaterialComponents_Chip_Action, new int[0]);
        dVar.f1330S0 = typedArrayD.hasValue(37);
        Context context4 = dVar.s0;
        ColorStateList colorStateListA = AbstractC0873c.a(context4, typedArrayD, 24);
        if (dVar.f1315L != colorStateListA) {
            dVar.f1315L = colorStateListA;
            dVar.onStateChange(dVar.getState());
        }
        ColorStateList colorStateListA2 = AbstractC0873c.a(context4, typedArrayD, 11);
        if (dVar.f1317M != colorStateListA2) {
            dVar.f1317M = colorStateListA2;
            dVar.onStateChange(dVar.getState());
        }
        float dimension = typedArrayD.getDimension(19, 0.0f);
        if (dVar.f1319N != dimension) {
            dVar.f1319N = dimension;
            dVar.invalidateSelf();
            dVar.H();
        }
        if (typedArrayD.hasValue(12)) {
            dVar.N(typedArrayD.getDimension(12, 0.0f));
        }
        dVar.S(AbstractC0873c.a(context4, typedArrayD, 22));
        dVar.T(typedArrayD.getDimension(23, 0.0f));
        dVar.d0(AbstractC0873c.a(context4, typedArrayD, 36));
        String text = typedArrayD.getText(5);
        text = text == null ? "" : text;
        boolean zEquals = TextUtils.equals(dVar.f1329S, text);
        i iVar = dVar.f1359y0;
        if (!zEquals) {
            dVar.f1329S = text;
            iVar.d = true;
            dVar.invalidateSelf();
            dVar.H();
        }
        C0876f c0876f = (!typedArrayD.hasValue(0) || (resourceId3 = typedArrayD.getResourceId(0, 0)) == 0) ? null : new C0876f(context4, resourceId3);
        c0876f.l = typedArrayD.getDimension(1, c0876f.l);
        iVar.b(c0876f, context4);
        int i = typedArrayD.getInt(3, 0);
        if (i == 1) {
            dVar.f1324P0 = TextUtils.TruncateAt.START;
        } else if (i == 2) {
            dVar.f1324P0 = TextUtils.TruncateAt.MIDDLE;
        } else if (i == 3) {
            dVar.f1324P0 = TextUtils.TruncateAt.END;
        }
        dVar.R(typedArrayD.getBoolean(18, false));
        if (attributeSet != null && attributeSet.getAttributeValue("http://schemas.android.com/apk/res-auto", "chipIconEnabled") != null && attributeSet.getAttributeValue("http://schemas.android.com/apk/res-auto", "chipIconVisible") == null) {
            dVar.R(typedArrayD.getBoolean(15, false));
        }
        dVar.O(AbstractC0873c.c(context4, typedArrayD, 14));
        if (typedArrayD.hasValue(17)) {
            dVar.Q(AbstractC0873c.a(context4, typedArrayD, 17));
        }
        dVar.P(typedArrayD.getDimension(16, -1.0f));
        dVar.a0(typedArrayD.getBoolean(31, false));
        if (attributeSet != null && attributeSet.getAttributeValue("http://schemas.android.com/apk/res-auto", "closeIconEnabled") != null && attributeSet.getAttributeValue("http://schemas.android.com/apk/res-auto", "closeIconVisible") == null) {
            dVar.a0(typedArrayD.getBoolean(26, false));
        }
        dVar.U(AbstractC0873c.c(context4, typedArrayD, 25));
        dVar.Z(AbstractC0873c.a(context4, typedArrayD, 30));
        dVar.W(typedArrayD.getDimension(28, 0.0f));
        dVar.J(typedArrayD.getBoolean(6, false));
        dVar.M(typedArrayD.getBoolean(10, false));
        if (attributeSet != null && attributeSet.getAttributeValue("http://schemas.android.com/apk/res-auto", "checkedIconEnabled") != null && attributeSet.getAttributeValue("http://schemas.android.com/apk/res-auto", "checkedIconVisible") == null) {
            dVar.M(typedArrayD.getBoolean(8, false));
        }
        dVar.K(AbstractC0873c.c(context4, typedArrayD, 7));
        if (typedArrayD.hasValue(9)) {
            dVar.L(AbstractC0873c.a(context4, typedArrayD, 9));
        }
        dVar.f1345i0 = (!typedArrayD.hasValue(39) || (resourceId2 = typedArrayD.getResourceId(39, 0)) == 0) ? null : Q2.c.a(resourceId2, context4);
        dVar.f1346j0 = (!typedArrayD.hasValue(33) || (resourceId = typedArrayD.getResourceId(33, 0)) == 0) ? null : Q2.c.a(resourceId, context4);
        float dimension2 = typedArrayD.getDimension(21, 0.0f);
        if (dVar.f1347k0 != dimension2) {
            dVar.f1347k0 = dimension2;
            dVar.invalidateSelf();
            dVar.H();
        }
        dVar.c0(typedArrayD.getDimension(35, 0.0f));
        dVar.b0(typedArrayD.getDimension(34, 0.0f));
        float dimension3 = typedArrayD.getDimension(41, 0.0f);
        if (dVar.f1350n0 != dimension3) {
            dVar.f1350n0 = dimension3;
            dVar.invalidateSelf();
            dVar.H();
        }
        float dimension4 = typedArrayD.getDimension(40, 0.0f);
        if (dVar.f1351o0 != dimension4) {
            dVar.f1351o0 = dimension4;
            dVar.invalidateSelf();
            dVar.H();
        }
        dVar.X(typedArrayD.getDimension(29, 0.0f));
        dVar.V(typedArrayD.getDimension(27, 0.0f));
        float dimension5 = typedArrayD.getDimension(13, 0.0f);
        if (dVar.f1354r0 != dimension5) {
            dVar.f1354r0 = dimension5;
            dVar.invalidateSelf();
            dVar.H();
        }
        dVar.f1328R0 = typedArrayD.getDimensionPixelSize(4, Integer.MAX_VALUE);
        typedArrayD.recycle();
        k.a(context2, attributeSet, com.stepos.ability.R.attr.chipStyle, com.stepos.ability.R.style.Widget_MaterialComponents_Chip_Action);
        k.b(context2, attributeSet, iArr, com.stepos.ability.R.attr.chipStyle, com.stepos.ability.R.style.Widget_MaterialComponents_Chip_Action, new int[0]);
        TypedArray typedArrayObtainStyledAttributes = context2.obtainStyledAttributes(attributeSet, iArr, com.stepos.ability.R.attr.chipStyle, com.stepos.ability.R.style.Widget_MaterialComponents_Chip_Action);
        this.f2392j = typedArrayObtainStyledAttributes.getBoolean(32, false);
        this.l = (int) Math.ceil(typedArrayObtainStyledAttributes.getDimension(20, AbstractC0872b.c(context2)));
        typedArrayObtainStyledAttributes.recycle();
        setChipDrawable(dVar);
        dVar.p(getElevation());
        k.a(context2, attributeSet, com.stepos.ability.R.attr.chipStyle, com.stepos.ability.R.style.Widget_MaterialComponents_Chip_Action);
        k.b(context2, attributeSet, iArr, com.stepos.ability.R.attr.chipStyle, com.stepos.ability.R.style.Widget_MaterialComponents_Chip_Action, new int[0]);
        TypedArray typedArrayObtainStyledAttributes2 = context2.obtainStyledAttributes(attributeSet, iArr, com.stepos.ability.R.attr.chipStyle, com.stepos.ability.R.style.Widget_MaterialComponents_Chip_Action);
        boolean zHasValue = typedArrayObtainStyledAttributes2.hasValue(37);
        typedArrayObtainStyledAttributes2.recycle();
        this.n = new b(this, this);
        e();
        if (!zHasValue) {
            setOutlineProvider(new A6.k(this, 1));
        }
        setChecked(this.f);
        setText(dVar.f1329S);
        setEllipsize(dVar.f1324P0);
        h();
        if (!this.f2391a.f1326Q0) {
            setLines(1);
            setHorizontallyScrolling(true);
        }
        setGravity(8388627);
        g();
        if (this.f2392j) {
            setMinHeight(this.l);
        }
        this.k = getLayoutDirection();
        super.setOnCheckedChangeListener(new F6.d(1, this));
    }

    /* JADX INFO: Access modifiers changed from: private */
    @NonNull
    public RectF getCloseIconTouchBounds() {
        RectF rectF = this.f2393q;
        rectF.setEmpty();
        if (d() && this.d != null) {
            d dVar = this.f2391a;
            Rect bounds = dVar.getBounds();
            rectF.setEmpty();
            if (dVar.g0()) {
                float f = dVar.f1354r0 + dVar.f1353q0 + dVar.f1339c0 + dVar.f1352p0 + dVar.f1351o0;
                if (DrawableCompat.getLayoutDirection(dVar) == 0) {
                    float f7 = bounds.right;
                    rectF.right = f7;
                    rectF.left = f7 - f;
                } else {
                    float f9 = bounds.left;
                    rectF.left = f9;
                    rectF.right = f9 + f;
                }
                rectF.top = bounds.top;
                rectF.bottom = bounds.bottom;
            }
        }
        return rectF;
    }

    /* JADX INFO: Access modifiers changed from: private */
    @NonNull
    public Rect getCloseIconTouchBoundsInt() {
        RectF closeIconTouchBounds = getCloseIconTouchBounds();
        int i = (int) closeIconTouchBounds.left;
        int i6 = (int) closeIconTouchBounds.top;
        int i10 = (int) closeIconTouchBounds.right;
        int i11 = (int) closeIconTouchBounds.bottom;
        Rect rect = this.p;
        rect.set(i, i6, i10, i11);
        return rect;
    }

    @Nullable
    private C0876f getTextAppearance() {
        d dVar = this.f2391a;
        if (dVar != null) {
            return dVar.f1359y0.f;
        }
        return null;
    }

    private void setCloseIconHovered(boolean z10) {
        if (this.h != z10) {
            this.h = z10;
            refreshDrawableState();
        }
    }

    private void setCloseIconPressed(boolean z10) {
        if (this.g != z10) {
            this.g = z10;
            refreshDrawableState();
        }
    }

    public final void c(int i) {
        this.l = i;
        if (!this.f2392j) {
            InsetDrawable insetDrawable = this.b;
            if (insetDrawable == null) {
                f();
                return;
            } else {
                if (insetDrawable != null) {
                    this.b = null;
                    setMinWidth(0);
                    setMinHeight((int) getChipMinHeight());
                    f();
                    return;
                }
                return;
            }
        }
        int iMax = Math.max(0, i - ((int) this.f2391a.f1319N));
        int iMax2 = Math.max(0, i - this.f2391a.getIntrinsicWidth());
        if (iMax2 <= 0 && iMax <= 0) {
            InsetDrawable insetDrawable2 = this.b;
            if (insetDrawable2 == null) {
                f();
                return;
            } else {
                if (insetDrawable2 != null) {
                    this.b = null;
                    setMinWidth(0);
                    setMinHeight((int) getChipMinHeight());
                    f();
                    return;
                }
                return;
            }
        }
        int i6 = iMax2 > 0 ? iMax2 / 2 : 0;
        int i10 = iMax > 0 ? iMax / 2 : 0;
        if (this.b != null) {
            Rect rect = new Rect();
            this.b.getPadding(rect);
            if (rect.top == i10 && rect.bottom == i10 && rect.left == i6 && rect.right == i6) {
                f();
                return;
            }
        }
        if (getMinHeight() != i) {
            setMinHeight(i);
        }
        if (getMinWidth() != i) {
            setMinWidth(i);
        }
        this.b = new InsetDrawable((Drawable) this.f2391a, i6, i10, i6, i10);
        f();
    }

    public final boolean d() {
        d dVar = this.f2391a;
        if (dVar == null) {
            return false;
        }
        Drawable drawable = dVar.f1337Z;
        return (drawable != null ? DrawableCompat.unwrap(drawable) : null) != null;
    }

    @Override // android.view.View
    public final boolean dispatchHoverEvent(MotionEvent motionEvent) {
        return !this.o ? super.dispatchHoverEvent(motionEvent) : this.n.dispatchHoverEvent(motionEvent) || super.dispatchHoverEvent(motionEvent);
    }

    @Override // android.view.View
    public final boolean dispatchKeyEvent(KeyEvent keyEvent) {
        if (!this.o) {
            return super.dispatchKeyEvent(keyEvent);
        }
        b bVar = this.n;
        if (!bVar.dispatchKeyEvent(keyEvent) || bVar.getKeyboardFocusedVirtualViewId() == Integer.MIN_VALUE) {
            return super.dispatchKeyEvent(keyEvent);
        }
        return true;
    }

    /* JADX WARN: Type inference failed for: r2v0, types: [boolean, int] */
    @Override // androidx.appcompat.widget.AppCompatCheckBox, android.widget.CompoundButton, android.widget.TextView, android.view.View
    public final void drawableStateChanged() {
        super.drawableStateChanged();
        d dVar = this.f2391a;
        boolean zY = false;
        int i = 0;
        zY = false;
        if (dVar != null && d.G(dVar.f1337Z)) {
            d dVar2 = this.f2391a;
            ?? IsEnabled = isEnabled();
            int i6 = IsEnabled;
            if (this.i) {
                i6 = IsEnabled + 1;
            }
            int i10 = i6;
            if (this.h) {
                i10 = i6 + 1;
            }
            int i11 = i10;
            if (this.g) {
                i11 = i10 + 1;
            }
            int i12 = i11;
            if (isChecked()) {
                i12 = i11 + 1;
            }
            int[] iArr = new int[i12];
            if (isEnabled()) {
                iArr[0] = 16842910;
                i = 1;
            }
            if (this.i) {
                iArr[i] = 16842908;
                i++;
            }
            if (this.h) {
                iArr[i] = 16843623;
                i++;
            }
            if (this.g) {
                iArr[i] = 16842919;
                i++;
            }
            if (isChecked()) {
                iArr[i] = 16842913;
            }
            zY = dVar2.Y(iArr);
        }
        if (zY) {
            invalidate();
        }
    }

    public final void e() {
        d dVar;
        if (!d() || (dVar = this.f2391a) == null || !dVar.f1336Y || this.d == null) {
            ViewCompat.setAccessibilityDelegate(this, null);
            this.o = false;
        } else {
            ViewCompat.setAccessibilityDelegate(this, this.n);
            this.o = true;
        }
    }

    public final void f() {
        ColorStateList colorStateListValueOf = this.f2391a.f1327R;
        if (colorStateListValueOf == null) {
            colorStateListValueOf = ColorStateList.valueOf(0);
        }
        this.c = new RippleDrawable(colorStateListValueOf, getBackgroundDrawable(), null);
        this.f2391a.getClass();
        setBackground(this.c);
        g();
    }

    public final void g() {
        d dVar;
        if (TextUtils.isEmpty(getText()) || (dVar = this.f2391a) == null) {
            return;
        }
        int iD = (int) (dVar.D() + dVar.f1354r0 + dVar.f1351o0);
        d dVar2 = this.f2391a;
        int iC = (int) (dVar2.C() + dVar2.f1347k0 + dVar2.f1350n0);
        if (this.b != null) {
            Rect rect = new Rect();
            this.b.getPadding(rect);
            iC += rect.left;
            iD += rect.right;
        }
        setPaddingRelative(iC, getPaddingTop(), iD, getPaddingBottom());
    }

    @Override // android.widget.CheckBox, android.widget.CompoundButton, android.widget.Button, android.widget.TextView, android.view.View
    @NonNull
    public CharSequence getAccessibilityClassName() {
        if (!TextUtils.isEmpty(this.m)) {
            return this.m;
        }
        d dVar = this.f2391a;
        if (dVar == null || !dVar.f1341e0) {
            return isClickable() ? "android.widget.Button" : AndroidComposeViewAccessibilityDelegateCompat.ClassName;
        }
        getParent();
        return "android.widget.Button";
    }

    @Nullable
    public Drawable getBackgroundDrawable() {
        InsetDrawable insetDrawable = this.b;
        return insetDrawable == null ? this.f2391a : insetDrawable;
    }

    @Nullable
    public Drawable getCheckedIcon() {
        d dVar = this.f2391a;
        if (dVar != null) {
            return dVar.f1343g0;
        }
        return null;
    }

    @Nullable
    public ColorStateList getCheckedIconTint() {
        d dVar = this.f2391a;
        if (dVar != null) {
            return dVar.f1344h0;
        }
        return null;
    }

    @Nullable
    public ColorStateList getChipBackgroundColor() {
        d dVar = this.f2391a;
        if (dVar != null) {
            return dVar.f1317M;
        }
        return null;
    }

    public float getChipCornerRadius() {
        d dVar = this.f2391a;
        if (dVar != null) {
            return Math.max(0.0f, dVar.E());
        }
        return 0.0f;
    }

    public Drawable getChipDrawable() {
        return this.f2391a;
    }

    public float getChipEndPadding() {
        d dVar = this.f2391a;
        if (dVar != null) {
            return dVar.f1354r0;
        }
        return 0.0f;
    }

    @Nullable
    public Drawable getChipIcon() {
        Drawable drawable;
        d dVar = this.f2391a;
        if (dVar == null || (drawable = dVar.f1332U) == null) {
            return null;
        }
        return DrawableCompat.unwrap(drawable);
    }

    public float getChipIconSize() {
        d dVar = this.f2391a;
        if (dVar != null) {
            return dVar.f1334W;
        }
        return 0.0f;
    }

    @Nullable
    public ColorStateList getChipIconTint() {
        d dVar = this.f2391a;
        if (dVar != null) {
            return dVar.f1333V;
        }
        return null;
    }

    public float getChipMinHeight() {
        d dVar = this.f2391a;
        if (dVar != null) {
            return dVar.f1319N;
        }
        return 0.0f;
    }

    public float getChipStartPadding() {
        d dVar = this.f2391a;
        if (dVar != null) {
            return dVar.f1347k0;
        }
        return 0.0f;
    }

    @Nullable
    public ColorStateList getChipStrokeColor() {
        d dVar = this.f2391a;
        if (dVar != null) {
            return dVar.f1323P;
        }
        return null;
    }

    public float getChipStrokeWidth() {
        d dVar = this.f2391a;
        if (dVar != null) {
            return dVar.f1325Q;
        }
        return 0.0f;
    }

    @Deprecated
    public CharSequence getChipText() {
        return getText();
    }

    @Nullable
    public Drawable getCloseIcon() {
        Drawable drawable;
        d dVar = this.f2391a;
        if (dVar == null || (drawable = dVar.f1337Z) == null) {
            return null;
        }
        return DrawableCompat.unwrap(drawable);
    }

    @Nullable
    public CharSequence getCloseIconContentDescription() {
        d dVar = this.f2391a;
        if (dVar != null) {
            return dVar.f1340d0;
        }
        return null;
    }

    public float getCloseIconEndPadding() {
        d dVar = this.f2391a;
        if (dVar != null) {
            return dVar.f1353q0;
        }
        return 0.0f;
    }

    public float getCloseIconSize() {
        d dVar = this.f2391a;
        if (dVar != null) {
            return dVar.f1339c0;
        }
        return 0.0f;
    }

    public float getCloseIconStartPadding() {
        d dVar = this.f2391a;
        if (dVar != null) {
            return dVar.f1352p0;
        }
        return 0.0f;
    }

    @Nullable
    public ColorStateList getCloseIconTint() {
        d dVar = this.f2391a;
        if (dVar != null) {
            return dVar.b0;
        }
        return null;
    }

    @Override // android.widget.TextView
    @Nullable
    public TextUtils.TruncateAt getEllipsize() {
        d dVar = this.f2391a;
        if (dVar != null) {
            return dVar.f1324P0;
        }
        return null;
    }

    @Override // android.widget.TextView, android.view.View
    public final void getFocusedRect(Rect rect) {
        if (this.o) {
            b bVar = this.n;
            if (bVar.getKeyboardFocusedVirtualViewId() == 1 || bVar.getAccessibilityFocusedVirtualViewId() == 1) {
                rect.set(getCloseIconTouchBoundsInt());
                return;
            }
        }
        super.getFocusedRect(rect);
    }

    @Nullable
    public Q2.c getHideMotionSpec() {
        d dVar = this.f2391a;
        if (dVar != null) {
            return dVar.f1346j0;
        }
        return null;
    }

    public float getIconEndPadding() {
        d dVar = this.f2391a;
        if (dVar != null) {
            return dVar.f1349m0;
        }
        return 0.0f;
    }

    public float getIconStartPadding() {
        d dVar = this.f2391a;
        if (dVar != null) {
            return dVar.f1348l0;
        }
        return 0.0f;
    }

    @Nullable
    public ColorStateList getRippleColor() {
        d dVar = this.f2391a;
        if (dVar != null) {
            return dVar.f1327R;
        }
        return null;
    }

    @NonNull
    public p getShapeAppearanceModel() {
        return this.f2391a.b.f4345a;
    }

    @Nullable
    public Q2.c getShowMotionSpec() {
        d dVar = this.f2391a;
        if (dVar != null) {
            return dVar.f1345i0;
        }
        return null;
    }

    public float getTextEndPadding() {
        d dVar = this.f2391a;
        if (dVar != null) {
            return dVar.f1351o0;
        }
        return 0.0f;
    }

    public float getTextStartPadding() {
        d dVar = this.f2391a;
        if (dVar != null) {
            return dVar.f1350n0;
        }
        return 0.0f;
    }

    public final void h() {
        TextPaint paint = getPaint();
        d dVar = this.f2391a;
        if (dVar != null) {
            paint.drawableState = dVar.getState();
        }
        C0876f textAppearance = getTextAppearance();
        if (textAppearance != null) {
            textAppearance.d(getContext(), paint, this.f2394r);
        }
    }

    @Override // android.widget.TextView, android.view.View
    public final void onAttachedToWindow() {
        super.onAttachedToWindow();
        AbstractC1451a.T(this, this.f2391a);
    }

    @Override // android.widget.CompoundButton, android.widget.TextView, android.view.View
    public final int[] onCreateDrawableState(int i) {
        int[] iArrOnCreateDrawableState = super.onCreateDrawableState(i + 2);
        if (isChecked()) {
            View.mergeDrawableStates(iArrOnCreateDrawableState, f2390t);
        }
        d dVar = this.f2391a;
        if (dVar != null && dVar.f1341e0) {
            View.mergeDrawableStates(iArrOnCreateDrawableState, u);
        }
        return iArrOnCreateDrawableState;
    }

    @Override // android.widget.TextView, android.view.View
    public final void onFocusChanged(boolean z10, int i, Rect rect) {
        super.onFocusChanged(z10, i, rect);
        if (this.o) {
            this.n.onFocusChanged(z10, i, rect);
        }
    }

    @Override // android.view.View
    public final boolean onHoverEvent(MotionEvent motionEvent) {
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked == 7) {
            setCloseIconHovered(getCloseIconTouchBounds().contains(motionEvent.getX(), motionEvent.getY()));
        } else if (actionMasked == 10) {
            setCloseIconHovered(false);
        }
        return super.onHoverEvent(motionEvent);
    }

    @Override // android.view.View
    public final void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo accessibilityNodeInfo) {
        super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
        accessibilityNodeInfo.setClassName(getAccessibilityClassName());
        d dVar = this.f2391a;
        accessibilityNodeInfo.setCheckable(dVar != null && dVar.f1341e0);
        accessibilityNodeInfo.setClickable(isClickable());
        getParent();
    }

    @Override // android.widget.Button, android.widget.TextView, android.view.View
    public final PointerIcon onResolvePointerIcon(MotionEvent motionEvent, int i) {
        return (getCloseIconTouchBounds().contains(motionEvent.getX(), motionEvent.getY()) && isEnabled()) ? PointerIcon.getSystemIcon(getContext(), 1002) : super.onResolvePointerIcon(motionEvent, i);
    }

    @Override // android.widget.TextView, android.view.View
    public final void onRtlPropertiesChanged(int i) {
        super.onRtlPropertiesChanged(i);
        if (this.k != i) {
            this.k = i;
            g();
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:8:0x001e, code lost:
    
        if (r0 != 3) goto L28;
     */
    @Override // android.widget.TextView, android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final boolean onTouchEvent(android.view.MotionEvent r6) {
        /*
            r5 = this;
            int r0 = r6.getActionMasked()
            android.graphics.RectF r1 = r5.getCloseIconTouchBounds()
            float r2 = r6.getX()
            float r3 = r6.getY()
            boolean r1 = r1.contains(r2, r3)
            r2 = 1
            r3 = 0
            if (r0 == 0) goto L4a
            if (r0 == r2) goto L2c
            r4 = 2
            if (r0 == r4) goto L21
            r1 = 3
            if (r0 == r1) goto L45
            goto L50
        L21:
            boolean r0 = r5.g
            if (r0 == 0) goto L50
            if (r1 != 0) goto L2a
            r5.setCloseIconPressed(r3)
        L2a:
            r0 = r2
            goto L51
        L2c:
            boolean r0 = r5.g
            if (r0 == 0) goto L45
            r5.playSoundEffect(r3)
            android.view.View$OnClickListener r0 = r5.d
            if (r0 == 0) goto L3a
            r0.onClick(r5)
        L3a:
            boolean r0 = r5.o
            if (r0 == 0) goto L43
            V2.b r0 = r5.n
            r0.sendEventForVirtualView(r2, r2)
        L43:
            r0 = r2
            goto L46
        L45:
            r0 = r3
        L46:
            r5.setCloseIconPressed(r3)
            goto L51
        L4a:
            if (r1 == 0) goto L50
            r5.setCloseIconPressed(r2)
            goto L2a
        L50:
            r0 = r3
        L51:
            if (r0 != 0) goto L5b
            boolean r5 = super.onTouchEvent(r6)
            if (r5 == 0) goto L5a
            goto L5b
        L5a:
            return r3
        L5b:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.material.chip.Chip.onTouchEvent(android.view.MotionEvent):boolean");
    }

    public void setAccessibilityClassName(@Nullable CharSequence charSequence) {
        this.m = charSequence;
    }

    @Override // android.view.View
    public void setBackground(Drawable drawable) {
        if (drawable == getBackgroundDrawable() || drawable == this.c) {
            super.setBackground(drawable);
        } else {
            Log.w("Chip", "Do not set the background; Chip manages its own background drawable.");
        }
    }

    @Override // android.view.View
    public void setBackgroundColor(int i) {
        Log.w("Chip", "Do not set the background color; Chip manages its own background drawable.");
    }

    @Override // androidx.appcompat.widget.AppCompatCheckBox, android.view.View
    public void setBackgroundDrawable(Drawable drawable) {
        if (drawable == getBackgroundDrawable() || drawable == this.c) {
            super.setBackgroundDrawable(drawable);
        } else {
            Log.w("Chip", "Do not set the background drawable; Chip manages its own background drawable.");
        }
    }

    @Override // androidx.appcompat.widget.AppCompatCheckBox, android.view.View
    public void setBackgroundResource(int i) {
        Log.w("Chip", "Do not set the background resource; Chip manages its own background drawable.");
    }

    @Override // android.view.View
    public void setBackgroundTintList(@Nullable ColorStateList colorStateList) {
        Log.w("Chip", "Do not set the background tint list; Chip manages its own background drawable.");
    }

    @Override // android.view.View
    public void setBackgroundTintMode(@Nullable PorterDuff.Mode mode) {
        Log.w("Chip", "Do not set the background tint mode; Chip manages its own background drawable.");
    }

    public void setCheckable(boolean z10) {
        d dVar = this.f2391a;
        if (dVar != null) {
            dVar.J(z10);
        }
    }

    public void setCheckableResource(@BoolRes int i) {
        d dVar = this.f2391a;
        if (dVar != null) {
            dVar.J(dVar.s0.getResources().getBoolean(i));
        }
    }

    @Override // android.widget.CompoundButton, android.widget.Checkable
    public void setChecked(boolean z10) {
        d dVar = this.f2391a;
        if (dVar == null) {
            this.f = z10;
        } else if (dVar.f1341e0) {
            super.setChecked(z10);
        }
    }

    public void setCheckedIcon(@Nullable Drawable drawable) {
        d dVar = this.f2391a;
        if (dVar != null) {
            dVar.K(drawable);
        }
    }

    @Deprecated
    public void setCheckedIconEnabled(boolean z10) {
        setCheckedIconVisible(z10);
    }

    @Deprecated
    public void setCheckedIconEnabledResource(@BoolRes int i) {
        setCheckedIconVisible(i);
    }

    public void setCheckedIconResource(@DrawableRes int i) {
        d dVar = this.f2391a;
        if (dVar != null) {
            dVar.K(AppCompatResources.getDrawable(dVar.s0, i));
        }
    }

    public void setCheckedIconTint(@Nullable ColorStateList colorStateList) {
        d dVar = this.f2391a;
        if (dVar != null) {
            dVar.L(colorStateList);
        }
    }

    public void setCheckedIconTintResource(@ColorRes int i) {
        d dVar = this.f2391a;
        if (dVar != null) {
            dVar.L(AppCompatResources.getColorStateList(dVar.s0, i));
        }
    }

    public void setCheckedIconVisible(@BoolRes int i) {
        d dVar = this.f2391a;
        if (dVar != null) {
            dVar.M(dVar.s0.getResources().getBoolean(i));
        }
    }

    public void setChipBackgroundColor(@Nullable ColorStateList colorStateList) {
        d dVar = this.f2391a;
        if (dVar == null || dVar.f1317M == colorStateList) {
            return;
        }
        dVar.f1317M = colorStateList;
        dVar.onStateChange(dVar.getState());
    }

    public void setChipBackgroundColorResource(@ColorRes int i) {
        ColorStateList colorStateList;
        d dVar = this.f2391a;
        if (dVar == null || dVar.f1317M == (colorStateList = AppCompatResources.getColorStateList(dVar.s0, i))) {
            return;
        }
        dVar.f1317M = colorStateList;
        dVar.onStateChange(dVar.getState());
    }

    @Deprecated
    public void setChipCornerRadius(float f) {
        d dVar = this.f2391a;
        if (dVar != null) {
            dVar.N(f);
        }
    }

    @Deprecated
    public void setChipCornerRadiusResource(@DimenRes int i) {
        d dVar = this.f2391a;
        if (dVar != null) {
            dVar.N(dVar.s0.getResources().getDimension(i));
        }
    }

    public void setChipDrawable(@NonNull d dVar) {
        d dVar2 = this.f2391a;
        if (dVar2 != dVar) {
            if (dVar2 != null) {
                dVar2.f1322O0 = new WeakReference(null);
            }
            this.f2391a = dVar;
            dVar.f1326Q0 = false;
            dVar.f1322O0 = new WeakReference(this);
            c(this.l);
        }
    }

    public void setChipEndPadding(float f) {
        d dVar = this.f2391a;
        if (dVar == null || dVar.f1354r0 == f) {
            return;
        }
        dVar.f1354r0 = f;
        dVar.invalidateSelf();
        dVar.H();
    }

    public void setChipEndPaddingResource(@DimenRes int i) throws Resources.NotFoundException {
        d dVar = this.f2391a;
        if (dVar != null) {
            float dimension = dVar.s0.getResources().getDimension(i);
            if (dVar.f1354r0 != dimension) {
                dVar.f1354r0 = dimension;
                dVar.invalidateSelf();
                dVar.H();
            }
        }
    }

    public void setChipIcon(@Nullable Drawable drawable) {
        d dVar = this.f2391a;
        if (dVar != null) {
            dVar.O(drawable);
        }
    }

    @Deprecated
    public void setChipIconEnabled(boolean z10) {
        setChipIconVisible(z10);
    }

    @Deprecated
    public void setChipIconEnabledResource(@BoolRes int i) {
        setChipIconVisible(i);
    }

    public void setChipIconResource(@DrawableRes int i) {
        d dVar = this.f2391a;
        if (dVar != null) {
            dVar.O(AppCompatResources.getDrawable(dVar.s0, i));
        }
    }

    public void setChipIconSize(float f) {
        d dVar = this.f2391a;
        if (dVar != null) {
            dVar.P(f);
        }
    }

    public void setChipIconSizeResource(@DimenRes int i) {
        d dVar = this.f2391a;
        if (dVar != null) {
            dVar.P(dVar.s0.getResources().getDimension(i));
        }
    }

    public void setChipIconTint(@Nullable ColorStateList colorStateList) {
        d dVar = this.f2391a;
        if (dVar != null) {
            dVar.Q(colorStateList);
        }
    }

    public void setChipIconTintResource(@ColorRes int i) {
        d dVar = this.f2391a;
        if (dVar != null) {
            dVar.Q(AppCompatResources.getColorStateList(dVar.s0, i));
        }
    }

    public void setChipIconVisible(@BoolRes int i) {
        d dVar = this.f2391a;
        if (dVar != null) {
            dVar.R(dVar.s0.getResources().getBoolean(i));
        }
    }

    public void setChipMinHeight(float f) {
        d dVar = this.f2391a;
        if (dVar == null || dVar.f1319N == f) {
            return;
        }
        dVar.f1319N = f;
        dVar.invalidateSelf();
        dVar.H();
    }

    public void setChipMinHeightResource(@DimenRes int i) throws Resources.NotFoundException {
        d dVar = this.f2391a;
        if (dVar != null) {
            float dimension = dVar.s0.getResources().getDimension(i);
            if (dVar.f1319N != dimension) {
                dVar.f1319N = dimension;
                dVar.invalidateSelf();
                dVar.H();
            }
        }
    }

    public void setChipStartPadding(float f) {
        d dVar = this.f2391a;
        if (dVar == null || dVar.f1347k0 == f) {
            return;
        }
        dVar.f1347k0 = f;
        dVar.invalidateSelf();
        dVar.H();
    }

    public void setChipStartPaddingResource(@DimenRes int i) throws Resources.NotFoundException {
        d dVar = this.f2391a;
        if (dVar != null) {
            float dimension = dVar.s0.getResources().getDimension(i);
            if (dVar.f1347k0 != dimension) {
                dVar.f1347k0 = dimension;
                dVar.invalidateSelf();
                dVar.H();
            }
        }
    }

    public void setChipStrokeColor(@Nullable ColorStateList colorStateList) {
        d dVar = this.f2391a;
        if (dVar != null) {
            dVar.S(colorStateList);
        }
    }

    public void setChipStrokeColorResource(@ColorRes int i) {
        d dVar = this.f2391a;
        if (dVar != null) {
            dVar.S(AppCompatResources.getColorStateList(dVar.s0, i));
        }
    }

    public void setChipStrokeWidth(float f) {
        d dVar = this.f2391a;
        if (dVar != null) {
            dVar.T(f);
        }
    }

    public void setChipStrokeWidthResource(@DimenRes int i) {
        d dVar = this.f2391a;
        if (dVar != null) {
            dVar.T(dVar.s0.getResources().getDimension(i));
        }
    }

    @Deprecated
    public void setChipText(@Nullable CharSequence charSequence) {
        setText(charSequence);
    }

    @Deprecated
    public void setChipTextResource(@StringRes int i) {
        setText(getResources().getString(i));
    }

    public void setCloseIcon(@Nullable Drawable drawable) {
        d dVar = this.f2391a;
        if (dVar != null) {
            dVar.U(drawable);
        }
        e();
    }

    public void setCloseIconContentDescription(@Nullable CharSequence charSequence) {
        d dVar = this.f2391a;
        if (dVar == null || dVar.f1340d0 == charSequence) {
            return;
        }
        dVar.f1340d0 = BidiFormatter.getInstance().unicodeWrap(charSequence);
        dVar.invalidateSelf();
    }

    @Deprecated
    public void setCloseIconEnabled(boolean z10) {
        setCloseIconVisible(z10);
    }

    @Deprecated
    public void setCloseIconEnabledResource(@BoolRes int i) {
        setCloseIconVisible(i);
    }

    public void setCloseIconEndPadding(float f) {
        d dVar = this.f2391a;
        if (dVar != null) {
            dVar.V(f);
        }
    }

    public void setCloseIconEndPaddingResource(@DimenRes int i) {
        d dVar = this.f2391a;
        if (dVar != null) {
            dVar.V(dVar.s0.getResources().getDimension(i));
        }
    }

    public void setCloseIconResource(@DrawableRes int i) {
        d dVar = this.f2391a;
        if (dVar != null) {
            dVar.U(AppCompatResources.getDrawable(dVar.s0, i));
        }
        e();
    }

    public void setCloseIconSize(float f) {
        d dVar = this.f2391a;
        if (dVar != null) {
            dVar.W(f);
        }
    }

    public void setCloseIconSizeResource(@DimenRes int i) {
        d dVar = this.f2391a;
        if (dVar != null) {
            dVar.W(dVar.s0.getResources().getDimension(i));
        }
    }

    public void setCloseIconStartPadding(float f) {
        d dVar = this.f2391a;
        if (dVar != null) {
            dVar.X(f);
        }
    }

    public void setCloseIconStartPaddingResource(@DimenRes int i) {
        d dVar = this.f2391a;
        if (dVar != null) {
            dVar.X(dVar.s0.getResources().getDimension(i));
        }
    }

    public void setCloseIconTint(@Nullable ColorStateList colorStateList) {
        d dVar = this.f2391a;
        if (dVar != null) {
            dVar.Z(colorStateList);
        }
    }

    public void setCloseIconTintResource(@ColorRes int i) {
        d dVar = this.f2391a;
        if (dVar != null) {
            dVar.Z(AppCompatResources.getColorStateList(dVar.s0, i));
        }
    }

    public void setCloseIconVisible(@BoolRes int i) {
        setCloseIconVisible(getResources().getBoolean(i));
    }

    @Override // androidx.appcompat.widget.AppCompatCheckBox, android.widget.TextView
    public final void setCompoundDrawables(Drawable drawable, Drawable drawable2, Drawable drawable3, Drawable drawable4) {
        if (drawable != null) {
            throw new UnsupportedOperationException("Please set start drawable using R.attr#chipIcon.");
        }
        if (drawable3 != null) {
            throw new UnsupportedOperationException("Please set end drawable using R.attr#closeIcon.");
        }
        super.setCompoundDrawables(drawable, drawable2, drawable3, drawable4);
    }

    @Override // androidx.appcompat.widget.AppCompatCheckBox, android.widget.TextView
    public final void setCompoundDrawablesRelative(Drawable drawable, Drawable drawable2, Drawable drawable3, Drawable drawable4) {
        if (drawable != null) {
            throw new UnsupportedOperationException("Please set start drawable using R.attr#chipIcon.");
        }
        if (drawable3 != null) {
            throw new UnsupportedOperationException("Please set end drawable using R.attr#closeIcon.");
        }
        super.setCompoundDrawablesRelative(drawable, drawable2, drawable3, drawable4);
    }

    @Override // android.widget.TextView
    public final void setCompoundDrawablesRelativeWithIntrinsicBounds(int i, int i6, int i10, int i11) {
        if (i != 0) {
            throw new UnsupportedOperationException("Please set start drawable using R.attr#chipIcon.");
        }
        if (i10 != 0) {
            throw new UnsupportedOperationException("Please set end drawable using R.attr#closeIcon.");
        }
        super.setCompoundDrawablesRelativeWithIntrinsicBounds(i, i6, i10, i11);
    }

    @Override // android.widget.TextView
    public final void setCompoundDrawablesWithIntrinsicBounds(int i, int i6, int i10, int i11) {
        if (i != 0) {
            throw new UnsupportedOperationException("Please set start drawable using R.attr#chipIcon.");
        }
        if (i10 != 0) {
            throw new UnsupportedOperationException("Please set end drawable using R.attr#closeIcon.");
        }
        super.setCompoundDrawablesWithIntrinsicBounds(i, i6, i10, i11);
    }

    @Override // android.view.View
    public void setElevation(float f) {
        super.setElevation(f);
        d dVar = this.f2391a;
        if (dVar != null) {
            dVar.p(f);
        }
    }

    @Override // android.widget.TextView
    public void setEllipsize(TextUtils.TruncateAt truncateAt) {
        if (this.f2391a == null) {
            return;
        }
        if (truncateAt == TextUtils.TruncateAt.MARQUEE) {
            throw new UnsupportedOperationException("Text within a chip are not allowed to scroll.");
        }
        super.setEllipsize(truncateAt);
        d dVar = this.f2391a;
        if (dVar != null) {
            dVar.f1324P0 = truncateAt;
        }
    }

    public void setEnsureMinTouchTargetSize(boolean z10) {
        this.f2392j = z10;
        c(this.l);
    }

    @Override // android.widget.TextView
    public void setGravity(int i) {
        if (i != 8388627) {
            Log.w("Chip", "Chip text must be vertically center and start aligned");
        } else {
            super.setGravity(i);
        }
    }

    public void setHideMotionSpec(@Nullable Q2.c cVar) {
        d dVar = this.f2391a;
        if (dVar != null) {
            dVar.f1346j0 = cVar;
        }
    }

    public void setHideMotionSpecResource(@AnimatorRes int i) {
        d dVar = this.f2391a;
        if (dVar != null) {
            dVar.f1346j0 = Q2.c.a(i, dVar.s0);
        }
    }

    public void setIconEndPadding(float f) {
        d dVar = this.f2391a;
        if (dVar != null) {
            dVar.b0(f);
        }
    }

    public void setIconEndPaddingResource(@DimenRes int i) {
        d dVar = this.f2391a;
        if (dVar != null) {
            dVar.b0(dVar.s0.getResources().getDimension(i));
        }
    }

    public void setIconStartPadding(float f) {
        d dVar = this.f2391a;
        if (dVar != null) {
            dVar.c0(f);
        }
    }

    public void setIconStartPaddingResource(@DimenRes int i) {
        d dVar = this.f2391a;
        if (dVar != null) {
            dVar.c0(dVar.s0.getResources().getDimension(i));
        }
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public void setInternalOnCheckedChangeListener(@Nullable f fVar) {
    }

    @Override // android.view.View
    public void setLayoutDirection(int i) {
        if (this.f2391a == null) {
            return;
        }
        super.setLayoutDirection(i);
    }

    @Override // android.widget.TextView
    public void setLines(int i) {
        if (i > 1) {
            throw new UnsupportedOperationException("Chip does not support multi-line text");
        }
        super.setLines(i);
    }

    @Override // android.widget.TextView
    public void setMaxLines(int i) {
        if (i > 1) {
            throw new UnsupportedOperationException("Chip does not support multi-line text");
        }
        super.setMaxLines(i);
    }

    @Override // android.widget.TextView
    public void setMaxWidth(@Px int i) {
        super.setMaxWidth(i);
        d dVar = this.f2391a;
        if (dVar != null) {
            dVar.f1328R0 = i;
        }
    }

    @Override // android.widget.TextView
    public void setMinLines(int i) {
        if (i > 1) {
            throw new UnsupportedOperationException("Chip does not support multi-line text");
        }
        super.setMinLines(i);
    }

    @Override // android.widget.CompoundButton
    public void setOnCheckedChangeListener(@Nullable CompoundButton.OnCheckedChangeListener onCheckedChangeListener) {
        this.e = onCheckedChangeListener;
    }

    public void setOnCloseIconClickListener(View.OnClickListener onClickListener) {
        this.d = onClickListener;
        e();
    }

    public void setRippleColor(@Nullable ColorStateList colorStateList) {
        d dVar = this.f2391a;
        if (dVar != null) {
            dVar.d0(colorStateList);
        }
        this.f2391a.getClass();
        f();
    }

    public void setRippleColorResource(@ColorRes int i) {
        d dVar = this.f2391a;
        if (dVar != null) {
            dVar.d0(AppCompatResources.getColorStateList(dVar.s0, i));
            this.f2391a.getClass();
            f();
        }
    }

    @Override // e3.InterfaceC1407A
    public void setShapeAppearanceModel(@NonNull p pVar) {
        this.f2391a.setShapeAppearanceModel(pVar);
    }

    public void setShowMotionSpec(@Nullable Q2.c cVar) {
        d dVar = this.f2391a;
        if (dVar != null) {
            dVar.f1345i0 = cVar;
        }
    }

    public void setShowMotionSpecResource(@AnimatorRes int i) {
        d dVar = this.f2391a;
        if (dVar != null) {
            dVar.f1345i0 = Q2.c.a(i, dVar.s0);
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
    public final void setText(CharSequence charSequence, TextView.BufferType bufferType) {
        d dVar = this.f2391a;
        if (dVar == null) {
            return;
        }
        if (charSequence == null) {
            charSequence = "";
        }
        super.setText(dVar.f1326Q0 ? null : charSequence, bufferType);
        d dVar2 = this.f2391a;
        if (dVar2 == null || TextUtils.equals(dVar2.f1329S, charSequence)) {
            return;
        }
        dVar2.f1329S = charSequence;
        dVar2.f1359y0.d = true;
        dVar2.invalidateSelf();
        dVar2.H();
    }

    public void setTextAppearance(@Nullable C0876f c0876f) {
        d dVar = this.f2391a;
        if (dVar != null) {
            dVar.f1359y0.b(c0876f, dVar.s0);
        }
        h();
    }

    public void setTextAppearanceResource(@StyleRes int i) {
        setTextAppearance(getContext(), i);
    }

    public void setTextEndPadding(float f) {
        d dVar = this.f2391a;
        if (dVar == null || dVar.f1351o0 == f) {
            return;
        }
        dVar.f1351o0 = f;
        dVar.invalidateSelf();
        dVar.H();
    }

    public void setTextEndPaddingResource(@DimenRes int i) throws Resources.NotFoundException {
        d dVar = this.f2391a;
        if (dVar != null) {
            float dimension = dVar.s0.getResources().getDimension(i);
            if (dVar.f1351o0 != dimension) {
                dVar.f1351o0 = dimension;
                dVar.invalidateSelf();
                dVar.H();
            }
        }
    }

    @Override // android.widget.TextView
    public final void setTextSize(int i, float f) {
        super.setTextSize(i, f);
        d dVar = this.f2391a;
        if (dVar != null) {
            float fApplyDimension = TypedValue.applyDimension(i, f, getResources().getDisplayMetrics());
            i iVar = dVar.f1359y0;
            C0876f c0876f = iVar.f;
            if (c0876f != null) {
                c0876f.l = fApplyDimension;
                iVar.f2501a.setTextSize(fApplyDimension);
                dVar.a();
            }
        }
        h();
    }

    public void setTextStartPadding(float f) {
        d dVar = this.f2391a;
        if (dVar == null || dVar.f1350n0 == f) {
            return;
        }
        dVar.f1350n0 = f;
        dVar.invalidateSelf();
        dVar.H();
    }

    public void setTextStartPaddingResource(@DimenRes int i) throws Resources.NotFoundException {
        d dVar = this.f2391a;
        if (dVar != null) {
            float dimension = dVar.s0.getResources().getDimension(i);
            if (dVar.f1350n0 != dimension) {
                dVar.f1350n0 = dimension;
                dVar.invalidateSelf();
                dVar.H();
            }
        }
    }

    public void setCloseIconVisible(boolean z10) {
        d dVar = this.f2391a;
        if (dVar != null) {
            dVar.a0(z10);
        }
        e();
    }

    public void setCheckedIconVisible(boolean z10) {
        d dVar = this.f2391a;
        if (dVar != null) {
            dVar.M(z10);
        }
    }

    public void setChipIconVisible(boolean z10) {
        d dVar = this.f2391a;
        if (dVar != null) {
            dVar.R(z10);
        }
    }

    @Override // android.widget.TextView
    public final void setCompoundDrawablesRelativeWithIntrinsicBounds(Drawable drawable, Drawable drawable2, Drawable drawable3, Drawable drawable4) {
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
    public final void setCompoundDrawablesWithIntrinsicBounds(Drawable drawable, Drawable drawable2, Drawable drawable3, Drawable drawable4) {
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
    public final void setTextAppearance(Context context, int i) {
        super.setTextAppearance(context, i);
        d dVar = this.f2391a;
        if (dVar != null) {
            Context context2 = dVar.s0;
            dVar.f1359y0.b(new C0876f(context2, i), context2);
        }
        h();
    }

    @Override // android.widget.TextView
    public void setTextAppearance(int i) {
        super.setTextAppearance(i);
        d dVar = this.f2391a;
        if (dVar != null) {
            Context context = dVar.s0;
            dVar.f1359y0.b(new C0876f(context, i), context);
        }
        h();
    }
}
