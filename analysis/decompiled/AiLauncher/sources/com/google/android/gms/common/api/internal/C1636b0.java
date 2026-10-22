package com.google.android.gms.common.api.internal;

import android.os.RemoteException;
import com.google.android.gms.common.Feature;
import com.google.android.gms.common.api.a;
import com.google.android.gms.common.api.internal.C1648n;

/* renamed from: com.google.android.gms.common.api.internal.b0, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public final class C1636b0 extends AbstractC1647m {

    /* renamed from: e, reason: collision with root package name */
    public final /* synthetic */ C1648n.a f19594e;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C1636b0(C1648n.a aVar, C1643i c1643i, Feature[] featureArr, boolean z10, int i10) {
        super(c1643i, featureArr, z10, i10);
        this.f19594e = aVar;
    }

    @Override // com.google.android.gms.common.api.internal.AbstractC1647m
    public final void d(a.b bVar, D2.j<Void> jVar) throws RemoteException {
        this.f19594e.f19650a.accept(bVar, jVar);
    }
}
