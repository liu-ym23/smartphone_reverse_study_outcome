package org.threeten.bp.temporal;

import org.threeten.bp.LocalDate;
import org.threeten.bp.LocalTime;
import org.threeten.bp.ZoneId;
import org.threeten.bp.ZoneOffset;
import org.threeten.bp.chrono.Chronology;

/* JADX INFO: loaded from: classes5.dex */
public final class TemporalQueries {
    static final TemporalQuery<Chronology> CHRONO = null;
    static final TemporalQuery<LocalDate> LOCAL_DATE = null;
    static final TemporalQuery<LocalTime> LOCAL_TIME = null;
    static final TemporalQuery<ZoneOffset> OFFSET = null;
    static final TemporalQuery<TemporalUnit> PRECISION = null;
    static final TemporalQuery<ZoneId> ZONE = null;
    static final TemporalQuery<ZoneId> ZONE_ID = null;

    private TemporalQueries() {
    }

    public static final TemporalQuery<ZoneId> zoneId() {
        return ZONE_ID;
    }

    static {
        ZONE_ID = new AnonymousClass1();
        CHRONO = new AnonymousClass2();
        PRECISION = new AnonymousClass3();
        ZONE = new AnonymousClass4();
        OFFSET = new AnonymousClass5();
        LOCAL_DATE = new AnonymousClass6();
        LOCAL_TIME = new AnonymousClass7();
    }

    public static final TemporalQuery<Chronology> chronology() {
        return CHRONO;
    }

    public static final TemporalQuery<TemporalUnit> precision() {
        return PRECISION;
    }

    public static final TemporalQuery<ZoneId> zone() {
        return ZONE;
    }

    public static final TemporalQuery<ZoneOffset> offset() {
        return OFFSET;
    }

    public static final TemporalQuery<LocalDate> localDate() {
        return LOCAL_DATE;
    }

    public static final TemporalQuery<LocalTime> localTime() {
        return LOCAL_TIME;
    }
}
