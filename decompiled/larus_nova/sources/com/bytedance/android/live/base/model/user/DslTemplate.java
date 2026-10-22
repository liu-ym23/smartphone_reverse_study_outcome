package com.bytedance.android.live.base.model.user;

import com.bytedance.ee.bear.thumbnail.ThumbGlideUrl;
import com.google.gson.annotations.SerializedName;

/* JADX INFO: loaded from: classes45.dex */
public class DslTemplate {

    @SerializedName("data")
    public String data;

    @SerializedName(ThumbGlideUrl.SOURCE_TEMPLATE)
    public String template;

    @SerializedName("template_hash")
    public String template_hash;

    public DslTemplate() {
    }
}
