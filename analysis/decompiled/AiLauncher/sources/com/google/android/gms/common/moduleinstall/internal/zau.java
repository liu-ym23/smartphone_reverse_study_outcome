package com.google.android.gms.common.moduleinstall.internal;

import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.internal.C1644j;
import com.google.android.gms.common.api.internal.r;
import com.google.android.gms.common.moduleinstall.ModuleInstallResponse;
import java.util.concurrent.atomic.AtomicReference;
import q2.InterfaceC5144a;

/* loaded from: classes2.dex */
final class zau extends zaa {
    final /* synthetic */ AtomicReference zaa;
    final /* synthetic */ D2.j zab;
    final /* synthetic */ InterfaceC5144a zac;
    final /* synthetic */ j zad;

    public zau(j jVar, AtomicReference atomicReference, D2.j jVar2, InterfaceC5144a interfaceC5144a) {
        this.zad = jVar;
        this.zaa = atomicReference;
        this.zab = jVar2;
        this.zac = interfaceC5144a;
    }

    @Override // com.google.android.gms.common.moduleinstall.internal.zaa, com.google.android.gms.common.moduleinstall.internal.zae
    public final void zad(Status status, ModuleInstallResponse moduleInstallResponse) {
        if (moduleInstallResponse != null) {
            this.zaa.set(moduleInstallResponse);
        }
        r.a(status, null, this.zab);
        if (!status.isSuccess() || (moduleInstallResponse != null && moduleInstallResponse.zaa())) {
            this.zad.h(C1644j.c(this.zac, InterfaceC5144a.class.getSimpleName()), 27306);
        }
    }
}
