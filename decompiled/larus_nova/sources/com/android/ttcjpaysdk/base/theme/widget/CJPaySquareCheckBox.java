package com.android.ttcjpaysdk.base.theme.widget;

import android.content.Context;
import android.graphics.Color;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.widget.CheckBox;
import android.widget.FrameLayout;
import com.android.ttcjpaysdk.base.ktextension.CJPayColorHelper;
import com.android.ttcjpaysdk.base.theme.CJPayColorConstants;
import com.android.ttcjpaysdk.base.theme.CJPayThemeManager;
import com.android.ttcjpaysdk.base.utils.CJBasicCommonUtils;
import com.android.ttcjpaysdk.base.utils.CJPayBasicUtils;
import com.bytedance.mt.protector.impl.color.ColorProtector;
import com.larus.nova.R;

/* JADX INFO: loaded from: classes28.dex */
public class CJPaySquareCheckBox extends FrameLayout {
    private boolean isChecked;
    private int mBackgroundColor;
    private CheckBox mCheckBox;
    private FrameLayout mCheckBoxLayout;
    private OnCheckedChangeListener mOnCheckedChangeListener;
    private View mRootView;

    public interface OnCheckedChangeListener {
        void onCheckedChanged(boolean r100);
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent r100) {
        return true;
    }

    public boolean isChecked() {
        return this.isChecked;
    }

    public CJPaySquareCheckBox(Context r100) {
        super(r100);
        this.mBackgroundColor = CJPayColorHelper.safeParseColor(CJPayColorConstants.CJ_PAY_RED);
        initView(r100);
    }

    public static /* synthetic */ OnCheckedChangeListener access$000(CJPaySquareCheckBox r100) {
        return r100.mOnCheckedChangeListener;
    }

    public static /* synthetic */ boolean access$100(CJPaySquareCheckBox r100) {
        return r100.isChecked;
    }

    public void initView(Context r100) {
        this.mBackgroundColor = Color.parseColor(CJPayThemeManager.getInstance().getThemeInfo().checkBoxInfo.bgColor);     // Catch: Exception -> L4
    L6:
        View r101 = LayoutInflater.from(r100).inflate(R.layout.cj_pay_custom_square_checkbox_layout, this);
        this.mRootView = r101;
        this.mCheckBox = (CheckBox) r101.findViewById(R.id.cj_pay_custom_checkbox);
        this.mCheckBoxLayout = (FrameLayout) this.mRootView.findViewById(R.id.cj_pay_custom_checkbox_layout);
        this.mRootView.setOnClickListener(new AnonymousClass1(this));
        int r102 = CJPayBasicUtils.dipToPX(r100, 8.0f);
        this.mRootView.setLayoutParams(new FrameLayout.LayoutParams(-2, -2));
        this.mRootView.setPadding(r102, r102, r102, r102);
        setChecked(false);
        return;
    L4:
        e = move-exception;
        CJBasicCommonUtils.reportCatchException("CJPaySquareCheckBox#initView", e);
        CJBasicCommonUtils.logCatch("CJCatch", "CJPaySquareCheckBox#initView", e);
        goto L6
    }

    public void setChecked(boolean r100) {
        this.mCheckBox.setChecked(r100);
        if (r100 == false) goto L5;
        this.mCheckBoxLayout.setBackgroundColor(this.mBackgroundColor);
    L6:
        this.isChecked = r100;
        return;
    L5:
        this.mCheckBoxLayout.setBackgroundColor(ColorProtector.parseColor("#00000000"));
        goto L6
    }

    public void setOnCheckedChangeListener(OnCheckedChangeListener r100) {
        this.mOnCheckedChangeListener = r100;
    }

    public CJPaySquareCheckBox(Context r100, AttributeSet r101) {
        super(r100, r101);
        this.mBackgroundColor = CJPayColorHelper.safeParseColor(CJPayColorConstants.CJ_PAY_RED);
        initView(r100);
    }

    public CJPaySquareCheckBox(Context r100, AttributeSet r101, int r102) {
        super(r100, r101, r102);
        this.mBackgroundColor = CJPayColorHelper.safeParseColor(CJPayColorConstants.CJ_PAY_RED);
        initView(r100);
    }
}
