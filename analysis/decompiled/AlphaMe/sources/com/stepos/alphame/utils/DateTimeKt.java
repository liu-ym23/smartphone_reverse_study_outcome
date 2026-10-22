package com.stepos.alphame.utils;

import java.time.DayOfWeek;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoField;
import java.time.temporal.ChronoUnit;
import java.time.temporal.Temporal;
import java.time.temporal.TemporalAdjuster;
import java.time.temporal.TemporalAdjusters;
import java.time.temporal.TemporalUnit;
import java.util.Calendar;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.PropertyReference0Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KProperty;
import kotlin.time.DurationKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000N\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0010\u001a\u001a\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\b\u0010\n\u001a\u0004\u0018\u00010\u000bH\u0002\u001a\u0016\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u000f\u001a\u001a\u0010\u0011\u001a\u00020\u0012*\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u000f2\u0006\u0010\u0014\u001a\u00020\u0015\u001a\u001a\u0010\u0011\u001a\u00020\u0016*\u00020\u00162\u0006\u0010\u0013\u001a\u00020\u000f2\u0006\u0010\u0014\u001a\u00020\u0015\u001a\n\u0010\u0017\u001a\u00020\u0012*\u00020\u0012\u001a\n\u0010\u0017\u001a\u00020\u0016*\u00020\u0016\u001a\n\u0010\u0018\u001a\u00020\u0012*\u00020\u0012\u001a\n\u0010\u0018\u001a\u00020\u0016*\u00020\u0016\u001a\n\u0010\u0019\u001a\u00020\u0012*\u00020\u0012\u001a\n\u0010\u0019\u001a\u00020\u0016*\u00020\u0016\u001a\n\u0010\u001a\u001a\u00020\u0012*\u00020\u0012\u001a\n\u0010\u001a\u001a\u00020\u0016*\u00020\u0016\u001a\n\u0010\u001b\u001a\u00020\u0012*\u00020\u0012\u001a\n\u0010\u001b\u001a\u00020\u0016*\u00020\u0016\u001a\n\u0010\u001c\u001a\u00020\u0012*\u00020\u0012\u001a\n\u0010\u001c\u001a\u00020\u0016*\u00020\u0016\u001a\u0012\u0010\u001d\u001a\u00020\u0012*\u00020\u00122\u0006\u0010\u0014\u001a\u00020\u0015\u001a\u0012\u0010\u001d\u001a\u00020\u0016*\u00020\u00162\u0006\u0010\u0014\u001a\u00020\u0015\u001a(\u0010\u001e\u001a\u00020\t*\u00020\u001f2\u0006\u0010\b\u001a\u00020\t2\b\b\u0002\u0010 \u001a\u00020\u00012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000b\u001a\u001e\u0010\u001e\u001a\u00020\t*\u00020\u00122\u0006\u0010\b\u001a\u00020\t2\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000b\u001a\u001e\u0010\u001e\u001a\u00020\t*\u00020\u00162\u0006\u0010\b\u001a\u00020\t2\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000b\u001a\u0014\u0010!\u001a\u00020\"*\u00020\u00122\b\b\u0002\u0010 \u001a\u00020\u0001\u001a\u0014\u0010!\u001a\u00020\"*\u00020\u00162\b\b\u0002\u0010 \u001a\u00020\u0001\u001a\u0014\u0010#\u001a\u00020\"*\u00020\u00122\b\b\u0002\u0010 \u001a\u00020\u0001\u001a\u0014\u0010#\u001a\u00020\"*\u00020\u00162\b\b\u0002\u0010 \u001a\u00020\u0001\u001a\n\u0010$\u001a\u00020\u0012*\u00020\u0012\u001a\n\u0010$\u001a\u00020\u0016*\u00020\u0016\u001a\n\u0010%\u001a\u00020\u0012*\u00020\u0012\u001a\n\u0010%\u001a\u00020\u0016*\u00020\u0016\u001a\u0012\u0010&\u001a\u00020\u0012*\u00020\u00122\u0006\u0010\u0014\u001a\u00020\u0015\u001a\u0012\u0010&\u001a\u00020\u0016*\u00020\u00162\u0006\u0010\u0014\u001a\u00020\u0015\u001a\u0012\u0010'\u001a\u00020\u0012*\u00020\u00122\u0006\u0010\u0014\u001a\u00020\u0015\u001a\u0012\u0010'\u001a\u00020\u0016*\u00020\u00162\u0006\u0010\u0014\u001a\u00020\u0015\u001a\u0012\u0010(\u001a\u00020\u0012*\u00020\u00122\u0006\u0010\u0014\u001a\u00020\u0015\u001a\u0012\u0010(\u001a\u00020\u0016*\u00020\u00162\u0006\u0010\u0014\u001a\u00020\u0015\u001a\u0012\u0010)\u001a\u00020\u0012*\u00020\u00122\u0006\u0010\u0014\u001a\u00020\u0015\u001a\u0012\u0010)\u001a\u00020\u0016*\u00020\u00162\u0006\u0010\u0014\u001a\u00020\u0015\u001a\u0012\u0010*\u001a\u00020\u0012*\u00020\u00122\u0006\u0010\u0014\u001a\u00020\u0015\u001a\u0012\u0010*\u001a\u00020\u0016*\u00020\u00162\u0006\u0010\u0014\u001a\u00020\u0015\u001a\u0014\u0010+\u001a\u00020\r*\u00020\u00162\b\b\u0002\u0010 \u001a\u00020\u0001\u001a\u001c\u0010,\u001a\u00020\r*\u00020\t2\u0006\u0010\b\u001a\u00020\t2\b\b\u0002\u0010 \u001a\u00020\u0001\u001a\u0014\u0010-\u001a\u00020\r*\u00020\u00162\b\b\u0002\u0010 \u001a\u00020\u0001\u001a\u001c\u0010.\u001a\u00020\r*\u00020\t2\u0006\u0010\b\u001a\u00020\t2\b\b\u0002\u0010 \u001a\u00020\u0001\u001a\u0014\u0010/\u001a\u00020\u001f*\u00020\u00162\b\b\u0002\u0010 \u001a\u00020\u0001\u001a\u001c\u0010/\u001a\u00020\u001f*\u00020\t2\u0006\u0010\b\u001a\u00020\t2\b\b\u0002\u0010 \u001a\u00020\u0001\u001a\u0012\u00100\u001a\u00020\u0012*\u00020\t2\u0006\u0010\b\u001a\u00020\t\u001a\u0014\u00101\u001a\u00020\u0016*\u00020\u001f2\b\b\u0002\u0010 \u001a\u00020\u0001\u001a\u0012\u00101\u001a\u00020\u0016*\u00020\t2\u0006\u0010\b\u001a\u00020\t\"\u001b\u0010\u0000\u001a\u00020\u00018FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0002\u0010\u0003¨\u00062"}, d2 = {"systemZoneId", "Ljava/time/ZoneId;", "getSystemZoneId", "()Ljava/time/ZoneId;", "systemZoneId$delegate", "Lcom/stepos/alphame/utils/DateTimeKt$systemZoneId$2;", "dateTimeFormatterOf", "Ljava/time/format/DateTimeFormatter;", "pattern", "", "locale", "Ljava/util/Locale;", "getCustomTimestamp", "", "hour", "", "min", "dayOfWeekInMonth", "Ljava/time/LocalDate;", "ordinal", "dayOfWeek", "Ljava/time/DayOfWeek;", "Ljava/time/LocalDateTime;", "firstDayOfLastMonth", "firstDayOfLastYear", "firstDayOfMonth", "firstDayOfNextMonth", "firstDayOfNextYear", "firstDayOfYear", "firstInMonth", "format", "Ljava/time/Instant;", "zone", "isToday", "", "isYesterday", "lastDayOfMonth", "lastDayOfYear", "lastInMonth", "next", "nextOrSame", "previous", "previousOrSame", "toEpochMilli", "toEpochMilliseconds", "toEpochSecond", "toEpochSeconds", "toInstant", "toLocalDate", "toLocalDateTime", "app_release"}, k = 2, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes.dex */
public final class DateTimeKt {
    static final /* synthetic */ KProperty<Object>[] $$delegatedProperties = {Reflection.property0(new PropertyReference0Impl(DateTimeKt.class, "systemZoneId", "getSystemZoneId()Ljava/time/ZoneId;", 1))};

    @NotNull
    private static final DateTimeKt$systemZoneId$2 systemZoneId$delegate = new DateTimeKt$systemZoneId$2();

    private static final DateTimeFormatter dateTimeFormatterOf(String str, Locale locale) {
        if (locale != null) {
            DateTimeFormatter dateTimeFormatterOfPattern = DateTimeFormatter.ofPattern(str, locale);
            Intrinsics.checkNotNull(dateTimeFormatterOfPattern);
            return dateTimeFormatterOfPattern;
        }
        DateTimeFormatter dateTimeFormatterOfPattern2 = DateTimeFormatter.ofPattern(str);
        Intrinsics.checkNotNull(dateTimeFormatterOfPattern2);
        return dateTimeFormatterOfPattern2;
    }

    @NotNull
    public static final LocalDateTime dayOfWeekInMonth(@NotNull LocalDateTime localDateTime, int i4, @NotNull DayOfWeek dayOfWeek) {
        Intrinsics.checkNotNullParameter(localDateTime, "<this>");
        Intrinsics.checkNotNullParameter(dayOfWeek, "dayOfWeek");
        LocalDateTime localDateTimeWith = localDateTime.with(TemporalAdjusters.dayOfWeekInMonth(i4, dayOfWeek));
        Intrinsics.checkNotNullExpressionValue(localDateTimeWith, "with(...)");
        return localDateTimeWith;
    }

    @NotNull
    public static final LocalDateTime firstDayOfLastMonth(@NotNull LocalDateTime localDateTime) {
        Intrinsics.checkNotNullParameter(localDateTime, "<this>");
        LocalDateTime localDateTimeWith = localDateTime.with((TemporalAdjuster) new a(1));
        Intrinsics.checkNotNullExpressionValue(localDateTimeWith, "with(...)");
        return localDateTimeWith;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Temporal firstDayOfLastMonth$lambda$1(Temporal temporal) {
        return temporal.with(ChronoField.DAY_OF_MONTH, 1L).minus(1L, ChronoUnit.MONTHS);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Temporal firstDayOfLastMonth$lambda$3(Temporal temporal) {
        return temporal.with(ChronoField.DAY_OF_MONTH, 1L).minus(1L, ChronoUnit.MONTHS);
    }

    @NotNull
    public static final LocalDateTime firstDayOfLastYear(@NotNull LocalDateTime localDateTime) {
        Intrinsics.checkNotNullParameter(localDateTime, "<this>");
        LocalDateTime localDateTimeWith = localDateTime.with((TemporalAdjuster) new a(2));
        Intrinsics.checkNotNullExpressionValue(localDateTimeWith, "with(...)");
        return localDateTimeWith;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Temporal firstDayOfLastYear$lambda$0(Temporal temporal) {
        return temporal.with(ChronoField.DAY_OF_YEAR, 1L).minus(1L, ChronoUnit.YEARS);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Temporal firstDayOfLastYear$lambda$2(Temporal temporal) {
        return temporal.with(ChronoField.DAY_OF_YEAR, 1L).minus(1L, ChronoUnit.YEARS);
    }

    @NotNull
    public static final LocalDateTime firstDayOfMonth(@NotNull LocalDateTime localDateTime) {
        Intrinsics.checkNotNullParameter(localDateTime, "<this>");
        LocalDateTime localDateTimeWith = localDateTime.with(TemporalAdjusters.firstDayOfMonth());
        Intrinsics.checkNotNullExpressionValue(localDateTimeWith, "with(...)");
        return localDateTimeWith;
    }

    @NotNull
    public static final LocalDateTime firstDayOfNextMonth(@NotNull LocalDateTime localDateTime) {
        Intrinsics.checkNotNullParameter(localDateTime, "<this>");
        LocalDateTime localDateTimeWith = localDateTime.with(TemporalAdjusters.firstDayOfNextMonth());
        Intrinsics.checkNotNullExpressionValue(localDateTimeWith, "with(...)");
        return localDateTimeWith;
    }

    @NotNull
    public static final LocalDateTime firstDayOfNextYear(@NotNull LocalDateTime localDateTime) {
        Intrinsics.checkNotNullParameter(localDateTime, "<this>");
        LocalDateTime localDateTimeWith = localDateTime.with(TemporalAdjusters.firstDayOfNextYear());
        Intrinsics.checkNotNullExpressionValue(localDateTimeWith, "with(...)");
        return localDateTimeWith;
    }

    @NotNull
    public static final LocalDateTime firstDayOfYear(@NotNull LocalDateTime localDateTime) {
        Intrinsics.checkNotNullParameter(localDateTime, "<this>");
        LocalDateTime localDateTimeWith = localDateTime.with(TemporalAdjusters.firstDayOfYear());
        Intrinsics.checkNotNullExpressionValue(localDateTimeWith, "with(...)");
        return localDateTimeWith;
    }

    @NotNull
    public static final LocalDateTime firstInMonth(@NotNull LocalDateTime localDateTime, @NotNull DayOfWeek dayOfWeek) {
        Intrinsics.checkNotNullParameter(localDateTime, "<this>");
        Intrinsics.checkNotNullParameter(dayOfWeek, "dayOfWeek");
        LocalDateTime localDateTimeWith = localDateTime.with(TemporalAdjusters.firstInMonth(dayOfWeek));
        Intrinsics.checkNotNullExpressionValue(localDateTimeWith, "with(...)");
        return localDateTimeWith;
    }

    @NotNull
    public static final String format(@NotNull Instant instant, @NotNull String pattern, @NotNull ZoneId zone, @Nullable Locale locale) {
        Intrinsics.checkNotNullParameter(instant, "<this>");
        Intrinsics.checkNotNullParameter(pattern, "pattern");
        Intrinsics.checkNotNullParameter(zone, "zone");
        String str = dateTimeFormatterOf(pattern, locale).withZone(zone).format(instant);
        Intrinsics.checkNotNullExpressionValue(str, "format(...)");
        return str;
    }

    public static /* synthetic */ String format$default(Instant instant, String str, ZoneId zoneId, Locale locale, int i4, Object obj) {
        if ((i4 & 2) != 0) {
            zoneId = getSystemZoneId();
        }
        if ((i4 & 4) != 0) {
            locale = null;
        }
        return format(instant, str, zoneId, locale);
    }

    public static final long getCustomTimestamp(int i4, int i5) {
        Calendar calendar = Calendar.getInstance();
        calendar.set(11, i4);
        calendar.set(12, i5);
        calendar.set(13, 0);
        return calendar.getTimeInMillis();
    }

    @NotNull
    public static final ZoneId getSystemZoneId() {
        return systemZoneId$delegate.getValue2((Object) null, $$delegatedProperties[0]);
    }

    public static final boolean isToday(@NotNull LocalDateTime localDateTime, @NotNull ZoneId zone) {
        Intrinsics.checkNotNullParameter(localDateTime, "<this>");
        Intrinsics.checkNotNullParameter(zone, "zone");
        LocalDate localDate = localDateTime.toLocalDate();
        Intrinsics.checkNotNullExpressionValue(localDate, "toLocalDate(...)");
        return isToday(localDate, zone);
    }

    public static /* synthetic */ boolean isToday$default(LocalDateTime localDateTime, ZoneId zoneId, int i4, Object obj) {
        if ((i4 & 1) != 0) {
            zoneId = getSystemZoneId();
        }
        return isToday(localDateTime, zoneId);
    }

    public static final boolean isYesterday(@NotNull LocalDateTime localDateTime, @NotNull ZoneId zone) {
        Intrinsics.checkNotNullParameter(localDateTime, "<this>");
        Intrinsics.checkNotNullParameter(zone, "zone");
        LocalDate localDate = localDateTime.toLocalDate();
        Intrinsics.checkNotNullExpressionValue(localDate, "toLocalDate(...)");
        return isYesterday(localDate, zone);
    }

    public static /* synthetic */ boolean isYesterday$default(LocalDateTime localDateTime, ZoneId zoneId, int i4, Object obj) {
        if ((i4 & 1) != 0) {
            zoneId = getSystemZoneId();
        }
        return isYesterday(localDateTime, zoneId);
    }

    @NotNull
    public static final LocalDateTime lastDayOfMonth(@NotNull LocalDateTime localDateTime) {
        Intrinsics.checkNotNullParameter(localDateTime, "<this>");
        LocalDateTime localDateTimeWith = localDateTime.with(TemporalAdjusters.lastDayOfMonth());
        Intrinsics.checkNotNullExpressionValue(localDateTimeWith, "with(...)");
        return localDateTimeWith;
    }

    @NotNull
    public static final LocalDateTime lastDayOfYear(@NotNull LocalDateTime localDateTime) {
        Intrinsics.checkNotNullParameter(localDateTime, "<this>");
        LocalDateTime localDateTimeWith = localDateTime.with(TemporalAdjusters.lastDayOfYear());
        Intrinsics.checkNotNullExpressionValue(localDateTimeWith, "with(...)");
        return localDateTimeWith;
    }

    @NotNull
    public static final LocalDateTime lastInMonth(@NotNull LocalDateTime localDateTime, @NotNull DayOfWeek dayOfWeek) {
        Intrinsics.checkNotNullParameter(localDateTime, "<this>");
        Intrinsics.checkNotNullParameter(dayOfWeek, "dayOfWeek");
        LocalDateTime localDateTimeWith = localDateTime.with(TemporalAdjusters.lastInMonth(dayOfWeek));
        Intrinsics.checkNotNullExpressionValue(localDateTimeWith, "with(...)");
        return localDateTimeWith;
    }

    @NotNull
    public static final LocalDateTime next(@NotNull LocalDateTime localDateTime, @NotNull DayOfWeek dayOfWeek) {
        Intrinsics.checkNotNullParameter(localDateTime, "<this>");
        Intrinsics.checkNotNullParameter(dayOfWeek, "dayOfWeek");
        LocalDateTime localDateTimeWith = localDateTime.with(TemporalAdjusters.next(dayOfWeek));
        Intrinsics.checkNotNullExpressionValue(localDateTimeWith, "with(...)");
        return localDateTimeWith;
    }

    @NotNull
    public static final LocalDateTime nextOrSame(@NotNull LocalDateTime localDateTime, @NotNull DayOfWeek dayOfWeek) {
        Intrinsics.checkNotNullParameter(localDateTime, "<this>");
        Intrinsics.checkNotNullParameter(dayOfWeek, "dayOfWeek");
        LocalDateTime localDateTimeWith = localDateTime.with(TemporalAdjusters.nextOrSame(dayOfWeek));
        Intrinsics.checkNotNullExpressionValue(localDateTimeWith, "with(...)");
        return localDateTimeWith;
    }

    @NotNull
    public static final LocalDateTime previous(@NotNull LocalDateTime localDateTime, @NotNull DayOfWeek dayOfWeek) {
        Intrinsics.checkNotNullParameter(localDateTime, "<this>");
        Intrinsics.checkNotNullParameter(dayOfWeek, "dayOfWeek");
        LocalDateTime localDateTimeWith = localDateTime.with(TemporalAdjusters.previous(dayOfWeek));
        Intrinsics.checkNotNullExpressionValue(localDateTimeWith, "with(...)");
        return localDateTimeWith;
    }

    @NotNull
    public static final LocalDateTime previousOrSame(@NotNull LocalDateTime localDateTime, @NotNull DayOfWeek dayOfWeek) {
        Intrinsics.checkNotNullParameter(localDateTime, "<this>");
        Intrinsics.checkNotNullParameter(dayOfWeek, "dayOfWeek");
        LocalDateTime localDateTimeWith = localDateTime.with(TemporalAdjusters.previousOrSame(dayOfWeek));
        Intrinsics.checkNotNullExpressionValue(localDateTimeWith, "with(...)");
        return localDateTimeWith;
    }

    public static final long toEpochMilli(@NotNull LocalDateTime localDateTime, @NotNull ZoneId zone) {
        Intrinsics.checkNotNullParameter(localDateTime, "<this>");
        Intrinsics.checkNotNullParameter(zone, "zone");
        return (toEpochSecond(localDateTime, zone) * 1000) + (localDateTime.toLocalTime().getNano() / DurationKt.NANOS_IN_MILLIS);
    }

    public static /* synthetic */ long toEpochMilli$default(LocalDateTime localDateTime, ZoneId zoneId, int i4, Object obj) {
        if ((i4 & 1) != 0) {
            zoneId = getSystemZoneId();
        }
        return toEpochMilli(localDateTime, zoneId);
    }

    public static final long toEpochMilliseconds(@NotNull String str, @NotNull String pattern, @NotNull ZoneId zone) {
        Intrinsics.checkNotNullParameter(str, "<this>");
        Intrinsics.checkNotNullParameter(pattern, "pattern");
        Intrinsics.checkNotNullParameter(zone, "zone");
        return toInstant(str, pattern, zone).toEpochMilli();
    }

    public static /* synthetic */ long toEpochMilliseconds$default(String str, String str2, ZoneId zoneId, int i4, Object obj) {
        if ((i4 & 2) != 0) {
            zoneId = getSystemZoneId();
        }
        return toEpochMilliseconds(str, str2, zoneId);
    }

    public static final long toEpochSecond(@NotNull LocalDateTime localDateTime, @NotNull ZoneId zone) {
        Intrinsics.checkNotNullParameter(localDateTime, "<this>");
        Intrinsics.checkNotNullParameter(zone, "zone");
        return localDateTime.atZone(zone).toEpochSecond();
    }

    public static /* synthetic */ long toEpochSecond$default(LocalDateTime localDateTime, ZoneId zoneId, int i4, Object obj) {
        if ((i4 & 1) != 0) {
            zoneId = getSystemZoneId();
        }
        return toEpochSecond(localDateTime, zoneId);
    }

    public static final long toEpochSeconds(@NotNull String str, @NotNull String pattern, @NotNull ZoneId zone) {
        Intrinsics.checkNotNullParameter(str, "<this>");
        Intrinsics.checkNotNullParameter(pattern, "pattern");
        Intrinsics.checkNotNullParameter(zone, "zone");
        return toInstant(str, pattern, zone).getEpochSecond();
    }

    public static /* synthetic */ long toEpochSeconds$default(String str, String str2, ZoneId zoneId, int i4, Object obj) {
        if ((i4 & 2) != 0) {
            zoneId = getSystemZoneId();
        }
        return toEpochSeconds(str, str2, zoneId);
    }

    @NotNull
    public static final Instant toInstant(@NotNull LocalDateTime localDateTime, @NotNull ZoneId zone) {
        Intrinsics.checkNotNullParameter(localDateTime, "<this>");
        Intrinsics.checkNotNullParameter(zone, "zone");
        Instant instant = localDateTime.atZone(zone).toInstant();
        Intrinsics.checkNotNullExpressionValue(instant, "toInstant(...)");
        return instant;
    }

    public static /* synthetic */ Instant toInstant$default(LocalDateTime localDateTime, ZoneId zoneId, int i4, Object obj) {
        if ((i4 & 1) != 0) {
            zoneId = getSystemZoneId();
        }
        return toInstant(localDateTime, zoneId);
    }

    @NotNull
    public static final LocalDate toLocalDate(@NotNull String str, @NotNull String pattern) {
        Intrinsics.checkNotNullParameter(str, "<this>");
        Intrinsics.checkNotNullParameter(pattern, "pattern");
        LocalDate localDate = LocalDate.parse(str, DateTimeFormatter.ofPattern(pattern));
        Intrinsics.checkNotNullExpressionValue(localDate, "parse(...)");
        return localDate;
    }

    @NotNull
    public static final LocalDateTime toLocalDateTime(@NotNull Instant instant, @NotNull ZoneId zone) {
        Intrinsics.checkNotNullParameter(instant, "<this>");
        Intrinsics.checkNotNullParameter(zone, "zone");
        LocalDateTime localDateTimeOfInstant = LocalDateTime.ofInstant(instant, zone);
        Intrinsics.checkNotNullExpressionValue(localDateTimeOfInstant, "ofInstant(...)");
        return localDateTimeOfInstant;
    }

    public static /* synthetic */ LocalDateTime toLocalDateTime$default(Instant instant, ZoneId zoneId, int i4, Object obj) {
        if ((i4 & 1) != 0) {
            zoneId = getSystemZoneId();
        }
        return toLocalDateTime(instant, zoneId);
    }

    @NotNull
    public static final LocalDate dayOfWeekInMonth(@NotNull LocalDate localDate, int i4, @NotNull DayOfWeek dayOfWeek) {
        Intrinsics.checkNotNullParameter(localDate, "<this>");
        Intrinsics.checkNotNullParameter(dayOfWeek, "dayOfWeek");
        LocalDate localDateWith = localDate.with(TemporalAdjusters.dayOfWeekInMonth(i4, dayOfWeek));
        Intrinsics.checkNotNullExpressionValue(localDateWith, "with(...)");
        return localDateWith;
    }

    @NotNull
    public static final LocalDate firstDayOfLastMonth(@NotNull LocalDate localDate) {
        Intrinsics.checkNotNullParameter(localDate, "<this>");
        LocalDate localDateWith = localDate.with((TemporalAdjuster) new a(3));
        Intrinsics.checkNotNullExpressionValue(localDateWith, "with(...)");
        return localDateWith;
    }

    @NotNull
    public static final LocalDate firstDayOfLastYear(@NotNull LocalDate localDate) {
        Intrinsics.checkNotNullParameter(localDate, "<this>");
        LocalDate localDateWith = localDate.with((TemporalAdjuster) new a(0));
        Intrinsics.checkNotNullExpressionValue(localDateWith, "with(...)");
        return localDateWith;
    }

    @NotNull
    public static final LocalDate firstDayOfMonth(@NotNull LocalDate localDate) {
        Intrinsics.checkNotNullParameter(localDate, "<this>");
        LocalDate localDateWith = localDate.with(TemporalAdjusters.firstDayOfMonth());
        Intrinsics.checkNotNullExpressionValue(localDateWith, "with(...)");
        return localDateWith;
    }

    @NotNull
    public static final LocalDate firstDayOfNextMonth(@NotNull LocalDate localDate) {
        Intrinsics.checkNotNullParameter(localDate, "<this>");
        LocalDate localDateWith = localDate.with(TemporalAdjusters.firstDayOfNextMonth());
        Intrinsics.checkNotNullExpressionValue(localDateWith, "with(...)");
        return localDateWith;
    }

    @NotNull
    public static final LocalDate firstDayOfNextYear(@NotNull LocalDate localDate) {
        Intrinsics.checkNotNullParameter(localDate, "<this>");
        LocalDate localDateWith = localDate.with(TemporalAdjusters.firstDayOfNextYear());
        Intrinsics.checkNotNullExpressionValue(localDateWith, "with(...)");
        return localDateWith;
    }

    @NotNull
    public static final LocalDate firstDayOfYear(@NotNull LocalDate localDate) {
        Intrinsics.checkNotNullParameter(localDate, "<this>");
        LocalDate localDateWith = localDate.with(TemporalAdjusters.firstDayOfYear());
        Intrinsics.checkNotNullExpressionValue(localDateWith, "with(...)");
        return localDateWith;
    }

    @NotNull
    public static final LocalDate firstInMonth(@NotNull LocalDate localDate, @NotNull DayOfWeek dayOfWeek) {
        Intrinsics.checkNotNullParameter(localDate, "<this>");
        Intrinsics.checkNotNullParameter(dayOfWeek, "dayOfWeek");
        LocalDate localDateWith = localDate.with(TemporalAdjusters.firstInMonth(dayOfWeek));
        Intrinsics.checkNotNullExpressionValue(localDateWith, "with(...)");
        return localDateWith;
    }

    @NotNull
    public static final String format(@NotNull LocalDateTime localDateTime, @NotNull String pattern, @Nullable Locale locale) {
        Intrinsics.checkNotNullParameter(localDateTime, "<this>");
        Intrinsics.checkNotNullParameter(pattern, "pattern");
        String str = dateTimeFormatterOf(pattern, locale).format(localDateTime);
        Intrinsics.checkNotNullExpressionValue(str, "format(...)");
        return str;
    }

    public static /* synthetic */ String format$default(LocalDateTime localDateTime, String str, Locale locale, int i4, Object obj) {
        if ((i4 & 2) != 0) {
            locale = null;
        }
        return format(localDateTime, str, locale);
    }

    public static final boolean isToday(@NotNull LocalDate localDate, @NotNull ZoneId zone) {
        Intrinsics.checkNotNullParameter(localDate, "<this>");
        Intrinsics.checkNotNullParameter(zone, "zone");
        return Intrinsics.areEqual(localDate, LocalDate.now(zone));
    }

    public static /* synthetic */ boolean isToday$default(LocalDate localDate, ZoneId zoneId, int i4, Object obj) {
        if ((i4 & 1) != 0) {
            zoneId = getSystemZoneId();
        }
        return isToday(localDate, zoneId);
    }

    public static final boolean isYesterday(@NotNull LocalDate localDate, @NotNull ZoneId zone) {
        Intrinsics.checkNotNullParameter(localDate, "<this>");
        Intrinsics.checkNotNullParameter(zone, "zone");
        return Intrinsics.areEqual(localDate, LocalDate.now(zone).minus(1L, (TemporalUnit) ChronoUnit.DAYS));
    }

    public static /* synthetic */ boolean isYesterday$default(LocalDate localDate, ZoneId zoneId, int i4, Object obj) {
        if ((i4 & 1) != 0) {
            zoneId = getSystemZoneId();
        }
        return isYesterday(localDate, zoneId);
    }

    @NotNull
    public static final LocalDate lastDayOfMonth(@NotNull LocalDate localDate) {
        Intrinsics.checkNotNullParameter(localDate, "<this>");
        LocalDate localDateWith = localDate.with(TemporalAdjusters.lastDayOfMonth());
        Intrinsics.checkNotNullExpressionValue(localDateWith, "with(...)");
        return localDateWith;
    }

    @NotNull
    public static final LocalDate lastDayOfYear(@NotNull LocalDate localDate) {
        Intrinsics.checkNotNullParameter(localDate, "<this>");
        LocalDate localDateWith = localDate.with(TemporalAdjusters.lastDayOfYear());
        Intrinsics.checkNotNullExpressionValue(localDateWith, "with(...)");
        return localDateWith;
    }

    @NotNull
    public static final LocalDate lastInMonth(@NotNull LocalDate localDate, @NotNull DayOfWeek dayOfWeek) {
        Intrinsics.checkNotNullParameter(localDate, "<this>");
        Intrinsics.checkNotNullParameter(dayOfWeek, "dayOfWeek");
        LocalDate localDateWith = localDate.with(TemporalAdjusters.lastInMonth(dayOfWeek));
        Intrinsics.checkNotNullExpressionValue(localDateWith, "with(...)");
        return localDateWith;
    }

    @NotNull
    public static final LocalDate next(@NotNull LocalDate localDate, @NotNull DayOfWeek dayOfWeek) {
        Intrinsics.checkNotNullParameter(localDate, "<this>");
        Intrinsics.checkNotNullParameter(dayOfWeek, "dayOfWeek");
        LocalDate localDateWith = localDate.with(TemporalAdjusters.next(dayOfWeek));
        Intrinsics.checkNotNullExpressionValue(localDateWith, "with(...)");
        return localDateWith;
    }

    @NotNull
    public static final LocalDate nextOrSame(@NotNull LocalDate localDate, @NotNull DayOfWeek dayOfWeek) {
        Intrinsics.checkNotNullParameter(localDate, "<this>");
        Intrinsics.checkNotNullParameter(dayOfWeek, "dayOfWeek");
        LocalDate localDateWith = localDate.with(TemporalAdjusters.nextOrSame(dayOfWeek));
        Intrinsics.checkNotNullExpressionValue(localDateWith, "with(...)");
        return localDateWith;
    }

    @NotNull
    public static final LocalDate previous(@NotNull LocalDate localDate, @NotNull DayOfWeek dayOfWeek) {
        Intrinsics.checkNotNullParameter(localDate, "<this>");
        Intrinsics.checkNotNullParameter(dayOfWeek, "dayOfWeek");
        LocalDate localDateWith = localDate.with(TemporalAdjusters.previous(dayOfWeek));
        Intrinsics.checkNotNullExpressionValue(localDateWith, "with(...)");
        return localDateWith;
    }

    @NotNull
    public static final LocalDate previousOrSame(@NotNull LocalDate localDate, @NotNull DayOfWeek dayOfWeek) {
        Intrinsics.checkNotNullParameter(localDate, "<this>");
        Intrinsics.checkNotNullParameter(dayOfWeek, "dayOfWeek");
        LocalDate localDateWith = localDate.with(TemporalAdjusters.previousOrSame(dayOfWeek));
        Intrinsics.checkNotNullExpressionValue(localDateWith, "with(...)");
        return localDateWith;
    }

    @NotNull
    public static final Instant toInstant(@NotNull String str, @NotNull String pattern, @NotNull ZoneId zone) {
        Intrinsics.checkNotNullParameter(str, "<this>");
        Intrinsics.checkNotNullParameter(pattern, "pattern");
        Intrinsics.checkNotNullParameter(zone, "zone");
        Instant instant = ZonedDateTime.parse(str, DateTimeFormatter.ofPattern(pattern).withZone(zone)).toInstant();
        Intrinsics.checkNotNullExpressionValue(instant, "toInstant(...)");
        return instant;
    }

    public static /* synthetic */ Instant toInstant$default(String str, String str2, ZoneId zoneId, int i4, Object obj) {
        if ((i4 & 2) != 0) {
            zoneId = getSystemZoneId();
        }
        return toInstant(str, str2, zoneId);
    }

    @NotNull
    public static final LocalDateTime toLocalDateTime(@NotNull String str, @NotNull String pattern) {
        Intrinsics.checkNotNullParameter(str, "<this>");
        Intrinsics.checkNotNullParameter(pattern, "pattern");
        LocalDateTime localDateTime = LocalDateTime.parse(str, DateTimeFormatter.ofPattern(pattern));
        Intrinsics.checkNotNullExpressionValue(localDateTime, "parse(...)");
        return localDateTime;
    }

    @NotNull
    public static final String format(@NotNull LocalDate localDate, @NotNull String pattern, @Nullable Locale locale) {
        Intrinsics.checkNotNullParameter(localDate, "<this>");
        Intrinsics.checkNotNullParameter(pattern, "pattern");
        String str = dateTimeFormatterOf(pattern, locale).format(localDate);
        Intrinsics.checkNotNullExpressionValue(str, "format(...)");
        return str;
    }

    public static /* synthetic */ String format$default(LocalDate localDate, String str, Locale locale, int i4, Object obj) {
        if ((i4 & 2) != 0) {
            locale = null;
        }
        return format(localDate, str, locale);
    }
}
