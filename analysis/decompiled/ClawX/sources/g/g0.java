package g;

import android.R;
import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.ColorStateList;
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
import android.view.inputmethod.InputMethodManager;
import android.view.textclassifier.TextClassifier;
import android.widget.TextView;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

/* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
/* loaded from: classes.dex */
public class g0 extends TextView {

    /* renamed from: a, reason: collision with root package name */
    public final n f2706a;

    /* renamed from: b, reason: collision with root package name */
    public final d0 f2707b;

    /* renamed from: c, reason: collision with root package name */
    public u f2708c;
    public boolean d;

    /* renamed from: e, reason: collision with root package name */
    public androidx.emoji2.text.p f2709e;

    /* renamed from: f, reason: collision with root package name */
    public Future f2710f;

    public g0(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, R.attr.textViewStyle);
    }

    private u getEmojiTextViewHelper() {
        if (this.f2708c == null) {
            this.f2708c = new u(this);
        }
        return this.f2708c;
    }

    @Override // android.widget.TextView, android.view.View
    public final void drawableStateChanged() {
        super.drawableStateChanged();
        n nVar = this.f2706a;
        if (nVar != null) {
            nVar.a();
        }
        d0 d0Var = this.f2707b;
        if (d0Var != null) {
            d0Var.b();
        }
    }

    @Override // android.widget.TextView
    public int getAutoSizeMaxTextSize() {
        return super.getAutoSizeMaxTextSize();
    }

    @Override // android.widget.TextView
    public int getAutoSizeMinTextSize() {
        return super.getAutoSizeMinTextSize();
    }

    @Override // android.widget.TextView
    public int getAutoSizeStepGranularity() {
        return super.getAutoSizeStepGranularity();
    }

    @Override // android.widget.TextView
    public int[] getAutoSizeTextAvailableSizes() {
        return super.getAutoSizeTextAvailableSizes();
    }

    @Override // android.widget.TextView
    @SuppressLint({"WrongConstant"})
    public int getAutoSizeTextType() {
        return super.getAutoSizeTextType() == 1 ? 1 : 0;
    }

    @Override // android.widget.TextView
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

    public e0 getSuperCaller() {
        if (this.f2709e == null) {
            if (Build.VERSION.SDK_INT >= 34) {
                this.f2709e = new f0(this);
            } else {
                this.f2709e = new androidx.emoji2.text.p(this);
            }
        }
        return this.f2709e;
    }

    public ColorStateList getSupportBackgroundTintList() {
        n nVar = this.f2706a;
        if (nVar != null) {
            return nVar.b();
        }
        return null;
    }

    public PorterDuff.Mode getSupportBackgroundTintMode() {
        n nVar = this.f2706a;
        if (nVar != null) {
            return nVar.c();
        }
        return null;
    }

    public ColorStateList getSupportCompoundDrawablesTintList() {
        s1 s1Var = this.f2707b.f2682h;
        if (s1Var != null) {
            return (ColorStateList) s1Var.f2824c;
        }
        return null;
    }

    public PorterDuff.Mode getSupportCompoundDrawablesTintMode() {
        s1 s1Var = this.f2707b.f2682h;
        if (s1Var != null) {
            return (PorterDuff.Mode) s1Var.d;
        }
        return null;
    }

    @Override // android.widget.TextView
    public CharSequence getText() {
        Future future = this.f2710f;
        if (future != null) {
            try {
                this.f2710f = null;
                if (future.get() == null) {
                    throw null;
                }
                throw new ClassCastException();
            } catch (InterruptedException | ExecutionException unused) {
            }
        }
        return super.getText();
    }

    @Override // android.widget.TextView
    public TextClassifier getTextClassifier() {
        return super.getTextClassifier();
    }

    public c0.c getTextMetricsParamsCompat() {
        return new c0.c(getTextMetricsParams());
    }

    @Override // android.widget.TextView, android.view.View
    public final InputConnection onCreateInputConnection(EditorInfo editorInfo) {
        InputConnection inputConnectionOnCreateInputConnection = super.onCreateInputConnection(editorInfo);
        this.f2707b.getClass();
        a.a.X(inputConnectionOnCreateInputConnection, editorInfo, this);
        return inputConnectionOnCreateInputConnection;
    }

    @Override // android.view.View
    public final void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        if (Build.VERSION.SDK_INT >= 33 || !onCheckIsTextEditor()) {
            return;
        }
        ((InputMethodManager) getContext().getSystemService("input_method")).isActive(this);
    }

    @Override // android.widget.TextView, android.view.View
    public final void onLayout(boolean z, int i8, int i9, int i10, int i11) {
        super.onLayout(z, i8, i9, i10, i11);
        d0 d0Var = this.f2707b;
        if (d0Var != null) {
            d0Var.getClass();
        }
    }

    @Override // android.widget.TextView, android.view.View
    public void onMeasure(int i8, int i9) {
        Future future = this.f2710f;
        if (future != null) {
            try {
                this.f2710f = null;
                if (future.get() != null) {
                    throw new ClassCastException();
                }
                throw null;
            } catch (InterruptedException | ExecutionException unused) {
            }
        }
        super.onMeasure(i8, i9);
    }

    @Override // android.widget.TextView
    public final void onTextChanged(CharSequence charSequence, int i8, int i9, int i10) {
        super.onTextChanged(charSequence, i8, i9, i10);
    }

    @Override // android.widget.TextView
    public void setAllCaps(boolean z) {
        super.setAllCaps(z);
        ((k4.z) getEmojiTextViewHelper().f2840b.f621a).G(z);
    }

    @Override // android.widget.TextView
    public final void setAutoSizeTextTypeUniformWithConfiguration(int i8, int i9, int i10, int i11) {
        super.setAutoSizeTextTypeUniformWithConfiguration(i8, i9, i10, i11);
    }

    @Override // android.widget.TextView
    public final void setAutoSizeTextTypeUniformWithPresetSizes(int[] iArr, int i8) {
        super.setAutoSizeTextTypeUniformWithPresetSizes(iArr, i8);
    }

    @Override // android.widget.TextView
    public void setAutoSizeTextTypeWithDefaults(int i8) {
        super.setAutoSizeTextTypeWithDefaults(i8);
    }

    @Override // android.view.View
    public void setBackgroundDrawable(Drawable drawable) {
        super.setBackgroundDrawable(drawable);
        n nVar = this.f2706a;
        if (nVar != null) {
            nVar.e();
        }
    }

    @Override // android.view.View
    public void setBackgroundResource(int i8) {
        super.setBackgroundResource(i8);
        n nVar = this.f2706a;
        if (nVar != null) {
            nVar.f(i8);
        }
    }

    @Override // android.widget.TextView
    public final void setCompoundDrawables(Drawable drawable, Drawable drawable2, Drawable drawable3, Drawable drawable4) {
        super.setCompoundDrawables(drawable, drawable2, drawable3, drawable4);
        d0 d0Var = this.f2707b;
        if (d0Var != null) {
            d0Var.b();
        }
    }

    @Override // android.widget.TextView
    public final void setCompoundDrawablesRelative(Drawable drawable, Drawable drawable2, Drawable drawable3, Drawable drawable4) {
        super.setCompoundDrawablesRelative(drawable, drawable2, drawable3, drawable4);
        d0 d0Var = this.f2707b;
        if (d0Var != null) {
            d0Var.b();
        }
    }

    @Override // android.widget.TextView
    public final void setCompoundDrawablesRelativeWithIntrinsicBounds(Drawable drawable, Drawable drawable2, Drawable drawable3, Drawable drawable4) {
        super.setCompoundDrawablesRelativeWithIntrinsicBounds(drawable, drawable2, drawable3, drawable4);
        d0 d0Var = this.f2707b;
        if (d0Var != null) {
            d0Var.b();
        }
    }

    @Override // android.widget.TextView
    public final void setCompoundDrawablesWithIntrinsicBounds(Drawable drawable, Drawable drawable2, Drawable drawable3, Drawable drawable4) {
        super.setCompoundDrawablesWithIntrinsicBounds(drawable, drawable2, drawable3, drawable4);
        d0 d0Var = this.f2707b;
        if (d0Var != null) {
            d0Var.b();
        }
    }

    @Override // android.widget.TextView
    public void setCustomSelectionActionModeCallback(ActionMode.Callback callback) {
        super.setCustomSelectionActionModeCallback(callback);
    }

    public void setEmojiCompatEnabled(boolean z) {
        ((k4.z) getEmojiTextViewHelper().f2840b.f621a).H(z);
    }

    @Override // android.widget.TextView
    public void setFilters(InputFilter[] inputFilterArr) {
        super.setFilters(((k4.z) getEmojiTextViewHelper().f2840b.f621a).v(inputFilterArr));
    }

    @Override // android.widget.TextView
    public void setFirstBaselineToTopHeight(int i8) {
        getSuperCaller().d(i8);
    }

    @Override // android.widget.TextView
    public void setLastBaselineToBottomHeight(int i8) {
        getSuperCaller().a(i8);
    }

    @Override // android.widget.TextView
    public void setLineHeight(int i8) {
        b8.h.L(this, i8);
    }

    public void setPrecomputedText(c0.d dVar) {
        throw null;
    }

    public void setSupportBackgroundTintList(ColorStateList colorStateList) {
        n nVar = this.f2706a;
        if (nVar != null) {
            nVar.h(colorStateList);
        }
    }

    public void setSupportBackgroundTintMode(PorterDuff.Mode mode) {
        n nVar = this.f2706a;
        if (nVar != null) {
            nVar.i(mode);
        }
    }

    public void setSupportCompoundDrawablesTintList(ColorStateList colorStateList) {
        d0 d0Var = this.f2707b;
        d0Var.f(colorStateList);
        d0Var.b();
    }

    public void setSupportCompoundDrawablesTintMode(PorterDuff.Mode mode) {
        d0 d0Var = this.f2707b;
        d0Var.g(mode);
        d0Var.b();
    }

    @Override // android.widget.TextView
    public final void setTextAppearance(Context context, int i8) {
        super.setTextAppearance(context, i8);
        d0 d0Var = this.f2707b;
        if (d0Var != null) {
            d0Var.e(context, i8);
        }
    }

    @Override // android.widget.TextView
    public void setTextClassifier(TextClassifier textClassifier) {
        super.setTextClassifier(textClassifier);
    }

    public void setTextFuture(Future<c0.d> future) {
        this.f2710f = future;
        if (future != null) {
            requestLayout();
        }
    }

    public void setTextMetricsParamsCompat(c0.c cVar) {
        TextDirectionHeuristic textDirectionHeuristic;
        TextDirectionHeuristic textDirectionHeuristic2 = cVar.f1043b;
        TextDirectionHeuristic textDirectionHeuristic3 = TextDirectionHeuristics.FIRSTSTRONG_RTL;
        int i8 = 1;
        if (textDirectionHeuristic2 != textDirectionHeuristic3 && textDirectionHeuristic2 != (textDirectionHeuristic = TextDirectionHeuristics.FIRSTSTRONG_LTR)) {
            if (textDirectionHeuristic2 == TextDirectionHeuristics.ANYRTL_LTR) {
                i8 = 2;
            } else if (textDirectionHeuristic2 == TextDirectionHeuristics.LTR) {
                i8 = 3;
            } else if (textDirectionHeuristic2 == TextDirectionHeuristics.RTL) {
                i8 = 4;
            } else if (textDirectionHeuristic2 == TextDirectionHeuristics.LOCALE) {
                i8 = 5;
            } else if (textDirectionHeuristic2 == textDirectionHeuristic) {
                i8 = 6;
            } else if (textDirectionHeuristic2 == textDirectionHeuristic3) {
                i8 = 7;
            }
        }
        setTextDirection(i8);
        getPaint().set(cVar.f1042a);
        setBreakStrategy(cVar.f1044c);
        setHyphenationFrequency(cVar.d);
    }

    @Override // android.widget.TextView
    public final void setTypeface(Typeface typeface, int i8) {
        Typeface typefaceCreate;
        if (this.d) {
            return;
        }
        if (typeface == null || i8 <= 0) {
            typefaceCreate = null;
        } else {
            Context context = getContext();
            x.e eVar = x.d.f6237a;
            if (context == null) {
                throw new IllegalArgumentException("Context cannot be null");
            }
            typefaceCreate = Typeface.create(typeface, i8);
        }
        this.d = true;
        if (typefaceCreate != null) {
            typeface = typefaceCreate;
        }
        try {
            super.setTypeface(typeface, i8);
        } finally {
            this.d = false;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public g0(Context context, AttributeSet attributeSet, int i8) {
        super(context, attributeSet, i8);
        r1.a(context);
        this.d = false;
        this.f2709e = null;
        q1.a(this, getContext());
        n nVar = new n(this);
        this.f2706a = nVar;
        nVar.d(attributeSet, i8);
        d0 d0Var = new d0(this);
        this.f2707b = d0Var;
        d0Var.d(attributeSet, i8);
        d0Var.b();
        getEmojiTextViewHelper().a(attributeSet, i8);
    }

    @Override // android.widget.TextView
    public final void setLineHeight(int i8, float f3) {
        int i9 = Build.VERSION.SDK_INT;
        if (i9 >= 34) {
            getSuperCaller().f(i8, f3);
        } else if (i9 >= 34) {
            e0.p.h(this, i8, f3);
        } else {
            b8.h.L(this, Math.round(TypedValue.applyDimension(i8, f3, getResources().getDisplayMetrics())));
        }
    }

    @Override // android.widget.TextView
    public final void setCompoundDrawablesRelativeWithIntrinsicBounds(int i8, int i9, int i10, int i11) {
        Context context = getContext();
        setCompoundDrawablesRelativeWithIntrinsicBounds(i8 != 0 ? b8.h.p(context, i8) : null, i9 != 0 ? b8.h.p(context, i9) : null, i10 != 0 ? b8.h.p(context, i10) : null, i11 != 0 ? b8.h.p(context, i11) : null);
        d0 d0Var = this.f2707b;
        if (d0Var != null) {
            d0Var.b();
        }
    }

    @Override // android.widget.TextView
    public final void setCompoundDrawablesWithIntrinsicBounds(int i8, int i9, int i10, int i11) {
        Context context = getContext();
        setCompoundDrawablesWithIntrinsicBounds(i8 != 0 ? b8.h.p(context, i8) : null, i9 != 0 ? b8.h.p(context, i9) : null, i10 != 0 ? b8.h.p(context, i10) : null, i11 != 0 ? b8.h.p(context, i11) : null);
        d0 d0Var = this.f2707b;
        if (d0Var != null) {
            d0Var.b();
        }
    }
}
