package com.bytedance.android.livesdkapi.model;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes12.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u000b\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R \u0010\u0003\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR \u0010\t\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\bR \u0010\f\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u0006\"\u0004\b\u000e\u0010\b¨\u0006\u000f"}, d2 = {"Lcom/bytedance/android/livesdkapi/model/Rank;", "", "()V", "fullSchema", "", "getFullSchema", "()Ljava/lang/String;", "setFullSchema", "(Ljava/lang/String;)V", "schema", "getSchema", "setSchema", "url", "getUrl", "setUrl", "live-model-api_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class Rank {

    @SerializedName("full")
    private String fullSchema;

    @SerializedName("schema")
    private String schema;

    @SerializedName("url")
    private String url;

    public Rank() {
        this.schema = "sslocal://webcast_lynxview?type=popup&business_type=themedcompetition&gravity=bottom&height=484&url=";
        this.url = "https://lf-webcast-gr-sourcecdn.bytegecko.com/obj/byte-gurd-source-gr/webcast/mono/lynx/social_themed_competition_lynx_douyin/pages/rank_list/template.js";
        this.fullSchema = "sslocal://webcast_lynxview?type=popup&business_type=themedcompetition&gravity=bottom&height=484&url=https%3A%2F%2Flf-webcast-gr-sourcecdn.bytegecko.com%2Fobj%2Fbyte-gurd-source-gr%2Fwebcast%2Fmono%2Flynx%2Fsocial_themed_competition_lynx_douyin%2Fpages%2Frank_list%2Ftemplate.js";
    }

    public final String getFullSchema() {
        return this.fullSchema;
    }

    public final String getSchema() {
        return this.schema;
    }

    public final String getUrl() {
        return this.url;
    }

    public final void setFullSchema(String r100) {
        this.fullSchema = r100;
    }

    public final void setSchema(String r100) {
        this.schema = r100;
    }

    public final void setUrl(String r100) {
        this.url = r100;
    }
}
