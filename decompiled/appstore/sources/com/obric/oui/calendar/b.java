package com.obric.oui.calendar;

import android.view.View;
import android.view.ViewGroup;
import androidx.viewpager.widget.PagerAdapter;
import com.obric.oui.calendar.format.DayFormatter;
import com.obric.oui.calendar.format.TitleFormatter;
import com.obric.oui.calendar.format.WeekDayFormatter;
import com.ttnet.org.chromium.net.NetError;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import org.threeten.bp.LocalDate;

/* JADX INFO: loaded from: classes4.dex */
public abstract class b extends PagerAdapter {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ArrayDeque f12661a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final MaterialCalendarView f12662b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final CalendarDay f12663c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public TitleFormatter f12664d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public Integer f12665e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public Integer f12666f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public Integer f12667g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public int f12668h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public CalendarDay f12669i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public CalendarDay f12670j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public DateRangeIndex f12671k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public List f12672l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public WeekDayFormatter f12673m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public DayFormatter f12674n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public DayFormatter f12675o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public List f12676p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public List f12677q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public boolean f12678r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public boolean f12679s;

    public b(MaterialCalendarView r10) {
        this.f12664d = TitleFormatter.DEFAULT;
        this.f12665e = null;
        this.f12666f = null;
        this.f12667g = null;
        this.f12668h = 4;
        this.f12669i = null;
        this.f12670j = null;
        this.f12672l = new ArrayList();
        this.f12673m = WeekDayFormatter.DEFAULT;
        DayFormatter r11 = DayFormatter.DEFAULT;
        this.f12674n = r11;
        this.f12675o = r11;
        this.f12676p = new ArrayList();
        this.f12677q = null;
        this.f12678r = true;
        this.f12662b = r10;
        this.f12663c = CalendarDay.today();
        ArrayDeque r12 = new ArrayDeque();
        this.f12661a = r12;
        r12.iterator();
        u(null, null);
    }

    public void A(WeekDayFormatter r10) {
        this.f12673m = r10;
        Iterator r11 = this.f12661a.iterator();
    L4:
        if (r11.hasNext() == false) goto L6;
        ((c) r11.next()).y(r10);
        goto L4
    }

    public void B(int r10) {
        if (r10 != 0) goto L4;
        return;
    L4:
        this.f12667g = Integer.valueOf(r10);
        Iterator r11 = this.f12661a.iterator();
    L6:
        if (r11.hasNext() == false) goto L8;
        ((c) r11.next()).z(r10);
        goto L6
    }

    public final void C() {
        int r10 = 0;
    L4:
        if (r10 >= this.f12672l.size()) goto L15;
        CalendarDay r11 = (CalendarDay) this.f12672l.get(r10);
        CalendarDay r12 = this.f12669i;
        if (r12 != null) goto L8;
    L9:
        CalendarDay r13 = this.f12670j;
        if (r13 == null) goto L14;
        if (r13.isBefore(r11) == false) goto L14;
    L13:
        this.f12672l.remove(r10);
        this.f12662b.B(r11);
        r10 = r10 - 1;
    L14:
        r10 = r10 + 1;
        goto L4
    L8:
        if (r12.isAfter(r11) == true) goto L13;
    }

    public void a() {
        this.f12672l.clear();
        m();
    }

    public abstract DateRangeIndex b(CalendarDay r10, CalendarDay r11);

    public abstract c c(int r10);

    public int d() {
        Integer r10 = this.f12666f;
        if (r10 != null) goto L6;
        return 0;
    L6:
        return r10.intValue();
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public void destroyItem(ViewGroup r10, int r11, Object r12) {
        c r13 = (c) r12;
        this.f12661a.remove(r13);
        r10.removeView(r13);
    }

    public int e(CalendarDay r10) {
        if (r10 == null) goto L4;
        CalendarDay r11 = this.f12669i;
        if (r11 != null) goto L8;
    L11:
        CalendarDay r12 = this.f12670j;
        if (r12 == null) goto L18;
        if (r10.isAfter(r12) == false) goto L18;
        return getCount() - 1;
    L18:
        return this.f12671k.indexOf(r10);
    L8:
        if (r10.isBefore(r11) == false) goto L11;
        return 0;
    L4:
        return getCount() / 2;
    }

    public CalendarDay f(int r10) {
        return this.f12671k.getItem(r10);
    }

    public DateRangeIndex g() {
        return this.f12671k;
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public int getCount() {
        return this.f12671k.getCount();
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public int getItemPosition(Object r10) {
        if (n(r10) == true) goto L5;
        return -2;
    L5:
        c r11 = (c) r10;
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
        return this.f12664d.format(f(r10));
    }

    public List h() {
        return Collections.unmodifiableList(this.f12672l);
    }

    public int i() {
        return this.f12668h;
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public Object instantiateItem(ViewGroup r10, int r11) {
        c r12 = c(r11);
        r12.setContentDescription(this.f12662b.getCalendarContentDescription());
        r12.setAlpha(0.0f);
        r12.w(this.f12678r);
        r12.y(this.f12673m);
        r12.p(this.f12674n);
        r12.q(this.f12675o);
        Integer r13 = this.f12665e;
        if (r13 == null) goto L6;
        r12.v(r13.intValue());
    L6:
        if ((r12 instanceof x) == false) goto L8;
        CalendarMode r14 = CalendarMode.WEEKS;
    L9:
        r12.n(r14);
        Integer r15 = this.f12666f;
        if (r15 == null) goto L12;
        r12.o(r15.intValue());
    L12:
        Integer r16 = this.f12667g;
        if (r16 == null) goto L15;
        r12.z(r16.intValue());
    L15:
        r12.x(this.f12668h);
        r12.t(this.f12669i);
        r12.s(this.f12670j);
        r12.u(this.f12672l);
        r10.addView(r12);
        this.f12661a.add(r12);
        r12.r(this.f12677q);
        return r12;
    L8:
        r14 = CalendarMode.MONTHS;
        goto L9
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public boolean isViewFromObject(View r10, Object r11) {
        if (r10 != r11) goto L4;
        return true;
    L4:
        return false;
    }

    public int j() {
        Integer r10 = this.f12667g;
        if (r10 != null) goto L6;
        return 0;
    L6:
        return r10.intValue();
    }

    public abstract int k(c r10);

    public void l() {
        this.f12677q = new ArrayList();
        Iterator r10 = this.f12676p.iterator();
    L4:
        if (r10.hasNext() == false) goto L8;
        DayViewDecorator r11 = (DayViewDecorator) r10.next();
        e r12 = new e();
        r11.decorate(r12);
        if (r12.f() == false) goto L4;
        this.f12677q.add(new f(r11, r12));
        goto L4
    L8:
        Iterator r13 = this.f12661a.iterator();
    L10:
        if (r13.hasNext() == false) goto L12;
        ((c) r13.next()).r(this.f12677q);
        goto L10
    }

    public final void m() {
        C();
        Iterator r10 = this.f12661a.iterator();
    L4:
        if (r10.hasNext() == false) goto L6;
        ((c) r10.next()).u(this.f12672l);
        goto L4
    }

    public abstract boolean n(Object r10);

    public b o(b r10) {
        r10.f12664d = this.f12664d;
        r10.f12665e = this.f12665e;
        r10.f12666f = this.f12666f;
        r10.f12667g = this.f12667g;
        r10.f12668h = this.f12668h;
        r10.f12669i = this.f12669i;
        r10.f12670j = this.f12670j;
        r10.f12672l = this.f12672l;
        r10.f12673m = this.f12673m;
        r10.f12674n = this.f12674n;
        r10.f12675o = this.f12675o;
        r10.f12676p = this.f12676p;
        r10.f12677q = this.f12677q;
        r10.f12678r = this.f12678r;
        return r10;
    }

    public void p(CalendarDay r10, CalendarDay r11) {
        this.f12672l.clear();
        LocalDate r12 = LocalDate.of(r10.getYear(), r10.getMonth(), r10.getDay());
        LocalDate r13 = r11.getDate();
    L4:
        if (r12.isBefore(r13) == true) goto L10;
        if (r12.equals(r13) == true) goto L10;
        m();
        return;
    L10:
        this.f12672l.add(CalendarDay.from(r12));
        r12 = r12.plusDays(1);
        goto L4
    }

    public void q(CalendarDay r10, boolean r11) {
        if (r11 == false) goto L7;
        if (this.f12672l.contains(r10) == true) goto L10;
        this.f12672l.add(r10);
        m();
        return;
    L10:
        return;
    L7:
        if (this.f12672l.contains(r10) == false) goto L12;
        this.f12672l.remove(r10);
        m();
        return;
    }

    public void r(int r10) {
        if (r10 != 0) goto L4;
        return;
    L4:
        this.f12666f = Integer.valueOf(r10);
        Iterator r11 = this.f12661a.iterator();
    L6:
        if (r11.hasNext() == false) goto L8;
        ((c) r11.next()).o(r10);
        goto L6
    }

    public void s(DayFormatter r10) {
        DayFormatter r11 = this.f12675o;
        if (r11 != this.f12674n) goto L5;
        r11 = r10;
    L5:
        this.f12675o = r11;
        this.f12674n = r10;
        Iterator r12 = this.f12661a.iterator();
    L7:
        if (r12.hasNext() == false) goto L9;
        ((c) r12.next()).p(r10);
        goto L7
    }

    public void t(DayFormatter r10) {
        this.f12675o = r10;
        Iterator r11 = this.f12661a.iterator();
    L4:
        if (r11.hasNext() == false) goto L6;
        ((c) r11.next()).q(r10);
        goto L4
    }

    public void u(CalendarDay r10, CalendarDay r11) {
        this.f12669i = r10;
        this.f12670j = r11;
        Iterator r12 = this.f12661a.iterator();
    L4:
        if (r12.hasNext() == false) goto L6;
        c r13 = (c) r12.next();
        r13.t(r10);
        r13.s(r11);
        goto L4
    L6:
        if (r10 != null) goto L8;
        r10 = CalendarDay.from(this.f12663c.getYear() + NetError.ERR_CERT_COMMON_NAME_INVALID, this.f12663c.getMonth(), this.f12663c.getDay());
    L8:
        if (r11 != null) goto L10;
        r11 = CalendarDay.from(this.f12663c.getYear() + 200, this.f12663c.getMonth(), this.f12663c.getDay());
    L10:
        this.f12671k = b(r10, r11);
        notifyDataSetChanged();
        m();
    }

    public void v(int r10) {
        this.f12665e = Integer.valueOf(r10);
        Iterator r11 = this.f12661a.iterator();
    L4:
        if (r11.hasNext() == false) goto L6;
        ((c) r11.next()).v(r10);
        goto L4
    }

    public void w(boolean r10) {
        this.f12678r = r10;
        Iterator r11 = this.f12661a.iterator();
    L4:
        if (r11.hasNext() == false) goto L6;
        ((c) r11.next()).w(this.f12678r);
        goto L4
    }

    public void x(int r10) {
        this.f12668h = r10;
        Iterator r11 = this.f12661a.iterator();
    L4:
        if (r11.hasNext() == false) goto L6;
        ((c) r11.next()).x(r10);
        goto L4
    }

    public void y(boolean r10) {
        this.f12679s = r10;
    }

    public void z(TitleFormatter r10) {
        if (r10 != null) goto L4;
        r10 = TitleFormatter.DEFAULT;
    L4:
        this.f12664d = r10;
    }
}
