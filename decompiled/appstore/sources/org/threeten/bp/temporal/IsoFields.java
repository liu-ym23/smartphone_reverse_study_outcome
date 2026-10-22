package org.threeten.bp.temporal;

import com.bytedanceos.common.ui.animation.AnimationConstants;
import ig.d;
import java.util.Locale;
import java.util.Map;
import org.threeten.bp.DayOfWeek;
import org.threeten.bp.Duration;
import org.threeten.bp.LocalDate;
import org.threeten.bp.chrono.IsoChronology;
import org.threeten.bp.chrono.e;
import org.threeten.bp.format.ResolverStyle;

/* JADX INFO: loaded from: classes4.dex */
public abstract class IsoFields {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final TemporalField f23217a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final TemporalField f23218b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final TemporalField f23219c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final TemporalField f23220d = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final TemporalUnit f23221e = null;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final TemporalUnit f23222f = null;

    public static abstract enum Field extends Enum<Field> implements TemporalField {
        private static final /* synthetic */ Field[] $VALUES = null;
        public static final Field DAY_OF_QUARTER = null;
        private static final int[] QUARTER_DAYS = null;
        public static final Field QUARTER_OF_YEAR = null;
        public static final Field WEEK_BASED_YEAR = null;
        public static final Field WEEK_OF_WEEK_BASED_YEAR = null;

        static {
            final String r10 = "DAY_OF_QUARTER";
            final int r11 = 0;
            Field r12 = new AnonymousClass1(r10, r11);
            DAY_OF_QUARTER = r12;
            final String r13 = "QUARTER_OF_YEAR";
            final int r14 = 1;
            Field r15 = new AnonymousClass2(r13, r14);
            QUARTER_OF_YEAR = r15;
            final String r16 = "WEEK_OF_WEEK_BASED_YEAR";
            final int r17 = 2;
            Field r18 = new AnonymousClass3(r16, r17);
            WEEK_OF_WEEK_BASED_YEAR = r18;
            final String r19 = "WEEK_BASED_YEAR";
            final int r20 = 3;
            Field r21 = new AnonymousClass4(r19, r20);
            WEEK_BASED_YEAR = r21;
            $VALUES = new Field[]{r12, r15, r18, r21};
            QUARTER_DAYS = new int[]{0, 90, 181, 273, 0, 91, 182, 274};
        }

        private Field(String r10, int r11) {
            super(r10, r11);
        }

        public static /* synthetic */ boolean access$100(TemporalAccessor r10) {
            return isIso(r10);
        }

        public static /* synthetic */ int[] access$200() {
            return QUARTER_DAYS;
        }

        public static /* synthetic */ ValueRange access$300(LocalDate r10) {
            return getWeekRange(r10);
        }

        public static /* synthetic */ int access$400(LocalDate r10) {
            return getWeek(r10);
        }

        public static /* synthetic */ int access$500(LocalDate r10) {
            return getWeekBasedYear(r10);
        }

        public static /* synthetic */ int access$600(int r10) {
            return getWeekRange(r10);
        }

        private static int getWeek(LocalDate r10) {
            int r11 = r10.getDayOfWeek().ordinal();
            int r12 = r10.getDayOfYear() - 1;
            int r13 = (3 - r11) + r12;
            int r14 = r13 - ((r13 / 7) * 7);
            int r15 = r14 - 3;
            if (r15 >= (-3)) goto L5;
            r15 = r14 + 4;
        L5:
            if (r12 < r15) goto L7;
            int r16 = ((r12 - r15) / 7) + 1;
            if (r16 != 53) goto L16;
            if (r15 == (-3)) goto L16;
            if (r15 == (-2)) goto L14;
            return 1;
        L14:
            if (r10.isLeapYear() == true) goto L16;
            return 1;
        L16:
            return r16;
        L7:
            return (int) getWeekRange(r10.withDayOfYear(AnimationConstants.DURATION_180).minusYears(1)).getMaximum();
        }

        private static int getWeekBasedYear(LocalDate r10) {
            int r11 = r10.getYear();
            int r12 = r10.getDayOfYear();
            if (r12 > 3) goto L8;
            if ((r12 - r10.getDayOfWeek().ordinal()) < (-2)) goto L14;
            return r11;
        L14:
            return r11 - 1;
        L8:
            if (r12 >= 363) goto L10;
            return r11;
        L10:
            if ((((r12 - 363) - (r10.isLeapYear() ? 1 : 0)) - r10.getDayOfWeek().ordinal()) >= 0) goto L12;
            return r11;
        L12:
            return r11 + 1;
        }

        private static ValueRange getWeekRange(LocalDate r10) {
            return ValueRange.of(1, getWeekRange(getWeekBasedYear(r10)));
        }

        private static boolean isIso(TemporalAccessor r10) {
            return e.from(r10).equals(IsoChronology.INSTANCE);
        }

        public static Field valueOf(String r10) {
            return (Field) Enum.valueOf(Field.class, r10);
        }

        public static Field[] values() {
            return (Field[]) $VALUES.clone();
        }

        @Override // org.threeten.bp.temporal.TemporalField
        public String getDisplayName(Locale r10) {
            d.h(r10, "locale");
            return toString();
        }

        @Override // org.threeten.bp.temporal.TemporalField
        public boolean isDateBased() {
            return true;
        }

        @Override // org.threeten.bp.temporal.TemporalField
        public boolean isTimeBased() {
            return false;
        }

        @Override // org.threeten.bp.temporal.TemporalField
        public TemporalAccessor resolve(Map<TemporalField, Long> r10, TemporalAccessor r11, ResolverStyle r12) {
            return null;
        }

        public /* synthetic */ Field(String r10, int r11, a r12) {
            this(r10, r11);
        }

        private static int getWeekRange(int r10) {
            LocalDate r11 = LocalDate.of(r10, 1, 1);
            if (r11.getDayOfWeek() != DayOfWeek.THURSDAY) goto L5;
            return 53;
        L5:
            if (r11.getDayOfWeek() == DayOfWeek.WEDNESDAY) goto L7;
            return 52;
        L7:
            if (r11.isLeapYear() == true) goto L14;
            return 52;
        L14:
            return 53;
        }
    }

    public static final enum Unit extends Enum<Unit> implements TemporalUnit {
        private static final /* synthetic */ Unit[] $VALUES = null;
        public static final Unit QUARTER_YEARS = null;
        public static final Unit WEEK_BASED_YEARS = null;
        private final Duration duration;
        private final String name;

        static {
            Unit r10 = new Unit("WEEK_BASED_YEARS", 0, "WeekBasedYears", Duration.ofSeconds(31556952));
            WEEK_BASED_YEARS = r10;
            Unit r11 = new Unit("QUARTER_YEARS", 1, "QuarterYears", Duration.ofSeconds(7889238));
            QUARTER_YEARS = r11;
            $VALUES = new Unit[]{r10, r11};
        }

        private Unit(String r10, int r11, String r12, Duration r13) {
            super(r10, r11);
            this.name = r12;
            this.duration = r13;
        }

        public static Unit valueOf(String r10) {
            return (Unit) Enum.valueOf(Unit.class, r10);
        }

        public static Unit[] values() {
            return (Unit[]) $VALUES.clone();
        }

        @Override // org.threeten.bp.temporal.TemporalUnit
        public <R extends Temporal> R addTo(R r10, long r11) {
            int r12 = a.f23223a[ordinal()];
            if (r12 != 1) goto L5;
            TemporalField r13 = IsoFields.f23220d;
            return (R) r10.with(r13, d.j(r10.get(r13), r11));
        L5:
            if (r12 != 2) goto L9;
            return (R) r10.plus(r11 / 256, ChronoUnit.YEARS).plus((r11 % 256) * 3, ChronoUnit.MONTHS);
        L9:
            throw new IllegalStateException("Unreachable");
        }

        @Override // org.threeten.bp.temporal.TemporalUnit
        public long between(Temporal r10, Temporal r11) {
            int r12 = a.f23223a[ordinal()];
            if (r12 != 1) goto L5;
            TemporalField r13 = IsoFields.f23220d;
            return d.o(r11.getLong(r13), r10.getLong(r13));
        L5:
            if (r12 != 2) goto L9;
            return r10.until(r11, ChronoUnit.MONTHS) / 3;
        L9:
            throw new IllegalStateException("Unreachable");
        }

        @Override // org.threeten.bp.temporal.TemporalUnit
        public Duration getDuration() {
            return this.duration;
        }

        @Override // org.threeten.bp.temporal.TemporalUnit
        public boolean isDateBased() {
            return true;
        }

        @Override // org.threeten.bp.temporal.TemporalUnit
        public boolean isDurationEstimated() {
            return true;
        }

        @Override // org.threeten.bp.temporal.TemporalUnit
        public boolean isSupportedBy(Temporal r10) {
            return r10.isSupported(ChronoField.EPOCH_DAY);
        }

        @Override // org.threeten.bp.temporal.TemporalUnit
        public boolean isTimeBased() {
            return false;
        }

        @Override // java.lang.Enum, org.threeten.bp.temporal.TemporalUnit
        public String toString() {
            return this.name;
        }
    }

    public static /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f23223a = null;

        static {
            int[] r10 = new int[Unit.values().length];
            f23223a = r10;
            r10[Unit.WEEK_BASED_YEARS.ordinal()] = 1;     // Catch: NoSuchFieldError -> L6
        L8:
            f23223a[Unit.QUARTER_YEARS.ordinal()] = 2;     // Catch: NoSuchFieldError -> L7
            return;
        }
    }

    static {
        f23217a = Field.DAY_OF_QUARTER;
        f23218b = Field.QUARTER_OF_YEAR;
        f23219c = Field.WEEK_OF_WEEK_BASED_YEAR;
        f23220d = Field.WEEK_BASED_YEAR;
        f23221e = Unit.WEEK_BASED_YEARS;
        f23222f = Unit.QUARTER_YEARS;
    }
}
