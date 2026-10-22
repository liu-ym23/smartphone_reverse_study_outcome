package com.bytedance.android.live.base.model.preview;

import com.google.gson.annotations.SerializedName;

/* JADX INFO: loaded from: classes45.dex */
public class PreviewTagModel {

    @SerializedName("anchor_detail")
    public PreviewAnchorModel anchorModel;

    @SerializedName("bottom_margin")
    public float bottomMargin;

    @SerializedName("douyin_label")
    public DouyinLabelModel douyinLabelModel;

    @SerializedName("live_end")
    public PreviewEndModel endModel;

    @SerializedName("left_margin")
    public float leftMargin;

    @SerializedName("live_label_is_medium_weight")
    public boolean liveLabelIsMediumWeight;

    @SerializedName("room_guide")
    public RoomGuideModel roomGuideModel;

    public PreviewTagModel() {
    }
}
