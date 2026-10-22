package com.bytedance.android.livesdkapi.model.com.bytedance.android.livesdk.config;

import com.google.gson.annotations.SerializedName;
import com.ss.android.downloadlib.constants.EventConstants;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes12.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u000f\n\u0002\u0010\b\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\u001d\u001a\u00020\u0004H\u0016R\u0018\u0010\u0003\u001a\u0004\u0018\u00010\u00048\u0006X\u0087D¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R\u0018\u0010\u0007\u001a\u0004\u0018\u00010\u00048\u0006X\u0087D¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0006R\u0016\u0010\t\u001a\u00020\n8\u0006X\u0087D¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0016\u0010\r\u001a\u00020\n8\u0006X\u0087D¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\fR\u0016\u0010\u000f\u001a\u00020\n8\u0006X\u0087D¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\fR\u0018\u0010\u0011\u001a\u0004\u0018\u00010\u00048\u0006X\u0087D¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0006R\u0018\u0010\u0013\u001a\u0004\u0018\u00010\u00048\u0006X\u0087D¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0006R\u0018\u0010\u0015\u001a\u0004\u0018\u00010\u00048\u0006X\u0087D¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0006R\u0018\u0010\u0017\u001a\u0004\u0018\u00010\u00048\u0006X\u0087D¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0006R\u0016\u0010\u0019\u001a\u00020\u001a8\u0006X\u0087D¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u001c¨\u0006\u001e"}, d2 = {"Lcom/bytedance/android/livesdkapi/model/com/bytedance/android/livesdk/config/GameSticker;", "", "()V", "alignMode", "", "getAlignMode", "()Ljava/lang/String;", "componentMode", "getComponentMode", "enable", "", "getEnable", "()Z", "enableLandscape", "getEnableLandscape", "enablePad", "getEnablePad", "gameId", "getGameId", "gameName", "getGameName", "logEvent", "getLogEvent", "sizeMode", "getSizeMode", "stickerType", "", "getStickerType", "()I", "toString", "infrastructure_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class GameSticker {

    @SerializedName("align_mode")
    private final String alignMode;

    @SerializedName("component_mode")
    private final String componentMode;

    @SerializedName("enable")
    private final boolean enable;

    @SerializedName("enable_landscape")
    private final boolean enableLandscape;

    @SerializedName("enable_pad")
    private final boolean enablePad;

    @SerializedName("game_id")
    private final String gameId;

    @SerializedName(EventConstants.ExtraJson.GAME_NAME)
    private final String gameName;

    @SerializedName("log_event")
    private final String logEvent;

    @SerializedName("size_mode")
    private final String sizeMode;

    @SerializedName("game_sticker_type")
    private final int stickerType;

    public String toString() {
        return "GameSticker(stickerType=" + this.stickerType + ", gameId=" + this.gameId + ", gameName=" + this.gameName + ", componentMode=" + this.componentMode + ", sizeMode=" + this.sizeMode + ", alignMode=" + this.alignMode + ", logEvent=" + this.logEvent + ", enable=" + this.enable + ", enableLandscape=" + this.enableLandscape + ", enablePad=" + this.enablePad + ')';
    }

    public GameSticker() {
        this.gameId = "";
        this.gameName = "";
        this.componentMode = "";
        this.sizeMode = "";
        this.alignMode = "";
        this.logEvent = "";
    }

    public final String getAlignMode() {
        return this.alignMode;
    }

    public final String getComponentMode() {
        return this.componentMode;
    }

    public final boolean getEnable() {
        return this.enable;
    }

    public final boolean getEnableLandscape() {
        return this.enableLandscape;
    }

    public final boolean getEnablePad() {
        return this.enablePad;
    }

    public final String getGameId() {
        return this.gameId;
    }

    public final String getGameName() {
        return this.gameName;
    }

    public final String getLogEvent() {
        return this.logEvent;
    }

    public final String getSizeMode() {
        return this.sizeMode;
    }

    public final int getStickerType() {
        return this.stickerType;
    }
}
