package com.google.android.material.button;

import Z2.h;
import Z2.l;
import Z2.o;
import Z2.s;
import android.R;
import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.Layout;
import android.text.TextPaint;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;
import android.widget.Button;
import android.widget.Checkable;
import android.widget.CompoundButton;
import android.widget.LinearLayout;
import androidx.appcompat.widget.AppCompatButton;
import androidx.customview.view.AbsSavedState;
import androidx.dynamicanimation.animation.f;
import androidx.dynamicanimation.animation.i;
import androidx.dynamicanimation.animation.j;
import com.google.android.material.R$attr;
import com.google.android.material.R$style;
import com.google.android.material.R$styleable;
import com.google.android.material.internal.r;
import com.google.android.material.internal.u;
import com.google.android.material.shape.StateListSizeChange;
import d3.C3953a;
import f.C4027a;
import java.util.Iterator;
import java.util.LinkedHashSet;
import u0.C5566a;

/* loaded from: classes2.dex */
public class MaterialButton extends AppCompatButton implements Checkable, o {

    /* renamed from: C, reason: collision with root package name */
    public static final int[] f20452C = {R.attr.state_checkable};

    /* renamed from: D, reason: collision with root package name */
    public static final int[] f20453D = {R.attr.state_checked};

    /* renamed from: E, reason: collision with root package name */
    public static final int f20454E = R$style.Widget_MaterialComponents_Button;

    /* renamed from: F, reason: collision with root package name */
    public static final int f20455F = R$attr.materialSizeOverlay;

    /* renamed from: G, reason: collision with root package name */
    public static final f<MaterialButton> f20456G = new a("widthIncrease");

    /* renamed from: A, reason: collision with root package name */
    public float f20457A;

    /* renamed from: B, reason: collision with root package name */
    public i f20458B;

    /* renamed from: a, reason: collision with root package name */
    public final e f20459a;

    /* renamed from: b, reason: collision with root package name */
    public final LinkedHashSet<b> f20460b;

    /* renamed from: c, reason: collision with root package name */
    public c f20461c;

    /* renamed from: d, reason: collision with root package name */
    public PorterDuff.Mode f20462d;

    /* renamed from: e, reason: collision with root package name */
    public ColorStateList f20463e;

    /* renamed from: f, reason: collision with root package name */
    public Drawable f20464f;

    /* renamed from: g, reason: collision with root package name */
    public String f20465g;

    /* renamed from: h, reason: collision with root package name */
    public int f20466h;

    /* renamed from: i, reason: collision with root package name */
    public int f20467i;

    /* renamed from: j, reason: collision with root package name */
    public int f20468j;

    /* renamed from: k, reason: collision with root package name */
    public int f20469k;

    /* renamed from: l, reason: collision with root package name */
    public boolean f20470l;

    /* renamed from: m, reason: collision with root package name */
    public boolean f20471m;

    /* renamed from: n, reason: collision with root package name */
    public int f20472n;

    /* renamed from: o, reason: collision with root package name */
    public int f20473o;

    /* renamed from: p, reason: collision with root package name */
    public float f20474p;

    /* renamed from: q, reason: collision with root package name */
    public int f20475q;

    /* renamed from: r, reason: collision with root package name */
    public int f20476r;

    /* renamed from: s, reason: collision with root package name */
    public LinearLayout.LayoutParams f20477s;

    /* renamed from: t, reason: collision with root package name */
    public boolean f20478t;

    /* renamed from: u, reason: collision with root package name */
    public int f20479u;

    /* renamed from: v, reason: collision with root package name */
    public boolean f20480v;

    /* renamed from: w, reason: collision with root package name */
    public int f20481w;

    /* renamed from: x, reason: collision with root package name */
    public StateListSizeChange f20482x;

    /* renamed from: y, reason: collision with root package name */
    public int f20483y;

    /* renamed from: z, reason: collision with root package name */
    public float f20484z;

    public static class SavedState extends AbsSavedState {
        public static final Parcelable.Creator<SavedState> CREATOR = new a();
        boolean checked;

        public class a implements Parcelable.ClassLoaderCreator<SavedState> {
            @Override // android.os.Parcelable.Creator
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public SavedState createFromParcel(Parcel parcel) {
                return new SavedState(parcel, null);
            }

            @Override // android.os.Parcelable.ClassLoaderCreator
            /* renamed from: b, reason: merged with bridge method [inline-methods] */
            public SavedState createFromParcel(Parcel parcel, ClassLoader classLoader) {
                return new SavedState(parcel, classLoader);
            }

            @Override // android.os.Parcelable.Creator
            /* renamed from: c, reason: merged with bridge method [inline-methods] */
            public SavedState[] newArray(int i10) {
                return new SavedState[i10];
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

    public class a extends f<MaterialButton> {
        public a(String str) {
            super(str);
        }

        @Override // androidx.dynamicanimation.animation.f
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public float getValue(MaterialButton materialButton) {
            return materialButton.getDisplayedWidthIncrease();
        }

        @Override // androidx.dynamicanimation.animation.f
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public void setValue(MaterialButton materialButton, float f10) {
            materialButton.setDisplayedWidthIncrease(f10);
        }
    }

    public interface b {
        void a(MaterialButton materialButton, boolean z10);
    }

    public interface c {
        void a(MaterialButton materialButton, boolean z10);
    }

    public MaterialButton(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, R$attr.materialButtonStyle);
    }

    public static /* synthetic */ void a(MaterialButton materialButton) {
        materialButton.f20479u = materialButton.getOpticalCenterShift();
        materialButton.s();
        materialButton.invalidate();
    }

    public static /* synthetic */ void b(MaterialButton materialButton, float f10) {
        int i10 = (int) (f10 * 0.11f);
        if (materialButton.f20479u != i10) {
            materialButton.f20479u = i10;
            materialButton.s();
            materialButton.invalidate();
        }
    }

    private Layout.Alignment getActualTextAlignment() {
        int textAlignment = getTextAlignment();
        return textAlignment != 1 ? (textAlignment == 6 || textAlignment == 3) ? Layout.Alignment.ALIGN_OPPOSITE : textAlignment != 4 ? Layout.Alignment.ALIGN_NORMAL : Layout.Alignment.ALIGN_CENTER : getGravityTextAlignment();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public float getDisplayedWidthIncrease() {
        return this.f20484z;
    }

    private Layout.Alignment getGravityTextAlignment() {
        int gravity = getGravity() & 8388615;
        return gravity != 1 ? (gravity == 5 || gravity == 8388613) ? Layout.Alignment.ALIGN_OPPOSITE : Layout.Alignment.ALIGN_NORMAL : Layout.Alignment.ALIGN_CENTER;
    }

    private int getOpticalCenterShift() {
        h hVarG;
        if (this.f20478t && this.f20480v && (hVarG = this.f20459a.g()) != null) {
            return (int) (hVarG.z() * 0.11f);
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

    private void setCheckedInternal(boolean z10) {
        if (!g() || this.f20470l == z10) {
            return;
        }
        this.f20470l = z10;
        refreshDrawableState();
        if (getParent() instanceof MaterialButtonToggleGroup) {
            ((MaterialButtonToggleGroup) getParent()).w(this, this.f20470l);
        }
        if (this.f20471m) {
            return;
        }
        this.f20471m = true;
        Iterator<b> it = this.f20460b.iterator();
        while (it.hasNext()) {
            it.next().a(this, this.f20470l);
        }
        this.f20471m = false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setDisplayedWidthIncrease(float f10) {
        if (this.f20484z != f10) {
            this.f20484z = f10;
            s();
            invalidate();
            if (getParent() instanceof d) {
                ((d) getParent()).k(this, (int) this.f20484z);
            }
        }
    }

    public final j e() {
        return T2.h.h(getContext(), R$attr.motionSpringFastSpatial, R$style.Motion_Material3_Spring_Standard_Fast_Spatial);
    }

    public final void f() {
        i iVar = new i(this, f20456G);
        this.f20458B = iVar;
        iVar.B(e());
    }

    public boolean g() {
        e eVar = this.f20459a;
        return eVar != null && eVar.r();
    }

    @SuppressLint({"KotlinPropertyAccess"})
    public String getA11yClassName() {
        if (TextUtils.isEmpty(this.f20465g)) {
            return (g() ? CompoundButton.class : Button.class).getName();
        }
        return this.f20465g;
    }

    public int getAllowedWidthDecrease() {
        return this.f20481w;
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
        if (m()) {
            return this.f20459a.b();
        }
        return 0;
    }

    public j getCornerSpringForce() {
        return this.f20459a.c();
    }

    public Drawable getIcon() {
        return this.f20464f;
    }

    public int getIconGravity() {
        return this.f20472n;
    }

    public int getIconPadding() {
        return this.f20469k;
    }

    public int getIconSize() {
        return this.f20466h;
    }

    public ColorStateList getIconTint() {
        return this.f20463e;
    }

    public PorterDuff.Mode getIconTintMode() {
        return this.f20462d;
    }

    public int getInsetBottom() {
        return this.f20459a.d();
    }

    public int getInsetTop() {
        return this.f20459a.e();
    }

    public ColorStateList getRippleColor() {
        if (m()) {
            return this.f20459a.i();
        }
        return null;
    }

    public l getShapeAppearanceModel() {
        if (m()) {
            return this.f20459a.j();
        }
        throw new IllegalStateException("Attempted to get ShapeAppearanceModel from a MaterialButton which has an overwritten background.");
    }

    public s getStateListShapeAppearanceModel() {
        if (m()) {
            return this.f20459a.k();
        }
        throw new IllegalStateException("Attempted to get StateListShapeAppearanceModel from a MaterialButton which has an overwritten background.");
    }

    public ColorStateList getStrokeColor() {
        if (m()) {
            return this.f20459a.l();
        }
        return null;
    }

    public int getStrokeWidth() {
        if (m()) {
            return this.f20459a.m();
        }
        return 0;
    }

    @Override // androidx.appcompat.widget.AppCompatButton
    public ColorStateList getSupportBackgroundTintList() {
        return m() ? this.f20459a.n() : super.getSupportBackgroundTintList();
    }

    @Override // androidx.appcompat.widget.AppCompatButton
    public PorterDuff.Mode getSupportBackgroundTintMode() {
        return m() ? this.f20459a.o() : super.getSupportBackgroundTintMode();
    }

    public final boolean h() {
        int i10 = this.f20472n;
        return i10 == 3 || i10 == 4;
    }

    public final boolean i() {
        int i10 = this.f20472n;
        return i10 == 1 || i10 == 2;
    }

    @Override // android.widget.Checkable
    public boolean isChecked() {
        return this.f20470l;
    }

    public final boolean j() {
        int i10 = this.f20472n;
        return i10 == 16 || i10 == 32;
    }

    public final boolean k() {
        return (getParent() instanceof d) && ((d) getParent()).getOrientation() == 0;
    }

    public final boolean l() {
        return getLayoutDirection() == 1;
    }

    public final boolean m() {
        e eVar = this.f20459a;
        return (eVar == null || eVar.q()) ? false : true;
    }

    public final void n(boolean z10) {
        if (this.f20482x == null) {
            return;
        }
        if (this.f20458B == null) {
            f();
        }
        if (this.f20480v) {
            this.f20458B.w(Math.min(this.f20483y, this.f20482x.e(getDrawableState()).f21260a.a(getWidth())));
            if (z10) {
                this.f20458B.C();
            }
        }
    }

    public void o() {
        LinearLayout.LayoutParams layoutParams = this.f20477s;
        if (layoutParams != null) {
            setLayoutParams(layoutParams);
            this.f20477s = null;
            this.f20474p = -1.0f;
        }
    }

    @Override // android.widget.TextView, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (m()) {
            Z2.i.f(this, this.f20459a.g());
        }
    }

    @Override // android.widget.TextView, android.view.View
    public int[] onCreateDrawableState(int i10) {
        int[] iArrOnCreateDrawableState = super.onCreateDrawableState(i10 + 2);
        if (g()) {
            View.mergeDrawableStates(iArrOnCreateDrawableState, f20452C);
        }
        if (isChecked()) {
            View.mergeDrawableStates(iArrOnCreateDrawableState, f20453D);
        }
        return iArrOnCreateDrawableState;
    }

    @Override // androidx.appcompat.widget.AppCompatButton, android.view.View
    public void onInitializeAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        super.onInitializeAccessibilityEvent(accessibilityEvent);
        accessibilityEvent.setClassName(getA11yClassName());
        accessibilityEvent.setChecked(isChecked());
    }

    @Override // androidx.appcompat.widget.AppCompatButton, android.view.View
    public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo accessibilityNodeInfo) {
        super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
        accessibilityNodeInfo.setClassName(getA11yClassName());
        accessibilityNodeInfo.setCheckable(g());
        accessibilityNodeInfo.setChecked(isChecked());
        accessibilityNodeInfo.setClickable(isClickable());
    }

    @Override // androidx.appcompat.widget.AppCompatButton, android.widget.TextView, android.view.View
    public void onLayout(boolean z10, int i10, int i11, int i12, int i13) {
        int i14;
        super.onLayout(z10, i10, i11, i12, i13);
        r(getMeasuredWidth(), getMeasuredHeight());
        int i15 = getResources().getConfiguration().orientation;
        if (this.f20473o != i15) {
            this.f20473o = i15;
            this.f20474p = -1.0f;
        }
        if (this.f20474p == -1.0f) {
            this.f20474p = getMeasuredWidth();
            if (this.f20477s == null && (getParent() instanceof d) && ((d) getParent()).getButtonSizeChange() != null) {
                this.f20477s = (LinearLayout.LayoutParams) getLayoutParams();
                LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(this.f20477s);
                layoutParams.width = (int) this.f20474p;
                setLayoutParams(layoutParams);
            }
        }
        if (this.f20481w == -1) {
            if (this.f20464f == null) {
                i14 = 0;
            } else {
                int iconPadding = getIconPadding();
                int intrinsicWidth = this.f20466h;
                if (intrinsicWidth == 0) {
                    intrinsicWidth = this.f20464f.getIntrinsicWidth();
                }
                i14 = iconPadding + intrinsicWidth;
            }
            this.f20481w = (getMeasuredWidth() - getTextLayoutWidth()) - i14;
        }
        if (this.f20475q == -1) {
            this.f20475q = getPaddingStart();
        }
        if (this.f20476r == -1) {
            this.f20476r = getPaddingEnd();
        }
        this.f20480v = k();
    }

    @Override // android.widget.TextView, android.view.View
    public void onRestoreInstanceState(Parcelable parcelable) {
        if (!(parcelable instanceof SavedState)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        SavedState savedState = (SavedState) parcelable;
        super.onRestoreInstanceState(savedState.getSuperState());
        setChecked(savedState.checked);
    }

    @Override // android.widget.TextView, android.view.View
    public Parcelable onSaveInstanceState() {
        SavedState savedState = new SavedState(super.onSaveInstanceState());
        savedState.checked = this.f20470l;
        return savedState;
    }

    @Override // androidx.appcompat.widget.AppCompatButton, android.widget.TextView
    public void onTextChanged(CharSequence charSequence, int i10, int i11, int i12) {
        super.onTextChanged(charSequence, i10, i11, i12);
        r(getMeasuredWidth(), getMeasuredHeight());
    }

    public final void p() {
        if (i()) {
            setCompoundDrawablesRelative(this.f20464f, null, null, null);
        } else if (h()) {
            setCompoundDrawablesRelative(null, null, this.f20464f, null);
        } else if (j()) {
            setCompoundDrawablesRelative(null, this.f20464f, null, null);
        }
    }

    @Override // android.view.View
    public boolean performClick() {
        if (isEnabled() && this.f20459a.s()) {
            toggle();
        }
        return super.performClick();
    }

    public final void q(boolean z10) {
        Drawable drawable = this.f20464f;
        if (drawable != null) {
            Drawable drawableMutate = C5566a.r(drawable).mutate();
            this.f20464f = drawableMutate;
            drawableMutate.setTintList(this.f20463e);
            PorterDuff.Mode mode = this.f20462d;
            if (mode != null) {
                this.f20464f.setTintMode(mode);
            }
            int intrinsicWidth = this.f20466h;
            if (intrinsicWidth == 0) {
                intrinsicWidth = this.f20464f.getIntrinsicWidth();
            }
            int intrinsicHeight = this.f20466h;
            if (intrinsicHeight == 0) {
                intrinsicHeight = this.f20464f.getIntrinsicHeight();
            }
            Drawable drawable2 = this.f20464f;
            int i10 = this.f20467i;
            int i11 = this.f20468j;
            drawable2.setBounds(i10, i11, intrinsicWidth + i10, intrinsicHeight + i11);
            this.f20464f.setVisible(true, z10);
        }
        if (z10) {
            p();
            return;
        }
        Drawable[] compoundDrawablesRelative = getCompoundDrawablesRelative();
        Drawable drawable3 = compoundDrawablesRelative[0];
        Drawable drawable4 = compoundDrawablesRelative[1];
        Drawable drawable5 = compoundDrawablesRelative[2];
        if ((!i() || drawable3 == this.f20464f) && ((!h() || drawable5 == this.f20464f) && (!j() || drawable4 == this.f20464f))) {
            return;
        }
        p();
    }

    public final void r(int i10, int i11) {
        if (this.f20464f == null || getLayout() == null) {
            return;
        }
        if (!i() && !h()) {
            if (j()) {
                this.f20467i = 0;
                if (this.f20472n == 16) {
                    this.f20468j = 0;
                    q(false);
                    return;
                }
                int intrinsicHeight = this.f20466h;
                if (intrinsicHeight == 0) {
                    intrinsicHeight = this.f20464f.getIntrinsicHeight();
                }
                int iMax = Math.max(0, (((((i11 - getTextHeight()) - getPaddingTop()) - intrinsicHeight) - this.f20469k) - getPaddingBottom()) / 2);
                if (this.f20468j != iMax) {
                    this.f20468j = iMax;
                    q(false);
                    return;
                }
                return;
            }
            return;
        }
        this.f20468j = 0;
        Layout.Alignment actualTextAlignment = getActualTextAlignment();
        int i12 = this.f20472n;
        if (i12 == 1 || i12 == 3 || ((i12 == 2 && actualTextAlignment == Layout.Alignment.ALIGN_NORMAL) || (i12 == 4 && actualTextAlignment == Layout.Alignment.ALIGN_OPPOSITE))) {
            this.f20467i = 0;
            q(false);
            return;
        }
        int intrinsicWidth = this.f20466h;
        if (intrinsicWidth == 0) {
            intrinsicWidth = this.f20464f.getIntrinsicWidth();
        }
        int textLayoutWidth = ((((i10 - getTextLayoutWidth()) - getPaddingEnd()) - intrinsicWidth) - this.f20469k) - getPaddingStart();
        if (actualTextAlignment == Layout.Alignment.ALIGN_CENTER) {
            textLayoutWidth /= 2;
        }
        if (l() != (this.f20472n == 4)) {
            textLayoutWidth = -textLayoutWidth;
        }
        if (this.f20467i != textLayoutWidth) {
            this.f20467i = textLayoutWidth;
            q(false);
        }
    }

    @Override // android.view.View
    public void refreshDrawableState() {
        super.refreshDrawableState();
        if (this.f20464f != null) {
            if (this.f20464f.setState(getDrawableState())) {
                invalidate();
            }
        }
    }

    public final void s() {
        int i10 = (int) (this.f20484z - this.f20457A);
        int i11 = (i10 / 2) + this.f20479u;
        getLayoutParams().width = (int) (this.f20474p + i10);
        setPaddingRelative(this.f20475q + i11, getPaddingTop(), (this.f20476r + i10) - i11, getPaddingBottom());
    }

    public void setA11yClassName(String str) {
        this.f20465g = str;
    }

    @Override // android.view.View
    public void setBackground(Drawable drawable) {
        setBackgroundDrawable(drawable);
    }

    @Override // android.view.View
    public void setBackgroundColor(int i10) {
        if (m()) {
            this.f20459a.u(i10);
        } else {
            super.setBackgroundColor(i10);
        }
    }

    @Override // androidx.appcompat.widget.AppCompatButton, android.view.View
    public void setBackgroundDrawable(Drawable drawable) {
        if (!m()) {
            super.setBackgroundDrawable(drawable);
        } else {
            if (drawable == getBackground()) {
                getBackground().setState(drawable.getState());
                return;
            }
            Log.w("MaterialButton", "MaterialButton manages its own background to control elevation, shape, color and states. Consider using backgroundTint, shapeAppearance and other attributes where available. A custom background will ignore these attributes and you should consider handling interaction states such as pressed, focused and disabled");
            this.f20459a.v();
            super.setBackgroundDrawable(drawable);
        }
    }

    @Override // androidx.appcompat.widget.AppCompatButton, android.view.View
    public void setBackgroundResource(int i10) {
        setBackgroundDrawable(i10 != 0 ? C4027a.b(getContext(), i10) : null);
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
        if (m()) {
            this.f20459a.w(z10);
        }
    }

    @Override // android.widget.Checkable
    public void setChecked(boolean z10) {
        setCheckedInternal(z10);
    }

    public void setCornerRadius(int i10) {
        if (m()) {
            this.f20459a.x(i10);
        }
    }

    public void setCornerRadiusResource(int i10) {
        if (m()) {
            setCornerRadius(getResources().getDimensionPixelSize(i10));
        }
    }

    public void setCornerSpringForce(j jVar) {
        this.f20459a.z(jVar);
    }

    public void setDisplayedWidthDecrease(int i10) {
        this.f20457A = Math.min(i10, this.f20481w);
        s();
        invalidate();
    }

    @Override // android.view.View
    public void setElevation(float f10) {
        super.setElevation(f10);
        if (m()) {
            this.f20459a.g().f0(f10);
        }
    }

    public void setIcon(Drawable drawable) {
        if (this.f20464f != drawable) {
            this.f20464f = drawable;
            q(true);
            r(getMeasuredWidth(), getMeasuredHeight());
        }
    }

    public void setIconGravity(int i10) {
        if (this.f20472n != i10) {
            this.f20472n = i10;
            r(getMeasuredWidth(), getMeasuredHeight());
        }
    }

    public void setIconPadding(int i10) {
        if (this.f20469k != i10) {
            this.f20469k = i10;
            setCompoundDrawablePadding(i10);
        }
    }

    public void setIconResource(int i10) {
        setIcon(i10 != 0 ? C4027a.b(getContext(), i10) : null);
    }

    public void setIconSize(int i10) {
        if (i10 < 0) {
            throw new IllegalArgumentException("iconSize cannot be less than 0");
        }
        if (this.f20466h != i10) {
            this.f20466h = i10;
            q(true);
        }
    }

    public void setIconTint(ColorStateList colorStateList) {
        if (this.f20463e != colorStateList) {
            this.f20463e = colorStateList;
            q(false);
        }
    }

    public void setIconTintMode(PorterDuff.Mode mode) {
        if (this.f20462d != mode) {
            this.f20462d = mode;
            q(false);
        }
    }

    public void setIconTintResource(int i10) {
        setIconTint(C4027a.a(getContext(), i10));
    }

    public void setInsetBottom(int i10) {
        this.f20459a.A(i10);
    }

    public void setInsetTop(int i10) {
        this.f20459a.B(i10);
    }

    public void setInternalBackground(Drawable drawable) {
        super.setBackgroundDrawable(drawable);
    }

    public void setOnPressedChangeListenerInternal(c cVar) {
        this.f20461c = cVar;
    }

    public void setOpticalCenterEnabled(boolean z10) {
        if (this.f20478t != z10) {
            this.f20478t = z10;
            if (z10) {
                this.f20459a.y(new h.d() { // from class: com.google.android.material.button.a
                    @Override // Z2.h.d
                    public final void a(float f10) {
                        MaterialButton.b(this.f20493a, f10);
                    }
                });
            } else {
                this.f20459a.y(null);
            }
            post(new Runnable() { // from class: com.google.android.material.button.b
                @Override // java.lang.Runnable
                public final void run() {
                    MaterialButton.a(this.f20494a);
                }
            });
        }
    }

    @Override // android.view.View
    public void setPressed(boolean z10) {
        c cVar = this.f20461c;
        if (cVar != null) {
            cVar.a(this, z10);
        }
        super.setPressed(z10);
        n(false);
    }

    public void setRippleColor(ColorStateList colorStateList) {
        if (m()) {
            this.f20459a.C(colorStateList);
        }
    }

    public void setRippleColorResource(int i10) {
        if (m()) {
            setRippleColor(C4027a.a(getContext(), i10));
        }
    }

    @Override // Z2.o
    public void setShapeAppearanceModel(l lVar) {
        if (!m()) {
            throw new IllegalStateException("Attempted to set ShapeAppearanceModel on a MaterialButton which has an overwritten background.");
        }
        this.f20459a.D(lVar);
    }

    public void setShouldDrawSurfaceColorStroke(boolean z10) {
        if (m()) {
            this.f20459a.E(z10);
        }
    }

    public void setSizeChange(StateListSizeChange stateListSizeChange) {
        if (this.f20482x != stateListSizeChange) {
            this.f20482x = stateListSizeChange;
            n(true);
        }
    }

    public void setStateListShapeAppearanceModel(s sVar) {
        if (!m()) {
            throw new IllegalStateException("Attempted to set StateListShapeAppearanceModel on a MaterialButton which has an overwritten background.");
        }
        if (this.f20459a.c() == null && sVar.f()) {
            this.f20459a.z(e());
        }
        this.f20459a.F(sVar);
    }

    public void setStrokeColor(ColorStateList colorStateList) {
        if (m()) {
            this.f20459a.G(colorStateList);
        }
    }

    public void setStrokeColorResource(int i10) {
        if (m()) {
            setStrokeColor(C4027a.a(getContext(), i10));
        }
    }

    public void setStrokeWidth(int i10) {
        if (m()) {
            this.f20459a.H(i10);
        }
    }

    public void setStrokeWidthResource(int i10) {
        if (m()) {
            setStrokeWidth(getResources().getDimensionPixelSize(i10));
        }
    }

    @Override // androidx.appcompat.widget.AppCompatButton
    public void setSupportBackgroundTintList(ColorStateList colorStateList) {
        if (m()) {
            this.f20459a.I(colorStateList);
        } else {
            super.setSupportBackgroundTintList(colorStateList);
        }
    }

    @Override // androidx.appcompat.widget.AppCompatButton
    public void setSupportBackgroundTintMode(PorterDuff.Mode mode) {
        if (m()) {
            this.f20459a.J(mode);
        } else {
            super.setSupportBackgroundTintMode(mode);
        }
    }

    @Override // android.view.View
    public void setTextAlignment(int i10) {
        super.setTextAlignment(i10);
        r(getMeasuredWidth(), getMeasuredHeight());
    }

    public void setToggleCheckedStateOnClick(boolean z10) {
        this.f20459a.K(z10);
    }

    @Override // android.widget.TextView
    public void setWidth(int i10) {
        this.f20474p = -1.0f;
        super.setWidth(i10);
    }

    public void setWidthChangeMax(int i10) {
        if (this.f20483y != i10) {
            this.f20483y = i10;
            n(true);
        }
    }

    @Override // android.widget.Checkable
    public void toggle() {
        setChecked(!this.f20470l);
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public MaterialButton(Context context, AttributeSet attributeSet, int i10) {
        int i11 = f20454E;
        super(C3953a.e(context, attributeSet, i10, i11, new int[]{f20455F}), attributeSet, i10);
        this.f20460b = new LinkedHashSet<>();
        this.f20470l = false;
        this.f20471m = false;
        this.f20473o = -1;
        this.f20474p = -1.0f;
        this.f20475q = -1;
        this.f20476r = -1;
        this.f20481w = -1;
        Context context2 = getContext();
        TypedArray typedArrayI = r.i(context2, attributeSet, R$styleable.MaterialButton, i10, i11, new int[0]);
        this.f20469k = typedArrayI.getDimensionPixelSize(R$styleable.MaterialButton_iconPadding, 0);
        this.f20462d = u.i(typedArrayI.getInt(R$styleable.MaterialButton_iconTintMode, -1), PorterDuff.Mode.SRC_IN);
        this.f20463e = W2.c.a(getContext(), typedArrayI, R$styleable.MaterialButton_iconTint);
        this.f20464f = W2.c.d(getContext(), typedArrayI, R$styleable.MaterialButton_icon);
        this.f20472n = typedArrayI.getInteger(R$styleable.MaterialButton_iconGravity, 1);
        this.f20466h = typedArrayI.getDimensionPixelSize(R$styleable.MaterialButton_iconSize, 0);
        s sVarB = s.b(context2, typedArrayI, R$styleable.MaterialButton_shapeAppearance);
        l lVarC = sVarB != null ? sVarB.c(true) : l.e(context2, attributeSet, i10, i11).m();
        boolean z10 = typedArrayI.getBoolean(R$styleable.MaterialButton_opticalCenterEnabled, false);
        e eVar = new e(this, lVarC);
        this.f20459a = eVar;
        eVar.t(typedArrayI);
        setCheckedInternal(typedArrayI.getBoolean(R$styleable.MaterialButton_android_checked, false));
        if (sVarB != null) {
            eVar.z(e());
            eVar.F(sVarB);
        }
        setOpticalCenterEnabled(z10);
        typedArrayI.recycle();
        setCompoundDrawablePadding(this.f20469k);
        q(this.f20464f != null);
    }
}
