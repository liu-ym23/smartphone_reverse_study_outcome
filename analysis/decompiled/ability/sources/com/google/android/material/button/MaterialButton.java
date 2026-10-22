package com.google.android.material.button;

import android.R;
import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.RippleDrawable;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.Layout;
import android.text.TextPaint;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.Log;
import android.util.TypedValue;
import android.view.View;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;
import android.widget.Button;
import android.widget.Checkable;
import android.widget.CompoundButton;
import android.widget.LinearLayout;
import androidx.annotation.ColorInt;
import androidx.annotation.ColorRes;
import androidx.annotation.DimenRes;
import androidx.annotation.Dimension;
import androidx.annotation.DrawableRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.Px;
import androidx.annotation.RestrictTo;
import androidx.appcompat.content.res.AppCompatResources;
import androidx.appcompat.widget.AppCompatButton;
import androidx.core.graphics.drawable.DrawableCompat;
import androidx.core.view.GravityCompat;
import androidx.customview.view.AbsSavedState;
import androidx.dynamicanimation.animation.SpringAnimation;
import androidx.dynamicanimation.animation.SpringForce;
import c3.AbstractC0872b;
import c3.AbstractC0873c;
import com.google.android.material.internal.k;
import com.google.android.material.internal.o;
import e3.C1409C;
import e3.C1411E;
import e3.InterfaceC1407A;
import e3.p;
import g1.AbstractC1451a;
import java.util.Iterator;
import java.util.LinkedHashSet;
import u1.C2031a;

/* loaded from: classes3.dex */
public class MaterialButton extends AppCompatButton implements Checkable, InterfaceC1407A {

    /* renamed from: C, reason: collision with root package name */
    public static final int[] f2350C = {R.attr.state_checkable};

    /* renamed from: D, reason: collision with root package name */
    public static final int[] f2351D = {R.attr.state_checked};
    public static final a E = new a("widthIncrease", 0);

    /* renamed from: A, reason: collision with root package name */
    public float f2352A;

    /* renamed from: B, reason: collision with root package name */
    public SpringAnimation f2353B;

    /* renamed from: a, reason: collision with root package name */
    public final e f2354a;
    public final LinkedHashSet b;
    public b c;
    public PorterDuff.Mode d;
    public ColorStateList e;
    public Drawable f;
    public String g;
    public int h;
    public int i;

    /* renamed from: j, reason: collision with root package name */
    public int f2355j;
    public int k;
    public boolean l;
    public boolean m;
    public int n;
    public int o;
    public float p;

    /* renamed from: q, reason: collision with root package name */
    public int f2356q;

    /* renamed from: r, reason: collision with root package name */
    public int f2357r;

    /* renamed from: s, reason: collision with root package name */
    public LinearLayout.LayoutParams f2358s;

    /* renamed from: t, reason: collision with root package name */
    public boolean f2359t;
    public int u;

    /* renamed from: v, reason: collision with root package name */
    public boolean f2360v;

    /* renamed from: w, reason: collision with root package name */
    public int f2361w;

    /* renamed from: x, reason: collision with root package name */
    public C1411E f2362x;
    public int y;

    /* renamed from: z, reason: collision with root package name */
    public float f2363z;

    public static class SavedState extends AbsSavedState {
        public static final Parcelable.Creator<SavedState> CREATOR = new c();
        boolean checked;

        public SavedState(Parcelable parcelable) {
            super(parcelable);
        }

        private void readFromParcel(@NonNull Parcel parcel) {
            this.checked = parcel.readInt() == 1;
        }

        @Override // androidx.customview.view.AbsSavedState, android.os.Parcelable
        public void writeToParcel(@NonNull Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
            parcel.writeInt(this.checked ? 1 : 0);
        }

        public SavedState(@NonNull Parcel parcel, ClassLoader classLoader) {
            super(parcel, classLoader);
            if (classLoader == null) {
                getClass().getClassLoader();
            }
            readFromParcel(parcel);
        }
    }

    public MaterialButton(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        super(i3.a.b(context, attributeSet, new int[]{com.stepos.ability.R.attr.materialSizeOverlay}, com.stepos.ability.R.attr.materialButtonStyle, com.stepos.ability.R.style.Widget_MaterialComponents_Button), attributeSet, com.stepos.ability.R.attr.materialButtonStyle);
        this.b = new LinkedHashSet();
        this.l = false;
        this.m = false;
        this.o = -1;
        this.p = -1.0f;
        this.f2356q = -1;
        this.f2357r = -1;
        this.f2361w = -1;
        Context context2 = getContext();
        TypedArray typedArrayD = k.d(context2, attributeSet, P2.a.n, com.stepos.ability.R.attr.materialButtonStyle, com.stepos.ability.R.style.Widget_MaterialComponents_Button, new int[0]);
        this.k = typedArrayD.getDimensionPixelSize(13, 0);
        int i = typedArrayD.getInt(16, -1);
        PorterDuff.Mode mode = PorterDuff.Mode.SRC_IN;
        this.d = o.b(i, mode);
        this.e = AbstractC0873c.a(getContext(), typedArrayD, 15);
        this.f = AbstractC0873c.c(getContext(), typedArrayD, 11);
        this.n = typedArrayD.getInteger(12, 1);
        this.h = typedArrayD.getDimensionPixelSize(14, 0);
        C1409C c1409cB = C1409C.b(context2, typedArrayD, 19);
        p pVarC = c1409cB != null ? c1409cB.c() : p.b(context2, attributeSet, com.stepos.ability.R.attr.materialButtonStyle, com.stepos.ability.R.style.Widget_MaterialComponents_Button).a();
        boolean z10 = typedArrayD.getBoolean(17, false);
        e eVar = new e(this, pVarC);
        this.f2354a = eVar;
        eVar.f = typedArrayD.getDimensionPixelOffset(2, 0);
        eVar.g = typedArrayD.getDimensionPixelOffset(3, 0);
        eVar.h = typedArrayD.getDimensionPixelOffset(4, 0);
        eVar.i = typedArrayD.getDimensionPixelOffset(5, 0);
        if (typedArrayD.hasValue(9)) {
            int dimensionPixelSize = typedArrayD.getDimensionPixelSize(9, -1);
            eVar.f2369j = dimensionPixelSize;
            e3.o oVarF = eVar.b.f();
            oVarF.c(dimensionPixelSize);
            eVar.b = oVarF.a();
            eVar.c = null;
            eVar.d();
            eVar.f2372s = true;
        }
        eVar.k = typedArrayD.getDimensionPixelSize(22, 0);
        eVar.l = o.b(typedArrayD.getInt(8, -1), mode);
        eVar.m = AbstractC0873c.a(getContext(), typedArrayD, 7);
        eVar.n = AbstractC0873c.a(getContext(), typedArrayD, 21);
        eVar.o = AbstractC0873c.a(getContext(), typedArrayD, 18);
        eVar.f2373t = typedArrayD.getBoolean(6, false);
        eVar.f2375w = typedArrayD.getDimensionPixelSize(10, 0);
        eVar.u = typedArrayD.getBoolean(23, true);
        int paddingStart = getPaddingStart();
        int paddingTop = getPaddingTop();
        int paddingEnd = getPaddingEnd();
        int paddingBottom = getPaddingBottom();
        if (typedArrayD.hasValue(0)) {
            eVar.f2371r = true;
            setSupportBackgroundTintList(eVar.m);
            setSupportBackgroundTintMode(eVar.l);
        } else {
            eVar.c();
        }
        setPaddingRelative(paddingStart + eVar.f, paddingTop + eVar.h, paddingEnd + eVar.g, paddingBottom + eVar.i);
        setCheckedInternal(typedArrayD.getBoolean(1, false));
        if (c1409cB != null) {
            eVar.d = d();
            if (eVar.c != null) {
                eVar.d();
            }
            eVar.c = c1409cB;
            eVar.d();
        }
        setOpticalCenterEnabled(z10);
        typedArrayD.recycle();
        setCompoundDrawablePadding(this.k);
        h(this.f != null);
    }

    public static /* synthetic */ void a(MaterialButton materialButton) {
        materialButton.u = materialButton.getOpticalCenterShift();
        materialButton.j();
        materialButton.invalidate();
    }

    private Layout.Alignment getActualTextAlignment() {
        int textAlignment = getTextAlignment();
        return textAlignment != 1 ? (textAlignment == 6 || textAlignment == 3) ? Layout.Alignment.ALIGN_OPPOSITE : textAlignment != 4 ? Layout.Alignment.ALIGN_NORMAL : Layout.Alignment.ALIGN_CENTER : getGravityTextAlignment();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public float getDisplayedWidthIncrease() {
        return this.f2363z;
    }

    private Layout.Alignment getGravityTextAlignment() {
        int gravity = getGravity() & GravityCompat.RELATIVE_HORIZONTAL_GRAVITY_MASK;
        return gravity != 1 ? (gravity == 5 || gravity == 8388613) ? Layout.Alignment.ALIGN_OPPOSITE : Layout.Alignment.ALIGN_NORMAL : Layout.Alignment.ALIGN_CENTER;
    }

    private int getOpticalCenterShift() {
        e3.k kVarA;
        if (this.f2359t && this.f2360v && (kVarA = this.f2354a.a(false)) != null) {
            return (int) (kVarA.i() * 0.11f);
        }
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
        e eVar = this.f2354a;
        if (eVar == null || !eVar.f2373t || this.l == z10) {
            return;
        }
        this.l = z10;
        refreshDrawableState();
        if (getParent() instanceof MaterialButtonToggleGroup) {
            MaterialButtonToggleGroup materialButtonToggleGroup = (MaterialButtonToggleGroup) getParent();
            boolean z11 = this.l;
            if (!materialButtonToggleGroup.l) {
                materialButtonToggleGroup.f(getId(), z11);
            }
        }
        if (this.m) {
            return;
        }
        this.m = true;
        Iterator it = this.b.iterator();
        if (it.hasNext()) {
            throw B7.a.f(it);
        }
        this.m = false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setDisplayedWidthIncrease(float f) {
        MaterialButton materialButton;
        MaterialButton materialButton2;
        if (this.f2363z != f) {
            this.f2363z = f;
            j();
            invalidate();
            if (getParent() instanceof d) {
                d dVar = (d) getParent();
                int i = (int) this.f2363z;
                int iIndexOfChild = dVar.indexOfChild(this);
                if (iIndexOfChild < 0) {
                    return;
                }
                int i6 = iIndexOfChild - 1;
                while (true) {
                    materialButton = null;
                    if (i6 < 0) {
                        materialButton2 = null;
                        break;
                    } else {
                        if (dVar.c(i6)) {
                            materialButton2 = (MaterialButton) dVar.getChildAt(i6);
                            break;
                        }
                        i6--;
                    }
                }
                int childCount = dVar.getChildCount();
                while (true) {
                    iIndexOfChild++;
                    if (iIndexOfChild >= childCount) {
                        break;
                    } else if (dVar.c(iIndexOfChild)) {
                        materialButton = (MaterialButton) dVar.getChildAt(iIndexOfChild);
                        break;
                    }
                }
                if (materialButton2 == null && materialButton == null) {
                    return;
                }
                if (materialButton2 == null) {
                    materialButton.setDisplayedWidthDecrease(i);
                }
                if (materialButton == null) {
                    materialButton2.setDisplayedWidthDecrease(i);
                }
                if (materialButton2 == null || materialButton == null) {
                    return;
                }
                materialButton2.setDisplayedWidthDecrease(i / 2);
                materialButton.setDisplayedWidthDecrease((i + 1) / 2);
            }
        }
    }

    public final SpringForce d() {
        Context context = getContext();
        TypedValue typedValueA = AbstractC0872b.a(com.stepos.ability.R.attr.motionSpringFastSpatial, context);
        int[] iArr = P2.a.f1082x;
        TypedArray typedArrayObtainStyledAttributes = typedValueA == null ? context.obtainStyledAttributes(null, iArr, 0, com.stepos.ability.R.style.Motion_Material3_Spring_Standard_Fast_Spatial) : context.obtainStyledAttributes(typedValueA.resourceId, iArr);
        SpringForce springForce = new SpringForce();
        try {
            float f = typedArrayObtainStyledAttributes.getFloat(1, Float.MIN_VALUE);
            if (f == Float.MIN_VALUE) {
                throw new IllegalArgumentException("A MaterialSpring style must have stiffness value.");
            }
            float f7 = typedArrayObtainStyledAttributes.getFloat(0, Float.MIN_VALUE);
            if (f7 == Float.MIN_VALUE) {
                throw new IllegalArgumentException("A MaterialSpring style must have a damping value.");
            }
            springForce.setStiffness(f);
            springForce.setDampingRatio(f7);
            return springForce;
        } finally {
            typedArrayObtainStyledAttributes.recycle();
        }
    }

    public final boolean e() {
        e eVar = this.f2354a;
        return (eVar == null || eVar.f2371r) ? false : true;
    }

    /* JADX WARN: Removed duplicated region for block: B:39:0x0083  */
    /* JADX WARN: Removed duplicated region for block: B:46:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void f(boolean r9) {
        /*
            r8 = this;
            e3.E r0 = r8.f2362x
            if (r0 != 0) goto L6
            goto L88
        L6:
            androidx.dynamicanimation.animation.SpringAnimation r0 = r8.f2353B
            if (r0 != 0) goto L1a
            androidx.dynamicanimation.animation.SpringAnimation r0 = new androidx.dynamicanimation.animation.SpringAnimation
            com.google.android.material.button.a r1 = com.google.android.material.button.MaterialButton.E
            r0.<init>(r8, r1)
            r8.f2353B = r0
            androidx.dynamicanimation.animation.SpringForce r1 = r8.d()
            r0.setSpring(r1)
        L1a:
            boolean r0 = r8.f2360v
            if (r0 == 0) goto L88
            int r0 = r8.y
            e3.E r1 = r8.f2362x
            int[] r2 = r8.getDrawableState()
            int[][] r3 = r1.c
            r4 = 0
            r5 = r4
        L2a:
            int r6 = r1.f4340a
            r7 = -1
            if (r5 >= r6) goto L3b
            r6 = r3[r5]
            boolean r6 = android.util.StateSet.stateSetMatches(r6, r2)
            if (r6 == 0) goto L38
            goto L3c
        L38:
            int r5 = r5 + 1
            goto L2a
        L3b:
            r5 = r7
        L3c:
            if (r5 >= 0) goto L55
            int[] r2 = android.util.StateSet.WILD_CARD
            int[][] r3 = r1.c
            r5 = r4
        L43:
            int r6 = r1.f4340a
            if (r5 >= r6) goto L54
            r6 = r3[r5]
            boolean r6 = android.util.StateSet.stateSetMatches(r6, r2)
            if (r6 == 0) goto L51
            r7 = r5
            goto L54
        L51:
            int r5 = r5 + 1
            goto L43
        L54:
            r5 = r7
        L55:
            if (r5 >= 0) goto L5a
            B1.c r1 = r1.b
            goto L5e
        L5a:
            B1.c[] r1 = r1.d
            r1 = r1[r5]
        L5e:
            java.lang.Object r1 = r1.f180a
            e3.D r1 = (e3.C1410D) r1
            int r2 = r8.getWidth()
            float r3 = r1.b
            com.google.android.material.shape.StateListSizeChange$SizeChangeType r1 = r1.f4339a
            com.google.android.material.shape.StateListSizeChange$SizeChangeType r5 = com.google.android.material.shape.StateListSizeChange$SizeChangeType.f2508a
            if (r1 != r5) goto L72
            float r1 = (float) r2
            float r3 = r3 * r1
        L70:
            int r4 = (int) r3
            goto L77
        L72:
            com.google.android.material.shape.StateListSizeChange$SizeChangeType r2 = com.google.android.material.shape.StateListSizeChange$SizeChangeType.b
            if (r1 != r2) goto L77
            goto L70
        L77:
            int r0 = java.lang.Math.min(r0, r4)
            androidx.dynamicanimation.animation.SpringAnimation r1 = r8.f2353B
            float r0 = (float) r0
            r1.animateToFinalPosition(r0)
            if (r9 == 0) goto L88
            androidx.dynamicanimation.animation.SpringAnimation r8 = r8.f2353B
            r8.skipToEnd()
        L88:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.material.button.MaterialButton.f(boolean):void");
    }

    public final void g() {
        int i = this.n;
        if (i == 1 || i == 2) {
            setCompoundDrawablesRelative(this.f, null, null, null);
            return;
        }
        if (i == 3 || i == 4) {
            setCompoundDrawablesRelative(null, null, this.f, null);
        } else if (i == 16 || i == 32) {
            setCompoundDrawablesRelative(null, this.f, null, null);
        }
    }

    @NonNull
    @SuppressLint({"KotlinPropertyAccess"})
    public String getA11yClassName() {
        if (!TextUtils.isEmpty(this.g)) {
            return this.g;
        }
        e eVar = this.f2354a;
        return ((eVar == null || !eVar.f2373t) ? Button.class : CompoundButton.class).getName();
    }

    @Px
    public int getAllowedWidthDecrease() {
        return this.f2361w;
    }

    @Override // android.view.View
    @Nullable
    public ColorStateList getBackgroundTintList() {
        return getSupportBackgroundTintList();
    }

    @Override // android.view.View
    @Nullable
    public PorterDuff.Mode getBackgroundTintMode() {
        return getSupportBackgroundTintMode();
    }

    @Px
    public int getCornerRadius() {
        if (e()) {
            return this.f2354a.f2369j;
        }
        return 0;
    }

    @Nullable
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public SpringForce getCornerSpringForce() {
        return this.f2354a.d;
    }

    public Drawable getIcon() {
        return this.f;
    }

    public int getIconGravity() {
        return this.n;
    }

    @Px
    public int getIconPadding() {
        return this.k;
    }

    @Px
    public int getIconSize() {
        return this.h;
    }

    public ColorStateList getIconTint() {
        return this.e;
    }

    public PorterDuff.Mode getIconTintMode() {
        return this.d;
    }

    @Dimension
    public int getInsetBottom() {
        return this.f2354a.i;
    }

    @Dimension
    public int getInsetTop() {
        return this.f2354a.h;
    }

    @Nullable
    public ColorStateList getRippleColor() {
        if (e()) {
            return this.f2354a.o;
        }
        return null;
    }

    @NonNull
    public p getShapeAppearanceModel() {
        if (e()) {
            return this.f2354a.b;
        }
        throw new IllegalStateException("Attempted to get ShapeAppearanceModel from a MaterialButton which has an overwritten background.");
    }

    @Nullable
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public C1409C getStateListShapeAppearanceModel() {
        if (e()) {
            return this.f2354a.c;
        }
        throw new IllegalStateException("Attempted to get StateListShapeAppearanceModel from a MaterialButton which has an overwritten background.");
    }

    public ColorStateList getStrokeColor() {
        if (e()) {
            return this.f2354a.n;
        }
        return null;
    }

    @Px
    public int getStrokeWidth() {
        if (e()) {
            return this.f2354a.k;
        }
        return 0;
    }

    @Override // androidx.appcompat.widget.AppCompatButton, androidx.core.view.TintableBackgroundView
    @Nullable
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public ColorStateList getSupportBackgroundTintList() {
        return e() ? this.f2354a.m : super.getSupportBackgroundTintList();
    }

    @Override // androidx.appcompat.widget.AppCompatButton, androidx.core.view.TintableBackgroundView
    @Nullable
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public PorterDuff.Mode getSupportBackgroundTintMode() {
        return e() ? this.f2354a.l : super.getSupportBackgroundTintMode();
    }

    public final void h(boolean z10) {
        Drawable drawable = this.f;
        if (drawable != null) {
            Drawable drawableMutate = DrawableCompat.wrap(drawable).mutate();
            this.f = drawableMutate;
            drawableMutate.setTintList(this.e);
            PorterDuff.Mode mode = this.d;
            if (mode != null) {
                this.f.setTintMode(mode);
            }
            int intrinsicWidth = this.h;
            if (intrinsicWidth == 0) {
                intrinsicWidth = this.f.getIntrinsicWidth();
            }
            int intrinsicHeight = this.h;
            if (intrinsicHeight == 0) {
                intrinsicHeight = this.f.getIntrinsicHeight();
            }
            Drawable drawable2 = this.f;
            int i = this.i;
            int i6 = this.f2355j;
            drawable2.setBounds(i, i6, intrinsicWidth + i, intrinsicHeight + i6);
            this.f.setVisible(true, z10);
        }
        if (z10) {
            g();
            return;
        }
        Drawable[] compoundDrawablesRelative = getCompoundDrawablesRelative();
        Drawable drawable3 = compoundDrawablesRelative[0];
        Drawable drawable4 = compoundDrawablesRelative[1];
        Drawable drawable5 = compoundDrawablesRelative[2];
        int i10 = this.n;
        if (((i10 == 1 || i10 == 2) && drawable3 != this.f) || (((i10 == 3 || i10 == 4) && drawable5 != this.f) || ((i10 == 16 || i10 == 32) && drawable4 != this.f))) {
            g();
        }
    }

    public final void i(int i, int i6) {
        if (this.f == null || getLayout() == null) {
            return;
        }
        int i10 = this.n;
        if (i10 != 1 && i10 != 2 && i10 != 3 && i10 != 4) {
            if (i10 == 16 || i10 == 32) {
                this.i = 0;
                if (i10 == 16) {
                    this.f2355j = 0;
                    h(false);
                    return;
                }
                int intrinsicHeight = this.h;
                if (intrinsicHeight == 0) {
                    intrinsicHeight = this.f.getIntrinsicHeight();
                }
                int iMax = Math.max(0, (((((i6 - getTextHeight()) - getPaddingTop()) - intrinsicHeight) - this.k) - getPaddingBottom()) / 2);
                if (this.f2355j != iMax) {
                    this.f2355j = iMax;
                    h(false);
                    return;
                }
                return;
            }
            return;
        }
        this.f2355j = 0;
        Layout.Alignment actualTextAlignment = getActualTextAlignment();
        int i11 = this.n;
        if (i11 == 1 || i11 == 3 || ((i11 == 2 && actualTextAlignment == Layout.Alignment.ALIGN_NORMAL) || (i11 == 4 && actualTextAlignment == Layout.Alignment.ALIGN_OPPOSITE))) {
            this.i = 0;
            h(false);
            return;
        }
        int intrinsicWidth = this.h;
        if (intrinsicWidth == 0) {
            intrinsicWidth = this.f.getIntrinsicWidth();
        }
        int textLayoutWidth = ((((i - getTextLayoutWidth()) - getPaddingEnd()) - intrinsicWidth) - this.k) - getPaddingStart();
        if (actualTextAlignment == Layout.Alignment.ALIGN_CENTER) {
            textLayoutWidth /= 2;
        }
        if ((getLayoutDirection() == 1) != (this.n == 4)) {
            textLayoutWidth = -textLayoutWidth;
        }
        if (this.i != textLayoutWidth) {
            this.i = textLayoutWidth;
            h(false);
        }
    }

    @Override // android.widget.Checkable
    public final boolean isChecked() {
        return this.l;
    }

    public final void j() {
        int i = (int) (this.f2363z - this.f2352A);
        int i6 = (i / 2) + this.u;
        getLayoutParams().width = (int) (this.p + i);
        setPaddingRelative(this.f2356q + i6, getPaddingTop(), (this.f2357r + i) - i6, getPaddingBottom());
    }

    @Override // android.widget.TextView, android.view.View
    public final void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (e()) {
            AbstractC1451a.T(this, this.f2354a.a(false));
        }
    }

    @Override // android.widget.TextView, android.view.View
    public final int[] onCreateDrawableState(int i) {
        int[] iArrOnCreateDrawableState = super.onCreateDrawableState(i + 2);
        e eVar = this.f2354a;
        if (eVar != null && eVar.f2373t) {
            View.mergeDrawableStates(iArrOnCreateDrawableState, f2350C);
        }
        if (this.l) {
            View.mergeDrawableStates(iArrOnCreateDrawableState, f2351D);
        }
        return iArrOnCreateDrawableState;
    }

    @Override // androidx.appcompat.widget.AppCompatButton, android.view.View
    public final void onInitializeAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        super.onInitializeAccessibilityEvent(accessibilityEvent);
        accessibilityEvent.setClassName(getA11yClassName());
        accessibilityEvent.setChecked(this.l);
    }

    @Override // androidx.appcompat.widget.AppCompatButton, android.view.View
    public final void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo accessibilityNodeInfo) {
        super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
        accessibilityNodeInfo.setClassName(getA11yClassName());
        e eVar = this.f2354a;
        accessibilityNodeInfo.setCheckable(eVar != null && eVar.f2373t);
        accessibilityNodeInfo.setChecked(this.l);
        accessibilityNodeInfo.setClickable(isClickable());
    }

    @Override // androidx.appcompat.widget.AppCompatButton, android.widget.TextView, android.view.View
    public final void onLayout(boolean z10, int i, int i6, int i10, int i11) {
        int i12;
        super.onLayout(z10, i, i6, i10, i11);
        i(getMeasuredWidth(), getMeasuredHeight());
        int i13 = getResources().getConfiguration().orientation;
        if (this.o != i13) {
            this.o = i13;
            this.p = -1.0f;
        }
        if (this.p == -1.0f) {
            this.p = getMeasuredWidth();
            if (this.f2358s == null && (getParent() instanceof d) && ((d) getParent()).getButtonSizeChange() != null) {
                this.f2358s = (LinearLayout.LayoutParams) getLayoutParams();
                LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(this.f2358s);
                layoutParams.width = (int) this.p;
                setLayoutParams(layoutParams);
            }
        }
        boolean z11 = false;
        if (this.f2361w == -1) {
            if (this.f == null) {
                i12 = 0;
            } else {
                int iconPadding = getIconPadding();
                int intrinsicWidth = this.h;
                if (intrinsicWidth == 0) {
                    intrinsicWidth = this.f.getIntrinsicWidth();
                }
                i12 = iconPadding + intrinsicWidth;
            }
            this.f2361w = (getMeasuredWidth() - getTextLayoutWidth()) - i12;
        }
        if (this.f2356q == -1) {
            this.f2356q = getPaddingStart();
        }
        if (this.f2357r == -1) {
            this.f2357r = getPaddingEnd();
        }
        if ((getParent() instanceof d) && ((d) getParent()).getOrientation() == 0) {
            z11 = true;
        }
        this.f2360v = z11;
    }

    @Override // android.widget.TextView, android.view.View
    public final void onRestoreInstanceState(Parcelable parcelable) {
        if (!(parcelable instanceof SavedState)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        SavedState savedState = (SavedState) parcelable;
        super.onRestoreInstanceState(savedState.getSuperState());
        setChecked(savedState.checked);
    }

    @Override // android.widget.TextView, android.view.View
    public final Parcelable onSaveInstanceState() {
        SavedState savedState = new SavedState(super.onSaveInstanceState());
        savedState.checked = this.l;
        return savedState;
    }

    @Override // androidx.appcompat.widget.AppCompatButton, android.widget.TextView
    public final void onTextChanged(CharSequence charSequence, int i, int i6, int i10) {
        super.onTextChanged(charSequence, i, i6, i10);
        i(getMeasuredWidth(), getMeasuredHeight());
    }

    @Override // android.view.View
    public final boolean performClick() {
        if (isEnabled() && this.f2354a.u) {
            toggle();
        }
        return super.performClick();
    }

    @Override // android.view.View
    public final void refreshDrawableState() {
        super.refreshDrawableState();
        if (this.f != null) {
            if (this.f.setState(getDrawableState())) {
                invalidate();
            }
        }
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public void setA11yClassName(@Nullable String str) {
        this.g = str;
    }

    @Override // android.view.View
    public void setBackground(@NonNull Drawable drawable) {
        setBackgroundDrawable(drawable);
    }

    @Override // android.view.View
    public void setBackgroundColor(@ColorInt int i) {
        if (!e()) {
            super.setBackgroundColor(i);
            return;
        }
        e eVar = this.f2354a;
        if (eVar.a(false) != null) {
            eVar.a(false).setTint(i);
        }
    }

    @Override // androidx.appcompat.widget.AppCompatButton, android.view.View
    public void setBackgroundDrawable(@NonNull Drawable drawable) {
        if (!e()) {
            super.setBackgroundDrawable(drawable);
            return;
        }
        if (drawable == getBackground()) {
            getBackground().setState(drawable.getState());
            return;
        }
        Log.w("MaterialButton", "MaterialButton manages its own background to control elevation, shape, color and states. Consider using backgroundTint, shapeAppearance and other attributes where available. A custom background will ignore these attributes and you should consider handling interaction states such as pressed, focused and disabled");
        e eVar = this.f2354a;
        eVar.f2371r = true;
        MaterialButton materialButton = eVar.f2368a;
        materialButton.setSupportBackgroundTintList(eVar.m);
        materialButton.setSupportBackgroundTintMode(eVar.l);
        super.setBackgroundDrawable(drawable);
    }

    @Override // androidx.appcompat.widget.AppCompatButton, android.view.View
    public void setBackgroundResource(@DrawableRes int i) {
        setBackgroundDrawable(i != 0 ? AppCompatResources.getDrawable(getContext(), i) : null);
    }

    @Override // android.view.View
    public void setBackgroundTintList(@Nullable ColorStateList colorStateList) {
        setSupportBackgroundTintList(colorStateList);
    }

    @Override // android.view.View
    public void setBackgroundTintMode(@Nullable PorterDuff.Mode mode) {
        setSupportBackgroundTintMode(mode);
    }

    public void setCheckable(boolean z10) {
        if (e()) {
            this.f2354a.f2373t = z10;
        }
    }

    @Override // android.widget.Checkable
    public void setChecked(boolean z10) {
        setCheckedInternal(z10);
    }

    public void setCornerRadius(@Px int i) {
        if (e()) {
            e eVar = this.f2354a;
            if (eVar.f2372s && eVar.f2369j == i) {
                return;
            }
            eVar.f2369j = i;
            eVar.f2372s = true;
            e3.o oVarF = eVar.b.f();
            oVarF.c(i);
            eVar.b = oVarF.a();
            eVar.c = null;
            eVar.d();
        }
    }

    public void setCornerRadiusResource(@DimenRes int i) {
        if (e()) {
            setCornerRadius(getResources().getDimensionPixelSize(i));
        }
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public void setCornerSpringForce(@NonNull SpringForce springForce) {
        e eVar = this.f2354a;
        eVar.d = springForce;
        if (eVar.c != null) {
            eVar.d();
        }
    }

    public void setDisplayedWidthDecrease(int i) {
        this.f2352A = Math.min(i, this.f2361w);
        j();
        invalidate();
    }

    @Override // android.view.View
    public void setElevation(float f) {
        super.setElevation(f);
        if (e()) {
            this.f2354a.a(false).p(f);
        }
    }

    public void setIcon(@Nullable Drawable drawable) {
        if (this.f != drawable) {
            this.f = drawable;
            h(true);
            i(getMeasuredWidth(), getMeasuredHeight());
        }
    }

    public void setIconGravity(int i) {
        if (this.n != i) {
            this.n = i;
            i(getMeasuredWidth(), getMeasuredHeight());
        }
    }

    public void setIconPadding(@Px int i) {
        if (this.k != i) {
            this.k = i;
            setCompoundDrawablePadding(i);
        }
    }

    public void setIconResource(@DrawableRes int i) {
        setIcon(i != 0 ? AppCompatResources.getDrawable(getContext(), i) : null);
    }

    public void setIconSize(@Px int i) {
        if (i < 0) {
            throw new IllegalArgumentException("iconSize cannot be less than 0");
        }
        if (this.h != i) {
            this.h = i;
            h(true);
        }
    }

    public void setIconTint(@Nullable ColorStateList colorStateList) {
        if (this.e != colorStateList) {
            this.e = colorStateList;
            h(false);
        }
    }

    public void setIconTintMode(PorterDuff.Mode mode) {
        if (this.d != mode) {
            this.d = mode;
            h(false);
        }
    }

    public void setIconTintResource(@ColorRes int i) {
        setIconTint(AppCompatResources.getColorStateList(getContext(), i));
    }

    public void setInsetBottom(@Dimension int i) {
        e eVar = this.f2354a;
        eVar.b(eVar.h, i);
    }

    public void setInsetTop(@Dimension int i) {
        e eVar = this.f2354a;
        eVar.b(i, eVar.i);
    }

    public void setInternalBackground(Drawable drawable) {
        super.setBackgroundDrawable(drawable);
    }

    public void setOnPressedChangeListenerInternal(@Nullable b bVar) {
        this.c = bVar;
    }

    public void setOpticalCenterEnabled(boolean z10) {
        if (this.f2359t != z10) {
            this.f2359t = z10;
            e eVar = this.f2354a;
            if (z10) {
                B5.a aVar = new B5.a(this, 14);
                eVar.e = aVar;
                e3.k kVarA = eVar.a(false);
                if (kVarA != null) {
                    kVarA.E = aVar;
                }
            } else {
                eVar.e = null;
                e3.k kVarA2 = eVar.a(false);
                if (kVarA2 != null) {
                    kVarA2.E = null;
                }
            }
            post(new D6.b(this, 16));
        }
    }

    @Override // android.view.View
    public void setPressed(boolean z10) {
        b bVar = this.c;
        if (bVar != null) {
            ((MaterialButtonToggleGroup) ((C2031a) bVar).f6686a).invalidate();
        }
        super.setPressed(z10);
        f(false);
    }

    public void setRippleColor(@Nullable ColorStateList colorStateList) {
        if (e()) {
            e eVar = this.f2354a;
            MaterialButton materialButton = eVar.f2368a;
            if (eVar.o != colorStateList) {
                eVar.o = colorStateList;
                if (materialButton.getBackground() instanceof RippleDrawable) {
                    RippleDrawable rippleDrawable = (RippleDrawable) materialButton.getBackground();
                    if (colorStateList == null) {
                        colorStateList = ColorStateList.valueOf(0);
                    }
                    rippleDrawable.setColor(colorStateList);
                }
            }
        }
    }

    public void setRippleColorResource(@ColorRes int i) {
        if (e()) {
            setRippleColor(AppCompatResources.getColorStateList(getContext(), i));
        }
    }

    @Override // e3.InterfaceC1407A
    public void setShapeAppearanceModel(@NonNull p pVar) {
        if (!e()) {
            throw new IllegalStateException("Attempted to set ShapeAppearanceModel on a MaterialButton which has an overwritten background.");
        }
        e eVar = this.f2354a;
        eVar.b = pVar;
        eVar.c = null;
        eVar.d();
    }

    public void setShouldDrawSurfaceColorStroke(boolean z10) {
        if (e()) {
            e eVar = this.f2354a;
            eVar.f2370q = z10;
            eVar.e();
        }
    }

    public void setSizeChange(@NonNull C1411E c1411e) {
        if (this.f2362x != c1411e) {
            this.f2362x = c1411e;
            f(true);
        }
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public void setStateListShapeAppearanceModel(@NonNull C1409C c1409c) {
        if (!e()) {
            throw new IllegalStateException("Attempted to set StateListShapeAppearanceModel on a MaterialButton which has an overwritten background.");
        }
        e eVar = this.f2354a;
        if (eVar.d == null && c1409c.d()) {
            eVar.d = d();
            if (eVar.c != null) {
                eVar.d();
            }
        }
        eVar.c = c1409c;
        eVar.d();
    }

    public void setStrokeColor(@Nullable ColorStateList colorStateList) {
        if (e()) {
            e eVar = this.f2354a;
            if (eVar.n != colorStateList) {
                eVar.n = colorStateList;
                eVar.e();
            }
        }
    }

    public void setStrokeColorResource(@ColorRes int i) {
        if (e()) {
            setStrokeColor(AppCompatResources.getColorStateList(getContext(), i));
        }
    }

    public void setStrokeWidth(@Px int i) {
        if (e()) {
            e eVar = this.f2354a;
            if (eVar.k != i) {
                eVar.k = i;
                eVar.e();
            }
        }
    }

    public void setStrokeWidthResource(@DimenRes int i) {
        if (e()) {
            setStrokeWidth(getResources().getDimensionPixelSize(i));
        }
    }

    @Override // androidx.appcompat.widget.AppCompatButton, androidx.core.view.TintableBackgroundView
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public void setSupportBackgroundTintList(@Nullable ColorStateList colorStateList) {
        if (!e()) {
            super.setSupportBackgroundTintList(colorStateList);
            return;
        }
        e eVar = this.f2354a;
        if (eVar.m != colorStateList) {
            eVar.m = colorStateList;
            if (eVar.a(false) != null) {
                eVar.a(false).setTintList(eVar.m);
            }
        }
    }

    @Override // androidx.appcompat.widget.AppCompatButton, androidx.core.view.TintableBackgroundView
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public void setSupportBackgroundTintMode(@Nullable PorterDuff.Mode mode) {
        if (!e()) {
            super.setSupportBackgroundTintMode(mode);
            return;
        }
        e eVar = this.f2354a;
        if (eVar.l != mode) {
            eVar.l = mode;
            if (eVar.a(false) == null || eVar.l == null) {
                return;
            }
            eVar.a(false).setTintMode(eVar.l);
        }
    }

    @Override // android.view.View
    public void setTextAlignment(int i) {
        super.setTextAlignment(i);
        i(getMeasuredWidth(), getMeasuredHeight());
    }

    public void setToggleCheckedStateOnClick(boolean z10) {
        this.f2354a.u = z10;
    }

    @Override // android.widget.TextView
    public void setWidth(@Px int i) {
        this.p = -1.0f;
        super.setWidth(i);
    }

    public void setWidthChangeMax(@Px int i) {
        if (this.y != i) {
            this.y = i;
            f(true);
        }
    }

    @Override // android.widget.Checkable
    public final void toggle() {
        setChecked(!this.l);
    }
}
