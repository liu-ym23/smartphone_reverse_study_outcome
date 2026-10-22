package com.bytedance.android.livesdkapi.model.com.bytedance.android.livesdk.config;

import com.google.gson.annotations.SerializedName;
import java.util.List;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes12.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\r\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R\u0016\u0010\u0003\u001a\u00020\u00048\u0006X\u0087D¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R\u001e\u0010\u0007\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\u0006\"\u0004\b\t\u0010\nR\u0016\u0010\u000b\u001a\u00020\u00048\u0006X\u0087D¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\u0006R\u0016\u0010\r\u001a\u00020\u00048\u0006X\u0087D¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u0006R\u0016\u0010\u000f\u001a\u00020\u00048\u0006X\u0087D¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0006R\u0016\u0010\u0011\u001a\u00020\u00128\u0006X\u0087D¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u001e\u0010\u0015\u001a\n\u0012\u0004\u0012\u00020\u0017\u0018\u00010\u00168\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0019¨\u0006\u001a"}, d2 = {"Lcom/bytedance/android/livesdkapi/model/com/bytedance/android/livesdk/config/GameStickerSetting;", "", "()V", "debugLog", "", "getDebugLog", "()Z", "enable", "getEnable", "setEnable", "(Z)V", "enableFold", "getEnableFold", "enablePad", "getEnablePad", "enablePk", "getEnablePk", "messageThreshold", "", "getMessageThreshold", "()I", "stickers", "", "Lcom/bytedance/android/livesdkapi/model/com/bytedance/android/livesdk/config/GameSticker;", "getStickers", "()Ljava/util/List;", "infrastructure_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class GameStickerSetting {

    @SerializedName("debug_log")
    private final boolean debugLog;

    @SerializedName("enable")
    private boolean enable;

    @SerializedName("enable_fold")
    private final boolean enableFold;

    @SerializedName("enable_pad")
    private final boolean enablePad;

    @SerializedName("enable_pk")
    private final boolean enablePk;

    @SerializedName("message_threshold")
    private final int messageThreshold;

    @SerializedName("stickers")
    private final List<GameSticker> stickers;

    public GameStickerSetting() {
        this.enable = true;
        this.enablePad = true;
    }

    public final boolean getDebugLog() {
        return this.debugLog;
    }

    public final boolean getEnable() {
        return this.enable;
    }

    public final boolean getEnableFold() {
        return this.enableFold;
    }

    public final boolean getEnablePad() {
        return this.enablePad;
    }

    public final boolean getEnablePk() {
        return this.enablePk;
    }

    public final int getMessageThreshold() {
        return this.messageThreshold;
    }

    public final List<GameSticker> getStickers() {
        return this.stickers;
    }

    public final void setEnable(boolean r100) {
        this.enable = r100;
    }
}
