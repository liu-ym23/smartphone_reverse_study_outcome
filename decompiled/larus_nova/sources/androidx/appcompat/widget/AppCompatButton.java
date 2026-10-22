package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.ActionMode;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;
import android.widget.Button;
import androidx.core.view.TintableBackgroundView;
import androidx.core.widget.AutoSizeableTextView;
import androidx.core.widget.TextViewCompat;
import androidx.core.widget.TintableCompoundDrawablesView;
import com.larus.nova.R;

/* JADX INFO: loaded from: classes2.dex */
public class AppCompatButton extends Button implements TintableBackgroundView, AutoSizeableTextView, TintableCompoundDrawablesView {
    private final AppCompatBackgroundHelper mBackgroundTintHelper;
    private final AppCompatTextHelper mTextHelper;

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

    public AppCompatButton(Context r100) {
        this(r100, null);
    }

    @Override // android.view.View
    public void onInitializeAccessibilityEvent(AccessibilityEvent r100) {
        super.onInitializeAccessibilityEvent(r100);
        r100.setClassName(Button.class.getName());
    }

    @Override // android.view.View
    public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo r100) {
        super.onInitializeAccessibilityNodeInfo(r100);
        r100.setClassName(Button.class.getName());
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

    public void setSupportAllCaps(boolean r100) {
        AppCompatTextHelper r101 = this.mTextHelper;
        if (r101 == null) goto L6;
        r101.setAllCaps(r100);
        return;
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

    public AppCompatButton(Context r100, AttributeSet r101) {
        this(r100, r101, R.attr.buttonStyle);
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

    public AppCompatButton(Context r100, AttributeSet r101, int r102) {
        super(TintContextWrapper.wrap(r100), r101, r102);
        ThemeUtils.checkAppCompatTheme(this, getContext());
        AppCompatBackgroundHelper r103 = new AppCompatBackgroundHelper(this);
        this.mBackgroundTintHelper = r103;
        r103.loadFromAttributes(r101, r102);
        AppCompatTextHelper r104 = new AppCompatTextHelper(this);
        this.mTextHelper = r104;
        this.mTextHelper.loadFromAttributes(r101, r102);
        r104.applyCompoundDrawablesTints();
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

    @Override // android.widget.TextView, android.view.View
    public void onLayout(boolean r100, int r101, int r102, int r110, int r111) {
        super.onLayout(r100, r101, r102, r110, r111);
        AppCompatTextHelper r103 = this.mTextHelper;
        if (r103 == null) goto L6;
        r103.onLayout(r100, r101, r102, r110, r111);
        return;
    }
}
