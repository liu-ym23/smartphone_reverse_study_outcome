package com.google.android.gms.common;

import android.app.PendingIntent;
import android.location.Location;
import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.WorkSource;
import android.util.Log;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.ClientIdentity;
import com.google.android.gms.internal.location.zzd;
import com.google.android.gms.internal.location.zzdb;
import com.google.android.gms.internal.location.zzdd;
import com.google.android.gms.internal.location.zzdf;
import com.google.android.gms.internal.location.zzdh;
import com.google.android.gms.location.ActivityRecognitionResult;
import com.google.android.gms.location.ActivityTransition;
import com.google.android.gms.location.ActivityTransitionEvent;
import com.google.android.gms.location.ActivityTransitionRequest;
import com.google.android.gms.location.ActivityTransitionResult;
import com.google.android.gms.location.CurrentLocationRequest;
import com.google.android.gms.location.DetectedActivity;
import com.google.android.gms.location.GeofencingRequest;
import com.google.android.gms.location.LastLocationRequest;
import com.google.android.gms.location.LocationAvailability;
import com.google.android.gms.location.LocationRequest;
import com.google.android.gms.location.LocationResult;
import com.google.android.gms.location.LocationSettingsRequest;
import com.google.android.gms.location.LocationSettingsResult;
import com.google.android.gms.location.LocationSettingsStates;
import com.google.android.gms.location.SleepClassifyEvent;
import com.google.android.gms.location.SleepSegmentEvent;
import com.google.android.gms.location.SleepSegmentRequest;
import com.google.android.gms.location.zzac;
import com.google.android.gms.location.zzaj;
import com.google.android.gms.location.zzb;
import com.stepos.alphame.utils.Property;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
import kotlin.jvm.internal.LongCompanionObject;

/* loaded from: classes.dex */
public final class k implements Parcelable.Creator {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f9879a;

    public /* synthetic */ k(int i4) {
        this.f9879a = i4;
    }

    @Override // android.os.Parcelable.Creator
    public final Object createFromParcel(Parcel parcel) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        WorkSource workSource;
        boolean z4;
        long j4;
        long j5;
        String strQ = "";
        switch (this.f9879a) {
            case 0:
                int iD0 = B0.f.D0(parcel);
                boolean zI0 = false;
                boolean zI02 = false;
                boolean zI03 = false;
                String strQ2 = null;
                IBinder iBinderN0 = null;
                while (parcel.dataPosition() < iD0) {
                    int i4 = parcel.readInt();
                    char c4 = (char) i4;
                    if (c4 == 1) {
                        strQ2 = B0.f.q(parcel, i4);
                    } else if (c4 == 2) {
                        zI0 = B0.f.i0(parcel, i4);
                    } else if (c4 == 3) {
                        zI02 = B0.f.i0(parcel, i4);
                    } else if (c4 == 4) {
                        iBinderN0 = B0.f.n0(parcel, i4);
                    } else if (c4 != 5) {
                        B0.f.z0(parcel, i4);
                    } else {
                        zI03 = B0.f.i0(parcel, i4);
                    }
                }
                B0.f.t(parcel, iD0);
                return new zzo(strQ2, zI0, zI02, iBinderN0, zI03);
            case 1:
                int iD02 = B0.f.D0(parcel);
                boolean zI04 = false;
                int iO0 = 0;
                int iO02 = 0;
                String strQ3 = null;
                while (parcel.dataPosition() < iD02) {
                    int i5 = parcel.readInt();
                    char c5 = (char) i5;
                    if (c5 == 1) {
                        zI04 = B0.f.i0(parcel, i5);
                    } else if (c5 == 2) {
                        strQ3 = B0.f.q(parcel, i5);
                    } else if (c5 == 3) {
                        iO0 = B0.f.o0(parcel, i5);
                    } else if (c5 != 4) {
                        B0.f.z0(parcel, i5);
                    } else {
                        iO02 = B0.f.o0(parcel, i5);
                    }
                }
                B0.f.t(parcel, iD02);
                return new zzq(iO0, iO02, strQ3, zI04);
            case 2:
                int iD03 = B0.f.D0(parcel);
                boolean zI05 = false;
                boolean zI06 = false;
                IBinder iBinderN02 = null;
                String strQ4 = null;
                while (parcel.dataPosition() < iD03) {
                    int i6 = parcel.readInt();
                    char c6 = (char) i6;
                    if (c6 == 1) {
                        strQ4 = B0.f.q(parcel, i6);
                    } else if (c6 == 2) {
                        iBinderN02 = B0.f.n0(parcel, i6);
                    } else if (c6 == 3) {
                        zI05 = B0.f.i0(parcel, i6);
                    } else if (c6 != 4) {
                        B0.f.z0(parcel, i6);
                    } else {
                        zI06 = B0.f.i0(parcel, i6);
                    }
                }
                B0.f.t(parcel, iD03);
                return new zzs(strQ4, iBinderN02, zI05, zI06);
            case 3:
                int iD04 = B0.f.D0(parcel);
                int iO03 = 0;
                IBinder iBinderN03 = null;
                IBinder iBinderN04 = null;
                PendingIntent pendingIntent = null;
                String strQ5 = null;
                while (parcel.dataPosition() < iD04) {
                    int i7 = parcel.readInt();
                    switch ((char) i7) {
                        case 1:
                            iO03 = B0.f.o0(parcel, i7);
                            break;
                        case 2:
                            iBinderN03 = B0.f.n0(parcel, i7);
                            break;
                        case 3:
                            iBinderN04 = B0.f.n0(parcel, i7);
                            break;
                        case 4:
                            pendingIntent = (PendingIntent) B0.f.p(parcel, i7, PendingIntent.CREATOR);
                            break;
                        case 5:
                            B0.f.q(parcel, i7);
                            break;
                        case 6:
                            strQ5 = B0.f.q(parcel, i7);
                            break;
                        default:
                            B0.f.z0(parcel, i7);
                            break;
                    }
                }
                B0.f.t(parcel, iD04);
                return new zzdb(iO03, iBinderN03, iBinderN04, pendingIntent, strQ5);
            case 4:
                int iD05 = B0.f.D0(parcel);
                boolean zI07 = false;
                boolean zI08 = false;
                boolean zI09 = false;
                boolean zI010 = false;
                LocationRequest locationRequest = null;
                ArrayList<ClientIdentity> arrayListS = null;
                long jP0 = LongCompanionObject.MAX_VALUE;
                while (parcel.dataPosition() < iD05) {
                    int i8 = parcel.readInt();
                    char c7 = (char) i8;
                    if (c7 == 1) {
                        locationRequest = (LocationRequest) B0.f.p(parcel, i8, LocationRequest.CREATOR);
                    } else if (c7 != 5) {
                        switch (c7) {
                            case '\b':
                                zI07 = B0.f.i0(parcel, i8);
                                break;
                            case '\t':
                                zI08 = B0.f.i0(parcel, i8);
                                break;
                            case '\n':
                                B0.f.q(parcel, i8);
                                break;
                            case 11:
                                zI09 = B0.f.i0(parcel, i8);
                                break;
                            case '\f':
                                zI010 = B0.f.i0(parcel, i8);
                                break;
                            case '\r':
                                B0.f.q(parcel, i8);
                                break;
                            case 14:
                                jP0 = B0.f.p0(parcel, i8);
                                break;
                            default:
                                B0.f.z0(parcel, i8);
                                break;
                        }
                    } else {
                        arrayListS = B0.f.s(parcel, i8, ClientIdentity.CREATOR);
                    }
                }
                B0.f.t(parcel, iD05);
                zzdd zzddVar = new zzdd();
                int i9 = locationRequest.f10047a;
                if (arrayListS == null) {
                    workSource = locationRequest.f10060n;
                } else if (arrayListS.isEmpty()) {
                    workSource = null;
                } else {
                    workSource = new WorkSource();
                    for (ClientIdentity clientIdentity : arrayListS) {
                        int i10 = clientIdentity.f9731a;
                        Method method = e1.b.f12503b;
                        if (method != null) {
                            String str = clientIdentity.f9732b;
                            if (str == null) {
                                str = "";
                            }
                            try {
                                method.invoke(workSource, Integer.valueOf(i10), str);
                            } catch (Exception e4) {
                                Log.wtf("WorkSourceUtil", "Unable to assign blame through WorkSource", e4);
                            }
                        } else {
                            Method method2 = e1.b.f12502a;
                            if (method2 != null) {
                                try {
                                    method2.invoke(workSource, Integer.valueOf(i10));
                                } catch (Exception e5) {
                                    Log.wtf("WorkSourceUtil", "Unable to assign blame through WorkSource", e5);
                                }
                            }
                        }
                    }
                }
                int i11 = zI07 ? 1 : locationRequest.f10056j;
                int i12 = zI08 ? 2 : locationRequest.f10057k;
                boolean z5 = zI09 ? true : locationRequest.f10059m;
                if (zI010) {
                    j4 = LongCompanionObject.MAX_VALUE;
                    z4 = true;
                } else {
                    z4 = locationRequest.f10054h;
                    j4 = LongCompanionObject.MAX_VALUE;
                }
                if (jP0 != j4) {
                    com.stepos.statsrpk.c.j("maxUpdateAgeMillis must be greater than or equal to 0, or IMPLICIT_MAX_UPDATE_AGE", jP0 == -1 || jP0 >= 0);
                } else {
                    jP0 = locationRequest.f10055i;
                }
                long jMin = locationRequest.f10049c;
                long j6 = locationRequest.f10048b;
                if (jMin == -1) {
                    j5 = j6;
                } else {
                    if (i9 != 105) {
                        jMin = Math.min(jMin, j6);
                    }
                    j5 = jMin;
                }
                zzddVar.f9987a = new LocationRequest(i9, j6, j5, Math.max(locationRequest.f10050d, j6), LongCompanionObject.MAX_VALUE, locationRequest.f10051e, locationRequest.f10052f, locationRequest.f10053g, z4, jP0 == -1 ? j6 : jP0, i11, i12, locationRequest.f10058l, z5, new WorkSource(workSource), locationRequest.f10061o);
                return zzddVar;
            case 5:
                int iD06 = B0.f.D0(parcel);
                int iO04 = 1;
                zzdd zzddVar2 = null;
                IBinder iBinderN05 = null;
                IBinder iBinderN06 = null;
                PendingIntent pendingIntent2 = null;
                IBinder iBinderN07 = null;
                String strQ6 = null;
                while (parcel.dataPosition() < iD06) {
                    int i13 = parcel.readInt();
                    switch ((char) i13) {
                        case 1:
                            iO04 = B0.f.o0(parcel, i13);
                            break;
                        case 2:
                            zzddVar2 = (zzdd) B0.f.p(parcel, i13, zzdd.CREATOR);
                            break;
                        case 3:
                            iBinderN05 = B0.f.n0(parcel, i13);
                            break;
                        case 4:
                            pendingIntent2 = (PendingIntent) B0.f.p(parcel, i13, PendingIntent.CREATOR);
                            break;
                        case 5:
                            iBinderN06 = B0.f.n0(parcel, i13);
                            break;
                        case 6:
                            iBinderN07 = B0.f.n0(parcel, i13);
                            break;
                        case 7:
                        default:
                            B0.f.z0(parcel, i13);
                            break;
                        case '\b':
                            strQ6 = B0.f.q(parcel, i13);
                            break;
                    }
                }
                B0.f.t(parcel, iD06);
                return new zzdf(iO04, zzddVar2, iBinderN05, iBinderN06, pendingIntent2, iBinderN07, strQ6);
            case 6:
                int iD07 = B0.f.D0(parcel);
                double dK0 = 0.0d;
                double dK02 = 0.0d;
                int iO05 = -1;
                int iO06 = 0;
                short s4 = 0;
                int iO07 = 0;
                String strQ7 = null;
                float fL0 = Property.DEFAULT_FLOAT_VALUE;
                long jP02 = 0;
                while (parcel.dataPosition() < iD07) {
                    int i14 = parcel.readInt();
                    switch ((char) i14) {
                        case 1:
                            strQ7 = B0.f.q(parcel, i14);
                            break;
                        case 2:
                            jP02 = B0.f.p0(parcel, i14);
                            break;
                        case 3:
                            B0.f.H0(parcel, i14, 4);
                            s4 = (short) parcel.readInt();
                            break;
                        case 4:
                            dK0 = B0.f.k0(parcel, i14);
                            break;
                        case 5:
                            dK02 = B0.f.k0(parcel, i14);
                            break;
                        case 6:
                            fL0 = B0.f.l0(parcel, i14);
                            break;
                        case 7:
                            iO06 = B0.f.o0(parcel, i14);
                            break;
                        case '\b':
                            iO07 = B0.f.o0(parcel, i14);
                            break;
                        case '\t':
                            iO05 = B0.f.o0(parcel, i14);
                            break;
                        default:
                            B0.f.z0(parcel, i14);
                            break;
                    }
                }
                B0.f.t(parcel, iD07);
                return new zzdh(strQ7, iO06, s4, dK0, dK02, fL0, jP02, iO07, iO05);
            case 7:
                int iD08 = B0.f.D0(parcel);
                com.google.android.gms.internal.location.h hVar = com.google.android.gms.internal.location.j.f9970b;
                List listS = com.google.android.gms.internal.location.k.f9971e;
                int iO08 = 0;
                int iO09 = 0;
                int iO010 = 0;
                String strQ8 = null;
                String strQ9 = null;
                String strQ10 = null;
                zzd zzdVar = null;
                while (parcel.dataPosition() < iD08) {
                    int i15 = parcel.readInt();
                    switch ((char) i15) {
                        case 1:
                            iO08 = B0.f.o0(parcel, i15);
                            break;
                        case 2:
                            iO09 = B0.f.o0(parcel, i15);
                            break;
                        case 3:
                            strQ8 = B0.f.q(parcel, i15);
                            break;
                        case 4:
                            strQ9 = B0.f.q(parcel, i15);
                            break;
                        case 5:
                            iO010 = B0.f.o0(parcel, i15);
                            break;
                        case 6:
                            strQ10 = B0.f.q(parcel, i15);
                            break;
                        case 7:
                            zzdVar = (zzd) B0.f.p(parcel, i15, zzd.CREATOR);
                            break;
                        case '\b':
                            listS = B0.f.s(parcel, i15, Feature.CREATOR);
                            break;
                        default:
                            B0.f.z0(parcel, i15);
                            break;
                    }
                }
                B0.f.t(parcel, iD08);
                return new zzd(iO08, iO09, strQ8, strQ9, strQ10, iO010, listS, zzdVar);
            case 8:
                int iD09 = B0.f.D0(parcel);
                Status status = null;
                while (parcel.dataPosition() < iD09) {
                    int i16 = parcel.readInt();
                    if (((char) i16) != 1) {
                        B0.f.z0(parcel, i16);
                    } else {
                        status = (Status) B0.f.p(parcel, i16, Status.CREATOR);
                    }
                }
                B0.f.t(parcel, iD09);
                return new com.google.android.gms.internal.location.zzg(status);
            case 9:
                int iD010 = B0.f.D0(parcel);
                LocationSettingsStates locationSettingsStates = null;
                Status status2 = null;
                while (parcel.dataPosition() < iD010) {
                    int i17 = parcel.readInt();
                    char c8 = (char) i17;
                    if (c8 == 1) {
                        status2 = (Status) B0.f.p(parcel, i17, Status.CREATOR);
                    } else if (c8 != 2) {
                        B0.f.z0(parcel, i17);
                    } else {
                        locationSettingsStates = (LocationSettingsStates) B0.f.p(parcel, i17, LocationSettingsStates.CREATOR);
                    }
                }
                B0.f.t(parcel, iD010);
                return new LocationSettingsResult(status2, locationSettingsStates);
            case 10:
                int iD011 = B0.f.D0(parcel);
                boolean zI011 = false;
                boolean zI012 = false;
                boolean zI013 = false;
                boolean zI014 = false;
                boolean zI015 = false;
                boolean zI016 = false;
                while (parcel.dataPosition() < iD011) {
                    int i18 = parcel.readInt();
                    switch ((char) i18) {
                        case 1:
                            zI011 = B0.f.i0(parcel, i18);
                            break;
                        case 2:
                            zI012 = B0.f.i0(parcel, i18);
                            break;
                        case 3:
                            zI013 = B0.f.i0(parcel, i18);
                            break;
                        case 4:
                            zI014 = B0.f.i0(parcel, i18);
                            break;
                        case 5:
                            zI015 = B0.f.i0(parcel, i18);
                            break;
                        case 6:
                            zI016 = B0.f.i0(parcel, i18);
                            break;
                        default:
                            B0.f.z0(parcel, i18);
                            break;
                    }
                }
                B0.f.t(parcel, iD011);
                return new LocationSettingsStates(zI011, zI012, zI013, zI014, zI015, zI016);
            case 11:
                int iD012 = B0.f.D0(parcel);
                int iO011 = 1;
                int iO012 = 1;
                long jP03 = -1;
                long jP04 = -1;
                while (parcel.dataPosition() < iD012) {
                    int i19 = parcel.readInt();
                    char c9 = (char) i19;
                    if (c9 == 1) {
                        iO011 = B0.f.o0(parcel, i19);
                    } else if (c9 == 2) {
                        iO012 = B0.f.o0(parcel, i19);
                    } else if (c9 == 3) {
                        jP03 = B0.f.p0(parcel, i19);
                    } else if (c9 != 4) {
                        B0.f.z0(parcel, i19);
                    } else {
                        jP04 = B0.f.p0(parcel, i19);
                    }
                }
                B0.f.t(parcel, iD012);
                return new zzac(jP03, iO011, jP04, iO012);
            case 12:
                int iD013 = B0.f.D0(parcel);
                int iO013 = 0;
                int iO014 = 0;
                int iO015 = 0;
                int iO016 = 0;
                int iO017 = 0;
                int iO018 = 0;
                int iO019 = 0;
                int iO020 = 0;
                boolean zI017 = false;
                while (parcel.dataPosition() < iD013) {
                    int i20 = parcel.readInt();
                    switch ((char) i20) {
                        case 1:
                            iO013 = B0.f.o0(parcel, i20);
                            break;
                        case 2:
                            iO014 = B0.f.o0(parcel, i20);
                            break;
                        case 3:
                            iO015 = B0.f.o0(parcel, i20);
                            break;
                        case 4:
                            iO016 = B0.f.o0(parcel, i20);
                            break;
                        case 5:
                            iO017 = B0.f.o0(parcel, i20);
                            break;
                        case 6:
                            iO018 = B0.f.o0(parcel, i20);
                            break;
                        case 7:
                            iO019 = B0.f.o0(parcel, i20);
                            break;
                        case '\b':
                            zI017 = B0.f.i0(parcel, i20);
                            break;
                        case '\t':
                            iO020 = B0.f.o0(parcel, i20);
                            break;
                        default:
                            B0.f.z0(parcel, i20);
                            break;
                    }
                }
                B0.f.t(parcel, iD013);
                return new SleepClassifyEvent(iO013, iO014, iO015, iO016, iO017, iO018, iO019, iO020, zI017);
            case 13:
                int iD014 = B0.f.D0(parcel);
                int iO021 = 0;
                int iO022 = 0;
                int iO023 = 0;
                long jP05 = 0;
                long jP06 = 0;
                while (parcel.dataPosition() < iD014) {
                    int i21 = parcel.readInt();
                    char c10 = (char) i21;
                    if (c10 == 1) {
                        jP05 = B0.f.p0(parcel, i21);
                    } else if (c10 == 2) {
                        jP06 = B0.f.p0(parcel, i21);
                    } else if (c10 == 3) {
                        iO021 = B0.f.o0(parcel, i21);
                    } else if (c10 == 4) {
                        iO022 = B0.f.o0(parcel, i21);
                    } else if (c10 != 5) {
                        B0.f.z0(parcel, i21);
                    } else {
                        iO023 = B0.f.o0(parcel, i21);
                    }
                }
                B0.f.t(parcel, iD014);
                return new SleepSegmentEvent(jP05, jP06, iO021, iO022, iO023);
            case 14:
                int iD015 = B0.f.D0(parcel);
                int iO024 = 0;
                ArrayList arrayListS2 = null;
                while (parcel.dataPosition() < iD015) {
                    int i22 = parcel.readInt();
                    char c11 = (char) i22;
                    if (c11 == 1) {
                        arrayListS2 = B0.f.s(parcel, i22, zzaj.CREATOR);
                    } else if (c11 != 2) {
                        B0.f.z0(parcel, i22);
                    } else {
                        iO024 = B0.f.o0(parcel, i22);
                    }
                }
                B0.f.t(parcel, iD015);
                return new SleepSegmentRequest(iO024, arrayListS2);
            case 15:
                int iD016 = B0.f.D0(parcel);
                int iO025 = 0;
                int iO026 = 0;
                int iO027 = 0;
                int iO028 = 0;
                while (parcel.dataPosition() < iD016) {
                    int i23 = parcel.readInt();
                    char c12 = (char) i23;
                    if (c12 == 1) {
                        iO025 = B0.f.o0(parcel, i23);
                    } else if (c12 == 2) {
                        iO026 = B0.f.o0(parcel, i23);
                    } else if (c12 == 3) {
                        iO027 = B0.f.o0(parcel, i23);
                    } else if (c12 != 4) {
                        B0.f.z0(parcel, i23);
                    } else {
                        iO028 = B0.f.o0(parcel, i23);
                    }
                }
                B0.f.t(parcel, iD016);
                return new zzaj(iO025, iO026, iO027, iO028);
            case 16:
                int iD017 = B0.f.D0(parcel);
                boolean zI018 = false;
                boolean zI019 = false;
                long jP07 = 0;
                WorkSource workSource2 = null;
                String strQ11 = null;
                int[] iArrO = null;
                String strQ12 = null;
                long jP08 = 0;
                String strQ13 = null;
                while (parcel.dataPosition() < iD017) {
                    int i24 = parcel.readInt();
                    switch ((char) i24) {
                        case 1:
                            jP07 = B0.f.p0(parcel, i24);
                            break;
                        case 2:
                            zI018 = B0.f.i0(parcel, i24);
                            break;
                        case 3:
                            workSource2 = (WorkSource) B0.f.p(parcel, i24, WorkSource.CREATOR);
                            break;
                        case 4:
                            strQ11 = B0.f.q(parcel, i24);
                            break;
                        case 5:
                            iArrO = B0.f.o(parcel, i24);
                            break;
                        case 6:
                            zI019 = B0.f.i0(parcel, i24);
                            break;
                        case 7:
                            strQ12 = B0.f.q(parcel, i24);
                            break;
                        case '\b':
                            jP08 = B0.f.p0(parcel, i24);
                            break;
                        case '\t':
                            strQ13 = B0.f.q(parcel, i24);
                            break;
                        default:
                            B0.f.z0(parcel, i24);
                            break;
                    }
                }
                B0.f.t(parcel, iD017);
                return new zzb(jP07, zI018, workSource2, strQ11, iArrO, zI019, strQ12, jP08, strQ13);
            case 17:
                int iD018 = B0.f.D0(parcel);
                int iO029 = 0;
                Bundle bundleK = null;
                long jP09 = 0;
                long jP010 = 0;
                ArrayList arrayListS3 = null;
                while (parcel.dataPosition() < iD018) {
                    int i25 = parcel.readInt();
                    char c13 = (char) i25;
                    if (c13 == 1) {
                        arrayListS3 = B0.f.s(parcel, i25, DetectedActivity.CREATOR);
                    } else if (c13 == 2) {
                        jP09 = B0.f.p0(parcel, i25);
                    } else if (c13 == 3) {
                        jP010 = B0.f.p0(parcel, i25);
                    } else if (c13 == 4) {
                        iO029 = B0.f.o0(parcel, i25);
                    } else if (c13 != 5) {
                        B0.f.z0(parcel, i25);
                    } else {
                        bundleK = B0.f.k(parcel, i25);
                    }
                }
                B0.f.t(parcel, iD018);
                ActivityRecognitionResult activityRecognitionResult = new ActivityRecognitionResult();
                com.stepos.statsrpk.c.j("Must have at least 1 detected activity", arrayListS3 != null && arrayListS3.size() > 0);
                com.stepos.statsrpk.c.j("Must set times", jP09 > 0 && jP010 > 0);
                activityRecognitionResult.f10005a = arrayListS3;
                activityRecognitionResult.f10006b = jP09;
                activityRecognitionResult.f10007c = jP010;
                activityRecognitionResult.f10008d = iO029;
                activityRecognitionResult.f10009e = bundleK;
                return activityRecognitionResult;
            case 18:
                int iD019 = B0.f.D0(parcel);
                int iO030 = 0;
                int iO031 = 0;
                while (parcel.dataPosition() < iD019) {
                    int i26 = parcel.readInt();
                    char c14 = (char) i26;
                    if (c14 == 1) {
                        iO030 = B0.f.o0(parcel, i26);
                    } else if (c14 != 2) {
                        B0.f.z0(parcel, i26);
                    } else {
                        iO031 = B0.f.o0(parcel, i26);
                    }
                }
                B0.f.t(parcel, iD019);
                return new ActivityTransition(iO030, iO031);
            case 19:
                int iD020 = B0.f.D0(parcel);
                int iO032 = 0;
                int iO033 = 0;
                long jP011 = 0;
                while (parcel.dataPosition() < iD020) {
                    int i27 = parcel.readInt();
                    char c15 = (char) i27;
                    if (c15 == 1) {
                        iO032 = B0.f.o0(parcel, i27);
                    } else if (c15 == 2) {
                        iO033 = B0.f.o0(parcel, i27);
                    } else if (c15 != 3) {
                        B0.f.z0(parcel, i27);
                    } else {
                        jP011 = B0.f.p0(parcel, i27);
                    }
                }
                B0.f.t(parcel, iD020);
                return new ActivityTransitionEvent(iO032, iO033, jP011);
            case 20:
                int iD021 = B0.f.D0(parcel);
                String strQ14 = null;
                ArrayList arrayListS4 = null;
                String strQ15 = null;
                ArrayList arrayListS5 = null;
                while (parcel.dataPosition() < iD021) {
                    int i28 = parcel.readInt();
                    char c16 = (char) i28;
                    if (c16 == 1) {
                        arrayListS5 = B0.f.s(parcel, i28, ActivityTransition.CREATOR);
                    } else if (c16 == 2) {
                        strQ14 = B0.f.q(parcel, i28);
                    } else if (c16 == 3) {
                        arrayListS4 = B0.f.s(parcel, i28, ClientIdentity.CREATOR);
                    } else if (c16 != 4) {
                        B0.f.z0(parcel, i28);
                    } else {
                        strQ15 = B0.f.q(parcel, i28);
                    }
                }
                B0.f.t(parcel, iD021);
                return new ActivityTransitionRequest(arrayListS5, strQ14, arrayListS4, strQ15);
            case 21:
                int iD022 = B0.f.D0(parcel);
                Bundle bundleK2 = null;
                ArrayList arrayListS6 = null;
                while (parcel.dataPosition() < iD022) {
                    int i29 = parcel.readInt();
                    char c17 = (char) i29;
                    if (c17 == 1) {
                        arrayListS6 = B0.f.s(parcel, i29, ActivityTransitionEvent.CREATOR);
                    } else if (c17 != 2) {
                        B0.f.z0(parcel, i29);
                    } else {
                        bundleK2 = B0.f.k(parcel, i29);
                    }
                }
                B0.f.t(parcel, iD022);
                return new ActivityTransitionResult(arrayListS6, bundleK2);
            case 22:
                int iD023 = B0.f.D0(parcel);
                WorkSource workSource3 = new WorkSource();
                int iO034 = 102;
                int iO035 = 0;
                boolean zI020 = false;
                int iO036 = 0;
                long jP012 = LongCompanionObject.MAX_VALUE;
                long jP013 = LongCompanionObject.MAX_VALUE;
                String strQ16 = null;
                zzd zzdVar2 = null;
                while (parcel.dataPosition() < iD023) {
                    int i30 = parcel.readInt();
                    switch ((char) i30) {
                        case 1:
                            jP012 = B0.f.p0(parcel, i30);
                            break;
                        case 2:
                            iO035 = B0.f.o0(parcel, i30);
                            break;
                        case 3:
                            iO034 = B0.f.o0(parcel, i30);
                            break;
                        case 4:
                            jP013 = B0.f.p0(parcel, i30);
                            break;
                        case 5:
                            zI020 = B0.f.i0(parcel, i30);
                            break;
                        case 6:
                            workSource3 = (WorkSource) B0.f.p(parcel, i30, WorkSource.CREATOR);
                            break;
                        case 7:
                            iO036 = B0.f.o0(parcel, i30);
                            break;
                        case '\b':
                            strQ16 = B0.f.q(parcel, i30);
                            break;
                        case '\t':
                            zzdVar2 = (zzd) B0.f.p(parcel, i30, zzd.CREATOR);
                            break;
                        default:
                            B0.f.z0(parcel, i30);
                            break;
                    }
                }
                B0.f.t(parcel, iD023);
                return new CurrentLocationRequest(jP012, iO035, iO034, jP013, zI020, iO036, strQ16, workSource3, zzdVar2);
            case 23:
                int iD024 = B0.f.D0(parcel);
                int iO037 = 0;
                int iO038 = 0;
                while (parcel.dataPosition() < iD024) {
                    int i31 = parcel.readInt();
                    char c18 = (char) i31;
                    if (c18 == 1) {
                        iO037 = B0.f.o0(parcel, i31);
                    } else if (c18 != 2) {
                        B0.f.z0(parcel, i31);
                    } else {
                        iO038 = B0.f.o0(parcel, i31);
                    }
                }
                B0.f.t(parcel, iD024);
                DetectedActivity detectedActivity = new DetectedActivity();
                detectedActivity.f10031a = iO037;
                detectedActivity.f10032b = iO038;
                return detectedActivity;
            case 24:
                int iD025 = B0.f.D0(parcel);
                int iO039 = 0;
                String strQ17 = null;
                ArrayList arrayListS7 = null;
                while (parcel.dataPosition() < iD025) {
                    int i32 = parcel.readInt();
                    char c19 = (char) i32;
                    if (c19 == 1) {
                        arrayListS7 = B0.f.s(parcel, i32, zzdh.CREATOR);
                    } else if (c19 == 2) {
                        iO039 = B0.f.o0(parcel, i32);
                    } else if (c19 == 3) {
                        strQ = B0.f.q(parcel, i32);
                    } else if (c19 != 4) {
                        B0.f.z0(parcel, i32);
                    } else {
                        strQ17 = B0.f.q(parcel, i32);
                    }
                }
                B0.f.t(parcel, iD025);
                return new GeofencingRequest(arrayListS7, iO039, strQ, strQ17);
            case 25:
                int iD026 = B0.f.D0(parcel);
                int iO040 = 0;
                boolean zI021 = false;
                long jP014 = LongCompanionObject.MAX_VALUE;
                String strQ18 = null;
                zzd zzdVar3 = null;
                while (parcel.dataPosition() < iD026) {
                    int i33 = parcel.readInt();
                    char c20 = (char) i33;
                    if (c20 == 1) {
                        jP014 = B0.f.p0(parcel, i33);
                    } else if (c20 == 2) {
                        iO040 = B0.f.o0(parcel, i33);
                    } else if (c20 == 3) {
                        zI021 = B0.f.i0(parcel, i33);
                    } else if (c20 == 4) {
                        strQ18 = B0.f.q(parcel, i33);
                    } else if (c20 != 5) {
                        B0.f.z0(parcel, i33);
                    } else {
                        zzdVar3 = (zzd) B0.f.p(parcel, i33, zzd.CREATOR);
                    }
                }
                B0.f.t(parcel, iD026);
                return new LastLocationRequest(jP014, iO040, zI021, strQ18, zzdVar3);
            case 26:
                int iD027 = B0.f.D0(parcel);
                int iO041 = 1000;
                int iO042 = 1;
                int iO043 = 1;
                long jP015 = 0;
                zzac[] zzacVarArr = null;
                while (parcel.dataPosition() < iD027) {
                    int i34 = parcel.readInt();
                    switch ((char) i34) {
                        case 1:
                            iO042 = B0.f.o0(parcel, i34);
                            break;
                        case 2:
                            iO043 = B0.f.o0(parcel, i34);
                            break;
                        case 3:
                            jP015 = B0.f.p0(parcel, i34);
                            break;
                        case 4:
                            iO041 = B0.f.o0(parcel, i34);
                            break;
                        case 5:
                            zzacVarArr = (zzac[]) B0.f.r(parcel, i34, zzac.CREATOR);
                            break;
                        case 6:
                            B0.f.i0(parcel, i34);
                            break;
                        default:
                            B0.f.z0(parcel, i34);
                            break;
                    }
                }
                B0.f.t(parcel, iD027);
                return new LocationAvailability(iO041, iO042, iO043, jP015, zzacVarArr);
            case 27:
                int iD028 = B0.f.D0(parcel);
                WorkSource workSource4 = new WorkSource();
                int iO044 = Integer.MAX_VALUE;
                int iO045 = 102;
                long jP016 = 3600000;
                boolean zI022 = false;
                int iO046 = 0;
                int iO047 = 0;
                boolean zI023 = false;
                long jP017 = 600000;
                long jP018 = 0;
                long jP019 = LongCompanionObject.MAX_VALUE;
                long jP020 = LongCompanionObject.MAX_VALUE;
                float fL02 = Property.DEFAULT_FLOAT_VALUE;
                long jP021 = -1;
                String strQ19 = null;
                zzd zzdVar4 = null;
                while (parcel.dataPosition() < iD028) {
                    int i35 = parcel.readInt();
                    switch ((char) i35) {
                        case 1:
                            iO045 = B0.f.o0(parcel, i35);
                            break;
                        case 2:
                            jP016 = B0.f.p0(parcel, i35);
                            break;
                        case 3:
                            jP017 = B0.f.p0(parcel, i35);
                            break;
                        case 4:
                        default:
                            B0.f.z0(parcel, i35);
                            break;
                        case 5:
                            jP019 = B0.f.p0(parcel, i35);
                            break;
                        case 6:
                            iO044 = B0.f.o0(parcel, i35);
                            break;
                        case 7:
                            fL02 = B0.f.l0(parcel, i35);
                            break;
                        case '\b':
                            jP018 = B0.f.p0(parcel, i35);
                            break;
                        case '\t':
                            zI022 = B0.f.i0(parcel, i35);
                            break;
                        case '\n':
                            jP020 = B0.f.p0(parcel, i35);
                            break;
                        case 11:
                            jP021 = B0.f.p0(parcel, i35);
                            break;
                        case '\f':
                            iO046 = B0.f.o0(parcel, i35);
                            break;
                        case '\r':
                            iO047 = B0.f.o0(parcel, i35);
                            break;
                        case 14:
                            strQ19 = B0.f.q(parcel, i35);
                            break;
                        case 15:
                            zI023 = B0.f.i0(parcel, i35);
                            break;
                        case 16:
                            workSource4 = (WorkSource) B0.f.p(parcel, i35, WorkSource.CREATOR);
                            break;
                        case 17:
                            zzdVar4 = (zzd) B0.f.p(parcel, i35, zzd.CREATOR);
                            break;
                    }
                }
                B0.f.t(parcel, iD028);
                return new LocationRequest(iO045, jP016, jP017, jP018, jP019, jP020, iO044, fL02, zI022, jP021, iO046, iO047, strQ19, zI023, workSource4, zzdVar4);
            case 28:
                int iD029 = B0.f.D0(parcel);
                List listS2 = LocationResult.f10062b;
                while (parcel.dataPosition() < iD029) {
                    int i36 = parcel.readInt();
                    if (((char) i36) != 1) {
                        B0.f.z0(parcel, i36);
                    } else {
                        listS2 = B0.f.s(parcel, i36, Location.CREATOR);
                    }
                }
                B0.f.t(parcel, iD029);
                return new LocationResult(listS2);
            default:
                int iD030 = B0.f.D0(parcel);
                boolean zI024 = false;
                boolean zI025 = false;
                ArrayList arrayListS8 = null;
                while (parcel.dataPosition() < iD030) {
                    int i37 = parcel.readInt();
                    char c21 = (char) i37;
                    if (c21 == 1) {
                        arrayListS8 = B0.f.s(parcel, i37, LocationRequest.CREATOR);
                    } else if (c21 == 2) {
                        zI024 = B0.f.i0(parcel, i37);
                    } else if (c21 != 3) {
                        B0.f.z0(parcel, i37);
                    } else {
                        zI025 = B0.f.i0(parcel, i37);
                    }
                }
                B0.f.t(parcel, iD030);
                return new LocationSettingsRequest(arrayListS8, zI024, zI025);
        }
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ Object[] newArray(int i4) {
        switch (this.f9879a) {
            case 0:
                return new zzo[i4];
            case 1:
                return new zzq[i4];
            case 2:
                return new zzs[i4];
            case 3:
                return new zzdb[i4];
            case 4:
                return new zzdd[i4];
            case 5:
                return new zzdf[i4];
            case 6:
                return new zzdh[i4];
            case 7:
                return new zzd[i4];
            case 8:
                return new com.google.android.gms.internal.location.zzg[i4];
            case 9:
                return new LocationSettingsResult[i4];
            case 10:
                return new LocationSettingsStates[i4];
            case 11:
                return new zzac[i4];
            case 12:
                return new SleepClassifyEvent[i4];
            case 13:
                return new SleepSegmentEvent[i4];
            case 14:
                return new SleepSegmentRequest[i4];
            case 15:
                return new zzaj[i4];
            case 16:
                return new zzb[i4];
            case 17:
                return new ActivityRecognitionResult[i4];
            case 18:
                return new ActivityTransition[i4];
            case 19:
                return new ActivityTransitionEvent[i4];
            case 20:
                return new ActivityTransitionRequest[i4];
            case 21:
                return new ActivityTransitionResult[i4];
            case 22:
                return new CurrentLocationRequest[i4];
            case 23:
                return new DetectedActivity[i4];
            case 24:
                return new GeofencingRequest[i4];
            case 25:
                return new LastLocationRequest[i4];
            case 26:
                return new LocationAvailability[i4];
            case 27:
                return new LocationRequest[i4];
            case 28:
                return new LocationResult[i4];
            default:
                return new LocationSettingsRequest[i4];
        }
    }
}
