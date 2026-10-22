package com.google.android.material.datepicker;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import com.stepos.alphame.R;
import java.util.Calendar;
import java.util.Locale;

/* renamed from: com.google.android.material.datepicker.j, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C0431j extends BaseAdapter {

    /* renamed from: a, reason: collision with root package name */
    public final Calendar f10686a;

    /* renamed from: b, reason: collision with root package name */
    public final int f10687b;

    /* renamed from: c, reason: collision with root package name */
    public final int f10688c;

    public C0431j() {
        Calendar calendarG = J.g(null);
        this.f10686a = calendarG;
        this.f10687b = calendarG.getMaximum(7);
        this.f10688c = calendarG.getFirstDayOfWeek();
    }

    @Override // android.widget.Adapter
    public final int getCount() {
        return this.f10687b;
    }

    @Override // android.widget.Adapter
    public final Object getItem(int i4) {
        int i5 = this.f10687b;
        if (i4 >= i5) {
            return null;
        }
        int i6 = i4 + this.f10688c;
        if (i6 > i5) {
            i6 -= i5;
        }
        return Integer.valueOf(i6);
    }

    @Override // android.widget.Adapter
    public final long getItemId(int i4) {
        return 0L;
    }

    @Override // android.widget.Adapter
    public final View getView(int i4, View view, ViewGroup viewGroup) {
        TextView textView = (TextView) view;
        if (view == null) {
            textView = (TextView) LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.mtrl_calendar_day_of_week, viewGroup, false);
        }
        int i5 = i4 + this.f10688c;
        int i6 = this.f10687b;
        if (i5 > i6) {
            i5 -= i6;
        }
        Calendar calendar = this.f10686a;
        calendar.set(7, i5);
        textView.setText(calendar.getDisplayName(7, 4, textView.getResources().getConfiguration().locale));
        textView.setContentDescription(String.format(viewGroup.getContext().getString(R.string.mtrl_picker_day_of_week_column_header), calendar.getDisplayName(7, 2, Locale.getDefault())));
        return textView;
    }

    public C0431j(int i4) {
        Calendar calendarG = J.g(null);
        this.f10686a = calendarG;
        this.f10687b = calendarG.getMaximum(7);
        this.f10688c = i4;
    }
}
