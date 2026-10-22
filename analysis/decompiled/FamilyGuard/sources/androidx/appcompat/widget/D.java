package androidx.appcompat.widget;

import android.R;
import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.text.InputFilter;
import android.util.AttributeSet;
import android.view.ActionMode;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputConnection;
import android.view.textclassifier.TextClassifier;
import android.widget.TextView;
import androidx.core.text.d;
import h.C0744a;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

/* loaded from: classes.dex */
public class D extends TextView {

    /* renamed from: a, reason: collision with root package name */
    private final C0435e f8113a;

    /* renamed from: b, reason: collision with root package name */
    private final C f8114b;

    /* renamed from: c, reason: collision with root package name */
    private final B f8115c;

    /* renamed from: d, reason: collision with root package name */
    private C0444n f8116d;

    /* renamed from: e, reason: collision with root package name */
    private boolean f8117e;

    /* renamed from: f, reason: collision with root package name */
    private a f8118f;

    /* renamed from: g, reason: collision with root package name */
    private Future<androidx.core.text.d> f8119g;

    private interface a {
        void a(int[] iArr, int i5);

        int[] b();

        TextClassifier c();

        int d();

        void e(TextClassifier textClassifier);

        void f(int i5);

        void g(int i5, int i6, int i7, int i8);

        int h();

        int i();

        void j(int i5);

        int k();

        void l(int i5);

        void m(int i5, float f5);
    }

    class b implements a {
        b() {
        }

        @Override // androidx.appcompat.widget.D.a
        public void a(int[] iArr, int i5) {
            D.super.setAutoSizeTextTypeUniformWithPresetSizes(iArr, i5);
        }

        @Override // androidx.appcompat.widget.D.a
        public int[] b() {
            return D.super.getAutoSizeTextAvailableSizes();
        }

        @Override // androidx.appcompat.widget.D.a
        public TextClassifier c() {
            return D.super.getTextClassifier();
        }

        @Override // androidx.appcompat.widget.D.a
        public int d() {
            return D.super.getAutoSizeMaxTextSize();
        }

        @Override // androidx.appcompat.widget.D.a
        public void e(TextClassifier textClassifier) {
            D.super.setTextClassifier(textClassifier);
        }

        @Override // androidx.appcompat.widget.D.a
        public void g(int i5, int i6, int i7, int i8) {
            D.super.setAutoSizeTextTypeUniformWithConfiguration(i5, i6, i7, i8);
        }

        @Override // androidx.appcompat.widget.D.a
        public int h() {
            return D.super.getAutoSizeTextType();
        }

        @Override // androidx.appcompat.widget.D.a
        public int i() {
            return D.super.getAutoSizeMinTextSize();
        }

        @Override // androidx.appcompat.widget.D.a
        public int k() {
            return D.super.getAutoSizeStepGranularity();
        }

        @Override // androidx.appcompat.widget.D.a
        public void l(int i5) {
            D.super.setAutoSizeTextTypeWithDefaults(i5);
        }

        @Override // androidx.appcompat.widget.D.a
        public void m(int i5, float f5) {
        }
    }

    class c extends b {
        c() {
            super();
        }

        @Override // androidx.appcompat.widget.D.a
        public void f(int i5) {
            D.super.setLastBaselineToBottomHeight(i5);
        }

        @Override // androidx.appcompat.widget.D.a
        public void j(int i5) {
            D.super.setFirstBaselineToTopHeight(i5);
        }
    }

    class d extends c {
        d() {
            super();
        }

        @Override // androidx.appcompat.widget.D.b, androidx.appcompat.widget.D.a
        public void m(int i5, float f5) {
            D.super.setLineHeight(i5, f5);
        }
    }

    public D(Context context) {
        this(context, null);
    }

    private C0444n getEmojiTextViewHelper() {
        if (this.f8116d == null) {
            this.f8116d = new C0444n(this);
        }
        return this.f8116d;
    }

    private void s() {
        Future<androidx.core.text.d> future = this.f8119g;
        if (future != null) {
            try {
                this.f8119g = null;
                androidx.core.widget.i.l(this, future.get());
            } catch (InterruptedException | ExecutionException unused) {
            }
        }
    }

    @Override // android.widget.TextView, android.view.View
    protected void drawableStateChanged() {
        super.drawableStateChanged();
        C0435e c0435e = this.f8113a;
        if (c0435e != null) {
            c0435e.b();
        }
        C c6 = this.f8114b;
        if (c6 != null) {
            c6.b();
        }
    }

    @Override // android.widget.TextView
    public int getAutoSizeMaxTextSize() {
        if (h0.f8559a) {
            return getSuperCaller().d();
        }
        C c6 = this.f8114b;
        if (c6 != null) {
            return c6.e();
        }
        return -1;
    }

    @Override // android.widget.TextView
    public int getAutoSizeMinTextSize() {
        if (h0.f8559a) {
            return getSuperCaller().i();
        }
        C c6 = this.f8114b;
        if (c6 != null) {
            return c6.f();
        }
        return -1;
    }

    @Override // android.widget.TextView
    public int getAutoSizeStepGranularity() {
        if (h0.f8559a) {
            return getSuperCaller().k();
        }
        C c6 = this.f8114b;
        if (c6 != null) {
            return c6.g();
        }
        return -1;
    }

    @Override // android.widget.TextView
    public int[] getAutoSizeTextAvailableSizes() {
        if (h0.f8559a) {
            return getSuperCaller().b();
        }
        C c6 = this.f8114b;
        return c6 != null ? c6.h() : new int[0];
    }

    @Override // android.widget.TextView
    public int getAutoSizeTextType() {
        if (h0.f8559a) {
            return getSuperCaller().h() == 1 ? 1 : 0;
        }
        C c6 = this.f8114b;
        if (c6 != null) {
            return c6.i();
        }
        return 0;
    }

    @Override // android.widget.TextView
    public ActionMode.Callback getCustomSelectionActionModeCallback() {
        return androidx.core.widget.i.o(super.getCustomSelectionActionModeCallback());
    }

    @Override // android.widget.TextView
    public int getFirstBaselineToTopHeight() {
        return androidx.core.widget.i.a(this);
    }

    @Override // android.widget.TextView
    public int getLastBaselineToBottomHeight() {
        return androidx.core.widget.i.b(this);
    }

    a getSuperCaller() {
        if (this.f8118f == null) {
            if (Build.VERSION.SDK_INT >= 34) {
                this.f8118f = new d();
            } else {
                this.f8118f = new c();
            }
        }
        return this.f8118f;
    }

    public ColorStateList getSupportBackgroundTintList() {
        C0435e c0435e = this.f8113a;
        if (c0435e != null) {
            return c0435e.c();
        }
        return null;
    }

    public PorterDuff.Mode getSupportBackgroundTintMode() {
        C0435e c0435e = this.f8113a;
        if (c0435e != null) {
            return c0435e.d();
        }
        return null;
    }

    public ColorStateList getSupportCompoundDrawablesTintList() {
        return this.f8114b.j();
    }

    public PorterDuff.Mode getSupportCompoundDrawablesTintMode() {
        return this.f8114b.k();
    }

    @Override // android.widget.TextView
    public CharSequence getText() {
        s();
        return super.getText();
    }

    @Override // android.widget.TextView
    public TextClassifier getTextClassifier() {
        return getSuperCaller().c();
    }

    public d.a getTextMetricsParamsCompat() {
        return androidx.core.widget.i.d(this);
    }

    @Override // android.widget.TextView, android.view.View
    public InputConnection onCreateInputConnection(EditorInfo editorInfo) {
        InputConnection inputConnectionOnCreateInputConnection = super.onCreateInputConnection(editorInfo);
        this.f8114b.r(this, inputConnectionOnCreateInputConnection, editorInfo);
        return C0445o.a(inputConnectionOnCreateInputConnection, editorInfo, this);
    }

    @Override // android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
    }

    @Override // android.widget.TextView, android.view.View
    protected void onLayout(boolean z5, int i5, int i6, int i7, int i8) {
        super.onLayout(z5, i5, i6, i7, i8);
        C c6 = this.f8114b;
        if (c6 != null) {
            c6.o(z5, i5, i6, i7, i8);
        }
    }

    @Override // android.widget.TextView, android.view.View
    protected void onMeasure(int i5, int i6) {
        s();
        super.onMeasure(i5, i6);
    }

    @Override // android.widget.TextView
    protected void onTextChanged(CharSequence charSequence, int i5, int i6, int i7) {
        super.onTextChanged(charSequence, i5, i6, i7);
        C c6 = this.f8114b;
        if (c6 == null || h0.f8559a || !c6.l()) {
            return;
        }
        this.f8114b.c();
    }

    @Override // android.widget.TextView
    public void setAllCaps(boolean z5) {
        super.setAllCaps(z5);
        getEmojiTextViewHelper().d(z5);
    }

    @Override // android.widget.TextView
    public void setAutoSizeTextTypeUniformWithConfiguration(int i5, int i6, int i7, int i8) {
        if (h0.f8559a) {
            getSuperCaller().g(i5, i6, i7, i8);
            return;
        }
        C c6 = this.f8114b;
        if (c6 != null) {
            c6.t(i5, i6, i7, i8);
        }
    }

    @Override // android.widget.TextView
    public void setAutoSizeTextTypeUniformWithPresetSizes(int[] iArr, int i5) {
        if (h0.f8559a) {
            getSuperCaller().a(iArr, i5);
            return;
        }
        C c6 = this.f8114b;
        if (c6 != null) {
            c6.u(iArr, i5);
        }
    }

    @Override // android.widget.TextView
    public void setAutoSizeTextTypeWithDefaults(int i5) {
        if (h0.f8559a) {
            getSuperCaller().l(i5);
            return;
        }
        C c6 = this.f8114b;
        if (c6 != null) {
            c6.v(i5);
        }
    }

    @Override // android.view.View
    public void setBackgroundDrawable(Drawable drawable) {
        super.setBackgroundDrawable(drawable);
        C0435e c0435e = this.f8113a;
        if (c0435e != null) {
            c0435e.f(drawable);
        }
    }

    @Override // android.view.View
    public void setBackgroundResource(int i5) {
        super.setBackgroundResource(i5);
        C0435e c0435e = this.f8113a;
        if (c0435e != null) {
            c0435e.g(i5);
        }
    }

    @Override // android.widget.TextView
    public void setCompoundDrawables(Drawable drawable, Drawable drawable2, Drawable drawable3, Drawable drawable4) {
        super.setCompoundDrawables(drawable, drawable2, drawable3, drawable4);
        C c6 = this.f8114b;
        if (c6 != null) {
            c6.p();
        }
    }

    @Override // android.widget.TextView
    public void setCompoundDrawablesRelative(Drawable drawable, Drawable drawable2, Drawable drawable3, Drawable drawable4) {
        super.setCompoundDrawablesRelative(drawable, drawable2, drawable3, drawable4);
        C c6 = this.f8114b;
        if (c6 != null) {
            c6.p();
        }
    }

    @Override // android.widget.TextView
    public void setCompoundDrawablesRelativeWithIntrinsicBounds(Drawable drawable, Drawable drawable2, Drawable drawable3, Drawable drawable4) {
        super.setCompoundDrawablesRelativeWithIntrinsicBounds(drawable, drawable2, drawable3, drawable4);
        C c6 = this.f8114b;
        if (c6 != null) {
            c6.p();
        }
    }

    @Override // android.widget.TextView
    public void setCompoundDrawablesWithIntrinsicBounds(Drawable drawable, Drawable drawable2, Drawable drawable3, Drawable drawable4) {
        super.setCompoundDrawablesWithIntrinsicBounds(drawable, drawable2, drawable3, drawable4);
        C c6 = this.f8114b;
        if (c6 != null) {
            c6.p();
        }
    }

    @Override // android.widget.TextView
    public void setCustomSelectionActionModeCallback(ActionMode.Callback callback) {
        super.setCustomSelectionActionModeCallback(androidx.core.widget.i.p(this, callback));
    }

    public void setEmojiCompatEnabled(boolean z5) {
        getEmojiTextViewHelper().e(z5);
    }

    @Override // android.widget.TextView
    public void setFilters(InputFilter[] inputFilterArr) {
        super.setFilters(getEmojiTextViewHelper().a(inputFilterArr));
    }

    @Override // android.widget.TextView
    public void setFirstBaselineToTopHeight(int i5) {
        getSuperCaller().j(i5);
    }

    @Override // android.widget.TextView
    public void setLastBaselineToBottomHeight(int i5) {
        getSuperCaller().f(i5);
    }

    @Override // android.widget.TextView
    public void setLineHeight(int i5) {
        androidx.core.widget.i.j(this, i5);
    }

    public void setPrecomputedText(androidx.core.text.d dVar) {
        androidx.core.widget.i.l(this, dVar);
    }

    public void setSupportBackgroundTintList(ColorStateList colorStateList) {
        C0435e c0435e = this.f8113a;
        if (c0435e != null) {
            c0435e.i(colorStateList);
        }
    }

    public void setSupportBackgroundTintMode(PorterDuff.Mode mode) {
        C0435e c0435e = this.f8113a;
        if (c0435e != null) {
            c0435e.j(mode);
        }
    }

    public void setSupportCompoundDrawablesTintList(ColorStateList colorStateList) {
        this.f8114b.w(colorStateList);
        this.f8114b.b();
    }

    public void setSupportCompoundDrawablesTintMode(PorterDuff.Mode mode) {
        this.f8114b.x(mode);
        this.f8114b.b();
    }

    @Override // android.widget.TextView
    public void setTextAppearance(Context context, int i5) {
        super.setTextAppearance(context, i5);
        C c6 = this.f8114b;
        if (c6 != null) {
            c6.q(context, i5);
        }
    }

    @Override // android.widget.TextView
    public void setTextClassifier(TextClassifier textClassifier) {
        getSuperCaller().e(textClassifier);
    }

    public void setTextFuture(Future<androidx.core.text.d> future) {
        this.f8119g = future;
        if (future != null) {
            requestLayout();
        }
    }

    public void setTextMetricsParamsCompat(d.a aVar) {
        androidx.core.widget.i.n(this, aVar);
    }

    @Override // android.widget.TextView
    public void setTextSize(int i5, float f5) {
        if (h0.f8559a) {
            super.setTextSize(i5, f5);
            return;
        }
        C c6 = this.f8114b;
        if (c6 != null) {
            c6.A(i5, f5);
        }
    }

    @Override // android.widget.TextView
    public void setTypeface(Typeface typeface, int i5) {
        if (this.f8117e) {
            return;
        }
        Typeface typefaceA = (typeface == null || i5 <= 0) ? null : androidx.core.graphics.e.a(getContext(), typeface, i5);
        this.f8117e = true;
        if (typefaceA != null) {
            typeface = typefaceA;
        }
        try {
            super.setTypeface(typeface, i5);
        } finally {
            this.f8117e = false;
        }
    }

    public D(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, R.attr.textViewStyle);
    }

    @Override // android.widget.TextView
    public void setLineHeight(int i5, float f5) {
        if (Build.VERSION.SDK_INT >= 34) {
            getSuperCaller().m(i5, f5);
        } else {
            androidx.core.widget.i.k(this, i5, f5);
        }
    }

    public D(Context context, AttributeSet attributeSet, int i5) {
        super(X.b(context), attributeSet, i5);
        this.f8117e = false;
        this.f8118f = null;
        V.a(this, getContext());
        C0435e c0435e = new C0435e(this);
        this.f8113a = c0435e;
        c0435e.e(attributeSet, i5);
        C c6 = new C(this);
        this.f8114b = c6;
        c6.m(attributeSet, i5);
        c6.b();
        this.f8115c = new B(this);
        getEmojiTextViewHelper().c(attributeSet, i5);
    }

    @Override // android.widget.TextView
    public void setCompoundDrawablesRelativeWithIntrinsicBounds(int i5, int i6, int i7, int i8) {
        Context context = getContext();
        setCompoundDrawablesRelativeWithIntrinsicBounds(i5 != 0 ? C0744a.b(context, i5) : null, i6 != 0 ? C0744a.b(context, i6) : null, i7 != 0 ? C0744a.b(context, i7) : null, i8 != 0 ? C0744a.b(context, i8) : null);
        C c6 = this.f8114b;
        if (c6 != null) {
            c6.p();
        }
    }

    @Override // android.widget.TextView
    public void setCompoundDrawablesWithIntrinsicBounds(int i5, int i6, int i7, int i8) {
        Context context = getContext();
        setCompoundDrawablesWithIntrinsicBounds(i5 != 0 ? C0744a.b(context, i5) : null, i6 != 0 ? C0744a.b(context, i6) : null, i7 != 0 ? C0744a.b(context, i7) : null, i8 != 0 ? C0744a.b(context, i8) : null);
        C c6 = this.f8114b;
        if (c6 != null) {
            c6.p();
        }
    }
}
