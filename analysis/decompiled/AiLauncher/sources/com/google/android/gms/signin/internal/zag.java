package com.google.android.gms.signin.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.h;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import java.util.List;
import p2.C5047a;

/* loaded from: classes2.dex */
public final class zag extends AbstractSafeParcelable implements h {
    public static final Parcelable.Creator<zag> CREATOR = new c();
    private final List zaa;
    private final String zab;

    public zag(List list, String str) {
        this.zaa = list;
        this.zab = str;
    }

    @Override // com.google.android.gms.common.api.h
    public final Status getStatus() {
        return this.zab != null ? Status.RESULT_SUCCESS : Status.RESULT_CANCELED;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i10) {
        List list = this.zaa;
        int iA = C5047a.a(parcel);
        C5047a.z(parcel, 1, list, false);
        C5047a.x(parcel, 2, this.zab, false);
        C5047a.b(parcel, iA);
    }
}
