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
@SafeParcelable.Class(creator = "MethodInvocationCreator")
/* loaded from: classes.dex */
public class MethodInvocation extends AbstractSafeParcelable {

    @NonNull
    public static final Parcelable.Creator<MethodInvocation> CREATOR = new C0154a(4);

    /* renamed from: a, reason: collision with root package name */
    public final int f9755a;

    /* renamed from: b, reason: collision with root package name */
    public final int f9756b;

    /* renamed from: c, reason: collision with root package name */
    public final int f9757c;

    /* renamed from: d, reason: collision with root package name */
    public final long f9758d;

    /* renamed from: e, reason: collision with root package name */
    public final long f9759e;

    /* renamed from: f, reason: collision with root package name */
    public final String f9760f;

    /* renamed from: g, reason: collision with root package name */
    public final String f9761g;

    /* renamed from: h, reason: collision with root package name */
    public final int f9762h;

    /* renamed from: i, reason: collision with root package name */
    public final int f9763i;

    public MethodInvocation(int i4, int i5, int i6, long j4, long j5, String str, String str2, int i7, int i8) {
        this.f9755a = i4;
        this.f9756b = i5;
        this.f9757c = i6;
        this.f9758d = j4;
        this.f9759e = j5;
        this.f9760f = str;
        this.f9761g = str2;
        this.f9762h = i7;
        this.f9763i = i8;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i4) {
        int iZ = J.Z(parcel, 20293);
        J.c0(parcel, 1, 4);
        parcel.writeInt(this.f9755a);
        J.c0(parcel, 2, 4);
        parcel.writeInt(this.f9756b);
        J.c0(parcel, 3, 4);
        parcel.writeInt(this.f9757c);
        J.c0(parcel, 4, 8);
        parcel.writeLong(this.f9758d);
        J.c0(parcel, 5, 8);
        parcel.writeLong(this.f9759e);
        J.U(parcel, 6, this.f9760f);
        J.U(parcel, 7, this.f9761g);
        J.c0(parcel, 8, 4);
        parcel.writeInt(this.f9762h);
        J.c0(parcel, 9, 4);
        parcel.writeInt(this.f9763i);
        J.b0(parcel, iZ);
    }
}
