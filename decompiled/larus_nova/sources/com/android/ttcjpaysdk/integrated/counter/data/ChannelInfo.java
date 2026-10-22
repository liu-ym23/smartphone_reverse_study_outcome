package com.android.ttcjpaysdk.integrated.counter.data;

import com.android.ttcjpaysdk.base.json.CJPayObject;

/* JADX INFO: loaded from: classes28.dex */
public class ChannelInfo implements CJPayObject {
    public ChannelData channel_data;
    public String data;
    public String ptcode;
    public QrCodeData qrcode_data;
    public String saas_scene;
    public String trade_type;

    public ChannelInfo() {
        this.ptcode = "";
        this.trade_type = "";
        this.data = "";
        this.saas_scene = "";
        this.channel_data = new ChannelData();
        this.qrcode_data = new QrCodeData();
    }
}
