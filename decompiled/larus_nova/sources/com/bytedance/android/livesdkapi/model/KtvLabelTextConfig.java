package com.bytedance.android.livesdkapi.model;

import com.bytedance.android.livesdkapi.LiveCommonConstants;
import com.google.gson.annotations.SerializedName;
import java.util.Map;

/* JADX INFO: loaded from: classes12.dex */
public class KtvLabelTextConfig {

    @SerializedName("ktv_component_lyric_text_second_line")
    public Map<Integer, KtvLyricText> ktvComponentLyricTextSecondLine;

    @SerializedName("ktv_component_score_lyric_count")
    public float ktvComponentScoreLyricCount;

    @SerializedName("ktv_feedback_tag")
    public String ktvFeedbackTag;

    @SerializedName("ktv_lyric_text")
    public Map<Integer, KtvLyricText> ktvLyricText;

    @SerializedName("ktv_midi_label_bg")
    public String[] ktvMidiLabelBackground;

    @SerializedName("ktv_stage_label_bg")
    public String[] ktvStageLabelBackground;

    @SerializedName("ktv_stage_label_icon")
    public String ktvStageLabelIcon;

    public String getKtvFeedbackTagUrl() {
        return "https://" + LiveCommonConstants.INSTANCE.getObjectTosPath() + "/obj/live-android/" + this.ktvFeedbackTag;
    }

    public String getKtvStageLabelIconUrl() {
        return "https://" + LiveCommonConstants.INSTANCE.getObjectTosPath() + "/obj/live-android/" + this.ktvStageLabelIcon;
    }

    public KtvLabelTextConfig() {
        this.ktvStageLabelIcon = "ktv_stage_mic_label_icon.png";
        this.ktvFeedbackTag = "ktv_feedback_tag.png";
        this.ktvStageLabelBackground = null;
        this.ktvMidiLabelBackground = null;
    }
}
