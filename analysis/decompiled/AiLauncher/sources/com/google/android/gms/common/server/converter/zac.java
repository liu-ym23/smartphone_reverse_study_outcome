package com.google.android.gms.common.server.converter;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import p2.C5047a;

/* loaded from: classes2.dex */
public final class zac extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zac> CREATOR = new c();
    final int zaa;
    final String zab;
    final int zac;

    public zac(int i10, String str, int i11) {
        this.zaa = i10;
        this.zab = str;
        this.zac = i11;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i10) {
        int i11 = this.zaa;
        int iA = C5047a.a(parcel);
        C5047a.p(parcel, 1, i11);
        C5047a.x(parcel, 2, this.zab, false);
        C5047a.p(parcel, 3, this.zac);
        C5047a.b(parcel, iA);
    }

    public zac(String str, int i10) {
        this.zaa = 1;
        this.zab = str;
        this.zac = i10;
    }
}
