package com.bytedance.android.ec.model.response.anchorv3;

import com.bytedance.android.livesdkapi.performance.ILoadStallMonitor;
import com.google.gson.annotations.SerializedName;
import com.ss.android.dypay.api.DyPayConstant;
import java.io.Serializable;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes44.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u000b\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R\u001e\u0010\u0003\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001e\u0010\t\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\bR\u001e\u0010\f\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u0006\"\u0004\b\u000e\u0010\b¨\u0006\u000f"}, d2 = {"Lcom/bytedance/android/ec/model/response/anchorv3/CountDown;", "Ljava/io/Serializable;", "()V", "endTime", "", "getEndTime", "()J", "setEndTime", "(J)V", "serverTime", "getServerTime", "setServerTime", DyPayConstant.KEY_START_TIME, "getStartTime", "setStartTime", "ec-model_release"}, k = 1, mv = {1, 4, 3})
public final class CountDown implements Serializable {

    @SerializedName("end_time")
    private long endTime;

    @SerializedName("server_time")
    private long serverTime;

    @SerializedName(ILoadStallMonitor.START_TIME)
    private long startTime;

    public CountDown() {
    }

    public final long getEndTime() {
        return this.endTime;
    }

    public final long getServerTime() {
        return this.serverTime;
    }

    public final long getStartTime() {
        return this.startTime;
    }

    public final void setEndTime(long r100) {
        this.endTime = r100;
    }

    public final void setServerTime(long r100) {
        this.serverTime = r100;
    }

    public final void setStartTime(long r100) {
        this.startTime = r100;
    }
}
