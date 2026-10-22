package com.google.android.gms.common.internal;

import android.os.Bundle;
import android.os.IBinder;
import android.util.Log;
import androidx.annotation.BinderThread;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.android.gms.common.util.VisibleForTesting;

@VisibleForTesting
/* loaded from: classes.dex */
public final class zzd extends zzab {

    @Nullable
    private c zza;
    private final int zzb;

    public zzd(@NonNull c cVar, int i4) {
        this.zza = cVar;
        this.zzb = i4;
    }

    @Override // com.google.android.gms.common.internal.IGmsCallbacks
    @BinderThread
    public final void onPostInitComplete(int i4, @NonNull IBinder iBinder, @Nullable Bundle bundle) {
        com.stepos.statsrpk.c.m(this.zza, "onPostInitComplete can be called only once per call to getRemoteService");
        c cVar = this.zza;
        int i5 = this.zzb;
        cVar.getClass();
        p pVar = new p(cVar, i4, iBinder, bundle);
        n nVar = cVar.f9777e;
        nVar.sendMessage(nVar.obtainMessage(1, i5, -1, pVar));
        this.zza = null;
    }

    @Override // com.google.android.gms.common.internal.IGmsCallbacks
    @BinderThread
    public final void zzb(int i4, @Nullable Bundle bundle) {
        Log.wtf("GmsClient", "received deprecated onAccountValidationComplete callback, ignoring", new Exception());
    }

    @Override // com.google.android.gms.common.internal.IGmsCallbacks
    @BinderThread
    public final void zzc(int i4, @NonNull IBinder iBinder, @NonNull zzj zzjVar) {
        c cVar = this.zza;
        com.stepos.statsrpk.c.m(cVar, "onPostInitCompleteWithConnectionInfo can be called only once per call togetRemoteService");
        com.stepos.statsrpk.c.l(zzjVar);
        cVar.f9793u = zzjVar;
        onPostInitComplete(i4, iBinder, zzjVar.f9872a);
    }
}
