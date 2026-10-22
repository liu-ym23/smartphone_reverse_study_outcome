package com.google.android.material.checkbox;

import android.R;
import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.drawable.AnimatedStateListDrawable;
import android.graphics.drawable.Drawable;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.view.accessibility.AccessibilityNodeInfo;
import android.view.autofill.AutofillManager;
import android.widget.CompoundButton;
import androidx.appcompat.widget.AppCompatCheckBox;
import androidx.appcompat.widget.U;
import com.google.android.material.R$attr;
import com.google.android.material.R$drawable;
import com.google.android.material.R$id;
import com.google.android.material.R$string;
import com.google.android.material.R$style;
import com.google.android.material.R$styleable;
import com.google.android.material.internal.r;
import com.google.android.material.internal.u;
import com.stepos.statsapp.v3.lib.plugin.constants.UxipConstants;
import d3.C3953a;
import f.C4027a;
import java.util.Iterator;
import java.util.LinkedHashSet;

/* loaded from: classes2.dex */
public class MaterialCheckBox extends AppCompatCheckBox {

    /* renamed from: A, reason: collision with root package name */
    public static final int[] f20588A;

    /* renamed from: B, reason: collision with root package name */
    public static final int[][] f20589B;

    /* renamed from: C, reason: collision with root package name */
    @SuppressLint({"DiscouragedApi"})
    public static final int f20590C;

    /* renamed from: y, reason: collision with root package name */
    public static final int f20591y = R$style.Widget_MaterialComponents_CompoundButton_CheckBox;

    /* renamed from: z, reason: collision with root package name */
    public static final int[] f20592z = {R$attr.state_indeterminate};

    /* renamed from: e, reason: collision with root package name */
    public final LinkedHashSet<c> f20593e;

    /* renamed from: f, reason: collision with root package name */
    public final LinkedHashSet<b> f20594f;

    /* renamed from: g, reason: collision with root package name */
    public ColorStateList f20595g;

    /* renamed from: h, reason: collision with root package name */
    public boolean f20596h;

    /* renamed from: i, reason: collision with root package name */
    public boolean f20597i;

    /* renamed from: j, reason: collision with root package name */
    public boolean f20598j;

    /* renamed from: k, reason: collision with root package name */
    public CharSequence f20599k;

    /* renamed from: l, reason: collision with root package name */
    public Drawable f20600l;

    /* renamed from: m, reason: collision with root package name */
    public Drawable f20601m;

    /* renamed from: n, reason: collision with root package name */
    public boolean f20602n;

    /* renamed from: o, reason: collision with root package name */
    public ColorStateList f20603o;

    /* renamed from: p, reason: collision with root package name */
    public ColorStateList f20604p;

    /* renamed from: q, reason: collision with root package name */
    public PorterDuff.Mode f20605q;

    /* renamed from: r, reason: collision with root package name */
    public int f20606r;

    /* renamed from: s, reason: collision with root package name */
    public int[] f20607s;

    /* renamed from: t, reason: collision with root package name */
    public boolean f20608t;

    /* renamed from: u, reason: collision with root package name */
    public CharSequence f20609u;

    /* renamed from: v, reason: collision with root package name */
    public CompoundButton.OnCheckedChangeListener f20610v;

    /* renamed from: w, reason: collision with root package name */
    public final q1.c f20611w;

    /* renamed from: x, reason: collision with root package name */
    public final q1.b f20612x;

    public static class SavedState extends View.BaseSavedState {
        public static final Parcelable.Creator<SavedState> CREATOR = new a();
        int checkedState;

        public class a implements Parcelable.Creator<SavedState> {
            @Override // android.os.Parcelable.Creator
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public SavedState createFromParcel(Parcel parcel) {
                return new SavedState(parcel, null);
            }

            @Override // android.os.Parcelable.Creator
            /* renamed from: b, reason: merged with bridge method [inline-methods] */
            public SavedState[] newArray(int i10) {
                return new SavedState[i10];
            }
        }

        public /* synthetic */ SavedState(Parcel parcel, a aVar) {
            this(parcel);
        }

        private String getCheckedStateString() {
            int i10 = this.checkedState;
            return i10 != 1 ? i10 != 2 ? "unchecked" : "indeterminate" : "checked";
        }

        public String toString() {
            return "MaterialCheckBox.SavedState{" + Integer.toHexString(System.identityHashCode(this)) + " CheckedState=" + getCheckedStateString() + "}";
        }

        @Override // android.view.View.BaseSavedState, android.view.AbsSavedState, android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i10) {
            super.writeToParcel(parcel, i10);
            parcel.writeValue(Integer.valueOf(this.checkedState));
        }

        public SavedState(Parcelable parcelable) {
            super(parcelable);
        }

        private SavedState(Parcel parcel) {
            super(parcel);
            this.checkedState = ((Integer) parcel.readValue(getClass().getClassLoader())).intValue();
        }
    }

    public class a extends q1.b {
        public a() {
        }

        @Override // q1.b
        public void b(Drawable drawable) {
            super.b(drawable);
            ColorStateList colorStateList = MaterialCheckBox.this.f20603o;
            if (colorStateList != null) {
                drawable.setTintList(colorStateList);
            }
        }

        @Override // q1.b
        public void c(Drawable drawable) {
            super.c(drawable);
            MaterialCheckBox materialCheckBox = MaterialCheckBox.this;
            ColorStateList colorStateList = materialCheckBox.f20603o;
            if (colorStateList != null) {
                drawable.setTint(colorStateList.getColorForState(materialCheckBox.f20607s, MaterialCheckBox.this.f20603o.getDefaultColor()));
            }
        }
    }

    public interface b {
        void a(MaterialCheckBox materialCheckBox, int i10);
    }

    public interface c {
        void a(MaterialCheckBox materialCheckBox, boolean z10);
    }

    static {
        int i10 = R$attr.state_error;
        f20588A = new int[]{i10};
        f20589B = new int[][]{new int[]{R.attr.state_enabled, i10}, new int[]{R.attr.state_enabled, R.attr.state_checked}, new int[]{R.attr.state_enabled, -16842912}, new int[]{-16842910, R.attr.state_checked}, new int[]{-16842910, -16842912}};
        f20590C = Resources.getSystem().getIdentifier("btn_check_material_anim", "drawable", UxipConstants.f30662a);
    }

    public MaterialCheckBox(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, androidx.appcompat.R$attr.checkboxStyle);
    }

    private String getButtonStateDescription() {
        int i10 = this.f20606r;
        return i10 == 1 ? getResources().getString(R$string.mtrl_checkbox_state_description_checked) : i10 == 0 ? getResources().getString(R$string.mtrl_checkbox_state_description_unchecked) : getResources().getString(R$string.mtrl_checkbox_state_description_indeterminate);
    }

    private ColorStateList getMaterialThemeColorsTintList() {
        if (this.f20595g == null) {
            int[][] iArr = f20589B;
            int[] iArr2 = new int[iArr.length];
            int iD = M2.a.d(this, androidx.appcompat.R$attr.colorControlActivated);
            int iD2 = M2.a.d(this, androidx.appcompat.R$attr.colorError);
            int iD3 = M2.a.d(this, R$attr.colorSurface);
            int iD4 = M2.a.d(this, R$attr.colorOnSurface);
            iArr2[0] = M2.a.j(iD3, iD2, 1.0f);
            iArr2[1] = M2.a.j(iD3, iD, 1.0f);
            iArr2[2] = M2.a.j(iD3, iD4, 0.54f);
            iArr2[3] = M2.a.j(iD3, iD4, 0.38f);
            iArr2[4] = M2.a.j(iD3, iD4, 0.38f);
            this.f20595g = new ColorStateList(iArr, iArr2);
        }
        return this.f20595g;
    }

    private ColorStateList getSuperButtonTintList() {
        ColorStateList colorStateList = this.f20603o;
        return colorStateList != null ? colorStateList : super.getButtonTintList() != null ? super.getButtonTintList() : getSupportButtonTintList();
    }

    public final boolean c(U u10) {
        return u10.n(R$styleable.MaterialCheckBox_android_button, 0) == f20590C && u10.n(R$styleable.MaterialCheckBox_buttonCompat, 0) == 0;
    }

    public boolean d() {
        return this.f20598j;
    }

    public final void e() {
        this.f20600l = O2.a.c(this.f20600l, this.f20603o, androidx.core.widget.c.c(this));
        this.f20601m = O2.a.c(this.f20601m, this.f20604p, this.f20605q);
        g();
        h();
        super.setButtonDrawable(O2.a.a(this.f20600l, this.f20601m));
        refreshDrawableState();
    }

    public final void f() {
        if (this.f20609u == null) {
            super.setStateDescription(getButtonStateDescription());
        }
    }

    public final void g() {
        q1.c cVar;
        if (this.f20602n) {
            q1.c cVar2 = this.f20611w;
            if (cVar2 != null) {
                cVar2.f(this.f20612x);
                this.f20611w.b(this.f20612x);
            }
            Drawable drawable = this.f20600l;
            if (!(drawable instanceof AnimatedStateListDrawable) || (cVar = this.f20611w) == null) {
                return;
            }
            int i10 = R$id.checked;
            int i11 = R$id.unchecked;
            ((AnimatedStateListDrawable) drawable).addTransition(i10, i11, cVar, false);
            ((AnimatedStateListDrawable) this.f20600l).addTransition(R$id.indeterminate, i11, this.f20611w, false);
        }
    }

    @Override // android.widget.CompoundButton
    public Drawable getButtonDrawable() {
        return this.f20600l;
    }

    public Drawable getButtonIconDrawable() {
        return this.f20601m;
    }

    public ColorStateList getButtonIconTintList() {
        return this.f20604p;
    }

    public PorterDuff.Mode getButtonIconTintMode() {
        return this.f20605q;
    }

    @Override // android.widget.CompoundButton
    public ColorStateList getButtonTintList() {
        return this.f20603o;
    }

    public int getCheckedState() {
        return this.f20606r;
    }

    public CharSequence getErrorAccessibilityLabel() {
        return this.f20599k;
    }

    public final void h() {
        ColorStateList colorStateList;
        ColorStateList colorStateList2;
        Drawable drawable = this.f20600l;
        if (drawable != null && (colorStateList2 = this.f20603o) != null) {
            drawable.setTintList(colorStateList2);
        }
        Drawable drawable2 = this.f20601m;
        if (drawable2 == null || (colorStateList = this.f20604p) == null) {
            return;
        }
        drawable2.setTintList(colorStateList);
    }

    @Override // android.widget.CompoundButton, android.widget.Checkable
    public boolean isChecked() {
        return this.f20606r == 1;
    }

    @Override // android.widget.TextView, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (this.f20596h && this.f20603o == null && this.f20604p == null) {
            setUseMaterialThemeColors(true);
        }
    }

    @Override // android.widget.CompoundButton, android.widget.TextView, android.view.View
    public int[] onCreateDrawableState(int i10) {
        int[] iArrOnCreateDrawableState = super.onCreateDrawableState(i10 + 2);
        if (getCheckedState() == 2) {
            View.mergeDrawableStates(iArrOnCreateDrawableState, f20592z);
        }
        if (d()) {
            View.mergeDrawableStates(iArrOnCreateDrawableState, f20588A);
        }
        this.f20607s = O2.a.e(iArrOnCreateDrawableState);
        return iArrOnCreateDrawableState;
    }

    @Override // android.widget.CompoundButton, android.widget.TextView, android.view.View
    public void onDraw(Canvas canvas) {
        Drawable drawableA;
        if (!this.f20597i || !TextUtils.isEmpty(getText()) || (drawableA = androidx.core.widget.c.a(this)) == null) {
            super.onDraw(canvas);
            return;
        }
        int width = ((getWidth() - drawableA.getIntrinsicWidth()) / 2) * (u.h(this) ? -1 : 1);
        int iSave = canvas.save();
        canvas.translate(width, 0.0f);
        super.onDraw(canvas);
        canvas.restoreToCount(iSave);
        if (getBackground() != null) {
            Rect bounds = drawableA.getBounds();
            getBackground().setHotspotBounds(bounds.left + width, bounds.top, bounds.right + width, bounds.bottom);
        }
    }

    @Override // android.view.View
    public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo accessibilityNodeInfo) {
        super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
        if (accessibilityNodeInfo != null && d()) {
            accessibilityNodeInfo.setText(((Object) accessibilityNodeInfo.getText()) + ", " + ((Object) this.f20599k));
        }
    }

    @Override // android.widget.CompoundButton, android.widget.TextView, android.view.View
    public void onRestoreInstanceState(Parcelable parcelable) {
        if (!(parcelable instanceof SavedState)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        SavedState savedState = (SavedState) parcelable;
        super.onRestoreInstanceState(savedState.getSuperState());
        setCheckedState(savedState.checkedState);
    }

    @Override // android.widget.CompoundButton, android.widget.TextView, android.view.View
    public Parcelable onSaveInstanceState() {
        SavedState savedState = new SavedState(super.onSaveInstanceState());
        savedState.checkedState = getCheckedState();
        return savedState;
    }

    @Override // androidx.appcompat.widget.AppCompatCheckBox, android.widget.CompoundButton
    public void setButtonDrawable(int i10) {
        setButtonDrawable(C4027a.b(getContext(), i10));
    }

    public void setButtonIconDrawable(Drawable drawable) {
        this.f20601m = drawable;
        e();
    }

    public void setButtonIconDrawableResource(int i10) {
        setButtonIconDrawable(C4027a.b(getContext(), i10));
    }

    public void setButtonIconTintList(ColorStateList colorStateList) {
        if (this.f20604p == colorStateList) {
            return;
        }
        this.f20604p = colorStateList;
        e();
    }

    public void setButtonIconTintMode(PorterDuff.Mode mode) {
        if (this.f20605q == mode) {
            return;
        }
        this.f20605q = mode;
        e();
    }

    @Override // android.widget.CompoundButton
    public void setButtonTintList(ColorStateList colorStateList) {
        if (this.f20603o == colorStateList) {
            return;
        }
        this.f20603o = colorStateList;
        e();
    }

    @Override // android.widget.CompoundButton
    public void setButtonTintMode(PorterDuff.Mode mode) {
        setSupportButtonTintMode(mode);
        e();
    }

    public void setCenterIfNoTextEnabled(boolean z10) {
        this.f20597i = z10;
    }

    @Override // android.widget.CompoundButton, android.widget.Checkable
    public void setChecked(boolean z10) {
        setCheckedState(z10 ? 1 : 0);
    }

    public void setCheckedState(int i10) {
        CompoundButton.OnCheckedChangeListener onCheckedChangeListener;
        if (this.f20606r != i10) {
            this.f20606r = i10;
            super.setChecked(i10 == 1);
            refreshDrawableState();
            f();
            if (this.f20608t) {
                return;
            }
            this.f20608t = true;
            LinkedHashSet<b> linkedHashSet = this.f20594f;
            if (linkedHashSet != null) {
                Iterator<b> it = linkedHashSet.iterator();
                while (it.hasNext()) {
                    it.next().a(this, this.f20606r);
                }
            }
            if (this.f20606r != 2 && (onCheckedChangeListener = this.f20610v) != null) {
                onCheckedChangeListener.onCheckedChanged(this, isChecked());
            }
            AutofillManager autofillManager = (AutofillManager) getContext().getSystemService(AutofillManager.class);
            if (autofillManager != null) {
                autofillManager.notifyValueChanged(this);
            }
            this.f20608t = false;
        }
    }

    public void setErrorAccessibilityLabel(CharSequence charSequence) {
        this.f20599k = charSequence;
    }

    public void setErrorAccessibilityLabelResource(int i10) {
        setErrorAccessibilityLabel(i10 != 0 ? getResources().getText(i10) : null);
    }

    public void setErrorShown(boolean z10) {
        if (this.f20598j == z10) {
            return;
        }
        this.f20598j = z10;
        refreshDrawableState();
        Iterator<c> it = this.f20593e.iterator();
        while (it.hasNext()) {
            it.next().a(this, this.f20598j);
        }
    }

    @Override // android.widget.CompoundButton
    public void setOnCheckedChangeListener(CompoundButton.OnCheckedChangeListener onCheckedChangeListener) {
        this.f20610v = onCheckedChangeListener;
    }

    @Override // android.widget.CompoundButton, android.view.View
    public void setStateDescription(CharSequence charSequence) {
        this.f20609u = charSequence;
        if (charSequence == null) {
            f();
        } else {
            super.setStateDescription(charSequence);
        }
    }

    public void setUseMaterialThemeColors(boolean z10) {
        this.f20596h = z10;
        if (z10) {
            androidx.core.widget.c.d(this, getMaterialThemeColorsTintList());
        } else {
            androidx.core.widget.c.d(this, null);
        }
    }

    @Override // android.widget.CompoundButton, android.widget.Checkable
    public void toggle() {
        setChecked(!isChecked());
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public MaterialCheckBox(Context context, AttributeSet attributeSet, int i10) {
        int i11 = f20591y;
        super(C3953a.d(context, attributeSet, i10, i11), attributeSet, i10);
        this.f20593e = new LinkedHashSet<>();
        this.f20594f = new LinkedHashSet<>();
        this.f20611w = q1.c.a(getContext(), R$drawable.mtrl_checkbox_button_checked_unchecked);
        this.f20612x = new a();
        Context context2 = getContext();
        this.f20600l = androidx.core.widget.c.a(this);
        this.f20603o = getSuperButtonTintList();
        setSupportButtonTintList(null);
        U uJ = r.j(context2, attributeSet, R$styleable.MaterialCheckBox, i10, i11, new int[0]);
        this.f20601m = uJ.g(R$styleable.MaterialCheckBox_buttonIcon);
        if (this.f20600l != null && r.g(context2) && c(uJ)) {
            super.setButtonDrawable((Drawable) null);
            this.f20600l = C4027a.b(context2, R$drawable.mtrl_checkbox_button);
            this.f20602n = true;
            if (this.f20601m == null) {
                this.f20601m = C4027a.b(context2, R$drawable.mtrl_checkbox_button_icon);
            }
        }
        this.f20604p = W2.c.b(context2, uJ, R$styleable.MaterialCheckBox_buttonIconTint);
        this.f20605q = u.i(uJ.k(R$styleable.MaterialCheckBox_buttonIconTintMode, -1), PorterDuff.Mode.SRC_IN);
        this.f20596h = uJ.a(R$styleable.MaterialCheckBox_useMaterialThemeColors, false);
        this.f20597i = uJ.a(R$styleable.MaterialCheckBox_centerIfNoTextEnabled, true);
        this.f20598j = uJ.a(R$styleable.MaterialCheckBox_errorShown, false);
        this.f20599k = uJ.p(R$styleable.MaterialCheckBox_errorAccessibilityLabel);
        int i12 = R$styleable.MaterialCheckBox_checkedState;
        if (uJ.s(i12)) {
            setCheckedState(uJ.k(i12, 0));
        }
        uJ.x();
        e();
    }

    @Override // androidx.appcompat.widget.AppCompatCheckBox, android.widget.CompoundButton
    public void setButtonDrawable(Drawable drawable) {
        this.f20600l = drawable;
        this.f20602n = false;
        e();
    }
}
