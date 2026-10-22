package com.google.android.material.datepicker;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.material.button.MaterialButton;
import java.util.Calendar;

/* loaded from: classes.dex */
public final class q extends RecyclerView.OnScrollListener {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ B f10702a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ s f10703b;

    public q(s sVar, B b4) {
        this.f10703b = sVar;
        this.f10702a = b4;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
    public final void onScrolled(RecyclerView recyclerView, int i4, int i5) {
        s sVar = this.f10703b;
        int iFindFirstVisibleItemPosition = i4 < 0 ? ((LinearLayoutManager) sVar.f10713j.getLayoutManager()).findFirstVisibleItemPosition() : ((LinearLayoutManager) sVar.f10713j.getLayoutManager()).findLastVisibleItemPosition();
        B b4 = this.f10702a;
        Calendar calendarC = J.c(b4.f10594a.f10599a.f10657a);
        calendarC.add(2, iFindFirstVisibleItemPosition);
        Month month = new Month(calendarC);
        sVar.f10709f = month;
        MaterialButton materialButton = sVar.f10718o;
        CalendarConstraints calendarConstraints = b4.f10594a;
        Calendar calendarC2 = J.c(calendarConstraints.f10599a.f10657a);
        calendarC2.add(2, iFindFirstVisibleItemPosition);
        materialButton.setText(new Month(calendarC2).g());
        sVar.j(calendarConstraints.f10599a.h(month));
    }
}
