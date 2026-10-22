package com.google.android.gms.signin.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.maps.model.c;
import java.util.ArrayList;
import java.util.List;
import t0.J;

@SafeParcelable.Class(creator = "RecordConsentByConsentResultResponseCreator")
/* loaded from: classes.dex */
public final class zag extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zag> CREATOR = new c(26);

    /* renamed from: a, reason: collision with root package name */
    public final List f10252a;

    /* renamed from: b, reason: collision with root package name */
    public final String f10253b;

    public zag(String str, ArrayList arrayList) {
        this.f10252a = arrayList;
        this.f10253b = str;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i4) {
        int iZ = J.Z(parcel, 20293);
        List<String> list = this.f10252a;
        if (list != null) {
            int iZ2 = J.Z(parcel, 1);
            parcel.writeStringList(list);
            J.b0(parcel, iZ2);
        }
        J.U(parcel, 2, this.f10253b);
        J.b0(parcel, iZ);
    }
}
