package com.obric.oui.calendar;

import java.util.Collection;
import org.threeten.bp.DayOfWeek;
import org.threeten.bp.LocalDate;

/* JADX INFO: loaded from: classes3.dex */
class WeekView extends CalendarPagerView {
    @Override // com.obric.oui.calendar.CalendarPagerView
    protected boolean isDayEnabled(CalendarDay r1) {
        return true;
    }

    public WeekView(MaterialCalendarView r1, CalendarDay r2, DayOfWeek r3, boolean r4) {
        super(r1, r2, r3, r4);
    }

    @Override // com.obric.oui.calendar.CalendarPagerView
    protected void buildDayViews(Collection<DayView> r4, LocalDate r5) {
        int r0 = 0;
    L4:
        if (r0 >= 7) goto L6;
        addDayView(r4, r5);
        r5 = r5.plusDays(1);
        r0 = r0 + 1;
        goto L4
    }

    @Override // com.obric.oui.calendar.CalendarPagerView
    protected int getRows() {
        if (this.showWeekDays == false) goto L5;
        return 2;
    L5:
        return 1;
    }
}
