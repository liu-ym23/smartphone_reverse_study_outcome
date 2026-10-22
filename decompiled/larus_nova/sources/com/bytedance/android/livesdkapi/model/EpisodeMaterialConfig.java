package com.bytedance.android.livesdkapi.model;

import com.google.gson.annotations.SerializedName;
import java.io.Serializable;

/* JADX INFO: loaded from: classes12.dex */
public class EpisodeMaterialConfig implements Serializable {
    private static final long serialVersionUID = 0;

    @SerializedName("discussion_background")
    public String discussionBackground;

    @SerializedName("square_background")
    public String squareBackground;

    @SerializedName("topic_background")
    public String topicBackground;

    public EpisodeMaterialConfig() {
    }
}
