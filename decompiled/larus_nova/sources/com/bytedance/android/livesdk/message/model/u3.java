package com.bytedance.android.livesdk.message.model;

import com.bytedance.android.live.base.model.user.User;
import com.bytedance.android.livesdkapi.message.Text;
import com.google.gson.annotations.SerializedName;
import java.util.List;

/* JADX INFO: loaded from: classes11.dex */
public class u3 {

    @SerializedName("content")
    private String content;

    @SerializedName("display_text")
    public Text displayText;

    @SerializedName("content_list")
    public qg highlightInfo;

    @SerializedName("highlighted")
    private List<jk> highlighteds;

    @SerializedName("room_id")
    private long roomId;

    @SerializedName("schema_webcast")
    private String schema;

    @SerializedName("user")
    private User user;

    public u3() {
    }
}
