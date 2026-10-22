package com.bytedance.android.livesdk.asr;

import kotlin.Metadata;

/* JADX INFO: loaded from: classes7.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lcom/bytedance/android/livesdk/asr/LogLevel;", "", "DEBUG", "INFO", "WARNING", "ERROR", "livegift-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final enum LogLevel extends Enum<LogLevel> {
    public static final LogLevel DEBUG = null;
    public static final LogLevel ERROR = null;
    public static final LogLevel INFO = null;
    public static final LogLevel WARNING = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ LogLevel[] f103954a = null;

    static {
        LogLevel r100 = new LogLevel("DEBUG", 0);
        DEBUG = r100;
        LogLevel r101 = new LogLevel("INFO", 1);
        INFO = r101;
        LogLevel r102 = new LogLevel("WARNING", 2);
        WARNING = r102;
        LogLevel r103 = new LogLevel("ERROR", 3);
        ERROR = r103;
        f103954a = new LogLevel[]{r100, r101, r102, r103};
    }

    public static LogLevel valueOf(String r100) {
        return (LogLevel) r27.a.a(LogLevel.class, r100);
    }

    public static LogLevel[] values() {
        return (LogLevel[]) f103954a.clone();
    }

    public LogLevel(String r100, int r101) {
        super(r100, r101);
    }
}
