package com.google.android.gms.maps.model;

import android.os.RemoteException;
import androidx.annotation.Nullable;
import com.google.android.gms.internal.maps.zzal;
import com.google.android.gms.internal.maps.zzam;
import m3.i;

/* loaded from: classes.dex */
final class zzab extends zzal {
    final /* synthetic */ b zza;

    public zzab(TileOverlayOptions tileOverlayOptions, b bVar) {
        this.zza = bVar;
    }

    @Override // com.google.android.gms.internal.maps.zzam
    @Nullable
    public final Tile zzb(int i4, int i5, int i6) {
        i iVar = (i) this.zza;
        iVar.getClass();
        try {
            return ((zzam) iVar.f13620a).zzb(i4, i5, i6);
        } catch (RemoteException unused) {
            return null;
        }
    }
}
