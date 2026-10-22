package com.bytedance.android.ec.model.response.anchorv3;

import com.bytedance.android.ec.model.ECUrlModel;
import com.bytedance.android.livesdkapi.performance.ILoadStallMonitor;
import com.google.gson.annotations.SerializedName;
import com.ss.android.dypay.api.DyPayConstant;
import java.io.Serializable;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes44.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R\u0016\u0010\u0003\u001a\u00020\u00048\u0006X\u0087D¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R\u0016\u0010\u0007\u001a\u00020\u00048\u0006X\u0087D¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0006R\u0018\u0010\t\u001a\u0004\u0018\u00010\n8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0018\u0010\r\u001a\u0004\u0018\u00010\u000e8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0018\u0010\u0011\u001a\u0004\u0018\u00010\n8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\fR\u0016\u0010\u0013\u001a\u00020\u00048\u0006X\u0087D¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0006R\u0016\u0010\u0015\u001a\u00020\u00048\u0006X\u0087D¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0006¨\u0006\u0017"}, d2 = {"Lcom/bytedance/android/ec/model/response/anchorv3/PromotionIPActivity;", "Ljava/io/Serializable;", "()V", "currentTime", "", "getCurrentTime", "()J", "endTime", "getEndTime", "ipBeltUrl", "", "getIpBeltUrl", "()Ljava/lang/String;", "ipLogoUrl", "Lcom/bytedance/android/ec/model/ECUrlModel;", "getIpLogoUrl", "()Lcom/bytedance/android/ec/model/ECUrlModel;", "ipSlogan", "getIpSlogan", "preStartTime", "getPreStartTime", DyPayConstant.KEY_START_TIME, "getStartTime", "ec-model_release"}, k = 1, mv = {1, 4, 3})
public final class PromotionIPActivity implements Serializable {

    @SerializedName("current_time")
    private final long currentTime;

    @SerializedName("end_time")
    private final long endTime;

    @SerializedName("tag_ip_belt")
    private final String ipBeltUrl;

    @SerializedName("tag_ip_logo")
    private final ECUrlModel ipLogoUrl;

    @SerializedName("tag_ip_slogan")
    private final String ipSlogan;

    @SerializedName("pre_start_time")
    private final long preStartTime;

    @SerializedName(ILoadStallMonitor.START_TIME)
    private final long startTime;

    public PromotionIPActivity() {
    }

    public final long getCurrentTime() {
        return this.currentTime;
    }

    public final long getEndTime() {
        return this.endTime;
    }

    public final String getIpBeltUrl() {
        return this.ipBeltUrl;
    }

    public final ECUrlModel getIpLogoUrl() {
        return this.ipLogoUrl;
    }

    public final String getIpSlogan() {
        return this.ipSlogan;
    }

    public final long getPreStartTime() {
        return this.preStartTime;
    }

    public final long getStartTime() {
        return this.startTime;
    }
}
