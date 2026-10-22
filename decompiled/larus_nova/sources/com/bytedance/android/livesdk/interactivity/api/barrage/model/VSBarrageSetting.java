package com.bytedance.android.livesdk.interactivity.api.barrage.model;

import com.google.gson.annotations.SerializedName;
import java.io.Serializable;

/* JADX INFO: loaded from: classes9.dex */
public class VSBarrageSetting implements Serializable {
    public static final int DEFAULT_ALPHA = 75;

    @SerializedName("alpha")
    private float alpha;

    @SerializedName("barrage_area")
    private float barrageArea;

    @SerializedName("font_size")
    private int fontSize;

    @SerializedName("is_ai_danmaku_enable")
    private boolean isAIDanmakuEnable;

    @SerializedName("is_character_danmaku_enable")
    private boolean isCharacterDanmakuEnable;

    @SerializedName("is_color_danmaku_enable")
    private boolean isColorDanmakuEnable;

    @SerializedName("is_gif_danmaku_enable")
    private boolean isGifDanmakuEnable;

    @SerializedName("is_gift_open")
    private boolean isGiftOpen;

    @SerializedName("is_mask_enable")
    private boolean isMaskEnable;

    @SerializedName("is_need_roll_back")
    private boolean isNeedRollback;

    @SerializedName("speed")
    private float speed;

    public static VSBarrageSetting getDefaultStyleSetting() {
        VSBarrageSetting r100 = new VSBarrageSetting();
        r100.setFontSize(BarrageSettingFont.MID);
        r100.setBarrageArea(0.45f);
        r100.setAlpha(75.0f);
        r100.setGiftOpen(true);
        r100.setAIDanmakuEnable(true);
        r100.setColorDanmakuEnable(true);
        r100.setCharacterDanmakuEnable(true);
        r100.setGifDanmakuEnable(true);
        return r100;
    }

    public VSBarrageSetting() {
        this.barrageArea = 0.45f;
        this.fontSize = BarrageSettingFont.MID.getFont();
        this.alpha = 100.0f;
        this.speed = 1.0f;
        this.isGiftOpen = true;
        this.isNeedRollback = false;
        this.isMaskEnable = true;
        this.isAIDanmakuEnable = true;
        this.isColorDanmakuEnable = true;
        this.isCharacterDanmakuEnable = true;
        this.isGifDanmakuEnable = true;
    }

    public boolean isGiftOpen() {
        return this.isGiftOpen;
    }

    public boolean isMaskEnable() {
        return this.isMaskEnable;
    }

    public void setAIDanmakuEnable(boolean r100) {
        this.isAIDanmakuEnable = r100;
    }

    public void setAlpha(float r100) {
        this.alpha = r100;
    }

    public void setBarrageArea(float r100) {
        this.barrageArea = r100;
    }

    public void setCharacterDanmakuEnable(boolean r100) {
        this.isCharacterDanmakuEnable = r100;
    }

    public void setColorDanmakuEnable(boolean r100) {
        this.isColorDanmakuEnable = r100;
    }

    public void setFontSize(BarrageSettingFont r100) {
        this.fontSize = r100.getFont();
    }

    public void setGifDanmakuEnable(boolean r100) {
        this.isGifDanmakuEnable = r100;
    }

    public void setGiftOpen(boolean r100) {
        this.isGiftOpen = r100;
    }

    public void setMaskEnable(boolean r100) {
        this.isMaskEnable = r100;
    }
}
