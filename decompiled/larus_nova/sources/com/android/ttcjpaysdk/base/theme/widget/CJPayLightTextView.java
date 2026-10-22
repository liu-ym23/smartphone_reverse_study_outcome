package com.android.ttcjpaysdk.base.theme.widget;

import android.content.Context;
import android.graphics.Color;
import android.util.AttributeSet;
import androidx.appcompat.widget.AppCompatTextView;
import com.android.ttcjpaysdk.base.ktextension.CJPayColorHelper;
import com.android.ttcjpaysdk.base.theme.CJPayColorConstants;
import com.android.ttcjpaysdk.base.theme.CJPayThemeManager;
import com.android.ttcjpaysdk.base.utils.CJBasicCommonUtils;

/* JADX INFO: loaded from: classes28.dex */
public class CJPayLightTextView extends AppCompatTextView {
    private int mTextColor;

    public CJPayLightTextView(Context r100) {
        super(r100);
        this.mTextColor = CJPayColorHelper.safeParseColor(CJPayColorConstants.CJ_PAY_RED);
        initView(r100);
    }

    private void initView(Context r100) {
        this.mTextColor = Color.parseColor(CJPayThemeManager.getInstance().getThemeInfo().linkTextInfo.textColor);     // Catch: Exception -> L4
    L6:
        setTextColor(this.mTextColor);
        return;
    L4:
        e = move-exception;
        CJBasicCommonUtils.reportCatchException("CJPayLightTextView#initView", e);
        CJBasicCommonUtils.logCatch("CJCatch", "CJPayLightTextView#initView", e);
        goto L6
    }

    public CJPayLightTextView(Context r100, AttributeSet r101) {
        super(r100, r101);
        this.mTextColor = CJPayColorHelper.safeParseColor(CJPayColorConstants.CJ_PAY_RED);
        initView(r100);
    }

    public CJPayLightTextView(Context r100, AttributeSet r101, int r102) {
        super(r100, r101, r102);
        this.mTextColor = CJPayColorHelper.safeParseColor(CJPayColorConstants.CJ_PAY_RED);
        initView(r100);
    }
}
