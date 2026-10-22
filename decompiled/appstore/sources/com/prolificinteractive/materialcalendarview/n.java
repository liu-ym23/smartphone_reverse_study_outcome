package com.prolificinteractive.materialcalendarview;

import android.view.View;
import android.view.ViewGroup;
import com.prolificinteractive.materialcalendarview.format.DayFormatter;
import com.prolificinteractive.materialcalendarview.format.TitleFormatter;
import com.prolificinteractive.materialcalendarview.format.WeekDayFormatter;
import java.util.List;
import org.threeten.bp.DayOfWeek;
import org.threeten.bp.LocalDate;
import org.threeten.bp.temporal.ChronoUnit;
import org.threeten.bp.temporal.WeekFields;

/* JADX INFO: loaded from: classes4.dex */
public class n extends c {

    public static class a implements DateRangeIndex {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final CalendarDay f17824a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final int f17825b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final DayOfWeek f17826c;

        public a(CalendarDay r10, CalendarDay r11, DayOfWeek r12) {
            this.f17826c = r12;
            this.f17824a = a(r10);
            this.f17825b = indexOf(r11) + 1;
        }

        public final CalendarDay a(CalendarDay r10) {
            return CalendarDay.from(r10.getDate().with(WeekFields.of(this.f17826c, 1).dayOfWeek(), 1));
        }

        @Override // com.prolificinteractive.materialcalendarview.DateRangeIndex
        public int getCount() {
            return this.f17825b;
        }

        @Override // com.prolificinteractive.materialcalendarview.DateRangeIndex
        public CalendarDay getItem(int r10) {
            return CalendarDay.from(this.f17824a.getDate().plusWeeks(r10));
        }

        @Override // com.prolificinteractive.materialcalendarview.DateRangeIndex
        public int indexOf(CalendarDay r10) {
            WeekFields r11 = WeekFields.of(this.f17826c, 1);
            LocalDate r12 = r10.getDate().with(r11.dayOfWeek(), 1);
            return (int) ChronoUnit.WEEKS.between(this.f17824a.getDate(), r12);
        }
    }

    public n(MaterialCalendarView r10) {
        super(r10);
    }

    @Override // com.prolificinteractive.materialcalendarview.c
    public /* bridge */ /* synthetic */ void A(WeekDayFormatter r10) {
        super.A(r10);
    }

    @Override // com.prolificinteractive.materialcalendarview.c
    public /* bridge */ /* synthetic */ void B(int r10) {
        super.B(r10);
    }

    public o D(int r10) {
        return new o(this.f17759b, f(r10), this.f17759b.getFirstDayOfWeek(), this.f17776s);
    }

    public int E(o r10) {
        CalendarDay r11 = r10.g();
        return g().indexOf(r11);
    }

    @Override // com.prolificinteractive.materialcalendarview.c
    public /* bridge */ /* synthetic */ void a() {
        super.a();
    }

    @Override // com.prolificinteractive.materialcalendarview.c
    public DateRangeIndex b(CalendarDay r10, CalendarDay r11) {
        return new a(r10, r11, this.f17759b.getFirstDayOfWeek());
    }

    @Override // com.prolificinteractive.materialcalendarview.c
    public /* bridge */ /* synthetic */ d c(int r10) {
        return D(r10);
    }

    @Override // com.prolificinteractive.materialcalendarview.c, androidx.viewpager.widget.PagerAdapter
    public /* bridge */ /* synthetic */ void destroyItem(ViewGroup r10, int r11, Object r12) {
        super.destroyItem(r10, r11, r12);
    }

    @Override // com.prolificinteractive.materialcalendarview.c
    public /* bridge */ /* synthetic */ int e(CalendarDay r10) {
        return super.e(r10);
    }

    @Override // com.prolificinteractive.materialcalendarview.c
    public /* bridge */ /* synthetic */ CalendarDay f(int r10) {
        return super.f(r10);
    }

    @Override // com.prolificinteractive.materialcalendarview.c
    public /* bridge */ /* synthetic */ DateRangeIndex g() {
        return super.g();
    }

    @Override // com.prolificinteractive.materialcalendarview.c, androidx.viewpager.widget.PagerAdapter
    public /* bridge */ /* synthetic */ int getCount() {
        return super.getCount();
    }

    @Override // com.prolificinteractive.materialcalendarview.c, androidx.viewpager.widget.PagerAdapter
    public /* bridge */ /* synthetic */ int getItemPosition(Object r10) {
        return super.getItemPosition(r10);
    }

    @Override // com.prolificinteractive.materialcalendarview.c, androidx.viewpager.widget.PagerAdapter
    public /* bridge */ /* synthetic */ CharSequence getPageTitle(int r10) {
        return super.getPageTitle(r10);
    }

    @Override // com.prolificinteractive.materialcalendarview.c
    public /* bridge */ /* synthetic */ List h() {
        return super.h();
    }

    @Override // com.prolificinteractive.materialcalendarview.c
    public /* bridge */ /* synthetic */ int i() {
        return super.i();
    }

    @Override // com.prolificinteractive.materialcalendarview.c, androidx.viewpager.widget.PagerAdapter
    public /* bridge */ /* synthetic */ Object instantiateItem(ViewGroup r10, int r11) {
        return super.instantiateItem(r10, r11);
    }

    @Override // com.prolificinteractive.materialcalendarview.c, androidx.viewpager.widget.PagerAdapter
    public /* bridge */ /* synthetic */ boolean isViewFromObject(View r10, Object r11) {
        return super.isViewFromObject(r10, r11);
    }

    @Override // com.prolificinteractive.materialcalendarview.c
    public /* bridge */ /* synthetic */ int k(d r10) {
        return E((o) r10);
    }

    @Override // com.prolificinteractive.materialcalendarview.c
    public /* bridge */ /* synthetic */ void l() {
        super.l();
    }

    @Override // com.prolificinteractive.materialcalendarview.c
    public boolean n(Object r10) {
        return r10 instanceof o;
    }

    @Override // com.prolificinteractive.materialcalendarview.c
    public /* bridge */ /* synthetic */ c o(c r10) {
        return super.o(r10);
    }

    @Override // com.prolificinteractive.materialcalendarview.c
    public /* bridge */ /* synthetic */ void p(CalendarDay r10, CalendarDay r11) {
        super.p(r10, r11);
    }

    @Override // com.prolificinteractive.materialcalendarview.c
    public /* bridge */ /* synthetic */ void q(CalendarDay r10, boolean r11) {
        super.q(r10, r11);
    }

    @Override // com.prolificinteractive.materialcalendarview.c
    public /* bridge */ /* synthetic */ void r(int r10) {
        super.r(r10);
    }

    @Override // com.prolificinteractive.materialcalendarview.c
    public /* bridge */ /* synthetic */ void s(DayFormatter r10) {
        super.s(r10);
    }

    @Override // com.prolificinteractive.materialcalendarview.c
    public /* bridge */ /* synthetic */ void t(DayFormatter r10) {
        super.t(r10);
    }

    @Override // com.prolificinteractive.materialcalendarview.c
    public /* bridge */ /* synthetic */ void u(CalendarDay r10, CalendarDay r11) {
        super.u(r10, r11);
    }

    @Override // com.prolificinteractive.materialcalendarview.c
    public /* bridge */ /* synthetic */ void v(int r10) {
        super.v(r10);
    }

    @Override // com.prolificinteractive.materialcalendarview.c
    public /* bridge */ /* synthetic */ void w(boolean r10) {
        super.w(r10);
    }

    @Override // com.prolificinteractive.materialcalendarview.c
    public /* bridge */ /* synthetic */ void x(int r10) {
        super.x(r10);
    }

    @Override // com.prolificinteractive.materialcalendarview.c
    public /* bridge */ /* synthetic */ void y(boolean r10) {
        super.y(r10);
    }

    @Override // com.prolificinteractive.materialcalendarview.c
    public /* bridge */ /* synthetic */ void z(TitleFormatter r10) {
        super.z(r10);
    }
}
