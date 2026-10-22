package com.bytedance.android.shopping.store.home.entity;

import com.bytedance.android.livesdkapi.performance.ILoadStallMonitor;
import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.ss.android.dypay.api.DyPayConstant;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes14.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0015\u0010\u0016R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001c\u0010\b\u001a\u0004\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000bR\u001c\u0010\f\u001a\u0004\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\f\u0010\t\u001a\u0004\b\r\u0010\u000bR\u001c\u0010\u000e\u001a\u0004\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u000e\u0010\t\u001a\u0004\b\u000f\u0010\u000bR\u001a\u0010\u0011\u001a\u00020\u00108\u0006X\u0087D¢\u0006\f\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014¨\u0006\u0017"}, d2 = {"Lcom/bytedance/android/shopping/store/home/entity/k;", "", "", "timeRangeType", "Ljava/lang/Integer;", "getTimeRangeType", "()Ljava/lang/Integer;", "", DyPayConstant.KEY_START_TIME, "Ljava/lang/Long;", "getStartTime", "()Ljava/lang/Long;", "endTime", "getEndTime", "curTime", "getCurTime", "", "isClosed", "Z", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "()Z", "<init>", "()V", "ec-biz-store-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class k {

    @SerializedName("cur_time")
    private final Long curTime;

    @SerializedName("end_time")
    private final Long endTime;

    @SerializedName("is_closed")
    private final boolean isClosed;

    @SerializedName(ILoadStallMonitor.START_TIME)
    private final Long startTime;

    @SerializedName("time_range_type")
    private final Integer timeRangeType;

    public k() {
    }

    public final boolean a() {
        return this.isClosed;
    }
}
