package ch.qos.logback.classic.pattern;

import ch.qos.logback.classic.spi.ILoggingEvent;
import ch.qos.logback.core.CoreConstants;
import ch.qos.logback.core.util.CachingDateFormatter;
import java.util.List;
import java.util.TimeZone;

/* loaded from: classes.dex */
public class DateConverter extends ClassicConverter {
    long lastTimestamp = -1;
    String timestampStrCache = null;
    CachingDateFormatter cachingDateFormatter = null;

    @Override // ch.qos.logback.core.pattern.DynamicConverter, ch.qos.logback.core.spi.LifeCycle
    public void start() {
        String firstOption = getFirstOption();
        if (firstOption == null) {
            firstOption = CoreConstants.ISO8601_PATTERN;
        }
        if (firstOption.equals(CoreConstants.ISO8601_STR)) {
            firstOption = CoreConstants.ISO8601_PATTERN;
        }
        try {
            this.cachingDateFormatter = new CachingDateFormatter(firstOption);
        } catch (IllegalArgumentException e4) {
            addWarn("Could not instantiate SimpleDateFormat with pattern ".concat(firstOption), e4);
            this.cachingDateFormatter = new CachingDateFormatter(CoreConstants.ISO8601_PATTERN);
        }
        List<String> optionList = getOptionList();
        if (optionList == null || optionList.size() <= 1) {
            return;
        }
        this.cachingDateFormatter.setTimeZone(TimeZone.getTimeZone(optionList.get(1)));
    }

    @Override // ch.qos.logback.core.pattern.Converter
    public String convert(ILoggingEvent iLoggingEvent) {
        return this.cachingDateFormatter.format(iLoggingEvent.getTimeStamp());
    }
}
