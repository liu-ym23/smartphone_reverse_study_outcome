package com.google.android.gms.common.moduleinstall.internal;

import androidx.annotation.Nullable;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.moduleinstall.ModuleInstallResponse;
import f1.AbstractC0557a;
import l1.C0758c;

/* loaded from: classes.dex */
final class zat extends zaa {
    final /* synthetic */ C0758c zaa;

    public zat(a aVar, C0758c c0758c) {
        this.zaa = c0758c;
    }

    @Override // com.google.android.gms.common.moduleinstall.internal.zaa, com.google.android.gms.common.moduleinstall.internal.zae
    public final void zad(Status status, @Nullable ModuleInstallResponse moduleInstallResponse) {
        AbstractC0557a.f0(status, moduleInstallResponse, this.zaa);
    }
}
