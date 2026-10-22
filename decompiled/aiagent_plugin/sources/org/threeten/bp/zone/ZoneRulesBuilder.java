package org.threeten.bp.zone;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.threeten.bp.DayOfWeek;
import org.threeten.bp.LocalDate;
import org.threeten.bp.LocalDateTime;
import org.threeten.bp.LocalTime;
import org.threeten.bp.Month;
import org.threeten.bp.Year;
import org.threeten.bp.ZoneOffset;
import org.threeten.bp.chrono.IsoChronology;
import org.threeten.bp.jdk8.Jdk8Methods;
import org.threeten.bp.temporal.ChronoField;
import org.threeten.bp.temporal.TemporalAdjusters;

/* JADX INFO: loaded from: classes5.dex */
class ZoneRulesBuilder {
    private Map<Object, Object> deduplicateMap;
    private List<TZWindow> windowList;

    class TZRule implements Comparable<TZRule> {
        private int dayOfMonthIndicator;
        private DayOfWeek dayOfWeek;
        private Month month;
        private int savingAmountSecs;
        final /* synthetic */ ZoneRulesBuilder this$0;
        private LocalTime time;
        private ZoneOffsetTransitionRule.TimeDefinition timeDefinition;
        private boolean timeEndOfDay;
        private int year;

        static /* synthetic */ boolean access$1000(TZRule r0) {
            return r0.timeEndOfDay;
        }

        static /* synthetic */ ZoneOffsetTransitionRule.TimeDefinition access$1100(TZRule r0) {
            return r0.timeDefinition;
        }

        static /* synthetic */ int access$300(TZRule r0) {
            return r0.savingAmountSecs;
        }

        static /* synthetic */ int access$500(TZRule r0) {
            return r0.year;
        }

        static /* synthetic */ int access$502(TZRule r0, int r1) {
            r0.year = r1;
            return r1;
        }

        static /* synthetic */ Month access$600(TZRule r0) {
            return r0.month;
        }

        static /* synthetic */ int access$700(TZRule r0) {
            return r0.dayOfMonthIndicator;
        }

        static /* synthetic */ DayOfWeek access$800(TZRule r0) {
            return r0.dayOfWeek;
        }

        static /* synthetic */ LocalTime access$900(TZRule r0) {
            return r0.time;
        }

        @Override // java.lang.Comparable
        public /* synthetic */ int compareTo(TZRule r3) {
            return compareTo2((TZRule) ZeusTransformUtils.preCheckCast(r3, TZRule.class, "com.obric.aiagent.plugin"));
        }

        TZRule(ZoneRulesBuilder r1, int r2, Month r3, int r4, DayOfWeek r5, LocalTime r6, boolean r7, ZoneOffsetTransitionRule.TimeDefinition r8, int r9) {
            this.this$0 = r1;
            this.year = r2;
            this.month = r3;
            this.dayOfMonthIndicator = r4;
            this.dayOfWeek = r5;
            this.time = r6;
            this.timeEndOfDay = r7;
            this.timeDefinition = r8;
            this.savingAmountSecs = r9;
        }

        ZoneOffsetTransition toTransition(ZoneOffset r5, int r6) {
            LocalDate r0 = toLocalDate();
            LocalDate r1 = (LocalDate) ZeusTransformUtils.preCheckCast(this.this$0.deduplicate(r0), LocalDate.class, "com.obric.aiagent.plugin");
            LocalDateTime r2 = (LocalDateTime) ZeusTransformUtils.preCheckCast(this.this$0.deduplicate(LocalDateTime.of(r1, this.time)), LocalDateTime.class, "com.obric.aiagent.plugin");
            ZoneOffset r7 = (ZoneOffset) ZeusTransformUtils.preCheckCast(this.this$0.deduplicate(ZoneOffset.ofTotalSeconds(r5.getTotalSeconds() + r6)), ZoneOffset.class, "com.obric.aiagent.plugin");
            return new ZoneOffsetTransition((LocalDateTime) ZeusTransformUtils.preCheckCast(this.this$0.deduplicate(this.timeDefinition.createDateTime(r2, r5, r7)), LocalDateTime.class, "com.obric.aiagent.plugin"), r7, (ZoneOffset) ZeusTransformUtils.preCheckCast(this.this$0.deduplicate(ZoneOffset.ofTotalSeconds(r5.getTotalSeconds() + this.savingAmountSecs)), ZoneOffset.class, "com.obric.aiagent.plugin"));
        }

        ZoneOffsetTransitionRule toTransitionRule(ZoneOffset r12, int r13) {
            if (this.dayOfMonthIndicator >= 0) goto L8;
            if (this.month == Month.FEBRUARY) goto L8;
            this.dayOfMonthIndicator = this.month.maxLength() - 6;
        L8:
            if (this.timeEndOfDay == false) goto L22;
            int r0 = this.dayOfMonthIndicator;
            if (r0 <= 0) goto L22;
            if (r0 == 28) goto L14;
        L16:
            boolean r1 = false;
        L17:
            if (r1 == true) goto L22;
            LocalDate r2 = LocalDate.of(2004, this.month, this.dayOfMonthIndicator).plusDays(1);
            this.month = r2.getMonth();
            this.dayOfMonthIndicator = r2.getDayOfMonth();
            DayOfWeek r3 = this.dayOfWeek;
            if (r3 == null) goto L21;
            this.dayOfWeek = r3.plus(1);
        L21:
            this.timeEndOfDay = false;
            goto L22
        L14:
            if (this.month != Month.FEBRUARY) goto L16;
            r1 = true;
        L22:
            ZoneOffsetTransition r14 = toTransition(r12, r13);
            return new ZoneOffsetTransitionRule(this.month, this.dayOfMonthIndicator, this.dayOfWeek, this.time, this.timeEndOfDay, this.timeDefinition, r12, r14.getOffsetBefore(), r14.getOffsetAfter());
        }

        /* JADX INFO: renamed from: compareTo, reason: avoid collision after fix types in other method */
        public int compareTo2(TZRule r3) {
            int r0 = this.year - r3.year;
            if (r0 != 0) goto L5;
            r0 = this.month.compareTo(r3.month);
        L5:
            if (r0 != 0) goto L7;
            r0 = toLocalDate().compareTo(r3.toLocalDate());
        L7:
            if (r0 == 0) goto L9;
            return r0;
        L9:
            return this.time.compareTo2(r3.time);
        }

        private LocalDate toLocalDate() {
            int r0 = this.dayOfMonthIndicator;
            if (r0 >= 0) goto L7;
            LocalDate r1 = LocalDate.of(this.year, this.month, (this.month.length(IsoChronology.INSTANCE.isLeapYear(this.year)) + 1) + this.dayOfMonthIndicator);
            DayOfWeek r2 = this.dayOfWeek;
            if (r2 == null) goto L11;
            r1 = r1.with(TemporalAdjusters.previousOrSame(r2));
        L11:
            if (this.timeEndOfDay == true) goto L13;
            return r1;
        L13:
            return r1.plusDays(1);
        L7:
            r1 = LocalDate.of(this.year, this.month, r0);
            DayOfWeek r3 = this.dayOfWeek;
            if (r3 == null) goto L11;
            r1 = r1.with(TemporalAdjusters.nextOrSame(r3));
            goto L11
        }
    }

    class TZWindow {
        private Integer fixedSavingAmountSecs;
        private List<TZRule> lastRuleList;
        private int maxLastRuleStartYear;
        private List<TZRule> ruleList;
        private final ZoneOffset standardOffset;
        final /* synthetic */ ZoneRulesBuilder this$0;
        private final ZoneOffsetTransitionRule.TimeDefinition timeDefinition;
        private final LocalDateTime windowEnd;

        static /* synthetic */ ZoneOffset access$000(TZWindow r0) {
            return r0.standardOffset;
        }

        static /* synthetic */ Integer access$100(TZWindow r0) {
            return r0.fixedSavingAmountSecs;
        }

        static /* synthetic */ List access$200(TZWindow r0) {
            return r0.ruleList;
        }

        static /* synthetic */ List access$400(TZWindow r0) {
            return r0.lastRuleList;
        }

        TZWindow(ZoneRulesBuilder r1, ZoneOffset r2, LocalDateTime r3, ZoneOffsetTransitionRule.TimeDefinition r4) {
            this.this$0 = r1;
            this.ruleList = new ArrayList();
            this.maxLastRuleStartYear = Year.MIN_VALUE;
            this.lastRuleList = new ArrayList();
            this.windowEnd = r3;
            this.timeDefinition = r4;
            this.standardOffset = r2;
        }

        void setFixedSavings(int r2) {
            if (this.ruleList.size() > 0) goto L9;
            if (this.lastRuleList.size() > 0) goto L9;
            this.fixedSavingAmountSecs = Integer.valueOf(r2);
            return;
        L9:
            throw new IllegalStateException("Window has DST rules, so cannot have fixed savings");
        }

        void addRule(int r16, int r17, Month r18, int r19, DayOfWeek r20, LocalTime r21, boolean r22, ZoneOffsetTransitionRule.TimeDefinition r23, int r24) {
            if (this.fixedSavingAmountSecs != null) goto L20;
            if (this.ruleList.size() >= 2000) goto L18;
            boolean r1 = false;
            int r3 = r17;
            if (r3 != 999999999) goto L9;
            r1 = true;
            r3 = r16;
        L9:
            int r2 = r16;
        L10:
            if (r2 > r3) goto L16;
            TZRule r14 = new TZRule(this.this$0, r2, r18, r19, r20, r21, r22, r23, r24);
            if (r1 == false) goto L14;
            this.lastRuleList.add(r14);
            this.maxLastRuleStartYear = Math.max(r16, this.maxLastRuleStartYear);
        L15:
            r2 = r2 + 1;
            goto L10
        L14:
            this.ruleList.add(r14);
            goto L15
        L16:
            return;
        L18:
            throw new IllegalStateException("Window has reached the maximum number of allowed rules");
        L20:
            throw new IllegalStateException("Window has a fixed DST saving, so cannot have DST rules");
        }

        void validateWindowOrder(TZWindow r4) {
            if (this.windowEnd.isBefore(r4.windowEnd) == true) goto L6;
            return;
        L6:
            throw new IllegalStateException("Windows must be added in date-time order: " + this.windowEnd + " < " + r4.windowEnd);
        }

        void tidy(int r17) {
            if (this.lastRuleList.size() == 1) goto L26;
            if (this.windowEnd.equals(LocalDateTime.MAX) == false) goto L14;
            this.maxLastRuleStartYear = Math.max(this.maxLastRuleStartYear, r17) + 1;
            Iterator<TZRule> r14 = this.lastRuleList.iterator();
        L8:
            if (r14.hasNext() == false) goto L10;
            TZRule r15 = (TZRule) ZeusTransformUtils.preCheckCast(r14.next(), TZRule.class, "com.obric.aiagent.plugin");
            addRule(TZRule.access$500(r15), this.maxLastRuleStartYear, TZRule.access$600(r15), TZRule.access$700(r15), TZRule.access$800(r15), TZRule.access$900(r15), TZRule.access$1000(r15), TZRule.access$1100(r15), TZRule.access$300(r15));
            TZRule.access$502(r15, this.maxLastRuleStartYear + 1);
            goto L8
        L10:
            int r0 = this.maxLastRuleStartYear;
            if (r0 != 999999999) goto L13;
            this.lastRuleList.clear();
        L19:
            Collections.sort(this.ruleList);
            Collections.sort(this.lastRuleList);
            if (this.ruleList.size() == 0) goto L22;
            return;
        L22:
            if (this.fixedSavingAmountSecs != null) goto L30;
            this.fixedSavingAmountSecs = 0;
            return;
        L30:
            return;
        L13:
            this.maxLastRuleStartYear = r0 + 1;
            goto L19
        L14:
            int r16 = this.windowEnd.getYear();
            Iterator<TZRule> r18 = this.lastRuleList.iterator();
        L16:
            if (r18.hasNext() == false) goto L18;
            TZRule r1 = (TZRule) ZeusTransformUtils.preCheckCast(r18.next(), TZRule.class, "com.obric.aiagent.plugin");
            addRule(TZRule.access$500(r1), r16 + 1, TZRule.access$600(r1), TZRule.access$700(r1), TZRule.access$800(r1), TZRule.access$900(r1), TZRule.access$1000(r1), TZRule.access$1100(r1), TZRule.access$300(r1));
            goto L16
        L18:
            this.lastRuleList.clear();
            this.maxLastRuleStartYear = Year.MAX_VALUE;
            goto L19
        L26:
            throw new IllegalStateException("Cannot have only one rule defined as being forever");
        }

        boolean isSingleWindowStandardOffset() {
            if (this.windowEnd.equals(LocalDateTime.MAX) == true) goto L5;
        L13:
            return false;
        L5:
            if (this.timeDefinition != ZoneOffsetTransitionRule.TimeDefinition.WALL) goto L13;
            if (this.fixedSavingAmountSecs != null) goto L13;
            if (this.lastRuleList.isEmpty() == false) goto L13;
            if (this.ruleList.isEmpty() == false) goto L13;
            return true;
        }

        ZoneOffset createWallOffset(int r1) {
            return ZoneOffset.ofTotalSeconds(this.standardOffset.getTotalSeconds() + r1);
        }

        long createDateTimeEpochSecond(int r3) {
            ZoneOffset r4 = createWallOffset(r3);
            return this.timeDefinition.createDateTime(this.windowEnd, this.standardOffset, r4).toEpochSecond(r4);
        }
    }

    public ZoneRulesBuilder() {
        this.windowList = new ArrayList();
    }

    public ZoneRulesBuilder addWindow(ZoneOffset r2, LocalDateTime r3, ZoneOffsetTransitionRule.TimeDefinition r4) {
        Jdk8Methods.requireNonNull(r2, "standardOffset");
        Jdk8Methods.requireNonNull(r3, "until");
        Jdk8Methods.requireNonNull(r4, "untilDefinition");
        TZWindow r0 = new TZWindow(this, r2, r3, r4);
        if (this.windowList.size() <= 0) goto L5;
        List<TZWindow> r5 = this.windowList;
        r0.validateWindowOrder((TZWindow) ZeusTransformUtils.preCheckCast(r5.get(r5.size() - 1), TZWindow.class, "com.obric.aiagent.plugin"));
    L5:
        this.windowList.add(r0);
        return this;
    }

    public ZoneRulesBuilder addWindowForever(ZoneOffset r3) {
        return addWindow(r3, LocalDateTime.MAX, ZoneOffsetTransitionRule.TimeDefinition.WALL);
    }

    public ZoneRulesBuilder setFixedSavingsToWindow(int r4) {
        if (this.windowList.isEmpty() == true) goto L7;
        List<TZWindow> r0 = this.windowList;
        ((TZWindow) ZeusTransformUtils.preCheckCast(r0.get(r0.size() - 1), TZWindow.class, "com.obric.aiagent.plugin")).setFixedSavings(r4);
        return this;
    L7:
        throw new IllegalStateException("Must add a window before setting the fixed savings");
    }

    public ZoneRulesBuilder addRuleToWindow(LocalDateTime r12, ZoneOffsetTransitionRule.TimeDefinition r13, int r14) {
        Jdk8Methods.requireNonNull(r12, "transitionDateTime");
        return addRuleToWindow(r12.getYear(), r12.getYear(), r12.getMonth(), r12.getDayOfMonth(), null, r12.toLocalTime(), false, r13, r14);
    }

    public ZoneRulesBuilder addRuleToWindow(int r11, Month r12, int r13, LocalTime r14, boolean r15, ZoneOffsetTransitionRule.TimeDefinition r16, int r17) {
        return addRuleToWindow(r11, r11, r12, r13, null, r14, r15, r16, r17);
    }

    public ZoneRulesBuilder addRuleToWindow(int r13, int r14, Month r15, int r16, DayOfWeek r17, LocalTime r18, boolean r19, ZoneOffsetTransitionRule.TimeDefinition r20, int r21) {
        Jdk8Methods.requireNonNull(r15, "month");
        Jdk8Methods.requireNonNull(r18, "time");
        Jdk8Methods.requireNonNull(r20, "timeDefinition");
        ChronoField.YEAR.checkValidValue(r13);
        ChronoField.YEAR.checkValidValue(r14);
        if (r16 < (-28)) goto L20;
        if (r16 > 31) goto L20;
        if (r16 == 0) goto L20;
        if (r19 == false) goto L14;
        if (r18.equals(LocalTime.MIDNIGHT) == true) goto L14;
        throw new IllegalArgumentException("Time must be midnight when end of day flag is true");
    L14:
        if (this.windowList.isEmpty() == true) goto L18;
        List<TZWindow> r1 = this.windowList;
        ((TZWindow) ZeusTransformUtils.preCheckCast(r1.get(r1.size() - 1), TZWindow.class, "com.obric.aiagent.plugin")).addRule(r13, r14, r15, r16, r17, r18, r19, r20, r21);
        return this;
    L18:
        throw new IllegalStateException("Must add a window before adding a rule");
    L20:
        throw new IllegalArgumentException("Day of month indicator must be between -28 and 31 inclusive excluding zero");
    }

    public ZoneRules toRules(String r2) {
        return toRules(r2, new HashMap());
    }

    ZoneRules toRules(String r22, Map<Object, Object> r23) {
        Map<Object, Object> r1 = (Map) ZeusTransformUtils.wrapperContextForParams(r23, Map.class, "com.obric.aiagent.plugin");
        Jdk8Methods.requireNonNull(r22, "zoneId");
        this.deduplicateMap = r1;
        if (this.windowList.isEmpty() == true) goto L50;
        ArrayList r6 = new ArrayList(4);
        ArrayList r7 = new ArrayList(256);
        ArrayList r8 = new ArrayList(2);
        int r3 = 0;
        TZWindow r2 = (TZWindow) ZeusTransformUtils.preCheckCast(this.windowList.get(0), TZWindow.class, "com.obric.aiagent.plugin");
        ZoneOffset r4 = TZWindow.access$000(r2);
        if (TZWindow.access$100(r2) == null) goto L7;
        int r5 = TZWindow.access$100(r2).intValue();
    L8:
        ZoneOffset r9 = (ZoneOffset) ZeusTransformUtils.preCheckCast(deduplicate(ZoneOffset.ofTotalSeconds(r4.getTotalSeconds() + r5)), ZoneOffset.class, "com.obric.aiagent.plugin");
        LocalDateTime r10 = (LocalDateTime) ZeusTransformUtils.preCheckCast(deduplicate(LocalDateTime.of(Year.MIN_VALUE, 1, 1, 0, 0)), LocalDateTime.class, "com.obric.aiagent.plugin");
        Iterator<TZWindow> r12 = this.windowList.iterator();
        ZoneOffset r13 = r9;
    L10:
        if (r12.hasNext() == false) goto L48;
        TZWindow r14 = (TZWindow) ZeusTransformUtils.preCheckCast(r12.next(), TZWindow.class, "com.obric.aiagent.plugin");
        r14.tidy(r10.getYear());
        Integer r15 = TZWindow.access$100(r14);
        if (r15 != null) goto L21;
        r15 = Integer.valueOf(r3);
        Iterator r16 = TZWindow.access$200(r14).iterator();
    L15:
        if (r16.hasNext() == false) goto L21;
        TZRule r11 = (TZRule) ZeusTransformUtils.preCheckCast(r16.next(), TZRule.class, "com.obric.aiagent.plugin");
        if (r11.toTransition(r4, r5).toEpochSecond() > r10.toEpochSecond(r13)) goto L21;
        r15 = Integer.valueOf(TZRule.access$300(r11));
    L21:
        if (r4.equals(TZWindow.access$000(r14)) == true) goto L23;
        Iterator<TZWindow> r17 = r12;
        r6.add(deduplicate(new ZoneOffsetTransition(LocalDateTime.ofEpochSecond(r10.toEpochSecond(r13), 0, r4), r4, TZWindow.access$000(r14))));
        r4 = (ZoneOffset) ZeusTransformUtils.preCheckCast(deduplicate(TZWindow.access$000(r14)), ZoneOffset.class, "com.obric.aiagent.plugin");
    L24:
        ZoneOffset r18 = (ZoneOffset) ZeusTransformUtils.preCheckCast(deduplicate(ZoneOffset.ofTotalSeconds(r4.getTotalSeconds() + r15.intValue())), ZoneOffset.class, "com.obric.aiagent.plugin");
        if (r13.equals(r18) == true) goto L27;
        r7.add((ZoneOffsetTransition) ZeusTransformUtils.preCheckCast(deduplicate(new ZoneOffsetTransition(r10, r13, r18)), ZoneOffsetTransition.class, "com.obric.aiagent.plugin"));
    L27:
        int r19 = r15.intValue();
        Iterator r20 = TZWindow.access$200(r14).iterator();
    L29:
        if (r20.hasNext() == false) goto L42;
        TZRule r110 = (TZRule) ZeusTransformUtils.preCheckCast(r20.next(), TZRule.class, "com.obric.aiagent.plugin");
        ZoneOffsetTransition r111 = (ZoneOffsetTransition) ZeusTransformUtils.preCheckCast(deduplicate(r110.toTransition(r4, r19)), ZoneOffsetTransition.class, "com.obric.aiagent.plugin");
        if (r111.toEpochSecond() >= r10.toEpochSecond(r13)) goto L33;
        boolean r112 = true;
    L34:
        if (r112 == true) goto L41;
        if (r111.toEpochSecond() >= r14.createDateTimeEpochSecond(r19)) goto L41;
        if (r111.getOffsetBefore().equals(r111.getOffsetAfter()) == true) goto L41;
        r7.add(r111);
        r19 = TZRule.access$300(r110);
    L41:
        r19 = r19;
        goto L29
    L33:
        r112 = false;
        goto L34
    L42:
        int r113 = r19;
        Iterator r21 = TZWindow.access$400(r14).iterator();
        r5 = r113;
    L44:
        if (r21.hasNext() == false) goto L46;
        TZRule r114 = (TZRule) ZeusTransformUtils.preCheckCast(r21.next(), TZRule.class, "com.obric.aiagent.plugin");
        r8.add((ZoneOffsetTransitionRule) ZeusTransformUtils.preCheckCast(deduplicate(r114.toTransitionRule(r4, r5)), ZoneOffsetTransitionRule.class, "com.obric.aiagent.plugin"));
        r5 = TZRule.access$300(r114);
        goto L44
    L46:
        r13 = (ZoneOffset) ZeusTransformUtils.preCheckCast(deduplicate(r14.createWallOffset(r5)), ZoneOffset.class, "com.obric.aiagent.plugin");
        r3 = 0;
        r10 = (LocalDateTime) ZeusTransformUtils.preCheckCast(deduplicate(LocalDateTime.ofEpochSecond(r14.createDateTimeEpochSecond(r5), 0, r13)), LocalDateTime.class, "com.obric.aiagent.plugin");
        r12 = r17;
        goto L10
    L23:
        r17 = r12;
        goto L24
    L48:
        return new StandardZoneRules(TZWindow.access$000(r2), r9, r6, r7, r8);
    L7:
        r5 = 0;
        goto L8
    L50:
        throw new IllegalStateException("No windows have been added to the builder");
    }

    <T> T deduplicate(T r2) {
        if (this.deduplicateMap.containsKey(r2) == true) goto L6;
        this.deduplicateMap.put(r2, r2);
    L6:
        return (T) this.deduplicateMap.get(r2);
    }
}
