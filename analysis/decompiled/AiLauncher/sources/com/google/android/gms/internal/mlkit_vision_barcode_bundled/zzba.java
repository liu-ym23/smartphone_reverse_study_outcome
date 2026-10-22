package com.google.android.gms.internal.mlkit_vision_barcode_bundled;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import p2.C5047a;

/* loaded from: classes2.dex */
public final class zzba extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzba> CREATOR = new C1742n();
    private final int zza;
    private final boolean zzb;

    public zzba(int i10, boolean z10) {
        this.zza = i10;
        this.zzb = z10;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i10) {
        int iA = C5047a.a(parcel);
        C5047a.p(parcel, 1, this.zza);
        C5047a.g(parcel, 2, this.zzb);
        C5047a.b(parcel, iA);
    }

    public final int zza() {
        return this.zza;
    }

    public final boolean zzb() {
        return this.zzb;
    }
}
