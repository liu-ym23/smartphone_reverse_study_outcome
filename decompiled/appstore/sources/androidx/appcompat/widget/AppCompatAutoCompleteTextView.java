package androidx.appcompat.widget;

import android.R;
import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.text.method.KeyListener;
import android.util.AttributeSet;
import android.view.ActionMode;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputConnection;
import android.widget.AutoCompleteTextView;
import androidx.annotation.DrawableRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.annotation.RestrictTo;
import androidx.appcompat.R$attr;
import androidx.core.view.TintableBackgroundView;
import androidx.core.widget.TextViewCompat;
import androidx.core.widget.TintableCompoundDrawablesView;

/* JADX INFO: loaded from: classes.dex */
public class AppCompatAutoCompleteTextView extends AutoCompleteTextView implements TintableBackgroundView, EmojiCompatConfigurationView, TintableCompoundDrawablesView {
    private static final int[] TINT_ATTRS = null;

    @NonNull
    private final g mAppCompatEmojiEditTextHelper;
    private final c mBackgroundTintHelper;
    private final o mTextHelper;

    static {
        TINT_ATTRS = new int[]{R.attr.popupBackground};
    }

    public AppCompatAutoCompleteTextView(@NonNull Context r10) {
        this(r10, null);
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

    public void initEmojiKeyListener(g r10) {
        KeyListener r11 = getKeyListener();
        if (r10.b(r11) == false) goto L9;
        boolean r12 = super.isFocusable();
        boolean r13 = super.isClickable();
        boolean r14 = super.isLongClickable();
        int r15 = super.getInputType();
        KeyListener r16 = r10.a(r11);
        if (r16 != r11) goto L7;
        return;
    L7:
        super.setKeyListener(r16);
        super.setRawInputType(r15);
        super.setFocusable(r12);
        super.setClickable(r13);
        super.setLongClickable(r14);
        return;
    }

    @Override // androidx.appcompat.widget.EmojiCompatConfigurationView
    public boolean isEmojiCompatEnabled() {
        return this.mAppCompatEmojiEditTextHelper.c();
    }

    @Override // android.widget.TextView, android.view.View
    public InputConnection onCreateInputConnection(EditorInfo r10) {
        InputConnection r11 = i.a(super.onCreateInputConnection(r10), r10, this);
        return this.mAppCompatEmojiEditTextHelper.e(r11, r10);
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
    public void setCustomSelectionActionModeCallback(@Nullable ActionMode.Callback r10) {
        super.setCustomSelectionActionModeCallback(TextViewCompat.q(this, r10));
    }

    @Override // android.widget.AutoCompleteTextView
    public void setDropDownBackgroundResource(@DrawableRes int r10) {
        setDropDownBackgroundDrawable(c.a.b(getContext(), r10));
    }

    @Override // androidx.appcompat.widget.EmojiCompatConfigurationView
    public void setEmojiCompatEnabled(boolean r10) {
        this.mAppCompatEmojiEditTextHelper.f(r10);
    }

    @Override // android.widget.TextView
    public void setKeyListener(@Nullable KeyListener r10) {
        super.setKeyListener(this.mAppCompatEmojiEditTextHelper.a(r10));
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

    public AppCompatAutoCompleteTextView(@NonNull Context r10, @Nullable AttributeSet r11) {
        this(r10, r11, R$attr.autoCompleteTextViewStyle);
    }

    public AppCompatAutoCompleteTextView(@NonNull Context r10, @Nullable AttributeSet r11, int r12) {
        super(y.b(r10), r11, r12);
        x.a(this, getContext());
        b0 r13 = b0.v(getContext(), r11, TINT_ATTRS, r12, 0);
        if (r13.s(0) == false) goto L5;
        setDropDownBackgroundDrawable(r13.g(0));
    L5:
        r13.w();
        c r14 = new c(this);
        this.mBackgroundTintHelper = r14;
        r14.e(r11, r12);
        o r15 = new o(this);
        this.mTextHelper = r15;
        r15.m(r11, r12);
        r15.b();
        g r16 = new g(this);
        this.mAppCompatEmojiEditTextHelper = r16;
        r16.d(r11, r12);
        initEmojiKeyListener(r16);
    }
}
