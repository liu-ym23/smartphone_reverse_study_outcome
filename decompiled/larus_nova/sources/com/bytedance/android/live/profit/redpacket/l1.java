package com.bytedance.android.live.profit.redpacket;

import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes47.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\b\u0018\u00002\u00020\u0001R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001c\u0010\u0007\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0007\u0010\u0004\u001a\u0004\b\b\u0010\u0006R\u001c\u0010\t\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\t\u0010\u0004\u001a\u0004\b\t\u0010\u0006¨\u0006\n"}, d2 = {"Lcom/bytedance/android/live/profit/redpacket/l1;", "", "", "detail", "Ljava/lang/String;", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "()Ljava/lang/String;", "redPacketId", "b", "isShowSurpriseResult", "live-redpacket-api_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class l1 {

    @SerializedName("detail")
    private final String detail;

    @SerializedName("is_show_surprise_result")
    private final String isShowSurpriseResult;

    @SerializedName("red_packet_id")
    private final String redPacketId;

    public final String a() {
        return this.detail;
    }

    public final String b() {
        return this.redPacketId;
    }

    public l1(String r100, String r101, String r102) {
        this.detail = r100;
        this.redPacketId = r101;
        this.isShowSurpriseResult = r102;
    }
}
