package com.bytedance.android.livesdkapi.roomplayer;

import kotlin.Metadata;
import r27.a;

/* JADX INFO: loaded from: classes12.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\b\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\b¨\u0006\t"}, d2 = {"Lcom/bytedance/android/livesdkapi/roomplayer/PlayerEffectLogLevel;", "", "(Ljava/lang/String;I)V", "LevelVerbose", "LevelDebug", "LevelInfo", "LevelWarn", "LevelError", "LevelNone", "live-player-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public final enum PlayerEffectLogLevel extends Enum<PlayerEffectLogLevel> {
    private static final /* synthetic */ PlayerEffectLogLevel[] $VALUES = null;
    public static final PlayerEffectLogLevel LevelDebug = null;
    public static final PlayerEffectLogLevel LevelError = null;
    public static final PlayerEffectLogLevel LevelInfo = null;
    public static final PlayerEffectLogLevel LevelNone = null;
    public static final PlayerEffectLogLevel LevelVerbose = null;
    public static final PlayerEffectLogLevel LevelWarn = null;

    static {
        PlayerEffectLogLevel r100 = new PlayerEffectLogLevel("LevelVerbose", 0);
        LevelVerbose = r100;
        PlayerEffectLogLevel r101 = new PlayerEffectLogLevel("LevelDebug", 1);
        LevelDebug = r101;
        PlayerEffectLogLevel r102 = new PlayerEffectLogLevel("LevelInfo", 2);
        LevelInfo = r102;
        PlayerEffectLogLevel r103 = new PlayerEffectLogLevel("LevelWarn", 3);
        LevelWarn = r103;
        PlayerEffectLogLevel r104 = new PlayerEffectLogLevel("LevelError", 4);
        LevelError = r104;
        PlayerEffectLogLevel r105 = new PlayerEffectLogLevel("LevelNone", 5);
        LevelNone = r105;
        $VALUES = new PlayerEffectLogLevel[]{r100, r101, r102, r103, r104, r105};
    }

    public static PlayerEffectLogLevel valueOf(String r100) {
        return (PlayerEffectLogLevel) a.a(PlayerEffectLogLevel.class, r100);
    }

    public static PlayerEffectLogLevel[] values() {
        return (PlayerEffectLogLevel[]) $VALUES.clone();
    }

    private PlayerEffectLogLevel(String r100, int r101) {
        super(r100, r101);
    }
}
