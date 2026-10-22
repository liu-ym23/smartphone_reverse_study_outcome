package com.stepos.textinputlayout;

import android.R;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.Interpolator;
import android.view.animation.PathInterpolator;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.core.view.C1313a;
import androidx.core.view.N;
import androidx.core.view.W;
import com.stepos.common.R$color;
import com.stepos.common.R$dimen;
import com.stepos.common.R$drawable;
import com.stepos.common.R$style;
import com.stepos.common.R$styleable;
import com.stepos.textinputlayout.a;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Locale;

/* loaded from: classes2.dex */
public class TextInputLayout extends LinearLayout {

    /* renamed from: v, reason: collision with root package name */
    public static Field f31081v;

    /* renamed from: w, reason: collision with root package name */
    public static Field f31082w;

    /* renamed from: x, reason: collision with root package name */
    public static Method f31083x;

    /* renamed from: a, reason: collision with root package name */
    public int f31084a;

    /* renamed from: b, reason: collision with root package name */
    public EditText f31085b;

    /* renamed from: c, reason: collision with root package name */
    public CharSequence f31086c;

    /* renamed from: d, reason: collision with root package name */
    public Paint f31087d;

    /* renamed from: e, reason: collision with root package name */
    public boolean f31088e;

    /* renamed from: f, reason: collision with root package name */
    public TextView f31089f;

    /* renamed from: g, reason: collision with root package name */
    public int f31090g;

    /* renamed from: h, reason: collision with root package name */
    public ColorStateList f31091h;

    /* renamed from: i, reason: collision with root package name */
    public ColorStateList f31092i;

    /* renamed from: j, reason: collision with root package name */
    public Drawable f31093j;

    /* renamed from: k, reason: collision with root package name */
    public Drawable f31094k;

    /* renamed from: l, reason: collision with root package name */
    public boolean f31095l;

    /* renamed from: m, reason: collision with root package name */
    public int f31096m;

    /* renamed from: n, reason: collision with root package name */
    public int f31097n;

    /* renamed from: o, reason: collision with root package name */
    public final N7.b f31098o;

    /* renamed from: p, reason: collision with root package name */
    public boolean f31099p;

    /* renamed from: q, reason: collision with root package name */
    public com.stepos.textinputlayout.a f31100q;

    /* renamed from: r, reason: collision with root package name */
    public int f31101r;

    /* renamed from: s, reason: collision with root package name */
    public int f31102s;

    /* renamed from: t, reason: collision with root package name */
    public boolean f31103t;

    /* renamed from: u, reason: collision with root package name */
    public int f31104u;

    public class a implements TextWatcher {
        public a() {
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
            TextInputLayout.this.l(true);
        }

        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence charSequence, int i10, int i11, int i12) {
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(CharSequence charSequence, int i10, int i11, int i12) throws IllegalAccessException, NoSuchFieldException, NoSuchMethodException, SecurityException, ClassNotFoundException, IllegalArgumentException, InvocationTargetException {
            if (TextInputLayout.this.f31085b == null || TextInputLayout.this.f31085b.getText().length() != 0) {
                return;
            }
            TextInputLayout.this.setErrorEnabled(false);
            TextInputLayout.this.f31085b.setBackgroundTintList(null);
        }
    }

    public class b extends W {
        public b() {
        }

        @Override // androidx.core.view.W, androidx.core.view.V
        public void e(View view) {
            view.setVisibility(0);
        }
    }

    public class c extends W {
        public c() {
        }

        @Override // androidx.core.view.W, androidx.core.view.V
        public void d(View view) {
            view.setVisibility(4);
        }
    }

    public class d implements a.b {
        public d() {
        }

        @Override // com.stepos.textinputlayout.a.b
        public void a(com.stepos.textinputlayout.a aVar) {
            TextInputLayout.this.f31098o.A(aVar.b());
        }
    }

    public class e extends C1313a {
        public e() {
        }

        @Override // androidx.core.view.C1313a
        public void onInitializeAccessibilityEvent(View view, AccessibilityEvent accessibilityEvent) {
            super.onInitializeAccessibilityEvent(view, accessibilityEvent);
            accessibilityEvent.setClassName(TextInputLayout.class.getSimpleName());
        }

        @Override // androidx.core.view.C1313a
        public void onInitializeAccessibilityNodeInfo(View view, C0.c cVar) {
            super.onInitializeAccessibilityNodeInfo(view, cVar);
            cVar.m0(TextInputLayout.class.getSimpleName());
            CharSequence charSequenceK = TextInputLayout.this.f31098o.k();
            if (!TextUtils.isEmpty(charSequenceK)) {
                cVar.O0(charSequenceK);
            }
            if (TextInputLayout.this.f31085b != null) {
                cVar.A0(TextInputLayout.this.f31085b);
            }
            CharSequence text = TextInputLayout.this.f31089f != null ? TextInputLayout.this.f31089f.getText() : null;
            if (TextUtils.isEmpty(text)) {
                return;
            }
            cVar.r0(true);
            cVar.u0(text);
        }

        @Override // androidx.core.view.C1313a
        public void onPopulateAccessibilityEvent(View view, AccessibilityEvent accessibilityEvent) {
            super.onPopulateAccessibilityEvent(view, accessibilityEvent);
            CharSequence charSequenceK = TextInputLayout.this.f31098o.k();
            if (TextUtils.isEmpty(charSequenceK)) {
                return;
            }
            accessibilityEvent.getText().add(charSequenceK);
        }

        public /* synthetic */ e(TextInputLayout textInputLayout, a aVar) {
            this();
        }
    }

    public TextInputLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public static boolean f(int[] iArr, int i10) {
        for (int i11 : iArr) {
            if (i11 == i10) {
                return true;
            }
        }
        return false;
    }

    private Interpolator getInterpolator() {
        return new PathInterpolator(0.1f, 0.0f, 0.1f, 1.0f);
    }

    @Override // android.view.ViewGroup
    public void addView(View view, int i10, ViewGroup.LayoutParams layoutParams) {
        if (!(view instanceof EditText)) {
            super.addView(view, i10, layoutParams);
        } else {
            setEditText((EditText) view);
            super.addView(view, 0, k(layoutParams));
        }
    }

    @Override // android.view.View
    public void draw(Canvas canvas) {
        super.draw(canvas);
        if (this.f31103t) {
            this.f31098o.f(canvas);
        }
    }

    public final void e(float f10) {
        if (this.f31098o.j() == f10) {
            return;
        }
        if (this.f31100q == null) {
            com.stepos.textinputlayout.a aVarA = com.stepos.textinputlayout.c.a();
            this.f31100q = aVarA;
            aVarA.f(getInterpolator());
            this.f31100q.d(this.f31084a);
            this.f31100q.g(new d());
        }
        this.f31100q.e(this.f31098o.j(), f10);
        this.f31100q.h();
    }

    public final void g(boolean z10) {
        com.stepos.textinputlayout.a aVar = this.f31100q;
        if (aVar != null && aVar.c()) {
            this.f31100q.a();
        }
        if (z10 && this.f31099p) {
            e(1.0f);
        } else {
            this.f31098o.A(1.0f);
        }
    }

    public EditText getEditText() {
        return this.f31085b;
    }

    public CharSequence getError() {
        TextView textView;
        if (this.f31088e && (textView = this.f31089f) != null && textView.getVisibility() == 0) {
            return this.f31089f.getText();
        }
        return null;
    }

    public boolean getErrorEnabled() {
        return this.f31088e;
    }

    public TextView getErrorView() {
        return this.f31089f;
    }

    public CharSequence getHint() {
        return this.f31086c;
    }

    public boolean getLabelEnable() {
        return this.f31103t;
    }

    public int getLabelTextHeight() {
        return this.f31102s;
    }

    public final void h(boolean z10) {
        com.stepos.textinputlayout.a aVar = this.f31100q;
        if (aVar != null && aVar.c()) {
            this.f31100q.a();
        }
        if (z10 && this.f31099p) {
            e(0.0f);
        } else {
            this.f31098o.A(0.0f);
        }
    }

    public boolean i() {
        TextView textView = this.f31089f;
        return textView != null && textView.getVisibility() == 0;
    }

    public final void j(EditText editText, int i10) throws IllegalAccessException, NoSuchFieldException, NoSuchMethodException, SecurityException, ClassNotFoundException, IllegalArgumentException, InvocationTargetException {
        if (i10 < 0) {
            return;
        }
        try {
            if (f31081v == null) {
                Field declaredField = TextView.class.getDeclaredField("mCursorDrawableRes");
                f31081v = declaredField;
                declaredField.setAccessible(true);
                this.f31104u = f31081v.getInt(editText);
            }
            f31081v.setInt(editText, 0);
            if (f31082w == null) {
                Field declaredField2 = TextView.class.getDeclaredField("mEditor");
                f31082w = declaredField2;
                declaredField2.setAccessible(true);
            }
            Object obj = f31082w.get(editText);
            Class<?> cls = Class.forName("android.widget.Editor");
            if (f31083x == null) {
                Method declaredMethod = cls.getDeclaredMethod("updateCursorPosition", null);
                f31083x = declaredMethod;
                declaredMethod.setAccessible(true);
            }
            f31083x.invoke(obj, null);
            f31081v.setInt(editText, i10);
        } catch (Exception e10) {
            e10.printStackTrace();
        }
    }

    public final LinearLayout.LayoutParams k(ViewGroup.LayoutParams layoutParams) {
        LinearLayout.LayoutParams layoutParams2 = layoutParams instanceof LinearLayout.LayoutParams ? (LinearLayout.LayoutParams) layoutParams : new LinearLayout.LayoutParams(layoutParams);
        if (this.f31087d == null) {
            this.f31087d = new Paint();
        }
        this.f31087d.setTypeface(this.f31098o.l());
        this.f31087d.setTextSize(this.f31098o.i());
        layoutParams2.topMargin = 0;
        this.f31102s = 0;
        return layoutParams2;
    }

    public final void l(boolean z10) {
        EditText editText = this.f31085b;
        boolean z11 = (editText == null || TextUtils.isEmpty(editText.getText())) ? false : true;
        boolean zF = f(getDrawableState(), R.attr.state_focused);
        ColorStateList colorStateList = this.f31091h;
        if (colorStateList != null && this.f31092i != null) {
            this.f31098o.x(colorStateList.getDefaultColor());
            this.f31098o.u(zF ? this.f31092i.getDefaultColor() : this.f31091h.getDefaultColor());
        }
        if (z11 || zF) {
            g(z10);
        } else {
            h(z10);
        }
    }

    @Override // android.view.View
    public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo accessibilityNodeInfo) {
        super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
        accessibilityNodeInfo.setClassName(TextInputLayout.class.getName());
    }

    @Override // android.widget.LinearLayout, android.view.ViewGroup, android.view.View
    public void onLayout(boolean z10, int i10, int i11, int i12, int i13) {
        int left;
        int right;
        super.onLayout(z10, i10, i11, i12, i13);
        EditText editText = this.f31085b;
        if (editText != null) {
            int left2 = editText.getLeft() + this.f31085b.getCompoundPaddingLeft();
            int right2 = this.f31085b.getRight() - this.f31085b.getCompoundPaddingRight();
            if (this.f31095l) {
                left = this.f31085b.getLeft() + this.f31085b.getCompoundPaddingLeft();
                right = this.f31085b.getRight() - this.f31085b.getCompoundPaddingRight();
            } else {
                left = this.f31085b.getLeft();
                right = this.f31085b.getRight();
            }
            int i14 = this.f31096m;
            this.f31098o.w(left2, this.f31085b.getTop() + this.f31085b.getCompoundPaddingTop(), right2, this.f31085b.getBottom() - this.f31085b.getCompoundPaddingBottom());
            this.f31098o.s(left + i14, getPaddingTop(), right + i14, (i13 - i11) - getPaddingBottom());
            this.f31098o.q();
        }
    }

    @Override // android.view.View
    public void refreshDrawableState() {
        super.refreshDrawableState();
        l(N.N(this));
    }

    public void setAlignEditContent(boolean z10) {
        this.f31095l = z10;
    }

    public void setAnimationDuration(int i10) {
        this.f31084a = i10;
    }

    public void setCollapsedTextColor(int i10) {
        this.f31092i = ColorStateList.valueOf(i10);
    }

    public void setEditText(EditText editText) {
        if (this.f31085b != null) {
            throw new IllegalArgumentException("We already have an EditText, can only have one");
        }
        this.f31085b = editText;
        if (TextUtils.getLayoutDirectionFromLocale(Locale.getDefault()) == 1) {
            this.f31085b.setTextDirection(4);
        }
        this.f31098o.F(this.f31085b.getTypeface());
        this.f31098o.z(this.f31085b.getTextSize());
        this.f31098o.y(this.f31085b.getGravity());
        this.f31085b.addTextChangedListener(new a());
        if (this.f31091h == null) {
            this.f31091h = this.f31085b.getHintTextColors();
        }
        if (TextUtils.isEmpty(this.f31086c)) {
            setHint(this.f31085b.getHint());
            this.f31085b.setHint((CharSequence) null);
        }
        TextView textView = this.f31089f;
        if (textView != null) {
            if (this.f31095l) {
                LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.f31085b.getLayoutParams();
                N.w0(this.f31089f, N.z(this.f31085b) + this.f31097n, this.f31101r, N.y(this.f31085b) + this.f31097n, 0);
                LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.f31089f.getLayoutParams();
                layoutParams2.leftMargin = layoutParams.leftMargin;
                layoutParams2.rightMargin = layoutParams.rightMargin;
                this.f31089f.setLayoutParams(layoutParams2);
            } else {
                int i10 = this.f31097n;
                N.w0(textView, i10, this.f31101r, i10, 0);
            }
        }
        l(false);
    }

    public void setError(CharSequence charSequence) throws IllegalAccessException, NoSuchFieldException, NoSuchMethodException, SecurityException, ClassNotFoundException, IllegalArgumentException, InvocationTargetException {
        boolean z10;
        if (this.f31088e) {
            z10 = false;
        } else {
            if (TextUtils.isEmpty(charSequence)) {
                return;
            }
            z10 = true;
            setErrorEnabled(true);
        }
        if (!TextUtils.isEmpty(charSequence)) {
            N.l0(this.f31089f, 0.0f);
            this.f31089f.setText(charSequence);
            N.d(this.f31089f).b(1.0f).f(this.f31084a).g(N7.a.f4853b).h(new b()).l();
            if (z10) {
                if (this.f31093j != null) {
                    this.f31094k = this.f31085b.getBackground();
                    this.f31085b.setBackground(this.f31093j);
                } else {
                    N.n0(this.f31085b, new ColorStateList(new int[][]{new int[]{R.attr.state_enabled, R.attr.state_focused}, new int[0]}, new int[]{this.f31089f.getCurrentTextColor(), getContext().getResources().getColor(R$color.stepos_text_input_normal_color)}));
                    j(this.f31085b, R$drawable.stepos_text_cursor_error_color);
                }
            }
        } else if (this.f31089f.getVisibility() == 0) {
            N.d(this.f31089f).b(0.0f).f(this.f31084a).g(N7.a.f4853b).h(new c()).l();
            getContext().getResources();
            Drawable drawable = this.f31094k;
            if (drawable != null) {
                this.f31085b.setBackground(drawable);
            } else {
                N.n0(this.f31085b, null);
            }
            j(this.f31085b, this.f31104u);
        }
        sendAccessibilityEvent(2048);
    }

    public void setErrorBackground(Drawable drawable) {
        EditText editText;
        this.f31093j = drawable;
        if (!i() || (editText = this.f31085b) == null) {
            return;
        }
        editText.setBackground(this.f31093j);
    }

    public void setErrorBackgroundResource(int i10) {
        EditText editText;
        if (i10 == 0) {
            return;
        }
        this.f31093j = androidx.core.content.a.e(getContext(), i10);
        if (!i() || (editText = this.f31085b) == null) {
            return;
        }
        editText.setBackground(this.f31093j);
    }

    public void setErrorEnabled(boolean z10) throws IllegalAccessException, NoSuchFieldException, NoSuchMethodException, SecurityException, ClassNotFoundException, IllegalArgumentException, InvocationTargetException {
        if (this.f31088e != z10) {
            TextView textView = this.f31089f;
            if (textView != null) {
                N.d(textView).c();
            }
            if (z10) {
                TextView textView2 = new TextView(getContext());
                this.f31089f = textView2;
                textView2.setTextAppearance(getContext(), this.f31090g);
                this.f31089f.setVisibility(4);
                if (TextUtils.getLayoutDirectionFromLocale(Locale.getDefault()) == 1) {
                    this.f31089f.setGravity(8388613);
                }
                addView(this.f31089f);
                EditText editText = this.f31085b;
                if (editText != null) {
                    if (this.f31095l) {
                        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) editText.getLayoutParams();
                        N.w0(this.f31089f, N.z(this.f31085b) + this.f31097n, this.f31101r, N.y(this.f31085b) + this.f31097n, 0);
                        LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.f31089f.getLayoutParams();
                        layoutParams2.leftMargin = layoutParams.leftMargin;
                        layoutParams2.rightMargin = layoutParams.rightMargin;
                        this.f31089f.setLayoutParams(layoutParams2);
                    } else {
                        TextView textView3 = this.f31089f;
                        int i10 = this.f31097n;
                        N.w0(textView3, i10, this.f31101r, i10, 0);
                    }
                }
            } else {
                getContext().getResources();
                Drawable drawable = this.f31094k;
                if (drawable != null) {
                    this.f31085b.setBackground(drawable);
                } else {
                    N.n0(this.f31085b, null);
                }
                j(this.f31085b, this.f31104u);
                removeView(this.f31089f);
                this.f31089f = null;
            }
            this.f31088e = z10;
        }
    }

    public void setErrorPaddingHorizontal(int i10) {
        this.f31097n = i10;
    }

    public void setErrorPaddingTop(int i10) {
        this.f31101r = i10;
        invalidate();
    }

    public void setHint(CharSequence charSequence) {
        this.f31086c = charSequence;
        this.f31098o.D(charSequence);
        sendAccessibilityEvent(2048);
    }

    public void setHintAnimationEnabled(boolean z10) {
        this.f31099p = z10;
    }

    public void setHintTextAppearance(int i10) throws Resources.NotFoundException {
        this.f31098o.t(i10);
        this.f31092i = ColorStateList.valueOf(this.f31098o.h());
        if (this.f31085b != null) {
            l(false);
            this.f31085b.setLayoutParams(k(this.f31085b.getLayoutParams()));
            this.f31085b.requestLayout();
        }
    }

    public void setLabelEnable(boolean z10) {
        this.f31103t = z10;
    }

    public void setLabelPaddingHorizontal(int i10) {
        this.f31096m = i10;
    }

    public void setOriginBackground(Drawable drawable) {
        EditText editText;
        this.f31094k = drawable;
        if (i() || (editText = this.f31085b) == null) {
            return;
        }
        editText.setBackground(this.f31094k);
    }

    public void setOriginBackgroundResource(int i10) {
        EditText editText;
        if (i10 == 0) {
            return;
        }
        this.f31094k = androidx.core.content.a.e(getContext(), i10);
        if (i() || (editText = this.f31085b) == null) {
            return;
        }
        editText.setBackground(this.f31094k);
    }

    public void setTypeface(Typeface typeface) {
        this.f31098o.F(typeface);
    }

    public TextInputLayout(Context context, AttributeSet attributeSet, int i10) throws IllegalAccessException, NoSuchFieldException, Resources.NotFoundException, NoSuchMethodException, SecurityException, ClassNotFoundException, IllegalArgumentException, InvocationTargetException {
        super(context, attributeSet);
        this.f31084a = 300;
        N7.b bVar = new N7.b(this);
        this.f31098o = bVar;
        this.f31101r = 6;
        this.f31102s = 0;
        this.f31103t = true;
        this.f31104u = -1;
        setOrientation(1);
        setWillNotDraw(false);
        setAddStatesFromChildren(true);
        bVar.E(N7.a.f4853b);
        bVar.C(new AccelerateInterpolator());
        bVar.v(8388659);
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R$styleable.StepOSTextInputLayout, i10, R$style.StepOSTextInputLayoutTextAppearance);
        this.f31086c = typedArrayObtainStyledAttributes.getText(R$styleable.StepOSTextInputLayout_android_hint);
        this.f31099p = typedArrayObtainStyledAttributes.getBoolean(R$styleable.StepOSTextInputLayout_hintAnimationEnabled, true);
        int i11 = R$styleable.StepOSTextInputLayout_android_textColorHint;
        if (typedArrayObtainStyledAttributes.hasValue(i11)) {
            ColorStateList colorStateList = typedArrayObtainStyledAttributes.getColorStateList(i11);
            this.f31092i = colorStateList;
            this.f31091h = colorStateList;
        }
        int i12 = R$styleable.StepOSTextInputLayout_hintTextAppearance;
        if (typedArrayObtainStyledAttributes.getResourceId(i12, -1) != -1) {
            setHintTextAppearance(typedArrayObtainStyledAttributes.getResourceId(i12, 0));
        }
        this.f31090g = typedArrayObtainStyledAttributes.getResourceId(R$styleable.StepOSTextInputLayout_errorTextAppearance, 0);
        boolean z10 = typedArrayObtainStyledAttributes.getBoolean(R$styleable.StepOSTextInputLayout_errorEnabled, false);
        this.f31093j = typedArrayObtainStyledAttributes.getDrawable(R$styleable.StepOSTextInputLayout_errorBackground);
        this.f31095l = typedArrayObtainStyledAttributes.getBoolean(R$styleable.StepOSTextInputLayout_alignEditContent, true);
        this.f31096m = typedArrayObtainStyledAttributes.getDimensionPixelSize(R$styleable.StepOSTextInputLayout_labelPaddingHorizontal, 0);
        this.f31097n = typedArrayObtainStyledAttributes.getDimensionPixelSize(R$styleable.StepOSTextInputLayout_errorPaddingHorizontal, 0);
        typedArrayObtainStyledAttributes.recycle();
        this.f31101r = context.getResources().getDimensionPixelSize(R$dimen.stepos_text_input_layout_default_margin_top);
        setErrorEnabled(z10);
        if (N.s(this) == 0) {
            N.r0(this, 1);
        }
        N.i0(this, new e(this, null));
    }
}
