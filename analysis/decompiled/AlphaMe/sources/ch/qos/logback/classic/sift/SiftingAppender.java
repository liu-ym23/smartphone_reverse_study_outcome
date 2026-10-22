package ch.qos.logback.classic.sift;

import ch.qos.logback.classic.ClassicConstants;
import ch.qos.logback.classic.spi.ILoggingEvent;
import ch.qos.logback.core.joran.spi.DefaultClass;
import ch.qos.logback.core.sift.Discriminator;
import ch.qos.logback.core.sift.SiftingAppenderBase;
import n3.e;
import o3.a;

/* loaded from: classes.dex */
public class SiftingAppender extends SiftingAppenderBase<ILoggingEvent> {
    @Override // ch.qos.logback.core.sift.SiftingAppenderBase
    @DefaultClass(MDCBasedDiscriminator.class)
    public void setDiscriminator(Discriminator<ILoggingEvent> discriminator) {
        super.setDiscriminator(discriminator);
    }

    @Override // ch.qos.logback.core.sift.SiftingAppenderBase
    public boolean eventMarksEndOfLife(ILoggingEvent iLoggingEvent) {
        e marker = iLoggingEvent.getMarker();
        if (marker == null) {
            return false;
        }
        return ((a) marker).a(ClassicConstants.FINALIZE_SESSION_MARKER);
    }

    @Override // ch.qos.logback.core.sift.SiftingAppenderBase
    public long getTimestamp(ILoggingEvent iLoggingEvent) {
        return iLoggingEvent.getTimeStamp();
    }
}
