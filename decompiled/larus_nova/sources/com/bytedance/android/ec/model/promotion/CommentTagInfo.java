package com.bytedance.android.ec.model.promotion;

import com.alipay.sdk.m.x.d;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes44.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u000b\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R \u0010\u0003\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR \u0010\t\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\bR \u0010\f\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u0006\"\u0004\b\u000e\u0010\b¨\u0006\u000f"}, d2 = {"Lcom/bytedance/android/ec/model/promotion/CommentTagInfo;", "Ljava/io/Serializable;", "()V", "content", "", "getContent", "()Ljava/lang/String;", "setContent", "(Ljava/lang/String;)V", "schema", "getSchema", "setSchema", "title", "getTitle", d.f25925o, "ec-model_release"}, k = 1, mv = {1, 4, 3})
public final class CommentTagInfo implements Serializable {

    @SerializedName("content")
    private String content;

    @SerializedName("schema")
    private String schema;

    @SerializedName("title")
    private String title;

    public CommentTagInfo() {
        this.title = "";
        this.content = "";
        this.schema = "";
    }

    public final String getContent() {
        return this.content;
    }

    public final String getSchema() {
        return this.schema;
    }

    public final String getTitle() {
        return this.title;
    }

    public final void setContent(String r100) {
        this.content = r100;
    }

    public final void setSchema(String r100) {
        this.schema = r100;
    }

    public final void setTitle(String r100) {
        this.title = r100;
    }
}
