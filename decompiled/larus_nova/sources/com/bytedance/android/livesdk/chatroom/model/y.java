package com.bytedance.android.livesdk.chatroom.model;

import com.amap.api.col.s.ce;
import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes7.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0015\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b#\u0010$R\"\u0010\u0003\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR$\u0010\n\u001a\u0004\u0018\u00010\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR$\u0010\u0011\u001a\u0004\u0018\u00010\u00108\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R$\u0010\u0017\u001a\u0004\u0018\u00010\u00108\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0017\u0010\u0012\u001a\u0004\b\u0018\u0010\u0014\"\u0004\b\u0019\u0010\u0016R$\u0010\u001a\u001a\u0004\u0018\u00010\u00108\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u001a\u0010\u0012\u001a\u0004\b\u001b\u0010\u0014\"\u0004\b\u001c\u0010\u0016R$\u0010\u001d\u001a\u0004\u0018\u00010\u00108\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u001d\u0010\u0012\u001a\u0004\b\u001e\u0010\u0014\"\u0004\b\u001f\u0010\u0016R$\u0010 \u001a\u0004\u0018\u00010\u00108\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b \u0010\u0012\u001a\u0004\b!\u0010\u0014\"\u0004\b\"\u0010\u0016¨\u0006%"}, d2 = {"Lcom/bytedance/android/livesdk/chatroom/model/y;", "", "", "stickerType", "I", "f", "()I", "setStickerType", "(I)V", "Lcom/bytedance/android/livesdk/chatroom/model/s0;", "stickerSize", "Lcom/bytedance/android/livesdk/chatroom/model/s0;", "e", "()Lcom/bytedance/android/livesdk/chatroom/model/s0;", "setStickerSize", "(Lcom/bytedance/android/livesdk/chatroom/model/s0;)V", "", "stickerData", "Ljava/lang/String;", "c", "()Ljava/lang/String;", "setStickerData", "(Ljava/lang/String;)V", "stickerDigest", "d", "setStickerDigest", "stickerUrl", ce.f26391f, "setStickerUrl", "recordId", "b", "setRecordId", "gameId", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "setGameId", "<init>", "()V", "livebase-model_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class y {

    @SerializedName("game_id")
    private String gameId;

    @SerializedName("record_id")
    private String recordId;

    @SerializedName("sticker_data")
    private String stickerData;

    @SerializedName("sticker_data_digest")
    private String stickerDigest;

    @SerializedName("sticker_size")
    private s0 stickerSize;

    @SerializedName("sticker_type")
    private int stickerType;

    @SerializedName("sticker_url")
    private String stickerUrl;

    public y() {
        this.stickerData = "";
        this.stickerDigest = "";
        this.stickerUrl = "";
        this.recordId = "";
        this.gameId = "";
    }

    public final String a() {
        return this.gameId;
    }

    public final String b() {
        return this.recordId;
    }

    public final String c() {
        return this.stickerData;
    }

    public final String d() {
        return this.stickerDigest;
    }

    public final s0 e() {
        return this.stickerSize;
    }

    public final int f() {
        return this.stickerType;
    }

    public final String g() {
        return this.stickerUrl;
    }
}
