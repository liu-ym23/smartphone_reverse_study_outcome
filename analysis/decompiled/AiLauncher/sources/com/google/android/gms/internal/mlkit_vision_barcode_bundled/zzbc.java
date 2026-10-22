package com.google.android.gms.internal.mlkit_vision_barcode_bundled;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import p2.C5047a;

/* loaded from: classes2.dex */
public final class zzbc extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzbc> CREATOR = new C1746o();
    private final zzbt zza;
    private final zzbv zzb;
    private final boolean zzc = true;
    private final boolean zzd;

    public zzbc(zzbt zzbtVar, zzbv zzbvVar, boolean z10, boolean z11) {
        this.zza = zzbtVar;
        this.zzb = zzbvVar;
        this.zzd = z11;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i10) {
        int iA = C5047a.a(parcel);
        C5047a.w(parcel, 1, this.zza, i10, false);
        C5047a.w(parcel, 2, this.zzb, i10, false);
        C5047a.g(parcel, 3, this.zzc);
        C5047a.g(parcel, 4, this.zzd);
        C5047a.b(parcel, iA);
    }

    public final zzbt zza() {
        return this.zza;
    }

    public final boolean zzb() {
        return this.zzd;
    }
}
