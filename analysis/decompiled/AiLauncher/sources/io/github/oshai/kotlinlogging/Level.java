package io.github.oshai.kotlinlogging;

import h9.InterfaceC4149a;
import kotlin.Metadata;
import kotlin.enums.a;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u000b\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0019\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u0006\u0010\u000e\u001a\u00020\u0003J\b\u0010\u000f\u001a\u00020\u0005H\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\r¨\u0006\u0010"}, d2 = {"Lio/github/oshai/kotlinlogging/Level;", "", "levelInt", "", "levelStr", "", "<init>", "(Ljava/lang/String;IILjava/lang/String;)V", "TRACE", "DEBUG", "INFO", "WARN", "ERROR", "OFF", "toInt", "toString", "kotlin-logging_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class Level {
    private static final /* synthetic */ InterfaceC4149a $ENTRIES;
    private static final /* synthetic */ Level[] $VALUES;
    private final int levelInt;
    private final String levelStr;
    public static final Level TRACE = new Level("TRACE", 0, 0, "TRACE");
    public static final Level DEBUG = new Level("DEBUG", 1, 10, "DEBUG");
    public static final Level INFO = new Level("INFO", 2, 20, "INFO");
    public static final Level WARN = new Level("WARN", 3, 30, "WARN");
    public static final Level ERROR = new Level("ERROR", 4, 40, "ERROR");
    public static final Level OFF = new Level("OFF", 5, 50, "OFF");

    private static final /* synthetic */ Level[] $values() {
        return new Level[]{TRACE, DEBUG, INFO, WARN, ERROR, OFF};
    }

    static {
        Level[] levelArr$values = $values();
        $VALUES = levelArr$values;
        $ENTRIES = a.a(levelArr$values);
    }

    private Level(String str, int i10, int i11, String str2) {
        this.levelInt = i11;
        this.levelStr = str2;
    }

    public static InterfaceC4149a<Level> getEntries() {
        return $ENTRIES;
    }

    public static Level valueOf(String str) {
        return (Level) Enum.valueOf(Level.class, str);
    }

    public static Level[] values() {
        return (Level[]) $VALUES.clone();
    }

    /* renamed from: toInt, reason: from getter */
    public final int getLevelInt() {
        return this.levelInt;
    }

    @Override // java.lang.Enum
    public String toString() {
        return this.levelStr;
    }
}
