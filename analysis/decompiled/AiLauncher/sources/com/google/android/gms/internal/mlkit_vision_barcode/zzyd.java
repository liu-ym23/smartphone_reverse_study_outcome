package com.google.android.gms.internal.mlkit_vision_barcode;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import p2.C5047a;
import z2.V8;

/* loaded from: classes2.dex */
public final class zzyd extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzyd> CREATOR = new V8();
    private final int zza;
    private final boolean zzb;

    public zzyd(int i10, boolean z10) {
        this.zza = i10;
        this.zzb = z10;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i10) {
        int i11 = this.zza;
        int iA = C5047a.a(parcel);
        C5047a.p(parcel, 1, i11);
        C5047a.g(parcel, 2, this.zzb);
        C5047a.b(parcel, iA);
    }
}
