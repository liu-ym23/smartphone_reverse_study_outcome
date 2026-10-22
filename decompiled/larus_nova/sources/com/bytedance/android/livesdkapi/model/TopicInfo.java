package com.bytedance.android.livesdkapi.model;

import com.bytedance.android.ec.core.event.a;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import java.util.Map;

/* JADX INFO: loaded from: classes12.dex */
public class TopicInfo implements Serializable {
    private static final long serialVersionUID = 0;

    @SerializedName(a.KEY_COMMENT_NUM)
    public long commentNum;

    @SerializedName("extra")
    public Map<String, Object> extra;
    public boolean isSelected;

    @SerializedName("topic_id")
    public String topicID;

    @SerializedName("topic_name")
    public String topicName;

    @SerializedName("topic_type")
    public long topicType;

    @SerializedName("view_num")
    public long viewNum;

    public TopicInfo() {
    }
}
