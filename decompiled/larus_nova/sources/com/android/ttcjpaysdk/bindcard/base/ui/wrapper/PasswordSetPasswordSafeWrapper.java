package com.android.ttcjpaysdk.bindcard.base.ui.wrapper;

import android.view.View;
import com.android.ttcjpaysdk.base.theme.CJPayThemeUtils;
import com.android.ttcjpaysdk.base.ui.Utils.CJPayBrandPromotionUtils;
import com.android.ttcjpaysdk.bindcard.base.bean.CJPayBindCardTitleBean;
import com.larus.nova.R;

/* JADX INFO: loaded from: classes28.dex */
public class PasswordSetPasswordSafeWrapper extends BasePasswordSetPasswordWrapper {
    public PasswordSetPasswordSafeWrapper(View r100) {
        super(r100);
    }

    @Override // com.android.ttcjpaysdk.bindcard.base.ui.wrapper.BasePasswordSetPasswordWrapper
    public void initViews(View r100) {
        this.mPwdInputErrorTipView.setVisibility(8);
        this.mPwdInputErrorTipView.setTextColor(CJPayThemeUtils.getLinkLightColor());
        CJPayBindCardTitleBean r101 = new CJPayBindCardTitleBean();
        r101.singleTitle = CJPayBrandPromotionUtils.Companion.getFullSetPasswordTitle(getContext().getResources().getString(R.string.cj_pay_bank_card_set_pay_pwd));
        r101.safetyText = getContext().getString(R.string.cj_pay_bank_card_set_pwd_subtitle);
        this.mBindCardTitle.setTitleInfo(r101);
    }
}
