package u6;

import a4.t;
import android.R;
import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.RippleDrawable;
import android.os.Parcelable;
import android.text.Layout;
import android.text.TextPaint;
import android.text.TextUtils;
import android.util.Log;
import android.util.TypedValue;
import android.view.View;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;
import android.widget.Button;
import android.widget.Checkable;
import android.widget.CompoundButton;
import f7.i;
import f7.l;
import f7.m;
import f7.w;
import f7.y;
import f7.z;
import id.k;
import java.lang.invoke.VarHandle;
import java.util.Iterator;
import java.util.LinkedHashSet;
import m.p;
import p5.f;
import z3.h;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public class c extends p implements Checkable, w {
    public static final int[] E = {R.attr.state_checkable};
    public static final int[] F = {R.attr.state_checked};
    public int A;
    public int B;
    public float C;
    public float D;

    /* renamed from: h, reason: collision with root package name */
    public final d f14108h;
    public final LinkedHashSet i;

    /* renamed from: j, reason: collision with root package name */
    public PorterDuff.Mode f14109j;

    /* renamed from: k, reason: collision with root package name */
    public ColorStateList f14110k;

    /* renamed from: l, reason: collision with root package name */
    public Drawable f14111l;

    /* renamed from: m, reason: collision with root package name */
    public String f14112m;

    /* renamed from: n, reason: collision with root package name */
    public int f14113n;

    /* renamed from: o, reason: collision with root package name */
    public int f14114o;

    /* renamed from: p, reason: collision with root package name */
    public int f14115p;

    /* renamed from: q, reason: collision with root package name */
    public int f14116q;

    /* renamed from: r, reason: collision with root package name */
    public boolean f14117r;

    /* renamed from: s, reason: collision with root package name */
    public boolean f14118s;

    /* renamed from: t, reason: collision with root package name */
    public int f14119t;

    /* renamed from: u, reason: collision with root package name */
    public int f14120u;

    /* renamed from: v, reason: collision with root package name */
    public float f14121v;

    /* renamed from: w, reason: collision with root package name */
    public int f14122w;

    /* renamed from: x, reason: collision with root package name */
    public int f14123x;

    /* renamed from: y, reason: collision with root package name */
    public boolean f14124y;

    /* renamed from: z, reason: collision with root package name */
    public int f14125z;

    /* JADX WARN: Removed duplicated region for block: B:12:0x00a5  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public c(android.content.Context r17, android.util.AttributeSet r18) throws android.content.res.Resources.NotFoundException {
        /*
            Method dump skipped, instructions count: 632
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: u6.c.<init>(android.content.Context, android.util.AttributeSet):void");
    }

    public static /* synthetic */ void a(c cVar) {
        cVar.f14125z = cVar.getOpticalCenterShift();
        cVar.i();
        cVar.invalidate();
    }

    private Layout.Alignment getActualTextAlignment() {
        int textAlignment = getTextAlignment();
        return textAlignment != 1 ? (textAlignment == 6 || textAlignment == 3) ? Layout.Alignment.ALIGN_OPPOSITE : textAlignment != 4 ? Layout.Alignment.ALIGN_NORMAL : Layout.Alignment.ALIGN_CENTER : getGravityTextAlignment();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public float getDisplayedWidthIncrease() {
        return this.C;
    }

    private Layout.Alignment getGravityTextAlignment() {
        int gravity = getGravity() & 8388615;
        return gravity != 1 ? (gravity == 5 || gravity == 8388613) ? Layout.Alignment.ALIGN_OPPOSITE : Layout.Alignment.ALIGN_NORMAL : Layout.Alignment.ALIGN_CENTER;
    }

    private int getOpticalCenterShift() {
        return 0;
    }

    private int getTextHeight() {
        if (getLineCount() > 1) {
            return getLayout().getHeight();
        }
        TextPaint paint = getPaint();
        String string = getText().toString();
        if (getTransformationMethod() != null) {
            string = getTransformationMethod().getTransformation(string, this).toString();
        }
        Rect rect = new Rect();
        paint.getTextBounds(string, 0, string.length(), rect);
        return Math.min(rect.height(), getLayout().getHeight());
    }

    private int getTextLayoutWidth() {
        int lineCount = getLineCount();
        float fMax = 0.0f;
        for (int i = 0; i < lineCount; i++) {
            fMax = Math.max(fMax, getLayout().getLineWidth(i));
        }
        return (int) Math.ceil(fMax);
    }

    private void setCheckedInternal(boolean z10) {
        d dVar = this.f14108h;
        if (dVar == null || !dVar.f14144t || this.f14117r == z10) {
            return;
        }
        this.f14117r = z10;
        refreshDrawableState();
        getParent();
        if (this.f14118s) {
            return;
        }
        this.f14118s = true;
        Iterator it = this.i.iterator();
        if (it.hasNext()) {
            throw androidx.activity.b.g(it);
        }
        this.f14118s = false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setDisplayedWidthIncrease(float f5) {
        if (this.C != f5) {
            this.C = f5;
            i();
            invalidate();
            getParent();
        }
    }

    public final h d() {
        Context context = getContext();
        TypedValue typedValueE = f.E(com.stepos.agentsafetycenter.R.attr.motionSpringFastSpatial, context);
        int[] iArr = p6.a.f9821n;
        TypedArray typedArrayObtainStyledAttributes = typedValueE == null ? context.obtainStyledAttributes(null, iArr, 0, com.stepos.agentsafetycenter.R.style.Motion_Material3_Spring_Standard_Fast_Spatial) : context.obtainStyledAttributes(typedValueE.resourceId, iArr);
        h hVar = new h();
        try {
            float f5 = typedArrayObtainStyledAttributes.getFloat(1, Float.MIN_VALUE);
            if (f5 == Float.MIN_VALUE) {
                throw new IllegalArgumentException("A MaterialSpring style must have stiffness value.");
            }
            float f10 = typedArrayObtainStyledAttributes.getFloat(0, Float.MIN_VALUE);
            if (f10 == Float.MIN_VALUE) {
                throw new IllegalArgumentException("A MaterialSpring style must have a damping value.");
            }
            hVar.b(f5);
            hVar.a(f10);
            return hVar;
        } finally {
            typedArrayObtainStyledAttributes.recycle();
        }
    }

    public final boolean e() {
        d dVar = this.f14108h;
        return (dVar == null || dVar.f14142r) ? false : true;
    }

    public final void f() {
        int i = this.f14119t;
        if (i == 1 || i == 2) {
            setCompoundDrawablesRelative(this.f14111l, null, null, null);
            return;
        }
        if (i == 3 || i == 4) {
            setCompoundDrawablesRelative(null, null, this.f14111l, null);
        } else if (i == 16 || i == 32) {
            setCompoundDrawablesRelative(null, this.f14111l, null, null);
        }
    }

    public final void g(boolean z10) {
        Drawable drawable = this.f14111l;
        if (drawable != null) {
            Drawable drawableMutate = drawable.mutate();
            this.f14111l = drawableMutate;
            drawableMutate.setTintList(this.f14110k);
            PorterDuff.Mode mode = this.f14109j;
            if (mode != null) {
                this.f14111l.setTintMode(mode);
            }
            int intrinsicWidth = this.f14113n;
            if (intrinsicWidth == 0) {
                intrinsicWidth = this.f14111l.getIntrinsicWidth();
            }
            int intrinsicHeight = this.f14113n;
            if (intrinsicHeight == 0) {
                intrinsicHeight = this.f14111l.getIntrinsicHeight();
            }
            Drawable drawable2 = this.f14111l;
            int i = this.f14114o;
            int i3 = this.f14115p;
            drawable2.setBounds(i, i3, intrinsicWidth + i, intrinsicHeight + i3);
            this.f14111l.setVisible(true, z10);
        }
        if (z10) {
            f();
            return;
        }
        Drawable[] compoundDrawablesRelative = getCompoundDrawablesRelative();
        Drawable drawable3 = compoundDrawablesRelative[0];
        Drawable drawable4 = compoundDrawablesRelative[1];
        Drawable drawable5 = compoundDrawablesRelative[2];
        int i10 = this.f14119t;
        if (((i10 == 1 || i10 == 2) && drawable3 != this.f14111l) || (((i10 == 3 || i10 == 4) && drawable5 != this.f14111l) || ((i10 == 16 || i10 == 32) && drawable4 != this.f14111l))) {
            f();
        }
    }

    @SuppressLint({"KotlinPropertyAccess"})
    public String getA11yClassName() {
        if (!TextUtils.isEmpty(this.f14112m)) {
            return this.f14112m;
        }
        d dVar = this.f14108h;
        return ((dVar == null || !dVar.f14144t) ? Button.class : CompoundButton.class).getName();
    }

    public int getAllowedWidthDecrease() {
        return this.A;
    }

    @Override // android.view.View
    public ColorStateList getBackgroundTintList() {
        return getSupportBackgroundTintList();
    }

    @Override // android.view.View
    public PorterDuff.Mode getBackgroundTintMode() {
        return getSupportBackgroundTintMode();
    }

    public int getCornerRadius() {
        if (e()) {
            return this.f14108h.f14134j;
        }
        return 0;
    }

    public h getCornerSpringForce() {
        return this.f14108h.f14129d;
    }

    public Drawable getIcon() {
        return this.f14111l;
    }

    public int getIconGravity() {
        return this.f14119t;
    }

    public int getIconPadding() {
        return this.f14116q;
    }

    public int getIconSize() {
        return this.f14113n;
    }

    public ColorStateList getIconTint() {
        return this.f14110k;
    }

    public PorterDuff.Mode getIconTintMode() {
        return this.f14109j;
    }

    public int getInsetBottom() {
        return this.f14108h.i;
    }

    public int getInsetTop() {
        return this.f14108h.f14133h;
    }

    public ColorStateList getRippleColor() {
        if (e()) {
            return this.f14108h.f14139o;
        }
        return null;
    }

    public m getShapeAppearanceModel() {
        if (e()) {
            return this.f14108h.f14127b;
        }
        od.f.e("Attempted to get ShapeAppearanceModel from a MaterialButton which has an overwritten background.");
        return null;
    }

    public y getStateListShapeAppearanceModel() {
        if (e()) {
            return this.f14108h.f14128c;
        }
        od.f.e("Attempted to get StateListShapeAppearanceModel from a MaterialButton which has an overwritten background.");
        return null;
    }

    public ColorStateList getStrokeColor() {
        if (e()) {
            return this.f14108h.f14138n;
        }
        return null;
    }

    public int getStrokeWidth() {
        if (e()) {
            return this.f14108h.f14135k;
        }
        return 0;
    }

    @Override // m.p
    public ColorStateList getSupportBackgroundTintList() {
        return e() ? this.f14108h.f14137m : super.getSupportBackgroundTintList();
    }

    @Override // m.p
    public PorterDuff.Mode getSupportBackgroundTintMode() {
        return e() ? this.f14108h.f14136l : super.getSupportBackgroundTintMode();
    }

    public final void h(int i, int i3) {
        if (this.f14111l == null || getLayout() == null) {
            return;
        }
        int i10 = this.f14119t;
        if (i10 != 1 && i10 != 2 && i10 != 3 && i10 != 4) {
            if (i10 == 16 || i10 == 32) {
                this.f14114o = 0;
                if (i10 == 16) {
                    this.f14115p = 0;
                    g(false);
                    return;
                }
                int intrinsicHeight = this.f14113n;
                if (intrinsicHeight == 0) {
                    intrinsicHeight = this.f14111l.getIntrinsicHeight();
                }
                int iMax = Math.max(0, (((((i3 - getTextHeight()) - getPaddingTop()) - intrinsicHeight) - this.f14116q) - getPaddingBottom()) / 2);
                if (this.f14115p != iMax) {
                    this.f14115p = iMax;
                    g(false);
                    return;
                }
                return;
            }
            return;
        }
        this.f14115p = 0;
        Layout.Alignment actualTextAlignment = getActualTextAlignment();
        int i11 = this.f14119t;
        if (i11 == 1 || i11 == 3 || ((i11 == 2 && actualTextAlignment == Layout.Alignment.ALIGN_NORMAL) || (i11 == 4 && actualTextAlignment == Layout.Alignment.ALIGN_OPPOSITE))) {
            this.f14114o = 0;
            g(false);
            return;
        }
        int intrinsicWidth = this.f14113n;
        if (intrinsicWidth == 0) {
            intrinsicWidth = this.f14111l.getIntrinsicWidth();
        }
        int textLayoutWidth = ((((i - getTextLayoutWidth()) - getPaddingEnd()) - intrinsicWidth) - this.f14116q) - getPaddingStart();
        if (actualTextAlignment == Layout.Alignment.ALIGN_CENTER) {
            textLayoutWidth /= 2;
        }
        if ((getLayoutDirection() == 1) != (this.f14119t == 4)) {
            textLayoutWidth = -textLayoutWidth;
        }
        if (this.f14114o != textLayoutWidth) {
            this.f14114o = textLayoutWidth;
            g(false);
        }
    }

    public final void i() {
        int i = (int) (this.C - this.D);
        int i3 = (i / 2) + this.f14125z;
        getLayoutParams().width = (int) (this.f14121v + i);
        setPaddingRelative(this.f14122w + i3, getPaddingTop(), (this.f14123x + i) - i3, getPaddingBottom());
    }

    @Override // android.widget.Checkable
    public final boolean isChecked() {
        return this.f14117r;
    }

    @Override // android.widget.TextView, android.view.View
    public final void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (e()) {
            a.a.V(this, this.f14108h.a(false));
        }
    }

    @Override // android.widget.TextView, android.view.View
    public final int[] onCreateDrawableState(int i) {
        int[] iArrOnCreateDrawableState = super.onCreateDrawableState(i + 2);
        d dVar = this.f14108h;
        if (dVar != null && dVar.f14144t) {
            View.mergeDrawableStates(iArrOnCreateDrawableState, E);
        }
        if (this.f14117r) {
            View.mergeDrawableStates(iArrOnCreateDrawableState, F);
        }
        return iArrOnCreateDrawableState;
    }

    @Override // m.p, android.view.View
    public final void onInitializeAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        super.onInitializeAccessibilityEvent(accessibilityEvent);
        accessibilityEvent.setClassName(getA11yClassName());
        accessibilityEvent.setChecked(this.f14117r);
    }

    @Override // m.p, android.view.View
    public final void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo accessibilityNodeInfo) {
        super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
        accessibilityNodeInfo.setClassName(getA11yClassName());
        d dVar = this.f14108h;
        accessibilityNodeInfo.setCheckable(dVar != null && dVar.f14144t);
        accessibilityNodeInfo.setChecked(this.f14117r);
        accessibilityNodeInfo.setClickable(isClickable());
    }

    @Override // m.p, android.widget.TextView, android.view.View
    public final void onLayout(boolean z10, int i, int i3, int i10, int i11) {
        int i12;
        super.onLayout(z10, i, i3, i10, i11);
        h(getMeasuredWidth(), getMeasuredHeight());
        int i13 = getResources().getConfiguration().orientation;
        if (this.f14120u != i13) {
            this.f14120u = i13;
            this.f14121v = -1.0f;
        }
        if (this.f14121v == -1.0f) {
            this.f14121v = getMeasuredWidth();
            getParent();
        }
        if (this.A == -1) {
            if (this.f14111l == null) {
                i12 = 0;
            } else {
                int iconPadding = getIconPadding();
                int intrinsicWidth = this.f14113n;
                if (intrinsicWidth == 0) {
                    intrinsicWidth = this.f14111l.getIntrinsicWidth();
                }
                i12 = iconPadding + intrinsicWidth;
            }
            this.A = (getMeasuredWidth() - getTextLayoutWidth()) - i12;
        }
        if (this.f14122w == -1) {
            this.f14122w = getPaddingStart();
        }
        if (this.f14123x == -1) {
            this.f14123x = getPaddingEnd();
        }
        getParent();
    }

    @Override // android.widget.TextView, android.view.View
    public final void onRestoreInstanceState(Parcelable parcelable) {
        if (!(parcelable instanceof b)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        b bVar = (b) parcelable;
        super.onRestoreInstanceState(bVar.getSuperState());
        setChecked(bVar.f14107c);
    }

    @Override // android.widget.TextView, android.view.View
    public final Parcelable onSaveInstanceState() {
        b bVar = new b(super.onSaveInstanceState());
        bVar.f14107c = this.f14117r;
        return bVar;
    }

    @Override // m.p, android.widget.TextView
    public final void onTextChanged(CharSequence charSequence, int i, int i3, int i10) {
        super.onTextChanged(charSequence, i, i3, i10);
        h(getMeasuredWidth(), getMeasuredHeight());
    }

    @Override // android.view.View
    public final boolean performClick() {
        if (isEnabled() && this.f14108h.f14145u) {
            toggle();
        }
        return super.performClick();
    }

    @Override // android.view.View
    public final void refreshDrawableState() {
        super.refreshDrawableState();
        if (this.f14111l != null) {
            if (this.f14111l.setState(getDrawableState())) {
                invalidate();
            }
        }
    }

    public void setA11yClassName(String str) {
        this.f14112m = str;
    }

    @Override // android.view.View
    public void setBackground(Drawable drawable) {
        setBackgroundDrawable(drawable);
    }

    @Override // android.view.View
    public void setBackgroundColor(int i) {
        if (!e()) {
            super.setBackgroundColor(i);
            return;
        }
        d dVar = this.f14108h;
        if (dVar.a(false) != null) {
            dVar.a(false).setTint(i);
        }
    }

    @Override // m.p, android.view.View
    public void setBackgroundDrawable(Drawable drawable) {
        if (!e()) {
            super.setBackgroundDrawable(drawable);
            return;
        }
        if (drawable == getBackground()) {
            getBackground().setState(drawable.getState());
            return;
        }
        Log.w("MaterialButton", "MaterialButton manages its own background to control elevation, shape, color and states. Consider using backgroundTint, shapeAppearance and other attributes where available. A custom background will ignore these attributes and you should consider handling interaction states such as pressed, focused and disabled");
        d dVar = this.f14108h;
        dVar.f14142r = true;
        c cVar = dVar.f14126a;
        cVar.setSupportBackgroundTintList(dVar.f14137m);
        cVar.setSupportBackgroundTintMode(dVar.f14136l);
        super.setBackgroundDrawable(drawable);
    }

    @Override // m.p, android.view.View
    public void setBackgroundResource(int i) {
        setBackgroundDrawable(i != 0 ? k.v(i, getContext()) : null);
    }

    @Override // android.view.View
    public void setBackgroundTintList(ColorStateList colorStateList) {
        setSupportBackgroundTintList(colorStateList);
    }

    @Override // android.view.View
    public void setBackgroundTintMode(PorterDuff.Mode mode) {
        setSupportBackgroundTintMode(mode);
    }

    public void setCheckable(boolean z10) {
        if (e()) {
            this.f14108h.f14144t = z10;
        }
    }

    @Override // android.widget.Checkable
    public void setChecked(boolean z10) {
        setCheckedInternal(z10);
    }

    public void setCornerRadius(int i) {
        if (e()) {
            d dVar = this.f14108h;
            if (dVar.f14143s && dVar.f14134j == i) {
                return;
            }
            dVar.f14134j = i;
            dVar.f14143s = true;
            float f5 = i;
            l lVarF = dVar.f14127b.f();
            lVarF.f3979e = new f7.a(f5);
            lVarF.f3980f = new f7.a(f5);
            lVarF.f3981g = new f7.a(f5);
            lVarF.f3982h = new f7.a(f5);
            dVar.f14127b = lVarF.a();
            dVar.f14128c = null;
            dVar.d();
        }
    }

    public void setCornerRadiusResource(int i) {
        if (e()) {
            setCornerRadius(getResources().getDimensionPixelSize(i));
        }
    }

    public void setCornerSpringForce(h hVar) {
        d dVar = this.f14108h;
        dVar.f14129d = hVar;
        if (dVar.f14128c != null) {
            dVar.d();
        }
    }

    public void setDisplayedWidthDecrease(int i) {
        this.D = Math.min(i, this.A);
        i();
        invalidate();
    }

    @Override // android.view.View
    public void setElevation(float f5) {
        super.setElevation(f5);
        if (e()) {
            this.f14108h.a(false).i(f5);
        }
    }

    public void setIcon(Drawable drawable) {
        if (this.f14111l != drawable) {
            this.f14111l = drawable;
            g(true);
            h(getMeasuredWidth(), getMeasuredHeight());
        }
    }

    public void setIconGravity(int i) {
        if (this.f14119t != i) {
            this.f14119t = i;
            h(getMeasuredWidth(), getMeasuredHeight());
        }
    }

    public void setIconPadding(int i) {
        if (this.f14116q != i) {
            this.f14116q = i;
            setCompoundDrawablePadding(i);
        }
    }

    public void setIconResource(int i) {
        setIcon(i != 0 ? k.v(i, getContext()) : null);
    }

    public void setIconSize(int i) {
        if (i < 0) {
            g5.f.s("iconSize cannot be less than 0");
        } else if (this.f14113n != i) {
            this.f14113n = i;
            g(true);
        }
    }

    public void setIconTint(ColorStateList colorStateList) {
        if (this.f14110k != colorStateList) {
            this.f14110k = colorStateList;
            g(false);
        }
    }

    public void setIconTintMode(PorterDuff.Mode mode) {
        if (this.f14109j != mode) {
            this.f14109j = mode;
            g(false);
        }
    }

    public void setIconTintResource(int i) {
        setIconTint(k.u(i, getContext()));
    }

    public void setInsetBottom(int i) {
        d dVar = this.f14108h;
        dVar.b(dVar.f14133h, i);
    }

    public void setInsetTop(int i) {
        d dVar = this.f14108h;
        dVar.b(i, dVar.i);
    }

    public void setInternalBackground(Drawable drawable) {
        super.setBackgroundDrawable(drawable);
    }

    public void setOpticalCenterEnabled(boolean z10) {
        if (this.f14124y != z10) {
            this.f14124y = z10;
            d dVar = this.f14108h;
            if (z10) {
                b.b bVar = new b.b(8);
                bVar.f1685f = this;
                VarHandle.storeStoreFence();
                dVar.f14130e = bVar;
                i iVarA = dVar.a(false);
                if (iVarA != null) {
                    iVarA.G = bVar;
                }
            } else {
                dVar.f14130e = null;
                i iVarA2 = dVar.a(false);
                if (iVarA2 != null) {
                    iVarA2.G = null;
                }
            }
            t tVar = new t(22);
            tVar.f200f = this;
            VarHandle.storeStoreFence();
            post(tVar);
        }
    }

    @Override // android.view.View
    public void setPressed(boolean z10) {
        super.setPressed(z10);
    }

    public void setRippleColor(ColorStateList colorStateList) {
        if (e()) {
            d dVar = this.f14108h;
            c cVar = dVar.f14126a;
            if (dVar.f14139o != colorStateList) {
                dVar.f14139o = colorStateList;
                if (cVar.getBackground() instanceof RippleDrawable) {
                    RippleDrawable rippleDrawable = (RippleDrawable) cVar.getBackground();
                    if (colorStateList == null) {
                        colorStateList = ColorStateList.valueOf(0);
                    }
                    rippleDrawable.setColor(colorStateList);
                }
            }
        }
    }

    public void setRippleColorResource(int i) {
        if (e()) {
            setRippleColor(k.u(i, getContext()));
        }
    }

    @Override // f7.w
    public void setShapeAppearanceModel(m mVar) {
        if (!e()) {
            od.f.e("Attempted to set ShapeAppearanceModel on a MaterialButton which has an overwritten background.");
            return;
        }
        d dVar = this.f14108h;
        dVar.f14127b = mVar;
        dVar.f14128c = null;
        dVar.d();
    }

    public void setShouldDrawSurfaceColorStroke(boolean z10) {
        if (e()) {
            d dVar = this.f14108h;
            dVar.f14141q = z10;
            dVar.e();
        }
    }

    public void setStateListShapeAppearanceModel(y yVar) {
        if (!e()) {
            od.f.e("Attempted to set StateListShapeAppearanceModel on a MaterialButton which has an overwritten background.");
            return;
        }
        d dVar = this.f14108h;
        if (dVar.f14129d == null && yVar.f4033a > 1) {
            dVar.f14129d = d();
            if (dVar.f14128c != null) {
                dVar.d();
            }
        }
        dVar.f14128c = yVar;
        dVar.d();
    }

    public void setStrokeColor(ColorStateList colorStateList) {
        if (e()) {
            d dVar = this.f14108h;
            if (dVar.f14138n != colorStateList) {
                dVar.f14138n = colorStateList;
                dVar.e();
            }
        }
    }

    public void setStrokeColorResource(int i) {
        if (e()) {
            setStrokeColor(k.u(i, getContext()));
        }
    }

    public void setStrokeWidth(int i) {
        if (e()) {
            d dVar = this.f14108h;
            if (dVar.f14135k != i) {
                dVar.f14135k = i;
                dVar.e();
            }
        }
    }

    public void setStrokeWidthResource(int i) {
        if (e()) {
            setStrokeWidth(getResources().getDimensionPixelSize(i));
        }
    }

    @Override // m.p
    public void setSupportBackgroundTintList(ColorStateList colorStateList) {
        if (!e()) {
            super.setSupportBackgroundTintList(colorStateList);
            return;
        }
        d dVar = this.f14108h;
        if (dVar.f14137m != colorStateList) {
            dVar.f14137m = colorStateList;
            if (dVar.a(false) != null) {
                dVar.a(false).setTintList(dVar.f14137m);
            }
        }
    }

    @Override // m.p
    public void setSupportBackgroundTintMode(PorterDuff.Mode mode) {
        if (!e()) {
            super.setSupportBackgroundTintMode(mode);
            return;
        }
        d dVar = this.f14108h;
        if (dVar.f14136l != mode) {
            dVar.f14136l = mode;
            if (dVar.a(false) == null || dVar.f14136l == null) {
                return;
            }
            dVar.a(false).setTintMode(dVar.f14136l);
        }
    }

    @Override // android.view.View
    public void setTextAlignment(int i) {
        super.setTextAlignment(i);
        h(getMeasuredWidth(), getMeasuredHeight());
    }

    public void setToggleCheckedStateOnClick(boolean z10) {
        this.f14108h.f14145u = z10;
    }

    @Override // android.widget.TextView
    public void setWidth(int i) {
        this.f14121v = -1.0f;
        super.setWidth(i);
    }

    public void setWidthChangeMax(int i) {
        if (this.B != i) {
            this.B = i;
        }
    }

    @Override // android.widget.Checkable
    public final void toggle() {
        setChecked(!this.f14117r);
    }

    public void setOnPressedChangeListenerInternal(a aVar) {
    }

    public void setSizeChange(z zVar) {
    }
}
