package com.google.android.gms.common.internal;

import a1.C0154a;
import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.NonNull;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import java.util.List;
import t0.J;

@KeepForSdk
@SafeParcelable.Class(creator = "TelemetryDataCreator")
/* loaded from: classes.dex */
public class TelemetryData extends AbstractSafeParcelable {

    @NonNull
    public static final Parcelable.Creator<TelemetryData> CREATOR = new C0154a(3);

    /* renamed from: a, reason: collision with root package name */
    public final int f9769a;

    /* renamed from: b, reason: collision with root package name */
    public List f9770b;

    public TelemetryData(int i4, List list) {
        this.f9769a = i4;
        this.f9770b = list;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i4) {
        int iZ = J.Z(parcel, 20293);
        J.c0(parcel, 1, 4);
        parcel.writeInt(this.f9769a);
        J.W(parcel, 2, this.f9770b);
        J.b0(parcel, iZ);
    }
}
