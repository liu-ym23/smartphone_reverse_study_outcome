package com.bytedance.android.ec.hybrid.data.entity;

import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import java.util.List;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes44.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\u0006\b\u0007\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R \u0010\u0003\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR&\u0010\t\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\n8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\"\u0010\u000f\u001a\u0004\u0018\u00010\u00108\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0002\u0010\u0015\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014¨\u0006\u0016"}, d2 = {"Lcom/bytedance/android/ec/hybrid/data/entity/RequireClientVersionItem;", "Ljava/io/Serializable;", "()V", "api", "", "getApi", "()Ljava/lang/String;", "setApi", "(Ljava/lang/String;)V", "group", "", "getGroup", "()Ljava/util/List;", "setGroup", "(Ljava/util/List;)V", "minVersion", "", "getMinVersion", "()Ljava/lang/Long;", "setMinVersion", "(Ljava/lang/Long;)V", "Ljava/lang/Long;", "ec-hybrid_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class RequireClientVersionItem implements Serializable {

    @SerializedName("api")
    private String api;

    @SerializedName("group")
    private List<String> group;

    @SerializedName("min_version")
    private Long minVersion;

    public RequireClientVersionItem() {
    }

    public final String getApi() {
        return this.api;
    }

    public final List<String> getGroup() {
        return this.group;
    }

    public final Long getMinVersion() {
        return this.minVersion;
    }

    public final void setApi(String r100) {
        this.api = r100;
    }

    public final void setGroup(List<String> r100) {
        this.group = r100;
    }

    public final void setMinVersion(Long r100) {
        this.minVersion = r100;
    }
}
