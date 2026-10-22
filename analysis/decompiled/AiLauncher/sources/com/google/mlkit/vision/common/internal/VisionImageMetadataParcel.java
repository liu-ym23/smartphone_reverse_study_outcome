package com.google.mlkit.vision.common.internal;

import android.graphics.Matrix;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import p2.C5047a;
import y3.d;
import y3.j;

/* loaded from: classes2.dex */
public class VisionImageMetadataParcel extends AbstractSafeParcelable {
    public static final Parcelable.Creator<VisionImageMetadataParcel> CREATOR = new j();
    public final int height;
    public final int rotation;
    public final long timestampMillis;
    public final int width;
    public final int zza;

    public VisionImageMetadataParcel(int i10, int i11, int i12, long j10, int i13) {
        this.width = i10;
        this.height = i11;
        this.zza = i12;
        this.timestampMillis = j10;
        this.rotation = i13;
    }

    public Matrix getUprightRotationMatrix() {
        return d.b().d(this.width, this.height, this.rotation);
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i10) {
        int iA = C5047a.a(parcel);
        C5047a.p(parcel, 1, this.width);
        C5047a.p(parcel, 2, this.height);
        C5047a.p(parcel, 3, this.zza);
        C5047a.r(parcel, 4, this.timestampMillis);
        C5047a.p(parcel, 5, this.rotation);
        C5047a.b(parcel, iA);
    }
}
