package com.google.android.material.datepicker;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

/* loaded from: classes3.dex */
public final class v extends RecyclerView.OnScrollListener {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ G f2438a;
    public final /* synthetic */ MaterialCalendar b;

    public v(MaterialCalendar materialCalendar, G g) {
        this.b = materialCalendar;
        this.f2438a = g;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
    public final void onScrolled(RecyclerView recyclerView, int i, int i6) {
        CalendarConstraints calendarConstraints = this.f2438a.f2413a;
        MaterialCalendar materialCalendar = this.b;
        int iFindFirstVisibleItemPosition = i < 0 ? ((LinearLayoutManager) materialCalendar.f2417j.getLayoutManager()).findFirstVisibleItemPosition() : ((LinearLayoutManager) materialCalendar.f2417j.getLayoutManager()).findLastVisibleItemPosition();
        Month monthMonthsLater = calendarConstraints.getStart().monthsLater(iFindFirstVisibleItemPosition);
        materialCalendar.f = monthMonthsLater;
        materialCalendar.o.setText(calendarConstraints.getStart().monthsLater(iFindFirstVisibleItemPosition).getLongName());
        materialCalendar.e(calendarConstraints.getStart().monthsUntil(monthMonthsLater));
    }
}
