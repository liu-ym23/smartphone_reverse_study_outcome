package com.bytedance.android.livesdk.chatroom.broadcast.v2.scene.model;

import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes7.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\t\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R\"\u0010\u0003\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0002\u0010\b\u001a\u0004\b\u0003\u0010\u0005\"\u0004\b\u0006\u0010\u0007R\"\u0010\t\u001a\u0004\u0018\u00010\n8\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0002\u0010\u000f\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\"\u0010\u0010\u001a\u0004\u0018\u00010\n8\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0002\u0010\u000f\u001a\u0004\b\u0011\u0010\f\"\u0004\b\u0012\u0010\u000e¨\u0006\u0013"}, d2 = {"Lcom/bytedance/android/livesdk/chatroom/broadcast/v2/scene/model/ShellSourceParams;", "Ljava/io/Serializable;", "()V", "isDirectGoEndPage", "", "()Ljava/lang/Boolean;", "setDirectGoEndPage", "(Ljava/lang/Boolean;)V", "Ljava/lang/Boolean;", "lastAnchorRoomId", "", "getLastAnchorRoomId", "()Ljava/lang/Long;", "setLastAnchorRoomId", "(Ljava/lang/Long;)V", "Ljava/lang/Long;", "lastAnchorRoomStreamId", "getLastAnchorRoomStreamId", "setLastAnchorRoomStreamId", "livesdkshell_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class ShellSourceParams implements Serializable {

    @SerializedName("is_direct_go_end_page")
    private Boolean isDirectGoEndPage;

    @SerializedName("last_anchor_room_id")
    private Long lastAnchorRoomId;

    @SerializedName("last_anchor_room_stream_id")
    private Long lastAnchorRoomStreamId;

    public ShellSourceParams() {
        this.isDirectGoEndPage = Boolean.FALSE;
    }

    public final Long getLastAnchorRoomId() {
        return this.lastAnchorRoomId;
    }

    public final Long getLastAnchorRoomStreamId() {
        return this.lastAnchorRoomStreamId;
    }

    public final Boolean isDirectGoEndPage() {
        return this.isDirectGoEndPage;
    }

    public final void setDirectGoEndPage(Boolean r100) {
        this.isDirectGoEndPage = r100;
    }

    public final void setLastAnchorRoomId(Long r100) {
        this.lastAnchorRoomId = r100;
    }

    public final void setLastAnchorRoomStreamId(Long r100) {
        this.lastAnchorRoomStreamId = r100;
    }
}
