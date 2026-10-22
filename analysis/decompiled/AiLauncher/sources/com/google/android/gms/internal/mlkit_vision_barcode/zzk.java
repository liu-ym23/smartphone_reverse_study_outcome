package com.google.android.gms.internal.mlkit_vision_barcode;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import p2.C5047a;
import z2.M8;

/* loaded from: classes2.dex */
public final class zzk extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzk> CREATOR = new M8();
    public String zza;
    public String zzb;
    public String zzc;
    public String zzd;
    public String zze;
    public zzj zzf;
    public zzj zzg;

    public zzk() {
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i10) {
        int iA = C5047a.a(parcel);
        C5047a.x(parcel, 2, this.zza, false);
        C5047a.x(parcel, 3, this.zzb, false);
        C5047a.x(parcel, 4, this.zzc, false);
        C5047a.x(parcel, 5, this.zzd, false);
        C5047a.x(parcel, 6, this.zze, false);
        C5047a.w(parcel, 7, this.zzf, i10, false);
        C5047a.w(parcel, 8, this.zzg, i10, false);
        C5047a.b(parcel, iA);
    }

    public zzk(String str, String str2, String str3, String str4, String str5, zzj zzjVar, zzj zzjVar2) {
        this.zza = str;
        this.zzb = str2;
        this.zzc = str3;
        this.zzd = str4;
        this.zze = str5;
        this.zzf = zzjVar;
        this.zzg = zzjVar2;
    }
}
