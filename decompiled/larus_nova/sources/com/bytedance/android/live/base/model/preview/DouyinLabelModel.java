package com.bytedance.android.live.base.model.preview;

import com.google.gson.annotations.SerializedName;
import com.lynx.jsbridge.LynxResourceModule;

/* JADX INFO: loaded from: classes45.dex */
public class DouyinLabelModel {

    @SerializedName("background_color")
    public String backgroundColor;

    @SerializedName("border_color")
    public String borderColor;

    @SerializedName("border_width")
    public int borderWidth;

    @SerializedName("corner_radius")
    public float cornerRadius;

    @SerializedName(LynxResourceModule.FONT_TYPE)
    public float font;

    @SerializedName("is_medium_weight")
    public boolean fontMediumWight;

    @SerializedName("height")
    public float height;

    @SerializedName("left_margin")
    public float leftMargin;

    public DouyinLabelModel() {
    }
}
