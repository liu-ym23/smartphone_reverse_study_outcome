package com.google.android.material.datepicker;

import android.annotation.SuppressLint;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import com.google.android.material.R$layout;
import com.google.android.material.R$string;
import java.util.Calendar;
import java.util.Locale;

/* loaded from: classes2.dex */
public class i extends BaseAdapter {

    /* renamed from: d, reason: collision with root package name */
    public static final int f20789d = 4;

    /* renamed from: a, reason: collision with root package name */
    public final Calendar f20790a;

    /* renamed from: b, reason: collision with root package name */
    public final int f20791b;

    /* renamed from: c, reason: collision with root package name */
    public final int f20792c;

    public i() {
        Calendar calendarN = v.n();
        this.f20790a = calendarN;
        this.f20791b = calendarN.getMaximum(7);
        this.f20792c = calendarN.getFirstDayOfWeek();
    }

    @Override // android.widget.Adapter
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public Integer getItem(int i10) {
        if (i10 >= this.f20791b) {
            return null;
        }
        return Integer.valueOf(b(i10));
    }

    public final int b(int i10) {
        int i11 = i10 + this.f20792c;
        int i12 = this.f20791b;
        return i11 > i12 ? i11 - i12 : i11;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        return this.f20791b;
    }

    @Override // android.widget.Adapter
    public long getItemId(int i10) {
        return 0L;
    }

    @Override // android.widget.Adapter
    @SuppressLint({"WrongConstant"})
    public View getView(int i10, View view, ViewGroup viewGroup) {
        TextView textView = (TextView) view;
        if (view == null) {
            textView = (TextView) LayoutInflater.from(viewGroup.getContext()).inflate(R$layout.mtrl_calendar_day_of_week, viewGroup, false);
        }
        this.f20790a.set(7, b(i10));
        textView.setText(this.f20790a.getDisplayName(7, f20789d, textView.getResources().getConfiguration().locale));
        textView.setContentDescription(String.format(viewGroup.getContext().getString(R$string.mtrl_picker_day_of_week_column_header), this.f20790a.getDisplayName(7, 2, Locale.getDefault())));
        return textView;
    }

    public i(int i10) {
        Calendar calendarN = v.n();
        this.f20790a = calendarN;
        this.f20791b = calendarN.getMaximum(7);
        this.f20792c = i10;
    }
}
