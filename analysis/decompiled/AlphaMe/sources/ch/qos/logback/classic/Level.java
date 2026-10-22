package ch.qos.logback.classic;

import java.io.Serializable;
import s.AbstractC0831a;

/* loaded from: classes.dex */
public final class Level implements Serializable {
    public static final int ALL_INT = Integer.MIN_VALUE;
    public static final int DEBUG_INT = 10000;
    public static final int INFO_INT = 20000;
    public static final int OFF_INT = Integer.MAX_VALUE;
    public static final int TRACE_INT = 5000;
    public static final int WARN_INT = 30000;
    private static final long serialVersionUID = -814092767334282137L;
    public final int levelInt;
    public final String levelStr;
    public static final Integer OFF_INTEGER = Integer.MAX_VALUE;
    public static final int ERROR_INT = 40000;
    public static final Integer ERROR_INTEGER = Integer.valueOf(ERROR_INT);
    public static final Integer WARN_INTEGER = 30000;
    public static final Integer INFO_INTEGER = 20000;
    public static final Integer DEBUG_INTEGER = 10000;
    public static final Integer TRACE_INTEGER = 5000;
    public static final Integer ALL_INTEGER = Integer.MIN_VALUE;
    public static final Level OFF = new Level(Integer.MAX_VALUE, "OFF");
    public static final Level ERROR = new Level(ERROR_INT, "ERROR");
    public static final Level WARN = new Level(30000, "WARN");
    public static final Level INFO = new Level(20000, "INFO");
    public static final Level DEBUG = new Level(10000, "DEBUG");
    public static final Level TRACE = new Level(5000, "TRACE");
    public static final Level ALL = new Level(Integer.MIN_VALUE, "ALL");

    private Level(int i4, String str) {
        this.levelInt = i4;
        this.levelStr = str;
    }

    public static Level fromLocationAwareLoggerInteger(int i4) {
        if (i4 == 0) {
            return TRACE;
        }
        if (i4 == 10) {
            return DEBUG;
        }
        if (i4 == 20) {
            return INFO;
        }
        if (i4 == 30) {
            return WARN;
        }
        if (i4 == 40) {
            return ERROR;
        }
        throw new IllegalArgumentException(i4 + " not a valid level value");
    }

    private Object readResolve() {
        return toLevel(this.levelInt);
    }

    public static Level toLevel(String str) {
        return toLevel(str, DEBUG);
    }

    public static int toLocationAwareLoggerInteger(Level level) {
        if (level == null) {
            throw new IllegalArgumentException("null level parameter is not admitted");
        }
        int i4 = level.toInt();
        if (i4 == 5000) {
            return 0;
        }
        if (i4 == 10000) {
            return 10;
        }
        if (i4 == 20000) {
            return 20;
        }
        if (i4 == 30000) {
            return 30;
        }
        if (i4 == 40000) {
            return 40;
        }
        throw new IllegalArgumentException(level + " not a valid level value");
    }

    public static Level valueOf(String str) {
        return toLevel(str, DEBUG);
    }

    public boolean isGreaterOrEqual(Level level) {
        return this.levelInt >= level.levelInt;
    }

    public int toInt() {
        return this.levelInt;
    }

    public Integer toInteger() {
        int i4 = this.levelInt;
        if (i4 == Integer.MIN_VALUE) {
            return ALL_INTEGER;
        }
        if (i4 == 5000) {
            return TRACE_INTEGER;
        }
        if (i4 == 10000) {
            return DEBUG_INTEGER;
        }
        if (i4 == 20000) {
            return INFO_INTEGER;
        }
        if (i4 == 30000) {
            return WARN_INTEGER;
        }
        if (i4 == 40000) {
            return ERROR_INTEGER;
        }
        if (i4 == Integer.MAX_VALUE) {
            return OFF_INTEGER;
        }
        StringBuilder sb = new StringBuilder("Level ");
        sb.append(this.levelStr);
        sb.append(", ");
        throw new IllegalStateException(AbstractC0831a.d(sb, this.levelInt, " is unknown."));
    }

    public String toString() {
        return this.levelStr;
    }

    public static Level toLevel(int i4) {
        return toLevel(i4, DEBUG);
    }

    public static Level toLevel(int i4, Level level) {
        if (i4 == Integer.MIN_VALUE) {
            return ALL;
        }
        if (i4 == 5000) {
            return TRACE;
        }
        if (i4 == 10000) {
            return DEBUG;
        }
        if (i4 == 20000) {
            return INFO;
        }
        if (i4 == 30000) {
            return WARN;
        }
        if (i4 != 40000) {
            return i4 != Integer.MAX_VALUE ? level : OFF;
        }
        return ERROR;
    }

    public static Level toLevel(String str, Level level) {
        if (str == null) {
            return level;
        }
        if (str.equalsIgnoreCase("ALL")) {
            return ALL;
        }
        if (str.equalsIgnoreCase("TRACE")) {
            return TRACE;
        }
        if (str.equalsIgnoreCase("DEBUG")) {
            return DEBUG;
        }
        if (str.equalsIgnoreCase("INFO")) {
            return INFO;
        }
        if (str.equalsIgnoreCase("WARN")) {
            return WARN;
        }
        if (str.equalsIgnoreCase("ERROR")) {
            return ERROR;
        }
        return str.equalsIgnoreCase("OFF") ? OFF : level;
    }
}
