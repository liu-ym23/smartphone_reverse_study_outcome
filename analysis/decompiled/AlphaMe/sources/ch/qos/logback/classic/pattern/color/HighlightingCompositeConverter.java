package ch.qos.logback.classic.pattern.color;

import ch.qos.logback.classic.spi.ILoggingEvent;
import ch.qos.logback.core.pattern.color.ANSIConstants;
import ch.qos.logback.core.pattern.color.ForegroundCompositeConverterBase;

/* loaded from: classes.dex */
public class HighlightingCompositeConverter extends ForegroundCompositeConverterBase<ILoggingEvent> {
    @Override // ch.qos.logback.core.pattern.color.ForegroundCompositeConverterBase
    public String getForegroundColorCode(ILoggingEvent iLoggingEvent) {
        int i4 = iLoggingEvent.getLevel().toInt();
        return i4 != 20000 ? i4 != 30000 ? i4 != 40000 ? ANSIConstants.DEFAULT_FG : "1;31" : ANSIConstants.RED_FG : ANSIConstants.BLUE_FG;
    }
}
