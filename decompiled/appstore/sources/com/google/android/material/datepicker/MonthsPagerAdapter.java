package com.google.android.material.datepicker;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.core.view.ViewCompat;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.material.R;

/* JADX INFO: loaded from: classes3.dex */
class MonthsPagerAdapter extends RecyclerView.Adapter {

    @NonNull
    private final CalendarConstraints calendarConstraints;
    private final Context context;
    private final DateSelector<?> dateSelector;
    private final int itemHeight;
    private final MaterialCalendar.OnDayClickListener onDayClickListener;

    public static class ViewHolder extends RecyclerView.ViewHolder {
        final MaterialCalendarGridView monthGrid;
        final TextView monthTitle;

        public ViewHolder(@NonNull LinearLayout r10, boolean r11) {
            super(r10);
            TextView r12 = (TextView) r10.findViewById(R.id.month_title);
            this.monthTitle = r12;
            ViewCompat.q0(r12, true);
            this.monthGrid = (MaterialCalendarGridView) r10.findViewById(R.id.month_grid);
            if (r11 == true) goto L6;
            r12.setVisibility(8);
            return;
        }
    }

    public MonthsPagerAdapter(@NonNull Context r10, DateSelector<?> r11, @NonNull CalendarConstraints r12, MaterialCalendar.OnDayClickListener r13) {
        Month r14 = r12.getStart();
        Month r15 = r12.getEnd();
        Month r16 = r12.getOpenAt();
        if (r14.compareTo2(r16) > 0) goto L15;
        if (r16.compareTo2(r15) > 0) goto L13;
        int r17 = MonthAdapter.MAXIMUM_WEEKS * MaterialCalendar.getDayHeight(r10);
        if (MaterialDatePicker.isFullscreen(r10) == false) goto L9;
        int r18 = MaterialCalendar.getDayHeight(r10);
    L10:
        this.context = r10;
        this.itemHeight = r17 + r18;
        this.calendarConstraints = r12;
        this.dateSelector = r11;
        this.onDayClickListener = r13;
        setHasStableIds(true);
        return;
    L9:
        r18 = 0;
        goto L10
    L13:
        throw new IllegalArgumentException("currentPage cannot be after lastPage");
    L15:
        throw new IllegalArgumentException("firstPage cannot be after currentPage");
    }

    public static /* synthetic */ MaterialCalendar.OnDayClickListener access$000(MonthsPagerAdapter r10) {
        return r10.onDayClickListener;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        return this.calendarConstraints.getMonthSpan();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public long getItemId(int r10) {
        return this.calendarConstraints.getStart().monthsLater(r10).getStableId();
    }

    @NonNull
    public Month getPageMonth(int r10) {
        return this.calendarConstraints.getStart().monthsLater(r10);
    }

    @NonNull
    public CharSequence getPageTitle(int r10) {
        return getPageMonth(r10).getLongName(this.context);
    }

    public int getPosition(@NonNull Month r10) {
        return this.calendarConstraints.getStart().monthsUntil(r10);
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
        Month r12 = this.calendarConstraints.getStart().monthsLater(r11);
        r10.monthTitle.setText(r12.getLongName(r10.itemView.getContext()));
        final MaterialCalendarGridView r13 = (MaterialCalendarGridView) r10.monthGrid.findViewById(R.id.month_grid);
        if (r13.getAdapter() != null) goto L5;
    L7:
        MonthAdapter r14 = new MonthAdapter(r12, this.dateSelector, this.calendarConstraints);
        r13.setNumColumns(r12.daysInWeek);
        r13.setAdapter(r14);
    L8:
        r13.setOnItemClickListener(new AnonymousClass1(this, r13));
        return;
    L5:
        if (r12.equals(r13.getAdapter().month) == false) goto L7;
        r13.invalidate();
        r13.getAdapter().updateSelectedStates(r13);
        goto L8
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    @NonNull
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup r10, int r11) {
        LinearLayout r12 = (LinearLayout) LayoutInflater.from(r10.getContext()).inflate(R.layout.mtrl_calendar_month_labeled, r10, false);
        if (MaterialDatePicker.isFullscreen(r10.getContext()) == false) goto L7;
        r12.setLayoutParams(new RecyclerView.LayoutParams(-1, this.itemHeight));
        return new ViewHolder(r12, true);
    L7:
        return new ViewHolder(r12, false);
    }
}
