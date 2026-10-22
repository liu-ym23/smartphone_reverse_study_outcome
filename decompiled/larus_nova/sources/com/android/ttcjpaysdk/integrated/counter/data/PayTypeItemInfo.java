package com.android.ttcjpaysdk.integrated.counter.data;

import com.android.ttcjpaysdk.base.json.CJPayObject;
import com.android.ttcjpaysdk.base.ui.data.AssetInfoBean;
import com.android.ttcjpaysdk.base.ui.data.RetainInfo;

/* JADX INFO: loaded from: classes28.dex */
public class PayTypeItemInfo implements CJPayObject {
    public CashierPageInfo cashier_page_info;
    public String ext_param;
    public MerchantInfo merchant_info;
    public PayTypeInfo paytype_info;
    public PromotionProcessInfo promotion_process;
    public RetainInfo retain_info;
    public UserInfo user_info;

    public static class CashierPageInfo implements CJPayObject {
        public AssetInfoBean asset_info;

        public CashierPageInfo() {
            this.asset_info = new AssetInfoBean();
        }
    }

    public AssetInfoBean getAssetInfo() {
        CashierPageInfo r100 = this.cashier_page_info;
        if (r100 != null) goto L5;
        return null;
    L5:
        return r100.asset_info;
    }

    public PayTypeItemInfo() {
        this.paytype_info = new PayTypeInfo();
        this.cashier_page_info = new CashierPageInfo();
        this.user_info = new UserInfo();
        this.promotion_process = new PromotionProcessInfo();
        this.merchant_info = new MerchantInfo();
        this.ext_param = "";
    }
}
