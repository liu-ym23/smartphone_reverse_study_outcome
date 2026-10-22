package com.google.android.material.datepicker;

import androidx.fragment.app.ComponentCallbacksC0511f;
import java.util.LinkedHashSet;

/* loaded from: classes.dex */
abstract class t<S> extends ComponentCallbacksC0511f {

    /* renamed from: f0, reason: collision with root package name */
    protected final LinkedHashSet<s<S>> f12791f0 = new LinkedHashSet<>();

    t() {
    }

    boolean U1(s<S> sVar) {
        return this.f12791f0.add(sVar);
    }

    void V1() {
        this.f12791f0.clear();
    }
}
