package org.threeten.bp.format;

import com.android.common.speech.LoggingEvents;
import com.android.contacts.util.HanziToPinyin;
import java.util.Locale;
import org.threeten.bp.DateTimeException;
import org.threeten.bp.Instant;
import org.threeten.bp.ZoneId;
import org.threeten.bp.ZoneOffset;
import org.threeten.bp.chrono.ChronoLocalDate;
import org.threeten.bp.chrono.Chronology;
import org.threeten.bp.chrono.IsoChronology;
import org.threeten.bp.jdk8.Jdk8Methods;
import org.threeten.bp.temporal.ChronoField;
import org.threeten.bp.temporal.TemporalAccessor;
import org.threeten.bp.temporal.TemporalField;
import org.threeten.bp.temporal.TemporalQueries;
import org.threeten.bp.temporal.TemporalQuery;

/* JADX INFO: loaded from: classes5.dex */
final class DateTimePrintContext {
    private Locale locale;
    private int optional;
    private DecimalStyle symbols;
    private TemporalAccessor temporal;

    DateTimePrintContext(TemporalAccessor r1, DateTimeFormatter r2) {
        this.temporal = adjust(r1, r2);
        this.locale = r2.getLocale();
        this.symbols = r2.getDecimalStyle();
    }

    DateTimePrintContext(TemporalAccessor r1, Locale r2, DecimalStyle r3) {
        this.temporal = r1;
        this.locale = r2;
        this.symbols = r3;
    }

    private static TemporalAccessor adjust(final TemporalAccessor r9, DateTimeFormatter r10) {
        Chronology r0 = r10.getChronology();
        ZoneId r11 = r10.getZone();
        if (r0 != null) goto L6;
        if (r11 != null) goto L6;
        return r9;
    L6:
        Chronology r1 = (Chronology) r9.query(TemporalQueries.chronology());
        final ZoneId r2 = (ZoneId) r9.query(TemporalQueries.zoneId());
        final ChronoLocalDate r4 = null;
        if (Jdk8Methods.equals(r1, r0) == false) goto L10;
        r0 = null;
    L10:
        if (Jdk8Methods.equals(r2, r11) == false) goto L12;
        r11 = null;
    L12:
        if (r0 != null) goto L15;
        if (r11 != null) goto L15;
        return r9;
    L15:
        if (r0 == null) goto L17;
        final Chronology r3 = r0;
    L18:
        if (r11 == null) goto L21;
        r2 = r11;
    L21:
        if (r11 != null) goto L23;
    L37:
        if (r0 == null) goto L55;
        if (r9.isSupported(ChronoField.EPOCH_DAY) == false) goto L42;
        r4 = r3.date(r9);
        goto L55
    L42:
        if (r0 != IsoChronology.INSTANCE) goto L44;
        if (r1 == null) goto L55;
    L44:
        ChronoField[] r12 = ChronoField.values();
        int r5 = r12.length;
        int r6 = 0;
    L45:
        if (r6 >= r5) goto L55;
        ChronoField r7 = r12[r6];
        if (r7.isDateBased() == false) goto L53;
        if (r9.isSupported(r7) == false) goto L53;
        throw new DateTimeException("Invalid override chronology for temporal: " + r0 + HanziToPinyin.Token.SEPARATOR + r9);
    L53:
        r6 = r6 + 1;
    L55:
        return new AnonymousClass1(r4, r9, r3, r2);
    L23:
        if (r9.isSupported(ChronoField.INSTANT_SECONDS) == false) goto L29;
        if (r3 != null) goto L28;
        r3 = IsoChronology.INSTANCE;
    L28:
        return r3.zonedDateTime(Instant.from(r9), r11);
    L29:
        ZoneId r8 = r11.normalized();
        ZoneOffset r13 = (ZoneOffset) r9.query(TemporalQueries.offset());
        if ((r8 instanceof ZoneOffset) == false) goto L37;
        if (r13 == null) goto L37;
        if (r8.equals(r13) == true) goto L37;
        throw new DateTimeException("Invalid override zone for temporal: " + r11 + HanziToPinyin.Token.SEPARATOR + r9);
    L17:
        r3 = r1;
        goto L18
    }

    TemporalAccessor getTemporal() {
        return this.temporal;
    }

    Locale getLocale() {
        return this.locale;
    }

    DecimalStyle getSymbols() {
        return this.symbols;
    }

    void startOptional() {
        this.optional++;
    }

    void endOptional() {
        this.optional--;
    }

    <R> R getValue(TemporalQuery<R> r3) {
        R r4 = (R) this.temporal.query(r3);
        if (r4 == null) goto L5;
    L9:
        return r4;
    L5:
        if (this.optional != 0) goto L9;
        throw new DateTimeException("Unable to extract value: " + this.temporal.getClass());
    }

    Long getValue(TemporalField r3) {
        return Long.valueOf(this.temporal.getLong(r3));
    L4:
        e = move-exception;
        if (this.optional <= 0) goto L9;
        return null;
    L9:
        throw e;
    }

    public String toString() {
        return this.temporal.toString();
    }

    void setDateTime(TemporalAccessor r2) {
        Jdk8Methods.requireNonNull(r2, "temporal");
        this.temporal = r2;
    }

    void setLocale(Locale r2) {
        Jdk8Methods.requireNonNull(r2, LoggingEvents.VoiceIme.EXTRA_START_LOCALE);
        this.locale = r2;
    }
}
