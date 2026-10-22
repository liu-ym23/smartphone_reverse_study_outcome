package com.bytedance.android.livesdk.message.model;

import com.bytedance.android.livesdkapi.depend.message.MessageType;
import com.bytedance.android.livesdkapi.depend.message.RoomSongInfo;
import com.bytedance.android.livesdkapi.message._CommonMessageData_ProtoDecoder;
import com.bytedance.android.tools.pbadapter.annotation.ProtoMessage;
import com.google.gson.annotations.SerializedName;
import com.hihonor.honorid.core.data.UserInfo;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes11.dex */
@ProtoMessage("webcast.im.LinkmicRoomSongMessage")
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\t\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\n\b\u0007\u0018\u0000 \u001a2\u00020\u0001:\u0001\u001bB\u0007¢\u0006\u0004\b\u0018\u0010\u0019J\u0006\u0010\u0003\u001a\u00020\u0002R$\u0010\u0005\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0005\u0010\u0006\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR$\u0010\f\u001a\u0004\u0018\u00010\u000b8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R$\u0010\u0013\u001a\u0004\u0018\u00010\u00128\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0013\u0010\u0015\"\u0004\b\u0016\u0010\u0017¨\u0006\u001c"}, d2 = {"Lcom/bytedance/android/livesdk/message/model/LinkmicRoomSongMessage;", "Lcom/bytedance/android/livesdk/message/model/o0;", "", "isMvPlayingTranslate", "Lcom/bytedance/android/livesdkapi/depend/message/RoomSongInfo;", "roomSongInfo", "Lcom/bytedance/android/livesdkapi/depend/message/RoomSongInfo;", "getRoomSongInfo", "()Lcom/bytedance/android/livesdkapi/depend/message/RoomSongInfo;", "setRoomSongInfo", "(Lcom/bytedance/android/livesdkapi/depend/message/RoomSongInfo;)V", "", UserInfo.UPDATE_TIME, "Ljava/lang/Long;", "getUpdateTime", "()Ljava/lang/Long;", "setUpdateTime", "(Ljava/lang/Long;)V", "", "isMvPlaying", "Ljava/lang/Integer;", "()Ljava/lang/Integer;", "setMvPlaying", "(Ljava/lang/Integer;)V", "<init>", "()V", "Companion", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "live-business-message-api_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class LinkmicRoomSongMessage extends o0 implements vh7.h {
    public static final a Companion = null;
    public static final int IS_PLAYING_VALUE = 1;
    public static final String SYNC_KEY = "RoomSongSubSyncKey";

    @SerializedName("is_mv_playing")
    protected Integer isMvPlaying;

    @SerializedName("room_song_info")
    protected RoomSongInfo roomSongInfo;

    @SerializedName("update_time")
    protected Long updateTime;

    public static final class a {
        public a() {
        }
    }

    static {
        Companion = new a();
    }

    public final boolean isMvPlayingTranslate() {
        Integer r100 = this.isMvPlaying;
        if (r100 != null) goto L6;
    L10:
        return false;
    L6:
        if (r100.intValue() != 1) goto L10;
        if (this.roomSongInfo == null) goto L10;
        return true;
    }

    public LinkmicRoomSongMessage() {
        this.isMvPlaying = 0;
        this.type = MessageType.LINKMIC_ROOM_SONG_MESSAGE;
    }

    public final RoomSongInfo getRoomSongInfo() {
        return this.roomSongInfo;
    }

    public final Long getUpdateTime() {
        return this.updateTime;
    }

    public final Integer isMvPlaying() {
        return this.isMvPlaying;
    }

    public LinkmicRoomSongMessage(am3.g r100) {
        long r101 = r100.c();
    L3:
        int r102 = r100.f();
        if (r102 == (-1)) goto L18;
        if (r102 != 1) goto L8;
        this.baseMessage = _CommonMessageData_ProtoDecoder.decodeStatic(r100);
        goto L3
    L8:
        if (r102 != 2) goto L10;
        this.roomSongInfo = new RoomSongInfo(r100);
        goto L3
    L10:
        if (r102 != 3) goto L12;
        this.updateTime = Long.valueOf(r100.j());
        goto L3
    L12:
        if (r102 != 4) goto L13;
        this.isMvPlaying = Integer.valueOf((int) r100.j());
        goto L3
    L13:
        am3.h.e(r100);
        goto L3
    L18:
        r100.d(r101);
        if (this.isMvPlaying != null) goto L21;
        this.isMvPlaying = 0;
    L21:
        this.type = MessageType.LINKMIC_ROOM_SONG_MESSAGE;
    }

    public final void setMvPlaying(Integer r100) {
        this.isMvPlaying = r100;
    }

    public final void setRoomSongInfo(RoomSongInfo r100) {
        this.roomSongInfo = r100;
    }

    public final void setUpdateTime(Long r100) {
        this.updateTime = r100;
    }
}
