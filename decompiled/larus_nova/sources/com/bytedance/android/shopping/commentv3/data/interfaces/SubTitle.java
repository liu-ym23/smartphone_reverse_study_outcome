package com.bytedance.android.shopping.commentv3.data.interfaces;

import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes13.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u000b\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R \u0010\u0003\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR \u0010\t\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\bR \u0010\f\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u0006\"\u0004\b\u000e\u0010\b¨\u0006\u000f"}, d2 = {"Lcom/bytedance/android/shopping/commentv3/data/interfaces/SubTitle;", "Ljava/io/Serializable;", "()V", "icon", "", "getIcon", "()Ljava/lang/String;", "setIcon", "(Ljava/lang/String;)V", "schema", "getSchema", "setSchema", "text", "getText", "setText", "ec-shopping-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class SubTitle implements Serializable {

    @SerializedName("icon")
    private String icon;

    @SerializedName("schema")
    private String schema;

    @SerializedName("text")
    private String text;

    public SubTitle() {
    }

    public final String getIcon() {
        return this.icon;
    }

    public final String getSchema() {
        return this.schema;
    }

    public final String getText() {
        return this.text;
    }

    public final void setIcon(String r100) {
        this.icon = r100;
    }

    public final void setSchema(String r100) {
        this.schema = r100;
    }

    public final void setText(String r100) {
        this.text = r100;
    }
}
