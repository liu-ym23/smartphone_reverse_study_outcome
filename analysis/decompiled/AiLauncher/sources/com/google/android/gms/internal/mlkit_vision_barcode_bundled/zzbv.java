package com.google.android.gms.internal.mlkit_vision_barcode_bundled;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import p2.C5047a;

/* loaded from: classes2.dex */
public final class zzbv extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzbv> CREATOR = new C1785y();
    private final float[] zza;

    public zzbv(float[] fArr) {
        this.zza = fArr;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i10) {
        float[] fArr = this.zza;
        int iA = C5047a.a(parcel);
        C5047a.n(parcel, 1, fArr, false);
        C5047a.b(parcel, iA);
    }
}
