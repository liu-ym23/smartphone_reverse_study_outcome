package com.google.android.gms.common.moduleinstall.internal;

import a1.C0154a;
import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.NonNull;
import com.airbnb.lottie.h;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.stepos.statsrpk.c;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import t0.J;

@KeepForSdk
@SafeParcelable.Class(creator = "ApiFeatureRequestCreator")
/* loaded from: classes.dex */
public class ApiFeatureRequest extends AbstractSafeParcelable {

    @NonNull
    public static final Parcelable.Creator<ApiFeatureRequest> CREATOR = new C0154a(14);

    /* renamed from: a, reason: collision with root package name */
    public final List f9890a;

    /* renamed from: b, reason: collision with root package name */
    public final boolean f9891b;

    /* renamed from: c, reason: collision with root package name */
    public final String f9892c;

    /* renamed from: d, reason: collision with root package name */
    public final String f9893d;

    public ApiFeatureRequest(ArrayList arrayList, boolean z4, String str, String str2) {
        c.l(arrayList);
        this.f9890a = arrayList;
        this.f9891b = z4;
        this.f9892c = str;
        this.f9893d = str2;
    }

    public final boolean equals(Object obj) {
        if (obj == null || !(obj instanceof ApiFeatureRequest)) {
            return false;
        }
        ApiFeatureRequest apiFeatureRequest = (ApiFeatureRequest) obj;
        return this.f9891b == apiFeatureRequest.f9891b && h.m(this.f9890a, apiFeatureRequest.f9890a) && h.m(this.f9892c, apiFeatureRequest.f9892c) && h.m(this.f9893d, apiFeatureRequest.f9893d);
    }

    public final int hashCode() {
        return Arrays.hashCode(new Object[]{Boolean.valueOf(this.f9891b), this.f9890a, this.f9892c, this.f9893d});
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i4) {
        int iZ = J.Z(parcel, 20293);
        J.W(parcel, 1, this.f9890a);
        J.c0(parcel, 2, 4);
        parcel.writeInt(this.f9891b ? 1 : 0);
        J.U(parcel, 3, this.f9892c);
        J.U(parcel, 4, this.f9893d);
        J.b0(parcel, iZ);
    }
}
