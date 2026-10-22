package androidx.appcompat.widget;

import android.R;
import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.text.InputFilter;
import android.util.AttributeSet;
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
import androidx.core.view.TintableBackgroundView;
import androidx.core.widget.AutoSizeableTextView;
import androidx.core.widget.TextViewCompat;
import androidx.core.widget.TintableCompoundDrawablesView;
import java.util.concurrent.Future;

/* JADX INFO: loaded from: classes.dex */
public class AppCompatTextView extends TextView implements TintableBackgroundView, TintableCompoundDrawablesView, AutoSizeableTextView, EmojiCompatConfigurationView {
    private final c mBackgroundTintHelper;

    @NonNull
    private h mEmojiTextViewHelper;
    private boolean mIsSetTypefaceProcessing;

    @Nullable
    private Future<androidx.core.text.c> mPrecomputedTextFuture;

    @Nullable
    private SuperCaller mSuperCaller;
    private final n mTextClassifierHelper;
    private final o mTextHelper;

    public interface SuperCaller {
        int getAutoSizeMaxTextSize();

        int getAutoSizeMinTextSize();

        int getAutoSizeStepGranularity();

        int[] getAutoSizeTextAvailableSizes();

        int getAutoSizeTextType();

        TextClassifier getTextClassifier();

        void setAutoSizeTextTypeUniformWithConfiguration(int r10, int r11, int r12, int r13);

        void setAutoSizeTextTypeUniformWithPresetSizes(int[] r10, int r11);

        void setAutoSizeTextTypeWithDefaults(int r10);

        void setFirstBaselineToTopHeight(@Px int r10);

        void setLastBaselineToBottomHeight(@Px int r10);

        void setTextClassifier(@Nullable TextClassifier r10);
    }

    public class a implements SuperCaller {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ AppCompatTextView f808a;

        public a(AppCompatTextView r10) {
            this.f808a = r10;
        }

        @Override // androidx.appcompat.widget.AppCompatTextView.SuperCaller
        public int getAutoSizeMaxTextSize() {
            return AppCompatTextView.access$001(this.f808a);
        }

        @Override // androidx.appcompat.widget.AppCompatTextView.SuperCaller
        public int getAutoSizeMinTextSize() {
            return AppCompatTextView.access$101(this.f808a);
        }

        @Override // androidx.appcompat.widget.AppCompatTextView.SuperCaller
        public int getAutoSizeStepGranularity() {
            return AppCompatTextView.access$201(this.f808a);
        }

        @Override // androidx.appcompat.widget.AppCompatTextView.SuperCaller
        public int[] getAutoSizeTextAvailableSizes() {
            return AppCompatTextView.access$301(this.f808a);
        }

        @Override // androidx.appcompat.widget.AppCompatTextView.SuperCaller
        public int getAutoSizeTextType() {
            return AppCompatTextView.access$401(this.f808a);
        }

        @Override // androidx.appcompat.widget.AppCompatTextView.SuperCaller
        public TextClassifier getTextClassifier() {
            return AppCompatTextView.access$501(this.f808a);
        }

        @Override // androidx.appcompat.widget.AppCompatTextView.SuperCaller
        public void setAutoSizeTextTypeUniformWithConfiguration(int r10, int r11, int r12, int r13) {
            AppCompatTextView.access$601(this.f808a, r10, r11, r12, r13);
        }

        @Override // androidx.appcompat.widget.AppCompatTextView.SuperCaller
        public void setAutoSizeTextTypeUniformWithPresetSizes(int[] r10, int r11) {
            AppCompatTextView.access$701(this.f808a, r10, r11);
        }

        @Override // androidx.appcompat.widget.AppCompatTextView.SuperCaller
        public void setAutoSizeTextTypeWithDefaults(int r10) {
            AppCompatTextView.access$801(this.f808a, r10);
        }

        @Override // androidx.appcompat.widget.AppCompatTextView.SuperCaller
        public void setTextClassifier(TextClassifier r10) {
            AppCompatTextView.access$901(this.f808a, r10);
        }
    }

    public class b extends a {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ AppCompatTextView f809b;

        public b(AppCompatTextView r10) {
            this.f809b = r10;
            super(r10);
        }

        @Override // androidx.appcompat.widget.AppCompatTextView.SuperCaller
        public void setFirstBaselineToTopHeight(int r10) {
            AppCompatTextView.access$1001(this.f809b, r10);
        }

        @Override // androidx.appcompat.widget.AppCompatTextView.SuperCaller
        public void setLastBaselineToBottomHeight(int r10) {
            AppCompatTextView.access$1101(this.f809b, r10);
        }
    }

    public AppCompatTextView(@NonNull Context r10) {
        this(r10, null);
    }

    public static /* synthetic */ int access$001(AppCompatTextView r10) {
        return super.getAutoSizeMaxTextSize();
    }

    public static /* synthetic */ void access$1001(AppCompatTextView r10, int r11) {
        super.setFirstBaselineToTopHeight(r11);
    }

    public static /* synthetic */ int access$101(AppCompatTextView r10) {
        return super.getAutoSizeMinTextSize();
    }

    public static /* synthetic */ void access$1101(AppCompatTextView r10, int r11) {
        super.setLastBaselineToBottomHeight(r11);
    }

    public static /* synthetic */ int access$201(AppCompatTextView r10) {
        return super.getAutoSizeStepGranularity();
    }

    public static /* synthetic */ int[] access$301(AppCompatTextView r10) {
        return super.getAutoSizeTextAvailableSizes();
    }

    public static /* synthetic */ int access$401(AppCompatTextView r10) {
        return super.getAutoSizeTextType();
    }

    public static /* synthetic */ TextClassifier access$501(AppCompatTextView r10) {
        return super.getTextClassifier();
    }

    public static /* synthetic */ void access$601(AppCompatTextView r10, int r11, int r12, int r13, int r14) {
        super.setAutoSizeTextTypeUniformWithConfiguration(r11, r12, r13, r14);
    }

    public static /* synthetic */ void access$701(AppCompatTextView r10, int[] r11, int r12) {
        super.setAutoSizeTextTypeUniformWithPresetSizes(r11, r12);
    }

    public static /* synthetic */ void access$801(AppCompatTextView r10, int r11) {
        super.setAutoSizeTextTypeWithDefaults(r11);
    }

    public static /* synthetic */ void access$901(AppCompatTextView r10, TextClassifier r11) {
        super.setTextClassifier(r11);
    }

    @NonNull
    private h getEmojiTextViewHelper() {
        if (this.mEmojiTextViewHelper != null) goto L6;
        this.mEmojiTextViewHelper = new h(this);
    L6:
        return this.mEmojiTextViewHelper;
    }

    public final void a() {
        Future<androidx.core.text.c> r10 = this.mPrecomputedTextFuture;
        if (r10 != null) goto L8;
        return;
    L8:
        this.mPrecomputedTextFuture = null;     // Catch: Throwable -> L7
        p.a(r10.get());     // Catch: Throwable -> L7
        TextViewCompat.m(this, null);     // Catch: Throwable -> L7
        return;
    }

    @Override // android.widget.TextView, android.view.View
    public void drawableStateChanged() {
        super.drawableStateChanged();
        c r10 = this.mBackgroundTintHelper;
        if (r10 == null) goto L5;
        r10.b();
    L5:
        o r11 = this.mTextHelper;
        if (r11 == null) goto L9;
        r11.b();
        return;
    }

    @Override // android.widget.TextView, androidx.core.widget.AutoSizeableTextView
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public int getAutoSizeMaxTextSize() {
        if (i0.f1034b == true) goto L5;
        o r10 = this.mTextHelper;
        if (r10 != null) goto L9;
        return -1;
    L9:
        return r10.e();
    L5:
        return getSuperCaller().getAutoSizeMaxTextSize();
    }

    @Override // android.widget.TextView, androidx.core.widget.AutoSizeableTextView
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public int getAutoSizeMinTextSize() {
        if (i0.f1034b == true) goto L5;
        o r10 = this.mTextHelper;
        if (r10 != null) goto L9;
        return -1;
    L9:
        return r10.f();
    L5:
        return getSuperCaller().getAutoSizeMinTextSize();
    }

    @Override // android.widget.TextView, androidx.core.widget.AutoSizeableTextView
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public int getAutoSizeStepGranularity() {
        if (i0.f1034b == true) goto L5;
        o r10 = this.mTextHelper;
        if (r10 != null) goto L9;
        return -1;
    L9:
        return r10.g();
    L5:
        return getSuperCaller().getAutoSizeStepGranularity();
    }

    @Override // android.widget.TextView, androidx.core.widget.AutoSizeableTextView
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public int[] getAutoSizeTextAvailableSizes() {
        if (i0.f1034b == true) goto L5;
        o r10 = this.mTextHelper;
        if (r10 == null) goto L11;
        return r10.h();
    L11:
        return new int[0];
    L5:
        return getSuperCaller().getAutoSizeTextAvailableSizes();
    }

    @Override // android.widget.TextView, androidx.core.widget.AutoSizeableTextView
    @SuppressLint({"WrongConstant"})
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public int getAutoSizeTextType() {
        if (i0.f1034b == true) goto L5;
        o r10 = this.mTextHelper;
        if (r10 != null) goto L11;
        return 0;
    L11:
        return r10.i();
    L5:
        if (getSuperCaller().getAutoSizeTextType() == 1) goto L7;
        return 0;
    L7:
        return 1;
    }

    @Override // android.widget.TextView
    @Nullable
    public ActionMode.Callback getCustomSelectionActionModeCallback() {
        return TextViewCompat.p(super.getCustomSelectionActionModeCallback());
    }

    @Override // android.widget.TextView
    public int getFirstBaselineToTopHeight() {
        return TextViewCompat.b(this);
    }

    @Override // android.widget.TextView
    public int getLastBaselineToBottomHeight() {
        return TextViewCompat.c(this);
    }

    @RequiresApi(api = 26)
    @UiThread
    public SuperCaller getSuperCaller() {
        if (this.mSuperCaller != null) goto L6;
        this.mSuperCaller = new b(this);
    L6:
        return this.mSuperCaller;
    }

    @Override // androidx.core.view.TintableBackgroundView
    @Nullable
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public ColorStateList getSupportBackgroundTintList() {
        c r10 = this.mBackgroundTintHelper;
        if (r10 != null) goto L7;
        return null;
    L7:
        return r10.c();
    }

    @Override // androidx.core.view.TintableBackgroundView
    @Nullable
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public PorterDuff.Mode getSupportBackgroundTintMode() {
        c r10 = this.mBackgroundTintHelper;
        if (r10 != null) goto L7;
        return null;
    L7:
        return r10.d();
    }

    @Override // androidx.core.widget.TintableCompoundDrawablesView
    @Nullable
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public ColorStateList getSupportCompoundDrawablesTintList() {
        return this.mTextHelper.j();
    }

    @Override // androidx.core.widget.TintableCompoundDrawablesView
    @Nullable
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public PorterDuff.Mode getSupportCompoundDrawablesTintMode() {
        return this.mTextHelper.k();
    }

    @Override // android.widget.TextView
    public CharSequence getText() {
        a();
        return super.getText();
    }

    @Override // android.widget.TextView
    @NonNull
    @RequiresApi(api = 26)
    public TextClassifier getTextClassifier() {
        return getSuperCaller().getTextClassifier();
    }

    @NonNull
    public androidx.core.text.c.a getTextMetricsParamsCompat() {
        return TextViewCompat.f(this);
    }

    @Override // androidx.appcompat.widget.EmojiCompatConfigurationView
    public boolean isEmojiCompatEnabled() {
        return getEmojiTextViewHelper().b();
    }

    @Override // android.widget.TextView, android.view.View
    public InputConnection onCreateInputConnection(EditorInfo r10) {
        InputConnection r11 = super.onCreateInputConnection(r10);
        this.mTextHelper.r(this, r11, r10);
        return i.a(r11, r10, this);
    }

    @Override // android.widget.TextView, android.view.View
    public void onLayout(boolean r10, int r11, int r12, int r13, int r14) {
        super.onLayout(r10, r11, r12, r13, r14);
        o r15 = this.mTextHelper;
        if (r15 == null) goto L6;
        r15.o(r10, r11, r12, r13, r14);
        return;
    }

    @Override // android.widget.TextView, android.view.View
    public void onMeasure(int r10, int r11) {
        a();
        super.onMeasure(r10, r11);
    }

    @Override // android.widget.TextView
    public void onTextChanged(CharSequence r10, int r11, int r12, int r13) {
        super.onTextChanged(r10, r11, r12, r13);
        o r14 = this.mTextHelper;
        if (r14 != null) goto L5;
        return;
    L5:
        if (i0.f1034b == false) goto L7;
        return;
    L7:
        if (r14.l() == false) goto L12;
        this.mTextHelper.c();
        return;
    }

    @Override // android.widget.TextView
    public void setAllCaps(boolean r10) {
        super.setAllCaps(r10);
        getEmojiTextViewHelper().d(r10);
    }

    @Override // android.widget.TextView, androidx.core.widget.AutoSizeableTextView
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public void setAutoSizeTextTypeUniformWithConfiguration(int r10, int r11, int r12, int r13) throws IllegalArgumentException {
        if (i0.f1034b == false) goto L5;
        getSuperCaller().setAutoSizeTextTypeUniformWithConfiguration(r10, r11, r12, r13);
        return;
    L5:
        o r14 = this.mTextHelper;
        if (r14 == null) goto L10;
        r14.t(r10, r11, r12, r13);
        return;
    }

    @Override // android.widget.TextView, androidx.core.widget.AutoSizeableTextView
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public void setAutoSizeTextTypeUniformWithPresetSizes(@NonNull int[] r10, int r11) throws IllegalArgumentException {
        if (i0.f1034b == false) goto L5;
        getSuperCaller().setAutoSizeTextTypeUniformWithPresetSizes(r10, r11);
        return;
    L5:
        o r12 = this.mTextHelper;
        if (r12 == null) goto L10;
        r12.u(r10, r11);
        return;
    }

    @Override // android.widget.TextView, androidx.core.widget.AutoSizeableTextView
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public void setAutoSizeTextTypeWithDefaults(int r10) {
        if (i0.f1034b == false) goto L5;
        getSuperCaller().setAutoSizeTextTypeWithDefaults(r10);
        return;
    L5:
        o r11 = this.mTextHelper;
        if (r11 == null) goto L10;
        r11.v(r10);
        return;
    }

    @Override // android.view.View
    public void setBackgroundDrawable(@Nullable Drawable r10) {
        super.setBackgroundDrawable(r10);
        c r11 = this.mBackgroundTintHelper;
        if (r11 == null) goto L6;
        r11.f(r10);
        return;
    }

    @Override // android.view.View
    public void setBackgroundResource(@DrawableRes int r10) {
        super.setBackgroundResource(r10);
        c r11 = this.mBackgroundTintHelper;
        if (r11 == null) goto L6;
        r11.g(r10);
        return;
    }

    @Override // android.widget.TextView
    public void setCompoundDrawables(@Nullable Drawable r10, @Nullable Drawable r11, @Nullable Drawable r12, @Nullable Drawable r13) {
        super.setCompoundDrawables(r10, r11, r12, r13);
        o r14 = this.mTextHelper;
        if (r14 == null) goto L6;
        r14.p();
        return;
    }

    @Override // android.widget.TextView
    @RequiresApi(17)
    public void setCompoundDrawablesRelative(@Nullable Drawable r10, @Nullable Drawable r11, @Nullable Drawable r12, @Nullable Drawable r13) {
        super.setCompoundDrawablesRelative(r10, r11, r12, r13);
        o r14 = this.mTextHelper;
        if (r14 == null) goto L6;
        r14.p();
        return;
    }

    @Override // android.widget.TextView
    @RequiresApi(17)
    public void setCompoundDrawablesRelativeWithIntrinsicBounds(@Nullable Drawable r10, @Nullable Drawable r11, @Nullable Drawable r12, @Nullable Drawable r13) {
        super.setCompoundDrawablesRelativeWithIntrinsicBounds(r10, r11, r12, r13);
        o r14 = this.mTextHelper;
        if (r14 == null) goto L6;
        r14.p();
        return;
    }

    @Override // android.widget.TextView
    public void setCompoundDrawablesWithIntrinsicBounds(@Nullable Drawable r10, @Nullable Drawable r11, @Nullable Drawable r12, @Nullable Drawable r13) {
        super.setCompoundDrawablesWithIntrinsicBounds(r10, r11, r12, r13);
        o r14 = this.mTextHelper;
        if (r14 == null) goto L6;
        r14.p();
        return;
    }

    @Override // android.widget.TextView
    public void setCustomSelectionActionModeCallback(@Nullable ActionMode.Callback r10) {
        super.setCustomSelectionActionModeCallback(TextViewCompat.q(this, r10));
    }

    @Override // androidx.appcompat.widget.EmojiCompatConfigurationView
    public void setEmojiCompatEnabled(boolean r10) {
        getEmojiTextViewHelper().e(r10);
    }

    @Override // android.widget.TextView
    public void setFilters(@NonNull InputFilter[] r10) {
        super.setFilters(getEmojiTextViewHelper().a(r10));
    }

    @Override // android.widget.TextView
    public void setFirstBaselineToTopHeight(@IntRange(from = 0) @Px int r10) {
        getSuperCaller().setFirstBaselineToTopHeight(r10);
    }

    @Override // android.widget.TextView
    public void setLastBaselineToBottomHeight(@IntRange(from = 0) @Px int r10) {
        getSuperCaller().setLastBaselineToBottomHeight(r10);
    }

    @Override // android.widget.TextView
    public void setLineHeight(@IntRange(from = 0) @Px int r10) {
        TextViewCompat.l(this, r10);
    }

    public void setPrecomputedText(@NonNull androidx.core.text.c r10) {
        TextViewCompat.m(this, r10);
    }

    @Override // androidx.core.view.TintableBackgroundView
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public void setSupportBackgroundTintList(@Nullable ColorStateList r10) {
        c r11 = this.mBackgroundTintHelper;
        if (r11 == null) goto L6;
        r11.i(r10);
        return;
    }

    @Override // androidx.core.view.TintableBackgroundView
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public void setSupportBackgroundTintMode(@Nullable PorterDuff.Mode r10) {
        c r11 = this.mBackgroundTintHelper;
        if (r11 == null) goto L6;
        r11.j(r10);
        return;
    }

    @Override // androidx.core.widget.TintableCompoundDrawablesView
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public void setSupportCompoundDrawablesTintList(@Nullable ColorStateList r10) {
        this.mTextHelper.w(r10);
        this.mTextHelper.b();
    }

    @Override // androidx.core.widget.TintableCompoundDrawablesView
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public void setSupportCompoundDrawablesTintMode(@Nullable PorterDuff.Mode r10) {
        this.mTextHelper.x(r10);
        this.mTextHelper.b();
    }

    @Override // android.widget.TextView
    public void setTextAppearance(Context r10, int r11) {
        super.setTextAppearance(r10, r11);
        o r12 = this.mTextHelper;
        if (r12 == null) goto L6;
        r12.q(r10, r11);
        return;
    }

    @Override // android.widget.TextView
    @RequiresApi(api = 26)
    public void setTextClassifier(@Nullable TextClassifier r10) {
        getSuperCaller().setTextClassifier(r10);
    }

    public void setTextFuture(@Nullable Future<androidx.core.text.c> r10) {
        this.mPrecomputedTextFuture = r10;
        if (r10 == null) goto L6;
        requestLayout();
        return;
    }

    public void setTextMetricsParamsCompat(@NonNull androidx.core.text.c.a r10) {
        TextViewCompat.o(this, r10);
    }

    @Override // android.widget.TextView
    public void setTextSize(int r10, float r11) {
        if (i0.f1034b == false) goto L5;
        super.setTextSize(r10, r11);
        return;
    L5:
        o r12 = this.mTextHelper;
        if (r12 == null) goto L10;
        r12.A(r10, r11);
        return;
    }

    @Override // android.widget.TextView
    public void setTypeface(@Nullable Typeface r10, int r11) {
        if (this.mIsSetTypefaceProcessing == false) goto L5;
        return;
    L5:
        if (r10 == null) goto L8;
        if (r11 <= 0) goto L8;
        Typeface r12 = androidx.core.graphics.h.a(getContext(), r10, r11);
    L9:
        this.mIsSetTypefaceProcessing = true;
        if (r12 == null) goto L19;
        r10 = r12;
    L19:
        super.setTypeface(r10, r11);     // Catch: Throwable -> L16
        this.mIsSetTypefaceProcessing = false;
        return;
    L16:
        th = move-exception;
        this.mIsSetTypefaceProcessing = false;
        throw th;
    L8:
        r12 = null;
        goto L9
    }

    public AppCompatTextView(@NonNull Context r10, @Nullable AttributeSet r11) {
        this(r10, r11, R.attr.textViewStyle);
    }

    public AppCompatTextView(@NonNull Context r10, @Nullable AttributeSet r11, int r12) {
        super(y.b(r10), r11, r12);
        this.mIsSetTypefaceProcessing = false;
        this.mSuperCaller = null;
        x.a(this, getContext());
        c r13 = new c(this);
        this.mBackgroundTintHelper = r13;
        r13.e(r11, r12);
        o r14 = new o(this);
        this.mTextHelper = r14;
        r14.m(r11, r12);
        r14.b();
        this.mTextClassifierHelper = new n(this);
        getEmojiTextViewHelper().c(r11, r12);
    }

    @Override // android.widget.TextView
    @RequiresApi(17)
    public void setCompoundDrawablesRelativeWithIntrinsicBounds(int r10, int r11, int r12, int r13) {
        Context r14 = getContext();
        Drawable r15 = null;
        if (r10 == 0) goto L5;
        Drawable r16 = c.a.b(r14, r10);
    L6:
        if (r11 == 0) goto L8;
        Drawable r17 = c.a.b(r14, r11);
    L9:
        if (r12 == 0) goto L11;
        Drawable r18 = c.a.b(r14, r12);
    L12:
        if (r13 == 0) goto L14;
        r15 = c.a.b(r14, r13);
    L14:
        setCompoundDrawablesRelativeWithIntrinsicBounds(r16, r17, r18, r15);
        o r19 = this.mTextHelper;
        if (r19 == null) goto L18;
        r19.p();
        return;
    L18:
        return;
    L11:
        r18 = null;
        goto L12
    L8:
        r17 = null;
        goto L9
    L5:
        r16 = null;
        goto L6
    }

    @Override // android.widget.TextView
    public void setCompoundDrawablesWithIntrinsicBounds(int r10, int r11, int r12, int r13) {
        Context r14 = getContext();
        Drawable r15 = null;
        if (r10 == 0) goto L5;
        Drawable r16 = c.a.b(r14, r10);
    L6:
        if (r11 == 0) goto L8;
        Drawable r17 = c.a.b(r14, r11);
    L9:
        if (r12 == 0) goto L11;
        Drawable r18 = c.a.b(r14, r12);
    L12:
        if (r13 == 0) goto L14;
        r15 = c.a.b(r14, r13);
    L14:
        setCompoundDrawablesWithIntrinsicBounds(r16, r17, r18, r15);
        o r19 = this.mTextHelper;
        if (r19 == null) goto L18;
        r19.p();
        return;
    L18:
        return;
    L11:
        r18 = null;
        goto L12
    L8:
        r17 = null;
        goto L9
    L5:
        r16 = null;
        goto L6
    }
}
