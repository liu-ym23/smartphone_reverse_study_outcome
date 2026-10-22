package com.google.android.material.textfield;

import android.annotation.SuppressLint;
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
import androidx.appcompat.widget.AppCompatTextView;
import androidx.appcompat.widget.U;
import com.google.android.material.R$dimen;
import com.google.android.material.R$id;
import com.google.android.material.R$layout;
import com.google.android.material.R$styleable;
import com.google.android.material.internal.CheckableImageButton;

@SuppressLint({"ViewConstructor"})
/* loaded from: classes2.dex */
public class z extends LinearLayout {

    /* renamed from: a, reason: collision with root package name */
    public final TextInputLayout f21694a;

    /* renamed from: b, reason: collision with root package name */
    public final TextView f21695b;

    /* renamed from: c, reason: collision with root package name */
    public CharSequence f21696c;

    /* renamed from: d, reason: collision with root package name */
    public final CheckableImageButton f21697d;

    /* renamed from: e, reason: collision with root package name */
    public ColorStateList f21698e;

    /* renamed from: f, reason: collision with root package name */
    public PorterDuff.Mode f21699f;

    /* renamed from: g, reason: collision with root package name */
    public int f21700g;

    /* renamed from: h, reason: collision with root package name */
    public ImageView.ScaleType f21701h;

    /* renamed from: i, reason: collision with root package name */
    public View.OnLongClickListener f21702i;

    /* renamed from: j, reason: collision with root package name */
    public boolean f21703j;

    public z(TextInputLayout textInputLayout, U u10) {
        super(textInputLayout.getContext());
        this.f21694a = textInputLayout;
        setVisibility(8);
        setOrientation(0);
        setLayoutParams(new FrameLayout.LayoutParams(-2, -1, 8388611));
        CheckableImageButton checkableImageButton = (CheckableImageButton) LayoutInflater.from(getContext()).inflate(R$layout.design_text_input_start_icon, (ViewGroup) this, false);
        this.f21697d = checkableImageButton;
        t.e(checkableImageButton);
        AppCompatTextView appCompatTextView = new AppCompatTextView(getContext());
        this.f21695b = appCompatTextView;
        j(u10);
        i(u10);
        addView(checkableImageButton);
        addView(appCompatTextView);
    }

    public void A(C0.c cVar) {
        if (this.f21695b.getVisibility() != 0) {
            cVar.P0(this.f21697d);
        } else {
            cVar.A0(this.f21695b);
            cVar.P0(this.f21695b);
        }
    }

    public void B() {
        EditText editText = this.f21694a.f21527e;
        if (editText == null) {
            return;
        }
        this.f21695b.setPaddingRelative(k() ? 0 : editText.getPaddingStart(), editText.getCompoundPaddingTop(), getContext().getResources().getDimensionPixelSize(R$dimen.material_input_text_to_prefix_suffix_padding), editText.getCompoundPaddingBottom());
    }

    public final void C() {
        int i10 = (this.f21696c == null || this.f21703j) ? 8 : 0;
        setVisibility((this.f21697d.getVisibility() == 0 || i10 == 0) ? 0 : 8);
        this.f21695b.setVisibility(i10);
        this.f21694a.p0();
    }

    public CharSequence a() {
        return this.f21696c;
    }

    public ColorStateList b() {
        return this.f21695b.getTextColors();
    }

    public int c() {
        return getPaddingStart() + this.f21695b.getPaddingStart() + (k() ? this.f21697d.getMeasuredWidth() + ((ViewGroup.MarginLayoutParams) this.f21697d.getLayoutParams()).getMarginEnd() : 0);
    }

    public TextView d() {
        return this.f21695b;
    }

    public CharSequence e() {
        return this.f21697d.getContentDescription();
    }

    public Drawable f() {
        return this.f21697d.getDrawable();
    }

    public int g() {
        return this.f21700g;
    }

    public ImageView.ScaleType h() {
        return this.f21701h;
    }

    public final void i(U u10) {
        this.f21695b.setVisibility(8);
        this.f21695b.setId(R$id.textinput_prefix_text);
        this.f21695b.setLayoutParams(new LinearLayout.LayoutParams(-2, -2));
        this.f21695b.setAccessibilityLiveRegion(1);
        o(u10.n(R$styleable.TextInputLayout_prefixTextAppearance, 0));
        int i10 = R$styleable.TextInputLayout_prefixTextColor;
        if (u10.s(i10)) {
            p(u10.c(i10));
        }
        n(u10.p(R$styleable.TextInputLayout_prefixText));
    }

    public final void j(U u10) {
        if (W2.c.h(getContext())) {
            ((ViewGroup.MarginLayoutParams) this.f21697d.getLayoutParams()).setMarginEnd(0);
        }
        u(null);
        v(null);
        int i10 = R$styleable.TextInputLayout_startIconTint;
        if (u10.s(i10)) {
            this.f21698e = W2.c.b(getContext(), u10, i10);
        }
        int i11 = R$styleable.TextInputLayout_startIconTintMode;
        if (u10.s(i11)) {
            this.f21699f = com.google.android.material.internal.u.i(u10.k(i11, -1), null);
        }
        int i12 = R$styleable.TextInputLayout_startIconDrawable;
        if (u10.s(i12)) {
            s(u10.g(i12));
            int i13 = R$styleable.TextInputLayout_startIconContentDescription;
            if (u10.s(i13)) {
                r(u10.p(i13));
            }
            q(u10.a(R$styleable.TextInputLayout_startIconCheckable, true));
        }
        t(u10.f(R$styleable.TextInputLayout_startIconMinSize, getResources().getDimensionPixelSize(R$dimen.mtrl_min_touch_target_size)));
        int i14 = R$styleable.TextInputLayout_startIconScaleType;
        if (u10.s(i14)) {
            w(t.b(u10.k(i14, -1)));
        }
    }

    public boolean k() {
        return this.f21697d.getVisibility() == 0;
    }

    public void l(boolean z10) {
        this.f21703j = z10;
        C();
    }

    public void m() {
        t.d(this.f21694a, this.f21697d, this.f21698e);
    }

    public void n(CharSequence charSequence) {
        this.f21696c = TextUtils.isEmpty(charSequence) ? null : charSequence;
        this.f21695b.setText(charSequence);
        C();
    }

    public void o(int i10) {
        androidx.core.widget.i.m(this.f21695b, i10);
    }

    @Override // android.widget.LinearLayout, android.view.View
    public void onMeasure(int i10, int i11) {
        super.onMeasure(i10, i11);
        B();
    }

    public void p(ColorStateList colorStateList) {
        this.f21695b.setTextColor(colorStateList);
    }

    public void q(boolean z10) {
        this.f21697d.setCheckable(z10);
    }

    public void r(CharSequence charSequence) {
        if (e() != charSequence) {
            this.f21697d.setContentDescription(charSequence);
        }
    }

    public void s(Drawable drawable) {
        this.f21697d.setImageDrawable(drawable);
        if (drawable != null) {
            t.a(this.f21694a, this.f21697d, this.f21698e, this.f21699f);
            z(true);
            m();
        } else {
            z(false);
            u(null);
            v(null);
            r(null);
        }
    }

    public void t(int i10) {
        if (i10 < 0) {
            throw new IllegalArgumentException("startIconSize cannot be less than 0");
        }
        if (i10 != this.f21700g) {
            this.f21700g = i10;
            t.g(this.f21697d, i10);
        }
    }

    public void u(View.OnClickListener onClickListener) {
        t.h(this.f21697d, onClickListener, this.f21702i);
    }

    public void v(View.OnLongClickListener onLongClickListener) {
        this.f21702i = onLongClickListener;
        t.i(this.f21697d, onLongClickListener);
    }

    public void w(ImageView.ScaleType scaleType) {
        this.f21701h = scaleType;
        t.j(this.f21697d, scaleType);
    }

    public void x(ColorStateList colorStateList) {
        if (this.f21698e != colorStateList) {
            this.f21698e = colorStateList;
            t.a(this.f21694a, this.f21697d, colorStateList, this.f21699f);
        }
    }

    public void y(PorterDuff.Mode mode) {
        if (this.f21699f != mode) {
            this.f21699f = mode;
            t.a(this.f21694a, this.f21697d, this.f21698e, mode);
        }
    }

    public void z(boolean z10) {
        if (k() != z10) {
            this.f21697d.setVisibility(z10 ? 0 : 8);
            B();
            C();
        }
    }
}
