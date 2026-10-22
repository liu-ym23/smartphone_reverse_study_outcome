package com.google.android.gms.location;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.ShowFirstParty;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.k;
import java.util.Arrays;
import t0.J;

@ShowFirstParty
@SafeParcelable.Class(creator = "NetworkLocationStatusCreator")
@Deprecated
/* loaded from: classes.dex */
public final class zzac extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzac> CREATOR = new k(11);

    /* renamed from: a, reason: collision with root package name */
    public final int f10091a;

    /* renamed from: b, reason: collision with root package name */
    public final int f10092b;

    /* renamed from: c, reason: collision with root package name */
    public final long f10093c;

    /* renamed from: d, reason: collision with root package name */
    public final long f10094d;

    public zzac(long j4, int i4, long j5, int i5) {
        this.f10091a = i4;
        this.f10092b = i5;
        this.f10093c = j4;
        this.f10094d = j5;
    }

    public final boolean equals(Object obj) {
        if (obj instanceof zzac) {
            zzac zzacVar = (zzac) obj;
            if (this.f10091a == zzacVar.f10091a && this.f10092b == zzacVar.f10092b && this.f10093c == zzacVar.f10093c && this.f10094d == zzacVar.f10094d) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        return Arrays.hashCode(new Object[]{Integer.valueOf(this.f10092b), Integer.valueOf(this.f10091a), Long.valueOf(this.f10094d), Long.valueOf(this.f10093c)});
    }

    public final String toString() {
        return "NetworkLocationStatus: Wifi status: " + this.f10091a + " Cell status: " + this.f10092b + " elapsed time NS: " + this.f10094d + " system time ms: " + this.f10093c;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i4) {
        int iZ = J.Z(parcel, 20293);
        J.c0(parcel, 1, 4);
        parcel.writeInt(this.f10091a);
        J.c0(parcel, 2, 4);
        parcel.writeInt(this.f10092b);
        J.c0(parcel, 3, 8);
        parcel.writeLong(this.f10093c);
        J.c0(parcel, 4, 8);
        parcel.writeLong(this.f10094d);
        J.b0(parcel, iZ);
    }
}
