package bytedance.jvm.time;

import bytedance.jvm.time.format.DateTimeFormatterBuilder;
import bytedance.jvm.time.format.TextStyle;
import bytedance.jvm.time.temporal.ChronoField;
import bytedance.jvm.time.temporal.ChronoUnit;
import bytedance.jvm.time.temporal.UnsupportedTemporalTypeException;
import bytedance.jvm.time.temporal.ValueRange;
import java.util.Locale;

/* JADX INFO: loaded from: classes28.dex */
public final enum DayOfWeek extends Enum<DayOfWeek> implements bytedance.jvm.time.temporal.d, bytedance.jvm.time.temporal.e {
    public static final DayOfWeek FRIDAY = null;
    public static final DayOfWeek MONDAY = null;
    public static final DayOfWeek SATURDAY = null;
    public static final DayOfWeek SUNDAY = null;
    public static final DayOfWeek THURSDAY = null;
    public static final DayOfWeek TUESDAY = null;
    public static final DayOfWeek WEDNESDAY = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final DayOfWeek[] f21486a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ DayOfWeek[] f21487b = null;

    static {
        DayOfWeek r100 = new DayOfWeek("MONDAY", 0);
        MONDAY = r100;
        DayOfWeek r101 = new DayOfWeek("TUESDAY", 1);
        TUESDAY = r101;
        DayOfWeek r102 = new DayOfWeek("WEDNESDAY", 2);
        WEDNESDAY = r102;
        DayOfWeek r103 = new DayOfWeek("THURSDAY", 3);
        THURSDAY = r103;
        DayOfWeek r104 = new DayOfWeek("FRIDAY", 4);
        FRIDAY = r104;
        DayOfWeek r105 = new DayOfWeek("SATURDAY", 5);
        SATURDAY = r105;
        DayOfWeek r110 = new DayOfWeek("SUNDAY", 6);
        SUNDAY = r110;
        f21487b = new DayOfWeek[]{r100, r101, r102, r103, r104, r105, r110};
        f21486a = values();
    }

    public static DayOfWeek[] values() {
        return (DayOfWeek[]) f21487b.clone();
    }

    public int getValue() {
        return ordinal() + 1;
    }

    public static DayOfWeek from(bytedance.jvm.time.temporal.d r100) {
        if ((r100 instanceof DayOfWeek) == true) goto L5;
        return of(r100.get(ChronoField.DAY_OF_WEEK));
    L8:
        e = move-exception;
        throw new DateTimeException("Unable to obtain DayOfWeek from TemporalAccessor: " + r100 + " of type " + r100.getClass().getName(), e);
    L5:
        return (DayOfWeek) r100;
    }

    public static DayOfWeek of(int r100) {
        if (r100 < 1) goto L9;
        if (r100 > 7) goto L9;
        return f21486a[r100 - 1];
    L9:
        throw new DateTimeException("Invalid value for DayOfWeek: " + r100);
    }

    public static DayOfWeek valueOf(String r100) {
        return (DayOfWeek) r27.a.a(DayOfWeek.class, r100);
    }

    @Override // bytedance.jvm.time.temporal.e
    public bytedance.jvm.time.temporal.b adjustInto(bytedance.jvm.time.temporal.b r100) {
        return r100.with(ChronoField.DAY_OF_WEEK, getValue());
    }

    @Override // bytedance.jvm.time.temporal.d
    public int get(bytedance.jvm.time.temporal.j r100) {
        if (r100 != ChronoField.DAY_OF_WEEK) goto L7;
        return getValue();
    L7:
        return bytedance.jvm.time.temporal.c.a(this, r100);
    }

    @Override // bytedance.jvm.time.temporal.d
    public long getLong(bytedance.jvm.time.temporal.j r100) {
        if (r100 != ChronoField.DAY_OF_WEEK) goto L7;
        return getValue();
    L7:
        if ((r100 instanceof ChronoField) == true) goto L11;
        return r100.getFrom(this);
    L11:
        throw new UnsupportedTemporalTypeException("Unsupported field: " + r100);
    }

    @Override // bytedance.jvm.time.temporal.d
    public boolean isSupported(bytedance.jvm.time.temporal.j r100) {
        if ((r100 instanceof ChronoField) == true) goto L5;
        if (r100 != null) goto L11;
    L13:
        return false;
    L11:
        if (r100.isSupportedBy(this) == false) goto L13;
        return true;
    L5:
        if (r100 == ChronoField.DAY_OF_WEEK) goto L15;
        return false;
    L15:
        return true;
    }

    public DayOfWeek minus(long r100) {
        return plus(-(r100 % 7));
    }

    public DayOfWeek plus(long r100) {
        int r101 = (int) (r100 % 7);
        return f21486a[(ordinal() + (r101 + 7)) % 7];
    }

    @Override // bytedance.jvm.time.temporal.d
    public <R> R query(bytedance.jvm.time.temporal.l<R> r100) {
        if (r100 != bytedance.jvm.time.temporal.k.f21716c) goto L7;
        return (R) ChronoUnit.DAYS;
    L7:
        return (R) bytedance.jvm.time.temporal.c.b(this, r100);
    }

    @Override // bytedance.jvm.time.temporal.d
    public ValueRange range(bytedance.jvm.time.temporal.j r100) {
        if (r100 != ChronoField.DAY_OF_WEEK) goto L7;
        return r100.range();
    L7:
        return bytedance.jvm.time.temporal.c.c(this, r100);
    }

    public DayOfWeek(String r100, int r101) {
        super(r100, r101);
    }

    public String getDisplayName(TextStyle r100, Locale r101) {
        DateTimeFormatterBuilder r102 = new DateTimeFormatterBuilder();
        r102.e(ChronoField.DAY_OF_WEEK, r100);
        return r102.o(r101).a(this);
    }
}
