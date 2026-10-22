package com.bytedance.android.live.profit.redpacket.model;

import com.bytedance.tools.kcp.aio.runtime.RpcMessage;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes47.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0007\b\u0007\u0018\u00002\u00020\u0001R\u001a\u0010\u0003\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001a\u0010\b\u001a\u00020\u00078\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000bR\u001a\u0010\f\u001a\u00020\u00078\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\f\u0010\t\u001a\u0004\b\r\u0010\u000b¨\u0006\u000e"}, d2 = {"Lcom/bytedance/android/live/profit/redpacket/model/l;", "", "", "tempStatus", "I", "getTempStatus", "()I", "", "tempStatusNum", "Ljava/lang/String;", "getTempStatusNum", "()Ljava/lang/String;", "tempStatusText", "getTempStatusText", "live-redpacket-api_saasRelease"}, k = 1, mv = {1, 5, 1})
@RpcMessage(messageName = "webcast.revenue.biz.luckyBox.ObserveTempStatusResponse")
public final class l {

    @SerializedName("temp_status")
    private final int tempStatus;

    @SerializedName("temp_status_num")
    private final String tempStatusNum;

    @SerializedName("temp_status_text")
    private final String tempStatusText;
}
