package com.bytedance.android.livesdk.chatroom.model.interact;

import com.google.gson.annotations.SerializedName;
import java.util.List;

/* JADX INFO: loaded from: classes7.dex */
public class RoomLinkMicAnchorSettings {

    @SerializedName("settings")
    public List<com.bytedance.android.livesdk.chatroom.interact.model.y> settings;

    public RoomLinkMicAnchorSettings() {
    }

    public List<com.bytedance.android.livesdk.chatroom.interact.model.y> getSettings() {
        return this.settings;
    }
}
