package com.stepos.textinputlayout;

import H1.g;
import H1.l;
import H1.m;
import android.R;
import android.content.Context;
import android.content.res.ColorStateList;
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
import androidx.core.view.C0456a;
import androidx.core.view.H;
import androidx.core.view.U;
import androidx.recyclerview.widget.RecyclerView;
import com.stepos.textinputlayout.d;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Locale;

/* loaded from: classes.dex */
public class TextInputLayout extends LinearLayout {

    /* renamed from: v, reason: collision with root package name */
    private static Field f15998v;

    /* renamed from: w, reason: collision with root package name */
    private static Field f15999w;

    /* renamed from: x, reason: collision with root package name */
    private static Method f16000x;

    /* renamed from: a, reason: collision with root package name */
    private int f16001a;

    /* renamed from: b, reason: collision with root package name */
    private EditText f16002b;

    /* renamed from: c, reason: collision with root package name */
    private CharSequence f16003c;

    /* renamed from: d, reason: collision with root package name */
    private Paint f16004d;

    /* renamed from: e, reason: collision with root package name */
    private boolean f16005e;

    /* renamed from: f, reason: collision with root package name */
    private TextView f16006f;

    /* renamed from: g, reason: collision with root package name */
    private int f16007g;

    /* renamed from: h, reason: collision with root package name */
    private ColorStateList f16008h;

    /* renamed from: i, reason: collision with root package name */
    private ColorStateList f16009i;

    /* renamed from: j, reason: collision with root package name */
    private Drawable f16010j;

    /* renamed from: k, reason: collision with root package name */
    private Drawable f16011k;

    /* renamed from: l, reason: collision with root package name */
    private boolean f16012l;

    /* renamed from: m, reason: collision with root package name */
    private int f16013m;

    /* renamed from: n, reason: collision with root package name */
    private int f16014n;

    /* renamed from: o, reason: collision with root package name */
    private final com.stepos.textinputlayout.b f16015o;

    /* renamed from: p, reason: collision with root package name */
    private boolean f16016p;

    /* renamed from: q, reason: collision with root package name */
    private com.stepos.textinputlayout.d f16017q;

    /* renamed from: r, reason: collision with root package name */
    private int f16018r;

    /* renamed from: s, reason: collision with root package name */
    private int f16019s;

    /* renamed from: t, reason: collision with root package name */
    private boolean f16020t;

    /* renamed from: u, reason: collision with root package name */
    private int f16021u;

    class a implements TextWatcher {
        a() {
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
            TextInputLayout.this.m(true);
        }

        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence charSequence, int i5, int i6, int i7) {
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(CharSequence charSequence, int i5, int i6, int i7) throws IllegalAccessException, NoSuchFieldException, NoSuchMethodException, SecurityException, ClassNotFoundException, IllegalArgumentException, InvocationTargetException {
            if (TextInputLayout.this.f16002b == null || TextInputLayout.this.f16002b.getText().length() != 0) {
                return;
            }
            TextInputLayout.this.setErrorEnabled(false);
            TextInputLayout.this.f16002b.setBackgroundTintList(null);
        }
    }

    class b extends U {
        b() {
        }

        @Override // androidx.core.view.U, androidx.core.view.T
        public void e(View view) {
            view.setVisibility(0);
        }
    }

    class c extends U {
        c() {
        }

        @Override // androidx.core.view.U, androidx.core.view.T
        public void d(View view) {
            view.setVisibility(4);
        }
    }

    class d implements d.b {
        d() {
        }

        @Override // com.stepos.textinputlayout.d.b
        public void a(com.stepos.textinputlayout.d dVar) {
            TextInputLayout.this.f16015o.A(dVar.b());
        }
    }

    private class e extends C0456a {
        private e() {
        }

        @Override // androidx.core.view.C0456a
        public void onInitializeAccessibilityEvent(View view, AccessibilityEvent accessibilityEvent) {
            super.onInitializeAccessibilityEvent(view, accessibilityEvent);
            accessibilityEvent.setClassName(TextInputLayout.class.getSimpleName());
        }

        @Override // androidx.core.view.C0456a
        public void onInitializeAccessibilityNodeInfo(View view, E.c cVar) {
            super.onInitializeAccessibilityNodeInfo(view, cVar);
            cVar.d0(TextInputLayout.class.getSimpleName());
            CharSequence charSequenceK = TextInputLayout.this.f16015o.k();
            if (!TextUtils.isEmpty(charSequenceK)) {
                cVar.A0(charSequenceK);
            }
            if (TextInputLayout.this.f16002b != null) {
                cVar.p0(TextInputLayout.this.f16002b);
            }
            CharSequence text = TextInputLayout.this.f16006f != null ? TextInputLayout.this.f16006f.getText() : null;
            if (TextUtils.isEmpty(text)) {
                return;
            }
            cVar.i0(true);
            cVar.k0(text);
        }

        @Override // androidx.core.view.C0456a
        public void onPopulateAccessibilityEvent(View view, AccessibilityEvent accessibilityEvent) {
            super.onPopulateAccessibilityEvent(view, accessibilityEvent);
            CharSequence charSequenceK = TextInputLayout.this.f16015o.k();
            if (TextUtils.isEmpty(charSequenceK)) {
                return;
            }
            accessibilityEvent.getText().add(charSequenceK);
        }

        /* synthetic */ e(TextInputLayout textInputLayout, a aVar) {
            this();
        }
    }

    public TextInputLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    private void e(float f5) {
        if (this.f16015o.j() == f5) {
            return;
        }
        if (this.f16017q == null) {
            com.stepos.textinputlayout.d dVarA = f.a();
            this.f16017q = dVarA;
            dVarA.f(getInterpolator());
            this.f16017q.d(this.f16001a);
            this.f16017q.g(new d());
        }
        this.f16017q.e(this.f16015o.j(), f5);
        this.f16017q.h();
    }

    private static boolean f(int[] iArr, int i5) {
        for (int i6 : iArr) {
            if (i6 == i5) {
                return true;
            }
        }
        return false;
    }

    private void g(boolean z5) {
        com.stepos.textinputlayout.d dVar = this.f16017q;
        if (dVar != null && dVar.c()) {
            this.f16017q.a();
        }
        if (z5 && this.f16016p) {
            e(1.0f);
        } else {
            this.f16015o.A(1.0f);
        }
    }

    private Interpolator getInterpolator() {
        return new PathInterpolator(0.1f, 0.0f, 0.1f, 1.0f);
    }

    private void h(boolean z5) {
        com.stepos.textinputlayout.d dVar = this.f16017q;
        if (dVar != null && dVar.c()) {
            this.f16017q.a();
        }
        if (z5 && this.f16016p) {
            e(0.0f);
        } else {
            this.f16015o.A(0.0f);
        }
    }

    private void k(EditText editText, int i5) throws IllegalAccessException, NoSuchFieldException, NoSuchMethodException, SecurityException, ClassNotFoundException, IllegalArgumentException, InvocationTargetException {
        if (i5 < 0) {
            return;
        }
        try {
            if (f15998v == null) {
                Field declaredField = TextView.class.getDeclaredField("mCursorDrawableRes");
                f15998v = declaredField;
                declaredField.setAccessible(true);
                this.f16021u = f15998v.getInt(editText);
            }
            f15998v.setInt(editText, 0);
            if (f15999w == null) {
                Field declaredField2 = TextView.class.getDeclaredField("mEditor");
                f15999w = declaredField2;
                declaredField2.setAccessible(true);
            }
            Object obj = f15999w.get(editText);
            Class<?> cls = Class.forName("android.widget.Editor");
            if (f16000x == null) {
                Method declaredMethod = cls.getDeclaredMethod("updateCursorPosition", null);
                f16000x = declaredMethod;
                declaredMethod.setAccessible(true);
            }
            f16000x.invoke(obj, null);
            f15998v.setInt(editText, i5);
        } catch (Exception e6) {
            e6.printStackTrace();
        }
    }

    private LinearLayout.LayoutParams l(ViewGroup.LayoutParams layoutParams) {
        LinearLayout.LayoutParams layoutParams2 = layoutParams instanceof LinearLayout.LayoutParams ? (LinearLayout.LayoutParams) layoutParams : new LinearLayout.LayoutParams(layoutParams);
        if (this.f16004d == null) {
            this.f16004d = new Paint();
        }
        this.f16004d.setTypeface(this.f16015o.l());
        this.f16004d.setTextSize(this.f16015o.i());
        layoutParams2.topMargin = 0;
        this.f16019s = 0;
        return layoutParams2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void m(boolean z5) {
        EditText editText = this.f16002b;
        boolean z6 = (editText == null || TextUtils.isEmpty(editText.getText())) ? false : true;
        boolean zF = f(getDrawableState(), R.attr.state_focused);
        ColorStateList colorStateList = this.f16008h;
        if (colorStateList != null && this.f16009i != null) {
            this.f16015o.x(colorStateList.getDefaultColor());
            this.f16015o.u(zF ? this.f16009i.getDefaultColor() : this.f16008h.getDefaultColor());
        }
        if (z6 || zF) {
            g(z5);
        } else {
            h(z5);
        }
    }

    @Override // android.view.ViewGroup
    public void addView(View view, int i5, ViewGroup.LayoutParams layoutParams) {
        if (!(view instanceof EditText)) {
            super.addView(view, i5, layoutParams);
        } else {
            setEditText((EditText) view);
            super.addView(view, 0, l(layoutParams));
        }
    }

    @Override // android.view.View
    public void draw(Canvas canvas) {
        super.draw(canvas);
        if (this.f16020t) {
            this.f16015o.f(canvas);
        }
    }

    public EditText getEditText() {
        return this.f16002b;
    }

    public CharSequence getError() {
        TextView textView;
        if (this.f16005e && (textView = this.f16006f) != null && textView.getVisibility() == 0) {
            return this.f16006f.getText();
        }
        return null;
    }

    public boolean getErrorEnabled() {
        return this.f16005e;
    }

    public TextView getErrorView() {
        return this.f16006f;
    }

    public CharSequence getHint() {
        return this.f16003c;
    }

    public boolean getLabelEnable() {
        return this.f16020t;
    }

    public int getLabelTextHeight() {
        return this.f16019s;
    }

    public boolean i() {
        return this.f16005e;
    }

    public boolean j() {
        TextView textView = this.f16006f;
        return textView != null && textView.getVisibility() == 0;
    }

    @Override // android.view.View
    public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo accessibilityNodeInfo) {
        super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
        accessibilityNodeInfo.setClassName(TextInputLayout.class.getName());
    }

    @Override // android.widget.LinearLayout, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z5, int i5, int i6, int i7, int i8) {
        int left;
        int right;
        super.onLayout(z5, i5, i6, i7, i8);
        EditText editText = this.f16002b;
        if (editText != null) {
            int left2 = editText.getLeft() + this.f16002b.getCompoundPaddingLeft();
            int right2 = this.f16002b.getRight() - this.f16002b.getCompoundPaddingRight();
            if (this.f16012l) {
                left = this.f16002b.getLeft() + this.f16002b.getCompoundPaddingLeft();
                right = this.f16002b.getRight() - this.f16002b.getCompoundPaddingRight();
            } else {
                left = this.f16002b.getLeft();
                right = this.f16002b.getRight();
            }
            int i9 = this.f16013m;
            this.f16015o.w(left2, this.f16002b.getTop() + this.f16002b.getCompoundPaddingTop(), right2, this.f16002b.getBottom() - this.f16002b.getCompoundPaddingBottom());
            this.f16015o.s(left + i9, getPaddingTop(), right + i9, (i8 - i6) - getPaddingBottom());
            this.f16015o.q();
        }
    }

    @Override // android.view.View
    public void refreshDrawableState() {
        super.refreshDrawableState();
        m(H.Q(this));
    }

    public void setAlignEditContent(boolean z5) {
        this.f16012l = z5;
    }

    public void setAnimationDuration(int i5) {
        this.f16001a = i5;
    }

    public void setCollapsedTextColor(int i5) {
        this.f16009i = ColorStateList.valueOf(i5);
    }

    public void setEditText(EditText editText) {
        if (this.f16002b != null) {
            throw new IllegalArgumentException("We already have an EditText, can only have one");
        }
        this.f16002b = editText;
        if (TextUtils.getLayoutDirectionFromLocale(Locale.getDefault()) == 1) {
            this.f16002b.setTextDirection(4);
        }
        this.f16015o.F(this.f16002b.getTypeface());
        this.f16015o.z(this.f16002b.getTextSize());
        this.f16015o.y(this.f16002b.getGravity());
        this.f16002b.addTextChangedListener(new a());
        if (this.f16008h == null) {
            this.f16008h = this.f16002b.getHintTextColors();
        }
        if (TextUtils.isEmpty(this.f16003c)) {
            setHint(this.f16002b.getHint());
            this.f16002b.setHint((CharSequence) null);
        }
        TextView textView = this.f16006f;
        if (textView != null) {
            if (this.f16012l) {
                LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.f16002b.getLayoutParams();
                H.x0(this.f16006f, H.C(this.f16002b) + this.f16014n, this.f16018r, H.B(this.f16002b) + this.f16014n, 0);
                LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.f16006f.getLayoutParams();
                layoutParams2.leftMargin = layoutParams.leftMargin;
                layoutParams2.rightMargin = layoutParams.rightMargin;
                this.f16006f.setLayoutParams(layoutParams2);
            } else {
                int i5 = this.f16014n;
                H.x0(textView, i5, this.f16018r, i5, 0);
            }
        }
        m(false);
    }

    public void setError(CharSequence charSequence) throws IllegalAccessException, NoSuchFieldException, NoSuchMethodException, SecurityException, ClassNotFoundException, IllegalArgumentException, InvocationTargetException {
        boolean z5;
        if (this.f16005e) {
            z5 = false;
        } else {
            if (TextUtils.isEmpty(charSequence)) {
                return;
            }
            z5 = true;
            setErrorEnabled(true);
        }
        if (!TextUtils.isEmpty(charSequence)) {
            H.n0(this.f16006f, 0.0f);
            this.f16006f.setText(charSequence);
            H.d(this.f16006f).b(1.0f).h(this.f16001a).i(com.stepos.textinputlayout.a.f16028b).j(new b()).n();
            if (z5) {
                if (this.f16010j != null) {
                    this.f16011k = this.f16002b.getBackground();
                    this.f16002b.setBackground(this.f16010j);
                } else {
                    H.p0(this.f16002b, new ColorStateList(new int[][]{new int[]{R.attr.state_enabled, R.attr.state_focused}, new int[0]}, new int[]{this.f16006f.getCurrentTextColor(), getContext().getResources().getColor(H1.e.f2076D)}));
                    k(this.f16002b, g.f2178N);
                }
            }
        } else if (this.f16006f.getVisibility() == 0) {
            H.d(this.f16006f).b(0.0f).h(this.f16001a).i(com.stepos.textinputlayout.a.f16028b).j(new c()).n();
            getContext().getResources();
            Drawable drawable = this.f16011k;
            if (drawable != null) {
                this.f16002b.setBackground(drawable);
            } else {
                H.p0(this.f16002b, null);
            }
            k(this.f16002b, this.f16021u);
        }
        sendAccessibilityEvent(RecyclerView.ItemAnimator.FLAG_MOVED);
    }

    public void setErrorBackground(Drawable drawable) {
        EditText editText;
        this.f16010j = drawable;
        if (!j() || (editText = this.f16002b) == null) {
            return;
        }
        editText.setBackground(this.f16010j);
    }

    public void setErrorBackgroundResource(int i5) {
        EditText editText;
        if (i5 == 0) {
            return;
        }
        this.f16010j = androidx.core.content.a.e(getContext(), i5);
        if (!j() || (editText = this.f16002b) == null) {
            return;
        }
        editText.setBackground(this.f16010j);
    }

    public void setErrorEnabled(boolean z5) throws IllegalAccessException, NoSuchFieldException, NoSuchMethodException, SecurityException, ClassNotFoundException, IllegalArgumentException, InvocationTargetException {
        if (this.f16005e != z5) {
            TextView textView = this.f16006f;
            if (textView != null) {
                H.d(textView).c();
            }
            if (z5) {
                TextView textView2 = new TextView(getContext());
                this.f16006f = textView2;
                textView2.setTextAppearance(getContext(), this.f16007g);
                this.f16006f.setVisibility(4);
                if (TextUtils.getLayoutDirectionFromLocale(Locale.getDefault()) == 1) {
                    this.f16006f.setGravity(8388613);
                }
                addView(this.f16006f);
                EditText editText = this.f16002b;
                if (editText != null) {
                    if (this.f16012l) {
                        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) editText.getLayoutParams();
                        H.x0(this.f16006f, H.C(this.f16002b) + this.f16014n, this.f16018r, H.B(this.f16002b) + this.f16014n, 0);
                        LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.f16006f.getLayoutParams();
                        layoutParams2.leftMargin = layoutParams.leftMargin;
                        layoutParams2.rightMargin = layoutParams.rightMargin;
                        this.f16006f.setLayoutParams(layoutParams2);
                    } else {
                        TextView textView3 = this.f16006f;
                        int i5 = this.f16014n;
                        H.x0(textView3, i5, this.f16018r, i5, 0);
                    }
                }
            } else {
                getContext().getResources();
                Drawable drawable = this.f16011k;
                if (drawable != null) {
                    this.f16002b.setBackground(drawable);
                } else {
                    H.p0(this.f16002b, null);
                }
                k(this.f16002b, this.f16021u);
                removeView(this.f16006f);
                this.f16006f = null;
            }
            this.f16005e = z5;
        }
    }

    public void setErrorPaddingHorizontal(int i5) {
        this.f16014n = i5;
    }

    public void setErrorPaddingTop(int i5) {
        this.f16018r = i5;
        invalidate();
    }

    public void setHint(CharSequence charSequence) {
        this.f16003c = charSequence;
        this.f16015o.D(charSequence);
        sendAccessibilityEvent(RecyclerView.ItemAnimator.FLAG_MOVED);
    }

    public void setHintAnimationEnabled(boolean z5) {
        this.f16016p = z5;
    }

    public void setHintTextAppearance(int i5) {
        this.f16015o.t(i5);
        this.f16009i = ColorStateList.valueOf(this.f16015o.h());
        if (this.f16002b != null) {
            m(false);
            this.f16002b.setLayoutParams(l(this.f16002b.getLayoutParams()));
            this.f16002b.requestLayout();
        }
    }

    public void setLabelEnable(boolean z5) {
        this.f16020t = z5;
    }

    public void setLabelPaddingHorizontal(int i5) {
        this.f16013m = i5;
    }

    public void setOriginBackground(Drawable drawable) {
        EditText editText;
        this.f16011k = drawable;
        if (j() || (editText = this.f16002b) == null) {
            return;
        }
        editText.setBackground(this.f16011k);
    }

    public void setOriginBackgroundResource(int i5) {
        EditText editText;
        if (i5 == 0) {
            return;
        }
        this.f16011k = androidx.core.content.a.e(getContext(), i5);
        if (j() || (editText = this.f16002b) == null) {
            return;
        }
        editText.setBackground(this.f16011k);
    }

    public void setTypeface(Typeface typeface) {
        this.f16015o.F(typeface);
    }

    public TextInputLayout(Context context, AttributeSet attributeSet, int i5) throws IllegalAccessException, NoSuchFieldException, NoSuchMethodException, SecurityException, ClassNotFoundException, IllegalArgumentException, InvocationTargetException {
        super(context, attributeSet);
        this.f16001a = 300;
        com.stepos.textinputlayout.b bVar = new com.stepos.textinputlayout.b(this);
        this.f16015o = bVar;
        this.f16018r = 6;
        this.f16019s = 0;
        this.f16020t = true;
        this.f16021u = -1;
        setOrientation(1);
        setWillNotDraw(false);
        setAddStatesFromChildren(true);
        bVar.E(com.stepos.textinputlayout.a.f16028b);
        bVar.C(new AccelerateInterpolator());
        bVar.v(8388659);
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, m.e6, i5, l.f2377i);
        this.f16003c = typedArrayObtainStyledAttributes.getText(m.g6);
        this.f16016p = typedArrayObtainStyledAttributes.getBoolean(m.m6, true);
        int i6 = m.f6;
        if (typedArrayObtainStyledAttributes.hasValue(i6)) {
            ColorStateList colorStateList = typedArrayObtainStyledAttributes.getColorStateList(i6);
            this.f16009i = colorStateList;
            this.f16008h = colorStateList;
        }
        int i7 = m.n6;
        if (typedArrayObtainStyledAttributes.getResourceId(i7, -1) != -1) {
            setHintTextAppearance(typedArrayObtainStyledAttributes.getResourceId(i7, 0));
        }
        this.f16007g = typedArrayObtainStyledAttributes.getResourceId(m.l6, 0);
        boolean z5 = typedArrayObtainStyledAttributes.getBoolean(m.j6, false);
        this.f16010j = typedArrayObtainStyledAttributes.getDrawable(m.i6);
        this.f16012l = typedArrayObtainStyledAttributes.getBoolean(m.h6, true);
        this.f16013m = typedArrayObtainStyledAttributes.getDimensionPixelSize(m.o6, 0);
        this.f16014n = typedArrayObtainStyledAttributes.getDimensionPixelSize(m.k6, 0);
        typedArrayObtainStyledAttributes.recycle();
        this.f16018r = context.getResources().getDimensionPixelSize(H1.f.f2146h0);
        setErrorEnabled(z5);
        if (H.v(this) == 0) {
            H.t0(this, 1);
        }
        H.k0(this, new e(this, null));
    }
}
