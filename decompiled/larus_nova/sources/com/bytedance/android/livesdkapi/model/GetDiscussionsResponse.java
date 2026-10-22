package com.bytedance.android.livesdkapi.model;

import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes12.dex */
public class GetDiscussionsResponse implements Serializable {
    private static final long serialVersionUID = 0;

    @SerializedName("display_topic_id")
    public String displayTopicID;

    @SerializedName("extra_info")
    public Map<String, Object> extraInfo;

    @SerializedName("topic_list")
    public List<TopicInfo> topicList;

    public GetDiscussionsResponse() {
    }
}
