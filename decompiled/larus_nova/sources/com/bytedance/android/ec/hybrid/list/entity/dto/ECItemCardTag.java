package com.bytedance.android.ec.hybrid.list.entity.dto;

import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes44.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\u0010\u000e\n\u0002\b\u0010\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R \u0010\u0003\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u00048\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\b\u001a\u0004\b\u0006\u0010\u0007R \u0010\t\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u00048\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\b\u001a\u0004\b\n\u0010\u0007R \u0010\u000b\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u00048\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\b\u001a\u0004\b\f\u0010\u0007R \u0010\r\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u00048\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\b\u001a\u0004\b\u000e\u0010\u0007R \u0010\u000f\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u00048\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\b\u001a\u0004\b\u0010\u0010\u0007R \u0010\u0011\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u00048\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\b\u001a\u0004\b\u0012\u0010\u0007R \u0010\u0013\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u00048\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\b\u001a\u0004\b\u0014\u0010\u0007¨\u0006\u0015"}, d2 = {"Lcom/bytedance/android/ec/hybrid/list/entity/dto/ECItemCardTag;", "Ljava/io/Serializable;", "()V", "leafCategory", "", "", "getLeafCategory", "()[Ljava/lang/String;", "[Ljava/lang/String;", "picSimId", "getPicSimId", "pid", "getPid", "predictCategory", "getPredictCategory", "rid", "getRid", "spuSimId", "getSpuSimId", "vcTagClusterId", "getVcTagClusterId", "ec-hybrid_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class ECItemCardTag implements Serializable {

    @SerializedName("leaf_categories")
    private final String[] leafCategory;

    @SerializedName("pic_sim_ids")
    private final String[] picSimId;

    @SerializedName("pids")
    private final String[] pid;

    @SerializedName("predict_categories")
    private final String[] predictCategory;

    @SerializedName("rid")
    private final String[] rid;

    @SerializedName("spu_sim_ids")
    private final String[] spuSimId;

    @SerializedName("vctg_cluster_ids")
    private final String[] vcTagClusterId;

    public ECItemCardTag() {
    }

    public final String[] getLeafCategory() {
        return this.leafCategory;
    }

    public final String[] getPicSimId() {
        return this.picSimId;
    }

    public final String[] getPid() {
        return this.pid;
    }

    public final String[] getPredictCategory() {
        return this.predictCategory;
    }

    public final String[] getRid() {
        return this.rid;
    }

    public final String[] getSpuSimId() {
        return this.spuSimId;
    }

    public final String[] getVcTagClusterId() {
        return this.vcTagClusterId;
    }
}
