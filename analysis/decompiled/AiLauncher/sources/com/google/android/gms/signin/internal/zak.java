package com.google.android.gms.signin.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.zav;
import p2.C5047a;

/* loaded from: classes2.dex */
public final class zak extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zak> CREATOR = new e();
    final int zaa;
    private final ConnectionResult zab;
    private final zav zac;

    public zak(int i10, ConnectionResult connectionResult, zav zavVar) {
        this.zaa = i10;
        this.zab = connectionResult;
        this.zac = zavVar;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i10) {
        int iA = C5047a.a(parcel);
        C5047a.p(parcel, 1, this.zaa);
        C5047a.w(parcel, 2, this.zab, i10, false);
        C5047a.w(parcel, 3, this.zac, i10, false);
        C5047a.b(parcel, iA);
    }

    public final ConnectionResult zaa() {
        return this.zab;
    }

    public final zav zab() {
        return this.zac;
    }
}
