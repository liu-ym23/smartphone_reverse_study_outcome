package com.google.android.gms.internal.mlkit_vision_barcode_bundled;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import p2.C5047a;

/* loaded from: classes2.dex */
public final class zzbt extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzbt> CREATOR = new C1781x();
    private final float[] zza;
    private final int zzb;
    private final boolean zzc;

    public zzbt(float[] fArr, int i10, boolean z10) {
        this.zza = fArr;
        this.zzb = i10;
        this.zzc = z10;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i10) {
        float[] fArr = this.zza;
        int iA = C5047a.a(parcel);
        C5047a.n(parcel, 1, fArr, false);
        C5047a.p(parcel, 2, this.zzb);
        C5047a.g(parcel, 3, this.zzc);
        C5047a.b(parcel, iA);
    }

    public final int zza() {
        return this.zzb;
    }

    public final boolean zzb() {
        return this.zzc;
    }

    public final float[] zzc() {
        return this.zza;
    }
}
