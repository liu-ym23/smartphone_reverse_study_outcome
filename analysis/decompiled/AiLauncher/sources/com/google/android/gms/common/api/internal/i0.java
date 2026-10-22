package com.google.android.gms.common.api.internal;

import android.os.RemoteException;
import com.google.android.gms.common.Feature;
import com.google.android.gms.common.api.a;
import com.google.android.gms.common.api.internal.AbstractC1651q;

/* loaded from: classes2.dex */
public final class i0 extends AbstractC1651q {

    /* renamed from: d, reason: collision with root package name */
    public final /* synthetic */ AbstractC1651q.a f19629d;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public i0(AbstractC1651q.a aVar, Feature[] featureArr, boolean z10, int i10) {
        super(featureArr, z10, i10);
        this.f19629d = aVar;
    }

    @Override // com.google.android.gms.common.api.internal.AbstractC1651q
    public final void b(a.b bVar, D2.j jVar) throws RemoteException {
        this.f19629d.f19665a.accept(bVar, jVar);
    }
}
