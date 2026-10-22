package com.android.ttcjpaysdk.base.theme.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.CheckBox;
import com.android.ttcjpaysdk.base.ktextension.CJPayColorHelper;
import com.android.ttcjpaysdk.base.theme.CJPayColorConstants;
import com.android.ttcjpaysdk.base.theme.CJPayThemeManager;
import com.android.ttcjpaysdk.base.utils.CJBasicCommonUtils;
import com.bytedance.mt.protector.impl.color.ColorProtector;
import com.larus.nova.R;

/* JADX INFO: loaded from: classes28.dex */
public class CJPayCircleCheckBox extends CJPayCheckBoxAdapter {
    private Drawable enableBgDrawable;
    private int mBackgroundColor;
    private CheckBox mCheckBox;
    private boolean mIsIESNewStyle;
    private View mRootView;
    private Drawable unenableBgDrawable;
    private boolean withCircleWhenUnchecked;

    @Override // com.android.ttcjpaysdk.base.theme.widget.CJPayCheckBoxAdapter
    public void changeCheckStatus() {
        if (this.mCheckBox.isChecked() == false) goto L5;
        setChecked(false);
        return;
    L5:
        setChecked(true);
    }

    @Override // com.android.ttcjpaysdk.base.theme.widget.CJPayCheckBoxAdapter
    public boolean isChecked() {
        return this.mCheckBox.isChecked();
    }

    public void setUnavailable() {
        this.mCheckBox.setBackgroundResource(R.drawable.cj_pay_icon_check_box_unavailable);
        this.mRootView.setBackgroundColor(ColorProtector.parseColor("#00000000"));
    }

    public CheckBox getCheckBox() {
        return this.mCheckBox;
    }

    public CJPayCircleCheckBox(Context r100) {
        super(r100);
        this.mBackgroundColor = CJPayColorHelper.safeParseColor(CJPayColorConstants.CJ_PAY_RED);
        this.withCircleWhenUnchecked = false;
        this.mIsIESNewStyle = false;
        initView(r100);
    }

    public void initView(Context r100) {
        this.mBackgroundColor = Color.parseColor(CJPayThemeManager.getInstance().getThemeInfo().checkBoxInfo.bgColor);     // Catch: Exception -> L4
    L6:
        View r101 = LayoutInflater.from(r100).inflate(R.layout.cj_pay_custom_circle_checkbox_layout, this);
        this.mRootView = r101;
        CheckBox r102 = (CheckBox) r101.findViewById(R.id.cj_pay_custom_checkbox);
        this.mCheckBox = r102;
        r102.setClickable(false);
        this.mRootView.setBackgroundColor(this.mBackgroundColor);
        setChecked(true);
        return;
    L4:
        e = move-exception;
        CJBasicCommonUtils.reportCatchException("CJPayCircleCheckBox#initView", e);
        CJBasicCommonUtils.logCatch("CJCatch", "CJPayCircleCheckBox#initView", e);
        goto L6
    }

    @Override // com.android.ttcjpaysdk.base.theme.widget.CJPayCheckBoxAdapter
    public void setChecked(boolean r100) {
        this.mCheckBox.setChecked(r100);
        if (r100 == false) goto L14;
        this.mRootView.setBackgroundColor(this.mBackgroundColor);
        if (this.withCircleWhenUnchecked == false) goto L24;
        Drawable r101 = this.enableBgDrawable;
        if (r101 == null) goto L10;
        this.mCheckBox.setBackgroundDrawable(r101);
        return;
    L10:
        if (this.mIsIESNewStyle == false) goto L12;
        this.mCheckBox.setBackgroundResource(R.drawable.cj_pay_icon_check_box_pressed2);
        return;
    L12:
        this.mCheckBox.setBackgroundResource(R.drawable.cj_pay_icon_check_box_pressed);
        return;
    L24:
        return;
    L14:
        if (this.withCircleWhenUnchecked == false) goto L22;
        Drawable r102 = this.unenableBgDrawable;
        if (r102 == null) goto L19;
        this.mCheckBox.setBackgroundDrawable(r102);
        goto L22
    L19:
        if (this.mIsIESNewStyle == false) goto L21;
        this.mCheckBox.setBackgroundResource(R.drawable.cj_pay_icon_check_box_normal3);
        goto L22
    L21:
        this.mCheckBox.setBackgroundResource(R.drawable.cj_pay_icon_check_box_normal);
    L22:
        this.mRootView.setBackgroundColor(ColorProtector.parseColor("#00000000"));
    }

    @Override // com.android.ttcjpaysdk.base.theme.widget.CJPayCheckBoxAdapter
    public void setIESNewStyle(boolean r100) {
        this.mIsIESNewStyle = r100;
    }

    @Override // com.android.ttcjpaysdk.base.theme.widget.CJPayCheckBoxAdapter
    public void setWithCircleWhenUnchecked(boolean r100) {
        this.withCircleWhenUnchecked = r100;
    }

    public CJPayCircleCheckBox(Context r100, AttributeSet r101) {
        super(r100, r101);
        this.mBackgroundColor = CJPayColorHelper.safeParseColor(CJPayColorConstants.CJ_PAY_RED);
        this.withCircleWhenUnchecked = false;
        this.mIsIESNewStyle = false;
        TypedArray r102 = r100.obtainStyledAttributes(r101, new int[]{R.attr.CJPayEnableBgDrawable, R.attr.CJPayUnenbleBgDrawable, R.attr.CJPayWithCircleWhenUnchecked});
        this.enableBgDrawable = r102.getDrawable(0);
        this.unenableBgDrawable = r102.getDrawable(1);
        this.withCircleWhenUnchecked = r102.getBoolean(2, false);
        initView(r100);
    }

    public CJPayCircleCheckBox(Context r100, AttributeSet r101, int r102) {
        super(r100, r101, r102);
        this.mBackgroundColor = CJPayColorHelper.safeParseColor(CJPayColorConstants.CJ_PAY_RED);
        this.withCircleWhenUnchecked = false;
        this.mIsIESNewStyle = false;
        TypedArray r103 = r100.obtainStyledAttributes(r101, new int[]{R.attr.CJPayEnableBgDrawable, R.attr.CJPayUnenbleBgDrawable, R.attr.CJPayWithCircleWhenUnchecked});
        this.enableBgDrawable = r103.getDrawable(0);
        this.unenableBgDrawable = r103.getDrawable(1);
        this.withCircleWhenUnchecked = r103.getBoolean(2, false);
        initView(r100);
    }
}
