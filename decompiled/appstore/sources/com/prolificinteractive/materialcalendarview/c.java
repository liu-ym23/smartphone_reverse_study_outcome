package com.prolificinteractive.materialcalendarview;

import android.view.View;
import android.view.ViewGroup;
import androidx.viewpager.widget.PagerAdapter;
import com.prolificinteractive.materialcalendarview.format.DayFormatter;
import com.prolificinteractive.materialcalendarview.format.TitleFormatter;
import com.prolificinteractive.materialcalendarview.format.WeekDayFormatter;
import com.ttnet.org.chromium.net.NetError;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import org.threeten.bp.LocalDate;

/* JADX INFO: loaded from: classes4.dex */
public abstract class c extends PagerAdapter {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ArrayDeque f17758a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final MaterialCalendarView f17759b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final CalendarDay f17760c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public TitleFormatter f17761d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public Integer f17762e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public Integer f17763f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public Integer f17764g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public int f17765h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public CalendarDay f17766i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public CalendarDay f17767j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public DateRangeIndex f17768k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public List f17769l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public WeekDayFormatter f17770m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public DayFormatter f17771n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public DayFormatter f17772o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public List f17773p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public List f17774q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public boolean f17775r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public boolean f17776s;

    public c(MaterialCalendarView r10) {
        this.f17761d = TitleFormatter.DEFAULT;
        this.f17762e = null;
        this.f17763f = null;
        this.f17764g = null;
        this.f17765h = 4;
        this.f17766i = null;
        this.f17767j = null;
        this.f17769l = new ArrayList();
        this.f17770m = WeekDayFormatter.DEFAULT;
        DayFormatter r11 = DayFormatter.DEFAULT;
        this.f17771n = r11;
        this.f17772o = r11;
        this.f17773p = new ArrayList();
        this.f17774q = null;
        this.f17775r = true;
        this.f17759b = r10;
        this.f17760c = CalendarDay.today();
        ArrayDeque r12 = new ArrayDeque();
        this.f17758a = r12;
        r12.iterator();
        u(null, null);
    }

    private void C() {
        int r10 = 0;
    L4:
        if (r10 >= this.f17769l.size()) goto L15;
        CalendarDay r11 = (CalendarDay) this.f17769l.get(r10);
        CalendarDay r12 = this.f17766i;
        if (r12 != null) goto L8;
    L9:
        CalendarDay r13 = this.f17767j;
        if (r13 == null) goto L14;
        if (r13.isBefore(r11) == false) goto L14;
    L13:
        this.f17769l.remove(r10);
        this.f17759b.D(r11);
        r10 = r10 - 1;
    L14:
        r10 = r10 + 1;
        goto L4
    L8:
        if (r12.isAfter(r11) == true) goto L13;
    }

    private void m() {
        C();
        Iterator r10 = this.f17758a.iterator();
    L4:
        if (r10.hasNext() == false) goto L6;
        ((d) r10.next()).r(this.f17769l);
        goto L4
    }

    public void A(WeekDayFormatter r10) {
        this.f17770m = r10;
        Iterator r11 = this.f17758a.iterator();
    L4:
        if (r11.hasNext() == false) goto L6;
        ((d) r11.next()).v(r10);
        goto L4
    }

    public void B(int r10) {
        if (r10 != 0) goto L4;
        return;
    L4:
        this.f17764g = Integer.valueOf(r10);
        Iterator r11 = this.f17758a.iterator();
    L6:
        if (r11.hasNext() == false) goto L8;
        ((d) r11.next()).w(r10);
        goto L6
    }

    public void a() {
        this.f17769l.clear();
        m();
    }

    public abstract DateRangeIndex b(CalendarDay r10, CalendarDay r11);

    public abstract d c(int r10);

    public int d() {
        Integer r10 = this.f17763f;
        if (r10 != null) goto L6;
        return 0;
    L6:
        return r10.intValue();
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public void destroyItem(ViewGroup r10, int r11, Object r12) {
        d r13 = (d) r12;
        this.f17758a.remove(r13);
        r10.removeView(r13);
    }

    public int e(CalendarDay r10) {
        if (r10 == null) goto L4;
        CalendarDay r11 = this.f17766i;
        if (r11 != null) goto L8;
    L11:
        CalendarDay r12 = this.f17767j;
        if (r12 == null) goto L18;
        if (r10.isAfter(r12) == false) goto L18;
        return getCount() - 1;
    L18:
        return this.f17768k.indexOf(r10);
    L8:
        if (r10.isBefore(r11) == false) goto L11;
        return 0;
    L4:
        return getCount() / 2;
    }

    public CalendarDay f(int r10) {
        return this.f17768k.getItem(r10);
    }

    public DateRangeIndex g() {
        return this.f17768k;
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public int getCount() {
        return this.f17768k.getCount();
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public int getItemPosition(Object r10) {
        if (n(r10) == true) goto L5;
        return -2;
    L5:
        d r11 = (d) r10;
        if (r11.g() != null) goto L8;
        return -2;
    L8:
        int r12 = k(r11);
        if (r12 >= 0) goto L11;
        return -2;
    L11:
        return r12;
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public CharSequence getPageTitle(int r10) {
        return this.f17761d.format(f(r10));
    }

    public List h() {
        return Collections.unmodifiableList(this.f17769l);
    }

    public int i() {
        return this.f17765h;
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public Object instantiateItem(ViewGroup r10, int r11) {
        d r12 = c(r11);
        r12.setContentDescription(this.f17759b.getCalendarContentDescription());
        r12.setAlpha(0.0f);
        r12.t(this.f17775r);
        r12.v(this.f17770m);
        r12.m(this.f17771n);
        r12.n(this.f17772o);
        Integer r13 = this.f17762e;
        if (r13 == null) goto L5;
        r12.s(r13.intValue());
    L5:
        Integer r14 = this.f17763f;
        if (r14 == null) goto L8;
        r12.l(r14.intValue());
    L8:
        Integer r15 = this.f17764g;
        if (r15 == null) goto L11;
        r12.w(r15.intValue());
    L11:
        r12.u(this.f17765h);
        r12.q(this.f17766i);
        r12.p(this.f17767j);
        r12.r(this.f17769l);
        r10.addView(r12);
        this.f17758a.add(r12);
        r12.o(this.f17774q);
        return r12;
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public boolean isViewFromObject(View r10, Object r11) {
        if (r10 != r11) goto L4;
        return true;
    L4:
        return false;
    }

    public int j() {
        Integer r10 = this.f17764g;
        if (r10 != null) goto L6;
        return 0;
    L6:
        return r10.intValue();
    }

    public abstract int k(d r10);

    public void l() {
        this.f17774q = new ArrayList();
        Iterator r10 = this.f17773p.iterator();
    L4:
        if (r10.hasNext() == false) goto L8;
        DayViewDecorator r11 = (DayViewDecorator) r10.next();
        f r12 = new f();
        r11.decorate(r12);
        if (r12.f() == false) goto L4;
        this.f17774q.add(new g(r11, r12));
        goto L4
    L8:
        Iterator r13 = this.f17758a.iterator();
    L10:
        if (r13.hasNext() == false) goto L12;
        ((d) r13.next()).o(this.f17774q);
        goto L10
    }

    public abstract boolean n(Object r10);

    public c o(c r10) {
        r10.f17761d = this.f17761d;
        r10.f17762e = this.f17762e;
        r10.f17763f = this.f17763f;
        r10.f17764g = this.f17764g;
        r10.f17765h = this.f17765h;
        r10.f17766i = this.f17766i;
        r10.f17767j = this.f17767j;
        r10.f17769l = this.f17769l;
        r10.f17770m = this.f17770m;
        r10.f17771n = this.f17771n;
        r10.f17772o = this.f17772o;
        r10.f17773p = this.f17773p;
        r10.f17774q = this.f17774q;
        r10.f17775r = this.f17775r;
        return r10;
    }

    public void p(CalendarDay r10, CalendarDay r11) {
        this.f17769l.clear();
        LocalDate r12 = LocalDate.of(r10.getYear(), r10.getMonth(), r10.getDay());
        LocalDate r13 = r11.getDate();
    L4:
        if (r12.isBefore(r13) == true) goto L10;
        if (r12.equals(r13) == true) goto L10;
        m();
        return;
    L10:
        this.f17769l.add(CalendarDay.from(r12));
        r12 = r12.plusDays(1);
        goto L4
    }

    public void q(CalendarDay r10, boolean r11) {
        if (r11 == false) goto L7;
        if (this.f17769l.contains(r10) == true) goto L10;
        this.f17769l.add(r10);
        m();
        return;
    L10:
        return;
    L7:
        if (this.f17769l.contains(r10) == false) goto L12;
        this.f17769l.remove(r10);
        m();
        return;
    }

    public void r(int r10) {
        if (r10 != 0) goto L4;
        return;
    L4:
        this.f17763f = Integer.valueOf(r10);
        Iterator r11 = this.f17758a.iterator();
    L6:
        if (r11.hasNext() == false) goto L8;
        ((d) r11.next()).l(r10);
        goto L6
    }

    public void s(DayFormatter r10) {
        DayFormatter r11 = this.f17772o;
        if (r11 != this.f17771n) goto L5;
        r11 = r10;
    L5:
        this.f17772o = r11;
        this.f17771n = r10;
        Iterator r12 = this.f17758a.iterator();
    L7:
        if (r12.hasNext() == false) goto L9;
        ((d) r12.next()).m(r10);
        goto L7
    }

    public void t(DayFormatter r10) {
        this.f17772o = r10;
        Iterator r11 = this.f17758a.iterator();
    L4:
        if (r11.hasNext() == false) goto L6;
        ((d) r11.next()).n(r10);
        goto L4
    }

    public void u(CalendarDay r10, CalendarDay r11) {
        this.f17766i = r10;
        this.f17767j = r11;
        Iterator r12 = this.f17758a.iterator();
    L4:
        if (r12.hasNext() == false) goto L6;
        d r13 = (d) r12.next();
        r13.q(r10);
        r13.p(r11);
        goto L4
    L6:
        if (r10 != null) goto L8;
        r10 = CalendarDay.from(this.f17760c.getYear() + NetError.ERR_CERT_COMMON_NAME_INVALID, this.f17760c.getMonth(), this.f17760c.getDay());
    L8:
        if (r11 != null) goto L10;
        r11 = CalendarDay.from(this.f17760c.getYear() + 200, this.f17760c.getMonth(), this.f17760c.getDay());
    L10:
        this.f17768k = b(r10, r11);
        notifyDataSetChanged();
        m();
    }

    public void v(int r10) {
        this.f17762e = Integer.valueOf(r10);
        Iterator r11 = this.f17758a.iterator();
    L4:
        if (r11.hasNext() == false) goto L6;
        ((d) r11.next()).s(r10);
        goto L4
    }

    public void w(boolean r10) {
        this.f17775r = r10;
        Iterator r11 = this.f17758a.iterator();
    L4:
        if (r11.hasNext() == false) goto L6;
        ((d) r11.next()).t(this.f17775r);
        goto L4
    }

    public void x(int r10) {
        this.f17765h = r10;
        Iterator r11 = this.f17758a.iterator();
    L4:
        if (r11.hasNext() == false) goto L6;
        ((d) r11.next()).u(r10);
        goto L4
    }

    public void y(boolean r10) {
        this.f17776s = r10;
    }

    public void z(TitleFormatter r10) {
        if (r10 != null) goto L4;
        r10 = TitleFormatter.DEFAULT;
    L4:
        this.f17761d = r10;
    }
}
