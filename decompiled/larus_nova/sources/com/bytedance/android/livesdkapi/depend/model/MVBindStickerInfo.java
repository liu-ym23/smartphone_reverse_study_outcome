package com.bytedance.android.livesdkapi.depend.model;

import com.google.gson.annotations.SerializedName;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes12.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R\u001e\u0010\u0003\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001c\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u000b0\n8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\r¨\u0006\u000e"}, d2 = {"Lcom/bytedance/android/livesdkapi/depend/model/MVBindStickerInfo;", "", "()V", "resourceID", "", "getResourceID", "()Ljava/lang/String;", "setResourceID", "(Ljava/lang/String;)V", "tagConfigs", "", "Lcom/bytedance/android/livesdkapi/depend/model/MVTagConfig;", "getTagConfigs", "()Ljava/util/List;", "liveeffect-middleware-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class MVBindStickerInfo {

    @SerializedName("resource_id")
    private String resourceID;

    @SerializedName("composer_param")
    private final List<MVTagConfig> tagConfigs;

    public MVBindStickerInfo() {
        this.resourceID = "";
        this.tagConfigs = CollectionsKt.emptyList();
    }

    public final String getResourceID() {
        return this.resourceID;
    }

    public final List<MVTagConfig> getTagConfigs() {
        return this.tagConfigs;
    }

    public final void setResourceID(String r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.resourceID = r100;
    }
}
