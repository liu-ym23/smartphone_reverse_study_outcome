package com.bytedance.android.livesdk.gift.configmodel;

import com.amap.api.col.s.ce;
import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u000f\u0018\u00002\u00020\u0001:\u0001\u0013B\u0007¢\u0006\u0004\b\u0016\u0010\u0017R\u001a\u0010\u0003\u001a\u00020\u00028\u0006X\u0087D¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001a\u0010\u0007\u001a\u00020\u00028\u0006X\u0087D¢\u0006\f\n\u0004\b\u0007\u0010\u0004\u001a\u0004\b\b\u0010\u0006R\u001a\u0010\n\u001a\u00020\t8\u0006X\u0087D¢\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\rR\u001a\u0010\u000e\u001a\u00020\t8\u0006X\u0087D¢\u0006\f\n\u0004\b\u000e\u0010\u000b\u001a\u0004\b\u000f\u0010\rR\u001a\u0010\u0010\u001a\u00020\t8\u0006X\u0087D¢\u0006\f\n\u0004\b\u0010\u0010\u000b\u001a\u0004\b\u0011\u0010\rR\u001a\u0010\u0012\u001a\u00020\t8\u0006X\u0087D¢\u0006\f\n\u0004\b\u0012\u0010\u000b\u001a\u0004\b\u0013\u0010\rR\u001a\u0010\u0014\u001a\u00020\t8\u0006X\u0087D¢\u0006\f\n\u0004\b\u0014\u0010\u000b\u001a\u0004\b\u0015\u0010\r¨\u0006\u0018"}, d2 = {"Lcom/bytedance/android/livesdk/gift/configmodel/d0;", "", "", "fetchOptEnable", "Z", "e", "()Z", "fetchMomentOptEnable", "d", "", "firstFetchGiftStrategy", "I", "f", "()I", "nextFetchStrategy", ce.f26391f, "fetchAssetsStrategy", "c", "delayFetchAssetsTime", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "delayFetchGiftListTime", "b", "<init>", "()V", "livegift-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class d0 {

    @SerializedName("fetch_assets_delay")
    private final int delayFetchAssetsTime;

    @SerializedName("fetch_gift_delay")
    private final int delayFetchGiftListTime;

    @SerializedName("fetch_assets_strategy")
    private final int fetchAssetsStrategy;

    @SerializedName("fetch_opt_only_moment_enable")
    private final boolean fetchMomentOptEnable;

    @SerializedName("fetch_opt_enable")
    private final boolean fetchOptEnable;

    @SerializedName("first_fetch_gift_strategy")
    private final int firstFetchGiftStrategy;

    @SerializedName("next_fetch_gift_strategy")
    private final int nextFetchStrategy;

    public static final class a {
    }

    static {
    }

    public d0() {
        this.firstFetchGiftStrategy = 4;
        this.nextFetchStrategy = 4;
        this.fetchAssetsStrategy = 4;
        this.delayFetchAssetsTime = 2000;
        this.delayFetchGiftListTime = 2000;
    }

    public final int a() {
        return this.delayFetchAssetsTime;
    }

    public final int b() {
        return this.delayFetchGiftListTime;
    }

    public final int c() {
        return this.fetchAssetsStrategy;
    }

    public final boolean d() {
        return this.fetchMomentOptEnable;
    }

    public final boolean e() {
        return this.fetchOptEnable;
    }

    public final int f() {
        return this.firstFetchGiftStrategy;
    }

    public final int g() {
        return this.nextFetchStrategy;
    }
}
