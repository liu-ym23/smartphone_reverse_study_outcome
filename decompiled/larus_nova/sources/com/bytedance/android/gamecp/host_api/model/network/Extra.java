package com.bytedance.android.gamecp.host_api.model.network;

import com.bytedance.android.shopping.yata.business.ability.common.TriggerTiming;
import com.bytedance.android.tools.pbadapter.annotation.IgnoreProtoFieldCheck;
import com.google.gson.annotations.SerializedName;

/* JADX INFO: loaded from: classes44.dex */
@IgnoreProtoFieldCheck
public class Extra {

    @SerializedName("has_more")
    public boolean hasMore;

    @SerializedName(TriggerTiming.NOW)
    public long now;

    public Extra() {
    }
}
