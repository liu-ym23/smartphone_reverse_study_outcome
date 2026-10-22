package com.stepos.textinputlayout;

import B0.f;
import K.J;
import K.S;
import K.e0;
import W2.a;
import W2.b;
import W2.c;
import W2.e;
import W2.h;
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
import android.text.TextPaint;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityNodeInfo;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.Interpolator;
import android.view.animation.PathInterpolator;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.DrawableRes;
import androidx.annotation.Nullable;
import com.baidu.platform.comapi.UIMsg;
import com.google.android.gms.common.api.internal.p;
import com.stepos.alphame.R;
import com.stepos.alphame.utils.Property;
import i2.AbstractC0620a;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Locale;
import java.util.WeakHashMap;
import r0.d;

/* loaded from: classes.dex */
public class TextInputLayout extends LinearLayout {

    /* renamed from: u, reason: collision with root package name */
    public static Field f12386u;

    /* renamed from: v, reason: collision with root package name */
    public static Field f12387v;

    /* renamed from: w, reason: collision with root package name */
    public static Method f12388w;

    /* renamed from: a, reason: collision with root package name */
    public int f12389a;

    /* renamed from: b, reason: collision with root package name */
    public EditText f12390b;

    /* renamed from: c, reason: collision with root package name */
    public CharSequence f12391c;

    /* renamed from: d, reason: collision with root package name */
    public Paint f12392d;

    /* renamed from: e, reason: collision with root package name */
    public boolean f12393e;

    /* renamed from: f, reason: collision with root package name */
    public TextView f12394f;

    /* renamed from: g, reason: collision with root package name */
    public final int f12395g;

    /* renamed from: h, reason: collision with root package name */
    public ColorStateList f12396h;

    /* renamed from: i, reason: collision with root package name */
    public ColorStateList f12397i;

    /* renamed from: j, reason: collision with root package name */
    public Drawable f12398j;

    /* renamed from: k, reason: collision with root package name */
    public Drawable f12399k;

    /* renamed from: l, reason: collision with root package name */
    public boolean f12400l;

    /* renamed from: m, reason: collision with root package name */
    public int f12401m;

    /* renamed from: n, reason: collision with root package name */
    public int f12402n;

    /* renamed from: o, reason: collision with root package name */
    public final b f12403o;

    /* renamed from: p, reason: collision with root package name */
    public boolean f12404p;

    /* renamed from: q, reason: collision with root package name */
    public p f12405q;

    /* renamed from: r, reason: collision with root package name */
    public int f12406r;

    /* renamed from: s, reason: collision with root package name */
    public boolean f12407s;

    /* renamed from: t, reason: collision with root package name */
    public int f12408t;

    public TextInputLayout(Context context, AttributeSet attributeSet) throws Resources.NotFoundException {
        super(context, attributeSet);
        this.f12389a = UIMsg.MsgDefine.RENDER_STATE_FIRST_FRAME;
        b bVar = new b(this);
        this.f12403o = bVar;
        this.f12406r = 6;
        this.f12407s = true;
        this.f12408t = -1;
        setOrientation(1);
        setWillNotDraw(false);
        setAddStatesFromChildren(true);
        bVar.f1996B = a.f1994a;
        bVar.d();
        bVar.f1995A = new AccelerateInterpolator();
        bVar.d();
        if (bVar.f2004h != 8388659) {
            bVar.f2004h = 8388659;
            bVar.d();
        }
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, AbstractC0620a.f13036r, 0, R.style.StepOSTextInputLayoutTextAppearance);
        this.f12391c = typedArrayObtainStyledAttributes.getText(1);
        this.f12404p = typedArrayObtainStyledAttributes.getBoolean(8, true);
        if (typedArrayObtainStyledAttributes.hasValue(0)) {
            ColorStateList colorStateList = typedArrayObtainStyledAttributes.getColorStateList(0);
            this.f12397i = colorStateList;
            this.f12396h = colorStateList;
        }
        if (typedArrayObtainStyledAttributes.getResourceId(9, -1) != -1) {
            setHintTextAppearance(typedArrayObtainStyledAttributes.getResourceId(9, 0));
        }
        this.f12395g = typedArrayObtainStyledAttributes.getResourceId(7, 0);
        boolean z4 = typedArrayObtainStyledAttributes.getBoolean(5, false);
        this.f12398j = typedArrayObtainStyledAttributes.getDrawable(4);
        this.f12400l = typedArrayObtainStyledAttributes.getBoolean(2, true);
        this.f12401m = typedArrayObtainStyledAttributes.getDimensionPixelSize(10, 0);
        this.f12402n = typedArrayObtainStyledAttributes.getDimensionPixelSize(6, 0);
        typedArrayObtainStyledAttributes.recycle();
        this.f12406r = context.getResources().getDimensionPixelSize(R.dimen.stepos_text_input_layout_default_margin_top);
        setErrorEnabled(z4);
        WeakHashMap weakHashMap = S.f939a;
        if (getImportantForAccessibility() == 0) {
            setImportantForAccessibility(1);
        }
        S.h(this, new d(this));
    }

    private Interpolator getInterpolator() {
        return new PathInterpolator(0.1f, Property.DEFAULT_FLOAT_VALUE, 0.1f, 1.0f);
    }

    public final void a(float f4) {
        b bVar = this.f12403o;
        if (bVar.f1999c == f4) {
            return;
        }
        if (this.f12405q == null) {
            p pVar = new p(25, new h());
            this.f12405q = pVar;
            ((f) pVar.f9664b).u0(getInterpolator());
            p pVar2 = this.f12405q;
            ((f) pVar2.f9664b).s0(this.f12389a);
            p pVar3 = this.f12405q;
            ((f) pVar3.f9664b).y0(new e(pVar3, new p(24, this)));
        }
        p pVar4 = this.f12405q;
        ((f) pVar4.f9664b).t0(bVar.f1999c, f4);
        ((f) this.f12405q.f9664b).A0();
    }

    @Override // android.view.ViewGroup
    public final void addView(View view, int i4, ViewGroup.LayoutParams layoutParams) {
        if (!(view instanceof EditText)) {
            super.addView(view, i4, layoutParams);
        } else {
            setEditText((EditText) view);
            super.addView(view, 0, d(layoutParams));
        }
    }

    public final boolean b() {
        TextView textView = this.f12394f;
        return textView != null && textView.getVisibility() == 0;
    }

    public final void c(EditText editText, int i4) throws IllegalAccessException, NoSuchFieldException, NoSuchMethodException, SecurityException, ClassNotFoundException, IllegalArgumentException, InvocationTargetException {
        if (i4 < 0) {
            return;
        }
        try {
            if (f12386u == null) {
                Field declaredField = TextView.class.getDeclaredField("mCursorDrawableRes");
                f12386u = declaredField;
                declaredField.setAccessible(true);
                this.f12408t = f12386u.getInt(editText);
            }
            f12386u.setInt(editText, 0);
            if (f12387v == null) {
                Field declaredField2 = TextView.class.getDeclaredField("mEditor");
                f12387v = declaredField2;
                declaredField2.setAccessible(true);
            }
            Object obj = f12387v.get(editText);
            Class<?> cls = Class.forName("android.widget.Editor");
            if (f12388w == null) {
                Method declaredMethod = cls.getDeclaredMethod("updateCursorPosition", new Class[0]);
                f12388w = declaredMethod;
                declaredMethod.setAccessible(true);
            }
            f12388w.invoke(obj, new Object[0]);
            f12386u.setInt(editText, i4);
        } catch (Exception e4) {
            e4.printStackTrace();
        }
    }

    public final LinearLayout.LayoutParams d(ViewGroup.LayoutParams layoutParams) {
        LinearLayout.LayoutParams layoutParams2 = layoutParams instanceof LinearLayout.LayoutParams ? (LinearLayout.LayoutParams) layoutParams : new LinearLayout.LayoutParams(layoutParams);
        if (this.f12392d == null) {
            this.f12392d = new Paint();
        }
        Paint paint = this.f12392d;
        b bVar = this.f12403o;
        paint.setTypeface(bVar.f2022z.getTypeface());
        this.f12392d.setTextSize(bVar.f2006j);
        layoutParams2.topMargin = 0;
        return layoutParams2;
    }

    @Override // android.view.View
    public final void draw(Canvas canvas) {
        super.draw(canvas);
        if (this.f12407s) {
            b bVar = this.f12403o;
            bVar.getClass();
            int iSave = canvas.save();
            if (bVar.f2016t != null && bVar.f1998b) {
                float f4 = bVar.f2013q;
                float f5 = bVar.f2014r;
                TextPaint textPaint = bVar.f2022z;
                textPaint.setTextSize(bVar.f2020x);
                textPaint.ascent();
                textPaint.descent();
                if (Float.compare(bVar.f2019w, 1.0f) != 0) {
                    float f6 = bVar.f2019w;
                    canvas.scale(f6, f6, f4, f5);
                }
                CharSequence charSequence = bVar.f2016t;
                canvas.drawText(charSequence, 0, charSequence.length(), f4, f5, textPaint);
            }
            canvas.restoreToCount(iSave);
        }
    }

    public final void e(boolean z4) {
        EditText editText = this.f12390b;
        boolean z5 = false;
        boolean z6 = (editText == null || TextUtils.isEmpty(editText.getText())) ? false : true;
        int[] drawableState = getDrawableState();
        int length = drawableState.length;
        int i4 = 0;
        while (true) {
            if (i4 >= length) {
                break;
            }
            if (drawableState[i4] == 16842908) {
                z5 = true;
                break;
            }
            i4++;
        }
        ColorStateList colorStateList = this.f12396h;
        b bVar = this.f12403o;
        if (colorStateList != null && this.f12397i != null) {
            int defaultColor = colorStateList.getDefaultColor();
            if (bVar.f2007k != defaultColor) {
                bVar.f2007k = defaultColor;
                bVar.d();
            }
            int defaultColor2 = z5 ? this.f12397i.getDefaultColor() : this.f12396h.getDefaultColor();
            if (bVar.f2008l != defaultColor2) {
                bVar.f2008l = defaultColor2;
                bVar.d();
            }
        }
        if (z6 || z5) {
            p pVar = this.f12405q;
            if (pVar != null && ((f) pVar.f9664b).R()) {
                ((f) this.f12405q.f9664b).e();
            }
            if (z4 && this.f12404p) {
                a(1.0f);
                return;
            } else {
                bVar.e(1.0f);
                return;
            }
        }
        p pVar2 = this.f12405q;
        if (pVar2 != null && ((f) pVar2.f9664b).R()) {
            ((f) this.f12405q.f9664b).e();
        }
        if (z4 && this.f12404p) {
            a(Property.DEFAULT_FLOAT_VALUE);
        } else {
            bVar.e(Property.DEFAULT_FLOAT_VALUE);
        }
    }

    @Nullable
    public EditText getEditText() {
        return this.f12390b;
    }

    @Nullable
    public CharSequence getError() {
        TextView textView;
        if (this.f12393e && (textView = this.f12394f) != null && textView.getVisibility() == 0) {
            return this.f12394f.getText();
        }
        return null;
    }

    public boolean getErrorEnabled() {
        return this.f12393e;
    }

    public TextView getErrorView() {
        return this.f12394f;
    }

    @Nullable
    public CharSequence getHint() {
        return this.f12391c;
    }

    public boolean getLabelEnable() {
        return this.f12407s;
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
    public final void onLayout(boolean z4, int i4, int i5, int i6, int i7) {
        int left;
        int right;
        super.onLayout(z4, i4, i5, i6, i7);
        EditText editText = this.f12390b;
        if (editText != null) {
            int compoundPaddingLeft = this.f12390b.getCompoundPaddingLeft() + editText.getLeft();
            int right2 = this.f12390b.getRight() - this.f12390b.getCompoundPaddingRight();
            if (this.f12400l) {
                left = this.f12390b.getCompoundPaddingLeft() + this.f12390b.getLeft();
                right = this.f12390b.getRight() - this.f12390b.getCompoundPaddingRight();
            } else {
                left = this.f12390b.getLeft();
                right = this.f12390b.getRight();
            }
            int i8 = this.f12401m;
            int i9 = left + i8;
            int i10 = right + i8;
            int compoundPaddingTop = this.f12390b.getCompoundPaddingTop() + this.f12390b.getTop();
            int bottom = this.f12390b.getBottom() - this.f12390b.getCompoundPaddingBottom();
            b bVar = this.f12403o;
            Rect rect = bVar.f2000d;
            if (!(rect.left == compoundPaddingLeft && rect.top == compoundPaddingTop && rect.right == right2 && rect.bottom == bottom)) {
                rect.set(compoundPaddingLeft, compoundPaddingTop, right2, bottom);
                bVar.f2021y = true;
                bVar.c();
            }
            int paddingTop = getPaddingTop();
            int paddingBottom = (i7 - i5) - getPaddingBottom();
            Rect rect2 = bVar.f2001e;
            if (rect2.left != i9 || rect2.top != paddingTop || rect2.right != i10 || rect2.bottom != paddingBottom) {
                rect2.set(i9, paddingTop, i10, paddingBottom);
                bVar.f2021y = true;
                bVar.c();
            }
            bVar.d();
        }
    }

    @Override // android.view.View
    public final void refreshDrawableState() {
        super.refreshDrawableState();
        WeakHashMap weakHashMap = S.f939a;
        e(isLaidOut());
    }

    public void setAlignEditContent(boolean z4) {
        this.f12400l = z4;
    }

    public void setAnimationDuration(int i4) {
        this.f12389a = i4;
    }

    public void setCollapsedTextColor(int i4) {
        this.f12397i = ColorStateList.valueOf(i4);
    }

    public void setEditText(EditText editText) {
        if (this.f12390b != null) {
            throw new IllegalArgumentException("We already have an EditText, can only have one");
        }
        this.f12390b = editText;
        if (TextUtils.getLayoutDirectionFromLocale(Locale.getDefault()) == 1) {
            this.f12390b.setTextDirection(4);
        }
        Typeface typeface = this.f12390b.getTypeface();
        b bVar = this.f12403o;
        if (typeface == null) {
            bVar.getClass();
            typeface = Typeface.DEFAULT;
        }
        TextPaint textPaint = bVar.f2022z;
        if (textPaint.getTypeface() != typeface) {
            textPaint.setTypeface(typeface);
            bVar.d();
        }
        float textSize = this.f12390b.getTextSize();
        if (Float.compare(bVar.f2005i, textSize) != 0) {
            bVar.f2005i = textSize;
            bVar.d();
        }
        int gravity = this.f12390b.getGravity();
        if (bVar.f2003g != gravity) {
            bVar.f2003g = gravity;
            bVar.d();
        }
        this.f12390b.addTextChangedListener(new c(1, this));
        if (this.f12396h == null) {
            this.f12396h = this.f12390b.getHintTextColors();
        }
        if (TextUtils.isEmpty(this.f12391c)) {
            setHint(this.f12390b.getHint());
            this.f12390b.setHint((CharSequence) null);
        }
        TextView textView = this.f12394f;
        if (textView != null) {
            if (this.f12400l) {
                LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.f12390b.getLayoutParams();
                TextView textView2 = this.f12394f;
                EditText editText2 = this.f12390b;
                WeakHashMap weakHashMap = S.f939a;
                textView2.setPaddingRelative(editText2.getPaddingStart() + this.f12402n, this.f12406r, this.f12390b.getPaddingEnd() + this.f12402n, 0);
                LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.f12394f.getLayoutParams();
                layoutParams2.leftMargin = layoutParams.leftMargin;
                layoutParams2.rightMargin = layoutParams.rightMargin;
                this.f12394f.setLayoutParams(layoutParams2);
            } else {
                int i4 = this.f12402n;
                int i5 = this.f12406r;
                WeakHashMap weakHashMap2 = S.f939a;
                textView.setPaddingRelative(i4, i5, i4, 0);
            }
        }
        e(false);
    }

    public void setError(@Nullable CharSequence charSequence) throws IllegalAccessException, NoSuchFieldException, NoSuchMethodException, SecurityException, ClassNotFoundException, IllegalArgumentException, InvocationTargetException {
        boolean z4;
        if (this.f12393e) {
            z4 = false;
        } else {
            if (TextUtils.isEmpty(charSequence)) {
                return;
            }
            setErrorEnabled(true);
            z4 = true;
        }
        if (!TextUtils.isEmpty(charSequence)) {
            TextView textView = this.f12394f;
            WeakHashMap weakHashMap = S.f939a;
            textView.setAlpha(Property.DEFAULT_FLOAT_VALUE);
            this.f12394f.setText(charSequence);
            e0 e0VarA = S.a(this.f12394f);
            e0VarA.a(1.0f);
            e0VarA.c(this.f12389a);
            e0VarA.d(a.f1994a);
            e0VarA.e(new W2.d(0));
            e0VarA.g();
            if (z4) {
                if (this.f12398j != null) {
                    this.f12399k = this.f12390b.getBackground();
                    this.f12390b.setBackground(this.f12398j);
                } else {
                    J.q(this.f12390b, new ColorStateList(new int[][]{new int[]{android.R.attr.state_enabled, android.R.attr.state_focused}, new int[0]}, new int[]{this.f12394f.getCurrentTextColor(), getContext().getResources().getColor(R.color.stepos_text_input_normal_color)}));
                    c(this.f12390b, R.drawable.stepos_text_cursor_error_color);
                }
            }
        } else if (this.f12394f.getVisibility() == 0) {
            e0 e0VarA2 = S.a(this.f12394f);
            e0VarA2.a(Property.DEFAULT_FLOAT_VALUE);
            e0VarA2.c(this.f12389a);
            e0VarA2.d(a.f1994a);
            e0VarA2.e(new W2.d(1));
            e0VarA2.g();
            getContext().getResources();
            Drawable drawable = this.f12399k;
            if (drawable != null) {
                this.f12390b.setBackground(drawable);
            } else {
                J.q(this.f12390b, null);
            }
            c(this.f12390b, this.f12408t);
        }
        sendAccessibilityEvent(2048);
    }

    public void setErrorBackground(Drawable drawable) {
        EditText editText;
        this.f12398j = drawable;
        if (!b() || (editText = this.f12390b) == null) {
            return;
        }
        editText.setBackground(this.f12398j);
    }

    public void setErrorBackgroundResource(@DrawableRes int i4) {
        EditText editText;
        if (i4 == 0) {
            return;
        }
        this.f12398j = androidx.core.content.a.b(getContext(), i4);
        if (!b() || (editText = this.f12390b) == null) {
            return;
        }
        editText.setBackground(this.f12398j);
    }

    public void setErrorEnabled(boolean z4) {
        if (this.f12393e != z4) {
            TextView textView = this.f12394f;
            if (textView != null) {
                S.a(textView).b();
            }
            if (z4) {
                TextView textView2 = new TextView(getContext());
                this.f12394f = textView2;
                textView2.setTextAppearance(getContext(), this.f12395g);
                this.f12394f.setVisibility(4);
                if (TextUtils.getLayoutDirectionFromLocale(Locale.getDefault()) == 1) {
                    this.f12394f.setGravity(8388613);
                }
                addView(this.f12394f);
                EditText editText = this.f12390b;
                if (editText != null) {
                    if (this.f12400l) {
                        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) editText.getLayoutParams();
                        TextView textView3 = this.f12394f;
                        EditText editText2 = this.f12390b;
                        WeakHashMap weakHashMap = S.f939a;
                        textView3.setPaddingRelative(editText2.getPaddingStart() + this.f12402n, this.f12406r, this.f12390b.getPaddingEnd() + this.f12402n, 0);
                        LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.f12394f.getLayoutParams();
                        layoutParams2.leftMargin = layoutParams.leftMargin;
                        layoutParams2.rightMargin = layoutParams.rightMargin;
                        this.f12394f.setLayoutParams(layoutParams2);
                    } else {
                        TextView textView4 = this.f12394f;
                        int i4 = this.f12402n;
                        int i5 = this.f12406r;
                        WeakHashMap weakHashMap2 = S.f939a;
                        textView4.setPaddingRelative(i4, i5, i4, 0);
                    }
                }
            } else {
                getContext().getResources();
                Drawable drawable = this.f12399k;
                if (drawable != null) {
                    this.f12390b.setBackground(drawable);
                } else {
                    EditText editText3 = this.f12390b;
                    WeakHashMap weakHashMap3 = S.f939a;
                    J.q(editText3, null);
                }
                c(this.f12390b, this.f12408t);
                removeView(this.f12394f);
                this.f12394f = null;
            }
            this.f12393e = z4;
        }
    }

    public void setErrorPaddingHorizontal(int i4) {
        this.f12402n = i4;
    }

    public void setErrorPaddingTop(int i4) {
        this.f12406r = i4;
        invalidate();
    }

    public void setHint(@Nullable CharSequence charSequence) {
        this.f12391c = charSequence;
        b bVar = this.f12403o;
        if (charSequence == null || !charSequence.equals(bVar.f2015s)) {
            bVar.f2015s = charSequence;
            bVar.f2016t = null;
            Bitmap bitmap = bVar.f2018v;
            if (bitmap != null) {
                bitmap.recycle();
                bVar.f2018v = null;
            }
            bVar.d();
        }
        sendAccessibilityEvent(2048);
    }

    public void setHintAnimationEnabled(boolean z4) {
        this.f12404p = z4;
    }

    /* JADX WARN: Removed duplicated region for block: B:8:0x0042  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void setHintTextAppearance(@androidx.annotation.StyleRes int r8) throws android.content.res.Resources.NotFoundException {
        /*
            r7 = this;
            W2.b r0 = r7.f12403o
            android.view.View r1 = r0.f1997a
            android.content.Context r2 = r1.getContext()
            int[] r3 = g.AbstractC0560a.f12610w
            android.content.res.TypedArray r8 = r2.obtainStyledAttributes(r8, r3)
            r2 = 3
            boolean r2 = r8.hasValue(r2)
            r3 = 0
            if (r2 == 0) goto L4c
            android.content.Context r1 = r1.getContext()
            android.content.res.Resources r2 = r1.getResources()
            java.lang.String r4 = r1.getPackageName()
            java.lang.String r5 = "StepOSThemeColor"
            java.lang.String r6 = "attr"
            int r2 = r2.getIdentifier(r5, r6, r4)
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
            r0.f2008l = r4
            if (r4 != 0) goto L4c
            r1 = -16776961(0xffffffffff0000ff, float:-1.7014636E38)
            r0.f2008l = r1
        L4c:
            boolean r1 = r8.hasValue(r3)
            if (r1 == 0) goto L5c
            float r1 = r0.f2006j
            int r1 = (int) r1
            int r1 = r8.getDimensionPixelSize(r3, r1)
            float r1 = (float) r1
            r0.f2006j = r1
        L5c:
            r8.recycle()
            r0.d()
            int r8 = r0.f2008l
            android.content.res.ColorStateList r8 = android.content.res.ColorStateList.valueOf(r8)
            r7.f12397i = r8
            android.widget.EditText r8 = r7.f12390b
            if (r8 == 0) goto L85
            r7.e(r3)
            android.widget.EditText r8 = r7.f12390b
            android.view.ViewGroup$LayoutParams r8 = r8.getLayoutParams()
            android.widget.LinearLayout$LayoutParams r8 = r7.d(r8)
            android.widget.EditText r0 = r7.f12390b
            r0.setLayoutParams(r8)
            android.widget.EditText r7 = r7.f12390b
            r7.requestLayout()
        L85:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.textinputlayout.TextInputLayout.setHintTextAppearance(int):void");
    }

    public void setLabelEnable(boolean z4) {
        this.f12407s = z4;
    }

    public void setLabelPaddingHorizontal(int i4) {
        this.f12401m = i4;
    }

    public void setOriginBackground(Drawable drawable) {
        EditText editText;
        this.f12399k = drawable;
        if (b() || (editText = this.f12390b) == null) {
            return;
        }
        editText.setBackground(this.f12399k);
    }

    public void setOriginBackgroundResource(@DrawableRes int i4) {
        EditText editText;
        if (i4 == 0) {
            return;
        }
        this.f12399k = androidx.core.content.a.b(getContext(), i4);
        if (b() || (editText = this.f12390b) == null) {
            return;
        }
        editText.setBackground(this.f12399k);
    }

    public void setTypeface(@Nullable Typeface typeface) {
        b bVar = this.f12403o;
        if (typeface == null) {
            bVar.getClass();
            typeface = Typeface.DEFAULT;
        }
        TextPaint textPaint = bVar.f2022z;
        if (textPaint.getTypeface() != typeface) {
            textPaint.setTypeface(typeface);
            bVar.d();
        }
    }
}
