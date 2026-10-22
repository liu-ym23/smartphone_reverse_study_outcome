package k6;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UncheckedIOException;
import java.lang.invoke.VarHandle;
import java.nio.charset.StandardCharsets;
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
import s.f;
import td.h;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class a implements TemporalAccessor {

    /* renamed from: o, reason: collision with root package name */
    public static final n6.a f7253o;

    /* renamed from: c, reason: collision with root package name */
    public final int f7254c;

    /* renamed from: f, reason: collision with root package name */
    public final int f7255f;

    /* renamed from: g, reason: collision with root package name */
    public final int f7256g;

    /* renamed from: h, reason: collision with root package name */
    public final int f7257h;
    public final int i;

    /* renamed from: j, reason: collision with root package name */
    public final int f7258j;

    /* renamed from: k, reason: collision with root package name */
    public final int f7259k;

    /* renamed from: l, reason: collision with root package name */
    public final int f7260l;

    /* renamed from: m, reason: collision with root package name */
    public final e f7261m;

    /* renamed from: n, reason: collision with root package name */
    public final int f7262n;

    static {
        n6.a aVar = new n6.a();
        TreeSet treeSet = new TreeSet();
        aVar.f8776c = treeSet;
        try {
            InputStream resourceAsStream = n6.a.class.getClassLoader().getResourceAsStream("leap_second_dates.csv");
            try {
                Objects.requireNonNull(resourceAsStream, "leap_second_dates.csv was not found on the classpath");
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(resourceAsStream, StandardCharsets.UTF_8));
                while (true) {
                    try {
                        String line = bufferedReader.readLine();
                        if (line == null) {
                            bufferedReader.close();
                            resourceAsStream.close();
                            aVar.f8777f = (YearMonth) treeSet.last();
                            VarHandle.storeStoreFence();
                            f7253o = aVar;
                            return;
                        }
                        if (!line.isEmpty()) {
                            treeSet.add(YearMonth.parse(line));
                        }
                    } finally {
                    }
                }
            } finally {
            }
        } catch (IOException e10) {
            throw new UncheckedIOException(e10);
        }
    }

    public a(int i, int i3, int i10, int i11, int i12, int i13, int i14, int i15, e eVar, int i16) {
        this.f7254c = i;
        this.f7255f = i3;
        this.f7256g = i10;
        this.f7257h = i11;
        this.i = i12;
        this.f7258j = i13;
        this.f7259k = i14;
        this.f7260l = i15;
        this.f7261m = eVar;
        this.f7262n = i16;
        if (i14 == 60) {
            YearMonth yearMonthOf = YearMonth.of(i3, i10);
            n6.a aVar = f7253o;
            boolean zContains = ((TreeSet) aVar.f8776c).contains(yearMonthOf);
            if (zContains || yearMonthOf.isAfter((YearMonth) aVar.f8777f)) {
                e eVar2 = e.f7269c;
                eVar = eVar == null ? eVar2 : eVar;
                int iA = i12 - (eVar.a() / 3600);
                int iA2 = i13 - ((eVar.a() % 3600) / 60);
                if (((i10 == Month.DECEMBER.getValue() && i11 == 31) || (i10 == Month.JUNE.getValue() && i11 == 30)) && iA == 23 && iA2 == 59) {
                    OffsetDateTime.of(i3, i10, i11, i12, i13, 59, i15, eVar.equals(eVar2) ? ZoneOffset.UTC : ZoneOffset.ofHoursMinutes(eVar.f7270a, eVar.f7271b)).plusSeconds(1L);
                    c cVar = new c("Leap second detected in input");
                    cVar.f7263c = zContains;
                    VarHandle.storeStoreFence();
                    throw cVar;
                }
            }
        }
        if (f.c(i) >= 2) {
            LocalDate.of(i3, i10, i11);
        }
        if (i14 > 59) {
            throw new DateTimeException(String.format("Invalid value for SecondOfMinute (valid values 0 - 59): %d", Integer.valueOf(i14)));
        }
    }

    public static String a(a aVar, int i, int i3) {
        int iC = f.c(i);
        int i10 = aVar.f7254c;
        if (iC > f.c(i10)) {
            throw new l6.a(androidx.activity.b.j("Requested granularity was ", k0.a.D(i), ", but contains only granularity ", k0.a.D(i10)));
        }
        e eVar = (e) Optional.ofNullable(aVar.f7261m).orElse(null);
        char[] cArr = new char[35];
        n6.b.c(aVar.f7255f, 0, cArr, 4);
        if (i == 1) {
            return h.q(cArr, 4, null);
        }
        if (f.c(i) >= 1) {
            cArr[4] = '-';
            n6.b.c(aVar.f7256g, 5, cArr, 2);
        }
        if (i == 2) {
            return h.q(cArr, 7, null);
        }
        if (f.c(i) >= 2) {
            cArr[7] = '-';
            n6.b.c(aVar.f7257h, 8, cArr, 2);
        }
        if (i == 3) {
            return h.q(cArr, 10, null);
        }
        if (f.c(i) >= 3) {
            cArr[10] = 'T';
            n6.b.c(aVar.i, 11, cArr, 2);
        }
        if (i == 4) {
            return h.q(cArr, 13, eVar);
        }
        if (f.c(i) >= 4) {
            cArr[13] = ':';
            n6.b.c(aVar.f7258j, 14, cArr, 2);
        }
        if (i == 5) {
            return h.q(cArr, 16, eVar);
        }
        if (f.c(i) >= 5) {
            cArr[16] = ':';
            n6.b.c(aVar.f7259k, 17, cArr, 2);
        }
        if (i == 6) {
            return h.q(cArr, 19, eVar);
        }
        if (i3 > 0 && f.c(i) >= 6) {
            cArr[19] = '.';
            n6.b.c(aVar.f7260l, 20, cArr, i3);
        }
        return h.q(cArr, (i3 > 0 ? 1 : 0) + 19 + i3, eVar);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || a.class != obj.getClass()) {
            return false;
        }
        a aVar = (a) obj;
        return this.f7255f == aVar.f7255f && this.f7256g == aVar.f7256g && this.f7257h == aVar.f7257h && this.i == aVar.i && this.f7258j == aVar.f7258j && this.f7259k == aVar.f7259k && this.f7260l == aVar.f7260l && this.f7262n == aVar.f7262n && this.f7254c == aVar.f7254c && Objects.equals(this.f7261m, aVar.f7261m);
    }

    @Override // java.time.temporal.TemporalAccessor
    public final long getLong(TemporalField temporalField) {
        boolean zEquals = temporalField.equals(ChronoField.YEAR);
        int i = this.f7255f;
        if (zEquals) {
            return i;
        }
        boolean zEquals2 = temporalField.equals(ChronoField.MONTH_OF_YEAR);
        int i3 = this.f7256g;
        if (zEquals2) {
            return i3;
        }
        boolean zEquals3 = temporalField.equals(ChronoField.DAY_OF_MONTH);
        int i10 = this.f7257h;
        if (zEquals3) {
            return i10;
        }
        boolean zEquals4 = temporalField.equals(ChronoField.HOUR_OF_DAY);
        int i11 = this.i;
        if (zEquals4) {
            return i11;
        }
        boolean zEquals5 = temporalField.equals(ChronoField.MINUTE_OF_HOUR);
        int i12 = this.f7258j;
        if (zEquals5) {
            return i12;
        }
        boolean zEquals6 = temporalField.equals(ChronoField.SECOND_OF_MINUTE);
        int i13 = this.f7259k;
        if (zEquals6) {
            return i13;
        }
        boolean zEquals7 = temporalField.equals(ChronoField.NANO_OF_SECOND);
        int i14 = this.f7260l;
        if (zEquals7) {
            return i14;
        }
        if (temporalField.equals(ChronoField.NANO_OF_DAY)) {
            return (((i12 * 60) + (i11 * 3600) + i13) * 1000000000) + i14;
        }
        if (!temporalField.equals(ChronoField.INSTANT_SECONDS)) {
            throw new UnsupportedTemporalTypeException("Unsupported field: " + temporalField);
        }
        long j10 = (i12 * 60) + (i11 * 3600) + i13;
        if (i3 == 0) {
            i3 = 1;
        }
        if (i10 == 0) {
            i10 = 1;
        }
        int i15 = i - (i3 > 2 ? 0 : 1);
        long j11 = (i15 >= 0 ? i15 : i15 - 399) / 400;
        long j12 = i15 - (400 * j11);
        return (((((j11 * 146097) + ((((j12 / 4) + (365 * j12)) - (j12 / 100)) + ((((((i3 > 2 ? i3 - 3 : i3 + 9) * 153) + 2) / 5) + i10) - 1))) - 719468) * 86400) + j10) - (this.f7261m != null ? r14.a() : 0L);
    }

    public final int hashCode() {
        return Objects.hash(Integer.valueOf(f.c(this.f7254c)), Integer.valueOf(this.f7255f), Integer.valueOf(this.f7256g), Integer.valueOf(this.f7257h), Integer.valueOf(this.i), Integer.valueOf(this.f7258j), Integer.valueOf(this.f7259k), Integer.valueOf(this.f7260l), this.f7261m, Integer.valueOf(this.f7262n));
    }

    @Override // java.time.temporal.TemporalAccessor
    public final boolean isSupported(TemporalField temporalField) {
        int i;
        if (temporalField != ChronoField.NANO_OF_DAY) {
            if (temporalField.equals(ChronoField.YEAR)) {
                i = 1;
            } else if (temporalField.equals(ChronoField.MONTH_OF_YEAR)) {
                i = 2;
            } else if (temporalField.equals(ChronoField.DAY_OF_MONTH)) {
                i = 3;
            } else if (temporalField.equals(ChronoField.HOUR_OF_DAY)) {
                i = 4;
            } else if (temporalField.equals(ChronoField.MINUTE_OF_HOUR)) {
                i = 5;
            } else if (temporalField.equals(ChronoField.SECOND_OF_MINUTE)) {
                i = 6;
            } else {
                if (!temporalField.equals(ChronoField.NANO_OF_SECOND)) {
                    throw new UnsupportedTemporalTypeException("Unsupported field: " + temporalField);
                }
                i = 7;
            }
            if (f.c(i) > f.c(this.f7254c)) {
                return false;
            }
        }
        return true;
    }

    public final String toString() {
        int i = this.f7262n;
        return i > 0 ? a(this, 7, i) : a(this, this.f7254c, 0);
    }
}
