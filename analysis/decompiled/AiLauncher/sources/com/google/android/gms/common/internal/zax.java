package com.google.android.gms.common.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import p2.C5047a;

/* loaded from: classes2.dex */
public final class zax extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zax> CREATOR = new D();
    final int zaa;
    private final int zab;
    private final int zac;

    @Deprecated
    private final Scope[] zad;

    public zax(int i10, int i11, int i12, Scope[] scopeArr) {
        this.zaa = i10;
        this.zab = i11;
        this.zac = i12;
        this.zad = scopeArr;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i10) {
        int i11 = this.zaa;
        int iA = C5047a.a(parcel);
        C5047a.p(parcel, 1, i11);
        C5047a.p(parcel, 2, this.zab);
        C5047a.p(parcel, 3, this.zac);
        C5047a.A(parcel, 4, this.zad, i10, false);
        C5047a.b(parcel, iA);
    }
}
