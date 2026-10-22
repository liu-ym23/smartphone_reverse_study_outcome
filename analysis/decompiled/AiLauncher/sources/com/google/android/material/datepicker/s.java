package com.google.android.material.datepicker;

import androidx.fragment.app.Fragment;
import java.util.LinkedHashSet;

/* loaded from: classes2.dex */
public abstract class s<S> extends Fragment {

    /* renamed from: a, reason: collision with root package name */
    public final LinkedHashSet<r<S>> f20857a = new LinkedHashSet<>();

    public boolean o(r<S> rVar) {
        return this.f20857a.add(rVar);
    }

    public void p() {
        this.f20857a.clear();
    }
}
