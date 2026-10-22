package com.google.android.material.datepicker;

import android.view.View;
import com.google.android.material.datepicker.MaterialCalendar;
import com.stepos.ability.R;

/* loaded from: classes3.dex */
public final class w implements View.OnClickListener {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ MaterialCalendar f2439a;

    public w(MaterialCalendar materialCalendar) {
        this.f2439a = materialCalendar;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        MaterialCalendar materialCalendar = this.f2439a;
        MaterialCalendar.CalendarSelector calendarSelector = materialCalendar.g;
        MaterialCalendar.CalendarSelector calendarSelector2 = MaterialCalendar.CalendarSelector.f2418a;
        MaterialCalendar.CalendarSelector calendarSelector3 = MaterialCalendar.CalendarSelector.b;
        if (calendarSelector == calendarSelector3) {
            materialCalendar.d(calendarSelector2);
            materialCalendar.f2417j.announceForAccessibility(materialCalendar.getString(R.string.mtrl_picker_toggled_to_day_selection));
        } else if (calendarSelector == calendarSelector2) {
            materialCalendar.d(calendarSelector3);
            materialCalendar.i.announceForAccessibility(materialCalendar.getString(R.string.mtrl_picker_toggled_to_year_selection));
        }
    }
}
