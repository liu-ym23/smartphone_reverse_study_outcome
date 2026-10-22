package com.bytedance.android.live.profit.redpacket.model;

import com.bytedance.sdk.account.platform.base.OnekeyLoginConstants;
import com.bytedance.tools.kcp.aio.runtime.RpcMessage;
import com.google.gson.annotations.SerializedName;
import java.util.List;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes47.dex */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0007\u0018\u00002\u00020\u0001R\u001a\u0010\u0003\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R*\u0010\n\u001a\u0012\u0012\u0004\u0012\u00020\b0\u0007j\b\u0012\u0004\u0012\u00020\b`\t8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\rR\u001c\u0010\u000f\u001a\u0004\u0018\u00010\u000e8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012R\u001c\u0010\u0014\u001a\u0004\u0018\u00010\u00138\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017¨\u0006\u0018"}, d2 = {"Lcom/bytedance/android/live/profit/redpacket/model/g;", "", "", "resultType", "I", "getResultType", "()I", "", "", "Lcom/bytedance/revenue/platform/api/core/KmpList;", "boxId", "Ljava/util/List;", "getBoxId", "()Ljava/util/List;", "Lcom/bytedance/android/live/profit/redpacket/model/f;", OnekeyLoginConstants.CU_KEY_RESULT_DATA, "Lcom/bytedance/android/live/profit/redpacket/model/f;", "getResultData", "()Lcom/bytedance/android/live/profit/redpacket/model/f;", "Lcom/bytedance/android/live/profit/redpacket/model/n;", "surpriseBoxResult", "Lcom/bytedance/android/live/profit/redpacket/model/n;", "getSurpriseBoxResult", "()Lcom/bytedance/android/live/profit/redpacket/model/n;", "live-redpacket-api_saasRelease"}, k = 1, mv = {1, 5, 1})
@RpcMessage(messageName = "webcast.revenue.biz.luckyBox.ObserveLuckyBoxResultResponse")
public final class g {

    @SerializedName("box_ids")
    private final List<String> boxId;

    @SerializedName("result_data")
    private final f resultData;

    @SerializedName("result_type")
    private final int resultType;

    @SerializedName("surprise_box_result")
    private final n surpriseBoxResult;
}
