package com.bytedance.android.shopping.dto;

import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import java.util.List;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes13.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\n\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R&\u0010\u0003\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR \u0010\n\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000e¨\u0006\u000f"}, d2 = {"Lcom/bytedance/android/shopping/dto/TouTiaoFullReductionInfo;", "Ljava/io/Serializable;", "()V", "fullReduction", "", "", "getFullReduction", "()Ljava/util/List;", "setFullReduction", "(Ljava/util/List;)V", "url", "getUrl", "()Ljava/lang/String;", "setUrl", "(Ljava/lang/String;)V", "ec-shopping-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class TouTiaoFullReductionInfo implements Serializable {

    @SerializedName("full_reduction")
    private List<String> fullReduction;

    @SerializedName("url")
    private String url;

    public TouTiaoFullReductionInfo() {
    }

    public final List<String> getFullReduction() {
        return this.fullReduction;
    }

    public final String getUrl() {
        return this.url;
    }

    public final void setFullReduction(List<String> r100) {
        this.fullReduction = r100;
    }

    public final void setUrl(String r100) {
        this.url = r100;
    }
}
