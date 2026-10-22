package ch.qos.logback.classic.pattern;

import ch.qos.logback.classic.spi.ILoggingEvent;
import n3.e;

/* loaded from: classes.dex */
public class MarkerConverter extends ClassicConverter {
    private static String EMPTY = "";

    @Override // ch.qos.logback.core.pattern.Converter
    public String convert(ILoggingEvent iLoggingEvent) {
        e marker = iLoggingEvent.getMarker();
        return marker == null ? EMPTY : marker.toString();
    }
}
