package com.prolificinteractive.materialcalendarview;

import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;
import androidx.annotation.NonNull;
import com.google.common.primitives.Ints;
import com.prolificinteractive.materialcalendarview.format.DayFormatter;
import com.prolificinteractive.materialcalendarview.format.WeekDayFormatter;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import org.threeten.bp.DayOfWeek;
import org.threeten.bp.LocalDate;
import org.threeten.bp.temporal.WeekFields;

/* JADX INFO: loaded from: classes4.dex */
public abstract class d extends ViewGroup implements View.OnClickListener, View.OnLongClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ArrayList f17777a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ArrayList f17778b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final DayOfWeek f17779c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f17780d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public MaterialCalendarView f17781e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public CalendarDay f17782f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public CalendarDay f17783g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public CalendarDay f17784h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public boolean f17785i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final Collection f17786j;

    public static class a extends ViewGroup.MarginLayoutParams {
        public a() {
            super(-2, -2);
        }
    }

    public d(MaterialCalendarView r10, CalendarDay r11, DayOfWeek r12, boolean r13) {
        super(r10.getContext());
        this.f17777a = new ArrayList();
        this.f17778b = new ArrayList();
        this.f17780d = 4;
        this.f17783g = null;
        this.f17784h = null;
        ArrayList r14 = new ArrayList();
        this.f17786j = r14;
        this.f17781e = r10;
        this.f17782f = r11;
        this.f17779c = r12;
        this.f17785i = r13;
        setClipChildren(false);
        setClipToPadding(false);
        if (i.a() == false) goto L5;
        setRotationY(180.0f);
    L5:
        if (r13 == false) goto L7;
        c(k());
    L7:
        b(r14, k());
    }

    public void a(Collection r10, LocalDate r11) {
        CalendarDay r12 = CalendarDay.from(r11);
        e r13 = new e(getContext(), r12);
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
        m r12 = new m(getContext(), r10.getDayOfWeek());
        r12.setImportantForAccessibility(2);
        this.f17777a.add(r12);
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
        return this.f17779c;
    }

    public CalendarDay g() {
        return this.f17782f;
    }

    @Override // android.view.ViewGroup
    public /* bridge */ /* synthetic */ ViewGroup.LayoutParams generateDefaultLayoutParams() {
        return d();
    }

    @Override // android.view.ViewGroup
    public /* bridge */ /* synthetic */ ViewGroup.LayoutParams generateLayoutParams(AttributeSet r10) {
        return e(r10);
    }

    public abstract int h();

    public void i() {
        f r10 = new f();
        Iterator r11 = this.f17786j.iterator();
    L4:
        if (r11.hasNext() == false) goto L12;
        e r12 = (e) r11.next();
        r10.g();
        Iterator r13 = this.f17778b.iterator();
    L7:
        if (r13.hasNext() == false) goto L11;
        g r14 = (g) r13.next();
        if (r14.f17806a.shouldDecorate(r12.g()) == false) goto L7;
        r14.f17807b.a(r10);
        goto L7
    L11:
        r12.a(r10);
        goto L4
    }

    public abstract boolean j(CalendarDay r10);

    public LocalDate k() {
        LocalDate r10 = g().getDate().with(WeekFields.of(this.f17779c, 1).dayOfWeek(), 1);
        int r11 = f().getValue() - r10.getDayOfWeek().getValue();
        if (MaterialCalendarView.J(this.f17780d) == false) goto L6;
        if (r11 < 0) goto L9;
    L7:
        r11 = r11 - 7;
    L9:
        return r10.plusDays(r11);
    L6:
        if (r11 <= 0) goto L9;
        goto L7
    }

    public void l(int r10) {
        Iterator r11 = this.f17786j.iterator();
    L4:
        if (r11.hasNext() == false) goto L6;
        ((e) r11.next()).setTextAppearance(getContext(), r10);
        goto L4
    }

    public void m(DayFormatter r10) {
        Iterator r11 = this.f17786j.iterator();
    L4:
        if (r11.hasNext() == false) goto L6;
        ((e) r11.next()).l(r10);
        goto L4
    }

    public void n(DayFormatter r10) {
        Iterator r11 = this.f17786j.iterator();
    L4:
        if (r11.hasNext() == false) goto L6;
        ((e) r11.next()).m(r10);
        goto L4
    }

    public void o(List r10) {
        this.f17778b.clear();
        if (r10 == null) goto L5;
        this.f17778b.addAll(r10);
    L5:
        i();
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View r10) {
        if ((r10 instanceof e) == false) goto L6;
        MaterialCalendarView r11 = this.f17781e;
        r11.B((e) r10);
        return;
    }

    @Override // android.view.View
    public void onInitializeAccessibilityEvent(@NonNull AccessibilityEvent r10) {
        super.onInitializeAccessibilityEvent(r10);
        r10.setClassName(d.class.getName());
    }

    @Override // android.view.View
    public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo r10) {
        super.onInitializeAccessibilityNodeInfo(r10);
        r10.setClassName(d.class.getName());
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onLayout(boolean r10, int r11, int r12, int r13, int r14) {
        int r15 = getWidth();
        int r16 = getChildCount();
        int r17 = r15;
        int r18 = 0;
        int r19 = 0;
        int r20 = 0;
    L3:
        if (r18 >= r16) goto L12;
        View r21 = getChildAt(r18);
        int r22 = r21.getMeasuredWidth();
        int r23 = r21.getMeasuredHeight();
        if (i.a() == false) goto L7;
        int r24 = r17 - r22;
        r21.layout(r24, r20, r17, r20 + r23);
        r17 = r24;
    L9:
        if ((r18 % 7) != 6) goto L11;
        r20 = r20 + r23;
        r17 = r15;
        r19 = 0;
    L11:
        r18 = r18 + 1;
        goto L3
    L7:
        int r25 = r22 + r19;
        r21.layout(r19, r20, r25, r20 + r23);
        r19 = r25;
        goto L9
    }

    @Override // android.view.View.OnLongClickListener
    public boolean onLongClick(View r10) {
        if ((r10 instanceof e) == false) goto L6;
        MaterialCalendarView r11 = this.f17781e;
        r11.C((e) r10);
        return true;
    L6:
        return false;
    }

    @Override // android.view.View
    public void onMeasure(int r10, int r11) {
        int r12 = View.MeasureSpec.getSize(r10);
        int r13 = View.MeasureSpec.getMode(r10);
        int r14 = View.MeasureSpec.getSize(r11);
        if (View.MeasureSpec.getMode(r11) == 0) goto L10;
        if (r13 == 0) goto L10;
        int r15 = r12 / 7;
        int r16 = r14 / h();
        setMeasuredDimension(r12, r14);
        int r17 = getChildCount();
        int r18 = 0;
    L6:
        if (r18 >= r17) goto L8;
        getChildAt(r18).measure(View.MeasureSpec.makeMeasureSpec(r15, Ints.MAX_POWER_OF_TWO), View.MeasureSpec.makeMeasureSpec(r16, Ints.MAX_POWER_OF_TWO));
        r18 = r18 + 1;
        goto L6
    L8:
        return;
    L10:
        throw new IllegalStateException("CalendarPagerView should never be left to decide it's size");
    }

    public void p(CalendarDay r10) {
        this.f17784h = r10;
        x();
    }

    public void q(CalendarDay r10) {
        this.f17783g = r10;
        x();
    }

    public void r(Collection r10) {
        Iterator r11 = this.f17786j.iterator();
    L4:
        if (r11.hasNext() == false) goto L12;
        e r12 = (e) r11.next();
        CalendarDay r13 = r12.g();
        if (r10 != null) goto L8;
    L10:
        boolean r14 = false;
    L11:
        r12.setChecked(r14);
        goto L4
    L8:
        if (r10.contains(r13) == false) goto L10;
        r14 = true;
        goto L11
    L12:
        postInvalidate();
    }

    public void s(int r10) {
        Iterator r11 = this.f17786j.iterator();
    L4:
        if (r11.hasNext() == false) goto L6;
        ((e) r11.next()).o(r10);
        goto L4
    }

    @Override // android.view.ViewGroup
    public boolean shouldDelayChildPressedState() {
        return false;
    }

    public void t(boolean r10) {
        Iterator r11 = this.f17786j.iterator();
    L4:
        if (r11.hasNext() == false) goto L10;
        e r12 = (e) r11.next();
        if (r10 == false) goto L8;
        d r13 = this;
    L9:
        r12.setOnClickListener(r13);
        r12.setClickable(r10);
        goto L4
    L8:
        r13 = null;
        goto L9
    }

    public void u(int r10) {
        this.f17780d = r10;
        x();
    }

    public void v(WeekDayFormatter r10) {
        Iterator r11 = this.f17777a.iterator();
    L4:
        if (r11.hasNext() == false) goto L6;
        ((m) r11.next()).c(r10);
        goto L4
    }

    public void w(int r10) {
        Iterator r11 = this.f17777a.iterator();
    L4:
        if (r11.hasNext() == false) goto L6;
        ((m) r11.next()).setTextAppearance(getContext(), r10);
        goto L4
    }

    public void x() {
        Iterator r10 = this.f17786j.iterator();
    L4:
        if (r10.hasNext() == false) goto L6;
        e r11 = (e) r10.next();
        CalendarDay r12 = r11.g();
        r11.q(this.f17780d, r12.isInRange(this.f17783g, this.f17784h), j(r12));
        goto L4
    L6:
        postInvalidate();
    }

    @Override // android.view.ViewGroup
    public ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams r10) {
        return new a();
    }
}
