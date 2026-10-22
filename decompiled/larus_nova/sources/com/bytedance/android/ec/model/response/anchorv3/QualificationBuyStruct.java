package com.bytedance.android.ec.model.response.anchorv3;

import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes44.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0011\u0018\u00002\u00020\u00012\u00020\u0002B\u0005¢\u0006\u0002\u0010\u0003J\u000f\u0010\u0018\u001a\u0004\u0018\u00010\u0005H\u0016¢\u0006\u0002\u0010\u0007J\u000f\u0010\u0019\u001a\u0004\u0018\u00010\u0005H\u0016¢\u0006\u0002\u0010\u0007J\u000f\u0010\u001a\u001a\u0004\u0018\u00010\u0005H\u0016¢\u0006\u0002\u0010\u0007J\u000f\u0010\u001b\u001a\u0004\u0018\u00010\u0005H\u0016¢\u0006\u0002\u0010\u0007J\u000f\u0010\u001c\u001a\u0004\u0018\u00010\u0005H\u0016¢\u0006\u0002\u0010\u0007R\u001a\u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\b\u001a\u0004\b\u0006\u0010\u0007R\u001a\u0010\t\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\b\u001a\u0004\b\n\u0010\u0007R\u001a\u0010\u000b\u001a\u0004\u0018\u00010\f8\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u000f\u001a\u0004\b\r\u0010\u000eR\u001a\u0010\u0010\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\b\u001a\u0004\b\u0011\u0010\u0007R\u001a\u0010\u0012\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\b\u001a\u0004\b\u0013\u0010\u0007R\u001a\u0010\u0014\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\b\u001a\u0004\b\u0015\u0010\u0007R\u001a\u0010\u0016\u001a\u0004\u0018\u00010\f8\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u000f\u001a\u0004\b\u0017\u0010\u000e¨\u0006\u001d"}, d2 = {"Lcom/bytedance/android/ec/model/response/anchorv3/QualificationBuyStruct;", "Ljava/io/Serializable;", "Lcom/bytedance/android/ec/model/response/anchorv3/IPromotionActivityStruct;", "()V", "beginTime", "", "getBeginTime", "()Ljava/lang/Long;", "Ljava/lang/Long;", "campaignId", "getCampaignId", "campaignName", "", "getCampaignName", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "curTime", "getCurTime", "endTime", "getEndTime", "preBeginTime", "getPreBeginTime", "status", "getStatus", "getActivityBeginTime", "getActivityCurrentTime", "getActivityEndTime", "getActivityId", "getActivityPreBeginTime", "ec-model_release"}, k = 1, mv = {1, 4, 3})
public final class QualificationBuyStruct implements Serializable, IPromotionActivityStruct {

    @SerializedName("begin_time")
    private final Long beginTime;

    @SerializedName("campaign_id")
    private final Long campaignId;

    @SerializedName("campaign_type")
    private final Integer campaignName;

    @SerializedName("cur_time")
    private final Long curTime;

    @SerializedName("end_time")
    private final Long endTime;

    @SerializedName("pre_begin_time")
    private final Long preBeginTime;

    @SerializedName("status")
    private final Integer status;

    public QualificationBuyStruct() {
    }

    @Override // com.bytedance.android.ec.model.response.anchorv3.IPromotionActivityStruct
    public Long getActivityBeginTime() {
        return this.beginTime;
    }

    @Override // com.bytedance.android.ec.model.response.anchorv3.IPromotionActivityStruct
    public Long getActivityCurrentTime() {
        return this.curTime;
    }

    @Override // com.bytedance.android.ec.model.response.anchorv3.IPromotionActivityStruct
    public Long getActivityEndTime() {
        return this.endTime;
    }

    @Override // com.bytedance.android.ec.model.response.anchorv3.IPromotionActivityStruct
    public Long getActivityId() {
        return this.campaignId;
    }

    @Override // com.bytedance.android.ec.model.response.anchorv3.IPromotionActivityStruct
    public Long getActivityPreBeginTime() {
        return this.preBeginTime;
    }

    public final Long getBeginTime() {
        return this.beginTime;
    }

    public final Long getCampaignId() {
        return this.campaignId;
    }

    public final Integer getCampaignName() {
        return this.campaignName;
    }

    public final Long getCurTime() {
        return this.curTime;
    }

    public final Long getEndTime() {
        return this.endTime;
    }

    public final Long getPreBeginTime() {
        return this.preBeginTime;
    }

    public final Integer getStatus() {
        return this.status;
    }
}
