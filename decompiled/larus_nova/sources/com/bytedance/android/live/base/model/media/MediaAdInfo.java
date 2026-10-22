package com.bytedance.android.live.base.model.media;

import com.google.gson.annotations.SerializedName;

/* JADX INFO: loaded from: classes45.dex */
public class MediaAdInfo {

    @SerializedName(com.bytedance.android.ec.core.event.a.KEY_SCHEMA_URL)
    private String schemaUrl;

    @SerializedName("title")
    private String title;

    public MediaAdInfo() {
    }

    public String getSchemaUrl() {
        return this.schemaUrl;
    }

    public String getTitle() {
        return this.title;
    }

    public void setSchemaUrl(String r100) {
        this.schemaUrl = r100;
    }

    public void setTitle(String r100) {
        this.title = r100;
    }
}
