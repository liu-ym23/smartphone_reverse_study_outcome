package com.android.ttcjpaysdk.base.ui.data;

import com.android.ttcjpaysdk.base.json.CJPayObject;

/* JADX INFO: loaded from: classes28.dex */
public class CJPayKeepDialogInfo implements CJPayObject {
    public String jh_app_id;
    public String jh_merchant_id;
    public boolean mHasVoucher;
    public boolean mIsBackButtonPressed;
    public boolean mShouldShow;
    public RetainInfo retain_info;
    public String tradeNo;
    public String tradeNoSp;
    public String tradeNoTp;

    public CJPayKeepDialogInfo() {
        this.mHasVoucher = false;
        this.mShouldShow = false;
        this.mIsBackButtonPressed = false;
        this.tradeNoTp = "";
        this.tradeNoSp = "";
        this.tradeNo = "";
        this.jh_merchant_id = "";
        this.jh_app_id = "";
    }
}
