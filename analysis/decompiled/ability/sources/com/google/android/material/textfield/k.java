package com.google.android.material.textfield;

import android.text.Editable;

/* loaded from: classes3.dex */
public final class k extends com.google.android.material.internal.j {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ m f2673a;

    public k(m mVar) {
        this.f2673a = mVar;
    }

    @Override // android.text.TextWatcher
    public final void afterTextChanged(Editable editable) {
        this.f2673a.b().a();
    }

    @Override // com.google.android.material.internal.j, android.text.TextWatcher
    public final void beforeTextChanged(CharSequence charSequence, int i, int i6, int i10) {
        this.f2673a.b().b();
    }
}
