package com.google.android.material.datepicker;

import android.view.ContextThemeWrapper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.material.datepicker.MaterialCalendar;
import com.stepos.aiengine.R;
import java.util.Iterator;
import java.util.WeakHashMap;
import v0.d0;
import v0.e0;
import v0.h0;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class o extends RecyclerView.Adapter<a> {

    /* renamed from: a, reason: collision with root package name */
    public final CalendarConstraints f4980a;

    /* renamed from: b, reason: collision with root package name */
    public final DateSelector<?> f4981b;

    /* renamed from: c, reason: collision with root package name */
    public final DayViewDecorator f4982c;

    /* renamed from: d, reason: collision with root package name */
    public final MaterialCalendar.e f4983d;

    /* renamed from: e, reason: collision with root package name */
    public final int f4984e;

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public static class a extends RecyclerView.ViewHolder {

        /* renamed from: a, reason: collision with root package name */
        public final TextView f4985a;

        /* renamed from: b, reason: collision with root package name */
        public final MaterialCalendarGridView f4986b;

        public a(LinearLayout linearLayout, boolean z) {
            super(linearLayout);
            TextView textView = (TextView) linearLayout.findViewById(R.id.month_title);
            this.f4985a = textView;
            WeakHashMap<View, h0> weakHashMap = e0.f13274a;
            new d0(R.id.tag_accessibility_heading, Boolean.class, 0, 28).c(textView, Boolean.TRUE);
            this.f4986b = (MaterialCalendarGridView) linearLayout.findViewById(R.id.month_grid);
            if (z) {
                return;
            }
            textView.setVisibility(8);
        }
    }

    public o(ContextThemeWrapper contextThemeWrapper, DateSelector dateSelector, CalendarConstraints calendarConstraints, DayViewDecorator dayViewDecorator, MaterialCalendar.e eVar) {
        Month start = calendarConstraints.getStart();
        Month end = calendarConstraints.getEnd();
        Month openAt = calendarConstraints.getOpenAt();
        if (start.compareTo(openAt) > 0) {
            throw new IllegalArgumentException("firstPage cannot be after currentPage");
        }
        if (openAt.compareTo(end) > 0) {
            throw new IllegalArgumentException("currentPage cannot be after lastPage");
        }
        this.f4984e = (MaterialCalendar.getDayHeight(contextThemeWrapper) * m.f4971j) + (MaterialDatePicker.isFullscreen(contextThemeWrapper) ? MaterialCalendar.getDayHeight(contextThemeWrapper) : 0);
        this.f4980a = calendarConstraints;
        this.f4981b = dateSelector;
        this.f4982c = dayViewDecorator;
        this.f4983d = eVar;
        setHasStableIds(true);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final int getItemCount() {
        return this.f4980a.getMonthSpan();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final long getItemId(int i10) {
        return this.f4980a.getStart().monthsLater(i10).getStableId();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final void onBindViewHolder(RecyclerView.ViewHolder viewHolder, int i10) {
        a aVar = (a) viewHolder;
        CalendarConstraints calendarConstraints = this.f4980a;
        Month monthMonthsLater = calendarConstraints.getStart().monthsLater(i10);
        aVar.f4985a.setText(monthMonthsLater.getLongName());
        MaterialCalendarGridView materialCalendarGridView = (MaterialCalendarGridView) aVar.f4986b.findViewById(R.id.month_grid);
        if (materialCalendarGridView.a() == null || !monthMonthsLater.equals(materialCalendarGridView.a().f4973a)) {
            m mVar = new m(monthMonthsLater, this.f4981b, calendarConstraints, this.f4982c);
            materialCalendarGridView.setNumColumns(monthMonthsLater.daysInWeek);
            materialCalendarGridView.setAdapter((ListAdapter) mVar);
        } else {
            materialCalendarGridView.invalidate();
            m mVarA = materialCalendarGridView.a();
            DateSelector<?> dateSelector = mVarA.f4974b;
            Iterator<Long> it = mVarA.f4975c.iterator();
            while (it.hasNext()) {
                mVarA.f(materialCalendarGridView, it.next().longValue());
            }
            if (dateSelector != null) {
                Iterator<Long> it2 = dateSelector.getSelectedDays().iterator();
                while (it2.hasNext()) {
                    mVarA.f(materialCalendarGridView, it2.next().longValue());
                }
                mVarA.f4975c = dateSelector.getSelectedDays();
            }
        }
        materialCalendarGridView.setOnItemClickListener(new n(this, materialCalendarGridView));
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final RecyclerView.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i10) {
        LinearLayout linearLayout = (LinearLayout) LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.mtrl_calendar_month_labeled, viewGroup, false);
        if (!MaterialDatePicker.isFullscreen(viewGroup.getContext())) {
            return new a(linearLayout, false);
        }
        linearLayout.setLayoutParams(new RecyclerView.LayoutParams(-1, this.f4984e));
        return new a(linearLayout, true);
    }
}
