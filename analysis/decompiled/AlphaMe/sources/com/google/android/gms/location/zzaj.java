package com.google.android.gms.location;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.ShowFirstParty;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.k;
import com.stepos.statsrpk.c;
import java.util.Arrays;
import s.AbstractC0831a;
import t0.J;

@ShowFirstParty
@SafeParcelable.Class(creator = "UserPreferredSleepWindowCreator")
@SafeParcelable.Reserved({1000})
/* loaded from: classes.dex */
public final class zzaj extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzaj> CREATOR = new k(15);

    /* renamed from: a, reason: collision with root package name */
    public final int f10095a;

    /* renamed from: b, reason: collision with root package name */
    public final int f10096b;

    /* renamed from: c, reason: collision with root package name */
    public final int f10097c;

    /* renamed from: d, reason: collision with root package name */
    public final int f10098d;

    public zzaj(int i4, int i5, int i6, int i7) {
        c.n("Start hour must be in range [0, 23].", i4 >= 0 && i4 <= 23);
        c.n("Start minute must be in range [0, 59].", i5 >= 0 && i5 <= 59);
        c.n("End hour must be in range [0, 23].", i6 >= 0 && i6 <= 23);
        c.n("End minute must be in range [0, 59].", i7 >= 0 && i7 <= 59);
        c.n("Parameters can't be all 0.", ((i4 + i5) + i6) + i7 > 0);
        this.f10095a = i4;
        this.f10096b = i5;
        this.f10097c = i6;
        this.f10098d = i7;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof zzaj)) {
            return false;
        }
        zzaj zzajVar = (zzaj) obj;
        return this.f10095a == zzajVar.f10095a && this.f10096b == zzajVar.f10096b && this.f10097c == zzajVar.f10097c && this.f10098d == zzajVar.f10098d;
    }

    public final int hashCode() {
        return Arrays.hashCode(new Object[]{Integer.valueOf(this.f10095a), Integer.valueOf(this.f10096b), Integer.valueOf(this.f10097c), Integer.valueOf(this.f10098d)});
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder("UserPreferredSleepWindow [startHour=");
        sb.append(this.f10095a);
        sb.append(", startMinute=");
        sb.append(this.f10096b);
        sb.append(", endHour=");
        sb.append(this.f10097c);
        sb.append(", endMinute=");
        return AbstractC0831a.d(sb, this.f10098d, "]");
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i4) {
        c.l(parcel);
        int iZ = J.Z(parcel, 20293);
        J.c0(parcel, 1, 4);
        parcel.writeInt(this.f10095a);
        J.c0(parcel, 2, 4);
        parcel.writeInt(this.f10096b);
        J.c0(parcel, 3, 4);
        parcel.writeInt(this.f10097c);
        J.c0(parcel, 4, 4);
        parcel.writeInt(this.f10098d);
        J.b0(parcel, iZ);
    }
}
