package org.slf4j.event;

/* loaded from: classes5.dex */
public enum Level {
    ERROR(40, "ERROR"),
    WARN(30, "WARN"),
    INFO(20, "INFO"),
    DEBUG(10, "DEBUG"),
    TRACE(0, "TRACE");

    private final int levelInt;
    private final String levelStr;

    Level(int i10, String str) {
        this.levelInt = i10;
        this.levelStr = str;
    }

    public static Level intToLevel(int i10) {
        if (i10 == 0) {
            return TRACE;
        }
        if (i10 == 10) {
            return DEBUG;
        }
        if (i10 == 20) {
            return INFO;
        }
        if (i10 == 30) {
            return WARN;
        }
        if (i10 == 40) {
            return ERROR;
        }
        throw new IllegalArgumentException("Level integer [" + i10 + "] not recognized.");
    }

    public int toInt() {
        return this.levelInt;
    }

    @Override // java.lang.Enum
    public String toString() {
        return this.levelStr;
    }
}
