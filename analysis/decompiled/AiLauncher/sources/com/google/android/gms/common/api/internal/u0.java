package com.google.android.gms.common.api.internal;

import android.app.PendingIntent;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import com.google.android.gms.common.ConnectionResult;
import java.util.concurrent.atomic.AtomicReference;

/* loaded from: classes2.dex */
public abstract class u0 extends LifecycleCallback implements DialogInterface.OnCancelListener {

    /* renamed from: b, reason: collision with root package name */
    public volatile boolean f19685b;

    /* renamed from: c, reason: collision with root package name */
    public final AtomicReference f19686c;

    /* renamed from: d, reason: collision with root package name */
    public final Handler f19687d;

    /* renamed from: e, reason: collision with root package name */
    public final com.google.android.gms.common.b f19688e;

    public u0(InterfaceC1642h interfaceC1642h, com.google.android.gms.common.b bVar) {
        super(interfaceC1642h);
        this.f19686c = new AtomicReference(null);
        this.f19687d = new w2.i(Looper.getMainLooper());
        this.f19688e = bVar;
    }

    public static final int p(r0 r0Var) {
        if (r0Var == null) {
            return -1;
        }
        return r0Var.a();
    }

    @Override // com.google.android.gms.common.api.internal.LifecycleCallback
    public final void e(int i10, int i11, Intent intent) {
        r0 r0Var = (r0) this.f19686c.get();
        if (i10 != 1) {
            if (i10 == 2) {
                int iG = this.f19688e.g(b());
                if (iG == 0) {
                    o();
                    return;
                } else {
                    if (r0Var == null) {
                        return;
                    }
                    if (r0Var.b().getErrorCode() == 18 && iG == 18) {
                        return;
                    }
                }
            }
        } else if (i11 == -1) {
            o();
            return;
        } else if (i11 == 0) {
            if (r0Var != null) {
                l(new ConnectionResult(intent != null ? intent.getIntExtra("<<ResolutionFailureErrorDetail>>", 13) : 13, null, r0Var.b().toString()), p(r0Var));
                return;
            }
            return;
        }
        if (r0Var != null) {
            l(r0Var.b(), r0Var.a());
        }
    }

    @Override // com.google.android.gms.common.api.internal.LifecycleCallback
    public final void f(Bundle bundle) {
        super.f(bundle);
        if (bundle != null) {
            this.f19686c.set(bundle.getBoolean("resolving_error", false) ? new r0(new ConnectionResult(bundle.getInt("failed_status"), (PendingIntent) bundle.getParcelable("failed_resolution")), bundle.getInt("failed_client_id", -1)) : null);
        }
    }

    @Override // com.google.android.gms.common.api.internal.LifecycleCallback
    public final void i(Bundle bundle) {
        super.i(bundle);
        r0 r0Var = (r0) this.f19686c.get();
        if (r0Var == null) {
            return;
        }
        bundle.putBoolean("resolving_error", true);
        bundle.putInt("failed_client_id", r0Var.a());
        bundle.putInt("failed_status", r0Var.b().getErrorCode());
        bundle.putParcelable("failed_resolution", r0Var.b().getResolution());
    }

    @Override // com.google.android.gms.common.api.internal.LifecycleCallback
    public void j() {
        super.j();
        this.f19685b = true;
    }

    @Override // com.google.android.gms.common.api.internal.LifecycleCallback
    public void k() {
        super.k();
        this.f19685b = false;
    }

    public final void l(ConnectionResult connectionResult, int i10) {
        this.f19686c.set(null);
        m(connectionResult, i10);
    }

    public abstract void m(ConnectionResult connectionResult, int i10);

    public abstract void n();

    public final void o() {
        this.f19686c.set(null);
        n();
    }

    @Override // android.content.DialogInterface.OnCancelListener
    public final void onCancel(DialogInterface dialogInterface) {
        l(new ConnectionResult(13, null), p((r0) this.f19686c.get()));
    }

    public final void s(ConnectionResult connectionResult, int i10) {
        AtomicReference atomicReference;
        r0 r0Var = new r0(connectionResult, i10);
        do {
            atomicReference = this.f19686c;
            if (atomicReference.compareAndSet(null, r0Var)) {
                this.f19687d.post(new t0(this, r0Var));
                return;
            }
        } while (atomicReference.get() == null);
    }
}
