package com.google.android.gms.common.moduleinstall.internal;

import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.internal.IStatusCallback;
import com.google.android.gms.common.api.internal.r;

/* loaded from: classes2.dex */
final class zax extends IStatusCallback.Stub {
    final /* synthetic */ D2.j zaa;

    public zax(j jVar, D2.j jVar2) {
        this.zaa = jVar2;
    }

    @Override // com.google.android.gms.common.api.internal.IStatusCallback
    public final void onResult(Status status) {
        r.a(status, null, this.zaa);
    }
}
