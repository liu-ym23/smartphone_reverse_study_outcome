package com.google.android.material.datepicker;

import android.view.ContextThemeWrapper;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import androidx.recyclerview.widget.RecyclerView;
import com.stepos.ability.R;
import java.util.Iterator;

/* loaded from: classes3.dex */
public final class G extends RecyclerView.Adapter {

    /* renamed from: a, reason: collision with root package name */
    public final CalendarConstraints f2413a;
    public final DateSelector b;
    public final DayViewDecorator c;
    public final C0915s d;
    public final int e;

    public G(ContextThemeWrapper contextThemeWrapper, DateSelector dateSelector, CalendarConstraints calendarConstraints, DayViewDecorator dayViewDecorator, C0915s c0915s) {
        Month start = calendarConstraints.getStart();
        Month end = calendarConstraints.getEnd();
        Month openAt = calendarConstraints.getOpenAt();
        if (start.compareTo(openAt) > 0) {
            throw new IllegalArgumentException("firstPage cannot be after currentPage");
        }
        if (openAt.compareTo(end) > 0) {
            throw new IllegalArgumentException("currentPage cannot be after lastPage");
        }
        this.e = (contextThemeWrapper.getResources().getDimensionPixelSize(R.dimen.mtrl_calendar_day_height) * D.g) + (A.d(android.R.attr.windowFullscreen, contextThemeWrapper) ? contextThemeWrapper.getResources().getDimensionPixelSize(R.dimen.mtrl_calendar_day_height) : 0);
        this.f2413a = calendarConstraints;
        this.b = dateSelector;
        this.c = dayViewDecorator;
        this.d = c0915s;
        setHasStableIds(true);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final int getItemCount() {
        return this.f2413a.getMonthSpan();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final long getItemId(int i) {
        return this.f2413a.getStart().monthsLater(i).getStableId();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final void onBindViewHolder(RecyclerView.ViewHolder viewHolder, int i) {
        F f = (F) viewHolder;
        CalendarConstraints calendarConstraints = this.f2413a;
        Month monthMonthsLater = calendarConstraints.getStart().monthsLater(i);
        f.f2412a.setText(monthMonthsLater.getLongName());
        MaterialCalendarGridView materialCalendarGridView = (MaterialCalendarGridView) f.b.findViewById(R.id.month_grid);
        if (materialCalendarGridView.a() == null || !monthMonthsLater.equals(materialCalendarGridView.a().f2410a)) {
            D d = new D(monthMonthsLater, this.b, calendarConstraints, this.c);
            materialCalendarGridView.setNumColumns(monthMonthsLater.daysInWeek);
            materialCalendarGridView.setAdapter((ListAdapter) d);
        } else {
            materialCalendarGridView.invalidate();
            D dA = materialCalendarGridView.a();
            DateSelector dateSelector = dA.b;
            Iterator it = dA.c.iterator();
            while (it.hasNext()) {
                dA.e(materialCalendarGridView, ((Long) it.next()).longValue());
            }
            if (dateSelector != null) {
                Iterator<Long> it2 = dateSelector.getSelectedDays().iterator();
                while (it2.hasNext()) {
                    dA.e(materialCalendarGridView, it2.next().longValue());
                }
                dA.c = dateSelector.getSelectedDays();
            }
        }
        materialCalendarGridView.setOnItemClickListener(new E(this, materialCalendarGridView));
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final RecyclerView.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        LinearLayout linearLayout = (LinearLayout) LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.mtrl_calendar_month_labeled, viewGroup, false);
        if (!A.d(android.R.attr.windowFullscreen, viewGroup.getContext())) {
            return new F(linearLayout, false);
        }
        linearLayout.setLayoutParams(new RecyclerView.LayoutParams(-1, this.e));
        return new F(linearLayout, true);
    }
}
