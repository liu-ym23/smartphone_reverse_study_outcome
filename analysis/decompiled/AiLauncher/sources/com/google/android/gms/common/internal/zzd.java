package com.google.android.gms.common.internal;

import android.os.Bundle;
import android.os.IBinder;
import android.util.Log;

/* loaded from: classes2.dex */
public final class zzd extends zzac {
    private AbstractC1662c zza;
    private final int zzb;

    public zzd(AbstractC1662c abstractC1662c, int i10) {
        this.zza = abstractC1662c;
        this.zzb = i10;
    }

    @Override // com.google.android.gms.common.internal.IGmsCallbacks
    public final void onPostInitComplete(int i10, IBinder iBinder, Bundle bundle) {
        C1669j.l(this.zza, "onPostInitComplete can be called only once per call to getRemoteService");
        this.zza.K(i10, iBinder, bundle, this.zzb);
        this.zza = null;
    }

    @Override // com.google.android.gms.common.internal.IGmsCallbacks
    public final void zzb(int i10, Bundle bundle) {
        Log.wtf("GmsClient", "received deprecated onAccountValidationComplete callback, ignoring", new Exception());
    }

    @Override // com.google.android.gms.common.internal.IGmsCallbacks
    public final void zzc(int i10, IBinder iBinder, zzk zzkVar) {
        AbstractC1662c abstractC1662c = this.zza;
        C1669j.l(abstractC1662c, "onPostInitCompleteWithConnectionInfo can be called only once per call togetRemoteService");
        C1669j.k(zzkVar);
        AbstractC1662c.Y(abstractC1662c, zzkVar);
        onPostInitComplete(i10, iBinder, zzkVar.zza);
    }
}
