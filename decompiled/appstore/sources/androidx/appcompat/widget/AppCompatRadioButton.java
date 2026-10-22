package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.text.InputFilter;
import android.util.AttributeSet;
import android.widget.RadioButton;
import androidx.annotation.DrawableRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.annotation.RestrictTo;
import androidx.appcompat.R$attr;
import androidx.core.view.TintableBackgroundView;
import androidx.core.widget.TintableCompoundButton;
import androidx.core.widget.TintableCompoundDrawablesView;

/* JADX INFO: loaded from: classes.dex */
public class AppCompatRadioButton extends RadioButton implements TintableCompoundButton, TintableBackgroundView, EmojiCompatConfigurationView, TintableCompoundDrawablesView {
    private h mAppCompatEmojiTextHelper;
    private final c mBackgroundTintHelper;
    private final e mCompoundButtonHelper;
    private final o mTextHelper;

    public AppCompatRadioButton(Context r10) {
        this(r10, null);
    }

    @NonNull
    private h getEmojiTextViewHelper() {
        if (this.mAppCompatEmojiTextHelper != null) goto L6;
        this.mAppCompatEmojiTextHelper = new h(this);
    L6:
        return this.mAppCompatEmojiTextHelper;
    }

    @Override // android.widget.CompoundButton, android.widget.TextView, android.view.View
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

    @Override // android.widget.CompoundButton, android.widget.TextView
    public int getCompoundPaddingLeft() {
        int r10 = super.getCompoundPaddingLeft();
        e r11 = this.mCompoundButtonHelper;
        if (r11 != null) goto L5;
        return r10;
    L5:
        return r11.b(r10);
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

    @Override // androidx.core.widget.TintableCompoundButton
    @Nullable
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public ColorStateList getSupportButtonTintList() {
        e r10 = this.mCompoundButtonHelper;
        if (r10 != null) goto L7;
        return null;
    L7:
        return r10.c();
    }

    @Override // androidx.core.widget.TintableCompoundButton
    @Nullable
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public PorterDuff.Mode getSupportButtonTintMode() {
        e r10 = this.mCompoundButtonHelper;
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

    @Override // android.widget.TextView
    public void setAllCaps(boolean r10) {
        super.setAllCaps(r10);
        getEmojiTextViewHelper().d(r10);
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

    @Override // android.widget.CompoundButton
    public void setButtonDrawable(Drawable r10) {
        super.setButtonDrawable(r10);
        e r11 = this.mCompoundButtonHelper;
        if (r11 == null) goto L6;
        r11.f();
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

    @Override // androidx.appcompat.widget.EmojiCompatConfigurationView
    public void setEmojiCompatEnabled(boolean r10) {
        getEmojiTextViewHelper().e(r10);
    }

    @Override // android.widget.TextView
    public void setFilters(@NonNull InputFilter[] r10) {
        super.setFilters(getEmojiTextViewHelper().a(r10));
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

    @Override // androidx.core.widget.TintableCompoundButton
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public void setSupportButtonTintList(@Nullable ColorStateList r10) {
        e r11 = this.mCompoundButtonHelper;
        if (r11 == null) goto L6;
        r11.g(r10);
        return;
    }

    @Override // androidx.core.widget.TintableCompoundButton
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public void setSupportButtonTintMode(@Nullable PorterDuff.Mode r10) {
        e r11 = this.mCompoundButtonHelper;
        if (r11 == null) goto L6;
        r11.h(r10);
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

    public AppCompatRadioButton(Context r10, @Nullable AttributeSet r11) {
        this(r10, r11, R$attr.radioButtonStyle);
    }

    public AppCompatRadioButton(Context r10, @Nullable AttributeSet r11, int r12) {
        super(y.b(r10), r11, r12);
        x.a(this, getContext());
        e r13 = new e(this);
        this.mCompoundButtonHelper = r13;
        r13.e(r11, r12);
        c r14 = new c(this);
        this.mBackgroundTintHelper = r14;
        r14.e(r11, r12);
        o r15 = new o(this);
        this.mTextHelper = r15;
        r15.m(r11, r12);
        getEmojiTextViewHelper().c(r11, r12);
    }

    @Override // android.widget.CompoundButton
    public void setButtonDrawable(@DrawableRes int r10) {
        setButtonDrawable(c.a.b(getContext(), r10));
    }
}
