package com.bytedance.android.livesdkapi.model;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes12.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R\u0016\u0010\u0003\u001a\u00020\u00048\u0006X\u0087D¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R\u0016\u0010\u0007\u001a\u00020\b8\u0006X\u0087D¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0016\u0010\u000b\u001a\u00020\u00048\u0006X\u0087D¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\u0006¨\u0006\r"}, d2 = {"Lcom/bytedance/android/livesdkapi/model/PlayerThreadPoolConfig;", "", "()V", "enable", "", "getEnable", "()Z", "poolSize", "", "getPoolSize", "()I", "reuseFirst", "getReuseFirst", "live-player-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class PlayerThreadPoolConfig {

    @SerializedName("enable")
    private final boolean enable;

    @SerializedName("pool_size")
    private final int poolSize;

    @SerializedName("reuse_first")
    private final boolean reuseFirst;

    public PlayerThreadPoolConfig() {
        this.poolSize = 3;
        this.reuseFirst = true;
    }

    public final boolean getEnable() {
        return this.enable;
    }

    public final int getPoolSize() {
        return this.poolSize;
    }

    public final boolean getReuseFirst() {
        return this.reuseFirst;
    }
}
