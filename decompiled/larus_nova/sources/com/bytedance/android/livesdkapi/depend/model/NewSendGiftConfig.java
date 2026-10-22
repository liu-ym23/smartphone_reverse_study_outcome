package com.bytedance.android.livesdkapi.depend.model;

import com.google.gson.annotations.SerializedName;

/* JADX INFO: loaded from: classes12.dex */
public class NewSendGiftConfig {

    @SerializedName("new_fast_gift_confirm_dialog")
    public String newFastGiftConfirmDialog;

    @SerializedName("new_gift_guide_gesture")
    public String newGiftGuideGesture;

    @SerializedName("new_gift_guide_landscape")
    public String newGiftGuideLandscape;

    @SerializedName("new_gift_guide_v1")
    public String newGiftGuideV1;

    @SerializedName("new_gift_guide_v2")
    public String newGiftGuideV2;

    @SerializedName("new_gift_guide_v3")
    public String newGiftGuideV3;

    public NewSendGiftConfig() {
        this.newFastGiftConfirmDialog = "https://lf3-webcastcdn-tos.douyinstatic.com/obj/live-android/ttlive_fast_gift_confirm_dialog_bg.png";
        this.newGiftGuideV1 = "https://lf3-webcastcdn-tos.douyinstatic.com/obj/live-android/ttlive_new_gift_guide_bg_v1.png";
        this.newGiftGuideV2 = "https://lf3-webcastcdn-tos.douyinstatic.com/obj/live-android/ttlive_new_gift_guide_bg_v2_new.png";
        this.newGiftGuideV3 = "https://lf3-webcastcdn-tos.douyinstatic.com/obj/live-android/ttlive_new_gift_guide_bg_v3.png";
        this.newGiftGuideLandscape = "https://lf3-webcastcdn-tos.douyinstatic.com/obj/live-android/ttlive_new_gift_guide_bg_landscape.png";
        this.newGiftGuideGesture = "https://lf3-webcastcdn-tos.douyinstatic.com/obj/live-android/new_gift_guide_v1_gesture.webp";
    }
}
