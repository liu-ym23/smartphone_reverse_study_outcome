package ch.qos.logback.classic.spi;

import ch.qos.logback.classic.Logger;
import java.util.Comparator;

/* loaded from: classes.dex */
public class LoggerComparator implements Comparator<Logger> {
    @Override // java.util.Comparator
    public int compare(Logger logger, Logger logger2) {
        if (logger.getName().equals(logger2.getName())) {
            return 0;
        }
        if (logger.getName().equals("ROOT")) {
            return -1;
        }
        if (logger2.getName().equals("ROOT")) {
            return 1;
        }
        return logger.getName().compareTo(logger2.getName());
    }
}
