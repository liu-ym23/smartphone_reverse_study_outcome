package com.bytedance.android.livesdk.chatroom.replay_api.model;

import kotlin.Metadata;
import r27.a;

/* JADX INFO: loaded from: classes7.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\b\n\u0002\b\b\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\t¨\u0006\n"}, d2 = {"Lcom/bytedance/android/livesdk/chatroom/replay_api/model/ReplayCacheConfig;", "", "", "value", "I", "getValue", "()I", "DISABLE", "ONLY_CACHE_API", "CACHE_API_AND_VIDEO", "vs-model_saasRelease"}, k = 1, mv = {1, 4, 3})
public final enum ReplayCacheConfig extends Enum<ReplayCacheConfig> {
    public static final ReplayCacheConfig CACHE_API_AND_VIDEO = null;
    public static final ReplayCacheConfig DISABLE = null;
    public static final ReplayCacheConfig ONLY_CACHE_API = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ ReplayCacheConfig[] f110377a = null;
    private final int value;

    static {
        ReplayCacheConfig r100 = new ReplayCacheConfig("DISABLE", 0, 0);
        DISABLE = r100;
        ReplayCacheConfig r101 = new ReplayCacheConfig("ONLY_CACHE_API", 1, 1);
        ONLY_CACHE_API = r101;
        ReplayCacheConfig r102 = new ReplayCacheConfig("CACHE_API_AND_VIDEO", 2, 2);
        CACHE_API_AND_VIDEO = r102;
        f110377a = new ReplayCacheConfig[]{r100, r101, r102};
    }

    public static ReplayCacheConfig valueOf(String r100) {
        return (ReplayCacheConfig) a.a(ReplayCacheConfig.class, r100);
    }

    public static ReplayCacheConfig[] values() {
        return (ReplayCacheConfig[]) f110377a.clone();
    }

    public final int getValue() {
        return this.value;
    }

    public ReplayCacheConfig(String r100, int r101, int r102) {
        super(r100, r101);
        this.value = r102;
    }
}
