package com.google.android.material.datepicker;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.material.R;
import com.google.android.material.timepicker.TimeModel;
import java.util.Calendar;
import java.util.Iterator;
import java.util.Locale;

/* JADX INFO: loaded from: classes3.dex */
class YearGridAdapter extends RecyclerView.Adapter {
    private final MaterialCalendar<?> materialCalendar;

    public static class ViewHolder extends RecyclerView.ViewHolder {
        final TextView textView;

        public ViewHolder(TextView r10) {
            super(r10);
            this.textView = r10;
        }
    }

    public YearGridAdapter(MaterialCalendar<?> r10) {
        this.materialCalendar = r10;
    }

    public static /* synthetic */ MaterialCalendar access$000(YearGridAdapter r10) {
        return r10.materialCalendar;
    }

    @NonNull
    private View.OnClickListener createYearClickListener(final int r10) {
        return new AnonymousClass1(this, r10);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        return this.materialCalendar.getCalendarConstraints().getYearSpan();
    }

    public int getPositionForYear(int r10) {
        return r10 - this.materialCalendar.getCalendarConstraints().getStart().year;
    }

    public int getYearForPosition(int r10) {
        return this.materialCalendar.getCalendarConstraints().getStart().year + r10;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public /* bridge */ /* synthetic */ void onBindViewHolder(@NonNull RecyclerView.ViewHolder r10, int r11) {
        onBindViewHolder((ViewHolder) r10, r11);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    @NonNull
    public /* bridge */ /* synthetic */ RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup r10, int r11) {
        return onCreateViewHolder(r10, r11);
    }

    public void onBindViewHolder(@NonNull ViewHolder r10, int r11) {
        int r12 = getYearForPosition(r11);
        String r13 = r10.textView.getContext().getString(R.string.mtrl_picker_navigate_to_year_description);
        r10.textView.setText(String.format(Locale.getDefault(), TimeModel.NUMBER_FORMAT, new Object[]{Integer.valueOf(r12)}));
        r10.textView.setContentDescription(String.format(r13, new Object[]{Integer.valueOf(r12)}));
        CalendarStyle r14 = this.materialCalendar.getCalendarStyle();
        Calendar r15 = UtcDates.getTodayCalendar();
        if (r15.get(1) != r12) goto L5;
        CalendarItemStyle r16 = r14.todayYear;
    L6:
        Iterator<Long> r17 = this.materialCalendar.getDateSelector().getSelectedDays().iterator();
    L8:
        if (r17.hasNext() == false) goto L12;
        r15.setTimeInMillis(r17.next().longValue());
        if (r15.get(1) != r12) goto L8;
        r16 = r14.selectedYear;
        goto L8
    L12:
        r16.styleItem(r10.textView);
        r10.textView.setOnClickListener(createYearClickListener(r12));
        return;
    L5:
        r16 = r14.year;
        goto L6
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    @NonNull
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup r10, int r11) {
        return new ViewHolder((TextView) LayoutInflater.from(r10.getContext()).inflate(R.layout.mtrl_calendar_year, r10, false));
    }
}
