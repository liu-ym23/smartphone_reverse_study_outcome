package com.google.android.material.button;

import B0.f;
import B0.g;
import W.m;
import Z2.I;
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
import androidx.appcompat.widget.C0230v;
import androidx.customview.view.AbsSavedState;
import com.google.android.gms.common.api.internal.p;
import com.google.android.material.internal.l;
import com.stepos.alphame.utils.Property;
import e.EnumC0546d;
import f1.AbstractC0557a;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.Iterator;
import java.util.LinkedHashSet;
import m1.AbstractC0769a;
import t0.J;
import y1.B;
import y1.D;
import y1.j;
import y1.n;
import y1.y;

/* loaded from: classes.dex */
public class MaterialButton extends C0230v implements Checkable, y {

    /* renamed from: F, reason: collision with root package name */
    public static final int[] f10468F = {R.attr.state_checkable};

    /* renamed from: G, reason: collision with root package name */
    public static final int[] f10469G = {R.attr.state_checked};

    /* renamed from: H, reason: collision with root package name */
    public static final K0.a f10470H = new K0.a("widthIncrease", 0);

    /* renamed from: A, reason: collision with root package name */
    public D f10471A;

    /* renamed from: B, reason: collision with root package name */
    public int f10472B;

    /* renamed from: C, reason: collision with root package name */
    public float f10473C;

    /* renamed from: D, reason: collision with root package name */
    public float f10474D;

    /* renamed from: E, reason: collision with root package name */
    public m f10475E;

    /* renamed from: d, reason: collision with root package name */
    public final e f10476d;

    /* renamed from: e, reason: collision with root package name */
    public final LinkedHashSet f10477e;

    /* renamed from: f, reason: collision with root package name */
    public a f10478f;

    /* renamed from: g, reason: collision with root package name */
    public PorterDuff.Mode f10479g;

    /* renamed from: h, reason: collision with root package name */
    public ColorStateList f10480h;

    /* renamed from: i, reason: collision with root package name */
    public Drawable f10481i;

    /* renamed from: j, reason: collision with root package name */
    public String f10482j;

    /* renamed from: k, reason: collision with root package name */
    public int f10483k;

    /* renamed from: l, reason: collision with root package name */
    public int f10484l;

    /* renamed from: m, reason: collision with root package name */
    public int f10485m;

    /* renamed from: n, reason: collision with root package name */
    public int f10486n;

    /* renamed from: o, reason: collision with root package name */
    public boolean f10487o;

    /* renamed from: p, reason: collision with root package name */
    public boolean f10488p;

    /* renamed from: q, reason: collision with root package name */
    public int f10489q;

    /* renamed from: r, reason: collision with root package name */
    public int f10490r;

    /* renamed from: s, reason: collision with root package name */
    public float f10491s;

    /* renamed from: t, reason: collision with root package name */
    public int f10492t;

    /* renamed from: u, reason: collision with root package name */
    public int f10493u;

    /* renamed from: v, reason: collision with root package name */
    public LinearLayout.LayoutParams f10494v;

    /* renamed from: w, reason: collision with root package name */
    public boolean f10495w;

    /* renamed from: x, reason: collision with root package name */
    public int f10496x;

    /* renamed from: y, reason: collision with root package name */
    public boolean f10497y;

    /* renamed from: z, reason: collision with root package name */
    public int f10498z;

    @Retention(RetentionPolicy.SOURCE)
    public @interface IconGravity {
    }

    public static class SavedState extends AbsSavedState {
        public static final Parcelable.Creator<SavedState> CREATOR = new b();

        /* renamed from: a, reason: collision with root package name */
        public boolean f10499a;

        public SavedState(Parcel parcel, ClassLoader classLoader) {
            super(parcel, classLoader);
            if (classLoader == null) {
                getClass().getClassLoader();
            }
            this.f10499a = parcel.readInt() == 1;
        }

        @Override // androidx.customview.view.AbsSavedState, android.os.Parcelable
        public final void writeToParcel(Parcel parcel, int i4) {
            super.writeToParcel(parcel, i4);
            parcel.writeInt(this.f10499a ? 1 : 0);
        }
    }

    public MaterialButton(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        super(C1.a.a(com.stepos.alphame.R.attr.materialButtonStyle, com.stepos.alphame.R.style.Widget_MaterialComponents_Button, context, attributeSet, new int[]{com.stepos.alphame.R.attr.materialSizeOverlay}), attributeSet, com.stepos.alphame.R.attr.materialButtonStyle);
        this.f10477e = new LinkedHashSet();
        this.f10487o = false;
        this.f10488p = false;
        this.f10490r = -1;
        this.f10491s = -1.0f;
        this.f10492t = -1;
        this.f10493u = -1;
        this.f10498z = -1;
        Context context2 = getContext();
        TypedArray typedArrayE = l.e(context2, attributeSet, AbstractC0769a.f13548n, com.stepos.alphame.R.attr.materialButtonStyle, com.stepos.alphame.R.style.Widget_MaterialComponents_Button, new int[0]);
        this.f10486n = typedArrayE.getDimensionPixelSize(13, 0);
        int i4 = typedArrayE.getInt(16, -1);
        PorterDuff.Mode mode = PorterDuff.Mode.SRC_IN;
        this.f10479g = J.D(i4, mode);
        this.f10480h = f.y(getContext(), typedArrayE, 15);
        this.f10481i = f.D(getContext(), typedArrayE, 11);
        this.f10489q = typedArrayE.getInteger(12, 1);
        this.f10483k = typedArrayE.getDimensionPixelSize(14, 0);
        B b4 = B.b(context2, typedArrayE, 19);
        n nVarC = b4 != null ? b4.c() : n.b(context2, attributeSet, com.stepos.alphame.R.attr.materialButtonStyle, com.stepos.alphame.R.style.Widget_MaterialComponents_Button).a();
        boolean z4 = typedArrayE.getBoolean(17, false);
        e eVar = new e(this, nVarC);
        this.f10476d = eVar;
        eVar.f10523f = typedArrayE.getDimensionPixelOffset(2, 0);
        eVar.f10524g = typedArrayE.getDimensionPixelOffset(3, 0);
        eVar.f10525h = typedArrayE.getDimensionPixelOffset(4, 0);
        eVar.f10526i = typedArrayE.getDimensionPixelOffset(5, 0);
        if (typedArrayE.hasValue(9)) {
            int dimensionPixelSize = typedArrayE.getDimensionPixelSize(9, -1);
            eVar.f10527j = dimensionPixelSize;
            y1.m mVarF = eVar.f10519b.f();
            mVarF.c(dimensionPixelSize);
            eVar.f10519b = mVarF.a();
            eVar.f10520c = null;
            eVar.d();
            eVar.f10536s = true;
        }
        eVar.f10528k = typedArrayE.getDimensionPixelSize(22, 0);
        eVar.f10529l = J.D(typedArrayE.getInt(8, -1), mode);
        eVar.f10530m = f.y(getContext(), typedArrayE, 7);
        eVar.f10531n = f.y(getContext(), typedArrayE, 21);
        eVar.f10532o = f.y(getContext(), typedArrayE, 18);
        eVar.f10537t = typedArrayE.getBoolean(6, false);
        eVar.f10540w = typedArrayE.getDimensionPixelSize(10, 0);
        eVar.f10538u = typedArrayE.getBoolean(23, true);
        int paddingStart = getPaddingStart();
        int paddingTop = getPaddingTop();
        int paddingEnd = getPaddingEnd();
        int paddingBottom = getPaddingBottom();
        if (typedArrayE.hasValue(0)) {
            eVar.f10535r = true;
            setSupportBackgroundTintList(eVar.f10530m);
            setSupportBackgroundTintMode(eVar.f10529l);
        } else {
            eVar.c();
        }
        setPaddingRelative(paddingStart + eVar.f10523f, paddingTop + eVar.f10525h, paddingEnd + eVar.f10524g, paddingBottom + eVar.f10526i);
        setCheckedInternal(typedArrayE.getBoolean(1, false));
        if (b4 != null) {
            eVar.f10521d = d();
            if (eVar.f10520c != null) {
                eVar.d();
            }
            eVar.f10520c = b4;
            eVar.d();
        }
        setOpticalCenterEnabled(z4);
        typedArrayE.recycle();
        setCompoundDrawablePadding(this.f10486n);
        i(this.f10481i != null);
    }

    public static /* synthetic */ void a(MaterialButton materialButton) {
        materialButton.f10496x = materialButton.getOpticalCenterShift();
        materialButton.k();
        materialButton.invalidate();
    }

    private Layout.Alignment getActualTextAlignment() {
        int textAlignment = getTextAlignment();
        return textAlignment != 1 ? (textAlignment == 6 || textAlignment == 3) ? Layout.Alignment.ALIGN_OPPOSITE : textAlignment != 4 ? Layout.Alignment.ALIGN_NORMAL : Layout.Alignment.ALIGN_CENTER : getGravityTextAlignment();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public float getDisplayedWidthIncrease() {
        return this.f10473C;
    }

    private Layout.Alignment getGravityTextAlignment() {
        int gravity = getGravity() & 8388615;
        return gravity != 1 ? (gravity == 5 || gravity == 8388613) ? Layout.Alignment.ALIGN_OPPOSITE : Layout.Alignment.ALIGN_NORMAL : Layout.Alignment.ALIGN_CENTER;
    }

    private int getOpticalCenterShift() {
        j jVarA;
        if (this.f10495w && this.f10497y && (jVarA = this.f10476d.a(false)) != null) {
            return (int) (jVarA.i() * 0.11f);
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
        float fMax = Property.DEFAULT_FLOAT_VALUE;
        for (int i4 = 0; i4 < lineCount; i4++) {
            fMax = Math.max(fMax, getLayout().getLineWidth(i4));
        }
        return (int) Math.ceil(fMax);
    }

    private void setCheckedInternal(boolean z4) {
        if (!e() || this.f10487o == z4) {
            return;
        }
        this.f10487o = z4;
        refreshDrawableState();
        if (getParent() instanceof MaterialButtonToggleGroup) {
            MaterialButtonToggleGroup materialButtonToggleGroup = (MaterialButtonToggleGroup) getParent();
            boolean z5 = this.f10487o;
            if (!materialButtonToggleGroup.f10502l) {
                materialButtonToggleGroup.f(getId(), z5);
            }
        }
        if (this.f10488p) {
            return;
        }
        this.f10488p = true;
        Iterator it = this.f10477e.iterator();
        if (it.hasNext()) {
            g.y(it.next());
            throw null;
        }
        this.f10488p = false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setDisplayedWidthIncrease(float f4) {
        MaterialButton materialButton;
        MaterialButton materialButton2;
        if (this.f10473C != f4) {
            this.f10473C = f4;
            k();
            invalidate();
            if (getParent() instanceof d) {
                d dVar = (d) getParent();
                int i4 = (int) this.f10473C;
                int iIndexOfChild = dVar.indexOfChild(this);
                if (iIndexOfChild < 0) {
                    return;
                }
                int i5 = iIndexOfChild - 1;
                while (true) {
                    materialButton = null;
                    if (i5 < 0) {
                        materialButton2 = null;
                        break;
                    } else {
                        if (dVar.c(i5)) {
                            materialButton2 = (MaterialButton) dVar.getChildAt(i5);
                            break;
                        }
                        i5--;
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
                    materialButton.setDisplayedWidthDecrease(i4);
                }
                if (materialButton == null) {
                    materialButton2.setDisplayedWidthDecrease(i4);
                }
                if (materialButton2 == null || materialButton == null) {
                    return;
                }
                materialButton2.setDisplayedWidthDecrease(i4 / 2);
                materialButton.setDisplayedWidthDecrease((i4 + 1) / 2);
            }
        }
    }

    public final W.n d() {
        Context context = getContext();
        TypedValue typedValueV = AbstractC0557a.V(com.stepos.alphame.R.attr.motionSpringFastSpatial, context);
        int[] iArr = AbstractC0769a.f13557w;
        TypedArray typedArrayObtainStyledAttributes = typedValueV == null ? context.obtainStyledAttributes(null, iArr, 0, com.stepos.alphame.R.style.Motion_Material3_Spring_Standard_Fast_Spatial) : context.obtainStyledAttributes(typedValueV.resourceId, iArr);
        W.n nVar = new W.n();
        try {
            float f4 = typedArrayObtainStyledAttributes.getFloat(1, Float.MIN_VALUE);
            if (f4 == Float.MIN_VALUE) {
                throw new IllegalArgumentException("A MaterialSpring style must have stiffness value.");
            }
            float f5 = typedArrayObtainStyledAttributes.getFloat(0, Float.MIN_VALUE);
            if (f5 == Float.MIN_VALUE) {
                throw new IllegalArgumentException("A MaterialSpring style must have a damping value.");
            }
            nVar.b(f4);
            nVar.a(f5);
            return nVar;
        } finally {
            typedArrayObtainStyledAttributes.recycle();
        }
    }

    public final boolean e() {
        e eVar = this.f10476d;
        return eVar != null && eVar.f10537t;
    }

    public final boolean f() {
        e eVar = this.f10476d;
        return (eVar == null || eVar.f10535r) ? false : true;
    }

    /* JADX WARN: Removed duplicated region for block: B:39:0x007e  */
    /* JADX WARN: Removed duplicated region for block: B:40:0x0081  */
    /* JADX WARN: Removed duplicated region for block: B:45:0x0096  */
    /* JADX WARN: Removed duplicated region for block: B:52:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void g(boolean r9) {
        /*
            r8 = this;
            y1.D r0 = r8.f10471A
            if (r0 != 0) goto L5
            return
        L5:
            W.m r0 = r8.f10475E
            if (r0 != 0) goto L18
            W.m r0 = new W.m
            K0.a r1 = com.google.android.material.button.MaterialButton.f10470H
            r0.<init>(r8, r1)
            r8.f10475E = r0
            W.n r1 = r8.d()
            r0.f1974m = r1
        L18:
            boolean r0 = r8.f10497y
            if (r0 == 0) goto L9b
            int r0 = r8.f10472B
            y1.D r1 = r8.f10471A
            int[] r2 = r8.getDrawableState()
            int[][] r3 = r1.f16194c
            r4 = 0
            r5 = r4
        L28:
            int r6 = r1.f16192a
            r7 = -1
            if (r5 >= r6) goto L39
            r6 = r3[r5]
            boolean r6 = android.util.StateSet.stateSetMatches(r6, r2)
            if (r6 == 0) goto L36
            goto L3a
        L36:
            int r5 = r5 + 1
            goto L28
        L39:
            r5 = r7
        L3a:
            if (r5 >= 0) goto L53
            int[] r2 = android.util.StateSet.WILD_CARD
            int[][] r3 = r1.f16194c
            r5 = r4
        L41:
            int r6 = r1.f16192a
            if (r5 >= r6) goto L52
            r6 = r3[r5]
            boolean r6 = android.util.StateSet.stateSetMatches(r6, r2)
            if (r6 == 0) goto L4f
            r7 = r5
            goto L52
        L4f:
            int r5 = r5 + 1
            goto L41
        L52:
            r5 = r7
        L53:
            if (r5 >= 0) goto L58
            com.google.android.gms.common.api.internal.p r1 = r1.f16193b
            goto L5c
        L58:
            com.google.android.gms.common.api.internal.p[] r1 = r1.f16195d
            r1 = r1[r5]
        L5c:
            java.lang.Object r1 = r1.f9664b
            y1.C r1 = (y1.C) r1
            int r2 = r8.getWidth()
            float r3 = r1.f16191b
            int r1 = r1.f16190a
            r5 = 1
            if (r1 != r5) goto L6f
            float r1 = (float) r2
            float r3 = r3 * r1
        L6d:
            int r4 = (int) r3
            goto L73
        L6f:
            r2 = 2
            if (r1 != r2) goto L73
            goto L6d
        L73:
            int r0 = java.lang.Math.min(r0, r4)
            W.m r1 = r8.f10475E
            float r0 = (float) r0
            boolean r2 = r1.f1967f
            if (r2 == 0) goto L81
            r1.f1975n = r0
            goto L94
        L81:
            W.n r2 = r1.f1974m
            if (r2 != 0) goto L8c
            W.n r2 = new W.n
            r2.<init>(r0)
            r1.f1974m = r2
        L8c:
            W.n r2 = r1.f1974m
            double r3 = (double) r0
            r2.f1985i = r3
            r1.i()
        L94:
            if (r9 == 0) goto L9b
            W.m r8 = r8.f10475E
            r8.h()
        L9b:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.material.button.MaterialButton.g(boolean):void");
    }

    @NonNull
    @SuppressLint({"KotlinPropertyAccess"})
    public String getA11yClassName() {
        if (TextUtils.isEmpty(this.f10482j)) {
            return (e() ? CompoundButton.class : Button.class).getName();
        }
        return this.f10482j;
    }

    @Px
    public int getAllowedWidthDecrease() {
        return this.f10498z;
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
        if (f()) {
            return this.f10476d.f10527j;
        }
        return 0;
    }

    @Nullable
    @RestrictTo({EnumC0546d.f12493b})
    public W.n getCornerSpringForce() {
        return this.f10476d.f10521d;
    }

    public Drawable getIcon() {
        return this.f10481i;
    }

    public int getIconGravity() {
        return this.f10489q;
    }

    @Px
    public int getIconPadding() {
        return this.f10486n;
    }

    @Px
    public int getIconSize() {
        return this.f10483k;
    }

    public ColorStateList getIconTint() {
        return this.f10480h;
    }

    public PorterDuff.Mode getIconTintMode() {
        return this.f10479g;
    }

    @Dimension
    public int getInsetBottom() {
        return this.f10476d.f10526i;
    }

    @Dimension
    public int getInsetTop() {
        return this.f10476d.f10525h;
    }

    @Nullable
    public ColorStateList getRippleColor() {
        if (f()) {
            return this.f10476d.f10532o;
        }
        return null;
    }

    @NonNull
    public n getShapeAppearanceModel() {
        if (f()) {
            return this.f10476d.f10519b;
        }
        throw new IllegalStateException("Attempted to get ShapeAppearanceModel from a MaterialButton which has an overwritten background.");
    }

    @Nullable
    @RestrictTo({EnumC0546d.f12493b})
    public B getStateListShapeAppearanceModel() {
        if (f()) {
            return this.f10476d.f10520c;
        }
        throw new IllegalStateException("Attempted to get StateListShapeAppearanceModel from a MaterialButton which has an overwritten background.");
    }

    public ColorStateList getStrokeColor() {
        if (f()) {
            return this.f10476d.f10531n;
        }
        return null;
    }

    @Px
    public int getStrokeWidth() {
        if (f()) {
            return this.f10476d.f10528k;
        }
        return 0;
    }

    @Override // androidx.appcompat.widget.C0230v
    @Nullable
    @RestrictTo({EnumC0546d.f12493b})
    public ColorStateList getSupportBackgroundTintList() {
        return f() ? this.f10476d.f10530m : super.getSupportBackgroundTintList();
    }

    @Override // androidx.appcompat.widget.C0230v
    @Nullable
    @RestrictTo({EnumC0546d.f12493b})
    public PorterDuff.Mode getSupportBackgroundTintMode() {
        return f() ? this.f10476d.f10529l : super.getSupportBackgroundTintMode();
    }

    public final void h() {
        int i4 = this.f10489q;
        boolean z4 = true;
        if (i4 != 1 && i4 != 2) {
            z4 = false;
        }
        if (z4) {
            setCompoundDrawablesRelative(this.f10481i, null, null, null);
            return;
        }
        if (i4 == 3 || i4 == 4) {
            setCompoundDrawablesRelative(null, null, this.f10481i, null);
        } else if (i4 == 16 || i4 == 32) {
            setCompoundDrawablesRelative(null, this.f10481i, null, null);
        }
    }

    public final void i(boolean z4) {
        Drawable drawable = this.f10481i;
        if (drawable != null) {
            Drawable drawableMutate = drawable.mutate();
            this.f10481i = drawableMutate;
            drawableMutate.setTintList(this.f10480h);
            PorterDuff.Mode mode = this.f10479g;
            if (mode != null) {
                this.f10481i.setTintMode(mode);
            }
            int intrinsicWidth = this.f10483k;
            if (intrinsicWidth == 0) {
                intrinsicWidth = this.f10481i.getIntrinsicWidth();
            }
            int intrinsicHeight = this.f10483k;
            if (intrinsicHeight == 0) {
                intrinsicHeight = this.f10481i.getIntrinsicHeight();
            }
            Drawable drawable2 = this.f10481i;
            int i4 = this.f10484l;
            int i5 = this.f10485m;
            drawable2.setBounds(i4, i5, intrinsicWidth + i4, intrinsicHeight + i5);
            this.f10481i.setVisible(true, z4);
        }
        if (z4) {
            h();
            return;
        }
        Drawable[] compoundDrawablesRelative = getCompoundDrawablesRelative();
        Drawable drawable3 = compoundDrawablesRelative[0];
        Drawable drawable4 = compoundDrawablesRelative[1];
        Drawable drawable5 = compoundDrawablesRelative[2];
        int i6 = this.f10489q;
        if (((i6 == 1 || i6 == 2) && drawable3 != this.f10481i) || (((i6 == 3 || i6 == 4) && drawable5 != this.f10481i) || ((i6 == 16 || i6 == 32) && drawable4 != this.f10481i))) {
            h();
        }
    }

    @Override // android.widget.Checkable
    public final boolean isChecked() {
        return this.f10487o;
    }

    public final void j(int i4, int i5) {
        if (this.f10481i == null || getLayout() == null) {
            return;
        }
        int i6 = this.f10489q;
        if (!(i6 == 1 || i6 == 2) && i6 != 3 && i6 != 4) {
            if (i6 == 16 || i6 == 32) {
                this.f10484l = 0;
                if (i6 == 16) {
                    this.f10485m = 0;
                    i(false);
                    return;
                }
                int intrinsicHeight = this.f10483k;
                if (intrinsicHeight == 0) {
                    intrinsicHeight = this.f10481i.getIntrinsicHeight();
                }
                int iMax = Math.max(0, (((((i5 - getTextHeight()) - getPaddingTop()) - intrinsicHeight) - this.f10486n) - getPaddingBottom()) / 2);
                if (this.f10485m != iMax) {
                    this.f10485m = iMax;
                    i(false);
                    return;
                }
                return;
            }
            return;
        }
        this.f10485m = 0;
        Layout.Alignment actualTextAlignment = getActualTextAlignment();
        int i7 = this.f10489q;
        if (i7 == 1 || i7 == 3 || ((i7 == 2 && actualTextAlignment == Layout.Alignment.ALIGN_NORMAL) || (i7 == 4 && actualTextAlignment == Layout.Alignment.ALIGN_OPPOSITE))) {
            this.f10484l = 0;
            i(false);
            return;
        }
        int intrinsicWidth = this.f10483k;
        if (intrinsicWidth == 0) {
            intrinsicWidth = this.f10481i.getIntrinsicWidth();
        }
        int textLayoutWidth = ((((i4 - getTextLayoutWidth()) - getPaddingEnd()) - intrinsicWidth) - this.f10486n) - getPaddingStart();
        if (actualTextAlignment == Layout.Alignment.ALIGN_CENTER) {
            textLayoutWidth /= 2;
        }
        if ((getLayoutDirection() == 1) != (this.f10489q == 4)) {
            textLayoutWidth = -textLayoutWidth;
        }
        if (this.f10484l != textLayoutWidth) {
            this.f10484l = textLayoutWidth;
            i(false);
        }
    }

    public final void k() {
        int i4 = (int) (this.f10473C - this.f10474D);
        int i5 = (i4 / 2) + this.f10496x;
        getLayoutParams().width = (int) (this.f10491s + i4);
        setPaddingRelative(this.f10492t + i5, getPaddingTop(), (this.f10493u + i4) - i5, getPaddingBottom());
    }

    @Override // android.widget.TextView, android.view.View
    public final void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (f()) {
            f.x0(this, this.f10476d.a(false));
        }
    }

    @Override // android.widget.TextView, android.view.View
    public final int[] onCreateDrawableState(int i4) {
        int[] iArrOnCreateDrawableState = super.onCreateDrawableState(i4 + 2);
        if (e()) {
            View.mergeDrawableStates(iArrOnCreateDrawableState, f10468F);
        }
        if (this.f10487o) {
            View.mergeDrawableStates(iArrOnCreateDrawableState, f10469G);
        }
        return iArrOnCreateDrawableState;
    }

    @Override // androidx.appcompat.widget.C0230v, android.view.View
    public final void onInitializeAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        super.onInitializeAccessibilityEvent(accessibilityEvent);
        accessibilityEvent.setClassName(getA11yClassName());
        accessibilityEvent.setChecked(this.f10487o);
    }

    @Override // androidx.appcompat.widget.C0230v, android.view.View
    public final void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo accessibilityNodeInfo) {
        super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
        accessibilityNodeInfo.setClassName(getA11yClassName());
        accessibilityNodeInfo.setCheckable(e());
        accessibilityNodeInfo.setChecked(this.f10487o);
        accessibilityNodeInfo.setClickable(isClickable());
    }

    @Override // androidx.appcompat.widget.C0230v, android.widget.TextView, android.view.View
    public final void onLayout(boolean z4, int i4, int i5, int i6, int i7) {
        int i8;
        super.onLayout(z4, i4, i5, i6, i7);
        j(getMeasuredWidth(), getMeasuredHeight());
        int i9 = getResources().getConfiguration().orientation;
        if (this.f10490r != i9) {
            this.f10490r = i9;
            this.f10491s = -1.0f;
        }
        if (this.f10491s == -1.0f) {
            this.f10491s = getMeasuredWidth();
            if (this.f10494v == null && (getParent() instanceof d) && ((d) getParent()).getButtonSizeChange() != null) {
                this.f10494v = (LinearLayout.LayoutParams) getLayoutParams();
                LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(this.f10494v);
                layoutParams.width = (int) this.f10491s;
                setLayoutParams(layoutParams);
            }
        }
        boolean z5 = false;
        if (this.f10498z == -1) {
            if (this.f10481i == null) {
                i8 = 0;
            } else {
                int iconPadding = getIconPadding();
                int intrinsicWidth = this.f10483k;
                if (intrinsicWidth == 0) {
                    intrinsicWidth = this.f10481i.getIntrinsicWidth();
                }
                i8 = iconPadding + intrinsicWidth;
            }
            this.f10498z = (getMeasuredWidth() - getTextLayoutWidth()) - i8;
        }
        if (this.f10492t == -1) {
            this.f10492t = getPaddingStart();
        }
        if (this.f10493u == -1) {
            this.f10493u = getPaddingEnd();
        }
        if ((getParent() instanceof d) && ((d) getParent()).getOrientation() == 0) {
            z5 = true;
        }
        this.f10497y = z5;
    }

    @Override // android.widget.TextView, android.view.View
    public final void onRestoreInstanceState(Parcelable parcelable) {
        if (!(parcelable instanceof SavedState)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        SavedState savedState = (SavedState) parcelable;
        super.onRestoreInstanceState(savedState.getSuperState());
        setChecked(savedState.f10499a);
    }

    @Override // android.widget.TextView, android.view.View
    public final Parcelable onSaveInstanceState() {
        SavedState savedState = new SavedState(super.onSaveInstanceState());
        savedState.f10499a = this.f10487o;
        return savedState;
    }

    @Override // androidx.appcompat.widget.C0230v, android.widget.TextView
    public final void onTextChanged(CharSequence charSequence, int i4, int i5, int i6) {
        super.onTextChanged(charSequence, i4, i5, i6);
        j(getMeasuredWidth(), getMeasuredHeight());
    }

    @Override // android.view.View
    public final boolean performClick() {
        if (isEnabled() && this.f10476d.f10538u) {
            toggle();
        }
        return super.performClick();
    }

    @Override // android.view.View
    public final void refreshDrawableState() {
        super.refreshDrawableState();
        if (this.f10481i != null) {
            if (this.f10481i.setState(getDrawableState())) {
                invalidate();
            }
        }
    }

    @RestrictTo({EnumC0546d.f12493b})
    public void setA11yClassName(@Nullable String str) {
        this.f10482j = str;
    }

    @Override // android.view.View
    public void setBackground(@NonNull Drawable drawable) {
        setBackgroundDrawable(drawable);
    }

    @Override // android.view.View
    public void setBackgroundColor(@ColorInt int i4) {
        if (!f()) {
            super.setBackgroundColor(i4);
            return;
        }
        e eVar = this.f10476d;
        if (eVar.a(false) != null) {
            eVar.a(false).setTint(i4);
        }
    }

    @Override // androidx.appcompat.widget.C0230v, android.view.View
    public void setBackgroundDrawable(@NonNull Drawable drawable) {
        if (!f()) {
            super.setBackgroundDrawable(drawable);
            return;
        }
        if (drawable == getBackground()) {
            getBackground().setState(drawable.getState());
            return;
        }
        Log.w("MaterialButton", "MaterialButton manages its own background to control elevation, shape, color and states. Consider using backgroundTint, shapeAppearance and other attributes where available. A custom background will ignore these attributes and you should consider handling interaction states such as pressed, focused and disabled");
        e eVar = this.f10476d;
        eVar.f10535r = true;
        ColorStateList colorStateList = eVar.f10530m;
        MaterialButton materialButton = eVar.f10518a;
        materialButton.setSupportBackgroundTintList(colorStateList);
        materialButton.setSupportBackgroundTintMode(eVar.f10529l);
        super.setBackgroundDrawable(drawable);
    }

    @Override // androidx.appcompat.widget.C0230v, android.view.View
    public void setBackgroundResource(@DrawableRes int i4) {
        setBackgroundDrawable(i4 != 0 ? I.o(getContext(), i4) : null);
    }

    @Override // android.view.View
    public void setBackgroundTintList(@Nullable ColorStateList colorStateList) {
        setSupportBackgroundTintList(colorStateList);
    }

    @Override // android.view.View
    public void setBackgroundTintMode(@Nullable PorterDuff.Mode mode) {
        setSupportBackgroundTintMode(mode);
    }

    public void setCheckable(boolean z4) {
        if (f()) {
            this.f10476d.f10537t = z4;
        }
    }

    @Override // android.widget.Checkable
    public void setChecked(boolean z4) {
        setCheckedInternal(z4);
    }

    public void setCornerRadius(@Px int i4) {
        if (f()) {
            e eVar = this.f10476d;
            if (eVar.f10536s && eVar.f10527j == i4) {
                return;
            }
            eVar.f10527j = i4;
            eVar.f10536s = true;
            y1.m mVarF = eVar.f10519b.f();
            mVarF.c(i4);
            eVar.f10519b = mVarF.a();
            eVar.f10520c = null;
            eVar.d();
        }
    }

    public void setCornerRadiusResource(@DimenRes int i4) {
        if (f()) {
            setCornerRadius(getResources().getDimensionPixelSize(i4));
        }
    }

    @RestrictTo({EnumC0546d.f12493b})
    public void setCornerSpringForce(@NonNull W.n nVar) {
        e eVar = this.f10476d;
        eVar.f10521d = nVar;
        if (eVar.f10520c != null) {
            eVar.d();
        }
    }

    public void setDisplayedWidthDecrease(int i4) {
        this.f10474D = Math.min(i4, this.f10498z);
        k();
        invalidate();
    }

    @Override // android.view.View
    public void setElevation(float f4) {
        super.setElevation(f4);
        if (f()) {
            this.f10476d.a(false).n(f4);
        }
    }

    public void setIcon(@Nullable Drawable drawable) {
        if (this.f10481i != drawable) {
            this.f10481i = drawable;
            i(true);
            j(getMeasuredWidth(), getMeasuredHeight());
        }
    }

    public void setIconGravity(int i4) {
        if (this.f10489q != i4) {
            this.f10489q = i4;
            j(getMeasuredWidth(), getMeasuredHeight());
        }
    }

    public void setIconPadding(@Px int i4) {
        if (this.f10486n != i4) {
            this.f10486n = i4;
            setCompoundDrawablePadding(i4);
        }
    }

    public void setIconResource(@DrawableRes int i4) {
        setIcon(i4 != 0 ? I.o(getContext(), i4) : null);
    }

    public void setIconSize(@Px int i4) {
        if (i4 < 0) {
            throw new IllegalArgumentException("iconSize cannot be less than 0");
        }
        if (this.f10483k != i4) {
            this.f10483k = i4;
            i(true);
        }
    }

    public void setIconTint(@Nullable ColorStateList colorStateList) {
        if (this.f10480h != colorStateList) {
            this.f10480h = colorStateList;
            i(false);
        }
    }

    public void setIconTintMode(PorterDuff.Mode mode) {
        if (this.f10479g != mode) {
            this.f10479g = mode;
            i(false);
        }
    }

    public void setIconTintResource(@ColorRes int i4) {
        setIconTint(f.x(i4, getContext()));
    }

    public void setInsetBottom(@Dimension int i4) {
        e eVar = this.f10476d;
        eVar.b(eVar.f10525h, i4);
    }

    public void setInsetTop(@Dimension int i4) {
        e eVar = this.f10476d;
        eVar.b(i4, eVar.f10526i);
    }

    public void setInternalBackground(Drawable drawable) {
        super.setBackgroundDrawable(drawable);
    }

    public void setOnPressedChangeListenerInternal(@Nullable a aVar) {
        this.f10478f = aVar;
    }

    public void setOpticalCenterEnabled(boolean z4) {
        if (this.f10495w != z4) {
            this.f10495w = z4;
            e eVar = this.f10476d;
            if (z4) {
                androidx.core.app.f fVar = new androidx.core.app.f(this);
                eVar.f10522e = fVar;
                j jVarA = eVar.a(false);
                if (jVarA != null) {
                    jVarA.f16232E = fVar;
                }
            } else {
                eVar.f10522e = null;
                j jVarA2 = eVar.a(false);
                if (jVarA2 != null) {
                    jVarA2.f16232E = null;
                }
            }
            post(new androidx.activity.d(11, this));
        }
    }

    @Override // android.view.View
    public void setPressed(boolean z4) {
        a aVar = this.f10478f;
        if (aVar != null) {
            ((d) ((p) aVar).f9664b).invalidate();
        }
        super.setPressed(z4);
        g(false);
    }

    public void setRippleColor(@Nullable ColorStateList colorStateList) {
        if (f()) {
            e eVar = this.f10476d;
            if (eVar.f10532o != colorStateList) {
                eVar.f10532o = colorStateList;
                MaterialButton materialButton = eVar.f10518a;
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

    public void setRippleColorResource(@ColorRes int i4) {
        if (f()) {
            setRippleColor(f.x(i4, getContext()));
        }
    }

    @Override // y1.y
    public void setShapeAppearanceModel(@NonNull n nVar) {
        if (!f()) {
            throw new IllegalStateException("Attempted to set ShapeAppearanceModel on a MaterialButton which has an overwritten background.");
        }
        e eVar = this.f10476d;
        eVar.f10519b = nVar;
        eVar.f10520c = null;
        eVar.d();
    }

    public void setShouldDrawSurfaceColorStroke(boolean z4) {
        if (f()) {
            e eVar = this.f10476d;
            eVar.f10534q = z4;
            eVar.e();
        }
    }

    public void setSizeChange(@NonNull D d4) {
        if (this.f10471A != d4) {
            this.f10471A = d4;
            g(true);
        }
    }

    @RestrictTo({EnumC0546d.f12493b})
    public void setStateListShapeAppearanceModel(@NonNull B b4) {
        if (!f()) {
            throw new IllegalStateException("Attempted to set StateListShapeAppearanceModel on a MaterialButton which has an overwritten background.");
        }
        e eVar = this.f10476d;
        if (eVar.f10521d == null && b4.d()) {
            eVar.f10521d = d();
            if (eVar.f10520c != null) {
                eVar.d();
            }
        }
        eVar.f10520c = b4;
        eVar.d();
    }

    public void setStrokeColor(@Nullable ColorStateList colorStateList) {
        if (f()) {
            e eVar = this.f10476d;
            if (eVar.f10531n != colorStateList) {
                eVar.f10531n = colorStateList;
                eVar.e();
            }
        }
    }

    public void setStrokeColorResource(@ColorRes int i4) {
        if (f()) {
            setStrokeColor(f.x(i4, getContext()));
        }
    }

    public void setStrokeWidth(@Px int i4) {
        if (f()) {
            e eVar = this.f10476d;
            if (eVar.f10528k != i4) {
                eVar.f10528k = i4;
                eVar.e();
            }
        }
    }

    public void setStrokeWidthResource(@DimenRes int i4) {
        if (f()) {
            setStrokeWidth(getResources().getDimensionPixelSize(i4));
        }
    }

    @Override // androidx.appcompat.widget.C0230v
    @RestrictTo({EnumC0546d.f12493b})
    public void setSupportBackgroundTintList(@Nullable ColorStateList colorStateList) {
        if (!f()) {
            super.setSupportBackgroundTintList(colorStateList);
            return;
        }
        e eVar = this.f10476d;
        if (eVar.f10530m != colorStateList) {
            eVar.f10530m = colorStateList;
            if (eVar.a(false) != null) {
                eVar.a(false).setTintList(eVar.f10530m);
            }
        }
    }

    @Override // androidx.appcompat.widget.C0230v
    @RestrictTo({EnumC0546d.f12493b})
    public void setSupportBackgroundTintMode(@Nullable PorterDuff.Mode mode) {
        if (!f()) {
            super.setSupportBackgroundTintMode(mode);
            return;
        }
        e eVar = this.f10476d;
        if (eVar.f10529l != mode) {
            eVar.f10529l = mode;
            if (eVar.a(false) == null || eVar.f10529l == null) {
                return;
            }
            eVar.a(false).setTintMode(eVar.f10529l);
        }
    }

    @Override // android.view.View
    public void setTextAlignment(int i4) {
        super.setTextAlignment(i4);
        j(getMeasuredWidth(), getMeasuredHeight());
    }

    public void setToggleCheckedStateOnClick(boolean z4) {
        this.f10476d.f10538u = z4;
    }

    @Override // android.widget.TextView
    public void setWidth(@Px int i4) {
        this.f10491s = -1.0f;
        super.setWidth(i4);
    }

    public void setWidthChangeMax(@Px int i4) {
        if (this.f10472B != i4) {
            this.f10472B = i4;
            g(true);
        }
    }

    @Override // android.widget.Checkable
    public final void toggle() {
        setChecked(!this.f10487o);
    }
}
