package ch.qos.logback.classic.db;

import ch.qos.logback.classic.spi.ILoggingEvent;

/* loaded from: classes.dex */
public class DBHelper {
    public static final short EXCEPTION_EXISTS = 2;
    public static final short PROPERTIES_EXIST = 1;

    public static short computeReferenceMask(ILoggingEvent iLoggingEvent) {
        short s4 = ((iLoggingEvent.getMDCPropertyMap() != null ? iLoggingEvent.getMDCPropertyMap().keySet().size() : 0) > 0 || (iLoggingEvent.getLoggerContextVO().getPropertyMap() != null ? iLoggingEvent.getLoggerContextVO().getPropertyMap().size() : 0) > 0) ? (short) 1 : (short) 0;
        return iLoggingEvent.getThrowableProxy() != null ? (short) (s4 | 2) : s4;
    }
}
