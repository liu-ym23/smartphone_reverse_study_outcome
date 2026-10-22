package com.google.android.gms.maps;

import android.graphics.Color;
import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.NonNull;
import com.google.android.gms.common.internal.ReflectedParcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.maps.model.CameraPosition;
import com.google.android.gms.maps.model.LatLngBounds;

@SafeParcelable.Class(creator = "GoogleMapOptionsCreator")
@SafeParcelable.Reserved({1})
/* loaded from: classes.dex */
public final class GoogleMapOptions extends AbstractSafeParcelable implements ReflectedParcelable {

    @NonNull
    public static final Parcelable.Creator<GoogleMapOptions> CREATOR = new com.google.android.gms.maps.model.c(23);

    /* renamed from: a, reason: collision with root package name */
    public Boolean f10108a;

    /* renamed from: b, reason: collision with root package name */
    public Boolean f10109b;

    /* renamed from: c, reason: collision with root package name */
    public int f10110c;

    /* renamed from: d, reason: collision with root package name */
    public CameraPosition f10111d;

    /* renamed from: e, reason: collision with root package name */
    public Boolean f10112e;

    /* renamed from: f, reason: collision with root package name */
    public Boolean f10113f;

    /* renamed from: g, reason: collision with root package name */
    public Boolean f10114g;

    /* renamed from: h, reason: collision with root package name */
    public Boolean f10115h;

    /* renamed from: i, reason: collision with root package name */
    public Boolean f10116i;

    /* renamed from: j, reason: collision with root package name */
    public Boolean f10117j;

    /* renamed from: k, reason: collision with root package name */
    public Boolean f10118k;

    /* renamed from: l, reason: collision with root package name */
    public Boolean f10119l;

    /* renamed from: m, reason: collision with root package name */
    public Boolean f10120m;

    /* renamed from: n, reason: collision with root package name */
    public Float f10121n;

    /* renamed from: o, reason: collision with root package name */
    public Float f10122o;

    /* renamed from: p, reason: collision with root package name */
    public LatLngBounds f10123p;

    /* renamed from: q, reason: collision with root package name */
    public Boolean f10124q;

    /* renamed from: r, reason: collision with root package name */
    public Integer f10125r;

    /* renamed from: s, reason: collision with root package name */
    public String f10126s;

    static {
        Color.argb(255, 236, 233, 225);
    }

    public final String toString() {
        B0.e eVar = new B0.e(this);
        eVar.a(Integer.valueOf(this.f10110c), "MapType");
        eVar.a(this.f10118k, "LiteMode");
        eVar.a(this.f10111d, "Camera");
        eVar.a(this.f10113f, "CompassEnabled");
        eVar.a(this.f10112e, "ZoomControlsEnabled");
        eVar.a(this.f10114g, "ScrollGesturesEnabled");
        eVar.a(this.f10115h, "ZoomGesturesEnabled");
        eVar.a(this.f10116i, "TiltGesturesEnabled");
        eVar.a(this.f10117j, "RotateGesturesEnabled");
        eVar.a(this.f10124q, "ScrollGesturesEnabledDuringRotateOrZoom");
        eVar.a(this.f10119l, "MapToolbarEnabled");
        eVar.a(this.f10120m, "AmbientEnabled");
        eVar.a(this.f10121n, "MinZoomPreference");
        eVar.a(this.f10122o, "MaxZoomPreference");
        eVar.a(this.f10125r, "BackgroundColor");
        eVar.a(this.f10123p, "LatLngBoundsForCameraTarget");
        eVar.a(this.f10108a, "ZOrderOnTop");
        eVar.a(this.f10109b, "UseViewLifecycleInFragment");
        return eVar.toString();
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i4) {
        int iZ = t0.J.Z(parcel, 20293);
        byte bR = com.stepos.statsrpk.c.R(this.f10108a);
        t0.J.c0(parcel, 2, 4);
        parcel.writeInt(bR);
        byte bR2 = com.stepos.statsrpk.c.R(this.f10109b);
        t0.J.c0(parcel, 3, 4);
        parcel.writeInt(bR2);
        t0.J.c0(parcel, 4, 4);
        parcel.writeInt(this.f10110c);
        t0.J.T(parcel, 5, this.f10111d, i4);
        byte bR3 = com.stepos.statsrpk.c.R(this.f10112e);
        t0.J.c0(parcel, 6, 4);
        parcel.writeInt(bR3);
        byte bR4 = com.stepos.statsrpk.c.R(this.f10113f);
        t0.J.c0(parcel, 7, 4);
        parcel.writeInt(bR4);
        byte bR5 = com.stepos.statsrpk.c.R(this.f10114g);
        t0.J.c0(parcel, 8, 4);
        parcel.writeInt(bR5);
        byte bR6 = com.stepos.statsrpk.c.R(this.f10115h);
        t0.J.c0(parcel, 9, 4);
        parcel.writeInt(bR6);
        byte bR7 = com.stepos.statsrpk.c.R(this.f10116i);
        t0.J.c0(parcel, 10, 4);
        parcel.writeInt(bR7);
        byte bR8 = com.stepos.statsrpk.c.R(this.f10117j);
        t0.J.c0(parcel, 11, 4);
        parcel.writeInt(bR8);
        byte bR9 = com.stepos.statsrpk.c.R(this.f10118k);
        t0.J.c0(parcel, 12, 4);
        parcel.writeInt(bR9);
        byte bR10 = com.stepos.statsrpk.c.R(this.f10119l);
        t0.J.c0(parcel, 14, 4);
        parcel.writeInt(bR10);
        byte bR11 = com.stepos.statsrpk.c.R(this.f10120m);
        t0.J.c0(parcel, 15, 4);
        parcel.writeInt(bR11);
        t0.J.Q(parcel, 16, this.f10121n);
        t0.J.Q(parcel, 17, this.f10122o);
        t0.J.T(parcel, 18, this.f10123p, i4);
        byte bR12 = com.stepos.statsrpk.c.R(this.f10124q);
        t0.J.c0(parcel, 19, 4);
        parcel.writeInt(bR12);
        Integer num = this.f10125r;
        if (num != null) {
            t0.J.c0(parcel, 20, 4);
            parcel.writeInt(num.intValue());
        }
        t0.J.U(parcel, 21, this.f10126s);
        t0.J.b0(parcel, iZ);
    }
}
