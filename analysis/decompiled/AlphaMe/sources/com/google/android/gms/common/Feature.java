package com.google.android.gms.common;

import a1.C0154a;
import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.NonNull;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.stepos.activeview.utils.Constants;
import java.util.Arrays;
import t0.J;

@KeepForSdk
@SafeParcelable.Class(creator = "FeatureCreator")
/* loaded from: classes.dex */
public class Feature extends AbstractSafeParcelable {

    @NonNull
    public static final Parcelable.Creator<Feature> CREATOR = new C0154a(29);

    /* renamed from: a, reason: collision with root package name */
    public final String f9601a;

    /* renamed from: b, reason: collision with root package name */
    public final int f9602b;

    /* renamed from: c, reason: collision with root package name */
    public final long f9603c;

    public Feature() {
        this.f9601a = "CLIENT_TELEMETRY";
        this.f9603c = 1L;
        this.f9602b = -1;
    }

    public final long N() {
        long j4 = this.f9603c;
        return j4 == -1 ? this.f9602b : j4;
    }

    public final boolean equals(Object obj) {
        if (obj instanceof Feature) {
            Feature feature = (Feature) obj;
            String str = this.f9601a;
            if (((str != null && str.equals(feature.f9601a)) || (str == null && feature.f9601a == null)) && N() == feature.N()) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        return Arrays.hashCode(new Object[]{this.f9601a, Long.valueOf(N())});
    }

    public final String toString() {
        B0.e eVar = new B0.e(this);
        eVar.a(this.f9601a, "name");
        eVar.a(Long.valueOf(N()), Constants.JSON_KEY_VERSION);
        return eVar.toString();
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i4) {
        int iZ = J.Z(parcel, 20293);
        J.U(parcel, 1, this.f9601a);
        J.c0(parcel, 2, 4);
        parcel.writeInt(this.f9602b);
        long jN = N();
        J.c0(parcel, 3, 8);
        parcel.writeLong(jN);
        J.b0(parcel, iZ);
    }

    public Feature(String str, int i4, long j4) {
        this.f9601a = str;
        this.f9602b = i4;
        this.f9603c = j4;
    }
}
