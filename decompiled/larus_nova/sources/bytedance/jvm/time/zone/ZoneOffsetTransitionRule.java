package bytedance.jvm.time.zone;

import bytedance.jvm.time.DayOfWeek;
import bytedance.jvm.time.LocalDate;
import bytedance.jvm.time.LocalDateTime;
import bytedance.jvm.time.LocalTime;
import bytedance.jvm.time.Month;
import bytedance.jvm.time.ZoneOffset;
import bytedance.jvm.time.chrono.IsoChronology;
import bytedance.jvm.time.temporal.f;
import bytedance.jvm.time.temporal.g;
import com.byted.mgl.merge.service.api.ui.BdpGameHostBaseUIService;
import com.bytedance.android.livesdk.announcement.AnnouncementViewModel;
import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;
import java.io.InvalidObjectException;
import java.io.ObjectInputStream;
import java.io.Serializable;
import java.util.Objects;

/* JADX INFO: loaded from: classes28.dex */
public final class ZoneOffsetTransitionRule implements Serializable {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private static final long serialVersionUID = 6889046316657758795L;
    private final byte dom;
    private final DayOfWeek dow;
    private final Month month;
    private final ZoneOffset offsetAfter;
    private final ZoneOffset offsetBefore;
    private final ZoneOffset standardOffset;
    private final LocalTime time;
    private final TimeDefinition timeDefinition;
    private final boolean timeEndOfDay;

    public static final enum TimeDefinition extends Enum<TimeDefinition> {
        public static final TimeDefinition STANDARD = null;
        public static final TimeDefinition UTC = null;
        public static final TimeDefinition WALL = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ TimeDefinition[] f21721a = null;

        static {
            TimeDefinition r100 = new TimeDefinition("UTC", 0);
            UTC = r100;
            TimeDefinition r101 = new TimeDefinition("WALL", 1);
            WALL = r101;
            TimeDefinition r102 = new TimeDefinition("STANDARD", 2);
            STANDARD = r102;
            f21721a = new TimeDefinition[]{r100, r101, r102};
        }

        public static TimeDefinition[] values() {
            return (TimeDefinition[]) f21721a.clone();
        }

        public static TimeDefinition valueOf(String r100) {
            return (TimeDefinition) r27.a.a(TimeDefinition.class, r100);
        }

        public TimeDefinition(String r100, int r101) {
            super(r100, r101);
        }

        public LocalDateTime createDateTime(LocalDateTime r100, ZoneOffset r101, ZoneOffset r102) {
            int r103 = a.f21722a[ordinal()];
            if (r103 == 1) goto L10;
            if (r103 == 2) goto L8;
            return r100;
        L8:
            return r100.plusSeconds(r102.getTotalSeconds() - r101.getTotalSeconds());
        L10:
            return r100.plusSeconds(r102.getTotalSeconds() - ZoneOffset.UTC.getTotalSeconds());
        }
    }

    public static /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f21722a = null;

        static {
            int[] r100 = new int[TimeDefinition.values().length];
            f21722a = r100;
            r100[TimeDefinition.UTC.ordinal()] = 1;     // Catch: NoSuchFieldError -> L6
        L8:
            f21722a[TimeDefinition.STANDARD.ordinal()] = 2;     // Catch: NoSuchFieldError -> L7
            return;
        }
    }

    private Object writeReplace() {
        return new Ser((byte) 3, this);
    }

    public int hashCode() {
        int r100 = (((this.time.toSecondOfDay() + (this.timeEndOfDay ? 1 : 0)) << 15) + (this.month.ordinal() << 11)) + ((this.dom + 32) << 5);
        DayOfWeek r101 = this.dow;
        if (r101 != null) goto L5;
        int r102 = 7;
    L7:
        return ((((r100 + (r102 << 2)) + this.timeDefinition.ordinal()) ^ this.standardOffset.hashCode()) ^ this.offsetBefore.hashCode()) ^ this.offsetAfter.hashCode();
    L5:
        r102 = r101.ordinal();
        goto L7
    }

    public String toString() {
        StringBuilder r100 = new StringBuilder("TransitionRule[");
        if (this.offsetBefore.compareTo2(this.offsetAfter) <= 0) goto L5;
        String r101 = "Gap ";
    L6:
        r100.append(r101);
        r100.append(this.offsetBefore);
        r100.append(" to ");
        r100.append(this.offsetAfter);
        r100.append(", ");
        DayOfWeek r102 = this.dow;
        if (r102 == null) goto L14;
        byte r103 = this.dom;
        if (r103 != (-1)) goto L11;
        r100.append(r102.name());
        r100.append(" on or before last day of ");
        r100.append(this.month.name());
    L15:
        r100.append(" at ");
        if (this.timeEndOfDay == false) goto L18;
        String r104 = "24:00";
    L19:
        r100.append(r104);
        r100.append(" ");
        r100.append(this.timeDefinition);
        r100.append(", standard offset ");
        r100.append(this.standardOffset);
        r100.append(']');
        return r100.toString();
    L18:
        r104 = this.time.toString();
        goto L19
    L11:
        if (r103 >= 0) goto L13;
        r100.append(r102.name());
        r100.append(" on or before last day minus ");
        r100.append((-this.dom) - 1);
        r100.append(" of ");
        r100.append(this.month.name());
        goto L15
    L13:
        r100.append(r102.name());
        r100.append(" on or after ");
        r100.append(this.month.name());
        r100.append(' ');
        r100.append(this.dom);
        goto L15
    L14:
        r100.append(this.month.name());
        r100.append(' ');
        r100.append(this.dom);
        goto L15
    L5:
        r101 = "Overlap ";
        goto L6
    }

    static {
    }

    public int getDayOfMonthIndicator() {
        return this.dom;
    }

    public DayOfWeek getDayOfWeek() {
        return this.dow;
    }

    public LocalTime getLocalTime() {
        return this.time;
    }

    public Month getMonth() {
        return this.month;
    }

    public ZoneOffset getOffsetAfter() {
        return this.offsetAfter;
    }

    public ZoneOffset getOffsetBefore() {
        return this.offsetBefore;
    }

    public ZoneOffset getStandardOffset() {
        return this.standardOffset;
    }

    public TimeDefinition getTimeDefinition() {
        return this.timeDefinition;
    }

    public boolean isMidnightEndOfDay() {
        return this.timeEndOfDay;
    }

    public static ZoneOffsetTransitionRule readExternal(DataInput r110) throws IOException {
        int r100 = r110.readInt();
        Month r101 = Month.of(r100 >>> 28);
        int r102 = ((264241152 & r100) >>> 22) - 32;
        int r103 = (3670016 & r100) >>> 19;
        if (r103 != 0) goto L5;
        DayOfWeek r104 = null;
    L6:
        DayOfWeek r105 = r104;
        int r106 = (507904 & r100) >>> 14;
        TimeDefinition r107 = TimeDefinition.values()[(r100 & 12288) >>> 12];
        int r108 = (r100 & 4080) >>> 4;
        int r109 = (r100 & 12) >>> 2;
        int r111 = r100 & 3;
        if (r106 != 31) goto L9;
        LocalTime r112 = LocalTime.ofSecondOfDay(r110.readInt());
    L11:
        if (r108 != 255) goto L13;
        int r113 = r110.readInt();
    L14:
        ZoneOffset r114 = ZoneOffset.ofTotalSeconds(r113);
        if (r109 != 3) goto L17;
        int r115 = r110.readInt();
    L18:
        ZoneOffset r116 = ZoneOffset.ofTotalSeconds(r115);
        if (r111 != 3) goto L21;
        int r117 = r110.readInt();
    L22:
        ZoneOffset r118 = ZoneOffset.ofTotalSeconds(r117);
        if (r106 != 24) goto L25;
        boolean r119 = true;
    L27:
        return of(r101, r102, r105, r112, r119, r107, r114, r116, r118);
    L25:
        r119 = false;
        goto L27
    L21:
        r117 = r114.getTotalSeconds() + (r111 * 1800);
        goto L22
    L17:
        r115 = r114.getTotalSeconds() + (r109 * 1800);
        goto L18
    L13:
        r113 = (r108 + com.alipay.sdk.m.n.a.f25611g) * 900;
        goto L14
    L9:
        r112 = LocalTime.of(r106 % 24, 0);
        goto L11
    L5:
        r104 = DayOfWeek.of(r103);
        goto L6
    }

    private void readObject(ObjectInputStream r100) throws InvalidObjectException {
        throw new InvalidObjectException("Deserialization via serialization delegate");
    }

    public ZoneOffsetTransition createTransition(int r100) {
        byte r101 = this.dom;
        if (r101 >= 0) goto L7;
        Month r102 = this.month;
        LocalDate r103 = LocalDate.of(r100, r102, (r102.length(IsoChronology.INSTANCE.isLeapYear(r100)) + 1) + this.dom);
        DayOfWeek r104 = this.dow;
        if (r104 == null) goto L11;
        final int r105 = r104.getValue();
        r103 = r103.with(new f(r105));
    L11:
        if (this.timeEndOfDay == false) goto L14;
        r103 = r103.plusDays(1);
    L14:
        return new ZoneOffsetTransition(this.timeDefinition.createDateTime(LocalDateTime.of(r103, this.time), this.standardOffset, this.offsetBefore), this.offsetBefore, this.offsetAfter);
    L7:
        r103 = LocalDate.of(r100, this.month, r101);
        DayOfWeek r106 = this.dow;
        if (r106 == null) goto L11;
        r103 = r103.with(new g(r106.getValue()));
        goto L11
    }

    public boolean equals(Object r100) {
        if (r100 != this) goto L6;
        return true;
    L6:
        if ((r100 instanceof ZoneOffsetTransitionRule) == false) goto L28;
        ZoneOffsetTransitionRule r101 = (ZoneOffsetTransitionRule) r100;
        if (this.month == r101.month) goto L10;
    L26:
        return false;
    L10:
        if (this.dom != r101.dom) goto L26;
        if (this.dow != r101.dow) goto L26;
        if (this.timeDefinition != r101.timeDefinition) goto L26;
        if (this.time.equals(r101.time) == false) goto L26;
        if (this.timeEndOfDay != r101.timeEndOfDay) goto L26;
        if (this.standardOffset.equals(r101.standardOffset) == false) goto L26;
        if (this.offsetBefore.equals(r101.offsetBefore) == false) goto L26;
        if (this.offsetAfter.equals(r101.offsetAfter) == false) goto L26;
        return true;
    L28:
        return false;
    }

    public void writeExternal(DataOutput r110) throws IOException {
        if (this.timeEndOfDay == false) goto L5;
        int r100 = 86400;
    L6:
        int r101 = this.standardOffset.getTotalSeconds();
        int r102 = this.offsetBefore.getTotalSeconds() - r101;
        int r103 = this.offsetAfter.getTotalSeconds() - r101;
        if ((r100 % AnnouncementViewModel.HOUR_DURATION) == 0) goto L9;
        int r104 = 31;
    L14:
        if ((r101 % 900) != 0) goto L16;
        int r105 = (r101 / 900) + 128;
    L18:
        if (r102 == 0) goto L23;
        if (r102 == 1800) goto L23;
        if (r102 == 3600) goto L23;
        int r106 = 3;
    L24:
        if (r103 == 0) goto L29;
        if (r103 == 1800) goto L29;
        if (r103 == 3600) goto L29;
        int r107 = 3;
    L30:
        DayOfWeek r108 = this.dow;
        if (r108 != null) goto L33;
        int r109 = 0;
    L34:
        r110.writeInt((((((((this.month.getValue() << 28) + ((this.dom + 32) << 22)) + (r109 << 19)) + (r104 << 14)) + (this.timeDefinition.ordinal() << 12)) + (r105 << 4)) + (r106 << 2)) + r107);
        if (r104 != 31) goto L37;
        r110.writeInt(r100);
    L37:
        if (r105 != 255) goto L39;
        r110.writeInt(r101);
    L39:
        if (r106 != 3) goto L41;
        r110.writeInt(this.offsetBefore.getTotalSeconds());
    L41:
        if (r107 != 3) goto L44;
        r110.writeInt(this.offsetAfter.getTotalSeconds());
        return;
    L44:
        return;
    L33:
        r109 = r108.getValue();
    L29:
        r107 = r103 / 1800;
    L23:
        r106 = r102 / 1800;
        goto L24
    L16:
        r105 = 255;
        goto L18
    L9:
        if (this.timeEndOfDay == false) goto L11;
        r104 = 24;
        goto L14
    L11:
        r104 = this.time.getHour();
        goto L14
    L5:
        r100 = this.time.toSecondOfDay();
        goto L6
    }

    public ZoneOffsetTransitionRule(Month r100, int r101, DayOfWeek r102, LocalTime r103, boolean r104, TimeDefinition r105, ZoneOffset r106, ZoneOffset r107, ZoneOffset r108) {
        this.month = r100;
        this.dom = (byte) r101;
        this.dow = r102;
        this.time = r103;
        this.timeEndOfDay = r104;
        this.timeDefinition = r105;
        this.standardOffset = r106;
        this.offsetBefore = r107;
        this.offsetAfter = r108;
    }

    public static ZoneOffsetTransitionRule of(Month r110, int r111, DayOfWeek r112, LocalTime r113, boolean r114, TimeDefinition r115, ZoneOffset r116, ZoneOffset r117, ZoneOffset r118) {
        Objects.requireNonNull(r110, BdpGameHostBaseUIService.DATE_PICKER_TYPE_MONTH);
        Objects.requireNonNull(r113, "time");
        Objects.requireNonNull(r115, "timeDefnition");
        Objects.requireNonNull(r116, "standardOffset");
        Objects.requireNonNull(r117, "offsetBefore");
        Objects.requireNonNull(r118, "offsetAfter");
        if (r111 < (-28)) goto L20;
        if (r111 > 31) goto L20;
        if (r111 == 0) goto L20;
        if (r114 == false) goto L14;
        if (r113.equals(LocalTime.MIDNIGHT) == true) goto L14;
        throw new IllegalArgumentException("Time must be midnight when end of day flag is true");
    L14:
        if (r113.getNano() != 0) goto L18;
        return new ZoneOffsetTransitionRule(r110, r111, r112, r113, r114, r115, r116, r117, r118);
    L18:
        throw new IllegalArgumentException("Time's nano-of-second must be zero");
    L20:
        throw new IllegalArgumentException("Day of month indicator must be between -28 and 31 inclusive excluding zero");
    }
}
