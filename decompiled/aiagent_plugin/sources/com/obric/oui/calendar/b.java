package com.obric.oui.calendar;

import android.view.View;
import android.view.ViewGroup;
import com.obric.aikernel.core.data.IdlErrors;
import com.obric.oui.calendar.CalendarPagerView;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import org.threeten.bp.LocalDate;

/* JADX INFO: compiled from: CalendarPagerAdapter.java */
/* JADX INFO: loaded from: classes4.dex */
abstract class b<V extends CalendarPagerView> extends androidx.viewpager.widget.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    protected final MaterialCalendarView f34373a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    boolean f34374b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final ArrayDeque<V> f34375c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final CalendarDay f34376d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private com.obric.oui.calendar.a.g f34377e;
    private Integer f;
    private Integer g;
    private Integer h;
    private int i;
    private CalendarDay j;
    private CalendarDay k;
    private c l;
    private List<CalendarDay> m;
    private com.obric.oui.calendar.a.h n;
    private com.obric.oui.calendar.a.e o;
    private com.obric.oui.calendar.a.e p;
    private List<d> q;
    private List<f> r;
    private boolean s;

    public abstract int a(V r1);

    public abstract c a(CalendarDay r1, CalendarDay r2);

    @Override // androidx.viewpager.widget.a
    public boolean a(View r1, Object r2) {
        if (r1 != r2) goto L4;
        return true;
    L4:
        return false;
    }

    public abstract boolean b(Object r1);

    public abstract V c(int r1);

    b(MaterialCalendarView r3) {
        this.f34377e = com.obric.oui.calendar.a.g.f34371a;
        this.f = null;
        this.g = null;
        this.h = null;
        this.i = 4;
        this.j = null;
        this.k = null;
        this.m = new ArrayList();
        this.n = com.obric.oui.calendar.a.h.f34372a;
        com.obric.oui.calendar.a.e r1 = com.obric.oui.calendar.a.e.f34369a;
        this.o = r1;
        this.p = r1;
        this.q = new ArrayList();
        this.r = null;
        this.s = true;
        this.f34373a = r3;
        this.f34376d = CalendarDay.today();
        ArrayDeque<V> r4 = new ArrayDeque();
        this.f34375c = r4;
        r4.iterator();
        b(null, null);
    }

    public void a(List<d> r3) {
        this.q = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.aiagent.plugin");
        d();
    }

    public void d() {
        this.r = new ArrayList();
        Iterator<d> r0 = this.q.iterator();
    L4:
        if (r0.hasNext() == false) goto L8;
        d r1 = (d) ZeusTransformUtils.preCheckCast(r0.next(), d.class, "com.obric.aiagent.plugin");
        e r2 = new e();
        r1.a(r2);
        if (r2.b() == false) goto L4;
        this.r.add(new f(r1, r2));
        goto L4
    L8:
        Iterator<V> r3 = this.f34375c.iterator();
    L10:
        if (r3.hasNext() == false) goto L12;
        ((CalendarPagerView) ZeusTransformUtils.preCheckCast(r3.next(), CalendarPagerView.class, "com.obric.aiagent.plugin")).setDayViewDecorators(this.r);
        goto L10
    }

    @Override // androidx.viewpager.widget.a
    public int a() {
        return this.l.a();
    }

    @Override // androidx.viewpager.widget.a
    public CharSequence a(int r2) {
        return this.f34377e.a(h(r2));
    }

    public b<?> a(b<?> r2) {
        r2.f34377e = this.f34377e;
        r2.f = this.f;
        r2.g = this.g;
        r2.h = this.h;
        r2.i = this.i;
        r2.j = this.j;
        r2.k = this.k;
        r2.m = this.m;
        r2.n = this.n;
        r2.o = this.o;
        r2.p = this.p;
        r2.q = this.q;
        r2.r = this.r;
        r2.s = this.s;
        return r2;
    }

    public int a(CalendarDay r2) {
        if (r2 == null) goto L4;
        CalendarDay r0 = this.j;
        if (r0 != null) goto L8;
    L11:
        CalendarDay r1 = this.k;
        if (r1 == null) goto L18;
        if (r2.isAfter(r1) == false) goto L18;
        return a() - 1;
    L18:
        return this.l.a(r2);
    L8:
        if (r2.isBefore(r0) == false) goto L11;
        return 0;
    L4:
        return a() / 2;
    }

    @Override // androidx.viewpager.widget.a
    public int a(Object r4) {
        if (b(r4) == true) goto L6;
        return -2;
    L6:
        if (((CalendarPagerView) ZeusTransformUtils.preCheckCast(r4, CalendarPagerView.class, "com.obric.aiagent.plugin")).getFirstViewDay() != null) goto L8;
        return -2;
    L8:
        int r3 = a((CalendarPagerView) ZeusTransformUtils.preCheckCast(r4, CalendarPagerView.class, "com.obric.aiagent.plugin"));
        if (r3 >= 0) goto L11;
        return -2;
    L11:
        return r3;
    }

    @Override // androidx.viewpager.widget.a
    public Object a(ViewGroup r2, int r3) {
        CalendarPagerView r4 = c(r3);
        r4.setContentDescription(this.f34373a.getCalendarContentDescription());
        r4.setAlpha(0.0f);
        r4.setSelectionEnabled(this.s);
        r4.setWeekDayFormatter(this.n);
        r4.setDayFormatter(this.o);
        r4.setDayFormatterContentDescription(this.p);
        Integer r0 = this.f;
        if (r0 == null) goto L6;
        r4.setSelectionColor(r0.intValue());
    L6:
        if (ZeusTransformUtils.instanceOf(r4, WeekView.class) == false) goto L8;
        a r1 = a.f34363b;
    L9:
        r4.setCalendarMode(r1);
        Integer r5 = this.g;
        if (r5 == null) goto L12;
        r4.setDateTextAppearance(r5.intValue());
    L12:
        Integer r6 = this.h;
        if (r6 == null) goto L15;
        r4.setWeekDayTextAppearance(r6.intValue());
    L15:
        r4.setShowOtherDates(this.i);
        r4.setMinimumDate(this.j);
        r4.setMaximumDate(this.k);
        r4.setSelectedDates(this.m);
        r2.addView(r4);
        this.f34375c.add((V) r4);
        r4.setDayViewDecorators(this.r);
        return r4;
    L8:
        r1 = a.f34362a;
        goto L9
    }

    public void a(boolean r1) {
        this.f34374b = r1;
    }

    public void b(boolean r4) {
        this.s = r4;
        Iterator<V> r5 = this.f34375c.iterator();
    L4:
        if (r5.hasNext() == false) goto L6;
        ((CalendarPagerView) ZeusTransformUtils.preCheckCast(r5.next(), CalendarPagerView.class, "com.obric.aiagent.plugin")).setSelectionEnabled(this.s);
        goto L4
    }

    @Override // androidx.viewpager.widget.a
    public void a(ViewGroup r2, int r3, Object r4) {
        CalendarPagerView r5 = (CalendarPagerView) ZeusTransformUtils.preCheckCast(r4, CalendarPagerView.class, "com.obric.aiagent.plugin");
        this.f34375c.remove(r5);
        r2.removeView(r5);
    }

    public void a(com.obric.oui.calendar.a.g r3) {
        com.obric.oui.calendar.a.g r4 = (com.obric.oui.calendar.a.g) ZeusTransformUtils.wrapperContextForParams(r3, com.obric.oui.calendar.a.g.class, "com.obric.aiagent.plugin");
        if (r4 != null) goto L5;
        r4 = com.obric.oui.calendar.a.g.f34371a;
    L5:
        this.f34377e = r4;
    }

    public void d(int r4) {
        this.f = Integer.valueOf(r4);
        Iterator<V> r3 = this.f34375c.iterator();
    L4:
        if (r3.hasNext() == false) goto L6;
        ((CalendarPagerView) ZeusTransformUtils.preCheckCast(r3.next(), CalendarPagerView.class, "com.obric.aiagent.plugin")).setSelectionColor(r4);
        goto L4
    }

    public void e(int r4) {
        if (r4 != 0) goto L4;
        return;
    L4:
        this.g = Integer.valueOf(r4);
        Iterator<V> r3 = this.f34375c.iterator();
    L6:
        if (r3.hasNext() == false) goto L8;
        ((CalendarPagerView) ZeusTransformUtils.preCheckCast(r3.next(), CalendarPagerView.class, "com.obric.aiagent.plugin")).setDateTextAppearance(r4);
        goto L6
    }

    public void f(int r4) {
        this.i = r4;
        Iterator<V> r3 = this.f34375c.iterator();
    L4:
        if (r3.hasNext() == false) goto L6;
        ((CalendarPagerView) ZeusTransformUtils.preCheckCast(r3.next(), CalendarPagerView.class, "com.obric.aiagent.plugin")).setShowOtherDates(r4);
        goto L4
    }

    public void a(com.obric.oui.calendar.a.h r4) {
        com.obric.oui.calendar.a.h r5 = (com.obric.oui.calendar.a.h) ZeusTransformUtils.wrapperContextForParams(r4, com.obric.oui.calendar.a.h.class, "com.obric.aiagent.plugin");
        this.n = r5;
        Iterator<V> r3 = this.f34375c.iterator();
    L4:
        if (r3.hasNext() == false) goto L6;
        ((CalendarPagerView) ZeusTransformUtils.preCheckCast(r3.next(), CalendarPagerView.class, "com.obric.aiagent.plugin")).setWeekDayFormatter(r5);
        goto L4
    }

    public void a(com.obric.oui.calendar.a.e r4) {
        com.obric.oui.calendar.a.e r5 = (com.obric.oui.calendar.a.e) ZeusTransformUtils.wrapperContextForParams(r4, com.obric.oui.calendar.a.e.class, "com.obric.aiagent.plugin");
        com.obric.oui.calendar.a.e r0 = this.p;
        if (r0 != this.o) goto L5;
        r0 = r5;
    L5:
        this.p = r0;
        this.o = r5;
        Iterator<V> r3 = this.f34375c.iterator();
    L7:
        if (r3.hasNext() == false) goto L9;
        ((CalendarPagerView) ZeusTransformUtils.preCheckCast(r3.next(), CalendarPagerView.class, "com.obric.aiagent.plugin")).setDayFormatter(r5);
        goto L7
    }

    public void b(com.obric.oui.calendar.a.e r4) {
        com.obric.oui.calendar.a.e r5 = (com.obric.oui.calendar.a.e) ZeusTransformUtils.wrapperContextForParams(r4, com.obric.oui.calendar.a.e.class, "com.obric.aiagent.plugin");
        this.p = r5;
        Iterator<V> r3 = this.f34375c.iterator();
    L4:
        if (r3.hasNext() == false) goto L6;
        ((CalendarPagerView) ZeusTransformUtils.preCheckCast(r3.next(), CalendarPagerView.class, "com.obric.aiagent.plugin")).setDayFormatterContentDescription(r5);
        goto L4
    }

    public int e() {
        return this.i;
    }

    public void g(int r4) {
        if (r4 != 0) goto L4;
        return;
    L4:
        this.h = Integer.valueOf(r4);
        Iterator<V> r3 = this.f34375c.iterator();
    L6:
        if (r3.hasNext() == false) goto L8;
        ((CalendarPagerView) ZeusTransformUtils.preCheckCast(r3.next(), CalendarPagerView.class, "com.obric.aiagent.plugin")).setWeekDayTextAppearance(r4);
        goto L6
    }

    public void b(CalendarDay r5, CalendarDay r6) {
        this.j = r5;
        this.k = r6;
        Iterator<V> r0 = this.f34375c.iterator();
    L4:
        if (r0.hasNext() == false) goto L6;
        CalendarPagerView r1 = (CalendarPagerView) ZeusTransformUtils.preCheckCast(r0.next(), CalendarPagerView.class, "com.obric.aiagent.plugin");
        r1.setMinimumDate(r5);
        r1.setMaximumDate(r6);
        goto L4
    L6:
        if (r5 != null) goto L8;
        r5 = CalendarDay.from(this.f34376d.getYear() + IdlErrors.E_NetworkNotActive, this.f34376d.getMonth(), this.f34376d.getDay());
    L8:
        if (r6 != null) goto L10;
        r6 = CalendarDay.from(this.f34376d.getYear() + 200, this.f34376d.getMonth(), this.f34376d.getDay());
    L10:
        this.l = a(r5, r6);
        c();
        k();
    }

    public c f() {
        return this.l;
    }

    public void g() {
        this.m.clear();
        k();
    }

    public void a(CalendarDay r1, boolean r2) {
        if (r2 == false) goto L7;
        if (this.m.contains(r1) == true) goto L10;
        this.m.add(r1);
        k();
        return;
    L10:
        return;
    L7:
        if (this.m.contains(r1) == false) goto L12;
        this.m.remove(r1);
        k();
        return;
    }

    public void c(CalendarDay r3, CalendarDay r4) {
        this.m.clear();
        LocalDate r5 = LocalDate.of(r3.getYear(), r3.getMonth(), r3.getDay());
        LocalDate r6 = r4.getDate();
    L4:
        if (r5.isBefore(r6) == true) goto L10;
        if (r5.equals(r6) == true) goto L10;
        k();
        return;
    L10:
        this.m.add(CalendarDay.from(r5));
        r5 = r5.plusDays(1);
        goto L4
    }

    private void k() {
        l();
        Iterator<V> r0 = this.f34375c.iterator();
    L4:
        if (r0.hasNext() == false) goto L6;
        ((CalendarPagerView) ZeusTransformUtils.preCheckCast(r0.next(), CalendarPagerView.class, "com.obric.aiagent.plugin")).setSelectedDates(this.m);
        goto L4
    }

    private void l() {
        int r0 = 0;
    L4:
        if (r0 >= this.m.size()) goto L15;
        CalendarDay r1 = (CalendarDay) ZeusTransformUtils.preCheckCast(this.m.get(r0), CalendarDay.class, "com.obric.aiagent.plugin");
        CalendarDay r2 = this.j;
        if (r2 != null) goto L8;
    L9:
        CalendarDay r3 = this.k;
        if (r3 == null) goto L14;
        if (r3.isBefore(r1) == false) goto L14;
    L13:
        this.m.remove(r0);
        this.f34373a.onDateUnselected(r1);
        r0 = r0 - 1;
    L14:
        r0 = r0 + 1;
        goto L4
    L8:
        if (r2.isAfter(r1) == true) goto L13;
    }

    public CalendarDay h(int r1) {
        return this.l.a(r1);
    }

    public List<CalendarDay> h() {
        return Collections.unmodifiableList(this.m);
    }

    public int i() {
        Integer r0 = this.g;
        if (r0 != null) goto L6;
        return 0;
    L6:
        return r0.intValue();
    }

    public int j() {
        Integer r0 = this.h;
        if (r0 != null) goto L6;
        return 0;
    L6:
        return r0.intValue();
    }
}
