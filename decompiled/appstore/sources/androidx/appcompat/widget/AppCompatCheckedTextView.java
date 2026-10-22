package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.ActionMode;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputConnection;
import android.widget.CheckedTextView;
import androidx.annotation.DrawableRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import androidx.appcompat.R$attr;
import androidx.core.view.TintableBackgroundView;
import androidx.core.widget.TextViewCompat;
import androidx.core.widget.TintableCheckedTextView;
import androidx.core.widget.TintableCompoundDrawablesView;

/* JADX INFO: loaded from: classes.dex */
public class AppCompatCheckedTextView extends CheckedTextView implements TintableCheckedTextView, TintableBackgroundView, EmojiCompatConfigurationView, TintableCompoundDrawablesView {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final d f771a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final c f772b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final o f773c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public h f774d;

    public AppCompatCheckedTextView(@NonNull Context r10) {
        this(r10, null);
    }

    @NonNull
    private h getEmojiTextViewHelper() {
        if (this.f774d != null) goto L6;
        this.f774d = new h(this);
    L6:
        return this.f774d;
    }

    @Override // android.widget.CheckedTextView, android.widget.TextView, android.view.View
    public void drawableStateChanged() {
        super.drawableStateChanged();
        o r10 = this.f773c;
        if (r10 == null) goto L5;
        r10.b();
    L5:
        c r11 = this.f772b;
        if (r11 == null) goto L8;
        r11.b();
    L8:
        d r12 = this.f771a;
        if (r12 == null) goto L12;
        r12.a();
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
        c r10 = this.f772b;
        if (r10 != null) goto L7;
        return null;
    L7:
        return r10.c();
    }

    @Override // androidx.core.view.TintableBackgroundView
    @Nullable
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public PorterDuff.Mode getSupportBackgroundTintMode() {
        c r10 = this.f772b;
        if (r10 != null) goto L7;
        return null;
    L7:
        return r10.d();
    }

    @Override // androidx.core.widget.TintableCheckedTextView
    @Nullable
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public ColorStateList getSupportCheckMarkTintList() {
        d r10 = this.f771a;
        if (r10 != null) goto L7;
        return null;
    L7:
        return r10.b();
    }

    @Override // androidx.core.widget.TintableCheckedTextView
    @Nullable
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public PorterDuff.Mode getSupportCheckMarkTintMode() {
        d r10 = this.f771a;
        if (r10 != null) goto L7;
        return null;
    L7:
        return r10.c();
    }

    @Override // androidx.core.widget.TintableCompoundDrawablesView
    @Nullable
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public ColorStateList getSupportCompoundDrawablesTintList() {
        return this.f773c.j();
    }

    @Override // androidx.core.widget.TintableCompoundDrawablesView
    @Nullable
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public PorterDuff.Mode getSupportCompoundDrawablesTintMode() {
        return this.f773c.k();
    }

    @Override // androidx.appcompat.widget.EmojiCompatConfigurationView
    public boolean isEmojiCompatEnabled() {
        return getEmojiTextViewHelper().b();
    }

    @Override // android.widget.TextView, android.view.View
    public InputConnection onCreateInputConnection(EditorInfo r10) {
        return i.a(super.onCreateInputConnection(r10), r10, this);
    }

    @Override // android.widget.TextView
    public void setAllCaps(boolean r10) {
        super.setAllCaps(r10);
        getEmojiTextViewHelper().d(r10);
    }

    @Override // android.view.View
    public void setBackgroundDrawable(@Nullable Drawable r10) {
        super.setBackgroundDrawable(r10);
        c r11 = this.f772b;
        if (r11 == null) goto L6;
        r11.f(r10);
        return;
    }

    @Override // android.view.View
    public void setBackgroundResource(@DrawableRes int r10) {
        super.setBackgroundResource(r10);
        c r11 = this.f772b;
        if (r11 == null) goto L6;
        r11.g(r10);
        return;
    }

    @Override // android.widget.CheckedTextView
    public void setCheckMarkDrawable(@Nullable Drawable r10) {
        super.setCheckMarkDrawable(r10);
        d r11 = this.f771a;
        if (r11 == null) goto L6;
        r11.e();
        return;
    }

    @Override // android.widget.TextView
    public void setCompoundDrawables(Drawable r10, Drawable r11, Drawable r12, Drawable r13) {
        super.setCompoundDrawables(r10, r11, r12, r13);
        o r14 = this.f773c;
        if (r14 == null) goto L6;
        r14.p();
        return;
    }

    @Override // android.widget.TextView
    public void setCompoundDrawablesRelative(Drawable r10, Drawable r11, Drawable r12, Drawable r13) {
        super.setCompoundDrawablesRelative(r10, r11, r12, r13);
        o r14 = this.f773c;
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

    @Override // androidx.core.view.TintableBackgroundView
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public void setSupportBackgroundTintList(@Nullable ColorStateList r10) {
        c r11 = this.f772b;
        if (r11 == null) goto L6;
        r11.i(r10);
        return;
    }

    @Override // androidx.core.view.TintableBackgroundView
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public void setSupportBackgroundTintMode(@Nullable PorterDuff.Mode r10) {
        c r11 = this.f772b;
        if (r11 == null) goto L6;
        r11.j(r10);
        return;
    }

    @Override // androidx.core.widget.TintableCheckedTextView
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public void setSupportCheckMarkTintList(@Nullable ColorStateList r10) {
        d r11 = this.f771a;
        if (r11 == null) goto L6;
        r11.f(r10);
        return;
    }

    @Override // androidx.core.widget.TintableCheckedTextView
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public void setSupportCheckMarkTintMode(@Nullable PorterDuff.Mode r10) {
        d r11 = this.f771a;
        if (r11 == null) goto L6;
        r11.g(r10);
        return;
    }

    @Override // androidx.core.widget.TintableCompoundDrawablesView
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public void setSupportCompoundDrawablesTintList(@Nullable ColorStateList r10) {
        this.f773c.w(r10);
        this.f773c.b();
    }

    @Override // androidx.core.widget.TintableCompoundDrawablesView
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public void setSupportCompoundDrawablesTintMode(@Nullable PorterDuff.Mode r10) {
        this.f773c.x(r10);
        this.f773c.b();
    }

    @Override // android.widget.TextView
    public void setTextAppearance(Context r10, int r11) {
        super.setTextAppearance(r10, r11);
        o r12 = this.f773c;
        if (r12 == null) goto L6;
        r12.q(r10, r11);
        return;
    }

    public AppCompatCheckedTextView(@NonNull Context r10, @Nullable AttributeSet r11) {
        this(r10, r11, R$attr.checkedTextViewStyle);
    }

    public AppCompatCheckedTextView(@NonNull Context r10, @Nullable AttributeSet r11, int r12) {
        super(y.b(r10), r11, r12);
        x.a(this, getContext());
        o r13 = new o(this);
        this.f773c = r13;
        r13.m(r11, r12);
        r13.b();
        c r14 = new c(this);
        this.f772b = r14;
        r14.e(r11, r12);
        d r15 = new d(this);
        this.f771a = r15;
        r15.d(r11, r12);
        getEmojiTextViewHelper().c(r11, r12);
    }

    @Override // android.widget.CheckedTextView
    public void setCheckMarkDrawable(@DrawableRes int r10) {
        setCheckMarkDrawable(c.a.b(getContext(), r10));
    }
}
