package com.google.android.material.datepicker;

import android.content.Context;
import android.widget.BaseAdapter;
import android.widget.TextView;
import com.stepos.alphame.R;
import java.util.Calendar;
import java.util.Collection;
import java.util.Date;
import java.util.Iterator;
import java.util.Locale;

/* loaded from: classes.dex */
public final class y extends BaseAdapter {

    /* renamed from: g, reason: collision with root package name */
    public static final int f10733g = J.g(null).getMaximum(4);

    /* renamed from: h, reason: collision with root package name */
    public static final int f10734h = (J.g(null).getMaximum(7) + J.g(null).getMaximum(5)) - 1;

    /* renamed from: a, reason: collision with root package name */
    public final Month f10735a;

    /* renamed from: b, reason: collision with root package name */
    public final DateSelector f10736b;

    /* renamed from: c, reason: collision with root package name */
    public Collection f10737c;

    /* renamed from: d, reason: collision with root package name */
    public o2.d f10738d;

    /* renamed from: e, reason: collision with root package name */
    public final CalendarConstraints f10739e;

    /* renamed from: f, reason: collision with root package name */
    public final DayViewDecorator f10740f;

    public y(Month month, DateSelector dateSelector, CalendarConstraints calendarConstraints, DayViewDecorator dayViewDecorator) {
        this.f10735a = month;
        this.f10736b = dateSelector;
        this.f10739e = calendarConstraints;
        this.f10740f = dayViewDecorator;
        this.f10737c = dateSelector.u();
    }

    public final int a() {
        int firstDayOfWeek = this.f10739e.f10603e;
        Month month = this.f10735a;
        Calendar calendar = month.f10657a;
        int i4 = calendar.get(7);
        if (firstDayOfWeek <= 0) {
            firstDayOfWeek = calendar.getFirstDayOfWeek();
        }
        int i5 = i4 - firstDayOfWeek;
        return i5 < 0 ? i5 + month.f10660d : i5;
    }

    @Override // android.widget.Adapter
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public final Long getItem(int i4) {
        if (i4 < a() || i4 > c()) {
            return null;
        }
        int iA = (i4 - a()) + 1;
        Calendar calendarC = J.c(this.f10735a.f10657a);
        calendarC.set(5, iA);
        return Long.valueOf(calendarC.getTimeInMillis());
    }

    public final int c() {
        return (a() + this.f10735a.f10661e) - 1;
    }

    public final void d(TextView textView, long j4, int i4) {
        boolean z4;
        boolean z5;
        H.d dVar;
        if (textView == null) {
            return;
        }
        Context context = textView.getContext();
        boolean z6 = false;
        boolean z7 = J.f().getTimeInMillis() == j4;
        DateSelector dateSelector = this.f10736b;
        Iterator it = dateSelector.e().iterator();
        while (true) {
            if (!it.hasNext()) {
                z4 = false;
                break;
            }
            Object obj = ((J.b) it.next()).f848a;
            if (obj != null && ((Long) obj).longValue() == j4) {
                z4 = true;
                break;
            }
        }
        Iterator it2 = dateSelector.e().iterator();
        while (true) {
            if (!it2.hasNext()) {
                z5 = false;
                break;
            }
            Object obj2 = ((J.b) it2.next()).f849b;
            if (obj2 != null && ((Long) obj2).longValue() == j4) {
                z5 = true;
                break;
            }
        }
        Calendar calendarF = J.f();
        Calendar calendarG = J.g(null);
        calendarG.setTimeInMillis(j4);
        String str = calendarF.get(1) == calendarG.get(1) ? J.b("MMMMEEEEd", Locale.getDefault()).format(new Date(j4)) : J.b("yMMMMEEEEd", Locale.getDefault()).format(new Date(j4));
        if (z7) {
            str = String.format(context.getString(R.string.mtrl_picker_today_description), str);
        }
        if (z4) {
            str = String.format(context.getString(R.string.mtrl_picker_start_date_description), str);
        } else if (z5) {
            str = String.format(context.getString(R.string.mtrl_picker_end_date_description), str);
        }
        textView.setContentDescription(str);
        if (this.f10739e.f10601c.l(j4)) {
            textView.setEnabled(true);
            Iterator it3 = dateSelector.u().iterator();
            while (true) {
                if (!it3.hasNext()) {
                    break;
                }
                if (J.a(j4) == J.a(((Long) it3.next()).longValue())) {
                    z6 = true;
                    break;
                }
            }
            textView.setSelected(z6);
            dVar = z6 ? (H.d) this.f10738d.f13797b : J.f().getTimeInMillis() == j4 ? (H.d) this.f10738d.f13798c : (H.d) this.f10738d.f13796a;
        } else {
            textView.setEnabled(false);
            dVar = (H.d) this.f10738d.f13802g;
        }
        if (this.f10740f == null || i4 == -1) {
            dVar.b(textView);
            return;
        }
        int i5 = this.f10735a.f10659c;
        dVar.b(textView);
        textView.setCompoundDrawables(null, null, null, null);
        textView.setContentDescription(str);
    }

    public final void e(MaterialCalendarGridView materialCalendarGridView, long j4) {
        Month monthF = Month.f(j4);
        Month month = this.f10735a;
        if (monthF.equals(month)) {
            Calendar calendarC = J.c(month.f10657a);
            calendarC.setTimeInMillis(j4);
            int i4 = calendarC.get(5);
            d((TextView) materialCalendarGridView.getChildAt((materialCalendarGridView.a().a() + (i4 - 1)) - materialCalendarGridView.getFirstVisiblePosition()), j4, i4);
        }
    }

    @Override // android.widget.Adapter
    public final int getCount() {
        return f10734h;
    }

    @Override // android.widget.Adapter
    public final long getItemId(int i4) {
        return i4 / this.f10735a.f10660d;
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
            o2.d r1 = r5.f10738d
            if (r1 != 0) goto Lf
            o2.d r1 = new o2.d
            r1.<init>(r0)
            r5.f10738d = r1
        Lf:
            r0 = r7
            android.widget.TextView r0 = (android.widget.TextView) r0
            r1 = 0
            if (r7 != 0) goto L27
            android.content.Context r7 = r8.getContext()
            android.view.LayoutInflater r7 = android.view.LayoutInflater.from(r7)
            r0 = 2131493036(0x7f0c00ac, float:1.860954E38)
            android.view.View r7 = r7.inflate(r0, r8, r1)
            r0 = r7
            android.widget.TextView r0 = (android.widget.TextView) r0
        L27:
            int r7 = r5.a()
            int r7 = r6 - r7
            if (r7 < 0) goto L5d
            com.google.android.material.datepicker.Month r8 = r5.f10735a
            int r2 = r8.f10661e
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
            goto L74
        L6d:
            long r1 = r6.longValue()
            r5.d(r0, r1, r7)
        L74:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.material.datepicker.y.getView(int, android.view.View, android.view.ViewGroup):android.view.View");
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public final boolean hasStableIds() {
        return true;
    }
}
