package com.google.android.gms.common.moduleinstall.internal;

import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.internal.r;
import com.google.android.gms.common.moduleinstall.ModuleAvailabilityResponse;

/* loaded from: classes2.dex */
final class zar extends zaa {
    final /* synthetic */ D2.j zaa;

    public zar(j jVar, D2.j jVar2) {
        this.zaa = jVar2;
    }

    @Override // com.google.android.gms.common.moduleinstall.internal.zaa, com.google.android.gms.common.moduleinstall.internal.zae
    public final void zae(Status status, ModuleAvailabilityResponse moduleAvailabilityResponse) {
        r.a(status, moduleAvailabilityResponse, this.zaa);
    }
}
