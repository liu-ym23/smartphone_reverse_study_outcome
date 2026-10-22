package com.bytedance.android.livehostapi.business.depend.share;

import com.google.gson.annotations.SerializedName;
import java.util.List;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes7.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0010 \n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u000b\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R \u0010\u0003\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR \u0010\t\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\bR&\u0010\f\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\r8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\u001e\u0010\u0012\u001a\u00020\u00138\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R \u0010\u0018\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u0006\"\u0004\b\u001a\u0010\bR \u0010\u001b\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\u0006\"\u0004\b\u001d\u0010\b¨\u0006\u001e"}, d2 = {"Lcom/bytedance/android/livehostapi/business/depend/share/CommandShareParams;", "", "()V", "extraParams", "", "getExtraParams", "()Ljava/lang/String;", "setExtraParams", "(Ljava/lang/String;)V", "objectId", "getObjectId", "setObjectId", "objectNames", "", "getObjectNames", "()Ljava/util/List;", "setObjectNames", "(Ljava/util/List;)V", "schemaType", "", "getSchemaType", "()I", "setSchemaType", "(I)V", "shareScene", "getShareScene", "setShareScene", "shareUrl", "getShareUrl", "setShareUrl", "hostapp-middleware_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class CommandShareParams {

    @SerializedName("extra_params")
    private String extraParams;

    @SerializedName("object_id")
    private String objectId;

    @SerializedName("object_names")
    private List<String> objectNames;

    @SerializedName("schema_type")
    private int schemaType;

    @SerializedName("share_scene")
    private String shareScene;

    @SerializedName("share_url")
    private String shareUrl;

    public CommandShareParams() {
        this.schemaType = 11;
    }

    public final String getExtraParams() {
        return this.extraParams;
    }

    public final String getObjectId() {
        return this.objectId;
    }

    public final List<String> getObjectNames() {
        return this.objectNames;
    }

    public final int getSchemaType() {
        return this.schemaType;
    }

    public final String getShareScene() {
        return this.shareScene;
    }

    public final String getShareUrl() {
        return this.shareUrl;
    }

    public final void setExtraParams(String r100) {
        this.extraParams = r100;
    }

    public final void setObjectId(String r100) {
        this.objectId = r100;
    }

    public final void setObjectNames(List<String> r100) {
        this.objectNames = r100;
    }

    public final void setSchemaType(int r100) {
        this.schemaType = r100;
    }

    public final void setShareScene(String r100) {
        this.shareScene = r100;
    }

    public final void setShareUrl(String r100) {
        this.shareUrl = r100;
    }
}
