package com.android.ttcjpaysdk.base.ui.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.StateListDrawable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import com.android.ttcjpaysdk.base.theme.widget.CJPayCustomButton;
import com.android.ttcjpaysdk.base.utils.CJPayBasicUtils;
import com.android.ttcjpaysdk.base.utils.CJPayFakeBoldUtils;
import com.larus.nova.R;

/* JADX INFO: loaded from: classes28.dex */
public class LoadingButton extends LinearLayout {
    private CJPayCustomButton button;
    private Drawable buttonBackground;
    private String buttonText;
    private CharSequence buttonTextCharSequence;
    private int buttonTextColor;
    private float buttonTextSize;
    private boolean enablePressedState;
    private ProgressBar loading;
    private int loadingHeight;
    private Drawable loadingIcon;
    private int loadingWidth;

    public void hideLoading() {
        if (this.loading.getVisibility() != 4) goto L5;
        return;
    L5:
        if (this.loading.getVisibility() == 8) goto L14;
        setClickable(true);
        this.loading.setVisibility(4);
        if (TextUtils.isEmpty(this.buttonTextCharSequence) == true) goto L10;
        applyButtonText(this.buttonTextCharSequence);
        return;
    L10:
        applyButtonText(this.buttonText);
        return;
    }

    public boolean isLoading() {
        if (this.loading.getVisibility() != 0) goto L5;
        return true;
    L5:
        return false;
    }

    public void setButtonGradientBackground() {
        this.button.setButtonGradientBackground();
    }

    public void setButtonTextBold() {
        CJPayFakeBoldUtils.fakeBold(this.button);
    }

    public void showLoading() {
        if (this.loading.getVisibility() != 0) goto L5;
        return;
    L5:
        setClickable(false);
        this.loading.setVisibility(0);
        this.button.setText("");
    }

    public String getButtonText() {
        return this.buttonText;
    }

    public LoadingButton(Context r100) {
        this(r100, null);
    }

    private void applyButtonText(CharSequence r100) {
        CJPayCustomButton r101 = this.button;
        if (r101 == null) goto L6;
        r101.setText(r100);
        return;
    }

    private void initView(Context r100) {
        setOrientation(0);
        View r101 = LayoutInflater.from(r100).inflate(R.layout.cj_pay_view_loading_button, this, true);
        this.button = (CJPayCustomButton) r101.findViewById(R.id.loading_btn_text);
        this.loading = (ProgressBar) r101.findViewById(R.id.loading_btn_loading);
    }

    public void setButtonBackground(Drawable r100) {
        this.buttonBackground = r100;
        this.button.setBackground(r100);
    }

    public void setButtonStyle(CJPayCustomButton.ButtonStyle r100) {
        this.button.setButtonStyle(r100);
    }

    public void setButtonText(CharSequence r100) {
        if (r100 == null) goto L4;
        String r101 = r100.toString();
    L5:
        this.buttonText = r101;
        this.buttonTextCharSequence = r100;
        applyButtonText(r100);
        invalidate();
        return;
    L4:
        r101 = "";
        goto L5
    }

    public void setButtonTextColor(int r100) {
        this.buttonTextColor = r100;
        this.button.setTextColor(r100);
        invalidate();
    }

    public void setButtonTextColorPressedState(ColorStateList r100) {
        this.button.setTextColor(r100);
    }

    @Override // android.view.View
    public void setEnabled(boolean r100) {
        super.setEnabled(r100);
        this.button.setEnabled(r100);
    }

    public void setLoadingHeight(int r100) {
        this.loadingHeight = r100;
        this.loading.getLayoutParams().height = r100;
        invalidate();
    }

    public void setLoadingIndeterminateDrawable(Drawable r100) {
        this.loading.setIndeterminateDrawable(r100);
        invalidate();
    }

    public void setLoadingWidth(int r100) {
        this.loadingWidth = r100;
        this.loading.getLayoutParams().width = r100;
        invalidate();
    }

    public void setButtonText(String r100) {
        this.buttonText = r100;
        this.buttonTextCharSequence = "";
        applyButtonText(r100);
        invalidate();
    }

    public LoadingButton(Context r100, AttributeSet r101) {
        this(r100, r101, 0);
    }

    private void initType(Context r100, AttributeSet r101) {
        TypedArray r102 = r100.obtainStyledAttributes(r101, new int[]{R.attr.btnBackground, R.attr.btnText, R.attr.btnTextColor, R.attr.btnTextSize, R.attr.enablePressedState, R.attr.loadingHeight, R.attr.loadingIcon, R.attr.loadingWidth});
        int r103 = r102.getIndexCount();
        int r104 = 0;
    L3:
        if (r104 >= r103) goto L28;
        int r105 = r102.getIndex(r104);
        if (r105 != 1) goto L8;
        String r106 = r102.getString(r105);
        this.buttonText = r106;
        applyButtonText(r106);
    L27:
        r104 = r104 + 1;
        goto L3
    L8:
        if (r105 != 2) goto L11;
        int r107 = r102.getColor(r105, -1);
        this.buttonTextColor = r107;
        this.button.setTextColor(r107);
        goto L27
    L11:
        if (r105 != 3) goto L14;
        float r108 = r102.getDimension(r105, CJPayBasicUtils.sp2px(r100, 15.0f));
        this.buttonTextSize = r108;
        this.button.setTextSize(0, r108);
        goto L27
    L14:
        if (r105 != 7) goto L17;
        this.loadingWidth = (int) r102.getDimension(r105, CJPayBasicUtils.dipToPX(r100, 20.0f));
        this.loading.getLayoutParams().width = this.loadingWidth;
        goto L27
    L17:
        if (r105 != 5) goto L19;
        this.loadingHeight = (int) r102.getDimension(r105, CJPayBasicUtils.dipToPX(r100, 20.0f));
        this.loading.getLayoutParams().height = this.loadingHeight;
        goto L27
    L19:
        if (r105 != 0) goto L22;
        Drawable r109 = r102.getDrawable(r105);
        this.buttonBackground = r109;
        this.button.setBackground(r109);
        goto L27
    L22:
        if (r105 != 6) goto L25;
        Drawable r110 = r102.getDrawable(r105);
        this.loadingIcon = r110;
        this.loading.setIndeterminateDrawable(r110);
        goto L27
    L25:
        if (r105 != 4) goto L27;
        boolean r111 = r102.getBoolean(r105, false);
        this.enablePressedState = r111;
        this.button.enablePressedState(r111);
        goto L27
    L28:
        r102.recycle();
    }

    public void setButtonPressedState(ColorStateList r100, StateListDrawable r101) {
        this.button.setBackgroundDrawable(r101);
        this.button.setTextColor(r100);
    }

    public void setButtonTextSize(int r100, float r101) {
        this.buttonTextSize = r101;
        this.button.setTextSize(r100, r101);
        invalidate();
    }

    public LoadingButton(Context r100, AttributeSet r101, int r102) {
        super(r100, r101, r102);
        this.buttonText = "";
        this.buttonTextCharSequence = "";
        this.enablePressedState = false;
        initView(r100);
        initType(r100, r101);
    }
}
