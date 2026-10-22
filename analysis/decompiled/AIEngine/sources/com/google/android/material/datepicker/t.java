package com.google.android.material.datepicker;

import android.view.View;
import com.google.android.material.datepicker.MaterialCalendar;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class t implements View.OnClickListener {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f4988a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ u f4989b;

    public t(u uVar, int i10) {
        this.f4989b = uVar;
        this.f4988a = i10;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        u uVar = this.f4989b;
        uVar.f4990a.setCurrentMonth(uVar.f4990a.getCalendarConstraints().clamp(Month.create(this.f4988a, uVar.f4990a.getCurrentMonth().month)));
        uVar.f4990a.setSelector(MaterialCalendar.CalendarSelector.f4901a);
        uVar.f4990a.sendAccessibilityFocusEventToMonthDropdown();
    }
}
