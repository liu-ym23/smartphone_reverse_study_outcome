package com.google.android.gms.common.server.response;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.server.response.FastJsonResponse;
import p2.C5047a;

/* loaded from: classes2.dex */
public final class zam extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zam> CREATOR = new b();
    final int zaa;
    final String zab;
    final FastJsonResponse.Field zac;

    public zam(int i10, String str, FastJsonResponse.Field field) {
        this.zaa = i10;
        this.zab = str;
        this.zac = field;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i10) {
        int i11 = this.zaa;
        int iA = C5047a.a(parcel);
        C5047a.p(parcel, 1, i11);
        C5047a.x(parcel, 2, this.zab, false);
        C5047a.w(parcel, 3, this.zac, i10, false);
        C5047a.b(parcel, iA);
    }

    public zam(String str, FastJsonResponse.Field field) {
        this.zaa = 1;
        this.zab = str;
        this.zac = field;
    }
}
