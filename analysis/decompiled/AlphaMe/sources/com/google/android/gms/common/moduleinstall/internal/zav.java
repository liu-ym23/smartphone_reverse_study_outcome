package com.google.android.gms.common.moduleinstall.internal;

import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.internal.IStatusCallback;
import f1.AbstractC0557a;
import l1.C0758c;

/* loaded from: classes.dex */
final class zav extends IStatusCallback.Stub {
    final /* synthetic */ C0758c zaa;

    public zav(a aVar, C0758c c0758c) {
        this.zaa = c0758c;
    }

    @Override // com.google.android.gms.common.api.internal.IStatusCallback
    public final void onResult(Status status) {
        AbstractC0557a.f0(status, Boolean.TRUE, this.zaa);
    }
}
