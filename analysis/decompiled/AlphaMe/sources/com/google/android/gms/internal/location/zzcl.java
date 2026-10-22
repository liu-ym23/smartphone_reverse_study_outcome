package com.google.android.gms.internal.location;

import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.internal.IStatusCallback;
import f1.AbstractC0557a;
import l1.C0758c;

/* loaded from: classes.dex */
final class zzcl extends IStatusCallback.Stub {
    final /* synthetic */ Object zza;
    final /* synthetic */ C0758c zzb;

    public zzcl(d dVar, Object obj, C0758c c0758c) {
        this.zza = obj;
        this.zzb = c0758c;
    }

    @Override // com.google.android.gms.common.api.internal.IStatusCallback
    public final void onResult(Status status) {
        AbstractC0557a.a0(status, this.zza, this.zzb);
    }
}
