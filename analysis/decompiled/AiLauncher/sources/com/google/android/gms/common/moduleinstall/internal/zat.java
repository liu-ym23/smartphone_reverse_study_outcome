package com.google.android.gms.common.moduleinstall.internal;

import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.internal.r;
import com.google.android.gms.common.moduleinstall.ModuleInstallResponse;

/* loaded from: classes2.dex */
final class zat extends zaa {
    final /* synthetic */ D2.j zaa;

    public zat(j jVar, D2.j jVar2) {
        this.zaa = jVar2;
    }

    @Override // com.google.android.gms.common.moduleinstall.internal.zaa, com.google.android.gms.common.moduleinstall.internal.zae
    public final void zad(Status status, ModuleInstallResponse moduleInstallResponse) {
        r.a(status, moduleInstallResponse, this.zaa);
    }
}
