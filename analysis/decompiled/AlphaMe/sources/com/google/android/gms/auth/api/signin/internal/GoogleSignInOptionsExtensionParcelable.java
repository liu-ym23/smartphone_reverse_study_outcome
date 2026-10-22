package com.google.android.gms.auth.api.signin.internal;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.NonNull;
import b.C0354a;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import t0.J;

@SafeParcelable.Class(creator = "GoogleSignInOptionsExtensionCreator")
/* loaded from: classes.dex */
public class GoogleSignInOptionsExtensionParcelable extends AbstractSafeParcelable {

    @NonNull
    public static final Parcelable.Creator<GoogleSignInOptionsExtensionParcelable> CREATOR = new C0354a(24);

    /* renamed from: a, reason: collision with root package name */
    public final int f9593a;

    /* renamed from: b, reason: collision with root package name */
    public final int f9594b;

    /* renamed from: c, reason: collision with root package name */
    public final Bundle f9595c;

    public GoogleSignInOptionsExtensionParcelable(int i4, int i5, Bundle bundle) {
        this.f9593a = i4;
        this.f9594b = i5;
        this.f9595c = bundle;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i4) {
        int iZ = J.Z(parcel, 20293);
        J.c0(parcel, 1, 4);
        parcel.writeInt(this.f9593a);
        J.c0(parcel, 2, 4);
        parcel.writeInt(this.f9594b);
        J.P(parcel, 3, this.f9595c);
        J.b0(parcel, iZ);
    }
}
