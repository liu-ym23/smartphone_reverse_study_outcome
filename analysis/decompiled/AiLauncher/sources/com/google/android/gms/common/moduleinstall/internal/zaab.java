package com.google.android.gms.common.moduleinstall.internal;

import com.google.android.gms.common.api.internal.C1643i;
import com.google.android.gms.common.moduleinstall.ModuleInstallStatusUpdate;

/* loaded from: classes2.dex */
final class zaab extends zag {
    private final C1643i zaa;

    public zaab(C1643i c1643i) {
        this.zaa = c1643i;
    }

    @Override // com.google.android.gms.common.moduleinstall.internal.zah
    public final void zab(ModuleInstallStatusUpdate moduleInstallStatusUpdate) {
        this.zaa.c(new a(this, moduleInstallStatusUpdate));
    }
}
