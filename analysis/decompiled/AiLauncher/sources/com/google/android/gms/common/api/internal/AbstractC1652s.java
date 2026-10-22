package com.google.android.gms.common.api.internal;

import android.os.RemoteException;
import com.google.android.gms.common.api.a;
import com.google.android.gms.common.api.a.b;
import com.google.android.gms.common.api.internal.C1643i;

/* renamed from: com.google.android.gms.common.api.internal.s, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public abstract class AbstractC1652s<A extends a.b, L> {

    /* renamed from: a, reason: collision with root package name */
    public final C1643i.a f19676a;

    public AbstractC1652s(C1643i.a<L> aVar) {
        this.f19676a = aVar;
    }

    public C1643i.a<L> a() {
        return this.f19676a;
    }

    public abstract void b(A a10, D2.j<Boolean> jVar) throws RemoteException;
}
