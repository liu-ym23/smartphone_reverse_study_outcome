package com.google.android.gms.signin.internal;

import android.content.Intent;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.h;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import p2.C5047a;

/* loaded from: classes2.dex */
public final class zaa extends AbstractSafeParcelable implements h {
    public static final Parcelable.Creator<zaa> CREATOR = new b();
    final int zaa;
    private int zab;
    private Intent zac;

    public zaa() {
        this(2, 0, null);
    }

    @Override // com.google.android.gms.common.api.h
    public final Status getStatus() {
        return this.zab == 0 ? Status.RESULT_SUCCESS : Status.RESULT_CANCELED;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i10) {
        int i11 = this.zaa;
        int iA = C5047a.a(parcel);
        C5047a.p(parcel, 1, i11);
        C5047a.p(parcel, 2, this.zab);
        C5047a.w(parcel, 3, this.zac, i10, false);
        C5047a.b(parcel, iA);
    }

    public zaa(int i10, int i11, Intent intent) {
        this.zaa = i10;
        this.zab = i11;
        this.zac = intent;
    }
}
