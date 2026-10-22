package bytedance.jvm.time.temporal;

import bytedance.jvm.time.DateTimeException;
import bytedance.jvm.time.format.ResolverStyle;
import java.util.Locale;
import java.util.Map;
import java.util.Objects;

/* JADX INFO: loaded from: classes28.dex */
public final class JulianFields {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final j f21690a = null;

    public static final enum Field extends Enum<Field> implements j {
        public static final Field JULIAN_DAY = null;
        public static final Field MODIFIED_JULIAN_DAY = null;
        public static final Field RATA_DIE = null;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public static final /* synthetic */ Field[] f21691f = null;
        private static final long serialVersionUID = -7501623920830201812L;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final transient String f21692a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final transient m f21693b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final transient m f21694c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final transient ValueRange f21695d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final transient long f21696e;

        @Override // bytedance.jvm.time.temporal.j
        public boolean isDateBased() {
            return true;
        }

        @Override // bytedance.jvm.time.temporal.j
        public boolean isTimeBased() {
            return false;
        }

        static {
            ChronoUnit r110 = ChronoUnit.DAYS;
            ChronoUnit r111 = ChronoUnit.FOREVER;
            Field r100 = new Field("JULIAN_DAY", 0, "JulianDay", r110, r111, 2440588);
            JULIAN_DAY = r100;
            Field r101 = new Field("MODIFIED_JULIAN_DAY", 1, "ModifiedJulianDay", r110, r111, 40587);
            MODIFIED_JULIAN_DAY = r101;
            Field r102 = new Field("RATA_DIE", 2, "RataDie", r110, r111, 719163);
            RATA_DIE = r102;
            f21691f = new Field[]{r100, r101, r102};
        }

        public static Field[] values() {
            return (Field[]) f21691f.clone();
        }

        public m getBaseUnit() {
            return this.f21693b;
        }

        public m getRangeUnit() {
            return this.f21694c;
        }

        @Override // bytedance.jvm.time.temporal.j
        public ValueRange range() {
            return this.f21695d;
        }

        @Override // java.lang.Enum, bytedance.jvm.time.temporal.j
        public String toString() {
            return this.f21692a;
        }

        public static Field valueOf(String r100) {
            return (Field) r27.a.a(Field.class, r100);
        }

        public String getDisplayName(Locale r100) {
            Objects.requireNonNull(r100, "locale");
            return toString();
        }

        @Override // bytedance.jvm.time.temporal.j
        public long getFrom(d r100) {
            return r100.getLong(ChronoField.EPOCH_DAY) + this.f21696e;
        }

        @Override // bytedance.jvm.time.temporal.j
        public boolean isSupportedBy(d r100) {
            return r100.isSupported(ChronoField.EPOCH_DAY);
        }

        @Override // bytedance.jvm.time.temporal.j
        public ValueRange rangeRefinedBy(d r100) {
            if (isSupportedBy(r100) == false) goto L7;
            return range();
        L7:
            throw new DateTimeException("Unsupported field: " + this);
        }

        @Override // bytedance.jvm.time.temporal.j
        public <R extends b> R adjustInto(R r110, long r111) {
            if (range().isValidValue(r111) == false) goto L18;
            ChronoField r100 = ChronoField.EPOCH_DAY;
            long r101 = this.f21696e;
            long r102 = r111 - r101;
            boolean r103 = false;
            if ((r101 ^ r111) < 0) goto L7;
            boolean r104 = true;
        L9:
            if ((r111 ^ r102) < 0) goto L12;
            r103 = true;
        L12:
            if ((r104 | r103) == false) goto L16;
            return (R) r110.with(r100, r102);
        L16:
            throw new ArithmeticException();
        L7:
            r104 = false;
            goto L9
        L18:
            throw new DateTimeException("Invalid value: " + this.f21692a + " " + r111);
        }

        @Override // bytedance.jvm.time.temporal.j
        public bytedance.jvm.time.chrono.c resolve(Map<j, Long> r110, d r111, ResolverStyle r112) {
            long r100 = r110.remove(this).longValue();
            bytedance.jvm.time.chrono.j r113 = bytedance.jvm.time.chrono.i.d(r111);
            if (r112 != ResolverStyle.LENIENT) goto L17;
            long r114 = this.f21696e;
            long r101 = r100 - r114;
            boolean r102 = false;
            if ((r114 ^ r100) < 0) goto L7;
            boolean r115 = true;
        L9:
            if ((r100 ^ r101) < 0) goto L12;
            r102 = true;
        L12:
            if ((r115 | r102) == false) goto L16;
            return r113.dateEpochDay(r101);
        L16:
            throw new ArithmeticException();
        L7:
            r115 = false;
            goto L9
        L17:
            range().checkValidValue(r100, this);
            return r113.dateEpochDay(r100 - this.f21696e);
        }

        @Override // bytedance.jvm.time.temporal.j
        public /* bridge */ /* synthetic */ d resolve(Map r100, d r101, ResolverStyle r102) {
            return resolve(r100, r101, r102);
        }

        public Field(String r100, int r101, String r102, ChronoUnit r103, ChronoUnit r104, long r105) {
            super(r100, r101);
            this.f21692a = r102;
            this.f21693b = r103;
            this.f21694c = r104;
            this.f21695d = ValueRange.of((-365243219162L) + r105, 365241780471L + r105);
            this.f21696e = r105;
        }
    }

    static {
        Field r100 = Field.JULIAN_DAY;
        f21690a = Field.MODIFIED_JULIAN_DAY;
        Field r101 = Field.JULIAN_DAY;
    }
}
