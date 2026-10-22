package com.bytedance.android.livesdk.chatroom.ssposter.model;

import com.bytedance.sdk.account.platform.base.OnekeyLoginConstants;
import com.google.gson.annotations.SerializedName;
import java.util.List;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes7.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0007\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R&\u0010\u0003\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR&\u0010\n\u001a\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\u0007\"\u0004\b\r\u0010\tR&\u0010\u000e\u001a\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0007\"\u0004\b\u0010\u0010\tR&\u0010\u0011\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0007\"\u0004\b\u0013\u0010\tR \u0010\u0014\u001a\u0004\u0018\u00010\u00158\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019¨\u0006\u001a"}, d2 = {"Lcom/bytedance/android/livesdk/chatroom/ssposter/model/TicketGenerateResponse;", "", "()V", "musicIdList", "", "", "getMusicIdList", "()Ljava/util/List;", "setMusicIdList", "(Ljava/util/List;)V", "musicIdStrList", "", "getMusicIdStrList", "setMusicIdStrList", "seqStr", "getSeqStr", "setSeqStr", "ticketIdList", "getTicketIdList", "setTicketIdList", "ticketInfo", "Lcom/bytedance/android/livesdk/chatroom/ssposter/model/TicketInfo;", "getTicketInfo", "()Lcom/bytedance/android/livesdk/chatroom/ssposter/model/TicketInfo;", "setTicketInfo", "(Lcom/bytedance/android/livesdk/chatroom/ssposter/model/TicketInfo;)V", "hostapp-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class TicketGenerateResponse {

    @SerializedName("music_id_list")
    private List<Long> musicIdList;

    @SerializedName("music_id_list_str")
    private List<String> musicIdStrList;

    @SerializedName("seq_str")
    private List<String> seqStr;

    @SerializedName(OnekeyLoginConstants.CU_KEY_SEQ)
    private List<Long> ticketIdList;

    @SerializedName("ticket")
    private TicketInfo ticketInfo;

    public TicketGenerateResponse() {
    }

    public final List<Long> getMusicIdList() {
        return this.musicIdList;
    }

    public final List<String> getMusicIdStrList() {
        return this.musicIdStrList;
    }

    public final List<String> getSeqStr() {
        return this.seqStr;
    }

    public final List<Long> getTicketIdList() {
        return this.ticketIdList;
    }

    public final TicketInfo getTicketInfo() {
        return this.ticketInfo;
    }

    public final void setMusicIdList(List<Long> r100) {
        this.musicIdList = r100;
    }

    public final void setMusicIdStrList(List<String> r100) {
        this.musicIdStrList = r100;
    }

    public final void setSeqStr(List<String> r100) {
        this.seqStr = r100;
    }

    public final void setTicketIdList(List<Long> r100) {
        this.ticketIdList = r100;
    }

    public final void setTicketInfo(TicketInfo r100) {
        this.ticketInfo = r100;
    }
}
