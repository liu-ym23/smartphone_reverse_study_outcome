package com.android.ttcjpaysdk.integrated.counter.data;

import com.android.ttcjpaysdk.base.json.CJPayObject;
import com.android.ttcjpaysdk.base.ui.data.AssetInfoBean;
import com.android.ttcjpaysdk.base.ui.data.CJPayButtonInfo;
import com.android.ttcjpaysdk.base.ui.data.IconTips;
import java.util.ArrayList;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes28.dex */
public class TradeConfirmResponseBean implements CJPayObject {
    public String biz_fail_reason;
    public CJPayButtonInfo button_info;
    public ArrayList<String> cashier_tag;
    public String change_pay_type_desc;
    public String code;
    public String combine_type;
    public JSONObject exts;
    public AssetInfoBean fail_reason_asset_info;
    public JSONObject hint_info;
    public IconTips icon_tips;
    public String jump_url;
    public String msg;
    public String pay_type;
    public PayTypeInfo paytype_info;
    public ProcessInfo process_info;
    public int pwd_left_lock_time;
    public String pwd_left_lock_time_desc;
    public int pwd_left_retry_time;
    public String unavailable_pay_type_sub_title;
    public AssetInfoBean used_asset_info;

    public TradeConfirmResponseBean() {
        this.code = "";
        this.msg = "";
        this.pwd_left_retry_time = 0;
        this.pwd_left_lock_time = 0;
        this.pwd_left_lock_time_desc = "";
        this.button_info = new CJPayButtonInfo();
        this.process_info = new ProcessInfo();
        this.paytype_info = new PayTypeInfo();
        this.jump_url = "";
        this.pay_type = "";
        this.combine_type = "";
        this.change_pay_type_desc = "";
        this.unavailable_pay_type_sub_title = "";
        this.icon_tips = new IconTips();
        this.biz_fail_reason = "";
        this.hint_info = new JSONObject();
        this.exts = new JSONObject();
        this.cashier_tag = new ArrayList();
    }
}
