package com.bytedance.android.livesdk.config;

import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.MapsKt;

/* JADX INFO: loaded from: classes8.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0002\b\t\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0018\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b$\u0010%R\"\u0010\u0003\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\"\u0010\t\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\t\u0010\u0004\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\bR0\u0010\u000f\u001a\u0010\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u000e\u0018\u00010\f8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R$\u0010\u0015\u001a\u0004\u0018\u00010\u000e8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0015\u0010\u0016\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001aR\"\u0010\u001b\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u001b\u0010\u0004\u001a\u0004\b\u001c\u0010\u0006\"\u0004\b\u001d\u0010\bR\"\u0010\u001e\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u001e\u0010\u0004\u001a\u0004\b\u001f\u0010\u0006\"\u0004\b \u0010\bR\"\u0010!\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b!\u0010\u0004\u001a\u0004\b\"\u0010\u0006\"\u0004\b#\u0010\b¨\u0006&"}, d2 = {"Lcom/bytedance/android/livesdk/config/i81;", "", "", "enable", "Z", "b", "()Z", "setEnable", "(Z)V", "enableLocalTest", "c", "setEnableLocalTest", "", "", "Lcom/bytedance/android/livesdk/config/t81;", "periodStrategy", "Ljava/util/Map;", com.amap.api.col.s.ce.f26391f, "()Ljava/util/Map;", "setPeriodStrategy", "(Ljava/util/Map;)V", "defaultPeriodStrategy", "Lcom/bytedance/android/livesdk/config/t81;", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "()Lcom/bytedance/android/livesdk/config/t81;", "setDefaultPeriodStrategy", "(Lcom/bytedance/android/livesdk/config/t81;)V", "enableScreenStrategy", "f", "setEnableScreenStrategy", "enableResourceBalanceStrategy", "e", "setEnableResourceBalanceStrategy", "enableReport", "d", "setEnableReport", "<init>", "()V", "liveutility_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class i81 {

    @SerializedName("default_period_strategy")
    private t81 defaultPeriodStrategy;

    @SerializedName("enable")
    private boolean enable;

    @SerializedName("enable_local_test")
    private boolean enableLocalTest;

    @SerializedName("enable_report")
    private boolean enableReport;

    @SerializedName("enable_resource_balance_strategy")
    private boolean enableResourceBalanceStrategy;

    @SerializedName("enable_screen_strategy")
    private boolean enableScreenStrategy;

    @SerializedName("period_strategy")
    private Map<String, t81> periodStrategy;

    public i81() {
        this.periodStrategy = MapsKt.emptyMap();
        this.defaultPeriodStrategy = new t81(0);
        this.enableReport = true;
    }

    public final t81 a() {
        return this.defaultPeriodStrategy;
    }

    public final boolean b() {
        return this.enable;
    }

    public final boolean c() {
        return this.enableLocalTest;
    }

    public final boolean d() {
        return this.enableReport;
    }

    public final boolean e() {
        return this.enableResourceBalanceStrategy;
    }

    public final boolean f() {
        return this.enableScreenStrategy;
    }

    public final Map<String, t81> g() {
        return this.periodStrategy;
    }
}
