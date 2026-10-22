package com.bytedance.android.shopping.store.home.entity;

import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes14.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010$\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R \u0010\u0003\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR,\u0010\t\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0004\u0018\u00010\n8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR&\u0010\u000f\u001a\n\u0012\u0004\u0012\u00020\u0011\u0018\u00010\u00108\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015¨\u0006\u0016"}, d2 = {"Lcom/bytedance/android/shopping/store/home/entity/Blcok;", "Ljava/io/Serializable;", "()V", "blockCode", "", "getBlockCode", "()Ljava/lang/String;", "setBlockCode", "(Ljava/lang/String;)V", "globalData", "", "getGlobalData", "()Ljava/util/Map;", "setGlobalData", "(Ljava/util/Map;)V", "moduleList", "", "Lcom/bytedance/android/shopping/store/home/entity/Module;", "getModuleList", "()Ljava/util/List;", "setModuleList", "(Ljava/util/List;)V", "ec-biz-store-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class Blcok implements Serializable {

    @SerializedName("block_code")
    private String blockCode;

    @SerializedName("global_data")
    private Map<String, String> globalData;

    @SerializedName("module_list")
    private List<Module> moduleList;

    public Blcok() {
        this.blockCode = "";
    }

    public final String getBlockCode() {
        return this.blockCode;
    }

    public final Map<String, String> getGlobalData() {
        return this.globalData;
    }

    public final List<Module> getModuleList() {
        return this.moduleList;
    }

    public final void setBlockCode(String r100) {
        this.blockCode = r100;
    }

    public final void setGlobalData(Map<String, String> r100) {
        this.globalData = r100;
    }

    public final void setModuleList(List<Module> r100) {
        this.moduleList = r100;
    }
}
