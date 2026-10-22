package com.google.android.gms.internal.location;

import android.os.RemoteException;
import f1.AbstractC0557a;
import l1.C0758c;

/* loaded from: classes.dex */
final class zzcp extends zzj {
    final /* synthetic */ C0758c zza;
    final /* synthetic */ com.google.android.gms.location.zzr zzb;

    public zzcp(C0758c c0758c, com.google.android.gms.location.zzr zzrVar) {
        this.zza = c0758c;
        this.zzb = zzrVar;
    }

    @Override // com.google.android.gms.internal.location.zzk
    public final void zzd(zzg zzgVar) {
        AbstractC0557a.a0(zzgVar.f10004a, null, this.zza);
    }

    @Override // com.google.android.gms.internal.location.zzk
    public final void zze() throws RemoteException {
        this.zzb.zzf();
    }
}
