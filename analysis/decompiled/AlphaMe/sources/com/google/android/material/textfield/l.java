package com.google.android.material.textfield;

import android.text.Editable;

/* loaded from: classes.dex */
public final class l extends com.google.android.material.internal.k {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ n f11032a;

    public l(n nVar) {
        this.f11032a = nVar;
    }

    @Override // android.text.TextWatcher
    public final void afterTextChanged(Editable editable) {
        this.f11032a.b().a();
    }

    @Override // com.google.android.material.internal.k, android.text.TextWatcher
    public final void beforeTextChanged(CharSequence charSequence, int i4, int i5, int i6) {
        this.f11032a.b().b();
    }
}
