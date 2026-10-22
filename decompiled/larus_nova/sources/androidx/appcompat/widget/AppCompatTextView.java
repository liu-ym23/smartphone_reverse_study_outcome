package androidx.appcompat.widget;

import android.R;
import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.util.AttributeSet;
import android.view.ActionMode;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputConnection;
import android.view.textclassifier.TextClassifier;
import android.widget.TextView;
import androidx.appcompat.content.res.AppCompatResources;
import androidx.core.graphics.TypefaceCompat;
import androidx.core.text.PrecomputedTextCompat;
import androidx.core.view.TintableBackgroundView;
import androidx.core.widget.AutoSizeableTextView;
import androidx.core.widget.TextViewCompat;
import androidx.core.widget.TintableCompoundDrawablesView;
import java.util.concurrent.Future;

/* JADX INFO: loaded from: classes3.dex */
public class AppCompatTextView extends TextView implements TintableBackgroundView, TintableCompoundDrawablesView, AutoSizeableTextView {
    private final AppCompatBackgroundHelper mBackgroundTintHelper;
    private boolean mIsSetTypefaceProcessing;
    private Future<PrecomputedTextCompat> mPrecomputedTextFuture;
    private final AppCompatTextClassifierHelper mTextClassifierHelper;
    private final AppCompatTextHelper mTextHelper;

    private void consumeTextFutureAndSetBlocking() {
        Future<PrecomputedTextCompat> r100 = this.mPrecomputedTextFuture;
        if (r100 != null) goto L8;
        return;
    L8:
        this.mPrecomputedTextFuture = null;     // Catch: Throwable -> L7
        TextViewCompat.setPrecomputedText(this, r100.get());     // Catch: Throwable -> L7
        return;
    }

    @Override // android.widget.TextView, androidx.core.widget.AutoSizeableTextView
    public int getAutoSizeMaxTextSize() {
        if (AutoSizeableTextView.PLATFORM_SUPPORTS_AUTOSIZE == true) goto L5;
        AppCompatTextHelper r100 = this.mTextHelper;
        if (r100 != null) goto L9;
        return -1;
    L9:
        return r100.getAutoSizeMaxTextSize();
    L5:
        return super.getAutoSizeMaxTextSize();
    }

    @Override // android.widget.TextView, androidx.core.widget.AutoSizeableTextView
    public int getAutoSizeMinTextSize() {
        if (AutoSizeableTextView.PLATFORM_SUPPORTS_AUTOSIZE == true) goto L5;
        AppCompatTextHelper r100 = this.mTextHelper;
        if (r100 != null) goto L9;
        return -1;
    L9:
        return r100.getAutoSizeMinTextSize();
    L5:
        return super.getAutoSizeMinTextSize();
    }

    @Override // android.widget.TextView, androidx.core.widget.AutoSizeableTextView
    public int getAutoSizeStepGranularity() {
        if (AutoSizeableTextView.PLATFORM_SUPPORTS_AUTOSIZE == true) goto L5;
        AppCompatTextHelper r100 = this.mTextHelper;
        if (r100 != null) goto L9;
        return -1;
    L9:
        return r100.getAutoSizeStepGranularity();
    L5:
        return super.getAutoSizeStepGranularity();
    }

    @Override // android.widget.TextView, androidx.core.widget.AutoSizeableTextView
    public int[] getAutoSizeTextAvailableSizes() {
        if (AutoSizeableTextView.PLATFORM_SUPPORTS_AUTOSIZE == true) goto L5;
        AppCompatTextHelper r100 = this.mTextHelper;
        if (r100 == null) goto L11;
        return r100.getAutoSizeTextAvailableSizes();
    L11:
        return new int[0];
    L5:
        return super.getAutoSizeTextAvailableSizes();
    }

    @Override // android.widget.TextView, androidx.core.widget.AutoSizeableTextView
    public int getAutoSizeTextType() {
        if (AutoSizeableTextView.PLATFORM_SUPPORTS_AUTOSIZE == true) goto L5;
        AppCompatTextHelper r100 = this.mTextHelper;
        if (r100 != null) goto L11;
        return 0;
    L11:
        return r100.getAutoSizeTextType();
    L5:
        if (super.getAutoSizeTextType() != 1) goto L13;
        return 1;
    L13:
        return 0;
    }

    @Override // androidx.core.view.TintableBackgroundView
    public ColorStateList getSupportBackgroundTintList() {
        AppCompatBackgroundHelper r100 = this.mBackgroundTintHelper;
        if (r100 != null) goto L7;
        return null;
    L7:
        return r100.getSupportBackgroundTintList();
    }

    @Override // androidx.core.view.TintableBackgroundView
    public PorterDuff.Mode getSupportBackgroundTintMode() {
        AppCompatBackgroundHelper r100 = this.mBackgroundTintHelper;
        if (r100 != null) goto L7;
        return null;
    L7:
        return r100.getSupportBackgroundTintMode();
    }

    @Override // androidx.core.widget.TintableCompoundDrawablesView
    public ColorStateList getSupportCompoundDrawablesTintList() {
        return this.mTextHelper.getCompoundDrawableTintList();
    }

    @Override // androidx.core.widget.TintableCompoundDrawablesView
    public PorterDuff.Mode getSupportCompoundDrawablesTintMode() {
        return this.mTextHelper.getCompoundDrawableTintMode();
    }

    @Override // android.widget.TextView
    public TextClassifier getTextClassifier() {
        if (Build.VERSION.SDK_INT >= 28) goto L10;
        AppCompatTextClassifierHelper r100 = this.mTextClassifierHelper;
        if (r100 == null) goto L10;
        return r100.getTextClassifier();
    L10:
        return super.getTextClassifier();
    }

    @Override // android.widget.TextView, android.view.View
    public void drawableStateChanged() {
        super.drawableStateChanged();
        AppCompatBackgroundHelper r100 = this.mBackgroundTintHelper;
        if (r100 == null) goto L5;
        r100.applySupportBackgroundTint();
    L5:
        AppCompatTextHelper r101 = this.mTextHelper;
        if (r101 == null) goto L9;
        r101.applyCompoundDrawablesTints();
        return;
    }

    @Override // android.widget.TextView
    public int getFirstBaselineToTopHeight() {
        return TextViewCompat.getFirstBaselineToTopHeight(this);
    }

    @Override // android.widget.TextView
    public int getLastBaselineToBottomHeight() {
        return TextViewCompat.getLastBaselineToBottomHeight(this);
    }

    @Override // android.widget.TextView
    public CharSequence getText() {
        consumeTextFutureAndSetBlocking();
        return super.getText();
    }

    public PrecomputedTextCompat.Params getTextMetricsParamsCompat() {
        return TextViewCompat.getTextMetricsParams(this);
    }

    public AppCompatTextView(Context r100) {
        this(r100, null);
    }

    @Override // android.widget.TextView, android.view.View
    public InputConnection onCreateInputConnection(EditorInfo r100) {
        InputConnection r101 = super.onCreateInputConnection(r100);
        this.mTextHelper.populateSurroundingTextIfNeeded(this, r101, r100);
        return AppCompatHintHelper.onCreateInputConnection(r101, r100, this);
    }

    @Override // android.widget.TextView, androidx.core.widget.AutoSizeableTextView
    public void setAutoSizeTextTypeWithDefaults(int r100) {
        if (AutoSizeableTextView.PLATFORM_SUPPORTS_AUTOSIZE == false) goto L5;
        super.setAutoSizeTextTypeWithDefaults(r100);
        return;
    L5:
        AppCompatTextHelper r101 = this.mTextHelper;
        if (r101 == null) goto L10;
        r101.setAutoSizeTextTypeWithDefaults(r100);
        return;
    }

    @Override // android.view.View
    public void setBackgroundDrawable(Drawable r100) {
        super.setBackgroundDrawable(r100);
        AppCompatBackgroundHelper r101 = this.mBackgroundTintHelper;
        if (r101 == null) goto L6;
        r101.onSetBackgroundDrawable(r100);
        return;
    }

    @Override // android.view.View
    public void setBackgroundResource(int r100) {
        super.setBackgroundResource(r100);
        AppCompatBackgroundHelper r101 = this.mBackgroundTintHelper;
        if (r101 == null) goto L6;
        r101.onSetBackgroundResource(r100);
        return;
    }

    @Override // android.widget.TextView
    public void setCustomSelectionActionModeCallback(ActionMode.Callback r100) {
        super.setCustomSelectionActionModeCallback(TextViewCompat.wrapCustomSelectionActionModeCallback(this, r100));
    }

    @Override // android.widget.TextView
    public void setFirstBaselineToTopHeight(int r100) {
        if (Build.VERSION.SDK_INT < 28) goto L5;
        super.setFirstBaselineToTopHeight(r100);
        return;
    L5:
        TextViewCompat.setFirstBaselineToTopHeight(this, r100);
    }

    @Override // android.widget.TextView
    public void setLastBaselineToBottomHeight(int r100) {
        if (Build.VERSION.SDK_INT < 28) goto L5;
        super.setLastBaselineToBottomHeight(r100);
        return;
    L5:
        TextViewCompat.setLastBaselineToBottomHeight(this, r100);
    }

    @Override // android.widget.TextView
    public void setLineHeight(int r100) {
        TextViewCompat.setLineHeight(this, r100);
    }

    public void setPrecomputedText(PrecomputedTextCompat r100) {
        TextViewCompat.setPrecomputedText(this, r100);
    }

    @Override // androidx.core.view.TintableBackgroundView
    public void setSupportBackgroundTintList(ColorStateList r100) {
        AppCompatBackgroundHelper r101 = this.mBackgroundTintHelper;
        if (r101 == null) goto L6;
        r101.setSupportBackgroundTintList(r100);
        return;
    }

    @Override // androidx.core.view.TintableBackgroundView
    public void setSupportBackgroundTintMode(PorterDuff.Mode r100) {
        AppCompatBackgroundHelper r101 = this.mBackgroundTintHelper;
        if (r101 == null) goto L6;
        r101.setSupportBackgroundTintMode(r100);
        return;
    }

    @Override // androidx.core.widget.TintableCompoundDrawablesView
    public void setSupportCompoundDrawablesTintList(ColorStateList r100) {
        this.mTextHelper.setCompoundDrawableTintList(r100);
        this.mTextHelper.applyCompoundDrawablesTints();
    }

    @Override // androidx.core.widget.TintableCompoundDrawablesView
    public void setSupportCompoundDrawablesTintMode(PorterDuff.Mode r100) {
        this.mTextHelper.setCompoundDrawableTintMode(r100);
        this.mTextHelper.applyCompoundDrawablesTints();
    }

    @Override // android.widget.TextView
    public void setTextClassifier(TextClassifier r100) {
        if (Build.VERSION.SDK_INT >= 28) goto L9;
        AppCompatTextClassifierHelper r101 = this.mTextClassifierHelper;
        if (r101 == null) goto L9;
        r101.setTextClassifier(r100);
        return;
    L9:
        super.setTextClassifier(r100);
    }

    public void setTextFuture(Future<PrecomputedTextCompat> r100) {
        this.mPrecomputedTextFuture = r100;
        if (r100 == null) goto L6;
        requestLayout();
        return;
    }

    public void setTextMetricsParamsCompat(PrecomputedTextCompat.Params r100) {
        TextViewCompat.setTextMetricsParams(this, r100);
    }

    public AppCompatTextView(Context r100, AttributeSet r101) {
        this(r100, r101, R.attr.textViewStyle);
    }

    @Override // android.widget.TextView, android.view.View
    public void onMeasure(int r100, int r101) {
        consumeTextFutureAndSetBlocking();
        super.onMeasure(r100, r101);
    }

    @Override // android.widget.TextView, androidx.core.widget.AutoSizeableTextView
    public void setAutoSizeTextTypeUniformWithPresetSizes(int[] r100, int r101) throws IllegalArgumentException {
        if (AutoSizeableTextView.PLATFORM_SUPPORTS_AUTOSIZE == false) goto L5;
        super.setAutoSizeTextTypeUniformWithPresetSizes(r100, r101);
        return;
    L5:
        AppCompatTextHelper r102 = this.mTextHelper;
        if (r102 == null) goto L10;
        r102.setAutoSizeTextTypeUniformWithPresetSizes(r100, r101);
        return;
    }

    @Override // android.widget.TextView
    public void setTextAppearance(Context r100, int r101) {
        super.setTextAppearance(r100, r101);
        AppCompatTextHelper r102 = this.mTextHelper;
        if (r102 == null) goto L6;
        r102.onSetTextAppearance(r100, r101);
        return;
    }

    @Override // android.widget.TextView
    public void setTextSize(int r100, float r101) {
        if (AutoSizeableTextView.PLATFORM_SUPPORTS_AUTOSIZE == false) goto L5;
        super.setTextSize(r100, r101);
        return;
    L5:
        AppCompatTextHelper r102 = this.mTextHelper;
        if (r102 == null) goto L10;
        r102.setTextSize(r100, r101);
        return;
    }

    @Override // android.widget.TextView
    public void setTypeface(Typeface r100, int r101) {
        if (this.mIsSetTypefaceProcessing == false) goto L5;
        return;
    L5:
        if (r100 == null) goto L8;
        if (r101 <= 0) goto L8;
        Typeface r102 = TypefaceCompat.create(getContext(), r100, r101);
    L9:
        this.mIsSetTypefaceProcessing = true;
        if (r102 == null) goto L19;
        r100 = r102;
    L19:
        super.setTypeface(r100, r101);     // Catch: Throwable -> L16
        this.mIsSetTypefaceProcessing = false;
        return;
    L16:
        th = move-exception;
        this.mIsSetTypefaceProcessing = false;
        throw th;
    L8:
        r102 = null;
        goto L9
    }

    public AppCompatTextView(Context r100, AttributeSet r101, int r102) {
        super(TintContextWrapper.wrap(r100), r101, r102);
        this.mIsSetTypefaceProcessing = false;
        ThemeUtils.checkAppCompatTheme(this, getContext());
        AppCompatBackgroundHelper r103 = new AppCompatBackgroundHelper(this);
        this.mBackgroundTintHelper = r103;
        r103.loadFromAttributes(r101, r102);
        AppCompatTextHelper r104 = new AppCompatTextHelper(this);
        this.mTextHelper = r104;
        this.mTextHelper.loadFromAttributes(r101, r102);
        r104.applyCompoundDrawablesTints();
        this.mTextClassifierHelper = new AppCompatTextClassifierHelper(this);
    }

    @Override // android.widget.TextView
    public void onTextChanged(CharSequence r100, int r101, int r102, int r103) {
        super.onTextChanged(r100, r101, r102, r103);
        AppCompatTextHelper r104 = this.mTextHelper;
        if (r104 != null) goto L5;
        return;
    L5:
        if (AutoSizeableTextView.PLATFORM_SUPPORTS_AUTOSIZE == false) goto L7;
        return;
    L7:
        if (r104.isAutoSizeEnabled() == false) goto L12;
        this.mTextHelper.autoSizeText();
        return;
    }

    @Override // android.widget.TextView, androidx.core.widget.AutoSizeableTextView
    public void setAutoSizeTextTypeUniformWithConfiguration(int r100, int r101, int r102, int r103) throws IllegalArgumentException {
        if (AutoSizeableTextView.PLATFORM_SUPPORTS_AUTOSIZE == false) goto L5;
        super.setAutoSizeTextTypeUniformWithConfiguration(r100, r101, r102, r103);
        return;
    L5:
        AppCompatTextHelper r104 = this.mTextHelper;
        if (r104 == null) goto L10;
        r104.setAutoSizeTextTypeUniformWithConfiguration(r100, r101, r102, r103);
        return;
    }

    @Override // android.widget.TextView
    public void setCompoundDrawables(Drawable r100, Drawable r101, Drawable r102, Drawable r103) {
        super.setCompoundDrawables(r100, r101, r102, r103);
        AppCompatTextHelper r104 = this.mTextHelper;
        if (r104 == null) goto L6;
        r104.onSetCompoundDrawables();
        return;
    }

    @Override // android.widget.TextView
    public void setCompoundDrawablesRelative(Drawable r100, Drawable r101, Drawable r102, Drawable r103) {
        super.setCompoundDrawablesRelative(r100, r101, r102, r103);
        AppCompatTextHelper r104 = this.mTextHelper;
        if (r104 == null) goto L6;
        r104.onSetCompoundDrawables();
        return;
    }

    @Override // android.widget.TextView
    public void setCompoundDrawablesRelativeWithIntrinsicBounds(int r100, int r101, int r102, int r103) {
        Context r104 = getContext();
        Drawable r105 = null;
        if (r100 == 0) goto L5;
        Drawable r106 = AppCompatResources.getDrawable(r104, r100);
    L6:
        if (r101 == 0) goto L8;
        Drawable r107 = AppCompatResources.getDrawable(r104, r101);
    L9:
        if (r102 == 0) goto L11;
        Drawable r108 = AppCompatResources.getDrawable(r104, r102);
    L12:
        if (r103 == 0) goto L14;
        r105 = AppCompatResources.getDrawable(r104, r103);
    L14:
        setCompoundDrawablesRelativeWithIntrinsicBounds(r106, r107, r108, r105);
        AppCompatTextHelper r109 = this.mTextHelper;
        if (r109 == null) goto L18;
        r109.onSetCompoundDrawables();
        return;
    L18:
        return;
    L11:
        r108 = null;
        goto L12
    L8:
        r107 = null;
        goto L9
    L5:
        r106 = null;
        goto L6
    }

    @Override // android.widget.TextView
    public void setCompoundDrawablesWithIntrinsicBounds(int r100, int r101, int r102, int r103) {
        Context r104 = getContext();
        Drawable r105 = null;
        if (r100 == 0) goto L5;
        Drawable r106 = AppCompatResources.getDrawable(r104, r100);
    L6:
        if (r101 == 0) goto L8;
        Drawable r107 = AppCompatResources.getDrawable(r104, r101);
    L9:
        if (r102 == 0) goto L11;
        Drawable r108 = AppCompatResources.getDrawable(r104, r102);
    L12:
        if (r103 == 0) goto L14;
        r105 = AppCompatResources.getDrawable(r104, r103);
    L14:
        setCompoundDrawablesWithIntrinsicBounds(r106, r107, r108, r105);
        AppCompatTextHelper r109 = this.mTextHelper;
        if (r109 == null) goto L18;
        r109.onSetCompoundDrawables();
        return;
    L18:
        return;
    L11:
        r108 = null;
        goto L12
    L8:
        r107 = null;
        goto L9
    L5:
        r106 = null;
        goto L6
    }

    @Override // android.widget.TextView
    public void setCompoundDrawablesRelativeWithIntrinsicBounds(Drawable r100, Drawable r101, Drawable r102, Drawable r103) {
        super.setCompoundDrawablesRelativeWithIntrinsicBounds(r100, r101, r102, r103);
        AppCompatTextHelper r104 = this.mTextHelper;
        if (r104 == null) goto L6;
        r104.onSetCompoundDrawables();
        return;
    }

    @Override // android.widget.TextView
    public void setCompoundDrawablesWithIntrinsicBounds(Drawable r100, Drawable r101, Drawable r102, Drawable r103) {
        super.setCompoundDrawablesWithIntrinsicBounds(r100, r101, r102, r103);
        AppCompatTextHelper r104 = this.mTextHelper;
        if (r104 == null) goto L6;
        r104.onSetCompoundDrawables();
        return;
    }

    @Override // android.widget.TextView, android.view.View
    public void onLayout(boolean r100, int r101, int r102, int r110, int r111) {
        super.onLayout(r100, r101, r102, r110, r111);
        AppCompatTextHelper r103 = this.mTextHelper;
        if (r103 == null) goto L6;
        r103.onLayout(r100, r101, r102, r110, r111);
        return;
    }
}
