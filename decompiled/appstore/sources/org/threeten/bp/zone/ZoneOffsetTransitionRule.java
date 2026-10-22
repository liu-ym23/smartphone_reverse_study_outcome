package org.threeten.bp.zone;

import com.blankj.utilcode.constant.CacheConstants;
import ig.d;
import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;
import java.io.Serializable;
import org.apache.http.message.TokenParser;
import org.threeten.bp.DayOfWeek;
import org.threeten.bp.LocalDate;
import org.threeten.bp.LocalDateTime;
import org.threeten.bp.LocalTime;
import org.threeten.bp.Month;
import org.threeten.bp.ZoneOffset;
import org.threeten.bp.chrono.IsoChronology;

/* JADX INFO: loaded from: classes4.dex */
public final class ZoneOffsetTransitionRule implements Serializable {
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
        private static final /* synthetic */ TimeDefinition[] $VALUES = null;
        public static final TimeDefinition STANDARD = null;
        public static final TimeDefinition UTC = null;
        public static final TimeDefinition WALL = null;

        static {
            TimeDefinition r10 = new TimeDefinition("UTC", 0);
            UTC = r10;
            TimeDefinition r11 = new TimeDefinition("WALL", 1);
            WALL = r11;
            TimeDefinition r12 = new TimeDefinition("STANDARD", 2);
            STANDARD = r12;
            $VALUES = new TimeDefinition[]{r10, r11, r12};
        }

        private TimeDefinition(String r10, int r11) {
            super(r10, r11);
        }

        public static TimeDefinition valueOf(String r10) {
            return (TimeDefinition) Enum.valueOf(TimeDefinition.class, r10);
        }

        public static TimeDefinition[] values() {
            return (TimeDefinition[]) $VALUES.clone();
        }

        public LocalDateTime createDateTime(LocalDateTime r10, ZoneOffset r11, ZoneOffset r12) {
            int r13 = a.f23243a[ordinal()];
            if (r13 == 1) goto L10;
            if (r13 == 2) goto L8;
            return r10;
        L8:
            return r10.plusSeconds(r12.getTotalSeconds() - r11.getTotalSeconds());
        L10:
            return r10.plusSeconds(r12.getTotalSeconds() - ZoneOffset.UTC.getTotalSeconds());
        }
    }

    public static /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f23243a = null;

        static {
            int[] r10 = new int[TimeDefinition.values().length];
            f23243a = r10;
            r10[TimeDefinition.UTC.ordinal()] = 1;     // Catch: NoSuchFieldError -> L6
        L8:
            f23243a[TimeDefinition.STANDARD.ordinal()] = 2;     // Catch: NoSuchFieldError -> L7
            return;
        }
    }

    public ZoneOffsetTransitionRule(Month r10, int r11, DayOfWeek r12, LocalTime r13, boolean r14, TimeDefinition r15, ZoneOffset r16, ZoneOffset r17, ZoneOffset r18) {
        this.month = r10;
        this.dom = (byte) r11;
        this.dow = r12;
        this.time = r13;
        this.timeEndOfDay = r14;
        this.timeDefinition = r15;
        this.standardOffset = r16;
        this.offsetBefore = r17;
        this.offsetAfter = r18;
    }

    public static ZoneOffsetTransitionRule of(Month r11, int r12, DayOfWeek r13, LocalTime r14, boolean r15, TimeDefinition r16, ZoneOffset r17, ZoneOffset r18, ZoneOffset r19) {
        d.h(r11, "month");
        d.h(r14, "time");
        d.h(r16, "timeDefnition");
        d.h(r17, "standardOffset");
        d.h(r18, "offsetBefore");
        d.h(r19, "offsetAfter");
        if (r12 < (-28)) goto L16;
        if (r12 > 31) goto L16;
        if (r12 == 0) goto L16;
        if (r15 == false) goto L14;
        if (r14.equals(LocalTime.MIDNIGHT) == true) goto L14;
        throw new IllegalArgumentException("Time must be midnight when end of day flag is true");
    L14:
        return new ZoneOffsetTransitionRule(r11, r12, r13, r14, r15, r16, r17, r18, r19);
    L16:
        throw new IllegalArgumentException("Day of month indicator must be between -28 and 31 inclusive excluding zero");
    }

    public static ZoneOffsetTransitionRule readExternal(DataInput r13) throws IOException {
        int r10 = r13.readInt();
        Month r11 = Month.of(r10 >>> 28);
        int r12 = ((264241152 & r10) >>> 22) - 32;
        int r14 = (3670016 & r10) >>> 19;
        if (r14 != 0) goto L6;
        DayOfWeek r15 = null;
    L5:
        DayOfWeek r16 = r15;
        int r17 = (507904 & r10) >>> 14;
        TimeDefinition r18 = TimeDefinition.values()[(r10 & 12288) >>> 12];
        int r19 = (r10 & 4080) >>> 4;
        int r20 = (r10 & 12) >>> 2;
        int r21 = r10 & 3;
        if (r17 != 31) goto L10;
        LocalTime r22 = LocalTime.ofSecondOfDay(r13.readInt());
    L12:
        if (r19 != 255) goto L15;
        int r23 = r13.readInt();
    L14:
        ZoneOffset r24 = ZoneOffset.ofTotalSeconds(r23);
        if (r20 != 3) goto L19;
        int r25 = r13.readInt();
    L18:
        ZoneOffset r26 = ZoneOffset.ofTotalSeconds(r25);
        if (r21 != 3) goto L23;
        int r110 = r13.readInt();
    L22:
        ZoneOffset r111 = ZoneOffset.ofTotalSeconds(r110);
        if (r17 != 24) goto L27;
        boolean r27 = true;
    L29:
        return of(r11, r12, r16, r22, r27, r18, r24, r26, r111);
    L27:
        r27 = false;
        goto L29
    L23:
        r110 = r24.getTotalSeconds() + (r21 * 1800);
        goto L22
    L19:
        r25 = r24.getTotalSeconds() + (r20 * 1800);
        goto L18
    L15:
        r23 = (r19 - 128) * 900;
        goto L14
    L10:
        r22 = LocalTime.of(r17 % 24, 0);
        goto L12
    L6:
        r15 = DayOfWeek.of(r14);
        goto L5
    }

    private Object writeReplace() {
        return new Ser((byte) 3, this);
    }

    public ZoneOffsetTransition createTransition(int r10) {
        byte r11 = this.dom;
        if (r11 >= 0) goto L7;
        Month r12 = this.month;
        LocalDate r13 = LocalDate.of(r10, r12, (r12.length(IsoChronology.INSTANCE.isLeapYear(r10)) + 1) + this.dom);
        DayOfWeek r14 = this.dow;
        if (r14 == null) goto L11;
        r13 = r13.with(org.threeten.bp.temporal.a.b(r14));
    L11:
        if (this.timeEndOfDay == false) goto L14;
        r13 = r13.plusDays(1);
    L14:
        return new ZoneOffsetTransition(this.timeDefinition.createDateTime(LocalDateTime.of(r13, this.time), this.standardOffset, this.offsetBefore), this.offsetBefore, this.offsetAfter);
    L7:
        r13 = LocalDate.of(r10, this.month, r11);
        DayOfWeek r15 = this.dow;
        if (r15 == null) goto L11;
        r13 = r13.with(org.threeten.bp.temporal.a.a(r15));
        goto L11
    }

    public boolean equals(Object r10) {
        if (r10 != this) goto L6;
        return true;
    L6:
        if ((r10 instanceof ZoneOffsetTransitionRule) == false) goto L28;
        ZoneOffsetTransitionRule r11 = (ZoneOffsetTransitionRule) r10;
        if (this.month != r11.month) goto L27;
        if (this.dom != r11.dom) goto L27;
        if (this.dow != r11.dow) goto L27;
        if (this.timeDefinition != r11.timeDefinition) goto L27;
        if (this.time.equals(r11.time) == false) goto L27;
        if (this.timeEndOfDay != r11.timeEndOfDay) goto L27;
        if (this.standardOffset.equals(r11.standardOffset) == false) goto L27;
        if (this.offsetBefore.equals(r11.offsetBefore) == false) goto L27;
        if (this.offsetAfter.equals(r11.offsetAfter) == false) goto L27;
        return true;
    L27:
        return false;
    L28:
        return false;
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

    public int hashCode() {
        int r10 = (((this.time.toSecondOfDay() + (this.timeEndOfDay ? 1 : 0)) << 15) + (this.month.ordinal() << 11)) + ((this.dom + 32) << 5);
        DayOfWeek r11 = this.dow;
        if (r11 != null) goto L5;
        int r12 = 7;
    L6:
        int r13 = (((r10 + (r12 << 2)) + this.timeDefinition.ordinal()) ^ this.standardOffset.hashCode()) ^ this.offsetBefore.hashCode();
        return this.offsetAfter.hashCode() ^ r13;
    L5:
        r12 = r11.ordinal();
        goto L6
    }

    public boolean isMidnightEndOfDay() {
        return this.timeEndOfDay;
    }

    public String toString() {
        StringBuilder r10 = new StringBuilder();
        r10.append("TransitionRule[");
        if (this.offsetBefore.compareTo2(this.offsetAfter) <= 0) goto L5;
        String r11 = "Gap ";
    L6:
        r10.append(r11);
        r10.append(this.offsetBefore);
        r10.append(" to ");
        r10.append(this.offsetAfter);
        r10.append(", ");
        DayOfWeek r12 = this.dow;
        if (r12 == null) goto L14;
        byte r13 = this.dom;
        if (r13 != (-1)) goto L11;
        r10.append(r12.name());
        r10.append(" on or before last day of ");
        r10.append(this.month.name());
    L15:
        r10.append(" at ");
        if (this.timeEndOfDay == false) goto L18;
        String r14 = "24:00";
    L19:
        r10.append(r14);
        r10.append(" ");
        r10.append(this.timeDefinition);
        r10.append(", standard offset ");
        r10.append(this.standardOffset);
        r10.append(']');
        return r10.toString();
    L18:
        r14 = this.time.toString();
        goto L19
    L11:
        if (r13 >= 0) goto L13;
        r10.append(r12.name());
        r10.append(" on or before last day minus ");
        r10.append((-this.dom) - 1);
        r10.append(" of ");
        r10.append(this.month.name());
        goto L15
    L13:
        r10.append(r12.name());
        r10.append(" on or after ");
        r10.append(this.month.name());
        r10.append(TokenParser.SP);
        r10.append(this.dom);
        goto L15
    L14:
        r10.append(this.month.name());
        r10.append(TokenParser.SP);
        r10.append(this.dom);
        goto L15
    L5:
        r11 = "Overlap ";
        goto L6
    }

    public void writeExternal(DataOutput r13) throws IOException {
        if (this.timeEndOfDay == false) goto L5;
        int r10 = CacheConstants.DAY;
    L6:
        int r11 = this.standardOffset.getTotalSeconds();
        int r12 = this.offsetBefore.getTotalSeconds() - r11;
        int r14 = this.offsetAfter.getTotalSeconds() - r11;
        if ((r10 % CacheConstants.HOUR) == 0) goto L9;
        int r15 = 31;
    L14:
        if ((r11 % 900) != 0) goto L16;
        int r16 = (r11 / 900) + 128;
    L18:
        if (r12 == 0) goto L23;
        if (r12 == 1800) goto L23;
        if (r12 == 3600) goto L23;
        int r17 = 3;
    L24:
        if (r14 == 0) goto L29;
        if (r14 == 1800) goto L29;
        if (r14 == 3600) goto L29;
        int r18 = 3;
    L30:
        DayOfWeek r19 = this.dow;
        if (r19 != null) goto L33;
        int r20 = 0;
    L34:
        r13.writeInt((((((((this.month.getValue() << 28) + ((this.dom + 32) << 22)) + (r20 << 19)) + (r15 << 14)) + (this.timeDefinition.ordinal() << 12)) + (r16 << 4)) + (r17 << 2)) + r18);
        if (r15 != 31) goto L37;
        r13.writeInt(r10);
    L37:
        if (r16 != 255) goto L39;
        r13.writeInt(r11);
    L39:
        if (r17 != 3) goto L41;
        r13.writeInt(this.offsetBefore.getTotalSeconds());
    L41:
        if (r18 != 3) goto L44;
        r13.writeInt(this.offsetAfter.getTotalSeconds());
        return;
    L44:
        return;
    L33:
        r20 = r19.getValue();
    L29:
        r18 = r14 / 1800;
    L23:
        r17 = r12 / 1800;
        goto L24
    L16:
        r16 = 255;
        goto L18
    L9:
        if (this.timeEndOfDay == false) goto L11;
        r15 = 24;
        goto L14
    L11:
        r15 = this.time.getHour();
        goto L14
    L5:
        r10 = this.time.toSecondOfDay();
        goto L6
    }
}
