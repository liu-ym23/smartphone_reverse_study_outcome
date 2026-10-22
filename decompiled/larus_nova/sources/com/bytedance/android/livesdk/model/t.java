package com.bytedance.android.livesdk.model;

import com.google.gson.annotations.SerializedName;
import java.util.Map;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes11.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0016\u0010\u0017R$\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR0\u0010\f\u001a\u0010\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R0\u0010\u0013\u001a\u0010\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u0012\u0018\u00010\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0013\u0010\r\u001a\u0004\b\u0014\u0010\u000f\"\u0004\b\u0015\u0010\u0011¨\u0006\u0018"}, d2 = {"Lcom/bytedance/android/livesdk/model/t;", "", "Lcom/bytedance/android/livesdk/model/v;", "defaultHookParam", "Lcom/bytedance/android/livesdk/model/v;", "getDefaultHookParam", "()Lcom/bytedance/android/livesdk/model/v;", "setDefaultHookParam", "(Lcom/bytedance/android/livesdk/model/v;)V", "", "", "Lcom/bytedance/android/livesdk/model/y;", "strategiesControl", "Ljava/util/Map;", "getStrategiesControl", "()Ljava/util/Map;", "setStrategiesControl", "(Ljava/util/Map;)V", "Lcom/bytedance/android/livesdk/model/x;", "staticHookRanking", "getStaticHookRanking", "setStaticHookRanking", "<init>", "()V", "infrastructure_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class t {

    @SerializedName("default_hook_config")
    private v defaultHookParam;

    @SerializedName("static_hook_config")
    private Map<String, x> staticHookRanking;

    @SerializedName("strategies_control")
    private Map<String, y> strategiesControl;

    public t() {
    }
}
