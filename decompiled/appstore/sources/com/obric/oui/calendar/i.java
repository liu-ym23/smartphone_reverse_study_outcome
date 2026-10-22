package com.obric.oui.calendar;

import java.util.Collection;
import org.threeten.bp.DayOfWeek;
import org.threeten.bp.LocalDate;

/* JADX INFO: loaded from: classes4.dex */
public class i extends c {

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public int f12717k;

    public i(MaterialCalendarView r10, CalendarDay r11, DayOfWeek r12, boolean r13) {
        super(r10, r11, r12, r13);
    }

    public CalendarDay B() {
        return g();
    }

    public final int C() {
        return c.j(B().getDate(), f(), MaterialCalendarView.H(this.f12683d));
    }

    @Override // com.obric.oui.calendar.c
    public void b(Collection r10, LocalDate r11) {
        this.f12717k = C();
        int r12 = 0;
    L4:
        if (r12 >= this.f12717k) goto L10;
        int r13 = 0;
    L7:
        if (r13 >= 7) goto L9;
        a(r10, r11);
        r11 = r11.plusDays(1);
        r13 = r13 + 1;
        goto L7
    L9:
        r12 = r12 + 1;
        goto L4
    }

    @Override // com.obric.oui.calendar.c
    public int i() {
        boolean r10 = this.f12688i;
        int r11 = this.f12717k;
        if (r10 == true) goto L5;
        return r11;
    L5:
        return r11 + 1;
    }

    @Override // com.obric.oui.calendar.c
    public boolean l(CalendarDay r10) {
        if (r10.getMonth() != g().getMonth()) goto L5;
        return true;
    L5:
        return false;
    }
}
