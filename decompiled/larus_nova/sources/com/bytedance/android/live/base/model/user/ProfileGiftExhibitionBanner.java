package com.bytedance.android.live.base.model.user;

import com.google.gson.annotations.SerializedName;
import java.util.List;

/* JADX INFO: loaded from: classes45.dex */
public class ProfileGiftExhibitionBanner {

    @SerializedName("achieved_gifts")
    public List<py.k> achievedGifts;

    @SerializedName("achieved_icon")
    public py.k achievedIcon;

    @SerializedName("grade_level")
    public int gradeLevel;

    @SerializedName("jump_schema")
    public String jumpSchema;

    @SerializedName("level_up_animation")
    public py.k levelUpAnimation;

    @SerializedName("light_sweep_animation")
    public py.k lightSweepAnimation;

    @SerializedName("lighted_count")
    public int lightedCount;

    @SerializedName("text")
    public String text;

    @SerializedName(com.bytedance.android.ec.core.event.a.KEY_TOTAL_COUNT)
    public int totalCount;

    @SerializedName("ui_config")
    public ProfileGiftExhibitionBannerUIConfig uiConfig;

    @SerializedName("universe_info")
    public ProfileGiftExhibitionBannerUniverseInfo universeInfo;

    public ProfileGiftExhibitionBanner() {
    }

    public boolean isGroupAnchor() {
        ProfileGiftExhibitionBannerUniverseInfo r100 = this.universeInfo;
        if (r100 != null) goto L5;
        return false;
    L5:
        return r100.getValid();
    }
}
