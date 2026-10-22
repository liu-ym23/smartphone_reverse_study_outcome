package a1;

import B0.f;
import android.accounts.Account;
import android.app.PendingIntent;
import android.database.CursorWindow;
import android.net.Uri;
import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.Feature;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.common.images.WebImage;
import com.google.android.gms.common.internal.BinderWrapper;
import com.google.android.gms.common.internal.ClientIdentity;
import com.google.android.gms.common.internal.ConnectionTelemetryConfiguration;
import com.google.android.gms.common.internal.GetServiceRequest;
import com.google.android.gms.common.internal.MethodInvocation;
import com.google.android.gms.common.internal.RootTelemetryConfiguration;
import com.google.android.gms.common.internal.TelemetryData;
import com.google.android.gms.common.internal.zat;
import com.google.android.gms.common.internal.zav;
import com.google.android.gms.common.internal.zax;
import com.google.android.gms.common.internal.zzaj;
import com.google.android.gms.common.internal.zzj;
import com.google.android.gms.common.moduleinstall.ModuleAvailabilityResponse;
import com.google.android.gms.common.moduleinstall.ModuleInstallIntentResponse;
import com.google.android.gms.common.moduleinstall.ModuleInstallResponse;
import com.google.android.gms.common.moduleinstall.ModuleInstallStatusUpdate;
import com.google.android.gms.common.moduleinstall.internal.ApiFeatureRequest;
import com.google.android.gms.common.server.FavaDiagnosticsEntity;
import com.google.android.gms.common.server.converter.StringToIntConverter;
import com.google.android.gms.common.server.converter.zaa;
import com.google.android.gms.common.server.converter.zac;
import com.google.android.gms.common.server.response.FastJsonResponse$Field;
import com.google.android.gms.common.server.response.SafeParcelResponse;
import com.google.android.gms.common.server.response.zal;
import com.google.android.gms.common.server.response.zam;
import com.google.android.gms.common.server.response.zan;
import com.google.android.gms.common.stats.WakeLockEvent;
import java.util.ArrayList;
import t0.J;

/* renamed from: a1.a, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C0154a implements Parcelable.Creator {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f2265a;

    public /* synthetic */ C0154a(int i4) {
        this.f2265a = i4;
    }

    public static void a(GetServiceRequest getServiceRequest, Parcel parcel, int i4) {
        int iZ = J.Z(parcel, 20293);
        int i5 = getServiceRequest.f9741a;
        J.c0(parcel, 1, 4);
        parcel.writeInt(i5);
        J.c0(parcel, 2, 4);
        parcel.writeInt(getServiceRequest.f9742b);
        J.c0(parcel, 3, 4);
        parcel.writeInt(getServiceRequest.f9743c);
        J.U(parcel, 4, getServiceRequest.f9744d);
        J.R(parcel, 5, getServiceRequest.f9745e);
        J.V(parcel, 6, getServiceRequest.f9746f, i4);
        J.P(parcel, 7, getServiceRequest.f9747g);
        J.T(parcel, 8, getServiceRequest.f9748h, i4);
        J.V(parcel, 10, getServiceRequest.f9749i, i4);
        J.V(parcel, 11, getServiceRequest.f9750j, i4);
        J.c0(parcel, 12, 4);
        parcel.writeInt(getServiceRequest.f9751k ? 1 : 0);
        J.c0(parcel, 13, 4);
        parcel.writeInt(getServiceRequest.f9752l);
        boolean z4 = getServiceRequest.f9753m;
        J.c0(parcel, 14, 4);
        parcel.writeInt(z4 ? 1 : 0);
        J.U(parcel, 15, getServiceRequest.f9754n);
        J.b0(parcel, iZ);
    }

    @Override // android.os.Parcelable.Creator
    public final Object createFromParcel(Parcel parcel) {
        Uri uri = null;
        String strQ = null;
        PendingIntent pendingIntent = null;
        String strQ2 = null;
        String strQ3 = null;
        ArrayList arrayListS = null;
        String strQ4 = null;
        String strQ5 = null;
        ArrayList arrayListS2 = null;
        StringToIntConverter stringToIntConverter = null;
        PendingIntent pendingIntent2 = null;
        ArrayList arrayListS3 = null;
        Bundle bundleK = null;
        Scope[] scopeArr = null;
        Account account = null;
        ArrayList arrayListS4 = null;
        String strQ6 = null;
        int iO0 = 0;
        int iO02 = 0;
        int iO03 = 0;
        int iO04 = 0;
        int iO05 = 0;
        int iO06 = 0;
        int iO07 = 0;
        int iO08 = 0;
        int iO09 = 0;
        int iO010 = 0;
        int iO011 = 0;
        boolean zI0 = false;
        boolean zI02 = false;
        int iO012 = 0;
        int iO013 = 0;
        int iO014 = 0;
        int iO015 = 0;
        int iO016 = 0;
        int iO017 = 0;
        int iO018 = 0;
        switch (this.f2265a) {
            case 0:
                int iD0 = f.D0(parcel);
                String[] strArr = null;
                CursorWindow[] cursorWindowArr = null;
                Bundle bundleK2 = null;
                int iO019 = 0;
                int iO020 = 0;
                while (parcel.dataPosition() < iD0) {
                    int i4 = parcel.readInt();
                    char c4 = (char) i4;
                    if (c4 == 1) {
                        int iQ0 = f.q0(parcel, i4);
                        int iDataPosition = parcel.dataPosition();
                        if (iQ0 == 0) {
                            strArr = null;
                        } else {
                            String[] strArrCreateStringArray = parcel.createStringArray();
                            parcel.setDataPosition(iDataPosition + iQ0);
                            strArr = strArrCreateStringArray;
                        }
                    } else if (c4 == 2) {
                        cursorWindowArr = (CursorWindow[]) f.r(parcel, i4, CursorWindow.CREATOR);
                    } else if (c4 == 3) {
                        iO020 = f.o0(parcel, i4);
                    } else if (c4 == 4) {
                        bundleK2 = f.k(parcel, i4);
                    } else if (c4 != 1000) {
                        f.z0(parcel, i4);
                    } else {
                        iO019 = f.o0(parcel, i4);
                    }
                }
                f.t(parcel, iD0);
                DataHolder dataHolder = new DataHolder(iO019, strArr, cursorWindowArr, iO020, bundleK2);
                dataHolder.f9709c = new Bundle();
                int i5 = 0;
                while (true) {
                    String[] strArr2 = dataHolder.f9708b;
                    if (i5 >= strArr2.length) {
                        CursorWindow[] cursorWindowArr2 = dataHolder.f9710d;
                        dataHolder.f9713g = new int[cursorWindowArr2.length];
                        int numRows = 0;
                        for (int i6 = 0; i6 < cursorWindowArr2.length; i6++) {
                            dataHolder.f9713g[i6] = numRows;
                            numRows += cursorWindowArr2[i6].getNumRows() - (numRows - cursorWindowArr2[i6].getStartPosition());
                        }
                        return dataHolder;
                    }
                    dataHolder.f9709c.putInt(strArr2[i5], i5);
                    i5++;
                }
            case 1:
                int iD02 = f.D0(parcel);
                int iO021 = 0;
                int iO022 = 0;
                while (parcel.dataPosition() < iD02) {
                    int i7 = parcel.readInt();
                    char c5 = (char) i7;
                    if (c5 == 1) {
                        iO018 = f.o0(parcel, i7);
                    } else if (c5 == 2) {
                        uri = (Uri) f.p(parcel, i7, Uri.CREATOR);
                    } else if (c5 == 3) {
                        iO021 = f.o0(parcel, i7);
                    } else if (c5 != 4) {
                        f.z0(parcel, i7);
                    } else {
                        iO022 = f.o0(parcel, i7);
                    }
                }
                f.t(parcel, iD02);
                return new WebImage(iO018, uri, iO021, iO022);
            case 2:
                int iD03 = f.D0(parcel);
                while (parcel.dataPosition() < iD03) {
                    int i8 = parcel.readInt();
                    char c6 = (char) i8;
                    if (c6 == 1) {
                        iO017 = f.o0(parcel, i8);
                    } else if (c6 != 2) {
                        f.z0(parcel, i8);
                    } else {
                        strQ6 = f.q(parcel, i8);
                    }
                }
                f.t(parcel, iD03);
                return new ClientIdentity(iO017, strQ6);
            case 3:
                int iD04 = f.D0(parcel);
                while (parcel.dataPosition() < iD04) {
                    int i9 = parcel.readInt();
                    char c7 = (char) i9;
                    if (c7 == 1) {
                        iO016 = f.o0(parcel, i9);
                    } else if (c7 != 2) {
                        f.z0(parcel, i9);
                    } else {
                        arrayListS4 = f.s(parcel, i9, MethodInvocation.CREATOR);
                    }
                }
                f.t(parcel, iD04);
                return new TelemetryData(iO016, arrayListS4);
            case 4:
                int iD05 = f.D0(parcel);
                long jP0 = 0;
                long jP02 = 0;
                int iO023 = -1;
                String strQ7 = null;
                String strQ8 = null;
                int iO024 = 0;
                int iO025 = 0;
                int iO026 = 0;
                int iO027 = 0;
                while (parcel.dataPosition() < iD05) {
                    int i10 = parcel.readInt();
                    switch ((char) i10) {
                        case 1:
                            iO024 = f.o0(parcel, i10);
                            break;
                        case 2:
                            iO025 = f.o0(parcel, i10);
                            break;
                        case 3:
                            iO026 = f.o0(parcel, i10);
                            break;
                        case 4:
                            jP0 = f.p0(parcel, i10);
                            break;
                        case 5:
                            jP02 = f.p0(parcel, i10);
                            break;
                        case 6:
                            strQ7 = f.q(parcel, i10);
                            break;
                        case 7:
                            strQ8 = f.q(parcel, i10);
                            break;
                        case '\b':
                            iO027 = f.o0(parcel, i10);
                            break;
                        case '\t':
                            iO023 = f.o0(parcel, i10);
                            break;
                        default:
                            f.z0(parcel, i10);
                            break;
                    }
                }
                f.t(parcel, iD05);
                return new MethodInvocation(iO024, iO025, iO026, jP0, jP02, strQ7, strQ8, iO027, iO023);
            case 5:
                int iD06 = f.D0(parcel);
                GoogleSignInAccount googleSignInAccount = null;
                int iO028 = 0;
                while (parcel.dataPosition() < iD06) {
                    int i11 = parcel.readInt();
                    char c8 = (char) i11;
                    if (c8 == 1) {
                        iO015 = f.o0(parcel, i11);
                    } else if (c8 == 2) {
                        account = (Account) f.p(parcel, i11, Account.CREATOR);
                    } else if (c8 == 3) {
                        iO028 = f.o0(parcel, i11);
                    } else if (c8 != 4) {
                        f.z0(parcel, i11);
                    } else {
                        googleSignInAccount = (GoogleSignInAccount) f.p(parcel, i11, GoogleSignInAccount.CREATOR);
                    }
                }
                f.t(parcel, iD06);
                return new zat(iO015, account, iO028, googleSignInAccount);
            case 6:
                int iD07 = f.D0(parcel);
                IBinder iBinderN0 = null;
                ConnectionResult connectionResult = null;
                int iO029 = 0;
                boolean zI03 = false;
                boolean zI04 = false;
                while (parcel.dataPosition() < iD07) {
                    int i12 = parcel.readInt();
                    char c9 = (char) i12;
                    if (c9 == 1) {
                        iO029 = f.o0(parcel, i12);
                    } else if (c9 == 2) {
                        iBinderN0 = f.n0(parcel, i12);
                    } else if (c9 == 3) {
                        connectionResult = (ConnectionResult) f.p(parcel, i12, ConnectionResult.CREATOR);
                    } else if (c9 == 4) {
                        zI03 = f.i0(parcel, i12);
                    } else if (c9 != 5) {
                        f.z0(parcel, i12);
                    } else {
                        zI04 = f.i0(parcel, i12);
                    }
                }
                f.t(parcel, iD07);
                return new zav(iO029, iBinderN0, connectionResult, zI03, zI04);
            case 7:
                int iD08 = f.D0(parcel);
                int iO030 = 0;
                int iO031 = 0;
                while (parcel.dataPosition() < iD08) {
                    int i13 = parcel.readInt();
                    char c10 = (char) i13;
                    if (c10 == 1) {
                        iO014 = f.o0(parcel, i13);
                    } else if (c10 == 2) {
                        iO030 = f.o0(parcel, i13);
                    } else if (c10 == 3) {
                        iO031 = f.o0(parcel, i13);
                    } else if (c10 != 4) {
                        f.z0(parcel, i13);
                    } else {
                        scopeArr = (Scope[]) f.r(parcel, i13, Scope.CREATOR);
                    }
                }
                f.t(parcel, iD08);
                return new zax(iO014, iO030, iO031, scopeArr);
            case 8:
                int iD09 = f.D0(parcel);
                int iO032 = 0;
                int iO033 = 0;
                int iO034 = 0;
                boolean zI05 = false;
                boolean zI06 = false;
                while (parcel.dataPosition() < iD09) {
                    int i14 = parcel.readInt();
                    char c11 = (char) i14;
                    if (c11 == 1) {
                        iO032 = f.o0(parcel, i14);
                    } else if (c11 == 2) {
                        zI05 = f.i0(parcel, i14);
                    } else if (c11 == 3) {
                        zI06 = f.i0(parcel, i14);
                    } else if (c11 == 4) {
                        iO033 = f.o0(parcel, i14);
                    } else if (c11 != 5) {
                        f.z0(parcel, i14);
                    } else {
                        iO034 = f.o0(parcel, i14);
                    }
                }
                f.t(parcel, iD09);
                return new RootTelemetryConfiguration(iO032, iO033, iO034, zI05, zI06);
            case 9:
                int iD010 = f.D0(parcel);
                while (parcel.dataPosition() < iD010) {
                    int i15 = parcel.readInt();
                    if (((char) i15) != 1) {
                        f.z0(parcel, i15);
                    } else {
                        iO013 = f.o0(parcel, i15);
                    }
                }
                f.t(parcel, iD010);
                return new zzaj(iO013);
            case 10:
                BinderWrapper binderWrapper = new BinderWrapper();
                binderWrapper.f9730a = parcel.readStrongBinder();
                return binderWrapper;
            case 11:
                int iD011 = f.D0(parcel);
                Feature[] featureArr = null;
                ConnectionTelemetryConfiguration connectionTelemetryConfiguration = null;
                while (parcel.dataPosition() < iD011) {
                    int i16 = parcel.readInt();
                    char c12 = (char) i16;
                    if (c12 == 1) {
                        bundleK = f.k(parcel, i16);
                    } else if (c12 == 2) {
                        featureArr = (Feature[]) f.r(parcel, i16, Feature.CREATOR);
                    } else if (c12 == 3) {
                        iO012 = f.o0(parcel, i16);
                    } else if (c12 != 4) {
                        f.z0(parcel, i16);
                    } else {
                        connectionTelemetryConfiguration = (ConnectionTelemetryConfiguration) f.p(parcel, i16, ConnectionTelemetryConfiguration.CREATOR);
                    }
                }
                f.t(parcel, iD011);
                zzj zzjVar = new zzj();
                zzjVar.f9872a = bundleK;
                zzjVar.f9873b = featureArr;
                zzjVar.f9874c = iO012;
                zzjVar.f9875d = connectionTelemetryConfiguration;
                return zzjVar;
            case 12:
                int iD012 = f.D0(parcel);
                RootTelemetryConfiguration rootTelemetryConfiguration = null;
                int[] iArrO = null;
                int[] iArrO2 = null;
                boolean zI07 = false;
                boolean zI08 = false;
                int iO035 = 0;
                while (parcel.dataPosition() < iD012) {
                    int i17 = parcel.readInt();
                    switch ((char) i17) {
                        case 1:
                            rootTelemetryConfiguration = (RootTelemetryConfiguration) f.p(parcel, i17, RootTelemetryConfiguration.CREATOR);
                            break;
                        case 2:
                            zI07 = f.i0(parcel, i17);
                            break;
                        case 3:
                            zI08 = f.i0(parcel, i17);
                            break;
                        case 4:
                            iArrO = f.o(parcel, i17);
                            break;
                        case 5:
                            iO035 = f.o0(parcel, i17);
                            break;
                        case 6:
                            iArrO2 = f.o(parcel, i17);
                            break;
                        default:
                            f.z0(parcel, i17);
                            break;
                    }
                }
                f.t(parcel, iD012);
                return new ConnectionTelemetryConfiguration(rootTelemetryConfiguration, zI07, zI08, iArrO, iO035, iArrO2);
            case 13:
                int iD013 = f.D0(parcel);
                Scope[] scopeArr2 = GetServiceRequest.f9739o;
                Bundle bundle = new Bundle();
                Feature[] featureArr2 = GetServiceRequest.f9740p;
                Feature[] featureArr3 = featureArr2;
                String strQ9 = null;
                IBinder iBinderN02 = null;
                Account account2 = null;
                String strQ10 = null;
                int iO036 = 0;
                int iO037 = 0;
                int iO038 = 0;
                boolean zI09 = false;
                int iO039 = 0;
                boolean zI010 = false;
                while (parcel.dataPosition() < iD013) {
                    int i18 = parcel.readInt();
                    switch ((char) i18) {
                        case 1:
                            iO036 = f.o0(parcel, i18);
                            break;
                        case 2:
                            iO037 = f.o0(parcel, i18);
                            break;
                        case 3:
                            iO038 = f.o0(parcel, i18);
                            break;
                        case 4:
                            strQ9 = f.q(parcel, i18);
                            break;
                        case 5:
                            iBinderN02 = f.n0(parcel, i18);
                            break;
                        case 6:
                            scopeArr2 = (Scope[]) f.r(parcel, i18, Scope.CREATOR);
                            break;
                        case 7:
                            bundle = f.k(parcel, i18);
                            break;
                        case '\b':
                            account2 = (Account) f.p(parcel, i18, Account.CREATOR);
                            break;
                        case '\t':
                        default:
                            f.z0(parcel, i18);
                            break;
                        case '\n':
                            featureArr2 = (Feature[]) f.r(parcel, i18, Feature.CREATOR);
                            break;
                        case 11:
                            featureArr3 = (Feature[]) f.r(parcel, i18, Feature.CREATOR);
                            break;
                        case '\f':
                            zI09 = f.i0(parcel, i18);
                            break;
                        case '\r':
                            iO039 = f.o0(parcel, i18);
                            break;
                        case 14:
                            zI010 = f.i0(parcel, i18);
                            break;
                        case 15:
                            strQ10 = f.q(parcel, i18);
                            break;
                    }
                }
                f.t(parcel, iD013);
                return new GetServiceRequest(iO036, iO037, iO038, strQ9, iBinderN02, scopeArr2, bundle, account2, featureArr2, featureArr3, zI09, iO039, zI010, strQ10);
            case 14:
                int iD014 = f.D0(parcel);
                String strQ11 = null;
                String strQ12 = null;
                while (parcel.dataPosition() < iD014) {
                    int i19 = parcel.readInt();
                    char c13 = (char) i19;
                    if (c13 == 1) {
                        arrayListS3 = f.s(parcel, i19, Feature.CREATOR);
                    } else if (c13 == 2) {
                        zI02 = f.i0(parcel, i19);
                    } else if (c13 == 3) {
                        strQ11 = f.q(parcel, i19);
                    } else if (c13 != 4) {
                        f.z0(parcel, i19);
                    } else {
                        strQ12 = f.q(parcel, i19);
                    }
                }
                f.t(parcel, iD014);
                return new ApiFeatureRequest(arrayListS3, zI02, strQ11, strQ12);
            case 15:
                int iD015 = f.D0(parcel);
                int iO040 = 0;
                while (parcel.dataPosition() < iD015) {
                    int i20 = parcel.readInt();
                    char c14 = (char) i20;
                    if (c14 == 1) {
                        zI0 = f.i0(parcel, i20);
                    } else if (c14 != 2) {
                        f.z0(parcel, i20);
                    } else {
                        iO040 = f.o0(parcel, i20);
                    }
                }
                f.t(parcel, iD015);
                return new ModuleAvailabilityResponse(iO040, zI0);
            case 16:
                int iD016 = f.D0(parcel);
                while (parcel.dataPosition() < iD016) {
                    int i21 = parcel.readInt();
                    if (((char) i21) != 1) {
                        f.z0(parcel, i21);
                    } else {
                        pendingIntent2 = (PendingIntent) f.p(parcel, i21, PendingIntent.CREATOR);
                    }
                }
                f.t(parcel, iD016);
                return new ModuleInstallIntentResponse(pendingIntent2);
            case 17:
                int iD017 = f.D0(parcel);
                boolean zI011 = false;
                while (parcel.dataPosition() < iD017) {
                    int i22 = parcel.readInt();
                    char c15 = (char) i22;
                    if (c15 == 1) {
                        iO011 = f.o0(parcel, i22);
                    } else if (c15 != 2) {
                        f.z0(parcel, i22);
                    } else {
                        zI011 = f.i0(parcel, i22);
                    }
                }
                f.t(parcel, iD017);
                return new ModuleInstallResponse(iO011, zI011);
            case 18:
                int iD018 = f.D0(parcel);
                Long lValueOf = null;
                Long lValueOf2 = null;
                int iO041 = 0;
                int iO042 = 0;
                int iO043 = 0;
                while (parcel.dataPosition() < iD018) {
                    int i23 = parcel.readInt();
                    char c16 = (char) i23;
                    if (c16 == 1) {
                        iO041 = f.o0(parcel, i23);
                    } else if (c16 == 2) {
                        iO042 = f.o0(parcel, i23);
                    } else if (c16 == 3) {
                        int iQ02 = f.q0(parcel, i23);
                        if (iQ02 == 0) {
                            lValueOf = null;
                        } else {
                            f.F0(parcel, iQ02, 8);
                            lValueOf = Long.valueOf(parcel.readLong());
                        }
                    } else if (c16 == 4) {
                        int iQ03 = f.q0(parcel, i23);
                        if (iQ03 == 0) {
                            lValueOf2 = null;
                        } else {
                            f.F0(parcel, iQ03, 8);
                            lValueOf2 = Long.valueOf(parcel.readLong());
                        }
                    } else if (c16 != 5) {
                        f.z0(parcel, i23);
                    } else {
                        iO043 = f.o0(parcel, i23);
                    }
                }
                f.t(parcel, iD018);
                return new ModuleInstallStatusUpdate(iO041, iO042, lValueOf, lValueOf2, iO043);
            case 19:
                int iD019 = f.D0(parcel);
                while (parcel.dataPosition() < iD019) {
                    int i24 = parcel.readInt();
                    char c17 = (char) i24;
                    if (c17 == 1) {
                        iO010 = f.o0(parcel, i24);
                    } else if (c17 != 2) {
                        f.z0(parcel, i24);
                    } else {
                        stringToIntConverter = (StringToIntConverter) f.p(parcel, i24, StringToIntConverter.CREATOR);
                    }
                }
                f.t(parcel, iD019);
                return new zaa(iO010, stringToIntConverter);
            case 20:
                int iD020 = f.D0(parcel);
                while (parcel.dataPosition() < iD020) {
                    int i25 = parcel.readInt();
                    char c18 = (char) i25;
                    if (c18 == 1) {
                        iO09 = f.o0(parcel, i25);
                    } else if (c18 != 2) {
                        f.z0(parcel, i25);
                    } else {
                        arrayListS2 = f.s(parcel, i25, zac.CREATOR);
                    }
                }
                f.t(parcel, iD020);
                return new StringToIntConverter(arrayListS2, iO09);
            case 21:
                int iD021 = f.D0(parcel);
                int iO044 = 0;
                while (parcel.dataPosition() < iD021) {
                    int i26 = parcel.readInt();
                    char c19 = (char) i26;
                    if (c19 == 1) {
                        iO08 = f.o0(parcel, i26);
                    } else if (c19 == 2) {
                        strQ5 = f.q(parcel, i26);
                    } else if (c19 != 3) {
                        f.z0(parcel, i26);
                    } else {
                        iO044 = f.o0(parcel, i26);
                    }
                }
                f.t(parcel, iD021);
                return new zac(iO08, iO044, strQ5);
            case 22:
                int iD022 = f.D0(parcel);
                FastJsonResponse$Field fastJsonResponse$Field = null;
                while (parcel.dataPosition() < iD022) {
                    int i27 = parcel.readInt();
                    char c20 = (char) i27;
                    if (c20 == 1) {
                        iO07 = f.o0(parcel, i27);
                    } else if (c20 == 2) {
                        strQ4 = f.q(parcel, i27);
                    } else if (c20 != 3) {
                        f.z0(parcel, i27);
                    } else {
                        fastJsonResponse$Field = (FastJsonResponse$Field) f.p(parcel, i27, FastJsonResponse$Field.CREATOR);
                    }
                }
                f.t(parcel, iD022);
                return new zam(iO07, strQ4, fastJsonResponse$Field);
            case 23:
                int iD023 = f.D0(parcel);
                String strQ13 = null;
                while (parcel.dataPosition() < iD023) {
                    int i28 = parcel.readInt();
                    char c21 = (char) i28;
                    if (c21 == 1) {
                        iO06 = f.o0(parcel, i28);
                    } else if (c21 == 2) {
                        arrayListS = f.s(parcel, i28, zal.CREATOR);
                    } else if (c21 != 3) {
                        f.z0(parcel, i28);
                    } else {
                        strQ13 = f.q(parcel, i28);
                    }
                }
                f.t(parcel, iD023);
                return new zan(iO06, strQ13, arrayListS);
            case 24:
                int iD024 = f.D0(parcel);
                ArrayList arrayListS5 = null;
                while (parcel.dataPosition() < iD024) {
                    int i29 = parcel.readInt();
                    char c22 = (char) i29;
                    if (c22 == 1) {
                        iO05 = f.o0(parcel, i29);
                    } else if (c22 == 2) {
                        strQ3 = f.q(parcel, i29);
                    } else if (c22 != 3) {
                        f.z0(parcel, i29);
                    } else {
                        arrayListS5 = f.s(parcel, i29, zam.CREATOR);
                    }
                }
                f.t(parcel, iD024);
                return new zal(iO05, strQ3, arrayListS5);
            case 25:
                int iD025 = f.D0(parcel);
                Parcel parcel2 = null;
                zan zanVar = null;
                while (parcel.dataPosition() < iD025) {
                    int i30 = parcel.readInt();
                    char c23 = (char) i30;
                    if (c23 == 1) {
                        iO04 = f.o0(parcel, i30);
                    } else if (c23 == 2) {
                        int iQ04 = f.q0(parcel, i30);
                        int iDataPosition2 = parcel.dataPosition();
                        if (iQ04 == 0) {
                            parcel2 = null;
                        } else {
                            Parcel parcelObtain = Parcel.obtain();
                            parcelObtain.appendFrom(parcel, iDataPosition2, iQ04);
                            parcel.setDataPosition(iDataPosition2 + iQ04);
                            parcel2 = parcelObtain;
                        }
                    } else if (c23 != 3) {
                        f.z0(parcel, i30);
                    } else {
                        zanVar = (zan) f.p(parcel, i30, zan.CREATOR);
                    }
                }
                f.t(parcel, iD025);
                return new SafeParcelResponse(iO04, parcel2, zanVar);
            case 26:
                int iD026 = f.D0(parcel);
                int iO045 = 0;
                while (parcel.dataPosition() < iD026) {
                    int i31 = parcel.readInt();
                    char c24 = (char) i31;
                    if (c24 == 1) {
                        iO03 = f.o0(parcel, i31);
                    } else if (c24 == 2) {
                        strQ2 = f.q(parcel, i31);
                    } else if (c24 != 3) {
                        f.z0(parcel, i31);
                    } else {
                        iO045 = f.o0(parcel, i31);
                    }
                }
                f.t(parcel, iD026);
                return new FavaDiagnosticsEntity(iO03, iO045, strQ2);
            case 27:
                int iD027 = f.D0(parcel);
                long jP03 = 0;
                long jP04 = 0;
                long jP05 = 0;
                float fL0 = 0.0f;
                String strQ14 = null;
                ArrayList<String> arrayList = null;
                String strQ15 = null;
                String strQ16 = null;
                String strQ17 = null;
                String strQ18 = null;
                int iO046 = 0;
                int iO047 = 0;
                int iO048 = 0;
                int iO049 = 0;
                boolean zI012 = false;
                while (parcel.dataPosition() < iD027) {
                    int i32 = parcel.readInt();
                    switch ((char) i32) {
                        case 1:
                            iO046 = f.o0(parcel, i32);
                            break;
                        case 2:
                            jP03 = f.p0(parcel, i32);
                            break;
                        case 3:
                        case 7:
                        case '\t':
                        default:
                            f.z0(parcel, i32);
                            break;
                        case 4:
                            strQ14 = f.q(parcel, i32);
                            break;
                        case 5:
                            iO048 = f.o0(parcel, i32);
                            break;
                        case 6:
                            int iQ05 = f.q0(parcel, i32);
                            int iDataPosition3 = parcel.dataPosition();
                            if (iQ05 == 0) {
                                arrayList = null;
                                break;
                            } else {
                                ArrayList<String> arrayListCreateStringArrayList = parcel.createStringArrayList();
                                parcel.setDataPosition(iDataPosition3 + iQ05);
                                arrayList = arrayListCreateStringArrayList;
                                break;
                            }
                        case '\b':
                            jP04 = f.p0(parcel, i32);
                            break;
                        case '\n':
                            strQ16 = f.q(parcel, i32);
                            break;
                        case 11:
                            iO047 = f.o0(parcel, i32);
                            break;
                        case '\f':
                            strQ15 = f.q(parcel, i32);
                            break;
                        case '\r':
                            strQ17 = f.q(parcel, i32);
                            break;
                        case 14:
                            iO049 = f.o0(parcel, i32);
                            break;
                        case 15:
                            fL0 = f.l0(parcel, i32);
                            break;
                        case 16:
                            jP05 = f.p0(parcel, i32);
                            break;
                        case 17:
                            strQ18 = f.q(parcel, i32);
                            break;
                        case 18:
                            zI012 = f.i0(parcel, i32);
                            break;
                    }
                }
                f.t(parcel, iD027);
                return new WakeLockEvent(iO046, jP03, iO047, strQ14, iO048, arrayList, strQ15, jP04, iO049, strQ16, strQ17, fL0, jP05, strQ18, zI012);
            case 28:
                int iD028 = f.D0(parcel);
                String strQ19 = null;
                int iO050 = 0;
                while (parcel.dataPosition() < iD028) {
                    int i33 = parcel.readInt();
                    char c25 = (char) i33;
                    if (c25 == 1) {
                        iO02 = f.o0(parcel, i33);
                    } else if (c25 == 2) {
                        iO050 = f.o0(parcel, i33);
                    } else if (c25 == 3) {
                        pendingIntent = (PendingIntent) f.p(parcel, i33, PendingIntent.CREATOR);
                    } else if (c25 != 4) {
                        f.z0(parcel, i33);
                    } else {
                        strQ19 = f.q(parcel, i33);
                    }
                }
                f.t(parcel, iD028);
                return new ConnectionResult(strQ19, pendingIntent, iO02, iO050);
            default:
                int iD029 = f.D0(parcel);
                long jP06 = -1;
                while (parcel.dataPosition() < iD029) {
                    int i34 = parcel.readInt();
                    char c26 = (char) i34;
                    if (c26 == 1) {
                        strQ = f.q(parcel, i34);
                    } else if (c26 == 2) {
                        iO0 = f.o0(parcel, i34);
                    } else if (c26 != 3) {
                        f.z0(parcel, i34);
                    } else {
                        jP06 = f.p0(parcel, i34);
                    }
                }
                f.t(parcel, iD029);
                return new Feature(strQ, iO0, jP06);
        }
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ Object[] newArray(int i4) {
        switch (this.f2265a) {
            case 0:
                return new DataHolder[i4];
            case 1:
                return new WebImage[i4];
            case 2:
                return new ClientIdentity[i4];
            case 3:
                return new TelemetryData[i4];
            case 4:
                return new MethodInvocation[i4];
            case 5:
                return new zat[i4];
            case 6:
                return new zav[i4];
            case 7:
                return new zax[i4];
            case 8:
                return new RootTelemetryConfiguration[i4];
            case 9:
                return new zzaj[i4];
            case 10:
                return new BinderWrapper[i4];
            case 11:
                return new zzj[i4];
            case 12:
                return new ConnectionTelemetryConfiguration[i4];
            case 13:
                return new GetServiceRequest[i4];
            case 14:
                return new ApiFeatureRequest[i4];
            case 15:
                return new ModuleAvailabilityResponse[i4];
            case 16:
                return new ModuleInstallIntentResponse[i4];
            case 17:
                return new ModuleInstallResponse[i4];
            case 18:
                return new ModuleInstallStatusUpdate[i4];
            case 19:
                return new zaa[i4];
            case 20:
                return new StringToIntConverter[i4];
            case 21:
                return new zac[i4];
            case 22:
                return new zam[i4];
            case 23:
                return new zan[i4];
            case 24:
                return new zal[i4];
            case 25:
                return new SafeParcelResponse[i4];
            case 26:
                return new FavaDiagnosticsEntity[i4];
            case 27:
                return new WakeLockEvent[i4];
            case 28:
                return new ConnectionResult[i4];
            default:
                return new Feature[i4];
        }
    }
}
