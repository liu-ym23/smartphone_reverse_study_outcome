package com.bytedance.android.livesdk.jsbridge.methods.dto;

import com.google.gson.annotations.SerializedName;
import com.ss.android.ugc.aweme.discover.model.ScoreTags;
import com.ss.ttvideoengine.model.BarrageMaskInfo;
import java.io.Serializable;
import java.util.List;

/* JADX INFO: loaded from: classes9.dex */
public class Anchor implements Serializable {

    @SerializedName("anchor_content")
    public String content;

    @SerializedName("anchor_icon")
    public Icon icon;

    /* JADX INFO: renamed from: id, reason: collision with root package name */
    @SerializedName("anchor_id")
    public String f142113id;

    @SerializedName("source")
    public int source;

    @SerializedName("anchor_tag")
    public String tag;

    @SerializedName("anchor_title")
    public String title;

    @SerializedName("anchor_business_type")
    public int type;

    public static class Icon implements Serializable {

        @SerializedName(BarrageMaskInfo.KEY_MASK_FILE_HASH)
        private String fileHash;

        @SerializedName("height")
        private int height;

        @SerializedName("data_size")
        private long size;

        @SerializedName("uri")
        protected String uri;

        @SerializedName("url_key")
        private String urlKey;

        @SerializedName(ScoreTags.STAR_URL_LIST)
        protected List<String> urls;

        @SerializedName("width")
        private int width;

        public Icon() {
        }
    }

    public Anchor() {
    }
}
