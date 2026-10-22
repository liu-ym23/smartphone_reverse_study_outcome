package com.google.android.gms.common.api.internal;

import android.os.DeadObjectException;
import android.os.RemoteException;
import com.google.android.gms.common.api.Status;

/* loaded from: classes2.dex */
public abstract class p0 {

    /* renamed from: a, reason: collision with root package name */
    public final int f19661a;

    public p0(int i10) {
        this.f19661a = i10;
    }

    public static /* bridge */ /* synthetic */ Status e(RemoteException remoteException) {
        return new Status(19, remoteException.getClass().getSimpleName() + ": " + remoteException.getLocalizedMessage());
    }

    public abstract void a(Status status);

    public abstract void b(Exception exc);

    public abstract void c(J j10) throws DeadObjectException;

    public abstract void d(C1654u c1654u, boolean z10);
}
