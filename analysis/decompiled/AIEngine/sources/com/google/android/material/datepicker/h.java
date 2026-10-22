package com.google.android.material.datepicker;

import android.annotation.SuppressLint;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import com.stepos.aiengine.R;
import java.util.Calendar;
import java.util.Locale;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class h extends BaseAdapter {

    /* renamed from: a, reason: collision with root package name */
    public final Calendar f4964a;

    /* renamed from: b, reason: collision with root package name */
    public final int f4965b;

    /* renamed from: c, reason: collision with root package name */
    public final int f4966c;

    public h() {
        Calendar calendarG = s.g(null);
        this.f4964a = calendarG;
        this.f4965b = calendarG.getMaximum(7);
        this.f4966c = calendarG.getFirstDayOfWeek();
    }

    @Override // android.widget.Adapter
    public final int getCount() {
        return this.f4965b;
    }

    @Override // android.widget.Adapter
    public final Object getItem(int i10) {
        int i11 = this.f4965b;
        if (i10 >= i11) {
            return null;
        }
        int i12 = i10 + this.f4966c;
        if (i12 > i11) {
            i12 -= i11;
        }
        return Integer.valueOf(i12);
    }

    @Override // android.widget.Adapter
    public final long getItemId(int i10) {
        return 0L;
    }

    @Override // android.widget.Adapter
    @SuppressLint({"WrongConstant"})
    public final View getView(int i10, View view, ViewGroup viewGroup) {
        TextView textView = (TextView) view;
        if (view == null) {
            textView = (TextView) LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.mtrl_calendar_day_of_week, viewGroup, false);
        }
        int i11 = i10 + this.f4966c;
        int i12 = this.f4965b;
        if (i11 > i12) {
            i11 -= i12;
        }
        Calendar calendar = this.f4964a;
        calendar.set(7, i11);
        textView.setText(calendar.getDisplayName(7, 4, textView.getResources().getConfiguration().locale));
        textView.setContentDescription(String.format(viewGroup.getContext().getString(R.string.mtrl_picker_day_of_week_column_header), calendar.getDisplayName(7, 2, Locale.getDefault())));
        return textView;
    }

    public h(int i10) {
        Calendar calendarG = s.g(null);
        this.f4964a = calendarG;
        this.f4965b = calendarG.getMaximum(7);
        this.f4966c = i10;
    }
}
