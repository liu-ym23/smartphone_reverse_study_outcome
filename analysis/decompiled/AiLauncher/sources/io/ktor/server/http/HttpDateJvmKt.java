package io.ktor.server.http;

import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.time.temporal.Temporal;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.jvm.internal.p;

@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u001a\u0011\u0010\u0002\u001a\u00020\u0001*\u00020\u0000¢\u0006\u0004\b\u0002\u0010\u0003\"\u0014\u0010\u0005\u001a\u00020\u00048\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0005\u0010\u0006\"\u0017\u0010\b\u001a\u00020\u00078\u0006¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000b¨\u0006\f"}, d2 = {"Ljava/time/temporal/Temporal;", "", "toHttpDateString", "(Ljava/time/temporal/Temporal;)Ljava/lang/String;", "Ljava/time/ZoneId;", "GreenwichMeanTime", "Ljava/time/ZoneId;", "Ljava/time/format/DateTimeFormatter;", "httpDateFormat", "Ljava/time/format/DateTimeFormatter;", "getHttpDateFormat", "()Ljava/time/format/DateTimeFormatter;", "ktor-server-core"}, k = 2, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class HttpDateJvmKt {
    private static final ZoneId GreenwichMeanTime;
    private static final DateTimeFormatter httpDateFormat;

    static {
        ZoneId zoneIdOf = ZoneId.of("GMT");
        p.h(zoneIdOf, "of(...)");
        GreenwichMeanTime = zoneIdOf;
        DateTimeFormatter dateTimeFormatterWithZone = DateTimeFormatter.ofPattern("EEE, dd MMM yyyy HH:mm:ss z").withLocale(Locale.US).withZone(zoneIdOf);
        p.f(dateTimeFormatterWithZone);
        httpDateFormat = dateTimeFormatterWithZone;
    }

    public static final DateTimeFormatter getHttpDateFormat() {
        return httpDateFormat;
    }

    public static final String toHttpDateString(Temporal temporal) {
        p.i(temporal, "<this>");
        String str = httpDateFormat.format(temporal);
        p.h(str, "format(...)");
        return str;
    }
}
