package com.google.android.material.datepicker;

import android.view.View;
import androidx.recyclerview.widget.LinearLayoutManager;
import java.util.Calendar;

/* renamed from: com.google.android.material.datepicker.k, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class ViewOnClickListenerC0432k implements View.OnClickListener {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f10689a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ B f10690b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ s f10691c;

    public /* synthetic */ ViewOnClickListenerC0432k(s sVar, B b4, int i4) {
        this.f10689a = i4;
        this.f10691c = sVar;
        this.f10690b = b4;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        int i4 = this.f10689a;
        B b4 = this.f10690b;
        s sVar = this.f10691c;
        switch (i4) {
            case 0:
                int iFindLastVisibleItemPosition = ((LinearLayoutManager) sVar.f10713j.getLayoutManager()).findLastVisibleItemPosition() - 1;
                Calendar calendarC = J.c(b4.f10594a.f10599a.f10657a);
                calendarC.add(2, iFindLastVisibleItemPosition);
                sVar.h(new Month(calendarC));
                break;
            default:
                int iFindFirstVisibleItemPosition = ((LinearLayoutManager) sVar.f10713j.getLayoutManager()).findFirstVisibleItemPosition() + 1;
                Calendar calendarC2 = J.c(b4.f10594a.f10599a.f10657a);
                calendarC2.add(2, iFindFirstVisibleItemPosition);
                sVar.h(new Month(calendarC2));
                break;
        }
    }
}
