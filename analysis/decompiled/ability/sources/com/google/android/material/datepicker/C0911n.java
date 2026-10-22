package com.google.android.material.datepicker;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import com.stepos.ability.R;
import java.util.Calendar;
import java.util.Locale;

/* renamed from: com.google.android.material.datepicker.n, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public final class C0911n extends BaseAdapter {

    /* renamed from: a, reason: collision with root package name */
    public final Calendar f2430a;
    public final int b;
    public final int c;

    public C0911n() {
        Calendar calendarG = O.g(null);
        this.f2430a = calendarG;
        this.b = calendarG.getMaximum(7);
        this.c = calendarG.getFirstDayOfWeek();
    }

    @Override // android.widget.Adapter
    public final int getCount() {
        return this.b;
    }

    @Override // android.widget.Adapter
    public final Object getItem(int i) {
        int i6 = this.b;
        if (i >= i6) {
            return null;
        }
        int i10 = i + this.c;
        if (i10 > i6) {
            i10 -= i6;
        }
        return Integer.valueOf(i10);
    }

    @Override // android.widget.Adapter
    public final long getItemId(int i) {
        return 0L;
    }

    @Override // android.widget.Adapter
    public final View getView(int i, View view, ViewGroup viewGroup) {
        TextView textView = (TextView) view;
        if (view == null) {
            textView = (TextView) LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.mtrl_calendar_day_of_week, viewGroup, false);
        }
        int i6 = i + this.c;
        int i10 = this.b;
        if (i6 > i10) {
            i6 -= i10;
        }
        Calendar calendar = this.f2430a;
        calendar.set(7, i6);
        textView.setText(calendar.getDisplayName(7, 4, textView.getResources().getConfiguration().locale));
        textView.setContentDescription(String.format(viewGroup.getContext().getString(R.string.mtrl_picker_day_of_week_column_header), calendar.getDisplayName(7, 2, Locale.getDefault())));
        return textView;
    }

    public C0911n(int i) {
        Calendar calendarG = O.g(null);
        this.f2430a = calendarG;
        this.b = calendarG.getMaximum(7);
        this.c = i;
    }
}
