package com.android.ttcjpaysdk.thirdparty.verify.params;

import com.android.ttcjpaysdk.base.json.CJPayObject;
import com.android.ttcjpaysdk.thirdparty.data.CJPayCheckoutCounterResponseBean;
import java.util.ArrayList;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes39.dex */
public class BdCounterParams implements CJPayObject {
    private CJPayCheckoutCounterResponseBean checkoutCounterResponseBean;
    public boolean isIndependentBDCounter;
    public String outer_aid;
    public ArrayList<String> payAddiTypeList;
    public JSONObject serverParams;
    public String voucher_show_info_type;

    public BdCounterParams() {
        this.isIndependentBDCounter = false;
        this.checkoutCounterResponseBean = null;
        this.outer_aid = "";
        this.voucher_show_info_type = "";
    }

    public CJPayCheckoutCounterResponseBean getBdCounterBean() {
        return this.checkoutCounterResponseBean;
    }

    public boolean isNoKeepDialog() {
        return this.isIndependentBDCounter;
    }

    public void setCheckoutCounterResponseBean(CJPayCheckoutCounterResponseBean r100) {
        this.checkoutCounterResponseBean = r100;
    }
}
