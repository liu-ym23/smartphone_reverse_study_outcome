package bytedance.jvm.time.chrono;

import bytedance.jvm.time.Clock;
import bytedance.jvm.time.Instant;
import bytedance.jvm.time.ZoneId;
import bytedance.jvm.time.ZoneOffset;
import bytedance.jvm.time.format.ResolverStyle;
import bytedance.jvm.time.temporal.ChronoField;
import bytedance.jvm.time.temporal.ValueRange;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes28.dex */
public interface j extends Comparable<j> {
    int compareTo(j r100);

    c date(int r100, int r101, int r102);

    c date(bytedance.jvm.time.temporal.d r100);

    c dateEpochDay(long r100);

    c dateNow(Clock r100);

    c dateYearDay(int r100, int r101);

    long epochSecond(int r100, int r101, int r102, int r103, int r104, int r105, ZoneOffset r106);

    boolean equals(Object r100);

    l eraOf(int r100);

    List<l> eras();

    String getCalendarType();

    String getId();

    int hashCode();

    boolean isLeapYear(long r100);

    e<? extends c> localDateTime(bytedance.jvm.time.temporal.d r100);

    int prolepticYear(l r100, int r101);

    ValueRange range(ChronoField r100);

    c resolveDate(Map<bytedance.jvm.time.temporal.j, Long> r100, ResolverStyle r101);

    String toString();

    h<? extends c> zonedDateTime(Instant r100, ZoneId r101);

    h<? extends c> zonedDateTime(bytedance.jvm.time.temporal.d r100);
}
