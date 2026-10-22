package androidx.appcompat.widget;

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
import g.C0728a;

/* renamed from: androidx.appcompat.widget.f, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public class C0436f extends Button {

    /* renamed from: a, reason: collision with root package name */
    private final C0435e f8546a;

    /* renamed from: b, reason: collision with root package name */
    private final C f8547b;

    /* renamed from: c, reason: collision with root package name */
    private C0444n f8548c;

    public C0436f(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, C0728a.f16842s);
    }

    private C0444n getEmojiTextViewHelper() {
        if (this.f8548c == null) {
            this.f8548c = new C0444n(this);
        }
        return this.f8548c;
    }

    @Override // android.widget.TextView, android.view.View
    protected void drawableStateChanged() {
        super.drawableStateChanged();
        C0435e c0435e = this.f8546a;
        if (c0435e != null) {
            c0435e.b();
        }
        C c6 = this.f8547b;
        if (c6 != null) {
            c6.b();
        }
    }

    @Override // android.widget.TextView
    public int getAutoSizeMaxTextSize() {
        if (h0.f8559a) {
            return super.getAutoSizeMaxTextSize();
        }
        C c6 = this.f8547b;
        if (c6 != null) {
            return c6.e();
        }
        return -1;
    }

    @Override // android.widget.TextView
    public int getAutoSizeMinTextSize() {
        if (h0.f8559a) {
            return super.getAutoSizeMinTextSize();
        }
        C c6 = this.f8547b;
        if (c6 != null) {
            return c6.f();
        }
        return -1;
    }

    @Override // android.widget.TextView
    public int getAutoSizeStepGranularity() {
        if (h0.f8559a) {
            return super.getAutoSizeStepGranularity();
        }
        C c6 = this.f8547b;
        if (c6 != null) {
            return c6.g();
        }
        return -1;
    }

    @Override // android.widget.TextView
    public int[] getAutoSizeTextAvailableSizes() {
        if (h0.f8559a) {
            return super.getAutoSizeTextAvailableSizes();
        }
        C c6 = this.f8547b;
        return c6 != null ? c6.h() : new int[0];
    }

    @Override // android.widget.TextView
    public int getAutoSizeTextType() {
        if (h0.f8559a) {
            return super.getAutoSizeTextType() == 1 ? 1 : 0;
        }
        C c6 = this.f8547b;
        if (c6 != null) {
            return c6.i();
        }
        return 0;
    }

    @Override // android.widget.TextView
    public ActionMode.Callback getCustomSelectionActionModeCallback() {
        return androidx.core.widget.i.o(super.getCustomSelectionActionModeCallback());
    }

    public ColorStateList getSupportBackgroundTintList() {
        C0435e c0435e = this.f8546a;
        if (c0435e != null) {
            return c0435e.c();
        }
        return null;
    }

    public PorterDuff.Mode getSupportBackgroundTintMode() {
        C0435e c0435e = this.f8546a;
        if (c0435e != null) {
            return c0435e.d();
        }
        return null;
    }

    public ColorStateList getSupportCompoundDrawablesTintList() {
        return this.f8547b.j();
    }

    public PorterDuff.Mode getSupportCompoundDrawablesTintMode() {
        return this.f8547b.k();
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
    protected void onLayout(boolean z5, int i5, int i6, int i7, int i8) {
        super.onLayout(z5, i5, i6, i7, i8);
        C c6 = this.f8547b;
        if (c6 != null) {
            c6.o(z5, i5, i6, i7, i8);
        }
    }

    @Override // android.widget.TextView
    protected void onTextChanged(CharSequence charSequence, int i5, int i6, int i7) {
        super.onTextChanged(charSequence, i5, i6, i7);
        C c6 = this.f8547b;
        if (c6 == null || h0.f8559a || !c6.l()) {
            return;
        }
        this.f8547b.c();
    }

    @Override // android.widget.TextView
    public void setAllCaps(boolean z5) {
        super.setAllCaps(z5);
        getEmojiTextViewHelper().d(z5);
    }

    @Override // android.widget.TextView
    public void setAutoSizeTextTypeUniformWithConfiguration(int i5, int i6, int i7, int i8) {
        if (h0.f8559a) {
            super.setAutoSizeTextTypeUniformWithConfiguration(i5, i6, i7, i8);
            return;
        }
        C c6 = this.f8547b;
        if (c6 != null) {
            c6.t(i5, i6, i7, i8);
        }
    }

    @Override // android.widget.TextView
    public void setAutoSizeTextTypeUniformWithPresetSizes(int[] iArr, int i5) {
        if (h0.f8559a) {
            super.setAutoSizeTextTypeUniformWithPresetSizes(iArr, i5);
            return;
        }
        C c6 = this.f8547b;
        if (c6 != null) {
            c6.u(iArr, i5);
        }
    }

    @Override // android.widget.TextView
    public void setAutoSizeTextTypeWithDefaults(int i5) {
        if (h0.f8559a) {
            super.setAutoSizeTextTypeWithDefaults(i5);
            return;
        }
        C c6 = this.f8547b;
        if (c6 != null) {
            c6.v(i5);
        }
    }

    @Override // android.view.View
    public void setBackgroundDrawable(Drawable drawable) {
        super.setBackgroundDrawable(drawable);
        C0435e c0435e = this.f8546a;
        if (c0435e != null) {
            c0435e.f(drawable);
        }
    }

    @Override // android.view.View
    public void setBackgroundResource(int i5) {
        super.setBackgroundResource(i5);
        C0435e c0435e = this.f8546a;
        if (c0435e != null) {
            c0435e.g(i5);
        }
    }

    @Override // android.widget.TextView
    public void setCustomSelectionActionModeCallback(ActionMode.Callback callback) {
        super.setCustomSelectionActionModeCallback(androidx.core.widget.i.p(this, callback));
    }

    public void setEmojiCompatEnabled(boolean z5) {
        getEmojiTextViewHelper().e(z5);
    }

    @Override // android.widget.TextView
    public void setFilters(InputFilter[] inputFilterArr) {
        super.setFilters(getEmojiTextViewHelper().a(inputFilterArr));
    }

    public void setSupportAllCaps(boolean z5) {
        C c6 = this.f8547b;
        if (c6 != null) {
            c6.s(z5);
        }
    }

    public void setSupportBackgroundTintList(ColorStateList colorStateList) {
        C0435e c0435e = this.f8546a;
        if (c0435e != null) {
            c0435e.i(colorStateList);
        }
    }

    public void setSupportBackgroundTintMode(PorterDuff.Mode mode) {
        C0435e c0435e = this.f8546a;
        if (c0435e != null) {
            c0435e.j(mode);
        }
    }

    public void setSupportCompoundDrawablesTintList(ColorStateList colorStateList) {
        this.f8547b.w(colorStateList);
        this.f8547b.b();
    }

    public void setSupportCompoundDrawablesTintMode(PorterDuff.Mode mode) {
        this.f8547b.x(mode);
        this.f8547b.b();
    }

    @Override // android.widget.TextView
    public void setTextAppearance(Context context, int i5) {
        super.setTextAppearance(context, i5);
        C c6 = this.f8547b;
        if (c6 != null) {
            c6.q(context, i5);
        }
    }

    @Override // android.widget.TextView
    public void setTextSize(int i5, float f5) {
        if (h0.f8559a) {
            super.setTextSize(i5, f5);
            return;
        }
        C c6 = this.f8547b;
        if (c6 != null) {
            c6.A(i5, f5);
        }
    }

    public C0436f(Context context, AttributeSet attributeSet, int i5) {
        super(X.b(context), attributeSet, i5);
        V.a(this, getContext());
        C0435e c0435e = new C0435e(this);
        this.f8546a = c0435e;
        c0435e.e(attributeSet, i5);
        C c6 = new C(this);
        this.f8547b = c6;
        c6.m(attributeSet, i5);
        c6.b();
        getEmojiTextViewHelper().c(attributeSet, i5);
    }
}
