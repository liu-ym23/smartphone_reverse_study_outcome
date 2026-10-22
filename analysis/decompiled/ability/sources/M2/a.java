package M2;

import com.ethlo.time.Field;
import com.ethlo.time.LeapSecondException;
import com.ethlo.time.internal.DateTimeFormatException;
import com.tencent.mmkv.MMKV;
import java.time.DateTimeException;
import java.time.LocalDate;
import java.time.Month;
import java.time.OffsetDateTime;
import java.time.YearMonth;
import java.time.ZoneOffset;
import java.time.temporal.ChronoField;
import java.time.temporal.TemporalAccessor;
import java.time.temporal.TemporalField;
import java.time.temporal.UnsupportedTemporalTypeException;
import java.util.Objects;
import java.util.Optional;
import java.util.TreeSet;

/* loaded from: classes2.dex */
public final class a implements TemporalAccessor {
    public static final O2.a k = new O2.a(0);

    /* renamed from: a, reason: collision with root package name */
    public final Field f960a;
    public final int b;
    public final int c;
    public final int d;
    public final int e;
    public final int f;
    public final int g;
    public final int h;
    public final d i;

    /* renamed from: j, reason: collision with root package name */
    public final int f961j;

    public a(Field field, int i, int i6, int i10, int i11, int i12, int i13, int i14, d dVar, int i15) {
        this.f960a = field;
        this.b = i;
        this.c = i6;
        this.d = i10;
        this.e = i11;
        this.f = i12;
        this.g = i13;
        this.h = i14;
        this.i = dVar;
        this.f961j = i15;
        if (i13 == 60) {
            YearMonth yearMonthOf = YearMonth.of(i, i6);
            O2.a aVar = k;
            boolean zContains = ((TreeSet) aVar.b).contains(yearMonthOf);
            if (zContains || yearMonthOf.isAfter((YearMonth) aVar.c)) {
                d dVar2 = d.c;
                dVar = dVar == null ? dVar2 : dVar;
                int iA = i11 - (dVar.a() / MMKV.ExpireInHour);
                int iA2 = i12 - ((dVar.a() % MMKV.ExpireInHour) / 60);
                if (((i6 == Month.DECEMBER.getValue() && i10 == 31) || (i6 == Month.JUNE.getValue() && i10 == 30)) && iA == 23 && iA2 == 59) {
                    OffsetDateTime.of(i, i6, i10, i11, i12, 59, i14, dVar.equals(dVar2) ? ZoneOffset.UTC : ZoneOffset.ofHoursMinutes(dVar.f963a, dVar.b)).plusSeconds(1L);
                    throw new LeapSecondException(zContains);
                }
            }
        }
        if (field.ordinal() >= 2) {
            LocalDate.of(i, i6, i10);
        }
        if (i13 > 59) {
            throw new DateTimeException(String.format("Invalid value for SecondOfMinute (valid values 0 - 59): %d", Integer.valueOf(i13)));
        }
    }

    public static String a(a aVar, Field field, int i) {
        int iOrdinal = field.ordinal();
        Field field2 = aVar.f960a;
        if (iOrdinal > field2.ordinal()) {
            throw new DateTimeFormatException(B7.a.n("Requested granularity was ", field.name(), ", but contains only granularity ", field2.name()));
        }
        d dVar = (d) Optional.ofNullable(aVar.i).orElse(null);
        char[] cArr = new char[35];
        O2.b.c(aVar.b, 0, cArr, 4);
        if (field == Field.YEAR) {
            return com.stepos.statsrpk.d.w(cArr, 4, null);
        }
        if (field.ordinal() >= 1) {
            cArr[4] = '-';
            O2.b.c(aVar.c, 5, cArr, 2);
        }
        if (field == Field.MONTH) {
            return com.stepos.statsrpk.d.w(cArr, 7, null);
        }
        if (field.ordinal() >= 2) {
            cArr[7] = '-';
            O2.b.c(aVar.d, 8, cArr, 2);
        }
        if (field == Field.DAY) {
            return com.stepos.statsrpk.d.w(cArr, 10, null);
        }
        if (field.ordinal() >= 3) {
            cArr[10] = 'T';
            O2.b.c(aVar.e, 11, cArr, 2);
        }
        if (field == Field.HOUR) {
            return com.stepos.statsrpk.d.w(cArr, 13, dVar);
        }
        if (field.ordinal() >= 4) {
            cArr[13] = ':';
            O2.b.c(aVar.f, 14, cArr, 2);
        }
        if (field == Field.MINUTE) {
            return com.stepos.statsrpk.d.w(cArr, 16, dVar);
        }
        if (field.ordinal() >= 5) {
            cArr[16] = ':';
            O2.b.c(aVar.g, 17, cArr, 2);
        }
        if (field == Field.SECOND) {
            return com.stepos.statsrpk.d.w(cArr, 19, dVar);
        }
        if (i > 0 && field.ordinal() >= 6) {
            cArr[19] = '.';
            O2.b.c(aVar.h, 20, cArr, i);
        }
        return com.stepos.statsrpk.d.w(cArr, (i > 0 ? 1 : 0) + 19 + i, dVar);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && a.class == obj.getClass()) {
            a aVar = (a) obj;
            if (this.b == aVar.b && this.c == aVar.c && this.d == aVar.d && this.e == aVar.e && this.f == aVar.f && this.g == aVar.g && this.h == aVar.h && this.f961j == aVar.f961j && this.f960a == aVar.f960a && Objects.equals(this.i, aVar.i)) {
                return true;
            }
        }
        return false;
    }

    @Override // java.time.temporal.TemporalAccessor
    public final long getLong(TemporalField temporalField) {
        boolean zEquals = temporalField.equals(ChronoField.YEAR);
        int i = this.b;
        if (zEquals) {
            return i;
        }
        boolean zEquals2 = temporalField.equals(ChronoField.MONTH_OF_YEAR);
        int i6 = this.c;
        if (zEquals2) {
            return i6;
        }
        boolean zEquals3 = temporalField.equals(ChronoField.DAY_OF_MONTH);
        int i10 = this.d;
        if (zEquals3) {
            return i10;
        }
        boolean zEquals4 = temporalField.equals(ChronoField.HOUR_OF_DAY);
        int i11 = this.e;
        if (zEquals4) {
            return i11;
        }
        boolean zEquals5 = temporalField.equals(ChronoField.MINUTE_OF_HOUR);
        int i12 = this.f;
        if (zEquals5) {
            return i12;
        }
        boolean zEquals6 = temporalField.equals(ChronoField.SECOND_OF_MINUTE);
        int i13 = this.g;
        if (zEquals6) {
            return i13;
        }
        boolean zEquals7 = temporalField.equals(ChronoField.NANO_OF_SECOND);
        int i14 = this.h;
        if (zEquals7) {
            return i14;
        }
        if (temporalField.equals(ChronoField.NANO_OF_DAY)) {
            return (((i12 * 60) + (i11 * 3600) + i13) * 1000000000) + i14;
        }
        if (!temporalField.equals(ChronoField.INSTANT_SECONDS)) {
            throw new UnsupportedTemporalTypeException("Unsupported field: " + temporalField);
        }
        long j5 = (i12 * 60) + (i11 * 3600) + i13;
        if (i6 == 0) {
            i6 = 1;
        }
        if (i10 == 0) {
            i10 = 1;
        }
        int i15 = i - (i6 > 2 ? 0 : 1);
        long j6 = (i15 >= 0 ? i15 : i15 - 399) / 400;
        long j10 = i15 - (400 * j6);
        return (((((j6 * 146097) + ((((j10 / 4) + (365 * j10)) - (j10 / 100)) + ((((((i6 > 2 ? i6 - 3 : i6 + 9) * 153) + 2) / 5) + i10) - 1))) - 719468) * 86400) + j5) - (this.i != null ? r14.a() : 0L);
    }

    public final int hashCode() {
        return Objects.hash(Integer.valueOf(this.f960a.ordinal()), Integer.valueOf(this.b), Integer.valueOf(this.c), Integer.valueOf(this.d), Integer.valueOf(this.e), Integer.valueOf(this.f), Integer.valueOf(this.g), Integer.valueOf(this.h), this.i, Integer.valueOf(this.f961j));
    }

    @Override // java.time.temporal.TemporalAccessor
    public final boolean isSupported(TemporalField temporalField) {
        Field field;
        if (temporalField == ChronoField.NANO_OF_DAY) {
            return true;
        }
        if (temporalField.equals(ChronoField.YEAR)) {
            field = Field.YEAR;
        } else if (temporalField.equals(ChronoField.MONTH_OF_YEAR)) {
            field = Field.MONTH;
        } else if (temporalField.equals(ChronoField.DAY_OF_MONTH)) {
            field = Field.DAY;
        } else if (temporalField.equals(ChronoField.HOUR_OF_DAY)) {
            field = Field.HOUR;
        } else if (temporalField.equals(ChronoField.MINUTE_OF_HOUR)) {
            field = Field.MINUTE;
        } else if (temporalField.equals(ChronoField.SECOND_OF_MINUTE)) {
            field = Field.SECOND;
        } else {
            if (!temporalField.equals(ChronoField.NANO_OF_SECOND)) {
                throw new UnsupportedTemporalTypeException("Unsupported field: " + temporalField);
            }
            field = Field.NANO;
        }
        return field.ordinal() <= this.f960a.ordinal();
    }

    public final String toString() {
        int i = this.f961j;
        return i > 0 ? a(this, Field.NANO, i) : a(this, this.f960a, 0);
    }
}
