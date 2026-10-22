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
import androidx.emoji2.text.t;
import b8.h;
import g.o;
import j1.b;
import j1.c;
import j1.d;
import j1.f;
import j1.g;
import java.util.Iterator;
import java.util.LinkedHashSet;
import k4.v;
import n0.e;
import p1.k;
import t1.b0;
import t1.j;
import t1.m;
import t1.n;
import t1.x;
import t1.z;
import x1.a;

/* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
/* loaded from: classes.dex */
public class MaterialButton extends o implements Checkable, x {
    public static final int[] G = {R.attr.state_checkable};
    public static final int[] H = {R.attr.state_checked};
    public static final b I = new b();
    public int A;
    public b0 B;
    public int C;
    public float D;
    public float E;
    public e F;
    public final g d;

    /* renamed from: e, reason: collision with root package name */
    public final LinkedHashSet f1261e;

    /* renamed from: f, reason: collision with root package name */
    public c f1262f;

    /* renamed from: g, reason: collision with root package name */
    public PorterDuff.Mode f1263g;

    /* renamed from: h, reason: collision with root package name */
    public ColorStateList f1264h;

    /* renamed from: j, reason: collision with root package name */
    public Drawable f1265j;

    /* renamed from: k, reason: collision with root package name */
    public String f1266k;

    /* renamed from: l, reason: collision with root package name */
    public int f1267l;

    /* renamed from: m, reason: collision with root package name */
    public int f1268m;

    /* renamed from: n, reason: collision with root package name */
    public int f1269n;

    /* renamed from: o, reason: collision with root package name */
    public int f1270o;

    /* renamed from: p, reason: collision with root package name */
    public boolean f1271p;

    /* renamed from: q, reason: collision with root package name */
    public boolean f1272q;

    /* renamed from: r, reason: collision with root package name */
    public int f1273r;

    /* renamed from: s, reason: collision with root package name */
    public int f1274s;

    /* renamed from: t, reason: collision with root package name */
    public float f1275t;

    /* renamed from: u, reason: collision with root package name */
    public int f1276u;

    /* renamed from: v, reason: collision with root package name */
    public int f1277v;

    /* renamed from: w, reason: collision with root package name */
    public LinearLayout.LayoutParams f1278w;

    /* renamed from: x, reason: collision with root package name */
    public boolean f1279x;
    public int y;
    public boolean z;

    public MaterialButton(Context context, AttributeSet attributeSet) {
        super(a.b(context, attributeSet, com.stepos.stepclaw.R.attr.materialButtonStyle, com.stepos.stepclaw.R.style.Widget_MaterialComponents_Button, new int[]{com.stepos.stepclaw.R.attr.materialSizeOverlay}), attributeSet);
        this.f1261e = new LinkedHashSet();
        this.f1271p = false;
        this.f1272q = false;
        this.f1274s = -1;
        this.f1275t = -1.0f;
        this.f1276u = -1;
        this.f1277v = -1;
        this.A = -1;
        Context context2 = getContext();
        TypedArray typedArrayE = k.e(context2, attributeSet, d1.a.f1767i, com.stepos.stepclaw.R.attr.materialButtonStyle, com.stepos.stepclaw.R.style.Widget_MaterialComponents_Button, new int[0]);
        this.f1270o = typedArrayE.getDimensionPixelSize(13, 0);
        int i8 = typedArrayE.getInt(16, -1);
        PorterDuff.Mode mode = PorterDuff.Mode.SRC_IN;
        this.f1263g = k.f(i8, mode);
        this.f1264h = v.D(getContext(), typedArrayE, 15);
        this.f1265j = v.F(getContext(), typedArrayE, 11);
        this.f1273r = typedArrayE.getInteger(12, 1);
        this.f1267l = typedArrayE.getDimensionPixelSize(14, 0);
        z zVarB = z.b(context2, typedArrayE, 19);
        n nVarC = zVarB != null ? zVarB.c() : n.b(context2, attributeSet, com.stepos.stepclaw.R.attr.materialButtonStyle, com.stepos.stepclaw.R.style.Widget_MaterialComponents_Button).a();
        boolean z = typedArrayE.getBoolean(17, false);
        g gVar = new g(this, nVarC);
        this.d = gVar;
        gVar.f3489f = typedArrayE.getDimensionPixelOffset(2, 0);
        gVar.f3490g = typedArrayE.getDimensionPixelOffset(3, 0);
        gVar.f3491h = typedArrayE.getDimensionPixelOffset(4, 0);
        gVar.f3492i = typedArrayE.getDimensionPixelOffset(5, 0);
        if (typedArrayE.hasValue(9)) {
            int dimensionPixelSize = typedArrayE.getDimensionPixelSize(9, -1);
            gVar.f3493j = dimensionPixelSize;
            float f3 = dimensionPixelSize;
            m mVarF = gVar.f3486b.f();
            mVarF.f5500e = new t1.a(f3);
            mVarF.f5501f = new t1.a(f3);
            mVarF.f5502g = new t1.a(f3);
            mVarF.f5503h = new t1.a(f3);
            gVar.f3486b = mVarF.a();
            gVar.f3487c = null;
            gVar.d();
            gVar.f3502s = true;
        }
        gVar.f3494k = typedArrayE.getDimensionPixelSize(22, 0);
        gVar.f3495l = k.f(typedArrayE.getInt(8, -1), mode);
        gVar.f3496m = v.D(getContext(), typedArrayE, 7);
        gVar.f3497n = v.D(getContext(), typedArrayE, 21);
        gVar.f3498o = v.D(getContext(), typedArrayE, 18);
        gVar.f3503t = typedArrayE.getBoolean(6, false);
        gVar.f3506w = typedArrayE.getDimensionPixelSize(10, 0);
        gVar.f3504u = typedArrayE.getBoolean(23, true);
        int paddingStart = getPaddingStart();
        int paddingTop = getPaddingTop();
        int paddingEnd = getPaddingEnd();
        int paddingBottom = getPaddingBottom();
        if (typedArrayE.hasValue(0)) {
            gVar.f3501r = true;
            setSupportBackgroundTintList(gVar.f3496m);
            setSupportBackgroundTintMode(gVar.f3495l);
        } else {
            gVar.c();
        }
        setPaddingRelative(paddingStart + gVar.f3489f, paddingTop + gVar.f3491h, paddingEnd + gVar.f3490g, paddingBottom + gVar.f3492i);
        setCheckedInternal(typedArrayE.getBoolean(1, false));
        if (zVarB != null) {
            gVar.d = d();
            if (gVar.f3487c != null) {
                gVar.d();
            }
            gVar.f3487c = zVarB;
            gVar.d();
        }
        setOpticalCenterEnabled(z);
        typedArrayE.recycle();
        setCompoundDrawablePadding(this.f1270o);
        h(this.f1265j != null);
    }

    public static /* synthetic */ void a(MaterialButton materialButton) {
        materialButton.y = materialButton.getOpticalCenterShift();
        materialButton.j();
        materialButton.invalidate();
    }

    private Layout.Alignment getActualTextAlignment() {
        int textAlignment = getTextAlignment();
        return textAlignment != 1 ? (textAlignment == 6 || textAlignment == 3) ? Layout.Alignment.ALIGN_OPPOSITE : textAlignment != 4 ? Layout.Alignment.ALIGN_NORMAL : Layout.Alignment.ALIGN_CENTER : getGravityTextAlignment();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public float getDisplayedWidthIncrease() {
        return this.D;
    }

    private Layout.Alignment getGravityTextAlignment() {
        int gravity = getGravity() & 8388615;
        return gravity != 1 ? (gravity == 5 || gravity == 8388613) ? Layout.Alignment.ALIGN_OPPOSITE : Layout.Alignment.ALIGN_NORMAL : Layout.Alignment.ALIGN_CENTER;
    }

    private int getOpticalCenterShift() {
        j jVarA;
        if (this.f1279x && this.z && (jVarA = this.d.a(false)) != null) {
            return (int) (jVarA.g() * 0.11f);
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
        for (int i8 = 0; i8 < lineCount; i8++) {
            fMax = Math.max(fMax, getLayout().getLineWidth(i8));
        }
        return (int) Math.ceil(fMax);
    }

    private void setCheckedInternal(boolean z) {
        g gVar = this.d;
        if (gVar == null || !gVar.f3503t || this.f1271p == z) {
            return;
        }
        this.f1271p = z;
        refreshDrawableState();
        if (getParent() instanceof MaterialButtonToggleGroup) {
            MaterialButtonToggleGroup materialButtonToggleGroup = (MaterialButtonToggleGroup) getParent();
            boolean z2 = this.f1271p;
            if (!materialButtonToggleGroup.f1282m) {
                materialButtonToggleGroup.f(getId(), z2);
            }
        }
        if (this.f1272q) {
            return;
        }
        this.f1272q = true;
        Iterator it = this.f1261e.iterator();
        if (it.hasNext()) {
            it.next().getClass();
            throw new ClassCastException();
        }
        this.f1272q = false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setDisplayedWidthIncrease(float f3) {
        MaterialButton materialButton;
        MaterialButton materialButton2;
        if (this.D != f3) {
            this.D = f3;
            j();
            invalidate();
            if (getParent() instanceof f) {
                f fVar = (f) getParent();
                int i8 = (int) this.D;
                int iIndexOfChild = fVar.indexOfChild(this);
                if (iIndexOfChild < 0) {
                    return;
                }
                int i9 = iIndexOfChild - 1;
                while (true) {
                    materialButton = null;
                    if (i9 < 0) {
                        materialButton2 = null;
                        break;
                    } else {
                        if (fVar.c(i9)) {
                            materialButton2 = (MaterialButton) fVar.getChildAt(i9);
                            break;
                        }
                        i9--;
                    }
                }
                int childCount = fVar.getChildCount();
                while (true) {
                    iIndexOfChild++;
                    if (iIndexOfChild >= childCount) {
                        break;
                    } else if (fVar.c(iIndexOfChild)) {
                        materialButton = (MaterialButton) fVar.getChildAt(iIndexOfChild);
                        break;
                    }
                }
                if (materialButton2 == null && materialButton == null) {
                    return;
                }
                if (materialButton2 == null) {
                    materialButton.setDisplayedWidthDecrease(i8);
                }
                if (materialButton == null) {
                    materialButton2.setDisplayedWidthDecrease(i8);
                }
                if (materialButton2 == null || materialButton == null) {
                    return;
                }
                materialButton2.setDisplayedWidthDecrease(i8 / 2);
                materialButton.setDisplayedWidthDecrease((i8 + 1) / 2);
            }
        }
    }

    public final n0.f d() {
        Context context = getContext();
        TypedValue typedValueD = k4.z.D(context, com.stepos.stepclaw.R.attr.motionSpringFastSpatial);
        int[] iArr = d1.a.f1772n;
        TypedArray typedArrayObtainStyledAttributes = typedValueD == null ? context.obtainStyledAttributes(null, iArr, 0, com.stepos.stepclaw.R.style.Motion_Material3_Spring_Standard_Fast_Spatial) : context.obtainStyledAttributes(typedValueD.resourceId, iArr);
        n0.f fVar = new n0.f();
        try {
            float f3 = typedArrayObtainStyledAttributes.getFloat(1, Float.MIN_VALUE);
            if (f3 == Float.MIN_VALUE) {
                throw new IllegalArgumentException("A MaterialSpring style must have stiffness value.");
            }
            float f7 = typedArrayObtainStyledAttributes.getFloat(0, Float.MIN_VALUE);
            if (f7 == Float.MIN_VALUE) {
                throw new IllegalArgumentException("A MaterialSpring style must have a damping value.");
            }
            if (f3 <= 0.0f) {
                throw new IllegalArgumentException("Spring stiffness constant must be positive.");
            }
            fVar.f3965a = Math.sqrt(f3);
            fVar.f3967c = false;
            if (f7 < 0.0f) {
                throw new IllegalArgumentException("Damping ratio must be non-negative");
            }
            fVar.f3966b = f7;
            fVar.f3967c = false;
            typedArrayObtainStyledAttributes.recycle();
            return fVar;
        } catch (Throwable th) {
            typedArrayObtainStyledAttributes.recycle();
            throw th;
        }
    }

    public final boolean e() {
        g gVar = this.d;
        return (gVar == null || gVar.f3501r) ? false : true;
    }

    /* JADX WARN: Removed duplicated region for block: B:39:0x0080  */
    /* JADX WARN: Removed duplicated region for block: B:46:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void f(boolean r9) {
        /*
            r8 = this;
            t1.b0 r0 = r8.B
            if (r0 != 0) goto L6
            goto L85
        L6:
            n0.e r0 = r8.F
            if (r0 != 0) goto L19
            n0.e r0 = new n0.e
            j1.b r1 = com.google.android.material.button.MaterialButton.I
            r0.<init>(r8, r1)
            r8.F = r0
            n0.f r1 = r8.d()
            r0.f3962j = r1
        L19:
            boolean r0 = r8.z
            if (r0 == 0) goto L85
            int r0 = r8.C
            t1.b0 r1 = r8.B
            int[] r2 = r8.getDrawableState()
            int[][] r3 = r1.f5452c
            r4 = 0
            r5 = r4
        L29:
            int r6 = r1.f5450a
            r7 = -1
            if (r5 >= r6) goto L3a
            r6 = r3[r5]
            boolean r6 = android.util.StateSet.stateSetMatches(r6, r2)
            if (r6 == 0) goto L37
            goto L3b
        L37:
            int r5 = r5 + 1
            goto L29
        L3a:
            r5 = r7
        L3b:
            if (r5 >= 0) goto L54
            int[] r2 = android.util.StateSet.WILD_CARD
            int[][] r3 = r1.f5452c
            r5 = r4
        L42:
            int r6 = r1.f5450a
            if (r5 >= r6) goto L53
            r6 = r3[r5]
            boolean r6 = android.util.StateSet.stateSetMatches(r6, r2)
            if (r6 == 0) goto L50
            r7 = r5
            goto L53
        L50:
            int r5 = r5 + 1
            goto L42
        L53:
            r5 = r7
        L54:
            if (r5 >= 0) goto L59
            r6.x r1 = r1.f5451b
            goto L5d
        L59:
            r6.x[] r1 = r1.d
            r1 = r1[r5]
        L5d:
            java.lang.Object r1 = r1.f5220a
            t1.a0 r1 = (t1.a0) r1
            int r2 = r8.getWidth()
            float r3 = r1.f5447b
            int r1 = r1.f5446a
            r5 = 1
            if (r1 != r5) goto L70
            float r1 = (float) r2
            float r3 = r3 * r1
        L6e:
            int r4 = (int) r3
            goto L74
        L70:
            r2 = 2
            if (r1 != r2) goto L74
            goto L6e
        L74:
            int r0 = java.lang.Math.min(r0, r4)
            n0.e r1 = r8.F
            float r0 = (float) r0
            r1.a(r0)
            if (r9 == 0) goto L85
            n0.e r8 = r8.F
            r8.d()
        L85:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.material.button.MaterialButton.f(boolean):void");
    }

    public final void g() {
        int i8 = this.f1273r;
        if (i8 == 1 || i8 == 2) {
            setCompoundDrawablesRelative(this.f1265j, null, null, null);
            return;
        }
        if (i8 == 3 || i8 == 4) {
            setCompoundDrawablesRelative(null, null, this.f1265j, null);
        } else if (i8 == 16 || i8 == 32) {
            setCompoundDrawablesRelative(null, this.f1265j, null, null);
        }
    }

    @SuppressLint({"KotlinPropertyAccess"})
    public String getA11yClassName() {
        if (!TextUtils.isEmpty(this.f1266k)) {
            return this.f1266k;
        }
        g gVar = this.d;
        return ((gVar == null || !gVar.f3503t) ? Button.class : CompoundButton.class).getName();
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
            return this.d.f3493j;
        }
        return 0;
    }

    public n0.f getCornerSpringForce() {
        return this.d.d;
    }

    public Drawable getIcon() {
        return this.f1265j;
    }

    public int getIconGravity() {
        return this.f1273r;
    }

    public int getIconPadding() {
        return this.f1270o;
    }

    public int getIconSize() {
        return this.f1267l;
    }

    public ColorStateList getIconTint() {
        return this.f1264h;
    }

    public PorterDuff.Mode getIconTintMode() {
        return this.f1263g;
    }

    public int getInsetBottom() {
        return this.d.f3492i;
    }

    public int getInsetTop() {
        return this.d.f3491h;
    }

    public ColorStateList getRippleColor() {
        if (e()) {
            return this.d.f3498o;
        }
        return null;
    }

    public n getShapeAppearanceModel() {
        if (e()) {
            return this.d.f3486b;
        }
        throw new IllegalStateException("Attempted to get ShapeAppearanceModel from a MaterialButton which has an overwritten background.");
    }

    public z getStateListShapeAppearanceModel() {
        if (e()) {
            return this.d.f3487c;
        }
        throw new IllegalStateException("Attempted to get StateListShapeAppearanceModel from a MaterialButton which has an overwritten background.");
    }

    public ColorStateList getStrokeColor() {
        if (e()) {
            return this.d.f3497n;
        }
        return null;
    }

    public int getStrokeWidth() {
        if (e()) {
            return this.d.f3494k;
        }
        return 0;
    }

    @Override // g.o
    public ColorStateList getSupportBackgroundTintList() {
        return e() ? this.d.f3496m : super.getSupportBackgroundTintList();
    }

    @Override // g.o
    public PorterDuff.Mode getSupportBackgroundTintMode() {
        return e() ? this.d.f3495l : super.getSupportBackgroundTintMode();
    }

    public final void h(boolean z) {
        Drawable drawable = this.f1265j;
        if (drawable != null) {
            Drawable drawableMutate = drawable.mutate();
            this.f1265j = drawableMutate;
            drawableMutate.setTintList(this.f1264h);
            PorterDuff.Mode mode = this.f1263g;
            if (mode != null) {
                this.f1265j.setTintMode(mode);
            }
            int intrinsicWidth = this.f1267l;
            if (intrinsicWidth == 0) {
                intrinsicWidth = this.f1265j.getIntrinsicWidth();
            }
            int intrinsicHeight = this.f1267l;
            if (intrinsicHeight == 0) {
                intrinsicHeight = this.f1265j.getIntrinsicHeight();
            }
            Drawable drawable2 = this.f1265j;
            int i8 = this.f1268m;
            int i9 = this.f1269n;
            drawable2.setBounds(i8, i9, intrinsicWidth + i8, intrinsicHeight + i9);
            this.f1265j.setVisible(true, z);
        }
        if (z) {
            g();
            return;
        }
        Drawable[] compoundDrawablesRelative = getCompoundDrawablesRelative();
        Drawable drawable3 = compoundDrawablesRelative[0];
        Drawable drawable4 = compoundDrawablesRelative[1];
        Drawable drawable5 = compoundDrawablesRelative[2];
        int i10 = this.f1273r;
        if (((i10 == 1 || i10 == 2) && drawable3 != this.f1265j) || (((i10 == 3 || i10 == 4) && drawable5 != this.f1265j) || ((i10 == 16 || i10 == 32) && drawable4 != this.f1265j))) {
            g();
        }
    }

    public final void i(int i8, int i9) {
        if (this.f1265j == null || getLayout() == null) {
            return;
        }
        int i10 = this.f1273r;
        if (i10 != 1 && i10 != 2 && i10 != 3 && i10 != 4) {
            if (i10 == 16 || i10 == 32) {
                this.f1268m = 0;
                if (i10 == 16) {
                    this.f1269n = 0;
                    h(false);
                    return;
                }
                int intrinsicHeight = this.f1267l;
                if (intrinsicHeight == 0) {
                    intrinsicHeight = this.f1265j.getIntrinsicHeight();
                }
                int iMax = Math.max(0, (((((i9 - getTextHeight()) - getPaddingTop()) - intrinsicHeight) - this.f1270o) - getPaddingBottom()) / 2);
                if (this.f1269n != iMax) {
                    this.f1269n = iMax;
                    h(false);
                    return;
                }
                return;
            }
            return;
        }
        this.f1269n = 0;
        Layout.Alignment actualTextAlignment = getActualTextAlignment();
        int i11 = this.f1273r;
        if (i11 == 1 || i11 == 3 || ((i11 == 2 && actualTextAlignment == Layout.Alignment.ALIGN_NORMAL) || (i11 == 4 && actualTextAlignment == Layout.Alignment.ALIGN_OPPOSITE))) {
            this.f1268m = 0;
            h(false);
            return;
        }
        int intrinsicWidth = this.f1267l;
        if (intrinsicWidth == 0) {
            intrinsicWidth = this.f1265j.getIntrinsicWidth();
        }
        int textLayoutWidth = ((((i8 - getTextLayoutWidth()) - getPaddingEnd()) - intrinsicWidth) - this.f1270o) - getPaddingStart();
        if (actualTextAlignment == Layout.Alignment.ALIGN_CENTER) {
            textLayoutWidth /= 2;
        }
        if ((getLayoutDirection() == 1) != (this.f1273r == 4)) {
            textLayoutWidth = -textLayoutWidth;
        }
        if (this.f1268m != textLayoutWidth) {
            this.f1268m = textLayoutWidth;
            h(false);
        }
    }

    @Override // android.widget.Checkable
    public final boolean isChecked() {
        return this.f1271p;
    }

    public final void j() {
        int i8 = (int) (this.D - this.E);
        int i9 = (i8 / 2) + this.y;
        getLayoutParams().width = (int) (this.f1275t + i8);
        setPaddingRelative(this.f1276u + i9, getPaddingTop(), (this.f1277v + i8) - i9, getPaddingBottom());
    }

    @Override // android.widget.TextView, android.view.View
    public final void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (e()) {
            k4.z.J(this, this.d.a(false));
        }
    }

    @Override // android.widget.TextView, android.view.View
    public final int[] onCreateDrawableState(int i8) {
        int[] iArrOnCreateDrawableState = super.onCreateDrawableState(i8 + 2);
        g gVar = this.d;
        if (gVar != null && gVar.f3503t) {
            View.mergeDrawableStates(iArrOnCreateDrawableState, G);
        }
        if (this.f1271p) {
            View.mergeDrawableStates(iArrOnCreateDrawableState, H);
        }
        return iArrOnCreateDrawableState;
    }

    @Override // g.o, android.view.View
    public final void onInitializeAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        super.onInitializeAccessibilityEvent(accessibilityEvent);
        accessibilityEvent.setClassName(getA11yClassName());
        accessibilityEvent.setChecked(this.f1271p);
    }

    @Override // g.o, android.view.View
    public final void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo accessibilityNodeInfo) {
        super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
        accessibilityNodeInfo.setClassName(getA11yClassName());
        g gVar = this.d;
        accessibilityNodeInfo.setCheckable(gVar != null && gVar.f3503t);
        accessibilityNodeInfo.setChecked(this.f1271p);
        accessibilityNodeInfo.setClickable(isClickable());
    }

    @Override // g.o, android.widget.TextView, android.view.View
    public final void onLayout(boolean z, int i8, int i9, int i10, int i11) {
        int i12;
        super.onLayout(z, i8, i9, i10, i11);
        i(getMeasuredWidth(), getMeasuredHeight());
        int i13 = getResources().getConfiguration().orientation;
        if (this.f1274s != i13) {
            this.f1274s = i13;
            this.f1275t = -1.0f;
        }
        if (this.f1275t == -1.0f) {
            this.f1275t = getMeasuredWidth();
            if (this.f1278w == null && (getParent() instanceof f) && ((f) getParent()).getButtonSizeChange() != null) {
                this.f1278w = (LinearLayout.LayoutParams) getLayoutParams();
                LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(this.f1278w);
                layoutParams.width = (int) this.f1275t;
                setLayoutParams(layoutParams);
            }
        }
        boolean z2 = false;
        if (this.A == -1) {
            if (this.f1265j == null) {
                i12 = 0;
            } else {
                int iconPadding = getIconPadding();
                int intrinsicWidth = this.f1267l;
                if (intrinsicWidth == 0) {
                    intrinsicWidth = this.f1265j.getIntrinsicWidth();
                }
                i12 = iconPadding + intrinsicWidth;
            }
            this.A = (getMeasuredWidth() - getTextLayoutWidth()) - i12;
        }
        if (this.f1276u == -1) {
            this.f1276u = getPaddingStart();
        }
        if (this.f1277v == -1) {
            this.f1277v = getPaddingEnd();
        }
        if ((getParent() instanceof f) && ((f) getParent()).getOrientation() == 0) {
            z2 = true;
        }
        this.z = z2;
    }

    @Override // android.widget.TextView, android.view.View
    public final void onRestoreInstanceState(Parcelable parcelable) {
        if (!(parcelable instanceof d)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        d dVar = (d) parcelable;
        super.onRestoreInstanceState(dVar.f3000a);
        setChecked(dVar.f3474c);
    }

    @Override // android.widget.TextView, android.view.View
    public final Parcelable onSaveInstanceState() {
        d dVar = new d(super.onSaveInstanceState());
        dVar.f3474c = this.f1271p;
        return dVar;
    }

    @Override // g.o, android.widget.TextView
    public final void onTextChanged(CharSequence charSequence, int i8, int i9, int i10) {
        super.onTextChanged(charSequence, i8, i9, i10);
        i(getMeasuredWidth(), getMeasuredHeight());
    }

    @Override // android.view.View
    public final boolean performClick() {
        if (isEnabled() && this.d.f3504u) {
            toggle();
        }
        return super.performClick();
    }

    @Override // android.view.View
    public final void refreshDrawableState() {
        super.refreshDrawableState();
        if (this.f1265j != null) {
            if (this.f1265j.setState(getDrawableState())) {
                invalidate();
            }
        }
    }

    public void setA11yClassName(String str) {
        this.f1266k = str;
    }

    @Override // android.view.View
    public void setBackground(Drawable drawable) {
        setBackgroundDrawable(drawable);
    }

    @Override // android.view.View
    public void setBackgroundColor(int i8) {
        if (!e()) {
            super.setBackgroundColor(i8);
            return;
        }
        g gVar = this.d;
        if (gVar.a(false) != null) {
            gVar.a(false).setTint(i8);
        }
    }

    @Override // g.o, android.view.View
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
        g gVar = this.d;
        gVar.f3501r = true;
        MaterialButton materialButton = gVar.f3485a;
        materialButton.setSupportBackgroundTintList(gVar.f3496m);
        materialButton.setSupportBackgroundTintMode(gVar.f3495l);
        super.setBackgroundDrawable(drawable);
    }

    @Override // g.o, android.view.View
    public void setBackgroundResource(int i8) {
        setBackgroundDrawable(i8 != 0 ? h.p(getContext(), i8) : null);
    }

    @Override // android.view.View
    public void setBackgroundTintList(ColorStateList colorStateList) {
        setSupportBackgroundTintList(colorStateList);
    }

    @Override // android.view.View
    public void setBackgroundTintMode(PorterDuff.Mode mode) {
        setSupportBackgroundTintMode(mode);
    }

    public void setCheckable(boolean z) {
        if (e()) {
            this.d.f3503t = z;
        }
    }

    @Override // android.widget.Checkable
    public void setChecked(boolean z) {
        setCheckedInternal(z);
    }

    public void setCornerRadius(int i8) {
        if (e()) {
            g gVar = this.d;
            if (gVar.f3502s && gVar.f3493j == i8) {
                return;
            }
            gVar.f3493j = i8;
            gVar.f3502s = true;
            float f3 = i8;
            m mVarF = gVar.f3486b.f();
            mVarF.f5500e = new t1.a(f3);
            mVarF.f5501f = new t1.a(f3);
            mVarF.f5502g = new t1.a(f3);
            mVarF.f5503h = new t1.a(f3);
            gVar.f3486b = mVarF.a();
            gVar.f3487c = null;
            gVar.d();
        }
    }

    public void setCornerRadiusResource(int i8) {
        if (e()) {
            setCornerRadius(getResources().getDimensionPixelSize(i8));
        }
    }

    public void setCornerSpringForce(n0.f fVar) {
        g gVar = this.d;
        gVar.d = fVar;
        if (gVar.f3487c != null) {
            gVar.d();
        }
    }

    public void setDisplayedWidthDecrease(int i8) {
        this.E = Math.min(i8, this.A);
        j();
        invalidate();
    }

    @Override // android.view.View
    public void setElevation(float f3) {
        super.setElevation(f3);
        if (e()) {
            this.d.a(false).l(f3);
        }
    }

    public void setIcon(Drawable drawable) {
        if (this.f1265j != drawable) {
            this.f1265j = drawable;
            h(true);
            i(getMeasuredWidth(), getMeasuredHeight());
        }
    }

    public void setIconGravity(int i8) {
        if (this.f1273r != i8) {
            this.f1273r = i8;
            i(getMeasuredWidth(), getMeasuredHeight());
        }
    }

    public void setIconPadding(int i8) {
        if (this.f1270o != i8) {
            this.f1270o = i8;
            setCompoundDrawablePadding(i8);
        }
    }

    public void setIconResource(int i8) {
        setIcon(i8 != 0 ? h.p(getContext(), i8) : null);
    }

    public void setIconSize(int i8) {
        if (i8 < 0) {
            throw new IllegalArgumentException("iconSize cannot be less than 0");
        }
        if (this.f1267l != i8) {
            this.f1267l = i8;
            h(true);
        }
    }

    public void setIconTint(ColorStateList colorStateList) {
        if (this.f1264h != colorStateList) {
            this.f1264h = colorStateList;
            h(false);
        }
    }

    public void setIconTintMode(PorterDuff.Mode mode) {
        if (this.f1263g != mode) {
            this.f1263g = mode;
            h(false);
        }
    }

    public void setIconTintResource(int i8) {
        setIconTint(k4.z.t(getContext(), i8));
    }

    public void setInsetBottom(int i8) {
        g gVar = this.d;
        gVar.b(gVar.f3491h, i8);
    }

    public void setInsetTop(int i8) {
        g gVar = this.d;
        gVar.b(i8, gVar.f3492i);
    }

    public void setInternalBackground(Drawable drawable) {
        super.setBackgroundDrawable(drawable);
    }

    public void setOnPressedChangeListenerInternal(c cVar) {
        this.f1262f = cVar;
    }

    public void setOpticalCenterEnabled(boolean z) {
        if (this.f1279x != z) {
            this.f1279x = z;
            g gVar = this.d;
            if (z) {
                j1.a aVar = new j1.a(this);
                gVar.f3488e = aVar;
                j jVarA = gVar.a(false);
                if (jVarA != null) {
                    jVarA.C = aVar;
                }
            } else {
                gVar.f3488e = null;
                j jVarA2 = gVar.a(false);
                if (jVarA2 != null) {
                    jVarA2.C = null;
                }
            }
            post(new t(3, this));
        }
    }

    @Override // android.view.View
    public void setPressed(boolean z) {
        c cVar = this.f1262f;
        if (cVar != null) {
            ((MaterialButtonToggleGroup) ((androidx.emoji2.text.m) cVar).f621a).invalidate();
        }
        super.setPressed(z);
        f(false);
    }

    public void setRippleColor(ColorStateList colorStateList) {
        if (e()) {
            g gVar = this.d;
            MaterialButton materialButton = gVar.f3485a;
            if (gVar.f3498o != colorStateList) {
                gVar.f3498o = colorStateList;
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

    public void setRippleColorResource(int i8) {
        if (e()) {
            setRippleColor(k4.z.t(getContext(), i8));
        }
    }

    @Override // t1.x
    public void setShapeAppearanceModel(n nVar) {
        if (!e()) {
            throw new IllegalStateException("Attempted to set ShapeAppearanceModel on a MaterialButton which has an overwritten background.");
        }
        g gVar = this.d;
        gVar.f3486b = nVar;
        gVar.f3487c = null;
        gVar.d();
    }

    public void setShouldDrawSurfaceColorStroke(boolean z) {
        if (e()) {
            g gVar = this.d;
            gVar.f3500q = z;
            gVar.e();
        }
    }

    public void setSizeChange(b0 b0Var) {
        if (this.B != b0Var) {
            this.B = b0Var;
            f(true);
        }
    }

    public void setStateListShapeAppearanceModel(z zVar) {
        if (!e()) {
            throw new IllegalStateException("Attempted to set StateListShapeAppearanceModel on a MaterialButton which has an overwritten background.");
        }
        g gVar = this.d;
        if (gVar.d == null && zVar.d()) {
            gVar.d = d();
            if (gVar.f3487c != null) {
                gVar.d();
            }
        }
        gVar.f3487c = zVar;
        gVar.d();
    }

    public void setStrokeColor(ColorStateList colorStateList) {
        if (e()) {
            g gVar = this.d;
            if (gVar.f3497n != colorStateList) {
                gVar.f3497n = colorStateList;
                gVar.e();
            }
        }
    }

    public void setStrokeColorResource(int i8) {
        if (e()) {
            setStrokeColor(k4.z.t(getContext(), i8));
        }
    }

    public void setStrokeWidth(int i8) {
        if (e()) {
            g gVar = this.d;
            if (gVar.f3494k != i8) {
                gVar.f3494k = i8;
                gVar.e();
            }
        }
    }

    public void setStrokeWidthResource(int i8) {
        if (e()) {
            setStrokeWidth(getResources().getDimensionPixelSize(i8));
        }
    }

    @Override // g.o
    public void setSupportBackgroundTintList(ColorStateList colorStateList) {
        if (!e()) {
            super.setSupportBackgroundTintList(colorStateList);
            return;
        }
        g gVar = this.d;
        if (gVar.f3496m != colorStateList) {
            gVar.f3496m = colorStateList;
            if (gVar.a(false) != null) {
                gVar.a(false).setTintList(gVar.f3496m);
            }
        }
    }

    @Override // g.o
    public void setSupportBackgroundTintMode(PorterDuff.Mode mode) {
        if (!e()) {
            super.setSupportBackgroundTintMode(mode);
            return;
        }
        g gVar = this.d;
        if (gVar.f3495l != mode) {
            gVar.f3495l = mode;
            if (gVar.a(false) == null || gVar.f3495l == null) {
                return;
            }
            gVar.a(false).setTintMode(gVar.f3495l);
        }
    }

    @Override // android.view.View
    public void setTextAlignment(int i8) {
        super.setTextAlignment(i8);
        i(getMeasuredWidth(), getMeasuredHeight());
    }

    public void setToggleCheckedStateOnClick(boolean z) {
        this.d.f3504u = z;
    }

    @Override // android.widget.TextView
    public void setWidth(int i8) {
        this.f1275t = -1.0f;
        super.setWidth(i8);
    }

    public void setWidthChangeMax(int i8) {
        if (this.C != i8) {
            this.C = i8;
            f(true);
        }
    }

    @Override // android.widget.Checkable
    public final void toggle() {
        setChecked(!this.f1271p);
    }
}
