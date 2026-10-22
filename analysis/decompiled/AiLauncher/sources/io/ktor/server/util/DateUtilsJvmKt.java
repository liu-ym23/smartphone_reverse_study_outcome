package io.ktor.server.util;

import io.ktor.util.date.DateJvmKt;
import io.ktor.util.date.GMTDate;
import io.ktor.utils.io.InternalAPI;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZoneOffset;
import java.time.ZonedDateTime;
import java.util.Date;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.jvm.internal.p;

@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\u001a\u0011\u0010\u0002\u001a\u00020\u0001*\u00020\u0000¢\u0006\u0004\b\u0002\u0010\u0003\u001a\u0011\u0010\u0002\u001a\u00020\u0001*\u00020\u0004¢\u0006\u0004\b\u0002\u0010\u0005\u001a\u0013\u0010\b\u001a\u00020\u0007*\u00020\u0006H\u0007¢\u0006\u0004\b\b\u0010\t\u001a\u0013\u0010\n\u001a\u00020\u0004*\u00020\u0006H\u0007¢\u0006\u0004\b\n\u0010\u000b\" \u0010\r\u001a\u00020\f8\u0006X\u0087\u0004¢\u0006\u0012\n\u0004\b\r\u0010\u000e\u0012\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u000f\u0010\u0010¨\u0006\u0013"}, d2 = {"Ljava/time/Instant;", "Lio/ktor/util/date/GMTDate;", "toGMTDate", "(Ljava/time/Instant;)Lio/ktor/util/date/GMTDate;", "Ljava/time/ZonedDateTime;", "(Ljava/time/ZonedDateTime;)Lio/ktor/util/date/GMTDate;", "Ljava/util/Date;", "Ljava/time/LocalDateTime;", "toLocalDateTime", "(Ljava/util/Date;)Ljava/time/LocalDateTime;", "toZonedDateTime", "(Ljava/util/Date;)Ljava/time/ZonedDateTime;", "Ljava/time/ZoneId;", "GreenwichMeanTime", "Ljava/time/ZoneId;", "getGreenwichMeanTime", "()Ljava/time/ZoneId;", "getGreenwichMeanTime$annotations", "()V", "ktor-server-core"}, k = 2, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class DateUtilsJvmKt {
    private static final ZoneId GreenwichMeanTime;

    static {
        ZoneId zoneIdOf = ZoneId.of("GMT");
        p.h(zoneIdOf, "of(...)");
        GreenwichMeanTime = zoneIdOf;
    }

    public static final ZoneId getGreenwichMeanTime() {
        return GreenwichMeanTime;
    }

    @InternalAPI
    public static /* synthetic */ void getGreenwichMeanTime$annotations() {
    }

    public static final GMTDate toGMTDate(Instant instant) {
        p.i(instant, "<this>");
        return DateJvmKt.GMTDate(Long.valueOf(TimeUnit.SECONDS.toMillis(instant.atZone(ZoneOffset.UTC).toEpochSecond())));
    }

    @InternalAPI
    public static final LocalDateTime toLocalDateTime(Date date) {
        p.i(date, "<this>");
        LocalDateTime localDateTimeOfInstant = LocalDateTime.ofInstant(date.toInstant(), ZoneId.systemDefault());
        p.h(localDateTimeOfInstant, "ofInstant(...)");
        return localDateTimeOfInstant;
    }

    @InternalAPI
    public static final ZonedDateTime toZonedDateTime(Date date) {
        p.i(date, "<this>");
        ZonedDateTime zonedDateTimeOfInstant = ZonedDateTime.ofInstant(date.toInstant(), GreenwichMeanTime);
        p.h(zonedDateTimeOfInstant, "ofInstant(...)");
        return zonedDateTimeOfInstant;
    }

    public static final GMTDate toGMTDate(ZonedDateTime zonedDateTime) {
        p.i(zonedDateTime, "<this>");
        Instant instant = zonedDateTime.toInstant();
        p.h(instant, "toInstant(...)");
        return toGMTDate(instant);
    }
}
