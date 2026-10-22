package com.bytedance.android.livesdk.interactivity.api.barrage.model;

import com.google.gson.annotations.SerializedName;
import java.io.Serializable;

/* JADX INFO: loaded from: classes9.dex */
public class BarrageSetting implements Serializable {
    public static final int DEFAULT_ALPHA = 75;

    @SerializedName("alpha")
    private float alpha;

    @SerializedName("barrage_area")
    private int barrageArea;

    @SerializedName("font_size")
    private int fontSize;

    @SerializedName("is_carnival_barrage_open")
    private boolean isCarnivalBarrageOpen;

    @SerializedName("is_chat_channel_open")
    private boolean isChatChannelOpen;

    @SerializedName("is_gift_open")
    private boolean isGiftOpen;

    @SerializedName("is_lottery_open")
    private boolean isLotteryOpen;

    @SerializedName("is_need_roll_back")
    private boolean isNeedRollback;

    public static BarrageSetting getDefaultVSLiveSetting() {
        BarrageSetting r100 = new BarrageSetting();
        r100.setFontSize(BarrageSettingFont.MID);
        r100.setBarrageArea(BarrageSettingArea.TOP);
        r100.setAlpha(75.0f);
        r100.setGiftOpen(true);
        r100.setChatChannelOpen(true);
        return r100;
    }

    public BarrageSettingArea getBarrageArea() {
        BarrageSettingArea.a r100 = BarrageSettingArea.Companion;
        int r101 = this.barrageArea;
        r100.getClass();
        if (r101 == 0) goto L15;
        if (r101 == 1) goto L19;
        if (r101 == 2) goto L18;
        if (r101 == 3) goto L17;
        return BarrageSettingArea.HALF;
    L17:
        return BarrageSettingArea.FULL;
    L18:
        return BarrageSettingArea.HALF;
    L19:
        return BarrageSettingArea.TOP;
    L15:
        return BarrageSettingArea.CLOSE;
    }

    public BarrageSettingFont getFontSize() {
        BarrageSettingFont.a r100 = BarrageSettingFont.Companion;
        int r101 = this.fontSize;
        r100.getClass();
        switch(r101) {
            case -1: goto L15;
            case 0: goto L25;
            case 1: goto L24;
            case 2: goto L23;
            case 3: goto L22;
            case 4: goto L21;
            case 5: goto L20;
            case 6: goto L19;
            case 7: goto L18;
            case 8: goto L17;
            default: goto L16;
        };
    L16:
        return BarrageSettingFont.MID;
    L17:
        return BarrageSettingFont.PORTRAIT;
    L18:
        return BarrageSettingFont.VS_PORTRAIT_LARGE;
    L19:
        return BarrageSettingFont.VS_PORTRAIT_BIG;
    L20:
        return BarrageSettingFont.VS_PORTRAIT_MID;
    L21:
        return BarrageSettingFont.VS_PORTRAIT_SMALL;
    L22:
        return BarrageSettingFont.VS_PORTRAIT;
    L23:
        return BarrageSettingFont.SMALL;
    L24:
        return BarrageSettingFont.MID;
    L25:
        return BarrageSettingFont.BIG;
    L15:
        return BarrageSettingFont.LARGE;
    }

    public BarrageSetting() {
        this.barrageArea = BarrageSettingArea.HALF.getArea();
        this.fontSize = BarrageSettingFont.MID.getFont();
        this.alpha = 75.0f;
        this.isGiftOpen = true;
        this.isLotteryOpen = true;
        this.isChatChannelOpen = true;
        this.isNeedRollback = false;
        this.isCarnivalBarrageOpen = true;
    }

    public float getAlpha() {
        return this.alpha;
    }

    public boolean isCarnivalBarrageOpen() {
        return this.isCarnivalBarrageOpen;
    }

    public boolean isChatChannelOpen() {
        return this.isChatChannelOpen;
    }

    public boolean isGiftOpen() {
        return this.isGiftOpen;
    }

    public boolean isLotteryOpen() {
        return this.isLotteryOpen;
    }

    public boolean isNeedRollback() {
        return this.isNeedRollback;
    }

    public BarrageSetting(boolean r100) {
        this.barrageArea = BarrageSettingArea.HALF.getArea();
        this.fontSize = BarrageSettingFont.MID.getFont();
        this.alpha = 75.0f;
        this.isGiftOpen = true;
        this.isLotteryOpen = true;
        this.isChatChannelOpen = true;
        this.isNeedRollback = false;
        this.isCarnivalBarrageOpen = true;
        if (r100 == false) goto L6;
        this.barrageArea = BarrageSettingArea.TOP.getArea();
        return;
    }

    public void setAlpha(float r100) {
        this.alpha = r100;
    }

    public void setBarrageArea(BarrageSettingArea r100) {
        this.barrageArea = r100.getArea();
    }

    public void setCarnivalBarrageOpen(boolean r100) {
        this.isCarnivalBarrageOpen = r100;
    }

    public void setChatChannelOpen(boolean r100) {
        this.isChatChannelOpen = r100;
    }

    public void setFontSize(BarrageSettingFont r100) {
        this.fontSize = r100.getFont();
    }

    public void setGiftOpen(boolean r100) {
        this.isGiftOpen = r100;
    }

    public void setLotteryOpen(boolean r100) {
        this.isLotteryOpen = r100;
    }

    public void setNeedRollback(boolean r100) {
        this.isNeedRollback = r100;
    }
}
