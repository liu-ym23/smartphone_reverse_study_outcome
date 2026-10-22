package com.bytedance.android.live.profit.redpacket.model;

import com.bytedance.tools.kcp.aio.runtime.RpcMessage;
import com.google.gson.annotations.SerializedName;
import java.util.Map;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes47.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0007\u0018\u00002\u00020\u0001R>\u0010\u0007\u001a&\u0012\u0004\u0012\u00020\u0003\u0012\b\u0012\u00060\u0004j\u0002`\u00050\u0002j\u0012\u0012\u0004\u0012\u00020\u0003\u0012\b\u0012\u00060\u0004j\u0002`\u0005`\u00068\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0007\u0010\b\u001a\u0004\b\t\u0010\n¨\u0006\u000b"}, d2 = {"Lcom/bytedance/android/live/profit/redpacket/model/m;", "", "", "", "", "Lcom/bytedance/revenue/platform/api/core/UnsafeLong;", "Lcom/bytedance/revenue/platform/api/core/KmpMap;", "timeData", "Ljava/util/Map;", "getTimeData", "()Ljava/util/Map;", "live-redpacket-api_saasRelease"}, k = 1, mv = {1, 5, 1})
@RpcMessage(messageName = "webcast.revenue.biz.luckyBox.ObserveUpdateTimeResponse")
public final class m {

    @SerializedName("time_data")
    private final Map<String, Long> timeData;
}
