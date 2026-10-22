package com.google.android.material.datepicker;

import android.content.Context;
import android.widget.BaseAdapter;
import android.widget.TextView;
import java.util.Collection;
import java.util.Iterator;

/* loaded from: classes2.dex */
public class p extends BaseAdapter {

    /* renamed from: g, reason: collision with root package name */
    public static final int f20840g = v.n().getMaximum(4);

    /* renamed from: h, reason: collision with root package name */
    public static final int f20841h = (v.n().getMaximum(5) + v.n().getMaximum(7)) - 1;

    /* renamed from: a, reason: collision with root package name */
    public final Month f20842a;

    /* renamed from: b, reason: collision with root package name */
    public final DateSelector<?> f20843b;

    /* renamed from: c, reason: collision with root package name */
    public Collection<Long> f20844c;

    /* renamed from: d, reason: collision with root package name */
    public b f20845d;

    /* renamed from: e, reason: collision with root package name */
    public final CalendarConstraints f20846e;

    /* renamed from: f, reason: collision with root package name */
    public final DayViewDecorator f20847f;

    public p(Month month, DateSelector<?> dateSelector, CalendarConstraints calendarConstraints, DayViewDecorator dayViewDecorator) {
        this.f20842a = month;
        this.f20843b = dateSelector;
        this.f20846e = calendarConstraints;
        this.f20847f = dayViewDecorator;
        this.f20844c = dateSelector.getSelectedDays();
    }

    public int a(int i10) {
        return b() + (i10 - 1);
    }

    public int b() {
        return this.f20842a.daysFromStartOfWeekToFirstOfMonth(this.f20846e.getFirstDayOfWeek());
    }

    public final String c(Context context, long j10) {
        return h.e(context, j10, l(j10), k(j10), g(j10));
    }

    @Override // android.widget.Adapter
    /* renamed from: d, reason: merged with bridge method [inline-methods] */
    public Long getItem(int i10) {
        if (i10 < b() || i10 > m()) {
            return null;
        }
        return Long.valueOf(this.f20842a.getDay(n(i10)));
    }

    /* JADX WARN: Removed duplicated region for block: B:11:0x0054  */
    @Override // android.widget.Adapter
    /* renamed from: e, reason: merged with bridge method [inline-methods] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public android.widget.TextView getView(int r6, android.view.View r7, android.view.ViewGroup r8) {
        /*
            r5 = this;
            android.content.Context r0 = r8.getContext()
            r5.f(r0)
            r0 = r7
            android.widget.TextView r0 = (android.widget.TextView) r0
            r1 = 0
            if (r7 != 0) goto L1e
            android.content.Context r7 = r8.getContext()
            android.view.LayoutInflater r7 = android.view.LayoutInflater.from(r7)
            int r0 = com.google.android.material.R$layout.mtrl_calendar_day
            android.view.View r7 = r7.inflate(r0, r8, r1)
            r0 = r7
            android.widget.TextView r0 = (android.widget.TextView) r0
        L1e:
            int r7 = r5.b()
            int r7 = r6 - r7
            if (r7 < 0) goto L54
            com.google.android.material.datepicker.Month r8 = r5.f20842a
            int r2 = r8.daysInMonth
            if (r7 < r2) goto L2d
            goto L54
        L2d:
            r2 = 1
            int r7 = r7 + r2
            r0.setTag(r8)
            android.content.res.Resources r8 = r0.getResources()
            android.content.res.Configuration r8 = r8.getConfiguration()
            java.util.Locale r8 = r8.locale
            java.lang.Integer r3 = java.lang.Integer.valueOf(r7)
            java.lang.Object[] r3 = new java.lang.Object[]{r3}
            java.lang.String r4 = "%d"
            java.lang.String r8 = java.lang.String.format(r8, r4, r3)
            r0.setText(r8)
            r0.setVisibility(r1)
            r0.setEnabled(r2)
            goto L5d
        L54:
            r7 = 8
            r0.setVisibility(r7)
            r0.setEnabled(r1)
            r7 = -1
        L5d:
            java.lang.Long r6 = r5.getItem(r6)
            if (r6 != 0) goto L64
            return r0
        L64:
            long r1 = r6.longValue()
            r5.o(r0, r1, r7)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.material.datepicker.p.getView(int, android.view.View, android.view.ViewGroup):android.widget.TextView");
    }

    public final void f(Context context) {
        if (this.f20845d == null) {
            this.f20845d = new b(context);
        }
    }

    public boolean g(long j10) {
        Iterator<B0.d<Long, Long>> it = this.f20843b.getSelectedRanges().iterator();
        while (it.hasNext()) {
            Long l10 = it.next().f1412b;
            if (l10 != null && l10.longValue() == j10) {
                return true;
            }
        }
        return false;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        return f20841h;
    }

    @Override // android.widget.Adapter
    public long getItemId(int i10) {
        return i10 / this.f20842a.daysInWeek;
    }

    public boolean h(int i10) {
        return i10 % this.f20842a.daysInWeek == 0;
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public boolean hasStableIds() {
        return true;
    }

    public boolean i(int i10) {
        return (i10 + 1) % this.f20842a.daysInWeek == 0;
    }

    public final boolean j(long j10) {
        Iterator<Long> it = this.f20843b.getSelectedDays().iterator();
        while (it.hasNext()) {
            if (v.a(j10) == v.a(it.next().longValue())) {
                return true;
            }
        }
        return false;
    }

    public boolean k(long j10) {
        Iterator<B0.d<Long, Long>> it = this.f20843b.getSelectedRanges().iterator();
        while (it.hasNext()) {
            Long l10 = it.next().f1411a;
            if (l10 != null && l10.longValue() == j10) {
                return true;
            }
        }
        return false;
    }

    public final boolean l(long j10) {
        return v.l().getTimeInMillis() == j10;
    }

    public int m() {
        return (b() + this.f20842a.daysInMonth) - 1;
    }

    public int n(int i10) {
        return (i10 - b()) + 1;
    }

    public final void o(TextView textView, long j10, int i10) {
        boolean zJ;
        a aVar;
        if (textView == null) {
            return;
        }
        Context context = textView.getContext();
        String strC = c(context, j10);
        textView.setContentDescription(strC);
        boolean zIsValid = this.f20846e.getDateValidator().isValid(j10);
        if (zIsValid) {
            textView.setEnabled(true);
            zJ = j(j10);
            textView.setSelected(zJ);
            aVar = zJ ? this.f20845d.f20768b : l(j10) ? this.f20845d.f20769c : this.f20845d.f20767a;
        } else {
            zJ = false;
            textView.setEnabled(false);
            aVar = this.f20845d.f20773g;
        }
        boolean z10 = zJ;
        DayViewDecorator dayViewDecorator = this.f20847f;
        if (dayViewDecorator == null || i10 == -1) {
            aVar.d(textView);
            return;
        }
        Month month = this.f20842a;
        int i11 = month.year;
        int i12 = month.month;
        aVar.e(textView, dayViewDecorator.getBackgroundColor(context, i11, i12, i10, zIsValid, z10), this.f20847f.getTextColor(context, i11, i12, i10, zIsValid, z10));
        textView.setCompoundDrawables(this.f20847f.getCompoundDrawableLeft(context, i11, i12, i10, zIsValid, z10), this.f20847f.getCompoundDrawableTop(context, i11, i12, i10, zIsValid, z10), this.f20847f.getCompoundDrawableRight(context, i11, i12, i10, zIsValid, z10), this.f20847f.getCompoundDrawableBottom(context, i11, i12, i10, zIsValid, z10));
        textView.setContentDescription(this.f20847f.getContentDescription(context, i11, i12, i10, zIsValid, z10, strC));
    }

    public final void p(MaterialCalendarGridView materialCalendarGridView, long j10) {
        if (Month.create(j10).equals(this.f20842a)) {
            int dayOfMonth = this.f20842a.getDayOfMonth(j10);
            o((TextView) materialCalendarGridView.getChildAt(materialCalendarGridView.getAdapter().a(dayOfMonth) - materialCalendarGridView.getFirstVisiblePosition()), j10, dayOfMonth);
        }
    }

    public void q(MaterialCalendarGridView materialCalendarGridView) {
        Iterator<Long> it = this.f20844c.iterator();
        while (it.hasNext()) {
            p(materialCalendarGridView, it.next().longValue());
        }
        DateSelector<?> dateSelector = this.f20843b;
        if (dateSelector != null) {
            Iterator<Long> it2 = dateSelector.getSelectedDays().iterator();
            while (it2.hasNext()) {
                p(materialCalendarGridView, it2.next().longValue());
            }
            this.f20844c = this.f20843b.getSelectedDays();
        }
    }

    public boolean r(int i10) {
        return i10 >= b() && i10 <= m();
    }
}
