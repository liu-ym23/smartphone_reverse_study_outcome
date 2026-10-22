package com.ethlo.time;

import java.time.LocalDate;
import java.time.OffsetDateTime;
import java.time.Year;
import java.time.YearMonth;
import java.time.temporal.ChronoField;
import java.time.temporal.Temporal;
import java.time.temporal.TemporalField;
import java.time.temporal.UnsupportedTemporalTypeException;

/* loaded from: classes.dex */
public enum Field {
    YEAR(4),
    MONTH(7),
    DAY(10),
    HOUR(13),
    MINUTE(16),
    SECOND(19),
    NANO(20),
    ZONE_OFFSET(17);

    private final int requiredLength;

    Field(int i10) {
        this.requiredLength = i10;
    }

    public static Field of(TemporalField temporalField) {
        if (temporalField.equals(ChronoField.YEAR)) {
            return YEAR;
        }
        if (temporalField.equals(ChronoField.MONTH_OF_YEAR)) {
            return MONTH;
        }
        if (temporalField.equals(ChronoField.DAY_OF_MONTH)) {
            return DAY;
        }
        if (temporalField.equals(ChronoField.HOUR_OF_DAY)) {
            return HOUR;
        }
        if (temporalField.equals(ChronoField.MINUTE_OF_HOUR)) {
            return MINUTE;
        }
        if (temporalField.equals(ChronoField.SECOND_OF_MINUTE)) {
            return SECOND;
        }
        if (temporalField.equals(ChronoField.NANO_OF_SECOND)) {
            return NANO;
        }
        throw new UnsupportedTemporalTypeException("Unsupported field: " + temporalField);
    }

    public int getRequiredLength() {
        return this.requiredLength;
    }

    public static Field valueOf(Class<? extends Temporal> cls) {
        if (Year.class.equals(cls)) {
            return YEAR;
        }
        if (YearMonth.class.equals(cls)) {
            return MONTH;
        }
        if (LocalDate.class.equals(cls)) {
            return DAY;
        }
        if (OffsetDateTime.class.equals(cls)) {
            return SECOND;
        }
        throw new IllegalArgumentException("Type " + cls.getSimpleName() + " is not supported");
    }
}
