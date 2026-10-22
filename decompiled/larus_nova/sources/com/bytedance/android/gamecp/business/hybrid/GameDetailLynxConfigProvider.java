package com.bytedance.android.gamecp.business.hybrid;

import kotlin.Lazy;
import kotlin.LazyKt;

/* JADX INFO: loaded from: classes44.dex */
public final class GameDetailLynxConfigProvider {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Lazy f55967a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Lazy f55968b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final Lazy f55969c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final Lazy f55970d = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final Lazy f55971e = null;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final Lazy f55972f = null;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final Lazy f55973g = null;

    public static boolean a() {
        return ((Boolean) f55971e.getValue()).booleanValue();
    }

    static {
        f55967a = LazyKt.lazy(GameDetailLynxConfigProvider$preLoadEnableWhenLiveRoomIdle$2.INSTANCE);
        f55968b = LazyKt.lazy(GameDetailLynxConfigProvider$preLoadEnable$2.INSTANCE);
        f55969c = LazyKt.lazy(GameDetailLynxConfigProvider$lynxUpdateSettingsEnable$2.INSTANCE);
        f55970d = LazyKt.lazy(GameDetailLynxConfigProvider$optLynxInitParams$2.INSTANCE);
        f55971e = LazyKt.lazy(GameDetailLynxConfigProvider$lyncCacheInContext$2.INSTANCE);
        f55972f = LazyKt.lazy(GameDetailLynxConfigProvider$optLynxCodeCacheEnable$2.INSTANCE);
        f55973g = LazyKt.lazy(GameDetailLynxConfigProvider$optLynxPredecodeEnable$2.INSTANCE);
    }
}
