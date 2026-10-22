package com.google.android.gms.common.api.internal;

import android.os.DeadObjectException;
import android.os.RemoteException;
import com.google.android.gms.common.Feature;
import com.google.android.gms.common.api.Status;
import java.util.Map;
import l1.AbstractC0759d;
import l1.C0758c;
import l1.C0760e;

/* loaded from: classes.dex */
public final class A extends v {

    /* renamed from: b, reason: collision with root package name */
    public final k f9616b;

    /* renamed from: c, reason: collision with root package name */
    public final C0758c f9617c;

    /* renamed from: d, reason: collision with root package name */
    public final y0.e f9618d;

    public A(k kVar, C0758c c0758c, y0.e eVar) {
        super(2);
        this.f9617c = c0758c;
        this.f9616b = kVar;
        this.f9618d = eVar;
        if (kVar.f9657c) {
            throw new IllegalArgumentException("Best-effort write calls cannot pass methods that should auto-resolve missing features.");
        }
    }

    @Override // com.google.android.gms.common.api.internal.v
    public final boolean a(q qVar) {
        return this.f9616b.f9657c;
    }

    @Override // com.google.android.gms.common.api.internal.v
    public final Feature[] b(q qVar) {
        return (Feature[]) this.f9616b.f9656b;
    }

    @Override // com.google.android.gms.common.api.internal.v
    public final void c(Status status) {
        this.f9618d.getClass();
        this.f9617c.b(status.f9614d != null ? new Z0.j(status) : new Z0.d(status));
    }

    @Override // com.google.android.gms.common.api.internal.v
    public final void d(RuntimeException runtimeException) {
        this.f9617c.b(runtimeException);
    }

    @Override // com.google.android.gms.common.api.internal.v
    public final void e(q qVar) throws DeadObjectException {
        C0758c c0758c = this.f9617c;
        try {
            this.f9616b.b(qVar.f9666b, c0758c);
        } catch (DeadObjectException e4) {
            throw e4;
        } catch (RemoteException e5) {
            c(v.g(e5));
        } catch (RuntimeException e6) {
            c0758c.b(e6);
        }
    }

    @Override // com.google.android.gms.common.api.internal.v
    public final void f(m3.i iVar, boolean z4) {
        Map map = (Map) iVar.f13621b;
        Boolean boolValueOf = Boolean.valueOf(z4);
        C0758c c0758c = this.f9617c;
        map.put(c0758c, boolValueOf);
        l1.h hVar = c0758c.f13454a;
        B0.m mVar = new B0.m(5, iVar, c0758c);
        hVar.getClass();
        hVar.f13464b.f(new C0760e(AbstractC0759d.f13455a, mVar));
        synchronized (hVar.f13463a) {
            try {
                if (hVar.f13465c) {
                    hVar.f13464b.g(hVar);
                }
            } finally {
            }
        }
    }
}
