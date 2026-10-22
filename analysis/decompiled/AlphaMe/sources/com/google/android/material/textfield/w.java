package com.google.android.material.textfield;

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
import androidx.appcompat.widget.C0200f0;
import com.google.android.material.internal.CheckableImageButton;
import com.stepos.alphame.R;
import t0.J;

/* loaded from: classes.dex */
public final class w extends LinearLayout {

    /* renamed from: a, reason: collision with root package name */
    public final TextInputLayout f11110a;

    /* renamed from: b, reason: collision with root package name */
    public final C0200f0 f11111b;

    /* renamed from: c, reason: collision with root package name */
    public CharSequence f11112c;

    /* renamed from: d, reason: collision with root package name */
    public final CheckableImageButton f11113d;

    /* renamed from: e, reason: collision with root package name */
    public ColorStateList f11114e;

    /* renamed from: f, reason: collision with root package name */
    public PorterDuff.Mode f11115f;

    /* renamed from: g, reason: collision with root package name */
    public int f11116g;

    /* renamed from: h, reason: collision with root package name */
    public ImageView.ScaleType f11117h;

    /* renamed from: i, reason: collision with root package name */
    public View.OnLongClickListener f11118i;

    /* renamed from: j, reason: collision with root package name */
    public boolean f11119j;

    public w(TextInputLayout textInputLayout, android.support.v4.media.session.c cVar) {
        CharSequence charSequenceU;
        super(textInputLayout.getContext());
        this.f11110a = textInputLayout;
        setVisibility(8);
        setOrientation(0);
        setLayoutParams(new FrameLayout.LayoutParams(-2, -1, 8388611));
        CheckableImageButton checkableImageButton = (CheckableImageButton) LayoutInflater.from(getContext()).inflate(R.layout.design_text_input_start_icon, (ViewGroup) this, false);
        this.f11113d = checkableImageButton;
        C0200f0 c0200f0 = new C0200f0(getContext(), null);
        this.f11111b = c0200f0;
        if (B0.f.Q(getContext())) {
            ((ViewGroup.MarginLayoutParams) checkableImageButton.getLayoutParams()).setMarginEnd(0);
        }
        View.OnLongClickListener onLongClickListener = this.f11118i;
        checkableImageButton.setOnClickListener(null);
        com.stepos.statsrpk.c.N(checkableImageButton, onLongClickListener);
        this.f11118i = null;
        checkableImageButton.setOnLongClickListener(null);
        com.stepos.statsrpk.c.N(checkableImageButton, null);
        if (cVar.v(70)) {
            this.f11114e = B0.f.z(getContext(), cVar, 70);
        }
        if (cVar.v(71)) {
            this.f11115f = J.D(cVar.p(71, -1), null);
        }
        if (cVar.v(67)) {
            b(cVar.l(67));
            if (cVar.v(66) && checkableImageButton.getContentDescription() != (charSequenceU = cVar.u(66))) {
                checkableImageButton.setContentDescription(charSequenceU);
            }
            checkableImageButton.setCheckable(cVar.g(65, true));
        }
        int iJ = cVar.j(68, getResources().getDimensionPixelSize(R.dimen.mtrl_min_touch_target_size));
        if (iJ < 0) {
            throw new IllegalArgumentException("startIconSize cannot be less than 0");
        }
        if (iJ != this.f11116g) {
            this.f11116g = iJ;
            checkableImageButton.setMinimumWidth(iJ);
            checkableImageButton.setMinimumHeight(iJ);
        }
        if (cVar.v(69)) {
            ImageView.ScaleType scaleTypeQ = com.stepos.statsrpk.c.q(cVar.p(69, -1));
            this.f11117h = scaleTypeQ;
            checkableImageButton.setScaleType(scaleTypeQ);
        }
        c0200f0.setVisibility(8);
        c0200f0.setId(R.id.textinput_prefix_text);
        c0200f0.setLayoutParams(new LinearLayout.LayoutParams(-2, -2));
        c0200f0.setAccessibilityLiveRegion(1);
        c0200f0.setTextAppearance(cVar.r(61, 0));
        if (cVar.v(62)) {
            c0200f0.setTextColor(cVar.h(62));
        }
        CharSequence charSequenceU2 = cVar.u(60);
        this.f11112c = TextUtils.isEmpty(charSequenceU2) ? null : charSequenceU2;
        c0200f0.setText(charSequenceU2);
        e();
        addView(checkableImageButton);
        addView(c0200f0);
    }

    public final int a() {
        int marginEnd;
        CheckableImageButton checkableImageButton = this.f11113d;
        if (checkableImageButton.getVisibility() == 0) {
            marginEnd = ((ViewGroup.MarginLayoutParams) checkableImageButton.getLayoutParams()).getMarginEnd() + checkableImageButton.getMeasuredWidth();
        } else {
            marginEnd = 0;
        }
        return this.f11111b.getPaddingStart() + getPaddingStart() + marginEnd;
    }

    public final void b(Drawable drawable) {
        CheckableImageButton checkableImageButton = this.f11113d;
        checkableImageButton.setImageDrawable(drawable);
        if (drawable != null) {
            ColorStateList colorStateList = this.f11114e;
            PorterDuff.Mode mode = this.f11115f;
            TextInputLayout textInputLayout = this.f11110a;
            com.stepos.statsrpk.c.e(textInputLayout, checkableImageButton, colorStateList, mode);
            c(true);
            com.stepos.statsrpk.c.I(textInputLayout, checkableImageButton, this.f11114e);
            return;
        }
        c(false);
        View.OnLongClickListener onLongClickListener = this.f11118i;
        checkableImageButton.setOnClickListener(null);
        com.stepos.statsrpk.c.N(checkableImageButton, onLongClickListener);
        this.f11118i = null;
        checkableImageButton.setOnLongClickListener(null);
        com.stepos.statsrpk.c.N(checkableImageButton, null);
        if (checkableImageButton.getContentDescription() != null) {
            checkableImageButton.setContentDescription(null);
        }
    }

    public final void c(boolean z4) {
        CheckableImageButton checkableImageButton = this.f11113d;
        if ((checkableImageButton.getVisibility() == 0) != z4) {
            checkableImageButton.setVisibility(z4 ? 0 : 8);
            d();
            e();
        }
    }

    public final void d() {
        EditText editText = this.f11110a.f10956e;
        if (editText == null) {
            return;
        }
        this.f11111b.setPaddingRelative(this.f11113d.getVisibility() == 0 ? 0 : editText.getPaddingStart(), editText.getCompoundPaddingTop(), getContext().getResources().getDimensionPixelSize(R.dimen.material_input_text_to_prefix_suffix_padding), editText.getCompoundPaddingBottom());
    }

    public final void e() {
        int i4 = (this.f11112c == null || this.f11119j) ? 8 : 0;
        setVisibility((this.f11113d.getVisibility() == 0 || i4 == 0) ? 0 : 8);
        this.f11111b.setVisibility(i4);
        this.f11110a.s();
    }

    @Override // android.widget.LinearLayout, android.view.View
    public final void onMeasure(int i4, int i5) {
        super.onMeasure(i4, i5);
        d();
    }
}
