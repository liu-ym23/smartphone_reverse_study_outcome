package com.google.android.gms.maps.model;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.NonNull;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import t0.J;

@SafeParcelable.Class(creator = "TileCreator")
@SafeParcelable.Reserved({1})
/* loaded from: classes.dex */
public final class Tile extends AbstractSafeParcelable {

    @NonNull
    public static final Parcelable.Creator<Tile> CREATOR = new c(22);

    /* renamed from: a, reason: collision with root package name */
    public final int f10234a;

    /* renamed from: b, reason: collision with root package name */
    public final int f10235b;

    /* renamed from: c, reason: collision with root package name */
    public final byte[] f10236c;

    public Tile(int i4, int i5, byte[] bArr) {
        this.f10234a = i4;
        this.f10235b = i5;
        this.f10236c = bArr;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i4) {
        int iZ = J.Z(parcel, 20293);
        J.c0(parcel, 2, 4);
        parcel.writeInt(this.f10234a);
        J.c0(parcel, 3, 4);
        parcel.writeInt(this.f10235b);
        byte[] bArr = this.f10236c;
        if (bArr != null) {
            int iZ2 = J.Z(parcel, 4);
            parcel.writeByteArray(bArr);
            J.b0(parcel, iZ2);
        }
        J.b0(parcel, iZ);
    }
}
