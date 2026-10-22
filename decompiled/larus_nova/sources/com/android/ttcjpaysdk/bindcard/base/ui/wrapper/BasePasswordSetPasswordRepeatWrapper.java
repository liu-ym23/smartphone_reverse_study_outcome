package com.android.ttcjpaysdk.bindcard.base.ui.wrapper;

import android.view.View;
import android.widget.FrameLayout;
import android.widget.ProgressBar;
import com.android.ttcjpaysdk.base.framework.BaseWrapper;
import com.android.ttcjpaysdk.base.theme.widget.CJPayCustomButton;
import com.android.ttcjpaysdk.base.ui.component.input.BasePwdEditText;
import com.android.ttcjpaysdk.bindcard.base.view.CJPayBindCardTitle;
import com.larus.nova.R;

/* JADX INFO: loaded from: classes28.dex */
public abstract class BasePasswordSetPasswordRepeatWrapper extends BaseWrapper {
    public CJPayBindCardTitle mBindCardTitle;
    public FrameLayout mBtnLayout;
    public ProgressBar mProgressLoading;
    public BasePwdEditText mPwdEditTextView;
    public CJPayCustomButton mTvComplete;

    public abstract void initViews(View r100);

    public BasePasswordSetPasswordRepeatWrapper(View r100) {
        super(r100);
        this.mPwdEditTextView = (BasePwdEditText) r100.findViewById(R.id.cj_pay_pwd_view_repeat);
        this.mBindCardTitle = (CJPayBindCardTitle) r100.findViewById(R.id.bind_card_title);
        this.mTvComplete = (CJPayCustomButton) r100.findViewById(R.id.tv_complete);
        this.mBtnLayout = (FrameLayout) r100.findViewById(R.id.cj_pay_set_pwd_btn);
        this.mProgressLoading = (ProgressBar) r100.findViewById(R.id.cj_pay_iv_loading);
        initViews(r100);
    }
}
