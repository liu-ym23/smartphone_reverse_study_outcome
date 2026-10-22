package com.google.android.gms.common.data;

import android.os.Parcel;
import android.os.ParcelFileDescriptor;
import android.os.Parcelable;
import androidx.annotation.NonNull;
import b.C0354a;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.internal.ReflectedParcelable;
import com.google.android.gms.common.internal.ShowFirstParty;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.stepos.statsrpk.c;
import t0.J;

@ShowFirstParty
@KeepForSdk
@SafeParcelable.Class(creator = "BitmapTeleporterCreator")
/* loaded from: classes.dex */
public class BitmapTeleporter extends AbstractSafeParcelable implements ReflectedParcelable {

    @NonNull
    @KeepForSdk
    public static final Parcelable.Creator<BitmapTeleporter> CREATOR = new C0354a(29);

    /* renamed from: a, reason: collision with root package name */
    public final int f9704a;

    /* renamed from: b, reason: collision with root package name */
    public ParcelFileDescriptor f9705b;

    /* renamed from: c, reason: collision with root package name */
    public final int f9706c;

    public BitmapTeleporter(int i4, ParcelFileDescriptor parcelFileDescriptor, int i5) {
        this.f9704a = i4;
        this.f9705b = parcelFileDescriptor;
        this.f9706c = i5;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i4) {
        if (this.f9705b == null) {
            c.l(null);
            throw null;
        }
        int iZ = J.Z(parcel, 20293);
        J.c0(parcel, 1, 4);
        parcel.writeInt(this.f9704a);
        J.T(parcel, 2, this.f9705b, i4 | 1);
        J.c0(parcel, 3, 4);
        parcel.writeInt(this.f9706c);
        J.b0(parcel, iZ);
        this.f9705b = null;
    }
}
