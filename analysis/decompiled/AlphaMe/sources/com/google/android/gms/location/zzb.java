package com.google.android.gms.location;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.WorkSource;
import com.google.android.gms.common.internal.ShowFirstParty;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.k;
import com.stepos.statsrpk.c;
import t0.J;

@ShowFirstParty
@SafeParcelable.Class(creator = "ActivityRecognitionRequestCreator")
@SafeParcelable.Reserved({1000})
/* loaded from: classes.dex */
public final class zzb extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzb> CREATOR = new k(16);

    /* renamed from: a, reason: collision with root package name */
    public final long f10099a;

    /* renamed from: b, reason: collision with root package name */
    public final boolean f10100b;

    /* renamed from: c, reason: collision with root package name */
    public final WorkSource f10101c;

    /* renamed from: d, reason: collision with root package name */
    public final String f10102d;

    /* renamed from: e, reason: collision with root package name */
    public final int[] f10103e;

    /* renamed from: f, reason: collision with root package name */
    public final boolean f10104f;

    /* renamed from: g, reason: collision with root package name */
    public final String f10105g;

    /* renamed from: h, reason: collision with root package name */
    public final long f10106h;

    /* renamed from: i, reason: collision with root package name */
    public final String f10107i;

    public zzb(long j4, boolean z4, WorkSource workSource, String str, int[] iArr, boolean z5, String str2, long j5, String str3) {
        this.f10099a = j4;
        this.f10100b = z4;
        this.f10101c = workSource;
        this.f10102d = str;
        this.f10103e = iArr;
        this.f10104f = z5;
        this.f10105g = str2;
        this.f10106h = j5;
        this.f10107i = str3;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i4) {
        c.l(parcel);
        int iZ = J.Z(parcel, 20293);
        J.c0(parcel, 1, 8);
        parcel.writeLong(this.f10099a);
        J.c0(parcel, 2, 4);
        parcel.writeInt(this.f10100b ? 1 : 0);
        J.T(parcel, 3, this.f10101c, i4);
        J.U(parcel, 4, this.f10102d);
        J.S(parcel, 5, this.f10103e);
        J.c0(parcel, 6, 4);
        parcel.writeInt(this.f10104f ? 1 : 0);
        J.U(parcel, 7, this.f10105g);
        J.c0(parcel, 8, 8);
        parcel.writeLong(this.f10106h);
        J.U(parcel, 9, this.f10107i);
        J.b0(parcel, iZ);
    }
}
