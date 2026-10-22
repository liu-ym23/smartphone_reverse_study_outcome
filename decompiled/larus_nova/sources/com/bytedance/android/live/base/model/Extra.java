package com.bytedance.android.live.base.model;

import com.bytedance.android.shopping.yata.business.ability.common.TriggerTiming;
import com.bytedance.android.tools.pbadapter.annotation.IgnoreProtoFieldCheck;
import com.google.gson.annotations.SerializedName;

/* JADX INFO: loaded from: classes45.dex */
public class Extra {

    @IgnoreProtoFieldCheck
    @SerializedName("has_more")
    public boolean hasMore;

    @IgnoreProtoFieldCheck
    @SerializedName(TriggerTiming.NOW)
    public long now;

    public Extra() {
    }
}
