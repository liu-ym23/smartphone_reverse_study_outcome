package com.google.android.material.datepicker;

import android.content.Context;
import android.widget.BaseAdapter;
import android.widget.TextView;
import com.stepos.aiengine.R;
import java.util.Calendar;
import java.util.Collection;
import java.util.Date;
import java.util.Iterator;
import java.util.Locale;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class m extends BaseAdapter {

    /* renamed from: j, reason: collision with root package name */
    public static final int f4971j = s.g(null).getMaximum(4);

    /* renamed from: k, reason: collision with root package name */
    public static final int f4972k = (s.g(null).getMaximum(7) + s.g(null).getMaximum(5)) - 1;

    /* renamed from: a, reason: collision with root package name */
    public final Month f4973a;

    /* renamed from: b, reason: collision with root package name */
    public final DateSelector<?> f4974b;

    /* renamed from: c, reason: collision with root package name */
    public Collection<Long> f4975c;

    /* renamed from: d, reason: collision with root package name */
    public b f4976d;

    /* renamed from: e, reason: collision with root package name */
    public final CalendarConstraints f4977e;
    public final DayViewDecorator h;

    public m(Month month, DateSelector<?> dateSelector, CalendarConstraints calendarConstraints, DayViewDecorator dayViewDecorator) {
        this.f4973a = month;
        this.f4974b = dateSelector;
        this.f4977e = calendarConstraints;
        this.h = dayViewDecorator;
        this.f4975c = dateSelector.getSelectedDays();
    }

    public final int b() {
        return this.f4973a.daysFromStartOfWeekToFirstOfMonth(this.f4977e.getFirstDayOfWeek());
    }

    @Override // android.widget.Adapter
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public final Long getItem(int i10) {
        if (i10 < b() || i10 > d()) {
            return null;
        }
        return Long.valueOf(this.f4973a.getDay((i10 - b()) + 1));
    }

    public final int d() {
        return (b() + this.f4973a.daysInMonth) - 1;
    }

    public final void e(TextView textView, long j10, int i10) {
        boolean z;
        boolean z3;
        a aVar;
        boolean z10;
        if (textView == null) {
            return;
        }
        Context context = textView.getContext();
        boolean z11 = true;
        boolean z12 = s.f().getTimeInMillis() == j10;
        DateSelector<?> dateSelector = this.f4974b;
        Iterator<u0.b<Long, Long>> it = dateSelector.getSelectedRanges().iterator();
        while (true) {
            if (!it.hasNext()) {
                z = false;
                break;
            }
            Long l10 = it.next().f13138a;
            if (l10 != null && l10.longValue() == j10) {
                z = true;
                break;
            }
        }
        Iterator<u0.b<Long, Long>> it2 = dateSelector.getSelectedRanges().iterator();
        while (true) {
            if (!it2.hasNext()) {
                z3 = false;
                break;
            }
            Long l11 = it2.next().f13139b;
            if (l11 != null && l11.longValue() == j10) {
                z3 = true;
                break;
            }
        }
        Calendar calendarF = s.f();
        Calendar calendarG = s.g(null);
        calendarG.setTimeInMillis(j10);
        String str = calendarF.get(1) == calendarG.get(1) ? s.b("MMMMEEEEd", Locale.getDefault()).format(new Date(j10)) : s.b("yMMMMEEEEd", Locale.getDefault()).format(new Date(j10));
        if (z12) {
            str = String.format(context.getString(R.string.mtrl_picker_today_description), str);
        }
        if (z) {
            str = String.format(context.getString(R.string.mtrl_picker_start_date_description), str);
        } else if (z3) {
            str = String.format(context.getString(R.string.mtrl_picker_end_date_description), str);
        }
        String str2 = str;
        textView.setContentDescription(str2);
        boolean zIsValid = this.f4977e.getDateValidator().isValid(j10);
        if (zIsValid) {
            textView.setEnabled(true);
            Iterator<Long> it3 = dateSelector.getSelectedDays().iterator();
            while (true) {
                if (!it3.hasNext()) {
                    z11 = false;
                    break;
                } else {
                    if (s.a(j10) == s.a(it3.next().longValue())) {
                        break;
                    }
                }
            }
            textView.setSelected(z11);
            aVar = z11 ? this.f4976d.f4946b : s.f().getTimeInMillis() == j10 ? this.f4976d.f4947c : this.f4976d.f4945a;
            z10 = z11;
        } else {
            textView.setEnabled(false);
            aVar = this.f4976d.f4951g;
            z10 = false;
        }
        DayViewDecorator dayViewDecorator = this.h;
        if (dayViewDecorator == null || i10 == -1) {
            aVar.b(textView, null, null);
            return;
        }
        Month month = this.f4973a;
        int i11 = month.year;
        int i12 = month.month;
        aVar.b(textView, dayViewDecorator.getBackgroundColor(context, i11, i12, i10, zIsValid, z10), this.h.getTextColor(context, i11, i12, i10, zIsValid, z10));
        textView.setCompoundDrawables(this.h.getCompoundDrawableLeft(context, i11, i12, i10, zIsValid, z10), this.h.getCompoundDrawableTop(context, i11, i12, i10, zIsValid, z10), this.h.getCompoundDrawableRight(context, i11, i12, i10, zIsValid, z10), this.h.getCompoundDrawableBottom(context, i11, i12, i10, zIsValid, z10));
        textView.setContentDescription(this.h.getContentDescription(context, i11, i12, i10, zIsValid, z10, str2));
    }

    public final void f(MaterialCalendarGridView materialCalendarGridView, long j10) {
        Month monthCreate = Month.create(j10);
        Month month = this.f4973a;
        if (monthCreate.equals(month)) {
            int dayOfMonth = month.getDayOfMonth(j10);
            e((TextView) materialCalendarGridView.getChildAt((materialCalendarGridView.a().b() + (dayOfMonth - 1)) - materialCalendarGridView.getFirstVisiblePosition()), j10, dayOfMonth);
        }
    }

    @Override // android.widget.Adapter
    public final int getCount() {
        return f4972k;
    }

    @Override // android.widget.Adapter
    public final long getItemId(int i10) {
        return i10 / this.f4973a.daysInWeek;
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
            com.google.android.material.datepicker.b r1 = r5.f4976d
            if (r1 != 0) goto Lf
            com.google.android.material.datepicker.b r1 = new com.google.android.material.datepicker.b
            r1.<init>(r0)
            r5.f4976d = r1
        Lf:
            r0 = r7
            android.widget.TextView r0 = (android.widget.TextView) r0
            r1 = 0
            if (r7 != 0) goto L27
            android.content.Context r7 = r8.getContext()
            android.view.LayoutInflater r7 = android.view.LayoutInflater.from(r7)
            r0 = 2131493035(0x7f0c00ab, float:1.8609539E38)
            android.view.View r7 = r7.inflate(r0, r8, r1)
            r0 = r7
            android.widget.TextView r0 = (android.widget.TextView) r0
        L27:
            int r7 = r5.b()
            int r7 = r6 - r7
            if (r7 < 0) goto L5d
            com.google.android.material.datepicker.Month r8 = r5.f4973a
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
            r5.e(r0, r1, r7)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.material.datepicker.m.getView(int, android.view.View, android.view.ViewGroup):android.view.View");
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public final boolean hasStableIds() {
        return true;
    }
}
