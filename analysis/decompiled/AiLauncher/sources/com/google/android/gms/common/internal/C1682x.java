package com.google.android.gms.common.internal;

import android.os.Bundle;
import com.google.android.gms.common.api.internal.InterfaceC1639e;
import com.google.android.gms.common.internal.AbstractC1662c;

/* renamed from: com.google.android.gms.common.internal.x, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public final class C1682x implements AbstractC1662c.a {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ InterfaceC1639e f19854a;

    public C1682x(InterfaceC1639e interfaceC1639e) {
        this.f19854a = interfaceC1639e;
    }

    @Override // com.google.android.gms.common.internal.AbstractC1662c.a
    public final void onConnected(Bundle bundle) {
        this.f19854a.onConnected(bundle);
    }

    @Override // com.google.android.gms.common.internal.AbstractC1662c.a
    public final void onConnectionSuspended(int i10) {
        this.f19854a.onConnectionSuspended(i10);
    }
}
