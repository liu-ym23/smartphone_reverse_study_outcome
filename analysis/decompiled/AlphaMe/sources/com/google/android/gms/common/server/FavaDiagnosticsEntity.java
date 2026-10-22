package com.google.android.gms.common.server;

import a1.C0154a;
import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.NonNull;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.internal.ReflectedParcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import t0.J;

@KeepForSdk
@SafeParcelable.Class(creator = "FavaDiagnosticsEntityCreator")
/* loaded from: classes.dex */
public class FavaDiagnosticsEntity extends AbstractSafeParcelable implements ReflectedParcelable {

    @NonNull
    @KeepForSdk
    public static final Parcelable.Creator<FavaDiagnosticsEntity> CREATOR = new C0154a(26);

    /* renamed from: a, reason: collision with root package name */
    public final int f9894a;

    /* renamed from: b, reason: collision with root package name */
    public final String f9895b;

    /* renamed from: c, reason: collision with root package name */
    public final int f9896c;

    public FavaDiagnosticsEntity(int i4, int i5, String str) {
        this.f9894a = i4;
        this.f9895b = str;
        this.f9896c = i5;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i4) {
        int iZ = J.Z(parcel, 20293);
        J.c0(parcel, 1, 4);
        parcel.writeInt(this.f9894a);
        J.U(parcel, 2, this.f9895b);
        J.c0(parcel, 3, 4);
        parcel.writeInt(this.f9896c);
        J.b0(parcel, iZ);
    }
}
