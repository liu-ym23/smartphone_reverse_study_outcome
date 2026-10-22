package com.google.android.material.datepicker;

import android.content.Context;
import android.widget.BaseAdapter;
import android.widget.TextView;
import androidx.compose.material3.DatePickerDefaults;
import androidx.core.util.Pair;
import com.stepos.ability.R;
import java.util.Calendar;
import java.util.Collection;
import java.util.Date;
import java.util.Iterator;
import java.util.Locale;

/* loaded from: classes3.dex */
public final class D extends BaseAdapter {
    public static final int g = O.g(null).getMaximum(4);
    public static final int h = (O.g(null).getMaximum(7) + O.g(null).getMaximum(5)) - 1;

    /* renamed from: a, reason: collision with root package name */
    public final Month f2410a;
    public final DateSelector b;
    public Collection c;
    public C5.f d;
    public final CalendarConstraints e;
    public final DayViewDecorator f;

    public D(Month month, DateSelector dateSelector, CalendarConstraints calendarConstraints, DayViewDecorator dayViewDecorator) {
        this.f2410a = month;
        this.b = dateSelector;
        this.e = calendarConstraints;
        this.f = dayViewDecorator;
        this.c = dateSelector.getSelectedDays();
    }

    public final int a() {
        return this.f2410a.daysFromStartOfWeekToFirstOfMonth(this.e.getFirstDayOfWeek());
    }

    @Override // android.widget.Adapter
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public final Long getItem(int i) {
        if (i < a() || i > c()) {
            return null;
        }
        return Long.valueOf(this.f2410a.getDay((i - a()) + 1));
    }

    public final int c() {
        return (a() + this.f2410a.daysInMonth) - 1;
    }

    public final void d(TextView textView, long j5, int i) {
        boolean z10;
        boolean z11;
        C0900c c0900c;
        boolean z12;
        if (textView == null) {
            return;
        }
        Context context = textView.getContext();
        boolean z13 = true;
        boolean z14 = O.f().getTimeInMillis() == j5;
        DateSelector dateSelector = this.b;
        Iterator<Pair<Long, Long>> it = dateSelector.getSelectedRanges().iterator();
        while (true) {
            if (!it.hasNext()) {
                z10 = false;
                break;
            }
            Long l = it.next().first;
            if (l != null && l.longValue() == j5) {
                z10 = true;
                break;
            }
        }
        Iterator<Pair<Long, Long>> it2 = dateSelector.getSelectedRanges().iterator();
        while (true) {
            if (!it2.hasNext()) {
                z11 = false;
                break;
            }
            Long l5 = it2.next().second;
            if (l5 != null && l5.longValue() == j5) {
                z11 = true;
                break;
            }
        }
        Calendar calendarF = O.f();
        Calendar calendarG = O.g(null);
        calendarG.setTimeInMillis(j5);
        String str = calendarF.get(1) == calendarG.get(1) ? O.b("MMMMEEEEd", Locale.getDefault()).format(new Date(j5)) : O.b(DatePickerDefaults.YearMonthWeekdayDaySkeleton, Locale.getDefault()).format(new Date(j5));
        if (z14) {
            str = String.format(context.getString(R.string.mtrl_picker_today_description), str);
        }
        if (z10) {
            str = String.format(context.getString(R.string.mtrl_picker_start_date_description), str);
        } else if (z11) {
            str = String.format(context.getString(R.string.mtrl_picker_end_date_description), str);
        }
        String str2 = str;
        textView.setContentDescription(str2);
        boolean zIsValid = this.e.getDateValidator().isValid(j5);
        if (zIsValid) {
            textView.setEnabled(true);
            Iterator<Long> it3 = dateSelector.getSelectedDays().iterator();
            while (true) {
                if (!it3.hasNext()) {
                    z13 = false;
                    break;
                } else {
                    if (O.a(j5) == O.a(it3.next().longValue())) {
                        break;
                    }
                }
            }
            textView.setSelected(z13);
            c0900c = z13 ? (C0900c) this.d.b : O.f().getTimeInMillis() == j5 ? (C0900c) this.d.c : (C0900c) this.d.f302a;
            z12 = z13;
        } else {
            textView.setEnabled(false);
            c0900c = (C0900c) this.d.g;
            z12 = false;
        }
        DayViewDecorator dayViewDecorator = this.f;
        if (dayViewDecorator == null || i == -1) {
            c0900c.e(textView, null, null);
            return;
        }
        Month month = this.f2410a;
        int i6 = month.year;
        int i10 = month.month;
        c0900c.e(textView, dayViewDecorator.getBackgroundColor(context, i6, i10, i, zIsValid, z12), this.f.getTextColor(context, i6, i10, i, zIsValid, z12));
        textView.setCompoundDrawables(this.f.getCompoundDrawableLeft(context, i6, i10, i, zIsValid, z12), this.f.getCompoundDrawableTop(context, i6, i10, i, zIsValid, z12), this.f.getCompoundDrawableRight(context, i6, i10, i, zIsValid, z12), this.f.getCompoundDrawableBottom(context, i6, i10, i, zIsValid, z12));
        textView.setContentDescription(this.f.getContentDescription(context, i6, i10, i, zIsValid, z12, str2));
    }

    public final void e(MaterialCalendarGridView materialCalendarGridView, long j5) {
        Month monthCreate = Month.create(j5);
        Month month = this.f2410a;
        if (monthCreate.equals(month)) {
            int dayOfMonth = month.getDayOfMonth(j5);
            d((TextView) materialCalendarGridView.getChildAt((materialCalendarGridView.a().a() + (dayOfMonth - 1)) - materialCalendarGridView.getFirstVisiblePosition()), j5, dayOfMonth);
        }
    }

    @Override // android.widget.Adapter
    public final int getCount() {
        return h;
    }

    @Override // android.widget.Adapter
    public final long getItemId(int i) {
        return i / this.f2410a.daysInWeek;
    }

    /* JADX WARN: Removed duplicated region for block: B:14:0x005d  */
    @Override // android.widget.Adapter
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final android.view.View getView(int r6, android.view.View r7, android.view.ViewGroup r8) {
        /*
            r5 = this;
            android.content.Context r0 = r8.getContext()
            C5.f r1 = r5.d
            if (r1 != 0) goto Lf
            C5.f r1 = new C5.f
            r1.<init>(r0)
            r5.d = r1
        Lf:
            r0 = r7
            android.widget.TextView r0 = (android.widget.TextView) r0
            r1 = 0
            if (r7 != 0) goto L27
            android.content.Context r7 = r8.getContext()
            android.view.LayoutInflater r7 = android.view.LayoutInflater.from(r7)
            r0 = 2131558600(0x7f0d00c8, float:1.874252E38)
            android.view.View r7 = r7.inflate(r0, r8, r1)
            r0 = r7
            android.widget.TextView r0 = (android.widget.TextView) r0
        L27:
            int r7 = r5.a()
            int r7 = r6 - r7
            if (r7 < 0) goto L5d
            com.google.android.material.datepicker.Month r8 = r5.f2410a
            int r2 = r8.daysInMonth
            if (r7 < r2) goto L36
            goto L5d
        L36:
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
            goto L66
        L5d:
            r7 = 8
            r0.setVisibility(r7)
            r0.setEnabled(r1)
            r7 = -1
        L66:
            java.lang.Long r6 = r5.getItem(r6)
            if (r6 != 0) goto L6d
            return r0
        L6d:
            long r1 = r6.longValue()
            r5.d(r0, r1, r7)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.material.datepicker.D.getView(int, android.view.View, android.view.ViewGroup):android.view.View");
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public final boolean hasStableIds() {
        return true;
    }
}
