package com.google.android.gms.common.internal;

import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.internal.InterfaceC1646l;
import com.google.android.gms.common.internal.AbstractC1662c;

/* renamed from: com.google.android.gms.common.internal.y, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public final class C1683y implements AbstractC1662c.b {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ InterfaceC1646l f19855a;

    public C1683y(InterfaceC1646l interfaceC1646l) {
        this.f19855a = interfaceC1646l;
    }

    @Override // com.google.android.gms.common.internal.AbstractC1662c.b
    public final void onConnectionFailed(ConnectionResult connectionResult) {
        this.f19855a.onConnectionFailed(connectionResult);
    }
}
