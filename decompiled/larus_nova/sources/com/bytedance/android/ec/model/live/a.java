package com.bytedance.android.ec.model.live;

import com.bytedance.android.livesdkapi.performance.ILoadStallMonitor;
import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.ss.android.dypay.api.DyPayConstant;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes44.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\t\n\u0002\b\t\u0018\u00002\u00020\u0001R\u001a\u0010\u0003\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001a\u0010\u0007\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0007\u0010\u0004\u001a\u0004\b\b\u0010\u0006R\u001a\u0010\t\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\t\u0010\u0004\u001a\u0004\b\n\u0010\u0006¨\u0006\u000b"}, d2 = {"Lcom/bytedance/android/ec/model/live/a;", "", "", DyPayConstant.KEY_START_TIME, "J", "c", "()J", "endTime", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "serverTime", "b", "ec-model_release"}, k = 1, mv = {1, 4, 3})
public final class a {

    @SerializedName("end_time")
    private final long endTime;

    @SerializedName("server_time")
    private final long serverTime;

    @SerializedName(ILoadStallMonitor.START_TIME)
    private final long startTime;

    public a() {
        this.startTime = 0;
        this.endTime = 0;
        this.serverTime = 0;
    }

    public final long a() {
        return this.endTime;
    }

    public final long b() {
        return this.serverTime;
    }

    public final long c() {
        return this.startTime;
    }
}
