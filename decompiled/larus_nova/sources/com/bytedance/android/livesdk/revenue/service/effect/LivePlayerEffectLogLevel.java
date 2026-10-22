package com.bytedance.android.livesdk.revenue.service.effect;

import kotlin.Metadata;

/* JADX INFO: loaded from: classes11.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0007\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007¨\u0006\b"}, d2 = {"Lcom/bytedance/android/livesdk/revenue/service/effect/LivePlayerEffectLogLevel;", "", "LevelVerbose", "LevelDebug", "LevelInfo", "LevelWarn", "LevelError", "LevelNone", "revenue-host-api_saasRelease"}, k = 1, mv = {1, 5, 1})
public final enum LivePlayerEffectLogLevel extends Enum<LivePlayerEffectLogLevel> {
    public static final LivePlayerEffectLogLevel LevelDebug = null;
    public static final LivePlayerEffectLogLevel LevelError = null;
    public static final LivePlayerEffectLogLevel LevelInfo = null;
    public static final LivePlayerEffectLogLevel LevelNone = null;
    public static final LivePlayerEffectLogLevel LevelVerbose = null;
    public static final LivePlayerEffectLogLevel LevelWarn = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ LivePlayerEffectLogLevel[] f157301a = null;

    static {
        LivePlayerEffectLogLevel r100 = new LivePlayerEffectLogLevel("LevelVerbose", 0);
        LevelVerbose = r100;
        LivePlayerEffectLogLevel r101 = new LivePlayerEffectLogLevel("LevelDebug", 1);
        LevelDebug = r101;
        LivePlayerEffectLogLevel r102 = new LivePlayerEffectLogLevel("LevelInfo", 2);
        LevelInfo = r102;
        LivePlayerEffectLogLevel r103 = new LivePlayerEffectLogLevel("LevelWarn", 3);
        LevelWarn = r103;
        LivePlayerEffectLogLevel r104 = new LivePlayerEffectLogLevel("LevelError", 4);
        LevelError = r104;
        LivePlayerEffectLogLevel r105 = new LivePlayerEffectLogLevel("LevelNone", 5);
        LevelNone = r105;
        f157301a = new LivePlayerEffectLogLevel[]{r100, r101, r102, r103, r104, r105};
    }

    public static LivePlayerEffectLogLevel valueOf(String r100) {
        return (LivePlayerEffectLogLevel) r27.a.a(LivePlayerEffectLogLevel.class, r100);
    }

    public static LivePlayerEffectLogLevel[] values() {
        return (LivePlayerEffectLogLevel[]) f157301a.clone();
    }

    public LivePlayerEffectLogLevel(String r100, int r101) {
        super(r100, r101);
    }
}
