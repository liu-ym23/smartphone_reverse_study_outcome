package com.bytedance.android.livesdk.player.setting;

import kotlin.Lazy;
import kotlin.LazyKt;

/* JADX INFO: loaded from: classes11.dex */
public final class SettingKeyUtils {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Lazy f156046a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Lazy f156047b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final Lazy f156048c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final Lazy f156049d = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final Lazy f156050e = null;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final Lazy f156051f = null;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final Lazy f156052g = null;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final Lazy f156053h = null;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final Lazy f156054i = null;

    public static boolean a() {
        return ((Boolean) f156048c.getValue()).booleanValue();
    }

    static {
        f156046a = LazyKt.lazy(SettingKeyUtils$settingByLazyOpt$2.INSTANCE);
        f156047b = LazyKt.lazy(SettingKeyUtils$loadPauseViewWay$2.INSTANCE);
        f156048c = LazyKt.lazy(SettingKeyUtils$eventLeakFix$2.INSTANCE);
        f156049d = LazyKt.lazy(SettingKeyUtils$playerStabilityOpt$2.INSTANCE);
        f156050e = LazyKt.lazy(SettingKeyUtils$optNpThParams$2.INSTANCE);
        f156051f = LazyKt.lazy(SettingKeyUtils$startPlayReportAfterCreateLiveStreamData$2.INSTANCE);
        f156052g = LazyKt.lazy(SettingKeyUtils$catchExceptionForAudioController$2.INSTANCE);
        f156053h = LazyKt.lazy(SettingKeyUtils$reportMuteToTrace$2.INSTANCE);
        f156054i = LazyKt.lazy(SettingKeyUtils$reportMuteCallStack$2.INSTANCE);
    }
}
