package com.google.android.gms.internal.mlkit_vision_barcode;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import p2.C5047a;
import z2.C6155i;

/* loaded from: classes2.dex */
public final class zzan extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzan> CREATOR = new C6155i();
    public int zza;
    public int zzb;
    public int zzc;
    public long zzd;
    public int zze;

    public zzan() {
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i10) {
        int iA = C5047a.a(parcel);
        C5047a.p(parcel, 2, this.zza);
        C5047a.p(parcel, 3, this.zzb);
        C5047a.p(parcel, 4, this.zzc);
        C5047a.r(parcel, 5, this.zzd);
        C5047a.p(parcel, 6, this.zze);
        C5047a.b(parcel, iA);
    }

    public zzan(int i10, int i11, int i12, long j10, int i13) {
        this.zza = i10;
        this.zzb = i11;
        this.zzc = i12;
        this.zzd = j10;
        this.zze = i13;
    }
}
