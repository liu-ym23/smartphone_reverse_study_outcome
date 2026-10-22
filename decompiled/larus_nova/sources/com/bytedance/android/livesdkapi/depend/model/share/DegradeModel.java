package com.bytedance.android.livesdkapi.depend.model.share;

import com.alipay.sdk.m.u.i;
import com.google.gson.annotations.SerializedName;
import com.tencent.open.SocialConstants;

/* JADX INFO: loaded from: classes12.dex */
public class DegradeModel {

    @SerializedName(SocialConstants.PARAM_APP_DESC)
    private String desc;

    @SerializedName("weixin")
    private int weiXin;

    @SerializedName("weixin_timeline")
    private int weiXinMoment;

    public DegradeModel() {
    }

    public boolean isWeixinDegrade() {
        if (this.weiXin == 1) goto L7;
        return false;
    L7:
        return true;
    }

    public boolean isWeixinTimelineDegrade() {
        if (this.weiXinMoment == 1) goto L7;
        return false;
    L7:
        return true;
    }

    public String toJsonString() {
        return "{\"weixin\":" + this.weiXin + ",\"weixin_timeline\":" + this.weiXinMoment + i.f25855d;
    }

    public String getDesc() {
        return this.desc;
    }

    public int getWeiXin() {
        return this.weiXin;
    }

    public int getWeiXinMoment() {
        return this.weiXinMoment;
    }

    public void setDesc(String r100) {
        this.desc = r100;
    }

    public void setWeiXin(int r100) {
        this.weiXin = r100;
    }

    public void setWeiXinMoment(int r100) {
        this.weiXinMoment = r100;
    }
}
