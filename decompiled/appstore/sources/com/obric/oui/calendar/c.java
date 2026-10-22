package com.obric.oui.calendar;

import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;
import androidx.annotation.NonNull;
import com.google.common.primitives.Ints;
import com.obric.oui.calendar.format.DayFormatter;
import com.obric.oui.calendar.format.WeekDayFormatter;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import org.threeten.bp.DayOfWeek;
import org.threeten.bp.LocalDate;
import org.threeten.bp.temporal.ChronoUnit;
import org.threeten.bp.temporal.WeekFields;

/* JADX INFO: loaded from: classes4.dex */
public abstract class c extends ViewGroup implements View.OnClickListener, View.OnLongClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ArrayList f12680a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ArrayList f12681b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final DayOfWeek f12682c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f12683d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public MaterialCalendarView f12684e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public CalendarDay f12685f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public CalendarDay f12686g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public CalendarDay f12687h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public boolean f12688i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final Collection f12689j;

    public static class a extends ViewGroup.MarginLayoutParams {
        public a() {
            super(-2, -2);
        }
    }

    public c(MaterialCalendarView r10, CalendarDay r11, DayOfWeek r12, boolean r13) {
        super(r10.getContext());
        this.f12680a = new ArrayList();
        this.f12681b = new ArrayList();
        this.f12683d = 4;
        this.f12686g = null;
        this.f12687h = null;
        ArrayList r14 = new ArrayList();
        this.f12689j = r14;
        this.f12684e = r10;
        this.f12685f = r11;
        this.f12682c = r12;
        this.f12688i = r13;
        setClipChildren(false);
        setClipToPadding(false);
        if (r13 == false) goto L5;
        c(m());
    L5:
        b(r14, m());
    }

    public static LocalDate h(LocalDate r10, DayOfWeek r11, boolean r12) {
        LocalDate r13 = r10.with(WeekFields.of(r11, 1).dayOfWeek(), 1);
        int r14 = r11.getValue() - r13.getDayOfWeek().getValue();
        if (r12 == false) goto L6;
        if (r14 < 0) goto L9;
    L7:
        r14 = r14 - 7;
    L9:
        return r13.plusDays(r14);
    L6:
        if (r14 <= 0) goto L9;
        goto L7
    }

    public static int j(LocalDate r10, DayOfWeek r11, boolean r12) {
        LocalDate r13 = h(r10, r11, r12);
        LocalDate r14 = r10.withDayOfMonth(r10.lengthOfMonth());
        return (int) ((ChronoUnit.DAYS.between(r13, r14) + 7) / 7);
    }

    public void A() {
        Iterator r10 = this.f12689j.iterator();
    L4:
        if (r10.hasNext() == false) goto L6;
        d r11 = (d) r10.next();
        CalendarDay r12 = r11.h();
        r11.t(this.f12683d, r12.isInRange(this.f12686g, this.f12687h), l(r12));
        goto L4
    L6:
        postInvalidate();
    }

    public void a(Collection r10, LocalDate r11) {
        CalendarDay r12 = CalendarDay.from(r11);
        d r13 = new d(getContext(), r12);
        r13.setOnClickListener(this);
        r13.setOnLongClickListener(this);
        r10.add(r13);
        addView(r13, new a());
    }

    public abstract void b(Collection r10, LocalDate r11);

    public final void c(LocalDate r10) {
        int r11 = 0;
    L4:
        if (r11 >= 7) goto L6;
        v r12 = new v(getContext(), r10.getDayOfWeek());
        r12.setImportantForAccessibility(2);
        this.f12680a.add(r12);
        addView(r12);
        r10 = r10.plusDays(1);
        r11 = r11 + 1;
        goto L4
    }

    @Override // android.view.ViewGroup
    public boolean checkLayoutParams(ViewGroup.LayoutParams r10) {
        return r10 instanceof a;
    }

    public a d() {
        return new a();
    }

    public a e(AttributeSet r10) {
        return new a();
    }

    public DayOfWeek f() {
        return this.f12682c;
    }

    public CalendarDay g() {
        return this.f12685f;
    }

    @Override // android.view.ViewGroup
    public /* bridge */ /* synthetic */ ViewGroup.LayoutParams generateDefaultLayoutParams() {
        return d();
    }

    @Override // android.view.ViewGroup
    public /* bridge */ /* synthetic */ ViewGroup.LayoutParams generateLayoutParams(AttributeSet r10) {
        return e(r10);
    }

    public abstract int i();

    public void k() {
        e r10 = new e();
        Iterator r11 = this.f12689j.iterator();
    L4:
        if (r11.hasNext() == false) goto L12;
        d r12 = (d) r11.next();
        r10.g();
        Iterator r13 = this.f12681b.iterator();
    L7:
        if (r13.hasNext() == false) goto L11;
        f r14 = (f) r13.next();
        if (r14.f12713a.shouldDecorate(r12.h()) == false) goto L7;
        r14.f12714b.a(r10);
        goto L7
    L11:
        r12.a(r10);
        goto L4
    }

    public abstract boolean l(CalendarDay r10);

    public LocalDate m() {
        return h(g().getDate(), this.f12682c, MaterialCalendarView.H(this.f12683d));
    }

    public void n(CalendarMode r10) {
        Iterator r11 = this.f12689j.iterator();
    L4:
        if (r11.hasNext() == false) goto L6;
        ((d) r11.next()).l(r10);
        goto L4
    }

    public void o(int r10) {
        Iterator r11 = this.f12689j.iterator();
    L4:
        if (r11.hasNext() == false) goto L6;
        ((d) r11.next()).setTextAppearance(getContext(), r10);
        goto L4
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View r10) {
        if ((r10 instanceof d) == false) goto L6;
        MaterialCalendarView r11 = this.f12684e;
        r11.z((d) r10);
        return;
    }

    @Override // android.view.View
    public void onInitializeAccessibilityEvent(@NonNull AccessibilityEvent r10) {
        super.onInitializeAccessibilityEvent(r10);
        r10.setClassName(c.class.getName());
    }

    @Override // android.view.View
    public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo r10) {
        super.onInitializeAccessibilityNodeInfo(r10);
        r10.setClassName(c.class.getName());
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onLayout(boolean r11, int r12, int r13, int r14, int r15) {
        int r16 = getWidth();
        int r17 = getChildCount();
        int r18 = getHeight();
        int r19 = i();
        if (this.f12688i == false) goto L5;
        r19 = Math.max(0, r19 - 1);
    L5:
        int r110 = this.f12684e.getTileHSpacing();
        int r10 = this.f12684e.getTileVSpacing();
        if (r110 >= 0) goto L8;
        r110 = (r16 - (this.f12684e.getMeasureInfo().f12576a * 7)) / 6;
    L8:
        if (r10 >= 0) goto L17;
        int r20 = r19 - (!this.f12688i ? 1 : 0);
        if (r20 == 0) goto L16;
        int r111 = r18 - (this.f12684e.getMeasureInfo().f12577b * r19);
        if (this.f12688i == false) goto L14;
        int r112 = this.f12684e.getWeekDaysHeight();
    L15:
        r10 = (r111 - r112) / r20;
        goto L17
    L14:
        r112 = 0;
        goto L15
    L16:
        r10 = 0;
    L17:
        int r21 = r16;
        int r113 = 0;
        int r114 = 0;
        int r22 = 0;
    L18:
        if (r113 >= r17) goto L29;
        View r23 = getChildAt(r113);
        int r24 = r23.getMeasuredWidth();
        int r25 = r23.getMeasuredHeight();
        int r26 = r113 % 7;
        if (r26 <= 0) goto L23;
        r114 = r114 + r110;
        r21 = r21 + r110;
    L23:
        if (g.a() == false) goto L25;
        int r27 = r21 - r24;
        r23.layout(r27, r22, r21, r22 + r25);
        r21 = r27;
    L26:
        if (r26 != 6) goto L28;
        r22 = (r22 + r25) + r10;
        r21 = r16;
        r114 = 0;
    L28:
        r113 = r113 + 1;
        goto L18
    L25:
        int r28 = r24 + r114;
        r23.layout(r114, r22, r28, r22 + r25);
        r114 = r28;
        goto L26
    }

    @Override // android.view.View.OnLongClickListener
    public boolean onLongClick(View r10) {
        if ((r10 instanceof d) == false) goto L6;
        MaterialCalendarView r11 = this.f12684e;
        r11.A((d) r10);
        return true;
    L6:
        return false;
    }

    @Override // android.view.View
    public void onMeasure(int r10, int r11) {
        int r12 = View.MeasureSpec.getSize(r10);
        int r13 = View.MeasureSpec.getMode(r10);
        int r14 = View.MeasureSpec.getSize(r11);
        if (View.MeasureSpec.getMode(r11) == 0) goto L16;
        if (r13 == 0) goto L16;
        setMeasuredDimension(r12, r14);
        int r15 = getChildCount();
        int r16 = 0;
    L6:
        if (r16 >= r15) goto L14;
        View r17 = getChildAt(r16);
        int r18 = View.MeasureSpec.makeMeasureSpec(this.f12684e.getMeasureInfo().f12576a, Ints.MAX_POWER_OF_TWO);
        if (this.f12688i == true) goto L10;
    L12:
        int r19 = View.MeasureSpec.makeMeasureSpec(this.f12684e.getMeasureInfo().f12577b, Ints.MAX_POWER_OF_TWO);
    L13:
        r17.measure(r18, r19);
        r16 = r16 + 1;
        goto L6
    L10:
        if (r16 >= 7) goto L12;
        r19 = View.MeasureSpec.makeMeasureSpec(this.f12684e.getWeekDaysHeight(), Ints.MAX_POWER_OF_TWO);
        goto L13
    L14:
        return;
    L16:
        throw new IllegalStateException("CalendarPagerView should never be left to decide it's size");
    }

    public void p(DayFormatter r10) {
        Iterator r11 = this.f12689j.iterator();
    L4:
        if (r11.hasNext() == false) goto L6;
        ((d) r11.next()).o(r10);
        goto L4
    }

    public void q(DayFormatter r10) {
        Iterator r11 = this.f12689j.iterator();
    L4:
        if (r11.hasNext() == false) goto L6;
        ((d) r11.next()).p(r10);
        goto L4
    }

    public void r(List r10) {
        this.f12681b.clear();
        if (r10 == null) goto L5;
        this.f12681b.addAll(r10);
    L5:
        k();
    }

    public void s(CalendarDay r10) {
        this.f12687h = r10;
        A();
    }

    @Override // android.view.ViewGroup
    public boolean shouldDelayChildPressedState() {
        return false;
    }

    public void t(CalendarDay r10) {
        this.f12686g = r10;
        A();
    }

    public void u(Collection r10) {
        Iterator r11 = this.f12689j.iterator();
    L4:
        if (r11.hasNext() == false) goto L14;
        d r12 = (d) r11.next();
        CalendarDay r13 = r12.h();
        if (r10 != null) goto L8;
    L10:
        boolean r14 = false;
    L12:
        if (r12.j() == false) goto L4;
        r12.setChecked(r14);
        goto L4
    L8:
        if (r10.contains(r13) == false) goto L10;
        r14 = true;
        goto L12
    L14:
        postInvalidate();
    }

    public void v(int r10) {
        Iterator r11 = this.f12689j.iterator();
    L4:
        if (r11.hasNext() == false) goto L6;
        ((d) r11.next()).r(r10);
        goto L4
    }

    public void w(boolean r10) {
        Iterator r11 = this.f12689j.iterator();
    L4:
        if (r11.hasNext() == false) goto L10;
        d r12 = (d) r11.next();
        if (r10 == false) goto L8;
        c r13 = this;
    L9:
        r12.setOnClickListener(r13);
        r12.setClickable(r10);
        goto L4
    L8:
        r13 = null;
        goto L9
    }

    public void x(int r10) {
        this.f12683d = r10;
        A();
    }

    public void y(WeekDayFormatter r10) {
        Iterator r11 = this.f12680a.iterator();
    L4:
        if (r11.hasNext() == false) goto L6;
        ((v) r11.next()).c(r10);
        goto L4
    }

    public void z(int r10) {
        Iterator r11 = this.f12680a.iterator();
    L4:
        if (r11.hasNext() == false) goto L6;
        ((v) r11.next()).setTextAppearance(getContext(), r10);
        goto L4
    }

    @Override // android.view.ViewGroup
    public ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams r10) {
        return new a();
    }
}
