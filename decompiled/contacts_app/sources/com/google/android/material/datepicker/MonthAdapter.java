package com.google.android.material.datepicker;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import androidx.core.util.Pair;
import com.google.android.material.R;
import com.google.android.material.timepicker.TimeModel;
import java.util.Collection;
import java.util.Iterator;

/* JADX INFO: loaded from: classes2.dex */
class MonthAdapter extends BaseAdapter {
    private static final int MAXIMUM_GRID_CELLS = 0;
    static final int MAXIMUM_WEEKS = 0;
    private static final int NO_DAY_NUMBER = -1;
    final CalendarConstraints calendarConstraints;
    CalendarStyle calendarStyle;
    final DateSelector<?> dateSelector;
    final DayViewDecorator dayViewDecorator;
    final Month month;
    private Collection<Long> previouslySelectedDates;

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public boolean hasStableIds() {
        return true;
    }

    @Override // android.widget.Adapter
    public /* bridge */ /* synthetic */ Object getItem(int r1) {
        return getItem(r1);
    }

    @Override // android.widget.Adapter
    public /* bridge */ /* synthetic */ View getView(int r1, View r2, ViewGroup r3) {
        return getView(r1, r2, r3);
    }

    static {
        MAXIMUM_WEEKS = UtcDates.getUtcCalendar().getMaximum(4);
        MAXIMUM_GRID_CELLS = (UtcDates.getUtcCalendar().getMaximum(5) + UtcDates.getUtcCalendar().getMaximum(7)) - 1;
    }

    MonthAdapter(Month r1, DateSelector<?> r2, CalendarConstraints r3, DayViewDecorator r4) {
        this.month = r1;
        this.dateSelector = r2;
        this.calendarConstraints = r3;
        this.dayViewDecorator = r4;
        this.previouslySelectedDates = r2.getSelectedDays();
    }

    @Override // android.widget.Adapter
    public Long getItem(int r2) {
        if (r2 >= firstPositionInMonth()) goto L5;
        return null;
    L5:
        if (r2 <= lastPositionInMonth()) goto L8;
        return null;
    L8:
        return Long.valueOf(this.month.getDay(positionToDay(r2)));
    }

    @Override // android.widget.Adapter
    public long getItemId(int r1) {
        return r1 / this.month.daysInWeek;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        return MAXIMUM_GRID_CELLS;
    }

    @Override // android.widget.Adapter
    public TextView getView(int r6, View r7, ViewGroup r8) {
        initializeStyles(r8.getContext());
        TextView r0 = (TextView) r7;
        if (r7 != null) goto L5;
        r0 = (TextView) LayoutInflater.from(r8.getContext()).inflate(R.layout.mtrl_calendar_day, r8, false);
    L5:
        int r9 = r6 - firstPositionInMonth();
        if (r9 >= 0) goto L8;
    L11:
        r0.setVisibility(8);
        r0.setEnabled(false);
        int r10 = -1;
    L12:
        Long r11 = getItem(r6);
        if (r11 != null) goto L15;
        return r0;
    L15:
        updateSelectedState(r0, r11.longValue(), r10);
        return r0;
    L8:
        if (r9 >= this.month.daysInMonth) goto L11;
        r10 = r9 + 1;
        r0.setTag(this.month);
        r0.setText(String.format(r0.getResources().getConfiguration().locale, TimeModel.NUMBER_FORMAT, new Object[]{Integer.valueOf(r10)}));
        r0.setVisibility(0);
        r0.setEnabled(true);
        goto L12
    }

    public void updateSelectedStates(MaterialCalendarGridView r4) {
        Iterator<Long> r0 = this.previouslySelectedDates.iterator();
    L4:
        if (r0.hasNext() == false) goto L6;
        updateSelectedStateForDate(r4, r0.next().longValue());
        goto L4
    L6:
        DateSelector<?> r1 = this.dateSelector;
        if (r1 == null) goto L16;
        Iterator<Long> r2 = r1.getSelectedDays().iterator();
    L10:
        if (r2.hasNext() == false) goto L12;
        updateSelectedStateForDate(r4, r2.next().longValue());
        goto L10
    L12:
        this.previouslySelectedDates = this.dateSelector.getSelectedDays();
        return;
    }

    private void updateSelectedStateForDate(MaterialCalendarGridView r4, long r5) {
        if (Month.create(r5).equals(this.month) == false) goto L6;
        int r0 = this.month.getDayOfMonth(r5);
        updateSelectedState((TextView) r4.getChildAt(r4.getAdapter().dayToPosition(r0) - r4.getFirstVisiblePosition()), r5, r0);
        return;
    }

    private void updateSelectedState(TextView r19, long r20, int r22) {
        if (r19 != null) goto L5;
        return;
    L5:
        Context r9 = r19.getContext();
        String r10 = getDayContentDescription(r9, r20);
        r19.setContentDescription(r10);
        boolean r11 = this.calendarConstraints.getDateValidator().isValid(r20);
        if (r11 == false) goto L15;
        r19.setEnabled(true);
        boolean r4 = isSelected(r20);
        r19.setSelected(r4);
        if (r4 == false) goto L12;
        CalendarItemStyle r2 = this.calendarStyle.selectedDay;
    L10:
        CalendarItemStyle r12 = r2;
        boolean r13 = r4;
    L17:
        if (this.dayViewDecorator != null) goto L19;
    L21:
        r12.styleItem(r19);
        return;
    L19:
        if (r22 == (-1)) goto L21;
        int r15 = this.month.year;
        int r8 = this.month.month;
        boolean r14 = r13;
        r12.styleItem(r19, this.dayViewDecorator.getBackgroundColor(r9, r15, r8, r22, r11, r14));
        Drawable r16 = this.dayViewDecorator.getCompoundDrawableLeft(r9, r15, r8, r22, r11, r14);
        Drawable r17 = this.dayViewDecorator.getCompoundDrawableTop(r9, r15, r8, r22, r11, r14);
        Drawable r18 = this.dayViewDecorator.getCompoundDrawableRight(r9, r15, r8, r22, r11, r13);
        boolean r21 = r13;
        r19.setCompoundDrawables(r16, r17, r18, this.dayViewDecorator.getCompoundDrawableBottom(r9, r15, r8, r22, r11, r21));
        r19.setContentDescription(this.dayViewDecorator.getContentDescription(r9, r15, r8, r22, r11, r21, r10));
        return;
    L12:
        if (isToday(r20) == false) goto L14;
        r2 = this.calendarStyle.todayDay;
        goto L10
    L14:
        r2 = this.calendarStyle.day;
        goto L10
    L15:
        r19.setEnabled(false);
        r13 = false;
        r12 = this.calendarStyle.invalidDay;
        goto L17
    }

    private String getDayContentDescription(Context r7, long r8) {
        return DateStrings.getDayContentDescription(r7, r8, isToday(r8), isStartOfRange(r8), isEndOfRange(r8));
    }

    private boolean isToday(long r3) {
        if (UtcDates.getTodayCalendar().getTimeInMillis() != r3) goto L5;
        return true;
    L5:
        return false;
    }

    boolean isStartOfRange(long r3) {
        Iterator<Pair<Long, Long>> r2 = this.dateSelector.getSelectedRanges().iterator();
    L4:
        if (r2.hasNext() == false) goto L11;
        Pair<Long, Long> r0 = r2.next();
        if (r0.first == null) goto L4;
        if (r0.first.longValue() != r3) goto L4;
        return true;
    L11:
        return false;
    }

    boolean isEndOfRange(long r3) {
        Iterator<Pair<Long, Long>> r2 = this.dateSelector.getSelectedRanges().iterator();
    L4:
        if (r2.hasNext() == false) goto L11;
        Pair<Long, Long> r0 = r2.next();
        if (r0.second == null) goto L4;
        if (r0.second.longValue() != r3) goto L4;
        return true;
    L11:
        return false;
    }

    private boolean isSelected(long r5) {
        Iterator<Long> r4 = this.dateSelector.getSelectedDays().iterator();
    L4:
        if (r4.hasNext() == false) goto L9;
        long r0 = r4.next().longValue();
        if (UtcDates.canonicalYearMonthDay(r5) != UtcDates.canonicalYearMonthDay(r0)) goto L4;
        return true;
    L9:
        return false;
    }

    private void initializeStyles(Context r2) {
        if (this.calendarStyle != null) goto L6;
        this.calendarStyle = new CalendarStyle(r2);
        return;
    }

    int firstPositionInMonth() {
        return this.month.daysFromStartOfWeekToFirstOfMonth(this.calendarConstraints.getFirstDayOfWeek());
    }

    int lastPositionInMonth() {
        return (firstPositionInMonth() + this.month.daysInMonth) - 1;
    }

    int positionToDay(int r1) {
        return (r1 - firstPositionInMonth()) + 1;
    }

    int dayToPosition(int r1) {
        return firstPositionInMonth() + (r1 - 1);
    }

    boolean withinMonth(int r2) {
        if (r2 >= firstPositionInMonth()) goto L5;
    L7:
        return false;
    L5:
        if (r2 > lastPositionInMonth()) goto L7;
        return true;
    }

    boolean isFirstInRow(int r1) {
        if ((r1 % this.month.daysInWeek) != 0) goto L5;
        return true;
    L5:
        return false;
    }

    boolean isLastInRow(int r2) {
        if (((r2 + 1) % this.month.daysInWeek) == 0) goto L7;
        return false;
    L7:
        return true;
    }
}
