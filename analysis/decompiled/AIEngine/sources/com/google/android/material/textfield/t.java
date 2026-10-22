package com.google.android.material.textfield;

import android.annotation.SuppressLint;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
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
import androidx.appcompat.widget.AppCompatTextView;
import androidx.appcompat.widget.x0;
import com.google.android.material.internal.CheckableImageButton;
import com.stepos.aiengine.R;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
@SuppressLint({"ViewConstructor"})
/* loaded from: classes.dex */
public final class t extends LinearLayout {

    /* renamed from: a, reason: collision with root package name */
    public final TextInputLayout f5333a;

    /* renamed from: b, reason: collision with root package name */
    public final AppCompatTextView f5334b;

    /* renamed from: c, reason: collision with root package name */
    public CharSequence f5335c;

    /* renamed from: d, reason: collision with root package name */
    public final CheckableImageButton f5336d;

    /* renamed from: e, reason: collision with root package name */
    public ColorStateList f5337e;
    public PorterDuff.Mode h;

    /* renamed from: j, reason: collision with root package name */
    public int f5338j;

    /* renamed from: k, reason: collision with root package name */
    public ImageView.ScaleType f5339k;

    /* renamed from: l, reason: collision with root package name */
    public View.OnLongClickListener f5340l;

    /* renamed from: m, reason: collision with root package name */
    public boolean f5341m;

    public t(TextInputLayout textInputLayout, x0 x0Var) {
        CharSequence text;
        super(textInputLayout.getContext());
        this.f5333a = textInputLayout;
        setVisibility(8);
        setOrientation(0);
        setLayoutParams(new FrameLayout.LayoutParams(-2, -1, 8388611));
        CheckableImageButton checkableImageButton = (CheckableImageButton) LayoutInflater.from(getContext()).inflate(R.layout.design_text_input_start_icon, (ViewGroup) this, false);
        this.f5336d = checkableImageButton;
        AppCompatTextView appCompatTextView = new AppCompatTextView(getContext(), null);
        this.f5334b = appCompatTextView;
        if (w4.c.d(getContext())) {
            ((ViewGroup.MarginLayoutParams) checkableImageButton.getLayoutParams()).setMarginEnd(0);
        }
        View.OnLongClickListener onLongClickListener = this.f5340l;
        checkableImageButton.setOnClickListener(null);
        m.d(checkableImageButton, onLongClickListener);
        this.f5340l = null;
        checkableImageButton.setOnLongClickListener(null);
        m.d(checkableImageButton, null);
        TypedArray typedArray = x0Var.f948b;
        if (typedArray.hasValue(70)) {
            this.f5337e = w4.c.b(getContext(), x0Var, 70);
        }
        if (typedArray.hasValue(71)) {
            this.h = com.google.android.material.internal.m.b(typedArray.getInt(71, -1), null);
        }
        if (typedArray.hasValue(67)) {
            b(x0Var.b(67));
            if (typedArray.hasValue(66) && checkableImageButton.getContentDescription() != (text = typedArray.getText(66))) {
                checkableImageButton.setContentDescription(text);
            }
            checkableImageButton.setCheckable(typedArray.getBoolean(65, true));
        }
        int dimensionPixelSize = typedArray.getDimensionPixelSize(68, getResources().getDimensionPixelSize(R.dimen.mtrl_min_touch_target_size));
        if (dimensionPixelSize < 0) {
            throw new IllegalArgumentException("startIconSize cannot be less than 0");
        }
        if (dimensionPixelSize != this.f5338j) {
            this.f5338j = dimensionPixelSize;
            checkableImageButton.setMinimumWidth(dimensionPixelSize);
            checkableImageButton.setMinimumHeight(dimensionPixelSize);
        }
        if (typedArray.hasValue(69)) {
            ImageView.ScaleType scaleTypeB = m.b(typedArray.getInt(69, -1));
            this.f5339k = scaleTypeB;
            checkableImageButton.setScaleType(scaleTypeB);
        }
        appCompatTextView.setVisibility(8);
        appCompatTextView.setId(R.id.textinput_prefix_text);
        appCompatTextView.setLayoutParams(new LinearLayout.LayoutParams(-2, -2));
        appCompatTextView.setAccessibilityLiveRegion(1);
        appCompatTextView.setTextAppearance(typedArray.getResourceId(61, 0));
        if (typedArray.hasValue(62)) {
            appCompatTextView.setTextColor(x0Var.a(62));
        }
        CharSequence text2 = typedArray.getText(60);
        this.f5335c = TextUtils.isEmpty(text2) ? null : text2;
        appCompatTextView.setText(text2);
        e();
        addView(checkableImageButton);
        addView(appCompatTextView);
    }

    public final int a() {
        int marginEnd;
        CheckableImageButton checkableImageButton = this.f5336d;
        if (checkableImageButton.getVisibility() == 0) {
            marginEnd = ((ViewGroup.MarginLayoutParams) checkableImageButton.getLayoutParams()).getMarginEnd() + checkableImageButton.getMeasuredWidth();
        } else {
            marginEnd = 0;
        }
        return this.f5334b.getPaddingStart() + getPaddingStart() + marginEnd;
    }

    public final void b(Drawable drawable) {
        CheckableImageButton checkableImageButton = this.f5336d;
        checkableImageButton.setImageDrawable(drawable);
        if (drawable != null) {
            ColorStateList colorStateList = this.f5337e;
            PorterDuff.Mode mode = this.h;
            TextInputLayout textInputLayout = this.f5333a;
            m.a(textInputLayout, checkableImageButton, colorStateList, mode);
            c(true);
            m.c(textInputLayout, checkableImageButton, this.f5337e);
            return;
        }
        c(false);
        View.OnLongClickListener onLongClickListener = this.f5340l;
        checkableImageButton.setOnClickListener(null);
        m.d(checkableImageButton, onLongClickListener);
        this.f5340l = null;
        checkableImageButton.setOnLongClickListener(null);
        m.d(checkableImageButton, null);
        if (checkableImageButton.getContentDescription() != null) {
            checkableImageButton.setContentDescription(null);
        }
    }

    public final void c(boolean z) {
        CheckableImageButton checkableImageButton = this.f5336d;
        if ((checkableImageButton.getVisibility() == 0) != z) {
            checkableImageButton.setVisibility(z ? 0 : 8);
            d();
            e();
        }
    }

    public final void d() {
        EditText editText = this.f5333a.f5189e;
        if (editText == null) {
            return;
        }
        this.f5334b.setPaddingRelative(this.f5336d.getVisibility() == 0 ? 0 : editText.getPaddingStart(), editText.getCompoundPaddingTop(), getContext().getResources().getDimensionPixelSize(R.dimen.material_input_text_to_prefix_suffix_padding), editText.getCompoundPaddingBottom());
    }

    public final void e() {
        int i10 = (this.f5335c == null || this.f5341m) ? 8 : 0;
        setVisibility((this.f5336d.getVisibility() == 0 || i10 == 0) ? 0 : 8);
        this.f5334b.setVisibility(i10);
        this.f5333a.s();
    }

    @Override // android.widget.LinearLayout, android.view.View
    public final void onMeasure(int i10, int i11) {
        super.onMeasure(i10, i11);
        d();
    }
}
