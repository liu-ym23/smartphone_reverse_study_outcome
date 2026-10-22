package com.google.android.material.textfield;

import a1.C0411d;
import a1.C0413f;
import a1.C0415h;
import a1.C0418k;
import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.appcompat.widget.D;
import androidx.appcompat.widget.a0;
import com.google.android.material.internal.CheckableImageButton;
import q1.C0981c;

/* loaded from: classes.dex */
class z extends LinearLayout {

    /* renamed from: a, reason: collision with root package name */
    private final TextInputLayout f13427a;

    /* renamed from: b, reason: collision with root package name */
    private final TextView f13428b;

    /* renamed from: c, reason: collision with root package name */
    private CharSequence f13429c;

    /* renamed from: d, reason: collision with root package name */
    private final CheckableImageButton f13430d;

    /* renamed from: e, reason: collision with root package name */
    private ColorStateList f13431e;

    /* renamed from: f, reason: collision with root package name */
    private PorterDuff.Mode f13432f;

    /* renamed from: g, reason: collision with root package name */
    private int f13433g;

    /* renamed from: h, reason: collision with root package name */
    private ImageView.ScaleType f13434h;

    /* renamed from: i, reason: collision with root package name */
    private View.OnLongClickListener f13435i;

    /* renamed from: j, reason: collision with root package name */
    private boolean f13436j;

    z(TextInputLayout textInputLayout, a0 a0Var) {
        super(textInputLayout.getContext());
        this.f13427a = textInputLayout;
        setVisibility(8);
        setOrientation(0);
        setLayoutParams(new FrameLayout.LayoutParams(-2, -1, 8388611));
        CheckableImageButton checkableImageButton = (CheckableImageButton) LayoutInflater.from(getContext()).inflate(C0415h.f6869c, (ViewGroup) this, false);
        this.f13430d = checkableImageButton;
        t.e(checkableImageButton);
        D d6 = new D(getContext());
        this.f13428b = d6;
        j(a0Var);
        i(a0Var);
        addView(checkableImageButton);
        addView(d6);
    }

    private void C() {
        int i5 = (this.f13429c == null || this.f13436j) ? 8 : 0;
        setVisibility((this.f13430d.getVisibility() == 0 || i5 == 0) ? 0 : 8);
        this.f13428b.setVisibility(i5);
        this.f13427a.p0();
    }

    private void i(a0 a0Var) {
        this.f13428b.setVisibility(8);
        this.f13428b.setId(C0413f.f6834Q);
        this.f13428b.setLayoutParams(new LinearLayout.LayoutParams(-2, -2));
        this.f13428b.setAccessibilityLiveRegion(1);
        o(a0Var.n(C0418k.T5, 0));
        int i5 = C0418k.U5;
        if (a0Var.s(i5)) {
            p(a0Var.c(i5));
        }
        n(a0Var.p(C0418k.S5));
    }

    private void j(a0 a0Var) {
        if (C0981c.g(getContext())) {
            ((ViewGroup.MarginLayoutParams) this.f13430d.getLayoutParams()).setMarginEnd(0);
        }
        u(null);
        v(null);
        int i5 = C0418k.a6;
        if (a0Var.s(i5)) {
            this.f13431e = C0981c.b(getContext(), a0Var, i5);
        }
        int i6 = C0418k.b6;
        if (a0Var.s(i6)) {
            this.f13432f = com.google.android.material.internal.r.h(a0Var.k(i6, -1), null);
        }
        int i7 = C0418k.X5;
        if (a0Var.s(i7)) {
            s(a0Var.g(i7));
            int i8 = C0418k.W5;
            if (a0Var.s(i8)) {
                r(a0Var.p(i8));
            }
            q(a0Var.a(C0418k.V5, true));
        }
        t(a0Var.f(C0418k.Y5, getResources().getDimensionPixelSize(C0411d.f6777c0)));
        int i9 = C0418k.Z5;
        if (a0Var.s(i9)) {
            w(t.b(a0Var.k(i9, -1)));
        }
    }

    void A(E.c cVar) {
        if (this.f13428b.getVisibility() != 0) {
            cVar.B0(this.f13430d);
        } else {
            cVar.p0(this.f13428b);
            cVar.B0(this.f13428b);
        }
    }

    void B() {
        EditText editText = this.f13427a.f13250e;
        if (editText == null) {
            return;
        }
        this.f13428b.setPaddingRelative(k() ? 0 : editText.getPaddingStart(), editText.getCompoundPaddingTop(), getContext().getResources().getDimensionPixelSize(C0411d.f6757L), editText.getCompoundPaddingBottom());
    }

    CharSequence a() {
        return this.f13429c;
    }

    ColorStateList b() {
        return this.f13428b.getTextColors();
    }

    int c() {
        return getPaddingStart() + this.f13428b.getPaddingStart() + (k() ? this.f13430d.getMeasuredWidth() + ((ViewGroup.MarginLayoutParams) this.f13430d.getLayoutParams()).getMarginEnd() : 0);
    }

    TextView d() {
        return this.f13428b;
    }

    CharSequence e() {
        return this.f13430d.getContentDescription();
    }

    Drawable f() {
        return this.f13430d.getDrawable();
    }

    int g() {
        return this.f13433g;
    }

    ImageView.ScaleType h() {
        return this.f13434h;
    }

    boolean k() {
        return this.f13430d.getVisibility() == 0;
    }

    void l(boolean z5) {
        this.f13436j = z5;
        C();
    }

    void m() {
        t.d(this.f13427a, this.f13430d, this.f13431e);
    }

    void n(CharSequence charSequence) {
        this.f13429c = TextUtils.isEmpty(charSequence) ? null : charSequence;
        this.f13428b.setText(charSequence);
        C();
    }

    void o(int i5) {
        androidx.core.widget.i.m(this.f13428b, i5);
    }

    @Override // android.widget.LinearLayout, android.view.View
    protected void onMeasure(int i5, int i6) {
        super.onMeasure(i5, i6);
        B();
    }

    void p(ColorStateList colorStateList) {
        this.f13428b.setTextColor(colorStateList);
    }

    void q(boolean z5) {
        this.f13430d.setCheckable(z5);
    }

    void r(CharSequence charSequence) {
        if (e() != charSequence) {
            this.f13430d.setContentDescription(charSequence);
        }
    }

    void s(Drawable drawable) {
        this.f13430d.setImageDrawable(drawable);
        if (drawable != null) {
            t.a(this.f13427a, this.f13430d, this.f13431e, this.f13432f);
            z(true);
            m();
        } else {
            z(false);
            u(null);
            v(null);
            r(null);
        }
    }

    void t(int i5) {
        if (i5 < 0) {
            throw new IllegalArgumentException("startIconSize cannot be less than 0");
        }
        if (i5 != this.f13433g) {
            this.f13433g = i5;
            t.g(this.f13430d, i5);
        }
    }

    void u(View.OnClickListener onClickListener) {
        t.h(this.f13430d, onClickListener, this.f13435i);
    }

    void v(View.OnLongClickListener onLongClickListener) {
        this.f13435i = onLongClickListener;
        t.i(this.f13430d, onLongClickListener);
    }

    void w(ImageView.ScaleType scaleType) {
        this.f13434h = scaleType;
        t.j(this.f13430d, scaleType);
    }

    void x(ColorStateList colorStateList) {
        if (this.f13431e != colorStateList) {
            this.f13431e = colorStateList;
            t.a(this.f13427a, this.f13430d, colorStateList, this.f13432f);
        }
    }

    void y(PorterDuff.Mode mode) {
        if (this.f13432f != mode) {
            this.f13432f = mode;
            t.a(this.f13427a, this.f13430d, this.f13431e, mode);
        }
    }

    void z(boolean z5) {
        if (k() != z5) {
            this.f13430d.setVisibility(z5 ? 0 : 8);
            B();
            C();
        }
    }
}
