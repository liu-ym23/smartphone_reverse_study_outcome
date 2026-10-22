package com.bytedance.android.ec.model.response;

import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes44.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R\u001e\u0010\u0003\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0003\u0010\u0005\"\u0004\b\u0006\u0010\u0007R\"\u0010\b\u001a\u0004\u0018\u00010\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0002\u0010\u000e\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\r¨\u0006\u000f"}, d2 = {"Lcom/bytedance/android/ec/model/response/TimeLimitScope;", "Ljava/io/Serializable;", "()V", "isNaturalTime", "", "()Z", "setNaturalTime", "(Z)V", "period", "", "getPeriod", "()Ljava/lang/Long;", "setPeriod", "(Ljava/lang/Long;)V", "Ljava/lang/Long;", "ec-model_release"}, k = 1, mv = {1, 4, 3})
public final class TimeLimitScope implements Serializable {

    @SerializedName("is_natural_time")
    private boolean isNaturalTime;

    @SerializedName("period")
    private Long period;

    public TimeLimitScope() {
    }

    public final Long getPeriod() {
        return this.period;
    }

    public final boolean isNaturalTime() {
        return this.isNaturalTime;
    }

    public final void setNaturalTime(boolean r100) {
        this.isNaturalTime = r100;
    }

    public final void setPeriod(Long r100) {
        this.period = r100;
    }
}
