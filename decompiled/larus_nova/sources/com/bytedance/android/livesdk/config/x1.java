package com.bytedance.android.livesdk.config;

import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import java.util.Map;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes8.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0010\u0006\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0012\u0010\u0013R0\u0010\u0005\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0005\u0010\u0006\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR$\u0010\f\u001a\u0004\u0018\u00010\u000b8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011¨\u0006\u0014"}, d2 = {"Lcom/bytedance/android/livesdk/config/x1;", "", "", "", "", "loadPriorityConfig", "Ljava/util/Map;", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "()Ljava/util/Map;", "setLoadPriorityConfig", "(Ljava/util/Map;)V", "Lcom/bytedance/android/livesdk/config/o91;", "loadStrategyConfig", "Lcom/bytedance/android/livesdk/config/o91;", "b", "()Lcom/bytedance/android/livesdk/config/o91;", "setLoadStrategyConfig", "(Lcom/bytedance/android/livesdk/config/o91;)V", "<init>", "()V", "infrastructure_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class x1 {

    @SerializedName("load_priority_config")
    private Map<String, Double> loadPriorityConfig;

    @SerializedName("load_strategy_config")
    private o91 loadStrategyConfig;

    public x1() {
    }

    public final Map<String, Double> a() {
        return this.loadPriorityConfig;
    }

    public final o91 b() {
        return this.loadStrategyConfig;
    }
}
