package com.google.android.gms.maps.model;

import B0.f;
import android.content.Intent;
import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.internal.zat;
import com.google.android.gms.common.internal.zav;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.internal.maps.zzal;
import com.google.android.gms.maps.GoogleMapOptions;
import com.google.android.gms.maps.StreetViewPanoramaOptions;
import com.google.android.gms.signin.internal.zaa;
import com.google.android.gms.signin.internal.zag;
import com.google.android.gms.signin.internal.zai;
import com.google.android.gms.signin.internal.zak;
import com.google.android.material.badge.BadgeState$State;
import com.stepos.alphame.utils.Property;
import java.util.ArrayList;
import java.util.Locale;

/* loaded from: classes.dex */
public final class c implements Parcelable.Creator {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f10248a;

    public /* synthetic */ c(int i4) {
        this.f10248a = i4;
    }

    @Override // android.os.Parcelable.Creator
    public final Object createFromParcel(Parcel parcel) {
        double dK0 = 0.0d;
        switch (this.f10248a) {
            case 0:
                float fL0 = Property.DEFAULT_FLOAT_VALUE;
                int iD0 = f.D0(parcel);
                float fL02 = 0.0f;
                LatLng latLng = null;
                float fL03 = 0.0f;
                while (parcel.dataPosition() < iD0) {
                    int i4 = parcel.readInt();
                    char c4 = (char) i4;
                    if (c4 == 2) {
                        latLng = (LatLng) f.p(parcel, i4, LatLng.CREATOR);
                    } else if (c4 == 3) {
                        fL03 = f.l0(parcel, i4);
                    } else if (c4 == 4) {
                        fL0 = f.l0(parcel, i4);
                    } else if (c4 != 5) {
                        f.z0(parcel, i4);
                    } else {
                        fL02 = f.l0(parcel, i4);
                    }
                }
                f.t(parcel, iD0);
                return new CameraPosition(latLng, fL03, fL0, fL02);
            case 1:
                int iD02 = f.D0(parcel);
                boolean zI0 = false;
                IBinder iBinderN0 = null;
                float fL04 = Property.DEFAULT_FLOAT_VALUE;
                boolean zI02 = true;
                float fL05 = Property.DEFAULT_FLOAT_VALUE;
                while (parcel.dataPosition() < iD02) {
                    int i5 = parcel.readInt();
                    char c5 = (char) i5;
                    if (c5 == 2) {
                        iBinderN0 = f.n0(parcel, i5);
                    } else if (c5 == 3) {
                        zI0 = f.i0(parcel, i5);
                    } else if (c5 == 4) {
                        fL04 = f.l0(parcel, i5);
                    } else if (c5 == 5) {
                        zI02 = f.i0(parcel, i5);
                    } else if (c5 != 6) {
                        f.z0(parcel, i5);
                    } else {
                        fL05 = f.l0(parcel, i5);
                    }
                }
                f.t(parcel, iD02);
                TileOverlayOptions tileOverlayOptions = new TileOverlayOptions();
                tileOverlayOptions.f10238b = true;
                tileOverlayOptions.f10240d = true;
                tileOverlayOptions.f10241e = Property.DEFAULT_FLOAT_VALUE;
                tileOverlayOptions.f10237a = zzal.zzc(iBinderN0);
                tileOverlayOptions.f10238b = zI0;
                tileOverlayOptions.f10239c = fL04;
                tileOverlayOptions.f10240d = zI02;
                tileOverlayOptions.f10241e = fL05;
                return tileOverlayOptions;
            case 2:
                int iD03 = f.D0(parcel);
                LatLng latLng2 = null;
                LatLng latLng3 = null;
                LatLng latLng4 = null;
                LatLng latLng5 = null;
                LatLngBounds latLngBounds = null;
                while (parcel.dataPosition() < iD03) {
                    int i6 = parcel.readInt();
                    char c6 = (char) i6;
                    if (c6 == 2) {
                        latLng2 = (LatLng) f.p(parcel, i6, LatLng.CREATOR);
                    } else if (c6 == 3) {
                        latLng3 = (LatLng) f.p(parcel, i6, LatLng.CREATOR);
                    } else if (c6 == 4) {
                        latLng4 = (LatLng) f.p(parcel, i6, LatLng.CREATOR);
                    } else if (c6 == 5) {
                        latLng5 = (LatLng) f.p(parcel, i6, LatLng.CREATOR);
                    } else if (c6 != 6) {
                        f.z0(parcel, i6);
                    } else {
                        latLngBounds = (LatLngBounds) f.p(parcel, i6, LatLngBounds.CREATOR);
                    }
                }
                f.t(parcel, iD03);
                return new VisibleRegion(latLng2, latLng3, latLng4, latLng5, latLngBounds);
            case 3:
                int iD04 = f.D0(parcel);
                int iO0 = 0;
                IBinder iBinderN02 = null;
                Float fM0 = null;
                while (parcel.dataPosition() < iD04) {
                    int i7 = parcel.readInt();
                    char c7 = (char) i7;
                    if (c7 == 2) {
                        iO0 = f.o0(parcel, i7);
                    } else if (c7 == 3) {
                        iBinderN02 = f.n0(parcel, i7);
                    } else if (c7 != 4) {
                        f.z0(parcel, i7);
                    } else {
                        fM0 = f.m0(parcel, i7);
                    }
                }
                f.t(parcel, iD04);
                return new Cap(iO0, iBinderN02 == null ? null : new a(IObjectWrapper.Stub.asInterface(iBinderN02)), fM0);
            case 4:
                int iD05 = f.D0(parcel);
                int iO02 = 0;
                boolean zI03 = false;
                boolean zI04 = false;
                int iO03 = 0;
                ArrayList arrayListS = null;
                LatLng latLng6 = null;
                float fL06 = Property.DEFAULT_FLOAT_VALUE;
                float fL07 = Property.DEFAULT_FLOAT_VALUE;
                while (parcel.dataPosition() < iD05) {
                    int i8 = parcel.readInt();
                    switch ((char) i8) {
                        case 2:
                            latLng6 = (LatLng) f.p(parcel, i8, LatLng.CREATOR);
                            break;
                        case 3:
                            dK0 = f.k0(parcel, i8);
                            break;
                        case 4:
                            fL07 = f.l0(parcel, i8);
                            break;
                        case 5:
                            iO03 = f.o0(parcel, i8);
                            break;
                        case 6:
                            iO02 = f.o0(parcel, i8);
                            break;
                        case 7:
                            fL06 = f.l0(parcel, i8);
                            break;
                        case '\b':
                            zI03 = f.i0(parcel, i8);
                            break;
                        case '\t':
                            zI04 = f.i0(parcel, i8);
                            break;
                        case '\n':
                            arrayListS = f.s(parcel, i8, PatternItem.CREATOR);
                            break;
                        default:
                            f.z0(parcel, i8);
                            break;
                    }
                }
                f.t(parcel, iD05);
                CircleOptions circleOptions = new CircleOptions();
                circleOptions.f10144a = latLng6;
                circleOptions.f10145b = dK0;
                circleOptions.f10146c = fL07;
                circleOptions.f10147d = iO03;
                circleOptions.f10148e = iO02;
                circleOptions.f10149f = fL06;
                circleOptions.f10150g = zI03;
                circleOptions.f10151h = zI04;
                circleOptions.f10152i = arrayListS;
                return circleOptions;
            case 5:
                LatLng latLng7 = null;
                int iD06 = f.D0(parcel);
                LatLngBounds latLngBounds2 = null;
                IBinder iBinderN03 = null;
                boolean zI05 = false;
                boolean zI06 = false;
                float fL08 = Property.DEFAULT_FLOAT_VALUE;
                float fL09 = Property.DEFAULT_FLOAT_VALUE;
                float fL010 = Property.DEFAULT_FLOAT_VALUE;
                float fL011 = Property.DEFAULT_FLOAT_VALUE;
                float fL012 = Property.DEFAULT_FLOAT_VALUE;
                float fL013 = Property.DEFAULT_FLOAT_VALUE;
                float fL014 = Property.DEFAULT_FLOAT_VALUE;
                while (parcel.dataPosition() < iD06) {
                    int i9 = parcel.readInt();
                    switch ((char) i9) {
                        case 2:
                            iBinderN03 = f.n0(parcel, i9);
                            break;
                        case 3:
                            latLng7 = (LatLng) f.p(parcel, i9, LatLng.CREATOR);
                            break;
                        case 4:
                            fL08 = f.l0(parcel, i9);
                            break;
                        case 5:
                            fL09 = f.l0(parcel, i9);
                            break;
                        case 6:
                            latLngBounds2 = (LatLngBounds) f.p(parcel, i9, LatLngBounds.CREATOR);
                            break;
                        case 7:
                            fL010 = f.l0(parcel, i9);
                            break;
                        case '\b':
                            fL011 = f.l0(parcel, i9);
                            break;
                        case '\t':
                            zI05 = f.i0(parcel, i9);
                            break;
                        case '\n':
                            fL012 = f.l0(parcel, i9);
                            break;
                        case 11:
                            fL013 = f.l0(parcel, i9);
                            break;
                        case '\f':
                            fL014 = f.l0(parcel, i9);
                            break;
                        case '\r':
                            zI06 = f.i0(parcel, i9);
                            break;
                        default:
                            f.z0(parcel, i9);
                            break;
                    }
                }
                f.t(parcel, iD06);
                GroundOverlayOptions groundOverlayOptions = new GroundOverlayOptions();
                groundOverlayOptions.f10162h = true;
                groundOverlayOptions.f10163i = Property.DEFAULT_FLOAT_VALUE;
                groundOverlayOptions.f10164j = 0.5f;
                groundOverlayOptions.f10165k = 0.5f;
                groundOverlayOptions.f10166l = false;
                groundOverlayOptions.f10155a = new a(IObjectWrapper.Stub.asInterface(iBinderN03));
                groundOverlayOptions.f10156b = latLng7;
                groundOverlayOptions.f10157c = fL08;
                groundOverlayOptions.f10158d = fL09;
                groundOverlayOptions.f10159e = latLngBounds2;
                groundOverlayOptions.f10160f = fL010;
                groundOverlayOptions.f10161g = fL011;
                groundOverlayOptions.f10162h = zI05;
                groundOverlayOptions.f10163i = fL012;
                groundOverlayOptions.f10164j = fL013;
                groundOverlayOptions.f10165k = fL014;
                groundOverlayOptions.f10166l = zI06;
                return groundOverlayOptions;
            case 6:
                LatLng latLng8 = null;
                int iD07 = f.D0(parcel);
                LatLng latLng9 = null;
                while (parcel.dataPosition() < iD07) {
                    int i10 = parcel.readInt();
                    char c8 = (char) i10;
                    if (c8 == 2) {
                        latLng9 = (LatLng) f.p(parcel, i10, LatLng.CREATOR);
                    } else if (c8 != 3) {
                        f.z0(parcel, i10);
                    } else {
                        latLng8 = (LatLng) f.p(parcel, i10, LatLng.CREATOR);
                    }
                }
                f.t(parcel, iD07);
                return new LatLngBounds(latLng9, latLng8);
            case 7:
                int iD08 = f.D0(parcel);
                double dK02 = 0.0d;
                while (parcel.dataPosition() < iD08) {
                    int i11 = parcel.readInt();
                    char c9 = (char) i11;
                    if (c9 == 2) {
                        dK0 = f.k0(parcel, i11);
                    } else if (c9 != 3) {
                        f.z0(parcel, i11);
                    } else {
                        dK02 = f.k0(parcel, i11);
                    }
                }
                f.t(parcel, iD08);
                return new LatLng(dK0, dK02);
            case 8:
                int iD09 = f.D0(parcel);
                String strQ = null;
                while (parcel.dataPosition() < iD09) {
                    int i12 = parcel.readInt();
                    if (((char) i12) != 2) {
                        f.z0(parcel, i12);
                    } else {
                        strQ = f.q(parcel, i12);
                    }
                }
                f.t(parcel, iD09);
                MapStyleOptions mapStyleOptions = new MapStyleOptions();
                com.stepos.statsrpk.c.m(strQ, "json must not be null");
                mapStyleOptions.f10171a = strQ;
                return mapStyleOptions;
            case 9:
                int iD010 = f.D0(parcel);
                float fL015 = 0.5f;
                float fL016 = 1.0f;
                LatLng latLng10 = null;
                String strQ2 = null;
                String strQ3 = null;
                IBinder iBinderN04 = null;
                float fL017 = Property.DEFAULT_FLOAT_VALUE;
                float fL018 = Property.DEFAULT_FLOAT_VALUE;
                boolean zI07 = false;
                boolean zI08 = false;
                boolean zI09 = false;
                float fL019 = Property.DEFAULT_FLOAT_VALUE;
                float fL020 = Property.DEFAULT_FLOAT_VALUE;
                float fL021 = Property.DEFAULT_FLOAT_VALUE;
                while (parcel.dataPosition() < iD010) {
                    int i13 = parcel.readInt();
                    switch ((char) i13) {
                        case 2:
                            latLng10 = (LatLng) f.p(parcel, i13, LatLng.CREATOR);
                            break;
                        case 3:
                            strQ2 = f.q(parcel, i13);
                            break;
                        case 4:
                            strQ3 = f.q(parcel, i13);
                            break;
                        case 5:
                            iBinderN04 = f.n0(parcel, i13);
                            break;
                        case 6:
                            fL017 = f.l0(parcel, i13);
                            break;
                        case 7:
                            fL018 = f.l0(parcel, i13);
                            break;
                        case '\b':
                            zI07 = f.i0(parcel, i13);
                            break;
                        case '\t':
                            zI08 = f.i0(parcel, i13);
                            break;
                        case '\n':
                            zI09 = f.i0(parcel, i13);
                            break;
                        case 11:
                            fL019 = f.l0(parcel, i13);
                            break;
                        case '\f':
                            fL015 = f.l0(parcel, i13);
                            break;
                        case '\r':
                            fL020 = f.l0(parcel, i13);
                            break;
                        case 14:
                            fL016 = f.l0(parcel, i13);
                            break;
                        case 15:
                            fL021 = f.l0(parcel, i13);
                            break;
                        default:
                            f.z0(parcel, i13);
                            break;
                    }
                }
                f.t(parcel, iD010);
                MarkerOptions markerOptions = new MarkerOptions();
                markerOptions.f10176e = 0.5f;
                markerOptions.f10177f = 1.0f;
                markerOptions.f10179h = true;
                markerOptions.f10180i = false;
                markerOptions.f10181j = Property.DEFAULT_FLOAT_VALUE;
                markerOptions.f10182k = 0.5f;
                markerOptions.f10183l = Property.DEFAULT_FLOAT_VALUE;
                markerOptions.f10184m = 1.0f;
                markerOptions.f10172a = latLng10;
                markerOptions.f10173b = strQ2;
                markerOptions.f10174c = strQ3;
                if (iBinderN04 == null) {
                    markerOptions.f10175d = null;
                } else {
                    markerOptions.f10175d = new a(IObjectWrapper.Stub.asInterface(iBinderN04));
                }
                markerOptions.f10176e = fL017;
                markerOptions.f10177f = fL018;
                markerOptions.f10178g = zI07;
                markerOptions.f10179h = zI08;
                markerOptions.f10180i = zI09;
                markerOptions.f10181j = fL019;
                markerOptions.f10182k = fL015;
                markerOptions.f10183l = fL020;
                markerOptions.f10184m = fL016;
                markerOptions.f10185n = fL021;
                return markerOptions;
            case 10:
                int iD011 = f.D0(parcel);
                int iO04 = 0;
                Float fM02 = null;
                while (parcel.dataPosition() < iD011) {
                    int i14 = parcel.readInt();
                    char c10 = (char) i14;
                    if (c10 == 2) {
                        iO04 = f.o0(parcel, i14);
                    } else if (c10 != 3) {
                        f.z0(parcel, i14);
                    } else {
                        fM02 = f.m0(parcel, i14);
                    }
                }
                f.t(parcel, iD011);
                return new PatternItem(iO04, fM02);
            case 11:
                int iD012 = f.D0(parcel);
                String strQ4 = null;
                String strQ5 = null;
                LatLng latLng11 = null;
                while (parcel.dataPosition() < iD012) {
                    int i15 = parcel.readInt();
                    char c11 = (char) i15;
                    if (c11 == 2) {
                        latLng11 = (LatLng) f.p(parcel, i15, LatLng.CREATOR);
                    } else if (c11 == 3) {
                        strQ4 = f.q(parcel, i15);
                    } else if (c11 != 4) {
                        f.z0(parcel, i15);
                    } else {
                        strQ5 = f.q(parcel, i15);
                    }
                }
                f.t(parcel, iD012);
                return new PointOfInterest(latLng11, strQ4, strQ5);
            case 12:
                int iD013 = f.D0(parcel);
                ArrayList arrayList = new ArrayList();
                ArrayList arrayListS2 = null;
                float fL022 = Property.DEFAULT_FLOAT_VALUE;
                int iO05 = 0;
                int iO06 = 0;
                float fL023 = Property.DEFAULT_FLOAT_VALUE;
                boolean zI010 = false;
                boolean zI011 = false;
                boolean zI012 = false;
                int iO07 = 0;
                ArrayList arrayListS3 = null;
                while (parcel.dataPosition() < iD013) {
                    int i16 = parcel.readInt();
                    switch ((char) i16) {
                        case 2:
                            arrayListS2 = f.s(parcel, i16, LatLng.CREATOR);
                            break;
                        case 3:
                            ClassLoader classLoader = c.class.getClassLoader();
                            int iQ0 = f.q0(parcel, i16);
                            int iDataPosition = parcel.dataPosition();
                            if (iQ0 != 0) {
                                parcel.readList(arrayList, classLoader);
                                parcel.setDataPosition(iDataPosition + iQ0);
                                break;
                            } else {
                                break;
                            }
                        case 4:
                            fL022 = f.l0(parcel, i16);
                            break;
                        case 5:
                            iO05 = f.o0(parcel, i16);
                            break;
                        case 6:
                            iO06 = f.o0(parcel, i16);
                            break;
                        case 7:
                            fL023 = f.l0(parcel, i16);
                            break;
                        case '\b':
                            zI010 = f.i0(parcel, i16);
                            break;
                        case '\t':
                            zI011 = f.i0(parcel, i16);
                            break;
                        case '\n':
                            zI012 = f.i0(parcel, i16);
                            break;
                        case 11:
                            iO07 = f.o0(parcel, i16);
                            break;
                        case '\f':
                            arrayListS3 = f.s(parcel, i16, PatternItem.CREATOR);
                            break;
                        default:
                            f.z0(parcel, i16);
                            break;
                    }
                }
                f.t(parcel, iD013);
                return new PolygonOptions(arrayListS2, arrayList, fL022, iO05, iO06, fL023, zI010, zI011, zI012, iO07, arrayListS3);
            case 13:
                int iD014 = f.D0(parcel);
                ArrayList arrayListS4 = null;
                float fL024 = Property.DEFAULT_FLOAT_VALUE;
                int iO08 = 0;
                float fL025 = Property.DEFAULT_FLOAT_VALUE;
                boolean zI013 = false;
                boolean zI014 = false;
                boolean zI015 = false;
                Cap cap = null;
                Cap cap2 = null;
                int iO09 = 0;
                ArrayList arrayListS5 = null;
                ArrayList arrayListS6 = null;
                while (parcel.dataPosition() < iD014) {
                    int i17 = parcel.readInt();
                    switch ((char) i17) {
                        case 2:
                            arrayListS4 = f.s(parcel, i17, LatLng.CREATOR);
                            break;
                        case 3:
                            fL024 = f.l0(parcel, i17);
                            break;
                        case 4:
                            iO08 = f.o0(parcel, i17);
                            break;
                        case 5:
                            fL025 = f.l0(parcel, i17);
                            break;
                        case 6:
                            zI013 = f.i0(parcel, i17);
                            break;
                        case 7:
                            zI014 = f.i0(parcel, i17);
                            break;
                        case '\b':
                            zI015 = f.i0(parcel, i17);
                            break;
                        case '\t':
                            cap = (Cap) f.p(parcel, i17, Cap.CREATOR);
                            break;
                        case '\n':
                            cap2 = (Cap) f.p(parcel, i17, Cap.CREATOR);
                            break;
                        case 11:
                            iO09 = f.o0(parcel, i17);
                            break;
                        case '\f':
                            arrayListS5 = f.s(parcel, i17, PatternItem.CREATOR);
                            break;
                        case '\r':
                            arrayListS6 = f.s(parcel, i17, StyleSpan.CREATOR);
                            break;
                        default:
                            f.z0(parcel, i17);
                            break;
                    }
                }
                f.t(parcel, iD014);
                return new PolylineOptions(arrayListS4, fL024, iO08, fL025, zI013, zI014, zI015, cap, cap2, iO09, arrayListS5, arrayListS6);
            case 14:
                int iD015 = f.D0(parcel);
                IBinder iBinderN05 = null;
                while (parcel.dataPosition() < iD015) {
                    int i18 = parcel.readInt();
                    if (((char) i18) != 2) {
                        f.z0(parcel, i18);
                    } else {
                        iBinderN05 = f.n0(parcel, i18);
                    }
                }
                f.t(parcel, iD015);
                return new StampStyle(iBinderN05);
            case 15:
                int iD016 = f.D0(parcel);
                float fL026 = Property.DEFAULT_FLOAT_VALUE;
                float fL027 = Property.DEFAULT_FLOAT_VALUE;
                float fL028 = Property.DEFAULT_FLOAT_VALUE;
                while (parcel.dataPosition() < iD016) {
                    int i19 = parcel.readInt();
                    char c12 = (char) i19;
                    if (c12 == 2) {
                        fL028 = f.l0(parcel, i19);
                    } else if (c12 == 3) {
                        fL026 = f.l0(parcel, i19);
                    } else if (c12 != 4) {
                        f.z0(parcel, i19);
                    } else {
                        fL027 = f.l0(parcel, i19);
                    }
                }
                f.t(parcel, iD016);
                return new StreetViewPanoramaCamera(fL028, fL026, fL027);
            case 16:
                int iD017 = f.D0(parcel);
                float fL029 = Property.DEFAULT_FLOAT_VALUE;
                String strQ6 = null;
                while (parcel.dataPosition() < iD017) {
                    int i20 = parcel.readInt();
                    char c13 = (char) i20;
                    if (c13 == 2) {
                        strQ6 = f.q(parcel, i20);
                    } else if (c13 != 3) {
                        f.z0(parcel, i20);
                    } else {
                        fL029 = f.l0(parcel, i20);
                    }
                }
                f.t(parcel, iD017);
                return new StreetViewPanoramaLink(strQ6, fL029);
            case 17:
                int iD018 = f.D0(parcel);
                LatLng latLng12 = null;
                String strQ7 = null;
                StreetViewPanoramaLink[] streetViewPanoramaLinkArr = null;
                while (parcel.dataPosition() < iD018) {
                    int i21 = parcel.readInt();
                    char c14 = (char) i21;
                    if (c14 == 2) {
                        streetViewPanoramaLinkArr = (StreetViewPanoramaLink[]) f.r(parcel, i21, StreetViewPanoramaLink.CREATOR);
                    } else if (c14 == 3) {
                        latLng12 = (LatLng) f.p(parcel, i21, LatLng.CREATOR);
                    } else if (c14 != 4) {
                        f.z0(parcel, i21);
                    } else {
                        strQ7 = f.q(parcel, i21);
                    }
                }
                f.t(parcel, iD018);
                return new StreetViewPanoramaLocation(streetViewPanoramaLinkArr, latLng12, strQ7);
            case 18:
                int iD019 = f.D0(parcel);
                float fL030 = Property.DEFAULT_FLOAT_VALUE;
                float fL031 = Property.DEFAULT_FLOAT_VALUE;
                while (parcel.dataPosition() < iD019) {
                    int i22 = parcel.readInt();
                    char c15 = (char) i22;
                    if (c15 == 2) {
                        fL031 = f.l0(parcel, i22);
                    } else if (c15 != 3) {
                        f.z0(parcel, i22);
                    } else {
                        fL030 = f.l0(parcel, i22);
                    }
                }
                f.t(parcel, iD019);
                return new StreetViewPanoramaOrientation(fL031, fL030);
            case 19:
                int iD020 = f.D0(parcel);
                int iO010 = 0;
                while (parcel.dataPosition() < iD020) {
                    int i23 = parcel.readInt();
                    if (((char) i23) != 2) {
                        f.z0(parcel, i23);
                    } else {
                        iO010 = f.o0(parcel, i23);
                    }
                }
                f.t(parcel, iD020);
                return new StreetViewSource(iO010);
            case 20:
                int iD021 = f.D0(parcel);
                float fL032 = Property.DEFAULT_FLOAT_VALUE;
                int iO011 = 0;
                int iO012 = 0;
                boolean zI016 = false;
                StampStyle stampStyle = null;
                while (parcel.dataPosition() < iD021) {
                    int i24 = parcel.readInt();
                    char c16 = (char) i24;
                    if (c16 == 2) {
                        fL032 = f.l0(parcel, i24);
                    } else if (c16 == 3) {
                        iO011 = f.o0(parcel, i24);
                    } else if (c16 == 4) {
                        iO012 = f.o0(parcel, i24);
                    } else if (c16 == 5) {
                        zI016 = f.i0(parcel, i24);
                    } else if (c16 != 6) {
                        f.z0(parcel, i24);
                    } else {
                        stampStyle = (StampStyle) f.p(parcel, i24, StampStyle.CREATOR);
                    }
                }
                f.t(parcel, iD021);
                return new StrokeStyle(fL032, iO011, iO012, zI016, stampStyle);
            case 21:
                int iD022 = f.D0(parcel);
                StrokeStyle strokeStyle = null;
                while (parcel.dataPosition() < iD022) {
                    int i25 = parcel.readInt();
                    char c17 = (char) i25;
                    if (c17 == 2) {
                        strokeStyle = (StrokeStyle) f.p(parcel, i25, StrokeStyle.CREATOR);
                    } else if (c17 != 3) {
                        f.z0(parcel, i25);
                    } else {
                        dK0 = f.k0(parcel, i25);
                    }
                }
                f.t(parcel, iD022);
                return new StyleSpan(strokeStyle, dK0);
            case 22:
                int iD023 = f.D0(parcel);
                int iO013 = 0;
                int iO014 = 0;
                byte[] bArrL = null;
                while (parcel.dataPosition() < iD023) {
                    int i26 = parcel.readInt();
                    char c18 = (char) i26;
                    if (c18 == 2) {
                        iO014 = f.o0(parcel, i26);
                    } else if (c18 == 3) {
                        iO013 = f.o0(parcel, i26);
                    } else if (c18 != 4) {
                        f.z0(parcel, i26);
                    } else {
                        bArrL = f.l(parcel, i26);
                    }
                }
                f.t(parcel, iD023);
                return new Tile(iO014, iO013, bArrL);
            case 23:
                int iD024 = f.D0(parcel);
                byte bJ0 = -1;
                byte bJ02 = -1;
                CameraPosition cameraPosition = null;
                byte bJ03 = -1;
                byte bJ04 = -1;
                byte bJ05 = -1;
                int iO015 = 0;
                byte bJ06 = -1;
                byte bJ07 = -1;
                byte bJ08 = -1;
                byte bJ09 = -1;
                byte bJ010 = -1;
                byte bJ011 = -1;
                Float fM03 = null;
                Float fM04 = null;
                LatLngBounds latLngBounds3 = null;
                byte bJ012 = -1;
                Integer numValueOf = null;
                String strQ8 = null;
                while (parcel.dataPosition() < iD024) {
                    int i27 = parcel.readInt();
                    switch ((char) i27) {
                        case 2:
                            bJ0 = f.j0(parcel, i27);
                            break;
                        case 3:
                            bJ02 = f.j0(parcel, i27);
                            break;
                        case 4:
                            iO015 = f.o0(parcel, i27);
                            break;
                        case 5:
                            cameraPosition = (CameraPosition) f.p(parcel, i27, CameraPosition.CREATOR);
                            break;
                        case 6:
                            bJ03 = f.j0(parcel, i27);
                            break;
                        case 7:
                            bJ04 = f.j0(parcel, i27);
                            break;
                        case '\b':
                            bJ05 = f.j0(parcel, i27);
                            break;
                        case '\t':
                            bJ06 = f.j0(parcel, i27);
                            break;
                        case '\n':
                            bJ07 = f.j0(parcel, i27);
                            break;
                        case 11:
                            bJ08 = f.j0(parcel, i27);
                            break;
                        case '\f':
                            bJ09 = f.j0(parcel, i27);
                            break;
                        case '\r':
                        default:
                            f.z0(parcel, i27);
                            break;
                        case 14:
                            bJ010 = f.j0(parcel, i27);
                            break;
                        case 15:
                            bJ011 = f.j0(parcel, i27);
                            break;
                        case 16:
                            fM03 = f.m0(parcel, i27);
                            break;
                        case 17:
                            fM04 = f.m0(parcel, i27);
                            break;
                        case 18:
                            latLngBounds3 = (LatLngBounds) f.p(parcel, i27, LatLngBounds.CREATOR);
                            break;
                        case 19:
                            bJ012 = f.j0(parcel, i27);
                            break;
                        case 20:
                            int iQ02 = f.q0(parcel, i27);
                            if (iQ02 != 0) {
                                f.F0(parcel, iQ02, 4);
                                numValueOf = Integer.valueOf(parcel.readInt());
                                break;
                            } else {
                                numValueOf = null;
                                break;
                            }
                        case 21:
                            strQ8 = f.q(parcel, i27);
                            break;
                    }
                }
                f.t(parcel, iD024);
                GoogleMapOptions googleMapOptions = new GoogleMapOptions();
                googleMapOptions.f10110c = -1;
                googleMapOptions.f10121n = null;
                googleMapOptions.f10122o = null;
                googleMapOptions.f10123p = null;
                googleMapOptions.f10125r = null;
                googleMapOptions.f10126s = null;
                googleMapOptions.f10108a = com.stepos.statsrpk.c.T(bJ0);
                googleMapOptions.f10109b = com.stepos.statsrpk.c.T(bJ02);
                googleMapOptions.f10110c = iO015;
                googleMapOptions.f10111d = cameraPosition;
                googleMapOptions.f10112e = com.stepos.statsrpk.c.T(bJ03);
                googleMapOptions.f10113f = com.stepos.statsrpk.c.T(bJ04);
                googleMapOptions.f10114g = com.stepos.statsrpk.c.T(bJ05);
                googleMapOptions.f10115h = com.stepos.statsrpk.c.T(bJ06);
                googleMapOptions.f10116i = com.stepos.statsrpk.c.T(bJ07);
                googleMapOptions.f10117j = com.stepos.statsrpk.c.T(bJ08);
                googleMapOptions.f10118k = com.stepos.statsrpk.c.T(bJ09);
                googleMapOptions.f10119l = com.stepos.statsrpk.c.T(bJ010);
                googleMapOptions.f10120m = com.stepos.statsrpk.c.T(bJ011);
                googleMapOptions.f10121n = fM03;
                googleMapOptions.f10122o = fM04;
                googleMapOptions.f10123p = latLngBounds3;
                googleMapOptions.f10124q = com.stepos.statsrpk.c.T(bJ012);
                googleMapOptions.f10125r = numValueOf;
                googleMapOptions.f10126s = strQ8;
                return googleMapOptions;
            case 24:
                int iD025 = f.D0(parcel);
                byte bJ013 = 0;
                byte bJ014 = 0;
                byte bJ015 = 0;
                byte bJ016 = 0;
                StreetViewPanoramaCamera streetViewPanoramaCamera = null;
                String strQ9 = null;
                LatLng latLng13 = null;
                byte bJ017 = 0;
                Integer numValueOf2 = null;
                StreetViewSource streetViewSource = null;
                while (parcel.dataPosition() < iD025) {
                    int i28 = parcel.readInt();
                    switch ((char) i28) {
                        case 2:
                            streetViewPanoramaCamera = (StreetViewPanoramaCamera) f.p(parcel, i28, StreetViewPanoramaCamera.CREATOR);
                            break;
                        case 3:
                            strQ9 = f.q(parcel, i28);
                            break;
                        case 4:
                            latLng13 = (LatLng) f.p(parcel, i28, LatLng.CREATOR);
                            break;
                        case 5:
                            int iQ03 = f.q0(parcel, i28);
                            if (iQ03 != 0) {
                                f.F0(parcel, iQ03, 4);
                                numValueOf2 = Integer.valueOf(parcel.readInt());
                                break;
                            } else {
                                numValueOf2 = null;
                                break;
                            }
                        case 6:
                            bJ017 = f.j0(parcel, i28);
                            break;
                        case 7:
                            bJ013 = f.j0(parcel, i28);
                            break;
                        case '\b':
                            bJ014 = f.j0(parcel, i28);
                            break;
                        case '\t':
                            bJ015 = f.j0(parcel, i28);
                            break;
                        case '\n':
                            bJ016 = f.j0(parcel, i28);
                            break;
                        case 11:
                            streetViewSource = (StreetViewSource) f.p(parcel, i28, StreetViewSource.CREATOR);
                            break;
                        default:
                            f.z0(parcel, i28);
                            break;
                    }
                }
                f.t(parcel, iD025);
                StreetViewPanoramaOptions streetViewPanoramaOptions = new StreetViewPanoramaOptions();
                Boolean bool = Boolean.TRUE;
                streetViewPanoramaOptions.f10131e = bool;
                streetViewPanoramaOptions.f10132f = bool;
                streetViewPanoramaOptions.f10133g = bool;
                streetViewPanoramaOptions.f10134h = bool;
                streetViewPanoramaOptions.f10136j = StreetViewSource.f10225b;
                streetViewPanoramaOptions.f10127a = streetViewPanoramaCamera;
                streetViewPanoramaOptions.f10129c = latLng13;
                streetViewPanoramaOptions.f10130d = numValueOf2;
                streetViewPanoramaOptions.f10128b = strQ9;
                streetViewPanoramaOptions.f10131e = com.stepos.statsrpk.c.T(bJ017);
                streetViewPanoramaOptions.f10132f = com.stepos.statsrpk.c.T(bJ013);
                streetViewPanoramaOptions.f10133g = com.stepos.statsrpk.c.T(bJ014);
                streetViewPanoramaOptions.f10134h = com.stepos.statsrpk.c.T(bJ015);
                streetViewPanoramaOptions.f10135i = com.stepos.statsrpk.c.T(bJ016);
                streetViewPanoramaOptions.f10136j = streetViewSource;
                return streetViewPanoramaOptions;
            case 25:
                int iD026 = f.D0(parcel);
                int iO016 = 0;
                int iO017 = 0;
                Intent intent = null;
                while (parcel.dataPosition() < iD026) {
                    int i29 = parcel.readInt();
                    char c19 = (char) i29;
                    if (c19 == 1) {
                        iO017 = f.o0(parcel, i29);
                    } else if (c19 == 2) {
                        iO016 = f.o0(parcel, i29);
                    } else if (c19 != 3) {
                        f.z0(parcel, i29);
                    } else {
                        intent = (Intent) f.p(parcel, i29, Intent.CREATOR);
                    }
                }
                f.t(parcel, iD026);
                return new zaa(iO017, iO016, intent);
            case 26:
                int iD027 = f.D0(parcel);
                ArrayList<String> arrayList2 = null;
                String strQ10 = null;
                while (parcel.dataPosition() < iD027) {
                    int i30 = parcel.readInt();
                    char c20 = (char) i30;
                    if (c20 == 1) {
                        int iQ04 = f.q0(parcel, i30);
                        int iDataPosition2 = parcel.dataPosition();
                        if (iQ04 == 0) {
                            arrayList2 = null;
                        } else {
                            ArrayList<String> arrayListCreateStringArrayList = parcel.createStringArrayList();
                            parcel.setDataPosition(iDataPosition2 + iQ04);
                            arrayList2 = arrayListCreateStringArrayList;
                        }
                    } else if (c20 != 2) {
                        f.z0(parcel, i30);
                    } else {
                        strQ10 = f.q(parcel, i30);
                    }
                }
                f.t(parcel, iD027);
                return new zag(strQ10, arrayList2);
            case 27:
                int iD028 = f.D0(parcel);
                int iO018 = 0;
                zat zatVar = null;
                while (parcel.dataPosition() < iD028) {
                    int i31 = parcel.readInt();
                    char c21 = (char) i31;
                    if (c21 == 1) {
                        iO018 = f.o0(parcel, i31);
                    } else if (c21 != 2) {
                        f.z0(parcel, i31);
                    } else {
                        zatVar = (zat) f.p(parcel, i31, zat.CREATOR);
                    }
                }
                f.t(parcel, iD028);
                return new zai(iO018, zatVar);
            case 28:
                int iD029 = f.D0(parcel);
                zav zavVar = null;
                int iO019 = 0;
                ConnectionResult connectionResult = null;
                while (parcel.dataPosition() < iD029) {
                    int i32 = parcel.readInt();
                    char c22 = (char) i32;
                    if (c22 == 1) {
                        iO019 = f.o0(parcel, i32);
                    } else if (c22 == 2) {
                        connectionResult = (ConnectionResult) f.p(parcel, i32, ConnectionResult.CREATOR);
                    } else if (c22 != 3) {
                        f.z0(parcel, i32);
                    } else {
                        zavVar = (zav) f.p(parcel, i32, zav.CREATOR);
                    }
                }
                f.t(parcel, iD029);
                return new zak(iO019, connectionResult, zavVar);
            default:
                BadgeState$State badgeState$State = new BadgeState$State();
                badgeState$State.f10353i = 255;
                badgeState$State.f10355k = -2;
                badgeState$State.f10356l = -2;
                badgeState$State.f10357m = -2;
                badgeState$State.f10363s = Boolean.TRUE;
                badgeState$State.f10345a = parcel.readInt();
                badgeState$State.f10346b = (Integer) parcel.readSerializable();
                badgeState$State.f10347c = (Integer) parcel.readSerializable();
                badgeState$State.f10348d = (Integer) parcel.readSerializable();
                badgeState$State.f10349e = (Integer) parcel.readSerializable();
                badgeState$State.f10350f = (Integer) parcel.readSerializable();
                badgeState$State.f10351g = (Integer) parcel.readSerializable();
                badgeState$State.f10352h = (Integer) parcel.readSerializable();
                badgeState$State.f10353i = parcel.readInt();
                badgeState$State.f10354j = parcel.readString();
                badgeState$State.f10355k = parcel.readInt();
                badgeState$State.f10356l = parcel.readInt();
                badgeState$State.f10357m = parcel.readInt();
                badgeState$State.f10359o = parcel.readString();
                badgeState$State.f10360p = parcel.readString();
                badgeState$State.f10361q = parcel.readInt();
                badgeState$State.f10362r = (Integer) parcel.readSerializable();
                badgeState$State.f10364t = (Integer) parcel.readSerializable();
                badgeState$State.f10365u = (Integer) parcel.readSerializable();
                badgeState$State.f10366v = (Integer) parcel.readSerializable();
                badgeState$State.f10367w = (Integer) parcel.readSerializable();
                badgeState$State.f10368x = (Integer) parcel.readSerializable();
                badgeState$State.f10369y = (Integer) parcel.readSerializable();
                badgeState$State.f10342B = (Integer) parcel.readSerializable();
                badgeState$State.f10370z = (Integer) parcel.readSerializable();
                badgeState$State.f10341A = (Integer) parcel.readSerializable();
                badgeState$State.f10363s = (Boolean) parcel.readSerializable();
                badgeState$State.f10358n = (Locale) parcel.readSerializable();
                badgeState$State.f10343C = (Boolean) parcel.readSerializable();
                badgeState$State.f10344D = (Integer) parcel.readSerializable();
                return badgeState$State;
        }
    }

    @Override // android.os.Parcelable.Creator
    public final Object[] newArray(int i4) {
        switch (this.f10248a) {
            case 0:
                return new CameraPosition[i4];
            case 1:
                return new TileOverlayOptions[i4];
            case 2:
                return new VisibleRegion[i4];
            case 3:
                return new Cap[i4];
            case 4:
                return new CircleOptions[i4];
            case 5:
                return new GroundOverlayOptions[i4];
            case 6:
                return new LatLngBounds[i4];
            case 7:
                return new LatLng[i4];
            case 8:
                return new MapStyleOptions[i4];
            case 9:
                return new MarkerOptions[i4];
            case 10:
                return new PatternItem[i4];
            case 11:
                return new PointOfInterest[i4];
            case 12:
                return new PolygonOptions[i4];
            case 13:
                return new PolylineOptions[i4];
            case 14:
                return new StampStyle[i4];
            case 15:
                return new StreetViewPanoramaCamera[i4];
            case 16:
                return new StreetViewPanoramaLink[i4];
            case 17:
                return new StreetViewPanoramaLocation[i4];
            case 18:
                return new StreetViewPanoramaOrientation[i4];
            case 19:
                return new StreetViewSource[i4];
            case 20:
                return new StrokeStyle[i4];
            case 21:
                return new StyleSpan[i4];
            case 22:
                return new Tile[i4];
            case 23:
                return new GoogleMapOptions[i4];
            case 24:
                return new StreetViewPanoramaOptions[i4];
            case 25:
                return new zaa[i4];
            case 26:
                return new zag[i4];
            case 27:
                return new zai[i4];
            case 28:
                return new zak[i4];
            default:
                return new BadgeState$State[i4];
        }
    }
}
