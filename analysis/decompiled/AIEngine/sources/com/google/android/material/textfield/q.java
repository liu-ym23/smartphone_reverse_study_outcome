package com.google.android.material.textfield;

import android.R;
import android.accessibilityservice.AccessibilityServiceInfo;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.Rect;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.RippleDrawable;
import android.os.Build;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.accessibility.AccessibilityManager;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Filterable;
import android.widget.ListAdapter;
import android.widget.TextView;
import androidx.appcompat.widget.k0;
import java.util.List;
import java.util.Locale;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class q extends androidx.appcompat.widget.c {

    /* renamed from: e, reason: collision with root package name */
    public final k0 f5320e;
    public final AccessibilityManager h;

    /* renamed from: j, reason: collision with root package name */
    public final Rect f5321j;

    /* renamed from: k, reason: collision with root package name */
    public final int f5322k;

    /* renamed from: l, reason: collision with root package name */
    public final float f5323l;

    /* renamed from: m, reason: collision with root package name */
    public ColorStateList f5324m;

    /* renamed from: n, reason: collision with root package name */
    public int f5325n;

    /* renamed from: o, reason: collision with root package name */
    public ColorStateList f5326o;

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public class a<T> extends ArrayAdapter<String> {

        /* renamed from: a, reason: collision with root package name */
        public ColorStateList f5327a;

        /* renamed from: b, reason: collision with root package name */
        public ColorStateList f5328b;

        public a(Context context, int i10, String[] strArr) {
            super(context, i10, strArr);
            b();
        }

        public final void b() {
            ColorStateList colorStateList;
            q qVar = q.this;
            ColorStateList colorStateList2 = qVar.f5326o;
            ColorStateList colorStateList3 = null;
            if (colorStateList2 != null) {
                int[] iArr = {R.attr.state_pressed};
                colorStateList = new ColorStateList(new int[][]{iArr, new int[0]}, new int[]{colorStateList2.getColorForState(iArr, 0), 0});
            } else {
                colorStateList = null;
            }
            this.f5328b = colorStateList;
            if (qVar.f5325n != 0 && qVar.f5326o != null) {
                int[] iArr2 = {R.attr.state_hovered, -16842919};
                int[] iArr3 = {R.attr.state_selected, -16842919};
                colorStateList3 = new ColorStateList(new int[][]{iArr3, iArr2, new int[0]}, new int[]{n0.a.b(qVar.f5326o.getColorForState(iArr3, 0), qVar.f5325n), n0.a.b(qVar.f5326o.getColorForState(iArr2, 0), qVar.f5325n), qVar.f5325n});
            }
            this.f5327a = colorStateList3;
        }

        @Override // android.widget.ArrayAdapter, android.widget.Adapter
        public final View getView(int i10, View view, ViewGroup viewGroup) {
            View view2 = super.getView(i10, view, viewGroup);
            if (view2 instanceof TextView) {
                TextView textView = (TextView) view2;
                q qVar = q.this;
                Drawable rippleDrawable = null;
                if (qVar.getText().toString().contentEquals(textView.getText()) && qVar.f5325n != 0) {
                    ColorDrawable colorDrawable = new ColorDrawable(qVar.f5325n);
                    if (this.f5328b != null) {
                        colorDrawable.setTintList(this.f5327a);
                        rippleDrawable = new RippleDrawable(this.f5328b, colorDrawable, null);
                    } else {
                        rippleDrawable = colorDrawable;
                    }
                }
                textView.setBackground(rippleDrawable);
            }
            return view2;
        }
    }

    public q(Context context, AttributeSet attributeSet) {
        super(b5.a.a(context, attributeSet, com.stepos.aiengine.R.attr.autoCompleteTextViewStyle, 0), attributeSet, 0);
        this.f5321j = new Rect();
        Context context2 = getContext();
        TypedArray typedArrayD = com.google.android.material.internal.i.d(context2, attributeSet, k4.a.f9908m, com.stepos.aiengine.R.attr.autoCompleteTextViewStyle, com.stepos.aiengine.R.style.Widget_AppCompat_AutoCompleteTextView, new int[0]);
        if (typedArrayD.hasValue(0) && typedArrayD.getInt(0, 0) == 0) {
            setKeyListener(null);
        }
        this.f5322k = typedArrayD.getResourceId(3, com.stepos.aiengine.R.layout.mtrl_auto_complete_simple_item);
        this.f5323l = typedArrayD.getDimensionPixelOffset(1, com.stepos.aiengine.R.dimen.mtrl_exposed_dropdown_menu_popup_elevation);
        if (typedArrayD.hasValue(2)) {
            this.f5324m = ColorStateList.valueOf(typedArrayD.getColor(2, 0));
        }
        this.f5325n = typedArrayD.getColor(4, 0);
        this.f5326o = w4.c.a(context2, typedArrayD, 5);
        this.h = (AccessibilityManager) context2.getSystemService("accessibility");
        k0 k0Var = new k0(context2, null, com.stepos.aiengine.R.attr.listPopupWindowStyle, 0);
        this.f5320e = k0Var;
        k0Var.B = true;
        k0Var.C.setFocusable(true);
        k0Var.r = this;
        k0Var.C.setInputMethodMode(2);
        k0Var.setAdapter(getAdapter());
        k0Var.f875s = new p(this);
        if (typedArrayD.hasValue(6)) {
            setSimpleItems(typedArrayD.getResourceId(6, 0));
        }
        typedArrayD.recycle();
    }

    public final TextInputLayout b() {
        for (ViewParent parent = getParent(); parent != null; parent = parent.getParent()) {
            if (parent instanceof TextInputLayout) {
                return (TextInputLayout) parent;
            }
        }
        return null;
    }

    public final boolean c() {
        List<AccessibilityServiceInfo> enabledAccessibilityServiceList;
        AccessibilityManager accessibilityManager = this.h;
        if (accessibilityManager != null && accessibilityManager.isTouchExplorationEnabled()) {
            return true;
        }
        if (accessibilityManager == null || !accessibilityManager.isEnabled() || (enabledAccessibilityServiceList = accessibilityManager.getEnabledAccessibilityServiceList(16)) == null) {
            return false;
        }
        for (AccessibilityServiceInfo accessibilityServiceInfo : enabledAccessibilityServiceList) {
            if (accessibilityServiceInfo.getSettingsActivityName() != null && accessibilityServiceInfo.getSettingsActivityName().contains("SwitchAccess")) {
                return true;
            }
        }
        return false;
    }

    @Override // android.widget.AutoCompleteTextView
    public final void dismissDropDown() {
        if (c()) {
            this.f5320e.dismiss();
        } else {
            super.dismissDropDown();
        }
    }

    public ColorStateList getDropDownBackgroundTintList() {
        return this.f5324m;
    }

    @Override // android.widget.TextView
    public CharSequence getHint() {
        TextInputLayout textInputLayoutB = b();
        return (textInputLayoutB == null || !textInputLayoutB.I) ? super.getHint() : textInputLayoutB.getHint();
    }

    public float getPopupElevation() {
        return this.f5323l;
    }

    public int getSimpleItemSelectedColor() {
        return this.f5325n;
    }

    public ColorStateList getSimpleItemSelectedRippleColor() {
        return this.f5326o;
    }

    @Override // android.widget.AutoCompleteTextView, android.widget.TextView, android.view.View
    public final void onAttachedToWindow() {
        super.onAttachedToWindow();
        TextInputLayout textInputLayoutB = b();
        if (textInputLayoutB != null && textInputLayoutB.I && super.getHint() == null) {
            String str = Build.MANUFACTURER;
            if ((str != null ? str.toLowerCase(Locale.ENGLISH) : "").equals("meizu")) {
                setHint("");
            }
        }
    }

    @Override // android.widget.AutoCompleteTextView, android.view.View
    public final void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.f5320e.dismiss();
    }

    @Override // android.widget.TextView, android.view.View
    public final void onMeasure(int i10, int i11) {
        super.onMeasure(i10, i11);
        if (View.MeasureSpec.getMode(i10) == Integer.MIN_VALUE) {
            int measuredWidth = getMeasuredWidth();
            ListAdapter adapter = getAdapter();
            TextInputLayout textInputLayoutB = b();
            int measuredWidth2 = 0;
            if (adapter != null && textInputLayoutB != null) {
                int iMakeMeasureSpec = View.MeasureSpec.makeMeasureSpec(getMeasuredWidth(), 0);
                int iMakeMeasureSpec2 = View.MeasureSpec.makeMeasureSpec(getMeasuredHeight(), 0);
                k0 k0Var = this.f5320e;
                int iMin = Math.min(adapter.getCount(), Math.max(0, !k0Var.C.isShowing() ? -1 : k0Var.f864c.getSelectedItemPosition()) + 15);
                View view = null;
                int iMax = 0;
                for (int iMax2 = Math.max(0, iMin - 15); iMax2 < iMin; iMax2++) {
                    int itemViewType = adapter.getItemViewType(iMax2);
                    if (itemViewType != measuredWidth2) {
                        view = null;
                        measuredWidth2 = itemViewType;
                    }
                    view = adapter.getView(iMax2, view, textInputLayoutB);
                    if (view.getLayoutParams() == null) {
                        view.setLayoutParams(new ViewGroup.LayoutParams(-2, -2));
                    }
                    view.measure(iMakeMeasureSpec, iMakeMeasureSpec2);
                    iMax = Math.max(iMax, view.getMeasuredWidth());
                }
                Drawable background = k0Var.C.getBackground();
                if (background != null) {
                    Rect rect = this.f5321j;
                    background.getPadding(rect);
                    iMax += rect.left + rect.right;
                }
                measuredWidth2 = textInputLayoutB.getEndIconView().getMeasuredWidth() + iMax;
            }
            setMeasuredDimension(Math.min(Math.max(measuredWidth, measuredWidth2), View.MeasureSpec.getSize(i10)), getMeasuredHeight());
        }
    }

    @Override // android.widget.AutoCompleteTextView, android.widget.TextView, android.view.View
    public final void onWindowFocusChanged(boolean z) {
        if (c()) {
            return;
        }
        super.onWindowFocusChanged(z);
    }

    @Override // android.widget.AutoCompleteTextView
    public <T extends ListAdapter & Filterable> void setAdapter(T t8) {
        super.setAdapter(t8);
        this.f5320e.setAdapter(getAdapter());
    }

    @Override // android.widget.AutoCompleteTextView
    public void setDropDownBackgroundDrawable(Drawable drawable) {
        super.setDropDownBackgroundDrawable(drawable);
        k0 k0Var = this.f5320e;
        if (k0Var != null) {
            k0Var.setBackgroundDrawable(drawable);
        }
    }

    public void setDropDownBackgroundTint(int i10) {
        setDropDownBackgroundTintList(ColorStateList.valueOf(i10));
    }

    public void setDropDownBackgroundTintList(ColorStateList colorStateList) {
        this.f5324m = colorStateList;
        Drawable dropDownBackground = getDropDownBackground();
        if (dropDownBackground instanceof y4.g) {
            ((y4.g) dropDownBackground).n(this.f5324m);
        }
    }

    @Override // android.widget.AutoCompleteTextView
    public void setOnItemSelectedListener(AdapterView.OnItemSelectedListener onItemSelectedListener) {
        super.setOnItemSelectedListener(onItemSelectedListener);
        this.f5320e.f876t = getOnItemSelectedListener();
    }

    @Override // android.widget.TextView
    public void setRawInputType(int i10) {
        super.setRawInputType(i10);
        TextInputLayout textInputLayoutB = b();
        if (textInputLayoutB != null) {
            textInputLayoutB.u();
        }
    }

    public void setSimpleItemSelectedColor(int i10) {
        this.f5325n = i10;
        if (getAdapter() instanceof a) {
            ((a) getAdapter()).b();
        }
    }

    public void setSimpleItemSelectedRippleColor(ColorStateList colorStateList) {
        this.f5326o = colorStateList;
        if (getAdapter() instanceof a) {
            ((a) getAdapter()).b();
        }
    }

    public void setSimpleItems(int i10) {
        setSimpleItems(getResources().getStringArray(i10));
    }

    @Override // android.widget.AutoCompleteTextView
    public final void showDropDown() {
        if (c()) {
            this.f5320e.show();
        } else {
            super.showDropDown();
        }
    }

    public void setSimpleItems(String[] strArr) {
        setAdapter(new a(getContext(), this.f5322k, strArr));
    }
}
