package com.bytedance.android.live.base.model.preview;

import com.bytedance.android.live.base.model.ImageModel;
import com.google.gson.annotations.SerializedName;
import com.lynx.jsbridge.LynxResourceModule;

/* JADX INFO: loaded from: classes45.dex */
public class RoomGuideModel {

    @SerializedName("background_color")
    public String backgroundColor;

    @SerializedName("border_color")
    public String borderColor;

    @SerializedName("border_width")
    public float borderWidth;

    @SerializedName("button_margin")
    public float buttonMargin;

    @SerializedName("corner_radius")
    public float cornerRadius;

    @SerializedName(LynxResourceModule.FONT_TYPE)
    public float font;

    @SerializedName("height")
    public float height;

    @SerializedName("icon_image")
    public ImageModel icon;

    @SerializedName("icon_margin")
    public float iconMargin;

    @SerializedName("right_margin")
    public float rightMargin;

    @SerializedName("separator_margin")
    public float separatorMargin;

    public RoomGuideModel() {
    }
}
