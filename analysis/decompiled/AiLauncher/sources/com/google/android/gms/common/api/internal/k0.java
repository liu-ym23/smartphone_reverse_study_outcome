package com.google.android.gms.common.api.internal;

import android.os.DeadObjectException;
import android.os.RemoteException;
import com.google.android.gms.common.api.ApiException;
import com.google.android.gms.common.api.Status;

/* loaded from: classes2.dex */
public abstract class k0 extends S {

    /* renamed from: b, reason: collision with root package name */
    public final D2.j f19641b;

    public k0(int i10, D2.j jVar) {
        super(i10);
        this.f19641b = jVar;
    }

    @Override // com.google.android.gms.common.api.internal.p0
    public final void a(Status status) {
        this.f19641b.d(new ApiException(status));
    }

    @Override // com.google.android.gms.common.api.internal.p0
    public final void b(Exception exc) {
        this.f19641b.d(exc);
    }

    @Override // com.google.android.gms.common.api.internal.p0
    public final void c(J j10) throws DeadObjectException {
        try {
            h(j10);
        } catch (DeadObjectException e10) {
            a(p0.e(e10));
            throw e10;
        } catch (RemoteException e11) {
            a(p0.e(e11));
        } catch (RuntimeException e12) {
            this.f19641b.d(e12);
        }
    }

    public abstract void h(J j10) throws RemoteException;
}
