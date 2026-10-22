package com.google.android.material.textfield;

import a1.C0411d;
import a1.C0415h;
import a1.C0418k;
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
import androidx.appcompat.widget.C0434d;
import androidx.appcompat.widget.M;
import g.C0728a;
import j1.C0777a;
import java.util.List;
import org.libpag.BuildConfig;
import q1.C0981c;
import t1.C1115h;
import x1.C1282a;

/* loaded from: classes.dex */
public class v extends C0434d {

    /* renamed from: e, reason: collision with root package name */
    private final M f13411e;

    /* renamed from: f, reason: collision with root package name */
    private final AccessibilityManager f13412f;

    /* renamed from: g, reason: collision with root package name */
    private final Rect f13413g;

    /* renamed from: h, reason: collision with root package name */
    private final int f13414h;

    /* renamed from: i, reason: collision with root package name */
    private final float f13415i;

    /* renamed from: j, reason: collision with root package name */
    private ColorStateList f13416j;

    /* renamed from: k, reason: collision with root package name */
    private int f13417k;

    /* renamed from: l, reason: collision with root package name */
    private ColorStateList f13418l;

    class a implements AdapterView.OnItemClickListener {
        a() {
        }

        @Override // android.widget.AdapterView.OnItemClickListener
        public void onItemClick(AdapterView<?> adapterView, View view, int i5, long j5) {
            v vVar = v.this;
            Object objV = i5 < 0 ? vVar.f13411e.v() : vVar.getAdapter().getItem(i5);
            v vVar2 = v.this;
            vVar2.setText(vVar2.convertSelectionToString(objV), false);
            AdapterView.OnItemClickListener onItemClickListener = v.this.getOnItemClickListener();
            if (onItemClickListener != null) {
                if (view == null || i5 < 0) {
                    view = v.this.f13411e.y();
                    i5 = v.this.f13411e.x();
                    j5 = v.this.f13411e.w();
                }
                onItemClickListener.onItemClick(v.this.f13411e.m(), view, i5, j5);
            }
            v.this.f13411e.dismiss();
        }
    }

    private class b<T> extends ArrayAdapter<String> {

        /* renamed from: a, reason: collision with root package name */
        private ColorStateList f13420a;

        /* renamed from: b, reason: collision with root package name */
        private ColorStateList f13421b;

        b(Context context, int i5, String[] strArr) {
            super(context, i5, strArr);
            f();
        }

        private ColorStateList a() {
            if (!c() || !d()) {
                return null;
            }
            int[] iArr = {R.attr.state_hovered, -16842919};
            int[] iArr2 = {R.attr.state_selected, -16842919};
            return new ColorStateList(new int[][]{iArr2, iArr, new int[0]}, new int[]{C0777a.i(v.this.f13417k, v.this.f13418l.getColorForState(iArr2, 0)), C0777a.i(v.this.f13417k, v.this.f13418l.getColorForState(iArr, 0)), v.this.f13417k});
        }

        private Drawable b() {
            if (!c()) {
                return null;
            }
            ColorDrawable colorDrawable = new ColorDrawable(v.this.f13417k);
            if (this.f13421b == null) {
                return colorDrawable;
            }
            colorDrawable.setTintList(this.f13420a);
            return new RippleDrawable(this.f13421b, colorDrawable, null);
        }

        private boolean c() {
            return v.this.f13417k != 0;
        }

        private boolean d() {
            return v.this.f13418l != null;
        }

        private ColorStateList e() {
            if (!d()) {
                return null;
            }
            int[] iArr = {R.attr.state_pressed};
            return new ColorStateList(new int[][]{iArr, new int[0]}, new int[]{v.this.f13418l.getColorForState(iArr, 0), 0});
        }

        void f() {
            this.f13421b = e();
            this.f13420a = a();
        }

        @Override // android.widget.ArrayAdapter, android.widget.Adapter
        public View getView(int i5, View view, ViewGroup viewGroup) {
            View view2 = super.getView(i5, view, viewGroup);
            if (view2 instanceof TextView) {
                TextView textView = (TextView) view2;
                textView.setBackground(v.this.getText().toString().contentEquals(textView.getText()) ? b() : null);
            }
            return view2;
        }
    }

    public v(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, C0728a.f16841r);
    }

    private TextInputLayout f() {
        for (ViewParent parent = getParent(); parent != null; parent = parent.getParent()) {
            if (parent instanceof TextInputLayout) {
                return (TextInputLayout) parent;
            }
        }
        return null;
    }

    private boolean g() {
        return i() || h();
    }

    private boolean h() {
        List<AccessibilityServiceInfo> enabledAccessibilityServiceList;
        AccessibilityManager accessibilityManager = this.f13412f;
        if (accessibilityManager != null && accessibilityManager.isEnabled() && (enabledAccessibilityServiceList = this.f13412f.getEnabledAccessibilityServiceList(16)) != null) {
            for (AccessibilityServiceInfo accessibilityServiceInfo : enabledAccessibilityServiceList) {
                if (accessibilityServiceInfo.getSettingsActivityName() != null && accessibilityServiceInfo.getSettingsActivityName().contains("SwitchAccess")) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean i() {
        AccessibilityManager accessibilityManager = this.f13412f;
        return accessibilityManager != null && accessibilityManager.isTouchExplorationEnabled();
    }

    private int j() {
        ListAdapter adapter = getAdapter();
        TextInputLayout textInputLayoutF = f();
        int i5 = 0;
        if (adapter == null || textInputLayoutF == null) {
            return 0;
        }
        int iMakeMeasureSpec = View.MeasureSpec.makeMeasureSpec(getMeasuredWidth(), 0);
        int iMakeMeasureSpec2 = View.MeasureSpec.makeMeasureSpec(getMeasuredHeight(), 0);
        int iMin = Math.min(adapter.getCount(), Math.max(0, this.f13411e.x()) + 15);
        View view = null;
        int iMax = 0;
        for (int iMax2 = Math.max(0, iMin - 15); iMax2 < iMin; iMax2++) {
            int itemViewType = adapter.getItemViewType(iMax2);
            if (itemViewType != i5) {
                view = null;
                i5 = itemViewType;
            }
            view = adapter.getView(iMax2, view, textInputLayoutF);
            if (view.getLayoutParams() == null) {
                view.setLayoutParams(new ViewGroup.LayoutParams(-2, -2));
            }
            view.measure(iMakeMeasureSpec, iMakeMeasureSpec2);
            iMax = Math.max(iMax, view.getMeasuredWidth());
        }
        Drawable drawableL = this.f13411e.l();
        if (drawableL != null) {
            drawableL.getPadding(this.f13413g);
            Rect rect = this.f13413g;
            iMax += rect.left + rect.right;
        }
        return iMax + textInputLayoutF.getEndIconView().getMeasuredWidth();
    }

    private void k() {
        TextInputLayout textInputLayoutF = f();
        if (textInputLayoutF != null) {
            textInputLayoutF.s0();
        }
    }

    @Override // android.widget.AutoCompleteTextView
    public void dismissDropDown() {
        if (g()) {
            this.f13411e.dismiss();
        } else {
            super.dismissDropDown();
        }
    }

    public ColorStateList getDropDownBackgroundTintList() {
        return this.f13416j;
    }

    @Override // android.widget.TextView
    public CharSequence getHint() {
        TextInputLayout textInputLayoutF = f();
        return (textInputLayoutF == null || !textInputLayoutF.T()) ? super.getHint() : textInputLayoutF.getHint();
    }

    public float getPopupElevation() {
        return this.f13415i;
    }

    public int getSimpleItemSelectedColor() {
        return this.f13417k;
    }

    public ColorStateList getSimpleItemSelectedRippleColor() {
        return this.f13418l;
    }

    @Override // android.widget.AutoCompleteTextView, android.widget.TextView, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        TextInputLayout textInputLayoutF = f();
        if (textInputLayoutF != null && textInputLayoutF.T() && super.getHint() == null && com.google.android.material.internal.i.b()) {
            setHint(BuildConfig.FLAVOR);
        }
    }

    @Override // android.widget.AutoCompleteTextView, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.f13411e.dismiss();
    }

    @Override // android.widget.TextView, android.view.View
    protected void onMeasure(int i5, int i6) {
        super.onMeasure(i5, i6);
        if (View.MeasureSpec.getMode(i5) == Integer.MIN_VALUE) {
            setMeasuredDimension(Math.min(Math.max(getMeasuredWidth(), j()), View.MeasureSpec.getSize(i5)), getMeasuredHeight());
        }
    }

    @Override // android.widget.AutoCompleteTextView, android.widget.TextView, android.view.View
    public void onWindowFocusChanged(boolean z5) {
        if (g()) {
            return;
        }
        super.onWindowFocusChanged(z5);
    }

    @Override // android.widget.AutoCompleteTextView
    public <T extends ListAdapter & Filterable> void setAdapter(T t5) {
        super.setAdapter(t5);
        this.f13411e.s(getAdapter());
    }

    @Override // android.widget.AutoCompleteTextView
    public void setDropDownBackgroundDrawable(Drawable drawable) {
        super.setDropDownBackgroundDrawable(drawable);
        M m5 = this.f13411e;
        if (m5 != null) {
            m5.g(drawable);
        }
    }

    public void setDropDownBackgroundTint(int i5) {
        setDropDownBackgroundTintList(ColorStateList.valueOf(i5));
    }

    public void setDropDownBackgroundTintList(ColorStateList colorStateList) {
        this.f13416j = colorStateList;
        Drawable dropDownBackground = getDropDownBackground();
        if (dropDownBackground instanceof C1115h) {
            ((C1115h) dropDownBackground).g0(this.f13416j);
        }
    }

    @Override // android.widget.AutoCompleteTextView
    public void setOnItemSelectedListener(AdapterView.OnItemSelectedListener onItemSelectedListener) {
        super.setOnItemSelectedListener(onItemSelectedListener);
        this.f13411e.M(getOnItemSelectedListener());
    }

    @Override // android.widget.TextView
    public void setRawInputType(int i5) {
        super.setRawInputType(i5);
        k();
    }

    public void setSimpleItemSelectedColor(int i5) {
        this.f13417k = i5;
        if (getAdapter() instanceof b) {
            ((b) getAdapter()).f();
        }
    }

    public void setSimpleItemSelectedRippleColor(ColorStateList colorStateList) {
        this.f13418l = colorStateList;
        if (getAdapter() instanceof b) {
            ((b) getAdapter()).f();
        }
    }

    public void setSimpleItems(int i5) {
        setSimpleItems(getResources().getStringArray(i5));
    }

    @Override // android.widget.AutoCompleteTextView
    public void showDropDown() {
        if (g()) {
            this.f13411e.a();
        } else {
            super.showDropDown();
        }
    }

    public v(Context context, AttributeSet attributeSet, int i5) {
        super(C1282a.d(context, attributeSet, i5, 0), attributeSet, i5);
        this.f13413g = new Rect();
        Context context2 = getContext();
        TypedArray typedArrayI = com.google.android.material.internal.o.i(context2, attributeSet, C0418k.f6967F1, i5, g.i.f16981f, new int[0]);
        int i6 = C0418k.f6973G1;
        if (typedArrayI.hasValue(i6) && typedArrayI.getInt(i6, 0) == 0) {
            setKeyListener(null);
        }
        this.f13414h = typedArrayI.getResourceId(C0418k.f6991J1, C0415h.f6876j);
        this.f13415i = typedArrayI.getDimensionPixelOffset(C0418k.f6979H1, C0411d.f6773a0);
        int i7 = C0418k.f6985I1;
        if (typedArrayI.hasValue(i7)) {
            this.f13416j = ColorStateList.valueOf(typedArrayI.getColor(i7, 0));
        }
        this.f13417k = typedArrayI.getColor(C0418k.f6997K1, 0);
        this.f13418l = C0981c.a(context2, typedArrayI, C0418k.f7003L1);
        this.f13412f = (AccessibilityManager) context2.getSystemService("accessibility");
        M m5 = new M(context2);
        this.f13411e = m5;
        m5.J(true);
        m5.D(this);
        m5.I(2);
        m5.s(getAdapter());
        m5.L(new a());
        int i8 = C0418k.f7009M1;
        if (typedArrayI.hasValue(i8)) {
            setSimpleItems(typedArrayI.getResourceId(i8, 0));
        }
        typedArrayI.recycle();
    }

    public void setSimpleItems(String[] strArr) {
        setAdapter(new b(getContext(), this.f13414h, strArr));
    }
}
