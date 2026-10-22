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
@SafeParcelable.Class(creator = "ConnectionTelemetryConfigurationCreator")
/* loaded from: classes.dex */
public class ConnectionTelemetryConfiguration extends AbstractSafeParcelable {

    @NonNull
    @KeepForSdk
    public static final Parcelable.Creator<ConnectionTelemetryConfiguration> CREATOR = new C0154a(12);

    /* renamed from: a, reason: collision with root package name */
    public final RootTelemetryConfiguration f9733a;

    /* renamed from: b, reason: collision with root package name */
    public final boolean f9734b;

    /* renamed from: c, reason: collision with root package name */
    public final boolean f9735c;

    /* renamed from: d, reason: collision with root package name */
    public final int[] f9736d;

    /* renamed from: e, reason: collision with root package name */
    public final int f9737e;

    /* renamed from: f, reason: collision with root package name */
    public final int[] f9738f;

    public ConnectionTelemetryConfiguration(RootTelemetryConfiguration rootTelemetryConfiguration, boolean z4, boolean z5, int[] iArr, int i4, int[] iArr2) {
        this.f9733a = rootTelemetryConfiguration;
        this.f9734b = z4;
        this.f9735c = z5;
        this.f9736d = iArr;
        this.f9737e = i4;
        this.f9738f = iArr2;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i4) {
        int iZ = J.Z(parcel, 20293);
        J.T(parcel, 1, this.f9733a, i4);
        J.c0(parcel, 2, 4);
        parcel.writeInt(this.f9734b ? 1 : 0);
        J.c0(parcel, 3, 4);
        parcel.writeInt(this.f9735c ? 1 : 0);
        J.S(parcel, 4, this.f9736d);
        J.c0(parcel, 5, 4);
        parcel.writeInt(this.f9737e);
        J.S(parcel, 6, this.f9738f);
        J.b0(parcel, iZ);
    }
}
