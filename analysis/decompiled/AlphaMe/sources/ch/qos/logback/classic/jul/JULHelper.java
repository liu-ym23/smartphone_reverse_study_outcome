package ch.qos.logback.classic.jul;

import java.util.logging.Level;
import java.util.logging.Logger;

/* loaded from: classes.dex */
public class JULHelper {
    public static Level asJULLevel(ch.qos.logback.classic.Level level) {
        if (level == null) {
            throw new IllegalArgumentException("Unexpected level [null]");
        }
        int i4 = level.levelInt;
        if (i4 == Integer.MIN_VALUE) {
            return Level.ALL;
        }
        if (i4 == 5000) {
            return Level.FINEST;
        }
        if (i4 == 10000) {
            return Level.FINE;
        }
        if (i4 == 20000) {
            return Level.INFO;
        }
        if (i4 == 30000) {
            return Level.WARNING;
        }
        if (i4 == 40000) {
            return Level.SEVERE;
        }
        if (i4 == Integer.MAX_VALUE) {
            return Level.OFF;
        }
        throw new IllegalArgumentException("Unexpected level [" + level + "]");
    }

    public static Logger asJULLogger(String str) {
        return Logger.getLogger(asJULLoggerName(str));
    }

    public static String asJULLoggerName(String str) {
        return "ROOT".equals(str) ? "" : str;
    }

    public static final boolean isRegularNonRootLogger(Logger logger) {
        if (logger == null) {
            return false;
        }
        return !logger.getName().equals("");
    }

    public static final boolean isRoot(Logger logger) {
        if (logger == null) {
            return false;
        }
        return logger.getName().equals("");
    }

    public static Logger asJULLogger(ch.qos.logback.classic.Logger logger) {
        return asJULLogger(logger.getName());
    }
}
