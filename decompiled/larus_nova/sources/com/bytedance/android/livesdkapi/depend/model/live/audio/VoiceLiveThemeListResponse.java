package com.bytedance.android.livesdkapi.depend.model.live.audio;

import com.bytedance.tools.kcp.modelx.runtime.internal.decode.FlexModelJsonAdapter;
import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;
import java.util.List;

/* JADX INFO: loaded from: classes12.dex */
@JsonAdapter(FlexModelJsonAdapter.class)
public class VoiceLiveThemeListResponse {

    @SerializedName("animated_exts")
    public String[] animatedType;

    @SerializedName("image_exts")
    public String[] imageType;

    @SerializedName("pre_choice")
    public String lastThemeKey;

    @SerializedName("bg_list")
    public List<IVoiceLiveTheme> themeList;

    @SerializedName("ugc_available")
    public int ugcAvailable;

    public VoiceLiveThemeListResponse() {
    }

    public String toString() {
        return "VoiceLiveThemeListResponse{voiceLiveThemeList=" + this.themeList + ", ugcAvailable=" + this.ugcAvailable + ", lastThemeKey='" + this.lastThemeKey + "'}";
    }
}
