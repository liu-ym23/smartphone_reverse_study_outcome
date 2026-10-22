package com.google.android.gms.internal.location;

import android.location.Location;
import com.google.android.gms.common.api.Status;
import f1.AbstractC0557a;
import l1.C0758c;

/* loaded from: classes.dex */
final class zzcm extends zzp {
    final /* synthetic */ C0758c zza;

    public zzcm(d dVar, C0758c c0758c) {
        this.zza = c0758c;
    }

    @Override // com.google.android.gms.internal.location.zzq
    public final void zzb(Status status, Location location) {
        AbstractC0557a.a0(status, location, this.zza);
    }
}
