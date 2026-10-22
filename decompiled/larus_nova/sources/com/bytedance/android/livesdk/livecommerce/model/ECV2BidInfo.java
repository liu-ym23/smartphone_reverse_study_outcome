package com.bytedance.android.livesdk.livecommerce.model;

import com.bytedance.android.tools.pbadapter.annotation.ProtoMessage;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes10.dex */
@ProtoMessage("live.BidInfo")
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R\u0014\u0010\u0003\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"Lcom/bytedance/android/livesdk/livecommerce/model/ECV2BidInfo;", "", "()V", "promotionId", "", "livecommerce_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class ECV2BidInfo {

    @SerializedName("promotion_id")
    public String promotionId;

    public ECV2BidInfo() {
    }
}
