package org.threeten.bp.zone;

import com.android.contacts.common.list.DefaultContactListAdapter;
import com.android.contacts.util.HanziToPinyin;
import com.bytedance.framwork.core.sdklib.DBHelper;
import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;
import java.io.Serializable;
import org.threeten.bp.DayOfWeek;
import org.threeten.bp.LocalDate;
import org.threeten.bp.LocalDateTime;
import org.threeten.bp.LocalTime;
import org.threeten.bp.Month;
import org.threeten.bp.ZoneOffset;
import org.threeten.bp.chrono.IsoChronology;
import org.threeten.bp.jdk8.Jdk8Methods;
import org.threeten.bp.temporal.TemporalAdjusters;

/* JADX INFO: loaded from: classes5.dex */
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

    /* JADX INFO: renamed from: org.threeten.bp.zone.ZoneOffsetTransitionRule$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$org$threeten$bp$zone$ZoneOffsetTransitionRule$TimeDefinition = null;

        static {
            int[] r0 = new int[TimeDefinition.values().length];
            $SwitchMap$org$threeten$bp$zone$ZoneOffsetTransitionRule$TimeDefinition = r0;
            r0[TimeDefinition.UTC.ordinal()] = 1;     // Catch: NoSuchFieldError -> L6
        L8:
            $SwitchMap$org$threeten$bp$zone$ZoneOffsetTransitionRule$TimeDefinition[TimeDefinition.STANDARD.ordinal()] = 2;     // Catch: NoSuchFieldError -> L7
            return;
        }
    }

    public static final enum TimeDefinition extends Enum<TimeDefinition> {
        private static final /* synthetic */ TimeDefinition[] $VALUES = null;
        public static final TimeDefinition STANDARD = null;
        public static final TimeDefinition UTC = null;
        public static final TimeDefinition WALL = null;

        private TimeDefinition(String r1, int r2) {
            super(r1, r2);
        }

        public static TimeDefinition valueOf(String r1) {
            return (TimeDefinition) Enum.valueOf(TimeDefinition.class, r1);
        }

        public static TimeDefinition[] values() {
            return (TimeDefinition[]) $VALUES.clone();
        }

        static {
            TimeDefinition r0 = new TimeDefinition("UTC", 0);
            UTC = r0;
            TimeDefinition r1 = new TimeDefinition("WALL", 1);
            WALL = r1;
            TimeDefinition r3 = new TimeDefinition("STANDARD", 2);
            STANDARD = r3;
            $VALUES = new TimeDefinition[]{r0, r1, r3};
        }

        public LocalDateTime createDateTime(LocalDateTime r2, ZoneOffset r3, ZoneOffset r4) {
            int r1 = AnonymousClass1.$SwitchMap$org$threeten$bp$zone$ZoneOffsetTransitionRule$TimeDefinition[ordinal()];
            if (r1 == 1) goto L10;
            if (r1 == 2) goto L8;
            return r2;
        L8:
            return r2.plusSeconds(r4.getTotalSeconds() - r3.getTotalSeconds());
        L10:
            return r2.plusSeconds(r4.getTotalSeconds() - ZoneOffset.UTC.getTotalSeconds());
        }
    }

    public static ZoneOffsetTransitionRule of(Month r11, int r12, DayOfWeek r13, LocalTime r14, boolean r15, TimeDefinition r16, ZoneOffset r17, ZoneOffset r18, ZoneOffset r19) {
        Jdk8Methods.requireNonNull(r11, "month");
        Jdk8Methods.requireNonNull(r14, DBHelper.COL_TIME);
        Jdk8Methods.requireNonNull(r16, "timeDefnition");
        Jdk8Methods.requireNonNull(r17, "standardOffset");
        Jdk8Methods.requireNonNull(r18, "offsetBefore");
        Jdk8Methods.requireNonNull(r19, "offsetAfter");
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

    ZoneOffsetTransitionRule(Month r1, int r2, DayOfWeek r3, LocalTime r4, boolean r5, TimeDefinition r6, ZoneOffset r7, ZoneOffset r8, ZoneOffset r9) {
        this.month = r1;
        this.dom = (byte) r2;
        this.dow = r3;
        this.time = r4;
        this.timeEndOfDay = r5;
        this.timeDefinition = r6;
        this.standardOffset = r7;
        this.offsetBefore = r8;
        this.offsetAfter = r9;
    }

    private Object writeReplace() {
        return new Ser((byte) 3, this);
    }

    void writeExternal(DataOutput r13) throws IOException {
        if (this.timeEndOfDay == false) goto L5;
        int r0 = 86400;
    L6:
        int r1 = this.standardOffset.getTotalSeconds();
        int r2 = this.offsetBefore.getTotalSeconds() - r1;
        int r3 = this.offsetAfter.getTotalSeconds() - r1;
        if ((r0 % 3600) == 0) goto L9;
        int r4 = 31;
    L14:
        if ((r1 % 900) != 0) goto L16;
        int r6 = (r1 / 900) + 128;
    L18:
        if (r2 == 0) goto L23;
        if (r2 == 1800) goto L23;
        if (r2 == 3600) goto L23;
        int r5 = 3;
    L24:
        if (r3 == 0) goto L29;
        if (r3 == 1800) goto L29;
        if (r3 == 3600) goto L29;
        int r7 = 3;
    L30:
        DayOfWeek r8 = this.dow;
        if (r8 != null) goto L33;
        int r9 = 0;
    L34:
        r13.writeInt((((((((this.month.getValue() << 28) + ((this.dom + 32) << 22)) + (r9 << 19)) + (r4 << 14)) + (this.timeDefinition.ordinal() << 12)) + (r6 << 4)) + (r5 << 2)) + r7);
        if (r4 != 31) goto L37;
        r13.writeInt(r0);
    L37:
        if (r6 != 255) goto L39;
        r13.writeInt(r1);
    L39:
        if (r5 != 3) goto L41;
        r13.writeInt(this.offsetBefore.getTotalSeconds());
    L41:
        if (r7 != 3) goto L44;
        r13.writeInt(this.offsetAfter.getTotalSeconds());
        return;
    L44:
        return;
    L33:
        r9 = r8.getValue();
    L29:
        r7 = r3 / 1800;
    L23:
        r5 = r2 / 1800;
        goto L24
    L16:
        r6 = 255;
        goto L18
    L9:
        if (this.timeEndOfDay == false) goto L11;
        r4 = 24;
        goto L14
    L11:
        r4 = this.time.getHour();
        goto L14
    L5:
        r0 = this.time.toSecondOfDay();
        goto L6
    }

    static ZoneOffsetTransitionRule readExternal(DataInput r13) throws IOException {
        int r0 = r13.readInt();
        Month r2 = Month.of(r0 >>> 28);
        int r3 = ((264241152 & r0) >>> 22) - 32;
        int r1 = (3670016 & r0) >>> 19;
        if (r1 != 0) goto L5;
        DayOfWeek r4 = null;
    L6:
        DayOfWeek r5 = r4;
        int r6 = (507904 & r0) >>> 14;
        TimeDefinition r7 = TimeDefinition.values()[(r0 & 12288) >>> 12];
        int r8 = (r0 & 4080) >>> 4;
        int r9 = (r0 & 12) >>> 2;
        int r10 = r0 & 3;
        if (r6 != 31) goto L9;
        LocalTime r11 = LocalTime.ofSecondOfDay(r13.readInt());
    L11:
        if (r8 != 255) goto L13;
        int r12 = r13.readInt();
    L14:
        ZoneOffset r14 = ZoneOffset.ofTotalSeconds(r12);
        if (r9 != 3) goto L17;
        int r15 = r13.readInt();
    L18:
        ZoneOffset r16 = ZoneOffset.ofTotalSeconds(r15);
        if (r10 != 3) goto L21;
        int r17 = r13.readInt();
    L22:
        ZoneOffset r18 = ZoneOffset.ofTotalSeconds(r17);
        if (r6 != 24) goto L25;
        boolean r19 = true;
    L27:
        return of(r2, r3, r5, r11, r19, r7, r14, r16, r18);
    L25:
        r19 = false;
        goto L27
    L21:
        r17 = r14.getTotalSeconds() + (r10 * 1800);
        goto L22
    L17:
        r15 = r14.getTotalSeconds() + (r9 * 1800);
        goto L18
    L13:
        r12 = (r8 - 128) * 900;
        goto L14
    L9:
        r11 = LocalTime.of(r6 % 24, 0);
        goto L11
    L5:
        r4 = DayOfWeek.of(r1);
        goto L6
    }

    public Month getMonth() {
        return this.month;
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

    public boolean isMidnightEndOfDay() {
        return this.timeEndOfDay;
    }

    public TimeDefinition getTimeDefinition() {
        return this.timeDefinition;
    }

    public ZoneOffset getStandardOffset() {
        return this.standardOffset;
    }

    public ZoneOffset getOffsetBefore() {
        return this.offsetBefore;
    }

    public ZoneOffset getOffsetAfter() {
        return this.offsetAfter;
    }

    public ZoneOffsetTransition createTransition(int r5) {
        byte r0 = this.dom;
        if (r0 >= 0) goto L7;
        Month r1 = this.month;
        LocalDate r6 = LocalDate.of(r5, r1, (r1.length(IsoChronology.INSTANCE.isLeapYear(r5)) + 1) + this.dom);
        DayOfWeek r2 = this.dow;
        if (r2 == null) goto L11;
        r6 = r6.with(TemporalAdjusters.previousOrSame(r2));
    L11:
        if (this.timeEndOfDay == false) goto L14;
        r6 = r6.plusDays(1);
    L14:
        return new ZoneOffsetTransition(this.timeDefinition.createDateTime(LocalDateTime.of(r6, this.time), this.standardOffset, this.offsetBefore), this.offsetBefore, this.offsetAfter);
    L7:
        r6 = LocalDate.of(r5, this.month, r0);
        DayOfWeek r3 = this.dow;
        if (r3 == null) goto L11;
        r6 = r6.with(TemporalAdjusters.nextOrSame(r3));
        goto L11
    }

    public boolean equals(Object r5) {
        if (r5 != this) goto L6;
        return true;
    L6:
        if ((r5 instanceof ZoneOffsetTransitionRule) == false) goto L28;
        ZoneOffsetTransitionRule r6 = (ZoneOffsetTransitionRule) r5;
        if (this.month != r6.month) goto L27;
        if (this.dom != r6.dom) goto L27;
        if (this.dow != r6.dow) goto L27;
        if (this.timeDefinition != r6.timeDefinition) goto L27;
        if (this.time.equals(r6.time) == false) goto L27;
        if (this.timeEndOfDay != r6.timeEndOfDay) goto L27;
        if (this.standardOffset.equals(r6.standardOffset) == false) goto L27;
        if (this.offsetBefore.equals(r6.offsetBefore) == false) goto L27;
        if (this.offsetAfter.equals(r6.offsetAfter) == false) goto L27;
        return true;
    L27:
        return false;
    L28:
        return false;
    }

    public int hashCode() {
        int r0 = (((this.time.toSecondOfDay() + (this.timeEndOfDay ? 1 : 0)) << 15) + (this.month.ordinal() << 11)) + ((this.dom + 32) << 5);
        DayOfWeek r1 = this.dow;
        if (r1 != null) goto L5;
        int r2 = 7;
    L6:
        int r3 = (((r0 + (r2 << 2)) + this.timeDefinition.ordinal()) ^ this.standardOffset.hashCode()) ^ this.offsetBefore.hashCode();
        return this.offsetAfter.hashCode() ^ r3;
    L5:
        r2 = r1.ordinal();
        goto L6
    }

    public String toString() {
        StringBuilder r0 = new StringBuilder("TransitionRule[");
        if (this.offsetBefore.compareTo2(this.offsetAfter) <= 0) goto L5;
        String r1 = "Gap ";
    L6:
        r0.append(r1).append(this.offsetBefore).append(" to ").append(this.offsetAfter).append(", ");
        DayOfWeek r2 = this.dow;
        if (r2 == null) goto L14;
        byte r3 = this.dom;
        if (r3 != (-1)) goto L11;
        r0.append(r2.name()).append(" on or before last day of ").append(this.month.name());
    L15:
        StringBuilder r4 = r0.append(" at ");
        if (this.timeEndOfDay == false) goto L18;
        String r5 = "24:00";
    L19:
        r4.append(r5).append(HanziToPinyin.Token.SEPARATOR).append(this.timeDefinition).append(", standard offset ").append(this.standardOffset).append(DefaultContactListAdapter.SNIPPET_END_MATCH);
        return r0.toString();
    L18:
        r5 = this.time.toString();
        goto L19
    L11:
        if (r3 >= 0) goto L13;
        r0.append(r2.name()).append(" on or before last day minus ").append((-this.dom) - 1).append(" of ").append(this.month.name());
        goto L15
    L13:
        r0.append(r2.name()).append(" on or after ").append(this.month.name()).append(' ').append(this.dom);
        goto L15
    L14:
        r0.append(this.month.name()).append(' ').append(this.dom);
        goto L15
    L5:
        r1 = "Overlap ";
        goto L6
    }
}
