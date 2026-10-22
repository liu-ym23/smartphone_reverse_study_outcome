package com.android.ttcjpaysdk.thirdparty.data;

import android.text.TextUtils;
import com.android.ttcjpaysdk.base.json.CJPayObject;
import com.android.ttcjpaysdk.base.ui.data.AssetInfoBean;
import com.android.ttcjpaysdk.base.ui.data.CJPayButtonInfo;
import com.android.ttcjpaysdk.base.ui.data.RetainInfo;
import java.io.Serializable;
import java.util.ArrayList;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes39.dex */
public class CJPayInsufficientBalanceHintInfo implements CJPayObject, Serializable {
    public String again_reason_type;
    public CJPayButtonInfo button_info;
    public String button_text;
    public ArrayList<String> cashierTag;
    public String combineType;
    public String fail_type;
    public String icon;
    public String icon_url;
    public int loading_time_ms;
    public String msg;
    public String origin_pay_type;
    public FrontSubPayTypeInfo rec_pay_type;
    public RetainInfo retain_info;
    public transient JSONObject retain_info_v2;
    public String secondPayType;
    public AssetInfoBean select_asset_info;
    public String status_msg;
    public String style;
    public String sub_button_text;
    public String sub_status_msg;
    public String title_msg;
    public String top_right_desc_text;
    public transient JSONObject track_exts;
    public String track_exts_str;
    public int trade_amount;
    public boolean useDoubleColorBallLoading;
    public ArrayList<String> voucher_bank_icons;

    public boolean hasCombinePay() {
        if (this.rec_pay_type.pay_type_data.combine_show_info.size() <= 0) goto L5;
        return true;
    L5:
        return false;
    }

    public boolean isPayAgainRecSimpleExp() {
        return this.cashierTag.contains("pay_again_rec_simple");
    }

    public Boolean isServerControl() {
        return Boolean.valueOf(!TextUtils.isEmpty(this.style));
    }

    public CJPayInsufficientBalanceHintInfo() {
        this.msg = "";
        this.icon_url = "";
        this.combineType = "";
        this.status_msg = "";
        this.title_msg = "";
        this.rec_pay_type = new FrontSubPayTypeInfo();
        this.voucher_bank_icons = new ArrayList();
        this.button_text = "";
        this.sub_button_text = "";
        this.sub_status_msg = "";
        this.retain_info = new RetainInfo();
        this.retain_info_v2 = null;
        this.style = "";
        this.select_asset_info = null;
        this.button_info = new CJPayButtonInfo();
        this.top_right_desc_text = "";
        this.trade_amount = 0;
        this.icon = "";
        this.cashierTag = new ArrayList();
        this.secondPayType = "";
        this.fail_type = "1";
        this.again_reason_type = "";
        this.origin_pay_type = "";
        this.track_exts = new JSONObject();
        this.track_exts_str = "";
        this.loading_time_ms = 0;
        this.useDoubleColorBallLoading = false;
    }
}
