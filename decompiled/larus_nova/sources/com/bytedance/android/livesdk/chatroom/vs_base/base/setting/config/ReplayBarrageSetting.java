package com.bytedance.android.livesdk.chatroom.vs_base.base.setting.config;

import com.google.gson.annotations.SerializedName;
import java.io.Serializable;

/* JADX INFO: loaded from: classes8.dex */
public class ReplayBarrageSetting implements Serializable {
    public static final int DEFAULT_ALPHA = 75;

    @SerializedName("alpha")
    private float alpha;

    @SerializedName("barrage_area")
    private float barrageArea;

    @SerializedName("font_size")
    private int fontSize;

    @SerializedName("is_need_roll_back")
    private boolean isNeedRollback;

    @SerializedName("speed")
    private float speed;

    public static ReplayBarrageSetting getDefaultPortraitStyleSetting() {
        ReplayBarrageSetting r100 = new ReplayBarrageSetting();
        r100.setFontSize(ReplayBarrageSettingFont.VS_PORTRAIT_MID);
        r100.setBarrageArea(0.45f);
        r100.setAlpha(75.0f);
        return r100;
    }

    public static ReplayBarrageSetting getDefaultStyleSetting() {
        ReplayBarrageSetting r100 = new ReplayBarrageSetting();
        r100.setFontSize(ReplayBarrageSettingFont.MID);
        r100.setBarrageArea(0.45f);
        r100.setAlpha(75.0f);
        return r100;
    }

    public ReplayBarrageSettingFont getFontSize() {
        ReplayBarrageSettingFont.a r100 = ReplayBarrageSettingFont.Companion;
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
        return ReplayBarrageSettingFont.MID;
    L17:
        return ReplayBarrageSettingFont.PORTRAIT;
    L18:
        return ReplayBarrageSettingFont.VS_PORTRAIT_LARGE;
    L19:
        return ReplayBarrageSettingFont.VS_PORTRAIT_BIG;
    L20:
        return ReplayBarrageSettingFont.VS_PORTRAIT_MID;
    L21:
        return ReplayBarrageSettingFont.VS_PORTRAIT_SMALL;
    L22:
        return ReplayBarrageSettingFont.VS_PORTRAIT;
    L23:
        return ReplayBarrageSettingFont.SMALL;
    L24:
        return ReplayBarrageSettingFont.MID;
    L25:
        return ReplayBarrageSettingFont.BIG;
    L15:
        return ReplayBarrageSettingFont.LARGE;
    }

    public ReplayBarrageSettingSpeed getSpeed() {
        ReplayBarrageSettingSpeed.a r100 = ReplayBarrageSettingSpeed.Companion;
        float r101 = this.speed;
        r100.getClass();
        ReplayBarrageSettingSpeed[] r102 = ReplayBarrageSettingSpeed.values();
        int r103 = r102.length;
        int r104 = 0;
    L3:
        if (r104 >= r103) goto L11;
        ReplayBarrageSettingSpeed r105 = r102[r104];
        if (r105.getFactor() != r101) goto L7;
        boolean r106 = true;
    L8:
        if (r106 == true) goto L12;
        r104 = r104 + 1;
    L12:
        if (r105 == null) goto L14;
        return r105;
    L14:
        return ReplayBarrageSettingSpeed.NORMAL;
    L7:
        r106 = false;
        goto L8
    L11:
        r105 = null;
        goto L12
    }

    public ReplayBarrageSetting() {
        this.barrageArea = 0.45f;
        this.fontSize = ReplayBarrageSettingFont.MID.getFont();
        this.alpha = 100.0f;
        this.speed = 1.0f;
        this.isNeedRollback = false;
    }

    public float getAlpha() {
        return this.alpha;
    }

    public float getBarrageArea() {
        return this.barrageArea;
    }

    public void setAlpha(float r100) {
        this.alpha = r100;
    }

    public void setBarrageArea(float r100) {
        this.barrageArea = r100;
    }

    public void setFontSize(ReplayBarrageSettingFont r100) {
        this.fontSize = r100.getFont();
    }

    public void setSpeed(ReplayBarrageSettingSpeed r100) {
        this.speed = r100.getFactor();
    }
}
