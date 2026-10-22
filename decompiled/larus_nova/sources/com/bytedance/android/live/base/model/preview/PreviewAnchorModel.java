package com.bytedance.android.live.base.model.preview;

import com.google.gson.annotations.SerializedName;

/* JADX INFO: loaded from: classes45.dex */
public class PreviewAnchorModel {

    @SerializedName("name_label_bottom_margin")
    public float bottomMargin;

    @SerializedName("name_label_font")
    public float nameLabelFont;

    @SerializedName("should_hide_avatar")
    public boolean shouldHideAvatar;

    @SerializedName("title_color")
    public String titleColor;

    @SerializedName("title_font")
    public float titleFont;

    @SerializedName("title_single_line")
    public boolean titleSingleLine;

    @SerializedName("name_label_top_margin")
    public float topMargin;

    public PreviewAnchorModel() {
    }
}
