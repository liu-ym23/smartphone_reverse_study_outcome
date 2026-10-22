package com.google.android.material.datepicker;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.TextView;
import androidx.core.view.N;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.material.R$id;
import com.google.android.material.R$layout;
import com.google.android.material.datepicker.MaterialCalendar;

/* loaded from: classes2.dex */
public class q extends RecyclerView.Adapter<b> {

    /* renamed from: a, reason: collision with root package name */
    public final CalendarConstraints f20848a;

    /* renamed from: b, reason: collision with root package name */
    public final DateSelector<?> f20849b;

    /* renamed from: c, reason: collision with root package name */
    public final DayViewDecorator f20850c;

    /* renamed from: d, reason: collision with root package name */
    public final MaterialCalendar.l f20851d;

    /* renamed from: e, reason: collision with root package name */
    public final int f20852e;

    public class a implements AdapterView.OnItemClickListener {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ MaterialCalendarGridView f20853a;

        public a(MaterialCalendarGridView materialCalendarGridView) {
            this.f20853a = materialCalendarGridView;
        }

        @Override // android.widget.AdapterView.OnItemClickListener
        public void onItemClick(AdapterView<?> adapterView, View view, int i10, long j10) {
            if (this.f20853a.getAdapter().r(i10)) {
                q.this.f20851d.a(this.f20853a.getAdapter().getItem(i10).longValue());
            }
        }
    }

    public static class b extends RecyclerView.ViewHolder {

        /* renamed from: a, reason: collision with root package name */
        public final TextView f20855a;

        /* renamed from: c, reason: collision with root package name */
        public final MaterialCalendarGridView f20856c;

        public b(LinearLayout linearLayout, boolean z10) {
            super(linearLayout);
            TextView textView = (TextView) linearLayout.findViewById(R$id.month_title);
            this.f20855a = textView;
            N.j0(textView, true);
            this.f20856c = (MaterialCalendarGridView) linearLayout.findViewById(R$id.month_grid);
            if (z10) {
                return;
            }
            textView.setVisibility(8);
        }
    }

    public q(Context context, DateSelector<?> dateSelector, CalendarConstraints calendarConstraints, DayViewDecorator dayViewDecorator, MaterialCalendar.l lVar) {
        Month start = calendarConstraints.getStart();
        Month end = calendarConstraints.getEnd();
        Month openAt = calendarConstraints.getOpenAt();
        if (start.compareTo(openAt) > 0) {
            throw new IllegalArgumentException("firstPage cannot be after currentPage");
        }
        if (openAt.compareTo(end) > 0) {
            throw new IllegalArgumentException("currentPage cannot be after lastPage");
        }
        this.f20852e = (p.f20840g * MaterialCalendar.F(context)) + (m.B(context) ? MaterialCalendar.F(context) : 0);
        this.f20848a = calendarConstraints;
        this.f20849b = dateSelector;
        this.f20850c = dayViewDecorator;
        this.f20851d = lVar;
        setHasStableIds(true);
    }

    public Month d(int i10) {
        return this.f20848a.getStart().monthsLater(i10);
    }

    public CharSequence e(int i10) {
        return d(i10).getLongName();
    }

    public int f(Month month) {
        return this.f20848a.getStart().monthsUntil(month);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: g, reason: merged with bridge method [inline-methods] */
    public void onBindViewHolder(b bVar, int i10) {
        Month monthMonthsLater = this.f20848a.getStart().monthsLater(i10);
        bVar.f20855a.setText(monthMonthsLater.getLongName());
        MaterialCalendarGridView materialCalendarGridView = (MaterialCalendarGridView) bVar.f20856c.findViewById(R$id.month_grid);
        if (materialCalendarGridView.getAdapter() == null || !monthMonthsLater.equals(materialCalendarGridView.getAdapter().f20842a)) {
            p pVar = new p(monthMonthsLater, this.f20849b, this.f20848a, this.f20850c);
            materialCalendarGridView.setNumColumns(monthMonthsLater.daysInWeek);
            materialCalendarGridView.setAdapter((ListAdapter) pVar);
        } else {
            materialCalendarGridView.invalidate();
            materialCalendarGridView.getAdapter().q(materialCalendarGridView);
        }
        materialCalendarGridView.setOnItemClickListener(new a(materialCalendarGridView));
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        return this.f20848a.getMonthSpan();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public long getItemId(int i10) {
        return this.f20848a.getStart().monthsLater(i10).getStableId();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: h, reason: merged with bridge method [inline-methods] */
    public b onCreateViewHolder(ViewGroup viewGroup, int i10) {
        LinearLayout linearLayout = (LinearLayout) LayoutInflater.from(viewGroup.getContext()).inflate(R$layout.mtrl_calendar_month_labeled, viewGroup, false);
        if (!m.B(viewGroup.getContext())) {
            return new b(linearLayout, false);
        }
        linearLayout.setLayoutParams(new RecyclerView.LayoutParams(-1, this.f20852e));
        return new b(linearLayout, true);
    }
}
