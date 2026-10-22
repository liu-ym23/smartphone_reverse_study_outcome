package com.stepos.textinputlayout;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.text.Editable;
import android.text.TextPaint;
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
import com.stepos.aiengine.R;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Locale;
import java.util.WeakHashMap;
import mb.y;
import v0.e0;
import v0.h0;
import wa.f;
import wa.g;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public class TextInputLayout extends LinearLayout {

    /* renamed from: x, reason: collision with root package name */
    public static Field f8109x;

    /* renamed from: y, reason: collision with root package name */
    public static Field f8110y;
    public static Method z;

    /* renamed from: a, reason: collision with root package name */
    public int f8111a;

    /* renamed from: b, reason: collision with root package name */
    public EditText f8112b;

    /* renamed from: c, reason: collision with root package name */
    public CharSequence f8113c;

    /* renamed from: d, reason: collision with root package name */
    public Paint f8114d;

    /* renamed from: e, reason: collision with root package name */
    public boolean f8115e;
    public TextView h;

    /* renamed from: j, reason: collision with root package name */
    public final int f8116j;

    /* renamed from: k, reason: collision with root package name */
    public ColorStateList f8117k;

    /* renamed from: l, reason: collision with root package name */
    public ColorStateList f8118l;

    /* renamed from: m, reason: collision with root package name */
    public Drawable f8119m;

    /* renamed from: n, reason: collision with root package name */
    public Drawable f8120n;

    /* renamed from: o, reason: collision with root package name */
    public boolean f8121o;

    /* renamed from: p, reason: collision with root package name */
    public int f8122p;

    /* renamed from: q, reason: collision with root package name */
    public int f8123q;
    public final wa.b r;

    /* renamed from: s, reason: collision with root package name */
    public boolean f8124s;

    /* renamed from: t, reason: collision with root package name */
    public wa.e f8125t;

    /* renamed from: u, reason: collision with root package name */
    public int f8126u;

    /* renamed from: v, reason: collision with root package name */
    public boolean f8127v;

    /* renamed from: w, reason: collision with root package name */
    public int f8128w;

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public class b extends y {
        @Override // mb.y, v0.i0
        public final void e(View view) {
            view.setVisibility(0);
        }
    }

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public class c extends y {
        @Override // mb.y, v0.i0
        public final void d(View view) {
            view.setVisibility(4);
        }
    }

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public class d {
        public d() {
        }
    }

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public class e extends v0.a {
        public e() {
        }

        @Override // v0.a
        public final void onInitializeAccessibilityEvent(View view, AccessibilityEvent accessibilityEvent) {
            super.onInitializeAccessibilityEvent(view, accessibilityEvent);
            accessibilityEvent.setClassName("TextInputLayout");
        }

        @Override // v0.a
        public final void onInitializeAccessibilityNodeInfo(View view, w0.b bVar) {
            super.onInitializeAccessibilityNodeInfo(view, bVar);
            bVar.h("TextInputLayout");
            AccessibilityNodeInfo accessibilityNodeInfo = bVar.f13532a;
            TextInputLayout textInputLayout = TextInputLayout.this;
            CharSequence charSequence = textInputLayout.r.f13640s;
            if (!TextUtils.isEmpty(charSequence)) {
                bVar.m(charSequence);
            }
            EditText editText = textInputLayout.f8112b;
            if (editText != null) {
                accessibilityNodeInfo.setLabelFor(editText);
            }
            TextView textView = textInputLayout.h;
            CharSequence text = textView != null ? textView.getText() : null;
            if (TextUtils.isEmpty(text)) {
                return;
            }
            accessibilityNodeInfo.setContentInvalid(true);
            accessibilityNodeInfo.setError(text);
        }

        @Override // v0.a
        public final void onPopulateAccessibilityEvent(View view, AccessibilityEvent accessibilityEvent) {
            super.onPopulateAccessibilityEvent(view, accessibilityEvent);
            CharSequence charSequence = TextInputLayout.this.r.f13640s;
            if (TextUtils.isEmpty(charSequence)) {
                return;
            }
            accessibilityEvent.getText().add(charSequence);
        }
    }

    public TextInputLayout(Context context, AttributeSet attributeSet) throws IllegalAccessException, NoSuchFieldException, Resources.NotFoundException, NoSuchMethodException, SecurityException, ClassNotFoundException, IllegalArgumentException, InvocationTargetException {
        super(context, attributeSet);
        this.f8111a = 300;
        wa.b bVar = new wa.b(this);
        this.r = bVar;
        this.f8126u = 6;
        this.f8127v = true;
        this.f8128w = -1;
        setOrientation(1);
        setWillNotDraw(false);
        setAddStatesFromChildren(true);
        bVar.B = wa.a.f13623a;
        bVar.d();
        bVar.A = new AccelerateInterpolator();
        bVar.d();
        if (bVar.h != 8388659) {
            bVar.h = 8388659;
            bVar.d();
        }
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, g8.a.r, 0, R.style.StepOSTextInputLayoutTextAppearance);
        this.f8113c = typedArrayObtainStyledAttributes.getText(1);
        this.f8124s = typedArrayObtainStyledAttributes.getBoolean(8, true);
        if (typedArrayObtainStyledAttributes.hasValue(0)) {
            ColorStateList colorStateList = typedArrayObtainStyledAttributes.getColorStateList(0);
            this.f8118l = colorStateList;
            this.f8117k = colorStateList;
        }
        if (typedArrayObtainStyledAttributes.getResourceId(9, -1) != -1) {
            setHintTextAppearance(typedArrayObtainStyledAttributes.getResourceId(9, 0));
        }
        this.f8116j = typedArrayObtainStyledAttributes.getResourceId(7, 0);
        boolean z3 = typedArrayObtainStyledAttributes.getBoolean(5, false);
        this.f8119m = typedArrayObtainStyledAttributes.getDrawable(4);
        this.f8121o = typedArrayObtainStyledAttributes.getBoolean(2, true);
        this.f8122p = typedArrayObtainStyledAttributes.getDimensionPixelSize(10, 0);
        this.f8123q = typedArrayObtainStyledAttributes.getDimensionPixelSize(6, 0);
        typedArrayObtainStyledAttributes.recycle();
        this.f8126u = context.getResources().getDimensionPixelSize(R.dimen.stepos_text_input_layout_default_margin_top);
        setErrorEnabled(z3);
        WeakHashMap<View, h0> weakHashMap = e0.f13274a;
        if (getImportantForAccessibility() == 0) {
            setImportantForAccessibility(1);
        }
        e0.j(this, new e());
    }

    private Interpolator getInterpolator() {
        return new PathInterpolator(0.1f, 0.0f, 0.1f, 1.0f);
    }

    public final void a(float f8) {
        wa.b bVar = this.r;
        if (bVar.f13626c == f8) {
            return;
        }
        if (this.f8125t == null) {
            g gVar = new g();
            this.f8125t = new wa.e(gVar);
            gVar.f13652a.setInterpolator(getInterpolator());
            this.f8125t.f13650a.f13652a.setDuration(this.f8111a);
            wa.e eVar = this.f8125t;
            eVar.f13650a.f13652a.addUpdateListener(new f(new wa.d(eVar, new d())));
        }
        this.f8125t.f13650a.f13652a.setFloatValues(bVar.f13626c, f8);
        this.f8125t.f13650a.f13652a.start();
    }

    @Override // android.view.ViewGroup
    public final void addView(View view, int i10, ViewGroup.LayoutParams layoutParams) {
        if (!(view instanceof EditText)) {
            super.addView(view, i10, layoutParams);
        } else {
            setEditText((EditText) view);
            super.addView(view, 0, d(layoutParams));
        }
    }

    public final boolean b() {
        TextView textView = this.h;
        return textView != null && textView.getVisibility() == 0;
    }

    public final void c(EditText editText, int i10) throws IllegalAccessException, NoSuchFieldException, NoSuchMethodException, SecurityException, ClassNotFoundException, IllegalArgumentException, InvocationTargetException {
        if (i10 < 0) {
            return;
        }
        try {
            if (f8109x == null) {
                Field declaredField = TextView.class.getDeclaredField("mCursorDrawableRes");
                f8109x = declaredField;
                declaredField.setAccessible(true);
                this.f8128w = f8109x.getInt(editText);
            }
            f8109x.setInt(editText, 0);
            if (f8110y == null) {
                Field declaredField2 = TextView.class.getDeclaredField("mEditor");
                f8110y = declaredField2;
                declaredField2.setAccessible(true);
            }
            Object obj = f8110y.get(editText);
            Class<?> cls = Class.forName("android.widget.Editor");
            if (z == null) {
                Method declaredMethod = cls.getDeclaredMethod("updateCursorPosition", null);
                z = declaredMethod;
                declaredMethod.setAccessible(true);
            }
            z.invoke(obj, null);
            f8109x.setInt(editText, i10);
        } catch (Exception e10) {
            e10.printStackTrace();
        }
    }

    public final LinearLayout.LayoutParams d(ViewGroup.LayoutParams layoutParams) {
        LinearLayout.LayoutParams layoutParams2 = layoutParams instanceof LinearLayout.LayoutParams ? (LinearLayout.LayoutParams) layoutParams : new LinearLayout.LayoutParams(layoutParams);
        if (this.f8114d == null) {
            this.f8114d = new Paint();
        }
        Paint paint = this.f8114d;
        wa.b bVar = this.r;
        paint.setTypeface(bVar.z.getTypeface());
        this.f8114d.setTextSize(bVar.f13632j);
        layoutParams2.topMargin = 0;
        return layoutParams2;
    }

    @Override // android.view.View
    public final void draw(Canvas canvas) {
        Canvas canvas2;
        super.draw(canvas);
        if (this.f8127v) {
            wa.b bVar = this.r;
            TextPaint textPaint = bVar.z;
            int iSave = canvas.save();
            if (bVar.f13641t == null || !bVar.f13625b) {
                canvas2 = canvas;
            } else {
                float f8 = bVar.f13639q;
                float f9 = bVar.r;
                textPaint.setTextSize(bVar.f13645x);
                textPaint.ascent();
                textPaint.descent();
                if (Float.compare(bVar.f13644w, 1.0f) != 0) {
                    float f10 = bVar.f13644w;
                    canvas.scale(f10, f10, f8, f9);
                }
                CharSequence charSequence = bVar.f13641t;
                canvas2 = canvas;
                canvas2.drawText(charSequence, 0, charSequence.length(), f8, f9, textPaint);
            }
            canvas2.restoreToCount(iSave);
        }
    }

    public final void e(boolean z3) {
        EditText editText = this.f8112b;
        boolean z10 = false;
        boolean z11 = (editText == null || TextUtils.isEmpty(editText.getText())) ? false : true;
        int[] drawableState = getDrawableState();
        int length = drawableState.length;
        int i10 = 0;
        while (true) {
            if (i10 >= length) {
                break;
            }
            if (drawableState[i10] == 16842908) {
                z10 = true;
                break;
            }
            i10++;
        }
        ColorStateList colorStateList = this.f8117k;
        wa.b bVar = this.r;
        if (colorStateList != null && this.f8118l != null) {
            int defaultColor = colorStateList.getDefaultColor();
            if (bVar.f13633k != defaultColor) {
                bVar.f13633k = defaultColor;
                bVar.d();
            }
            int defaultColor2 = z10 ? this.f8118l.getDefaultColor() : this.f8117k.getDefaultColor();
            if (bVar.f13634l != defaultColor2) {
                bVar.f13634l = defaultColor2;
                bVar.d();
            }
        }
        if (z11 || z10) {
            wa.e eVar = this.f8125t;
            if (eVar != null && eVar.f13650a.f13652a.isRunning()) {
                this.f8125t.f13650a.f13652a.cancel();
            }
            if (z3 && this.f8124s) {
                a(1.0f);
                return;
            } else {
                bVar.e(1.0f);
                return;
            }
        }
        wa.e eVar2 = this.f8125t;
        if (eVar2 != null && eVar2.f13650a.f13652a.isRunning()) {
            this.f8125t.f13650a.f13652a.cancel();
        }
        if (z3 && this.f8124s) {
            a(0.0f);
        } else {
            bVar.e(0.0f);
        }
    }

    public EditText getEditText() {
        return this.f8112b;
    }

    public CharSequence getError() {
        TextView textView;
        if (this.f8115e && (textView = this.h) != null && textView.getVisibility() == 0) {
            return this.h.getText();
        }
        return null;
    }

    public boolean getErrorEnabled() {
        return this.f8115e;
    }

    public TextView getErrorView() {
        return this.h;
    }

    public CharSequence getHint() {
        return this.f8113c;
    }

    public boolean getLabelEnable() {
        return this.f8127v;
    }

    public int getLabelTextHeight() {
        return 0;
    }

    @Override // android.view.View
    public final void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo accessibilityNodeInfo) {
        super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
        accessibilityNodeInfo.setClassName(TextInputLayout.class.getName());
    }

    @Override // android.widget.LinearLayout, android.view.ViewGroup, android.view.View
    public final void onLayout(boolean z3, int i10, int i11, int i12, int i13) {
        int left;
        int right;
        super.onLayout(z3, i10, i11, i12, i13);
        EditText editText = this.f8112b;
        if (editText != null) {
            int compoundPaddingLeft = this.f8112b.getCompoundPaddingLeft() + editText.getLeft();
            int right2 = this.f8112b.getRight() - this.f8112b.getCompoundPaddingRight();
            if (this.f8121o) {
                left = this.f8112b.getCompoundPaddingLeft() + this.f8112b.getLeft();
                right = this.f8112b.getRight() - this.f8112b.getCompoundPaddingRight();
            } else {
                left = this.f8112b.getLeft();
                right = this.f8112b.getRight();
            }
            int i14 = this.f8122p;
            int i15 = left + i14;
            int i16 = right + i14;
            int compoundPaddingTop = this.f8112b.getCompoundPaddingTop() + this.f8112b.getTop();
            int bottom = this.f8112b.getBottom() - this.f8112b.getCompoundPaddingBottom();
            wa.b bVar = this.r;
            Rect rect = bVar.f13627d;
            if (rect.left != compoundPaddingLeft || rect.top != compoundPaddingTop || rect.right != right2 || rect.bottom != bottom) {
                rect.set(compoundPaddingLeft, compoundPaddingTop, right2, bottom);
                bVar.f13646y = true;
                bVar.c();
            }
            int paddingTop = getPaddingTop();
            int paddingBottom = (i13 - i11) - getPaddingBottom();
            Rect rect2 = bVar.f13628e;
            if (rect2.left != i15 || rect2.top != paddingTop || rect2.right != i16 || rect2.bottom != paddingBottom) {
                rect2.set(i15, paddingTop, i16, paddingBottom);
                bVar.f13646y = true;
                bVar.c();
            }
            bVar.d();
        }
    }

    @Override // android.view.View
    public final void refreshDrawableState() {
        super.refreshDrawableState();
        WeakHashMap<View, h0> weakHashMap = e0.f13274a;
        e(isLaidOut());
    }

    public void setAlignEditContent(boolean z3) {
        this.f8121o = z3;
    }

    public void setAnimationDuration(int i10) {
        this.f8111a = i10;
    }

    public void setCollapsedTextColor(int i10) {
        this.f8118l = ColorStateList.valueOf(i10);
    }

    public void setEditText(EditText editText) {
        if (this.f8112b != null) {
            throw new IllegalArgumentException("We already have an EditText, can only have one");
        }
        this.f8112b = editText;
        if (TextUtils.getLayoutDirectionFromLocale(Locale.getDefault()) == 1) {
            this.f8112b.setTextDirection(4);
        }
        Typeface typeface = this.f8112b.getTypeface();
        wa.b bVar = this.r;
        TextPaint textPaint = bVar.z;
        if (typeface == null) {
            typeface = Typeface.DEFAULT;
        }
        if (textPaint.getTypeface() != typeface) {
            textPaint.setTypeface(typeface);
            bVar.d();
        }
        float textSize = this.f8112b.getTextSize();
        if (Float.compare(bVar.f13631i, textSize) != 0) {
            bVar.f13631i = textSize;
            bVar.d();
        }
        int gravity = this.f8112b.getGravity();
        if (bVar.f13630g != gravity) {
            bVar.f13630g = gravity;
            bVar.d();
        }
        this.f8112b.addTextChangedListener(new a());
        if (this.f8117k == null) {
            this.f8117k = this.f8112b.getHintTextColors();
        }
        if (TextUtils.isEmpty(this.f8113c)) {
            setHint(this.f8112b.getHint());
            this.f8112b.setHint((CharSequence) null);
        }
        TextView textView = this.h;
        if (textView != null) {
            if (this.f8121o) {
                LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.f8112b.getLayoutParams();
                TextView textView2 = this.h;
                EditText editText2 = this.f8112b;
                WeakHashMap<View, h0> weakHashMap = e0.f13274a;
                textView2.setPaddingRelative(editText2.getPaddingStart() + this.f8123q, this.f8126u, this.f8112b.getPaddingEnd() + this.f8123q, 0);
                LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.h.getLayoutParams();
                layoutParams2.leftMargin = layoutParams.leftMargin;
                layoutParams2.rightMargin = layoutParams.rightMargin;
                this.h.setLayoutParams(layoutParams2);
            } else {
                int i10 = this.f8123q;
                int i11 = this.f8126u;
                WeakHashMap<View, h0> weakHashMap2 = e0.f13274a;
                textView.setPaddingRelative(i10, i11, i10, 0);
            }
        }
        e(false);
    }

    public void setError(CharSequence charSequence) throws IllegalAccessException, NoSuchFieldException, NoSuchMethodException, SecurityException, ClassNotFoundException, IllegalArgumentException, InvocationTargetException {
        boolean z3;
        if (this.f8115e) {
            z3 = false;
        } else {
            if (TextUtils.isEmpty(charSequence)) {
                return;
            }
            z3 = true;
            setErrorEnabled(true);
        }
        if (!TextUtils.isEmpty(charSequence)) {
            TextView textView = this.h;
            WeakHashMap<View, h0> weakHashMap = e0.f13274a;
            textView.setAlpha(0.0f);
            this.h.setText(charSequence);
            h0 h0VarA = e0.a(this.h);
            h0VarA.a(1.0f);
            h0VarA.c(this.f8111a);
            h0VarA.d(wa.a.f13623a);
            h0VarA.e(new b());
            h0VarA.g();
            if (z3) {
                if (this.f8119m != null) {
                    this.f8120n = this.f8112b.getBackground();
                    this.f8112b.setBackground(this.f8119m);
                } else {
                    e0.d.h(this.f8112b, new ColorStateList(new int[][]{new int[]{android.R.attr.state_enabled, android.R.attr.state_focused}, new int[0]}, new int[]{this.h.getCurrentTextColor(), getContext().getResources().getColor(R.color.stepos_text_input_normal_color)}));
                    c(this.f8112b, R.drawable.stepos_text_cursor_error_color);
                }
            }
        } else if (this.h.getVisibility() == 0) {
            h0 h0VarA2 = e0.a(this.h);
            h0VarA2.a(0.0f);
            h0VarA2.c(this.f8111a);
            h0VarA2.d(wa.a.f13623a);
            h0VarA2.e(new c());
            h0VarA2.g();
            getContext().getResources();
            Drawable drawable = this.f8120n;
            if (drawable != null) {
                this.f8112b.setBackground(drawable);
            } else {
                e0.d.h(this.f8112b, null);
            }
            c(this.f8112b, this.f8128w);
        }
        sendAccessibilityEvent(2048);
    }

    public void setErrorBackground(Drawable drawable) {
        EditText editText;
        this.f8119m = drawable;
        if (!b() || (editText = this.f8112b) == null) {
            return;
        }
        editText.setBackground(this.f8119m);
    }

    public void setErrorBackgroundResource(int i10) {
        EditText editText;
        if (i10 == 0) {
            return;
        }
        this.f8119m = getContext().getDrawable(i10);
        if (!b() || (editText = this.f8112b) == null) {
            return;
        }
        editText.setBackground(this.f8119m);
    }

    public void setErrorEnabled(boolean z3) throws IllegalAccessException, NoSuchFieldException, NoSuchMethodException, SecurityException, ClassNotFoundException, IllegalArgumentException, InvocationTargetException {
        if (this.f8115e != z3) {
            TextView textView = this.h;
            if (textView != null) {
                e0.a(textView).b();
            }
            if (z3) {
                TextView textView2 = new TextView(getContext());
                this.h = textView2;
                textView2.setTextAppearance(getContext(), this.f8116j);
                this.h.setVisibility(4);
                if (TextUtils.getLayoutDirectionFromLocale(Locale.getDefault()) == 1) {
                    this.h.setGravity(8388613);
                }
                addView(this.h);
                EditText editText = this.f8112b;
                if (editText != null) {
                    if (this.f8121o) {
                        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) editText.getLayoutParams();
                        TextView textView3 = this.h;
                        EditText editText2 = this.f8112b;
                        WeakHashMap<View, h0> weakHashMap = e0.f13274a;
                        textView3.setPaddingRelative(editText2.getPaddingStart() + this.f8123q, this.f8126u, this.f8112b.getPaddingEnd() + this.f8123q, 0);
                        LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.h.getLayoutParams();
                        layoutParams2.leftMargin = layoutParams.leftMargin;
                        layoutParams2.rightMargin = layoutParams.rightMargin;
                        this.h.setLayoutParams(layoutParams2);
                    } else {
                        TextView textView4 = this.h;
                        int i10 = this.f8123q;
                        int i11 = this.f8126u;
                        WeakHashMap<View, h0> weakHashMap2 = e0.f13274a;
                        textView4.setPaddingRelative(i10, i11, i10, 0);
                    }
                }
            } else {
                getContext().getResources();
                Drawable drawable = this.f8120n;
                if (drawable != null) {
                    this.f8112b.setBackground(drawable);
                } else {
                    EditText editText3 = this.f8112b;
                    WeakHashMap<View, h0> weakHashMap3 = e0.f13274a;
                    e0.d.h(editText3, null);
                }
                c(this.f8112b, this.f8128w);
                removeView(this.h);
                this.h = null;
            }
            this.f8115e = z3;
        }
    }

    public void setErrorPaddingHorizontal(int i10) {
        this.f8123q = i10;
    }

    public void setErrorPaddingTop(int i10) {
        this.f8126u = i10;
        invalidate();
    }

    public void setHint(CharSequence charSequence) {
        this.f8113c = charSequence;
        wa.b bVar = this.r;
        if (charSequence == null || !charSequence.equals(bVar.f13640s)) {
            bVar.f13640s = charSequence;
            bVar.f13641t = null;
            Bitmap bitmap = bVar.f13643v;
            if (bitmap != null) {
                bitmap.recycle();
                bVar.f13643v = null;
            }
            bVar.d();
        }
        sendAccessibilityEvent(2048);
    }

    public void setHintAnimationEnabled(boolean z3) {
        this.f8124s = z3;
    }

    /* JADX WARN: Removed duplicated region for block: B:8:0x0042  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void setHintTextAppearance(int r8) throws android.content.res.Resources.NotFoundException {
        /*
            r7 = this;
            wa.b r0 = r7.r
            com.stepos.textinputlayout.TextInputLayout r1 = r0.f13624a
            android.content.Context r2 = r1.getContext()
            int[] r3 = g.a.f8941w
            android.content.res.TypedArray r8 = r2.obtainStyledAttributes(r8, r3)
            r2 = 3
            boolean r2 = r8.hasValue(r2)
            r3 = 0
            if (r2 == 0) goto L4c
            android.content.Context r1 = r1.getContext()
            android.content.res.Resources r2 = r1.getResources()
            java.lang.String r4 = "attr"
            java.lang.String r5 = r1.getPackageName()
            java.lang.String r6 = "StepOSThemeColor"
            int r2 = r2.getIdentifier(r6, r4, r5)
            if (r2 <= 0) goto L42
            android.content.res.Resources$Theme r1 = r1.getTheme()
            int[] r2 = new int[]{r2}
            android.content.res.TypedArray r1 = r1.obtainStyledAttributes(r2)
            r2 = -1
            int r4 = r1.getColor(r3, r2)
            r1.recycle()
            if (r4 != r2) goto L43
        L42:
            r4 = r3
        L43:
            r0.f13634l = r4
            if (r4 != 0) goto L4c
            r1 = -16776961(0xffffffffff0000ff, float:-1.7014636E38)
            r0.f13634l = r1
        L4c:
            boolean r1 = r8.hasValue(r3)
            if (r1 == 0) goto L5c
            float r1 = r0.f13632j
            int r1 = (int) r1
            int r1 = r8.getDimensionPixelSize(r3, r1)
            float r1 = (float) r1
            r0.f13632j = r1
        L5c:
            r8.recycle()
            r0.d()
            int r8 = r0.f13634l
            android.content.res.ColorStateList r8 = android.content.res.ColorStateList.valueOf(r8)
            r7.f8118l = r8
            android.widget.EditText r8 = r7.f8112b
            if (r8 == 0) goto L85
            r7.e(r3)
            android.widget.EditText r8 = r7.f8112b
            android.view.ViewGroup$LayoutParams r8 = r8.getLayoutParams()
            android.widget.LinearLayout$LayoutParams r8 = r7.d(r8)
            android.widget.EditText r0 = r7.f8112b
            r0.setLayoutParams(r8)
            android.widget.EditText r7 = r7.f8112b
            r7.requestLayout()
        L85:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.textinputlayout.TextInputLayout.setHintTextAppearance(int):void");
    }

    public void setLabelEnable(boolean z3) {
        this.f8127v = z3;
    }

    public void setLabelPaddingHorizontal(int i10) {
        this.f8122p = i10;
    }

    public void setOriginBackground(Drawable drawable) {
        EditText editText;
        this.f8120n = drawable;
        if (b() || (editText = this.f8112b) == null) {
            return;
        }
        editText.setBackground(this.f8120n);
    }

    public void setOriginBackgroundResource(int i10) {
        EditText editText;
        if (i10 == 0) {
            return;
        }
        this.f8120n = getContext().getDrawable(i10);
        if (b() || (editText = this.f8112b) == null) {
            return;
        }
        editText.setBackground(this.f8120n);
    }

    public void setTypeface(Typeface typeface) {
        wa.b bVar = this.r;
        TextPaint textPaint = bVar.z;
        if (typeface == null) {
            typeface = Typeface.DEFAULT;
        }
        if (textPaint.getTypeface() != typeface) {
            textPaint.setTypeface(typeface);
            bVar.d();
        }
    }

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public class a implements TextWatcher {
        public a() {
        }

        @Override // android.text.TextWatcher
        public final void afterTextChanged(Editable editable) {
            Field field = TextInputLayout.f8109x;
            TextInputLayout.this.e(true);
        }

        @Override // android.text.TextWatcher
        public final void onTextChanged(CharSequence charSequence, int i10, int i11, int i12) throws IllegalAccessException, NoSuchFieldException, NoSuchMethodException, SecurityException, ClassNotFoundException, IllegalArgumentException, InvocationTargetException {
            TextInputLayout textInputLayout = TextInputLayout.this;
            EditText editText = textInputLayout.f8112b;
            if (editText == null || editText.getText().length() != 0) {
                return;
            }
            textInputLayout.setErrorEnabled(false);
            textInputLayout.f8112b.setBackgroundTintList(null);
        }

        @Override // android.text.TextWatcher
        public final void beforeTextChanged(CharSequence charSequence, int i10, int i11, int i12) {
        }
    }
}
