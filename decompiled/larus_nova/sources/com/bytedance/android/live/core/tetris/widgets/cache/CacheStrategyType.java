package com.bytedance.android.live.core.tetris.widgets.cache;

import com.bytedance.android.livesdk.chatroom.event.UserProfileEvent;
import com.ss.android.ugc.effectmanager.common.EffectConstants;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes45.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lcom/bytedance/android/live/core/tetris/widgets/cache/CacheStrategyType;", "", EffectConstants.NORMAL, "LOW_END_DEVICE", "NO_CACHE", UserProfileEvent.POSITION_NONE, "tetris_saasRelease"}, k = 1, mv = {1, 4, 3})
public final enum CacheStrategyType extends Enum<CacheStrategyType> {
    public static final CacheStrategyType LOW_END_DEVICE = null;
    public static final CacheStrategyType NONE = null;
    public static final CacheStrategyType NORMAL = null;
    public static final CacheStrategyType NO_CACHE = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ CacheStrategyType[] f65960a = null;

    static {
        CacheStrategyType r100 = new CacheStrategyType(EffectConstants.NORMAL, 0);
        NORMAL = r100;
        CacheStrategyType r101 = new CacheStrategyType("LOW_END_DEVICE", 1);
        LOW_END_DEVICE = r101;
        CacheStrategyType r102 = new CacheStrategyType("NO_CACHE", 2);
        NO_CACHE = r102;
        CacheStrategyType r103 = new CacheStrategyType(UserProfileEvent.POSITION_NONE, 3);
        NONE = r103;
        f65960a = new CacheStrategyType[]{r100, r101, r102, r103};
    }

    public static CacheStrategyType valueOf(String r100) {
        return (CacheStrategyType) r27.a.a(CacheStrategyType.class, r100);
    }

    public static CacheStrategyType[] values() {
        return (CacheStrategyType[]) f65960a.clone();
    }

    public CacheStrategyType(String r100, int r101) {
        super(r100, r101);
    }
}
