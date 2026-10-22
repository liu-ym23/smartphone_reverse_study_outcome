package com.android.ttcjpaysdk.bindcard.base.ui.wrapper;

import android.view.View;
import com.android.ttcjpaysdk.base.ui.Utils.CJPayBrandPromotionUtils;
import com.android.ttcjpaysdk.bindcard.base.bean.CJPayBindCardTitleBean;
import com.larus.nova.R;

/* JADX INFO: loaded from: classes28.dex */
public class PasswordSetPasswordRepeatSafeWrapper extends BasePasswordSetPasswordRepeatWrapper {
    public PasswordSetPasswordRepeatSafeWrapper(View r100) {
        super(r100);
    }

    @Override // com.android.ttcjpaysdk.bindcard.base.ui.wrapper.BasePasswordSetPasswordRepeatWrapper
    public void initViews(View r100) {
        this.mProgressLoading.setVisibility(8);
        CJPayBindCardTitleBean r101 = new CJPayBindCardTitleBean();
        r101.singleTitle = CJPayBrandPromotionUtils.Companion.getFullSetPasswordTitleAgain(getContext().getString(R.string.cj_pay_bank_card_confirm_pay_pwd));
        this.mBindCardTitle.setTitleInfo(r101);
    }
}
