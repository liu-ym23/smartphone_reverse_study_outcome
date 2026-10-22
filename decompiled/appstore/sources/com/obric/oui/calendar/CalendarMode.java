package com.obric.oui.calendar;

/* JADX INFO: loaded from: classes4.dex */
public final enum CalendarMode extends Enum<CalendarMode> {
    private static final /* synthetic */ CalendarMode[] $VALUES = null;
    public static final CalendarMode MONTHS = null;
    public static final CalendarMode WEEKS = null;
    final int visibleWeeksCount;

    static {
        CalendarMode r10 = new CalendarMode("MONTHS", 0, 5);
        MONTHS = r10;
        CalendarMode r11 = new CalendarMode("WEEKS", 1, 1);
        WEEKS = r11;
        $VALUES = new CalendarMode[]{r10, r11};
    }

    private CalendarMode(String r10, int r11, int r12) {
        super(r10, r11);
        this.visibleWeeksCount = r12;
    }

    public static CalendarMode valueOf(String r10) {
        return (CalendarMode) Enum.valueOf(CalendarMode.class, r10);
    }

    public static CalendarMode[] values() {
        return (CalendarMode[]) $VALUES.clone();
    }
}
