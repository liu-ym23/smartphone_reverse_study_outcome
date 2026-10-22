package org.threeten.bp.temporal;

import com.android.common.speech.LoggingEvents;
import java.util.Locale;
import java.util.Map;
import org.threeten.bp.DayOfWeek;
import org.threeten.bp.Duration;
import org.threeten.bp.LocalDate;
import org.threeten.bp.chrono.Chronology;
import org.threeten.bp.chrono.IsoChronology;
import org.threeten.bp.format.ResolverStyle;
import org.threeten.bp.jdk8.Jdk8Methods;

/* JADX INFO: loaded from: classes5.dex */
public final class IsoFields {
    public static final TemporalField DAY_OF_QUARTER = null;
    public static final TemporalField QUARTER_OF_YEAR = null;
    public static final TemporalUnit QUARTER_YEARS = null;
    public static final TemporalField WEEK_BASED_YEAR = null;
    public static final TemporalUnit WEEK_BASED_YEARS = null;
    public static final TemporalField WEEK_OF_WEEK_BASED_YEAR = null;

    /* JADX INFO: renamed from: org.threeten.bp.temporal.IsoFields$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$org$threeten$bp$temporal$IsoFields$Unit = null;

        static {
            int[] r0 = new int[Unit.values().length];
            $SwitchMap$org$threeten$bp$temporal$IsoFields$Unit = r0;
            r0[Unit.WEEK_BASED_YEARS.ordinal()] = 1;     // Catch: NoSuchFieldError -> L6
        L8:
            $SwitchMap$org$threeten$bp$temporal$IsoFields$Unit[Unit.QUARTER_YEARS.ordinal()] = 2;     // Catch: NoSuchFieldError -> L7
            return;
        }
    }

    private static abstract enum Field extends Enum<Field> implements TemporalField {
        private static final /* synthetic */ Field[] $VALUES = null;
        public static final Field DAY_OF_QUARTER = null;
        private static final int[] QUARTER_DAYS = null;
        public static final Field QUARTER_OF_YEAR = null;
        public static final Field WEEK_BASED_YEAR = null;
        public static final Field WEEK_OF_WEEK_BASED_YEAR = null;

        @Override // org.threeten.bp.temporal.TemporalField
        public boolean isDateBased() {
            return true;
        }

        @Override // org.threeten.bp.temporal.TemporalField
        public boolean isTimeBased() {
            return false;
        }

        @Override // org.threeten.bp.temporal.TemporalField
        public TemporalAccessor resolve(Map<TemporalField, Long> r1, TemporalAccessor r2, ResolverStyle r3) {
            return null;
        }

        private Field(String r1, int r2) {
            super(r1, r2);
        }

        /* synthetic */ Field(String r1, int r2, AnonymousClass1 r3) {
            this(r1, r2);
        }

        static /* synthetic */ boolean access$100(TemporalAccessor r0) {
            return isIso(r0);
        }

        static /* synthetic */ int[] access$200() {
            return QUARTER_DAYS;
        }

        static /* synthetic */ ValueRange access$300(LocalDate r0) {
            return getWeekRange(r0);
        }

        static /* synthetic */ int access$400(LocalDate r0) {
            return getWeek(r0);
        }

        static /* synthetic */ int access$500(LocalDate r0) {
            return getWeekBasedYear(r0);
        }

        static /* synthetic */ int access$600(int r0) {
            return getWeekRange(r0);
        }

        public static Field valueOf(String r1) {
            return (Field) Enum.valueOf(Field.class, r1);
        }

        public static Field[] values() {
            return (Field[]) $VALUES.clone();
        }

        static {
            final String r1 = "DAY_OF_QUARTER";
            final int r2 = 0;
            Field r0 = new AnonymousClass1(r1, r2);
            DAY_OF_QUARTER = r0;
            final String r3 = "QUARTER_OF_YEAR";
            final int r4 = 1;
            Field r5 = new AnonymousClass2(r3, r4);
            QUARTER_OF_YEAR = r5;
            final String r6 = "WEEK_OF_WEEK_BASED_YEAR";
            final int r7 = 2;
            Field r8 = new AnonymousClass3(r6, r7);
            WEEK_OF_WEEK_BASED_YEAR = r8;
            final String r9 = "WEEK_BASED_YEAR";
            final int r10 = 3;
            Field r11 = new AnonymousClass4(r9, r10);
            WEEK_BASED_YEAR = r11;
            $VALUES = new Field[]{r0, r5, r8, r11};
            QUARTER_DAYS = new int[]{0, 90, 181, 273, 0, 91, 182, 274};
        }

        @Override // org.threeten.bp.temporal.TemporalField
        public String getDisplayName(Locale r2) {
            Jdk8Methods.requireNonNull(r2, LoggingEvents.VoiceIme.EXTRA_START_LOCALE);
            return toString();
        }

        private static boolean isIso(TemporalAccessor r1) {
            return Chronology.from(r1).equals(IsoChronology.INSTANCE);
        }

        private static ValueRange getWeekRange(LocalDate r4) {
            return ValueRange.of(1, getWeekRange(getWeekBasedYear(r4)));
        }

        private static int getWeekRange(int r2) {
            LocalDate r3 = LocalDate.of(r2, 1, 1);
            if (r3.getDayOfWeek() != DayOfWeek.THURSDAY) goto L5;
            return 53;
        L5:
            if (r3.getDayOfWeek() == DayOfWeek.WEDNESDAY) goto L7;
            return 52;
        L7:
            if (r3.isLeapYear() == true) goto L14;
            return 52;
        L14:
            return 53;
        }

        private static int getWeek(LocalDate r5) {
            int r0 = r5.getDayOfWeek().ordinal();
            int r1 = r5.getDayOfYear() - 1;
            int r2 = (3 - r0) + r1;
            int r3 = (r2 - ((r2 / 7) * 7)) - 3;
            if (r3 >= (-3)) goto L5;
            r3 = r3 + 7;
        L5:
            if (r1 < r3) goto L7;
            int r4 = ((r1 - r3) / 7) + 1;
            if (r4 != 53) goto L21;
            if (r3 != (-3)) goto L12;
        L17:
            boolean r6 = true;
        L18:
            if (r6 == true) goto L21;
            return 1;
        L12:
            if (r3 == (-2)) goto L14;
        L16:
            r6 = false;
            goto L18
        L14:
            if (r5.isLeapYear() == false) goto L16;
        L21:
            return r4;
        L7:
            return (int) getWeekRange(r5.withDayOfYear(180).minusYears(1)).getMaximum();
        }

        private static int getWeekBasedYear(LocalDate r4) {
            int r0 = r4.getYear();
            int r1 = r4.getDayOfYear();
            if (r1 > 3) goto L8;
            if ((r1 - r4.getDayOfWeek().ordinal()) < (-2)) goto L14;
            return r0;
        L14:
            return r0 - 1;
        L8:
            if (r1 >= 363) goto L10;
            return r0;
        L10:
            if ((((r1 - 363) - (r4.isLeapYear() ? 1 : 0)) - r4.getDayOfWeek().ordinal()) >= 0) goto L12;
            return r0;
        L12:
            return r0 + 1;
        }
    }

    private static final enum Unit extends Enum<Unit> implements TemporalUnit {
        private static final /* synthetic */ Unit[] $VALUES = null;
        public static final Unit QUARTER_YEARS = null;
        public static final Unit WEEK_BASED_YEARS = null;
        private final Duration duration;
        private final String name;

        @Override // org.threeten.bp.temporal.TemporalUnit
        public boolean isDateBased() {
            return true;
        }

        @Override // org.threeten.bp.temporal.TemporalUnit
        public boolean isDurationEstimated() {
            return true;
        }

        @Override // org.threeten.bp.temporal.TemporalUnit
        public boolean isTimeBased() {
            return false;
        }

        public static Unit valueOf(String r1) {
            return (Unit) Enum.valueOf(Unit.class, r1);
        }

        public static Unit[] values() {
            return (Unit[]) $VALUES.clone();
        }

        static {
            Unit r0 = new Unit("WEEK_BASED_YEARS", 0, "WeekBasedYears", Duration.ofSeconds(31556952));
            WEEK_BASED_YEARS = r0;
            Unit r1 = new Unit("QUARTER_YEARS", 1, "QuarterYears", Duration.ofSeconds(7889238));
            QUARTER_YEARS = r1;
            $VALUES = new Unit[]{r0, r1};
        }

        private Unit(String r1, int r2, String r3, Duration r4) {
            super(r1, r2);
            this.name = r3;
            this.duration = r4;
        }

        @Override // org.threeten.bp.temporal.TemporalUnit
        public Duration getDuration() {
            return this.duration;
        }

        @Override // org.threeten.bp.temporal.TemporalUnit
        public boolean isSupportedBy(Temporal r1) {
            return r1.isSupported(ChronoField.EPOCH_DAY);
        }

        @Override // org.threeten.bp.temporal.TemporalUnit
        public <R extends Temporal> R addTo(R r5, long r6) {
            int r4 = AnonymousClass1.$SwitchMap$org$threeten$bp$temporal$IsoFields$Unit[ordinal()];
            if (r4 == 1) goto L11;
            if (r4 != 2) goto L9;
            return (R) r5.plus(r6 / 256, ChronoUnit.YEARS).plus((r6 % 256) * 3, ChronoUnit.MONTHS);
        L9:
            throw new IllegalStateException("Unreachable");
        L11:
            return (R) r5.with(IsoFields.WEEK_BASED_YEAR, Jdk8Methods.safeAdd(r5.get(IsoFields.WEEK_BASED_YEAR), r6));
        }

        @Override // org.threeten.bp.temporal.TemporalUnit
        public long between(Temporal r3, Temporal r4) {
            int r2 = AnonymousClass1.$SwitchMap$org$threeten$bp$temporal$IsoFields$Unit[ordinal()];
            if (r2 == 1) goto L11;
            if (r2 != 2) goto L9;
            return r3.until(r4, ChronoUnit.MONTHS) / 3;
        L9:
            throw new IllegalStateException("Unreachable");
        L11:
            return Jdk8Methods.safeSubtract(r4.getLong(IsoFields.WEEK_BASED_YEAR), r3.getLong(IsoFields.WEEK_BASED_YEAR));
        }

        @Override // java.lang.Enum, org.threeten.bp.temporal.TemporalUnit
        public String toString() {
            return this.name;
        }
    }

    static {
        DAY_OF_QUARTER = Field.DAY_OF_QUARTER;
        QUARTER_OF_YEAR = Field.QUARTER_OF_YEAR;
        WEEK_OF_WEEK_BASED_YEAR = Field.WEEK_OF_WEEK_BASED_YEAR;
        WEEK_BASED_YEAR = Field.WEEK_BASED_YEAR;
        WEEK_BASED_YEARS = Unit.WEEK_BASED_YEARS;
        QUARTER_YEARS = Unit.QUARTER_YEARS;
    }

    private IsoFields() {
        throw new AssertionError("Not instantiable");
    }
}
