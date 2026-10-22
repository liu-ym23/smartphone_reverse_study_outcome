package com.android.ttcjpaysdk.thirdparty.verify.params;

import com.android.ttcjpaysdk.base.json.CJPayObject;

/* JADX INFO: loaded from: classes39.dex */
public class CJPayVerifyParams implements CJPayObject {
    public String bankCardId;
    public int pageHeight;
    public String shareAssetId;

    public CJPayVerifyParams() {
        this.pageHeight = 470;
        this.bankCardId = "";
        this.shareAssetId = "";
    }
}
