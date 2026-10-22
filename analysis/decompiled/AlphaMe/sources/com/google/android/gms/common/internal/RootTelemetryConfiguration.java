package com.google.android.gms.common.internal;

import a1.C0154a;
import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.NonNull;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import t0.J;

@KeepForSdk
@SafeParcelable.Class(creator = "RootTelemetryConfigurationCreator")
/* loaded from: classes.dex */
public class RootTelemetryConfiguration extends AbstractSafeParcelable {

    @NonNull
    @KeepForSdk
    public static final Parcelable.Creator<RootTelemetryConfiguration> CREATOR = new C0154a(8);

    /* renamed from: a, reason: collision with root package name */
    public final int f9764a;

    /* renamed from: b, reason: collision with root package name */
    public final boolean f9765b;

    /* renamed from: c, reason: collision with root package name */
    public final boolean f9766c;

    /* renamed from: d, reason: collision with root package name */
    public final int f9767d;

    /* renamed from: e, reason: collision with root package name */
    public final int f9768e;

    public RootTelemetryConfiguration(int i4, int i5, int i6, boolean z4, boolean z5) {
        this.f9764a = i4;
        this.f9765b = z4;
        this.f9766c = z5;
        this.f9767d = i5;
        this.f9768e = i6;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i4) {
        int iZ = J.Z(parcel, 20293);
        J.c0(parcel, 1, 4);
        parcel.writeInt(this.f9764a);
        J.c0(parcel, 2, 4);
        parcel.writeInt(this.f9765b ? 1 : 0);
        J.c0(parcel, 3, 4);
        parcel.writeInt(this.f9766c ? 1 : 0);
        J.c0(parcel, 4, 4);
        parcel.writeInt(this.f9767d);
        J.c0(parcel, 5, 4);
        parcel.writeInt(this.f9768e);
        J.b0(parcel, iZ);
    }
}
