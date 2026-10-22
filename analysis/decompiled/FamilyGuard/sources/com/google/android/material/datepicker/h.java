package com.google.android.material.datepicker;

import a1.C0415h;
import a1.C0416i;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import java.util.Calendar;
import java.util.Locale;

/* loaded from: classes.dex */
class h extends BaseAdapter {

    /* renamed from: d, reason: collision with root package name */
    private static final int f12676d = 4;

    /* renamed from: a, reason: collision with root package name */
    private final Calendar f12677a;

    /* renamed from: b, reason: collision with root package name */
    private final int f12678b;

    /* renamed from: c, reason: collision with root package name */
    private final int f12679c;

    public h() {
        Calendar calendarI = w.i();
        this.f12677a = calendarI;
        this.f12678b = calendarI.getMaximum(7);
        this.f12679c = calendarI.getFirstDayOfWeek();
    }

    private int b(int i5) {
        int i6 = i5 + this.f12679c;
        int i7 = this.f12678b;
        return i6 > i7 ? i6 - i7 : i6;
    }

    @Override // android.widget.Adapter
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public Integer getItem(int i5) {
        if (i5 >= this.f12678b) {
            return null;
        }
        return Integer.valueOf(b(i5));
    }

    @Override // android.widget.Adapter
    public int getCount() {
        return this.f12678b;
    }

    @Override // android.widget.Adapter
    public long getItemId(int i5) {
        return 0L;
    }

    @Override // android.widget.Adapter
    public View getView(int i5, View view, ViewGroup viewGroup) {
        TextView textView = (TextView) view;
        if (view == null) {
            textView = (TextView) LayoutInflater.from(viewGroup.getContext()).inflate(C0415h.f6878l, viewGroup, false);
        }
        this.f12677a.set(7, b(i5));
        textView.setText(this.f12677a.getDisplayName(7, f12676d, textView.getResources().getConfiguration().locale));
        textView.setContentDescription(String.format(viewGroup.getContext().getString(C0416i.f6896l), this.f12677a.getDisplayName(7, 2, Locale.getDefault())));
        return textView;
    }

    public h(int i5) {
        Calendar calendarI = w.i();
        this.f12677a = calendarI;
        this.f12678b = calendarI.getMaximum(7);
        this.f12679c = i5;
    }
}
