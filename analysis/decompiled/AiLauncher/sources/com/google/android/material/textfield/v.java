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
import androidx.appcompat.R$attr;
import androidx.appcompat.R$style;
import androidx.appcompat.widget.C1290c;
import androidx.appcompat.widget.F;
import com.google.android.material.R$dimen;
import com.google.android.material.R$layout;
import com.google.android.material.R$styleable;
import d3.C3953a;
import java.util.List;

/* loaded from: classes2.dex */
public class v extends C1290c {

    /* renamed from: a, reason: collision with root package name */
    public final F f21678a;

    /* renamed from: b, reason: collision with root package name */
    public final AccessibilityManager f21679b;

    /* renamed from: c, reason: collision with root package name */
    public final Rect f21680c;

    /* renamed from: d, reason: collision with root package name */
    public final int f21681d;

    /* renamed from: e, reason: collision with root package name */
    public final float f21682e;

    /* renamed from: f, reason: collision with root package name */
    public ColorStateList f21683f;

    /* renamed from: g, reason: collision with root package name */
    public int f21684g;

    /* renamed from: h, reason: collision with root package name */
    public ColorStateList f21685h;

    public class a implements AdapterView.OnItemClickListener {
        public a() {
        }

        @Override // android.widget.AdapterView.OnItemClickListener
        public void onItemClick(AdapterView<?> adapterView, View view, int i10, long j10) {
            v vVar = v.this;
            Object objT = i10 < 0 ? vVar.f21678a.t() : vVar.getAdapter().getItem(i10);
            v vVar2 = v.this;
            vVar2.setText(vVar2.convertSelectionToString(objT), false);
            AdapterView.OnItemClickListener onItemClickListener = v.this.getOnItemClickListener();
            if (onItemClickListener != null) {
                if (view == null || i10 < 0) {
                    view = v.this.f21678a.w();
                    i10 = v.this.f21678a.v();
                    j10 = v.this.f21678a.u();
                }
                onItemClickListener.onItemClick(v.this.f21678a.n(), view, i10, j10);
            }
            v.this.f21678a.dismiss();
        }
    }

    public class b<T> extends ArrayAdapter<String> {

        /* renamed from: a, reason: collision with root package name */
        public ColorStateList f21687a;

        /* renamed from: b, reason: collision with root package name */
        public ColorStateList f21688b;

        public b(Context context, int i10, String[] strArr) {
            super(context, i10, strArr);
            f();
        }

        public final ColorStateList a() {
            if (!c() || !d()) {
                return null;
            }
            int[] iArr = {R.attr.state_hovered, -16842919};
            int[] iArr2 = {R.attr.state_selected, -16842919};
            return new ColorStateList(new int[][]{iArr2, iArr, new int[0]}, new int[]{M2.a.i(v.this.f21684g, v.this.f21685h.getColorForState(iArr2, 0)), M2.a.i(v.this.f21684g, v.this.f21685h.getColorForState(iArr, 0)), v.this.f21684g});
        }

        public final Drawable b() {
            if (!c()) {
                return null;
            }
            ColorDrawable colorDrawable = new ColorDrawable(v.this.f21684g);
            if (this.f21688b == null) {
                return colorDrawable;
            }
            colorDrawable.setTintList(this.f21687a);
            return new RippleDrawable(this.f21688b, colorDrawable, null);
        }

        public final boolean c() {
            return v.this.f21684g != 0;
        }

        public final boolean d() {
            return v.this.f21685h != null;
        }

        public final ColorStateList e() {
            if (!d()) {
                return null;
            }
            int[] iArr = {R.attr.state_pressed};
            return new ColorStateList(new int[][]{iArr, new int[0]}, new int[]{v.this.f21685h.getColorForState(iArr, 0), 0});
        }

        public void f() {
            this.f21688b = e();
            this.f21687a = a();
        }

        @Override // android.widget.ArrayAdapter, android.widget.Adapter
        public View getView(int i10, View view, ViewGroup viewGroup) {
            View view2 = super.getView(i10, view, viewGroup);
            if (view2 instanceof TextView) {
                TextView textView = (TextView) view2;
                textView.setBackground(v.this.getText().toString().contentEquals(textView.getText()) ? b() : null);
            }
            return view2;
        }
    }

    public v(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, R$attr.autoCompleteTextViewStyle);
    }

    @Override // android.widget.AutoCompleteTextView
    public void dismissDropDown() {
        if (f()) {
            this.f21678a.dismiss();
        } else {
            super.dismissDropDown();
        }
    }

    public final TextInputLayout e() {
        for (ViewParent parent = getParent(); parent != null; parent = parent.getParent()) {
            if (parent instanceof TextInputLayout) {
                return (TextInputLayout) parent;
            }
        }
        return null;
    }

    public final boolean f() {
        return h() || g();
    }

    public final boolean g() {
        List<AccessibilityServiceInfo> enabledAccessibilityServiceList;
        AccessibilityManager accessibilityManager = this.f21679b;
        if (accessibilityManager != null && accessibilityManager.isEnabled() && (enabledAccessibilityServiceList = this.f21679b.getEnabledAccessibilityServiceList(16)) != null) {
            for (AccessibilityServiceInfo accessibilityServiceInfo : enabledAccessibilityServiceList) {
                if (accessibilityServiceInfo.getSettingsActivityName() != null && accessibilityServiceInfo.getSettingsActivityName().contains("SwitchAccess")) {
                    return true;
                }
            }
        }
        return false;
    }

    public ColorStateList getDropDownBackgroundTintList() {
        return this.f21683f;
    }

    @Override // android.widget.TextView
    public CharSequence getHint() {
        TextInputLayout textInputLayoutE = e();
        return (textInputLayoutE == null || !textInputLayoutE.T()) ? super.getHint() : textInputLayoutE.getHint();
    }

    public float getPopupElevation() {
        return this.f21682e;
    }

    public int getSimpleItemSelectedColor() {
        return this.f21684g;
    }

    public ColorStateList getSimpleItemSelectedRippleColor() {
        return this.f21685h;
    }

    public final boolean h() {
        AccessibilityManager accessibilityManager = this.f21679b;
        return accessibilityManager != null && accessibilityManager.isTouchExplorationEnabled();
    }

    public final int i() {
        ListAdapter adapter = getAdapter();
        TextInputLayout textInputLayoutE = e();
        int i10 = 0;
        if (adapter == null || textInputLayoutE == null) {
            return 0;
        }
        int iMakeMeasureSpec = View.MeasureSpec.makeMeasureSpec(getMeasuredWidth(), 0);
        int iMakeMeasureSpec2 = View.MeasureSpec.makeMeasureSpec(getMeasuredHeight(), 0);
        int iMin = Math.min(adapter.getCount(), Math.max(0, this.f21678a.v()) + 15);
        View view = null;
        int iMax = 0;
        for (int iMax2 = Math.max(0, iMin - 15); iMax2 < iMin; iMax2++) {
            int itemViewType = adapter.getItemViewType(iMax2);
            if (itemViewType != i10) {
                view = null;
                i10 = itemViewType;
            }
            view = adapter.getView(iMax2, view, textInputLayoutE);
            if (view.getLayoutParams() == null) {
                view.setLayoutParams(new ViewGroup.LayoutParams(-2, -2));
            }
            view.measure(iMakeMeasureSpec, iMakeMeasureSpec2);
            iMax = Math.max(iMax, view.getMeasuredWidth());
        }
        Drawable drawableF = this.f21678a.f();
        if (drawableF != null) {
            drawableF.getPadding(this.f21680c);
            Rect rect = this.f21680c;
            iMax += rect.left + rect.right;
        }
        return iMax + textInputLayoutE.getEndIconView().getMeasuredWidth();
    }

    public final void j() {
        TextInputLayout textInputLayoutE = e();
        if (textInputLayoutE != null) {
            textInputLayoutE.s0();
        }
    }

    @Override // android.widget.AutoCompleteTextView, android.widget.TextView, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        TextInputLayout textInputLayoutE = e();
        if (textInputLayoutE != null && textInputLayoutE.T() && super.getHint() == null && com.google.android.material.internal.i.d()) {
            setHint("");
        }
    }

    @Override // android.widget.AutoCompleteTextView, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.f21678a.dismiss();
    }

    @Override // android.widget.TextView, android.view.View
    public void onMeasure(int i10, int i11) {
        super.onMeasure(i10, i11);
        if (View.MeasureSpec.getMode(i10) == Integer.MIN_VALUE) {
            setMeasuredDimension(Math.min(Math.max(getMeasuredWidth(), i()), View.MeasureSpec.getSize(i10)), getMeasuredHeight());
        }
    }

    @Override // android.widget.AutoCompleteTextView, android.widget.TextView, android.view.View
    public void onWindowFocusChanged(boolean z10) {
        if (f()) {
            return;
        }
        super.onWindowFocusChanged(z10);
    }

    @Override // android.widget.AutoCompleteTextView
    public <T extends ListAdapter & Filterable> void setAdapter(T t10) {
        super.setAdapter(t10);
        this.f21678a.l(getAdapter());
    }

    @Override // android.widget.AutoCompleteTextView
    public void setDropDownBackgroundDrawable(Drawable drawable) {
        super.setDropDownBackgroundDrawable(drawable);
        F f10 = this.f21678a;
        if (f10 != null) {
            f10.b(drawable);
        }
    }

    public void setDropDownBackgroundTint(int i10) {
        setDropDownBackgroundTintList(ColorStateList.valueOf(i10));
    }

    public void setDropDownBackgroundTintList(ColorStateList colorStateList) {
        this.f21683f = colorStateList;
        Drawable dropDownBackground = getDropDownBackground();
        if (dropDownBackground instanceof Z2.h) {
            ((Z2.h) dropDownBackground).g0(this.f21683f);
        }
    }

    @Override // android.widget.AutoCompleteTextView
    public void setOnItemSelectedListener(AdapterView.OnItemSelectedListener onItemSelectedListener) {
        super.setOnItemSelectedListener(onItemSelectedListener);
        this.f21678a.K(getOnItemSelectedListener());
    }

    @Override // android.widget.TextView
    public void setRawInputType(int i10) {
        super.setRawInputType(i10);
        j();
    }

    public void setSimpleItemSelectedColor(int i10) {
        this.f21684g = i10;
        if (getAdapter() instanceof b) {
            ((b) getAdapter()).f();
        }
    }

    public void setSimpleItemSelectedRippleColor(ColorStateList colorStateList) {
        this.f21685h = colorStateList;
        if (getAdapter() instanceof b) {
            ((b) getAdapter()).f();
        }
    }

    public void setSimpleItems(int i10) {
        setSimpleItems(getResources().getStringArray(i10));
    }

    @Override // android.widget.AutoCompleteTextView
    public void showDropDown() {
        if (f()) {
            this.f21678a.show();
        } else {
            super.showDropDown();
        }
    }

    public v(Context context, AttributeSet attributeSet, int i10) {
        super(C3953a.d(context, attributeSet, i10, 0), attributeSet, i10);
        this.f21680c = new Rect();
        Context context2 = getContext();
        TypedArray typedArrayI = com.google.android.material.internal.r.i(context2, attributeSet, R$styleable.MaterialAutoCompleteTextView, i10, R$style.Widget_AppCompat_AutoCompleteTextView, new int[0]);
        int i11 = R$styleable.MaterialAutoCompleteTextView_android_inputType;
        if (typedArrayI.hasValue(i11) && typedArrayI.getInt(i11, 0) == 0) {
            setKeyListener(null);
        }
        this.f21681d = typedArrayI.getResourceId(R$styleable.MaterialAutoCompleteTextView_simpleItemLayout, R$layout.mtrl_auto_complete_simple_item);
        this.f21682e = typedArrayI.getDimensionPixelOffset(R$styleable.MaterialAutoCompleteTextView_android_popupElevation, R$dimen.mtrl_exposed_dropdown_menu_popup_elevation);
        int i12 = R$styleable.MaterialAutoCompleteTextView_dropDownBackgroundTint;
        if (typedArrayI.hasValue(i12)) {
            this.f21683f = ColorStateList.valueOf(typedArrayI.getColor(i12, 0));
        }
        this.f21684g = typedArrayI.getColor(R$styleable.MaterialAutoCompleteTextView_simpleItemSelectedColor, 0);
        this.f21685h = W2.c.a(context2, typedArrayI, R$styleable.MaterialAutoCompleteTextView_simpleItemSelectedRippleColor);
        this.f21679b = (AccessibilityManager) context2.getSystemService("accessibility");
        F f10 = new F(context2);
        this.f21678a = f10;
        f10.H(true);
        f10.B(this);
        f10.G(2);
        f10.l(getAdapter());
        f10.J(new a());
        int i13 = R$styleable.MaterialAutoCompleteTextView_simpleItems;
        if (typedArrayI.hasValue(i13)) {
            setSimpleItems(typedArrayI.getResourceId(i13, 0));
        }
        typedArrayI.recycle();
    }

    public void setSimpleItems(String[] strArr) {
        setAdapter(new b(getContext(), this.f21681d, strArr));
    }
}
