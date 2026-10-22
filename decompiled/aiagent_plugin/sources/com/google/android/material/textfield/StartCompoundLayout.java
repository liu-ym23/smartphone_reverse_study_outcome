package com.google.android.material.textfield;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.appcompat.widget.y;
import androidx.core.view.ViewCompat;
import androidx.core.widget.TextViewCompat;
import com.bytedance.bdturing.localstorage.DbHelper;
import com.google.android.material.internal.CheckableImageButton;
import com.google.android.material.internal.r;
import com.obric.aiagent.plugin.R;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes2.dex */
class StartCompoundLayout extends LinearLayout {
    private boolean hintExpanded;
    private CharSequence prefixText;
    private final TextView prefixTextView;
    private View.OnLongClickListener startIconOnLongClickListener;
    private ColorStateList startIconTintList;
    private PorterDuff.Mode startIconTintMode;
    private final CheckableImageButton startIconView;
    private final TextInputLayout textInputLayout;

    StartCompoundLayout(TextInputLayout r6, y r7) {
        super((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r6.getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin"));
        this.textInputLayout = r6;
        setVisibility(8);
        setOrientation(0);
        setLayoutParams(new FrameLayout.LayoutParams(-2, -1, 8388611));
        CheckableImageButton r8 = (CheckableImageButton) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.inflate(LayoutInflater.from((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin")), ZeusTransformUtils.mapRes(R.layout.design_text_input_start_icon, "layout", "design_text_input_start_icon"), this, false, "com.obric.aiagent.plugin"), CheckableImageButton.class, "com.obric.aiagent.plugin");
        this.startIconView = r8;
        AppCompatTextView r0 = new AppCompatTextView((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin"));
        this.prefixTextView = r0;
        initStartIconView(r7);
        initPrefixTextView(r7);
        addView(r8);
        addView(r0);
    }

    private void initStartIconView(y r7) {
        if (com.google.android.material.g.c.a((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin")) == false) goto L5;
        androidx.core.view.g.b((ViewGroup.MarginLayoutParams) ZeusTransformUtils.preCheckCast(this.startIconView.getLayoutParams(), ViewGroup.MarginLayoutParams.class, "com.obric.aiagent.plugin"), 0);
    L5:
        setStartIconOnClickListener(null);
        setStartIconOnLongClickListener(null);
        if (r7.g(ZeusTransformUtils.mapRes(R.styleable.TextInputLayout_startIconTint, "styleable", "TextInputLayout_startIconTint")) == false) goto L9;
        this.startIconTintList = com.google.android.material.g.c.a((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin"), r7, ZeusTransformUtils.mapRes(R.styleable.TextInputLayout_startIconTint, "styleable", "TextInputLayout_startIconTint"));
    L9:
        if (r7.g(ZeusTransformUtils.mapRes(R.styleable.TextInputLayout_startIconTintMode, "styleable", "TextInputLayout_startIconTintMode")) == false) goto L12;
        this.startIconTintMode = r.a(r7.a(ZeusTransformUtils.mapRes(R.styleable.TextInputLayout_startIconTintMode, "styleable", "TextInputLayout_startIconTintMode"), -1), null);
    L12:
        if (r7.g(ZeusTransformUtils.mapRes(R.styleable.TextInputLayout_startIconDrawable, "styleable", "TextInputLayout_startIconDrawable")) == false) goto L18;
        setStartIconDrawable(r7.a(ZeusTransformUtils.mapRes(R.styleable.TextInputLayout_startIconDrawable, "styleable", "TextInputLayout_startIconDrawable")));
        if (r7.g(ZeusTransformUtils.mapRes(R.styleable.TextInputLayout_startIconContentDescription, "styleable", "TextInputLayout_startIconContentDescription")) == false) goto L16;
        setStartIconContentDescription(r7.c(ZeusTransformUtils.mapRes(R.styleable.TextInputLayout_startIconContentDescription, "styleable", "TextInputLayout_startIconContentDescription")));
    L16:
        setStartIconCheckable(r7.a(ZeusTransformUtils.mapRes(R.styleable.TextInputLayout_startIconCheckable, "styleable", "TextInputLayout_startIconCheckable"), true));
        return;
    }

    private void initPrefixTextView(y r5) {
        this.prefixTextView.setVisibility(8);
        this.prefixTextView.setId(ZeusTransformUtils.mapRes(R.id.textinput_prefix_text, DbHelper.COL_ID, "textinput_prefix_text"));
        this.prefixTextView.setLayoutParams(new LinearLayout.LayoutParams(-2, -2));
        ViewCompat.e(this.prefixTextView, 1);
        setPrefixTextAppearance(r5.g(ZeusTransformUtils.mapRes(R.styleable.TextInputLayout_prefixTextAppearance, "styleable", "TextInputLayout_prefixTextAppearance"), 0));
        if (r5.g(ZeusTransformUtils.mapRes(R.styleable.TextInputLayout_prefixTextColor, "styleable", "TextInputLayout_prefixTextColor")) == false) goto L5;
        setPrefixTextColor(r5.e(ZeusTransformUtils.mapRes(R.styleable.TextInputLayout_prefixTextColor, "styleable", "TextInputLayout_prefixTextColor")));
    L5:
        setPrefixText(r5.c(ZeusTransformUtils.mapRes(R.styleable.TextInputLayout_prefixText, "styleable", "TextInputLayout_prefixText")));
    }

    @Override // android.widget.LinearLayout, android.view.View
    public void onMeasure(int r1, int r2) {
        super.onMeasure(r1, r2);
        updatePrefixTextViewPadding();
    }

    TextView getPrefixTextView() {
        return this.prefixTextView;
    }

    void setPrefixText(CharSequence r3) {
        CharSequence r4 = (CharSequence) ZeusTransformUtils.wrapperContextForParams(r3, CharSequence.class, "com.obric.aiagent.plugin");
        if (TextUtils.isEmpty(r4) == false) goto L5;
        CharSequence r0 = null;
    L6:
        this.prefixText = r0;
        this.prefixTextView.setText(r4);
        updateVisibility();
        return;
    L5:
        r0 = r4;
        goto L6
    }

    CharSequence getPrefixText() {
        return this.prefixText;
    }

    void setPrefixTextColor(ColorStateList r1) {
        this.prefixTextView.setTextColor(r1);
    }

    ColorStateList getPrefixTextColor() {
        return this.prefixTextView.getTextColors();
    }

    void setPrefixTextAppearance(int r1) {
        TextViewCompat.a(this.prefixTextView, r1);
    }

    void setStartIconDrawable(Drawable r4) {
        this.startIconView.setImageDrawable(r4);
        if (r4 == null) goto L5;
        e.a(this.textInputLayout, this.startIconView, this.startIconTintList, this.startIconTintMode);
        setStartIconVisible(true);
        refreshStartIconDrawableState();
        return;
    L5:
        setStartIconVisible(false);
        setStartIconOnClickListener(null);
        setStartIconOnLongClickListener(null);
        setStartIconContentDescription(null);
    }

    Drawable getStartIconDrawable() {
        return this.startIconView.getDrawable();
    }

    void setStartIconOnClickListener(View.OnClickListener r3) {
        View.OnClickListener r4 = (View.OnClickListener) ZeusTransformUtils.wrapperContextForParams(r3, View.OnClickListener.class, "com.obric.aiagent.plugin");
        e.a(this.startIconView, r4, this.startIconOnLongClickListener);
    }

    void setStartIconOnLongClickListener(View.OnLongClickListener r3) {
        View.OnLongClickListener r4 = (View.OnLongClickListener) ZeusTransformUtils.wrapperContextForParams(r3, View.OnLongClickListener.class, "com.obric.aiagent.plugin");
        this.startIconOnLongClickListener = r4;
        e.a(this.startIconView, r4);
    }

    void setStartIconVisible(boolean r2) {
        if (isStartIconVisible() == r2) goto L10;
        CheckableImageButton r0 = this.startIconView;
        if (r2 == false) goto L7;
        int r3 = 0;
    L8:
        r0.setVisibility(r3);
        updatePrefixTextViewPadding();
        updateVisibility();
        return;
    L7:
        r3 = 8;
        goto L8
    }

    boolean isStartIconVisible() {
        if (this.startIconView.getVisibility() != 0) goto L5;
        return true;
    L5:
        return false;
    }

    void refreshStartIconDrawableState() {
        e.a(this.textInputLayout, this.startIconView, this.startIconTintList);
    }

    void setStartIconCheckable(boolean r1) {
        this.startIconView.setCheckable(r1);
    }

    boolean isStartIconCheckable() {
        return this.startIconView.isCheckable();
    }

    void setStartIconContentDescription(CharSequence r3) {
        CharSequence r4 = (CharSequence) ZeusTransformUtils.wrapperContextForParams(r3, CharSequence.class, "com.obric.aiagent.plugin");
        if (getStartIconContentDescription() == r4) goto L6;
        this.startIconView.setContentDescription(r4);
        return;
    }

    CharSequence getStartIconContentDescription() {
        return this.startIconView.getContentDescription();
    }

    void setStartIconTintList(ColorStateList r3) {
        if (this.startIconTintList == r3) goto L6;
        this.startIconTintList = r3;
        e.a(this.textInputLayout, this.startIconView, r3, this.startIconTintMode);
        return;
    }

    void setStartIconTintMode(PorterDuff.Mode r3) {
        if (this.startIconTintMode == r3) goto L6;
        this.startIconTintMode = r3;
        e.a(this.textInputLayout, this.startIconView, this.startIconTintList, r3);
        return;
    }

    void setupAccessibilityNodeInfo(androidx.core.view.accessibility.b r2) {
        if (this.prefixTextView.getVisibility() != 0) goto L5;
        r2.e(this.prefixTextView);
        r2.f(this.prefixTextView);
        return;
    L5:
        r2.f(this.startIconView);
    }

    void updatePrefixTextViewPadding() {
        EditText r0 = this.textInputLayout.editText;
        if (r0 != null) goto L6;
        return;
    L6:
        if (isStartIconVisible() == false) goto L8;
        int r1 = 0;
    L9:
        ViewCompat.b(this.prefixTextView, r1, r0.getCompoundPaddingTop(), ZeusTransformUtils.getResources((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin"), "com.obric.aiagent.plugin").getDimensionPixelSize(ZeusTransformUtils.mapRes(R.dimen.material_input_text_to_prefix_suffix_padding, "dimen", "material_input_text_to_prefix_suffix_padding")), r0.getCompoundPaddingBottom());
        return;
    L8:
        r1 = ViewCompat.l(r0);
        goto L9
    }

    void onHintStateChanged(boolean r1) {
        this.hintExpanded = r1;
        updateVisibility();
    }

    private void updateVisibility() {
        int r1 = 8;
        if (this.prefixText != null) goto L5;
    L7:
        int r0 = 8;
    L9:
        if (this.startIconView.getVisibility() == 0) goto L13;
        if (r0 == 0) goto L13;
        boolean r3 = false;
    L14:
        if (r3 == false) goto L16;
        r1 = 0;
    L16:
        setVisibility(r1);
        this.prefixTextView.setVisibility(r0);
        this.textInputLayout.updateDummyDrawables();
        return;
    L13:
        r3 = true;
        goto L14
    L5:
        if (this.hintExpanded == true) goto L7;
        r0 = 0;
        goto L9
    }
}
