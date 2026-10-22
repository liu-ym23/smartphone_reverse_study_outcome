package com.bytedance.android.live.broadcast.model;

import com.bytedance.android.ec.core.event.a;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes45.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0007\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R \u0010\u0003\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\b¨\u0006\t"}, d2 = {"Lcom/bytedance/android/live/broadcast/model/SchemaInfo;", "", "()V", "schemaUrl", "", "getSchemaUrl", "()Ljava/lang/String;", "setSchemaUrl", "(Ljava/lang/String;)V", "live-model-api_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class SchemaInfo {

    @SerializedName(a.KEY_SCHEMA_URL)
    private String schemaUrl;

    public SchemaInfo() {
    }

    public final String getSchemaUrl() {
        return this.schemaUrl;
    }

    public final void setSchemaUrl(String r100) {
        this.schemaUrl = r100;
    }
}
