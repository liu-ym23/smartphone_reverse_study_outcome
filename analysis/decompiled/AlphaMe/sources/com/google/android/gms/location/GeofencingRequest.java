package com.google.android.gms.location;

import B0.g;
import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.NonNull;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.k;
import java.util.ArrayList;
import java.util.List;
import t0.J;

@SafeParcelable.Class(creator = "GeofencingRequestCreator")
@SafeParcelable.Reserved({1000})
/* loaded from: classes.dex */
public class GeofencingRequest extends AbstractSafeParcelable {

    @NonNull
    public static final Parcelable.Creator<GeofencingRequest> CREATOR = new k(24);

    /* renamed from: a, reason: collision with root package name */
    public final List f10033a;

    /* renamed from: b, reason: collision with root package name */
    public final int f10034b;

    /* renamed from: c, reason: collision with root package name */
    public final String f10035c;

    /* renamed from: d, reason: collision with root package name */
    public final String f10036d;

    public @interface InitialTrigger {
    }

    public GeofencingRequest(ArrayList arrayList, int i4, String str, String str2) {
        this.f10033a = arrayList;
        this.f10034b = i4;
        this.f10035c = str;
        this.f10036d = str2;
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder("GeofencingRequest[geofences=");
        sb.append(this.f10033a);
        sb.append(", initialTrigger=");
        sb.append(this.f10034b);
        sb.append(", tag=");
        sb.append(this.f10035c);
        sb.append(", attributionTag=");
        return g.r(sb, this.f10036d, "]");
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i4) {
        int iZ = J.Z(parcel, 20293);
        J.W(parcel, 1, this.f10033a);
        J.c0(parcel, 2, 4);
        parcel.writeInt(this.f10034b);
        J.U(parcel, 3, this.f10035c);
        J.U(parcel, 4, this.f10036d);
        J.b0(parcel, iZ);
    }
}
