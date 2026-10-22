package com.google.android.material.datepicker;

import android.view.View;
import com.google.android.material.button.MaterialButton;
import java.util.Calendar;

/* loaded from: classes.dex */
public final class K implements View.OnClickListener {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f10622a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ M f10623b;

    public K(M m4, int i4) {
        this.f10623b = m4;
        this.f10622a = i4;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        M m4 = this.f10623b;
        Month monthC = Month.c(this.f10622a, m4.f10625a.f10709f.f10658b);
        s sVar = m4.f10625a;
        CalendarConstraints calendarConstraints = sVar.f10707d;
        Month month = calendarConstraints.f10599a;
        Calendar calendar = month.f10657a;
        Calendar calendar2 = monthC.f10657a;
        if (calendar2.compareTo(calendar) < 0) {
            monthC = month;
        } else {
            Month month2 = calendarConstraints.f10600b;
            if (calendar2.compareTo(month2.f10657a) > 0) {
                monthC = month2;
            }
        }
        sVar.h(monthC);
        sVar.i(1);
        MaterialButton materialButton = sVar.f10718o;
        if (materialButton != null) {
            materialButton.sendAccessibilityEvent(8);
        }
    }
}
