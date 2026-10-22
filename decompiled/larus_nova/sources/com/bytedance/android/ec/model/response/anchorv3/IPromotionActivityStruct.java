package com.bytedance.android.ec.model.response.anchorv3;

import java.io.Serializable;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes44.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0006\bf\u0018\u00002\u00020\u0001J\u000f\u0010\u0002\u001a\u0004\u0018\u00010\u0003H&¢\u0006\u0002\u0010\u0004J\u000f\u0010\u0005\u001a\u0004\u0018\u00010\u0003H&¢\u0006\u0002\u0010\u0004J\u000f\u0010\u0006\u001a\u0004\u0018\u00010\u0003H&¢\u0006\u0002\u0010\u0004J\u000f\u0010\u0007\u001a\u0004\u0018\u00010\u0003H&¢\u0006\u0002\u0010\u0004J\u000f\u0010\b\u001a\u0004\u0018\u00010\u0003H&¢\u0006\u0002\u0010\u0004¨\u0006\t"}, d2 = {"Lcom/bytedance/android/ec/model/response/anchorv3/IPromotionActivityStruct;", "Ljava/io/Serializable;", "getActivityBeginTime", "", "()Ljava/lang/Long;", "getActivityCurrentTime", "getActivityEndTime", "getActivityId", "getActivityPreBeginTime", "ec-model_release"}, k = 1, mv = {1, 4, 3})
public interface IPromotionActivityStruct extends Serializable {
    Long getActivityBeginTime();

    Long getActivityCurrentTime();

    Long getActivityEndTime();

    Long getActivityId();

    Long getActivityPreBeginTime();
}
