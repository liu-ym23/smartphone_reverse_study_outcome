package com.google.android.gms.location;

import B0.g;
import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.NonNull;
import com.airbnb.lottie.h;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.k;
import com.google.android.gms.internal.location.e;
import com.google.android.gms.internal.location.zzd;
import java.util.Arrays;
import kotlin.jvm.internal.LongCompanionObject;
import t0.J;

@SafeParcelable.Class(creator = "LastLocationRequestCreator")
/* loaded from: classes.dex */
public final class LastLocationRequest extends AbstractSafeParcelable {

    @NonNull
    public static final Parcelable.Creator<LastLocationRequest> CREATOR = new k(25);

    /* renamed from: a, reason: collision with root package name */
    public final long f10037a;

    /* renamed from: b, reason: collision with root package name */
    public final int f10038b;

    /* renamed from: c, reason: collision with root package name */
    public final boolean f10039c;

    /* renamed from: d, reason: collision with root package name */
    public final String f10040d;

    /* renamed from: e, reason: collision with root package name */
    public final zzd f10041e;

    public LastLocationRequest(long j4, int i4, boolean z4, String str, zzd zzdVar) {
        this.f10037a = j4;
        this.f10038b = i4;
        this.f10039c = z4;
        this.f10040d = str;
        this.f10041e = zzdVar;
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof LastLocationRequest)) {
            return false;
        }
        LastLocationRequest lastLocationRequest = (LastLocationRequest) obj;
        return this.f10037a == lastLocationRequest.f10037a && this.f10038b == lastLocationRequest.f10038b && this.f10039c == lastLocationRequest.f10039c && h.m(this.f10040d, lastLocationRequest.f10040d) && h.m(this.f10041e, lastLocationRequest.f10041e);
    }

    public final int hashCode() {
        return Arrays.hashCode(new Object[]{Long.valueOf(this.f10037a), Integer.valueOf(this.f10038b), Boolean.valueOf(this.f10039c)});
    }

    public final String toString() {
        StringBuilder sbS = g.s("LastLocationRequest[");
        long j4 = this.f10037a;
        if (j4 != LongCompanionObject.MAX_VALUE) {
            sbS.append("maxAge=");
            e.a(sbS, j4);
        }
        int i4 = this.f10038b;
        if (i4 != 0) {
            sbS.append(", ");
            sbS.append(h.N(i4));
        }
        if (this.f10039c) {
            sbS.append(", bypass");
        }
        String str = this.f10040d;
        if (str != null) {
            sbS.append(", moduleId=");
            sbS.append(str);
        }
        zzd zzdVar = this.f10041e;
        if (zzdVar != null) {
            sbS.append(", impersonation=");
            sbS.append(zzdVar);
        }
        sbS.append(']');
        return sbS.toString();
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i4) {
        int iZ = J.Z(parcel, 20293);
        J.c0(parcel, 1, 8);
        parcel.writeLong(this.f10037a);
        J.c0(parcel, 2, 4);
        parcel.writeInt(this.f10038b);
        J.c0(parcel, 3, 4);
        parcel.writeInt(this.f10039c ? 1 : 0);
        J.U(parcel, 4, this.f10040d);
        J.T(parcel, 5, this.f10041e, i4);
        J.b0(parcel, iZ);
    }
}
