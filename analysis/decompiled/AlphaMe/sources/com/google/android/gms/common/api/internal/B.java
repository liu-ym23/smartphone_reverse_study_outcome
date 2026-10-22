package com.google.android.gms.common.api.internal;

import android.os.DeadObjectException;
import android.os.RemoteException;
import com.google.android.gms.common.Feature;
import com.google.android.gms.common.api.Status;
import l1.C0758c;

/* loaded from: classes.dex */
public final class B extends v {

    /* renamed from: b, reason: collision with root package name */
    public final C0758c f9619b;

    public B(h hVar, C0758c c0758c) {
        super(4);
        this.f9619b = c0758c;
    }

    @Override // com.google.android.gms.common.api.internal.v
    public final boolean a(q qVar) {
        B0.g.y(qVar.f9670f.get(null));
        return false;
    }

    @Override // com.google.android.gms.common.api.internal.v
    public final Feature[] b(q qVar) {
        B0.g.y(qVar.f9670f.get(null));
        return null;
    }

    @Override // com.google.android.gms.common.api.internal.v
    public final void c(Status status) {
        this.f9619b.b(new Z0.d(status));
    }

    @Override // com.google.android.gms.common.api.internal.v
    public final void d(RuntimeException runtimeException) {
        this.f9619b.b(runtimeException);
    }

    @Override // com.google.android.gms.common.api.internal.v
    public final void e(q qVar) throws DeadObjectException {
        try {
            h(qVar);
        } catch (DeadObjectException e4) {
            c(v.g(e4));
            throw e4;
        } catch (RemoteException e5) {
            c(v.g(e5));
        } catch (RuntimeException e6) {
            this.f9619b.b(e6);
        }
    }

    @Override // com.google.android.gms.common.api.internal.v
    public final /* bridge */ /* synthetic */ void f(m3.i iVar, boolean z4) {
    }

    public final void h(q qVar) {
        B0.g.y(qVar.f9670f.remove(null));
        this.f9619b.c(Boolean.FALSE);
    }
}
