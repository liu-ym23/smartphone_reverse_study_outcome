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
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;
import android.widget.Button;
import android.widget.Checkable;
import android.widget.CompoundButton;
import android.widget.LinearLayout;
import androidx.appcompat.widget.e;
import androidx.appcompat.widget.y0;
import androidx.customview.view.AbsSavedState;
import androidx.datastore.preferences.protobuf.b1;
import com.google.android.material.internal.i;
import com.google.android.material.internal.m;
import com.google.android.material.shape.StateListSizeChange;
import h1.f;
import java.util.Iterator;
import java.util.LinkedHashSet;
import y4.g;
import y4.j;
import y4.n;
import y4.p;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public class MaterialButton extends e implements Checkable, n {
    public static final int[] I = {R.attr.state_checkable};
    public static final int[] J = {R.attr.state_checked};
    public static final a K = new a();
    public int A;
    public boolean B;
    public int C;
    public StateListSizeChange D;
    public int E;
    public float F;
    public float G;
    public f H;

    /* renamed from: d, reason: collision with root package name */
    public final d f4737d;

    /* renamed from: e, reason: collision with root package name */
    public final LinkedHashSet<b> f4738e;
    public c h;

    /* renamed from: j, reason: collision with root package name */
    public PorterDuff.Mode f4739j;

    /* renamed from: k, reason: collision with root package name */
    public ColorStateList f4740k;

    /* renamed from: l, reason: collision with root package name */
    public Drawable f4741l;

    /* renamed from: m, reason: collision with root package name */
    public String f4742m;

    /* renamed from: n, reason: collision with root package name */
    public int f4743n;

    /* renamed from: o, reason: collision with root package name */
    public int f4744o;

    /* renamed from: p, reason: collision with root package name */
    public int f4745p;

    /* renamed from: q, reason: collision with root package name */
    public int f4746q;
    public boolean r;

    /* renamed from: s, reason: collision with root package name */
    public boolean f4747s;

    /* renamed from: t, reason: collision with root package name */
    public int f4748t;

    /* renamed from: u, reason: collision with root package name */
    public int f4749u;

    /* renamed from: v, reason: collision with root package name */
    public float f4750v;

    /* renamed from: w, reason: collision with root package name */
    public int f4751w;

    /* renamed from: x, reason: collision with root package name */
    public int f4752x;

    /* renamed from: y, reason: collision with root package name */
    public LinearLayout.LayoutParams f4753y;
    public boolean z;

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public static class SavedState extends AbsSavedState {
        public static final Parcelable.Creator<SavedState> CREATOR = new a();
        boolean checked;

        /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
        public class a implements Parcelable.ClassLoaderCreator<SavedState> {
            @Override // android.os.Parcelable.ClassLoaderCreator
            public final SavedState createFromParcel(Parcel parcel, ClassLoader classLoader) {
                return new SavedState(parcel, classLoader);
            }

            @Override // android.os.Parcelable.Creator
            public final Object[] newArray(int i10) {
                return new SavedState[i10];
            }

            @Override // android.os.Parcelable.Creator
            public final Object createFromParcel(Parcel parcel) {
                return new SavedState(parcel, null);
            }
        }

        public SavedState(Parcelable parcelable) {
            super(parcelable);
        }

        private void readFromParcel(Parcel parcel) {
            this.checked = parcel.readInt() == 1;
        }

        @Override // androidx.customview.view.AbsSavedState, android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i10) {
            super.writeToParcel(parcel, i10);
            parcel.writeInt(this.checked ? 1 : 0);
        }

        public SavedState(Parcel parcel, ClassLoader classLoader) {
            super(parcel, classLoader);
            if (classLoader == null) {
                getClass().getClassLoader();
            }
            readFromParcel(parcel);
        }
    }

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public class a extends androidx.datastore.preferences.protobuf.f {
        @Override // androidx.datastore.preferences.protobuf.f
        public final float f(Object obj) {
            return ((MaterialButton) obj).getDisplayedWidthIncrease();
        }

        @Override // androidx.datastore.preferences.protobuf.f
        public final void i(Object obj, float f8) {
            ((MaterialButton) obj).setDisplayedWidthIncrease(f8);
        }
    }

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public interface b {
        void a();
    }

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public interface c {
    }

    public MaterialButton(Context context, AttributeSet attributeSet) {
        super(b5.a.b(context, attributeSet, com.stepos.aiengine.R.attr.materialButtonStyle, com.stepos.aiengine.R.style.Widget_MaterialComponents_Button, new int[]{com.stepos.aiengine.R.attr.materialSizeOverlay}), attributeSet, com.stepos.aiengine.R.attr.materialButtonStyle);
        this.f4738e = new LinkedHashSet<>();
        this.r = false;
        this.f4747s = false;
        this.f4749u = -1;
        this.f4750v = -1.0f;
        this.f4751w = -1;
        this.f4752x = -1;
        this.C = -1;
        Context context2 = getContext();
        TypedArray typedArrayD = i.d(context2, attributeSet, k4.a.f9909n, com.stepos.aiengine.R.attr.materialButtonStyle, com.stepos.aiengine.R.style.Widget_MaterialComponents_Button, new int[0]);
        this.f4746q = typedArrayD.getDimensionPixelSize(13, 0);
        int i10 = typedArrayD.getInt(16, -1);
        PorterDuff.Mode mode = PorterDuff.Mode.SRC_IN;
        this.f4739j = m.b(i10, mode);
        this.f4740k = w4.c.a(getContext(), typedArrayD, 15);
        this.f4741l = w4.c.c(getContext(), typedArrayD, 11);
        this.f4748t = typedArrayD.getInteger(12, 1);
        this.f4743n = typedArrayD.getDimensionPixelSize(14, 0);
        p pVarB = p.b(context2, typedArrayD, 19);
        j jVarC = pVarB != null ? pVarB.c() : j.b(context2, attributeSet, com.stepos.aiengine.R.attr.materialButtonStyle, com.stepos.aiengine.R.style.Widget_MaterialComponents_Button).a();
        boolean z = typedArrayD.getBoolean(17, false);
        d dVar = new d(this, jVarC);
        this.f4737d = dVar;
        dVar.f4779f = typedArrayD.getDimensionPixelOffset(2, 0);
        dVar.f4780g = typedArrayD.getDimensionPixelOffset(3, 0);
        dVar.h = typedArrayD.getDimensionPixelOffset(4, 0);
        dVar.f4781i = typedArrayD.getDimensionPixelOffset(5, 0);
        if (typedArrayD.hasValue(9)) {
            int dimensionPixelSize = typedArrayD.getDimensionPixelSize(9, -1);
            dVar.f4782j = dimensionPixelSize;
            j.a aVarF = dVar.f4775b.f();
            aVarF.b(dimensionPixelSize);
            dVar.f4775b = aVarF.a();
            dVar.f4776c = null;
            dVar.d();
            dVar.f4790s = true;
        }
        dVar.f4783k = typedArrayD.getDimensionPixelSize(22, 0);
        dVar.f4784l = m.b(typedArrayD.getInt(8, -1), mode);
        dVar.f4785m = w4.c.a(getContext(), typedArrayD, 7);
        dVar.f4786n = w4.c.a(getContext(), typedArrayD, 21);
        dVar.f4787o = w4.c.a(getContext(), typedArrayD, 18);
        dVar.f4791t = typedArrayD.getBoolean(6, false);
        dVar.f4794w = typedArrayD.getDimensionPixelSize(10, 0);
        dVar.f4792u = typedArrayD.getBoolean(23, true);
        int paddingStart = getPaddingStart();
        int paddingTop = getPaddingTop();
        int paddingEnd = getPaddingEnd();
        int paddingBottom = getPaddingBottom();
        if (typedArrayD.hasValue(0)) {
            dVar.r = true;
            setSupportBackgroundTintList(dVar.f4785m);
            setSupportBackgroundTintMode(dVar.f4784l);
        } else {
            dVar.c();
        }
        setPaddingRelative(paddingStart + dVar.f4779f, paddingTop + dVar.h, paddingEnd + dVar.f4780g, paddingBottom + dVar.f4781i);
        setCheckedInternal(typedArrayD.getBoolean(1, false));
        if (pVarB != null) {
            dVar.f4777d = d();
            if (dVar.f4776c != null) {
                dVar.d();
            }
            dVar.f4776c = pVarB;
            dVar.d();
        }
        setOpticalCenterEnabled(z);
        typedArrayD.recycle();
        setCompoundDrawablePadding(this.f4746q);
        h(this.f4741l != null);
    }

    public static /* synthetic */ void a(MaterialButton materialButton) {
        materialButton.A = materialButton.getOpticalCenterShift();
        materialButton.j();
        materialButton.invalidate();
    }

    private Layout.Alignment getActualTextAlignment() {
        int textAlignment = getTextAlignment();
        return textAlignment != 1 ? (textAlignment == 6 || textAlignment == 3) ? Layout.Alignment.ALIGN_OPPOSITE : textAlignment != 4 ? Layout.Alignment.ALIGN_NORMAL : Layout.Alignment.ALIGN_CENTER : getGravityTextAlignment();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public float getDisplayedWidthIncrease() {
        return this.F;
    }

    private Layout.Alignment getGravityTextAlignment() {
        int gravity = getGravity() & 8388615;
        return gravity != 1 ? (gravity == 5 || gravity == 8388613) ? Layout.Alignment.ALIGN_OPPOSITE : Layout.Alignment.ALIGN_NORMAL : Layout.Alignment.ALIGN_CENTER;
    }

    private int getOpticalCenterShift() {
        g gVarA;
        if (this.z && this.B && (gVarA = this.f4737d.a(false)) != null) {
            return (int) (gVarA.h() * 0.11f);
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
        for (int i10 = 0; i10 < lineCount; i10++) {
            fMax = Math.max(fMax, getLayout().getLineWidth(i10));
        }
        return (int) Math.ceil(fMax);
    }

    private void setCheckedInternal(boolean z) {
        d dVar = this.f4737d;
        if (dVar == null || !dVar.f4791t || this.r == z) {
            return;
        }
        this.r = z;
        refreshDrawableState();
        if (getParent() instanceof MaterialButtonToggleGroup) {
            MaterialButtonToggleGroup materialButtonToggleGroup = (MaterialButtonToggleGroup) getParent();
            boolean z3 = this.r;
            if (!materialButtonToggleGroup.f4756p) {
                materialButtonToggleGroup.f(getId(), z3);
            }
        }
        if (this.f4747s) {
            return;
        }
        this.f4747s = true;
        Iterator<b> it = this.f4738e.iterator();
        while (it.hasNext()) {
            it.next().a();
        }
        this.f4747s = false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setDisplayedWidthIncrease(float f8) {
        MaterialButton materialButton;
        MaterialButton materialButton2;
        if (this.F != f8) {
            this.F = f8;
            j();
            invalidate();
            if (getParent() instanceof com.google.android.material.button.c) {
                com.google.android.material.button.c cVar = (com.google.android.material.button.c) getParent();
                int i10 = (int) this.F;
                int iIndexOfChild = cVar.indexOfChild(this);
                if (iIndexOfChild < 0) {
                    return;
                }
                int i11 = iIndexOfChild - 1;
                while (true) {
                    materialButton = null;
                    if (i11 < 0) {
                        materialButton2 = null;
                        break;
                    } else {
                        if (cVar.c(i11)) {
                            materialButton2 = (MaterialButton) cVar.getChildAt(i11);
                            break;
                        }
                        i11--;
                    }
                }
                int childCount = cVar.getChildCount();
                while (true) {
                    iIndexOfChild++;
                    if (iIndexOfChild >= childCount) {
                        break;
                    } else if (cVar.c(iIndexOfChild)) {
                        materialButton = (MaterialButton) cVar.getChildAt(iIndexOfChild);
                        break;
                    }
                }
                if (materialButton2 == null && materialButton == null) {
                    return;
                }
                if (materialButton2 == null) {
                    materialButton.setDisplayedWidthDecrease(i10);
                }
                if (materialButton == null) {
                    materialButton2.setDisplayedWidthDecrease(i10);
                }
                if (materialButton2 == null || materialButton == null) {
                    return;
                }
                materialButton2.setDisplayedWidthDecrease(i10 / 2);
                materialButton.setDisplayedWidthDecrease((i10 + 1) / 2);
            }
        }
    }

    public final h1.g d() {
        Context context = getContext();
        TypedValue typedValueA = w4.b.a(com.stepos.aiengine.R.attr.motionSpringFastSpatial, context);
        int[] iArr = k4.a.f9917w;
        TypedArray typedArrayObtainStyledAttributes = typedValueA == null ? context.obtainStyledAttributes(null, iArr, 0, com.stepos.aiengine.R.style.Motion_Material3_Spring_Standard_Fast_Spatial) : context.obtainStyledAttributes(typedValueA.resourceId, iArr);
        h1.g gVar = new h1.g();
        try {
            float f8 = typedArrayObtainStyledAttributes.getFloat(1, Float.MIN_VALUE);
            if (f8 == Float.MIN_VALUE) {
                throw new IllegalArgumentException("A MaterialSpring style must have stiffness value.");
            }
            float f9 = typedArrayObtainStyledAttributes.getFloat(0, Float.MIN_VALUE);
            if (f9 == Float.MIN_VALUE) {
                throw new IllegalArgumentException("A MaterialSpring style must have a damping value.");
            }
            gVar.b(f8);
            gVar.a(f9);
            return gVar;
        } finally {
            typedArrayObtainStyledAttributes.recycle();
        }
    }

    public final boolean e() {
        d dVar = this.f4737d;
        return (dVar == null || dVar.r) ? false : true;
    }

    /* JADX WARN: Removed duplicated region for block: B:39:0x007f  */
    /* JADX WARN: Removed duplicated region for block: B:40:0x0082  */
    /* JADX WARN: Removed duplicated region for block: B:45:0x0097  */
    /* JADX WARN: Removed duplicated region for block: B:52:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void f(boolean r9) {
        /*
            r8 = this;
            com.google.android.material.shape.StateListSizeChange r0 = r8.D
            if (r0 != 0) goto L6
            goto L9c
        L6:
            h1.f r0 = r8.H
            if (r0 != 0) goto L19
            h1.f r0 = new h1.f
            com.google.android.material.button.MaterialButton$a r1 = com.google.android.material.button.MaterialButton.K
            r0.<init>(r8, r1)
            r8.H = r0
            h1.g r1 = r8.d()
            r0.f9241t = r1
        L19:
            boolean r0 = r8.B
            if (r0 == 0) goto L9c
            int r0 = r8.E
            com.google.android.material.shape.StateListSizeChange r1 = r8.D
            int[] r2 = r8.getDrawableState()
            int[][] r3 = r1.f5124c
            r4 = 0
            r5 = r4
        L29:
            int r6 = r1.f5122a
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
            int[][] r3 = r1.f5124c
            r5 = r4
        L42:
            int r6 = r1.f5122a
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
            com.google.android.material.shape.StateListSizeChange$a r1 = r1.f5123b
            goto L5d
        L59:
            com.google.android.material.shape.StateListSizeChange$a[] r1 = r1.f5125d
            r1 = r1[r5]
        L5d:
            com.google.android.material.shape.StateListSizeChange$b r1 = r1.f5129a
            int r2 = r8.getWidth()
            float r3 = r1.f5131b
            com.google.android.material.shape.StateListSizeChange$SizeChangeType r1 = r1.f5130a
            com.google.android.material.shape.StateListSizeChange$SizeChangeType r5 = com.google.android.material.shape.StateListSizeChange.SizeChangeType.f5126a
            if (r1 != r5) goto L6f
            float r1 = (float) r2
            float r3 = r3 * r1
        L6d:
            int r4 = (int) r3
            goto L74
        L6f:
            com.google.android.material.shape.StateListSizeChange$SizeChangeType r2 = com.google.android.material.shape.StateListSizeChange.SizeChangeType.f5127b
            if (r1 != r2) goto L74
            goto L6d
        L74:
            int r0 = java.lang.Math.min(r0, r4)
            h1.f r1 = r8.H
            float r0 = (float) r0
            boolean r2 = r1.f9232f
            if (r2 == 0) goto L82
            r1.f9242u = r0
            goto L95
        L82:
            h1.g r2 = r1.f9241t
            if (r2 != 0) goto L8d
            h1.g r2 = new h1.g
            r2.<init>(r0)
            r1.f9241t = r2
        L8d:
            h1.g r2 = r1.f9241t
            double r3 = (double) r0
            r2.f9251i = r3
            r1.h()
        L95:
            if (r9 == 0) goto L9c
            h1.f r8 = r8.H
            r8.g()
        L9c:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.material.button.MaterialButton.f(boolean):void");
    }

    public final void g() {
        int i10 = this.f4748t;
        if (i10 == 1 || i10 == 2) {
            setCompoundDrawablesRelative(this.f4741l, null, null, null);
            return;
        }
        if (i10 == 3 || i10 == 4) {
            setCompoundDrawablesRelative(null, null, this.f4741l, null);
        } else if (i10 == 16 || i10 == 32) {
            setCompoundDrawablesRelative(null, this.f4741l, null, null);
        }
    }

    @SuppressLint({"KotlinPropertyAccess"})
    public String getA11yClassName() {
        if (!TextUtils.isEmpty(this.f4742m)) {
            return this.f4742m;
        }
        d dVar = this.f4737d;
        return ((dVar == null || !dVar.f4791t) ? Button.class : CompoundButton.class).getName();
    }

    public int getAllowedWidthDecrease() {
        return this.C;
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
            return this.f4737d.f4782j;
        }
        return 0;
    }

    public h1.g getCornerSpringForce() {
        return this.f4737d.f4777d;
    }

    public Drawable getIcon() {
        return this.f4741l;
    }

    public int getIconGravity() {
        return this.f4748t;
    }

    public int getIconPadding() {
        return this.f4746q;
    }

    public int getIconSize() {
        return this.f4743n;
    }

    public ColorStateList getIconTint() {
        return this.f4740k;
    }

    public PorterDuff.Mode getIconTintMode() {
        return this.f4739j;
    }

    public int getInsetBottom() {
        return this.f4737d.f4781i;
    }

    public int getInsetTop() {
        return this.f4737d.h;
    }

    public ColorStateList getRippleColor() {
        if (e()) {
            return this.f4737d.f4787o;
        }
        return null;
    }

    public j getShapeAppearanceModel() {
        if (e()) {
            return this.f4737d.f4775b;
        }
        throw new IllegalStateException("Attempted to get ShapeAppearanceModel from a MaterialButton which has an overwritten background.");
    }

    public p getStateListShapeAppearanceModel() {
        if (e()) {
            return this.f4737d.f4776c;
        }
        throw new IllegalStateException("Attempted to get StateListShapeAppearanceModel from a MaterialButton which has an overwritten background.");
    }

    public ColorStateList getStrokeColor() {
        if (e()) {
            return this.f4737d.f4786n;
        }
        return null;
    }

    public int getStrokeWidth() {
        if (e()) {
            return this.f4737d.f4783k;
        }
        return 0;
    }

    @Override // androidx.appcompat.widget.e
    public ColorStateList getSupportBackgroundTintList() {
        return e() ? this.f4737d.f4785m : super.getSupportBackgroundTintList();
    }

    @Override // androidx.appcompat.widget.e
    public PorterDuff.Mode getSupportBackgroundTintMode() {
        return e() ? this.f4737d.f4784l : super.getSupportBackgroundTintMode();
    }

    public final void h(boolean z) {
        Drawable drawable = this.f4741l;
        if (drawable != null) {
            Drawable drawableMutate = drawable.mutate();
            this.f4741l = drawableMutate;
            drawableMutate.setTintList(this.f4740k);
            PorterDuff.Mode mode = this.f4739j;
            if (mode != null) {
                this.f4741l.setTintMode(mode);
            }
            int intrinsicWidth = this.f4743n;
            if (intrinsicWidth == 0) {
                intrinsicWidth = this.f4741l.getIntrinsicWidth();
            }
            int intrinsicHeight = this.f4743n;
            if (intrinsicHeight == 0) {
                intrinsicHeight = this.f4741l.getIntrinsicHeight();
            }
            Drawable drawable2 = this.f4741l;
            int i10 = this.f4744o;
            int i11 = this.f4745p;
            drawable2.setBounds(i10, i11, intrinsicWidth + i10, intrinsicHeight + i11);
            this.f4741l.setVisible(true, z);
        }
        if (z) {
            g();
            return;
        }
        Drawable[] compoundDrawablesRelative = getCompoundDrawablesRelative();
        Drawable drawable3 = compoundDrawablesRelative[0];
        Drawable drawable4 = compoundDrawablesRelative[1];
        Drawable drawable5 = compoundDrawablesRelative[2];
        int i12 = this.f4748t;
        if (((i12 == 1 || i12 == 2) && drawable3 != this.f4741l) || (((i12 == 3 || i12 == 4) && drawable5 != this.f4741l) || ((i12 == 16 || i12 == 32) && drawable4 != this.f4741l))) {
            g();
        }
    }

    public final void i(int i10, int i11) {
        if (this.f4741l == null || getLayout() == null) {
            return;
        }
        int i12 = this.f4748t;
        if (i12 != 1 && i12 != 2 && i12 != 3 && i12 != 4) {
            if (i12 == 16 || i12 == 32) {
                this.f4744o = 0;
                if (i12 == 16) {
                    this.f4745p = 0;
                    h(false);
                    return;
                }
                int intrinsicHeight = this.f4743n;
                if (intrinsicHeight == 0) {
                    intrinsicHeight = this.f4741l.getIntrinsicHeight();
                }
                int iMax = Math.max(0, (((((i11 - getTextHeight()) - getPaddingTop()) - intrinsicHeight) - this.f4746q) - getPaddingBottom()) / 2);
                if (this.f4745p != iMax) {
                    this.f4745p = iMax;
                    h(false);
                    return;
                }
                return;
            }
            return;
        }
        this.f4745p = 0;
        Layout.Alignment actualTextAlignment = getActualTextAlignment();
        int i13 = this.f4748t;
        if (i13 == 1 || i13 == 3 || ((i13 == 2 && actualTextAlignment == Layout.Alignment.ALIGN_NORMAL) || (i13 == 4 && actualTextAlignment == Layout.Alignment.ALIGN_OPPOSITE))) {
            this.f4744o = 0;
            h(false);
            return;
        }
        int intrinsicWidth = this.f4743n;
        if (intrinsicWidth == 0) {
            intrinsicWidth = this.f4741l.getIntrinsicWidth();
        }
        int textLayoutWidth = ((((i10 - getTextLayoutWidth()) - getPaddingEnd()) - intrinsicWidth) - this.f4746q) - getPaddingStart();
        if (actualTextAlignment == Layout.Alignment.ALIGN_CENTER) {
            textLayoutWidth /= 2;
        }
        if ((getLayoutDirection() == 1) != (this.f4748t == 4)) {
            textLayoutWidth = -textLayoutWidth;
        }
        if (this.f4744o != textLayoutWidth) {
            this.f4744o = textLayoutWidth;
            h(false);
        }
    }

    @Override // android.widget.Checkable
    public final boolean isChecked() {
        return this.r;
    }

    public final void j() {
        int i10 = (int) (this.F - this.G);
        int i11 = (i10 / 2) + this.A;
        getLayoutParams().width = (int) (this.f4750v + i10);
        setPaddingRelative(this.f4751w + i11, getPaddingTop(), (this.f4752x + i10) - i11, getPaddingBottom());
    }

    @Override // android.widget.TextView, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (e()) {
            xb.a.g(this, this.f4737d.a(false));
        }
    }

    @Override // android.widget.TextView, android.view.View
    public final int[] onCreateDrawableState(int i10) {
        int[] iArrOnCreateDrawableState = super.onCreateDrawableState(i10 + 2);
        d dVar = this.f4737d;
        if (dVar != null && dVar.f4791t) {
            Button.mergeDrawableStates(iArrOnCreateDrawableState, I);
        }
        if (this.r) {
            Button.mergeDrawableStates(iArrOnCreateDrawableState, J);
        }
        return iArrOnCreateDrawableState;
    }

    @Override // androidx.appcompat.widget.e, android.view.View
    public final void onInitializeAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        super.onInitializeAccessibilityEvent(accessibilityEvent);
        accessibilityEvent.setClassName(getA11yClassName());
        accessibilityEvent.setChecked(this.r);
    }

    @Override // androidx.appcompat.widget.e, android.view.View
    public final void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo accessibilityNodeInfo) {
        super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
        accessibilityNodeInfo.setClassName(getA11yClassName());
        d dVar = this.f4737d;
        accessibilityNodeInfo.setCheckable(dVar != null && dVar.f4791t);
        accessibilityNodeInfo.setChecked(this.r);
        accessibilityNodeInfo.setClickable(isClickable());
    }

    @Override // androidx.appcompat.widget.e, android.widget.TextView, android.view.View
    public final void onLayout(boolean z, int i10, int i11, int i12, int i13) {
        int i14;
        super.onLayout(z, i10, i11, i12, i13);
        i(getMeasuredWidth(), getMeasuredHeight());
        int i15 = getResources().getConfiguration().orientation;
        if (this.f4749u != i15) {
            this.f4749u = i15;
            this.f4750v = -1.0f;
        }
        if (this.f4750v == -1.0f) {
            this.f4750v = getMeasuredWidth();
            if (this.f4753y == null && (getParent() instanceof com.google.android.material.button.c) && ((com.google.android.material.button.c) getParent()).getButtonSizeChange() != null) {
                this.f4753y = (LinearLayout.LayoutParams) getLayoutParams();
                LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(this.f4753y);
                layoutParams.width = (int) this.f4750v;
                setLayoutParams(layoutParams);
            }
        }
        boolean z3 = false;
        if (this.C == -1) {
            if (this.f4741l == null) {
                i14 = 0;
            } else {
                int iconPadding = getIconPadding();
                int intrinsicWidth = this.f4743n;
                if (intrinsicWidth == 0) {
                    intrinsicWidth = this.f4741l.getIntrinsicWidth();
                }
                i14 = iconPadding + intrinsicWidth;
            }
            this.C = (getMeasuredWidth() - getTextLayoutWidth()) - i14;
        }
        if (this.f4751w == -1) {
            this.f4751w = getPaddingStart();
        }
        if (this.f4752x == -1) {
            this.f4752x = getPaddingEnd();
        }
        if ((getParent() instanceof com.google.android.material.button.c) && ((com.google.android.material.button.c) getParent()).getOrientation() == 0) {
            z3 = true;
        }
        this.B = z3;
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
        savedState.checked = this.r;
        return savedState;
    }

    @Override // androidx.appcompat.widget.e, android.widget.TextView
    public final void onTextChanged(CharSequence charSequence, int i10, int i11, int i12) {
        super.onTextChanged(charSequence, i10, i11, i12);
        i(getMeasuredWidth(), getMeasuredHeight());
    }

    @Override // android.view.View
    public final boolean performClick() {
        if (isEnabled() && this.f4737d.f4792u) {
            toggle();
        }
        return super.performClick();
    }

    @Override // android.view.View
    public final void refreshDrawableState() {
        super.refreshDrawableState();
        if (this.f4741l != null) {
            if (this.f4741l.setState(getDrawableState())) {
                invalidate();
            }
        }
    }

    public void setA11yClassName(String str) {
        this.f4742m = str;
    }

    @Override // android.view.View
    public void setBackground(Drawable drawable) {
        setBackgroundDrawable(drawable);
    }

    @Override // android.view.View
    public void setBackgroundColor(int i10) {
        if (!e()) {
            super.setBackgroundColor(i10);
            return;
        }
        d dVar = this.f4737d;
        if (dVar.a(false) != null) {
            dVar.a(false).setTint(i10);
        }
    }

    @Override // androidx.appcompat.widget.e, android.view.View
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
        d dVar = this.f4737d;
        dVar.r = true;
        MaterialButton materialButton = dVar.f4774a;
        materialButton.setSupportBackgroundTintList(dVar.f4785m);
        materialButton.setSupportBackgroundTintMode(dVar.f4784l);
        super.setBackgroundDrawable(drawable);
    }

    @Override // androidx.appcompat.widget.e, android.view.View
    public void setBackgroundResource(int i10) {
        setBackgroundDrawable(i10 != 0 ? b1.L(i10, getContext()) : null);
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
            this.f4737d.f4791t = z;
        }
    }

    @Override // android.widget.Checkable
    public void setChecked(boolean z) {
        setCheckedInternal(z);
    }

    public void setCornerRadius(int i10) {
        if (e()) {
            d dVar = this.f4737d;
            if (dVar.f4790s && dVar.f4782j == i10) {
                return;
            }
            dVar.f4782j = i10;
            dVar.f4790s = true;
            j.a aVarF = dVar.f4775b.f();
            aVarF.b(i10);
            dVar.f4775b = aVarF.a();
            dVar.f4776c = null;
            dVar.d();
        }
    }

    public void setCornerRadiusResource(int i10) {
        if (e()) {
            setCornerRadius(getResources().getDimensionPixelSize(i10));
        }
    }

    public void setCornerSpringForce(h1.g gVar) {
        d dVar = this.f4737d;
        dVar.f4777d = gVar;
        if (dVar.f4776c != null) {
            dVar.d();
        }
    }

    public void setDisplayedWidthDecrease(int i10) {
        this.G = Math.min(i10, this.C);
        j();
        invalidate();
    }

    @Override // android.view.View
    public void setElevation(float f8) {
        super.setElevation(f8);
        if (e()) {
            this.f4737d.a(false).m(f8);
        }
    }

    public void setIcon(Drawable drawable) {
        if (this.f4741l != drawable) {
            this.f4741l = drawable;
            h(true);
            i(getMeasuredWidth(), getMeasuredHeight());
        }
    }

    public void setIconGravity(int i10) {
        if (this.f4748t != i10) {
            this.f4748t = i10;
            i(getMeasuredWidth(), getMeasuredHeight());
        }
    }

    public void setIconPadding(int i10) {
        if (this.f4746q != i10) {
            this.f4746q = i10;
            setCompoundDrawablePadding(i10);
        }
    }

    public void setIconResource(int i10) {
        setIcon(i10 != 0 ? b1.L(i10, getContext()) : null);
    }

    public void setIconSize(int i10) {
        if (i10 < 0) {
            throw new IllegalArgumentException("iconSize cannot be less than 0");
        }
        if (this.f4743n != i10) {
            this.f4743n = i10;
            h(true);
        }
    }

    public void setIconTint(ColorStateList colorStateList) {
        if (this.f4740k != colorStateList) {
            this.f4740k = colorStateList;
            h(false);
        }
    }

    public void setIconTintMode(PorterDuff.Mode mode) {
        if (this.f4739j != mode) {
            this.f4739j = mode;
            h(false);
        }
    }

    public void setIconTintResource(int i10) {
        setIconTint(androidx.core.content.a.b(i10, getContext()));
    }

    public void setInsetBottom(int i10) {
        d dVar = this.f4737d;
        dVar.b(dVar.h, i10);
    }

    public void setInsetTop(int i10) {
        d dVar = this.f4737d;
        dVar.b(i10, dVar.f4781i);
    }

    public void setInternalBackground(Drawable drawable) {
        super.setBackgroundDrawable(drawable);
    }

    public void setOnPressedChangeListenerInternal(c cVar) {
        this.h = cVar;
    }

    public void setOpticalCenterEnabled(boolean z) {
        if (this.z != z) {
            this.z = z;
            d dVar = this.f4737d;
            if (z) {
                com.google.android.material.button.a aVar = new com.google.android.material.button.a(this);
                dVar.f4778e = aVar;
                g gVarA = dVar.a(false);
                if (gVarA != null) {
                    gVarA.F = aVar;
                }
            } else {
                dVar.f4778e = null;
                g gVarA2 = dVar.a(false);
                if (gVarA2 != null) {
                    gVarA2.F = null;
                }
            }
            post(new y0(this, 5));
        }
    }

    @Override // android.view.View
    public void setPressed(boolean z) {
        c cVar = this.h;
        if (cVar != null) {
            com.google.android.material.button.c.this.invalidate();
        }
        super.setPressed(z);
        f(false);
    }

    public void setRippleColor(ColorStateList colorStateList) {
        if (e()) {
            d dVar = this.f4737d;
            MaterialButton materialButton = dVar.f4774a;
            if (dVar.f4787o != colorStateList) {
                dVar.f4787o = colorStateList;
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

    public void setRippleColorResource(int i10) {
        if (e()) {
            setRippleColor(androidx.core.content.a.b(i10, getContext()));
        }
    }

    @Override // y4.n
    public void setShapeAppearanceModel(j jVar) {
        if (!e()) {
            throw new IllegalStateException("Attempted to set ShapeAppearanceModel on a MaterialButton which has an overwritten background.");
        }
        d dVar = this.f4737d;
        dVar.f4775b = jVar;
        dVar.f4776c = null;
        dVar.d();
    }

    public void setShouldDrawSurfaceColorStroke(boolean z) {
        if (e()) {
            d dVar = this.f4737d;
            dVar.f4789q = z;
            dVar.e();
        }
    }

    public void setSizeChange(StateListSizeChange stateListSizeChange) {
        if (this.D != stateListSizeChange) {
            this.D = stateListSizeChange;
            f(true);
        }
    }

    public void setStateListShapeAppearanceModel(p pVar) {
        if (!e()) {
            throw new IllegalStateException("Attempted to set StateListShapeAppearanceModel on a MaterialButton which has an overwritten background.");
        }
        d dVar = this.f4737d;
        if (dVar.f4777d == null && pVar.d()) {
            dVar.f4777d = d();
            if (dVar.f4776c != null) {
                dVar.d();
            }
        }
        dVar.f4776c = pVar;
        dVar.d();
    }

    public void setStrokeColor(ColorStateList colorStateList) {
        if (e()) {
            d dVar = this.f4737d;
            if (dVar.f4786n != colorStateList) {
                dVar.f4786n = colorStateList;
                dVar.e();
            }
        }
    }

    public void setStrokeColorResource(int i10) {
        if (e()) {
            setStrokeColor(androidx.core.content.a.b(i10, getContext()));
        }
    }

    public void setStrokeWidth(int i10) {
        if (e()) {
            d dVar = this.f4737d;
            if (dVar.f4783k != i10) {
                dVar.f4783k = i10;
                dVar.e();
            }
        }
    }

    public void setStrokeWidthResource(int i10) {
        if (e()) {
            setStrokeWidth(getResources().getDimensionPixelSize(i10));
        }
    }

    @Override // androidx.appcompat.widget.e
    public void setSupportBackgroundTintList(ColorStateList colorStateList) {
        if (!e()) {
            super.setSupportBackgroundTintList(colorStateList);
            return;
        }
        d dVar = this.f4737d;
        if (dVar.f4785m != colorStateList) {
            dVar.f4785m = colorStateList;
            if (dVar.a(false) != null) {
                dVar.a(false).setTintList(dVar.f4785m);
            }
        }
    }

    @Override // androidx.appcompat.widget.e
    public void setSupportBackgroundTintMode(PorterDuff.Mode mode) {
        if (!e()) {
            super.setSupportBackgroundTintMode(mode);
            return;
        }
        d dVar = this.f4737d;
        if (dVar.f4784l != mode) {
            dVar.f4784l = mode;
            if (dVar.a(false) == null || dVar.f4784l == null) {
                return;
            }
            dVar.a(false).setTintMode(dVar.f4784l);
        }
    }

    @Override // android.view.View
    public void setTextAlignment(int i10) {
        super.setTextAlignment(i10);
        i(getMeasuredWidth(), getMeasuredHeight());
    }

    public void setToggleCheckedStateOnClick(boolean z) {
        this.f4737d.f4792u = z;
    }

    @Override // android.widget.TextView
    public void setWidth(int i10) {
        this.f4750v = -1.0f;
        super.setWidth(i10);
    }

    public void setWidthChangeMax(int i10) {
        if (this.E != i10) {
            this.E = i10;
            f(true);
        }
    }

    @Override // android.widget.Checkable
    public final void toggle() {
        setChecked(!this.r);
    }
}
