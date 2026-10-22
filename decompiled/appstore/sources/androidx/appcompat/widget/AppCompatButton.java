package androidx.appcompat.widget;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.text.InputFilter;
import android.util.AttributeSet;
import android.view.ActionMode;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;
import android.widget.Button;
import androidx.annotation.DrawableRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import androidx.appcompat.R$attr;
import androidx.core.view.TintableBackgroundView;
import androidx.core.widget.AutoSizeableTextView;
import androidx.core.widget.TextViewCompat;
import androidx.core.widget.TintableCompoundDrawablesView;

/* JADX INFO: loaded from: classes.dex */
public class AppCompatButton extends Button implements TintableBackgroundView, AutoSizeableTextView, TintableCompoundDrawablesView, EmojiCompatConfigurationView {

    @NonNull
    private h mAppCompatEmojiTextHelper;
    private final c mBackgroundTintHelper;
    private final o mTextHelper;

    public AppCompatButton(@NonNull Context r10) {
        this(r10, null);
    }

    @NonNull
    private h getEmojiTextViewHelper() {
        if (this.mAppCompatEmojiTextHelper != null) goto L6;
        this.mAppCompatEmojiTextHelper = new h(this);
    L6:
        return this.mAppCompatEmojiTextHelper;
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
        return super.getAutoSizeMaxTextSize();
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
        return super.getAutoSizeMinTextSize();
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
        return super.getAutoSizeStepGranularity();
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
        return super.getAutoSizeTextAvailableSizes();
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
        if (super.getAutoSizeTextType() == 1) goto L7;
        return 0;
    L7:
        return 1;
    }

    @Override // android.widget.TextView
    @Nullable
    public ActionMode.Callback getCustomSelectionActionModeCallback() {
        return TextViewCompat.p(super.getCustomSelectionActionModeCallback());
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

    @Override // androidx.appcompat.widget.EmojiCompatConfigurationView
    public boolean isEmojiCompatEnabled() {
        return getEmojiTextViewHelper().b();
    }

    @Override // android.view.View
    public void onInitializeAccessibilityEvent(AccessibilityEvent r10) {
        super.onInitializeAccessibilityEvent(r10);
        r10.setClassName(Button.class.getName());
    }

    @Override // android.view.View
    public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo r10) {
        super.onInitializeAccessibilityNodeInfo(r10);
        r10.setClassName(Button.class.getName());
    }

    @Override // android.widget.TextView, android.view.View
    public void onLayout(boolean r10, int r11, int r12, int r13, int r14) {
        super.onLayout(r10, r11, r12, r13, r14);
        o r15 = this.mTextHelper;
        if (r15 == null) goto L6;
        r15.o(r10, r11, r12, r13, r14);
        return;
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
        super.setAutoSizeTextTypeUniformWithConfiguration(r10, r11, r12, r13);
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
        super.setAutoSizeTextTypeUniformWithPresetSizes(r10, r11);
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
        super.setAutoSizeTextTypeWithDefaults(r10);
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

    public void setSupportAllCaps(boolean r10) {
        o r11 = this.mTextHelper;
        if (r11 == null) goto L6;
        r11.s(r10);
        return;
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

    public AppCompatButton(@NonNull Context r10, @Nullable AttributeSet r11) {
        this(r10, r11, R$attr.buttonStyle);
    }

    public AppCompatButton(@NonNull Context r10, @Nullable AttributeSet r11, int r12) {
        super(y.b(r10), r11, r12);
        x.a(this, getContext());
        c r13 = new c(this);
        this.mBackgroundTintHelper = r13;
        r13.e(r11, r12);
        o r14 = new o(this);
        this.mTextHelper = r14;
        r14.m(r11, r12);
        r14.b();
        getEmojiTextViewHelper().c(r11, r12);
    }
}
