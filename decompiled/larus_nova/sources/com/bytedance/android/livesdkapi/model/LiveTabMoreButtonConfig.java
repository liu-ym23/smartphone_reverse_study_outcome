package com.bytedance.android.livesdkapi.model;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes12.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R\u001e\u0010\u0003\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR \u0010\t\u001a\u0004\u0018\u00010\n8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000e¨\u0006\u000f"}, d2 = {"Lcom/bytedance/android/livesdkapi/model/LiveTabMoreButtonConfig;", "", "()V", "enable", "", "getEnable", "()Z", "setEnable", "(Z)V", "schema", "", "getSchema", "()Ljava/lang/String;", "setSchema", "(Ljava/lang/String;)V", "livebase-model_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class LiveTabMoreButtonConfig {

    @SerializedName("enable")
    private boolean enable;

    @SerializedName("schema")
    private String schema;

    public LiveTabMoreButtonConfig() {
        this.schema = "sslocal://webcast_redirect?entry=vs_play_schedule&scheme_query=enter_from_merge%3Denter_from_merge=homepage_xlive";
        this.enable = true;
    }

    public final boolean getEnable() {
        return this.enable;
    }

    public final String getSchema() {
        return this.schema;
    }

    public final void setEnable(boolean r100) {
        this.enable = r100;
    }

    public final void setSchema(String r100) {
        this.schema = r100;
    }
}
