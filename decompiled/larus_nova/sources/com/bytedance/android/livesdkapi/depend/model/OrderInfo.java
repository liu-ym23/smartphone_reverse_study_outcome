package com.bytedance.android.livesdkapi.depend.model;

import com.bytedance.android.livesdkapi.host.PayChannel;
import com.google.gson.annotations.SerializedName;

/* JADX INFO: loaded from: classes12.dex */
public class OrderInfo {
    private String channelId;

    @SerializedName("form_html")
    private String formHtml;
    private String mAlipayRequestString;

    @SerializedName("order_id")
    private String mId;
    private PayChannel mPayChannel;
    private boolean mSuccess;
    private String mWXAppId;
    private String mWXNonceString;
    private String mWXPartnerId;
    private String mWXPrePayId;
    private String mWXSign;
    private String mWXTimeStamp;
    private String productId;
    private int realCount;

    public OrderInfo() {
    }

    public String getAlipayRequestString() {
        return this.mAlipayRequestString;
    }

    public String getChannelId() {
        return this.channelId;
    }

    public String getFormHtml() {
        return this.formHtml;
    }

    public String getId() {
        return this.mId;
    }

    public PayChannel getPayChannel() {
        return this.mPayChannel;
    }

    public String getProductId() {
        return this.productId;
    }

    public int getRealCount() {
        return this.realCount;
    }

    public String getWXAppId() {
        return this.mWXAppId;
    }

    public String getWXNonceString() {
        return this.mWXNonceString;
    }

    public String getWXPartnerId() {
        return this.mWXPartnerId;
    }

    public String getWXPrePayId() {
        return this.mWXPrePayId;
    }

    public String getWXSign() {
        return this.mWXSign;
    }

    public String getWXTimeStamp() {
        return this.mWXTimeStamp;
    }

    public boolean isSuccess() {
        return this.mSuccess;
    }

    public void setAlipayRequestString(String r100) {
        this.mAlipayRequestString = r100;
    }

    public void setChannelId(String r100) {
        this.channelId = r100;
    }

    public void setFormHtml(String r100) {
        this.formHtml = r100;
    }

    public void setId(String r100) {
        this.mId = r100;
    }

    public void setPayChannel(PayChannel r100) {
        this.mPayChannel = r100;
    }

    public void setProductId(String r100) {
        this.productId = r100;
    }

    public void setRealCount(int r100) {
        this.realCount = r100;
    }

    public void setSuccess(boolean r100) {
        this.mSuccess = r100;
    }

    public void setWXAppId(String r100) {
        this.mWXAppId = r100;
    }

    public void setWXNonceString(String r100) {
        this.mWXNonceString = r100;
    }

    public void setWXPartnerId(String r100) {
        this.mWXPartnerId = r100;
    }

    public void setWXPrePayId(String r100) {
        this.mWXPrePayId = r100;
    }

    public void setWXSign(String r100) {
        this.mWXSign = r100;
    }

    public void setWXTimeStamp(String r100) {
        this.mWXTimeStamp = r100;
    }
}
