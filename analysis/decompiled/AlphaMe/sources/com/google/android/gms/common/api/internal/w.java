package com.google.android.gms.common.api.internal;

import android.os.SystemClock;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.MethodInvocation;
import g1.HandlerC0575c;
import l1.InterfaceC0757b;

/* loaded from: classes.dex */
public final class w implements InterfaceC0757b {

    /* renamed from: a, reason: collision with root package name */
    public final C0407e f9688a;

    /* renamed from: b, reason: collision with root package name */
    public final int f9689b;

    /* renamed from: c, reason: collision with root package name */
    public final C0403a f9690c;

    /* renamed from: d, reason: collision with root package name */
    public final long f9691d;

    /* renamed from: e, reason: collision with root package name */
    public final long f9692e;

    public w(C0407e c0407e, int i4, C0403a c0403a, long j4, long j5) {
        this.f9688a = c0407e;
        this.f9689b = i4;
        this.f9690c = c0403a;
        this.f9691d = j4;
        this.f9692e = j5;
    }

    @Override // l1.InterfaceC0757b
    public final void a(l1.h hVar) {
        Exception exc;
        int i4;
        int i5;
        long j4;
        long j5;
        int iElapsedRealtime;
        C0407e c0407e = this.f9688a;
        if (c0407e.a()) {
            com.google.android.gms.common.internal.f.b().getClass();
            q qVar = (q) c0407e.f9650j.get(this.f9690c);
            if (qVar != null) {
                com.google.android.gms.common.internal.e eVar = qVar.f9666b;
                if (eVar instanceof com.google.android.gms.common.internal.c) {
                    long j6 = this.f9691d;
                    boolean z4 = true;
                    boolean z5 = j6 > 0;
                    int i6 = eVar.f9788p;
                    synchronized (hVar.f13463a) {
                        try {
                            if (!hVar.f13465c || hVar.f13467e != null) {
                                z4 = false;
                            }
                        } catch (Throwable th) {
                            throw th;
                        }
                    }
                    if (z4) {
                        i4 = 0;
                        i5 = 0;
                    } else {
                        synchronized (hVar.f13463a) {
                            exc = hVar.f13467e;
                        }
                        if (exc instanceof Z0.d) {
                            Status status = ((Z0.d) exc).f2147a;
                            int i7 = status.f9612b;
                            ConnectionResult connectionResult = status.f9615e;
                            i5 = connectionResult == null ? -1 : connectionResult.f9598b;
                            i4 = i7;
                        } else {
                            i4 = 101;
                            i5 = -1;
                        }
                    }
                    if (z5) {
                        long jCurrentTimeMillis = System.currentTimeMillis();
                        iElapsedRealtime = (int) (SystemClock.elapsedRealtime() - this.f9692e);
                        j4 = j6;
                        j5 = jCurrentTimeMillis;
                    } else {
                        j4 = 0;
                        j5 = 0;
                        iElapsedRealtime = -1;
                    }
                    HandlerC0575c handlerC0575c = c0407e.f9653m;
                    handlerC0575c.sendMessage(handlerC0575c.obtainMessage(18, new x(new MethodInvocation(this.f9689b, i4, i5, j4, j5, null, null, i6, iElapsedRealtime), 0, 5000, 100)));
                }
            }
        }
    }
}
