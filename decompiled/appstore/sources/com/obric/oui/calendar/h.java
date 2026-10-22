package com.obric.oui.calendar;

import org.threeten.bp.Period;

/* JADX INFO: loaded from: classes4.dex */
public class h extends b {

    public static class a implements DateRangeIndex {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final CalendarDay f12715a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final int f12716b;

        public a(CalendarDay r10, CalendarDay r11) {
            this.f12715a = CalendarDay.from(r10.getYear(), r10.getMonth(), 1);
            this.f12716b = indexOf(r11) + 1;
        }

        @Override // com.obric.oui.calendar.DateRangeIndex
        public int getCount() {
            return this.f12716b;
        }

        @Override // com.obric.oui.calendar.DateRangeIndex
        public CalendarDay getItem(int r10) {
            return CalendarDay.from(this.f12715a.getDate().plusMonths(r10));
        }

        @Override // com.obric.oui.calendar.DateRangeIndex
        public int indexOf(CalendarDay r10) {
            return (int) Period.between(this.f12715a.getDate().withDayOfMonth(1), r10.getDate().withDayOfMonth(1)).toTotalMonths();
        }
    }

    public h(MaterialCalendarView r10) {
        super(r10);
    }

    public i D(int r10) {
        return new i(this.f12662b, f(r10), this.f12662b.getFirstDayOfWeek(), this.f12679s);
    }

    public int E(i r10) {
        CalendarDay r11 = r10.B();
        return g().indexOf(r11);
    }

    @Override // com.obric.oui.calendar.b
    public DateRangeIndex b(CalendarDay r10, CalendarDay r11) {
        return new a(r10, r11);
    }

    @Override // com.obric.oui.calendar.b
    public /* bridge */ /* synthetic */ c c(int r10) {
        return D(r10);
    }

    @Override // com.obric.oui.calendar.b
    public /* bridge */ /* synthetic */ int k(c r10) {
        return E((i) r10);
    }

    @Override // com.obric.oui.calendar.b
    public boolean n(Object r10) {
        return r10 instanceof i;
    }
}
