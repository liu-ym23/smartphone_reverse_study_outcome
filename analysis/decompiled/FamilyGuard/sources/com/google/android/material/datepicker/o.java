package com.google.android.material.datepicker;

import android.os.Bundle;
import android.view.ContextThemeWrapper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import java.util.Iterator;

/* loaded from: classes.dex */
public final class o<S> extends t<S> {

    /* renamed from: g0, reason: collision with root package name */
    private int f12763g0;

    /* renamed from: h0, reason: collision with root package name */
    private d<S> f12764h0;

    /* renamed from: i0, reason: collision with root package name */
    private com.google.android.material.datepicker.a f12765i0;

    class a extends s<S> {
        a() {
        }

        @Override // com.google.android.material.datepicker.s
        public void a(S s5) {
            Iterator<s<S>> it = o.this.f12791f0.iterator();
            while (it.hasNext()) {
                it.next().a(s5);
            }
        }
    }

    static <T> o<T> W1(d<T> dVar, int i5, com.google.android.material.datepicker.a aVar) {
        o<T> oVar = new o<>();
        Bundle bundle = new Bundle();
        bundle.putInt("THEME_RES_ID_KEY", i5);
        bundle.putParcelable("DATE_SELECTOR_KEY", dVar);
        bundle.putParcelable("CALENDAR_CONSTRAINTS_KEY", aVar);
        oVar.G1(bundle);
        return oVar;
    }

    @Override // androidx.fragment.app.ComponentCallbacksC0511f
    public void R0(Bundle bundle) {
        super.R0(bundle);
        bundle.putInt("THEME_RES_ID_KEY", this.f12763g0);
        bundle.putParcelable("DATE_SELECTOR_KEY", this.f12764h0);
        bundle.putParcelable("CALENDAR_CONSTRAINTS_KEY", this.f12765i0);
    }

    @Override // androidx.fragment.app.ComponentCallbacksC0511f
    public void v0(Bundle bundle) {
        super.v0(bundle);
        if (bundle == null) {
            bundle = u();
        }
        this.f12763g0 = bundle.getInt("THEME_RES_ID_KEY");
        this.f12764h0 = (d) bundle.getParcelable("DATE_SELECTOR_KEY");
        this.f12765i0 = (com.google.android.material.datepicker.a) bundle.getParcelable("CALENDAR_CONSTRAINTS_KEY");
    }

    @Override // androidx.fragment.app.ComponentCallbacksC0511f
    public View z0(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        return this.f12764h0.m(layoutInflater.cloneInContext(new ContextThemeWrapper(w(), this.f12763g0)), viewGroup, bundle, this.f12765i0, new a());
    }
}
