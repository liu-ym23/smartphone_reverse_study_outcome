package com.google.android.gms.internal.mlkit_vision_barcode_bundled;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import p2.C5047a;

/* loaded from: classes2.dex */
public final class zzap extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzap> CREATOR = new C1761s();
    private final zzat zza;
    private final String zzb;
    private final String zzc;
    private final zzau[] zzd;
    private final zzar[] zze;
    private final String[] zzf;
    private final zzam[] zzg;

    public zzap(zzat zzatVar, String str, String str2, zzau[] zzauVarArr, zzar[] zzarVarArr, String[] strArr, zzam[] zzamVarArr) {
        this.zza = zzatVar;
        this.zzb = str;
        this.zzc = str2;
        this.zzd = zzauVarArr;
        this.zze = zzarVarArr;
        this.zzf = strArr;
        this.zzg = zzamVarArr;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i10) {
        zzat zzatVar = this.zza;
        int iA = C5047a.a(parcel);
        C5047a.w(parcel, 1, zzatVar, i10, false);
        C5047a.x(parcel, 2, this.zzb, false);
        C5047a.x(parcel, 3, this.zzc, false);
        C5047a.A(parcel, 4, this.zzd, i10, false);
        C5047a.A(parcel, 5, this.zze, i10, false);
        C5047a.y(parcel, 6, this.zzf, false);
        C5047a.A(parcel, 7, this.zzg, i10, false);
        C5047a.b(parcel, iA);
    }
}
