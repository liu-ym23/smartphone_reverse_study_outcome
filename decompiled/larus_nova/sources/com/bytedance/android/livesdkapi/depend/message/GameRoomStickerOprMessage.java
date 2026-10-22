package com.bytedance.android.livesdkapi.depend.message;

import am3.g;
import com.bytedance.android.live.base.annotation.ForMain;
import com.bytedance.android.livesdk.message.model.p0;
import com.bytedance.android.livesdkapi.depend.model.live.gamesticker.GameRoomStickerSize;
import com.bytedance.android.livesdkapi.message._CommonMessageData_ProtoDecoder;
import com.google.gson.annotations.SerializedName;
import com.ss.ugc.live.sdk.message.stream.IStreamMessage;
import kotlin.Metadata;
import vh7.h;

/* JADX INFO: loaded from: classes12.dex */
@ForMain
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0015\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b*\u0010+J\b\u0010\u0003\u001a\u00020\u0002H\u0016J\b\u0010\u0005\u001a\u00020\u0004H\u0016R\"\u0010\u0007\u001a\u00020\u00068\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0007\u0010\b\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR\"\u0010\r\u001a\u00020\u00068\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\r\u0010\b\u001a\u0004\b\u000e\u0010\n\"\u0004\b\u000f\u0010\fR$\u0010\u0011\u001a\u0004\u0018\u00010\u00108\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R$\u0010\u0018\u001a\u0004\u0018\u00010\u00178\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0018\u0010\u0019\u001a\u0004\b\u001a\u0010\u001b\"\u0004\b\u001c\u0010\u001dR$\u0010\u001e\u001a\u0004\u0018\u00010\u00178\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u001e\u0010\u0019\u001a\u0004\b\u001f\u0010\u001b\"\u0004\b \u0010\u001dR$\u0010!\u001a\u0004\u0018\u00010\u00178\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b!\u0010\u0019\u001a\u0004\b\"\u0010\u001b\"\u0004\b#\u0010\u001dR$\u0010$\u001a\u0004\u0018\u00010\u00178\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b$\u0010\u0019\u001a\u0004\b%\u0010\u001b\"\u0004\b&\u0010\u001dR$\u0010'\u001a\u0004\u0018\u00010\u00178\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b'\u0010\u0019\u001a\u0004\b(\u0010\u001b\"\u0004\b)\u0010\u001d¨\u0006,"}, d2 = {"Lcom/bytedance/android/livesdkapi/depend/message/GameRoomStickerOprMessage;", "Lcom/bytedance/android/livesdk/message/model/p0;", "", "isStreamMessage", "Lcom/ss/ugc/live/sdk/message/stream/IStreamMessage$DelayMode;", "getDelayMode", "", "oprType", "I", "getOprType", "()I", "setOprType", "(I)V", "stickerType", "getStickerType", "setStickerType", "Lcom/bytedance/android/livesdkapi/depend/model/live/gamesticker/GameRoomStickerSize;", "stickerSize", "Lcom/bytedance/android/livesdkapi/depend/model/live/gamesticker/GameRoomStickerSize;", "getStickerSize", "()Lcom/bytedance/android/livesdkapi/depend/model/live/gamesticker/GameRoomStickerSize;", "setStickerSize", "(Lcom/bytedance/android/livesdkapi/depend/model/live/gamesticker/GameRoomStickerSize;)V", "", "stickerData", "Ljava/lang/String;", "getStickerData", "()Ljava/lang/String;", "setStickerData", "(Ljava/lang/String;)V", "stickerDigest", "getStickerDigest", "setStickerDigest", "stickerUrl", "getStickerUrl", "setStickerUrl", "recordId", "getRecordId", "setRecordId", "gameId", "getGameId", "setGameId", "<init>", "()V", "livebase-model_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class GameRoomStickerOprMessage extends p0 implements h {

    @SerializedName("game_id")
    protected String gameId;

    @SerializedName("opr_type")
    protected int oprType;

    @SerializedName("record_id")
    protected String recordId;

    @SerializedName("data")
    protected String stickerData;

    @SerializedName("data_digest")
    protected String stickerDigest;

    @SerializedName("sticker_size")
    protected GameRoomStickerSize stickerSize;

    @SerializedName("sticker_type")
    protected int stickerType;

    @SerializedName("sticker_url")
    protected String stickerUrl;

    @Override // com.ss.ugc.live.sdk.message.stream.IStreamMessage
    public boolean isStreamMessage() {
        return true;
    }

    public GameRoomStickerOprMessage() {
        this.stickerData = "";
        this.stickerDigest = "";
        this.stickerUrl = "";
        this.recordId = "";
        this.gameId = "";
        this.type = MessageType.GAME_ROOM_STICKER_OPR_MESSAGE;
    }

    @Override // com.ss.ugc.live.sdk.message.stream.IStreamMessage
    public IStreamMessage.DelayMode getDelayMode() {
        return IStreamMessage.DelayMode.DEFAULT;
    }

    public final String getGameId() {
        return this.gameId;
    }

    public final int getOprType() {
        return this.oprType;
    }

    public final String getRecordId() {
        return this.recordId;
    }

    public final String getStickerData() {
        return this.stickerData;
    }

    public final String getStickerDigest() {
        return this.stickerDigest;
    }

    public final GameRoomStickerSize getStickerSize() {
        return this.stickerSize;
    }

    public final int getStickerType() {
        return this.stickerType;
    }

    public final String getStickerUrl() {
        return this.stickerUrl;
    }

    public GameRoomStickerOprMessage(g r100) {
        long r101 = r100.c();
    L3:
        int r102 = r100.f();
        if (r102 == (-1)) goto L16;
        switch(r102) {
            case 1: goto L15;
            case 2: goto L14;
            case 3: goto L13;
            case 4: goto L12;
            case 5: goto L11;
            case 6: goto L10;
            case 7: goto L9;
            case 8: goto L8;
            case 9: goto L6;
            case 10: goto L7;
            default: goto L6;
        };
    L7:
        this.gameId = am3.h.c(r100);
        goto L3
    L8:
        this.recordId = am3.h.c(r100);
        goto L3
    L9:
        this.stickerUrl = am3.h.c(r100);
        goto L3
    L10:
        this.stickerDigest = am3.h.c(r100);
        goto L3
    L11:
        this.stickerData = am3.h.c(r100);
        goto L3
    L12:
        this.stickerSize = new GameRoomStickerSize(r100);
        goto L3
    L13:
        this.stickerType = r100.i();
        goto L3
    L14:
        this.oprType = r100.i();
        goto L3
    L15:
        this.baseMessage = _CommonMessageData_ProtoDecoder.decodeStatic(r100);
        goto L3
    L6:
        am3.h.e(r100);
        goto L3
    L16:
        r100.d(r101);
        if (this.stickerData != null) goto L20;
        this.stickerData = "";
    L20:
        if (this.stickerDigest != null) goto L23;
        this.stickerDigest = "";
    L23:
        if (this.stickerUrl != null) goto L26;
        this.stickerUrl = "";
    L26:
        if (this.recordId != null) goto L29;
        this.recordId = "";
    L29:
        if (this.gameId != null) goto L31;
        this.gameId = "";
    L31:
        this.type = MessageType.GAME_ROOM_STICKER_OPR_MESSAGE;
    }

    public final void setGameId(String r100) {
        this.gameId = r100;
    }

    public final void setOprType(int r100) {
        this.oprType = r100;
    }

    public final void setRecordId(String r100) {
        this.recordId = r100;
    }

    public final void setStickerData(String r100) {
        this.stickerData = r100;
    }

    public final void setStickerDigest(String r100) {
        this.stickerDigest = r100;
    }

    public final void setStickerSize(GameRoomStickerSize r100) {
        this.stickerSize = r100;
    }

    public final void setStickerType(int r100) {
        this.stickerType = r100;
    }

    public final void setStickerUrl(String r100) {
        this.stickerUrl = r100;
    }
}
