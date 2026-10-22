package com.google.android.gms.common.moduleinstall.internal;

import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.internal.r;
import com.google.android.gms.common.moduleinstall.ModuleInstallIntentResponse;

/* loaded from: classes2.dex */
final class zaw extends zaa {
    final /* synthetic */ D2.j zaa;

    public zaw(j jVar, D2.j jVar2) {
        this.zaa = jVar2;
    }

    @Override // com.google.android.gms.common.moduleinstall.internal.zaa, com.google.android.gms.common.moduleinstall.internal.zae
    public final void zac(Status status, ModuleInstallIntentResponse moduleInstallIntentResponse) {
        r.a(status, moduleInstallIntentResponse, this.zaa);
    }
}
