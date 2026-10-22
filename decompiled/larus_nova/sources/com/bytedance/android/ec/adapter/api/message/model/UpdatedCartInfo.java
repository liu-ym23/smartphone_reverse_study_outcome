package com.bytedance.android.ec.adapter.api.message.model;

import com.bytedance.android.tools.pbadapter.annotation.ProtoMessage;
import com.google.gson.annotations.SerializedName;

/* JADX INFO: loaded from: classes43.dex */
@ProtoMessage("webcast.im.UpdatedCartInfo")
public class UpdatedCartInfo {

    @SerializedName("horizontal")
    public RoomCartStateHorizontal horizontal;
    public RoomCartIconsMsg roomCartIcons;

    @SerializedName("vertical")
    public RoomCartStateVertical vertical;

    public static class RoomCartIconsMsg extends de.a {
        public RoomCartIconsMsg() {
        }
    }

    @ProtoMessage("webcast.data.CartHorizontal")
    public static class RoomCartStateHorizontal extends de.b {
        public RoomCartStateHorizontal() {
        }
    }

    @ProtoMessage("webcast.data.CartVertical")
    public static class RoomCartStateVertical extends de.b {
        public RoomCartStateVertical() {
        }
    }

    public UpdatedCartInfo() {
    }
}
