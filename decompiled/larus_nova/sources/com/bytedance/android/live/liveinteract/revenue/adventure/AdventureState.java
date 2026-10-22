package com.bytedance.android.live.liveinteract.revenue.adventure;

import com.bytedance.android.livesdk.chatroom.model.interact.h;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;

/* JADX INFO: loaded from: classes46.dex */
public class AdventureState implements Serializable {

    @SerializedName("adventure_info")
    public h adventureInfo;

    @SerializedName("status")
    public int status;

    public AdventureState() {
    }
}
