package com.google.android.gms.common.api.internal;

import android.app.Dialog;
import android.app.PendingIntent;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.GoogleApiActivity;
import com.google.android.gms.common.internal.C1669j;

/* loaded from: classes2.dex */
public final class t0 implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    public final r0 f19681a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ u0 f19682b;

    public t0(u0 u0Var, r0 r0Var) {
        this.f19682b = u0Var;
        this.f19681a = r0Var;
    }

    @Override // java.lang.Runnable
    public final void run() {
        if (this.f19682b.f19685b) {
            ConnectionResult connectionResultB = this.f19681a.b();
            if (connectionResultB.hasResolution()) {
                u0 u0Var = this.f19682b;
                u0Var.f19557a.startActivityForResult(GoogleApiActivity.a(u0Var.b(), (PendingIntent) C1669j.k(connectionResultB.getResolution()), this.f19681a.a(), false), 1);
                return;
            }
            u0 u0Var2 = this.f19682b;
            if (u0Var2.f19688e.b(u0Var2.b(), connectionResultB.getErrorCode(), null) != null) {
                u0 u0Var3 = this.f19682b;
                u0Var3.f19688e.v(u0Var3.b(), u0Var3.f19557a, connectionResultB.getErrorCode(), 2, this.f19682b);
                return;
            }
            if (connectionResultB.getErrorCode() != 18) {
                this.f19682b.l(connectionResultB, this.f19681a.a());
                return;
            }
            u0 u0Var4 = this.f19682b;
            Dialog dialogQ = u0Var4.f19688e.q(u0Var4.b(), u0Var4);
            u0 u0Var5 = this.f19682b;
            u0Var5.f19688e.r(u0Var5.b().getApplicationContext(), new s0(this, dialogQ));
        }
    }
}
