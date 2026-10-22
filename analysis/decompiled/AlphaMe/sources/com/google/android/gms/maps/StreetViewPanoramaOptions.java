package com.google.android.gms.maps;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.NonNull;
import com.google.android.gms.common.internal.ReflectedParcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.StreetViewPanoramaCamera;
import com.google.android.gms.maps.model.StreetViewSource;

@SafeParcelable.Class(creator = "StreetViewPanoramaOptionsCreator")
@SafeParcelable.Reserved({1})
/* loaded from: classes.dex */
public final class StreetViewPanoramaOptions extends AbstractSafeParcelable implements ReflectedParcelable {

    @NonNull
    public static final Parcelable.Creator<StreetViewPanoramaOptions> CREATOR = new com.google.android.gms.maps.model.c(24);

    /* renamed from: a, reason: collision with root package name */
    public StreetViewPanoramaCamera f10127a;

    /* renamed from: b, reason: collision with root package name */
    public String f10128b;

    /* renamed from: c, reason: collision with root package name */
    public LatLng f10129c;

    /* renamed from: d, reason: collision with root package name */
    public Integer f10130d;

    /* renamed from: e, reason: collision with root package name */
    public Boolean f10131e;

    /* renamed from: f, reason: collision with root package name */
    public Boolean f10132f;

    /* renamed from: g, reason: collision with root package name */
    public Boolean f10133g;

    /* renamed from: h, reason: collision with root package name */
    public Boolean f10134h;

    /* renamed from: i, reason: collision with root package name */
    public Boolean f10135i;

    /* renamed from: j, reason: collision with root package name */
    public StreetViewSource f10136j;

    public final String toString() {
        B0.e eVar = new B0.e(this);
        eVar.a(this.f10128b, "PanoramaId");
        eVar.a(this.f10129c, "Position");
        eVar.a(this.f10130d, "Radius");
        eVar.a(this.f10136j, "Source");
        eVar.a(this.f10127a, "StreetViewPanoramaCamera");
        eVar.a(this.f10131e, "UserNavigationEnabled");
        eVar.a(this.f10132f, "ZoomGesturesEnabled");
        eVar.a(this.f10133g, "PanningGesturesEnabled");
        eVar.a(this.f10134h, "StreetNamesEnabled");
        eVar.a(this.f10135i, "UseViewLifecycleInFragment");
        return eVar.toString();
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i4) {
        int iZ = t0.J.Z(parcel, 20293);
        t0.J.T(parcel, 2, this.f10127a, i4);
        t0.J.U(parcel, 3, this.f10128b);
        t0.J.T(parcel, 4, this.f10129c, i4);
        Integer num = this.f10130d;
        if (num != null) {
            t0.J.c0(parcel, 5, 4);
            parcel.writeInt(num.intValue());
        }
        byte bR = com.stepos.statsrpk.c.R(this.f10131e);
        t0.J.c0(parcel, 6, 4);
        parcel.writeInt(bR);
        byte bR2 = com.stepos.statsrpk.c.R(this.f10132f);
        t0.J.c0(parcel, 7, 4);
        parcel.writeInt(bR2);
        byte bR3 = com.stepos.statsrpk.c.R(this.f10133g);
        t0.J.c0(parcel, 8, 4);
        parcel.writeInt(bR3);
        byte bR4 = com.stepos.statsrpk.c.R(this.f10134h);
        t0.J.c0(parcel, 9, 4);
        parcel.writeInt(bR4);
        byte bR5 = com.stepos.statsrpk.c.R(this.f10135i);
        t0.J.c0(parcel, 10, 4);
        parcel.writeInt(bR5);
        t0.J.T(parcel, 11, this.f10136j, i4);
        t0.J.b0(parcel, iZ);
    }
}
