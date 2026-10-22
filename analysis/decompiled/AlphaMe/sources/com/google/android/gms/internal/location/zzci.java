package com.google.android.gms.internal.location;

import android.app.PendingIntent;
import com.google.android.gms.common.api.Status;
import f1.AbstractC0557a;
import l1.C0758c;

/* loaded from: classes.dex */
final class zzci extends zzl {
    final /* synthetic */ C0758c zza;

    public zzci(C0758c c0758c) {
        this.zza = c0758c;
    }

    @Override // com.google.android.gms.internal.location.zzm
    public final void zzb(int i4, String[] strArr) {
        if (i4 != 0 && (i4 < 1000 || i4 >= 1006)) {
            i4 = 13;
        }
        AbstractC0557a.a0(new Status(i4, null), null, this.zza);
    }

    @Override // com.google.android.gms.internal.location.zzm
    public final void zzc(int i4, PendingIntent pendingIntent) {
        if (i4 != 0 && (i4 < 1000 || i4 >= 1006)) {
            i4 = 13;
        }
        AbstractC0557a.a0(new Status(i4, null), null, this.zza);
    }

    @Override // com.google.android.gms.internal.location.zzm
    public final void zzd(int i4, String[] strArr) {
        if (i4 != 0 && (i4 < 1000 || i4 >= 1006)) {
            i4 = 13;
        }
        AbstractC0557a.a0(new Status(i4, null), null, this.zza);
    }
}
