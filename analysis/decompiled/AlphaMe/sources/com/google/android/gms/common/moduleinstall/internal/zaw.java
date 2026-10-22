package com.google.android.gms.common.moduleinstall.internal;

import androidx.annotation.Nullable;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.moduleinstall.ModuleInstallIntentResponse;
import f1.AbstractC0557a;
import l1.C0758c;

/* loaded from: classes.dex */
final class zaw extends zaa {
    final /* synthetic */ C0758c zaa;

    public zaw(a aVar, C0758c c0758c) {
        this.zaa = c0758c;
    }

    @Override // com.google.android.gms.common.moduleinstall.internal.zaa, com.google.android.gms.common.moduleinstall.internal.zae
    public final void zac(Status status, @Nullable ModuleInstallIntentResponse moduleInstallIntentResponse) {
        AbstractC0557a.f0(status, moduleInstallIntentResponse, this.zaa);
    }
}
