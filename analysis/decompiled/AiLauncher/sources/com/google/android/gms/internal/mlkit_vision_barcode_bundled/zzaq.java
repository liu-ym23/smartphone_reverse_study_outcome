package com.google.android.gms.internal.mlkit_vision_barcode_bundled;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import p2.C5047a;

/* loaded from: classes2.dex */
public final class zzaq extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzaq> CREATOR = new C1765t();
    private final String zza;
    private final String zzb;
    private final String zzc;
    private final String zzd;
    private final String zze;
    private final String zzf;
    private final String zzg;
    private final String zzh;
    private final String zzi;
    private final String zzj;
    private final String zzk;
    private final String zzl;
    private final String zzm;
    private final String zzn;

    public zzaq(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9, String str10, String str11, String str12, String str13, String str14) {
        this.zza = str;
        this.zzb = str2;
        this.zzc = str3;
        this.zzd = str4;
        this.zze = str5;
        this.zzf = str6;
        this.zzg = str7;
        this.zzh = str8;
        this.zzi = str9;
        this.zzj = str10;
        this.zzk = str11;
        this.zzl = str12;
        this.zzm = str13;
        this.zzn = str14;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i10) {
        String str = this.zza;
        int iA = C5047a.a(parcel);
        C5047a.x(parcel, 1, str, false);
        C5047a.x(parcel, 2, this.zzb, false);
        C5047a.x(parcel, 3, this.zzc, false);
        C5047a.x(parcel, 4, this.zzd, false);
        C5047a.x(parcel, 5, this.zze, false);
        C5047a.x(parcel, 6, this.zzf, false);
        C5047a.x(parcel, 7, this.zzg, false);
        C5047a.x(parcel, 8, this.zzh, false);
        C5047a.x(parcel, 9, this.zzi, false);
        C5047a.x(parcel, 10, this.zzj, false);
        C5047a.x(parcel, 11, this.zzk, false);
        C5047a.x(parcel, 12, this.zzl, false);
        C5047a.x(parcel, 13, this.zzm, false);
        C5047a.x(parcel, 14, this.zzn, false);
        C5047a.b(parcel, iA);
    }
}
