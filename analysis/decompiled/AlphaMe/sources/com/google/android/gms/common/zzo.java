package com.google.android.gms.common;

import android.content.Context;
import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.ObjectWrapper;
import t0.J;

@SafeParcelable.Class(creator = "GoogleCertificatesLookupQueryCreator")
/* loaded from: classes.dex */
public final class zzo extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzo> CREATOR = new k(0);

    /* renamed from: a, reason: collision with root package name */
    public final String f9948a;

    /* renamed from: b, reason: collision with root package name */
    public final boolean f9949b;

    /* renamed from: c, reason: collision with root package name */
    public final boolean f9950c;

    /* renamed from: d, reason: collision with root package name */
    public final Context f9951d;

    /* renamed from: e, reason: collision with root package name */
    public final boolean f9952e;

    public zzo(String str, boolean z4, boolean z5, IBinder iBinder, boolean z6) {
        this.f9948a = str;
        this.f9949b = z4;
        this.f9950c = z5;
        this.f9951d = (Context) ObjectWrapper.unwrap(IObjectWrapper.Stub.asInterface(iBinder));
        this.f9952e = z6;
    }

    /* JADX WARN: Type inference failed for: r0v6, types: [android.os.IBinder, com.google.android.gms.dynamic.IObjectWrapper] */
    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i4) {
        int iZ = J.Z(parcel, 20293);
        J.U(parcel, 1, this.f9948a);
        J.c0(parcel, 2, 4);
        parcel.writeInt(this.f9949b ? 1 : 0);
        J.c0(parcel, 3, 4);
        parcel.writeInt(this.f9950c ? 1 : 0);
        J.R(parcel, 4, ObjectWrapper.wrap(this.f9951d));
        J.c0(parcel, 5, 4);
        parcel.writeInt(this.f9952e ? 1 : 0);
        J.b0(parcel, iZ);
    }
}
