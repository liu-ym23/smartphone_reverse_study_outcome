package com.android.ttcjpaysdk.thirdparty.data;

import android.text.TextUtils;
import com.android.ttcjpaysdk.base.json.CJPayObject;
import java.util.ArrayList;
import java.util.Iterator;

/* JADX INFO: loaded from: classes39.dex */
public class CJPayDiscountInfo implements CJPayObject {
    public ArrayList<CJPayDiscount> discounts;
    public ArrayList<CJPayCampaign> discounts_v2;
    public String msg;
    public String status;

    public CJPayDiscountInfo() {
        this.discounts = new ArrayList();
        this.discounts_v2 = new ArrayList();
        this.msg = "";
        this.status = "";
    }

    public CJPayCampaign getTTCJPayCampaign(String r100) {
        ArrayList<CJPayCampaign> r101 = this.discounts_v2;
        if (r101 == null) goto L10;
        Iterator<CJPayCampaign> r102 = r101.iterator();
    L6:
        if (r102.hasNext() == false) goto L15;
        CJPayCampaign r103 = r102.next();
        if (TextUtils.equals(r103.campaign_no, r100) == false) goto L6;
        return r103;
    L15:
        return null;
    L10:
        return null;
    }
}
