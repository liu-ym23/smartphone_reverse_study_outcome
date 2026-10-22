package com.google.android.material.checkbox;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.drawable.AnimatedStateListDrawable;
import android.graphics.drawable.AnimatedVectorDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.LayerDrawable;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.View;
import android.view.accessibility.AccessibilityNodeInfo;
import android.view.autofill.AutofillManager;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import androidx.appcompat.widget.f;
import androidx.appcompat.widget.x0;
import androidx.datastore.preferences.protobuf.b1;
import com.google.android.material.internal.i;
import com.google.android.material.internal.m;
import com.stepos.aiengine.R;
import e2.d;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedHashSet;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class MaterialCheckBox extends f {
    public static final int[] B = {R.attr.state_indeterminate};
    public static final int[] C = {R.attr.state_error};
    public static final int[][] D = {new int[]{android.R.attr.state_enabled, R.attr.state_error}, new int[]{android.R.attr.state_enabled, android.R.attr.state_checked}, new int[]{android.R.attr.state_enabled, -16842912}, new int[]{-16842910, android.R.attr.state_checked}, new int[]{-16842910, -16842912}};

    @SuppressLint({"DiscouragedApi"})
    public static final int E = Resources.getSystem().getIdentifier("btn_check_material_anim", "drawable", "android");
    public final a A;

    /* renamed from: e, reason: collision with root package name */
    public final LinkedHashSet<c> f4841e;
    public final LinkedHashSet<b> h;

    /* renamed from: j, reason: collision with root package name */
    public ColorStateList f4842j;

    /* renamed from: k, reason: collision with root package name */
    public boolean f4843k;

    /* renamed from: l, reason: collision with root package name */
    public boolean f4844l;

    /* renamed from: m, reason: collision with root package name */
    public boolean f4845m;

    /* renamed from: n, reason: collision with root package name */
    public CharSequence f4846n;

    /* renamed from: o, reason: collision with root package name */
    public Drawable f4847o;

    /* renamed from: p, reason: collision with root package name */
    public Drawable f4848p;

    /* renamed from: q, reason: collision with root package name */
    public boolean f4849q;
    public ColorStateList r;

    /* renamed from: s, reason: collision with root package name */
    public ColorStateList f4850s;

    /* renamed from: t, reason: collision with root package name */
    public PorterDuff.Mode f4851t;

    /* renamed from: u, reason: collision with root package name */
    public int f4852u;

    /* renamed from: v, reason: collision with root package name */
    public int[] f4853v;

    /* renamed from: w, reason: collision with root package name */
    public boolean f4854w;

    /* renamed from: x, reason: collision with root package name */
    public CharSequence f4855x;

    /* renamed from: y, reason: collision with root package name */
    public CompoundButton.OnCheckedChangeListener f4856y;
    public final d z;

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public static class SavedState extends View.BaseSavedState {
        public static final Parcelable.Creator<SavedState> CREATOR = new a();
        int checkedState;

        /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
        public class a implements Parcelable.Creator<SavedState> {
            @Override // android.os.Parcelable.Creator
            public final SavedState createFromParcel(Parcel parcel) {
                return new SavedState(parcel, null);
            }

            @Override // android.os.Parcelable.Creator
            public final SavedState[] newArray(int i10) {
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
            StringBuilder sb2 = new StringBuilder("MaterialCheckBox.SavedState{");
            sb2.append(Integer.toHexString(System.identityHashCode(this)));
            sb2.append(" CheckedState=");
            return ai.onnxruntime.a.o(sb2, getCheckedStateString(), "}");
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

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public class a extends e2.c {
        public a() {
        }

        @Override // e2.c
        public final void a(Drawable drawable) {
            ColorStateList colorStateList = MaterialCheckBox.this.r;
            if (colorStateList != null) {
                drawable.setTintList(colorStateList);
            }
        }

        @Override // e2.c
        public final void b(Drawable drawable) {
            MaterialCheckBox materialCheckBox = MaterialCheckBox.this;
            ColorStateList colorStateList = materialCheckBox.r;
            if (colorStateList != null) {
                drawable.setTint(colorStateList.getColorForState(materialCheckBox.f4853v, colorStateList.getDefaultColor()));
            }
        }
    }

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public interface b {
        void a();
    }

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public interface c {
        void a();
    }

    public MaterialCheckBox(Context context, AttributeSet attributeSet) throws Resources.NotFoundException {
        super(b5.a.a(context, attributeSet, R.attr.checkboxStyle, R.style.Widget_MaterialComponents_CompoundButton_CheckBox), attributeSet, R.attr.checkboxStyle);
        this.f4841e = new LinkedHashSet<>();
        this.h = new LinkedHashSet<>();
        Context context2 = getContext();
        d dVar = new d(context2, 0);
        Resources resources = context2.getResources();
        Resources.Theme theme = context2.getTheme();
        ThreadLocal<TypedValue> threadLocal = m0.f.f10462a;
        Drawable drawable = resources.getDrawable(R.drawable.mtrl_checkbox_button_checked_unchecked, theme);
        dVar.f8538a = drawable;
        drawable.setCallback(dVar.h);
        new d.c(dVar.f8538a.getConstantState());
        this.z = dVar;
        this.A = new a();
        Context context3 = getContext();
        this.f4847o = getButtonDrawable();
        this.r = getSuperButtonTintList();
        setSupportButtonTintList(null);
        i.a(context3, attributeSet, R.attr.checkboxStyle, R.style.Widget_MaterialComponents_CompoundButton_CheckBox);
        int[] iArr = k4.a.f9913s;
        i.b(context3, attributeSet, iArr, R.attr.checkboxStyle, R.style.Widget_MaterialComponents_CompoundButton_CheckBox, new int[0]);
        TypedArray typedArrayObtainStyledAttributes = context3.obtainStyledAttributes(attributeSet, iArr, R.attr.checkboxStyle, R.style.Widget_MaterialComponents_CompoundButton_CheckBox);
        x0 x0Var = new x0(context3, typedArrayObtainStyledAttributes);
        this.f4848p = x0Var.b(2);
        if (this.f4847o != null && w4.b.b(context3, R.attr.isMaterial3Theme, false)) {
            int resourceId = typedArrayObtainStyledAttributes.getResourceId(0, 0);
            int resourceId2 = typedArrayObtainStyledAttributes.getResourceId(1, 0);
            if (resourceId == E && resourceId2 == 0) {
                super.setButtonDrawable((Drawable) null);
                this.f4847o = b1.L(R.drawable.mtrl_checkbox_button, context3);
                this.f4849q = true;
                if (this.f4848p == null) {
                    this.f4848p = b1.L(R.drawable.mtrl_checkbox_button_icon, context3);
                }
            }
        }
        this.f4850s = w4.c.b(context3, x0Var, 3);
        this.f4851t = m.b(typedArrayObtainStyledAttributes.getInt(4, -1), PorterDuff.Mode.SRC_IN);
        this.f4843k = typedArrayObtainStyledAttributes.getBoolean(10, false);
        this.f4844l = typedArrayObtainStyledAttributes.getBoolean(6, true);
        this.f4845m = typedArrayObtainStyledAttributes.getBoolean(9, false);
        this.f4846n = typedArrayObtainStyledAttributes.getText(8);
        if (typedArrayObtainStyledAttributes.hasValue(7)) {
            setCheckedState(typedArrayObtainStyledAttributes.getInt(7, 0));
        }
        x0Var.f();
        b();
    }

    private String getButtonStateDescription() {
        int i10 = this.f4852u;
        return i10 == 1 ? getResources().getString(R.string.mtrl_checkbox_state_description_checked) : i10 == 0 ? getResources().getString(R.string.mtrl_checkbox_state_description_unchecked) : getResources().getString(R.string.mtrl_checkbox_state_description_indeterminate);
    }

    private ColorStateList getMaterialThemeColorsTintList() {
        if (this.f4842j == null) {
            int iS = jd.b.s(R.attr.colorControlActivated, this);
            int iS2 = jd.b.s(R.attr.colorError, this);
            int iS3 = jd.b.s(R.attr.colorSurface, this);
            int iS4 = jd.b.s(R.attr.colorOnSurface, this);
            this.f4842j = new ColorStateList(D, new int[]{jd.b.C(1.0f, iS3, iS2), jd.b.C(1.0f, iS3, iS), jd.b.C(0.54f, iS3, iS4), jd.b.C(0.38f, iS3, iS4), jd.b.C(0.38f, iS3, iS4)});
        }
        return this.f4842j;
    }

    private ColorStateList getSuperButtonTintList() {
        ColorStateList colorStateList = this.r;
        return colorStateList != null ? colorStateList : super.getButtonTintList() != null ? super.getButtonTintList() : getSupportButtonTintList();
    }

    public final void b() {
        ColorStateList colorStateList;
        ColorStateList colorStateList2;
        com.google.android.material.bottomappbar.a aVar;
        Drawable drawableMutate = this.f4847o;
        ColorStateList colorStateList3 = this.r;
        PorterDuff.Mode buttonTintMode = getButtonTintMode();
        if (drawableMutate == null) {
            drawableMutate = null;
        } else if (colorStateList3 != null) {
            drawableMutate = drawableMutate.mutate();
            if (buttonTintMode != null) {
                drawableMutate.setTintMode(buttonTintMode);
            }
        }
        this.f4847o = drawableMutate;
        Drawable drawableMutate2 = this.f4848p;
        ColorStateList colorStateList4 = this.f4850s;
        PorterDuff.Mode mode = this.f4851t;
        if (drawableMutate2 == null) {
            drawableMutate2 = null;
        } else if (colorStateList4 != null) {
            drawableMutate2 = drawableMutate2.mutate();
            if (mode != null) {
                drawableMutate2.setTintMode(mode);
            }
        }
        this.f4848p = drawableMutate2;
        if (this.f4849q) {
            d dVar = this.z;
            if (dVar != null) {
                d.b bVar = dVar.f8528b;
                Drawable drawable = dVar.f8538a;
                a aVar2 = this.A;
                if (drawable != null) {
                    AnimatedVectorDrawable animatedVectorDrawable = (AnimatedVectorDrawable) drawable;
                    if (aVar2.f8527a == null) {
                        aVar2.f8527a = new e2.b(aVar2);
                    }
                    animatedVectorDrawable.unregisterAnimationCallback(aVar2.f8527a);
                }
                ArrayList<e2.c> arrayList = dVar.f8531e;
                if (arrayList != null && aVar2 != null) {
                    arrayList.remove(aVar2);
                    if (dVar.f8531e.size() == 0 && (aVar = dVar.f8530d) != null) {
                        bVar.f8534b.removeListener(aVar);
                        dVar.f8530d = null;
                    }
                }
                Drawable drawable2 = dVar.f8538a;
                if (drawable2 != null) {
                    AnimatedVectorDrawable animatedVectorDrawable2 = (AnimatedVectorDrawable) drawable2;
                    if (aVar2.f8527a == null) {
                        aVar2.f8527a = new e2.b(aVar2);
                    }
                    animatedVectorDrawable2.registerAnimationCallback(aVar2.f8527a);
                } else if (aVar2 != null) {
                    if (dVar.f8531e == null) {
                        dVar.f8531e = new ArrayList<>();
                    }
                    if (!dVar.f8531e.contains(aVar2)) {
                        dVar.f8531e.add(aVar2);
                        if (dVar.f8530d == null) {
                            dVar.f8530d = new com.google.android.material.bottomappbar.a(dVar, 2);
                        }
                        bVar.f8534b.addListener(dVar.f8530d);
                    }
                }
            }
            Drawable drawable3 = this.f4847o;
            if ((drawable3 instanceof AnimatedStateListDrawable) && dVar != null) {
                ((AnimatedStateListDrawable) drawable3).addTransition(R.id.checked, R.id.unchecked, dVar, false);
                ((AnimatedStateListDrawable) this.f4847o).addTransition(R.id.indeterminate, R.id.unchecked, dVar, false);
            }
        }
        Drawable drawable4 = this.f4847o;
        if (drawable4 != null && (colorStateList2 = this.r) != null) {
            drawable4.setTintList(colorStateList2);
        }
        Drawable drawable5 = this.f4848p;
        if (drawable5 != null && (colorStateList = this.f4850s) != null) {
            drawable5.setTintList(colorStateList);
        }
        Drawable drawable6 = this.f4847o;
        Drawable drawable7 = this.f4848p;
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
                float f8 = intrinsicWidth / intrinsicHeight;
                if (f8 >= drawable6.getIntrinsicWidth() / drawable6.getIntrinsicHeight()) {
                    int intrinsicWidth2 = drawable6.getIntrinsicWidth();
                    intrinsicHeight = (int) (intrinsicWidth2 / f8);
                    intrinsicWidth = intrinsicWidth2;
                } else {
                    intrinsicHeight = drawable6.getIntrinsicHeight();
                    intrinsicWidth = (int) (f8 * intrinsicHeight);
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
    public Drawable getButtonDrawable() {
        return this.f4847o;
    }

    public Drawable getButtonIconDrawable() {
        return this.f4848p;
    }

    public ColorStateList getButtonIconTintList() {
        return this.f4850s;
    }

    public PorterDuff.Mode getButtonIconTintMode() {
        return this.f4851t;
    }

    @Override // android.widget.CompoundButton
    public ColorStateList getButtonTintList() {
        return this.r;
    }

    public int getCheckedState() {
        return this.f4852u;
    }

    public CharSequence getErrorAccessibilityLabel() {
        return this.f4846n;
    }

    @Override // android.widget.CompoundButton, android.widget.Checkable
    public final boolean isChecked() {
        return this.f4852u == 1;
    }

    @Override // android.widget.TextView, android.view.View
    public final void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (this.f4843k && this.r == null && this.f4850s == null) {
            setUseMaterialThemeColors(true);
        }
    }

    @Override // android.widget.CompoundButton, android.widget.TextView, android.view.View
    public final int[] onCreateDrawableState(int i10) {
        int[] iArrCopyOf;
        int[] iArrOnCreateDrawableState = super.onCreateDrawableState(i10 + 2);
        if (getCheckedState() == 2) {
            CheckBox.mergeDrawableStates(iArrOnCreateDrawableState, B);
        }
        if (this.f4845m) {
            CheckBox.mergeDrawableStates(iArrOnCreateDrawableState, C);
        }
        int i11 = 0;
        while (true) {
            if (i11 >= iArrOnCreateDrawableState.length) {
                iArrCopyOf = Arrays.copyOf(iArrOnCreateDrawableState, iArrOnCreateDrawableState.length + 1);
                iArrCopyOf[iArrOnCreateDrawableState.length] = 16842912;
                break;
            }
            int i12 = iArrOnCreateDrawableState[i11];
            if (i12 == 16842912) {
                iArrCopyOf = iArrOnCreateDrawableState;
                break;
            }
            if (i12 == 0) {
                iArrCopyOf = (int[]) iArrOnCreateDrawableState.clone();
                iArrCopyOf[i11] = 16842912;
                break;
            }
            i11++;
        }
        this.f4853v = iArrCopyOf;
        return iArrOnCreateDrawableState;
    }

    @Override // android.widget.CompoundButton, android.widget.TextView, android.view.View
    public final void onDraw(Canvas canvas) {
        Drawable buttonDrawable;
        if (!this.f4844l || !TextUtils.isEmpty(getText()) || (buttonDrawable = getButtonDrawable()) == null) {
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
        if (accessibilityNodeInfo != null && this.f4845m) {
            accessibilityNodeInfo.setText(((Object) accessibilityNodeInfo.getText()) + ", " + ((Object) this.f4846n));
        }
    }

    @Override // android.widget.CompoundButton, android.widget.TextView, android.view.View
    public final void onRestoreInstanceState(Parcelable parcelable) {
        if (!(parcelable instanceof SavedState)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        SavedState savedState = (SavedState) parcelable;
        super.onRestoreInstanceState(savedState.getSuperState());
        setCheckedState(savedState.checkedState);
    }

    @Override // android.widget.CompoundButton, android.widget.TextView, android.view.View
    public final Parcelable onSaveInstanceState() {
        SavedState savedState = new SavedState(super.onSaveInstanceState());
        savedState.checkedState = getCheckedState();
        return savedState;
    }

    @Override // androidx.appcompat.widget.f, android.widget.CompoundButton
    public void setButtonDrawable(int i10) {
        setButtonDrawable(b1.L(i10, getContext()));
    }

    public void setButtonIconDrawable(Drawable drawable) {
        this.f4848p = drawable;
        b();
    }

    public void setButtonIconDrawableResource(int i10) {
        setButtonIconDrawable(b1.L(i10, getContext()));
    }

    public void setButtonIconTintList(ColorStateList colorStateList) {
        if (this.f4850s == colorStateList) {
            return;
        }
        this.f4850s = colorStateList;
        b();
    }

    public void setButtonIconTintMode(PorterDuff.Mode mode) {
        if (this.f4851t == mode) {
            return;
        }
        this.f4851t = mode;
        b();
    }

    @Override // android.widget.CompoundButton
    public void setButtonTintList(ColorStateList colorStateList) {
        if (this.r == colorStateList) {
            return;
        }
        this.r = colorStateList;
        b();
    }

    @Override // android.widget.CompoundButton
    public void setButtonTintMode(PorterDuff.Mode mode) {
        setSupportButtonTintMode(mode);
        b();
    }

    public void setCenterIfNoTextEnabled(boolean z) {
        this.f4844l = z;
    }

    @Override // android.widget.CompoundButton, android.widget.Checkable
    public void setChecked(boolean z) {
        setCheckedState(z ? 1 : 0);
    }

    public void setCheckedState(int i10) {
        CompoundButton.OnCheckedChangeListener onCheckedChangeListener;
        if (this.f4852u != i10) {
            this.f4852u = i10;
            super.setChecked(i10 == 1);
            refreshDrawableState();
            if (this.f4855x == null) {
                super.setStateDescription(getButtonStateDescription());
            }
            if (this.f4854w) {
                return;
            }
            this.f4854w = true;
            LinkedHashSet<b> linkedHashSet = this.h;
            if (linkedHashSet != null) {
                Iterator<b> it = linkedHashSet.iterator();
                while (it.hasNext()) {
                    it.next().a();
                }
            }
            if (this.f4852u != 2 && (onCheckedChangeListener = this.f4856y) != null) {
                onCheckedChangeListener.onCheckedChanged(this, isChecked());
            }
            AutofillManager autofillManager = (AutofillManager) getContext().getSystemService(AutofillManager.class);
            if (autofillManager != null) {
                autofillManager.notifyValueChanged(this);
            }
            this.f4854w = false;
        }
    }

    public void setErrorAccessibilityLabel(CharSequence charSequence) {
        this.f4846n = charSequence;
    }

    public void setErrorAccessibilityLabelResource(int i10) {
        setErrorAccessibilityLabel(i10 != 0 ? getResources().getText(i10) : null);
    }

    public void setErrorShown(boolean z) {
        if (this.f4845m == z) {
            return;
        }
        this.f4845m = z;
        refreshDrawableState();
        Iterator<c> it = this.f4841e.iterator();
        while (it.hasNext()) {
            it.next().a();
        }
    }

    @Override // android.widget.CompoundButton
    public void setOnCheckedChangeListener(CompoundButton.OnCheckedChangeListener onCheckedChangeListener) {
        this.f4856y = onCheckedChangeListener;
    }

    @Override // android.widget.CompoundButton, android.view.View
    public void setStateDescription(CharSequence charSequence) {
        this.f4855x = charSequence;
        if (charSequence != null) {
            super.setStateDescription(charSequence);
        } else if (charSequence == null) {
            super.setStateDescription(getButtonStateDescription());
        }
    }

    public void setUseMaterialThemeColors(boolean z) {
        this.f4843k = z;
        if (z) {
            setButtonTintList(getMaterialThemeColorsTintList());
        } else {
            setButtonTintList(null);
        }
    }

    @Override // android.widget.CompoundButton, android.widget.Checkable
    public final void toggle() {
        setChecked(!isChecked());
    }

    @Override // androidx.appcompat.widget.f, android.widget.CompoundButton
    public void setButtonDrawable(Drawable drawable) {
        this.f4847o = drawable;
        this.f4849q = false;
        b();
    }
}
