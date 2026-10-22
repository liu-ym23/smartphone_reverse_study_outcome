package androidx.appcompat.widget;

import android.R;
import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.PorterDuff;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.text.InputFilter;
import android.text.TextDirectionHeuristic;
import android.text.TextDirectionHeuristics;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.ActionMode;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputConnection;
import android.view.textclassifier.TextClassifier;
import android.widget.TextView;
import androidx.annotation.DrawableRes;
import androidx.annotation.IntRange;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.Px;
import androidx.annotation.RequiresApi;
import androidx.annotation.RestrictTo;
import androidx.annotation.UiThread;
import e.EnumC0546d;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

/* renamed from: androidx.appcompat.widget.f0, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public class C0200f0 extends TextView {

    /* renamed from: a, reason: collision with root package name */
    public final C0228u f3081a;

    /* renamed from: b, reason: collision with root package name */
    public final C0192b0 f3082b;

    /* renamed from: c, reason: collision with root package name */
    public D f3083c;

    /* renamed from: d, reason: collision with root package name */
    public boolean f3084d;

    /* renamed from: e, reason: collision with root package name */
    public C0196d0 f3085e;

    /* renamed from: f, reason: collision with root package name */
    public Future f3086f;

    public C0200f0(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, R.attr.textViewStyle);
    }

    @NonNull
    private D getEmojiTextViewHelper() {
        if (this.f3083c == null) {
            this.f3083c = new D(this);
        }
        return this.f3083c;
    }

    @Override // android.widget.TextView, android.view.View
    public void drawableStateChanged() {
        super.drawableStateChanged();
        C0228u c0228u = this.f3081a;
        if (c0228u != null) {
            c0228u.a();
        }
        C0192b0 c0192b0 = this.f3082b;
        if (c0192b0 != null) {
            c0192b0.b();
        }
    }

    @Override // android.widget.TextView
    @RestrictTo({EnumC0546d.f12494c})
    public int getAutoSizeMaxTextSize() {
        return super.getAutoSizeMaxTextSize();
    }

    @Override // android.widget.TextView
    @RestrictTo({EnumC0546d.f12494c})
    public int getAutoSizeMinTextSize() {
        return super.getAutoSizeMinTextSize();
    }

    @Override // android.widget.TextView
    @RestrictTo({EnumC0546d.f12494c})
    public int getAutoSizeStepGranularity() {
        return super.getAutoSizeStepGranularity();
    }

    @Override // android.widget.TextView
    @RestrictTo({EnumC0546d.f12494c})
    public int[] getAutoSizeTextAvailableSizes() {
        return super.getAutoSizeTextAvailableSizes();
    }

    @Override // android.widget.TextView
    @SuppressLint({"WrongConstant"})
    @RestrictTo({EnumC0546d.f12494c})
    public int getAutoSizeTextType() {
        return super.getAutoSizeTextType() == 1 ? 1 : 0;
    }

    @Override // android.widget.TextView
    @Nullable
    public ActionMode.Callback getCustomSelectionActionModeCallback() {
        return super.getCustomSelectionActionModeCallback();
    }

    @Override // android.widget.TextView
    public int getFirstBaselineToTopHeight() {
        return getPaddingTop() - getPaint().getFontMetricsInt().top;
    }

    @Override // android.widget.TextView
    public int getLastBaselineToBottomHeight() {
        return getPaddingBottom() + getPaint().getFontMetricsInt().bottom;
    }

    @RequiresApi(api = 26)
    @UiThread
    public InterfaceC0194c0 getSuperCaller() {
        if (this.f3085e == null) {
            if (Build.VERSION.SDK_INT >= 34) {
                this.f3085e = new C0198e0(this);
            } else {
                this.f3085e = new C0196d0(this);
            }
        }
        return this.f3085e;
    }

    @Nullable
    @RestrictTo({EnumC0546d.f12494c})
    public ColorStateList getSupportBackgroundTintList() {
        C0228u c0228u = this.f3081a;
        if (c0228u != null) {
            return c0228u.b();
        }
        return null;
    }

    @Nullable
    @RestrictTo({EnumC0546d.f12494c})
    public PorterDuff.Mode getSupportBackgroundTintMode() {
        C0228u c0228u = this.f3081a;
        if (c0228u != null) {
            return c0228u.c();
        }
        return null;
    }

    @Nullable
    @RestrictTo({EnumC0546d.f12494c})
    public ColorStateList getSupportCompoundDrawablesTintList() {
        return this.f3082b.d();
    }

    @Nullable
    @RestrictTo({EnumC0546d.f12494c})
    public PorterDuff.Mode getSupportCompoundDrawablesTintMode() {
        return this.f3082b.e();
    }

    @Override // android.widget.TextView
    public CharSequence getText() {
        r();
        return super.getText();
    }

    @Override // android.widget.TextView
    @NonNull
    @RequiresApi(api = 26)
    public TextClassifier getTextClassifier() {
        return super.getTextClassifier();
    }

    @NonNull
    public I.d getTextMetricsParamsCompat() {
        return new I.d(androidx.core.widget.m.c(this));
    }

    @Override // android.widget.TextView, android.view.View
    public final InputConnection onCreateInputConnection(EditorInfo editorInfo) {
        InputConnection inputConnectionOnCreateInputConnection = super.onCreateInputConnection(editorInfo);
        this.f3082b.getClass();
        t0.J.B(this, editorInfo, inputConnectionOnCreateInputConnection);
        return inputConnectionOnCreateInputConnection;
    }

    @Override // android.view.View
    public final void onDetachedFromWindow() {
        super.onDetachedFromWindow();
    }

    @Override // android.widget.TextView, android.view.View
    public void onLayout(boolean z4, int i4, int i5, int i6, int i7) {
        super.onLayout(z4, i4, i5, i6, i7);
        C0192b0 c0192b0 = this.f3082b;
        if (c0192b0 != null) {
            c0192b0.getClass();
        }
    }

    @Override // android.widget.TextView, android.view.View
    public void onMeasure(int i4, int i5) {
        r();
        super.onMeasure(i4, i5);
    }

    @Override // android.widget.TextView
    public final void onTextChanged(CharSequence charSequence, int i4, int i5, int i6) {
        super.onTextChanged(charSequence, i4, i5, i6);
    }

    public final void r() {
        Future future = this.f3086f;
        if (future == null) {
            return;
        }
        try {
            this.f3086f = null;
            B0.g.y(future.get());
            throw null;
        } catch (InterruptedException | ExecutionException unused) {
        }
    }

    @Override // android.widget.TextView
    public void setAllCaps(boolean z4) {
        super.setAllCaps(z4);
        getEmojiTextViewHelper().c(z4);
    }

    @Override // android.widget.TextView
    public final void setAutoSizeTextTypeUniformWithConfiguration(int i4, int i5, int i6, int i7) {
        super.setAutoSizeTextTypeUniformWithConfiguration(i4, i5, i6, i7);
    }

    @Override // android.widget.TextView
    public final void setAutoSizeTextTypeUniformWithPresetSizes(int[] iArr, int i4) {
        super.setAutoSizeTextTypeUniformWithPresetSizes(iArr, i4);
    }

    @Override // android.widget.TextView
    @RestrictTo({EnumC0546d.f12494c})
    public void setAutoSizeTextTypeWithDefaults(int i4) {
        super.setAutoSizeTextTypeWithDefaults(i4);
    }

    @Override // android.view.View
    public void setBackgroundDrawable(@Nullable Drawable drawable) {
        super.setBackgroundDrawable(drawable);
        C0228u c0228u = this.f3081a;
        if (c0228u != null) {
            c0228u.e();
        }
    }

    @Override // android.view.View
    public void setBackgroundResource(@DrawableRes int i4) {
        super.setBackgroundResource(i4);
        C0228u c0228u = this.f3081a;
        if (c0228u != null) {
            c0228u.f(i4);
        }
    }

    @Override // android.widget.TextView
    public final void setCompoundDrawables(Drawable drawable, Drawable drawable2, Drawable drawable3, Drawable drawable4) {
        super.setCompoundDrawables(drawable, drawable2, drawable3, drawable4);
        C0192b0 c0192b0 = this.f3082b;
        if (c0192b0 != null) {
            c0192b0.b();
        }
    }

    @Override // android.widget.TextView
    public final void setCompoundDrawablesRelative(Drawable drawable, Drawable drawable2, Drawable drawable3, Drawable drawable4) {
        super.setCompoundDrawablesRelative(drawable, drawable2, drawable3, drawable4);
        C0192b0 c0192b0 = this.f3082b;
        if (c0192b0 != null) {
            c0192b0.b();
        }
    }

    @Override // android.widget.TextView
    public final void setCompoundDrawablesRelativeWithIntrinsicBounds(Drawable drawable, Drawable drawable2, Drawable drawable3, Drawable drawable4) {
        super.setCompoundDrawablesRelativeWithIntrinsicBounds(drawable, drawable2, drawable3, drawable4);
        C0192b0 c0192b0 = this.f3082b;
        if (c0192b0 != null) {
            c0192b0.b();
        }
    }

    @Override // android.widget.TextView
    public final void setCompoundDrawablesWithIntrinsicBounds(Drawable drawable, Drawable drawable2, Drawable drawable3, Drawable drawable4) {
        super.setCompoundDrawablesWithIntrinsicBounds(drawable, drawable2, drawable3, drawable4);
        C0192b0 c0192b0 = this.f3082b;
        if (c0192b0 != null) {
            c0192b0.b();
        }
    }

    @Override // android.widget.TextView
    public void setCustomSelectionActionModeCallback(@Nullable ActionMode.Callback callback) {
        super.setCustomSelectionActionModeCallback(callback);
    }

    public void setEmojiCompatEnabled(boolean z4) {
        getEmojiTextViewHelper().d(z4);
    }

    @Override // android.widget.TextView
    public void setFilters(@NonNull InputFilter[] inputFilterArr) {
        super.setFilters(getEmojiTextViewHelper().a(inputFilterArr));
    }

    @Override // android.widget.TextView
    public void setFirstBaselineToTopHeight(@IntRange(from = 0) @Px int i4) {
        getSuperCaller().k(i4);
    }

    @Override // android.widget.TextView
    public void setLastBaselineToBottomHeight(@IntRange(from = 0) @Px int i4) {
        getSuperCaller().d(i4);
    }

    @Override // android.widget.TextView
    public void setLineHeight(@IntRange(from = 0) @Px int i4) {
        B0.f.v0(this, i4);
    }

    public void setPrecomputedText(@NonNull I.e eVar) {
        throw null;
    }

    @RestrictTo({EnumC0546d.f12494c})
    public void setSupportBackgroundTintList(@Nullable ColorStateList colorStateList) {
        C0228u c0228u = this.f3081a;
        if (c0228u != null) {
            c0228u.h(colorStateList);
        }
    }

    @RestrictTo({EnumC0546d.f12494c})
    public void setSupportBackgroundTintMode(@Nullable PorterDuff.Mode mode) {
        C0228u c0228u = this.f3081a;
        if (c0228u != null) {
            c0228u.i(mode);
        }
    }

    @RestrictTo({EnumC0546d.f12494c})
    public void setSupportCompoundDrawablesTintList(@Nullable ColorStateList colorStateList) {
        C0192b0 c0192b0 = this.f3082b;
        c0192b0.h(colorStateList);
        c0192b0.b();
    }

    @RestrictTo({EnumC0546d.f12494c})
    public void setSupportCompoundDrawablesTintMode(@Nullable PorterDuff.Mode mode) {
        C0192b0 c0192b0 = this.f3082b;
        c0192b0.i(mode);
        c0192b0.b();
    }

    @Override // android.widget.TextView
    public void setTextAppearance(Context context, int i4) {
        super.setTextAppearance(context, i4);
        C0192b0 c0192b0 = this.f3082b;
        if (c0192b0 != null) {
            c0192b0.g(i4, context);
        }
    }

    @Override // android.widget.TextView
    @RequiresApi(api = 26)
    public void setTextClassifier(@Nullable TextClassifier textClassifier) {
        super.setTextClassifier(textClassifier);
    }

    public void setTextFuture(@Nullable Future<I.e> future) {
        this.f3086f = future;
        if (future != null) {
            requestLayout();
        }
    }

    public void setTextMetricsParamsCompat(@NonNull I.d dVar) {
        TextDirectionHeuristic textDirectionHeuristic;
        TextDirectionHeuristic textDirectionHeuristic2 = dVar.f820b;
        TextDirectionHeuristic textDirectionHeuristic3 = TextDirectionHeuristics.FIRSTSTRONG_RTL;
        int i4 = 1;
        if (textDirectionHeuristic2 != textDirectionHeuristic3 && textDirectionHeuristic2 != (textDirectionHeuristic = TextDirectionHeuristics.FIRSTSTRONG_LTR)) {
            if (textDirectionHeuristic2 == TextDirectionHeuristics.ANYRTL_LTR) {
                i4 = 2;
            } else if (textDirectionHeuristic2 == TextDirectionHeuristics.LTR) {
                i4 = 3;
            } else if (textDirectionHeuristic2 == TextDirectionHeuristics.RTL) {
                i4 = 4;
            } else if (textDirectionHeuristic2 == TextDirectionHeuristics.LOCALE) {
                i4 = 5;
            } else if (textDirectionHeuristic2 == textDirectionHeuristic) {
                i4 = 6;
            } else if (textDirectionHeuristic2 == textDirectionHeuristic3) {
                i4 = 7;
            }
        }
        setTextDirection(i4);
        getPaint().set(dVar.f819a);
        androidx.core.widget.l.e(this, dVar.f821c);
        androidx.core.widget.l.h(this, dVar.f822d);
    }

    @Override // android.widget.TextView
    public final void setTextSize(int i4, float f4) {
        super.setTextSize(i4, f4);
    }

    @Override // android.widget.TextView
    public final void setTypeface(Typeface typeface, int i4) {
        Typeface typefaceCreate;
        if (this.f3084d) {
            return;
        }
        if (typeface == null || i4 <= 0) {
            typefaceCreate = null;
        } else {
            Context context = getContext();
            D.h hVar = D.g.f364a;
            if (context == null) {
                throw new IllegalArgumentException("Context cannot be null");
            }
            typefaceCreate = Typeface.create(typeface, i4);
        }
        this.f3084d = true;
        if (typefaceCreate != null) {
            typeface = typefaceCreate;
        }
        try {
            super.setTypeface(typeface, i4);
        } finally {
            this.f3084d = false;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C0200f0(Context context, AttributeSet attributeSet, int i4) throws Resources.NotFoundException {
        super(context, attributeSet, i4);
        W0.a(context);
        this.f3084d = false;
        this.f3085e = null;
        V0.a(getContext(), this);
        C0228u c0228u = new C0228u(this);
        this.f3081a = c0228u;
        c0228u.d(attributeSet, i4);
        C0192b0 c0192b0 = new C0192b0(this);
        this.f3082b = c0192b0;
        c0192b0.f(attributeSet, i4);
        c0192b0.b();
        getEmojiTextViewHelper().b(attributeSet, i4);
    }

    @Override // android.widget.TextView
    public final void setLineHeight(int i4, float f4) {
        int i5 = Build.VERSION.SDK_INT;
        if (i5 >= 34) {
            getSuperCaller().m(i4, f4);
        } else if (i5 >= 34) {
            androidx.core.widget.n.a(this, i4, f4);
        } else {
            B0.f.v0(this, Math.round(TypedValue.applyDimension(i4, f4, getResources().getDisplayMetrics())));
        }
    }

    @Override // android.widget.TextView
    public final void setCompoundDrawablesRelativeWithIntrinsicBounds(int i4, int i5, int i6, int i7) {
        Context context = getContext();
        setCompoundDrawablesRelativeWithIntrinsicBounds(i4 != 0 ? Z2.I.o(context, i4) : null, i5 != 0 ? Z2.I.o(context, i5) : null, i6 != 0 ? Z2.I.o(context, i6) : null, i7 != 0 ? Z2.I.o(context, i7) : null);
        C0192b0 c0192b0 = this.f3082b;
        if (c0192b0 != null) {
            c0192b0.b();
        }
    }

    @Override // android.widget.TextView
    public final void setCompoundDrawablesWithIntrinsicBounds(int i4, int i5, int i6, int i7) {
        Context context = getContext();
        setCompoundDrawablesWithIntrinsicBounds(i4 != 0 ? Z2.I.o(context, i4) : null, i5 != 0 ? Z2.I.o(context, i5) : null, i6 != 0 ? Z2.I.o(context, i6) : null, i7 != 0 ? Z2.I.o(context, i7) : null);
        C0192b0 c0192b0 = this.f3082b;
        if (c0192b0 != null) {
            c0192b0.b();
        }
    }
}
