package com.android.ttcjpaysdk.bindcard.base.ui.wrapper;

import android.view.View;
import android.widget.TextView;
import com.android.ttcjpaysdk.base.framework.BaseWrapper;
import com.android.ttcjpaysdk.base.ui.component.input.BasePwdEditText;
import com.android.ttcjpaysdk.bindcard.base.view.CJPayBindCardTitle;
import com.larus.nova.R;

/* JADX INFO: loaded from: classes28.dex */
public abstract class BasePasswordSetPasswordWrapper extends BaseWrapper {
    public CJPayBindCardTitle mBindCardTitle;
    public BasePwdEditText mPwdEditTextView;
    public TextView mPwdInputErrorTipView;

    public abstract void initViews(View r100);

    public BasePasswordSetPasswordWrapper(View r100) {
        super(r100);
        this.mBindCardTitle = (CJPayBindCardTitle) r100.findViewById(R.id.bind_card_title);
        this.mPwdEditTextView = (BasePwdEditText) r100.findViewById(R.id.cj_pay_pwd_view);
        this.mPwdInputErrorTipView = (TextView) r100.findViewById(R.id.cj_pay_input_error_tip);
        initViews(r100);
    }
}
