package com.obric.oui.calendar;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import org.threeten.bp.Period;

/* JADX INFO: compiled from: MonthPagerAdapter.java */
/* JADX INFO: loaded from: classes4.dex */
class h extends b<MonthView> {

    /* JADX INFO: compiled from: MonthPagerAdapter.java */
    public static class a implements c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final CalendarDay f34386a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final int f34387b;

        public a(CalendarDay r3, CalendarDay r4) {
            this.f34386a = CalendarDay.from(r3.getYear(), r3.getMonth(), 1);
            this.f34387b = a(r4) + 1;
        }

        @Override // com.obric.oui.calendar.c
        public int a() {
            return this.f34387b;
        }

        @Override // com.obric.oui.calendar.c
        public int a(CalendarDay r2) {
            return (int) Period.between(this.f34386a.getDate().withDayOfMonth(1), r2.getDate().withDayOfMonth(1)).toTotalMonths();
        }

        @Override // com.obric.oui.calendar.c
        public CalendarDay a(int r3) {
            return CalendarDay.from(this.f34386a.getDate().plusMonths(r3));
        }
    }

    @Override // com.obric.oui.calendar.b
    public /* synthetic */ int a(CalendarPagerView r3) {
        return a((MonthView) ZeusTransformUtils.preCheckCast(r3, MonthView.class, "com.obric.aiagent.plugin"));
    }

    @Override // com.obric.oui.calendar.b
    public /* synthetic */ CalendarPagerView c(int r1) {
        return i(r1);
    }

    h(MaterialCalendarView r1) {
        super(r1);
    }

    public MonthView i(int r4) {
        return new MonthView(this.f34373a, h(r4), this.f34373a.getFirstDayOfWeek(), this.f34374b);
    }

    public int a(MonthView r1) {
        CalendarDay r2 = r1.getMonth();
        return f().a(r2);
    }

    @Override // com.obric.oui.calendar.b
    public boolean b(Object r1) {
        return ZeusTransformUtils.instanceOf(r1, MonthView.class);
    }

    @Override // com.obric.oui.calendar.b
    public c a(CalendarDay r1, CalendarDay r2) {
        return new a(r1, r2);
    }
}
