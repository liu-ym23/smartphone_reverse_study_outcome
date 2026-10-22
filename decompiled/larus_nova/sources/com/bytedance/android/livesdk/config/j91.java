package com.bytedance.android.livesdk.config;

import com.bytedance.ies.sdk.widgets.priority.PriorityModule;
import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes8.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0002\b\t\n\u0002\u0010\u0007\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u001a\u0010\u001bR$\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR$\u0010\t\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\t\u0010\u0004\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\bR$\u0010\r\u001a\u0004\u0018\u00010\f8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R$\u0010\u0014\u001a\u0004\u0018\u00010\u00138\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019¨\u0006\u001c"}, d2 = {"Lcom/bytedance/android/livesdk/config/j91;", "", "", "enable_priority", "Ljava/lang/Boolean;", "c", "()Ljava/lang/Boolean;", "setEnable_priority", "(Ljava/lang/Boolean;)V", "enable_frame_load", "b", "setEnable_frame_load", "", "frame_ratio", "Ljava/lang/Float;", "d", "()Ljava/lang/Float;", "setFrame_ratio", "(Ljava/lang/Float;)V", "Lcom/bytedance/ies/sdk/widgets/priority/PriorityModule;", "diff_config", "Lcom/bytedance/ies/sdk/widgets/priority/PriorityModule;", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "()Lcom/bytedance/ies/sdk/widgets/priority/PriorityModule;", "setDiff_config", "(Lcom/bytedance/ies/sdk/widgets/priority/PriorityModule;)V", "<init>", "()V", "liveutility_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class j91 {

    @SerializedName("diff_config")
    private PriorityModule diff_config;

    @SerializedName("enable_frame_load")
    private Boolean enable_frame_load;

    @SerializedName("enable_priority")
    private Boolean enable_priority;

    @SerializedName("frame_ratio")
    private Float frame_ratio;

    public j91() {
        Boolean r100 = Boolean.FALSE;
        this.enable_priority = r100;
        this.enable_frame_load = r100;
        this.frame_ratio = Float.valueOf(1.0f);
    }

    public final PriorityModule a() {
        return this.diff_config;
    }

    public final Boolean b() {
        return this.enable_frame_load;
    }

    public final Boolean c() {
        return this.enable_priority;
    }

    public final Float d() {
        return this.frame_ratio;
    }
}
