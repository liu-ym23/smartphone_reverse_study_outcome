package com.google.android.gms.internal.mlkit_vision_barcode;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import p2.C5047a;
import z2.C6194l8;

/* loaded from: classes2.dex */
public final class zzj extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzj> CREATOR = new C6194l8();
    public int zza;
    public int zzb;
    public int zzc;
    public int zzd;
    public int zze;
    public int zzf;
    public boolean zzg;
    public String zzh;

    public zzj() {
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i10) {
        int iA = C5047a.a(parcel);
        C5047a.p(parcel, 2, this.zza);
        C5047a.p(parcel, 3, this.zzb);
        C5047a.p(parcel, 4, this.zzc);
        C5047a.p(parcel, 5, this.zzd);
        C5047a.p(parcel, 6, this.zze);
        C5047a.p(parcel, 7, this.zzf);
        C5047a.g(parcel, 8, this.zzg);
        C5047a.x(parcel, 9, this.zzh, false);
        C5047a.b(parcel, iA);
    }

    public zzj(int i10, int i11, int i12, int i13, int i14, int i15, boolean z10, String str) {
        this.zza = i10;
        this.zzb = i11;
        this.zzc = i12;
        this.zzd = i13;
        this.zze = i14;
        this.zzf = i15;
        this.zzg = z10;
        this.zzh = str;
    }
}
