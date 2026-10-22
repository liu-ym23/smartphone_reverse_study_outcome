package com.bytedance.android.live.base.model.media;

import com.bytedance.android.ecom.arch.slice.slices.template.TemplateNodeType;
import com.google.gson.annotations.SerializedName;
import py.k;

/* JADX INFO: loaded from: classes45.dex */
public class VideoInfo {

    @SerializedName("cover")
    private k cover;

    @SerializedName(TemplateNodeType.RAW)
    private String raw;

    @SerializedName("type")
    private int type;

    public VideoInfo() {
    }
}
