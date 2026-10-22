package com.google.android.material.datepicker;

import android.os.Bundle;
import android.view.ContextThemeWrapper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.RestrictTo;
import e.EnumC0546d;

@RestrictTo({EnumC0546d.f12493b})
/* loaded from: classes.dex */
public final class w<S> extends D {

    /* renamed from: b, reason: collision with root package name */
    public int f10729b;

    /* renamed from: c, reason: collision with root package name */
    public DateSelector f10730c;

    /* renamed from: d, reason: collision with root package name */
    public CalendarConstraints f10731d;

    @Override // androidx.fragment.app.D
    public final void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (bundle == null) {
            bundle = getArguments();
        }
        this.f10729b = bundle.getInt("THEME_RES_ID_KEY");
        this.f10730c = (DateSelector) bundle.getParcelable("DATE_SELECTOR_KEY");
        this.f10731d = (CalendarConstraints) bundle.getParcelable("CALENDAR_CONSTRAINTS_KEY");
    }

    @Override // androidx.fragment.app.D
    public final View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        return this.f10730c.C(layoutInflater.cloneInContext(new ContextThemeWrapper(getContext(), this.f10729b)), viewGroup, this.f10731d, new v(this, 1));
    }

    @Override // androidx.fragment.app.D
    public final void onSaveInstanceState(Bundle bundle) {
        bundle.putInt("THEME_RES_ID_KEY", this.f10729b);
        bundle.putParcelable("DATE_SELECTOR_KEY", this.f10730c);
        bundle.putParcelable("CALENDAR_CONSTRAINTS_KEY", this.f10731d);
    }
}
