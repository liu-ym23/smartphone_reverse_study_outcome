package com.google.android.gms.internal.location;

import com.google.android.gms.common.api.internal.p;
import com.google.android.gms.location.LocationSettingsResult;
import f1.AbstractC0557a;
import l1.C0758c;

/* loaded from: classes.dex */
final class zzcq extends zzr {
    final /* synthetic */ C0758c zza;

    public zzcq(C0758c c0758c) {
        this.zza = c0758c;
    }

    @Override // com.google.android.gms.internal.location.zzs
    public final void zzb(LocationSettingsResult locationSettingsResult) {
        AbstractC0557a.a0(locationSettingsResult.f10067a, new p(locationSettingsResult), this.zza);
    }
}
