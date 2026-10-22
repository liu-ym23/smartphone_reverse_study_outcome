package com.google.android.gms.common.api.internal;

import android.os.DeadObjectException;
import android.os.RemoteException;
import com.google.android.gms.common.Feature;
import com.google.android.gms.common.api.Status;

/* loaded from: classes2.dex */
public final class n0 extends S {

    /* renamed from: b, reason: collision with root package name */
    public final AbstractC1651q f19657b;

    /* renamed from: c, reason: collision with root package name */
    public final D2.j f19658c;

    /* renamed from: d, reason: collision with root package name */
    public final InterfaceC1650p f19659d;

    public n0(int i10, AbstractC1651q abstractC1651q, D2.j jVar, InterfaceC1650p interfaceC1650p) {
        super(i10);
        this.f19658c = jVar;
        this.f19657b = abstractC1651q;
        this.f19659d = interfaceC1650p;
        if (i10 == 2 && abstractC1651q.c()) {
            throw new IllegalArgumentException("Best-effort write calls cannot pass methods that should auto-resolve missing features.");
        }
    }

    @Override // com.google.android.gms.common.api.internal.p0
    public final void a(Status status) {
        this.f19658c.d(this.f19659d.a(status));
    }

    @Override // com.google.android.gms.common.api.internal.p0
    public final void b(Exception exc) {
        this.f19658c.d(exc);
    }

    @Override // com.google.android.gms.common.api.internal.p0
    public final void c(J j10) throws DeadObjectException {
        try {
            this.f19657b.b(j10.t(), this.f19658c);
        } catch (DeadObjectException e10) {
            throw e10;
        } catch (RemoteException e11) {
            a(p0.e(e11));
        } catch (RuntimeException e12) {
            this.f19658c.d(e12);
        }
    }

    @Override // com.google.android.gms.common.api.internal.p0
    public final void d(C1654u c1654u, boolean z10) {
        c1654u.b(this.f19658c, z10);
    }

    @Override // com.google.android.gms.common.api.internal.S
    public final boolean f(J j10) {
        return this.f19657b.c();
    }

    @Override // com.google.android.gms.common.api.internal.S
    public final Feature[] g(J j10) {
        return this.f19657b.e();
    }
}
