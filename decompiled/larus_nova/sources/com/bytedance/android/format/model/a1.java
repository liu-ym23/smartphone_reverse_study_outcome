package com.bytedance.android.format.model;

import com.bytedance.android.gamecp.business.instantplay.InstantPlayContext;
import com.google.gson.annotations.SerializedName;
import java.util.Map;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes44.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010$\n\u0002\b\u0005\u0018\u00002\u00020\u0001R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001c\u0010\u0007\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0007\u0010\u0004\u001a\u0004\b\b\u0010\u0006R\u001c\u0010\t\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\t\u0010\u0004\u001a\u0004\b\n\u0010\u0006R\u001c\u0010\f\u001a\u0004\u0018\u00010\u000b8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u000fR\u001c\u0010\u0010\u001a\u0004\u0018\u00010\u000b8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0010\u0010\r\u001a\u0004\b\u0011\u0010\u000fR(\u0010\u0013\u001a\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u00128\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0015\u0010\u0016¨\u0006\u0017"}, d2 = {"Lcom/bytedance/android/format/model/a1;", "", "", "roomId", "Ljava/lang/String;", "getRoomId", "()Ljava/lang/String;", "userId", "getUserId", "playId", "getPlayId", "", "userInteractType", "Ljava/lang/Integer;", "getUserInteractType", "()Ljava/lang/Integer;", "interactiveRoomMode", "getInteractiveRoomMode", "", "extra", "Ljava/util/Map;", "getExtra", "()Ljava/util/Map;", "format-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class a1 {

    @SerializedName("extra")
    private final Map<String, String> extra;

    @SerializedName("interactive_room_mode")
    private final Integer interactiveRoomMode;

    @SerializedName(InstantPlayContext.PLAY_ID)
    private final String playId;

    @SerializedName("room_id")
    private final String roomId;

    @SerializedName("user_id")
    private final String userId;

    @SerializedName("interact_type")
    private final Integer userInteractType;

    public a1() {
        this.roomId = null;
        this.userId = null;
        this.playId = null;
        this.userInteractType = null;
        this.interactiveRoomMode = null;
        this.extra = null;
    }
}
