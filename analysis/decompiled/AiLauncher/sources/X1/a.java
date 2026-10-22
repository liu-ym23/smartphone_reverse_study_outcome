package X1;

import Z1.f;
import com.ethlo.time.Field;
import com.ethlo.time.LeapSecondException;
import com.ethlo.time.internal.DateTimeFormatException;
import java.time.DateTimeException;
import java.time.LocalDate;
import java.time.Month;
import java.time.OffsetDateTime;
import java.time.YearMonth;
import java.time.format.DateTimeParseException;
import java.time.temporal.ChronoField;
import java.time.temporal.TemporalAccessor;
import java.time.temporal.TemporalField;
import java.time.temporal.UnsupportedTemporalTypeException;
import java.util.Objects;
import java.util.Optional;

/* loaded from: classes.dex */
public class a implements TemporalAccessor {

    /* renamed from: l, reason: collision with root package name */
    public static final Z1.e f6828l = new Z1.c();

    /* renamed from: a, reason: collision with root package name */
    public final Field f6829a;

    /* renamed from: b, reason: collision with root package name */
    public final int f6830b;

    /* renamed from: c, reason: collision with root package name */
    public final int f6831c;

    /* renamed from: d, reason: collision with root package name */
    public final int f6832d;

    /* renamed from: e, reason: collision with root package name */
    public final int f6833e;

    /* renamed from: f, reason: collision with root package name */
    public final int f6834f;

    /* renamed from: g, reason: collision with root package name */
    public final int f6835g;

    /* renamed from: h, reason: collision with root package name */
    public final int f6836h;

    /* renamed from: i, reason: collision with root package name */
    public final e f6837i;

    /* renamed from: j, reason: collision with root package name */
    public final int f6838j;

    /* renamed from: k, reason: collision with root package name */
    public final int f6839k;

    public a(Field field, int i10, int i11, int i12, int i13, int i14, int i15, int i16, e eVar, int i17, int i18) {
        this.f6829a = field;
        this.f6830b = i10;
        this.f6831c = i11;
        this.f6832d = i12;
        this.f6833e = i13;
        this.f6834f = i14;
        this.f6835g = i15;
        this.f6836h = i16;
        this.f6837i = eVar;
        this.f6838j = i17;
        l(i10, i11, i12, i13, i14, i15, i16, eVar);
        r();
        this.f6839k = i18;
    }

    public static void l(int i10, int i11, int i12, int i13, int i14, int i15, int i16, e eVar) {
        if (i15 == 60) {
            YearMonth yearMonthOf = YearMonth.of(i10, i11);
            Z1.e eVar2 = f6828l;
            boolean zB = eVar2.b(yearMonthOf);
            if (zB || yearMonthOf.isAfter(eVar2.a())) {
                e eVar3 = eVar == null ? e.f6846c : eVar;
                int iD = i13 - (eVar3.d() / 3600);
                int iD2 = i14 - ((eVar3.d() % 3600) / 60);
                if (((i11 == Month.DECEMBER.getValue() && i12 == 31) || (i11 == Month.JUNE.getValue() && i12 == 30)) && iD == 23 && iD2 == 59) {
                    throw new LeapSecondException(OffsetDateTime.of(i10, i11, i12, i13, i14, 59, i16, eVar3.f()).plusSeconds(1L), i15, zB);
                }
            }
        }
    }

    public final void a(Field field) {
        if (k(field)) {
            return;
        }
        throw new DateTimeFormatException("No " + field.name() + " field found");
    }

    public int b() {
        return this.f6832d;
    }

    public int c() {
        return this.f6833e;
    }

    public int d() {
        return this.f6834f;
    }

    public int e() {
        return this.f6831c;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && getClass() == obj.getClass()) {
            a aVar = (a) obj;
            if (this.f6830b == aVar.f6830b && this.f6831c == aVar.f6831c && this.f6832d == aVar.f6832d && this.f6833e == aVar.f6833e && this.f6834f == aVar.f6834f && this.f6835g == aVar.f6835g && this.f6836h == aVar.f6836h && this.f6838j == aVar.f6838j && this.f6829a == aVar.f6829a && Objects.equals(this.f6837i, aVar.f6837i)) {
                return true;
            }
        }
        return false;
    }

    public Field f() {
        return this.f6829a;
    }

    public int g() {
        return this.f6836h;
    }

    @Override // java.time.temporal.TemporalAccessor
    public long getLong(TemporalField temporalField) {
        int i10;
        if (temporalField.equals(ChronoField.YEAR)) {
            i10 = this.f6830b;
        } else if (temporalField.equals(ChronoField.MONTH_OF_YEAR)) {
            i10 = this.f6831c;
        } else if (temporalField.equals(ChronoField.DAY_OF_MONTH)) {
            i10 = this.f6832d;
        } else if (temporalField.equals(ChronoField.HOUR_OF_DAY)) {
            i10 = this.f6833e;
        } else if (temporalField.equals(ChronoField.MINUTE_OF_HOUR)) {
            i10 = this.f6834f;
        } else if (temporalField.equals(ChronoField.SECOND_OF_MINUTE)) {
            i10 = this.f6835g;
        } else {
            if (!temporalField.equals(ChronoField.NANO_OF_SECOND)) {
                if (temporalField.equals(ChronoField.NANO_OF_DAY)) {
                    return (((this.f6833e * 3600) + (this.f6834f * 60) + this.f6835g) * 1000000000) + this.f6836h;
                }
                if (temporalField.equals(ChronoField.INSTANT_SECONDS)) {
                    return m();
                }
                throw new UnsupportedTemporalTypeException("Unsupported field: " + temporalField);
            }
            i10 = this.f6836h;
        }
        return i10;
    }

    public Optional<e> h() {
        return Optional.ofNullable(this.f6837i);
    }

    public int hashCode() {
        return Objects.hash(Integer.valueOf(this.f6829a.ordinal()), Integer.valueOf(this.f6830b), Integer.valueOf(this.f6831c), Integer.valueOf(this.f6832d), Integer.valueOf(this.f6833e), Integer.valueOf(this.f6834f), Integer.valueOf(this.f6835g), Integer.valueOf(this.f6836h), this.f6837i, Integer.valueOf(this.f6838j));
    }

    public int i() {
        return this.f6835g;
    }

    @Override // java.time.temporal.TemporalAccessor
    public boolean isSupported(TemporalField temporalField) {
        return temporalField == ChronoField.NANO_OF_DAY || Field.of(temporalField).ordinal() <= this.f6829a.ordinal();
    }

    public int j() {
        return this.f6830b;
    }

    public boolean k(Field field) {
        return field.ordinal() <= this.f6829a.ordinal();
    }

    public final long m() {
        long j10 = (this.f6833e * 3600) + (this.f6834f * 60) + this.f6835g;
        int i10 = this.f6830b;
        int i11 = this.f6831c;
        if (i11 == 0) {
            i11 = 1;
        }
        int i12 = this.f6832d;
        return ((Z1.b.a(i10, i11, i12 != 0 ? i12 : 1) * 86400) + j10) - (this.f6837i != null ? r6.d() : 0L);
    }

    public OffsetDateTime n() {
        a(Field.MINUTE);
        e eVar = this.f6837i;
        if (eVar != null) {
            return OffsetDateTime.of(this.f6830b, this.f6831c, this.f6832d, this.f6833e, this.f6834f, this.f6835g, this.f6836h, eVar.f());
        }
        String string = toString();
        throw new DateTimeParseException("No timezone information: " + string, string, string.length());
    }

    public String o(int i10) {
        return p(this, Field.NANO, i10);
    }

    public final String p(a aVar, Field field, int i10) {
        if (field.ordinal() > aVar.f().ordinal()) {
            throw new DateTimeFormatException(String.format("Requested granularity was %s, but contains only granularity %s", field.name(), aVar.f().name()));
        }
        e eVarOrElse = aVar.h().orElse(null);
        char[] cArr = new char[35];
        f.e(aVar.j(), cArr, 0, 4);
        Field field2 = Field.YEAR;
        if (field == field2) {
            return Y1.a.a(cArr, field2.getRequiredLength(), null);
        }
        int iOrdinal = field.ordinal();
        Field field3 = Field.MONTH;
        if (iOrdinal >= field3.ordinal()) {
            cArr[4] = '-';
            f.e(aVar.e(), cArr, 5, 2);
        }
        if (field == field3) {
            return Y1.a.a(cArr, field3.getRequiredLength(), null);
        }
        int iOrdinal2 = field.ordinal();
        Field field4 = Field.DAY;
        if (iOrdinal2 >= field4.ordinal()) {
            cArr[7] = '-';
            f.e(aVar.b(), cArr, 8, 2);
        }
        if (field == field4) {
            return Y1.a.a(cArr, field4.getRequiredLength(), null);
        }
        int iOrdinal3 = field.ordinal();
        Field field5 = Field.HOUR;
        if (iOrdinal3 >= field5.ordinal()) {
            cArr[10] = 'T';
            f.e(aVar.c(), cArr, 11, 2);
        }
        if (field == field5) {
            return Y1.a.a(cArr, field5.getRequiredLength(), eVarOrElse);
        }
        int iOrdinal4 = field.ordinal();
        Field field6 = Field.MINUTE;
        if (iOrdinal4 >= field6.ordinal()) {
            cArr[13] = ':';
            f.e(aVar.d(), cArr, 14, 2);
        }
        if (field == field6) {
            return Y1.a.a(cArr, field6.getRequiredLength(), eVarOrElse);
        }
        int iOrdinal5 = field.ordinal();
        Field field7 = Field.SECOND;
        if (iOrdinal5 >= field7.ordinal()) {
            cArr[16] = ':';
            f.e(aVar.i(), cArr, 17, 2);
        }
        if (field == field7) {
            return Y1.a.a(cArr, field7.getRequiredLength(), eVarOrElse);
        }
        if (i10 > 0 && field.ordinal() >= Field.NANO.ordinal()) {
            cArr[19] = '.';
            f.e(aVar.g(), cArr, 20, i10);
        }
        return Y1.a.a(cArr, (i10 > 0 ? 1 : 0) + 19 + i10, eVarOrElse);
    }

    public String q(Field field) {
        return p(this, field, 0);
    }

    public final void r() {
        if (this.f6829a.ordinal() >= Field.DAY.ordinal()) {
            LocalDate.of(this.f6830b, this.f6831c, this.f6832d);
        }
        if (this.f6835g > 59) {
            throw new DateTimeException(String.format("Invalid value for SecondOfMinute (valid values 0 - 59): %d", Integer.valueOf(this.f6835g)));
        }
    }

    public String toString() {
        int i10 = this.f6838j;
        return i10 > 0 ? o(i10) : q(this.f6829a);
    }
}
