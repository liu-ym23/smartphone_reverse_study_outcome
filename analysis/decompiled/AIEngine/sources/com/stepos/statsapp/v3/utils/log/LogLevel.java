package com.stepos.statsapp.v3.utils.log;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class LogLevel {

    /* renamed from: a, reason: collision with root package name */
    public static final LogLevel f8040a;

    /* renamed from: b, reason: collision with root package name */
    public static final LogLevel f8041b;

    /* renamed from: c, reason: collision with root package name */
    public static final LogLevel f8042c;

    /* renamed from: d, reason: collision with root package name */
    public static final LogLevel f8043d;

    /* renamed from: e, reason: collision with root package name */
    public static final LogLevel f8044e;
    public static final /* synthetic */ LogLevel[] h;

    static {
        LogLevel logLevel = new LogLevel("VERBOSE", 0);
        f8040a = logLevel;
        LogLevel logLevel2 = new LogLevel("DEBUG", 1);
        f8041b = logLevel2;
        LogLevel logLevel3 = new LogLevel("INFO", 2);
        f8042c = logLevel3;
        LogLevel logLevel4 = new LogLevel("WARN", 3);
        f8043d = logLevel4;
        LogLevel logLevel5 = new LogLevel("ERROR", 4);
        f8044e = logLevel5;
        h = new LogLevel[]{logLevel, logLevel2, logLevel3, logLevel4, logLevel5, new LogLevel("NULL", 5)};
    }

    public LogLevel() {
        throw null;
    }

    public static LogLevel valueOf(String str) {
        return (LogLevel) Enum.valueOf(LogLevel.class, str);
    }

    public static LogLevel[] values() {
        return (LogLevel[]) h.clone();
    }
}
