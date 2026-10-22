package com.google.android.material.datepicker;

import android.view.View;
import com.google.android.material.button.MaterialButton;
import com.google.android.material.datepicker.MaterialCalendar;

/* loaded from: classes3.dex */
public final class P implements View.OnClickListener {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f2421a;
    public final /* synthetic */ S b;

    public P(S s5, int i) {
        this.b = s5;
        this.f2421a = i;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        S s5 = this.b;
        s5.f2423a.c(s5.f2423a.d.clamp(Month.create(this.f2421a, s5.f2423a.f.month)));
        s5.f2423a.d(MaterialCalendar.CalendarSelector.f2418a);
        MaterialButton materialButton = s5.f2423a.o;
        if (materialButton != null) {
            materialButton.sendAccessibilityEvent(8);
        }
    }
}
