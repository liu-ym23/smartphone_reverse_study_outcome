package com.bytedance.android.livesdk.gift.model;

import com.bytedance.ee.bear.middleground.comment.aibot.model.AiBotPollingAuthResult;
import com.google.gson.annotations.SerializedName;
import java.util.List;

/* JADX INFO: loaded from: classes9.dex */
public class g3 {

    @SerializedName("diamond_rushed")
    public int diamondRushed;

    @SerializedName(AiBotPollingAuthResult.STATUS_EXPIRED)
    public boolean expired;

    @SerializedName("result")
    public boolean result;

    @SerializedName("rushed_users")
    public List<com.bytedance.android.livesdk.chatroom.model.i3> rushedList;

    public g3() {
    }
}
