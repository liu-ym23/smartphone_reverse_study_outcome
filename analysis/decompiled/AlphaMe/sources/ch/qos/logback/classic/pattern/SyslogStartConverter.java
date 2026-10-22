package ch.qos.logback.classic.pattern;

import B0.g;
import ch.qos.logback.classic.spi.ILoggingEvent;
import ch.qos.logback.classic.util.LevelToSyslogSeverity;
import ch.qos.logback.core.net.SyslogAppenderBase;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

/* loaded from: classes.dex */
public class SyslogStartConverter extends ClassicConverter {
    int facility;
    String localHostName;
    SimpleDateFormat simpleMonthFormat;
    SimpleDateFormat simpleTimeFormat;
    long lastTimestamp = -1;
    String timesmapStr = null;
    private final Calendar calendar = Calendar.getInstance(Locale.US);

    public String computeTimeStampString(long j4) {
        String str;
        synchronized (this) {
            try {
                if (j4 / 1000 != this.lastTimestamp) {
                    this.lastTimestamp = j4 / 1000;
                    Date date = new Date(j4);
                    this.calendar.setTime(date);
                    this.timesmapStr = String.format("%s %2d %s", this.simpleMonthFormat.format(date), Integer.valueOf(this.calendar.get(5)), this.simpleTimeFormat.format(date));
                }
                str = this.timesmapStr;
            } catch (Throwable th) {
                throw th;
            }
        }
        return str;
    }

    public String getLocalHostname() {
        try {
            return InetAddress.getLocalHost().getHostName();
        } catch (UnknownHostException e4) {
            this.addError("Could not determine local host name", e4);
            return "UNKNOWN_LOCALHOST";
        }
    }

    @Override // ch.qos.logback.core.pattern.DynamicConverter, ch.qos.logback.core.spi.LifeCycle
    public void start() {
        String firstOption = getFirstOption();
        if (firstOption == null) {
            addError("was expecting a facility string as an option");
            return;
        }
        this.facility = SyslogAppenderBase.facilityStringToint(firstOption);
        this.localHostName = getLocalHostname();
        try {
            Locale locale = Locale.US;
            this.simpleMonthFormat = new SimpleDateFormat("MMM", locale);
            this.simpleTimeFormat = new SimpleDateFormat("HH:mm:ss", locale);
            super.start();
        } catch (IllegalArgumentException e4) {
            addError("Could not instantiate SimpleDateFormat", e4);
        }
    }

    @Override // ch.qos.logback.core.pattern.Converter
    public String convert(ILoggingEvent iLoggingEvent) {
        StringBuilder sb = new StringBuilder("<");
        sb.append(LevelToSyslogSeverity.convert(iLoggingEvent) + this.facility);
        sb.append(">");
        sb.append(computeTimeStampString(iLoggingEvent.getTimeStamp()));
        sb.append(' ');
        return g.q(sb, this.localHostName, ' ');
    }
}
