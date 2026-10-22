package kotlin.time;

import java.util.Collection;
import java.util.Iterator;
import kotlin.Deprecated;
import kotlin.DeprecatedSinceKotlin;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.collections.IntIterator;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;
import kotlin.ranges.CharRange;
import kotlin.ranges.IntRange;
import kotlin.ranges.LongRange;
import kotlin.ranges.RangesKt;
import kotlin.text.StringsKt;

/* JADX INFO: compiled from: Duration.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000>\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0006\n\u0002\b*\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0010\f\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0004\u001a\u001d\u0010#\u001a\u00020\u00072\u0006\u0010$\u001a\u00020\u00012\u0006\u0010%\u001a\u00020\u0005H\u0002¢\u0006\u0002\u0010&\u001a\u0015\u0010'\u001a\u00020\u00072\u0006\u0010(\u001a\u00020\u0001H\u0002¢\u0006\u0002\u0010\u0010\u001a\u0015\u0010)\u001a\u00020\u00072\u0006\u0010*\u001a\u00020\u0001H\u0002¢\u0006\u0002\u0010\u0010\u001a\u0015\u0010+\u001a\u00020\u00072\u0006\u0010,\u001a\u00020\u0001H\u0002¢\u0006\u0002\u0010\u0010\u001a\u0015\u0010-\u001a\u00020\u00072\u0006\u0010.\u001a\u00020\u0001H\u0002¢\u0006\u0002\u0010\u0010\u001a\u0010\u0010/\u001a\u00020\u00012\u0006\u0010*\u001a\u00020\u0001H\u0002\u001a\u0010\u00100\u001a\u00020\u00012\u0006\u0010.\u001a\u00020\u0001H\u0002\u001a\u001d\u00101\u001a\u00020\u00072\u0006\u00102\u001a\u0002032\u0006\u00104\u001a\u000205H\u0002¢\u0006\u0002\u00106\u001a\u0010\u00107\u001a\u00020\u00012\u0006\u00102\u001a\u000203H\u0002\u001a)\u00108\u001a\u00020\u0005*\u0002032\u0006\u00109\u001a\u00020\u00052\u0012\u0010:\u001a\u000e\u0012\u0004\u0012\u00020<\u0012\u0004\u0012\u0002050;H\u0082\b\u001a)\u0010=\u001a\u000203*\u0002032\u0006\u00109\u001a\u00020\u00052\u0012\u0010:\u001a\u000e\u0012\u0004\u0012\u00020<\u0012\u0004\u0012\u0002050;H\u0082\b\u001a\u001c\u0010>\u001a\u00020\u0007*\u00020\b2\u0006\u0010?\u001a\u00020\u0007H\u0087\n¢\u0006\u0004\b@\u0010A\u001a\u001c\u0010>\u001a\u00020\u0007*\u00020\u00052\u0006\u0010?\u001a\u00020\u0007H\u0087\n¢\u0006\u0004\bB\u0010C\u001a\u0019\u0010D\u001a\u00020\u0007*\u00020\b2\u0006\u0010E\u001a\u00020FH\u0007¢\u0006\u0002\u0010G\u001a\u0019\u0010D\u001a\u00020\u0007*\u00020\u00052\u0006\u0010E\u001a\u00020FH\u0007¢\u0006\u0002\u0010H\u001a\u0019\u0010D\u001a\u00020\u0007*\u00020\u00012\u0006\u0010E\u001a\u00020FH\u0007¢\u0006\u0002\u0010I\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0080T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0002\u001a\u00020\u0001X\u0080T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0003\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0004\u001a\u00020\u0005X\u0080T¢\u0006\u0002\n\u0000\"\u001e\u0010\u0006\u001a\u00020\u0007*\u00020\b8FX\u0087\u0004¢\u0006\f\u0012\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\f\"\u001e\u0010\u0006\u001a\u00020\u0007*\u00020\u00058FX\u0087\u0004¢\u0006\f\u0012\u0004\b\t\u0010\r\u001a\u0004\b\u000b\u0010\u000e\"\u001e\u0010\u0006\u001a\u00020\u0007*\u00020\u00018FX\u0087\u0004¢\u0006\f\u0012\u0004\b\t\u0010\u000f\u001a\u0004\b\u000b\u0010\u0010\"\u001e\u0010\u0011\u001a\u00020\u0007*\u00020\b8FX\u0087\u0004¢\u0006\f\u0012\u0004\b\u0012\u0010\n\u001a\u0004\b\u0013\u0010\f\"\u001e\u0010\u0011\u001a\u00020\u0007*\u00020\u00058FX\u0087\u0004¢\u0006\f\u0012\u0004\b\u0012\u0010\r\u001a\u0004\b\u0013\u0010\u000e\"\u001e\u0010\u0011\u001a\u00020\u0007*\u00020\u00018FX\u0087\u0004¢\u0006\f\u0012\u0004\b\u0012\u0010\u000f\u001a\u0004\b\u0013\u0010\u0010\"\u001e\u0010\u0014\u001a\u00020\u0007*\u00020\b8FX\u0087\u0004¢\u0006\f\u0012\u0004\b\u0015\u0010\n\u001a\u0004\b\u0016\u0010\f\"\u001e\u0010\u0014\u001a\u00020\u0007*\u00020\u00058FX\u0087\u0004¢\u0006\f\u0012\u0004\b\u0015\u0010\r\u001a\u0004\b\u0016\u0010\u000e\"\u001e\u0010\u0014\u001a\u00020\u0007*\u00020\u00018FX\u0087\u0004¢\u0006\f\u0012\u0004\b\u0015\u0010\u000f\u001a\u0004\b\u0016\u0010\u0010\"\u001e\u0010\u0017\u001a\u00020\u0007*\u00020\b8FX\u0087\u0004¢\u0006\f\u0012\u0004\b\u0018\u0010\n\u001a\u0004\b\u0019\u0010\f\"\u001e\u0010\u0017\u001a\u00020\u0007*\u00020\u00058FX\u0087\u0004¢\u0006\f\u0012\u0004\b\u0018\u0010\r\u001a\u0004\b\u0019\u0010\u000e\"\u001e\u0010\u0017\u001a\u00020\u0007*\u00020\u00018FX\u0087\u0004¢\u0006\f\u0012\u0004\b\u0018\u0010\u000f\u001a\u0004\b\u0019\u0010\u0010\"\u001e\u0010\u001a\u001a\u00020\u0007*\u00020\b8FX\u0087\u0004¢\u0006\f\u0012\u0004\b\u001b\u0010\n\u001a\u0004\b\u001c\u0010\f\"\u001e\u0010\u001a\u001a\u00020\u0007*\u00020\u00058FX\u0087\u0004¢\u0006\f\u0012\u0004\b\u001b\u0010\r\u001a\u0004\b\u001c\u0010\u000e\"\u001e\u0010\u001a\u001a\u00020\u0007*\u00020\u00018FX\u0087\u0004¢\u0006\f\u0012\u0004\b\u001b\u0010\u000f\u001a\u0004\b\u001c\u0010\u0010\"\u001e\u0010\u001d\u001a\u00020\u0007*\u00020\b8FX\u0087\u0004¢\u0006\f\u0012\u0004\b\u001e\u0010\n\u001a\u0004\b\u001f\u0010\f\"\u001e\u0010\u001d\u001a\u00020\u0007*\u00020\u00058FX\u0087\u0004¢\u0006\f\u0012\u0004\b\u001e\u0010\r\u001a\u0004\b\u001f\u0010\u000e\"\u001e\u0010\u001d\u001a\u00020\u0007*\u00020\u00018FX\u0087\u0004¢\u0006\f\u0012\u0004\b\u001e\u0010\u000f\u001a\u0004\b\u001f\u0010\u0010\"\u001e\u0010 \u001a\u00020\u0007*\u00020\b8FX\u0087\u0004¢\u0006\f\u0012\u0004\b!\u0010\n\u001a\u0004\b\"\u0010\f\"\u001e\u0010 \u001a\u00020\u0007*\u00020\u00058FX\u0087\u0004¢\u0006\f\u0012\u0004\b!\u0010\r\u001a\u0004\b\"\u0010\u000e\"\u001e\u0010 \u001a\u00020\u0007*\u00020\u00018FX\u0087\u0004¢\u0006\f\u0012\u0004\b!\u0010\u000f\u001a\u0004\b\"\u0010\u0010¨\u0006J"}, d2 = {"MAX_MILLIS", "", "MAX_NANOS", "MAX_NANOS_IN_MILLIS", "NANOS_IN_MILLIS", "", "days", "Lkotlin/time/Duration;", "", "getDays$annotations", "(D)V", "getDays", "(D)J", "(I)V", "(I)J", "(J)V", "(J)J", "hours", "getHours$annotations", "getHours", "microseconds", "getMicroseconds$annotations", "getMicroseconds", "milliseconds", "getMilliseconds$annotations", "getMilliseconds", "minutes", "getMinutes$annotations", "getMinutes", "nanoseconds", "getNanoseconds$annotations", "getNanoseconds", "seconds", "getSeconds$annotations", "getSeconds", "durationOf", "normalValue", "unitDiscriminator", "(JI)J", "durationOfMillis", "normalMillis", "durationOfMillisNormalized", "millis", "durationOfNanos", "normalNanos", "durationOfNanosNormalized", "nanos", "millisToNanos", "nanosToMillis", "parseDuration", "value", "", "strictIso", "", "(Ljava/lang/String;Z)J", "parseOverLongIsoComponent", "skipWhile", "startIndex", "predicate", "Lkotlin/Function1;", "", "substringWhile", "times", "duration", "times-kIfJnKk", "(DJ)J", "times-mvk6XK0", "(IJ)J", "toDuration", "unit", "Lkotlin/time/DurationUnit;", "(DLkotlin/time/DurationUnit;)J", "(ILkotlin/time/DurationUnit;)J", "(JLkotlin/time/DurationUnit;)J", "kotlin-stdlib"}, k = 2, mv = {1, 9, 0}, xi = 48)
public final class DurationKt {
    public static final long MAX_MILLIS = 4611686018427387903L;
    public static final long MAX_NANOS = 4611686018426999999L;
    private static final long MAX_NANOS_IN_MILLIS = 4611686018426L;
    public static final int NANOS_IN_MILLIS = 1000000;

    public static final /* synthetic */ long access$durationOf(long r0, int r2) {
        return durationOf(r0, r2);
    }

    public static final /* synthetic */ long access$durationOfMillis(long r0) {
        return durationOfMillis(r0);
    }

    public static final /* synthetic */ long access$durationOfMillisNormalized(long r0) {
        return durationOfMillisNormalized(r0);
    }

    public static final /* synthetic */ long access$durationOfNanos(long r0) {
        return durationOfNanos(r0);
    }

    public static final /* synthetic */ long access$durationOfNanosNormalized(long r0) {
        return durationOfNanosNormalized(r0);
    }

    public static final /* synthetic */ long access$millisToNanos(long r0) {
        return millisToNanos(r0);
    }

    public static final /* synthetic */ long access$nanosToMillis(long r0) {
        return nanosToMillis(r0);
    }

    public static final /* synthetic */ long access$parseDuration(String r0, boolean r1) {
        return parseDuration(r0, r1);
    }

    @Deprecated(message = "Use 'Double.days' extension property from Duration.Companion instead.", replaceWith = @ReplaceWith(expression = "this.days", imports = {"kotlin.time.Duration.Companion.days"}))
    @DeprecatedSinceKotlin(errorSince = "1.8", hiddenSince = "1.9", warningSince = "1.5")
    public static /* synthetic */ void getDays$annotations(double r0) {
    }

    @Deprecated(message = "Use 'Int.days' extension property from Duration.Companion instead.", replaceWith = @ReplaceWith(expression = "this.days", imports = {"kotlin.time.Duration.Companion.days"}))
    @DeprecatedSinceKotlin(errorSince = "1.8", hiddenSince = "1.9", warningSince = "1.5")
    public static /* synthetic */ void getDays$annotations(int r0) {
    }

    @Deprecated(message = "Use 'Long.days' extension property from Duration.Companion instead.", replaceWith = @ReplaceWith(expression = "this.days", imports = {"kotlin.time.Duration.Companion.days"}))
    @DeprecatedSinceKotlin(errorSince = "1.8", hiddenSince = "1.9", warningSince = "1.5")
    public static /* synthetic */ void getDays$annotations(long r0) {
    }

    @Deprecated(message = "Use 'Double.hours' extension property from Duration.Companion instead.", replaceWith = @ReplaceWith(expression = "this.hours", imports = {"kotlin.time.Duration.Companion.hours"}))
    @DeprecatedSinceKotlin(errorSince = "1.8", hiddenSince = "1.9", warningSince = "1.5")
    public static /* synthetic */ void getHours$annotations(double r0) {
    }

    @Deprecated(message = "Use 'Int.hours' extension property from Duration.Companion instead.", replaceWith = @ReplaceWith(expression = "this.hours", imports = {"kotlin.time.Duration.Companion.hours"}))
    @DeprecatedSinceKotlin(errorSince = "1.8", hiddenSince = "1.9", warningSince = "1.5")
    public static /* synthetic */ void getHours$annotations(int r0) {
    }

    @Deprecated(message = "Use 'Long.hours' extension property from Duration.Companion instead.", replaceWith = @ReplaceWith(expression = "this.hours", imports = {"kotlin.time.Duration.Companion.hours"}))
    @DeprecatedSinceKotlin(errorSince = "1.8", hiddenSince = "1.9", warningSince = "1.5")
    public static /* synthetic */ void getHours$annotations(long r0) {
    }

    @Deprecated(message = "Use 'Double.microseconds' extension property from Duration.Companion instead.", replaceWith = @ReplaceWith(expression = "this.microseconds", imports = {"kotlin.time.Duration.Companion.microseconds"}))
    @DeprecatedSinceKotlin(errorSince = "1.8", hiddenSince = "1.9", warningSince = "1.5")
    public static /* synthetic */ void getMicroseconds$annotations(double r0) {
    }

    @Deprecated(message = "Use 'Int.microseconds' extension property from Duration.Companion instead.", replaceWith = @ReplaceWith(expression = "this.microseconds", imports = {"kotlin.time.Duration.Companion.microseconds"}))
    @DeprecatedSinceKotlin(errorSince = "1.8", hiddenSince = "1.9", warningSince = "1.5")
    public static /* synthetic */ void getMicroseconds$annotations(int r0) {
    }

    @Deprecated(message = "Use 'Long.microseconds' extension property from Duration.Companion instead.", replaceWith = @ReplaceWith(expression = "this.microseconds", imports = {"kotlin.time.Duration.Companion.microseconds"}))
    @DeprecatedSinceKotlin(errorSince = "1.8", hiddenSince = "1.9", warningSince = "1.5")
    public static /* synthetic */ void getMicroseconds$annotations(long r0) {
    }

    @Deprecated(message = "Use 'Double.milliseconds' extension property from Duration.Companion instead.", replaceWith = @ReplaceWith(expression = "this.milliseconds", imports = {"kotlin.time.Duration.Companion.milliseconds"}))
    @DeprecatedSinceKotlin(errorSince = "1.8", hiddenSince = "1.9", warningSince = "1.5")
    public static /* synthetic */ void getMilliseconds$annotations(double r0) {
    }

    @Deprecated(message = "Use 'Int.milliseconds' extension property from Duration.Companion instead.", replaceWith = @ReplaceWith(expression = "this.milliseconds", imports = {"kotlin.time.Duration.Companion.milliseconds"}))
    @DeprecatedSinceKotlin(errorSince = "1.8", hiddenSince = "1.9", warningSince = "1.5")
    public static /* synthetic */ void getMilliseconds$annotations(int r0) {
    }

    @Deprecated(message = "Use 'Long.milliseconds' extension property from Duration.Companion instead.", replaceWith = @ReplaceWith(expression = "this.milliseconds", imports = {"kotlin.time.Duration.Companion.milliseconds"}))
    @DeprecatedSinceKotlin(errorSince = "1.8", hiddenSince = "1.9", warningSince = "1.5")
    public static /* synthetic */ void getMilliseconds$annotations(long r0) {
    }

    @Deprecated(message = "Use 'Double.minutes' extension property from Duration.Companion instead.", replaceWith = @ReplaceWith(expression = "this.minutes", imports = {"kotlin.time.Duration.Companion.minutes"}))
    @DeprecatedSinceKotlin(errorSince = "1.8", hiddenSince = "1.9", warningSince = "1.5")
    public static /* synthetic */ void getMinutes$annotations(double r0) {
    }

    @Deprecated(message = "Use 'Int.minutes' extension property from Duration.Companion instead.", replaceWith = @ReplaceWith(expression = "this.minutes", imports = {"kotlin.time.Duration.Companion.minutes"}))
    @DeprecatedSinceKotlin(errorSince = "1.8", hiddenSince = "1.9", warningSince = "1.5")
    public static /* synthetic */ void getMinutes$annotations(int r0) {
    }

    @Deprecated(message = "Use 'Long.minutes' extension property from Duration.Companion instead.", replaceWith = @ReplaceWith(expression = "this.minutes", imports = {"kotlin.time.Duration.Companion.minutes"}))
    @DeprecatedSinceKotlin(errorSince = "1.8", hiddenSince = "1.9", warningSince = "1.5")
    public static /* synthetic */ void getMinutes$annotations(long r0) {
    }

    @Deprecated(message = "Use 'Double.nanoseconds' extension property from Duration.Companion instead.", replaceWith = @ReplaceWith(expression = "this.nanoseconds", imports = {"kotlin.time.Duration.Companion.nanoseconds"}))
    @DeprecatedSinceKotlin(errorSince = "1.8", hiddenSince = "1.9", warningSince = "1.5")
    public static /* synthetic */ void getNanoseconds$annotations(double r0) {
    }

    @Deprecated(message = "Use 'Int.nanoseconds' extension property from Duration.Companion instead.", replaceWith = @ReplaceWith(expression = "this.nanoseconds", imports = {"kotlin.time.Duration.Companion.nanoseconds"}))
    @DeprecatedSinceKotlin(errorSince = "1.8", hiddenSince = "1.9", warningSince = "1.5")
    public static /* synthetic */ void getNanoseconds$annotations(int r0) {
    }

    @Deprecated(message = "Use 'Long.nanoseconds' extension property from Duration.Companion instead.", replaceWith = @ReplaceWith(expression = "this.nanoseconds", imports = {"kotlin.time.Duration.Companion.nanoseconds"}))
    @DeprecatedSinceKotlin(errorSince = "1.8", hiddenSince = "1.9", warningSince = "1.5")
    public static /* synthetic */ void getNanoseconds$annotations(long r0) {
    }

    @Deprecated(message = "Use 'Double.seconds' extension property from Duration.Companion instead.", replaceWith = @ReplaceWith(expression = "this.seconds", imports = {"kotlin.time.Duration.Companion.seconds"}))
    @DeprecatedSinceKotlin(errorSince = "1.8", hiddenSince = "1.9", warningSince = "1.5")
    public static /* synthetic */ void getSeconds$annotations(double r0) {
    }

    @Deprecated(message = "Use 'Int.seconds' extension property from Duration.Companion instead.", replaceWith = @ReplaceWith(expression = "this.seconds", imports = {"kotlin.time.Duration.Companion.seconds"}))
    @DeprecatedSinceKotlin(errorSince = "1.8", hiddenSince = "1.9", warningSince = "1.5")
    public static /* synthetic */ void getSeconds$annotations(int r0) {
    }

    @Deprecated(message = "Use 'Long.seconds' extension property from Duration.Companion instead.", replaceWith = @ReplaceWith(expression = "this.seconds", imports = {"kotlin.time.Duration.Companion.seconds"}))
    @DeprecatedSinceKotlin(errorSince = "1.8", hiddenSince = "1.9", warningSince = "1.5")
    public static /* synthetic */ void getSeconds$annotations(long r0) {
    }

    private static final long millisToNanos(long r2) {
        return r2 * ((long) 1000000);
    }

    public static final long toDuration(int r2, DurationUnit r3) {
        Intrinsics.checkNotNullParameter(r3, "unit");
        if (r3.compareTo(DurationUnit.SECONDS) > 0) goto L6;
        return durationOfNanos(DurationUnitKt.convertDurationUnitOverflow(r2, r3, DurationUnit.NANOSECONDS));
    L6:
        return toDuration(r2, r3);
    }

    public static final long toDuration(long r7, DurationUnit r9) {
        Intrinsics.checkNotNullParameter(r9, "unit");
        long r0 = DurationUnitKt.convertDurationUnitOverflow(MAX_NANOS, DurationUnit.NANOSECONDS, r9);
        if (new LongRange(-r0, r0).contains(r7) == false) goto L7;
        return durationOfNanos(DurationUnitKt.convertDurationUnitOverflow(r7, r9, DurationUnit.NANOSECONDS));
    L7:
        return durationOfMillis(RangesKt.coerceIn(DurationUnitKt.convertDurationUnit(r7, r9, DurationUnit.MILLISECONDS), -4611686018427387903L, MAX_MILLIS));
    }

    public static final long toDuration(double r7, DurationUnit r9) {
        Intrinsics.checkNotNullParameter(r9, "unit");
        double r0 = DurationUnitKt.convertDurationUnit(r7, r9, DurationUnit.NANOSECONDS);
        if ((!Double.isNaN(r0)) == false) goto L10;
        long r1 = MathKt.roundToLong(r0);
        if (new LongRange(-4611686018426999999L, MAX_NANOS).contains(r1) == false) goto L8;
        return durationOfNanos(r1);
    L8:
        return durationOfMillisNormalized(MathKt.roundToLong(DurationUnitKt.convertDurationUnit(r7, r9, DurationUnit.MILLISECONDS)));
    L10:
        throw new IllegalArgumentException("Duration value cannot be NaN.".toString());
    }

    public static final /* synthetic */ long getNanoseconds(int r2) {
        return toDuration(r2, DurationUnit.NANOSECONDS);
    }

    public static final /* synthetic */ long getNanoseconds(long r1) {
        return toDuration(r1, DurationUnit.NANOSECONDS);
    }

    public static final /* synthetic */ long getNanoseconds(double r1) {
        return toDuration(r1, DurationUnit.NANOSECONDS);
    }

    public static final /* synthetic */ long getMicroseconds(int r2) {
        return toDuration(r2, DurationUnit.MICROSECONDS);
    }

    public static final /* synthetic */ long getMicroseconds(long r1) {
        return toDuration(r1, DurationUnit.MICROSECONDS);
    }

    public static final /* synthetic */ long getMicroseconds(double r1) {
        return toDuration(r1, DurationUnit.MICROSECONDS);
    }

    public static final /* synthetic */ long getMilliseconds(int r2) {
        return toDuration(r2, DurationUnit.MILLISECONDS);
    }

    public static final /* synthetic */ long getMilliseconds(long r1) {
        return toDuration(r1, DurationUnit.MILLISECONDS);
    }

    public static final /* synthetic */ long getMilliseconds(double r1) {
        return toDuration(r1, DurationUnit.MILLISECONDS);
    }

    public static final /* synthetic */ long getSeconds(int r2) {
        return toDuration(r2, DurationUnit.SECONDS);
    }

    public static final /* synthetic */ long getSeconds(long r1) {
        return toDuration(r1, DurationUnit.SECONDS);
    }

    public static final /* synthetic */ long getSeconds(double r1) {
        return toDuration(r1, DurationUnit.SECONDS);
    }

    public static final /* synthetic */ long getMinutes(int r2) {
        return toDuration(r2, DurationUnit.MINUTES);
    }

    public static final /* synthetic */ long getMinutes(long r1) {
        return toDuration(r1, DurationUnit.MINUTES);
    }

    public static final /* synthetic */ long getMinutes(double r1) {
        return toDuration(r1, DurationUnit.MINUTES);
    }

    public static final /* synthetic */ long getHours(int r2) {
        return toDuration(r2, DurationUnit.HOURS);
    }

    public static final /* synthetic */ long getHours(long r1) {
        return toDuration(r1, DurationUnit.HOURS);
    }

    public static final /* synthetic */ long getHours(double r1) {
        return toDuration(r1, DurationUnit.HOURS);
    }

    public static final /* synthetic */ long getDays(int r2) {
        return toDuration(r2, DurationUnit.DAYS);
    }

    public static final /* synthetic */ long getDays(long r1) {
        return toDuration(r1, DurationUnit.DAYS);
    }

    public static final /* synthetic */ long getDays(double r1) {
        return toDuration(r1, DurationUnit.DAYS);
    }

    /* JADX INFO: renamed from: times-mvk6XK0, reason: not valid java name */
    private static final long m2271timesmvk6XK0(int r0, long r1) {
        return Duration.m2182timesUwyO8pc(r1, r0);
    }

    /* JADX INFO: renamed from: times-kIfJnKk, reason: not valid java name */
    private static final long m2270timeskIfJnKk(double r0, long r2) {
        return Duration.m2181timesUwyO8pc(r2, r0);
    }

    private static final long parseDuration(String r26, boolean r27) {
        String r6 = r26;
        int r7 = r26.length();
        if (r7 == 0) goto L157;
        long r8 = Duration.Companion.m2247getZEROUwyO8pc();
        char r0 = r6.charAt(0);
        boolean r11 = true;
        if (r0 != '+') goto L7;
    L6:
        int r12 = 1;
    L10:
        if (r12 <= 0) goto L12;
        boolean r13 = true;
    L14:
        if (r13 == true) goto L16;
    L18:
        boolean r15 = false;
    L20:
        if (r7 <= r12) goto L155;
        char r5 = '9';
        char r1 = '0';
        if (r6.charAt(r12) != 'P') goto L78;
        int r14 = r12 + 1;
        if (r14 == r7) goto L77;
        boolean r2 = false;
        DurationUnit r3 = null;
    L26:
        if (r14 >= r7) goto L75;
        if (r6.charAt(r14) == 'T') goto L29;
        int r4 = r14;
    L37:
        if (r4 >= r26.length()) goto L48;
        char r16 = r6.charAt(r4);
        if (new CharRange(r1, r5).contains(r16) == true) goto L44;
        boolean r17 = r15;
        if (StringsKt.contains$default("+-.", r16, false, 2, null) == true) goto L45;
        boolean r18 = false;
    L46:
        if (r18 == false) goto L49;
        r4 = r4 + 1;
        r15 = r17;
        r1 = '0';
        r5 = '9';
    L49:
        Intrinsics.checkNotNull(r6, "null cannot be cast to non-null type java.lang.String");
        String r9 = r6.substring(r14, r4);
        Intrinsics.checkNotNullExpressionValue(r9, "substring(...)");
        String r19 = r9;
        if (r19.length() != 0) goto L52;
        boolean r110 = true;
    L53:
        if (r110 == true) goto L74;
        int r111 = r14 + r9.length();
        String r112 = r6;
        if (r111 < 0) goto L72;
        if (r111 > StringsKt.getLastIndex(r112)) goto L72;
        char r113 = r112.charAt(r111);
        r14 = r111 + 1;
        DurationUnit r114 = DurationUnitKt.durationUnitByIsoChar(r113, r2);
        if (r3 != null) goto L61;
    L65:
        int r10 = StringsKt.indexOf$default(r19, '.', 0, false, 6, null);
        if (r114 != DurationUnit.SECONDS) goto L69;
        if (r10 <= 0) goto L69;
        Intrinsics.checkNotNull(r9, "null cannot be cast to non-null type java.lang.String");
        String r115 = r9.substring(0, r10);
        Intrinsics.checkNotNullExpressionValue(r115, "substring(...)");
        long r20 = Duration.m2180plusLRDsOJo(r8, toDuration(parseOverLongIsoComponent(r115), r114));
        Intrinsics.checkNotNull(r9, "null cannot be cast to non-null type java.lang.String");
        String r21 = r9.substring(r10);
        Intrinsics.checkNotNullExpressionValue(r21, "substring(...)");
        r8 = Duration.m2180plusLRDsOJo(r20, toDuration(Double.parseDouble(r21), r114));
    L70:
        r2 = r2;
        r3 = r114;
        r15 = r17;
        r1 = '0';
        r5 = '9';
        r11 = true;
    L69:
        r8 = Duration.m2180plusLRDsOJo(r8, toDuration(parseOverLongIsoComponent(r9), r114));
        goto L70
    L61:
        if (r3.compareTo(r114) > 0) goto L65;
        throw new IllegalArgumentException("Unexpected order of duration components");
    L72:
        throw new IllegalArgumentException("Missing unit for value " + r9);
    L74:
        throw new IllegalArgumentException();
    L52:
        r110 = false;
    L45:
        r18 = true;
        goto L46
    L44:
        r17 = r15;
        goto L45
    L48:
        r17 = r15;
        goto L49
    L29:
        if (r2 == true) goto L34;
        r14 = r14 + 1;
        if (r14 == r7) goto L34;
        r2 = r11;
    L34:
        throw new IllegalArgumentException();
    L75:
        boolean r116 = r15;
    L149:
        if (r116 == true) goto L151;
        return r8;
    L151:
        return Duration.m2197unaryMinusUwyO8pc(r8);
    L77:
        throw new IllegalArgumentException();
    L78:
        r116 = r15;
        if (r27 == true) goto L153;
        String r25 = "Unexpected order of duration components";
        DurationUnit r117 = null;
        if (StringsKt.regionMatches(r26, r12, "Infinity", 0, Math.max(r7 - r12, 8), true) == false) goto L83;
        r8 = Duration.Companion.m2245getINFINITEUwyO8pc();
        goto L149
    L83:
        boolean r22 = !r13;
        if (r13 == false) goto L95;
        if (r6.charAt(r12) != '(') goto L95;
        if (StringsKt.last(r6) != ')') goto L95;
        r12 = r12 + 1;
        r7 = r7 - 1;
        if (r12 == r7) goto L93;
        r22 = true;
        goto L95
    L93:
        throw new IllegalArgumentException("No components");
    L95:
        boolean r118 = false;
    L96:
        if (r12 >= r7) goto L149;
        if (r118 == false) goto L107;
        if (r22 == false) goto L107;
    L100:
        if (r12 >= r26.length()) goto L107;
        if (r6.charAt(r12) != ' ') goto L104;
        boolean r119 = true;
    L105:
        if (r119 == false) goto L107;
        r12 = r12 + 1;
        goto L100
    L104:
        r119 = false;
    L107:
        int r23 = r12;
    L109:
        if (r23 >= r26.length()) goto L120;
        char r24 = r6.charAt(r23);
        if (new CharRange('0', '9').contains(r24) == false) goto L113;
    L116:
        boolean r120 = true;
    L117:
        if (r120 == false) goto L120;
        r23 = r23 + 1;
        goto L109
    L113:
        if (r24 == '.') goto L116;
        r120 = false;
    L120:
        Intrinsics.checkNotNull(r6, "null cannot be cast to non-null type java.lang.String");
        String r28 = r6.substring(r12, r23);
        Intrinsics.checkNotNullExpressionValue(r28, "substring(...)");
        String r121 = r28;
        if (r121.length() != 0) goto L123;
        boolean r122 = true;
    L124:
        if (r122 == true) goto L148;
        int r123 = r12 + r28.length();
        int r29 = r123;
    L127:
        if (r29 >= r26.length()) goto L131;
        if (new CharRange('a', 'z').contains(r6.charAt(r29)) == false) goto L131;
        r29 = r29 + 1;
    L131:
        Intrinsics.checkNotNull(r6, "null cannot be cast to non-null type java.lang.String");
        String r30 = r6.substring(r123, r29);
        Intrinsics.checkNotNullExpressionValue(r30, "substring(...)");
        r12 = r123 + r30.length();
        DurationUnit r31 = DurationUnitKt.durationUnitByShortName(r30);
        if (r117 != null) goto L134;
    L138:
        String r32 = r25;
        int r33 = StringsKt.indexOf$default(r121, '.', 0, false, 6, null);
        if (r33 <= 0) goto L145;
        Intrinsics.checkNotNull(r28, "null cannot be cast to non-null type java.lang.String");
        String r124 = r28.substring(0, r33);
        Intrinsics.checkNotNullExpressionValue(r124, "substring(...)");
        long r34 = Duration.m2180plusLRDsOJo(r8, toDuration(Long.parseLong(r124), r31));
        Intrinsics.checkNotNull(r28, "null cannot be cast to non-null type java.lang.String");
        String r35 = r28.substring(r33);
        Intrinsics.checkNotNullExpressionValue(r35, "substring(...)");
        r8 = Duration.m2180plusLRDsOJo(r34, toDuration(Double.parseDouble(r35), r31));
        if (r12 >= r7) goto L146;
        throw new IllegalArgumentException("Fractional component must be last");
    L146:
        r6 = r26;
        r25 = r32;
        r117 = r31;
        r118 = true;
        goto L96
    L145:
        r8 = Duration.m2180plusLRDsOJo(r8, toDuration(Long.parseLong(r28), r31));
        goto L146
    L134:
        if (r117.compareTo(r31) > 0) goto L138;
        throw new IllegalArgumentException(r25);
    L148:
        throw new IllegalArgumentException();
    L123:
        r122 = false;
        goto L124
    L153:
        throw new IllegalArgumentException();
    L155:
        throw new IllegalArgumentException("No components");
    L16:
        if (StringsKt.startsWith$default(r6, '-', false, 2, null) == false) goto L18;
        r15 = true;
        goto L20
    L12:
        r13 = false;
        goto L14
    L7:
        if (r0 == '-') goto L6;
        r12 = 0;
        goto L10
    L157:
        throw new IllegalArgumentException("The string is empty");
    }

    private static final long parseOverLongIsoComponent(String r9) {
        int r0 = r9.length();
        if (r0 > 0) goto L5;
    L7:
        int r5 = 0;
    L9:
        if ((r0 - r5) <= 16) goto L28;
        Iterable r1 = new IntRange(r5, StringsKt.getLastIndex(r9));
        if ((r1 instanceof Collection) == true) goto L13;
    L15:
        Iterator r2 = r1.iterator();
    L17:
        if (r2.hasNext() == false) goto L14;
        if (new CharRange('0', '9').contains(r9.charAt(((IntIterator) r2).nextInt())) == true) goto L17;
        boolean r3 = false;
    L21:
        if (r3 == false) goto L28;
        if (r9.charAt(0) != '-') goto L25;
        return Long.MIN_VALUE;
    L25:
        return Long.MAX_VALUE;
    L14:
        r3 = true;
        goto L21
    L13:
        if (((Collection) r1).isEmpty() == false) goto L15;
    L28:
        if (StringsKt.startsWith$default(r9, "+", false, 2, null) == false) goto L31;
        r9 = StringsKt.drop(r9, 1);
    L31:
        return Long.parseLong(r9);
    L5:
        if (StringsKt.contains$default("+-", r9.charAt(0), false, 2, null) == false) goto L7;
        r5 = 1;
        goto L9
    }

    private static final int skipWhile(String r1, int r2, Function1<? super Character, Boolean> r3) {
    L3:
        if (r2 >= r1.length()) goto L7;
        if (r3.invoke(Character.valueOf(r1.charAt(r2))).booleanValue() == false) goto L7;
        r2 = r2 + 1;
    L7:
        return r2;
    }

    private static final long nanosToMillis(long r2) {
        return r2 / ((long) 1000000);
    }

    private static final long durationOfNanos(long r1) {
        return Duration.m2144constructorimpl(r1 << 1);
    }

    private static final long durationOfMillis(long r2) {
        return Duration.m2144constructorimpl((r2 << 1) + 1);
    }

    private static final long durationOf(long r2, int r4) {
        return Duration.m2144constructorimpl((r2 << 1) + ((long) r4));
    }

    private static final long durationOfNanosNormalized(long r5) {
        if (new LongRange(-4611686018426999999L, MAX_NANOS).contains(r5) == false) goto L6;
        return durationOfNanos(r5);
    L6:
        return durationOfMillis(nanosToMillis(r5));
    }

    private static final long durationOfMillisNormalized(long r6) {
        if (new LongRange(-4611686018426L, MAX_NANOS_IN_MILLIS).contains(r6) == false) goto L6;
        return durationOfNanos(millisToNanos(r6));
    L6:
        return durationOfMillis(RangesKt.coerceIn(r6, -4611686018427387903L, MAX_MILLIS));
    }

    private static final String substringWhile(String r2, int r3, Function1<? super Character, Boolean> r4) {
        int r0 = r3;
    L4:
        if (r0 >= r2.length()) goto L8;
        if (r4.invoke(Character.valueOf(r2.charAt(r0))).booleanValue() == false) goto L8;
        r0 = r0 + 1;
    L8:
        Intrinsics.checkNotNull(r2, "null cannot be cast to non-null type java.lang.String");
        String r5 = r2.substring(r3, r0);
        Intrinsics.checkNotNullExpressionValue(r5, "substring(...)");
        return r5;
    }
}
