package com.google.android.gms.internal.mlkit_vision_barcode_bundled;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import p2.C5047a;

/* loaded from: classes2.dex */
public final class zzbr extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzbr> CREATOR = new C1777w();
    private final boolean zza;
    private final byte[] zzb;
    private final boolean zzc;
    private final float zzd;
    private final boolean zze;

    public zzbr(boolean z10, byte[] bArr, boolean z11, float f10, boolean z12) {
        this.zza = z10;
        this.zzb = bArr;
        this.zzc = z11;
        this.zzd = f10;
        this.zze = z12;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i10) {
        boolean z10 = this.zza;
        int iA = C5047a.a(parcel);
        C5047a.g(parcel, 1, z10);
        C5047a.j(parcel, 2, this.zzb, false);
        C5047a.g(parcel, 3, this.zzc);
        C5047a.m(parcel, 4, this.zzd);
        C5047a.g(parcel, 5, this.zze);
        C5047a.b(parcel, iA);
    }
}
