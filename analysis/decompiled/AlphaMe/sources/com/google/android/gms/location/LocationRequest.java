package com.google.android.gms.location;

import B0.f;
import B0.g;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.SystemClock;
import android.os.WorkSource;
import androidx.annotation.NonNull;
import com.airbnb.lottie.h;
import com.google.android.gms.common.internal.ReflectedParcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.k;
import com.google.android.gms.internal.location.e;
import com.google.android.gms.internal.location.zzd;
import com.stepos.alphame.awareness.AwarenessDataItem;
import e1.b;
import java.util.Arrays;
import kotlin.jvm.internal.LongCompanionObject;
import t0.J;

@SafeParcelable.Class(creator = "LocationRequestCreator")
@SafeParcelable.Reserved({4, 5, 1000})
/* loaded from: classes.dex */
public final class LocationRequest extends AbstractSafeParcelable implements ReflectedParcelable {

    @NonNull
    public static final Parcelable.Creator<LocationRequest> CREATOR = new k(27);

    /* renamed from: a, reason: collision with root package name */
    public final int f10047a;

    /* renamed from: b, reason: collision with root package name */
    public final long f10048b;

    /* renamed from: c, reason: collision with root package name */
    public final long f10049c;

    /* renamed from: d, reason: collision with root package name */
    public final long f10050d;

    /* renamed from: e, reason: collision with root package name */
    public final long f10051e;

    /* renamed from: f, reason: collision with root package name */
    public final int f10052f;

    /* renamed from: g, reason: collision with root package name */
    public final float f10053g;

    /* renamed from: h, reason: collision with root package name */
    public final boolean f10054h;

    /* renamed from: i, reason: collision with root package name */
    public final long f10055i;

    /* renamed from: j, reason: collision with root package name */
    public final int f10056j;

    /* renamed from: k, reason: collision with root package name */
    public final int f10057k;

    /* renamed from: l, reason: collision with root package name */
    public final String f10058l;

    /* renamed from: m, reason: collision with root package name */
    public final boolean f10059m;

    /* renamed from: n, reason: collision with root package name */
    public final WorkSource f10060n;

    /* renamed from: o, reason: collision with root package name */
    public final zzd f10061o;

    public LocationRequest(int i4, long j4, long j5, long j6, long j7, long j8, int i5, float f4, boolean z4, long j9, int i6, int i7, String str, boolean z5, WorkSource workSource, zzd zzdVar) {
        this.f10047a = i4;
        long j10 = j4;
        this.f10048b = j10;
        this.f10049c = j5;
        this.f10050d = j6;
        this.f10051e = j7 == LongCompanionObject.MAX_VALUE ? j8 : Math.min(Math.max(1L, j7 - SystemClock.elapsedRealtime()), j8);
        this.f10052f = i5;
        this.f10053g = f4;
        this.f10054h = z4;
        this.f10055i = j9 != -1 ? j9 : j10;
        this.f10056j = i6;
        this.f10057k = i7;
        this.f10058l = str;
        this.f10059m = z5;
        this.f10060n = workSource;
        this.f10061o = zzdVar;
    }

    public static String O(long j4) {
        String string;
        if (j4 == LongCompanionObject.MAX_VALUE) {
            return "∞";
        }
        StringBuilder sb = e.f9962a;
        synchronized (sb) {
            sb.setLength(0);
            e.a(sb, j4);
            string = sb.toString();
        }
        return string;
    }

    public final boolean N() {
        long j4 = this.f10050d;
        return j4 > 0 && (j4 >> 1) >= this.f10048b;
    }

    public final boolean equals(Object obj) {
        if (obj instanceof LocationRequest) {
            LocationRequest locationRequest = (LocationRequest) obj;
            int i4 = locationRequest.f10047a;
            int i5 = this.f10047a;
            if (i5 == i4 && ((i5 == 105 || this.f10048b == locationRequest.f10048b) && this.f10049c == locationRequest.f10049c && N() == locationRequest.N() && ((!N() || this.f10050d == locationRequest.f10050d) && this.f10051e == locationRequest.f10051e && this.f10052f == locationRequest.f10052f && this.f10053g == locationRequest.f10053g && this.f10054h == locationRequest.f10054h && this.f10056j == locationRequest.f10056j && this.f10057k == locationRequest.f10057k && this.f10059m == locationRequest.f10059m && this.f10060n.equals(locationRequest.f10060n) && h.m(this.f10058l, locationRequest.f10058l) && h.m(this.f10061o, locationRequest.f10061o)))) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        return Arrays.hashCode(new Object[]{Integer.valueOf(this.f10047a), Long.valueOf(this.f10048b), Long.valueOf(this.f10049c), this.f10060n});
    }

    public final String toString() {
        String str;
        StringBuilder sbS = g.s("Request[");
        int i4 = this.f10047a;
        boolean z4 = i4 == 105;
        long j4 = this.f10048b;
        if (z4) {
            sbS.append(f.G0(i4));
        } else {
            sbS.append("@");
            if (N()) {
                e.a(sbS, j4);
                sbS.append("/");
                e.a(sbS, this.f10050d);
            } else {
                e.a(sbS, j4);
            }
            sbS.append(AwarenessDataItem.PERMISSION_SPLITTER);
            sbS.append(f.G0(i4));
        }
        boolean z5 = this.f10047a == 105;
        long j5 = this.f10049c;
        if (z5 || j5 != j4) {
            sbS.append(", minUpdateInterval=");
            sbS.append(O(j5));
        }
        float f4 = this.f10053g;
        if (f4 > 0.0d) {
            sbS.append(", minUpdateDistance=");
            sbS.append(f4);
        }
        boolean z6 = this.f10047a == 105;
        long j6 = this.f10055i;
        if (!z6 ? j6 != j4 : j6 != LongCompanionObject.MAX_VALUE) {
            sbS.append(", maxUpdateAge=");
            sbS.append(O(j6));
        }
        long j7 = this.f10051e;
        if (j7 != LongCompanionObject.MAX_VALUE) {
            sbS.append(", duration=");
            e.a(sbS, j7);
        }
        int i5 = this.f10052f;
        if (i5 != Integer.MAX_VALUE) {
            sbS.append(", maxUpdates=");
            sbS.append(i5);
        }
        int i6 = this.f10057k;
        if (i6 != 0) {
            sbS.append(", ");
            if (i6 == 0) {
                str = "THROTTLE_BACKGROUND";
            } else if (i6 == 1) {
                str = "THROTTLE_ALWAYS";
            } else {
                if (i6 != 2) {
                    throw new IllegalArgumentException();
                }
                str = "THROTTLE_NEVER";
            }
            sbS.append(str);
        }
        int i7 = this.f10056j;
        if (i7 != 0) {
            sbS.append(", ");
            sbS.append(h.N(i7));
        }
        if (this.f10054h) {
            sbS.append(", waitForAccurateLocation");
        }
        if (this.f10059m) {
            sbS.append(", bypass");
        }
        String str2 = this.f10058l;
        if (str2 != null) {
            sbS.append(", moduleId=");
            sbS.append(str2);
        }
        WorkSource workSource = this.f10060n;
        if (!b.a(workSource)) {
            sbS.append(", ");
            sbS.append(workSource);
        }
        zzd zzdVar = this.f10061o;
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
        J.c0(parcel, 1, 4);
        parcel.writeInt(this.f10047a);
        J.c0(parcel, 2, 8);
        parcel.writeLong(this.f10048b);
        J.c0(parcel, 3, 8);
        parcel.writeLong(this.f10049c);
        J.c0(parcel, 6, 4);
        parcel.writeInt(this.f10052f);
        J.c0(parcel, 7, 4);
        parcel.writeFloat(this.f10053g);
        J.c0(parcel, 8, 8);
        parcel.writeLong(this.f10050d);
        J.c0(parcel, 9, 4);
        parcel.writeInt(this.f10054h ? 1 : 0);
        J.c0(parcel, 10, 8);
        parcel.writeLong(this.f10051e);
        J.c0(parcel, 11, 8);
        parcel.writeLong(this.f10055i);
        J.c0(parcel, 12, 4);
        parcel.writeInt(this.f10056j);
        J.c0(parcel, 13, 4);
        parcel.writeInt(this.f10057k);
        J.U(parcel, 14, this.f10058l);
        J.c0(parcel, 15, 4);
        parcel.writeInt(this.f10059m ? 1 : 0);
        J.T(parcel, 16, this.f10060n, i4);
        J.T(parcel, 17, this.f10061o, i4);
        J.b0(parcel, iZ);
    }
}
