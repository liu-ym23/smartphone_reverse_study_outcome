package org.threeten.bp.format;

import com.android.contacts.common.compat.DirectorySdkCompat;
import com.android.contacts.common.list.DefaultContactListAdapter;
import com.android.contacts.util.HanziToPinyin;
import com.ttnet.org.chromium.base.TimeUtils;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import org.threeten.bp.DateTimeException;
import org.threeten.bp.Instant;
import org.threeten.bp.LocalDate;
import org.threeten.bp.LocalTime;
import org.threeten.bp.Period;
import org.threeten.bp.ZoneId;
import org.threeten.bp.ZoneOffset;
import org.threeten.bp.chrono.ChronoLocalDate;
import org.threeten.bp.chrono.ChronoLocalDateTime;
import org.threeten.bp.chrono.ChronoZonedDateTime;
import org.threeten.bp.chrono.Chronology;
import org.threeten.bp.chrono.IsoChronology;
import org.threeten.bp.jdk8.DefaultInterfaceTemporalAccessor;
import org.threeten.bp.jdk8.Jdk8Methods;
import org.threeten.bp.temporal.ChronoField;
import org.threeten.bp.temporal.TemporalAccessor;
import org.threeten.bp.temporal.TemporalField;
import org.threeten.bp.temporal.TemporalQueries;
import org.threeten.bp.temporal.TemporalQuery;

/* JADX INFO: loaded from: classes5.dex */
final class DateTimeBuilder extends DefaultInterfaceTemporalAccessor implements TemporalAccessor, Cloneable {
    Chronology chrono;
    ChronoLocalDate date;
    Period excessDays;
    final Map<TemporalField, Long> fieldValues;
    boolean leapSecond;
    LocalTime time;
    ZoneId zone;

    public DateTimeBuilder() {
        this.fieldValues = new HashMap();
    }

    public DateTimeBuilder(TemporalField r2, long r3) {
        this.fieldValues = new HashMap();
        addFieldValue(r2, r3);
    }

    private Long getFieldValue0(TemporalField r1) {
        return this.fieldValues.get(r1);
    }

    DateTimeBuilder addFieldValue(TemporalField r5, long r6) {
        Jdk8Methods.requireNonNull(r5, "field");
        Long r0 = getFieldValue0(r5);
        if (r0 == null) goto L10;
        if (r0.longValue() == r6) goto L10;
        throw new DateTimeException("Conflict found: " + r5 + HanziToPinyin.Token.SEPARATOR + r0 + " differs from " + r5 + HanziToPinyin.Token.SEPARATOR + r6 + ": " + this);
    L10:
        return putFieldValue0(r5, r6);
    }

    private DateTimeBuilder putFieldValue0(TemporalField r2, long r3) {
        this.fieldValues.put(r2, Long.valueOf(r3));
        return this;
    }

    void addObject(ChronoLocalDate r1) {
        this.date = r1;
    }

    void addObject(LocalTime r1) {
        this.time = r1;
    }

    public DateTimeBuilder resolve(ResolverStyle r2, Set<TemporalField> r3) {
        if (r3 == null) goto L4;
        this.fieldValues.keySet().retainAll(r3);
    L4:
        mergeInstantFields();
        mergeDate(r2);
        mergeTime(r2);
        if (resolveFields(r2) == false) goto L7;
        mergeInstantFields();
        mergeDate(r2);
        mergeTime(r2);
    L7:
        resolveTimeInferZeroes(r2);
        crossCheck();
        Period r4 = this.excessDays;
        if (r4 != null) goto L10;
    L16:
        resolveFractional();
        resolveInstant();
        return this;
    L10:
        if (r4.isZero() == true) goto L16;
        ChronoLocalDate r5 = this.date;
        if (r5 == null) goto L16;
        if (this.time == null) goto L16;
        this.date = r5.plus(this.excessDays);
        this.excessDays = Period.ZERO;
        goto L16
    }

    private boolean resolveFields(ResolverStyle r7) {
        int r1 = 0;
    L4:
        if (r1 >= 100) goto L34;
        Iterator<Map.Entry<TemporalField, Long>> r3 = this.fieldValues.entrySet().iterator();
    L7:
        if (r3.hasNext() == false) goto L34;
        TemporalField r4 = r3.next().getKey();
        TemporalAccessor r5 = r4.resolve(this.fieldValues, this, r7);
        if (r5 != null) goto L11;
        if (this.fieldValues.containsKey(r4) == true) goto L7;
    L33:
        r1 = r1 + 1;
        goto L4
    L11:
        if ((r5 instanceof ChronoZonedDateTime) == false) goto L21;
        ChronoZonedDateTime r6 = (ChronoZonedDateTime) r5;
        ZoneId r2 = this.zone;
        if (r2 != null) goto L16;
        this.zone = r6.getZone();
    L17:
        r5 = r6.toLocalDateTime();
        goto L21
    L16:
        if (r2.equals(r6.getZone()) == true) goto L17;
        throw new DateTimeException("ChronoZonedDateTime must use the effective parsed zone: " + this.zone);
    L21:
        if ((r5 instanceof ChronoLocalDate) == false) goto L24;
        resolveMakeChanges(r4, (ChronoLocalDate) r5);
        goto L33
    L24:
        if ((r5 instanceof LocalTime) == false) goto L27;
        resolveMakeChanges(r4, (LocalTime) r5);
        goto L33
    L27:
        if ((r5 instanceof ChronoLocalDateTime) == false) goto L30;
        ChronoLocalDateTime r8 = (ChronoLocalDateTime) r5;
        resolveMakeChanges(r4, r8.toLocalDate());
        resolveMakeChanges(r4, r8.toLocalTime());
        goto L33
    L30:
        throw new DateTimeException("Unknown type: " + r5.getClass().getName());
    L34:
        if (r1 == 100) goto L39;
        if (r1 <= 0) goto L50;
        return true;
    L50:
        return false;
    L39:
        throw new DateTimeException("Badly written field");
    }

    private void resolveMakeChanges(TemporalField r6, ChronoLocalDate r7) {
        if (this.chrono.equals(r7.getChronology()) == false) goto L13;
        long r0 = r7.toEpochDay();
        Long r5 = this.fieldValues.put(ChronoField.EPOCH_DAY, Long.valueOf(r0));
        if (r5 != null) goto L7;
        return;
    L7:
        if (r5.longValue() != r0) goto L10;
        return;
    L10:
        throw new DateTimeException("Conflict found: " + LocalDate.ofEpochDay(r5.longValue()) + " differs from " + LocalDate.ofEpochDay(r0) + " while resolving  " + r6);
    L13:
        throw new DateTimeException("ChronoLocalDate must use the effective parsed chronology: " + this.chrono);
    }

    private void resolveMakeChanges(TemporalField r5, LocalTime r6) {
        long r0 = r6.toNanoOfDay();
        Long r4 = this.fieldValues.put(ChronoField.NANO_OF_DAY, Long.valueOf(r0));
        if (r4 != null) goto L5;
        return;
    L5:
        if (r4.longValue() != r0) goto L8;
        return;
    L8:
        throw new DateTimeException("Conflict found: " + LocalTime.ofNanoOfDay(r4.longValue()) + " differs from " + r6 + " while resolving  " + r5);
    }

    private void mergeDate(ResolverStyle r3) {
        if ((this.chrono instanceof IsoChronology) == false) goto L6;
        checkDate(IsoChronology.INSTANCE.resolveDate(this.fieldValues, r3));
        return;
    L6:
        if (this.fieldValues.containsKey(ChronoField.EPOCH_DAY) == false) goto L10;
        checkDate(LocalDate.ofEpochDay(this.fieldValues.remove(ChronoField.EPOCH_DAY).longValue()));
        return;
    }

    private void checkDate(LocalDate r8) {
        if (r8 == null) goto L16;
        addObject(r8);
        Iterator<TemporalField> r0 = this.fieldValues.keySet().iterator();
    L5:
        if (r0.hasNext() == false) goto L28;
        TemporalField r1 = r0.next();
        if ((r1 instanceof ChronoField) == false) goto L5;
        if (r1.isDateBased() == false) goto L5;
        long r2 = r8.getLong(r1);     // Catch: DateTimeException -> L17
        Long r4 = this.fieldValues.get(r1);
        if (r2 == r4.longValue()) goto L5;
        throw new DateTimeException("Conflict found: Field " + r1 + HanziToPinyin.Token.SEPARATOR + r2 + " differs from " + r1 + HanziToPinyin.Token.SEPARATOR + r4 + " derived from " + r8);
    L28:
        return;
    }

    private void mergeTime(ResolverStyle r12) {
        long r1 = 0;
        if (this.fieldValues.containsKey(ChronoField.CLOCK_HOUR_OF_DAY) == false) goto L17;
        long r3 = this.fieldValues.remove(ChronoField.CLOCK_HOUR_OF_DAY).longValue();
        if (r12 != ResolverStyle.LENIENT) goto L7;
    L12:
        ChronoField r0 = ChronoField.HOUR_OF_DAY;
        if (r3 != 24) goto L15;
        r3 = 0;
    L15:
        addFieldValue(r0, r3);
        goto L17
    L7:
        if (r12 == ResolverStyle.SMART) goto L9;
    L11:
        ChronoField.CLOCK_HOUR_OF_DAY.checkValidValue(r3);
        goto L12
    L9:
        if (r3 != 0) goto L11;
    L17:
        if (this.fieldValues.containsKey(ChronoField.CLOCK_HOUR_OF_AMPM) == false) goto L32;
        long r5 = this.fieldValues.remove(ChronoField.CLOCK_HOUR_OF_AMPM).longValue();
        if (r12 != ResolverStyle.LENIENT) goto L21;
    L26:
        ChronoField r2 = ChronoField.HOUR_OF_AMPM;
        if (r5 == 12) goto L30;
        r1 = r5;
    L30:
        addFieldValue(r2, r1);
        goto L32
    L21:
        if (r12 == ResolverStyle.SMART) goto L23;
    L25:
        ChronoField.CLOCK_HOUR_OF_AMPM.checkValidValue(r5);
        goto L26
    L23:
        if (r5 != 0) goto L25;
    L32:
        if (r12 == ResolverStyle.LENIENT) goto L40;
        if (this.fieldValues.containsKey(ChronoField.AMPM_OF_DAY) == false) goto L37;
        ChronoField.AMPM_OF_DAY.checkValidValue(this.fieldValues.get(ChronoField.AMPM_OF_DAY).longValue());
    L37:
        if (this.fieldValues.containsKey(ChronoField.HOUR_OF_AMPM) == false) goto L40;
        ChronoField.HOUR_OF_AMPM.checkValidValue(this.fieldValues.get(ChronoField.HOUR_OF_AMPM).longValue());
    L40:
        if (this.fieldValues.containsKey(ChronoField.AMPM_OF_DAY) == false) goto L45;
        if (this.fieldValues.containsKey(ChronoField.HOUR_OF_AMPM) == false) goto L45;
        long r4 = this.fieldValues.remove(ChronoField.AMPM_OF_DAY).longValue();
        addFieldValue(ChronoField.HOUR_OF_DAY, (r4 * 12) + this.fieldValues.remove(ChronoField.HOUR_OF_AMPM).longValue());
    L45:
        if (this.fieldValues.containsKey(ChronoField.NANO_OF_DAY) == false) goto L51;
        long r6 = this.fieldValues.remove(ChronoField.NANO_OF_DAY).longValue();
        if (r12 == ResolverStyle.LENIENT) goto L49;
        ChronoField.NANO_OF_DAY.checkValidValue(r6);
    L49:
        addFieldValue(ChronoField.SECOND_OF_DAY, r6 / DirectorySdkCompat.ENTERPRISE_LOCAL_DEFAULT);
        addFieldValue(ChronoField.NANO_OF_SECOND, r6 % DirectorySdkCompat.ENTERPRISE_LOCAL_DEFAULT);
    L51:
        if (this.fieldValues.containsKey(ChronoField.MICRO_OF_DAY) == false) goto L57;
        long r7 = this.fieldValues.remove(ChronoField.MICRO_OF_DAY).longValue();
        if (r12 == ResolverStyle.LENIENT) goto L55;
        ChronoField.MICRO_OF_DAY.checkValidValue(r7);
    L55:
        addFieldValue(ChronoField.SECOND_OF_DAY, r7 / 1000000);
        addFieldValue(ChronoField.MICRO_OF_SECOND, r7 % 1000000);
    L57:
        if (this.fieldValues.containsKey(ChronoField.MILLI_OF_DAY) == false) goto L63;
        long r8 = this.fieldValues.remove(ChronoField.MILLI_OF_DAY).longValue();
        if (r12 == ResolverStyle.LENIENT) goto L61;
        ChronoField.MILLI_OF_DAY.checkValidValue(r8);
    L61:
        addFieldValue(ChronoField.SECOND_OF_DAY, r8 / 1000);
        addFieldValue(ChronoField.MILLI_OF_SECOND, r8 % 1000);
    L63:
        if (this.fieldValues.containsKey(ChronoField.SECOND_OF_DAY) == false) goto L69;
        long r9 = this.fieldValues.remove(ChronoField.SECOND_OF_DAY).longValue();
        if (r12 == ResolverStyle.LENIENT) goto L67;
        ChronoField.SECOND_OF_DAY.checkValidValue(r9);
    L67:
        addFieldValue(ChronoField.HOUR_OF_DAY, r9 / TimeUtils.SECONDS_PER_HOUR);
        addFieldValue(ChronoField.MINUTE_OF_HOUR, (r9 / 60) % 60);
        addFieldValue(ChronoField.SECOND_OF_MINUTE, r9 % 60);
    L69:
        if (this.fieldValues.containsKey(ChronoField.MINUTE_OF_DAY) == false) goto L75;
        long r10 = this.fieldValues.remove(ChronoField.MINUTE_OF_DAY).longValue();
        if (r12 == ResolverStyle.LENIENT) goto L73;
        ChronoField.MINUTE_OF_DAY.checkValidValue(r10);
    L73:
        addFieldValue(ChronoField.HOUR_OF_DAY, r10 / 60);
        addFieldValue(ChronoField.MINUTE_OF_HOUR, r10 % 60);
    L75:
        if (r12 == ResolverStyle.LENIENT) goto L83;
        if (this.fieldValues.containsKey(ChronoField.MILLI_OF_SECOND) == false) goto L80;
        ChronoField.MILLI_OF_SECOND.checkValidValue(this.fieldValues.get(ChronoField.MILLI_OF_SECOND).longValue());
    L80:
        if (this.fieldValues.containsKey(ChronoField.MICRO_OF_SECOND) == false) goto L83;
        ChronoField.MICRO_OF_SECOND.checkValidValue(this.fieldValues.get(ChronoField.MICRO_OF_SECOND).longValue());
    L83:
        if (this.fieldValues.containsKey(ChronoField.MILLI_OF_SECOND) == false) goto L88;
        if (this.fieldValues.containsKey(ChronoField.MICRO_OF_SECOND) == false) goto L88;
        addFieldValue(ChronoField.MICRO_OF_SECOND, (this.fieldValues.remove(ChronoField.MILLI_OF_SECOND).longValue() * 1000) + (this.fieldValues.get(ChronoField.MICRO_OF_SECOND).longValue() % 1000));
    L88:
        if (this.fieldValues.containsKey(ChronoField.MICRO_OF_SECOND) == false) goto L93;
        if (this.fieldValues.containsKey(ChronoField.NANO_OF_SECOND) == false) goto L93;
        addFieldValue(ChronoField.MICRO_OF_SECOND, this.fieldValues.get(ChronoField.NANO_OF_SECOND).longValue() / 1000);
        this.fieldValues.remove(ChronoField.MICRO_OF_SECOND);
    L93:
        if (this.fieldValues.containsKey(ChronoField.MILLI_OF_SECOND) == false) goto L98;
        if (this.fieldValues.containsKey(ChronoField.NANO_OF_SECOND) == false) goto L98;
        addFieldValue(ChronoField.MILLI_OF_SECOND, this.fieldValues.get(ChronoField.NANO_OF_SECOND).longValue() / 1000000);
        this.fieldValues.remove(ChronoField.MILLI_OF_SECOND);
    L98:
        if (this.fieldValues.containsKey(ChronoField.MICRO_OF_SECOND) == false) goto L101;
        addFieldValue(ChronoField.NANO_OF_SECOND, this.fieldValues.remove(ChronoField.MICRO_OF_SECOND).longValue() * 1000);
        return;
    L101:
        if (this.fieldValues.containsKey(ChronoField.MILLI_OF_SECOND) == false) goto L105;
        addFieldValue(ChronoField.NANO_OF_SECOND, this.fieldValues.remove(ChronoField.MILLI_OF_SECOND).longValue() * 1000000);
        return;
    }

    private void resolveTimeInferZeroes(ResolverStyle r13) {
        Long r0 = this.fieldValues.get(ChronoField.HOUR_OF_DAY);
        Long r1 = this.fieldValues.get(ChronoField.MINUTE_OF_HOUR);
        Long r2 = this.fieldValues.get(ChronoField.SECOND_OF_MINUTE);
        Long r3 = this.fieldValues.get(ChronoField.NANO_OF_SECOND);
        if (r0 != null) goto L5;
        return;
    L5:
        if (r1 != null) goto L9;
        if (r2 != null) goto L8;
        if (r3 == null) goto L9;
        return;
    L8:
        return;
    L9:
        if (r1 == null) goto L14;
        if (r2 != null) goto L14;
        if (r3 == null) goto L14;
        return;
    L14:
        if (r13 == ResolverStyle.LENIENT) goto L43;
        if (r0 != null) goto L17;
    L52:
        this.fieldValues.remove(ChronoField.HOUR_OF_DAY);
        this.fieldValues.remove(ChronoField.MINUTE_OF_HOUR);
        this.fieldValues.remove(ChronoField.SECOND_OF_MINUTE);
        this.fieldValues.remove(ChronoField.NANO_OF_SECOND);
        return;
    L17:
        if (r13 == ResolverStyle.SMART) goto L19;
    L30:
        int r14 = ChronoField.HOUR_OF_DAY.checkValidIntValue(r0.longValue());
        if (r1 == null) goto L40;
        int r4 = ChronoField.MINUTE_OF_HOUR.checkValidIntValue(r1.longValue());
        if (r2 == null) goto L38;
        int r5 = ChronoField.SECOND_OF_MINUTE.checkValidIntValue(r2.longValue());
        if (r3 == null) goto L37;
        addObject(LocalTime.of(r14, r4, r5, ChronoField.NANO_OF_SECOND.checkValidIntValue(r3.longValue())));
        goto L52
    L37:
        addObject(LocalTime.of(r14, r4, r5));
        goto L52
    L38:
        if (r3 != null) goto L52;
        addObject(LocalTime.of(r14, r4));
        goto L52
    L40:
        if (r2 != null) goto L52;
        if (r3 != null) goto L52;
        addObject(LocalTime.of(r14, 0));
        goto L52
    L19:
        if (r0.longValue() != 24) goto L30;
        if (r1 != null) goto L22;
    L23:
        if (r2 != null) goto L25;
    L26:
        if (r3 != null) goto L28;
    L29:
        r0 = 0L;
        this.excessDays = Period.ofDays(1);
        goto L30
    L28:
        if (r3.longValue() != 0) goto L30;
    L25:
        if (r2.longValue() != 0) goto L30;
    L22:
        if (r1.longValue() != 0) goto L30;
    L43:
        if (r0 == null) goto L52;
        long r10 = r0.longValue();
        if (r1 == null) goto L51;
        if (r2 == null) goto L50;
        if (r3 != null) goto L49;
        r3 = 0L;
    L49:
        long r6 = Jdk8Methods.safeAdd(Jdk8Methods.safeAdd(Jdk8Methods.safeAdd(Jdk8Methods.safeMultiply(r10, 3600000000000L), Jdk8Methods.safeMultiply(r1.longValue(), 60000000000L)), Jdk8Methods.safeMultiply(r2.longValue(), DirectorySdkCompat.ENTERPRISE_LOCAL_DEFAULT)), r3.longValue());
        int r15 = (int) Jdk8Methods.floorDiv(r6, 86400000000000L);
        addObject(LocalTime.ofNanoOfDay(Jdk8Methods.floorMod(r6, 86400000000000L)));
        this.excessDays = Period.ofDays(r15);
        goto L52
    L50:
        long r7 = Jdk8Methods.safeAdd(Jdk8Methods.safeMultiply(r10, TimeUtils.SECONDS_PER_HOUR), Jdk8Methods.safeMultiply(r1.longValue(), 60));
        int r16 = (int) Jdk8Methods.floorDiv(r7, TimeUtils.SECONDS_PER_DAY);
        addObject(LocalTime.ofSecondOfDay(Jdk8Methods.floorMod(r7, TimeUtils.SECONDS_PER_DAY)));
        this.excessDays = Period.ofDays(r16);
        goto L52
    L51:
        int r17 = Jdk8Methods.safeToInt(Jdk8Methods.floorDiv(r10, 24));
        addObject(LocalTime.of(Jdk8Methods.floorMod(r10, 24), 0));
        this.excessDays = Period.ofDays(r17);
        goto L52
    }

    private void mergeInstantFields() {
        if (this.fieldValues.containsKey(ChronoField.INSTANT_SECONDS) == false) goto L11;
        ZoneId r0 = this.zone;
        if (r0 == null) goto L7;
        mergeInstantFields0(r0);
        return;
    L7:
        Long r1 = this.fieldValues.get(ChronoField.OFFSET_SECONDS);
        if (r1 == null) goto L13;
        mergeInstantFields0(ZoneOffset.ofTotalSeconds(r1.intValue()));
        return;
    L13:
        return;
    }

    private void mergeInstantFields0(ZoneId r4) {
        ChronoZonedDateTime<?> r5 = this.chrono.zonedDateTime(Instant.ofEpochSecond(this.fieldValues.remove(ChronoField.INSTANT_SECONDS).longValue()), r4);
        if (this.date != null) goto L5;
        addObject(r5.toLocalDate());
    L6:
        addFieldValue(ChronoField.SECOND_OF_DAY, r5.toLocalTime().toSecondOfDay());
        return;
    L5:
        resolveMakeChanges(ChronoField.INSTANT_SECONDS, r5.toLocalDate());
        goto L6
    }

    private void crossCheck() {
        if (this.fieldValues.size() <= 0) goto L15;
        ChronoLocalDate r0 = this.date;
        if (r0 == null) goto L9;
        LocalTime r1 = this.time;
        if (r1 == null) goto L9;
        crossCheck(r0.atTime(r1));
        return;
    L9:
        if (r0 == null) goto L11;
        crossCheck(r0);
        return;
    L11:
        TemporalAccessor r2 = this.time;
        if (r2 == null) goto L18;
        crossCheck(r2);
        return;
    L18:
        return;
    }

    private void crossCheck(TemporalAccessor r7) {
        Iterator<Map.Entry<TemporalField, Long>> r6 = this.fieldValues.entrySet().iterator();
    L4:
        if (r6.hasNext() == false) goto L13;
        Map.Entry<TemporalField, Long> r0 = r6.next();
        TemporalField r1 = r0.getKey();
        long r2 = r0.getValue().longValue();
        if (r7.isSupported(r1) == false) goto L4;
        long r4 = r7.getLong(r1);     // Catch: RuntimeException -> L14
        if (r4 != r2) goto L12;
        r6.remove();
        goto L4
    L12:
        throw new DateTimeException("Cross check failed: " + r1 + HanziToPinyin.Token.SEPARATOR + r4 + " vs " + r1 + HanziToPinyin.Token.SEPARATOR + r2);
    }

    private void resolveFractional() {
        if (this.time == null) goto L5;
        return;
    L5:
        if (this.fieldValues.containsKey(ChronoField.INSTANT_SECONDS) == true) goto L11;
        if (this.fieldValues.containsKey(ChronoField.SECOND_OF_DAY) == true) goto L11;
        if (this.fieldValues.containsKey(ChronoField.SECOND_OF_MINUTE) == true) goto L11;
        return;
    L11:
        if (this.fieldValues.containsKey(ChronoField.NANO_OF_SECOND) == false) goto L13;
        long r0 = this.fieldValues.get(ChronoField.NANO_OF_SECOND).longValue();
        this.fieldValues.put(ChronoField.MICRO_OF_SECOND, Long.valueOf(r0 / 1000));
        this.fieldValues.put(ChronoField.MILLI_OF_SECOND, Long.valueOf(r0 / 1000000));
        return;
    L13:
        this.fieldValues.put(ChronoField.NANO_OF_SECOND, 0L);
        this.fieldValues.put(ChronoField.MICRO_OF_SECOND, 0L);
        this.fieldValues.put(ChronoField.MILLI_OF_SECOND, 0L);
    }

    private void resolveInstant() {
        ChronoLocalDate r0 = this.date;
        if (r0 == null) goto L13;
        LocalTime r1 = this.time;
        if (r1 != null) goto L7;
        return;
    L7:
        if (this.zone == null) goto L9;
        long r2 = r0.atTime(r1).atZone(this.zone).getLong(ChronoField.INSTANT_SECONDS);
        this.fieldValues.put(ChronoField.INSTANT_SECONDS, Long.valueOf(r2));
        return;
    L9:
        Long r3 = this.fieldValues.get(ChronoField.OFFSET_SECONDS);
        if (r3 == null) goto L16;
        ZoneOffset r4 = ZoneOffset.ofTotalSeconds(r3.intValue());
        long r5 = this.date.atTime(this.time).atZone(r4).getLong(ChronoField.INSTANT_SECONDS);
        this.fieldValues.put(ChronoField.INSTANT_SECONDS, Long.valueOf(r5));
        return;
    L16:
        return;
    }

    public <R> R build(TemporalQuery<R> r1) {
        return r1.queryFrom(this);
    }

    @Override // org.threeten.bp.temporal.TemporalAccessor
    public boolean isSupported(TemporalField r3) {
        if (r3 != null) goto L6;
        return false;
    L6:
        if (this.fieldValues.containsKey(r3) == true) goto L15;
        ChronoLocalDate r1 = this.date;
        if (r1 != null) goto L10;
    L11:
        LocalTime r2 = this.time;
        if (r2 != null) goto L14;
        return false;
    L14:
        if (r2.isSupported(r3) == true) goto L15;
        return false;
    L10:
        if (r1.isSupported(r3) == false) goto L11;
    L15:
        return true;
    }

    @Override // org.threeten.bp.temporal.TemporalAccessor
    public long getLong(TemporalField r3) {
        Jdk8Methods.requireNonNull(r3, "field");
        Long r0 = getFieldValue0(r3);
        if (r0 != null) goto L19;
        ChronoLocalDate r1 = this.date;
        if (r1 != null) goto L7;
    L10:
        LocalTime r2 = this.time;
        if (r2 == null) goto L17;
        if (r2.isSupported(r3) == false) goto L17;
        return this.time.getLong(r3);
    L17:
        throw new DateTimeException("Field not found: " + r3);
    L7:
        if (r1.isSupported(r3) == false) goto L10;
        return this.date.getLong(r3);
    L19:
        return r0.longValue();
    }

    @Override // org.threeten.bp.jdk8.DefaultInterfaceTemporalAccessor, org.threeten.bp.temporal.TemporalAccessor
    public <R> R query(TemporalQuery<R> r3) {
        if (r3 != TemporalQueries.zoneId()) goto L7;
        return (R) this.zone;
    L7:
        if (r3 != TemporalQueries.chronology()) goto L11;
        return (R) this.chrono;
    L11:
        if (r3 != TemporalQueries.localDate()) goto L17;
        ChronoLocalDate r2 = this.date;
        if (r2 != null) goto L15;
        return null;
    L15:
        return (R) LocalDate.from(r2);
    L17:
        if (r3 != TemporalQueries.localTime()) goto L21;
        return (R) this.time;
    L21:
        if (r3 == TemporalQueries.zone()) goto L31;
        if (r3 == TemporalQueries.offset()) goto L31;
        if (r3 != TemporalQueries.precision()) goto L29;
        return null;
    L29:
        return r3.queryFrom(this);
    L31:
        return r3.queryFrom(this);
    }

    public String toString() {
        StringBuilder r0 = new StringBuilder(128);
        r0.append("DateTimeBuilder[");
        if (this.fieldValues.size() <= 0) goto L5;
        r0.append("fields=").append(this.fieldValues);
    L5:
        r0.append(", ").append(this.chrono);
        r0.append(", ").append(this.zone);
        r0.append(", ").append(this.date);
        r0.append(", ").append(this.time);
        r0.append(DefaultContactListAdapter.SNIPPET_END_MATCH);
        return r0.toString();
    }
}
