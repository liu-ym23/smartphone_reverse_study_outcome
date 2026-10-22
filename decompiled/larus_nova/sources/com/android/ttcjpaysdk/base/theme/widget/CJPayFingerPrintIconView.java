package com.android.ttcjpaysdk.base.theme.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import com.android.ttcjpaysdk.base.ktextension.CJPayColorHelper;
import com.android.ttcjpaysdk.base.theme.CJPayColorConstants;
import com.android.ttcjpaysdk.base.theme.CJPayThemeManager;
import com.android.ttcjpaysdk.base.utils.CJBasicCommonUtils;
import com.android.ttcjpaysdk.base.utils.CJPayBasicUtils;
import com.larus.nova.R;

/* JADX INFO: loaded from: classes28.dex */
public class CJPayFingerPrintIconView extends FrameLayout {
    private int mBackgroundColor;
    private int mGrayCircleSize;
    private View mIconGrayCircleBgView;
    private int mIconSize;
    private ImageView mIconView;
    private boolean mWithGrayCircleBg;

    private void drawView() {
        ViewGroup.LayoutParams r100 = this.mIconView.getLayoutParams();
        r100.width = this.mIconSize;
        ViewGroup.LayoutParams r101 = this.mIconView.getLayoutParams();
        r101.height = this.mIconSize;
        if (this.mWithGrayCircleBg == false) goto L5;
        this.mIconGrayCircleBgView.setVisibility(0);
        ViewGroup.LayoutParams r102 = this.mIconGrayCircleBgView.getLayoutParams();
        r102.height = this.mGrayCircleSize;
        ViewGroup.LayoutParams r103 = this.mIconGrayCircleBgView.getLayoutParams();
        r103.width = this.mGrayCircleSize;
        this.mIconView.setImageResource(R.drawable.cj_pay_icon_fingerprint_gray);
    L12:
        this.mBackgroundColor = Color.parseColor(CJPayThemeManager.getInstance().getThemeInfo().buttonInfo.startBgColor);     // Catch: Exception -> L8
    L10:
        this.mIconView.setBackgroundColor(this.mBackgroundColor);
        return;
    L8:
        e = move-exception;
        CJBasicCommonUtils.reportCatchException("CJPayFingerPrintIconView#drawView", e);
        CJBasicCommonUtils.logCatch("CJCatch", "CJPayFingerPrintIconView#drawView", e);
        goto L10
    L5:
        this.mIconGrayCircleBgView.setVisibility(8);
        this.mIconView.setImageResource(R.drawable.cj_pay_icon_fingerprint_white);
        goto L12
    }

    public CJPayFingerPrintIconView(Context r100) {
        super(r100);
        this.mBackgroundColor = CJPayColorHelper.safeParseColor(CJPayColorConstants.CJ_PAY_RED);
        this.mWithGrayCircleBg = false;
        this.mGrayCircleSize = CJPayBasicUtils.dipToPX(getContext(), 88.0f);
        this.mIconSize = CJPayBasicUtils.dipToPX(getContext(), 60.0f);
        initView(r100, null);
    }

    public CJPayFingerPrintIconView(Context r100, AttributeSet r101) {
        super(r100, r101);
        this.mBackgroundColor = CJPayColorHelper.safeParseColor(CJPayColorConstants.CJ_PAY_RED);
        this.mWithGrayCircleBg = false;
        this.mGrayCircleSize = CJPayBasicUtils.dipToPX(getContext(), 88.0f);
        this.mIconSize = CJPayBasicUtils.dipToPX(getContext(), 60.0f);
        TypedArray r102 = r100.obtainStyledAttributes(r101, new int[]{R.attr.CJPayGrayCircleSize, R.attr.CJPayIconSize, R.attr.CJPayWithGrayCircleBg});
        this.mWithGrayCircleBg = r102.getBoolean(2, false);
        this.mGrayCircleSize = (int) r102.getDimension(0, CJPayBasicUtils.dipToPX(getContext(), 88.0f));
        if (this.mWithGrayCircleBg == false) goto L5;
        int r103 = CJPayBasicUtils.dipToPX(getContext(), 54.0f);
    L6:
        this.mIconSize = (int) r102.getDimension(1, r103);
        initView(r100, r101);
        return;
    L5:
        r103 = CJPayBasicUtils.dipToPX(getContext(), 60.0f);
        goto L6
    }

    private void initView(Context r100, AttributeSet r101) {
        View r102 = LayoutInflater.from(r100).inflate(R.layout.cj_pay_view_fingerprint_icon_layout, this);
        this.mIconGrayCircleBgView = r102.findViewById(R.id.cj_pay_fingerprint_icon_bg);
        this.mIconView = (ImageView) r102.findViewById(R.id.cj_pay_fingerprint_icon);
        drawView();
    }

    public CJPayFingerPrintIconView(Context r100, AttributeSet r101, int r102) {
        super(r100, r101, r102);
        this.mBackgroundColor = CJPayColorHelper.safeParseColor(CJPayColorConstants.CJ_PAY_RED);
        this.mWithGrayCircleBg = false;
        this.mGrayCircleSize = CJPayBasicUtils.dipToPX(getContext(), 88.0f);
        this.mIconSize = CJPayBasicUtils.dipToPX(getContext(), 60.0f);
        TypedArray r103 = r100.obtainStyledAttributes(r101, new int[]{R.attr.CJPayGrayCircleSize, R.attr.CJPayIconSize, R.attr.CJPayWithGrayCircleBg});
        this.mWithGrayCircleBg = r103.getBoolean(2, false);
        this.mGrayCircleSize = (int) r103.getDimension(0, CJPayBasicUtils.dipToPX(getContext(), 88.0f));
        if (this.mWithGrayCircleBg == false) goto L5;
        int r104 = CJPayBasicUtils.dipToPX(getContext(), 54.0f);
    L6:
        this.mIconSize = (int) r103.getDimension(1, r104);
        initView(r100, r101);
        return;
    L5:
        r104 = CJPayBasicUtils.dipToPX(getContext(), 60.0f);
        goto L6
    }

    public void updateViewAttributes(boolean r100, int r101, int r102) {
        this.mWithGrayCircleBg = r100;
        this.mGrayCircleSize = r101;
        this.mIconSize = r102;
        drawView();
    }
}
