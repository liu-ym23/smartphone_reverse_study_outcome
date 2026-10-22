package com.google.android.gms.signin.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.zat;
import p2.C5047a;

/* loaded from: classes2.dex */
public final class zai extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zai> CREATOR = new d();
    final int zaa;
    final zat zab;

    public zai(int i10, zat zatVar) {
        this.zaa = i10;
        this.zab = zatVar;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i10) {
        int iA = C5047a.a(parcel);
        C5047a.p(parcel, 1, this.zaa);
        C5047a.w(parcel, 2, this.zab, i10, false);
        C5047a.b(parcel, iA);
    }
}
