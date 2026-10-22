package com.bytedance.android.livesdkapi.vsplayer.preload;

import kotlin.Metadata;
import r27.a;

/* JADX INFO: loaded from: classes12.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\t¨\u0006\n"}, d2 = {"Lcom/bytedance/android/livesdkapi/vsplayer/preload/CacheConfig;", "", "value", "", "(Ljava/lang/String;II)V", "getValue", "()I", "DISABLE", "ONLY_CACHE_API", "CACHE_API_AND_VIDEO", "livesdkapi_saasRelease"}, k = 1, mv = {1, 4, 3})
public final enum CacheConfig extends Enum<CacheConfig> {
    private static final /* synthetic */ CacheConfig[] $VALUES = null;
    public static final CacheConfig CACHE_API_AND_VIDEO = null;
    public static final CacheConfig DISABLE = null;
    public static final CacheConfig ONLY_CACHE_API = null;
    private final int value;

    static {
        CacheConfig r100 = new CacheConfig("DISABLE", 0, 0);
        DISABLE = r100;
        CacheConfig r101 = new CacheConfig("ONLY_CACHE_API", 1, 1);
        ONLY_CACHE_API = r101;
        CacheConfig r102 = new CacheConfig("CACHE_API_AND_VIDEO", 2, 2);
        CACHE_API_AND_VIDEO = r102;
        $VALUES = new CacheConfig[]{r100, r101, r102};
    }

    public static CacheConfig valueOf(String r100) {
        return (CacheConfig) a.a(CacheConfig.class, r100);
    }

    public static CacheConfig[] values() {
        return (CacheConfig[]) $VALUES.clone();
    }

    public final int getValue() {
        return this.value;
    }

    private CacheConfig(String r100, int r101, int r102) {
        super(r100, r101);
        this.value = r102;
    }
}
