package com.stepos.statsapp.v3.utils.log;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* loaded from: classes3.dex */
public final class LogLevel {

    /* renamed from: a, reason: collision with root package name */
    public static final LogLevel f3974a;
    public static final LogLevel b;
    public static final LogLevel c;
    public static final LogLevel d;
    public static final LogLevel e;
    public static final /* synthetic */ LogLevel[] f;

    static {
        LogLevel logLevel = new LogLevel("VERBOSE", 0);
        f3974a = logLevel;
        LogLevel logLevel2 = new LogLevel("DEBUG", 1);
        b = logLevel2;
        LogLevel logLevel3 = new LogLevel("INFO", 2);
        c = logLevel3;
        LogLevel logLevel4 = new LogLevel("WARN", 3);
        d = logLevel4;
        LogLevel logLevel5 = new LogLevel("ERROR", 4);
        e = logLevel5;
        f = new LogLevel[]{logLevel, logLevel2, logLevel3, logLevel4, logLevel5, new LogLevel("NULL", 5)};
    }

    public static LogLevel valueOf(String str) {
        return (LogLevel) Enum.valueOf(LogLevel.class, str);
    }

    public static LogLevel[] values() {
        return (LogLevel[]) f.clone();
    }
}
