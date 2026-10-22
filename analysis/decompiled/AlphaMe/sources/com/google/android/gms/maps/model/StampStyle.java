package com.google.android.gms.maps.model;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.NonNull;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.dynamic.IObjectWrapper;
import t0.J;

@SafeParcelable.Class(creator = "StampStyleCreator")
@SafeParcelable.Reserved({1})
/* loaded from: classes.dex */
public class StampStyle extends AbstractSafeParcelable {

    @NonNull
    public static final Parcelable.Creator<StampStyle> CREATOR = new c(14);

    /* renamed from: a, reason: collision with root package name */
    public final a f10214a;

    public StampStyle(IBinder iBinder) {
        this.f10214a = new a(IObjectWrapper.Stub.asInterface(iBinder));
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i4) {
        int iZ = J.Z(parcel, 20293);
        J.R(parcel, 2, this.f10214a.f10247a.asBinder());
        J.b0(parcel, iZ);
    }
}
