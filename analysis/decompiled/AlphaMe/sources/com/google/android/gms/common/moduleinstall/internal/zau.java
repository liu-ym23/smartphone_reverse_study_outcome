package com.google.android.gms.common.moduleinstall.internal;

import androidx.annotation.Nullable;
import b1.InterfaceC0365a;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.moduleinstall.ModuleInstallResponse;
import com.stepos.statsrpk.c;
import f1.AbstractC0557a;
import java.util.concurrent.atomic.AtomicReference;
import l1.C0758c;

/* loaded from: classes.dex */
final class zau extends zaa {
    final /* synthetic */ AtomicReference zaa;
    final /* synthetic */ C0758c zab;
    final /* synthetic */ InterfaceC0365a zac;
    final /* synthetic */ a zad;

    public zau(a aVar, AtomicReference atomicReference, C0758c c0758c, InterfaceC0365a interfaceC0365a) {
        this.zaa = atomicReference;
        this.zab = c0758c;
    }

    @Override // com.google.android.gms.common.moduleinstall.internal.zaa, com.google.android.gms.common.moduleinstall.internal.zae
    public final void zad(Status status, @Nullable ModuleInstallResponse moduleInstallResponse) {
        if (moduleInstallResponse != null) {
            this.zaa.set(moduleInstallResponse);
        }
        AbstractC0557a.f0(status, null, this.zab);
        if (status.f9612b > 0 || (moduleInstallResponse != null && moduleInstallResponse.f9884b)) {
            c.m(null, "Listener must not be null");
            throw null;
        }
    }
}
