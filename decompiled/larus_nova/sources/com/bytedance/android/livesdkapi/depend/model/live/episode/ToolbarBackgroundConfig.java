package com.bytedance.android.livesdkapi.depend.model.live.episode;

import com.google.gson.annotations.SerializedName;
import py.k;

/* JADX INFO: loaded from: classes12.dex */
public class ToolbarBackgroundConfig {

    @SerializedName("image")
    public k background;

    @SerializedName("color")
    public String color;

    @SerializedName("switch")
    public long needSwitch;

    public static class BACKGROUND_TYPE {
        public static final long BACKGROUND_COLOR_BY_SERVER = 2;
        public static final long BACKGROUND_IMAGE_BY_SERVER = 3;
        public static final long GENERATE_COLOR = 1;

        public BACKGROUND_TYPE() {
        }
    }

    public ToolbarBackgroundConfig() {
    }
}
