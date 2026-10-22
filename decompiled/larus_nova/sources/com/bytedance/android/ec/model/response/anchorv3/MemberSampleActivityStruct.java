package com.bytedance.android.ec.model.response.anchorv3;

import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes44.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\f\n\u0002\u0010\u000e\n\u0002\b\n\u0018\u00002\u00020\u00012\u00020\u0002B\u0005¢\u0006\u0002\u0010\u0003J\u000f\u0010\u0017\u001a\u0004\u0018\u00010\u0005H\u0016¢\u0006\u0002\u0010\u0007J\u000f\u0010\u0018\u001a\u0004\u0018\u00010\u0005H\u0016¢\u0006\u0002\u0010\u0007J\u000f\u0010\u0019\u001a\u0004\u0018\u00010\u0005H\u0016¢\u0006\u0002\u0010\u0007J\u000f\u0010\u001a\u001a\u0004\u0018\u00010\u0005H\u0016¢\u0006\u0002\u0010\u0007J\u000f\u0010\u001b\u001a\u0004\u0018\u00010\u0005H\u0016¢\u0006\u0002\u0010\u0007R\u001a\u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\b\u001a\u0004\b\u0006\u0010\u0007R\u001a\u0010\t\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\b\u001a\u0004\b\n\u0010\u0007R\u001a\u0010\u000b\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\b\u001a\u0004\b\f\u0010\u0007R\u001a\u0010\r\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\b\u001a\u0004\b\u000e\u0010\u0007R\u001a\u0010\u000f\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\b\u001a\u0004\b\u0010\u0010\u0007R\u0018\u0010\u0011\u001a\u0004\u0018\u00010\u00128\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u001a\u0010\u0015\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\b\u001a\u0004\b\u0016\u0010\u0007¨\u0006\u001c"}, d2 = {"Lcom/bytedance/android/ec/model/response/anchorv3/MemberSampleActivityStruct;", "Ljava/io/Serializable;", "Lcom/bytedance/android/ec/model/response/anchorv3/IPromotionActivityStruct;", "()V", "beginTime", "", "getBeginTime", "()Ljava/lang/Long;", "Ljava/lang/Long;", "currentTime", "getCurrentTime", "endTime", "getEndTime", "id", "getId", "preBeginTime", "getPreBeginTime", "reason", "", "getReason", "()Ljava/lang/String;", "reasonType", "getReasonType", "getActivityBeginTime", "getActivityCurrentTime", "getActivityEndTime", "getActivityId", "getActivityPreBeginTime", "ec-model_release"}, k = 1, mv = {1, 4, 3})
public final class MemberSampleActivityStruct implements Serializable, IPromotionActivityStruct {

    @SerializedName("begin_time")
    private final Long beginTime;

    @SerializedName("current_time")
    private final Long currentTime;

    @SerializedName("end_time")
    private final Long endTime;

    /* JADX INFO: renamed from: id, reason: collision with root package name */
    @SerializedName("id")
    private final Long f47933id;

    @SerializedName("pre_begin_time")
    private final Long preBeginTime;

    @SerializedName("reason")
    private final String reason;

    @SerializedName("reason_type")
    private final Long reasonType;

    public MemberSampleActivityStruct() {
    }

    @Override // com.bytedance.android.ec.model.response.anchorv3.IPromotionActivityStruct
    public Long getActivityBeginTime() {
        return this.beginTime;
    }

    @Override // com.bytedance.android.ec.model.response.anchorv3.IPromotionActivityStruct
    public Long getActivityCurrentTime() {
        return this.currentTime;
    }

    @Override // com.bytedance.android.ec.model.response.anchorv3.IPromotionActivityStruct
    public Long getActivityEndTime() {
        return this.endTime;
    }

    @Override // com.bytedance.android.ec.model.response.anchorv3.IPromotionActivityStruct
    public Long getActivityId() {
        return this.f47933id;
    }

    @Override // com.bytedance.android.ec.model.response.anchorv3.IPromotionActivityStruct
    public Long getActivityPreBeginTime() {
        return this.preBeginTime;
    }

    public final Long getBeginTime() {
        return this.beginTime;
    }

    public final Long getCurrentTime() {
        return this.currentTime;
    }

    public final Long getEndTime() {
        return this.endTime;
    }

    public final Long getId() {
        return this.f47933id;
    }

    public final Long getPreBeginTime() {
        return this.preBeginTime;
    }

    public final String getReason() {
        return this.reason;
    }

    public final Long getReasonType() {
        return this.reasonType;
    }
}
