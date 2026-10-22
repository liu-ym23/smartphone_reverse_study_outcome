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
import androidx.appcompat.R$attr;

/* loaded from: classes.dex */
public class AppCompatButton extends Button {
    private C1297j mAppCompatEmojiTextHelper;
    private final C1291d mBackgroundTintHelper;
    private final C1309w mTextHelper;

    public AppCompatButton(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, R$attr.buttonStyle);
    }

    private C1297j getEmojiTextViewHelper() {
        if (this.mAppCompatEmojiTextHelper == null) {
            this.mAppCompatEmojiTextHelper = new C1297j(this);
        }
        return this.mAppCompatEmojiTextHelper;
    }

    @Override // android.widget.TextView, android.view.View
    public void drawableStateChanged() {
        super.drawableStateChanged();
        C1291d c1291d = this.mBackgroundTintHelper;
        if (c1291d != null) {
            c1291d.b();
        }
        C1309w c1309w = this.mTextHelper;
        if (c1309w != null) {
            c1309w.b();
        }
    }

    @Override // android.widget.TextView
    public int getAutoSizeMaxTextSize() {
        if (b0.f9179a) {
            return super.getAutoSizeMaxTextSize();
        }
        C1309w c1309w = this.mTextHelper;
        if (c1309w != null) {
            return c1309w.e();
        }
        return -1;
    }

    @Override // android.widget.TextView
    public int getAutoSizeMinTextSize() {
        if (b0.f9179a) {
            return super.getAutoSizeMinTextSize();
        }
        C1309w c1309w = this.mTextHelper;
        if (c1309w != null) {
            return c1309w.f();
        }
        return -1;
    }

    @Override // android.widget.TextView
    public int getAutoSizeStepGranularity() {
        if (b0.f9179a) {
            return super.getAutoSizeStepGranularity();
        }
        C1309w c1309w = this.mTextHelper;
        if (c1309w != null) {
            return c1309w.g();
        }
        return -1;
    }

    @Override // android.widget.TextView
    public int[] getAutoSizeTextAvailableSizes() {
        if (b0.f9179a) {
            return super.getAutoSizeTextAvailableSizes();
        }
        C1309w c1309w = this.mTextHelper;
        return c1309w != null ? c1309w.h() : new int[0];
    }

    @Override // android.widget.TextView
    @SuppressLint({"WrongConstant"})
    public int getAutoSizeTextType() {
        if (b0.f9179a) {
            return super.getAutoSizeTextType() == 1 ? 1 : 0;
        }
        C1309w c1309w = this.mTextHelper;
        if (c1309w != null) {
            return c1309w.i();
        }
        return 0;
    }

    @Override // android.widget.TextView
    public ActionMode.Callback getCustomSelectionActionModeCallback() {
        return androidx.core.widget.i.o(super.getCustomSelectionActionModeCallback());
    }

    public ColorStateList getSupportBackgroundTintList() {
        C1291d c1291d = this.mBackgroundTintHelper;
        if (c1291d != null) {
            return c1291d.c();
        }
        return null;
    }

    public PorterDuff.Mode getSupportBackgroundTintMode() {
        C1291d c1291d = this.mBackgroundTintHelper;
        if (c1291d != null) {
            return c1291d.d();
        }
        return null;
    }

    public ColorStateList getSupportCompoundDrawablesTintList() {
        return this.mTextHelper.j();
    }

    public PorterDuff.Mode getSupportCompoundDrawablesTintMode() {
        return this.mTextHelper.k();
    }

    @Override // android.view.View
    public void onInitializeAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        super.onInitializeAccessibilityEvent(accessibilityEvent);
        accessibilityEvent.setClassName(Button.class.getName());
    }

    @Override // android.view.View
    public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo accessibilityNodeInfo) {
        super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
        accessibilityNodeInfo.setClassName(Button.class.getName());
    }

    @Override // android.widget.TextView, android.view.View
    public void onLayout(boolean z10, int i10, int i11, int i12, int i13) {
        super.onLayout(z10, i10, i11, i12, i13);
        C1309w c1309w = this.mTextHelper;
        if (c1309w != null) {
            c1309w.o(z10, i10, i11, i12, i13);
        }
    }

    @Override // android.widget.TextView
    public void onTextChanged(CharSequence charSequence, int i10, int i11, int i12) {
        super.onTextChanged(charSequence, i10, i11, i12);
        C1309w c1309w = this.mTextHelper;
        if (c1309w == null || b0.f9179a || !c1309w.l()) {
            return;
        }
        this.mTextHelper.c();
    }

    @Override // android.widget.TextView
    public void setAllCaps(boolean z10) {
        super.setAllCaps(z10);
        getEmojiTextViewHelper().d(z10);
    }

    @Override // android.widget.TextView
    public void setAutoSizeTextTypeUniformWithConfiguration(int i10, int i11, int i12, int i13) throws IllegalArgumentException {
        if (b0.f9179a) {
            super.setAutoSizeTextTypeUniformWithConfiguration(i10, i11, i12, i13);
            return;
        }
        C1309w c1309w = this.mTextHelper;
        if (c1309w != null) {
            c1309w.t(i10, i11, i12, i13);
        }
    }

    @Override // android.widget.TextView
    public void setAutoSizeTextTypeUniformWithPresetSizes(int[] iArr, int i10) throws IllegalArgumentException {
        if (b0.f9179a) {
            super.setAutoSizeTextTypeUniformWithPresetSizes(iArr, i10);
            return;
        }
        C1309w c1309w = this.mTextHelper;
        if (c1309w != null) {
            c1309w.u(iArr, i10);
        }
    }

    @Override // android.widget.TextView
    public void setAutoSizeTextTypeWithDefaults(int i10) {
        if (b0.f9179a) {
            super.setAutoSizeTextTypeWithDefaults(i10);
            return;
        }
        C1309w c1309w = this.mTextHelper;
        if (c1309w != null) {
            c1309w.v(i10);
        }
    }

    @Override // android.view.View
    public void setBackgroundDrawable(Drawable drawable) {
        super.setBackgroundDrawable(drawable);
        C1291d c1291d = this.mBackgroundTintHelper;
        if (c1291d != null) {
            c1291d.f(drawable);
        }
    }

    @Override // android.view.View
    public void setBackgroundResource(int i10) {
        super.setBackgroundResource(i10);
        C1291d c1291d = this.mBackgroundTintHelper;
        if (c1291d != null) {
            c1291d.g(i10);
        }
    }

    @Override // android.widget.TextView
    public void setCustomSelectionActionModeCallback(ActionMode.Callback callback) {
        super.setCustomSelectionActionModeCallback(androidx.core.widget.i.p(this, callback));
    }

    public void setEmojiCompatEnabled(boolean z10) {
        getEmojiTextViewHelper().e(z10);
    }

    @Override // android.widget.TextView
    public void setFilters(InputFilter[] inputFilterArr) {
        super.setFilters(getEmojiTextViewHelper().a(inputFilterArr));
    }

    public void setSupportAllCaps(boolean z10) {
        C1309w c1309w = this.mTextHelper;
        if (c1309w != null) {
            c1309w.s(z10);
        }
    }

    public void setSupportBackgroundTintList(ColorStateList colorStateList) {
        C1291d c1291d = this.mBackgroundTintHelper;
        if (c1291d != null) {
            c1291d.i(colorStateList);
        }
    }

    public void setSupportBackgroundTintMode(PorterDuff.Mode mode) {
        C1291d c1291d = this.mBackgroundTintHelper;
        if (c1291d != null) {
            c1291d.j(mode);
        }
    }

    public void setSupportCompoundDrawablesTintList(ColorStateList colorStateList) {
        this.mTextHelper.w(colorStateList);
        this.mTextHelper.b();
    }

    public void setSupportCompoundDrawablesTintMode(PorterDuff.Mode mode) {
        this.mTextHelper.x(mode);
        this.mTextHelper.b();
    }

    @Override // android.widget.TextView
    public void setTextAppearance(Context context, int i10) {
        super.setTextAppearance(context, i10);
        C1309w c1309w = this.mTextHelper;
        if (c1309w != null) {
            c1309w.q(context, i10);
        }
    }

    @Override // android.widget.TextView
    public void setTextSize(int i10, float f10) {
        if (b0.f9179a) {
            super.setTextSize(i10, f10);
            return;
        }
        C1309w c1309w = this.mTextHelper;
        if (c1309w != null) {
            c1309w.A(i10, f10);
        }
    }

    public AppCompatButton(Context context, AttributeSet attributeSet, int i10) {
        super(Q.b(context), attributeSet, i10);
        O.a(this, getContext());
        C1291d c1291d = new C1291d(this);
        this.mBackgroundTintHelper = c1291d;
        c1291d.e(attributeSet, i10);
        C1309w c1309w = new C1309w(this);
        this.mTextHelper = c1309w;
        c1309w.m(attributeSet, i10);
        c1309w.b();
        getEmojiTextViewHelper().c(attributeSet, i10);
    }
}
