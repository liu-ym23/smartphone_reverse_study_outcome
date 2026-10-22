package org.threeten.bp;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.DataInput;
import java.io.DataOutput;
import java.io.InvalidObjectException;
import java.io.Serializable;
import java.util.List;
import org.threeten.bp.chrono.ChronoLocalDate;
import org.threeten.bp.chrono.ChronoLocalDateTime;
import org.threeten.bp.chrono.ChronoZonedDateTime;
import org.threeten.bp.format.DateTimeFormatter;
import org.threeten.bp.jdk8.Jdk8Methods;
import org.threeten.bp.temporal.ChronoField;
import org.threeten.bp.temporal.ChronoUnit;
import org.threeten.bp.temporal.Temporal;
import org.threeten.bp.temporal.TemporalAccessor;
import org.threeten.bp.temporal.TemporalAdjuster;
import org.threeten.bp.temporal.TemporalAmount;
import org.threeten.bp.temporal.TemporalField;
import org.threeten.bp.temporal.TemporalQueries;
import org.threeten.bp.temporal.TemporalQuery;
import org.threeten.bp.temporal.TemporalUnit;
import org.threeten.bp.temporal.ValueRange;
import org.threeten.bp.zone.ZoneOffsetTransition;
import org.threeten.bp.zone.ZoneRules;

/* JADX INFO: loaded from: classes5.dex */
public final class ZonedDateTime extends ChronoZonedDateTime<LocalDate> implements Serializable, Temporal {
    public static final TemporalQuery<ZonedDateTime> FROM = null;
    private static final long serialVersionUID = -6260982410461394882L;
    private final LocalDateTime dateTime;
    private final ZoneOffset offset;
    private final ZoneId zone;

    /* JADX INFO: renamed from: org.threeten.bp.ZonedDateTime$2, reason: invalid class name */
    static /* synthetic */ class AnonymousClass2 {
        static final /* synthetic */ int[] $SwitchMap$org$threeten$bp$temporal$ChronoField = null;

        static {
            int[] r0 = new int[ChronoField.values().length];
            $SwitchMap$org$threeten$bp$temporal$ChronoField = r0;
            r0[ChronoField.INSTANT_SECONDS.ordinal()] = 1;     // Catch: NoSuchFieldError -> L6
        L8:
            $SwitchMap$org$threeten$bp$temporal$ChronoField[ChronoField.OFFSET_SECONDS.ordinal()] = 2;     // Catch: NoSuchFieldError -> L7
            return;
        }
    }

    @Override // org.threeten.bp.chrono.ChronoZonedDateTime, org.threeten.bp.jdk8.DefaultInterfaceTemporal, org.threeten.bp.temporal.Temporal
    public /* synthetic */ ChronoZonedDateTime minus(long r3, TemporalUnit r5) {
        return minus(r3, (TemporalUnit) ZeusTransformUtils.wrapperContextForParams(r5, TemporalUnit.class, "com.obric.aiagent.plugin"));
    }

    @Override // org.threeten.bp.chrono.ChronoZonedDateTime, org.threeten.bp.jdk8.DefaultInterfaceTemporal, org.threeten.bp.temporal.Temporal
    public /* synthetic */ ChronoZonedDateTime minus(TemporalAmount r3) {
        return minus((TemporalAmount) ZeusTransformUtils.wrapperContextForParams(r3, TemporalAmount.class, "com.obric.aiagent.plugin"));
    }

    @Override // org.threeten.bp.chrono.ChronoZonedDateTime, org.threeten.bp.jdk8.DefaultInterfaceTemporal, org.threeten.bp.temporal.Temporal
    public /* synthetic */ Temporal minus(long r3, TemporalUnit r5) {
        return minus(r3, (TemporalUnit) ZeusTransformUtils.wrapperContextForParams(r5, TemporalUnit.class, "com.obric.aiagent.plugin"));
    }

    @Override // org.threeten.bp.chrono.ChronoZonedDateTime, org.threeten.bp.jdk8.DefaultInterfaceTemporal, org.threeten.bp.temporal.Temporal
    public /* synthetic */ Temporal minus(TemporalAmount r3) {
        return minus((TemporalAmount) ZeusTransformUtils.wrapperContextForParams(r3, TemporalAmount.class, "com.obric.aiagent.plugin"));
    }

    @Override // org.threeten.bp.chrono.ChronoZonedDateTime, org.threeten.bp.temporal.Temporal
    public /* synthetic */ ChronoZonedDateTime plus(long r3, TemporalUnit r5) {
        return plus(r3, (TemporalUnit) ZeusTransformUtils.wrapperContextForParams(r5, TemporalUnit.class, "com.obric.aiagent.plugin"));
    }

    @Override // org.threeten.bp.chrono.ChronoZonedDateTime, org.threeten.bp.jdk8.DefaultInterfaceTemporal, org.threeten.bp.temporal.Temporal
    public /* synthetic */ ChronoZonedDateTime plus(TemporalAmount r3) {
        return plus((TemporalAmount) ZeusTransformUtils.wrapperContextForParams(r3, TemporalAmount.class, "com.obric.aiagent.plugin"));
    }

    @Override // org.threeten.bp.chrono.ChronoZonedDateTime, org.threeten.bp.temporal.Temporal
    public /* synthetic */ Temporal plus(long r3, TemporalUnit r5) {
        return plus(r3, (TemporalUnit) ZeusTransformUtils.wrapperContextForParams(r5, TemporalUnit.class, "com.obric.aiagent.plugin"));
    }

    @Override // org.threeten.bp.chrono.ChronoZonedDateTime, org.threeten.bp.jdk8.DefaultInterfaceTemporal, org.threeten.bp.temporal.Temporal
    public /* synthetic */ Temporal plus(TemporalAmount r3) {
        return plus((TemporalAmount) ZeusTransformUtils.wrapperContextForParams(r3, TemporalAmount.class, "com.obric.aiagent.plugin"));
    }

    @Override // org.threeten.bp.chrono.ChronoZonedDateTime
    public /* bridge */ /* synthetic */ ChronoLocalDate toLocalDate() {
        return toLocalDate();
    }

    @Override // org.threeten.bp.chrono.ChronoZonedDateTime
    public /* bridge */ /* synthetic */ ChronoLocalDateTime toLocalDateTime() {
        return toLocalDateTime();
    }

    @Override // org.threeten.bp.chrono.ChronoZonedDateTime, org.threeten.bp.jdk8.DefaultInterfaceTemporal, org.threeten.bp.temporal.Temporal
    public /* synthetic */ ChronoZonedDateTime with(TemporalAdjuster r3) {
        return with((TemporalAdjuster) ZeusTransformUtils.wrapperContextForParams(r3, TemporalAdjuster.class, "com.obric.aiagent.plugin"));
    }

    @Override // org.threeten.bp.chrono.ChronoZonedDateTime, org.threeten.bp.temporal.Temporal
    public /* synthetic */ ChronoZonedDateTime with(TemporalField r3, long r4) {
        return with((TemporalField) ZeusTransformUtils.wrapperContextForParams(r3, TemporalField.class, "com.obric.aiagent.plugin"), r4);
    }

    @Override // org.threeten.bp.chrono.ChronoZonedDateTime, org.threeten.bp.jdk8.DefaultInterfaceTemporal, org.threeten.bp.temporal.Temporal
    public /* synthetic */ Temporal with(TemporalAdjuster r3) {
        return with((TemporalAdjuster) ZeusTransformUtils.wrapperContextForParams(r3, TemporalAdjuster.class, "com.obric.aiagent.plugin"));
    }

    @Override // org.threeten.bp.chrono.ChronoZonedDateTime, org.threeten.bp.temporal.Temporal
    public /* synthetic */ Temporal with(TemporalField r3, long r4) {
        return with((TemporalField) ZeusTransformUtils.wrapperContextForParams(r3, TemporalField.class, "com.obric.aiagent.plugin"), r4);
    }

    @Override // org.threeten.bp.chrono.ChronoZonedDateTime
    public /* bridge */ /* synthetic */ ChronoZonedDateTime withEarlierOffsetAtOverlap() {
        return withEarlierOffsetAtOverlap();
    }

    @Override // org.threeten.bp.chrono.ChronoZonedDateTime
    public /* bridge */ /* synthetic */ ChronoZonedDateTime withLaterOffsetAtOverlap() {
        return withLaterOffsetAtOverlap();
    }

    @Override // org.threeten.bp.chrono.ChronoZonedDateTime
    public /* bridge */ /* synthetic */ ChronoZonedDateTime withZoneSameInstant(ZoneId r1) {
        return withZoneSameInstant(r1);
    }

    @Override // org.threeten.bp.chrono.ChronoZonedDateTime
    public /* bridge */ /* synthetic */ ChronoZonedDateTime withZoneSameLocal(ZoneId r1) {
        return withZoneSameLocal(r1);
    }

    static {
        FROM = new AnonymousClass1();
    }

    public static ZonedDateTime now() {
        return now(Clock.systemDefaultZone());
    }

    public static ZonedDateTime now(ZoneId r0) {
        return now(Clock.system(r0));
    }

    public static ZonedDateTime now(Clock r1) {
        Jdk8Methods.requireNonNull(r1, "clock");
        return ofInstant(r1.instant(), r1.getZone());
    }

    public static ZonedDateTime of(LocalDate r0, LocalTime r1, ZoneId r2) {
        return of(LocalDateTime.of(r0, r1), r2);
    }

    public static ZonedDateTime of(LocalDateTime r1, ZoneId r2) {
        return ofLocal(r1, r2, null);
    }

    public static ZonedDateTime of(int r0, int r1, int r2, int r3, int r4, int r5, int r6, ZoneId r7) {
        return ofLocal(LocalDateTime.of(r0, r1, r2, r3, r4, r5, r6), r7, null);
    }

    public static ZonedDateTime ofLocal(LocalDateTime r6, ZoneId r7, ZoneOffset r8) {
        Jdk8Methods.requireNonNull(r6, "localDateTime");
        Jdk8Methods.requireNonNull(r7, "zone");
        if (ZeusTransformUtils.instanceOf(r7, ZoneOffset.class) == true) goto L5;
        ZoneRules r0 = r7.getRules();
        List<ZoneOffset> r2 = r0.getValidOffsets(r6);
        if (r2.size() != 1) goto L10;
        r8 = (ZoneOffset) ZeusTransformUtils.preCheckCast(r2.get(0), ZoneOffset.class, "com.obric.aiagent.plugin");
    L18:
        return new ZonedDateTime(r6, r8, r7);
    L10:
        if (r2.size() != 0) goto L12;
        ZoneOffsetTransition r9 = r0.getTransition(r6);
        r6 = r6.plusSeconds(r9.getDuration().getSeconds());
        r8 = r9.getOffsetAfter();
        goto L18
    L12:
        if (r8 != null) goto L14;
    L16:
        r8 = (ZoneOffset) ZeusTransformUtils.preCheckCast(Jdk8Methods.requireNonNull(r2.get(0), "offset"), ZoneOffset.class, "com.obric.aiagent.plugin");
        goto L18
    L14:
        if (r2.contains(r8) == false) goto L16;
    L5:
        return new ZonedDateTime(r6, (ZoneOffset) ZeusTransformUtils.preCheckCast(r7, ZoneOffset.class, "com.obric.aiagent.plugin"), r7);
    }

    public static ZonedDateTime ofInstant(Instant r2, ZoneId r3) {
        Jdk8Methods.requireNonNull(r2, "instant");
        Jdk8Methods.requireNonNull(r3, "zone");
        return create(r2.getEpochSecond(), r2.getNano(), r3);
    }

    public static ZonedDateTime ofInstant(LocalDateTime r2, ZoneOffset r3, ZoneId r4) {
        Jdk8Methods.requireNonNull(r2, "localDateTime");
        Jdk8Methods.requireNonNull(r3, "offset");
        Jdk8Methods.requireNonNull(r4, "zone");
        return create(r2.toEpochSecond(r3), r2.getNano(), r4);
    }

    private static ZonedDateTime create(long r3, int r5, ZoneId r6) {
        ZoneOffset r0 = r6.getRules().getOffset(Instant.ofEpochSecond(r3, r5));
        return new ZonedDateTime(LocalDateTime.ofEpochSecond(r3, r5, r0), r0, r6);
    }

    public static ZonedDateTime ofStrict(LocalDateTime r3, ZoneOffset r4, ZoneId r5) {
        Jdk8Methods.requireNonNull(r3, "localDateTime");
        Jdk8Methods.requireNonNull(r4, "offset");
        Jdk8Methods.requireNonNull(r5, "zone");
        ZoneRules r0 = r5.getRules();
        if (r0.isValidOffset(r3, r4) == true) goto L13;
        ZoneOffsetTransition r1 = r0.getTransition(r3);
        if (r1 == null) goto L11;
        if (r1.isGap() == false) goto L11;
        throw new DateTimeException("LocalDateTime '" + r3 + "' does not exist in zone '" + r5 + "' due to a gap in the local time-line, typically caused by daylight savings");
    L11:
        throw new DateTimeException("ZoneOffset '" + r4 + "' is not valid for LocalDateTime '" + r3 + "' in zone '" + r5 + "'");
    L13:
        return new ZonedDateTime(r3, r4, r5);
    }

    private static ZonedDateTime ofLenient(LocalDateTime r1, ZoneOffset r2, ZoneId r3) {
        Jdk8Methods.requireNonNull(r1, "localDateTime");
        Jdk8Methods.requireNonNull(r2, "offset");
        Jdk8Methods.requireNonNull(r3, "zone");
        if (ZeusTransformUtils.instanceOf(r3, ZoneOffset.class) == false) goto L10;
        if (r2.equals(r3) == true) goto L10;
        throw new IllegalArgumentException("ZoneId must match ZoneOffset");
    L10:
        return new ZonedDateTime(r1, r2, r3);
    }

    public static ZonedDateTime from(TemporalAccessor r4) {
        TemporalAccessor r5 = (TemporalAccessor) ZeusTransformUtils.wrapperContextForParams(r4, TemporalAccessor.class, "com.obric.aiagent.plugin");
        if (ZeusTransformUtils.instanceOf(r5, ZonedDateTime.class) == true) goto L5;
        ZoneId r0 = ZoneId.from(r5);     // Catch: DateTimeException -> L12
        if (r5.isSupported(ChronoField.INSTANT_SECONDS) == true) goto L15;
    L10:
        return of(LocalDateTime.from(r5), r0);
    L15:
        return create(r5.getLong(ChronoField.INSTANT_SECONDS), r5.get(ChronoField.NANO_OF_SECOND), r0);
    L13:
        throw new DateTimeException("Unable to obtain ZonedDateTime from TemporalAccessor: " + r5 + ", type " + r5.getClass().getName());
    L5:
        return (ZonedDateTime) ZeusTransformUtils.preCheckCast(r5, ZonedDateTime.class, "com.obric.aiagent.plugin");
    }

    public static ZonedDateTime parse(CharSequence r2) {
        return parse((CharSequence) ZeusTransformUtils.wrapperContextForParams(r2, CharSequence.class, "com.obric.aiagent.plugin"), DateTimeFormatter.ISO_ZONED_DATE_TIME);
    }

    public static ZonedDateTime parse(CharSequence r2, DateTimeFormatter r3) {
        CharSequence r4 = (CharSequence) ZeusTransformUtils.wrapperContextForParams(r2, CharSequence.class, "com.obric.aiagent.plugin");
        Jdk8Methods.requireNonNull(r3, "formatter");
        return (ZonedDateTime) ZeusTransformUtils.preCheckCast(r3.parse(r4, FROM), ZonedDateTime.class, "com.obric.aiagent.plugin");
    }

    private ZonedDateTime(LocalDateTime r1, ZoneOffset r2, ZoneId r3) {
        this.dateTime = r1;
        this.offset = r2;
        this.zone = r3;
    }

    private ZonedDateTime resolveLocal(LocalDateTime r2) {
        return ofLocal(r2, this.zone, this.offset);
    }

    private ZonedDateTime resolveInstant(LocalDateTime r2) {
        return ofInstant(r2, this.offset, this.zone);
    }

    private ZonedDateTime resolveOffset(ZoneOffset r3) {
        if (r3.equals(this.offset) == false) goto L5;
    L8:
        return this;
    L5:
        if (this.zone.getRules().isValidOffset(this.dateTime, r3) == false) goto L8;
        return new ZonedDateTime(this.dateTime, r3, this.zone);
    }

    @Override // org.threeten.bp.temporal.TemporalAccessor
    public boolean isSupported(TemporalField r3) {
        TemporalField r4 = (TemporalField) ZeusTransformUtils.wrapperContextForParams(r3, TemporalField.class, "com.obric.aiagent.plugin");
        if (ZeusTransformUtils.instanceOf(r4, ChronoField.class) == true) goto L9;
        if (r4 != null) goto L6;
    L8:
        return false;
    L6:
        if (r4.isSupportedBy(this) == false) goto L8;
    L9:
        return true;
    }

    @Override // org.threeten.bp.temporal.Temporal
    public boolean isSupported(TemporalUnit r4) {
        TemporalUnit r5 = (TemporalUnit) ZeusTransformUtils.wrapperContextForParams(r4, TemporalUnit.class, "com.obric.aiagent.plugin");
        if (ZeusTransformUtils.instanceOf(r5, ChronoUnit.class) == true) goto L5;
        if (r5 == null) goto L16;
        if (r5.isSupportedBy(this) == false) goto L16;
        return true;
    L16:
        return false;
    L5:
        if (r5.isDateBased() == false) goto L7;
        return true;
    L7:
        if (r5.isTimeBased() == false) goto L10;
        return true;
    L10:
        return false;
    }

    @Override // org.threeten.bp.chrono.ChronoZonedDateTime, org.threeten.bp.jdk8.DefaultInterfaceTemporalAccessor, org.threeten.bp.temporal.TemporalAccessor
    public ValueRange range(TemporalField r3) {
        TemporalField r4 = (TemporalField) ZeusTransformUtils.wrapperContextForParams(r3, TemporalField.class, "com.obric.aiagent.plugin");
        if (ZeusTransformUtils.instanceOf(r4, ChronoField.class) == false) goto L14;
        if (r4 == ChronoField.INSTANT_SECONDS) goto L12;
        if (r4 == ChronoField.OFFSET_SECONDS) goto L12;
        return this.dateTime.range(r4);
    L12:
        return r4.range();
    L14:
        return r4.rangeRefinedBy(this);
    }

    @Override // org.threeten.bp.chrono.ChronoZonedDateTime, org.threeten.bp.jdk8.DefaultInterfaceTemporalAccessor, org.threeten.bp.temporal.TemporalAccessor
    public int get(TemporalField r4) {
        TemporalField r5 = (TemporalField) ZeusTransformUtils.wrapperContextForParams(r4, TemporalField.class, "com.obric.aiagent.plugin");
        if (ZeusTransformUtils.instanceOf(r5, ChronoField.class) == false) goto L15;
        int r0 = AnonymousClass2.$SwitchMap$org$threeten$bp$temporal$ChronoField[((ChronoField) ZeusTransformUtils.preCheckCast(r5, ChronoField.class, "com.obric.aiagent.plugin")).ordinal()];
        if (r0 == 1) goto L13;
        if (r0 == 2) goto L11;
        return this.dateTime.get(r5);
    L11:
        return getOffset().getTotalSeconds();
    L13:
        throw new DateTimeException("Field too large for an int: " + r5);
    L15:
        return super.get(r5);
    }

    @Override // org.threeten.bp.chrono.ChronoZonedDateTime, org.threeten.bp.temporal.TemporalAccessor
    public long getLong(TemporalField r4) {
        TemporalField r5 = (TemporalField) ZeusTransformUtils.wrapperContextForParams(r4, TemporalField.class, "com.obric.aiagent.plugin");
        if (ZeusTransformUtils.instanceOf(r5, ChronoField.class) == false) goto L15;
        int r0 = AnonymousClass2.$SwitchMap$org$threeten$bp$temporal$ChronoField[((ChronoField) ZeusTransformUtils.preCheckCast(r5, ChronoField.class, "com.obric.aiagent.plugin")).ordinal()];
        if (r0 == 1) goto L13;
        if (r0 == 2) goto L11;
        return this.dateTime.getLong(r5);
    L11:
        return getOffset().getTotalSeconds();
    L13:
        return toEpochSecond();
    L15:
        return r5.getFrom(this);
    }

    @Override // org.threeten.bp.chrono.ChronoZonedDateTime
    public ZoneOffset getOffset() {
        return this.offset;
    }

    @Override // org.threeten.bp.chrono.ChronoZonedDateTime
    public ZonedDateTime withEarlierOffsetAtOverlap() {
        ZoneOffsetTransition r0 = getZone().getRules().getTransition(this.dateTime);
        if (r0 != null) goto L5;
    L10:
        return this;
    L5:
        if (r0.isOverlap() == false) goto L10;
        ZoneOffset r1 = r0.getOffsetBefore();
        if (r1.equals(this.offset) == true) goto L10;
        return new ZonedDateTime(this.dateTime, r1, this.zone);
    }

    @Override // org.threeten.bp.chrono.ChronoZonedDateTime
    public ZonedDateTime withLaterOffsetAtOverlap() {
        ZoneOffsetTransition r0 = getZone().getRules().getTransition(toLocalDateTime());
        if (r0 == null) goto L8;
        ZoneOffset r1 = r0.getOffsetAfter();
        if (r1.equals(this.offset) == true) goto L8;
        return new ZonedDateTime(this.dateTime, r1, this.zone);
    L8:
        return this;
    }

    @Override // org.threeten.bp.chrono.ChronoZonedDateTime
    public ZoneId getZone() {
        return this.zone;
    }

    @Override // org.threeten.bp.chrono.ChronoZonedDateTime
    public ZonedDateTime withZoneSameLocal(ZoneId r2) {
        Jdk8Methods.requireNonNull(r2, "zone");
        if (this.zone.equals(r2) == false) goto L6;
        return this;
    L6:
        return ofLocal(this.dateTime, r2, this.offset);
    }

    @Override // org.threeten.bp.chrono.ChronoZonedDateTime
    public ZonedDateTime withZoneSameInstant(ZoneId r3) {
        Jdk8Methods.requireNonNull(r3, "zone");
        if (this.zone.equals(r3) == false) goto L6;
        return this;
    L6:
        return create(this.dateTime.toEpochSecond(this.offset), this.dateTime.getNano(), r3);
    }

    public ZonedDateTime withFixedOffsetZone() {
        if (this.zone.equals(this.offset) == true) goto L7;
        LocalDateTime r1 = this.dateTime;
        ZoneOffset r2 = this.offset;
        return new ZonedDateTime(r1, r2, r2);
    L7:
        return this;
    }

    public int getYear() {
        return this.dateTime.getYear();
    }

    public int getMonthValue() {
        return this.dateTime.getMonthValue();
    }

    public Month getMonth() {
        return this.dateTime.getMonth();
    }

    public int getDayOfMonth() {
        return this.dateTime.getDayOfMonth();
    }

    public int getDayOfYear() {
        return this.dateTime.getDayOfYear();
    }

    public DayOfWeek getDayOfWeek() {
        return this.dateTime.getDayOfWeek();
    }

    public int getHour() {
        return this.dateTime.getHour();
    }

    public int getMinute() {
        return this.dateTime.getMinute();
    }

    public int getSecond() {
        return this.dateTime.getSecond();
    }

    public int getNano() {
        return this.dateTime.getNano();
    }

    @Override // org.threeten.bp.chrono.ChronoZonedDateTime, org.threeten.bp.jdk8.DefaultInterfaceTemporal, org.threeten.bp.temporal.Temporal
    public ZonedDateTime with(TemporalAdjuster r4) {
        TemporalAdjuster r5 = (TemporalAdjuster) ZeusTransformUtils.wrapperContextForParams(r4, TemporalAdjuster.class, "com.obric.aiagent.plugin");
        if (ZeusTransformUtils.instanceOf(r5, LocalDate.class) == false) goto L7;
        return resolveLocal(LocalDateTime.of((LocalDate) ZeusTransformUtils.preCheckCast(r5, LocalDate.class, "com.obric.aiagent.plugin"), this.dateTime.toLocalTime()));
    L7:
        if (ZeusTransformUtils.instanceOf(r5, LocalTime.class) == false) goto L11;
        return resolveLocal(LocalDateTime.of(this.dateTime.toLocalDate(), (LocalTime) ZeusTransformUtils.preCheckCast(r5, LocalTime.class, "com.obric.aiagent.plugin")));
    L11:
        if (ZeusTransformUtils.instanceOf(r5, LocalDateTime.class) == false) goto L15;
        return resolveLocal((LocalDateTime) ZeusTransformUtils.preCheckCast(r5, LocalDateTime.class, "com.obric.aiagent.plugin"));
    L15:
        if (ZeusTransformUtils.instanceOf(r5, Instant.class) == false) goto L19;
        Instant r6 = (Instant) ZeusTransformUtils.preCheckCast(r5, Instant.class, "com.obric.aiagent.plugin");
        return create(r6.getEpochSecond(), r6.getNano(), this.zone);
    L19:
        if (ZeusTransformUtils.instanceOf(r5, ZoneOffset.class) == false) goto L23;
        return resolveOffset((ZoneOffset) ZeusTransformUtils.preCheckCast(r5, ZoneOffset.class, "com.obric.aiagent.plugin"));
    L23:
        return (ZonedDateTime) ZeusTransformUtils.preCheckCast(r5.adjustInto(this), ZonedDateTime.class, "com.obric.aiagent.plugin");
    }

    @Override // org.threeten.bp.chrono.ChronoZonedDateTime, org.threeten.bp.temporal.Temporal
    public ZonedDateTime with(TemporalField r4, long r5) {
        TemporalField r6 = (TemporalField) ZeusTransformUtils.wrapperContextForParams(r4, TemporalField.class, "com.obric.aiagent.plugin");
        if (ZeusTransformUtils.instanceOf(r6, ChronoField.class) == false) goto L15;
        ChronoField r0 = (ChronoField) ZeusTransformUtils.preCheckCast(r6, ChronoField.class, "com.obric.aiagent.plugin");
        int r1 = AnonymousClass2.$SwitchMap$org$threeten$bp$temporal$ChronoField[r0.ordinal()];
        if (r1 == 1) goto L13;
        if (r1 == 2) goto L11;
        return resolveLocal(this.dateTime.with(r6, r5));
    L11:
        return resolveOffset(ZoneOffset.ofTotalSeconds(r0.checkValidIntValue(r5)));
    L13:
        return create(r5, getNano(), this.zone);
    L15:
        return (ZonedDateTime) ZeusTransformUtils.preCheckCast(r6.adjustInto(this, r5), ZonedDateTime.class, "com.obric.aiagent.plugin");
    }

    public ZonedDateTime withYear(int r2) {
        return resolveLocal(this.dateTime.withYear(r2));
    }

    public ZonedDateTime withMonth(int r2) {
        return resolveLocal(this.dateTime.withMonth(r2));
    }

    public ZonedDateTime withDayOfMonth(int r2) {
        return resolveLocal(this.dateTime.withDayOfMonth(r2));
    }

    public ZonedDateTime withDayOfYear(int r2) {
        return resolveLocal(this.dateTime.withDayOfYear(r2));
    }

    public ZonedDateTime withHour(int r2) {
        return resolveLocal(this.dateTime.withHour(r2));
    }

    public ZonedDateTime withMinute(int r2) {
        return resolveLocal(this.dateTime.withMinute(r2));
    }

    public ZonedDateTime withSecond(int r2) {
        return resolveLocal(this.dateTime.withSecond(r2));
    }

    public ZonedDateTime withNano(int r2) {
        return resolveLocal(this.dateTime.withNano(r2));
    }

    public ZonedDateTime truncatedTo(TemporalUnit r3) {
        TemporalUnit r4 = (TemporalUnit) ZeusTransformUtils.wrapperContextForParams(r3, TemporalUnit.class, "com.obric.aiagent.plugin");
        return resolveLocal(this.dateTime.truncatedTo(r4));
    }

    @Override // org.threeten.bp.chrono.ChronoZonedDateTime, org.threeten.bp.jdk8.DefaultInterfaceTemporal, org.threeten.bp.temporal.Temporal
    public ZonedDateTime plus(TemporalAmount r3) {
        return (ZonedDateTime) ZeusTransformUtils.preCheckCast(((TemporalAmount) ZeusTransformUtils.wrapperContextForParams(r3, TemporalAmount.class, "com.obric.aiagent.plugin")).addTo(this), ZonedDateTime.class, "com.obric.aiagent.plugin");
    }

    @Override // org.threeten.bp.chrono.ChronoZonedDateTime, org.threeten.bp.temporal.Temporal
    public ZonedDateTime plus(long r3, TemporalUnit r5) {
        TemporalUnit r6 = (TemporalUnit) ZeusTransformUtils.wrapperContextForParams(r5, TemporalUnit.class, "com.obric.aiagent.plugin");
        if (ZeusTransformUtils.instanceOf(r6, ChronoUnit.class) == false) goto L11;
        if (r6.isDateBased() == false) goto L9;
        return resolveLocal(this.dateTime.plus(r3, r6));
    L9:
        return resolveInstant(this.dateTime.plus(r3, r6));
    L11:
        return (ZonedDateTime) ZeusTransformUtils.preCheckCast(r6.addTo(this, r3), ZonedDateTime.class, "com.obric.aiagent.plugin");
    }

    public ZonedDateTime plusYears(long r2) {
        return resolveLocal(this.dateTime.plusYears(r2));
    }

    public ZonedDateTime plusMonths(long r2) {
        return resolveLocal(this.dateTime.plusMonths(r2));
    }

    public ZonedDateTime plusWeeks(long r2) {
        return resolveLocal(this.dateTime.plusWeeks(r2));
    }

    public ZonedDateTime plusDays(long r2) {
        return resolveLocal(this.dateTime.plusDays(r2));
    }

    public ZonedDateTime plusHours(long r2) {
        return resolveInstant(this.dateTime.plusHours(r2));
    }

    public ZonedDateTime plusMinutes(long r2) {
        return resolveInstant(this.dateTime.plusMinutes(r2));
    }

    public ZonedDateTime plusSeconds(long r2) {
        return resolveInstant(this.dateTime.plusSeconds(r2));
    }

    public ZonedDateTime plusNanos(long r2) {
        return resolveInstant(this.dateTime.plusNanos(r2));
    }

    @Override // org.threeten.bp.chrono.ChronoZonedDateTime, org.threeten.bp.jdk8.DefaultInterfaceTemporal, org.threeten.bp.temporal.Temporal
    public ZonedDateTime minus(TemporalAmount r3) {
        return (ZonedDateTime) ZeusTransformUtils.preCheckCast(((TemporalAmount) ZeusTransformUtils.wrapperContextForParams(r3, TemporalAmount.class, "com.obric.aiagent.plugin")).subtractFrom(this), ZonedDateTime.class, "com.obric.aiagent.plugin");
    }

    @Override // org.threeten.bp.chrono.ChronoZonedDateTime, org.threeten.bp.jdk8.DefaultInterfaceTemporal, org.threeten.bp.temporal.Temporal
    public ZonedDateTime minus(long r3, TemporalUnit r5) {
        TemporalUnit r6 = (TemporalUnit) ZeusTransformUtils.wrapperContextForParams(r5, TemporalUnit.class, "com.obric.aiagent.plugin");
        if (r3 != Long.MIN_VALUE) goto L5;
        ZonedDateTime this = plus(Long.MAX_VALUE, r6);
        long r4 = 1;
    L7:
        return this.plus(r4, r6);
    L5:
        r4 = -r3;
        goto L7
    }

    public ZonedDateTime minusYears(long r3) {
        if (r3 != Long.MIN_VALUE) goto L5;
        ZonedDateTime this = plusYears(Long.MAX_VALUE);
        long r4 = 1;
    L7:
        return this.plusYears(r4);
    L5:
        r4 = -r3;
        goto L7
    }

    public ZonedDateTime minusMonths(long r3) {
        if (r3 != Long.MIN_VALUE) goto L5;
        ZonedDateTime this = plusMonths(Long.MAX_VALUE);
        long r4 = 1;
    L7:
        return this.plusMonths(r4);
    L5:
        r4 = -r3;
        goto L7
    }

    public ZonedDateTime minusWeeks(long r3) {
        if (r3 != Long.MIN_VALUE) goto L5;
        ZonedDateTime this = plusWeeks(Long.MAX_VALUE);
        long r4 = 1;
    L7:
        return this.plusWeeks(r4);
    L5:
        r4 = -r3;
        goto L7
    }

    public ZonedDateTime minusDays(long r3) {
        if (r3 != Long.MIN_VALUE) goto L5;
        ZonedDateTime this = plusDays(Long.MAX_VALUE);
        long r4 = 1;
    L7:
        return this.plusDays(r4);
    L5:
        r4 = -r3;
        goto L7
    }

    public ZonedDateTime minusHours(long r3) {
        if (r3 != Long.MIN_VALUE) goto L5;
        ZonedDateTime this = plusHours(Long.MAX_VALUE);
        long r4 = 1;
    L7:
        return this.plusHours(r4);
    L5:
        r4 = -r3;
        goto L7
    }

    public ZonedDateTime minusMinutes(long r3) {
        if (r3 != Long.MIN_VALUE) goto L5;
        ZonedDateTime this = plusMinutes(Long.MAX_VALUE);
        long r4 = 1;
    L7:
        return this.plusMinutes(r4);
    L5:
        r4 = -r3;
        goto L7
    }

    public ZonedDateTime minusSeconds(long r3) {
        if (r3 != Long.MIN_VALUE) goto L5;
        ZonedDateTime this = plusSeconds(Long.MAX_VALUE);
        long r4 = 1;
    L7:
        return this.plusSeconds(r4);
    L5:
        r4 = -r3;
        goto L7
    }

    public ZonedDateTime minusNanos(long r3) {
        if (r3 != Long.MIN_VALUE) goto L5;
        ZonedDateTime this = plusNanos(Long.MAX_VALUE);
        long r4 = 1;
    L7:
        return this.plusNanos(r4);
    L5:
        r4 = -r3;
        goto L7
    }

    @Override // org.threeten.bp.chrono.ChronoZonedDateTime, org.threeten.bp.jdk8.DefaultInterfaceTemporalAccessor, org.threeten.bp.temporal.TemporalAccessor
    public <R> R query(TemporalQuery<R> r3) {
        TemporalQuery<R> r4 = (TemporalQuery) ZeusTransformUtils.wrapperContextForParams(r3, TemporalQuery.class, "com.obric.aiagent.plugin");
        if (r4 != TemporalQueries.localDate()) goto L7;
        return (R) toLocalDate();
    L7:
        return (R) super.query(r4);
    }

    @Override // org.threeten.bp.temporal.Temporal
    public long until(Temporal r3, TemporalUnit r4) {
        Temporal r5 = (Temporal) ZeusTransformUtils.wrapperContextForParams(r3, Temporal.class, "com.obric.aiagent.plugin");
        TemporalUnit r6 = (TemporalUnit) ZeusTransformUtils.wrapperContextForParams(r4, TemporalUnit.class, "com.obric.aiagent.plugin");
        ZonedDateTime r7 = from(r5);
        if (ZeusTransformUtils.instanceOf(r6, ChronoUnit.class) == false) goto L11;
        ZonedDateTime r8 = r7.withZoneSameInstant(this.zone);
        if (r6.isDateBased() == false) goto L9;
        return this.dateTime.until(r8.dateTime, r6);
    L9:
        return toOffsetDateTime().until(r8.toOffsetDateTime(), r6);
    L11:
        return r6.between(this, r7);
    }

    @Override // org.threeten.bp.chrono.ChronoZonedDateTime
    public LocalDateTime toLocalDateTime() {
        return this.dateTime;
    }

    @Override // org.threeten.bp.chrono.ChronoZonedDateTime
    public LocalDate toLocalDate() {
        return this.dateTime.toLocalDate();
    }

    @Override // org.threeten.bp.chrono.ChronoZonedDateTime
    public LocalTime toLocalTime() {
        return this.dateTime.toLocalTime();
    }

    public OffsetDateTime toOffsetDateTime() {
        return OffsetDateTime.of(this.dateTime, this.offset);
    }

    @Override // org.threeten.bp.chrono.ChronoZonedDateTime
    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r5, ZonedDateTime.class) == false) goto L16;
        ZonedDateTime r6 = (ZonedDateTime) ZeusTransformUtils.preCheckCast(r5, ZonedDateTime.class, "com.obric.aiagent.plugin");
        if (this.dateTime.equals(r6.dateTime) == false) goto L15;
        if (this.offset.equals(r6.offset) == false) goto L15;
        if (this.zone.equals(r6.zone) == false) goto L15;
        return true;
    L15:
        return false;
    L16:
        return false;
    }

    @Override // org.threeten.bp.chrono.ChronoZonedDateTime
    public int hashCode() {
        int r0 = this.dateTime.hashCode() ^ this.offset.hashCode();
        return Integer.rotateLeft(this.zone.hashCode(), 3) ^ r0;
    }

    @Override // org.threeten.bp.chrono.ChronoZonedDateTime
    public String toString() {
        String r0 = this.dateTime.toString() + this.offset.toString();
        if (this.offset != this.zone) goto L5;
        return r0;
    L5:
        return r0 + '[' + this.zone.toString() + ']';
    }

    @Override // org.threeten.bp.chrono.ChronoZonedDateTime
    public String format(DateTimeFormatter r1) {
        return super.format(r1);
    }

    private Object writeReplace() {
        return new Ser((byte) 6, this);
    }

    private Object readResolve() {
        throw new InvalidObjectException("Deserialization via serialization delegate");
    }

    void writeExternal(DataOutput r3) {
        DataOutput r4 = (DataOutput) ZeusTransformUtils.wrapperContextForParams(r3, DataOutput.class, "com.obric.aiagent.plugin");
        this.dateTime.writeExternal(r4);
        this.offset.writeExternal(r4);
        this.zone.write(r4);
    }

    static ZonedDateTime readExternal(DataInput r4) {
        DataInput r5 = (DataInput) ZeusTransformUtils.wrapperContextForParams(r4, DataInput.class, "com.obric.aiagent.plugin");
        return ofLenient(LocalDateTime.readExternal(r5), ZoneOffset.readExternal(r5), (ZoneId) ZeusTransformUtils.preCheckCast(Ser.read(r5), ZoneId.class, "com.obric.aiagent.plugin"));
    }
}
