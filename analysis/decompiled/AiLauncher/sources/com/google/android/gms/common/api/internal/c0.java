package com.google.android.gms.common.api.internal;

import android.os.RemoteException;
import com.google.android.gms.common.api.a;
import com.google.android.gms.common.api.internal.C1643i;
import com.google.android.gms.common.api.internal.C1648n;

/* loaded from: classes2.dex */
public final class c0 extends AbstractC1652s {

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ C1648n.a f19600b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public c0(C1648n.a aVar, C1643i.a aVar2) {
        super(aVar2);
        this.f19600b = aVar;
    }

    @Override // com.google.android.gms.common.api.internal.AbstractC1652s
    public final void b(a.b bVar, D2.j<Boolean> jVar) throws RemoteException {
        this.f19600b.f19651b.accept(bVar, jVar);
    }
}
