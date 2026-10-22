package com.google.android.material.datepicker;

import android.annotation.SuppressLint;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.android.material.R;
import java.util.Calendar;
import java.util.Locale;

/* JADX INFO: loaded from: classes3.dex */
class DaysOfWeekAdapter extends BaseAdapter {
    private static final int CALENDAR_DAY_STYLE = 0;
    private static final int NARROW_FORMAT = 4;

    @NonNull
    private final Calendar calendar;
    private final int daysInWeek;
    private final int firstDayOfWeek;

    static {
        CALENDAR_DAY_STYLE = 4;
    }

    public DaysOfWeekAdapter() {
        Calendar r10 = UtcDates.getUtcCalendar();
        this.calendar = r10;
        this.daysInWeek = r10.getMaximum(7);
        this.firstDayOfWeek = r10.getFirstDayOfWeek();
    }

    private int positionToDayOfWeek(int r10) {
        int r11 = r10 + this.firstDayOfWeek;
        int r12 = this.daysInWeek;
        if (r11 > r12) goto L5;
        return r11;
    L5:
        return r11 - r12;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        return this.daysInWeek;
    }

    @Override // android.widget.Adapter
    @Nullable
    public /* bridge */ /* synthetic */ Object getItem(int r10) {
        return getItem(r10);
    }

    @Override // android.widget.Adapter
    public long getItemId(int r10) {
        return 0;
    }

    @Override // android.widget.Adapter
    @Nullable
    @SuppressLint({"WrongConstant"})
    public View getView(int r10, @Nullable View r11, @NonNull ViewGroup r12) {
        TextView r13 = (TextView) r11;
        if (r11 != null) goto L5;
        r13 = (TextView) LayoutInflater.from(r12.getContext()).inflate(R.layout.mtrl_calendar_day_of_week, r12, false);
    L5:
        this.calendar.set(7, positionToDayOfWeek(r10));
        Locale r14 = r13.getResources().getConfiguration().locale;
        r13.setText(this.calendar.getDisplayName(7, CALENDAR_DAY_STYLE, r14));
        r13.setContentDescription(String.format(r12.getContext().getString(R.string.mtrl_picker_day_of_week_column_header), new Object[]{this.calendar.getDisplayName(7, 2, Locale.getDefault())}));
        return r13;
    }

    @Override // android.widget.Adapter
    @Nullable
    public Integer getItem(int r10) {
        if (r10 < this.daysInWeek) goto L7;
        return null;
    L7:
        return Integer.valueOf(positionToDayOfWeek(r10));
    }
}
