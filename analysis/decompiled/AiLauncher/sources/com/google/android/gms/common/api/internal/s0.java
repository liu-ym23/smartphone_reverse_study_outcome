package com.google.android.gms.common.api.internal;

import android.app.Dialog;

/* loaded from: classes2.dex */
public final class s0 extends P {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Dialog f19677a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ t0 f19678b;

    public s0(t0 t0Var, Dialog dialog) {
        this.f19678b = t0Var;
        this.f19677a = dialog;
    }

    @Override // com.google.android.gms.common.api.internal.P
    public final void a() {
        this.f19678b.f19682b.o();
        if (this.f19677a.isShowing()) {
            this.f19677a.dismiss();
        }
    }
}
