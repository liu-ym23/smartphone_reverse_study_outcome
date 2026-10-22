package com.android.ttcjpaysdk.integrated.counter.data;

import com.android.ttcjpaysdk.base.json.CJPayObject;
import com.android.ttcjpaysdk.base.ui.data.AssetInfoBean;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes28.dex */
public class PreTradeCreateParam implements CJPayObject {
    public ArrayList<AssetInfoBean.AssetMetaInfoBean> asset_meta_info_list;
    public String bank_card_id;
    public String business_scene;
    public String combine_type;
    public String credit_pay_installment;
    public String ext_param;
    public String lynx_ext_param;
    public String primary_pay_type;
    public PromotionProcessInfo promotion_process;
    public String share_asset_code;
    public String share_asset_id;
    public String sub_ext;
    public String sub_pay_type;

    public PreTradeCreateParam() {
        this.bank_card_id = "";
        this.sub_pay_type = "";
        this.business_scene = "";
        this.combine_type = "";
        this.credit_pay_installment = "";
        this.ext_param = "";
        this.lynx_ext_param = "";
        this.sub_ext = "";
        this.primary_pay_type = "";
        this.share_asset_code = "";
        this.share_asset_id = "";
    }
}
