package com.bytedance.android.live.core.resources;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import java.util.HashMap;
import java.util.List;

/* JADX INFO: loaded from: classes45.dex */
public class g {

    @SerializedName("audio_graph")
    public a audioGraph;

    @SerializedName("gift_duration")
    public long duration;

    @SerializedName("befViewFitMode")
    public int fitMode;

    @SerializedName("befViewRenderFPS")
    public int fps;

    @SerializedName("gift_type")
    public String giftType;

    @SerializedName("model_names")
    public String modelNames;

    @Expose(deserialize = false, serialize = false)
    private HashMap<String, List<String>> modelNamesEntity;

    @SerializedName("need_screen_shot")
    public boolean needScreenShot;

    @SerializedName("requirements")
    public List<String> requirements;

    @SerializedName("should_multi_frame")
    public boolean shouldMultiFrame;

    @SerializedName("befViewRenderSize")
    public b size;

    @SerializedName("view_overlay")
    public String viewOverlay;

    public static class a {

        @SerializedName("dB_value")
        public float dbValue;

        @SerializedName("gain")
        public float gain;

        @SerializedName("sources")
        public List<String> sources;

        @SerializedName("use_output")
        public boolean useOutput;

        public a() {
        }
    }

    public static class b {

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        @SerializedName("h")
        public int f65197h;

        /* JADX INFO: renamed from: w, reason: collision with root package name */
        @SerializedName("w")
        public int f65198w;

        public b() {
        }
    }

    public g() {
        this.modelNamesEntity = null;
    }
}
