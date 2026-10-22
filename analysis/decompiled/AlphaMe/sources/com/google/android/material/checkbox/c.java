package com.google.android.material.checkbox;

import B0.f;
import B0.g;
import C.j;
import C.o;
import Z2.I;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.drawable.AnimatedStateListDrawable;
import android.graphics.drawable.AnimatedVectorDrawable;
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
import androidx.appcompat.widget.C0195d;
import androidx.appcompat.widget.C0232w;
import com.google.android.material.internal.l;
import com.stepos.alphame.R;
import com.stepos.alphame.utils.Property;
import f1.AbstractC0557a;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedHashSet;
import m1.AbstractC0769a;
import p0.C0812b;
import p0.C0813c;
import p0.d;
import p0.e;
import t0.J;

/* loaded from: classes.dex */
public final class c extends C0232w {

    /* renamed from: e, reason: collision with root package name */
    public final LinkedHashSet f10551e;

    /* renamed from: f, reason: collision with root package name */
    public final LinkedHashSet f10552f;

    /* renamed from: g, reason: collision with root package name */
    public ColorStateList f10553g;

    /* renamed from: h, reason: collision with root package name */
    public boolean f10554h;

    /* renamed from: i, reason: collision with root package name */
    public boolean f10555i;

    /* renamed from: j, reason: collision with root package name */
    public boolean f10556j;

    /* renamed from: k, reason: collision with root package name */
    public CharSequence f10557k;

    /* renamed from: l, reason: collision with root package name */
    public Drawable f10558l;

    /* renamed from: m, reason: collision with root package name */
    public Drawable f10559m;

    /* renamed from: n, reason: collision with root package name */
    public boolean f10560n;

    /* renamed from: o, reason: collision with root package name */
    public ColorStateList f10561o;

    /* renamed from: p, reason: collision with root package name */
    public ColorStateList f10562p;

    /* renamed from: q, reason: collision with root package name */
    public PorterDuff.Mode f10563q;

    /* renamed from: r, reason: collision with root package name */
    public int f10564r;

    /* renamed from: s, reason: collision with root package name */
    public int[] f10565s;

    /* renamed from: t, reason: collision with root package name */
    public boolean f10566t;

    /* renamed from: u, reason: collision with root package name */
    public CharSequence f10567u;

    /* renamed from: v, reason: collision with root package name */
    public CompoundButton.OnCheckedChangeListener f10568v;

    /* renamed from: w, reason: collision with root package name */
    public final e f10569w;

    /* renamed from: x, reason: collision with root package name */
    public final a f10570x;

    /* renamed from: y, reason: collision with root package name */
    public static final int[] f10549y = {R.attr.state_indeterminate};

    /* renamed from: z, reason: collision with root package name */
    public static final int[] f10550z = {R.attr.state_error};

    /* renamed from: A, reason: collision with root package name */
    public static final int[][] f10547A = {new int[]{android.R.attr.state_enabled, R.attr.state_error}, new int[]{android.R.attr.state_enabled, android.R.attr.state_checked}, new int[]{android.R.attr.state_enabled, -16842912}, new int[]{-16842910, android.R.attr.state_checked}, new int[]{-16842910, -16842912}};

    /* renamed from: B, reason: collision with root package name */
    public static final int f10548B = Resources.getSystem().getIdentifier("btn_check_material_anim", "drawable", "android");

    public c(Context context, AttributeSet attributeSet) {
        super(C1.a.b(context, attributeSet, R.attr.checkboxStyle, R.style.Widget_MaterialComponents_CompoundButton_CheckBox), attributeSet, R.attr.checkboxStyle);
        this.f10551e = new LinkedHashSet();
        this.f10552f = new LinkedHashSet();
        Context context2 = getContext();
        e eVar = new e(context2);
        Resources resources = context2.getResources();
        Resources.Theme theme = context2.getTheme();
        ThreadLocal threadLocal = o.f272a;
        Drawable drawableA = j.a(resources, R.drawable.mtrl_checkbox_button_checked_unchecked, theme);
        eVar.f13857a = drawableA;
        drawableA.setCallback(eVar.f13856f);
        new d(eVar.f13857a.getConstantState());
        this.f10569w = eVar;
        this.f10570x = new a(this);
        Context context3 = getContext();
        this.f10558l = androidx.core.widget.c.a(this);
        this.f10561o = getSuperButtonTintList();
        setSupportButtonTintList(null);
        int[] iArr = AbstractC0769a.f13553s;
        l.a(context3, attributeSet, R.attr.checkboxStyle, R.style.Widget_MaterialComponents_CompoundButton_CheckBox);
        l.b(context3, attributeSet, iArr, R.attr.checkboxStyle, R.style.Widget_MaterialComponents_CompoundButton_CheckBox, new int[0]);
        android.support.v4.media.session.c cVar = new android.support.v4.media.session.c(context3, context3.obtainStyledAttributes(attributeSet, iArr, R.attr.checkboxStyle, R.style.Widget_MaterialComponents_CompoundButton_CheckBox));
        this.f10559m = cVar.l(2);
        if (this.f10558l != null && AbstractC0557a.W(context3, R.attr.isMaterial3Theme, false)) {
            int iR = cVar.r(0, 0);
            int iR2 = cVar.r(1, 0);
            if (iR == f10548B && iR2 == 0) {
                super.setButtonDrawable((Drawable) null);
                this.f10558l = I.o(context3, R.drawable.mtrl_checkbox_button);
                this.f10560n = true;
                if (this.f10559m == null) {
                    this.f10559m = I.o(context3, R.drawable.mtrl_checkbox_button_icon);
                }
            }
        }
        this.f10562p = f.z(context3, cVar, 3);
        this.f10563q = J.D(cVar.p(4, -1), PorterDuff.Mode.SRC_IN);
        this.f10554h = cVar.g(10, false);
        this.f10555i = cVar.g(6, true);
        this.f10556j = cVar.g(9, false);
        this.f10557k = cVar.u(8);
        if (cVar.v(7)) {
            setCheckedState(cVar.p(7, 0));
        }
        cVar.A();
        a();
    }

    @NonNull
    private String getButtonStateDescription() {
        int i4 = this.f10564r;
        return i4 == 1 ? getResources().getString(R.string.mtrl_checkbox_state_description_checked) : i4 == 0 ? getResources().getString(R.string.mtrl_checkbox_state_description_unchecked) : getResources().getString(R.string.mtrl_checkbox_state_description_indeterminate);
    }

    private ColorStateList getMaterialThemeColorsTintList() {
        if (this.f10553g == null) {
            int iX = AbstractC0557a.x(R.attr.colorControlActivated, this);
            int iX2 = AbstractC0557a.x(R.attr.colorError, this);
            int iX3 = AbstractC0557a.x(R.attr.colorSurface, this);
            int iX4 = AbstractC0557a.x(R.attr.colorOnSurface, this);
            this.f10553g = new ColorStateList(f10547A, new int[]{AbstractC0557a.L(1.0f, iX3, iX2), AbstractC0557a.L(1.0f, iX3, iX), AbstractC0557a.L(0.54f, iX3, iX4), AbstractC0557a.L(0.38f, iX3, iX4), AbstractC0557a.L(0.38f, iX3, iX4)});
        }
        return this.f10553g;
    }

    @Nullable
    private ColorStateList getSuperButtonTintList() {
        ColorStateList colorStateList = this.f10561o;
        return colorStateList != null ? colorStateList : super.getButtonTintList() != null ? super.getButtonTintList() : getSupportButtonTintList();
    }

    public final void a() {
        ColorStateList colorStateList;
        ColorStateList colorStateList2;
        C0195d c0195d;
        Drawable drawableMutate = this.f10558l;
        ColorStateList colorStateList3 = this.f10561o;
        PorterDuff.Mode modeB = androidx.core.widget.b.b(this);
        if (drawableMutate == null) {
            drawableMutate = null;
        } else if (colorStateList3 != null) {
            drawableMutate = drawableMutate.mutate();
            if (modeB != null) {
                drawableMutate.setTintMode(modeB);
            }
        }
        this.f10558l = drawableMutate;
        Drawable drawableMutate2 = this.f10559m;
        ColorStateList colorStateList4 = this.f10562p;
        PorterDuff.Mode mode = this.f10563q;
        if (drawableMutate2 == null) {
            drawableMutate2 = null;
        } else if (colorStateList4 != null) {
            drawableMutate2 = drawableMutate2.mutate();
            if (mode != null) {
                drawableMutate2.setTintMode(mode);
            }
        }
        this.f10559m = drawableMutate2;
        if (this.f10560n) {
            e eVar = this.f10569w;
            if (eVar != null) {
                Drawable drawable = eVar.f13857a;
                a aVar = this.f10570x;
                if (drawable != null) {
                    AnimatedVectorDrawable animatedVectorDrawable = (AnimatedVectorDrawable) drawable;
                    if (aVar.f10545a == null) {
                        aVar.f10545a = new C0812b(aVar);
                    }
                    animatedVectorDrawable.unregisterAnimationCallback(aVar.f10545a);
                }
                ArrayList arrayList = eVar.f13855e;
                C0813c c0813c = eVar.f13852b;
                if (arrayList != null && aVar != null) {
                    arrayList.remove(aVar);
                    if (eVar.f13855e.size() == 0 && (c0195d = eVar.f13854d) != null) {
                        c0813c.f13848b.removeListener(c0195d);
                        eVar.f13854d = null;
                    }
                }
                Drawable drawable2 = eVar.f13857a;
                if (drawable2 != null) {
                    AnimatedVectorDrawable animatedVectorDrawable2 = (AnimatedVectorDrawable) drawable2;
                    if (aVar.f10545a == null) {
                        aVar.f10545a = new C0812b(aVar);
                    }
                    animatedVectorDrawable2.registerAnimationCallback(aVar.f10545a);
                } else if (aVar != null) {
                    if (eVar.f13855e == null) {
                        eVar.f13855e = new ArrayList();
                    }
                    if (!eVar.f13855e.contains(aVar)) {
                        eVar.f13855e.add(aVar);
                        if (eVar.f13854d == null) {
                            eVar.f13854d = new C0195d(2, eVar);
                        }
                        c0813c.f13848b.addListener(eVar.f13854d);
                    }
                }
            }
            Drawable drawable3 = this.f10558l;
            if ((drawable3 instanceof AnimatedStateListDrawable) && eVar != null) {
                ((AnimatedStateListDrawable) drawable3).addTransition(R.id.checked, R.id.unchecked, eVar, false);
                ((AnimatedStateListDrawable) this.f10558l).addTransition(R.id.indeterminate, R.id.unchecked, eVar, false);
            }
        }
        Drawable drawable4 = this.f10558l;
        if (drawable4 != null && (colorStateList2 = this.f10561o) != null) {
            drawable4.setTintList(colorStateList2);
        }
        Drawable drawable5 = this.f10559m;
        if (drawable5 != null && (colorStateList = this.f10562p) != null) {
            drawable5.setTintList(colorStateList);
        }
        Drawable drawable6 = this.f10558l;
        Drawable drawable7 = this.f10559m;
        if (drawable6 == null) {
            drawable6 = drawable7;
        } else if (drawable7 != null) {
            int intrinsicWidth = drawable7.getIntrinsicWidth();
            if (intrinsicWidth == -1) {
                intrinsicWidth = drawable6.getIntrinsicWidth();
            }
            int intrinsicHeight = drawable7.getIntrinsicHeight();
            if (intrinsicHeight == -1) {
                intrinsicHeight = drawable6.getIntrinsicHeight();
            }
            if (intrinsicWidth > drawable6.getIntrinsicWidth() || intrinsicHeight > drawable6.getIntrinsicHeight()) {
                float f4 = intrinsicWidth / intrinsicHeight;
                if (f4 >= drawable6.getIntrinsicWidth() / drawable6.getIntrinsicHeight()) {
                    int intrinsicWidth2 = drawable6.getIntrinsicWidth();
                    intrinsicHeight = (int) (intrinsicWidth2 / f4);
                    intrinsicWidth = intrinsicWidth2;
                } else {
                    intrinsicHeight = drawable6.getIntrinsicHeight();
                    intrinsicWidth = (int) (f4 * intrinsicHeight);
                }
            }
            LayerDrawable layerDrawable = new LayerDrawable(new Drawable[]{drawable6, drawable7});
            layerDrawable.setLayerSize(1, intrinsicWidth, intrinsicHeight);
            layerDrawable.setLayerGravity(1, 17);
            drawable6 = layerDrawable;
        }
        super.setButtonDrawable(drawable6);
        refreshDrawableState();
    }

    @Override // android.widget.CompoundButton
    @Nullable
    public Drawable getButtonDrawable() {
        return this.f10558l;
    }

    @Nullable
    public Drawable getButtonIconDrawable() {
        return this.f10559m;
    }

    @Nullable
    public ColorStateList getButtonIconTintList() {
        return this.f10562p;
    }

    @NonNull
    public PorterDuff.Mode getButtonIconTintMode() {
        return this.f10563q;
    }

    @Override // android.widget.CompoundButton
    @Nullable
    public ColorStateList getButtonTintList() {
        return this.f10561o;
    }

    public int getCheckedState() {
        return this.f10564r;
    }

    @Nullable
    public CharSequence getErrorAccessibilityLabel() {
        return this.f10557k;
    }

    @Override // android.widget.CompoundButton, android.widget.Checkable
    public final boolean isChecked() {
        return this.f10564r == 1;
    }

    @Override // android.widget.TextView, android.view.View
    public final void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (this.f10554h && this.f10561o == null && this.f10562p == null) {
            setUseMaterialThemeColors(true);
        }
    }

    @Override // android.widget.CompoundButton, android.widget.TextView, android.view.View
    public final int[] onCreateDrawableState(int i4) {
        int[] iArrCopyOf;
        int[] iArrOnCreateDrawableState = super.onCreateDrawableState(i4 + 2);
        if (getCheckedState() == 2) {
            View.mergeDrawableStates(iArrOnCreateDrawableState, f10549y);
        }
        if (this.f10556j) {
            View.mergeDrawableStates(iArrOnCreateDrawableState, f10550z);
        }
        int i5 = 0;
        while (true) {
            if (i5 >= iArrOnCreateDrawableState.length) {
                iArrCopyOf = Arrays.copyOf(iArrOnCreateDrawableState, iArrOnCreateDrawableState.length + 1);
                iArrCopyOf[iArrOnCreateDrawableState.length] = 16842912;
                break;
            }
            int i6 = iArrOnCreateDrawableState[i5];
            if (i6 == 16842912) {
                iArrCopyOf = iArrOnCreateDrawableState;
                break;
            }
            if (i6 == 0) {
                iArrCopyOf = (int[]) iArrOnCreateDrawableState.clone();
                iArrCopyOf[i5] = 16842912;
                break;
            }
            i5++;
        }
        this.f10565s = iArrCopyOf;
        return iArrOnCreateDrawableState;
    }

    @Override // android.widget.CompoundButton, android.widget.TextView, android.view.View
    public final void onDraw(Canvas canvas) {
        Drawable drawableA;
        if (!this.f10555i || !TextUtils.isEmpty(getText()) || (drawableA = androidx.core.widget.c.a(this)) == null) {
            super.onDraw(canvas);
            return;
        }
        int width = ((getWidth() - drawableA.getIntrinsicWidth()) / 2) * (getLayoutDirection() == 1 ? -1 : 1);
        int iSave = canvas.save();
        canvas.translate(width, Property.DEFAULT_FLOAT_VALUE);
        super.onDraw(canvas);
        canvas.restoreToCount(iSave);
        if (getBackground() != null) {
            Rect bounds = drawableA.getBounds();
            getBackground().setHotspotBounds(bounds.left + width, bounds.top, bounds.right + width, bounds.bottom);
        }
    }

    @Override // android.view.View
    public final void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo accessibilityNodeInfo) {
        super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
        if (accessibilityNodeInfo != null && this.f10556j) {
            accessibilityNodeInfo.setText(((Object) accessibilityNodeInfo.getText()) + ", " + ((Object) this.f10557k));
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
        setCheckedState(materialCheckBox$SavedState.f10544a);
    }

    @Override // android.widget.CompoundButton, android.widget.TextView, android.view.View
    public final Parcelable onSaveInstanceState() {
        MaterialCheckBox$SavedState materialCheckBox$SavedState = new MaterialCheckBox$SavedState(super.onSaveInstanceState());
        materialCheckBox$SavedState.f10544a = getCheckedState();
        return materialCheckBox$SavedState;
    }

    @Override // androidx.appcompat.widget.C0232w, android.widget.CompoundButton
    public void setButtonDrawable(@DrawableRes int i4) {
        setButtonDrawable(I.o(getContext(), i4));
    }

    public void setButtonIconDrawable(@Nullable Drawable drawable) {
        this.f10559m = drawable;
        a();
    }

    public void setButtonIconDrawableResource(@DrawableRes int i4) {
        setButtonIconDrawable(I.o(getContext(), i4));
    }

    public void setButtonIconTintList(@Nullable ColorStateList colorStateList) {
        if (this.f10562p == colorStateList) {
            return;
        }
        this.f10562p = colorStateList;
        a();
    }

    public void setButtonIconTintMode(@NonNull PorterDuff.Mode mode) {
        if (this.f10563q == mode) {
            return;
        }
        this.f10563q = mode;
        a();
    }

    @Override // android.widget.CompoundButton
    public void setButtonTintList(@Nullable ColorStateList colorStateList) {
        if (this.f10561o == colorStateList) {
            return;
        }
        this.f10561o = colorStateList;
        a();
    }

    @Override // android.widget.CompoundButton
    public void setButtonTintMode(@Nullable PorterDuff.Mode mode) {
        setSupportButtonTintMode(mode);
        a();
    }

    public void setCenterIfNoTextEnabled(boolean z4) {
        this.f10555i = z4;
    }

    @Override // android.widget.CompoundButton, android.widget.Checkable
    public void setChecked(boolean z4) {
        setCheckedState(z4 ? 1 : 0);
    }

    public void setCheckedState(int i4) {
        CompoundButton.OnCheckedChangeListener onCheckedChangeListener;
        if (this.f10564r != i4) {
            this.f10564r = i4;
            super.setChecked(i4 == 1);
            refreshDrawableState();
            if (this.f10567u == null) {
                super.setStateDescription(getButtonStateDescription());
            }
            if (this.f10566t) {
                return;
            }
            this.f10566t = true;
            LinkedHashSet linkedHashSet = this.f10552f;
            if (linkedHashSet != null) {
                Iterator it = linkedHashSet.iterator();
                if (it.hasNext()) {
                    g.y(it.next());
                    throw null;
                }
            }
            if (this.f10564r != 2 && (onCheckedChangeListener = this.f10568v) != null) {
                onCheckedChangeListener.onCheckedChanged(this, isChecked());
            }
            AutofillManager autofillManager = (AutofillManager) getContext().getSystemService(AutofillManager.class);
            if (autofillManager != null) {
                autofillManager.notifyValueChanged(this);
            }
            this.f10566t = false;
        }
    }

    public void setErrorAccessibilityLabel(@Nullable CharSequence charSequence) {
        this.f10557k = charSequence;
    }

    public void setErrorAccessibilityLabelResource(@StringRes int i4) {
        setErrorAccessibilityLabel(i4 != 0 ? getResources().getText(i4) : null);
    }

    public void setErrorShown(boolean z4) {
        if (this.f10556j == z4) {
            return;
        }
        this.f10556j = z4;
        refreshDrawableState();
        Iterator it = this.f10551e.iterator();
        if (it.hasNext()) {
            g.y(it.next());
            throw null;
        }
    }

    @Override // android.widget.CompoundButton
    public void setOnCheckedChangeListener(@Nullable CompoundButton.OnCheckedChangeListener onCheckedChangeListener) {
        this.f10568v = onCheckedChangeListener;
    }

    @Override // android.widget.CompoundButton, android.view.View
    @RequiresApi(30)
    public void setStateDescription(@Nullable CharSequence charSequence) {
        this.f10567u = charSequence;
        if (charSequence != null) {
            super.setStateDescription(charSequence);
        } else if (charSequence == null) {
            super.setStateDescription(getButtonStateDescription());
        }
    }

    public void setUseMaterialThemeColors(boolean z4) {
        this.f10554h = z4;
        if (z4) {
            androidx.core.widget.b.c(this, getMaterialThemeColorsTintList());
        } else {
            androidx.core.widget.b.c(this, null);
        }
    }

    @Override // android.widget.CompoundButton, android.widget.Checkable
    public final void toggle() {
        setChecked(!isChecked());
    }

    @Override // androidx.appcompat.widget.C0232w, android.widget.CompoundButton
    public void setButtonDrawable(@Nullable Drawable drawable) {
        this.f10558l = drawable;
        this.f10560n = false;
        a();
    }
}
