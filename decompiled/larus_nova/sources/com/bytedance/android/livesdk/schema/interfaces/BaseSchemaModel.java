package com.bytedance.android.livesdk.schema.interfaces;

import android.net.Uri;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes11.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\b'\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\u000f\u001a\u00020\u0004H&J\b\u0010\u0010\u001a\u00020\u0004H\u0016R \u0010\u0003\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001c\u0010\t\u001a\u0004\u0018\u00010\nX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000e¨\u0006\u0011"}, d2 = {"Lcom/bytedance/android/livesdk/schema/interfaces/BaseSchemaModel;", "", "()V", "schema", "", "getSchema", "()Ljava/lang/String;", "setSchema", "(Ljava/lang/String;)V", "uri", "Landroid/net/Uri;", "getUri", "()Landroid/net/Uri;", "setUri", "(Landroid/net/Uri;)V", "getSchemaHost", "subSchemaHost", "livehybrid-middleware-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public abstract class BaseSchemaModel {

    @SerializedName("schema")
    private String schema;
    private Uri uri;

    public BaseSchemaModel() {
    }

    public abstract String getSchemaHost();

    public String subSchemaHost() {
        return "";
    }

    public final String getSchema() {
        return this.schema;
    }

    public final Uri getUri() {
        return this.uri;
    }

    public final void setSchema(String r100) {
        this.schema = r100;
    }

    public final void setUri(Uri r100) {
        this.uri = r100;
    }
}
