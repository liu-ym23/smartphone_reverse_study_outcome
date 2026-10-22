package bytedance.jvm.time.chrono;

import bytedance.jvm.time.ZoneOffset;
import bytedance.jvm.time.format.DateTimeFormatterBuilder;
import bytedance.jvm.time.format.TextStyle;
import bytedance.jvm.time.temporal.ChronoField;
import bytedance.jvm.time.temporal.UnsupportedTemporalTypeException;
import bytedance.jvm.time.temporal.ValueRange;
import java.util.Locale;
import java.util.Objects;
import java.util.Set;

/* JADX INFO: loaded from: classes28.dex */
public final /* synthetic */ class i {

    public class a implements bytedance.jvm.time.temporal.d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ j f21574a;

        @Override // bytedance.jvm.time.temporal.d
        public final /* synthetic */ int get(bytedance.jvm.time.temporal.j r100) {
            return bytedance.jvm.time.temporal.c.a(this, r100);
        }

        @Override // bytedance.jvm.time.temporal.d
        public final boolean isSupported(bytedance.jvm.time.temporal.j r100) {
            return false;
        }

        @Override // bytedance.jvm.time.temporal.d
        public final /* synthetic */ ValueRange range(bytedance.jvm.time.temporal.j r100) {
            return bytedance.jvm.time.temporal.c.c(this, r100);
        }

        public a(j r100) {
            this.f21574a = r100;
        }

        @Override // bytedance.jvm.time.temporal.d
        public final long getLong(bytedance.jvm.time.temporal.j r100) {
            throw new UnsupportedTemporalTypeException("Unsupported field: " + r100);
        }

        @Override // bytedance.jvm.time.temporal.d
        public <R> R query(bytedance.jvm.time.temporal.l<R> r100) {
            if (r100 != bytedance.jvm.time.temporal.k.f21715b) goto L7;
            return (R) this.f21574a;
        L7:
            return (R) bytedance.jvm.time.temporal.c.b(this, r100);
        }
    }

    public static Set<j> e() {
        return bytedance.jvm.time.chrono.a.getAvailableChronologies();
    }

    public static j d(bytedance.jvm.time.temporal.d r100) {
        Objects.requireNonNull(r100, "temporal");
        j r101 = (j) r100.query(bytedance.jvm.time.temporal.k.f21715b);
        IsoChronology r102 = IsoChronology.INSTANCE;
        if (r101 != null) goto L7;
        Objects.requireNonNull(r102, "defaultObj");
        return r102;
    L7:
        return r101;
    }

    public static String c(j r100, TextStyle r101, Locale r102) {
        a r103 = new a(r100);
        DateTimeFormatterBuilder r104 = new DateTimeFormatterBuilder();
        Objects.requireNonNull(r101, "textStyle");
        r104.b(new DateTimeFormatterBuilder.c(r101));
        return r104.o(r102).a(r103);
    }

    public static long a(j r110, int r111, int r112, int r210, int r211, int r212, int r213, ZoneOffset r214) {
        Objects.requireNonNull(r214, "zoneOffset");
        ChronoField.HOUR_OF_DAY.checkValidValue(r211);
        ChronoField.MINUTE_OF_HOUR.checkValidValue(r212);
        ChronoField.SECOND_OF_MINUTE.checkValidValue(r213);
        long r100 = r110.date(r111, r112, r210).toEpochDay();
        long r101 = 86400;
        int r102 = ((Long.numberOfLeadingZeros(r100) + Long.numberOfLeadingZeros(~r100)) + Long.numberOfLeadingZeros(r101)) + Long.numberOfLeadingZeros(~r101);
        boolean r113 = true;
        if (r102 <= 65) goto L6;
        long r103 = r100 * r101;
    L22:
        long r104 = ((long) ((((r211 * 60) + r212) * 60) + r213)) - ((long) r214.getTotalSeconds());
        long r105 = r103 + r104;
        if ((r104 ^ r103) >= 0) goto L25;
        boolean r106 = true;
    L27:
        if ((r103 ^ r105) >= 0) goto L31;
        r113 = false;
    L31:
        if ((r106 | r113) == false) goto L34;
        return r105;
    L34:
        throw new ArithmeticException();
    L25:
        r106 = false;
        goto L27
    L6:
        if (r102 < 64) goto L36;
        if (r100 < 0) goto L10;
        boolean r107 = true;
    L12:
        if (r101 == Long.MIN_VALUE) goto L14;
        boolean r114 = true;
    L16:
        if ((r107 | r114) == false) goto L36;
        long r115 = r100 * r101;
        if (r100 != 0) goto L20;
    L21:
        r103 = r115;
        goto L22
    L20:
        if ((r115 / r100) != r101) goto L36;
    L14:
        r114 = false;
        goto L16
    L10:
        r107 = false;
    L36:
        throw new ArithmeticException();
    }

    public static long b(j r100, l r110, int r111, int r112, int r113, int r114, int r115, int r116, ZoneOffset r117) {
        Objects.requireNonNull(r110, "era");
        return r100.epochSecond(r100.prolepticYear(r110, r111), r112, r113, r114, r115, r116, r117);
    }
}
