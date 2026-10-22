package androidx.appcompat.widget;

import android.R;
import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.text.method.KeyListener;
import android.util.AttributeSet;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputConnection;
import android.widget.MultiAutoCompleteTextView;
import androidx.annotation.DrawableRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import androidx.appcompat.R$attr;
import androidx.core.view.TintableBackgroundView;
import androidx.core.widget.TintableCompoundDrawablesView;

/* JADX INFO: loaded from: classes.dex */
public class AppCompatMultiAutoCompleteTextView extends MultiAutoCompleteTextView implements TintableBackgroundView, EmojiCompatConfigurationView, TintableCompoundDrawablesView {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final int[] f776d = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final c f777a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final o f778b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final g f779c;

    static {
        f776d = new int[]{R.attr.popupBackground};
    }

    public AppCompatMultiAutoCompleteTextView(@NonNull Context r10) {
        this(r10, null);
    }

    public void a(g r10) {
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

    @Override // android.widget.TextView, android.view.View
    public void drawableStateChanged() {
        super.drawableStateChanged();
        c r10 = this.f777a;
        if (r10 == null) goto L5;
        r10.b();
    L5:
        o r11 = this.f778b;
        if (r11 == null) goto L9;
        r11.b();
        return;
    }

    @Override // androidx.core.view.TintableBackgroundView
    @Nullable
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public ColorStateList getSupportBackgroundTintList() {
        c r10 = this.f777a;
        if (r10 != null) goto L7;
        return null;
    L7:
        return r10.c();
    }

    @Override // androidx.core.view.TintableBackgroundView
    @Nullable
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public PorterDuff.Mode getSupportBackgroundTintMode() {
        c r10 = this.f777a;
        if (r10 != null) goto L7;
        return null;
    L7:
        return r10.d();
    }

    @Override // androidx.core.widget.TintableCompoundDrawablesView
    @Nullable
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public ColorStateList getSupportCompoundDrawablesTintList() {
        return this.f778b.j();
    }

    @Override // androidx.core.widget.TintableCompoundDrawablesView
    @Nullable
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public PorterDuff.Mode getSupportCompoundDrawablesTintMode() {
        return this.f778b.k();
    }

    @Override // androidx.appcompat.widget.EmojiCompatConfigurationView
    public boolean isEmojiCompatEnabled() {
        return this.f779c.c();
    }

    @Override // android.widget.TextView, android.view.View
    public InputConnection onCreateInputConnection(EditorInfo r10) {
        InputConnection r11 = i.a(super.onCreateInputConnection(r10), r10, this);
        return this.f779c.e(r11, r10);
    }

    @Override // android.view.View
    public void setBackgroundDrawable(@Nullable Drawable r10) {
        super.setBackgroundDrawable(r10);
        c r11 = this.f777a;
        if (r11 == null) goto L6;
        r11.f(r10);
        return;
    }

    @Override // android.view.View
    public void setBackgroundResource(@DrawableRes int r10) {
        super.setBackgroundResource(r10);
        c r11 = this.f777a;
        if (r11 == null) goto L6;
        r11.g(r10);
        return;
    }

    @Override // android.widget.TextView
    public void setCompoundDrawables(Drawable r10, Drawable r11, Drawable r12, Drawable r13) {
        super.setCompoundDrawables(r10, r11, r12, r13);
        o r14 = this.f778b;
        if (r14 == null) goto L6;
        r14.p();
        return;
    }

    @Override // android.widget.TextView
    public void setCompoundDrawablesRelative(Drawable r10, Drawable r11, Drawable r12, Drawable r13) {
        super.setCompoundDrawablesRelative(r10, r11, r12, r13);
        o r14 = this.f778b;
        if (r14 == null) goto L6;
        r14.p();
        return;
    }

    @Override // android.widget.AutoCompleteTextView
    public void setDropDownBackgroundResource(@DrawableRes int r10) {
        setDropDownBackgroundDrawable(c.a.b(getContext(), r10));
    }

    @Override // androidx.appcompat.widget.EmojiCompatConfigurationView
    public void setEmojiCompatEnabled(boolean r10) {
        this.f779c.f(r10);
    }

    @Override // android.widget.TextView
    public void setKeyListener(@Nullable KeyListener r10) {
        super.setKeyListener(this.f779c.a(r10));
    }

    @Override // androidx.core.view.TintableBackgroundView
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public void setSupportBackgroundTintList(@Nullable ColorStateList r10) {
        c r11 = this.f777a;
        if (r11 == null) goto L6;
        r11.i(r10);
        return;
    }

    @Override // androidx.core.view.TintableBackgroundView
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public void setSupportBackgroundTintMode(@Nullable PorterDuff.Mode r10) {
        c r11 = this.f777a;
        if (r11 == null) goto L6;
        r11.j(r10);
        return;
    }

    @Override // androidx.core.widget.TintableCompoundDrawablesView
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public void setSupportCompoundDrawablesTintList(@Nullable ColorStateList r10) {
        this.f778b.w(r10);
        this.f778b.b();
    }

    @Override // androidx.core.widget.TintableCompoundDrawablesView
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public void setSupportCompoundDrawablesTintMode(@Nullable PorterDuff.Mode r10) {
        this.f778b.x(r10);
        this.f778b.b();
    }

    @Override // android.widget.TextView
    public void setTextAppearance(Context r10, int r11) {
        super.setTextAppearance(r10, r11);
        o r12 = this.f778b;
        if (r12 == null) goto L6;
        r12.q(r10, r11);
        return;
    }

    public AppCompatMultiAutoCompleteTextView(@NonNull Context r10, @Nullable AttributeSet r11) {
        this(r10, r11, R$attr.autoCompleteTextViewStyle);
    }

    public AppCompatMultiAutoCompleteTextView(@NonNull Context r10, @Nullable AttributeSet r11, int r12) {
        super(y.b(r10), r11, r12);
        x.a(this, getContext());
        b0 r13 = b0.v(getContext(), r11, f776d, r12, 0);
        if (r13.s(0) == false) goto L5;
        setDropDownBackgroundDrawable(r13.g(0));
    L5:
        r13.w();
        c r14 = new c(this);
        this.f777a = r14;
        r14.e(r11, r12);
        o r15 = new o(this);
        this.f778b = r15;
        r15.m(r11, r12);
        r15.b();
        g r16 = new g(this);
        this.f779c = r16;
        r16.d(r11, r12);
        a(r16);
    }
}
