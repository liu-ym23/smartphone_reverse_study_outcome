package com.google.android.gms.location;

import B0.f;
import B0.g;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.WorkSource;
import androidx.annotation.NonNull;
import com.airbnb.lottie.h;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.k;
import com.google.android.gms.internal.location.e;
import com.google.android.gms.internal.location.zzd;
import e1.b;
import java.util.Arrays;
import kotlin.jvm.internal.LongCompanionObject;
import t0.J;

@SafeParcelable.Class(creator = "CurrentLocationRequestCreator")
/* loaded from: classes.dex */
public final class CurrentLocationRequest extends AbstractSafeParcelable {

    @NonNull
    public static final Parcelable.Creator<CurrentLocationRequest> CREATOR = new k(22);

    /* renamed from: a, reason: collision with root package name */
    public final long f10022a;

    /* renamed from: b, reason: collision with root package name */
    public final int f10023b;

    /* renamed from: c, reason: collision with root package name */
    public final int f10024c;

    /* renamed from: d, reason: collision with root package name */
    public final long f10025d;

    /* renamed from: e, reason: collision with root package name */
    public final boolean f10026e;

    /* renamed from: f, reason: collision with root package name */
    public final int f10027f;

    /* renamed from: g, reason: collision with root package name */
    public final String f10028g;

    /* renamed from: h, reason: collision with root package name */
    public final WorkSource f10029h;

    /* renamed from: i, reason: collision with root package name */
    public final zzd f10030i;

    public CurrentLocationRequest(long j4, int i4, int i5, long j5, boolean z4, int i6, String str, WorkSource workSource, zzd zzdVar) {
        if (str != null) {
            throw new IllegalArgumentException();
        }
        this.f10022a = j4;
        this.f10023b = i4;
        this.f10024c = i5;
        this.f10025d = j5;
        this.f10026e = z4;
        this.f10027f = i6;
        this.f10028g = str;
        this.f10029h = workSource;
        this.f10030i = zzdVar;
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof CurrentLocationRequest)) {
            return false;
        }
        CurrentLocationRequest currentLocationRequest = (CurrentLocationRequest) obj;
        return this.f10022a == currentLocationRequest.f10022a && this.f10023b == currentLocationRequest.f10023b && this.f10024c == currentLocationRequest.f10024c && this.f10025d == currentLocationRequest.f10025d && this.f10026e == currentLocationRequest.f10026e && this.f10027f == currentLocationRequest.f10027f && h.m(this.f10028g, currentLocationRequest.f10028g) && h.m(this.f10029h, currentLocationRequest.f10029h) && h.m(this.f10030i, currentLocationRequest.f10030i);
    }

    public final int hashCode() {
        return Arrays.hashCode(new Object[]{Long.valueOf(this.f10022a), Integer.valueOf(this.f10023b), Integer.valueOf(this.f10024c), Long.valueOf(this.f10025d)});
    }

    public final String toString() {
        String str;
        StringBuilder sbS = g.s("CurrentLocationRequest[");
        sbS.append(f.G0(this.f10024c));
        long j4 = this.f10022a;
        if (j4 != LongCompanionObject.MAX_VALUE) {
            sbS.append(", maxAge=");
            e.a(sbS, j4);
        }
        long j5 = this.f10025d;
        if (j5 != LongCompanionObject.MAX_VALUE) {
            sbS.append(", duration=");
            sbS.append(j5);
            sbS.append("ms");
        }
        int i4 = this.f10023b;
        if (i4 != 0) {
            sbS.append(", ");
            sbS.append(h.N(i4));
        }
        if (this.f10026e) {
            sbS.append(", bypass");
        }
        int i5 = this.f10027f;
        if (i5 != 0) {
            sbS.append(", ");
            if (i5 == 0) {
                str = "THROTTLE_BACKGROUND";
            } else if (i5 == 1) {
                str = "THROTTLE_ALWAYS";
            } else {
                if (i5 != 2) {
                    throw new IllegalArgumentException();
                }
                str = "THROTTLE_NEVER";
            }
            sbS.append(str);
        }
        String str2 = this.f10028g;
        if (str2 != null) {
            sbS.append(", moduleId=");
            sbS.append(str2);
        }
        WorkSource workSource = this.f10029h;
        if (!b.a(workSource)) {
            sbS.append(", workSource=");
            sbS.append(workSource);
        }
        zzd zzdVar = this.f10030i;
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
        parcel.writeLong(this.f10022a);
        J.c0(parcel, 2, 4);
        parcel.writeInt(this.f10023b);
        J.c0(parcel, 3, 4);
        parcel.writeInt(this.f10024c);
        J.c0(parcel, 4, 8);
        parcel.writeLong(this.f10025d);
        J.c0(parcel, 5, 4);
        parcel.writeInt(this.f10026e ? 1 : 0);
        J.T(parcel, 6, this.f10029h, i4);
        J.c0(parcel, 7, 4);
        parcel.writeInt(this.f10027f);
        J.U(parcel, 8, this.f10028g);
        J.T(parcel, 9, this.f10030i, i4);
        J.b0(parcel, iZ);
    }
}
