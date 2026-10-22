package com.bytedance.android.live.effect.base;

import kotlin.Metadata;

/* JADX INFO: loaded from: classes45.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\b\n\u0002\b\b\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\t¨\u0006\n"}, d2 = {"Lcom/bytedance/android/live/effect/base/EffectDataFetchCacheType;", "", "", "code", "I", "getCode", "()I", "NoCache", "HitLiveCache", "HitEPCache", "liveeffect-middleware-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public final enum EffectDataFetchCacheType extends Enum<EffectDataFetchCacheType> {
    public static final EffectDataFetchCacheType HitEPCache = null;
    public static final EffectDataFetchCacheType HitLiveCache = null;
    public static final EffectDataFetchCacheType NoCache = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ EffectDataFetchCacheType[] f66951a = null;
    private final int code;

    static {
        EffectDataFetchCacheType r100 = new EffectDataFetchCacheType("NoCache", 0, 0);
        NoCache = r100;
        EffectDataFetchCacheType r101 = new EffectDataFetchCacheType("HitLiveCache", 1, 1);
        HitLiveCache = r101;
        EffectDataFetchCacheType r102 = new EffectDataFetchCacheType("HitEPCache", 2, 2);
        HitEPCache = r102;
        f66951a = new EffectDataFetchCacheType[]{r100, r101, r102};
    }

    public static EffectDataFetchCacheType valueOf(String r100) {
        return (EffectDataFetchCacheType) r27.a.a(EffectDataFetchCacheType.class, r100);
    }

    public static EffectDataFetchCacheType[] values() {
        return (EffectDataFetchCacheType[]) f66951a.clone();
    }

    public final int getCode() {
        return this.code;
    }

    public EffectDataFetchCacheType(String r100, int r101, int r102) {
        super(r100, r101);
        this.code = r102;
    }
}
