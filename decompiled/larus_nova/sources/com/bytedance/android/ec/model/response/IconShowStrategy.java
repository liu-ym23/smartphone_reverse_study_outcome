package com.bytedance.android.ec.model.response;

import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import java.util.List;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes44.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R&\u0010\u0003\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR \u0010\n\u001a\u0004\u0018\u00010\u000b8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u001e\u0010\u0010\u001a\u00020\u00118\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R \u0010\u0016\u001a\u0004\u0018\u00010\u00178\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001bR\u001e\u0010\u001c\u001a\u00020\u00118\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\u0013\"\u0004\b\u001e\u0010\u0015¨\u0006\u001f"}, d2 = {"Lcom/bytedance/android/ec/model/response/IconShowStrategy;", "Ljava/io/Serializable;", "()V", "cancelActions", "", "Lcom/bytedance/android/ec/model/response/CancelAction;", "getCancelActions", "()Ljava/util/List;", "setCancelActions", "(Ljava/util/List;)V", "limitKey", "", "getLimitKey", "()Ljava/lang/String;", "setLimitKey", "(Ljava/lang/String;)V", "singleTimes", "", "getSingleTimes", "()I", "setSingleTimes", "(I)V", "timesLimitScope", "Lcom/bytedance/android/ec/model/response/TimeLimitScope;", "getTimesLimitScope", "()Lcom/bytedance/android/ec/model/response/TimeLimitScope;", "setTimesLimitScope", "(Lcom/bytedance/android/ec/model/response/TimeLimitScope;)V", "totalTimes", "getTotalTimes", "setTotalTimes", "ec-model_release"}, k = 1, mv = {1, 4, 3})
public final class IconShowStrategy implements Serializable {

    @SerializedName("cancel_actions")
    private List<CancelAction> cancelActions;

    @SerializedName("limit_key")
    private String limitKey;

    @SerializedName("single_times")
    private int singleTimes;

    @SerializedName("times_limit_scope")
    private TimeLimitScope timesLimitScope;

    @SerializedName("total_times")
    private int totalTimes;

    public IconShowStrategy() {
    }

    public final List<CancelAction> getCancelActions() {
        return this.cancelActions;
    }

    public final String getLimitKey() {
        return this.limitKey;
    }

    public final int getSingleTimes() {
        return this.singleTimes;
    }

    public final TimeLimitScope getTimesLimitScope() {
        return this.timesLimitScope;
    }

    public final int getTotalTimes() {
        return this.totalTimes;
    }

    public final void setCancelActions(List<CancelAction> r100) {
        this.cancelActions = r100;
    }

    public final void setLimitKey(String r100) {
        this.limitKey = r100;
    }

    public final void setSingleTimes(int r100) {
        this.singleTimes = r100;
    }

    public final void setTimesLimitScope(TimeLimitScope r100) {
        this.timesLimitScope = r100;
    }

    public final void setTotalTimes(int r100) {
        this.totalTimes = r100;
    }
}
