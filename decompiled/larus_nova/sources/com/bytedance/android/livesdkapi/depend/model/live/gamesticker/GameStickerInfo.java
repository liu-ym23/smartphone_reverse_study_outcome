package com.bytedance.android.livesdkapi.depend.model.live.gamesticker;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes12.dex */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b$\u0018\u00002\u00020\u0001BM\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u000b\u0012\u0006\u0010\f\u001a\u00020\u000b\u0012\u0006\u0010\r\u001a\u00020\u000b\u0012\u0006\u0010\u000e\u001a\u00020\u000f\u0012\u0006\u0010\u0010\u001a\u00020\u000b¢\u0006\u0002\u0010\u0011J\u0006\u00105\u001a\u00020\u000bJ\b\u00106\u001a\u00020\u000bH\u0016R\u001a\u0010\u0012\u001a\u00020\u0013X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0014\"\u0004\b\u0015\u0010\u0016R\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001aR\u001a\u0010\n\u001a\u00020\u000bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001b\u0010\u001c\"\u0004\b\u001d\u0010\u001eR\u001a\u0010\f\u001a\u00020\u000bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001f\u0010\u001c\"\u0004\b \u0010\u001eR\u001a\u0010\u0010\u001a\u00020\u000bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b!\u0010\u001c\"\u0004\b\"\u0010\u001eR\u001a\u0010\u0006\u001a\u00020\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b#\u0010$\"\u0004\b%\u0010&R\u001a\u0010\u000e\u001a\u00020\u000fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b'\u0010(\"\u0004\b)\u0010*R\u001a\u0010\b\u001a\u00020\tX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b+\u0010,\"\u0004\b-\u0010.R\u001a\u0010\u0004\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b/\u00100\"\u0004\b1\u00102R\u001a\u0010\r\u001a\u00020\u000bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b3\u0010\u001c\"\u0004\b4\u0010\u001e¨\u00067"}, d2 = {"Lcom/bytedance/android/livesdkapi/depend/model/live/gamesticker/GameStickerInfo;", "", "source", "Lcom/bytedance/android/livesdkapi/depend/model/live/gamesticker/GameStickerSource;", "stickerType", "", "stickerOpr", "Lcom/bytedance/android/livesdkapi/depend/model/live/gamesticker/GameStickerOpr;", "stickerSize", "Lcom/bytedance/android/livesdkapi/depend/model/live/gamesticker/GameRoomStickerSize;", "stickerData", "", "stickerDigest", "stickerUrl", "stickerRecordId", "", "stickerGameId", "(Lcom/bytedance/android/livesdkapi/depend/model/live/gamesticker/GameStickerSource;ILcom/bytedance/android/livesdkapi/depend/model/live/gamesticker/GameStickerOpr;Lcom/bytedance/android/livesdkapi/depend/model/live/gamesticker/GameRoomStickerSize;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;JLjava/lang/String;)V", "isValid", "", "()Z", "setValid", "(Z)V", "getSource", "()Lcom/bytedance/android/livesdkapi/depend/model/live/gamesticker/GameStickerSource;", "setSource", "(Lcom/bytedance/android/livesdkapi/depend/model/live/gamesticker/GameStickerSource;)V", "getStickerData", "()Ljava/lang/String;", "setStickerData", "(Ljava/lang/String;)V", "getStickerDigest", "setStickerDigest", "getStickerGameId", "setStickerGameId", "getStickerOpr", "()Lcom/bytedance/android/livesdkapi/depend/model/live/gamesticker/GameStickerOpr;", "setStickerOpr", "(Lcom/bytedance/android/livesdkapi/depend/model/live/gamesticker/GameStickerOpr;)V", "getStickerRecordId", "()J", "setStickerRecordId", "(J)V", "getStickerSize", "()Lcom/bytedance/android/livesdkapi/depend/model/live/gamesticker/GameRoomStickerSize;", "setStickerSize", "(Lcom/bytedance/android/livesdkapi/depend/model/live/gamesticker/GameRoomStickerSize;)V", "getStickerType", "()I", "setStickerType", "(I)V", "getStickerUrl", "setStickerUrl", "toSimpleStr", "toString", "live-model-api_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class GameStickerInfo {
    private boolean isValid;
    private GameStickerSource source;
    private String stickerData;
    private String stickerDigest;
    private String stickerGameId;
    private GameStickerOpr stickerOpr;
    private long stickerRecordId;
    private GameRoomStickerSize stickerSize;
    private int stickerType;
    private String stickerUrl;

    public final String toSimpleStr() {
        return "GameStickerInfo(\nstickerType=" + this.stickerType + ", \nstickerOpr=" + this.stickerOpr + ", \nstickerRecordId='" + this.stickerRecordId + ", \nstickerGameId='" + this.stickerGameId + " \n')";
    }

    public String toString() {
        return "GameStickerInfo(source=" + this.source + ", stickerType=" + this.stickerType + ", stickerOpr=" + this.stickerOpr + ", stickerSize=" + this.stickerSize + ", stickerDigest='" + this.stickerDigest + ", stickerRecordId='" + this.stickerRecordId + "stickerGameId='" + this.stickerGameId + "')";
    }

    public final GameStickerSource getSource() {
        return this.source;
    }

    public final String getStickerData() {
        return this.stickerData;
    }

    public final String getStickerDigest() {
        return this.stickerDigest;
    }

    public final String getStickerGameId() {
        return this.stickerGameId;
    }

    public final GameStickerOpr getStickerOpr() {
        return this.stickerOpr;
    }

    public final long getStickerRecordId() {
        return this.stickerRecordId;
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

    public final boolean isValid() {
        return this.isValid;
    }

    public final void setSource(GameStickerSource r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.source = r100;
    }

    public final void setStickerData(String r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.stickerData = r100;
    }

    public final void setStickerDigest(String r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.stickerDigest = r100;
    }

    public final void setStickerGameId(String r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.stickerGameId = r100;
    }

    public final void setStickerOpr(GameStickerOpr r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.stickerOpr = r100;
    }

    public final void setStickerRecordId(long r100) {
        this.stickerRecordId = r100;
    }

    public final void setStickerSize(GameRoomStickerSize r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.stickerSize = r100;
    }

    public final void setStickerType(int r100) {
        this.stickerType = r100;
    }

    public final void setStickerUrl(String r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.stickerUrl = r100;
    }

    public final void setValid(boolean r100) {
        this.isValid = r100;
    }

    public GameStickerInfo(GameStickerSource r100, int r101, GameStickerOpr r102, GameRoomStickerSize r103, String r104, String r105, String r106, long r107, String r110) {
        Intrinsics.checkNotNullParameter(r100, "source");
        Intrinsics.checkNotNullParameter(r102, "stickerOpr");
        Intrinsics.checkNotNullParameter(r103, "stickerSize");
        Intrinsics.checkNotNullParameter(r104, "stickerData");
        Intrinsics.checkNotNullParameter(r105, "stickerDigest");
        Intrinsics.checkNotNullParameter(r106, "stickerUrl");
        Intrinsics.checkNotNullParameter(r110, "stickerGameId");
        this.source = r100;
        this.stickerType = r101;
        this.stickerOpr = r102;
        this.stickerSize = r103;
        this.stickerData = r104;
        this.stickerDigest = r105;
        this.stickerUrl = r106;
        this.stickerRecordId = r107;
        this.stickerGameId = r110;
        this.isValid = true;
    }
}
