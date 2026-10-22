package com.google.android.gms.internal.location;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.room.AbstractC0351g;
import ch.qos.logback.classic.spi.CallerData;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.util.VisibleForTesting;
import com.stepos.alphame.utils.Property;
import java.util.Locale;
import t0.J;

@VisibleForTesting
@SafeParcelable.Class(creator = "ParcelableGeofenceCreator")
@SafeParcelable.Reserved({1000})
/* loaded from: classes.dex */
public final class zzdh extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzdh> CREATOR = new com.google.android.gms.common.k(6);

    /* renamed from: a, reason: collision with root package name */
    public final String f9995a;

    /* renamed from: b, reason: collision with root package name */
    public final long f9996b;

    /* renamed from: c, reason: collision with root package name */
    public final short f9997c;

    /* renamed from: d, reason: collision with root package name */
    public final double f9998d;

    /* renamed from: e, reason: collision with root package name */
    public final double f9999e;

    /* renamed from: f, reason: collision with root package name */
    public final float f10000f;

    /* renamed from: g, reason: collision with root package name */
    public final int f10001g;

    /* renamed from: h, reason: collision with root package name */
    public final int f10002h;

    /* renamed from: i, reason: collision with root package name */
    public final int f10003i;

    public zzdh(String str, int i4, short s4, double d4, double d5, float f4, long j4, int i5, int i6) {
        if (str == null || str.length() > 100) {
            throw new IllegalArgumentException("requestId is null or too long: ".concat(String.valueOf(str)));
        }
        if (f4 <= Property.DEFAULT_FLOAT_VALUE) {
            throw new IllegalArgumentException("invalid radius: " + f4);
        }
        if (d4 > 90.0d || d4 < -90.0d) {
            throw new IllegalArgumentException("invalid latitude: " + d4);
        }
        if (d5 > 180.0d || d5 < -180.0d) {
            throw new IllegalArgumentException("invalid longitude: " + d5);
        }
        int i7 = i4 & 7;
        if (i7 == 0) {
            throw new IllegalArgumentException(AbstractC0351g.m("No supported transition specified: ", i4));
        }
        this.f9997c = s4;
        this.f9995a = str;
        this.f9998d = d4;
        this.f9999e = d5;
        this.f10000f = f4;
        this.f9996b = j4;
        this.f10001g = i7;
        this.f10002h = i5;
        this.f10003i = i6;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof zzdh) {
            zzdh zzdhVar = (zzdh) obj;
            if (this.f10000f == zzdhVar.f10000f && this.f9998d == zzdhVar.f9998d && this.f9999e == zzdhVar.f9999e && this.f9997c == zzdhVar.f9997c) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        long jDoubleToLongBits = Double.doubleToLongBits(this.f9998d);
        long jDoubleToLongBits2 = Double.doubleToLongBits(this.f9999e);
        return ((((Float.floatToIntBits(this.f10000f) + ((((((int) (jDoubleToLongBits ^ (jDoubleToLongBits >>> 32))) + 31) * 31) + ((int) (jDoubleToLongBits2 ^ (jDoubleToLongBits2 >>> 32)))) * 31)) * 31) + this.f9997c) * 31) + this.f10001g;
    }

    public final String toString() {
        Locale locale = Locale.US;
        Object[] objArr = new Object[9];
        short s4 = this.f9997c;
        objArr[0] = s4 != -1 ? s4 != 1 ? "UNKNOWN" : "CIRCLE" : "INVALID";
        objArr[1] = this.f9995a.replaceAll("\\p{C}", CallerData.NA);
        objArr[2] = Integer.valueOf(this.f10001g);
        objArr[3] = Double.valueOf(this.f9998d);
        objArr[4] = Double.valueOf(this.f9999e);
        objArr[5] = Float.valueOf(this.f10000f);
        objArr[6] = Integer.valueOf(this.f10002h / 1000);
        objArr[7] = Integer.valueOf(this.f10003i);
        objArr[8] = Long.valueOf(this.f9996b);
        return String.format(locale, "Geofence[%s id:%s transitions:%d %.6f, %.6f %.0fm, resp=%ds, dwell=%dms, @%d]", objArr);
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i4) {
        int iZ = J.Z(parcel, 20293);
        J.U(parcel, 1, this.f9995a);
        J.c0(parcel, 2, 8);
        parcel.writeLong(this.f9996b);
        J.c0(parcel, 3, 4);
        parcel.writeInt(this.f9997c);
        J.c0(parcel, 4, 8);
        parcel.writeDouble(this.f9998d);
        J.c0(parcel, 5, 8);
        parcel.writeDouble(this.f9999e);
        J.c0(parcel, 6, 4);
        parcel.writeFloat(this.f10000f);
        J.c0(parcel, 7, 4);
        parcel.writeInt(this.f10001g);
        J.c0(parcel, 8, 4);
        parcel.writeInt(this.f10002h);
        J.c0(parcel, 9, 4);
        parcel.writeInt(this.f10003i);
        J.b0(parcel, iZ);
    }
}
