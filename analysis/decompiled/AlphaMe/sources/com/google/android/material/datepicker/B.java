package com.google.android.material.datepicker;

import android.view.ContextThemeWrapper;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import androidx.recyclerview.widget.RecyclerView;
import com.stepos.alphame.R;
import java.util.Calendar;
import java.util.Iterator;

/* loaded from: classes.dex */
public final class B extends RecyclerView.Adapter {

    /* renamed from: a, reason: collision with root package name */
    public final CalendarConstraints f10594a;

    /* renamed from: b, reason: collision with root package name */
    public final DateSelector f10595b;

    /* renamed from: c, reason: collision with root package name */
    public final DayViewDecorator f10596c;

    /* renamed from: d, reason: collision with root package name */
    public final r f10597d;

    /* renamed from: e, reason: collision with root package name */
    public final int f10598e;

    public B(ContextThemeWrapper contextThemeWrapper, DateSelector dateSelector, CalendarConstraints calendarConstraints, DayViewDecorator dayViewDecorator, o oVar) {
        Month month = calendarConstraints.f10599a;
        Month month2 = calendarConstraints.f10602d;
        if (month.f10657a.compareTo(month2.f10657a) > 0) {
            throw new IllegalArgumentException("firstPage cannot be after currentPage");
        }
        if (month2.f10657a.compareTo(calendarConstraints.f10600b.f10657a) > 0) {
            throw new IllegalArgumentException("currentPage cannot be after lastPage");
        }
        int i4 = y.f10733g;
        int i5 = s.f10704q;
        this.f10598e = (contextThemeWrapper.getResources().getDimensionPixelSize(R.dimen.mtrl_calendar_day_height) * i4) + (MaterialDatePicker.k(android.R.attr.windowFullscreen, contextThemeWrapper) ? contextThemeWrapper.getResources().getDimensionPixelSize(R.dimen.mtrl_calendar_day_height) : 0);
        this.f10594a = calendarConstraints;
        this.f10595b = dateSelector;
        this.f10596c = dayViewDecorator;
        this.f10597d = oVar;
        setHasStableIds(true);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final int getItemCount() {
        return this.f10594a.f10605g;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final long getItemId(int i4) {
        Calendar calendarC = J.c(this.f10594a.f10599a.f10657a);
        calendarC.add(2, i4);
        return new Month(calendarC).f10657a.getTimeInMillis();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final void onBindViewHolder(RecyclerView.ViewHolder viewHolder, int i4) {
        A a4 = (A) viewHolder;
        CalendarConstraints calendarConstraints = this.f10594a;
        Calendar calendarC = J.c(calendarConstraints.f10599a.f10657a);
        calendarC.add(2, i4);
        Month month = new Month(calendarC);
        a4.f10592a.setText(month.g());
        MaterialCalendarGridView materialCalendarGridView = (MaterialCalendarGridView) a4.f10593b.findViewById(R.id.month_grid);
        if (materialCalendarGridView.a() == null || !month.equals(materialCalendarGridView.a().f10735a)) {
            y yVar = new y(month, this.f10595b, calendarConstraints, this.f10596c);
            materialCalendarGridView.setNumColumns(month.f10660d);
            materialCalendarGridView.setAdapter((ListAdapter) yVar);
        } else {
            materialCalendarGridView.invalidate();
            y yVarA = materialCalendarGridView.a();
            Iterator it = yVarA.f10737c.iterator();
            while (it.hasNext()) {
                yVarA.e(materialCalendarGridView, ((Long) it.next()).longValue());
            }
            DateSelector dateSelector = yVarA.f10736b;
            if (dateSelector != null) {
                Iterator it2 = dateSelector.u().iterator();
                while (it2.hasNext()) {
                    yVarA.e(materialCalendarGridView, ((Long) it2.next()).longValue());
                }
                yVarA.f10737c = dateSelector.u();
            }
        }
        materialCalendarGridView.setOnItemClickListener(new z(this, materialCalendarGridView));
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final RecyclerView.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i4) {
        LinearLayout linearLayout = (LinearLayout) LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.mtrl_calendar_month_labeled, viewGroup, false);
        if (!MaterialDatePicker.k(android.R.attr.windowFullscreen, viewGroup.getContext())) {
            return new A(linearLayout, false);
        }
        linearLayout.setLayoutParams(new RecyclerView.LayoutParams(-1, this.f10598e));
        return new A(linearLayout, true);
    }
}
