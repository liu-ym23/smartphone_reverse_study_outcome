package com.bytedance.android.livesdk.chatroom.model.interact;

import com.bytedance.android.live.base.model.user.User;
import com.google.gson.annotations.SerializedName;

/* JADX INFO: loaded from: classes7.dex */
public class o2 {

    @SerializedName("rank")
    private int rank;

    @SerializedName(com.bytedance.android.ec.core.event.a.KEY_SCORE)
    private long score;

    @SerializedName("user")
    private User user;

    @SerializedName("user_id")
    private long userId;

    public o2() {
    }
}
