package com.prolificinteractive.materialcalendarview;

import java.util.Collection;
import org.threeten.bp.DayOfWeek;
import org.threeten.bp.LocalDate;

/* JADX INFO: loaded from: classes4.dex */
public class o extends d {
    public o(MaterialCalendarView r10, CalendarDay r11, DayOfWeek r12, boolean r13) {
        super(r10, r11, r12, r13);
    }

    @Override // com.prolificinteractive.materialcalendarview.d
    public void b(Collection r10, LocalDate r11) {
        int r12 = 0;
    L4:
        if (r12 >= 7) goto L6;
        a(r10, r11);
        r11 = r11.plusDays(1);
        r12 = r12 + 1;
        goto L4
    }

    @Override // com.prolificinteractive.materialcalendarview.d
    public int h() {
        if (this.f17785i == false) goto L5;
        return 2;
    L5:
        return 1;
    }

    @Override // com.prolificinteractive.materialcalendarview.d
    public boolean j(CalendarDay r10) {
        return true;
    }
}
