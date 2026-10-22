package com.google.android.gms.common.api.internal;

import android.os.RemoteException;
import com.google.android.gms.common.Feature;
import com.google.android.gms.common.api.Status;

/* loaded from: classes.dex */
public abstract class v {

    /* renamed from: a, reason: collision with root package name */
    public final int f9687a;

    public v(int i4) {
        this.f9687a = i4;
    }

    public static /* bridge */ /* synthetic */ Status g(RemoteException remoteException) {
        return new Status(19, remoteException.getClass().getSimpleName() + ": " + remoteException.getLocalizedMessage());
    }

    public abstract boolean a(q qVar);

    public abstract Feature[] b(q qVar);

    public abstract void c(Status status);

    public abstract void d(RuntimeException runtimeException);

    public abstract void e(q qVar);

    public abstract void f(m3.i iVar, boolean z4);
}
