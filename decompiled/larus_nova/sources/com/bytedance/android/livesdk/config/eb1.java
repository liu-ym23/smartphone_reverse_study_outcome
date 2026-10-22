package com.bytedance.android.livesdk.config;

import com.google.gson.annotations.SerializedName;

/* JADX INFO: loaded from: classes8.dex */
public class eb1 {

    @SerializedName("item_show")
    public boolean enableShow;

    @SerializedName("frequency")
    public int frequency;

    @SerializedName("url")
    public String schema;

    public eb1() {
        this.enableShow = true;
        this.schema = "";
        this.frequency = 3;
    }
}
