package com.bytedance.android.ec.model;

import com.bytedance.android.shopping.searchsimilar.model.SimilarProductParam;
import com.google.gson.annotations.SerializedName;
import com.ss.android.ugc.route_monitor.impl.route_out.control.bean.RuleConditionBean;
import java.io.Serializable;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes44.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\n\n\u0002\u0010\u000e\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R\u001a\u0010\u0003\u001a\u0004\u0018\u00010\u00048\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u0007\u001a\u0004\b\u0005\u0010\u0006R\u001a\u0010\b\u001a\u0004\u0018\u00010\u00048\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u0007\u001a\u0004\b\t\u0010\u0006R\"\u0010\n\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0002\u0010\u0007\u001a\u0004\b\u000b\u0010\u0006\"\u0004\b\f\u0010\rR\u0018\u0010\u000e\u001a\u0004\u0018\u00010\u000f8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011¨\u0006\u0012"}, d2 = {"Lcom/bytedance/android/ec/model/InnerFlowAdData;", "Ljava/io/Serializable;", "()V", "adId", "", "getAdId", "()Ljava/lang/Long;", "Ljava/lang/Long;", "awemeId", "getAwemeId", "creativeId", "getCreativeId", "setCreativeId", "(Ljava/lang/Long;)V", RuleConditionBean.OPEN_URL_KEY, "", "getOpenUrl", "()Ljava/lang/String;", "ec-model_release"}, k = 1, mv = {1, 4, 3})
public final class InnerFlowAdData implements Serializable {

    @SerializedName("ad_id")
    private final Long adId;

    @SerializedName(SimilarProductParam.AWEME_ID)
    private final Long awemeId;

    @SerializedName("creative_id")
    private Long creativeId;

    @SerializedName("open_url")
    private final String openUrl;

    public InnerFlowAdData() {
    }

    public final Long getAdId() {
        return this.adId;
    }

    public final Long getAwemeId() {
        return this.awemeId;
    }

    public final Long getCreativeId() {
        return this.creativeId;
    }

    public final String getOpenUrl() {
        return this.openUrl;
    }

    public final void setCreativeId(Long r100) {
        this.creativeId = r100;
    }
}
