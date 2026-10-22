package com.google.android.material.checkbox;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.drawable.AnimatedStateListDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.LayerDrawable;
import android.os.Parcelable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.view.accessibility.AccessibilityNodeInfo;
import android.view.autofill.AutofillManager;
import android.widget.CompoundButton;
import androidx.annotation.DrawableRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.annotation.StringRes;
import androidx.appcompat.content.res.AppCompatResources;
import androidx.appcompat.widget.AppCompatCheckBox;
import androidx.appcompat.widget.TintTypedArray;
import androidx.appfunctions.internal.AppSearchAppFunctionReader;
import androidx.core.graphics.drawable.DrawableCompat;
import androidx.core.widget.CompoundButtonCompat;
import androidx.vectordrawable.graphics.drawable.AnimatedVectorDrawableCompat;
import c3.AbstractC0872b;
import c3.AbstractC0873c;
import com.google.android.material.internal.k;
import com.google.android.material.internal.o;
import com.stepos.ability.R;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedHashSet;

/* loaded from: classes3.dex */
public final class c extends AppCompatCheckBox {
    public static final int[] u = {R.attr.state_indeterminate};

    /* renamed from: v, reason: collision with root package name */
    public static final int[] f2380v = {R.attr.state_error};

    /* renamed from: w, reason: collision with root package name */
    public static final int[][] f2381w = {new int[]{android.R.attr.state_enabled, R.attr.state_error}, new int[]{android.R.attr.state_enabled, android.R.attr.state_checked}, new int[]{android.R.attr.state_enabled, -16842912}, new int[]{-16842910, android.R.attr.state_checked}, new int[]{-16842910, -16842912}};

    /* renamed from: x, reason: collision with root package name */
    public static final int f2382x = Resources.getSystem().getIdentifier("btn_check_material_anim", "drawable", AppSearchAppFunctionReader.SYSTEM_PACKAGE_NAME);

    /* renamed from: a, reason: collision with root package name */
    public final LinkedHashSet f2383a;
    public final LinkedHashSet b;
    public ColorStateList c;
    public boolean d;
    public boolean e;
    public boolean f;
    public CharSequence g;
    public Drawable h;
    public Drawable i;

    /* renamed from: j, reason: collision with root package name */
    public boolean f2384j;
    public ColorStateList k;
    public ColorStateList l;
    public PorterDuff.Mode m;
    public int n;
    public int[] o;
    public boolean p;

    /* renamed from: q, reason: collision with root package name */
    public CharSequence f2385q;

    /* renamed from: r, reason: collision with root package name */
    public CompoundButton.OnCheckedChangeListener f2386r;

    /* renamed from: s, reason: collision with root package name */
    public final AnimatedVectorDrawableCompat f2387s;

    /* renamed from: t, reason: collision with root package name */
    public final a f2388t;

    /* JADX WARN: Illegal instructions before constructor call */
    public c(Context context, AttributeSet attributeSet) {
        int i = androidx.appcompat.R.attr.checkboxStyle;
        super(i3.a.a(context, attributeSet, i, R.style.Widget_MaterialComponents_CompoundButton_CheckBox), attributeSet, i);
        this.f2383a = new LinkedHashSet();
        this.b = new LinkedHashSet();
        this.f2387s = AnimatedVectorDrawableCompat.create(getContext(), R.drawable.mtrl_checkbox_button_checked_unchecked);
        this.f2388t = new a(this);
        Context context2 = getContext();
        this.h = CompoundButtonCompat.getButtonDrawable(this);
        this.k = getSuperButtonTintList();
        setSupportButtonTintList(null);
        k.a(context2, attributeSet, i, R.style.Widget_MaterialComponents_CompoundButton_CheckBox);
        int[] iArr = P2.a.f1079t;
        k.b(context2, attributeSet, iArr, i, R.style.Widget_MaterialComponents_CompoundButton_CheckBox, new int[0]);
        TintTypedArray tintTypedArrayObtainStyledAttributes = TintTypedArray.obtainStyledAttributes(context2, attributeSet, iArr, i, R.style.Widget_MaterialComponents_CompoundButton_CheckBox);
        this.i = tintTypedArrayObtainStyledAttributes.getDrawable(2);
        if (this.h != null && AbstractC0872b.b(context2, R.attr.isMaterial3Theme, false)) {
            int resourceId = tintTypedArrayObtainStyledAttributes.getResourceId(0, 0);
            int resourceId2 = tintTypedArrayObtainStyledAttributes.getResourceId(1, 0);
            if (resourceId == f2382x && resourceId2 == 0) {
                super.setButtonDrawable((Drawable) null);
                this.h = AppCompatResources.getDrawable(context2, R.drawable.mtrl_checkbox_button);
                this.f2384j = true;
                if (this.i == null) {
                    this.i = AppCompatResources.getDrawable(context2, R.drawable.mtrl_checkbox_button_icon);
                }
            }
        }
        this.l = AbstractC0873c.b(context2, tintTypedArrayObtainStyledAttributes, 3);
        this.m = o.b(tintTypedArrayObtainStyledAttributes.getInt(4, -1), PorterDuff.Mode.SRC_IN);
        this.d = tintTypedArrayObtainStyledAttributes.getBoolean(10, false);
        this.e = tintTypedArrayObtainStyledAttributes.getBoolean(6, true);
        this.f = tintTypedArrayObtainStyledAttributes.getBoolean(9, false);
        this.g = tintTypedArrayObtainStyledAttributes.getText(8);
        if (tintTypedArrayObtainStyledAttributes.hasValue(7)) {
            setCheckedState(tintTypedArrayObtainStyledAttributes.getInt(7, 0));
        }
        tintTypedArrayObtainStyledAttributes.recycle();
        a();
    }

    @NonNull
    private String getButtonStateDescription() {
        int i = this.n;
        return i == 1 ? getResources().getString(R.string.mtrl_checkbox_state_description_checked) : i == 0 ? getResources().getString(R.string.mtrl_checkbox_state_description_unchecked) : getResources().getString(R.string.mtrl_checkbox_state_description_indeterminate);
    }

    private ColorStateList getMaterialThemeColorsTintList() {
        if (this.c == null) {
            int iA = W2.a.a(androidx.appcompat.R.attr.colorControlActivated, this);
            int iA2 = W2.a.a(androidx.appcompat.R.attr.colorError, this);
            int iA3 = W2.a.a(R.attr.colorSurface, this);
            int iA4 = W2.a.a(R.attr.colorOnSurface, this);
            this.c = new ColorStateList(f2381w, new int[]{W2.a.c(1.0f, iA3, iA2), W2.a.c(1.0f, iA3, iA), W2.a.c(0.54f, iA3, iA4), W2.a.c(0.38f, iA3, iA4), W2.a.c(0.38f, iA3, iA4)});
        }
        return this.c;
    }

    @Nullable
    private ColorStateList getSuperButtonTintList() {
        ColorStateList colorStateList = this.k;
        return colorStateList != null ? colorStateList : super.getButtonTintList() != null ? super.getButtonTintList() : getSupportButtonTintList();
    }

    public final void a() {
        ColorStateList colorStateList;
        ColorStateList colorStateList2;
        Drawable drawableMutate = this.h;
        ColorStateList colorStateList3 = this.k;
        PorterDuff.Mode buttonTintMode = CompoundButtonCompat.getButtonTintMode(this);
        Drawable drawableMutate2 = null;
        if (drawableMutate == null) {
            drawableMutate = null;
        } else if (colorStateList3 != null) {
            drawableMutate = DrawableCompat.wrap(drawableMutate).mutate();
            if (buttonTintMode != null) {
                drawableMutate.setTintMode(buttonTintMode);
            }
        }
        this.h = drawableMutate;
        Drawable drawable = this.i;
        ColorStateList colorStateList4 = this.l;
        PorterDuff.Mode mode = this.m;
        if (drawable != null) {
            if (colorStateList4 != null) {
                drawableMutate2 = DrawableCompat.wrap(drawable).mutate();
                if (mode != null) {
                    drawableMutate2.setTintMode(mode);
                }
            } else {
                drawableMutate2 = drawable;
            }
        }
        this.i = drawableMutate2;
        if (this.f2384j) {
            AnimatedVectorDrawableCompat animatedVectorDrawableCompat = this.f2387s;
            if (animatedVectorDrawableCompat != null) {
                a aVar = this.f2388t;
                animatedVectorDrawableCompat.unregisterAnimationCallback(aVar);
                animatedVectorDrawableCompat.registerAnimationCallback(aVar);
            }
            Drawable drawable2 = this.h;
            if ((drawable2 instanceof AnimatedStateListDrawable) && animatedVectorDrawableCompat != null) {
                ((AnimatedStateListDrawable) drawable2).addTransition(R.id.checked, R.id.unchecked, animatedVectorDrawableCompat, false);
                ((AnimatedStateListDrawable) this.h).addTransition(R.id.indeterminate, R.id.unchecked, animatedVectorDrawableCompat, false);
            }
        }
        Drawable drawable3 = this.h;
        if (drawable3 != null && (colorStateList2 = this.k) != null) {
            drawable3.setTintList(colorStateList2);
        }
        Drawable drawable4 = this.i;
        if (drawable4 != null && (colorStateList = this.l) != null) {
            drawable4.setTintList(colorStateList);
        }
        Drawable drawable5 = this.h;
        Drawable drawable6 = this.i;
        if (drawable5 == null) {
            drawable5 = drawable6;
        } else if (drawable6 != null) {
            int intrinsicWidth = drawable6.getIntrinsicWidth();
            if (intrinsicWidth == -1) {
                intrinsicWidth = drawable5.getIntrinsicWidth();
            }
            int intrinsicHeight = drawable6.getIntrinsicHeight();
            if (intrinsicHeight == -1) {
                intrinsicHeight = drawable5.getIntrinsicHeight();
            }
            if (intrinsicWidth > drawable5.getIntrinsicWidth() || intrinsicHeight > drawable5.getIntrinsicHeight()) {
                float f = intrinsicWidth / intrinsicHeight;
                if (f >= drawable5.getIntrinsicWidth() / drawable5.getIntrinsicHeight()) {
                    int intrinsicWidth2 = drawable5.getIntrinsicWidth();
                    intrinsicHeight = (int) (intrinsicWidth2 / f);
                    intrinsicWidth = intrinsicWidth2;
                } else {
                    intrinsicHeight = drawable5.getIntrinsicHeight();
                    intrinsicWidth = (int) (f * intrinsicHeight);
                }
            }
            LayerDrawable layerDrawable = new LayerDrawable(new Drawable[]{drawable5, drawable6});
            layerDrawable.setLayerSize(1, intrinsicWidth, intrinsicHeight);
            layerDrawable.setLayerGravity(1, 17);
            drawable5 = layerDrawable;
        }
        super.setButtonDrawable(drawable5);
        refreshDrawableState();
    }

    @Override // android.widget.CompoundButton
    @Nullable
    public Drawable getButtonDrawable() {
        return this.h;
    }

    @Nullable
    public Drawable getButtonIconDrawable() {
        return this.i;
    }

    @Nullable
    public ColorStateList getButtonIconTintList() {
        return this.l;
    }

    @NonNull
    public PorterDuff.Mode getButtonIconTintMode() {
        return this.m;
    }

    @Override // android.widget.CompoundButton
    @Nullable
    public ColorStateList getButtonTintList() {
        return this.k;
    }

    public int getCheckedState() {
        return this.n;
    }

    @Nullable
    public CharSequence getErrorAccessibilityLabel() {
        return this.g;
    }

    @Override // android.widget.CompoundButton, android.widget.Checkable
    public final boolean isChecked() {
        return this.n == 1;
    }

    @Override // android.widget.TextView, android.view.View
    public final void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (this.d && this.k == null && this.l == null) {
            setUseMaterialThemeColors(true);
        }
    }

    @Override // android.widget.CompoundButton, android.widget.TextView, android.view.View
    public final int[] onCreateDrawableState(int i) {
        int[] iArrCopyOf;
        int[] iArrOnCreateDrawableState = super.onCreateDrawableState(i + 2);
        if (getCheckedState() == 2) {
            View.mergeDrawableStates(iArrOnCreateDrawableState, u);
        }
        if (this.f) {
            View.mergeDrawableStates(iArrOnCreateDrawableState, f2380v);
        }
        int i6 = 0;
        while (true) {
            if (i6 >= iArrOnCreateDrawableState.length) {
                iArrCopyOf = Arrays.copyOf(iArrOnCreateDrawableState, iArrOnCreateDrawableState.length + 1);
                iArrCopyOf[iArrOnCreateDrawableState.length] = 16842912;
                break;
            }
            int i10 = iArrOnCreateDrawableState[i6];
            if (i10 == 16842912) {
                iArrCopyOf = iArrOnCreateDrawableState;
                break;
            }
            if (i10 == 0) {
                iArrCopyOf = (int[]) iArrOnCreateDrawableState.clone();
                iArrCopyOf[i6] = 16842912;
                break;
            }
            i6++;
        }
        this.o = iArrCopyOf;
        return iArrOnCreateDrawableState;
    }

    @Override // android.widget.CompoundButton, android.widget.TextView, android.view.View
    public final void onDraw(Canvas canvas) {
        Drawable buttonDrawable;
        if (!this.e || !TextUtils.isEmpty(getText()) || (buttonDrawable = CompoundButtonCompat.getButtonDrawable(this)) == null) {
            super.onDraw(canvas);
            return;
        }
        int width = ((getWidth() - buttonDrawable.getIntrinsicWidth()) / 2) * (getLayoutDirection() == 1 ? -1 : 1);
        int iSave = canvas.save();
        canvas.translate(width, 0.0f);
        super.onDraw(canvas);
        canvas.restoreToCount(iSave);
        if (getBackground() != null) {
            Rect bounds = buttonDrawable.getBounds();
            getBackground().setHotspotBounds(bounds.left + width, bounds.top, bounds.right + width, bounds.bottom);
        }
    }

    @Override // android.view.View
    public final void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo accessibilityNodeInfo) {
        super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
        if (accessibilityNodeInfo != null && this.f) {
            accessibilityNodeInfo.setText(((Object) accessibilityNodeInfo.getText()) + ", " + ((Object) this.g));
        }
    }

    @Override // android.widget.CompoundButton, android.widget.TextView, android.view.View
    public final void onRestoreInstanceState(Parcelable parcelable) {
        if (!(parcelable instanceof MaterialCheckBox$SavedState)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        MaterialCheckBox$SavedState materialCheckBox$SavedState = (MaterialCheckBox$SavedState) parcelable;
        super.onRestoreInstanceState(materialCheckBox$SavedState.getSuperState());
        setCheckedState(materialCheckBox$SavedState.checkedState);
    }

    @Override // android.widget.CompoundButton, android.widget.TextView, android.view.View
    public final Parcelable onSaveInstanceState() {
        MaterialCheckBox$SavedState materialCheckBox$SavedState = new MaterialCheckBox$SavedState(super.onSaveInstanceState());
        materialCheckBox$SavedState.checkedState = getCheckedState();
        return materialCheckBox$SavedState;
    }

    @Override // androidx.appcompat.widget.AppCompatCheckBox, android.widget.CompoundButton
    public void setButtonDrawable(@DrawableRes int i) {
        setButtonDrawable(AppCompatResources.getDrawable(getContext(), i));
    }

    public void setButtonIconDrawable(@Nullable Drawable drawable) {
        this.i = drawable;
        a();
    }

    public void setButtonIconDrawableResource(@DrawableRes int i) {
        setButtonIconDrawable(AppCompatResources.getDrawable(getContext(), i));
    }

    public void setButtonIconTintList(@Nullable ColorStateList colorStateList) {
        if (this.l == colorStateList) {
            return;
        }
        this.l = colorStateList;
        a();
    }

    public void setButtonIconTintMode(@NonNull PorterDuff.Mode mode) {
        if (this.m == mode) {
            return;
        }
        this.m = mode;
        a();
    }

    @Override // android.widget.CompoundButton
    public void setButtonTintList(@Nullable ColorStateList colorStateList) {
        if (this.k == colorStateList) {
            return;
        }
        this.k = colorStateList;
        a();
    }

    @Override // android.widget.CompoundButton
    public void setButtonTintMode(@Nullable PorterDuff.Mode mode) {
        setSupportButtonTintMode(mode);
        a();
    }

    public void setCenterIfNoTextEnabled(boolean z10) {
        this.e = z10;
    }

    @Override // android.widget.CompoundButton, android.widget.Checkable
    public void setChecked(boolean z10) {
        setCheckedState(z10 ? 1 : 0);
    }

    public void setCheckedState(int i) {
        CompoundButton.OnCheckedChangeListener onCheckedChangeListener;
        if (this.n != i) {
            this.n = i;
            super.setChecked(i == 1);
            refreshDrawableState();
            if (this.f2385q == null) {
                super.setStateDescription(getButtonStateDescription());
            }
            if (this.p) {
                return;
            }
            this.p = true;
            LinkedHashSet linkedHashSet = this.b;
            if (linkedHashSet != null) {
                Iterator it = linkedHashSet.iterator();
                if (it.hasNext()) {
                    throw B7.a.f(it);
                }
            }
            if (this.n != 2 && (onCheckedChangeListener = this.f2386r) != null) {
                onCheckedChangeListener.onCheckedChanged(this, isChecked());
            }
            AutofillManager autofillManager = (AutofillManager) getContext().getSystemService(AutofillManager.class);
            if (autofillManager != null) {
                autofillManager.notifyValueChanged(this);
            }
            this.p = false;
        }
    }

    public void setErrorAccessibilityLabel(@Nullable CharSequence charSequence) {
        this.g = charSequence;
    }

    public void setErrorAccessibilityLabelResource(@StringRes int i) {
        setErrorAccessibilityLabel(i != 0 ? getResources().getText(i) : null);
    }

    public void setErrorShown(boolean z10) {
        if (this.f == z10) {
            return;
        }
        this.f = z10;
        refreshDrawableState();
        Iterator it = this.f2383a.iterator();
        if (it.hasNext()) {
            throw B7.a.f(it);
        }
    }

    @Override // android.widget.CompoundButton
    public void setOnCheckedChangeListener(@Nullable CompoundButton.OnCheckedChangeListener onCheckedChangeListener) {
        this.f2386r = onCheckedChangeListener;
    }

    @Override // android.widget.CompoundButton, android.view.View
    @RequiresApi(30)
    public void setStateDescription(@Nullable CharSequence charSequence) {
        this.f2385q = charSequence;
        if (charSequence != null) {
            super.setStateDescription(charSequence);
        } else if (charSequence == null) {
            super.setStateDescription(getButtonStateDescription());
        }
    }

    public void setUseMaterialThemeColors(boolean z10) {
        this.d = z10;
        if (z10) {
            CompoundButtonCompat.setButtonTintList(this, getMaterialThemeColorsTintList());
        } else {
            CompoundButtonCompat.setButtonTintList(this, null);
        }
    }

    @Override // android.widget.CompoundButton, android.widget.Checkable
    public final void toggle() {
        setChecked(!isChecked());
    }

    @Override // androidx.appcompat.widget.AppCompatCheckBox, android.widget.CompoundButton
    public void setButtonDrawable(@Nullable Drawable drawable) {
        this.h = drawable;
        this.f2384j = false;
        a();
    }
}
