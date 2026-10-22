package com.bytedance.android.livesdk.announce;

import com.google.gson.annotations.SerializedName;

/* JADX INFO: loaded from: classes7.dex */
public class e {

    @SerializedName("biz_type")
    public int biztype;

    @SerializedName("style")
    public int style;

    @SerializedName("text")
    public String text;

    @SerializedName("url")
    public String url;

    public e() {
        this.text = "";
        this.style = 0;
        this.url = "";
        this.biztype = 0;
    }
}
