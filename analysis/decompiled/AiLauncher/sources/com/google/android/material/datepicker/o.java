package com.google.android.material.datepicker;

import android.os.Bundle;
import android.view.ContextThemeWrapper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import java.util.Iterator;

/* loaded from: classes2.dex */
public final class o<S> extends s<S> {

    /* renamed from: b, reason: collision with root package name */
    public int f20836b;

    /* renamed from: c, reason: collision with root package name */
    public DateSelector<S> f20837c;

    /* renamed from: d, reason: collision with root package name */
    public CalendarConstraints f20838d;

    public class a extends r<S> {
        public a() {
        }

        @Override // com.google.android.material.datepicker.r
        public void a() {
            Iterator<r<S>> it = o.this.f20857a.iterator();
            while (it.hasNext()) {
                it.next().a();
            }
        }

        @Override // com.google.android.material.datepicker.r
        public void b(S s10) {
            Iterator<r<S>> it = o.this.f20857a.iterator();
            while (it.hasNext()) {
                it.next().b(s10);
            }
        }
    }

    public static <T> o<T> q(DateSelector<T> dateSelector, int i10, CalendarConstraints calendarConstraints) {
        o<T> oVar = new o<>();
        Bundle bundle = new Bundle();
        bundle.putInt("THEME_RES_ID_KEY", i10);
        bundle.putParcelable("DATE_SELECTOR_KEY", dateSelector);
        bundle.putParcelable("CALENDAR_CONSTRAINTS_KEY", calendarConstraints);
        oVar.setArguments(bundle);
        return oVar;
    }

    @Override // androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (bundle == null) {
            bundle = getArguments();
        }
        this.f20836b = bundle.getInt("THEME_RES_ID_KEY");
        this.f20837c = (DateSelector) bundle.getParcelable("DATE_SELECTOR_KEY");
        this.f20838d = (CalendarConstraints) bundle.getParcelable("CALENDAR_CONSTRAINTS_KEY");
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        return this.f20837c.onCreateTextInputView(layoutInflater.cloneInContext(new ContextThemeWrapper(getContext(), this.f20836b)), viewGroup, bundle, this.f20838d, new a());
    }

    @Override // androidx.fragment.app.Fragment
    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putInt("THEME_RES_ID_KEY", this.f20836b);
        bundle.putParcelable("DATE_SELECTOR_KEY", this.f20837c);
        bundle.putParcelable("CALENDAR_CONSTRAINTS_KEY", this.f20838d);
    }
}
