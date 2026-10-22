package com.prolificinteractive.materialcalendarview;

import org.threeten.bp.Period;

/* JADX INFO: loaded from: classes4.dex */
public class j extends c {

    public static class a implements DateRangeIndex {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final CalendarDay f17808a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final int f17809b;

        public a(CalendarDay r10, CalendarDay r11) {
            this.f17808a = CalendarDay.from(r10.getYear(), r10.getMonth(), 1);
            this.f17809b = indexOf(r11) + 1;
        }

        @Override // com.prolificinteractive.materialcalendarview.DateRangeIndex
        public int getCount() {
            return this.f17809b;
        }

        @Override // com.prolificinteractive.materialcalendarview.DateRangeIndex
        public CalendarDay getItem(int r10) {
            return CalendarDay.from(this.f17808a.getDate().plusMonths(r10));
        }

        @Override // com.prolificinteractive.materialcalendarview.DateRangeIndex
        public int indexOf(CalendarDay r10) {
            return (int) Period.between(this.f17808a.getDate().withDayOfMonth(1), r10.getDate().withDayOfMonth(1)).toTotalMonths();
        }
    }

    public j(MaterialCalendarView r10) {
        super(r10);
    }

    public k D(int r10) {
        return new k(this.f17759b, f(r10), this.f17759b.getFirstDayOfWeek(), this.f17776s);
    }

    public int E(k r10) {
        CalendarDay r11 = r10.y();
        return g().indexOf(r11);
    }

    @Override // com.prolificinteractive.materialcalendarview.c
    public DateRangeIndex b(CalendarDay r10, CalendarDay r11) {
        return new a(r10, r11);
    }

    @Override // com.prolificinteractive.materialcalendarview.c
    public /* bridge */ /* synthetic */ d c(int r10) {
        return D(r10);
    }

    @Override // com.prolificinteractive.materialcalendarview.c
    public /* bridge */ /* synthetic */ int k(d r10) {
        return E((k) r10);
    }

    @Override // com.prolificinteractive.materialcalendarview.c
    public boolean n(Object r10) {
        return r10 instanceof k;
    }
}
