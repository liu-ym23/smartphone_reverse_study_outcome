package com.tencent.mmkv;

/* JADX INFO: loaded from: classes4.dex */
public final enum MMKVLogLevel extends Enum<MMKVLogLevel> {
    private static final /* synthetic */ MMKVLogLevel[] $VALUES = null;
    public static final MMKVLogLevel LevelDebug = null;
    public static final MMKVLogLevel LevelError = null;
    public static final MMKVLogLevel LevelInfo = null;
    public static final MMKVLogLevel LevelNone = null;
    public static final MMKVLogLevel LevelWarning = null;

    static {
        MMKVLogLevel r10 = new MMKVLogLevel("LevelDebug", 0);
        LevelDebug = r10;
        MMKVLogLevel r11 = new MMKVLogLevel("LevelInfo", 1);
        LevelInfo = r11;
        MMKVLogLevel r12 = new MMKVLogLevel("LevelWarning", 2);
        LevelWarning = r12;
        MMKVLogLevel r13 = new MMKVLogLevel("LevelError", 3);
        LevelError = r13;
        MMKVLogLevel r14 = new MMKVLogLevel("LevelNone", 4);
        LevelNone = r14;
        $VALUES = new MMKVLogLevel[]{r10, r11, r12, r13, r14};
    }

    private MMKVLogLevel(String r10, int r11) {
        super(r10, r11);
    }

    public static MMKVLogLevel valueOf(String r10) {
        return (MMKVLogLevel) Enum.valueOf(MMKVLogLevel.class, r10);
    }

    public static MMKVLogLevel[] values() {
        return (MMKVLogLevel[]) $VALUES.clone();
    }
}
