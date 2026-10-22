package com.obric.oui.calendar;

import android.view.View;
import android.view.ViewGroup;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.List;
import org.threeten.bp.DayOfWeek;
import org.threeten.bp.LocalDate;
import org.threeten.bp.temporal.ChronoUnit;
import org.threeten.bp.temporal.WeekFields;

/* JADX INFO: compiled from: WeekPagerAdapter.java */
/* JADX INFO: loaded from: classes4.dex */
public class o extends b<WeekView> {

    /* JADX INFO: compiled from: WeekPagerAdapter.java */
    public static class a implements c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final CalendarDay f34396a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final int f34397b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final DayOfWeek f34398c;

        public a(CalendarDay r1, CalendarDay r2, DayOfWeek r3) {
            this.f34398c = r3;
            this.f34396a = b(r1);
            this.f34397b = a(r2) + 1;
        }

        @Override // com.obric.oui.calendar.c
        public int a() {
            return this.f34397b;
        }

        @Override // com.obric.oui.calendar.c
        public int a(CalendarDay r4) {
            WeekFields r0 = WeekFields.of(this.f34398c, 1);
            LocalDate r5 = r4.getDate().with(r0.dayOfWeek(), 1);
            return (int) ChronoUnit.WEEKS.between(this.f34396a.getDate(), r5);
        }

        @Override // com.obric.oui.calendar.c
        public CalendarDay a(int r3) {
            return CalendarDay.from(this.f34396a.getDate().plusWeeks(r3));
        }

        private CalendarDay b(CalendarDay r3) {
            return CalendarDay.from(r3.getDate().with(WeekFields.of(this.f34398c, 1).dayOfWeek(), 1));
        }
    }

    @Override // com.obric.oui.calendar.b, androidx.viewpager.widget.a
    public /* bridge */ /* synthetic */ int a() {
        return super.a();
    }

    @Override // com.obric.oui.calendar.b
    public /* bridge */ /* synthetic */ int a(CalendarDay r1) {
        return super.a(r1);
    }

    @Override // com.obric.oui.calendar.b
    public /* synthetic */ int a(CalendarPagerView r3) {
        return a((WeekView) ZeusTransformUtils.preCheckCast(r3, WeekView.class, "com.obric.aiagent.plugin"));
    }

    @Override // com.obric.oui.calendar.b, androidx.viewpager.widget.a
    public /* bridge */ /* synthetic */ int a(Object r1) {
        return super.a(r1);
    }

    @Override // com.obric.oui.calendar.b
    public /* bridge */ /* synthetic */ b a(b r1) {
        return super.a(r1);
    }

    @Override // com.obric.oui.calendar.b, androidx.viewpager.widget.a
    public /* bridge */ /* synthetic */ CharSequence a(int r1) {
        return super.a(r1);
    }

    @Override // com.obric.oui.calendar.b, androidx.viewpager.widget.a
    public /* bridge */ /* synthetic */ Object a(ViewGroup r1, int r2) {
        return super.a(r1, r2);
    }

    @Override // com.obric.oui.calendar.b, androidx.viewpager.widget.a
    public /* bridge */ /* synthetic */ void a(ViewGroup r1, int r2, Object r3) {
        super.a(r1, r2, r3);
    }

    @Override // com.obric.oui.calendar.b
    public /* bridge */ /* synthetic */ void a(CalendarDay r1, boolean r2) {
        super.a(r1, r2);
    }

    @Override // com.obric.oui.calendar.b
    public /* synthetic */ void a(com.obric.oui.calendar.a.e r3) {
        super.a((com.obric.oui.calendar.a.e) ZeusTransformUtils.wrapperContextForParams(r3, com.obric.oui.calendar.a.e.class, "com.obric.aiagent.plugin"));
    }

    @Override // com.obric.oui.calendar.b
    public /* synthetic */ void a(com.obric.oui.calendar.a.g r3) {
        super.a((com.obric.oui.calendar.a.g) ZeusTransformUtils.wrapperContextForParams(r3, com.obric.oui.calendar.a.g.class, "com.obric.aiagent.plugin"));
    }

    @Override // com.obric.oui.calendar.b
    public /* synthetic */ void a(com.obric.oui.calendar.a.h r3) {
        super.a((com.obric.oui.calendar.a.h) ZeusTransformUtils.wrapperContextForParams(r3, com.obric.oui.calendar.a.h.class, "com.obric.aiagent.plugin"));
    }

    @Override // com.obric.oui.calendar.b
    public /* synthetic */ void a(List r3) {
        super.a((List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.aiagent.plugin"));
    }

    @Override // com.obric.oui.calendar.b
    public /* bridge */ /* synthetic */ void a(boolean r1) {
        super.a(r1);
    }

    @Override // com.obric.oui.calendar.b, androidx.viewpager.widget.a
    public /* bridge */ /* synthetic */ boolean a(View r1, Object r2) {
        return super.a(r1, r2);
    }

    @Override // com.obric.oui.calendar.b
    public /* bridge */ /* synthetic */ void b(CalendarDay r1, CalendarDay r2) {
        super.b(r1, r2);
    }

    @Override // com.obric.oui.calendar.b
    public /* synthetic */ void b(com.obric.oui.calendar.a.e r3) {
        super.b((com.obric.oui.calendar.a.e) ZeusTransformUtils.wrapperContextForParams(r3, com.obric.oui.calendar.a.e.class, "com.obric.aiagent.plugin"));
    }

    @Override // com.obric.oui.calendar.b
    public /* bridge */ /* synthetic */ void b(boolean r1) {
        super.b(r1);
    }

    @Override // com.obric.oui.calendar.b
    public /* synthetic */ CalendarPagerView c(int r1) {
        return i(r1);
    }

    @Override // com.obric.oui.calendar.b
    public /* bridge */ /* synthetic */ void c(CalendarDay r1, CalendarDay r2) {
        super.c(r1, r2);
    }

    @Override // com.obric.oui.calendar.b
    public /* bridge */ /* synthetic */ void d() {
        super.d();
    }

    @Override // com.obric.oui.calendar.b
    public /* bridge */ /* synthetic */ void d(int r1) {
        super.d(r1);
    }

    @Override // com.obric.oui.calendar.b
    public /* bridge */ /* synthetic */ int e() {
        return super.e();
    }

    @Override // com.obric.oui.calendar.b
    public /* bridge */ /* synthetic */ void e(int r1) {
        super.e(r1);
    }

    @Override // com.obric.oui.calendar.b
    public /* bridge */ /* synthetic */ c f() {
        return super.f();
    }

    @Override // com.obric.oui.calendar.b
    public /* bridge */ /* synthetic */ void f(int r1) {
        super.f(r1);
    }

    @Override // com.obric.oui.calendar.b
    public /* bridge */ /* synthetic */ void g() {
        super.g();
    }

    @Override // com.obric.oui.calendar.b
    public /* bridge */ /* synthetic */ void g(int r1) {
        super.g(r1);
    }

    @Override // com.obric.oui.calendar.b
    public /* bridge */ /* synthetic */ CalendarDay h(int r1) {
        return super.h(r1);
    }

    @Override // com.obric.oui.calendar.b
    public /* bridge */ /* synthetic */ List h() {
        return super.h();
    }

    public o(MaterialCalendarView r1) {
        super(r1);
    }

    public WeekView i(int r4) {
        return new WeekView(this.f34373a, h(r4), this.f34373a.getFirstDayOfWeek(), this.f34374b);
    }

    public int a(WeekView r1) {
        CalendarDay r2 = r1.getFirstViewDay();
        return f().a(r2);
    }

    @Override // com.obric.oui.calendar.b
    public boolean b(Object r1) {
        return ZeusTransformUtils.instanceOf(r1, WeekView.class);
    }

    @Override // com.obric.oui.calendar.b
    public c a(CalendarDay r2, CalendarDay r3) {
        return new a(r2, r3, this.f34373a.getFirstDayOfWeek());
    }
}
