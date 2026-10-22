package com.android.ttcjpaysdk.bindcard.base.bean;

import java.io.Serializable;

/* JADX INFO: loaded from: classes28.dex */
public class CJPayBindCardCommonBean implements Serializable {
    public String processInfo;
    public String signOrderNo;
    public String smchId;

    public CJPayBindCardCommonBean() {
        this.signOrderNo = "";
        this.smchId = "";
        this.processInfo = "";
    }
}
