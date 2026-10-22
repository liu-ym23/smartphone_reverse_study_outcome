package com.stepos.textinputlayout;

import A0.b;
import J4.c;
import M0.k;
import V4.s;
import android.animation.ValueAnimator;
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
import androidx.core.content.ContextCompat;
import androidx.core.view.GravityCompat;
import androidx.core.view.ViewCompat;
import com.google.android.material.internal.a;
import com.stepos.ability.R;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Locale;
import v6.AbstractC2060a;
import v6.C2061b;
import v6.d;
import w0.C2086g;

/* loaded from: classes3.dex */
public class TextInputLayout extends LinearLayout {
    public static Field u;

    /* renamed from: v, reason: collision with root package name */
    public static Field f4078v;

    /* renamed from: w, reason: collision with root package name */
    public static Method f4079w;

    /* renamed from: a, reason: collision with root package name */
    public int f4080a;
    public EditText b;
    public CharSequence c;
    public Paint d;
    public boolean e;
    public TextView f;
    public final int g;
    public ColorStateList h;
    public ColorStateList i;

    /* renamed from: j, reason: collision with root package name */
    public Drawable f4081j;
    public Drawable k;
    public boolean l;
    public int m;
    public int n;
    public final C2061b o;
    public boolean p;

    /* renamed from: q, reason: collision with root package name */
    public b f4082q;

    /* renamed from: r, reason: collision with root package name */
    public int f4083r;

    /* renamed from: s, reason: collision with root package name */
    public boolean f4084s;

    /* renamed from: t, reason: collision with root package name */
    public int f4085t;

    public TextInputLayout(Context context, AttributeSet attributeSet) throws Resources.NotFoundException {
        super(context, attributeSet);
        this.f4080a = 300;
        C2061b c2061b = new C2061b(this);
        this.o = c2061b;
        this.f4083r = 6;
        this.f4084s = true;
        this.f4085t = -1;
        setOrientation(1);
        setWillNotDraw(false);
        setAddStatesFromChildren(true);
        c2061b.f6772B = AbstractC2060a.f6770a;
        c2061b.d();
        c2061b.f6771A = new AccelerateInterpolator();
        c2061b.d();
        if (c2061b.h != 8388659) {
            c2061b.h = 8388659;
            c2061b.d();
        }
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, s.f1374r, 0, R.style.StepOSTextInputLayoutTextAppearance);
        this.c = typedArrayObtainStyledAttributes.getText(1);
        this.p = typedArrayObtainStyledAttributes.getBoolean(8, true);
        if (typedArrayObtainStyledAttributes.hasValue(0)) {
            ColorStateList colorStateList = typedArrayObtainStyledAttributes.getColorStateList(0);
            this.i = colorStateList;
            this.h = colorStateList;
        }
        if (typedArrayObtainStyledAttributes.getResourceId(9, -1) != -1) {
            setHintTextAppearance(typedArrayObtainStyledAttributes.getResourceId(9, 0));
        }
        this.g = typedArrayObtainStyledAttributes.getResourceId(7, 0);
        boolean z10 = typedArrayObtainStyledAttributes.getBoolean(5, false);
        this.f4081j = typedArrayObtainStyledAttributes.getDrawable(4);
        this.l = typedArrayObtainStyledAttributes.getBoolean(2, true);
        this.m = typedArrayObtainStyledAttributes.getDimensionPixelSize(10, 0);
        this.n = typedArrayObtainStyledAttributes.getDimensionPixelSize(6, 0);
        typedArrayObtainStyledAttributes.recycle();
        this.f4083r = context.getResources().getDimensionPixelSize(R.dimen.stepos_text_input_layout_default_margin_top);
        setErrorEnabled(z10);
        if (ViewCompat.getImportantForAccessibility(this) == 0) {
            ViewCompat.setImportantForAccessibility(this, 1);
        }
        ViewCompat.setAccessibilityDelegate(this, new a(2, this));
    }

    private Interpolator getInterpolator() {
        return new PathInterpolator(0.1f, 0.0f, 0.1f, 1.0f);
    }

    public final void a(float f) {
        C2061b c2061b = this.o;
        if (c2061b.c == f) {
            return;
        }
        if (this.f4082q == null) {
            Q.a aVar = new Q.a();
            int i = 10;
            this.f4082q = new b(aVar, i);
            ((ValueAnimator) aVar.b).setInterpolator(getInterpolator());
            ((ValueAnimator) ((Q.a) this.f4082q.b).b).setDuration(this.f4080a);
            b bVar = this.f4082q;
            ((ValueAnimator) ((Q.a) bVar.b).b).addUpdateListener(new c(new k(i, bVar, new C2086g(this)), 6));
        }
        ((ValueAnimator) ((Q.a) this.f4082q.b).b).setFloatValues(c2061b.c, f);
        ((ValueAnimator) ((Q.a) this.f4082q.b).b).start();
    }

    @Override // android.view.ViewGroup
    public final void addView(View view, int i, ViewGroup.LayoutParams layoutParams) {
        if (!(view instanceof EditText)) {
            super.addView(view, i, layoutParams);
        } else {
            setEditText((EditText) view);
            super.addView(view, 0, d(layoutParams));
        }
    }

    public final boolean b() {
        TextView textView = this.f;
        return textView != null && textView.getVisibility() == 0;
    }

    public final void c(EditText editText, int i) throws IllegalAccessException, NoSuchFieldException, NoSuchMethodException, SecurityException, ClassNotFoundException, IllegalArgumentException, InvocationTargetException {
        if (i < 0) {
            return;
        }
        try {
            if (u == null) {
                Field declaredField = TextView.class.getDeclaredField("mCursorDrawableRes");
                u = declaredField;
                declaredField.setAccessible(true);
                this.f4085t = u.getInt(editText);
            }
            u.setInt(editText, 0);
            if (f4078v == null) {
                Field declaredField2 = TextView.class.getDeclaredField("mEditor");
                f4078v = declaredField2;
                declaredField2.setAccessible(true);
            }
            Object obj = f4078v.get(editText);
            Class<?> cls = Class.forName("android.widget.Editor");
            if (f4079w == null) {
                Method declaredMethod = cls.getDeclaredMethod("updateCursorPosition", null);
                f4079w = declaredMethod;
                declaredMethod.setAccessible(true);
            }
            f4079w.invoke(obj, null);
            u.setInt(editText, i);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public final LinearLayout.LayoutParams d(ViewGroup.LayoutParams layoutParams) {
        LinearLayout.LayoutParams layoutParams2 = layoutParams instanceof LinearLayout.LayoutParams ? (LinearLayout.LayoutParams) layoutParams : new LinearLayout.LayoutParams(layoutParams);
        if (this.d == null) {
            this.d = new Paint();
        }
        Paint paint = this.d;
        C2061b c2061b = this.o;
        paint.setTypeface(c2061b.f6782z.getTypeface());
        this.d.setTextSize(c2061b.f6774j);
        layoutParams2.topMargin = 0;
        return layoutParams2;
    }

    @Override // android.view.View
    public final void draw(Canvas canvas) {
        Canvas canvas2;
        super.draw(canvas);
        if (this.f4084s) {
            C2061b c2061b = this.o;
            TextPaint textPaint = c2061b.f6782z;
            int iSave = canvas.save();
            if (c2061b.f6778t == null || !c2061b.b) {
                canvas2 = canvas;
            } else {
                float f = c2061b.f6775q;
                float f7 = c2061b.f6776r;
                textPaint.setTextSize(c2061b.f6781x);
                textPaint.ascent();
                textPaint.descent();
                if (Float.compare(c2061b.f6780w, 1.0f) != 0) {
                    float f9 = c2061b.f6780w;
                    canvas.scale(f9, f9, f, f7);
                }
                CharSequence charSequence = c2061b.f6778t;
                canvas2 = canvas;
                canvas2.drawText(charSequence, 0, charSequence.length(), f, f7, textPaint);
            }
            canvas2.restoreToCount(iSave);
        }
    }

    public final void e(boolean z10) {
        EditText editText = this.b;
        boolean z11 = false;
        boolean z12 = (editText == null || TextUtils.isEmpty(editText.getText())) ? false : true;
        int[] drawableState = getDrawableState();
        int length = drawableState.length;
        int i = 0;
        while (true) {
            if (i >= length) {
                break;
            }
            if (drawableState[i] == 16842908) {
                z11 = true;
                break;
            }
            i++;
        }
        ColorStateList colorStateList = this.h;
        C2061b c2061b = this.o;
        if (colorStateList != null && this.i != null) {
            int defaultColor = colorStateList.getDefaultColor();
            if (c2061b.k != defaultColor) {
                c2061b.k = defaultColor;
                c2061b.d();
            }
            int defaultColor2 = z11 ? this.i.getDefaultColor() : this.h.getDefaultColor();
            if (c2061b.l != defaultColor2) {
                c2061b.l = defaultColor2;
                c2061b.d();
            }
        }
        if (z12 || z11) {
            b bVar = this.f4082q;
            if (bVar != null && ((ValueAnimator) ((Q.a) bVar.b).b).isRunning()) {
                ((ValueAnimator) ((Q.a) this.f4082q.b).b).cancel();
            }
            if (z10 && this.p) {
                a(1.0f);
                return;
            } else {
                c2061b.e(1.0f);
                return;
            }
        }
        b bVar2 = this.f4082q;
        if (bVar2 != null && ((ValueAnimator) ((Q.a) bVar2.b).b).isRunning()) {
            ((ValueAnimator) ((Q.a) this.f4082q.b).b).cancel();
        }
        if (z10 && this.p) {
            a(0.0f);
        } else {
            c2061b.e(0.0f);
        }
    }

    @Nullable
    public EditText getEditText() {
        return this.b;
    }

    @Nullable
    public CharSequence getError() {
        TextView textView;
        if (this.e && (textView = this.f) != null && textView.getVisibility() == 0) {
            return this.f.getText();
        }
        return null;
    }

    public boolean getErrorEnabled() {
        return this.e;
    }

    public TextView getErrorView() {
        return this.f;
    }

    @Nullable
    public CharSequence getHint() {
        return this.c;
    }

    public boolean getLabelEnable() {
        return this.f4084s;
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
    public final void onLayout(boolean z10, int i, int i6, int i10, int i11) {
        int left;
        int right;
        super.onLayout(z10, i, i6, i10, i11);
        EditText editText = this.b;
        if (editText != null) {
            int compoundPaddingLeft = this.b.getCompoundPaddingLeft() + editText.getLeft();
            int right2 = this.b.getRight() - this.b.getCompoundPaddingRight();
            if (this.l) {
                left = this.b.getCompoundPaddingLeft() + this.b.getLeft();
                right = this.b.getRight() - this.b.getCompoundPaddingRight();
            } else {
                left = this.b.getLeft();
                right = this.b.getRight();
            }
            int i12 = this.m;
            int i13 = left + i12;
            int i14 = right + i12;
            int compoundPaddingTop = this.b.getCompoundPaddingTop() + this.b.getTop();
            int bottom = this.b.getBottom() - this.b.getCompoundPaddingBottom();
            C2061b c2061b = this.o;
            Rect rect = c2061b.d;
            if (rect.left != compoundPaddingLeft || rect.top != compoundPaddingTop || rect.right != right2 || rect.bottom != bottom) {
                rect.set(compoundPaddingLeft, compoundPaddingTop, right2, bottom);
                c2061b.y = true;
                c2061b.c();
            }
            int paddingTop = getPaddingTop();
            int paddingBottom = (i11 - i6) - getPaddingBottom();
            Rect rect2 = c2061b.e;
            if (rect2.left != i13 || rect2.top != paddingTop || rect2.right != i14 || rect2.bottom != paddingBottom) {
                rect2.set(i13, paddingTop, i14, paddingBottom);
                c2061b.y = true;
                c2061b.c();
            }
            c2061b.d();
        }
    }

    @Override // android.view.View
    public final void refreshDrawableState() {
        super.refreshDrawableState();
        e(ViewCompat.isLaidOut(this));
    }

    public void setAlignEditContent(boolean z10) {
        this.l = z10;
    }

    public void setAnimationDuration(int i) {
        this.f4080a = i;
    }

    public void setCollapsedTextColor(int i) {
        this.i = ColorStateList.valueOf(i);
    }

    public void setEditText(EditText editText) {
        if (this.b != null) {
            throw new IllegalArgumentException("We already have an EditText, can only have one");
        }
        this.b = editText;
        if (TextUtils.getLayoutDirectionFromLocale(Locale.getDefault()) == 1) {
            this.b.setTextDirection(4);
        }
        Typeface typeface = this.b.getTypeface();
        C2061b c2061b = this.o;
        TextPaint textPaint = c2061b.f6782z;
        if (typeface == null) {
            typeface = Typeface.DEFAULT;
        }
        if (textPaint.getTypeface() != typeface) {
            textPaint.setTypeface(typeface);
            c2061b.d();
        }
        float textSize = this.b.getTextSize();
        if (Float.compare(c2061b.i, textSize) != 0) {
            c2061b.i = textSize;
            c2061b.d();
        }
        int gravity = this.b.getGravity();
        if (c2061b.g != gravity) {
            c2061b.g = gravity;
            c2061b.d();
        }
        this.b.addTextChangedListener(new v6.c(1, this));
        if (this.h == null) {
            this.h = this.b.getHintTextColors();
        }
        if (TextUtils.isEmpty(this.c)) {
            setHint(this.b.getHint());
            this.b.setHint((CharSequence) null);
        }
        TextView textView = this.f;
        if (textView != null) {
            if (this.l) {
                LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.b.getLayoutParams();
                ViewCompat.setPaddingRelative(this.f, ViewCompat.getPaddingStart(this.b) + this.n, this.f4083r, ViewCompat.getPaddingEnd(this.b) + this.n, 0);
                LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.f.getLayoutParams();
                layoutParams2.leftMargin = layoutParams.leftMargin;
                layoutParams2.rightMargin = layoutParams.rightMargin;
                this.f.setLayoutParams(layoutParams2);
            } else {
                int i = this.n;
                ViewCompat.setPaddingRelative(textView, i, this.f4083r, i, 0);
            }
        }
        e(false);
    }

    public void setError(@Nullable CharSequence charSequence) throws IllegalAccessException, NoSuchFieldException, NoSuchMethodException, SecurityException, ClassNotFoundException, IllegalArgumentException, InvocationTargetException {
        boolean z10;
        if (this.e) {
            z10 = false;
        } else {
            if (TextUtils.isEmpty(charSequence)) {
                return;
            }
            z10 = true;
            setErrorEnabled(true);
        }
        if (!TextUtils.isEmpty(charSequence)) {
            ViewCompat.setAlpha(this.f, 0.0f);
            this.f.setText(charSequence);
            ViewCompat.animate(this.f).alpha(1.0f).setDuration(this.f4080a).setInterpolator(AbstractC2060a.f6770a).setListener(new d(0)).start();
            if (z10) {
                if (this.f4081j != null) {
                    this.k = this.b.getBackground();
                    this.b.setBackground(this.f4081j);
                } else {
                    ViewCompat.setBackgroundTintList(this.b, new ColorStateList(new int[][]{new int[]{android.R.attr.state_enabled, android.R.attr.state_focused}, new int[0]}, new int[]{this.f.getCurrentTextColor(), getContext().getResources().getColor(R.color.stepos_text_input_normal_color)}));
                    c(this.b, R.drawable.stepos_text_cursor_error_color);
                }
            }
        } else if (this.f.getVisibility() == 0) {
            ViewCompat.animate(this.f).alpha(0.0f).setDuration(this.f4080a).setInterpolator(AbstractC2060a.f6770a).setListener(new d(1)).start();
            getContext().getResources();
            Drawable drawable = this.k;
            if (drawable != null) {
                this.b.setBackground(drawable);
            } else {
                ViewCompat.setBackgroundTintList(this.b, null);
            }
            c(this.b, this.f4085t);
        }
        sendAccessibilityEvent(2048);
    }

    public void setErrorBackground(Drawable drawable) {
        EditText editText;
        this.f4081j = drawable;
        if (!b() || (editText = this.b) == null) {
            return;
        }
        editText.setBackground(this.f4081j);
    }

    public void setErrorBackgroundResource(@DrawableRes int i) {
        EditText editText;
        if (i == 0) {
            return;
        }
        this.f4081j = ContextCompat.getDrawable(getContext(), i);
        if (!b() || (editText = this.b) == null) {
            return;
        }
        editText.setBackground(this.f4081j);
    }

    public void setErrorEnabled(boolean z10) {
        if (this.e != z10) {
            TextView textView = this.f;
            if (textView != null) {
                ViewCompat.animate(textView).cancel();
            }
            if (z10) {
                TextView textView2 = new TextView(getContext());
                this.f = textView2;
                textView2.setTextAppearance(getContext(), this.g);
                this.f.setVisibility(4);
                if (TextUtils.getLayoutDirectionFromLocale(Locale.getDefault()) == 1) {
                    this.f.setGravity(GravityCompat.END);
                }
                addView(this.f);
                EditText editText = this.b;
                if (editText != null) {
                    if (this.l) {
                        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) editText.getLayoutParams();
                        ViewCompat.setPaddingRelative(this.f, ViewCompat.getPaddingStart(this.b) + this.n, this.f4083r, ViewCompat.getPaddingEnd(this.b) + this.n, 0);
                        LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.f.getLayoutParams();
                        layoutParams2.leftMargin = layoutParams.leftMargin;
                        layoutParams2.rightMargin = layoutParams.rightMargin;
                        this.f.setLayoutParams(layoutParams2);
                    } else {
                        TextView textView3 = this.f;
                        int i = this.n;
                        ViewCompat.setPaddingRelative(textView3, i, this.f4083r, i, 0);
                    }
                }
            } else {
                getContext().getResources();
                Drawable drawable = this.k;
                if (drawable != null) {
                    this.b.setBackground(drawable);
                } else {
                    ViewCompat.setBackgroundTintList(this.b, null);
                }
                c(this.b, this.f4085t);
                removeView(this.f);
                this.f = null;
            }
            this.e = z10;
        }
    }

    public void setErrorPaddingHorizontal(int i) {
        this.n = i;
    }

    public void setErrorPaddingTop(int i) {
        this.f4083r = i;
        invalidate();
    }

    public void setHint(@Nullable CharSequence charSequence) {
        this.c = charSequence;
        C2061b c2061b = this.o;
        if (charSequence == null || !charSequence.equals(c2061b.f6777s)) {
            c2061b.f6777s = charSequence;
            c2061b.f6778t = null;
            Bitmap bitmap = c2061b.f6779v;
            if (bitmap != null) {
                bitmap.recycle();
                c2061b.f6779v = null;
            }
            c2061b.d();
        }
        sendAccessibilityEvent(2048);
    }

    public void setHintAnimationEnabled(boolean z10) {
        this.p = z10;
    }

    /* JADX WARN: Removed duplicated region for block: B:8:0x0043  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void setHintTextAppearance(@androidx.annotation.StyleRes int r8) throws android.content.res.Resources.NotFoundException {
        /*
            r7 = this;
            v6.b r0 = r7.o
            com.stepos.textinputlayout.TextInputLayout r1 = r0.f6773a
            android.content.Context r2 = r1.getContext()
            int[] r3 = androidx.appcompat.R.styleable.TextAppearance
            android.content.res.TypedArray r8 = r2.obtainStyledAttributes(r8, r3)
            int r2 = androidx.appcompat.R.styleable.TextAppearance_android_textColor
            boolean r2 = r8.hasValue(r2)
            r3 = 0
            if (r2 == 0) goto L4d
            android.content.Context r1 = r1.getContext()
            android.content.res.Resources r2 = r1.getResources()
            java.lang.String r4 = "attr"
            java.lang.String r5 = r1.getPackageName()
            java.lang.String r6 = "StepOSThemeColor"
            int r2 = r2.getIdentifier(r6, r4, r5)
            if (r2 <= 0) goto L43
            android.content.res.Resources$Theme r1 = r1.getTheme()
            int[] r2 = new int[]{r2}
            android.content.res.TypedArray r1 = r1.obtainStyledAttributes(r2)
            r2 = -1
            int r4 = r1.getColor(r3, r2)
            r1.recycle()
            if (r4 != r2) goto L44
        L43:
            r4 = r3
        L44:
            r0.l = r4
            if (r4 != 0) goto L4d
            r1 = -16776961(0xffffffffff0000ff, float:-1.7014636E38)
            r0.l = r1
        L4d:
            int r1 = androidx.appcompat.R.styleable.TextAppearance_android_textSize
            boolean r1 = r8.hasValue(r1)
            if (r1 == 0) goto L61
            int r1 = androidx.appcompat.R.styleable.TextAppearance_android_textSize
            float r2 = r0.f6774j
            int r2 = (int) r2
            int r1 = r8.getDimensionPixelSize(r1, r2)
            float r1 = (float) r1
            r0.f6774j = r1
        L61:
            r8.recycle()
            r0.d()
            int r8 = r0.l
            android.content.res.ColorStateList r8 = android.content.res.ColorStateList.valueOf(r8)
            r7.i = r8
            android.widget.EditText r8 = r7.b
            if (r8 == 0) goto L8a
            r7.e(r3)
            android.widget.EditText r8 = r7.b
            android.view.ViewGroup$LayoutParams r8 = r8.getLayoutParams()
            android.widget.LinearLayout$LayoutParams r8 = r7.d(r8)
            android.widget.EditText r0 = r7.b
            r0.setLayoutParams(r8)
            android.widget.EditText r7 = r7.b
            r7.requestLayout()
        L8a:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.textinputlayout.TextInputLayout.setHintTextAppearance(int):void");
    }

    public void setLabelEnable(boolean z10) {
        this.f4084s = z10;
    }

    public void setLabelPaddingHorizontal(int i) {
        this.m = i;
    }

    public void setOriginBackground(Drawable drawable) {
        EditText editText;
        this.k = drawable;
        if (b() || (editText = this.b) == null) {
            return;
        }
        editText.setBackground(this.k);
    }

    public void setOriginBackgroundResource(@DrawableRes int i) {
        EditText editText;
        if (i == 0) {
            return;
        }
        this.k = ContextCompat.getDrawable(getContext(), i);
        if (b() || (editText = this.b) == null) {
            return;
        }
        editText.setBackground(this.k);
    }

    public void setTypeface(@Nullable Typeface typeface) {
        C2061b c2061b = this.o;
        TextPaint textPaint = c2061b.f6782z;
        if (typeface == null) {
            typeface = Typeface.DEFAULT;
        }
        if (textPaint.getTypeface() != typeface) {
            textPaint.setTypeface(typeface);
            c2061b.d();
        }
    }
}
