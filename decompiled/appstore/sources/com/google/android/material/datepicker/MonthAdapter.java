package com.google.android.material.datepicker;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.android.material.R;
import com.google.android.material.timepicker.TimeModel;
import java.util.Collection;
import java.util.Iterator;

/* JADX INFO: loaded from: classes3.dex */
class MonthAdapter extends BaseAdapter {
    static final int MAXIMUM_WEEKS = 0;
    final CalendarConstraints calendarConstraints;
    CalendarStyle calendarStyle;
    final DateSelector<?> dateSelector;
    final Month month;
    private Collection<Long> previouslySelectedDates;

    static {
        MAXIMUM_WEEKS = UtcDates.getUtcCalendar().getMaximum(4);
    }

    public MonthAdapter(Month r10, DateSelector<?> r11, CalendarConstraints r12) {
        this.month = r10;
        this.dateSelector = r11;
        this.calendarConstraints = r12;
        this.previouslySelectedDates = r11.getSelectedDays();
    }

    private void initializeStyles(Context r10) {
        if (this.calendarStyle != null) goto L6;
        this.calendarStyle = new CalendarStyle(r10);
        return;
    }

    private boolean isSelected(long r10) {
        Iterator<Long> r11 = this.dateSelector.getSelectedDays().iterator();
    L4:
        if (r11.hasNext() == false) goto L9;
        long r12 = r11.next().longValue();
        if (UtcDates.canonicalYearMonthDay(r10) != UtcDates.canonicalYearMonthDay(r12)) goto L4;
        return true;
    L9:
        return false;
    }

    private void updateSelectedState(@Nullable TextView r10, long r11) {
        if (r10 != null) goto L5;
        return;
    L5:
        if (this.calendarConstraints.getDateValidator().isValid(r11) == false) goto L13;
        r10.setEnabled(true);
        if (isSelected(r11) == false) goto L10;
        CalendarItemStyle r12 = this.calendarStyle.selectedDay;
    L14:
        r12.styleItem(r10);
        return;
    L10:
        if (UtcDates.getTodayCalendar().getTimeInMillis() != r11) goto L12;
        r12 = this.calendarStyle.todayDay;
        goto L14
    L12:
        r12 = this.calendarStyle.day;
        goto L14
    L13:
        r10.setEnabled(false);
        r12 = this.calendarStyle.invalidDay;
        goto L14
    }

    private void updateSelectedStateForDate(MaterialCalendarGridView r10, long r11) {
        if (Month.create(r11).equals(this.month) == false) goto L6;
        int r12 = this.month.getDayOfMonth(r11);
        updateSelectedState((TextView) r10.getChildAt(r10.getAdapter().dayToPosition(r12) - r10.getFirstVisiblePosition()), r11);
        return;
    }

    public int dayToPosition(int r10) {
        return firstPositionInMonth() + (r10 - 1);
    }

    public int firstPositionInMonth() {
        return this.month.daysFromStartOfWeekToFirstOfMonth();
    }

    @Override // android.widget.Adapter
    public int getCount() {
        return this.month.daysInMonth + firstPositionInMonth();
    }

    @Override // android.widget.Adapter
    @Nullable
    public /* bridge */ /* synthetic */ Object getItem(int r10) {
        return getItem(r10);
    }

    @Override // android.widget.Adapter
    public long getItemId(int r10) {
        return r10 / this.month.daysInWeek;
    }

    @Override // android.widget.Adapter
    @NonNull
    public /* bridge */ /* synthetic */ View getView(int r10, @Nullable View r11, @NonNull ViewGroup r12) {
        return getView(r10, r11, r12);
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public boolean hasStableIds() {
        return true;
    }

    public boolean isFirstInRow(int r10) {
        if ((r10 % this.month.daysInWeek) != 0) goto L5;
        return true;
    L5:
        return false;
    }

    public boolean isLastInRow(int r10) {
        if (((r10 + 1) % this.month.daysInWeek) == 0) goto L7;
        return false;
    L7:
        return true;
    }

    public int lastPositionInMonth() {
        return (this.month.daysFromStartOfWeekToFirstOfMonth() + this.month.daysInMonth) - 1;
    }

    public int positionToDay(int r10) {
        return (r10 - this.month.daysFromStartOfWeekToFirstOfMonth()) + 1;
    }

    public void updateSelectedStates(MaterialCalendarGridView r10) {
        Iterator<Long> r11 = this.previouslySelectedDates.iterator();
    L4:
        if (r11.hasNext() == false) goto L6;
        updateSelectedStateForDate(r10, r11.next().longValue());
        goto L4
    L6:
        DateSelector<?> r12 = this.dateSelector;
        if (r12 == null) goto L16;
        Iterator<Long> r13 = r12.getSelectedDays().iterator();
    L10:
        if (r13.hasNext() == false) goto L12;
        updateSelectedStateForDate(r10, r13.next().longValue());
        goto L10
    L12:
        this.previouslySelectedDates = this.dateSelector.getSelectedDays();
        return;
    }

    public boolean withinMonth(int r10) {
        if (r10 >= firstPositionInMonth()) goto L5;
    L7:
        return false;
    L5:
        if (r10 > lastPositionInMonth()) goto L7;
        return true;
    }

    @Override // android.widget.Adapter
    @Nullable
    public Long getItem(int r10) {
        if (r10 >= this.month.daysFromStartOfWeekToFirstOfMonth()) goto L5;
        return null;
    L5:
        if (r10 <= lastPositionInMonth()) goto L8;
        return null;
    L8:
        return Long.valueOf(this.month.getDay(positionToDay(r10)));
    }

    @Override // android.widget.Adapter
    @NonNull
    public TextView getView(int r10, @Nullable View r11, @NonNull ViewGroup r12) {
        initializeStyles(r12.getContext());
        TextView r13 = (TextView) r11;
        if (r11 != null) goto L5;
        r13 = (TextView) LayoutInflater.from(r12.getContext()).inflate(R.layout.mtrl_calendar_day, r12, false);
    L5:
        int r14 = r10 - firstPositionInMonth();
        if (r14 < 0) goto L15;
        Month r15 = this.month;
        if (r14 >= r15.daysInMonth) goto L15;
        int r16 = r14 + 1;
        r13.setTag(r15);
        r13.setText(String.format(r13.getResources().getConfiguration().locale, TimeModel.NUMBER_FORMAT, new Object[]{Integer.valueOf(r16)}));
        long r17 = this.month.getDay(r16);
        if (this.month.year != Month.current().year) goto L13;
        r13.setContentDescription(DateStrings.getMonthDayOfWeekDay(r17));
    L14:
        r13.setVisibility(0);
        r13.setEnabled(true);
    L16:
        Long r18 = getItem(r10);
        if (r18 != null) goto L19;
        return r13;
    L19:
        updateSelectedState(r13, r18.longValue());
        return r13;
    L13:
        r13.setContentDescription(DateStrings.getYearMonthDayOfWeekDay(r17));
    L15:
        r13.setVisibility(8);
        r13.setEnabled(false);
        goto L16
    }
}
